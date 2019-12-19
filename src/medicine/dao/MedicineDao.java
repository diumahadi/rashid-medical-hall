package medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medicine.model.Company;
import medicine.model.Location;
import medicine.model.Medicine;
import medicine.model.Unit;
import medicine.model.User;
import medicine.service.FormOperation;
import medicine.util.DbUtil;

public class MedicineDao implements FormOperation<Medicine> {

    private final Connection connection;

    public MedicineDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public boolean save(Medicine data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Medicine savem(Medicine data, Connection conn) throws SQLException {

        String sql = "INSERT INTO medicine (name,company_id,location_id,medicine_type,unit_id,unit_purchase_price,unit_sales_price,display,created_by) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, data.getMedicineName());
        ps.setInt(2, data.getCompany().getCompanyId());
        if (data.getLocation() != null) {
            ps.setInt(3, data.getLocation().getLocationId());
        } else {
            ps.setNull(3, java.sql.Types.INTEGER);
        }

        if (data.getMedicineType() != null) {
            ps.setInt(4, data.getMedicineType().getTypeId());
        } else {
            ps.setNull(4, java.sql.Types.INTEGER);
        }

        if (data.getUnit() != null) {
            ps.setInt(5, data.getUnit().getUnitId());
        } else {
            ps.setNull(5, java.sql.Types.INTEGER);
        }
        ps.setDouble(6, data.getUnitPurchase());
        ps.setDouble(7, data.getUnitSales());
        ps.setInt(8, data.getDisplay());
        ps.setInt(9, data.getUser().getUserId());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs != null && rs.next()) {
            data = find(String.valueOf(rs.getLong(1)));
        }
        return data;
    }

    public long saveMedicine(Medicine data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(Medicine data) {
        try {
            String sql = "UPDATE medicine SET name=?,company_id=?,location_id=?,medicine_type=?,unit_id=?,unit_purchase_price=?,unit_sales_price=?,display=?,created_by=? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getMedicineName());
            ps.setInt(2, data.getCompany().getCompanyId());
            if (data.getLocation() != null) {
                ps.setInt(3, data.getLocation().getLocationId());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }

            if (data.getMedicineType() != null) {
                ps.setInt(4, data.getMedicineType().getTypeId());
            } else {
                ps.setNull(4, java.sql.Types.INTEGER);
            }

            if (data.getUnit() != null) {
                ps.setInt(5, data.getUnit().getUnitId());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            ps.setDouble(6, data.getUnitPurchase());
            ps.setDouble(7, data.getUnitSales());
            ps.setInt(8, data.getDisplay());
            ps.setInt(9, data.getUser().getUserId());
            ps.setInt(10, data.getMedicineId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("MedicineDao:Update:SQL Error........." + e);
            return false;
        }
        return true;
    }

    public Medicine updatem(Medicine data, Connection conn) throws SQLException {
        String sql = "UPDATE medicine SET name=?,company_id=?,location_id=?,medicine_type=?,unit_id=?,unit_purchase_price=?,unit_sales_price=?,display=?,created_by=? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, data.getMedicineName());
        ps.setInt(2, data.getCompany().getCompanyId());
        if (data.getLocation() != null) {
            ps.setInt(3, data.getLocation().getLocationId());
        } else {
            ps.setNull(3, java.sql.Types.INTEGER);
        }

        if (data.getMedicineType() != null) {
            ps.setInt(4, data.getMedicineType().getTypeId());
        } else {
            ps.setNull(4, java.sql.Types.INTEGER);
        }

        if (data.getUnit() != null) {
            ps.setInt(5, data.getUnit().getUnitId());
        } else {
            ps.setNull(5, java.sql.Types.INTEGER);
        }
        ps.setDouble(6, data.getUnitPurchase());
        ps.setDouble(7, data.getUnitSales());
        ps.setInt(8, data.getDisplay());
        ps.setInt(9, data.getUser().getUserId());
        ps.setInt(10, data.getMedicineId());
        ps.executeUpdate();
        data = find(String.valueOf(data.getMedicineId()));
        return data;
    }

    @Override
    public boolean delete(Medicine data) {
        try {
            String sql = "DELETE FROM medicine WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, data.getMedicineId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("MedicineDao:delete:Error..." + e);
            return false;
        }
        return true;
    }

    @Override
    public Medicine find(String id) {
        Medicine data = new Medicine();
        try {
            String sql = "SELECT * FROM medicine WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CompanyDao companyDao = new CompanyDao();
                Company company = companyDao.find(String.valueOf(rs.getInt("company_id")));
                data.setCompany(company);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                MedicineTypeDao typeDao = new MedicineTypeDao();
                data.setMedicineType(typeDao.find(String.valueOf(rs.getInt("medicine_type"))));
                UnitDao unitDao = new UnitDao();
                Unit unit = unitDao.find(String.valueOf(rs.getInt("unit_id")));
                data.setUnit(unit);
                LocationDao locationDao = new LocationDao();
                Location location = locationDao.find(String.valueOf(rs.getInt("location_id")));
                data.setLocation(location);
                data.setMedicineId(rs.getInt("id"));
                data.setMedicineName(rs.getString("name"));
                data.setUnitPurchase(rs.getDouble("unit_purchase_price"));
                data.setUnitSales(rs.getDouble("unit_sales_price"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
            }
        } catch (SQLException e) {
            System.out.println("MedicineDao:Find:SQL Error........." + e);
        }
        return data;
    }

    public Medicine findByName(String name) {
        Medicine data = new Medicine();
        try {
            String sql = "SELECT * FROM medicine WHERE name = ? limit 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CompanyDao companyDao = new CompanyDao();
                Company company = companyDao.find(String.valueOf(rs.getInt("company_id")));
                data.setCompany(company);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                MedicineTypeDao typeDao = new MedicineTypeDao();
                data.setMedicineType(typeDao.find(String.valueOf(rs.getInt("medicine_type"))));
                UnitDao unitDao = new UnitDao();
                Unit unit = unitDao.find(String.valueOf(rs.getInt("unit_id")));
                data.setUnit(unit);
                LocationDao locationDao = new LocationDao();
                Location location = locationDao.find(String.valueOf(rs.getInt("location_id")));
                data.setLocation(location);
                data.setMedicineId(rs.getInt("id"));
                data.setMedicineName(rs.getString("name"));
                data.setUnitPurchase(rs.getDouble("unit_purchase_price"));
                data.setUnitSales(rs.getDouble("unit_sales_price"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
            }
        } catch (SQLException e) {
            System.out.println("MedicineDao:FindByName:SQL Error........." + e);
        }
        return data;
    }

    @Override
    public List<Medicine> display() {
        List<Medicine> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medicine ORDER BY name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Medicine data = new Medicine();
                CompanyDao companyDao = new CompanyDao();
                Company company = companyDao.find(String.valueOf(rs.getInt("company_id")));
                data.setCompany(company);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                MedicineTypeDao typeDao = new MedicineTypeDao();
                data.setMedicineType(typeDao.find(String.valueOf(rs.getInt("medicine_type"))));
                UnitDao unitDao = new UnitDao();
                Unit unit = unitDao.find(String.valueOf(rs.getInt("unit_id")));
                data.setUnit(unit);
                LocationDao locationDao = new LocationDao();
                Location location = locationDao.find(String.valueOf(rs.getInt("location_id")));
                data.setLocation(location);
                data.setMedicineId(rs.getInt("id"));
                data.setMedicineName(rs.getString("name"));
                data.setUnitPurchase(rs.getDouble("unit_purchase_price"));
                data.setUnitSales(rs.getDouble("unit_sales_price"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("MedicineDao:Display:SQL Error........." + e);
        }
        return list;
    }

    public List<Medicine> getMatch(String match) {
        List<Medicine> list = new ArrayList<>();
        try {
            match = match.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
            String sql = "SELECT * FROM medicine WHERE name LIKE ? ESCAPE '!' ORDER BY name";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + match + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicine data = new Medicine();
                CompanyDao companyDao = new CompanyDao();
                Company company = companyDao.find(String.valueOf(rs.getInt("company_id")));
                data.setCompany(company);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                MedicineTypeDao typeDao = new MedicineTypeDao();
                data.setMedicineType(typeDao.find(String.valueOf(rs.getInt("medicine_type"))));;
                UnitDao unitDao = new UnitDao();
                Unit unit = unitDao.find(String.valueOf(rs.getInt("unit_id")));
                data.setUnit(unit);
                LocationDao locationDao = new LocationDao();
                Location location = locationDao.find(String.valueOf(rs.getInt("location_id")));
                data.setLocation(location);
                data.setMedicineId(rs.getInt("id"));
                data.setMedicineName(rs.getString("name"));
                data.setUnitPurchase(rs.getDouble("unit_purchase_price"));
                data.setUnitSales(rs.getDouble("unit_sales_price"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("MedicineDao:getMatch:SQL Error........." + e);
        } 
        return list;
    }

    public List<Medicine> medicineUnderCompany(int COMPANY_ID) {
        List<Medicine> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medicine where company_id=" + COMPANY_ID + " ORDER BY name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Medicine data = new Medicine();
                CompanyDao companyDao = new CompanyDao();
                Company company = companyDao.find(String.valueOf(rs.getInt("company_id")));
                data.setCompany(company);
                data.setCreatedAt(rs.getTimestamp("created_at"));
                data.setDisplay(rs.getInt("display"));
                MedicineTypeDao typeDao = new MedicineTypeDao();
                data.setMedicineType(typeDao.find(String.valueOf(rs.getInt("medicine_type"))));
                UnitDao unitDao = new UnitDao();
                Unit unit = unitDao.find(String.valueOf(rs.getInt("unit_id")));
                data.setUnit(unit);
                LocationDao locationDao = new LocationDao();
                Location location = locationDao.find(String.valueOf(rs.getInt("location_id")));
                data.setLocation(location);
                data.setMedicineId(rs.getInt("id"));
                data.setMedicineName(rs.getString("name"));
                data.setUnitPurchase(rs.getDouble("unit_purchase_price"));
                data.setUnitSales(rs.getDouble("unit_sales_price"));
                UserDao userDao = new UserDao();
                User user = userDao.find(String.valueOf(rs.getInt("created_by")));
                data.setUser(user);
                list.add(data);
            }
        } catch (SQLException e) {
            System.out.println("MedicineDao:medicineUnderCompany:SQL Error........." + e);
        }
        return list;
    }

}
