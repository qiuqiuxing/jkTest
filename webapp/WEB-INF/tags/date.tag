<%@tag pageEncoding="UTF-8"%>
<%@tag import="java.util.Map"%>
<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%-- doc --%>
<%@tag description="date" display-name="日期选择框"%>
<%@attribute name="id" required="true" type="java.lang.String" description="页面中唯一标志符"%>
<%@attribute name="key" required="true" type="java.lang.String" description="名称"%>
<%@attribute name="value" type="java.lang.String" description="组件值"%>
<%@attribute name="required" type="java.lang.String" description="是否必填"%>
<%@attribute name="emptyTips" type="java.lang.String" description="为空时校验提示信息"%>
<%@attribute name="placeholder" type="java.lang.String" description="获的焦点事件处理函数"%>
<%@attribute name="start" type="java.lang.String" description="年份输入区间开始"%>
<%@attribute name="end" type="java.lang.String" description="年份输入区间结束"%>
<%@attribute name='validNowTime' type='java.lang.String' description='left/right,验证时间,left表示不能大于当前时间，right表示不能小于当前时间'%>
<%@attribute name="usedefaultplaceholder" type="java.lang.String" description="是否使用默认的placeholder，默认true"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="onselect" type="java.lang.String"
	description="选择回调函数，该函数返回false时将阻止设值,function selectCallback(value,obj){}"%>
<%@attribute name="readonly" type="java.lang.String" description="是否只读，默认false"%>
<%@attribute name="disabled" type="java.lang.String" description="是否禁用，默认false"%>
<%
	if(StringUtils.isBlank(usedefaultplaceholder)){
		usedefaultplaceholder = "true";
	}
	if (StringUtils.isBlank(placeholder) && "true".equals(usedefaultplaceholder)) {
		placeholder = "请选择" + key;
	}
	if (StringUtils.isBlank(emptyTips)) {
		emptyTips = "请选择" + key;
	}
	String cssClass = "weui-cell weui-cell_active weui-cell_access weui-cell_select weui-cell_select-after";
	if ("true".equals(readonly)) {
		cssClass += " weui-cell_readonly";
	}
	if ("true".equals(disabled)) {
		cssClass += " weui-cell_disabled";
	}
%>
<%-- doc --%>
<div id="<%=id%>" mtype="date" class="<%=cssClass%>" <%if ("false".equals(display)) {%> style="display: none;" <%}%>>
	<div class="weui-cell__hd">
		<label class="weui-label">
			<span class="weui-required" <%if ("true".equals(required)) {%> style="color: red;" <%} else {%>
				style="color: red;display: none;" <%}%>>*</span>
			<%=key%>
		</label>
	</div>
	<div class="weui-cell__bd" id="<%=id%>_showPicker">
		<input id="<%=id%>_DESC" class="weui-input" <%if (StringUtils.isNotBlank(placeholder)) {%>
			placeholder="<%=placeholder%>" <%}%> readonly="readonly" <%if (StringUtils.isNotBlank(value)) {%> value="<%=value%>"
			<%}%><%if ("true".equals(required)) {%> required="<%=required%>" <%}%> <%if (StringUtils.isNotBlank(emptyTips)) {%>emptyTips="<%=emptyTips%>" <%}%>/>
		<input id="<%=id%>_input" name="<%=id%>" type="hidden" class="weui-input" key=<%=key%> <%if ("true".equals(required)) {%>
			required="<%=required%>" <%}%><%if ("true".equals(readonly)) {%> readonly="<%=readonly%>" <%}%>
				<%if ("true".equals(disabled)){%> disabled="<%=disabled%>" <%}%> <%if (StringUtils.isNotBlank(placeholder)) {%>
			placeholder="<%=placeholder%>" <%}%> <%if (StringUtils.isNotBlank(value)) {%> value="<%=value%>" <%}%>
			   <%if (StringUtils.isNotBlank(emptyTips)) {%>emptyTips="<%=emptyTips%>" <%}%>/>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$('#<%=id%>_showPicker').click(function() {
		var _desc = $('#<%=id%>_DESC');
		var _input = $('#<%=id%>_input');
		if("true" == _input.attr("readonly") || "true" == _input.attr("disabled")){
			return false;
		}
		weui.datePicker({
            <%if (StringUtils.isNotBlank(validNowTime) && "right".equals(validNowTime)){%>
            	start: new Date().getFullYear(),
            <%}%>
            <%if (StringUtils.isNotBlank(validNowTime) && "left".equals(validNowTime)){%>
            	end: new Date().getFullYear(),
            <%}%>
			<%if (StringUtils.isNotBlank(start)) {%>
				start : parseInt('<%=start%>'),
			<%} else {%>
				start : 1900,
			<%}%>
			<%if (StringUtils.isNotBlank(end)) {%>
				end : parseInt('<%=end%>'),
			<%} else {%>
				end : new Date().getFullYear(),
			<%}%>
			onChange : function(result) {
				// console.log(result);
                let year = result[0].value;
                let month = ("00" + result[1].value).slice(-2);
                let day = ("00" + result[2].value).slice(-2);
                let nowdate = Base.getNowDateStr("");
                <%if (StringUtils.isNotBlank(validNowTime) && "right".equals(validNowTime)){%>
                if ((year + month + day) < nowdate) {
                    Base.topTips("不能小于当前时间：" + nowdate, 1000);
                }
                <%}%>
                <%if (StringUtils.isNotBlank(validNowTime) && "left".equals(validNowTime)){%>
                if ((year + month + day) > nowdate) {
                    Base.topTips("不能大于当前时间：" + nowdate, 1000);
                }
                <%}%>
			},
			onConfirm : function(result) {
				let year = result[0].value;
				let month = ("00" + result[1].value).slice(-2);
				let day = ("00" + result[2].value).slice(-2);
				let d_value = year + "-" + month + "-" + day;
                let nowdate = Base.getNowDateStr("");
                <%if (StringUtils.isNotBlank(validNowTime) && "right".equals(validNowTime)){%>
					if ((year + month + day) < nowdate) {
						Base.alert("不能小于当前时间："+nowdate, "warn");
						return;
					}
                <%}%>
				<%if (StringUtils.isNotBlank(validNowTime) && "left".equals(validNowTime)){%>
                	if ((year + month + day) > nowdate) {
						Base.alert("不能大于当前时间："+nowdate, "warn");
						return;
                	}
                <%}%>
                _input.val(d_value);
                _desc.val(d_value);
                //设置值后隐藏校验错误提示
                weui.form.hideErrorTips(document.getElementById('<%=id%>_input'));
				<%if (StringUtils.isNotBlank(onselect)) {%>
					if(typeof <%=onselect%> === 'function'){
						let ret = <%=onselect%>.call(this, d_value,$('#<%=id%>')[0]);
						if(ret == false){
                            _input.val("");
                            _desc.val("");
							return false;
						}
					}
				<%}%>
			},
			title : '选择<%=key%>',
			id : '<%=id%>_showPicker'
		});
	});
});
</script>
