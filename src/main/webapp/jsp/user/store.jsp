<%--
  Created by IntelliJ IDEA.
  User: HAN
  Date: 2023/6/24
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<style>
  .bj{
    height:100%;
    width: auto;
    bottom:0;
    position: relative;
    z-index: 0;
    margin-top: 2px;
  }
  .div1{
    height:90%;
    position: absolute;
    width: 20%;
    background-image: linear-gradient(to bottom right, #ffffff, #fcd8a3);
    left: 3%;
    top:20px;
    border-right-color:black;
    box-shadow:0px 3px 3px #c8c8c8 ;
  }
  .div1 img{
    height: 150px;
    width: 150px;
    /*border-radius:200px;*/
    margin-left: 65px;
    margin-top: 10%;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50%;
  }
  .div2{
    height:90%;
    position: absolute;
    width: 75%;
    background-color: white;
    left: 23%;
    top:20px;
    box-shadow:0px 3px 3px #c8c8c8 ;
    overflow-y:auto;
  }
  .p1 {
    text-align: center;
  }
  p{
    margin-left: 5px;
    font-size: small;
    margin-top: 10px;
  }
  .span1 {
    top: 30px;
    margin-left: 30px;
    color: #b6b4b4;
  }
  .dish_table {
    margin-top: 15px;
    width: 100%;
    border-top: 1px solid rgba(190, 182, 182, 0.38);
    border-bottom: 1px solid rgba(190, 182, 182, 0.38);
  }

  .dish_table td{
    padding: 5px 5px;
    font-size: 15px;
    color: rgb(0, 0, 0);
    text-align: center;
  }
  .dish_table th {
    padding: 5px 5px;
    font-size: 15px;
    color: rgb(0, 0, 0);
    text-align: center;
    border-bottom: 1px solid rgba(190, 182, 182, 0.38);
  }
</style>
<%--<script>--%>
<%--  const form = document.getElementById('upload-form');--%>
<%--  const submitBtn = document.getElementById('submitBtn');--%>
<%--  submitBtn.addEventListener('click', () => {--%>
<%--    form.submit();--%>
<%--  });--%>
<%--</script>--%>
<div class="bj">
<div class="div1">
  <c:forEach items="${storelist}" var="store" varStatus="status">
    <img  src="pictureshop_picture?id=${store.id}" alt="image" style="height: 150px;width: 150px;border-radius:200px;margin-left: 65px;
    margin-top: 10%;">
    <p class="p1">${store.shop_name}</p>
    <p>主营类型：${store.main_category}</p>
    <p>辅营类型：${store.auxiliary_category}</p>
    <p>店铺地址：${store.address}</p>
  </c:forEach>
  <h4>购物车:</h4>
  <form action="Userservlet" method="post" id="upload-form">
    <input type="hidden" name="method" value="order">
    <table>
      <c:set var="isExecuted" value="false" />
      <c:forEach items="${shopcarlist}" var="shopcar" varStatus="status">
        <tr>
          <td></td>
          <td><img  src="picturedishes_picture?id=${dish.id}" style="animation: avatar_turn_around 2s linear infinite;
                             display: inline-block;
                             padding: 5px;
                             width: 25px;
                             height: 25px;
                             border-radius: 70px;
                             vertical-align: top;
                             transition: all .3s;"
                    alt="img"></td>
          <td>${shopcar._d.name}</td>
          <td>${shopcar._d.price}</td>
          <td>${shopcar.taste}</td>
          <td>${shopcar.number}</td>
        </tr>
        <tr>
          <c:if test="${not isExecuted}">
            <td>总数量：${shopcar._shopcar.total_number}</td>
            <td>总金额：${shopcar._shopcar.total_amount}</td>
            <c:set var="isExecuted" value="true" />
          </c:if>
        </tr>
      </c:forEach>
    </table>
    <input type="submit" class="button" name="mm" value="下单"/>
    <input type="submit" class="button" name="mm" value="清空购物车"/>
  </form>
</div>
<div class="div2">
  <span class="span1">店内已有菜品:</span>
  <table class="dish_table">
    <thead>
    <tr>
      <th>序号</th> <th>菜品</th><th width="100px">菜品描述</th><th>类别</th><th>状态</th><th>价格</th><th>点菜</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dishlist}" var="dish" varStatus="status">
      <tr>
        <td>${dish.id}</td>
        <td>
          <img  src="picturedishes_picture?id=${dish.id}" style="animation: avatar_turn_around 2s linear infinite;
                         display: inline-block;
                         padding: 5px;
                         width: 50px;
                         height: 50px;
                         border-radius: 70px;
                         vertical-align: top;
                         transition: all .3s;"
                alt="img">
            ${dish.name}
        </td>
        <td width="100px">${dish.describe}</td>
        <td >${dish.category}</td>
        <td>${dish.status}</td>
        <td>${dish.price}</td>
        <td>
          <a href="Userservlet?method=uptaste&id=${dish.id}">加入购物车</a>
        </td>
      </tr>
    </c:forEach>
    <form action="Userservlet" method="get">
      <c:forEach items="${tastelist}" var="taste" varStatus="status">
        <input type="hidden" name="method" value="upshop">
        <tr>
          <input type="radio" name="taste" value="${taste.name}">${taste.name} </tr>
        <tr>
          <input type="hidden" name="id" value="${dishid}">
      </tr>
      </c:forEach>
      <input type="submit" class="button" name="mm" value="加入购物车"/>
    </form>
    </tbody>
  </table>
</div>
</div>
</body>
</html>
