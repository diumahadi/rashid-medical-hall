package medicine.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesMaster {
    private long salesId;
    private Client client;
    private PSTitle psTitle;
    private Date salesDate;
    private double paidAmount;
    private double dueAmount;
    private User user;
    private Timestamp createdAt;
    private List<SalesDetails> details = new ArrayList();

    public long getSalesId() {
        return salesId;
    }

    public void setSalesId(long salesId) {
        this.salesId = salesId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PSTitle getPsTitle() {
        return psTitle;
    }

    public void setPsTitle(PSTitle psTitle) {
        this.psTitle = psTitle;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
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

    public List<SalesDetails> getDetails() {
        return details;
    }

    public void setDetails(List<SalesDetails> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return ""+salesId; 
    }    
    
    
}
