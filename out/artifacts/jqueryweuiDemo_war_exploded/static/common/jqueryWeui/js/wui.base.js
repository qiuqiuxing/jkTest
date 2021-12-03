/**
 * WUI-API
 */
(function ($) {
    $.extend(true, window, {
        Base: core()
    });

    function core() {
        return {
            regexp: regexp,//自定义正则校验
            init: init,
            isEmpty: isEmpty,
            showPsmp: showPsmp,
            topTips: topTips,
            toast: toast,
            setReadOnly: setReadOnly,
            setDisabled: setDisabled,
            setEnable: setEnable,
            setRequired: setRequired,
            clearData: clearData,
            setDisRequired: setDisRequired,
            setSelectInputList: setSelectInputList,
            hide: hide,
            show: show,
            setValue: setValue,
            getValue: getValue,
            alert: alert,
            confirm, confirm,
            showMask: showMask,
            hideMask: hideMask,
            validate: validate,
            validateForm: validateForm,
            submit: submit,
            submitForm: submitForm,
            setGridData: setGridData,
            clearGridData: clearGridData,
            getGridData: getGridData,
            getGridRowData: getGridRowData,
            addGridData: addGridData,
            deleteGridData: deleteGridData,
            parseCodeList: parseCodeList,
            loadCodeTable: loadCodeTable,
            desensitization: desensitization,
            getNowDateStr: getNowDateStr,
            idcard218: idcard218,
            getCodeDesc: getCodeDesc,
            setOldInputValue: setOldInputValue,
            checkInputChange: checkInputChange
        };

        /**
         * 初始化
         */
        function init() {
            //加载码表
            Base.loadCodeTable();
        }

        /**
         * 自定义表单校验正则
         * 表单的pattern需要以REG_开头，如pattern="REG_PHONENO"
         * @returns
         */
        function regexp() {
            return {
                mobile: /^1\d{10}$/,
                idcard: /^\d{6}((19|20)\d{2})((0[0-9])|(1[0-2]))(((0|1|2)[0-9])|(3[0,1]))\d{3}[xX\d]$/,
                zipcode: /[0-9]\d{5}(?!\d)/,
                email: /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/,
                url: /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/,
                chinese: /^[\u4e00-\u9fa5]+$/,
                ip: /^((?:(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d)))\.){3}(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d))))$/,
                integer: /^-?[1-9]\d*$/,
            }
        }

        /**
         * 判断是值否为空
         * @param value
         * @returns {boolean}
         */
        function isEmpty(value) {
            if (value == "" || value == null || value == undefined || value == 'undefined') {
                return true;
            }
            return false;
        }

        /**
         * 打开评价页面
         * </br>
         * psmpUrl 评价url
         * </br>
         * redirectUrl 评价完成后的回调url
         */
        function showPsmp(psmpUrl, redirectUrl) {
            if (redirectUrl) {
                if (psmpUrl.indexOf("?") > -1) {
                    window.location.href = BasePath.serverPath + psmpUrl + "&redirectUrl=" + redirectUrl;
                } else {
                    window.location.href = BasePath.serverPath + psmpUrl + "?redirectUrl=" + redirectUrl;
                }
            } else {
                window.location.href = BasePath.serverPath + psmpUrl;
            }
        }

        /**
         * 顶部错误提示信息
         * </br>
         *content：内容，默认操作成功
         * </br>
         *duration：持续时间，单位毫秒，默认3000
         * </br>
         * type：类型success,error,warning
         */
        function topTips(content, duration, type) {
            $.toptip(content, duration, type);
        }


        /**
         * toast提示信息
         * </br>
         *content：内容，默认已经完成
         * </br>
         * style：类型，cancel，forbidden，text 也可只传到该参数将此参数替换为毫秒时间，也可以是回调函数
         * </br>
         *callback：回调函数
         */
        function toast(content, style, callback) {
            $.toast.prototype.defaults.duration = 3000;
            $.toast(content, style, callback);
        }

        /**
         * 设置组件只读，多个组件id使用逗号分隔
         * </br>
         * ids，例如aac002,aac001
         */
        function setReadOnly(ids) {
            var _ids = ids.split(',');
            for (var i = 0; i < _ids.length; i++) {
                var cur_id = _ids[i];
                var obj = $("#" + cur_id);
                obj.addClass("weui-cell_readonly");
                if (obj.attr("mtype") == "textarea") {
                    $("textarea", obj).attr("readonly", "true");
                } else {
                    $("input", obj).attr("readonly", "true");
                }
            }
        }

        /**
         * 禁用组件，多个组件id使用逗号分隔
         * </br>
         * ids，例如aac002,aac001
         */
        function setDisabled(ids) {
            var _ids = ids.split(',');
            for (var i = 0; i < _ids.length; i++) {
                var cur_id = _ids[i];
                var obj = $("#" + cur_id);
                if (obj.attr("mtype") == "button") {
                    obj.addClass("weui-btn_disabled").attr("disabled", true);
                } else if (obj.attr("mtype") == "textarea") {
                    obj.addClass("weui-cell_disabled");
                    $("textarea", obj).attr("disabled", "true");
                } else {
                    obj.addClass("weui-cell_disabled");
                    $("input", obj).attr("disabled", "true");
                }
            }
        }

        /**
         * 启用组件，多个组件id使用逗号分隔
         * </br>
         * ids，例如aac002,aac001
         */
        function setEnable(ids) {
            var _ids = ids.split(',');
            for (var i = 0; i < _ids.length; i++) {
                var cur_id = _ids[i];
                var obj = $("#" + cur_id);
                if (obj.attr("mtype") == "button") {
                    obj.removeClass("weui-btn_disabled").removeAttr("disabled");
                } else if (obj.attr("mtype") == "textarea") {
                    obj.removeClass("weui-cell_disabled").removeClass("weui-cell_readonly");
                    $("textarea", obj).removeAttr("readonly").removeAttr("disabled");
                } else {
                    obj.removeClass("weui-cell_disabled").removeClass("weui-cell_readonly");
                    $("input", obj).removeAttr("readonly").removeAttr("disabled");
                }
            }
        }

        /**
         * 设置组件必填，多个组件id使用逗号分隔
         * </br>
         * ids，例如aac002,aac001
         */
        function setRequired(ids) {
            var _ids = ids.split(',');
            for (var i = 0; i < _ids.length; i++) {
                var cur_id = _ids[i];
                var obj = $("#" + cur_id);
                $(".weui-required", obj).show();
                if (obj.attr("mtype") == "textarea") {
                    $("textarea", obj).attr("required", "true");
                } else {
                    $("input", obj).attr("required", "true");
                }
            }
        }

        /**
         * 清空容器下所有组件的值
         * </br>
         * id:容器id
         */
        function clearData(id) {
            $('input', $("#" + id)).val('');
            $('textarea', $("#" + id)).val('');
        }

        /**
         * 设置组件必填，多个组件id使用逗号分隔
         * </br>
         * ids，例如aac002,aac001
         */
        function setDisRequired(ids) {
            var _ids = ids.split(',');
            for (var i = 0; i < _ids.length; i++) {
                var cur_id = _ids[i];
                var obj = $("#" + cur_id);
                $(".weui-required", obj).hide();
                if (obj.attr("mtype") == "textarea") {
                    $("textarea", obj).removeAttr("required");
                } else {
                    $("input", obj).removeAttr("required");
                }
            }
        }

        /**
         * 设置下拉列表选项数据，多个组件id使用逗号分隔
         * </br>
         * ids，例如aac002,aac001
         * </br>
         * data，JSON数组，例如[{'id':'1','name':'男'},{'id':'2','name':'女'}]
         */
        function setSelectInputList(ids, data) {
            if (!data) {
                return false;
            }
            data = Base.parseCodeList(data);
            var _ids = ids.split(',');
            for (var i = 0; i < _ids.length; i++) {
                var cur_id = _ids[i];
                var obj = $("#" + cur_id);
                if (obj.attr("mtype") != "selectInput") {
                    Base.alert(cur_id + "不是selectInput组件!", "error");
                } else {
                    $('#' + cur_id).selectData = data;
                    var _desc = $('#' + cur_id + '_DESC');
                    var _input = $('#' + cur_id + '_input');
                    if ("true" == _input.attr("readonly") || "true" == _input.attr("disabled")) {
                        return false;
                    }
                    let config = {
                        title: '请选择' + _input.attr("key"),
                        items: data,
                        beforeClose: function (values, titles) {
                            var beforeClose = eval(_input.attr("beforeClose"));
                            if (typeof beforeClose === 'function') {
                                return beforeClose.call(this, values, titles);
                            }
                            return true;
                        },
                        onChange: function (d) {
                            var onselect = eval(_input.attr("onselect"));
                            if (typeof onselect === 'function') {
                                onselect.call(this, d.values, d.titles);
                            }
                        },
                        onClose: function (d) {
                            _input.val(d.data.values);
                        }
                    };
                    if(!_desc.data("weui-select")){
                        _desc.select(config);
                    }else{
                        _desc.select("update",config);
                    }
                }
            }
        }

        /**
         * 隐藏组件，多个组件id使用逗号分隔
         * </br>
         * ids，例如aac002,aac001
         */
        function hide(ids) {
            var _ids = ids.split(',');
            for (var i = 0; i < _ids.length; i++) {
                var cur_id = _ids[i];
                var obj = $("#" + cur_id);
                obj.hide();
            }
        }

        /**
         * 显示组件，多个组件id使用逗号分隔
         * </br>
         * ids，例如aac002,aac001
         */
        function show(ids) {
            var _ids = ids.split(',');
            for (var i = 0; i < _ids.length; i++) {
                var cur_id = _ids[i];
                var obj = $("#" + cur_id);
                obj.show();
            }
        }

        /**
         * 设置组件值，多个组件id使用逗号分隔
         * </br>
         * ids，例如aac002,aac001 ,也可以是Object值进行批量设置
         * </br>
         * value:要设置的值
         */
        function setValue(ids, value) {
            if (Base.isEmpty(value)) {
                value = '';
            }
            if (ids == null || ids == "") return;
            if (typeof ids == 'string') {
                var _ids = ids.split(',');
                for (var i = 0; i < _ids.length; i++) {
                    var cur_id = _ids[i];
                    var obj = $("#" + cur_id);
                    if (obj.attr("mtype") == "selectInput") {
                        var _input = $("#" + cur_id + "_input", obj);
                        var _desc = $("#" + cur_id + "_DESC", obj);
                        if (Base.isEmpty(value)) {
                            _input.val(null);
                            _desc.val(null);
                        } else {
                            let codeList = $("#"+cur_id).selectData;
                            if (codeList) {
                                var findCode = false;
                                for (var j = 0; j < codeList.length; j++) {
                                    var code = codeList[j];
                                    if (code.id == value) {
                                        _input.val(value);
                                        _desc.val(code.name);
                                        findCode = true;
                                        break;
                                    }
                                }
                                if (!findCode) {
                                    _input.val(null);
                                    _desc.val(null);
                                }
                            } else {
                                _input.val(null);
                                _desc.val(null);
                            }
                        }
                    } else if (obj.attr("mtype") == "textarea") {
                        $("textarea", obj).val(value);
                    } else if (obj.attr("mtype") == "date") {
                        $("input", obj).val(value);
                    } else if (obj.attr("desensitization")) {
                        $("#" + cur_id + "_input").val(value);
                        $("#" + cur_id + "_input_dest").val(Base.desensitization(value, obj.attr("desensitization")));
                    } else {
                        $("#" + cur_id + "_input").val(value);
                    }
                }
            } else {
                for (let k in ids) {
                    Base.setValue(k, ids[k]);
                }
            }
        }

        /**
         * 获取组件值
         * </br>
         * id:组件id
         */
        function getValue(id) {
            return $("#" + id + "_input").val();
        }

        /**
         * Alert消息框
         * </br>
         * message:提示内容
         * </br>
         * type:消息框类型，info，wanr，error
         * </br>
         * callback:回调函数，连续调用Alert时只能在回调函数中进行实现
         */
        function alert(message, type, callback) {
            var title ="";
            if (type == "info") {
                title = "提示";
            } else if (type == "warn") {
                title = "警告";
            } else if (type == "error") {
                title = "错误";
            } else {
                title = "提示";
            }
            $.alert(message,title,function () {
                if (typeof callback === "function") {
                    callback.call(this);
                }
            });
        }

        /**
         * Confirm确认框
         * </br>
         * message:提示内容
         * </br>
         * callback:回调函数，接收一个true或false的选择结果变量
         */
        function confirm(message, callback) {
            window.weui_confirm = weui.confirm(message, function () {
                if (typeof callback === "function") {
                    window.weui_confirm.hide(function () {
                        callback.call(this, true);
                    });
                }
            }, function () {
                if (typeof callback === "function") {
                    window.weui_confirm.hide(function () {
                        callback.call(this, false);
                    });
                }
            });
        }

        /**
         * 显示遮罩层，该函数返回一个loading对象
         * </br>
         * 提示内容，默认读取中...
         */
        function showMask(message) {
            return $.showLoading(message);
        }

        /**
         * 取消遮罩层
         */
        function hideMask() {
            $.hideLoading();
        }


        /**
         * 验证表单元素
         * </br>
         * id:组件id，多个组件使用逗号分隔
         */
        function validate(id, callback) {
            var _ids = id.split(',');
            for (var i = 0; i < _ids.length; i++) {
                var cur_id = _ids[i];
                weui.form.validate("#" + cur_id, function (error) {
                    if (error) {
                        if (typeof callback === 'function') {
                            callback.call(this, false);
                        }
                    } else {
                        var _input = $("#" + cur_id + "_input");
                        var value = _input.val() || '';
                        if ("true" == _input.attr("required") && !value) {
                            weui.form.showErrorTips({
                                ele: _input.get(0),
                                msg: _input.attr("emptytips")
                            });
                            //$("body").scrollTop($("#" + cur_id).offset().top - obj.height());
                            if (typeof callback === 'function') {
                                callback.call(this, false);
                            }
                        }
                        if (_input.attr("minlength")) {
                            var minlength = _input.attr("minlength");
                            if (value.length < parseInt(minlength)) {
                                weui.form.showErrorTips({
                                    ele: _input.get(0),
                                    msg: "minlength"
                                });
                                if (typeof callback === 'function') {
                                    callback.call(this, false);
                                }
                            }
                        }
                        if (_input.attr("maxlength")) {
                            var maxlength = _input.attr("maxlength");
                            if (value.length > parseInt(maxlength)) {
                                weui.form.showErrorTips({
                                    ele: _input.get(0),
                                    msg: "maxlength"
                                });
                                if (typeof callback === 'function') {
                                    callback.call(this, false);
                                }
                            }
                        }
                        if (typeof callback === 'function') {
                            callback.call(this, true);
                        }
                    }
                }, {
                    regexp: Base.regexp()
                });

            }
        }

        /**
         * 验证表单
         * </br>
         * id:表单id
         * </br>
         * callback:验证回调函数,接收一个true或者false的表单验证结果
         */
        function validateForm(id, callback) {
            if (!id) {
                return;
            }
            //非必录项不校验
            $("#" + id).find('[required=onlycheck]').each(function () {
                if ($(this).val().length == 0 || $(this)[0].hasAttribute("readonly")) {
                    $(this).removeAttr("required");
                    $(this).attr("requiredBack", "requiredBack");
                }
            });
            weui.form.validate("#" + id, function (error) {
                //重新设置校验
                $("#" + id).find('[requiredBack]').each(function () {
                    $(this).removeAttr("requiredBack");
                    $(this).attr("required", "onlycheck");
                });
                if (error) {
                    $("#" + error.ele['id']).focus();
                    if (typeof callback === 'function') {
                        callback.call(this, false);
                    }
                } else {
                    if (typeof callback === 'function') {
                        callback.call(this, true);
                    }
                }
            }, {
                regexp: Base.regexp()
            });
        }

        /**
         * 发送异步请求
         * @param url
         * @param data
         * @param isShowMask
         * @param _mask
         * @param success
         * @param error
         */
        function ajax(url, data, isShowMask, _mask, success, error, async) {
            $.ajax({
                async: async,
                url: url,
                type: "POST",
                dataType: "json",
                data: data,
                beforeSend: function () {
                    if (isShowMask) {
                        Base.showMask();
                    }
                },
                success: function (data) {
                    if (data) {
                        if (data.code == 1) {//成功
                            if (data.data.msg && data.data.msgType) {
                                Base.alert(data.data.msg, data.data.msgType,function(){
                                    delete data.data.msg;
                                    delete data.data.msgType;
                                    if (success) success(data.data);
                                });
                            }
                        } else if (data.code == 40001) {//系统级异常
                            // Base.toast(data.message, "cancel");
                            Base.topTips(data.message, 3000, "error");
                        } else {//有失败信息
                            Base.alert(data.data, "error");
                            if (error) error(data);
                        }
                    }
                },
                error: function (xhr, type) {
                    Base.topTips("系统繁忙，请稍后再试", 3000, "error");
                },
                complete: function () {//完成响应
                    if (isShowMask) {
                        Base.hideMask();
                    }
                }
            });
        }

        /**
         * 异步提交
         * </br>
         * id：需要提交的容器id，如果非formId则参数需要自己传
         * </br>
         * url:提交后台地址
         * </br>
         * parameter:额外提交参数
         * </br>
         * onsubmit:提交前执行函数，当函数返回false时将阻止提交
         * </br>
         * aotoValidate:是否自动验证表单，默认是
         * </br>
         * success:请求成功回调函数function(data)
         * </br>
         * error:请求过程中发生错误时的回调函数function(xhr, type)
         * </br>
         * showMask:是否显示遮罩层，默认是，如果是同步执行连续多个请求或本次请求无需阻断用户操作界面的建议设置为false，
         * 因为遮罩层的显示和隐藏会有300ms的动画效果且是单例的，同步连续显示遮罩层将导致回调函数不执行
         * @param async 是否异步获取，默认异步
         */
        function submit(id, url, parameter, onsubmit, autoValidate, success, error, showMask, async) {
            var isShowMask = showMask == false ? false : true;
            if (async == null) async = true;
            if (typeof onsubmit === 'function') {
                if (!onsubmit.call(this)) {
                    return false;
                }
            }
            var _mask = null;
            var data;
            if (id) {
                data = $("#" + id).serialize();
            } else {
                data = '';
            }
            if (parameter && typeof parameter === "object") {
                data += ("&" + $.param(parameter));
            }
            ajax(url, data, isShowMask, _mask, success, error, async);
        }

        /**
         * 同步提交
         * @param formId
         * @param onSubmit
         * @param autoValidate
         * @param url
         * @param parameter
         * @returns {boolean}
         */
        function submitForm(formId, onSubmit, autoValidate, url, parameter) {
            var _mask = Base.showMask();
            var form;
            if (formId) {
                form = document.getElementById(formId);
            } else {
                Base.alert('传入formId为空');
                return false;
            }
            if (!form) {
                Base.alert('找不到需要提交的form元素');
                return false;
            }
            if (onSubmit && !onSubmit()) {
                if (_mask) Base.hideMask();
                return false;
            }
            if (autoValidate) {
                Base.validateForm(formId, function (yes) {
                    if (!yes) {
                        if (_mask) Base.hideMask();
                        return false;
                    } else {
                        if (parameter) {
                            url += "?" + $.param(parameter);
                        }
                        var $form = $(form);
                        if (url) {//ie8不识别form.action
                            $form.attr("action", url);
                        }
                        form.submit();
                    }
                });
            } else {
                if (parameter) {
                    url += "?" + $.param(parameter);
                }
                var $form = $(form);
                if (url) {//ie8不识别form.action
                    $form.attr("action", url);
                }
                form.submit();
            }
        }

        /**
         * 设置表格数据
         * </br>
         * id：表格id
         * </br>
         * data: 数据
         */
        function setGridData(id, data) {
            if (data && data.length > 0) {
                var opt = eval("opt_" + id);
                $("#" + id + "_nodata").hide();
                var $mainContent = $("#" + id);
                $mainContent.empty().css("display", "flex");
                // var codeTable = JSON.parse(sessionStorage.getItem("codeTable"));
                $.each(data, function (i, e) {
                    var appendHtml = [];
                    appendHtml.push('<div id="datarow_' + e[opt.rowId] + '" class="datagrid-item">');
                    appendHtml.push('<div class="item-content">');
                    $.each(opt.columns, function (index, item) {
                        var desc = e[item.id];
                        if (item.collection) {
                            var codeList = JSON.parse(sessionStorage.getItem(item.collection.trim().toUpperCase()));
                            if (codeList) {
                                for (var j = 0; j < codeList.length; j++) {
                                    var code = codeList[j];
                                    if (code.id == desc) {
                                        desc = code.name;
                                        break;
                                    }
                                }
                            }
                        }
                        appendHtml.push('<div class="item-row"><label>' + item.key + '</label><span>' + desc + '</span></div>');
                    });
                    if (opt.buttons.length > 0) {
                        appendHtml.push('<div class="opt-group">');
                        $.each(opt.buttons, function (index, item) {
                            appendHtml.push('<div class="');
                            if (item.cssClass) {
                                appendHtml.push(item.cssClass);
                            }
                            if (item.hasSeparation) {
                                appendHtml.push(' btn-separation');
                            }
                            appendHtml.push('" ');
                            if (item.onclick) {
                                appendHtml.push('onclick="');
                                appendHtml.push(item.onclick);
                                appendHtml.push('(\'');
                                appendHtml.push(e[opt.rowId]);
                                appendHtml.push('\')"');
                            }
                            appendHtml.push('>');
                            appendHtml.push(item.key);
                            appendHtml.push('</div>');
                        });
                        appendHtml.push('</div>');
                    }
                    appendHtml.push('</div>');
                    appendHtml.push('</div>');
                    $mainContent.append($(appendHtml.join('')).data("wui_rowdata", e));
                });
            } else {
                $("#" + id).empty().hide();
                $("#" + id + "_nodata").css("display", "flex");
            }
        }

        /**
         * 清空表格所有数据
         *   </br>
         * id：表格id
         */
        function clearGridData(id) {
            $("#" + id).empty().hide();
            $("#" + id + "_nodata").css("display", "flex");
        }

        /**
         * 获取表格所有数据
         *   </br>
         * id：表格id
         */
        function getGridData(id) {
            var result = [];
            var rows = $(".datagrid-item", "#" + id);
            if (rows && rows.length > 0) {
                $.each(rows, function (i, elt) {
                    result.push($(elt).data("wui_rowdata"));
                });
            }
            return result;
        }

        /**
         * 获取表格指定行数据
         * </br>
         * id：表格id
         * </br>
         * rowId: 行数据id
         */
        function getGridRowData(id, rowId) {
            return $("#datarow_" + rowId, "#" + id).data("wui_rowdata");
        }

        /**
         * 添加一行数据到数据表格
         * </br>
         * id：表格id
         * </br>
         * data: 数据
         */
        function addGridData(id, data) {
            if (data) {
                var opt = eval("opt_" + id);
                $("#" + id + "_nodata").hide();
                var $mainContent = $("#" + id);
                $mainContent.empty().css("display", "flex");
                var appendHtml = [];
                var codeTable = JSON.parse(sessionStorage.getItem("codeTable"));
                appendHtml.push('<div id="datarow_' + data[opt.rowId] + '" class="datagrid-item">');
                appendHtml.push('<div class="item-content">');
                $.each(opt.columns, function (index, item) {
                    var desc = data[item.id];
                    if (item.collection) {
                        var codeList = codeTable[item.collection];
                        if (codeList) {
                            for (var j = 0; j < codeList.length; j++) {
                                var code = codeList[j];
                                if (code.value == desc) {
                                    desc = code.label;
                                    break;
                                }
                            }
                        }
                    }
                    appendHtml.push('<div class="item-row"><label>' + item.key + '</label><span>' + desc + '</span></div>');
                });
                if (opt.buttons.length > 0) {
                    appendHtml.push('<div class="opt-group">');
                    $.each(opt.buttons, function (index, item) {
                        appendHtml.push('<div class="');
                        if (item.cssClass) {
                            appendHtml.push(item.cssClass);
                        }
                        if (item.hasSeparation) {
                            appendHtml.push(' btn-separation');
                        }
                        appendHtml.push('" ');
                        if (item.onclick) {
                            appendHtml.push('onclick="');
                            appendHtml.push(item.onclick);
                            appendHtml.push('(\'');
                            appendHtml.push(data[opt.rowId]);
                            appendHtml.push('\')"');
                        }
                        appendHtml.push('>');
                        appendHtml.push(item.key);
                        appendHtml.push('</div>');
                    });
                    appendHtml.push('</div>');
                }
                appendHtml.push('</div>');
                appendHtml.push('</div>');
                $mainContent.append($(appendHtml.join('')).data("wui_rowdata", data));
            }
        }

        /**
         * 删除表格指定数据
         * </br>
         * id：表格id
         * </br>
         * rowId: 行数据id
         */
        function deleteGridData(id, rowId) {
            var datagrid = $("#" + id);
            $("#datarow_" + rowId, datagrid).remove();
            if ($(".datagrid-item", datagrid).length <= 0) {
                datagrid.hide();
                $("#" + id + "_nodata").css("display", "flex");
            }
        }

        /**
         * 码表转换为weui格式数据
         * @param codeList
         * @returns {Array}
         */
        function parseCodeList(codeList) {
            let code = [];
            let map;
            let listElement;
            if (codeList) {
                for (let i = 0, len = codeList.length; i < len; i++) {
                    map = {};
                    listElement = codeList[i];
                    if (listElement.id && listElement.name) {
                        map.value = listElement.id;
                        map.title = listElement.name;
                    } else {
                        map = listElement;
                    }
                    code.push(map);
                }
                return code;
            }
        }

        /**
         * 加载码表缓存
         */
        function loadCodeTable() {
            Base.submit("", Base.serverPath + "/codeTable/codeTable!query.do", null, null, false, function (data) {
                if (JSON.stringify(data) != "{}") {
                    for (let i in data) {
                        let codeList = JSON.stringify(data[i]);
                        sessionStorage.setItem(i, codeList);
                    }
                }
            }, null, false,);
        }

        /**
         * 脱敏
         * @param value
         * @param type
         * @returns {*}
         */
        function desensitization(value, type) {
            if (this.isEmpty(value)) {
                return "";
            }
            let value_dest = value;
            let length = value.length;
            if ("name" == type) {
                if (length === 4) {
                    value_dest = replaceBetween(value, 0, 2);
                } else {
                    value_dest = replaceBetween(value, 0, 1);
                }
            }
            if ("bank" == type) {
                value_dest = replaceBetween(value, 6, length - 4);
            }
            if ("idCard" == type) {
                value_dest = replaceBetween(value, 6, length - 4);
            }
            if ("email" == type) {
                //邮箱账号名只显示前两位
                let at_position = value.indexOf("@");
                value_dest = value.substring(0, at_position);
                if (at_position > 2) {
                    value_dest = replaceBetween(value_dest, 2, at_position);
                }
                //邮箱域名隐藏
                value_dest += replaceBetween(value.substring(at_position), 1, value.substring(at_position).lastIndexOf("."));
            }
            if ("phone" == type) {
                if (length >= 11) {
                    value_dest = replaceBetween(value, 3, length - 4);
                } else {
                    value_dest = replaceBetween(value, 0, length - 4);
                }
            }
            if ("zipCode" == type) {
                value_dest = replaceBetween(value, 2, 6);
            }
            return value_dest;

            function replaceBetween(str, beginLen, endLen) {
                var firstStr = str.substr(0, beginLen);
                var lastStr = str.substr(endLen);
                var middleStr = '';
                for (let i = 0; i < endLen - beginLen; i++) {
                    middleStr += '*';
                }
                let tempStr = firstStr + middleStr + lastStr;
                return tempStr;
            }
        }

        /**
         * 获取当前日期字符串
         * @param rex 格式，如/或者-
         * @returns {*}
         */
        function getNowDateStr(rex) {
            var today = new Date();
            var month = today.getMonth() + 1;
            month = month < 10 ? '0' + month : month;
            var day = today.getDate() < 10 ? '0' + today.getDate() : today.getDate();
            return today.getFullYear() + rex + month + rex + day;
        }

        /**
         * 身份证15to18
         * @param sId
         * @returns {*}
         */
        function idcard218(sId) {
            if (sId.length == 15) {
                if (!/^\d{14}(\d|x)$/i.test(sId)) {
                    this.message = "你输入的身份证长度或格式错误";
                    return false;
                } else {
                    sId = sId.substr(0, 6) + '19' + sId.substr(6, 9)
                    sId += getVCode(sId);
                }
            }

            function getVCode(CardNo17) {
                let Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1];
                let Ai = ['1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'];
                let cardNoSum = 0;
                for (let i = 0; i < CardNo17.length; i++) cardNoSum += CardNo17.charAt(i) * Wi[i];
                let seq = cardNoSum % 11;
                return Ai[seq];
            }

            return sId;
        }

        /***
         * 获取码表描述值（对应CdsiAppCode中的码表值）
         * @param codeValue code值
         * @param codeType 码表
         */
        function getCodeDesc(codeValue, codeType) {
            codeType = codeType.trim().toUpperCase();
            let codeListStr = sessionStorage.getItem(codeType);
            if (Base.isEmpty(codeListStr)) {
                return "";
            }
            let codeList = JSON.parse(codeListStr);
            for (let index in codeList) {
                if (codeList[index].id == codeValue) {
                    return codeList[index].name;
                }
            }
            return "";
        }

        /**
         * 设置当前容器下所有输入框的值，可用于提交前值变化判断（包括文本域textarea）
         * @param id
         */
        function setOldInputValue(id) {
            var oldInputValue = {};
            let dom;
            if (id == null) {
                dom = $("input").add("textarea");
            } else {
                dom = $("#" + id).find("input").add("textarea");
            }
            dom.each(function () {
                //需要提交的数据才记录
                if ($(this).attr("name") != undefined) {
                    let id = $(this).attr("name");
                    oldInputValue[id] = $(this).val();
                }
            });
            Base.oldInputValue = oldInputValue;
            return oldInputValue;
        }

        /**
         * 检查当前容器内input值与之前设置值变化情况（包括文本域textarea）
         * @param id 容器id
         * @returns {Array}
         */
        function checkInputChange(id) {
            let dom;
            if (id == null) {
                dom = $("input").add("textarea");
            } else {
                dom = $("#" + id).find("input").add("textarea");
            }
            let changeData = [];
            dom.each(function () {
                if ($(this).attr("name") != undefined) {
                    let id = $(this).attr("name");
                    let value = $(this).val();
                    if (Base.oldInputValue) {
                        let oldInputValue = Base.oldInputValue;
                        for (let key in oldInputValue) {
                            if (key == id && value != oldInputValue[key]) {
                                let data = {id: key, oldValue: oldInputValue[key], value: value};
                                changeData.push(data);
                            }
                        }
                    }
                }
            });
            if (changeData.length == 0) {
                return null;
            }
            return changeData;
        }
    }
}(Zepto));

/**
 * 文本域输入长度限制
 * @param input
 */
function textarea(input) {
    var content = $(input);
    var max = content.next().find('i').text();
    var value = content.val();
    if (value.length > 0) {
        value = value.replace(/\n|\r/gi, "");
        var len = value.length;
        content.next().find('span').text(len);
        if (len > max) {
            content.next().addClass('f-red');
        } else {
            content.next().removeClass('f-red');
        }
    }else{
        content.next().find('span').text(0);
    }
}
