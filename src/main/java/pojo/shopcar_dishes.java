package pojo;

import java.util.Date;

public class shopcar_dishes {
    private dishes _d;
    private shopcar _shopcar;
    private Date time;
    private int number;
    private String taste;

    @Override
    public String toString() {
        return "shopcar_dishes{" +
                "_d=" + _d +
                ", _shopcar=" + _shopcar +
                ", time=" + time +
                ", number=" + number +
                ", taste='" + taste + '\'' +
                '}';
    }

    public shopcar get_shopcar() {
        return _shopcar;
    }

    public void set_shopcar(shopcar _shopcar) {
        this._shopcar = _shopcar;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public dishes get_d() {
        return _d;
    }

    public void set_d(dishes _d) {
        this._d = _d;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
