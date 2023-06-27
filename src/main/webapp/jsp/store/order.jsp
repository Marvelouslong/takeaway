<%--
  Created by IntelliJ IDEA.
  User: y1577
  Date: 2023/6/19
  Time: 1:22
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
    <button class="btn" onclick="window.location.href = '/ORDER?method=list'"><<  返回界面</button>
    <div class="div10">

    <div class="div8" style="z-index: 5">

     <c:forEach items="${order}" var="order1" varStatus="status" >
        <span>订单序号 :${order1.id}</span>      <span style="float: right">付款方式:${order1.payway}</span> <br> <br>
        <span>收货人姓名 :${order1._re.name}</span>        <span style="float: right">订单状态 :${order1.status}</span> <br>  <br>
        <span>收货人电话 :${order1._re.phone}</span> <span style="float: right">下单时间 :${order1.checkout_time}</span> <br>  <br>
         <span>骑手电话 :${order1._r.phone}</span>
        <span style="float: right">实收总金额 :$100</span><br>
       <hr>
        <div style="height: 100px">备注:<br>
         ${order1.notes}</div>
        <hr>
     </c:forEach>
    </div>
 <br>
<c:forEach items="${dish}" var="dishes" varStatus="status" >
        <p> 商 品：</p>
        <table class="order_table">
            <tr>
                <td>菜 名 :${dishes._d.name}</td>
                <td>口 味 :${dishes.taste}</td>
                <td>金 额 :${dishes._d.price}</td>
            </tr>
        </table>
</c:forEach>
    </div>
</div>
</body>
</html>
