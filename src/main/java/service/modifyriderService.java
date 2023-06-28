package service;

import pojo.administrators;
import pojo.rider;

public interface modifyriderService {
    //修改状态
    public Boolean modifyrider(rider Rider, administrators admin) throws Exception;
    public Boolean modifycontext(rider Rider) throws Exception;
    public Boolean modifydriver(rider Rider) throws Exception;
}
