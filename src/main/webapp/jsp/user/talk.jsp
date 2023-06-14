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
        display: flex;
    }
.right{
    width: 30%;
    height: 60%;
}
</style>
<div class="main">
    <div class="left">
        <table class="table">
            <c:forEach var="user" items="${userList }" varStatus="status">
                <tr>
                    <td>
                        <div>
                            <div class="x_div1" style="display:inline-block" >
<%--                                <img class="x_img" src="../../img/店铺图片.jpg">${user.picture } <br>${user.storename }--%>
                            </div>
                            <div class="x_div2" style="display:inline-block">
                                ${talk.context}<br><br>${talk.picture}<br>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="right">
        <textarea  rows="4" maxlength="150" placeholder="不超过150个字"/>
        <button type="submit">提交</button>
    </div>
</div>
</body>
</html>
