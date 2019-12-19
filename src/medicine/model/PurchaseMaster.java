package medicine.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseMaster {
    private long purchaseId;
    private String invoiceNo;
    private Client client;
    private PSTitle pSTitle;
    private Date purchaseDate;
    private double paidAmount;
    private double dueAmount;
    private User user;
    private Timestamp createdAt;
    private List<PurchaseDetails> details=new ArrayList<>();

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PSTitle getpSTitle() {
        return pSTitle;
    }

    public void setpSTitle(PSTitle pSTitle) {
        this.pSTitle = pSTitle;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }   

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<PurchaseDetails> getDetails() {
        return details;
    }

    public void setDetails(List<PurchaseDetails> details) {
        this.details = details;
    }  

    @Override
    public String toString() {
        return ""+purchaseId;
    }   
    
    
}
