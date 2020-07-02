<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: llc
  Date: 2020/4/18
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>forEach标签</title>
</head>
<body>
    <c:forEach begin="1" end="10" step="1" var="i">
        ${i}</br>
    </c:forEach>
    <br>
    <%--
    <c:forEach begin="1" end="10" step="1" var="i" varStatus="s">
        ${i} <h3>${s.index}</h3> <h4>${s.count}</h4></br>
    </c:forEach>
    --%>
    <%
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        request.setAttribute("list",list);
    %>
    <c:forEach items="${list}" var="str" varStatus="s">
        <h3>容器中索引${s.index}</h3>
        <h4>计数器${s.count}</h4>
        <h5>容器内容${str}</h5>
    </c:forEach>

</body>
</html>
