package hnit.llc.cpms.service;

import hnit.llc.cpms.bean.Maintenance;
import com.baomidou.mybatisplus.extension.service.IService;
import hnit.llc.cpms.vo.MaintenanceVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 报修表 服务类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public interface MaintenanceService extends IService<Maintenance> {

    List<Maintenance> listMaintenancePage(Map<String, Object> map);

    List<MaintenanceVo> getMaintenanceCount();
}
