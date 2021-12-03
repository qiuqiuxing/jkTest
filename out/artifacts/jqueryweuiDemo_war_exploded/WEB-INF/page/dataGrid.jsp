<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="wui" tagdir="/WEB-INF/tags"%>
<html>
<head>
    <%@ include file="inc.jsp" %>
    <title>dataGrid组件</title>
    <link rel="stylesheet" href="${basePath }/static/common/weui/weui/datagrid.css">
</head>
<body>
<wui:form id="form1">
    <wui:panel key="表格">
       <wui:dataGrid id="grid" rowId="aac001">
           <wui:dataGridItem id="aac001" key="个人编号"/>
           <wui:dataGridItem id="aac003" key="姓名"/>
           <wui:dataGridItem id="aac004" key="性别" collection="AAC004"/>
           <wui:dataGridButtonGroup>
               <wui:dataGridButton key="查看详情" onclick="alert(1)"/>
               <wui:dataGridButton key="撤销" onclick="alert(2)"/>
           </wui:dataGridButtonGroup>
       </wui:dataGrid>
    </wui:panel>

</wui:form>
</body>
<script type="text/javascript">
    $(function(){
        Base.init();
        Base.setGridData("grid", [{'aac001':'11111111','aac003':'测试1','aac004':'1'}
        ,{'aac001':'22222222','aac003':'测试2','aac004':'2'}
        ,{'aac001':'33333333','aac003':'测试3','aac004':'1'}]);
    });
</script>
</html>
