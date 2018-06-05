<form id="userAddForm">
    <div class="modal-body">
        <div class="form-group">
            <label id="userNoLabel">账号</label>
            <input type="text" class="form-control" name="username" placeholder="输入账号..."
                   required>
        </div>
        <div class="form-group">
            <label id="passwordLabel">密码</label>
            <input type="password" class="form-control" name="password" placeholder="输入密码..."
                   required>
        </div>
        <div class="form-group">
            <label id="nickNameLabel">昵称</label>
            <input type="text" class="form-control" name="name" placeholder="输入昵称..." required>
        </div>
        <div class="form-group">
            <label id="phoneLabel">手机号码</label>
            <input type="text" class="form-control" name="phone" placeholder="输入手机号码..."
                   required>
        </div>
        <div class="form-group">
            <label>角色：</label>
            <select name="roles" id="roles" class="selectpicker form-control" multiple data-max-options="4" data-live-search="true">
                <#if roles??>
                    <#list roles as role>
                        <#if (role.value) ??>
                            <@shiro.hasRole name="admin">
                                <option value="${role.roleId}">${role.name}</option>
                            </@shiro.hasRole>
                        <#else>
                            <option value="${role.roleId}">${role.name}</option>
                        </#if>
                    </#list>
                </#if>
            </select>
        </div>
    </div>
    <div class="modal-footer">
        <div class="pull-right">
            <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i
                    class="fa fa-close"></i>关闭
            </button>
            <button type="button" class="btn btn-primary btn-sm" onclick="userSave();"><i
                    class="fa fa-save"></i>保存
            </button>
        </div>
    </div>
</form>
<script type="text/javascript">
    $(".selectpicker").selectpicker({
        noneSelectedText: '请选择',
        countSelectedText: function(){}
    });
    function userSave() {
        if ($("#userAddForm").valid()) {
            $.ajax({
                url: 'system/user/save',
                type: 'put',
                dataType: 'json',
                data: $("#userAddForm").serialize(),
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
        $("#userAddForm").validate({
            errorClass: 'text-danger',
            errorElement: "span"
        });
    }
</script>