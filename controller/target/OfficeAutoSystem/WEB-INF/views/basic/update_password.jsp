<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/13
  Time: 20:02
  To change this template use File | Settings | File Templates.
  忘记密码跳转后的修改密码
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改密码</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/static/css/gsy/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/gsy/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/dist/css/layui.css">
</head>
<body class="gray-bg">
<div class="passwordBox animated fadeInDown">
    <div class="row">
        <div class="col-md-12">
            <div class="ibox-content">
                <h2 class="font-bold">修改密码</h2>
                <p>
                    <c:if test="${requestScope.mistake ne null}">
                        <c:out value="${requestScope.mistake}"></c:out>    <!-- 返回了错误的结果显示的内容 -->
                    </c:if>
                </p>
                <div class="row">
                    <div class="col-lg-12">
                        <form:form class="m-t" role="form" modelAttribute="user" action="/user/updatePassword" method="post">
                            <div class="form-group">
                                <form:input path="password" type="password" id="password"  class="form-control" placeholder="请输入新的密码" onblur="checkP()" required=""/>
                            </div>
                            <button type="submit" class="btn btn-primary block full-width m-b">确认</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr/>
    <div class="row">
        <div class="col-md-6">
            LittlePig'System
        </div>
        <div class="col-md-6 text-right">
            <small>© 2018</small>
        </div>
    </div>
</div>
<!-- Mainly scripts -->
<script src="/static/js/gsy/js/jquery-2.1.1.js"></script>
<script src="/static/js/gsy/js/bootstrap.js"></script>
<script src="/static/js/gsy/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/static/js/gsy/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- Custom and plugin javascript -->
<script src="/static/js/gsy/js/inspinia.js"></script>
<script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
<!-- Peity -->
<script src="/static/js/gsy/js/plugins/peity/jquery.peity.min.js"></script>
<!-- Peity -->
<script src="/static/js/gsy/js/demo/peity-demo.js"></script>

<script src="/static/js/gsy/update_password.js"></script>

</body>
</html>
