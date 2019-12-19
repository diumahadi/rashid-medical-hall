package medicine.model;

import java.util.Date;

public class PurchaseDetails {
    private long detailsId;
    private PurchaseMaster purchaseMaster;
    private Medicine medicine;
    private Unit unit;
    private int quantity;
    private double purchasePrice;
    private double salesPrice;
    private Date expiracyDate;

    public long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(long detailsId) {
        this.detailsId = detailsId;
    }

    public PurchaseMaster getPurchaseMaster() {
        return purchaseMaster;
    }

    public void setPurchaseMaster(PurchaseMaster purchaseMaster) {
        this.purchaseMaster = purchaseMaster;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return ""+detailsId;
    }
    
}
