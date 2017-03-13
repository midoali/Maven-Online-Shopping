
<%-- 
    Document   : editProfile
    Created on : Mar 11, 2017, 11:35:24 AM
    Author     : fatma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
        <script>
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
                        <ul><li><a href="login.html"> LOGOUT</a></li></ul>
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

        <!--header//-->
        <div class="registration-form">
            <div class="container">
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a></li>
                    <li class="active">Edit Profile</li>
                </ol>

                <!-- *****  *********************    -->
                <!-- -->
                <h2>Edit your Account</h2>
                <div class="col-md-6 reg-form">
                    <div class="reg">
                        <!--                    <p>Welcome, please enter the folling to continue.</p>-->

                        <%--<c:out value="${sessionScope.myCustomer}"></c:out>--%>

                        <!--  Action:  ::     servlet to save into db-->
                        <form action="UpdatedDataServlet" method="post">

                            <ul>
                                <li class="text-info">Name*</li>
                                <li> <input type="text" value="<c:out value="${sessionScope.myCustomerInfo.name}"/>" name="updatedName" required/></li> 
                            </ul>
                            <ul>
                                <li class="text-info">Email:*</li>
                                <li> <input type="text" value="<c:out value="${sessionScope.myCustomerInfo.email}"/>" name="updatedMail" required/></li> 
                            </ul>

                            <ul>
                                <li class="text-info">Mobile Number:* </li>
                                <li> <input type="number" name="updatedPhone" value="${sessionScope.myCustomerInfo.phone}" required/></li>
                            </ul>					

                            <ul>
                                <li class="text-info">Credit Limit:* </li>
                                <li><input type="number" name="updatedCredit" value="${sessionScope.myCustomerInfo.credit}"/></li>
                            </ul>

                            <ul>
                                <li class="text-info">Address: </li>
                                <li> <input type="text" name="updatedAdd" value="${sessionScope.myCustomerInfo.address}"/></li>
                            </ul>

                            <ul>
                                <li class="text-info">Birthday: </li>
                                <li><input type="date" name="updatedBirthday" value="${sessionScope.myCustomerInfo.birthday}"/></li>
                            </ul>

                            <ul>
                                <li class="text-info">Job: </li>
                                <li><input type="text" name="updatedJob" value="${sessionScope.myCustomerInfo.job}" /></li>
                            </ul>

                            <input type="submit" value="Save Changes">

                            <p class="click">By clicking this button, you agree to my modern style <a href="#">Pollicy Terms and Conditions</a> to Use</p> 
                        </form>
                    </div>
                </div>
                <div class="clearfix"></div>		 
            </div>
        </div>
        <!--fotter-->
        <div class="fotter-logo">
            <div class="container">
                <div class="ftr-logo"><h3><a href="index.html">NEW FASHIONS</a></h3></div>
                <div class="ftr-info">
                    <p>&copy; 2017 All Rights Reseverd Design by <a href="http://w3layouts.com/">JETS-TEAM</a> </p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!--fotter//-->	
    </body>
</html>
