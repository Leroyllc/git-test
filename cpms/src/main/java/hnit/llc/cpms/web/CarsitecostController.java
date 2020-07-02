package hnit.llc.cpms.web;


import hnit.llc.cpms.bean.Carsitecost;
import hnit.llc.cpms.service.CarsitecostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车位收费表 前端控制器
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/carsitecost")
public class CarsitecostController {
    @Autowired
    private CarsitecostService carsitecostService;

    /**
     * 删除
     */
    @RequestMapping("/removeCarsitecost")
    public Object removeCarsitecost(@RequestParam("carsiteIds[]") List<String> carsiteIds){
        return carsitecostService.removeByIds(carsiteIds);
    }
    /**
     * 添加
     * @param carsitecost
     * @param result
     * @return
     */
    @RequestMapping("/saveCarsitecost")
    public Object saveCarsitecost(@Valid Carsitecost carsitecost,String carsitecostId, BindingResult result){
        String beginTime = carsitecost.getBeginTime();
        String beginMonth = beginTime.substring(0, 2);
        String beginDay = beginTime.substring(3,5);
        String beginYear = beginTime.substring(6, 10);
        carsitecost.setBeginTime(beginYear+"-"+beginMonth+"-"+beginDay);
        //处理到期时间
        String endTime = carsitecost.getEndTime();
        String endMonth = endTime.substring(0, 2);
        String endDay = endTime.substring(3,5);
        String endYear = endTime.substring(6, 10);
        carsitecost.setEndTime(endYear+"-"+endMonth+"-"+endDay);
        Map<String, Object> map = new HashMap<>();
        if(result.getAllErrors().size() > 0){
            List<FieldError> errors = result.getFieldErrors();
            for(FieldError error: errors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return map;
        }
        return carsitecostService.saveCarsitecost(carsitecost,carsitecostId);
    }
    /**
     * 更新
     * @param carsitecost
     * @return
     */
    @RequestMapping("/updateCarsitecost")
    public Object updateCarsitecost(Carsitecost carsitecost){
        String beginTime = carsitecost.getBeginTime();
        String beginMonth = beginTime.substring(0, 2);
        String beginDay = beginTime.substring(3,5);
        String beginYear = beginTime.substring(6, 10);
        carsitecost.setBeginTime(beginYear+"-"+beginMonth+"-"+beginDay);
        //处理到期时间
        String endTime = carsitecost.getEndTime();
        String endMonth = endTime.substring(0, 2);
        String endDay = endTime.substring(3,5);
        String endYear = endTime.substring(6, 10);
        carsitecost.setEndTime(endYear+"-"+endMonth+"-"+endDay);
        return carsitecostService.updateById(carsitecost);
    }


    /**
     * 查询
     * @param page
     * @param rows
     * @param ownerName
     * @return
     */
    @RequestMapping("/listCarsitecostPage")
    public Object listCarsitecostPage(int page, int rows, String ownerName) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("page",(page - 1) * rows);
        map.put("size", rows);
        map.put("ownerName",ownerName);
        Map<String,Object> result = new HashMap<>();
        result.put("total",carsitecostService.count(null));
        result.put("rows",carsitecostService.listCarsitecostPage(map));
        return result;
    }
}

