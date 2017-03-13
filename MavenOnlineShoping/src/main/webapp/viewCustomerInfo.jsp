<%-- 
    Document   : viewCustomerInfo
    Created on : Mar 12, 2017, 10:56:52 PM
    Author     : fatma
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:directive.include file="/header.jsp"/>--%>

<html>
    <head>
        
        <!-- start menu -->

        <script>
            var custReq = null;
            // open connection

            function createConnection() {
                if (window.XMLHttpRequest)
                    custReq = new window.XMLHttpRequest();
                else if (window.ActiveXObject)
                    custReq = new ActiveXObject(Microsoft.XMLHTTP);
//                trackState(custReq);
                custReq.onreadystatechange = handleCustReq;
//                openReq(custReq);
                custReq.open("GET", "Adminservlet?timeStamp=" + new Date().getDate(), true);
//                custReq.open("GET", "myFile.txt?timeStamp=" + new Date().getDate(), true);

                custReq.send(null);

            }

            function handleCustReq() {
                //alert(req.readystate);
                if (custReq.readyState === 4)
                    document.getElementById("results").innerHTML = custReq.responseText;
            }

        </script>
    </head>

    <body onload="setInterval(createConnection, 3000)">
        <table Border="1">
            <tr>
                <th>Customer Name</th>
                <th>Customer Email</th>
                <th>Customer Phone</th>
                <th>Customer Birthday</th>
                <th>Customer Address</th>
                <th>Customer Job</th>
            </tr>


            <tr>

            <div id="results"> </div>

        </tr>
    </table>

</body>

</html>

