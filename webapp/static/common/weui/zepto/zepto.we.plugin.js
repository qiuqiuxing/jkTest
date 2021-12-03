/**
 * WEUI插件
 * @author yangjun
 */
(function(factory) {
	if (typeof define === 'function' && define.amd) {
		define([ 'zepto' ], factory);
	} else {
		factory(Zepto);
	}
}(function($) {

	window.WePlugin = {

		//提示信息
		showMessage : function(message, btnValue) {
			var $iosDialog2 = $('#iosDialog2');
			if ($iosDialog2 && $iosDialog2.length > 0) {
				$('.weui-dialog__bd', $iosDialog2).text(message || '提示信息');
				$('.weui-dialog__btn', $iosDialog2).text(btnValue || '知道了');
				$iosDialog2.show();
			} else {
				var html = [];
				html.push('<div class="js_dialog" id="iosDialog2">');
				html.push('<div class="weui-mask"></div>');
				html.push('<div class="weui-dialog">');
				html.push('<div class="weui-dialog__bd">');
				html.push(message);
				html.push('</div>');
				html.push('<div class="weui-dialog__ft">');
				$iosDialog2 = $(html.join(''));
				var btn = '<a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_primary">' + (btnValue || '知道了') + '</a>';
				var $btn = $(btn);
				$('.weui-dialog__ft', $iosDialog2).append($btn);
				$btn.tap(function() {
					$iosDialog2.hide();
				});
				$('body').append($iosDialog2);
			}
		},

		//显示加载提示
		showLoading : function showLoading() {
			var $loadingToast = $('#loadingToast');
			if ($loadingToast && $loadingToast.length > 0) {
				$loadingToast.show();
			} else {
				var html = [];
				html.push('<div id="loadingToast">');
				html.push('<div class="weui-mask_transparent"></div>');
				html.push('<div class="weui-toast">');
				html.push('<i class="weui-loading weui-icon_toast"></i>');
				html.push('<p class="weui-toast__content">数据加载中</p>');
				$('body').append(html.join(''));
			}
		},

		//关闭加载提示
		hideLoading : function() {
			$('#loadingToast').hide();
		}
	};

}));