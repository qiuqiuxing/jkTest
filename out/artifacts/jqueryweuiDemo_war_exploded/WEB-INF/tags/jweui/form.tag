<%@tag pageEncoding="UTF-8"%>
<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%-- doc --%>
<%@tag description="form" display-name="form表单"%>
<%@attribute name="id" required="true" type="java.lang.String" description="页面中唯一标志符"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="cssClass" type="java.lang.String" description="自定义样式"%>
<%@attribute name="cssStyle" type="java.lang.String" description="自定义样式"%>
<%-- doc --%>
<%
	String cssClasses = "weui-cells weui-cells_form";
	if (StringUtils.isNotBlank(cssClass)) {
		cssClasses += (" " + cssClass);
	}
	String cssStyles = "";
	if (StringUtils.isNotBlank(cssStyle)) {
		cssStyles += cssStyle;
	}
	if ("false".equals(display)) {
		cssStyles += "display: none;";
	}
%>
<form id="<%=id%>" method="post" class="<%=cssClasses%>" style="<%=cssStyles%>">
	<jsp:doBody />
</form>

