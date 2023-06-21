package dao;

public interface photoDao {
    public byte[] querybrand_authorization(int id)throws  Exception;
    public byte[] querylicense(int id)throws  Exception;
    public byte[] querycertificate_of_business(int id)throws  Exception;
    public byte[] queryshop_picture(int id)throws  Exception;
    public byte[] picturedishes_picture(int id)throws  Exception;
}
