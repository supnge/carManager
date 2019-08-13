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
	<%--下拉选择--%>
	<link href="${pageContext.request.contextPath}/admin/css/jquery.searchableSelect.css" rel="stylesheet"
		  type="text/css">
	<script src="${pageContext.request.contextPath}/admin/jquery/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/admin/jquery/jquery.searchableSelect.js"></script>

<script type="text/javascript">
	$(function () {
		$('select').searchableSelect();
	});
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/GoodsAddServlet";
		<%--window.location.href = "${pageContext.request.contextPath}/admin/products/goodsAdd.jsp";--%>
	}

	function deleteById(id,name) {
		if(confirm('货物信息与合同信息关联，谨慎删除！！！是否要删除[' + name + ']?')){
			location.href = '${pageContext.request.contextPath}/DeleteGoodsByIdServlet?id=' + id;
		}
	}

	//实现全选或不全选的js方法
	function checkAll() {
		//1.获取全选按钮的状态
		var ckAllGoods = document.getElementById('ckAllGoods');
		//alert(ckAllBook.checked);

		//2.获取每一行的checkbox,然后设置选中的状态
		var checkboxs = document.getElementsByName('ckGoodsIds');
		for(var i=0;i<checkboxs.length;i++){
			checkboxs[i].checked = ckAllGoods.checked;
		}
	}

	function deleteAllBook(){

		//1.获取所有选中的司机的进行拼接
		var checkboxs = document.getElementsByName('ckGoodsIds');
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

		if(confirm('要删除的货物为[' + ids + ']?')){
			location.href = '${pageContext.request.contextPath}/DeleteAllGoodsServlet?ids=' + ids;
		}
	}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/SearchGoodsServlet"
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
									车辆编码：</td>
								<td class="ta_01" bgColor="#ffffff">
									<select id="cheIdSeclect"  class="textbox combo" name="carId"  style="width: 180px; height: 35px;">
										<option value="">--请选择车牌号--</option>
										<c:forEach items="${cheIdInGoods}" var="record">
											<option value="${record.id}">${record.chepai}</option>
										</c:forEach>
									</select>
								</td>

								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									货物名称：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
																		   name="name" size="15" value="" id="Form1_Name" class="bg" />
								</td>
							</tr>

							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									单价：</td>
								<td class="ta_01" bgColor="#ffffff">
									<input type="text" name="danjia" size="15" value="" id="danjia" class="bg" />
								</td>

								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									车辆载重：</td>
								<td class="ta_01" bgColor="#ffffff">
									<input type="text" name="carZaizhong" size="15" value="" id="carZaizhong" class="bg" />
								</td>
							</tr>
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									总价：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
																		   name="zongjia" size="15" value="" id="Form1_zongjia" class="bg" />
								</td>
								<<td align="right" bgColor="#ffffff" class="ta_01"><br>
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
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>货物列表</strong>
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
								<td align="center" width="5%"><input type="checkbox" id="ckAllGoods" onclick="checkAll();"/>全选或者全不选</td>
								<td align="center" width="10%">货物名称</td>
								<td align="center" width="5%">单价</td>
								<td align="center" width="8%">车牌号码</td>
								<td align="center" width="12%">车辆载重</td>
								<td align="center" width="15%">总价</td>
								<td width="5%" align="center">编辑</td>
								<td width="5%" align="center">删除</td>
							</tr>

							<c:forEach items="${goodsPageResult.list}" var="goods">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td align="center" width="10%">
										<input type="checkbox" name="ckGoodsIds" value="${goods.id}"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" width="15%" align="center">${goods.name}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" width="13%" align="center">${goods.danjia}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" width="12%" align="center">${goods.chepai}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" width="12%" align="center">${goods.carZaizhong}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" width="12%" align="center">${goods.zongjia}
										<input type="hidden" name="remark" value="${goods.remark}">
									</td>
									<td align="center" style="HEIGHT: 22px" width="5%"><a
										href="${pageContext.request.contextPath}/FindGoodsByIdServlet?id=${goods.id}">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand"> </a>
									</td>
									<td align="center" style="HEIGHT: 22px" width="5%"><a
										href="javascript:deleteById('${goods.id}','${goods.name}')">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
									</td>
								</tr>
							</c:forEach>
							<tr>
									<td colspan="18" align="right">
										当前页：${goodsPageResult.currentPage}/${goodsPageResult.totalPage}
										&nbsp;总条数:${goodsPageResult.totalCount}
									</td>
							</tr>
							<tr>
									<td colspan="18" align="center">
										<c:if test="${goodsPageResult.currentPage - 1 != 0}">
											<a href="${pageContext.request.contextPath }/GoodsListServlet?page=${goodsPageResult.currentPage - 1}">上一页</a>
										</c:if>
										<c:if test="${goodsPageResult.totalPage != 0 }">
											<c:forEach begin="1" end="${goodsPageResult.totalPage}" var="p">
												<a href="${pageContext.request.contextPath }/GoodsListServlet?page=${p}">
													<%--加入判断--%>
													<c:choose>
														<c:when test="${goodsPageResult.currentPage eq p}"><span style="color: red">${p}</span></c:when>
														<c:otherwise>${p}</c:otherwise>
													</c:choose>

												</a>
											</c:forEach>
										</c:if>

										<c:if test="${goodsPageResult.currentPage + 1 != goodsPageResult.totalPage + 1}">
											<a href="${pageContext.request.contextPath }/GoodsListServlet?page=${goodsPageResult.currentPage + 1}">下一页</a>
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

