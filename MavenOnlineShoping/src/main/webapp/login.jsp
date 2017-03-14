
<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<jsp:directive.include file="/header.jsp"/>

<div class="login">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <!--<li class="active">Login</li>-->
        </ol>
        <h2>Login</h2>
        <script>
//            var name = $("#loginNameId").val();
//            $.ajax({url: 'CustomerNameServlet',
            //                    type: 'GET',
//                    contentType: 'html/plain',
//                    data: name,
//                    dataType: 'html/plain',
//                    success: function (data) {
//                        $("#nameSpan").html(data.name);
//                    }
//                    });


            function checkName() {
                if (window.XMLHttpRequest)
                    nameReq = new window.XMLHttpRequest();
                else if (window.ActiveXObject)
                    nameReq = new ActiveXObject(Microsoft.XMLHTTP);

                nameReq.onreadystatechange = handleReq2;

                nameReq.open("GET", "CustomerNameServlet?uName=" + document.getElementById("loginNameId").value + "&time=" + new Date().getDate(), true);

                nameReq.send(null);
            }
            function handleReq2() {
//                alert(nameReq.readystate);

                if (nameReq.readyState === 4)
                    document.getElementById("nameSpan").innerHTML = nameReq.responseText;
            }


        </script>
        <div class="col-md-6 log">			 
            <p>Welcome, please enter the following to continue.</p>
            <!--            <p>If you have previously Login with us, <span>click here</span></p>-->
            <form action="login" method="post">
                <h5>User Name:</h5>	
                <input type="text" name="loginName" id="loginNameId" onblur="checkName()"/><span id="nameSpan"></span>
                <h5>Password:</h5>
                <input type="password" name="loginPass"/>			
                <input type="submit" value="Login">
                <a href="#">Forgot Password ?</a>
            </form>	

        </div>
        <div class="col-md-6 login-right">
            <h3>NEW REGISTRATION</h3>
            <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
            <a class="acount-btn" href="registration">Create an Account</a>
        </div>
        <div class="clearfix"></div>		 

    </div>
</div>
<!--fotter-->
<jsp:directive.include file="/footer.jsp"/>

