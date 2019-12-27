<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <title>谜苑天涯-登录</title>
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/myty.css" />
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<div class="layui-row">
    <div class="borderColor loginDiv height-260">
        <div class="centerDiv height-100">
            <form id="loginForm" class="layui-form layui-form-pane"  action="/login/loginCheck" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="userName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" />
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="userPassword"  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" />
                    </div>
                </div>
                <div class="layui-form-item">
                    <button  class="layui-btn layui-btn-fluid" lay-submit lay-filter="login">登录</button>
                </div>
                <span style="color: #FF5722">${errMsg}</span>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    // layUI获取元素值：var pvalue = $("input[name='password']").val(); name属性为password的input的值
    layui.use(['form'], function(){
        var form = layui.form;
        //自定义验证规则，元素使用lay-verify绑定校验规则，不同的校验规则 用逗号间隔，可以使用自定义方法
        form.verify({
            pass: [/(.+){6,12}$/, '密码必须6到12位']
        });
        //监听提交,也就是在点击按钮，提交到后台之前的操作
        form.on('submit(login)', function(data){
            layer.msg(data);
        });
    });
</script>
</html>
