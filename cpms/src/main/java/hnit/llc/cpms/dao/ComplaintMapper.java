package hnit.llc.cpms.dao;

import hnit.llc.cpms.bean.Complaint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hnit.llc.cpms.vo.ComplaintVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 投诉表 Mapper 接口
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Repository
@Mapper
public interface ComplaintMapper extends BaseMapper<Complaint> {

    List<Complaint> listComplaintPage(Map<String, Object> map);

    List<ComplaintVo> getComplaintCount();
}
