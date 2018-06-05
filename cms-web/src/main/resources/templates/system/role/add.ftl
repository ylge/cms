<form id="roleAddForm">
    <div class="modal-body">
        <div class="form-group">
            <label id="userNoLabel">账号</label>
            <input type="text" class="form-control" name="name" placeholder="角色名称..."
                   required>
        </div>
        <div class="form-group">
            <label id="phoneLabel">备注</label>
            <input type="text" class="form-control" name="remark" placeholder="描述...">
        </div>
    </div>
    <div class="modal-footer">
        <div class="pull-right">
            <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i
                    class="fa fa-close"></i>关闭
            </button>
            <button type="button" class="btn btn-primary btn-sm" onclick="roleSave();"><i
                    class="fa fa-save"></i>保存
            </button>
        </div>
    </div>
</form>
<script type="text/javascript">
    function roleSave() {
        if ($("#roleAddForm").valid()) {
            $.ajax({
                url: 'system/role/save',
                type: 'put',
                dataType: 'json',
                data: $("#roleAddForm").serialize(),
                success: function (data) {
                    if (data.code == 200) {
                        $("#lgModal").modal('hide');
                        alertMsg("添加成功", "success");
                        reloadTable(list_ajax);
                    } else {
                        alertMsg("添加失败:" + data.msg, "success");
                    }
                }
            });
        }
        $("#roleAddForm").validate({
            errorClass: 'text-danger',
            errorElement: "span"
        });
    }
</script>