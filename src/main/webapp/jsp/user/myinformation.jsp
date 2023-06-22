<%--
  Created by IntelliJ IDEA.
  User: HAN
  Date: 2023/6/18
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
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
  #aside_content .card-info .author-info__name {
    font-weight: 500;
    font-size: 1.1rem;
  }
     /* 弹窗的样式，可自行调整样式 */
   .popup {
     position: fixed;
     top: 50%;
     left: 50%;
     transform: translate(-50%, -50%);
     padding: 20px;
     background-color: #fff;
     border: 2px solid #000;
     border-radius: 10px;
     box-shadow: 0px 0px 10px #000;
     z-index: 9999;
   }
</style>
<script>
  const form = document.getElementById('upload-form');
  const submitBtn = document.getElementById('submitBtn');
  submitBtn.addEventListener('click', () => {
    form.submit();
  });
    // 点击按钮触发弹窗
    function popupFunction() {
    // 显示弹窗
    document.getElementById("popup").style.display = "block";
  }

    // 点击弹窗上的关闭按钮触发关闭弹窗
    function closePopup() {
    // 隐藏弹窗
    document.getElementById("popup").style.display = "none";
  }
</script>
<div id="content-outer">
  <div class="layout_page" id="content-inner">
    <div class="aside_content" id="aside_content">
      <div class="card-widget card-info">
        <div class="card-content">
          <div class="card-info-avatar is-center">
            <img class="avatar-img" src="Userservlet?id=${userSession.id}&method=img1" style="animation: avatar_turn_around 2s linear infinite;" alt="头像">
            <div class="author-info__name">${userSession.name}</div>
            <div class="author-info__phone">${userSession.phone}</div>
            <div class="author-info__sex">${userSession.sex}</div>
            <div class="author-info__description">${userSession.signature}</div>
            <form action="Userservlet" method="post" id="upload-form" enctype="multipart/form-data">
              <input type="hidden" name="method" value="change-user-img">
              <input type="file" id="fileInput" name="image" accept="image/png,image/jpg,image/jpeg,image/bmp"/>
              <button type="submit" id="submitBtn">上传</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <article id="page">
      <div class="article-container">
        <h2>我的订单</h2>
        <table>
          <c:forEach items="${orderlist}" var="order" varStatus="status">
            <tr>
            <td> <img src="Userservlet?id=${order._o._s.id}&method=img"
                      style="animation: avatar_turn_around 2s linear infinite;
                         display: inline-block;
                         padding: 5px;
                         width: 50px;
                         height: 50px;
                         border-radius: 70px;
                         vertical-align: top;
                         transition: all .3s;"
                      alt="img"></td>
            <td>骑手：${order._o._r.phone}<br>商家：${order._o._s.con_telephone}</td>
            <td>订单状态：${order._o.status}<br>订单时间：${order._o.order_time}<br>订单金额：${order._o.money}</td>
            </tr>
            <button onclick="popupFunction()">查看详情</button>
            <div id="popup" class="popup" style="display: none;">
              <h2>${order._o._s.shop_name}</h2>
              <table>
                <tr>
                  <td> <img src="Userservlet?id=${order._o._s.id}&method=img"
                            style="animation: avatar_turn_around 2s linear infinite;
                         display: inline-block;
                         padding: 5px;
                         width: 50px;
                         height: 50px;
                         border-radius: 70px;
                         vertical-align: top;
                         transition: all .3s;"
                            alt="img"></td>
                  <td>骑手：${order._o._r.phone}<br>商家：${order._s.con_telephone}</td>
                  <td>订单状态：${order._o.status}<br>订单时间：${order._o.order_time}<br>订单金额：${order.money}</td>
                </tr>
                <tr><td>
                  <c:forEach var="dish" items="${order._d}">
                    <c:out value="${dish.name}" />
                    <img src="Userservlet?id=${dish.id}&method=img"
                         style="animation: avatar_turn_around 2s linear infinite;
                         display: inline-block;
                         padding: 5px;
                         width: 120px;
                         height: 120px;
                         border-radius: 70px;
                         vertical-align: top;
                         transition: all .3s;"
                         alt="img">
                    <c:out value=", " escapeXml="false" />
                  </c:forEach>
                  </td>
                  <td>接收人姓名：${order._re.name}<br>接收人电话：${order._re.phone}</td>
                  <td>接收人地址：${order._re.address}</td>
                </tr>
                <tr><a class="vieworder" href="#">删除订单</a></tr>
                <tr><a class="vieworder" href="#">修改订单信息</a></tr>
                <tr><a class="vieworder" href="#">添加评论</a></tr>
                <tr><a class="vieworder" href="#">再来一单</a></tr>
              </table>
              <button onclick="closePopup()">关闭</button>
            </div>
            <hr>
          </c:forEach>
        </table>
      </div>
    </article>
  </div>
</div>
</body>
</html>
