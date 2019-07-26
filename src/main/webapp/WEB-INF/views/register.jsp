<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Table Layout - srtdash</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="common/includeCss.jsp" %>
</head>


<body>
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> to improve your experience.</p>
<![endif]-->
<!-- preloader area start -->
<div id="preloader">
    <div class="loader"></div>
</div>
<!-- preloader area end -->
<!-- login area start -->
<div class="login-area">
    <div class="container">
        <div class="login-box ptb--100">
            <form:form method="post" modelAttribute="user">
            <div class="login-form-head">
                <h4>Sign up</h4>
                <p>Hello there, Sign up and Join with Us</p>
            </div>
            <div class="login-form-body">
                <div class="form-gp">
                    <label for="exampleInputName1">Username</label>
                    <form:input path="username" type="text" id="exampleInputName1"/>
                    <i class="ti-user"></i>
                </div>
                <div><form:errors path="username" cssClass="alert alert-danger"/></div>
                <div class="form-gp">
                    <label for="exampleInputPassword1">Password</label>
                    <form:input path="password" type="password" id="exampleInputPassword1"/>
                    <i class="ti-lock"></i>
                </div>
                <div><form:errors path="password" cssClass="alert alert-danger"/></div>
                <div class="submit-btn-area">
                    <button id="form_submit" type="submit">Submit <i class="ti-arrow-right"></i></button>
                </div>
                <div class="form-footer text-center mt-5">
                    <p class="text-muted">Don't have an account? <a href="login.html">Sign in</a></p>
                </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</div>
<!-- login area end -->

<%@ include file="common/includeJs.jsp" %>
</body>

</html>
