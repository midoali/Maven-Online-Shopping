<%-- 
    Document   : updateproduct
    Created on : Mar 14, 2017, 1:04:09 PM
    Author     : Nour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Admin</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .btn-file {
                position: relative;
                overflow: hidden;
            }
            .btn-file input[type=file] {
                position: absolute;
                top: 0;
                right: 0;
                min-width: 100%;
                min-height: 100%;
                font-size: 100px;
                text-align: right;
                filter: alpha(opacity=0);
                opacity: 0;
                outline: none;
                background: white;
                cursor: inherit;
                display: block;
            }
            #img-upload{
                width: 100%;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <center><h2>Update Product</h2></center>
            <form class="form-horizontal" method="post" action="updateproduct">
                <div class="form-group">        
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </div>
                <c:set var="product" value="${requestScope.productInfo}"></c:set>
                <input type="hidden" name="id" value="${product.id}">
                <div class="form-group">
                    <label class="control-label col-sm-2">Description :</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="desc" placeholder="Enter product description" rows="3" required><c:out value="${product.description}"></c:out>"</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Category :</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="category" required>
                            <option value="clothes">Clothes</option>
                            <option value="shoes">Shoes</option>
                            <option value="accessories">Accessories</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Type :</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="type" placeholder="Enter product Type" value="${product.type}">
                    </div>
                    <label class="control-label col-sm-2">Brand :</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="brand" placeholder="Enter product brand" value="${product.brand}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Price :</label>
                    <div class="col-sm-4">
                        <input type="number" class="form-control" name="price" placeholder="Enter product price" min="0" value="${product.price}" required>
                    </div>
                    <label class="control-label col-sm-2">Quantity :</label>
                    <div class="col-sm-4">
                        <input type="number" class="form-control" name="quan" placeholder="Enter product quantity" min="0" value="${product.quantity}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Color :</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="color" placeholder="Enter product color" value="${product.color}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label class="control-label col-sm-offset-2 col-sm-2">Change Image:</label>
                            <div class="input-group">
                                <span class="input-group-btn">
                                    <span class="btn btn-default btn-file">
                                        Browse… <input type="file" id="imgInp" name="imgpath">
                                    </span>
                                </span>
                                <input type="text" name="imgname" class="form-control" readonly>
                            </div>
                            <img id='img-upload'/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
