package hnit.llc.cpms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hnit.llc.cpms.bean.User;
import hnit.llc.cpms.dao.UserMapper;
import hnit.llc.cpms.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
