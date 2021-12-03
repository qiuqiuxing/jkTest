<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="../WEB-INF/page/inc.jsp" %>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <title>错误412</title>
    <style type="text/css">/*powderblue*/
        body{
            background-color: #FFFFFF;
            background-size: 100% 100%;
        }
    .child {
        width:300px;
        height:200px;
        margin:auto;
        position:absolute;
        left:50%;
        top:50%;
        margin-left: -150px;
        margin-top:-100px;
    }
    h2{
        color: white;
        text-align: center;
    }

    </style>
</head>
<body>
<div>
    <img id="show" src="<%=basePath%>/error/412.png" style="height: 40%; width: 100%"/>
    <div class="child">
        <h2>
            ${requestScope.s}
        </h2>
    </div>

</div>
</body>
</html>
