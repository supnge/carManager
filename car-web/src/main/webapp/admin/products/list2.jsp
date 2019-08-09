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
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/products/add.jsp";
	}
	
	function deleteById(bookId,bookName) {
		if(confirm('是否要删除[' + bookName + ']?')){
			location.href = '${pageContext.request.contextPath}/DeleteBookByIdServlet?id=' + bookId;
		}
	}
	
	//实现全选或不全选的js方法
	function checkAll() {
		//1.获取全选按钮的状态
		var ckAllBook = document.getElementById('ckAllBook');
		//alert(ckAllBook.checked);
		
		//2.获取每一行的checkbox,然后设置选中的状态
		var checkboxs = document.getElementsByName('ckBookIds');
		for(var i=0;i<checkboxs.length;i++){
			checkboxs[i].checked = ckAllBook.checked;
		}
	}
	
	function deleteAllBook(){
		
		//1.获取所有选中的书的进行拼接
		var checkboxs = document.getElementsByName('ckBookIds');
		var ids = '';
		for(var i=0;i<checkboxs.length;i++){
			if(checkboxs[i].checked == true){
				ids += checkboxs[i].value + ',';
			}
		}
		
		//2.删除最后一个逗号
		ids = ids.substring(0,ids.length - 1);
		
		//3.调用Servlet方法删除图书
		if(ids == '') return;//空字符串就不用删除了
		
		location.href = '${pageContext.request.contextPath}/DeleteAllBookServlet?ids=' + ids;
	}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/SearchBookServlet"
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
									商品编号</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="id" size="15" value="" id="Form1_userName2" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									类别：</td>
								<td class="ta_01" bgColor="#ffffff"><select name="category"
									id="category">
										<option value="" selected="selected">--选择商品类加--</option>
										<option value="文学">文学</option>
										<option value="生活">生活</option>
										<option value="计算机">计算机</option>
										<option value="外语">外语</option>
										<option value="经营">经营</option>
										<option value="励志">励志</option>
										<option value="社科">社科</option>
										<option value="学术">学术</option>
										<option value="少儿">少儿</option>
										<option value="艺术">艺术</option>
										<option value="原版">原版</option>
										<option value="科技">科技</option>
										<option value="考试">考试</option>
										<option value="生活百科">生活百科</option>
								</select></td>
							</tr>

							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									商品名称：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="name" size="15" value="" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									价格区间(元)：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="minprice" size="10" value="" />- <input type="text"
									name="maxprice" size="10" value="" /></td>
							</tr>
							
							
							<tr>
								<td width="100" height="22" align="center" bgColor="#f5fafe"
									class="ta_01"></td>
								<td class="ta_01" bgColor="#ffffff"><font face="宋体"
									color="red"> &nbsp;</font>
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01"><br>
									<br></td>
								<td align="right" bgColor="#ffffff" class="ta_01">
									<button type="submit" id="search" name="search"
										value="&#26597;&#35810;" class="button_view">
										&#26597;&#35810;</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="reset" name="reset" value="&#37325;&#32622;"
									class="button_view" />
								</td>
							</tr>
							
						</table>
					</td>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="delete" name="add" value="&#28155;&#21152;"
							class="button_add" onclick="deleteAllBook();">批量删除
						</button>
						<button type="button" id="add" name="add" value="&#28155;&#21152;"
							class="button_add" onclick="addProduct()">&#28155;&#21152;
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
								<td align="center" width="10%"><input type="checkbox" id="ckAllBook" onclick="checkAll();"/>全选或者全不选</td>
								<td align="center" width="24%">商品编号</td>
								<td align="center" width="18%">商品名称</td>
								<td align="center" width="9%">商品价格</td>
								<td align="center" width="9%">商品数量</td>
								<td width="8%" align="center">商品类别</td>
								<td width="8%" align="center">编辑</td>
								<td width="8%" align="center">删除</td>
							</tr>

							<c:forEach items="${pageResult.list}" var="book">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td align="center" width="10%">
										<input type="checkbox" name="ckBookIds" value="${book.id}"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23">${book.id}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${book.name}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${book.price}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${book.pnum}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${book.category}</td>
									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="${pageContext.request.contextPath}/FindBookByIdServlet?id=${book.id}">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand"> </a>
									</td>
									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="javascript:deleteById('${book.id}','${book.name}')">
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
											<a href="${pageContext.request.contextPath }/BookListServlet?page=${pageResult.currentPage - 1}">上一页</a>
										</c:if>
										<c:if test="${pageResult.totalPage != 0 }">
											<c:forEach begin="1" end="${pageResult.totalPage}" var="p">
												<a href="${pageContext.request.contextPath }/BookListServlet?page=${p}">
													<%--加入判断--%>
													<c:choose>
														<c:when test="${pageResult.currentPage eq p}"><span style="color: red">${p}</span></c:when>
														<c:otherwise>${p}</c:otherwise>
													</c:choose>

												</a>
											</c:forEach>
										</c:if>
										
										<c:if test="${pageResult.currentPage + 1 != pageResult.totalPage + 1}">
											<a href="${pageContext.request.contextPath }/BookListServlet?page=${pageResult.currentPage + 1}">下一页</a>
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

