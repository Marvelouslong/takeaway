package pojo;

import java.sql.Timestamp;

public class order {
    private int id;
    private  String status;
    private String payway;
    private String notes;
    private Timestamp checkout_time;
    private Timestamp order_time;
    private double money;
    private receiver _re;
    private rider _r;
    private store _s;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Timestamp getCheckout_time() {
        return checkout_time;
    }

    public void setCheckout_time(Timestamp checkout_time) {
        this.checkout_time = checkout_time;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public receiver get_re() {
        return _re;
    }

    public void set_re(receiver _re) {
        this._re = _re;
    }

    public rider get_r() {
        return _r;
    }

    public void set_r(rider _r) {
        this._r = _r;
    }

    public store get_s() {
        return _s;
    }

    public void set_s(store _s) {
        this._s = _s;
    }

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", payway='" + payway + '\'' +
                ", notes='" + notes + '\'' +
                ", checkout_time=" + checkout_time +
                ", order_time=" + order_time +
                ", money=" + money +
                ", _re=" + _re +
                ", _r=" + _r +
                ", _s=" + _s +
                '}';
    }
}
