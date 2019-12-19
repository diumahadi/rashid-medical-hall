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
import medicine.model.Company;
import medicine.model.User;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class ClientDao implements BaseDao<Client> {

    private final Connection connection;
    private DistrictDao districtDao;

    public ClientDao() {
        this.connection = DbUtil.getConnection();
    }

    @Override
    public Client save(Client data) {
        try {
            String sql = "INSERT INTO client (first_name,last_name,age,gender,date_of_birth,email,client_type,mobile,blood_group,company_id,present_district_id,address,permanent_district_id,permanent_address,starting_due,display,created_by) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getFirstName());
            ps.setString(2, data.getLastName());
            ps.setInt(3, data.getAge());
            ps.setString(4, data.getGender());
            if (data.getDateOfBirth() != null) {
                ps.setDate(5, new java.sql.Date(data.getDateOfBirth().getTime()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }
            ps.setString(6, data.getEmail());
            ps.setInt(7, data.getClientType());
            ps.setString(8, data.getMobile());
            ps.setString(9, data.getBloodGroup());
            if (data.getCompany() != null) {
                ps.setInt(10, data.getCompany().getCompanyId());
            } else {
                ps.setNull(10, java.sql.Types.INTEGER);
            }
            if (data.getPresentDistrict() != null) {
                ps.setInt(11, data.getPresentDistrict().getDistrictId());
            } else {
                ps.setNull(11, java.sql.Types.INTEGER);
            }
            ps.setString(12, data.getAddress());

            if (data.getPermanentDistrict() != null) {
                ps.setInt(13, data.getPermanentDistrict().getDistrictId());
            } else {
                ps.setNull(13, java.sql.Types.INTEGER);
            }

            ps.setString(14, data.getPermanentAddress());
            ps.setDouble(15, data.getStartingDue());
            ps.setInt(16, data.getDisplay());
            ps.setInt(17, data.getUser().getUserId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                data = find(String.valueOf(rs.getLong(1)));
            }
        } catch (SQLException e) {
            throw new UncaughtError("ClientDao:Insert:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public Client update(Client data) {
        try {
            String sql = "UPDATE client SET first_name=?,last_name=?,age=?,gender=?,date_of_birth=?,email=?,client_type=?,mobile=?,blood_group=?,company_id=?,present_district_id=?,address=?,permanent_district_id=?,permanent_address=?,starting_due=?,display=?,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getFirstName());
            ps.setString(2, data.getLastName());
            ps.setInt(3, data.getAge());
            ps.setString(4, data.getGender());
            if (data.getDateOfBirth() != null) {
                ps.setDate(5, new java.sql.Date(data.getDateOfBirth().getTime()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }
            ps.setString(6, data.getEmail());
            ps.setInt(7, data.getClientType());
            ps.setString(8, data.getMobile());
            ps.setString(9, data.getBloodGroup());
            if (data.getCompany() != null) {
                ps.setInt(10, data.getCompany().getCompanyId());
            } else {
                ps.setNull(10, java.sql.Types.INTEGER);
            }
            if (data.getPresentDistrict() != null) {
                ps.setInt(11, data.getPresentDistrict().getDistrictId());
            } else {
                ps.setNull(11, java.sql.Types.INTEGER);
            }
            ps.setString(12, data.getAddress());

            if (data.getPermanentDistrict() != null) {
                ps.setInt(13, data.getPermanentDistrict().getDistrictId());
            } else {
                ps.setNull(13, java.sql.Types.INTEGER);
            }

            ps.setString(14, data.getPermanentAddress());
            ps.setDouble(15, data.getStartingDue());
            ps.setInt(16, data.getDisplay());
            ps.setInt(17, data.getUser().getUserId());
            ps.setLong(18, data.getClientId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new UncaughtError("ClientDao:Update:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public boolean delete(Client data) {
        try {
            String sql = "DELETE FROM client WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.getClientId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ClientDao:Delete:SQL Error........." + e);
            return false;
        }
        return true;
    }

    @Override
    public Client find(String id) {
        Client data = new Client();
        try {
            String sql = "SELECT * FROM client WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data.setAddress(rs.getString("address"));
                data.setAge(rs.getInt("age"));
                data.setBloodGroup(rs.getString("blood_group"));
                data.setClientId(rs.getLong("id"));
                data.setClientType(rs.getInt("client_type"));
                CompanyDao companyDao = new CompanyDao();
                Company company = companyDao.find(String.valueOf(rs.getInt("company_id")));
                data.setCompany(company);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDateOfBirth(rs.getDate("date_of_birth"));
                data.setDisplay(rs.getInt("display"));
                data.setEmail(rs.getString("email"));
                data.setFirstName(rs.getString("first_name"));
                data.setGender(rs.getString("gender"));
                data.setLastName(rs.getString("last_name"));
                data.setMobile(rs.getString("mobile"));
                data.setPermanentAddress(rs.getString("permanent_address"));
                
                if (rs.getInt("permanent_district_id") != 0) {
                    districtDao = new DistrictDao();
                    data.setPermanentDistrict(districtDao.find(String.valueOf(rs.getInt("permanent_district_id"))));
                } else {
                    data.setPermanentDistrict(null);
                }

                if (rs.getInt("present_district_id") != 0) {
                    districtDao = new DistrictDao();
                    data.setPresentDistrict(districtDao.find(String.valueOf(rs.getInt("present_district_id"))));
                } else {
                    data.setPresentDistrict(null);
                }

                data.setStartingDue(rs.getDouble("starting_due"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
            }
        } catch (SQLException e) {
            throw new UncaughtError("ClientDao:Find:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<Client> display() {
        List<Client> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM client ORDER BY id DESC";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Client data = new Client();
                data.setAddress(rs.getString("address"));
                data.setAge(rs.getInt("age"));
                data.setBloodGroup(rs.getString("blood_group"));
                data.setClientId(rs.getLong("id"));
                data.setClientType(rs.getInt("client_type"));
                CompanyDao companyDao = new CompanyDao();
                Company company = companyDao.find(String.valueOf(rs.getInt("company_id")));
                data.setCompany(company);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDateOfBirth(rs.getDate("date_of_birth"));
                data.setDisplay(rs.getInt("display"));
                data.setEmail(rs.getString("email"));
                data.setFirstName(rs.getString("first_name"));
                data.setGender(rs.getString("gender"));
                data.setLastName(rs.getString("last_name"));
                data.setMobile(rs.getString("mobile"));
                data.setPermanentAddress(rs.getString("permanent_address"));
                
                if (rs.getInt("permanent_district_id") != 0) {
                    districtDao = new DistrictDao();
                    data.setPermanentDistrict(districtDao.find(String.valueOf(rs.getInt("permanent_district_id"))));
                } else {
                    data.setPermanentDistrict(null);
                }

                if (rs.getInt("present_district_id") != 0) {
                    districtDao = new DistrictDao();
                    data.setPresentDistrict(districtDao.find(String.valueOf(rs.getInt("present_district_id"))));
                } else {
                    data.setPresentDistrict(null);
                }
                
                data.setStartingDue(rs.getDouble("starting_due"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("ClientDao:Display:SQL Error........." + e);
        }
        return list;
    }

    public List<Client> getMatch(String match, Integer clientTp) {
        List<Client> list = new ArrayList<>();
        try {
            match = match.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
            String sql = "SELECT * FROM `client` WHERE first_name LIKE ? ESCAPE '!' AND client_type=? ORDER BY first_name";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + match + "%");
            ps.setInt(2, clientTp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client data = new Client();
                data.setAddress(rs.getString("address"));
                data.setAge(rs.getInt("age"));
                data.setBloodGroup(rs.getString("blood_group"));
                data.setClientId(rs.getLong("id"));
                data.setClientType(rs.getInt("client_type"));
                CompanyDao companyDao = new CompanyDao();
                Company company = companyDao.find(String.valueOf(rs.getInt("company_id")));
                data.setCompany(company);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDateOfBirth(rs.getDate("date_of_birth"));
                data.setDisplay(rs.getInt("display"));
                data.setEmail(rs.getString("email"));
                data.setFirstName(rs.getString("first_name"));
                data.setGender(rs.getString("gender"));
                data.setLastName(rs.getString("last_name"));
                data.setMobile(rs.getString("mobile"));
                data.setPermanentAddress(rs.getString("permanent_address"));
                if (rs.getInt("permanent_district_id") != 0) {
                    districtDao = new DistrictDao();
                    data.setPermanentDistrict(districtDao.find(String.valueOf(rs.getInt("permanent_district_id"))));
                } else {
                    data.setPermanentDistrict(null);
                }

                if (rs.getInt("present_district_id") != 0) {
                    districtDao = new DistrictDao();
                    data.setPresentDistrict(districtDao.find(String.valueOf(rs.getInt("present_district_id"))));
                } else {
                    data.setPresentDistrict(null);
                }
                data.setStartingDue(rs.getDouble("starting_due"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            throw new UncaughtError("ClientDao:getMatch:SQL Error........." + e);
        }
        return list;
    }

    public List<Client> display(int CLIENT_TYPE) {
        List<Client> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM client WHERE client_type =" + CLIENT_TYPE + " ORDER BY first_name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Client data = new Client();
                data.setAddress(rs.getString("address"));
                data.setAge(rs.getInt("age"));
                data.setBloodGroup(rs.getString("blood_group"));
                data.setClientId(rs.getLong("id"));
                data.setClientType(rs.getInt("client_type"));
                CompanyDao companyDao = new CompanyDao();
                Company company = companyDao.find(String.valueOf(rs.getInt("company_id")));
                data.setCompany(company);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDateOfBirth(rs.getDate("date_of_birth"));
                data.setDisplay(rs.getInt("display"));
                data.setEmail(rs.getString("email"));
                data.setFirstName(rs.getString("first_name"));
                data.setGender(rs.getString("gender"));
                data.setLastName(rs.getString("last_name"));
                data.setMobile(rs.getString("mobile"));
                data.setPermanentAddress(rs.getString("permanent_address"));
                
                if (rs.getInt("permanent_district_id") != 0) {
                    districtDao = new DistrictDao();
                    data.setPermanentDistrict(districtDao.find(String.valueOf(rs.getInt("permanent_district_id"))));
                } else {
                    data.setPermanentDistrict(null);
                }

                if (rs.getInt("present_district_id") != 0) {
                    districtDao = new DistrictDao();
                    data.setPresentDistrict(districtDao.find(String.valueOf(rs.getInt("present_district_id"))));
                } else {
                    data.setPresentDistrict(null);
                }
                
                data.setStartingDue(rs.getDouble("starting_due"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            throw new UncaughtError("ClientDao:Display:SQL Error........." + e);
        }
        return list;
    }
}
