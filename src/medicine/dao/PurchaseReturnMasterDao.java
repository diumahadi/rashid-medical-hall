package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import medicine.model.Client;
import medicine.model.PurchaseReturnMaster;
import medicine.model.User;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class PurchaseReturnMasterDao implements BaseDao<PurchaseReturnMaster> {

    private final Connection connection;

    public PurchaseReturnMasterDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public PurchaseReturnMaster save(PurchaseReturnMaster data) {
        try {
            String sql = "INSERT INTO purchase_return_master (client_id,return_date,created_by) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, data.getClient().getClientId());
            ps.setDate(2, new java.sql.Date(data.getReturnDate().getTime()));
            ps.setInt(3, data.getUser().getUserId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                data = find(String.valueOf(rs.getLong(1)));
            }
        } catch (SQLException e) {
            System.out.println("PurchaseReturnMaster:Insert:Error........." + e);

        }
        return data;
    }

    @Override
    public PurchaseReturnMaster update(PurchaseReturnMaster data) {
        try {
            String sql = "UPDATE purchase_return_master SET client_id=?,return_date=?,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getClient().getClientId());
            ps.setDate(2, new java.sql.Date(data.getReturnDate().getTime()));
            ps.setInt(3, data.getUser().getUserId());
            ps.setLong(4, data.getReturnId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Error("PurchaseReturnMaster:Update:Error........." + e);
        }
        return data;
    }

    @Override
    public boolean delete(PurchaseReturnMaster data) {
        try {
            String sql = "DELETE FROM purchase_return_master WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getReturnId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Error("PurchaseReturnMaster:Delete:Error........." + e);
        }
        return true;
    }

    public boolean delete(PurchaseReturnMaster data, Connection conn) {
        try {
            String sql = "DELETE FROM purchase_return_master WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, data.getReturnId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Error("PurchaseReturnMaster:Delete:Error........." + e);
        }
        return true;
    }

    @Override
    public PurchaseReturnMaster find(String id) {
        PurchaseReturnMaster data = new PurchaseReturnMaster();
        try {
            String sql = "SELECT * FROM purchase_return_master WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                data.setClient(client);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setReturnDate(rs.getDate("return_date"));
                data.setReturnId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
            }
        } catch (SQLException e) {
            throw new Error("PurchaseReturnMaster:Find:Error........." + e);
        }
        return data;
    }

    public Map<Long, Client> getRepresentativeList() {
        Map<Long, Client> map = new HashMap<>();
        for (PurchaseReturnMaster mas : display()) {
            if (!map.containsKey(mas.getClient().getClientId())) {
                map.put(mas.getClient().getClientId(), mas.getClient());
            }
        }
        return map;
    }

    public List<PurchaseReturnMaster> getSingleRepReturn(Client c) {
        List<PurchaseReturnMaster> list = new ArrayList<>();

        for (PurchaseReturnMaster mas : display()) {
            if (mas.getClient().getClientId() == c.getClientId()) {
                list.add(mas);
            }
        }

        return list;
    }

    @Override
    public List<PurchaseReturnMaster> display() {
        List<PurchaseReturnMaster> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM purchase_return_master ORDER BY return_date DESC";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PurchaseReturnMaster data = new PurchaseReturnMaster();
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                data.setClient(client);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setReturnDate(rs.getDate("return_date"));
                data.setReturnId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            throw new Error("PurchaseReturnMaster:Display:SQL Error........." + e);
        }
        return list;
    }

}
