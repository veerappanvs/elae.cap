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
	$(document).on(
				'change',
				':file',
				function() {
					$('.error').remove();
					
					    if(this.files[0].size > 52428800){
					       this.value = "";
					       $(this).after('<span class="error" >Only 50 MB of Data is allowed to upload.</span>');
					       return;
					    }
						
					var input = $(this), numFiles = input.get(0).files ? input
							.get(0).files.length : 1, label = input.val()
							.replace(/\\/g, '/').replace(/.*\//, '');

							input[0].nextElementSibling.innerText = label;

				});

	}
	
	
	function deleteFile(cycleId,fileId){
		var uri='/cap/tagfile/delete?cycleId='+cycleId+'&fileId='+fileId;
		$.ajax({
			type : "GET",
			url : uri,
			 async: false,
			success : function(response) {
				$('#'+fileId).remove();
				
			},
			error : function(msg, url, line) {
				
			}
		});
		
	}
	
	
</script>
</head>
<body>

	<form:form id="form2" method="POST" enctype="multipart/form-data"
		commandName="evidenceFileInfo">


		
		<jsp:include page="cycleInfo.jsp"></jsp:include>


		<div class="line" style="margin: 10px 0; color: black"></div>


		<div class="form-group row">
			<div class="col-sm-12" style="text-align: center">
				<h4>Upload Evidence Files</h4>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-2"></div>
			<div class="col-sm-4">
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="file" name="file">
					<label class="custom-file-label" for="file">Choose file</label>
				</div>
				<form:errors path="file" cssClass="error" />
			</div>
			<div class="col-sm-4">Files must be under 50MB in size, and
				only the following formats are allowed: .doc(x), .xls(x), .ppt(x)
				.pdf, .jpg, .png, .bmp, .gif, .mp3, .wav., .txt</div>
			<div class="col-sm-2"></div>
		</div>

		<div style="margin: 50px 0; color: black"></div>
		<input type="hidden" value="${cycleId}">
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<div class="col-sm-4">Select Types(s) of Evidence:</div>
			<div class="col-sm-7"></div>
		</div>


		<div class="form-group row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">

				<table class="table white-background no-border left-aligned">
					<c:forEach items="${evidenceFileInfo.evidenceTypes}" step="3"
						var="element" varStatus="elementStatus">
						<tr>
							<td ><form:checkbox label="${evidenceFileInfo.evidenceTypes.get(elementStatus.index).label}"
									path="evidenceTypes[${elementStatus.index}].selected" disabled="${!canUpload }"
									 />
								</td>
							<td >
							<form:checkbox disabled="${!canUpload }"
									path="evidenceTypes[${(elementStatus.index+1)}].selected" label="${evidenceFileInfo.evidenceTypes.get(elementStatus.index+1).label}"
									 />
								</td>
							<td >
							<c:if test="${(elementStatus.index+2) lt evidenceFileInfo.evidenceTypes.size() }">
									<form:checkbox disabled="${!canUpload }"
										path="evidenceTypes[${(elementStatus.index+2)}].selected"
										label="${evidenceFileInfo.evidenceTypes.get(elementStatus.index+2).label}" />
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-sm-1"></div>
		</div>

		<div class="form-group row">
			<div class="col-sm-1"></div>
			<div class="col-sm-4">Tag File to Essential Element(s):</div>
			<div class="col-sm-7"></div>
		</div>


		<div class="form-group row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">

				<table class="table white-background no-border left-aligned">
					<c:forEach items="${evidenceFileInfo.attributes}" step="3"
						var="element" varStatus="elementStatus">
						<tr>
							<td ><form:checkbox label="${evidenceFileInfo.attributes.get(elementStatus.index).label}"
									path="attributes[${elementStatus.index}].selected" disabled="${!canUpload }"
									 />
								</td>
							<td ><form:checkbox disabled="${!canUpload }"
									path="attributes[${(elementStatus.index+1)}].selected" label="${evidenceFileInfo.attributes.get(elementStatus.index+1).label}"
									 />
								</td>
							<td ><form:checkbox disabled="${!canUpload }"
									path="attributes[${(elementStatus.index+2)}].selected" label="${evidenceFileInfo.attributes.get(elementStatus.index+2).label}"
									 />
								</td>

						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-sm-1"></div>
		</div>

		<c:if test="${canUpload }">
			<div class="form-group row">
				<div class="col-sm-12" style="text-align: center">
					<input type="submit" value="Upload" class="btn btn-primary" />
				</div>
			</div>
		</c:if>
		<div class="line" style="margin: 10px 0; color: black"></div>

		<div class="form-group row">
			<div class="col-sm-12" style="text-align: center">
				<h4>Current Uploaded Evidence File</h4>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-12">
				<table class="table white-background">
					<thead>
						<tr>
							<th>File Name</th>
							<th>Type of Evidence</th>
							<th>Tagged Element(s)</th>
							<th style="width: 15%">File Owner</th>
							<th style="width: 11%">Uploaded Date</th>
							<th style="width: 12%">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${evidenceFiles.size() lt 1 }">
							<tr>
								<td colspan="6">No uploaded file data exist.</td>
							</tr>
						</c:if>
						<c:forEach items="${evidenceFiles}" var="file">
							<tr id="${file.fileId}">
								<td ><a
									href="/cap/tagfile/download?cycleId=${cycleId }&amp;fileId=${file.fileId}"
									onclick="downloadFile false;">${file.internalFileName }</a></td>
							
								<td><c:forEach items="${file.evidenceTypes}" var="attribute"
										varStatus="attStatus">${attribute.label}${attStatus.last?'':', '}</c:forEach></td>
										
								<td><c:forEach items="${file.attributes}" var="attribute"
										varStatus="attStatus">${attribute.label}${attStatus.last?'':', '}</c:forEach></td>
										
								<td>${file.personName }</td>
								<td><fmt:formatDate pattern="MM/dd/yyyy"
										value="${file.createdDate}" /></td>
								<td><a class="btn btn-primary" href="#"
									onclick="deleteFile(${cycleId},${file.fileId });return false;"
									style="${file.canDelete?'':'display:none'}">Delete</a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


	</form:form>

</body>
</html>
