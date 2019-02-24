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

        <!--come from index-->
        <link rel="stylesheet" href="/static/css/fyf/bootstrap-3.3.5-dist/css/bootstrap.css">
        <link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
        <link href="/static/css/css/animate.css" rel="stylesheet">
        <link href="/static/css/css/style.css" rel="stylesheet">
        <!--iCheck-->
        <link rel="stylesheet" href="/static/css/fyf/icheck-1.x/skins/square/red.css">
        <!--simditor-->
        <link rel="stylesheet" href="/static/css/fyf/simditor.css">
        <!--select2-->
        <link rel="stylesheet" href="/static/css/fyf/select2.css">
        <!--datepicker-->
        <link href="/static/css/lyj/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
        <!-- 本页面css -->
        <link rel="stylesheet" href="/static/css/lyj/leave.css">
        <!-- Sweet Alert -->
        <link href="/static/css/gsy/plugins/sweetalert/sweetalert.css" rel="stylesheet">
        <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
        <script src="/static/js/fyf/jQuery2.2.3.js"></script>
    </head>


    <body>
        <div id="wrapper">
            <jsp:include page="/WEB-INF/views/css/sidebar.jsp"/>
            <div id="page-wrapper" class="gray-bg dashbard-1">
                <jsp:include page="/WEB-INF/views/css/topbar.jsp"/>
                <div style="padding:20px">
                    <form modelAttribute="leave" action="insertLeave" method="post"  enctype="multipart/form-data">

                        <label for="dtp_input1" class="col-md-2 control-label">开始时间：</label>
                        <div class="input-group date form_datetime col-md-5"  data-date-format="yyyy-mm-dd HH:ii" data-link-field="dtp_input1">
                            <input class="form-control" name="startTime" size="16" type="text" readonly value="${leave.startTime}">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input1" value="" /><br/>
                        <label for="dtp_input1" class="col-md-2 control-label">结束时间：</label>
                        <div class="input-group date form_datetime col-md-5"  data-date-format="yyyy-mm-dd HH:ii" data-link-field="dtp_input2">
                            <input class="form-control" name="deadlineTime" readonly size="16" type="text" value="${leave.deadlineTime}">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input2" value="" /><br/>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">请假类型:</label>
                            <div class="col-sm-10 type"><input type="text" class="form-control" name="type "  value="${leave.type}"></div>
                        </div>
                        <div id="reason">
                        <label class="labelReason">请假原因:</label>
                        <textarea name="reason" id="abstract_text" cols="26" rows="10" value="${leave.reason}"></textarea>
                        </div>
                        <input class="id" name="id" value="${leave.id}">
                        <div id="buttons">
                            <button class="btn btn-success btn-sm insert demo2" type="submit">提交</button>
                            <button class="btn btn-danger btn-sm cancel demo4">取消</button>
                        </div>
                    </form>
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
    <link rel="stylesheet" href="/static/css/fyf/icheck-1.x/skins/square/red.css">
    <!--simditor-->
    <script src="/static/js/fyf/simditor/module.js"></script>
    <script src="/static/js/fyf/simditor/hotkeys.js"></script>
    <script src="/static/js/fyf/simditor/uploader.js"></script>
    <script src="/static/js/fyf/simditor/simditor.js"></script>
    <!--select2-->
    <script src="/static/js/fyf/select2.js"></script>
    <script src="/static/js/fyf/sockjs.js"></script>
    <script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
    <!--datepicker-->
    <script src="/static/js/lyj/bootstrap-datetimepicker.js"></script>
    <!-- Sweet alert -->
    <script src="/static/js/gsy/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script>
        $(document).ready(function(){
            $(".id").css('display','none');
        });
        //弹出内容
        $('.insert').click(function(){
            swal({
                title: "提交成功",
                text: "您已成功提交请假申请",
                type: "success"
            });
        });
        $('.cancel').click(function(){
            swal({
                title: "取消",
                text: "您已放弃您的请假申请",
                type: "success"
            });
        });
        //初始化textarea
        var editor = new Simditor({
            textarea: $('#abstract_text'),
            upload:{
                url: 'http://up-z1.qiniu.com/',
                params:{'token':'${token}'},
                fileKey:'file'
            }
        });
        $.fn.datetimepicker.dates['zh'] = {
            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
            daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            today: "今天",
            /*suffix: [],*/
            meridiem: ["上午", "下午"]
        }
        //初始化datetimepicker
        $('.form_datetime').datetimepicker({
            language:  'zh',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 1,
            showMeridian: 1
        });
    </script>

</html>