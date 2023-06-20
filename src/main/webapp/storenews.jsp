<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/common/head.jsp"%>
<!DOCTYPE html>
<div class="right">
  <div class="location">
    <strong>你现在所在的位置是:</strong>
    <span>商家信息审核</span>
  </div>
<%--  <div class="search">--%>
<%--    <form method="get" action="store">--%>
<%--      <a href="${pageContext.request.contextPath}/a.jsp" >添加叫号</a>--%>
<%--      <a href="${pageContext.request.contextPath}/modify.jsp" >修改信息</a>--%>
<%--    </form>--%>
<%--  </div>--%>
  <!--用户-->
  <table   class="providerTable" cellpadding="0" cellspacing="0">
    <tr class="firstTr">
      <th width="5%">编码</th>
      <th width="5%">商家地址</th>
      <th width="5%">商家联系方式</th>
      <th width="5%">商家名称</th>
      <th width="5%">负责人姓名</th>
      <th width="5%">品牌</th>
      <th width="5%">银行卡</th>
      <th width="5%">许可证</th>
      <th width="5%">商业证书</th>
      <th width="5%">合法身份证</th>
      <th width="5%">状态</th>
      <th width="5%">商家照片</th>
      <th width="5%"></th>
    </tr>
    <c:forEach var="storeList" items="${storeList}">
      <tr>
        <td>
          <span>${storeList.id }</span>
        </td>
        <td>
          <span>${storeList.address }</span>
        </td>
        <td>
          <span>${storeList.con_telephone}</span>
        </td>
        <td>
          <span>${storeList.shop_name}</span>
        </td>
        <td>
          <span>${storeList.con_name}</span>
        </td>
        <td>
<%--          <span>${storeList.brand_authorization}</span>--%>
          <img src="picture?id=${storeList.id }">
        </td>
        <td>
          <span>${storeList.bank_card}</span>
        </td>
        <td>
<%--          <span>${storeList.license}</span>--%>
           <img src="picture?id=${storeList.id }">
        </td>
        <td>
<%--          <span>${storeList.certificate_of_business}</span>--%>
             <img src="picture?id=${storeList.id }">
        </td>
        <td>
          <span>${storeList.legal_id_card}</span>
        </td>
        <td>
          <span>${storeList.status}</span>
        </td>
        <td>
<%--          <span>${storeList.shop_picture}</span>--%>
          <img src="picture?id=${storeList.id }">
        </td>
        <td>
          <form method="get" action="store">
            <a href="modifystore" >修改状态</a>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>