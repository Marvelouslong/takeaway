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
        width: 100%;
        display: flex;
        background-color: #eeeaea;
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
        list-style:none;
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
    .container {
        max-width: 1320px;
        margin-top: 5px;
        margin-left: 0px;
        margin-right: 0px;
    }
    .stores {
        display: flex;
        flex-wrap: wrap;
        margin: 20px 0;
    }
    .store {
        width: 50%;
        float: left;
        box-shadow: 0 0 10px #f2faff;
        background-color: #fbfbfb;
        border-radius: 5px;
        margin: 20px 0;
        padding: 20px;
        box-sizing: border-box;
    }
</style>
<div class="background">
    <div class="b-wrap">
        <ul class="con">
            <li><a href="#">
                <div class="con-img">
                    <img src="${pageContext.request.contextPath}/img/美食.jpg" alt="mlm">
                </div>
                <span>美食</span>
            </a></li>
            <li>
                <a href="https://t.bilibili.com/">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/粥铺.webp" alt="mlm">
                    </div>
                    <span>包子粥铺</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/ranking">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/鲜花.webp" alt="mlm">
                    </div>
                    <span>浪漫鲜花</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/炸鸡.jpg" alt="mlm">
                    </div>
                    <span>炸鸡鸭脖</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/米粉.jpg" alt="mlm">
                    </div>
                    <span>米粉馆</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/蔬菜.webp" alt="mlm">
                    </div>
                    <span>蔬菜水果</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/甜品.webp" alt="mlm">
                    </div>
                    <span>甜点饮品</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/酒.webp" alt="mlm">
                    </div>
                    <span>买酒</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/汤饭.jpg" alt="mlm">
                    </div>
                    <span>汤饭</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/川湘菜.jpg" alt="mlm">
                    </div>
                    <span>川湘菜</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/饺子.webp" alt="mlm">
                    </div>
                    <span>饺子馆</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/汉堡.webp" alt="mlm">
                    </div>
                    <span>汉堡披萨</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/面包.webp" alt="mlm">
                    </div>
                    <span>面包蛋糕</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/龙虾.webp" alt="mlm">
                    </div>
                    <span>龙虾烧烤</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/烤鱼.jpg" alt="mlm">
                    </div>
                    <span>火锅烤鱼</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/汤面.webp" alt="mlm">
                    </div>
                    <span>暖胃汤面</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/日韩.webp" alt="mlm">
                    </div>
                    <span>日韩料理</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/轻食.jpeg" alt="mlm">
                    </div>
                    <span>低脂轻食</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/简餐.webp" alt="mlm">
                    </div>
                    <span>快食简餐</span>
                </a>
            </li>
            <li>
                <a href="https://www.bilibili.com/v/channel/9222?tab=multiple">
                    <div class="con-img">
                        <img src="${pageContext.request.contextPath}/img/小吃.webp" alt="mlm">
                    </div>
                    <span>小吃馆</span>
                </a>
            </li>
        </ul>
    </div>
    <form action="user" method="get">
        <input name="method" value="query" type="hidden">
        <div class="container">
            <div class="stores">
                <c:forEach items="${storelist}" var="store" varStatus="status">
                    <div class="store">
<%--                        <img src="${store.picture}" alt="${store.name}">--%>
                        ${store.name}
                        ${store.address}
                    </div>
                    <c:if test="${status.index % 2 == 1 or status.last}">
                        <div style="clear:both;"></div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </form>
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <c:import url="//rollpage.jsp">
        <c:param name="totalCount" value="${totalCount}"/>
        <c:param name="currentPageNo" value="${currentPageNo}"/>
        <c:param name="totalPageCount" value="${totalPageCount}"/>
    </c:import>
</div>
</body>
</html>
