<%-- 
    Document   : index
    Created on : Mar 8, 2017, 9:11:30 PM
    Author     : Nour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="homeUrl" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <title>Sports Shopping Cart</title>
        <link href="${homeUrl}/Resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="${homeUrl}/Resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,200,600,800,700,500,300,100,900' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Arimo:400,700,700italic' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="${homeUrl}/Resources/css/component.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="New Fashions Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" 
              />
        <script src="${homeUrl}/Resources/js/jquery.min.js"></script>
        <script src="${homeUrl}/Resources/js/simpleCart.min.js"></script>
        <!-- start menu -->
        <link href="${homeUrl}/Resources/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="${homeUrl}/Resources/js/megamenu.js"></script>
        <script>
            function clearCart(){
                    $.post("${homeUrl}/users/clearCart",
                        {},
                        function (data) {          
                            console.log(data);
                           if(data.status == 'ok'){
                               console.log(data.message);
                           }
                        });
                }
            $(document).ready(function () {
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
                        <ul><li>
                                <c:if test="${loggedIn == 'true'}">
                                    <li>Welcome <strong><c:out value="${sessionScope.myCustomer.name}"/></strong></li>
                                    <a href="${homeUrl}/logout"> LOGOUT</a>
                                </c:if>
                                 <c:if test="${loggedIn != 'true'}">
                                    <a href="${homeUrl}/login"> LOGIN</a>
                                 </c:if>
                            </li></ul>
                    </div>
                    <div class="logo">
                        <h3><a href="${homeUrl}/home">SPORTS SHOP</a></h3>
                    </div>			  
                    <div class="box_1">				 
                        <a href="${homeUrl}/users/cart"><h3>Cart: <span >
                                    <c:if test="${loggedIn == 'true'}"  >
                                    $${myShoppingCart.getTotalCost()}
                                    </c:if>
                                </span> (<span id="simpleCart_quantity" >
                                    <c:if test="${loggedIn == 'true'}"  >
                                        ${myShoppingCart.getItems().size()}
                                    </c:if>
                                </span> items)<img src="${homeUrl}/Resources/images/cart.png" alt="" /></h3></a>
                                <p><a href="javascript:;"
                                      <c:if test="${loggedIn == 'true'}"  >
                                      onclick="clearCart()"
                                      </c:if>
                                      class="simpleCart_empty">clear cart</a></p>

                    </div>

                    <div class="clearfix"></div>
                </div>

                <!-- start header menu -->
                <ul class="megamenu skyblue">
                    <li class="active grid"><a class="color1" href="${homeUrl}/home">Home</a></li>
                    <li class="grid"><a href="#">Categories</a>
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
                    <li><a href="#">Brands</a><div class="megapanel">
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
                    <li class="grid"><a href="${homeUrl}/aboutus">ABOUT US</a></li>
                    <li class="grid"><a href="${homeUrl}/blog.html">BLOG</a></li>				

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
                                        <a href="SingleProduct?productId=${product.id}" ><div class="more-product-info"><span>NEW</span></div>						
                                            <div class="product-img b-link-stripe b-animate-go  thickbox">						   
                                                <img src="Resources/images/products/${product.imagePath}" class="img-responsive" alt="" style="width:400px;height: 350px;"/>
                                                <div class="b-wrapper">
                                                    <h4 class="b-animate b-from-left  b-delay03">							
                                                        <button class="btns">ORDER NOW</button>
                                                    </h4>
                                                </div>
                                            </div></a>						
                                        <div class="product-info simpleCart_shelfItem">
                                            <div class="product-info-cust">
                                                <h4><c:out value="${product.type}"/> <c:out value="${product.id}"/></h4>
                                                <span class="item_price">$<c:out value="${product.price}"/></span>
                                                <input type="number" class="item_quantity" min="0" max="${product.quantity}" value="0" />
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
