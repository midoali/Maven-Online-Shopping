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
        <script>
            $(document).ready(function () {
                $(document).on('change', '.btn-file :file', function () {
                    var input = $(this),
                            label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
                    input.trigger('fileselect', [label]);
                    // alert("input=" + input);
                });

                $('.btn-file :file').on('fileselect', function (event, label) {

                    var input = $(this).parents('.input-group').find(':text'),
                            log = label;
                    if (input.length) {
                        input.val(log);
                    } else {
                        if (log)
                            alert(log);
                    }

                });
                function readURL(input) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            $('#img-upload').attr('src', e.target.result);
                        }

                        reader.readAsDataURL(input.files[0]);
                    }
                }

                $("#imgInp").change(function () {
                    readURL(this);
                });
            });
        </script>
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
                        <textarea class="form-control" name="desc" placeholder="Enter product description" rows="3" required><c:out value="${product.description}"></c:out></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Category :</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="category" required>
                            <c:if test="${product.categoryId == 1}">
                                <option value="1" selected="selected">Clothes</option>
                                <option value="2">Shoes</option>
                                <option value="3">Accessories</option>
                            </c:if>
                            <c:if test="${product.categoryId == 2}">
                                <option value="1" >Clothes</option>
                                <option value="2" selected="selected">Shoes</option>
                                <option value="3">Accessories</option>
                            </c:if>
                            <c:if test="${product.categoryId == 3}">
                                <option value="1" >Clothes</option>
                                <option value="2">Shoes</option>
                                <option value="3" selected="selected">Accessories</option>
                            </c:if>
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
                        <input type="text" class="form-control" name="brand" placeholder="Enter product brand" value="${product.brand}" list="productList">
                        <datalist id="productList">
                            <option value="nike">Nike</option>
                            <option value="adidas">Adidas</option>
                            <option value="puma">Puma</option>
                            <option value="nb">NB</option>
                        </datalist>
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
                            <label class="control-label col-sm-offset-2 col-sm-2">Change Image :</label>
                            <div class="input-group">
                                <span class="input-group-btn">
                                    <span class="btn btn-default btn-file">
                                        Browse… <input type="file" id="imgInp" accept="image/*" value="${product.imagePath}">
                                    </span>
                                </span>
                                    <input type="text" class="form-control" name="imgpath" value="${product.imagePath}" readonly>
                            </div>
                            <img id='img-upload' src="../Resources/images/products/${product.imagePath}"/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
