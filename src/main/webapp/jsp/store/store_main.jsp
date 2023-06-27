<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@include file='where.jsp'%>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/jsp/store/store.css"/>" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="bj"></div>

<div class="div1">
   <img  src="pictureshop_picture?id=${shopSession.id}" alt="image" style="height: 150px;width: 150px;border-radius:200px;margin-left: 65px;
    margin-top: 10%;">
    <p class="p1">${shopSession.shop_name}</p>
    <p>主营类型：${shopSession.main_category}</p>
    <p>辅营类型：${shopSession.auxiliary_category}</p>
    <p>店铺地址：${shopSession.address}</p>
</div>
<div class="div2">
    <span class="span1">店内已有菜品:</span>
   <div class="search"> <form method="post" action="<c:url value="/DISHES?method=dishes_search"/>">
       <input  class="search_input" type="text" style="border: 0px" placeholder="请输入菜名" name="name">
       <button class="search_button" type="submit" value="提交" style="border-right: 1px black">搜索</button>
   </form></div>
    <button class="add_button" onclick="window.location.href='jsp/store/dish_add.jsp'">添加新的菜品</button>
    <table class="dish_table">
     <thead>
        <tr>
        <th>序号</th> <th>菜品</th><th width="100px">菜品描述</th><th>类别</th><th>状态</th><th>价格</th><th>操作</th>
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
       <form action="<c:url value="/jsp/store/dish_updata.jsp"/>" method="post">
        <input type="hidden" name="d_id" value="${dish.id}">
           <button type="submit" value="编辑">编辑</button>
        </form>
    <form action="<c:url value="/DISHES?method=dishes_del"/>" method="post">
        <input type="hidden" name="d_id" value="${dish.id}">
        <button type="submit" value="删除">删除</button>
    </form>

    <form action="<c:url value="/TASTE?method=list&d_id=${dish.id}"/>" method="post">
        <button type="submit" value=""> 选择菜品口味</button>
    </form>
         </td>
     </tr>
      </c:forEach>
        </tbody>
    </table>



</div>
</body>
<script>
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
</html>
