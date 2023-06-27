<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>美了么外卖送餐平台</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
    <meta charset="utf-8">
    <script src="http://code.jquery.com/jquery-latest.js"type="text/javascript"></script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
  <h1>审核</h1>
  <div class="publicHeaderR">
    <p><span>您好！</span><span style="color: #b6afaf"> ${adminSession.name}</span>  欢迎你！</p>
    <a href="admin-out">退出</a>
  </div>
</header>

<!--主体内容-->
<section class="publicMian ">
  <div class="left">
    <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
    <nav>
      <ul class="list">
        <li ><a href="store">审核商家</a></li>
        <li ><a href="ridernews">审核骑手</a></li>
        <li><a href="admin-out">退出</a></li>
      </ul>
    </nav>
  </div>
  <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
  <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
<div class="providerAdd" style="width: 100%">
  <form id="storeForm" name="storeForm" method="post" action="modifyrider"  style="text-align: center">
    <input type="hidden" name="method" value="modifyrider">
    <div>
      <label for="id">骑手编码：</label>
      <input type="number" name="id" id="id" >
      <!-- 放置提示信息 -->
      <font color="red"></font>
    </div>
    <div class="form-group">
      <label class="radio-inline">
        <input type="radio" name="type" checked value="pass" class="radio-inline" ><font color="black">通过</font>
      </label>
      <label class="radio-inline">
        <input type="radio" name="type" value="abc" class="radio-inline" ><font color="black">正在审核</font>
      </label>
      <label class="radio-inline">
        <input type="radio" name="type" value="nopass" class="radio-inline" ><font color="black">未通过</font>
      </label>
    </div>
    <div>
      <input type="submit" name="modifystore" id="modifystore" value="保存"  style="width: 60px;height: 40px;font-size:large;text-align: center">
    </div>
  </form>
  <table   class="providerTable" cellpadding="0" cellspacing="0">
    <tr class="firstTr">
      <th width="10%">编码</th>
      <th width="15%">联系方式</th>
      <th width="10%">姓名</th>
      <th width="15%">身份证卡号</th>
      <th width="15%">驾驶证</th>
      <th width="15%">银行卡</th>
      <th width="10%">工作城市</th>
      <th width="10%">状态</th>
    </tr>
    <c:forEach var="ridernewsList" items="${ridernewsList}">
      <tr>
        <td>
          <span>${ridernewsList.id}</span>
        </td>
        <td>
          <span>${ridernewsList.phone }</span>
        </td>
        <td>
          <span>${ridernewsList.name}</span>
        </td>
        <td>
          <span>${ridernewsList.id_card}</span>
        </td>
        <td>
          <img class="pimg" src="picturedriver_license?id=${ridernewsList.id }" style="width:250px;height:250px;">
          <html>

          <body>
          <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
            <div id="innerdiv" style="position:absolute;">
              <img id="bigimg" style="border:5px solid #fff;" src="" />
            </div>
          </div>
          <script>
            $(function(){
              $(".pimg").click(function(){
                var _this = $(this);//将当前的pimg元素作为_this传入函数
                imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
              });
            });

            function imgShow(outerdiv, innerdiv, bigimg, _this){
              var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
              $(bigimg).attr("src", src);//设置#bigimg元素的src属性

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
                $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放

                var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
                var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
                $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性
                $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg
              });

              $(outerdiv).click(function(){//再次点击淡出消失弹出层
                $(this).fadeOut("fast");
              });
            }
          </script>
          </body>

          </html>
        </td>
        <td>
          <span>${ridernewsList.bank_card}</span>
        </td>

        <td>
          <span>${ridernewsList.work_city}</span>
        </td>
        <td>
          <span>${ridernewsList.status}</span>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</section>
</body>
</html>