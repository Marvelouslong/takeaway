<%--
  Created by IntelliJ IDEA.
  User: y1577
  Date: 2023/6/19
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file='where.jsp'%>
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
</style>
<div id="content-outer">
  <div class="layout_page" id="content-inner">
    <div class="aside_content" id="aside_content">
      <div class="card-widget card-info">
        <div class="card-content">
          <div class="card-info-avatar is-center">
            <img  src="<c:url value="/pictureshop_picture?id=${shopSession.id}"/>" alt="image" style="height: 150px;width: 150px;border-radius:200px;margin-left: 65px;
    margin-top: 10%;">
            <div class="author-info__name">商店姓名${shopSession.shop_name}</div>
            <div class="author-info__phone">联系人电话:${shopSession.con_telephone}</div>
            <div class="author-info__sex">联系人姓名:${shopSession.con_name}</div>
            <div class="author-info__description">地址:${shopSession.address}</div>
            <div class="author-info__name">主营:${shopSession.main_category}</div>
            <div class="author-info__name">辅营:${shopSession.auxiliary_category}</div>
            <div class="author-info__name">登陆密码:${shopSession.password}</div>
            <div class="author-info__name">银行卡号:${shopSession.bank_card}</div>
            <div class="author-info__name">法定联系人身份证件:${shopSession.legal_id_card}</div>
            <div class="author-info__name">店铺审核状态:${shopSession.status}</div>

          </div>
        </div>
      </div>
    </div>
    <article id="page">
      <h2>我的信息</h2>
      <form action="<c:url value="/STORE?method=updata1"/>" method="post"  class="smart-green" enctype="multipart/form-data"  id="upload-form">
        <label>
          <span>联系电话:</span>
          <input type="text"  name="category" placeholder="请输入联系电话"/>
        </label>
        <label>
          <span>密码:</span>
          <input type="text"  name="category" placeholder="请输入新的密码"/>
        </label>
        <label>
          <span>主营菜品:</span>
          <input type="text"  name="category" placeholder="主营菜品"/>
        </label>
        <label>
          <span>辅营菜品:</span>
          <input type="text"  name="category" placeholder="请输入菜品类别，如凉菜类"/>
        </label>
        <label>
          <span>地址:</span>
          <input type="text"  name="category" placeholder="辅营菜品"/>
        </label>
      </form>
    </article>
  </div>
</div>
</html>