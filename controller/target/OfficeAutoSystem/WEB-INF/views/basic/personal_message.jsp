<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/7
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>

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
                        <strong>个人信息</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <div class="wrapper wrapper-content">
            <div class="row animated fadeInRight">
                <div class="col-md-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h3>个人信息</h3>
                        </div>
                        <div>
                            <div class="ibox-content no-padding border-left-right">
                                <c:if test ="${not empty user.avatar}">
                                    <img alt="image" class="img-responsive" style="height: 150px;width: 150px" src ="${user.avatar}">
                                </c:if>
                                <c:if test ="${empty user.avatar}">
                                    <img alt="image" class="img-responsive" style="height: 100px;width: 100px" src ="http://cdn.fanyank.com/Fm77jCT1O8fVcP-KqZFhMjXjErSh">
                                </c:if>

                            </div>
                            <div class="ibox-content profile-content">
                                <h3>${requestScope.user.username}</h3>
                                <p style="font-size: medium"><i class="fa fa-map-marker"></i> ${requestScope.user.officalAddress}</p>
                                <h3>
                                    个人简介
                                </h3>
                                <p style="font-size:medium">
                                    ${requestScope.user.desc}
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h3>其他信息</h3>
                        </div>
                        <div class="ibox-content">
                            <div>
                                <div class="feed-activity-list">
                                    <div class="feed-element">
                                        <div class="media-body ">
                                            <h3>手机号:${requestScope.user.phoneNumber}</h3>
                                        </div>
                                    </div>
                                    <div class="feed-element">
                                        <div class="media-body ">
                                            <h3>邮箱:${requestScope.user.email}</h3>
                                        </div>
                                    </div>
                                    <div class="feed-element">
                                        <div class="media-body ">
                                            <h3>部门:${requestScope.user.department.department}</h3>
                                        </div>
                                    </div>
                                    <div class="feed-element">
                                        <div class="media-body ">
                                            <h3>职位:${requestScope.user.position.position}</h3>
                                        </div>
                                    </div>
                                    <div class="feed-element">
                                        <div class="media-body ">
                                            <h3>办公电话:${requestScope.user.officalNumber}</h3>
                                        </div>
                                    </div>
                                    <div class="feed-element">
                                        <div class="media-body ">
                                            <h3>邮编:${requestScope.user.postcode}</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
<script src="/static/css/fyf/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<!--come from index-->
<script src="/static/js/css/metisMenu/jquery.metisMenu.js"></script>
<script src="/static/js/css/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/js/css/inspinia.js"></script>
<script src="/static/js/fyf/sockjs.js"></script>
<script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>

</body>
</html>
