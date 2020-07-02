<%--
  Created by IntelliJ IDEA.
  User: llc
  Date: 2020/5/5
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>跳转成功list</h3>
<c:forEach items="${list}" var="account">
    ${account.id}<br>
    ${account.name}<br>
    ${account.money}<br>
</c:forEach>
</body>
</html>
