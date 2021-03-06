<#macro menu>
<aside class="main-sidebar">
    <section class="sidebar">
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">主导航</li>
            <#if menuList??>
                <#list menuList as menu>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa ${menu.icon}"></i>
                            <span>${menu.name}</span>
                            <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                            </span>
                        </a>
                        <#if menu.child??>
                            <ul class="treeview-menu">
                                <#list menu.child as child>
                                    <li>
                                        <#if child.child??>
                                            <a href="#"
                                            <i class="fa fa-bars"></i>
                                            <span>${child.name}</span>
                                            <span class="pull-right-container">
                                                <i class="fa fa-angle-left pull-right"></i>
                                            </span>
                                            </a>
                                        <#else >
                                            <a target="navTab" href="${child.url}">
                                            <i class="fa fa-circle-o"></i>
                                            <span>${child.name}</span>
                                            </a>
                                        </#if>
                                        <#if child.child??>
                                            <ul class="treeview-menu">
                                                <#list child.child as child>
                                                    <li>
                                                        <a target="navTab" href="${child.url}">
                                                            <i class="fa fa-circle-o"></i> <span>${child.name}</span>
                                                        </a>
                                                    </li>
                                                </#list>
                                            </ul>
                                        </#if>
                                    </li>
                                </#list>
                            </ul>
                        </#if>
                    </li>
                </#list>
            </#if>
        </ul>
    </section>
</aside>
</#macro>

<#macro header>
<header class="main-header">
    <a href="#" class="logo">
    <#--<span class="logo-mini"><b>易乎社区CMS</b></span>-->
        <span class="logo-lg"><b>易乎社区CMS</b></span>
    </a>
    <nav class="navbar navbar-static-top">
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">切换导航</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="hidden-xs">${user.name!}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="user-header">
                            <img src="${user.avatar!'adminlte/dist/img/ehulogo.png'}" class="img-circle">
                            <p>
                                ${user.username!}
                                <small>${user.createTime?string('yyyy-MM-dd HH:mm:ss')}加入</small>
                            </p>
                        </li>
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="/user/goModifyPwd/${user.id}" target="modal" modal="lg"
                                   class="btn btn-default btn-flat">密码修改</a>
                            </div>
                            <div class="pull-right">
                                <a href="/logout" class="btn btn-default btn-flat">安全退出</a>
                            </div>
                        </li>
                    </ul>
                </li>
            <#--<li>
                <a href="#" data-toggle="control-sidebar">
                    <i class="fa fa-gears"></i>
                </a>
            </li>-->
            </ul>
        </div>
    </nav>
</header>
</#macro>

<#macro footer>
<footer class="main-footer">
    <div class="pull-right hidden-xs">
        <b>Version</b> 3.0.0
    </div>
    上海初瞳信息科技有限公司
</footer>
</#macro>

<#macro style>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="shortcut icon" type="image/x-icon" href="adminlte/dist/img/ehulogo.png">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="adminlte/plugins/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="adminlte/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
   folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="adminlte/dist/css/skins/_all-skins.min.css"
<!-- 以上为公共css -->

<!-- bootstrap datepicker -->
<link rel="stylesheet" href="adminlte/plugins/datepicker/datepicker3.css">
<!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet" href="adminlte/plugins/iCheck/all.css">
<!-- Bootstrap Color Picker -->
<link rel="stylesheet" href="adminlte/plugins/colorpicker/bootstrap-colorpicker.min.css">
<!-- Bootstrap time Picker -->
<link rel="stylesheet" href="adminlte/plugins/timepicker/bootstrap-timepicker.min.css">
<!-- Bootstrap select -->
<link rel="stylesheet" href="adminlte/plugins/bootstrap-select/bootstrap-select.min.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet" href="adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="adminlte/plugins/iCheck/flat/blue.css">

<link rel="stylesheet" href="adminlte/plugins/jquery-treegrid-master/css/jquery.treegrid.css"></link>
<!-- bootstrap slider -->
<link rel="stylesheet" href="adminlte/plugins/bootstrap-slider/slider.css">
<!-- bootstrap-table -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">
<#--bootstrap-iconpicker-->
<link rel="stylesheet" href="adminlte/plugins/bootstrap-iconpicker/bootstrap-iconpicker.min.css">
<!-- treeview-->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</#macro>

<#macro jsFile>
<!-- jQuery 2.2.3 -->
<script src="adminlte/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="adminlte/plugins/bootstrap/js/bootstrap.min.js"></script>
<#--<script src="adminlte/plugins/fastclick/fastclick.js"></script>-->
<!-- Slimscroll -->
<script src="adminlte/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- AdminLTE App -->
<script src="adminlte/dist/js/common.js"></script>
<script src="adminlte/dist/js/app.js"></script>
<!-- 以上JS为页面必须 -->

<!-- jQuery UI 1.11.bootstrap-select -->
<script src="adminlte/plugins/jQueryUI/jquery-ui.min.js"></script>
<script src="adminlte/plugins/jquery-treegrid-master/js/jquery.treegrid.min.js"></script>
<script src="adminlte/plugins/jquery-treegrid-master/js/jquery.treegrid.bootstrap3.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- iCheck -->
<script src="adminlte/plugins/iCheck/icheck.min.js"></script>
<!-- InputMask -->
<script src="adminlte/plugins/input-mask/jquery.inputmask.js"></script>
<script src="adminlte/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="adminlte/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- bootstrap datepicker -->
<script src="adminlte/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="adminlte/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<!-- bootstrap color picker -->
<script src="adminlte/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="adminlte/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- bootstrap select -->
<script src="adminlte/plugins/bootstrap-select/bootstrap-select.min.js"></script>
<script src="adminlte/plugins/bootstrap-select/i18n/defaults-zh_CN.js"></script>
<!-- Bootstrap slider -->
<script src="adminlte/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<!-- bootstrap-table -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
<#--bootstrap-iconpicker-->
<script type="text/javascript" src="adminlte/plugins/bootstrap-iconpicker/bootstrap-iconpicker-iconset-all.min.js"></script>
<script type="text/javascript" src="adminlte/plugins/bootstrap-iconpicker/bootstrap-iconpicker.min.js"></script>
<!-- validate-->
<script type="text/javascript" src="adminlte/plugins/validate/jquery.validate.js"></script>
<!-- treeview-->
<script type="text/javascript" src="adminlte/plugins/tree/treeview.js"></script>z
<script type="text/javascript" src="//cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>
</#macro>

<#macro setting>
<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
        <li>
            <a href="#control-sidebar-home-tab" data-toggle="tab">
                <i class="fa fa-home"></i>
            </a>
        </li>
        <li>
            <a href="#control-sidebar-settings-tab" data-toggle="tab">
                <i class="fa fa-gears"></i>
            </a>
        </li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <!-- Home tab content -->
        <div class="tab-pane" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">最近的活动</h3>
            <ul class="control-sidebar-menu">
                <li>
                    <a href="javascript:void(0)">
                        <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                        <div class="menu-info">
                            <h4 class="control-sidebar-subheading">我的生日</h4>

                            <p>四月二十四</p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <i class="menu-icon fa fa-user bg-yellow"></i>

                        <div class="menu-info">
                            <h4 class="control-sidebar-subheading">更新我的资料</h4>

                            <p>新手机号码 (+86)1234567890</p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                        <div class="menu-info">
                            <h4 class="control-sidebar-subheading">添加邮箱地址</h4>

                            <p>abc@roncoo.com</p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <i class="menu-icon fa fa-file-code-o bg-green"></i>

                        <div class="menu-info">
                            <h4 class="control-sidebar-subheading">写个256字的描述</h4>

                            <p>执行时间5秒</p>
                        </div>
                    </a>
                </li>
            </ul>
            <h3 class="control-sidebar-heading">任务进度</h3>
            <ul class="control-sidebar-menu">
                <li>
                    <a href="javascript:void(0)">
                        <h4 class="control-sidebar-subheading">
                            自定义模板的设计 <span class="label label-danger pull-right">70%</span>
                        </h4>

                        <div class="progress progress-xxs">
                            <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <h4 class="control-sidebar-subheading">
                            更新简历 <span class="label label-success pull-right">95%</span>
                        </h4>

                        <div class="progress progress-xxs">
                            <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <h4 class="control-sidebar-subheading">
                            获取积分 <span class="label label-warning pull-right">50%</span>
                        </h4>

                        <div class="progress progress-xxs">
                            <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <h4 class="control-sidebar-subheading">
                            后端框架 <span class="label label-primary pull-right">68%</span>
                        </h4>

                        <div class="progress progress-xxs">
                            <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <!-- Settings tab content -->
        <div class="tab-pane" id="control-sidebar-settings-tab">
            <form method="post">
                <h3 class="control-sidebar-heading">一般设置</h3>

                <div class="form-group">
                    <label class="control-sidebar-subheading"> 面板的使用报告 <input type="checkbox" class="pull-right"
                                                                              checked>
                    </label>

                    <p>有关此常规设置选项的一些信息</p>
                </div>
                <div class="form-group">
                    <label class="control-sidebar-subheading"> 允许邮件重定向 <input type="checkbox" class="pull-right"
                                                                              checked>
                    </label>

                    <p>其他可用的选项集</p>
                </div>
                <div class="form-group">
                    <label class="control-sidebar-subheading"> 在帖子中公开作者姓名 <input type="checkbox" class="pull-right"
                                                                                 checked>
                    </label>

                    <p>允许用户在博客帖子中显示自己的名字</p>
                </div>
                <h3 class="control-sidebar-heading">聊天设置</h3>

                <div class="form-group">
                    <label class="control-sidebar-subheading"> 显示我是否在线 <input type="checkbox" class="pull-right"
                                                                              checked>
                    </label>
                </div>
                <div class="form-group">
                    <label class="control-sidebar-subheading"> 关闭通知 <input type="checkbox" class="pull-right">
                    </label>
                </div>
                <div class="form-group">
                    <label class="control-sidebar-subheading"> 删除的聊天记录 <a href="javascript:void(0)"
                                                                          class="text-red pull-right">
                        <i class="fa fa-trash-o"></i>
                    </a>
                    </label>
                </div>
            </form>
        </div>
    </div>
</aside>
<div id="loading" class="loading-panel">
    <div class="box">
        <i class="fa fa-refresh fa-spin"></i> <span class="tip"> 正在加载 · · · </span>
    </div>
</div>
<div class="modal fade" id="smModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p>确认删除？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="lgModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <#--<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>-->
            <div class="modal-body">
                <p>确认删除？</p>
            </div>
        </div>
    </div>
</div>
</#macro>