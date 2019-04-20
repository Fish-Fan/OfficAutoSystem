<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--come from index-->
    <link rel="stylesheet" href="/static/css/fyf/bootstrap-3.3.5-dist/css/bootstrap.css">
    <link rel="stylesheet" href="/static/css/fyf/font-awesome/css/all.css">
    <link href="/static/js/css/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/static/css/css/animate.css" rel="stylesheet">
    <link href="/static/css/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/fyf/toastr.min.css">
    <link rel="stylesheet" href="/static/js/fyf/webuploader/webuploader.css">
    <link rel="stylesheet" href="/static/dist/css/layui.css">
    <link rel="stylesheet" href="/static/css/css/jsTree/style.min.css">
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
                            <i class="fas fa-file-word"></i>
                            <strong>jsTree</strong> 是jQuery插件，提供交互的树。它完全是免费的，开放源码，并在麻省理工学院的许可下发行。jsTree容易扩展、是主题化和可配置的，它支持HTML、JSON数据源和数据加载。
                            获得更多信息: <a href="http://www.jstree.com/" target="_blank">http://www.jstree.com/</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <p id="userRootFolderId" class="hidden" value="${userRootFolderId}"></p>
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>JSON例子</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="container">
                            <button id="add-file-btn">添加文件</button>
                        </div>
                        <div id="using_json"></div>

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
    <script src="/static/js/fyf/webuploader/webuploader.js"></script>

    <script src="/static/js/css/jstree.js"></script>
    <script src="/static/js/fyf/jstree_my.js"></script>
    <style>
        .jstree-open > .jstree-anchor > .fa-folder:before {
            content: "\f07c";
        }

        .jstree-default .jstree-icon.none {
            width: 0;
        }
    </style>

    <script>
        $(function () {
            function getTreeRef() {
                return $('#using_json').jstree(true);
            }

            <!--webuploader start-->
            var uploader = WebUploader.create({

                // swf文件路径
                swf: '/js/Uploader.swf',
                // 文件接收服务端。
                server: 'http://up-z1.qiniu.com/',
                // 选择文件的按钮。可选。
                // 内部根据当前运行是创建，可能是input元素，也可能是flash.
                pick: '#add-file-btn',
                formData:{'token':'${token}'},
                fileVal:'file',
                // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
                resize: false,
                auto:true,
                // 只允许选择图片文件。
                // accept: {
                //     title: 'Images',
                //     extensions: 'gif,jpg,jpeg,bmp,png',
                //     mimeTypes: 'image/*'
                // },
                //限制文件大小为100M以内
                fileSingleSizeLimit:1024*1024*100
            });

            uploader.on("uploadProgress",function(file){
                $(".webuploader-pick").text("文件上传中...").attr("disabled","disabled");
            });

            //文件上传失败时调用
            uploader.on("uploadError",function(file){
                alert("上传服务器错误");
            });

            //无论上传成功还是失败都调用
            uploader.on("uploadComplete",function(){
                $(".webuploader-pick").text("添加文件").removeAttr("disabled");
            });


            uploader.on("uploadSuccess",function(file,result){
                //从七牛获取回调信息
                var key = result.file_path;
                var text = result.name;
                var size = result.size;

                var fileObj = {
                    name: text,
                    type: getFileType(text),
                    folderId: null,
                    size: size,
                    foreignChain: key,
                    createTime: Date.now()
                };

                var tree = getTreeRef(),
                    selectedNode = tree.get_selected();
                //只能选择一个文件夹
                if(selectedNode.length != 1) { return false; }
                selectedNode = selectedNode[0];
                fileObj.folderId = selectedNode;

                //更新数据库
                $.ajax({
                    type: "POST",
                    url: "/file/createfile",
                    data: fileObj,
                    success: function(resp) {
                        JSON.stringify(resp);
                        tree.create_node(selectedNode,resp);
                    }
                });
                alert("上传成功");
            });

            uploader.on('beforeFileQueued',function (file) {
                var selectedNodes = getTreeRef().get_selected();
                if(selectedNodes.length != 1) {
                    alert("只能选择一个文件夹")
                    return false;
                } else {
                    var selectNode = getTreeRef().get_node(selectedNodes[0]);
                    if(selectNode.type != 'folder') {
                        alert("请选择一个文件夹进行上传")
                        return false;
                    } else {
                        return true;
                    }
                }
            });

            function getFileType(fileName) {
                var fileNameArr = fileName.split('.');
                return fileNameArr[fileNameArr.length-1];
            }
        });
    </script>
</body>
</html>
