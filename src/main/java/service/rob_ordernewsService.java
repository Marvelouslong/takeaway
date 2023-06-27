package service;

import pojo.order;
import pojo.rider;

import java.util.List;

public interface rob_ordernewsService {
    public List<order> getorderlist(long phone);
    public Boolean rob(rider Rider,order Order);
}
