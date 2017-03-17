<%-- 
    Document   : productsView
    Created on : Mar 13, 2017, 5:57:46 AM
    Author     : Yousef
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="homeUrl" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Admin Panel</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="${homeUrl}/Resources/js/bootstrap-confirmation.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#pbod").on("click", ".delBtn", function () {
//               $(".delBtn").click(function(){
                    var trProductId = $(this).attr("id");
                    var myProductId = $(this).attr("product_id");

                    var ans = confirm("are you sure you want to delete this product ?");
                    if (ans) {
                        $.post("${homeUrl}/admin/deleteProduct",
                                {productId: myProductId},
                                function (data) {
                                    if (data.status == 'ok') {
                                        $("#tr_" + myProductId).remove();
                                    }
                                }, "json");
                    }
                });


                $("#searchField").keyup(function () {
                    console.log("ff");
                    var searchField = $("#searchField").val();
                    $("#pbod").html("");
                    $(".loader").show();
                    $.post("${homeUrl}/admin/viewProducts",
                            {keyword: searchField},
                            function (data) {
                                for (var i = 0; i < data.length; i++) {
                                    var strTable = "<tr id='tr_" + data[i].id + "'>";
                                    strTable += "<td><img src='../Resources/images/products/" + data[i].imagePath + "' style='width:100px;height: 100px;'/></td>";
                                    strTable += "<td>...</td>";
                                    strTable += "<td>" + data[i].type + "</td>";
                                    strTable += "<td>" + data[i].brand + "</td>";
                                    strTable += "<td>" + data[i].price + "</td>";
                                    strTable += "<td>" + data[i].quantity + "</td>";
                                    strTable += "<td>" + data[i].description + "</td>";
                                    strTable += "<td>" + data[i].color + "</td>";
                                    strTable += "<td><button type='button' product_id='" + data[i].id + "' id='update_" + data[i].id + "' onclick=\"location.href='updateproduct?id=" + data[i].id + "'\"  class='btn btn-primary'>Update</button>";
                                    strTable += "<button type='button' product_id='" + data[i].id + "' id='delete_" + data[i].id + "' class='btn btn-danger delBtn'>Delete</button></td></tr>";
                                    $("#pbod").append(strTable);
                                }
                                $(".loader").hide();
                            }, "json");
                });

            });

        </script>
        <style>
            .loader {
                border: 16px solid #f3f3f3;
                border-radius: 50%;
                border-top: 16px solid #3498db;
                width: 120px;
                height: 120px;
                -webkit-animation: spin 2s linear infinite;
                animation: spin 2s linear infinite;
                margin: 0 auto;
                display: none;
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
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Admin Panel</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Products</a></li>
                    <li><a href="#">Customers</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <button type="button" id="addBtn" class="btn btn-success" onclick="location.href = '${homeUrl}/admin/addproduct'">Add New Product</button>
                </div>
                <div class="col-sm-4">
                    <form class="form-inline">

                        <div class="form-group">
                            <input id="searchField" type="text" class="form-control" name="searchField" placeholder="Enter you keyword">
                        </div>


                        <button type="button" id="searchBtn" class="btn btn-primary">Search</button>
                    </form>
                </div>
                <div class="col-sm-4"></div>

            </div>
            <br>
            <div class="row">
                <div class="col-sm-12">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Product Image</th>
                                    <th>Category</th>
                                    <th>Type</th>
                                    <th>Brand</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Description</th>
                                    <th>Color</th>
                                    <th>Operations</th>
                                </tr>
                            </thead>
                            <tbody id="pbod">

                                <c:if test="${!empty requestScope.products}">
                                    <c:forEach items="${requestScope.products}" var="product">
                                        <tr id="tr_${product.id}">
                                            <td> <img src="${homeUrl}/Resources/images/products/${product.imagePath}" alt="" style="width:100px;height: 100px;"/></td>
                                            <td> ... </td>
                                            <td>${product.type}</td>
                                            <td>${product.brand}</td>
                                            <td>${product.price}</td>
                                            <td>${product.quantity}</td>
                                            <td>${product.description}</td>
                                            <td>${product.color}</td>
                                            <td><button type="button" product_id="${product.id}" id="update_${product.id}" onclick="location.href = '${homeUrl}/admin/updateproduct?id=${product.id}'" class="btn btn-primary">Update</button>
                                                <button type="button" data-toggle="confirmation"  product_id="${product.id}" id="delete_${product.id}" class="btn btn-danger delBtn">Delete</button></td>

                                        </tr>

                                    </c:forEach>
                                </c:if>

                            </tbody>
                        </table>
                    </div>
                    <div class="loader"></div>
                </div>
            </div>

        </div>
    </body>
</html>

