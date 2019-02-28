<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/7
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link href="/static/css/gsy/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/gsy/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/css/gsy/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">LP</h1>
        </div>
        <h3>注册 </h3>
        <form:form class="m-t" role="form" modelAttribute="user" action ="/user/insertUser" method="post">
            <div class="form-group">
                <form:input path="username" id="username" class="form-control" placeholder="姓名"  onblur="checkU()"/>
            </div>
            <div class="form-group">
                <form:input path="password" id="password" type="password" class="form-control" placeholder="密码" onblur="checkP()"/>
            </div>
            <div class="form-group">
                <form:input path="email" id="email" class="form-control" placeholder="邮箱" onblur="checkE()"/>
            </div>
            <div class="form-group">
                <form:input path="phoneNumber" id="phoneNumber" class="form-control" placeholder="手机号" onblur="checkPn()"/>
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">注册</button>

            <p class="text-muted text-center"><small>已经有一个账户?</small></p>
            <a class="btn btn-sm btn-white btn-block" href="/user/login">登录</a>
        </form:form>
        <p class="m-t"> <small>LittlePig's System &copy; 2018</small> </p>
    </div>
</div>

<!-- Mainly scripts -->
<script src="/static/js/gsy/js/jquery-2.1.1.js"></script>
<script src="/static/js/gsy/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/static/js/gsy/js/plugins/iCheck/icheck.min.js"></script>
<!-- Input Mask-->
<script src="/static/js/gsy/js/plugins/jasny/jasny-bootstrap.min.js"></script>
<script src="/static/js/gsy/register.js"></script>
<script>
    $(document).ready(function(){
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
</body>
</html>
