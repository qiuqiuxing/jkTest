<%@tag pageEncoding="UTF-8"%>
<%@tag import="java.util.Map"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%-- doc --%>
<%@tag description="dataGrid" display-name="数据表格"%>
<%@attribute name="id" required="true" type="java.lang.String" description="页面中唯一标志符"%>
<%@attribute name="rowId" required="true" type="java.lang.String" description="行数据唯一标识"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="cssStyle" type="java.lang.String" description="自定义样式"%>
<%-- doc --%>
<%
	if (StringUtils.isBlank(id)) {
		id = "datagrid";
	}
	String cssStyles = "";
	if (StringUtils.isNotBlank(cssStyle)) {
		cssStyles += cssStyle;
	}
	if ("false".equals(display)) {
		cssStyles += "display: none;";
	}
%>
<script type="text/javascript">
	opt_<%=id%> = {
		rowId:"<%=rowId%>",
		columns:[],
		buttons:[]
	};
</script>
<div id="<%=id%>" class="datagrid-content" style="<%=cssStyles%>">
	<jsp:doBody />
</div>
<div id="<%=id%>_nodata" class="nodata-content">
	<div class="nodata-img">
		<img alt="" src="${basePath }/static/common/weui/images/nodata.png">
	</div>
	<div class="nodata-text">没有符合条件的数据</div>
</div>
