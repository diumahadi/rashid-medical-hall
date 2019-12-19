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
import medicine.model.PurchaseDetails;
import medicine.model.PurchaseMaster;
import medicine.model.Unit;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class PurchaseDetailsDao implements BaseDao<PurchaseDetails> {

    private final Connection connection;

    public PurchaseDetailsDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public PurchaseDetails save(PurchaseDetails data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PurchaseDetails save(PurchaseDetails data, PurchaseMaster mas, Connection conn) throws SQLException {
        String sql = "INSERT INTO purchase_details (purchase_id,medicine_id,unit_id,quantity,purchase_price,mrp_price,expiracy_date) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, mas.getPurchaseId());
        ps.setInt(2, data.getMedicine().getMedicineId());
        if (data.getUnit() != null) {
            ps.setInt(3, data.getUnit().getUnitId());
        } else {
            ps.setNull(3, java.sql.Types.INTEGER);
        }
        ps.setInt(4, data.getQuantity());
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

    @Override
    public PurchaseDetails update(PurchaseDetails data) {
        try {
            String sql = "UPDATE purchase_details SET purchase_id=?,medicine_id=?,unit_id=?,quantity=?,purchase_price=?,mrp_price=?,expiracy_date=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getPurchaseMaster().getPurchaseId());
            ps.setInt(2, data.getMedicine().getMedicineId());
            if (data.getUnit() != null) {
                ps.setInt(3, data.getUnit().getUnitId());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }
            ps.setInt(4, data.getQuantity());
            ps.setDouble(5, data.getPurchasePrice());
            ps.setDouble(6, data.getSalesPrice());
            ps.setDate(7, new java.sql.Date(data.getExpiracyDate().getTime()));
            ps.setLong(8, data.getDetailsId());
            ps.executeUpdate();
            data = find(String.valueOf(data.getDetailsId()));
        } catch (SQLException e) {
            System.out.println("PurchaseDetailsDao:Update:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public boolean delete(PurchaseDetails data) {
        try {
            String sql = "DELETE FROM purchase_details WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getDetailsId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("PurchaseDetailsDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public PurchaseDetails find(String id) {
        PurchaseDetails data = new PurchaseDetails();
        try {
            String sql = "SELECT * FROM purchase_details WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setDetailsId(rs.getLong("id"));
                data.setExpiracyDate(rs.getDate("expiracy_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                PurchaseMasterDao masterDao = new PurchaseMasterDao();
                PurchaseMaster master = masterDao.find(String.valueOf(rs.getLong("purchase_id")));
                data.setPurchaseMaster(master);
                data.setPurchasePrice(rs.getDouble("purchase_price"));
                data.setQuantity(rs.getInt("quantity"));
                data.setSalesPrice(rs.getDouble("mrp_price"));
                if (rs.getInt("unit_id") != 0) {
                    UnitDao unitDao = new UnitDao();
                    Unit unit = unitDao.find(String.valueOf(rs.getInt("unit_id")));
                    data.setUnit(unit);
                } else {
                    data.setUnit(null);
                }
            }
        } catch (SQLException e) {
            System.out.println("PurchaseDetailsDao:Find:SQL Error........." + e);
        }
        return data;
    }

    public List<PurchaseDetails> find(long purchaseId) {
        List<PurchaseDetails> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM purchase_details WHERE purchase_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, purchaseId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PurchaseDetails data = new PurchaseDetails();
                data.setDetailsId(rs.getLong("id"));
                data.setExpiracyDate(rs.getDate("expiracy_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                PurchaseMasterDao masterDao = new PurchaseMasterDao();
                PurchaseMaster master = masterDao.find(String.valueOf(rs.getLong("purchase_id")));
                data.setPurchaseMaster(master);
                data.setPurchasePrice(rs.getDouble("purchase_price"));
                data.setQuantity(rs.getInt("quantity"));
                data.setSalesPrice(rs.getDouble("mrp_price"));
                if (rs.getInt("unit_id") != 0) {
                    UnitDao unitDao = new UnitDao();
                    Unit unit = unitDao.find(String.valueOf(rs.getInt("unit_id")));
                    data.setUnit(unit);
                } else {
                    data.setUnit(null);
                }

                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error........." + e);
        }

        Collections.sort(list, new Comparator<PurchaseDetails>() {
            @Override
            public int compare(PurchaseDetails d1, PurchaseDetails d2) {
                return d1.getMedicine().getMedicineName().compareToIgnoreCase(d2.getMedicine().getMedicineName());
            }
        });
        return list;
    }

    @Override
    public List<PurchaseDetails> display() {
        List<PurchaseDetails> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM purchase_details";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PurchaseDetails data = new PurchaseDetails();
                data.setDetailsId(rs.getLong("id"));
                data.setExpiracyDate(rs.getDate("expiracy_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                PurchaseMasterDao masterDao = new PurchaseMasterDao();
                PurchaseMaster master = masterDao.find(String.valueOf(rs.getLong("purchase_id")));
                data.setPurchaseMaster(master);
                data.setPurchasePrice(rs.getDouble("purchase_price"));
                data.setQuantity(rs.getInt("quantity"));
                data.setSalesPrice(rs.getDouble("mrp_price"));
                UnitDao unitDao = new UnitDao();
                Unit unit = unitDao.find(String.valueOf(rs.getInt("unit_id")));
                data.setUnit(unit);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("PurchaseDetailsDao:Display:SQL Error........." + e);
        }
        return list;
    }

}
