package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import medicine.model.Medicine;
import medicine.model.PurchaseReturnDetails;
import medicine.model.PurchaseReturnTaken;
import medicine.model.User;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class PurchaseReturnTakenDao implements BaseDao<PurchaseReturnTaken> {
    
    private final Connection connection;
    private StockDao stockDao;
    private PurchaseReturnDeatilsDao returnDeatilsDao;
    
    public PurchaseReturnTakenDao() {
        connection = DbUtil.getConnection();
    }
    
    @Override
    public PurchaseReturnTaken save(PurchaseReturnTaken data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PurchaseReturnTaken update(PurchaseReturnTaken data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public PurchaseReturnTaken save(PurchaseReturnTaken data,PurchaseReturnDetails det,Connection conn) {     
        try {
            String sql = "INSERT INTO purchase_return_taken (deatil_id,quantity,submit_date,created_by) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, data.getReturnDetails().getDetailId());
            ps.setInt(2, data.getQuantity());
            ps.setDate(3, new java.sql.Date(data.getTakenDate().getTime()));
            ps.setInt(4, data.getUser().getUserId());
            ps.executeUpdate();                    
            
        } catch (SQLException e) {
            throw new Error("PurchaseReturnDetailsDao:Update:SQL Error........." + e);
        }
        return data;
    }
    
    public PurchaseReturnTaken update(PurchaseReturnTaken data,PurchaseReturnDetails det,Connection conn) {
        try {
            String sql = "UPDATE purchase_return_taken SET deatil_id=?,quantity=?,submit_date=?,created_by=? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, data.getReturnDetails().getDetailId());
            ps.setInt(2, data.getQuantity());
            ps.setDate(3, new java.sql.Date(data.getTakenDate().getTime()));
            ps.setInt(4, data.getUser().getUserId());
            ps.setLong(5, data.getTakenId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Error("PurchaseReturnDetailsDao:Update:SQL Error........." + e);
        }
        return data;
    }
    
    @Override
    public boolean delete(PurchaseReturnTaken data) {
        try {
            String sql = "DELETE FROM purchase_return_taken WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getTakenId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("PurchaseReturnTakenDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }
    
    public boolean deleteUnderDetails(PurchaseReturnDetails det,Connection conn) {
        try {
            String sql = "DELETE FROM purchase_return_taken WHERE deatil_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, det.getDetailId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Error("PurchaseReturnTakenDao:deleteUnderDetails:SQL Error........." + e);
        }
        return true;
    }
    
    @Override
    public PurchaseReturnTaken find(String id) {
        PurchaseReturnTaken data = new PurchaseReturnTaken();
        try {
            String sql = "SELECT * FROM purchase_return_taken WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setQuantity(rs.getInt("quantity"));
                PurchaseReturnDeatilsDao detailsDao = new PurchaseReturnDeatilsDao();
                data.setReturnDetails(detailsDao.findSingleResult(String.valueOf(rs.getLong("deatil_id"))));
                data.setTakenDate(rs.getDate("submit_date"));
                data.setTakenId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
            }
        } catch (SQLException e) {
            System.out.println("PSTitleDao:Find:SQL Error........." + e);
        }
        return data;
    }
    
    public List<PurchaseReturnTaken> childUnderSingleDetail(PurchaseReturnDetails det) {
        List<PurchaseReturnTaken> list = new ArrayList<>();
        try {

            String sql = "SELECT * FROM purchase_return_taken WHERE deatil_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, det.getDetailId());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PurchaseReturnTaken data = new PurchaseReturnTaken();
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setQuantity(rs.getInt("quantity"));
                PurchaseReturnDeatilsDao detailsDao = new PurchaseReturnDeatilsDao();
                data.setReturnDetails(detailsDao.findSingleResult(String.valueOf(rs.getLong("deatil_id"))));
                data.setTakenDate(rs.getDate("submit_date"));
                data.setTakenId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            throw new Error("PurchaseReturnTakenDao:childUnderSingleDetail:SQL Error........." + e);
        }

       
        return list;
    }
    
    @Override
    public List<PurchaseReturnTaken> display() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
    
}
