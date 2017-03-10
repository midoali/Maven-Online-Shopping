<%-- 
    Document   : index
    Created on : Mar 8, 2017, 9:11:30 PM
    Author     : Nour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sports Shopping Cart</title>
        <link href="Resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="Resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,200,600,800,700,500,300,100,900' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Arimo:400,700,700italic' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="Resources/css/component.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="New Fashions Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" 
              />
        <script src="Resources/js/jquery.min.js"></script>
        <script src="Resources/js/simpleCart.min.js"></script>
        <!-- start menu -->
        <link href="Resources/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="Resources/js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });
        </script>
        <!-- start menu -->
    </head>
    <body>
        <!--header-->
        <div class="header">
            <div class="container">
                <div class="main-header">
                    <div class="carting">
                        <ul><li><a href="login.html"> LOGIN</a></li></ul>
                    </div>
                    <div class="logo">
                        <h3><a href="index.html">SPORTS SHOP</a></h3>
                    </div>			  
                    <div class="box_1">				 
                        <a href="cart.html"><h3>Cart: <span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)<img src="Resources/images/cart.png" alt=""/></h3></a>
                        <p><a href="javascript:;" class="simpleCart_empty">clear cart</a></p>

                    </div>

                    <div class="clearfix"></div>
                </div>

                <!-- start header menu -->
                <ul class="megamenu skyblue">
                    <li class="active grid"><a class="color1" href="index.html">Home</a></li>
                    <li class="grid"><a href="#">Women</a>
                        <div class="megapanel">
                            <div class="row">
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>shop</h4>
                                        <ul>
                                            <li><a href="products.html">new arrivals</a></li>
                                            <li><a href="products.html">men</a></li>
                                            <li><a href="products.html">women</a></li>
                                            <li><a href="products.html">accessories</a></li>
                                            <li><a href="products.html">kids</a></li>
                                            <li><a href="products.html">brands</a></li>
                                        </ul>	
                                    </div>							
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>help</h4>
                                        <ul>
                                            <li><a href="products.html">trends</a></li>
                                            <li><a href="products.html">sale</a></li>
                                            <li><a href="products.html">style videos</a></li>
                                            <li><a href="products.html">accessories</a></li>
                                            <li><a href="products.html">kids</a></li>
                                            <li><a href="products.html">style videos</a></li>
                                        </ul>	
                                    </div>							
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>Products</h4>
                                        <ul>
                                            <li><a href="products.html">trends</a></li>
                                            <li><a href="products.html">sale</a></li>
                                            <li><a href="products.html">style videos</a></li>
                                            <li><a href="products.html">accessories</a></li>
                                            <li><a href="products.html">kids</a></li>
                                            <li><a href="products.html">style videos</a></li>
                                        </ul>	
                                    </div>												
                                </div>						
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>my company</h4>
                                        <ul>
                                            <li><a href="products.html">tremds</a></li>
                                            <li><a href="products.html">sale</a></li>
                                            <li><a href="products.html">style videos</a></li>
                                            <li><a href="products.html">accessories</a></li>
                                            <li><a href="products.html">kids</a></li>
                                            <li><a href="products.html">style videos</a></li>
                                        </ul>	
                                    </div>
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>popular</h4>
                                        <ul>
                                            <li><a href="products.html">new arrivals</a></li>
                                            <li><a href="products.html">men</a></li>
                                            <li><a href="products.html">women</a></li>
                                            <li><a href="products.html">accessories</a></li>
                                            <li><a href="products.html">kids</a></li>
                                            <li><a href="products.html">style videos</a></li>
                                        </ul>	
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col2"></div>
                                <div class="col1"></div>
                                <div class="col1"></div>
                                <div class="col1"></div>
                                <div class="col1"></div>
                            </div>
                        </div>
                    </li>
                    <li><a href="#">MEN</a><div class="megapanel">
                            <div class="row">
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>shop</h4>
                                        <ul>
                                            <li><a href="men.html">new arrivals</a></li>
                                            <li><a href="men.html">men</a></li>
                                            <li><a href="men.html">women</a></li>
                                            <li><a href="men.html">accessories</a></li>
                                            <li><a href="men.html">kids</a></li>
                                            <li><a href="men.html">brands</a></li>
                                        </ul>	
                                    </div>							
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>help</h4>
                                        <ul>
                                            <li><a href="men.html">trends</a></li>
                                            <li><a href="men.html">sale</a></li>
                                            <li><a href="men.html">style videos</a></li>
                                            <li><a href="men.html">accessories</a></li>
                                            <li><a href="men.html">kids</a></li>
                                            <li><a href="men.html">style videos</a></li>
                                        </ul>	
                                    </div>							
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>Products</h4>
                                        <ul>
                                            <li><a href="men.html">trends</a></li>
                                            <li><a href="men.html">sale</a></li>
                                            <li><a href="men.html">style videos</a></li>
                                            <li><a href="men.html">accessories</a></li>
                                            <li><a href="men.html">kids</a></li>
                                            <li><a href="men.html">style videos</a></li>
                                        </ul>	
                                    </div>												
                                </div>						
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>my company</h4>
                                        <ul>
                                            <li><a href="men.html">trends</a></li>
                                            <li><a href="men.html">sale</a></li>
                                            <li><a href="men.html">style videos</a></li>
                                            <li><a href="men.html">accessories</a></li>
                                            <li><a href="men.html">kids</a></li>
                                            <li><a href="men.html">style videos</a></li>
                                        </ul>	
                                    </div>
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>popular</h4>
                                        <ul>
                                            <li><a href="men.html">new arrivals</a></li>
                                            <li><a href="men.html">men</a></li>
                                            <li><a href="men.html">women</a></li>
                                            <li><a href="men.html">accessories</a></li>
                                            <li><a href="men.html">kids</a></li>
                                            <li><a href="men.html">style videos</a></li>
                                        </ul>	
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col2"></div>
                                <div class="col1"></div>
                                <div class="col1"></div>
                                <div class="col1"></div>
                                <div class="col1"></div>
                            </div>
                        </div>
                    </li>
                    <li class="grid"><a href="about.html">ABOUT US</a></li>
                    <li class="grid"><a href="blog.html">BLOG</a></li>				
                    <li><a href="#">SHOP ONLINE</a>
                        <div class="megapanel">
                            <div class="row">
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>shop</h4>
                                        <ul>
                                            <li><a href="shop.html">new arrivals</a></li>
                                            <li><a href="shop.html">men</a></li>
                                            <li><a href="shop.html">women</a></li>
                                            <li><a href="shop.html">accessories</a></li>
                                            <li><a href="shop.html">kids</a></li>
                                            <li><a href="shop.html">brands</a></li>
                                        </ul>	
                                    </div>							
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>help</h4>
                                        <ul>
                                            <li><a href="shop.html">trends</a></li>
                                            <li><a href="shop.html">sale</a></li>
                                            <li><a href="shop.html">style videos</a></li>
                                            <li><a href="shop.html">accessories</a></li>
                                            <li><a href="shop.html">kids</a></li>
                                            <li><a href="shop.html">style videos</a></li>
                                        </ul>	
                                    </div>							
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>Products</h4>
                                        <ul>
                                            <li><a href="shop.html">trends</a></li>
                                            <li><a href="shop.html">sale</a></li>
                                            <li><a href="shop.html">style videos</a></li>
                                            <li><a href="shop.html">accessories</a></li>
                                            <li><a href="shop.html">kids</a></li>
                                            <li><a href="shop.html">style videos</a></li>
                                        </ul>	
                                    </div>												
                                </div>						
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>my company</h4>
                                        <ul>
                                            <li><a href="shop.html">trends</a></li>
                                            <li><a href="shop.html">sale</a></li>
                                            <li><a href="shop.html">style videos</a></li>
                                            <li><a href="shop.html">accessories</a></li>
                                            <li><a href="shop.html">kids</a></li>
                                            <li><a href="shop.html">style videos</a></li>
                                        </ul>	
                                    </div>
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>popular</h4>
                                        <ul>
                                            <li><a href="shop.html">new arrivals</a></li>
                                            <li><a href="shop.html">men</a></li>
                                            <li><a href="shop.html">women</a></li>
                                            <li><a href="shop.html">accessories</a></li>
                                            <li><a href="shop.html">kids</a></li>
                                            <li><a href="shop.html">style videos</a></li>
                                        </ul>	
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col2"></div>
                                <div class="col1"></div>
                                <div class="col1"></div>
                                <div class="col1"></div>
                                <div class="col1"></div>
                            </div>
                        </div>
                    </li>			

                </ul> 			 
                <div class="clearfix"></div>			   	
            </div>
            <div class="caption">
                <h1>SPORTS AND INSPIRATION</h1>	 
                <p>Champions aren't made in the gyms. Champions are made from something they have deep inside them -- a desire, a dream, a vision.</p>
            </div>
        </div>

        <!---->
        <div class="features" id="features">
            <div class="container">
                <div class="tabs-box">
                    <ul class="tabs-menu">
                        <li><a href="#tab1">Clothes</a></li>
                        <li><a href="#tab2">Shoes</a></li>
                        <li><a href="#tab3">Equipments</a></li>
                    </ul>
                    <div class="clearfix"> </div>
                    <div class="tab-grids">
                        <div id="tab1" class="tab-grid1">
                            <c:if test="${empty requestScope.products}">
                                <center> <h1>No Products to View</h1></center>
                                </c:if>
                                <c:if test="${!empty requestScope.products}">
                                    <c:forEach items="${requestScope.products}" var="product">
                                    <div class="product-grid">					  
                                        <a href="single.html" onclick="<c:set var="productId" value="${product.id}"
                                               scope="request" />"><div class="more-product-info"><span>NEW</span></div>						
                                            <div class="product-img b-link-stripe b-animate-go  thickbox">						   
                                                <img src="Resources/images/products/${product.imagePath}" class="img-responsive" alt=""/>
                                                <div class="b-wrapper">
                                                    <h4 class="b-animate b-from-left  b-delay03">							
                                                        <button class="btns">ORDER NOW</button>
                                                    </h4>
                                                </div>
                                            </div></a>						
                                        <div class="product-info simpleCart_shelfItem">
                                            <div class="product-info-cust">
                                                <h4><c:out value="${product.type}"/> <c:out value="${product.id}"/></h4>
                                                <h6><c:out value="${product.description}"/></h6>
                                                <h6>Brand: <c:out value="${product.brand}"/></h6>
                                                <h6>Available color: <c:out value="${product.color}"/></h6>
                                                <span class="item_price">$<c:out value="${product.price}"/></span>
                                                <input type="number" class="item_quantity" min="1" max="${product.quantity}" />
                                            </div>													
                                            <div class="clearfix"> </div>
                                        </div>
                                    </div>	
                                </c:forEach>
                            </c:if>
                            <div class="clearfix"></div>
                        </div>				

                        <div id="tab2" class="tab-grid2">
                            <div class="clearfix"></div>
                        </div>

                        <div id="tab3" class="tab-grid3">
                            <div class="clearfix"></div>					
                        </div>
                    </div>				
                </div>
                <!-- tabs-box -->
                <!-- Comman-js-files -->
                <script>
            $(document).ready(function () {
                $("#tab2").hide();
                $("#tab3").hide();
                $(".tabs-menu a").click(function (event) {
                    event.preventDefault();
                    var tab = $(this).attr("href");
                    $(".tab-grid1,.tab-grid2,.tab-grid3").not(tab).css("display", "none");
                    $(tab).fadeIn("slow");
                });
                $("ul.tabs-menu li a").click(function () {
                    $(this).parent().addClass("active a");
                    $(this).parent().siblings().removeClass("active a");
                });
            });
                </script>
                <!-- Comman-js-files -->
            </div>
        </div>
        <!--fotter-->
        <div class="fotter">
            <div class="container">
                <div class="col-md-6 contact">
                    <form>
                        <input type="text" class="text" value="Name..." onfocus="this.value = '';" onblur="if (this.value == '') {
                                    this.value = 'Name...';
                                }">
                        <input type="text" class="text" value="Email..." onfocus="this.value = '';" onblur="if (this.value == '') {
                                    this.value = 'Email...';
                                }">
                        <textarea onfocus="if (this.value == 'Message...')
                                    this.value = '';" onblur="if (this.value == '')
                                                this.value = 'Message...';" >Message...</textarea>	
                        <div class="clearfix"></div>
                        <input type="submit" value="SUBMIT">
                    </form>

                </div>
                <div class="col-md-6 ftr-left">
                    <div class="ftr-list">
                        <ul>
                            <li><a href="#">Home</a></li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="blog.html">Blog</a></li>
                            <li><a href="contact.html">Contact</a></li>
                        </ul>
                    </div>
                    <div class="clearfix"></div>
                    <h4>FOLLOW US</h4>
                    <div class="social-icons">
                        <a href="#"><span class="in"> </span></a>
                        <a href="#"><span class="you"> </span></a>
                        <a href="#"><span class="twt"> </span></a>
                        <a href="#"><span class="fb"> </span></a>
                    </div>
                </div>	 
                <div class="clearfix"></div>
            </div>
        </div>
        <!--fotter//-->
        <div class="fotter-logo">
            <div class="container">
                <div class="ftr-logo"><h3><a href="index.html">SPORTS SHOP</a></h3></div>
                <div class="ftr-info">
                    <p>&copy; 2015 All Rights Reserved Design by <a href="http://w3layouts.com/">W3layouts</a> </p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!--fotter//-->

    </body>
</html>
