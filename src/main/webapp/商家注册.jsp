<%--
  Created by IntelliJ IDEA.
  User: liangsicheng
  Date: 2023/6/13
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <script language="JavaScript">
        function check() {
            if (form1.aname.value == "") {
                alert("商家名称不能为空");
                form1.aname.focus();
                return false;
            }
            if (form1.address.value == "") {
                alert("地址不能为空");
                form1.address.focus();
                return false;
            }
            if (form1.name.value == "") {
                alert("联系人姓名不能为空");
                form1.name.focus();
                return false;
            }
            if(form1.telephone.value=="") {
                alert("电话号码不能为空");
                form1.telephone.focus();
                return false;
            }
            for(i=0;i<form1.telephone.value.length;i++){
                if(form1.telephone.value.charAt(i)<'0'||
                form1.telephone.value.charAt(i)>'9'){
                    alert("电话号码格式不正确");
                    form1.telephone.focus();
                    return false;
                }
            }
            if(form1.zhuying.value=="") {
                alert("主营品类不能为空");
                form1.zhuying.focus();
                return false;
            }
            if(form1.fuying.value=="") {
                alert("辅营品类不能为空");
                form1.fuying.focus();
                return false;
            }
            if(form1.pw1.value=="") {
                alert("密码不能为空");
                form1.pw1.focus();
                return false;
            }
            if(form1.pw1.value.length<6) {
                alert("密码长度不能小于6");
                form1.pw1.focus();
                return false;
            }
            if(form1.pw1.value!=form1.pw2.value) {
                alert("密码与确认密码不一致");
                form1.pw1.focus();
                return false;
            }
        }

    </script>
    <title>商家注册页面</title>
    <style>
        #app{
            width: 500px;
            height: 1000px;
            background-image: url("https://tse3-mm.cn.bing.net/th/id/OIP-C.H1B7_uoF913ZKwy_T9Tp4QHaLG?w=202&h=303&c=7&r=0&o=5&dpr=1.3&pid=1.7");
            border-radius: 20px;
            overflow: hidden;
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

        #app.ruirui{
            margin-left: 40px;
        }
        .h{
            margin-left: 200px;
            width: 100px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div id="app">
        <div class="susu">
            <h1>商家注册</h1>
            <div class="ruirui">
                <from  method="get" name="form1" onSubmit="return check()">
                    <p>&nbsp;商家名称&nbsp;:<input type="text" name="aname" placeholder="请输入商家名称"></p>
                    <p>&nbsp;地址&nbsp;&nbsp;&nbsp; :<input type="text" name="address" placeholder="请输入商家地址"></p>
                    <p>&nbsp;联系人姓名 :<input type="text" name="name" placeholder="请输入联系人姓名"></p>
                    <p>&nbsp;联系人电话 :<input type="text" name="telephone" placeholder="请输入联系人电话号码"></p>
                    <p>&nbsp;主营品类&nbsp;:<input type="text" name="zhuying" placeholder="请输入主营品类"></p>
                    <p>&nbsp;辅营品类&nbsp;:<input type="text" name="fuying" placeholder="请输入辅营品类"></p>
                    <p>&nbsp;密码&nbsp;&nbsp;&nbsp;:<input type="password" name="pw1" placeholder="请输入登录密码"></p>
                    <p>&nbsp;确认密码&nbsp;&nbsp;:<input type="password" name="pw2" placeholder="请再次输入密码"></p>
                    <p>&nbsp;营业执照&nbsp;:<form method="post" action="${ctx}/upimg" id="form1"
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

                    <p>&nbsp;&nbsp;&nbsp;<input class="h" type="submit" value="注册">
                </from>
            </div>
        </div>
    </div>

</body>
</html>
