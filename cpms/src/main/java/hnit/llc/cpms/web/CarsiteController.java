package hnit.llc.cpms.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hnit.llc.cpms.bean.Carsite;
import hnit.llc.cpms.service.CarsiteService;
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
 * 车位表 前端控制器
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/carsite")
public class CarsiteController {
    @Autowired
    private CarsiteService carsiteService;

    /**
     * 查询车位信息
     * @return
     */

    @RequestMapping("/listCarsite")
    public Object listCarsite(){
        return carsiteService.list(null);
    }

    /**
     * 删除或批量删除
     */
    @RequestMapping("/removeCarsite")
    public Object removeCarsite(@RequestParam("carsiteIds[]") List<String> carsiteIds){
        return carsiteService.removeByIds(carsiteIds);
    }

    /**
     * 添加
     */
    @RequestMapping("/saveOrUpdateCarsite")
    public Object saveOrUpdateCarsite(@Valid Carsite carsite, BindingResult result){
        Map<String,Object> map = new HashMap<>();
        if(result.getAllErrors().size() > 0){
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error: errors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return map;
        }
        return carsiteService.saveOrUpdate(carsite);
    }

    /**
     * 查询
     * @param page
     * @param rows
     * @param carsiteNumber
     * @return
     */
    @RequestMapping("/listCarsitePage")
    public Object listCarsitePage(int page, int rows, String carsiteNumber){
        QueryWrapper<Carsite> query = new QueryWrapper<>();
        if(!"".equals(carsiteNumber) && carsiteNumber != null) query.like(true,"carsiteNumber",carsiteNumber);
        Map<String,Object> map = new HashMap<>();
        map.put("total",carsiteService.count(query));
        map.put("rows",carsiteService.page(new Page<Carsite>(page,rows),query).getRecords());
        return map;
    }
}

