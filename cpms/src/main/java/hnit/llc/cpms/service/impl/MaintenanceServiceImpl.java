package hnit.llc.cpms.service.impl;

import hnit.llc.cpms.bean.Maintenance;
import hnit.llc.cpms.dao.MaintenanceMapper;
import hnit.llc.cpms.service.MaintenanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hnit.llc.cpms.vo.MaintenanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 报修表 服务实现类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Service
@Transactional
public class MaintenanceServiceImpl extends ServiceImpl<MaintenanceMapper, Maintenance> implements MaintenanceService {
    @Autowired
    private MaintenanceMapper maintenanceMapper;

    @Override
    public List<Maintenance> listMaintenancePage(Map<String, Object> map) {
        return maintenanceMapper.listMaintenancePage(map);
    }

    @Override
    public List<MaintenanceVo> getMaintenanceCount() {
        return maintenanceMapper.getMaintenanceCount();
    }
}
