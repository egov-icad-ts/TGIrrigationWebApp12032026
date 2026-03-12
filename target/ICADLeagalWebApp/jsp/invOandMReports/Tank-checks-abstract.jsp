
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>

<title>O&M Tank Checks</title>

<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">


<link rel="stylesheet"
	href="../css/Html5DataTable/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href=" ../css/Html5DataTable/buttons.dataTables.min.css" />
	
	<script type="text/javascript" src="../js/invomReports/michecks_report.js"></script>



<div class="col-md-9">
	<div>

		<div class="panel panel-primary" >
			<div class="panel-heading">
				<h3 class="panel-title">Irrigation Tanks: Irrigation Tanks Abstract</h3>
			</div>
<div class="panel-body">


<%-- <div class="row" >

&emsp; &emsp;
										

						<div class="col-md-2">
						<label class="label-controlPMS rowlebel ">Select Unit: <font
								color=red>*</font>
							</label>
							<select class="form-control" id="unitId" name="unitId"
								required onchange="getProjects(this.value,1);getCircles(this.value,1)" >
									<option value=" ">--select--</option>

							<c:forEach items="${unitList}" var="u">
								<option value="${u.unitId}">${u.unitName}</option>

							</c:forEach>



							</select>
						</div>

						
						<div class="col-md-2">
						<label class="label-controlPMS rowlebel ">Select Circle:
								
							</label>
							<select class="form-control" id="circleId" name="circleId"
								 onchange="getDivisions(this.value,1)">
							

							</select>
						</div>


						
						<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select
								Division: 
							</label>
							<select class="form-control" id="divisionId" name="divisionId"
								 onchange="getSubDivisions(this.value,1)">
								

							</select>
						</div>

					
						<div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Sub
								Division: 
							</label>
							<select class="form-control" id="subdivisionId" name="subdivisionId"
								>
							
							</select>
						</div>


				
					



				</div> --%>



<div class="col-md-12">

	<%-- 	<div class="col-md-2 ">
											<label class="label-control rowlebel ">Select District <font color=red>*</font> </label>
											 <select class="form-control" id="districtId" name="newDistrictId"
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
											</div>
											
										<div class="col-md-2 ">
										<input  value="0"
									id="mcode" type="hidden" />
											<label class="label-control rowlebel ">Select Mandal<font color=red>*</font> </label>
											<select class="form-control" id="mandalId" name="mandalId"
							onchange="getVillages(this.value,1)"  required>
							
						

						</select>
											
											</div>
											
												<div class="col-md-2 ">
												<input  value="0"
									id="vcode" type="hidden" />
											<label class="label-control rowlebel ">Select Village<font color=red>*</font> </label>
											<select class="form-control" id="villageId" name="villageId"
							 required onchange="getHabitations(districtId.value,mcode.value,vcode.value,1)">
							

						</select>
											</div>
											
							
								<div class="col-md-2">
								<label class="label-control rowlebel ">Select
										Habitation: <font color=red>*</font>
									</label>
									<select class="form-control" id="habitationId" name="habitationId"
										required onchange="getTanks(districtId.value,mcode.value,vcode.value,this.value,1)">


									</select>
								</div>
											
												<div class="col-md-2 ">
											<label class="label-control rowlebel ">Select Tank<font color=red>*</font> </label>
											<select class="form-control" id="tankId" name="tankId"
							 required   >
						
						

						</select>
											</div>  gettankabstractdata(tankId.value,this.value,'tanksreport','tanksreport2','tanksreport3')--%>
											
												
												<div class="col-md-6">
												<label class="label-control rowlebel ">Select Frequency</label>
										<select class="form-control" id="miTankFreqId"
											name="miTankFreqId"  required>
											<option value=" ">--select--</option>
											<option value="9">PRE MONSOON (April,May)</option>
											<option value="11">DURING MONSOON(JUNE TO AUGUEST)</option>
											<option value="10">POST MONSOON (November,December)</option>
											


										</select>
									</div>
									<div class="col-md-6 ">
											<label class="label-control rowlebel ">Select Year</label>
											  <select class="form-control" id="year" name="year" required onchange="gettankabstractdata(miTankFreqId.value,this.value,'tanksreport')" > 
											 <option value=" ">--select--</option>
											 <option value="2019">2019</option>
											  <option value="2020">2020</option>
											  <option value="2021">2021</option>
											
											 </select>
											</div>
											</div>

<!-- , gettankinflowoutflowdata(,year.value,'tanksreport1'),gettankrepairdata(tankId.value,year.value,'tanksreport2'), gettankcapacitydata(tankId.value,year.value,'tanksreport3')	 -->
	
		<div id="result1" class="col-md-12">
		
		&emsp; &emsp;
		
	
		
		<!-- 	<div id="tabs">
				<ul class="left-tabs">
									 
						
							
						 <li><a href="#tcab" >TANK CHECKS ABSTRACT</a></li>
						  <li><a href="#inflow" >TANK INFLOW-OUTFLOW</a></li>
						   <li><a href="#repairhistory" >TANK REPAIR HISTORY</a></li>						   
						     <li><a href="#capacity" >TANK CAPACITY</a></li>
						       <li><a href="#feed" >TANK FEED DETAILS</a></li>
						    
					
					
						 
						
						
						 
						</ul> --> <!-- tabs -->
					<!-- <div class="left-content" >	
						 	<div id="tcab" >
						 	 -->
						 	<form:form id="tanksreport" method="post" modelAttribute="mitankinspect">
	
		<input name=year id="yearhidden" type=hidden>
		<input name=newDistrictId id= "districtId1" type=hidden>
		<input name=mandalId id= "mandalId1" type=hidden>
		<input name=villageId id= "villageId1" type=hidden>
		<input name=tankId id= "tankId1" type=hidden>
		<input name=year id="year1" type=hidden>	
		<input name=miTankFreqId id="miTankFreqId1" type=hidden>	
		<input name=tabId id= "tabIdhidden1"  value="1" type=hidden>
		
		<div class="alert alert-info" >
			<strong>Note : Please Use A4(landscape) Size Paper for
				Print. Also Selected Data Can be Exported and Printed</strong>
		</div>	
		
	
											
		</form:form>							


		<div class="alert alert-success" >
			<h3><strong>Inspected Tanks Condition with respect to Unit</strong></h3>
		</div>	
				
				
				&emsp;&emsp;
	 <c:if test="${miunitAbstract!=null}">	

				<div class="show-grid gridList " 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class="display table-bordered table1" style="width: 100%"
							id="table1">
							<thead>

								<tr style="font-size: 18px">
									<th>Sl.No</th>
									<th>Unit</th>
									<th>Check list Monsoon (Pre / During / Post)</th>
									<th>Tanks Inspected</th>
									<th>Tanks in Emergency</th>
									<th>Tanks in Observation</th>
									<th>Tanks in Deferred</th>
									<th>Tanks in Original Work</th>
									<th>Year</th>
								
								</tr>

							</thead>


							<tbody>

								<c:forEach items="${miunitAbstract}" var="t" varStatus="count">
								
		
		
								
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>

										<td><b><c:out value="${t.unitName}"></c:out></b></td>
										
										<c:if test="${t.miTankFreqId==9}">
										<td>Pre Monsoon</td>
													</c:if>
													
													<c:if test="${t.miTankFreqId==10}">
										<td>Post Monsoon</td>
													</c:if>
													
													<c:if test="${t.miTankFreqId==11}">
										<td>During Monsoon</td>
													</c:if>

                                        
										<td ><a style="color: green;font-weight: bold;"	href="../invReport/TankUnitDetails?unitId=<c:out
													value="${t.unitId}"></c:out>&tankStatusId=5&miTankFreqId=<c:out
													value="${t.miTankFreqId}"></c:out>&year=<c:out
													value="${t.year}"></c:out>"  target="_blank"><c:out
													value="${t.totalCount}"></c:out></a></td>
										<td><a style="color: red;font-weight: bold;"	href="../invReport/TankUnitDetails?unitId=<c:out
													value="${t.unitId}"></c:out>&tankStatusId=2&miTankFreqId=<c:out
													value="${t.miTankFreqId}"></c:out>&year=<c:out
													value="${t.year}"></c:out>"  target="_blank"><c:out
													value="${t.emergencyCount}"></c:out></a></td>
													<td><a style="color: blue;font-weight: bold;"	href="../invReport/TankUnitDetails?unitId=<c:out
													value="${t.unitId}"></c:out>&tankStatusId=1&miTankFreqId=<c:out
													value="${t.miTankFreqId}"></c:out>&year=<c:out
													value="${t.year}"></c:out>"  target="_blank"><c:out
													value="${t.observeCount}"></c:out></a></td>
													<td><a style="color: orange;font-weight: bold;"	href="../invReport/TankUnitDetails?unitId=<c:out
													value="${t.unitId}"></c:out>&tankStatusId=3&miTankFreqId=<c:out
													value="${t.miTankFreqId}"></c:out>&year=<c:out
													value="${t.year}"></c:out>"  target="_blank"><c:out
													value="${t.defferedCount}"></c:out></a></td>
													
													<td><a style="font-weight: bold;"	href="../invReport/TankUnitDetails?unitId=<c:out
													value="${t.unitId}"></c:out>&tankStatusId=4&miTankFreqId=<c:out
													value="${t.miTankFreqId}"></c:out>&year=<c:out
													value="${t.year}"></c:out>"  target="_blank"><c:out
													value="${t.originalworkCount}"></c:out></a></td>
													<td style="font-weight: bold;"><c:out
													value="${t.year}"></c:out></td>
										


									</tr>

								</c:forEach>



							



							</tbody>
		</table>


				</div>
				</div>
				 </c:if> 
			
			&emsp;&emsp;	 
			<div class="alert alert-success" >
			<h3><strong>Inspected Tanks with respect to District and Monsoon</strong></h3>
		</div>	
				
				
				
				 &emsp;&emsp;
	<c:if test="${miTankAbstract!=null}">	

				<div class="show-grid gridList " 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class="display table-bordered table1" style="width: 100%"
							id="table1">
							<thead>

								<tr style="font-size: 18px">
									<th>Sl.No</th>
									<th>District</th>
									<th>Check list Monsoon (Pre / During / Post)</th>
									<th>Tanks Inspected</th>
									<th>Tanks in Emergency</th>
									<th>Tanks in Observation</th>
									<th>Tanks in Deferred</th>
									<th>Tanks in Original Work</th>
									<th>Year</th>
									
								
								</tr>

							</thead>


							<tbody>

								<c:forEach items="${miTankAbstract}" var="t" varStatus="count">		
								
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>

										<td><b><c:out value="${t.districtName}"></c:out></b></td>
										
										<c:if test="${t.miTankFreqId==9}">
										<td>Pre Monsoon</td>
													</c:if>
													
													<c:if test="${t.miTankFreqId==10}">
										<td>Post Monsoon</td>
													</c:if>
													
													<c:if test="${t.miTankFreqId==11}">
										<td>During Monsoon</td>
													</c:if>

                                        
										<td ><a style="color: green;font-weight: bold;"	href="../invReport/TankDetail?newDistrictId=<c:out
													value="${t.newDistrictId}"></c:out>&tankStatusId=5&miTankFreqId=<c:out
													value="${t.miTankFreqId}"></c:out>&year=<c:out
													value="${t.year}"></c:out>"  target="_blank"><c:out
													value="${t.totalCount}"></c:out></a></td>
										<td><a style="color: red;font-weight: bold;"	href="../invReport/TankDetail?newDistrictId=<c:out
													value="${t.newDistrictId}"></c:out>&tankStatusId=2&miTankFreqId=<c:out
													value="${t.miTankFreqId}"></c:out>&year=<c:out
													value="${t.year}"></c:out>"  target="_blank"><c:out
													value="${t.emergencyCount}"></c:out></a></td>
													<td><a style="color: blue;font-weight: bold;"	href="../invReport/TankDetail?newDistrictId=<c:out
													value="${t.newDistrictId}"></c:out>&tankStatusId=1&miTankFreqId=<c:out
													value="${t.miTankFreqId}"></c:out>&year=<c:out
													value="${t.year}"></c:out>"  target="_blank"><c:out
													value="${t.observeCount}"></c:out></a></td>
													<td><a style="color: orange;font-weight: bold;"	href="../invReport/TankDetail?newDistrictId=<c:out
													value="${t.newDistrictId}"></c:out>&tankStatusId=3&miTankFreqId=<c:out
													value="${t.miTankFreqId}"></c:out>&year=<c:out
													value="${t.year}"></c:out>"  target="_blank"><c:out
													value="${t.defferedCount}"></c:out></a></td>
													
													<td><a style="font-weight: bold;"	href="../invReport/TankDetail?newDistrictId=<c:out
													value="${t.newDistrictId}"></c:out>&tankStatusId=4&miTankFreqId=<c:out
													value="${t.miTankFreqId}"></c:out>&year=<c:out
													value="${t.year}"></c:out>"  target="_blank"><c:out
													value="${t.originalworkCount}"></c:out></a></td>
													<td style="font-weight: bold;"><c:out
													value="${t.year}"></c:out></td>
										


									</tr>

								</c:forEach>
										
										
										
										
										
										
										
										
									<%-- 	<td><a 	href="../invReport/TankDetail?newDistrictId=<c:out
													value="${t.newDistrictId}"></c:out>&miTankFreqId=9"   target="_blank"><c:out
													value="${t.preTankCount}"></c:out></a></td>
										<td><a  	href="../invReport/TankDetail?newDistrictId=<c:out
													value="${t.newDistrictId}"></c:out>&miTankFreqId=11" target="_blank"><c:out
													value="${t.duringTankCount}"></c:out></a></td>


										<td><a 	href="../invReport/TankDetail?newDistrictId=<c:out
													value="${t.newDistrictId}"></c:out>&miTankFreqId=10"  target="_blank"><c:out
													value="${t.postTankCount}"></c:out></a></td>
										 --%>
										


									<%-- </tr>

								</c:forEach>
 --%>


								<%-- <tr style="color: red; font-weight: bold; font-size: 16px;">
									<td>MI Tanks</td>
									<td style="text-align: center;">Total</td>
									<td><a target="_blank"
										href="../invReport/TankDetail?newDistrictId=0&miTankFreqId=9">${totalPreCount}</a></td>
										
									<td><a target="_blank"
										href="../invReport/TankDetail?newDistrictId=0&miTankFreqId=11" >${totalDuringCount}</a></td>

									<td><a target="_blank"
										href="../invReport/TankDetail?newDistrictId=0&miTankFreqId=10" >${totalPostCount}</a></td>
									
									

								</tr> 

 --%>

							</tbody>
		</table>


				</div>
				</div>
				</c:if>
				
					&emsp;&emsp;	 
			<div class="alert alert-success" >
			<h3><strong>Inspected Tanks Capacity (mcft) and Ayacut (acres) With respect to Unit</strong></h3>
		</div>	
				
				
				
				 &emsp;&emsp;
				
				
				<c:if test="${mCapacityAbstract!=null}">	

				<div class="show-grid gridList " 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class="display table-bordered table1" style="width: 100%"
							id="table1">
							<thead>

								<tr style="font-size: 18px">
									<th>Sl.No</th>
									<th>Unit</th>
									<th>Total Ayacut (acres)</th>
									<th>Cultivated Ayacut (acres)</th>
									<th>Gross Capacity (mcft)</th>
									<th>Available Capacity (mcft)</th>
									
								
								</tr>

							</thead>


							<tbody>

								<c:forEach items="${mCapacityAbstract}" var="t" varStatus="count">
								
		
		
								
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>

										<td ><a style="color: blue;"	href="../invReport/TankcapayacutDetail?unitId=<c:out
													value="${t.unitId}"></c:out>"  target="_blank"><b><c:out value="${t.unitName}"></c:out></b></a></td>
										
										
                                        
										<td style="color:red;"><c:out
													value="${t.grossAyacut}"></c:out></td>
										<td style="color:green;"><c:out
													value="${t.ayacut}"></c:out></a></td>
													<td style="color:red;"><c:out 	value="${t.grossCapacity}"></c:out></td>
													<td style="color:green;"><c:out
													value="${t.availableCapacity}"></c:out></td>
													
												
										


									</tr>

								</c:forEach>



							



							</tbody>
		</table>


				</div>
				</div>
				 </c:if> 
				 
						 	</div>
						 	
<%-- 						 	<div id="inflow" >
						 	
						 	<form:form id="tanksreport1" method="post" modelAttribute="mitankinspect">
	
	
	<input name=year id="yearhidden" type=hidden>
		<input name=newDistrictId id= "districtId2" type=hidden>
		<input name=mandalId id= "mandalId2" type=hidden>
		<input name=villageId id= "villageId2" type=hidden>
		<input name=tankId id= "tankId2" type=hidden>
		<input name=year id= "year2" type=hidden>
	

	
		<input name=tabId id= "tabIdhidden2" value="2" type=hidden>
	
	

	
		<div class="alert alert-info" >
			<strong>Note : Please Use A4(landscape) Size Paper for
				Print. Also Selected Data Can be Exported and Printed</strong>
		</div>	
		
	

											 
											
		</form:form>							





&emsp;&emsp;


 <c:if test="${inflowlist!=null}">
<div class="show-grid gridList " 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class="display table-bordered table1" style="width: 100%"
							id="tableinflow">
							<thead>
							
                             <tr style="font-size: 18px">
                            
                             	
									<th colspan="2" style="color:blue;">District : <c:out value="${inflowlist[0].districtName}"></c:out></th>
									<th style="color:red;">Mandal : <c:out value="${inflowlist[0].mandalName}"></c:out></th>
									<th style="color:blue;">Village:<c:out value="${inflowlist[0].villageName}"></c:out> </th>
									<th  colspan="2"  style="color:red;">Tank:<c:out value="${inflowlist[0].tankName}"></c:out></th>
								
									
									
								</tr>
								
								<tr style="font-size: 18px">
									<th>Sl.No</th>
									<th>Inflow</th>
									<th>Outflow</th>
									<th >Ayacut</th>
									<th >Inspect Date (dd/mm/yyyy)</th>
									<th >Remarks</th>
								
								</tr>

							</thead>


							<tbody>

								<c:forEach items="${inflowlist}" var="t" varStatus="count">
								
		
		
									<a target="_blank"  href="../parasreport/cagParasAbstractOffice?unitId=<c:out value="${t.unitId}"></c:out>" ></a>
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>
onclick="gettankdetail(${t.newDistrictId},9,${t.year})"
										<td  ><b><c:out value="${t.inflow}"></c:out></b></td>
										<td  ><c:out 	value="${t.outfow}"></c:out></td>


										<td ><c:out 	value="${t.ayacut}"></c:out></td>
										<td ><c:out 	value="${t.inspectDate}"></c:out></td>
											<td  ><c:out 	value="${t.remarks}"></c:out></td>
										


									</tr>

								</c:forEach>



							



							</tbody>
		</table>

	


	









					<!-- </div> -->

						</c:if>


				</div>
				</div>
				
				</c:if>  
				
				


</div> --%>
<%-- 						 	<div id="repairhistory" >
						 	
						 	<form:form id="tanksreport2" method="post" modelAttribute="mitankinspect">
	

		<input name=newDistrictId id= "districtId3" type=hidden>
		<input name=mandalId id= "mandalId3" type=hidden>
		<input name=villageId id= "villageId3" type=hidden>
		<input name=tankId id= "tankId3" type=hidden>
		<input name=year id= "year3" type=hidden>
		
		
		<input name=tabId id="tabIdhidden3" value="3" type=hidden>
	

	
		
		<div class="alert alert-info" >
			<strong>Note : Please Use A4(landscape) Size Paper for
				Print. Also Selected Data Can be Exported and Printed</strong>
		</div>	
		
		
	
											 
											
		</form:form>							






&emsp; &emsp;

   <c:if test="${repairlist!=null}">
<div class="show-grid gridList " 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class="display table-bordered table1" style="width: 100%"
							id="table3">
							<thead>
                        
                             <tr style="font-size: 18px">
                            
                             	
									<th colspan="3" style="color:blue;">District : <c:out value="${repairlist[0].districtName}"></c:out></th>
									<th  colspan="2"style="color:red;">Mandal : <c:out value="${repairlist[0].mandalName}"></c:out></th>
									<th  colspan="2" style="color:blue;">Village:<c:out value="${repairlist[0].villageName}"></c:out> </th>
									<th  colspan="3"  style="color:red;">Tank:<c:out value="${repairlist[0].tankName}"></c:out></th>
								
									
									
								</tr>
							
								<tr style="font-size: 18px">
									<th>Sl.No</th>
									<th>Component Name</th>
									<th>Rate</th>
									<th>Quantity</th>
									<th>Amount</th>
									<th>Units</th>
									<th>Start Date - End Date</th>
									<th>Scheme Taken</th>
									<th>Description of Repair</th>
									<th>Remarks</th>
								
								</tr>

							</thead>


							<tbody>

								<c:forEach items="${repairlist}" var="t" varStatus="count">
								
		
		
									<a target="_blank"  href="../parasreport/cagParasAbstractOffice?unitId=<c:out value="${t.unitId}"></c:out>" ></a>
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>
onclick="gettankdetail(${t.newDistrictId},9,${t.year})"
										<td><b><c:out value="${t.miCompName}"></c:out></b></td>
										<td><c:out 	value="${t.rate}"></c:out></td>


										<td><c:out  value="${t.quantity}"></c:out></td>
										<td><c:out 	value="${t.amount}"></c:out></td>
											<td><c:out 	value="${t.unitMeasureName}"></c:out></td>
												<td><c:out 	value="${t.repairStartDate}"></c:out> - <c:out 	value="${t.repairEndDate}"></c:out></td>
													<td><c:out 	value="${t.schemeTaken}"></c:out></td>
														<td><c:out 	value="${t.repairDescription}"></c:out></td>
														
														<td><c:out 	value="${t.remarks}"></c:out></td>
										


									</tr>

								</c:forEach>






							</tbody>
		</table>

			
				</div>
				</div>
				
				</c:if>

</div> --%>
						 	<%-- <div id="capacity" >
						 	<form:form id="tanksreport3" method="post" modelAttribute="mitankinspect">
	
	
	
	
	<input name=newDistrictId id= "districtId4" type=hidden>
		<input name=mandalId id= "mandalId4" type=hidden>
		<input name=villageId id= "villageId4" type=hidden>
		<input name=tankId id= "tankId4" type=hidden>
		<input name=year id= "year4" type=hidden>
		

		<input name=tabId id= "tabIdhidden4" value="4"  type=hidden>
		
		
		
		<div class="alert alert-info" >
			<strong>Note : Please Use A4(landscape) Size Paper for
				Print. Also Selected Data Can be Exported and Printed</strong>
		</div>	
		
		
	
											 
											
		</form:form>							






&emsp;&emsp;

 <c:if test="${capacitylist!=null}">
<div class="show-grid gridList " 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class="display table-bordered table1" style="width: 100%"
							id="table4">
							<thead>
							
							
                             <tr style="font-size: 18px">
                            
                             	
									<th colspan="2" style="color:blue;">District : <c:out value="${capacitylist[0].districtName}"></c:out></th>
									<th  colspan="2"style="color:red;">Mandal : <c:out value="${capacitylist[0].mandalName}"></c:out></th>
									<th  colspan="3" style="color:blue;">Village:<c:out value="${capacitylist[0].villageName}"></c:out> </th>
									<th  colspan="3"  style="color:red;">Tank:<c:out value="${capacitylist[0].tankName}"></c:out></th>
								
									
									
								</tr>
								

								<tr style="font-size: 18px">
									<th>Sl.No</th>
									<th>Gross Capacity</th>
									<th>Available Capacity</th>
									<th>Surplus</th>
									<th>Inflow (Cusecs)</th>
									<th>Outflow (Cusecs)</th>
									<th>Ayacut (acres)</th>
									<th>Tank Level (M)</th>
									<th>Inspect Date</th>									
									<th>Remarks</th>
								
								</tr>

							</thead>


							<tbody>
								<c:forEach items="${capacitylist}" var="t" varStatus="count">		
		
									<a target="_blank"  href="../parasreport/cagParasAbstractOffice?unitId=<c:out value="${t.unitId}"></c:out>" ></a>
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>
onclick="gettankdetail(${t.newDistrictId},9,${t.year})"
										<td style="color:red;"><b><c:out value="${t.grossCapacity}"></c:out></b></td>
										<td style="color:green;"><c:out 	value="${t.availableCapacity}"></c:out></td>


										<td><c:out 	value="${t.surplus}"></c:out></td>
										<td><c:out 	value="${t.inflow}"></c:out></td>
										<td><c:out 	value="${t.outfow}"></c:out></td>
											<td><c:out 	value="${t.ayacut}"></c:out></td>
										
											<td><c:out 	value="${t.tankLevel}"></c:out></td>
										<td><c:out  value="${t.inspectDate}"></c:out></td>
										<td><c:out  value="${t.remarks}"></c:out></td>
										


									</tr>

								</c:forEach>



							


							</tbody>
		</table>

					


					<!-- </div> -->

						</c:if>


				</div>
				</div>
				</c:if>

</div> --%>

<%-- <div id="feed" >
						 	<form:form id="tanksreport5" method="post" modelAttribute="mitankinspect">
	
	
	
	
		<input name=newDistrictId id= "districtId5" type=hidden>
		<input name=mandalId id= "mandalId5" type=hidden>
		<input name=villageId id= "villageId5" type=hidden>
		<input name=tankId id= "tankId5" type=hidden>
		<input name=year id= "year5" type=hidden>
		

		<input name=tabId id= "tabIdhidden5" value="5"  type=hidden>
		
		<div class="alert alert-info" >
			<strong>Note : Please Use A4(landscape) Size Paper for
				Print. Also Selected Data Can be Exported and Printed</strong>
		</div>	
		
		
	
											 
											
		</form:form>							






&emsp; &emsp;


 <c:if test="${feedlist!=null}">
<div class="show-grid gridList " 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class="display table-bordered table1" style="width: 100%"
							id="table4">
							<thead>
							
							
                             <tr style="font-size: 18px">
                            
                             	
									<th colspan="2" style="color:blue;">District : <c:out value="${capacitylist[0].districtName}"></c:out></th>
									<th  colspan="1"style="color:red;">Mandal : <c:out value="${capacitylist[0].mandalName}"></c:out></th>
									<th  colspan="1" style="color:blue;">Village:<c:out value="${capacitylist[0].villageName}"></c:out> </th>
									<th  colspan="2"  style="color:red;">Tank:<c:out value="${capacitylist[0].tankName}"></c:out></th>
								
									
									
								</tr>
							

								<tr style="font-size: 18px">
									<th>Sl.No</th>
									<th>Can Feed</th>
									<th>Cluster Name</th>
									<th>Chain Link Name</th>
									<th>Source Type</th>									
									<th>Source Component Type</th>
									<th>Source Name</th>
									<th>Date</th>
									<th>O.T Location</th>
									<th>Source Details</th>
								
								</tr>

							</thead>


							<tbody>
								<c:forEach items="${feedlist}" var="t" varStatus="count">		
		
									<a target="_blank"  href="../parasreport/cagParasAbstractOffice?unitId=<c:out value="${t.unitId}"></c:out>" ></a>
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>
onclick="gettankdetail(${t.newDistrictId},9,${t.year})"
										<td><b><c:out value="${t.grossCapacity}"></c:out></b></td>
										<td><c:out 	value="${t.availableCapacity}"></c:out></td>


										<td><c:out 	value="${t.surplus}"></c:out></td>
										<td><c:out  value="${t.inspectDate}"></c:out></td>
										<td><c:out  value="${t.remarks}"></c:out></td>
										
										 <td></td>
										  <td></td>
										   <td></td>
										    <td></td>
										     <td></td>
										      <td></td>
										       <td></td>
										        <td></td>
										         <td></td>
										          <td></td>


									</tr>

								</c:forEach>



							


							</tbody>
		</table>

					


					<!-- </div> -->

						</c:if>


				</div>
				</div>
				
				</c:if>

</div> --%>
						
					<!-- </div>
					</div>	 
					</div>
						  -->

  


	
</div> <!-- //panel body -->
		</div> <!-- panel heading -->


	
	 </div> 
<!-- empty -->
 </div> 
<!-- //col-md-9-->






						<!-- 	<script src="../js/Html5DataTable/jquery-3.3.1.js" type="text/javascript"></script> -->
						<script src="../js/Html5DataTable/jquery.dataTables.min.js"
							type="text/javascript"></script>
						<script src=" ../js/Html5DataTable/dataTables.buttons.min.js"
							type="text/javascript"></script>
						<script src=" ../js/Html5DataTable/jszip.min.js"
							type="text/javascript"></script>
						<script src="../js/Html5DataTable/pdfmake.min.js"
							type="text/javascript"></script>
						<script src=" ../js/Html5DataTable/vfs_fonts.js"
							type="text/javascript"></script>
						<script src="../js/Html5DataTable/buttons.html5.min.js"
							type="text/javascript"></script>
						<script src="../js/Html5DataTable/buttons.print.min.js"
							type="text/javascript"></script>
						<script src="../js/Html5DataTable/dataTables.select.min.js"
							type="text/javascript"></script>


						<script type="text/javascript">
							$('.table1')
									.DataTable(
											{
												dom : 'Bfrtip',
												responsive : true,
												"paging" : false,
												"autoWidth" : true,
												"lengthChange" : false,
												"pageLength" : 20,
												buttons : [
														'copyHtml5',
														{
															extend : 'excelHtml5',
															autoFilter : true,
															sheetName : 'Exported_Paras_data',
															text : 'Save To Excel',
															className : 'btn-primary ',
															messageTop : 'Mi Tank Inspection Abstract'

														},

														{
															extend : 'pdfHtml5',
															className : 'btn-primary ',
															text : 'PDF View / Download',
															orientation : 'landscape',
															pageSize : 'A4',
															download : 'open',
															font : '18',
															filename : 'IR_Paras_Report',
															exportOptions : {
																columns : ':visible',
																search : 'applied',
																order : 'applied'
															},

															title : 'Mi Tank Inspection Abstract',
															customize : function(
																	doc) {
																doc.defaultStyle.fontfamily = 'Arial';

																doc.defaultStyle.fontSize = 16;
																doc.defaultStyle.alignment = 'center';
																doc.styles.tableHeader.fontSize = 18;
																doc.pageMargins = [
																		80, 80,
																		80, 80 ];
																doc['footer'] = (function(
																		page,
																		pages) {
																	return {
																		columns : [

																		{
																			alignment : 'right',
																			text : [
																					{
																						text : page
																								.toString(),
																						italics : true
																					},
																					' of ',
																					{
																						text : pages
																								.toString(),
																						italics : true
																					} ]
																		} ],
																		margin : [
																				5,
																				0 ]
																	}
																});

															}

														},
														{
															extend : 'print',
															text : 'Print All',
															className : 'btn-primary ',
															exportOptions : {
																modifier : {
																	selected : null
																}
															}

														},
														,
														{
															extend : 'print',
															text : 'Print Selected',
															className : 'btn-primary '

														} ],
												select : true

											});
						</script>















<script type="text/javascript" src="../js/parsley.js"></script>



<!-- //main-content -->
