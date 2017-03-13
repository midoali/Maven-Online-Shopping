<%-- 
    Document   : adminView
    Created on : Mar 12, 2017, 10:35:39 PM
    Author     : fatma
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
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
            function clearCart() {
                $.post("${homeUrl}/users/clearCart",
                        {},
                        function (data) {
                            console.log(data);
                            if (data.status == 'ok') {
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
    <form action="Adminservlet" method="">
        <input type="button" value="View Customers"/>
    </form>
</body>
<%--<jsp:directive.include file="/footer.jsp"/>--%>

</html>

