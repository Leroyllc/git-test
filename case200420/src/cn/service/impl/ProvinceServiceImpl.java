package cn.service.impl;

import cn.dao.ProvinceDao;
import cn.dao.impl.ProvinceDaoImpl;
import cn.domain.Province;
import cn.service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDaoImpl dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }
}
