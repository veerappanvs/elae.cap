<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title></title>
<tiles:putAttribute name="title" value="Teacher Candidate Search" />
</head>
<body>
	<form:form id="form2" method="POST" commandName="candidateEnrollment">
		<div id="error-section" style="margin-bottom: 25px" class="error">
			<form:errors path="*" />
		</div>

			<div style="text-align: center; padding: 10px">
				<h5>Teacher Candidate Information</h5>
			</div>
			
			<div style="text-align: center; padding: 10px">
				<b>Note:</b> Review the Teacher Candidate and CAP cycle information below. To start the Cycle press 'Start Cycle'. 
			</div>

			<div class="line" style="margin: 10px 0; color: black"></div>

			<div>

				<div class="form-group row">
					<div class="col-sm-3">
						<label class="col-form-label float-right font-weight-bold">Teacher
							Candidate:</label>
					</div>
					<div class="col-sm-3">
						<label class="col-form-label">${candidateEnrollment.candidateName}</label>
					</div>
					<div class="col-sm-3">
						<label class="col-form-label float-right font-weight-bold">Teacher
							Candidate MEPID:</label>
					</div>
					<div class="col-sm-3">
						<label class="col-form-label">${candidateEnrollment.mepid}</label>
					</div>
				</div>


				<div class="form-group row">
					<div class="col-sm-3">
						<label class="col-form-label float-right font-weight-bold">Program:</label>
					</div>
					<div class="col-sm-3">
						<label class="col-form-label">${candidateEnrollment.programName}</label>
					</div>
					<div class="col-sm-6"></div>
				</div>
			</div>

			<div class="line" style="margin: 10px 0; color: black"></div>




			<div class="form-group row">
				<div class="col-sm-3">
					<label class="col-form-label float-right font-weight-bold">Program
						Supervisor:</label>
				</div>
				<div class="col-sm-3">
					<label class="col-form-label">${candidateEnrollment.supervisorName}</label>
				</div>
				<div class="col-sm-3">
					<label class="col-form-label float-right font-weight-bold">Supervising
						Practitioner:</label>
				</div>
				<div class="col-sm-3">
					<label class="col-form-label">${candidateEnrollment.practitioner.firstName} ${candidateEnrollment.practitioner.lastName}</label>
				</div>
			</div>


			<div class="form-group row">
				<div class="col-sm-3">
					<label class="col-form-label float-right font-weight-bold">Practicum
						District:</label>
				</div>
				<div class="col-sm-3">
					<label class="col-form-label">${candidateEnrollment.practitioner.districtName}</label>
				</div>
				<div class="col-sm-3">
					<label class="col-form-label float-right font-weight-bold">Practicum School:</label>
				</div>
				<div class="col-sm-3">
					<label class="col-form-label">${candidateEnrollment.practitioner.schoolName}</label>
				</div>
			</div>

			<div class="form-group row">					
					<div class="col-sm-3">
						<label class="col-form-label float-right font-weight-bold">Cycle Start Date:</label>
					</div>
					<div class="col-sm-3">
						<label class="col-form-label"><fmt:formatDate pattern="MM/dd/yyyy" value="${candidateEnrollment.cycleStartDate}" /></label>
					</div>
					<div class="col-sm-3">
					</div>
					<div class="col-sm-3">
					</div>
				</div>
				<div>
					<div>
						<div style="text-align: right; margin: 50px">
							<input type="hidden" value="4" name="_page" /> <input
								type="submit" value="Back" name="_command"
								class="btn btn-primary" /> <input type="submit" value="Cancel"
								name="_command" class="btn btn-primary" /> <input type="submit"
								value="Start Cycle" name="_command" class="btn btn-primary" />
						</div>
					</div>

				</div>

			
	</form:form>
</body>
</html>
