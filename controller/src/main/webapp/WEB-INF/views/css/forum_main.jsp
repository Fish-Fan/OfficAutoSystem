<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!--come from index-->
    <link rel="stylesheet" href="/static/css/fyf/bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
</head>
<body>
<div id="wrapper" style="min-height: 100vh">
    <jsp:include page="/WEB-INF/views/css/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/WEB-INF/views/css/topbar.jsp"/>
        <div style="padding:20px">
            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-sm-4">
                    <h2>论坛</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">主页</a>
                        </li>
                        <li class="active">
                            <strong>吐槽大会</strong>
                        </li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="wrapper wrapper-content animated fadeInRight">
                        <!--第二行-->
                        <div class="ibox-content m-b-sm border-bottom">
                            <div class="p-xs">
                                <div class="pull-left m-r-md">
                                    <i class="fa fa-paper-plane text-navy mid-icon" style="color: #3399CC"></i>
                                </div>
                                <h2>欢迎来到小猪佩奇的吐槽大会</h2>
                                <span>肯定会有你感兴趣的话题。</span>
                            </div>
                        </div>
                        <!--第三部分-->
                        <div class="ibox-content forum-container">
                            <c:forEach items="${topicList}" var="topic">
                            <div class="forum-title">
                                <!--node列表-->
                                <h3>${topic.node.nodeName}</h3>
                            </div>

                            <div class="forum-item">
                                <div class="row">
                                    <div class="col-md-9">
                                        <div class="forum-icon" >
                                            <c:if test="${topic.node.id == 1 }">
                                                <i class="fa fa-comment" style="color: #FFFF66"></i>
                                            </c:if>
                                            <c:if test="${topic.node.id == 2}">
                                                <i class="fa fa-heart" style="color: #FF6666"></i>
                                            </c:if>
                                            <c:if test="${topic.node.id == 3}">
                                                <%--hongse--%>
                                                <i class="fa fa-drupal" style="color:#00CCCC"></i>
                                            </c:if>
                                            <c:if test="${topic.node.id == 4}">
                                                <i class="fa fa-copyright" style="color: #339999"></i>
                                            </c:if>
                                            <c:if test="${topic.node.id == 5 }">
                                                <i class="fa fa-leaf" style="color: #66CC66"></i>
                                            </c:if>
                                            <c:if test="${topic.node.id == 6 }">
                                                <i class="fa fa-envira"></i>
                                            </c:if>
                                        </div>

                                        <a href="/comment?topicId=${topic.id}" class="forum-item-title" style="color: #0e0e0e">${topic.title}</a>
                                        <div class="forum-sub-title">${topic.text}</div>
                                    </div>


                                    <div class="col-md-1 forum-info">
                                        <span class="views-number">
                                            ${topic.replyNumber}
                                        </span>
                                        <div>
                                            <small>回复数</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/static/js/fyf/jQuery2.2.3.js"></script>
<script src="/static/css/fyf/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<!--come from index-->
<script src="/static/js/css/metisMenu/jquery.metisMenu.js"></script>
<script src="/static/js/css/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/js/css/inspinia.js"></script>
<script src="/static/js/fyf/sockjs.js"></script>
<script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
</body>
</html>