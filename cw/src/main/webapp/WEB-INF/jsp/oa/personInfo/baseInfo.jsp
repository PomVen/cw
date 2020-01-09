<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2020/1/3
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>个人基本信息</title>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <link rel="stylesheet" href="/font/iconfont.css">
    <link rel="stylesheet" href="/css/mycss.css">
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <%--<script type="text/javascript" src="/easyui/locale/easyui-lang-zh_CN.js"></script>--%>
    <script src="/font/iconfont.js"></script>
</head>
<body style="overflow: hidden">
<div class="easyui-tabs" style="width:100%;height:100%; ">
    <div title="基本信息" iconCls="iconfont icon-gerenxinxi" style="padding:10px;">
        <table>
            <tr>
                <th style="width: 100px;">姓名</th>
                <td style="width: 200px;">${loginUser.userName}</td>
                <th style="width: 100px;">工号</th>
                <td style="width: 200px;">${loginUser.userId}</td>
            </tr>
        </table>
    </div>
    <div title="通讯录" iconCls="iconfont icon-tongxunlu" style="padding:10px;">
        通讯录
    </div>
    <div title="教育经历" iconCls="iconfont icon-jiaoyujingli1" style="padding:10px;">
        <table id="edu_table" toolbar="#edu_tool" style="width: 100%"></table>
    </div>
    <div title="工作经历" iconCls="iconfont icon-gongzuojingli1" style="padding:10px;">
        工作经历
    </div>
    <div title="职称及证书" iconCls="iconfont icon-zhengshu-shixin" style="padding:10px;">
        职称及证书
    </div>
</div>
<div id="edu_tool" style="padding:3px">
    <span>学校名称:</span>
    <input id="schoolNameSearch" style="line-height:26px;border:1px solid #ccc">
    <span>入学时间:</span>
    <input id="startTimeSearch" style="line-height:26px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()"><i class="iconfont icon-search"></i> 查询</a>
    <a href="#" class="easyui-linkbutton" plain="true" onclick="reset()"><i class="iconfont icon-shuaxin2"></i> 重置</a>
</div>
<div id="edu_add" class="easyui-dialog" title="新增教育经历" closed="true" style="width:50%;height:240px;padding:10px"
     buttons="#edu_add_btn" iconCls="iconfont icon-jiaoyujingli">
    <form id="addEduHis" action="/edu/addEduHis" method="post">
        <input id="userId" type="text" name="userId" hidden value="${loginUser.userId}">
        <table>
            <tr>
                <td width="130px">学校名称</td>
                <td width="200px"><input id="schoolName" style="line-height:26px;border:1px solid #ccc" class="easyui-validatebox" type="text" name="schoolName" data-options="required:true"/></td>
                <td width="130px">学校类型</td>
                <td width="200px"><select class="easyui-combotree" url="/util/getSchoolTypeList" name="schoolType" id="schoolType" style="width: 160px; border:1px solid #ccc" data-options="required:true"/></td>
            </tr>
            <tr>
                <td><label for="startTime">入学时间:</label></td>
                <td><input id="startTime" type="text" name="startTime" style="border:1px solid #ccc" data-options="required:true"></td>
                <td><label for="endTime">毕业时间:</label></td>
                <td><input id="endTime" style="border:1px solid #ccc" type="text" name="endTime"></td>
            </tr>
            <tr>
                <td><label for="major">专业:</label></td>
                <td><input id="major" class="easyui-validatebox" style="line-height:26px;border:1px solid #ccc" type="text" name="major" data-options="required:true"/></td>
                <td><label for="degree">学位证书:</label></td>
                <td><input id="degree" class="easyui-validatebox" style="line-height:26px;border:1px solid #ccc" type="text" name="degree" data-options="required:true"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="edu_add_btn">
    <table cellpadding="0" cellspacing="0" style="width:100%">
        <tr>
            <td style="text-align:right">
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px" data-options="iconCls: 'iconfont icon-tijiao1'">提交</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
                   onclick="javascript:$('#edu_add').dialog('close')">取消</a>
            </td>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    $('#startTimeSearch').datetimebox({
        required: false,
        showSeconds: false
    });
    $('#startTime').datetimebox({
        required: true,
        showSeconds: false
    });
    $('#endTime').datetimebox({
        required: true,
        showSeconds: false
    });
    $('#edu_table').datagrid({
        // title:'教育经历',
        // iconCls:'icon-edit',
        // width:1300,
        // height:400,
        fit:true, //自适应高度
        singleSelect: true,
        idField: 'id',
        url: '/edu/getEduHisInfo',
        rownumbers: true,
        pagination: true,
        pageList: [2, 5, 10, 20, 50, 100],
        // frozenColumns: [[
        //     {field: 'userName', title: '姓名', width: 150, editor: 'text'}
        // ]],
        columns: [[
            {field: 'id', title: '序号', align: 'center', hidden: true}
            , {field: 'userId', title: '工号', editor: 'text', hidden: true}
            , {field: 'schoolName', title: '学校名称', editor: 'text', width: setWidth(24)}
            , {field: 'typeValue', title: '学校类型', editor: 'text', width: setWidth(12)}
            , {
                field: 'startTime', width: setWidth(12), title: '入学时间', editor: 'text', sortable: true,
                formatter: function (value) {
                    var d = new Date(value);
                    return d.getFullYear() + "-" + ((d.getMonth() + 1) < 10 ? "0" + (d.getMonth() + 1) : (d.getMonth() + 1)) + "-" + (d.getDate() < 10 ? ("0" + d.getDate()) : d.getDate());
                }
            }
            , {
                field: 'endTime', width: setWidth(12), title: '毕业时间', editor: 'text', sortable: true,
                formatter: function (value) {
                    var d = new Date(value);
                    return d.getFullYear() + "-" + ((d.getMonth() + 1) < 10 ? "0" + (d.getMonth() + 1) : (d.getMonth() + 1)) + "-" + (d.getDate() < 10 ? ("0" + d.getDate()) : d.getDate());
                }
            }
            , {field: 'major', title: '专业', editor: 'text', width: setWidth(20)}
            , {field: 'degree', title: '所获学位或证书', editor: 'text', width: setWidth(18)}
        ]]
    });

    function submitForm() {
        $('#addEduHis').form('submit', {
            onSubmit: function(param){
                var isValid = $(this).form('validate');
                if (!isValid){
                    $.messager.progress('close');	// hide progress bar while the form is invalid
                }
                return isValid;	// return false will stop the form submission
            },
            success: function(data){
                var data = eval('(' + data + ')');  // change the JSON string to javascript object
                if(data.result){
                    alert(data.msg);
                    $('#edu_add').dialog('close');
                    $('#edu_table').datagrid('load', {});
                } else {
                    alert(data.msg);
                }
            }
        });
    }

    function setWidth(percent){
        return $("#edu_table").width() * percent / 100;
    }

    function doSearch() {
        $('#edu_table').datagrid('load', {
            schoolName: $('#schoolNameSearch').val(),
            startTime: $('#startTimeSearch').val()
        });
    }

    function reset() {
        $('#schoolNameSearch').val("");
        $('#startTimeSearch').datetimebox();
        $('#edu_table').datagrid('load', {
            schoolName: $('#schoolNameSearch').val(),
            startTime: $('#startTimeSearch').val()
        });
    }

    $('#edu_table').datagrid('getPager').pagination({
        // showPageList:true,
        beforePageText: '第',//页数文本框前显示的汉字
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
        buttons: [{
            iconCls: 'icon-add',
            text: '新增',
            handler: function () {
                $('#edu_add').dialog('open');
            }
        }],
        onBeforeRefresh: function () {
            return true;
        }
    });
    // //条纹
    // $('#edu_table').datagrid({
    //     rowStyler:function(index,row){
    //         if (index%2 > 0){
    //             return 'background-color:gray;';
    //         }
    //     }
    // });
</script>
</html>
