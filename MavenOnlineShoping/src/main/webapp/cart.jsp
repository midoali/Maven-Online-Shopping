<%-- 
    Document   : cart
    Created on : Mar 10, 2017, 9:32:04 AM
    Author     : Yousef
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="header.jsp"/>
<script>
    $(document).ready(function(c) {
        $('.close1').on('click', function(c){
            var item_id = $(this).attr("item_id");
            $("#"+item_id).fadeOut('slow', function (c) {
                $(this).remove();
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
                    <h2>My Shopping Bag (2)</h2>
			
                    <div class="cart-header" id="1" >
				 <div class="close1" item_id="1"> </div>
				 <div class="cart-sec">
						<div class="cart-item cyc">
							 <img src="Resources/images/pic-2.jpg"/>
						</div>
					   <div class="cart-item-info">
							 <h3>Mast & Harbour<span>Model No: 3578</span></h3>
							 <h4><span>Rs. $ </span>150.00</h4>
							 <p class="qty">Qty ::</p>
							 <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
					   </div>
					   <div class="clearfix"></div>
						<div class="delivery">
							 <p>Service Charges:: Rs.50.00</p>
							 <span>Delivered in 2-3 bussiness days</span>
							 <div class="clearfix"></div>
				        </div>						
				  </div>
			 </div>
			
			 <div class="cart-header" id="2" >
				 <div class="close1" item_id="2"> </div>
				  <div class="cart-sec">
						<div class="cart-item">
							 <img src="Resources/images/pic-1.jpg"/>
						</div>
					   <div class="cart-item-info">
							 <h3>Woolen Shrug<span>Model No: 8768</span></h3>
							 <h4><span>Rs. $ </span>200.00</h4>
							 <p class="qty">Qty ::</p>
							 <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
					   </div>
					   <div class="clearfix"></div>
						<div class="delivery">
							 <p>Service Charges:: Rs.50.00</p>
							 <span>Delivered in 2-3 bussiness days</span>
							 <div class="clearfix"></div>
				        </div>						
				  </div>
			  </div>		
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
			 <a class="order" href="#">Place Order</a>
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
