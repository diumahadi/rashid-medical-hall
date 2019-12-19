package medicine.model;

import java.sql.Timestamp;

public class Medicine {
    private int medicineId;
    private String medicineName;
    private Company company;
    private Location location;
    private MedicineType medicineType;
    private Unit unit;
    private double unitPurchase;
    private double unitSales;//mrp
    private int display;
    private User user;
    private Timestamp createdAt;
    private Stock stock;
    
    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public MedicineType getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineType medicineType) {
        this.medicineType = medicineType;
    }


    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    
    public double getUnitPurchase() {
        return unitPurchase;
    }

    public void setUnitPurchase(double unitPurchase) {
        this.unitPurchase = unitPurchase;
    }

    public double getUnitSales() {
        return unitSales;
    }

    public void setUnitSales(double unitSales) {
        this.unitSales = unitSales;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        return this.medicineId*10;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medicine other = (Medicine) obj;
        return this.medicineId == other.medicineId;
    }
    
    

    @Override
    public String toString() {
        return medicineName;
    }   
    
}
