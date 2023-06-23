<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
        <h1>审核</h1>
        <div class="publicHeaderR">
            <p><span>您好！</span><span style="color: #fff21b"> ${adminSession.name}</span>  欢迎你！</p>
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