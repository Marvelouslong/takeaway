<%--
  Created by IntelliJ IDEA.
  User: y1577
  Date: 2023/6/18
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file='where.jsp'%>
<html>
<head>
    <title>商家订单信息</title>
  <link href="<c:url value="/jsp/store/store.css"/>" rel="stylesheet">
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
  <span class="span1">订单信息:</span>
  <table class="dish_table">
    <thead>
    <tr>
      <th>序号</th><th>用户姓名</th><th>用户联系电话</th><th>备注</th><th>状态</th><th>详情</th>
    </tr>
    </thead>
    <tbody>
      <c:forEach items="${order_list}" var="order" varStatus="status" >
    <tr>
        <td>${order.id}</td>
        <td>${order._u.name}</td>
      <td>${order._u.phone}</td>
      <td>${order.notes}</td>
      <td>${order.status}</td>
      <td>
        <button class="btn" onclick="window.location.href = 'order.jsp'">查看订单详情</button>
      </td>
    </tr>
      </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>
