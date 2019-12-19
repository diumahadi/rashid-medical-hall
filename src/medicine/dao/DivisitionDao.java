package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.Division;
import medicine.service.FormOperation;
import medicine.util.DbUtil;

public class DivisitionDao implements FormOperation<Division> {

    private final Connection connection;

    public DivisitionDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public boolean save(Division data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Division data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Division data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Division find(String id) {
        Division data = new Division();
        try {
            String sql = "SELECT * FROM division WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setDivisionId(rs.getInt("id"));
                data.setDivisionName(rs.getString("division_name"));
            }
        } catch (SQLException e) {
            System.out.println("DivisitionDao:Find:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<Division> display() {
        List<Division> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM division ORDER BY division_name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Division data = new Division();
                data.setDivisionId(rs.getInt("id"));
                data.setDivisionName(rs.getString("division_name"));
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("DivisitionDao:Display:SQL Error........." + e);
        }
        return list;
    }

}
