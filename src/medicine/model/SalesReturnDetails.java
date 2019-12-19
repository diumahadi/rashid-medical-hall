package medicine.model;

import java.sql.Timestamp;

public class SalesReturnDetails {
    private long detailId;
    private SalesReturnMaster salesReturnMaster;
    private Medicine medicine;
    private int returnQuantity;
    private double submitAmount;
    private Timestamp submitDate;

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
        this.detailId = detailId;
    }

    public SalesReturnMaster getSalesReturnMaster() {
        return salesReturnMaster;
    }

    public void setSalesReturnMaster(SalesReturnMaster salesReturnMaster) {
        this.salesReturnMaster = salesReturnMaster;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getReturnQuantity() {
        return returnQuantity;
    }

    public void setReturnQuantity(int returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    public double getSubmitAmount() {
        return submitAmount;
    }

    public void setSubmitAmount(double submitAmount) {
        this.submitAmount = submitAmount;
    }

    public Timestamp getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Timestamp submitDate) {
        this.submitDate = submitDate;
    }

    @Override
    public String toString() {
        return ""+detailId;
    }
    
    
}
