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
    <title>添加商品</title>

    <style>
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

    </style>

    <!--表单样式-->
    <style>
        input{
            margin-top: 20px;
            border: 1px solid #ccc;
            border-radius: 2px;
            color: #000;
            font-family: 'Open Sans', sans-serif;
            font-size: 1em;
            height: 50px;
            padding: 0 16px;
            transition: background 0.3s ease-in-out;
            width: 300px;
        }
        input:focus {
            outline: none;
            border-color: #9ecaed;
            box-shadow: 0 0 10px #9ecaed;
        }
        select{
            margin-top: 20px;
            border: 1px solid #ccc;
            border-radius: 2px;
            color: #000;
            font-family: 'Open Sans', sans-serif;
            font-size: 1em;
            height: 50px;
            padding: 0 16px;
            transition: background 0.3s ease-in-out;
            width: 300px;
        }
        .submit{
            left: -3px;
            position: relative;
            -webkit-appearance: none;
            background: #009dff;
            border: 2px solid #ccc;
            border-radius: 2px;
            color: #fff;
            cursor: pointer;
            height: 50px;
            font-family: 'Open Sans', sans-serif;
            font-size: 1.2em;
            text-align: center;
            text-transform: uppercase;
            transition: background 0.3s ease-in-out;
            width: 300px;
        }
        .submit:hover {
            background: #00c8ff;
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

<div id="main" style="height: 800px; width:1000px;margin: auto; background: -webkit-linear-gradient(top left, #ffe3d9 0%, #53e3a6 100%);background: linear-gradient(to bottom right, #ffe3d9 0%, #53e3a6 100%);" >

    <!--头部按钮-->
    <div id="header" style="text-align: center;">
        <button class="button button1" onclick="managerUser()">管理用户信息</button>
        <button class="button button2" onclick="managerCartitem()">管理购物车信息</button>
        <button class="button button3" onclick="managerGoods()">管理商品信息</button>
        <a href="/user/index.jsp" style="color:black;text-decoration: none;" onclick="return confirmZX()"><button class="button button4">退出登录</button></a>
    </div><hr/>

    <!--身体部分-->
    <div id="body" style="text-align: center;">

        <h1>添加商品</h1>
        <!--表单-->
        <form action="/user/addGoods" method="get">
            <input type="text" name="goods.gname" placeholder="商品名称" required oninvalid="setCustomValidity('请输入商品名称！');" oninput="setCustomValidity('')" />
            <br/>
            <input type="text" name="goods.gprice" placeholder="商品价格" required oninvalid="setCustomValidity('请输入商品价格！');" oninput="setCustomValidity('')" />
            <br/>
            <input type="text" name="goods.gdesc" placeholder="商品描述" required oninvalid="setCustomValidity('请输入商品描述！');" oninput="setCustomValidity('')" />
            <br/>
            <select name="goods.gsort" required oninvalid="setCustomValidity('请选择商品类别！');" oninput="setCustomValidity('')" >
                <option value="">商品分类</option>
                <option value="clothes">clothes</option>
                <option value="food">food</option>
                <option value="live">live</option>
                <option value="travel">travel</option>
            </select>
            <br/>
            <input type="submit" class="submit" value="提交" />
        </form>
        <a href="/queryGoodsPaging.action"><input type="submit" class="submit" value="取消" /></a>

    </div>

</div>
</body>
</html>
