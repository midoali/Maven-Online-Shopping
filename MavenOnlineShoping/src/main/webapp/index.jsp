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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
            function clearModal()
            {
                $("#code").val("");
                $("#modalfooter").html("");
                $("#codespan").html("");
            }
            function checkcode()
            {
                $.ajax({url: "credit?code=" + $("#code").val(), type: "get", contentType: 'text/html', data: new Date().toString(), dataType: 'text', success: function (data) {
                        $("#codespan").html(data);
                    }});
            }
            function chargeCredit()
            {
                $.ajax({url: "credit?code=" + $("#code").val(), type: "post", contentType: 'text/html', data: new Date().toString(), dataType: 'text', success: function (data) {
                        if (data === "-1")
                        {
                            $("#modalfooter").html("Inncorrect Code.<br> please enter a valid one.");
                        } else if (data === "0")
                        {
                            $("#modalfooter").html("This card has already been charged.<br> please enter a new one.");
                        } else
                        {
                            $("#modalfooter").html("you have successfully recharged your credit.<br> your current credit = " + data + "$");
                        }
                    }});
            }

        </script>
        <!-- start menu -->
        <style>
            .modal-header, h4, .close {
                background-color: #3054E3;
                color:white !important;
                text-align: center;
                font-size: 30px;
            }
            .modal-footer {
                background-color: lightgray;
                color: darkred !important;
                text-align: center;
            }
            .disableddiv {
                pointer-events: none;
                opacity: 0.5;
            }
            .cd-popup-trigger{
                display: block;
                width: 170px;
                height: 50px;
                line-height: 50px;
                margin: 3em auto;
                text-align: center;
                font-size: 12px;
                /*font-size: 0.875rem;*/
                font-weight: bold;
                text-transform: uppercase;
                border-radius: 50em;
                background: #3054E3;
                box-shadow: 0 3px 0 rgba(0, 0, 0, 0.07);
                color: white;
                text-decoration: none;
                font-family: sans-serif;
                position: fixed;
                z-index: 19;
                bottom: 86%;
                left: 42%;
            }
            .cd-popup-trigger:hover{
                text-decoration: none;
            }
            <c:if test="${!sessionScope.loggedIn == 'true'}" >
                .megamenu>li>a {
                    padding: 9px 6.5%!important;
                }
            </c:if>
        </style>
    </head>
    <body>
        <!--header-->
        <div class="header">
            <div class="container">
                <div class="main-header">
                    <div class="carting">
                        <ul><li>
                                <c:if test="${loggedIn == 'true'}">
                                    <a data-toggle="modal" data-target="#myModal" data-backdrop="static"><span class="glyphicon glyphicon-credit-card"></span></a>
                                    <div class="modal fade" id="myModal" role="dialog">
                                        <div class="modal-dialog">

                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header" style="padding:35px 50px;">
                                                    <button type="button" class="close" data-dismiss="modal" onclick="clearModal()">&times;</button>
                                                    <h4 class="modal-title"><span class="glyphicon glyphicon-usd"></span>Recharge your Credit</h4>
                                                </div>
                                                <div class="modal-body" id="modalbody">
                                                    <form role="form">
                                                        <div class="form-group">
                                                            <label for="code" class="control-label"><span class="glyphicon glyphicon-credit-card"></span> Enter credit code</label>
                                                            <input type="number" class="form-control" id="code" placeholder="ex: 4200000" style="width:  300px!important;" onkeyup="checkcode()" pattern="/d{9}" required autofocus>
                                                            <span id="codespan" style="color: #31b0d5"></span>
                                                        </div>
                                                        <button type="button" class="btn btn-primary btn-block" onclick="chargeCredit()">charge</button>
                                                    </form>
                                                </div>
                                                <div class="modal-footer" id="modalfooter"></div>
                                            </div>

                                        </div>
                                    </div>
                                <li style="color:wheat;">Welcome <strong><c:out value="${sessionScope.myCustomer.name}"/></strong>&nbsp;-&nbsp;</li>
                                <a style="color:white;font-weight:bold;" href="${homeUrl}/logout"> LOGOUT <span class="glyphicon glyphicon-log-out"></span></a>
                                </c:if>
                                <c:if test="${loggedIn != 'true'}">
                                <a href="${homeUrl}/login"><span class="glyphicon glyphicon-log-in"></span> LOGIN </a>
                            </c:if>
                            </li></ul>
                    </div>
                    <div class="logo">
                        <h3><a href="${homeUrl}/home">SPORTS SHOP</a></h3>
                    </div>			  
                    <div class="box_1">				 
                        <a href="${homeUrl}/users/cart"><h3>Cart: <span id="cartCost">
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
                              class="simpleCart_empty">clear cart </a></p>

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
                        <li><a href="#clothes" category_id="2" class="catSelect">Shoes</a></li>
                        <li><a href="#shoes" category_id="1" class="catSelect">Clothes</a></li>
                        <li><a href="#accessories" category_id="3" class="catSelect">Accessories</a></li>
                        <li class="active"><a href="#all" category_id="0" class="catSelect" >All</a></li>
                        <input type="hidden" name="selectedCategory" id="selectedCategory" value="0" />
                        <script>
                            var category_id = 0;
                            var last_id = ${maxIdProduct};
                            var emptyContent = false;
                            function renderHome(data) {
                                if (data.length > 0)
                                    last_id = data[0].id;
                                var output = "";
                                for (var i = 0; i < data.length; i++) {
                                    output += '<div class="product-grid">';
                                    output += '<a href="SingleProduct?productId=' + data[i].id + '" ><div class="more-product-info"><span>NEW</span></div>';
                                    output += '<div class="product-img b-link-stripe b-animate-go  thickbox">';
                                    output += '<img src="Resources/images/products/' + data[i].imagePath + '" class="img-responsive" alt="" style="width:400px;height: 350px;"/>';
                                    output += '<div class="b-wrapper">';
                                    output += '<h4 class="b-animate b-from-left  b-delay03">';
                                    output += '<button class="btns">ORDER NOW</button>';
                                    output += '</h4>';
                                    output += '</div>';
                                    output += '</div></a>';
                                    output += '<div class="product-info simpleCart_shelfItem">';
                                    output += '<div class="product-info-cust">';
                                    output += '<h4>' + data[i].type + ' ' + data[i].id + '</h4>';
                                    output += '<span class="item_price">$' + data[i].price + '</span>';
                                    output += '<input type="number" class="item_quantity" min="0" max="' + data[i].quantity + '" value="0" /></div><div class="clearfix"> </div> </div> </div>';
                                }
//                                $("#tab").html("");
                                $("#tab").prepend(output);
                            }
                            function updateHome() {
                                $.post("${homeUrl}/getHomeProducts?date=" + new Date().toDateString(),
                                        {cat_id: category_id, latest_id: last_id},
                                        function (data) {
                                            if (data.length > 0 && !emptyContent)
                                                $(".cd-popup-trigger").show();
                                            emptyContent = false;
                                            renderHome(data);
                                        },
                                        "json");
                            }
                            $(document).ready(function () {
                                $('.cd-popup-trigger').on('click', function (event) {
                                    $(this).hide();
                                    event.preventDefault();
                                    $('html, body').animate({
                                        scrollTop: $($.attr(this, 'href')).offset().top
                                    }, 500);
                                });
                                $(".catSelect").click(function () {
                                    category_id = $(this).attr("category_id");
                                    last_id = 0;
                                    $("#tab").html("");
                                    emptyContent = true;
                                    $("#selectedCategory").val(category_id);
                                    updateHome();
                                });
                                setInterval(updateHome, 10000);
                            });
                        </script>
                    </ul>
                    <div class="clearfix"> </div>
                    <a href="#features" class="cd-popup-trigger" style="display:none;" id="popUp">New Products</a>
                    <div class="tab-grids">
                        <div id="tab" >
                            <c:if test="${empty requestScope.products}">
                                <center> <h1>No Products to View</h1></center>
                                </c:if>
                                <c:if test="${!empty requestScope.products}">
                                    <c:forEach items="${requestScope.products}" var="product">
                                        <c:if test="${product.quantity == 0}">
                                        <div class="product-grid disableddiv">					  
                                            <a href="SingleProduct?productId=${product.id}" ><div class="finished-product-info"><span>OUT OF STOCK</span></div>						
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
                                    </c:if>
                                    <c:if test="${product.quantity != 0}">
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
                                    </c:if>
                                </c:forEach>
                            </c:if>
                            <div class="clearfix"></div>
                        </div>				


                    </div>				
                </div>
                <!-- tabs-box -->
                <!-- Comman-js-files -->
                <script>
                    $(document).ready(function () {
                        $(".tabs-menu a").click(function (event) {
                            event.preventDefault();
                            var tab = $(this).attr("href");
//                            $(".tab-grid1,.tab-grid2,.tab-grid3").not(tab).css("display", "none");
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
