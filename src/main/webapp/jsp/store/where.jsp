<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: y1577
  Date: 2023/6/13
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家导航栏</title>
    <style>

        * {
            /* 清除标签默认的内边距 */
            padding: 0;
            /* 清除标签默认的外边距 */
            margin: 0;
            z-index: 1;
        }
        .welcome{
            color: rgba(1,1,1,0.38);
            top: 20px;
            width: auto;
            height: 20px;
            right:10px ;
            position:absolute;
        }

        .where{
            -webkit-box-shadow:0px 3px 3px #c8c8c8 ;
            -moz-box-shadow:0px 3px 3px #c8c8c8 ;
            box-shadow:0px 3px 3px #c8c8c8 ;
            width: 100%;
            margin: 0;
            padding: 0;
        }
        img{
            height: 45px;
        }

        ul{
            list-style-type: none; /*清除无序列表前的小点*/
            width: auto;
            height: 8%;
            background: #ffffff;
            margin: 0;
            /*padding-left: 20%;!*左边距，使li看起来在中间*!*/
            position: relative;
            text-align: center;
        }
        li{
            float: left;
            width: 130px;
            height: 100%;
            padding: 0;
            margin-right: 1%;  /*两个li之间的距离*/
        }
        a:link,a:visited{ /*鼠标未点击和点击过时的样式*/
            display: block;
            color: #464444;
            background-color: #ffffff;
            text-align: center;
            line-height: 30px; /*li行高*/
            padding: 10px;
            text-decoration: none; /*去下划线*/
        }
        a:hover{ /*鼠标移动到点击位时的样式，active指点击过后的样式*/
            /*background-color: #fded64;*/
            color: #73C9E5;
            cursor: pointer;
        }
        .bj_foot{
            bottom:0;
            position:absolute;
            text-align: center;
            width: 100%;
            color: #9F9F9F;
            font-size: small;
            z-index: 2;
        }
    </style>
</head>
<body>
    <div class="where">
        <ul>
          <li><img  src="<c:url value="/img/导航栏.png"/>"></li>
            <li><a href="<c:url value="DISHES?method=list_dishes"/>"> 首页 </a></li>
            <li><a href="<c:url value="ORDER?method=list"/>"> 订单 </a></li>
            <li><a href="<c:url value="EVA?method=list"/>"> 查看评论 </a></li>
            <li><a href="<c:url value="STORE1?method=list"/>"> 我的信息 </a></li>
        </ul>
    </div>
    <div class="welcome">欢迎您的登录</div>
    <div class="bj_foot"> <h6>欢迎来到商家界面</h6></div>
</body>
</html>