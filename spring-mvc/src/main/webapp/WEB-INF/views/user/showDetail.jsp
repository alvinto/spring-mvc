<%--
  Created by IntelliJ IDEA.
  User: alvin
  Date: 2016/5/30
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户详细信息</title>
</head>
<body>
  <table>
    <tr>
      <td>用户名：</td>
      <td colspan="2">密码：</td>

    </tr>
    <tr>
      <td>
        <input name="userName" type="text" value="${user.username}"/>
      </td>
      <td>
        <input name="password" type="password" value="${user.password}"/>
      </td>
      <td>
        <a href="/spring-mvc/user/delete.html?username=${user.username}">删除</a>
      </td>
    </tr>
  </table>
</body>
</html>
