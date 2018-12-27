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
<script type="text/javascript">
function pageLoad(){
	$('#meetingDate1').datepicker();
	$('#meetingDate2').datepicker();
	$('#meetingDate3').datepicker();
}
	
	function formSubmit(meetingNumber){
		$("#form2").attr("action", "/cap/threewaymeeting?cycleId=${cycleId}&meetingNumber="+meetingNumber); 
		$('#form2').submit();
	}
	
</script>
<title></title>
</head>
<body>
	<form:form id="form2" method="POST" commandName="threewayMeeting">
		
		<jsp:include page="cycleInfo.jsp"></jsp:include>

		<div class="line"></div>

		

		<div class="form-group row">
			<div class="col-sm-1"></div>
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">First Three-Way Meeting</div>
			</div>
			<div class="col-sm-2">
				<form:input path="meetingDate1" cssClass="form-control" placeholder="mm/dd/yyyy"  disabled="true" aria-label="First Three-Way Meeting" />				
			</div>
			<div class="col-sm-4"></div>
			<div class="col-sm-1"></div>
		</div>
		
		<div class="form-group row" style="text-align:center">
			<div class="col-sm-12"><form:errors path="meetingDate1"  cssClass="error"  /> </div>
		</div>
		
		
		
		
		
		<div class="line"></div>

		<div class="form-group row">
			<div class="col-sm-1"></div>
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Second Three-Way Meeting</div>
			</div>
			<div class="col-sm-2">
				<form:input path="meetingDate2" cssClass="form-control"  placeholder="mm/dd/yyyy"  disabled="true"  aria-label="Second Three-Way Meeting" />
			</div>
			<div class="col-sm-4"></div>
			<div class="col-sm-1"></div>
		</div>
		<div class="form-group row" style="text-align:center">
			<div class="col-sm-12"><form:errors path="meetingDate2"  cssClass="error"  /> </div>
		</div>
				
		<div class="line"></div>


		<div class="form-group row">
			<div class="col-sm-1"></div>
			<div class="col-sm-4">
				<div class="col-form-label float-right font-weight-bold">Third Three-Way Meeting</div>
			</div>
			<div class="col-sm-2">
				<form:input path="meetingDate3" cssClass="form-control"  placeholder="mm/dd/yyyy" disabled="true" aria-label="Third Three-Way Meeting" />
			</div>
			<div class="col-sm-4"></div>
			<div class="col-sm-1"></div>
		</div>
		
		<div class="form-group row" style="text-align:center">
			<div class="col-sm-12"><form:errors path="meetingDate3"  cssClass="error"  /> </div>
		</div>

	</form:form>
</body>
</html>
