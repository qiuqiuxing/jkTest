<%@tag pageEncoding="UTF-8"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%@ tag import="com.alibaba.fastjson.JSONArray" %>
<%@ tag import="com.alibaba.fastjson.JSON" %>
<%@ tag import="java.util.Iterator" %>
<%@ tag import="com.alibaba.fastjson.JSONObject" %>
<%@ tag import="com.yinhai.base.appcode.CodeTableLocator" %>
<%-- doc --%>
<%@tag description="selectInput" display-name="下拉选择框"%>
<%@attribute name="id" required="true" type="java.lang.String" description="页面中唯一标志符"%>
<%@attribute name="key" required="true" type="java.lang.String" description="名称"%>
<%@attribute name="value" type="java.lang.String" description="组件值"%>
<%@attribute name="required" type="java.lang.String" description="是否必填"%>
<%@attribute name="placeholder" type="java.lang.String" description="占位提示信息"%>
<%@attribute name="data" type="java.lang.String"
	description="列表数据，[{'label':'男','value':'1'},{'label':'女','value':'2'}]"%>
<%@attribute name="usedefaultplaceholder" type="java.lang.String" description="是否使用默认的placeholder，默认true"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="collection" type="java.lang.String" description="代码表（在CdsiAppCode类中添加码表）"%>
<%@attribute name="onselect" type="java.lang.String"
	description="选择回调函数，该函数返回false时将阻止设值,function selectCallback(label, value, obj){}"%>
<%@attribute name="readonly" type="java.lang.String" description="是否只读，默认false"%>
<%@attribute name="disabled" type="java.lang.String" description="是否禁用，默认false"%>
<%@attribute name="emptyTips" type="java.lang.String" description="为空时校验提示信息"%>
<%@attribute name="defaultValue" type="java.lang.String" description="选择面板中初始化选择位置,数据格式['510000','510100','510101']"%>
<%@attribute name='filter' type='java.lang.String' description='设置过滤这些数据不显示，例如:filter="1,2,3"表示key为1,2,3的数据项不显示'%>
<%@attribute name='reverseFilter' type='java.lang.Boolean' description='true/false,对设置的filter数据是否进行反向过滤，默认false'%>
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
	if(reverseFilter == null){
		reverseFilter = false;
	}
	String cssClass = "weui-cell weui-cell_active weui-cell_access weui-cell_select weui-cell_select-after";
	if ("true".equals(readonly)) {
		cssClass += " weui-cell_readonly";
	}
	if ("true".equals(disabled)) {
		cssClass += " weui-cell_disabled";
	}
	String valueDESC = null;
	if (StringUtils.isNotBlank(value)) {
		try {
			if(StringUtils.isNotBlank(data)){
				JSONArray codeList = JSON.parseArray(data);
				if (codeList != null) {
					Iterator<Object> iterator = codeList.iterator();
					JSONObject code = null;
					boolean findCode = false;
					while (iterator.hasNext()) {
						code = (JSONObject) iterator.next();
						if (value.equals(code.getString("value"))) {
							valueDESC = code.getString("label");
							findCode = true;
							break;
						}
					}
					if (!findCode) {
						valueDESC = value;
					}
				}
			}else{
				valueDESC = CodeTableLocator.getCodeDesc(collection, value);
			}
		} catch (Exception e) {
		    e.printStackTrace();
			valueDESC = value;
		}
	}
%>
<%-- doc --%>
<div id="<%=id%>" mtype="selectInput" class="<%=cssClass%>" <%if ("false".equals(display)) {%> style="display: none;"
	<%}%>>
	<div class="weui-cell__hd">
		<label class="weui-label">
			<span class="weui-required" <%if ("true".equals(required)) {%> style="color: red;" <%} else {%>
				style="color: red;display: none;" <%}%>>*</span>
			<%=key%>
		</label>
	</div>
	<div class="weui-cell__bd weui-flex" id="<%=id%>_showPicker">
		<input id="<%=id%>_DESC" name="<%=id%>_DESC" class="weui-input" <%if (StringUtils.isNotBlank(placeholder)) {%>
			placeholder="<%=placeholder%>" <%}%> readonly="readonly" <%if ("true".equals(required)) {%> required="<%=required%>" <%}%>
			<%if (StringUtils.isNotBlank(valueDESC)) {%>value="<%=valueDESC%>" <%}%> <%if (StringUtils.isNotBlank(emptyTips)) {%>emptyTips="<%=emptyTips%>" <%}%>/>
		<%-- 
		<button id="<%=id%>_input_clear" class="weui-btn_reset weui-btn_icon weui-btn_input-clear">
			<i class="weui-icon-clear"></i>
		</button>
		--%>
	</div>
	<input id="<%=id%>_input" name="<%=id%>" type="hidden" <%if (StringUtils.isNotBlank(value)) {%> value="<%=value%>"
		<%}%> key="<%=key%>" <%if ("true".equals(required)) {%> required="<%=required%>" <%}%>
		<%if ("true".equals(readonly)) {%> readonly="<%=readonly%>" <%}%> <%if ("true".equals(disabled)) {%>
		disabled="<%=disabled%>" <%}%> <%if (StringUtils.isNotBlank(placeholder)) {%> placeholder="<%=placeholder%>" <%}%>
		<%if (StringUtils.isNotBlank(onselect)) {%> onselect="<%=onselect%>" <%}%>
		<%if (StringUtils.isNotBlank(collection)) {%> collection="<%=collection%>" <%}%> defaultValue="<%=defaultValue%>" />
</div>
<script type="text/javascript">
<%--
$('#<%=id%>_input_clear').tap(function(e){
	$('#<%=id%>_input').val('');
	$('#<%=id%>_DESC').val('');
});
--%>
var data;
<%if (StringUtils.isNotBlank(collection)) {%>
	data = Base.parseCodeList(<%=CodeTableLocator.getCodeJson(collection)%>);
<%} else {%>
	data = <%=data%>;
<%}%>
if(data){
	<% if(StringUtils.isNotBlank(filter)){%>
	data = Base.parseCodeList(<%=CodeTableLocator.getFilterCodeJson(collection,filter,!reverseFilter)%>);
	<%}%>
	//设置下拉选列表值到Base变量里面
	Base.selectDatas['<%=id%>_showPicker'] = data;
	$('#<%=id%>_showPicker').click(function() {
		var _this = $("#<%=id%>_input");

		var _desc = $('#<%=id%>_DESC');
		var _input = $('#<%=id%>_input');

		if("true" == _this.attr("readonly") || "true" == _this.attr("disabled")){
			return false;
		}
		weui.picker(Base.selectDatas['<%=id%>_showPicker'], {
			onChange : function(result) {
				//console.log(result);
			},
			<%if (StringUtils.isNotBlank(defaultValue)) {%>
			defaultValue : <%=defaultValue%>,
			<%}%>
			onConfirm : function(result) {
				<%if (StringUtils.isNotBlank(onselect)) {%>
					if(typeof <%=onselect%> === 'function'){
						var ret = <%=onselect%>.call(this, result[result.length -1].label, result[result.length -1].value,$('#<%=id%>'));
						if(ret == false){
                            _desc.val("");
                            _input.val("");
							return false;
						}
					}
				<%}%>
				var _label = '';
				for (var n = 0; n <= result.length - 1; n++) {
					_label += '-';
					_label += result[n].label;
				}
				_desc.val(_label.substr(1));
				//_desc.val(result[result.length -1].label);
				_input.val(result[result.length -1].value);
				//设置值后隐藏校验错误提示
                weui.form.hideErrorTips(document.getElementById('<%=id%>_DESC'));
			},
			title : '选择<%=key%>',
			id : '<%=id%>_showPicker'
		});
	});
}
</script>
