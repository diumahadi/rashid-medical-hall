package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.PSTitle;
import medicine.model.User;
import medicine.service.FormOperation;
import medicine.util.DbUtil;

public class PSTitleDao implements FormOperation<PSTitle>{

    private final Connection connection;
    
    public PSTitleDao(){
        connection=DbUtil.getConnection();
    }
    
    @Override
    public boolean save(PSTitle data) {
        try {
            String sql = "INSERT INTO ps_title (title_name,display,created_by) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getTitle());
            ps.setInt(2, data.getDisplay());
            ps.setInt(3, data.getUser().getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("PSTitleDao:Insert:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(PSTitle data) {
        try {
            String sql = "UPDATE ps_title SET title_name=?,display=?,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getTitle());
            ps.setInt(2, data.getDisplay());
            ps.setInt(3, data.getUser().getUserId());
            ps.setInt(4, data.getPsId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("PSTitleDao:Update:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(PSTitle data) {
        try {
            String sql = "DELETE FROM ps_title WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, data.getPsId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("PSTitleDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public PSTitle find(String id) {
        PSTitle data = new PSTitle();
        try {
            String sql = "SELECT * FROM ps_title WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setPsId(rs.getInt("id"));
                data.setTitle(rs.getString("title_name"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
            }
        } catch (SQLException e) {
            System.out.println("PSTitleDao:Find:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<PSTitle> display() {
        List<PSTitle> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ps_title ORDER BY title_name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PSTitle data = new PSTitle();
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setPsId(rs.getInt("id"));
                data.setTitle(rs.getString("title_name"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("PSTitleDao:Display:SQL Error........." + e);
        }
        return list;
    }
    
}
