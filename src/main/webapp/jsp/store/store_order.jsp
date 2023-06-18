<%--
  Created by IntelliJ IDEA.
  User: y1577
  Date: 2023/6/18
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file='where.jsp'%>
<html>
<head>
    <title>商家订单信息</title>
  <link href="store.css" rel="stylesheet">

</head>
<body>
  <div class="bj"></div>
  <div class="div1">
  <img class="div1-img" src="../../img/店铺图片.jpg" alt="店铺图片">
  <p class="p1">吃好你再来饭店</p>
  <p>主营类型：$四川菜</p>
  <p>辅营类型：$家常菜</p>
  <p>商家简介：神佛无啊回复啊回复爱好分辨出位于巴登参悟i很多不擦五大湖大无法无法</p>
  </div>
<div class="div2">
  <span class="span1">订单信息:</span>
  <table class="dish_table">
    <tr>
      <th>序号</th><th>内容</th><th>口味</th><th>备注</th><th>状态</th><th>详情</th>
    </tr>
    <tr>
      <td>$订单id</td>
      <td>鱼香肉丝</td>
      <td>酸甜</td>
      <td>不要葱花和香菜</td>
      <td>未完成</td>
      <td>
        <button  class="btn" id="btn" value="隐藏" >查看详细信息</button>
      </td>
    <tr>
      <td>$订单id</td>
      <td>鱼香肉丝</td>
      <td>酸甜</td>
      <td>不要葱花和香菜</td>
      <td>已完成</td>
      <td>
        <button  class="btn" id="btn" value="隐藏" >查看详细信息</button>
      </td>
    </tr>
    <tr>
      <td>$订单id</td>
      <td>鱼香肉丝</td>
      <td>酸甜</td>
      <td>不要葱花和香菜</td>
      <td>已完成</td>
      <td>
        <button  class="btn" id="btn" value="隐藏" >查看详细信息</button>
      </td>
    </tr>
    <tr>
      <td>$订单id</td>
      <td>鱼香肉丝</td>
      <td>酸甜</td>
      <td>不要葱花和香菜</td>
      <td>已完成</td>
      <td>
        <button  class="btn" id="btn" value="隐藏" >查看详细信息</button>
      </td>
    </tr>
    <tr>
      <td>$订单id</td>
      <td>鱼香肉丝</td>
      <td>酸甜</td>
      <td>不要葱花和香菜</td>
      <td>已完成</td>
      <td>
        <button  class="btn" id="btn" value="隐藏" >查看详细信息</button>
      </td>
    </tr>
    <tr>
      <td>$订单id</td>
      <td>鱼香肉丝</td>
      <td>酸甜</td>
      <td>不要葱花和香菜</td>
      <td>已完成</td>
      <td>
        <button  class="btn" id="btn" value="隐藏" >查看详细信息</button>
      </td>
    </tr>
    <tr>
      <td>$订单id</td>
      <td>鱼香肉丝</td>
      <td>酸甜</td>
      <td>不要葱花和香菜</td>
      <td>已完成</td>
      <td>
        <button  class="btn" id="btn" value="隐藏" >查看详细信息</button>
      </td>
    </tr>
    <tr>
      <td>$订单id</td>
      <td>鱼香肉丝</td>
      <td>酸甜</td>
      <td>不要葱花和香菜</td>
      <td>已完成</td>
      <td>
        <button  class="btn" id="btn" value="隐藏" >查看详细信息</button>
      </td>
    </tr>
  </table>
  <div  class="div3" id="div3">
    临千仞之溪，非才长也，位高也！
  </div>
</div>
  <script>
    var btn = document.getElementById("btn");
    var div = document.getElementById("div3");
    btn.onclick = function () {
      if(this.value === "隐藏"){
        div.className = "hide";
        btn.value = "显示";
      }else {
        div.className = "show";
        btn.value = "隐藏";
      }
    }
  </script>
</body>
</html>
