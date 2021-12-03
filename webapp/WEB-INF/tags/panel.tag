<%@tag pageEncoding="UTF-8"%>
<%@tag import="java.util.Map"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%-- doc --%>
<%@tag description="panel" display-name="面板容器"%>
<%@attribute name="id" type="java.lang.String" description="页面中唯一标志符"%>
<%@attribute name="key" type="java.lang.String" description="面板标题"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="cssClass" type="java.lang.String" description="自定义样式"%>
<%@attribute name="cssStyle" type="java.lang.String" description="自定义样式"%>
<%-- doc --%>
<%
	String cssClasses = "weui-cells__group weui-cells__group_form";
	if (StringUtils.isNotBlank(cssClass)) {
		cssClasses += (" " + cssClass);
	}
	String cssStyles = "margin-top: 8px;";
	if (StringUtils.isNotBlank(cssStyle)) {
		cssStyles += cssStyle;
	}
	if ("false".equals(display)) {
		cssStyles += "display: none;";
	}
%>
<div id="<%=id == null ? "" : id%>" class="<%=cssClasses%>" style="<%=cssStyles%>">
	<div class="weui-cells__title"><%=key == null ? "" : key%></div>
	<div class="weui-cells">
		<jsp:doBody />
	</div>
</div>

