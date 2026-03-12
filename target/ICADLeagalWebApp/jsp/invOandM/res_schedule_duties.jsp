

<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<!-- <script type="text/javascript" src="../js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>

<style>
.ui-tabs-vertical {
	width: 45em;
}

.ui-tabs-vertical .ui-tabs-nav {
	padding: .1em .1em .1em .1em;
	float: left;
	width: 8em;
}

.ui-tabs-vertical .ui-tabs-nav li {
	clear: left;
	width: 100%;
	border-bottom-width: 1px !important;
	border-right-width: 0 !important;
	margin: 0 -1px .2em 0;
}

.ui-tabs-vertical .ui-tabs-nav li a {
	display: block;
}

.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active {
	padding-bottom: 0;
	padding-right: .1em;
	border-right-width: 1px;
	border-right-width: 1px;
}

.ui-tabs-vertical .ui-tabs-panel {
	padding: 1em;
	float: right;
	width: 30em;
}
</style>


<script type="text/javascript">
	$(document).ready(function() {
		
		 $('#Aeetab').hide();
		 
		 $('#aetabs').hide();
		 
		 $('#Deetabs').hide();
		 
		 $('#Eetabs').hide();
		 
		 $('#Setabs').hide();

		$('#unitId').multiselect({

			enableCaseInsensitiveFiltering : true

		});

		$('#circleId').multiselect({

			enableCaseInsensitiveFiltering : true

		});

		$('#divisionId').multiselect({

			enableCaseInsensitiveFiltering : true

		});

		$('#subdivisionId').multiselect({

			enableCaseInsensitiveFiltering : true

		});

		$('#reservoirId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		
		$('#designationId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		
		$('#projectId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		
		

	});

	$(function() {

		$("#addresjuris").click(function() {
			var link = $(this).attr('href');

			alert(link);

			$('#whereFormWillLive').load(link);

			// $(".content").load(link);
		});

		/* 
		 $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
		 $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
		 */
		$("#tabs").tabs()
		$("#tabs1").tabs()
		$("#tabs2").tabs()
		$("#tabs3").tabs()
		
		$("#tabs4").tabs()
		
		

		$(".childtab").tabs()

		$(".datepick").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});

		$("#miCompIdParent").change(function() {
			var id = $(this).val();

			alert(id);

			$('#compparentId').val(id);

			// $(".content").load(link);
		});
		
		
		$("#designationId").change(function() {
			var id = parseInt($(this).val());

			//alert(id);
             if(id==2){
            	 $('#Aeetab').show();
            	 
             }else{
            	 
            	 $('#Aeetab').hide(); 
             }
           if(id==4){
        	   
        	   $('#Deetabs').show();
            	 
             }else{
            	 $('#Deetabs').hide(); 
            	 
             }
           if(id==8){
        	   
        	   $('#aetabs').show();
          	 
           }else{
        	   $('#aetabs').hide();
        	   
           }
           if(id==5){
        	   
        	   $('#Eetabs').show();
            	 
           }else{
        	   
        	   $('#Eetabs').hide(); 
           }
           if(id==7){
        	   $('#Setabs').show();
           }else {
        	   
        	   $('#Setabs').hide();
           }
			

			// $(".content").load(link);
		});

	});
</script>

<!-- <div class="w3l-main" id="borderStyle"> -->


<div class="col-md-9">
	


<div>
		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">O&M of Reservoir:Schedule of Duties</h3>
			</div>

			<div class="panel-body">

				<div class="alert alert-info col-md-12" style="padding: 0px"
					id="action_alert"></div>


				<div class="col-md-12 invDiv">

<form:form id="mainformid" name="mainformname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

					<div class="col-md-12">
						<br /> <br />
						<div class="col-md-6">
							<div class="col-md-6">
								<label class="label-controlPMS rowlebel ">Select Unit: <font
									color=red>*</font>
								</label>
							</div>

							<div class="col-md-6">
								<select class="form-control" id="unitId" name="unitId" required
									onchange="getProjects(this.value,1);getCircles(this.value,1)">
									<option value=" ">--select--</option>
									<c:forEach items="${unitList}" var="u">
										<option value="${u.unitId}">${u.unitName}</option>

									</c:forEach>

								</select>
							</div>

							<div class="col-md-6">
								<label class="label-controlPMS rowlebel ">Select Circle:
									
								</label>
							</div>
							<div class="col-md-6">
								<select class="form-control" id="circleId" name="circleId"
									 onchange="getDivisions(this.value,1)">


								</select>
							</div>


							<div class="col-md-6">
								<label class="label-controlPMS rowlebel ">Select
									Division:
								</label>
							</div>
							<div class="col-md-6">
								<select class="form-control" id="divisionId" name="divisionId"
									 onchange="getSubDivisions(this.value,1)">



								</select>
							</div>

							<div class="col-md-6">
								<label class="label-controlPMS rowlebel ">Select Sub
									Division:
								</label>
							</div>
							<div class="col-md-6">
								<select class="form-control" id="subdivisionId"
									name="subdivisionId" >



								</select>
							</div>


						</div>
						<div class="col-md-6">

							<div class="col-md-6">
								<label class="label-controlPMS rowlebel ">Select
									Project: <font color=red>*</font>
								</label>
							</div>

							<div class="col-md-6">
								<select class="form-control" id="projectId" name="projectId"
									required onchange="getReservoirs(this.value,1)">
									


								</select>
							</div>
							<div class="col-md-6">
								<label class="label-controlPMS rowlebel ">Select
									Reservoir: <font color=red>*</font>
								</label>
							</div>

							<div class="col-md-6">
								<select class="form-control" id="reservoirId" name="reservoirId"
									required>



								</select>
							</div>
							
							<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Frequency: <font
							color=red>*</font>
						</label>
					</div>
					<div class="col-md-6">
						<select class="form-control" id="miTankFreqId" name="miTankFreqId"
							 required>
							<option value=" ">--select--</option>
							<option value="9">PRE MONSOON (April,May)</option>
							<option value="10">POST MONSOON (November,December)</option>
							<option value="11">DURING MONSOON(JUNE TO AUGUEST)</option>
						

						</select>
					</div>

							<div class="col-md-6">
								<label class="label-controlPMS rowlebel ">Select
									Designation: <font color=red>*</font>
								</label>
							</div>

							<div class="col-md-6">
								<select class="form-control" id="designationId"
									name="designationId" required>
									<option value=" ">--select--</option>
									<option value="2">AEE</option>
									<option value="8">AE</option>
									<option value="4">DEE</option>
									<option value="5">EE</option>
									<option value="7">SE</option>


								</select>
							</div>


						</div>



					</div>
</form:form>

				</div>



				<div id="Aeetab" class="col-md-12 ">




					<div id="tabs">
						<ul>




							<li><a href="#tabDaily" onclick="getcheckfalse1()" >Daily</a></li>
							<li><a href="#tabweekly" onclick="getcheckfalse2()" >Weekly</a></li>







						</ul>
						<!-- tabs -->





						<div id="tabDaily">

						<form:form id="resaeedaily" name="resaeedailyname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by AEE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId1" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId1" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId1" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId1" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId1" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId1" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId1" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId1" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="1"
									id="dutyFrequencyId1" type="hidden" />
									
									
							

<div class="col-md-12 invDiv">
<div class="col-md-6">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
															
														</label> 
														
														</div>
														<div class="col-md-6"><input type="text"
															class=" datepick form-control datepicker"
															id="aeeinspectDate"
															name="resScheduleDutyList[0].inspectDate"
															placeholder="dateofoperation" />
													</div>
													</div>








								<c:forEach items="${scheduleDutyDailyAee}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<c:out value="${n.dutyDisplaySeq}"></c:out>
												<b><c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyDailyAee}" var="k"
											varStatus="kcount">

											<c:if test="${k.parentDutyId==n.dutyId }">



												<div class="row">
													<br></br>
													<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck1  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>
													
													<div class="col-md-2">
													<label class="label-controlPMS rowlebel ">Enter Value:<font color=red>*</font></label>
													 <input name="readingValue${kcount.count}" value="" class=" form-control " id="resScheduleDutyList[${kcount.count}].readingValue" type="text" />
													 
													 </div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck1  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="inspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
															<option value="1">Monitor</option>
															<option value="2">Investigation</option>
															<option value="3">Repair</option>



														</select>
													</div>
													
													<div class="col-md-2">
													<label class="label-controlPMS rowlebel ">Enter Value:<font color=red>*</font></label>
													 <input name="readingValue${kcount.count}" value="" class=" form-control " id="resScheduleDutyList[${kcount.count}].readingValue" type="text" />
													 
													 </div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>


									</c:if>


								</c:forEach>



								<br />
								
								<button type="button" name="resaeedaily" id="resaeedailybtn"
								class="btn btn-1 btn-primary center-block schedulebutton">Submit</button>
							</form:form>

							

						</div>

						<div id="tabweekly">

						<form:form id="resaeeweekly" name="resaeeweeklyname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by AEE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId2" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId2" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId2" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId2" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId2" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId2" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId2" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId2" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="2"
									id="dutyFrequencyId2" type="hidden" />
									
									


								<c:forEach items="${scheduleDutyWeeklyAee}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<b><c:out value="${n.dutyDisplaySeq}"></c:out>
													<c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyWeeklyAee}" var="k"
											varStatus="kcount">

											<c:if test="${k.parentDutyId == n.dutyId }">

												<div class="row">
													<br></br>
													<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck2  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="inspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>
													
													

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>

											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck2  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="inspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>
													
													

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>

									</c:if>


								</c:forEach>


								<br />
								
								<button type="button" name="resaeeweekly" id="resaeeweeklybtn"
								class="btn btn-1 btn-primary center-block schedulebutton">Submit</button>
							</form:form>

							

						</div>



					</div>
					<!-- tabs -->


				</div>
				<!-- col-md-8 div Aee -->




				<div id="aetabs" class="col-md-12 ">



					<div id="tabs1">
						<ul>




							<li><a href="#aetabDaily" onclick="getcheckfalse3()">Daily</a></li>
							<li><a href="#aetabweekly" onclick="getcheckfalse4()">Weekly</a></li>







						</ul>
						<!-- tabs -->





						<div id="aetabDaily">

							<form:form id="resaedaily" name="resaedailyname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by AE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId3" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId3" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId3" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId3" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId3" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId3" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId3" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId3" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="1"
									id="dutyFrequencyId3" type="hidden" />

<div class="col-md-12 invDiv">
<div class="col-md-6">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
															
														</label> 
														
														</div>
														<div class="col-md-6"><input type="text"
															class=" datepick form-control datepicker"
															id="aeinspectDate"
															name="resScheduleDutyList[0].inspectDate"
															placeholder="dateofoperation" />
													</div>
													</div>



								<c:forEach items="${scheduleDutyDailyAe}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<c:out value="${n.dutyDisplaySeq}"></c:out>
												<b><c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyDailyAe}" var="k"
											varStatus="kcount">

											<c:if test="${k.parentDutyId==n.dutyId }">



												<div class="row">
													<br></br>
													<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck3  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


												

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>
													
													<div class="col-md-2">
													<label class="label-controlPMS rowlebel ">Enter Value:<font color=red>*</font></label>
													 <input name="readingValue${kcount.count}" value="" class=" form-control " id="resScheduleDutyList[${kcount.count}].readingValue" type="text" />
													 
													 </div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck3   rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="inspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>
													
													<div class="col-md-2">
													<label class="label-controlPMS rowlebel ">Enter Value:<font color=red>*</font></label>
													 <input name="readingValue${kcount.count}" value="" class=" form-control " id="resScheduleDutyList[${kcount.count}].readingValue" type="text" />
													 
													 </div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>


									</c:if>


								</c:forEach>



								<br />
								<button type="button" name="resaedaily" id="resaedailybtn"
								class="btn btn-1 btn-primary center-block schedulebutton">Submit</button>
							</form:form>

							

						</div>

						<div id="aetabweekly">

							<form:form id="resaeweekly" name="resaeweeklyname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by AE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId4" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId4" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId4" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId4" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId4" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId4" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId4" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId4" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="2"
									id="dutyFrequencyId4" type="hidden" />


								<c:forEach items="${scheduleDutyWeeklyAe}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<b><c:out value="${n.dutyDisplaySeq}"></c:out>
													<c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyWeeklyAe}" var="k"
											varStatus="kcount">

											<c:if test="${k.parentDutyId == n.dutyId }">

												<div class="row">
													<br></br>
														<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck4  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="aeinspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>
													
													

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>

											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck4  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="inspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>
													
													

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>

									</c:if>


								</c:forEach>


								<br />
								<button type="button" name="resaeweekly" id="resaeweeklybtn"
								class="btn btn-1 btn-primary center-block schedulebutton">Submit</button>
							</form:form>

							

						</div>



					</div>
					<!-- tabs -->


				</div>
				<!-- col-md-8 div Ae -->


				<div id="Deetabs" class="col-md-12 ">



					<div id="tabs2">
						<ul>




							<li><a href="#deetabMonthly" onclick="getcheckfalse5()">Monthly</a></li>
							<li><a href="#deetabQuarterly" onclick="getcheckfalse6()">Quarterly</a></li>
							<li><a href="#deetabHalfYearly" onclick="getcheckfalse7()">HalfYearly</a></li>
							<li><a href="#deetabYearly" onclick="getcheckfalse8()">Yearly</a></li>
							<li><a href="#deetab5years" onclick="getcheckfalse9()">Every 5 Years</a></li>







						</ul>
						<!-- tabs -->





						<div id="deetabMonthly">

							<form:form id="resdeemonthly" name="resdeemonthlyname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by DEE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId5" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId5" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId5" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId5" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId5" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId5" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId5" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId5" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="3"
									id="dutyFrequencyId5" type="hidden" />


								<c:forEach items="${scheduleDutyMonDee}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<c:out value="${n.dutyDisplaySeq}"></c:out>
												<b><c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyMonDee}" var="k"
											varStatus="ncount">

											<c:if test="${k.parentDutyId==n.dutyId }">



												<div class="row">
													<br></br>
														<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck5  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="deemoninspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck5 rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="deemoninspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>


									</c:if>


								</c:forEach>



								<br />
								<button type="button" name="resdeemonthly" id="resdeemonthlybtn"
								class="btn btn-1 btn-primary center-block schedulebutton">Submit</button>
							</form:form>

							

						</div>

						<div id="deetabQuarterly">

							<form:form id="resdeequart" name="resdeequartname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by DEE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId6" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId6" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId6" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId6" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId6" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId6" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId6" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId6" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="4"
									id="dutyFrequencyId1" type="hidden" />


								<c:forEach items="${scheduleDutyQuarterDee}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<b><c:out value="${n.dutyDisplaySeq}"></c:out>
													<c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyQuarterDee}" var="k"
											varStatus="ncount">

											<c:if test="${k.parentDutyId == n.dutyId }">

												<div class="row">
													<br></br>
														<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck6  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="deequarinspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>

											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck6  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="deequarinspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>

									</c:if>


								</c:forEach>


								<br />
								
								<button type="button" name="resdeequarterly" id="resdeequarterlybtn"
								class="btn btn-1 btn-primary center-block schedulebutton">Submit</button>
							</form:form>

							

						</div>

						<div id="deetabHalfYearly">

							<form:form id="resdeehalfyear" name="resdeehalfyearname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by DEE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId7" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId7" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId7" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId7" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId7" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId7" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId7" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId7" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="5"
									id="dutyFrequencyId7" type="hidden" />


								<c:forEach items="${scheduleDutyHalfYearDee}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<b><c:out value="${n.dutyDisplaySeq}"></c:out>
													<c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyHalfYearDee}" var="k"
											varStatus="ncount">

											<c:if test="${k.parentDutyId == n.dutyId }">

												<div class="row">
													<br></br>
														<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck7  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="deehalfinspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>

											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck7  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="deehalfinspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>

									</c:if>


								</c:forEach>


								<br />
								<button type="button" name="resdeehalfyearly" id="resdeehalfyearlybtn"
								class="btn btn-1 btn-primary center-block schedulebutton">Submit</button>
							</form:form>

							

						</div>


						<div id="deetabYearly">

							<form:form id="resdeeyearly" name="resdeeyearlyname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by DEE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId8" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId8" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId8" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId8" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId8" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId8" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId8" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId8" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="6"
									id="dutyFrequencyId8" type="hidden" />


								<c:forEach items="${scheduleDutyAnnualDee}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<b><c:out value="${n.dutyDisplaySeq}"></c:out>
													<c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyAnnualDee}" var="k"
											varStatus="ncount">

											<c:if test="${k.parentDutyId == n.dutyId }">

												<div class="row">
													<br></br>
														<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck8  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="deeyearinspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>

											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck8  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="deeyearinspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>

									</c:if>


								</c:forEach>


								<br />
								
								<button type="button" name="resdeeyearly" id="resdeeyearlybtn"
								class="btn btn-1 btn-primary center-block  schedulebutton">Submit</button>
							</form:form>

							

						</div>


						<div id="deetab5years">

							<form:form id="resdee5years" name="resdee5yearsname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by DEE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId9" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId9" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId9" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId9" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId9" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId9" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId9" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId9" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="7"
									id="dutyFrequencyId9" type="hidden" />



								<c:forEach items="${scheduleDutyFiveYearDee}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<b><c:out value="${n.dutyDisplaySeq}"></c:out>
													<c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyFiveYearDee}" var="k"
											varStatus="ncount">

											<c:if test="${k.parentDutyId == n.dutyId }">

												<div class="row">
													<br></br>
														<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck9  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="dee5yearinspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>

											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck9  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="dee5yearinspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>

									</c:if>


								</c:forEach>


								<br />
								<button type="button" name="resdee5years" id="resdee5yearsbtn"
								class="btn btn-1 btn-primary center-block schedulebutton">Submit</button>
							</form:form>

							

						</div>




					</div>
					<!-- tabs -->


				</div>
				<!-- col-md-8 div Dee -->

				<div id="Eetabs" class="col-md-12 ">




					<div id="tabs3">
						<ul>



							<li><a href="#eetabMonMonsoon" onclick="getcheckfalse10()">Monthly During Monsoon</a></li>
							<li><a href="#eetabMon" onclick="getcheckfalse11()">Monthly</a></li>
							<li><a href="#eetabQuarter" onclick="getcheckfalse12()">Quarterly</a></li>







						</ul>
						<!-- tabs -->



						<div id="eetabMonMonsoon">

							<form:form id="reseemonsoon" name="reseemonsoonname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by EE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId10" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId10" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId10" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId10" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId10" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId10" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId10" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId10" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="8"
									id="dutyFrequencyId10" type="hidden" />


								<c:forEach items="${scheduleDutyMonSoonEE}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<c:out value="${n.dutyDisplaySeq}"></c:out>
												<b><c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyMonSoonEE}" var="k"
											varStatus="ncount">

											<c:if test="${k.parentDutyId==n.dutyId }">



												<div class="row">
													<br></br>
														<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck10  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="eemonsooninspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck10  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="eemonsooninspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>


									</c:if>


								</c:forEach>



								<br />
								
								<button type="button" name="reseemonsoon" id="reseemonsoonbtn"
								class="btn btn-1 btn-primary center-block schedulebutton">Submit</button>
							</form:form>

							

						</div>


						<div id="eetabMon">

							<form:form id="reseemon" name="reseemonname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by EE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId11" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId11" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId11" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId11" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId11" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId11" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId11" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId11" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="3"
									id="dutyFrequencyId11" type="hidden" />


								<c:forEach items="${scheduleDutyMonthlyEE}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<c:out value="${n.dutyDisplaySeq}"></c:out>
												<b><c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyMonthlyEE}" var="k"
											varStatus="ncount">

											<c:if test="${k.parentDutyId==n.dutyId }">



												<div class="row">
													<br></br>
														<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck11  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="eemoninspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck11  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="eemoninspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>


									</c:if>


								</c:forEach>



								<br />
							</form:form>

							<button type="button" name="reseemon" id="reseemonbtn"
								class="btn btn-1 btn-primary center-block schedulebutton">Submit</button>

						</div>

						<div id="eetabQuarter">

							<form:form id="reseequarter" name="reseequartername"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by EE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId12" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId12" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId12" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId12" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId12" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId12" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId12" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId12" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="4"
									id="dutyFrequencyId12" type="hidden" />



								<c:forEach items="${scheduleDutyQuarterlyEE}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<b><c:out value="${n.dutyDisplaySeq}"></c:out>
													<c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyQuarterlyEE}" var="k"
											varStatus="ncount">

											<c:if test="${k.parentDutyId == n.dutyId }">

												<div class="row">
													<br></br>
														<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck12  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="eequarinspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>

											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck12  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="eequarinspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>

									</c:if>


								</c:forEach>


								<br />
								<button type="button" name="reseequarter" id="reseequarterbtn"
								class="btn btn-1 btn-primary center-block  schedulebutton">Submit</button>
							</form:form>

							

						</div>



					</div>
					<!-- tabs -->


				</div>
				<!-- col-md-8 div Ee -->

				<div id="Setabs" class="col-md-12 ">




					<div id="tabs4">
						<ul>




							<li><a href="#Setab5Years" onclick="getcheckfalse13()">Every 5 Years</a></li>








						</ul>
						<!-- tabs -->





						<div id="Setab5Years">

						<form:form id="resse5year" name="resse5yearname"
								modelAttribute="schedulecheckList" method="post"
								data-parsley-validate-if-empty="">

								<div class="col-md-12 invDiv">

									<label class="label-control rowlebel " for="parameter1">
										Schedule of Duties by SE </label>
								</div>


                       <input name="resScheduleDutyList[0].unitId" value="0"
									id="resunitId13" type="hidden" />
								<input name="resScheduleDutyList[0].circleId" value="0"
									id="rescircleId13" type="hidden" />
								<input name="resScheduleDutyList[0].divisionId" value="0"
									id="resdivisionId13" type="hidden" />
								<input name="resScheduleDutyList[0].subdivisionId" value="0"
									id="ressubdivisionId13" type="hidden" />
								<input name="resScheduleDutyList[0].projectId" value="0"
									id="resprojectId13" type="hidden" />
								<input name="resScheduleDutyList[0].reservoirId" value="0"
									id="resreservoirId13" type="hidden" />
								<input name="resScheduleDutyList[0].designationId" value="0"
									id="resdesignationId13" type="hidden" />
								<input name="resScheduleDutyList[0].resCode" value="0"
									id="resresCodeId13" type="hidden" />
									
									<input name="resScheduleDutyList[0].dutyFrequencyId" value="4"
									id="dutyFrequencyId13" type="hidden" />



								<c:forEach items="${scheduleDutyFiveYearSE}" var="n"
									varStatus="ncount">



									<c:if test="${n.parentHasChild==true  }">

										<div class="col-md-12 invDiv" style="color: maroon;">
											<h3>
												<c:out value="${n.dutyDisplaySeq}"></c:out>
												<b><c:out value="${n.dutyName}"></c:out></b>
											</h3>
										</div>

										<c:forEach items="${scheduleDutyFiveYearSE}" var="k"
											varStatus="ncount">

											<c:if test="${k.parentDutyId==n.dutyId }">



												<div class="row">
													<br></br>
														<div class="col-md-1">${k.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${kcount.count}].scheduleCheckboxId"
													class="schedulecuscheck13  rescuscheck" value="0"
													id="scheduleCheckboxId${kcount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${k.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${kcount.count}].dutyId"
													value="${k.dutyId}" id="dutyId${kcount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].parentDutyId"
													value="${k.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${kcount.count}"
													name="resScheduleDutyList[${kcount.count}].dutyDesignationMapId"
													value="${k.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="se5yearinspectDate${kcount.count}"
															name="resScheduleDutyList[${kcount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${kcount.count}].actionId" id="actionId${kcount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${kcount.count}" name="resScheduleDutyList[${kcount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${kcount.count}" name="resScheduleDutyList[${kcount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${n.parentDutyId==0 && n.parentHasChild==false }">

										<div class="row" style="color: blue;">
											<br></br>
											<div class="col-md-1">${n.dutyDisplaySeq}</div>
													  <div class="col-md-1">
                       <input
													name="resScheduleDutyList[${ncount.count}].scheduleCheckboxId"
													class="schedulecuscheck13  rescuscheck" value="0"
													id="scheduleCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
													<div class="col-md-2 invDiv">

														<label class="label-control rowlebel " for="parameter1">
															${n.dutyName}</label>
															
														<input
													name="resScheduleDutyList[${ncount.count}].dutyId"
													value="${n.dutyId}" id="dutyId${ncount.count}"
													type="hidden" />
													 <input type="hidden" class="form-control"
													id="parentDutyId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].parentDutyId"
													value="${n.parentDutyId}" />
													
													 <input type="hidden" class="form-control"
													id="dutyDesignationMapId${ncount.count}"
													name="resScheduleDutyList[${ncount.count}].dutyDesignationMapId"
													value="${n.dutyDesignationMapId}" />
													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Select
															Date: <font color=red>*</font>
														</label> <input type="text"
															class=" datepick form-control datepicker"
															id="se5yearinspectDate${ncount.count}"
															name="resScheduleDutyList[${ncount.count}].inspectDate"
															placeholder="dateofoperation" />
													</div>

													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required :<font color=red>*</font>
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" checked="checked"
															value="false" >NO
														</label> <label class="radio-inline"> <input type="radio"
															name="resScheduleDutyList[${ncount.count}].actionId" id="actionId${ncount.count}" value="true" >Yes
														</label>


													</div>


													<div class="col-md-2">
														<label class="label-controlPMS rowlebel ">Action
															Required Type:<font color=red>*</font>
														</label> <select class="form-control" id="actionReqId${ncount.count}" name="resScheduleDutyList[${ncount.count}].actionReqId"
															>
															<option value=" ">--select--</option>
							<option value="1">Observation</option>
							<option value="2">Emergency</option>
							<option value="3">Deferred</option>
							<option value="4">Original Work</option>



														</select>
													</div>

													<div class="col-md-2">


														<textarea class="form-control" id="remarks${ncount.count}" name="resScheduleDutyList[${ncount.count}].remarks"
															rows="3" cols="50" placeholder="Observations"></textarea>
													</div>
										</div>


									</c:if>


								</c:forEach>



								<br />
								<button type="button" name="resse" id="ressebtn"
								class="btn btn-1 btn-primary center-block schedulebutton ">Submit</button>
							</form:form>

							

						</div>



					</div>
					<!-- tabs -->


				</div>
				<!-- col-md-8 div Se -->


			</div>
			<!-- panel body div -->

		</div>
		<!-- panel div -->


	</div>
	<!-- row div -->

</div>

<!-- container ends -->




<!--  dilogue starts -->




<!-- </div> -->
<!-- //main-content -->

	<script type="text/javascript">
	
	function getcheckfalse1(){	
		$('.schedulecuscheck2').prop('checked', false);
		
		$('.schedulebutton').hide();
		$('#action_alert').empty();
		
	}

	function getcheckfalse2(){	
$('.schedulecuscheck1').prop('checked', false);		
$('.schedulebutton').hide();
		$('#action_alert').empty();
		
	}


	function getcheckfalse3(){	
$('.schedulecuscheck4').prop('checked', false);
		
$('.schedulebutton').hide();
		$('#action_alert').empty();		
	}

	function getcheckfalse4(){	
$('.schedulecuscheck3').prop('checked', false);
		
$('.schedulebutton').hide();
		$('#action_alert').empty();				
	}
	
	function getcheckfalse5(){	
		$('.schedulecuscheck6').prop('checked', false);
		$('.schedulecuscheck7').prop('checked', false);
		$('.schedulecuscheck8').prop('checked', false);
		$('.schedulecuscheck9').prop('checked', false);
				
		$('.schedulebutton').hide();
				$('#action_alert').empty();				
			}
	
	function getcheckfalse6(){	
		$('.schedulecuscheck5').prop('checked', false);
		$('.schedulecuscheck7').prop('checked', false);
		$('.schedulecuscheck8').prop('checked', false);
		$('.schedulecuscheck9').prop('checked', false);
				
		$('.schedulebutton').hide();
				$('#action_alert').empty();				
		
	}
	

	function getcheckfalse7(){	
		$('.schedulecuscheck5').prop('checked', false);
		$('.schedulecuscheck6').prop('checked', false);
		$('.schedulecuscheck8').prop('checked', false);
		$('.schedulecuscheck9').prop('checked', false);
				
		$('.schedulebutton').hide();
				$('#action_alert').empty();				
			}
	
	function getcheckfalse8(){	
		$('.schedulecuscheck5').prop('checked', false);
		$('.schedulecuscheck6').prop('checked', false);
		$('.schedulecuscheck7').prop('checked', false);
		$('.schedulecuscheck9').prop('checked', false);
				
		$('.schedulebutton').hide();
				
				$('#action_alert').empty();				
			}
	
	function getcheckfalse9(){	
		$('.schedulecuscheck5').prop('checked', false);
		$('.schedulecuscheck6').prop('checked', false);
		$('.schedulecuscheck7').prop('checked', false);
		$('.schedulecuscheck8').prop('checked', false);
				
				$('.schedulebutton').hide();
				$('#action_alert').empty();				
			}

	function getcheckfalse10(){	
		$('.schedulecuscheck11').prop('checked', false);
		$('.schedulecuscheck12').prop('checked', false);
		
				
				$('.schedulebutton').hide();
				$('#action_alert').empty();				
			}
	
	function getcheckfalse11(){	
		$('.schedulecuscheck10').prop('checked', false);
		$('.schedulecuscheck12').prop('checked', false);
		
				
				$('.schedulebutton').hide();
				$('#action_alert').empty();				
			}
	function getcheckfalse12(){	
		$('.schedulecuscheck10').prop('checked', false);
		$('.schedulecuscheck11').prop('checked', false);
		
				
				$('.schedulebutton').hide();
				$('#action_alert').empty();				
			}


	
	
	</script>
	

<script type="text/javascript">
	$(function() {
		
		

		$('.schedulebutton').hide();

		$('.rescuscheck')
				.click(
						function() {
					
	                 	var checkname =  $(this).prop('class');
	                 	
	                 	var cnamesplit = checkname.split(" ");
	                 	var checkclass1 = cnamesplit[0];
	                 	var checkclass2 = cnamesplit[1];
	                 	
	                 //	alert("i am here"+checkclass1);
	                 	
	                 	//  var subStrcheck = checkid.substring(12, checkid.length);
	                 	
	                 		                 	
	           
	
	                 	
						
  if(checkclass1.length!=null){
							var checkid = $(this).prop('id');
							
							//alert("check"+checkid);

							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == true) {
								$(this).val(1);

							}
							//class=mycustomcheck
							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == false) {
								$(this).val(0);

							}
							//   alert( "uncome"); 
                          var classname="."+checkclass1+":checked";
                          
                        //  alert("classname"+classname);
                          
                          
							//var numberNotChecked = $('input:checkbox[class=' + classname + ']:not(":checked")').length;
							var numberOfChecked = $(classname).length
								
								//$('input:checkbox:checked').length;

							//  alert( "un"+numberNotChecked);
						 //  alert("mat"+numberOfChecked);

						 // alert( "diff"+(numberOfChecked-numberNotChecked) );

							if ((numberOfChecked) >= 1) {
								$('.schedulebutton').show();
							} else {

								$('.schedulebutton').hide();
							}
							
  }				
							
 
						});
		

		
		/* 
		 $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
		 $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
		 */

		$("#unitId").change(function() {
			var id = $(this).val();

			
			for(var i=1 ;i <=13 ;i++){
				
		    $('#resunitId'+i).val(id);	
			}
			
			

		});

		$("#circleId").change(function() {
			var id = $(this).val();
			for(var i=1 ;i <=13 ;i++){
				
				$('#rescircleId'+i).val(id);
				}
				
			

		});

		$("#divisionId").change(function() {
			var id = $(this).val();
			
         for(var i=1 ;i <=13 ;i++){
				
	$('#resdivisionId'+i).val(id);
				}

			

		});

		$("#subdivisionId").change(function() {
			var id = $(this).val();
			
			for(var i=1 ;i <=13 ;i++){
				
				$('#ressubdivisionId'+i).val(id);
							}

			

		});

		$("#projectId").change(function() {
			var id = $(this).val();
			
for(var i=1 ;i <=13 ;i++){
				
				$('#resprojectId'+i).val(id);
							}

			

		});

		$("#reservoirId").change(function() {
			var id = $(this).val();
			
			
			
			
for(var i=1 ;i <=13 ;i++){
				
				$('#resresCodeId'+i).val(id);
							}

			
		});

		$("#year").change(function() {
			var id = $(this).val();
for(var i=1 ;i <=13 ;i++){
				
	$('#year'+i).val(id);
							}

			

			

		});

		$("#designationId").change(function() {
			
			
			var id = $(this).val();
			
for(var i=1 ;i <=13 ;i++){
				
	$('#resdesignationId'+i).val(id);
							}

			

			

		});

		$('.schedulebutton')
				.click(
						function(e) {

							var formname = this.form.name;
							//	var getformname=$(formname).prop('form');
							var buttonid = $(this).prop('id');

						//	alert("buttonid" + buttonid);

						//	alert("formname" + formname);

							alert("kal1");

							// alert("kal1");
							// var n= $('#addayacutinfo').text() ;

							// alert("text"+n);

							$('#action_alert').empty();

							e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===

							//alert("kal1");

							// var fname="form[name="+""+formname+"]";

							//alert("fname"+fname);
							/* 	if(buttonid=='addmichecks1'){ */
								if ($('form[name=mainformname]').parsley().isValid()) {  
									
									alert("kal2");
							if ($('form[name=' + formname + ']').parsley()
									.isValid()) {

								/*  
								   if($('.mycustomcheck').val()!=null){
								   	
								   	  if($('.mycustomcheck').val()==1){ */

								//alert("kal3");

								$
										.ajax({
											url : "../invtsimis/addResdamdutyinspect",
											method : "POST",
											async : false,
											data : $(
													'form[name=' + formname
															+ ']').serialize(),

											success : function(response) {

												//alert("kal"+response);

												if (response != 0) {

													// $('#ayacut-dailogue').dialog('close'); 

													$('#action_alert')
															.html(
																	'<p style="margin: 0px !important;">Data Updated Successfully</p>');
												}
												if (response == 0) {

													$('#action_alert')
															.html(
																	'<p style="margin: 0px !important;">Failed to Update data</p>');
												}

												//getResRegAyacutByResCode(response);

												//  alert(finYear);

												//  $('#action_alert').dialog('open'); 

												// getunitData(unitId,circleId,divisionId) ;

											},

											error : function() {
												alert(error);

											}

										});

								/* 	  }
								  } */
								/*  }  */

							}
							}else {
								
								$('form[name=mainformname]').parsley().validate();
								alert("kal4");
							}

						});

	});
</script>


<script type="text/javascript" src="../js/parsley.js"></script>

<script type="text/javascript">
function getProjects(unitId,hkey) {

	var unitId = unitId ;
		
		//$('#unitId').val();

	//  alert("procId"+procId);
	
	if(hkey==1){
	$('#projectId').multiselect('rebuild');
}
	
	if(hkey==2){
	$('#dipackprojectId').multiselect('rebuild');
	}

	$.ajax({
		url : "../web/getProjects?unitId=" + unitId,
		type : "GET",
		success : function(response) {
			
			if(hkey==1){
			var $select = $('#projectId');
			
			var selectedprojectId=$('#hiddenprojectId').val();
			}
			if(hkey==2){
				var $select = $('#dipackprojectId');
				}
			$select.find('option').remove();

			var obj = JSON.parse(response);

			if(hkey==1){
			$('#projectId')
					.append('<option value="0"> --select--</option>');
			}
			
			if(hkey==2){
			$('#dipackprojectId')
			.append('<option value="0"> --select--</option>');
			}

			
			$.each(obj, function(key, value) {
				
				if(hkey==1){
					
					if(selectedprojectId==value.projectId){

				$('#projectId').append(
						'<option value="'+value.projectId+'"selected="selected"> '
								+ value.projectName + '</option>');
					}
					
					if(selectedprojectId==null || selectedprojectId!=value.projectId){

						$('#projectId').append(
								'<option value="'+value.projectId+'"> '
										+ value.projectName + '</option>');
							}

				$('#projectId').multiselect('rebuild')
				}
				if(hkey==2){
				$('#dipackprojectId').append(
						'<option value="'+value.projectId+'"> '
								+ value.projectName + '</option>');

				$('#dipackprojectId').multiselect('rebuild')
				}

				/* 	$(this).removeAttr('selected').prop('selected', false);
				  
				  if($('li').hasClass('active')){
				  	if($('input').prop('checked', true)){
				  		
				  		 $('input').prop('checked', false);
				  		
				  	var spantext=	$("span.multiselect-selected-text").text();
				  	$("span.multiselect-selected-text").text('None Selected')
				  		
				  		
				  	}
				  	$('li').removeClass('active');
				     
				  } */

			});
		},
		error : function() {
			alert(error);
		}
	});
}

function getPackages(projectId) {

	var projectId =projectId ;
		
		//$('#projectId').val();

	//  alert("procId"+procId);
	$('#packageId').multiselect('rebuild');

	$.ajax({
		url : "../web/getPackages?projectId=" + projectId,
		type : "GET",
		success : function(response) {
			var $select = $('#packageId');
			$select.find('option').remove();
			
			var selectedpackageId=$('#hiddenpackageId').val();

			var obj = JSON.parse(response);

			$('#packageId')
					.append('<option value="0"> --select--</option>');

			$.each(obj, function(key, value) {
				
				if(selectedpackageId==value.pkgId){

				$('#packageId').append(
						'<option value="'+value.pkgId+'" selected="selected"> ' + value.pkgName
								+ '</option>');
				}
				if(selectedpackageId==null || selectedpackageId!=value.pkgId){
					$('#packageId').append(
							'<option value="'+value.pkgId+'"> ' + value.pkgName
									+ '</option>');
					
				}

				$('#packageId').multiselect('rebuild')

				/* 	$(this).removeAttr('selected').prop('selected', false);
				  
				  if($('li').hasClass('active')){
				  	if($('input').prop('checked', true)){
				  		
				  		 $('input').prop('checked', false);
				  		
				  	var spantext=	$("span.multiselect-selected-text").text();
				  	$("span.multiselect-selected-text").text('None Selected')
				  		
				  		
				  	}
				  	$('li').removeClass('active');
				     
				  } */

			});
		},
		error : function() {
			alert(error);
		}
	});
}

function getCircles(unitId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var unitId = unitId ;
		//document.getElementById("unitId").value;
	//alert(mandalId);

	$
			.ajax({
				url : "../web/getCircles?unitId=" + unitId,
				type : "GET",
				success : function(response) {
                    if(hkey==1){
					var $select = $('#circleId');
					
					var selectedCircleId= $('#hiddencircleId').val();
					
					//alert("selectedCircleId"+selectedCircleId);
                    }
                    if(hkey==2){
                    	
                    	var $select = $('#dipackcircleId');
                    }
					$select.find('option').remove();

					var obj = JSON.parse(response);
					
					if(hkey==1){
					$('#circleId').append(
							'<option value="0"> --select--</option>');
					}
					if(hkey==2){
					$('#dipackcircleId').append(
					'<option value="0"> --select--</option>');
			}

					$.each(obj, function(key, value) {
						if(hkey==1){
							
	if(selectedCircleId==value.circleId){	
	  							
	  							/* $('#projectId').val(value.projectId);
	  							$('#projectName').val(value.projectName); */
	  						
	  					$('#circleId').append( '<option value="'+value.circleId+'" selected="selected"> '+value.circleName+'</option>' );
	  					
	  						}
	  						
	  					 if(selectedCircleId==null||selectedCircleId!=value.circleId){
	  							$('#circleId').append( '<option value="'+value.circleId+'"> '+value.circleName+'</option>' );	
	  						
	  						} 
							
						

						$('#circleId').multiselect('rebuild');
						
						}
						if(hkey==2){
							$('#dipackcircleId').append(
									'<option value="'+value.circleId+'" > '
											+ value.circleName + '</option>');

							$('#dipackcircleId').multiselect('rebuild');
							
							}
					});

				},
				error : function() {
					alert(error);
				}
			});
}

function getDivisions(circleId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId =circleId ;
		//document.getElementById("circleId").value;
	//alert(mandalId);

	$.ajax({
		url : "../web/getDivisions?circleId=" + circleId,
		type : "GET",
		success : function(response) {
			if(hkey==1){
			var $select = $('#divisionId');
			
			var selecteddivisionId= $('#hiddendivisionId').val();
			}
			if(hkey==2){
				var $select = $('#dipackdivisionId');
				}

			$select.find('option').remove();

			var obj = JSON.parse(response);
			
			if(hkey==1){
			$('#divisionId').append(
					'<option value="0"> --select--</option>');
			}
			if(hkey==2){
			$('#dipackdivisionId').append(
			'<option value="0"> --select--</option>');
			}

			$.each(obj, function(key, value) {
				if(hkey==1){
					if(selecteddivisionId==value.divisionId){
				$('#divisionId').append(
						'<option value="'+value.divisionId+'" selected="selected"> '
								+ value.divisionName + '</option>');
					}
					
					 if(selecteddivisionId==null||selecteddivisionId!=value.divisionId){
						 
							$('#divisionId').append(
									'<option value="'+value.divisionId+'"> '
											+ value.divisionName + '</option>');
						 
					 }

				$('#divisionId').multiselect('rebuild');
				}
				if(hkey==2){
					$('#dipackdivisionId').append(
							'<option value="'+value.divisionId+'" > '
									+ value.divisionName + '</option>');

					$('#dipackdivisionId').multiselect('rebuild');
					}
			});

		},
		error : function() {
			alert(error);
		}
	});
}



function getSubDivisions(divisionId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var divisionId = divisionId ;
		
		//document.getElementById("divisionId").value;
	//alert(mandalId);

	$.ajax({
		url : "../web/getSubDivisions?divisionId=" + divisionId,
		type : "GET",
		success : function(response) {
			if(hkey==1){
			var $select = $('#subdivisionId');
			
			var selectedsubdivisionId= $('#hiddensubdivisionId').val();
			//alert("selectedsubdivisionId"+selectedsubdivisionId);
			}
			/* if(hkey==2){
				var $select = $('#subdivisionId');	
				
			} */
			$select.find('option').remove();

			var obj = JSON.parse(response);
			
		
			$('#subdivisionId').append(
					'<option value="0"> --select--</option>');
			

			$.each(obj, function(key, value) {

				if(selectedsubdivisionId==value.subdivisionId){
				$('#subdivisionId').append(
						'<option value="'+value.subdivisionId+'" selected="selected" > '
								+ value.subdivisionName + '</option>');
				}
				if(selectedsubdivisionId==null || selectedsubdivisionId!=value.subdivisionId){
					$('#subdivisionId').append(
							'<option value="'+value.subdivisionId+'" > '
									+ value.subdivisionName + '</option>');
					}

				$('#subdivisionId').multiselect('rebuild');
			});

		},
		error : function() {
			alert(error);
		}
	});
}



function getReservoirs(projectId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	//var projectId = projectId ;
		
		//document.getElementById("divisionId").value;
	//alert(mandalId);

	$.ajax({
		url : "../invtsimis/getResList?projectId=" + projectId,
		type : "GET",
		success : function(response) {
			if(hkey==1){
			var $select = $('#reservoirId');
			
			$select.find('option').remove();
			
		
			//alert("selectedsubdivisionId"+selectedsubdivisionId);
			}
			
		/* 	var selectedreservoirId=null ; */// $('#hiddenrservoirId').val();
			/* if(hkey==2){
				var $select = $('#subdivisionId');	
				
			} */
			//alert(response);

			var obj = JSON.parse(response);
			
		
			$('#reservoirId').append(
					'<option value="0"> --select--</option>');
			

			$.each(obj, function(key, value) {
				
				$('#reservoirId').append(
						'<option value="'+value.resCode+'" > '
								+ value.resName + '</option>');

				/* if(selectedreservoirId==value.reservoirId){
				$('#reservoirId').append(
						'<option value="'+value.resCode+'" selected="selected" > '
								+ value.resName + '</option>');
				}
				if(selectedreservoirId==null || selectedreservoirId!=value.reservoirId){
				
					} */

				$('#reservoirId').multiselect('rebuild');
			});

		},
		error : function() {
			alert(error);
		}
	});
}
</script>




