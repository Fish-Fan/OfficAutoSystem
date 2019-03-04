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

    <script src="/static/js/fyf/jQuery2.2.3.js"></script>
    <!--come from index-->
    <link rel="stylesheet" href="/static/css/fyf/bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
    <link href="/static/css/fyf/simditor.css" rel="stylesheet">
    <%--<link href="/static/css/css/hemisu-light.css" rel="stylesheet">--%>
    <link href="/static/css/css/style1.css" rel="stylesheet">
    <!--simditor-->
    <link rel="stylesheet" href="/static/css/fyf/simditor.css">
    <link rel="stylesheet" href="/static/dist/css/layui.css">
</head>
<body>
<div id="wrapper" style="min-height: 100vh">
    <jsp:include page="/WEB-INF/views/framework/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/WEB-INF/views/framework/topbar.jsp"/>
        <div style="padding:20px">


            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="box" style="padding: 10px 20px;margin-bottom: 20px">
                    <ul class="breadcrumb" style="background-color: #fff;margin-bottom: 0px;">
                        <li><a href="/index.do">首页</a></li>
                        <li class="active">${topic.node.nodeName}</li>
                    </ul>
                    <div class="topic-head">

                        <img class="img-rounded avatar" style="height: 100px;width: 100px" src="${topic.user.avatar}" alt="">
                        <h3 class="title" style="line-height: 40px">${topic.title}</h3>
                        <p class="topic-msg muted"><a href="">来自: ${topic.user.username}</a>  </p>
                    </div>
                    <div class="topic-body">
                        ${topic.text}
                    </div>

                </div>
                <div class="ibox-content forum-post-container">
                    <div class="forum-post-info">
                        <h4><span class="text-navy"><i class="fa fa-globe"></i> General discussion</span> - Little pig - <span class="text-muted">Free talks</span></h4>
                     </div>
                    <c:forEach items="${commentList}" var="comment">
                    <div class="media">

                        <a class="forum-avatar" href="#">
                            <%--有问题--%>
                                <c:if test ="${comment.user.avatar == null }">
                            <img src="http://cdn.fanyank.com/Fm77jCT1O8fVcP-KqZFhMjXjErSh" class="img-circle" alt="image">
                                </c:if>
                                <c:if test ="${comment.user.avatar != null }">
                                    <img src="${comment.user.avatar}" class="img-circle" alt="image">
                                </c:if>
                            <div class="author-info">
                                <strong>${comment.user.username}</strong><br/>
                                <strong>${comment.createTime}</strong> <br/>
                            </div>
                        </a>
                        <div class="media-body">
                            ${comment.comment}
                            <br/><br/>
                            - From
                            Little Pig  , Company
                        </div>
                    </div>
                    </c:forEach>
                </div>

                <div class="box" style="margin:20px 0px;" id="commentForm">
                    <a name="new"></a>
                    <div class="talk-item muted" style="font-size: 12px"><i class="fa fa-plus"></i> 添加一条新回复</div>
                    <form method="post" action="/comment.do"  style="padding: 15px;margin-bottom:0px; ">

                        <textarea name="comment" id="editor" rows="3" cols="20"></textarea>
                        <input type="hidden" name="topicId" value="${topic.id}">
                        <input type="hidden" name="replyNumber" value="${topic.replyNumber}">
                        <input type="hidden" name="userId" value="${topic.user.id}">

                    <div class="talk-item muted" style="text-align: right;font-size: 12px">
                        <span class="pull-left">请尽量让自己的回复能够对别人有帮助回复</span>
                        <button id="sendBtn" class="btn btn-primary" type="submit">发布</button>
                    </div>
                    </form>
                </div>
            </div>



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

<!--simditor-->
<script src="/static/js/fyf/simditor/module.js"></script>
<script src="/static/js/fyf/simditor/hotkeys.js"></script>
<script src="/static/js/fyf/simditor/uploader.js"></script>
<script src="/static/js/fyf/simditor/simditor.js"></script>

<script src="/static/js/fyf/timepicki.js"></script>
<script>
    $(function () {
       var editor = new Simditor({
           textarea: $('#editor'),
           toolbar: false
       });
    })

</script>
</body>
</html>