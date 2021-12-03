<%@tag pageEncoding="UTF-8"%>
<%-- doc --%>
<%@tag description="text" display-name="页面标题"%>
<%@attribute name="title" required="true" type="java.lang.String" description="标题"%>
<%-- doc --%>
<header class='demos-header' style="background-color: #5f96d9">
	<div style="text-align: center;color: white;height: 60px">
		<div style="height: 10px"></div>
		<h2 class="demos-title"><%=title%></h2>
	</div>
</header>

