package medicine.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.User;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class UserDao implements BaseDao<User> {

    private final Connection connection;

    public UserDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public User save(User data) {
        try {
            String sql = "INSERT INTO user (user_name,password,first_name,last_name,email,image,contact_number,address,group_id,user_level,is_active) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getUserName());
            ps.setString(2, data.getPassword());
            ps.setString(3, data.getFirstName());
            ps.setString(4, data.getLastName());
            ps.setString(5, data.getEmail());
            ps.setString(6, data.getImage());
            ps.setString(7, data.getContactNumber());
            ps.setString(8, data.getAddress());
            ps.setInt(9, data.getGroupId());
            ps.setInt(10, data.getUserLevel());
            ps.setInt(11, data.getIsActive());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                data = find(String.valueOf(rs.getLong(1)));
            }
        } catch (SQLException e) {
            throw new Error("UserDao:Insert:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public User update(User data) {
        try {
            String sql = "UPDATE user SET user_name=?,first_name=?,last_name=?,email=?,image=?,contact_number=?,address=?,group_id=?,user_level=?,is_active=? WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getUserName());
            ps.setString(2, data.getFirstName());
            ps.setString(3, data.getLastName());
            ps.setString(4, data.getEmail());
            ps.setString(5, data.getImage());
            ps.setString(6, data.getContactNumber());
            ps.setString(7, data.getAddress());
            ps.setInt(8, data.getGroupId());
            ps.setInt(9, data.getUserLevel());
            ps.setInt(10, data.getIsActive());
            ps.setInt(11, data.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Error("UserDao:Update:SQL Error........." + e);
        }
        return data;

    }

    @Override
    public boolean delete(User data) {
        try {
            String sql = "DELETE FROM user WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, data.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Error("UserDao:Delete:SQL Error........." + e);
        }
        return true;
    }

    @Override
    public User find(String id) {
        User data = new User();
        try {
            String sql = "SELECT * FROM user WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setAddress(rs.getString("address"));
                data.setContactNumber(rs.getString("contact_number"));
                data.setEmail(rs.getString("email"));
                data.setFirstName(rs.getString("first_name"));
                data.setGroupId(rs.getInt("group_id"));
                data.setImage(rs.getString("image"));
                data.setIsActive(rs.getInt("is_active"));
                data.setLastName(rs.getString("last_name"));
                data.setPassword(rs.getString("password"));
                data.setUserId(rs.getInt("user_id"));
                data.setUserLevel(rs.getInt("user_level"));
                data.setUserName(rs.getString("user_name"));
            }
        } catch (SQLException e) {
            throw new Error("UserDao:Find:SQL Error........." + e);
        }
        return data;
    }

    public User findByUserName(String userName) {
        User data = new User();
        try {
            String sql = "SELECT * FROM user WHERE user_name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setAddress(rs.getString("address"));
                data.setContactNumber(rs.getString("contact_number"));
                data.setEmail(rs.getString("email"));
                data.setFirstName(rs.getString("first_name"));
                data.setGroupId(rs.getInt("group_id"));
                data.setImage(rs.getString("image"));
                data.setIsActive(rs.getInt("is_active"));
                data.setLastName(rs.getString("last_name"));
                data.setPassword(rs.getString("password"));
                data.setUserId(rs.getInt("user_id"));
                data.setUserLevel(rs.getInt("user_level"));
                data.setUserName(rs.getString("user_name"));
            }
        } catch (SQLException e) {
            throw new Error("UserDao:findByUserName:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<User> display() {
        List<User> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user WHERE is_active!=2 ORDER BY first_name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User data = new User();
                data.setAddress(rs.getString("address"));
                data.setContactNumber(rs.getString("contact_number"));
                data.setEmail(rs.getString("email"));
                data.setFirstName(rs.getString("first_name"));
                data.setGroupId(rs.getInt("group_id"));
                data.setImage(rs.getString("image"));
                data.setIsActive(rs.getInt("is_active"));
                data.setLastName(rs.getString("last_name"));
                data.setPassword(rs.getString("password"));
                data.setUserId(rs.getInt("user_id"));
                data.setUserLevel(rs.getInt("user_level"));
                data.setUserName(rs.getString("user_name"));
                list.add(data);
            }
        } catch (SQLException e) {
            throw new Error("UserDao:Display:SQL Error........." + e);
        }
        return list;
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
