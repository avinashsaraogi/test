<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Manager Home</title>
</head>
<body>
        <div align="center">
            <h1>Book Details</h1>
            
            <table border="1">
			<th>Book Id</th>
                <th>Title</th>
                <th>Price</th>
                <th>volume</th>
                <th>Publish Date</th>
                <th>Subject Id</th>
                 
                <c:forEach var="book" items="${searchBook}" varStatus="status">
                <tr>
                    <td>${book.bookId}</td>
                    <td>${book.title}</td>
                    <td>${book.price}</td>
                    <td>${book.volume}</td>
                    <td>${book.publishDate}</td>
					<td>${book.subjectId}</td>
                    
                             
                </tr>
                </c:forEach>             
            </table>
        </div>

<br/>
    <br/>
    Go back to <a href="index">Choose the Option</a>
    </body>
</html>