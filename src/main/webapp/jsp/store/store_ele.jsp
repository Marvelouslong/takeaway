<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file='where.jsp'%>
<html>
<head>
  <title>商家评论信息</title>
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
  <span class="span1">评论信息:</span>
  <table class="dish_table">
<%--    <tr>--%>
<%--      <th>序号</th><th>内容</th><th>时间</th>--%>
<%--    </tr>--%>
    <c:forEach items="${list}" var="eva" varStatus="status" >
      <tr>
        <td>订单编号：${eva._o.id}</td>
        <td>用户姓名：${eva._o._u.name}<br>
            联系电话：${eva._o._u.phone}</td>
        <td style="width: 500px">${eva.evaluate}<br>
            <div style="font-size: small;color: #9F9F9F">谢谢啊亲${eva.shop_evaluate}</div>
        </td>

        <td>
            <form action="<c:url value="/EVA?method=update"/>" method="post">
                <input type="hidden" name="id" value="${eva.id}">
                <button type="submit">回复</button>
            </form>
            <form action="<c:url value="/EVA?method=del"/>" method="post">
                <input type="hidden" name="id" value="${eva.id}">
                <button type="submit">删除评论</button>
            </form>
            <span style="color: #9F9F9F;float: right;font-size: small"> ${eva._o.checkout_time}</span>
        </td>
          </tr>
    </c:forEach>
  </table>

</div>
</body>
</html>