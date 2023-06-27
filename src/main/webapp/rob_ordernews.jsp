<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
  .add_button{
    background-color: rgba(252,216,163,0.41);
    border: 0;
    margin-left: 700px;
    margin-top: 30px;
    padding: 5px;
    border-radius:200px;
    width: 150px;
    height: 50px;
    font-size: large;
  }
  .add_button:hover{
    background-color: rgba(246,184,120,0.41);
  }
  .add_button1{
    background-color: rgba(252,216,163,0.41);
    border: 0;
    padding: 5px;
    border-radius:200px;
    width: 100px;
    height: 40px;
    font-size: large;
  }
  .add_button1:hover{
    background-color: rgba(246,184,120,0.41);
  }
</style>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>美了么外卖送餐平台</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
</head>
<body>
<!--头部-->
<header class="publicHeader">
  <h1>抢单页面</h1>
  <div class="publicHeaderR">
    <p><span>您好！</span><span style="color:#b6afaf"> ${riderSession.name}</span>  欢迎你！</p>
    <a href="riderinformation.jsp">我的</a>
    <a href="admin-out">退出</a>
  </div>
</header>
<!--用户-->
<table class="providerTable" cellpadding="0" cellspacing="0">
  <tr class="firstTr">
    <th width="5%">订单编码</th>
    <th width="5%">状态</th>
    <th width="5%">支付方式</th>
    <th width="10%">备注</th>
    <th width="10%">订单时间</th>
    <th width="5%">收件人姓名</th>
    <th width="10%">收件人电话</th>
    <th width="10%">收件人地址</th>
    <th width="10%">商家电话</th>
    <th width="10%">店铺名称</th>
    <th width="10%">店铺地址</th>
    <th width="5%">配送费</th>
    <th width="10%">操作</th>
  </tr>
  <c:forEach var="rob_orderlist" items="${rob_orderlist}">
    <tr>
      <td>
        <span>${rob_orderlist.id }</span>
      </td>
      <td>
        <span>等待抢单</span>
      </td>
      <td>
        <span>${rob_orderlist.payway}</span>
      </td>
      <td>
        <span>${rob_orderlist.notes}</span>
      </td>
      <td>
        <span>${rob_orderlist.order_time}</span>
      </td>
      <td>
        <span>${rob_orderlist._re.name}</span>
      </td>
      <td>
        <span>${rob_orderlist._re.phone}</span>
      </td>
      <td>
        <span>${rob_orderlist._re.address}</span>
      </td>
      <td>
        <span>${rob_orderlist._s.con_telephone}</span>
      </td>
      <td>
        <span>${rob_orderlist._s.shop_name}</span>
      </td>
      <td>
        <span>${rob_orderlist._s.address}</span>
      </td>
      <td>
        <span>5.00</span>
      </td>
      <td>
        <form action="<c:url value="rob"/>" method="post">
          <input type="hidden" name="id" value="${rob_orderlist.id}">
          <button type="submit"  class="add_button1" value="抢单">抢单</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
