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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
  <meta charset="utf-8">
  <title>Setup</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Le styles -->
  <link href="../assets/css/bootstrap.css" rel="stylesheet">
  <link href="../assets/css/employee.css" rel="stylesheet">
  <link href="../assets/css/client.css" rel="stylesheet">
  <style>
    body {
      padding-top: 60px;
      /* 60px to make the container go all the way to the bottom of the topbar */
    }
  </style>
  <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a class="btn btn-navbar" data-toggle="collapse"
         data-target=".nav-collapse"> <span class="icon-bar"></span> <span
          class="icon-bar"></span> <span class="icon-bar"></span>
      </a> <a class="brand" href="/">Company Base</a>
      <!--/.nav-collapse -->
    </div>
  </div>
</div>

<div class="container">

  <h1>Company Database</h1>

  <h2>Seeded database with the following employees</h2>
  <table width="500">
    <tr>
      <td><b>First Name</b></td>
      <td><b>Last Name</b></td>
      <td><b>Email</b></td>
    </tr>

    <c:forEach items="${requestScope.employees}" var="employee">
      <tr>
        <td>${ employee.firstName }</td>
        <td>${ employee.lastName }</td>
        <td>${ employee.email}</td>
      </tr>
    </c:forEach>

  </table>


  <h2>Seeded database with the following clients</h2>
  <table width="1000">
    <tr>
      <td><b>Name</b></td>
      <td><b>Email</b></td>
      <td><b>Years</b></td>
    </tr>

    <c:forEach items="${requestScope.clients}" var="client">
      <tr>
        <td>${ client.name }</td>
        <td>${ client.email }</td>
        <td>${ client.years }</td>
      </tr>
    </c:forEach>

  </table>

  <h2>Employees</h2>
  <a href="employee">Go to employee app</a>

  <h2>Clients</h2>
    <a href="client">Go to client app</a>

</div>
<!-- /container -->
</body>
</html>
