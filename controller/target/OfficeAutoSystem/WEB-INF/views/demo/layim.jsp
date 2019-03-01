<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>layim</title>
    <link rel="stylesheet" href="/static/dist/css/layui.css">
</head>
<body>

</body>
<script src="/static/dist/layui.js"></script>
<script>
    layui.use('layim', function(layim){
        //先来个客服模式压压精
        layim.config({
            init: {
              url: '/im/init',
              type: 'get'
            },
            brief: false //是否简约模式（如果true则不显示主面板）

        }).chat({
            name: '客服姐姐'
            ,type: 'friend'
            ,avatar: 'http://tp1.sinaimg.cn/5619439268/180/40030060651/1'
            ,id: -2
        });
    });
</script>
</html>
