package medicine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import medicine.model.Medicine;
import medicine.model.Stock;
import medicine.service.FormOperation;
import medicine.util.DbUtil;

public class MedicineStockDao implements FormOperation<Medicine> {

    private final Connection connection;
    private MedicineDao medicineDao;
    private StockDao stockDao;

    public MedicineStockDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public boolean save(Medicine data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Stock savem(Medicine data) {
        Stock stock = null;
        try {
            connection.setAutoCommit(false);
            medicineDao = new MedicineDao();
            Medicine med = medicineDao.savem(data, connection);
            stockDao = new StockDao();
            stock = stockDao.savem(data.getStock(), med, connection);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:MedicineStockDao...:insertm..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:MedicineStockDao...:insertm...rollback" + e1);
            }

        }
        return stock;
    }

    public Stock updatem(Medicine data) {
        Stock stock = null;
        try {
            connection.setAutoCommit(false);
            medicineDao = new MedicineDao();
            Medicine med = medicineDao.updatem(data, connection);
            stockDao = new StockDao();
            stock = stockDao.update(data.getStock(), med, connection);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:MedicineStockDao...:updatem..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:MedicineStockDao...:updatem...rollback" + e1);
            }
        }
        return stock;
    }

    @Override
    public boolean update(Medicine data) {
        try {
            medicineDao = new MedicineDao();
            medicineDao.update(data);
            stockDao = new StockDao();
            Stock stock = data.getStock();
            stock.setMedicine(data);
            stockDao.update(stock);
        } catch (Exception e) {
            System.out.println("MedicineStockDao:Update:Error..." + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Medicine data) {
        stockDao = new StockDao();
        return stockDao.delete(data.getStock()) && medicineDao.delete(data);
    }

    @Override
    public Medicine find(String medicineId) {
        medicineDao = new MedicineDao();
        Medicine medicine = medicineDao.find(medicineId);
        stockDao = new StockDao();
        Stock stock = stockDao.find(medicineId);
        medicine.setStock(stock);
        return medicine;
    }

    public Medicine findByName(String medicineName) {
        medicineDao = new MedicineDao();
        Medicine medicine = medicineDao.findByName(medicineName);
        stockDao = new StockDao();
        medicine.setStock(stockDao.find(String.valueOf(medicine.getMedicineId())));
        return medicine;
    }

    @Override
    public List<Medicine> display() {
        List<Medicine> medicineList = new ArrayList<>();
        medicineDao = new MedicineDao();
        for (Medicine m : medicineDao.display()) {
            stockDao = new StockDao();
            m.setStock(stockDao.find(String.valueOf(m.getMedicineId())));
            medicineList.add(m);
        }
        return medicineList;
    }

    public List<Medicine> getMedicineUnderCompany(int COMPANY_ID) {
        List<Medicine> medicineList = new ArrayList<>();
        medicineDao = new MedicineDao();
        for (Medicine m : medicineDao.medicineUnderCompany(COMPANY_ID)) {
            stockDao = new StockDao();
            m.setStock(stockDao.find(String.valueOf(m.getMedicineId())));
            medicineList.add(m);
        }
        return medicineList;
    }

    public boolean isStockAvailable(Medicine med) {
        stockDao = new StockDao();
        Stock st = stockDao.find(String.valueOf(med.getMedicineId()));
        return st.getStockQuantity() > 0;
    }

}
