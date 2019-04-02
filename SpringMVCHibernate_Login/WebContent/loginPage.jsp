<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>        
        <title>Login</title>
    </head>
    <body align="center">
        <div class="container">
            <h3>Login Application</h3>
            <div> </div>
     
            <!-- User input form to validate a user -->
            <%-- <c:url var="validateUrl" value="/user/validate" /> --%>
            <form action="validate" method="POST">
                <div>
                    <label for="emailId">Enter EmailId:</label>
                    <input type="text" id="emailId"  name="emailId">
                </div>
                <div>
                    <label for="password">Enter Password:</label>
                    <input type="password" id="password"  name="password">
                </div>
                <button id="confirm_user" type="submit">Login</button>
            </form>
        </div>
        
            
    </body>
</html>