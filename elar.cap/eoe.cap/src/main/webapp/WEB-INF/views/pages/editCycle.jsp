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
			async : false,
			url : path,
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

	<form:form id="form2" method="POST"  commandName="capCycleInfo"
		action="/cap/cycle">

		<div style="text-align: center; padding: 10px">
			<span style="font-size: 1.3rem; font-weight: bold">CAP Form</span></br>			
		</div>
		

		<div class="form-group row">
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Note:</div>
			</div>
			<div class="col-sm-8">
				<div class="col-form-label">To be completed by the Program Supervisor and Teacher Candidate.</div>
			</div>
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
				<form:input class="form-control " path="courseNumber" aria-label="Please enter Practicum Course Number" maxlength="255" />
				<form:errors path="courseNumber" cssClass="error" />
			</div>
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Credit Hours:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control" path="creditHours" aria-label="Please enter number of Credit Hours" maxlength="10" />
				<form:errors path="creditHours" cssClass="error" />
			</div>
		</div>


		<div class="form-group row">
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Practicum/Equivalent Seminar Course Title:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control " path="courseTitle" aria-label="Please enter Practicum Course Title" maxlength="255"  />
				<form:errors path="courseTitle" cssClass="error" />
			</div>
		
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Grade level of Practicum Students:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control" path="gradLevel" aria-label="Please enter Grade Level"   maxlength="255"  />
				<form:errors path="gradLevel" cssClass="error" />
			</div>		
		</div>

		<div class="form-group row">
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Total Number of Practicum Hours:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control" path="practicumHours" aria-label="Please enter Practicum Hours"  maxlength="10"  />
				<form:errors path="practicumHours" cssClass="error" />
			</div>
			
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold"
					style="text-align: right">Number of Hours assumed full responsibility in the role:</div>
			</div>
			<div class="col-sm-2">
				<form:input class="form-control" path="hoursFullResponsibility" aria-label="Please enter number of hours"   maxlength="10" />
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
			<div class="col-sm-2">
				<div id="supervisorId" class="col-form-label">${capCycleInfo.supervisor.userId}</div>
			</div>

			<div class="col-sm-2"  >
				<sec:authorize access="hasRole('ROLE_MANAGER')">
					<button type="button" class="btn btn-primary"
						data-toggle="modal" data-target="#programSupervisorListModal"
						data-backdrop="static"
						onclick="loadProgramSupervisorModal('loadProgramSupervisor','','index=${status.index}');"
						data-keyboard="false">Change</button>
				</sec:authorize>
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
									<sec:authorize
										access="hasAnyRole('ROLE_MANAGER', 'ROLE_SUPERVISOR')">
										<td style="text-align: center"><button type="button"
												class="btn btn-primary" data-toggle="modal"
												data-target="#practionerListModal"
												data-backdrop="static"
												onclick="loadPractitionerModal('loadPractitioner','','index=${status.index}');"
												data-keyboard="false">Change</button> <c:if
												test="${capCycleInfo.practitioners.size() gt 1 }">
												<button type="button" class="btn btn-primary"
													style="margin-top: 10px;display:block"
													onclick="loadPractitionerModal('deletePractitioner','','index=${status.index}');">Delete</button>
											</c:if></td>
									</sec:authorize>

									<sec:authorize
										access="!hasAnyRole('ROLE_MANAGER', 'ROLE_SUPERVISOR')">
										<td>&nbsp;</td>
									</sec:authorize>

								</tr>
							</c:forEach>
							<sec:authorize
								access="hasAnyRole('ROLE_MANAGER', 'ROLE_SUPERVISOR')">
								<tr>
									<td colspan="4" style="text-align: center; border: none">
									<c:if test="${capCycleInfo.practitioners.size() lt 2 }">		<button type="button" class="btn btn-primary"
											style="margin: 10px" data-toggle="modal"
											data-target="#practionerListModal" data-backdrop="static"
											onclick="loadPractitionerModal('addPractitioner','','index=${capCycleInfo.practitioners.size()}');"
											data-keyboard="false">Add Practitioner</button>
											</c:if>
									</td>
								</tr>
							</sec:authorize>
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
				<div class="col-sm-2">
					<span style="font-size: 1rem; font-weight: bold">Status:</span>
					<c:if test="${empty capCycleInfo.cycleStatus}"> Open</c:if>
				</div>
	
				<div class="col-sm-8 float-left">
					<c:forEach items="${statusReasonTypes}" var="entry">
						<c:if test="${entry.key == capCycleInfo.cycleStatus}">
							<c:out value="${entry['value']}" />
						</c:if>
					</c:forEach>
				</div>
			</div>
		<sec:authorize access="!hasRole('ROLE_ADMIN')">
			<div class="form-group row">
				<div class="col-sm-2"></div>
				<div class="col-sm-10">
					<span style="font-size: 1rem; font-weight: bold">Incomplete Assessments and/or Observations:</span>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-2"></div>
				<div class="col-sm-10">
					<c:forEach var="iws" items="${fn:split(capCycleInfo.incompleteWorksString, ',')}">
							${iws}</br>
					</c:forEach>
				</div>
			</div>
		</sec:authorize>
		
		<sec:authorize access="hasAnyRole('ROLE_MANAGER', 'ROLE_SUPERVISOR')">
			<c:if test="${empty capCycleInfo.cycleStatus}">
				<div class="form-group row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 style="align-items:center;" >
						<input type="button" name="answer" class="btn btn-primary" aria-label="Do you want to end cycle"
							value="Do you want to end the cycle?"
							onclick="showEndingReasonDiv()" /></br>
							<form:errors path="statusReasonTypeCode" cssClass="error" />
					</div>
					<div class="col-sm-2"></div>
				</div>
			</c:if>

			<div id="wantToEndDiv" style="display: none;">
				<div class="form-group row">
					<div class="col-sm-2"></div>
					<div class="col-sm-4">
						<div class="col-form-label float-right font-weight-bold">Please
							provide a reason for ending the cycle:</div>
					</div>
					<div class="col-sm-4">
						<form:select id="statusReasonTypeCode" path="statusReasonTypeCode"
							class="form-control custom-select-lg" aria-label="Please select a Status">
							<form:option value="" label="Select" />
							<form:options items="${statusReasonTypes}" />
						</form:select>					
					</div>
					<div class="col-sm-2"></div>
				</div>
			</div>
		</sec:authorize>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<c:if test="${not empty capCycleInfo.cycleStatus}">
				<div class="form-group row">
					<div class="col-sm-2"></div>
					<div class="col-sm-3">
						<div class="col-form-label font-weight-bold">Reason for closing the cycle:</div>
					
						<div class="col-form-label">
							<c:forEach items="${statusReasonTypes}" var="entry">
								<c:if test="${entry.key == capCycleInfo.cycleStatus}">
								<c:out value="${entry['value']}" />
								</c:if>
							</c:forEach>
						</div>
					</div>	
					<div class="col-sm-5"></div>
					<div class="col-sm-2"></div>
				</div>
				
				<!-- This option is only available to CAP ADMIN if reOpenDate field is null -->
				<c:if test="${empty capCycleInfo.reOpenDate}">
					<div class="form-group row">
						<div class="col-sm-2"></div>
						<div class="col-sm-3">
							<div class="col-form-label font-weight-bold">Do you want to Re-open the cycle?</div>&nbsp;&nbsp;
							<form:radiobutton path = "reOpenCycleFlag" value = "Y"/><div class="font-weight-bold">Yes</div>&nbsp;&nbsp;
							<form:radiobutton path = "reOpenCycleFlag" value = "N" /><divclass="font-weight-bold">No</div>
						</div>	
						<div class="col-sm-5"></div>
						<div class="col-sm-2"></div>
					</div>
				</c:if>
			</c:if>
		</sec:authorize>
		
		<div class="modal fade" id="practionerListModal" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg"
				role="document">
				<div class="modal-content" style="padding: 20px">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Assign
							Supervising Practitioner</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div id="error-section-modal" style="margin-bottom: 25px"
							class="error"></div>
						<div id="practitioner-section"></div>
					</div>

				</div>
			</div>
		</div>

		<div class="modal fade" id="programSupervisorListModal" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg"
				role="document">
				<div class="modal-content" style="padding: 20px">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Re-assign
							Program Supervisor</h5>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<div id="error-section-modal" style="margin-bottom: 25px"
							class="error"></div>
						<div id="programSupervisor-section"></div>
					</div>
				</div>
			</div>
		</div>
		<sec:authorize access="hasAnyRole('ROLE_MANAGER', 'ROLE_SUPERVISOR')">
			<div class="form-group row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<div style="margin: 50px">
						<input type="submit" value="Cancel" name="Cancel"
							class="btn btn-primary" /> <input type="submit" value="Save"
							name="endCycle" class="btn btn-primary" />
					</div>
				</div>
				<div class="col-sm-4"></div>
			</div>
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<c:if test="${empty capCycleInfo.reOpenDate && not empty capCycleInfo.cycleCloseDate}">
				<div class="form-group row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<div style="margin: 50px">
							<input type="submit" value="Cancel" name="Cancel"
								class="btn btn-primary" /> <input type="submit" value="Save"
								name="reOpenCycle" class="btn btn-primary" />
						</div>
					</div>
					<div class="col-sm-4"></div>
				</div>
			</c:if>
		</sec:authorize>
		
		<input type="hidden" name="cycleId" value="${cycleId}">
		<input type="hidden" name="scrollX" id="scrollX" value="0" />
		<input type="hidden" name="scrollY" id="scrollY" value="0" />
	</form:form>

