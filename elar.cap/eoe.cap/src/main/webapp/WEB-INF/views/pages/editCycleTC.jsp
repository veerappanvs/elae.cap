<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">

function setScrollPosition(){
	$('#scrollX').val(window.pageXOffset);
	$('#scrollY').val(window.pageYOffset);
}

	function pageLoad() {
		window.scroll(${scrollX!=null?scrollX:0},${scrollY!=null?scrollY:0});
	}
	
	function assignSupervisor(supervisorName, supervisorId, userId) {
		$('#supervisordaPersonId').val(supervisorId);
		$('#supervisorName').text(supervisorName);
		$('#supervisorId').text(userId);
		$('#supervisorPersonId').val(supervisorId);
		
		path = '/cap/cycle/saveSupervisor?cycleId=${cycleId}&supervisorId='+ supervisorId;
		
		$.ajax({
			type : "GET",
			url : path,
			async : false,
			success : function(response) {
			}
		});

	}

	function loadProgramSupervisorModal(method, process, requestParams) {
		var parameters = [];

		if (requestParams.length > 0) {
			var processElements = requestParams.split(',');

			for (idx in processElements) {
				parameter = {
					name : processElements[idx].split('=')[0],
					value : processElements[idx].split('=')[1]
				}
				parameters.push(parameter);
			}
		}

		if (process.length > 0) {

			var processElements = process.split(',');

			for (element in processElements) {
				parameter = {
					name : $('#' + processElements[element]).attr("id"),
					value : $('#' + processElements[element]).val()
				}
				parameters.push(parameter);
			}
		}

		var queryString = jQuery.param(parameters);

		if (queryString != '')
			queryString = '&' + queryString

		path = '/cap/cycle/' + method + '?cycleId=' + ${cycleId	}
		+queryString;

		$.ajax({
			type : "GET",
			url : path,
			async : false,
			success : function(response) {

				result = $.parseHTML(response);

				$('#programSupervisor-section').text("");
				$('#programSupervisor-section').append(result[5]);
				$('#supervisorResult').dataTable();
			}
		});
	}

	function loadPractitionerModal(method, process, requestParams) {

		var parameters = [];

		if (requestParams.length > 0) {
			var processElements = requestParams.split(',');

			for (idx in processElements) {
				parameter = {
					name : processElements[idx].split('=')[0],
					value : processElements[idx].split('=')[1]
				}
				parameters.push(parameter);
			}

		}

		if (process.length > 0) {
			var processElements = process.split(',');
			for (element in processElements) {
				parameter = {
					name : $('#' + processElements[element]).attr("id"),
					value : $('#' + processElements[element]).val()
				}
				parameters.push(parameter);
			}
		}

		var queryString = jQuery.param(parameters);

		if (queryString != '')
			queryString = '&' + queryString

		path = '/cap/cycle/' + method + '?cycleId=' + ${cycleId}+queryString;

		$.ajax({
			type : "GET",
			url : path,
			async : false,
			success : function(response) {

				result = $.parseHTML(response);

				$('#practitioner-section').text("");
				$('#practitioner-section').append(result[5].childNodes);

			},
			complete : function(response) {

				postScript = $(response.responseText)[2].innerText;

				if (postScript.length != 0) {
					eval(postScript);
				}
			}

		});

	}

	function showEndingReasonDiv() {
		document.getElementById('wantToEndDiv').style.display = "block";
	}
</script>
<title></title>
</head>
<body>
	<form:form id="form2" method="POST" commandName="capCycleInfo"
		action="/cap/cycle">

		<div style="text-align: center; padding: 10px">
			<span style="font-size: 1.3rem; font-weight: bold">CAP Form</span></br>
			<span style="font-size: 1rem;"><b>Note: </b> To be completed by the Program Supervisor and Teacher Candidate.</span>
		</div>
		<div>&nbsp;</div>

		<div class="form-group row">
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Program:</div>
			</div>
			<div class="col-sm-8">
				<div class="col-form-label">${capCycleInfo.programName}</div>
			</div>
		</div>


		<div class="form-group row">
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Practicum/Equivalent Course Number:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control " path="courseNumber" aria-label="Please enter Practicum Course Number"  maxlength="255" />
				<form:errors path="courseNumber" cssClass="error" />
			</div>
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Credit Hours:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control" path="creditHours" aria-label="Please enter number of Credit Hours"  maxlength="10" />
				<form:errors path="creditHours" cssClass="error" />
			</div>
		</div>


		<div class="form-group row">
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Practicum/Equivalent Seminar Course Title:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control " path="courseTitle" aria-label="Please enter Practicum Course Title"  maxlength="255" />
				<form:errors path="courseTitle" cssClass="error" />
			</div>
		
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Grade level of Practicum Students:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control" path="gradLevel" aria-label="Please enter Grade Level"   maxlength="255" />
				<form:errors path="gradLevel" cssClass="error" />
			</div>		
		</div>

		<div class="form-group row">
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Total Number of Practicum Hours:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control" path="practicumHours" aria-label="Please enter Practicum Hours"  maxlength="10" />
				<form:errors path="practicumHours" cssClass="error" />
			</div>
			
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold"
					style="text-align: right">Number of Hours assumed full responsibility in the role:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control" path="hoursFullResponsibility" aria-label="Please enter number of hours"  maxlength="10" />
				<form:errors path="hoursFullResponsibility" cssClass="error" />
			</div>			
		</div>


		<div class="form-group row">
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Practicum Type:</div>
			</div>
			<div class="col-sm-2">
				<form:select id="practicumTypeCode" path="practicumTypeCode"
					class="form-control custom-select-lg" aria-label="Please select Practicum Type">
					<form:options items="${practicumTypes}" />
				</form:select>
				<form:errors path="practicumTypeCode" cssClass="error" />
			</div>
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Cycle Completion Year:</div>
			</div>
			<div class="col-sm-2">
				<c:if test="${capCycleInfo.schoolYear ne null }" ><div class="col-form-label">${capCycleInfo.schoolYear-1} - ${capCycleInfo.schoolYear}</div>	</c:if>			
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-8">
				<div class="col-form-label float-right font-weight-bold">Have
					any of the components of the approved programs been waived? </div>
			</div>
			<div class="col-sm-4">
				<form:select id="waived" path="waived" cssStyle=" width:100px"
					class="form-control custom-select-lg" aria-label="Please select if any components have been waived">
					<form:option value="N" label="No" />
					<form:option value="Y" label="Yes" />
				</form:select>
				<form:errors path="waived" cssClass="error" />
			</div>
		</div>

		<sec:authorize access="hasAnyRole('ROLE_MANAGER', 'ROLE_SUPERVISOR', 'ROLE_CANDIDATE')">
			<div class="form-group row">
				<div class="col-sm-12" style="text-align: center">
					<input type="submit" value="Save" name="saveCycleInfo"
						onclick="setScrollPosition();" class="btn btn-primary" />
				</div>
			</div>
		</sec:authorize>

		<div class="line" style="margin: 10px 0; color: black"></div>


		<div style="text-align: center; margin: 40px">
			<span style="font-size: 1.3rem; font-weight: bold">Teacher
				Candidate Information</span>
		</div>

		<div class="form-group row">
			<div class="col-sm-3">
				<div class="col-form-label float-right font-weight-bold">Name:</div>
			</div>
			<div class="col-sm-2">
				<div class="col-form-label">${capCycleInfo.candidateFirstName}
					${capCycleInfo.candidateLastName}</div>
			</div>
			<div class="col-sm-3">
				<div class="col-form-label  float-right font-weight-bold">MEPID:</div>
			</div>
			<div class="col-sm-4">
				<div class="col-form-label">${capCycleInfo.candidateMEPID}</div>
			</div>

		</div>

		<div class="line" style="margin: 10px 0; color: black"></div>

		<div style="text-align: center; margin: 40px">
			<span style="font-size: 1.3rem; font-weight: bold">Program
				Supervisor Information</span>
		</div>

		<div class="form-group row">
			<div class="col-sm-3">
				<div class="col-form-label float-right  font-weight-bold">Name:</div>
			</div>
			<div class="col-sm-2">
				<div id="supervisorName" class="col-form-label">${capCycleInfo.supervisor.firstName}
					${capCycleInfo.supervisor.lastName}</div> <input id="supervisorPersonId"
					type="hidden" value="${capCycleInfo.supervisor.daPersonId}"
					name="supervisor.daPersonId">
			</div>
			<div class="col-sm-3">
				<div class="col-form-label float-right font-weight-bold">UserId:&nbsp;</div>
			</div>
			<div class="col-sm-3">
				<div id="supervisorId" class="col-form-label">${capCycleInfo.supervisor.userId}</div>
			</div>

			<div class="col-sm-1"  style="text-align:right">
				
			</div>

		</div>


		<div class="line" style="margin: 10px 0; color: black"></div>

		<div style="text-align: center; margin: 40px">
			<span style="font-size: 1.3rem; font-weight: bold">Supervising
				Practitioner Information</span>
		</div>

		<div id="practionerList">
			<div class="form-group row">
				<div class="col-sm-12">
					<table class="table white-background">
						<thead>
							<tr>
								<th>Name</th>
								<th>MEPID</th>
								<th>Practicum School</th>
								<th style="width: 12%">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${capCycleInfo.practitioners }"
								var="practitioner" varStatus="status">
								<tr>
									<td>${practitioner.firstName} ${practitioner.lastName}</td>
									<td>${practitioner.mepid}</td>
									<td>${practitioner.districtName}:${practitioner.schoolName}</td>
									<td style="text-align: center"> </td>

								</tr>
							</c:forEach>
							
						</tbody>

					</table>
				</div>
			</div>


		</div>


		<div class="line" style="margin: 10px 0; color: black"></div>


		<div style="text-align: center; margin: 40px">
			<span style="font-size: 1.3rem; font-weight: bold">Cycle
				Status</span>
		</div>

		<div class="form-group row">
			<div class="col-sm-2"></div>
			<div class="col-sm-10">
				<div class="col-form-label "><b>Status:</b>
					<c:if test="${empty capCycleInfo.cycleStatus}"> Open</c:if>
					<c:if test="${not empty capCycleInfo.cycleStatus}"> 
						<c:forEach items="${statusReasonTypes}" var="entry">
							<c:if test="${entry.key == capCycleInfo.cycleStatus}">
								<c:out value="${entry['value']}" />
							</c:if>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-2"></div>
			<div class="col-sm-10">
				<div class="col-form-label font-weight-bold">Incomplete Assessments and/or Observations:</div>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2"></div>
			<div class="col-sm-10">
				<div class="col-form-label"> <c:forEach var="iws"
						items="${fn:split(capCycleInfo.incompleteWorksString, ',')}">
						${iws}</br>
					</c:forEach>
				</div>
			</div>
		</div>

		<input type="hidden" name="cycleId" value="${cycleId}">
		<input type="hidden" name="scrollX" id="scrollX" value="0" />
		<input type="hidden" name="scrollY" id="scrollY" value="0" />
	</form:form>
</body>
</html>
