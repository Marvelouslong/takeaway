package pojo;

import com.mysql.cj.jdbc.Blob;

import java.util.Arrays;

public class dishes {
    private int id;
    private String name;
    private Blob picture;
    private String describe;
    private String status;
    private double price;
    private String category;
    private int s_id;

    public dishes(Integer id, String name, String describe, String status, Double price, String category) {
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

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
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

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    @Override
    public String toString() {
        return "dishes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture=" + picture +
                ", describe='" + describe + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", s_id=" + s_id +
                '}';
    }
}
