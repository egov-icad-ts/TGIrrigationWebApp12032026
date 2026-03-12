

<!--main code block-->
<!-- sec-section -->

<meta http-equiv="Content-Security-Policy" content="connect-src 'self' https://irrigationpms.cgg.gov.in">

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<!-- <script type="text/javascript" src="../js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>


<script type="text/javascript" src="../js/invom/res-ann1.js"></script>

 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />




	<style>
.ui-tabs-vertical { width: 100% }
.ui-tabs-vertical .ui-tabs-nav { padding: .1em .1em .1em .1em; float: left; width: 15%; }
.ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
.ui-tabs-vertical .ui-tabs-nav li a { display:block; }
.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
.ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right;width:85%  }
 .tabcontent {
            display: none;
            padding: 20px;
        }

</style> 

 <script>
         function openTab(evt, tabName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tablink");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(tabName).style.display = "block";
            evt.currentTarget.className += " active";
        } 
        $(function() { 
        $("#recsalientupdate").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#recsalientupdate li").removeClass("ui-corner-top").addClass("ui-corner-left");
        });
    </script>



<!-- <div class="w3l-main" id="borderStyle">
 -->

<div class="col-md-9">
	


<div>

		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Pre/Post monsoon check list:Reservoir Inspection Checklist
				<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						 <c:if test="${userObj.employeeName!=null && userObj.employeeName!='NA'  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>	
			 
			 </c:if>
			 
			 <c:if test="${userObj.designationName!=null && userObj.designationName!='NA'  }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>	
			 
			 </c:if>
			 </div>
			 <br></br>
			 <div class="span6 pull-right">
			
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
			 <c:out value="${userObj.unitName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">	
			 <c:out value="${userObj.circleName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId==0  }">	
						   <c:if test="${userObj.unitId>0  &&  userObj.circleId>0  &&  userObj.divisionId>0 }">	
			 <c:out value="${userObj.divisionName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId!=0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  &&  userObj.divisionId>0 &&  userObj.subdivisionId>0  }">	
			 <c:out value="${userObj.subdivisionName}"></c:out>	
			 </c:if>
			 </c:if>
			 
			   <c:if test="${userObj.unitId==null && userObj.circleId==null && userObj.divisionId==null && userObj.subdivisionId==null }">	
						   
			 <c:out value="${userObj.userName}"></c:out>	
			 
			 </c:if>
			 
	</div></c:if> &emsp;&emsp;
				
				
				</h3>
			</div>
<div class="panel-body">
<div class="alert alert-info col-md-12" style="padding: 0px"
				id="action_alert"></div>

			


	<%-- 	here<c:out value="${userObj.unitId }"></c:out> --%>
								
							<c:if test="${ userObj.unitId > 0 && userObj.unitId!=9}">		<!-- <div class="col-md-12 invDiv"> -->

<form:form id="mainform" name="mainformname"
								modelAttribute="rescheckList" method="post"
								data-parsley-validate-if-empty="">
								
							
								<div class="col-md-12 invDiv">
								
								<div class="col-md-12">
						
						
						<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Select Large Tank/ Projects  to proceed further. </strong>
				<br>
				<strong style="color:#CA3F22"> Note: Step-1. </strong>
				

			</div>
			</div>
			
	                       <div class="col-md-6">
									<label class="label-control rowlebel ">
										
									</label>
									
									<button type="button" name="showtanksname" id="showtanksdata" 
																	class="btn btn-1 btn-primary center-block "  >Select Tanks</button>
								</div>
								
								<div class="col-md-6">
									<label class="label-control rowlebel ">
										
									</label>
									
									<button type="button" name="showprojectname" id="showprojectsdisplaydata" 
																	class="btn btn-1 btn-primary center-block "  >Select Projects and Reservoirs</button>
								</div>
							
								<br>
								</div>
								
						
								</div>
								
								<!-- start of tanks display -->
								
								<div class="col-md-12 invDiv" id="mkinfo">
						
						
						
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: This information is from mission kakatiya. </strong>
				<br>
				<strong style="color:#CA3F22"> Note: Step-2/3. Click on View/Edit Tank Info button and update if required </strong>
				<br>
				

			</div>
			</div>
			
			
						<div class="col-md-12">
							<div >	
							<div class="col-md-3">
							
							<input  value="${userObj.designationId}" 
											class=" form-control " id="design" type="hidden" />
							<input  value="${userObj.unitId}" 
											class=" form-control " id="uid" type="hidden" />
							<input  value="${userObj.circleId}" 
											class=" form-control " id="cid" type="hidden" />
											
							<input  value="${userObj.divisionId}" 
											class=" form-control " id="diid" type="hidden" />
											
							<input  value="${userObj.subdivisionId}" 
											class=" form-control " id="suid" type="hidden" />
							
								<input  value="0" readonly="readonly" 
											class=" form-control " id="tankId" type="hidden" />
								<label class="label-control rowlebel ">Tank/Anicut/CheckDam:
										<font color=red>*</font>
									</label>
									
									<input id="tankdata" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									</div>
						
								
								
									<div >	
										<div  class="col-md-3">	
										<label class="label-control rowlebel ">Mandal:
										
									</label>	
										<input id="mandata" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									
								</div>
								</div>
								
							
								<div >	
									<div   class="col-md-3">	
									<label class="label-control rowlebel ">Village:
										
									</label>		
									<input id="villdata" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
								
								</div>
								
								</div>
								
								<div >	
									<div   class="col-md-3">	
									<label class="label-control rowlebel ">Project ID Code(PIC):
										
									</label>		
									<input id="tankpic" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
								
								</div>
								
								</div>
								</div>
								
								<br>
								<br>
								<div class="col-md-12">
											<div  id="gross">
									
									<div class="col-md-3">
                                      <label class="label-control rowlebel " for="parameter1">Gross
											Capacity (mcft)</label>

										<input name="miTankInspectList[0].grossCapacity" value="" readonly="readonly"
											class=" form-control " id="grossCapacity" type="text" />

									</div>
								</div>
								<div id="geo">
									
									<div class="col-md-3">
									<label class="label-control rowlebel " for="parameter1">Geo
											Tag Id</label>


										<input name="miTankInspectList[0].geoTagId" value="" readonly="readonly"
											class=" form-control " id="geoTagId" type="text"    />

									</div>
								</div>
								
								<div  id="gmainayacut">
									
									<div class="col-md-3">
									<label class="label-control rowlebel " for="parameter1">Ayacut 
										 (Acres)</label>


										<input name="miTankInspectList[0].grossAyacut" value="" readonly="readonly"
											class=" form-control " id="gayacut" type="text"    />

									</div>
								</div>
								
								<div  id="mainhptank">
									
									<div class="col-md-3">
									<label class="label-control rowlebel " for="parameter1">
										 </label>

<!-- TankDamInfo(tankId.value), -->
										<button type="button" name="shaddtankinf" id="shaddtankinf" 
																	class="btn btn-1 btn-primary center-block "  onclick="TankImpContLvlInfo(tankId.value)"  >(part 1a) View/Edit Tank Info</button>

									</div>
								</div>
								</div>
								
								<div class="col-md-12">
											<div  id="lat">
									
									<div class="col-md-3">
                                      <label class="label-control rowlebel " for="parameter1">Latitude
											</label>

										<input name="miTankInspectList[0].latitude" value="0" readonly="readonly"
											class=" form-control " id="tanklatitude" type="text" />

									</div>
								</div>
								
								<div  id="long">
									
									<div class="col-md-3">
                                      <label class="label-control rowlebel " for="parameter1">Longitude
											</label>

										<input name="miTankInspectList[0].longitude" value="0" readonly="readonly"
											class=" form-control " id="tanklongitude" type="text" />

									</div>
								</div>
								</div>
								
								
								<div class="col-md-12">
								<br>
								<br>
								
								<!-- onclick="resDamImpContLvlInfo(resId.value)" -->
								<div  class="col-md-3"></div>
								
								<div  class="col-md-6">
								<div  class="col-md-2">
								
								<img style="text-align: right;" src="../images/imagesarrow.png" height="50" width="50">
								
								</div>
								<div  class="col-md-4">
								
								<button type="button" name="shaddtanksalientinf" id="shaddtanksalienticon" 
																	class="btn btn-1 btn-primary center-block "  onclick="tankSalientLvlInfo(tankId.value)"  >Add/Edit Tank Salient Features</button>
																	</div></div>
								<div  class="col-md-3"></div>
								
								</div>
								
								
								</div>
								
								
								<!-- start of res display -->
								
								<div class="col-md-12 invDiv" id="pmsresinfo">
								
									<div class="col-md-12">
						
																	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: (Reservoir name is from PMS.If Reservoir location is not displayed , please add location of Reservoir to submit AnnexureI & II.) </strong>
				<br>
				<strong style="color:#CA3F22"> Note: Step-2. Click on Add/update Reservoir Location button and update if required </strong>
                <br>
                	<strong style="color:#CA3F22"> Note: Step-3. Click on Add/View Reservoir Info button and update if required </strong>
			</div>
			</div>
			
		
			
	
						
								
								<div class="col-md-3">
							
							
							<input  value="0" 
											class=" form-control " id="resMainDistrictId" type="hidden" />
								<input name="projectId" value="0" readonly="readonly" 
											class=" form-control " id="resmainprojectId" type="hidden" />
											<input name="resId" value="0" readonly="readonly" 
											class=" form-control " id="resId" type="hidden" />
								<label class="label-control rowlebel ">Project:
										<font color=red>*</font>
									</label>
									
									<input id="projectName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									
									<div  class="col-md-3">	
										<label class="label-control rowlebel ">Reservoir:
										
									</label>	
										<input id="reservoirName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									
								</div>
								
								<div   class="col-md-3">	
									<label class="label-control rowlebel ">Project ID Code(PIC):
										
									</label>		
									<input id="respic" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
								
								</div>
								
								
								<div  class="col-md-3">	
								
								<label class="label-control rowlebel ">
									
									</label>
						
						<button type="button" name="shaddres" id="shaddresinflocn" 
																	class="btn btn-1 btn-primary center-block "  > (part 1a) Add/update Reservoir Location</button>
						
						<br>
						
									
								</div>
								
								
									
								
								
								
									
						
								
								</div>
								
								<div class="col-md-12">
								
								<br>
								
									<div class="col-md-3">
							
							
							
							
								<label class="label-control rowlebel ">District Name:
										<font color=red>*</font>
									</label>
									
									<input id="resmaindistrictName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									
									
									<div class="col-md-3">
							
							
							
							
								<label class="label-control rowlebel ">Mandal Name:
										<font color=red>*</font>
									</label>
									
									<input id="resmainmandalName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									
									
									<div class="col-md-3">
							
							
							
							
								<label class="label-control rowlebel ">Village Name:
										<font color=red>*</font>
									</label>
									
									<input id="resmainvillageName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									
									
									
									
									<div class="col-md-3">
									<label class="label-control rowlebel " for="parameter1">
										 </label>

<!-- resDamInfo(resId.value), -->
										<button type="button" name="shaddresinf" id="shaddresbaiscinf" 
																	class="btn btn-1 btn-primary center-block " onclick="resDamImpContLvlInfo(resId.value)"  >(part 1a) Add/View Reservoir Info</button>

									</div>
								
								
								</div>
								
								<div class="col-md-12">
								<br>
								<br>
								
								<!-- onclick="resDamImpContLvlInfo(resId.value)" -->
								<div  class="col-md-3"></div>
								
								<div  class="col-md-6">
								<div  class="col-md-2">
								
								<img style="text-align: right;" src="../images/imagesarrow.png" height="50" width="50">
								
								</div>
								<div  class="col-md-4">
								
								<button type="button" name="shaddressalientinf" id="shaddressalienticon" 
																	class="btn btn-1 btn-primary center-block "  onclick="resDamSalientLvlInfo(resId.value)"  >Add/Edit Reservoir Salient Features</button>
																	</div></div>
								<div  class="col-md-3"></div>
								
								</div>
								</div>
								
							
								
								
								
								
					
								
								
								<div class="col-md-12 invDiv">							
	
							<div class="col-md-12">
							
							<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Select  frequency </strong>
				<br>
				<strong style="color:#CA3F22"> Note: Step-4.  Year , Monsoon and Overall Condition of Dam </strong>
				<br>
				<strong style="color:#CA3F22"> (Note: click on Reference): </strong>
					
				

			</div>
			</div>
		<div class="col-md-12">	
			<div class="col-md-6">
					<label class="label-controlPMS rowlebel ">Year <font
							color=red>*</font>
						</label>
						
						<select class="form-control" id="year" name="year"  onchange="getresmst2mst1byfreqyear(1),getResInspectioninfo(),getResDamHealthDetails(),getActionStatusDetails( ),getDamInspectioninfo(),getDamRemarksinfo(),getDamInspectPhotosinfo(),getprevmonsoonData()"
							 required >
							<option value=" ">--select--</option>
						

						</select>
						
						<!-- <input class="form-control" id="year"  type="text" name="year"  value="0"  readonly="readonly"   required /> -->
					</div>
						
							
								
									

									<div class="col-md-6">
									<input name=nextEmpId value="" 	id="nextEmpId" type="hidden" />
									
									<label class="label-control rowlebel ">Next level review:  				<font color=red>*</font>
										</label>
										
										<select class="form-control" id="nextPostId" name="nextPostId" required>
										
											<option value=" ">--select--</option>

											<c:forEach items="${getempapprove}" var="u">
												<option value="${u.postId}">${u.empName}</option>
												
												<c:if test="${getempapprove.size()==1}"> <script>     $('select>option:eq(1)').prop('selected', true);  $("#nextPostId").val("${u.postId}");$("#nextEmpId").val("${u.empId}");</script></c:if>
  
												
						 			</c:forEach>


										</select>
									</div>
								
							</div>	
					
								
											
						<!-- 	onchange="getann1inspectdata(year.value)"	 -->
								
                  <div class="col-md-12">	
                  <br><br>
					<div class="col-md-3">
					<label class="label-controlPMS rowlebel ">Select Frequency: <font
							color=red>*</font>
						</label>
						<select class="form-control" id="dutyFrequencyId" name="dutyFrequencyId"  onchange="getresmst2mst1byfreqyear(1),getResInspectioninfo(),getResDamHealthDetails(),getActionStatusDetails( ),getDamInspectioninfo(),getDamRemarksinfo(),getDamInspectPhotosinfo(),getprevmonsoonData()"
							 required >
							<option value=" ">--select--</option>
							<option value="9">PRE MONSOON (April,May)</option>
							<option value="10">POST MONSOON (November,December)</option>
						<!-- 	<option value="11">DURING MONSOON(JUNE TO AUGUEST)</option> -->
						

						</select>
					</div>
					<div class="col-md-3"></div>
					
					
					
						<div class="col-md-3">
					
						<label class="label-controlPMS rowlebel ">Overall Condition of Dam 
								 <font color=red>*</font>
							</label>
							<select class="form-control" id="conditionofDamId" name="conditionofDamId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Unsatisfactory</option>
								<option value="2">2-Poor</option>
								<option value="3">3-Fair</option>
								<option value="4">4-Satisfactory</option>
								


							</select>
						</div>
						
							<div class="col-md-1"  >
							 <label class="label-control rowlebel ">
									</label>
								<button type="button" name="addmichecks12" id="refcondres" 
									class="btn btn-1 btn-primary center-block ">Reference</button>
									</div>
						
							<div class="col-md-2">
							<label class="label-control rowlebel ">
									</label>
																
																<button type="button" name="editdamStatus1" id="editDamStatus12" 
																	class="btn btn-1 btn-primary center-block  " onclick="editdamstatus(conditionofDamId.value)">Edit Status</button>
															</div>
							
</div>

<c:if test="${userObj.unitId>0 && userObj.circleId > 0 && userObj.divisionId > 0 && userObj.subdivisionId > 0 && (userObj.designationId==2 || userObj.designationId==8 ) }">	
<div class="col-md-12" id="previnfodata"  >
<br><br>

<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Click on check box only, if the data has been entered for previous monsoon. </strong>
				<br>
				<br>
				<strong style="color:#CA3F22"> Note: Recommendations can be copied from CE office logins only. </strong>
				
				

			</div>
			</div>

<div class="col-md-12" style="text-align: center;"  >
														<input
																	name="monsooncheck"
																	class="schedulecuscheck1 monsooncheckinf" value="0"
																	id="monsooncheckId" type="checkbox" onchange="handleMonsoonInfo(this.id)" />
																	 <label for="monsooncheckId" class="label-control rowlebel  ">
								Copy previous monsoon data to present monsoon <br>
								(Inspection details, part 2a, Annexure I, part 1b, Inspection Photographs, Health Status)  </label>	
									</div>
									</div>
									
									</c:if>
									
		<c:if test="${userObj.unitId>0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 && (userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==4|| userObj.designationId==5|| userObj.designationId==9|| userObj.designationId==10) }">		
	<div class="col-md-12" id="prevrecommenddata"  >
<br><br>

<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Click on check box only, if the recommendations has been entered for previous monsoon. (CE office only) </strong>
				<br>
				
				

			</div>
			</div>

<div class="col-md-12" style="text-align: center;"  >
														<input
																	name="monsooncheck"
																	class="schedulecuscheck1 monsooncheckinf" value="0"
																	id="recommendcheckId" type="checkbox" onchange="handleRecomandationInfo(this.id)" />
																	 <label for="recommendcheckId" class="label-control rowlebel  ">
								Copy previous Recommendations data to present monsoon Recommendations &emsp;
								(Recommendations)  </label>	
									</div>
									</div>
									
									</c:if>					
				
</div>.
          
						
					
						</div>
						
						
					

				
</form:form>

</c:if>	
		
			<%-- <c:if test="${ userObj.unitId > 0 && userObj.unitId==9}">
			
			<form:form id="mainform2" name="mainformname"
								modelAttribute="rescheckList" method="post"
								data-parsley-validate-if-empty="">
								
				<div class="col-md-12 invDiv">	
			<div class="col-md-10">
					<label class="label-controlPMS rowlebel ">Year <font
							color=red>*</font>
						</label>
						
						<select class="form-control" id="yearsd" name="year"  onchange="getresmst2mst1byfreqyear(1),getResInspectioninfo(),getResDamHealthDetails(),getActionStatusDetails( ),getDamInspectioninfo(),getDamRemarksinfo(),getDamInspectPhotosinfo(),getprevmonsoonData()"
							 required >
							<option value=" ">--select--</option>
						

						</select>
						
					
					</div>
					<br>
					<br>
					
						<div class="col-md-10">
					<label class="label-controlPMS rowlebel ">Select Frequency: <font
							color=red>*</font>
						</label>
						<select class="form-control" id="dutyFrequencyIdsd" name="dutyFrequencyId"  onchange="getresmst2mst1byfreqyear(1),getResInspectioninfo(),getResDamHealthDetails(),getActionStatusDetails( ),getDamInspectioninfo(),getDamRemarksinfo(),getDamInspectPhotosinfo(),getprevmonsoonData()"
							 required >
							<option value=" ">--select--</option>
							<option value="9">PRE MONSOON (April,May)</option>
							<option value="10">POST MONSOON (November,December)</option>
						<!-- 	<option value="11">DURING MONSOON(JUNE TO AUGUEST)</option> -->
						

						</select>
					</div>
						<br>
						<br>
					
						<div class="col-md-10">
					<label class="label-controlPMS rowlebel ">Unit <font
							color=red>*</font>
						</label>
						
						<select class="form-control" id="unitIdsd" name="unitId"  onchange="getresmst2mst1byfreqyear(1),getResInspectioninfo(),getResDamHealthDetails(),getActionStatusDetails( ),getDamInspectioninfo(),getDamRemarksinfo(),getDamInspectPhotosinfo(),getprevmonsoonData()"
							 required >
							 <c:if test="${unitList!=null}">
							 <option value=" ">--select--</option>
							<c:forEach items="${unitList}" var="u" varStatus="count">
							
							<option value="${u.unitId}">${u.unitName }</option>
							</c:forEach>
							</c:if>
						

						</select>
						
					
					</div>
					
					
								
							</div>	
						<div class="col-md-12 invDiv" >	
						
						<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Select any one of the below two conditions either Overall Condition of Dam  or Category of Dam  </strong>
				<br>
				
				

			</div>
			</div>
							<div class="col-md-10">
					
						<label class="label-controlPMS rowlebel ">Overall Condition of Dam 
								 <font color=red>*</font>
							</label>
							<select class="form-control" id="conditionofDamIdsd" name="conditionofDamId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Unsatisfactory</option>
								<option value="2">2-Poor</option>
								<option value="3">3-Fair</option>
								<option value="4">4-Satisfactory</option>
								


							</select>
						</div>
							<br>
							<br>
						
						<div class="col-md-10">
					
						<label class="label-controlPMS rowlebel ">Category of Dam 
								 <font color=red>*</font>
							</label>
							<select class="form-control" id="categorysd" name="category"
								required >
								<option value=" ">--select--</option>
								<option value="1">Category-1</option>
								<option value="2">Category-2</option>
								<option value="3">Category-3</option>
							
								


							</select>
						</div>
						
						</div>
						
										
								
								
								</form:form>
			
			</c:if>		 --%>	

		



			 <div  class="col-md-12" >
			
				
				 	<div id="resprepost">
				 	
				 	<ul>
				 	
				 	
				 	
				 	<li><a href="#inspect" >(part 1a) Add Inspection Details </a></li>
					
					<li><a href="#2ann" > part 2a</a></li>	
					
					<li><a href="#1ann" > Annexure I</a></li>
					
					<li><a href="#addDamRmks" >part 1b / Add Remarks</a></li>
					
					<li><a href="#addinspectpht" >Add Inspection Photographs/Documents</a></li>				
					
					<li><a href="#health" >(Part 2b)Health Status(Reservoir)</a></li>
				<!-- 	<li><a href="#recommn" >Recommendations</a></li> -->
				<!-- 	<li><a href="#ats" >Action Taken Status</a></li> -->
					
					
					
					<!-- <li><a href="#history" >History </a></li>
					<li><a href="#capacity" >Capacity</a></li> -->
					
				</ul>
				
				<div id="inspect">
					
					
					<form:form id="addinspect" method="post" modelAttribute="addinspectdata"
		name="addinspectform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data"  style="overflow:hidden">
		
		
		<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Inspection details can be added by AEE/AE only. </strong>
				<br>
				

			</div>
			</div>
		
		
		<!-- start of earth ann1 form -->
									
										<input name="projectId" value="0" class="mainprojId"
											id="inspectresprojectId" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="inspectresreservoirId" type="hidden" />
									
									<input name="tankId" value="0"  class="maintankId"
									id="inspecttankId" type="hidden" />
							
						
								<input name="year" value="0" id="inspectyear" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="11" id="inspecttabId" type="hidden" /> 
									 


   <input name="dutyFrequencyId" value="0" id="inspectdutyFrequencyId" type="hidden"  	class="maindutyFrequencyId"/>
   
    <input name="conditionofDamId" value="0" id="inspectconditionofDamId" type="hidden"  	class="mainconditionofDamId"/>
    
    
    
    
    <input name="nextPostId" value="0" id="inspectnextPostId" type="hidden" class="mainnextPostId" />
    
     <input name="editFlag" value="false" id="inspecteditFlag" type="hidden"  />
     
       <input name="resinspectInfoId" value="0" id="hiddeninsresinspectInfoId" type="hidden"  />
       
        <input  value="I&CAD Dept." id="hiddenuserdamowner" type="hidden"  />
        <input  value="I&CAD Dept." id="hiddenuserdampop" type="hidden"  />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="inspectpostId" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="inspectnextEmpId" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="inspectuserempId" type="hidden"  	class="mainuserempId" />
								</c:if> 
								
									<!-- end of earth form ann1 form  --> 
		
		
		
		<div class="col-md-12 invDiv">
		
		
		
		<div class="col-md-12">
						
						<br>
						
						<div class="col-md-6">
											
								<label class="label-control rowlebel ">Dam Owner:
										
									</label>
									
									<input id="ownerOfDam" value="I&CAD Dept." name="ownerOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly" />
											</div>
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Dam Operator:
										
									</label>
									
									<input id="damOperator" value="${userObj.unitName}" name="damOperator"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" />
											</div>
									
									<br><br>		
										<br>	
									<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1">
											Select Inspecting officers<font
											color=red>*</font></label> 
											
											<select class="form-control" id="inspectOfficeId1"
											name="inspectOfficeId" required>
											<option value=" ">--select--</option>
											 <option value="1">D.S.R.P(Dam safety review panel)</option>
											 <option value="2">S.D.S.O</option>
											<option value="3">S.D.S.I.T / Technical committee</option> 
											<option value="4">Project Authority</option>
											
									</select>
											</div>
											
											<div class="col-md-3">	
										
										<label class="label-control rowlebel " for="parameter1">
										    select officer designation<font
											color=red>*</font></label> 
											<select class="form-control" id="rec2inspectdesignation"
											name="inspectdesignationId" required>
										    <option value=" ">--select--</option>
											<option value="10">ENC</option>
											<option value="9">CE</option>
											<option value="7">SE</option>
											<option value="5">EE</option>
											<option value="4">DEE</option>
											



										</select>
										</div>
										<br>
										
										<div class="col-md-6">	
										<label class="label-control rowlebel " for="parameter1">
										  </label> 
																
								
																<label class="label-control rowlebel ">Inspect Date (dd/mm/yyyy): <font color=red>*</font>
																</label> <input type="text"
																	class=" datepickinspect form-control datepicker "
																	id="inspectinspectDate1"
																	name="inspectDate"
																	placeholder="inspectDate" value=" " readonly="readonly" required/>
															
										</div>
										
										<br>
								
										
										</div>
											
										
									
									
							
				
		<div class="col-md-12 ">
		<br>
		<div class="col-md-6">
							
							
							
								
											
								<label class="label-control rowlebel "> Name and designation of the Inspecting officers
										<font color=red>*</font>
									</label>
									<textarea class="form-control" id="inspectOfficerData1" 	name="inspectOfficerData" rows="3" cols="50" placeholder="Name1(Designation1),Name2(Designation2)" required></textarea>
									
									
									
								</div>	
								
						
						
						
								<div class="col-md-6">
							
							
							
								
											
								<label class="label-control rowlebel "> Name and designation of the field officers present
										<font color=red>*</font>
									</label>
									
									
									
								
										<textarea class="form-control" id="fieldOfficerData1" 	name="fieldOfficerData" rows="3" cols="50" placeholder="Name1(Designation1),Name2(Designation2)" required></textarea>
						</div>
							
							
					<br>
							
						
						
							</div>
							
								<div class="col-md-12">
									<br>
									
							<div  class="col-md-6 ">
																<label class="label-control rowlebel ">Type of Inspection <font color=red>*</font>
																</label> <input type="text"
																	class="  form-control  "
																	id="typeofinspection1"
																	name="typeofinspection"
																	placeholder="typeofinspection"  required readonly=readonly/>
															</div>
							
															
															
																<div class="col-md-6 ">
																<label class="label-control rowlebel ">Reservoir water level (meters) as on inspection date <font color=red>*</font>
																</label> <input type="text"
																	class="  form-control  "
																	id="presentWaterlevel1"
																	name="presentWaterlevel"
																	placeholder="presentWaterlevel" value="0.01" required data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.01" />
															</div>
															
															<br>
															</div>
															
							<div class="col-md-12">
							<br>
											
																<div class="col-md-6 ">
																<label class="label-control rowlebel ">Storage Capacity (MCM) (Live) <font color=red>*</font>
																</label> <input type="text"
																	class="  form-control  "
																	id="storageCapacity1"
																	name="storageCapacity"
																	placeholder="storageCapacity" value="0.01" required data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.01" />
															</div>
															
																	<div class="col-md-6 ">
																<label class="label-control rowlebel ">Weather Conditions <font color=red>*</font>
																</label> 
																
																<select class="form-control" id="weatherconditionId1"
											name="weatherconditionId" required>
											<option value=" ">--select--</option>
											<option value="1">Sunny</option> 
											 <option value="2">Rainy</option>
											<option value="3">Good</option> 
											<option value="4">bad</option>
											
									</select>
																
																<!-- <input type="text"
																	class="  form-control  "
																	id="weathercondition1"
																	name="weathercondition"
																	placeholder="weathercondition" value=" "  required/> -->
															</div>
															<br>
															
															</div>
															
															
	
					
							<!-- <div class="col-md-12">
							
							<br>
									<br>
						
						
								<div class="col-md-6">			
								
											
								<label class="label-control rowlebel ">Does the officer-in-charge of the operation and maintenance of dam posses all the records as given in the Annexure-I
										<font color=red>*</font>
									</label>
									
									
								
								</div>									
									
									
						
						  <div class="col-md-6">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="inchargeofAnn1" id="inchargeofAnn1n"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="inchargeofAnn1" id="inchargeofAnn1y"     value="true"   >Yes</label>
       
          
    </div>
					
							
									
							</div> -->
							
							<!-- <div class="col-md-12">
						
						<br>
									<br>
						
						
								<div class="col-md-6">
							
							
							
								
											
								<label class="label-control rowlebel "> When and whom was the dam inspected
										<font color=red>*</font>
									</label>
									
									
									
								</div>	
									<div class="col-md-6">
										<textarea class="form-control" id="preDaminspecteddata" 	name="preDaminspecteddata" rows="3" cols="50" placeholder="Name1(Designation1),Date,Name2(Designation2),Date"></textarea>
						</div>
							
							
					
							
						
						
							</div> -->
							
							
							<!-- <div class="col-md-12">
							
							<br>
									<br>
						
						
								<div class="col-md-6">			
								
											
								<label class="label-control rowlebel ">Are the items ponted out during the last Inspection properly attended to? (If not state deficiencies yet to be corrected)
										<font color=red>*</font>
									</label>
									
									
								
								</div>									
									
									
						
						  <div class="col-md-3">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="itemsInspected" id="itemsInspectedn"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="itemsInspected" id="itemsInspectedy"     value="true"   >Yes</label>
       
          
    </div>
     <div class="col-md-3">
										<textarea class="form-control" id="itemsInspectedReason" 	name="itemsInspectedReason" rows="3" cols="50" placeholder="Reasons"></textarea>
						</div>
					
							
									
							</div> -->
							
							<!-- <div class="col-md-12">
							
							<br>
									<br>
						
						
								<div class="col-md-6">			
								
											
								<label class="label-control rowlebel ">Whether Vigilence and Watch & Ward are provided
										<font color=red>*</font>
									</label>
									
									
								
								</div>									
									
									
						
						  <div class="col-md-3">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="vigandWatchProvided" id="vigandWatchProvidedn"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="vigandWatchProvided" id="vigandWatchProvidedy"     value="true"   >Yes</label>
       
          
    </div>
    
    <div class="col-md-3">
										<textarea class="form-control" id="vigandwatchreason" 	name="vigandwatchreason" rows="3" cols="50" placeholder="Reasons"></textarea>
						</div>
					
							
									
							</div>
							 -->
							<!-- <div class="col-md-12">
							
							<br>
									<br>
						
						
								<div class="col-md-6">			
								
											
								<label class="label-control rowlebel ">Have the observations of inspecting officer in respect of all the dam components are easily furnished as given in the annexure-II
										<font color=red>*</font>
									</label>
									
									
								
								</div>									
									
									
						
						  <div class="col-md-6">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="obsAnn2" id="obsAnn2n"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="obsAnn2" id="obsAnn2y"     value="true"   >Yes</label>
       
          
    </div>
					
							
									
							</div> -->
							
							
							
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="inspectcaptcha_id" name="imgCaptcha" src="../captcha.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('inspectcaptcha_id').src = '../captcha.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="inspectcaptcha_id1" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
								</div>
								
								<c:if test="${ (userObj.unitId!=9 || userObj.unitId!=9832 || userObj.unitId!=4 || userObj.unitId!=9830) && (userObj.designationId==2 || userObj.designationId==8)}">
						
						<div class="col-md-12">
						<br>
						
						<button type="button" name="submitinspectinf" id="submitinspectinf1" 
																	class="btn btn-1 btn-primary center-block" onclick="AddInspectionInfo(this.form.id,editFlag.value)"  >Submit</button>
						
						</div>
		
		</c:if>
				
			</div>			

	</form:form>
	
	
	
	 <div id="inspectdata"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table7">
						<thead id="resinspecthead1"> </thead>
						
						<tbody id="resinspectbody1"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>    	
					
					
					</div>
				
				<div id="1ann"> 
				
				<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note1: Observations Can be added by AEE/AE only. </strong>
				<br>
				<strong style="color:black"> Note2: <button type="button" name="leg1" id="annobsleg1b" class="btn btn-1 btn-primary "  > </button> :   Observations not entered 
				&emsp;&emsp; <button type="button" name="leg1" id="annobsleg1g" class="btn btn-1 btn-success "  > </button>  :  Observations entered 
				 </strong>
				<br>
				

			</div>
			</div>
					
						<ul>
						
						
				 	<c:if test="${rescatList!=null}">
					 	
					 	
						
					 <c:forEach items="${rescatList}" var="liinfo1" varStatus="listcount1">
					 
					
					 
					 <c:if test="${liinfo1.resCatParentId==0 && liinfo1.resCategoryId<5 }">
						
					    <li><a href="#gen<c:out value="${liinfo1.resCategoryId}"></c:out>" ><c:out value="${liinfo1.resCategory}"></c:out></a></li>
					  </c:if>  
					    </c:forEach>
						
						</c:if> 
				 	
							
						<!-- 	<li><a href="#addre" >Add Remarks Annexure1</a></li> -->
						</ul>
						
					<!-- 	start of ann categories -->
					
					<c:if test="${rescatList!=null}">
						
						 <c:forEach items="${rescatList}" var="dataann1" varStatus="dataann1count">
						 
						  <c:if test="${dataann1.resCatParentId==0 && dataann1.resCategoryId<5 }">
					<div id="gen<c:out value="${dataann1.resCategoryId}"></c:out>">
						
							<div class="col-md-12">	
								
								<div class="col-md-12">
								
								<c:if test="${rescheckann1all!=null}">
								
								<c:forEach items="${rescheckann1all}" var="m" varStatus="acount">
								
								<c:if test="${m.resCategoryId==dataann1.resCategoryId  && m.isTitle==false}"> 
								
								<div class="col-md-1">
								
								<button type="button" name="snumgen" id="annobs${m.resCheckId}"        class="btn btn-1 btn-primary  center-block annbuttoninf"  onclick="getresgenchecklist('${m.resCheckId}',this.id)">${m.checkdisplayNum}</button> &emsp;&emsp;&emsp;&emsp;  
								</div>
								</c:if>
								
								<c:if test="${m.resCategoryId==dataann1.resCategoryId  && m.isTitle==true}"> 
								
								<div class="col-md-12" style="color:blue; font-size: 16px">
								<br>
								
								<strong>   ${m.checkdisplayNum} &emsp;&emsp;   ${m.resCheck}  </strong>
								
								<br>
								</div>
								</c:if>
								
							<%-- 	<c:if test="${acount.count==12}">  <br> <br> </c:if> --%>
								
								</c:forEach>
								
							
								
								</c:if>
								
								
								</div>
								
								
								
						 		<div class="col-md-12"> 

								<c:if test="${rescheckann1all!=null}">


									<c:forEach items="${rescheckann1all}" var="m" varStatus="mcount">
									
								<c:if test="${m.resCategoryId==dataann1.resCategoryId }">
									
										<div class="col-md-12 resmainobsinf" id="resmainobs${m.resCheckId}">
										
										&emsp;&emsp;
										
										
									<!-- 	start of form  -->
										
										<form:form id="resformgen${m.resCheckId}" name="resgenform${m.resCheckId}name"
								modelAttribute="rescheckObject" method="post"
								data-parsley-validate-if-empty="" style="overflow:hidden">					
							
									
									<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${m.resCheckId}" type="hidden" />
											
												<input  value="0" 
											id="ann2mst1Id${m.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${m.resCheckId}" name="resInspectMst2Id" type="hidden" />
														
											
								  <%--   <input name="reservoirInspectList[0].inspectDate" value="0"
											id="inspectDate${mcount.count}" type="hidden" />	 --%>
											
											
														
							
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${m.resCheckId}" type="hidden" />
									      
								<input name="tankId" value="0"  class="maintankId"
									id="restankId1${m.resCheckId}" type="hidden" />
								<input name="year" value="0" id="year${m.resCheckId}" class="mainyear"
									type="hidden" />
							   <input name="tabId" value="2${m.resCategoryId}" id="tabId${m.resCheckId}" type="hidden" /> 
							   
							   <input name="annexureId" value="1" id="annexureId${m.resCheckId}" class="mainannId"
									type="hidden" />
                              <input name="editFlag" value="false"  
									id="resann1editFlag${m.resCheckId}" type="hidden" />

          <input name="dutyFrequencyId" value="0" id="dutyFrequencyId${m.resCheckId}" type="hidden"  class="maindutyFrequencyId"/>
          <input name="conditionofDamId" value="0" id="conditionofDamId${m.resCheckId}" type="hidden"  	class="mainconditionofDamId"/>
          
         

								
		<input name="nextPostId" value="0" id="nextPostId${m.resCheckId}" type="hidden" class="mainnextPostId" />
			<c:if test="${userObj!=null && userObj.post!=null}">
<input name="postId" value="${userObj.post}" id="postId${m.resCheckId}"  type="hidden"  class="mainpostId"/>
			</c:if>
		<input name="nextEmpId" value="0" id="nextEmpId${m.resCheckId}" type="hidden"  class="mainnextEmpId"/>
		   <c:if test="${userObj!=null && userObj.empId!=null}">
    <input value="${userObj.empId}" name="empId" id="userempId${m.resCheckId}" type="hidden" class="mainuserempId" />
		</c:if>    
										
										<!-- end of form  -->
										
						 <div class="col-md-12">			
					   <div class="col-md-12">
   <c:choose>
   <c:when test="${not empty m.resCheck}">
			 <label class="label-control rowlebel invDiv "  for="parameter1">${m.checkdisplayNum} &emsp;&emsp; ${m.resCheck}</label>
			 </c:when> 
			 <c:otherwise>
			<strong><c:out value="${m.checkdisplayNum}"></c:out></strong>	 <input
											name="resCheckName" 
											class=" form-control " id="resCheckName${m.resCheckId}" type="text"  />  
											</c:otherwise>
											
											</c:choose>
			  <input  name="resCheckId"  value="${m.resCheckId}" 
			          id="resCheckId${m.resCheckId}"  type="hidden" /> 
	         <input type="hidden" class="form-control" 	id="resCatId${m.resCheckId}"
				    name="resCatId" value="${m.resCategoryId}" />
											
						</div>
						</div>
						
						 <div class="col-md-12"  > 
						 <br>
						
						<div class="col-md-6">
						
						<label class="label-control rowlebel " for="parameter1">
											Nos</label> 		
											
						<input
											name="installedcount" value="0"
											class=" form-control  installno " id="installedcount${m.resCheckId}" type="text"  
										
											   />
											   
											   
			          </div>
			          
			          <div class="col-md-6">
						
						<label class="label-control rowlebel " for="parameter1">
											Location</label> 		
											
						<input
											name="location" value="0"
											class=" form-control  locat" id="location${m.resCheckId}" type="text"  
										
											   />
											   
											   
			          </div>
			          
			          
			          <br>
			          </div>
							<div class="col-md-12">
							 <br>
						<div class="col-md-6">
						
						<label class="label-control rowlebel " for="parameter1">
											Chainage (from)</label> 		
											
											
											
											
						<input
											name="irrChFrm" value="0.00"
											class=" form-control  chfrmann1" id="irrChFrm${m.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
			          </div>
			         	<div class="col-md-6"> 
			         	
			         	 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											</label>
			         <input
											name="irrChTo" value="0.00"
											class=" form-control chtoann1" id="irrChTo${m.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											
						</div>	
						</div>
						
							<div class="col-md-12">
							 <br>
						
						<div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Since When Installed ( Month / Year)</label> 		
											
						<input
											name="installmonth" value="0" readonly="readonly"
											class=" form-control datepicknew instmonth" id="installmonth${m.resCheckId}" type="text"  
										
											   />
			          </div>	
			          
			          <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Whether in working condition ( Yes / No) &emsp;&emsp;</label> 
											
					 <label class="radio-inline"> <input class="rd1wrkn instwrkcond" type="radio" name="workingcondition" id="workingconditionn${m.resCheckId}"  checked="checked"    value="false"  required >N</label>
        <label class="radio-inline"> <input class="rd1wrky instwrkcond" type="radio" name="workingcondition" id="workingconditiony${m.resCheckId}"     value="true"  required >Y</label>		
											
						
			          </div>
			          
			          </div>
			         	<div class="col-md-12"> 
			         	 <br>
			          <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Date last Calibration </label> 		
											
						<input
											name="datelastCalibrated" value=" " readonly="readonly"
											class=" form-control datepicknew datelstcalb" id="datelastCalibrated${m.resCheckId}" type="text"  
										
											   />
			          </div>	
			          
			           <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Date for next Calibration </label> 		
											
						<input
											name="datenextCalibrated" value=" " readonly="readonly"
											class=" form-control datepicknew datenxtcalb" id="datenextCalibrated${m.resCheckId}" type="text"  
										
											   />
			          </div>	
			          
			          </div>
			          
			          	<div class="col-md-12">
			          	 <br>
			          
			          <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Observations maintained ( Yes / No) &emsp;&emsp;</label> 
											
					 <label class="radio-inline"> <input class="rd1obsn obsmain" type="radio" name="obsmaintained" id="obsmaintainedn${m.resCheckId}"  checked="checked"    value="false"  required >N</label>
        <label class="radio-inline"> <input class="rd1obsy obsmain" type="radio" name="obsmaintained" id="obsmaintainedy${m.resCheckId}"     value="true"  required >Y</label>		
											
						
			          </div>
			          
			           <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Agency responsible for data collection and processing ( Yes / No) &emsp;&emsp;</label> 
											
					 <label class="radio-inline"> <input class="rd1agn agresp" type="radio" name="agencyresponsible" id="agencyresponsiblen${m.resCheckId}"  checked="checked"    value="false"  required >N</label>
        <label class="radio-inline"> <input class="rd1agy agresp" type="radio" name="agencyresponsible" id="agencyresponsibley${m.resCheckId}"     value="true"  required >Y</label>		
											
						
			          </div>
			          
			          </div>
			          	<div class="col-md-12">
			          	 <br>
			            <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Analysis of data done at field level ( Yes / No) &emsp;&emsp;</label> 
											
					 <label class="radio-inline"> <input class="rd1ann analysedata" type="radio" name="analysisofdata" id="analysisofdatan${m.resCheckId}"  checked="checked"    value="false"  required >N</label>
        <label class="radio-inline"> <input class="rd1any  analysedata" type="radio" name="analysisofdata" id="analysisofdatay${m.resCheckId}"     value="true"  required >Y</label>		
											
						
			          </div>
			           <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Data sent to DSO regularly ( Yes / No) &emsp;&emsp;</label> 
											
					 <label class="radio-inline"> <input class="rd1dson datadso" type="radio" name="datasenttoDSO" id="datasenttoDSOn${m.resCheckId}"  checked="checked"    value="false"  required >N</label>
        <label class="radio-inline"> <input class="rd1dsoy datadso" type="radio" name="datasenttoDSO" id="datasenttoDSOy${m.resCheckId}"     value="true"  required >Y</label>		
											
						
			          </div>
			          
			          </div>	
			          
			           <div class="col-md-12"  > 						
						<div class="col-md-12">
						
						 <br>
						 
						 <label class="label-control rowlebel " for="parameter1">
											Observations</label> 

		<textarea class="form-control remks" id="remarks${m.resCheckId}"	name="remarks"
				   rows="3" cols="50" placeholder="Observations" required></textarea>
						
						</div>
						
						</div>
											
						<c:if test="${(userObj.unitId!=9 || userObj.unitId!=4 || userObj.unitId!=9832 || userObj.unitId!=9830) &&(userObj.designationId==2 || userObj.designationId==8) }">			 
						 <div class="col-md-12"  > 
						  <br>
						 
						&emsp;&emsp;
	 	<button type="button" name="rescheckadd${m.resCheckId}"  id="rescheckbutton${m.resCheckId}"
					  class="btn btn-1 btn-primary center-block "  onclick="addnrldchecksann1(this.form.id,resann1editFlag${m.resCheckId}.value,${m.resCheckId})">Submit</button>
									
						&emsp;&emsp;
						
						</div>
						</c:if>	
									
				</form:form>
									
										
										</div>
			
                           <div id="annvieweditinf${m.resCheckId}" class="col-md-12 resannvieweditdata">
                           &emsp;&emsp;&emsp;&emsp;
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="gen-frm-table-${m.resCheckId}">
											<thead id="gen-thead${m.resCheckId}">
											<tr>
											<th>S.NO</th>
											<th>Edit Observations</th>
											<th>Delete Observations</th>
											
											<!-- <th>Add / Edit / Delete / View Recommendations</th> -->
											
											</tr>

											</thead>


											<tbody id="gen-tbody${mcount.count}">
									<tr>
									<td> S.no </td>
									<td><button type="button" name="ann1editobservations" 	id="reseditobs${m.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs" onclick="anneditobservations(${m.resCheckId})">Edit Observations</button></td>
									<td><button type="button" name="ann1delete1" 	id="resdeleteobs${m.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs" onclick="deleteanndata(ann2mst2Id${m.resCheckId}.value,'${m.resCheckId}')" >Delete Observations</button></td>
									
									<!-- addrecminfo -->
								<%-- 	<td><button type="button" name="ann1edit4" 	id="resviewrecm${m.resCheckId}"  class="btn btn-1 btn-primary center-block " onclick="addrecmmn(${m.resCheckId},1)">Add  Recommendations</button>
									<br>
									<button type="button" name="ann1edit4" 	id="resviewrecm${m.resCheckId}"  class="btn btn-1 btn-primary center-block " onclick="addrecmmn(${m.resCheckId})"> Edit / Delete / View Recommendations</button>
									<br></td> --%>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>
							
						

										 
							
							</c:if>
									
									</c:forEach>
								</c:if>
								
								&emsp;&emsp;&emsp;&emsp;
								
							
								
							 	</div>
								
						
									&emsp;&emsp;
							
							</div>
						</div>
						
						</c:if>
						
						</c:forEach>
						</c:if>
					<!-- 	end of enn categories -->
						
						
						
				
					
					
					
					</div>
					
					<div id="2ann">
					
					<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note1: Observations can be added by AEE/AE only. </strong>
				<br>
				<strong style="color:black"> Note2: <button type="button" name="leg2" id="annobsleg2b" class="btn btn-1 btn-primary "  > </button> :   Observations not entered 
				&emsp;&emsp; <button type="button" name="leg2" id="annobsleg2g" class="btn btn-1 btn-success "  > </button>  :  Observations entered 
				&emsp;&emsp;<button type="button" name="leg2" id="annobsleg2r" class="btn btn-1 btn-danger "  > </button> :  Recommendations entered </strong>
				<br>
				<strong style="color:#CA3F22"> Note3: Recommendations can be added by CE Office only. </strong>
				<br>
				<strong style="color:#CA3F22"> Note4: Once the Recommendations are added then edit,delete observations are not available </strong>

			</div>
			</div>
					
					<!-- <div id="tabs2"> -->
						<ul>
						
					 	<c:if test="${rescatList!=null}">
					 	
					 	
						
					 <c:forEach items="${rescatList}" var="liinfo" varStatus="listcount">
					 
					
					 
					 <c:if test="${liinfo.resCatParentId==0 && liinfo.resCategoryId>=5 }">
						
					    <li><a href="#earth<c:out value="${liinfo.resCategoryId}"></c:out>" ><c:out value="${liinfo.catNumDisplay}"></c:out>-<c:out value="${liinfo.resCategory}"></c:out></a></li>
					  </c:if>  
					    </c:forEach>
						
						</c:if> 
							
							<!-- <li><a href="#addre2" >Add Remarks Annexure II </a></li> -->
						
						</ul>
						
						
						
						
						<!-- </div> -->
						
							<!-- start of annexure II categories -->
						
						<c:if test="${rescatList!=null}">
						
						 <c:forEach items="${rescatList}" var="datainfo" varStatus="datacount">
						<div id="earth<c:out value="${datainfo.resCategoryId}"></c:out>">
						
						<!-- start of divs -->
						
						<div id="verticalearth<c:out value="${datainfo.resCategoryId}"></c:out>">
						 	
						  	<c:if test="${rescatList!=null}"> 
						 	
						 					<ul>
						 	
				  <c:forEach items="${rescatList}" var="k" varStatus="kcount">
					 
						<c:if test="${k.resCatParentId==datainfo.resCategoryId && k.catTitle==false}"> 
					<li ><a  style="color:maroon;" href="#<c:out value="${kcount.count}"></c:out>" ><c:if test="${!(k.catNumDisplay=='0')}">  <c:out value="${k.catNumDisplay}"></c:out> </c:if>&emsp;&emsp;<c:out value="${k.resCategory}"></c:out></a></li>
					 
					</c:if>
				</c:forEach>
					
				</ul>
				
				</c:if>
				
				<c:if test="${rescatList!=null}">
				 <c:forEach items="${rescatList}" var="l" varStatus="lcount">
				 <c:if test="${l.resCatParentId==datainfo.resCategoryId}"> 
				 
					<div id="${lcount.count}">
					
					
					
					  
					  <div class="col-md-12">
								
							 <c:forEach items="${rescheckann2all}" var="g" varStatus="gcount">
						    	   <c:if test="${g.resCategoryId==l.resCategoryId && l.resCatParentId==datainfo.resCategoryId && g.isTitle==false}">
								<div class="col-md-1">
								
								
								<button type="button" name="earthann2" id="annobs${g.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${g.resCheckId}',this.id)"> ${g.checkdisplayNum}</button>  
								&emsp;&emsp;&emsp;&emsp;
								</div>
								
								<c:if test="${g.resCheckSeq==12}">  <br> <br> </c:if>
								
									</c:if>
								</c:forEach>
								
								<br><br>
								</div> 
								
							
					
				
						<c:if test="${rescatList!=null}">
						
						
						
						
						

					
						    	   <c:forEach items="${rescheckann2all}" var="n" varStatus="ncount">
						    	   <c:if test="${n.resCategoryId==l.resCategoryId && l.resCatParentId==datainfo.resCategoryId}">
						    	   

								
								
                     
                       <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
                       
                   
                     
                     	<form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="" style="overflow:hidden">
					
                         <!--    start of ann2ear form hidden values -->
								<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}"   type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" name="resInspectMst2Id" type="hidden" />
									
									
									<input name="editFlag" value="false"  
									id="resann2editFlag${n.resCheckId}" type="hidden" />
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							<input name="tankId" value="0"  class="maintankId"
									id="restankId2${n.resCheckId}" type="hidden" />
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="31" id="tabId${n.resCheckId}" type="hidden" /> 
									   <input name="annexureId" value="2" id="annexureId${n.resCheckId}" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyId${n.resCheckId}" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamId${n.resCheckId}" type="hidden"  	class="mainconditionofDamId"/>
   
    
    
    
    
    <input name="nextPostId" value="" id="nextPostId${n.resCheckId}" type="hidden" class="mainnextPostId" />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="postId${n.resCheckId}" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="nextEmpId${n.resCheckId}" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="userempId${n.resCheckId}" type="hidden"  	class="mainuserempId" />
								</c:if> 
                        
                        
                        	
					
                    <!--     end of ann2earform  hidden values-->
                       
                       
                       
                       <c:if  test="${n.isTitle==true}">
                       	<div class="col-md-12">	 
			<label class="label-control rowlebel " for="parameter1" style="color: blue">
											${n.resCheck}
											
											
											
											</label> 
					</div>
					
					</c:if>
                       
                       
					  <div class="col-md-12 ">
					  
					  
					  
					  <label class="label-control rowlebel invDiv "
													for="parameter1"><c:if test="${!(n.checkdisplayNum=='0')}">  ${n.checkdisplayNum} </c:if> &emsp;&emsp;   	${n.resCheck}</label>
													
													
													 <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
						
						<div class="col-md-12">	 
        <label class="label-control rowlebel ">Response <font color=red>*</font> </label>
      
        <label class="radio-inline"> <input class="rd1damn   damresp" type="radio" name="damcheckResponseId" id="damcheckResponseIdn${n.resCheckId}"  checked="checked"    value="1"  required  >N</label>
        <label class="radio-inline"> <input class="rd1damy   damresp" type="radio" name="damcheckResponseId" id="damcheckResponseIdy${n.resCheckId}"     value="2"  required >Y</label>
         <label class="radio-inline"> <input class="rd1damna  damresp" type="radio" name="damcheckResponseId" id="damcheckResponseIdna${n.resCheckId}"     value="3"  required >NA</label>
     
   
        </div>
						
						
					<div class="col-md-12" id="obsres${n.resCheckId}">	 
					 <br>
					 
<label class="label-control rowlebel ">Observations <font color=red>*</font> </label>
				<textarea class="form-control ann2rmks" id="remarks${n.resCheckId}"
													name="remarks"
						
													rows="3" cols="50" placeholder="Observations"></textarea>
													
													<br>
					</div>
					
					<div class="col-md-6" id="chfrmres${n.resCheckId}">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control  irrchfrm2ann" id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6" id="chtores${n.resCheckId}">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control  irrchto2ann" id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
									
								
					
						<div class="col-md-12" id="condres${n.resCheckId}">
						
						<br>
						
						<label class="label-controlPMS rowlebel ">Condition
								 <font color=red>*</font>
							</label>
							<select class="form-control condcheck" id="conditionofCheckId${n.resCheckId}" name="conditionofCheckId"
								required onchange="">
								<option value=" ">--select--</option>
								<option value="1">1-Unsatisfactory</option>
								<option value="2">2-Poor</option>
								<option value="3">3-Fair</option>
								<option value="4">4-Satisfactory</option>
								


							</select>
						</div>
							
					
			
							<c:if test="${(userObj.unitId!=9 || userObj.unitId!=4 || userObj.unitId!=9832 || userObj.unitId!=9830) && ( userObj.designationId==2 || userObj.designationId==8  ) }">	
							<div class="col-md-12">
							<br />
							<br />
							 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id,resann2editFlag${n.resCheckId}.value,${n.resCheckId})" >Submit</button>
							 </div>
							 </c:if>
							 
							 
							 </form:form>
					
					</div>
					
					
					
					<!-- start of div data -->
					
					<div id="annvieweditinf${n.resCheckId}" class="col-md-12 resannvieweditdata">
                           &emsp;&emsp;&emsp;&emsp;
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="gen-frm-table-${n.resCheckId}">
											<thead id="gen-thead${n.resCheckId}">
											<tr>
											<th>S.NO</th>
											<th>Edit Observations</th>
											
										
											<th>Delete Observations</th>
											
											<th>Add / View/Edit/Delete  Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs"  onclick="anneditobservations(${n.resCheckId})" >Edit Observations</button>
									
									</td>
									<td><button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs"  onclick="deleteanndata(ann2mst2Id${n.resCheckId}.value,'${n.resCheckId}')">Delete Observations</button></td>
									
									
									<td>
										<c:if test="${((userObj.unitId>0 &&  userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0) && (userObj.unitId!=9 || userObj.unitId!=9832 || userObj.unitId!=4 || userObj.unitId!=9830) && (userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==4 || userObj.designationId==5 || userObj.designationId==7 || userObj.designationId==9 || userObj.designationId==10 ) )  }">
									<button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block " onclick="addrecmmn(${n.resCheckId},2)">Add  Recommendations</button>
									</c:if>
									<br>
									<button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block " onclick="getResDamRecommendations(${n.resCheckId})">Edit / Delete/ View Recommendations</button>
									<br>
									</td>
									</tr>
                                                       <!-- addrecminfo -->
											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					
					</c:if>
					
					
					</c:forEach>
				<%-- </c:forEach> --%>
				 	  </c:if>
					
						
				
					
				
				</div>
				</c:if>
				</c:forEach>
				
				</c:if>
			
				
					
				</div>
						
						
						
					<!-- 	end of divs -->
						
						
						</div>
						
						</c:forEach>
						</c:if>
						
						
				
				<!-- end of annexure II categories -->
				
				
										
						
					<%-- <div id="addre2">
					
					<form:form id="reviewformremann2" method="post" modelAttribute="rescheckObject"
		name="reviewformremann1name" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		<div class="col-md-12">
			
<!-- start of remarks form hidden data -->
				
       <input name="projectId" value="0" class="mainprojId"
											id="resprojectIdremann2" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirIdremann2" type="hidden" />
							
						
								<input name="year" value="0" id="yearremann2" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="33" id="tabIdremann2" type="hidden" /> 
									   <input name="annexureId" value="2" id="annexureIdrem" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyIdremann2" type="hidden"  	class="maindutyFrequencyId"/>
   
   <input name="conditionofDamId" value="0" id="conditionofDamIdremann2" type="hidden"  	class="mainconditionofDamId"/>
   
    
    
    
    
    <input name="nextPostId" value="" id="nextPostIdremann2" type="hidden" class="mainnextPostId" />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="postIdremann2" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="nextEmpIdremann2" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="userempIdremann2" type="hidden"  	class="mainuserempId" />
								</c:if> 
								
								<!-- end of remarks form hidden data -->
	
       <div class="col-md-12">
		<label class="label-control rowlebel "> InspectDate</label>
			<input type="text"  class="datepick form-control datepicker "  id="inspectDateremann2"  name="inspectDate"  placeholder="dateofoperation" value="0" readonly="readonly"/>
		</div>
		<div class="col-md-12">
		<label class="label-control rowlebel "> Remarks</label>
			<textarea class="form-control" id="remarksremann2"
				name="remarks" rows="3" cols="50"
				placeholder="Review Details" required></textarea>
		</div>
	

  

		<div class="col-md-12">
		
				<label class="label-control rowlebel "></label>
				<input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block reviewbutton" id="reviewinfoid2" 
					value="Add Remarks" onclick="AddRemarksInfo(this.form.id)">
			
		</div>
		
		</div>

	</form:form>
					
					</div> --%>
					
					
					</div>
					
					
				
					
					
					
					<%-- <div id="history">
				
				<form:form id="resann2form5" name="resann2form5name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId5" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId5" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId5" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId5" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId5" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId5" type="hidden" />
							 <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId5" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId5" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId5" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year5"
									type="hidden" />
									
									 <input name="reservoirInspectList[0].tabId" value="5" id="tabId5" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId5" type="hidden" /> 
                                       <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId5" type="hidden" /> 
                                       
                                       <div class="col-md-12">
                                       
                                       <br><br>
				
					   <div class="col-md-12">
							<label class="label-controlPMS rowlebel ">History of past distress, if any , and brief details:
								 <font color=red>*</font>
								<textarea class="form-control myrem"
																	id="remarks"
																	name="remarks"
																	rows="3" cols="50" placeholder="History"></textarea>
							</label>
						</div>
						
						   <div class="col-md-12">
							<label class="label-controlPMS rowlebel ">Remedial measures carried out:
								 <font color=red>*</font>
								<textarea class="form-control myrem"
																	id="remarks"
																	name="remarks"
																	rows="3" cols="50" placeholder="Remedial"></textarea>
							</label>
						</div>
						
						

						
						<div class="col-md-12"> 
					
						<div class="col-md-4"> 
    <label class="label-controlPMS rowlebel ">Select Inspect Date: <font
							color=red>*</font>
						</label>	
						
							<select class="form-control" id="reshistinspectDate" name="inspectDate"
								required>
								

							</select>
				</div>
				
				<div class="col-md-4"> </div>
					<div class="col-md-4"> </div>
						</div>
						<div class="col-md-12"> 
						 <button type="button" name="rescheckbutton5" id="rescheckbutton5" class="btn btn-1 btn-primary center-block " >Submit</button>
    
   </div>
					  
						</div>   	
					
					
						 
					</form:form>
					
					<div id="rescapacity"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table5">
						<thead id="thead5"> </thead>
						
						<tbody id="tbody5"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>
				
				
				</div> --%>
					
					<%-- <div id="capacity">
				
				<form:form id="resann2form5" name="resann2form5name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId5" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId5" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId5" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId5" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId5" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId5" type="hidden" />
							 <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId5" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId5" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId5" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year5"
									type="hidden" />
									
									 <input name="reservoirInspectList[0].tabId" value="5" id="tabId5" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId5" type="hidden" /> 
                                       <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId5" type="hidden" /> 
                                       
                                       <div class="col-md-12">
                                       
                                       <br><br>
					<div class="col-md-2">
                     
                     <input name="reservoirInspectList[0].resCheckboxId" 	class="rescustomcheck5" value="0"  id="resCheckboxId0" type="checkbox" />
                    
                     </div>  
					   <div class="col-md-4">
							<label class="label-controlPMS rowlebel ">Maximum Water Level
								 <font color=red>*</font>
								<input id="canreamarksVillageName" value="" name="reamarksVillageName"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
							</label>
						</div>

						
						<div class="col-md-4"> 
    <label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>	
						
							<input
				type="text" class=" datepick form-control datepicker" id="restab5inspectDate" name="reservoirInspectList[0].inspectDate"
				placeholder="dateofoperation"  />
						</div>
						<div class="col-md-2"> 
						 <button type="button" name="rescheckbutton5" id="rescheckbutton5" class="btn btn-1 btn-primary center-block " >Submit</button>
    
   </div>
					  
						</div>   	
					
					
					 <div class="col-md-12">
					 
					 <br><br>
					<div class="col-md-2">
                     
                     <input name="reservoirInspectList[0].resCheckboxId" 	class="rescustomcheck5" value="0"  id="resCheckboxId0" type="checkbox" />
                    
                     </div> 
					   <div class="col-md-4">
							<label class="label-controlPMS rowlebel ">Minimum Water Level
								 <font color=red>*</font>
								<input id="canreamarksVillageName" value="" name="reamarksVillageName"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
							</label>
						</div>

						
						<div class="col-md-4"> 
    <label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>	
						
							<input
				type="text" class=" datepick form-control datepicker" id="restab5inspectDate" name="reservoirInspectList[0].inspectDate"
				placeholder="dateofoperation"  />
						</div>
						<div class="col-md-2"> 
						 <button type="button" name="rescheckbutton5" id="rescheckbutton5" class="btn btn-1 btn-primary center-block " >Submit</button>
    
   </div>
					  
						</div>   	
						
						<div class="col-md-12">
					 
					 <br><br>
					<div class="col-md-2">
                     
                     <input name="reservoirInspectList[0].resCheckboxId" 	class="rescustomcheck5" value="0"  id="resCheckboxId0" type="checkbox" />
                    
                     </div> 
					   <div class="col-md-4">
							<label class="label-controlPMS rowlebel ">Maximum Over flows
								 <font color=red>*</font></label>
						
							 <label class="radio-inline"> 
							 <input type="radio" class="myradio "  name="actionreq" id="actionreqn" value="false">NO </label>
							 <label class="radio-inline"> <input  type="radio" class="myradio"  name="actionreq"  id="actionreqy" value="true">Yes
																</label>


						
						
						</div>

						
						<div class="col-md-4"> 
    <label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>	
						
							<input
				type="text" class=" datepick form-control datepicker" id="restab5inspectDate" name="reservoirInspectList[0].inspectDate"
				placeholder="dateofoperation"  />
						</div>
						<div class="col-md-2"> 
						 <button type="button" name="rescheckbutton5" id="rescheckbutton5" class="btn btn-1 btn-primary center-block " >Submit</button>
    
   </div>
      <br><br>
					
						</div>   
						
						 
					</form:form>
					
					<div id="rescapacity"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table5">
						<thead id="thead5"> </thead>
						
						<tbody id="tbody5"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>
				
				
				</div> --%>
					
					<div id="health">
					
					<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note1: Dam health Status can be added by AEE/AE only. </strong>
				<br>
				<strong style="color:#CA3F22"> Note2: Recommendations can be added by CE Office only. </strong>

			</div>
			</div>
				
				<form:form id="reshealthform5" name="reshealthform5name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="" style="overflow:hidden">
						
						
						
								<input name="projectId" value="0" class="mainprojId"
											id="reshealthann2" type="hidden" />
											
											
								<input  value="0" 
											id="healthmst1Id" type="hidden" name="resInspectMst1Id" />
											<input  value="0" 
											id="healthmst2Id" type="hidden" name="resInspectMst2Id"  />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="reshealthann2" type="hidden" />
									
										<input name="resDamHealthId" value="0"  
									id="resresDamHealthId" type="hidden" />
									
										<input name="editFlag" value="false"  
									id="reshealtheditFlag" type="hidden" />
									
									
							
							<input name="tankId" value="0"  class="maintankId"
									id="healthtankId" type="hidden" />
						
								<input name="year" value="0" id="yearhealth" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="41" id="tabIdhealth" type="hidden" /> 
									   <input name="annexureId" value="0" id="annexurehealth" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyIdhealth" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamIdhealth" type="hidden"  	class="mainconditionofDamId"/>
   
    <input  value="${userObj.unitId}" id="healthunitId" type="hidden"  	/>
    <input  value="${userObj.circleId}" id="healthcircleId" type="hidden"  	/>
     <input  value="${userObj.divisionId}" id="healthdivisionId" type="hidden"  	/>
      <input  value="${userObj.subdivisionId}" id="healthsubdivisionId" type="hidden"  	/>
       <input  value="${userObj.designationId}" id="healthdesignationId" type="hidden"  	/>
    
    
    
    
    <input name="nextPostId" value="" id="nextPostIdhealth" type="hidden" class="mainnextPostId" />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="postIdhealth" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="nextEmpIdhealth" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="userempIdhealth" type="hidden"  	class="mainuserempId" />
								</c:if> 
                                       
                                       <div class="col-md-12">
			
                      <br>
						  <div class="col-md-2"></div>
                     
				
						<div class="col-md-8">
						<label class="label-controlPMS rowlebel ">Select
								Category: <font color=red>*</font>
							</label>
							<select class="form-control" id="deficiencyCategory" name="deficiencyCategory"
								required>
								<option value=" ">--select--</option>
								<option value="1">1-Deficiencies which may lead to failure</option>
								<option value="2">2-Major Deficiencies required for  prompt remediable measures</option>
								<option value="3">3-Minor remediable measures which are rectifiable during the year</option>
								


							</select>
						</div>
						
						<div class="col-md-2"></div>
						
						 <br>
						 </div>
						 
						   <div class="col-md-12">
			
                      <br>
			   <div class="col-md-2"></div>			 
					
    <div class="col-md-8">
    
     <label class="label-controlPMS rowlebel ">Select Inspection Date: <font
							color=red>*</font>
						</label>	
					
				<select class="form-control" id="healthinspectOfficeInfoId" name="inspectOfficeInfoId"
								required >
								

							</select>
					</div>
					
					 <div class="col-md-2"></div>	
					  <br>
					 
					 </div>		 
					
					 <div class="col-md-12">
						  <br>
						  
						  <div class="col-md-2"></div>
						
						
						<div class="col-md-8">	 
						<label class="label-controlPMS rowlebel ">Significant Deficiencies Noticed/Observations: <font color=red>*</font>
							</label>
						
				<textarea class="form-control" id="reshealth6remarks" 	name="remarks" rows="3" cols="50" placeholder="Observations" required></textarea>
					</div>
				  <div class="col-md-2"></div>	
					 <br>
						 
					  
						</div>   	
						
						<c:if test="${(userObj.unitId!=9 || userObj.unitId!=9832 || userObj.unitId!=4 || userObj.unitId!=9830)&&(userObj.designationId==2 || userObj.designationId==8) }">
					
						 <div class="col-md-12">
						 <br>
						
						 <button type="button" name="rescheckbutton5" id="resdamhealthbutton" class="btn btn-1 btn-primary center-block "  onclick="addresdamhealth(this.form.id,reshealtheditFlag.value,resresDamHealthId.value)" >Submit</button>
						 
						
						  <br>
						 </div>
						 
						 </c:if>
					</form:form>
					
					<div id="reshealth"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="healthtable5">
						<thead id="reshealthhead5"> </thead>
						
						<tbody id="reshealthbody5"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>
				
				
				</div>
				<%-- <div id="recommn">
				
				<form:form id="resann2form6" name="resann2form6name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
					
						
						<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId6" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId6" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId6" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId6" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId6" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId6" type="hidden" />
								 <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId6" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId6" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId6" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year6"
									type="hidden" />
									 <input name="reservoirInspectList[0].tabId" value="6" id="tabId6" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId6" type="hidden" /> 
                                           <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId6" type="hidden" /> 
                                <div class="col-md-12">             
                      <!--                      <div class="col-md-1">
                     
                     <input name="reservoirInspectList[0].resCheckboxId" 	class="rescustomcheck6" value="0"  id="resCheckboxId0" type="checkbox" />
                    
                     </div>  -->
                     
                     <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Latest Health Status: <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
						 <input name="reservoirInspectList[0].resDamHealthId" value="1" id="resDamHealthId" type="hidden" /> 
						
				<textarea class="form-control" id="reslatesthealth"  rows="3" cols="50" placeholder="Observations" readonly="readonly"> </textarea>
					</div>
					<div class="col-md-6"> 
    <label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>	
						</div>
						
						
    <div class="col-md-6">
					
					<input
				type="text" class=" datepick form-control datepicker" id="inspectDate" name="reservoirInspectList[0].inspectDate"
				placeholder="dateofoperation"  />
					</div>
					    <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Recommendations by SDSO /SDSIT : <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
				<textarea class="form-control" id="recomendbysdso" 	name="reservoirInspectList[0].recomendbysdso" rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					  
					</div>	
						
						
						 <br />
						 <button type="button" name="rescheckbutton6" id="rescheckbutton6" class="btn btn-1 btn-primary center-block rescheckbutton" >Submit</button>
						 
						 
					
					</form:form>
					
					 <div id="resrecommend"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table6">
						<thead id="thead6"> </thead>
						
						<tbody id="tbody6"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>    	
				
				
				</div> --%>
					<%-- <div id="ats">
					
					<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note1: Action taken status can be added by AEE only. </strong>
				

			</div>
			</div>
				
				<form:form id="resatsform" name="resatsformname"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="" style="overflow:hidden">
					
					<!-- start  -->
					
					<input name="projectId" value="0" class="mainprojId"
											id="resatsann2" type="hidden" />
											
											
								<input  value="0" 
											id="atsnewmst1Id" type="hidden" name="resInspectMst1Id" />
											<input  value="0" 
											id="atsnewmst2Id" type="hidden" name="resInspectMst2Id"  />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resats" type="hidden" />
							
								<input name="tankId" value="0"  class="maintankId"
									id="atstankId" type="hidden" />
						
								<input name="year" value="0" id="yearsta" class="mainyear"
									type="hidden" />
									
									<input name="resDamActionId" value="0" id="atsresDamActionId" 
									type="hidden" />
									
									
									
									 <input name="tabId" value="51" id="tabIdats" type="hidden" /> 
									   <input name="annexureId" value="0" id="annexureats" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyIdats" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamIdsta" type="hidden"  	class="mainconditionofDamId"/>
   
   <input name="editFlag" value="false" id="atseditFlag" type="hidden"  	/>
    
    
    
    
    <input name="nextPostId" value="" id="nextPostIdats" type="hidden" class="mainnextPostId" />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="postIdats" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="nextEmpIdats" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="userempIdats" type="hidden"  	class="mainuserempId" />
								</c:if> 
					
					<!-- end  -->
						
						               <div class="col-md-12">     
					
                     <br>
                  
    
    <div class="col-md-6">
     <label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>	
    
    <select class="form-control" id="resatc71inspectDate" name="inspectOfficeInfoId"
								required onchange="getResDamHealthDetailsByInspectInfo(this.value),getHealthRecommendationinfoId(this.value,atsnewmst1Id.value,atsnewmst2Id.value )  ">
								<option value=" ">--select--</option>
					
							</select>
					
				
					</div>
					
					<div class="col-md-6">	
						
						<label class="label-controlPMS rowlebel ">Category <font color=red>*</font>
							</label> 
						 <input name="resDamHealthId" value="0" id="atcresDamHealthId" type="hidden" /> 
						
				<textarea id="atchealthcategory" class="form-control"  rows="3" cols="50" placeholder="Observations" readonly="readonly"></textarea>
					</div>
               
           <br>
           </div>
           
					   <div class="col-md-12">     
					   <br>
			
						<div class="col-md-6">	 
						
						<label class="label-controlPMS rowlebel ">Observations / Significant Deficiencies Noticed: <font color=red>*</font>
							</label>	
				<textarea id="atchealthremarks" class="form-control"  rows="3" cols="50" placeholder="Observations" readonly="readonly"> </textarea>
					</div>
					
					
					 
						<div class="col-md-6">	 
						<label class="label-controlPMS rowlebel ">Recommendation: <font color=red>*</font>
							</label>
						 <input name="resannRecommendId" value="0" id="atcresRecommendId" type="hidden" /> 
						
				<textarea id="resrecommendats"  class="form-control"  rows="3" cols="50" placeholder="Observations" readonly="readonly"> </textarea>
					</div>
					 <br>
					 </div>
					 
					   <div class="col-md-12">   
					    <br> 

				
						  <div class="col-md-6">
						  <label class="label-controlPMS rowlebel ">Whether Action initiated  :<font
							color=red>*</font>
						</label>	
        <label class="radio-inline"> <input type="radio" class="myradio" name="actionTakeninit" id="atsactionTakeninitn"     value="false"  required  >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="actionTakeninit" id="atsactionTakeninity"     value="true"  required >Yes</label>
       
          
    </div>
    

						
						  <div class="col-md-6">	
						  <label class="label-controlPMS rowlebel ">Whether action completed  :<font
							color=red>*</font>
						</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="actionTakencomplete" id="atsactionTakencompleten"     value="false"  required  >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="actionTakencomplete" id="atsactionTakencompletey"     value="true" required  >Yes</label>
       
          
    </div>
    <br>
    </div>
      <div class="col-md-12">
				  <br>
						<div class="col-md-6">	 
						<label class="label-controlPMS rowlebel ">Remarks/Reasons for pending  : <font color=red>*</font>
							</label>
				<textarea class="form-control" id="atsremarks" 	name="remarks" rows="3" cols="50" placeholder="Observations" required></textarea>
					</div>
					<br>
					</div>
				<c:if test="${(userObj.unitId!=9 || userObj.unitId!=4 || userObj.unitId!=9832 || userObj.unitId!=9830) && (userObj.designationId==2 || userObj.designationId==8) }">		    	   
					<div class="col-md-12">	 
						 <br />
						  <br />
						 <button type="button" name="rescheckbutton7" id="rescheckbutton7" class="btn btn-1 btn-primary center-block " onclick="addactionStatusInfo(this.form.id,atseditFlag.value,atsresDamActionId.value)" >Submit</button>
						 </div>
						 </c:if>
					</form:form>
					
					
					 <div id="acttaken"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table7">
						<thead id="resatshead7"> </thead>
						
						<tbody id="resatsbody7"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>    	
				
				
				
				</div> --%>
				
				<div id="addDamRmks">
					
				<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note1: AEE/AE/DEE/EE/SE can add remarks. </strong>
				<br>
				<strong style="color:#CA3F22"> Note2: Include in the document will add remarks as part 1b to the final document in the report. </strong>
				<br>
				<strong style="color:#CA3F22"> Note3: Edit and delete options are available only to the respective designations. </strong>
				

			</div>
			</div>
			
   
	<form:form id="reviewformremann1" method="post" modelAttribute="rescheckObject"
		name="reviewformremann1name" data-parsley-validate-if-empty=""
		enctype="multipart/form-data" style="overflow:hidden">
		
		<div class="col-md-12 inDiv">
			
<!-- start of remarks form hidden data -->
				
       <input name="projectId" value="0" class="mainprojId"
											id="resprojectIdremann1" type="hidden" />
									
		<input name="resInspectMst1Id" value="0"  class="mainresInspectMst1Id"
									id="remresInspectMst1Id" type="hidden" />	
									
														 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirIdremann1" type="hidden" />
									
									<input name="tankId" value="0"  class="maintankId"
									id="maintankIdremann1" type="hidden" />
							
							
						
								<input name="year" value="0" id="yearremann1" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="6" id="tabIdremann1" type="hidden" /> 
									   <input name="annexureId" value="1" id="annexureIdrem" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyIdremann1" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamIdremann1" type="hidden"  	class="mainconditionofDamId"/>
   
   <input name="editFlag" value="false" id="damremarkseditflag" type="hidden"  	/>
   
   <input name="resRemarksMst1ReviewId" value="0" id="damannRemarksMst1ReviewId" type="hidden"  	/>
    
    
    
    
    <input name="nextPostId" value="" id="nextPostIdremann1" type="hidden" class="mainnextPostId" />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="postIdremann1" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="nextEmpIdremann1" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="userempIdremann1" type="hidden"  	class="mainuserempId" />
								</c:if> 
								
								<!-- end of remarks form hidden data -->
	
       <div class="col-md-12">
          
        
        <br>
						
	 <div class="col-md-2"></div>		
    
    <div class="col-md-8">
        <label class="label-controlPMS rowlebel ">Select Inspection Date: <font
							color=red>*</font>
						</label>	
					
				<select class="form-control" id="reminspectOfficeInfoId" name="inspectOfficeInfoId" onchange="getResInspectionbyinspectinfoId(this.value)"
								required>
								

							</select>
					</div>
		 <div class="col-md-2"></div>	
		 <br>
		 </div>		
		 
		   <div class="col-md-12">
          
        
        <br>
        
        <div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note1: click on Yes for adding part 1b information (i.e Please provide any additional information or comments not covered by Part 1a from above)  </strong>
				<br>
				<strong style="color:#CA3F22"> Note2: click on NO for General remarks </strong>
				<br>
				
				

			</div>
			</div>
			
        
        	 <div class="col-md-2"></div>		
	
    <div class="col-md-8">
    
      <label class="label-controlPMS rowlebel ">Include Remarks in the Document: <font
							color=red>*</font>
						</label>	
					
				
	<label class="radio-inline"> <input type="radio" class="myradio" name="remarksinclindoc" id="remarksinclindocn"  checked="checked"   value="false"   >NO</label>
      <label class="radio-inline"> <input type="radio" class="myradio" name="remarksinclindoc" id="remarksinclindocy"     value="true"   >Yes</label>

					</div>
					
						 <div class="col-md-2"></div>	
					
					<br>
					
					</div>
		  <div class="col-md-12">	
		  <br>	
			 <div class="col-md-2"></div>	
		<div class="col-md-8">
			<label class="label-control rowlebel "> Remarks</label>
		
			<textarea class="form-control" id="remarksremann1"
				name="remarks" rows="3" cols="50"
				placeholder="Review Details" required></textarea>
		</div>
			 <div class="col-md-2"></div>
			 <br>	
		
		</div>
		
		<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="inspectcaptcha_idr" name="imgCaptcha" src="../captcha2.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('inspectcaptcha_idr').src = '../captcha2.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="inspectcaptcha_idr1" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
								</div>
	

  <c:if test="${(userObj.unitId!=9 || userObj.unitId!=4 || userObj.unitId!=9832 || userObj.unitId!=9830)  }">

		<div class="col-md-12">
		
				<label class="label-control rowlebel "></label>
				
				 <button type="button" name="rmksreviewbutton" id="damannareviewinfoid" class="btn btn-1 btn-primary center-block " onclick="AddRemarksInfo(this.form.id,damremarkseditflag.value)" >Submit</button>
				<!-- <input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block reviewbutton" id="damannareviewinfoid" 
					value="Add Remarks"    onclick="AddRemarksInfo(this.form.id,damremarkseditflag.value)"><br><br>	 -->	
		</div>
		</c:if>
		
		
		</div>

	</form:form>
	
	
	 <div id="rmks"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table7">
						<thead id="resrmkshead4"> </thead>
						
						<tbody id="resrmksbody4"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>    	
				


					
					
					</div>
					
					<div id="addinspectpht">

<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note1: Inspection Photos/Documents can be added by AEE/AE only. </strong>
				
				

			</div>
			</div>

<form:form id="adddocrec" name="adddocrecinf"
								modelAttribute="resinspectdatainfo" method="post" class="resinsectform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" style="overflow:hidden" >
								
								
								<!-- start of remarks form hidden data -->
				
       <input name="projectId" value="0" class="mainprojId"
											id="resprojectIdpht" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirIdpht" type="hidden" />
									
									<input name="tankId" value="0"  class="maintankId"
									id="maintankIdpht" type="hidden" />
							
							<input name="resInspectMst1Id" value="0"  class="mainresInspectMst1Id"
									id="phtresInspectMst1Id" type="hidden" />	
						
								<input name="year" value="0" id="yearpht" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="3" id="tabIdpht" type="hidden" /> 
									   <input name="annexureId" value="1" id="annexureIdpht" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyIdpht" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamIdpht" type="hidden"  	class="mainconditionofDamId"/>
    
    
    
    
    <input name="nextPostId" value="" id="nextPostIdpht" type="hidden" class="mainnextPostId" />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="postIdpht" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="nextEmpIdpht" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="userempIdpht" type="hidden"  	class="mainuserempId" />
								</c:if> 
								
								<!-- end of remarks form hidden data -->
								
								

 	 <div class="col-md-12 invDiv fphtedit">
 	 
 	 
 	 <div class="col-md-12">
          
        
        <br>
         <div class="col-md-2"></div>

    <div class="col-md-8">
     <label class="label-controlPMS rowlebel ">Select Inspection Date: <font
							color=red>*</font>
						</label>	
					
				<select class="form-control" id="inspectphtInfoId" name="inspectOfficeInfoId" onchange="getResInspectionbyinspectinfoId(this.value)"
								required>
								

							</select>
					</div>
					
					  <div class="col-md-2"></div>
					
				
					    <br>
						
		
		</div>
 	 
 	 <div class="col-md-12">
 	 <br>
 	 <div class="col-md-2"></div>
 	 
 	
 	 
 	
 	 
 	   <div class="col-md-8">
 	    <label class="label-controlPMS rowlebel ">Document Title</label>
 	 
 	  <input name="docTitle"    id="docTitle"   type="text"  	class="form-control" />
 	  
 	  </div>
 	  	 <div class="col-md-2"></div>
 	  
 	   <br>
 	  
 	  </div>
 	  <div class="col-md-12">
 	  <br>
 	  <br>
 	  <div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note2: All Images/documents size should be less than 2MB. Image format allowed are .jpeg,.jpg,.png.,.pdf </strong>
				
				

			</div>
			</div>
			</div>
 	 
							<div class="col-md-12">
							<br>
							 <div class="col-md-2"></div>
					
										 
										  <div class="col-md-8"  >
										  <label class="label-controlPMS rowlebel ">Upload Photos(Multiple)/Documents</label>
								<input id="resinspectPhotosnew" name="uploadPhotos" type="file" 	class="btn-info" value="Upload Documents"  multiple="multiple"  required  data-parsley-max-file-size="2048"  data-parsley-fileextension='jpeg,jpg,png,pdf'  > 
							</div>
							 <div class="col-md-2"></div>
							<br>
							</div>
							
							
							
						
							
							<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="photocaptcha_id" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('photocaptcha_id').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
												<br>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="photocaptcha_id1" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
						<c:if test="${((userObj.unitId!=9 || userObj.unitId!=4 || userObj.unitId!=9832 || userObj.unitId!=9830)  && (userObj.designationId==2 || userObj.designationId==8))}">	
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="addmichecks11" id="addmichecks11" onclick="addphotosdatafn(this.form.id)"
									class="btn btn-1 btn-primary center-block ">Submit</button>
									</div>
									
									</c:if>
							
							</div> 
							
	</form:form>
	
	
	 <div id="inspectphtup"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table7">
						<thead id="resinspecthead5"> </thead>
						
						<tbody id="resinspectbody5"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>   							




 

</div>

				</div> <!-- r12 -->

			 </div>
			<!-- col-md-8 div -->

		</div>
		<!-- container div -->

</div> <!-- panelbody -->
	</div>
	<!-- panel div -->


	<!-- data ends -->
</div>



<!--  dilogue starts -->


<div id="getprojects_dialogue">

	<form:form id="getprojects" method="post" modelAttribute="getprojectsdata"
		name="getprojdescform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="viewprojectsdata">
								<div class="show-grid gridList "
									style="display: block">
									<div class="table-responsive" >
										<table class=" display table-bordered tanktable" style="width: 100%"
											id="viewresdataid">
											<thead id="viewprojectsdatahead">
											<tr style="font-weight: bold;"> 
											<!-- <th>S.No.</th> -->
											<th>Project</th>
											
											<th>Reservoirs</th>
																			
										
											
											
											
											
											
											 </tr>

											</thead>


											<tbody id="viewprojectsdatabosy">
											
											<c:forEach items="${projectList}" var="t" varStatus="count">
									
									            
																						
											<c:choose>
											<c:when test="${reservoirList!=null }">
											
										
												
												<c:forEach items="${reservoirList}" var="m" varStatus="count">
												
												
												
												<c:choose>
												<c:when test="${m.projectId==t.projectId}">
												
												 <tr>
												<td style="color: blue;"><c:out value="${t.projectName}"></c:out></td>
												<td>
										
												
												<table class="table-bordered">
												<tr>
												<td>${m.resName}</td>
												
												<td><button type="button" name="selectproject" id="selectProjectsdata${count.count}" 
																	class="btn btn-1 btn-primary center-block"  onclick="showprojectsdata('${t.projectName}',${t.projectId},${m.reservoirId},'${m.resName}',${m.unitId},4,'${m.nrldCode}')" >Select Reservoir</button></td>
																	</tr>
													</table>
												
												
												
												 </td>	
												 	</tr>			
												</c:when>
												
												
												
												</c:choose>
												</c:forEach>
											
												
												
												</c:when>
													
												
												</c:choose>
												
											
												
												
											
												
												
										
												
												
												
												
									
										
									
										
									
										</c:forEach>
									
											

											</tbody>
										</table>
									</div>


								</div>
							</div>
							
		
		

	
						

							
							
							
						

	</form:form>
	


</div>


<div id="addresloc_dialogue">

	<form:form id="addresloc" method="post" modelAttribute="addreslocdata"
		name="addreslocform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		<input type="hidden" class="form-control"  id="reseditFlag"  value="false" />
		  <input id="resProjectId" value="0" name="projectId"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="hidden" />
		<input id="resselectedMandalId" value="0"   class=" form-control "  type="hidden" />
		<input id="resselectedVillageId" value="0"   class=" form-control "  type="hidden" />
		
		<input id="resselectedDistrictId" value="0"   class=" form-control "  type="hidden" />
		
		
		
		<input id="reservoirId" value="0"  name="reservoirId" class=" form-control "  type="hidden" />
		
		<div class="col-md-12 invDiv">
		<div class="col-md-12">
		
		<div class="col-md-3">
							
							
							
								
											
								<label class="label-control rowlebel ">Reservoir Name:
										<font color=red>*</font>
									</label>
									
									<input id="resdianew" value="" name="resName"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly" />
									
								</div>	
									<div class="col-md-3">
										<label class="label-control rowlebel ">Select District:
										<font color=red>*</font>
									</label>
									
										<select class="form-control" id="resdistrictId" name="districtId" 
							  required onchange="getMandals(this.value,1)">
							<%-- <option value=" ">--select--</option>
							<c:forEach items="${districtsList}" var="d">							
									<option value="${d.districtId}" >${d.districtName}</option>
								
								</c:forEach> --%>
							
						

						</select>
						</div>
							
						<div class="col-md-3">
										<label class="label-control rowlebel ">Select Mandal:
										<font color=red>*</font>
									</label>
									
										<select class="form-control" id="resmandalId" name="mandalId" 
							 required onchange="getVillages(resdistrictId.value,this.value,1)">
							

						</select>
						</div>
							
						
						<div class="col-md-3">
										<label class="label-control rowlebel ">Select Village:
										
									</label>
									
										<select class="form-control" id="resvillageId" name="villageId" 
							 >
						
						

						</select>
						
						<br>
						</div>
							</div>
							<div class="col-md-12">
							<div class="col-md-8">
							
								
											
								<label class="label-control rowlebel ">(If Village is not in the above list then use this column)Village Name:
										
									</label>
									
									<input id="resreamarksVillageName" value="" name="remarksVillage"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
										<br>
									</div>
									
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="resnrldcaptcha_id" name="imgCaptcha" src="../captcha2.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('resnrldcaptcha_id').src = '../captcha2.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="resnrldcaptcha_id1" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
								</div>
						
						<div class="col-md-12">
						<br>
						
						<button type="button" name="submitResinfo" id="submitRes" 
																	class="btn btn-1 btn-primary center-block" onclick="updateReservoirLocation()"  >Submit</button>
						
						</div>
		
		
				
			</div>			

	</form:form>
	


</div>


<div id="addrecommend_dialogue">

	<form:form id="addrecpmmend" method="post" modelAttribute="addrecomnddata"
		name="addrecommendform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		<input id="rec2resInspectMst1Id" value="0"  name="resInspectMst1Id"  class=" form-control "  type="hidden" />
		
		<input id="rec2resInspectMst2Id"   value="0"   name="resInspectMst2Id" class=" form-control "  type="hidden" />
		
		<input id="rec2resDamHealthId"   value="0"   name="resDamHealthId" class=" form-control "  type="hidden" />
		
		<input id="selectedhealthinspectOfficeId"   value="0"  class=" form-control "  type="hidden" />
		
		<input id="rec2checkId"   value="0"  class=" form-control "  type="hidden" />
		
		<input id="annreseditflag"   value="false"  class=" form-control "  name="editFlag" type="hidden" />
		
		
		<input id="rec2resannRecommendId"   value="0"   name="resannRecommendId" class=" form-control "  type="hidden" />
		
	
		
		<div class="col-md-12 invDiv">
		
		<div class="col-md-12">
						
						<br>
									<br>
									<div class="col-md-6">

										<label class="label-control rowlebel " for="parameter1">
											Select Inspecting officers<font
											color=red>*</font></label> 
											</div>
										<div class="col-md-6">	
											<select class="form-control" id="rec2inspectOfficeInfoId"
											name="inspectOfficeInfoId" required>
											<!-- <option value=" ">--select--</option>
											<option value="1">DSRP(Dam safety review panel)(28/09/2022)</option>
											<option value="2">SDSO (06/07/2022)</option>
											<option value="3">SDSIT / Technical committee(04/04/2022)</option>
											<option value="4">Project Authority(01/02/2022)</option>
											 -->



										</select>
										</div>
										
										
										
										<br>
									<br>
										
										</div>
				<div class="col-md-12">
				
				
				<div class="col-md-6">
							
								
								<label class="label-control rowlebel "> Recommendation
										<font color=red>*</font>
									</label>
							
								</div>	
									<div class="col-md-6">
										<textarea class="form-control" id="damannrecemremarks" 	name="remarks" rows="3" cols="50" placeholder="Recommendation"></textarea>
						</div>
				
				</div>	
				
				<div class="col-md-12">
				<button type="button" name="selectrecm" id="selectProjectsdatarecm" 
																	class="btn btn-1 btn-primary center-block"  onclick="AddRecommendationInfo(this.form.id,annreseditflag.value,rec2checkId.value,1)" >Submit</button>					
				</div>						
		
		</div>
		
		
		
		</form:form>



</div>


<div id="addhealthremarks_dialogue">
					
					<form:form id="addrecpmmendhealth" method="post" modelAttribute="addrecpmmendhealthdata"
		name="addrecommendform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		<input id="healthresInspectMst1Id" value="0"  name="resInspectMst1Id"  class=" form-control "  type="hidden" />
		
		<input id="healthresInspectMst2Id"   value="0"   name="resInspectMst2Id" class=" form-control "  type="hidden" />
		
		<input id="healthresDamHealthId"   value="0"   name="resDamHealthId" class=" form-control "  type="hidden" />
		<input id="healthOfficeInfoId"   value="0"   name="inspectOfficeInfoId" class=" form-control "  type="hidden" />
		
		<input id="healtheditFlag"   value="false"   name="editFlag" class=" form-control "  type="hidden" />
		
		<input id="healthannRecommendId"   value="0"   name="resannRecommendId" class=" form-control "  type="hidden" />
		

		
		
		
		
		<div class="col-md-12 invDiv">
		
		<div class="col-md-12">
						
						<br>
									<br>
									<div class="col-md-6">

										<label class="label-control rowlebel " for="parameter1">
										 Inspect office<font
											color=red>*</font></label> 
											</div>
										<div class="col-md-6">	
											
                           <input id="inspectInfo" value="0"   class=" form-control "  type="text"  readonly="readonly" />
									
										</div>
										
										<br>
									<br>
										
										</div>
				<div class="col-md-12">
				
				
				<div class="col-md-6">
							
								
								<label class="label-control rowlebel "> Remedial Measures
										<font color=red>*</font>
									</label>
							
								</div>	
									<div class="col-md-6">
										<textarea class="form-control" id="recemremarks" 	name="remarks" rows="3" cols="50" placeholder="Recommendation"></textarea>
						</div>
				
				</div>	
				
				<div class="col-md-12">
				<br>
				<br>
				<button type="button" name="selectrecm" id="selectProjectsdatarecm" 
																	class="btn btn-1 btn-primary center-block"  onclick="AddRecommendationInfo(this.form.id,healtheditFlag.value,healthresDamHealthId.value,2 )" >Submit</button>					
				</div>						
		
		</div>
		
		
		
		</form:form>
					
					</div>


<div id="reccheck_doc_update">

<div id="reccheckupdate">

<form:form id="adddocrec" name="adddocrecinf"
								modelAttribute="resinspectdatainfo" method="post" class="resinsectform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

 	 <div class="col-md-12 invDiv fphtedit">
					   <div class="col-md-6"  >
										 <label class="label-controlPMS rowlebel ">Upload Photos(Multiple)</label>
										 
										 <input name="resInspectMst1Id" value="0" readonly="readonly" 
											class=" form-control " id="resphtInspectMst1Id" type="hidden" />
											<input name="resInspectMst2Id" value="0" readonly="readonly" 
											class=" form-control " id="resphtInspectMst2Id" type="hidden" />
										 </div>
										 
										  <div class="col-md-6"  >
								<input id="resinspectPhotosnew" name="uploadPhotos" type="file" 	class="btn-info" value="Upload Documents"  multiple="multiple"  required  data-parsley-max-file-size="2048"  data-parsley-fileextension='jpeg,jpg,png'  > 
							</div>
							
							
							<br></br>
							
							<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="photocaptcha_id" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('photocaptcha_id').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="photocaptcha_id1" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="addmichecks11" id="addmichecks11" onclick="updatephotosdatafn(this.form.name)"
									class="btn btn-1 btn-primary center-block frmphotobutton">Submit</button>
									</div>
							
							</div> 
	</form:form>							
</div>



 

</div>


<div id="res_basic_info">



<div id="recbasicupdate">

<!-- <ul>
				 	<li><a href="#daminfo" >Dam info </a></li>
					<li><a href="#conlevel" > Controlling Level</a></li>
					
					
				</ul> -->
				
				
	
<!-- 	<div id="conlevel"> -->

<form:form id="adddamcontrolinf" name="adddamcontrolinfdata"
								modelAttribute="resinspectdatainfo" method="post" class="resinsectform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

<!-- start of hidden values  -->

 <input name="tankId" value="0" readonly="readonly" 
											class=" form-control " id="dmctrltankdata" type="hidden" /> 
											
											<input  value="false" 
											class=" form-control " id="damctrleditFlag" type="hidden" />
<!-- end of hidden values -->

<input name="reservoirId" value="0" readonly="readonly" 
											class=" form-control " id="dmctrlreservoirIddata" type="hidden" /> 


<input  value="${userObj.unitName }" readonly="readonly" 
											class=" form-control " id="userdamunitName" type="hidden" /> 
											
											<input  value="${userObj.divisionName }" readonly="readonly" 
											class=" form-control " id="userdamdivisionName" type="hidden" /> 
											
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Click on Edit , if required to change the information shown. </strong>
				<br>
				<strong style="color:#CA3F22"> Note: Check reference for hazard classification. </strong>
								

			</div>
			</div>

 	 <div class="col-md-12 invDiv fphtedit">
 	 
 	 <div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Dam Type:
										
									</label>
									
									
									<select class="form-control " id="typeOfDamId" name="typeOfDamId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Earthen</option>
								<option value="2">2-Composite</option>
								<option value="3">3-Concrete / Masonry</option>
							
								


							</select>
									
									<!-- <input id="typeOfDam" value="" name="typeOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> -->
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Dam Purpose:
										
									</label>
									
									<select class="form-control " id="damPurposeId" name="damPurposeId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Irrigation</option>
								<option value="2">2-Multipurpose</option>
								
							
								


							</select>
									
								<%-- 	<input id="damPurpose" value="${userObj.divisionName}" name="damOperator"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> --%>
											</div>
									</div>
									
									
									<div class="col-md-12">
									
									<div class="col-md-6">
											
								<label class="label-control rowlebel ">Commissioning Date (dd/mm/yyyy):
										
									</label>
									
									<input id="commisionDate" value="" name="commisionDate"   style="color:blue; font-weight: bold;"
											class=" form-control datepicknew "  type="text"  readonly="readonly"  required/>
											</div>
							
								<div class="col-md-4">
											
								<label class="label-control rowlebel ">Hazard Classification (Note:click on Reference):
										
									</label>
									
									<select class="form-control " id="hazardClassId" name="hazardClassId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-High hazard dam</option>
								<option value="2">2-Significant hazard dam</option>
								<option value="3">3-Low hazard dam</option>
							
								


							</select>
									
									<!-- <input id="hazardClass" value="" name="hazardClass"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> -->
											</div>
											
											<div class="col-md-2"  >
							 <label class="label-control rowlebel ">
									</label>
								<button type="button" name="addmichecks11" id="refdemores" 
									class="btn btn-1 btn-primary center-block ">Reference</button>
									</div>	
										
										<br><br>	
									</div> 
					   
								<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">TBL RL (meters):
										
									</label>
									
									<input id="trlLevel" value="" name="trlLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly" required  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">MWL RL (meters):
										
									</label>
									
									<input id="mwlLevel" value="" name="mwlLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" required  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
											</div>
									</div>	
									
									
									<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">FRL RL (meters):
										
									</label>
									
									<input id="frlLevel" value="" name="frlLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly"  required data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12" />
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Spillway Crest RL (meters):
										
									</label>
									
									<input id="spillWayCrestLevel" value="" name="spillWayCrestLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" required  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
											</div>
									</div>	
									
									<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">MDDL RL (meters):
										
									</label>
									
									<input id="mddlLevel" value="" name="mddlLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" required data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12" />
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Lowest River bed RL (meters):
										
									</label>
									
									<input id="lowestRiverBed" value="" name="lowestRiverBed"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly"  required  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12" />
											</div>
									</div>	
									
									
									
									<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Deepest foundation level RL (meters):
										
									</label>
									
									<input id="deepestfoundationLevel" value="" name="deepestfoundationLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly" required data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12" />
											</div>
											
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Gross Storage at FRL (MCM):
										
									</label>
									
									<input id="grossStorageatFrl" value="0" name="grossStorageatFrl"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly" required  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
											</div>
											
											
									</div> 
									
									<div class="col-md-12" id="latlong">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Reservoir Latitude:
										
									</label>
									<div class="col-md-12">
									<div class="col-md-4">
									<label class="label-control rowlebel ">Degrees:
										
									</label>
									<input id="res_lat_d" value="" name="res_lat_d"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly"  />
											</div>
											<div class="col-md-4">
											<label class="label-control rowlebel ">Minutes:
										
									</label>
											<input id="res_lat_m" value="" name="res_lat_m"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly"  />
											</div>
											<div class="col-md-4">
												<label class="label-control rowlebel ">Seconds:
										
									</label>
											<input id="res_lat_s" value="" name="res_lat_s"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly"  />
											</div>
											</div>
											</div>
											
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Reservoir Longitude:
										
									</label>
										<div class="col-md-12">
									<div class="col-md-4">
									<label class="label-control rowlebel ">Degrees:</label>
									<input id="res_long_d" value="" name="res_long_d"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly"  />
											</div>
											
											<div class="col-md-4">
											<label class="label-control rowlebel ">Minutes:
										
									</label>
											<input id="res_long_m" value="" name="res_long_m"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly"  />
											</div>
											<div class="col-md-4">
											<label class="label-control rowlebel ">Seconds:
										
									</label>
											<input id="res_long_s" value="" name="res_long_s"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly"  />
											</div>
											</div>
											</div>
											
									</div> 
										
							<br></br>
							
							<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="contcaptcha_id" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('contcaptcha_id').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="contcaptcha_id1" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
								
							
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="addmichecks11" id="damcontrolinf" onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)"
									class="btn btn-1 btn-primary center-block frmphotobutton">Edit</button>
									</div>
						
							</div> 
	</form:form>	
	
	
	<div class="col-md-12"></div>
	<!-- </div>			 -->			
</div>



 

</div>


<div id="rescheck_doc_dia">

<div id="rescheckdocinf">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="doc-frm-table-10">
											<thead id="doc-thead10">

											</thead>


											<tbody id="doc-tbody10">

											</tbody>
										</table>
									</div>


								</div>
							</div>



 

</div>



<%-- <div id="addinspect_dialogue">

	<form:form id="addinspect" method="post" modelAttribute="addinspectdata"
		name="addinspectform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div class="col-md-12 invDiv">
		<div class="col-md-12">
		
		
		<div class="col-md-12">
						
						<br>
									<br>
									<div class="col-md-6">

										<label class="label-control rowlebel " for="parameter1">
											Select Inspecting officers<font
											color=red>*</font></label> 
											</div>
										<div class="col-md-6">	
											<select class="form-control" id="inspectOfficerList"
											name="inspectOfficerList" required>
											<option value=" ">--select--</option>
											<option value="1">DSRP(Dam safety review panel)</option>
											<option value="2">SDSO</option>
											<option value="3">SDSIT / Technical committee</option>
											<option value="4">Project Authority</option>
											



										</select>
										</div>
										
										<br>
									<br>
										
										</div>
											
										
									
									
							
				
		
		<div class="col-md-6">
							
							
							
								
											
								<label class="label-control rowlebel "> Name and designation of the Inspecting officers
										<font color=red>*</font>
									</label>
									
									
									
								</div>	
									<div class="col-md-6">
										<textarea class="form-control" id="restab5remarks" 	name="reservoirInspectList[0].remarks" rows="3" cols="50" placeholder="Name1(Designation1),Name2(Designation2)"></textarea>
						</div>
						</div>
						
						<div class="col-md-12">
						
						<br>
									<br>
						
						
								<div class="col-md-6">
							
							
							
								
											
								<label class="label-control rowlebel "> Name and designation of the field officers present
										<font color=red>*</font>
									</label>
									
									
									
								</div>	
									<div class="col-md-6">
										<textarea class="form-control" id="restab5remarks" 	name="reservoirInspectList[0].remarks" rows="3" cols="50" placeholder="Name1(Designation1),Name2(Designation2)"></textarea>
						</div>
							
							
					
							
						
						
							</div>
							
								<div class="col-md-12">
									<br>
									<br>
							
							
															<div id="yearid" class="col-md-6 insdate">
																<label class="label-control rowlebel ">Inspect Date: <font color=red>*</font>
																</label> <input type="text"
																	class=" datepick form-control datepicker "
																	id="inspectDate"
																	name="inspectDate"
																	placeholder="dateofoperation" value="0" readonly="readonly"/>
															</div>
															
																<div id="yearid" class="col-md-6 insdate">
																<label class="label-control rowlebel ">Reservoir water level <font color=red>*</font>
																</label> <input type="text"
																	class="  form-control  "
																	id="waterlevel"
																	name="waterlevel"
																	placeholder="dateofoperation" value="0" />
															</div>
															</div>
							
					
							<div class="col-md-12">
							
							<br>
									<br>
						
						
								<div class="col-md-6">			
								
											
								<label class="label-control rowlebel ">Does the officer-in-charge of the operation and maintenance of dam posses all the records as given in the Annexure-I
										<font color=red>*</font>
									</label>
									
									
								
								</div>									
									
									
						
						  <div class="col-md-6">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompleten"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompletey"     value="true"   >Yes</label>
       
          
    </div>
					
							
									
							</div>
							
							<div class="col-md-12">
						
						<br>
									<br>
						
						
								<div class="col-md-6">
							
							
							
								
											
								<label class="label-control rowlebel "> When and whom was the dam inspected
										<font color=red>*</font>
									</label>
									
									
									
								</div>	
									<div class="col-md-6">
										<textarea class="form-control" id="restab5remarks" 	name="reservoirInspectList[0].remarks" rows="3" cols="50" placeholder="Name1(Designation1),Date,Name2(Designation2),Date"></textarea>
						</div>
							
							
					
							
						
						
							</div>
							
							
							<div class="col-md-12">
							
							<br>
									<br>
						
						
								<div class="col-md-6">			
								
											
								<label class="label-control rowlebel ">Are the items ponted out during the last Inspectoin properly attended to? (If not state deficiencies yet to be corrected)
										<font color=red>*</font>
									</label>
									
									
								
								</div>									
									
									
						
						  <div class="col-md-3">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompleten"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompletey"     value="true"   >Yes</label>
       
          
    </div>
     <div class="col-md-3">
										<textarea class="form-control" id="restab5remarks" 	name="reservoirInspectList[0].remarks" rows="3" cols="50" placeholder="Reasons"></textarea>
						</div>
					
							
									
							</div>
							
							<div class="col-md-12">
							
							<br>
									<br>
						
						
								<div class="col-md-6">			
								
											
								<label class="label-control rowlebel ">Whether Vigilence and Watch & Ward are provided
										<font color=red>*</font>
									</label>
									
									
								
								</div>									
									
									
						
						  <div class="col-md-3">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompleten"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompletey"     value="true"   >Yes</label>
       
          
    </div>
    
    <div class="col-md-3">
										<textarea class="form-control" id="restab5remarks" 	name="reservoirInspectList[0].remarks" rows="3" cols="50" placeholder="Reasons"></textarea>
						</div>
					
							
									
							</div>
							
							<div class="col-md-12">
							
							<br>
									<br>
						
						
								<div class="col-md-6">			
								
											
								<label class="label-control rowlebel ">Have the observations of inspecting officer in respect of all the dam components are easily furnished as given in the annexure-II
										<font color=red>*</font>
									</label>
									
									
								
								</div>									
									
									
						
						  <div class="col-md-6">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompleten"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompletey"     value="true"   >Yes</label>
       
          
    </div>
					
							
									
							</div>
							
							
							
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="rescaptcha_id" name="imgCaptcha" src="../captcha2.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('rescaptcha_id').src = '../captcha2.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="rescaptcha_id1" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
								</div>
						
						<div class="col-md-12">
						<br>
						
						<button type="button" name="submitinspectinf" id="submitinspectinf" 
																	class="btn btn-1 btn-primary center-block" onclick="addInspectinf()"  >Submit</button>
						
						</div>
		
		
				
			</div>			

	</form:form>
	


</div> --%>


<div id="gettanks_dialogue">

	<form:form id="gettanks" method="post" modelAttribute="gettanks"
		name="getanksdescform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="viewtanksdata">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered tanktable" style="width: 100%"
											id="viewtanksdataid">
											<thead id="viewtanksdatahead">
											<tr style="font-weight: bold;"> 
											<td>S.No.</td>
											<td>District</td>
											<td>Mandal</td>
											<td>Constituency</td>		
											<td>Village</td>
											<td>Habitation</td>												
											<td>TankCode</td>											
											<td>Tank Name</td>											
											<td>Action</td>
											
											
											
											
											
											 </tr>

											</thead>


											<tbody id="viewtanksdatabosy">
											
											<c:forEach items="${tanksList}" var="t" varStatus="count">
										<%--   <c:if test="${t.unitId>0&&t.circleId<=0&&t.divisionId<=0}">	 --%>
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
											  
											
												<td style="color: blue;"><c:out value="${t.districtName}"></c:out></td>
											
											
												<td><c:out value="${t.mandalName}"></c:out></td>
												<td><c:out value="${t.constName}"></c:out></td>
												<td><c:out value="${t.villageName}"></c:out></td>
												<td><c:out value="${t.habitationName}"></c:out></td>
																						
												
											
												
												
											
												
												<td><c:out value="${t.tankCode}"></c:out></td>
												
												<td><c:out value="${t.tankName}"></c:out></td>
												
												<%-- <td><c:out value="${t.mandalId}"></c:out>--<c:out value="${t.villageId}"></c:out>--<c:out value="${t.habitationId}"></c:out>--<c:out value="${t.acCode}"></c:out></td> --%>
												<%-- getrepairdata('${t.tankId}'), gettankfeeddata(${t.tankId}), --%>
												<td><button type="button" name="selectTank" id="selectTankdata${count.count}" 
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata('${t.tankName}','${t.tankId}','${t.tankCode}','${t.newDistrictId}','${t.mandalId}','${t.villageId}','${t.acCode}','${t.habitationId}','${t.mandalName}','${t.villageName}',1,'${t.nrldCode}'),gettankgeotaglist('${t.tankId}')" >Select Tank</button></td>
												
												
											<!-- , -->
												
												<%-- <button type="button" name="selectTank" id="selectTankdata${count.count}" 
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata(${t.tankId},${t.tankName})" >Select Tank</button>
											 --%>
												
												
												
												
												
										</tr>
										
									
										
									
										</c:forEach>
									
											

											</tbody>
										</table>
									</div>


								</div>
							</div>
							
		
		

	
						

							
							
							
						

	</form:form>
	


</div>


<div id="editdamtatus_dialogue">

	<form:form id="editdamstatusid" method="post" modelAttribute="damstatus"
		name="editcriticalform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
<input name="resInspectMst1Id" value="0"
									id="editcriticalMst1Id" type="hidden" class="mainresInspectMst1Id" />
									
								
   <div class="row" id="editcritical" >
								
									<div class="col-md-6">
																<label class="label-control rowlebel ">Over all condition of Dam:<font color=red>*</font>
																</label>
																</div>
																<div class="col-md-6"> <select class="form-control"
																	id="editdamStatusId"
																	name="conditionofDamId" required>
																	<option value=" ">--select--</option>
																	<option value="1">Un satisfactory</option>
																	<option value="2">Poor</option>
																	<option value="3">Fair</option>
																	<option value="4">Satisfactory</option>



																</select>
																</div>
																
																
									 
																	<div class="col-md-4">
																
																<button type="button" name="edittankStatus" id="editcriticalStatus"  style="text-align: center;"
																	class="btn btn-1 btn-primary center-block  " onclick="submitcriticalstatus()">Submit</button>
															</div>
								

							</div>
	
	</form:form>

</div>

 <div id="getrecommendation_dialogue">

	<form:form id="getrecommendationinfo" method="post" modelAttribute="getrecommends"
		name="getrecommendsform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="viewrevommends">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered " style="width: 100%"
											id="viewrecdataid">
											<thead id="viewrecdatahead">
											
											</thead>


											<tbody id="viewrecdatabody">
											
											
											</tbody>
										</table>
									</div>


								</div>
							</div>
							
		
		
	</form:form>
	
</div> 

<div id="res_salient_info">



<div id="recsalientupdate">


		
		
		<!-- <button class="tablink" onclick="openTab(event, 'Tab1')">Salient Features of the Dam</button> -->

		
		 <ul>
  <li> <a  href="#Tab1" onclick="document.getElementById('salientcaptcha_id1').src = '../captcha3.jpg?' + Math.random();  return false" >Salient Features of the Dam</a> </li>
    <li> <a href="#Tab2" onclick="document.getElementById('salientcaptcha_id2').src = '../captcha3.jpg?' + Math.random();  return false" >Gallery</a>   </li>
    <li>  <a href="#Tab3"  onclick="document.getElementById('salientcaptcha_id3').src = '../captcha3.jpg?' + Math.random();  return false">Gates</a>   </li>
    <li>  <a href="#Tab4" onclick="document.getElementById('salientcaptcha_id4').src = '../captcha3.jpg?' + Math.random();  return false">Operation & Maintenance Manual</a>   </li>
    <li>  <a href="#Tab5" onclick="document.getElementById('salientcaptcha_id5').src = '../captcha3.jpg?' + Math.random();  return false" >Silting of Reservoir</a> </li>
   <!--  <li> <a href="#Tab6" onclick="document.getElementById('salientcaptcha_id6').src = '../captcha3.jpg?' + Math.random();  return false">Leakage through the Dam Body</a>  </li> -->
    <li>  <a href="#Tab7" onclick="document.getElementById('salientcaptcha_id7').src = '../captcha3.jpg?' + Math.random();  return false" >Structural Safety Assessment</a> </li>
    <li>  <a href="#Tab8" onclick="document.getElementById('salientcaptcha_id8').src = '../captcha3.jpg?' + Math.random();  return false">Dam Break Analysis</a> </li>
    <li>  <a href="#Tab9" onclick="document.getElementById('salientcaptcha_id9').src = '../captcha3.jpg?' + Math.random();  return false" >Emergency Action Plan</a>  </li>
     
     </ul>
	


<div id="Tab1" class="tabcontent">

<form:form id="addsalientinf1" name="adddamsalientinfdata1"
								modelAttribute="resinspectsalientinfo" method="post" class="ressalientform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

<!-- start of hidden values  -->

 <input name="tankId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalienttankdata1" type="hidden" /> 
											
<input  value="false" 
											class=" form-control " id="damsalienteditFlag1" type="hidden" />
<!-- end of hidden values -->

<input name="reservoirId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalientreservoirIddata1" type="hidden" /> 


<input  value="${userObj.unitName }" readonly="readonly" 
											class=" form-control " id="usersalunitName1" type="hidden" /> 
											
<input  value="${userObj.divisionName }" readonly="readonly" 
											class=" form-control " id="usersaldivisionName1" type="hidden" /> 

	 <div class="col-md-12 invDiv fsalientedit">
 	 
 	 
							
   <div class="col-md-12">
 	 
 	 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Salient Features of the Dam. </strong>
				
								

			</div>
			</div>
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Height(m)(above deepest foundation level):
										
									</label>
									
								<input id="salientheightdfl" value="" name="salientheightdfl"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  required   data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
									
									<!-- <input id="typeOfDam" value="" name="typeOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> -->
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Length of the crest (m):
										
									</label>
									
									<input id="salientlengthcrest" value="" name="salientlengthcrest"   style="color:blue; font-weight: bold;"
											class=" form-control "  required type="text"    data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
									
								<%-- 	<input id="damPurpose" value="${userObj.divisionName}" name="damOperator"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> --%>
											</div>
									</div>
									
									
									<div class="col-md-12">	
									<div class="col-md-6">
											
								<label class="label-control rowlebel ">Bottom width (m):
										
									</label>
									
								<input id="salientbottomwidth" value="" name="salientbottomwidth"   style="color:blue; font-weight: bold;"
											class=" form-control "   required  type="text"    data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
									
									<!-- <input id="typeOfDam" value="" name="typeOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> -->
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Top width (m):
										
									</label>
									
								<input id="salienttopwidth" value="" name="salienttopwidth"   style="color:blue; font-weight: bold;"
											class=" form-control "  required type="text"    data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
									
									<!-- <input id="typeOfDam" value="" name="typeOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> -->
											</div>
											
									</div>
									
									<div class="col-md-12">	
									 <br>
											<br>
									 
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Capacity of the reservoir in (m3). </strong>
			
								

			</div>
			</div>
									 
									 
											<div class="col-md-6">
											
								<label class="label-control rowlebel "> a) Gross Storage at M.W.L:
										
									</label>
									
								<input id="grossCapacityMwl" value="" name="grossCapacityMwl"   style="color:blue; font-weight: bold;"
											class=" form-control "   required type="text"    data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
									
									<!-- <input id="typeOfDam" value="" name="typeOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> -->
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel "> b) Dead Storage:
										
									</label>
									
								<input id="capacitydeadstorage" value="" name="capacitydeadstorage"   style="color:blue; font-weight: bold;"
											class=" form-control "  required type="text"    data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
									
									<!-- <input id="typeOfDam" value="" name="typeOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> -->
											</div>
											
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel "> c) Active Storage:
										
									</label>
									
								<input id="capacityactivestorage" value="" name="capacityactivestorage"   style="color:blue; font-weight: bold;"
											class=" form-control "  required type="text"    data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
									
									<!-- <input id="typeOfDam" value="" name="typeOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> -->
											</div>
									 
									 </div>
									 
									 <div class="col-md-12">	
									 <br>
											<br>
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Max Flood Discharge (in m3). </strong>
				
								

			</div>
			</div>
									 
											<div class="col-md-6">
											
								<label class="label-control rowlebel "> a) Design Flood:
										
									</label>
									
								<input id="mfddesignflood" value="" name="mfddesignflood"   style="color:blue; font-weight: bold;"
											class=" form-control "  required type="text"    data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
									
									<!-- <input id="typeOfDam" value="" name="typeOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> -->
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel "> b) Observed Flood:
										
									</label>
									
								<input id="mfdobservedflood" value="" name="mfdobservedflood"   style="color:blue; font-weight: bold;"
											class=" form-control "   required type="text"    data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"/>
									
									<!-- <input id="typeOfDam" value="" name="typeOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" /> -->
											</div>
									 
									 </div>
									 
									 <div class="col-md-12">
									<br>
											
								<label class="label-control rowlebel ">Specially difficult Foundation problems:
										
									</label>
									
									<input id="specialDifficultFoundationIssues" value="" name="specialDifficultFoundationIssues"   style="color:blue; font-weight: bold;"
											class=" form-control  "   required type="text"    />
											</div>
											
											<div class="col-md-12">
											<br>
											<br>
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Unusual Dam Design:
										
									</label>
									
									<select class="form-control " id="unusualDamDesignId" name="unusualDamDesignId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Yes</option>
								<option value="2">2-No</option>
								
							
								


							</select>
									
								
											</div>
											
												<div class="col-md-6"  >
													<label class="label-control rowlebel ">If Yes, Please give Details:
										
									</label>
											
											<textarea id="unusualDamDesigndetails"  name="unusualDamDesigndetails"   style="color:blue; font-weight: bold;"
											class=" form-control  "   required ></textarea>
							 
								
									</div>	
										
										
									</div>
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="salientcaptcha_id1" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('salientcaptcha_id1').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="salientcaptcha_id1" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
								
							<!-- onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)" -->
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="salientchecks1" id="salientchecksres1" 
									class="btn btn-1 btn-primary center-block frmsalientbutton" onclick="saleditinfo1(dmsalienttankdata1.value,dmsalientreservoirIddata1.value,this.form.id, 3,damsalienteditFlag1.value)">Edit</button>
									</div>
									
									</div>
									
									</form:form>
</div>

<div id="Tab2" class="tabcontent">

<form:form id="addsalientinf2" name="adddamsalientinfdata2"
								modelAttribute="resinspectsalientinfo" method="post" class="ressalientform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

<!-- start of hidden values  -->

 <input name="tankId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalienttankdata2" type="hidden" /> 
											
<input  value="false" 
											class=" form-control " id="damsalienteditFlag2" type="hidden" />
<!-- end of hidden values -->

<input name="reservoirId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalientreservoirIddata2" type="hidden" /> 


<input  value="${userObj.unitName }" readonly="readonly" 
											class=" form-control " id="usersalunitName2" type="hidden" /> 
											
<input  value="${userObj.divisionName }" readonly="readonly" 
											class=" form-control " id="usersaldivisionName2" type="hidden" /> 
   
									
									<div class="col-md-12">
								 <br>
											<br>
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Inspection Galleries in the Dam . </strong>
				
								

			</div>
			</div>
							
								<div class="col-md-4">
											
								<label class="label-control rowlebel "> a) Number:
										
									</label>
									
									<input id="damGalleryNumber" value="" name="damGalleryNumber"   style="color:blue; font-weight: bold;"
											class=" form-control " required  type="text"   />
											</div>
											
											<div class="col-md-4">
											
								<label class="label-control rowlebel ">b) Elevation of Galleries (m):
										
									</label>
									
									<input id="galleryElevation" value="" name="galleryElevation"   style="color:blue; font-weight: bold;"
											class=" form-control "  required type="text"    />
											</div>
											
											<div class="col-md-4">
											
								<label class="label-control rowlebel ">c) Are all Galleries Dry?:
										
									</label>
									
									<input id="GalleryDryStatus" value="" name="GalleryDryStatus"   style="color:blue; font-weight: bold;"
											class=" form-control "   required type="text"    />
											</div>
									</div>	
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="salientcaptcha_id2" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('salientcaptcha_id2').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="salientcaptcha_id2" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
								
							<!-- onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)" -->
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="salientchecks2" id="salientchecksres2" 
									class="btn btn-1 btn-primary center-block frmsalientbutton" onclick="saleditinfo2(dmsalienttankdata2.value,dmsalientreservoirIddata2.value,this.form.id, 3,damsalienteditFlag2.value)">Edit</button>


									</div>
									
									</form:form>
</div>

<div id="Tab3" class="tabcontent">

<form:form id="addsalientinf3" name="adddamsalientinfdata3"
								modelAttribute="resinspectsalientinfo" method="post" class="ressalientform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

<!-- start of hidden values  -->

 <input name="tankId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalienttankdata3" type="hidden" /> 
											
<input  value="false" 
											class=" form-control " id="damsalienteditFlag3" type="hidden" />
<!-- end of hidden values -->

<input name="reservoirId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalientreservoirIddata3" type="hidden" /> 


<input  value="${userObj.unitName }" readonly="readonly" 
											class=" form-control " id="usersalunitName3" type="hidden" /> 
											
<input  value="${userObj.divisionName }" readonly="readonly" 
											class=" form-control " id="usersaldivisionName3" type="hidden" /> 
    
									
									
									<div class="col-md-12">
									
									<br>
											<br>
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Gates . </strong>
				
								

			</div>
			</div>
							
								
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Method of operation of Gates:
										
									</label>
									
									<select class="form-control " id="gateOperationMethodId" name="gateOperationMethodId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Hydraulic</option>
								<option value="2">2-Electric</option>
								<option value="3">3-Manual</option>
								<option value="4">4-Automatic fall</option>
								
								
							
								


							</select>
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Size of each Gate Length:
										
									</label>
									
									<input id="resgatesize" value="" name="resgatesize"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"   required placeholder="23m*11m"  />
											
												
											</div>
											
									</div>	
									
									<div class="col-md-12">
									
									
									<div class="col-md-6">
											
								<label class="label-control rowlebel ">Number of gates working fine:
										
									</label>
									
									<input id="damGateNumberFine" value="" name="damGateNumberFine"  required  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"   />
											</div>
											
							
								
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Number of gates Remarks:
										
									</label>
									
									<input id="resgatenumber" value="" name="resgatenumber"  required  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"   />
											</div>
											
											
											
											
										
											
										
									</div>	
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="salientcaptcha_id3" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('salientcaptcha_id3').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="salientcaptcha_id3" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
								
							<!-- onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)" -->
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="salientchecks3" id="salientchecksres3" 
									class="btn btn-1 btn-primary center-block frmsalientbutton" onclick="saleditinfo3(dmsalienttankdata3.value,dmsalientreservoirIddata3.value,this.form.id, 3,damsalienteditFlag3.value)">Edit</button>
									</div>
									
									</form:form>
</div>

<div id="Tab4" class="tabcontent">
<form:form id="addsalientinf4" name="adddamsalientinfdata4"
								modelAttribute="resinspectsalientinfo" method="post" class="ressalientform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

<!-- start of hidden values  -->

 <input name="tankId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalienttankdata4" type="hidden" /> 
											
<input  value="false" 
											class=" form-control " id="damsalienteditFlag4" type="hidden" />
<!-- end of hidden values -->

<input name="reservoirId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalientreservoirIddata4" type="hidden" /> 


<input  value="${userObj.unitName }" readonly="readonly" 
											class=" form-control " id="usersalunitName4" type="hidden" /> 
											
<input  value="${userObj.divisionName }" readonly="readonly" 
											class=" form-control " id="usersaldivisionName4" type="hidden" /> 
									
									<div class="col-md-12">
									
									<br>
											<br>
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Operation  & Maintenance Manual . </strong>
				
								

			</div>
			</div>
							
								
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">a) Was an Operation & Maintenance Manual prepared?:
										
									</label>
									
									<select class="form-control " id="OanMManualPreparedId" name="OanMManualPreparedId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Yes</option>
								<option value="2">2-No</option>
								
								


							</select>
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">If No,by when Operation and Maintenance Manual likely to be prepared (Month-Year):
										
									</label>
									
									<input id="OanMManualPreparedTime" value="" name="OanMManualPreparedTime" required   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"   />
											
												
											</div>
											
									</div>	
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="salientcaptcha_id4" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('salientcaptcha_id4').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="salientcaptcha_id4" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
								
							<!-- onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)" -->
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="salientchecks4" id="salientchecksres4" 
									class="btn btn-1 btn-primary center-block frmsalientbutton" onclick="saleditinfo4(dmsalienttankdata4.value,dmsalientreservoirIddata4.value,this.form.id, 3,damsalienteditFlag4.value)">Edit</button>
									</div>
									
									</form:form>


</div>

<div id="Tab5" class="tabcontent">

<form:form id="addsalientinf5" name="adddamsalientinfdata5"
								modelAttribute="resinspectsalientinfo" method="post" class="ressalientform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

<!-- start of hidden values  -->

 <input name="tankId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalienttankdata5" type="hidden" /> 
											
<input  value="false" 
											class=" form-control " id="damsalienteditFlag5" type="hidden" />
<!-- end of hidden values -->

<input name="reservoirId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalientreservoirIddata5" type="hidden" /> 


<input  value="${userObj.unitName }" readonly="readonly" 
											class=" form-control " id="usersalunitName5" type="hidden" /> 
											
<input  value="${userObj.divisionName }" readonly="readonly" 
											class=" form-control " id="usersaldivisionName5" type="hidden" /> 


									
									<div class="col-md-12">
									
									<br>
											<br>
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Silting of Reservoir. </strong>
				
								

			</div>
			</div>
							
								
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">a) Does the Reservoir get Silted?:
										
									</label>
									
									<select class="form-control " id="reservoirSiltedId" name="reservoirSiltedId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Yes</option>
								<option value="2">2-No</option>
								
								


							</select>
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">If Yes,What percentage of the rservoir capacity is lost?:
										
									</label>
									
									<input id="lostPercentageReservoirCapacity" value="" name="lostPercentageReservoirCapacity"   style="color:blue; font-weight: bold;"
											class=" form-control "   required type="text"   />
											
												
											</div>
											
									</div>
									
									<div class="col-md-12">
									
									<br>
											<br>
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Leakage through the Dam body. </strong>
				
								

			</div>
			</div>
							
								
											
											<div class="col-md-12">
											
								<label class="label-control rowlebel ">Peak water leakage (in  m3):
										
									</label>
									
										
									<input id="peakWaterLeakage" value="" name="peakWaterLeakage"  required  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"   />
											</div>
											
									</div>	
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="salientcaptcha_id5" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('salientcaptcha_id5').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="salientcaptcha_id5" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
								
							<!-- onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)" -->
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="salientchecks5" id="salientchecksres5" 
									class="btn btn-1 btn-primary center-block frmsalientbutton" onclick="saleditinfo5(dmsalienttankdata5.value,dmsalientreservoirIddata5.value,this.form.id, 3,damsalienteditFlag5.value)">Edit</button>
									</div>
</form:form>
</div>

<!-- <div id="Tab6" class="tabcontent">
<div class="col-md-12">
									
									<br>
											<br>
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Leakage through the Dam body. </strong>
				
								

			</div>
			</div>
							
								
											
											<div class="col-md-12">
											
								<label class="label-control rowlebel ">Peak water leakage (in  m3):
										
									</label>
									
										
									<input id="peakWaterLeakage" value="" name="peakWaterLeakage"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"   />
											</div>
											
									</div>	
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="salientcaptcha_id6" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('salientcaptcha_id6').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="salientcaptcha_id6" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
								
							onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)"
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="salientchecks11" id="salientchecksres" 
									class="btn btn-1 btn-primary center-block frmsalientbutton">Edit</button>
									</div>
									
									

</div> -->

<div id="Tab7" class="tabcontent">

<form:form id="addsalientinf7" name="adddamsalientinfdata7"
								modelAttribute="resinspectsalientinfo" method="post" class="ressalientform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

<!-- start of hidden values  -->

 <input name="tankId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalienttankdata7" type="hidden" /> 
											
<input  value="false" 
											class=" form-control " id="damsalienteditFlag7" type="hidden" />
<!-- end of hidden values -->

<input name="reservoirId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalientreservoirIddata7" type="hidden" /> 


<input  value="${userObj.unitName }" readonly="readonly" 
											class=" form-control " id="usersalunitName7" type="hidden" /> 
											
<input  value="${userObj.divisionName }" readonly="readonly" 
											class=" form-control " id="usersaldivisionName7" type="hidden" /> 

<div class="col-md-12">
									
									<br>
											<br>
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Stuructural Safety Assessment. </strong>
				
								

			</div>
			</div>
							
								
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Was Structural Safety Assessment performed?:
										
									</label>
									
									<select class="form-control "   id="structuralSafetyPerformedId" name="structuralSafetyPerformedId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Yes</option>
								<option value="2">2-No</option>
								
								


							</select>
											</div>
											
												<div class="col-md-6"  >
												
													<label class="label-control rowlebel ">If Yes, was the Dam found to be safe?:
										
									</label>
											
											<textarea id="damFoundSafe"  required name="damFoundSafe"   style="color:blue; font-weight: bold;"
											class=" form-control  "   ></textarea>
							 
								
									</div>	
									
									<div class="col-md-6"  >
												
													<label class="label-control rowlebel ">If No, was the Dam retrofitted?:
										
									</label>
											
											<textarea id="damRetrofitStatus"   required name="damRetrofitStatus"   style="color:blue; font-weight: bold;"
											class=" form-control  "   ></textarea>
							 
								
									</div>	
									
									<div class="col-md-6"  >
												
													<label class="label-control rowlebel ">If Yes, when was the Dam retrofitted?:
										
									</label>
											
											<textarea id="damRetrofitTime"   required name="damRetrofitTime"   style="color:blue; font-weight: bold;"
											class=" form-control  "   ></textarea>
							 
								
									</div>
									
									<div class="col-md-6"  >
												
													<label class="label-control rowlebel ">If Yes, what was the Dam retrofit measure adopted?:
										
									</label>
											
											<textarea id="damretrofitMeausreAdopted"   required  name="damretrofitMeausreAdopted"   style="color:blue; font-weight: bold;"
											class=" form-control  "   ></textarea>
							 
								
									</div>		
											
									</div>
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="salientcaptcha_id7" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('salientcaptcha_id7').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="salientcaptcha_id7" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
								
							<!-- onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)" -->
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="salientchecks7" id="salientchecksres7" 
									class="btn btn-1 btn-primary center-block frmsalientbutton" onclick="saleditinfo7(dmsalienttankdata7.value,dmsalientreservoirIddata7.value,this.form.id, 3,damsalienteditFlag7.value)">Edit</button>
									</div>


									
		</form:form>							

</div>

<div id="Tab8" class="tabcontent">

<form:form id="addsalientinf8" name="adddamsalientinfdata8"
								modelAttribute="resinspectsalientinfo" method="post" class="ressalientform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

<!-- start of hidden values  -->

 <input name="tankId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalienttankdata8" type="hidden" /> 
											
<input  value="false" 
											class=" form-control " id="damsalienteditFlag8" type="hidden" />
<!-- end of hidden values -->

<input name="reservoirId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalientreservoirIddata8" type="hidden" /> 


<input  value="${userObj.unitName }" readonly="readonly" 
											class=" form-control " id="usersalunitName8" type="hidden" /> 
											
<input  value="${userObj.divisionName }" readonly="readonly" 
											class=" form-control " id="usersaldivisionName8" type="hidden" /> 

<div class="col-md-12">
									
									<br>
											<br>
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Dam Break Analysis. </strong>
				
								

			</div>
			</div>
							
								
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Was Dam Break Analysis performed?:
										
									</label>
									
									<select class="form-control " id="damBreakAnalysisId" name="damBreakAnalysisId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Yes</option>
								<option value="2">2-No</option>
								
								


							</select>
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">If Yes, were Disaster Management Plans prepared?:
										
									</label>
									
									<input id="disaster_manage_prepared" value="" name="disaster_manage_prepared"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  required  />
											
												
											</div>
											
									</div>
									
									
											
							
							
								
							

<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="salientcaptcha_id8" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('salientcaptcha_id8').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="salientcaptcha_id8" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
								
							<!-- onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)" -->
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="salientchecks8" id="salientchecksres8" 
									class="btn btn-1 btn-primary center-block frmsalientbutton"  onclick="saleditinfo8(dmsalienttankdata8.value,dmsalientreservoirIddata8.value,this.form.id, 3,damsalienteditFlag8.value)">Edit</button>
									</div>
									
									
									</form:form>

</div>
<div id="Tab9" class="tabcontent">


<form:form id="addsalientinf9" name="adddamsalientinfdata9"
								modelAttribute="resinspectsalientinfo" method="post" class="ressalientform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

<!-- start of hidden values  -->

 <input name="tankId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalienttankdata9" type="hidden" /> 
											
<input  value="false" 
											class=" form-control " id="damsalienteditFlag9" type="hidden" />
<!-- end of hidden values -->

<input name="reservoirId" value="0" readonly="readonly" 
											class=" form-control " id="dmsalientreservoirIddata9" type="hidden" /> 


<input  value="${userObj.unitName }" readonly="readonly" 
											class=" form-control " id="usersalunitName9" type="hidden" /> 
											
<input  value="${userObj.divisionName }" readonly="readonly" 
											class=" form-control " id="usersaldivisionName9" type="hidden" /> 
											
											

 	 
	

<div class="col-md-12">
									
									<br>
											<br>
									 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:blue"> Note: Emergency Action plan. </strong>
				
								

			</div>
			</div>
							
								
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Was an Emergency Action plan prepared?:
										
									</label>
									
									<select class="form-control " id="emergencyActionPlanPreparedId" name="emergencyActionPlanPreparedId"
								required >
								<option value=" ">--select--</option>
								<option value="1">1-Yes</option>
								<option value="2">2-No</option>
								
								


							</select>
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">If Yes, was it shared with the SDMA and DDMA?:
										
									</label>
									
									<input id="emergencyActionShared" value="" name="emergencyActionShared"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"   required  />
											
												
											</div>
											
											
											
									</div>


<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="salientcaptcha_id9" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('salientcaptcha_id9').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="salientcaptcha_id9" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
							
								</div>
								
							<!-- onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)" -->
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="salientchecks11" id="salientchecksres9" 
									class="btn btn-1 btn-primary center-block frmsalientbutton"  onclick="saleditinfo9(dmsalienttankdata9.value,dmsalientreservoirIddata9.value,this.form.id, 3,damsalienteditFlag9.value)">Edit</button>
									</div>

	</form:form>
</div>
	
				
	
<!-- 	<div id="conlevel"> -->


	
	
	
	
</div>



 

</div>


<div id="hazardinfo_dialogue">

	<form:form id="hazardinfo" method="post" modelAttribute="hazard"
		name="hazarddatainfo" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="hazarddaminfo" class="col-md-12 invDiv">
		
			
		
		<div class="col-md-12"  style="border: 2px solid black; ">
						
						<br>
									<br>
								
										<div class="col-md-12" style="color: blue;" >	
										
										<label class="label-control rowlebel " for="parameter1">
											High hazard dam:<font
											color=red>*</font></label> 
											<p> A dam whose catastrophic (breach) failure would cause the loss of life and severe damage to homes, industrial and commercial buildings , public utilities, major highways, or railroads.</p>
										</div>
										
										<br>
									<br>
										
										</div>
										
		<div class="col-md-12"  style="border: 2px solid black; colour:blue">
						
						<br>
									<br>
								
										<div class="col-md-12" style="color: blue;" >	
										
										<label class="label-control rowlebel " for="parameter1">
											Significant hazard dam:<font
											color=red>*</font></label> 
											<p> A dam whose failure would damage isolated homes and highways, or cause the temporary interupption of public utility services.</p>
										</div>
										
										<br>
									<br>
										
										</div>
										
										
					<div class="col-md-12"  style="border: 2px solid black; colour:blue" >
						
						<br>
									<br>
								
										<div class="col-md-12"  style="color: blue;">	
										<label class="label-control rowlebel " for="parameter1">
											Low hazard dam:<font
											color=red>*</font></label> 
											<p> A dam whose failure would damage farm buildings, agricultural land , or local roads.</p>
										</div>
										
										<br>
									<br>
										
										</div>
		
		
		
		
								</div>
		
	</form:form>
	
</div> 



<div id="conditioninfo_dialogue">

	<form:form id="conditioninfo" method="post" modelAttribute="condition"
		name="conditiondatainfo" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="conditiondaminfo" class="col-md-12 invDiv">
		
			
		
		<div class="col-md-12"  style="border: 2px solid black; ">
						
						<br>
									<br>
									
										<div class="col-md-12" style="color: blue;" >	
										<label class="label-control rowlebel " for="parameter1">
											Satisfactory:<font
											color=red>*</font></label> 
											<p><strong> No existing or potential dam safety deficiencies are recognized. Acceptable performance is expected under all loading conditions (static, hydrologic,seismic) in accordance with the applicable regulatory criteria or tolerable risk guidelines. </strong></p>
										</div>
										
										<br>
									<br>
										
										</div>
										
		<div class="col-md-12"  style="border: 2px solid black; colour:blue">
						
						<br>
									<br>
									
										<div class="col-md-12" style="color: blue;" >
										<label class="label-control rowlebel " for="parameter1">
											Fair:<font
											color=red>*</font></label> 	
											 <p><strong> No existing dam safety deficiencies are recognized for normal loading conditions. Rare or extreme hydrologic and / or seismic events may result in a dam safety deficiency. Risk may be in the range to take further action.</strong></p>
										</div>
										
										<br>
									<br>
										
										</div>
										
										
					<div class="col-md-12"  style="border: 2px solid black; colour:blue" >
						
						<br>
									<br>
									
										<div class="col-md-12"  style="color: blue;">
											<label class="label-control rowlebel " for="parameter1">
											Poor:<font
											color=red>*</font></label> 	
											 <p><strong>A dam safety deficiency is recognized for loading conditions which may realistically occur. Remedial action is necessary. Poor may also be used when  uncertainties exist as to critical  analysis parameters  which identify a potential dam safety deficiency. Further investigations and studies are necessary.</strong></p>		</div>
										
										<br>
									<br>
										
										</div>
										
										<div class="col-md-12"  style="border: 2px solid black; colour:blue" >
						
						<br>
									<br>
									
										<div class="col-md-12"  style="color: blue;">
										
										<label class="label-control rowlebel " for="parameter1">
											Unsatisfactory:<font
											color=red>*</font></label> 	
											 <p><strong>A dam safety deficiency is recognized that  requires immediate or emergency remedial action for problem resolution.</strong></p>		</div>
										
										<br>
									<br>
										
										</div>
		
		
		
		
								</div>
		
	</form:form>
	
</div> 

<!--  dilogue ends -->























<!-- </div> -->
<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>
<script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.print.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.colVis.min.js" type="text/javascript"></script>	
	



