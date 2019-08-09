<%--
  Created by IntelliJ IDEA.
  User: supeng
  Date: 2019-08-04
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/admin/css/Style.css" type="text/css" rel="stylesheet"/>
    <style type="text/css">
        <!--
        body {
            background-color: #FFFFFF;
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
        }

        body, td, th {
            color: #000000;
        }

        -->
    </style>
    <style>
        BODY {
            SCROLLBAR-FACE-COLOR: #cccccc;
            SCROLLBAR-HIGHLIGHT-COLOR: #ffffFF;
            SCROLLBAR-SHADOW-COLOR: #ffffff;
            SCROLLBAR-3DLIGHT-COLOR: #cccccc;
            SCROLLBAR-ARROW-COLOR: #ffffff;
            SCROLLBAR-TRACK-COLOR: #ffffFF;
            SCROLLBAR-DARKSHADOW-COLOR: #cccccc;
        }
    </style>
    <script type="text/javascript">
        function check1()
        {
            if(document.ThisForm.username.value=="")
            {
                alert("请输入用户名");
                document.ThisForm.username.focus();
                return false;
            }
            if(document.ThisForm.userPw.value=="")
            {
                alert("请输入密码");
                document.ThisForm.userPw.focus();
                return false;
            }
            if(document.ThisForm.userType.value=="-1")
            {
                alert("请选择登陆身份");
                document.ThisForm.userType.focus();
                return false;
            }
        }

    </script>
</head>
<body>
<br>
<br>
<br>
<br>
<table width="559" height="423" border="0" align="center" cellpadding="0" cellspacing="0"
        bgcolor="#f0ffff">
    <tr>
        <td>
            <div align="center" style="FONT-WEIGHT: bold; FONT-SIZE: 33pt;">车辆管理系统</div>
        </td>
    </tr>
    <tr>
        <td width="559" valign="middle" align="center">
            <form name="ThisForm" method="POST" action="/carManager/LoginServlet">
                <table width="410" height="198" border="1" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="10" colspan="2"></td>
                    </tr>

                    <tr>
                        <td height="39" align="center"><span class="STYLE15"><div
                                style="font-family:宋体;font-size-adjust: inherit">用户名：</div></span></td>
                        <td width="300" valign="middle" align="center">
                            <input name="username" type="text" class="input2"
                                   onMouseOver="this.style.background='#F0DAF3';"
                                   onMouseOut="this.style.background='#FFFFFF'">
                        </td>
                    </tr>
                    <tr>
                        <td height="10" colspan="2" valign="bottom"></td>
                    </tr>

                    <tr>
                        <td height="39" align="center"><span class="STYLE15">密 码：</span></td>
                        <td valign="middle" align="center"><input name="userPw" type="password" size="21" class="input2"
                                                                  align="bottom"
                                                                  onMouseOver="this.style.background='#F0DAF3';"
                                                                  onMouseOut="this.style.background='#FFFFFF'"></td>
                    </tr>

                    <tr>
                        <td height="39" align="center"><span class="STYLE15">请选择身份：</span></td>
                        <td valign="middle" align="center">
                            <select class="INPUT_text" name="userType">
                                <option value="-1" selected="selected">请选择登陆身份</option>
                                <option value="chaoji">超级管理员</option>
                                <option value="putong">普通管理员</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td height="10" colspan="2" valign="bottom"></td>
                    </tr>
                    <tr>
                        <td colspan="2" valign="middle" align="center">&nbsp; &nbsp; &nbsp; &nbsp;
                            <input name="button" type="submit" class="submit" size="50" value="登录" onclick="check1()"> &nbsp;
                            <input name="Submit2" type="reset" class="submit1" value="重置">
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
