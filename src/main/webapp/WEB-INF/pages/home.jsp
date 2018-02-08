<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>home</title>
</head>
<body>

<h1>主页</h1>

<h3>根据角色显示不同的按钮<br>
    部门经理显示：删除、查询按钮<br>
    教学主管显示：查询按钮
</h3>
<shiro:hasAnyRoles name="部门经理">
    <input type="button" value="删除">
    <br><br>
</shiro:hasAnyRoles>

<input type="button" value="查询">

<br>
<a href="/logout">退出登录</a>


</body>
</html>
