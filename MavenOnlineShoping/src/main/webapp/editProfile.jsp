
<%-- 
    Document   : editProfile
    Created on : Mar 11, 2017, 11:35:24 AM
    Author     : fatma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:directive.include file="/header.jsp"/>

<!DOCTYPE html>
<html>
      
        <div class="registration-form">
            <div class="container">
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a></li>
                    <li class="active">Edit Profile</li>
                </ol>

                <!-- *****  *********************    -->
                <!-- -->
                <h2>Edit your Account</h2>
                <div class="col-md-6 reg-form">
                    <div class="reg">
                        <!--                    <p>Welcome, please enter the folling to continue.</p>-->

                        <%--<c:out value="${sessionScope.myCustomer}"></c:out>--%>

                        <!--  Action:  ::     servlet to save into db-->
                        <form action="UpdatedDataServlet" method="post">

                            <ul>
                                <li class="text-info">Name*</li>
                                <li> <input type="text" value="<c:out value="${sessionScope.myCustomerInfo.name}"/>" name="updatedName" required/></li> 
                            </ul>
                            <ul>
                                <li class="text-info">Email:*</li>
                                <li> <input type="text" value="<c:out value="${sessionScope.myCustomerInfo.email}"/>" name="updatedMail" required/></li> 
                            </ul>

                            <ul>
                                <li class="text-info">Mobile Number:* </li>
                                <li> <input type="number" name="updatedPhone" value="${sessionScope.myCustomerInfo.phone}" required/></li>
                            </ul>					

                            <ul>
                                <li class="text-info">Credit Limit:* </li>
                                <li><input type="number" name="updatedCredit" value="${sessionScope.myCustomerInfo.credit}"/></li>
                            </ul>

                            <ul>
                                <li class="text-info">Address: </li>
                                <li> <input type="text" name="updatedAdd" value="${sessionScope.myCustomerInfo.address}"/></li>
                            </ul>

                            <ul>
                                <li class="text-info">Birthday: </li>
                                <li><input type="date" name="updatedBirthday" value="${sessionScope.myCustomerInfo.birthday}"/></li>
                            </ul>

                            <ul>
                                <li class="text-info">Job: </li>
                                <li><input type="text" name="updatedJob" value="${sessionScope.myCustomerInfo.job}" /></li>
                            </ul>

                            <input type="submit" value="Save Changes">

                            <p class="click">By clicking this button, you agree to my modern style <a href="#">Pollicy Terms and Conditions</a> to Use</p> 
                        </form>
                    </div>
                </div>
                <div class="clearfix"></div>		 
            </div>
        </div>
        <!--fotter-->
        <jsp:directive.include file="/footer.jsp"/>
    </body>
</html>
