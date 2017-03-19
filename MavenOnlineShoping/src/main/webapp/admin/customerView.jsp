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
            $("#viewBtn").click(function () {
            $.ajax({url: "AdminServlet",
                    type: 'GET',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                    $("#cbod").append("<tr><td>" + data[i].name + "</td>\n\
                                        <td>" + data[i].birthday + " </td>\n\
                                        <td>" + data[i].job + "</td>\n\
                                        <td>" + data[i].email + "</td>\n\
                                        <td>" + data[i].credit + "</td>\n\
                                        <td>" + data[i].phone + "</td>\n\
                                        <td><button onclick=\"window.open('${homeUrl}/admin/ViewReceiptServlet?id="+data[i].id+"')\">View Receipt</button></td></tr>");
                    }
                    }
            });
            });

//                    function viewReceipt() {
//                    var CId = {id: data[i].id};
//                            jsonId = {id: CId};
//                            console.log(jsonId);
//                            $.ajax({
//                            url: "ViewReceiptServlet",
//                                    type: 'GET',
//                                    contentType: 'application/json',
//                                    data: CId,
//                                    dataType: 'json',
//                                    success: function (data) {
//
//                                    }
//                            });
//                    }

            }
            );
        </script>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Admin Panel</a>
                </div>
                <ul class="nav navbar-nav">
                    <li ><a href="${homeUrl}/admin/viewProducts">Products</a></li>

                    <li class="active"><a href="#">Customers</a></li>
                </ul>

            </div>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <button type="button" id="viewBtn" class="btn btn-success">View Customers</button>
                </div>
                <div class="col-sm-4">
                    <form class="form-inline">

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
                                    <th>Customer Name</th>
                                    <th>Birthday</th>
                                    <th>Job</th>
                                    <th>Email</th>
                                    <th>Credit</th>
                                    <th>Phone</th>
                                    <!--                                    <th>Id</th>
                                                                        <th>Password</th>-->
                                </tr>
                            </thead>
                            <tbody id="cbod">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>

