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
  </div>
  <div class="div2">
    <span class="span1">评论信息:</span>
    <table class="dish_table">
      <tr>
        <th>订单信息</th><th>用户信息</th><th>评价内容</th><th>操作</th>
      </tr>
      <c:forEach items="${list}" var="eva" varStatus="status" >
        <tr>
          <td>
            <img  src="<c:url value="/evaluate_picture?id=${eva.id}"/>" alt="image" style="border-radius:200px;width: 50px;height: 50px;
    margin-top: 10%;">
            <div  style="color: #9F9F9F;font-size: small">订单编号：${eva._o.id}</div>
          </td>
          <td>用户姓名：${eva._o._u.name}<br>
            联系电话：${eva._o._u.phone}</td>
          <td style="width: 500px">${eva.evaluate}<br>
            <br>
            <div style="font-size: small;color: #9F9F9F">${eva.shop_evaluate}</div>
          </td>
          <td>
            <span style="color: #9F9F9F;float: right;font-size: small"> ${eva._o.checkout_time}</span>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
</body>
</html>