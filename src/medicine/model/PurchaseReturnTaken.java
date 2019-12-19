package medicine.model;
import java.sql.Timestamp;
import java.util.Date;

public class PurchaseReturnTaken {
    private long takenId;
    private PurchaseReturnDetails returnDetails;
    private int quantity;
    private Date takenDate;
    private User user;
    private Timestamp createdAt;

    public long getTakenId() {
        return takenId;
    }

    public void setTakenId(long takenId) {
        this.takenId = takenId;
    }

    public PurchaseReturnDetails getReturnDetails() {
        return returnDetails;
    }

    public void setReturnDetails(PurchaseReturnDetails returnDetails) {
        this.returnDetails = returnDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
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

    
    
}
