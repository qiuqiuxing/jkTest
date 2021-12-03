<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%--@doc--%>
<%@tag description='tab页的容器' display-name='tabs' %>

<%@attribute name='id' description='组件id' type='java.lang.String' %>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name='cssClass' description='给该组件添加自定义样式class，如:cssClass="no-padding"' type='java.lang.String' %>
<%@attribute name='cssStyle' description='给该组件添加自定义样式，如:cssStyle="padding-top:10px"' type='java.lang.String' %>
<%--@doc--%>
<%
	String cssClasses = "weui-tab";
	if (StringUtils.isNotBlank(cssClass)) {
		cssClasses += (" " + cssClass);
	}
	String cssStyles = "";
	if (StringUtils.isNotBlank(cssStyle)) {
		cssStyles += cssStyle;
	}
	if ("false".equals(display)) {
		cssStyles += "display: none;";
	}
 %>

<div mtype="tabs" id="<%=id == null ? "" : id%>" class="<%=cssClasses%>" style="<%=cssStyles%>">
	<div class="weui-navbar">
		<jsp:doBody/>
	</div>
	<div class="weui-tab__panel"></div>
</div>
<script type="text/javascript">
    $(function(){
		//设置默认选中tab
		if ($(".weui-bar__item_on").length == 0) {
			$($(".weui-navbar__item")[0]).addClass("weui-bar__item_on");
		}
		//重新排列tab
		$(".weui-tab").each(function(){
			let realpanels = $(this).children(".weui-tab__panel");
			$(this).find(".tab_panel").each(function(){
				$(this).appendTo(realpanels);
			});
		});
        $('.weui-navbar__item').on('click', function () {
            let linkid = $(this).attr("link-field");
            let $tabpanels = $(this).parent().siblings(".weui-tab__panel").children();
            $tabpanels.each(function(){
                if (linkid == $(this).attr("id")) {
                    $(this).css("display", "block");
                }else{
                    $(this).css("display", "none");
                }
            });
            $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
        });
        $(".weui-bar__item_on").each(function(){
            $(this).trigger("click");
        });
    });
</script>