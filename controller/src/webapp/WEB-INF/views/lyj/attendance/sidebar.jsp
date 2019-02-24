<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
                             </span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">王昆</strong>
                             </span> <span class="text-muted text-xs block">经理 <b class="caret"></b></span> </span> </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a href="#">个人信息</a></li>
                        <li><a href="#">联系方式</a></li>
                        <li><a href="#">邮箱</a></li>
                        <li class="divider"></li>
                        <li><a href="">退出登录</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    IN+
                </div>
            </li>
            <li>
                <a href="/sign" id="sign"><i class="fa fa-th-large"></i> <span class="nav-label">签到</span> </a>
            </li>
            <li>
                <a href="/signout"><i class="fa fa-th-large"></i> <span class="nav-label">签退</span> </a>
            </li>
            <li>
                <a href="/selectAttendance"><i class="fa fa-th-large"></i> <span class="nav-label">签到记录</span> </a>
            </li>
            <li class="active">
                <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">签到设置</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="/insertAttendanceStandard">签到标准设置 </a></li>
                    <li><a href="/selectAttendanceStandard">查看签到标准</a></li>
                </ul>
            </li>
        </ul>

    </div>
</nav>
<script>

</script>
