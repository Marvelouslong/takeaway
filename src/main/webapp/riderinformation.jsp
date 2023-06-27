<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
  #content-outer {
    -webkit-box-flex: 1;
    -moz-box-flex: 1;
    -o-box-flex: 1;
    box-flex: 1;
    -webkit-flex: 1 auto;
    -ms-flex: 1 auto;
    flex: 1 auto;
    display: block;
  }
  h1 {
    font-size: 2em;
    margin: .67em 0;
  }
  .layout_page {
    display: flex;
    -webkit-box-align: start;
    align-items: flex-start;
    margin: 0 auto;
    padding: 0 5px;
    max-width: 1400px;
  }

  #page{
    margin-left: 20px;
    margin-top: 10px;
    width: 75%;
    border-radius: 3px;
    background: #fff;
    box-shadow: 0 4px 8px 6px rgba(7, 17, 27, .06);
    transition: all .3s;
  }
  #page{
    padding: 20px 44px 44px;
  }

  #aside_content {
    width: 25%;
  }
  #aside_content .card-widget {
    overflow: hidden;
    margin: 10px 0;
    border-radius: 3px;
    background: #fff;
    -webkit-box-shadow: 0 4px 8px 6px rgba(7, 17, 27, .06);
    box-shadow: 0 4px 8px 6px rgba(7, 17, 27, .06);
    -webkit-transition: all .3s;
    -moz-transition: all .3s;
    -o-transition: all .3s;
    -ms-transition: all .3s;
    transition: all .3s;
  }
  #aside_content .card-content {
    padding: 1rem 1.2rem;
  }
  .tool a {
    color: #FF0066;
  }

  .is-center {
    text-align: center;
  }

  #aside_content .card-info img {
    display: inline-block;
    padding: 5px;
    width: 120px;
    height: 120px;
    border-radius: 70px;
    vertical-align: top;
    transition: all .3s;
  }
  img {
    max-width: 100%;
    transition: all .2s;
  }
  .avatar-img {
    animation: avatar_turn_around 2s linear infinite;
  }
  #aside_content .card-info .author-info__name {
    font-weight: 500;
    font-size: 1.1rem;
  }
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
<body>
<div class="where">
  <ul>
    <li><img  src="<c:url value="img/导航栏.png"/>"></li>
  </ul>
</div>
<div class="welcome">修改信息</div>
<div class="welcome">欢迎您的登录</div>
<div class="bj_foot"> <h6>欢迎来到骑手信息界面</h6></div>
</body>
</html>
<head>
    <meta charset="UTF-8">
    <title>美了么外卖送餐平台</title>
    <meta charset="utf-8">
    <script src="http://code.jquery.com/jquery-latest.js"type="text/javascript"></script>
</head>
<div id="content-outer">
  <div class="layout_page" id="content-inner">
    <div class="aside_content" id="aside_content">
      <div class="card-widget card-info">
        <div class="card-content">
          <div class="card-info-avatar is-center">
            <div class="author-info__name">电话:${riderSession.phone}</div>
            <div class="author-info__phone">姓名:${riderSession.name}</div>
            <div class="author-info__sex">身份证卡号:${riderSession.id_card}</div>
            <div class="author-info__name">银行卡:${riderSession.bank_card}</div>
            <div class="author-info__name">工作城市:${riderSession.work_city}</div>
            <div class="author-info__name">状态:${riderSession.status}</div>
          </div>
        </div>
      </div>
    </div>
    <article id="page">
      <div class="article-container">
        <h2>驾驶证</h2>
          <div>
              <img class="pimg" src="picturedriver_license?id=${riderSession.id }" style="width:300px;height:300px;">
          </div>
      </div>
    </article>
  </div>
</div>
</body>
</html>