package hnit.llc.cpms.service.impl;

import hnit.llc.cpms.bean.Carsite;
import hnit.llc.cpms.dao.CarsiteMapper;
import hnit.llc.cpms.service.CarsiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 车位表 服务实现类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Service
@Transactional
public class CarsiteServiceImpl extends ServiceImpl<CarsiteMapper, Carsite> implements CarsiteService {

}
