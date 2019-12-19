package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.Company;
import medicine.model.User;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class CompanyDao implements BaseDao<Company> {

    private final Connection connection;

    public CompanyDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public Company save(Company data) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO company (company_name,email,web_url,logo,mobile,address,display,created_by) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getCompanyName());
            ps.setString(2, data.getEmail());
            ps.setString(3, data.getWebUrl());
            ps.setString(4, data.getLogo());
            ps.setString(5, data.getMobile());
            ps.setString(6, data.getAddress());
            ps.setInt(7, data.getDisplay());
            ps.setInt(8, data.getUser().getUserId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:CompanyDao...:insertm..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:CompanyDao...:insertm...rollback" + e1);
            }

        }
        return data;
    }

    @Override
    public Company update(Company data) {

        try {
            connection.setAutoCommit(false);
            String sql = "UPDATE company SET company_name=?,email=?,web_url=?,logo=?,mobile=?,address=?,display=?,created_by=? WHERE company_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getCompanyName());
            ps.setString(2, data.getEmail());
            ps.setString(3, data.getWebUrl());
            ps.setString(4, data.getLogo());
            ps.setString(5, data.getMobile());
            ps.setString(6, data.getAddress());
            ps.setInt(7, data.getDisplay());
            ps.setInt(8, data.getUser().getUserId());
            ps.setInt(9, data.getCompanyId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:CompanyDao...:Update..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:CompanyDao...:Update...rollback" + e1);
            }

        }
        return data;
    }

    @Override
    public boolean delete(Company data) {
        try {
            connection.setAutoCommit(false);
            String sql = "DELETE FROM company WHERE company_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, data.getCompanyId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:CompanyDao...:Delete..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:CompanyDao...:Delete...rollback" + e1);
            }

        }
        return true;
    }

    @Override
    public Company find(String id) {
        Company data = new Company();
        try {
            String sql = "SELECT * FROM company WHERE company_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setAddress(rs.getString("address"));
                data.setCompanyId(rs.getInt("company_id"));
                data.setCompanyName(rs.getString("company_name"));
                data.setDisplay(rs.getInt("display"));
                data.setEmail(rs.getString("email"));
                data.setLogo(rs.getString("logo"));
                data.setMobile(rs.getString("mobile"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                data.setWebUrl(rs.getString("web_url"));
            }
        } catch (SQLException e) {
            System.out.println("CompanyDao:Find:SQL Error........." + e);
        }
        return data;
    }

    public List<Company> getMatch(String match) {
        List<Company> list = new ArrayList<>();
        try {
            match = match.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
            String sql = "SELECT * FROM company WHERE company_name LIKE ? ESCAPE '!' ORDER BY company_name";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + match + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Company data = new Company();
                data.setAddress(rs.getString("address"));
                data.setCompanyId(rs.getInt("company_id"));
                data.setCompanyName(rs.getString("company_name"));
                data.setDisplay(rs.getInt("display"));
                data.setEmail(rs.getString("email"));
                data.setLogo(rs.getString("logo"));
                data.setMobile(rs.getString("mobile"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                data.setWebUrl(rs.getString("web_url"));
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("CompanyDao:getMatch:SQL Error........." + e);
        }
        return list;
    }

    @Override
    public List<Company> display() {
        List<Company> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM company ORDER BY company_name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Company data = new Company();
                data.setAddress(rs.getString("address"));
                data.setCompanyId(rs.getInt("company_id"));
                data.setCompanyName(rs.getString("company_name"));
                data.setDisplay(rs.getInt("display"));
                data.setEmail(rs.getString("email"));
                data.setLogo(rs.getString("logo"));
                data.setMobile(rs.getString("mobile"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                data.setWebUrl(rs.getString("web_url"));
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("CompanyDao:Display:SQL Error........." + e);
        }
        return list;
    }

}
