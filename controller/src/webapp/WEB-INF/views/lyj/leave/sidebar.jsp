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
                <a href="/insertLeave"><i class="fa fa-th-large"></i> <span class="nav-label">请假申请</span> </a>
            </li>
            <li>
                <a href="/selectLeave"><i class="fa fa-th-large"></i> <span class="nav-label">请假记录</span> </a>
            </li>
            <%--<li>--%>
            <%--<a href="#"><i class="fa fa-pie-chart"></i> <span class="nav-label">会议申请</span>  </a>--%>
            <%--</li>--%>
            <li>
                <a href="/leaveapproval"><i class="fa fa-pie-chart"></i> <span class="nav-label">请假审批</span>  </a>
            </li>


        </ul>

    </div>
</nav>
