<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: liangsicheng
  Date: 2023/6/19
  Time: 13:55
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
            formData.append('brand_authorization', file);
            fetch('/upload', {
                method: 'POST',
                body: formData
            }).then(response => {
                // 处理上传结果
            });
        }
    });
</script>
<script>
    const form = document.querySelector('#upload-form');
    const input = document.querySelector('#fileInput');
    form.addEventListener('submit', (event) => {
        event.preventDefault(); // 阻止表单提交
        const file = input.files[0];
        if (file) {
            const formData = new FormData();
            formData.append('license', file);
            fetch('/upload', {
                method: 'POST',
                body: formData
            }).then(response => {
                // 处理上传结果
            });
        }
    });
</script>
<script>
    const form = document.querySelector('#upload-form');
    const input = document.querySelector('#fileInput');
    form.addEventListener('submit', (event) => {
        event.preventDefault(); // 阻止表单提交
        const file = input.files[0];
        if (file) {
            const formData = new FormData();
            formData.append('certificate_of_business', file);
            fetch('/upload', {
                method: 'POST',
                body: formData
            }).then(response => {
                // 处理上传结果
            });
        }
    });
</script>
<script>
    const form = document.querySelector('#upload-form');
    const input = document.querySelector('#fileInput');
    form.addEventListener('submit', (event) => {
        event.preventDefault(); // 阻止表单提交
        const file = input.files[0];
        if (file) {
            const formData = new FormData();
            formData.append('shop_picture', file);
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
  <title>商家注册页面</title>
  <style>
    #app{
      background-image: url("https://img.51miz.com/preview/element/00/01/10/42/E-1104263-F3A6C089.jpg");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: 100% 100%;
    }
    #napp{
      border: #f3b9b9 8px solid;
      width:600px;
      margin-left: 500px;
      margin-top: 10px;
      color: #0C0C0C;
      font-size: 25px;

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
    .h{
      margin-left: 20px;
      width: 300px;
      margin-top: 20px;
    }
  </style>
</head>
<body>
<div id="app">
  <div id="napp" class="susu">
    <h1>商家注册页面</h1>
    <div class="ruirui">
      <form  action="${pageContext.request.contextPath}/storeregister" method="post" name="form0" enctype="multipart/form-data" id="upload-form">
        <p>&nbsp;商家名称&nbsp;:<input type="text" name="shop_name" id="shop_name" placeholder="请输入商家名称"></p>
        <p>&nbsp;地址&nbsp;&nbsp;&nbsp; :<input type="text" name="address" id="address" placeholder="请输入商家地址"></p>
        <p>&nbsp;公司银行卡&nbsp;&nbsp;&nbsp; :<input type="text" name="bank_card" id="bank_card" placeholder="请输入公司银行卡号"></p>
        <p>&nbsp;联系人姓名&nbsp;&nbsp;&nbsp; :<input type="text" name="con_name" id="con_name" placeholder="请输入联系人姓名"></p>
        <p>&nbsp;法人身份证&nbsp;&nbsp;&nbsp; :<input type="text" name="legal_id_card" id="legal_id_card" placeholder="请输入法人身份证号"></p>
        <p>&nbsp;联系人电话 :<input type="text" name="con_telephone" id="con_telephone" placeholder="请输入联系人电话号码"></p>
        <p>&nbsp;主营品类&nbsp;:<input type="text" name="main_category" id="main_category" placeholder="请输入主营品类"></p>
        <p>&nbsp;辅营品类&nbsp;:<input type="text" name="auxiliary_category" id="auxiliary_category" placeholder="请输入辅营品类"></p>
        <p>&nbsp;密码&nbsp;&nbsp;&nbsp;:<input type="password" name="password" id="password" placeholder="请输入登录密码"></p>
        <p><label>
              <span>营业执照图片 :</span><br>
              <img id="imagePreview1" src="#" alt="图片预览">
              <br>
              <input name="brand_authorization" type="file" id="fileInput1">
          </label>
          </p>
          <p><label>
              <span>营业许可证图片 :</span><br>
              <img id="imagePreview2" src="#" alt="图片预览">
              <br>
              <input name="license" type="file" id="fileInput2">
          </label>
          </p>
          <p><label>
              <span>商标授权书图片 :</span><br>
              <img id="imagePreview3" src="#" alt="图片预览">
              <br>
              <input name="certificate_of_business" type="file" id="fileInput3">
          </label>
          </p>
          <p>
              <label>
                  <span>添加实体店铺照片图片 :</span><br>
                  <img id="imagePreview4" src="#" alt="图片预览">
                  <br>
                  <input name="shop_picture" type="file" id="fileInput4">
              </label>
          </p>
          <button type="submit" onclick="return check()" value="注册">注册</button>
        <span style="color: #FD482C;font-size: 15px" id="tip">${tip}  </span>
      </form>
    </div>
  </div>
</div>


    <script>
    function check() {
    let shop_name = document.getElementById("shop_name").value;
    let address = document.getElementById("address").value;
    let con_name = document.getElementById("con_name").value;
    let con_telephone = document.getElementById("con_telephone").value;
    let password = document.getElementById("password").value;
    let main_category = document.getElementById("main_category").value;
    let auxiliary_category = document.getElementById("auxiliary_category").value;
    if (shop_name == null || shop_name.trim() === "") {
    alert("商家名称不能为空!");
    document.getElementById("tip").innerHTML = "商家名称不能为空!";
    return false;
    }
    if (address == null || address.trim() === "") {
        alert("商家地址不能为空!");
        document.getElementById("tip").innerHTML = "商家地址不能为空!!";
        return false;
    }
    if (con_name == null || con_name.trim() === "") {
        alert("联系人姓名不能为空!");
        document.getElementById("tip").innerHTML = "联系人姓名不能为空!";
        return false;
    }

    if (con_telephone == null || con_telephone.trim() === "") {
    alert("电话号码不能为空!");
    document.getElementById("tip").innerHTML = "电话号码不能为空!";
    return false;
    }
    if (main_category == null || main_category.trim() === "") {
    alert("主营品类不能为空!");
    document.getElementById("tip").innerHTML = "主营品类不能为空!";
    return false;
    }
    if (auxiliary_category == null || auxiliary_category.trim() === "") {
    alert("辅营品类不能为空!");
    document.getElementById("tip").innerHTML = "辅营品类不能为空!";
    return false;
    }
    if (password == null || password.trim() === "") {
    alert("密码不能为空!");
    document.getElementById("tip").innerHTML = "密码不能为空!";
    return false;
    }
    }
    </script>
<script>
    const fileInput1 = document.getElementById('fileInput1');
    const imagePreview1 = document.getElementById('imagePreview1');

    fileInput1.addEventListener('change', function() {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            reader.addEventListener('load', function() {
                imagePreview1.setAttribute('src', this.result);
            });
            reader.readAsDataURL(file);
        }
    });
</script>
<script>
    const fileInput2 = document.getElementById('fileInput2');
    const imagePreview2 = document.getElementById('imagePreview2');

    fileInput2.addEventListener('change', function() {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            reader.addEventListener('load', function() {
                imagePreview2.setAttribute('src', this.result);
            });
            reader.readAsDataURL(file);
        }
    });
</script>
<script>
    const fileInput3 = document.getElementById('fileInput3');
    const imagePreview3 = document.getElementById('imagePreview3');

    fileInput3.addEventListener('change', function() {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            reader.addEventListener('load', function() {
                imagePreview3.setAttribute('src', this.result);
            });
            reader.readAsDataURL(file);
        }
    });
</script>
<script>
    const fileInput4 = document.getElementById('fileInput4');
    const imagePreview4 = document.getElementById('imagePreview4');

    fileInput4.addEventListener('change', function() {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            reader.addEventListener('load', function() {
                imagePreview4.setAttribute('src', this.result);
            });
            reader.readAsDataURL(file);
        }
    });
</script>


</body>
</html>

