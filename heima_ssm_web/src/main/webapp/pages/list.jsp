<%--
  Created by IntelliJ IDEA.
  User: Suger121
  Date: 2020/9/25
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${userList}" var="user">
    <tr>
        <td><input name="ids" type="checkbox"></td>
        <td>${user.id }</td>
        <td>${user.username }</td>
        <td>${user.email }</td>
        <td>${user.phoneNum }</td>
        <td>${user.statusStr }</td>
        <td class="text-center">
            <a href="${pageContext.request.contextPath}/user/findById.do?id=${user.id}" class="btn bg-olive btn-xs">详情</a>
            <a href="${pageContext.request.contextPath}/user/findUserByIdAndAllRole.do?id=${user.id}" class="btn bg-olive btn-xs">添加角色</a>
        </td>
    </tr>
</c:forEach>
</body>
</html>
