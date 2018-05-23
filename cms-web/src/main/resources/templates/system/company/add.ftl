<div class="row">
    <div class="col-md-12">
        <form id="securityAddForm">
            <div class="modal-body">
                <div class="form-group">
                    <label id="userNoLabel">编码</label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="输入账号...">
                </div>
                <div class="form-group">
                    <label id="passwordLabel">公司名称</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="输入密码...">
                </div>
                <div class="form-group">
                    <label id="nickNameLabel">简称</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="输入昵称...">
                </div>
                <div class="form-group">
                    <label id="nickNameLabel">地址</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="输入昵称...">
                </div>
                <div class="form-group">
                    <label id="nickNameLabel">城市邮编</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="输入昵称...">
                </div>
            </div>
            <div class="modal-footer">
                <div class="pull-right">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i
                            class="fa fa-close"></i>关闭
                    </button>
                    <button type="button" class="btn btn-primary btn-sm" onclick="securitySave();"><i
                            class="fa fa-save"></i>保存
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    function securitySave() {
        // $("span").remove(".errorClass");
        // $("br").remove(".errorClass");
        if($("#securityAddForm").valid()){
            $.ajax({
                url: '/user/save',
                type: 'post',
                dataType: 'text',
                data: $("#securityAddForm").serialize(),
                success: function (data) {
                    var json = JSON.parse(data);
                    if (json.status) {
                        $("#lgModal").modal('hide');
                        alertMsg("添加成功", "success");
                        reloadTable(list_ajax, "#roleTime", "#rolePremise");
                    } else {
                        alertMsg("添加失败:" + json.msg, "success");
                    }
                }
            }
        });
        $("#securityAddForm").validate(
        {
            errorClass: 'text-danger',
            errorElement: "span"
        });
    }
</script>