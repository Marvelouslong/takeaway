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
    private int re_id;
    private int r_id;
    private int s_id;

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

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
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
                ", re_id=" + re_id +
                ", r_id=" + r_id +
                ", s_id=" + s_id +
                '}';
    }
}
