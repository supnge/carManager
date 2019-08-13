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
            $('select').searchableSelect();
        });

        function jisuan(){
            var text1=document.getElementById("danjia").value;
            var text2=document.getElementById("carZaizhong").value;
            document.getElementById("zongjia").value=parseFloat(text1)*parseFloat(text2);
            console.log("danjia: "+$("#danjia").val());
            $("#zongjia").val(parseFloat(text1)*parseFloat(text2));
            console.log("zongjia: "+$("#zongjia").val())
        }

    </script>

</HEAD>

<body>
<form id="userAction_save_do" name="Form1"
      action="${pageContext.request.contextPath}/AddGoodsServlet" method="post">
    &nbsp;
    <table cellSpacing="1" cellPadding="5" width="100%" align="center"
           bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
        <tr>
            <td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
                height="26"><strong><STRONG>添加货物信息</STRONG> </strong>
            </td>
        </tr>
        <tr>

            <td align="center" bgColor="#f5fafe" class="ta_01">货物名称：</td>
            <td class="ta_01" bgColor="#ffffff"><input type="text"
                                                       name="name" class="bg" value="${goods.name}"/></td>
            <td align="center" bgColor="#f5fafe" class="ta_01">车辆编码：</td>
            <td class="ta_01" bgColor="#ffffff">
                <select id="distribute_type"  class="textbox combo" id="carId"  name="carId" style="width: 180px; height: 35px;">
                    <option value="">请选择</option>
                    <c:forEach items="${tCheList}" var="car">
                        <option value="${car.id}">${car.chepai}</option>
                    </c:forEach>
                </select>

            </td>
        </tr>

        <tr>
            <td align="center" bgColor="#f5fafe" class="ta_01">单价：</td>
            <td class="ta_01" bgColor="#ffffff" width="200px">
                <input type="text" width="100%" name="danjia" id="danjia" class="bg" onkeyup="jisuan();" />
            </td>
            <td align="center" bgColor="#f5fafe" class="ta_01">车辆载重：</td>
            <td class="ta_01" bgColor="#ffffff">
                <input type="text" name="carZaizhong" id="carZaizhong" class="bg" onkeyup="jisuan();" />
                <%--隐藏del信息--%>
                <input type="hidden" name="del" value="1"></td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe" class="ta_01">总价：</td>
            <td class="ta_01" bgColor="#ffffff">
                <input type="text" name="zongjia" id="zongjia"  value="${goods.zongjia}"  readonly/>
            </td>
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