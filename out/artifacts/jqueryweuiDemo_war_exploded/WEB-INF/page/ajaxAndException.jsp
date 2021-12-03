<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="wui" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <%@ include file="inc.jsp" %>
    <title>异步与异常测试</title>
</head>
<body>
<wui:form id="form1">
    <wui:text id="aac001" key="社保编号"/>
    <wui:buttonLayout>
        <wui:button id="sumBtn" key="提交" onclick="fnSave()"/>
    </wui:buttonLayout>
</wui:form>
</body>
<script type="text/javascript">
    $(function () {
        Base.init();
    });

    function fnSave() {
        Base.submit("form1","ajaxAndException!query.do",null,null,true,function(data){
            console.log(data);
        },function(errdata){
            console.log(errdata);
        });
    }
</script>
</html>
<%@ include file="/incfooter.jsp" %>