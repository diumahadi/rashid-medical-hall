package medicine.model;

import java.sql.Timestamp;

public class PSTitle {
    private int psId;
    private String title;
    private int display;
    private User user;
    private Timestamp createdAt;

    public int getPsId() {
        return psId;
    }

    public void setPsId(int psId) {
        this.psId = psId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return title;
    }
    
    
}
