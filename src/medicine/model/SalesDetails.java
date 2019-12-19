package medicine.model;

import java.util.Comparator;
import java.util.Date;

public class SalesDetails {
    private long detailsId;
    private SalesMaster salesMaster;
    private Medicine medicine;
    private int quantity;
    private double percentage;
    private double purchasePrice;
    private double salesPrice;
    private Date expiracyDate;

    public long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(long detailsId) {
        this.detailsId = detailsId;
    }

    public SalesMaster getSalesMaster() {
        return salesMaster;
    }

    public void setSalesMaster(SalesMaster salesMaster) {
        this.salesMaster = salesMaster;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Date getExpiracyDate() {
        return expiracyDate;
    }

    public void setExpiracyDate(Date expiracyDate) {
        this.expiracyDate = expiracyDate;
    }

    @Override
    public String toString() {
        return "DETAIL_ID: "+detailsId;
    }
    
}
