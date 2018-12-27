<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<sec:authentication var="user" property="principal" />


<ul class="list-unstyled components">
	<li id="home" ><a href="/cap">Home</a></li>
	<li><a href="/cap/announcement">Announcements</a></li>
	<sec:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_SUPERVISOR')">
	<li id="startCycle" ><a href="/cap/candidate">Start Cycle</a></li>
	</sec:authorize>
	
	<sec:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
		<li><a href="/cap/reports">Reports</a></li>
	</sec:authorize>
	
	<sec:authorize access="hasAnyRole('ROLE_MANAGER')">
		<li><a href="/cap/batchload">Upload Reports</a></li>
		<li><a href="/cap/importedCapList">Imported Reports</a></li>
	</sec:authorize>	
        <li><a href="http://www.doe.mass.edu/edprep/cap/onlineplatform.html">FAQ</a></li>
	<li><a href="/cap/logout">Log Out</a></li>
</ul>
