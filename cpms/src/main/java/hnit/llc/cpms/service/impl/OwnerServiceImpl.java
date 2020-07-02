package hnit.llc.cpms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hnit.llc.cpms.bean.House;
import hnit.llc.cpms.bean.Owner;
import hnit.llc.cpms.dao.OwnerMapper;
import hnit.llc.cpms.service.HouseService;
import hnit.llc.cpms.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主表 服务实现类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Service
@Transactional
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements OwnerService {

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private HouseService houseService;

    @Override
    public List<Owner> listOwnerPage(Map<String, Object> map) {
        return ownerMapper.listOwnerPage(map);
    }

    //处理逻辑
    @Override
    public boolean saveOwner(@Valid Owner owner) {
        //添加业主信息的时候就是业主入住
        //由业主获取房屋id 并获取房屋对象
        House house = houseService.getById(owner.getHouseId());
        if(house != null){
            house.setInTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            house.setHstatus("已入住");
            houseService.updateById(house);
        }

        return ownerMapper.insert(owner) != 0? true: false;
    }

    @Override
    public boolean updateOwner(@Valid Owner owner) {
        House house = houseService.getById(owner.getHouseId());
        if(house != null){
            house.setInTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            house.setHstatus("已入住");
            houseService.updateById(house);
        }//更新房屋信息
        return ownerMapper.updateById(owner) != 0 ? true : false;
    }

    @Override
    public Owner getOwner(String houseId) {
        return ownerMapper.getOwner(houseId);
    }
}
