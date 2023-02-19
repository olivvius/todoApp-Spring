<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
    <body>
        <br />
        <form:form method = "POST" action = "/modify-todo" modelAttribute="modify">
            <table>
                <tr><td><form:input path = "id" /></td></tr>
                <tr>
                    <td><form:label path = "username">Name</form:label></td>
                    <td><form:input path = "username" /></td>
                </tr>
                <tr>
                    <td><form:label path = "description">description</form:label></td>
                    <td><form:input path = "description" /></td>
                </tr>
                <tr>
                    <td><form:label path = "targetDate">targetDate</form:label></td>
                    <td><form:input path = "targetDate" /></td>
                </tr>
                <tr>
                    <td colspan = "2">
                        <input type = "submit" value = "Submit"/>
                    </td>
                </tr>
            </table>  
        </form:form>
        <br />  
  

    </body>
</html>
