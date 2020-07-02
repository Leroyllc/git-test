package hnit.llc.cpms.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hnit.llc.cpms.bean.User;
import hnit.llc.cpms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 删除或批量删除
     */
    @RequestMapping("/removeUser")
    public Object removeUser(@RequestParam("userIds[]")  List<String> userIds){
       return userService.removeByIds(userIds);
    }

    /**
     * 添加
     */
    @RequestMapping("/saveOrUpdateUser")
    public Object saveOrUpdateUser(@Valid User user, BindingResult result){
        Map<String,Object> map = new HashMap<>();
        if(result.getAllErrors().size() > 0){
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error: errors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return map;
        }
        return userService.saveOrUpdate(user);
    }

    /**
     * 查询
     * @param page
     * @param rows
     * @param username
     * @return
     */
    @RequestMapping("/listUserPage")
    public Object listUserPage(int page, int rows, String username){
        QueryWrapper<User> query = new QueryWrapper<>();
        if(!"".equals(username) && username != null) query.like(true,"USERNAME",username);
        Map<String,Object> map = new HashMap<>();
        map.put("total",userService.count(query));
        map.put("rows",userService.page(new Page<User>(page,rows),query).getRecords());
        return map;
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Object login(String username, String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        Subject subject = SecurityUtils.getSubject();

        //如果登录不正确
        if(!subject.isAuthenticated()){
            try{
                subject.login(token);
            }catch (UnknownAccountException e){//账号不正确
                return "0";
            }catch (IncorrectCredentialsException e){   //密码不正确
                return "0";
            }catch (AuthenticationException e){
                System.out.println("认证失败");
            }
        }
        return "1";
    }
}

