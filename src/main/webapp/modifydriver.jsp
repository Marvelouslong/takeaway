<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<style>
  .add_button1{
    background-color: rgba(252,216,163,0.41);
    border: 0;
    padding: 5px;
    border-radius:200px;
    width: 100px;
    height: 40px;
    font-size: large;
  }
  .add_button1:hover{
    background-color: rgba(246,184,120,0.41);
  }
  .div1{
    height:90%;
    position: absolute;
    width: 100%;
    background-image: linear-gradient(to bottom right, #ffffff, #fcd8a3);
    /*left: 700px;*/
    top:60px;
    border-right-color:black;
    box-shadow:0px 3px 3px #c8c8c8 ;
  }
  .div2{
    height:90%;
    position: absolute;
    width: 70%;
    background-color: white;
    left: 250px;
    top:60px;
    box-shadow:0 3px 3px #c8c8c8 ;
    overflow-y:auto;
  }
</style>
<head lang="en">
  <meta charset="UTF-8">
  <title>美了么外卖送餐平台</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
</head>
<body>
<!--头部-->
<header class="publicHeader">
  <h1>修改</h1>
  <div class="publicHeaderR">
    <p><span>您好！</span><span style="color:#b6afaf"> ${riderSession.name}</span>  欢迎你！</p>
    <a href="rob_ordernews">抢单</a>
    <a href="modifycontext.jsp">修改信息</a>
    <a href="riderinformation.jsp">我的</a>
    <a href="admin-out">退出</a>
  </div>
</header>
<script>
  const form = document.getElementById('upload-form');
  const submitBtn = document.getElementById('submitBtn');
  submitBtn.addEventListener('click', () => {
    form.submit();
  });

</script>
<html>
<body>
<div class="bj"></div>
<div class="div1">
  <div class="div2">

    <form  action="<c:url value="/modifydriver"/>" method="post"  class="smart-green" enctype="multipart/form-data"  id="upload-form" style="text-align: center">
      <label>
        <span style="font-size: large">驾驶证图片 :</span><br>
        <img id="imagePreview" name="image"  src="#" alt="图片预览" style="width: 100px;height: 100px"><br>
        <br>
        <input name="image" type="file"  id="fileInput"><br>
      </label>
      <label style="font-size: large">
        <button type="submit"  class="add_button1" value="完成">完成</button>
      </label>
    </form>
  </div>
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
</div>
</body>
</html>
