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
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.mobile.js"></script>
    <script type="text/javascript">
        function openTabs(text, url) {
            if ($("#tabs").tabs('exists', text)) {
                $("#tabs").tabs('select', text)
            } else {
                var myContext = "<iframe frameborder='0' scrolling='auto' style='height:100%;width:100%;" +
                    "heigth:100%' src=" + url + ">";
                $("#tabs").tabs('add', {
                    title: text,
                    closable: true,
                    content: myContext
                })
            }
        }
    </script>
</head>
<body class="easyui-layout">
    <div  data-options="region:'north',title:'小区物业管理系统',split:true" style="height:80px;">
        <script>
            Date.prototype.format = function (fmt) {
                var o = {
                    "y+": this.getFullYear, //年
                    "M+": this.getMonth() + 1, //月份
                    "d+": this.getDate(), //日
                    "h+": this.getHours(), //小时
                    "m+": this.getMinutes(), //分
                    "s+": this.getSeconds() //秒
                };
                if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                for (var k in o)
                    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                return fmt;
            }
            setInterval("document.getElementById('dateTime').innerHTML = (new Date()).format('yyyy-MM-dd hh:mm:ss');", 1000);
        </script>
        <div style="width: 40%; float: left;position: absolute">当前系统时间:</div>
        <div id="dateTime" style="float: left;margin-left: 45%"></div>
    </div>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:200px;">
        <div id="aa" class="easyui-accordion" style="width:100%;height:100%;">
            <div title="楼栋房屋管理">
                <a href="#" class="easyui-linkbutton" onclick="openTabs('楼栋信息','pages/buildingList.html')" data-options="plain:true" style="width: 100%">楼 栋 信 息</a>
                <a href="#" class="easyui-linkbutton" onclick="openTabs('房屋信息','pages/houseList.html')" data-options="plain:true" style="width: 100%">房 屋 信 息</a>
            </div>

            <div title="业主信息管理">
                <a href="#" class="easyui-linkbutton" onclick="openTabs('业主信息','pages/ownerList.html')" data-options="plain:true" style="width: 100%">业 主 信 息</a>
            </div>

            <div title="车位信息管理">
                <a href="#" class="easyui-linkbutton" onclick="openTabs('车位信息','pages/carsiteList.html')" data-options="plain:true" style="width: 100%">车 位 信 息</a>
            </div>
            <div title="物业信息管理">
                <a href="#" class="easyui-linkbutton" onclick="openTabs('车位收费','pages/carsitecostList.html')" data-options="plain:true" style="width: 100%">车 位 收 费</a>
                <a href="#" class="easyui-linkbutton" onclick="openTabs('物业信息','pages/propercostList.html')" data-options="plain:true" style="width: 100%">物 业 收 费</a>
            </div>
            <div title="投诉报修管理">
                <a href="#" class="easyui-linkbutton" onclick="openTabs('投诉管理','pages/complaintList.html')" data-options="plain:true" style="width: 100%">投 诉 管 理</a>
                <a href="#" class="easyui-linkbutton" onclick="openTabs('报修管理','pages/maintenanceList.html')" data-options="plain:true" style="width: 100%">报 修 管 理</a>
            </div>
            <div title="投诉报修统计">
                <a href="#" class="easyui-linkbutton" onclick="openTabs('投诉统计','pages/complaintCount.html')" data-options="plain:true" style="width: 100%">投 诉 统 计</a>
                <a href="#" class="easyui-linkbutton" onclick="openTabs('报修统计','pages/maintenanceCount.html')" data-options="plain:true" style="width: 100%">报 修 统 计</a>
            </div>

            <div title="用户信息管理">
                <a href="#" class="easyui-linkbutton" onclick="openTabs('用户信息','pages/userList.html')" data-options="plain:true" style="width: 100%">用 户 信 息</a>
            </div>
        </div>
    </div>
    <div data-options="region:'center',title:'显示数据 '" style="padding:5px;background:#eee;">
        <div id="tabs" class="easyui-tabs" style="width:100%;height:100%;">

            <div title="首页" style=" padding:20px;display:none;">
                <div align="center"><h2>欢迎使用小区物业管理系统</h2></div>
            </div>
        </div>
    </div>
</body>
</html>
