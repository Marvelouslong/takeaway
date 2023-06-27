<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/common/head.jsp"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<head>
  <meta charset="utf-8">
  <script src="http://code.jquery.com/jquery-latest.js"type="text/javascript"></script>
</head>
<div class="providerAdd" style="width: 100%">
  <form id="storeForm" name="storeForm" method="post" action="modifystore" style="text-align: center" >
    <input type="hidden" name="method" value="modifystore">
    <div>
      <label for="id" >商家编码：</label>
      <input type="number" name="id" id="id">
    </div>
    <div class="form-group">
      <label class="radio-inline">
        <input type="radio" name="type" checked value="pass" class="radio-inline"><font color="black"><font size="x-large">通过</font></font>
      </label>
      <label class="radio-inline">
        <input type="radio" name="type" value="abc" class="radio-inline" ><font color="black">正在审核</font>
      </label>
      <label class="radio-inline">
        <input type="radio" name="type" value="nopass" class="radio-inline" ><font color="black">未通过</font>
      </label>
    </div>
    <div>
      <input type="submit" name="modifystore" id="modifystore" value="保存"    style="width: 60px;height: 40px;font-size:large">
    </div>
  </form>
  <table   class="providerTable" cellpadding="0" cellspacing="0">
    <tr class="firstTr">
      <th width="5%">编码</th>
      <th width="10%">地址</th>
      <th width="5%">联系方式</th>
      <th width="5%">商家名</th>
      <th width="5%">负责人姓名</th>
      <th width="5%">品牌</th>
      <th width="5%">银行卡号</th>
      <th width="5%">许可证</th>
      <th width="5%">证书</th>
      <th width="5%">身份证</th>
      <th width="8%">状态</th>
      <th width="5%">商家照片</th>
    </tr>
    <c:forEach var="storeList" items="${storeList}">
      <tr>
        <td>
          <span>${storeList.id}</span>
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
          <img class="pimg1" src="picturebrand_authorization?id=${storeList.id }" style="width:100px;height:100px;">
          <html>

          <body>
          <div id="outerdiv1" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
            <div id="innerdiv1" style="position:absolute;">
              <img id="bigimg1" style="border:5px solid #fff;" src="" />
            </div>
          </div>
          <script>
            $(function(){
              $(".pimg1").click(function(){
                var _this = $(this);//将当前的pimg元素作为_this传入函数
                imgShow("#outerdiv1", "#innerdiv1", "#bigimg1", _this);
              });
            });

            function imgShow(outerdiv1, innerdiv1, bigimg1, _this1){
              var src = _this1.attr("src");//获取当前点击的pimg元素中的src属性
              $(bigimg1).attr("src", src);//设置#bigimg元素的src属性

              /*获取当前点击图片的真实大小，并显示弹出层及大图*/
              $("<img/>").attr("src", src).load(function(){
                var windowW = $(window).width();//获取当前窗口宽度
                var windowH = $(window).height();//获取当前窗口高度
                var realWidth = 1000;//获取图片真实宽度
                var realHeight = 1000;//获取图片真实高度
                var imgWidth, imgHeight;
                var scale = 1;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

                if(realHeight>windowH*scale) {//判断图片高度
                  imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
                  imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
                  if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                    imgWidth = windowW*scale;//再对宽度进行缩放
                  }
                } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
                  imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                  imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
                } else {//如果图片真实高度和宽度都符合要求，高宽不变
                  imgWidth = realWidth;
                  imgHeight = realHeight;
                }
                $(bigimg1).css("width",imgWidth);//以最终的宽度对图片缩放

                var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
                var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
                $(innerdiv1).css({"top":h, "left":w});//设置#innerdiv的top和left属性
                $(outerdiv1).fadeIn("fast");//淡入显示#outerdiv及.pimg
              });

              $(outerdiv1).click(function(){//再次点击淡出消失弹出层
                $(this).fadeOut("fast");
              });
            }
          </script>
          </body>

          </html>
        </td>
        <td>
          <span>${storeList.bank_card}</span>
        </td>
        <td>
           <img class="pimg2" src="picturelicense?id=${storeList.id }" style="width:100px;height:100px;">
          <html>
          <body>
          <div id="outerdiv2" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
            <div id="innerdiv2" style="position:absolute;">
              <img id="bigimg2" style="border:5px solid #fff;" src="" />
            </div>
          </div>
          <script>
            $(function(){
              $(".pimg2").click(function(){
                var _this = $(this);//将当前的pimg元素作为_this传入函数
                imgShow("#outerdiv2", "#innerdiv2", "#bigimg2", _this);
              });
            });

            function imgShow(outerdiv2, innerdiv2, bigimg2, _this2){
              var src = _this1.attr("src");//获取当前点击的pimg元素中的src属性
              $(bigimg1).attr("src", src);//设置#bigimg元素的src属性

              /*获取当前点击图片的真实大小，并显示弹出层及大图*/
              $("<img/>").attr("src", src).load(function(){
                var windowW = $(window).width();//获取当前窗口宽度
                var windowH = $(window).height();//获取当前窗口高度
                var realWidth = 1000;//获取图片真实宽度
                var realHeight = 1000;//获取图片真实高度
                var imgWidth, imgHeight;
                var scale = 1;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

                if(realHeight>windowH*scale) {//判断图片高度
                  imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
                  imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
                  if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                    imgWidth = windowW*scale;//再对宽度进行缩放
                  }
                } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
                  imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                  imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
                } else {//如果图片真实高度和宽度都符合要求，高宽不变
                  imgWidth = realWidth;
                  imgHeight = realHeight;
                }
                $(bigimg2).css("width",imgWidth);//以最终的宽度对图片缩放

                var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
                var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
                $(innerdiv2).css({"top":h, "left":w});//设置#innerdiv的top和left属性
                $(outerdiv2).fadeIn("fast");//淡入显示#outerdiv及.pimg
              });

              $(outerdiv2).click(function(){//再次点击淡出消失弹出层
                $(this).fadeOut("fast");
              });
            }
          </script>
          </body>

          </html>
        </td>
        <td>
             <img  class="pimg3" src="picturecertificate_of_business?id=${storeList.id }" style="width:100px;height:100px;">
          <html>
          <body>
          <div id="outerdiv3" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
            <div id="innerdiv3" style="position:absolute;">
              <img id="bigimg3" style="border:5px solid #fff;" src="" />
            </div>
          </div>
          <script>
            $(function(){
              $(".pimg3").click(function(){
                var _this = $(this);//将当前的pimg元素作为_this传入函数
                imgShow("#outerdiv3", "#innerdiv3", "#bigimg3", _this);
              });
            });

            function imgShow(outerdiv3, innerdiv3, bigimg3, _this3){
              var src = _this3.attr("src");//获取当前点击的pimg元素中的src属性
              $(bigimg3).attr("src", src);//设置#bigimg元素的src属性

              /*获取当前点击图片的真实大小，并显示弹出层及大图*/
              $("<img/>").attr("src", src).load(function(){
                var windowW = $(window).width();//获取当前窗口宽度
                var windowH = $(window).height();//获取当前窗口高度
                var realWidth = 1000;//获取图片真实宽度
                var realHeight = 1000;//获取图片真实高度
                var imgWidth, imgHeight;
                var scale = 1;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

                if(realHeight>windowH*scale) {//判断图片高度
                  imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
                  imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
                  if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                    imgWidth = windowW*scale;//再对宽度进行缩放
                  }
                } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
                  imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                  imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
                } else {//如果图片真实高度和宽度都符合要求，高宽不变
                  imgWidth = realWidth;
                  imgHeight = realHeight;
                }
                $(bigimg3).css("width",imgWidth);//以最终的宽度对图片缩放

                var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
                var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
                $(innerdiv3).css({"top":h, "left":w});//设置#innerdiv的top和left属性
                $(outerdiv3).fadeIn("fast");//淡入显示#outerdiv及.pimg
              });

              $(outerdiv3).click(function(){//再次点击淡出消失弹出层
                $(this).fadeOut("fast");
              });
            }
          </script>
          </body>

          </html>
        </td>
        <td>
          <span>${storeList.legal_id_card}</span>
        </td>
        <td>
          <span>${storeList.status}</span>
        </td>
        <td>
          <img class="pimg4" src="pictureshop_picture?id=${storeList.id }" style="width:100px;height:100px;">
          <html>
          <body>
          <div id="outerdiv4" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
            <div id="innerdiv4" style="position:absolute;">
              <img id="bigimg4" style="border:5px solid #fff;" src="" />
            </div>
          </div>
          <script>
            $(function(){
              $(".pimg4").click(function(){
                var _this = $(this);//将当前的pimg元素作为_this传入函数
                imgShow("#outerdiv4", "#innerdiv4", "#bigimg4", _this);
              });
            });

            function imgShow(outerdiv4, innerdiv4, bigimg4, _this4){
              var src = _this4.attr("src");//获取当前点击的pimg元素中的src属性
              $(bigimg4).attr("src", src);//设置#bigimg元素的src属性

              /*获取当前点击图片的真实大小，并显示弹出层及大图*/
              $("<img/>").attr("src", src).load(function(){
                var windowW = $(window).width();//获取当前窗口宽度
                var windowH = $(window).height();//获取当前窗口高度
                var realWidth = 1000;//获取图片真实宽度
                var realHeight = 1000;//获取图片真实高度
                var imgWidth, imgHeight;
                var scale = 1;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

                if(realHeight>windowH*scale) {//判断图片高度
                  imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
                  imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
                  if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                    imgWidth = windowW*scale;//再对宽度进行缩放
                  }
                } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
                  imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                  imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
                } else {//如果图片真实高度和宽度都符合要求，高宽不变
                  imgWidth = realWidth;
                  imgHeight = realHeight;
                }
                $(bigimg4).css("width",imgWidth);//以最终的宽度对图片缩放

                var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
                var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
                $(innerdiv4).css({"top":h, "left":w});//设置#innerdiv的top和left属性
                $(outerdiv4).fadeIn("fast");//淡入显示#outerdiv及.pimg
              });

              $(outerdiv4).click(function(){//再次点击淡出消失弹出层
                $(this).fadeOut("fast");
              });
            }
          </script>
          </body>

          </html>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</section>
