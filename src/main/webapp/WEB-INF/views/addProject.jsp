<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html class="no-js" lang="pl-PL">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Table Layout - srtdash</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/png" href="/resources/images/icon/favicon.ico">
    <%@ include file="common/includeCss.jsp" %>
</head>

<body>
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> to improve your experience.</p>
<![endif]-->
<%@ include file="common/preloader.jsp" %>
<!-- page container area start -->
<div class="page-container">
    <!-- sidebar menu area start -->
    <%@ include file="common/sidebar.jsp" %>
    <!-- sidebar menu area end -->
    <!-- main content area start -->
    <div class="main-content">
        <!-- header area start -->
        <%@ include file="common/navbar.jsp" %>
        <!-- header area end -->
        <div class="main-content-inner">
            <div class="row d-flex justify-content-center">
                <!-- Projects -->
                <!-- accordion style 4 start -->
                <div class="col-md-8 mt-3">
                    <div class="card">
                        <div class="card-body">
                            <form:form action="${action}" modelAttribute="project" method="post">
                                <form:hidden path="id"/>
                                <h4 class="header-title">Dodaj projekt</h4>
                                <div class="form-group">
                                    <label for="example-text-input" class="col-form-label">Nazwa</label>
                                    <form:input path="name" class="form-control" type="text" placeholder="Nazwa projektu" id="example-text-input"/>
                                </div>
                                <div><form:errors path="name" cssClass="alert alert-danger"/></div>
                                <%--                                    <div>--%>
                                <%--                                        <input class="color-input-field" type="color" id="head" name="head" value="#e66465">--%>
                                <%--                                        <label for="head">Head</label>--%>
                                <%--                                    </div>--%>
                                <%--                            <div class="form-group">--%>
                                <%--                                <label for="example-email-input" class="col-form-label">Podaj e-mail'e współpracowników</label>--%>
                                <%--                                <input class="form-control" type="email" placeholder="name@example.com"--%>
                                <%--                                       id="example-email-input">--%>
                                <%--                            </div>--%>
                                <%--                            <div class="form-group">--%>
                                <%--                                <label class="col-form-label">Projekt nadrzędny</label>--%>
                                <%--                                <select class="custom-select">--%>
                                <%--                                    <option selected="selected">Brak projektu nadrzędnego</option>--%>
                                <%--                                    <option value="1">One</option>--%>
                                <%--                                    <option value="2">Two</option>--%>
                                <%--                                    <option value="3">Three</option>--%>
                                <%--                                </select>--%>
                                <%--                            </div>--%>
                                <input type="submit" class="btn btn-primary mt-4 pr-4 pl-4"/>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- main content area end -->
    <!-- footer area start-->
    <%@ include file="common/footer.jsp" %>
    <!-- footer area end-->
</div>
<!-- page container area end -->
<!-- offset area start -->
<%@ include file="common/includeJs.jsp" %>
</body>

</html>
