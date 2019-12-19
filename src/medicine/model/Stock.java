package medicine.model;

import java.util.Date;

public class Stock {
    private int sockId;
    private Medicine medicine;
    private int stockQuantity;
    private int startingStock;
    private int reorderLevel;
    private Date expiracyDate;

    public int getSockId() {
        return sockId;
    }

    public void setSockId(int sockId) {
        this.sockId = sockId;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getStartingStock() {
        return startingStock;
    }

    public void setStartingStock(int startingStock) {
        this.startingStock = startingStock;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Date getExpiracyDate() {
        return expiracyDate;
    }

    public void setExpiracyDate(Date expiracyDate) {
        this.expiracyDate = expiracyDate;
    }
    
    
}
