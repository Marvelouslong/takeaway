package pojo;

import com.mysql.cj.jdbc.Blob;

public class user {
    private int id;
    private String name;
    private long phone;
    private String password;
    private String signature;
    private String sex;
    private byte[] picture;

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", signature='" + signature + '\'' +
                ", sex='" + sex + '\'' +
                ", picture=" + picture +
                '}';
    }
    public user(String name,long phone,String password,String signature,String sex,byte[] picture){
        this.name=name;
        this.phone=phone;
        this.password=password;
        this.signature=signature;
        this.sex=sex;
        this.picture=picture;
    }

    public byte[] picture() {
        return picture;
    }

    public user() {
    }
}
