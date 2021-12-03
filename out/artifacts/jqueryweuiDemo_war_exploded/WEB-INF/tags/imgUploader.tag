<%@tag pageEncoding="UTF-8"%>
<%@tag import="java.util.Map"%>
<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%-- doc --%>
<%@tag description="imgUploader" display-name="图片上传组件"%>
<%@attribute name="id" required="true" type="java.lang.String" description="页面中唯一标志符"%>
<%@attribute name="key" required="false" type="java.lang.String" description="上传内容名称"%>
<%@attribute name="description" required="false" type="java.lang.String" description="上传内容描述"%>
<%@attribute name="maxCount" required="false" type="java.lang.String" description="最大上传文件数，默认5"%>
<%@attribute name="maxSize" required="false" type="java.lang.String" description="单文件最大限制，单位MB，默认5M"%>
<%@attribute name="upUrl" required="true" type="java.lang.String" description="文件上传url"%>
<%@attribute name="delUrl" required="false" type="java.lang.String" description="文件删除url"%>
<%@attribute name="display" type="java.lang.String" description="是否显示，默认true"%>
<%@attribute name="cssClass" type="java.lang.String" description="自定义样式"%>
<%@attribute name="cssStyle" type="java.lang.String" description="自定义样式"%>
<%@attribute name="required" type="java.lang.String" description="是否必填"%>
<%@attribute name="disabled" type="java.lang.String" description="是否禁用，默认false"%>
<%@attribute name="fileVal" type="java.lang.String" description="后台接收文件字段名称，默认file"%>
<%@attribute name="onProgress" type="java.lang.String" description="上传进度监听函数,function(percent){},接收进度百分比参数"%>
<%@attribute name="onSuccess" type="java.lang.String" description="上传成功的回调函数,function(ret){},接收后台返回的resonpseText参数"%>
<%@attribute name="onError" type="java.lang.String" description="上传失败的回调函数,function(err){},接收后天返回的错误信息"%>
<%@attribute name="onBeforeSend" type="java.lang.String"
	description="发送文件前执行的函数，function(data, headers) {},可以通过扩展data对象来扩展上传参数"%>
<%@attribute name="data" type="java.lang.String" description="上传时的额外参数，JSON格式字符串"%>
<%-- doc --%>
<%
	String cssClasses = "";
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
	if (StringUtils.isBlank(key)) {
		key = "材料上传";
	}
	if (StringUtils.isBlank(maxCount)) {
		maxCount = "5";
	}
	if (StringUtils.isBlank(maxSize)) {
		maxSize = "5";
	}
	if (StringUtils.isBlank(fileVal)) {
		fileVal = "file";
	}
%>
<div class="weui-cell" id="<%=id%>" class="<%=cssClasses%>" style="<%=cssStyles%>" mtype="imgUploader">
	<div class="weui-cell__bd">
		<div class="weui-uploader">
			<div class="weui-uploader__hd">
				<%
					if ("true".equals(required)) {
				%>
				<span class="weui-required" style="color: red;">*</span>
				<%
					}
				%>
				<p class="weui-uploader__title"><%=key%></p>
				<div class="weui-uploader__info">
					<span id="<%=id%>Count">0</span>
					/<%=maxCount%>
				</div>
			</div>
			<%
				if (StringUtils.isNotBlank(description)) {
			%>
			<div class="weui-uploader__hd" style="color: red;font-size: 14px;"><%=description%></div>
			<%
				}
			%>
			<div class="weui-uploader__bd">
				<ul class="weui-uploader__files" id="<%=id%>Files"></ul>
				<div class="weui-uploader__input-box">
					<input id="<%=id%>Input" class="weui-uploader__input" key="<%=key%>" type="file" accept="image/*" capture="camera"
						multiple="" <%if ("true".equals(disabled)) {%> disabled="<%=disabled%>" <%}%> />
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var <%=id%>Count = 0;
	var <%=id%>CountDom = document.getElementById("<%=id%>Count");
	weui.uploader('#<%=id%>', {
		url : '<%=upUrl%>',
		auto : true,
		type : 'file',
		fileVal : '<%=fileVal%>',
		compress : {
			/* width : 1600,
			height : 1600,
			quality : .8 */
		},
		onBeforeQueued : function(files) {
			// `this` 是轮询到的文件, `files` 是所有文件
			if ([ "image/jpg", "image/jpeg", "image/png", "image/gif" ].indexOf(this.type) < 0) {
				weui.alert('请上传图片');
				return false; // 阻止文件添加
			}
			if (this.size > parseInt("<%=maxSize%>") * 1024 * 1024) {
				weui.alert('请上传不超过<%=maxSize%>M的图片');
				return false;
			}
			var maxCount = parseInt("<%=maxCount%>");
			if (files.length > maxCount) { // 防止一下子选择过多文件
				weui.alert('最多只能上传'+maxCount+'张图片，请重新选择');
				return false;
			}
			if (<%=id%>Count + 1 > maxCount) {
				weui.alert('最多只能上传'+maxCount+'张图片');
				return false;
			}
			++<%=id%>Count;
			<%=id%>CountDom.innerHTML = <%=id%>Count;
			// return true; // 阻止默认行为，不插入预览图的框架
		},
		onQueued : function() {
			// console.log(this);
			// console.log(this.status); // 文件的状态：'ready', 'progress', 'success', 'fail'
			// console.log(this.base64); // 如果是base64上传，file.base64可以获得文件的base64
			// this.upload(); // 如果是手动上传，这里可以通过调用upload来实现；也可以用它来实现重传。
			// this.stop(); // 中断上传
			// return true; // 阻止默认行为，不显示预览图的图像

		},
		onBeforeSend : function(data, headers) {
			// console.log(this, data, headers);
			// $.extend(data, { test: 1 }); // 可以扩展此对象来控制上传参数
			// $.extend(headers, { Origin: 'http://127.0.0.1' }); // 可以扩展此对象来控制上传头部
			// return false; // 阻止文件上传
			$.extend(data, {'id':this.id});
			<%if (StringUtils.isNotBlank(data)) {%>
				$.extend(data, JSON.parse('<%=data%>'));
			<%}%>
			if(typeof(<%=onBeforeSend%>)==='function'){
				return <%=onBeforeSend%>.call(this,data,headers);
			}
		},
		onProgress : function(percent) {
			// console.log(this, percent);
			// return true; // 阻止默认行为，不使用默认的进度显示
			if(typeof(<%=onProgress%>) === 'function'){
				return <%=onProgress%>.call(this, percent);
			}
		},
		onSuccess : function(ret) {
			// console.log(this, ret);
			// return true; // 阻止默认行为，不使用默认的成功态
			if(typeof(<%=onSuccess%>) === 'function'){
				return <%=onSuccess%>.call(this, ret);
			}
		},
		onError : function(err) {
			// console.log(this, err);
			// return true; // 阻止默认行为，不使用默认的失败态
			if(typeof(<%=onError%>) === 'function'){
				return <%=onError%>.call(this, err);
			}
		}
	});

	//缩略图预览
	document.querySelector('#<%=id%>Files').addEventListener('click', function(e) {
		var target = e.target;
		while (!target.classList.contains('weui-uploader__file') && target) {
			target = target.parentNode;
		}
		if (!target) return;
		var url = target.getAttribute('style') || '';
		var id = target.getAttribute('data-id');
		if (url) {
			url = url.match(/url\((.*?)\)/)[1].replace(/"/g, '');
		}
		var gallery = weui.gallery(url, {
			className : '',
			onDelete : function() {
				weui.confirm('确定删除该图片？', function() {
					Base.submit("", "<%=delUrl%>", {'id' : id}, null, false, function(data){
						--<%=id%>Count;
						<%=id%>CountDom.innerHTML = <%=id%>Count;
						target.remove();
						gallery.hide();
					}, function(xhr, type){
						weui.alert("删除失败");
					});
				});
			}
		});
	});
</script>


