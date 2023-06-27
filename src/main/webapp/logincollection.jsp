<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
  input::-webkit-input-placeholder {
    color: black;
    font-size: 14px;
  }
  .logincollection_bg {
    background:url("img/商家登陆.jpg");
    style:"background-repeat:no-repeat";
    background-attachment:fixed;
    background-size:100% 100%;
  }
</style>
<html>
<head >
  <title>美了么外卖送餐平台</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/store.css">
  <script type="text/javascript">
  </script>
</head>
<body  class="logincollection_bg">
<section >
  <header class="loginHeader" >
    <h1 style="color:#000;">美了么外卖送餐平台登录</h1>
  </header>
  <section class="loginCont">
    <form name="storeForm" method="post" action="loginstore.jsp" style="text-align: center" >
    <div>
      <input type="submit" name="store" id="store" value="商家登录" style="background-color:transparent;width: 150px;height: 40px;font-size:large;text-align: center;color:black">
    </div>
    </form>
    <form method="post" action="loginuser.jsp" style="text-align: center" >
      <div>
        <input type="submit" name="user" id="user" value="用户登录" style="background-color:transparent;width: 150px;height: 40px;font-size:large;text-align: center;color: black">
      </div>
    </form>
    <form name="adminForm" method="post" action="loginadmin.jsp" style="text-align: center" >
      <div>
        <input type="submit" name="admin" id="admin" value="管理员登录" style="background-color:transparent;width: 150px;height: 40px;font-size:large;text-align: center;color: black">
      </div>
    </form>
    <form name="riderForm" method="post" action="loginrider.jsp" style="text-align: center" >
      <div>
        <input type="submit" name="rider" id="rider" value="骑手登录" style="background-color:transparent;width: 150px;height: 40px;font-size:large;text-align: center;color: black">
      </div>
    </form>
  </section>
</section>
<p><a href="storeregister.jsp" style="color: #00FFFF">未注册？商家注册</a></p>
<p><a href="riderregister.jsp" style="color: #00FFFF">未注册？骑手注册</a></p>
<p><a href="userregister.jsp" style="color: #00FFFF">未注册？用户注册</a></p>
<p><a href="adminregister.jsp" style="color: #00FFFF">未注册？管理员注册</a></p>
</body>
</html>
