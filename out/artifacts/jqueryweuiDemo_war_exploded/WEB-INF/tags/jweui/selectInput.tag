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
	description="列表数据，[{'id':'1','name':'男'},{'id':'2','name':'女'}]"%>
<%@attribute name="usedefaultplaceholder" type="java.lang.String" description="是否使用默认的placeholder，默认true"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="collection" type="java.lang.String" description="代码表（在CdsiAppCode类中添加码表）"%>
<%@attribute name="beforeClose" type="java.lang.String"
	description="关闭前选择校验函数，返回true或false，返回false将不会关闭，function selectCallback(id, name){}"%>
<%@attribute name="onselect" type="java.lang.String"
	description="选择回调函数，function selectCallback(id, name){}"%>
<%@attribute name="readonly" type="java.lang.String" description="是否只读，默认false"%>
<%@attribute name="disabled" type="java.lang.String" description="是否禁用，默认false"%>
<%@attribute name="emptyTips" type="java.lang.String" description="为空时校验提示信息"%>
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
	String cssClass = "weui-cell weui-cell_select";
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
						if (value.equals(code.getString("id"))) {
							valueDESC = code.getString("name");
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
<div id="<%=id%>" mtype="selectInput" sty class="<%=cssClass%>" <%if ("false".equals(display)) {%> style="display: none;"
	<%}%>>
	<div class="weui-cell__hd">
		<label class="weui-label">
			<span class="weui-required" <%if ("true".equals(required)) {%> style="color: red;" <%} else {%>
				style="color: red;display: none;" <%}%>>*</span>
			<%=key%>
		</label>
	</div>
	<div class="weui-cell__bd" id="<%=id%>_showPicker">
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
			<%if (StringUtils.isNotBlank(beforeClose)) {%> beforeClose="<%=beforeClose%>" <%}%>
		<%if (StringUtils.isNotBlank(collection)) {%> collection="<%=collection%>" <%}%>/>
</div>
<script type="text/javascript">
let <%=id%>_data;
<%if (StringUtils.isNotBlank(collection)) {%>
	<%=id%>_data = Base.parseCodeList(<%=CodeTableLocator.getCodeJson(collection)%>);
<%} else {%>
	<%=id%>_data = Base.parseCodeList(<%=data%>);
<%}%>
if(<%=id%>_data){
	<% if(StringUtils.isNotBlank(filter)){%>
    <%=id%>_data = Base.parseCodeList(<%=CodeTableLocator.getFilterCodeJson(collection,filter,!reverseFilter)%>);
	<%}%>
	//设置下拉选列表值
	$('#<%=id%>').selectData = <%=id%>_data;
    $('#<%=id%>_DESC').select({
        title : '请选择<%=key%>',
        items: <%=id%>_data,
        beforeClose: function(values, titles) {
            if(typeof <%=beforeClose%> === 'function'){
                return <%=beforeClose%>.call(this, values, titles);
			}
            return true;
        },
        onChange: function(d) {
            if(typeof <%=onselect%> === 'function'){
                <%=onselect%>.call(this, d.values, d.titles);
			}
        },
        onClose: function (d) {
            $('#<%=id%>_input').val(d.data.values);
        }
    });
}
</script>
