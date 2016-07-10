<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
    <title>Jelly</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/css/style.css" />" />
</head>
<body>
    <h1>Create a new Jelly Account</h1>
    <h3>Online dating for everyone</h3>
    <div id="registrationForm">
        <sf:form method="POST" commandName="registrationData">
            <table class="center">
                <tr>
                    <td colspan="2"><sf:errors path="*" element="div" cssClass="errors" /></td>
                </tr>
                <tr>
                    <td><sf:label path="email" cssErrorClass="error">Email</sf:label>:</td>
                    <td><sf:input path="email" type="email" /></td>
                </tr>
                <tr>
                    <td><sf:label path="password" cssErrorClass="error">Password</sf:label>:</td>
                    <td><sf:password path="password" showPassword="false"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="register"/></td>
                </tr>
                <tr>
                    <td colspan="2">Already have an account? <a href="login"> login page</a> </td>
                </tr>
            </table>
        </sf:form>

    </div>
</body>
</html>