<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<h1 style="text-align: center;">Hello World WebSocket Client</h1>

<br>

<div style="text-align: center;">
    <form action="">
        <input onclick="send_message()" value="Send" type="button">
        <input id="textID" name="message" value="Hello WebSocket!" type="text"><br>
    </form>
</div>
<div id="output"></div>

<script src="/static/js/fyf/jQuery2.2.3.js"></script>


</body>
</html>