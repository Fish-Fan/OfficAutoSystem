<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>请假中心</title>

		<link href="/static/css/css/bootstrap.min.css" rel="stylesheet">
		<link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
		<link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
		<link href="/static/css/css/animate.css" rel="stylesheet">
		<link href="/static/css/css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
        <!--datepicker-->
        <link href="/static/css/lyj/datepicker3.css" rel="stylesheet">
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

                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="date_added">添加日期</label>
                            <div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="date_added" type="text" class="form-control" value="03/04/2014">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">

                        </div>
                    </div>
                        <form:form modelAttribute="leave" action="insertLeave" method="post"  enctype="multipart/form-data">

                            <ul id="leaveInfo">
                                开始时间：<li><form:input path="startTime" disabled="true"/></li>
                                结束时间：<li><form:input path="deadlineTime" disabled="true"/></li>
                                请假类型：<li><form:input path="type" disabled="true"/></li>
                            </ul>
                            <ul id="leaveReason">
                                请假原因：<form:textarea path = "reason" disabled="true"></form:textarea>
                            </ul>
                            <input type="button" value="批准" id="approve"/>
                            <input type="button" id="cancle" value="拒绝" id="disapprove" />
                        </form:form>
                </div>
            </div>
        </div>
 	</body>
    <script src="https://cdn.bootcss.com/axios/0.18.0/axios.js"></script>
    <script src="/static/js/css/bootstrap.min.js"></script>
    <script src="/static/js/css/metisMenu/jquery.metisMenu.js"></script>
    <script src="/static/js/css/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="/static/js/css/inspinia.js"></script>
    <script src="/static/js/fyf/sockjs.js"></script>
    <script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
    <script>
            $('#approve').on('click',function () {
                $.get('approveLeave?id='+${leave.id})
                }
            );
            $('#disapprove').on('click',function () {
                    $.get('disapproveLeave?id='+${leave.id})
                }
            );

     </script>
</html>