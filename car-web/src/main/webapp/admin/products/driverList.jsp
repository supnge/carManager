<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
	<link href="${pageContext.request.contextPath}/admin/css/jquery.searchableSelect.css" rel="stylesheet"
		  type="text/css">
	<script src="${pageContext.request.contextPath}/admin/jquery/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/admin/jquery/jquery.searchableSelect.js"></script>
<script type="text/javascript">

	$(function () {
		$('#tel').searchableSelect();
		$('#oilCard').searchableSelect();

	});

	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/products/driverAdd.jsp";
	}

	function deleteById(id,name) {
		if(confirm('司机信息关联众多，请谨慎删除！！！ 确认是否要删除[' + name + ']?')){
			location.href = '${pageContext.request.contextPath}/DeleteDriverByIdServlet?id=' + id;
		}
	}

	//实现全选或不全选的js方法
	function checkAll() {
		//1.获取全选按钮的状态
		var ckAllDriver = document.getElementById('ckAllDriver');
		//alert(ckAllBook.checked);

		//2.获取每一行的checkbox,然后设置选中的状态
		var checkboxs = document.getElementsByName('ckDriverIds');
		for(var i=0;i<checkboxs.length;i++){
			checkboxs[i].checked = ckAllDriver.checked;
		}
	}

	function deleteAllBook(){

		//1.获取所有选中的司机的进行拼接
		var checkboxs = document.getElementsByName('ckDriverIds');
		var ids = '';
		for(var i=0;i<checkboxs.length;i++){
			if(checkboxs[i].checked == true){
				ids += checkboxs[i].value + ',';
			}
		}

		//2.删除最后一个逗号
		ids = ids.substring(0,ids.length - 1);

		//3.调用Servlet方法删除司机
		if(ids == '') return;//空字符串就不用删除了

		if(confirm('要删除的司机为[' + ids + ']?')){
			location.href = '${pageContext.request.contextPath}/DeleteAllDriverServlet?ids=' + ids;
		}
	}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/SearchDriverServlet"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查询条件</strong>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									姓名</td>
								<td class="ta_01" bgColor="#ffffff">
									<select id="cheIdSeclect"  class="textbox combo" name="name"  style="width: 180px; height: 35px;">
										<option value="">--请选择--</option>
										<c:forEach items="${pageResult.list}" var="driver">
											<option value="${driver.name}">${driver.name}</option>
										</c:forEach>
									</select>
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									性别：</td>
								<td class="ta_01" bgColor="#ffffff"><select name="sex"
									id="sex">
										<option value="" selected="selected">--选择性别--</option>
										<option value="男">男</option>
										<option value="女">女</option>

								</select></td>
							</tr>

							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									手机号码：</td>
								<td class="ta_01" bgColor="#ffffff">
									<select id="tel"  class="textbox combo" name="tel"  style="width: 180px; height: 35px;">
										<option value="">--请选择--</option>
										<c:forEach items="${pageResult.list}" var="driver">
											<option value="${driver.tel}">${driver.tel}</option>
										</c:forEach>
									</select>
								</td>

								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									油卡号：</td>
								<td class="ta_01" bgColor="#ffffff">
									<select id="oilCard"  class="textbox combo" name="oilCard"  style="width: 180px; height: 35px;">
										<option value="">--请选择--</option>
										<c:forEach items="${pageResult.list}" var="driver">
											<option value="${driver.oilCard}">${driver.oilCard}</option>
										</c:forEach>
									</select>
								</td>
							</tr>


							<tr>
								<td width="100" height="22" align="center" bgColor="#f5fafe"
									class="ta_01"></td>
								<td class="ta_01" bgColor="#ffffff"><font face="宋体"
									color="red"> &nbsp;</font>
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01"><br>
									<br></td>
                                <td align="left" bgColor="#ffffff" class="ta_01">
                                    <button type="submit" id="search" name="search"
                                            value="查询" class="button_view">
                                        查询
                                    </button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="reset" name="reset" value="重置"
                                           class="button_view"/>
                                </td>
							</tr>

						</table>
					</td>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>司机列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="delete" name="add" value="&#28155;&#21152;"
							class="button_add" onclick="deleteAllBook();">批量删除
						</button>
						<button type="button" id="add" name="add" value="添加"
							class="button_add" onclick="addProduct()">添加
						</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="5%"><input type="checkbox" id="ckAllDriver" onclick="checkAll();"/>全选或者全不选</td>
								<td align="center" width="10%">姓名</td>
								<td align="center" width="5%">性别</td>
								<td align="center" width="8%">年龄</td>
								<td align="center" width="12%">手机</td>
								<td align="center" width="15%">地址</td>
								<td align="center" width="13%">银行卡</td>
								<td align="center" width="12%">加油卡</td>
								<td width="5%" align="center">编辑</td>
								<td width="5%" align="center">删除</td>
							</tr>

							<c:forEach items="${pageResult.list}" var="driver">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td align="center" width="10%">
										<input type="checkbox" name="ckDriverIds" value="${driver.id}"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%">${driver.name}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">${driver.sex}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%">${driver.age}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${driver.tel}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" width="15%" align="center">${driver.address}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" width="13%" align="center">${driver.card}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" width="12%" align="center">${driver.oilCard}</td>
									<td align="center" style="HEIGHT: 22px" width="5%"><a
										href="${pageContext.request.contextPath}/FindDriverByIdServlet?id=${driver.id}">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand"> </a>
									</td>
									<td align="center" style="HEIGHT: 22px" width="5%"><a
										href="javascript:deleteById('${driver.id}','${driver.name}')">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
									</td>
								</tr>
							</c:forEach>
							<tr>
									<td colspan="18" align="right">
										当前页：${pageResult.currentPage}/${pageResult.totalPage}
										&nbsp;总条数:${pageResult.totalCount}
									</td>
							</tr>
							<tr>
									<td colspan="18" align="center">
										<c:if test="${pageResult.currentPage - 1 != 0}">
											<a href="${pageContext.request.contextPath }/DriverListServlet?page=${pageResult.currentPage - 1}">上一页</a>
										</c:if>
										<c:if test="${pageResult.totalPage != 0 }">
											<c:forEach begin="1" end="${pageResult.totalPage}" var="p">
												<a href="${pageContext.request.contextPath }/DriverListServlet?page=${p}">
													<%--加入判断--%>
													<c:choose>
														<c:when test="${pageResult.currentPage eq p}"><span style="color: red">${p}</span></c:when>
														<c:otherwise>${p}</c:otherwise>
													</c:choose>

												</a>
											</c:forEach>
										</c:if>

										<c:if test="${pageResult.currentPage + 1 != pageResult.totalPage + 1}">
											<a href="${pageContext.request.contextPath }/DriverListServlet?page=${pageResult.currentPage + 1}">下一页</a>
										</c:if>
									</td>
							</tr>
						</table>

					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

