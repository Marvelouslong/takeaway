<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

<div class="right">
  <div class="location">
    <strong>你现在所在的位置是:</strong>
    <span>管理员页面 >> 修改状态</span>
  </div>
  <div class="providerAdd">
    <form id="storeForm" name="storeForm" method="post" action="modifystore">
      <input type="hidden" name="method" value="modifystore">
      <!--div的class 为error是验证错误，ok是验证成功-->
      <div>
        <label for="legal_id_card">商家：</label>
        <input readonly type="text" name="legal_id_card" id="legal_id_card" value="${shopSession.legal_id_card}">
        <!-- 放置提示信息 -->
        <font color="red"></font>
      </div>
      <div>
        <label for="status">状态</label>
        <input type="text" name="status" id="status" value="">
      </div>
      <div class="providerAddBtn">
        <input type="submit" name="modifystore" id="modifystore" value="保存">
      </div>
    </form>
  </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>