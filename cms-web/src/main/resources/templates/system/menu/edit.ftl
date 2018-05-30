<div class="row">
    <div class="col-md-12">
        <form id="securityAddForm">
            <input type="text" hidden id="id" name="id" value="${menu.id}">
            <div class="modal-body">
                <div class="form-group">
                    <label class="" id="nameLabel">菜单名称</label>
                    <input type="text" class="form-control" name="name" id="name" value="${menu.name!}" placeholder="输入菜单名称...">
                </div>
                <div class="form-group">
                    <label class="" id="urlLabel">请求地址</label>
                    <input type="text" class="form-control" name="url" id="url" value="${menu.url!}" placeholder="输入请求地址...">
                </div>
                <div class="form-group">
                    <label id="nickNameLabel">排序</label>
                    <input type="text" class="form-control" name="sort" id="sort" value="${menu.sort!}" placeholder="输入排序...">
                </div>
                <div class="form-group">
                    <label id="nickNameLabel">图标</label>
                    <input type="text" class="form-control" name="icon" id="icon" value="${menu.icon!}" placeholder="输入图标...">
                </div>
                <div class="form-group">
                    <label>是否是菜单</label>
                    <select name="isMenu" class="form-control select2" style="width: 100%;">
                        <option <#if menu.isMenu==1> selected="selected"</#if> value="1">是</option>
                        <option <#if menu.isMenu==0> selected="selected"</#if>  value="0">否</option>
                    </select>
                </div>
            </div>
        </form>
    </div>
   <#-- <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
        <ul id="treeDemo" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
    </div>-->

</div>
<div class="modal-footer">
    <div class="pull-right">
        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
        <button type="button" class="btn btn-primary btn-sm" onclick="securitySave();"><i class="fa fa-save"></i>更新
        </button>
    </div>
</div>
<script type="text/javascript" src="other/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="other/zTree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript">
    function securitySave() {
        $.ajax({
            url: '/system/menu/update',
            type: 'put',
            dataType: 'json',
            data: $("#securityAddForm").serialize(),
            success: function (data) {
                if (data.code==200) {
                    // $("#lgModal").modal('hide');
                    alertMsg("更新成功", "success");
                    reloadMenuList();
                } else {
                    alertMsg("更新失败:" + data.msg, "success");
                }
            }
        });
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