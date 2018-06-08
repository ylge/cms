<div class="row">
    <div class="box">
        <div class="box-header">
            <h3 class="box-title">菜单管理</h3>
        </div>
        <div class="box-body">
            <div class="row">
                <div class="col-sm-12">
                    <table id="menu_tab" class="table table-bordered">
                        <thead>
                        <tr>
                            <th>菜单名称</th>
                            <th>菜单URL</th>
                            <th>菜单类型</th>
                            <th>排序</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#if menus?? && (menus?size > 0) >
                                <#list menus as menu>
                                    <tr id="tr_${menu.id}" class="<#if menu.parentId==0>treegrid-${menu.id}<#else >treegrid-${menu.id} treegrid-parent-${menu.parentId} </#if>">
                                        <td>${menu.name }</td>
                                        <td>${menu.url }</td>
                                        <td><#if menu.isMenu==1>菜单<#else>按钮</#if></td>
                                        <td><input type="text" name="sort" value="${menu.sort}" id="${menu.id}" style="width:30px"/></td>
                                        <td>${menu.createTime?string('yyyy-MM-dd hh:mm:ss')}</td>
                                        <td class="text-left text-nowrap">
                                            <div class="btn-group ">
                                                <a class="btn btn-xs btn-info" target="modal"
                                                   href="/system/menu/add/${menu.id}">添加</a>
                                                <#if menu.id!=1>
                                                    <a class="btn btn-xs btn-info" target="modal"
                                                       href="/system/menu/edit/${menu.id}">修改</a>
                                                <a class="btn btn-xs btn-default" callback="menuReload('tr_${menu.id}')"
                                                   data-body="确认要删除吗？" target="ajaxTodo"
                                                   href="/system/menu/delete/${menu.id}">删除</a>
                                                </#if>
                                            </div>
                                        </td>
                                    </tr>
                                </#list>
                            </#if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $(".table").treegrid({
            expanderExpandedClass: 'glyphicon glyphicon-minus',
            expanderCollapsedClass: 'glyphicon glyphicon-plus'
        });
    });
    //更新排序
    $("input[name=sort]").on('keyup',function () {
        var _id = $(this).attr("id");
        var _sort = $(this).val();
        if(_sort!==''){
            $.post( '/system/menu/save',{
                id: _id,
                sort: _sort
            },function (data) {
                if(data.code===200){
                    alert("修改成功");
                }
            });
        }
    });
    function menuReload(data){
        $("#"+data).hide();
    }
</script>