

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

<script type="text/javascript" src="../js/moment.min.js"></script>

<script type="text/javascript" src="../js/invom/tank-feed.js"></script>

<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" media="screen" href="../css/bootstrap-datetimepicker.min.css">

<!-- <script crossorigin src="https://unpkg.com/react@16/umd/react.development.js"></script>
    <script crossorigin src="https://unpkg.com/react-dom@16/umd/react-dom.development.js"></script> -->
    <!-- https://babeljs.io/docs/en/next/babel-standalone.html -->
    <!-- <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script> -->


  <!--   <script type="text/babel" src="../js/reactjs/retank-feed.js"></script> -->






<!-- <div class="w3l-main" id="borderStyle"> -->


<div class="col-md-9">



	<div>



		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Tank Feed Details:Tank Feed Details. 
				
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


				<div  class="col-md-12 ">
				
				

					<form:form id="mainformid" name="mainformname"
						modelAttribute="micheckList" method="post"
						data-parsley-validate-if-empty="">

					
						&emsp; &emsp;
						<div class="col-md-12 invDiv">
						
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
						
						
	
						
  </form:form>
  
  <div class="col-md-12 invDiv">
					<div class="col-md-12 invDiv" style="text-align: center; font-weight: bold;">
					
					<div class="col-md-6">Tank Name</div>
					<div class="col-md-6">Action</div>
					
					
					
					</div>
					
					<!-- <div id="react-container"></div> -->
					
					<br></br>
					
					
					<c:if test="${tanksList!=null }">
					<c:forEach items="${tanksList}" var="d" varStatus="count">
					<div class="col-md-12 invDiv">
					<div class="col-md-4" style="text-align: center; font-weight: bold; ">
					<button type="button" name="showtanksname" id="showtanksdata" 
																	class="btn btn-1 btn-primary center-block "  ><c:out value="${count.count}"></c:out> &emsp; &emsp;<c:out value="${d.tankName}"></c:out></button>
					</div>
					<div class="col-md-2">	 
        <label class="label-control rowlebel ">Can Feed <font color=red>*</font> </label>
        <!--   <div class="form-group"> -->
        <label class="radio-inline"> <input class="canf" type="radio" name="canfeed" id="pacincln"  checked="checked"   value="false"  required >NO</label>
        <label class="radio-inline"> <input class="canf" type="radio" name="canfeed" id="pacincly"     value="true"  required >Yes</label>
   
        </div>
					<div class="col-md-6"> 
					<div class="col-md-6">
				<!-- 	<button type="button" name="showtanksname" id="showtanksdata" 
																	class="btn btn-1 btn-primary center-block "  >View Tank Info</button>
					<br>
				
					 -->
					<button type="button" name="showtanksname" id="addtankfeedinf" 
																	class="btn btn-1 btn-primary center-block addtankfeedinfcls "  >Add Tank Feed Info</button>
					</div>
					<div class="col-md-6">
					
					<button type="button" name="showtanksname" id="showtanksdata" 
																	class="btn btn-1 btn-primary center-block "  >Edit Tank Feed Info</button>
					<br>
					<button type="button" name="showtanksname" id="showtanksdata" 
																	class="btn btn-1 btn-primary center-block "  >Delete Tank Feed Info</button>
					
					</div>
					</div>
					</div>
					</c:forEach>
					</c:if>
					
					
					
					
					
					
					
					</div>

					

</div>


						</div>  
						
						
						
						 <!--  form20end  -->
						
							

















				







				

			</div>
			<!-- panel div div -->


		</div>
		<!-- panel div -->



	</div>
	


















































<!-- dialogues -->

<div id="tank-feed-dialogue">
<form:form id="mainformid" name="mainformname"
						modelAttribute="micheckList" method="post"
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




									



							


									<div class="col-md-6">
										<label class="label-control rowlebel ">Select Chain
											Link: Add/Edit<font color=red>*</font>
										</label> <select class="form-control" id="chainLinkId"
											name="miTankInspectList[0].chainLinkId">
											<option value="0">--select--</option>
											<option value="1">link1</option>
											<option value="2">link2</option>
											<option value="3">link2</option>


										</select>
									</div>
									<div class="col-md-6">
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
									
									<div class="col-md-6">
										<label class="label-control rowlebel ">Select
										project:<font color=red>*</font>
										</label> <select class="form-control" id="se"
											name="miTankInspectList[0].sourceTypeId">
											<option value="0">--select--</option>
											<option value="1">proj1</option>
											<option value="2">proj2</option>
											<option value="3">proj3</option>


										</select>
									</div>
									
									<div class="col-md-6">
										<label class="label-control rowlebel ">Select
										package:Add/Edit<font color=red>*</font>
										</label> <select class="form-control" id="se"
											name="miTankInspectList[0].sourceTypeId">
											<option value="0">--select--</option>
											<option value="1">pack1</option>
											<option value="2">pack2</option>
											<option value="3">pack3</option>


										</select>
									</div>
									



									<div class="col-md-6">
										<label class="label-control rowlebel ">Select
											Source Component type:Add/edit<font color=red>*</font>
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



									<div class="col-md-6">
										<label class="label-control rowlebel ">Select
											Canal/Pressure Main:Add/edit<font color=red>*</font>
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

								
									
									


									<div class="col-md-6">


										<label class="label-control rowlebel " for="parameter1">O.T
											Location at Km</label> <input
											name="miTankInspectList[0].otLocationKm" value=""
											class=" form-control " id="otLocationKm" type="text" />
									</div>


									<div class="col-md-6">

<label class="label-control rowlebel " for="parameter1">Source Details</label> 
										<textarea class="form-control" id="sourceDetails"
											name="miTankInspectList[0].sourceDetails" rows="3" cols="50"
											placeholder="Source Details"></textarea>
									</div>
								





								<br></br>
								<button type="button" name="addmichecks7" id="addmichecks7"
									class="btn btn-1 btn-primary center-block micheckbutton">Submit</button>
</c:if>

							</form:form>
							</div>












   

<script type="text/javascript" src="../js/parsley.js"></script>


	
	

