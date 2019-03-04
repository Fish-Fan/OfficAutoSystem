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
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>申请人</th>
                    <th>当前职位</th>
                    <th>申请时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${applyList}" var="apply">
                    <tr>
                        <th>${apply.user.username}</th>
                        <td>${apply.user.position.position}</td>
                        <td>${apply.applicationTime}</td>
                        <td>
                            <c:choose>
                                <c:when test="${apply.departmentManagerAdvice eq null}">
                                    <button id="checkDetail${apply.id}" class="btn btn-primary" data-toggle="modal" data-target="#${apply.id}">查看详情</button>
                                </c:when>
                                <c:when test="${apply.departmentManagerAdvice eq 1}">
                                    <span class="text-success">已批准</span>
                                </c:when>
                                <c:when test="${apply.departmentManagerAdvice eq 0}">
                                    <span class="text-danger">已拒绝</span>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <c:forEach items="${applyList}" var="apply">
                <div id="${apply.id}" class="modal fade withdraw-modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">${apply.user.username}的职位申请详情</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>姓名:</label>
                                    <p>${apply.user.username}</p>
                                </div>
                                <div class="form-group">
                                    <label>当前职位:</label>
                                    <p>${apply.user.position.position}</p>
                                </div>
                                <div class="form-group">
                                    <label>申请时间:</label>
                                    <p>${apply.applicationTime}</p>
                                </div>
                                <div class="form-group">
                                    <label>申请陈述:</label>
                                    <div>${apply.applicationReason}</div>
                                </div>
                                <div class="form-group">
                                    <label>您的意见:</label>
                                    <input type="text" id="reasonInput${apply.id}" class="form-control">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-primary confirmBtn" style="width: 100%" attr="${apply.id}">确认调度</button>
                                <button class="btn btn-danger rejectBtn" style="width: 100%;margin: 5px 0" attr="${apply.id}">拒绝调度</button>
                            </div>


                        </div>
                    </div>
                </div>
            </c:forEach>
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
<script>
    $(function () {
        /**
         * status状态
         * 0->待审批
         * 1->批准
         * 2->拒绝
         */

        $('.confirmBtn').on('click',function () {
            var thisBtn = $(this);
            var id = thisBtn.attr('attr');
            var reasonValue = $('#reasonInput'+id).val();
            $.post('/position/manager/advice/yes',{
                id : id,
                reason: reasonValue
            },function (data) {
                $('.modal').modal('hide');
                $('#checkDetail'+id).parent().replaceWith('<td><span class="text-success"><b>已批准</b></span></td>');
            },'json');

        });

        $('.rejectBtn').on('click',function () {
            var thisBtn = $(this);
            var id = thisBtn.attr('attr');
            var reasonValue = $('#reasonInput'+id).val();
            $.post('/position/manager/advice/reject',{
                id : id,
                reason: reasonValue
            },function (data) {
                $('.modal').modal('hide');
                $('#checkDetail'+id).parent().replaceWith('<td><span class="text-danger"><b>已拒绝</b></span></td>');
            },'json');
        });





    })
</script>
</body>
</html>