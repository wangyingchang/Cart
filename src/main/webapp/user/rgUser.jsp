<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册用户</title>
    <link rel="stylesheet" href="../CSS/styles.css">

</head>
<body>

<div style="text-align:center;margin:50px 0;">
    <h4>一个单调的购物车系统</h4>
    <div>
        <a href="/user/index.jsp">返回登录</a>
    </div>
</div>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <form action="/user/rgUser" method="get" >
                <input type="text" name="user.userName" placeholder="Username" required oninvalid="setCustomValidity('请输入您的账号！');" oninput="setCustomValidity('')" style="color:gray;"/>
                <input type="password" name="user.userPwd" placeholder="Password" required oninvalid="setCustomValidity('请输入您的密码！');" oninput="setCustomValidity('')" style="color:gray;" />
                <input type="email" name="user.userEamil" placeholder="UserEmail" required oninvalid="setCustomValidity('请输入正确的邮箱！');" oninput="setCustomValidity('')" style="color:gray;" />
                <input type="hidden" name="user.userRole" value="1"/><br/>
                <input type="submit" value="注册" style="color:gray;font-weight:300;margin-top:-20px;"/>
            </form>
            <span>${message1}</span>
        </div>

        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>

</body>
</html>