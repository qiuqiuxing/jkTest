<%@tag pageEncoding="UTF-8"%>
<%@tag import="java.util.Map"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%-- doc --%>
<%@tag description="buttonLayout" display-name="按钮容器"%>
<%@attribute name="id" type="java.lang.String" description="页面中唯一标志符"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="cssClass" type="java.lang.String" description="附加class样式"%>
<%@attribute name="cssStyle" type="java.lang.String" description="附加css样式"%>
<%@attribute name="bottom" type="java.lang.String" description="是否固定在屏幕底部"%>
<%-- doc --%>
<%
	if (StringUtils.isNotBlank(cssClass)) {
		cssClass = "button-sp-area " + cssClass;
	} else {
		cssClass = "button-sp-area";
	}
	if (StringUtils.isNotBlank(cssStyle)) {
		cssStyle = "padding: 24px;text-align: center;" + cssStyle;
	} else {
		cssStyle = "padding: 24px;text-align: center;";
	}
	if("true".equals(bottom)){
		cssStyle +="position: fixed;bottom: 0;width:88%;background: white";
	}
	if ("false".equals(display)) {
		cssStyle += "display: none;";
	}
%>
<div id="<%=id == null ? "" : id%>" class="<%=cssClass%>" style="<%=cssStyle%>">
	<jsp:doBody />
</div>

