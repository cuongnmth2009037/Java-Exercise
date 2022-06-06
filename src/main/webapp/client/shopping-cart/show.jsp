<%@ page import="com.example.product.t2009m1java.util.ShoppingCartHelper" %>
<%@ page import="com.example.product.t2009m1java.entity.ShoppingCart" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="com.example.product.t2009m1java.entity.CartItem" %>
<%
    ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(request);
    ShoppingCart shoppingCart = shoppingCartHelper.getCart();
    Locale loc = new Locale("vi", "VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
 %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/admin/assets/css/cart.css">
<h2>ShoppingCart</h2>
<div class="shopping-cart">
    <div class="column-labels">
        <label class="product-image">Image</label>
        <label class="product-details">Product</label>
        <label class="product-price">Price</label>
        <label class="product-quantity">Quantity</label>
        <label class="product-removal">Remove</label>
        <label class="product-line-price">Total</label>
    </div>

    <%for (CartItem cartItem : shoppingCart.getListItem()){%>
    <div class="product">
        <div class="product-image">
            <img src="<%=cartItem.getProductThumbnail()%>">
        </div>
        <div class="product-details"><%=cartItem.getProductName()%></div>
        <div class="product-price"><%=nf.format(cartItem.getUnitPrice())%></div>
        <div class="product-quantity">
            <%=cartItem.getQuantity()%>
<%--            <input type="number" class="product-quantity-input" data-product_id="@product.Id" data-product_price="@product.Price" value="" min="1">--%>
            <a class="product-quantity-input" href="/shopping-cart/add?productId=<%=cartItem.getProductId()%>&quantity=1">+</a>
        </div>
        <div class="product-removal">
            <a href="/shopping-cart/remove?productId=<%=cartItem.getProductId()%>">
            Remove
            </a>
        </div>
        <div class="product-line-price total-price-prod-@product.Id"><%=nf.format(shoppingCart.getTotalPrice())%></div>
    </div>
    <%}%>
</div>