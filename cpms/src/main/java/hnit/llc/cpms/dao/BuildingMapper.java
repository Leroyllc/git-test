package hnit.llc.cpms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hnit.llc.cpms.bean.Building;
import hnit.llc.cpms.bean.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 楼栋表 Mapper 接口
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */

@Repository
@Mapper
public interface BuildingMapper extends BaseMapper<Building> {

    List<Building> getAllBuilding();

    Building getBuilding(@Param("buId") String buId);

    List<House> getExistHouse(@Param("buId") String buId);
}
