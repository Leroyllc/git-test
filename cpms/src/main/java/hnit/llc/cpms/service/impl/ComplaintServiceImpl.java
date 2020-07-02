package hnit.llc.cpms.service.impl;

import hnit.llc.cpms.bean.Complaint;
import hnit.llc.cpms.dao.ComplaintMapper;
import hnit.llc.cpms.service.ComplaintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hnit.llc.cpms.vo.ComplaintVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 投诉表 服务实现类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Service
@Transactional
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {
    @Autowired
    private ComplaintMapper complaintMapper;

    @Override
    public List<Complaint> listComplaintPage(Map<String, Object> map) {
        return complaintMapper.listComplaintPage(map);
    }

    @Override
    public List<ComplaintVo> getComplaintCount() {
        return complaintMapper.getComplaintCount();
    }
}
