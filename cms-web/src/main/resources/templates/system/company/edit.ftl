<div class="row">
    <div class="col-md-12">
        <form id="securityAddForm">
            <div class="modal-body">
                <input type="hidden" name="companyId" value="${company.companyId}">
                <div class="form-group">
                    <label>编码</label>
                    <input type="text" class="form-control" name="code" id="code" value="${company.code}" placeholder="输入公司编码..." required>
                </div>
                <div class="form-group">
                    <label>公司名称</label>
                    <input type="text" class="form-control" name="name" id="name" value="${company.name}" placeholder="输入公司名称..." required>
                </div>
                <div class="form-group">
                    <label>简称</label>
                    <input type="text" class="form-control" name="shortName" id="shortName" value="${company.shortName}" placeholder="输入简称..." required>
                </div>
                <div class="form-group">
                    <label>地址</label>
                    <input type="text" class="form-control" name="address" id="address" value="${company.address}" placeholder="输入地址..." required>
                </div>
                <div class="form-group">
                    <label>城市邮编</label>
                    <input type="text" class="form-control" name="cityCode" id="cityCode" value="${company.cityCode}" placeholder="输入邮编..." required>
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
        if ($("#securityAddForm").valid()) {
            $.ajax({
                url: 'system/company/save',
                type: 'put',
                dataType: 'json',
                data: $("#securityAddForm").serialize(),
                success: function (data) {
                    if (data.code==200) {
                        alertMsg("添加成功", "success");
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
</script>