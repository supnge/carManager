<%@ page language="java" pageEncoding="UTF-8" %>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
          type="text/css" rel="stylesheet">
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/admin/js/My97DatePicker/WdatePicker.js"></script>

</HEAD>

<body>
<form id="userAction_save_do" name="Form1"
      action="${pageContext.request.contextPath}/AddRecordServlet" method="post">
    &nbsp;
    <table cellSpacing="1" cellPadding="5" width="100%" align="center"
           bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
        <tr>
            <td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
                height="26"><strong><STRONG>添加出车记录</STRONG> </strong>
            </td>
        </tr>




        <tr>
            <td align="center" bgColor="#f5fafe" class="ta_01">车辆选择：</td>
            <td class="ta_01" bgColor="#ffffff">
                <input type="text" name="cheId" class="bg" value="${record.cheId }"/>
                <input type="hidden" name="id" value="${record.id }">
            </td>
            <td align="center" bgColor="#f5fafe" class="ta_01">油卡类型：</td>
            <td class="ta_01" bgColor="#ffffff"><select name="shiyou"
                                                        id="shiyou">
                <option value="" selected="selected">--油卡类型--</option>
                <option value="柴油">柴油</option>
                <option value="汽油">汽油</option>
            </select></td>

        </tr>
        <tr>

            <td align="center" bgColor="#f5fafe" class="ta_01">开出时间：</td>
            <td class="ta_01" bgColor="#ffffff">
                <input type="text" name="kaichushijian" class="bg" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" value="${record.kaichushijian}"/>
            </td>
            <td align="center" bgColor="#f5fafe" class="ta_01">回来时间：</td>
            <td class="ta_01" bgColor="#ffffff" width="200px">
                <input type="text" width="100%" name="huilaishijian" class="bg" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" value="${record.huilaishijian}"/>
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