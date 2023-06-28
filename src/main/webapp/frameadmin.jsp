<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8");%>
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
    <h1>审核</h1>
    <div class="publicHeaderR">
        <p><span>您好！</span><span style="color: #b6afaf"> ${adminSession.name}</span>  欢迎你！</p>
        <a href="adminpassword.jsp">修改密码</a>
        <a href="adminregister.jsp">管理员注册</a>
        <a href="admin-out">退出</a>
    </div>
</header>

<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="store">审核商家</a></li>
                <li ><a href="ridernews">审核骑手</a></li>
                <li><a href="admin-out">退出</a></li>
            </ul>
        </nav>
    </div>
    <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
    <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath }/img/logo.jpg" alt=""/>
        <div class="wFont">
            <h2>${adminSession.name }</h2>
            <p>欢迎来到美了么外卖送餐平台!</p>
        </div>
    </div>
</section>
</body>
</html>