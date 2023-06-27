package pojo;

public class rider {
    private int id;
    private long phone;
    private String name;
    private String id_card;
    public byte[] driver_license;
    private long bank_card;
    private String work_city;
    private String status;
    private String password;
    private int ad_id;

    public rider() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }


    public long getBank_card() {
        return bank_card;
    }

    public void setBank_card(long bank_card) {
        this.bank_card = bank_card;
    }

    public String getWork_city() {
        return work_city;
    }

    public void setWork_city(String work_city) {
        this.work_city = work_city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }
    public byte[] driver_license() {
        return driver_license;
    }
    public void driver_license(byte[] driver_license) {
        this.driver_license = driver_license;
    }

    @Override
    public String toString() {
        return "rider{" +
                "id=" + id +
                ", phone=" + phone +
                ", name='" + name + '\'' +
                ", id_card='" + id_card + '\'' +
                ", driver_license=" + driver_license +
                ", bank_card=" + bank_card +
                ", work_city='" + work_city + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", ad_id=" + ad_id +
                '}';
    }

    public rider(int id, long phone,String name,String id_card,byte[] driver_license,long bank_card,String work_city,String status,String password,int ad_id){
        this.id=id;
        this.phone = phone;
        this.name = name;
        this.id_card=id_card;
        this.driver_license=driver_license;
        this.bank_card=bank_card;
        this.work_city=work_city;
        this.status=status;
        this.password=password;
        this.ad_id=ad_id;
    }
//    public rider(int id, long phone,String name,String id_card,byte[] driver_license,long bank_card,String work_city,String status,String password){
//        this.id=id;
//        this.phone = phone;
//        this.name = name;
//        this.id_card=id_card;
//        this.driver_license=driver_license;
//        this.bank_card=bank_card;
//        this.work_city=work_city;
//        this.status=status;
//        this.password=password;
//    }
    public rider( String name,long phone,String id_card,long bank_card,String work_city,String password,String status,byte[] driver_license){
        this.name = name;
        this.phone = phone;
        this.id_card=id_card;
        this.driver_license=driver_license;
        this.bank_card=bank_card;
        this.work_city=work_city;
        this.status=status;
        this.password=password;
    }
//    public rider(int id,int ad_id){
//        this.id = id;
//        this.ad_id = ad_id;
//    }
//    public rider(int id, long phone,String name,String id_card,byte[] driver_license,long bank_card,String work_city,String password){
//        this.id=id;
//        this.phone = phone;
//        this.name = name;
//        this.id_card=id_card;
//        this.driver_license=driver_license;
//        this.bank_card=bank_card;
//        this.work_city=work_city;
//        this.password=password;
//    }



}
