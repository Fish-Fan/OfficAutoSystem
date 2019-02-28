<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/16
  Time: 18:08
  To change this template use File | Settings | File Templates.
  个人信息内的修改密码
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改密码</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--come from index-->
    <link rel="stylesheet" href="/static/css/fyf/bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
    <script src="/static/js/fyf/jQuery2.2.3.js"></script>
</head>
<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/views/framework/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="/WEB-INF/views/framework/topbar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>个人信息</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/index">首页</a>
                    </li>
                    <li class="active">
                        账号安全设置
                    </li>
                    <li class="active">
                        <strong>修改密码</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>修改密码</h5>
                        </div>
                        <div class="ibox-content">
                            <form:form modelAttribute="user" action="/user/updatePasswords" method="post" class="form-horizontal">
                                <div class="form-group"><label class="col-sm-2 control-label">请输入新的密码</label>
                                    <div class="col-sm-9">
                                        <form:input path="password" type="password" id="password" placeholder="请输入新的密码" onblur="checkP()" class="form-control" />
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-5">
                                        <button class="btn btn-primary" type="submit">保存</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div>
                <strong>Little'System</strong>  &copy; 2018
            </div>
        </div>
    </div>
</div>
<!--come from index-->
<script src="/static/js/css/metisMenu/jquery.metisMenu.js"></script>
<script src="/static/js/css/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/js/css/inspinia.js"></script>
<script src="/static/js/fyf/sockjs.js"></script>
<script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
<!-- Mainly scripts -->
<script src="/static/js/gsy/js/jquery-2.1.1.js"></script>
<script src="/static/js/gsy/js/bootstrap.js"></script>
<!-- Custom and plugin javascript -->
<script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
<!-- Peity -->
<script src="/static/js/gsy/js/plugins/peity/jquery.peity.min.js"></script>
<!-- Peity -->
<script src="/static/js/gsy/js/demo/peity-demo.js"></script>

<script src="/static/js/gsy/update_password.js"></script>

</body>
</html>
