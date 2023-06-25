<%--
  Created by IntelliJ IDEA.
  User: liangsicheng
  Date: 2023/6/19
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
  <title>用户注册页面</title>
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
    <h1>用户注册</h1>
    <div class="ruirui">
      <form  active="userregisterServlet" method="post" name="form0" onclick="return check()">
        <p>&nbsp;用户名&nbsp;:<input type="text" name="name" id="name" placeholder="请输入用户名"></p>
        <p>&nbsp;手机号&nbsp;&nbsp;&nbsp; :<input type="text" name="phone" id="phone" placeholder="请输入手机号"></p>
        <p>&nbsp;个性签名 :<input type="text" name="signature" id="signature" placeholder="请输入个性签名"></p>
        <p>&nbsp;性别 :<input type="text" name="sex" id="sex" placeholder="请输入性别"></p>
        <p>&nbsp;密码&nbsp;:<input type="text" name="password" id="password" placeholder="请输入密码"></p>
        <p>&nbsp;头像:<form method="post" action="${ctx}/upimg" name="picture" id="picture"
                              enctype="multipart/form-data" class="contact-form">
          <div>
							<span> <label> 单张照片* </label>
							</span>
            <span>
                                <input name="src" type="file" class="textbox"
                                       required="required" accept="image/*">
							</span>
            <span>
               <input type="submit" value="提交" name="tijiao">
           </span>
          </div>
        </form>
        <button type="submit" value="注册">注册</button>
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
    let phone = document.getElementById("phone").value;
    let signature = document.getElementById("signature").value;
    let sex = document.getElementById("sex").value;
    let password = document.getElementById("password").value;
    if (name == null || name.trim() == "") {
      alert("用户名不能为空!");
      document.getElementById("tip").innerHTML = "用户名不能为空!";
      return false;
    }
    if (phone == null || phone.trim() == "") {
      alert("手机号不能为空!");
      document.getElementById("tip").innerHTML = "手机号不能为空!!";
      return false;
    }
    if (signature == null || signature.trim() == "") {
      alert("个性签名不能为空!");
      document.getElementById("tip").innerHTML = "个性签名不能为空!";
      return false;
    }
    if (sex == null || sex.trim() == "") {
      alert("性别不能为空!");
      document.getElementById("tip").innerHTML = "性别不能为空!";
      return false;
    }
    if(password == null || password.trim() == "") {
      alert("密码不能为空!");
      document.getElementById("tip").innerHTML = "密码不能为空!";
      return false;
    }
    if (check(name)&&check(phone)&&check(signature)&&check(sex)&&check(password)){
      alert("注册成功");
      document.getElementById("tip").innerHTML="注册成功!";
      return ture;
    }
  }
</script>