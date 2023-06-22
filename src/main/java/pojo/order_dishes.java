package pojo;

public class order_dishes {
    private order _o;
    private dishes _d;

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

    @Override
    public String toString() {
        return "order_dishes{" +
                "_o=" + _o +
                ", _d=" + _d +
                '}';
    }
}
