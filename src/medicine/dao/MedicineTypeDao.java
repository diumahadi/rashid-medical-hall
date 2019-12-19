package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.MedicineType;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class MedicineTypeDao implements BaseDao<MedicineType>{

    private final Connection connection;

    public MedicineTypeDao() {
        connection = DbUtil.getConnection();
    }
    
    
    @Override
    public MedicineType save(MedicineType data) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO medicine_type (name,display,created_by) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getTypeName());
            ps.setInt(2, data.getDisplay());            
            ps.setInt(3, data.getUser().getUserId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:MedicineTypeDao...:Save..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:MedicineTypeDao...:Save...rollback" + e1);
            }

        }
        return data;
    }

    @Override
    public MedicineType update(MedicineType data) {
        try {
            connection.setAutoCommit(false);
            String sql = "UPDATE medicine_type SET name=?,display=?,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getTypeName());
            ps.setInt(2, data.getDisplay());            
            ps.setInt(3, data.getUser().getUserId());
            ps.setInt(4, data.getTypeId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:MedicineTypeDao...:Update..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:MedicineTypeDao...:Update...rollback" + e1);
            }

        }
        return data;
    }

    @Override
    public boolean delete(MedicineType data) {
        try {
            connection.setAutoCommit(false);
            String sql = "DELETE FROM medicine_type WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, data.getTypeId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:MedicineTypeDao...:Delete..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:MedicineTypeDao...:Delete...rollback" + e1);
            }

        }
        return true;
    }

    @Override
    public MedicineType find(String id) {
        MedicineType data = new MedicineType();
        try {
            String sql = "SELECT * FROM medicine_type WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setTypeId(rs.getInt("id"));
                data.setTypeName(rs.getString("name"));                
                UserDao userDao = new UserDao();
                data.setUser(userDao.find(String.valueOf(rs.getInt("created_by"))));
            }
        } catch (SQLException e) {
            System.out.println("MedicineTypeDao:Find:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<MedicineType> display() {
       List<MedicineType> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medicine_type ORDER BY name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                MedicineType data = new MedicineType();
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setTypeId(rs.getInt("id"));
                data.setTypeName(rs.getString("name"));                
                UserDao userDao = new UserDao();
                data.setUser(userDao.find(String.valueOf(rs.getInt("created_by"))));
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("MedicineTypeDao:Display:SQL Error........." + e);
        }
        return list;
    }
    
}
