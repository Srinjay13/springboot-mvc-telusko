<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h1>Hello, Welcome to My JSP App from Srinjay!</h1>
    <p>This is the index.jsp page running on Internal Tomcat.</p>
	
	<form action="subtract" method="post">
	        <label for="name">Enter your number 1: </label>
	        <input type="text" id="num1" name="num1"/>
			<label for="name">Enter your number 2: </label>
		    <input type="text" id="num2" name="num2"/>
			<input type="submit">
	    </form>
		
		<br>
		<br>
		<form action="addCoder" method="post">
			        <label for="coderId">Enter your id: </label>
			        <input type="text" id="coderId" name="coderId"/>
					<label for="coderName">Enter your name: </label>
				    <input type="text" id="coderName" name="coderName"/>
					<input type="submit">
			    </form>
</body>
</html>
