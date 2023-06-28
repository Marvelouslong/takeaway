<%--
  Created by IntelliJ IDEA.
  User: HAN
  Date: 2023/6/27
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<form action="Userservlet" method="get">
<table class="table">
<%--    <c:set var="sum" value="0" />--%>
    <c:forEach items="${shopcarlist}" var="shopcar" varStatus="status">
        <tr>
            <td><img  src="picturedishes_picture?id=${shopcar._d.id}" style="animation: avatar_turn_around 2s linear infinite;
                             display: inline-block;
                             padding: 5px;
                             width: 25px;
                             height: 25px;
                             border-radius: 70px;
                             vertical-align: top;
                             transition: all .3s;"
                      alt="img"></td>
            <td>${shopcar._d.name}</td>
            <td>${shopcar._d.price}</td>
            <td>${shopcar.taste}</td>
            <td>${shopcar.number}</td>
<%--            <c:set var="money" value="${shopcar._d.price * shopcar.number}" />--%>
<%--            <c:set var="sum" value="${sum + money}" />--%>
        </tr>
    </c:forEach>
    <td><input type="radio" name="payway" value="微信">微信</td>
    <td><input type="radio" name="payway" value="支付宝">支付宝</td>
    <td><input type="radio" name="payway" value="银联卡">银联卡</td>
    <tr><td>接收人：&nbsp;</td><td>电话：&nbsp;</td><td>地址：&nbsp;</td></tr>
    <c:forEach var="re" items="${receiverlist}" varStatus="status">
    <tr>
        <td><input type="radio" name="receiver" value="${re.id}">${re.name}&nbsp; &nbsp; &nbsp; ${re.phone}&nbsp;&nbsp;&nbsp;${re.address}</td>
    </tr>
    </c:forEach>
    <tr>
        <td><input type="hidden" name="method" value="order"></td>
        <td><input type="hidden" name="sid" value="${sid}"></td>
        <td><input type="hidden" name="sum" value="${sum}"></td>
        <td>备注：<input type="text" name="notes" placeholder="添加备注~"></td>
        <td><input type="submit" name="mm" value="下单"></td>
        <td><input type="submit" name="mm" value="取消"></td>
    </tr>
</table>
</form>
</body>
</html>