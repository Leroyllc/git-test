package hnit.llc.cpms.service.impl;

import hnit.llc.cpms.bean.Building;
import hnit.llc.cpms.bean.House;
import hnit.llc.cpms.dao.BuildingMapper;
import hnit.llc.cpms.service.BuildingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 楼栋表 服务实现类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Service
@Transactional
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> getAllBuilding() {
        return buildingMapper.getAllBuilding();
    }

    @Override
    public List<House> getAllHouse(String buId) {
        return buildingMapper.getBuilding(buId).getHouseList();//根据楼栋查询所有房屋信息
    }

    @Override
    public List<House> getExistHouse(String buId) {
        return buildingMapper.getExistHouse(buId);
    }


}
