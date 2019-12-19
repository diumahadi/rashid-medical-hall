package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.Client;
import medicine.model.PSTitle;
import medicine.model.SalesMaster;
import medicine.model.User;
import medicine.service.FormOperation;
import medicine.util.DbUtil;

public class SalesMasterDao implements FormOperation<SalesMaster> {

    private final Connection connection;

    public SalesMasterDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public boolean save(SalesMaster data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SalesMaster save(SalesMaster data, Connection conn) throws SQLException {

        String sql = "INSERT INTO sales_master (client_id,ps_id,sales_date,paid_amount,due_amount,created_by) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        if (data.getClient() != null) {
            ps.setLong(1, data.getClient().getClientId());
        } else {
            ps.setNull(1, java.sql.Types.LONGNVARCHAR);
        }
        ps.setInt(2, data.getPsTitle().getPsId());
        ps.setDate(3, new java.sql.Date(data.getSalesDate().getTime()));
        ps.setDouble(4, data.getPaidAmount());
        ps.setDouble(5, data.getDueAmount());
        ps.setInt(6, data.getUser().getUserId());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs != null && rs.next()) {
            data = find(String.valueOf(rs.getLong(1)));
        }
        return data;
    }

    @Override
    public boolean update(SalesMaster data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean update(SalesMaster data, Connection conn) {
        try {
            String sql = "UPDATE sales_master SET client_id=?,ps_id=?,sales_date=?,paid_amount=?,due_amount=?,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            if (data.getClient() != null) {
                ps.setLong(1, data.getClient().getClientId());
            } else {
                ps.setNull(1, java.sql.Types.LONGNVARCHAR);
            }
            ps.setInt(2, data.getPsTitle().getPsId());
            ps.setDate(3, new java.sql.Date(data.getSalesDate().getTime()));
            ps.setDouble(4, data.getPaidAmount());
            ps.setDouble(5, data.getDueAmount());
            ps.setInt(6, data.getUser().getUserId());
            ps.setLong(7, data.getSalesId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SalesMasterDao:Update:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(SalesMaster data) {
        try {
            String sql = "DELETE FROM sales_master WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getSalesId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SalesMasterDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public SalesMaster find(String id) {
        SalesMaster data = new SalesMaster();
        try {
            String sql = "SELECT * FROM sales_master WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                data.setClient(client);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDueAmount(rs.getDouble("due_amount"));
                data.setPaidAmount(rs.getDouble("paid_amount"));
                PSTitleDao psTitleDao = new PSTitleDao();
                PSTitle title = psTitleDao.find(String.valueOf(rs.getInt("ps_id")));
                data.setPsTitle(title);
                data.setSalesDate(rs.getDate("sales_date"));
                data.setSalesId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
            }
        } catch (SQLException e) {
            System.out.println("SalesMasterDao:Find:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<SalesMaster> display() {
        List<SalesMaster> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM sales_master ORDER BY sales_date DESC";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                SalesMaster data = new SalesMaster();
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                data.setClient(client);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDueAmount(rs.getDouble("due_amount"));
                data.setPaidAmount(rs.getDouble("paid_amount"));
                PSTitleDao psTitleDao = new PSTitleDao();
                PSTitle title = psTitleDao.find(String.valueOf(rs.getInt("ps_id")));
                data.setPsTitle(title);
                data.setSalesDate(rs.getDate("sales_date"));
                data.setSalesId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("SalesMasterDao:Display:SQL Error........." + e);
        }
        return list;
    }

}
