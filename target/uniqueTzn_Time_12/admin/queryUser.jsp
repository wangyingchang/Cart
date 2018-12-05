<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 18386
  Date: 2018/6/7
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询用户</title>
    <style>

        /*头部按钮*/
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            cursor: pointer;
        }

        .button1 {
            background-color: white;
            color: black;
            border: 2px solid #4CAF50;
        }

        .button1:hover {
            background-color: #4CAF50;
            color: white;
        }
        .button2 {
            background-color: white;
            color: black;
            border: 2px solid #008CBA;
        }

        .button2:hover {
            background-color: #008CBA;
            color: white;
        }

        .button3 {
            background-color: white;
            color: black;
            border: 2px solid #555555;
        }

        .button3:hover {
            background-color: #555555;
            color: white;
        }
        .button4 {
            background-color: white;
            color: black;
            border: 2px solid #f44336;
        }

        .button4:hover {
            background-color: #f44336;
            color: white;
        }

        table {
            border-collapse: collapse;
            font-family: Futura, Arial, sans-serif;
        }
        caption {
            font-size: larger;
            margin: 1em auto;
        }
        th,td {
            padding: .65em;
        }
        th {
            background: #555;
            border: 1px solid #777;
            color: #fff;
            font-family: '圆体';
        }
        td {
            border: 1px solid #777;
        }

    </style>

    <!--管理用户-按钮-->
    <script type="text/javascript">
        function managerUser(){
            location.href = "/queryUser.action"
        }
    </script>

    <!--管理购物车-按钮-->
    <script type="text/javascript">
        function managerCartitem(){
            location.href = "/queryCartitemPaging.action?page=1"
        }
    </script>

    <!--管理商品-按钮-->
    <script type="text/javascript">
        function managerGoods(){
            location.href = "/queryGoodsPaging.action?page=1"
        }
    </script>

    <!--提示框-->
    <script type="text/javascript">
        function confirmit() {
            if(confirm("确认删除吗？")){
                return true;
            }else{
                return false;
            }

        }
    </script>

    <!--批量删除用户-->
    <script type="text/javascript">
        function deleteUserAll() {
            var check=document.getElementsByName("boxName");
            var userAll="";
            for(var i=0,length=check.length;i<length;i++)
            {
                if (check[i].checked) {
                    userAll[i] = check[i].value;
                    userAll = userAll + check[i].value + ",";
                }
            }
            if(userAll==""){
                alert("请勾选要删除的用户！");
            }else{
                if(confirmit()==true) {
                    window.location.href = "user/deleteUserAll?userAll=" + userAll;
                    alert("删除成功！");
                }
            }
        }
    </script>

    <!--提示框-->
    <script type="text/javascript">
        function confirmZX() {
            if(confirm("确认注销？")){
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>
<body>

<div id="main" style="height: 800px; width:1000px; margin: auto; background: -webkit-linear-gradient(top left, #ffe3d9 0%, #53e3a6 100%);background: linear-gradient(to bottom right, #ffe3d9 0%, #53e3a6 100%);">
    <!--头部按钮-->
    <div id="header" style="text-align: center;">
        <button class="button button1" onclick="managerUser()">管理用户信息</button>
        <button class="button button2" onclick="managerCartitem()">管理购物车信息</button>
        <button class="button button3" onclick="managerGoods()">管理商品信息</button>
        <a href="/user/index.jsp" style="color:black;text-decoration: none;" onclick="return confirmZX()"><button class="button button4">退出登录</button></a>
    </div><hr/>

    <!--身体部分-->
    <div id="body" style="text-align: center;">
        <table style="margin:auto;height:auto;width:1000px;text-align:center;">
            <tr>
                <th><input type="submit" value="批量删除" onclick="deleteUserAll()"></th>
                <th colspan="5">用户信息</th>
                <th colspan="2"><a href="/admin/addUser.jsp" style="text-decoration: none;font-family: '幼圆';color:#fff;"><input type="submit" value="添加用户" /></a></th>
            </tr>
            <tr>
                <th>多选</th>
                <th>用户ID</th>
                <th>用户名</th>
                <th>用户密码</th>
                <th>用户邮箱</th>
                <th>角色</th>
                <th colspan="2">操作</th>
            </tr>
            <s:iterator value="#session.tUsersList">
                    <tr style="color: gray;">
                        <td>
                            <input type="checkbox" name="boxName"  value="${id}">
                        </td>
                        <td>${id}</td>
                        <td>${userName}</td>
                        <td>${userPwd}</td>
                        <td>${userEamil}</td>
                        <td>${userRole}</td>
                        <td>
                            <form action="/user/queryUserById" method="get">
                                <input type="hidden" name="user.id" value="${id}"/>
                                <input type="submit" value="修改信息">
                            </form>
                        </td>
                        <td>
                            <form action="/user/deleteUser" method="get">
                                <input type="hidden" name="user.id" value="${id}"/>
                                <input type="submit" value="删除用户" onclick="return confirmit()">
                            </form>
                        </td>
                    </tr>
            </s:iterator>
        </table>
    </div>
</div>
</body>
</html>
