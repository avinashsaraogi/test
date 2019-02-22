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
            <h1>Subject Details</h1>
            
            <table border="1">
			<th>Subject Id</th>
                <th>Duration In Hours</th>
                <th>Subject Title</th>
                                
                <c:forEach var="subject" items="${searchSubject}" varStatus="status">
                <tr>
                    <td>${subject.subjectId}</td>
                    <td>${subject.durationInHours}</td>
                    <td>${subject.subtitle}</td>
                    
                    
                             
                </tr>
                </c:forEach>             
            </table>
        </div>

<br/>
    <br/>
    Go back to <a href="index">Choose the Option</a>
    </body>
</html>