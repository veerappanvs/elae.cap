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
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.flash.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.flash.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.print.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/fixedheader/3.1.5/js/dataTables.fixedHeader.js"></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function pageLoad() {

		var table = $('#resultDatatable').DataTable({
			fixedHeader:true,				
			"columnDefs" : [ {
				"targets" : [ 5 ],
				"orderData" : [ 6 ]
			}, {
				"targets" : [ 6 ],
				"visible" : false,
				"searchable" : false
			} ]
		});
		
		jQuery('#year').change( function() {
			 $("#form").submit();
	    });

	}
	
	
</script>
<title></title>
</head>
<body>
<form:form id="form" method="GET" >
	<div class="form-group row">
		<div class="col-sm-3">
			<div class="col-form-label float-right font-weight-bold">Completion
				Year:</div>
		</div>

		<div class="col-sm-3">
			<select id="year" name="year" class="form-control custom-select-lg"
				aria-label="Please select a CAP completion year">
				<option   value="0">All</option>
				<c:forEach items="${years}" var="year">
					<option ${year.key eq selectedYear ?"selected='selected'":""}  value="${year.key }">${year.key }</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-sm-6"></div>
	</div>

	<div class="form-group row">
		<div class="col-sm-12">		
					<table id="resultDatatable"
						class="table table-hover table-bordered table-striped">
						<thead>
							<tr>
								<th title="Teacher Candidate"><strong>Teacher
										Candidate</strong></th>
								<th title="MEPID"><strong>MEPID</strong></th>
								<th title="Program"><strong>Program</strong></th>
								<th title="Program Supervisor"><strong>Program
										Supervisor</strong></th>
								<th title="Supervising Practitioner"><strong>Supervising
										Practitioner</strong></th>
								<th title="Cycle Import Date"><strong>Cycle
										Import Date</strong></th>
								<th><strong>Year</strong></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${importedCapInfos}" var="importedCapInfo">
								<tr>
									<td><a
										href="/cap/importedCapInfo?importId=${importedCapInfo.uploadId}">${importedCapInfo.candidateName}</a></td>
									<td>${importedCapInfo.candidateMepid}</td>
									<td>${importedCapInfo.programName}</td>
									<td>${importedCapInfo.supervisorName}</td>
									<td>${importedCapInfo.practitionerName}</td>
									<td><fmt:formatDate pattern="MM/dd/yyyy"
											value="${importedCapInfo.importDate}" /></td>
									<td><fmt:formatDate pattern="yyyy/mm/dd"
											value="${importedCapInfo.importDate}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		

</form:form>
</body>
</html>