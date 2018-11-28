<#--图片裁剪功能页-->
<div class="modal fade" id="imgModal" <#--aria-hidden="true"-->>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title text-primary">
                    <i class="fa fa-pencil"></i>
                    图片裁剪
                </h4>
            </div>
            <div class="modal-body">
                <p class="tip-info text-center">
                    未选择图片
                </p>
                <div class="img-container hidden">
                    <img src="" alt="" id="photo">
                </div>
                <div class="img-preview-box hidden">
                    <hr>
                    <span>150*150:</span>
                    <div class="img-preview img-preview-lg">
                    </div>
                    <span>100*100:</span>
                    <div class="img-preview img-preview-md">
                    </div>
                    <span>30*30:</span>
                    <div class="img-preview img-preview-sm">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <label class="btn btn-danger pull-left" for="photoInput">
                    <input type="file" class="sr-only" id="photoInput" accept="image/*">
                    <span>打开图片</span>
                </label>
                <button class="btn btn-primary" onclick="sendPhoto();">提交</button>
                <button class="btn btn-close" aria-hidden="true" onclick="closeModal()">取消</button>
            </div>
        </div>
    </div>
</div>
<#--图片裁剪-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/cropper/3.1.3/cropper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/cropper/3.1.3/cropper.min.js"></script>
<script type="text/javascript">
    //每次隐藏modal 清理内容
    $("#imgModal").on("hidden.bs.modal", function () {
        $(this).removeData("modal");
    });
    var initCropperInModal = function (img, input, modal) {
        var $image = img;
        var $inputImage = input;
        var $modal = modal;
        var options = {
            aspectRatio: 1, // 纵横比
            viewMode: 2,
            preview: '.img-preview' // 预览图的class名
        };
        // 模态框隐藏后需要保存的数据对象
        var saveData = {};
        var URL = window.URL || window.webkitURL;
        var blobURL;
        $modal.on('show.bs.modal', function () {
            // 如果打开模态框时没有选择文件就点击“打开图片”按钮
            if (!$inputImage.val()) {
                $inputImage.click();
            }
        }).on('shown.bs.modal', function () {
            // 重新创建
            $image.cropper($.extend(options, {
                ready: function () {
                    // 当剪切界面就绪后，恢复数据
                    if (saveData.canvasData) {
                        $image.cropper('setCanvasData', saveData.canvasData);
                        $image.cropper('setCropBoxData', saveData.cropBoxData);
                    }
                }
            }));
        }).on('hidden.bs.modal', function () {
            // 保存相关数据
            saveData.cropBoxData = $image.cropper('getCropBoxData');
            saveData.canvasData = $image.cropper('getCanvasData');
            // 销毁并将图片保存在img标签
            $image.cropper('destroy').attr('src', blobURL);
        });
        if (URL) {
            $inputImage.change(function () {
                var files = this.files;
                var file;
                if (!$image.data('cropper')) {
                    return;
                }
                if (files && files.length) {
                    file = files[0];
                    if (/^image\/\w+$/.test(file.type)) {

                        if (blobURL) {
                            URL.revokeObjectURL(blobURL);
                        }
                        blobURL = URL.createObjectURL(file);

                        // 重置cropper，将图像替换
                        $image.cropper('reset').cropper('replace', blobURL);

                        // 选择文件后，显示和隐藏相关内容
                        $('.img-container').removeClass('hidden');
                        $('.img-preview-box').removeClass('hidden');
                        $('#changeModal .disabled').removeAttr('disabled').removeClass('disabled');
                        $('#changeModal .tip-info').addClass('hidden');

                    } else {
                        window.alert('请选择一个图像文件！');
                    }
                }
            });
        } else {
            $inputImage.prop('disabled', true).addClass('disabled');
        }
    };

    /*var sendPhoto = function () {
        $('#photo').cropper('getCroppedCanvas', {
            width: 300,
            height: 300
        }).toBlob(function (blob) {
            // 转化为blob后更改src属性，隐藏模态框
            $('#storeLogo').attr('src', URL.createObjectURL(blob));
            $('#imgModal').modal('hide');
        });
    };*/

    var sendPhoto = function () {
        // 得到PNG格式的dataURL
        var photo = $('#photo').cropper('getCroppedCanvas', {
            width: 300,
            height: 300
        }).toBlob(function (blob) {
            var formData = new FormData();
            formData.append("file", blob, 'i.jpeg');
            $.ajax({
                url: 'file/upload', // 要上传的地址
                type: 'post',
                data: formData,
                processData: false,
                contentType: false,
                success: function (data) {
                    if (data.code == 200) {
                        // 将上传的头像的地址填入，为保证不载入缓存加个随机数
                        // $('#storeLogo').attr('src', data.data);
                        var id = $(".cropperImage").val();
                        $('#' + id).attr('src', data.data);
                        $('.' + id).val(data.data);
                        $('#imgModal').modal('hide');
                    } else {
                        alertMsg("上传失败:" + data.msg, "success");
                    }
                }
            });
        });
    };
    $(function () {
        initCropperInModal($('#photo'), $('#photoInput'), $('#imgModal'));
    });

    function closeModal() {
        $('#imgModal').modal('hide');
    }
</script>
<style>
    #photo {
        max-width: 100%;
        max-height: 350px;
    }

    .img-preview-box {
        text-align: center;
    }

    .img-preview-box > div {
        display: inline-block;;
        margin-right: 10px;
    }

    .img-preview {
        overflow: hidden;
    }

    .img-preview-box .img-preview-lg {
        width: 150px;
        height: 150px;
    }

    .img-preview-box .img-preview-md {
        width: 100px;
        height: 100px;
    }

    .img-preview-box .img-preview-sm {
        width: 50px;
        height: 50px;
        border-radius: 50%;
    }
</style>



