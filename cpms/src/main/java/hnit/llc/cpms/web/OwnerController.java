package hnit.llc.cpms.web;


import hnit.llc.cpms.bean.Owner;
import hnit.llc.cpms.service.OwnerService;
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
 * 业主表 前端控制器
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    /**
     * 根据房屋ID获取业主信息
     * @param houseId
     * @return
     */
    @RequestMapping("/getOwner")
    public Object getOwner(String houseId){
        return ownerService.getOwner(houseId);
    }

    /**
     * 删除或批量删除
     */
    @RequestMapping("/removeOwner")
    public Object removeOwner(@RequestParam("ownerIds[]") List<String> ownerIds){
        return ownerService.removeByIds(ownerIds);
    }

    /**
     * 添加
     */
    @RequestMapping("/saveOwner")
    public Object saveOwner(@Valid Owner owner, BindingResult result){
        Map<String,Object> map = new HashMap<>();
        if(result.getAllErrors().size() > 0){
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error: errors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return map;
        }
        return ownerService.saveOwner(owner);
    }

    /**
     * 更新
     * @param owner
     * @param result
     * @return
     */
    @RequestMapping("/updateOwner")
    public Object updateOwner(@Valid Owner owner, BindingResult result){
        Map<String,Object> map = new HashMap<>();
        if(result.getAllErrors().size() > 0){
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error: errors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return map;
        }
        return ownerService.updateOwner(owner);
    }

    /**
     * 查询
     * @param page
     * @param rows
     * @param ownerName
     * @return
     */
    @RequestMapping("/listOwnerPage")
    public Object listOwnerPage(int page, int rows, String ownerName){
        Map<String,Object> map = new HashMap<>();
        map.put("page",(page - 1) * rows);
        map.put("size", rows);
        map.put("ownerName",ownerName);
        Map<String,Object> result = new HashMap<>();
        result.put("total",ownerService.count(null));
        result.put("rows",ownerService.listOwnerPage(map));
        return result;
    }
}

