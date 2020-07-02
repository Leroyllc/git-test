package hnit.llc.cpms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hnit.llc.cpms.bean.Building;
import hnit.llc.cpms.bean.House;

import java.util.List;

/**
 * <p>
 * 楼栋表 服务类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public interface BuildingService extends IService<Building> {

    List<Building> getAllBuilding();

    List<House> getAllHouse(String buId);

    List<House> getExistHouse(String buId);
}
