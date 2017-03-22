<%-- 
    Document   : receiptView
    Created on : Mar 18, 2017, 10:11:23 PM
    Author     : fatma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="homeUrl" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="${homeUrl}/Resources/js/bootstrap-confirmation.min.js"></script>
        <title>Receipt View</title>
        <script>
            $.ajax({
                url: 'ViewReceiptServlet',
                type: 'POST',
                contentType: 'application/json',

                dataType: 'json',
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        $("#rtb").append("<tr><td>" + data[i].totalCost + "</td>\n\
                                        <td>" + data[i].date + " </td>\n\
                                       </tr>");
                    }
                }

            });
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

                     <li><a href="${homeUrl}/admin/viewCustomer">Customers</a></li>
                </ul>

            </div>
        </nav>



        <div class="container">
            <div class="row">

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
                                    <th>Total Cost</th>
                                    <th>Date</th>
                                </tr>
                            </thead>
                            <tbody id="rtb">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>






    </body>
</html>
