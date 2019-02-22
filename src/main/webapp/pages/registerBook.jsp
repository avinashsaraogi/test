<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Registration Book</h2>
  
    <form:form method="POST" action="saveBooks.htm" modelAttribute="book">
        <form:input type="hidden" path="bookId" id="bookId" />
        <table>
            <tr>
                <td><label for="title">Enter Title: </label> </td>
                <td><form:input path="title" id="title"/></td>
                <td><form:errors path="title" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="price">Enter Price: </label> </td>
                <td><form:input path="price" id="price"/></td>
                <td><form:errors path="price" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="volume">Enter Volume: </label> </td>
                <td><form:input path="volume" id="volume"/></td>
                <td><form:errors path="volume" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="inputDate">Enter Date[yyyy/MM/dd]:  </label> </td>
                <td><form:input path="inputDate" id="inputDate"/></td>
                <td><form:errors path="inputDate" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/index.jsp' />">Choose the Option</a>
</body>
</html>