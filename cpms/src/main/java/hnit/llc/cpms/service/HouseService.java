package hnit.llc.cpms.service;

import hnit.llc.cpms.bean.House;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 服务类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public interface HouseService extends IService<House> {

    List<House> listHousePage(Map<String, Object> map);
}
