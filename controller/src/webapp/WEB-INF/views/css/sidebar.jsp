<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <c:if test="${sessionScope.get('current_user').avatar != null}">
                        <span>   <img alt="image" class="img-circle" style="width: 50px;height: 50px" src="${sessionScope.get("current_user").avatar}" /> </span>
                    </c:if>
                 <c:if test="${sessionScope.get('current_user').avatar == null}">
                     <span>   <img alt="image" class="img-circle" style="width: 50px;height: 50px" src="http://cdn.fanyank.com/Fm77jCT1O8fVcP-KqZFhMjXjErSh" /> </span>
                 </c:if>



                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${sessionScope.get("current_user").username}</strong>
                             </span> <span class="text-muted text-xs block">${sessionScope.get("current_user").position.position}<b class="caret"></b></span> </span> </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a href="#">个人信息</a></li>
                        <li><a href="#">联系方式</a></li>
                        <li><a href="#">邮箱</a></li>
                        <li class="divider"></li>
                        <li><a href="/user/userExit">退出登录</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    ${sessionScope.get("current_user").username}
                </div>
            </li>
            <li class="active">
                <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">签到中心</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li class="active"><a href="/attendance">签到 <span class="label label-primary pull-right">记得签到呦</span></a></li>
                    <li><a href="/selectAttendance">签到记录</a></li>
                    <c:if test="${sessionScope.get('current_user').position.id != 1}">
                        <li>
                            <a href="#">签到设置 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a href="/insertAttendanceStandard">签到标准设置</a>
                                </li>
                                <li>
                                    <a href="/selectAttendanceStandard">查看签到标准</a>
                                </li>
                            </ul>
                        </li>
                    </c:if>
                </ul>
            </li>
            <li class="active">
                <a href="#"><i class="fa fa-user"></i> <span class="nav-label">个人中心</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li class="active"><a href="/personal_message">个人信息</a></li>
                    <li><a href="/message">修改资料</a></li>
                    <li><a href="/user/updatePasswords">修改密码</a></li>
                </ul>
            </li>
            <li class="active">
                <a href="#"><i class="fa fa-comments"></i> <span class="nav-label">会议中心</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li class="active"><a href="/newconference">申请会议</a></li>
                    <c:if test="${sessionScope.get('current_user').position.id != 1}">
                        <li><a href="/conference/manager">会议审批</a></li>
                    </c:if>
                    <c:if test="${sessionScope.get('current_user').currentConferenceApplyId != null}">
                        <li><a href="/conference/result?id=${sessionScope.get('current_user').currentConferenceApplyId}">审批状态</a></li>
                    </c:if>

                </ul>
            </li>
            <li class="active">
                <a href="#"><i class="fa fa-chevron-circle-up"></i> <span class="nav-label">我的职位</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li class="active"><a href="/position/up">职位申请</a></li>
                    <c:if test="${sessionScope.get('current_user').position.id == 3}">
                        <li><a href="/position/applyinfo/boss">审批职位</a></li>
                        <li><a href="/position/control">职位调度</a></li>
                    </c:if>
                    <c:if test="${sessionScope.get('current_user').position.id == 2}">
                        <li><a href="/position/applyinfo/manager">审批职位</a></li>
                        <li><a href="/position/control">职位调度</a></li>
                    </c:if>

                    <c:if test="${sessionScope.get('current_user').currentPositionApplyId != null}">
                        <li><a href="/position/afterapply?id=${sessionScope.get('current_user').currentPositionApplyId}">申请状态</a></li>
                    </c:if>

                </ul>
            </li>
            <li class="active">
                <a href="#"><i class="fa fa-flag"></i> <span class="nav-label">我要请假</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li class="active"><a href="/insertLeave">请假申请</a></li>
                    <li><a href="/selectLeave">请假记录</a></li>
                    <c:if test="${sessionScope.get('current_user').position.id != 1}">
                        <li><a href="/leaveapproval">请假审批</a></li>
                    </c:if>
                </ul>
            </li>
            <li class="active">
                <a href="/forum"><i class="fa fa-users"></i> <span class="nav-label">吐槽大会</span>  </a>
                <a href="/topic"><i class="fa fa-coffee"></i> <span class="nav-label">我要发帖</span>  </a>
            </li>


        </ul>

    </div>
</nav>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<nav class="navbar-default navbar-static-side" role="navigation">--%>
    <%--<div class="sidebar-collapse">--%>
        <%--<ul class="nav metismenu" id="side-menu">--%>
            <%--<li class="nav-header">--%>
                <%--<div class="dropdown profile-element">--%>
                    <%--<c:if test="${sessionScope.get('current_user').avatar != null}">--%>
                        <%--<span>   <img alt="image" class="img-circle" style="width: 50px;height: 50px" src="${sessionScope.get("current_user").avatar}" /> </span>--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${sessionScope.get('current_user').avatar == null}">--%>
                        <%--<span>   <img alt="image" class="img-circle" style="width: 50px;height: 50px" src="http://cdn.fanyank.com/Fm77jCT1O8fVcP-KqZFhMjXjErSh" /> </span>--%>
                    <%--</c:if>--%>



                    <%--<a data-toggle="dropdown" class="dropdown-toggle" href="#">--%>
                            <%--<span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${sessionScope.get("current_user").username}</strong>--%>
                             <%--</span> <span class="text-muted text-xs block">${sessionScope.get("current_user").position.position}<b class="caret"></b></span> </span> </a>--%>
                    <%--<ul class="dropdown-menu animated fadeInRight m-t-xs">--%>
                        <%--<li><a href="#">个人信息</a></li>--%>
                        <%--<li><a href="#">联系方式</a></li>--%>
                        <%--<li><a href="#">邮箱</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="/user/userExit">退出登录</a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="logo-element">--%>
                    <%--${sessionScope.get("current_user").username}--%>
                <%--</div>--%>
            <%--</li>--%>
            <%--&lt;%&ndash;<li class="active">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">签到中心</span> <span class="fa arrow"></span></a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<ul class="nav nav-second-level">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li class="active"><a href="/attendance">签到 <span class="label label-primary pull-right">记得签到呦</span></a></li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li><a href="/selectAttendance">签到记录</a></li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<c:if test="${sessionScope.get('current_user').position.id != 1}">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a href="#">签到设置 <span class="fa arrow"></span></a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<ul class="nav nav-third-level">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a href="/insertAttendanceStandard">签到标准设置</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a href="/selectAttendanceStandard">查看签到标准</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
            <%--<li class="active">--%>
                <%--<a href="#"><i class="fa fa-user"></i> <span class="nav-label">个人管理</span> <span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li><a href="/attendance">签到</a></li>--%>
                    <%--<li class="active"><a href="/personal_message">个人信息管理</a></li>--%>
                    <%--<li><a href="/attendance">投递简历管理</a></li>--%>
                    <%--&lt;%&ndash;<li><a href="/message">修改资料</a></li>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<li><a href="/user/updatePasswords">修改密码</a></li>&ndash;%&gt;--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li class="active">--%>
                <%--<a href="#"><i class="fa fa-comments"></i> <span class="nav-label">商家管理</span> <span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li class="active"><a href="/newconference">商家资格审核</a></li>--%>
                    <%--<c:if test="${sessionScope.get('current_user').position.id != 1}">--%>
                        <%--<li><a href="/conference/manager">商家上架审核</a></li>--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${sessionScope.get('current_user').currentConferenceApplyId != null}">--%>
                        <%--<li><a href="/conference/result?id=${sessionScope.get('current_user').currentConferenceApplyId}">审批状态</a></li>--%>
                    <%--</c:if>--%>

                <%--</ul>--%>
            <%--</li>--%>
            <%--<li class="active">--%>
                <%--<a href="#"><i class="fa fa-chevron-circle-up"></i> <span class="nav-label">订单管理</span> <span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li class="active"><a href="/position/up">未付款订单</a></li>--%>
                    <%--<c:if test="${sessionScope.get('current_user').position.id == 3}">--%>
                        <%--<li><a href="/position/applyinfo/boss">代付款订单</a></li>--%>
                        <%--<li><a href="/position/control">退款售后</a></li>--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${sessionScope.get('current_user').position.id == 2}">--%>
                        <%--<li><a href="/position/applyinfo/manager">订单查询</a></li>--%>
                        <%--<li><a href="/position/control">退款售后</a></li>--%>
                    <%--</c:if>--%>

                    <%--<c:if test="${sessionScope.get('current_user').currentPositionApplyId != null}">--%>
                        <%--<li><a href="/position/afterapply?id=${sessionScope.get('current_user').currentPositionApplyId}">申请状态</a></li>--%>
                    <%--</c:if>--%>

                <%--</ul>--%>
            <%--</li>--%>
            <%--<li class="active">--%>
                <%--<a href="#"><i class="fa fa-flag"></i> <span class="nav-label">财务统计</span> <span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li class="active"><a href="/insertLeave">成交量统计</a></li>--%>
                    <%--<li><a href="/selectLeave">退款统计</a></li>--%>
                    <%--<c:if test="${sessionScope.get('current_user').position.id != 1}">--%>
                        <%--<li><a href="/leaveapproval">盈利统计</a></li>--%>
                    <%--</c:if>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li class="active">--%>
                <%--<a href="/forum"><i class="fa fa-users"></i> <span class="nav-label">会员管理</span>  </a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li class="active"><a href="/insertLeave">会员信息</a></li>--%>
                    <%--<li><a href="/selectLeave">会员等级</a></li>--%>
                    <%--<li><a href="/leaveapproval">优惠设置</a></li>--%>
                    <%--<li><a href="/leaveapproval">积分管理</a></li>--%>

                <%--</ul>--%>
                <%--<a href="/topic"><i class="fa fa-coffee"></i> <span class="nav-label">客服管理</span>  </a>--%>
            <%--</li>--%>


        <%--</ul>--%>

    <%--</div>--%>
<%--</nav>--%>
