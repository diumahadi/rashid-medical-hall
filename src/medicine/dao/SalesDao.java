package medicine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import medicine.exception.StockError;
import medicine.model.SalesDetails;
import medicine.model.SalesMaster;
import medicine.model.Stock;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class SalesDao implements BaseDao<SalesMaster> {

    private final Connection connection;
    private StockDao stockDao;
    private SalesMasterDao masterDao;
    private SalesDetailsDao detailsDao;
    private List<SalesDetails> detailsList = new ArrayList<>();

    public SalesDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public SalesMaster save(SalesMaster data) {
        SalesMaster master = null;
        try {
            connection.setAutoCommit(false);
            masterDao = new SalesMasterDao();
            master = masterDao.save(data, connection);

            for (SalesDetails det : data.getDetails()) {
                detailsDao = new SalesDetailsDao();
                detailsDao.save(det, master, connection);
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() - det.getQuantity());
                stockDao.update(stock, det.getMedicine(), connection);
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:SalesDao...:Save..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:SalesDao...:Save...rollback" + e1);
            }
        }
        return master;
    }

    @Override
    public SalesMaster update(SalesMaster data) {
        try {
            connection.setAutoCommit(false);
            detailsDao = new SalesDetailsDao();
            for (SalesDetails det : detailsDao.find(data)) {
                detailsDao = new SalesDetailsDao();
                detailsDao.delete(det, connection);
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() + det.getQuantity());
                stockDao.update(stock, stock.getMedicine(), connection);
            }

            for (SalesDetails det : data.getDetails()) {
                detailsDao = new SalesDetailsDao();
                detailsDao.save(det, data, connection);
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                if (stock.getStockQuantity() >= det.getQuantity()) {
                    stock.setStockQuantity(stock.getStockQuantity() - det.getQuantity());
                    stockDao.update(stock, stock.getMedicine(), connection);
                } else {
                    throw new StockError("You don't have sufficient stock !!!!");
                }
            }

            masterDao = new SalesMasterDao();
            masterDao.update(data, connection);

            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:PurchaseMasterDao...:Update..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:PurchaseMasterDao...:Update...rollback" + e1);
            }

        }
        return data;
    }

    @Override
    public boolean delete(SalesMaster data) {
        try {
            connection.setAutoCommit(false);
            for (SalesDetails det : data.getDetails()) {
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() + det.getQuantity());
                stockDao.update(stock, det.getMedicine(), connection);
                detailsDao = new SalesDetailsDao();
                detailsDao.delete(det);
            }
            masterDao = new SalesMasterDao();
            masterDao.delete(data);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:SalesDao...:Delete..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:SalesDao...:Delete...rollback" + e1);
            }

        }
        return true;
    }

    @Override
    public SalesMaster find(String id) {
        masterDao = new SalesMasterDao();
        SalesMaster master = masterDao.find(String.valueOf(id));
        detailsDao = new SalesDetailsDao();
        detailsList = detailsDao.find(master);
        master.setDetails(detailsList);
        return master;
    }

    @Override
    public List<SalesMaster> display() {
        List<SalesMaster> list = new ArrayList<>();
        masterDao = new SalesMasterDao();
        for (SalesMaster master : masterDao.display()) {
            detailsDao = new SalesDetailsDao();
            detailsList = detailsDao.find(master);
            master.setDetails(detailsList);
            list.add(master);
        }
        return list;
    }

}
