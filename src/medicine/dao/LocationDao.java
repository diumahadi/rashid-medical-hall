package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.Location;
import medicine.model.User;
import medicine.service.FormOperation;
import medicine.util.DbUtil;

public class LocationDao implements FormOperation<Location>{
    private final Connection connection;
    
    public LocationDao(){
        connection=DbUtil.getConnection();
    }

    @Override
    public boolean save(Location data) {
        try {
            String sql = "INSERT INTO medicine_location (location_name,display,created_by) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getLocationName());
            ps.setInt(2, data.getDisplay());
            ps.setInt(3, data.getUser().getUserId());           
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("LocationDao:Insert:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Location data) {
        try {
            String sql = "UPDATE medicine_location SET location_name=?,display=?,created_by=? WHERE location_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getLocationName());
            ps.setInt(2, data.getDisplay());
            ps.setInt(3, data.getUser().getUserId());
            ps.setInt(4, data.getLocationId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("LocationDao:Update:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Location data) {
        try {
            String sql = "DELETE FROM medicine_location WHERE location_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, data.getLocationId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("LocationDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public Location find(String id) {
        Location data = new Location();
        try {
            String sql = "SELECT * FROM medicine_location WHERE location_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setLocationName(rs.getString("location_name"));
                data.setLocationId(rs.getInt("location_id"));
                UserDao userDao=new UserDao();
                User user=userDao.find(String.valueOf(rs.getInt("created_by")));                
                data.setUser(user);
            }
        } catch (SQLException e) {
            System.out.println("LocationDao:Find:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<Location> display() {
        List<Location> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medicine_location ORDER BY location_name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Location data = new Location();
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setLocationName(rs.getString("location_name"));
                data.setLocationId(rs.getInt("location_id"));
                UserDao userDao=new UserDao();
                User user=userDao.find(String.valueOf(rs.getInt("created_by")));                
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("LocationDao:Display:SQL Error........." + e);
        }
        return list;
    }
    
}
