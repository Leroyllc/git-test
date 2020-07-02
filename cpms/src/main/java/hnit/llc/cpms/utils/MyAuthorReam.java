package hnit.llc.cpms.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import hnit.llc.cpms.bean.User;
import hnit.llc.cpms.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 处理用户登录认证类,同时和数据库结合
 */
public class MyAuthorReam extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo info = null;
        String username = (String)token.getPrincipal();
        User user = login(username);
        if(user != null){
            info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),super.getName());
        }
        return info;
    }

    private User login(String username) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq(true,"username",username);
        return userService.getOne(query);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
