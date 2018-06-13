<form id="roleUpdateForm">
    <div class="modal-body">
        <input type="hidden" id="roleId" value="${role.roleId}">
        <div class="form-group">
            <label id="userNoLabel">账号</label>
            <input type="text" class="form-control" value="${role.name}" name="name" placeholder="角色名称..."
                   required>
        </div>
        <div class="form-group">
            <label id="phoneLabel">备注</label>
            <input type="text" class="form-control" value="${role.remark!}" name="remark" placeholder="描述...">
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
        $.post('/system/role/grant', , function (data) {
            if (data.code === 200) {
                $("#lgModal").modal('hide');
            }
            reloadTable(list_ajax);
            $('#menuTree').treeview();
            alertMsg(data.msg, "success");
        })
    }
</script>
