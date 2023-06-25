<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<form  action="rob"  name="actionForm" id="actionForm"  method="post" >
  <div class="inputbox">
    <font color="black">phone：</font>
    <input id="input" style="background-color:transparent" type="text" name="phone" placeholder="请输入账号"  required/>
  </div>
<%--  <div class="inputbox">--%>
<%--    <font color="black">id：</font>--%>
<%--    <input id="input" style="background-color:transparent" type="number" name="id" placeholder="请输入订单编码"  required/>--%>
<%--  </div>--%>
  <div class="subBtn">
    <input style="background-color:transparent" type="submit" value="登录"/>
    <input style="background-color:transparent" type="reset" value="重置"/>
    <%--  <a href="loginstore.jsp">aa</a>--%>
  </div>
</form>
