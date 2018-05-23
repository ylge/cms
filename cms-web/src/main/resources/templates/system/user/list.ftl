<script type="text/javascript">
    $(function () {
        //初始化时间选择器
        $('#startDate').datepicker({
            language: 'zh-CN',
            format: 'yyyy-mm-dd',
            autoclose: true,
            todayHighlight: true
        });
    });
</script>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">用户管理</h3>

                <div class="box-tools pull-left">
                <@shiro.hasPermission name="system/user/add">
                    <a onclick="securityToListAjax();" class="btn btn-sm btn-primary" target="modal" modal="lg"
                       href="system/user/add">添加</a>
                </@shiro.hasPermission>
                    <a class="btn btn-sm btn-primary" href="system/user/exportExcel">导出</a>
                </div>
            </div>
            <div class="box-body">
                <div class="box-group">
                    <div class="col-md-4">
                        <div class="input-group date ">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" class="form-control pull-right" id="startDate" placeholder="选择开始时间...">
                        </div>
                    </div>
                <#--<div class="col-md-4">
                    <div class="input-group date ">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <input type="text" class="form-control pull-right" id="endDate" placeholder="选择结束时间...">
                    </div>
                </div>-->
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" class="form-control" id="username" placeholder="根据账号搜索...">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" class="form-control" id="roleId" placeholder="根据角色搜索...">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <button type="submit" onclick="securityReload();" class="btn btn-primary">搜索</button>
                    </div>
                </div>
                <table id="security_tab" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                    <tr>
                        <th>序号</th>
                        <th>账号</th>
                        <th>昵称</th>
                        <th>状态</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </tr>
                    </thead>
                    <tbody>
                        <#if page?? && page.list?? && (page.list?size > 0) >
                            <#list page.list as n>
                                <tr>
                                    <td>${n.userId }</td>
                                    <td>${n.username }</td>
                                    <td>${n.name }</td>
                                    <td>${n.status}</td>
                                    <td>${n.name}</td>
                                    <td class="text-right text-nowrap">
                                        <div class="btn-group ">
                                        <#--<button class="btn btn-white btn-sm edit" data-id="${n.id }" data-toggle="modal"
                                                    data-target="#edit">
                                                <i class="fa fa-pencil"></i> 编辑
                                            </button>-->
                                        </div>
                                    </td>
                                </tr>
                            </#list>
                        <#else>
                            <tr>
                                <td colspan="8">没有记录</td>
                            </tr>
                        </#if>
                    </tbody>
                </table>
                <div id="pager">
                <#import "../../common/page.ftl" as p>
                    <!--#if recordCount??-->
                <@p.pager pageNo=page.pageNum pageSize=page.pageSize recordCount=page.total pageCount=page.size toURL="system/user/list" method="get"/>
                    <!--/#if-->
                </div>
            </div>
        </div>
    </div>
</div>
