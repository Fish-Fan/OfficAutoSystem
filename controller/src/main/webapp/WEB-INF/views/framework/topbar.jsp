<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String wsPath = "ws://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="/static/js/fyf/toastr.min.js"></script>
<script src="/static/js/fyf/timeago.js"></script>
<script src="/static/dist/layui.js"></script>
<div class="row border-bottom">
    <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
            <form role="search" class="navbar-form-custom" action="#">
                <div class="form-group">
                    <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                </div>
            </form>
        </div>
        <ul class="nav navbar-top-links navbar-right">
            <li>
                <span class="m-r-sm text-muted welcome-message">欢迎您：${sessionScope.get("current_user").username}</span>
            </li>

            <li class="dropdown">
                <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell"></i>  <span id="notifyCount" class="label label-primary">0</span>
                </a>
                <ul id="notifyUl" class="dropdown-menu dropdown-alerts">

                </ul>
            </li>


            <li>
                <a href="/user/userExit">
                    <i class="fa fa-sign-out"></i> 退出登录
                </a>
            </li>
        </ul>

    </nav>
</div>
<script>
    $(function () {
        //渲染bell
        var userId = ${sessionScope.get("current_user").id};
        $.get("/user/notify?userId=" + userId,function (data) {
            var notifyArr = data;
            notifyArr.forEach(function (notify,index) {
                var icon = '';
                if(notify.type == 'info') {
                    icon = '<span class="bg-primary"><i class="fa fa-comment fa-fw"></i></span>';
                } else if(notify.type == 'success') {
                    icon = '<span style="color:tomato"><i class="fa fa-check-square fa-lg fa-fw"></i></span>';
                } else if(notify.type == 'warning') {
                    icon = '<span class="text-info"><i class="fa fa-exclamation-triangle fa-lg fa-fw"></i></span>';
                } else {
                    icon = '<span class="text-danger"><i class="fa fa-ban fa-fw"></i></span>';
                }
                if(index == notifyArr.length-1) {
                    $('#notifyUl').append('<li><a id='+ notify.id +' href="'+ notify.jumpToUrl +'"><div>'+ icon + notify.title +'<span class="pull-right text-muted small timeago" title="'+ notify.notifyTime +'"></span></div></a></li>');
                } else {
                    $('#notifyUl').append('<li><a id='+ notify.id +' href="'+ notify.jumpToUrl +'"><div>'+ icon + notify.title +'<span class="pull-right text-muted small timeago" title="'+ notify.notifyTime +'"></span></div></a></li><li class="divider"></li>');
                }
            });
            if(notifyArr.length > 0) {
                $('#notifyCount').text(notifyArr.length);
            } else {
                $('#notifyCount').addClass('hide');
            }
            $('.timeago').timeago();
        });
        <!--toastr config-->
        toastr.options = {
            "closeButton": true,
            "debug": false,
            "progressBar": true,
            "preventDuplicates": false,
            "positionClass": "toast-top-right",
            "onclick": null,
            "showDuration": "400",
            "hideDuration": "1000",
            "timeOut": "7000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        };



        function insertNotify(notification) {
            //显示通知
            if(notification.jumpToUrl != undefined) {
                toastr.options.onclick = function () {
                    window.location.href = notification.jumpToUrl;
                }
            }
            if(notification.type == "info") {
                toastr.info(notification.content, notification.title);
            } else if(notification.type == "success") {
                toastr.success(notification.content, notification.title);
            } else if(notification.type == "error") {
                toastr.error(notification.content, notification.title);
            } else {
                toastr.warning(notification.content, notification.title);
            }
            //设置icon
            var icon = '';
            if(notification.type == 'info') {
                icon = '<span class="bg-primary"><i class="fa fa-comment fa-fw"></i></span>';
            } else if(notification.type == 'success') {
                icon = '<span style="color:tomato"><i class="fa fa-check-square fa-lg fa-fw"></i></span>';
            } else if(notification.type == 'warning') {
                icon = '<span class="text-info"><i class="fa fa-exclamation-triangle fa-lg fa-fw"></i></span>';
            } else {
                icon = '<span class="text-danger"><i class="fa fa-ban fa-fw"></i></span>';
            }
            //在topbar中添加通知
            $('#notifyUl').append('<li class="divider"></li><li><a id='+ notification.id +' href="'+ notification.jumpToUrl +'"><div>'+ icon + notification.title +'<span class="pull-right text-muted small timeago" title="'+ notification.notifyTime +'"></span></div></a></li>');
            var notifyCount = parseInt($('#notifyCount').text()) + 1;
            if($('#notifyCount').hasClass('hide')) {
                $('#notifyCount').removeClass('hide');
            }
            $('#notifyCount').text(notifyCount);
            $('.timeago').timeago();
        }

        $('#notifyUl').on('click','a',function (e) {
            e.preventDefault();
            var id = $(this).attr('id');
            var url = $(this).attr('href');
            $.get('/user/notify/update?id='+id,function () {
                window.location.href = url;
            });
        });

        layui.use('layim', function(layim){

            <!--websocket start-->
            var sock;
            if ('WebSocket' in window) {
                sock = new WebSocket("<%=wsPath%>socketServer");
            } else if ('MozWebSocket' in window) {
                sock = new MozWebSocket("<%=wsPath%>socketServer");
            } else {
                sock = new SockJS("<%=basePath%>sockjs/socketServer");
            }
            sock.onopen = function (e) {

            };
            sock.onmessage = function (e) {
                var message = JSON.parse(e.data);
                if(message.type == "friend") {
                    message.mine = false;
                    console.log(message);
                    layim.getMessage(message);
                } else {
                    insertNotify(message);
                }

            };
            sock.onerror = function (e) {
                console.log(e);
            };
            sock.onclose = function (e) {
                console.log(e);
            }



            layim.config({
                init: {
                    url: '/im/init',
                    type: 'get'
                },
                brief: false //是否简约模式（如果true则不显示主面板）

            });

            layim.on('sendMessage',function (res) {
                var mine = res.mine;
                var to = res.to;
                sock.send(JSON.stringify({
                    type: 'chatMessage',
                    data: res
                }));
            });

            layim.on('ready',function (options) {
                console.log(options);
            });
        });
    })
</script>