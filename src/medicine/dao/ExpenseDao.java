package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.exception.UncaughtError;
import medicine.model.Expense;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class ExpenseDao implements BaseDao<Expense>{

    private final Connection connection;
    
    public ExpenseDao() {
        connection = DbUtil.getConnection();
    }
    
    @Override
    public Expense save(Expense data) {
        try {
            String sql = "INSERT INTO expense (head_id,amount,expense_date,estatus,created_by) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, data.getExpenseHead().getHeadId());
            ps.setDouble(2, data.getAmount());
            ps.setDate(3, new java.sql.Date(data.getExpenseDate().getTime()));
            ps.setString(4, data.getStatus());
            ps.setInt(5, data.getUser().getUserId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                data = find(String.valueOf(rs.getLong(1)));
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseDao:save:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseDao:save..." + e);
        }
        return data;
    }

    @Override
    public Expense update(Expense data) {
        try {
            String sql = "UPDATE expense SET head_id=?,amount=?,expense_date=?,estatus=?,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, data.getExpenseHead().getHeadId());
            ps.setDouble(2, data.getAmount());
            ps.setDate(3, new java.sql.Date(data.getExpenseDate().getTime()));
            ps.setString(4, data.getStatus());
            ps.setInt(5, data.getUser().getUserId());
            ps.setLong(6, data.getExpenseId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                data = find(String.valueOf(rs.getLong(1)));
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseDao:save:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseDao:save..." + e);
        }
        return data;
    }

    @Override
    public boolean delete(Expense data) {
        try {
            String sql = "DELETE FROM expense WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getExpenseId());
            ps.executeUpdate();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseDao:delete:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseDao:delete..." + e);
        }
        return true;
    }

    @Override
    public Expense find(String id) {
        Expense data = new Expense();
        try {
            String sql = "SELECT * FROM expense WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setAmount(rs.getDouble("amount"));
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setExpenseDate(rs.getDate("expense_date"));                
                ExpenseHeadDao headDao=new ExpenseHeadDao();
                data.setExpenseHead(headDao.find(String.valueOf(rs.getInt("head_id"))));
                data.setExpenseId(rs.getLong("id"));
                data.setStatus(rs.getString("estatus"));                
                UserDao userDao = new UserDao();
                data.setUser(userDao.find(String.valueOf(rs.getInt("created_by"))));
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseDao:find:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseDao:find..." + e);
        }
        return data;
    }
    
    
    
    public List<Expense> getExpensesUnderExpenseHead(Expense exp){
        List<Expense> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM expense WHERE head_id="+exp.getExpenseId()+" ORDER BY id";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Expense data = new Expense();
                data.setAmount(rs.getDouble("amount"));
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setExpenseDate(rs.getDate("expense_date"));                
                ExpenseHeadDao headDao=new ExpenseHeadDao();
                data.setExpenseHead(headDao.find(String.valueOf(rs.getInt("head_id"))));
                data.setExpenseId(rs.getLong("id"));
                data.setStatus(rs.getString("estatus"));                
                UserDao userDao = new UserDao();
                data.setUser(userDao.find(String.valueOf(rs.getInt("created_by"))));
                list.add(data);
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseDao:getExpensesUnderExpenseHead:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseDao:getExpensesUnderExpenseHead..." + e);
        }
        return list;
    }

    @Override
    public List<Expense> display() {
        List<Expense> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM expense ORDER BY id,expense_date";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Expense data = new Expense();
                data.setAmount(rs.getDouble("amount"));
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setExpenseDate(rs.getDate("expense_date"));                
                ExpenseHeadDao headDao=new ExpenseHeadDao();
                data.setExpenseHead(headDao.find(String.valueOf(rs.getInt("head_id"))));
                data.setExpenseId(rs.getLong("id"));
                data.setStatus(rs.getString("estatus"));                
                UserDao userDao = new UserDao();
                data.setUser(userDao.find(String.valueOf(rs.getInt("created_by"))));
                list.add(data);
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:ExpenseDao:display:rollback..." + e1);
            }
            throw new UncaughtError("Error:ExpenseDao:display..." + e);
        }
        return list;
    }
    
}
