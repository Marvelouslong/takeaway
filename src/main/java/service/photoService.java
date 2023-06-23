package service;

public interface photoService {
    public byte[] picturebrand_authorization(int id) throws Exception;
    public byte[] picturelicense(int id) throws Exception;
    public byte[] picturecertificate_of_business(int id) throws Exception;
    public byte[] pictureshop_picture(int id) throws Exception;
    public byte[] picturedishes_picture(int id) throws Exception;
    public byte[] picturedriver_license(int id) throws Exception;
}

