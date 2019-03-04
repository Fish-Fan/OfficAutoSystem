<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
    <link rel="stylesheet" href="/static/dist/css/layui.css">
    <script src="/static/js/fyf/jQuery2.2.3.js"></script>
</head>
<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/views/framework/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/WEB-INF/views/framework/topbar.jsp"/>
        <div style="padding:20px">
            <div class="wrapper wrapper-content">
                <div class="row animated fadeInRight">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-content" id="ibox-content">

                                <div id="vertical-timeline" class="vertical-container dark-timeline">
                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon navy-bg">
                                            <i class="fa fa-briefcase"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <h2>会议提交成功</h2>
                                            <p>
                                                <label>会议发起人: </label>
                                                <span>${conference.user.username}</span>
                                            </p>
                                            <p>
                                                <label>审批人: </label>
                                                <span>${conference.respondUser.username}</span>
                                            </p>
                                            <p>
                                                <label>创建时间: </label>
                                                <span>${conference.createTime}</span>
                                            </p>
                                            <p>
                                                <label>会议时间:</label>
                                                <span>${conference.startTime} - ${conference.deadlineTime}</span>
                                            </p>
                                            <p>
                                                <label>会议地点: </label>
                                                <span>${conference.site}</span>
                                            </p>
                                            <p>
                                                <label>会议级别: </label>
                                                <span>${conference.type}</span>
                                            </p>
                                            <p>
                                                <label>会议标题: </label>
                                                <span>${conference.reason}</span>
                                            </p>
                                            <p>
                                                <label>会议内容: </label>
                                                <div>${conference.content}</div>
                                            </p>
                                            <span class="vertical-date">
                                        今天 <br/>
                                        <small>12月24日</small>
                                    </span>
                                        </div>
                                    </div>

                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon ${conference.statusId eq 0 ? "bg-gray" : "lazur-bg"}">
                                            <i class="fa fa-coffee"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <c:choose>
                                                <c:when test="${conference.statusId eq 0}">
                                                    <h2>等待审批中...</h2>
                                                </c:when>
                                                <c:when test="${conference.statusId eq 1}">
                                                    <h2>领导审批</h2>
                                                    <p>
                                                            ${conference.respondUser.department.department}${conference.respondUser.position.position}${conference.respondUser.username}
                                                                批准了您的会议请求
                                                    </p>
                                                    <span class="vertical-date"> 昨天 <br/><small>${conference.resultTime}</small></span>
                                                </c:when>
                                                <c:when test="${conference.statusId eq 2}">
                                                    <h2>领导审批</h2>
                                                    <p>
                                                            ${conference.respondUser.department.department}${conference.respondUser.position.position}${conference.respondUser.username}
                                                                拒绝了您的会议请求,以下为拒绝理由: <br>
                                                            ${conference.rejectReason}
                                                    </p>
                                                    <span class="vertical-date"> 昨天 <br/><small>${conference.resultTime}</small></span>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                    </div>

                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon ${conference.statusId eq 0 ? "bg-gray" : "lazur-bg"}">
                                            <i class="fa fa-file"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <c:choose>
                                                <c:when test="${conference.statusId eq 0}">
                                                    <h2>暂无审批结果</h2>
                                                </c:when>
                                                <c:when test="${conference.statusId eq 1}">
                                                    <h2>审批结果</h2>
                                                    <p>
                                                        申请成功，请所有人员于${conference.startTime}到${conference.site}准时参加会议
                                                    </p>
                                                    <span class="vertical-date"> 昨天 <br/><small>${conference.resultTime}</small></span>
                                                </c:when>
                                                <c:when test="${conference.statusId eq 2}">
                                                    <h2>审批结果</h2>
                                                    <p>
                                                        申请失败
                                                    </p>
                                                    <span class="vertical-date"> 昨天 <br/><small>${conference.resultTime}</small></span>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                    </div>


                                </div>

                            </div>
                        </div>
                    </div>
                </div>
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