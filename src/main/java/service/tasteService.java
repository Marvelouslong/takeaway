package service;

import pojo.taste;

import java.util.List;

public interface tasteService {
    public void add(taste taste);
    public List<taste> list(Integer D_id);
}
