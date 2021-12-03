<%@tag pageEncoding="UTF-8"%>
<%@tag import="javax.servlet.jsp.tagext.JspTag"%>
<%@tag import="java.lang.reflect.Method"%>
<%@tag import="java.beans.PropertyDescriptor"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%@ tag import="com.yinhai.base.util.TagUtil" %>
<%-- doc --%>
<%@tag description="dataGridItem" display-name="数据表格"%>
<%@attribute name="id" required="true" type="java.lang.String" description="列字段名称"%>
<%@attribute name="key" required="true" type="java.lang.String" description="列字段描述"%>
<%@attribute name="collection" type="java.lang.String" description="代码表"%>
<%-- doc --%>
<%
	JspTag parentTag = TagUtil.getTa3ParentTag(getParent());
	Class parentTagClass = parentTag.getClass();
	PropertyDescriptor pd = new PropertyDescriptor("id", parentTagClass);
	Method method = pd.getReadMethod();
	String gridId = (String) method.invoke(parentTag);
	if (StringUtils.isBlank(collection)) {
		collection = "";
	}
%>
<script type="text/javascript">
	opt_<%=gridId%>.columns.push({
		"id" : "<%=id%>",
		"key" : "<%=key%>",
		"collection" : "<%=collection%>"
	});
</script>
