<%@tag pageEncoding="UTF-8" %>
<%@tag import="java.util.Map" %>
<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%-- doc --%>
<%@tag description="date" display-name="日期选择框" %>
<%@attribute name="id" required="true" type="java.lang.String" description="页面中唯一标志符" %>
<%@attribute name="key" required="true" type="java.lang.String" description="名称" %>
<%@attribute name="value" type="java.lang.String" description="组件值" %>
<%@attribute name="required" type="java.lang.String" description="是否必填" %>
<%@attribute name="dateType" type="java.lang.String" description="日期类型，date,dateTime,默认date" %>
<%@attribute name="onchange" type="java.lang.String" description="值改变事件，fnonchange()" %>
<%@attribute name="emptyTips" type="java.lang.String" description="为空时校验提示信息" %>
<%@attribute name="placeholder" type="java.lang.String" description="获的焦点事件处理函数" %>
<%@attribute name="start" type="java.lang.String" description="日期输入区间开始，2021-04-16" %>
<%@attribute name="end" type="java.lang.String" description="日期输入区间结束，2030-04-16" %>
<%@attribute name="years" type="java.lang.String" description="限定年份，[2017,2018,2019]" %>
<%@attribute name="monthes" type="java.lang.String" description="限定月份，['06', '07']" %>
<%@attribute name='validNowTime' type='java.lang.String' description='left/right,验证时间,left表示不能大于当前时间，right表示不能小于当前时间' %>
<%@attribute name="usedefaultplaceholder" type="java.lang.String" description="是否使用默认的placeholder，默认true" %>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true" %>
<%@attribute name="onselect" type="java.lang.String"
             description="选择回调函数，该函数返回false时将阻止设值,function selectCallback(value,obj){}" %>
<%@attribute name="readonly" type="java.lang.String" description="是否只读，默认false" %>
<%@attribute name="disabled" type="java.lang.String" description="是否禁用，默认false" %>
<%
    if (StringUtils.isBlank(usedefaultplaceholder)) {
        usedefaultplaceholder = "true";
    }
    if (StringUtils.isBlank(dateType)) {
        dateType = "date";
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
        <input id="<%=id%>_DESC" class="weui-input"  <%if (StringUtils.isNotBlank(placeholder)) {%>
               placeholder="<%=placeholder%>" <%}%> readonly="readonly" <%if (StringUtils.isNotBlank(value)) {%>
               value="<%=value%>"
                <%}%><%if ("true".equals(required)) {%> required="<%=required%>" <%}%>
               <%if (StringUtils.isNotBlank(emptyTips)) {%>emptyTips="<%=emptyTips%>" <%}%>
               <%if (StringUtils.isNotBlank(onchange)) {%>onchange="<%=onchange%>" <%}%>/>
        <input id="<%=id%>_input" name="<%=id%>" type="hidden" class="weui-input"
               key=<%=key%> <%if ("true".equals(required)) {%>
                       required="<%=required%>" <%}%><%if ("true".equals(readonly)) {%> readonly="<%=readonly%>" <%}%>
                <%if ("true".equals(disabled)) {%>
               disabled="<%=disabled%>" <%}%> <%if (StringUtils.isNotBlank(placeholder)) {%>
               placeholder="<%=placeholder%>" <%}%> <%if (StringUtils.isNotBlank(value)) {%> value="<%=value%>" <%}%>
               <%if (StringUtils.isNotBlank(emptyTips)) {%>emptyTips="<%=emptyTips%>" <%}%>/>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        if ("true" == $('#<%=id%>_input').attr("readonly") || "true" == $('#<%=id%>_input').attr("disabled")) {
            return false;
        }
        $('#<%=id%>_DESC').datetimePicker({
            title: '请选择<%=key%>',
            // years:range(1940,2030),
            <%if(StringUtils.isNotBlank(dateType) && "date".equals(dateType)){%>
                times: function () {
                    return [];
                },
            <%}%>
            parse: function (str) {
                return str.split("-");
            },
            <%if (StringUtils.isNotBlank(validNowTime) && "right".equals(validNowTime)){%>
            min: Base.getNowDateStr("-"),
            <%}%>
            <%if (StringUtils.isNotBlank(validNowTime) && "left".equals(validNowTime)){%>
            max: Base.getNowDateStr("-"),
            <%}%>
            <%if (StringUtils.isNotBlank(start)){%>
            min: '<%=start%>',
            <%}%>
            <%if (StringUtils.isNotBlank(end)){%>
            max: '<%=end%>',
            <%}%>
            <%if (StringUtils.isNotBlank(years)){%>
            years: <%=years%>,
            <%}%>
            <%if (StringUtils.isNotBlank(monthes)){%>
            monthes: <%=monthes%>,
            <%}%>
            onChange: function (picker, values, displayValues) {
                let value = values[0] + '-' + values[1] + '-' + values[2];
                if(typeof <%=onselect%> === 'function'){
                    <%=onselect%>.call(this, value);
                }
            },
            onClose: function (d) {
                $('#<%=id%>_input').val($('#<%=id%>_DESC').val());
            }
        });
    });
</script>
