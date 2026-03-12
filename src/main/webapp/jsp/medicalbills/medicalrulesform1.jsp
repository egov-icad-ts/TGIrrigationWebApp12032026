

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
							href="#tab1-content">Add Hospital</a> <a
							class="breadcrumb__step" href="#tab2-content">Add Go's
							</a> <a class="breadcrumb__step" href="#tab3-content">Add Office Location
							</a> <a class="breadcrumb__step" href="#tab4-content">Add Rules
							</a> 
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
							

							<div class="col-md-12 invDiv" id="EmpInfo">



								<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Hospital Info
											. </strong> <br>


									</div>
								</div>
								<div class="col-md-12">
									<div  class="col-md-4"> </div>
										<div class="col-md-4">



											<input name="tankId" value="" readonly="readonly"
												class=" form-control " id="tankId" type="hidden" /> <label
												class="label-control rowlebel ">Hospital Name: <font
												color=red>*</font>
											</label> <input id="tankdata" value="" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />
										</div>
									</div>

                       <div class="col-md-12">

									<div  class="col-md-4"> </div>
										<div class="col-md-4">
											<label class="label-control rowlebel ">Location

											</label> <input id="mandata" value="" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />

										</div>
									</div>
   <div class="col-md-12">
<div  class="col-md-4"> </div>
								
										<div class="col-md-4">
											<label class="label-control rowlebel ">Hospital Recognized Go: </label> <input
												id="villdata" value="" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />

										</div>

									</div>
									
								   <div class="col-md-12">
								   
								   	<div class="col-md-4"></div>
										<div class="col-md-4">
											<label class="label-control rowlebel ">Hospital Type</label> <input
												id="villdata" value="Recognized/Un Recognized" readonly="readonly"
												style="color: blue; font-weight: bold;"
												class=" form-control " type="text" />

										</div>

									</div>
								
								
								<div class="col-md-12">
								
								<br>
								<br>

							<div class="col-md-4"></div>

							<div class="col-md-4">

								<button type="button" name="shaddres" id="shaddresinflocn"
									class="btn btn-1 btn-primary center-block ">Submit</button>

							</div>

							<div class="col-md-4"></div>

						</div>
								

								<br> <br>
								

								

							</div>


							


						</form:form>


					</div>

					<div class="tab-content" id="tab2-content">


						<div class="col-md-12 invDiv">

							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note: Go's Info
										 </strong> <br>


								</div>
							</div>
							
							<div class="col-md-12">
							
							<div class="col-md-4"></div>

							<div class="col-md-4">




								<label class="label-control rowlebel ">GO Name
									: <font color=red>*</font>
								</label> <input id="tankdata" value="" readonly="readonly"
									style="color: blue; font-weight: bold;" class=" form-control "
									type="text" />
							</div>
							
							</div>
							
							<div class="col-md-12">
							
							<br><br>
							
							<div class="col-md-4"></div>

<div class="col-md-4">
									<input id="formPhotosnew"
										name="miTankformDataList[0].uploadPhotos" type="file"
										class="btn-info" value="Upload Documents" multiple="multiple"
										data-parsley-max-file-size="2048"
										data-parsley-fileextension='jpeg,jpg,png' required>

								</div>
								
								</div>
							
							
							<div class="col-md-12">
							
							<br><br>

							<div class="col-md-4"></div>

							<div class="col-md-4">

								<button type="button" name="shaddres" id="shaddresinflocn"
									class="btn btn-1 btn-primary center-block ">Submit</button>

							</div>

							<div class="col-md-4"></div>

						</div>
							

							
							

						</div>



					
						


						


					</div>


					<div class="tab-content" id="tab3-content">

						<div class="col-md-12 invDiv">

							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note: Location of Office
										</strong> <br>


								</div>
							</div>

	<div class="col-md-12">
	
	<div class="col-md-4"></div>
							<div class="col-md-4">

								<label class="label-control rowlebel " for="parameter1">
									Select Unit<font color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">unit1</option>
									<option value="2">unit2</option>
									
								</select>

							</div>
							
							</div>
							
							<div class="col-md-12">
	
	<div class="col-md-4"></div>
							
							<div class="col-md-4">

								<label class="label-control rowlebel " for="parameter1">
									Select circle<font color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">circle1</option>
									<option value="2">circle2</option>
									
								</select>

							</div>
							</div>
							
							<div class="col-md-12">
	
	<div class="col-md-4"></div>
							
							<div class="col-md-4">

								<label class="label-control rowlebel " for="parameter1">
									Select division<font color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">division1</option>
									<option value="2">division2</option>
									
								</select>

							</div>
							
							</div>
							

					<div class="col-md-12">
	
	<div class="col-md-4"></div>		
							<div class="col-md-4">





								<label class="label-control rowlebel ">District <font
									color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">district1</option>
									<option value="2">district2</option>



								</select>
							</div>
							
							</div>
							
							<div class="col-md-12">
	
	<div class="col-md-4"></div>
							
							<div class="col-md-4">





								<label class="label-control rowlebel ">Mandal <font
									color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">mandal1</option>
									<option value="2">mandal2</option>



								</select>
							</div>
							
							</div>
							
							<div class="col-md-12">
	
	<div class="col-md-4"></div>
							
							<div class="col-md-4">





								<label class="label-control rowlebel ">village <font
									color=red>*</font>
								</label> <select class="form-control" id="inspectOfficeId1"
									name="inspectOfficeId" required>
									<option value=" ">--select--</option>
									<option value="1">mandal1</option>
									<option value="2">mandal2</option>



								</select>
							</div>
							
							</div>
<div class="col-md-12">
	
	<div class="col-md-4"></div>

							<div class="col-md-4">

								<label class="label-control rowlebel "> <font color=red>*</font>
								</label>

								<button type="button" name="shaddres" id="shaddresinflocn"
									class="btn btn-1 btn-primary center-block ">Submit
									</button>


							</div>
</div>

						</div>


						


						

						
					</div>


					<div class="tab-content" id="tab4-content">


						<div class="col-md-12 invDiv">

							<div class="row show-grid ">
								<div class="alert alert-info" role="alert">
									<strong style="color: #CA3F22"> Note *: Rules to be applied </strong>


								</div>
							</div>

							

							<div class="col-md-12">

								<button type="button" name="shaddres" id="shaddresinflocn"
									class="btn btn-1 btn-primary center-block ">Submit</button>

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