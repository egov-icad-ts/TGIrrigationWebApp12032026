<!--Header admin starts here-->

<%@include file="/jsp/header/taglib_includes.jsp"%>

<script type="text/javascript">
	$(".dropdown").hover(function() {
		var dropdownMenu = $(this).children(".dropdown-menu");
		if (dropdownMenu.is(":visible")) {
			dropdownMenu.parent().toggleClass("open");
		}
	});
</script>



<div class="banner-two">
	<div class="header">
		<div class="container">
			<div class="header-main">
				<div class="logo">
					<h1>
						<img src="../img/webimg/telangana.png" alt="" /> PMS
					</h1>
				</div>
				<div class="top-nav">
					<span class="menu"> <img src="../img/webimg/icon.png" alt="" />
					</span>
					<nav class="cl-effect-1" role="navigation">
						<ul class="res ">
							<!--   
					  <li class="dropdown " ><a class="dropdown-toggle" data-toggle="dropdown" href="../pms/service" >Project Info<span class="caret"></span> </a>
						<ul class="dropdown-menu">
						<li><a class="active" href="../pmsUser/projectYearlyUpdates">Project Yearly</a></li>
						<li><a href="../pmsUser/projectMonthlyUpdates">Project Monthly</a></li>
						<li><a href="../pmsUser/projectOnceData">Project Once</a></li>
						<li><a href="../pmsUser/projectData">Project Data</a></li>
						<li><a href="../pmsUser/powerRequirement">Power Required for LIS</a></li>
						
						
											
						</ul>
						</li>  -->

							<li><a class="active" href="../pmsUser/dashBoard">Home</a>
							<li><a href="../pmsUser/canalLineDiagram">Canal Line
									Diagram</a></li>
							<li><a href="../pmsUser/laAdminSancReport">Administrative
									Sanction</a></li>
							<c:if test="${userObj.roleId==13  }">
							<li class="dropdown " ><a class="dropdown-toggle" data-toggle="dropdown" href="#" >Reports<span class="caret"></span> </a>
						
						<ul class="dropdown-menu" style="background-color: #2471a3;">
						
						
						 <li><a href="../pmsReports/acquiredDataReport">Acquired LA Report</a></li>
						
						</ul>
						</li> 
						</c:if>
							<c:if test="${userObj.roleId!=13  }">
								<li class="dropdown "><a class="dropdown-toggle"
									data-toggle="dropdown">Package Info<span class="caret"></span>
								</a>
									<ul class="dropdown-menu" style="background-color: #2471a3;">										
										<c:if
											test="${userObj.designationId==9 || (userObj.circleId==0 && userObj.divisionId==0 && userObj.designationId==5)}">
											<li><a href="../pmsUser/projectAdminSanction">Project
													Admin Sanction</a></li>
											<li><a href="../pmsUser/getSanctionAmountList">Edit
													Admin Sanction</a></li>

											<li><a href="../pmsUser/ceCreatePackge">Create
													Package</a></li>
											<li><a href="../pmsUser/ceEditPackge">Edit Package</a></li>
											<li><a href="../pmsUser/ceEditAssignWork">CE Edit
													Assign Work</a></li>
										</c:if>
									</ul>
									
								<li class="dropdown "><a class="dropdown-toggle"
									data-toggle="dropdown">Proforma Entry<span class="caret"></span>
								</a>
									<ul class="dropdown-menu" style="background-color: #2471a3;">
										<c:if
											test="${userObj.designationId==9 || (userObj.circleId==0 && userObj.divisionId==0 && userObj.designationId==5)}">
											<li><a href="../pmsUser/expenditureDetailsEntry">Expenditure
													Details</a></li>
											<li><a href="../pmsUser/physicalProgressEntry">Physical
													Progress</a></li>

											<li><a href="../pmsUser/rrDetailsEntry">R &amp; R
													Details</a></li>
											<li><a href="../pmsUser/forestLandExpEntry">Forest
													Land Details</a></li>
											<li><a href="../pmsUser/misExpenditureEntry">Miscellaneous
													Expenditure</a></li>

										</c:if>

									</ul></li>


								<li class="dropdown "><a class="dropdown-toggle"
									data-toggle="dropdown">Components Info</a>
									<ul class="dropdown-menu" style="background-color: #2471a3;">

										<c:if test="${userObj.designationId==9}">
											<li><a href="../pmsUser/ceCreateComponent">CE Create
													Component</a></li>
											<li><a href="../pmsUser/ceAssignComponent">CE Assign
													Component</a></li>
										</c:if>


										<c:if test="${userObj.designationId==7}">
											<li><a href="../pmsUser/seCreateCanalComponent">SE
													Create Canal Distributory</a></li>
											<li><a href="../pmsUser/seEditCanalComponent">SE
													Edit Canal Distributory</a></li>

											<li><a href="../pmsUser/seAssignComponent">SE Assign
													Package Component</a></li>
											<li><a href="../pmsUser/seEditAssignComponent">SE
													Edit Assign Package Component</a></li>
										</c:if>
										<c:if
											test="${userObj.designationId==5 || userObj.designationId==114 }">
											<li><a class="active"
												href="../pmsUser/eeAssignComponent">Assign Component</a></li>
											<li><a class="active"
												href="../pmsUser/eeEditAssignComponent">Edit Assign
													Component</a></li>


										</c:if>
									</ul></li>

								<li class="dropdown "><a class="dropdown-toggle"
									data-toggle="dropdown">LA Info<span class="caret"></span>
								</a>
									<ul class="dropdown-menu" style="background-color: #2471a3;">
										<c:if
											test="${userObj.designationId==4 || userObj.designationId==113 }">
											<li><a class="active" href="../pmsUser/deeEnterReq">Enter
													Requisition </a></li>
											<li><a class="active"
												href="../pmsUser/getrevisedDEEReqlist">Edit Requisition
											</a></li>

											<li><a class="active" href="../pmsUser/laStructures">Add
													Structures </a></li>
										</c:if>
										<c:if
											test="${userObj.designationId==5 || userObj.designationId==114 }">
											<li><a class="active" href="../pmsUser/eeCreate">EE
													Create Canal Minor/Subminor</a></li>
											<li><a class="active" href="../pmsUser/eeApproveReq">Approve
													Requisition</a></li>
											<li><a href="../pmsUser/eeSendtoLAO">Send to LAO/LPD</a></li>
											<li><a href="../pmsUser/eePrintReq">Print
													Requisition</a></li>
										</c:if>

									</ul></li>

								<li class="dropdown "><a class="dropdown-toggle"
									data-toggle="dropdown" href="../pms/shortcode">Help</a>
									<ul class="dropdown-menu" style="background-color: #2471a3;">
										<li><a href="../pmsUser/contactus">Contact us</a></li>
									</ul></li>

							</c:if>
							<c:if
								test="${userObj.userName=='sweth220986' || userObj.userName=='41103922' || userObj.userName=='sarad010685'}">
								<li><a href="../pmsUser/contactStatus">Contact Status</a></li>
							</c:if>

							<li><a href="../pmsUser/logout">Logout</a></li>
						</ul>
					</nav>
					<!-- script-for-menu -->
					<script>
						   $( "span.menu" ).click(function() {
							 $( "ul.res" ).slideToggle( 300, function() {
							 // Animation complete.
							  });
							 });
						</script>
					<!-- /script-for-menu -->
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
<!--Header admin ends here-->