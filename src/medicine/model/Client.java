package medicine.model;

import java.sql.Timestamp;
import java.util.Date;

public class Client {

    private long clientId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private int clientType;
    private String mobile;
    private String bloodGroup;
    private Company company;
    private District presentDistrict;
    private String address;
    private District permanentDistrict;
    private String permanentAddress;
    private double startingDue;
    private int display;
    private User user;
    private Timestamp createdAt;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public District getPresentDistrict() {
        return presentDistrict;
    }

    public void setPresentDistrict(District presentDistrict) {
        this.presentDistrict = presentDistrict;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public District getPermanentDistrict() {
        return permanentDistrict;
    }

    public void setPermanentDistrict(District permanentDistrict) {
        this.permanentDistrict = permanentDistrict;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public double getStartingDue() {
        return startingDue;
    }

    public void setStartingDue(double startingDue) {
        this.startingDue = startingDue;
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

        if (this.clientType == 1) {
            return firstName + ((mobile !=null) ? " - " +mobile:"");
        } else if (this.clientType == 2) {
            return firstName;
        } else if (this.clientType == 3) {
            return firstName + " - " + this.getCompany().getCompanyName();
        } else if (this.clientType == 4) {
            return clientId + " - " + firstName;
        }else{
            return "";
        }
    }

}
