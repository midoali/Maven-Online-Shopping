<%-- 
    Document   : browseProducts
    Created on : Mar 17, 2017, 6:38:02 PM
    Author     : Yousef
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/header.jsp"/>
<style>
    #search{
        width: 130px;
        box-sizing: border-box;
        border: 2px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
        background-color: white;
        background-image: url('${homeUrl}/Resources/images/searchicon.png');
        background-position: 10px 10px; 
        background-repeat: no-repeat;
        padding: 12px 20px 12px 40px;
        -webkit-transition: width 0.4s ease-in-out;
        transition: width 0.4s ease-in-out;
        margin-left:57px;
    }

    #search:focus {
        width: 45%;
    }

    #loader {
        border: 16px solid #f3f3f3;
        border-radius: 50%;
        border-top: 16px solid #3498db;
        width: 120px;
        height: 120px;
        -webkit-animation: spin 2s linear infinite;
        animation: spin 2s linear infinite;
        margin: 0 auto;
        z-index: 99;
        position:fixed;
        margin-left: 24%;
    margin-top: -5%;
        /*margin-left:40%;*/
    }

    @-webkit-keyframes spin {
        0% { -webkit-transform: rotate(0deg); }
        100% { -webkit-transform: rotate(360deg); }
    }

    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }
</style>
<script
    src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
    integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
crossorigin="anonymous"></script>
<div class="product-model">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li class="active">Categories</li>
        </ol>
        <form id="searchFields" name="searchFields">
            <h2>OUR PRODUCTS <input type="text" name="keyword" id="search" placeholder="Search.." ></h2>
            <div class="col-md-9 product-model-sec" >
                <div id="productsCont">
                    <c:forEach items="${products}" var="product" >
                        <a href="SingleProduct?productId=${product.id}">
                            <div class="product-grid love-grid">
                                <div class="more-product"><span> </span></div>						
                                <div class="product-img b-link-stripe b-animate-go  thickbox">
                                    <img src="${homeUrl}/Resources/images/products/${product.imagePath}" class="img-responsive" alt=""/>
                                    <div class="b-wrapper">
                                        <h4 class="b-animate b-from-left  b-delay03">							
                                            <button class="btns">ORDER NOW</button>
                                        </h4>

                                    </div>
                                </div>
                        </a>						
                        <div class="product-info simpleCart_shelfItem">
                            <div class="product-info-cust">
                                <h4><c:out value="${product.type}"/> <c:out value="${product.id}"/></h4>
                                <span class="item_price">$${product.price}</span>
                                <input type="number" class="item_quantity" min="0" max="${product.quantity}"value="0" />
                                <input type="button" class="item_add items" value="ADD">
                            </div>											
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div id="loader"></div>
    </div>

    <div class="rsidebar span_1_of_left">
        <section  class="sky-form">
            <div class="product_right" style="margin-bottom: -18px;">
                <h3 class="m_2">Categories</h3>
                <div class="row row1 scroll-pane">
                    <div class="col col-4">
                        <label class="radio"><input type="radio" class="inputSearch" name="catRadio" value="0" checked /><i></i>All</label>
                                <c:forEach items="${categories}" var="category">
                            <label class="radio"><input type="radio" name="catRadio" class="inputSearch" value="${category.id}"/><i></i>${category.name}</label>
                                </c:forEach>
                    </div>
                </div>
        </section>

        <section  class="sky-form">
            <h4>Brand</h4>
            <div class="row row1 scroll-pane">
                <div class="col col-4">
                    <label class="checkbox"><input type="checkbox" class="inputSearch" name="brandChecks" value="addidas"><i></i>Addidas</label>
                    <label class="checkbox"><input type="checkbox" class="inputSearch" name="brandChecks" value="nb"><i></i>NB</label>
                    <label class="checkbox"><input type="checkbox" class="inputSearch" name="brandChecks" value="puma"><i></i>Puma</label>
                    <label class="checkbox"><input type="checkbox" class="inputSearch" name="brandChecks" value="nike"><i></i>Nike</label>
                    <label class="checkbox"><input type="checkbox" class="inputSearch" name="brandChecks" value="kabba"><i></i>Kabba</label>
                </div>
            </div>
        </section>		
        <section  class="sky-form">
            <h4>Price</h4>
            <div class="row row1 scroll-pane">
                <script type="text/javascript">
                    function renderProducts(data) {
                        var output = "";


                        for (var i = 0; i < data.length; i++) {
                            output += '<a href="SingleProduct?productId=' + data[i].id + '">';
                            output += '<div class="product-grid love-grid">';
                            output += '<div class="more-product"><span> </span></div>';
                            output += '<div class="product-img b-link-stripe b-animate-go  thickbox">';
                            output += '<img src="${homeUrl}/Resources/images/products/' + data[i].imagePath + '" class="img-responsive" alt=""/>';
                            output += '<div class="b-wrapper">';
                            output += '<h4 class="b-animate b-from-left  b-delay03">';
                            output += '<button class="btns">ORDER NOW</button>';
                            output += '</h4>';
                            output += '</div></div></a>';
                            output += '<div class="product-info simpleCart_shelfItem">';
                            output += '<div class="product-info-cust">';
                            output += '<h4>' + data[i].type + ' ' + data[i].id + '</h4>';
                            output += '<span class="item_price">$' + data[i].price + '</span>';
                            output += '<input type="number" class="item_quantity" min="0" max="' + data[i].quantity + '"value="0" />';
                            output += '<input type="button" class="item_add items" value="ADD">';
                            output += '</div>';
                            output += '<div class="clearfix"> </div>';
                            output += '</div></div>';
                        }

                        $("#productsCont").html(output);


                    }
                    function searchCats() {
                        $("#productsCont").html("");
                        $("#loader").show();
                        $.post("${homeUrl}/browseProducts?date="+new Date().toString()
                                , $("#searchFields").serialize()
                                , function (data) {
                                    renderProducts(data);
                                    console.log("done");
                                    $("#loader").hide();
                                });
                    }
                    $(function () {
                        $("#slider-range").slider({
                            range: true,
                            min: 10,
                            max: 1000,
                            values: [10, 1000],
                            slide: function (event, ui) {
                                $("#amount").html("$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ]);
                                $("#amount1").val(ui.values[ 0 ]);
                                $("#amount2").val(ui.values[ 1 ]);
                            }
                        });
                        $("#amount").html("$" + $("#slider-range").slider("values", 0) +
                                " - $" + $("#slider-range").slider("values", 1));
                        $(".ui-slider-handle").mouseup(function () {
                            searchCats();
                        });
                    });

                    $(document).ready(function () {
                        $("#loader").hide();
                        $("input:radio[name='catRadio']").change(function () {
                            $("#catfFields").val($(this).val());
                        });
                        $("#search").keyup(function () {
                            searchCats();
                        });
                        $(".inputSearch").change(function () {
                            searchCats();
                        });
                    });
                </script>
                <div class="col col-4">

                    <p id="amount"></p>
                    <br>               
                    <div id="slider-range" style="width: 90%;margin-left: 7px;" class="inputSearch"></div>

                    <!--<form id="searchFields" name="searchFields">-->
                    <input type="hidden" id="catfFields" name="catFields" value="0"/>
                    <!--<input type="hidden" id="brandFields" name="brandFields" value=""/>-->

                    <input type="hidden" id="amount1" class="inputSearch" name="amount1" value="0" />
                    <input type="hidden" id="amount2" class="inputSearch" name="amount2" value="9999999"/>
                    <!--<input type="submit" name="submit_range" value="Submit">-->
                    <!--</form>-->
                </div>
            </div>
        </section>
        </form>
    </div>			 
    <div class="clearfix"></div>


</div>
</div>	        
<jsp:directive.include file="/footer.jsp"/>