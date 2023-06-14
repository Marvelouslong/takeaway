package pojo;

import java.util.Arrays;

public class evaluate {
    private int id;
    private String evaluate;
    private byte[] picture;
    private int o_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    @Override
    public String toString() {
        return "evaluate{" +
                "id=" + id +
                ", evaluate='" + evaluate + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", o_id=" + o_id +
                '}';
    }
}
