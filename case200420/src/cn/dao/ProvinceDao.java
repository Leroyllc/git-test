package cn.dao;

import cn.domain.Province;
import cn.util.JDBCUtils;
import com.alibaba.druid.util.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public interface ProvinceDao {

    public List<Province> findAll();
}
