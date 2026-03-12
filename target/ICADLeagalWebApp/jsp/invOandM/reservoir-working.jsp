

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
</style> 



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

			


			<!-- <div class="col-md-12 invDiv"> -->

<form:form id="mainform" name="mainformname"
								modelAttribute="rescheckList" method="post"
								data-parsley-validate-if-empty="">
								
								
								<div class="col-md-12 invDiv">
								
								<div class="col-md-12">
						
						
						<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Select Tank/Anicut/Check Dam to proceed further. </strong>
				<br>
				

			</div>
			</div>
						<div class="col-md-4">
									<label class="label-control rowlebel ">
										
									</label>
									
									<button type="button" name="showtanksname" id="showtanksdata" 
																	class="btn btn-1 btn-primary center-block "  >Select Tanks</button>
								</div>
								<div class="col-md-4">
									<label class="label-control rowlebel ">
										
									</label>
									
									<button type="button" name="anicutname" id="anicutdata" 
																	class="btn btn-1 btn-primary center-block "  >Select Anicuts</button>
								</div>
								
								<div class="col-md-4">
									<label class="label-control rowlebel ">
										
									</label>
									
									<button type="button" name="checkdamname" id="showcheckdamdata" 
																	class="btn btn-1 btn-primary center-block "  >Select Check Dams</button>
								</div>
								<br>
								</div>
								
									<div class="col-md-12">
								<br>
								
								<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Select Project and Reservoir to proceed further </strong>
				<br>
				

			</div>
			</div>
						<div class="col-md-12">
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
				

			</div>
			</div>
						<div class="col-md-12">
							<div >	
							<div class="col-md-3">
							
							
							
								<input name="tankId" value="" readonly="readonly" 
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
											Capacity (TMC)</label>

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


										<button type="button" name="shaddtankinf" id="shaddtankinf" 
																	class="btn btn-1 btn-primary center-block "  >Add Tank Info</button>

									</div>
								</div>
								</div>
								
								</div>
								
								
								<!-- start of res display -->
								
								<div class="col-md-12 invDiv" id="pmsresinfo">
								
									<div class="col-md-12">
						
																	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: (Reservoir name is from PMS.If Reservoir location is not displayed , please add location of Reservoir to submit AnnexureI & II.) </strong>
				<br>
				

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
						
						<button type="button" name="shaddres" id="shaddresinf" 
																	class="btn btn-1 btn-primary center-block "  >Add/update Reservoir Location</button>
						
						<br>
						<!-- <button type="button" name="sheditres" id="sheditresinfo" 
																	class="btn btn-1 btn-primary center-block "  >Edit Reservoir Location</button> -->
									
										
										<!-- <input id="reservoirName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" /> -->
									
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


										<button type="button" name="shaddresinf" id="shaddresinf" 
																	class="btn btn-1 btn-primary center-block "  >Add/View Reservoir Info</button>

									</div>
								
								
								</div>
								</div>
								
							
								
								
								
								
					
								
								
								<div class="col-md-12 invDiv">							
	
							<div class="col-md-12">
							
							<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Select Inspection Date, frequency </strong>
				<br>
				

			</div>
			</div>
			
			<div class="col-md-3">
					<label class="label-controlPMS rowlebel ">Year <font
							color=red>*</font>
						</label>
						
						<input class="form-control" id="year"  type="text" name="year"  value="0"  readonly="readonly"   required />
					</div>
						
							
								<div  id="emp">
									

									<div class="col-md-3">
									<input name=nextEmpId value="" 	id="nextEmpId" type="hidden" />
									
									<label class="label-control rowlebel ">Next level review: <font color=red>*</font>
										</label>
										
										<select class="form-control" id="nextPostId" name="nextPostId" required>
										
											<option value=" ">--select--</option>

											<c:forEach items="${getempapprove}" var="u">
												<option value="${u.postId}">${u.empName}</option>
                                   <c:if test="${getempapprove.size()==1}"><script>    $('select>option:eq(1)').prop('selected', true);  $("#nextPostId").val("${u.postId}");$("#nextEmpId").val("${u.empId}");</script></c:if>
											</c:forEach>


										</select>
									</div>
								</div>
								
					
								
											
						<!-- 	onchange="getann1inspectdata(year.value)"	 -->
								
                     <div  id="freqid">
					<div class="col-md-3">
					<label class="label-controlPMS rowlebel ">Select Frequency: <font
							color=red>*</font>
						</label>
						<select class="form-control" id="dutyFrequencyId" name="dutyFrequencyId" 
							 required >
							<option value=" ">--select--</option>
							<option value="9">PRE MONSOON (April,May)</option>
							<option value="10">POST MONSOON (November,December)</option>
						<!-- 	<option value="11">DURING MONSOON(JUNE TO AUGUEST)</option> -->
						

						</select>
					</div>
					</div>
					
					 <div id="condition">
					
						<div class="col-md-3">
						
						<label class="label-controlPMS rowlebel ">Overall Condition of Dam
								 <font color=red>*</font>
							</label>
							<select class="form-control" id="conditionofDamId" name="conditionofDamId"
								required onchange="getresmst2mst1byfreqyear(),getResInspectioninfo(),getResDamHealthDetails()">
								<option value=" ">--select--</option>
								<option value="1">1-Unsatisfactory</option>
								<option value="2">2-Poor</option>
								<option value="3">3-Fair</option>
								<option value="4">4-Satisfactory</option>
								


							</select>
						</div>
							</div>
</div>

          
						
					
						</div>
						
						
							<!-- start of inspection details -->
								
								
								<!-- <div class="col-md-12 invDiv" id="inspectinfo">
								
									<div class="col-md-12">
						
																	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note:  </strong>
				<br>
				

			</div>
			</div>
						
								
								<div  class="col-md-4">	
								
								<label class="label-control rowlebel ">
									
									</label>
						
						<button type="button" name="shaddinspect" id="shaddinspectinf" 
																	class="btn btn-1 btn-primary center-block "  >Add Inspection Details</button>
						
						<br>
						
									
								</div>
								
									<div  class="col-md-4">	
								
								<label class="label-control rowlebel ">
									
									</label>
						
						<button type="button" name="sheditinspect" id="sheditinspectinf" 
																	class="btn btn-1 btn-primary center-block "  >Edit Inspection Details</button>
						
						<br>
						
									
								</div>
									
								
								
								<div  class="col-md-4">	
								
								<label class="label-control rowlebel ">
									
									</label>
						
						<button type="button" name="shviewinspect" id="shviewinspectinf" 
																	class="btn btn-1 btn-primary center-block "  >View Inspection Details</button>
						
						<br>
						
									
								</div>
								
									
						
								
								</div>
								
								
								</div> -->
								
								
								<!-- end of inspection details -->
						
						
				
								
								

				
</form:form>

		



			 <div  class="col-md-12">
			
				
				 	<div id="resprepost">
				 	
				 	<ul>
				 	<li><a href="#inspect" >Add Inspection Details </a></li>
					<li><a href="#1ann" > Annexure I</a></li>
					<li><a href="#2ann" > Annexure II</a></li>					
					<li><a href="#history" >History </a></li>
					<li><a href="#capacity" >Capacity</a></li>
					<li><a href="#health" >Health Status(Reservoir)</a></li>
				<!-- 	<li><a href="#recommn" >Recommendations</a></li> -->
					<li><a href="#ats" >Action Taken Status</a></li>
					
				</ul>
				
				<div id="inspect">
					
					
					<form:form id="addinspect" method="post" modelAttribute="addinspectdata"
		name="addinspectform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		<!-- start of earth ann1 form -->
									
										<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${mcount.count}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${mcount.count}" type="hidden" />
									
									<input name="tankId" value="0"  class="maintankId"
									id="tankId${mcount.count}" type="hidden" />
							
						
								<input name="year" value="0" id="year${mcount.count}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="21" id="tabId${mcount.count}" type="hidden" /> 
									 


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyId${mcount.count}" type="hidden"  	class="maindutyFrequencyId"/>
   
    <input name="conditionofDamId" value="0" id="conditionofDamId${mcount.count}" type="hidden"  	class="mainconditionofDamId"/>
    
    
    
    
    <input name="nextPostId" value="" id="nextPostId${mcount.count}" type="hidden" class="mainnextPostId" />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="postId${mcount.count}" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="nextEmpId${mcount.count}" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="userempId${mcount.count}" type="hidden"  	class="mainuserempId" />
								</c:if> 
								
									<!-- end of earth form ann1 form  --> 
		
		
		
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
											<select class="form-control" id="inspectOfficeId"
											name="inspectOfficeId" required>
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
										<textarea class="form-control" id="inspectOfficerData" 	name="inspectOfficerData" rows="3" cols="50" placeholder="Name1(Designation1),Name2(Designation2)"></textarea>
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
										<textarea class="form-control" id="fieldOfficerData" 	name="fieldOfficerData" rows="3" cols="50" placeholder="Name1(Designation1),Name2(Designation2)"></textarea>
						</div>
							
							
					
							
						
						
							</div>
							
								<div class="col-md-12">
									<br>
									<br>
							
							
															<div id="yearid" class="col-md-6 insdate">
																<label class="label-control rowlebel ">Inspect Date: <font color=red>*</font>
																</label> <input type="text"
																	class=" datepick form-control datepicker "
																	id="inspectDateres"
																	name="inspectDate"
																	placeholder="dateofoperation" value="0" readonly="readonly"/>
															</div>
															
																<div id="yearid" class="col-md-6 insdate">
																<label class="label-control rowlebel ">Reservoir water level <font color=red>*</font>
																</label> <input type="text"
																	class="  form-control  "
																	id="presentWaterlevel"
																	name="presentWaterlevel"
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
        <label class="radio-inline"> <input type="radio" class="myradio" name="inchargeofAnn1" id="inchargeofAnn1n"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="inchargeofAnn1" id="inchargeofAnn1y"     value="true"   >Yes</label>
       
          
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
										<textarea class="form-control" id="preDaminspecteddata" 	name="preDaminspecteddata" rows="3" cols="50" placeholder="Name1(Designation1),Date,Name2(Designation2),Date"></textarea>
						</div>
							
							
					
							
						
						
							</div>
							
							
							<div class="col-md-12">
							
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
        <label class="radio-inline"> <input type="radio" class="myradio" name="vigandWatchProvided" id="vigandWatchProvidedn"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="vigandWatchProvided" id="vigandWatchProvidedy"     value="true"   >Yes</label>
       
          
    </div>
    
    <div class="col-md-3">
										<textarea class="form-control" id="vigandwatchreason" 	name="vigandwatchreason" rows="3" cols="50" placeholder="Reasons"></textarea>
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
        <label class="radio-inline"> <input type="radio" class="myradio" name="obsAnn2" id="obsAnn2n"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="obsAnn2" id="obsAnn2y"     value="true"   >Yes</label>
       
          
    </div>
					
							
									
							</div>
							
							
							
									
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
						
						<div class="col-md-12">
						<br>
						
						<button type="button" name="submitinspectinf" id="submitinspectinf" 
																	class="btn btn-1 btn-primary center-block" onclick="AddInspectionInfo(this.form.id)"  >Submit</button>
						
						</div>
		
		
				
			</div>			

	</form:form>
					
					
					</div>
				
				<div id="1ann"> 
					
						<ul>
							<li><a href="#gen" >HYDRO-METEOROLOGICAL INSTRUMENTS</a></li>
							<li><a href="#ear" >GEO-TECHNICAL INSTRUMENTS</a></li>
							<li><a href="#mas" >GEODETIC INSTRUMENTS</a></li>
							<li><a href="#oandm" >SEISMIC INSTRUMENTS</a></li>
							<li><a href="#addre" >Add Remarks Annexure1</a></li>
						</ul>
						<div id="gen">
						
							<div class="col-md-12">	
								
								<div class="col-md-12">
								
								<c:if test="${ann1resa!=null}">
								
								<c:forEach items="${ann1resa}" var="m" varStatus="acount">
								
								<div class="col-md-1">
								
								<button type="button" name="snumgen" id="annobs${m.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${m.resCheckId}',this.id)">${m.checkdisplayNum}</button> &emsp;&emsp;&emsp;&emsp;  
								</div>
								
							<%-- 	<c:if test="${acount.count==12}">  <br> <br> </c:if> --%>
								
								</c:forEach>
								
							
								
								</c:if>
								
								
								</div>
								
								
								
						 		<div class="col-md-12"> 

								<c:if test="${ann1resa!=null}">


									<c:forEach items="${ann1resa}" var="m" varStatus="mcount">
									
								
									
										<div class="col-md-12 resmainobsinf" id="resmainobs${m.resCheckId}">
										
										&emsp;&emsp;
										
										
									<!-- 	start of form  -->
										
										<form:form id="resformgen${m.resCheckId}" name="resgenform${m.resCheckId}name"
								modelAttribute="rescheckObject" method="post"
								data-parsley-validate-if-empty="">					
							
									
									<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${m.resCheckId}" type="hidden" />
											
								  <%--   <input name="reservoirInspectList[0].inspectDate" value="0"
											id="inspectDate${mcount.count}" type="hidden" />	 --%>					
							
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${m.resCheckId}" type="hidden" />
									      
							
								<input name="year" value="0" id="year${m.resCheckId}" class="mainyear"
									type="hidden" />
							   <input name="tabId" value="1" id="tabId${m.resCheckId}" type="hidden" /> 
							   
							   <input name="annexureId" value="1" id="annexureId${m.resCheckId}" class="mainannId"
									type="hidden" />


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

			 <label class="label-control rowlebel invDiv "  for="parameter1">${m.checkdisplayNum} &emsp;&emsp; ${m.resCheck}</label> 
			  <input  name="resCheckId"  value="${m.resCheckId}" 
			          id="resCheckId${m.resCheckId}"  type="hidden" /> 
	         <input type="hidden" class="form-control" 	id="resCatId${m.resCheckId}"
				    name="resCatId" value="${m.resCategoryId}" />
											
						</div>
											
											
						<div class="col-md-12">
						
						 <input  name="irrChFrm"  value="0.00" 
			          id="irrChFrm${m.resCheckId}"  type="hidden" /> 
			          
			          <input  name="irrChTo"  value="0.00" 
			          id="irrChTo${m.resCheckId}"  type="hidden" /> 

		<textarea class="form-control" id="remarks${m.resCheckId}"	name="remarks"
				   rows="3" cols="50" placeholder="Observations" required></textarea>
						
						</div>
											
										 
						 <div class="col-md-12"  > 
						 
						&emsp;&emsp;
	 	<button type="button" name="rescheckadd${m.resCheckId}"  id="rescheckbutton${m.resCheckId}"
					  class="btn btn-1 btn-primary center-block "  onclick="addnrldchecksann1(this.form.id)">Submit</button>
									
						&emsp;&emsp;
						
						</div>
									
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${mcount.count}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${m.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit Observations</button>
									&emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${m.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${m.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${m.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${m.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${m.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">Edit/View Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>
							
						

										 
							
							
									
									</c:forEach>
								</c:if>
								
								&emsp;&emsp;&emsp;&emsp;
								
							
								
							 	</div>
								
						
									&emsp;&emsp;
							
							</div>
						</div>
						<div id="ear">							
								
								<div class="col-md-12">
								
								<c:if test="${ann1resb!=null}">
								
								<c:forEach items="${ann1resb}" var="m" varStatus="bcount">
								
								<div class="col-md-1">
								
								<button type="button" name="snumgen" id="annobs${m.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${m.resCheckId}',this.id)">${m.checkdisplayNum}</button> &emsp;&emsp;&emsp;&emsp;  
								</div>
								
								<%-- <c:if test="${bcount.count==12}">  <br> <br> </c:if> --%>
								
								</c:forEach>
								
							
								
								</c:if>
								
								
								</div>   

						                
								<c:if test="${ann1resb!=null}">



									<c:forEach items="${ann1resb}" var="m" varStatus="mcount">
									
										<div class="col-md-12 resmainobsinf" id="resmainobs${m.resCheckId}">
										
										<form:form id="resformearth${m.resCheckId}" name="resformrearth${m.resCheckId}name"
								modelAttribute="rescheckObject" method="post"
								data-parsley-validate-if-empty="">


								<!-- start of earth ann1 form -->
									
										<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${m.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${m.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${m.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="2" id="tabId${m.resCheckId}" type="hidden" /> 
									   <input name="annexureId" value="1" id="annexureId${m.resCheckId}" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyId${m.resCheckId}" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamId${m.resCheckId}" type="hidden"  	class="mainconditionofDamId"/>
    
    
    
    
    <input name="nextPostId" value="" id="nextPostId${m.resCheckId}" type="hidden" class="mainnextPostId" />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="postId${m.resCheckId}" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="nextEmpId${m.resCheckId}" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="userempId${m.resCheckId}" type="hidden"  	class="mainuserempId" />
								</c:if> 
								
									<!-- end of earth form ann1 form  -->

										
											<div class="col-md-12 invDiv">

								<label class="label-control rowlebel "  for="parameter1">${m.checkdisplayNum}&emsp;&emsp; ${m.resCheck}</label>
								 <input name="resCheckId"
										value="${m.resCheckId}" id="resCheckId${m.resCheckId}"  type="hidden" />
								 <input type="hidden" class="form-control"  id="resCatId${m.resCheckId}"
										name="resCatId"  value="${m.resCategoryId}" />
											</div>
											<div class="col-md-12">
											
												 <input  name="irrChFrm"  value="0.00" 
			          id="irrChFrm${m.resCheckId}"  type="hidden" /> 
			          
			          <input  name="irrChTo"  value="0.00" 
			          id="irrChTo${m.resCheckId}"  type="hidden" /> 

												<textarea class="form-control" id="remarks${m.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
											</div>
											
									
											<div class="col-md-12">
											<button type="button" name="rescheckann1ear${m.resCheckId}"
									id="rescheckann1earbutton${m.resCheckId}"
									class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)">Submit</button>
									
									</div>
									
									
									
									
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${mcount.count}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${m.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit Observations</button>
									&emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${m.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button>
									</td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${m.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${m.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${m.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${m.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">Edit/View Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>
									</c:forEach>
								</c:if>
								<br />
								
				
							
						</div>

						<div id="mas">

							  
								
								
								<div class="col-md-12">
								
								<c:if test="${ann1resc!=null}">
								
								<c:forEach items="${ann1resc}" var="m" varStatus="ccount">
								
								<div class="col-md-1">
								
								<button type="button" name="concgen" id="annobs${m.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${m.resCheckId}',this.id)">${m.checkdisplayNum}</button>  
								</div>
								
								<c:if test="${ccount.count==12}">  <br> <br> </c:if>
								
								</c:forEach>
								
							
								
								</c:if>
								
								
								</div>  
 
						                
								<c:if test="${ann1resc!=null}">



									<c:forEach items="${ann1resc}" var="m" varStatus="mcount">
										<div class=" col-md-12 resmainobsinf" id="resmainobs${m.resCheckId}">
										
										
										<form:form id="resformconc${m.resCheckId}" name="resformconc${m.resCheckId}name"
								modelAttribute="rescheckObject" method="post"
								data-parsley-validate-if-empty="">

				
									<!-- start of earth conc form -->
									
										<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${m.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${m.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${m.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="3" id="tabId${m.resCheckId}" type="hidden" /> 
									   <input name="annexureId" value="1" id="annexureId${m.resCheckId}" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyId${m.resCheckId}" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamId${m.resCheckId}" type="hidden"  	class="mainconditionofDamId"/>
    
    
    
    
    <input name="nextPostId" value="" id="nextPostId${m.resCheckId}" type="hidden" class="mainnextPostId" />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="postId${m.resCheckId}" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="nextEmpId${m.resCheckId}" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="userempId${m.resCheckId}" type="hidden"  	class="mainuserempId" />
								</c:if> 
								
									<!-- end of conc form ann1 form  -->

									
											<div class="col-md-12">

												<label class="label-control rowlebel invDiv "
													for="parameter1"> ${m.checkdisplayNum} &emsp;&emsp;${m.resCheck}</label>
													
													 <input
													name="resCheckId"
													value="${m.resCheckId}" id="resCheckId${m.resCheckId}"
													type="hidden" />
													 <input type="hidden" class="form-control"													
													id="resCatId${m.resCheckId}"
													name="resCatId"
													value="${m.resCategoryId}" />
											</div>
											<div class="col-md-12">
											
												   <input  name="irrChFrm"  value="0.00" 
			          id="irrChFrm${m.resCheckId}"  type="hidden" /> 
			          
			                        <input  name="irrChTo"  value="0.00" 
			          id="irrChTo${m.resCheckId}"  type="hidden" /> 

												<textarea class="form-control" id="remarks${m.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
											</div>
									
											<div class="col-md-12">
												<button type="button" name="rescheckbutton3"
									id="rescheckbutton3"
									class="btn btn-1 btn-primary center-block "  onclick="addnrldchecksann1(this.form.id)" >Submit</button>
									</div>
									
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Edit Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${mcount.count}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${m.resCheckId}"  class="btn btn-1 btn-primary center-block  editannobs">Edit Observations</button>
									&emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${m.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${m.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${m.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${m.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${m.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">Edit/View Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>
									</c:forEach>
								</c:if>
							
							
						

						</div>

						<div id="oandm">

							
								
								
								<div class="col-md-12">
								
								<c:if test="${ann1resd!=null}">
								
								<c:forEach items="${ann1resd}" var="m" varStatus="dcount">
								
								<div class="col-md-1">
								
								<button type="button" name="omgen" id="annobs${m.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${m.resCheckId}',this.id)">${m.checkdisplayNum}</button>  
								</div>
								
								<c:if test="${dcount.count==12}">  <br> <br> </c:if>
								
								</c:forEach>
								
							
								
								</c:if>
								
								
								</div> 
						                

								<c:if test="${ann1resd!=null}">




									<c:forEach items="${ann1resd}" var="m" varStatus="mcount">
										<div class=" col-md-12 resmainobsinf" id="resmainobs${m.resCheckId}">
 

                                     <form:form id="resformom${m.resCheckId}" name="resformom${m.resCheckId}name"
								modelAttribute="rescheckObject" method="post"
								data-parsley-validate-if-empty="">


						
								<!-- start of om form -->
									
										<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${m.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${m.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${m.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="4" id="tabId${m.resCheckId}" type="hidden" /> 
									   <input name="annexureId" value="1" id="annexureId${m.resCheckId}" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyId${m.resCheckId}" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamId${m.resCheckId}" type="hidden"  	class="mainconditionofDamId"/>
    
    
    
    
    <input name="nextPostId" value="" id="nextPostId${m.resCheckId}" type="hidden" class="mainnextPostId" />
										
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="postId" value="${userObj.post}" id="postId${m.resCheckId}" class="mainpostId"
									type="hidden" />
									</c:if>
									<input name="nextEmpId" value="0" id="nextEmpId${m.resCheckId}" type="hidden" 	class="mainnextEmpId" />
						            <c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" name="empId" id="userempId${m.resCheckId}" type="hidden"  	class="mainuserempId" />
								</c:if> 
								
									<!-- end of om form ann1 form  --> 

									
											<div class="col-md-12">

												<label class="label-control rowlebel invDiv "
													for="parameter1">${m.checkdisplayNum} &emsp;&emsp; ${m.resCheck}</label> 
													<input
													name="resCheckId"
													value="${m.resCheckId}" id="resCheckId${m.resCheckId}"
													type="hidden" /> 
													
													<input type="hidden" class="form-control"
													id="resCatId${m.resCheckId}"
													name="resCatId"
													value="${m.resCategoryId}" />
											</div>
											<div class="col-md-12">
											
												 <input  name="irrChFrm"  value="0.00" 
			          id="irrChFrm${m.resCheckId}"  type="hidden" /> 
			          
			          <input  name="irrChTo"  value="0.00" 
			          id="irrChTo${m.resCheckId}"  type="hidden" /> 

												<textarea class="form-control" id="remarks${m.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
											</div>
											
											
										<div class="col-md-12">	
											<button type="button" name="rescheckbutton4"
									id="rescheckbutton${m.resCheckId}"
									class="btn btn-1 btn-primary center-block "  onclick="addnrldchecksann1(this.form.id)">Submit</button>
									</div>


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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete  Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${mcount.count}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${m.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs ">Edit Observations</button>
									&emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${m.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${m.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${m.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${m.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${m.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">Edit/View Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
										
										
										
									</c:forEach>
								</c:if>
								<br />

								<br />
								
								
								
							


						</div>
				
					
					<div id="addre">
					
				
			
   
	<form:form id="reviewformremann1" method="post" modelAttribute="rescheckObject"
		name="reviewformremann1name" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		<div class="col-md-12">
			
<!-- start of remarks form hidden data -->
				
       <input name="projectId" value="0" class="mainprojId"
											id="resprojectIdremann1" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirIdremann1" type="hidden" />
									
									<input name="tankId" value="0"  class="maintankId"
									id="maintankIdremann1" type="hidden" />
							
							
						
								<input name="year" value="0" id="yearremann1" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="3" id="tabIdremann1" type="hidden" /> 
									   <input name="annexureId" value="1" id="annexureIdrem" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyIdremann1" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamIdremann1" type="hidden"  	class="mainconditionofDamId"/>
    
    
    
    
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
		<label class="label-control rowlebel "> InspectDate</label>
			<input type="text"  class="datepick form-control datepicker "  id="inspectDateremann1"  name="inspectDate"  placeholder="dateofoperation" value="0" readonly="readonly"/>
		</div>
		<div class="col-md-12">
		<label class="label-control rowlebel "> Remarks</label>
			<textarea class="form-control" id="remarksremann1"
				name="remarks" rows="3" cols="50"
				placeholder="Review Details" required></textarea>
		</div>
	

  

		<div class="col-md-12">
		
				<label class="label-control rowlebel "></label>
				<input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block reviewbutton" id="reviewinfoid" 
					value="Add Remarks" onclick="AddRemarksInfo(this.form.id)">
			
		</div>
		
		</div>

	</form:form>


					
					
					</div>
					
					
					</div>
					
					<div id="2ann">
					
					
					here <c:out value="${rescatList[0].catNumDisplay}"></c:out>-<c:out value="${rescatList[0].resCategory}"></c:out>
					<!-- <div id="tabs2"> -->
						<ul>
						
					 	<c:if test="${rescatList!=null}">
					 	
					 	
						
					 <c:forEach items="${rescatList}" var="liinfo" varStatus="listcount">
					 
					
					 
					 <c:if test="${liinfo.resCatParentId==0 && liinfo.resCategoryId>=5 }">
						
					    <li><a href="#earth<c:out value="${liinfo.resCategoryId}"></c:out>" ><c:out value="${liinfo.catNumDisplay}"></c:out>-<c:out value="${liinfo.resCategory}"></c:out></a></li>
					  </c:if>  
					    </c:forEach>
						
						</c:if> 
							<!-- <li><a href="#earth" >A-Reservoir</a></li>
							<li><a href="#mason" >B.Dam and Dam Reach (Embankment) </a></li>
							<li><a href="#c" >C.Dam and Dam Block/Reach (Concrete/Masonry) </a></li>
							<li><a href="#d" >D.Gallery/Shaft and Drainage (Concrete/Masonry) </a></li>
							<li><a href="#e" >E.Spillway and Energy Dissipation Structure </a></li>
							<li><a href="#f" >F.Intake/Outlet and Water Conveyance Structure </a></li>
							<li><a href="#g" >G.Hydro-Mechanical Component and Pump </a></li>
						      <li><a href="#h" >H.Access Road </a></li>
						       <li><a href="#i" >I.Instrumentation </a></li>
						        <li><a href="#k" >K.Emergency Preparedness </a></li>
						          <li><a href="#l" >L.Inspection Photographs </a></li>
							<li><a href="#addre2" >Add Remarks Annexure II </a></li> -->
						
						</ul>
						
						
						
						
						<!-- </div> -->
						
						<c:if test="${rescatList!=null}">
						
						 <c:forEach items="${rescatList}" var="datainfo" varStatus="datacount">
						<div id="earth<c:out value="${datainfo.resCategoryId}"></c:out>">
						
						<!-- start of divs -->
						
						<div id="verticalearth<c:out value="${datainfo.resCategoryId}"></c:out>">
						 	
						  	<c:if test="${rescatList!=null}"> 
						 	
						 					<ul>
						 	
				  <c:forEach items="${rescatList}" var="k" varStatus="kcount">
					 
						<c:if test="${datainfo.resCatParentId==datainfo.resCategoryId && k.catTitle==false}"> 
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
								
							 <c:forEach items="${rescheckann2a}" var="g" varStatus="gcount">
						    	   <c:if test="${g.resCategoryId==l.resCategoryId && l.resCatParentId==datainfo.resCategoryId && g.isTitle==false}">
								<div class="col-md-1">
								
								<button type="button" name="earthann2" id="annobs${g.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${g.resCheckId}',this.id)"> ${g.checkdisplayNum}</button>  
								</div>
								
								<c:if test="${g.resCheckSeq==12}">  <br> <br> </c:if>
								
									</c:if>
								</c:forEach>
								
								<br><br>
								</div> 
								
							
					
				
						<c:if test="${rescatList!=null}">
						
						
						
						
						

					
						    	   <c:forEach items="${rescheckann2a}" var="n" varStatus="ncount">
						    	   <c:if test="${n.resCategoryId==l.resCategoryId && l.resCatParentId==datainfo.resCategoryId}">
						    	   

								
								
                     
                       <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
                       
                   
                     
                     	<form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
					
                         <!--    start of ann2ear form hidden values -->
								<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
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
													for="parameter1"><c:if test="${!(n.checkdisplayNum=='0')}">  ${n.checkdisplayNum} </c:if> &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
					

				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
			
							
							<div class="col-md-12">
							<br />
							<br />
							 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
							 </div>
							 
							 
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Edit Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit Observations</button>
									&emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">Edit/View Recommendations</button></td>
									</tr>

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
						
						<div id="earth">
						
						
						
						 	<div id="verticalearth">
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="k" varStatus="kcount">
					 
						<c:if test="${k.resCatParentId==5 && k.catTitle==false}"> 
					<li ><a  style="color:maroon;" href="#<c:out value="${kcount.count}"></c:out>" ><c:if test="${!(k.catNumDisplay=='0')}">  <c:out value="${k.catNumDisplay}"></c:out> </c:if>&emsp;&emsp;<c:out value="${k.resCategory}"></c:out></a></li>
					 
					</c:if>
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				<c:if test="${rescatList!=null}">
				 <c:forEach items="${rescatList}" var="l" varStatus="lcount">
				 <c:if test="${l.resCatParentId==5}"> 
				 
					<div id="${lcount.count}">
					
					
					
					
						    	   
					
					  
					  
					  <div class="col-md-12">
								
							 <c:forEach items="${rescheckann2a}" var="g" varStatus="gcount">
						    	   <c:if test="${g.resCategoryId==l.resCategoryId && l.resCatParentId==5 && g.isTitle==false}">
								<div class="col-md-1">
								
								<button type="button" name="earthann2" id="annobs${g.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${g.resCheckId}',this.id)"> ${g.checkdisplayNum}</button>  
								</div>
								
								<c:if test="${g.resCheckSeq==12}">  <br> <br> </c:if>
								
									</c:if>
								</c:forEach>
								
								<br><br>
								</div> 
								
							
					
				
						<c:if test="${rescatList!=null}">
						
						
						
						
						

					
						    	   <c:forEach items="${rescheckann2a}" var="n" varStatus="ncount">
						    	   <c:if test="${n.resCategoryId==l.resCategoryId && l.resCatParentId==5}">
						    	   

								
								
                     
                       <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
                       
                   
                     
                     	<form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
					
                         <!--    start of ann2ear form hidden values -->
								<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
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
													for="parameter1"><c:if test="${!(n.checkdisplayNum=='0')}">  ${n.checkdisplayNum} </c:if> &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
					

				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
			
							
							<div class="col-md-12">
							<br />
							<br />
							 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
							 </div>
							 
							 
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Edit Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit Observations</button>
									&emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">Edit/View Recommendations</button></td>
									</tr>

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
				
				</div>
						
						<div id="mason">
						
							
					
						
						<div id="verticalmason">
						
						
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="r" varStatus="rcount">
					 
					 <c:if test="${(r.resCatParentId==6) && (r.catTitle==false)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<li ><a  style="color:maroon; " href="#mas${catnum}" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </a></li>
					 
					</c:if>
					
					<c:if test="${(r.resCatParentId==6 ) && (r.catTitle==true)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<div class="col-md-12" style="color: maroon;" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </div>
					 
					</c:if>
					
					  
		
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				 <c:set var = "divcatnum" scope = "session" value = "0" />
				
				<c:if test="${rescatList!=null}">
				
				 <c:forEach items="${rescatList}" var="s" varStatus="scount">
				 
				
				 
				 
					
					
				 
				 	
					
				  <c:if test="${(s.resCatParentId==6  ) && (s.catTitle==false) }">  
				  
				
					   <c:set var = "divcatnum" scope = "session" value = "${s.resCategoryId}${scount.count}" />
					 
					
					 
				
				 
					<div id="mas${divcatnum}">
					
					
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: NA means sequence number is not provided in the documents/reports  </strong>
				<br>
				

			</div>
			</div>
			
					  
					  <div class="col-md-12">
					  <br><br>
								
							 <c:forEach items="${rescheckann2b}" var="q" varStatus="qcount">
						    	   <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==6   ) && q.isTitle==false) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-1">
								
							
								
								<button type="button" name="masann2" id="annobs${q.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${q.resCheckId}',this.id)"> ${q.checkdisplayNum}</button>  
								
								&emsp;&emsp;
								</div>								
															
								
								<c:if test="${q.resCheckSeq == 12}">  <br> <br> </c:if>
								
									<c:if test="${q.resCheckSeq == 24}">  <br> <br> </c:if>
								
									</c:if>
									
									
										
								
								 <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==6   ) && q.isTitle==true) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-12">
								<br><br>
								
								<div class="col-md-12" style="color: black;"><h4><strong> <c:if test="${!(q.checkdisplayNum=='0')}">  ${q.checkdisplayNum} </c:if> &emsp;&emsp; ${q.resCheck}</strong></h4> 	<br><br></div>  
								
								<br><br>
								</div>
								
								
								
									</c:if>
									
							
								</c:forEach>
								
								<br><br>
								</div> 
								
						
					
						
                        <c:if test="${rescatList!=null}">
					
						    	  <c:forEach items="${rescheckann2b}" var="n" varStatus="ncount">
						    	  
					
						    	   <c:if test="${n.resCategoryId==s.resCategoryId && (s.resCatParentId==6  ) && n.isTitle==false }">
					  <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
					  
	       <br><br>
	       
	       <form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="32" id="tabId${n.resCheckId}" type="hidden" /> 
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
          
                     
                     
					  <div class="col-md-12">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1">${n.checkdisplayNum} &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
					<div class="col-md-12">	 
					<br><br>
					
					 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
					 </div>
			
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit  Observations</button> &emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo " onclick="addrecmmn(${n.resCheckId})">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">View/Edit/Delete Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					</c:if>
					
						</c:forEach>	
				
					
				 	  </c:if>
					
						
					
					
					
						</div>
						</c:if>
						</c:forEach>
						</c:if>
						
				</div>
				</div>
				
				<!-- start of c -->
				
				<div id="c">
						
							
					
						
						<div id="verticalc">
						
						
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="r" varStatus="rcount">
					 
					 <c:if test="${(r.resCatParentId==7) && (r.catTitle==false)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<li ><a  style="color:maroon; " href="#mas${catnum}" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </a></li>
					 
					</c:if>
					
					<c:if test="${(r.resCatParentId==7) && (r.catTitle==true)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<div class="col-md-12" style="color: maroon;" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </div>
					 
					</c:if>
					
					  
		
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				 <c:set var = "divcatnum" scope = "session" value = "0" />
				
				<c:if test="${rescatList!=null}">
				
				 <c:forEach items="${rescatList}" var="s" varStatus="scount">
				 
				
				 
				 
					
					
				 
				 	
					
				  <c:if test="${(s.resCatParentId==7 ) && (s.catTitle==false) }">  
				  
				
					   <c:set var = "divcatnum" scope = "session" value = "${s.resCategoryId}${scount.count}" />
					 
					
					 
				
				 
					<div id="mas${divcatnum}">
					
					
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: NA means sequence number is not provided in the documents/reports  </strong>
				<br>
				

			</div>
			</div>
			
					  
					  <div class="col-md-12">
					  <br><br>
								
							 <c:forEach items="${rescheckann2c}" var="q" varStatus="qcount">
						    	   <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==7  ) && q.isTitle==false) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-1">
								
							
								
								<button type="button" name="masann2" id="annobs${q.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${q.resCheckId}',this.id)"> ${q.checkdisplayNum}</button>  
								
								&emsp;&emsp;
								</div>								
															
								
								<c:if test="${q.resCheckSeq == 12}">  <br> <br> </c:if>
								
									<c:if test="${q.resCheckSeq == 24}">  <br> <br> </c:if>
								
									</c:if>
									
									
										
								
								 <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==7  ) && q.isTitle==true) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-12">
								<br><br>
								
								<div class="col-md-12" style="color: black;"><h4><strong> <c:if test="${!(q.checkdisplayNum=='0')}">  ${q.checkdisplayNum} </c:if> &emsp;&emsp; ${q.resCheck}</strong></h4> 	<br><br></div>  
								
								<br><br>
								</div>
								
								
								
									</c:if>
									
							
								</c:forEach>
								
								<br><br>
								</div> 
								
						
					
						
                        <c:if test="${rescatList!=null}">
					
						    	  <c:forEach items="${rescheckann2c}" var="n" varStatus="ncount">
						    	  
					
						    	   <c:if test="${n.resCategoryId==s.resCategoryId && (s.resCatParentId==7 ) && n.isTitle==false }">
					  <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
					  
	       <br><br>
	       
	       <form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="32" id="tabId${n.resCheckId}" type="hidden" /> 
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
          
                     
                     
					  <div class="col-md-12">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1">${n.checkdisplayNum} &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
					<div class="col-md-12">	 
					<br><br>
					
					 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
					 </div>
			
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit  Observations</button> &emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo " onclick="addrecmmn(${n.resCheckId})">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">View/Edit/Delete Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					</c:if>
					
						</c:forEach>	
				
					
				 	  </c:if>
					
						
					
					
					
						</div>
						</c:if>
						</c:forEach>
						</c:if>
						
				</div>
				</div>
				
			<!-- 	start of d -->
				<div id="d">
						
							
					
						
						<div id="verticald">
						
						
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="r" varStatus="rcount">
					 
					 <c:if test="${(r.resCatParentId==8) && (r.catTitle==false)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<li ><a  style="color:maroon; " href="#mas${catnum}" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </a></li>
					 
					</c:if>
					
					<c:if test="${(r.resCatParentId==8) && (r.catTitle==true)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<div class="col-md-12" style="color: maroon;" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </div>
					 
					</c:if>
					
					  
		
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				 <c:set var = "divcatnum" scope = "session" value = "0" />
				
				<c:if test="${rescatList!=null}">
				
				 <c:forEach items="${rescatList}" var="s" varStatus="scount">
				 
				
				 
				 
					
					
				 
				 	
					
				  <c:if test="${(s.resCatParentId==8 ) && (s.catTitle==false) }">  
				  
				
					   <c:set var = "divcatnum" scope = "session" value = "${s.resCategoryId}${scount.count}" />
					 
					
					 
				
				 
					<div id="mas${divcatnum}">
					
					
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: NA means sequence number is not provided in the documents/reports  </strong>
				<br>
				

			</div>
			</div>
			
					  
					  <div class="col-md-12">
					  <br><br>
								
							 <c:forEach items="${rescheckann2d}" var="q" varStatus="qcount">
						    	   <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==8  ) && q.isTitle==false) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-1">
								
							
								
								<button type="button" name="masann2" id="annobs${q.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${q.resCheckId}',this.id)"> ${q.checkdisplayNum}</button>  
								
								&emsp;&emsp;
								</div>								
															
								
								<c:if test="${q.resCheckSeq == 12}">  <br> <br> </c:if>
								
									<c:if test="${q.resCheckSeq == 24}">  <br> <br> </c:if>
								
									</c:if>
									
									
										
								
								 <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==8  ) && q.isTitle==true) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-12">
								<br><br>
								
								<div class="col-md-12" style="color: black;"><h4><strong> <c:if test="${!(q.checkdisplayNum=='0')}">  ${q.checkdisplayNum} </c:if> &emsp;&emsp; ${q.resCheck}</strong></h4> 	<br><br></div>  
								
								<br><br>
								</div>
								
								
								
									</c:if>
									
							
								</c:forEach>
								
								<br><br>
								</div> 
								
						
					
						
                        <c:if test="${rescatList!=null}">
					
						    	  <c:forEach items="${rescheckann2d}" var="n" varStatus="ncount">
						    	  
					
						    	   <c:if test="${n.resCategoryId==s.resCategoryId && (s.resCatParentId==8 ) && n.isTitle==false }">
					  <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
					  
	       <br><br>
	       
	       <form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="32" id="tabId${n.resCheckId}" type="hidden" /> 
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
          
                     
                     
					  <div class="col-md-12">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1">${n.checkdisplayNum} &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
					<div class="col-md-12">	 
					<br><br>
					
					 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
					 </div>
			
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit  Observations</button> &emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo " onclick="addrecmmn(${n.resCheckId})">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">View/Edit/Delete Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					</c:if>
					
						</c:forEach>	
				
					
				 	  </c:if>
					
						
					
					
					
						</div>
						</c:if>
						</c:forEach>
						</c:if>
						
				</div>
				</div>
				
			<!-- 	start of e -->
				
				<div id="e">
						
							
					
						
						<div id="verticale">
						
						
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="r" varStatus="rcount">
					 
					 <c:if test="${(r.resCatParentId==9) && (r.catTitle==false)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<li ><a  style="color:maroon; " href="#mas${catnum}" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </a></li>
					 
					</c:if>
					
					<c:if test="${(r.resCatParentId==9) && (r.catTitle==true)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<div class="col-md-12" style="color: maroon;" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </div>
					 
					</c:if>
					
					  
		
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				 <c:set var = "divcatnum" scope = "session" value = "0" />
				
				<c:if test="${rescatList!=null}">
				
				 <c:forEach items="${rescatList}" var="s" varStatus="scount">
				 
				
				 
				 
					
					
				 
				 	
					
				  <c:if test="${(s.resCatParentId==9 ) && (s.catTitle==false) }">  
				  
				
					   <c:set var = "divcatnum" scope = "session" value = "${s.resCategoryId}${scount.count}" />
					 
					
					 
				
				 
					<div id="mas${divcatnum}">
					
					
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: NA means sequence number is not provided in the documents/reports  </strong>
				<br>
				

			</div>
			</div>
			
					  
					  <div class="col-md-12">
					  <br><br>
								
							 <c:forEach items="${rescheckann2e}" var="q" varStatus="qcount">
						    	   <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==9  ) && q.isTitle==false) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-1">
								
							
								
								<button type="button" name="masann2" id="annobs${q.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${q.resCheckId}',this.id)"> ${q.checkdisplayNum}</button>  
								
								&emsp;&emsp;
								</div>								
															
								
								<c:if test="${q.resCheckSeq == 12}">  <br> <br> </c:if>
								
									<c:if test="${q.resCheckSeq == 24}">  <br> <br> </c:if>
								
									</c:if>
									
									
										
								
								 <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==9  ) && q.isTitle==true) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-12">
								<br><br>
								
								<div class="col-md-12" style="color: black;"><h4><strong> <c:if test="${!(q.checkdisplayNum=='0')}">  ${q.checkdisplayNum} </c:if> &emsp;&emsp; ${q.resCheck}</strong></h4> 	<br><br></div>  
								
								<br><br>
								</div>
								
								
								
									</c:if>
									
							
								</c:forEach>
								
								<br><br>
								</div> 
								
						
					
						
                        <c:if test="${rescatList!=null}">
					
						    	  <c:forEach items="${rescheckann2e}" var="n" varStatus="ncount">
						    	  
					
						    	   <c:if test="${n.resCategoryId==s.resCategoryId && (s.resCatParentId==9 ) && n.isTitle==false }">
					  <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
					  
	       <br><br>
	       
	       <form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="32" id="tabId${n.resCheckId}" type="hidden" /> 
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
          
                     
                     
					  <div class="col-md-12">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1">${n.checkdisplayNum} &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
					<div class="col-md-12">	 
					<br><br>
					
					 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
					 </div>
			
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit  Observations</button> &emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo " onclick="addrecmmn(${n.resCheckId})">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">View/Edit/Delete Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					</c:if>
					
						</c:forEach>	
				
					
				 	  </c:if>
					
						
					
					
					
						</div>
						</c:if>
						</c:forEach>
						</c:if>
						
				</div>
				</div>
				
				
				<!-- start of f -->
				<div id="f">
						
							
					
						
						<div id="verticalf">
						
						
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="r" varStatus="rcount">
					 
					 <c:if test="${(r.resCatParentId==10) && (r.catTitle==false)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<li ><a  style="color:maroon; " href="#mas${catnum}" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </a></li>
					 
					</c:if>
					
					<c:if test="${(r.resCatParentId==10) && (r.catTitle==true)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<div class="col-md-12" style="color: maroon;" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </div>
					 
					</c:if>
					
					  
		
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				 <c:set var = "divcatnum" scope = "session" value = "0" />
				
				<c:if test="${rescatList!=null}">
				
				 <c:forEach items="${rescatList}" var="s" varStatus="scount">
				 
				
				 
				 
					
					
				 
				 	
					
				  <c:if test="${(s.resCatParentId==10 ) && (s.catTitle==false) }">  
				  
				
					   <c:set var = "divcatnum" scope = "session" value = "${s.resCategoryId}${scount.count}" />
					 
					
					 
				
				 
					<div id="mas${divcatnum}">
					
					
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: NA means sequence number is not provided in the documents/reports  </strong>
				<br>
				

			</div>
			</div>
			
					  
					  <div class="col-md-12">
					  <br><br>
								
							 <c:forEach items="${rescheckann2f}" var="q" varStatus="qcount">
						    	   <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==10  ) && q.isTitle==false) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-1">
								
							
								
								<button type="button" name="masann2" id="annobs${q.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${q.resCheckId}',this.id)"> ${q.checkdisplayNum}</button>  
								
								&emsp;&emsp;
								</div>								
															
								
								<c:if test="${q.resCheckSeq == 12}">  <br> <br> </c:if>
								
									<c:if test="${q.resCheckSeq == 24}">  <br> <br> </c:if>
								
									</c:if>
									
									
										
								
								 <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==10  ) && q.isTitle==true) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-12">
								<br><br>
								
								<div class="col-md-12" style="color: black;"><h4><strong> <c:if test="${!(q.checkdisplayNum=='0')}">  ${q.checkdisplayNum} </c:if> &emsp;&emsp; ${q.resCheck}</strong></h4> 	<br><br></div>  
								
								<br><br>
								</div>
								
								
								
									</c:if>
									
							
								</c:forEach>
								
								<br><br>
								</div> 
								
						
					
						
                        <c:if test="${rescatList!=null}">
					
						    	  <c:forEach items="${rescheckann2f}" var="n" varStatus="ncount">
						    	  
					
						    	   <c:if test="${n.resCategoryId==s.resCategoryId && (s.resCatParentId==10 ) && n.isTitle==false }">
					  <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
					  
	       <br><br>
	       
	       <form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="32" id="tabId${n.resCheckId}" type="hidden" /> 
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
          
                     
                     
					  <div class="col-md-12">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1">${n.checkdisplayNum} &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
					<div class="col-md-12">	 
					<br><br>
					
					 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
					 </div>
			
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit  Observations</button> &emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo " onclick="addrecmmn(${n.resCheckId})">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">View/Edit/Delete Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					</c:if>
					
						</c:forEach>	
				
					
				 	  </c:if>
					
						
					
					
					
						</div>
						</c:if>
						</c:forEach>
						</c:if>
						
				</div>
				</div>
				
			<!-- 	start of g -->
				<div id="g">
						
							
					
						
						<div id="verticalg">
						
						
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="r" varStatus="rcount">
					 
					 <c:if test="${(r.resCatParentId==11) && (r.catTitle==false)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<li ><a  style="color:maroon; " href="#mas${catnum}" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </a></li>
					 
					</c:if>
					
					<c:if test="${(r.resCatParentId==11) && (r.catTitle==true)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<div class="col-md-12" style="color: maroon;" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </div>
					 
					</c:if>
					
					  
		
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				 <c:set var = "divcatnum" scope = "session" value = "0" />
				
				<c:if test="${rescatList!=null}">
				
				 <c:forEach items="${rescatList}" var="s" varStatus="scount">
				 
				
				 
				 
					
					
				 
				 	
					
				  <c:if test="${(s.resCatParentId==11 ) && (s.catTitle==false) }">  
				  
				
					   <c:set var = "divcatnum" scope = "session" value = "${s.resCategoryId}${scount.count}" />
					 
					
					 
				
				 
					<div id="mas${divcatnum}">
					
					
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: NA means sequence number is not provided in the documents/reports  </strong>
				<br>
				

			</div>
			</div>
			
					  
					  <div class="col-md-12">
					  <br><br>
								
							 <c:forEach items="${rescheckann2g}" var="q" varStatus="qcount">
						    	   <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==11  ) && q.isTitle==false) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-1">
								
							
								
								<button type="button" name="masann2" id="annobs${q.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${q.resCheckId}',this.id)"> ${q.checkdisplayNum}</button>  
								
								&emsp;&emsp;
								</div>								
															
								
								<c:if test="${q.resCheckSeq == 12}">  <br> <br> </c:if>
								
									<c:if test="${q.resCheckSeq == 24}">  <br> <br> </c:if>
								
									</c:if>
									
									
										
								
								 <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==11  ) && q.isTitle==true) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-12">
								<br><br>
								
								<div class="col-md-12" style="color: black;"><h4><strong> <c:if test="${!(q.checkdisplayNum=='0')}">  ${q.checkdisplayNum} </c:if> &emsp;&emsp; ${q.resCheck}</strong></h4> 	<br><br></div>  
								
								<br><br>
								</div>
								
								
								
									</c:if>
									
							
								</c:forEach>
								
								<br><br>
								</div> 
								
						
					
						
                        <c:if test="${rescatList!=null}">
					
						    	  <c:forEach items="${rescheckann2g}" var="n" varStatus="ncount">
						    	  
					
						    	   <c:if test="${n.resCategoryId==s.resCategoryId && (s.resCatParentId==11 ) && n.isTitle==false }">
					  <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
					  
	       <br><br>
	       
	       <form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="32" id="tabId${n.resCheckId}" type="hidden" /> 
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
          
                     
                     
					  <div class="col-md-12">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1">${n.checkdisplayNum} &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
					<div class="col-md-12">	 
					<br><br>
					
					 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
					 </div>
			
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit  Observations</button> &emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo " onclick="addrecmmn(${n.resCheckId})">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">View/Edit/Delete Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					</c:if>
					
						</c:forEach>	
				
					
				 	  </c:if>
					
						
					
					
					
						</div>
						</c:if>
						</c:forEach>
						</c:if>
						
				</div>
				</div>
				
				<!-- start of h -->
				
				<div id="h">
						
							
					
						
						<div id="verticalh">
						
						
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="r" varStatus="rcount">
					 
					 <c:if test="${(r.resCatParentId==12) && (r.catTitle==false)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<li ><a  style="color:maroon; " href="#mas${catnum}" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </a></li>
					 
					</c:if>
					
					<c:if test="${(r.resCatParentId==12) && (r.catTitle==true)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<div class="col-md-12" style="color: maroon;" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </div>
					 
					</c:if>
					
					  
		
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				 <c:set var = "divcatnum" scope = "session" value = "0" />
				
				<c:if test="${rescatList!=null}">
				
				 <c:forEach items="${rescatList}" var="s" varStatus="scount">
				 
				
				 
				 
					
					
				 
				 	
					
				  <c:if test="${(s.resCatParentId==12 ) && (s.catTitle==false) }">  
				  
				
					   <c:set var = "divcatnum" scope = "session" value = "${s.resCategoryId}${scount.count}" />
					 
					
					 
				
				 
					<div id="mas${divcatnum}">
					
					
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: NA means sequence number is not provided in the documents/reports  </strong>
				<br>
				

			</div>
			</div>
			
					  
					  <div class="col-md-12">
					  <br><br>
								
							 <c:forEach items="${rescheckann2h}" var="q" varStatus="qcount">
						    	   <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==12  ) && q.isTitle==false) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-1">
								
							
								
								<button type="button" name="masann2" id="annobs${q.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${q.resCheckId}',this.id)"> ${q.checkdisplayNum}</button>  
								
								&emsp;&emsp;
								</div>								
															
								
								<c:if test="${q.resCheckSeq == 12}">  <br> <br> </c:if>
								
									<c:if test="${q.resCheckSeq == 24}">  <br> <br> </c:if>
								
									</c:if>
									
									
										
								
								 <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==12  ) && q.isTitle==true) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-12">
								<br><br>
								
								<div class="col-md-12" style="color: black;"><h4><strong> <c:if test="${!(q.checkdisplayNum=='0')}">  ${q.checkdisplayNum} </c:if> &emsp;&emsp; ${q.resCheck}</strong></h4> 	<br><br></div>  
								
								<br><br>
								</div>
								
								
								
									</c:if>
									
							
								</c:forEach>
								
								<br><br>
								</div> 
								
						
					
						
                        <c:if test="${rescatList!=null}">
					
						    	  <c:forEach items="${rescheckann2h}" var="n" varStatus="ncount">
						    	  
					
						    	   <c:if test="${n.resCategoryId==s.resCategoryId && (s.resCatParentId==12 ) && n.isTitle==false }">
					  <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
					  
	       <br><br>
	       
	       <form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="32" id="tabId${n.resCheckId}" type="hidden" /> 
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
          
                     
                     
					  <div class="col-md-12">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1">${n.checkdisplayNum} &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
					<div class="col-md-12">	 
					<br><br>
					
					 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
					 </div>
			
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit  Observations</button> &emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo " onclick="addrecmmn(${n.resCheckId})">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">View/Edit/Delete Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					</c:if>
					
						</c:forEach>	
				
					
				 	  </c:if>
					
						
					
					
					
						</div>
						</c:if>
						</c:forEach>
						</c:if>
						
				</div>
				</div>
				
				<!-- start of i -->
				<div id="i">
						
							
					
						
						<div id="verticali">
						
						
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="r" varStatus="rcount">
					 
					 <c:if test="${(r.resCatParentId==13) && (r.catTitle==false)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<li ><a  style="color:maroon; " href="#mas${catnum}" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </a></li>
					 
					</c:if>
					
					<c:if test="${(r.resCatParentId==13) && (r.catTitle==true)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<div class="col-md-12" style="color: maroon;" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </div>
					 
					</c:if>
					
					  
		
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				 <c:set var = "divcatnum" scope = "session" value = "0" />
				
				<c:if test="${rescatList!=null}">
				
				 <c:forEach items="${rescatList}" var="s" varStatus="scount">
				 
				
				 
				 
					
					
				 
				 	
					
				  <c:if test="${(s.resCatParentId==13 ) && (s.catTitle==false) }">  
				  
				
					   <c:set var = "divcatnum" scope = "session" value = "${s.resCategoryId}${scount.count}" />
					 
					
					 
				
				 
					<div id="mas${divcatnum}">
					
					
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: NA means sequence number is not provided in the documents/reports  </strong>
				<br>
				

			</div>
			</div>
			
					  
					  <div class="col-md-12">
					  <br><br>
								
							 <c:forEach items="${rescheckann2i}" var="q" varStatus="qcount">
						    	   <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==13  ) && q.isTitle==false) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-1">
								
							
								
								<button type="button" name="masann2" id="annobs${q.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${q.resCheckId}',this.id)"> ${q.checkdisplayNum}</button>  
								
								&emsp;&emsp;
								</div>								
															
								
								<c:if test="${q.resCheckSeq == 12}">  <br> <br> </c:if>
								
									<c:if test="${q.resCheckSeq == 24}">  <br> <br> </c:if>
								
									</c:if>
									
									
										
								
								 <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==13  ) && q.isTitle==true) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-12">
								<br><br>
								
								<div class="col-md-12" style="color: black;"><h4><strong> <c:if test="${!(q.checkdisplayNum=='0')}">  ${q.checkdisplayNum} </c:if> &emsp;&emsp; ${q.resCheck}</strong></h4> 	<br><br></div>  
								
								<br><br>
								</div>
								
								
								
									</c:if>
									
							
								</c:forEach>
								
								<br><br>
								</div> 
								
						
					
						
                        <c:if test="${rescatList!=null}">
					
						    	  <c:forEach items="${rescheckann2i}" var="n" varStatus="ncount">
						    	  
					
						    	   <c:if test="${n.resCategoryId==s.resCategoryId && (s.resCatParentId==13 ) && n.isTitle==false }">
					  <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
					  
	       <br><br>
	       
	       <form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="32" id="tabId${n.resCheckId}" type="hidden" /> 
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
          
                     
                     
					  <div class="col-md-12">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1">${n.checkdisplayNum} &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
					<div class="col-md-12">	 
					<br><br>
					
					 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
					 </div>
			
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit  Observations</button> &emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo " onclick="addrecmmn(${n.resCheckId})">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">View/Edit/Delete Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					</c:if>
					
						</c:forEach>	
				
					
				 	  </c:if>
					
						
					
					
					
						</div>
						</c:if>
						</c:forEach>
						</c:if>
						
				</div>
				</div>
			<!-- 	strat of k -->
				<div id="k">
						
							
					
						
						<div id="verticalk">
						
						
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="r" varStatus="rcount">
					 
					 <c:if test="${(r.resCatParentId==14) && (r.catTitle==false)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<li ><a  style="color:maroon; " href="#mas${catnum}" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </a></li>
					 
					</c:if>
					
					<c:if test="${(r.resCatParentId==14) && (r.catTitle==true)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<div class="col-md-12" style="color: maroon;" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </div>
					 
					</c:if>
					
					  
		
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				 <c:set var = "divcatnum" scope = "session" value = "0" />
				
				<c:if test="${rescatList!=null}">
				
				 <c:forEach items="${rescatList}" var="s" varStatus="scount">
				 
				
				 
				 
					
					
				 
				 	
					
				  <c:if test="${(s.resCatParentId==14 ) && (s.catTitle==false) }">  
				  
				
					   <c:set var = "divcatnum" scope = "session" value = "${s.resCategoryId}${scount.count}" />
					 
					
					 
				
				 
					<div id="mas${divcatnum}">
					
					
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: NA means sequence number is not provided in the documents/reports  </strong>
				<br>
				

			</div>
			</div>
			
					  
					  <div class="col-md-12">
					  <br><br>
								
							 <c:forEach items="${rescheckann2k}" var="q" varStatus="qcount">
						    	   <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==14  ) && q.isTitle==false) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-1">
								
							
								
								<button type="button" name="masann2" id="annobs${q.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${q.resCheckId}',this.id)"> ${q.checkdisplayNum}</button>  
								
								&emsp;&emsp;
								</div>								
															
								
								<c:if test="${q.resCheckSeq == 12}">  <br> <br> </c:if>
								
									<c:if test="${q.resCheckSeq == 24}">  <br> <br> </c:if>
								
									</c:if>
									
									
										
								
								 <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==14  ) && q.isTitle==true) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-12">
								<br><br>
								
								<div class="col-md-12" style="color: black;"><h4><strong> <c:if test="${!(q.checkdisplayNum=='0')}">  ${q.checkdisplayNum} </c:if> &emsp;&emsp; ${q.resCheck}</strong></h4> 	<br><br></div>  
								
								<br><br>
								</div>
								
								
								
									</c:if>
									
							
								</c:forEach>
								
								<br><br>
								</div> 
								
						
					
						
                        <c:if test="${rescatList!=null}">
					
						    	  <c:forEach items="${rescheckann2k}" var="n" varStatus="ncount">
						    	  
					
						    	   <c:if test="${n.resCategoryId==s.resCategoryId && (s.resCatParentId==14 ) && n.isTitle==false }">
					  <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
					  
	       <br><br>
	       
	       <form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="32" id="tabId${n.resCheckId}" type="hidden" /> 
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
          
                     
                     
					  <div class="col-md-12">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1">${n.checkdisplayNum} &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
					<div class="col-md-12">	 
					<br><br>
					
					 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
					 </div>
			
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit  Observations</button> &emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo " onclick="addrecmmn(${n.resCheckId})">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">View/Edit/Delete Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					</c:if>
					
						</c:forEach>	
				
					
				 	  </c:if>
					
						
					
					
					
						</div>
						</c:if>
						</c:forEach>
						</c:if>
						
				</div>
				</div>
				
				<!-- start of l -->
				
				<div id="l">
						
							
					
						
						<div id="verticall">
						
						
						 	
						 	<c:if test="${rescatList!=null}">
						 	
						 					<ul>
						 	
					 <c:forEach items="${rescatList}" var="r" varStatus="rcount">
					 
					 <c:if test="${(r.resCatParentId==15) && (r.catTitle==false)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<li ><a  style="color:maroon; " href="#mas${catnum}" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </a></li>
					 
					</c:if>
					
					<c:if test="${(r.resCatParentId==15) && (r.catTitle==true)  }"> 
					   <c:set var = "catnum" scope = "session" value = "${r.resCategoryId}${rcount.count}" />
					 
					<div class="col-md-12" style="color: maroon;" > ${r.catNumDisplay}&emsp;&emsp;<c:out value="${r.resCategory}"></c:out>    </div>
					 
					</c:if>
					
					  
		
					</c:forEach>
					
				</ul>
				
				</c:if>
				
				 <c:set var = "divcatnum" scope = "session" value = "0" />
				
				<c:if test="${rescatList!=null}">
				
				 <c:forEach items="${rescatList}" var="s" varStatus="scount">
				 
				
				 
				 
					
					
				 
				 	
					
				  <c:if test="${(s.resCatParentId==15 ) && (s.catTitle==false) }">  
				  
				
					   <c:set var = "divcatnum" scope = "session" value = "${s.resCategoryId}${scount.count}" />
					 
					
					 
				
				 
					<div id="mas${divcatnum}">
					
					
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: NA means sequence number is not provided in the documents/reports  </strong>
				<br>
				

			</div>
			</div>
			
					  
					  <div class="col-md-12">
					  <br><br>
								
							 <c:forEach items="${rescheckann2l}" var="q" varStatus="qcount">
						    	   <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==15  ) && q.isTitle==false) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-1">
								
							
								
								<button type="button" name="masann2" id="annobs${q.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${q.resCheckId}',this.id)"> ${q.checkdisplayNum}</button>  
								
								&emsp;&emsp;
								</div>								
															
								
								<c:if test="${q.resCheckSeq == 12}">  <br> <br> </c:if>
								
									<c:if test="${q.resCheckSeq == 24}">  <br> <br> </c:if>
								
									</c:if>
									
									
										
								
								 <c:if test="${q.resCategoryId==s.resCategoryId && ((s.resCatParentId==15  ) && q.isTitle==true) }">
						    	   
						    	  <!--  || s.resCatParentId==19 -->
								<div class="col-md-12">
								<br><br>
								
								<div class="col-md-12" style="color: black;"><h4><strong> <c:if test="${!(q.checkdisplayNum=='0')}">  ${q.checkdisplayNum} </c:if> &emsp;&emsp; ${q.resCheck}</strong></h4> 	<br><br></div>  
								
								<br><br>
								</div>
								
								
								
									</c:if>
									
							
								</c:forEach>
								
								<br><br>
								</div> 
								
						
					
						
                        <c:if test="${rescatList!=null}">
					
						    	  <c:forEach items="${rescheckann2l}" var="n" varStatus="ncount">
						    	  
					
						    	   <c:if test="${n.resCategoryId==s.resCategoryId && (s.resCatParentId==15 ) && n.isTitle==false }">
					  <div class=" col-md-12 resmainobsinf" id="resmainobs${n.resCheckId}">
					  
	       <br><br>
	       
	       <form:form id="resann2form${n.resCheckId}" name="resann2form${n.resCheckId}name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="resreservoirId${n.resCheckId}" type="hidden" />
							
						
								<input name="year" value="0" id="year${n.resCheckId}" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="32" id="tabId${n.resCheckId}" type="hidden" /> 
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
          
                     
                     
					  <div class="col-md-12">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1">${n.checkdisplayNum} &emsp;&emsp; ${n.resCheck}</label> <input
													name="resCheckId"
													value="${n.resCheckId}" id="resCheckId${n.resCheckId}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="resCatId${n.resCheckId}"
													name="resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-12">	 
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-6">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
										
											<input
											name="irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-6">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${n.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
					
					<div class="col-md-12">	 
					<br><br>
					
					 <button type="button" name="rescheckbutton" id="rescheckbutton${n.resCheckId}" class="btn btn-1 btn-primary center-block " onclick="addnrldchecksann1(this.form.id)" >Submit</button>
					 </div>
			
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
											<th>Add Photos/Documents</th>
											<th>view/Delete Photos/Documents</th>
											<th>Add Recommendations</th>
											
											<th>View/Edit/Delete Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit  Observations</button> &emsp;&emsp;
									<button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									<td><button type="button" name="ann1edit2" 	id="resaddpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block addphotoinf ">Add Photos/Documents</button></td>
									<td><button type="button" name="ann1edit3" 	id="resviewpht${n.resCheckId}"  class="btn btn-1 btn-primary center-block viewphtinf ">View/Delete Documents/photos</button></td>
									<td><button type="button" name="ann1edit4" 	id="resaddrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block addrecminfo " onclick="addrecmmn(${n.resCheckId})">Add Recommendations</button></td>
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block editrecminfo">View/Edit/Delete Recommendations</button></td>
									</tr>

											</tbody>
										</table>
									</div>


								</div>
							</div>	
					
					<!-- end of div data -->
					
					
					</c:if>
					
						</c:forEach>	
				
					
				 	  </c:if>
					
						
					
					
					
						</div>
						</c:if>
						</c:forEach>
						</c:if>
						
				</div>
				</div>
						
										
						
					<div id="addre2">
					
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
					
					</div>
					
					
					</div>
					
					
				
					
					
					
					<div id="history">
				
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
				
				
				</div>
					
					<div id="capacity">
				
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
				
				
				</div>
					
					<div id="health">
				
				<form:form id="reshealthform5" name="reshealthform5name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						
								<input name="projectId" value="0" class="mainprojId"
											id="reshealthann2" type="hidden" />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="reshealthann2" type="hidden" />
							
						
								<input name="year" value="0" id="yearhealth" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="51" id="tabIdhealth" type="hidden" /> 
									   <input name="annexureId" value="0" id="annexurehealth" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyIdhealth" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamIdhealth" type="hidden"  	class="mainconditionofDamId"/>
    
    
    
    
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
						  <br>
                     
					   <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select
								Category: <font color=red>*</font>
							</label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="deficiencyCategory" name="deficiencyCategory"
								required>
								<option value=" ">--select--</option>
								<option value="1">1-Deficiencies which may lead to failure</option>
								<option value="2">2-Major Deficiencies required for  prompt remediable measures</option>
								<option value="3">3-Minor remediable measures which are rectifiable during the year</option>
								


							</select>
						</div>
						
						 <br>
						  <br>
						<div class="col-md-6"> 
    <label class="label-controlPMS rowlebel ">Select Inspection Date: <font
							color=red>*</font>
						</label>	
						</div>
    
    <div class="col-md-6">
					
				<select class="form-control" id="healthinspectOfficeInfoId" name="inspectOfficeInfoId"
								required>
								

							</select>
					</div>
					
					 <br>
						  <br>
						 <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Significant Deficiencies Noticed/Observations: <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
				<textarea class="form-control" id="reshealth6remarks" 	name="remarks" rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					 <br>
						  <br>
					  
						</div>   	
					
						 <div class="col-md-12">
						 <br>
						  <br>
						 <button type="button" name="rescheckbutton5" id="rescheckbutton5" class="btn btn-1 btn-primary center-block "  onclick="addresdamhealth(this.form.id)" >Submit</button>
						 
						  <br>
						  <br>
						 </div>
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
					<div id="ats">
				
				<form:form id="resann2form7" name="resann2form7name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
					
						
						<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId7" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId7" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId7" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId7" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId7" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId7" type="hidden" />
								 <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId7" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId7" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId7" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year7"
									type="hidden" />
									 <input name="reservoirInspectList[0].tabId" value="7" id="tabId7" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId7" type="hidden" /> 
						                    <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId7" type="hidden" /> 
						               <div class="col-md-12">     
						<!--                      <div class="col-md-1">
                     
                     <input name="reservoirInspectList[0].resCheckboxId" 	class="rescustomcheck7" value="0"  id="resCheckboxId0" type="checkbox" />
                    
                     </div> --> 
                     
                     <div class="col-md-6"> 
    <label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>	
						</div>
    
    <div class="col-md-6">
    
    <select class="form-control" id="resatc71inspectDate" name="resinspectInfoId"
								required onchange="getResDamHealthDetailsByInspectInfo(this.value)">
								<option value=" ">--select--</option>
					
							</select>
					
				
					</div>
                     
        
					
					<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Category <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
						 <input name="resDamHealthId" value="1" id="resDamHealthId" type="hidden" /> 
						
				<textarea id="atchealthcategory" class="form-control"  rows="3" cols="50" placeholder="Observations" readonly="readonly"></textarea>
					</div>
					
					<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Observations / Significant Deficiencies Noticed: <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
						
						
				<textarea id="atchealthremarks" class="form-control"  rows="3" cols="50" placeholder="Observations" readonly="readonly"> </textarea>
					</div>
					
					
					        <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Recommendation: <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
						 <input name="reservoirInspectList[0].resRecommendId" value="1" id="resRecommendId" type="hidden" /> 
						
				<textarea class="form-control"  rows="3" cols="50" placeholder="Observations" readonly="readonly"> text here recommend</textarea>
					</div>

					 <div class="col-md-6">
				<label class="label-controlPMS rowlebel ">Whether Action initiated  :<font
							color=red>*</font>
						</label>
						</div>
						
						  <div class="col-md-6">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakeninit" id="actionTakeninitn"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakeninit" id="actionTakeninity"     value="true"   >Yes</label>
       
          
    </div>
    
     <div class="col-md-6">
				<label class="label-controlPMS rowlebel ">Whether action completed  :<font
							color=red>*</font>
						</label>
						</div>
						
						  <div class="col-md-6">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompleten"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompletey"     value="true"   >Yes</label>
       
          
    </div>
    
					   
					   <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Remarks/Reasons for pending  : <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
				<textarea class="form-control" id="restab7remarks" 	name="reservoirInspectList[0].remarks" rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					</div>
						    	   
					
						 <br />
						 <button type="button" name="rescheckbutton7" id="rescheckbutton7" class="btn btn-1 btn-primary center-block rescheckbutton" >Submit</button>
					</form:form>
					
					
					 <div id="acttaken"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table7">
						<thead id="thead7"> </thead>
						
						<tbody id="tbody7"></tbody>
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
										<table class=" display table-bordered table1" style="width: 100%"
											id="viewresdataid">
											<thead id="viewprojectsdatahead">
											<tr style="font-weight: bold;"> 
											<th>S.No.</th>
											<th>Project</th>
											
											<th>Reservoirs</th>
																			
										
											
											
											
											
											
											 </tr>

											</thead>


											<tbody id="viewprojectsdatabosy">
											
											<c:forEach items="${projectList}" var="t" varStatus="count">
										<%--   <c:if test="${t.unitId>0&&t.circleId<=0&&t.divisionId<=0}">	 --%>
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
											  
											
												<td style="color: blue;"><c:out value="${t.projectName}"></c:out></td>
											
											<c:choose>
											<c:when test="${reservoirList!=null }">
												<td>
										
												
												<table class="table-bordered">
												<c:forEach items="${reservoirList}" var="m" varStatus="count">
												
												<c:choose>
												<c:when test="${m.projectId==t.projectId}">
												<tr>
												<td>${m.resName}</td>
												
												<td><button type="button" name="selectproject" id="selectProjectsdata${count.count}" 
																	class="btn btn-1 btn-primary center-block"  onclick="showprojectsdata('${t.projectName}',${t.projectId},${m.reservoirId},'${m.resName}',${m.unitId},4)" >Select Reservoir</button></td>
																	</tr>
																	
												</c:when>
												
												</c:choose>
												</c:forEach>
											
												
												</table>
												
												
												
												 </td>
												</c:when>
												<c:otherwise>
											
												
												<td></td>
																	</c:otherwise>
												</c:choose>
												
												
											
												
												
										
												
												
												
												
										</tr>
										
									
										
									
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
											<option value=" ">--select--</option>
											<option value="1">DSRP(Dam safety review panel)(28/09/2022)</option>
											<option value="2">SDSO (06/07/2022)</option>
											<option value="3">SDSIT / Technical committee(04/04/2022)</option>
											<option value="4">Project Authority(01/02/2022)</option>
											



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
										<textarea class="form-control" id="recemremarks" 	name="remarks" rows="3" cols="50" placeholder="Recommendation"></textarea>
						</div>
				
				</div>	
				
				<div class="col-md-12">
				<button type="button" name="selectrecm" id="selectProjectsdatarecm" 
																	class="btn btn-1 btn-primary center-block"  onclick="AddRecommendationInfo(this.form.id)" >Submit</button>					
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
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata('${t.tankName}','${t.tankId}','${t.tankCode}','${t.newDistrictId}','${t.mandalId}','${t.villageId}','${t.acCode}','${t.habitationId}','${t.mandalName}','${t.villageName}',1),gettankgeotaglist('${t.tankId}')" >Select Tank</button></td>
												
												
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

<div id="getanicut_dialogue">

	<form:form id="gettanks" method="post" modelAttribute="gettanks"
		name="getanksdescform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="viewanicutdata">
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
											<td>Anicut</td>											
											<td>Action</td>
											
											
											
											
											
											 </tr>

											</thead>


											<tbody id="viewanicutdatabody">
											
											<c:forEach items="${anicutList}" var="t" varStatus="count">
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
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata('${t.tankName}','${t.tankId}','${t.tankCode}','${t.newDistrictId}','${t.mandalId}','${t.villageId}','${t.acCode}','${t.habitationId}','${t.mandalName}','${t.villageName}',2),gettankgeotaglist('${t.tankId}')" >Select Anicut</button></td>
												
												
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

<div id="getcheckdam_dialogue">

	<form:form id="gettanks" method="post" modelAttribute="gettanks"
		name="getanksdescform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="viewcheckDamdata">
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
											<td>Check Dam</td>											
											<td>Action</td>
											
											
											
											
											
											 </tr>

											</thead>


											<tbody id="viewcheckDamdatabody">
											
											<c:forEach items="${checkDamList}" var="t" varStatus="count">
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
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata('${t.tankName}','${t.tankId}','${t.tankCode}','${t.newDistrictId}','${t.mandalId}','${t.villageId}','${t.acCode}','${t.habitationId}','${t.mandalName}','${t.villageName}',3),gettankgeotaglist('${t.tankId}')" >Select Check Dam</button></td>
												
												
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
	


