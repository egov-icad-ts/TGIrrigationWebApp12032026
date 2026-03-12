

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
		$('#subtab1-act').show(); // Show the content of the initially active tab

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

		
		
		
		
		

	});
</script>



<!-- <div class="w3l-main" id="borderStyle"> -->


<div class="col-md-9">



	<div>



		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">
					Medical Bills Forward Data.

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

			

				<div id="result" class="col-md-12 ">


					


					&emsp;&emsp;

					<div class="col-md-12">


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
											<strong style="color: #CA3F22"> Note: Enter Employee
												Id / PPO Id to proceed further. </strong> <br>


										</div>
									</div>



									
<div class="col-md-12">
<div class="col-md-4"></div>

									<div class="col-md-4">




										<label class="label-control rowlebel ">Employee Id/
											PPO ID: <font color=red>*</font>
										</label> <input id="tankdata" value="" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text" />
									</div>

								
</div>

<div class="col-md-12">
<div class="col-md-4"></div>

									<div class="col-md-4">




										<label class="label-control rowlebel ">Select Year <font color=red>*</font>
										</label> <select class="form-control"
												id="nextEmpId" name="nextEmpId" required
												onchange="getempId(this.value)">

												<option value=" ">--select--</option>
												<option value=" 1">--2022--</option>
												<option value=" 2">--2023--</option>
											
											</select>
									</div>

								
</div>

<div class="col-md-12">
<div class="col-md-4"></div>
									<div class="col-md-2">




										<label class="label-control rowlebel ">from Date  <font color=red>*</font>
										</label> <input id="tankdata" value="" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text" />
											
											</div>
											
											<div class="col-md-2">
											
											<label class="label-control rowlebel ">to Date  <font color=red>*</font>
										</label> <input id="tankdata" value="" readonly="readonly"
											style="color: blue; font-weight: bold;"
											class=" form-control " type="text" />
											
											</div>
									

								
</div>

<div class="col-md-12">
<div class="col-md-4"></div>

									<div class="col-md-4">




										<label class="label-control rowlebel ">Select Office <font color=red>*</font>
										</label> <select class="form-control"
												id="nextEmpId" name="nextEmpId" required
												onchange="getempId(this.value)">

												<option value=" ">--select--</option>
												<option value=" 1">--EE1--</option>
												<option value=" 2">--EE2--</option>
											
											</select>
									</div>

								
</div>

<div class="col-md-12">
<div class="col-md-4"></div>

									<div class="col-md-4">




										<label class="label-control rowlebel ">Medical Bill Type <font color=red>*</font>
										</label> <select class="form-control"
												id="nextEmpId" name="nextEmpId" required
												onchange="getempId(this.value)">

												<option value=" ">--select--</option>
												<option value=" 1">Medical Bills Submitted</option>
												<option value=" 2">Medical Bills at Government </option>
												<option value=" 2">Medical Bills at approved </option>
											
											</select>
									</div>

								
</div>





								</div>




							</div>

							<div class="col-md-12 invDiv" id="EmpInfo">



								<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Display of Medical Bills. </strong> <br>


									</div>
								</div>
								<div class="col-md-12">
									
										<div class="col-md-4">



											<input name="tankId" value="" readonly="readonly"
												class=" form-control " id="tankId" type="hidden" /> <label
												class="label-control rowlebel ">Bill No 1: <font
												color=red>*</font>
											</label> <input id="tankdata" value="" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />
										</div>
									



									<div class="col-md-4">

										<label class="label-control rowlebel "> <font
											color=red>*</font>
										</label>

										<button type="button" name="shaddres" id="shaddresinflocn"
											class="btn btn-1 btn-primary center-block "> Select Bill1 </button>


									</div>


								</div>
								
								<div class="col-md-12">
									
										<div class="col-md-4">



											<input name="tankId" value="" readonly="readonly"
												class=" form-control " id="tankId" type="hidden" /> <label
												class="label-control rowlebel ">Bill No 2: <font
												color=red>*</font>
											</label> <input id="tankdata" value="" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />
										</div>
									



									<div class="col-md-4">

										<label class="label-control rowlebel "> <font
											color=red>*</font>
										</label>

										<button type="button" name="shaddres" id="shaddresinflocn"
											class="btn btn-1 btn-primary center-block "> Select Bill2 </button>


									</div>


								</div>

								<br> <br>
								

								
									</div>

									


	</form:form>
	
	<div  class="col-md-12 invDiv">
	
	
	<div class="breadcrumb">
						<a class="breadcrumb__step "
							href="#subtab1-emp">Employee Profile</a>
							 <a
							class="breadcrumb__step" href="#subtab1-bill">Medical Bill Info
							</a> 
							<a class="breadcrumb__step" href="#subtab1-docs">Documents
							</a>
							
							<a class="breadcrumb__step  breadcrumb__step--active" href="#subtab1-act">Action
							</a>
							
							<a class="breadcrumb__step  breadcrumb__step--active" href="#subtab1-off-doc">forwarding files
							</a>
							
							<a class="breadcrumb__step  breadcrumb__step--active" href="#subtab1-off-status">Status
							</a>
							
					</div>
	
	<!-- <div class="cd-bread-sub1">
	
	<section>
	

	<nav>
		<ol class="cd-multi-steps text-center custom-icons">
		
			<li class="visited"><a class="cd-bread-sub1_step cd-bread-sub1_step_active" href="#subtab1-emp">Employee Profile</a></li>
			<li class="visited" ><a class="cd-bread-sub1_step " href="#subtab1-bill">Medical Bill Info</a></li>
			<li class="current"><a class="cd-bread-sub1_step" href="#subtab1-docs">Documents</a></li>
			<li ><a class="cd-bread-sub1_step" href="#subtab1-act">Action</a></li>
		
		</ol>
	</nav>
</section>

</div> -->


<div class="tab-content" id="subtab1-emp">

<div class="col-md-12 invDiv">

<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Display Employee Profile </strong> <br>


									</div>
								</div>
								
								<div  class="col-md-12">
								
								<div  class="col-md-6">
								
								<div class="col-md-6"><label
												class="label-control rowlebel ">Employee Name 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Name" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6"><label
												class="label-control rowlebel ">Date of Birth
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Date of Birth" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6"><label
												class="label-control rowlebel ">Phone 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Phone" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6"><label
												class="label-control rowlebel ">Email 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Email" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6 row"><label
												class="label-control rowlebel ">Office Address 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Office address including district mandal village" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6"><label
												class="label-control rowlebel "> Present address 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="present home address" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
										
								
								</div>
								
								<div  class="col-md-6">
								
								
								<div class="col-md-6"><label
												class="label-control rowlebel "> Scale &pay 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Scale" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6"><label
												class="label-control rowlebel "> Basic pay 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="basic pay" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								
								<div class="col-md-6"><label
												class="label-control rowlebel "> Da 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Da" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
						
												
												<div class="col-md-6"><label
												class="label-control rowlebel "> Hra 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="hra" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
												<div class="col-md-6"><label
												class="label-control rowlebel "> Others 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Others" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
												
												
										
								
								</div>
								
								
								</div>



</div>

<div class="col-md-12 invDiv">

<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Display Dependency List </strong> <br>


									</div>
								</div>
								
								<div  class="col-md-12">
								
								<div class="col-md-6"><label
												class="label-control rowlebel "> dependent1 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="dependent1  age relation" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
												<div class="col-md-6"><label
												class="label-control rowlebel "> dependent2 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="dependent2 age relation" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
													<div class="col-md-6"><label
												class="label-control rowlebel "> dependent3
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="dependent3 age relation" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								
								</div>
								</div>
							

</div>

<div  class="tab-content" id="subtab1-bill">

<div class="col-md-12 invDiv">

<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Display Medical bill information </strong> <br>


									</div>
								</div>
								
								<div  class="col-md-12">
								
								<div  class="col-md-6">
								
								<div class="col-md-6"><label
												class="label-control rowlebel ">Medical Bill Type 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Reimbursement proposal" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6"><label
												class="label-control rowlebel ">Status
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="In Service" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6"><label
												class="label-control rowlebel ">Type 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Gen" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6"><label
												class="label-control rowlebel ">Patient Details 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="In/Out patient" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6 row"><label
												class="label-control rowlebel ">Employee and Patient same 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="Yes/No" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6"><label
												class="label-control rowlebel "> Dependent 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="test Name 1" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
										<div class="col-md-6"><label
												class="label-control rowlebel "> Decease Name 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="test decease 1" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								<div class="col-md-6"><label
												class="label-control rowlebel "> Period of treatment from 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="date1 with time" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								
								<div class="col-md-6"><label
												class="label-control rowlebel "> Period of treatment to 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="date2 with time" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								
								</div>
								
								<div  class="col-md-6">
								
						
												
												<div class="col-md-6"><label
												class="label-control rowlebel "> Hospital 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="hospital1" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
												<div class="col-md-6"><label
												class="label-control rowlebel "> Hospital Address 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="hospital1 address" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
												<div class="col-md-6"><label
												class="label-control rowlebel "> Hospital Type 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="hospital1 type" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
												<div class="col-md-6"><label
												class="label-control rowlebel "> Amount claim 
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="amount" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
													<div class="col-md-6"><label
												class="label-control rowlebel "> Spell Claim
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="spell claim" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
												
												<div class="col-md-6"><label
												class="label-control rowlebel "> Date of Proposal
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="date of proposal" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
								
								</div>
								
								
								</div>



</div>

</div>

<div class="tab-content"  id="subtab1-docs">

<div class="col-md-12 invDiv">

<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Display Uploaded documents </strong> <br>


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
									<u>Non Drawn Certificate</u>
								</div>
								<div class="col-md-12">
									<u>Hospital Recognition G.O</u>
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

<div class="tab-content" id="subtab1-act">

<div class="col-md-12 invDiv">

<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Action </strong> <br>


									</div>
								</div>
								
	
	
	<div class="col-md-12">
	
	<div class="col-md-4">




										<label class="label-control rowlebel ">Select Next Level Office <font color=red>*</font>
										</label> <select class="form-control"
												id="nextEmpId" name="nextEmpId" required
												onchange="getempId(this.value)">

												<option value=" ">--select--</option>
												<option value=" 1">Se Office</option>
												<option value=" 2">Ce/Enc Office</option>
												<option value=" 3">Send to Government</option>
												<option value=" 4">Sanction/Approve</option>
												
											
											</select>
											
											</div>
		<div class="col-md-4">




										<label class="label-control rowlebel ">Select Bill status <font color=red>*</font>
										</label> <select class="form-control"
												id="nextEmpId" name="nextEmpId" required
												onchange="getempId(this.value)">

												<option value=" ">--select--</option>
												<option value=" 1">check list forwarded</option>
												<option value=" 2">Non-Drwan Certificate Issued</option>
												<option value=" 3">Spell Claim Certificate Issued</option>
												<option value=" 4">Form-E issued</option>
												<option value=" 5">Under taking letter for reimbursement by forwarding authority</option>
												<option value=" 6">Request Confirmity letter from DME office</option>
												<option value=" 7">Request Genuinity letter from Hospital</option>
											
											</select>
											
											</div>
											
											<div class="col-md-4">




										<label class="label-control rowlebel ">Select current status <font color=red>*</font>
										</label> <select class="form-control"
												id="nextEmpId" name="nextEmpId" required
												onchange="getempId(this.value)">

												<option value=" ">--select--</option>
												<option value=" 1">Pending at Hospital</option>
												<option value=" 2">Pendening at DME office</option>
												<option value=" 3">Pending at Government </option>
												<option value=" 4">Require More Information</option>
												<option value=" 5">Require More Documents</option>
												<option value=" 6">Rejected</option>
												
											
											</select>
											
											</div>
											
											<br>
										<br>
										
									</div>
									
									
										<div class="col-md-12">
										<br>
										<br>
										
										
										<div class="col-md-6"><label
												class="label-control rowlebel "> Remarks to next level office
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="remarks to office" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
										
										</div>
										
										<div class="col-md-12">
										<br>
										<br>
										
										
										<div class="col-md-6"><label
												class="label-control rowlebel "> Remarks to employee
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="remarks to employee" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
										
										</div>
										
										<div class="col-md-12">
										<br>
										<br>
										
										
										<div class="col-md-6"><label
												class="label-control rowlebel "> Name of File (File number)
											</label></div>
								<div class="col-md-6"><input id="tankdata" value="File number with date" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" /></div>
										
										</div>
									<div class="col-md-12">
									<br>
										<br>
										
										
										<div class="col-md-6"><label
												class="label-control rowlebel "> Upload Documents
											</label></div>
								<div class="col-md-6"><input id="formPhotosnew"
										name="miTankformDataList[0].uploadPhotos" type="file"
										class="btn-info" value="Upload Documents" multiple="multiple"
										data-parsley-max-file-size="2048"
										data-parsley-fileextension='jpeg,jpg,png' required></div>
										
										</div>
										
										<div class="col-md-12">
										<br>
										<br>
										

								<button type="button" name="shaddres" id="shaddresinflocn"
									class="btn btn-1 btn-primary center-block ">Submit</button>

							</div>



</div>

</div>


<div class="tab-content"  id="subtab1-off-doc">

<div class="col-md-12 invDiv">

<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Display office Uploaded documents </strong> <br>


									</div>
								</div>
								
								<div class="col-md-12">

								
								<div class="col-md-12">
									<u>Non Drawn Certificate</u>
								</div>
								<div class="col-md-12">
									<u>Spell count certificate</u>
								</div>
								<div class="col-md-12">
									<u>Lr. to Government</u>
								</div>
								
								

							</div>



</div>

</div>



<div class="tab-content"  id="subtab1-off-status">

<div class="col-md-12 invDiv">

<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Status </strong> <br>


									</div>
								</div>
								
								<div class="col-md-12 officebillstatus" id="officedivcall">
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
									id="resreamarksVillageName" value="Lr forwarded for necessary action (remarks to office ) " name="remarksVillage"
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



</div>


</div>



</div>


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


	<!-- container div -->




	<!-- data ends -->



	<!--  dilogue starts -->






















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