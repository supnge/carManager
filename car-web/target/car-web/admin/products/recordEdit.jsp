<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
          type="text/css" rel="stylesheet">
    <script language="javascript"
            src="${pageContext.request.contextPath}/admin/js/public.js"></script>
    <script language="javascript"
            src="${pageContext.request.contextPath}/admin/js/check.js"></script>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/admin/js/My97DatePicker/WdatePicker.js"></script>
    <%--下拉选择--%>
    <link href="${pageContext.request.contextPath}/admin/css/jquery.searchableSelect.css" rel="stylesheet"
          type="text/css">
    <script src="${pageContext.request.contextPath}/admin/jquery/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/jquery/jquery.searchableSelect.js"></script>

</HEAD>
<script type="text/javascript">

    $(function () {

        // 这个功能会与下面的去重复冲突，不知道啥情况
        // $('select').searchableSelect();
    });

    //设置类别的默认值
    function setProductCategory(t, c) {
        var category = document.getElementById("shiyou");
        var cheId = document.getElementById("cheId");

        var ops = category.options;
        var ops2 = cheId.options;
        for (var i = 0; i < ops.length; i++) {

            if (ops[i].value == t) {
                ops[i].selected = true;
            }
        }

        for (var i = 0; i < ops2.length; i++) {
            if (ops2[i].value == c) {
                ops2[i].selected = true;
            }
        }
    };



</script>
<body onload="setProductCategory('${record.shiyou}', '${record.cheId }')">
<form id="userAction_save_do" name="Form1"
      action="${pageContext.request.contextPath}/UpdateRe	cordServlet" method="post">

    <table cellSpacing="1" cellPadding="5" width="100%" align="center"
           bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
        <tr>
            <td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
                height="26"><strong><STRONG>编辑出车记录</STRONG> </strong></td>
            <input type="hidden" name="id" value="${record.id }">
        </tr>

        <tr>
            <td align="center" bgColor="#f5fafe" class="ta_01">车辆选择：</td>
            <td class="ta_01" bgColor="#ffffff">
                <select id="cheId" class="textbox combo" name="cheId" style="width: 180px; height: 35px;">
                    <c:forEach items="${carList}" var="car">
                        <option value="${car.id}">${car.chepai}</option>
                    </c:forEach>
                </select>
            </td>
            <td align="center" bgColor="#f5fafe" class="ta_01">油卡类型：</td>
            <td class="ta_01" bgColor="#ffffff">
                <select name="shiyou"
                        id="shiyou">
                    <option value="柴油">柴油</option>
                    <option value="汽油">汽油</option>
                </select></td>

        </tr>
        <tr>

            <td align="center" bgColor="#f5fafe" class="ta_01">开出时间：</td>
            <td class="ta_01" bgColor="#ffffff">
                <input type="text" name="kaichushijian" class="bg" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"
                       value="${record.kaichushijian}"/>
            </td>
            <td align="center" bgColor="#f5fafe" class="ta_01">回来时间：</td>
            <td class="ta_01" bgColor="#ffffff" width="200px">
                <input type="text" width="100%" name="huilaishijian" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"
                       class="bg" value="${record.huilaishijian}"/>
            </td>
        </tr>

        <tr>
            <td align="center" bgColor="#f5fafe" class="ta_01">出发地址：</td>
            <td class="ta_01" bgColor="#ffffff">
                <input type="text" name="qishidizhi" class="bg" value="${record.qishidizhi}"/>
                <%--隐藏del信息--%>
                <input type="hidden" name="del" value="1">
            </td>
            <td align="center" bgColor="#f5fafe" class="ta_01">目的地址：</td>
            <td class="ta_01" bgColor="#ffffff">
                <input type="text" name="mudidizhi" class="bg" value="${record.mudidizhi}"/>
                <%--隐藏del信息--%>
                <input type="hidden" name="del" value="1">
            </td>
        </tr>
        <TR>
            <td align="center" colSpan="4" class="sep1"><img
                    src="${pageContext.request.contextPath}/admin/images/shim.gif">
            </td>
        </TR>

        <tr>
            <td class="ta_01" style="WIDTH: 100%" align="center"
                bgColor="#f5fafe" colSpan="4"><input type="submit"
                                                     class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>


                <input type="reset" value="重置" class="button_cancel"> <FONT
                        face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
                        class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
                <span id="Label1"> </span></td>
        </tr>
    </table>
</form>


</body>
</HTML>