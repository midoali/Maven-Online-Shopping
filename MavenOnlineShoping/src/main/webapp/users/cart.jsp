<%-- 
    Document   : cart
    Created on : Mar 10, 2017, 9:32:04 AM
    Author     : Yousef
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:directive.include file="/header.jsp"/>
<script>
    $(document).ready(function (c) {
        $('.close1').on('click', function (c) {
            var item_id = $(this).attr("item_id");
            $("#" + item_id).fadeOut('slow', function (c) {
                $(this).remove();
//                $.ajax({
//                    url: 'http://localhost:8084${homeUrl}/users/deleteCartItem',
//                    type:"POST",
//                    data:{itemIndex: item_id},
//                    success: function () {
//                        alert('success');
//                    },
//                    error: function (data) {
//                        console.log(data);
//                    },
//                    dataType: 'json'
//                });
                $.post("${homeUrl}/users/deleteCartItem",
                        {itemIndex: item_id},
                        function (data) {          
                            console.log(data);
                           if(data.status == 'ok'){
                               console.log(data.message);
                           }
                        });
            });
        });
    });
</script>
<div class="cart">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li class="active">Cart</li>
        </ol>
        <div class="cart-top">
            <a href="index.html"><< home</a>
        </div>	

        <div class="col-md-9 cart-items">
            <c:set var="numItems" value="${myShoppingCart.getItems().size()}" />
            <h2>My Shopping Bag (${numItems})</h2>
            <c:set var="counter" value="0" />
            <c:forEach items="${myShoppingCart.getItems()}" var="currentItem" >

                <div class="cart-header" id="${counter}" >
                    <div class="close1" item_id="${counter}"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${homeUrl}/Resources/images/products/${currentItem.getProduct().getImagePath()}"/>
                        </div>
                        <div class="cart-item-info">
                            <h3>${currentItem.getProduct().getType()}<span>Model No: ${currentItem.getProduct().getId()}</span></h3>
                            <h4><span>Price. $ </span>${currentItem.getProduct().getPrice()}</h4>
                            <p class="qty">Quantity ::</p>
                            <input min="1" max="${currentItem.getProduct().getQuantity()}" type="number" id="quantity" name="quantity" value="${currentItem.getQuantity()}" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                        <div class="delivery">
                            <p>Service Charges:: Rs.50.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>						
                    </div>
                </div>
                <c:set var="counter" value="${counter+1}" />
            </c:forEach>

        </div>

        <div class="col-md-3 cart-total">
            <a class="continue" href="#">Continue to basket</a>
            <div class="price-details">
                <h3>Price Details</h3>
                <span>Total</span>
                <span class="total">350.00</span>
                <span>Discount</span>
                <span class="total">---</span>
                <span>Delivery Charges</span>
                <span class="total">100.00</span>
                <div class="clearfix"></div>				 
            </div>	
            <h4 class="last-price">TOTAL</h4>
            <span class="total final">450.00</span>
            <div class="clearfix"></div>
            <a class="order" href="BuyServlet">Place Order</a>
            <div class="total-item">
                <h3>OPTIONS</h3>
                <h4>COUPONS</h4>
                <a class="cpns" href="#">Apply Coupons</a>
                <p><a href="#">Log In</a> to use accounts - linked coupons</p>
            </div>
        </div>
    </div>
</div>
<!--fotter-->
<div class="fotter-logo">
    <div class="container">
        <div class="ftr-logo"><h3><a href="index.html">NEW FASHIONS</a></h3></div>
        <div class="ftr-info">
            <p>&copy; 2015 All Rights Reseverd Design by <a href="http://w3layouts.com/">W3layouts</a> </p>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!--fotter//-->

</body>
</html>