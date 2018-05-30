<div class="row">
    <div class="col-md-12">
        <form id="securityAddForm">
            <div class="modal-body">
                <input type="hidden" name="parentId" value="${menu.id}">
                <input type="hidden" name="level" value="${menu.level+1}">
                <div class="form-group">
                    <label class="" id="nameLabel">菜单名称</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="输入菜单名称..." required>
                </div>
                <div class="form-group">
                    <label class="" id="urlLabel">请求地址</label>
                    <input type="text" class="form-control" name="url" id="url" placeholder="输入请求地址..." required>
                </div>
                <div class="form-group">
                    <label id="sortNameLabel">排序</label>
                    <input type="number" class="form-control" name="sort" id="sort" placeholder="输入排序..." required>
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
        if ($("#securityAddForm").valid()) {
            $.ajax({
                url: '/system/menu/save',
                type: 'put',
                dataType: 'json',
                data: $("#securityAddForm").serialize(),
                success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        alertMsg("添加成功", "success");
                        reloadMenuList();
                    } else {
                        alertMsg("添加失败:" + data.msg, "success");
                    }
                }
            });
        }
    }
    $("#securityAddForm").validate({
        errorClass: 'text-danger',
        errorElement: "span"
    });
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