#cms
>此项目后台管理的基础框架
##采用技术
    后台架构：Springboot + Mybatis + Freemarker 
    权限控制 Shiro
    分页查询 PageHelper
    数据库 Mysql
    页面展示 AdminLTE + BootStrap
    报表导出 EasyPoi
##开发说明
    1.导入 db/cms_init.sql
    2.修改数据库配置文件
##项目结构
    1.cms-web是web项目,包括一些基础配置信息
    2.cms-system是项目的基础模块 ，包括用户管理，菜单管理，角色管理，权限管理等基础信息管理
    3.cms-common是项目的公共模块，项目中一些公共的内容都在这里边
    4.cms-xxx根据不同的需求新增子模块（业务相关模块）即可 ，比如商品管理，报表管理等