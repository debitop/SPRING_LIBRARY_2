<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 04.09.2018
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/student/addStudent">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>age</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>admin</td>
            <td><input type="checkbox" name="admin"></td>
        </tr>
    </table>
    <input type="submit" name="save">

</form>
</body>
</html>
