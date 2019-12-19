package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.Unit;
import medicine.model.User;
import medicine.service.FormOperation;
import medicine.util.DbUtil;

public class UnitDao implements FormOperation<Unit>{

    private final Connection connection;
    
    public UnitDao(){
        connection=DbUtil.getConnection();
    }
    
    @Override
    public boolean save(Unit data) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO unit (unit_name,display,created_by) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getUnitName());
            ps.setInt(2, data.getDisplay());
            ps.setInt(3, data.getUser().getUserId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("UnitDao:Insert:SQL Error........." + e);
            return false;
        } 
        return true;
    }

    @Override
    public boolean update(Unit data) {
        try {
            String sql = "UPDATE unit SET unit_name=?,display=?,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getUnitName());
            ps.setInt(2, data.getDisplay());
            ps.setInt(3, data.getUser().getUserId());
            ps.setInt(4, data.getUnitId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("UnitDao:Update:SQL Error........." + e);
            return false;
        } 
        return true;
    }

    @Override
    public boolean delete(Unit data) {
        try {
            String sql = "DELETE FROM unit WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, data.getUnitId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("UnitDao:Delete:SQL Error........." + e);
            return false;
        } 
        return true;
    }

    @Override
    public Unit find(String id) {
        Unit data = new Unit();
        try {
            String sql = "SELECT * FROM unit WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setUnitId(rs.getInt("id"));
                data.setUnitName(rs.getString("unit_name"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
            }
        } catch (SQLException e) {
            System.out.println("UnitDao:Find:SQL Error........." + e);
        } 
        return data;
    }

    @Override
    public List<Unit> display() {
        List<Unit> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM unit ORDER BY unit_name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Unit data = new Unit();
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setUnitId(rs.getInt("id"));
                data.setUnitName(rs.getString("unit_name"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("UnitDao:Display:SQL Error........." + e);
        } 
        return list;
    }
    
}
