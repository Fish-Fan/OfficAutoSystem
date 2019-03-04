<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>新建会议</title>
    <!--come from index-->
    <link rel="stylesheet" href="/static/css/fyf/bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
    <!--iCheck-->
    <link rel="stylesheet" href="/static/css/fyf/icheck-1.x/skins/square/red.css">
    <!--simditor-->
    <link rel="stylesheet" href="/static/css/fyf/simditor.css">
    <!--timepicker-->
    <link rel="stylesheet" href="/static/css/fyf/timepicker/timepicki.css">
    <!--conference-->
    <link rel="stylesheet" href="/static/css/fyf/conference.css">
    <!--select2-->
    <link rel="stylesheet" href="/static/css/fyf/select2.css">
    <link rel="stylesheet" href="/static/dist/css/layui.css">
    <script src="/static/js/fyf/jQuery2.2.3.js"></script>
</head>
<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/views/framework/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/WEB-INF/views/framework/topbar.jsp"/>
        <div style="padding:20px">
            <form action="/newconference" method="post">
                <div class="form-group">
                    <label>选择会议室:</label>
                    <div>
                        <c:forEach items="${roomList}" var="item">
                            <label class="icheckbox"><input type="radio" name="site" checked value="${item.room}">${item.room}</label>
                        </c:forEach>
                    </div>

                    <label>参会人员</label>
                    <div>
                        <select id="persons" class="persons form-control" name="persons" multiple="multiple">
                        </select>
                    </div>

                    <label>会议时间:</label>
                    <input type="text" name="startTime" class="time_element form-control"/>
                    -
                    <input type="text" name="deadlineTime" class="time_element form-control">

                    <label>会议主题:</label>
                    <input type="text" class="form-control" name="reason">

                    <label>会议类型:</label>
                    <select name="type" class="form-control" id="conference_type">
                        <c:forEach items="${conferenceTypeList}" var="conferenceType">
                            <option value="${conferenceType.conferenceType}">${conferenceType.conferenceType}</option>
                        </c:forEach>
                    </select>

                    <label>会议摘要:</label>
                    <textarea name="content" id="abstract_text" cols="30" rows="10"></textarea>
                    <button class="btn btn-success submitBtn" type="submit">提交会议</button>
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
<script src="/static/js/fyf/icheck.min.js"></script>
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
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-red',
            radioClass: 'iradio_square-red'
        });

        $(".time_element").timepicki();

        //初始化textarea
        var editor = new Simditor({
            textarea: $('#abstract_text'),
            upload:{
                url: 'http://up-z1.qiniu.com/',
                params:{'token':'${token}'},
                fileKey:'file'
            }
        });

        /**
         * select2 start----------------
         */

        var position = ['职员','主管','经理','老板'];




         function formatRepo (repo) {
            if (repo.loading) {
                return repo.text;
            }
            if(repo.avatar == undefined) {
                repo.avatar = "http://cdn.fanyank.com/Fm77jCT1O8fVcP-KqZFhMjXjErSh";
            }

            var markup='<div class="select2-result-repository clearfix">';
             markup+='        <div class="select2-result-repository__avatar">';
             markup+='            <img src="'+ repo.avatar +'" alt="">';
             markup+='        </div>';
             markup+='        <div class="select2-result-repository__meta">';
             markup+='            <p class="select2-result-repository_title"><span style="color: black;\n' +
                 '    font-weight: 700;\n' +
                 '    word-wrap: break-word;\n' +
                 '    line-height: 1.1;\n' +
                 '    margin-bottom: 4px">' + repo.username + '</span></p>';
             markup+='<p class="select2-result-repository__description">'+ repo.department.department + ' - '+repo.position.position +'</p>'
             markup+='            <p class="select2-result-repository__description">'+ repo.desc +'</p>';
             markup+='        </div>';
             markup+='    </div>';
             markup+='';

            return markup;
        }

        function formatRepoSelection (repo) {
            return repo.username || repo.password;
        }

        $("#conference_type").select2();

        var personInput = $('.persons').select2({
            allowClear: true,
            debug: true,
            placeholder: '员工编号',
            ajax: {
                url: '/user/search/byid',
                dataType: 'json',
                delay: 250,

                data: function (params) {
                    var query = {
                        id: params.term
                    };
                    return query;
                },
                processResults: function (data) {
                    return {
                        results: data.items
                    };
                },
            },
            minimumInputLength: 1,
            escapeMarkup: function (markup) { return markup; },
            templateResult: formatRepo,
            templateSelection: formatRepoSelection

        });

    });
</script>
<script src="/static/js/fyf/sockjs.js"></script>
<script src="/static/js/gsy/js/plugins/pace/pace.min.js"></script>
</html>