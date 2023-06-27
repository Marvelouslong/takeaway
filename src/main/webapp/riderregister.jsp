<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liangsicheng
  Date: 2023/6/19
  Time: 15:06
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
    <title>骑手注册页面</title>
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
      height: 50px;
      margin: 8px 0px;
      border-radius: 15px;
    }

    #napp{
      border: #e2f6ba 3px solid;
      width:600px;
      height:800px;
      margin-left: 500px;
      margin-top: 10px;
      color: #0C0C0C;
      font-size: 25px;
    }

  </style>
</head>
<body>
<div id="app">
  <div id="napp" class="susu">
    <h1>骑手注册</h1>
    <div class="ruirui">
      <form action="${pageContext.request.contextPath}/riderregister" method="post" name="form0" enctype="multipart/form-data" id="upload-form">
        <p>&nbsp;骑手姓名&nbsp;:<input type="text" name="name" id="name" placeholder="请输入姓名"></p>
        <p>&nbsp;工作城市&nbsp; :<input type="text" name="work_city" id="work_city" placeholder="请输入工作城市"></p>
        <p>&nbsp;手机号 :<input type="text" name="phone" id="phone" placeholder="请输入手机号"></p>
        <p>&nbsp;密码&nbsp;&nbsp;&nbsp;:<input type="password" name="password" id="password" placeholder="请输入登录密码"></p>
        <p>&nbsp;身份证号&nbsp;&nbsp;&nbsp;:<input type="text" name="id_card" id="id_card" placeholder="请输入身份证号"></p>
        <p>&nbsp;银行卡号&nbsp;&nbsp;&nbsp;:<input type="text" name="bank_card" id="bank_card" placeholder="请输入银行卡号"></p>
          <label>
              <span>添加驾驶证图片 :</span><br>
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
    let work_city = document.getElementById("work_city").value;
    let phone = document.getElementById("phone").value;
    let password = document.getElementById("password").value;
    let id_card = document.getElementById("id_card").value;
    let bank_card = document.getElementById("bank_card").value;
    if (name == null || name.trim() == "") {
      alert("骑手姓名不能为空!");
      document.getElementById("tip").innerHTML = "骑手姓名不能为空!";
      return false;
    }
    if (work_city == null || work_city.trim() == "") {
      alert("工作城市不能为空!")
      document.getElementById("tip").innerHTML = "工作城市不能为空!!";
      return false;
    }
    if (phone == null || phone.trim() == "") {
      alert("电话号码不能为空!")
      document.getElementById("tip").innerHTML = "电话号码不能为空!";
      return false;
    }
    if (password == null || password.trim() == "") {
      alert("密码不能为空!")
      document.getElementById("tip").innerHTML = "密码不能为空!";
      return false;
    }
    if (id_card == null || id_card.trim() == "") {
        alert("身份证号不能为空!")
        document.getElementById("tip").innerHTML = "身份证号不能为空!";
        return false;
      }
    if (bank_card == null || bank_card.trim() == "") {
        alert("银行卡号不能为空!")
        document.getElementById("tip").innerHTML = "银行卡号不能为空!";
        return false;
      }
    if (check(name)&&check(work_city)&&check(phone)&&check(password)&&check(id_card)&&check(bank_card)){
          alert("注册成功");
          document.getElementById("tip").innerHTML="注册成功!";
          return ture;
      }
    return ture;
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

