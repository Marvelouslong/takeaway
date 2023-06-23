package service.impl;

import dao.impl.photoDaoImpl;
import service.photoService;

public class photoServiceImpl implements photoService {
        private photoDaoImpl bdi = new photoDaoImpl();
        public byte[] picturebrand_authorization(int id) {
            // TODO Auto-generated method stub		
            //调用dao方法
            return bdi.querybrand_authorization(id);
        }
        public byte[] picturelicense(int id) {
             // TODO Auto-generated method stub
             //调用dao方法
           return bdi.querylicense(id);
        }
        public byte[] picturecertificate_of_business(int id) {
            // TODO Auto-generated method stub
            //调用dao方法
           return bdi.querycertificate_of_business(id);
        }
        public byte[] pictureshop_picture(int id) {
            // TODO Auto-generated method stub
            // 调用dao方法
            return bdi.queryshop_picture(id);
        }
    public byte[] picturedishes_picture(int id) {
        // TODO Auto-generated method stub
        // 调用dao方法
        return bdi.picturedishes_picture(id);
    }
       public byte[] picturedriver_license(int id) {
           // TODO Auto-generated method stub
           // 调用dao方法
          return bdi.querydriver_license(id);
       }
}
