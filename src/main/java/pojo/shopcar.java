package pojo;

public class shopcar {
    private int id;
    private double total_amount;
    private int total_number;
    private user _u;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public user get_u() {
        return _u;
    }

    public void set_u(user _u) {
        this._u = _u;
    }

    @Override
    public String toString() {
        return "shopcar{" +
                "id=" + id +
                ", total_amount=" + total_amount +
                ", total_number=" + total_number +
                ", _u=" + _u +
                '}';
    }
}
