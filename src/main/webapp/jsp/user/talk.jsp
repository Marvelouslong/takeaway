<%--
  Created by IntelliJ IDEA.
  User: HAN
  Date: 2023/6/14
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<style>
    .main{
        margin-top: 10px;
        display: flex;
        width: 1320px;
        margin-left: 50px;
    }
    .left{
        background-color: #ffffff;
        display: flex;
        width: 70%;
    }
    .right{
        background-color: #ffffff;
        margin-left: 10px;
        width: 30%;
        height: 60%;
    }
    .right textarea{
        width: 300px;
        height: 400px;
        overflow-x:hidden;overflow-y:hidden
    }

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
        margin:0 3px;
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
        font-weight:20;
    }
    .page-go-form
    {
        position:absolute;
        display:inline-block;
        right:50px;
        top:0;
    }
    .page-go-form input,label,button
    {
        margin:0 5px;
    }
</style>
<script>
    const form = document.getElementById('upload-form');
    const submitBtn = document.getElementById('submitBtn');
    submitBtn.addEventListener('click', () => {
        form.submit();
    });

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
<div class="main">
    <div class="left">
        <form action="Userservlet" method="get">
            <input type="hidden" name="method" value="talkshow">
            <input type="hidden" name="pageIndex" value="1">
        <table class="table">
            <c:forEach var="talk" items="${talklist}" varStatus="status">
                <tr>
                    <td> <img src="Userservlet?id=${talk._u.id}&method=img4"
                              style="animation: avatar_turn_around 2s linear infinite;
                     display: inline-block;
                     padding: 5px;
                     width: 50px;
                     height: 50px;
                     border-radius: 70px;
                     vertical-align: top;
                     transition: all .3s;"
                              alt="img">
                        <br>
                        ${talk._u.name}
                    </td>
                    <td style="display:inline-block">
                        ${talk.context}
                    </td>
                    <td> <img src="Userservlet?id=${talk.id}&method=img5"
                              style="animation: avatar_turn_around 2s linear infinite;
                                         display: inline-block;
                                         padding: 5px;
                                         width: 50px;
                                         height: 50px;
                                         border-radius: 70px;
                                         vertical-align: top;
                                         transition: all .3s;"
                              alt="img">
                    </td>
                </tr>
                <br>
            </c:forEach>
        </table>
        </form>
    </div>
    <div class="right">
        <form action="Userservlet" method="post" id="upload-form" enctype="multipart/form-data">
            <input type="hidden" name="method" value="upload-talk">
            <h3>发布框：</h3>
            <input type="text" maxlength="150" placeholder="不超过150个字" name="talkcontext">
            <input type="file" id="fileInput" name="image" accept="image/png,image/jpg,image/jpeg,image/bmp"/>
            <button type="submit" id="submitBtn">提交</button>
        </form>
    </div>
</div>
<footer class="page-bar">
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <c:set var="totalCount" value="${totalCount}"/>
    <c:set var="currentPageNo" value="${currentPageNo}"/>
    <c:set var="totalPageCount" value="${totalPageCount}"/>
    <ul class="page-num-ul clearfix">
        <li>当前第${currentPageNo }页</li>
        <br>
        <c:if test="${totalCount > 1}">
            <a href="javascript:page_nav(document.forms[1],1);">首页</a>
            <a href="javascript:page_nav(document.forms[1],${currentPageNo-1});">上一页</a>
        </c:if>
        <c:if test="${currentPageNo < totalPageCount }">
            <a href="javascript:page_nav(document.forms[1],${currentPageNo+1 });">下一页</a>
            <a href="javascript:page_nav(document.forms[1],${totalPageCount });">最后一页</a>
        </c:if>
        &nbsp;&nbsp;
    </ul>
    <span class="page-go-form"><label>跳转至</label>
     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
     <button type="button" class="page-btn" onClick='jump_to(document.forms[1],document.getElementById("inputPage").value)'>GO</button>
    </span>
</footer>
</body>
</html>
