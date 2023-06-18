package service;

import pojo.store;

import java.util.List;

public interface userservice {
    public List<store> getstorelist(String query, int currentPageNo, int pageSize);
    public int getstoreCount(String query);
}
