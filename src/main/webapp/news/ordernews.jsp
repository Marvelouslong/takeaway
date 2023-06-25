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
    <a href="rob_ordernews">抢单</a>
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
      <th width="10%">骑手电话</th>
      <th width="5%">骑手姓名</th>
      <th width="10%">商家电话</th>
      <th width="10%">店铺名称</th>
      <th width="10%">店铺地址</th>
    </tr>
    <c:forEach var="orderList" items="${orderList}">
      <tr>
        <td>
          <span>${orderList.id }</span>
        </td>
        <td>
          <span>${orderList.status }</span>
        </td>
        <td>
          <span>${orderList.payway}</span>
        </td>
        <td>
          <span>${orderList.notes}</span>
        </td>
        <td>
          <span>${orderList.order_time}</span>
        </td>
        <td>
          <span>${orderList.money}</span>
        </td>
<%--        <td>--%>
<%--          <span>${orderList._r.id}</span>--%>
<%--        </td>--%>
        <td>
          <span>${orderList._re.name}</span>
        </td>
        <td>
          <span>${orderList._re.phone}</span>
        </td>
        <td>
          <span>${orderList._re.address}</span>
        </td>
        <td>
          <span>${orderList._r.phone}</span>
        </td>
        <td>
          <span>${orderList._r.name}</span>
        </td>
        <td>
          <span>${orderList._s.con_telephone}</span>
        </td>
        <td>
          <span>${orderList._s.shop_name}</span>
        </td>
        <td>
          <span>${orderList._s.address}</span>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</section>
</body>
</html>

<footer class="footer" style="color:#000;">
  骑手订单页面
</footer>
</body>
</html>