<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%--@doc--%>
<%@tag description='tab页，只能放在tabs容器内' display-name='tab' %>

<%@attribute name='id' required="true" description='组件id' type='java.lang.String' %>
<%@attribute name='key' required="true" description='组件的label标签' type='java.lang.String' %>
<%@attribute name='cssClass' description='给该组件添加自定义样式class，如:cssClass="no-padding"' type='java.lang.String' %>
<%@attribute name='cssStyle' description='给该组件添加自定义样式，如:cssStyle="padding-top:10px"' type='java.lang.String' %>
<%@attribute name='selected' description='tab是否被选中' type='java.lang.String' %>
<%--@doc--%>
<%
	String cssClasses = "weui-navbar__item";
	if (StringUtils.isNotBlank(cssClass)) {
		cssClasses += (" " + cssClass);
	}
	if ("true".equals(selected)) {
		cssClasses += " weui-bar__item_on";
	}
	String cssStyles = "";
	if (StringUtils.isNotBlank(cssStyle)) {
		cssStyles += cssStyle;
	}
 %>

<div mtype="tab" link-field="<%=id%>" class="<%=cssClasses%>"
	 <%if(StringUtils.isNotBlank(cssStyle)){%>style="<%=cssStyles%>"<%}%> >
		<%=key%>
	<div id="<%=id%>" style="display: none" class="tab_panel">
		<jsp:doBody/>
	</div>
</div>