package hnit.llc.cpms.service.impl;

import hnit.llc.cpms.bean.House;
import hnit.llc.cpms.dao.HouseMapper;
import hnit.llc.cpms.service.HouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 服务实现类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Service
@Transactional
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<House> listHousePage(Map<String, Object> map) {
        return houseMapper.listHousePage(map);
    }
}
