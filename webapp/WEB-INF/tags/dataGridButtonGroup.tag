<%@tag pageEncoding="UTF-8"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%-- doc --%>
<%@tag description="dataGridButtonGroup" display-name="数据表格按钮容器"%>
<%@attribute name="cssStyle" type="java.lang.String" description="自定义样式"%>
<%-- doc --%>
<%
	String cssStyles = "";
	if (StringUtils.isNotBlank(cssStyle)) {
		cssStyles += cssStyle;
	}
%>
<div class="opt-group" style="<%=cssStyles%>">
	<jsp:doBody />
</div>
