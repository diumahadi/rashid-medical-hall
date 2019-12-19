package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.exception.UncaughtError;
import medicine.model.Client;
import medicine.model.ClientPayment;
import medicine.model.PurchaseMaster;
import medicine.model.SalesMaster;
import medicine.model.User;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class ClientPaymentDao implements BaseDao<ClientPayment> {

    private final Connection connection;
    private PurchaseDao purchaseDao;
    private SalesDao salesDao;

    public ClientPaymentDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public ClientPayment save(ClientPayment data) {
        try {
            String sql = "INSERT INTO client_payment (client_id,paid_amount,paid_tp,paid_date,created_by) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, data.getClient().getClientId());
            ps.setDouble(2, data.getPaidAmount());
            ps.setString(3, data.getPaymentType());
            ps.setDate(4, new java.sql.Date(data.getPaidDate().getTime()));
            ps.setInt(5, data.getUser().getUserId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                data = find(String.valueOf(rs.getLong(1)));
            }
        } catch (SQLException e) {
            throw new UncaughtError("Error...:ClientPaymentDao...:Save..." + e);
        }
        return data;
    }

    @Override
    public ClientPayment update(ClientPayment data) {
        try {
            String sql = "UPDATE client_payment SET client_id=? ,paid_amount=?,paid_tp=?,paid_date=? ,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getClient().getClientId());
            ps.setDouble(2, data.getPaidAmount());
            ps.setString(3, data.getPaymentType());
            ps.setDate(4, new java.sql.Date(data.getPaidDate().getTime()));
            ps.setInt(5, data.getUser().getUserId());
            ps.setLong(6, data.getPaymentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new UncaughtError("Error...:ClientPaymentDao...:Update..." + e);
        }
        return data;
    }

    @Override
    public boolean delete(ClientPayment data) {
        try {
            String sql = "DELETE FROM client_payment WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getPaymentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new UncaughtError("Error...:ClientPaymentDao...:delete..." + e);
        }
        return true;
    }

    @Override
    public ClientPayment find(String id) {
        ClientPayment data = new ClientPayment();
        try {
            String sql = "SELECT * FROM client_payment WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setCreatedAt(rs.getTimestamp("created_at"));
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                data.setClient(client);
                data.setPaidAmount(rs.getDouble("paid_amount"));
                data.setPaymentType(rs.getString("paid_tp"));
                data.setPaidDate(rs.getDate("paid_date"));
                data.setPaymentId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
            }
        } catch (SQLException e) {
            throw new UncaughtError("Error...:ClientPaymentDao...:find..." + e);
        }
        return data;
    }

    @Override
    public List<ClientPayment> display() {
        List<ClientPayment> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM client_payment ORDER BY paid_date";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ClientPayment data = new ClientPayment();
                data.setCreatedAt(rs.getTimestamp("created_at"));
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                data.setClient(client);
                data.setPaidAmount(rs.getDouble("paid_amount"));
                data.setPaymentType(rs.getString("paid_tp"));
                data.setPaidDate(rs.getDate("paid_date"));
                data.setPaymentId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            throw new UncaughtError("Error...:ClientPaymentDao...:display..." + e);
        }
        return list;
    }

    public double getTotalSalesDue(Client client) {

        double totalDueAmount = 0;
        try {
            String sql = "SELECT SUM(due_amount) salesDue FROM sales_master WHERE client_id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, client.getClientId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalDueAmount = rs.getDouble("salesDue");
            }
        } catch (SQLException e) {
            throw new UncaughtError("Error...:ClientPaymentDao...:getSalesDue..." + e);
        }
        return totalDueAmount;
    }
    
    public double getTotalPurchaseDue(Client client) {

        double totalDueAmount = 0;
        try {
            String sql = "SELECT SUM(due_amount) purchaseDue FROM purchase_master WHERE client_id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, client.getClientId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalDueAmount = rs.getDouble("purchaseDue");
            }
        } catch (SQLException e) {
            throw new UncaughtError("Error...:ClientPaymentDao...:getTotalPurchaseDue..." + e);
        }
        return totalDueAmount;
    }
    
    public double getTotalPayment(Client client,String paidTp) {

        double totalPaidAmount = 0;
        try {
            String sql = "SELECT SUM(paid_amount) paidAmount FROM client_payment WHERE client_id= ? AND paid_tp=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, client.getClientId());
            ps.setString(2, paidTp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalPaidAmount = rs.getDouble("paidAmount");
            }
        } catch (SQLException e) {
            throw new UncaughtError("Error...:ClientPaymentDao...:getTotalPayment..." + e);
        }
        return totalPaidAmount;
    }

    public double getRepTotalDueAmount(Client client) {
        double totalDuePurchase = 0;
        double totalDueSales = 0;
        double totalPaid = 0;

        purchaseDao = new PurchaseDao();
        for (PurchaseMaster mas : purchaseDao.display()) {
            if (mas.getClient() != null && (mas.getClient().getClientId() == client.getClientId())) {
                totalDuePurchase += mas.getDueAmount();
            }
        }

        salesDao = new SalesDao();
        for (SalesMaster mas : salesDao.display()) {
            if (mas.getClient() != null && (mas.getClient().getClientId() == client.getClientId())) {
                totalDueSales += mas.getDueAmount();
            }
        }

        for (ClientPayment p : display()) {
            if (p.getClient().getClientId() == client.getClientId()) {
                totalPaid += p.getPaidAmount();
            }
        }

        return totalDuePurchase + totalDueSales + client.getStartingDue() - totalPaid;
    }

    public double getClientTotalDueAmount(Client client) {
        double totalDue = 0;
        double totalPaid = 0;
        salesDao = new SalesDao();

        for (SalesMaster mas : salesDao.display()) {
            if (mas.getClient() != null && (mas.getClient().getClientId() == client.getClientId())) {
                totalDue += mas.getDueAmount();
            }
        }

        for (ClientPayment p : display()) {
            if (p.getClient().getClientId() == client.getClientId()) {
                totalPaid += p.getPaidAmount();
            }
        }
        return totalDue + client.getStartingDue() - totalPaid;
    }

}
