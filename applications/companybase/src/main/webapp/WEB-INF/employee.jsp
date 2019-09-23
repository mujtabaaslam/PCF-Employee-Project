<%--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
  <meta charset="utf-8">
  <title>Employees</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Le styles -->
  <link href="assets/css/bootstrap.css" rel="stylesheet">
  <link href="assets/css/employee.css" rel="stylesheet">
  <style>
    body {
      padding-top: 60px;
      /* 60px to make the container go all the way to the bottom of the topbar */
    }
  </style>
  <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a class="btn btn-navbar" data-toggle="collapse"
         data-target=".nav-collapse"> <span class="icon-bar"></span> <span
          class="icon-bar"></span> <span class="icon-bar"></span>
      </a> <a class="brand" href="/">Companybase</a>

      <form class="navbar-form pull-right">
        <select name="field">
          <option value="firstName">First Name</option>
          <option value="lastName">Last Name</option>
          <option value="email">Email</option>
          <option value="title">Title</option>
          <option value="department">Department</option>
        </select> <input type="text" name="key" size="20">
        <button type="submit" class="btn">Search</button>
      </form>

      <!--/.nav-collapse -->
    </div>
  </div>
</div>

<div class="container">

  <h1>Employees</h1>

  <form class="employee-input-form form-inline" action="employee"
        method="post">
    <p>Add Employee</p>
    <input type="text" name="firstName" placeholder="First Name" size="29"/> <input
      type="text" name="lastName" placeholder="Last Name" size="17"/> <input
      type="text" name="email" placeholder="Email" size="14"/> <input
      type="text" name="salary" placeholder="Salary" size="7"/> <input
      type="text" name="title" placeholder="Title" size="4"/> <input
      type="text" name="department" placeholder="Department" size="4"
      style="width: 110px;"/> <input type="submit" name="action"
                                     class="btn btn-primary" value="Add"/>
  </form>

  <table class="table table-striped table-bordered">
    <thead>
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Email</th>
      <th>Salary</th>
      <th>Title</th>
      <th>Department</th>
      <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee">
      <tr>
        <td><c:out value="${employee.firstName}"/></td>
        <td><c:out value="${employee.lastName}"/></td>
        <td><c:out value="${employee.email}"/></td>
        <td><c:out value="${employee.salary}"/></td>
        <td><c:out value="${employee.title}"/></td>
        <td><c:out value="${employee.department}"/></td>
        <td><a href="?action=Remove&id=${employee.id}"><i
            class="icon-trash"></i></a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <c:if test="${count > 0}">
    <c:if test="${page > 1}">
      <a href="<c:url value="employee"><c:param name="page" value="${page - 1}"/><c:param name="field" value="${field}"/><c:param name="key" value="${key}"/></c:url>">&lt; Prev</a>&nbsp;
    </c:if>
    Showing records ${start} to ${end} of ${count}
    <c:if test="${page < pageCount}">
      &nbsp;<a href="<c:url value="employee"><c:param name="page" value="${page + 1}"/><c:param name="field" value="${field}"/><c:param name="key"
                                                                                                                                        value="${key}"/></c:url>">Next &gt;</a>
    </c:if>
  </c:if>
</div>
<!-- /container -->
</body>
</html>
