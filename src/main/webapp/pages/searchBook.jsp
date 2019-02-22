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
 
    <h2>Search/Delete Book</h2>
  
    <form:form method="POST" action="${action}" modelAttribute="book">
        
        <table>
        	<tr>
                <td>Book Id List:  </td>
                <td colspan="2">${bookIds}</td>
                
            </tr>   
            <tr>
                <td><label for="bookId">Enter the Book ID references from the above list : </label> </td>
                <td><form:input path="bookId" id="bookId"/></td>
                <td><form:errors path="bookId" cssClass="bookId"/></td>
            </tr>
         
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${search}">
                            <input type="submit" id="search" value="Search"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" id="Delete"value="Delete"/>
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