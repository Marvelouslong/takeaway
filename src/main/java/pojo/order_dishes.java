package pojo;

public class order_dishes {
    private order _o;
    private dishes _d;
    private String taste;

    public order get_o() {
        return _o;
    }

    public void set_o(order _o) {
        this._o = _o;
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

    @Override
    public String toString() {
        return "order_dishes{" +
                "_o=" + _o +
                ", _d=" + _d +
                ", taste='" + taste + '\'' +
                '}';
    }
}
