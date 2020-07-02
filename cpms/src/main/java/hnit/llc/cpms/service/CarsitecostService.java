package hnit.llc.cpms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hnit.llc.cpms.bean.Carsitecost;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车位收费表 服务类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public interface CarsitecostService extends IService<Carsitecost> {

    List<Carsitecost> listCarsitecostPage(Map<String, Object> map) throws Exception;

    boolean saveCarsitecost(@Valid Carsitecost carsitecost, String  carsitecostId);
}
