package medicine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import medicine.exception.StockError;
import medicine.model.PurchaseDetails;
import medicine.model.PurchaseMaster;
import medicine.model.Stock;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class PurchaseDao implements BaseDao<PurchaseMaster> {

    private final Connection connection;
    private StockDao stockDao;
    private PurchaseMasterDao masterDao;
    private PurchaseDetailsDao detailsDao;

    public PurchaseDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public PurchaseMaster save(PurchaseMaster data) {
        PurchaseMaster master = null;
        try {
            connection.setAutoCommit(false);
            masterDao = new PurchaseMasterDao();
            master = masterDao.save(data, connection);

            for (PurchaseDetails det : data.getDetails()) {
                detailsDao = new PurchaseDetailsDao();
                detailsDao.save(det, master, connection);
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() + det.getQuantity());
                stockDao.update(stock, det.getMedicine(), connection);
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:PurchaseMasterDao...:Save..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:PurchaseMasterDao...:Save...rollback" + e1);
            }

        }
        return master;
    }

    @Override
    public PurchaseMaster update(PurchaseMaster data) {
        try {
            connection.setAutoCommit(false);
            detailsDao = new PurchaseDetailsDao();
            for (PurchaseDetails det : detailsDao.find(data.getPurchaseId())) {
                detailsDao = new PurchaseDetailsDao();
                detailsDao.delete(det);
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                if (stock.getStockQuantity() >= det.getQuantity()) {
                    stock.setStockQuantity(stock.getStockQuantity() - det.getQuantity());
                    stockDao.update(stock, stock.getMedicine(), connection);
                } else {
                    throw new StockError("You don't have sufficient stock !!!!");
                }
            }

            for (PurchaseDetails det : data.getDetails()) {
                detailsDao = new PurchaseDetailsDao();
                detailsDao.save(det, data, connection);
                
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() + det.getQuantity());
                stockDao.update(stock, stock.getMedicine(), connection);
            }

            masterDao = new PurchaseMasterDao();
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
    public boolean delete(PurchaseMaster data) {
        try {
            connection.setAutoCommit(false);
            for (PurchaseDetails det : data.getDetails()) {
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() - det.getQuantity());
                stockDao.update(stock, det.getMedicine(), connection);
                detailsDao = new PurchaseDetailsDao();
                detailsDao.delete(det);
            }
            masterDao = new PurchaseMasterDao();
            masterDao.delete(data);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error...:PurchaseDao...:Delete..." + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:PurchaseDao...:Delete...rollback" + e1);
            }

        }
        return true;
    }

    @Override
    public PurchaseMaster find(String id) {
        masterDao = new PurchaseMasterDao();
        PurchaseMaster master = masterDao.find(id);
        detailsDao = new PurchaseDetailsDao();
        master.setDetails(detailsDao.find(master.getPurchaseId()));
        return master;
    }

    public PurchaseMaster findByInvoice(String invoiceId) {
        masterDao = new PurchaseMasterDao();
        PurchaseMaster master = masterDao.findByInvoice(invoiceId);
        detailsDao = new PurchaseDetailsDao();
        master.setDetails(detailsDao.find(master.getPurchaseId()));
        return master;
    }

    @Override
    public List<PurchaseMaster> display() {
        List<PurchaseMaster> list = new ArrayList<>();
        masterDao = new PurchaseMasterDao();
        for (PurchaseMaster master : masterDao.display()) {
            detailsDao = new PurchaseDetailsDao();
            master.setDetails(detailsDao.find(master.getPurchaseId()));
            list.add(master);
        }
        return list;
    }

}
