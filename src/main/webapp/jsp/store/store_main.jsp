<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@include file='where.jsp'%>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/jsp/store/store.css"/>" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="bj"></div>

<div class="div1">
   <img  src="pictureshop_picture?id=${shopSession.id}" alt="image" style="height: 150px;width: 150px;border-radius:200px;margin-left: 65px;
    margin-top: 10%;">
    <p class="p1">${shopSession.shop_name}</p>
    <p>主营类型：${shopSession.main_category}</p>
    <p>辅营类型：${shopSession.auxiliary_category}</p>
    <p>店铺地址：${shopSession.address}</p>
</div>
<div class="div2">
    <span class="span1">店内已有菜品:</span>
    <button class="add_button" onclick="window.location.href='jsp/store/dish_add.jsp'">添加新的菜品</button>
    <table class="dish_table">
     <thead>
        <tr>
        <th>序号</th> <th>菜品</th><th width="100px">菜品描述</th><th>类别</th><th>状态</th><th>价格</th><th>操作</th>
     </tr>
     </thead>
        <tbody>
        <c:forEach items="${dishes_list}" var="dish" >
     <tr>
         <td>${dish.id}</td>
          <td>
         <img  src="picturedishes_picture?id=${dish.id}"><br>
          ${dish.name}
         </td>
         <td width="100px">${dish.describe}</td>
         <td >${dish.category}</td>
         <td>${dish.status}</td>
          <td>${dish.price}</td>
         <td>
             <button type="button">删除</button>
             <button type="button">编辑</button>
             <a href="<c:url value="/TASTE?method=list&d_id=${dish.id}"/>">
                 <button type="button">
                     选择菜品口味
                 </button>
             </a>
         </td>
     </tr>
      </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
