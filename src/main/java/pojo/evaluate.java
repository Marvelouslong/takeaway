package pojo;

import com.mysql.cj.jdbc.Blob;

import java.util.Arrays;

public class evaluate {
    private int id;
    private String evaluate;
    private byte[] picture;
    private String shop_evaluate;
    private order _o;

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

    public order get_o() {
        return _o;
    }

    public void set_o(order _o) {
        this._o = _o;
    }

    @Override
    public String toString() {
        return "evaluate{" +
                "id=" + id +
                ", evaluate='" + evaluate + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", _o=" + _o +
                '}';
    }

    public String getShop_evaluate() {
        return shop_evaluate;
    }

    public void setShop_evaluate(String shop_evaluate) {
        this.shop_evaluate = shop_evaluate;
    }
    public evaluate(Integer id,String shop_evaluate){
        this.id=id;
        this.shop_evaluate=shop_evaluate;
    }
    public evaluate(){}
}
