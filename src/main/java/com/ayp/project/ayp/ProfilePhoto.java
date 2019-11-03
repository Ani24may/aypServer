package com.ayp.project.ayp;

import javax.persistence.*;

@Entity
@Table(name="ProfilePhoto")
public class ProfilePhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private int RegId;

    private String path;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getRegId() {
        return RegId;
    }

    public void setRegId(int regId) {
        RegId = regId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public ProfilePhoto(int regId, String path) {
        RegId = regId;
        this.path = path;
    }

    public ProfilePhoto()
    {

    }
}
