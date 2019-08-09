<%--
  Created by IntelliJ IDEA.
  User: supeng
  Date: 2019-07-26
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellspacing="0" cellpadding="1" rules="all"
       bordercolor="gray" border="1" id="DataGrid1"
       style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
    <tr
            style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

        <td align="center" width="18%">文件名称</td>
        <td align="center" width="7%">编辑</td>
    </tr>

    <c:forEach items="${fileList}" var="fileName">
        <tr onmouseover="this.style.backgroundColor = 'white'"
            onmouseout="this.style.backgroundColor = '#F5FAFE';">
            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                width="18%">${fileName}
            </td>
            <td align="center" style="HEIGHT: 22px" width="7%"><a
                    href="${pageContext.request.contextPath}/DownloadServlet?fileName=${fileName}">
                <img
                        src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
                        border="0" style="CURSOR: hand"> </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
