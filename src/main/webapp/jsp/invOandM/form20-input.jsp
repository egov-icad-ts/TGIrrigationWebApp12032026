

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
<script type="text/javascript" src="../js/jquery-ui-timepicker-addon.min.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>

<script type="text/javascript" src="../js/moment.min.js"></script>

<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" media="screen" href="../css/bootstrap-datetimepicker.min.css">



<script type="text/javascript" src="../js/customnew.js"></script>

<script type="text/javascript" src="../js/invom/form20.js"></script>
<link rel="stylesheet" media="screen" href="../css/invom/michecks.css">

 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />






<!-- <div class="w3l-main" id="borderStyle"> -->


<div class="col-md-9">



	<div>



		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">TMS of Irrigation Tank / Projects (Major/medium):Form 20 Data Entry. 
				
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
			 
	</div></c:if> &emsp;&emsp;</h3>
			</div>


			<div class="panel-body">
				
				<div class="alert alert-info col-md-12" style="padding: 0px"
					id="action_alert">
					<c:if test="${msg!=null }">
						<c:out value="${msg}"></c:out>
					</c:if>
				</div>


				<div id="result" class="col-md-12 ">
				
				

					<form:form id="mainformid" name="mainformname"
						modelAttribute="micheckList" method="post"
						data-parsley-validate-if-empty="">
						
						<input value="${userObj.unitId}" id="userunit" type="hidden" />
						<input value="${userObj.circleId}" id="usercircle" type="hidden" />
						<input value="${userObj.divisionId}" id="userdivision" type="hidden" />
						<input value="${userObj.subdivisionId}" id="usersubdivision" type="hidden" />
						<input value="${userObj.post}" id="userpost" type="hidden" />

					
						&emsp; &emsp;
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
									
									<button type="button" name="showprojectname" id="showprojectsdata" 
																	class="btn btn-1 btn-primary center-block "  >Select Projects and Reservoirs</button>
								</div>
								
								<br>
								
								</div>
								
								<div class="col-md-12">
								<br>
								
								<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Select Project for Canals to proceed further</strong>
				<br>
				

			</div>
			</div>
						<div class="col-md-12">
									<label class="label-control rowlebel ">
										
									</label>
									
									<button type="button" name="showprojects" id="showprojectscaninfo" 
																	class="btn btn-1 btn-primary center-block "  >Select Projects</button>
								</div>
								
								
								
								</div>
								</div>
						
						<div class="col-md-12 invDiv" id="mkinfo">
						
						
						
											<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: This information is from mission kakatiya. </strong>
				<br>
				

			</div>
			</div>
						<div class="col-md-12">
							<div >	
							<div class="col-md-4">
							
							
							
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
										<div  class="col-md-4">	
										<label class="label-control rowlebel ">Mandal:
										
									</label>	
										<input id="mandata" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									
								</div>
								</div>
								
							
								<div >	
									<div   class="col-md-4">	
									<label class="label-control rowlebel ">Village:
										
									</label>		
									<input id="villdata" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
								
								</div>
								
								</div>
								</div>
								
								<br>
								<br>
								<div class="col-md-12">
											<div  id="gross">
									
									<div class="col-md-4">
                                      <label class="label-control rowlebel " for="parameter1">Gross
											Capacity (TMC)</label>

										<input name="miTankInspectList[0].grossCapacity" value="" readonly="readonly"
											class=" form-control " id="grossCapacity" type="text" />

									</div>
								</div>
								<div id="geo">
									
									<div class="col-md-4">
									<label class="label-control rowlebel " for="parameter1">Geo
											Tag Id</label>


										<input name="miTankInspectList[0].geoTagId" value="" readonly="readonly"
											class=" form-control " id="geoTagId" type="text"    />

									</div>
								</div>
								
								<div  id="gmainayacut">
									
									<div class="col-md-4">
									<label class="label-control rowlebel " for="parameter1">Ayacut 
										 (Acres)</label>


										<input name="miTankInspectList[0].grossAyacut" value="" readonly="readonly"
											class=" form-control " id="gayacut" type="text"    />

									</div>
								</div>
								</div>
								
								</div>
								
								<!-- start of res display -->
								
								<div class="col-md-12 invDiv" id="pmsresinfo">
								
									<div class="col-md-12">
						
																	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: (Reservoir name is from PMS.If Reservoir location is not displayed , please add location of Reservoir to submit form 20.) </strong>
				<br>
				

			</div>
			</div>
						
								
								<div class="col-md-4">
							
							
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
									
									<div  class="col-md-4">	
										<label class="label-control rowlebel ">Reservoir:
										
									</label>	
										<input id="reservoirName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									
								</div>
								
								
								<div  class="col-md-4">	
								
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
								
									<div class="col-md-4">
							
							
							
							
								<label class="label-control rowlebel ">District Name:
										<font color=red>*</font>
									</label>
									
									<input id="resmaindistrictName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									
									
									<div class="col-md-4">
							
							
							
							
								<label class="label-control rowlebel ">Mandal Name:
										<font color=red>*</font>
									</label>
									
									<input id="resmainmandalName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									
									
									<div class="col-md-4">
							
							
							
							
								<label class="label-control rowlebel ">Village Name:
										<font color=red>*</font>
									</label>
									
									<input id="resmainvillageName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
								
								</div>
								</div>
								
								
								<div class="col-md-12 invDiv" id="pmscaninfo">
								
									
								
									<div class="col-md-12">
									
									
						
																
						
								
								<div class="col-md-4">
							
							
							
								<input name="projectId" value="0" readonly="readonly" 
											class=" form-control " id="canmainprojectId" type="hidden" />
											
								<input  value="0" 
											class=" form-control " id="canMainDistrictId" type="hidden" />
											
								<label class="label-control rowlebel ">Project:
										<font color=red>*</font>
									</label>
									
									<input id="projectNamecan" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									
									
									<div class="col-md-4">
							
							
							
							
								<label class="label-control rowlebel ">Canal Name:
										<font color=red>*</font>
									</label>
									
									<input id="canalNamecan" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									
									
									
						
						<div  class="col-md-4">	
						
						<label class="label-control rowlebel ">
										
									</label>
						
						<button type="button" name="shaddcanals" id="shaddcanalsinf" 
																	class="btn btn-1 btn-primary center-block "  >Add Canal Location</button>
																	<br>
						<!-- <button type="button" name="sheditcanals" id="sheditcanalsinfo" 
																	class="btn btn-1 btn-primary center-block "  >Edit Canal Location</button> -->
						</div>											
					
						
									
										
										<!-- <input id="reservoirName" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" /> -->
								
								
									
						<br>
								
								</div>
								
								<div class="col-md-12">
								
								<br>
								
									<div class="col-md-4">
							
							
							
							
								<label class="label-control rowlebel ">District Name:
										<font color=red>*</font>
									</label>
									
									<input id="districtNamecan" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									
									
									<div class="col-md-4">
							
							
							
							
								<label class="label-control rowlebel ">Mandal Name:
										<font color=red>*</font>
									</label>
									
									<input id="mandalNamecan" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
									
									
									<div class="col-md-4">
							
							
							
							
								<label class="label-control rowlebel ">Village Name:
										<font color=red>*</font>
									</label>
									
									<input id="villageNamecan" value="" readonly="readonly"  style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
									</div>
								
								</div>
								</div>
								
								
								<!-- end of res display -->
								
								
								
	<div class="col-md-12 invDiv">							
	
							<div class="col-md-12">
							
				
							
								<div  id="emp">
									

									<div class="col-md-6">
									
									<label class="label-control rowlebel ">Next level review: <font color=red>*</font>
										</label>
										<input name=nextPostId value="" 	id="nextPostId" type="hidden" />
										 <select class="form-control" id="nextEmpId" name="nextEmpId" required onchange="getempId(this.value)">
										
											<option value=" ">--select--</option>

											<c:forEach items="${getempapprove}" var="u">
												<option value="${u.empId}">${u.empName}</option>
                                   <c:if test="${getempapprove.size()==1}"><script>    $('select>option:eq(1)').prop('selected', true);  $("#nextPostId").val("${u.postId}");$("#nextEmpId").val("${u.empId}");  getempId("${u.empId}"); </script></c:if>
											</c:forEach>


										</select> 
										
										<%-- <select class="form-control" id="nextPostId"
											name="nextPostId"   required>
											<option value=" ">--select--</option>
										<c:forEach items="${getempapprove}" var="d">							
									<option value="${d.postId}" >${d.empName}</option>
								
								</c:forEach>


										</select>
										 --%>
									</div>
								</div>
								
									<div  id="yearid">
									
									<div class="col-md-6">
									<label class="label-control rowlebel ">Year:
											<font color=red>*</font>
										</label>
										
										<!--  onchange="getmst2inspectdata(this.value)" <input class="form-control" id="year"  type="text" name="year"  value=""  readonly="readonly"   required /> -->
									<select class="form-control" id="year" name="year"
											 required>
											<option value=" ">--select--</option>
										


										</select> 
									</div>
								</div>
								
								


								
								</div>
								&emsp;&emsp;
                            
						
					
						</div>
						

					</form:form>
					
				

															
				</div>



&emsp;&emsp;

				<div id="result1" class="col-md-12 ">


				<!-- 	<div id="tabs"> -->
					<!-- 	<ul>
									<li><a href="#frm20" onclick="getcheckfalse6()">FORM20
									</a></li>
						
						</ul> -->
						<!-- tabs -->





						
						
						


						

						

						


					
						
						
						<div id="frm20">

							<form:form id="michecks8" name="michecks8"
								modelAttribute="miTankformDataList" method="post" class="mitankform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

								
								<input name="miTankformDataList[0].tankId" value="0"
									id="mitankId8" type="hidden" />
									
									<input name="miTankformDataList[0].projectId" value="0"
									id="projectId8" type="hidden" />
							
						
									<input name="miTankformDataList[0].resId" value="0" id="resId8" type="hidden" />
									<input name="miTankformDataList[0].canId" value="0" id="canalId8" type="hidden" />
									<input name="miTankformDataList[0].catId" value="0" id="catId8" type="hidden" />
									
									<input name="miTankformDataList[0].canalLocId" value="0" id="canalLocId8" type="hidden" />
									
									<input name="miTankformDataList[0].nextEmpId" value="0" id="nextEmpId8" type="hidden" />
									<input name="miTankformDataList[0].nextPostId" value="0" id="nextPostId8" type="hidden" />
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="miTankformDataList[0].postId" value="${userObj.post}" id="postId8"
									type="hidden" />
									</c:if>
									
								
									
									<c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" id="userempId8" type="hidden" />
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId!=null}">

									<c:if test="${userObj.unitId>0}">
										<input name="miTankformDataList[0].unitId"
											value="${userObj.unitId}" id="miunitId8" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.unitId==null || userObj.unitId==0)}">
									
										<input name="miTankformDataList[0].unitId" value="0"
											id="miunitId8" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.circleId!=null}">
									<c:if test="${userObj.circleId>0}">
										<input name="miTankformDataList[0].circleId"
											value="${userObj.circleId}" id="micircleId8" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.circleId==null || userObj.circleId==0)}">
									
										<input name="miTankformDataList[0].circleId" value="0"
											id="micircleId8" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.divisionId!=null}">
									<c:if test="${userObj.divisionId>0}">
										<input name="miTankformDataList[0].divisionId"
											value="${userObj.divisionId}" id="midivisionId8"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.divisionId==null || userObj.divisionId==0)}">
									
										<input name="miTankformDataList[0].divisionId" value="0"
											id="midivisionId8" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.subdivisionId!=null}">
									<c:if test="${userObj.subdivisionId>0}">
										<input name="miTankformDataList[0].subDivisionId"
											value="${userObj.subdivisionId}" id="misubdivisionId8"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.subdivisionId==null || userObj.subdivisionId==0)}">
									
										<input name="miTankformDataList[0].subDivisionId" value="0"
											id="misubdivisionId8" type="hidden" />
									
								</c:if>
								
								<c:if test="${userObj!=null && userObj.sectionId!=null }">
									<c:if test="${userObj.sectionId>0}">
										<input name="miTankformDataList[0].sectionId"
											value="${userObj.sectionId}" id="misectionId8"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.sectionId==null || userObj.sectionId==0 )}">
									<c:if test="${userObj.sectionId==0}">
										<input name="miTankformDataList[0].sectionId" value="0"
											id="misectionId8" type="hidden" />
									</c:if>
								</c:if>
								
								
						
					
					


								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if test="${userObj.designationId>0}">
										<input name="miTankformDataList[0].designationId"
											value="${userObj.designationId}" id="designationId6"
											type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0)}">

								
										<input name="miTankformDataList[0].designationId" value="0"
											id="designationId8" type="hidden" />
									
								</c:if>
								<input name="miTankformDataList[0].tabId" value="1"
									id="tabId8" type="hidden" />
								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
										<input name="miTankformDataList[0].levelId" value="0"
											id="levelId8" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==4 ) }">
										<input name="miTankformDataList[0].levelId" value="1"
											id="levelId8" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==5 || userObj.designationId==6 ) }">
										<input name="miTankformDataList[0].levelId" value="2"
											id="levelId8" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==7  ) }">
										<input name="miTankformDataList[0].levelId" value="3"
											id="levelId8" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==9 || userObj.designationId==10 ) }">
										<input name="miTankformDataList[0].levelId" value="4"
											id="levelId8" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0)}">
									<input name="miTankformDataList[0].levelId" value="-1"
										id="levelId8" type="hidden" />
								</c:if>

<c:if test="${userObj!=null && ( userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==0)}">

  <div class="col-md-12 invDiv" >
 
 <div class="col-md-12">
 <div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22;"> Note 1*: Use Check boxes to add temporary and  permanent  measures amount. </strong>
				
				
				

			</div>
			</div>
			</div>
			
			 <div class="col-md-12" >
									<br>
									
									<div class="col-md-6">

										<label class="label-control rowlebel " for="parameter1">
											Damage Type<font
											color=red>*</font></label> 
											</div>
										<div class="col-md-6">	
											<select class="form-control" id="damageType"
											name="miTankformDataList[0].damageType" required>
											<option value=" ">--select--</option>
											<option value="1">Breach</option>
											<option value="2">Damage</option>
											



										</select>
										</div>
											
										
									
									
							
				</div> 
 
 
 <div class="col-md-12" >
 <br>
									
									
									<div class="col-md-6">

										<label class="label-control rowlebel " for="parameter1">
											Date of Damage<font
											color=red>*</font></label> 
											</div>
											<div class="col-md-2"><input
											name="miTankformDataList[0].damageDate" value="0" readonly="readonly"
											class=" datepick form-control datepicker" id="damageDate" type="text" 
										
											 required  />

									</div>
									
								 		<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">
											Time<font
											color=red>*</font></label> 
											</div>
											<div class="col-md-2">
											
											<input
											name="miTankformDataList[0].damageTime" value="0:0"
											class="form-control" id="damageTime" type="text" 
										
											 required  />

									</div> 
									
									<div class="col-md-2">								
									
									</div>
									
									 <div class="col-md-12 show-grid ">
									 <div class="col-md-4"></div>
<div class="alert alert-info col-md-8" role="alert" style="text-align: right;">
				
				<strong style="color:#CA3F22;  "> Note *: Click on time to enter repective damage time. </strong>
				
				

			</div>
			</div>
									
								
									
							
				</div> 

									
									 <div class="col-md-12" >
									<br>
									
									<div class="col-md-6">

										<label class="label-control rowlebel " for="parameter1">
											Cause of Damage<font
											color=red>*</font></label> 
											</div>
											<div class="col-md-6"><textarea
											name="miTankformDataList[0].damageCause" rows="1" cols="2"
											class="form-control " id="damageCause" 
										
											 required  ></textarea>

									</div>
									
									
									
							
				</div> 
				
				
				
				<div class="col-md-12" >
				<br>
									
									
									<div class="col-md-6">

										<label class="label-control rowlebel " for="parameter1">
											Proposed Replace or Reconstruction <font
											color=red>*</font></label> 
											</div>
											<div class="col-md-6">
											
											<input
											name="miTankformDataList[0].frmProposed" value="" 
											class="form-control " id="frmProposed" type="text" 
										
											 required  />
									

									</div>
									
								
									
								
									
							
				</div>
				
				    	 <div class=" col-md-12">
				    	 <br>
											<div class="col-md-6">
											
											<label class="label-control rowlebel " for="parameter1">
											If it is not proposed to replace or reconstruct the damaged portion of the property that the amount to be written off. 
											The capital value of the property?(The amount should be estimated in the absense of the recorded book value)
											
											
											</label> 
											</div>
											<div class="col-md-6">
											<input
											name="miTankformDataList[0].writeOffValue" value="0.00"
											class="form-control " id="writeOffValue" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$"  data-parsley-trigger="blur"  data-parsley-error-message="You must enter  2 digits ex:0.12"
										
											   />
											 </div>
											 </div>
											 
											  <div class=" col-md-12">
											  <br>
											  
											<div class="col-md-6">
											
											<label class="label-control rowlebel " for="parameter1">
											Action being taken to effect write off.
											
										
											
											</label> 
											</div>
											<div class="col-md-6">
											<textarea
											name="miTankformDataList[0].writeOffAction" 
											class=" form-control " id="writeOffAction" rows="1" cols="2" 
										
											   /></textarea>
											 
											 <input name="miTankformDataList[0].formDataId"
											value="0" id="formDataId"
											type="hidden" />
											 </div>
											 </div>
											 
											<!--  <div class=" col-md-12">
											  <br>
											  
											<div class="col-md-6">
											
											<label class="label-control rowlebel " for="parameter1">
											In case of Irrigation Source Name of Structure of Damaged portion(whether left side or right side).
											
										
											
											</label> 
											</div>
											<div class="col-md-6">
											<textarea
											name="miTankformDataList[0].irrStrDmaPort" 
											class=" form-control " id="irrStrDmaPort" rows="1" cols="2" 
										
											   /></textarea>
											 
											
											 </div>
											 </div>
											  -->
											
				 
				
				</div> 
				
				<br>
				 <div class="col-md-12">
				 <div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note *: Please Check on  If due to rainfall to enter Rain Guage Station and Date.</strong>
				
				
				
				

			</div>
			</div>
			</div>
				
				
				
				
				 <div class="col-md-12 invDiv flex-parent-element" id="tanksflitems">

  <div class="flex-child-element col-md-4 ">
   <div class="col-md-12">
  <div class="col-md-2">
																 <input
																	
																	class="frmchk" value=""
																	id="regchkid" type="checkbox" />
															</div>

															<div class="col-md-10 ">

																<label class="label-control rowlebel " for="parameter1">
																	 Registered Ayacut</label> 
																
															</div>
															</div>
															
															  <div class="col-md-12">
															
															<div class="col-md-2">
																 <input
																	
																	class="frmchk" value=""
																	id="rainchkid" type="checkbox" />
															</div>

															<div class="col-md-10 ">

																<label class="label-control rowlebel " for="parameter1">
																	 If due to rain fall</label><font color=red> (Required)*</font> 
																
															</div>
															</div>
															
															 <div class="col-md-12">
															
															<div class="col-md-2">
																 <input
																	
																	class="frmchk" value=""
																	id="bldchkid" type="checkbox" />
															</div>

															<div class="col-md-10 ">

																<label class="label-control rowlebel " for="parameter1">
																	 In case of buldings</label> 
																
															</div>
															</div>
															
															
															<c:if test="${frmsrcList!=null }">
															
																		
															
						<c:forEach  items="${frmsrcList}" var="m" varStatus="count" >
						
		
						
							
															 <div class="col-md-12"  id="srcleft${count.count}">
															
															<div class="col-md-2">
																 <input
																   	name="miTankformDataList[${count.count}].frmchkboxId"
																	class="frmchk" value="${m.irrSrcId}"
																	id="anichkid${count.count}" type="checkbox" />
															</div>
															
															<%-- <c:out value="${count.count+3}"></c:out> ) --%>

															<div class="col-md-10 ">

																<label class="label-control rowlebel " for="parameter1">
																	 <c:out value="${m.irrSrcName}"></c:out> </label> 
																
															</div>
															</div>
						
						</c:forEach>
						</c:if>
														
															
																
  </div>
  
  <div class="flex-child-element col-md-8 ">
   <div id="flreg" >
						
							<div class=" col-md-12">
							 <h4 style="color: blue; margin: 1em; font-weight: bold;">Registered</h4>
							</div>
						<div class="col-md-12">
											
												<label class="label-control rowlebel " for="parameter1">
											a) under left side Channel (Acres)
											
											
											</label> 
											<input
											name="miTankformDataList[0].regLeftChnnAcres" value="0.00"
											class=" form-control regacres " id="regLeftChnnAcres" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
											 
											 	 	<div class="col-md-12">
											 	<label class="label-control rowlebel " for="parameter1">
											b) Under right side Channel (Acres)
											
											
											</label> 
											<input
											name="miTankformDataList[0].regRightChnnAcres" value="0.00"
											class=" form-control regacres " id="regRightChnnAcres" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
											 
											 <div class="col-md-12">
											 	<label class="label-control rowlebel " for="parameter1">
											c) Other Ayacut (Acres)
											
											
											</label> 
											<input
											name="miTankformDataList[0].regOthAcres" value="0.00"
											class=" form-control  regacres" id="regOthAcres" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
											 
											 		 <div class="col-md-12">
											 	<label class="label-control rowlebel " for="parameter1">
											d) Total (Acres)
											
											
											</label> 
											<input
											 value="" readonly="readonly"
											class=" form-control " id="regTotalAcres" type="text" 
										
											   />
											 </div>
											 <br>
											
						</div>
						
						<div id="flrain"  >
						
						<div class=" col-md-12">
						
						 <h4 style="color: blue; margin: 1em; font-weight: bold;">If due to rain fall</h4>
							
							</div>
						
							<div class="col-md-12">
											
												<label class="label-control rowlebel " for="parameter1">
											a) Name of nearest Rain Gauge Station.
											
											
											</label> 
											<input
											name="miTankformDataList[0].rainRGStation" value=""
											class=" form-control " id="rainRGStation" type="text" 
										
											 required  />
											 </div>
											 
											 	<div class="col-md-12">
											 	<label class="label-control rowlebel " for="parameter1">
											b) Quantity of Rainfall
											
											
											</label> 
											<input
											name="miTankformDataList[0].rainQty" value="0.00"
											class=" form-control " id="rainQty" type="text" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											  required  />
											 </div>
											 
											 		 <div class="col-md-12">
											 	<label class="label-control rowlebel " for="parameter1">
											c) date
											
											
											</label> 
											
											<input type="text" class=" datepick form-control datepicker"
											id="rainDate"
											name="miTankformDataList[0].rainDate"
											placeholder="date" readonly="readonly" required />
											
											 </div>
											 
											 	 <br>
											
						</div>
						
						<div id="flbld"  >
					
											<div class="col-md-12">
											
											 <h4 style="color: blue; margin: 1em; font-weight: bold;">Incase of buldings, if the damages are due to cyclone or fire accidents</h4>
										
											</div>
											<div class="col-md-12">
											
												<label class="label-control rowlebel " for="parameter1">
											a) Name of Quarter 
											
											
											</label> 
											<input
											name="miTankformDataList[0].quartName" value=""
											class=" form-control " id="quartName" type="text" 
										
											   />
											 </div>
											 
											 	<div class="col-md-12">
											
												<label class="label-control rowlebel " for="parameter1">
											b) Quarter Type 
											
											
											</label> 
											<input
											name="miTankformDataList[0].quartType" value=""
											class=" form-control " id="quartType" type="text" 
										
											   />
											 </div>
											 
											 	<div class="col-md-12">
											 	<label class="label-control rowlebel " for="parameter1">
											c) Residential or Non Residential
											
											
											</label> 
						    <input
											name="miTankformDataList[0].bldgTypeName" value=""
											class=" form-control " id="bldgTypeName" type="text" 
										
											   />
											 </div>
											 
											 <div class="col-md-12">
											 	<label class="label-control rowlebel " for="parameter1">
											d) Description of damage
											
											
											</label> 
											<textarea
											name="miTankformDataList[0].bldgDescDamage" rows="2" cols="4"
											class=" form-control " id="bldgDescDamage" 
										
											   ></textarea>
											 </div>
											 
											 <br>
											  <br>	
						
						</div>
						
						<c:if test="${frmsrcList!=null }">
						<c:forEach  items="${frmsrcList}" var="t" varStatus="count" >
						
						<div id="flani${count.count}"  >
						
						<div class="col-md-12">
						
						 <h4 style="color: blue; margin: 1em; font-weight: bold;">${t.irrSrcName}</h4>
						
						</div>
						<input name="miTankformDataList[${count.count-1}].irrSrcId" value="${t.irrSrcId}" id="irrSrcId${count.count-1}" type="hidden" />
											<div class="col-md-12">
												<label class="label-control rowlebel " for="parameter1">
											Chainage (from)
											
											
											
											</label> 
											
											<input name="miTankformDataList[${count.count-1}].formDetailId"
											value="0" id="formDetailId${count.count-1}"
											type="hidden" />
										
										
											<input
											name="miTankformDataList[${count.count-1}].irrChFrm" value="0.00"
											class=" form-control " id="irrChFrm${count.count-1}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										
											
											
											<div class="col-md-12">
												 <label class="label-control rowlebel " for="parameter1">
											Chainage(to)
											
											
											
											</label>
											 
											 	<input
											name="miTankformDataList[${count.count-1}].irrChTo" value="0.00"
											class=" form-control " id="irrChTo${count.count-1}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									
									</div>
									
									
											
											
											 <div class="col-md-12">
											 	 <label class="label-control rowlebel " for="parameter1">
											Measurement L.B.  or Depth  (to)
											
											
											
											</label> 
											 <div class="col-md-4"> 
											 <label class="label-control rowlebel " for="parameter1">
											L
											
											
											
											</label> 
											 	<input
											name="miTankformDataList[${count.count-1}].irrL" value="0.00"
											class=" form-control " id="irrL${count.count-1}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											  </div>
											 <div class="col-md-4">
											  <label class="label-control rowlebel " for="parameter1">
											B
											
											
											
											</label>   
											 <input style="float: right"
											name="miTankformDataList[${count.count-1}].irrB" value="0.00"
											class=" form-control " id="irrB${count.count-1}" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
										 <div class="col-md-4"> 
										  <label class="label-control rowlebel " for="parameter1">
											D
											
											
											
											</label> 	 
											 <input style="float: right"
											name="miTankformDataList[${count.count-1}].irrD" value="0.00"
											class=" form-control " id="irrD${count.count-1}" type="text" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>&emsp;&emsp;&emsp;&emsp;
											

									</div>
									
								
											
											 <div class="col-md-12">
											 		 <label class="label-control rowlebel " for="parameter1">
											Permanent Measure(Rs)
											
											
											
											</label> 
											 
											 	<input
											name="miTankformDataList[${count.count-1}].irrPermcost" value="0.00"
											class=" form-control pcost" id="irrPermcost${count.count-1}" type="text" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									</div>
									
									<div class="col-md-12">
											 		 <label class="label-control rowlebel " for="parameter1">
											Temporary Measure(Rs)
											
											
											
											</label> 
											 
											 	<input
											name="miTankformDataList[${count.count-1}].irrTempcost" value="0.00"
											class=" form-control tcost" id="irrTempcost${count.count-1}" type="text" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />

									</div>
								
									
									 <br>
									
									</div>
									</c:forEach>
									
									</c:if>
									
									
	
</div>
</div> 
<!-- start of reservoir -->








				
				 <div class=" col-md-12 invDiv ">	
						
									
											 <div class=" col-md-12">
											<div class="col-md-6">
											
											<label class="label-control rowlebel " for="parameter1">
											Approximate estimate for Repairs or Reconstruction
											
											
											
											</label> 
											</div>
											
											
											<div class="col-md-2">
											
												<label class="label-control rowlebel " for="parameter1">
											Temporary Measure
											
											
											</label> 
											<input
											name="miTankformDataList[0].approxRepTemp" value="0.00" readonly="readonly"
											class=" form-control appval" id="approxRepTemp" type="text"  
										
											  required />
											 </div>
											 
											 	<div class="col-md-2">
											 	<label class="label-control rowlebel " for="parameter1">
											Permanent Repairs
											
											
											</label> 
											<input
											name="miTankformDataList[0].approxRepPermanent" value="0.00"  readonly="readonly"
											class=" form-control appval" id="approxRepPermanent" type="text"  
										
											 required  />
											 </div>
											 
											 	 	<div class="col-md-2">
											 	<label class="label-control rowlebel " for="parameter1">
											Total &emsp;&emsp;&emsp;&emsp; (Rs).
											
											
											</label> 
											<input
											name="miTankformDataList[0].approxRepTotal" value="0.00" readonly="readonly"
											class=" form-control " id="approxRepTotal" type="text" 
										
											   />
											 </div>
											
											 </div>
											 
											
											 
											 <div class="col-md-12"> 
											  <br>
											 		<div class="col-md-6">

										<label class="label-control rowlebel " for="parameter1">
											Book value<font
											color=red>*</font></label> 
											</div>
											<div class="col-md-6"><input
											name="miTankformDataList[0].frmBookValue" value="0.00"
											class=" form-control " id="frmBookValue" type="text" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											 required  />

									</div>
									
									<div class="col-md-8"></div>
									
									</div>
											 
											 <div class="col-md-12">
											  <br>
											<div class="col-md-6">
											
											<label class="label-control rowlebel " for="parameter1">
											Ayacut effected
											
											<font
											color=red>*</font>
											
											</label> 
											</div>
											<div class="col-md-3">
											
												<label class="label-control rowlebel " for="parameter1">
											acres
											
											
											</label> 
											<input
											name="miTankformDataList[0].effAyacutAcres" value="0.00"
											class=" form-control " id="effAyacutAcres" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
											 
											 	<div class="col-md-3">
											 	<label class="label-control rowlebel " for="parameter1">
											value in Rs.
											
											
											</label> 
											<input
											name="miTankformDataList[0].effAyacutValue" value="0.00"
											class=" form-control " id="effAyacutValue" type="text" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12"
										
											   />
											 </div>
											 </div>
											 
											 <div class="col-md-12">
											  <br>
											<div class="col-md-6">
											
											<label class="label-control rowlebel " for="parameter1">
											Whether action is being taken to protect the standing crops: Proposed for Temporary restoration
											
											<font
											color=red>*</font>
											
											</label> 
											</div>
											<div class="col-md-6">
											<textarea
											name="miTankformDataList[0].actionStdCrops" 
											class=" form-control " id="actionStdCrops" rows="1" cols="2"
										
											 required  ></textarea>
											 </div>
											 </div>
											 
											 
									
									<div class=" col-md-12 ">
									 <br>
											<div class="col-md-6">
											
											<label class="label-control rowlebel " for="parameter1">
											Indicate Whether the damages due to breaches. Scours washed off and silted up
											
											<font
											color=red>*</font>
											
											</label> 
											</div>
											<div class="col-md-6">
											<textarea
											name="miTankformDataList[0].damageBreaches"  rows="1" cols="2"
											class=" form-control " id="damageBreaches" 
										
											 required  ></textarea>
											 </div>
											 </div>
											 
											  <div class=" col-md-12">
											   <br>
											<div class="col-md-6">
											
											<label class="label-control rowlebel " for="parameter1">
											Any useful information/Remarks
											
											<font
											color=red>*</font>
											
											</label> 
											</div>
											<div class="col-md-6">
											<textarea
											name="miTankformDataList[0].usefulRemarks"  rows="1" cols="2"
											class=" form-control " id="usefulRemarks" 
										
											 required  ></textarea>
											 </div>
											 </div>
											 
											  <div class="col-md-12" >
											  <br>
 	
 	<div class="col-md-6">
 	<label class="label-control rowlebel "> TSFC Form 20 sent date to Accountant General : <font color=red>*</font>
										</label> </div>
 
 <div class="col-md-6">
										<input type="text" class=" datepick form-control datepicker"
											id="tsfcFormDate"
											name="miTankformDataList[0].tsfcFormDate"
											placeholder="date" readonly="readonly" required/>
									</div>
									
									</div>
											 </div> 
				
									
			 	 <div class="col-md-12 invDiv updatepht">
			 	 
			 	   <div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note *: Size of uploaded multiple photos together should not exceed 2mb(.jpg,.png are allowed) </strong>
				
				
				
				

			</div>
			</div>
					   <div class="col-md-6"  >
										 <label class="label-controlPMS rowlebel ">Upload Photos(Multiple)</label>
										 </div>
										 
										  <div class="col-md-6"  >
								<input id="formPhotosnew" name="miTankformDataList[0].uploadPhotos" type="file" 	class="btn-info" value="Upload Documents"  multiple="multiple"   data-parsley-max-file-size="2048"  data-parsley-fileextension='jpeg,jpg,png'  required > 
							</div>
							
							</div> 
							
							
							<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="mainformcaptcha_id" name="imgCaptcha" src="../captcha.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('mainformcaptcha_id').src = '../captcha.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="miTankformDataList[0].captcha"  id="form20captcha" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
								</div>
					
				
				
								


                           <div class="col-md-12">
								<br>
								
								  <div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note *: Edit form 20,Delete form 20, update photos,delete photos buttons are available only for 7 days from the date of submission.</strong>
				
				
				
				

			</div>
			</div>
								<button type="button" name="addmichecks8" id="addmichecks8" onclick="addformdata(this.form.name),editformdata(this.form.name)"
									class="btn btn-1 btn-primary center-block frmchkbutton">Submit</button>
									
								</div>

</c:if>
							</form:form>
							
							
							&emsp;&emsp;&emsp;&emsp;&emsp;
<%-- <c:if test="${userObj!=null && ( userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==0)}"> --%>
							<div id="frm20data">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="table8">
											<thead id="thead8">

											</thead>


											<tbody id="tbody8">

											</tbody>
										</table>
									</div>


								</div>
							</div>

<%-- </c:if> --%>


						</div> <!--  form20end  -->
						
							

















				<!-- 	</div> -->
					<!-- tabs -->









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






<div id="gettanks_dialogue">

	<form:form id="gettanks" method="post" modelAttribute="gettanks"
		name="getanksdescform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="viewtanksdata">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered table1" style="width: 100%"
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
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata('${t.tankName}','${t.tankId}','${t.tankCode}','${t.newDistrictId}','${t.mandalId}','${t.villageId}','${t.acCode}','${t.habitationId}','${t.mandalName}','${t.villageName}',1),gettankgeotaglist('${t.tankId}'),getfrmsentlist(${t.tankId},0,0)" >Select Tank</button></td>
												
												
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
										<table class=" display table-bordered table1" style="width: 100%"
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
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata('${t.tankName}','${t.tankId}','${t.tankCode}','${t.newDistrictId}','${t.mandalId}','${t.villageId}','${t.acCode}','${t.habitationId}','${t.mandalName}','${t.villageName}',2),gettankgeotaglist('${t.tankId}'),getfrmsentlist('${t.tankId}',0,0)" >Select Anicut</button></td>
												
												
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
										<table class=" display table-bordered table1" style="width: 100%"
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
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata('${t.tankName}','${t.tankId}','${t.tankCode}','${t.newDistrictId}','${t.mandalId}','${t.villageId}','${t.acCode}','${t.habitationId}','${t.mandalName}','${t.villageName}',3),gettankgeotaglist('${t.tankId}'),getfrmsentlist('${t.tankId}',0,0)" >Select Check Dam</button></td>
												
												
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


<!-- form20dialogues -->


<div id="frm20_view_dia">

<div id="viewfrm20">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="view-frm-table-9">
											<thead id="view-thead9">

											</thead>


											<tbody id="view-tbody9">

											</tbody>
										</table>
									</div>


								</div>
							</div>



 

</div>

<div id="frm20_doc_update">

<div id="docfrm20update">

<form:form id="editdoc9" name="editdocphoto9"
								modelAttribute="miTankformDataList" method="post" class="mitankform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

 	 <div class="col-md-12 invDiv fphtedit">
					   <div class="col-md-6"  >
										 <label class="label-controlPMS rowlebel ">Upload Photos(Multiple)</label>
										 
										 <input name="miTankformDataList[0].formDataId" value="0" readonly="readonly" 
											class=" form-control " id="editformdataId" type="hidden" />
										 </div>
										 
										  <div class="col-md-6"  >
								<input id="editformPhotosnew" name="miTankformDataList[0].uploadPhotos" type="file" 	class="btn-info" value="Upload Documents"  multiple="multiple"  required  data-parsley-max-file-size="2048"  data-parsley-fileextension='jpeg,jpg,png'  > 
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
													
											<input type="text" name="miTankformDataList[0].captcha"  id="photocaptcha_id1" class="form-control" required>
													
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


<div id="frm20_doc_dia">

<div id="docfrm20">
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







    
    <div id="confirmdia">

</div>

<div id="getprojects_dialogue">

	<form:form id="getprojects" method="post" modelAttribute="getprojectsdata"
		name="getprojdescform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="viewprojectsdata">
								<div class="show-grid gridList "
									style="display: block">
									<div class="table-responsive" >
										<table class=" display table-bordered table1" style="width: 100%"
											id="viewtanksdataid">
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
																	class="btn btn-1 btn-primary center-block"  onclick="showprojectsdata('${t.projectName}',${t.projectId},${m.reservoirId},'${m.resName}',${m.unitId},4),getfrmsentlist(0,${m.reservoirId},0)" >Select Reservoir</button></td>
																	</tr>
																	
												</c:when>
												
												</c:choose>
												</c:forEach>
											<%-- 	<tr>
												<td></td>
												<td><button type="button" name="selectproject" id="selectProjectsdata${count.count}" 
																	class="btn btn-1 btn-primary center-block"  onclick="showprojectsdata('${t.projectName}',${t.projectId},0,'NA',0),getann1inspectdata(year.value)" >Select Project</button>
																	</td></tr> --%>
												
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


<div id="getprojectscanals_dialogue">

	<form:form id="getprojectscanals" method="post" modelAttribute="getprojectsdata"
		name="getprojdescform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="viewprojectsdata">
								<div class="show-grid gridList "
									style="display: block">
									<div class="table-responsive" >
										<table class=" display table-bordered table1" style="width: 100%"
											id="viewtanksdataid">
											<thead id="viewprojectsdatahead">
											<tr style="font-weight: bold;"> 
											<th>S.No.</th>
											<th>Project</th>
											
										    <th>Action</th>
																			
										
											
											
											
											
											
											 </tr>

											</thead>


											<tbody id="viewprojectsdatabosy">
											
											<c:forEach items="${projectList}" var="t" varStatus="count">
										<%--   <c:if test="${t.unitId>0&&t.circleId<=0&&t.divisionId<=0}">	 --%>
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
											  
											
												<td style="color: blue;"><c:out value="${t.projectName}"></c:out></td>
											
											     <td><button type="button" name="selectprojectcan" id="showprojectscan${count.count}" 
																	class="btn btn-1 btn-primary center-block"  onclick="showprojectscandata('${t.projectName}',${t.projectId},5)" >Select Project</button></td>
												
												
											
												
												
										
												
												
												
												
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
						
						<button type="button" name="submitResinfo" id="submitRes" 
																	class="btn btn-1 btn-primary center-block" onclick="updateReservoirLocation()"  >Submit</button>
						
						</div>
		
		
				
			</div>			

	</form:form>
	


</div>


<div id="addcanals_dialogue">

	<div id="form20tabs">
<ul><li  ><a href="#getcanal" >Select Canal</a></li>
							<li   ><a href="#addcanal" >Add Canal Name</a></li>
							<li   ><a href="#addloccanal" >Add Canal Location</a></li>

						</ul>
			
			
			<div id="getcanal">	
			
			<form:form id="addcanalsloc1" method="post" modelAttribute="addcanalsdata"
		name="addcanalsloc1form" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
			
							<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note 1 *: Select Canal to see form 20</strong>
				
		
			</div>
			</div>
			
			
			
			<div id="viewcnlinfo">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="view-cnl-table-13">
											<thead id="view-thead13">

											</thead>


											<tbody id="view-tbody13">

											</tbody>
										</table>
									</div>


								</div>
							</div>
			
			</form:form>
			</div>
			
			<div id="addcanal">	
			
			<form:form id="addcanalsloc2" method="post" modelAttribute="addcanalsdata"
		name="addcanalsloc2form" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		 <input type="hidden" class="form-control"  id="editFlag2"  value="false" />
		  	<input id="cancanId2" value="0"  name="canalId" class=" form-control "  type="hidden" />
		 <input id="canProjectId2" value="0" name="projectId"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="hidden" />
		<div class="alert alert-info " style="padding: 0px"
					id="action_alertcan2">
					
				</div>
		
			
			<div class=" col-md-12 ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note 1 *: Use Project Code for Canal name: Ex: SRSP11L</strong>
				<br>
				<strong style="color:#CA3F22"> Note 2*: Length Of Canal Name is restricted to minimum 3 maximum 20 characters and One Upper Case character </strong>
				<br>
				<strong style="color:#CA3F22"> Note 3*: For Supplimental Canal use (SUPPL). Do not add km in Canal names. Use chainage for Km in add Canal Location </strong>
				
				
				
				

			</div>
			</div> 
			
			
			
			<!-- <div class=" invDiv">	 -->
			
					<div class="col-md-12">
						<br>
						
						<div class="col-md-6" id="projCodeviewid" style="color: blue; font-weight: bold;">
						
						
						
						
						</div>	
						
						<div class="col-md-6" id="projnameviewid" style="color: blue; font-weight: bold;">
						
						
						
						
						</div>
						
						
									
						
					
									
									<br><br>	
									</div>	
						
			
			<div  class="col-md-12">	
			
			<br>
					<div class="col-md-4">
							
							
							
								
											
								<label class="label-control rowlebel ">Canal Name:
										<font color=red>*</font>
									</label>
									
									<input id="canalName" value="" name="canalName"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  required data-parsley-type="alphanum" data-parsley-minlength="3" data-parsley-uppercase="1"  data-parsley-maxlength="20" />
											
												
											
											</div>
											
															<div class="col-md-4">
										<label class="label-control rowlebel ">Select Canal Type:
										<font color=red>*</font>
									</label>
									
										<select class="form-control" id="canalTypeId" name="canalTypeId" 
							 required   >
							<option value=" ">--select--</option>
							<option value="1">Main </option>
							<option value="2">Distributory</option>
							<option value="3">Minor</option>
							<option value="4">Sub Minor</option>
							<option value="5">child-Sub minor</option>	
							<option value="6">Other than above</option>		
						

						</select>
						</div>
									
					
									
									<div class="col-md-4">
										<label class="label-control rowlebel ">Select reservoir:
										
									</label>
									
										<select class="form-control" id="canalReservoirId" name="reservoirId" 
							    >
							    
							    
							
								
							
						
						
						

						</select>
						</div>
						
						
						</div>
						
						<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="cancaptcha_id" name="imgCaptcha" src="../captcha2.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('cancaptcha_id').src = '../captcha2.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="cancaptcha1" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
								</div>
						
							<div class="col-md-12">
						<br>
						
						<button type="button" name="submitCanalName" id="submitCanalName" 
																	class="btn btn-1 btn-primary center-block"  onclick="addCanals()"  >Submit</button>
						<br><br>
						</div>
						
						
						
						<div id="viewcnlnameinfo">
							
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="view-cnl-table-14">
											<thead id="view-thead14">

											</thead>


											<tbody id="view-tbody14">

											</tbody>
										</table>
									</div>


								</div>
							</div>
									
			
			<!-- </div> -->
			
			</form:form>
			
			</div>
						
		<div id="addloccanal">		
	

	<form:form id="addcanalsloc" method="post" modelAttribute="addcanalsdata"
		name="addcanalslocform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		  <input type="hidden" class="form-control"  id="editFlag"  value="false" />
		  
		  <input id="canProjectId" value="0" name="projectId"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="hidden" />
		<input id="canselectedMandalId" value="0"   class=" form-control "  type="hidden" />
		<input id="canselectedVillageId" value="0"   class=" form-control "  type="hidden" />
		<input id="canselectedDistrictId" value="0"   class=" form-control "  type="hidden" />
		
		<input id="canalLocId" value="0" name="canalLocId"  class=" form-control "  type="hidden" />
		
		
	
<div class="alert alert-info col-md-12" style="padding: 0px"
					id="action_alertcan">
					
				</div>
		
		
		
	
		
		  
		  		<!-- <div class="col-md-12 invDiv">	 -->
		  		
		  				
		<div  class="col-md-12">	
									
							<br>
									
									<div  class="col-md-3">	
										<label class="label-control rowlebel ">Select Canal:
										
									</label>
									
										<select class="form-control" id="canalId" name="canalId" 
							 required  >
							
						

						</select>
						</div>
						
						
					
									<div class="col-md-3">
										<label class="label-control rowlebel ">Select District:
										<font color=red>*</font>
									</label>
									
										<select class="form-control" id="candistrictId" name="districtId" 
							 required onchange="getMandals(candistrictId.value,2)">
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
									
										<select class="form-control" id="canmandalId" name="mandalId" 
							 required  onchange="getVillages(candistrictId.value,this.value,2)">
							
							
						

						</select>
						
						</div>
					
						
					
						<div class="col-md-3">
						
						
										<label class="label-control rowlebel ">Select Village:
										
									</label>
									
										<select class="form-control" id="canvillageId" name="villageId" 
							 >
							
						

						</select>
						</div>
						
						
						
								</div>
						
						<div class="col-md-12">
						<br>
							
								
							<div class="col-md-10">				
								<label class="label-control rowlebel ">(If Village is not in the above list then use this column)Village Name:
										
									</label>
									
									<input id="canreamarksVillageName" value="" name="reamarksVillageName"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" />
											
											
									</div>		
											
											
											
									</div>
									
									<div class="col-md-12">
						<br>
							
								
							<div class="col-md-6">				
								<label class="label-control rowlebel ">Chainage From(km)
										
									</label>
									
									<input id="chainageFromkm" value="0.00" name="chainageFromkm"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12" />
											
											
									</div>
									
									<div class="col-md-6">				
								<label class="label-control rowlebel ">Chainage To(Km)
										
									</label>
									
									<input id="chainageTokm" value="0.00" name="chainageTokm"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 digits ex:0.12" />
											
											
									</div>			
											
											
											
									</div>
									
									
									<div class="col-md-12">
						<br>
						<div class="col-md-4"></div>
						<div class="col-md-4">

												<img id="cancaptcha_id2" name="imgCaptcha" src="../captcha3.jpg">

										

											
												<a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('cancaptcha_id2').src = '../captcha3.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a>
										
												</div>
												<div class="col-md-4"></div>
											</div>
											
							
								<div class="col-md-12 ">
								<div class="col-md-4"></div>
								<div class="col-md-4">
								
									<label class="label-control" for="captcha">Enter above Image text </label>											
													
											<input type="text" name="captcha"  id="cancaptcha2" class="form-control" required>
													
								</div>
								<div class="col-md-4"></div>
								</div>
									
								<div class="col-md-12">
						<br>	
						
						<div class="col-md-4"></div>
									<div class="col-md-4">
						
						
						<button type="button" name="submitCanalinfo" id="submitCanalLoc" 
																	class="btn btn-1 btn-primary center-block"  onclick="addCanalLocation()"  >Submit</button>
						
						</div>
						
						<div class="col-md-4"></div>
									
									<br><br>	
									</div>	
						
						
						
						<div id="viewcnllocinfo">
						
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="view-cnl-table-15">
											<thead id="view-thead15">

											</thead>


											<tbody id="view-tbody15">

											</tbody>
										</table>
									</div>


								</div>
							</div>
		
		
				
				
<!-- </div>	 -->	
	</form:form>
	
	
	
</div>
</div>
</div>


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
	
	
	

