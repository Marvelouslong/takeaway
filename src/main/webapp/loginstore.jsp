<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    input::-webkit-input-placeholder {
        color: black;
        font-size: 14px;
    }
    .login_bg {
        background:url("img/外卖.jpg");
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
<body  class="login_bg">
<section >
    <header class="loginHeader" >
        <h1 style="color:#000;">美了么商家登录</h1>
    </header>
    <section class="loginCont">
        <form  action="${pageContext.request.contextPath }/loginstore.do"  name="actionForm" id="actionForm"  method="post" >
            <div class="info">${error}</div>
            <div class="inputbox">
                <font color="black">账&ensp;&ensp;号：</font>
                <input id="input" style="background-color:transparent" type="text" class="input-text"  name="con_telephone" placeholder="请输入账号" required/>
            </div>
            <div class="inputbox">
                <font color="black">密&ensp;&ensp;码：</font>
                <input id="input" style="background-color:transparent" type="password" name="password" placeholder="请输入密码"  required/>
            </div>
            <div class="subBtn">
                <input style="background-color:transparent;color: black" type="submit" value="登录"/>
                <input style="background-color:transparent;color:#000;" type="reset" value="重置"/>
            </div>
        </form>
    </section>
</section>
</body>
</html>