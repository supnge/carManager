<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>菜单</title>
    <link href="${pageContext.request.contextPath}/admin/css/left.css" rel="stylesheet" type="text/css">
    <link rel="StyleSheet" href="${pageContext.request.contextPath}/admin/css/dtree.css" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/dtree.js"></script>
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="12"></td>
    </tr>
</table>
<table width="100%" border="0">
    <tr>
        <td>
            <div class="dtree">

                <a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>

                <script type="text/javascript">
                    <!--
                    d = new dTree('d');
                    d.add(0, -1, '系统菜单树');
                    d.add(1, 0, '司机信息管理', '${pageContext.request.contextPath}/admin/login/welcome.jsp', '', 'mainFrame');
                    d.add(2, 0, '车辆信息管理', '${pageContext.request.contextPath}/CarListServlet', '', 'mainFrame');
                    d.add(3, 0, '出车记录管理', '${pageContext.request.contextPath}/RecordListServlet', '', 'mainFrame');
                    d.add(4, 0, '货物信息管理', '${pageContext.request.contextPath}/GoodsListServlet', '', 'mainFrame');
                    d.add(5, 0, '合同管理', '${pageContext.request.contextPath}/ContractListServlet', '', 'mainFrame');
                    <%--d.add(6, 0, '综合查询', '${pageContext.request.contextPath}/admin/login/welcome.jsp', '', 'mainFrame');--%>


                    //司机信息管理的子目录添加
                    d.add(11, 1, '司机信息', '${pageContext.request.contextPath}/DriverListServlet', '', 'mainFrame');

                    //车辆信息管理的子目录添加
                    d.add(11, 2, '车辆信息', '${pageContext.request.contextPath}/CarListServlet', '', 'mainFrame');

                    //出车记录管理的子目录添加
                    d.add(11, 3, '出车信息', '${pageContext.request.contextPath}/RecordListServlet', '', 'mainFrame');

                    //货物信息管理的子目录添加
                    d.add(11, 4, '货物信息', '${pageContext.request.contextPath}/GoodsListServlet', '', 'mainFrame');

                    //合同信息管理的子目录添加
                    d.add(11, 5, '合同信息', '${pageContext.request.contextPath}/ContractListServlet', '', 'mainFrame');

                    //综合查询
                    d.add(11, 6, '综合查询/导出', '${pageContext.request.contextPath}/InformationListServlet', '', 'mainFrame');

                    document.write(d);
                    //-->
                </script>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
