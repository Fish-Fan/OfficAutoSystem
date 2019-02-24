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
</head>
<body>
<div id="wrapper" style="min-height: 100vh">
    <jsp:include page="/WEB-INF/views/css/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/WEB-INF/views/css/topbar.jsp"/>
        <div style="padding:20px">
            <div class="wrapper wrapper-content">
                <div class="row animated fadeInRight">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-content" id="ibox-content">

                                <div id="vertical-timeline" class="vertical-container dark-timeline">
                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon navy-bg">
                                            <i class="fa fa-briefcase"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <h2>会议提交成功</h2>
                                            <p>
                                                <label>会议发起人:</label>
                                                <span>fanyanj</span>
                                            </p>
                                            <p>
                                                <label>审批人:</label>
                                                <span>佩奇</span>
                                            </p>
                                            <p>
                                                <label>创建时间: </label>
                                                <span>2018/12/12 9:00</span>
                                            </p>
                                            <p>
                                                <label>会议时间:</label>
                                                <span>9:00 AM - 12:00 AM</span>
                                            </p>
                                            <p>
                                                <label>会议地点: </label>
                                                <span>B404</span>
                                            </p>
                                            <p>
                                                <label>会议级别:</label>
                                                <span>每周例会</span>
                                            </p>
                                            <p>
                                                <label>会议标题:</label>
                                                <span>十九届三中全会</span>
                                            </p>
                                            <p>
                                                <label>会议内容</label>
                                                <span><p>大家好，我是渣渣辉。</p><p><img alt="weixin.jpg" src="http://cdn.fanyank.com/FhK29d3Xt3hkpHs-jPS0eo7kXkj4" width="430" height="430"><br></p></span>
                                            </p>
                                            <span class="vertical-date">
                                        今天 <br/>
                                        <small>12月24日</small>
                                    </span>
                                        </div>
                                    </div>

                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon gray-bg">
                                            <i class="fa fa-file-text"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <h2>等待审批中...</h2>
                                            <p>正在等待主管佩奇审批</p>
                                            <span class="vertical-date">
                                        今天 <br/>
                                        <small>12月24日</small>
                                    </span>
                                        </div>
                                    </div>

                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon gray-bg">
                                            <i class="fa fa-coffee"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <h2>审批结果</h2>
                                            <p>暂无结果</p>
                                            <span class="vertical-date"> 昨天 <br/><small>12月23日</small></span>
                                        </div>
                                    </div>


                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/static/js/fyf/jQuery2.2.3.js"></script>
<script src="/static/css/fyf/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<!--come from index-->
<script src="/static/js/css/metisMenu/jquery.metisMenu.js"></script>
<script src="/static/js/css/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/js/css/inspinia.js"></script>
<script>

</script>
</body>
</html>