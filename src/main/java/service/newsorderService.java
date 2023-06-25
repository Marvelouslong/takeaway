package service;

import pojo.order;

import java.util.List;

public interface newsorderService {
    public List<order> getorderlist(long phone);
}
