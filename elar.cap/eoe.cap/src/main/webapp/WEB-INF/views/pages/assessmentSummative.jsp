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
<script>

function setScrollPosition(elementCode){
	$('#scrollX').val(window.pageXOffset);
	$('#scrollY').val(window.pageYOffset);
	$('#elementCode').val(elementCode);
	
}

	function pageLoad() {
		window.scroll(${scrollX!=null?scrollX:0},${scrollY!=null?scrollY:0});
	}
</script>
<title></title>
</head>
<body>
	<form:form id="form2" method="POST" commandName="assessmentInfo"  action="summative"  >
		<div id="error-section" style="margin-bottom: 25px" class="error">
			<form:errors />
		</div>
		
		<jsp:include page="cycleInfo.jsp"></jsp:include>

		<div class="line" style="margin: 10px 0; color: black"></div>

		<div style="text-align: center; padding: 10px"><h5>${assessmentInfo.typeDesc} Assessment for ${cycleInfo.candidateFirstName} ${cycleInfo.candidateLastName}</h5>
		</div>

		<div class="line" style="margin: 10px 0; color: black"></div>

		<div class="form-group row">
			<div class="col-sm-12">
				<div style="border: 1px solid; padding: 20px">
					<div class="form-group row">
						<div class="col-sm-12">
							<b>Instructions:</b>  The Program Supervisor and Supervising
							Practitioner jointly complete the ${assessmentInfo.typeDesc}
							Assessment by reviewing all available evidence and assigning
							ratings for the candidates demonstration of quality, scope, and
							consistency of each element.
						</div>
					</div>
					<c:forEach items="${dimensions}" var="dimension">
						<div class="form-group row" style="margin-left: 20px">
							<div class="col-sm-12">
								<li><b>${dimension.dimensionDesc}: </b> ${dimension.dimensionLongDesc}</li>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>




		<div class="line" style="margin: 10px 0; color: black"></div>

		<c:forEach items="${assessmentInfo.elements}" var="element"
			varStatus="elementIndex">
			<div id="${element.elementCode}">
				<div class="form-group row"
					style="padding: 20px; margin: 2px; background: aliceBlue">
					<div class="col-sm-4 font-weight-bold">${element.altDesc }</div>
					<div class="col-sm-5"></div>
					<div class="col-sm-3"><b>Progress: </b> ${element.completed eq 'Y' ? 'Complete':'Incomplete' }</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-12">
						<table class="table white-background">
							<thead>
								<tr>
									<c:forEach items="${element.ratingInfos}" var="ratingInfo">
										<th scope="col">${ratingInfo.shortDesc}</th>
									</c:forEach>
								</tr>
							</thead>
							<tr>
								<c:forEach items="${element.ratingInfos}" var="ratingInfo">
									<td>${ratingInfo.longDesc}</td>
								</c:forEach>
							</tr>


						</table>


					</div>
				</div>


				<div class="form-group row">
					<div class="col-sm-12">
						<table class="table white-background">
							<thead>
								<tr>
									<th scope="col" style="text-align: center">Dimension</th>
									<th scope="col" style="text-align: center">Formative Assessment Rating</th>
									<th scope="col" style="text-align: center">Summative Assessment Rating</th>
									<th scope="col" style="text-align: center">Readiness Threshold Met?</th>
								</tr>
							</thead>
							<c:forEach items="${element.dimensions}" var="dimension"
								varStatus="dimensionIndex">
								<tr>
									<td style="text-align: center"><b>${dimension.dimensionDesc}</b></td>
									<td style="text-align: center">${dimension.formativeRatingDesc}</td>
									<td style="text-align: center"><form:select
											path="elements[${elementIndex.index }].dimensions[${dimensionIndex.index }].ratingCode"
											cssClass="form-control" aria-label="Please select a rating">
											<form:option value="">Select</form:option>
											<form:options items="${ratingTypes}" />
										</form:select></td>
									
									<c:if test="${dimensionIndex.index eq 0 }">
										<td rowspan="${element.dimensions.size()}"
											style="text-align: center"><form:radiobutton
												cssClass="form-control" 
												path="elements[${elementIndex.index}].metThreshHold"
												value="Y" label=" Yes" /> <form:radiobutton
												cssClass="form-control" cssStyle="margin-top:20px" 
												path="elements[${elementIndex.index}].metThreshHold"
												value="N" label=" No" /></td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>

				<div class="form-group row" style="padding: 20px">
					<div class="col-sm-12">
						<div class="form-group row">
							<div class="col-sm-12">
								<h6>Sources of Evidence</h6>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-12">
								<table class="table white-background">
										<tr>
											<td scope="col" colspan="4" style="text-align: center;font-weight:bold;width: 55%">Observation</td>
											<td scope="col" rowspan="2" style="text-align: center;${element.evidenceSources.mslFocus?'font-weight:bold':'' }">Measure
												of Student Learning</td>
											<td scope="col" rowspan="2" style="text-align: center;${element.evidenceSources.slfFocus?'font-weight:bold':'' }">Student
												Feedback</td>
											<td scope="col" rowspan="2" style="text-align: center;${element.evidenceSources.cafFocus?'font-weight:bold':'' }">Candidate
												Artifacts</td>
											<td scope="col" rowspan="2" style="text-align: center;${element.evidenceSources.ppgFocus?'font-weight:bold':'' }">Professional
												Practice Goals</td>
										</tr>
										<tr>
											<td scope="col" style="text-align: center;${element.evidenceSources.announced1Focus?'font-weight:bold':'' }">Announced 1</td>
											<td scope="col" style="text-align: center;${element.evidenceSources.unAnnounced1Focus?'font-weight:bold':'' }">Unannounced 1</td>
											<td scope="col" style="text-align: center;${element.evidenceSources.announced2Focus?'font-weight:bold':'' }">Announced 2</td>
											<td scope="col" style="text-align: center;${element.evidenceSources.unAnnounced2Focus?'font-weight:bold':'' }">Unannounced 2</td>
										</tr>
										
										<tr>
											<td scope="col" style="text-align: center;"><input disabled="disabled" type="checkbox" ${element.evidenceSources.announced1?'checked="checked" ':'' }/></td>
											<td scope="col" style="text-align: center;"><input disabled="disabled" type="checkbox" ${element.evidenceSources.unAnnounced1?'checked="checked" ':'' }/></td>
											<td scope="col" style="text-align: center;"><input disabled="disabled" type="checkbox" ${element.evidenceSources.announced2?'checked="checked" ':'' }/></td>
											<td scope="col" style="text-align: center;"><input disabled="disabled" type="checkbox" ${element.evidenceSources.unAnnounced2?'checked="checked" ':'' }/></td>
											<td scope="col" style="text-align: center;"><input disabled="disabled" type="checkbox" ${element.evidenceSources.msl?'checked="checked" ':'' }/></td>
											<td scope="col" style="text-align: center;"><input disabled="disabled" type="checkbox" ${element.evidenceSources.slf?'checked="checked" ':'' }/></td>
											<td scope="col" style="text-align: center;"><input disabled="disabled" type="checkbox" ${element.evidenceSources.caf?'checked="checked" ':'' }/></td>
											<td scope="col" style="text-align: center;"><input disabled="disabled" type="checkbox" ${element.evidenceSources.ppg?'checked="checked" ':'' }/></td>
										</tr>
								</table>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-4">
								<div class="col-form-label">
									<b>Announced Observation 1</b></br>
									Observation Date: <fmt:formatDate pattern="MM/dd/yyyy" value="${assessmentInfo.announcedObservation1.observationDate}" /></br>
									Calibrated Evidence: 
									
								</div>
							</div>
							<div class="col-sm-4">
								<div class="col-form-label"><b>Unannounced Observation 1</b></br>
								Observation Date: <fmt:formatDate pattern="MM/dd/yyyy" value="${assessmentInfo.unAnnouncedObservation.observationDate}" /></br>
								Calibrated Evidence: </br>
								</div>

							</div>
							<div class="col-sm-4">
								<div class="col-form-label"><b>Announced Observation 2</b></br>
								Observation Date: <fmt:formatDate pattern="MM/dd/yyyy" value="${assessmentInfo.announcedObservation2.observationDate}" /></br>
								Calibrated Evidence: 
								</div>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-4">
								<c:forEach
									items="${assessmentInfo.announcedObservation1.evidences}"
									var="evidence">
									<c:if test="${evidence.elementCode eq element.elementCode }">
										<textarea rows="5" class="form-control" readonly="readonly" aria-label="Calibrated evidence for announced observation 1">${evidence.calEvidence}</textarea>
									</c:if>
								</c:forEach>
							</div>
							<div class="col-sm-4">
								<c:forEach
									items="${assessmentInfo.unAnnouncedObservation.evidences}"
									var="evidence">
									<c:if test="${evidence.elementCode eq element.elementCode }">
										<textarea rows="5" class="form-control" readonly="readonly" aria-label="Calibrated evidence for unannounced observation 1">${evidence.calEvidence}</textarea>
									</c:if>
								</c:forEach>
							</div>
							<div class="col-sm-4">
								<c:forEach
									items="${assessmentInfo.announcedObservation2.evidences}"
									var="evidence">
									<c:if test="${evidence.elementCode eq element.elementCode }">
										<textarea rows="5" class="form-control" readonly="readonly" aria-label="Calibrated evidence for announced observation 2">${evidence.calEvidence}</textarea>
									</c:if>
								</c:forEach>
							</div>
						</div>

						
						<div class="form-group row">
							<div class="col-sm-8">
								<table class="table white-background">
									<tr>
										<td
											style="text-align: initial; border: 0; padding: 0; vertical-align: top">
											<table class="table white-background">
												<tr>
													<td
														style="text-align: initial; border: 0; padding: 0; vertical-align: top;padding: 0 15px 0 0;">
														<label class="col-form-label"><b>Unannounced
																Observation 2</b></br> Observation Date: <fmt:formatDate
																pattern="MM/dd/yyyy"
																value="${assessmentInfo.unAnnouncedObservation2.observationDate}" /></br>
															Calibrated Evidence: </label>
													</td>
													<td
														style="text-align: initial; border: 0; padding: 0; vertical-align: top;padding: 0 0 0 15px;">
														<label class="col-form-label"><b>Formative
																Assessment Evidence:</b> </label>
													</td>
												</tr>
												<tr>
													<td
														style="text-align: initial; border: 0; padding: 0; vertical-align: top;padding: 0 15px 0 0;">
														<c:forEach
															items="${assessmentInfo.unAnnouncedObservation2.evidences}"
															var="evidence">
															<c:if
																test="${evidence.elementCode eq element.elementCode }">
																<textarea rows="5" class="form-control"
																	readonly="readonly">${evidence.calEvidence}</textarea>
															</c:if>
														</c:forEach>
													</td>
													<td
														style="text-align: initial; border: 0; padding: 0; vertical-align: top;padding: 0 0 0 15px;">
														<textarea rows="5" class="form-control"
															readonly="readonly">${element.formativeRationale}</textarea>
													</td>
												</tr>
											</table>

										</td>
									</tr>
								</table>
							</div>
							<div class="col-sm-4">
								<table class="table white-background">
									<thead>
										<tr>
											<th scope="col" style="text-align: center; width: 60%">Tagged
												Evidence Files</th>
											<th scope="col" style="text-align: center">Types of
												Evidence</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${element.files.size() lt 1}">
											<tr>
												<td></td>
												<td></td>
											</tr>
										</c:if>
										<c:forEach items="${element.files}" var="file">
											<tr>
												<td><a style="display: block; margin-top: 10px"
													href="/cap/tagfile/download?cycleId=${cycleId }&amp;fileId=${file.fileId}"
													onclick="downloadFile false;">${file.internalFileName }</a></td>
												<td><c:forEach items="${file.evidenceTypes}"
														var="attribute" varStatus="attStatus">${attribute.label}${attStatus.last?'':', '}</c:forEach>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>


						<div class="form-group row">
							<div class="col-sm-12">
								<br/>
								<h6>Evidence: Insert evidence to support the ratings here.</h6>
								<b>Note:</b> Required Evidence for ${element.altDesc} includes 
								${element.evidenceSources.text}								
								
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-12">
								<form:textarea cssClass="form-control" rows="5" maxlength="4000" aria-label="Please enter Rating Rationale"
									path="elements[${elementIndex.index}].rationale" />
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-12" style="text-align: center">
					<input type="submit" value="Save"
						name="Save${element.elementCode }" class="btn btn-primary"
						onclick="setScrollPosition('${element.elementCode }');" />
				</div>
			</div>


		</c:forEach>

		<div class="line" style="margin: 10px 0; color: black"></div>
		<div class="form-group row">
			
			<div class="col-sm-12" style="padding: 20px;">
				<h5>Evidence-Based Feedback</h5>
			</div>
		</div>



		<div class="form-group row">
			<div class="col-sm-12">
				<table class="table white-background">
					<thead>
						<tr>
							<th scope="col" colspan="${dimensions.size()+2 }">Summary of
								Summative Assessment Ratings</th>
						</tr>
						<tr>
							<th scope="col">Element</th>
							<c:forEach items="${dimensions}" var="dimension">
								<th scope="col">${dimension.dimensionDesc }</th>
							</c:forEach>
							<th scope="col">Readiness Thresholds Met?</th>
						</tr>
					</thead>

					<c:forEach items="${assessmentInfo.elements}" var="element">
						<tr>
							<td>${element.altDesc }</td>
							<c:forEach items="${element.dimensions}" var="dimension">
								<td>${dimension.ratingDesc }</td>
							</c:forEach>
							<td>${element.metThreshHold eq 'Y'?'Yes':'No' }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>




		<div class="form-group row">
			<div class="col-sm-12">
				<table class="table white-background">
					<tr>
						<td width="25%"><b>Evidence-Based Feedback to Candidate</b></td>
						<td><form:textarea path="evidenceFeedback" rows="6" cssClass="form-control"
								maxlength="4000" aria-label="Evidence-Based Feedback to Candidate"/></td>
					</tr>

					<tr>
						<td width="25%"><b>Recommended Focus for Future
								Professional Practice Goal</b></td>
						<td><form:textarea path="recommendedfocus" rows="3" cssClass="form-control"
								maxlength="4000" aria-label="Recommended Focus for Future Professional Practice Goal"/></td>
					</tr>
				</table>
			</div>
		</div>

		<div class="line" style="margin: 10px 0; color: black"></div>

		<div class="form-group row">
			<div class="col-sm-12">Based on the Teacher Candidate's
				performance as measured on the CAP Rubric, we have determined this
				Teacher Candidate to be:</div>
		</div>


		<div class="form-group row">
			<div class="col-sm-3"></div>
			<div class="col-sm-3">				
				<form:radiobutton path="readyToTeach" value="Y" aria-label="Click here if the Teacher Candidate is Ready to Teach"/><b>&nbsp; Ready to Teach</b>
			</div>
			<div class="col-sm-3">
				<form:radiobutton path="readyToTeach" value="N" aria-label="Click here if the Teacher Candidate is not Ready to Teach"/>
				<b>&nbsp; Not Yet Ready to Teach</b>
			</div>
			<div class="col-sm-3"></div>
		</div>

		<div class="form-group row">
			<div class="col-sm-12">When you click "Ready To Teach", you are
				confirming this candidate is rated Proficient or higher in Quality
				across all six essential elements.</div>
		</div>





		<div class="line" style="margin: 10px 0; color: black"></div>
		<c:if test="${assessmentInfo.canSignOff }">
			<div class="form-group row">
				<div class="col-sm-5"></div>
				<div class="col-sm-2">
					<form:checkbox path="assignmentSigned" aria-label="Click here to complete the assessment form"/><b>&nbsp; Complete</b>
				</div>
				<div class="col-sm-5"></div>
			</div>


			<c:if test="${assessmentInfo.psApproved eq 'Y' }">
				<div class="form-group row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">The Program Supervisor has marked this
						Summative Assessment as "Finished".</div>
					<div class="col-sm-4"></div>
					</div>
			</c:if>

			<div class="form-group row">
					<div class="col-sm-1"></div>
					<div class="col-sm-10">
					<b>Note:</b> Please check this box if this
						Summative Assessment is complete.  This will give the Teacher
						Candidate access to this Form.	
					</div>
				<div class="col-sm-1"></div>
			</div>

		</c:if>

		<div class="form-group row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<div>
					<input type="submit" value="Cancel" name="cancel"
						class="btn btn-primary" /> <input type="submit" value="Save"
						name="save" class="btn btn-primary"
						onclick="setScrollPosition('ALL');" />
				</div>
			</div>
			<div class="col-sm-4"></div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10" >
				<b>Note:</b>  The option to complete this Form and share it with the Teacher Candidate will only become available when all required components of the Form are completed. Please use the Progress statuses above to identify and revisit any incomplete sections.  Both the Program Supervisor and Supervising Practitioner must mark this Form "Complete" in order to share it with the Teacher Candidate.
			</div>
			<div class="col-sm-1"></div>
		</div>
		<input type="hidden" name="cycleId" id="cycleId" value="${cycleId}" />
		<input type="hidden" name="typeCode" id="typeCode" value="3" />
		<input type="hidden" name="elementCode" id="elementCode" value="ALL" />
		<input type="hidden" name="scrollX" id="scrollX" value="0" />
		<input type="hidden" name="scrollY" id="scrollY" value="0" />
	</form:form>
</body>
</html>
