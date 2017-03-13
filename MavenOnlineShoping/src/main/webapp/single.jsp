
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:directive.include file="/header.jsp"/>
        <!--header//-->
        <!--Single Page starts Here-->
        <div class="product-main">
            <div class="container">
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a></li>
                    <li class="active">Single</li>
                </ol>
                <div class="ctnt-bar cntnt">
                    <div class="content-bar">
                        <div class="single-page">					 
                            <!--Include the Etalage files-->
                            <link rel="stylesheet" href="Resources/css/etalage.css">
                            <script src="Resources/js/jquery.etalage.min.js"></script>
                            <!-- Include the Etalage files -->
                            <script>
jQuery(document).ready(function ($) {

$('#etalage').etalage({
thumb_image_width: 300,
thumb_image_height: 400,
source_image_width: 700,
source_image_height: 800,
show_hint: true,
click_callback: function (image_anchor, instance_id) {
alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
}
});
// This is for the dropdown list example:
$('.dropdownlist').change(function () {
etalage_show($(this).find('option:selected').attr('class'));
});


    var numQuant = $("#quantity").val();
    
});
                            </script>
                            <!--//details-product-slider-->
                            <div class="details-left-slider">
                                <ul id="etalage">
                                    <li>
                                        <img class="etalage_thumb_image" src="Resources/images/products/${product.imagePath}" />
                                        <img class="etalage_source_image" src="Resources/images/products/${product.imagePath}"  />
                                    </li>
                                </ul>

                            </div>
                            <div class="details-left-info">
                                <h3><c:out value="${product.type}"/> <c:out value="${product.id}"/></h3>

                                <p>$<c:out value="${product.price}"/></p>
                                
                                
                                <form method="post" action="users/addToCart">
                                       <p class="qty">Qty ::</p><input max="${product.quantity}" min="1"  type="number"  id="quantity" name="quantity" value="1"  class="form-control input-small">
                                       <input type="hidden" name="productId" value="${product.id}"/>
                                    <div class="btn_form">
                                        <input type="submit" value="add to cart" />
                                    </div>
                                    </form>

                                    <div class="flower-type">
                                        <p>Mobel  <c:out value="${product.type}"/></p>
                                        <p>Brand  ::<c:out value="${product.brand}"/></p>
                                    </div>
                                    <h5>Description  ::</h5>
                                    <p class="desc"><c:out value="${product.description}"/></p>
                                </div>
                                <div class="clearfix"></div>				 	
                            </div>
                        </div>
                    </div>		 
                   	
                </div>
            </div>
            <jsp:directive.include file="/footer.jsp"/>