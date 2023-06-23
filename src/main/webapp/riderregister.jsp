<%--
  Created by IntelliJ IDEA.
  User: liangsicheng
  Date: 2023/6/19
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <title>商家注册页面</title>
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
      border: #e2f6ba 3px solid;
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
    <h1>骑手注册</h1>
    <div class="ruirui">
      <from  active="#" method="get" name="form0" onclick="return check()">
        <p>&nbsp;骑手姓名&nbsp;:<input type="text" name="name" id="name" placeholder="请输入姓名"></p>
        <p>&nbsp;工作城市&nbsp; :<input type="text" name="city" id="city" placeholder="请输入工作城市"></p>
        <p>&nbsp;手机号 :<input type="text" name="telephone" id="telephone" placeholder="请输入手机号"></p>
        <p>&nbsp;密码&nbsp;&nbsp;&nbsp;:<input type="password" name="pw" id="password" placeholder="请输入登录密码"></p>
        <p>&nbsp;驾驶证&nbsp;:<form method="post" action="${ctx}/upimg" id="form1"
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
        <p>&nbsp;身份证&nbsp;:<form method="post" action="${ctx}/upimg" id="form2"
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
        <p>&nbsp;银行卡&nbsp;:<form method="post" action="${ctx}/upimg" id="form3"
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
        <p>&nbsp;&nbsp;&nbsp;<input class="h" type="submit" value="注册">
        <span style="color: #FD482C;font-size: 15px" id="tip">${tip}  </span>
      </from>
    </div>
  </div>
</div>
</body>
</html>

<script>
  function check() {
    let name = document.getElementById("name").value;
    let city = document.getElementById("city").value;
    let telephone = document.getElementById("telephone").value;
    let password = document.getElementById("password").value;
    if (name == null || name.trim() == "") {
      alert("骑手姓名不能为空!");
      document.getElementById("tip").innerHTML = "骑手姓名不能为空!";
      return false;
    }
    if (city == null || city.trim() == "") {
      alert("工作城市不能为空!")
      document.getElementById("tip").innerHTML = "工作城市不能为空!!";
      return false;
    }
    if (telephone == null || telephone.trim() == "") {
      alert("电话号码不能为空!")
      document.getElementById("tip").innerHTML = "电话号码不能为空!";
      return false;
    }
    if (password == null || password.trim() == "") {
      alert("密码不能为空!")
      document.getElementById("tip").innerHTML = "密码不能为空!";
      return false;
    }
      if (check(name)&&check(city)&&check(telephone)&&check(password)){
          alert("注册成功");
          document.getElementById("tip").innerHTML="注册成功!";
          return ture;
      }
    return ture;
  }
</script>
