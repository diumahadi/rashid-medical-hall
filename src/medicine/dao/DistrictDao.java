package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.District;
import medicine.service.FormOperation;
import medicine.util.DbUtil;

public class DistrictDao implements FormOperation<District>{

    private final Connection connection;
    
    public DistrictDao(){
        connection=DbUtil.getConnection();
    }
    @Override
    public boolean save(District data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(District data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(District data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public District find(String id) {
        District data = new District();
        try {
            String sql = "SELECT * FROM district WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setDistrictId(rs.getInt("id"));
                data.setDistrictName(rs.getString("disctrict_name"));
                DivisitionDao divisionDao=new DivisitionDao();                
                data.setDivision(divisionDao.find(String.valueOf(rs.getInt("division_id"))));                
            }
        } catch (SQLException e) {
            System.out.println("DistrictDao:Find:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<District> display() {
        List<District> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM district ORDER BY disctrict_name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                District data = new District();
                data.setDistrictId(rs.getInt("id"));
                data.setDistrictName(rs.getString("disctrict_name"));
                DivisitionDao divisionDao=new DivisitionDao();                
                data.setDivision(divisionDao.find(String.valueOf(rs.getInt("division_id"))));  
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("DistrictDao:Display:SQL Error........." + e);
        }
        return list;
    }
    
}
