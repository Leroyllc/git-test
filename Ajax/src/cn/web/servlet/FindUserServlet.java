package cn.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        //获取值
        String username = request.getParameter("username");

        //写在图中
        Map<String, Object> map = new HashMap<>();

        if("tom".equals(username)){
            map.put("userExist",true);
            map.put("msg","用户名已存在");
        }else {
            map.put("userExist",false);
            map.put("msg","用户名可以注册");
        }

        //将Map转换为json对象
        ObjectMapper objectMapper = new ObjectMapper();

        //传递给客户端
        objectMapper.writeValue(response.getWriter(),map);

        System.out.println(username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
