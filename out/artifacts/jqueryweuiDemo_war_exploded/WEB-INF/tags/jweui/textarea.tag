<%@tag pageEncoding="UTF-8"%>
<%@tag import="java.util.Map"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%-- doc --%>
<%@tag description="text" display-name="文本输入框"%>
<%@attribute name="id" required="true" type="java.lang.String" description="页面中唯一标志符"%>
<%@attribute name="key" required="true" type="java.lang.String" description="名称"%>
<%@attribute name="value" type="java.lang.String" description="组件值"%>
<%@attribute name="required" type="java.lang.String" description="是否必填"%>
<%@attribute name="onblur" type="java.lang.String" description="失去焦点事件处理函数"%>
<%@attribute name="onchange" type="java.lang.String" description="值发生改变事件处理函数"%>
<%@attribute name="onclick" type="java.lang.String" description="点击事件处理函数"%>
<%@attribute name="onfocus" type="java.lang.String" description="获的焦点事件处理函数"%>
<%@attribute name="placeholder" type="java.lang.String" description="获的焦点事件处理函数"%>
<%@attribute name="pattern" type="java.lang.String" description="输入验证正则表达式"%>
<%@attribute name="usedefaultplaceholder" type="java.lang.String" description="是否使用默认的placeholder，默认true"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="readonly" type="java.lang.String" description="是否只读，默认false"%>
<%@attribute name="disabled" type="java.lang.String" description="是否禁用，默认false"%>
<%@attribute name="emptyTips" type="java.lang.String" description="为空时校验提示信息"%>
<%@attribute name="minLength" type="java.lang.String" description="允许输入的最小长度"%>
<%@attribute name="maxLength" type="java.lang.String" description="允许输入的最大长度"%>
<%@attribute name="minLengthTips" type="java.lang.String" description="不满足最小长度的提示信息"%>
<%@attribute name="maxLengthTips" type="java.lang.String" description="不满足最大长度的提示信息"%>
<%@attribute name="rows" type="java.lang.String" description="展示行数，默认3"%>
<%
	if(StringUtils.isBlank(usedefaultplaceholder)){
		usedefaultplaceholder = "true";
	}
	if (StringUtils.isBlank(placeholder) && "true".equals(usedefaultplaceholder)) {
		placeholder = "请输入" + key;
	}
	if (StringUtils.isBlank(emptyTips)) {
		emptyTips = "请输入" + key;
	}
	if (StringUtils.isBlank(minLengthTips)) {
		minLengthTips = key + "的最小长度为" + minLength;
	}
	if (StringUtils.isBlank(maxLengthTips)) {
		maxLengthTips = key + "的最大长度为" + maxLength;
	}
	String cssClass = "weui-cell weui-cell_active";
	if ("true".equals(readonly)) {
		cssClass += " weui-cell_readonly";
	}
	if ("true".equals(disabled)) {
		cssClass += " weui-cell_disabled";
	}
	if (StringUtils.isBlank(rows)) {
		rows = "3";
	}
%>
<%-- doc --%>
<div id="<%=id%>" mtype="textarea" class="<%=cssClass%>" <%if ("false".equals(display)) {%> style="display: none;" <%}%>>
	<div class="weui-cell__hd">
		<label class="weui-label">
			<span class="weui-required" <%if ("true".equals(required)) {%> style="color: red;" <%} else {%>
				style="color: red;display: none;" <%}%>>*</span>
			<%=key%>
		</label>
	</div>
	<div class="weui-cell__bd">
		<textarea id="<%=id%>_input" name="<%=id%>" class="weui-textarea" key="<%=key%>" onkeyup="textarea(this);"
			<%if (StringUtils.isNotBlank(placeholder)) {%> placeholder="<%=placeholder%>" <%}%>
			 <%if (StringUtils.isNotBlank(pattern)) {%>
			pattern="<%=pattern%>" <%}%> <%if (StringUtils.isNotBlank(onblur)) {%> onblur="<%=onblur%>" <%}%>
			<%if (StringUtils.isNotBlank(onchange)) {%> onchange="<%=onblur%>" <%}%> <%if (StringUtils.isNotBlank(onclick)) {%>
			onclick="<%=onclick%>" <%}%> <%if (StringUtils.isNotBlank(onfocus)) {%> onclick="<%=onfocus%>" <%}%>
			<%if ("true".equals(required)) {%> required="<%=required%>" <%}%> <%if ("true".equals(readonly)) {%>
			readonly="<%=readonly%>" <%}%> <%if ("true".equals(disabled)) {%> disabled="<%=disabled%>" <%}%>
			<%if (StringUtils.isNotBlank(emptyTips)) {%> emptyTips="<%=emptyTips%>" <%}%>
			<%if (StringUtils.isNotBlank(maxLength)) {%> maxLength="<%=maxLength%>" <%}%>
			<%if (StringUtils.isNotBlank(minLength)) {%> minLength="<%=minLength%>" <%}%>
			<%if (StringUtils.isNotBlank(minLengthTips)) {%> minLengthTips="<%=minLengthTips%>" <%}%>
			<%if (StringUtils.isNotBlank(maxLengthTips)) {%> maxLengthTips="<%=maxLengthTips%>" <%}%> 
			rows="<%=rows%>"><%if (StringUtils.isNotBlank(value)) {%><%=value%><%}%></textarea>
		<%if(StringUtils.isNotBlank(maxLength)){%>
		<div class="weui-textarea-counter"><span>0</span>/<i><%=maxLength%></i></div>
		<%}%>
	</div>
</div>

<script>

</script>
