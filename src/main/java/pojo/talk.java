package pojo;

import java.util.Arrays;

public class talk {
    private int id;
    private  String context;
    private byte[] picture;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
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
                ", picture=" + Arrays.toString(picture) +
                ", u_id=" + u_id +
                '}';
    }
}
