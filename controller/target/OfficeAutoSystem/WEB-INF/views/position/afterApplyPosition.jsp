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
                                            <h2>职位申请提交成功</h2>
                                            <p>
                                                <label>申请时间: </label>
                                                <span>${apply.applicationTime}</span>
                                            </p>
                                            <p>
                                                <label>申请职位: </label>
                                                <span>${apply.user.department.department} - ${apply.respond.position.position}</span>
                                            </p>
                                            <p>
                                                <label>审批人: </label>
                                                <span>${apply.respond.username}</span>
                                            </p>
                                            <p>
                                                <label>申请缘由: </label>
                                                <div>${apply.applicationReason}</div>
                                            </p>
                                            <span class="vertical-date">
                                        今天 <br/>
                                        <small>12月24日</small>
                                    </span>
                                        </div>
                                    </div>

                                    <c:if test="${apply.departmentManagerAdvice != null}">
                                        <div class="vertical-timeline-block">
                                            <div class="vertical-timeline-icon ${apply.departmentManagerAdvice eq null ? "bg-gray" : "lazur-bg"}">
                                                <i class="fa fa-coffee"></i>
                                            </div>

                                            <div class="vertical-timeline-content">
                                                <c:choose>
                                                    <c:when test="${apply.departmentManagerAdvice eq null}">
                                                        <h2>等待主管审批中...</h2>
                                                    </c:when>
                                                    <c:when test="${apply.departmentManagerAdvice eq 0}">
                                                        <h2>主管审批完成</h2>
                                                        <p>
                                                                ${apply.respond.username}${apply.respond.position.position}拒绝了您的职位升迁，以下为拒绝理由:
                                                            <br>
                                                                ${apply.reason}

                                                        </p>
                                                        <span class="vertical-date"> 昨天 <br/><small>${apply.managerResultTime}</small></span>
                                                    </c:when>
                                                    <c:when test="${apply.departmentManagerAdvice eq 1}">
                                                        <h2>主管审批完成</h2>
                                                        <p>
                                                                ${apply.respond.username}${apply.respond.position.position}同意了您的职位升迁。主管对您大加赞赏，并向经理提到:
                                                            <br>
                                                                ${apply.reason}
                                                        </p>
                                                        <span class="vertical-date"> 昨天 <br/><small>${apply.managerResultTime}</small></span>
                                                    </c:when>
                                                </c:choose>
                                            </div>
                                        </div>
                                    </c:if>

                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon ${apply.departmentBossAdvice eq null ? "bg-gray" : "lazur-bg"}">
                                            <i class="fa fa-coffee"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <c:choose>
                                                <c:when test="${apply.departmentBossAdvice eq null}">
                                                    <h2>等待经理审批中...</h2>
                                                </c:when>
                                                <c:when test="${apply.departmentBossAdvice eq 0}">
                                                    <h2>经理审批完成</h2>
                                                    <p>
                                                        经理拒绝了您的升迁请求。
                                                    </p>
                                                    <span class="vertical-date"> 昨天 <br/><small>${apply.bossResultTime}</small></span>
                                                </c:when>
                                                <c:when test="${apply.departmentBossAdvice eq 1}">
                                                    <h2>经理审批完成</h2>
                                                    <p>
                                                        经理同意了您的升迁请求
                                                    </p>
                                                    <span class="vertical-date"> 昨天 <br/><small>${apply.bossResultTime}</small></span>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                    </div>

                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon ${apply.conclusion eq null ? "bg-gray" : "lazur-bg"}">
                                            <i class="fa fa-file"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <c:choose>
                                                <c:when test="${apply.conclusion eq null}">
                                                    <h2>暂无审批结果</h2>
                                                </c:when>
                                                <c:when test="${apply.conclusion eq '成功'}">
                                                    <h2>审批结果</h2>
                                                    <p>
                                                        申请成功，经理很认可您最近的业绩，继续加油吧！！！
                                                    </p>
                                                    <span class="vertical-date"> 昨天 <br/><small>${apply.bossResultTime}</small></span>
                                                </c:when>
                                                <c:when test="${apply.conclusion eq '失败'}">
                                                    <h2>审批结果</h2>
                                                    <p>
                                                        申请失败，经理觉得您还需要再接再厉哦！！！
                                                    </p>
                                                    <span class="vertical-date"> 昨天 <br/><small>${apply.bossResultTime}</small></span>
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