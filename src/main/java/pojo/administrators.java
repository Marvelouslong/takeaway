package pojo;

public class administrators {
    private int id;
    private String name;
    private long account_number;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public administrators(String name,long account_number,String password) {
        this.name=name;
        this.account_number=account_number;
        this.password=password;
    }

    @Override
    public String toString() {
        return "administrators{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account_number=" + account_number +
                ", password='" + password + '\'' +
                '}';
    }

    public administrators() {
    }
}
