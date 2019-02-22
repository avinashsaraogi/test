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
 
    <h2>Registration Subject</h2>
  
    <form:form method="POST" action="saveSubject.htm" modelAttribute="subject">
        <form:input type="hidden" path="subjectId" id="subjectId" />
        <table>
            <tr>
                <td><label for="durationInHours">Enter Duration In Hours: </label> </td>
                <td><form:input path="durationInHours" id="durationInHours"/></td>
                <td><form:errors path="durationInHours" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="subtitle">Enter Sub Title: </label> </td>
                <td><form:input path="subtitle" id="subtitle"/></td>
                <td><form:errors path="subtitle" cssClass="subtitle"/></td>
            </tr>
     		
              <tr>
                <td>Book Id List:  </td>
                <td colspan="2">${bookIds}</td>
                
            </tr>     
     		<tr>
                <td><label for="bookId">Enter the Book ID references from the above list (comma separated): </label> </td>
                <td><form:input path="bookId" id="bookId"/></td>
                <td><form:errors path="bookId" cssClass="bookId"/></td>
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