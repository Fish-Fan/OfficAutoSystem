<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>签到中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">


        <link href="/static/css/css/bootstrap.min.css" rel="stylesheet">
        <link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
        <link href="/static/css/css/animate.css" rel="stylesheet">
        <link href="/static/css/css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
        <script src="/static/js/fyf/jQuery2.2.3.js"></script>
        <link rel="stylesheet" href="/static/dist/css/layui.css">
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
                                        <th>签到人</th>
                                        <th>所属部门</th>
                                        <th>职务</th>
                                        <th>签到时间</th>
                                        <th>签到情况</th>
                                        <th>签退时间</th>
                                        <th>签退情况</th>
                                    </tr>
                                    </thead>
                                    <c:forEach items="${attendances}" var="attendance">
                                        <tbody>
                                            <tr>
                                                <td>${attendance.user.username}</td>
                                                <td>${attendance.user.department.department}</td>
                                                <td>${attendance.user.position.position}</td>
                                                <td>${attendance.attendanceTime}</td>
                                                <td>${attendance.startStatus.states}</td>
                                                <td>${attendance.departureTime}</td>
                                                <td>${attendance.departureStatus.states}</td>
                                            </tr>
                                        </tbody>
                                    </c:forEach>
                                    <tfoot>
                                    <tr>
                                        <td colspan="7">
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
 	</body>
    <script src="https://cdn.bootcss.com/axios/0.18.0/axios.js"></script>
    <script src="/static/js/css/jquery-2.1.1.js"></script>
    <script src="/static/js/css/bootstrap.min.js"></script>
    <script src="/static/js/css/metisMenu/jquery.metisMenu.js"></script>
    <script src="/static/js/css/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="/static/js/css/inspinia.js"></script>
    <script src="/static/js/fyf/sockjs.js"></script>
    <script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
</html>