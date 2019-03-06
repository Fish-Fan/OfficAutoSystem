<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--come from index-->
    <link rel="stylesheet" href="/static/css/fyf/bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
    <link rel="stylesheet" href="/static/dist/css/layui.css">
    <script src="/static/js/fyf/jQuery2.2.3.js"></script>
</head>
<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/views/framework/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="/WEB-INF/views/framework/topbar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>个人信息</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/index">首页</a>
                    </li>
                    <li class="active">
                        <strong>个人信息</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-content">
                            <div>
                                        <span class="pull-right text-right">
                                        <small>过去一个月销售量: <strong>中国</strong></small>
                                            <br/>
                                            所有销售量: 162,862
                                        </span>
                                <h1 class="m-b-xs">$ 50,992</h1>
                                <h3 class="font-bold no-margins">
                                    年中销售量
                                </h3>
                                <small>销售市场.</small>
                            </div>

                            <div>
                                <canvas id="lineChart" height="70"></canvas>
                            </div>

                            <div class="m-t-md">
                                <small class="pull-right">
                                    <i class="fa fa-clock-o"> </i>
                                    更新于 16.07.2015
                                </small>
                                <small>
                                    <strong>销售分析:</strong> 过去一个月的销售额超过 $50,000.
                                </small>
                            </div>

                        </div>
                    </div>
                </div>
            </div>


            <div class="row">

                <div class="col-lg-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-primary pull-right">今天</span>
                            <h5>访问量</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">22 285,400</h1>
                            <div class="stat-percent font-bold text-navy">20% <i class="fa fa-level-up"></i></div>
                            <small>新订单</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-right">月</span>
                            <h5>订单</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">60 420,600</h1>
                            <div class="stat-percent font-bold text-info">40% <i class="fa fa-level-up"></i></div>
                            <small>新订单</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-warning pull-right">季度</span>
                            <h5>收入</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">$ 120 430,800</h1>
                            <div class="stat-percent font-bold text-warning">16% <i class="fa fa-level-up"></i></div>
                            <small>新订单</small>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>新数据报告</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">设置 1</a>
                                    </li>
                                    <li><a href="#">设置 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content ibox-heading">
                            <h3>价格上涨
                                <div class="stat-percent text-navy">34% <i class="fa fa-level-up"></i></div>
                            </h3>
                            <small><i class="fa fa-stack-exchange"></i> 新的季度数据.</small>
                        </div>
                        <div class="ibox-content">
                            <div>

                                <div class="pull-right text-right">

                                    <span class="bar_dashboard">5,3,9,6,5,9,7,3,5,2,4,7,3,2,7,9,6,4,5,7,3,2,1,0,9,5,6,8,3,2,1</span>
                                    <br/>
                                    <small class="font-bold">$ 20 054.43</small>
                                </div>
                                <h4>NYS数据报告!
                                    <br/>
                                    <small class="m-r"><a href="graph_flot.html"> 检查价格是否正确! </a> </small>
                                </h4>
                            </div>
                        </div>
                    </div>
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>查看评论和微博</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">设置 1</a>
                                    </li>
                                    <li><a href="#">设置 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content no-padding">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <p><a class="text-info" href="#">@Alan Marry</a> 我相信.</p>
                                    <small class="block text-muted"><i class="fa fa-clock-o"></i> 1分钟前</small>
                                </li>
                                <li class="list-group-item">
                                    <p><a class="text-info" href="#">@Stock Man</a> 检查价格，太贵了! </p>
                                    <small class="block text-muted"><i class="fa fa-clock-o"></i> 2小时前</small>
                                </li>
                                <li class="list-group-item">
                                    <p><a class="text-info" href="#">@Kevin Smith</a> 罗一模是谁？ </p>
                                    <small class="block text-muted"><i class="fa fa-clock-o"></i> 2分钟前</small>
                                </li>
                                <li class="list-group-item ">
                                    <p><a class="text-info" href="#">@Jonathan Febrick</a> 卡车，一卡车的东西</p>
                                    <small class="block text-muted"><i class="fa fa-clock-o"></i> 1小时前</small>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>时间轴</h5>
                            <span class="label label-primary">今日会议</span>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">设置 1</a>
                                    </li>
                                    <li><a href="#">设置 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>

                        <div class="ibox-content inspinia-timeline">

                            <div class="timeline-item">
                                <div class="row">
                                    <div class="col-xs-3 date">
                                        <i class="fa fa-briefcase"></i>
                                        6:00 am
                                        <br/>
                                        <small class="text-navy">2小时前</small>
                                    </div>
                                    <div class="col-xs-7 content no-top-border">
                                        <p class="m-b-xs"><strong>会议</strong></p>

                                        <p>产品会议.</p>

                                    </div>
                                </div>
                            </div>
                            <div class="timeline-item">
                                <div class="row">
                                    <div class="col-xs-3 date">
                                        <i class="fa fa-file-text"></i>
                                        7:00 am
                                        <br/>
                                        <small class="text-navy">3小时前</small>
                                    </div>
                                    <div class="col-xs-7 content">
                                        <p class="m-b-xs"><strong>发邮件</strong></p>
                                        <p>发一封邮件，发凉风邮件.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="timeline-item">
                                <div class="row">
                                    <div class="col-xs-3 date">
                                        <i class="fa fa-coffee"></i>
                                        8:00 am
                                        <br/>
                                    </div>
                                    <div class="col-xs-7 content">
                                        <p class="m-b-xs"><strong>喝杯咖啡</strong></p>
                                        <p>
                                            去死吧，还和咖啡.
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="timeline-item">
                                <div class="row">
                                    <div class="col-xs-3 date">
                                        <i class="fa fa-phone"></i>
                                        11:00 am
                                        <br/>
                                        <small class="text-navy">21小时前</small>
                                    </div>
                                    <div class="col-xs-7 content">
                                        <p class="m-b-xs"><strong>电话会议</strong></p>
                                        <p>
                                            打个电话给老婆.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <div class="footer">
            <div>
                <strong>Little'System</strong>  &copy; 2018
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


<!-- Flot -->
<script src="/static/js/css/flot/jquery.flot.js"></script>
<script src="/static/js/css/flot/jquery.flot.tooltip.min.js"></script>
<script src="/static/js/css/flot/jquery.flot.spline.js"></script>
<script src="/static/js/css/flot/jquery.flot.resize.js"></script>
<script src="/static/js/css/flot/jquery.flot.pie.js"></script>
<script src="/static/js/css/flot/jquery.flot.symbol.js"></script>
<script src="/static/js/css/flot/curvedLines.js"></script>

<!-- Peity -->
<script src="/static/js/css/jquery.peity.min.js"></script>
<script src="/static/js/css/peity-demo.js"></script>

<!-- Custom and plugin javascript -->
<script src="/static/js/css/inspinia.js"></script>
<script src="/static/js/css/pace.min.js"></script>

<!-- jQuery UI -->
<script src="/static/js/css/jquery-ui.min.js"></script>


<!-- Sparkline -->
<script src="/static/js/css/jquery.sparkline.min.js"></script>

<!-- Sparkline demo data  -->
<script src="/static/js/css/sparkline-demo.js"></script>

<!-- ChartJS-->
<script src="/static/js/css/Chart.min.js"></script>

<script>
    $(document).ready(function() {

        var lineData = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "Example dataset",
                    fillColor: "rgba(220,220,220,0.5)",
                    strokeColor: "rgba(220,220,220,1)",
                    pointColor: "rgba(220,220,220,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(220,220,220,1)",
                    data: [65, 59, 80, 81, 56, 55, 40]
                },
                {
                    label: "Example dataset",
                    fillColor: "rgba(26,179,148,0.5)",
                    strokeColor: "rgba(26,179,148,0.7)",
                    pointColor: "rgba(26,179,148,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(26,179,148,1)",
                    data: [28, 48, 40, 19, 86, 27, 90]
                }
            ]
        };

        var lineOptions = {
            scaleShowGridLines: true,
            scaleGridLineColor: "rgba(0,0,0,.05)",
            scaleGridLineWidth: 1,
            bezierCurve: true,
            bezierCurveTension: 0.4,
            pointDot: true,
            pointDotRadius: 4,
            pointDotStrokeWidth: 1,
            pointHitDetectionRadius: 20,
            datasetStroke: true,
            datasetStrokeWidth: 2,
            datasetFill: true,
            responsive: true,
        };


        var ctx = document.getElementById("lineChart").getContext("2d");
        var myNewChart = new Chart(ctx).Line(lineData, lineOptions);

    });
</script>

</body>
</html>
