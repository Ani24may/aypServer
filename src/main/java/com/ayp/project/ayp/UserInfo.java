package com.ayp.project.ayp;

import javax.persistence.*;

@Entity
@Table(name="UserInfo")
public class UserInfo {

//    private static UserInfo userInfo=null;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @Column(name="FatherName")
    private String FatherName;

    private String Gotra;

    private String MobileNo2;

    private String LandLineNo1;

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getGotra() {
        return Gotra;
    }

    public void setGotra(String gotra) {
        Gotra = gotra;
    }

    public String getMobileNo2() {
        return MobileNo2;
    }

    public void setMobileNo2(String mobileNo2) {
        MobileNo2 = mobileNo2;
    }

    public String getLandLineNo1() {
        return LandLineNo1;
    }

    public void setLandLineNo1(String landLineNo1) {
        LandLineNo1 = landLineNo1;
    }

    public String getLandLineNo2() {
        return LandLineNo2;
    }

    public void setLandLineNo2(String landLineNo2) {
        LandLineNo2 = landLineNo2;
    }

    public String getAdd1() {
        return Add1;
    }

    public void setAdd1(String add1) {
        Add1 = add1;
    }

    public String getAdd2() {
        return Add2;
    }

    public void setAdd2(String add2) {
        Add2 = add2;
    }

    public String getAdd3() {
        return Add3;
    }

    public void setAdd3(String add3) {
        Add3 = add3;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String pin) {
        Pin = pin;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getDom() {
        return Dom;
    }

    public void setDom(String dom) {
        Dom = dom;
    }

    public int getRegId() {
        return RegId;
    }

    public void setRegId(int regId) {
        RegId = regId;
    }

    private String LandLineNo2;

    private String Add1;

    private String Add2;

    private String Add3;

    private String City;

    private String Pin;

    private String State;

    private String BloodGroup;

    private String Dob;

    private String Dom;

    private int RegId;

    public UserInfo()
    {

    }

    public UserInfo(String fatherName, String gotra, String mobileNo2, String landLineNo1, String landLineNo2, String add1, String add2, String add3, String city, String pin, String state, String bloodGroup, String dob, String dom, int regId) {
        FatherName = fatherName;
        Gotra = gotra;
        MobileNo2 = mobileNo2;
        LandLineNo1 = landLineNo1;
        LandLineNo2 = landLineNo2;
        Add1 = add1;
        Add2 = add2;
        Add3 = add3;
        City = city;
        Pin = pin;
        State = state;
        BloodGroup = bloodGroup;
        Dob = dob;
        Dom = dom;
        RegId = regId;
    }

//    public static UserInfo getInstance()
//    {
//        if(userInfo==null)
//        {
//            userInfo=new UserInfo();
//
//        }
//        return userInfo;
//    }
}
