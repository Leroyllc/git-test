<%--
  Created by IntelliJ IDEA.
  User: llc
  Date: 2020/5/3
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    
    <script>
        $(function(){
            $("#btn").click(function(){
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"aaa","password":"123","age":"23"}',
                    dataType:"json",
                    type:"POST",
                    success:function(data) {
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">testString</a>

    <br/>

    <a href="user/testVoid">testVoid</a>

    <br>
    <a href="user/testModelAndView">testModelAndView</a>

    </br>
    <button id="btn">发送ajax的请求</button>
</body>
</html>
