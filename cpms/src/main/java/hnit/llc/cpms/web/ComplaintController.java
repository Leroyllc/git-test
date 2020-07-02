package hnit.llc.cpms.web;


import hnit.llc.cpms.bean.Complaint;
import hnit.llc.cpms.service.ComplaintService;
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
 * 投诉表 前端控制器
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    /**
     * 统计投诉次数
     * @return
     */
    @RequestMapping("/getComplaintCount")
    public Object getComplaintCount(){
        return complaintService.getComplaintCount();
    }

    /**
     * 处理
     * @param complaint
     * @return
     */
    @RequestMapping("/dealComplaint")
    public Object dealComplaint(Complaint complaint){
        complaint.setpTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        complaint.setCstatus("已处理");
        return complaintService.updateById(complaint);
    }
    /**
     * 添加
     * @param complaint
     * @param result
     * @return
     */
    @RequestMapping("/saveComplaint")
    public Object saveComplaint(@Valid Complaint complaint, BindingResult result){
        String comTime = complaint.getComTime();
        String month = comTime.substring(0, 2);
        String day = comTime.substring(3,5);
        String year = comTime.substring(6, 10);
        complaint.setComTime(year+"-"+month+"-"+day);
        Map<String, Object> map = new HashMap<>();
        if(result.getAllErrors().size() > 0){
            List<FieldError> errors = result.getFieldErrors();
            for(FieldError error: errors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return map;
        }
        return complaintService.save(complaint);
    }
    /**
     * 更新
     * @param complaint
     * @return
     */
    @RequestMapping("/updateComplaint")
    public Object updateComplaint(Complaint complaint){
        String comTime = complaint.getComTime();
        String month = comTime.substring(0, 2);
        String day = comTime.substring(3,5);
        String year = comTime.substring(6, 10);
        complaint.setComTime(year+"-"+month+"-"+day);
        return complaintService.updateById(complaint);
    }


    /**
     * 查询
     * @param page
     * @param rows
     * @param ownerName
     * @return
     */
    @RequestMapping("/listComplaintPage")
    public Object listComplaintPage(int page, int rows, String ownerName) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        map.put("page",(page - 1) * rows);
        map.put("size", rows);
        map.put("ownerName", ownerName);
        Map<String ,Object> result = new HashMap<>();
        result.put("total",complaintService.count(null));
        List<Complaint> list = complaintService.listComplaintPage(map);
        result.put("rows", list);
        return result;
    }
}

