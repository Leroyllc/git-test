package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet({"/d3","/demo3"})
//@WebServlet("/*")
@WebServlet("*.do")
public class ServletDemo3 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletDemo3");
        System.out.println(req);
        System.out.println("获取方式请求："+req.getMethod());
        System.out.println("获取虚拟目录："+req.getContextPath());
        System.out.println("获取Servlet路径:"+ req.getServletPath());
        System.out.println("获取get方式请求参数:"+req.getQueryString());
        System.out.println("获取请求URI：" + req.getRequestURI()+"获取请求URL："+req.getRequestURL());
        System.out.println("获取协议及版本："+req.getProtocol());
        System.out.println("获取客户机的IP地址："+req.getRemoteAddr());
    }
}
