<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="form-group row">
	<div class="col-sm-1"></div>
	<div class="col-sm-2">
		<label class="col-form-label float-right font-weight-bold">Program
			Name:</label>
	</div>
	<div class="col-sm-3">
		<label class="col-form-label">${cycleInfo.programName}</label>
	</div>
	<div class="col-sm-3">
		<label class="col-form-label float-right font-weight-bold"
			style="text-align: right">Supervising Practitioner:</label>
	</div>
	<div class="col-sm-3">
		<label class="col-form-label"> 
		<c:forEach items="${cycleInfo.practitioners}" var="practitioner">
			${practitioner.firstName} ${practitioner.lastName}<br>
		</c:forEach>
		</label>
	</div>
</div>


<div class="form-group row">
	<div class="col-sm-1"></div>
	<div class="col-sm-2">
		<label class="col-form-label float-right font-weight-bold">Teacher
			Candidate:</label>
	</div>
	<div class="col-sm-3">
		<label class="col-form-label">${cycleInfo.candidateFirstName}
			${cycleInfo.candidateLastName}</label>
	</div>
	<div class="col-sm-3">
		<label class="col-form-label float-right font-weight-bold">Cycle
			Start Date:</label>
	</div>
	<div class="col-sm-3">
		<label class="col-form-label"><fmt:formatDate
				pattern="MM/dd/yyyy" value="${cycleInfo.startDate}" /></label>
	</div>
</div>

<c:if test="${cycleInfo.schoolYear ne null}">
	<div class="form-group row">
		<div class="col-sm-1"></div>
		<div class="col-sm-2">
			<label class="col-form-label float-right font-weight-bold">CAP
				Completion Year:</label>
		</div>
		<div class="col-sm-3">
			<label class="col-form-label">${cycleInfo.schoolYear-1} -
				${cycleInfo.schoolYear}</label>
		</div>
		<div class="col-sm-6"></div>
	</div>
</c:if>
