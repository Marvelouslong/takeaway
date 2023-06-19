

<%--
  Created by IntelliJ IDEA.
  User: y1577
  Date: 2023/6/13
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file='where.jsp'%>
<html>
<head>
    <link href="store.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="bj"></div>

<div class="div1">
    <img class="div1-img" src="../../img/店铺图片.jpg" alt="店铺图片">
    <p class="p1">${shopSession.shop_name}</p>
    <p>主营类型：${shopSession.main_category}</p>
    <p>辅营类型：${shopSession.auxiliary_category}</p>
<%--    <p>商家简介：神佛无啊回复啊回复爱好分辨出位于巴登参悟i很多不擦五大湖大无法无法</p>--%>
</div>
<div class="div2">
    <span class="span1">店内已有菜品:</span>
    <button class="add_button" onclick="window.location.href = 'dish_add.jsp'">添加新的菜品</button>
    <table class="dish_table">
     <tr>
         <th>菜品</th><th width="100px">菜品描述</th><th>类别</th><th>状态</th><th>操作</th>
     </tr>
     <tr>
         <td>
         <div><img class="dish_img" src="../../img/店铺图片.jpg" alt="图片加载失败"><br>
             这是一道菜
         </div>
         </td>
         <td width="100px">这是一道踩踩踩踩踩次啊次啊啊啊啊</td>
         <td >凉菜类</td>
         <td>正在售卖</td>
         <td>
             <button type="button">删除</button>
             <button type="button">编辑</button>
         </td>
     </tr>
        <tr>
            <td>
                <div><img class="dish_img" src="../../img/店铺图片.jpg" alt="图片加载失败"><br>
                    这是一道菜
                </div>
            </td>
            <td width="100px">这是一道踩踩踩踩踩次啊次啊aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa啊啊啊</td>
            <td>凉菜类</td>
            <td>正在售卖</td>
            <td>
                <button type="button">删除</button>
                <button type="button">编辑</button>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
