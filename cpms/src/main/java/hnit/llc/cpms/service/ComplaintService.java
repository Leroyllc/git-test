package hnit.llc.cpms.service;

import hnit.llc.cpms.bean.Complaint;
import com.baomidou.mybatisplus.extension.service.IService;
import hnit.llc.cpms.vo.ComplaintVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 投诉表 服务类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public interface ComplaintService extends IService<Complaint> {

    List<Complaint> listComplaintPage(Map<String, Object> map);

    List<ComplaintVo> getComplaintCount();
}
