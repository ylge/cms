var tableModel = (function () {
    return {
        getHeight: function () {
            return $(window).height() - $('.content-header').outerHeight(true);
        },
        getState: function (value, row, index) {
            return value == 1 ? "启用" : "禁用";
        }
    }
})();

//每次隐藏modal 清理内容
$("#lgModal").on("hide.bs.modal", function () {
    $(this).removeData("bs.modal");
    $(".modal-body").children().remove();
});

//表单刷新
var list_ajax;
var date_ajax;
//当你需要多条件查询，你可以调用此方法，动态修改参数传给服务器
//查询添加的时候需要重写该方法，每个页面查询参数不一样，请参考user/list 葛永亮 2017-9-14
window.reloadTable = function (oTable, opt) {
    oTable.bootstrapTable('refresh', opt);
};

/*
function onClickCheckbox(clickName, target) {
    var status = false;
    if (document.getElementById(clickName).checked) {
        status = true;
    }
    var list = document.getElementsByName(target);
    for (var i = 0; i < list.length; i++) {
        list[i].checked = status;
    }
}
*/

/*function iFrameHeight() {
    var ifm = document.getElementById("content");
    var subWeb = document.frames ? document.frames["content"].document : ifm.contentDocument;
    if (ifm != null && subWeb != null) {
        ifm.height = subWeb.body.scrollHeight;
    }
}*/

(function () {
    //全局ajax处理
    $.ajaxSetup({
        complete: function (jqXHR) {
        },
        data: {},
        error: function (jqXHR, textStatus, errorThrown) {
        }
    });

    if ($.browser && $.browser.msie) {
        //ie 都不缓存
        $.ajaxSetup({
            cache: false
        });
    }

    //不支持placeholder浏览器下对placeholder进行处理
    if (document.createElement('input').placeholder !== '') {
        $('[placeholder]').focus(function () {
            var input = $(this);
            if (input.val() == input.attr('placeholder')) {
                input.val('');
                input.removeClass('placeholder');
            }
        }).blur(function () {
            var input = $(this);
            if (input.val() == '' || input.val() == input.attr('placeholder')) {
                input.addClass('placeholder');
                input.val(input.attr('placeholder'));
            }
        }).blur().parents('form').submit(function () {
            $(this).find('[placeholder]').each(function () {
                var input = $(this);
                if (input.val() == input.attr('placeholder')) {
                    input.val('');
                }
            });
        });
    }

    var ajaxForm_list = $('form.js-ajax-form');
    if (ajaxForm_list.length) {
        var $btn;
        $('button.js-ajax-submit').on('click', function (e) {
            var btn = $(this);
            var form = btn.parents('form.js-ajax-form');
            $btn = btn;

            if (btn.data("loading")) {
                return;
            }

            //ie处理placeholder提交问题
            if ($.browser && $.browser.msie) {
                form.find('[placeholder]').each(function () {
                    var input = $(this);
                    if (input.val() == input.attr('placeholder')) {
                        input.val('');
                    }
                });
            }
        });

        ajaxForm_list.each(function () {
            $(this).validate({
                debug: true,
                //是否在获取焦点时验证
                //onfocusout : false,
                //当鼠标掉级时验证
                //onclick : false,
                //给未通过验证的元素加效果,闪烁等
                //highlight : false,
                onkeyup: function (element, event) {
                    return;
                },
                showErrors: function (errorMap, errorArr) {
                    if (parseInt(errorArr.length) > 0) {
                        $(errorArr[0].element).focus();
                        layer.msg(errorArr[0].message, {icon: 2});
                    }
                },
                submitHandler: function (form) {
                    var $form = $(form);
                    $form.ajaxSubmit({
                        url: $btn.data('action') ? $btn.data('action') : $form.attr('action'),
                        dataType: 'json',
                        beforeSubmit: function (arr, $form, options) {
                            $btn.data("loading", true);
                            var text = $btn.text();
                            $btn.text(text + '中...').prop('disabled', true).addClass('disabled');
                        },
                        success: function (data, statusText, xhr, $form) {
                            var text = $btn.text();
                            $btn.removeClass('disabled').prop('disabled', false).text(text.replace('中...', '')).parent().find('span').remove();
                            if (data.state === 'success') {
                                layer.msg(data.msg, {icon: 1}, function () {
                                    if (data.referer) {
                                        operaModel.redirect(data.referer);//返回带跳转地址
                                    } else {
                                        if (data.state === 'success') {
                                            operaModel.reloadPage(window);//刷新当前页
                                        }
                                    }
                                });
                            } else if (data.state === 'error') {
                                layer.msg(data.msg, {icon: 2});
                            }
                        },
                        error: function (xhr, e, statusText) {
                            console.log(statusText);
                            operaModel.reloadPage(window);//刷新当前页
                        },
                        complete: function () {
                            $btn.data("loading", false);
                        }
                    });
                }
            });
        });
    }
})();