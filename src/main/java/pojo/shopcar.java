package pojo;

public class shopcar {
    private int id;
    private double total_amount;
    private int total_number;
    private int u_id;

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

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "shopcar{" +
                "id=" + id +
                ", total_amount=" + total_amount +
                ", total_number=" + total_number +
                ", u_id=" + u_id +
                '}';
    }
}
