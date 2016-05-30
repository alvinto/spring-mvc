<%--
  Created by IntelliJ IDEA.
  User: alvin
  Date: 2016/5/30
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户详细信息</title>
</head>
<body>
<table>
  <tr>
    <td>用户名：</td>
    <td>
      <input name="userName" type="text" value="${user.username}"/>
    </td>
  </tr>
  <tr>
    <td>密码：</td>
    <td>
      <input name="password" type="password" value="${user.password}"/>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <input type="submit" name="提交"/>
    </td>
  </tr>
</table>
</body>
</html>
