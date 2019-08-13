<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/admin/css/Style.css"
          rel="stylesheet" type="text/css"/>
    <script language="javascript"
            src="${pageContext.request.contextPath}/admin/js/public.js"></script>
    <%--下拉选择--%>
    <link href="${pageContext.request.contextPath}/admin/css/jquery.searchableSelect.css" rel="stylesheet"
          type="text/css">
    <script src="${pageContext.request.contextPath}/admin/jquery/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/jquery/jquery.searchableSelect.js"></script>
    <%--日历--%>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/admin/js/My97DatePicker/WdatePicker.js"></script>

    <script type="text/javascript">

        $(function () {

            // 这个功能会与下面的去重复冲突，不知道啥情况
            $('select').searchableSelect();

            // $("#cheIdSeclect").click(function() {
            //     console.log("开始去重");
            //     $("select option").each(function() {
            //         text = $(this).text();
            //         if($("select option:contains("+text+")").length > 1)
            //             $("select option:contains("+text+"):gt(0)").remove();
            //     });
            // });


        });


        function addProduct() {
            window.location.href = "${pageContext.request.contextPath}/RecordAddServlet";
            <%--window.location.href = "${pageContext.request.contextPath}/admin/products/recordAdd.jsp";--%>
        }

        function deleteById(id, name) {
            if (confirm('是否要删除[' + name + ']?')) {
                location.href = '${pageContext.request.contextPath}/DeleteRecordByIdServlet?id=' + id;
            }
        }

        //实现全选或不全选的js方法
        function checkAll() {
            //1.获取全选按钮的状态
            var ckAllDriver = document.getElementById('ckAllDriver');
            //alert(ckAllBook.checked);

            //2.获取每一行的checkbox,然后设置选中的状态
            var checkboxs = document.getElementsByName('ckRecordIds');
            for (var i = 0; i < checkboxs.length; i++) {
                checkboxs[i].checked = ckAllDriver.checked;
            }
        }

        function deleteAllBook() {

            //1.获取所有选中的司机的进行拼接
            var checkboxs = document.getElementsByName('ckRecordIds');
            var ids = '';
            for (var i = 0; i < checkboxs.length; i++) {
                if (checkboxs[i].checked == true) {
                    ids += checkboxs[i].value + ',';
                }
            }

            //2.删除最后一个逗号
            ids = ids.substring(0, ids.length - 1);

            //3.调用Servlet方法删除司机
            if (ids == '') return;//空字符串就不用删除了

            if (confirm('要删除的司机为[' + ids + ']?')) {
                location.href = '${pageContext.request.contextPath}/DeleteAllRecordsServlet?ids=' + ids;
            }
        }
    </script>
</HEAD>
<body>
<br>
<form id="Form1" name="Form1"
      action="${pageContext.request.contextPath}/SearchRecordServlet"
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
                            车辆编号
                        </td>
                        <td class="ta_01" bgColor="#ffffff">
                            <select id="cheIdSeclect"  class="textbox combo" name="cheId"  style="width: 180px; height: 35px;">
                                <option value="">--请选择车牌号--</option>
                                <c:forEach items="${cheIdInRecord}" var="record">
                                    <option value="${record.id}">${record.chepai}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td height="22" align="center" bgColor="#f5fafe" class="ta_01">
                        </td>
                        <td class="ta_01" bgColor="#ffffff">
                        </td>

                    </tr>

                    <tr>
                        <td height="22" align="center" bgColor="#f5fafe" class="ta_01">
                            出车时间：
                        </td>
                        <td class="ta_01" bgColor="#ffffff">
                            <input type="text" name="start1" size="15" value="" id="start1"
                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/> ----
                            <input type="text" name="start2" size="15" value="" id="start2"
                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
                        </td>

                        <td height="22" align="center" bgColor="#f5fafe" class="ta_01">
                            回来时间：
                        </td>
                        <td class="ta_01" bgColor="#ffffff">
                            <input type="text" name="end1" size="15" value="" id="end1"
                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/> ----
                            <input type="text" name="end2" size="15" value="" id="end2"
                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
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
            <td class="ta_01" align="center" bgColor="#afd1f3"><strong>出车记录列表</strong>
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
                        <td align="center" width="5%"><input type="checkbox" id="ckAllDriver" onclick="checkAll();"/>全选或者全不选
                        </td>
                        <td align="center" width="10%">车牌号</td>
                        <td align="center" width="5%">出车时间</td>
                        <td align="center" width="8%">回来时间</td>
                        <td align="center" width="12%">起始地址</td>
                        <td align="center" width="15%">目的地址</td>
                        <td align="center" width="13%">石油类型</td>
                        <td width="5%" align="center">编辑</td>
                        <td width="5%" align="center">删除</td>
                    </tr>

                    <c:forEach items="${recordPageResult.list}" var="record">
                        <tr onmouseover="this.style.backgroundColor = 'white'"
                            onmouseout="this.style.backgroundColor = '#F5FAFE';">
                            <td align="center" width="10%">
                                <input type="checkbox" name="ckRecordIds" value="${record.id}"/>
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="5%">${record.chepai}</td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="10%">${record.kaichushijian}</td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="5%">${record.huilaishijian}</td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${record.qishidizhi}</td>
                            <td style="CURSOR: hand; HEIGHT: 22px" width="15%" align="center">${record.mudidizhi}</td>
                            <td style="CURSOR: hand; HEIGHT: 22px" width="13%" align="center">${record.shiyou}</td>
                            <td align="center" style="HEIGHT: 22px" width="5%"><a
                                    href="${pageContext.request.contextPath}/FindRecordByIdServlet?id=${record.id}">
                                <img
                                        src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
                                        border="0" style="CURSOR: hand"> </a>
                            </td>
                            <td align="center" style="HEIGHT: 22px" width="5%"><a
                                    href="javascript:deleteById('${record.id}','${record.chepai}')">
                                <img
                                        src="${pageContext.request.contextPath}/admin/images/i_del.gif"
                                        width="16" height="16" border="0" style="CURSOR: hand">
                            </a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="18" align="right">
                            当前页：${recordPageResult.currentPage}/${recordPageResult.totalPage}
                            &nbsp;总条数:${recordPageResult.totalCount}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="18" align="center">
                            <c:if test="${recordPageResult.currentPage - 1 != 0}">
                                <a href="${pageContext.request.contextPath }/RecordListServlet?page=${recordPageResult.currentPage - 1}">上一页</a>
                            </c:if>
                            <c:if test="${recordPageResult.totalPage != 0 }">
                                <c:forEach begin="1" end="${recordPageResult.totalPage}" var="p">
                                    <a href="${pageContext.request.contextPath }/RecordListServlet?page=${p}">
                                            <%--加入判断--%>
                                        <c:choose>
                                            <c:when test="${recordPageResult.currentPage eq p}"><span
                                                    style="color: red">${p}</span></c:when>
                                            <c:otherwise>${p}</c:otherwise>
                                        </c:choose>

                                    </a>
                                </c:forEach>
                            </c:if>

                            <c:if test="${recordPageResult.currentPage + 1 != recordPageResult.totalPage + 1}">
                                <a href="${pageContext.request.contextPath }/RecordListServlet?page=${recordPageResult.currentPage + 1}">下一页</a>
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

