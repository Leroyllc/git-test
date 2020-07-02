package hnit.llc.cpms.dao;

import hnit.llc.cpms.bean.Propercost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物业费表 Mapper 接口
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Repository
@Mapper
public interface PropercostMapper extends BaseMapper<Propercost> {

    List<Propercost> listPropercostPage(Map<String, Object> map);
}
