<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <title>菜单管理</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta http-equiv="Access-Control-Allow-Origin" content="*">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="icon" href="favicon.ico">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/dtree.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/font/dtreefont.css">

        <style type="text/css">
                .select-test{position: absolute;max-height: 500px;height: 350px;overflow: auto;width: 100%;z-index: 123;display:
                        none;border:1px solid silver;top: 42px;}
                .layui-show{display: block!important;}
        </style>
</head>
<body class="childrenBody">
<!-- 搜索条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>查询条件</legend>
</fieldset>
<form class="layui-form" method="post" id="searchFrm">
        <div class="layui-form-item">
                <div class="layui-inline">
                        <label class="layui-form-label">菜单名称:</label>
                        <div class="layui-input-inline">
                                <input type="text" name="title" autocomplete="off" class="layui-input">
                        </div>
                </div>
                <div class="layui-inline">
                        <button type="button" class="layui-btn layui-btn-normal layui-icon layui-icon-search" id="doSearch">查询</button>
                        <button type="reset" class="layui-btn layui-btn-warm layui-icon layui-icon-refresh">重置</button>
                </div>
        </div>
</form>

<!-- 搜索条件结束 -->


<!-- 数据表格开始 -->
<table class="layui-hide" id="menuTable" lay-filter="menuTable"></table>
<div style="display: none;" id="menuToolBar">
        <button type="button" class="layui-btn layui-btn-sm" lay-event="add">增加</button>
</div>
<div id="menuBar" style="display: none;">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</div>
<!-- 数据表格结束 -->

<!-- 添加和修改的弹出层开始 -->
<div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
        <form class="layui-form" lay-filter="dataFrm" id="dataFrm">
                <div class="layui-form-item">
                        <label class="layui-form-label">父级菜单：</label>
                        <div class="layui-input-block">
                                <div class="layui-unselect layui-form-select" id="pid_div">
                                        <div class="layui-select-title">
                                                <input type="hidden" name="pid" id="pid">
                                                <input type="text" name="pid_str" id="pid_str" placeholder="请选择" readonly="" class="layui-input layui-unselect">
                                                <i class="layui-edge"></i>
                                        </div>
                                </div>
                                <div class="layui-card select-test" id="menuSelectDiv">
                                        <div class="layui-card-body">
                                                <div id="toolbarDiv"><ul id="menuTree" class="dtree" data-id="0" style="width: 100%;"></ul></div>
                                        </div>
                                </div>
                        </div>
                </div>
                <div class="layui-form-item">
                        <label class="layui-form-label">菜单名称:</label>
                        <div class="layui-input-block">
                                <input type="hidden" name="id">
                                <input type="text" name="title" placeholder="请输入菜单名称" autocomplete="off"
                                       class="layui-input">
                        </div>
                </div>
                <div class="layui-form-item">
                        <label class="layui-form-label">菜单地址:</label>
                        <div class="layui-input-block">
                                <input type="text" name="href" placeholder="请输入菜单地址" autocomplete="off"
                                       class="layui-input">
                        </div>
                </div>
                <div class="layui-form-item">
                        <div class="layui-inline">
                                <label class="layui-form-label">菜单图标:</label>
                                <div class="layui-input-inline">
                                        <input type="text" name="icon" placeholder="请输入菜单图标" lay-verify="required" autocomplete="off"
                                               class="layui-input">
                                </div>
                        </div>
                        <div class="layui-inline">
                                <label class="layui-form-label">TARGET:</label>
                                <div class="layui-input-inline">
                                        <input type="text" name="target" placeholder="请输入TRAGET" autocomplete="off"
                                               class="layui-input">
                                </div>
                        </div>
                </div>
                <div class="layui-form-item">
                        <div class="layui-inline">
                                <label class="layui-form-label">是否展开:</label>
                                <div class="layui-input-inline">
                                        <input type="radio" name="spread" value="1" title="展开">
                                        <input type="radio" name="spread" value="0" title="不展开" checked="checked">
                                </div>
                        </div>
                        <div class="layui-inline">
                                <label class="layui-form-label">是否可用:</label>
                                <div class="layui-input-inline">
                                        <input type="radio" name="available" value="1" checked="checked" title="可用">
                                        <input type="radio" name="available" value="0" title="不可">
                                </div>
                        </div>
                </div>
                <div class="layui-form-item" style="text-align: center;">
                        <div class="layui-input-block">
                                <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release"
                                        lay-filter="doSubmit" lay-submit="">提交</button>
                                <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
                        </div>
                </div>
        </form>
</div>
<!-- 添加和修改的弹出层结束 -->

<script src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
<script type="text/javascript">
        var tableIns;
        layui.extend({
                dtree: '${pageContext.request.contextPath}/resources/layui_ext/dist/dtree'
        }).use(['jquery','layer','form','dtree','table'],function() {
                var $ = layui.jquery;
                var layer = layui.layer;
                var form = layui.form;
                var dtree = layui.dtree;
                var table = layui.table;
                //渲染表格
                tableIns = table.render({
                        elem: '#menuTable' , //渲染的目标对象
                        url: '${pageContext.request.contextPath}/menu/loadAllMenu.action', //数据接口地址
                        title:'菜单列表数据', //标题
                        height: 'full-150',
                        cellMinWidth : 100 , //设置列最小默认宽度
                        toolbar: '#menuToolBar' , //表格的头部工具栏
                        page: true , //启动分页
                        cols: [[
                                {type:'checkbox',fixed: 'left'},
                                {field:'id',title:'ID',align:'center',width:'80'},
                                {field:'pid',title:'父节点ID',align:'center',width:'100'},
                                {field:'title',title:'菜单名称',align:'center',width:'120'},
                                {field:'href',title:'菜单地址',align:'center',width:'220'},
                                {field:'spread',title:'是否展开',align:'center',width:'100',templet:function(d) {
                                                return d.spread == '1'?'<font color="blue">展开</font>':'<font color="red">不展开</font>'
                                        }},
                                {field:'target',title:'TARGET',align:'center',width:'100'},
                                {field:'icon',title:'菜单图标',align:'center',width:'100',templet:function(d) {
                                                return "<div class='layui-icon'>"+d.icon+"</div>"
                                        }},
                                {field:'available',title:'是否可用',align:'center',width:'100',templet:function(d) {
                                                return d.available=='1'?'<font color=blue>可用</font>':'<font color=red>不可用</font>'
                                        }},
                                {fixed:'right',title:'操作',toolbar:'#menuBar',align:'center',width:'180'}
                        ]]
                });

                //模糊查询
                $("#doSearch").click(function () {
                        //获取搜索框中的参数
                        var param =  $("#searchFrm").serialize();
                        tableIns.reload({
                                url: "${pageContext.request.contextPath}/menu/loadAllMenu.action?"+param,
                                page: {curr: 1}
                        })
                })

                //监听头部工具栏
                table.on("toolbar(menuTable)",function(obj) {
                        switch (obj.event) {
                                case 'add':
                                        openAddMenu();
                                        break;
                        }
                })

                var url;
                var mainIndex ;
                //打开添加页面
                function openAddMenu(){
                        mainIndex = layer.open({
                                type:1,
                                title:"添加菜单",
                                content:$("#saveOrUpdateDiv"),
                                area: ['800px','450px'],
                                success: function(index) {
                                        //清空表单数据
                                        $("#dataFrm")[0].reset();
                                        $("menuSelectDiv").removeClass("layui-show");
                                        url = "${pageContext.request.contextPath}/menu/addMenu.action"

                                }
                        })
                }

                //保存
                form.on("submit(doSubmit)",function(obj) {
                        //序列化表单数据
                        var param = $("#dataFrm").serialize();
                        $.get(url,param,function(obj) {
                                layer.msg(obj.msg);
                                //关闭弹出层
                                layer.close(mainIndex);
                                //刷新数据表格
                                tableIns.reload();
                                //刷新左侧得树
                                window.parent.left.menuTree.reload();
                                //刷新添加和修改的下拉树
                                menuTree.reload();
                        })
                })

                //初始化添加和修改页面的下拉树
                var menuTree = dtree.render({
                        elem: "#menuTree",
                        dataStyle: "layuiStyle", //使用layui风格展示数据
                        response:{message:"msg",statusCode:0}, //修改response中返回数据的定义
                        dataFormat: "list", //配置data的风格为list
                        url: "${pageContext.request.contextPath}/menu/loadMenuManagerLeftTreeJson.action?spread=1",
                        icon:"2",
                        accordion:true
                })

                //点击下拉可以加载树
                $("#pid_div").on("click",function() {
                        $(this).toggleClass("layui-form-selected");
                        $("#menuSelectDiv").toggleClass("layui-show layui-anim layui-anim-upbit");
                })

                dtree.on("node(menuTree)",function(obj) {
                        $("#pid_str").val(obj.param.context);
                        $("#pid").val(obj.param.nodeId);
                        $("#pid_div").toggleClass("layui-form-selected");
                        $("#menuSelectDiv").toggleClass("layui-show layui-anim layui-anim-upbit");
                })

                //监听行工具栏
                table.on("tool(menuTable)",function(obj) {
                        //获取当前行数据
                        var data = obj.data;
                        var layEvent = obj.event;
                        if(layEvent == 'del'){
                                //先判断当前菜单是否有子节点
                                $.get("${pageContext.request.contextPath}/menu/checkMenuHasChildren.action?id="+data.id,function (obj){
                                        if(obj.code >= 0){
                                                layer.msg("当前菜单有子节点,请先删除完子节点");
                                        }else{
                                                layer.confirm("确定删除 ["+data.title+"]这个菜单吗?",function (index){
                                                        //发送删除的请求
                                                        $.get("${pageContext.request.contextPath}/menu/deleteMenu.action",{id:data.id},function (res){
                                                                layer.msg(res.msg);
                                                                //刷新表格
                                                                tableIns.reload();
                                                                //刷新左边的树
                                                                window.parent.left.menuTree.reload();
                                                                //刷新添加和修改的下拉树
                                                                menuTree.reload();
                                                        })
                                                })
                                        }
                                })

                        }else if(layEvent == 'edit'){
                                openUpdateMenu(data);
                        }
                })

                function openUpdateMenu(data){
                        mainIndex = layer.open({
                                type:1,
                                title:"修改菜单",
                                content:$("#saveOrUpdateDiv"),
                                area: ['800px','450px'],
                                success: function(index) {
                                        form.val("dataFrm",data);//回显
                                        $("menuSelectDiv").removeClass("layui-show");
                                        url = "${pageContext.request.contextPath}/menu/updateMenu.action"
                                        //反选下拉树
                                        var pid = data.pid;
                                        var params = dtree.dataInit("menuTree",pid);
                                        //给下拉框的text赋值
                                        $("#pid_str").val(params.context);
                                }
                        })
                }

        })

        function reloadTable(id) {
                tableIns.reload({
                        url:"${pageContext.request.contextPath}/menu/loadAllMenu.action?id="+id
                })
        }

</script>
</body>
</html>