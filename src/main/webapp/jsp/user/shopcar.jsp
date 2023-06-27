<%--
  Created by IntelliJ IDEA.
  User: HAN
  Date: 2023/6/19
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<main class="shopcars">
  <table class="table">
    <c:set var="isExecuted" value="false" />
    <c:set var="lastValue" value="" />
    <c:forEach var="shopcar" items="${shopcar}" varStatus="status">
      <tr>
        <td><a href="Userservlet?method=storelist&id=${shopcar._d.s_id}">
          <c:if test="${shopcar._d.s_id ne lastValue}">
          <img  src="pictureshop_picture?id=${shopcar._d.s_id}"
                alt="image" style="height: 100px;width: 100px;border-radius:200px;margin-left: 65px;
    margin-top: 10%;">
            ${shopcar._d._s.shop_name}
        </c:if>
        <c:set var="lastValue" value="${shopcar._d.s_id}" />
        </a>
        </td>
        <td><a href="Userservlet?method=storelist&id=${shopcar._d.s_id}">
          <img  src="picturedishes_picture?id=${shopcar._d.id}" style="animation: avatar_turn_around 2s linear infinite;
                             display: inline-block;
                             padding: 5px;
                             width: 50px;
                             height: 50px;
                             border-radius: 70px;
                             vertical-align: top;
                             transition: all .3s;"
                alt="img"></a></td>
        <td><a href="Userservlet?method=storelist&id=${shopcar._d.s_id}">${shopcar._d.name}</a></td>
      </tr>
      <tr>
        <c:if test="${status.last and not isExecuted}">
          <td>总数量：${shopcar._shopcar.total_number}</td>
          <td>总金额：${shopcar._shopcar.total_amount}</td>
          <c:set var="isExecuted" value="true" />
        </c:if>
      </tr>
    </c:forEach>
  </table>
</main>
</body>
</html>
