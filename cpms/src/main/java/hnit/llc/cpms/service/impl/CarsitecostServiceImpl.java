package hnit.llc.cpms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hnit.llc.cpms.bean.Carsite;
import hnit.llc.cpms.bean.Carsitecost;
import hnit.llc.cpms.dao.CarsitecostMapper;
import hnit.llc.cpms.service.CarsiteService;
import hnit.llc.cpms.service.CarsitecostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车位收费表 服务实现类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Service
@Transactional
public class CarsitecostServiceImpl extends ServiceImpl<CarsitecostMapper, Carsitecost> implements CarsitecostService {
    @Autowired
    private CarsitecostMapper carsitecostMapper;

    @Autowired
    private CarsiteService carsiteService;

    @Override
    public List<Carsitecost> listCarsitecostPage(Map<String, Object> map) throws Exception {
        //获取系统当前时间，转换为日期对象，然后进行比较
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date sysDate = df.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        List<Carsitecost> carsitecosts = carsitecostMapper.listCarsitecostPage(map);
        for (Carsitecost carsitecost: carsitecosts){
            Date endTime = df.parse(carsitecost.getEndTime());
            //如果系统时间大于到期时间
            if(sysDate.compareTo(endTime) == 1){
                carsitecost.setCscstatus("欠费");
                super.updateById(carsitecost);  //更新缴费状态
            }
        }
        return carsitecosts;
    }

    @Override
    public boolean saveCarsitecost(@Valid Carsitecost carsitecost, String carsitecostId) {
        Carsite carsite = carsiteService.getById(carsitecostId);
        carsite.setOwnerId(carsitecost.getOwnerId());
        carsite.setCsstatus("已启用");
        carsitecost.setCscstatus("正常");
        carsiteService.updateById(carsite); //更新车位信息
        return carsitecostMapper.insert(carsitecost) != 0 ? true:false; //更新缴费
    }
}
