
<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<jsp:directive.include file="/header.jsp"/>

<div class="registration-form">
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li class="active">Registration</li>
            </ol>
            
            <script>
                function checkReg(){
                    var regName= $("#regNameId").val();
                       $.ajax({
                        url:'CustomerNameServlet',
                        type:'POST',
                        contentType:'html/plain',
                        data: regName,
                        dataType:'html/plain',
                        success: function(data){
                            $("#regSpan").html(data);
                        }
                       });
                }
              
            </script>
            <!-- *****  *********************    -->
            <!-- Registration Form-->
            <h2>Registration</h2>
            <div class="col-md-6 reg-form">
                <div class="reg">
                    <p>Welcome, please enter the following to continue.</p>
                    <p>If you have previously registered with us, <a href="#">click here</a></p>
                    <form action="registration" method="post">
                        <ul>
                            <li class="text-info">Name:* </li>
                            <li><input type="text" name="regName" id="regNameId"required/><span id="regSpan"></span></li>
                        </ul>
                        <!--                        <ul>
                                                    <li class="text-info">Last Name: </li>
                                                    <li><input type="text" value=""></li>
                                                </ul>				 -->
                          <ul>
                            <li class="text-info">Password:* </li>
                            <li><input type="password" name="regPass" required/></li>
                        </ul>
                        
                        <ul>
                            <li class="text-info">Re-enter Password:* </li>
                            <li><input type="password" required/></li>
                        </ul>
                        
                        <ul>
                            <li class="text-info">Email:* </li>
                            <li><input type="email" name="regMail" required/></li>
                        </ul>
                        
                        <ul>
                            <li class="text-info">Mobile Number:* </li>
                            <li><input type="tel" name="regPhone" placeholder="(020)000-000-0000" required/></li>
                        </ul>					
                        
<!--                        <ul>
                            <li class="text-info">Credit Card:* </li>
                            <li><input type="number" name="regCredit"></li>
                        </ul>-->

                        <ul>
                            <li class="text-info">Address:* </li>
                            <li> <input type="text" name="regAdd" required/></li>
                        </ul>

                        <ul>
                            <li class="text-info">Birthday: </li>
                            <li><input type="date" name="regBirthday"/></li>
                        </ul>
                        
                        <ul>
                            <li class="text-info">Job: </li>
                            <li><input type="text" name="regJob"/></li>
                        </ul>

                        <input type="submit" value="Register Now">
                        
                        <p class="click">By clicking this button, you agree to my modern style <a href="#">Pollicy Terms and Conditions</a> to Use</p> 
                    </form>
                </div>
            </div>
            <div class="col-md-6 reg-right">
                <h3>Completely Free Accouent</h3>
                <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
                <!--             <h3 class="lorem">Lorem ipsum dolor sit amet elit.</h3>
                                <p>Tincidunt metus, sed euismod elit enim ut mi. Nulla porttitor et dolor sed condimentum. Praesent porttitor lorem dui, in pulvinar enim rhoncus vitae. Curabitur tincidunt, turpis ac lobortis hendrerit, ex elit vestibulum est, at faucibus erat ligula non neque.</p>-->

            </div>
            <div class="clearfix"></div>		 
        </div>
    </div>
<jsp:directive.include file="/footer.jsp"/>
