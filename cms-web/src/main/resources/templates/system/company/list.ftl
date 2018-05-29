<script type="text/javascript">
</script>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">公司管理</h3>

                <div class="box-tools pull-left">
                <@shiro.hasPermission name="system/company/add">
                    <a class="btn btn-sm btn-primary" target="modal" modal="lg"
                       href="system/company/add">添加</a>
                </@shiro.hasPermission>
                </div>
            </div>
            <div class="box-body">
                <div class="clearfix">
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" class="form-control" id="name" placeholder="根据公司名称搜索...">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-primary">搜索</button>
                    </div>
                </div>
                <table id="security_tab" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                    <tr>
                        <th>序号</th>
                        <th>公司名称</th>
                        <th>公司编码</th>
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
                                <td>${n.companyId }</td>
                                <td>${n.name }</td>
                                <td>${n.code }</td>
                                <td>${n.status}</td>
                                <td>${n.createTime}</td>
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
                <@p.pager pageNo=page.pageNum pageSize=page.pageSize recordCount=page.total pageCount=page.size toURL="system/company/list" method="get"/>
                    <!--/#if-->
                </div>
            </div>
        </div>
    </div>
</div>
