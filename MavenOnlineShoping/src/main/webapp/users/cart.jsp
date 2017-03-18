<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:directive.include file="/header.jsp"/>
<script>

    $(document).ready(function (c) {
        $('.close1').on('click', function (c) {
            var item_id = $(this).attr("item_id");
            $("#" + item_id).fadeOut('slow', function (c) {
                $(this).remove();
                $.post("${homeUrl}/users/deleteCartItem",
                        {itemIndex: item_id},
                        function (data) {
                            if (data.status == 'ok') {
                                console.log(data.message);
                                $("#numItems").html(data.numItems);
                                $("#simpleCart_quantity").html(data.numItems);
                                $("#cartCost").html("$" + data.totalCost);
                                $("#totalCostReceipt").html(data.totalCost);
                                $("#totalFinal").html(data.finalCost);
                            }
                        }, "json");
            });
        });
        $('#buybtn').click(function () {
            $.ajax({url: "BuyServlet?", type: 'GET', contentType: 'text/html', data: new Date().toString(), dataType: 'text', success: function (data) {

                    if (data == "-1")
                    {
                        $('#result').html("quanities of products available now are less than your chosen quantity.\n please decrease your quantity and try again");
                    } else if (data == "-10")
                    {
                        $('#result').html("Your credit is less than total price.\n please recharge your credit first");
                    } else if (data == "-100")
                    {
                        $('#result').html("Cart is Empty.\n please choose items to buy first");
                    } else
                    {
                        $('#result').html("Buying operation finished successfully.\nyour current credit = $" + data);
                        $.ajax({url: "PrintServlet?print=" + $("#someSwitchOptionPrimary").val(), type: 'GET', contentType: 'text/html', data: new Date().toString(), dataType: 'json', success: function (data) {}});
                        $('#cart').html("");
                        $('#numItems').html("0");
                        $('#totalCostReceipt').html("0.0");
                        $('#totalFinal').html("100.0");
                    }
                }});
        });
    });</script>
<style>
    .material-switch > input[type="checkbox"] {
        display: none;   
    }

    .material-switch > label {
        cursor: pointer;
        height: 0px;
        position: relative; 
        width: 40px;  
    }

    .material-switch > label::before {
        background: rgb(0, 0, 0);
        box-shadow: inset 0px 0px 10px rgba(0, 0, 0, 0.5);
        border-radius: 8px;
        content: '';
        height: 16px;
        margin-top: -8px;
        position:absolute;
        opacity: 0.3;
        transition: all 0.4s ease-in-out;
        width: 40px;
    }
    .material-switch > label::after {
        background: rgb(255, 255, 255);
        border-radius: 16px;
        box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
        content: '';
        height: 24px;
        left: -4px;
        margin-top: -8px;
        position: absolute;
        top: -4px;
        transition: all 0.3s ease-in-out;
        width: 24px;
    }
    .material-switch > input[type="checkbox"]:checked + label::before {
        background: inherit;
        opacity: 0.5;
    }
    .material-switch > input[type="checkbox"]:checked + label::after {
        background: inherit;
        left: 20px;
    }   
</style>
<div class="cart">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li class="active">Cart</li>
        </ol>
        <div class="cart-top">
            <a href="index.html"> home</a>
        </div>	

        <div class="col-md-9 cart-items">
            <c:set var="numItems" value="${myShoppingCart.getItems().size()}" />
            <h2>My Shopping Bag (<span id="numItems" >${numItems}</span>)</h2>
            <div id="cart">
                <c:set var="counter" value="0" />
                <c:forEach items="${myShoppingCart.getItems()}" var="currentItem" >

                    <div class="cart-header" id="${currentItem.getKey()}" >
                        <div class="close1" item_id="${currentItem.getKey()}"> </div>
                        <div class="cart-sec">
                            <div class="cart-item cyc">
                                <img src="${homeUrl}/Resources/images/products/${currentItem.getValue().getProduct().getImagePath()}"/>
                            </div>
                            <div class="cart-item-info">
                                <h3>${currentItem.getValue().getProduct().getType()}<span>Model No: ${currentItem.getValue().getProduct().getId()}</span>    </h3> 

                                <h4><span>Price. $ </span>${currentItem.getValue().getProduct().getPrice()}</h4>
                                <p class="qty">Quantity ::</p>
                                <label>${currentItem.getValue().getQuantity()}</label>
                                <!--<input min="1" max="${currentItem.getValue().getProduct().getQuantity()}" type="number" id="quantity" name="quantity" value="${currentItem.getValue().getQuantity()}" class="form-control input-small">-->
                                <input  class="btn-info" type="button" id="availableQuantity" value="stil available !"  onclick="check(${currentItem.getValue().getProduct().getId()},${currentItem.getValue().getQuantity()})"  />
                                <img id="qImg${currentItem.getValue().getProduct().getId()}" width="25" height="25"/><span class="warning" id="checkSpan"   tabindex="1"></span>
                            </div>
                            <div class="clearfix"></div>
                            <div class="delivery">
                                <p>Service Charges:: Rs.50.00</p>
                                <span>Delivered in 2-3 bussiness days</span>
                                <div class="clearfix"></div>
                            </div>						
                        </div>
                    </div>
                    <%--<c:set var="counter" value="${counter+1}" />--%>
                </c:forEach>
            </div>
        </div>

        <div class="col-md-3 cart-total">
            <h4 style="font-size: 24px;font-weight: bold;text-align: center;margin-bottom: 30px;">Receipt</h4>
            <div class="price-details">
                <h3>Price Details</h3>
                <span>Total</span>
                <span class="total" id="totalCostReceipt">${myShoppingCart.getTotalCost()}</span>
                <span>Discount</span>
                <span class="total">---</span>
                <span>Delivery Charges</span>
                <span class="total">100.00</span>
                <div class="clearfix"></div>				 
            </div>	
            <h4 class="last-price">TOTAL</h4>
            <span class="total final" id="totalFinal">${myShoppingCart.getTotalCost() + 100.00}</span>
            <div class="clearfix"></div>
            <br><br>
            Print Receipt
            <div class="material-switch pull-right">
                <input id="someSwitchOptionPrimary" name="someSwitchOption001" type="checkbox" />
                <label for="someSwitchOptionPrimary" class="label-warning"></label>
            </div>
            <a class="order" id="buybtn">Place Order</a>
            <div class="total-item">
                <div id="result" style="color: blue "></div>
            </div>
        </div>
    </div>
</div>
<script>



    function check(pId, qId) {

        $.ajax({url: 'QuantityAvailability?time=' + new Date().getTime(), //servlet url
            type: 'GET', //servlet request type
            data: {"productId": pId, "productQuantity": qId},
            dataType: "text",
            success: function (data) {
                var result = $.trim(data);
                if (data == "available") {
                    document.getElementById("qImg" + pId).src = "../Resources/images/right.png";
                } else {
                    document.getElementById("qImg" + pId).src = "../Resources/images/wrong.png";
                }

//                        $("#checkSpan").text(data);

            }
        });
    }


</script>

<jsp:directive.include file="/footer.jsp"/>
