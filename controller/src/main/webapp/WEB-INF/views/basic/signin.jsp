<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>签到</title>
    <link rel="stylesheet" href="/static/dist/css/layui.css">
</head>
<body>
<%--<input type="button" title="开启摄像头" value="开启摄像头" onclick="getMedia();" /><br />--%>
<%--<video height="360px" autoplay="autoplay"></video><hr />--%>
<%--<input type="button" title="拍照" value="拍照" onclick="getPhoto();" /><br />--%>
<%--<canvas id="canvas1" height="360px" ></canvas> <hr />--%>
<%--<input title="签到" value="签到" /><br />--%>
<%--<audio id="voice" src=""  autoplay="autoplay">--%>
<%--</audio>--%>

<div class="booth">
    <audio id="voice" src=""  autoplay="autoplay"/>
    <video id="video" width="400" height="300"></video>
    <button id='tack'> 拍照</button>
    <canvas id='canvas' width='400' height='300'></canvas>
    <img id='img' src=''>
</div>

<script src="/static/js/fyf/jQuery2.2.3.js"></script>
<script>

</script>
</body>
</html>