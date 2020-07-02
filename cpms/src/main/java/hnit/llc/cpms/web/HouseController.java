package hnit.llc.cpms.web;


import hnit.llc.cpms.bean.House;
import hnit.llc.cpms.service.HouseService;
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
 * 房屋表 前端控制器
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * 删除或批量删除
     */
    @RequestMapping("/removeHouse")
    public Object removeHouse(@RequestParam("houseIds[]") List<String> houseIds){
        return houseService.removeByIds(houseIds);
    }

    /**
     * 添加
     */
    @RequestMapping("/saveOrUpdateHouse")
    public Object saveOrUpdateHouse(@Valid House house, BindingResult result){
        Map<String,Object> map = new HashMap<>();
        if(result.getAllErrors().size() > 0){
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error: errors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return map;
        }
        return houseService.saveOrUpdate(house);
    }

    /**
     * 查询
     * @param page
     * @param rows
     * @param buNumber
     * @return
     */
    @RequestMapping("/listHousePage")
    public Object listHousePage(int page, int rows, String buNumber){
        Map<String,Object> map = new HashMap<>();
        map.put("page",(page - 1) * rows);
        map.put("size", rows);
        map.put("buNumber",buNumber);
        Map<String,Object> result = new HashMap<>();
        result.put("total",houseService.count(null));
        result.put("rows",houseService.listHousePage(map));
        return result;
    }
}

