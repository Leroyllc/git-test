<%--
  Created by IntelliJ IDEA.
  User: llc
  Date: 2020/5/4
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>传统文件上传</h3>

    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload1"><br>
        <input type="submit" value="上传">
    </form>

    <h3>SpringMVC文件上传</h3>

    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload2"><br>
        <input type="submit" value="上传">
    </form>

    <h3>SpringMVC跨服务器文件上传</h3>

    <form action="user/fileupload3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>

    <a href="user/testInterception">拦截器</a>
</body>
</html>
