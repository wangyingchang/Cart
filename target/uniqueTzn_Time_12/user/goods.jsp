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
    <title>商品信息</title>
    <style>
        /*左栏按钮*/
        .button {
            display: inline-block;
            border-radius: 4px;
            background-color: #f4511e;
            border: none;
            color: #FFFFFF;
            text-align: center;
            font-size: 28px;
            padding: 20px;
            width: 130px;
            transition: all 0.5s;
            cursor: pointer;
            margin: 2px;
        }

        .button span {
            cursor: pointer;
            display: inline-block;
            position: relative;
            transition: 0.5s;
        }

        .button span:after {
            content: '»';
            position: absolute;
            opacity: 0;
            top: 0;
            right: -20px;
            transition: 0.5s;
        }

        .button:hover span {
            padding-right: 25px;
        }

        .button:hover span:after {
            opacity: 1;
            right: 0;
        }

        /*头部超链接*/
        a:link {color: gray; text-decoration: none}      /* unvisited link */
        a:visited {color: gray;text-decoration: none}  /* visited link */
        a:hover {color: #6c8cff;text-decoration: none}  /* mouse over link */
        a:active {color: #ff68b4;text-decoration: none}  /* selected link */

    </style>

    <!--衣-按钮-->
    <script type="text/javascript">
        function clothes(){
            location.href = "/queryClothes.action"
        }
    </script>

    <!--食-按钮-->
    <script type="text/javascript">
        function food(){
            location.href = "/queryFood.action"
        }
    </script>

    <!--住-按钮-->
    <script type="text/javascript">
        function live(){
            location.href = "/queryLive.action"
        }
    </script>

    <!--行-按钮-->
    <script type="text/javascript">
        function travel(){
            location.href = "/queryTravel.action"
        }
    </script>

    <!--->
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

<!--容器-->
<div id="container" style="width:1000px; margin:auto; background: -webkit-linear-gradient(top left, #ffe3d9 0%, #53e3a6 100%);background: linear-gradient(to bottom right, #ffe3d9 0%, #53e3a6 100%);" >

    <!--头部-->
    <div id="header" style="background: #555; height:160px;">

        <div style="height:70px;color:gray;width:150px;float:left;margin-top: 80px;text-align:center;line-height: 70px;">
            您好！<span style="color: #f4511e;"><s:iterator value="#session.tUser1list">${userName}</s:iterator></span>
        </div>

        <div style="height:70px;color:gray;width:100px;float:left;margin-top: 80px;text-align:center;line-height: 70px;">
            <a href="/user/goods.jsp">商品信息</a>
        </div>

        <div style="height:70px;color:gray;width:100px;float:left;margin-top:80px;text-align:center;line-height:70px;">
            <s:iterator value="#session.tUser1list">
                <a href="/user/userQueryCartitem?cartitem.uid=${userName}">我的购物车</a>
            </s:iterator>
        </div>

        <div style="height:70px;color:gray;width:100px;float:left;margin-top:80px;text-align:center;line-height:70px;">
            <a href="/user/updateUserPwd.jsp">修改密码</a>
        </div>

        <div style="height:70px;color:gray;width:100px;float:left;margin-top:80px;text-align:center;line-height:70px;">
            <a href="/upFile/upFile.jsp">上传文件</a>
        </div>

        <div style="height:70px;color:gray;width:100px;float:left;margin-top:80px;text-align:center;line-height:70px;">
            <a href="/user/index.jsp" onclick="return confirmZX()">退出登录</a>
        </div>

    </div>

    <!--左边菜单-->
    <div id="menu" style="height:460px;width:150px;float:left;">
        <div style="font-size:2em;color:gray;margin:10px;height:40px;  ">
            商品分类
        </div>
        <div style="width:140px; height: 80px; margin:auto;">
            <button class="button" style="vertical-align:middle" onclick="clothes()"><span>衣 </span></button>
        </div>
        <div style="width:140px; height: 80px; margin:auto;">
            <button class="button" style="vertical-align:middle" onclick="food()"><span>食 </span></button>
        </div>
        <div style="width:140px; height: 80px; margin:auto;">
            <button class="button" style="vertical-align:middle" onclick="live()"><span>住 </span></button>
        </div>
        <div style="width:140px; height: 80px; margin:auto;">
            <button class="button" style="vertical-align:middle " onclick="travel()"><span>行 </span></button>
        </div>
    </div>
    <!--右边显示栏-->
    <div id="content" style=";height:440px;width:850px;float:left;padding-top:10px;">

    </div>

    <!--底部版权-->
    <div id="footer" style="background:#555;clear:both;text-align:center;">
        wangyingchang@163.com
    </div>
</div>
</body>
</html>
