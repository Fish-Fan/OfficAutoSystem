<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/7
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>登录系统</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/static/css/gsy/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/gsy/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="middle-box text-center loginscreen animated fadeInDown">
         <div>
             <div>
                  <h2 class="logo-name">LP</h2>
            </div>
             <h3>欢迎登录</h3>
            <p>
                <c:if test="${requestScope.mistake ne null}">
                     <c:out value="抱歉，${requestScope.mistake}"></c:out>    <!-- 返回了错误的结果显示的内容 -->
                </c:if>
             </p>
        <form:form class="m-t" role="form" modelAttribute="user" action="/user/login" method="post">
            <div class="form-group">
                <form:input path="username" id="username" class="form-control" placeholder="用户名" onblur="checkU()" />
            </div>
            <div class="form-group">
                <form:input path="password" id="password" type="password" class="form-control" placeholder="密码" onblur="checkP()"/>
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登录</button>
            <a href="/user/forgetPassword"><small>忘记密码?</small></a>
            <p class="text-muted text-center"><small>没有账户?</small></p>
            <a class="btn btn-sm btn-white btn-block" href="/user/insertUser">创建账户</a>
        </form:form>
        <p class="m-t"> <small>LittlePig's System &copy; 2018</small> </p>
        </div>
    </div>

<!-- Mainly scripts -->
<script src="/static/js/gsy/js/jquery-2.1.1.js"></script>
<script src="/static/js/gsy/js/bootstrap.min.js"></script>
<script src="/static/js/gsy/login.js"></script>
</body>
</html>
