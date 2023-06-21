<%--
  Created by IntelliJ IDEA.
  User: y1577
  Date: 2023/6/14
  Time: 16:24
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file='where.jsp'%>
<html>
<head>
    <title>Title</title>
    <link href="store.css" rel="stylesheet">
</head>
<body>
<div class="bj"></div>
<div class="div1">
    <img class="div1-img" src="${shopSession.shop_picture}" alt="店铺图片">
    <p class="p1">${shopSession.shop_name}</p>
    <p>主营类型：${shopSession.main_category}</p>
    <p>辅营类型：${shopSession.auxiliary_category}</p>
    <p>店铺地址：${shopSession.address}</p>
</div>
<div class="div2">
    <span class="span1">添加菜品:</span>
        <form action="<c:url value="/DISHES?method=dishes_add"/>" method="post" class="smart-green" enctype="multipart/form-data" id="upload-form">
            <label>
                <span>菜名 :</span>
                <input type="text"  name="name" placeholder="请输入菜品名称"/>
            </label>
            <label>
                <span>状态 :</span>
                <select name="status">
                    <option value="t1">正在售卖</option>
                    <option value="t2">已售空</option>
                    <option value="t3">已下架</option>
                </select>
            </label>
            <label>
                <span>菜品类别:</span>
                <input type="text"  name="category" placeholder="请输入菜品类别，如凉菜类"/>
            </label>
            <label>
                <span>菜品口味（最多五个，没有写无）:</span><br><br>
                 <input type="text" name="name1" placeholder="请输入菜品口味"/>
                <input type="text" name="name2"  placeholder="请输入菜品口味"/>
                <input type="text"  name="name3" placeholder="请输入菜品口味"/>
               <input type="text"  name="name4"  placeholder="请输入菜品口味"/>
               <input type="text"  name="name5"  placeholder="请输入菜品口味"/>
            </label>
            <label>
                <span>菜品描述 :</span>
                <textarea name="describe"  placeholder="请输入菜品相关信息"></textarea>
            </label>
            <label>
                <span>售卖价格 :</span>
                <input type="number"  name="price"  placeholder="请输入菜品金额"/>
            </label>
            <label>
                <span>添加菜品图片 :</span><br>
                <img id="imagePreview" src="#" alt="图片预览">
                <br>
                <input name="image" type="file" id="fileInput">
            </label>
            <label>
                <span> </span>
                <input type="submit" class="button" value="提交"/>
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
</body>
</html>
