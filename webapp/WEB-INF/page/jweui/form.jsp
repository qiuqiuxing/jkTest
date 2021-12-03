<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="wui" tagdir="/WEB-INF/tags/jweui"%>
<html>
<head>
    <%@ include file="inc.jsp" %>
    <title>表单一些组件</title>
</head>
<body>
<wui:form id="form1">
    <wui:panel id="panl1" key="输入框">
        <wui:text id="aac001" key="个人编号" required="true" maxLength="10"/>
        <wui:text id="email" key="邮件" validType="email"/>
        <wui:text id="aac002" key="身份证脱敏处理" value="51162119920129257X" desensitization="idCard" readonly="true"/>
        <wui:textarea id="wby" key="文本域" rows="3" maxLength="200"/>
        <wui:selectInput id="yab003" key="下拉选" collection="YAB003_AB" filter="510199" beforeClose="fnBeforeYab003" onselect="fnSelectYab003"/>
        <wui:selectInput id="aac004" key="js动态设置select" beforeClose="fnBeforeAac004" onselect="fnSelectAac004"/>
        <wui:switchButton id="switch1" key="开关"/>
        <wui:date id="date" key="日期" start="2020-01-01" end="2022-01-01"/>
        <wui:imgUploader id="files" key="请上传图片"/>
        <wui:buttonLayout>
            <wui:button id="sumBtn" key="提交" onclick="fnSave()"/>
        </wui:buttonLayout>
    </wui:panel>
</wui:form>
</body>
<script type="text/javascript">
    $(function(){
        Base.init();
        Base.setSelectInputList("aac004", [{'id':'01','name':'男'},{'id':'02','name':'女'}]);
        //设置旧input值，方便后续Base.checkInputChange判断
        Base.setOldInputValue();
        // console.log(Base.setOldInputValue());
    });
    function fnBeforeYab003(id,name){
        if(id=="510104"){
            $.toast("不能选锦江区", "cancel");
            return false;
        }
    }
    function fnBeforeAac004(id,name){
        if(id=="01"){
            $.toast("不能选男", "cancel");
            return false;
        }
    }
    function fnSelectAac004(id,name){
        console.log(id, name);
    }
    function fnSelectYab003(id,name){
        console.log(id, name);
    }
    function fnSave(){
        Base.submit("form1",Base.serverPath+"/save/saveDemo",null,null,true,function(data){
            console.log(data);
            Base.setDisabled("sumBtn");
        });
    }
</script>
</html>
