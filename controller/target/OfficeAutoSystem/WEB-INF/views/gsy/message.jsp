<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/13
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改个人信息</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--come from index-->
    <link rel="stylesheet" href="/static/css/fyf/bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="/static/css/css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
    <link rel="stylesheet" href="/static/js/fyf/webuploader/webuploader.css">
    <script src="/static/js/fyf/jQuery2.2.3.js"></script>
</head>
<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/views/css/sidebar.jsp"/>
    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="/WEB-INF/views/css/topbar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>个人信息</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/index">首页</a>
                    </li>
                    <li class="active">
                        个人信息设置
                    </li>
                    <li class="active">
                        <strong>修改个人信息</strong>
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
                        <div class="ibox-title">
                            <h5>修改个人信息</h5>
                        </div>
                        <div class="ibox-content">
                            <form:form modelAttribute="user" action="/updateMessage" method="post" class="form-horizontal">
                                <div class="form-group"><label class="col-sm-2 control-label">头像</label>
                                    <div class="col-sm-9">

                                        <div class="col-sm-9">
                                            <c:if test ="${not empty user.avatar}">
                                                <img class="avatar2" style="width: 150px;height: 150px" src ="${user.avatar}" alt="">
                                            </c:if>
                                            <c:if test ="${empty user.avatar }">
                                            <img class="avatar2" style="width: 100px;height: 100px" src ="http://cdn.fanyank.com/Fm77jCT1O8fVcP-KqZFhMjXjErSh" alt="">
                                            </c:if>

                                        </div>
                                        <div class="col-sm-3" style="padding-top:160px;padding-left:50px;" id="picker">上传新头像</div>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">姓名</label>

                                    <div class="col-sm-9"><form:input path="username"  disabled="true" value="${requestScope.user.username}" class="form-control"/></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">手机号</label>
                                    <div class="col-sm-9"><form:input path="phoneNumber" id="phoneNumber" value="${requestScope.user.phoneNumber}" onblur="checkP()" type="text" class="form-control"/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">邮箱</label>

                                    <div class="col-sm-9"><form:input path="email" id="email" value="${requestScope.user.email}" onblur="checkE()" class="form-control"/></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">部门</label>

                                    <div class="col-sm-9"><form:input path="department" disabled="true" value="${requestScope.user.department.department}"  class="form-control"/></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-lg-2 control-label">职位</label>

                                    <div class="col-lg-9"><form:input path="position" disabled="true" value="${requestScope.user.position.position}"  class="form-control"/></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-lg-2 control-label">办公电话</label>

                                    <div class="col-lg-9"><form:input path="officalNumber" id="officalNumber" value="${requestScope.user.officalNumber}" onblur="checkO()" class="form-control" /></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">邮编</label>
                                    <div class="col-sm-9">
                                        <form:input path="postcode" id="postcode" value="${requestScope.user.postcode}" onblur="checkPo()" class="form-control"/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">办公地址</label>
                                    <div class="col-sm-9">
                                        <form:input path="officalAddress" id="officalAddress" value="${requestScope.user.officalAddress}" onblur="checkOa()" class="form-control"/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">个人简介</label>
                                    <div class="col-sm-9">
                                        <form:input path="desc" id="desc" value="${requestScope.user.desc}" onblur="checkD()" class="form-control"/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">备注</label>
                                    <div class="col-sm-9"><form:input path="remark" id="remark" value="${requestScope.user.remark}" onblur="checkR()" class="form-control"/></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-5">
                                        <button class="btn btn-white" type="submit">取消</button>
                                        <button class="btn btn-primary" type="submit">保存</button>
                                    </div>
                                </div>
                            </form:form>
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
<!-- Peity -->
<script src="/static/js/gsy/js/plugins/peity/jquery.peity.min.js"></script>
<!-- Peity -->
<script src="/static/js/gsy/js/demo/peity-demo.js"></script>
<!-- Input Mask-->
<script src="/static/js/gsy/js/plugins/jasny/jasny-bootstrap.min.js"></script>
<script src="/static/js/gsy/message.js"></script>
<script src="/static/js/fyf/webuploader/webuploader.min.js"></script>
<script>
    $(function () {
        var uploader = WebUploader.create({

            // swf文件路径
            swf: '/js/Uploader.swf',
            // 文件接收服务端。
            server: 'http://up-z1.qiniu.com/',
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker',
            formData:{'token':'${token}'},
            fileVal:'file',
            // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false,
            auto:true,
            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            },
            //限制文件大小为100k以内
            fileSingleSizeLimit:100*1024
        });

        uploader.on("uploadProgress",function(file){
            $(".webuploader-pick").text("头像上传中...").attr("disabled","disabled");
        });

        //文件上传失败时调用
        uploader.on("uploadError",function(file){
            alert("上传服务器错误");
        });

        //无论上传成功还是失败都调用
        uploader.on("uploadComplete",function(){
            $(".webuploader-pick").text("上传新头像").removeAttr("disabled");
        });


        uploader.on("uploadSuccess",function(file,result){
            var key = result.file_path;
            console.log("key->" + key);
            $.post("/updateAvatar",{"key":key},function () {
                $(".avatar2").attr("src",key+"-avatar");
                uploader.removeFile(file,true);
            });

        });
    })
</script>
</body>
</html>
