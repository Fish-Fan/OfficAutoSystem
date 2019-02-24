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
        <!--本页面Css-->
        <link href="/static/css/lyj/sign.css" rel="stylesheet">
        <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
        <script src="/static/js/fyf/jQuery2.2.3.js"></script>
    </head>
    <body>
		<div id="wrapper">
			<jsp:include page="/WEB-INF/views/css/sidebar.jsp"/>
			<div id="page-wrapper" class="gray-bg dashbard-1">
				<jsp:include page="/WEB-INF/views/css/topbar.jsp"/>
				<div style="padding:20px">
                    <div class="ibox">

                            <div class="row">
                                <div class="col-md-6">
                                    <video id="video" width="400" height="300"></video>
                                    <button id='tack' class="btn btn-primary"> 拍照</button>
                                </div>
                                <div class="col-md-6" style="min-height: 400px">
                                    <img id='img' src='' class="hide">
                                    <canvas id='canvas' width='400' height='300'></canvas>
                                </div>
                                <audio id="voice" src=""  autoplay="autoplay"/>
                            </div>
                    </div>

                        <%--<c:if test="${isSign eq 1}">--%>
                            <%--<a data-toggle="modal"  class="btn btn-primary  sign-btn" href="#modal-form">签退</a>--%>
                        <%--</c:if>--%>
                    </div>
                    </div>
				</div>
			</div>
		</div>
 	</body>
    <script src="https://cdn.bootcss.com/axios/0.18.0/axios.js"></script>
    <script src="/static/js/css/jquery-2.1.1.js"></script>
    <script src="/static/js/fyf/jQuery2.2.3.js"></script>
    <script src="/static/js/css/bootstrap.min.js"></script>
    <script src="/static/js/css/metisMenu/jquery.metisMenu.js"></script>
    <script src="/static/js/css/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="/static/js/css/inspinia.js"></script>
    <script src="/static/js/fyf/sockjs.js"></script>
    <script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
    <script src="/static/js/fyf/timeago.js"></script>

    <script>
        $(function () {
            $(function () {
                var video = document.getElementById('video'),
                    canvas = document.getElementById('canvas'),
                    snap = document.getElementById('tack'),
                    img = document.getElementById('img'),
                    vendorUrl = window.URL || window.webkitURL;

                //媒体对象
                navigator.getMedia = navigator.getUserMedia ||
                    navigator.webkitGetUserMedia ||
                    navigator.mozGetUserMedia ||
                    navigator.msGetUserMedia;
                navigator.getMedia({
                    video: true, //使用摄像头对象
                    audio: false  //不适用音频
                }, function (strem) {
                    //console.log(strem);
                    // video.src = vendorUrl.createObjectURL(strem);
                    video.srcObject = strem;
                    video.play();
                }, function (error) {
                    //error.code
                    console.log(error);
                });
                snap.addEventListener('click', function () {

                    //绘制canvas图形
                    canvas.getContext('2d').drawImage(video, 0, 0, 400, 300);

                    //把canvas图像转为img图片
                    img.src = canvas.toDataURL("image/png");

                    $.post('/user/facesearch',{
                        "img": img.src.split(',')[1]
                    },function (data) {
                        var result = JSON.parse(data);
                        var type = result.result;
                        if(type == 'error') {
                            toastr.error('没有检测到人脸', '签到失败');
                        } else if(type == 'warning') {
                            toastr.warning('没有找到该用户', '签到失败');
                        } else {
                            toastr.success('签到成功', '5秒后跳转至个人信息页面');
                            // setTimeout(function () {
                            //    window.location.href = "/message"
                            // },5000);
                        }

                        // if(data != null) {
                        //     var result = JSON.parse(data);
                        //     var type = result.result;
                        //     if(type == 'error') {
                        //         toastr.error('没有检测到人脸', '签到失败');
                        //     } else if(type == 'warning') {
                        //         toastr.warning('没有找到该用户', '签到失败');
                        //     } else {
                        //         toastr.success('签到成功', '5秒后跳转至个人信息页面');
                        //         // setTimeout(function () {
                        //         //    window.location.href = "/message"
                        //         // },5000);
                        //     }
                        // } else {
                        //
                        // }

                        $('#voice').attr('src',result.voice)
                    });

                })
            });
        });
    </script>
</html>