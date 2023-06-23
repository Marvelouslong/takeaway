package pojo;

import com.mysql.cj.jdbc.Blob;

import java.util.Arrays;

public class dishes {
    private Integer s_id;
    private int id;
    private String name;
    public byte[] picture;
    private String describe;
    private String status;
    private double price;
    private String category;
    private store _s;




    public dishes(Integer id, String name, String describe, String status, Double price, String category) {
        this.id=id;
        this.name=name;
        this.describe=describe;
        this.price=price;
        this.category=category;
        this.status=status;
    }

    public  dishes(String name,String describe,String status,Double price,String category,byte[] picture,Integer s_id){
        this.name=name;
        this.describe=describe;
        this.status=status;
        this.price=price;
        this.category=category;
        this.picture=picture;
        this.s_id=s_id;
//        this.id=id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }



    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "dishes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", describe='" + describe + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", _s=" + _s +
                ", s_id=" + s_id +
                '}';
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public store get_s() {
        return _s;
    }

    public void set_s(store _s) {
        this._s = _s;
    }

}
