
<%@ page import="com.example.product.t2009m1java.entity.Account" %><%
    Account account = (Account) request.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body class="w3-container w3-auto">

<div class="w3-panel w3-green">
    <h3>Register Success!</h3>
</div>
<h1>Username: <%=account.getUsername()%></h1>
<h1>Password: <%=account.getPassword()%></h1>
</body>
</html>
