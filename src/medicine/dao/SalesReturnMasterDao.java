package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.Client;
import medicine.model.SalesReturnMaster;
import medicine.model.User;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class SalesReturnMasterDao implements BaseDao <SalesReturnMaster>{

    public final Connection connection;
    
    public SalesReturnMasterDao(){
        connection=DbUtil.getConnection();
    }
    
    @Override
    public SalesReturnMaster save(SalesReturnMaster data) {
        try {
            String sql = "INSERT INTO sales_return_master (client_id,return_date,created_by) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (data.getClient() != null) {
                ps.setLong(1, data.getClient().getClientId());
            } else {
                ps.setNull(1, java.sql.Types.LONGNVARCHAR);
            }
            ps.setDate(2, new java.sql.Date(data.getReturnDate().getTime()));
            ps.setInt(3, data.getUser().getUserId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                data = find(String.valueOf(rs.getLong(1)));
            }
        } catch (SQLException e) {
            System.out.println("SalesReturnMasterDao:Insert:SQL Error........." + e);

        }
        return data;
    }

    @Override
    public SalesReturnMaster update(SalesReturnMaster data) {
       try {
            String sql = "UPDATE sales_return_master SET client_id=?,return_date=?,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            if (data.getClient() != null) {
                ps.setLong(1, data.getClient().getClientId());
            } else {
                ps.setNull(1, java.sql.Types.LONGNVARCHAR);
            }
            ps.setDate(2, new java.sql.Date(data.getReturnDate().getTime()));
            ps.setInt(3, data.getUser().getUserId());
            ps.setLong(4, data.getReturnId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SalesReturnMasterDao:Update:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public boolean delete(SalesReturnMaster data) {
        try {
            String sql = "DELETE FROM sales_return_master WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getReturnId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SalesReturnMasterDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public SalesReturnMaster find(String id) {
        SalesReturnMaster data = new SalesReturnMaster();
        try {
            String sql = "SELECT * FROM sales_return_master WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                data.setClient(client);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setReturnDate(rs.getDate("return_date"));
                data.setReturnId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
            }
        } catch (SQLException e) {
            System.out.println("SalesReturnMasterDao:Find:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<SalesReturnMaster> display() {
        List<SalesReturnMaster> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM sales_return_master ORDER BY return_date DESC";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                SalesReturnMaster data = new SalesReturnMaster();
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                data.setClient(client);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setReturnDate(rs.getDate("return_date"));
                data.setReturnId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("SalesReturnMasterDao:Display:SQL Error........." + e);
        }
        return list;
    }
    
}
