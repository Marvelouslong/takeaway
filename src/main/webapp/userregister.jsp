<%--
  Created by IntelliJ IDEA.
  User: liangsicheng
  Date: 2023/6/19
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<script>
  const form = document.querySelector('#upload-form');
  const input = document.querySelector('#fileInput');
  form.addEventListener('submit', (event) => {
    event.preventDefault(); // 阻止表单提交
    const file = input.files[0];
    if (file) {
      const formData = new FormData();
      formData.append('image', file);
      fetch('/upload', {
        method: 'POST',
        body: formData
      }).then(response => {
        // 处理上传结果
      });
    }
  });
</script>
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
      <form  action="${pageContext.request.contextPath}/userregister" method="post" name="form0"  enctype="multipart/form-data"  id="upload-form">
        <p>&nbsp;用户名&nbsp;:<input type="text" name="name" id="name" placeholder="请输入用户名"></p>
        <p>&nbsp;手机号&nbsp;&nbsp;&nbsp; :<input type="text" name="phone" id="phone" placeholder="请输入手机号"></p>
        <p>&nbsp;个性签名 :<input type="text" name="signature" id="signature" placeholder="请输入个性签名"></p>
        <p>&nbsp;性别 :<input type="text" name="sex" id="sex" placeholder="请输入性别"></p>
        <p>&nbsp;密码&nbsp;:<input type="text" name="password" id="password" placeholder="请输入密码"></p>
        <label>
          <span>添加头像图片 :</span><br>
          <img id="imagePreview" src="#" alt="图片预览">
          <br>
          <input name="image" type="file" id="fileInput">
        </label>
        <button type="submit" onclick="return check()" value="注册">注册</button>
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
<script>
  const fileInput = document.getElementById('fileInput');
  const imagePreview = document.getElementById('imagePreview');

  fileInput.addEventListener('change', function() {
    const file = this.files[0];
    if (file) {
      const reader = new FileReader();
      reader.addEventListener('load', function() {
        imagePreview.setAttribute('src', this.result);
      });
      reader.readAsDataURL(file);
    }
  });
</script>
