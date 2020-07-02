package hnit.llc.cpms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hnit.llc.cpms.bean.Propercost;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物业费表 服务类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public interface PropercostService extends IService<Propercost> {

    List<Propercost> listPropercostPage(Map<String, Object> map) throws Exception;

    boolean savePropercost(Propercost propercost);
}
