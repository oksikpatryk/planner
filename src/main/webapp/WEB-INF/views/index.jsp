<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form method="post">
                <div class="login-form-head">
                    <h4>Witaj</h4>
                </div>
                <div class="login-form-body">
                    <div class="submit-btn-area">
                        <button class="mt-4" ><a href="/tasks/">Przejdź do tasków</a> <i class="ti-arrow-right"></i></button>
                        <button class="mt-4" ><a href="/login">Zaloguj się</a> <i class="ti-arrow-right"></i></button>
                        <button class="mt-4" ><a href="/create-user">Zarejestruj się</a> <i class="ti-arrow-right"></i></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- login area end -->

<%@ include file="common/includeJs.jsp" %>
</body>

</html>
