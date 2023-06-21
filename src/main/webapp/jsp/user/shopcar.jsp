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
    <c:forEach var="shopcar" items="${shopcarlist}" varStatus="status">
      <tr>
        <div>
          <img  src="picture?id=${shopcar.id}">
          <div class="x_div2" style="display:inline-block">
              ${talk.context}<br><br>${talk._u.name}<br>
          </div>
        </div>
      </tr>
    </c:forEach>
  </table>
</main>
</body>
</html>
