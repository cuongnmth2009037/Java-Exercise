<%@ page import="com.example.product.t2009m1java.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Product Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/product/create" class="nav-link">Product List</a></li>
        </ul>
    </nav>
</header>
<br>
    <%
    Product product = (Product) request.getAttribute("product");
%>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="/product/update" method="post">
                <fieldset class="form-group">
                    <input type="hidden"  class="form-control" name="id" value="<%= product.getId() %>" >
                </fieldset>
                <fieldset class="form-group">
                    <label>Name</label> <input type="text"  class="form-control" name="name" value="<%= product.getName() %>" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Description</label> <input type="text"  class="form-control" name="description" value="<%= product.getDescription() %>">
                </fieldset>
                <fieldset class="form-group">
                    <label>Detail</label> <input type="text"  class="form-control" name="detail" value="<%= product.getDetail() %>">
                </fieldset>
                <fieldset class="form-group">
                    <label>Thumbnail</label> <input type="text"  class="form-control" name="thumbnail" value="<%= product.getThumbnail() %>">
                </fieldset>
                <fieldset class="form-group">
                    <label>Price</label> <input type="number"  class="form-control" name="price" value="<%= product.getPrice() %>" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>ManufactureEmail</label> <input type="email"  class="form-control" name="manufactureEmail" value="<%= product.getManufactureEmail() %>">
                </fieldset>
                <fieldset class="form-group">
                    <label>ManufacturePhone</label> <input type="tel"  class="form-control" name="manufacturePhone" value="<%= product.getManufacturePhone() %>">
                </fieldset>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</html>