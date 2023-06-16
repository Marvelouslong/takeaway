<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
  input::-webkit-input-placeholder {
    color: #2d2d2d;
    font-size: 14px;
  }</style>
<html>
<head>
  <title>美了么外卖送餐平台</title>
  <link type="text/css" rel="stylesheet" href="css/style.css">
  <script type="text/javascript">
  </script>
</head>
<body class="login_bg">
<section >
  <header class="loginHeader" >
    <h1>美了么管理员登陆</h1>
  </header>
  <section class="loginCont">
    <form  action="${pageContext.request.contextPath }/login.do"  name="actionForm" id="actionForm"  method="post" >
      <div class="info">${error}</div>
      <div class="inputbox">
        <font color="black">账&ensp;&ensp;号：</font>
        <input id="input" style="background-color:transparent" type="text" class="input-text"  name="account_number" placeholder="请输入账号" required/>
      </div>
      <div class="inputbox">
        <font color="black">密&ensp;&ensp;码：</font>
        <input id="input" style="background-color:transparent" type="password" name="password" placeholder="请输入密码"  required/>
      </div>
      <div class="subBtn">
        <input style="background-color:transparent" type="submit" value="登录"/>
        <input style="background-color:transparent" type="reset" value="重置"/>
      </div>
    </form>
  </section>
</section>
</body>
</html>

</body>
</html>
