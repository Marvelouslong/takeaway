package service;

import pojo.administrators;
import pojo.rider;

public interface loginriderService {
    public rider loginrider(long phone, String password);
}
