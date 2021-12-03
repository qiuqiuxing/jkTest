<%@tag pageEncoding="UTF-8"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%-- doc --%>
<%@tag description="imgUploader" display-name="图片上传组件，当前页面只支持一个该组件"%>
<%@attribute name="id" type="java.lang.String" required="true" description="页面中唯一标志符"%>
<%@attribute name="key" type="java.lang.String" required="true" description="上传说明"%>
<%@attribute name="maxCount" required="false" type="java.lang.String" description="最大上传文件数，默认5"%>
<%@attribute name="maxSize" required="false" type="java.lang.String" description="单文件最大限制，单位MB，默认20M"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="cssClass" type="java.lang.String" description="自定义样式"%>
<%@attribute name="cssStyle" type="java.lang.String" description="自定义样式"%>
<%-- doc --%>
<%
	String cssClasses = "weui-uploader ";
	if (StringUtils.isNotBlank(cssClass)) {
		cssClasses += cssClass;
	}
	String cssStyles = "padding: 10px 15px;";
	if (StringUtils.isNotBlank(cssStyle)) {
		cssStyles += cssStyle;
	}
	if ("false".equals(display)) {
		cssStyles += "display: none;";
	}
	if (StringUtils.isBlank(maxCount)) {
		maxCount = "5";
	}
	if (StringUtils.isBlank(maxSize)) {
		maxSize = "20";
	}
%>
<div id="<%=id%>" mtype="imgUploader" class="<%=cssClasses%>" style="<%=cssStyles%>">
	<div class="weui-uploader__hd">
		<p class="weui-uploader__title"><%=key%></p>
		<div class="weui-uploader__info" id="<%=id%>_uploader__info">0/<%=maxCount%></div>
	</div>
	<div class="weui-uploader__bd">
		<ul class="weui-uploader__files">

		</ul>
		<div class="weui-uploader__input-box">
			<input id="<%=id%>_input" class="weui-uploader__input" accept="image/*" multiple="" type="file">
		</div>
	</div>
</div>
<script type="text/javascript">
    var <%=id%>_imgs = [];
    //记录当前已选择图片数量
    var <%=id%>_imgIndex = 0;
    $("#<%=id%>_input").on("change",function(){
        let id = "<%=id%>";
        let file = this;
        var MAXWIDTH = 750;
        var MAXHEIGHT = 1000;
        if (<%=id%>_imgIndex + file.files.length ><%=maxCount%>) {
            $.alert("图片数量超出了最大值", "警告");
            return;
        }
        for (var i = 0; i < file.files.length; i++) {
            if (file.files && file.files[i]) {
                let filename = file.files[i].name;
                let filesize = file.files[i].size;
                //文件大小控制
                if (filesize > <%=maxSize%> * 1024 * 1024) {
                    $.alert("图片大小超出了允许的最大值<%=maxSize%>MB", "警告");
                    return;
                }
                //不压缩
                /*var reader = new FileReader();
                reader.onload = function (evt) {
                    let imgURL = evt.target.result;
                    let imgbase64 = imgURL.substring(imgURL.indexOf("base64") + 7);
                    let imgIndex = $(file).parent().prev().find("li").length;
                    let img = <%=id%>_imgs[imgIndex];
                    let imgdata = JSON.stringify({
                        name: img.name,
                        size: img.size,
                        type: img.type,
                        base64: imgbase64
                    });
                    console.log(imgdata);
                    $(file).parent().prev().append('<li onclick="removeimg(this)" class="weui-uploader__file" style="background-image:url(' + imgURL + ')"><input index=\"' + imgIndex + '\" name="imgfile_' + id + '\" type="hidden" /></li>');
                    $(file).parent().prev().find("input:last").val(imgdata);
                };
                reader.readAsDataURL(file.files[i]);
                <%=id%>_imgs.push(file.files[i]);*/
                //压缩上传（文件太大事后台解析不出base64）
                lrz(file.files[i], {width: 750, fieldName: "file"}).then(function (data) {
                    let imgURL = data.base64;
                    let imgbase64 = imgURL.substring(imgURL.indexOf("base64") + 7);
                    let imgIndex = $(file).parent().prev().find("li").length;
                    let imgdata = JSON.stringify({
                        name: data.origin.name,
                        size: data.file.size,
                        type: data.file.type,
                        base64: imgbase64
                    });
                    // console.log(imgdata);
                    $(file).parent().prev().append('<li onclick="removeimg(this)" class="weui-uploader__file" style="background-image:url(' + imgURL + ')"><input index=\"' + imgIndex + '\" name="imgfile_' + id + '\" type="hidden" /></li>');
                    $(file).parent().prev().find("input:last").val(imgdata);
                }).then(function (data) {

                }).catch(function (err) {
                    console.log(err);
                });
                <%=id%>_imgIndex++;
                $("#<%=id%>_uploader__info").html(<%=id%>_imgIndex + "/" +<%=maxCount%>);
                if(<%=id%>_imgIndex == <%=maxCount%>){
                    $("#<%=id%>_input").parent().hide();
                }
            }
        }
    });
	function removeimg(obj){
		$.confirm('您确定要删除吗?', '确认删除?', function() {
			let removeIndex = $(obj).attr("index");
			<%=id%>_imgIndex--;
			$("#<%=id%>_uploader__info").html(<%=id%>_imgIndex + "/" +<%=maxCount%>);
			$("#<%=id%>_input").parent().show();
			<%--<%=id%>_imgs.splice(removeIndex, 1);--%>
			$(obj).remove();
		});
		return false;
	}
</script>


