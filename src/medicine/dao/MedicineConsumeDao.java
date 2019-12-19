package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.exception.UncaughtError;
import medicine.model.MedicineConsume;
import medicine.model.Stock;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class MedicineConsumeDao implements BaseDao<MedicineConsume> {

    private final Connection connection;
    private StockDao stockDao;

    public MedicineConsumeDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public MedicineConsume save(MedicineConsume data) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO medicine_consume (medicine_id,consume_date,reason,quantity,price,created_by) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, data.getMedicine().getMedicineId());
            ps.setDate(2, new java.sql.Date(data.getConsumeDate().getTime()));
            ps.setString(3, data.getReason());
            ps.setInt(4, data.getQuantity());
            ps.setDouble(5, data.getPrice());
            ps.setInt(6, data.getUser().getUserId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                data = find(String.valueOf(rs.getLong(1)));
                stockDao = new StockDao();
                Stock stock = stockDao.find(data.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() - data.getQuantity());
                stockDao.update(stock,data.getMedicine(),connection);
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:MedicineConsumeDao:save:rollback..." + e1);
            }
            throw new UncaughtError("Error:MedicineConsumeDao:save..." + e);
        }
        return data;
    }

    @Override
    public MedicineConsume update(MedicineConsume data) {
        try {
            connection.setAutoCommit(false);
            MedicineConsumeDao consumeDao=new MedicineConsumeDao();
            MedicineConsume oldrecord = consumeDao.find(String.valueOf(data.getConsumeId()));
            
            String sql = "UPDATE medicine_consume SET medicine_id=?,consume_date=?,reason=?,quantity=?,price=?,created_by=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, data.getMedicine().getMedicineId());
            ps.setDate(2, new java.sql.Date(data.getConsumeDate().getTime()));
            ps.setString(3, data.getReason());
            ps.setInt(4, data.getQuantity());
            ps.setDouble(5, data.getPrice());
            ps.setInt(6, data.getUser().getUserId());
            ps.setLong(7, data.getConsumeId());
            ps.executeUpdate();
            
            stockDao = new StockDao();
            Stock stock = stockDao.find(data.getMedicine());
            stock.setStockQuantity(stock.getStockQuantity()+oldrecord.getQuantity() - data.getQuantity());
            stockDao.update(stock,data.getMedicine(), connection);
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:MedicineConsumeDao:update:rollback..." + e1);
            }
            throw new UncaughtError("Error:MedicineConsumeDao:update..." + e);
        }
        return data;
    }

    @Override
    public boolean delete(MedicineConsume data) {
        try {
            connection.setAutoCommit(false);
            String sql = "DELETE FROM medicine_consume WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getConsumeId());
            ps.executeUpdate();
            stockDao = new StockDao();
            Stock stock = stockDao.find(data.getMedicine());
            stock.setStockQuantity(stock.getStockQuantity()+data.getQuantity());
            stockDao.update(stock,data.getMedicine(), connection);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:MedicineConsumeDao:delete:rollback..." + e1);
            }
            throw new UncaughtError("Error:MedicineConsumeDao:delete..." + e);
        }
        return true;
    }

    @Override
    public MedicineConsume find(String id) {
        MedicineConsume data = new MedicineConsume();
        try {
            String sql = "SELECT * FROM medicine_consume WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setConsumeDate(rs.getDate("consume_date"));
                data.setConsumeId(rs.getLong("id"));
                data.setCreatedAt(rs.getTimestamp("created_at"));
                MedicineDao medicineDao = new MedicineDao();
                data.setMedicine(medicineDao.find(String.valueOf(rs.getInt("medicine_id"))));
                data.setPrice(rs.getDouble("price"));
                data.setQuantity(rs.getInt("quantity"));
                data.setReason(rs.getString("reason"));
                UserDao userDao = new UserDao();
                data.setUser(userDao.find(String.valueOf(rs.getInt("created_by"))));
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:MedicineConsumeDao:find:rollback..." + e1);
            }
            throw new UncaughtError("Error:MedicineConsumeDao:find..." + e);
        }
        return data;
    }

    @Override
    public List<MedicineConsume> display() {
        List<MedicineConsume> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medicine_consume ORDER BY id,consume_date";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                MedicineConsume data = new MedicineConsume();
                data.setConsumeDate(rs.getDate("consume_date"));
                data.setConsumeId(rs.getLong("id"));
                data.setCreatedAt(rs.getTimestamp("created_at"));
                MedicineDao medicineDao = new MedicineDao();
                data.setMedicine(medicineDao.find(String.valueOf(rs.getInt("medicine_id"))));
                data.setPrice(rs.getDouble("price"));
                data.setQuantity(rs.getInt("quantity"));
                data.setReason(rs.getString("reason"));
                UserDao userDao = new UserDao();
                data.setUser(userDao.find(String.valueOf(rs.getInt("created_by"))));
                list.add(data);
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new UncaughtError("Error:MedicineConsumeDao:display:rollback..." + e1);
            }
            throw new UncaughtError("Error:MedicineConsumeDao:display..." + e);
        }
        return list;
    }

}
