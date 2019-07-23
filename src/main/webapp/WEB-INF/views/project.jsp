<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="pl-PL">

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
                            <h4 class="header-title">Zadania na dziś</h4>
                            <div class="single-table">
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <tbody>
                                        <tr>
                                            <td><i class="fa fa-circle-o red"></i></td>
                                            <td class="col-1 red">Posprzątać</td>
                                            <td class="text-right">Dom</td>
                                            <td>
                                                <i class="ti-more-alt" data-toggle="dropdown"></i>
                                                <div class="dropdown-menu">
                                                    <div><span class="dropdown-item disabled">Priorytet</span></div>
                                                    <div class="dropdown-item">
                                                        <a href="project/priority" class="col-pat-1"><i class="fa fa-flag-o gray" ></i></a>
                                                        <a href="project/priority" class="col-pat-1"><i class="fa fa-flag-o green " ></i></a>
                                                        <a href="project/priority" class="col-pat-1"><i class="fa fa-flag-o yellow"></i></a>
                                                        <a href="project/priority" class="col-pat-1"><i class="fa fa-flag red"></i></a>
                                                    </div><hr/>
                                                    <div><a class="dropdown-item" href="#">Usuń</a></div>
                                                    <div><a class="dropdown-item" href="#">Przypomnienie</a></div>
                                                    <div><a class="dropdown-item" href="#">Poproś o pomoc</a></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><i class="fa fa-circle-o green"></i></td>
                                            <td class="col-1 green">kupić chleb</td>
                                            <td class="text-right">Dom</td>
                                            <td>
                                                <i class="ti-more-alt" data-toggle="dropdown"></i>
                                                <div class="dropdown-menu">
                                                    <a class="dropdown-item" href="#">Usuń</a>
                                                    <a class="dropdown-item" href="#">Przypomnienie</a>
                                                    <a class="dropdown-item" href="#">Poproś o pomoc</a>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><i class="fa fa-circle-o gray"></i></td>
                                            <td class="col-1 gray">praca domowa</td>
                                            <td class="text-right">Szkoła</td>
                                            <td>
                                                <i class="ti-more-alt" data-toggle="dropdown"></i>
                                                <div class="dropdown-menu">
                                                    <a class="dropdown-item" href="#">Usuń</a>
                                                    <a class="dropdown-item" href="#">Przypomnienie</a>
                                                    <a class="dropdown-item" href="#">Poproś o pomoc</a>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <div>
                                        <a href="/addTask" class="btn btn-rounded btn-success mb-3">Dodaj zadanie</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- accordion style 4 end -->
                <!-- Projects -->
            </div>
        </div>
    </div>
    <!-- main content area end -->
    <!-- footer area start-->
    <%@ include file="common/footer.jsp" %>
    <!-- footer area end-->
</div>
<!-- page container area end -->
<%@ include file="common/includeJs.jsp" %>
</body>

</html>
