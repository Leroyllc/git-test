package hnit.llc.cpms.dao;

import hnit.llc.cpms.bean.Owner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主表 Mapper 接口
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Repository
@Mapper
public interface OwnerMapper extends BaseMapper<Owner> {

    List<Owner> listOwnerPage(Map<String, Object> map);

    Owner getOwner(@Param("houseId") String houseId);
}
