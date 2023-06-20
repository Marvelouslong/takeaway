package service.impl;

import dao.impl.photoDaoImpl;
import dao.impl.storeDaoImpl;
import dao.photoDao;
import service.photoService;

public class photoServiceImpl implements photoService {
        private photoDaoImpl bdi = new photoDaoImpl();
        public byte[] picture(int id) {
            // TODO Auto-generated method stub		
            //调用dao方法
            return bdi.queryphoto(id);
        }

    }
