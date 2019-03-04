<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>请假记录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <link href="/static/css/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
    <!--本页面CSS-->
    <link href="/static/css/lyj/leaverecord.css" rel="stylesheet">
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

                <div class="ibox">
                    <div class="ibox-content">
                            <table class="footable table table-stripped toggle-arrow-tiny" data-page-size="15">
                                <thead>
                                <tr>
                                    <th>请假人</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>请假类型</th>
                                    <th>请假原因</th>
                                    <th>批准时间</th>
                                    <th>批准情况</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <c:forEach items="${leaves}" var="leave">
                                <tbody>
                                    <tr>
                                        <td>${leave.user.username}</td>
                                        <td>${leave.startTime}</td>
                                        <td>${leave.deadlineTime}</td>
                                        <td>${leave.type}</td>
                                        <td>${leave.reason}</td>
                                        <td>${leave.respondentTime}</td>
                                        <td>${leave.states.states}</td>
                                        <td class="text-right">
                                            <div class="btn-group ">
                                                <button class="btn-white btn btn-xs update" id=${leave.id} >修改</button>
                                                <button class="btn-white btn btn-xs delete" id=${leave.id}>删除</button>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                                </c:forEach>
                                <tfoot>
                                <tr>
                                    <td colspan="8">
                                        <ul class="pagination pull-right"></ul>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.bootcss.com/axios/0.18.0/axios.js"></script>
    <script src="/static/js/css/jquery-2.1.1.js"></script>
    <script src="/static/js/css/bootstrap.min.js"></script>
    <script src="/static/js/css/metisMenu/jquery.metisMenu.js"></script>
    <script src="/static/js/css/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="/static/js/css/inspinia.js"></script>
    <script src="/static/js/fyf/sockjs.js"></script>
    <script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
    <script>
        $(".update").on('click',function () {
            var id = $(this).attr("id");
            $.get('updateLeave?id=' + id,function () {
                window.location.href = "/insertLeave1?id="+id;
            });

        });

        $(".delete").on('click',function (){
            $(this).parent().parent().parent().remove();
            var id = $(this).attr("id");
            $.get('deleteLeave?id='+id)
            }
        );

    </script>
</body>
</html>