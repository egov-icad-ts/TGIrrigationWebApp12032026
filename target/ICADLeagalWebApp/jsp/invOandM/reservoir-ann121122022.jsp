

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

<script type="text/javascript" src="../js/moment.min.js"></script>

<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" media="screen" href="../css/bootstrap-datetimepicker.min.css">


<script type="text/javascript" src="../js/customnew.js"></script>

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
				<strong style="color:#CA3F22"> Note: Select Large Tank/ Projects  to proceed further. </strong>
				<br>
				

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
				

			</div>
			</div>
						<div class="col-md-12">
							<div >	
							<div class="col-md-3">
							
							
							
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
																	class="btn btn-1 btn-primary center-block "  onclick="TankDamInfo(tankId.value),TankImpContLvlInfo(tankId.value)"  >View/Edit Tank Info</button>

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


										<button type="button" name="shaddresinf" id="shaddresbaiscinf" 
																	class="btn btn-1 btn-primary center-block " onclick="resDamInfo(resId.value),resDamImpContLvlInfo(resId.value)"  >Add/View Reservoir Info</button>

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
			
			<div class="col-md-12">
			
			<div class="col-md-6">
					<label class="label-controlPMS rowlebel ">Year <font
							color=red>*</font>
						</label>
						
						<input class="form-control" id="year"  type="text" name="year"  value="0"  readonly="readonly"   required />
					</div>
						
							
							
									

									<div class="col-md-6">
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
								
						<br><br>		
					</div>
								
											
						<!-- 	onchange="getann1inspectdata(year.value)"	 -->
					 <div  id="freqid" class="col-md-12">	
					 
					 <br><br>		
                  
					<div class="col-md-6">
					<label class="label-controlPMS rowlebel ">Select Frequency: <font
							color=red>*</font>
						</label>
						<select class="form-control" id="dutyFrequencyId" name="dutyFrequencyId"  onchange="getresmst2mst1byfreqyear(),getResInspectioninfo(),getResDamHealthDetails(),getActionStatusDetails( ),getDamInspectioninfo(),getDamRemarksinfo(),getDamInspectPhotosinfo()"
							 required >
							<option value=" ">--select--</option>
							<option value="9">PRE MONSOON (April,May)</option>
							<option value="10">POST MONSOON (November,December)</option>
						<!-- 	<option value="11">DURING MONSOON(JUNE TO AUGUEST)</option> -->
						

						</select>
					</div>
					
					
					 
					
						<div class="col-md-4">
						
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
						
						<div class="col-md-2">
																
																<button type="button" name="editdamStatus1" id="editDamStatus12" 
																	class="btn btn-1 btn-primary center-block  " onclick="editdamstatus(conditionofDamId.value)">Edit Status</button>
															</div>
							
</div>

         </div>				
					
						</div>
						
						
								

				
</form:form>

		



			 <div  class="col-md-12">
			
				
				 	<div id="resprepost">
				 	
				 	<ul>
				 	
				 	
				 	
				 	<li><a href="#inspect" >Add Inspection Details </a></li>
					<li><a href="#1ann" > Annexure I</a></li>
					<li><a href="#2ann" > Annexure II</a></li>	
					
					<li><a href="#addDamRmks" >Add Remarks</a></li>
					
					<li><a href="#addinspectpht" >Add Inspection Photographs</a></li>				
					
					<li><a href="#health" >Health Status(Reservoir)</a></li>
			
					<li><a href="#ats" >Action Taken Status</a></li>
					
					

				</ul>
				
				<div id="inspect">
					
					
					<form:form id="addinspect" method="post" modelAttribute="addinspectdata"
		name="addinspectform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
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

										<label class="label-control rowlebel " for="parameter1">
											Select Inspecting officers<font
											color=red>*</font></label> 
											
											<select class="form-control" id="inspectOfficeId"
											name="inspectOfficeId" required>
											<option value=" ">--select--</option>
											<option value="1">DSRP(Dam safety review panel)</option>
											<option value="2">SDSO</option>
											<option value="3">SDSIT / Technical committee</option>
											<option value="4">Project Authority</option>
											
									</select>
											</div>
										<div class="col-md-6">	
																
								
																<label class="label-control rowlebel ">Inspect Date: <font color=red>*</font>
																</label> <input type="text"
																	class=" datepick form-control datepicker "
																	id="inspectinspectDate"
																	name="inspectDate"
																	placeholder="inspectDate" value="0" readonly="readonly" required/>
															
										</div>
										
										<br>
								
										
										</div>
											
										
									
									
							
				
		<div class="col-md-12 ">
		<br>
		<div class="col-md-6">
							
							
							
								
											
								<label class="label-control rowlebel "> Name and designation of the Inspecting officers
										<font color=red>*</font>
									</label>
									<textarea class="form-control" id="inspectOfficerData" 	name="inspectOfficerData" rows="3" cols="50" placeholder="Name1(Designation1),Name2(Designation2)" required></textarea>
									
									
									
								</div>	
								
						
						
						
								<div class="col-md-6">
							
							
							
								
											
								<label class="label-control rowlebel "> Name and designation of the field officers present
										<font color=red>*</font>
									</label>
									
									
									
								
										<textarea class="form-control" id="fieldOfficerData" 	name="fieldOfficerData" rows="3" cols="50" placeholder="Name1(Designation1),Name2(Designation2)" required></textarea>
						</div>
							
							
					<br>
							
						
						
							</div>
							
								<div class="col-md-12">
									<br>
									
							<div  class="col-md-6 ">
																<label class="label-control rowlebel ">Type of Inspection <font color=red>*</font>
																</label> <input type="text"
																	class="  form-control  "
																	id="typeofinspection"
																	name="typeofinspection"
																	placeholder="typeofinspection"  required/>
															</div>
							
															
															
																<div class="col-md-6 ">
																<label class="label-control rowlebel ">Reservoir water level <font color=red>*</font>
																</label> <input type="text"
																	class="  form-control  "
																	id="presentWaterlevel"
																	name="presentWaterlevel"
																	placeholder="presentWaterlevel" value="0" required />
															</div>
															
															<br>
															</div>
															
							<div class="col-md-12">
							<br>
											
																<div class="col-md-6 ">
																<label class="label-control rowlebel ">Storage Capacity (MCM) (Live) <font color=red>*</font>
																</label> <input type="text"
																	class="  form-control  "
																	id="storageCapacity"
																	name="storageCapacity"
																	placeholder="storageCapacity" value="0" required />
															</div>
															
																	<div class="col-md-6 ">
																<label class="label-control rowlebel ">Weather Conditions <font color=red>*</font>
																</label> <input type="text"
																	class="  form-control  "
																	id="weathercondition"
																	name="weathercondition"
																	placeholder="weathercondition" value=" "  required/>
															</div>
															<br>
															
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
								
								<button type="button" name="snumgen" id="annobs${m.resCheckId}" class="btn btn-1 btn-primary center-block annbuttoninf"  onclick="getresgenchecklist('${m.resCheckId}',this.id)">${m.checkdisplayNum}</button> &emsp;&emsp;&emsp;&emsp;  
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
								data-parsley-validate-if-empty="">					
							
									
									<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${m.resCheckId}" type="hidden" />
											
												<input  value="0" 
											id="ann2mst1Id${m.resCheckId}" type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${m.resCheckId}" type="hidden" />
														
											
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
											class=" form-control " id="installedcount${m.resCheckId}" type="text"  
										
											   />
											   
											   
			          </div>
			          
			          <div class="col-md-6">
						
						<label class="label-control rowlebel " for="parameter1">
											Location</label> 		
											
						<input
											name="location" value="0"
											class=" form-control " id="location${m.resCheckId}" type="text"  
										
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
											class=" form-control " id="irrChFrm${m.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
			          </div>
			         	<div class="col-md-6"> 
			         	
			         	 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											</label>
			         <input
											name="irrChTo" value="0.00"
											class=" form-control " id="irrChTo${m.resCheckId}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
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
											class=" form-control datepick" id="installmonth${m.resCheckId}" type="text"  
										
											   />
			          </div>	
			          
			          <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Whether in working condition ( Yes / No) &emsp;&emsp;</label> 
											
					 <label class="radio-inline"> <input class="rd1" type="radio" name="workingcondition" id="workingconditionn${m.resCheckId}"  checked="checked"    value="false"  required >N</label>
        <label class="radio-inline"> <input class="rd1" type="radio" name="workingcondition" id="workingconditiony${m.resCheckId}"     value="true"  required >Y</label>		
											
						
			          </div>
			          
			          </div>
			         	<div class="col-md-12"> 
			         	 <br>
			          <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Date last Calibration </label> 		
											
						<input
											name="datelastCalibrated" value="0" readonly="readonly"
											class=" form-control datepick" id="datelastCalibrated${m.resCheckId}" type="text"  
										
											   />
			          </div>	
			          
			           <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Date for next Calibration </label> 		
											
						<input
											name="datenextCalibrated" value="0" readonly="readonly"
											class=" form-control datepick" id="datenextCalibrated${m.resCheckId}" type="text"  
										
											   />
			          </div>	
			          
			          </div>
			          
			          	<div class="col-md-12">
			          	 <br>
			          
			          <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Observations maintained ( Yes / No) &emsp;&emsp;</label> 
											
					 <label class="radio-inline"> <input class="rd1" type="radio" name="obsmaintained" id="obsmaintainedn${m.resCheckId}"  checked="checked"    value="false"  required >N</label>
        <label class="radio-inline"> <input class="rd1" type="radio" name="obsmaintained" id="obsmaintainedy${m.resCheckId}"     value="true"  required >Y</label>		
											
						
			          </div>
			          
			           <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Agency responsible for data collection and processing ( Yes / No) &emsp;&emsp;</label> 
											
					 <label class="radio-inline"> <input class="rd1" type="radio" name="agencyresponsible" id="agencyresponsiblen${m.resCheckId}"  checked="checked"    value="false"  required >N</label>
        <label class="radio-inline"> <input class="rd1" type="radio" name="agencyresponsible" id="agencyresponsibley${m.resCheckId}"     value="true"  required >Y</label>		
											
						
			          </div>
			          
			          </div>
			          	<div class="col-md-12">
			          	 <br>
			            <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Analysis of data done at field level ( Yes / No) &emsp;&emsp;</label> 
											
					 <label class="radio-inline"> <input class="rd1" type="radio" name="analysisofdata" id="analysisofdatan${m.resCheckId}"  checked="checked"    value="false"  required >N</label>
        <label class="radio-inline"> <input class="rd1" type="radio" name="analysisofdata" id="analysisofdatay${m.resCheckId}"     value="true"  required >Y</label>		
											
						
			          </div>
			           <div class="col-md-6">
						
						
						<label class="label-control rowlebel " for="parameter1">
											Data sent to DSO regularly ( Yes / No) &emsp;&emsp;</label> 
											
					 <label class="radio-inline"> <input class="rd1" type="radio" name="datasenttoDSO" id="datasenttoDSOn${m.resCheckId}"  checked="checked"    value="false"  required >N</label>
        <label class="radio-inline"> <input class="rd1" type="radio" name="datasenttoDSO" id="datasenttoDSOy${m.resCheckId}"     value="true"  required >Y</label>		
											
						
			          </div>
			          
			          </div>	
			          
			           <div class="col-md-12"  > 						
						<div class="col-md-12">
						
						 <br>
						 
						 <label class="label-control rowlebel " for="parameter1">
											Observations</label> 

		<textarea class="form-control" id="remarks${m.resCheckId}"	name="remarks"
				   rows="3" cols="50" placeholder="Observations" required></textarea>
						
						</div>
						
						</div>
											
										 
						 <div class="col-md-12"  > 
						  <br>
						 
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
											id="gen-frm-table${m.resCheckId}">
											<thead id="gen-thead${m.resCheckId}">
											<tr>
											<th>S.NO</th>
											<th>Edit Observations</th>
											<th>Delete Observations</th>
											
										<!-- 	<th>Add / Edit / Delete / View Recommendations</th> -->
											
											</tr>

											</thead>


											<tbody id="gen-tbody${mcount.count}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${m.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit Observations</button>
								
									</td>
									<td><button type="button" name="ann1edit1" 	id="resdeleteobs${m.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs  " onclick="deleteAnnmst2(${m.resInspectMst2Id},${m.resCheckId})">Delete Observations</button></td>
									
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
								data-parsley-validate-if-empty="">
					
                         <!--    start of ann2ear form hidden values -->
								<input name="projectId" value="0" class="mainprojId"
											id="resprojectId${n.resCheckId}" type="hidden" />
											
											<input  value="0" 
											id="ann2mst1Id${n.resCheckId}"   type="hidden" />
											<input  value="0" 
											id="ann2mst2Id${n.resCheckId}" type="hidden" />
									
								 
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
													for="parameter1"><c:if test="${!(n.checkdisplayNum=='0')}">  ${n.checkdisplayNum} </c:if> &emsp;&emsp; ${n.resCheck}</label>
													
													
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
      
        <label class="radio-inline"> <input class="rd1" type="radio" name="damcheckResponseId" id="damcheckResponseIdn${n.resCheckId}"  checked="checked"    value="1"  required >N</label>
        <label class="radio-inline"> <input class="rd1" type="radio" name="damcheckResponseId" id="damcheckResponseyIdy${n.resCheckId}"     value="2"  required >Y</label>
         <label class="radio-inline"> <input class="rd1" type="radio" name="damcheckResponseId" id="damcheckResponsenaIdna${n.resCheckId}"     value="3"  required >NA</label>
     
   
        </div>
						
						
					<div class="col-md-12">	 
					 <br>
					 
<label class="label-control rowlebel ">Observations <font color=red>*</font> </label>
				<textarea class="form-control" id="remarks${n.resCheckId}"
													name="remarks"
						
													rows="3" cols="50" placeholder="Observations"></textarea>
													
													<br>
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
						
						<br>
						
						<label class="label-controlPMS rowlebel ">Condition
								 <font color=red>*</font>
							</label>
							<select class="form-control" id="conditionofCheckId${n.resCheckId}" name="conditionofCheckId"
								required onchange="">
								<option value=" ">--select--</option>
								<option value="1">1-Unsatisfactory</option>
								<option value="2">2-Poor</option>
								<option value="3">3-Fair</option>
								<option value="4">4-Satisfactory</option>
								


							</select>
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
											id="gen-frm-table${n.resCheckId}">
											<thead id="gen-thead${n.resCheckId}">
											<tr>
											<th>S.NO</th>
											<th>Edit Observations</th>
											
										
											<th>Delete Observations</th>
											
											<th>Add / View/Edit/Delete Edit Recommendations</th>
											
											</tr>

											</thead>


											<tbody id="gen-tbody${n.resCheckId}">
									<tr>
									<td>Sno</td>
									<td><button type="button" name="ann1edit1" 	id="reseditobs${n.resCheckId}"  class="btn btn-1 btn-primary center-block editannobs">Edit Observations</button>
									
									</td>
									<td><button type="button" name="ann1edit1" 	id="resdeleteobs${n.resCheckId}"  class="btn btn-1 btn-danger center-block delannobs">Delete Observations</button></td>
									
									
									<td><button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block " onclick="addrecmmn(${n.resCheckId},2)">Add  Recommendations</button>
									<br>
									<button type="button" name="ann1edit4" 	id="resviewrecm${n.resCheckId}"  class="btn btn-1 btn-primary center-block " onclick="addrecmmn(${n.resCheckId})">Edit / Delete/ View Recommendations</button>
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
					
					
				
					
		<div id="addDamRmks">
					
				
			
   
	<form:form id="reviewformremann1" method="post" modelAttribute="rescheckObject"
		name="reviewformremann1name" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
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
	

  

		<div class="col-md-12">
		
				<label class="label-control rowlebel "></label>
				<input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block reviewbutton" id="reviewinfoid" 
					value="Add Remarks" onclick="AddRemarksInfo(this.form.id)">
					
					<br><br>
			
		</div>
		
		
		
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



<form:form id="adddocrec" name="adddocrecinf"
								modelAttribute="resinspectdatainfo" method="post" class="resinsectform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
								
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
							 <div class="col-md-2"></div>
					
										 
										  <div class="col-md-8"  >
										  <label class="label-controlPMS rowlebel ">Upload Photos(Multiple)</label>
								<input id="resinspectPhotosnew" name="uploadPhotos" type="file" 	class="btn-info" value="Upload Documents"  multiple="multiple"  required  data-parsley-max-file-size="2048"  data-parsley-fileextension='jpeg,jpg,png'  > 
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
							
							 <div class="col-md-12"  >
							 	<br><br>
								<button type="button" name="addmichecks11" id="addmichecks11" onclick="addphotosdatafn(this.form.id)"
									class="btn btn-1 btn-primary center-block ">Submit</button>
									</div>
							
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
					
					
					<div id="health">
				
				<form:form id="reshealthform5" name="reshealthform5name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						
								<input name="projectId" value="0" class="mainprojId"
											id="reshealthann2" type="hidden" />
											
											
								<input  value="0" 
											id="healthmst1Id" type="hidden" name="resInspectMst1Id" />
											<input  value="0" 
											id="healthmst2Id" type="hidden" name="resInspectMst2Id"  />
									
								 
								<input name="reservoirId" value="0"  class="mainresId"
									id="reshealthann2" type="hidden" />
							
							<input name="tankId" value="0"  class="maintankId"
									id="healthtankId" type="hidden" />
						
								<input name="year" value="0" id="yearhealth" class="mainyear"
									type="hidden" />
									
									 <input name="tabId" value="41" id="tabIdhealth" type="hidden" /> 
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
						
				<textarea class="form-control" id="reshealth6remarks" 	name="remarks" rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
				  <div class="col-md-2"></div>	
					 <br>
						 
					  
						</div>   	
					
						 <div class="col-md-12">
						 <br>
						
						 <button type="button" name="rescheckbutton5" id="rescheckbutton5" class="btn btn-1 btn-primary center-block "  onclick="addresdamhealth(this.form.id)" >Submit</button>
						 
						
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
				
					<div id="ats">
				
				<form:form id="resatsform" name="resatsformname"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
					
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
									
									 <input name="tabId" value="51" id="tabIdats" type="hidden" /> 
									   <input name="annexureId" value="0" id="annexureats" class="mainannId"
									type="hidden" />


   <input name="dutyFrequencyId" value="0" id="dutyFrequencyIdats" type="hidden"  	class="maindutyFrequencyId"/>
   <input name="conditionofDamId" value="0" id="conditionofDamIdsta" type="hidden"  	class="mainconditionofDamId"/>
    
    
    
    
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
        <label class="radio-inline"> <input type="radio" class="myradio" name="actionTakeninit" id="atsactionTakeninitn"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="actionTakeninit" id="atsactionTakeninity"     value="true"   >Yes</label>
       
          
    </div>
    

						
						  <div class="col-md-6">	
						  <label class="label-controlPMS rowlebel ">Whether action completed  :<font
							color=red>*</font>
						</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="actionTakencomplete" id="atsactionTakencompleten"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="actionTakencomplete" id="atsactionTakencompletey"     value="true"   >Yes</label>
       
          
    </div>
    <br>
    </div>
      <div class="col-md-12">
				  <br>
						<div class="col-md-6">	 
						<label class="label-controlPMS rowlebel ">Remarks/Reasons for pending  : <font color=red>*</font>
							</label>
				<textarea class="form-control" id="atsremarks" 	name="remarks" rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					<br>
					</div>
						    	   
					<div class="col-md-12">	 
						 <br />
						  <br />
						 <button type="button" name="rescheckbutton7" id="rescheckbutton7" class="btn btn-1 btn-primary center-block " onclick="addactionStatusInfo(this.form.id)" >Submit</button>
						 </div>
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
											id="viewresdatainf">
											<thead id="viewprojectsdatahead" >
											<tr style="font-weight: bold;"> 
											<th>S.No.</th>
											<th>Project</th>
											
											<th>Reservoirs</th>
									
											 </tr>

											</thead>


											<tbody id="viewprojectsdatabosy">
											
											<c:forEach items="${projectList}" var="t" varStatus="count">
										
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
																	class="btn btn-1 btn-primary center-block"  onclick="showprojectsdata('${t.projectName}',${t.projectId},${m.reservoirId},'${m.resName}',${m.unitId},4,'${m.nrldCode}')" >Select Reservoir</button></td>
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
		
		<input id="rec2resDamHealthId"   value="0"   name="resDamHealthId" class=" form-control "  type="hidden" />
		
		<input id="selectedhealthinspectOfficeId"   value="0"  class=" form-control "  type="hidden" />
		
		
		
		
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


<div id="addhealthremarks_dialogue">
					
					<form:form id="addrecpmmendhealth" method="post" modelAttribute="addrecpmmendhealthdata"
		name="addrecommendform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		<input id="healthresInspectMst1Id" value="0"  name="resInspectMst1Id"  class=" form-control "  type="hidden" />
		
		<input id="healthresInspectMst2Id"   value="0"   name="resInspectMst2Id" class=" form-control "  type="hidden" />
		
		<input id="healthresDamHealthId"   value="0"   name="resDamHealthId" class=" form-control "  type="hidden" />
		<input id="healthOfficeInfoId"   value="0"   name="inspectOfficeInfoId" class=" form-control "  type="hidden" />
		

		
		
		
		
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


<div id="res_basic_info">



<div id="recbasicupdate">

<ul>
				 	<li><a href="#daminfo" >Dam info </a></li>
					<li><a href="#conlevel" > Controlling Level</a></li>
					
					
				</ul>
				
				<div id="daminfo">

<form:form id="adddambasicinf" name="adddambasicinfdata"
								modelAttribute="resinspectdatainfo" method="post" class="resinsectform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

<!--  start of hidden values  -->
 
 <input  value="false" 	class=" form-control " id="daminfeditFlag" type="hidden" />
 
<input name="reservoirId" value="0" readonly="readonly" 
											class=" form-control " id="dminfreservoirIddata" type="hidden" /> 
 
 <input name="tankId" value="0" readonly="readonly" 
											class=" form-control " id="dminftankdata" type="hidden" /> 
 
<!--  end of hidden values  -->




 	 <div class="col-md-12 invDiv fphtedit">
					   
								<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Dam Type:
										
									</label>
									
									<input id="typeOfDam" value="" name="typeOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" />
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Dam Owner:
										
									</label>
									
									<input id="ownerOfDam" value="" name="ownerOfDam"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly" />
											</div>
									</div>	
									
									
									
									
									<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Dam Operator:
										
									</label>
									
									<input id="damOperator" value="" name="damOperator"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" />
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Commissioning Date:
										
									</label>
									
									<input id="commisionDate" value="" name="commisionDate"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" />
											</div>
									</div>	
									
									
									
									<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Hazard Classification:
										
									</label>
									
									<input id="hazardClass" value="" name="hazardClass"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" />
											</div>
											
											
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
								<button type="button" name="addmichecks11" id="daminfupdate" onclick="editinfo(dminftankdata.value,dminfreservoirIddata.value,this.form.id, 1,daminfeditFlag.value)"
									class="btn btn-1 btn-primary center-block frmphotobutton">Edit</button>
									</div>
							
							</div> 
	</form:form>	
	
	<div class="col-md-12"></div>
	</div>
	
	<div id="conlevel">

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


 	 <div class="col-md-12 invDiv fphtedit">
					   
								<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">TBL RL:
										
									</label>
									
									<input id="trlLevel" value="" name="trlLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly" />
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">MWL RL:
										
									</label>
									
									<input id="mwlLevel" value="" name="mwlLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" />
											</div>
									</div>	
									
									
									<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel">FRL RL:
										
									</label>
									
						<input id="frlLevel" value="" name="frlLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly" />
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Spillway Crest RL:
										
									</label>
									
									<input id="spillWayCrestLevel" value="" name="spillWayCrestLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" />
											</div>
									</div>	
									
									<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">MDDL RL:
										
									</label>
									
									<input id="mddlLevel" value="" name="mddlLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" />
											</div>
											
											<div class="col-md-6">
											
								<label class="label-control rowlebel ">Lowest River bed RL:
										
									</label>
									
									<input id="lowestRiverBed" value="" name="lowestRiverBed"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  readonly="readonly" />
											</div>
									</div>	
									
									
									
									<div class="col-md-12">
							
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Deepest foundation level RL:
										
									</label>
									
									<input id="deepestfoundationLevel" value="" name="deepestfoundationLevel"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly" />
											</div>
											
								<div class="col-md-6">
											
								<label class="label-control rowlebel ">Gross Storage at FRL:
										
									</label>
									
									<input id="grossStorageatFrl" value="0" name="grossStorageatFrl"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" readonly="readonly" />
											</div>
											
											
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
								<button type="button" name="addmichecks11" id="damcontrolinf" onclick="editinfo(dmctrltankdata.value,dmctrlreservoirIddata.value,this.form.id, 2,damctrleditFlag.value)"
									class="btn btn-1 btn-primary center-block frmphotobutton">Edit</button>
									</div>
							
							</div> 
	</form:form>	
	
	
	<div class="col-md-12"></div>
	</div>						
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




<!--  dilogue ends -->



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
	




















<!-- </div> -->
<!-- //main-content -->

