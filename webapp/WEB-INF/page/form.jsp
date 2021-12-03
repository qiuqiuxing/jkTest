<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="wui" tagdir="/WEB-INF/tags"%>
<html>
<head>
    <%@ include file="inc.jsp" %>
    <title>表单一些组件</title>
</head>
<body>
<wui:form id="form1">
    <wui:panel key="输入框">
        <wui:text id="aac001" key="个人编号" required="true" maxLength="10"/>
        <wui:text id="email" key="邮件" validType="email"/>
        <wui:text id="aac002" key="身份证脱敏处理" value="51162119920129257X" desensitization="idCard" readonly="true"/>
        <wui:textarea id="wby" key="文本域" rows="3"/>
        <wui:selectInput id="yab003" key="下拉选" collection="YAB003_AB" filter="510199"/>
        <wui:selectInput id="aac004" key="js动态设置select" />
        <wui:switchButton id="switch1" key="开关"/>
        <wui:date id="date" key="日期" validNowTime="left"/>
        <wui:buttonLayout>
            <wui:button id="sumBtn" key="提交" onclick="fnSave()"/>
        </wui:buttonLayout>
    </wui:panel>


</wui:form>
</body>
<script type="text/javascript">
    $(function(){
        Base.init();
        Base.setSelectInputList("aac004", [{'value':'01','label':'男'},{'value':'01','label':'女'}]);
        //设置旧input值，方便后续Base.checkInputChange判断
        console.log(Base.setOldInputValue());
    });

    function fnSave(){
        console.log(Base.checkInputChange());
    }
</script>
</html>
