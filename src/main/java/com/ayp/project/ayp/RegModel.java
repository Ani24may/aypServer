package com.ayp.project.ayp;

public class RegModel {


    private String FirstName;

    private String LastName;

    private String Password;

    private String Email;

    private String PhoneNo;

    private String Category;

    public String getFirstName() {
        return FirstName;
    }

    public String getLastname() {
        return LastName;
    }


    public String getPassword() {
        return Password;
    }


    public String getEmail() {
        return Email;
    }


    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public void setLastname(String lastname) {
        this.LastName = lastname;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public String getCategory() {
        return Category;
    }

}
