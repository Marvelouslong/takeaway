<%--
  Created by IntelliJ IDEA.
  User: HAN
  Date: 2023/6/24
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<style>
    #content-outer {
        -webkit-box-flex: 1;
        -moz-box-flex: 1;
        -o-box-flex: 1;
        box-flex: 1;
        -webkit-flex: 1 auto;
        -ms-flex: 1 auto;
        flex: 1 auto;
        display: block;
    }
    h1 {
        font-size: 2em;
        margin: .67em 0;
    }
    .layout_page {
        display: flex;
        -webkit-box-align: start;
        align-items: flex-start;
        margin: 0 auto;
        padding: 0 5px;
        max-width: 1400px;
    }

    #page{
        margin-left: 20px;
        margin-top: 10px;
        width: 75%;
        border-radius: 3px;
        background: #fff;
        box-shadow: 0 4px 8px 6px rgba(7, 17, 27, .06);
        transition: all .3s;
    }
    #page{
        padding: 20px 44px 44px;
    }

    #aside_content {
        width: 25%;
    }
    #aside_content .card-widget {
        overflow: hidden;
        margin: 10px 0;
        border-radius: 3px;
        background: #fff;
        -webkit-box-shadow: 0 4px 8px 6px rgba(7, 17, 27, .06);
        box-shadow: 0 4px 8px 6px rgba(7, 17, 27, .06);
        -webkit-transition: all .3s;
        -moz-transition: all .3s;
        -o-transition: all .3s;
        -ms-transition: all .3s;
        transition: all .3s;
    }
    #aside_content .card-content {
        padding: 1rem 1.2rem;
    }
    .tool a {
        color: #FF0066;
    }

    .is-center {
        text-align: center;
    }

    #aside_content .card-info img {
        display: inline-block;
        padding: 5px;
        width: 120px;
        height: 120px;
        border-radius: 70px;
        vertical-align: top;
        transition: all .3s;
    }
    img {
        max-width: 100%;
        transition: all .2s;
    }
    #aside_content .card-info .author-info__name {
        font-weight: 500;
        font-size: 1.1rem;
    }
</style>
<div id="content-outer">
    <div class="layout_page" id="content-inner">
        <div class="aside_content" id="aside_content">
            <div class="card-widget card-info">
                <div class="card-content">
                    <div class="card-info-avatar is-center">
                        <img class="avatar-img" src="Userservlet?id=${userSession.id}&method=img1" style="animation: avatar_turn_around 2s linear infinite;" alt="头像">
                        <div class="author-info__name">${userSession.name}</div>
                        <div class="author-info__phone">${userSession.phone}</div>
                        <div class="author-info__sex">${userSession.sex}</div>
                        <div class="author-info__description">${userSession.signature}</div>
                    </div>
                </div>
            </div>
        </div>
        <article id="page">
            <div class="article-container">
                <a href="<c:url value="Userservlet">
                <c:param name="method" value="myinformation"/>
                </c:url>">返回</a>
                <h2>修改个人信息</h2>
                <form action="Userservlet" method="post" id="upload-form" enctype="multipart/form-data">
                    <input type="hidden" name="method" value="change-user-img">
                    <h3>更换头像</h3>
                    <input type="file" id="fileInput" name="image" accept="image/png,image/jpg,image/jpeg,image/bmp"/>
                    <h3>名字：</h3>
                    <input type="text" name="name" value="${userSession.name}">
                    <br>
                    <h3>手机号：</h3>
                    <input type="text" name="phone" id="searchInput" value="${userSession.phone}">
                    <span id="phoneNumberValidation"></span>
                    <br>
                    <h3>性别：</h3>
                    <br>
                    <input type="radio" name="sex" value="男"> 男
                    <input type="radio" name="sex" value="女"> 女
                    <input type="radio" name="sex" value="机器人"> 机器人
                    <br>
                    <h3>个性签名：</h3>
                    <br>
                    <input type="text" name="signature" maxlength="100" placeholder="不超过100个字" value="${userSession.signature}">
                    <h3>更改密码：</h3>
                    <br>
                    <h4>原密码：</h4>
                    <input type="text" maxlength="15" name="password">
                    <div class="info">${message}</div>
                    <h4>新密码:</h4>
                    <input type="text" maxlength="15" name="newpassword">
                    <input type="submit" id="submitBtn">
                </form>
            </div>
        </article>
    </div>
</div>
</body>
</html>
