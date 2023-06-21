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
</style>
<%--<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>--%>
<%--<script>--%>
<%--  //当选着文件后内容被改变调用方法--%>
<%--  $("#fileInput").change(function () {--%>
<%--    var file = this.files[0];--%>
<%--    if (window.FileReader) {--%>
<%--      var reader = new FileReader();--%>
<%--      reader.readAsDataURL(file);--%>
<%--      reader.onloadend = function (e) {--%>
<%--        $("#image").attr("src", e.target.result);--%>
<%--      };--%>
<%--    }--%>
<%--  });--%>
<%--</script>--%>
<%--<script>--%>
<%--  const form = document.querySelector('#upload-form');--%>
<%--  const input = document.querySelector('#fileInput');--%>
<%--  form.addEventListener('submit', (event) => {--%>
<%--    event.preventDefault(); // 阻止表单提交--%>
<%--    const file = input.files[0];--%>
<%--    if (file) {--%>
<%--      const formData = new FormData();--%>
<%--      formData.append('image', file);--%>
<%--      fetch('/Userservlet', {--%>
<%--        method: 'GET',--%>
<%--        body: formData,--%>
<%--        headers: {--%>
<%--          'Content-Type': 'multipart/form-data' // 设置请求头中的content type--%>
<%--        }--%>
<%--      }).then(response => {--%>
<%--        return response.text();--%>
<%--      }).then(result => {--%>
<%--        const resultEl = document.getElementById('result');--%>
<%--        resultEl.innerText = '上传成功，文件ID：' + result;--%>
<%--      }).catch(error => {--%>
<%--        console.error(error);--%>
<%--      });--%>
<%--    }--%>
<%--  });--%>
<%--</script>--%>
<script>
  const form = document.getElementById('upload-form');
  const submitBtn = document.getElementById('submitBtn');
  submitBtn.addEventListener('click', () => {
    form.submit();
  });
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
        <form action="user" method="post">
          <input type="hidden" name="method" value="orderlist">
          <c:forEach items="${orderlist}" var="order" varStatus="status">
            ${order.s_name}
            ${order.r_phone}
            ${order.status}
            ${order.d_name}
            ${order.money}
            <hr>
          </c:forEach>
        </form>
      </div>
    </article>
  </div>
</div>
</body>
</html>
