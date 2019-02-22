<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelloWorld page</title>
</head>
<body>
    
		<form method="post" action="chooseOption">
		<table>
		<tr> <td colspan="3"><p> 
		Following is the menu: <br/>
		1. Add a Subject: <br/>
		2. Add a Book:<br/>
		3. Delete a Subject:<br/>
		4. Delete a book:<br/>
		5. Search for a book:<br/>
		6. Search for a subject:<br/>
		7. Sort Book by Title:<br/>
		8. Sort Subject By Subject Title:<br/>
		9. Sort Book by Publish date:<br/>
		
		
		</p></td></tr>
		
		<tr>
					<td>Please enter the Option</td>
					<td>:</td>
					<td><input type="text" name="option"/></td>
				</tr>
		<tr><td colspan="3"> 
		<input type="submit" value="Submit"/></td>
		</tr>
		</table>
		</form> 
</body>

</html>