<%--
  Created by IntelliJ IDEA.
  User: llc
  Date: 2020/5/7
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.mobile.js"></script>
    <script>
        $(function () {
            $("#login-dialog").dialog({
                buttons:[{
                    text:"登录",
                    handler:function () {
                            $('#login-form').form('submit', {
                                    url:'user/login',
                                onSubmit: function(){
                                    return $("#login-form").form('validate');
                            },
                            success:function(flag){
                                //如果登录验证成功,跳转到index.jsp
                                if(flag == '1'){
                                    window.location.href="index.jsp";
                                }else if(flag == '0'){
                                    $.messager.alert('消息','账号或密码不正确', 'error')
                                }
                            }
                        });
                    }
                }]
            });
        });
    </script>
</head>
<body>

    <div id="login-dialog" class="easyui-dialog" title="小区物流管理系统登录" style="width:auto;height:auto;"
         data-options="closable:false, modal:true">
        <form action="" id="login-form" method="post">
           <table>
               <tr>
                   <td>账号</td>
                   <td><input name="username" class="easyui-textbox" data-options="iconCls:'icon-man',required:true"></td>
               </tr>
               <tr>
                   <td>密码</td>
                   <td><input name="password" type="password" class="easyui-textbox" data-options="iconCls:'icon-lock',required:true"></td>
               </tr>
           </table>
        </form>
    </div>
</body>
</html>
