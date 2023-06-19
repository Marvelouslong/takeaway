<%--
  Created by IntelliJ IDEA.
  User: y1577
  Date: 2023/6/19
  Time: 1:22
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
    <button class="btn" onclick="window.location.href = 'store_order.jsp'"><<  返回界面</button>
    <div class="div10">
    <div class="div8">
        <span>订单序号 :$序号</span>      <span style="float: right">付款方式:$微信支付</span> <br> <br>
        <span>收货人姓名 :$姓名</span>        <span style="float: right">订单状态 :$未完成</span> <br>  <br>
        <span>收货人电话 :$15776957349</span> <span style="float: right">下单时间 :$2023.06.19</span> <br>  <br>
        <span style="float: right">实收总金额 :$100</span><br>
      <hr>
        <div style="height: 100px">备注:<br>
                    $不要辣椒不要葱不要香菜</div>
        <hr>
    </div>
 <br>
        <p> 商 品：</p>
        <table class="order_table">
            <tr>
                <td>菜 名 :$鱼香肉丝</td>
                <td>口 味 :$酸甜</td>
                <td>金 额 :$100</td>
            </tr>
            <tr>
                <td>菜 名 :$鱼香肉丝</td>
                <td>口 味 :$酸甜asadasda</td>
                <td>金 额 :$100</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
