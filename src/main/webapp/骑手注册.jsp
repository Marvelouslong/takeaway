<%--
  Created by IntelliJ IDEA.
  User: liangsicheng
  Date: 2023/6/14
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function check() {
        if (form1.name.value == "") {
            alert("商家名称不能为空");
            form1.name.focus();
            return false;
        }
        if (form1.city.value == "") {
            alert("商家名称不能为空");
            form1.city.focus();
            return false;
        }
        if (form1.telephone.value == "") {
            alert("手机号不能为空");
            form1.telephone.focus();
            return false;
        }
        for (i = 0; i < form1.telephone.value.length; i++) {
            if (form1.telephone.value.charAt(i) < '0' ||
                form1.telephone.value.charAt(i) > '9') {
                alert("手机号格式不正确");
                form1.telephone.focus();
                return false;
            }
        }
        if (form1.pw1.value == "") {
            alert("密码不能为空");
            form1.pw1.focus();
            return false;
        }
        if (form1.pw1.value.length < 6) {
            alert("密码长度不能小于6");
            form1.pw1.focus();
            return false;
        }
        if (form1.pw1.value != form1.pw2.value) {
            alert("密码与确认密码不一致");
            form1.pw1.focus();
            return false;
        }
    }


</script>

<html>
<head>
    <title>骑手注册页面</title>
    <style>
        #app{
            width: 500px;
            height: 600px;
            background-image: url("https://tse2-mm.cn.bing.net/th/id/OIP-C.Ucj9fs3Z4CRQmc5Q2HVS7QHaJf?w=202&h=259&c=7&r=0&o=5&dpr=1.3&pid=1.7");
            border-radius: 20px;
            overflow: hidden;
        }
        h1{
            margin-left: 30px;
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
        <h1>骑手注册</h1>
        <div class="ruirui">
            <from  method="get" name="form1" onSubmit="return check()">
                <p>&nbsp;骑手姓名&nbsp;:<input style="background-color:transparent" type="text" name="name" placeholder="请输入姓名"></p>
                <p>&nbsp;工作城市&nbsp; :<input style="background-color:transparent" type="text" name="city" placeholder="请输入工作城市"></p>
                <p>&nbsp;手机号 :<input style="background-color:transparent" type="text" name="telephone" placeholder="请输入手机号"></p>
                <p>&nbsp;密码&nbsp;&nbsp;&nbsp;:<input style="background-color:transparent" type="password" name="pw1" placeholder="请输入登录密码"></p>
                <p>&nbsp;确认密码&nbsp;&nbsp;:<input style="background-color:transparent" type="password" name="pw2" placeholder="请再次输入密码"></p>
                <p>&nbsp;驾驶证&nbsp;:<form method="post" action="${ctx}/upimg" id="form1"
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
                <p>&nbsp;身份证&nbsp;:<form method="post" action="${ctx}/upimg" id="form2"
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
                <p>&nbsp;银行卡&nbsp;:<form method="post" action="${ctx}/upimg" id="form3"
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


