package pojo;

public class taste {
    private int id;
    private String name;
    private int d_id;
    public taste(Integer id,String name){
        this.id=id;
        this.name=name;
    }

    public taste(String name,Integer d_id) {
        this.d_id = d_id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public taste() {
    }

    @Override
    public String toString() {
        return "taste{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
