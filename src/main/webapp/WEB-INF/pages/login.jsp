<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<h1>登录页面</h1>


<form action="/submitLogin">
    用户名：<input type="text" name="userName">
    <br><br>
    密码：<input type="password" name="password">
    <br><br>

    <input type="submit" value="登录">
    <input type="reset" value="重置">

</form>

</body>
</html>
