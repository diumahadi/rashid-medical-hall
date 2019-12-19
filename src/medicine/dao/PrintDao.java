package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import medicine.model.Medicine;
import medicine.model.PrintSingleMedicineBarcode;
import medicine.util.DbUtil;

public class PrintDao {

    private final Connection connection;

    public PrintDao() {
        this.connection = DbUtil.getConnection();
    }
    
    
    public boolean save(PrintSingleMedicineBarcode data) {
        try {
            String sql = "INSERT INTO print_single_medicine_barcode (medicine_id,created_by) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, data.getMedicine().getMedicineId());
            ps.setInt(2, data.getUser().getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("PrintDao:Insert:SQL Error........." + e);
            return false;
        }
        return true;
    }
    
    public boolean removeAllRows(){
        try {
            String sql = "truncate print_single_medicine_barcode";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("PrintDao:removeAllRows:Error..." + e);
            return false;
        }
        return true;
    }

    public  int totalCount(Medicine m) {
        int total = 0;
        try {
            String sql = "SELECT COUNT(*) total FROM print_single_medicine_barcode WHERE medicine_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, m.getMedicineId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println(""+e);
        }
        return total;
    }

}
