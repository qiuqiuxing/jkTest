<%@tag pageEncoding="UTF-8"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%-- doc --%>
<%@tag description="switchButton" display-name="开关按钮"%>
<%@attribute name="id" type="java.lang.String" required="true" description="页面中唯一标志符"%>
<%@attribute name="key" type="java.lang.String" required="true" description="面板标题"%>
<%@attribute name='labelWidth' description='label占的宽度，如labelWidth="120"' type='java.lang.String' %>
<%@attribute name='labelStyle' description='label自定义样式' type='java.lang.String' %>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="cssClass" type="java.lang.String" description="自定义样式"%>
<%@attribute name="cssStyle" type="java.lang.String" description="自定义样式"%>
<%@attribute name="onchange" type="java.lang.String" description="值发生改变事件处理函数,如fnChange()"%>
<%-- doc --%>
<%
	String cssClasses = "weui-cell weui-cell_active weui-cell_switch";
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
	String labelStyles = "";
	if(StringUtils.isNotBlank(labelWidth)){
		labelStyles += "width:" + labelWidth + ";";
	}
	if(StringUtils.isNotBlank(labelStyle)){
		labelStyles += labelStyle;
	}
%>
<div id="<%=id%>" mtype="switch" class="<%=cssClasses%>" style="<%=cssStyles%>">
	<div class="weui-cell__bd">
		<label class="weui-label" <%if (StringUtils.isNotBlank(labelStyles)) {%> style="<%=labelStyles%>" <%}%>><%=key%></label>
	</div>
	<div class="weui-cell__ft">
		<input id="<%=id%>_input" name="<%=id%>" class="weui-switch" type="checkbox"
			<%if (StringUtils.isNotBlank(onchange)) {%> onchange="<%=onchange%>" <%}%>>
	</div>
</div>

