package hnit.llc.cpms.dao;

import hnit.llc.cpms.bean.Maintenance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hnit.llc.cpms.vo.MaintenanceVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 报修表 Mapper 接口
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Repository
@Mapper
public interface MaintenanceMapper extends BaseMapper<Maintenance> {

    List<Maintenance> listMaintenancePage(Map<String, Object> map);

    List<MaintenanceVo> getMaintenanceCount();
}
