<!-- sidebar menu area start -->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="sidebar-menu">
    <div class="sidebar-header">
        <div class="logo">
            <a href="index.html"><img src="/resources/images/icon/logo.png" alt="logo" height="42"
                                      width="42"><span> Done </span></a>
        </div>
    </div>
    <div class="main-menu">
        <div class="menu-inner">
            <nav>
                <ul class="metismenu" id="menu">
                    <li>
                        <a href="/addTask" aria-expanded="true"><i class="fa fa-plus"></i><span>Dodaj zadanie</span>
                            <span class="pull-right-container"><span
                                    class="badge badge-light pull-right">3</span></span></a>
                    </li>
                    <li>
                        <a href="/" aria-expanded="true"><i class="fa fa-angle-double-right"></i><span>Dziś</span>
                            <span class="pull-right-container"><span
                                    class="badge badge-light pull-right">3</span></span></a>
                    </li>
                    <li>
                        <a href="/nextSevenDays" aria-expanded="true"><i
                                class="fa fa-calendar"></i><span>Następne 7 dni</span>
                            <span class="pull-right-container"><span
                                    class="badge badge-light pull-right">9</span></span></a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" aria-expanded="true"><i
                                class="fa fa-list-ul"></i><span>Projekty</span></a>
                        <ul class="collapse">

                            <c:forEach var="p" items="${projects}">
                                <li>
                                    <a href="/project/${p.id}"><i class="gray fa fa-circle"></i><span>${p.name}<span class="badge badge-pill pull-right">${fn:length(p.tasks)}</span></span></a></li>
                                </li>
                            </c:forEach>
                            <li><a href="/addProject"><i class="fa fa-plus"></i><span>Dodaj projekt</span></a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
