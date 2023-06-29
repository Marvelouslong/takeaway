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
<form  action="adminpassword"  name="actionForm" id="actionForm"  method="post" >
<div class="inputbox">
  <font color="black">密&ensp;&ensp;码：</font>
  <input id="input" style="background-color:transparent" type="password" name="password" placeholder="请输入密码"  required/>
</div>
<div class="subBtn">
  <input style="background-color:transparent" type="submit" value="修改"/>
  <input style="background-color:transparent" type="reset" value="重置"/>
</div>
