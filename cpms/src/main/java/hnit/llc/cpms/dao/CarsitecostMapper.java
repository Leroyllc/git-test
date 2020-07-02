package hnit.llc.cpms.dao;

import hnit.llc.cpms.bean.Carsitecost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车位收费表 Mapper 接口
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Repository
@Mapper
public interface CarsitecostMapper extends BaseMapper<Carsitecost> {

    List<Carsitecost> listCarsitecostPage(Map<String, Object> map);
}
