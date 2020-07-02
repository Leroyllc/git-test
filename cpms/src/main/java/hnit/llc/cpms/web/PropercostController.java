package hnit.llc.cpms.web;


import hnit.llc.cpms.bean.Propercost;
import hnit.llc.cpms.service.PropercostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物业费表 前端控制器
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/propercost")
public class PropercostController {
    @Autowired
    private PropercostService propercostService;

    /**
     * 添加
     * @param propercost
     * @param result
     * @return
     */
    @RequestMapping("/savePropercost")
    public Object savePropercost(@Valid Propercost propercost, BindingResult result){
        String beginTime = propercost.getBeginTime();
        String beginMonth = beginTime.substring(0, 2);
        String beginDay = beginTime.substring(3,5);
        String beginYear = beginTime.substring(6, 10);
        propercost.setBeginTime(beginYear+"-"+beginMonth+"-"+beginDay);
        //处理到期时间
        String endTime = propercost.getEndTime();
        String endMonth = endTime.substring(0, 2);
        String endDay = endTime.substring(3,5);
        String endYear = endTime.substring(6, 10);
        propercost.setEndTime(endYear+"-"+endMonth+"-"+endDay);
        Map<String, Object> map = new HashMap<>();
        if(result.getAllErrors().size() > 0){
            List<FieldError> errors = result.getFieldErrors();
            for(FieldError error: errors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return map;
        }
        return propercostService.savePropercost(propercost);
    }
    /**
     * 更新
     * @param propercost
     * @return
     */
    @RequestMapping("/updatePropercost")
    public Object updatePropercost(Propercost propercost,BindingResult result){
        String beginTime = propercost.getBeginTime();
        String beginMonth = beginTime.substring(0, 2);
        String beginDay = beginTime.substring(3,5);
        String beginYear = beginTime.substring(6, 10);
        propercost.setBeginTime(beginYear+"-"+beginMonth+"-"+beginDay);
        //处理到期时间
        String endTime = propercost.getEndTime();
        String endMonth = endTime.substring(0, 2);
        String endDay = endTime.substring(3,5);
        String endYear = endTime.substring(6, 10);
        propercost.setEndTime(endYear+"-"+endMonth+"-"+endDay);
        return propercostService.updateById(propercost);
    }


    /**
     * 查询
     * @param page
     * @param rows
     * @param ownerName
     * @return
     */
    @RequestMapping("/listPropercostPage")
    public Object listPropercostPage(int page, int rows, String ownerName) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        map.put("page",(page - 1) * rows);
        map.put("size", rows);
        map.put("ownerName", ownerName);
        Map<String ,Object> result = new HashMap<>();
        result.put("total",propercostService.count(null));
        List<Propercost> list = propercostService.listPropercostPage(map);
        result.put("rows", list);
        return result;
    }
}

