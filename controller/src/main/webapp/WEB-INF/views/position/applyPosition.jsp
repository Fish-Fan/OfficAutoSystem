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
    <!--simditor-->
    <link rel="stylesheet" href="/static/css/fyf/simditor.css">
    <!--select2-->
    <link rel="stylesheet" href="/static/css/fyf/select2.css">
    <script src="/static/js/fyf/jQuery2.2.3.js"></script>
</head>
<body>
<div id="wrapper" style="min-height: 100vh">
    <jsp:include page="/WEB-INF/views/framework/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/WEB-INF/views/framework/topbar.jsp"/>
        <div style="padding:20px">
            <p class="text-info">${message}</p>
            <form action="/position/up" method="post">
                <input type="text" name="departmentId" hidden value="${user.department.id}">
                <input type="text" name="userId" hidden value="${user.id}">
                <div class="form-group">
                    <label>当前职位:</label>
                    <p>${user.department.department} - <span>${user.position.position}</span></p>
                </div>
                <div class="form-group">
                    <label>晋升职位:</label>
                    <select id="positionInput" type="text" class="form-control" name="positionId">
                        <c:forEach items="${positionList}" var="position">
                            <option value="${position.id}">${position.position}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>申请原因</label>
                    <textarea name="applicationReason" id="applicationReasonInput" cols="30" rows="10"></textarea>
                </div>
                <button type="submit" class="btn btn-primary" style="width: 100%">提交申请</button>
            </form>
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
<!--select2-->
<script src="/static/js/fyf/select2.js"></script>
<!--simditor-->
<script src="/static/js/fyf/simditor/module.js"></script>
<script src="/static/js/fyf/simditor/hotkeys.js"></script>
<script src="/static/js/fyf/simditor/uploader.js"></script>
<script src="/static/js/fyf/simditor/simditor.js"></script>

<script>
    $(function () {
        $('#positionInput').select2();
        //初始化textarea
        var editor = new Simditor({
            textarea: $('#applicationReasonInput'),
            upload:{
                url: 'http://up-z1.qiniu.com/',
                params:{'token':'${token}'},
                fileKey:'file'
            }
        });
    })
</script>
</body>
</html>