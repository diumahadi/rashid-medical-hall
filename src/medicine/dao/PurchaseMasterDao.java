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
import medicine.model.PurchaseMaster;
import medicine.model.User;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class PurchaseMasterDao implements BaseDao<PurchaseMaster> {

    private final Connection connection;

    public PurchaseMasterDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public PurchaseMaster save(PurchaseMaster data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PurchaseMaster update(PurchaseMaster data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PurchaseMaster save(PurchaseMaster data, Connection conn) throws SQLException {
        String sql = "INSERT INTO purchase_master (client_id,invoice_no,ps_id,purchase_date,paid_amount,due_amount,created_by) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        if (data.getClient() != null) {
            ps.setLong(1, data.getClient().getClientId());
        } else {
            ps.setNull(1, java.sql.Types.BIGINT);
        }

        if (data.getInvoiceNo() != null) {
            ps.setString(2, data.getInvoiceNo());
        } else {
            ps.setNull(2, java.sql.Types.VARCHAR);
        }

        ps.setInt(3, data.getpSTitle().getPsId());
        ps.setDate(4, new java.sql.Date(data.getPurchaseDate().getTime()));
        ps.setDouble(5, data.getPaidAmount());
        ps.setDouble(6, data.getDueAmount());
        ps.setInt(7, data.getUser().getUserId());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs != null && rs.next()) {
            data = find(String.valueOf(rs.getLong(1)));
        }
        return data;
    }

    public PurchaseMaster update(PurchaseMaster data, Connection conn) throws SQLException {
        try {
            String sql = "UPDATE purchase_master SET client_id=?,invoice_no=?,ps_id=?,purchase_date=?,paid_amount=?,due_amount=?,created_by=? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            if (data.getClient() != null) {
                ps.setLong(1, data.getClient().getClientId());
            } else {
                ps.setNull(1, java.sql.Types.BIGINT);
            }

            if (data.getInvoiceNo() != null) {
                ps.setString(2, data.getInvoiceNo());
            } else {
                ps.setNull(2, java.sql.Types.VARCHAR);
            }

            ps.setInt(3, data.getpSTitle().getPsId());
            ps.setDate(4, new java.sql.Date(data.getPurchaseDate().getTime()));
            ps.setDouble(5, data.getPaidAmount());
            ps.setDouble(6, data.getDueAmount());
            ps.setInt(7, data.getUser().getUserId());
            ps.setLong(8, data.getPurchaseId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("PurchaseDetailsDao:Update:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public boolean delete(PurchaseMaster data) {
        try {
            String sql = "DELETE FROM purchase_master WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getPurchaseId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("PurchaseMasterDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public PurchaseMaster find(String id) {
        PurchaseMaster data = new PurchaseMaster();
        try {
            String sql = "SELECT * FROM purchase_master WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getLong("client_id") != 0) {
                    ClientDao clientDao = new ClientDao();
                    Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                    data.setClient(client);
                }else{
                    data.setClient(null);
                }

                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDueAmount(rs.getDouble("due_amount"));
                data.setPaidAmount(rs.getDouble("paid_amount"));
                data.setPurchaseDate(rs.getDate("purchase_date"));
                data.setPurchaseId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                PSTitleDao pSTitleDao = new PSTitleDao();
                PSTitle pSTitle = pSTitleDao.find(String.valueOf(rs.getInt("ps_id")));
                data.setpSTitle(pSTitle);
            }
        } catch (SQLException e) {
            System.out.println("PurchaseMasterDao:Find:SQL Error........." + e);
        }
        return data;
    }

    public PurchaseMaster findByInvoice(String id) {
        PurchaseMaster data = new PurchaseMaster();
        try {
            String sql = "SELECT * FROM purchase_master WHERE invoice_no = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getLong("client_id") != 0) {
                    ClientDao clientDao = new ClientDao();
                    Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                    data.setClient(client);
                }else{
                    data.setClient(null);
                }
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDueAmount(rs.getDouble("due_amount"));
                data.setPaidAmount(rs.getDouble("paid_amount"));
                data.setPurchaseDate(rs.getDate("purchase_date"));
                data.setPurchaseId(rs.getLong("id"));
                data.setInvoiceNo(rs.getString("invoice_no"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                PSTitleDao pSTitleDao = new PSTitleDao();
                PSTitle pSTitle = pSTitleDao.find(String.valueOf(rs.getInt("ps_id")));
                data.setpSTitle(pSTitle);
            }
        } catch (SQLException e) {
            System.out.println("PurchaseMasterDao:findByInvoice:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<PurchaseMaster> display() {
        List<PurchaseMaster> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM purchase_master ORDER BY purchase_date DESC";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PurchaseMaster data = new PurchaseMaster();
                if (rs.getLong("client_id") != 0) {
                    ClientDao clientDao = new ClientDao();
                    Client client = clientDao.find(String.valueOf(rs.getLong("client_id")));
                    data.setClient(client);
                }else{
                    data.setClient(null);
                }
                data.setInvoiceNo(rs.getString("invoice_no"));
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDueAmount(rs.getDouble("due_amount"));
                data.setPaidAmount(rs.getDouble("paid_amount"));
                data.setPurchaseDate(rs.getDate("purchase_date"));
                data.setPurchaseId(rs.getLong("id"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                PSTitleDao pSTitleDao = new PSTitleDao();
                PSTitle pSTitle = pSTitleDao.find(String.valueOf(rs.getInt("ps_id")));
                data.setpSTitle(pSTitle);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("PurchaseMasterDao:Display:SQL Error........." + e);
        }
        return list;
    }

}
