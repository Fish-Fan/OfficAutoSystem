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


        <!--come from index-->
        <link rel="stylesheet" href="/static/css/fyf/bootstrap-3.3.5-dist/css/bootstrap.css">
        <link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
        <link href="/static/css/css/animate.css" rel="stylesheet">
        <link href="/static/css/css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
        <!--iCheck-->
        <link rel="stylesheet" href="/static/css/fyf/icheck-1.x/skins/square/red.css">
        <!--timepicker-->
        <link rel="stylesheet" href="/static/css/fyf/timepicker/timepicki.css">
        <!--conference-->
        <link rel="stylesheet" href="/static/css/fyf/conference.css">
        <!--select2-->
        <link rel="stylesheet" href="/static/css/fyf/select2.css">
        <script src="/static/js/fyf/jQuery2.2.3.js"></script>
    </head>
    <body>
		<div id="wrapper">
			<jsp:include page="/WEB-INF/views/framework/sidebar.jsp"/>
			<div id="page-wrapper" class="gray-bg dashbard-1">
				<jsp:include page="/WEB-INF/views/framework/topbar.jsp"/>
				<div style="padding:20px">
                    <form:form  id="sign" modelAttribute="attendanceStandard" action="insertAttendanceStandard" method="post"
                                                      enctype="multipart/form-data">
                        <label>签到时间设置:</label>
                        <input type="text" name="workTime" class="time_element form-control" value="${attendanceStandard.workTime}"/>
                        <label>签退时间设置:</label>
                        <input type="text" name="closingTime" class="time_element form-control" value="${attendanceStandard.closingTime}"/>
                        <label>季节:</label>
                        <input type="text" class="form-control" name="season" value="${attendanceStandard.season}">
                        <input class="id" name="id" value="${attendanceStandard.id}">
                        <button class="btn btn-success submitBtn" type="submit">提交</button>
                    </form:form>

				</div>
			</div>
		</div>
 	</body>
    <script src="/static/css/fyf/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <!--come from index-->
    <script src="/static/js/css/metisMenu/jquery.metisMenu.js"></script>
    <script src="/static/js/css/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="/static/js/css/inspinia.js"></script>
    <!--iCheck-->
    <script src="/static/js/fyf/icheck.min.js"></script>
    <!--timepicker-->
    <script src="/static/js/fyf/timepicki.js"></script>
    <!--select2-->
    <script src="/static/js/fyf/select2.js"></script>
    <script src="/static/js/fyf/sockjs.js"></script>
    <script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
    <script>
        $(document).ready(function(){
           $(".id").css('display','none');
        });
        $(".time_element").timepicki({
            show_meridian:false,
            min_hour_value:0,
            max_hour_value:23,
            step_size_minutes:1,
            overflow_minutes:true,
            increase_direction:'down',
            disable_keyboard_mobile: true});

        function submit(callback){
            document.getElementById("sign").submit();
            callback();
        }
    </script>
</html>