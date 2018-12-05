<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="../CSS/styles.css">

</head>
<body>

  <div style="text-align:center;margin:50px 0;">
      <h4>一个单调的购物车系统</h4>
      <div>
          <a href="/user/rgUser.jsp">注册用户</a>
      </div>
  </div>
  <div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <form action="/user/user_login" method="get" >
                <input type="text" name="user.userName" placeholder="Username" required oninvalid="setCustomValidity('请输入您的账号！');" oninput="setCustomValidity('')" style="color:gray;"/>
                <input type="password" name="user.userPwd" placeholder="Password" required oninvalid="setCustomValidity('请输入您的密码！');" oninput="setCustomValidity('')" style="color:gray;" />
                <select name="user.userRole" style="padding-left:105px;color:gray;font-weight:300;font-size: 18px;height:45px;width: 250px;border:1px rgba(255, 255, 255, 0.4) solid;background-color: rgba(255, 255, 255, 0.2);">
                    <option value="1">用户</option>
                    <option value="2">管理员</option>
                </select>
                <br/><br/>
                <input type="submit" value="登录" style="color:gray;font-weight:300;margin-top:-10px;"/>
            </form>
            <span>${message}</span>
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