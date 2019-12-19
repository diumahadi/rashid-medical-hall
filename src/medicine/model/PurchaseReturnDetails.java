package medicine.model;

import java.util.Date;

public class PurchaseReturnDetails {
    private long detailId;
    private PurchaseReturnMaster purchaseReturnMaster;
    private Medicine medicine;
    private int returnQuantity;
    private int submitQuantity;
    private Date submitDate;

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
        this.detailId = detailId;
    }

    public PurchaseReturnMaster getPurchaseReturnMaster() {
        return purchaseReturnMaster;
    }

    public void setPurchaseReturnMaster(PurchaseReturnMaster purchaseReturnMaster) {
        this.purchaseReturnMaster = purchaseReturnMaster;
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

    public int getSubmitQuantity() {
        return submitQuantity;
    }

    public void setSubmitQuantity(int submitQuantity) {
        this.submitQuantity = submitQuantity;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    

    @Override
    public String toString() {
        return medicine+" ::"+returnQuantity+" >> "+submitQuantity; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
