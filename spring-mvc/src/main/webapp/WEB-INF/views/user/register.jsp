<%--
  Created by IntelliJ IDEA.
  User: alvin
  Date: 2016/5/29
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
  <form method="post" action="<c:url value="/user.html"/>">
    <table>
      <tr>
        <td>用户名：</td>
        <td>
          <input name="userName" type="text"/>
        </td>
      </tr>
      <tr>
        <td>密码：</td>
        <td>
          <input name="password" type="password"/>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" name="提交"/>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>
