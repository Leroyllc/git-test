package hnit.llc.cpms.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hnit.llc.cpms.bean.Building;
import hnit.llc.cpms.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 楼栋表 前端控制器
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    /**
     * 查询已入住的房屋
     * @param buId
     * @return
     */
    @RequestMapping("/getExistHouse")
    public Object getExistHouse(String buId){
        return buildingService.getExistHouse(buId);
    }

    /**
     * 根据楼栋ID查询楼栋下所有房屋信息
     * @return
     */
    @RequestMapping("/getAllHouse")
    public Object getAllHouse(String buId){
        return buildingService.getAllHouse(buId);
    }

    /**
     * 查询所有楼栋信息
     * @return
     */
    @RequestMapping("/getAllBuilding")
    public Object getAllBuilding(){
        return buildingService.getAllBuilding();
    }

    /**
     * 删除或批量删除
     */
    @RequestMapping("/removeBuilding")
    public Object removeBuilding(@RequestParam("buIds[]") List<String> buIds){
        return buildingService.removeByIds(buIds);
    }

    /**
     * 添加
     */
    @RequestMapping("/saveOrUpdateBuilding")
    public Object saveOrUpdateBuilding(Building building, BindingResult result){
        Map<String,Object> map = new HashMap<>();
        if(result.getAllErrors().size() > 0){
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error: errors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return map;
        }
        return buildingService.saveOrUpdate(building);
    }

    /**
     * 查询
     * @param page
     * @param rows
     * @param buNumber
     * @return
     */
    @RequestMapping("/listBuildingPage")
    public Object listBuildingPage(int page, int rows, String buNumber){
        QueryWrapper<Building> query = new QueryWrapper<>();
        if(!"".equals(buNumber) && buNumber != null) query.like(true,"buNumber",buNumber);
        Map<String,Object> map = new HashMap<>();
        map.put("total",buildingService.count(query));
        map.put("rows",buildingService.page(new Page<Building>(page,rows),query).getRecords());
        return map;
    }

}

