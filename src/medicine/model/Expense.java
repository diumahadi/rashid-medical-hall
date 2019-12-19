package medicine.model;

import java.sql.Timestamp;
import java.util.Date;


public class Expense {
    private long expenseId;
    private ExpenseHead expenseHead;
    private double amount;
    private Date expenseDate;
    private String status;
    private User user;
    private Timestamp createdAt;

    public long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(long expenseId) {
        this.expenseId = expenseId;
    }

    public ExpenseHead getExpenseHead() {
        return expenseHead;
    }

    public void setExpenseHead(ExpenseHead expenseHead) {
        this.expenseHead = expenseHead;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return expenseId+": "+expenseHead;
    }
    
    
    
}
