package medicine.model;

import java.sql.Timestamp;
import java.util.Date;

public class MedicineConsume {
    private long consumeId;
    private Medicine medicine;
    private Date consumeDate;
    private String reason;
    private int quantity;
    private Double price;
    private User user;
    private Timestamp createdAt;

    public long getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(long consumeId) {
        this.consumeId = consumeId;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Date getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getQuantity() {
        return Math.abs(quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @Override
    public String toString() {
        return consumeId+": "+medicine; 
    }
    
    
}
