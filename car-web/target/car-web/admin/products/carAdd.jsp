<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
          type="text/css" rel="stylesheet">
    <%--下拉选择--%>
    <link href="${pageContext.request.contextPath}/admin/css/jquery.searchableSelect.css" rel="stylesheet"
          type="text/css">
    <script src="${pageContext.request.contextPath}/admin/jquery/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/jquery/jquery.searchableSelect.js"></script>

    <script type="text/javascript">
        $(function () {
            $('#sijiId').searchableSelect();
        });
    </script>
</HEAD>

<body>
<form id="userAction_save_do" name="Form1"
      action="${pageContext.request.contextPath}/AddCarServlet" method="post">
    &nbsp;
    <table cellSpacing="1" cellPadding="5" width="100%" align="center"
           bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
        <tr>
            <td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
                height="26"><strong><STRONG>添加车辆</STRONG> </strong>
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe" class="ta_01">车牌：</td>
            <td class="ta_01" bgColor="#ffffff">
                <input type="text" name="chepai" class="bg" value="${car.chepai }"/>
                <input type="hidden" name="id" value="${car.id }">
            </td>
            <td align="center" bgColor="#f5fafe" class="ta_01">车型：</td>
            <td class="ta_01" bgColor="#ffffff">
                <select name="chexing"
                        id="chexing">
                    <option value="" selected="selected">--车型--</option>
                    <option value="大客车">大客车</option>
                    <option value="货车">货车</option>
                    <option value="轿车">轿车</option>
                </select>
            </td>

        </tr>
        <tr>

            <td align="center" bgColor="#f5fafe" class="ta_01">出厂日期：</td>
            <td class="ta_01" bgColor="#ffffff">
                <input type="text" name="chuchangriqi" class="bg" value="${car.chuchangriqi}"/>
            </td>
            <td align="center" bgColor="#f5fafe" class="ta_01">载重量(T)：</td>
            <td class="ta_01" bgColor="#ffffff" width="200px">
                <input type="text" width="100%" name="zaizhongliang" class="bg" value="${car.zaizhongliang}"/>
            </td>
        </tr>

        <tr>

            <td align="center" bgColor="#f5fafe" class="ta_01">司机：</td>
            <td class="ta_01" bgColor="#ffffff">
                <select id="sijiId"  class="textbox combo" name="sijiId" style="width: 180px; height: 35px;">
                    <option value="">请选择</option>
                    <c:forEach items="${driverList}" var="driver">
                        <option value="${driver.id}">${driver.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td align="center" bgColor="#f5fafe" class="ta_01">石油类型：</td>
            <td class="ta_01" bgColor="#ffffff" width="200px">
                <select name="shiyouleixing"
                        id="shiyouleixing">
                    <option value="" selected="selected">--石油类型--</option>
                    <option value="柴油">柴油</option>
                    <option value="汽油">汽油</option>
                </select>
                <%--隐藏del信息--%>
                <input type="hidden" name="del" value="1"></td>
            </td>
        </tr>


        <TR>
            <td align="center" colSpan="4" class="sep1"><img
                    src="${pageContext.request.contextPath}/admin/images/shim.gif">
            </td>
        </TR>


        <tr>
            <td class="ta_01" style="WIDTH: 100%" align="center"
                bgColor="#f5fafe" colSpan="4">


                <input type="submit" class="button_ok" value="确定">

                <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>


                <input type="reset" value="重置" class="button_cancel">

                <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
                    class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
                <span id="Label1">
					
					</span>
            </td>
        </tr>
    </table>
</form>
</body>
</HTML>