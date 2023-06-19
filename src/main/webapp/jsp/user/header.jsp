<%--
  Created by IntelliJ IDEA.
  User: HAN
  Date: 2023/6/13
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>美了么外卖送餐平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <style>
        .nav{
            display: flex;
            justify-content: space-between;
            height: 70px;
            -webkit-box-shadow:0px 3px 3px #c8c8c8 ;
            -moz-box-shadow:0px 3px 3px #c8c8c8 ;
            box-shadow:0px 3px 3px #c8c8c8 ;
        }
        .nav-img{
            position: relative;
            margin: 0px 10px 10px 20px;
        }
        .nav-link-ul{
            position: relative;
            margin: 25px 10px 20px 20px;
            width: 400px;
        }
        .nav-link-item{
            display: inline;
            margin-left: 30px;
            font-size: medium;
        }
        .nav-link-item a{
            color: #080909;
        }
        .nav-link-item a:hover {
            color: #73C9E5;
            cursor: pointer;
        }

        .nav-search-box{
            width: 400px;
        }
        .nav-search{
            position: relative;
            margin-top: 20px;
        }
        #nav_searchform{
            display: block;
            padding: 0 38px 0 16px;
            border: 1px solid hsla(0, 0%, 100%, 0);
            border-radius: 2px;
            background-color: #ffffff;
        }
        .nav-search-keyword{
            overflow: hidden;
            width: 100%;
            height: 34px;
            background-color: transparent;
            border: none;
            box-shadow: none;
            color: #999;
            font-size: 14px;
            line-height: 34px;
        }
        .nav-search-submit{
            position: absolute;
            top: 0;
            right: 0;
            margin: 0;
            padding: 0;
            width: 48px;
            height: 36px;
            border: none;
            border-radius: 2px;
            background: #e7e7e7;
            line-height: 26px;
            cursor: pointer;
        }
    .nav-hello{
        position: relative;
        margin: 25px 20px 10px 40px;
    }
    </style>

</head>
<body>
<header class="nav">
    <img src="${pageContext.request.contextPath}/img/logo.jpg" class="nav-img" alt="logo">
    <div class="nav-link">
        <ul class="nav-link-ul">
            <li class="nav-link-item">
                <a href="homepage.jsp">首页</a>
            </li>
            <li class="nav-link-item">
                <a href="shopcar.jsp">购物车</a>
            </li>
            <li class="nav-link-item">
                <a href="talk.jsp">讨论区</a>
            </li>
            <li class="nav-link-item">
                <a href="myinformation.jsp">我的信息</a>
            </li>
        </ul>
    </div>
    <div class="nav-search-box">
        <div class="nav-search">
            <form id="nav_searchform" action="${pageContext.request.contextPath }/Userservlet" method="get">
                <input name="method" value="query" class="input-text" type="hidden">
                <input type="hidden" name="pageIndex" value="1"/>
                <input type="text" autocomplete="off" accesskey="s" placeholder="搜索商家或菜品"
                       class="nav-search-keyword" name="query">
                <div class="nav-search-btn">
                <button type="submit" class="nav-search-submit">
                    <i class="layui-icon">&#xe615;</i>
                </button>
                </div>
            </form>
        </div>
    </div>
    <div class="nav-hello">
        <p><span>下午好！</span><span style="color: #fff21b">${userSession.name}</span> , 欢迎你！</p>
    </div>
</header>