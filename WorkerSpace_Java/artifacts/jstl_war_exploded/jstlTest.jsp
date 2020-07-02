<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: llc
  Date: 2020/4/18
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>jstlTest</title>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add(new User(23,"张三"));
        list.add(new User(22,"李四"));
        list.add(new User(21,"王五"));

        request.setAttribute("list", list);
    %>

    <table  border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
        </tr>

        <c:forEach items="${list}" var="user" varStatus="s">
        <tr>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
