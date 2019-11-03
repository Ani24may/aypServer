package com.ayp.project.ayp;

import javax.persistence.*;

@Entity
@Table(name="Registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RegId;

    @Column(name="FirstName")
    private String FirstName;

    @Column(name="LastName")
    private String LastName;

    @Column(name="Password")
    private String Password;

    @Column(name="Email")
    private String Email;

    @Column(name="PhoneNo")
    private String PhoneNo;

    @Column(name="Category")
    private String Category;


    public int getRegId() {
        return RegId;
    }

    public void setRegId(int id) {
        RegId = id;
    }
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastname() {
        return LastName;
    }

    public void setLastname(String lastname) {
        LastName = lastname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Registration()
    {

    }
    public Registration(String firstName,String lastname,String password,String email,String phoneNo,String category)
    {
        this.setFirstName(firstName);
        this.setLastname(lastname);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhoneNo(phoneNo);
        this.setCategory(category);
    }
}
