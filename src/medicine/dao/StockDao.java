package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.Medicine;
import medicine.model.Stock;
import medicine.service.FormOperation;
import medicine.util.DbUtil;

public class StockDao implements FormOperation<Stock> {

    private final Connection connection;

    public StockDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public boolean save(Stock data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Stock savem(Stock data, Medicine med, Connection conn) throws SQLException {
        String sql = "INSERT INTO medicine_stock (medicine_id,stock,starting_stock,reorder_level,expiracy_date) VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, med.getMedicineId());
        ps.setInt(2, data.getStockQuantity());
        ps.setInt(3, data.getStartingStock());
        ps.setInt(4, data.getReorderLevel());
        ps.setDate(5, new java.sql.Date(data.getExpiracyDate().getTime()));
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs != null && rs.next()) {
            data = find(String.valueOf(rs.getLong(1)));
        }
        return data;
    }

    public Stock update(Stock data, Medicine med, Connection conn) throws SQLException {
        String sql = "UPDATE medicine_stock SET medicine_id=?,stock=?,starting_stock=?,reorder_level=?,expiracy_date=? WHERE stock_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, med.getMedicineId());
        ps.setInt(2, data.getStockQuantity());
        ps.setInt(3, data.getStartingStock());
        ps.setInt(4, data.getReorderLevel());
        ps.setDate(5, new java.sql.Date(data.getExpiracyDate().getTime()));
        ps.setInt(6, data.getSockId());
        ps.executeUpdate();
        data = find(String.valueOf(data.getSockId()));
        return data;
    }

    @Override
    public boolean update(Stock data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(Stock data) {
        try {
            String sql = "DELETE FROM medicine_stock WHERE stock_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, data.getSockId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("StockDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public Stock find(String id) {
        Stock data = new Stock();
        try {
            String sql = "SELECT * FROM medicine_stock WHERE medicine_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setExpiracyDate(rs.getDate("expiracy_date"));
                data.setReorderLevel(rs.getInt("reorder_level"));
                data.setSockId(rs.getInt("stock_id"));
                data.setStartingStock(rs.getInt("starting_stock"));
                data.setStockQuantity(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println("StockDao:Find:SQL Error........." + e);
        }
        return data;
    }

    public Stock find(Medicine medicine) {
        Stock data = new Stock();
        try {
            String sql = "SELECT * FROM medicine_stock WHERE medicine_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, medicine.getMedicineId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setExpiracyDate(rs.getDate("expiracy_date"));
                data.setMedicine(medicine);
                data.setReorderLevel(rs.getInt("reorder_level"));
                data.setSockId(rs.getInt("stock_id"));
                data.setStartingStock(rs.getInt("starting_stock"));
                data.setStockQuantity(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println("StockDao:Find:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<Stock> display() {
        List<Stock> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medicine_stock ORDER BY medicine_id";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Stock data = new Stock();
                data.setExpiracyDate(rs.getDate("expiracy_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                data.setReorderLevel(rs.getInt("reorder_level"));
                data.setSockId(rs.getInt("stock_id"));
                data.setStartingStock(rs.getInt("starting_stock"));
                data.setStockQuantity(rs.getInt("stock"));
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("StockDao:Display:SQL Error........." + e);
        }
        return list;
    }

}
