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
  .div1{
    height:90%;
    position: absolute;
    width: 20%;
    background-image: linear-gradient(to bottom right, #ffffff, #fcd8a3);
    left: 3%;
    top:60px;
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
    top:60px;
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
  <span class="span1">店内已有菜品:</span>
  <table class="dish_table">
    <thead>
    <tr>
      <th>序号</th> <th>菜品</th><th width="100px">菜品描述</th><th>类别</th><th>状态</th><th>价格</th><th>点菜</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dishes_list}" var="dish" >
      <tr>
        <td>${dish.id}</td>
        <td>
          <img  src="picturedishes_picture?id=${dish.id}"><br>
            ${dish.name}
        </td>
        <td width="100px">${dish.describe}</td>
        <td >${dish.category}</td>
        <td>${dish.status}</td>
        <td>${dish.price}</td>
        <td>
          <button type="button">删除</button>
          <button type="button">编辑</button>
          <a href="<c:url value="/TASTE?method=list&d_id=${dish.id}"/>">
            <button type="button">
              选择菜品口味
            </button>
          </a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
