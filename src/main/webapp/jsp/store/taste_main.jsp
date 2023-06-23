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
  <span class="span1">口味类型:</span>
  <table class="dish_table">
    <thead>
    <tr><th>名称</th><th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="taste" >
      <tr>
        <td>${taste.name}</td>
        <td>
          <button type="button">删除</button>
          <button type="button">修改</button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <button id="btn6" value="隐藏" class="add_button">添加新口味</button>
  <div class="div3" id="div3">
    <form method="post" action="<c:url value="/TASTE?method=add"/>" class="taste_add">
      <h4>添加口味信息</h4>
      <br>
      <br>
      <br>
      <label>
        <span>菜品序号 :</span>
        <input type="text" name="d_id"  placeholder="请输入菜品序号">
      </label>
      <br>
      <br>
      <label>
        <span>口&ensp;&ensp;&ensp;味 :</span>
        <input type="text" name="name"  placeholder="请输入口味名称">
      </label>
      <br>
      <br>
      <label>
        <input type="submit" class="button" value="提交"/>
        <input type="submit" class="button" value="取消"/>
      </label>
    </form>
  </div>
</div>
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
</body>
</html>
