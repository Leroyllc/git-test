<%--
  Created by IntelliJ IDEA.
  User: llc
  Date: 2020/5/3
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="anno/testAnno?name=张三">测试注解</a>
    <br/>

    <form action="anno/testRequestBody" method="post">
        姓  名：<input name="name" type="text"></br>
        年  龄：<input name="age" type="text"></br>
        <input type="submit" value="提交">
    </form>
    <br/>

    <a href="anno/testPathVariable/10">测试可变路径</a>
</body>
</html>
