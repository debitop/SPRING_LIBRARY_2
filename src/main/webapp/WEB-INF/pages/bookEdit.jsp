<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 04.09.2018
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="/book/editBook/{bookId}">
    <table>
        <tr>
            <td><form:label path="bookId">Id</form:label></td>
            <td><form:input path="bookId" disabled="true"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="studentId">StudentId</form:label></td>
            <td><form:input path="studentId" disabled="true"/></td>
        </tr>
        <tr>
            <td><form:label path="author">Author</form:label></td>
            <td><form:input path="author"/></td>
        </tr>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title"/></td>
        </tr>
    </table>
    <input type="submit" name="Save">
</form:form>
</body>
</html>
