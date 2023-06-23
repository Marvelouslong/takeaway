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
    <h1>商家注册</h1>
    <div class="ruirui">
      <form  active="#" method="get" name="form0" onclick="return check()">
        <p>&nbsp;商家名称&nbsp;:<input type="text" name="aname" id="aname" placeholder="请输入商家名称"></p>
        <p>&nbsp;地址&nbsp;&nbsp;&nbsp; :<input type="text" name="address" id="address" placeholder="请输入商家地址"></p>
        <p>&nbsp;联系人姓名 :<input type="text" name="name" id="name" placeholder="请输入联系人姓名"></p>
        <p>&nbsp;联系人电话 :<input type="text" name="telephone" id="telephone" placeholder="请输入联系人电话号码"></p>
        <p>&nbsp;主营品类&nbsp;:<input type="text" name="zhuying" id="zhuying" placeholder="请输入主营品类"></p>
        <p>&nbsp;辅营品类&nbsp;:<input type="text" name="fuying" id="fuying" placeholder="请输入辅营品类"></p>
        <p>&nbsp;密码&nbsp;&nbsp;&nbsp;:<input type="password" name="password" id="password" placeholder="请输入登录密码"></p>
        <p>&nbsp;营业执照&nbsp;:<form method="post" action="${ctx}/upimg" id="form1"
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
        <p>&nbsp;营业许可证:<form method="post" action="${ctx}/upimg" id="form2"
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
        <p>&nbsp;公司银行卡:<form method="post" action="${ctx}/upimg" id="form3"
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
        <p>&nbsp;商标授权书:<form method="post" action="${ctx}/upimg" id="form4"
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
        <p>&nbsp;法人身份证:<form method="post" action="${ctx}/upimg" id="form5"
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
        <p>&nbsp;实体店铺图:<form method="post" action="${ctx}/upimg" id="form6"
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
        <p>&nbsp;&nbsp;<input class="h" type="submit" value="注册"></p>
        <span style="color: #FD482C;font-size: 15px" id="tip">${tip}  </span>
      </form>
    </div>
  </div>
</div>


</body>
</html>

<script>
  function check() {
      let aname = document.getElementById("aname").value;
      let address = document.getElementById("address").value;
      let name = document.getElementById("name").value;
      let telephone = document.getElementById("telephone").value;
      let password = document.getElementById("password").value;
      let zhuying = document.getElementById("zhuying").value;
      let fuying = document.getElementById("fuying").value;
      if (aname == null || aname.trim() == "") {
          alert("商家名称不能为空!");
          document.getElementById("tip").innerHTML = "商家名称不能为空!";
          return false;
      }
      if (address == null || address.trim() == "") {
          alert("商家地址不能为空!");
          document.getElementById("tip").innerHTML = "商家地址不能为空!!";
          return false;
      }
      if (name == null || name.trim() == "") {
          alert("联系人姓名不能为空!");
          document.getElementById("tip").innerHTML = "联系人姓名不能为空!";
          return false;
      }
      if (telephone == null || telephone.trim() == "") {
          alert("电话号码不能为空!");
          document.getElementById("tip").innerHTML = "电话号码不能为空!";
          return false;
      }
      if (zhuying == null || zhuying.trim() == "") {
          alert("主营品类不能为空!");
          document.getElementById("tip").innerHTML = "主营品类不能为空!";
          return false;
      }
      if (fuying == null || fuying.trim() == "") {
          alert("辅营品类不能为空!");
          document.getElementById("tip").innerHTML = "辅营品类不能为空!";
          return false;
      }
      if (password == null || password.trim() == "") {
          alert("密码不能为空!");
          document.getElementById("tip").innerHTML = "密码不能为空!";
          return false;
      }
      if (check(aname)&&check(address)&&check(name)&&check(telephone)&&check(zhuying)&&check(fuying)&&check(password)){
          alert("注册成功");
          document.getElementById("tip").innerHTML="注册成功!";
          return ture;
      }
  }
</script>
