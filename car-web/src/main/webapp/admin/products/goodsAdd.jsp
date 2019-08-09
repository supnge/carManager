<%@ page language="java" pageEncoding="UTF-8" %>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
          type="text/css" rel="stylesheet">


</HEAD>

<body>
<form id="userAction_save_do" name="Form1"
      action="${pageContext.request.contextPath}/AddGoodsServlet" method="post">
    &nbsp;
    <table cellSpacing="1" cellPadding="5" width="100%" align="center"
           bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
        <tr>
            <td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
                height="26"><strong><STRONG>添加司机</STRONG> </strong>
            </td>
        </tr>
        <tr>

            <td align="center" bgColor="#f5fafe" class="ta_01">货物名称：</td>
            <td class="ta_01" bgColor="#ffffff"><input type="text"
                                                       name="name" class="bg" value="${goods.name}"/></td>
            <td align="center" bgColor="#f5fafe" class="ta_01">单价：</td>
            <td class="ta_01" bgColor="#ffffff" width="200px"><input type="text" width="100%"
                                                                     name="danjia" class="bg" value="${goods.danjia}"/></td>
        </tr>

        <tr>
            <td align="center" bgColor="#f5fafe" class="ta_01">车辆编码：</td>
            <td class="ta_01" bgColor="#ffffff"><input type="text"
                                                       name="carId" class="bg" value="${goods.carId}"/></td>
            <td align="center" bgColor="#f5fafe" class="ta_01">车辆载重：</td>
            <td class="ta_01" bgColor="#ffffff"><input type="text"
                                                       name="carZaizhong" class="bg" value="${goods.carZaizhong}"/>
                <%--隐藏del信息--%>
                <input type="hidden" name="del" value="1"></td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe" class="ta_01">总价：</td>
            <td class="ta_01" bgColor="#ffffff"><input type="text"
                                                       name="zongjia" class="bg" value="${goods.zongjia}"/></td>
            <td bgColor="#f5fafe"></td>
            <td bgColor="#ffffff"></td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe" class="ta_01">说明：</td>
            <td class="ta_01" bgColor="#ffffff"><textarea
                    name="remark" cols="30" rows="6"
                    style="WIDTH: 96%"></textarea>
            </td>
            <td bgColor="#f5fafe"></td>
            <td bgColor="#ffffff"></td>
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