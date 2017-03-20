<%-- 
    Document   : header
    Created on : Mar 10, 2017, 9:57:00 AM
    Author     : Yousef
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="homeUrl" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <title>Sports Shopping Cart</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="${homeUrl}/Resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="${homeUrl}/Resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="${homeUrl}/Resources/css/form.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,200,600,800,700,500,300,100,900' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Arimo:400,700,700italic' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="${homeUrl}/Resources/css/component.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="New Fashions Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" 
              />
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css" type="text/css" media="all" /> 
        <!--<script src="${homeUrl}/Resources/js/jquery.min.js"></script>-->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="${homeUrl}/Resources/js/jquery.easydropdown.js"></script>
        <script src="${homeUrl}/Resources/js/simpleCart.min.js"></script>
        <!-- start menu -->
        <link href="${homeUrl}/Resources/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        
        <script type="text/javascript" src="${homeUrl}/Resources/js/megamenu.js"></script>
        <script>
            function clearCart() {
                $.post("${homeUrl}/users/clearCart",
                        {},
                        function (data) {
                            console.log(data);
                            if (data.status == 'ok') {
                                console.log(data.message);
                                $("#simpleCart_quantity").html("0");
                                $("#cartCost").html("0.00");
                            }
                        }, "json");
            }
            $(document).ready(function () {
                $(".megamenu").megamenu();
            });

        </script>
        <!-- start menu -->
    </head>
    <body>
        <!--header-->
        <div class="header2 text-center">
            <div class="container">
                <div class="main-header">
                    <div class="carting">
                        <ul><li>
                                <c:if test="${loggedIn == 'true'}">
                                    <a href="${homeUrl}/users/CustHomeServlet" style="color:white;"><span class="glyphicon glyphicon-credit-card"></span></a>
                                <li style="color:wheat;">Welcome <strong><c:out value="${sessionScope.myCustomer.name}"/></strong>&nbsp;-&nbsp;</li>
                                <a style="color:white;font-weight:bold;" href="${homeUrl}/logout"> LOGOUT <span class="glyphicon glyphicon-log-out"></span></a>
                            </c:if>
                            <c:if test="${loggedIn != 'true'}">
                                <a href="${homeUrl}/login"><span class="glyphicon glyphicon-log-in"></span> LOGIN</a>
                            </c:if>
                            </li></ul>
                    </div>
                    <div class="logo">
                        <h3><a href="${homeUrl}/home">SPORTS SHOP</a></h3>
                    </div>

                    <div class="box_1">	

                        <a href="
                           <c:if test="${loggedIn == 'true'}">
                               ${homeUrl}/users/cart
                           </c:if>
                           "><h3>Cart: <span id="cartCost" >$${myShoppingCart.getTotalCost()}</span> (<span id="simpleCart_quantity" >${myShoppingCart.getItems().size()}</span> items)<img src="${homeUrl}/Resources/images/cart.png" alt=""/></h3></a>
                        <p><a href="javascript:;" onclick="clearCart()" class="simpleCart_empty">clear cart</a></p>

                    </div>

                    <div class="clearfix"></div>
                </div>
                <!-- start header menu -->
                <ul class="megamenu skyblue">
                    <li class="active grid"><a class="color1" href="${homeUrl}/home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                    <li class="grid"><a href="#"><span class="glyphicon glyphicon-th-large"></span> Categories</a>
                        <div class="megapanel">
                            <div class="row">
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>Clothes</h4>
                                        <ul>
                                            <li><a href="">T-shirts</a></li>
                                            <li><a href="">Training suits</a></li>
                                            <li><a href="">Hoodies</a></li>
                                            <li><a href="">Trousers</a></li>
                                            <li><a href="">Shorts</a></li>
                                        </ul>	
                                    </div>							
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>Shoes</h4>
                                        <ul>
                                            <li><a href="">Sneakers</a></li>
                                        </ul>	
                                    </div>							
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>Accessories</h4>
                                        <ul>
                                            <li><a href="">Caps</a></li>
                                            <li><a href="">Watches</a></li>
                                            <li><a href="">Glasses</a></li>
                                            <li><a href="">Balls</a></li>
                                            <li><a href="">Bags</a></li>
                                            <li><a href="">Others</a></li>
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
                    <li><a href="#"><span class="glyphicon glyphicon-tags"></span> Brands</a><div class="megapanel">
                            <div class="row">
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>Nike</h4>
                                        <ul>
                                            <li><a href="men.html">shoes</a></li>
                                            <li><a href="men.html">football shirts</a></li>
                                            <li><a href="men.html">bags</a></li>
                                            <li><a href="men.html">accessories</a></li>
                                        </ul>	
                                    </div>							
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>addidas</h4>
                                        <ul>
                                            <li><a href="men.html">shoes</a></li>
                                            <li><a href="men.html">T-shirts</a></li>
                                            <li><a href="men.html">training suits</a></li>
                                            <li><a href="men.html">accessories</a></li>
                                            <li><a href="men.html">bags</a></li>
                                        </ul>	
                                    </div>							
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>puma</h4>
                                        <ul>
                                            <li><a href="men.html">bags</a></li>
                                            <li><a href="men.html">accessories</a></li>
                                        </ul>	
                                    </div>												
                                </div>						
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>NB</h4>
                                        <ul>
                                            <li><a href="men.html">shoes</a></li>
                                            <li><a href="men.html">accessories</a></li>
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
                    <li class="grid"><a href="${homeUrl}/aboutus"><span class="glyphicon glyphicon-info-sign"></span> ABOUT US</a></li>
                    <li class="grid"><a href="blog.html"><span class="glyphicon glyphicon-film"></span> BLOG</a></li>			
                        <c:if test="${loggedIn == 'true'}"  >
                        <li class="grid"><a href="${homeUrl}/users/CustHomeServlet"><span class="glyphicon glyphicon-cog"></span> Edit Profile</a></li>	
                        </c:if>

                </ul> 
            </div>
            <div class="clearfix"></div> 
        </div>
