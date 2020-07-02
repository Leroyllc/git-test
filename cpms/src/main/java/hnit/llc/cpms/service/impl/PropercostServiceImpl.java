package hnit.llc.cpms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hnit.llc.cpms.bean.Propercost;
import hnit.llc.cpms.dao.PropercostMapper;
import hnit.llc.cpms.service.PropercostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物业费表 服务实现类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Service
@Transactional
public class PropercostServiceImpl extends ServiceImpl<PropercostMapper, Propercost> implements PropercostService {
    @Autowired
    PropercostMapper propercostMapper;

    @Override
    public List<Propercost> listPropercostPage(Map<String, Object> map) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date sysDate = df.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        List<Propercost> propercosts = propercostMapper.listPropercostPage(map);
        for (Propercost propercost: propercosts){
            Date endTime = df.parse(propercost.getEndTime());
            if(sysDate.compareTo(endTime) == 1){
                propercost.setPstatus("欠费");
                super.updateById(propercost);  //更新缴费状态
            }
            int money = Integer.parseInt(propercost.getElevatorCost()) +Integer.parseInt(propercost.getGarbageCost())+ Integer.parseInt(propercost.getLightingCost());
            propercost.setMoney(String.valueOf(money));
            super.updateById(propercost);
        }
        return propercosts;
    }

    @Override
    public boolean savePropercost(Propercost propercost) {
        return super.save(propercost);
    }
}
