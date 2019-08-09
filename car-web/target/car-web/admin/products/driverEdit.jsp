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
	function setProductCategory(t) {
		var category = document.getElementById("sex");

		var ops = category.options;
		for ( var i = 0; i < ops.length; i++) {

			if (ops[i].value == t) {
				ops[i].selected = true;
				return;
			}
		}

	};
</script>
<body onload="setProductCategory('${driver.sex}')">
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/UpdateDriverServlet" method="post">
	
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑司机</STRONG> </strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">姓名：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="name" class="bg"  value="${driver.name }"/>
					<input type="hidden" name="id" value="${driver.id }">
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">性别：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="sex"
															id="sex">
					<option value="" selected="selected">--性别--</option>
					<option value="男">男</option>
					<option value="女">女</option>
				</select></td>

			</tr>
			<tr>

				<td align="center" bgColor="#f5fafe" class="ta_01">年龄：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
														   name="age" class="bg" value="${driver.age}" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">手机：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="tel" class="bg" value="${driver.tel}" /></td>
			</tr>

			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">地址：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
														   name="address" class="bg" value="${driver.address}" /></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">银行卡：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
														   name="card" class="bg" value="${driver.card}" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">加油卡：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
														   name="oilCard" class="bg" value="${driver.oilCard}" /></td>
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