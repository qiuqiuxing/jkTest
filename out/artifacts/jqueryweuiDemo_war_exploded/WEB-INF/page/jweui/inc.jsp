<%@page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    /* String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
     */
    //正式
//    String basePath = "https://" + request.getServerName() + ":" + request.getServerPort() + path ;
    //本地
    String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + path ;
    request.setAttribute("basePath", basePath);
%>
<script>
    var Base = {
        "serverPath": "<%=basePath%>"
    };
</script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<meta name="mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" href="${basePath}/static/common/jqueryWeui/css/weui.css">
<link rel="stylesheet" href="${basePath}/static/common/jqueryWeui/css/weuix.css">
<script type="text/javascript" src="${basePath}/static/common/jqueryWeui/js/zepto.min.js"></script>
<script type="text/javascript" src="${basePath}/static/common/jqueryWeui/js/zepto.weui.js"></script>
<script type="text/javascript" src="${basePath}/static/common/jqueryWeui/js/lrz.min.js"></script>
<script type="text/javascript" src="${basePath}/static/common/jqueryWeui/js/wui.base.js"></script>
<%--调式工具--%>
<script type="text/javascript" src="${basePath}/static/common/eruda.js"></script>
<%--<style>
	input {
		text-align: right;
	}
</style>--%>
