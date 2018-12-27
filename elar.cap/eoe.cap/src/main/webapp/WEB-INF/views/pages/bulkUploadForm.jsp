<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function pageLoad() {
		$(document)
				.on(
						'change',
						':file',
						function() {
							$('.error').remove();

							if (this.files[0].size > 52428800) {
								this.value = "";
								$(this)
										.after(
												'<span class="error" >Only 50 MB of Data is allowed to upload.</span>');
								return;
							}

							var input = $(this), numFiles = input.get(0).files ? input
									.get(0).files.length
									: 1, label = input.val()
									.replace(/\\/g, '/').replace(/.*\//, '');

							input[0].nextElementSibling.innerText = label;

						});

	}
</script>
</head>
<body>

	<form:form id="form2" method="POST" enctype="multipart/form-data"
		commandName="batchInfo">


		<div class="form-group row">
			<div class="col-sm-12" style="text-align: center">
				<h4>Upload CAP Cycle Report</h4>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-2"></div>
			<div class="col-sm-4" style="vertical-align: middle;">
				<div class="custom-file" style="margin-top: 50px">
					<input type="file" class="custom-file-input" id="file" name="file">
					<label class="custom-file-label" for="file">Choose file</label>
				</div>
				<form:errors path="file" cssClass="error" />
				<c:if test="${batchInfo.errcount gt 0 }" >	
				<div class="error">Please use <a  href="/cap/batchload/errorLog?batchId=${batchInfo.batchId}" style="color:blue;text-decoration: underline;" > this link</a> to see the list of
					errors in the uploaded file. Please upload the file again and
					ensure that the data entered is accurate and is in correct format.
				</div>
				</c:if>
			</div>
			<div class="col-sm-4">
				<p>
					<b>Note:</b>
				</p>
				<p>
				<ul>
					<li>Please click <a href="/cap/batchload/template" style="color:blue;text-decoration: underline;" >here</a>,
						to download template for CAP Cycle Report.
					</li>
					<li>Please ensure that the information entered is accurate and
						for the current Cycle Year.</li>
				</ul>
				</p>
			</div>
			<div class="col-sm-2"></div>
		</div>



		<div class="form-group row">
			<div class="col-sm-12" style="text-align: center">
				<input type="submit" value="Upload" class="btn btn-primary" />
			</div>
		</div>
		<div class="line" style="margin: 10px 0; color: black"></div>


	</form:form>

</body>
</html>
