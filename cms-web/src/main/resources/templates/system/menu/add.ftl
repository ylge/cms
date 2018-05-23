<div class="row">
    <div class="col-md-12">
        <form id="securityAddForm">
            <div class="modal-body">
                <input type="text" hidden id="parentId" name="parentId" value="${parentId}">
                <div class="form-group">
                    <label class="" id="nameLabel">菜单名称</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="输入菜单名称...">
                </div>
                <div class="form-group">
                    <label class="" id="urlLabel">请求地址</label>
                    <input type="text" class="form-control" name="url" id="url" placeholder="输入请求地址...">
                </div>
                <div class="form-group">
                    <label id="sortNameLabel">排序</label>
                    <input type="number" class="form-control" name="sort" id="sort" placeholder="输入排序...">
                </div>
                <div class="form-group">
                    <label id="nickNameLabel">图标</label>
                    <input type="text" class="form-control" name="icon" id="icon" placeholder="输入图标...">
                </div>
                <div class="form-group">
                    <label>是否是菜单</label>
                    <select name="isMenu" class="form-control select2" style="width: 100%;">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="modal-footer">
    <div class="pull-right">
        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
        <button type="button" class="btn btn-primary btn-sm" onclick="securitySave();"><i class="fa fa-save"></i>保存
        </button>
    </div>
</div>
<script type="text/javascript">
    function securitySave() {
        $("span").remove(".errorClass");
        $("br").remove(".errorClass");
        var status = 1;
        if ($("#name").val() == "") {
            $("#nameLabel").prepend('<span class="errorClass" style="color:red">*菜单不能为空</span><br class="errorClass"/>');
            status = 0;
        }
        if ($("#url").val() == "") {
            $("#urlLabel").prepend('<span class="errorClass" style="color:red">*请求地址不能为空</span><br class="errorClass"/>');
            status = 0;
        }
        if($("#sort").val() == ""){
            $("#sortNameLabel").prepend('<span class="errorClass" style="color:red">*顺序编号不能为空</span><br class="errorClass"/>');
            status = 0;
        }
        if (status == 0) {
            return false;
        } else {
            $.ajax({
                url: '/system/menu/save',
                type: 'post',
                dataType: 'text',
                data: $("#securityAddForm").serialize(),
                success: function (data) {
                    var json = JSON.parse(data);
                    if (json.code==200) {
                        $("#lgModal").modal('hide');
                        alertMsg("添加成功", "success");
                        reloadMenuList();
                    } else {
                        alertMsg("添加失败:" + json.msg, "success");
                    }
                }
            });
        }
    }

    function hideMenu() {
        $("#menuContent").fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown);
    }
    function onBodyDown(event) {
        if (!(event.target.id == "menuBtn" || event.target.id == "pName" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length > 0)) {
            hideMenu();
        }
    }
</script>