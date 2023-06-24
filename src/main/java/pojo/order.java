package pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class order {
    private int id;
    private String status;
    private String payway;
    private String notes;
    private Date checkout_time;
    private Date order_time;
    private double money;
    private user _u;
    private rider _r;
    private store _s;
    private receiver _re;
//public order(Integer id,String status,String payway,String notes,Date checkout_time,Date order_time,Double money,user _u,rider _r,receiver _re)
//{
//    this.id=id;
//    this.status=status;
//    this.payway=payway;
//    this.notes=notes;
//    this.checkout_time = checkout_time;
//    this.order_time=order_time;
//    this.money=money;
//    this._r = _r;
//    this._u = _u;
//    this._re= _re;
//}

public order(){};

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

    public Date getCheckout_time() {
        return checkout_time;
    }

    public void setCheckout_time(Date checkout_time) {
        this.checkout_time = checkout_time;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
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

    public user get_u() {
        return _u;
    }

    public void set_u(user _u) {
        this._u = _u;
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
                ", _u=" + _u +
                ", _r=" + _r +
                ", _s=" + _s +
                ", _re=" + _re +
                '}';
    }
}
