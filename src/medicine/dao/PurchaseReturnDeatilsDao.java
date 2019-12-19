package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import medicine.model.Medicine;
import medicine.model.PurchaseReturnDetails;
import medicine.model.PurchaseReturnMaster;
import medicine.service.ChildOperation;
import medicine.util.DbUtil;

public class PurchaseReturnDeatilsDao implements ChildOperation<PurchaseReturnDetails, PurchaseReturnMaster> {

    private final Connection connection;

    public PurchaseReturnDeatilsDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public PurchaseReturnDetails save(PurchaseReturnDetails details, PurchaseReturnMaster master, Connection conn) {
        try {
            String sql = "INSERT INTO purchase_return_details (return_id,medicine_id,return_quantity,submit_date) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, details.getPurchaseReturnMaster().getReturnId());
            ps.setInt(2, details.getMedicine().getMedicineId());
            ps.setInt(3, details.getReturnQuantity());
            ps.setDate(4, new java.sql.Date(details.getSubmitDate().getTime()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                details = findSingleResult(String.valueOf(rs.getLong(1)));
            }

        } catch (SQLException e) {
            throw new Error("PurchaseReturnDetailsDao:Save:SQL Error........." + e);
        }
        return details;
    }

    @Override
    public PurchaseReturnDetails update(PurchaseReturnDetails details, PurchaseReturnMaster master, Connection conn) {
        try {
            String sql = "UPDATE purchase_return_details SET return_id=?,medicine_id=?,return_quantity=?,submit_quantity=?,submit_date=? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, master.getReturnId());
            ps.setInt(2, details.getMedicine().getMedicineId());
            ps.setInt(3, details.getReturnQuantity());
            ps.setInt(4, details.getSubmitQuantity());
            ps.setDate(5, new java.sql.Date(details.getSubmitDate().getTime()));
            ps.setLong(6, details.getDetailId());
            ps.executeUpdate();
            details = findSingleResult(String.valueOf(details.getDetailId()));
        } catch (SQLException e) {
            throw new Error("PurchaseReturnDetailsDao:Update:SQL Error........." + e);
        }
        return details;
    }
    
    public PurchaseReturnDetails update(PurchaseReturnDetails details, Connection conn) {
        try {
            String sql = "UPDATE purchase_return_details SET return_id=?,medicine_id=?,return_quantity=?,submit_quantity=?,submit_date=? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, details.getPurchaseReturnMaster().getReturnId());
            ps.setInt(2, details.getMedicine().getMedicineId());
            ps.setInt(3, details.getReturnQuantity());
            ps.setInt(4, details.getSubmitQuantity());
            ps.setDate(5, new java.sql.Date(details.getSubmitDate().getTime()));
            ps.setLong(6, details.getDetailId());
            ps.executeUpdate();
            details = findSingleResult(String.valueOf(details.getDetailId()));
        } catch (SQLException e) {
            throw new Error("PurchaseReturnDetailsDao:Update:SQL Error........." + e);
        }
        return details;
    }

    @Override
    public boolean deleteSingleRecord(PurchaseReturnDetails details, Connection conn) {
        try {
            String sql = "DELETE FROM purchase_return_details WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, details.getDetailId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Error("PurchaseReturnDetailsDao:DeleteSingleRecord:SQL Error........." + e);
        }
        return true;
    }

    @Override
    public boolean deleteChildRecords(PurchaseReturnMaster master, Connection conn) {
        try {
            String sql = "DELETE FROM purchase_return_details WHERE return_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, master.getReturnId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Error("PurchaseReturnDetailsDao:DeleteSingleRecord:SQL Error........." + e);
        }
        return true;
    }

    @Override
    public PurchaseReturnDetails findSingleResult(String id) {
        PurchaseReturnDetails data = new PurchaseReturnDetails();
        try {
            String sql = "SELECT * FROM purchase_return_details WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setDetailId(rs.getLong("id"));
                data.setSubmitDate(rs.getDate("submit_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                PurchaseReturnMasterDao masterDao = new PurchaseReturnMasterDao();
                PurchaseReturnMaster master = masterDao.find(String.valueOf(rs.getLong("return_id")));
                data.setPurchaseReturnMaster(master);
                data.setReturnQuantity(rs.getInt("return_quantity"));
                data.setSubmitQuantity(rs.getInt("submit_quantity"));
            }
        } catch (SQLException e) {
            throw new Error("PurchaseReturnDetailsDao:DeleteSingleRecord:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<PurchaseReturnDetails> childUnderParent(PurchaseReturnMaster master) {
        List<PurchaseReturnDetails> list = new ArrayList<>();
        try {

            String sql = "SELECT * FROM purchase_return_details WHERE return_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, master.getReturnId());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PurchaseReturnDetails data = new PurchaseReturnDetails();
                data.setDetailId(rs.getLong("id"));
                data.setSubmitDate(rs.getDate("submit_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                data.setPurchaseReturnMaster(master);
                data.setReturnQuantity(rs.getInt("return_quantity"));
                data.setSubmitQuantity(rs.getInt("submit_quantity"));
                list.add(data);
            }
        } catch (SQLException e) {
            throw new Error("PurchaseReturnDetailsDao:ChildUnderParent:SQL Error........." + e);
        }

        Collections.sort(list, new Comparator<PurchaseReturnDetails>() {
            @Override
            public int compare(PurchaseReturnDetails d1, PurchaseReturnDetails d2) {
                return d1.getMedicine().getMedicineName().compareToIgnoreCase(d2.getMedicine().getMedicineName());
            }
        });
        return list;
    }

    @Override
    public List<PurchaseReturnDetails> display() {
        List<PurchaseReturnDetails> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM purchase_return_details";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PurchaseReturnDetails data = new PurchaseReturnDetails();
                data.setDetailId(rs.getLong("id"));
                data.setSubmitDate(rs.getDate("submit_date"));
                MedicineDao medicineDao = new MedicineDao();
                Medicine medicine = medicineDao.find(String.valueOf(rs.getInt("medicine_id")));
                data.setMedicine(medicine);
                PurchaseReturnMasterDao masterDao = new PurchaseReturnMasterDao();
                PurchaseReturnMaster master = masterDao.find(String.valueOf(rs.getLong("return_id")));
                data.setPurchaseReturnMaster(master);
                data.setReturnQuantity(rs.getInt("return_quantity"));
                data.setSubmitQuantity(rs.getInt("submit_quantity"));
                list.add(data);
            }
        } catch (SQLException e) {
            throw new Error("PurchaseReturnDetailsDao:Display:SQL Error........." + e);
        }
        return list;
    }

}
