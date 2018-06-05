<div class="row">
    <div class="box">
        <div class="box-header">
            <h3 class="box-title">用户管理</h3>
        </div>
        <div class="box-body">
            <div class="row">
                <div class="col-md-4">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                        <input type="text" class="form-control" id="username" placeholder="根据账号搜索...">
                    </div>
                </div>
                <div class="col-md-4">
                    <button type="button" onclick="userReload()" class="btn btn-primary">搜索</button>
                        <@shiro.hasPermission name="system/user/add">
                            <a class="btn btn-primary" onclick="userToListAjax()" target="modal"
                               href="system/user/add">添加</a>
                        </@shiro.hasPermission>
                    <a class="btn btn-primary" href="system/user/exportExcel">导出</a>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <table id="user_tab" class="table table-bordered table-striped dataTable">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>账号</th>
                            <th>昵称</th>
                            <th>状态</th>
                            <th>创建时间</th>
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
        user_tab = $('#user_tab').DataTable({
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
                "url": "system/user/page",
                "dataType": "json",
                "type": "post",
                "data": function (d) {
                    d.username = $('#username').val();
                }
            },
            "columns": [
                {"data": "userId"},
                {"data": "username"},
                {"data": "name"},
                {"data": null},
                {"data": "createTime"},
                {"data": null}
            ],
            "columnDefs": [
                {
                    targets: 3,
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
                        var btn = '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="system/user/view/' + data.id + '">查看</a> &nbsp;';
                        btn += '<@shiro.hasPermission name="system/user/edit">'
                                + '<a class="btn btn-xs btn-info" data-title="修改" target="modal" modal="lg" href="system/user/edit/' + data.id + '">修改</a> &nbsp;'
                                +'</@shiro.hasPermission>'
                                + '<@shiro.hasPermission name="system/user/edit">'
                                + '<a class="btn btn-xs btn-info" target="modal" modal="lg" href="system/user/goResetPwd/' + data.id + '">重置密码</a> &nbsp;'
                                +'</@shiro.hasPermission>'
                                + '<@shiro.hasPermission name="system/user/edit">'
                                + '<a class="btn btn-xs btn-info" target="modal" modal="lg" href="system/user/goDispatcherRole/' + data.id + '">角色分配</a> &nbsp;'
                                +'</@shiro.hasPermission>';
                                <#--+ '<@shiro.hasPermission name="system/user/delete">'-->
                                <#--+ '<a class="btn btn-xs btn-default" callback="userReload();" data-body="确认要删除吗？" target="ajaxTodo" href="system/user/delete/' + data.id + '">删除</a>'-->
                                <#--+'</@shiro.hasPermission>';-->
                        return btn;
                    }
                }]
        })
    });

    function userToListAjax() {
        list_ajax = user_tab;
    }

    function userReload() {
        reloadTable(user_tab);
    }
</script>
