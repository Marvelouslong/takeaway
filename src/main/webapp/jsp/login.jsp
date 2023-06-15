<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>美了么外卖送餐平台</title>
  <link type="text/css" rel="stylesheet" href="../css/style.css">
  <script type="text/javascript">
  </script>
</head>
<body class="login_bg">
<section >
  <header class="loginHeader" >
    <h1>美了么外卖送餐平台</h1>
  </header>
  <section class="loginCont">
    <form  action="${pageContext.request.contextPath }/login.do"  name="actionForm" id="actionForm"  method="post" >
<%--      <div class="info">${error}</div>--%>
      <div class="inputbox">
        <font color="white">用户名：</font>
        <input type="text" class="input-text"  name="name" placeholder="请输入用户名" required/>
      </div>
      <div class="inputbox">
        <font color="white">密&ensp;&ensp;码：</font>
        <input type="password" name="password" placeholder="请输入密码" required/>
      </div>
<%--      <div class="form-group">--%>
<%--      </div>--%>
      <div class="subBtn">
        <input type="submit" value="登录"/>
        <input type="reset" value="重置"/>
      </div>
    </form>
  </section>
</section>
</body>
</html>

</body>
</html>
