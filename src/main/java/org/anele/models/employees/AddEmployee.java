package org.anele.models.employees;

public class AddEmployee {

    private String firstname;
    private String middleName;
    private String lastname;
    private int employeeId;
    private LoginDetails loginDetails;

    public AddEmployee(String firstname, String middleName, String lastname, int employeeId, LoginDetails loginDetails) {
        this.firstname = firstname;
        this.middleName = middleName;
        this.lastname = lastname;
        this.employeeId = employeeId;
        this.loginDetails = loginDetails;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(LoginDetails loginDetails) {
        this.loginDetails = loginDetails;
    }
}
