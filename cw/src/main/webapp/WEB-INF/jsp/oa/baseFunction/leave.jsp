<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2020/1/3
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>请假</title>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <link rel="stylesheet" href="/font/iconfont.css">
    <link rel="stylesheet" href="/css/mycss.css">
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <script src="/font/iconfont.js"></script>
</head>
<body>
<form id="addLeave" action="/leave/addLeave" method="post">
    <td><input id="userId" type="text" name="userId" hidden value="${loginUser.userId}"></td>
    <table>
        <tr>
            <td><label for="leaveId">流程编号:</label></td>
            <td><input id="leaveId" class="easyui-validatebox" type="text" name="leaveId" data-options="required:true" readonly value="${leaveId}"/></td>
            <td><label for="createUser">申请人:</label></td>
            <td><input id="createUser" class="easyui-validatebox" type="text" name="createUser" data-options="required:true" readonly value="${loginUser.userName}"/></td>
            <td><label for="createTime">申请时间:</label></td>
            <td><input id="createTime" type="text" name="createTime" readonly></td>
            <td><label for="leaveType">请假类型:</label></td>
            <td><select class="easyui-combotree" url="/util/getLeaveTypeList" name="leaveType" id="leaveType" style="width: 150px" data-options="required:true" /></td>
        </tr>
        <tr>
            <td><label for="leaveStartTime">请假开始时间:</label></td>
            <td><input id="leaveStartTime" type="text" name="leaveStartTime"></td>
            <td><label for="leaveEndTime">请假结束时间:</label></td>
            <td><input id="leaveEndTime" type="text" name="leaveEndTime"></td>
        </tr>
        <tr>
            <td><label for="leaveDesc">请假事由:</label></td>
            <td colspan="7"><input class="easyui-textbox" id="leaveDesc" name="leaveDesc" data-options="required:true, multiline:true" style="width: 1000px; height: 100px;word-wrap: break-word"/></td>
        </tr>
    </table>
</form>
<div style="text-align:center;padding:5px 0">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm(1)" style="width:80px" data-options="iconCls: 'iconfont icon-tijiao1'">提交</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm(2)" style="width:80px" data-options="iconCls: 'iconfont icon-baocun1'">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px" data-options="iconCls: 'iconfont icon-quxiao1'">取消</a>
</div>
</body>
<script type="text/javascript">
    $('#createTime').datetimebox({
        value: new Date().getFullYear() + '-' + (new Date().getMonth() + 1) + '-' + new Date().getDate() +" "+(new Date().getHours())+":"+new Date().getMinutes()+":"+new Date().getSeconds(),
        required: true,
        showSeconds: false
    });
    $('#leaveStartTime').datetimebox({
        value: new Date().getFullYear() + '-' + (new Date().getMonth() + 1) + '-' + new Date().getDate() +" "+(new Date().getHours())+":"+new Date().getMinutes()+":"+new Date().getSeconds(),
        required: true,
        showSeconds: false
    });
    $('#leaveEndTime').datetimebox({
        value: new Date().getFullYear() + '-' + (new Date().getMonth() + 1) + '-' + new Date().getDate() +" "+(new Date().getHours())+":"+new Date().getMinutes()+":"+new Date().getSeconds(),
        required: true,
        showSeconds: false
    });

    function submitForm(flag){
        $('#addLeave').form('submit', {
            onSubmit: function(param){
                var isValid = $(this).form('validate');
                if (!isValid){
                    $.messager.progress('close');	// hide progress bar while the form is invalid
                }
                param.flag = flag;
                return isValid;	// return false will stop the form submission
            },
            success: function(data){
                $.messager.progress('close');	// hide progress bar while submit successfully
            }
        });
    }
    function clearForm(){
        $('#addLeave').form('clear');
    }


</script>
</html>
