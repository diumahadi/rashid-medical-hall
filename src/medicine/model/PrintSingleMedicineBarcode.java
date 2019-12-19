package medicine.model;

import java.sql.Timestamp;

public class PrintSingleMedicineBarcode {
    private int printId;
    private Medicine medicine;
    private User user;
    private Timestamp createdAt;

    public int getPrintId() {
        return printId;
    }

    public void setPrintId(int printId) {
        this.printId = printId;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
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
        return medicine.getMedicineName();
    }    
    
}
