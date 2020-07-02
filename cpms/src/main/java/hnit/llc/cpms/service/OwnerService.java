package hnit.llc.cpms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hnit.llc.cpms.bean.Owner;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主表 服务类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public interface OwnerService extends IService<Owner> {

    List<Owner> listOwnerPage(Map<String, Object> map);

    boolean saveOwner(@Valid Owner owner);

    boolean updateOwner(@Valid Owner owner);

    Owner getOwner(String houseId);
}
