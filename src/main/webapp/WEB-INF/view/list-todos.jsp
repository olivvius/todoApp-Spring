<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
    <body>
        <a href="http://localhost:8080/add-todo">Ajouter une tache toodoo</a> 
        <table>
            <tr>
                <th>id</th>
                <th>personne</th>
                <th>description</th>
                <th>target date</th>
            </tr>

            <c:forEach var="p" items="${list}">
                <tr>
                    <td><c:out value="${p.getId()}"/></td>
                    <td><c:out value="${p.getUsername()}"/></td>
                    <td><c:out value="${p.getDescription()}"/></td>
                    <td><c:out value="${p.getTargetDate()}"/></td>
                    <td>
                        <form:form action="/delete-todo" method="post" modelAttribute="delete">
                            <form:hidden path="id" value="${p.getId()}" />
                            <form:button>delete</form:button>
                        </form:form>
                    </td>
                    <td>
                        <form action="/modify-todo" method="get">
                            <input type="hidden" name="id" value="${p.getId()}">
                            <input type="submit" value="modify">
                        </form> 
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
