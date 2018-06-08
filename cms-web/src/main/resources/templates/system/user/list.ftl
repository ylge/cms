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
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var user_tab;
    $(function () {
        user_tab=$('#user_tab').bootstrapTable({
            // height : tableModel.getHeight(),
            url: "system/user/page",
            method: 'get',
            striped: true,                      //是否显示行间隔色
            pagination: true, //分页
            queryParams: queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            columns: [
                {title: "ID", field: "userId"},
                {title: "帐号", field: "username"},
                {title: "昵称", field: "name"},
                {title: "状态", field: "status", formatter: tableModel.getState},
                {title: "创建时间", field: "createTime", sortable: true},
                {title: "操作", field: "operate", align: 'center',formatter: operateFormatter}
            ]
        });
    });
    function operateFormatter(value, row, index) {
        return [
            <@shiro.hasPermission name="system/user/edit">,
            '<a href="system/user/edit/'+row.userId+'" >',
            '<i class="glyphicon glyphicon-edit"></i>修改',
            '</a>  ',
            </@shiro.hasPermission>,
            <@shiro.hasPermission name="system/user/delete">,
            '<a callback="userReload();" data-body="确认要删除吗？" target="ajaxTodo" href="system/user/delete/'+row.userId+'">',
            '<i class="glyphicon glyphicon-trash"></i>删除',
            '</a>',
            </@shiro.hasPermission>
        ].join('');
    }
    function userToListAjax() {
        list_ajax = user_tab;
    }

    function queryParams(params) {
        console.log(params);
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //偏移量
            order: params.order,  //排序方式
            sort: params.sort,  //排序字段
            username: $("#username").val()
        };
        return temp;
    }

    function userReload() {
        reloadTable(user_tab);
    }
</script>
