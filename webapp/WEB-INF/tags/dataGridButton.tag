<%@tag pageEncoding="UTF-8"%>
<%@tag import="javax.servlet.jsp.tagext.JspTag"%>
<%@tag import="javax.servlet.jsp.tagext.SimpleTagSupport"%>
<%@tag import="java.lang.reflect.Method"%>
<%@tag import="java.beans.PropertyDescriptor"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%@ tag import="com.yinhai.base.util.TagUtil" %>
<%-- doc --%>
<%@tag description="dataGridButton" display-name="表格按钮"%>
<%@attribute name="key" required="true" type="java.lang.String" description="按钮名称"%>
<%@attribute name="hasSeparation" type="java.lang.String" description="是否显示分隔线"%>
<%@attribute name="cssClass" type="java.lang.String" description="自定义样式"%>
<%@attribute name="onclick" type="java.lang.String" description="点击事件，接收行数据唯一标识作为参数，function(id){}"%>

<%-- doc --%>
<%
	JspTag parentTag = TagUtil.getTa3ParentTag(getParent());
	parentTag = ((SimpleTagSupport) parentTag).getParent();
	Class parentTagClass = parentTag.getClass();
	PropertyDescriptor pd = new PropertyDescriptor("id", parentTagClass);
	Method method = pd.getReadMethod();
	String gridId = (String) method.invoke(parentTag);
	if (StringUtils.isBlank(hasSeparation)) {
		hasSeparation = "false";
	}
	if (StringUtils.isBlank(cssClass)) {
		cssClass = "";
	}
%>
<script type="text/javascript">
	opt_<%=gridId%>.buttons.push({
		"onclick" : "<%=onclick%>",
		"key" : "<%=key%>",
		"hasSeparation" : <%=hasSeparation%>,
		"cssClass" : "<%=cssClass%>"
	});
</script>
