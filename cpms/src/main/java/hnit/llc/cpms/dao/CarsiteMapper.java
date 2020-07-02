package hnit.llc.cpms.dao;

import hnit.llc.cpms.bean.Carsite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 车位表 Mapper 接口
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Repository
@Mapper
public interface CarsiteMapper extends BaseMapper<Carsite> {

}
