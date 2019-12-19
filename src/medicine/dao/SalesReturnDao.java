package medicine.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import medicine.model.SalesReturnDetails;
import medicine.model.SalesReturnMaster;
import medicine.model.Stock;
import medicine.service.FormOperation;
import medicine.util.DbUtil;

public class SalesReturnDao implements FormOperation<SalesReturnMaster>{
    
    private final Connection connection;
    private StockDao stockDao;
    private SalesReturnMasterDao masterDao;
    private SalesReturnDetailsDao detailsDao;
    private List<SalesReturnDetails> detailsList;
    
    public SalesReturnDao() {
        detailsList = new ArrayList<>();
         connection = DbUtil.getConnection();
    }

    @Override
    public boolean save(SalesReturnMaster data) {
        try {
            connection.setAutoCommit(false);
            masterDao = new SalesReturnMasterDao();
            SalesReturnMaster master = masterDao.save(data);
            for (SalesReturnDetails det : data.getDetails()) {
                detailsDao = new SalesReturnDetailsDao();
                det.setSalesReturnMaster(master);
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() + det.getReturnQuantity());
                stockDao.update(stock,det.getMedicine(), connection);
                detailsDao.save(det,connection);
            }
            connection.commit();
        } catch (Exception e) {
            System.out.println("SalesReturnDao:Insert:Error...."+e);
            try {
                connection.rollback();                
                System.out.println("SalesReturnDao:Insert:roolback...."+e);
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(SalesReturnDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean update(SalesReturnMaster data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(SalesReturnMaster data) {
        try {
            for (SalesReturnDetails det : data.getDetails()) {
                stockDao = new StockDao();
                Stock stock = stockDao.find(det.getMedicine());
                stock.setStockQuantity(stock.getStockQuantity() - det.getReturnQuantity());
                stockDao.update(stock);
                detailsDao = new SalesReturnDetailsDao();
                detailsDao.delete(det);
            }
            masterDao = new SalesReturnMasterDao();
            masterDao.delete(data);
        } catch (Exception e) {
            System.out.println("SalesReturnDao:Delete:Error..."+e);
            return false;
        }
        return true;
    }

    @Override
    public SalesReturnMaster find(String id) {
        masterDao = new SalesReturnMasterDao();
        SalesReturnMaster master = masterDao.find(String.valueOf(id));
        detailsDao = new SalesReturnDetailsDao();
        detailsList = detailsDao.find(Long.parseLong(id));
        master.setDetails(detailsList);
        return master;
    }

    @Override
    public List<SalesReturnMaster> display() {
        List<SalesReturnMaster> list = new ArrayList<>();
        masterDao = new SalesReturnMasterDao();
        for (SalesReturnMaster master : masterDao.display()) {
            detailsDao = new SalesReturnDetailsDao();
            detailsList = detailsDao.find(master.getReturnId());
            master.setDetails(detailsList);
            list.add(master);
        }
        return list;
    }
    
}
