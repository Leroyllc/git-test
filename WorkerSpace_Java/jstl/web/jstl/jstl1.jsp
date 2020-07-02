<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: llc
  Date: 2020/4/18
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
    <c:if test="true">
        <h1>I am true</h1>
    </c:if>

    <%
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");

        request.setAttribute("list",list);

    %>

    <c:if test="${not empty list}">
        遍历集合！
    </c:if>
</body>
</html>
