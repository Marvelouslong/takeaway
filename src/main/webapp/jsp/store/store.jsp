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
      <table style=" margin: auto; text-align: center;">
        <tr><td style="width: 400px"><img  src="<c:url value="/picturebrand_authorization?id=${shopSession.id}"/>" alt="image" style="height: 200px;width: 300px;border-radius:200px;
    "><br>营业执照</td>
        <td style="width: 400px"><img  src="<c:url value="/picturelicense?id=${shopSession.id}"/>" alt="image" style="height: 200px;width: 300px;border-radius:200px;
    "><br>营业许可证</td>
        </tr>
        <tr>
              <td style="width: 400px"><img  src="<c:url value="/picturecertificate_of_business?id=${shopSession.id}"/>" alt="image" style="height: 200px;width: 300px;border-radius:200px;
    "><br style="width: 400px">授权书</td>
                <td> <img  src="<c:url value="/pictureshop_picture?id=${shopSession.id}"/>" alt="image" style="height: 200px;width: 300px;border-radius:200px;
   "><br>商店图片（头像）</td></tr>
      </table>
      <form style="float: right" action="<c:url value="/jsp/store/store_imgupdate1.jsp"/>" method="post">
        <input type="hidden" name="id" value="${shopSession.id}">
        <button type="submit" value="编辑">编辑基础信息（无需审核）</button>
      </form>
      <form  style="float: right" action="<c:url value="/jsp/store/store_imgupdate2.jsp"/>" method="post">
        <input type="hidden" name="id" value="${shopSession.id}">
        <button type="submit" value="编辑">编辑非基础信息（需要重新审核）</button>
      </form>

    </article>
  </div>
</div>
</html>