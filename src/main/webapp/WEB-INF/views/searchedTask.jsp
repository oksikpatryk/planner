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
                        <c:if test="${searchedTasks.size() > 0 }">
                            <div class="card-body">
                                <h4 class="header-title text-dark">Znalezione zadania</h4>
                                <div class="single-table">
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <tbody>
                                            <c:forEach var="searchedTask" items="${searchedTasks}">
                                                <tr>
                                                    <td><a href="/deleteTask/${searchedTask.id}"><i
                                                            class="fa fa-circle-o priority-${searchedTask.priority}"></i></a>
                                                    </td>
                                                    <td class="col-1 priority-${searchedTask.priority}">${searchedTask.name}</td>
                                                    <td class="text-right text-nowrap">${searchedTask.project.name}</td>
                                                    <td>
                                                        <i class="ti-more-alt" data-toggle="dropdown"></i>
                                                        <div class="dropdown-menu">
                                                            <div><span class="dropdown-item disabled">Priorytet</span>
                                                            </div>
                                                            <div class="dropdown-item">
                                                                <a href="project/priority" class="col-pat-1">
                                                                    <i
                                                                            <c:if test="${searchedTask.priority == 4}">class="fa fa-flag priority-4"</c:if>
                                                                            <c:if test="${searchedTask.priority != 4}">class="fa fa-flag-o priority-4"</c:if>></i>
                                                                </a>
                                                                <a href="project/priority" class="col-pat-1">
                                                                    <i
                                                                            <c:if test="${searchedTask.priority == 3}">class="fa fa-flag priority-3"</c:if>
                                                                            <c:if test="${searchedTask.priority != 3}">class="fa fa-flag-o priority-3"</c:if>></i>
                                                                </a>
                                                                <a href="project/priority" class="col-pat-1">
                                                                    <i
                                                                            <c:if test="${searchedTask.priority == 2}">class="fa fa-flag priority-2"</c:if>
                                                                            <c:if test="${searchedTask.priority != 2}">class="fa fa-flag-o priority-2"</c:if>></i>
                                                                </a>
                                                                <a href="project/priority" class="col-pat-1">
                                                                    <i
                                                                            <c:if test="${searchedTask.priority == 1}">class="fa fa-flag priority-1"</c:if>
                                                                            <c:if test="${searchedTask.priority != 1}">class="fa fa-flag-o priority-1"</c:if>></i>
                                                                </a>
                                                            </div>
                                                            <hr/>
                                                            <div><a class="dropdown-item" href="#">Usuń</a></div>
                                                            <div><a class="dropdown-item" href="#">Przypomnienie</a>
                                                            </div>
                                                            <div><a class="dropdown-item" href="#">Poproś o pomoc</a>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${searchedTasks.size() <= 0 }">
                            <div class="card-body">
                                <h4 class="header-title text-danger">Brak zadań o takiej nazwie</h4>
                            </div>
                        </c:if>
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
