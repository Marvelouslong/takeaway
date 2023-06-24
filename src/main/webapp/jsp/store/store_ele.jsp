<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file='where.jsp'%>
<html>
<head>
  <title>商家订单信息</title>
  <link href="store.css" rel="stylesheet">
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
  <span class="span1">评论信息:</span>
  <table class="dish_table">
    <tr>
      <th>序号</th><th>内容</th><th>时间</th>
    </tr>
  </table>

</div>
</body>
</html>