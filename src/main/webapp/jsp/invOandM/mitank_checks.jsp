

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

<script type="text/javascript" src="../js/invom/michecks.js"></script>
<link rel="stylesheet" media="screen" href="../css/invom/michecks.css">

 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />






<!-- <div class="w3l-main" id="borderStyle"> -->


<div class="col-md-9">



	<div>



		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">TMS of Irrigation Tank:Tank Inspection Data Entry. 
				
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

					
						&emsp; &emsp;
						<div class="col-md-12 invDiv">
						
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
								</div>
						
						<div class="col-md-12 invDiv">
						
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
						<!-- 	<div  id="tankdata"  class="col-md-6">		
									
								
								
									<select class="form-control" id="tankId" name="tankId" required
										onchange="getrepairdata(this.value),getcapacitydata(this.value),gettankfeeddata(this.value),getsluicelist(this.value),getweirlist(this.value),gettankgeotaglist(this.value),getrepairdesclist(this.value),getmst2inspectdata(year.value)">
										


									</select>
									
									
									
								</div> -->
								
								
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
											Capacity (mcft)</label>

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
	<div class="col-md-12 invDiv">							
	<!-- <div class="col-md-6"> -->
								<%-- <div class="col-md-6">
									<label class="label-control rowlebel ">Select
										District: <font color=red>*</font>
									</label>
								</div>

								<div class="col-md-6">
									<select class="form-control" id="districtId" name="districtId"
										onchange="getMandals(this.value,1)" required>

										<option value="">--select--</option>
										<c:forEach items="${districtList}" var="d">
											<c:choose>
												<c:when test="${d.districtId==selectedDistrictId }">
													<option value="${d.districtId}" selected="selected">${d.districtName}</option>
												</c:when>
												<c:otherwise>
													<option value="${d.districtId}">${d.districtName}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>


									</select>
								</div> --%>

							<!-- 	<div class="col-md-6">
									<label class="label-control rowlebel ">Select
										Mandal: <font color=red>*</font>
									</label>
								</div>

								<div class="col-md-6">
								
								<input  value="0"
									id="mcode" type="hidden" />
									<select class="form-control" id="mandalId" name="mandalId"
										onchange="getVillages(this.value,1)" required>



									</select>
								</div>
								 -->
								
							<!-- 	<div class="col-md-6">
								<input  value="0"
									id="vcode" type="hidden" />
									<label class="label-control rowlebel ">Select
										Village: <font color=red>*</font>
									</label>
								</div>
								<div class="col-md-6">
									<select class="form-control" id="villageId" name="villageId"
										required onchange="getHabitations(districtId.value,mcode.value,vcode.value,1)">


									</select>
								</div>
								 -->
								<!-- <div class="col-md-6">
									<label class="label-control rowlebel ">Select
										Habitation: <font color=red>*</font>
									</label>
								</div>
								<div class="col-md-6">
									<select class="form-control" id="habitationId" name="habitationId"
										required onchange="getTanks(districtId.value,mcode.value,vcode.value,this.value,1)">


									</select>
								</div> -->
								
						<!-- 	<div class="col-md-6">
									<label class="label-control rowlebel ">
										Constituency: <font color=red>*</font>
									</label>
								</div> -->

<!-- 
								<div class="col-md-6">
									<input name="constName" class="form-control" value="0"
									id="constName" type="text"  readonly="readonly"/>
									<input name="constId" value="0"
									id="constId" type="hidden" />
								</div>
								 -->
								
							
								
					

								
						<!-- 	</div> -->
							<div class="col-md-12">
							
							<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Select frequency, Over all Tank status </strong>
				<br>
				

			</div>
			</div>
							
							
								<div  id="emp">
									

									<div class="col-md-6">
									
									<label class="label-control rowlebel ">Next level review: <font color=red>*</font>
										</label>
										<input name=nextEmpId value="0" 	id="nextEmpId" type="hidden" />
										<select class="form-control" id="nextPostId" name="nextPostId" required>
										
											<option value=" ">--select--</option>

											<c:forEach items="${getempapprove}" var="u">
												<option value="${u.postId}">${u.empName}</option>
                                   <c:if test="${getempapprove.size()==1}"><script>    $('select>option:eq(1)').prop('selected', true);  $("#nextPostId").val("${u.postId}");$("#nextEmpId").val("${u.empId}");</script></c:if>
											</c:forEach>


										</select>
									</div>
								</div>
								
									<div  id="yearid">
									
									<div class="col-md-6">
									<label class="label-control rowlebel ">Year:
											<font color=red>*</font>
										</label>
										
										<input class="form-control" id="year"  type="text" name="year"  value=""  readonly="readonly"   required />
									<!-- 	<select class="form-control" id="year" name="year"
											onchange="getmst2inspectdata(this.value)" required>
											<option value=" ">--select--</option>
										


										</select>  -->
									</div>
								</div>
								
								


								
								</div>
								&emsp;&emsp;
                              <div class="col-md-12">
                              
                              <div id="freqid">
								
									<div class="col-md-6">
									<label class="label-control rowlebel ">Select
											Frequency: <font color=red>*</font>
										</label>
										<select class="form-control" id="miTankFreqId"
											name="miTankFreqId" onchange="getmst2inspectdata(year.value)"  required>
											<option value=" ">--select--</option>
											<option value="9">PRE MONSOON (April,May)</option>
											<option value="10">POST MONSOON (November,December)</option>
											<option value="11">DURING MONSOON(JUNE TO AUGUEST)</option>


										</select>
									</div>
								</div>

							
								
                             <div  id="statusid" >
								
									
																<div class="col-md-4"> 
																<label class="label-control rowlebel ">Over all Tank status:<font color=red>*</font>
																</label>
																
																<select class="form-control"
																	id="tankStatusId"
																	name="tankStatusId" required>
																	<option value=" ">--select--</option>
																	<option value="1">Observation</option>
																	<option value="2">Emergency</option>
																	<option value="3">Maintenance</option>
																	<option value="4">Original Work</option>



																</select>
																</div>
																	<div class="col-md-2">
																
																<button type="button" name="edittankStatus" id="editankStatus" 
																	class="btn btn-1 btn-primary center-block  " onclick="editcrticalstatus(tankStatusId.value)">Edit Status</button>
															</div>
								

							</div>
					
						</div>
						
					
						</div>
						

					</form:form>
					
				

															
				</div>



&emsp;&emsp;

				<div id="result1" class="col-md-12 ">


					<div id="tabs">
						<ul>



							<li  id="bundli" ><a href="#emb" onclick="getcheckfalse1()">BUND</a></li>
							<li  id="sluiceli"  ><a href="#slu" onclick="getcheckfalse2()">SLUICE</a></li>
							<li  id="weirli"  ><a href="#weir" onclick="getcheckfalse3()">WEIR</a></li>

						
							<li><a href="#capacity" onclick="getcheckfalse6()">TANK
									CAPACITY</a></li>
					
									
								





						</ul>
						<!-- tabs -->





						<div id="emb">

							<form:form id="michecks1" name="michecks1"
								modelAttribute="micheckList" method="post" class="mitankform"
								data-parsley-validate-if-empty="">

								<input name="miTankInspectList[0].newDistrictId" value=""
									id="midistrictId1" type="hidden" />
								<input name="miTankInspectList[0].mandalId" value=""
									id="mimandalId1" type="hidden" />
								<input name="miTankInspectList[0].villageId" value=""
									id="mivillageId1" type="hidden" />
								<input name="miTankInspectList[0].tankId" value=""
									id="mitankId1" type="hidden" />
								<input name="miTankInspectList[0].miTankFreqId" value=""
									id="mimiTankFreqId1" type="hidden" />
									<input name="miTankInspectList[0].miInpsectMst1Id" value=""
									id="miInpsectMst1Id1" type="hidden" />
								<input name="miTankInspectList[0].year" value="" id="miyear1"
									type="hidden" />
									
									<input name="miTankInspectList[0].nextEmpId" value="" id="nextEmpId1" type="hidden" />
										<input name="miTankInspectList[0].nextPostId" value="" id="nextPostId1" type="hidden" />
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="miTankInspectList[0].postId" value="${userObj.post}" id="postId1"
									type="hidden" />
									</c:if>
									
										
									
									
									
									<input name="miTankInspectList[0].tankStatusId" value="0" id="tankStatusId1"
									type="hidden" />
									
									<c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" id="userempId1" type="hidden" />
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId!=null}">

									<c:if test="${userObj.unitId>0}">
										<input name="miTankInspectList[0].unitId"
											value="${userObj.unitId}" id="miunitId1" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.unitId==null|| userObj.unitId==0)}">
									<c:if test="${userObj.unitId==0}">
										<input name="miTankInspectList[0].unitId" value="0"
											id="miunitId1" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.circleId!=null}">
									<c:if test="${userObj.circleId>0}">
										<input name="miTankInspectList[0].circleId"
											value="${userObj.circleId}" id="micircleId1" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.circleId==null || userObj.circleId==0)}">
									<c:if test="${userObj.circleId==0}">
										<input name="miTankInspectList[0].circleId" value="0"
											id="micircleId1" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.divisionId!=null}">
									<c:if test="${userObj.divisionId>0}">
										<input name="miTankInspectList[0].divisionId"
											value="${userObj.divisionId}" id="midivisionId1"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.divisionId==null || userObj.divisionId==0 )}">
									<c:if test="${userObj.divisionId==0}">
										<input name="miTankInspectList[0].divisionId" value="0"
											id="midivisionId1" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.subdivisionId!=null }">
									<c:if test="${userObj.subdivisionId>0}">
										<input name="miTankInspectList[0].subdivisionId"
											value="${userObj.subdivisionId}" id="misubdivisionId1"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.subdivisionId==null || userObj.subdivisionId==0 )}">
									<c:if test="${userObj.subdivisionId==0}">
										<input name="miTankInspectList[0].subdivisionId" value="0"
											id="misubdivisionId1" type="hidden" />
									</c:if>
								</c:if>
								
								<c:if test="${userObj!=null && userObj.sectionId!=null }">
									<c:if test="${userObj.sectionId>0}">
										<input name="miTankInspectList[0].sectionId"
											value="${userObj.sectionId}" id="misectionId1"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.sectionId==null || userObj.sectionId==0 )}">
									<c:if test="${userObj.sectionId==0}">
										<input name="miTankInspectList[0].sectionId" value="0"
											id="misectionId1" type="hidden" />
									</c:if>
								</c:if>
								

								<c:if test="${userObj!=null && userObj.projectId!=null}">
									<c:if test="${userObj.projectId>0}">
										<input name="miTankInspectList[0].projectId"
											value="${userObj.projectId}" id="projectId1" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.projectId==null || userObj.projectId==0 )}">
									<c:if test="${userObj.projectId==0 || userObj.projectId==null}">
										<input name="miTankInspectList[0].projectId" value="0"
											id="projectId1" type="hidden" />
									</c:if>
								</c:if>
								<input name="miTankInspectList[0].constId" value="0"
									id="constId1" type="hidden" />


								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if test="${userObj.designationId>0}">
										<input name="miTankInspectList[0].designationId"
											value="${userObj.designationId}" id="designationId1"
											type="hidden" />
									</c:if>
								</c:if>

								<c:if
									test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0) }">

									<c:if test="${userObj.designationId==0}">
										<input name="miTankInspectList[0].designationId" value="0"
											id="designationId1" type="hidden" />
									</c:if>
								</c:if>
								<input name="miTankInspectList[0].tabId" value="1"
									id="tabId1" type="hidden" />

								<input name="miTankInspectList[0].tankWeirSluiceId" value="0"
									id="tankWeirSluiceId1" type="hidden" />

								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
										<input name="miTankInspectList[0].levelId" value="0"
											id="levelId1" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==4 ) }">
										<input name="miTankInspectList[0].levelId" value="1"
											id="levelId1" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==5 || userObj.designationId==6 ) }">
										<input name="miTankInspectList[0].levelId" value="2"
											id="levelId1" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==7  ) }">
										<input name="miTankInspectList[0].levelId" value="3"
											id="levelId1" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==9 || userObj.designationId==10 ) }">
										<input name="miTankInspectList[0].levelId" value="4"
											id="levelId1" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && userObj.designationId==null}">
									<input name="miTankInspectList[0].levelId" value="-1"
										id="levelId1" type="hidden" />
								</c:if>
								
							<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note 1*: Please ensure that check box is enabled before entering data and to enable submit button. </strong>
				<br>
				<strong style="color:#CA3F22"> Note 2:  Only AEE can submit inspection data. DEE/EE/SE can add remarks only. </strong>
				
				<br>
				<strong style="color:#CA3F22"> Note 3:  Click on Ok to view other tabs (Ex: Sluice,Weir,Tank Capacity). </strong>
				

			</div>
			</div>
											&emsp;&emsp;


								<c:forEach items="${micompsparent}" var="m" varStatus="mcount">




									<c:forEach items="${micompschild}" var="n" varStatus="ncount">


										<c:if
											test="${m.miCompId==n.miparentId && m.hasChild==true && ( n.miparentId==1) }">
											<%-- <div class="col-md-12" style="color: maroon;">
												<h4>
													<b><c:out value="${n.miCompName}"></c:out></b>
												</h4>
											</div> --%>
											&emsp;
										

											<c:if test="${michecks1!=null}">
												<c:forEach items="${michecks1}" var="k" varStatus="kcount">
													<c:if test="${n.miCompId==k.miCompId}">


														<div class="row">
															<br></br>
															<div class="col-md-1">
																${kcount.count} <input
																	name="miTankInspectList[${kcount.count}].micheckboxId"
																	class="schedulecuscheck1 mycustomcheck" value="0"
																	id="micheckboxId${kcount.count}" type="checkbox" />
															</div>

															<div class="col-md-2 invDiv">

																<label class="label-control rowlebel " for="parameter1">
																	${k.miCheck}</label> <input
																	name="miTankInspectList[${kcount.count}].miInspectMapId"
																	value="${k.miInspectMapId}"
																	id="miInspectMapId${kcount.count}" type="hidden" /> <input
																	name="miTankInspectList[${kcount.count}].miInspectTypeId"
																	value="${k.miInspectTypeId}"
																	id="miInspectTypeId${kcount.count}" type="hidden" /> <input
																	name="miTankInspectList[${kcount.count}].miCompId"
																	value="${k.miCompId}" id="miCompId${kcount.count}"
																	type="hidden" />

															</div>


															<div id="bunddate${kcount.count}" class="col-md-2 bunddate">
																<label class="label-control rowlebel ">Inspect Date: <font color=red>*</font>
																</label> <input type="text"
																	class=" datepick form-control datepicker "
																	id="inspectDate${kcount.count}"
																	name="miTankInspectList[${kcount.count}].inspectDate"
																	placeholder="dateofoperation" readonly="readonly"/>
															</div>

															<div id="bundactreq${kcount.count}" class="col-md-2 bundactreq"> 
																<label class="label-control rowlebel ">Action
																	Required :<font color=red>*</font>
																</label> <label class="radio-inline"> <input
																	type="radio" class="myradio n bundreqn"
																	name="miTankInspectList[${kcount.count}].actionreq"
																	id="actionreqn${kcount.count }" value="false">NO
																</label> <label class="radio-inline"> <input
																	type="radio" class="myradio y bundreqy"
																	name="miTankInspectList[${kcount.count}].actionreq"
																	id="actionreqy${kcount.count}" value="true">Yes
																</label>


															</div>


															<div class="col-md-2 myactionreq"
																id="myactionreqid${kcount.count }">
																<label class="label-control rowlebel ">Action
																	Required Type:<font color=red>*</font>
																</label> <select class="form-control actionreqselect"
																	id="actionrequireqId${kcount.count}"
																	name="miTankInspectList[${kcount.count}].actionrequireqId">
																	<option value=" ">--select--</option>
																	<option value="1">Observation</option>
																	<option value="2">Emergency</option>
																	<option value="3">Maintenance</option>
																	<option value="4">Original Work</option>



																</select>
															</div>

															<div id="bundobs${kcount.count}" class="col-md-2 bundobs">

                                               <label class="label-control rowlebel ">Observations
																</label>
																<textarea class="form-control myrem"
																	id="remarks${kcount.count}"
																	name="miTankInspectList[${kcount.count}].remarks"
																	rows="3" cols="50" placeholder="Observations"></textarea>
															</div>

															<div class="col-md-1">
															<input
																	name="miTankInspectList[${kcount.count}].miInpsectMst2Id"
																	value="0"
																	id="miInpsectMst2Id${kcount.count}" type="hidden" /> 
															
															 <c:if test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==4 ||  userObj.designationId==5 ) }">
															 <label></label>
																<button type="button" name="editemb" id="editemb${kcount.count}" 
																	class="btn btn-1 btn-primary center-block editemb " onclick="openmicheckform(miInpsectMst2Id${kcount.count}.value,tabId1.value,miyear1.value,${kcount.count},miInpsectMst1Id1.value)">Edit</button>
																	</c:if>
																	
																	&emsp;&emsp;&emsp;&emsp;
																	
																	 <c:if test="${userObj.designationId>0 && ( userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==4 || userObj.designationId==5) }">
																	  <label></label>
																<button type="button" name="deleteemb" id="deleteemb${kcount.count}" 
																	class="btn btn-1 btn-primary center-block deleteemb" onclick="deleteembMst2(miInpsectMst2Id${kcount.count}.value,tabId1.value,miyear1.value,${kcount.count})" >Delete</button>
																	
																	</c:if>
															</div>
														</div>

													</c:if>
												</c:forEach>
											</c:if>
										</c:if>

									</c:forEach>





									<br />

								</c:forEach>
								
								<c:if test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
                            <div   style="text-align: center;">
                            
                            <textarea class="form-control"
																	id="embRemarks"
																	name="miTankInspectList[0].embRemarks"
																	rows="3" cols="50" placeholder="Observations"></textarea>
											
											</div>
												</c:if>
								
								
								<button type="button" name="addmichecks1" id="addmichecks1"
									class="btn btn-1 btn-primary center-block micheckbutton">Submit</button>


							</form:form>
							
							
									
						<div class="row">
 <c:if test="${userObj.designationId>0 && (userObj.designationId==4 || userObj.designationId==5 || userObj.designationId==6 || userObj.designationId==7 || userObj.designationId==9 || userObj.designationId==10) }">
                            <div class="col-md-6" id="embrev" style="text-align: center;">
												<label class="label-control rowlebel ">
													<button type="button" name="addembRemarks" id="addembRemarks"
														class="btn btn-1 btn-primary center-block">Add
														Remarks</button>
												</label>
											</div>
												</c:if>
												
												 <div class="col-md-6"  style="text-align: center;">
												<label class="label-control rowlebel ">
												<input value="0"
																	id="embmst1Id" type="hidden" /> 
													<button type="button" name="viewembRemarks" id="viewembRemarks"
														class="btn btn-1 btn-primary center-block"  onclick="viewmst1Remarks(embmst1Id.value,1);">View
														Remarks</button>
												</label>
											</div>
											</div>

						</div>
						<div id="slu">

							<form:form id="michecks2" name="michecks2"
								modelAttribute="micheckList" method="post" class="mitankform"
								data-parsley-validate-if-empty="">

								<input name="miTankInspectList[0].newDistrictId" value=""
									id="midistrictId2" type="hidden" />
								<input name="miTankInspectList[0].mandalId" value=""
									id="mimandalId2" type="hidden" />
								<input name="miTankInspectList[0].villageId" value=""
									id="mivillageId2" type="hidden" />
								<input name="miTankInspectList[0].tankId" value=""
									id="mitankId2" type="hidden" />
								<input name="miTankInspectList[0].miTankFreqId" value=""
									id="mimiTankFreqId2" type="hidden" />
								<input name="miTankInspectList[0].year" value="" id="miyear2"
									type="hidden" />
									<input name="miTankInspectList[0].miInpsectMst1Id" value=""
									id="miInpsectMst1Id2" type="hidden" />
								
										<input name="miTankInspectList[0].tankStatusId" value="0" id="tankStatusId2"
									type="hidden" />
									<input name="miTankInspectList[0].nextEmpId" value="" id="nextEmpId2" type="hidden" />
									<input name="miTankInspectList[0].nextPostId" value="" id="nextPostId2" type="hidden" />
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="miTankInspectList[0].postId" value="${userObj.post}" id="postId2"
									type="hidden" />
									</c:if>
									<c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" id="userempId2" type="hidden" />
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId!=null}">

									<c:if test="${userObj.unitId>0}">
										<input name="miTankInspectList[0].unitId"
											value="${userObj.unitId}" id="miunitId2" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId==null}">
									<c:if test="${userObj.unitId==0}">
										<input name="miTankInspectList[0].unitId" value="0"
											id="miunitId2" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.circleId!=null && userObj.circleId>0 )}">
									
										<input name="miTankInspectList[0].circleId"
											value="${userObj.circleId}" id="micircleId2" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && ( userObj.circleId==null || userObj.circleId==0 )}">
									
										<input name="miTankInspectList[0].circleId" value="0"
											id="micircleId2" type="hidden" />
								
								</c:if>
								<c:if test="${userObj!=null && ( userObj.divisionId!=null && userObj.divisionId>0 )}">
									
										<input name="miTankInspectList[0].divisionId"
											value="${userObj.divisionId}" id="midivisionId2"
											type="hidden" />
									
								</c:if>
								<c:if test="${ userObj!=null && ( userObj.divisionId ==null || userObj.divisionId==0 )}">
									
										<input name="miTankInspectList[0].divisionId" value="0"
											id="midivisionId2" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && ( userObj.subdivisionId!=null && userObj.subdivisionId>0)}">
									
										<input name="miTankInspectList[0].subdivisionId"
											value="${userObj.subdivisionId}" id="misubdivisionId2"
											type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && ( userObj.subdivisionId==null || userObj.subdivisionId==0)}">
									
										<input name="miTankInspectList[0].subdivisionId" value="0"
											id="misubdivisionId2" type="hidden" />
									
								</c:if>
								
								<c:if test="${userObj!=null && userObj.sectionId!=null }">
									<c:if test="${userObj.sectionId>0}">
										<input name="miTankInspectList[0].sectionId"
											value="${userObj.sectionId}" id="misectionId2"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.sectionId==null || userObj.sectionId==0 )}">
									<c:if test="${userObj.sectionId==0}">
										<input name="miTankInspectList[0].sectionId" value="0"
											id="misectionId2" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.projectId!=null && userObj.projectId>0)}">
									
										<input name="miTankInspectList[0].projectId"
											value="${userObj.projectId}" id="projectId2" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && (userObj.projectId==null || userObj.projectId==0)}">
									
										<input name="miTankInspectList[0].projectId" value="0"
											id="projectId2" type="hidden" />
									
								</c:if>
								<input name="miTankInspectList[0].constId" value="0"
									id="constId2" type="hidden" />


								<c:if test="${userObj!=null && (userObj.designationId!=null && userObj.designationId>0)}">

									
										<input name="miTankInspectList[0].designationId"
											value="${userObj.designationId}" id="designationId2"
											type="hidden" />
									
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0)}">
								

									
										<input name="miTankInspectList[0].designationId" value="0"
											id="designationId2" type="hidden" />
									
								</c:if>
								<input name="miTankInspectList[0].tabId" value="2"
									id="tabId2" type="hidden" />
								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
										<input name="miTankInspectList[0].levelId" value="0"
											id="levelId2" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==4 ) }">
										<input name="miTankInspectList[0].levelId" value="1"
											id="levelId2" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==5 || userObj.designationId==6 ) }">
										<input name="miTankInspectList[0].levelId" value="2"
											id="levelId2" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==7  ) }">
										<input name="miTankInspectList[0].levelId" value="3"
											id="levelId2" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==9 || userObj.designationId==10 ) }">
										<input name="miTankInspectList[0].levelId" value="4"
											id="levelId2" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && userObj.designationId==null}">
									<input name="levelId" value="-1"
										id="levelId2" type="hidden" />
								</c:if>
								
								<input  value="0"
										id="slsluiceId" type="hidden" />
								<c:forEach items="${micompsparent}" var="m" varStatus="mcount">

									<br></br>
									<c:if test="${m.miCompId==5 }">
										<div class="row invDiv col-md-12">
											<div class="col-md-2">
												<label class="label-control rowlebel "> Select
													Sluice:<font color=red>*</font>
												</label>
											</div>
											<div class="col-md-6">
												<select class="form-control " id="sluiceId"
													name="miTankInspectList[0].tankWeirSluiceId" required onchange="getmiinspectmst2bysluicewier(this.value,2)">
												


												</select>
											</div>
											<div class="col-md-2">
												<label class="label-control rowlebel ">
													<button type="button" name="addsluice" id="addsluice"
														class="btn btn-1 btn-primary center-block">Add
														Sluice</button>
												</label>
											</div>
											
											<div class="col-md-2">
												<label class="label-control rowlebel ">
													<button type="button" name="editsluice" id="editsluice"
														class="btn btn-1 btn-primary center-block">Edit
														Sluice</button>
												</label>
											</div>


										</div>
									</c:if>




									<c:if test="${m.miparentId==0 && m.hasChild==false}">

										<c:if test="${michecks2!=null}">
											<c:forEach items="${michecks2}" var="k" varStatus="kcount">
												<c:if test="${m.miCompId==k.miCompId}">
													<div class="row">
														<br></br>

														<div class="col-md-1">
															${kcount.count} <input
																name="miTankInspectList[${kcount.count}].micheckboxId"
																class="schedulecuscheck2 mycustomcheck" value="0"
																id="micheckboxIdslu${kcount.count}" type="checkbox" />
														</div>

														<div class="col-md-2 invDiv">

															<label class="label-control rowlebel " for="parameter1">
																${k.miCheck}</label> <input
																name="miTankInspectList[${kcount.count}].miInspectMapId"
																value="${k.miInspectMapId}"
																id="miInspectMapIdslu${kcount.count}" type="hidden" />
															<input
																name="miTankInspectList[${kcount.count}].miInspectTypeId"
																value="${k.miInspectTypeId}"
																id="miInspectTypeIdslu${kcount.count}" type="hidden" />
															<input name="miTankInspectList[${kcount.count}].miCompId"
																value="${k.miCompId}" id="miCompIdslu${kcount.count}"
																type="hidden" />

														</div>

														<div id="slupdateslu${kcount.count }" class="col-md-2 slupdate">
															<label class="label-control rowlebel ">
															Inspect Date: <font color=red>*</font>
															</label> <input type="text"
																class="datepick form-control datepicker sludate"
																id="inspectDateslu${kcount.count }"
																name="miTankInspectList[${kcount.count}].inspectDate" readonly="readonly" />
														</div>

														<div id="sluactreqslu${kcount.count}"  class="col-md-2 sluactreq">
															<label class="label-control rowlebel ">Action
																Required :<font color=red>*</font>
															</label> <label class="radio-inline"> <input type="radio"
																class="myradio n sluradion"
																name="miTankInspectList[${kcount.count}].actionreq"
																id="actionreqslun${kcount.count}" value="false">NO
															</label> <label class="radio-inline"> <input type="radio"
																class="myradio y sluradioy"
																name="miTankInspectList[${kcount.count}].actionreq"
																id="actionreqsluy${kcount.count}" value="true">Yes
															</label>


														</div>


														<div class="col-md-2 myactionreq slureq"
															id="myactionreqidslu${kcount.count }">
															<label class="label-control rowlebel ">Action
																Required Type:<font color=red>*</font>
															</label> <select class="form-control sllist" 
																id="actionrequireqIdslu${kcount.count}"
																name="miTankInspectList[${kcount.count}].actionrequireqId">
																<option value="0">--select--</option>
																<option value="1">Observation</option>
																<option value="2">Emergency</option>
																<option value="3">Maintenance</option>
																<option value="4">Original Work</option>



															</select>
														</div>

														<div id="sluopslu${kcount.count}" class="col-md-2 sluop ">

                                                      <label class="label-control rowlebel ">Observations:
															</label>
															<textarea class="form-control myrem sluobs"
																id="remarksslu${kcount.count}"
																name="miTankInspectList[${kcount.count}].remarks"
																rows="3" cols="50" placeholder="Observations"></textarea>
														</div>
														<div class="col-md-1">
														<input
																	name="miTankInspectList[${kcount.count}].miInpsectMst2Id"
																	value="0"
																	id="miInpsectMst2Idslu${kcount.count}" type="hidden" /> 
														 <c:if test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==4 || userObj.designationId==5) }">
														 <label></label>
															<button type="button" name="editslu" id="editslu${kcount.count}"
																class="btn btn-1 btn-primary center-block editslu" onclick="openmicheckform(miInpsectMst2Idslu${kcount.count}.value,tabId2.value,miyear2.value,${kcount.count},miInpsectMst1Id2.value)">Edit</button>
																</c:if>
																&emsp;&emsp;&emsp;&emsp;
																 <c:if test="${userObj.designationId>0 && ( userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==4 || userObj.designationId==5) }">
																 	 <label></label>
															<button type="button" name="deleteslu" id="deleteslu${kcount.count}"
																class="btn btn-1 btn-primary center-block deleteslu" onclick="deleteembMst2(miInpsectMst2Idslu${kcount.count}.value,tabId2.value,miyear2.value,${kcount.count})">Delete</button>
																</c:if>
														</div>
													</div>
												</c:if>
											</c:forEach>
										</c:if>
									</c:if>


									<br />

								</c:forEach>
								
											<c:if test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
                            <div   style="text-align: center;" >
                            
                            <textarea class="form-control"
																	id="tab2sluRemarks"
																	name="miTankInspectList[0].sluRemarks"
																	rows="3" cols="50" placeholder="Observations"></textarea>
											
											</div>
												</c:if>
								<button type="button" name="addmichecks2" id="addmichecks2"
									class="btn btn-1 btn-primary center-block micheckbutton">Submit</button>


							</form:form>
							
							
							<div class="row">
<c:if test="${userObj.designationId>0 && (userObj.designationId==4 || userObj.designationId==5 || userObj.designationId==6 || userObj.designationId==7 || userObj.designationId==9 || userObj.designationId==10) }">
                              <div class="col-md-6" id="slurev" style="text-align: center;">
												<label class="label-control rowlebel ">
													<button type="button" name="sluRemarks" id="sluRemarks"
														class="btn btn-1 btn-primary center-block">Add
														Remarks</button>
												</label>
											</div>
											</c:if>
											
											<div class="col-md-6"  style="text-align: center;">
												<label class="label-control rowlebel ">
												<input value="0"  id="slumst1Id" type="hidden" /> 
													<button type="button" name="viewsluRemarks" id="viewsluRemarks"
														class="btn btn-1 btn-primary center-block" onclick="viewmst1Remarks(slumst1Id.value,2)">View
														Remarks</button>
												</label>
											</div>
											</div>

						</div>
						<div id="weir">

							<form:form id="michecks3" name="michecks3"
								modelAttribute="micheckList" method="post" class="mitankform"
								data-parsley-validate-if-empty="">

								<input name="miTankInspectList[0].newDistrictId" value=""
									id="midistrictId3" type="hidden" />
								<input name="miTankInspectList[0].mandalId" value=""
									id="mimandalId3" type="hidden" />
								<input name="miTankInspectList[0].villageId" value=""
									id="mivillageId3" type="hidden" />
								<input name="miTankInspectList[0].tankId" value=""
									id="mitankId3" type="hidden" />
								<input name="miTankInspectList[0].miTankFreqId" value=""
									id="mimiTankFreqId3" type="hidden" />
									<input name="miTankInspectList[0].miInpsectMst1Id" value=""
									id="miInpsectMst1Id3" type="hidden" />
								<input name="miTankInspectList[0].year" value="" id="miyear3"
									type="hidden" />
								<input name="miTankInspectList[0].nextPostId" value="" id="nextPostId3" type="hidden" />
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="miTankInspectList[0].postId" value="${userObj.post}" id="postId3"
									type="hidden" />
									</c:if>
									<input name="miTankInspectList[0].nextEmpId" value="" id="nextEmpId3" type="hidden" />
										<input name="miTankInspectList[0].tankStatusId" value="0" id="tankStatusId3"
									type="hidden" />
									<c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" id="userempId3" type="hidden" />
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId!=null}">

									<c:if test="${userObj.unitId>0}">
										<input name="miTankInspectList[0].unitId"
											value="${userObj.unitId}" id="miunitId3" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId==null}">
									<c:if test="${userObj.unitId==0}">
										<input name="miTankInspectList[0].unitId" value="0"
											id="miunitId3" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.circleId!=null}">
									<c:if test="${userObj.circleId>0}">
										<input name="miTankInspectList[0].circleId"
											value="${userObj.circleId}" id="micircleId3" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && ( userObj.circleId==null || userObj.circleId==0)}">
									
										<input name="miTankInspectList[0].circleId" value="0"
											id="micircleId3" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.divisionId!=null && userObj.divisionId>0}">
									
										<input name="miTankInspectList[0].divisionId"
											value="${userObj.divisionId}" id="midivisionId3"
											type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.divisionId==null || userObj.divisionId==0}">
									
										<input name="miTankInspectList[0].divisionId" value="0"
											id="midivisionId3" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.subdivisionId!=null && userObj.subdivisionId>0}">
									
										<input name="miTankInspectList[0].subdivisionId"
											value="${userObj.subdivisionId}" id="misubdivisionId3"
											type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.subdivisionId==null || userObj.subdivisionId==0}">
									
										<input name="miTankInspectList[0].subdivisionId" value="0"
											id="misubdivisionId3" type="hidden" />
									
								</c:if>
								
								<c:if test="${userObj!=null && userObj.sectionId!=null }">
									<c:if test="${userObj.sectionId>0}">
										<input name="miTankInspectList[0].sectionId"
											value="${userObj.sectionId}" id="misectionId3"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.sectionId==null || userObj.sectionId==0 )}">
									<c:if test="${userObj.sectionId==0}">
										<input name="miTankInspectList[0].sectionId" value="0"
											id="misectionId3" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && userObj.projectId!=null && userObj.projectId>0}">
									
										<input name="miTankInspectList[0].projectId"
											value="${userObj.projectId}" id="projectId3" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.projectId==null || userObj.projectId==0}">
									
										<input name="miTankInspectList[0].projectId" value="0"
											id="projectId3" type="hidden" />
									
								</c:if>
								<input name="miTankInspectList[0].constId" value="0"
									id="constId3" type="hidden" />


								<c:if test="${userObj!=null && userObj.designationId!=null && userObj.designationId>0}">

									
										<input name="miTankInspectList[0].designationId"
											value="${userObj.designationId}" id="designationId3"
											type="hidden" />
									
								</c:if>

								<c:if test="${userObj!=null && userObj.designationId==null || userObj.designationId==0}">

									
										<input name="miTankInspectList[0].designationId" value="0"
											id="designationId3" type="hidden" />
									
								</c:if>
								<input name="miTankInspectList[0].tabId" value="3"
									id="tabId3" type="hidden" />
								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
										<input name="miTankInspectList[0].levelId" value="0"
											id="levelId3" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==4 ) }">
										<input name="miTankInspectList[0].levelId" value="1"
											id="levelId3" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==5 || userObj.designationId==6 ) }">
										<input name="miTankInspectList[0].levelId" value="2"
											id="levelId3" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==7  ) }">
										<input name="miTankInspectList[0].levelId" value="3"
											id="levelId3" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==9 || userObj.designationId==10 ) }">
										<input name="miTankInspectList[0].levelId" value="4"
											id="levelId3" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0 )}">
									<input name="miTankInspectList[0].levelId" value="-1"
										id="levelId3" type="hidden" />
								</c:if>
								
								<input  value="0"
										id="wiweirId" type="hidden" />


								<c:forEach items="${micompsparent}" var="m" varStatus="mcount">



									<c:if test="${m.miCompId==6 }">
										<div class="row invDiv col-md-12">
											<div class="col-md-2">
												<label class="label-control rowlebel "> Select
													Wier:<font color=red>*</font>
												</label>
											</div>
											<div class="col-md-6">
												<select class="form-control" id="weirId"
													name="miTankInspectList[0].tankWeirSluiceId" required onchange="getmiinspectmst2bysluicewier(this.value,3)">
													
                                                     

												</select>
											</div>
											<div class="col-md-2">
												<label class="label-control rowlebel ">
													<button type="button" name="addweir" id="addweir"
														class="btn btn-1 btn-primary center-block">Add
														Weir</button>
												</label>
											</div>
											<div class="col-md-2">
												<label class="label-control rowlebel ">
													<button type="button" name="editweirname" id="editweirname"
														class="btn btn-1 btn-primary center-block">Edit
														Weir</button>
												</label>
											</div>


										</div>
									</c:if>
									<c:forEach items="${micompschild}" var="n" varStatus="ncount">


										<c:if
											test="${m.miCompId==n.miparentId && m.hasChild==true  && m.miCompId==6}">
											<%-- <div class="col-md-12" style="color: maroon;">
												<h4>
													<b><c:out value="${n.miCompName}"></c:out></b>
												</h4>
											</div> --%>
											&emsp;&emsp;

											<c:if test="${michecks3!=null}">
												<c:forEach items="${michecks3}" var="k" varStatus="kcount">
													<c:if test="${n.miCompId==k.miCompId}">


														<div class="row">
															<br></br>
															<div class="col-md-1">
																${kcount.count} <input
																	name="miTankInspectList[${kcount.count}].micheckboxId"
																	class="schedulecuscheck3 mycustomcheck" value="0"
																	id="micheckboxIdweir${kcount.count}" type="checkbox" />
															</div>

															<div class="col-md-2 invDiv">

																<label class="label-control rowlebel " for="parameter1">
																	${k.miCheck}</label> <input
																	name="miTankInspectList[${kcount.count}].miInspectMapId"
																	value="${k.miInspectMapId}"
																	id="miInspectMapIdweir${kcount.count}" type="hidden" />
																<input
																	name="miTankInspectList[${kcount.count}].miInspectTypeId"
																	value="${k.miInspectTypeId}"
																	id="miInspectTypeIdweir${kcount.count}" type="hidden" />

																<input
																	name="miTankInspectList[${kcount.count}].miCompId"
																	value="${k.miCompId}" id="miCompIdweir${kcount.count}"
																	type="hidden" />

															</div>


															<div id="weirpagedateweir${kcount.count}" class="col-md-2 weirpagedate">
																<label class="label-control rowlebel ">Inspect Date: <font color=red>*</font>
																</label> <input type="text"
																	class=" datepick form-control datepicker weirdate"
																	id="inspectDateweir${kcount.count}"
																	name="miTankInspectList[${kcount.count}].inspectDate"
																	placeholder="dateofoperation"  readonly="readonly"/>
															</div>

															<div id="weiractreqweir${kcount.count}" class="col-md-2 weiractreq">
																<label class="label-control rowlebel ">Action
																	Required :<font color=red>*</font>
																</label> <label class="radio-inline"> <input
																	type="radio" class="myradio n weirradion"
																	name="miTankInspectList[${kcount.count}].actionreq"
																	id="actionreqweirsn${kcount.count}" value="false">NO
																</label> <label class="radio-inline"> <input
																	type="radio" class="myradio y weirradioy"
																	name="miTankInspectList[${kcount.count}].actionreq"
																	id="actionreqweirsy${kcount.count}" value="true">Yes
																</label>


															</div>


															<div class="col-md-2 myactionreq weirreq"
																id="myactionreqidweir${kcount.count }">
																<label class="label-control rowlebel ">Action
																	Required Type:<font color=red>*</font>
																</label> <select class="form-control wrlist" 
																	id="actionrequireqIdweir${kcount.count}"
																	name="miTankInspectList[${kcount.count}].actionrequireqId">
																	<option value="0">--select--</option>
																	<option value="1">Observation</option>
																	<option value="2">Emergency</option>
																	<option value="3">Maintenance</option>
																	<option value="4">Original Work</option>



																</select>
															</div>

															<div id="weirpageobsweir${kcount.count}" class="col-md-2 weirpageobs">

                                                               <label class="label-control rowlebel ">Observations:
																</label>
																<textarea class="form-control myrem  weirobs"
																	id="remarksweir${kcount.count}"
																	name="miTankInspectList[${kcount.count}].remarks"
																	rows="3" cols="50" placeholder="Observations"></textarea>
															</div>
															<div class="col-md-1">
															
															<input
																	name="miTankInspectList[${kcount.count}].miInpsectMst2Id"
																	value="0"
																	id="miInpsectMst2Idweir${kcount.count}" type="hidden" /> 
															
															 <c:if test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==4 || userObj.designationId==5) }">
															 	 <label></label>
																<button type="button" name="editweir" id="editweir${kcount.count}"
																	class="btn btn-1 btn-primary center-block editweir" onclick="openmicheckform(miInpsectMst2Idweir${kcount.count}.value,tabId3.value,miyear3.value,${kcount.count},miInpsectMst1Id3.value)">Edit</button>
																	</c:if>
																	
																	&emsp;&emsp;&emsp;&emsp;
																	 <c:if test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==4 || userObj.designationId==5 ) }">
																	 	 <label></label>
																<button type="button" name="deleteweir" id="deleteweir${kcount.count}"
																	class="btn btn-1 btn-primary center-block deleteweir" onclick="deleteembMst2(miInpsectMst2Idweir${kcount.count}.value,tabId3.value,miyear3.value,${kcount.count})">Delete</button>
																	</c:if>
															</div>
														</div>

													</c:if>
												</c:forEach>
											</c:if>
										</c:if>

									</c:forEach>





									<br />

								</c:forEach>
								
								<c:if test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
                            <div   style="text-align: center;">
                            
                            <textarea class="form-control"
																	id="tab3weirRemarks"
																	name="miTankInspectList[0].weirRemarks"
																	rows="3" cols="50" placeholder="Observations"></textarea>
											
											</div>
												</c:if>
								<button type="button" name="addmichecks3" id="addmichecks3"
									class="btn btn-1 btn-primary center-block micheckbutton">Submit</button>


							</form:form>
						<div class="row">
<c:if test="${userObj.designationId>0 && (userObj.designationId==4 || userObj.designationId==5 || userObj.designationId==6 || userObj.designationId==7 || userObj.designationId==9 || userObj.designationId==10) }">
                            <div  class="col-md-6"  style="text-align: center;" id="weirrev">
												<label class="label-control rowlebel ">
													<button type="button" name="addweirRemarks" id="addweirRemarks"
														class="btn btn-1 btn-primary center-block">Add
														Remarks</button>
												</label>
											</div>
											</c:if>
											
											<div class="col-md-6"  style="text-align: center;">
												<label class="label-control rowlebel ">
												<input value="0"  id="weirmst1Id" type="hidden" /> 
													<button type="button" name="viewweirRemarks" id="viewweirRemarks"
														class="btn btn-1 btn-primary center-block" onclick="viewmst1Remarks(weirmst1Id.value,3)">View
														Remarks</button>
												</label>
											</div>
											</div>

						</div>


						

						<%-- <div id="repair">

							<form:form id="michecks5" name="michecks5"
								modelAttribute="micheckList" method="post" class="mitankform"
								data-parsley-validate-if-empty="">

								<input name="miTankInspectList[0].newDistrictId" value=""
									id="midistrictId5" type="hidden" />
								<input name="miTankInspectList[0].mandalId" value=""
									id="mimandalId5" type="hidden" />
								<input name="miTankInspectList[0].villageId" value=""
									id="mivillageId5" type="hidden" />
								<input name="miTankInspectList[0].tankId" value=""
									id="mitankId5" type="hidden" />
								<input name="miTankInspectList[0].miTankFreqId" value=""
									id="mimiTankFreqId5" type="hidden" />
								<input name="miTankInspectList[0].year" value="" id="miyear5"
									type="hidden" />
									<input name="miTankInspectList[0].nextEmpId" value="" id="nextEmpId5" type="hidden" />
									<input name="miTankInspectList[0].nextPostId" value="" id="nextPostId5" type="hidden" />
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="miTankInspectList[0].postId" value="${userObj.post}" id="postId5"
									type="hidden" />
									</c:if>
										<input name="miTankInspectList[0].tankStatusId" value="0" id="tankStatusId5"
									type="hidden" />
									
									<c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" id="userempId5" type="hidden" />
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId!=null}">

									<c:if test="${userObj.unitId>0}">
										<input name="miTankInspectList[0].unitId"
											value="${userObj.unitId}" id="miunitId5" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.unitId==null || userObj.unitId==0)}">
								
										<input name="miTankInspectList[0].unitId" value="0"
											id="miunitId5" type="hidden" />
									
								</c:if>
								<c:if test="${ userObj!=null && userObj.circleId!= null }">
								
									<c:if test="${ userObj.circleId >0}">
										<input name="miTankInspectList[0].circleId"
											value="${userObj.circleId}" id="micircleId5" type="hidden" />
											</c:if>
									
								</c:if>
								<c:if test="${userObj!=null && (userObj.circleId==null || userObj.circleId==0)}">
									
										<input name="miTankInspectList[0].circleId" value="0"
											id="micircleId5" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.divisionId!=null}">
									<c:if test="${userObj.divisionId>0}">
										<input name="miTankInspectList[0].divisionId"
											value="${userObj.divisionId}" id="midivisionId5"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.divisionId==null || userObj.divisionId==0)}">
									
										<input name="miTankInspectList[0].divisionId" value="0"
											id="midivisionId5" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.subdivisionId!=null}">
									<c:if test="${userObj.subdivisionId>0}">
										<input name="miTankInspectList[0].subdivisionId"
											value="${userObj.subdivisionId}" id="misubdivisionId5"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.subdivisionId==null || userObj.subdivisionId==0)}">
								
										<input name="miTankInspectList[0].subdivisionId" value="0"
											id="misubdivisionId5" type="hidden" />
									
								</c:if>
								
								<c:if test="${userObj!=null && userObj.sectionId!=null }">
									<c:if test="${userObj.sectionId>0}">
										<input name="miTankInspectList[0].sectionId"
											value="${userObj.sectionId}" id="misectionId5"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.sectionId==null || userObj.sectionId==0 )}">
									<c:if test="${userObj.sectionId==0}">
										<input name="miTankInspectList[0].sectionId" value="0"
											id="misectionId5" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && userObj.projectId!=null}">
									<c:if test="${userObj.projectId>0}">
										<input name="miTankInspectList[0].projectId"
											value="${userObj.projectId}" id="projectId5" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.projectId==null || userObj.projectId==0)}">
									
										<input name="miTankInspectList[0].projectId" value="0"
											id="projectId5" type="hidden" />
									
								</c:if>
								<input name="miTankInspectList[0].constId" value="0"
									id="constId5" type="hidden" />


								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if test="${userObj.designationId>0}">
										<input name="miTankInspectList[0].designationId"
											value="${userObj.designationId}" id="designationId5"
											type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0)}">

									
										<input name="miTankInspectList[0].designationId" value="0"
											id="designationId5" type="hidden" />
									
								</c:if>

								<input name="miTankInspectList[0].tabId" value="5"
									id="tabId5" type="hidden" />

								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
										<input name="miTankInspectList[0].levelId" value="0"
											id="levelId5" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==4 ) }">
										<input name="miTankInspectList[0].levelId" value="1"
											id="levelId5" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==5 || userObj.designationId==6 ) }">
										<input name="miTankInspectList[0].levelId" value="2"
											id="levelId5" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==7  ) }">
										<input name="miTankInspectList[0].levelId" value="3"
											id="levelId5" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==9 || userObj.designationId==10 ) }">
										<input name="miTankInspectList[0].levelId" value="4"
											id="levelId5" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0) }">
									<input name="miTankInspectList[0].levelId" value="-1"
										id="levelId5" type="hidden" />
								</c:if>




<c:if test="${userObj!=null && ( userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==0)}">


	<div class="invDiv col-md-12">
											<div class="col-md-2">
												<label class="label-control rowlebel "> Select Description of Repair
													:<font color=red>*</font>
												</label>
											</div>
											<div class="col-md-8">
												<select class="form-control" id="repairdescId"
													name="miTankInspectList[0].repairdescId" required onchange="getdescdata(this.value)">
												


												</select>
											</div>
										
											
											<div class="col-md-2">
												<label class="label-control rowlebel ">
													<button type="button" name="addrepair" id="addRepairdesc"
														class="btn btn-1 btn-primary center-block">Add
														Repair</button>
												
													<button type="button" name="addrepair" id="editRepairdesc"
														class="btn btn-1 btn-primary center-block">Edit
														Repair</button>
												
													<button type="button" name="addrepair" id="deleteRepairdesc"
														class="btn btn-1 btn-primary center-block">
														Delete Repair</button>
												</label>
												
												</div>
											


										</div>

								<div class="row ">
									<div class="col-md-1">
										<input name="miTankInspectList[0].micheckboxId"
											class="schedulecuscheck5 mycustomcheck" value="0"
											id="inflowcheckId" type="checkbox" />


									</div>

									<div class="col-md-3">

										<label class="label-control rowlebel " for="repairCompId">Select
											Component</label> <select class="form-control" id="repairCompId"
											name="miTankInspectList[0].miCompId" required>
											<option value=" ">--select--</option>
											<option value="1">Earth Bund</option>
											<option value="5">Sluice</option>
											<option value="6">Weir</option>
											<option value="8">Irrigation Channel</option>
											<option value="9">Feeder Channel</option>



										</select>
									</div>



									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Rate</label>
										<input name="miTankInspectList[0].rate" value=""
											class=" form-control " id="rate" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur" 
											data-parsley-error-message="You must enter rate ex:925.25"
											 required />
									</div>



									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Quantity</label>
										<input name="miTankInspectList[0].quantity" value="0"
											class=" form-control " id="quantity" type="text" required
											data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur" 
											data-parsley-error-message="You must enter quantity ex:925.00" />
									</div>

									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Amount</label>
										<input name="miTankInspectList[0].amount" value="" readonly="readonly"
											class=" form-control " id="amount" type="text" />
									</div>


									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Units</label>
										<select class="form-control" id="unitMeasureId"
											name="miTankInspectList[0].unitMeasureId" required>
											<option value=" ">--select--</option>
											<option value="1">No.</option>
											<option value="2">square meter</option>
											<option value="3">cubic meter</option>
											<option value="4">meter</option>



										</select>
									</div>


								</div>
								<br></br>
								<div class="row">

								<!-- <div class="col-md-1"></div>

									<div class="col-md-2">
										<label class="label-control rowlebel ">Select Date:
											<font color=red>*</font>
										</label> <input type="text" class=" datepick form-control datepicker"
											id="inspectDaterepairs"
											name="miTankInspectList[0].inspectDate"
											placeholder="dateofoperation" readonly="readonly" />
									</div>

                                   
									<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1">Scheme
											( repair taken)</label> <input
											name="miTankInspectList[0].schemeTaken" value=""
											class=" form-control " id="schemeTaken" type="text" />
									</div>

									<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1">Description
											for repair</label>
										<textarea class="form-control" id="repairDescription"
											name="miTankInspectList[0].repairDescription" rows="3"
											cols="50" placeholder="Observations"></textarea>
									</div>

 -->

									<div class="col-md-12">

										<label class="label-control rowlebel " for="parameter1">remarks</label>
										<textarea class="form-control" id="remarksrepairs"
											name="miTankInspectList[0].remarks" rows="2" cols="50"
											placeholder="Observations"></textarea>
									</div>
								</div>








								<button type="button" name="addmichecks5" id="addmichecks5"
									class="btn btn-1 btn-primary center-block micheckbutton">Submit</button>
                </c:if>

							</form:form>

							<br></br>
							<div id="repairsdata">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="table5">
											<thead id="thead5">

											</thead>


											<tbody id="tbody5">


											</tbody>
										</table>

									</div>

								</div>
							</div>




						</div> --%>

						<div id="capacity">

							<form:form id="michecks6" name="michecks6"
								modelAttribute="micheckList" method="post" class="mitankform"
								data-parsley-validate-if-empty="">

								<input name="miTankInspectList[0].newDistrictId" value=""
									id="midistrictId6" type="hidden" />
								<input name="miTankInspectList[0].mandalId" value=""
									id="mimandalId6" type="hidden" />
								<input name="miTankInspectList[0].villageId" value=""
									id="mivillageId6" type="hidden" />
								<input name="miTankInspectList[0].tankId" value=""
									id="mitankId6" type="hidden" />
								<input name="miTankInspectList[0].miTankFreqId" value=""
									id="mimiTankFreqId6" type="hidden" />
								<input name="miTankInspectList[0].year" value="" id="miyear6"
									type="hidden" />
									
									<input name="miTankInspectList[0].nextEmpId" value="" id="nextEmpId6" type="hidden" />
									<input name="miTankInspectList[0].nextPostId" value="" id="nextPostId6" type="hidden" />
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="miTankInspectList[0].postId" value="${userObj.post}" id="postId6"
									type="hidden" />
									</c:if>
									
										<input name="miTankInspectList[0].tankStatusId" value="0" id="tankStatusId6"
									type="hidden" />
									
									<c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" id="userempId6" type="hidden" />
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId!=null}">

									<c:if test="${userObj.unitId>0}">
										<input name="miTankInspectList[0].unitId"
											value="${userObj.unitId}" id="miunitId6" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.unitId==null || userObj.unitId==0)}">
									
										<input name="miTankInspectList[0].unitId" value="0"
											id="miunitId6" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.circleId!=null}">
									<c:if test="${userObj.circleId>0}">
										<input name="miTankInspectList[0].circleId"
											value="${userObj.circleId}" id="micircleId6" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.circleId==null || userObj.circleId==0)}">
									
										<input name="miTankInspectList[0].circleId" value="0"
											id="micircleId6" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.divisionId!=null}">
									<c:if test="${userObj.divisionId>0}">
										<input name="miTankInspectList[0].divisionId"
											value="${userObj.divisionId}" id="midivisionId6"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.divisionId==null || userObj.divisionId==0)}">
									
										<input name="miTankInspectList[0].divisionId" value="0"
											id="midivisionId6" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.subdivisionId!=null}">
									<c:if test="${userObj.subdivisionId>0}">
										<input name="miTankInspectList[0].subdivisionId"
											value="${userObj.subdivisionId}" id="misubdivisionId6"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.subdivisionId==null || userObj.subdivisionId==0)}">
									
										<input name="miTankInspectList[0].subdivisionId" value="0"
											id="misubdivisionId6" type="hidden" />
									
								</c:if>
								
								<c:if test="${userObj!=null && userObj.sectionId!=null }">
									<c:if test="${userObj.sectionId>0}">
										<input name="miTankInspectList[0].sectionId"
											value="${userObj.sectionId}" id="misectionId6"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.sectionId==null || userObj.sectionId==0 )}">
									<c:if test="${userObj.sectionId==0}">
										<input name="miTankInspectList[0].sectionId" value="0"
											id="misectionId6" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && userObj.projectId!=null}">
									<c:if test="${userObj.projectId>0}">
										<input name="miTankInspectList[0].projectId"
											value="${userObj.projectId}" id="projectId6" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && (userObj.projectId==null || userObj.projectId==0 )}">
								
										<input name="miTankInspectList[0].projectId" value="0"
											id="projectId6" type="hidden" />
									
								</c:if>
								<input name="miTankInspectList[0].constId" value="0"
									id="constId6" type="hidden" />


								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if test="${userObj.designationId>0}">
										<input name="miTankInspectList[0].designationId"
											value="${userObj.designationId}" id="designationId6"
											type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0)}">

								
										<input name="miTankInspectList[0].designationId" value="0"
											id="designationId6" type="hidden" />
									
								</c:if>
								<input name="miTankInspectList[0].tabId" value="6"
									id="tabId6" type="hidden" />
								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
										<input name="miTankInspectList[0].levelId" value="0"
											id="levelId6" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==4 ) }">
										<input name="miTankInspectList[0].levelId" value="1"
											id="levelId6" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==5 || userObj.designationId==6 ) }">
										<input name="miTankInspectList[0].levelId" value="2"
											id="levelId6" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==7  ) }">
										<input name="miTankInspectList[0].levelId" value="3"
											id="levelId6" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==9 || userObj.designationId==10 ) }">
										<input name="miTankInspectList[0].levelId" value="4"
											id="levelId6" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0)}">
									<input name="miTankInspectList[0].levelId" value="-1"
										id="levelId6" type="hidden" />
								</c:if>

<c:if test="${userObj!=null && ( userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==0)}">

 <div class="col-md-12" >
 	<div class="col-md-4"></div>
 	<div class="col-md-2">
 	<label class="label-control rowlebel "> As on Inspect
											Date: <font color=red>*</font>
										</label> </div>
 
 <div class="col-md-2">
										<input type="text" class=" datepick form-control datepicker"
											id="inspectDateinflows"
											name="miTankInspectList[0].inspectDate"
											placeholder="dateofoperation" readonly="readonly" required/>
									</div>
									<div class="col-md-4"></div>
 

		
				</div> 
				
				<br>
				<br>
				<br>

								<div class="row">
									<br></br>




									<div class="col-md-1">
										<input name="miTankInspectList[0].micheckboxId"
											class="schedulecuscheck6 mycustomcheck" value="0"
											id="capacitycheckId" type="checkbox" />
									</div>


									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">
											Present Capacity(TMC)<font
											color=red>*</font></label> <input
											name="miTankInspectList[0].availableCapacity" value=""
											class=" form-control " id="availableCapacity" type="text" data-parsley-pattern="^[0-9]*\.[0-9]{5}$" data-parsley-trigger="blur" 
											data-parsley-error-message="You must enter capacity 5 digits ex:0.00012"
											 required  />

									</div>
									
									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">
											Capacity(%)</label> <input
											name="miTankInspectList[0].percentageCapacity" value="" readonly="readonly"
											class=" form-control " id="percentageCapacity" type="text"  />

									</div>
									
									<!-- <font
											color=red>*</font> -->
									
									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1"> Tank Level(M)
											</label> <input name="miTankInspectList[0].tankLevel" value="0.00"
											class=" form-control " id="tankLevel" type="text" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur" 
											data-parsley-error-message="You must enter tankLevel ex:0.12"  />

									</div>
									
									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1"> Cultivated Ayacut(acres)<font
											color=red>*</font></label>
										<input name="miTankInspectList[0].ayacut" value="0.00"
											class=" form-control " id="ayacut" type="text"   data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur" 
											data-parsley-error-message="You must enter ayacut 2 digits ex:0.12" />

									</div>

									<div class="col-md-3">
										<label class="label-control rowlebel ">Surplus :<font
											color=red>*</font>
										</label> <label class="radio-inline"> <input type="radio"
											class="myradio" name="miTankInspectList[0].surplus"
											id="surplusn" value="false" required>NO
										</label> <label class="radio-inline"> <input type="radio"
											class="myradio" name="miTankInspectList[0].surplus"
											id="surplusy" value="true" required>Yes
										</label>
									</div>


								
								</div>
								&emsp;&emsp;
								
								<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Inflow(Cusecs)
											</label> <input name="miTankInspectList[0].inflow" value="0.00"
											class=" form-control " id="inflow" type="text" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur" 
											data-parsley-error-message="You must enter Inflow ex:0.12"  />

									</div>

									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Outflow(Cusecs)
											</label> <input name="miTankInspectList[0].outfow" value="0.00"
											class=" form-control " id="outfow" type="text"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur" 
											data-parsley-error-message="You must enter Outflow ex:0.34" />

									</div>

									
									
										





									<div class="col-md-5">

                             <label class="label-control rowlebel ">Remarks </label>
										<textarea class="form-control" id="remarksinflows"
											name="miTankInspectList[0].remarks" rows="3" cols="50"
											placeholder="Remarks"></textarea>
									</div>
									</div>



								<br></br>
								<button type="button" name="addmichecks6" id="addmichecks6"
									class="btn btn-1 btn-primary center-block micheckbutton">Submit</button>

</c:if>
							</form:form>
							
							
							&emsp;&emsp;&emsp;&emsp;&emsp;

							<div id="capacitydata">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="table6">
											<thead id="thead6">

											</thead>


											<tbody id="tbody6">

											</tbody>
										</table>
									</div>


								</div>
							</div>




						</div>


					<%-- 	  <div id="feeding">

							<form:form id="michecks7" name="michecks7"
								modelAttribute="micheckList" method="post" class="mitankform"
								data-parsley-validate-if-empty="">

								<input name="miTankInspectList[0].newDistrictId" value=""
									id="midistrictId7" type="hidden" />
								<input name="miTankInspectList[0].mandalId" value=""
									id="mimandalId7" type="hidden" />
								<input name="miTankInspectList[0].villageId" value=""
									id="mivillageId7" type="hidden" />
								<input name="miTankInspectList[0].tankId" value=""
									id="mitankId7" type="hidden" />
								<input name="miTankInspectList[0].miTankFreqId" value=""
									id="mimiTankFreqId7" type="hidden" />
								<input name="miTankInspectList[0].year" value="" id="miyear7"
									type="hidden" />
									<input name="miTankInspectList[0].nextEmpId" value="" id="nextEmpId7" type="hidden" />
							<input name="miTankInspectList[0].nextPostId" value="" id="nextPostId7" type="hidden" />
										<c:if test="${userObj!=null && userObj.post!=null}">
								<input name="miTankInspectList[0].postId" value="${userObj.post}" id="postId7"
									type="hidden" />
									</c:if>
										<input name="miTankInspectList[0].tankStatusId" value="0" id="tankStatusId7"
									type="hidden" />

								<c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" id="userempId7" type="hidden" />
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId!=null}">

									<c:if test="${userObj.unitId>0}">
										<input name="miTankInspectList[0].unitId"
											value="${userObj.unitId}" id="miunitId7" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId==null}">
									<c:if test="${userObj.unitId==0}">
										<input name="miTankInspectList[0].unitId" value="0"
											id="miunitId7" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.circleId!=null}">
									<c:if test="${userObj.circleId>0}">
										<input name="miTankInspectList[0].circleId"
											value="${userObj.circleId}" id="micircleId7" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.circleId==null || userObj.circleId==0  )}">

									<input name="miTankInspectList[0].circleId" value="0"
										id="micircleId7" type="hidden" />

								</c:if>
								<c:if test="${userObj!=null && userObj.divisionId!=null}">
									<c:if test="${userObj.divisionId>0}">
										<input name="miTankInspectList[0].divisionId"
											value="${userObj.divisionId}" id="midivisionId7"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && ( userObj.divisionId==null || userObj.divisionId==0)}">

									<input name="miTankInspectList[0].divisionId" value="0"
										id="midivisionId7" type="hidden" />

								</c:if>
								<c:if test="${userObj!=null && userObj.subdivisionId!=null}">
									<c:if test="${userObj.subdivisionId>0}">
										<input name="miTankInspectList[0].subdivisionId"
											value="${userObj.subdivisionId}" id="misubdivisionId7"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.subdivisionId==null || userObj.subdivisionId==0 )}">

									<input name="miTankInspectList[0].subdivisionId" value="0"
										id="misubdivisionId7" type="hidden" />
								</c:if>

								<c:if test="${userObj!=null && userObj.projectId!=null}">
									<c:if test="${userObj.projectId>0}">
										<input name="miTankInspectList[0].projectId"
											value="${userObj.projectId}" id="projectId7" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.projectId==null || userObj.projectId==0 ) }">

									<input name="miTankInspectList[0].projectId" value="0"
										id="projectId7" type="hidden" />
								</c:if>
								<input name="miTankInspectList[0].constId" value="0"
									id="constId7" type="hidden" />


								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if test="${userObj.designationId>0}">
										<input name="miTankInspectList[0].designationId"
											value="${userObj.designationId}" id="designationId7"
											type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && userObj.designationId==null}">

									<c:if test="${userObj.designationId==0}">
										<input name="miTankInspectList[0].designationId" value="0"
											id="designationId7" type="hidden" />
									</c:if>
								</c:if>
								<input name="miTankInspectList[0].tabId" value="7"
									id="tabId7" type="hidden" />

								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
										<input name="miTankInspectList[0].levelId" value="0"
											id="levelId7" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==4 ) }">
										<input name="miTankInspectList[0].levelId" value="1"
											id="levelId7" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==5 || userObj.designationId==6 ) }">
										<input name="miTankInspectList[0].levelId" value="2"
											id="levelId7" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==7  ) }">
										<input name="miTankInspectList[0].levelId" value="3"
											id="levelId7" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==9 || userObj.designationId==10 ) }">
										<input name="miTankInspectList[0].levelId" value="4"
											id="levelId7" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0)}">
									<input name="miTankInspectList[0].levelId" value="-1"
										id="levelId7" type="hidden" />
								</c:if>


<c:if test="${userObj!=null && ( userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==0)}">
								<div class="row">
									<br></br>




									<div class="col-md-1">
										<input name="miTankInspectList[0].micheckboxId"
											class="schedulecuscheck7 mycustomcheck" value="0"
											id="capacitycheckId" type="checkbox" />
									</div>



									<div class="col-md-2">
										<label class="label-control rowlebel ">Can feed:<font
											color=red>*</font>
										</label> <label class="radio-inline"> <input type="radio"
											class="myradio" name="miTankInspectList[0].canFeed"
											id="canFeedn" value="false">NO
										</label> <label class="radio-inline"> <input type="radio"
											class="myradio" name="miTankInspectList[0].canFeed"
											id="canFeedy" value="true">Yes
										</label>
									</div>


									<div class="col-md-2">
										<label class="label-control rowlebel ">Select Chain
											Link:<font color=red>*</font>
										</label> <select class="form-control" id="chainLinkId"
											name="miTankInspectList[0].chainLinkId">
											<option value="0">--select--</option>
											<option value="1">link1</option>
											<option value="2">link2</option>
											<option value="3">link2</option>


										</select>
									</div>
									<div class="col-md-2">
										<label class="label-control rowlebel ">Select
											Source type:<font color=red>*</font>
										</label> <select class="form-control" id="se"
											name="miTankInspectList[0].sourceTypeId">
											<option value="0">--select--</option>
											<option value="1">Regeneration</option>
											<option value="2">Gravity</option>
											<option value="3">Lift/Pressure main</option>


										</select>
									</div>



									<div class="col-md-2">
										<label class="label-control rowlebel ">Select
											Source Component type:<font color=red>*</font>
										</label> <select class="form-control" id="sourceCompTypeId"
											name="miTankInspectList[0].sourceCompTypeId">
											<option value="0">--select--</option>
											<option value="1">Main canal</option>
											<option value="2">Branch canal</option>
											<option value="3">Distributory</option>
											<option value="4">Minor</option>
											<option value="5">Sub minor</option>
											<option value="6">FC</option>



										</select>
									</div>



									<div class="col-md-3">
										<label class="label-control rowlebel ">Select
											Canal/Pressure Main:<font color=red>*</font>
										</label> <select class="form-control" id="sourceCompId"
											name="miTankInspectList[0].sourceCompId">
											<option value="0">--select--</option>
											<option value="1">DB1</option>
											<option value="2">DB2</option>
											<option value="2">PM1</option>
											<option value="2">PM2</option>


										</select>
									</div>
								</div>

								<div class="row">
									<br></br>
									<div class="col-md-1"></div>
									<div class="col-md-2">
										<label class="label-control rowlebel ">Inspect
											Date: <font color=red>*</font>
										</label> <input type="text" class=" datepick form-control datepicker"
											id="inspectDatefeeding"
											name="miTankInspectList[0].inspectDate"
											placeholder="dateofoperation" readonly="readonly" />
									</div>



									<div class="col-md-2">


										<label class="label-control rowlebel " for="parameter1">O.T
											Location at Km</label> <input
											name="miTankInspectList[0].otLocationKm" value=""
											class=" form-control " id="otLocationKm" type="text" />
									</div>


									<div class="col-md-3">

<label class="label-control rowlebel " for="parameter1">Source Details</label> 
										<textarea class="form-control" id="sourceDetails"
											name="miTankInspectList[0].sourceDetails" rows="3" cols="50"
											placeholder="Source Details"></textarea>
									</div>
								</div>





								<br></br>
								<button type="button" name="addmichecks7" id="addmichecks7"
									class="btn btn-1 btn-primary center-block micheckbutton">Submit</button>
</c:if>

							</form:form>

							<div id="tankfeeddata">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="table7">
											<thead id="thead7">

											</thead>


											<tbody id="tbody7">

											</tbody>
										</table>
									</div>


								</div>
							</div>




						</div>  --%> 
						
						
						<%-- <div id="frm20">

							<form:form id="michecks8" name="michecks8"
								modelAttribute="miTankformDataList" method="post" class="mitankform"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >

								
								<input name="miTankformDataList[0].tankId" value="0"
									id="mitankId8" type="hidden" />
							
						
									
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
								<input name="miTankformDataList[0].tabId" value="8"
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
 
 <div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22;"> Note 1*: In case of Irrigation Source Name of Structure of Damaged portion(whether left side or right side).(use 4 to 11 checkboxes) </strong>
				
				
				

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
											 
											
				 
				
				</div> 
				
				<br>
				 <div class="col-md-12">
				 <div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note *: Please Check on 2) if due to rainfall to enter Rain Guage Station and Date.</strong>
				
				
				
				

			</div>
			</div>
			</div>
				
				
				
				
				 <div class="col-md-12 invDiv flex-parent-element" >

  <div class="flex-child-element col-md-4 ">
   <div class="col-md-12">
  <div class="col-md-2">
																 <input
																	
																	class="frmchk" value=""
																	id="regchkid" type="checkbox" />
															</div>

															<div class="col-md-10 ">

																<label class="label-control rowlebel " for="parameter1">
																	1) Registered Ayacut</label> 
																
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
																	2) If due to rain fall</label> 
																
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
																	3) In case of buldings</label> 
																
															</div>
															</div>
															
															
															<c:if test="${frmsrcList!=null }">
															
																		
															
						<c:forEach  items="${frmsrcList}" var="m" varStatus="count" >
						
		
						
							
															 <div class="col-md-12">
															
															<div class="col-md-2">
																 <input
																   	name="miTankformDataList[${count.count}].frmchkboxId"
																	class="frmchk" value="${m.irrSrcId}"
																	id="anichkid${count.count}" type="checkbox" />
															</div>

															<div class="col-md-10 ">

																<label class="label-control rowlebel " for="parameter1">
																	<c:out value="${count.count+3}"></c:out> ) <c:out value="${m.irrSrcName}"></c:out> </label> 
																
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
<c:if test="${userObj!=null && ( userObj.designationId==2 || userObj.designationId==8 || userObj.designationId==0)}">
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

</c:if>


						</div> <!--  form20end  -->
						
							 --%>

















					</div>
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



<div id="sluice_dialogue">

	<form:form id="sluiceformid" method="post" modelAttribute="sluice"
		name="sluiceform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">


 <input  id="editsntankWeirSluiceIdhide" name="tankWeirSluiceId" type="hidden" />
      <input value="1" id="tankWeirSluiceTypeId" name="tankWeirSluiceTypeId" type="hidden" />
		<input value="0" id="sluicetankId" type="hidden" name="tankId" />


		<div class="col-md-6">
			<label class="label-control rowlebel ">Name Of Sluice</label>
		</div>

		<div class="col-md-6">
			<input type="text" class="form-control" id="sluiceName"
				name="tankWeirSluiceName" placeholder="Ex: sluiceName" required />
		</div>




		<div class="row show-grid">

			<div class="col-md-8">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block" id="addsluiceformbutton"
					value="Add Sluice">
			</div>
			
			<div class="col-md-8">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block" id="editsluiceformbutton"
					value="Edit Sluice">
			</div>


		</div>

	</form:form>

</div>

<div id="weir_dialogue">

	<form:form id="weirformid" method="post" modelAttribute="weir"
		name="weirform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		 <input  id="editwntankWeirSluiceIdhide" name="tankWeirSluiceId" type="hidden" />
		  <input value="2" id="tankWeirSluiceTypeId" name="tankWeirSluiceTypeId" type="hidden" />
		<input value="0" id="weirtankId" type="hidden" name="tankId" />


		<div class="col-md-6">
			<label class="label-control rowlebel ">Name of Weir</label>
		</div>

		<div class="col-md-6">
			<input type="text" class="form-control" id="weirName" name="tankWeirSluiceName"
				placeholder="Ex: weir1" required />
		</div>




		<div class="row show-grid">

			<div class="col-md-8">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block" id="addweirformbutton"
					value="Add Weir">
			</div>
			
			<div class="col-md-8">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block" id="editweirformbutton"
					value="Edit Weir">
			</div>


		</div>

	</form:form>

</div>

<div id="review_dialogue" class="reviewclass">

	<form:form id="reviewformid" method="post" modelAttribute="micheckList"
		name="reviewform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
        <input value="0" id="editmiInpsectMst1IdReviewIdhide" name="miInpsectMst1IdReviewId" type="hidden" />
        <input value="0" id="editremarksmst1tabID" name="tabId" type="hidden" />
         <input value="0" id="editremarksmst1Id" name="miInpsectMst1Id" type="hidden" />
		<input value="0" id="tankfeedtankId" type="hidden" />
		<input value="0" id="tankfeeddetailId" type="hidden" />
		<input value="0" id="tankcapacitytankId" type="hidden" />
		<input value="0" id="tankcapacityId" type="hidden" />
		<input value="0" id="tankrepairtankId" type="hidden" />
		<input value="0" id="tankrepairId" type="hidden" />
		
		<input value="0" id="editmiCapcityReviewIdhide" type="hidden" />
		<input value="0" id="editremarksCapacityIdhide" type="hidden" />
		
		
		
		
	<!-- 	<input value="0" id="tankinoutId" type="hidden" /> -->
	<!-- 	<input value="0" id="tankinouttankId" type="hidden" /> -->
		<div class="col-md-6">
			<label class="label-control rowlebel ">Remarks</label>
		</div>

		<div class="col-md-6">
			<textarea class="form-control" id="tankFeedRemarks"
				name="miTankInspectList[0].remarks" rows="3" cols="50"
				placeholder="Review Details" required></textarea>
		</div>
	

     <!--  feedreview(),repairreview(), -->

		<div class="row show-grid">
			<div class="col-md-8">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block reviewbutton" id="reviewinfoid" onclick="capacityreview(),insertCheckreviewsemb(),insertCheckreviewslu(),insertCheckreviewsweir()"
					value="Add Remarks">
			</div>
			
			<div class="col-md-8">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block editreviewbutton" id="editmst1reviewinfoid"  onclick="updatemst1editedremarks()"  value="Edit Remarks">
			</div>
			
			<!-- onclick="feedreview(),capacityreview(),repairreview(),insertCheckreviewsemb(),insertCheckreviewslu,insertCheckreviewsweir()"
 -->

		</div>

	</form:form>

</div>

<div id="mainform_dialogue">

<form:form id="editformid" name="editformname"
						modelAttribute="micheckList" method="post"
						data-parsley-validate-if-empty="">
						
						<input  value=""
										id="selecteditMandalId" type="hidden" />
										<input  value=""
										id="selecteditVillageId" type="hidden" />
										<input  value=""
										id="selecteditTankId" type="hidden" />
										<input  value=""
										id="selecteditdistrictId" type="hidden" />
										<input  value=""
										id="selecteditconstId" type="hidden" />

						<div class="col-md-12">
							<br /> <br />
							<div class="col-md-6">
								<div class="col-md-6">
									<label class="label-control rowlebel ">Select
										Constituency: <font color=red>*</font>
									</label>
								</div>


								<div class="col-md-6">
									<select class="form-control" id="editconstId" name="constId">

										<option value="">--select--</option>
										<option value="1">const1</option>
										<option value="2">const2</option>
										<option value="3">const3</option>
										<%-- <c:forEach items="${districtList}" var="d">
								<c:choose>
								<c:when test="${d.districtId==selectedDistrictId }">
									<option value="${d.districtId}" selected="selected">${d.districtName}</option>
									</c:when>
									<c:otherwise>
									<option value="${d.districtId}">${d.districtName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>
 --%>

									</select>
								</div>


								<div class="col-md-6">
									<label class="label-control rowlebel ">Select
										District: <font color=red>*</font>
									</label>
								</div>

								<div class="col-md-6">
									<select class="form-control" id="editdistrictId" name="districtId"
										onchange="getMandals(this.value,2)" required>

										<option value="">--select--</option>
										<c:forEach items="${districtList}" var="d">
											<c:choose>
												<c:when test="${d.districtId==selectedDistrictId }">
													<option value="${d.districtId}" selected="selected">${d.districtName}</option>
												</c:when>
												<c:otherwise>
													<option value="${d.districtId}">${d.districtName}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>


									</select>
								</div>

								<div class="col-md-6">
									<label class="label-control rowlebel ">Select
										Mandal: <font color=red>*</font>
									</label>
								</div>

								<div class="col-md-6">
									<select class="form-control" id="editmandalId" name="mandalId"
										onchange="getVillages(this.value,2)" required>



									</select>
								</div>
								<div class="col-md-6">
									<label class="label-control rowlebel ">Select
										Village: <font color=red>*</font>
									</label>
								</div>
								<div class="col-md-6">
									<select class="form-control" id="editvillageId" name="villageId"
										required onchange="getTanks(this.value,2)">


									</select>
								</div>
								<div class="col-md-6">
									<label class="label-control rowlebel ">Select Tank:
										<font color=red>*</font>
									</label>
								</div>
								<div class="col-md-6">
									<select class="form-control" id="edittankId" name="tankId" required
										>
									

									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="row" id="emp">
									<div class="col-md-6">
										<label class="label-control rowlebel ">Select For
											Employee Review: <font color=red>*</font>
										</label>
									</div>

									<div class="col-md-6">
									<input name=nextEmpId value="" 	id="editnextEmpId" type="hidden" />
										<select class="form-control" id="editnextPostId" name="nextPostId" required>
											<option value=" ">--select--</option>

											<c:forEach items="${getempapprove}" var="u">
												<option value="${u.postId}">${u.empName}</option>

											</c:forEach>


										</select>
									</div>
								</div>
								<div class="row" id="gross">
									<div class="col-md-6">
										<label class="label-control rowlebel " for="parameter1">Gross
											Capacity(TMC)</label>
									</div>
									<div class="col-md-6">


										<input name="grossCapacity" value=""
											class=" form-control " id="editgrossCapacity" type="text" />

									</div>
								</div>
								<div class="row" id="geo">
									<div class="col-md-6">
										<label class="label-control rowlebel " for="parameter1">Geo
											Tag Id</label>
									</div>
									<div class="col-md-6">


										<input name="grossCapacity" value=""
											class=" form-control " id="editgrossCapacity" type="text" />

									</div>
								</div>




								<div class="row" id="freqid">
									<div class="col-md-6">
										<label class="label-control rowlebel ">Select
											Frequency: <font color=red>*</font>
										</label>
									</div>
									<div class="col-md-6">
										<select class="form-control" id="editmiTankFreqId"
											name="miTankFreqId" required>
											<option value=" ">--select--</option>
											<option value="9">PRE MONSOON (April,May)</option>
											<option value="10">POST MONSOON (November,December)</option>
											<option value="11">DURING MONSOON(JUNE TO AUGUEST)</option>


										</select>
									</div>
								</div>


								<div class="row" id="yearid">
									<div class="col-md-6">
										<label class="label-control rowlebel ">Select Year:
											<font color=red>*</font>
										</label>
									</div>
									<div class="col-md-6">
										<select class="form-control" id="edityear" name="year"
											 required>
											 
											<!--  onchange="getmst2inspectdata(this.value)" -->
											<option value=" ">--select--</option>
											<option value="2019">2019</option>
											<option value="2020">2020</option>


										</select>
									</div>
								</div>

							</div>



						</div>
						
							<div class="row show-grid">

			<div class="col-md-12">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block" id="EditMainTankInfo" 
					value="Update Tank Info">
			</div>


		</div>

					</form:form>
</div>


<div id="micheck_dialogue">

	<form:form id="editcheckformid" method="post" modelAttribute="editmichecks"
		name="editcheckform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
	
		
		<input name="newDistrictId" value=""
									id="editmidistrictId" type="hidden" />
								<input name="mandalId" value=""
									id="editmimandalId" type="hidden" />
								<input name="villageId" value=""
									id="editmivillageId" type="hidden" />
								<input name="tankId" value=""
									id="editmitankId" type="hidden" />
								<input name="miTankFreqId" value=""
									id="editmimiTankFreqId" type="hidden" />
									<input name="miInpsectMst1Id" value=""
									id="editmiInpsectMst1Id" type="hidden" />
										<input name="miInpsectMst2Id" value=""
									id="editmiInpsectMst2Id" type="hidden" />
								<input name="year" value="" id="editmiyear"
									type="hidden" />
								<input name="empId" value="" id="editempId"
									type="hidden" />
									<input name="tankWeirSluiceId" value="0" id="selectedtankWeirSluiceId"
									type="hidden" />
									
									
									<c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" id="edituserempId" type="hidden" />
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId!=null}">

									<c:if test="${userObj.unitId>0}">
										<input name="unitId"
											value="${userObj.unitId}" id="editmiunitId" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.unitId==null|| userObj.unitId==0)}">
									<c:if test="${userObj.unitId==0}">
										<input name="unitId" value="0"
											id="editmiunitId" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.circleId!=null}">
									<c:if test="${userObj.circleId>0}">
										<input name="circleId"
											value="${userObj.circleId}" id="editmicircleId" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.circleId==null || userObj.circleId==0)}">
									
										<input name="circleId" value="0"
											id="editmicircleId" type="hidden" />
									
								</c:if>
								<c:if test="${userObj!=null && userObj.divisionId!=null}">
									<c:if test="${userObj.divisionId>0}">
										<input name="divisionId"
											value="${userObj.divisionId}" id="editmidivisionId"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.divisionId==null || userObj.divisionId==0 )}">
									<c:if test="${userObj.divisionId==0}">
										<input name="divisionId" value="0"
											id="editmidivisionId" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.subdivisionId!=null }">
									<c:if test="${userObj.subdivisionId>0}">
										<input name="subdivisionId"
											value="${userObj.subdivisionId}" id="editmisubdivisionId"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.subdivisionId==null || userObj.subdivisionId==0 )}">
									<c:if test="${userObj.subdivisionId==0}">
										<input name="subdivisionId" value="0"
											id="editmisubdivisionId" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && userObj.projectId!=null}">
									<c:if test="${userObj.projectId>0}">
										<input name="projectId"
											value="${userObj.projectId}" id="editprojectId" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.projectId==null || userObj.projectId==0 )}">
									
										<input name="projectId" value="0"
											id="editprojectId" type="hidden" />
									
								</c:if>
								<input name="constId" value="0"
									id="editconstId" type="hidden" />


								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if test="${userObj.designationId>0}">
										<input name="designationId"
											value="${userObj.designationId}" id="editdesignationId"
											type="hidden" />
									</c:if>
								</c:if>

								<c:if
									test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0) }">

								
										<input name="designationId" value="0"
											id="editesignationId" type="hidden" />
									
								</c:if>
								<input name="tabId" value=""
									id="edittabId" type="hidden" />

								<input name="tankWeirSluiceId" value="0"
									id="edittankWeirSluiceId" type="hidden" />

								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
										<input name="levelId" value="0"
											id="editlevelId" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==4 ) }">
										<input name="levelId" value="1"
											id="editlevelId" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==5 || userObj.designationId==6 ) }">
										<input name="levelId" value="2"
											id="editlevelId" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==7  ) }">
										<input name="levelId" value="3"
											id="editlevelId" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==9 || userObj.designationId==10 ) }">
										<input name="levelId" value="4"
											id="editlevelId" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && userObj.designationId==null}">
									<input name="levelId" value="-1"
										id="editlevelId" type="hidden" />
								</c:if>

		
	<div class="row">
														&emsp;&emsp;
														
														
															
															<div class="col-md-4 ">

<textarea class="form-control"  id="editmiInspectTypeName" 	name="miInspectTypeName" 	rows="3" cols="50" placeholder="Observations" readonly="readonly"></textarea>
														
																	<input
																	name="miInspectMapId"
																	value=""
																	id="editmiInspectMapId" type="hidden" /> 
																	<input
																	name="miInspectTypeId"
																	value="<%-- ${k.miInspectTypeId} --%>"
																	id="editmiInspectTypeId" type="hidden" />
																	 <input
																	name="miCompId"
																	value="" id="editmiCompId"
																	type="hidden" />

															</div>


															<div class="col-md-2">
																<label class="label-control rowlebel ">Select
																	Date: <font color=red>*</font>
																</label> <input type="text"
																	class=" datepick form-control datepicker"
																	id="editinspectDate"
																	name="inspectDate"
																	placeholder="dateofoperation" value="0" readonly="readonly" required/>
															</div>

															<div class="col-md-2">
																<label class="label-control rowlebel ">Action
																	Required :<font color=red>*</font>
																</label> <label class="radio-inline"> <input
																	type="radio" class="myradio"
																	name="actionreq"
																	id="editactionreqn" value="false" required>NO
																</label> <label class="radio-inline"> <input
																	type="radio" class="myradio"
																	name="actionreq"
																	id="editactionreqy" value="true" required>Yes
																</label>


															</div>


															<div class="col-md-2 editmyactionreq"
																id="editmyactionreqid">
																<label class="label-control rowlebel ">Action
																	Required Type:<font color=red>*</font>
																</label> <select class="form-control"
																	id="editactionrequireqId"
																	name="actionrequireqId">
																	<option value="0">--select--</option>
																	<option value="1">Observation</option>
																	<option value="2">Emergency</option>
																	<option value="3">Maintenance</option>
																	<option value="4">Original Work</option>



																</select>
															</div>

															<div class="col-md-2">


																<textarea class="form-control"
																	id="editremarks"
																	name="remarks"
																	rows="3" cols="50" placeholder="Observations"></textarea>
															</div>

															
														</div>




		<div class="row show-grid">

			<div class="col-md-12">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block" id="micheckinfoid"  
					value="Update Check">
			</div>


		</div>

	</form:form>

</div>




<div id="miinfo_dialogue">

	<form:form id="editinfoformid" method="post" modelAttribute="editinoutflow"
		name="editinfoform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
	
		
		
									<c:if test="${userObj!=null && userObj.empId!=null}">
									<input value="${userObj.empId}" id="infouserempId" type="hidden" />
								</c:if>
								<c:if test="${userObj!=null && userObj.unitId!=null}">

									<c:if test="${userObj.unitId>0}">
										<input name="unitId"
											value="${userObj.unitId}" id="infomiunitId" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.unitId==null|| userObj.unitId==0)}">
									<c:if test="${userObj.unitId==0}">
										<input name="unitId" value="0"
											id="infomiunitId" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.circleId!=null}">
									<c:if test="${userObj.circleId>0}">
										<input name="circleId"
											value="${userObj.circleId}" id="infomicircleId" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.circleId==null || userObj.circleId==0)}">
									<c:if test="${userObj.circleId==0}">
										<input name="circleId" value="0"
											id="infomicircleId" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.divisionId!=null}">
									<c:if test="${userObj.divisionId>0}">
										<input name="divisionId"
											value="${userObj.divisionId}" id="infomidivisionId"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.divisionId==null || userObj.divisionId==0 )}">
									<c:if test="${userObj.divisionId==0}">
										<input name="divisionId" value="0"
											id="infomidivisionId" type="hidden" />
									</c:if>
								</c:if>
								<c:if test="${userObj!=null && userObj.subdivisionId!=null }">
									<c:if test="${userObj.subdivisionId>0}">
										<input name="subdivisionId"
											value="${userObj.subdivisionId}" id="infomisubdivisionId"
											type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.subdivisionId==null || userObj.subdivisionId==0 )}">
									<c:if test="${userObj.subdivisionId==0}">
										<input name="subdivisionId" value="0"
											id="infomisubdivisionId" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && userObj.projectId!=null}">
									<c:if test="${userObj.projectId>0}">
										<input name="projectId"
											value="${userObj.projectId}" id="infoprojectId" type="hidden" />
									</c:if>
								</c:if>
								<c:if
									test="${userObj!=null && (userObj.projectId==null || userObj.projectId==0 )}">
									<c:if test="${userObj.projectId==0 || userObj.projectId==null}">
										<input name="projectId" value="0"
											id="infoprojectId" type="hidden" />
									</c:if>
								</c:if>
							

								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if test="${userObj.designationId>0}">
										<input name="designationId"
											value="${userObj.designationId}" id="infodesignationId"
											type="hidden" />
									</c:if>
								</c:if>

								<c:if
									test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0) }">

									<c:if test="${userObj.designationId==0}">
										<input name="designationId" value="0"
											id="infodesignationId" type="hidden" />
									</c:if>
								</c:if>
								<input name="tabId" value=""
									id="infotabId" type="hidden" />
								

							
								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
										<input name="levelId" value="0"
											id="infolevelId" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==4 ) }">
										<input name="levelId" value="1"
											id="infolevelId" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==5 || userObj.designationId==6 ) }">
										<input name="levelId" value="2"
											id="infolevelId" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==7  ) }">
										<input name="levelId" value="3"
											id="infolevelId" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==9 || userObj.designationId==10 ) }">
										<input name="levelId" value="4"
											id="infolevelId" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && userObj.designationId==null}">
									<input name="levelId" value="-1"
										id="infolevelId" type="hidden" />
								</c:if>
								
									
										<input  value="0" name="tankId"
										id="selectinfoTankId" type="hidden" />
										
										
									
<!--    <div id="inflowdataupdate">
   
						
						<div class="row ">
						
							<input name="mitankInoutFlowId" value="0"
									id="editmitankInoutFlowId" type="hidden" />
									<br></br>

									<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1">Inflow
											Level(M)</label> <input name="inflow" value="0.0"
											class=" form-control " id="infinflow" type="text"  />

									</div>

									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Outflow
											Level(M)</label> <input name="outfow" value="0.0"
											class=" form-control " id="infoutfow" type="text"  />

									</div>

									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Ayacut(acres)</label>
										<input name="ayacut" value="0.0"
											class=" form-control " id="infayacut" type="text"  />

									</div>


									<div class="col-md-2">
										<label class="label-control rowlebel ">Select Date:
											<font color=red>*</font>
										</label> <input type="text" class=" datepick form-control datepicker"
											id="infinspectDateinflow" value="0"
											name="inspectDate"
											placeholder="dateofoperation" readonly="readonly"  />
									</div>






									<div class="col-md-2">


										<textarea class="form-control" id="infremarksinflows"
											name="remarks" rows="3" cols="50"
											placeholder="Observations"></textarea>
									</div>
								</div>
						
						



		<div class="row show-grid">

			<div class="col-md-12">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block" id="miinfooutflowid"  
					value="Update inflow-outflow">
			</div>


		</div>
		</div> -->
		
		<div id="repairdataupdate">
						
						<div class="row ">
									<br></br>
									<input  value="0" name="mitankRepairsId"
										id="selectedrepairId" type="hidden" />
										
										<input  value="0" 
										id="selectededitrepdescId" type="hidden" />
									
<div class="col-md-2">

										<label class="label-control rowlebel " for="repairCompId">Select
											Component</label> <select class="form-control" id="editrepairCompId"
											name="miCompId" >
											<option value=" ">--select--</option>
											<option value="1">Earth Bund</option>
											<option value="5">Sluice</option>
											<option value="6">Weir</option>
											<option value="8">Irrigation Channel</option>
											<option value="9">Feeder Channel</option>



										</select>
									</div>
									

								

									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Rate
											</label> <input name="rate" value="0.0"
											class=" form-control " id="editrate" type="text"  />

									</div>

									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Quantity</label>
										<input name="quantity" value="0.0"
											class=" form-control " id="editquantity" type="text"  />

									</div>
									
									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Amount</label>
										<input name="amount" value="0.0"
											class=" form-control " id="editamount" type="text" readonly="readonly" />

									</div>
									
									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Units</label>
										<select class="form-control" id="editunitMeasureId"
											name="unitMeasureId" >
											<option value=" ">--select--</option>
											<option value="1">No.</option>
											<option value="2">square meter</option>
											<option value="3">cubic meter</option>
											<option value="4">meter</option>



										</select>
									</div>
									
									<div class="col-md-2">

										<label class="label-control rowlebel" >Description</label>
										<select class="form-control" id="editrepairdescId"
											name="repairdescId" >
											


										</select>
									</div>
									</div>
									
									
									
	<!-- 	<div class="row ">								



									<div class="col-md-3">
										<label class="label-control rowlebel ">Select Date:
											<font color=red>*</font>
										</label> <input type="text" class=" datepick form-control datepicker"
											id="editinspectDaterepair"
											name="inspectDateRepair" value="0"
											placeholder="dateofoperation" readonly="readonly" />
									</div>
									
									<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1">Scheme(repair taken)</label>
										<input name="schemeTaken" value=""
											class=" form-control " id="editschemeTaken" type="text" />

									</div>






									<div class="col-md-3">

	<label class="label-control rowlebel " for="parameter1">Repairs Description</label>
										<textarea class="form-control" id="editrepairDescription"
											name="repairDescription" rows="3" cols="50"
											placeholder="Observations"></textarea>
									</div>
									
									 <div class="col-md-3">

	<label class="label-control rowlebel " for="parameter1">Remarks</label>
										<textarea class="form-control" id="editremarksrepair"
											name="repairRemarks" rows="3" cols="50"
											placeholder="Observations"></textarea>
									</div>
								</div>  -->
						
						



		<div class="row show-grid">

			<div class="col-md-12">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block" id="mirepair"  
					value="Update Repairs">
			</div>


		</div>
		</div>
		
		
		
		
		
		<div id="capacitydataupdate">
		
		<div class="col-md-12" >
		
		  <div class="col-md-4"></div>
		
		   <div class="col-md-2">
										<label class="label-control rowlebel ">As on Inspect Date:
											<font color=red>*</font>
										</label>	</div>
							 <div class="col-md-2">			 <input type="text" class=" datepick form-control datepicker"
											id="editinspectDatecapacity"
											name="inspectDateCapacity" value="0"
											placeholder="dateofoperation" readonly="readonly"  /> </div>
											
											  <div class="col-md-4"></div>
								

		
				</div>
				
				<br>
					<br>
						<br>
						
						<div class="row ">
									<br></br>
									<input  value="0" name="mitankCapacityId"
										id="selectedcapacityId" type="hidden" />
									


								

									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Present Capacity(TMC)
											</label> <input name="availableCapacity" value="0.0"
											class=" form-control " id="editavailableCapacity" type="text"  />

									</div>
									
									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Capacity(%)</label>
										<input value="0.0"
											class=" form-control " id="editcapacitypercent" type="text" readonly="readonly"  />

									</div>
									
									<div class="col-md-2">

										<label class="label-control rowlebel " for="parameter1">Tank Level(M)</label>
										<input name="tankLevel" value="0.0"
											class=" form-control " id="inftankLevel" type="text"  />

									</div>
									
									<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1">Cultivated Ayacut(acres)</label>
										<input name="ayacut" value="0.0"
											class=" form-control " id="infayacut" type="text"  />

									</div>

									<div class="col-md-3">
										<label class="label-control rowlebel ">Surplus:<font
											color=red>*</font>
										</label> <label class="radio-inline"> <input type="radio"
											class="myradio" name="surplus"
											id="editsurplusn" value="false" >NO
										</label> <label class="radio-inline"> <input type="radio"
											class="myradio" name="surplus"
											id="editsurplusy" value="true" >Yes
										</label>
									</div>

									
								
									

									





									
									<!-- <div class="col-md-3">

	<label class="label-control rowlebel " for="parameter1">Remarks</label>
										<textarea class="form-control" id="editremarkscapacity"
											name="capacityRemarks" rows="3" cols="50"
											placeholder="Observations"></textarea>
									</div> -->
								</div>
								
								
									<div class="row ">
						
						
									<br></br>

									<div class="col-md-4">

										<label class="label-control rowlebel " for="parameter1">Inflow(cusecs)
											</label> <input name="inflow" value="0.0"
											class=" form-control " id="infinflow" type="text"  />

									</div>

									<div class="col-md-4">

										<label class="label-control rowlebel " for="parameter1">Outflow(cusecs)
											</label> <input name="outfow" value="0.0"
											class=" form-control " id="infoutfow" type="text"  />

									</div>

									

                                 
									
									




									
								</div>
						
						



		<div class="row show-grid">

			<div class="col-md-12">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block" id="micapacity"  
					value="Update Capacity">
			</div>


		</div>
		</div>
		
		
		<div id="feeddataupdate">
						
						<div class="row ">
									<br></br>
									<input  value="0" name="mitankFeedDetailsId"
										id="selectedfeedId" type="hidden" />
									
<div class="col-md-2">
										<label class="label-control rowlebel ">Can feed:<font
											color=red>*</font>
										</label> <label class="radio-inline"> <input type="radio"
											class="myradio" name="canFeed"
											id="editcanFeedn" value="false">NO
										</label> <label class="radio-inline"> <input type="radio"
											class="myradio" name="canFeed"
											id="editcanFeedy" value="true">Yes
										</label>
									</div>

									

								

									
									<div class="col-md-2">
										<label class="label-control rowlebel ">Select Chain
											Link:<font color=red>*</font>
										</label> <select class="form-control" id="editchainLinkId"
											name="chainLinkId">
											<option value="0">--select--</option>
											<option value="1">link1</option>
											<option value="2">link2</option>
											<option value="3">link2</option>


										</select>
									</div>

									<div class="col-md-2">
										<label class="label-control rowlebel ">Select
											Source type:<font color=red>*</font>
										</label> <select class="form-control" id="editsourceTypeId"
											name="sourceTypeId">
											<option value="0">--select--</option>
											<option value="1">Regeneration</option>
											<option value="2">Gravity</option>
											<option value="3">Lift/Pressure main</option>


										</select>
									</div>

									
									<div class="col-md-3">
										<label class="label-control rowlebel ">Select
											Source Component type:<font color=red>*</font>
										</label> <select class="form-control" id="editsourceCompTypeId"
											name="sourceCompTypeId">
											<option value="0">--select--</option>
											<option value="1">Main canal</option>
											<option value="2">Branch canal</option>
											<option value="3">Distributory</option>
											<option value="4">Minor</option>
											<option value="5">Sub minor</option>
											<option value="6">FC</option>



										</select>
									</div>
									
									<div class="col-md-3">
										<label class="label-control rowlebel ">Select
											Canal/Pressure Main:<font color=red>*</font>
										</label> <select class="form-control" id="editsourceCompId"
											name="sourceCompId">
											<option value="0">--select--</option>
											<option value="1">DB1</option>
											<option value="2">DB2</option>
											<option value="2">PM1</option>
											<option value="2">PM2</option>


										</select>
									</div>
								</div>
									
								
									
									&emsp; &emsp;
									
		<div class="row ">								



									
									<div class="col-md-2">
										<label class="label-control rowlebel ">Inspect
											Date: <font color=red>*</font>
										</label> <input type="text" class=" datepick form-control datepicker"
											id="editinspectDatefeeding" value="0"
											name="inspectDateFeed"
											placeholder="dateofoperation" readonly="readonly" />
									</div>

									<div class="col-md-2">


										<label class="label-control rowlebel " for="parameter1">O.T
											Location at Km</label> <input
											name="otLocationKm" value="0.0"
											class=" form-control " id="editotLocationKm" type="text" />
									</div>






									<div class="col-md-8">
                                  <label class="label-control rowlebel " for="parameter1">Source Details</label>

										<textarea class="form-control" id="editsourceDetails"
											name="sourceDetails" rows="3" cols="50"
											placeholder="Source Details"></textarea>
									</div>
								</div>
								
						
						



		<div class="row show-grid">

			<div class="col-md-12">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="button"
					class="btn btn-1 btn-primary center-block" id="mifeed"  
					value="Update Feed Details">
			</div>


		</div>
		</div>
		
		
		

	</form:form>
	
	
	
	

</div>

<div id="viewRemarks_dialogue">

	<form:form id="viewremarksid" method="post" modelAttribute="weir"
		name="weirform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">



<div id="viewmst1data">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="view1">
											<thead id="viewhead1">

											</thead>


											<tbody id="viewbody1">

											</tbody>
										</table>
									</div>


								</div>
							</div>
							

							
	
	
		
		


		

	</form:form>

</div>



<div id="edittankstatus_dialogue">

	<form:form id="editstatusid" method="post" modelAttribute="tankstatus"
		name="editcriticalform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
<input name="miInpsectMst1Id" value="0"
									id="editcriticalMst1Id" type="hidden" />
									
								
   <div class="row" id="editcritical" >
								
									<div class="col-md-6">
																<label class="label-control rowlebel ">Tank Status:<font color=red>*</font>
																</label>
																</div>
																<div class="col-md-6"> <select class="form-control"
																	id="edittankStatusId"
																	name="tankStatusId" required>
																	<option value=" ">--select--</option>
																	<option value="1">Observation</option>
																	<option value="2">Emergency</option>
																	<option value="3">Maintenance</option>
																	<option value="4">Original Work</option>



																</select>
																</div>
																
																
									 <%-- <div class="col-md-6">
																<label class="label-control rowlebel ">Unit:<font color=red>*</font>
																</label>
																</div> 
																<div class="col-md-6"> <select class="form-control"
																	id="editUnitId"
																	name="unitId" onchange="getCircles(this.value,1)">
																<option value=" ">--select--</option>
									<c:forEach items="${unitList}" var="u">
										<option value="${u.unitId}">${u.unitName}</option>

									</c:forEach>	


																</select>
																</div>  --%>
																
																								<!-- <div class="col-md-6">
																<label class="label-control rowlebel ">Circle:<font color=red>*</font>
																</label>
																</div> 
																 <div class="col-md-6"> <select class="form-control"
																	id="editCircleId"
																	name="circleId" onchange="getDivisions(this.value,1)">
																	


																</select>
																</div>  -->
																
																 <!-- <div class="col-md-6">
																<label class="label-control rowlebel ">Division:<font color=red>*</font>
																</label>
																</div> 
															 	<div class="col-md-6"> <select class="form-control"
																	id="editDivisionId"
																	name="divisionId" onchange="getSubDivisions(this.value,1)">
																	


																</select>
																</div>		 -->														
																<!--  <div class="col-md-6">
																<label class="label-control rowlebel ">Sub Division:<font color=red>*</font>
																</label>
																</div> 
																 <div class="col-md-6"> <select class="form-control"
																	id="editSubDivisionId"
																	name="subdivisionId" >
																	


																</select>
																</div>  -->
																	<div class="col-md-4">
																
																<button type="button" name="edittankStatus" id="editcriticalStatus"  style="text-align: center;"
																	class="btn btn-1 btn-primary center-block  " onclick="submitcriticalstatus()">Submit</button>
															</div>
								

							</div>
	
	</form:form>

</div>


<div id="repairdesc_dialogue">

	<form:form id="repairdesc" method="post" modelAttribute="repairdesc"
		name="repairdescform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if test="${userObj.designationId>0}">
										<input name="designationId"
											value="${userObj.designationId}" id="repairdescdesignationId"
											type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0)}">

									
										<input name="designationId" value="0"
											id="repairdescdesignationId" type="hidden" />
									
								</c:if>

								

								<c:if test="${userObj!=null && userObj.designationId!=null}">

									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==2 || userObj.designationId==8) }">
										<input name="levelId" value="0"
											id="repairdesclevelId" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==4 ) }">
										<input name="levelId" value="1"
											id="repairdesclevelId" type="hidden" />
									</c:if>



									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==5 || userObj.designationId==6 ) }">
										<input name="levelId" value="2"
											id="repairdesclevelId" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==7  ) }">
										<input name="levelId" value="3"
											id="repairdesclevelId" type="hidden" />
									</c:if>
									<c:if
										test="${userObj.designationId>0 && (userObj.designationId==9 || userObj.designationId==10 ) }">
										<input name="levelId" value="4"
											id="repairdesclevelId" type="hidden" />
									</c:if>
								</c:if>

								<c:if test="${userObj!=null && (userObj.designationId==null || userObj.designationId==0) }">
									<input name="levelId" value="-1"
										id="repairdesclevelId" type="hidden" />
								</c:if>
		
		
		 
		<input value="0" id="repairdesctankId" type="hidden" name="tankId" />
		
		
		<input value="0" id="updaterepairdescId" type="hidden" name="repairdescId" />


	
						<div class="col-md-12">	
							<div class="col-md-3">
										<label class="label-control rowlebel ">Start Date:
											<font color=red>*</font>
										</label> <input type="text" class=" datepick form-control datepicker"
											id="repairStartDate"
											name="repairStartDate"
											placeholder="dateofoperation" readonly="readonly" required="required" />
									</div>
									
									<div class="col-md-3">
										<label class="label-control rowlebel ">End Date:
											<font color=red>*</font>
										</label> <input type="text" class=" datepick form-control datepicker"
											id="repairEndDate"
											name="repairEndDate"
											placeholder="dateofoperation" readonly="readonly" required="required" />
									</div>
									
									

                                   
									<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1">Scheme
											( repair taken)</label> <input
											name="schemeTaken" value=""
											class=" form-control " id="schemeTaken" type="text"  required="required" />
									</div>

									<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1">Description
											for repair</label>
										<textarea class="form-control" id="repairDescription"
											name="repairDescription" rows="2"
											cols="50" placeholder="Observations" required="required" ></textarea>
									</div>
									
									</div>
									<div class="col-md-12">
									
									<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1"></label>
										<button type="button" name="addRepairmain" id="addRepairmain" class="btn btn-1 btn-primary center-block  " onclick="">Add Repair Description</button>
										</div>
										<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1"></label>
										<button type="button" name="editRepairmain" id="editRepairmain" class="btn btn-1 btn-primary center-block  " onclick="">Edit Repair</button> 
										</div>
										
										<div class="col-md-3">

										<label class="label-control rowlebel " for="parameter1"></label>
										<button type="button" name="deleteRepairmain" id="deleteRepairmain"  class="btn btn-1 btn-primary center-block  " onclick="">Delete Repair</button>
										</div>
									</div>

							
							
							
						

	</form:form>
	
		

</div>



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
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata('${t.tankName}','${t.tankId}','${t.tankCode}','${t.newDistrictId}','${t.mandalId}','${t.villageId}','${t.acCode}','${t.habitationId}','${t.mandalName}','${t.villageName}',1),getcapacitydata('${t.tankId}'),getsluicelist('${t.tankId}'),getweirlist('${t.tankId}'),gettankgeotaglist('${t.tankId}'),getrepairdesclist('${t.tankId}'), getmst2inspectdata(year.value),getfrmsentlist('${t.tankId}')" >Select Tank</button></td>
												
												
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
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata('${t.tankName}','${t.tankId}','${t.tankCode}','${t.newDistrictId}','${t.mandalId}','${t.villageId}','${t.acCode}','${t.habitationId}','${t.mandalName}','${t.villageName}',2),getcapacitydata('${t.tankId}'),getsluicelist('${t.tankId}'),getweirlist('${t.tankId}'),gettankgeotaglist('${t.tankId}'),getrepairdesclist('${t.tankId}'), getmst2inspectdata(year.value),getfrmsentlist('${t.tankId}')" >Select Anicut</button></td>
												
												
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
																	class="btn btn-1 btn-primary center-block"  onclick="showtankdata('${t.tankName}','${t.tankId}','${t.tankCode}','${t.newDistrictId}','${t.mandalId}','${t.villageId}','${t.acCode}','${t.habitationId}','${t.mandalName}','${t.villageName}',3),getcapacitydata('${t.tankId}'),getsluicelist('${t.tankId}'),getweirlist('${t.tankId}'),gettankgeotaglist('${t.tankId}'),getrepairdesclist('${t.tankId}'), getmst2inspectdata(year.value),getfrmsentlist('${t.tankId}')" >Select Check Dam</button></td>
												
												
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


<!-- <div id="frm20_view_dia">

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



 

</div> -->

<%-- <div id="frm20_doc_update">

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
							
							 <div class="col-md-12"  >
								<button type="button" name="addmichecks11" id="addmichecks11" onclick="updatephotosdatafn(this.form.name)"
									class="btn btn-1 btn-primary center-block frmphotobutton">Submit</button>
									</div>
							
							</div> 
	</form:form>							
</div>



 

</div> --%>


<!-- <div id="frm20_doc_dia">

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



 

</div> -->






<div id="faqSpopup" class="ayucutFaq container">
    

   

    <div class="panel-group" id="accordion">
        <div class="faqHeader">General Clarifications</div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><b>Below Logins can be used for Inspection of Tanks</b></a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                     Respective HRMS logins are allowed to enter Inspection of Tanks.
                  
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTen"><b>Bund Inspection</b></a>
                </h4>
            </div>
            <div id="collapseTen" class="panel-collapse collapse in">
                <div class="panel-body">
                   1.Select Tank(Tanks has been taken from Mission Kakatiya Website)<br>
                   2.Observe Next level review (If any discrepancy please rech out to us)<br>
                   3.Atleast one Inspection check of the tank should be submitted.<br>
                   4.Inspection Date is mandatory<br>
                   5.Please select action required.<br>                 
                   6.Edit/Delete Action is available.
                 
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseEleven"><b>Sluice Inspection</b></a>
                </h4>
            </div>
            <div id="collapseEleven" class="panel-collapse collapse in">
                <div class="panel-body">
              
                   1.Select Tank(Tanks has been taken from Mission Kakatiya Website)<br>
                   2.Observe Next level review (If any discrepancy please rech out to us)<br>
                   3.Atleast one Inspection check of the tank should be submitted.<br>
                   4.Inspection Date is mandatory<br>
                   5.Please select action required.<br>                 
                   6.Edit/Delete Action is available<br>
                   7.Sluice is Mandatory so please mention Sluice Name by appending Tank name.
                    
                </div>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse1"><b>Weir Inspection</b></a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse in">
                <div class="panel-body">
                
                    1.Select Tank(Tanks has been taken from Mission Kakatiya Website)<br>
                   2.Observe Next level review (If any discrepancy please reach out to us)<br>
                   3.Atleast one Inspection check of the tank should be submitted.<br>
                   4.Inspection Date is mandatory<br>
                   5.Please select action required.<br>                 
                   6.Edit/Delete Action is available<br>
                   7.Weir is Mandatory so please mention Weir Name by appending Tank name.
                    
                  
                </div>
            </div>
        </div>
        
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse2"><b>Tank Capacity</b></a>
                </h4>
            </div>
            <div id="collapse2" class="panel-collapse collapse in">
                <div class="panel-body">
                
                 1.Capacity Should not exceed Gross Capacity in (TMC) <br>
                   2.Tank level is optional.<br>
                   3.Cultivated Ayacut (Acres)<br>
                   4.Inspecttion date is Mandatory<br>                                  
                   5.Edit and Delete Action are available.              
                  
                
                </div>
            </div>
        </div>
        
        
       
            
        </div>
    </div>
    
    <div id="confirmdia">

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
	
	
	

