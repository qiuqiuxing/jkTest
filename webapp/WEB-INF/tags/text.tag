<%@tag pageEncoding="UTF-8"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%-- doc --%>
<%@tag description="text" display-name="文本输入框"%>
<%@attribute name="id" required="true" type="java.lang.String" description="页面中唯一标志符"%>
<%@attribute name="key" required="true" type="java.lang.String" description="名称"%>
<%@attribute name="value" type="java.lang.String" description="组件值"%>
<%@attribute name="required" type="java.lang.String" description="是否必填"%>
<%@attribute name='labelWidth' description='label占的宽度，如labelWidth="120"' type='java.lang.String' %>
<%@attribute name='labelStyle' description='label自定义样式' type='java.lang.String' %>
<%@attribute name="onblur" type="java.lang.String" description="失去焦点事件处理函数"%>
<%@attribute name="onchange" type="java.lang.String" description="值发生改变事件处理函数"%>
<%@attribute name="onclick" type="java.lang.String" description="点击事件处理函数"%>
<%@attribute name="onfocus" type="java.lang.String" description="获的焦点事件处理函数"%>
<%@attribute name="placeholder" type="java.lang.String" description="获的焦点事件处理函数"%>
<%@attribute name="type" type="java.lang.String"
	description="输入类型，text,password,email,url,number,range,date, month, week, time, datetime, datetime-local,color"%>
<%@attribute name="validType" type="java.lang.String" description="验证类型，idcard，mobile，zipcode，email, url, chinese, ip, integer"%>
<%@attribute name="pattern" type="java.lang.String" description="输入验证正则表达式"%>
<%@attribute name="usedefaultplaceholder" type="java.lang.String" description="是否使用默认的placeholder，默认true"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="readonly" type="java.lang.String" description="是否只读，默认false"%>
<%@attribute name="disabled" type="java.lang.String" description="是否禁用，默认false"%>
<%@attribute name="emptyTips" type="java.lang.String" description="为空时校验提示信息"%>
<%@attribute name="notMatchTips" type="java.lang.String" description="不满足正则表达式校验提示信息"%>
<%@attribute name="minLength" type="java.lang.String" description="允许输入的最小长度"%>
<%@attribute name="maxLength" type="java.lang.String" description="允许输入的最大长度"%>
<%@attribute name="minLengthTips" type="java.lang.String" description="不满足最小长度的提示信息"%>
<%@attribute name="maxLengthTips" type="java.lang.String" description="不满足最大长度的提示信息"%>
<%@attribute name="desensitization" type="java.lang.String" description="脱敏处理类型,姓名(name),银行账号(bank),身份证(idCard),邮箱地址(email),手机号码(phone),邮编(zipCode)"%>
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
	if (StringUtils.isBlank(notMatchTips)) {
		notMatchTips = "请输入正确的" + key;
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
	//校验规则，对应Base.regexp()
	if(StringUtils.isNotBlank(validType)){
		pattern = "REG_" + validType;
	}
	//是否需要强制校验
	boolean isValidate = false;
	if (!"true".equals(required) && StringUtils.isNotBlank(pattern)) {
		isValidate = true;
	}
	String labelStyles = "";
	if(StringUtils.isNotBlank(labelWidth)){
		labelStyles += "width:" + labelWidth + ";";
	}
	if(StringUtils.isNotBlank(labelStyle)){
		labelStyles += labelStyle;
	}
%>
<%-- doc --%>
<div id="<%=id%>" mtype="text" class="<%=cssClass%>" <%if ("false".equals(display)) {%> style="display: none;" <%}%>
		<%if (StringUtils.isNotBlank(desensitization)){%> desensitization = "<%=desensitization%>"<%}%>>
	<div class="weui-cell__hd">
            <label <%if (StringUtils.isNotBlank(labelStyles)) {%> style="<%=labelStyles%>" <%}%> class="weui-label" for="<%=id%>_input">
			<span class="weui-required" <%if ("true".equals(required)) {%> style="color: red;" <%} else {%>
				style="color: red;display: none;" <%}%>>*</span>
			<%=key%>
		</label>
	</div>
	<div class="weui-cell__bd weui-flex">
		<%if (StringUtils.isNotBlank(desensitization)) {%>
		<input id="<%=id%>_input_dest" class="weui-input" readonly="true"/>
		<%}%>
		<input id="<%=id%>_input" name="<%=id%>" class="weui-input" key=<%=key%> <%if (StringUtils.isNotBlank(desensitization)) {%> style="display:none;" <%}%>
			<%if (StringUtils.isNotBlank(placeholder)) {%> placeholder="<%=placeholder%>" <%}%>
				<%if (isValidate) {%> required="onlycheck" <%}%>
			<%if (StringUtils.isNotBlank(type)) {%> type="<%=type%>" <%}%> <%if (StringUtils.isNotBlank(pattern)) {%>
			pattern="<%=pattern%>" <%}%> <%if (StringUtils.isNotBlank(onblur)) {%> onblur="<%=onblur%>" <%}%>
			<%if (StringUtils.isNotBlank(onchange)) {%> onchange="<%=onchange%>" <%}%> <%if (StringUtils.isNotBlank(onclick)) {%>
			onclick="<%=onclick%>" <%}%> <%if (StringUtils.isNotBlank(onfocus)) {%> onclick="<%=onfocus%>" <%}%>
			<%if ("true".equals(required)) {%> required="<%=required%>" <%}%> <%if ("true".equals(readonly)) {%>
			readonly="<%=readonly%>" <%}%> <%if ("true".equals(disabled)) {%> disabled="<%=disabled%>" <%}%>
			<%if (StringUtils.isNotBlank(value)) {%> value="<%=value%>" <%}%> <%if (StringUtils.isNotBlank(emptyTips)) {%>
			emptyTips="<%=emptyTips%>" <%}%> <%if (StringUtils.isNotBlank(notMatchTips)) {%> notMatchTips="<%=notMatchTips%>"
			<%}%> <%if (StringUtils.isNotBlank(maxLength)) {%> maxLength="<%=maxLength%>" <%}%>
			<%if (StringUtils.isNotBlank(minLength)) {%> minLength="<%=minLength%>" <%}%>
			<%if (StringUtils.isNotBlank(minLengthTips)) {%> minLengthTips="<%=minLengthTips%>" <%}%>
			<%if (StringUtils.isNotBlank(maxLengthTips)) {%> maxLengthTips="<%=maxLengthTips%>" <%}%> />
		<%--
		<button id="<%=id%>_input_clear" class="weui-btn_reset weui-btn_icon weui-btn_input-clear">
			<i class="weui-icon-clear"></i>
		</button>
		 --%>
	</div>
</div>
<script type="text/javascript">
<%if(StringUtils.isNotBlank(value) && StringUtils.isNotBlank(desensitization)){%>
	var value_dest = Base.desensitization('<%=value%>','<%=desensitization%>');
	$("#<%=id%>_input_dest").val(value_dest);
<%}%>
</script>
