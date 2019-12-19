package medicine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import medicine.model.PurchaseReturnDetails;
import medicine.model.PurchaseReturnMaster;
import medicine.model.PurchaseReturnTaken;
import medicine.model.Stock;
import medicine.service.BaseDao;
import medicine.util.DbUtil;

public class PurchaseReturnDao implements BaseDao<PurchaseReturnMaster> {

    private final Connection connection;
    private StockDao stockDao;
    private PurchaseReturnMasterDao masterDao;
    private PurchaseReturnDeatilsDao detailsDao;
    private PurchaseReturnTakenDao takenDao;

    public PurchaseReturnDao() {
        connection = DbUtil.getConnection();
    }

    @Override
    public PurchaseReturnMaster save(PurchaseReturnMaster data) {
        PurchaseReturnMaster master = null;
        try {
            connection.setAutoCommit(false);
            masterDao = new PurchaseReturnMasterDao();
            master = masterDao.save(data);
            for (PurchaseReturnDetails det : data.getDetails()) {
                detailsDao = new PurchaseReturnDeatilsDao();
                det.setPurchaseReturnMaster(master);
                detailsDao.save(det, master, connection);
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() - det.getReturnQuantity());
                stockDao.update(stock, det.getMedicine(), connection);
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:PurchaseReturnDetailsDao...:Save...rollback" + e1);
            }
            throw new Error("Error...:PurchaseReturnDetailsDao:Save:..." + e);
        }
        return master;
    }

    @Override
    public PurchaseReturnMaster update(PurchaseReturnMaster data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PurchaseReturnTaken returnTaken(PurchaseReturnTaken data, PurchaseReturnDetails det) {
        try {
            connection.setAutoCommit(false);
            takenDao = new PurchaseReturnTakenDao();
            takenDao.save(data, det, connection);

            stockDao = new StockDao();
            Stock stock = stockDao.find(det.getMedicine());
            stock.setStockQuantity(stock.getStockQuantity() + det.getReturnQuantity());
            stockDao.update(stock, det.getMedicine(), connection);

            detailsDao = new PurchaseReturnDeatilsDao();
            PurchaseReturnDetails oldDetails = detailsDao.findSingleResult(String.valueOf(det.getDetailId()));
            det.setSubmitQuantity(oldDetails.getSubmitQuantity() + data.getQuantity());

            detailsDao = new PurchaseReturnDeatilsDao();
            detailsDao.update(det, connection);
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:PurchaseReturnDetailsDao...:returnTaken...rollback" + e1);
            }
            throw new Error("Error...:PurchaseReturnDetailsDao:returnTaken:..." + e);
        }
        return data;
    }

    public boolean returnDelete(PurchaseReturnMaster master) {
        try {
            connection.setAutoCommit(false);
            detailsDao = new PurchaseReturnDeatilsDao();
            for (PurchaseReturnDetails det : detailsDao.childUnderParent(master)) {
                
                takenDao=new PurchaseReturnTakenDao();
                for(PurchaseReturnTaken t:takenDao.childUnderSingleDetail(det)){
                    stockDao = new StockDao();
                    Stock stock = stockDao.find(det.getMedicine());
                    stock.setStockQuantity(stock.getStockQuantity() - t.getQuantity());
                    stockDao.update(stock, det.getMedicine(), connection);
                }
                
                detailsDao = new PurchaseReturnDeatilsDao();
                det.setSubmitQuantity(0);
                detailsDao.update(det, connection);
                
                takenDao = new PurchaseReturnTakenDao();
                takenDao.deleteUnderDetails(det, connection);
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Error...:PurchaseReturnDetailsDao...:returnDelete...rollback" + e1);
            }
            throw new Error("Error...:PurchaseReturnDetailsDao:returnDelete:..." + e);
        }
        return true;
    }

    public boolean update(HashMap tempMap) {

        try {
            Set set = tempMap.entrySet();
            Iterator i = set.iterator();
            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                PurchaseReturnDetails det = (PurchaseReturnDetails) tempMap.get(me.getKey());
                detailsDao = new PurchaseReturnDeatilsDao();
                det.setPurchaseReturnMaster(det.getPurchaseReturnMaster());
                detailsDao.update(det, det.getPurchaseReturnMaster(), connection);

                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity());
                stockDao.update(stock);

            }
        } catch (Exception e) {
            System.out.println("Error.." + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(PurchaseReturnMaster data) {
        try {
            for (PurchaseReturnDetails det : data.getDetails()) {
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() + det.getReturnQuantity());
                stockDao.update(stock);
                detailsDao = new PurchaseReturnDeatilsDao();
                detailsDao.deleteChildRecords(data, connection);
            }
            masterDao = new PurchaseReturnMasterDao();
            masterDao.delete(data);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public PurchaseReturnMaster find(String id) {
        masterDao = new PurchaseReturnMasterDao();
        PurchaseReturnMaster master = masterDao.find(String.valueOf(id));
        detailsDao = new PurchaseReturnDeatilsDao();
        List<PurchaseReturnDetails> detailsList = detailsDao.childUnderParent(master);
        master.setDetails(detailsList);
        return master;
    }

    @Override
    public List<PurchaseReturnMaster> display() {
        List<PurchaseReturnMaster> list = new ArrayList<>();
        masterDao = new PurchaseReturnMasterDao();
        for (PurchaseReturnMaster master : masterDao.display()) {
            detailsDao = new PurchaseReturnDeatilsDao();
            List<PurchaseReturnDetails> detailsList = detailsDao.childUnderParent(master);
            master.setDetails(detailsList);
            list.add(master);
        }
        return list;
    }

}
