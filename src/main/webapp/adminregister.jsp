<%--
  Created by IntelliJ IDEA.
  User: liangsicheng
  Date: 2023/6/19
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>管理员注册页面</title>
  <style>
    #app{
      background-image: url(https://img-qn-2.51miz.com/preview/video/00/00/12/17/V-121759-83916990.jpg);
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: 100% 100%;
    }
    h1{
      margin-left: 10px;
    }
    .susu.ruirui input{
      width: 220px;
      height: 30px;
      margin: 8px 0px;
      border-radius: 15px;
    }

    #napp{
      border: #e2f6ba 3px ;
      height: 800px;
      width:600px;
      margin-left: 500px;
      margin-top: 10px;
      color: #0C0C0C;
      font-size: 25px;
    }
    .h{
      margin-left: 20px;
      width: 100px;
      margin-top: 20px;
    }
  </style>
</head>
<body>
<div id="app">
  <div id="napp" class="susu">
    <h1>管理员注册</h1>
    <div class="ruirui">
      <form  active="#" method="get" name="form0" onclick="return check()">
        <p>&nbsp;管理员姓名&nbsp;:<input type="text" name="name" id="name" placeholder="请输入姓名"></p>
        <p>&nbsp;账号&nbsp;&nbsp;&nbsp; :<input type="text" name="account" id="account" placeholder="请输入账号"></p>
        <p>&nbsp;密码 :<input type="text" name="password" id="password" placeholder="请输入密码"></p>
        <p>&nbsp;&nbsp;<input class="h" type="submit" value="注册"></p>
        <span style="color: #FD482C;font-size: 15px" id="tip">${tip}  </span>
      </form>
    </div>
  </div>
</div>


</body>
</html>

<script>
  function check() {
    let name = document.getElementById("name").value;
    let account = document.getElementById("account").value;
    let password = document.getElementById("password").value;
    if (name == null || name.trim() == "") {
      alert("姓名不能为空!");
      document.getElementById("tip").innerHTML = "姓名不能为空!";
      return false;
    }
    if (account == null || account.trim() == "") {
      alert("账号不能为空!");
      document.getElementById("tip").innerHTML = "账号不能为空!!";
      return false;
    }
    if (password == null || password.trim() == "") {
      alert("密码不能为空!");
      document.getElementById("tip").innerHTML = "密码不能为空!";
      return false;
    }
    if (check(name)&&check(account)&&check(name)&&check(password)){
      alert("注册成功");
      document.getElementById("tip").innerHTML="注册成功!";
      return ture;
    }
  }
</script>
