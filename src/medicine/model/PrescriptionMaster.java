package medicine.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrescriptionMaster {

    private long prescriptionId;
    private Client client;
    private int visitNo;
    private double paidAmount;
    private Date date;
    private User user;
    private Timestamp createdAt;
    private List<PrescriptionDetails> details = new ArrayList<>();

    public long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(int visitNo) {
        this.visitNo = visitNo;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public List<PrescriptionDetails> getDetails() {
        return details;
    }

    public void setDetails(List<PrescriptionDetails> details) {
        this.details = details;
    }
    
    @Override
    public String toString() {
        return "" + prescriptionId;
    }

}
