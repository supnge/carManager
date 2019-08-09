package com.carManager.domain;

public class TAdmin {
    private Integer userid;

    private String username;

    private String userpw;

    private String type;

    public TAdmin( String username, String userpw, String type) {
        this.username = username;
        this.userpw = userpw;
        this.type = type;
    }

    public TAdmin() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw == null ? null : userpw.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}