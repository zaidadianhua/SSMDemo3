package com.gx.domain;

public class User {
    private int uname;
    private int upwd;

    public User(int uname, int upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public User() {
    }

    public int getUname() {
        return uname;
    }

    public void setUname(int uname) {
        this.uname = uname;
    }

    public int getUpwd() {
        return upwd;
    }

    public void setUpwd(int upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname=" + uname +
                ", upwd=" + upwd +
                '}';
    }
}
