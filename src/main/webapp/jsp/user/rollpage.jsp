<%--
  Created by IntelliJ IDEA.
  User: HAN
  Date: 2023/6/16
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>rollpage</title>
  <script>
    function page_nav(frm,num){
      frm.pageIndex.value = num;
      frm.submit();
    }

    function jump_to(frm,num){
      //alert(num);
      //验证用户的输入
      var regexp=/^[1-9]\d*$/;
      var totalPageCount = document.getElementById("totalPageCount").value;
      //alert(totalPageCount);
      if(!regexp.test(num)){
        alert("请输入大于0的正整数！");
        return false;
      }else if((num-totalPageCount) > 0){
        alert("请输入小于总页数的页码");
        return false;
      }else{
        page_nav(frm,num);
      }
    }
  </script>
  <style>
    .page-bar
    {
      position:relative;
      margin-top:10px;
    }
    .page-num-ul li
    {
      float:left;
      display: flex;
    }
    .page-num-ul li a
    {
      display:inline-block;
      padding:3px 5px;
      margin:0px 3px;
      border:1px solid #b8b8b8;
    }
    .page-num-ul a:hover,.page-num-ul .thisclass
    {
      border:1px solid #c5063f;
      background-color:#c5063f;
      color:#FFF;
      text-decoration:none;
    }
    .page-key
    {
      width:50px;
    }
    .page-btn
    {
      border:1px solid #b8b8b8;
      background-color:#fff3f8;
      display:inline-block;
      width:52px;
      height:25px;
      line-height:25px;
      font-weight:20px;
    }
    .page-go-form
    {
      position:absolute;
      display:inline-block;
      right:50px;
      top:0px;
    }
    .page-go-form input,label,button
    {
      margin:0px 5px;
    }
  </style>
</head>
<body>
<div class="page-bar">
  <ul class="page-num-ul clearfix">
    <li>当前第${param.currentPageNo }页</li>
    <c:if test="${param.currentPageNo > 1}">
      <a href="javascript:page_nav(document.forms[0],1);">首页</a>
      <a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1});">上一页</a>
    </c:if>
    <c:if test="${param.currentPageNo < param.totalPageCount }">
      <a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1 });">下一页</a>
      <a href="javascript:page_nav(document.forms[0],${param.totalPageCount });">最后一页</a>
    </c:if>
    &nbsp;&nbsp;
  </ul>
  <span class="page-go-form"><label>跳转至</label>
     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
    </span>
</div>
</body>
</html>
