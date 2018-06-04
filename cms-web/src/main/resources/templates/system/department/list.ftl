<div class="row">
    <div class="box">
        <div class="box-header">
            <h3 class="box-title">部门管理</h3>
        </div>
        <div class="box-body">
            <div class="row">
                <div class="col-md-4">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                        <input type="text" class="form-control" id="companyName" placeholder="根据公司名称搜索...">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                        <input type="text" class="form-control" id="name" placeholder="根据部门名称搜索...">
                    </div>
                </div>
                <div class="col-md-4">
                    <button type="button" onclick="departmentReload()" class="btn btn-primary">搜索</button>
                        <@shiro.hasPermission name="system/department/add">
                        <a class="btn btn-primary" onclick="departmentToListAjax()" target="modal"
                           href="system/department/add">添加</a>
                        </@shiro.hasPermission>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <table id="department_tab" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>部门名称</th>
                            <th>所属公司</th>
                            <th>描述</th>
                            <th>状态</th>
                            <th>创建时间</th>
                            <th>创建人</th>
                            <th>修改时间</th>
                            <th>修改人</th>
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
    var department_tab;
    $(function () {
        department_tab = $('#department_tab').DataTable({
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
                "url": "system/department/page",
                "dataType": "json",
                "type": "post",
                "data": function (d) {
                    d.name = $('#name').val();
                    d.companyName = $('#companyName').val();
                }
            },
            "columns": [
                {"data": "departmentId"},
                {"data": "name"},
                {"data": "companyName"},
                {"data": "comment"},
                {"data": null},
                {"data": "createTime"},
                {"data": "createBy"},
                {"data": "updateTime"},
                {"data": "updateBy"},
                {"data": null}
            ],
            "columnDefs": [
                {
                    targets: 4,
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
                        var btn = '<a class="btn btn-xs btn-primary" target="modal" onclick="departmentToListAjax()" modal="lg" href="system/department/view/' + data.departmentId + '">查看</a> &nbsp;'
                                + '<@shiro.hasPermission name="system/department/edit">'
                                + '<a class="btn btn-xs btn-info" data-title="修改" onclick="departmentToListAjax()" target="modal" modal="lg" href="system/department/edit/' + data.departmentId + '">修改</a> &nbsp;'
                                + '</@shiro.hasPermission>'
                                + '<@shiro.hasPermission name="system/department/delete">'
                                + '<a class="btn btn-xs btn-default" callback="securityReload();" data-body="确认要删除吗？" target="ajaxTodo" href="system/department/delete/' + data.departmentId + '">删除</a>'
                                +'</@shiro.hasPermission>';
                        return btn;
                    }
                }]
        })
    });

    function departmentToListAjax() {
        list_ajax = department_tab;
    }

    function departmentReload() {
        reloadTable(department_tab);
    }
</script>
