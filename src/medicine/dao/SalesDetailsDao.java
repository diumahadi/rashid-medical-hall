package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import medicine.model.Medicine;
import medicine.model.SalesDetails;
import medicine.model.SalesMaster;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class SalesDetailsDao implements BaseDao<SalesDetails> {

    private final Connection connection;

    public SalesDetailsDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public SalesDetails save(SalesDetails data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SalesDetails update(SalesDetails data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SalesDetails save(SalesDetails data, SalesMaster mas, Connection conn) throws SQLException {
        String sql = "INSERT INTO sales_details (sales_id,medicine_id,quantity,percentage,purchase_price,sales_price,expiracy_date) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, mas.getSalesId());
        ps.setInt(2, data.getMedicine().getMedicineId());
        ps.setInt(3, data.getQuantity());
        ps.setDouble(4, data.getPercentage());
        ps.setDouble(5, data.getPurchasePrice());
        ps.setDouble(6, data.getSalesPrice());
        ps.setDate(7, new java.sql.Date(data.getExpiracyDate().getTime()));
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs != null && rs.next()) {
            data = find(String.valueOf(rs.getLong(1)));
        }
        return data;
    }

    public SalesDetails update(SalesDetails data,Connection conn) throws SQLException {
        String sql = "UPDATE sales_details SET sales_id=?,medicine_id=?,quantity=?,percentage=?,purchase_price=?,sales_price=?,expiracy_date=? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, data.getSalesMaster().getSalesId());
        ps.setInt(2, data.getMedicine().getMedicineId());
        ps.setInt(3, data.getQuantity());
        ps.setDouble(4, data.getPercentage());
        ps.setDouble(5, data.getPurchasePrice());
        ps.setDouble(6, data.getSalesPrice());
        ps.setDate(7, new java.sql.Date(data.getExpiracyDate().getTime()));
        ps.setLong(8, data.getDetailsId());
        ps.executeUpdate();
        data = find(String.valueOf(data.getDetailsId()));
        return data;
    }

    @Override
    public boolean delete(SalesDetails data) {
        try {
            String sql = "DELETE FROM sales_details WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getDetailsId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SalesDetailsDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }
    
    public boolean delete(SalesDetails data,Connection conn) {
        try {
            String sql = "DELETE FROM sales_details WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, data.getDetailsId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SalesDetailsDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public SalesDetails find(String id) {
        SalesDetails data = new SalesDetails();
        try {
            String sql = "SELECT * FROM sales_details WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setDetailsId(rs.getLong("id"));
                data.setExpiracyDate(rs.getDate("expiracy_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf("medicine_id"));
                data.setMedicine(medicine);
                data.setPurchasePrice(rs.getDouble("purchase_price"));
                data.setQuantity(rs.getInt("quantity"));
                data.setPercentage(rs.getDouble("percentage"));
                SalesMasterDao masterDao = new SalesMasterDao();
                SalesMaster master = masterDao.find(String.valueOf(rs.getLong("sales_id")));
                data.setSalesMaster(master);
                data.setSalesPrice(rs.getDouble("sales_price"));
            }
        } catch (SQLException e) {
            System.out.println("SalesDetailsDao:Find:SQL Error........." + e);
        }
        return data;
    }

    public List<SalesDetails> find(SalesMaster master) {
        List<SalesDetails> list = new ArrayList<>();
        try {

            String sql = "SELECT * FROM sales_details WHERE sales_id= ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, master.getSalesId());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                SalesDetails data = new SalesDetails();
                data.setDetailsId(rs.getLong("id"));
                data.setExpiracyDate(rs.getDate("expiracy_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                data.setPurchasePrice(rs.getDouble("purchase_price"));
                data.setQuantity(rs.getInt("quantity"));
                data.setPercentage(rs.getDouble("percentage"));
                data.setSalesMaster(master);
                data.setSalesPrice(rs.getDouble("sales_price"));
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error........." + e);
        }

        Collections.sort(list, new Comparator<SalesDetails>() {
            @Override
            public int compare(SalesDetails d1, SalesDetails d2) {
                return d1.getMedicine().getMedicineName().compareToIgnoreCase(d2.getMedicine().getMedicineName());
            }
        });
        return list;
    }

    @Override
    public List<SalesDetails> display() {
        List<SalesDetails> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM sales_details ORDER BY id";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                SalesDetails data = new SalesDetails();
                data.setDetailsId(rs.getLong("id"));
                data.setExpiracyDate(rs.getDate("expiracy_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf("medicine_id"));
                data.setMedicine(medicine);
                data.setPurchasePrice(rs.getDouble("purchase_price"));
                data.setQuantity(rs.getInt("quantity"));
                data.setPercentage(rs.getDouble("percentage"));
                SalesMasterDao masterDao = new SalesMasterDao();
                SalesMaster master = masterDao.find(String.valueOf(rs.getLong("sales_id")));
                data.setSalesMaster(master);
                data.setSalesPrice(rs.getDouble("sales_price"));
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("SalesDetailsDao:Display:SQL Error........." + e);
        }
        return list;
    }

}
