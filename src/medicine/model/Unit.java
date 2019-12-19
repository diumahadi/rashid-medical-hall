package medicine.model;

import java.sql.Timestamp;

public class Unit {
    private int unitId;
    private String unitName;
    private int display;
    private User user;
    private Timestamp createdAt;

    public Unit() {
    }
    
    
    

    public Unit(int unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
    }    
    
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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

    @Override
    public String toString() {
        return unitName; 
    }
    
    
}
