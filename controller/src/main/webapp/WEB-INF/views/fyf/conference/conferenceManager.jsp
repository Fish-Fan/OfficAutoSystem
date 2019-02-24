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
    <script src="/static/js/fyf/jQuery2.2.3.js"></script>
</head>
<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/views/css/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/WEB-INF/views/css/topbar.jsp"/>
        <div style="padding:20px">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>会议名称</th>
                    <th>会议日期</th>
                    <th>会议时间</th>
                    <th>会议申请人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${conferenceList}" var="conference">
                    <tr>
                        <th>${conference.reason}</th>
                        <td>${conference.date}</td>
                        <td>${conference.startTime} - ${conference.deadlineTime}</td>
                        <td>${conference.user.username}</td>
                        <td>
                            <c:choose>
                                <c:when test="${conference.statusId eq 0}">
                                    <button class="btn btn-success allow" attr="${conference.id}">批准</button>
                                    <button id="delete${conference.id}" class="btn btn-danger reject" data-toggle="modal" data-target="#${conference.id}">撤销</button>
                                </c:when>
                                <c:when test="${conference.statusId eq 1}">
                                    <span class="text-success"><b>已批准</b></span>
                                </c:when>
                                <c:when test="${conference.statusId eq 2}">
                                    <span class="text-danger"><b>已拒绝</b></span>
                                </c:when>
                            </c:choose>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <c:forEach items="${conferenceList}" var="conference">
                <div id="${conference.id}" class="modal fade withdraw-modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">确认撤销${conference.user.username}发起的${conference.reason}</h4>
                            </div>
                            <div class="modal-body">
                                <input type="text" class="form-control reason" placeholder="撤销原因...">
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-danger deleteBtn" style="width: 100%" attr="${conference.id}">确认撤销</button>
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
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
<script>
    $(function () {
        /**
         * status状态
         * 0->待审批
         * 1->批准
         * 2->拒绝
         */
        $('.allow').on('click',function () {
            var thisBtn = $(this);
            var id = thisBtn.attr('attr');
            $.get('/conference/allow?id='+ id,function (data) {
                console.log(data.status);
                thisBtn.parent().replaceWith('<td><span class="text-success"><b>已批准</b></span></td>');
            },'json');

        });

        $('.deleteBtn').on('click',function () {
            var thisBtn = $(this);
            var id = thisBtn.attr('attr');
            var reason = thisBtn.parent().parent().find('.reason').val();
            axios.post('/conference/reject',{
                id: id,
                rejectReason: reason
            }).then(function (response) {
                var result = response.data;
                if(result == "success"){
                    $('.modal').modal('hide');
                    $('#delete'+id).parent().replaceWith('<td><span class="text-danger"><b>已拒绝</b></span></td>');
                }
            })
        });





    })
</script>
</body>
</html>