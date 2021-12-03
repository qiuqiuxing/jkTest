<%@tag pageEncoding="UTF-8"%>
<%@tag import="java.util.Map"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%-- doc --%>
<%@tag description="button" display-name="按钮"%>
<%@attribute name="id" required="true" type="java.lang.String" description="页面中唯一标志符"%>
<%@attribute name="key" required="true" type="java.lang.String" description="名称"%>
<%@attribute name="onclick" type="java.lang.String" description="点击事件处理函数"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="disabled" type="java.lang.String" description="是否禁用，默认false"%>
<%@attribute name="size" type="java.lang.String" description="按钮大小，可选normal,line,mini，默认为normal"%>
<%@attribute name="type" type="java.lang.String" description="按钮类型，可选primary,default,warn，默认为primary"%>
<%@attribute name="cssClass" type="java.lang.String" description="自定义样式"%>
<%@attribute name="cssStyle" type="java.lang.String" description="自定义样式"%>
<%-- doc --%>
<%
	if (StringUtils.isBlank(size)) {
		size = "normal";
	}
	if (StringUtils.isBlank(type)) {
		type = "primary";
	}
	String cssClasses = "";
	if ("normal".equals(size)) {
		cssClasses += " weui-btn";
		if ("primary".equals(type)) {
			cssClasses += " weui-btn_primary";
		} else if ("default".equals(type)) {
			cssClasses += " weui-btn_default";
		} else {
			cssClasses += " weui-btn_warn";
		}
	} else if ("line".equals(size)) {
		cssClasses += " weui-btn_cell";
		if ("primary".equals(type)) {
			cssClasses += " weui-btn_cell-primary";
		} else if ("default".equals(type)) {
			cssClasses += " weui-btn_cell-default";
		} else {
			cssClasses += " weui-btn_cell-warn";
		}
	} else {
		cssClasses += " weui-btn weui-btn_mini";
		if ("primary".equals(type)) {
			cssClasses += " weui-btn_primary";
		} else if ("default".equals(type)) {
			cssClasses += " weui-btn_default";
		} else {
			cssClasses += " weui-btn_warn";
		}
	}
	if ("true".equals(disabled)) {
		cssClasses += " weui-btn_disabled";
	}
	String cssStyles = "margin-top: 15px;";
	if (StringUtils.isNotBlank(cssStyle)) {
		cssStyles += cssStyle;
	}
	if ("false".equals(display)) {
		cssStyles += "display: none;";
	}
%>
<button id="<%=id%>" type="button" class="<%=cssClasses%>" mtype="button" style="<%=cssStyles%>"
		<%if (StringUtils.isNotBlank(onclick)) {%> onclick="<%=onclick%>" <%}%>
		<%if ("true".equals(disabled)) {%> disabled="<%=disabled%>" <%}%>>
	<%=key%>
</button>
<script type="text/javascript">
/*$("#<%=id%>").tap(function(){
	var _this = $(this);
	if(_this.hasClass("weui-btn_disabled")){
		return false;
	}else{
		if(typeof <%=onclick%> === "function"){
			<%=onclick%>.call(this);
		}
	}
});*/
</script>
