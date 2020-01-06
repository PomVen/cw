<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/12/27
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>OA系统</title>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <link rel="stylesheet" href="/font/iconfont.css">
    <link rel="stylesheet" href="/css/mycss.css">
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <script src="/font/iconfont.js"></script>
<body class="easyui-layout">
<div class="clear"></div>
<div region="north" style="width:100%; height: 10%">
    欢迎你，${loginUser.userName}！
    <a href="/login/loginOut" title="退出系统">
        <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-tuichudenglu"></use>
        </svg>
    </a>
</div>
<div region="south" id="footer" style="text-align: center; height: 6%">OA系统<br/><span class="iconfont icon-uniE"></span>copyright Hallth <span class="iconfont icon-2019"></span> </div>
</body>
<div region="west" split="true" title="菜单栏" style="width: 150px;">
    <div id="menu-content" class="easyui-accordion" style="position: absolute; top: 27px; left: 0px; right: 0px; bottom: 0px;">
        <c:forEach varStatus="status" items="${oaMenu}" var="itemP">
            <c:if test="${itemP.parentId == '0'}">
                <div title="${itemP.menuName}" iconcls="iconfont ${itemP.menuIcon}" style="overflow: auto; padding: 0px;">
                    <c:forEach varStatus="status" items="${oaMenu}" var="itemC">
                        <c:if test="${itemC.parentId == itemP.menuId}">
                            <li class="sys-menu-li">
                                <div class="menuDiv" target="mainFrame" href="${itemC.menuPath}">
                                    <span class="nav">
                                        <svg class="icon" aria-hidden="true">
                                            <use xlink:href="#${itemC.menuIcon}"></use>
                                        </svg>
                                        ${itemC.menuName}
                                    </span>
                                </div>
                            </li>
                        </c:if>
                    </c:forEach>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
<div id="mainPanle" region="center" style="overflow: hidden;">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
    </div>
    <div id="mm" class="easyui-menu" style="width: 150px;">
        <div id="mm-refresh">刷新</div>
        <div class="menu-sep"></div>
        <div id="mm-tabclose">关闭</div>
        <div id="mm-tabcloseall">全部关闭</div>
        <div id="mm-tabcloseother">关闭其他</div>
        <div id="mm-tabcloseright">关闭左侧标签页</div>
        <div id="mm-tabcloseleft">关闭右侧标签页</div>
        <div class="menu-sep"></div>
        <div id="mm-exit">退出</div>
    </div>
</div>
</body>
<script type="text/javascript">
    function showcontent(language) {
        $('#content').html('Introduction to ' + language + ' language');
    }

    <%--$(function () {--%>
    <%--$('#LeftMenu').sidemenu({--%>
    <%--data: ${oaMenu},--%>
    <%--onSelect: onSideMenuSelect,--%>
    <%--border: true--%>
    <%--});--%>
    <%--});--%>
    <%--function onSideMenuSelect() {--%>
    <%----%>
    <%--}--%>


</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.easyui-accordion li div').click(function () {
            var tabTitle = $(this).text();//tab标题
            var url = $(this).attr("href");//tab连接
            addTab(tabTitle, url);
            $('.easyui-accordion li div').removeClass("menu-selected");
            $(this).removeClass("menu-hover");
            $(this).addClass("menu-selected");
        }).hover(function () {
            $(this).addClass("menu-hover");
        }, function () {
            $(this).removeClass("menu-hover");
        });

        function addTab(subtitle, url) {
            if (!$('#tabs').tabs('exists', subtitle)) {
                $('#tabs').tabs('add', {
                    title: subtitle,
                    content: createFrame(url),
                    closable: true,
                    cache: true,
                    width: $('#mainPanle').width() - 10,
                    height: $('#mainPanle').height() - 26,
                    tools: [{
                        iconCls: 'icon-reload',
                        handler: function () {
                            refreshTab();
                        }
                    }]
                });
            } else {
                $('#tabs').tabs('select', subtitle);
            }
            tabClose();
            tabCloseEven();
        }

        //切换选项卡刷新
        $('#tabs').tabs({
            onSelect: function (title, index) {
                refreshTab();
            }
        });

        //刷新当前选项卡
        function refreshTab() {
            var currTab = self.parent.$('#tabs').tabs('getSelected'); //获得当前tab
            var url = $(currTab.panel('options').content).attr('src');
            if (url == undefined)
                url = "/login/login";
            self.parent.$('#tabs').tabs('update', {
                tab: currTab,
                options: {
                    content: createFrame(url)
                }
            });
        }

        function createFrame(url) {
            var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
            return s;
        }

        function tabClose() {
            /*双击关闭TAB选项卡*/
            $(".tabs-inner").dblclick(function () {
                var subtitle = $(this).children("span").text();
                $('#tabs').tabs('close', subtitle);
            })
            //绑定右键菜单
            $(".tabs-inner").bind('contextmenu', function (e) {
                $('#mm').menu('show', {
                    left: e.pageX,
                    top: e.pageY,
                });
                var subtitle = $(this).children("span").text();
                $('#mm').data("currtab", subtitle);
                return false;
            });
        }

        //绑定右键菜单事件
        function tabCloseEven() {
            //刷新
            $('#mm-refresh').click(function () {
                refreshTab();
            })
            //关闭当前
            $('#mm-tabclose').click(function () {
                var currtab_title = $('#mm').data("currtab");
                $('#tabs').tabs('close', currtab_title);
            })
            //全部关闭
            $('#mm-tabcloseall').click(function () {
                $('.tabs-inner span').each(function (i, n) {
                    var t = $(n).text();
                    $('#tabs').tabs('close', t);
                });
            });
            //关闭除当前之外的TAB
            $('#mm-tabcloseother').click(function () {
                var currtab_title = $('#mm').data("currtab");
                $('.tabs-inner span').each(function (i, n) {
                    var t = $(n).text();
                    if (t != currtab_title)
                        $('#tabs').tabs('close', t);
                });
            });
            //关闭当前右侧的TAB
            $('#mm-tabcloseright').click(function () {
                var nextall = $('.tabs-selected').nextAll();
                if (nextall.length == 0) {
                    //msgShow('系统提示','后边没有啦~~','error');
                    //alert('后边没有啦~~');
                    return false;
                }
                nextall.each(function (i, n) {
                    var t = $('a:eq(0) span', $(n)).text();
                    $('#tabs').tabs('close', t);
                });
                return false;
            });
            //关闭当前左侧的TAB
            $('#mm-tabcloseleft').click(function () {
                var prevall = $('.tabs-selected').prevAll();
                if (prevall.length == 0) {
                    //alert('到头了，前边没有啦~~');
                    return false;
                }
                prevall.each(function (i, n) {
                    var t = $('a:eq(0) span', $(n)).text();
                    $('#tabs').tabs('close', t);
                });
                return false;
            });
            //退出
            $("#mm-exit").click(function () {
                $('#mm').menu('hide');
            })
        }
    });
</script>
</html>
