package hnit.llc.cpms.web;


import hnit.llc.cpms.bean.Maintenance;
import hnit.llc.cpms.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 报修表 前端控制器
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenanceService;


    /**
     * 统计报修次数
     * @return
     */
    @RequestMapping("/getMaintenanceCount")
    public Object getMaintenanceCount(){
        return maintenanceService.getMaintenanceCount();
    }

    /**
     * 处理
     *
     * @param maintenance
     * @return
     */
    @RequestMapping("/dealMaintenance")
    public Object dealMaintenance(Maintenance maintenance) {
        maintenance.setPtime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        maintenance.setMstatus("已处理");
        return maintenanceService.updateById(maintenance);
    }

    /**
     * 添加
     *
     * @param maintenance
     * @param result
     * @return
     */
    @RequestMapping("/saveMaintenance")
    public Object saveMaintenance(@Valid Maintenance maintenance, BindingResult result) {
        String mTime = maintenance.getMtime();
        String mMonth = mTime.substring(0, 2);
        String mDay = mTime.substring(3,5);
        String mYear = mTime.substring(6, 10);
        maintenance.setMtime(mYear+"-"+mMonth+"-"+mDay);
        //格式化处理时间
        String endTime = maintenance.getPtime();
        String endMonth = endTime.substring(0, 2);
        String endDay = endTime.substring(3,5);
        String endYear = endTime.substring(6, 10);
        maintenance.setPtime(endYear+"-"+endMonth+"-"+endDay);
        Map<String, Object> map = new HashMap<>();
        if (result.getAllErrors().size() > 0) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return map;
        }
        return maintenanceService.save(maintenance);
    }

    /**
     * 更新
     *
     * @param maintenance
     * @return
     */
    @RequestMapping("/updateMaintenance")
    public Object updateMaintenance(Maintenance maintenance) {
        return maintenanceService.updateById(maintenance);
    }


    /**
     * 查询
     *
     * @param page
     * @param rows
     * @param ownerName
     * @return
     */
    @RequestMapping("/listMaintenancePage")
    public Object listMaintenancePage(int page, int rows, String ownerName) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("page", (page - 1) * rows);
        map.put("size", rows);
        map.put("ownerName", ownerName);
        Map<String, Object> result = new HashMap<>();
        result.put("total", maintenanceService.count(null));
        List<Maintenance> list = maintenanceService.listMaintenancePage(map);
        result.put("rows", list);
        return result;
    }
}

