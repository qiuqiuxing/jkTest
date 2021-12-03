<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="http://ide.cdhrss.chengdu.gov.cn/cdsiwx/">

    <meta charset="UTF-8">
    <title>解除本地绑卡</title>
    <%@ include file="../WEB-INF/page/inc.jsp" %>
    <meta name="viewport"
          content="initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="<%=basePath%>socialInquire/fonts/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>socialInquire/css/default.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>socialInquire/css/toast.css" media="all">
    <!--herf:表示本地路径   th:表示服务器路径-->
    <link rel="stylesheet" href="<%=basePath%>/statics/common/css/weui/weui.min.css">
</head>
<body>
<!--提示是否解绑-->
<div class="info-box">
    <div id="untyingCard" style="display: none">
        <div class="weui-mask"></div>
        <div class="weui-dialog">
            <div class="weui-dialog__hd"><strong class="weui-dialog__title">温馨提示</strong></div>
            <div class="weui-dialog__bd">您当前存在本地绑卡，如果不解除您当前本地绑卡业务，则无法进入当前系统，请您仔细考虑是否要解除您当前本地绑卡业务！</div>
            <div class="weui-dialog__ft">
                <a href="" class="weui-dialog__btn weui-dialog__btn_default" onclick="fnUntying()">确定</a>
                <%--如果取消则会回到404提示解绑页面--%>
                <a href="" class="weui-dialog__btn weui-dialog__btn_primary">取消</a>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>socialInquire/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>statics/common/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>statics/common/js/userServer.js"></script>
<script type="text/javascript" src="<%=basePath%>socialInquire/js/echarts.simple.min.js"></script>
<script type="text/javascript" src="<%=basePath%>socialInquire/js/collect-v2.js"></script>
<script type="text/javascript" src="<%=basePath%>socialInquire/js/utils.js"></script>
<script type="text/javascript" src="<%=basePath%>statics/common/js/weui/weui.min.js"></script>

<script type="text/javascript">

    var aac001;
    $(function () {
        aac001 = "${sessionScope.card_no}";//个人编码
        //调用接口解绑
        fnUntying();
    });

    /*查询账户余额*/
    function fnUntying(){
        $.ajax({
            type: 'post',
            url: '<%=basePath%>fwcUser/callJypt1',
            dataType:'json',
            data:{
                aac001:aac001,
                jybh:'cdsi0099014'
            },
            beforeSend: function(){
                window.showLoading();
            },
            success: function(data){

                if(data.code=="1"){
                    window.toast(data.message?data.message:"本地绑卡解除失败");
                    return;
                }
            },
            complete: function () {//完成响应
                window.closeLoading();
            },
            error : function() {
                window.toast('连接服务器失败');
            }
        });

    }

</script>
</html>
