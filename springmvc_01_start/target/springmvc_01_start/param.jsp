<%--
  Created by IntelliJ IDEA.
  User: llc
  Date: 2020/5/3
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<a href="param/testParam?username=aaa&password=123">请求参数绑定</a>--%>

<%--<form action="param/saveAccount" method="post">--%>
    <%--用户名:<input name="username" type="text"></br>--%>
    <%--密  码：<input name="password" type="text"></br>--%>
    <%--金  额：<input name="money" type="text"></br>--%>
    <%--姓  名：<input name="user.name" type="text"></br>--%>
    <%--年  龄：<input name="user.age" type="text"></br>--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>


<%--<form action="param/saveAccount" method="post">--%>
    <%--用户名:<input name="username" type="text"></br>--%>
    <%--密  码：<input name="password" type="text"></br>--%>
    <%--金  额：<input name="money" type="text"></br>--%>

    <%--姓  名：<input name="list[0].name" type="text"></br>--%>
    <%--年  龄：<input name="list[0].age" type="text"></br>--%>

    <%--姓  名：<input name="list[1].name" type="text"></br>--%>
    <%--年  龄：<input name="list[1].age" type="text"></br>--%>

    <%--姓  名：<input name="map['one'].name" type="text"></br>--%>
    <%--年  龄：<input name="map['one'].age" type="text"></br>--%>

    <%--姓  名：<input name="map['two'].name" type="text"></br>--%>
    <%--年  龄：<input name="map['two'].age" type="text"></br>--%>
    <%--<input type="submit" value="提交">--%>

<form action="param/saveUser" method="post">
    姓  名：<input name="name" type="text"></br>
    年  龄：<input name="age" type="text"></br>
    生  日：<input name="birthday" type="text"></br>
    <input type="submit" value="提交">
</form>
</body>
</html>
