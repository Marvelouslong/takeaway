<%--
  Created by IntelliJ IDEA.
  User: liangsicheng
  Date: 2023/6/19
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
  <title>商家注册页面</title>
  <style>
    #app{
      background-image: url("https://img.51miz.com/preview/element/00/01/10/42/E-1104263-F3A6C089.jpg");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: 100% 100%;
    }
    #napp{
      border: #f3b9b9 8px solid;
      width:600px;
      margin-left: 500px;
      margin-top: 10px;
      color: #0C0C0C;
      font-size: 25px;

    }
    h1{
      margin-left: 10px;
    }
    .susu.ruirui input{
      width: 220px;
      height: 30px;
      margin: 8px 0px;
      border-radius: 15px;
    }
    .h{
      margin-left: 20px;
      width: 300px;
      margin-top: 20px;
    }
  </style>
</head>
<body>
<div id="app">
  <div id="napp" class="susu">
    <h1>商家注册页面</h1>
    <div class="ruirui">
      <form  action="storeregisterServlet" method="post" name="form0" onclick="return check()">
        <p>&nbsp;商家名称&nbsp;:<input type="text" name="shop_name" id="shop_name" placeholder="请输入商家名称"></p>
        <p>&nbsp;地址&nbsp;&nbsp;&nbsp; :<input type="text" name="address" id="address" placeholder="请输入商家地址"></p>
        <p>&nbsp;联系人电话 :<input type="text" name="con_telephone" id="con_telephone" placeholder="请输入联系人电话号码"></p>
        <p>&nbsp;主营品类&nbsp;:<input type="text" name="main_category" id="main_category" placeholder="请输入主营品类"></p>
        <p>&nbsp;辅营品类&nbsp;:<input type="text" name="auxiliary_category" id="auxiliary_category" placeholder="请输入辅营品类"></p>
        <p>&nbsp;密码&nbsp;&nbsp;&nbsp;:<input type="password" name="password" id="password" placeholder="请输入登录密码"></p>
        <p>&nbsp;营业执照&nbsp;:<form method="post" action="${ctx}/upimg" name="license" id="license"
                                      enctype="multipart/form-data" class="contact-form">
        <div>
							<span> <label> 单张照片* </label>
							</span>
          <span>
                                <input name="src" type="file" class="textbox"
                                       required="required" accept="image/*">
							</span>
           <span>
               <input type="submit" value="提交" name="tijiao">
           </span>
        </div>
      </form>
        <p>&nbsp;营业许可证:<form method="post" action="${ctx}/upimg" name="certificate_of_business" id="certificate_of_business"
                                  enctype="multipart/form-data" class="contact-form">
        <div>
							<span> <label> 单张照片* </label>
							</span>
          <span>
                                <input name="src" type="file" class="textbox"
                                       required="required" accept="image/*">
							</span>
          <span> <input type="submit" value="提交" name="tijiao">
							</span>
        </div>
      </form>
        <p>&nbsp;公司银行卡:<form method="post" action="${ctx}/upimg" name="bank_card" id="bank_card"
                                  enctype="multipart/form-data" class="contact-form">
        <div>
							<span> <label> 单张照片* </label>
							</span>
          <span>
                                <input name="src" type="file" class="textbox"
                                       required="required" accept="image/*">
							</span>
          <span> <input type="submit" value="提交" name="tijiao">
							</span>
        </div>
      </form>
        <p>&nbsp;商标授权书:<form method="post" action="${ctx}/upimg" name="brand_authorization" id="brand_authorization"
                                  enctype="multipart/form-data" class="contact-form">
        <div>
							<span> <label> 单张照片* </label>
							</span>
          <span>
                                <input name="src" type="file" class="textbox"
                                       required="required" accept="image/*">
							</span>
          <span> <input type="submit" value="提交" name="tijiao">
							</span>
        </div>
      </form>
        <p>&nbsp;法人身份证:<form method="post" action="${ctx}/upimg" name="legal_id_card" id="legal_id_card"
                                  enctype="multipart/form-data" class="contact-form">
        <div>
							<span> <label> 单张照片* </label>
							</span>
          <span>
                                <input name="src" type="file" class="textbox"
                                       required="required" accept="image/*">
							</span>
          <span> <input type="submit" value="提交" name="tijiao">
							</span>
        </div>
      </form>
        <p>&nbsp;实体店铺图:<form method="post" action="${ctx}/upimg" name="shop_picture" id="shop_picture"
                                  enctype="multipart/form-data" class="contact-form">
        <div>
							<span> <label> 单张照片* </label>
							</span>
          <span>
                                <input name="src" type="file" class="textbox"
                                       required="required" accept="image/*">
							</span>
          <span> <input type="submit" value="提交" name="tijiao">
							</span>
        </div>
      </form>
          <button type="submit" value="注册">注册</button>
        <span style="color: #FD482C;font-size: 15px" id="tip">${tip}  </span>
      </form>
    </div>
  </div>
</div>


</body>
</html>

<script>
  function check() {
      let shop_name = document.getElementById("shop_name").value;
      let address = document.getElementById("address").value;
      let con_telephone = document.getElementById("con_telephone").value;
      let password = document.getElementById("password").value;
      let main_category = document.getElementById("main_category").value;
      let auxiliary_category = document.getElementById("auxiliary_category").value;
      if (shop_name == null || shop_name.trim() == "") {
          alert("商家名称不能为空!");
          document.getElementById("tip").innerHTML = "商家名称不能为空!";
          return false;
      }
      if (address == null || address.trim() == "") {
          alert("商家地址不能为空!");
          document.getElementById("tip").innerHTML = "商家地址不能为空!!";
          return false;
      }

      if (con_telephone == null || con_telephone.trim() == "") {
          alert("电话号码不能为空!");
          document.getElementById("tip").innerHTML = "电话号码不能为空!";
          return false;
      }
      if (main_category == null || main_category.trim() == "") {
          alert("主营品类不能为空!");
          document.getElementById("tip").innerHTML = "主营品类不能为空!";
          return false;
      }
      if (auxiliary_category == null || auxiliary_category.trim() == "") {
          alert("辅营品类不能为空!");
          document.getElementById("tip").innerHTML = "辅营品类不能为空!";
          return false;
      }
      if (password == null || password.trim() == "") {
          alert("密码不能为空!");
          document.getElementById("tip").innerHTML = "密码不能为空!";
          return false;
      }
      if (check(shop_name)&&check(address)&&check(con_telephone)&&check(main_category)&&check(auxiliary_category)&&check(password)){
          alert("注册成功");
          document.getElementById("tip").innerHTML="注册成功!";
          return ture;
      }
  }
</script>
