package medicine.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesReturnMaster {
    private long returnId;
    private Client client;
    private Date returnDate;
    private User user;
    private Timestamp createdAt;    
    private List<SalesReturnDetails> details = new ArrayList<>();

    public long getReturnId() {
        return returnId;
    }

    public void setReturnId(long returnId) {
        this.returnId = returnId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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

    public List<SalesReturnDetails> getDetails() {
        return details;
    }

    public void setDetails(List<SalesReturnDetails> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return ""+returnId;
    }
    
    
}
