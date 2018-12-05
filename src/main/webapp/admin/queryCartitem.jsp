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
    <title>查询购物车</title>
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
            border: 1px solid#777;
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

    <!--批量删除购物车-->
    <script type="text/javascript">
        function deleteCartitemAll() {
            var check=document.getElementsByName("boxName");
            var cartitemAll="";
            for(var i=0,length=check.length;i<length;i++)
            {
                if (check[i].checked) {
                    cartitemAll[i] = check[i].value;
                    cartitemAll = cartitemAll + check[i].value + ",";
                }
            }
            if(cartitemAll==""){
                alert("请勾选要删除的用户！");
            }else{
                if(confirmit()==true) {
                    window.location.href = "user/deleteCartitemAll?cartitemAll=" + cartitemAll;
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
                <th><input type="submit" value="批量删除" onclick="deleteCartitemAll()"></th>
                <th colspan="5">购物车信息</th>
                <th colspan="2"><a href="/admin/addCartitem.jsp" style="text-decoration: none;font-family: '幼圆';color:#fff;"><input type="submit" value="添加购物车" /></a></th>
            </tr>
            <tr>
                <th>操作</th>
                <th>购物车ID</th>
                <th>用户名</th>
                <th>商品ID</th>
                <th>商品名称</th>
                <th>商品描述</th>
                <th colspan="2">操作</th>
            </tr>
            <s:iterator value="#session.pageBean.list">
                <tr style="color: gray;">
                    <td>
                        <input type="checkbox" name="boxName"  value="${cartitemId}">
                    </td>
                    <td>${cartitemId}</td>
                    <td>${uid}</td>
                    <td>${gid}</td>
                    <td>${gname}</td>
                    <td>${gdesc}</td>
                    <td>
                        <form action="/user/queryCartitemById" method="get">
                            <input type="hidden" name="cartitem.cartitemId" value="${cartitemId}"/>
                            <input type="submit" value="修改信息">
                        </form>
                    </td>
                    <td>
                        <form action="/user/deleteCartitem" method="get">
                            <input type="hidden" name="cartitem.cartitemId" value="${cartitemId}"/>
                            <input type="submit" value="踢出购物车" onclick="return confirmit()">
                        </form>
                    </td>
                </tr>
            </s:iterator>
            <!--分页栏-->
            <tr align="center">
                <td colspan="8">
                    第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页     
                    <s:if test="pageBean.page!=1">
                        <a href="${pageContext.request.contextPath }/queryCartitemPaging.action?page=1">首页</a>|
                        <a href="${pageContext.request.contextPath }/queryCartitemPaging.action?page=<s:property value="pageBean.page-1"/>">上一页</a>|
                    </s:if>

                    <s:if test="pageBean.page!=pageBean.totalPage">
                        <a href="${pageContext.request.contextPath }/queryCartitemPaging.action?page=<s:property value="pageBean.page+1"/>">下一页</a>|
                        <a href="${pageContext.request.contextPath }/queryCartitemPaging.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>
                    </s:if>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
