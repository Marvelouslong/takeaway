<%--
  Created by IntelliJ IDEA.
  User: y1577
  Date: 2023/6/14
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
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
    <img class="div1-img" src="../../img/店铺图片.jpg" alt="店铺图片">
    <p class="p1">吃好你再来饭店</p>
    <p>主营类型：$四川菜</p>
    <p>辅营类型：$家常菜</p>
    <p>商家简介：神佛无啊回复啊回复爱好分辨出位于巴登参悟i很多不擦五大湖大无法无法</p>
</div>
<div class="div2">
    <span class="span1">添加菜品:</span>
        <form action="/form/" method="post" class="smart-green" enctype="multipart/form-data">
            <label>
                <span>菜名 :</span>
                <input type="text"   placeholder="请输入菜品名称"/>
            </label>
            <label>
                <span>状态 :</span>
                <select>
                    <option value="t1">正在售卖</option>
                    <option value="t2">已售空</option>
                    <option value="t3">已下架</option>
                </select>
            </label>
            <label>
                <span>菜品类别:</span>
                <input type="text"   placeholder="请输入菜品类别，如凉菜类"/>
            </label>
            <label>
                <span>菜品口味（最多五个，没有写无）:</span><br><br>
                 <input type="text"   placeholder="请输入菜品口味"/>
                <input type="text"   placeholder="请输入菜品口味"/>
                <input type="text"   placeholder="请输入菜品口味"/>
               <input type="text"   placeholder="请输入菜品口味"/>
               <input type="text"   placeholder="请输入菜品口味"/>
            </label>
            <label>
                <span>菜品描述 :</span>
                <textarea  placeholder="请输入菜品相关信息"></textarea>
            </label>
            <label>
                <span>添加菜品图片 :</span><br>
                <img id="imagePreview" src="#" alt="图片预览">
                <br>
                <input type="file" id="fileInput">
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
