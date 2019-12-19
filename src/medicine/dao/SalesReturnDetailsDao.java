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
import medicine.model.SalesReturnDetails;
import medicine.model.SalesReturnMaster;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class SalesReturnDetailsDao implements BaseDao<SalesReturnDetails>{

    private final Connection connection;

    public SalesReturnDetailsDao() {
        connection = DbUtil.getConnection();
    }
    
    @Override
    public SalesReturnDetails save(SalesReturnDetails data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean save(SalesReturnDetails data,Connection conn) {        
        try {
            String sql = "INSERT INTO sales_return_details (return_id,medicine_id,return_quantity,submit_amount) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, data.getSalesReturnMaster().getReturnId());
            ps.setInt(2, data.getMedicine().getMedicineId());
            ps.setInt(3, data.getReturnQuantity());
            ps.setDouble(4, data.getSubmitAmount());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SalesReturnDetailsDao:Insert:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public SalesReturnDetails update(SalesReturnDetails data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean update(SalesReturnDetails data,Connection conn) {
        try {
            String sql = "UPDATE sales_return_details SET return_id=?,medicine_id=?,return_quantity=?,submit_amount=? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, data.getSalesReturnMaster().getReturnId());
            ps.setInt(2, data.getMedicine().getMedicineId());
            ps.setInt(3, data.getReturnQuantity());
            ps.setDouble(4, data.getSubmitAmount());
            ps.setLong(5, data.getDetailId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SalesReturnDetailsDao:Update:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(SalesReturnDetails data) {
        try {
            String sql = "DELETE FROM sales_return_details WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getDetailId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SalesReturnDetailsDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public SalesReturnDetails find(String id) {
        SalesReturnDetails data = new SalesReturnDetails();
        try {
            String sql = "SELECT * FROM sales_return_details WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setDetailId(rs.getLong("id"));
                data.setSubmitDate(rs.getTimestamp("submit_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                SalesReturnMasterDao masterDao = new SalesReturnMasterDao();
                SalesReturnMaster master = masterDao.find(String.valueOf(rs.getLong("return_id")));
                data.setSalesReturnMaster(master);
                data.setReturnQuantity(rs.getInt("return_quantity"));
                data.setSubmitAmount(rs.getDouble("submit_amount"));
            }
        } catch (SQLException e) {
            System.out.println("SalesReturnDetailsDao:Find:SQL Error........." + e);
        }
        return data;
    }

    public List<SalesReturnDetails> find(long RETURN_ID) {
        List<SalesReturnDetails> list = new ArrayList<>();
        try {
            
            String sql="SELECT * FROM sales_return_details WHERE return_id = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, RETURN_ID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                SalesReturnDetails data = new SalesReturnDetails();
                data.setDetailId(rs.getLong("id"));
                data.setSubmitDate(rs.getTimestamp("submit_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                SalesReturnMasterDao masterDao = new SalesReturnMasterDao();
                SalesReturnMaster master = masterDao.find(String.valueOf(rs.getLong("return_id")));
                data.setSalesReturnMaster(master);
                data.setReturnQuantity(rs.getInt("return_quantity"));
                data.setSubmitAmount(rs.getDouble("submit_amount"));
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("SalesReturnDetailsDao:Fidn:SQL Error........." + e);
        }

        Collections.sort(list, new Comparator<SalesReturnDetails>() {
            @Override
            public int compare(SalesReturnDetails d1, SalesReturnDetails d2) {
                return d1.getMedicine().getMedicineName().compareToIgnoreCase(d2.getMedicine().getMedicineName());
            }
        });
        return list;
    }
    
    @Override
    public List<SalesReturnDetails> display() {
        List<SalesReturnDetails> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM sales_return_details";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                SalesReturnDetails data = new SalesReturnDetails();
                data.setDetailId(rs.getLong("id"));
                data.setSubmitDate(rs.getTimestamp("submit_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                SalesReturnMasterDao masterDao = new SalesReturnMasterDao();
                SalesReturnMaster master = masterDao.find(String.valueOf(rs.getLong("return_id")));
                data.setSalesReturnMaster(master);
                data.setReturnQuantity(rs.getInt("return_quantity"));
                data.setSubmitAmount(rs.getDouble("submit_amount"));
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("SalesReturnDetailsDao:Display:SQL Error........." + e);
        }
        return list;
    }

    
    
}
