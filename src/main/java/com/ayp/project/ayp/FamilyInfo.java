package com.ayp.project.ayp;

import javax.persistence.*;

@Entity
@Table(name="FamilyInfo")
public class FamilyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;

    private String Spouce;

    private String DobSpouce;

    private String Child1;

    private String DobChild1;

    private String Child2;

    private String DobChild2;

    private String Child3;

    private String DobChild3;

    private int RegId;

    public String getSpouce() {
        return Spouce;
    }

    public void setSpouce(String spouce) {
        Spouce = spouce;
    }

    public String getDobSpouce() {
        return DobSpouce;
    }

    public void setDobSpouce(String dobSpouce) {
        DobSpouce = dobSpouce;
    }

    public String getChild1() {
        return Child1;
    }

    public void setChild1(String child1) {
        Child1 = child1;
    }

    public String getDobChild1() {
        return DobChild1;
    }

    public void setDobChild1(String dobChild1) {
        DobChild1 = dobChild1;
    }

    public String getChild2() {
        return Child2;
    }

    public void setChild2(String child2) {
        Child2 = child2;
    }

    public String getDobChild2() {
        return DobChild2;
    }

    public void setDobChild2(String dobChild2) {
        DobChild2 = dobChild2;
    }

    public String getChild3() {
        return Child3;
    }

    public void setChild3(String child3) {
        Child3 = child3;
    }

    public String getDobChild3() {
        return DobChild3;
    }

    public void setDobChild3(String dobChild3) {
        DobChild3 = dobChild3;
    }

    public int getRegId() {
        return RegId;
    }

    public void setRegId(int regId) {
        RegId = regId;
    }

    public FamilyInfo(String spouce, String dobSpouce, String child1, String dobChild1, String child2, String dobChild2, String child3, String dobChild3, int regId) {
        Spouce = spouce;
        DobSpouce = dobSpouce;
        Child1 = child1;
        DobChild1 = dobChild1;
        Child2 = child2;
        DobChild2 = dobChild2;
        Child3 = child3;
        DobChild3 = dobChild3;
        RegId = regId;
    }

    public FamilyInfo()
    {

    }
}
