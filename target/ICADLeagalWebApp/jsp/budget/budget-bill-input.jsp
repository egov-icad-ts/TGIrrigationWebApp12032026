

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
<script type="text/javascript"
	src="../js/jquery-ui-timepicker-addon.min.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>

<script type="text/javascript" src="../js/moment.min.js"></script>

<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" media="screen"
	href="../css/bootstrap-datetimepicker.min.css">



<script type="text/javascript" src="../js/customnew.js"></script>

<script type="text/javascript"
	src="../js/breadcrumb/prefixfree-1.0.7.js"></script>
<script type="text/javascript" src="../js/breadcrumb/modernizr.js"></script>


<link rel="stylesheet" media="screen" href="../css/invom/michecks.css">

<link rel="stylesheet"
	href="../css/Html5DataTable/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href=" ../css/Html5DataTable/buttons.dataTables.min.css" />

<script type="text/javascript">
	$(document).ready(function() {

		$('.tab-content').hide();
		$('#tab1-content').show(); // Show the content of the initially active tab

		// Select breadcrumb steps
		const
		breadcrumbSteps = $('.breadcrumb__step');

		// Add a click event handler to each breadcrumb step
		// Add a click event handler to each breadcrumb step
		breadcrumbSteps.on('click', function() {
			// Get the href attribute which contains the corresponding tab content ID
			const
			tabContentId = $(this).attr('href');

			// Hide all tab contents
			$('.tab-content').hide();

			// Show the content of the corresponding tab
			$(tabContentId).show();

			// Remove the 'breadcrumb__step--active' class from all steps
			$('.breadcrumb__step').removeClass('breadcrumb__step--active');

			// Add the 'breadcrumb__step--active' class to the clicked step
			$(this).addClass('breadcrumb__step--active');
		});

		// Disable all steps except the clicked one

		$('.billstatus').hide();

		$("#statusbillselect").change(function() {
			var id = $(this).val();

			if (id == 1) {
				$('#divcall').show();
				$('#circlecall').hide();
				$('#ceenccall').hide();
			}

			if (id == 2) {
				$('#divcall').hide();
				$('#circlecall').show();
				$('#ceenccall').hide();
			}

			if (id == 3) {
				$('#divcall').hide();
				$('#circlecall').hide();
				$('#ceenccall').show();
			}

		});

	});
</script>



<!-- <div class="w3l-main" id="borderStyle"> -->


<div class="col-md-9">



	<div>



		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">
					Medical Bill Data Entry.

					<c:if test="${userObj!=null}">
						<div class="span6 pull-right">

							Welcome to

							<c:if
								test="${userObj.employeeName!=null && userObj.employeeName!='NA'  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>

							</c:if>

							<c:if
								test="${userObj.designationName!=null && userObj.designationName!='NA'  }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>

							</c:if>
						</div>
						<br></br>
						<div class="span6 pull-right">

							<c:if
								test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">
								<c:if test="${userObj.unitId>0  }">
									<c:out value="${userObj.unitName}"></c:out>
								</c:if>
							</c:if>

							<c:if
								test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">
								<c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">
									<c:out value="${userObj.circleName}"></c:out>
								</c:if>
							</c:if>

							<c:if
								test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId==0  }">
								<c:if
									test="${userObj.unitId>0  &&  userObj.circleId>0  &&  userObj.divisionId>0 }">
									<c:out value="${userObj.divisionName}"></c:out>
								</c:if>
							</c:if>

							<c:if
								test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId!=0 }">
								<c:if
									test="${userObj.unitId>0 &&  userObj.circleId>0  &&  userObj.divisionId>0 &&  userObj.subdivisionId>0  }">
									<c:out value="${userObj.subdivisionName}"></c:out>
								</c:if>
							</c:if>

							<c:if
								test="${userObj.unitId==null && userObj.circleId==null && userObj.divisionId==null && userObj.subdivisionId==null }">

								<c:out value="${userObj.userName}"></c:out>

							</c:if>

						</div>
					</c:if>
					&emsp;&emsp;
				</h3>
			</div>


			<div class="panel-body">

				<div class="alert alert-info col-md-12" style="padding: 0px"
					id="action_alert">
					<c:if test="${msg!=null }">
						<c:out value="${msg}"></c:out>
					</c:if>
				</div>

				<!-- <section>
	<h2>Medical Bills Upload</h2>

	<nav>
		<ol class="cd-multi-steps text-center custom-icons">
			<li class="visited"><a href="#0">Employee Info</a></li>
			<li class="visited" ><a href="#0">Bills Upload</a></li>
			<li class="current"><em>Status</em></li>
			<li><em>Review</em></li>
		</ol>
	</nav>
</section> -->


				<div id="result" class="col-md-12 ">


					<div class="breadcrumb">
						<a class="breadcrumb__step breadcrumb__step--active"
							href="#tab1-content">Employee Profile</a> <a
							class="breadcrumb__step" href="#tab2-content">Medical Bill
							Service</a> <a class="breadcrumb__step" href="#tab3-content">Medical
							Bill Claim</a> <a class="breadcrumb__step" href="#tab4-content">Documents
							Upload</a> <a class="breadcrumb__step" href="#tab5-content">Status</a>
					</div>


					&emsp;&emsp;

					<div class="tab-content" id="tab1-content">


						<form:form id="mainformid" name="mainformname"
							modelAttribute="micheckList" method="post"
							data-parsley-validate-if-empty="">

							<input value="${userObj.unitId}" id="userunit" type="hidden" />
							<input value="${userObj.circleId}" id="usercircle" type="hidden" />
							<input value="${userObj.divisionId}" id="userdivision"
								type="hidden" />
							<input value="${userObj.subdivisionId}" id="usersubdivision"
								type="hidden" />
							<input value="${userObj.post}" id="userpost" type="hidden" />


							&emsp; &emsp;
							<div class="col-md-12 invDiv">



								<div class="col-md-12">


									<div class="row show-grid ">
										<div class="alert alert-info" role="alert">
											<strong style="color: #CA3F22"> Note: Check Employee
												Id / PPO Id to proceed further. </strong> <br>


										</div>
									</div>



									<div class="col-md-4">

										<label class="label-control rowlebel "> <font
											color=red>*</font>
										</label>

										<button type="button" name="shaddres" id="shaddresinflocn"
											class="btn btn-1 btn-primary center-block ">
											Register PPO ID</button>


									</div>


									<div class="col-md-4">




										<label class="label-control rowlebel ">Employee Id/
											PPO ID: <font color=red>*</font>
										</label> <input id="tankdata" value="" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text" />
									</div>

									<div class="col-md-4">

										<label class="label-control rowlebel ">Status: <font
											color=red>*</font>
										</label> <input id="tankdata" value="" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text"
											placeholder="Inservice/Retired" />



									</div>







								</div>




							</div>

							<div class="col-md-12 invDiv" id="EmpInfo">



								<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: This
											information is from HRMS. </strong> <br>


									</div>
								</div>
								<div class="col-md-12">
									<div>
										<div class="col-md-4">



											<input name="tankId" value="" readonly="readonly"
												class=" form-control " id="tankId" type="hidden" /> <label
												class="label-control rowlebel ">Name: <font
												color=red>*</font>
											</label> <input id="tankdata" value="" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />
										</div>
									</div>



									<div>
										<div class="col-md-4">
											<label class="label-control rowlebel ">Date Of Birth:

											</label> <input id="mandata" value="" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />

										</div>
									</div>


									<div>
										<div class="col-md-4">
											<label class="label-control rowlebel ">Phone: </label> <input
												id="villdata" value="" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />

										</div>

									</div>
								</div>

								<br> <br>
								<div class="col-md-12">
									<div id="gross">

										<div class="col-md-4">
											<label class="label-control rowlebel " for="parameter1">Office
												Address  </label> <input name="miTankInspectList[0].grossCapacity"
												value="Including District mandal Village" readonly="readonly" class=" form-control "
												id="grossCapacity" type="text" />

										</div>
									</div>
									<div id="geo">

										<div class="col-md-4">
											<label class="label-control rowlebel " for="parameter1">present
												address </label> <input name="miTankInspectList[0].geoTagId"
												value="" readonly="readonly" class=" form-control "
												id="geoTagId" type="text" />

										</div>
									</div>

									<div id="gmainayacut">

										<div class="col-md-4">
											<label class="label-control rowlebel " for="parameter1">Email
											</label> <input name="miTankInspectList[0].grossAyacut" value=""
												readonly="readonly" class=" form-control " id="gayacut"
												type="text" />

										</div>
									</div>
								</div>

								

							</div>


							<div class="col-md-12 invDiv" id="Salaryinfo">

								<div class="col-md-12">

									<div class="row show-grid ">
										<div class="alert alert-info" role="alert">
											<strong style="color: #CA3F22"> Note: Scale & pay
												information </strong> <br>


										</div>
									</div>


									<div class="col-md-2">



										<label class="label-control rowlebel ">Sclale&pay: <font
											color=red>*</font>
										</label> <input id="projectName" value="" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text" />
									</div>

									<div class="col-md-2">
										<label class="label-control rowlebel ">Basic Pay: </label> <input
											id="reservoirName" value="" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text" />

									</div>


									<div class="col-md-2">

										<label class="label-control rowlebel ">DA: </label> <input
											id="reservoirName" value="" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text" />



									</div>

									<div class="col-md-2">

										<label class="label-control rowlebel ">HRA : </label> <input
											id="reservoirName" value="" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text" />



									</div>


									<div class="col-md-2">

										<label class="label-control rowlebel ">Others : </label> <input
											id="reservoirName" value="" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text" />



									</div>

									<div class="col-md-2">

										<label class="label-control rowlebel "> <font
											color=red>*</font>
										</label>

										<button type="button" name="shaddres" id="shaddresinflocn"
											class="btn btn-1 btn-primary center-block ">Add
											scale of pay info</button>


									</div>





								</div>


							</div>

							<!-- start of res display -->










							<div class="col-md-12 invDiv">

								<div class="col-md-12">



									<div id="emp">


										<div class="col-md-3">

											<label class="label-control rowlebel ">DDO /
												Forwarding officer Designation : <font color=red>*</font>
											</label> <input name=nextPostId value="" id="nextPostId"
												type="hidden" /> <select class="form-control"
												id="nextEmpId" name="nextEmpId" required
												onchange="getempId(this.value)">

												<option value=" ">--select--</option>
												<option value=" 1">--EE--</option>
												<option value=" 2">--SE--</option>
												<option value=" 3">--CE--</option>




											</select>


										</div>

										<div class="col-md-3">

											<label class="label-control rowlebel ">Name </label> <input
												id="reservoirName" value="" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />



										</div>

										<div class="col-md-3">

											<label class="label-control rowlebel ">Qualification

											</label> <input id="reservoirName" value="" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />



										</div>
										
										<div class="col-md-3">

										<label class="label-control rowlebel ">Office Details

										</label> <input id="reservoirName" value="Including District Mandal Village" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text" />



									</div>
										
									</div>
								</div>





								







								&emsp;&emsp;



							</div>


							<div class="col-md-12 invDiv" id="familyinfo">

								<div class="col-md-12">

									<div class="row show-grid ">
										<div class="alert alert-info" role="alert">
											<strong style="color: #CA3F22"> Note: Family
												information(Maximum 6(tentative) persons to be added) </strong> <br>


										</div>
									</div>


									<div class="col-md-6">


										<div class="col-md-12">
											<label class="label-control rowlebel ">Dependent1: <font
												color=red>*</font>
											</label> <input id="projectName" value="name age relation" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />
										</div>
										<div class="col-md-12">
											<label class="label-control rowlebel ">Dependent2: <font
												color=red>*</font>
											</label> <input id="projectName" value="name age relation" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />
										</div>
										<div class="col-md-12">
											<label class="label-control rowlebel ">dependent 3: </label>
											<input id="reservoirName" value="name age relation" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />

										</div>

									</div>





									<div class="col-md-6">

										<label class="label-control rowlebel "> <font
											color=red>*</font>
										</label>

										<button type="button" name="shaddres" id="shaddresinflocn"
											class="btn btn-1 btn-primary center-block ">Add
											Dependency</button>


									</div>




								</div>


							</div>


						</form:form>


					</div>

					<div class="tab-content" id="tab2-content">


						<div class="col-md-12 invDiv">

							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note: Bill type
										information </strong> <br>


								</div>
							</div>

							<div class="col-md-4">

								<label class="label-control rowlebel " for="parameter1">
									Medical Bill Type<font color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">Submission of medical reimbursement
										proposal</option>
									<option value="2">Claiming of sanctioned medical bill
										amount</option>


								</select>
							</div>

							<div class="col-md-4">

								<label class="label-control rowlebel " for="parameter1">
									Status<font color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">In- Service</option>
									<option value="2">Retired</option>
									<option value="1">Death-in Service</option>
									<option value="2">Death-after Retd</option>


								</select>
							</div>
							<div class="col-md-4">

								<label class="label-control rowlebel " for="parameter1">
									Type<font color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">Gen</option>
									<option value="2">Class IV</option>


								</select>
							</div>


						</div>



						<div class="col-md-12 invDiv">

							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note: Patient
										information </strong> <br>


								</div>
							</div>

							<div class="col-md-12">
								<div class="col-md-4">

									<label class="label-control rowlebel " for="parameter1">
										Patient Details<font color=red>*</font>
									</label> <select class="form-control" id="inspectOfficeId1"
										name="inspectOfficeId" required>
										<option value=" ">--select--</option>
										<option value="1">In Patient</option>
										<option value="2">Out Patient</option>


									</select>

								</div>
								<div class="col-md-4">

									<label class="label-control rowlebel " for="parameter1">
										Is the Employee and patient same<font color=red>*</font>
									</label> <select class="form-control" id="inspectOfficeId1"
										name="inspectOfficeId" required>
										<option value=" ">--select--</option>
										<option value="1">Yes</option>
										<option value="2">No</option>



									</select>
								</div>


								<div class="col-md-4">

									<label class="label-control rowlebel " for="parameter1">
										Select Dependeant<font color=red>*</font>
									</label> <select class="form-control" id="inspectOfficeId1"
										name="inspectOfficeId" required>
										<option value=" ">--select--</option>
										<option value="1">dependent1</option>
										<option value="2">dependent2</option>
										<option value="1">dependent3</option>
										<option value="2">dependent4</option>



									</select>
								</div>
							</div>





						</div>

						<div class="col-md-12 invDiv">

							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note: Decease
										information </strong> <br>


								</div>
							</div>

							<div class="col-md-3">

								<label class="label-control rowlebel " for="parameter1">
									Select Decease<font color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">Decease1</option>
									<option value="2">Decease2</option>
									<option value="3">Decease3</option>
									<option value="4">Decease4</option>

									<option value="4">Others</option>


								</select>

							</div>

							<div class="col-md-3">




								<label class="label-control rowlebel ">Others (Decease)
									: <font color=red>*</font>
								</label> <input id="tankdata" value="" readonly="readonly"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />
							</div>

							<div class="col-md-3">




								<label class="label-control rowlebel ">Period of
									Treatment from : <font color=red>*</font>
								</label> <input id="tankdata" value="" readonly="readonly"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />
							</div>

							<div class="col-md-3">




								<label class="label-control rowlebel ">Period of
									Treatment to : <font color=red>*</font>
								</label> <input id="tankdata" value="" readonly="readonly"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />
							</div>






						</div>


						<div class="col-md-12">

							<div class="col-md-4"></div>

							<div class="col-md-4">

								<button type="button" name="shaddres" id="shaddresinflocn"
									class="btn btn-1 btn-primary center-block ">Submit</button>

							</div>

							<div class="col-md-4"></div>

						</div>


					</div>


					<div class="tab-content" id="tab3-content">

						<div class="col-md-12 invDiv">

							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note: Hospital
										Information </strong> <br>


								</div>
							</div>


							<div class="col-md-3">

								<label class="label-control rowlebel " for="parameter1">
									Select Hospital<font color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">Hospital1</option>
									<option value="2">Hospital2</option>
									<option value="3">Hospital3</option>
									<option value="4">Hospital4</option>

									<option value="4">Others</option>


								</select>

							</div>

							<div class="col-md-3">





								<label class="label-control rowlebel ">Hospital Address
									: <font color=red>*</font>
								</label> <input id="tankdata" value="" readonly="readonly"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />
							</div>

							<div class="col-md-3">





								<label class="label-control rowlebel ">Hospital Type : <font
									color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">Recognized</option>
									<option value="2">Un recognized</option>



								</select>
							</div>


							<div class="col-md-3">

								<label class="label-control rowlebel "> <font color=red>*</font>
								</label>

								<button type="button" name="shaddres" id="shaddresinflocn"
									class="btn btn-1 btn-primary center-block ">Add
									Hospital</button>


							</div>


						</div>


						<div class="col-md-12 invDiv">

							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note: Amount claim </strong> <br>


								</div>
							</div>

							<div class="col-md-12">

								<div class="col-md-3">





									<label class="label-control rowlebel ">Amount : <font
										color=red>*</font>
									</label> <input id="tankdata" value="" readonly="readonly"
										style="color: blue; font-weight: bold;" class=" form-control "
										type="text" />
								</div>

								<div class="col-md-3">

									<label class="label-control rowlebel ">Spell of claim <font
										color=red>*</font>
									</label> <input id="tankdata" value="" readonly="readonly"
										style="color: blue; font-weight: bold;" class=" form-control "
										type="text" />
								</div>


								<div class="col-md-3">

									<label class="label-control rowlebel ">Date of
										Submission Of proposals <font color=red>*</font>
									</label> <input id="tankdata" value="" readonly="readonly"
										style="color: blue; font-weight: bold;" class=" form-control "
										type="text" />
								</div>

							</div>



						</div>


						<div class="col-md-12">

							<div class="col-md-4"></div>

							<div class="col-md-4">

								<button type="button" name="shaddres" id="shaddresinflocn"
									class="btn btn-1 btn-primary center-block ">Submit</button>

							</div>

							<div class="col-md-4"></div>

						</div>


						<div class="col-md-12 invDiv">

							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note: Display after
										submit Download Documents </strong> <br>


								</div>
							</div>

							<div class="col-md-12">

								<div class="col-md-4">
									<label class="label-control rowlebel "> <font color=red>*</font>
									</label>

									<button type="button" name="shaddres" id="shaddresinflocn"
										class="btn btn-1 btn-primary center-block ">Download
										checklist</button>

									&emsp;&emsp; <br>
									<button type="button" name="shaddres" id="shaddresinflocn"
										class="btn btn-1 btn-primary center-block ">Download
										Appendix-II</button>
										
										&emsp;&emsp; <br>
									<button type="button" name="shaddres" id="shaddresinflocn"
										class="btn btn-1 btn-primary center-block ">Download
										Form-C</button>

									&emsp;&emsp; <br>
									<button type="button" name="shaddres" id="shaddresinflocn"
										class="btn btn-1 btn-primary center-block ">Download
										Hospital Recognition G.O</button>

									&emsp;&emsp; <br>
									<button type="button" name="shaddres" id="shaddresinflocn"
										class="btn btn-1 btn-primary center-block ">Download
										Reference Non-Drawn Certificate</button>
									&emsp;&emsp; <br>
									<button type="button" name="shaddres" id="shaddresinflocn"
										class="btn btn-1 btn-primary center-block ">Download
										Reference Genuine Certificate</button>

								</div>





							</div>



						</div>
					</div>


					<div class="tab-content" id="tab4-content">


						<div class="col-md-12 invDiv">

							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note *: Size of
										uploaded multiple Documents together should not exceed
										2mb(.jpg,.png are allowed) </strong>


								</div>
							</div>

							<div class="col-md-12">

								<div class="col-md-4">

									<label class="label-control rowlebel ">Upload<font
										color=red>*</font></label> <select class="form-control"
										id="inspectOfficeId1" name="inspectOfficeId" required>
										<option value=" ">--select--</option>
										<option value="1">check List</option>
										<option value="2">Appendix-II</option>
										<option value="2">Form-C</option>
										<option value="3">Non Drawn Certificate</option>
										<option value="4">Hospital Recognition G.O</option>
										<option value="5">Emergency Certificate</option>
										<option value="6">Essentiality Certificate</option>
										<option value="7">Discharge Summery</option>
										<option value="8">Original Medical Bills</option>
										<option value="9">Genuine certificate</option>
										<option value="10">Covering Letter</option>
										<option value="11">Letter to DDO</option>



									</select>
								</div>

								<div class="col-md-4">


									<input id="formPhotosnew"
										name="miTankformDataList[0].uploadPhotos" type="file"
										class="btn-info" value="Upload Documents" multiple="multiple"
										data-parsley-max-file-size="2048"
										data-parsley-fileextension='jpeg,jpg,png' required>

								</div>
								<div class="col-md-4"></div>

							</div>

							<div class="col-md-12">

								<button type="button" name="shaddres" id="shaddresinflocn"
									class="btn btn-1 btn-primary center-block ">Submit</button>

							</div>








						</div>

						<div class="col-md-12 invDiv">


							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note *: Display
										Uploaded Documents </strong>


								</div>
							</div>
							<div class="col-md-12">

								<div class="col-md-12">
									<u>Check List</u>
								</div>
								<div class="col-md-12">
									<u>Appendix-II</u>
								</div>
								
								<div class="col-md-12">
									<u>Form-C</u>
								</div>
								<div class="col-md-12">
									<u>Non Drawn Certificate</u>
								</div>
								<div class="col-md-12">
									<u>Hospital Recognition G.O</u>
								</div>
								<div class="col-md-12">
									<u>Emergency Certificate</u>
								</div>
								<div class="col-md-12">
									<u>Emergency Certificate</u>
								</div>
								<div class="col-md-12">
									<u>Essentiality Certificate</u>
								</div>
								<div class="col-md-12">
									<u>Discharge Summery</u>
								</div>
								<div class="col-md-12">
									<u>Original Medical Bills</u>
								</div>
								<div class="col-md-12">
									<u>Genuine certificate</u>
								</div>
								<div class="col-md-12">
									<u>Covering Letter</u>
								</div>
								<div class="col-md-12">
									<u>Letter to DDO</u>
								</div>

							</div>


						</div>




					</div>


					<div class="tab-content" id="tab5-content">

						<div class="col-md-12 invDiv">

							<div class="col-md-12">

								<div class="col-md-4">

									<label class="label-control rowlebel ">Select Medical
										Bill<font color=red>*</font>
									</label> <select class="form-control" id="statusbillselect"
										name="inspectOfficeId" required>
										<option value=" ">--select--</option>
										<option value="1">Bill 1 division</option>
										<option value="2">Bill 2 se</option>
										<option value="3">Bill 3 ce</option>




									</select>
								</div>
							</div>

						</div>
						
                  <div class="col-md-12 invDiv">
						<div class="col-md-12 billstatus" id="divcall">
							<h4>Status bar for Additional claim/ Unrecognized based on
								bill submitted division office</h4>
							<section id="1">
								<nav>
									<ol class="cd-multi-steps text-top">
										<li class="visited"><a href="#div1">Bills Submitted</a></li>
										<li class="current"><a href="#div2">Division Office</a></li>
										<li><a href="#div3">Circle Office</a></li>
										<li><em>Ce/Enc Office</em></li>
										<li><em>Government</em></li>
										<li><em>Sanction / Approve</em></li>
									</ol>
								</nav>
							</section>
							<h4>Status bar for Recognized greater than 50,000 based on
								bill division submitted office</h4>
							<section id="2">
								<nav>
									<ol class="cd-multi-steps text-top">
										<li class="visited"><a href="#div1">Bills Submitted</a></li>
										<li class="current"><a href="#div2">Division Office</a></li>
										<li><a href="#div3">Circle Office</a></li>
										<li><em>Ce/Enc Office</em></li>
										<li><em>Sanction / Approve</em></li>

									</ol>
								</nav>
							</section>

							<h4>Status bar for Recognized less than 50,000 based on bill
								division submitted office</h4>
							<section id="3">
								<nav>
									<ol class="cd-multi-steps text-top">
										<li class="visited"><a href="#div1">Bills Submitted</a></li>
										<li class="current"><a href="#div2">Division Office</a></li>
										<li><em>Sanction / Approve</em></li>

									</ol>
								</nav>
							</section>

							<!-- <div id="div1">

								<label class="label-control rowlebel ">Remarks </label> <input
									id="resreamarksVillageName" value="" name="remarksVillage"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />

							</div> -->
							<div id="div2">

								<label class="label-control rowlebel ">Remarks </label> <input
									id="resreamarksVillageName" value="Pending at hospital /  genuinity certificate " name="remarksVillage"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />

							</div>

							<!-- <div id="div3">

								<label class="label-control rowlebel ">Remarks </label> <input
									id="resreamarksVillageName" value="sanctioned" name="remarksVillage"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />

							</div> -->


						</div>

						<div class="col-md-12 billstatus" id="circlecall">
							<h4>Status bar for Additional claim/ Unrecognized based on
								bill submitted circle office</h4>
							<section id="4">
								<nav>
									<ol class="cd-multi-steps text-top">
										<li class="visited"><a href="#circle1">Bills Submitted</a></li>
										<li class="current"><a href="#circle2">circle Office</a></li>
										<li><em>Ce/Enc Office</em></li>
										<li><em>Government</em></li>
										<li><em>Sanction / Approve</em></li>
									</ol>
								</nav>
							</section>
							<h4>Status bar for Recognized greater than 50,000 based on
								bill circle submitted office</h4>
							<section id="5">
								<nav>
									<ol class="cd-multi-steps text-top">
										<li class="visited"><a href="#circle1">Bills Submitted</a></li>
										<li class="current"><a href="#circle2">Circle Office</a></li>
										<li><em>Ce/Enc Office</em></li>
										<li><em>Sanction / Approve</em></li>

									</ol>
								</nav>
							</section>

							<h4>Status bar for Recognized less than 50,000 based on bill
								circle submitted office</h4>
							<section id="6">
								<nav>
									<ol class="cd-multi-steps text-top">
										<li class="visited"><a href="#circle1">Bills Submitted</a></li>
										<li class="current"><a href="#circle2">Circle Office</a></li>
										<li><em>Sanction / Approve</em></li>

									</ol>
								</nav>
							</section>
							
							<!-- <div id="circle1">

								<label class="label-control rowlebel ">Remarks </label> <input
									id="resreamarksVillageName" value="" name="remarksVillage"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />

							</div> -->
							<div id="circle2">

								<label class="label-control rowlebel ">Remarks </label> <input
									id="resreamarksVillageName" value="Require original medical bills " name="remarksVillage"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />

							</div>

							<!-- <div id="circle3">

								<label class="label-control rowlebel ">Remarks </label> <input
									id="resreamarksVillageName" value="sanctioned" name="remarksVillage"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />

							</div> -->
							

						</div>

						<div class="col-md-12  billstatus" id="ceenccall">
							<h4>Status bar for Additional claim/ Unrecognized based on
								bill submitted CE/ENC office</h4>
							<section id="7">
								<nav>
									<ol class="cd-multi-steps text-top">
										<li class="visited"><a href="#0">Bills Submitted</a></li>
										<li class="current"><a href="#0">CE/ENC Office</a></li>
										<li><em>Government</em></li>
										<li><em>Sanction / Approve</em></li>
									</ol>
								</nav>
							</section>
							<h4>Status bar for Recognized greater than and less than
								50,000 based on bill CE/ENC submitted office</h4>
							<section id="8">
								<nav>
									<ol class="cd-multi-steps text-top">
										<li class="visited"><a href="#ce1">Bills Submitted</a></li>
										<li class="current"><a href="#ce2">CE/ENC Office</a></li>
										<li><em>Sanction / Approve</em></li>

									</ol>
								</nav>
							</section>
							
							<!-- <div id="ce1">

								<label class="label-control rowlebel ">Remarks </label> <input
									id="resreamarksVillageName" value="" name="remarksVillage"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />

							</div> -->
							<div id="ce2">

								<label class="label-control rowlebel ">Remarks </label> <input
									id="resreamarksVillageName" value="send to government " name="remarksVillage"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />

							</div>

							<!-- <div id="ce3">

								<label class="label-control rowlebel ">Remarks </label> <input
									id="resreamarksVillageName" value="sanctioned" name="remarksVillage"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />

							</div> -->


						</div>
						</div>


					</div>











				</div>
				<!-- col-md-8 div -->

			</div>
			<!-- panel div div -->


		</div>
		<!-- panel div -->

		<!-- <div class="row show-grid ">
				<div class="col-md-4">
				</div>
					<div class="col-md-4">
				</div>
				
			<div class="col-md-4" >
									
									<label class="label-controlPMS rowlebel "><b><a id="helpId" href="javascript:void(0)"><strong style="color:#CA3F22">****Click Here For Clarifications</strong></a></b>
										
									</label> 
					 
					
											
									 </div>
							
			</div> -->

	</div>
	<!-- container div -->




	<!-- data ends -->



	<!--  dilogue starts -->


















</div>



<!-- </div> -->
<!-- //main-content -->




































<script type="text/javascript" src="../js/parsley.js"></script>

<script src="../js/Html5DataTable/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script src=" ../js/Html5DataTable/dataTables.buttons.min.js"
	type="text/javascript"></script>
<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>
<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>
<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>
<script src="../js/Html5DataTable/buttons.html5.min.js"
	type="text/javascript"></script>
<script src="../js/Html5DataTable/buttons.print.min.js"
	type="text/javascript"></script>
<script src="../js/Html5DataTable/dataTables.select.min.js"
	type="text/javascript"></script>
<script src="../js/Html5DataTable/buttons.colVis.min.js"
	type="text/javascript"></script>