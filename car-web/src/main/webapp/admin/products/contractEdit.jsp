<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

</HEAD>
<script type="text/javascript">

	//设置类别的默认值
	function setProductCategory(c) {
		var category = document.getElementById("cheId");

		var ops = category.options;
		for (var i = 0; i < ops.length; i++) {

			if (ops[i].value == c) {
				ops[i].selected = true;
			}
		}
	};
</script>
<body onload="setProductCategory('${contract.cheId }')">
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/UpdateContractServlet" method="post">
	
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑合同</STRONG> </strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">合同名称：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="name" class="bg" value="${contract.name }"/>
					<input type="hidden" name="id" value="${contract.id }">
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">车辆编号：</td>
				<td class="ta_01" bgColor="#ffffff" width="200px">
					<select id="cheId" class="textbox combo" name="cheId" style="width: 180px; height: 35px;">
						<c:forEach items="${carList}" var="car">
							<option value="${car.id}">${car.chepai}</option>
						</c:forEach>
					</select>
				</td>

			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">货物名称：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select id="huowuId" class="textbox combo" name="huowuId" style="width: 180px; height: 35px;">
						<c:forEach items="${goodsList}" var="goods">
							<option value="${goods.id}">${goods.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>

			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">上传照片：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="photoId" class="bg" value="${contract.photoId}"/>
					<%--隐藏del信息--%>
					<input type="hidden" name="del" value="1"></td>
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
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>




</body>
</HTML>