
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>

var noDataFoundforMEPID="<spring:message code="empty.mepid.result"/>";
var noDataFoundforPrograms="<spring:message code="empty.programs.result"/>";



function startCycle(programCompleterId){
	
	$('#programCompleterId').val(programCompleterId);
	jQuery('#form1').submit();
	
}

function pageLoad() {
			loadDropDownWithSortOrder('candidate/programs','selectProgramId');
			
			$('#searchByProgram').click(function() {
				$('#inputmepid').val('');
				loadDataTable('candidate/programid','result','selectProgramId',noDataFoundforPrograms)	
				
			});
			
			$('#searchByMEPID').click(function() {
				$('#selectProgramId').val('');
				loadDataTable('candidate/mepid','result','inputmepid',noDataFoundforMEPID)	
				
			});

			
			}




	
	
</script>
<title></title>
</head>
<body>
	<div id="error-section" style="margin-bottom:25px" ></div>

	<form:form id="form1"  method="POST" commandName="candidateEnrollment">
		<div style="text-align: center; padding: 10px">
			<span style="font-size: 1.3rem; font-weight: bold">Teacher Candidate Search</span></br></br>
			<p>
			<span style="font-size: 1rem;"><b>Note:</b> Search by the Teacher Candidate's program or MEPID, then select the name of the Teacher Candidate to add to the Cycle.</span>
			</p>
			<p>&nbsp;</p>
		</div>

		<div class="form-group row"> 
		<div class="col-sm-1">
				</div>  
			<div class="col-sm-4">
				<form:select id="selectProgramId" path="selectProgramId"
					 class="form-control form-control-sm" aria-label="Please select a program" >
					 <form:option value="">Select</form:option>
				</form:select>
				<form:errors path="selectProgramId"  />
			</div>
			<div class="col-sm-2">
				<input id="searchByProgram" type="button" class="btn btn-primary"
					value="Search By Program">
			</div>
			<div class="col-sm-2">
				<form:input id="inputmepid" path="inputmepid" class="form-control form-control-sm"  maxlength="8" aria-label="Please enter a MEPID" />
			</div>
			<div class="col-sm-2">
				<button id="searchByMEPID" type="button" class="btn btn-primary">Search By MEPID</button>
			</div>
			<div class="col-sm-1">
				</div>
		</div>


		<div id="resultWrapper"></div>
		<form:hidden id="programCompleterId" path="programCompleterId" />
		<input type="hidden" value="0" name="_page" />
		<input type="hidden" value="Next" name="_command" />

	</form:form>

</body>
</html>