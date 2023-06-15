package pojo;

import com.mysql.cj.jdbc.Blob;

import java.util.Arrays;

public class talk {
    private int id;
    private String context;
    private Blob picture;
    private int u_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "talk{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", picture=" + picture +
                ", u_id=" + u_id +
                '}';
    }
}

