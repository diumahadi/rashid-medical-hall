package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.exception.UncaughtError;
import medicine.model.ExpenseHead;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class ExpenseHeadDao implements BaseDao<ExpenseHead>{

    private final Connection connection;
    
    public ExpenseHeadDao() {
        connection = DbUtil.getConnection();
    }
    
    @Override
    public ExpenseHead save(ExpenseHead data) {    
        try {
            String sql = "INSERT INTO expense_head (head_name,display,created_by) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getHeadName());
            ps.setInt(2, data.getDisplay());
            ps.setInt(3, data.getUser().getUserId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                data = find(String.valueOf(rs.getLong(1)));
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseHeadDao:save:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseHeadDao:save..." + e);
        }
        return data;
    }

    @Override
    public ExpenseHead update(ExpenseHead data) {
         try {
            String sql = "UPDATE expense_head SET head_name=?,display=?,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getHeadName());
            ps.setInt(2, data.getDisplay());
            ps.setInt(3, data.getUser().getUserId());
            ps.setInt(4, data.getHeadId());
            ps.executeUpdate();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseHeadDao:update:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseHeadDao:update..." + e);
        }
        return data;
    }

    @Override
    public boolean delete(ExpenseHead data) {
        try {
            String sql = "DELETE FROM expense_head WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, data.getHeadId());
            ps.executeUpdate();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseHeadDao:delete:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseHeadDao:delete..." + e);
        }
        return true;
    }

    @Override
    public ExpenseHead find(String id) {
        ExpenseHead data = new ExpenseHead();
        try {
            String sql = "SELECT * FROM expense_head WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setHeadId(rs.getInt("id"));
                data.setHeadName(rs.getString("head_name"));
                UserDao userDao = new UserDao();
                data.setUser(userDao.find(String.valueOf(rs.getInt("created_by"))));
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseHeadDao:find:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseHeadDao:find..." + e);
        }
        return data;
    }
    
    public List<ExpenseHead> getMatch(String match) {
        List<ExpenseHead> list = new ArrayList<>();
        try {
            match = match.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
            
            String sql = "SELECT * FROM expense_head WHERE head_name LIKE ? ESCAPE '!' ORDER BY head_name";            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + match + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ExpenseHead data = new ExpenseHead();
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setHeadId(rs.getInt("id"));
                data.setHeadName(rs.getString("head_name"));
                UserDao userDao = new UserDao();
                data.setUser(userDao.find(String.valueOf(rs.getInt("created_by"))));
                list.add(data);
            }
        } catch (SQLException e) {
            throw new UncaughtError("Error:ExpenseHeadDao:getMatch..." + e);
        }
        return list;
    }

    @Override
    public List<ExpenseHead> display() {
        List<ExpenseHead> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM expense_head ORDER BY head_name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ExpenseHead data = new ExpenseHead();
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                data.setHeadId(rs.getInt("id"));
                data.setHeadName(rs.getString("head_name"));
                UserDao userDao = new UserDao();
                data.setUser(userDao.find(String.valueOf(rs.getInt("created_by"))));
                list.add(data);
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseHeadDao:display:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseHeadDao:display..." + e);
        }
        return list;
    }
    
}
