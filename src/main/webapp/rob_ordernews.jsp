<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
  <h1>订单</h1>
  <div class="publicHeaderR">
    <p><span>您好！</span><span style="color: #fff21b"> ${riderSession.name}</span>  欢迎你！</p>
    <a href="admin-out">退出</a>
<%--    <a href="loginrider">骑手订单</a>--%>
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
    <th width="5%">支付</th>
    <th width="5%">收件人姓名</th>
    <th width="10%">收件人电话</th>
    <th width="10%">收件人地址</th>
    <th width="10%">商家电话</th>
    <th width="10%">店铺名称</th>
    <th width="10%">店铺地址</th>
    <th width="10%">操作</th>
  </tr>
  <c:forEach var="rob_orderlist" items="${rob_orderlist}">
    <tr>
      <td>
        <span>${rob_orderlist.id }</span>
      </td>
      <td>
        <span>${rob_orderlist.status }</span>
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
        <span>${rob_orderlist.money}</span>
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
        <form action="<c:url value="rob"/>" method="post">
          <input type="hidden" name="id" value="${rob_orderlist.id}">
          <button type="submit" value="抢单">抢单</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</div>
</section>
<a href="o.jsp">qiang</a>
<%--<a href="rob.jsp">rob</a>--%>
</body>
</html>

<footer class="footer" style="color:#000;">
  抢单页面
</footer>
</body>
</html>
