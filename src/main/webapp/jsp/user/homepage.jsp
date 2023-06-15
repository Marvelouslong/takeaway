<%--
  Created by IntelliJ IDEA.
  User: HAN
  Date: 2023/6/13
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<style>
    .background{
        height: 100%;
        display: flex;
    }
    .b-wrap{
        width: 1320px;
        height: 103px;
        margin-top: 5px;
        margin-left: 50px;
        display: flex;
        align-items: center;
        background-color: #fbfbfb;
    }
    .b-wrap .con{
        display: flex;
    }
    .b-wrap .con li{
        cursor: pointer;
        width: 66px;
        height: 68px;
        text-align: center;
        font-size: 14px;
        white-space: nowrap;
        font-size: 14px;
    }
    .b-wrap .con li .con-img img{
        width: 60px;
        height: 55px;
    }
    .table{

    }
</style>
<div class="background">
    <div class="b-wrap">
        <ul class="con">
            <li><a href="#">
                <div class="con-img">
                    <img src="../../img/美食.jpg" alt="mlm">
                </div>
                <span>美食</span>
            </a></li>
            <li>
                <a href="https://t.bilibili.com/">
                    <div class="con-img">
                        <img src="../../img/粥铺.webp" alt="mlm">
                    </div>
                    <span>包子粥铺</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/ranking">
                    <div class="con-img">
                        <img src="../../img/鲜花.webp" alt="mlm">
                    </div>
                    <span>浪漫鲜花</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/炸鸡.jpg" alt="mlm">
                    </div>
                    <span>炸鸡鸭脖</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/米粉.jpg" alt="mlm">
                    </div>
                    <span>米粉馆</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/蔬菜.webp" alt="mlm">
                    </div>
                    <span>蔬菜水果</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/甜品.webp" alt="mlm">
                    </div>
                    <span>甜点饮品</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/酒.webp" alt="mlm">
                    </div>
                    <span>买酒</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/汤饭.jpg" alt="mlm">
                    </div>
                    <span>汤饭</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/川湘菜.jpg" alt="mlm">
                    </div>
                    <span>川湘菜</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/饺子.webp" alt="mlm">
                    </div>
                    <span>饺子馆</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/汉堡.webp" alt="mlm">
                    </div>
                    <span>汉堡披萨</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/面包.webp" alt="mlm">
                    </div>
                    <span>面包蛋糕</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/龙虾.webp" alt="mlm">
                    </div>
                    <span>龙虾烧烤</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/烤鱼.jpg" alt="mlm">
                    </div>
                    <span>火锅烤鱼</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/汤面.webp" alt="mlm">
                    </div>
                    <span>暖胃汤面</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/日韩.webp" alt="mlm">
                    </div>
                    <span>日韩料理</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/轻食.jpeg" alt="mlm">
                    </div>
                    <span>低脂轻食</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/简餐.webp" alt="mlm">
                    </div>
                    <span>快食简餐</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="../../img/小吃.webp" alt="mlm">
                    </div>
                    <span>小吃馆</span>
                </a>
            </li>
        </ul>
    </div>
<%--    表单循环还未写完--%>
    <div class="main">
        <div class="m-table">
            <table class="table">
                <div class="container">
                    <c:forEach items="${array}" var="item" varStatus="status">
                        <div class="item">
                            <p>${item.name}</p>
                            <p>${item.description}</p>
                        </div>
                        <c:if test="${status.index % 2 == 1 or status.last}">
                            <div style="clear:both;"></div>
                        </c:if>
                    </c:forEach>
                </div>
               <c:forEach var="store" items="${storeList }" varStatus="status">
                    <tr>
                        <td>
                            <div>
                            <div class="x_div1" style="display:inline-block" >
    <%--                            <img class="x_img" src="../../img/店铺图片.jpg">${store.picture } <br>${store.storename }--%>
                            </div>
                            <div class="x_div2" style="display:inline-block">
                                主营：${user.main_category}<br><br>地址：${store.address}<br><br> 联系电话:${store.phone}<br>
                            </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
<%--                <form action="submit.php" method="post">--%>
<%--                    <div class="container">--%>
<%--                        <c:forEach items="${array}" var="item" varStatus="status">--%>
<%--                            <c:if test="${status.index % 2 == 0}">--%>
<%--                                <div class="row">--%>
<%--                            </c:if>--%>
<%--                            <div class="col-md-6">--%>
<%--                                <p>${item.name}</p>--%>
<%--                                <p>${item.description}</p>--%>
<%--                                <input type="hidden" name="name${status.index}" value="${item.name}">--%>
<%--                                <input type="hidden" name="description${status.index}" value="${item.description}">--%>
<%--                                <button type="submit" class="btn btn-primary">提交</button>--%>
<%--                            </div>--%>
<%--                            <c:if test="${status.index % 2 == 1 or status.last}">--%>
<%--                                </div>--%>
<%--                            </c:if>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>
<%--                </form>--%>
            </table>
        </div>
    </div>
</div>
</body>
</html>
