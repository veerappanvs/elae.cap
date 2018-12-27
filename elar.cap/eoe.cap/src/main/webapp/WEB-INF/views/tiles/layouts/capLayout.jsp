<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="doeCommonData"
	class="edu.mass.doe.doecommon.startup.DoeCommonData"
	scope="application" />
<% String vision_css_url = doeCommonData.getMainCSSFileURL().trim(); %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
<tiles:importAttribute name="page" toName="pageName" />
<script type="text/javascript" src="/cap/script/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/cap/script/popper.min.js"></script>
<script type="text/javascript" src="/cap/script/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/cap/css/datatables.min.css" />

<link rel="stylesheet" type="text/css"
	href="/cap/css/bootstrap-datepicker.min.css" />
<link rel="stylesheet" type="text/css"
	href="/cap/css/bootstrap-timepicker.min.css" />
<script type="text/javascript" src="/cap/script/datatables.min.js"></script>
<script type="text/javascript"
	src="/cap/script/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
	src="/cap/script/bootstrap-timepicker.min.js"></script>
<script type="text/javascript" src="/cap/script/cap.js"></script>
<script type="text/javascript" src="/cap/script/util.js"></script>
<script type="text/javascript" src="/cap/script/autosize.min.js"></script>

<link rel="stylesheet" href="/cap/css/vision.css">

<link rel="stylesheet" href="/cap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/cap/css/fontawesome.css" />
<link rel="stylesheet" type="text/css" href="/cap/css/bootstrap-datepicker.min.css" />
<link rel="stylesheet" type="text/css" href="/cap/css/bootstrap-timepicker.min.css" />
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedheader/3.1.5/css/fixedHeader.bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/cap/css/cap.css" />

<script type="text/javascript">
var pageName='${pageName}';
</script>
</head>
<body>
	<div>
		<%=doeCommonData.getHeaderFileOne()%>
	</div>
	<sec:authentication var="user" property="principal" />

	<div class="wrapper" style="width:${not empty wrapper_width?wrapper_width:'100%'}6000px">
		<!-- Sidebar Holder -->
		<nav id="sidebar"   class="no-print">
			<div class="sidebar-header">
				<img src="/cap/images/capLogo200-WhtBgrnd.png" alt="CAP Online Tool" />
			</div>

			<tiles:insertAttribute name="menu" />

		</nav>

		<!-- Page Content Holder -->
		<div id="content">
			<nav class="navbar navbar-default">
				<div class="container-fluid">				
					<div class="navbar-header ">
						<h4>Welcome ${user.name}</h4>
					</div>

					<div class="collapse show" id="bs-example-navbar-collapse-1">
						<ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
							<sec:authorize
								access="hasAnyRole('ROLE_MANAGER', 'ROLE_SUPERVISOR', 'ROLE_PRACTITIONER', 'ROLE_ADMIN')">
								<li class="nav-item"><h4>
										<a class="nav-link p-2" href="#">${user.orgName}</a>
									</h4></li>
							</sec:authorize>
							<c:if test="${displayMessage}">	<li class="nav-item"><a href="/cap/message?cycleId=${cycleId}" aria-label="Please click here to open messages"><span><i class="fas fa-envelope"></i></span></a></li></c:if>
						</ul>
					</div>
				</div>
			</nav>

			<div>
				<div
					style="min-height: calc(100% - 250px); background: white; padding: 10px;">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
		</div>
	</div>
	<div>
		<%=doeCommonData.getFooter()%>
	</div>
</body>
</html>
