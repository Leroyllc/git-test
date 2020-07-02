package hnit.llc.cpms.dao;

import hnit.llc.cpms.bean.House;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 Mapper 接口
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Repository
@Mapper
public interface HouseMapper extends BaseMapper<House> {

    List<House> listHousePage(Map<String, Object> map);
}
