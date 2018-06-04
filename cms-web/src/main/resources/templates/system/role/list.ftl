<div class="row">
    <div class="box">
        <div class="box-header">
            <h3 class="box-title">角色管理</h3>
        </div>
        <div class="box-body">
            <div class="row">
                <div class="col-md-4">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                        <input type="text" class="form-control" id="name" placeholder="根据角色名称搜索...">
                    </div>
                </div>
                <div class="col-md-4">
                    <button type="button" onclick="roleReload()" class="btn btn-primary">搜索</button>
                        <@shiro.hasPermission name="system/role/add">
                            <a class="btn btn-primary" onclick="roleToListAjax()" target="modal" modal="lg"
                               href="system/role/add">添加</a>
                        </@shiro.hasPermission>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <table id="role_tab" class="table table-bordered table-striped dataTable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>角色名称</th>
                            <th>状态</th>
                            <th>创建时间</th>
                            <th>创建人</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var user_tab;
    $(function () {
        //初始化时间选择器
        $('#startDate').datepicker({
            language: 'zh-CN',
            format: 'yyyy-mm-dd',
            autoclose: true,
            todayHighlight: true
        });
        user_tab = $('#role_tab').DataTable({
            "dom": "t<'row'<'col-xs-2'l><'col-xs-3'i><'col-xs-6'p>>",
            "processing": true,
            "searching": false,
            "serverSide": true, //启用服务器端分页
            "scrollY": "480",//滚动条y轴
            "bSort": false, //是否启动各个字段的排序功能
            "autoWidth": true, //是否自适应宽度
            // "bLengthChange" : true,//分页条数选择按钮
            // "pagingType": "full_numbers",//首页和尾页
            "language": {"url": "adminlte/plugins/datatables/language.json"},
            "ajax": {
                "url": "system/role/page",
                "dataType": "json",
                "type": "post",
                "data": function (d) {
                    d.name = $('#name').val();
                }
            },
            "columns": [
                {"data": "roleId"},
                {"data": "name"},
                {"data": null},
                {"data": "createTime"},
                {"data": "createBy"},
                {"data": null}
            ],
            "columnDefs": [
                {
                    targets: 2,
                    data: null,
                    render: function (data) {
                        if (data.status == 0) {
                            return "不可用";
                        }
                        if (data.status == 1) {
                            return "可用";
                        }
                        return "未知状态";
                    }
                },
                {
                    "targets": -1,
                    "data": null,
                    "render": function (data) {
                        var btn = '<@shiro.hasPermission name="system/role/edit">'
                                + '<a class="btn btn-xs btn-info" data-title="修改" target="modal" modal="lg" href="system/role/edit/' + data.id + '">修改</a> &nbsp;'
                                +'</@shiro.hasPermission>'
                                + '<@shiro.hasPermission name="system/role/delete">'
                                + '<a class="btn btn-xs btn-default" callback="roleReload();" data-body="确认要删除吗？" target="ajaxTodo" href="system/role/delete/' + data.id + '">删除</a>'
                                +'</@shiro.hasPermission>';
                        return btn;
                    }
                }]
        })
    });

    function roleToListAjax() {
        list_ajax = role_tab;
    }

    function roleReload() {
        reloadTable(role_tab);
    }
</script>
