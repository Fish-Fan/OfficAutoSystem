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

    <link href="/static/css/css/style1.css" rel="stylesheet">
    <!--simditor-->
    <link rel="stylesheet" href="/static/css/fyf/simditor.css">
    <link rel="stylesheet" href="/static/css/fyf/select2.css">

    <link rel="stylesheet" href="/static/dist/css/layui.css">
</head>
<body>
<div id="wrapper" style="min-height: 100vh">
    <jsp:include page="/WEB-INF/views/framework/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/WEB-INF/views/framework/topbar.jsp"/>
        <div style="padding:20px">

                <div class="box-header">
                    <span class="title"><i class="fa fa-plus"></i> 发布新主题</span>
                </div>

                <form method="post" action="/newtopic" style="padding: 20px" id="topicForm">
                    <label class="control-label">主题标题</label>
                    <input type="text" name="title" class="form-control" placeholder="请输入主题标题，如果标题能够表达完整内容，则正文可以为空">
                    <label class="control-label">正文</label>

                    <textarea name="text" id="editor"></textarea>

                    <select name="nodeId" id="node_type" style="width: auto">
                        <c:forEach items="${nodeList}" var="node">
                            <option value="${node.id}"> ${node.nodeName}</option>
                        </c:forEach>
                    </select>

                </form>
                <div class="form-actions" style="text-align: center ">
                    <button id="sendBtn" class="btn btn-primary" type="submit">发布主题</button>
                </div>



        </div>
    </div>
</div>


<script src="https://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>
<script src="/static/css/fyf/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<!--come from index-->
<script src="/static/js/css/metisMenu/jquery.metisMenu.js"></script>
<script src="/static/js/css/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/js/css/inspinia.js"></script>

<!--simditor-->
<script src="/static/js/fyf/simditor/module.js"></script>
<script src="/static/js/fyf/simditor/hotkeys.js"></script>
<script src="/static/js/fyf/simditor/uploader.js"></script>
<script src="/static/js/fyf/simditor/simditor.js"></script>

<!--timepicker-->
<script src="/static/js/fyf/timepicki.js"></script>
<!--select2-->
<script src="/static/js/fyf/select2.js"></script>



<script>
    $(function(){
        var editor = new Simditor({
            textarea: $('#editor'),
            upload:{
                url: 'http://up-z1.qiniu.com/',
                params:{'token':'${token}'},
                fileKey:'file'
            }
        });

        $("#sendBtn").click(function(){
            $("#topicForm").submit();
        });

        $("#topicForm").validate({
            errorClass:"text-error",
            errorElement:"span",
            rules:{
                title:{
                    required:true,
                    maxlength:40
                },
                nodeid:{
                    required:true
                }
            },
            messages:{
                title:{
                    required:"请输入标题",
                    maxlength:"标题内容最多40个字符"
                },
                nodeid:{
                    required:"请选择节点"
                }
            }
        });

    });
    $("#node_type").select2();
</script>
</body>
</html>