<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file='where.jsp'%>
<!DOCTYPE html>
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
</div>
<div class="div2">
    <span class="span1">店内已有菜品:</span>
    <button class="add_button" onclick="window.location.href = 'dish_add.jsp'">添加新的菜品</button>
    <table class="dish_table">
     <thead>
        <tr>
        <th>序号</th> <th>菜品</th><th width="100px">菜品描述</th><th>类别</th><th>状态</th><th>价格</th><th>操作</th>
     </tr>
     </thead>
        <tbody>
        <c:forEach items="${list}" var="dish">
     <tr>
         <td>${dish.id}</td>
          <td>
         <div><img  src="picture?id=${dish.id}"><br>
          ${dish.name}
         </div>
         </td>
         <td width="100px">${dish.describe}</td>
         <td >${dish.category}</td>
         <td>${dish.status}</td>
          <td>${dish.price}</td>
         <td>
             <button type="button">删除</button>
             <button type="button">编辑</button>
         </td>
     </tr>
      </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
