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
                            <div class="row align-items-center">
                                <!-- nav and search button -->
                                <div class="col-md-6 col-sm-8 clearfix">
                                    <div class="pull-left">
                                        <h4 class="header-title">${project.name}</h4>
                                    </div>
                                </div>
                                <!-- profile info & task notification -->
                                <div class="col-md-6 col-sm-4 clearfix">
                                    <ul class="notification-area pull-right">
                                        <li><a href="/deleteProject/${project.id}" class="text-danger"><i class="ti-trash"></i></a></li>
                                        <li><a href="/renameProject/${project.id}"><i class="fa fa-edit"></i></a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="row single-table">
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <tbody>
                                        <c:forEach var="t" items="${project.tasks}">
                                            <tr>
                                                <td><i class="fa fa-circle-o red"></i></td>
                                                <td class="col-1 red">${t.name}</td>
                                                <td>
                                                    <i class="ti-more-alt" data-toggle="dropdown"></i>
                                                    <div class="dropdown-menu">
                                                        <div><span class="dropdown-item disabled">Priorytet</span></div>
                                                        <div class="dropdown-item">
                                                            <a href="project/priority" class="col-pat-1"><i
                                                                    class="fa fa-flag-o gray"></i></a>
                                                            <a href="project/priority" class="col-pat-1"><i
                                                                    class="fa fa-flag-o green "></i></a>
                                                            <a href="project/priority" class="col-pat-1"><i
                                                                    class="fa fa-flag-o yellow"></i></a>
                                                            <a href="project/priority" class="col-pat-1"><i
                                                                    class="fa fa-flag red"></i></a>
                                                        </div>
                                                        <hr/>
                                                        <div><a class="dropdown-item" href="#">Usuń</a></div>
                                                        <div><a class="dropdown-item" href="#">Przypomnienie</a></div>
                                                        <div><a class="dropdown-item" href="#">Poproś o pomoc</a></div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
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
