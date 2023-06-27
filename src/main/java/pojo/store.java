package pojo;

import com.mysql.cj.jdbc.Blob;

import java.util.Arrays;

public class store {
    private int id;
    private String address;
    private long con_telephone;
    private String shop_name;
    private String con_name;
    private String password;
    private byte[] brand_authorization;
    private long bank_card;
    private byte[] license;
    private byte[] certificate_of_business;
    private  String legal_id_card;
    private String status;
    private byte[] shop_picture;
    private  String main_category;
    private String auxiliary_category;
    private int ad_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCon_telephone() {
        return con_telephone;
    }

    public void setCon_telephone(long con_telephone) {
        this.con_telephone = con_telephone;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }
    public String getCon_name(){return con_name;}

    public void setCon_name(String con_name) {this.con_name = con_name;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBank_card() {
        return bank_card;
    }

    public void setBank_card(long bank_card) {
        this.bank_card = bank_card;
    }

    public byte[] getBrand_authorization() {
        return brand_authorization;
    }

    public void setBrand_authorization(byte[] brand_authorization) {
        this.brand_authorization = brand_authorization;
    }

    public byte[] getLicense() {
        return license;
    }

    public void setLicense(byte[] license) {
        this.license = license;
    }

    public byte[] getCertificate_of_business() {
        return certificate_of_business;
    }

    public void setCertificate_of_business(byte[] certificate_of_business) {
        this.certificate_of_business = certificate_of_business;
    }

    public byte[] getShop_picture() {
        return shop_picture;
    }

    public void setShop_picture(byte[] shop_picture) {
        this.shop_picture = shop_picture;
    }

    public String getLegal_id_card() {
        return legal_id_card;
    }

    public void setLegal_id_card(String legal_id_card) {
        this.legal_id_card = legal_id_card;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMain_category() {
        return main_category;
    }

    public void setMain_category(String main_category) {
        this.main_category = main_category;
    }

    public String getAuxiliary_category() {
        return auxiliary_category;
    }

    public void setAuxiliary_category(String auxiliary_category) {
        this.auxiliary_category = auxiliary_category;
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }
    @Override
    public String toString() {
        return "store{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", con_telephone=" + con_telephone +
                ", shop_name='" + shop_name + '\'' +
                ", password='" + password + '\'' +
                ", brand_authorization=" + brand_authorization +
                ", bank_card=" + bank_card +
                ", license=" + license +
                ", certificate_of_business=" + certificate_of_business +
                ", legal_id_card='" + legal_id_card + '\'' +
                ", status='" + status + '\'' +
                ", shop_picture=" + shop_picture +
                ", main_category='" + main_category + '\'' +
                ", auxiliary_category='" + auxiliary_category + '\'' +
                ", ad_id=" + ad_id +
                '}';
    }
    public store(int id,String address, long con_telephone,String shop_name,String con_name,String password,byte[] brand_authorization,long bank_card,byte[] license,byte[] certificate_of_business,String legal_id_card,String status,byte[] shop_picture,String main_category,String auxiliary_category,int ad_id)
    {
        this.id = id;
        this.address = address;
        this.con_telephone = con_telephone;
        this.shop_name = shop_name;
        this.con_name = con_name;
        this.bank_card = bank_card;
        this.password=password;
        this.brand_authorization = brand_authorization;
        this.license = license;
        this.certificate_of_business = certificate_of_business;
        this.shop_picture = shop_picture;
        this.legal_id_card = legal_id_card;
        this.status = status;
        this.main_category = main_category;
        this.auxiliary_category = auxiliary_category;
        this.ad_id = ad_id;
    }
    public store(String address, long con_telephone,String shop_name,String con_name,String password,long bank_card,String legal_id_card,String main_category,String auxiliary_category,String status,byte[] brand_authorization,byte[] license,byte[] certificate_of_business,byte[] shop_picture)
    {
        this.address = address;
        this.con_telephone = con_telephone;
        this.shop_name = shop_name;
        this.con_name = con_name;
        this.password=password;
        this.bank_card = bank_card;
        this.brand_authorization = brand_authorization;
        this.license = license;
        this.certificate_of_business = certificate_of_business;
        this.shop_picture = shop_picture;
        this.legal_id_card = legal_id_card;
        this.status = status;
        this.main_category = main_category;
        this.auxiliary_category = auxiliary_category;
    }
    public store(int id,String address, long con_telephone,String shop_name,String con_name,String password,byte[] brand_authorization,long bank_card,byte[] license,byte[] certificate_of_business,String legal_id_card,String status,byte[] shop_picture,String main_category,String auxiliary_category)
    {
        this.id = id;
        this.address = address;
        this.con_telephone = con_telephone;
        this.shop_name = shop_name;
        this.con_name = con_name;
        this.bank_card = bank_card;
        this.password=password;
        this.brand_authorization = brand_authorization;
        this.license = license;
        this.certificate_of_business = certificate_of_business;
        this.shop_picture = shop_picture;
        this.legal_id_card = legal_id_card;
        this.status = status;
        this.main_category = main_category;
        this.auxiliary_category = auxiliary_category;

    }
    public store(int id,String address, long con_telephone,String password,String main_category,String auxiliary_category)
    {
        this.id = id;
        this.address = address;
        this.con_telephone = con_telephone;
        this.password=password;
        this.main_category = main_category;
        this.auxiliary_category = auxiliary_category;

    }
    public store() {}

    public byte[] brand_authorization() {
        return brand_authorization;
    }

    public byte[] license() {
        return  license;
    }

    public byte[] certificate_of_business() {
        return  certificate_of_business;
    }

    public byte[] shop_picture() {
        return  shop_picture;
    }
}
