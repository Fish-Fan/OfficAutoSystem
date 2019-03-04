<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <!--select2-->
    <link rel="stylesheet" href="/static/css/fyf/select2.css">
    <link rel="stylesheet" href="/static/dist/css/layui.css">

    <script src="/static/js/fyf/jQuery2.2.3.js"></script>
    <link rel="stylesheet" href="/static/css/fyf/conference.css">
</head>
<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/views/framework/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/WEB-INF/views/framework/topbar.jsp"/>
        <div style="padding:20px">
            <h1>您的职位是 ${sessionScope.get("current_user").position.position}</h1>
            <form action="/position/control" method="post">
                <input type="text" name="departmentId" hidden value="1">
                <div class="form-group">
                    <label>搜索职员:</label>
                    <select id="searchInput" type="text" class="form-control" name="userId"></select>
                </div>
                <div class="form-group">
                    <label>选择职位:</label>
                    <select id="positionInput" type="text" class="form-control" name="positionId">
                        <c:forEach items="${positionList}" var="position">
                            <option value="${position.id}">${position.position}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>调度原因</label>
                    <input type="text" class="form-control" name="reason">
                </div>
                <button type="submit" class="btn btn-primary" style="width: 100%">确认调度</button>
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
<script>
    $(function () {
        var position = ['职员','主管','经理','老板'];
        $('#positionInput').select2();

        function formatRepo (repo) {
            if (repo.loading) {
                return repo.text;
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


        var searchInput = $('#searchInput').select2({
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
                cache: true
            },
            minimumInputLength: 1,
            escapeMarkup: function (markup) { return markup; },
            templateResult: formatRepo,
            templateSelection: formatRepoSelection

        });
    })
</script>
</body>
</html>