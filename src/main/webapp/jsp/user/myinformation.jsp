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
    font-size: 1.1rem;}

  .div3{
    display: none;

  }
  .show {
    background-color: #fbfbfb;
    display: block;
    height:300px;
    width: 300px;
    padding-left: 20px;
    border: 1px black;
    z-index: 3;
    left:500px;
    top: 100px;
    position: absolute;
  }
  .hide{
    display: none;
  }
</style>
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
            <br>
            <a href="Userservlet?method=jump">修改个人信息</a>
            <br>            <br>
            <form id="upload-form" action="Userservlet" method="get">
              <input type="hidden" name="method" value="change_receiver">
              <c:forEach var="re" items="${receiverlist}" varStatus="status">
                序号：${status.index+1}
                <br>
                  接收人：
                      <input type="text" name="name[${status.index}]" value="${re.name}">
                    <br>
                    电话：<input type="text" name="phone[${status.index}]" value="${re.phone}">
                <br>
                    地址：
                <input type="text" name="address[${status.index}]" value="${re.address}">
                <br>
                <br>
                <input type="hidden" name="id[${status.index}]" value="${re.id}">
                <button type="submit" id="submitBtn" name="submitBtn" value="${status.index}">修改</button>
                <br>
              </c:forEach>
            </form>
            <button  id="btn6" value="隐藏">增加接收人</button>
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
            <td> <img src="Userservlet?id=${order._s.id}&method=img"
                      style="animation: avatar_turn_around 2s linear infinite;
                         display: inline-block;
                         padding: 5px;
                         width: 50px;
                         height: 50px;
                         border-radius: 70px;
                         vertical-align: top;
                         transition: all .3s;"
                      alt="img"></td>
            <td style="padding-left: 30px;padding-top: 20px">骑手：${order._r.name != null ? order._r.name : '暂无人接单'}<br>骑手电话：${order._r.phone != 0 ? order._r.phone : '暂无人接单'}</td>
            <td style="padding-left: 30px;padding-top: 20px">商家：${order._s.shop_name}<br>商家电话：${order._s.con_telephone}</td>
            <td style="padding-left: 30px;padding-top: 20px">订单状态：${order.status}<br>订单时间：${order.order_time}<br>订单金额：${order.money}</td>
            <td style="padding-left: 30px;padding-top: 20px">接收人：${order._re.name}<br>接收人电话：${order._re.phone}<br>接收地址${order._re.address}</td>
            <td style="padding-left: 30px;padding-top: 20px"><a class="vieworder" href="Userservlet?method=showdishes&id=${order.id}">查看菜品</a></td>
            <td style="padding-left: 10px;padding-top: 20px"><a class="vieworder" href="Userservlet?method=showevaluate&id=${order.id}">添加评论</a></td>
            <td style="padding-left: 10px;padding-top: 20px"><a class="vieworder" href="Userservlet?method=query&query=${order._s.shop_name}&pageIndex=1">再来一单</a></td>
            <td style="padding-left: 10px;padding-top: 20px"><c:if test="${order.status eq '正在配送'}"><a href="Userservlet?method=changeostatus&id=${order.id}">确认收货</a></c:if></td>
            </tr>
          </c:forEach>
          <c:set var="isExecuted" value="false" />
          <c:forEach items="${dishlist}" var="dish" varStatus="status">
            <c:if test="${not isExecuted}">
              <a href="<c:url value="Userservlet">
                <c:param name="method" value="myinformation"/>
                </c:url>">返回订单</a>
              <c:set var="isExecuted" value="true" />
            </c:if>
            <tr>
              <td> <img src="Userservlet?id=${dish.id}&method=img2"
                        style="animation: avatar_turn_around 2s linear infinite;
                         display: inline-block;
                         padding: 5px;
                         width: 50px;
                         height: 50px;
                         border-radius: 70px;
                         vertical-align: top;
                         transition: all .3s;"
                        alt="img"></td>
              <td style="padding-left: 40px;padding-top: 20px">菜名：${dish.name}<br>价钱：${dish.price}</td>
            </tr>
           </c:forEach>
        </table>
       </div>
      </article>
    </div>
  </div>
<div class="div3" id="div3">
  <form method="get" action="Userservlet">
    <input type="hidden" name="method" value="addre">
    <h4>添加接收人姓名：</h4>
    <br>
    <input type="text" name="name">
    <br>
    <h4>添加接收人电话：</h4>
    <br>
    <input type="text" name="phone">
    <br>
    <h4>添加接收地址：</h4>
    <br>
    <input type="text" name="address">
    <br>
    <label>
      <input type="submit" class="button" name="mm" value="提交"/>
      <input type="submit" class="button" name="mm" value="取消"/>
    </label>
  </form>
</div>
</body>
</html>
<script>
  const form = document.getElementById('upload-form');
  const submitBtn = document.getElementById('submitBtn');
  submitBtn.addEventListener('click', () => {
    form.submit();
  });

  var btn = document.getElementById("btn6");
  var div = document.getElementById("div3");
  btn.onclick = function () {
    if(this.value === "隐藏"){
      div.className = "hide";
      btn.value = "显示"
    }else{
      div.className = "show";
      btn.value = "隐藏"
    }
  }
</script>