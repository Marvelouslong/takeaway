package pojo;

import com.mysql.cj.jdbc.Blob;

import java.util.Arrays;

public class talk {
    private int id;
    private String context;
    private byte[] picture;
    private user _u;

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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public user get_u() {
        return _u;
    }

    public void set_u(user _u) {
        this._u = _u;
    }

    @Override
    public String toString() {
        return "talk{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", picture=" + picture +
                ", _u=" + _u +
                '}';
    }
}

