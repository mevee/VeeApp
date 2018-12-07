package com.example.vee.database;

public class User {
    public String uid;
    public String name;
    public String email;
    public String status;
    public String mobile;
    public String devicetoken;
    public String imgurl;
    public String thumb_img;
    public String isonline;

    public User() {
    }

    public User(String uid, String name, String email, String status, String mobile, String devicetoken, String imgurl, String thumb_img, String isonline) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.status = status;
        this.mobile = mobile;
        this.devicetoken = devicetoken;
        this.imgurl = imgurl;
        this.thumb_img = thumb_img;
        this.isonline = isonline;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDevicetoken() {
        return devicetoken;
    }

    public void setDevicetoken(String devicetoken) {
        this.devicetoken = devicetoken;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getThumb_img() {
        return thumb_img;
    }

    public void setThumb_img(String thumb_img) {
        this.thumb_img = thumb_img;
    }

    public String getIsonline() {
        return isonline;
    }

    public void setIsonline(String isonline) {
        this.isonline = isonline;
    }
}
