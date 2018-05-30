<div class="row">
    <div class="box">
        <div class="box-header">
            <h3 class="box-title">公司管理</h3>
            <div class="box-tools pull-left">
                <#--<@shiro.hasPermission name="system/company/add">
                    <a class="btn btn-sm btn-primary" onclick="securityToListAjax()" target="modal" modal="lg"
                       href="system/company/add">添加</a>
                </@shiro.hasPermission>-->
            </div>
        </div>
        <div class="box-body">
            <div class="dataTables_wrapper form-inline dt-bootstrap">
                <div class="row">
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" class="form-control" id="name" placeholder="根据公司名称搜索...">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-primary">搜索</button>
                        <@shiro.hasPermission name="system/company/add">
                        <a class="btn btn-primary" onclick="securityToListAjax()" target="modal" modal="lg"
                           href="system/company/add">添加</a>
                        </@shiro.hasPermission>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <table id="company_tab" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th width="">序号</th>
                                <th>公司名称</th>
                                <th>公司简称</th>
                                <th>公司编码</th>
                                <th>地址</th>
                            <#--<th>城市编码</th>-->
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
</div>
<script type="text/javascript">
    var company_tab;
    $(function () {
        company_tab = $('#company_tab').DataTable({
            "dom": '<"toolbar">rt<"bottom"ilp><"clear">',
            "processing": true,
            "searching": false,
            "serverSide": true, //启用服务器端分页
            "scrollCollapse": true,//滚动条
            "bSort": true, //是否启动各个字段的排序功能
            "bAutoWidth": true, //是否自适应宽度
            "language": {"url": "adminlte/plugins/datatables/language.json"},
            "ajax": {
                "url": "system/company/page",
                "dataType": "json",
                "type": "post",
                "data": function (d) {
                    d.name = $('#name').val();
                }
            },
            "columns": [
                {"data": "companyId"},
                {"data": "name"},
                {"data": "shortName"},
                {"data": "code"},
                {"data": "address"},
                // {"data": "cityCode"},
                {"data": null},
                {"data": "createTime"},
                {"data": "createBy"},
                {"data": null}
            ],
            "columnDefs": [
                {
                    targets: 5,
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
                        var btn = '<a class="btn btn-xs btn-primary" target="modal" onclick="securityToListAjax()" modal="lg" href="system/conmany/view/' + data.companyId + '">查看</a> &nbsp;'
                                + '<@shiro.hasPermission name="system/company/edit">'
                                + '<a class="btn btn-xs btn-info" data-title="修改" onclick="securityToListAjax()" target="modal" modal="lg" href="system/company/edit/' + data.companyId + '">修改</a> &nbsp;'
                                + '</@shiro.hasPermission>'
                                + '<@shiro.hasPermission name="system/company/delete">'
                                + '<a class="btn btn-xs btn-default" callback="securityReload();" data-body="确认要删除吗？" target="ajaxTodo" href="system/company/delete/' + data.companyId + '">删除</a>'
                                +'</@shiro.hasPermission>';
                        return btn;
                    }
                }]
        })
    });

    function securityToListAjax() {
        list_ajax = company_tab;
        console.log(list_ajax);
    }

    function securityReload() {
        reloadTable(company_tab);
    }
</script>
