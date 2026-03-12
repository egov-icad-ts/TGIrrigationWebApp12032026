<%@include file="/jsp/header/taglib_includes.jsp"%> 




<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">

<script src="../js/newcharts/core.js"></script>
<script src="../js/newcharts/charts.js"></script>
<script src="../js/newcharts/animated.js"></script>



<link rel="stylesheet"
	href="../css/Html5DataTable/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href=" ../css/Html5DataTable/buttons.dataTables.min.css" />
	
	<script type="text/javascript" src="../js/invomReports/form20_report.js"></script>

<style>
#chartdiv {
  width: 100%;
  height: 300px;
}

</style>

<style>
#chartdiv {
  width: 100%;
  height: 300px;
}

</style>

<style>
#chartdiv2 {
 width: 100%;
  height: 400px;
}

</style>

<style>
#chartdiv3 {
  width: 100%;
  height:  400px;
}

</style>


<link rel="stylesheet" media="screen" href="../css/custom.css" >
<div class="col-md-9">       
		 


		<div >
			 

				<!--   panel start here -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title" style="color:#fff" >TMS of Irrigation Tank / Projects (Major/medium):Form 20 Report.  
						
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
					 <c:if test="${userObj.userName!='icad_test' && userObj.userName!='cs_telangana'  }">	 <c:out value="${userObj.unitName}"></c:out></c:if>
			   <c:if test="${userObj.userName=='icad_test'  }">	 AG AUDIT</c:if>	
			    <c:if test="${userObj.userName=='cs_telangana'  }"> CS Telangana</c:if>	
			   
		
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
			 </div>
			 <br>
	</c:if></h3>
					</div>
					
					<div class="panel-body">
				
				
						
			
						 	
					
					
					<div class="col-md-12  ">
					<form:form id="tankform20main" method="post" modelAttribute="mitankform20main" name="mainform20abreport">
					
						<div class="col-md-12">
	                                    <div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Select year  or both from date and to date to get data</strong>
				<br>
					<br>
				
				
                 
                 
			</div>
			</div>
			</div>
					
					 <c:if test="${userObj!=null}">	
					 
					 <input name="unitId" value="${userObj.unitId}" class=" form-control " id="uformUnitId" type="hidden" />
					  <input name="circleId" value="${userObj.circleId}" class=" form-control " id="uformCircleId" type="hidden" />
					  <input name="divisionId" value="${userObj.divisionId}" class=" form-control " id="uformDivisionId" type="hidden" />
					   <input name="subDivisionId" value="${userObj.subdivisionId}" class=" form-control " id="uformSubdivisionId" type="hidden" />
					    <input name="designationId" value="${userObj.designationId}" class=" form-control " id="uformdrilldesgId" type="hidden" />
					    <input name="listDesignationId"  class=" form-control " id="uformlistdesgId" type="hidden" />
					     <input name="postId" value="${userObj.post}" class=" form-control " id="uformPostId" type="hidden" />
					       <input name="tsfcFormYear"  class=" form-control " id="formyear1" type="hidden" />
					       
					         <input  name="frmFromDate"  class=" form-control " id="frmFromDate1"  type="hidden" />
					          <input name="frmToDate"  class=" form-control " id="frmToDate1"   type="hidden" />
					        <input    name="offAccess" class=" form-control " id="uformOfficeAccess"  type="hidden" />
					        
					          <input  value="${userObj.designationId}" class=" form-control " id="uformDesignationId" type="hidden" />
					          
					          
					             <input  name="tankCout"  class=" form-control " id="tankCout"  value="${repeatedCountAbst[0].tankCout}" type="hidden" />
					             <input  name="repeatedTankId"  class=" form-control " id="repeatedTankId"  value="${repeatedCountAbst[0].repeatedTankId}" type="hidden" />
					             <input  name="repeatedTankName"  class=" form-control " id="repeatedTankName"  value="${repeatedCountAbst[0].repeatedTankName}" type="hidden" />
					              <input  name="repeatedCatId"  class=" form-control " id="repeatedCatId"  value="${repeatedCountAbst[0].repeatedCatId}" type="hidden" />
					             
					          
					          
					          
					          
					          
					          
					        
					        </c:if>
					        
					        
					      <!--    <div class="col-md-12 invDiv">
							
							<div class="col-md-6 invDiv">
							
							<div id="chartdiv">
							
							grapgh here
							
							</div>
							
							
							</div>
							<div class="col-md-6 invDiv">
							
						
							<div id="chartdiv1">
							
							second	grapgh here
							
							</div>
						
							
							
							
							</div>
							
							
							
							
							</div>  -->
							
					<!-- 	 <div class="col-md-12 invDiv">
						 
						 
						 <h4>Repeated Sources Breached</h4>
						 
							<div id="chartdiv2">
							
							
							
							</div>
							
							
							</div>  -->
							
						<!-- 	 <div class="col-md-12 invDiv">
							 
							  <h4>Repeated Sources damaged</h4>
							<div id="chartdiv3">
							
							
							
							</div>
							 
							
							
							</div>  -->
					
						<div class="col-md-12  invDiv ">
                                        <div class="col-md-2 ">
											<label class="label-control rowlebel ">Select Year</label>
											  <select class="form-control" id="form20year" name="formyear" > 
											 <option value="0">--select--</option>
											
											<c:forEach items="${selectFormYear}" var="u">
									              <option value="${u.tsfcFormYear}">${u.tsfcFormYear}</option>

								</c:forEach>
											 </select>
											</div>
								<div class="col-md-2 "> OR </div>								
												
									<div class="col-md-2 ">
										<label class="label-control rowlebel ">From Date</label>
										<input type="text" class=" datepick form-control datepicker"
											id="tsfcfrmFromDate"
											name="tsfcfrmFromDate"
											placeholder="date" readonly="readonly"  />
										
										</div>
									<div class="col-md-2 ">
										<label class="label-control rowlebel ">To Date</label>
										<input type="text" class=" datepick form-control datepicker"
											id="tsfcfrmToDate"
											name="tsfcfrmToDate"
											placeholder="date" readonly="readonly"  /></div>
											
											<div class="col-md-4 "> 
											<button id="viewform20report" class="btn btn-1 btn-primary center-block" type="button" name="viewform20report" onclick="getform20tankabdata( form20year.value,tsfcfrmFromDate.value,tsfcfrmToDate.value,'tankform20main','true')">Submit</button>
											</div>
											</div> <!-- end of invDiv -->
											
										
											
											
								</form:form>
							</div>	
							
							
							
						
						
						<div id="abs1" class="col-md-12 ">	
						
						<ul id="tmsreportstab">
					 <li><a href="#tcab1" data-toggle="tab" >Form 20 Tanks Abstract</a></li>
					    <li><a href="#tcab2" data-toggle="tab" >Form 20 Reservoirs Abstract</a></li>
				   <li><a href="#tcab3"  data-toggle="tab" >Form 20 Canals Abstract</a></li>						   
					 
						</ul> 	
						
						<div id="tcab1" class="col-md-12 ">	
								<form:form id="tankform20report1" method="post" modelAttribute="mitankform20rpt" >	
								<div class="col-md-12">
								<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Tanks Abstract</strong>
				<br>
				

			</div>
			</div>
			</div>
	
	     <c:set var = "frmdesg" scope = "session" value = "${userObj.designationId}"/>	
	      <c:set var = "frmoffacc" scope = "session" value = "1"/>	
	      <c:set var = "frmnewdesg" scope = "session" value = "1"/>	  
					       
	
	  <input name="tsfcFormYear"  class=" form-control " id="frmyear" type="hidden" />
	   <input name="frmFromDate"  class=" form-control " id="frmdate" type="hidden" />
	     <input name="frmToDate"  class=" form-control " id="frmtodate" type="hidden" />
	 
	  <input name="unitId"  class=" form-control " id="frmtempUnitId" type="hidden" />	
	  <input name="circleId"  class=" form-control " id="frmtempCircleId" type="hidden" />	
	   <input name="divisionId"  class=" form-control " id="frmtempDivisionId" type="hidden" /> 
	   <input name="subDivisionId"  class=" form-control " id="frmtempSubDivisionId" type="hidden" />
	    <input  value="${frmoffacc}"  name="offAccess" class=" form-control " id="frmtempOfficeAccess" type="hidden" />
	    <input name="postId"  class=" form-control " id="frmtempPostId" type="hidden" />
	    <input name="designationId"  value="${frmnewdesg}"  class=" form-control " id="frmtempDesignationId" type="hidden" />
	    <input name="formDataId"    class=" form-control " id="form20DataId" type="hidden" />
	    <input name="catId"    class=" form-control " id="frmcatId" type="hidden" />
	    <input name="sourceName"    class=" form-control " id="sourceName" type="hidden" />
	    
	     <!-- <input name="reportType"   class=" form-control "    id="frmtempreportTypeId" type="hidden" /> -->

	     
	     
	     
	       <!-- values for  for back button  -->	
	     
	     <%--  <input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="logincapUnitId" type="hidden" />
	       <input name="userCircleId" value="${userObj.circleId}" class=" form-control " id="logincapCircleId" type="hidden" />
	        <input name="userDivisionId" value="${userObj.divisionId}" class=" form-control " id="logincapDivisionId" type="hidden" />
	         <input name="userSubdivisionId" value="${userObj.subdivisionId}" class=" form-control " id="logincapSubdivisionId" type="hidden" />
	         --%>
	         <input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="logincapUnitId" type="hidden" >
	          <input name="userDesignationId" value="${userObj.designationId}" class=" form-control " id="loginfrm20designationId" type="hidden" />
	         <input name="backdesignationId" value="0" class=" form-control " id="frmbackdesgId" type="hidden" /> 
	         <input name="listDesignationId"    class=" form-control " id="frmtemplistDesignationId" type="hidden" />
	         
	         
	         
	         	<div class="row show-grid ">

		
		
		<c:if test="${frmdetailYear!=null}">
		<div class="col-md-12"  id="form20pre">
		
		<button type="button" name="backtoform20intreport" id="backtoform20intreport" class="btn btn-1 btn-primary center-block " onclick="getform20tankabdata('${frmdetailYear}','${frmdetailFromDate}','${frmdetailToDate }','tankform20main',false )"><b>Back to Initial Abstract Data</b></button>				
				</div>	
				</c:if>
				
			<%--  <c:if test="${formcontbackdesgId!=0 && formcontbackdesgId!=null  &&  formcontbackdesgId>capdesgId && capunitId!=4 && capunitId!=9832  }"> --%>
				
				<!-- && frmunitId!=4 && frmunitId!=9832  -->
			 <c:if test="${formcontbackdesgId!=0 && formcontbackdesgId!=null  && prefrm20year!=null &&  formcontbackdesgId>frmdesgId && frmunitId!=4 && frmunitId!=9832  && frmunitId!=9830 }">
				<div class="col-md-2"  id="preform20abstract">
				 <%--  <c:out value="${formcontbackdesgId} ,${frmdesgId} "></c:out> --%>
				<button type="button" name="preform20abst" id="preform20abst" class="btn btn-1 btn-primary center-block " onclick="gettankForm20abstract('${prefrm20year}', '${prefrm20desgId}','${prefrm20unitId}','${prefrm20circleId}','${prefrm20divisionId}','${prefrm20subdivisionId}','${prefrm20post}','${prefrm20offAccess}','tankform20report1','${fromdate }','${todate }' )"><b>Form20 Previous Absract Tanks</b></button>
				
				</div>	
				</c:if> 
				
			
				
		</div>
								
									<c:if test="${mifrom20tankabst!=null}">
		<div class="show-grid gridList "  id="cap-detail-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
				 
						<table class="display table-bordered  table1" id="t-form-1">
							<thead id="t-form-hd-1" >
	                      <tr style="font-size: 18px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                      <th>Office</th>
	                      
	                    
	                      <th>Sum of Approx. Permanent Cost (In Lakhs)</th>
	                      <th>Sum of Approx Temporary Cost (In Lakhs)</th>
	                      <th>Sum of Approx. Total Repairs Cost (In Lakhs)</th>
	                      <!--   <th>Total Book value (In Lakhs)</th> -->
	                      
	                      <th>Form 20 breached tanks count</th>
	                      <th>Form 20 damaged tanks count</th>
	                      <th>Form 20 submitted tanks count</th>
	                      
	                   
							</tr>
							</thead>


							<tbody id="t-form-bd-1">
							
						<tr style="font-size: 12px ; text-align: center; color:red; font-weight: bold;"> 
						<td></td>
						<td>Year/ Date Range <c:out value="${userObj.userName}"></c:out></td>
						<c:choose>
									 <c:when test="${fn:length(fromdate)>0 && fn:length(todate)>0}">
									 
									  <td><b> from <c:out value="${fromdate}"></c:out>     to  <c:out value="${todate}"></c:out>  </b></td>
									 </c:when>
									  
									  <c:when test="${frmYear!=null && frmYear>0 }">
									   <td><b><c:out value="${frmYear}"></c:out></b></td>
									  </c:when>
										<c:otherwise>
										  <td><b></b></td>
										</c:otherwise>
									
                                          </c:choose>  
                                          
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td></tr>
							
							<c:forEach items="${mifrom20tankabst}" var="f" varStatus="count">		
								
									<tr style="font-size: 12px ; text-align: center;">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>
												<c:if test="${frmdesgId==2 || frmdesgId==8 && frmsubdivId >0}">
											<td><b><c:out value="${f.postName}"></c:out></b></td>	
											</c:if>
											<c:if test="${frmdesgId==4 &&   frmsubdivId >0}">

										<td><b><c:out value="${f.postName}"></c:out></b></td>
										
										</c:if>
										
										<c:if test="${frmdesgId==5 && fmdivId>0 &&    frmsubdivId ==0}">

										<td><button type="button" name="form20tank" id="officeTankfrm${count.count}" class="btn btn-1 btn-primary center-block"  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear } ','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report1','${fromdate}','${todate}')"  ><b><c:out value="${f.subDivisionName}"></c:out></b></button></td>
										
										</c:if>
										<c:if test="${frmdesgId==7 && frmunitId>0  && frmcircleId>0 && fmdivId==0 &&    frmsubdivId ==0}">
										
										<td><button type="button" name="form20tank" id="officeTankfrm${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear } ','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report1','${fromdate}','${todate}')"  ><b><c:out value="${f.divisionName}"></c:out></b></button></td>
										
										</c:if>
										
										<c:choose>
										
											<c:when test="${frmOffAccess==3}">
											
											
											 <c:if test="${(frmdesgId==9  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) ||
											  (frmdesgId==7  && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&    f.subDivisionId ==0)}">
											  
											
											
                                         <c:if test="${frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830 }">
                                        <!--  This part of code executes when ENC A or I clicks on any unit name and designation Id becomes 9 or 7 -->
                                       <%--   <c:out value="2 CE SE nt ENCA or I"></c:out> --%>
										<td><button type="button" name="form20tank" id="officeTankfrm${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report1','${fromdate}','${todate}')"  > <b><c:out value="${f.circleName}"></c:out></b></button></td>
										</c:if>
										
										
										</c:if> 
											
											</c:when>
											
											<c:otherwise>
										 <%-- 	<c:out value="not 3 CE SE nt ENCA or I"></c:out>  --%>
											
											<c:if test="${(frmdesgId==9)  && (frmunitId>0 &&  frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0)}">
										 	<%-- <c:out value="normal CE login"></c:out>  --%>
										<td><button type="button" name="officeTankfm" id="officeTankfrm20${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear}','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report1','${fromdate}','${todate}')"  > <b><c:out value="${f.circleName}"></c:out></b></button></td>
										
										</c:if>
											
											</c:otherwise>
										
										</c:choose>
										
										
										
										<c:choose>
										<c:when test="${frmOffAccess==3}">
										<c:if test="${userObj.userName ne 'icad_test'}">
										<c:if test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9   && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&   f.subDivisionId ==0 ) ) }">
										      
										      <%-- <c:out value="${prefrm20desgId}"></c:out>  --%>
										      <c:if test="${prefrm20desgId==null}">

										<td><button type="button" name="officeTankfm" id="officeTankfrm20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report1','${fromdate}','${todate}')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										 <c:if test="${prefrm20desgId!=null}">

										<td><button type="button" name="officeTankfm" id="officeTankfrm20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract ('${frmYear }','${prefrm20desgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report1','${fromdate}','${todate}')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										</c:if>
										</c:if>
										
										<c:if test="${userObj.userName eq 'icad_test'}">
										<c:if test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9   && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&   f.subDivisionId ==0 ) ) }">
										      
										      <%-- <c:out value="${prefrm20desgId}"></c:out>  --%>
										      <c:if test="${prefrm20desgId==null}">

										<td> <b><c:out value="${f.unitName}"></c:out></b> </td>
										
										</c:if> 
										 <c:if test="${prefrm20desgId!=null}">

										<td>  <b><c:out value="${f.unitName}"></c:out></b> </td>
										
										</c:if> 
										</c:if>
										</c:if>
										</c:when>
										<c:otherwise>
										
										
										
									
										
											<c:if test="${(frmdesgId==10  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 )}">

										<td><button type="button" name="officeTankfm" id="officeTankfrm20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report1','${fromdate}','${todate}')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if>
									
								
										
										</c:otherwise>
										
										
									        </c:choose>
										
										
											
											<td><b>${f.sumAprxCostPermt}</b></td>	
											<td><b>${f.sumAprxCostTemp}</b></td>
											<td><b>${f.sumRepairsPermTemp}</b></td>
											<%-- <td><b>${f.sumFmBkValue}</b></td>	 --%>
											
											 <td><b>${f.breachCount}</b></td>
											 
											  <td><b>${f.damageCount}</b></td>
											  
											<!--   sumApxCtPermt,sumAxCtTemp,sumRepsPermTemp -->
											
										<%-- '${frmOffAccess }' '${frmOffAccess }'	sumAprxCostPermt,sumAprxCostTemp ,sumRepairsPermTemp<td><b>${f.totalTankCount}</b></td>	 --%>	
										
										 <c:choose>
											<c:when test="${(frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0) }">
										<td><button type="button" name="Form20Tanks" id="Form20Tanks${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="getForm20tanks('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${f.catId }' ,'${frmYear}','${fromdate}' ,'${todate}' )"  > <b>${f.totalTankCount}</b></button></td>
										
										
										</c:when>
										
										<c:otherwise>
										<td><button type="button" name="Form20Tanks" id="Form20Tanks${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="getForm20tanks('${frmYear }','${frmListdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${f.catId }','${frmYear}','${fromdate}' ,'${todate}')"  > <b>${f.totalTankCount}</b></button></td>
										
										
										</c:otherwise>
										
										</c:choose>
										
																			 
											 
										
                                          

									</tr>

								</c:forEach>
								
								<tr style="color: red ; font-size: 12px; font-weight: bold; text-align: center;  ">
								<td>--</td>
								<td>Tanks/Anicuts/Check Dams Total</td>
								<td>${tankstotalApc }</td>
								<td>${tankstotalAtc }</td>
								<td>${tankstotalAtr }</td>
								<td>${tankstotalbc }</td>
								<td>${tankstotaldc }</td>
								<td>${tankstotaltc }</td>
								<td></td>
								
								</tr>

							
							</tbody>
							
		</table>
		<c:out value="Note: Approx. Total Repairs Cost= Approx Permament cost + Approx temporary cost "></c:out>
		</div>
		</div>
				
				</c:if>
				
				<c:if test="${miTankForm20detail!=null}">
				
				<div class="show-grid gridList "  id="form-detail-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered  table1" id="form-detail-1">
							<thead id="form-detail-hd-1" >
	                      <tr style="font-size: 12px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                       <th>District Name</th>
	                      <th>Mandal Name</th>
	                      <th>Village Name</th>
	                      <th>Constituency</th>
	                     <!--  <th>Unit Name</th>
	                      <th>Circle Name</th>
	                      <th>Division Name</th> -->
	                      <th>Sub Division Name</th>
	                      <th>Tank Name</th>
	                       <th>TSFC form Date(dd/mm/YYY)</th>
	                       <th>Damage Type</th>
	                   <!--     <th>Downloads</th> -->
	                        <th>Images/Files</th>
	                     
	                     <!--  <th>Year</th> -->


							</tr>
							</thead>


							<tbody id="form-detail-bd-1">
							
						
							
							<c:forEach items="${miTankForm20detail}" var="t" varStatus="count">		
								
									<tr style="font-size: 12px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>								
										<td ><b><c:out value="${t.districtName}"></c:out></b></td>
										<td><b><c:out value="${t.mandalName}"></c:out></b></td>
										<td><b><c:out value="${t.villageName}"></c:out></b></td>
										<td><b><c:out value="${t.constituencyName}"></c:out></b></td>		

										<%-- <td><b><c:out value="${t.unitName}"></c:out></b></td>
										<td><b><c:out value="${t.circleName}"></c:out></b></td>
										<td><b><c:out value="${t.divisionName}"></c:out></b></td> --%>
										<td><b><c:out value="${t.subDivisionName}"></c:out></b></td>
											<td class="micolblue"><b><c:out value="${t.tankName}"></c:out></b></td>
											
										<%-- <td><b><c:out value="${t.tsfcFormDate}"></c:out></b></td> --%>
										
										<td><button type="button" name="form20detailrpt" id="form20detailrpt${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="getForm20DetailReport('${t.formDataId }','${t.catId }','tankform20report1')"  ><b><c:out value="${t.tsfcFormDate}"></c:out></b></button></td>
									<td><b><c:out value="${t.damageTypeName}"></c:out></b></td>
										<%-- <td><button type="button" name="form20detailrpt" id="form20detailrpt${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="getForm20ImagesReport('${t.formDataId }','${t.catId }','tankform20report1')"  ><b>Download Images in pdf</b></button></td> --%>
										
										<td><b><button type="button" name="viewfrmpht" id="viewfrmphtr${count.count}" class="btn btn-1 btn-primary center-block "  onclick="viewfrmphtfnserver(${t.formDataId },'${t.tankName}','tankform20report1')"  >View Photos</button> </b></td>
										<%-- <td><b><c:out value="${t.tsfcFormYear}"></c:out></b></td> --%>
									
									</tr>

								</c:forEach>

							
							</tbody>
		</table>


				</div>
				</div>
				
				</c:if>	
				
									</form:form> 
									</div>  <!-- end of tcab1 -->
									
							  <div id="tcab2" class="col-md-12 ">
							  
							  <form:form id="tankform20report2" method="post" modelAttribute="mitankform20rpt" >	
	
	                     <div class="col-md-12">
	                         	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Reservoir Abstract</strong>
				<br>
				

			</div>
			</div>
			</div>
	
	     <c:set var = "frmdesg" scope = "session" value = "${userObj.designationId}"/>	
	      <c:set var = "frmoffacc" scope = "session" value = "1"/>	
	      <c:set var = "frmnewdesg" scope = "session" value = "1"/>	  
					       
	
	  <input name="tsfcFormYear"  class=" form-control " id="frmyear2" type="hidden" />
	  <input name="frmFromDate"  class=" form-control " id="frmdate2" type="hidden" />
	     <input name="frmToDate"  class=" form-control " id="frmtodate2" type="hidden" />
	 
	  <input name="unitId"  class=" form-control " id="frmtempUnitId2" type="hidden" />	
	  <input name="circleId"  class=" form-control " id="frmtempCircleId2" type="hidden" />	
	   <input name="divisionId"  class=" form-control " id="frmtempDivisionId2" type="hidden" /> 
	   <input name="subDivisionId"  class=" form-control " id="frmtempSubDivisionId2" type="hidden" />
	    <input  value="${frmoffacc}"  name="offAccess" class=" form-control " id="frmtempOfficeAccess2" type="hidden" />
	    <input name="postId"  class=" form-control " id="frmtempPostId2" type="hidden" />
	    <input name="designationId"  value="${frmnewdesg}"  class=" form-control " id="frmtempDesignationId2" type="hidden" />
	    <input name="formDataId"    class=" form-control " id="form20DataId2" type="hidden" />
	     <input name="catId"    class=" form-control " id="frmcatId2" type="hidden" />
	      <input name="sourceName"    class=" form-control " id="sourceName2" type="hidden" />
	    
	     <!-- <input name="reportType"   class=" form-control "    id="frmtempreportTypeId" type="hidden" /> -->

	     
	     
	     
	       <!-- values for  for back button  -->	
	     
	     <%--  <input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="logincapUnitId" type="hidden" />
	       <input name="userCircleId" value="${userObj.circleId}" class=" form-control " id="logincapCircleId" type="hidden" />
	        <input name="userDivisionId" value="${userObj.divisionId}" class=" form-control " id="logincapDivisionId" type="hidden" />
	         <input name="userSubdivisionId" value="${userObj.subdivisionId}" class=" form-control " id="logincapSubdivisionId" type="hidden" />
	         --%>
	         <input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="logincapUnitId2" type="hidden" >
	          <input name="userDesignationId" value="${userObj.designationId}" class=" form-control " id="loginfrm20designationId2" type="hidden" />
	         <input name="backdesignationId" value="0" class=" form-control " id="frmbackdesgId2" type="hidden" /> 
	         <input name="listDesignationId"    class=" form-control " id="frmtemplistDesignationId2" type="hidden" />
	         
	         
	         
	         	<div class="row show-grid ">

		
		
		<c:if test="${frmdetailYear!=null}">
		<div class="col-md-12"  id="form20pre">
		
		<button type="button" name="backtoform20intreport" id="backtoform20intreport2" class="btn btn-1 btn-primary center-block " onclick="getform20tankabdata('${frmdetailYear}','${frmdetailFromDate }','${frmdetailToDate }','tankform20main',false )"><b>Back to Initial Abstract Data</b></button>				
				</div>	
				</c:if>
				
			<%--  <c:if test="${formcontbackdesgId!=0 && formcontbackdesgId!=null  &&  formcontbackdesgId>capdesgId && capunitId!=4 && capunitId!=9832  }"> --%>
				
				<!-- && frmunitId!=4 && frmunitId!=9832  -->
			 <c:if test="${formcontbackdesgId!=0 && formcontbackdesgId!=null  && prefrm20year!=null &&  formcontbackdesgId>frmdesgId && frmunitId!=4 && frmunitId!=9832  && frmunitId!=9830 }">
				<div class="col-md-2"  id="preform20abstract">
				 <%--  <c:out value="${formcontbackdesgId} ,${frmdesgId} "></c:out> --%>
				<button type="button" name="preform20abst" id="preform20abst2" class="btn btn-1 btn-primary center-block " onclick="gettankForm20abstract('${frmYear }', '${prefrm20desgId}','${prefrm20unitId}','${prefrm20circleId}','${prefrm20divisionId}','${prefrm20subdivisionId}','${prefrm20post}','${prefrm20offAccess}','tankform20report2','${fromdate}','${todate}' )"><b>Form20 Previous Abstract Reservoirs</b></button>
				
				</div>	
				</c:if> 
				
			
				
		</div>
								
									<c:if test="${mifrom20resabst!=null}">
		<div class="show-grid gridList "  id="cap-detail-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
				 
						<table class="display table-bordered  table1" id="t-form-1">
							<thead id="t-form-hd-1" >
	                      <tr style="font-size: 12px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                      <th>Office</th>
	                      
	                    
	                      <th>Sum of Approx. Permanent Cost (In Lakhs)</th>
	                      <th>Sum of Approx Temporary Cost (In Lakhs)</th>
	                      <th>Sum of Approx. Total Repairs Cost (In Lakhs)</th>
	                      <!--   <th>Total Book value (In Lakhs)</th> -->
	                      
	                      <th>Form 20 breached reservoir count</th>
	                      <th>Form 20 damaged reservoir count</th>
	                      <th>Form 20 submitted reservoir count</th>
	                      
	                  
							</tr>
							</thead>


							<tbody id="t-form-bd-1">
							
							<tr style="font-size: 12px ; text-align: center; color:red; font-weight: bold;"> 
						<td></td>
						<td >Year/ Date Range</td>
						<c:choose>
									 <c:when test="${fn:length(fromdate)>0 && fn:length(todate)>0}">
									 
									  <td><b> from <c:out value="${fromdate}"></c:out>	to 	<c:out value="${todate}"></c:out>  </b></td>
									 </c:when>
									  
									  <c:when test="${frmYear!=null && frmYear>0 }">
									   <td><b><c:out value="${frmYear}"></c:out></b></td>
									  </c:when>
										<c:otherwise>
										  <td><b></b></td>
										</c:otherwise>
									
                                          </c:choose>
                                          
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td></tr>
							
							<c:forEach items="${mifrom20resabst}" var="f" varStatus="count">		
								
									<tr style="font-size: 12px ; text-align: center;">

										<td ><c:out
												value="${count.count}"></c:out></td>
												<c:if test="${frmdesgId==2 || frmdesgId==8 && frmsubdivId >0}">
											<td><b><c:out value="${f.postName}"></c:out></b></td>	
											</c:if>
											<c:if test="${frmdesgId==4 &&   frmsubdivId >0}">

										<td><b><c:out value="${f.postName}"></c:out></b></td>
										
										</c:if>
										
										<c:if test="${frmdesgId==5 && fmdivId>0 &&    frmsubdivId ==0}">

										<td><button type="button" name="form20tank" id="officeTankfrmr${count.count}" class="btn btn-1 btn-primary center-block"  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report2','${fromdate}','${todate}')"  ><b><c:out value="${f.subDivisionName}"></c:out></b></button></td>
										
										</c:if>
										<c:if test="${frmdesgId==7 && frmunitId>0  && frmcircleId>0 && fmdivId==0 &&    frmsubdivId ==0}">
										
										<td><button type="button" name="form20tank" id="officeTankfrmr${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report2','${fromdate}','${todate}')"  ><b><c:out value="${f.divisionName}"></c:out></b></button></td>
										
										</c:if>
										
										<c:choose>
										
											<c:when test="${frmOffAccess==3}">
											
											
											 <c:if test="${(frmdesgId==9  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) ||
											  (frmdesgId==7  && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&    f.subDivisionId ==0)}">
											  
											
											
                                         <c:if test="${frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830 }">
                                        <!--  This part of code executes when ENC A or I clicks on any unit name and designation Id becomes 9 or 7 -->
                                       <%--   <c:out value="2 CE SE nt ENCA or I"></c:out> --%>
										<td><button type="button" name="form20tank" id="officeTankfrmr${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report2','${fromdate}','${todate}')"  > <b><c:out value="${f.circleName}"></c:out></b></button></td>
										</c:if>
										
										
										</c:if> 
											
											</c:when>
											
											<c:otherwise>
										 <%-- 	<c:out value="not 3 CE SE nt ENCA or I"></c:out>  --%>
											
											<c:if test="${(frmdesgId==9)  && (frmunitId>0 &&  frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0)}">
										 	<%-- <c:out value="normal CE login"></c:out>  --%>
										<td><button type="button" name="officeTankfm" id="officeTankfrmr20${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report2','${fromdate}','${todate}')"  > <b><c:out value="${f.circleName}"></c:out></b></button></td>
										
										</c:if>
											
											</c:otherwise>
										
										</c:choose>
										
										
										
										<c:choose>
										<c:when test="${frmOffAccess==3}">
										<c:if test="${userObj.userName ne 'icad_test'}">
										<c:if test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9   && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&   f.subDivisionId ==0 ) ) }">
										      
										      <%-- <c:out value="${prefrm20desgId}"></c:out>  --%>
										      <c:if test="${prefrm20desgId==null}">

										<td><button type="button" name="officeTankfm" id="officeTankfrmr20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report2','${fromdate}','${todate}')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										 <c:if test="${prefrm20desgId!=null}">

										<td><button type="button" name="officeTankfm" id="officeTankfrmr20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract ('${frmYear }','${prefrm20desgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report2','${fromdate}','${todate}')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										</c:if>
										</c:if>
										
										<c:if test="${userObj.userName eq 'icad_test'}">
										<c:if test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9   && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&   f.subDivisionId ==0 ) ) }">
										      
										      <%-- <c:out value="${prefrm20desgId}"></c:out>  --%>
										      <c:if test="${prefrm20desgId==null}">

										<td> <b><c:out value="${f.unitName}"></c:out></b> </td>
										
										</c:if> 
										 <c:if test="${prefrm20desgId!=null}">

										<td>  <b><c:out value="${f.unitName}"></c:out></b> </td>
										
										</c:if> 
										</c:if>
										</c:if>
										</c:when>
										<c:otherwise>
										
											<c:if test="${(frmdesgId==10  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0)}">

										<td><button type="button" name="officeTankfm" id="officeTankfrmr20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report2','${fromdate}','${todate}')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if>
										
										</c:otherwise>
										
										
									        </c:choose>
										
										
											
											<td><b>${f.sumAprxCostPermt}</b></td>	
											<td><b>${f.sumAprxCostTemp}</b></td>
											<td><b>${f.sumRepairsPermTemp}</b></td>
											<%-- <td><b>${f.sumFmBkValue}</b></td>	 --%>
											
											 <td><b>${f.breachCount}</b></td>
											 
											  <td><b>${f.damageCount}</b></td>
											  
											<!--   sumApxCtPermt,sumAxCtTemp,sumRepsPermTemp -->
											
										<%-- '${frmOffAccess }','${frmOffAccess }',	sumAprxCostPermt,sumAprxCostTemp ,sumRepairsPermTemp<td><b>${f.totalTankCount}</b></td>	 --%>	
										
										 <c:choose>
											<c:when test="${(frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0) }">
										<td><button type="button" name="Form20Tanks" id="Form20Tanksr${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="getForm20reservoirs('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${f.catId}')"  > <b>${f.totalTankCount}</b></button></td>
										
										
										</c:when>
										
										<c:otherwise>
										<td><button type="button" name="Form20Tanks" id="Form20Tanksr${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="getForm20reservoirs('${frmYear }','${frmListdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${f.catId}')"  > <b>${f.totalTankCount}</b></button></td>
										
										
										</c:otherwise>
										
										</c:choose>
										
																			 
											 
											
									
                                          
                                          
                                          

									</tr>

								</c:forEach>
								
										<tr style="color: red ; font-size: 12px; font-weight: bold ; text-align: center;">
								<td>--</td>
								<td>Reservoirs Total</td>
								<td>${restotalApc }</td>
								<td>${restotalAtc }</td>
								<td>${restotalAtr }</td>
								<td>${restotalbc }</td>
								<td>${restotaldc }</td>
								<td>${restotaltc }</td>
								<td></td>
								
								</tr>

							
							</tbody>
							
		</table>
		<c:out value="Note: Approx. Total Repairs Cost= Approx Permament cost + Approx temporary cost "></c:out>
		</div>
		</div>
				
				</c:if>
				
				<c:if test="${miReservoirForm20detail!=null}">
				
				<div class="show-grid gridList "  id="form-detail-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered  table1" id="form-detail-1">
							<thead id="form-detail-hd-1" >
	                      <tr style="font-size: 18px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                       <th>District Name</th>
	                      <th>Mandal Name</th>
	                      <th>Village Name</th>
	                   <!--    <th>Constituency</th> -->
	                     <!--  <th>Unit Name</th>
	                      <th>Circle Name</th>
	                      <th>Division Name</th> -->
	                      <th>Sub Division Name</th>
	                      <th>Reservoir Name</th>
	                       <th>TSFC form Date(dd/mm/YYY)</th>
	                       <th>Damage Type</th>
	                      <!--  <th>Downloads</th> -->
	                        <th>Images/Files</th>
	                     
	                     <!--  <th>Year</th> -->


							</tr>
							</thead>


							<tbody id="form-detail-bd-1">
							
						
							
							<c:forEach items="${miReservoirForm20detail}" var="t" varStatus="count">		
								
									<tr style="font-size: 12px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>								
										<td ><b><c:out value="${t.districtName}"></c:out></b></td>
										<td><b><c:out value="${t.mandalName}"></c:out></b></td>
										<td><b><c:out value="${t.villageName}"></c:out></b></td>
										<%-- <td><b><c:out value="${t.constituencyName}"></c:out></b></td>	 --%>	

										<%-- <td><b><c:out value="${t.unitName}"></c:out></b></td>
										<td><b><c:out value="${t.circleName}"></c:out></b></td>
										<td><b><c:out value="${t.divisionName}"></c:out></b></td> --%>
										<td><b><c:out value="${t.subDivisionName}"></c:out></b></td>
											<td class="micolblue"><b><c:out value="${t.tankName}"></c:out></b></td>
											
										<%-- <td><b><c:out value="${t.tsfcFormDate}"></c:out></b></td> --%>
										
										<td><button type="button" name="form20detailrpt" id="form20detailrpt${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="getForm20DetailReport('${t.formDataId }','${t.catId }','tankform20report2')"  ><b><c:out value="${t.tsfcFormDate}"></c:out></b></button></td>
									<td><b><c:out value="${t.damageTypeName}"></c:out></b></td>
										<%-- <td><button type="button" name="form20detailrpt" id="form20detailrpt${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="getForm20ImagesReport('${t.formDataId }','${t.catId }','tankform20report2')"  ><b>Download Images in pdf</b></button></td> --%>
										
										<td><b><button type="button" name="viewfrmpht" id="viewfrmphtr${count.count}" class="btn btn-1 btn-primary center-block "  onclick="viewfrmphtfnserver(${t.formDataId },'${t.tankName}','tankform20report2')"  >View Photos</button> </b></td>
										<%-- <td><b><c:out value="${t.tsfcFormYear}"></c:out></b></td> --%>
									
									</tr>

								</c:forEach>

							
							</tbody>
		</table>


				</div>
				</div>
				
				</c:if>	
				
									</form:form> 
									</div>  <!-- end of tcab2 -->
									<div id="tcab3" class="col-md-12 ">
									
									<form:form id="tankform20report3" method="post" modelAttribute="mitankform20rpt" >	
	                                   <div class="col-md-12">
	                                    <div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Canals Abstract</strong>
				<br>
				

			</div>
			</div>
			</div>
	                             
	     <c:set var = "frmdesg" scope = "session" value = "${userObj.designationId}"/>	
	      <c:set var = "frmoffacc" scope = "session" value = "1"/>	
	      <c:set var = "frmnewdesg" scope = "session" value = "1"/>	  
					       
	
	  <input name="tsfcFormYear"  class=" form-control " id="frmyear3" type="hidden" />
	  <input name="frmFromDate"  class=" form-control " id="frmdate3" type="hidden" />
	     <input name="frmToDate"  class=" form-control " id="frmtodate3" type="hidden" />
	 
	  <input name="unitId"  class=" form-control " id="frmtempUnitId3" type="hidden" />	
	  <input name="circleId"  class=" form-control " id="frmtempCircleId3" type="hidden" />	
	   <input name="divisionId"  class=" form-control " id="frmtempDivisionId3" type="hidden" /> 
	   <input name="subDivisionId"  class=" form-control " id="frmtempSubDivisionId3" type="hidden" />
	    <input  value="${frmoffacc}"  name="offAccess" class=" form-control " id="frmtempOfficeAccess3" type="hidden" />
	    <input name="postId"  class=" form-control " id="frmtempPostId3" type="hidden" />
	    <input name="designationId"  value="${frmnewdesg}"  class=" form-control " id="frmtempDesignationId3" type="hidden" />
	    <input name="formDataId"    class=" form-control " id="form20DataId3" type="hidden" />
	    <input name="catId"    class=" form-control " id="frmcatId3" type="hidden" />
	     <input name="sourceName"    class=" form-control " id="sourceName3" type="hidden" />
	    
	     <!-- <input name="reportType"   class=" form-control "    id="frmtempreportTypeId" type="hidden" /> -->

	     
	     
	     
	       <!-- values for  for back button  -->	
	     
	     <%--  <input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="logincapUnitId" type="hidden" />
	       <input name="userCircleId" value="${userObj.circleId}" class=" form-control " id="logincapCircleId" type="hidden" />
	        <input name="userDivisionId" value="${userObj.divisionId}" class=" form-control " id="logincapDivisionId" type="hidden" />
	         <input name="userSubdivisionId" value="${userObj.subdivisionId}" class=" form-control " id="logincapSubdivisionId" type="hidden" />
	         --%>
	         <input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="logincapUnitId3" type="hidden" >
	          <input name="userDesignationId" value="${userObj.designationId}" class=" form-control " id="loginfrm20designationId3" type="hidden" />
	         <input name="backdesignationId" value="0" class=" form-control " id="frmbackdesgId3" type="hidden" /> 
	         <input name="listDesignationId"    class=" form-control " id="frmtemplistDesignationId3" type="hidden" />
	         
	         
	         
	         	<div class="row show-grid ">

		
		
		<c:if test="${frmdetailYear!=null}">
		<div class="col-md-12"  id="form20pre">
		
		<button type="button" name="backtoform20intreport" id="backtoform20intreport3" class="btn btn-1 btn-primary center-block " onclick="getform20tankabdata('${frmdetailYear}','${frmdetailFromDate }','${frmdetailToDate }','tankform20main',false )"><b>Back to Initial Abstract Data</b></button>				
				</div>	
				</c:if>
				
			<%--  <c:if test="${formcontbackdesgId!=0 && formcontbackdesgId!=null  &&  formcontbackdesgId>capdesgId && capunitId!=4 && capunitId!=9832  }"> --%>
				
				<!-- && frmunitId!=4 && frmunitId!=9832  -->
			 <c:if test="${formcontbackdesgId!=0 && formcontbackdesgId!=null  && prefrm20year!=null &&  formcontbackdesgId>frmdesgId && frmunitId!=4 && frmunitId!=9832  && frmunitId!=9830 }">
				<div class="col-md-2"  id="preform20abstract">
				 <%--  <c:out value="${formcontbackdesgId} ,${frmdesgId} "></c:out> --%>
				<button type="button" name="preform20abst" id="preform20abst3" class="btn btn-1 btn-primary center-block " onclick="gettankForm20abstract('${frmYear }', '${prefrm20desgId}','${prefrm20unitId}','${prefrm20circleId}','${prefrm20divisionId}','${prefrm20subdivisionId}','${prefrm20post}','${prefrm20offAccess}','tankform20report3','${fromdate}','${todate}' )"><b>Form20 Previous Abstract Canal</b></button>
				
				</div>	
				</c:if> 
				
			
				
		</div>
								
									<c:if test="${mifrom20canalabst!=null}">
		<div class="show-grid gridList "  id="cap-detail-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
				 
						<table class="display table-bordered  table1" id="t-form-1">
							<thead id="t-form-hd-1" >
	                      <tr style="font-size: 12px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                      <th>Office</th>
	                      
	                    
	                      <th>Sum of Approx. Permanent Cost (In Lakhs)</th>
	                      <th>Sum of Approx Temporary Cost (In Lakhs)</th>
	                      <th>Sum of Approx. Total Repairs Cost (In Lakhs)</th>
	                      <!--   <th>Total Book value (In Lakhs)</th> -->
	                      
	                      <th>Form 20 breached canals count</th>
	                      <th>Form 20 damaged canals count</th>
	                      <th>Form 20 submitted canals count</th>
	                      
	               
							</tr>
							</thead>


							<tbody id="t-form-bd-1">
							
								<tr style="font-size: 12px ; text-align: center;color:red; font-weight: bold;"> 
						<td></td>
						<td >Year/ Date Range</td>
						<c:choose>
									 <c:when test="${fn:length(fromdate)>0 && fn:length(todate)>0}">
									 
									  <td><b> from <c:out value="${fromdate}"></c:out>       to     <c:out value="${todate}"></c:out>  </b></td>
									 </c:when>
									  
									  <c:when test="${frmYear!=null && frmYear>0 }">
									   <td><b><c:out value="${frmYear}"></c:out></b></td>
									  </c:when>
										<c:otherwise>
										  <td><b></b></td>
										</c:otherwise>
									
                                          </c:choose>
                                          
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td></tr>
						
							
							<c:forEach items="${mifrom20canalabst}" var="f" varStatus="count">		
								
									<tr style="font-size: 12px ; text-align: center;">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>
												<c:if test="${frmdesgId==2 || frmdesgId==8 && frmsubdivId >0}">
											<td><b><c:out value="${f.postName}"></c:out></b></td>	
											</c:if>
											<c:if test="${frmdesgId==4 &&   frmsubdivId >0}">

										<td><b><c:out value="${f.postName}"></c:out></b></td>
										
										</c:if>
										
										<c:if test="${frmdesgId==5 && fmdivId>0 &&    frmsubdivId ==0}">

										<td><button type="button" name="form20tank" id="officeTankfrmc${count.count}" class="btn btn-1 btn-primary center-block"  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report3','${fromdate}','${todate}')"  ><b><c:out value="${f.subDivisionName}"></c:out></b></button></td>
										
										</c:if>
										<c:if test="${frmdesgId==7 && frmunitId>0  && frmcircleId>0 && fmdivId==0 &&    frmsubdivId ==0}">
										
										<td><button type="button" name="form20tank" id="officeTankfrmc${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report3','${fromdate}','${todate}')"  ><b><c:out value="${f.divisionName}"></c:out></b></button></td>
										
										</c:if>
										
										<c:choose>
										
											<c:when test="${frmOffAccess==3}">
											
											
											 <c:if test="${(frmdesgId==9  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) ||
											  (frmdesgId==7  && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&    f.subDivisionId ==0)}">
											  
											
											
                                         <c:if test="${frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830 }">
                                        <!--  This part of code executes when ENC A or I clicks on any unit name and designation Id becomes 9 or 7 -->
                                       <%--   <c:out value="2 CE SE nt ENCA or I"></c:out> --%>
										<td><button type="button" name="form20tank" id="officeTankfrmc${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report3','${fromdate}','${todate}')"  > <b><c:out value="${f.circleName}"></c:out></b></button></td>
										</c:if>
										
										
										</c:if> 
											
											</c:when>
											
											<c:otherwise>
										 <%-- 	<c:out value="not 3 CE SE nt ENCA or I"></c:out>  --%>
											
											<c:if test="${(frmdesgId==9)  && (frmunitId>0 &&  frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0)}">
										 	<%-- <c:out value="normal CE login"></c:out>  --%>
										<td><button type="button" name="officeTankfm" id="officeTankfrmc20${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report3','${fromdate}','${todate}')"  > <b><c:out value="${f.circleName}"></c:out></b></button></td>
										
										</c:if>
											
											</c:otherwise>
										
										</c:choose>
										
										
										
										<c:choose>
										<c:when test="${frmOffAccess==3}">
										<c:if test="${userObj.userName ne 'icad_test'}">
										<c:if test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9   && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&   f.subDivisionId ==0 ) ) }">
										      
										      <%-- <c:out value="${prefrm20desgId}"></c:out>  --%>
										      <c:if test="${prefrm20desgId==null}">

										<td><button type="button" name="officeTankfm" id="officeTankfrmc20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report3','${fromdate}','${todate}')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										 <c:if test="${prefrm20desgId!=null}">

										<td><button type="button" name="officeTankfm" id="officeTankfrmc20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract ('${frmYear }','${prefrm20desgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report3','${fromdate}','${todate}')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										</c:if>
										</c:if>
										
										<c:if test="${userObj.userName eq 'icad_test'}">
										<c:if test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9   && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&   f.subDivisionId ==0 ) ) }">
										      
										      <%-- <c:out value="${prefrm20desgId}"></c:out>  --%>
										      <c:if test="${prefrm20desgId==null}">

										<td> <b><c:out value="${f.unitName}"></c:out></b> </td>
										
										</c:if> 
										 <c:if test="${prefrm20desgId!=null}">

										<td>  <b><c:out value="${f.unitName}"></c:out></b> </td>
										
										</c:if> 
										</c:if>
										</c:if>
										
										
										</c:when>
										<c:otherwise>
										
											<c:if test="${(frmdesgId==10  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0)}">

										<td><button type="button" name="officeTankfm" id="officeTankfrmc20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }','tankform20report3','${fromdate}','${todate}')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if>
										
										</c:otherwise>
										
										
									        </c:choose>
										
										
											
											<td><b>${f.sumAprxCostPermt}</b></td>	
											<td><b>${f.sumAprxCostTemp}</b></td>
											<td><b>${f.sumRepairsPermTemp}</b></td>
											<%-- <td><b>${f.sumFmBkValue}</b></td>	 --%>
											
											 <td><b>${f.breachCount}</b></td>
											 
											  <td><b>${f.damageCount}</b></td>
											  
											<!--   sumApxCtPermt,sumAxCtTemp,sumRepsPermTemp -->
											
										<%-- '${frmOffAccess }','${frmOffAccess }'	sumAprxCostPermt,sumAprxCostTemp ,sumRepairsPermTemp<td><b>${f.totalTankCount}</b></td>	 --%>	
										
										 <c:choose>
											<c:when test="${(frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0) }">
										<td><button type="button" name="Form20Tanks" id="Form20Tanksc${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="getForm20canals('${frmYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${f.catId }')"  > <b>${f.totalTankCount}</b></button></td>
										
										
										</c:when>
										
										<c:otherwise>
										<td><button type="button" name="Form20Tanks" id="Form20Tanksc${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="getForm20canals('${frmYear }','${frmListdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${f.catId }')"  > <b>${f.totalTankCount}</b></button></td>
										
										
										</c:otherwise>
										
										</c:choose>
										
																			 
											 
											
									
                                         
                                          

									</tr>

								</c:forEach>
								
								<tr style="color: red ; font-size: 12px ; font-weight: bold; text-align: center;">
								<td>--</td>
								<td>Canals Total</td>
								<td>${cantotalApc }</td>
								<td>${cantotalAtc }</td>
								<td>${cantotalAtr }</td>
								<td>${cantotalbc }</td>
								<td>${cantotaldc }</td>
								<td>${cantotaltc }</td>
								<td></td>
								
								</tr>
								

							
							</tbody>
							
		</table>
		<c:out value="Note: Approx. Total Repairs Cost= Approx Permament cost + Approx temporary cost "></c:out>
		</div>
		</div>
				
				</c:if>
				
				<c:if test="${miCanalForm20detail!=null}">
				
				<div class="show-grid gridList "  id="form-detail-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered  table1" id="form-detail-1">
							<thead id="form-detail-hd-1" >
	                      <tr style="font-size: 12px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                       <th>District Name</th>
	                      <th>Mandal Name</th>
	                      <th>Village Name</th>
	                    <!--   <th>Constituency</th> -->
	                     <!--  <th>Unit Name</th>
	                      <th>Circle Name</th>
	                      <th>Division Name</th> -->
	                      <th>Sub Division Name</th>
	                      <th>Canal Name</th>
	                       <th>TSFC form Date(dd/mm/YYY)</th>
	                       <th>Damage Type</th>
	                     <!--   <th>Downloads</th> -->
	                        <th>Images/Files</th>
	                     
	                     <!--  <th>Year</th> -->


							</tr>
							</thead>


							<tbody id="form-detail-bd-1">
							
						
							
							<c:forEach items="${miCanalForm20detail}" var="t" varStatus="count">		
								
									<tr style="font-size: 12px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>								
										<td ><b><c:out value="${t.districtName}"></c:out></b></td>
										<td><b><c:out value="${t.mandalName}"></c:out></b></td>
										<td><b><c:out value="${t.villageName}"></c:out></b></td>
										<%-- <td><b><c:out value="${t.constituencyName}"></c:out></b></td>	 --%>	

										<%-- <td><b><c:out value="${t.unitName}"></c:out></b></td>
										<td><b><c:out value="${t.circleName}"></c:out></b></td>
										<td><b><c:out value="${t.divisionName}"></c:out></b></td> --%>
										<td><b><c:out value="${t.subDivisionName}"></c:out></b></td>
											<td class="micolblue"><b><c:out value="${t.tankName}"></c:out></b></td>
											
										<%-- <td><b><c:out value="${t.tsfcFormDate}"></c:out></b></td> --%>
										
										<td><button type="button" name="form20detailrpt" id="form20detailrpt${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="getForm20DetailReport('${t.formDataId }','${t.catId }','tankform20report3')"  ><b><c:out value="${t.tsfcFormDate}"></c:out></b></button></td>
									<td><b><c:out value="${t.damageTypeName}"></c:out></b></td>
										<%-- <td><button type="button" name="form20detailrpt" id="form20detailrpt${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="getForm20ImagesReport('${t.formDataId }','${t.catId }','tankform20report3')"  ><b>Download Images in pdf</b></button></td> --%>
										
										<td><b><button type="button" name="viewfrmpht" id="viewfrmphtr${count.count}" class="btn btn-1 btn-primary center-block "  onclick="viewfrmphtfnserver(${t.formDataId },'${t.tankName}','tankform20report3')"  >View Photos</button> </b></td>
										<%-- <td><b><c:out value="${t.tsfcFormYear}"></c:out></b></td> --%>
									
									</tr>

								</c:forEach>

							
							</tbody>
		</table>


				</div>
				</div>
				
				</c:if>	
				
									</form:form> 
									
									
									 </div>  <!-- end of tcab3 --> 
									</div>  <!-- end of abs1 -->
									


	                                      
											
						
					
				
			
				</div>   <!-- panel body  div  -->
					</div>   <!-- panel primary   div  --> <!--  panel ends here -->
				</div>
				

			 
			<!-- /.col-md-9 -->


		</div>
		<!-- row -->
		
		





		
	 <!-- <a id="popit" Style="display:none;" href="0" title=""></a>	  -->
	 



		
	<!-- 	<div id="di-rp"   >
			
		 <div id="rpnew">

  </div>
	
		
</div> -->
	   

		
<div id="frm20_doc_dia">

<form:form id="frm_doc_dia" method="post" modelAttribute="frm_doc_dia_new"
		name="frmdescformdata" data-parsley-validate-if-empty="" target="_blank"
		enctype="multipart/form-data">

<div id="docfrm20">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display  table-bordered" style="width: 100%"
											id="doc-frm-table-10">
											<thead id="doc-thead10">

											</thead>


											<tbody id="doc-tbody10">

											</tbody>
										</table>
									</div>


								</div>
							</div>



 </form:form>

</div>	

	




<script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.print.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>
		<script src="../js/Html5DataTable/buttons.colVis.min.js" type="text/javascript"></script>
		 <script src="../js/Html5DataTable/buttons.html5.new.js" type="text/javascript"></script> 
	
	
	
<script type="text/javascript">			
							
    $('.table1').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "ordering": false,
        "autoWidth": true,
        "lengthChange": false,
        "pageLength": 20,
        "scrollY": 400,
        "scrollX": true,
        buttons: [
             {
                extend: 'copyHtml5',
                text:  'Copy Data',
                exportOptions: {
                    columns: [ 0, ':visible' ]
                }
            },
            {
                extend: 'excelHtml5',
                autoFilter: true,
                sheetName: 'form20',
                text:  'Download Data To Excel',
                className: 'btn-primary ',
                messageTop: 'form20',
                exportOptions: {
                    columns: ':visible'
                }
               
                
            },
            
            {
                extend: 'pdfHtml5',
                className: 'btn-primary ',
                text:  'PDF View / Download',
                orientation: 'landscape',
                pageSize: 'A4',
                download: 'open',
                font:'10',
                filename: 'form20',
                exportOptions: {
					columns: ':visible'
					
				},
				 
               
                title: 'T.S.F.C. FormNo.20',
                customize: function (doc) {
                	doc.defaultStyle.fontfamily ='Arial';
                	
                	doc.defaultStyle.fontSize = 10;
                	doc.defaultStyle.alignment = 'center';
                	doc.styles.tableHeader.fontSize = 12;
                	doc.pageMargins = [80, 80, 80,80];
                	 doc['footer']=(function(page, pages) {
                      	return {
                      	columns: [
                     
                      	{
                      	alignment: 'right',
                      	text: [
                      	{ text: page.toString(), italics: true },
                      	' of ',
                      	{ text: pages.toString(), italics: true }
                      	]
                      	}
                      	],
                      	margin: [5, 0]
                      	}
                      	});
      				
                	
                	
                	
                }
				
               
            },
            {
                extend: 'print',
                text: 'Print All',
                className: 'btn-primary ',
                exportOptions: {
                    modifier: {
                        selected: null
                    },
                    columns: ':visible'
                }
               
                
                
            },
            ,{
                extend: 'print',
                text: 'Print Selected',
                className: 'btn-primary ',
                exportOptions: {
                    columns: ':visible'
                }
                
                
                
            },
            {
                extend: 'colvis',
                text: 'Exclude for Print/Export',
                
                columnText: function ( dt, idx, title ) {
                    return title;
                }
               
                }
        ],
        select: true
       
    } );
    
    </script>	
    
    <script type="text/javascript" src="../js/parsley.js"></script>

<!-- Chart code -->
<script>
am4core.ready(function() {

// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

/**
 * Define data for each year
 */
var chartData = {
  
  "2022": [
    { "sector": "Tanks", "size": 538 },
    { "sector": "Reservoirs", "size": 11 },
    { "sector": "Canals", "size": 124 }
    ],
    
    "2023": [
             { "sector": "Tanks", "size": 690 },
             { "sector": "Reservoirs", "size": 8 },
             { "sector": "Canals", "size": 202 }
 ]
    
};

// Create chart instance
var chart = am4core.create("chartdiv", am4charts.PieChart);

// Add data
chart.data = [
  { "sector": "Tanks", "size": 538 },
  { "sector": "Reservoirs", "size": 11 },
  { "sector": "Canals", "size": 124 },
  
];

// Add label
chart.innerRadius = 100;
var label = chart.seriesContainer.createChild(am4core.Label);
label.text = "2022";
label.horizontalCenter = "middle";
label.verticalCenter = "middle";
label.fontSize = 50;

// Add and configure Series
var pieSeries = chart.series.push(new am4charts.PieSeries());
pieSeries.dataFields.value = "size";
pieSeries.dataFields.category = "sector";

// Animate chart data
var currentYear = 2022;
function getCurrentData() {
  label.text = currentYear;
  var data = chartData[currentYear];
  currentYear++;
  if (currentYear > 2023)
    currentYear = 2022;
  return data;
}

function loop() {
  //chart.allLabels[0].text = currentYear;
  var data = getCurrentData();
  for(var i = 0; i < data.length; i++) {
    chart.data[i].size = data[i].size;
  }
  chart.invalidateRawData();
  chart.setTimeout( loop, 10000 );
}

loop();

}); // end am4core.ready()
</script>


<script>
am4core.ready(function() {

// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

var chart = am4core.create("chartdiv1", am4charts.XYChart);
chart.padding(40, 40, 40, 40);

chart.numberFormatter.bigNumberPrefixes = [
  { "number": 1e+3, "suffix": "K" },
  { "number": 1e+6, "suffix": "M" },
  { "number": 1e+9, "suffix": "B" }
];

var label = chart.plotContainer.createChild(am4core.Label);
label.x = am4core.percent(97);
label.y = am4core.percent(95);
label.horizontalCenter = "right";
label.verticalCenter = "middle";
label.dx = -15;
label.fontSize = 50;

var playButton = chart.plotContainer.createChild(am4core.PlayButton);
playButton.x = am4core.percent(97);
playButton.y = am4core.percent(95);
playButton.dy = -2;
playButton.verticalCenter = "middle";
playButton.events.on("toggled", function(event) {
  if (event.target.isActive) {
    play();
  }
  else {
    stop();
  }
})

var stepDuration = 10000;

var categoryAxis = chart.yAxes.push(new am4charts.CategoryAxis());
categoryAxis.renderer.grid.template.location = 0;
categoryAxis.dataFields.category = "Category";
categoryAxis.renderer.minGridDistance = 1;
categoryAxis.renderer.inversed = true;
categoryAxis.renderer.grid.template.disabled = true;

var valueAxis = chart.xAxes.push(new am4charts.ValueAxis());
valueAxis.min = 0;
valueAxis.rangeChangeEasing = am4core.ease.linear;
valueAxis.rangeChangeDuration = stepDuration;
valueAxis.extraMax = 0.1;

var series = chart.series.push(new am4charts.ColumnSeries());
series.dataFields.categoryY = "Category";
series.dataFields.valueX = "Number";
series.tooltipText = "{valueX.value}"
series.columns.template.strokeOpacity = 0;
series.columns.template.column.cornerRadiusBottomRight = 5;
series.columns.template.column.cornerRadiusTopRight = 5;
series.interpolationDuration = stepDuration;
series.interpolationEasing = am4core.ease.linear;

var labelBullet = series.bullets.push(new am4charts.LabelBullet())
labelBullet.label.horizontalCenter = "right";
labelBullet.label.text = "{values.valueX.workingValue.formatNumber('#.0as')}";
labelBullet.label.textAlign = "end";
labelBullet.label.dx = -10;

chart.zoomOutButton.disabled = true;

// as by default columns of the same series are of the same color, we add adapter which takes colors from chart.colors color set
series.columns.template.adapter.add("fill", function(fill, target){
  return chart.colors.getIndex(target.dataItem.index);
});

var year = 2022;
label.text = year.toString();

var interval;

function play() {
  interval = setInterval(function(){
    nextYear();
  }, stepDuration)
  nextYear();
}

function stop() {
  if (interval) {
    clearInterval(interval);
  }
}

function nextYear() {
  year++

  if (year > 2023) {
    year = 2022;
  }

  var newData = allData[year];
  var itemsWithNonZero = 0;
  for (var i = 0; i < chart.data.length; i++) {
    chart.data[i].Number = newData[i].Number;
    if (chart.data[i].Number > 0) {
      itemsWithNonZero++;
    }
  }

  if (year == 2023) {
    series.interpolationDuration = stepDuration / 4;
    valueAxis.rangeChangeDuration = stepDuration / 4;
  }
  else {
    series.interpolationDuration = stepDuration;
    valueAxis.rangeChangeDuration = stepDuration;
  }

  chart.invalidateRawData();
  label.text = year.toString();

  categoryAxis.zoom({ start: 0, end: itemsWithNonZero / categoryAxis.dataItems.length });
}


categoryAxis.sortBySeries = series;

var allData = {
  "2022": [
    {
      "Category": "Tanks",
      "Number": 538
    },
    {
      "Category": "Reservoir",
      "Number": 11
    },
    {
      "Category": "Canals",
      "Number": 128
    }

   
  ],
  "2023": [
    {
      "Category": "Tanks",
      "Number": 690
    },
    {
      "Category": "Reservoir",
      "Number": 8
    },
    {
      "Category": "Canals",
      "Number": 202
    }

  
  ]
  
}

chart.data = JSON.parse(JSON.stringify(allData[year]));
categoryAxis.zoom({ start: 0, end: 1 / chart.data.length });

series.events.on("inited", function() {
  setTimeout(function() {
    playButton.isActive = true; // this starts interval
  }, 6000)
})

}); // end am4core.ready()
</script>

<script>

var url = "../invrest/repeatedTanksBreach"

	var newdata = []; 

 /* $.getJSON(url,function(onSuccessData){ 
	alert(onSuccessData); 
	
	newdata=onSuccessData;
	
	alert("newdata"+newdata);
	$.each(onSuccessData, function(index, item) {
        jsonArray.push(item);
    });
	
	alert("jsonArray"+jsonArray)

    // Now 'jsonArray' contains the data from the server, you can process it further if needed
    console.log(jsonArray);
	
	}); */


	am4core.ready(function() {
	    // Themes begin
	    am4core.useTheme(am4themes_animated);
	    am4core.options.autoDispose = true;
	    // Themes end

	    // Create chart instance
	    var chart = am4core.create("chartdiv2", am4charts.XYChart);

	    // Create axes
	    var categoryAxis = chart.yAxes.push(new am4charts.CategoryAxis());
	    categoryAxis.dataFields.category = "name";
	    categoryAxis.renderer.grid.template.disabled = true;
	    categoryAxis.renderer.minGridDistance = 15;
	    categoryAxis.renderer.inside = false;
	    
	    
	    categoryAxis.renderer.labels.template.wrap = true;
	    categoryAxis.renderer.labels.template.fill = am4core.color("#000");
	    categoryAxis.renderer.labels.template.fontSize = 11;
	    categoryAxis.renderer.inversed = true;
	    //categoryAxis.renderer.labels.template.rotation = 90; // Rotate labels
	   // categoryAxis.renderer.labels.template.horizontalCenter = "left";
	    //categoryAxis.renderer.labels.template.verticalCenter = "middle";
	   // categoryAxis.renderer.labels.template.paddingTop = 0;
	   // categoryAxis.renderer.labels.template.paddingRight = 10;
	    
	   
	    //categoryAxis.renderer.labels.rotation = 270;

	    var valueAxis = chart.xAxes.push(new am4charts.ValueAxis());
	    valueAxis.renderer.grid.template.strokeDasharray = "4,4";
	    
	    valueAxis.renderer.opposite = true;
	    
	   
	    valueAxis.renderer.labels.template.disabled = false;
	    
	    //valueAxis.renderer.labels.template.rotation = -90;
	    //valueAxis.renderer.labels.template.horizontalCenter = "right";
	   // valueAxis.renderer.labels.template.verticalCenter = "middle";
	   // valueAxis.renderer.labels.template.maxWidth = 120;
	  //  valueAxis.renderer.labels.template.wrap = true;
	 // valueAxis.min = 0;

	    // Do not crop bullets
	    chart.maskBullets = false;

	    // Remove padding
	    chart.paddingBottom = 0;

	    // Create series
	    var series = chart.series.push(new am4charts.ColumnSeries());
	    series.dataFields.valueX = "points";
	    series.dataFields.categoryY = "name";
	    series.columns.template.propertyFields.fill = "color";
	    series.columns.template.propertyFields.stroke = "color";
	    series.columns.template.column.cornerRadiusTopLeft = 10;
	    series.columns.template.column.cornerRadiusTopRight = 10;
	    series.columns.template.tooltipText = "{categoryY}: [bold]{valueX}[/b]";

	    // Add bullets
	    var bullet = series.bullets.push(new am4charts.Bullet());
	    var image = bullet.createChild(am4core.Image);
	    image.horizontalCenter = "middle";
	    image.verticalCenter = "bottom";
	    image.dy = 10;
	    image.y = am4core.percent(100);
	    image.propertyFields.href = "bullet";
	    image.tooltipText = series.columns.template.tooltipText;
	    image.propertyFields.fill = "color";
	    image.filters.push(new am4core.DropShadowFilter());
	    
	   // chart.plotContainer.rotation = 90;

	    // Fetch data
	    $.getJSON(url, function(json) {
	        // Assign data to chart
	        chart.data = json.map(function(item) {
	            return {
	                "name": item.repeatedTankName,
	                "points": parseInt(item.totalTankCount),
	                "color": chart.colors.next(),
	                "bullet": getImageURLForCategory(item.repeatedCatId)
	            };
	        });
	    });
	    
	    
	 // Function to get image URL based on category
	    function getImageURLForCategory(category) {
	        // Write your logic to determine the image URL based on the category
	        // Example:
	        	//alert("category"+category)
	        if (parseInt(category) === 1) {
	            return "../images/shamirpet_lake.jpg";
	        } else if (parseInt(category) === 2) {
	            return "../images/reservoir-1-64.png";
	        } else if (parseInt(category) === 3) {
	            return "../images/srsp_floodflow_canal.jpg";
	        } else {
	            return "../images/reservoir-1-64.png";
	        }
	    }
	 
	 //start of export 
	    chart.cursor = new am4charts.XYCursor();
		chart.cursor.lineX.strokeOpacity = 0;
		chart.cursor.lineY.strokeOpacity = 0;
		
		chart.exporting.menu = new am4core.ExportMenu();
		chart.exporting.menu.align = "right";
		chart.exporting.menu.verticalAlign = "top";
		
		//
		
		var title = chart.titles.create();
		title.text = "Status";
		title.disabled = true;
		chart.exporting.events.on("exportstarted", function(ev) {
			  title.disabled = false;
			  title.parent.invalidate();
			});

			// Disable title when export finishes
		/*	chart.exporting.events.on("exportfinished", function(ev) {
			  title.disabled = true;
			});
*/
			// Add title to validated sprites
			chart.exporting.validateSprites.push(title);
			chart.exporting.validateSprites.push(title.parent);
		/*chart.exporting=[{
			"exporting": {
			    "menu": {
			      // No need to specify `type`, since
			      // there's only one type of `ExportMenu`
			    }
			  }
		}]*/
		chart.exporting.menu.items = [{
			
			"label": "Exp",
			"titles": [{
			    "text": "Speed",
			    "fontSize": 25,
			    "marginBottom": 30
			  }],
			 // "icon": "../images/download_image.png",
		    "menu": [
		      {
		    	
		        "label": "Image",
		        "menu": [
		          { "type": "png", "label": "PNG" },
		          { "type": "jpg", "label": "JPG" },
		         
		          { "type": "pdf", "label": "PDF" }
		        ]
		      }, {
		        "label": "Data",
		        "menu": [
		         
		         
		          { "type": "xlsx", "label": "XLSX" },
		         
		          { "type": "pdfdata", "label": "PDF" }
		        ]
		      }, {
		        "label": "Print", "type": "print"
		      }
		    ]
			
			}];
		
		
		
		var options = chart.exporting.getFormatOptions("pdf");
		options.addURL = false;
		options.pivot = true;
		options.pageOrientation='landscape'; 
		options.pageSize ="A4";
		chart.exporting.setFormatOptions("pdf", options);
		
		var options2 = chart.exporting.getFormatOptions("pdfdata");
		options2.addURL = false;
		options2.pivot=true;
		chart.exporting.setFormatOptions("pdfdata", options2);
		
		var options3 = chart.exporting.getFormatOptions("xlsx");		
		options3.pivot=true;
		chart.exporting.setFormatOptions("xlsx", options3);
		
		chart.exporting.adapter.add("pdfmakeDocument", function(pdf, target) {

			  // Add title to the beginning
			
			  pdf.doc.content.unshift({

					alignment: 'justify',
				  
			    text: "Abstract",
			    margin: [90, 30],
			    style: {
			      fontSize: 25,
			      bold: true,
			    }
			  
			 
			  });

			  return pdf;
			});
		
		chart.exporting.filePrefix = "Abstract";
	 
	    
	});

</script>


<script>

var url2 = "../invrest/repeatedTanksDamage"

	

 /* $.getJSON(url,function(onSuccessData){ 
	alert(onSuccessData); 
	
	newdata=onSuccessData;
	
	alert("newdata"+newdata);
	$.each(onSuccessData, function(index, item) {
        jsonArray.push(item);
    });
	
	alert("jsonArray"+jsonArray)

    // Now 'jsonArray' contains the data from the server, you can process it further if needed
    console.log(jsonArray);
	
	}); */


	am4core.ready(function() {
	    // Themes begin
	    am4core.useTheme(am4themes_animated);
	    am4core.options.autoDispose = true;
	    // Themes end

	    // Create chart instance
	    var chart = am4core.create("chartdiv3", am4charts.XYChart);

	    // Create axes
	    var categoryAxis = chart.yAxes.push(new am4charts.CategoryAxis());
	    categoryAxis.dataFields.category = "name";
	    categoryAxis.renderer.grid.template.disabled = true;
	    categoryAxis.renderer.minGridDistance = 15;
	    categoryAxis.renderer.inside = false;
	    categoryAxis.renderer.labels.template.wrap = true;
	    categoryAxis.renderer.labels.template.fill = am4core.color("#000");
	    categoryAxis.renderer.labels.template.fontSize = 11;
	    categoryAxis.renderer.inversed = true;
	   
	  

	    var valueAxis = chart.xAxes.push(new am4charts.ValueAxis());
	    //valueAxis.renderer.grid.template.strokeDasharray = "4,4";
	    //valueAxis.renderer.labels.template.disabled = true;
	   // valueAxis.min = 0;
	    valueAxis.renderer.opposite = true;
	    
	    //valueAxis.renderer.labels.template.rotation = 0; // Rotate labels
	   // valueAxis.renderer.labels.template.horizontalCenter = "right";
	   // valueAxis.renderer.labels.template.verticalCenter = "middle";
	   // valueAxis.renderer.labels.template.fontSize = 11;
	    
	    
	    //valueAxis.renderer.labels.template.fill = am4core.color("#000");
	   // valueAxis.renderer.labels.template.fontSize = 11;
	   
	  
	    // Do not crop bullets
	    chart.maskBullets = false;

	    // Remove padding
	    chart.paddingBottom = 0;

	    // Create series
	    var series = chart.series.push(new am4charts.ColumnSeries());
	    series.dataFields.valueX = "points";
	    series.dataFields.categoryY = "name";
	    series.columns.template.propertyFields.fill = "color";
	    series.columns.template.propertyFields.stroke = "color";
	    series.columns.template.column.cornerRadiusTopLeft = 10;
	    series.columns.template.column.cornerRadiusTopRight = 10;
	    series.columns.template.tooltipText = "{categoryY}: [bold]{valueX}[/b]";

	    // Add bullets
	    var bullet = series.bullets.push(new am4charts.Bullet());
	    var image = bullet.createChild(am4core.Image);
	    image.horizontalCenter = "middle";
	    image.verticalCenter = "bottom";
	    image.dy = 10;
	    image.y = am4core.percent(100);
	    image.propertyFields.href = "bullet";
	    image.tooltipText = series.columns.template.tooltipText;
	    image.propertyFields.fill = "color";
	    image.filters.push(new am4core.DropShadowFilter());
       
	   // chart.plotContainer.rotation = 90;
	    // Fetch data
	    $.getJSON(url2, function(json) {
	        // Assign data to chart
	        chart.data = json.map(function(item) {
	            return {
	                "name": item.repeatedTankName,
	                "points": parseInt(item.totalTankCount),
	                "color": chart.colors.next(),
	                "bullet": getImageURLForCategory(item.repeatedCatId)
	            };
	        });
	    });
	    
	    
	 // Function to get image URL based on category
	    function getImageURLForCategory(category) {
	        // Write your logic to determine the image URL based on the category
	        // Example:
	        	//alert("category"+category)
	        if (parseInt(category) === 1) {
	            return "../images/shamirpet_lake.jpg";
	        } else if (parseInt(category) === 2) {
	            return "../images/reservoir-1-64.png";
	        } else if (parseInt(category) === 3) {
	            return "../images/srsp_floodflow_canal.jpg";
	        } else {
	            return "../images/reservoir-1-64.png";
	        }
	    }
	 
	 //start of export
	 
	    chart.cursor = new am4charts.XYCursor();
		chart.cursor.lineX.strokeOpacity = 0;
		chart.cursor.lineY.strokeOpacity = 0;
		
		chart.exporting.menu = new am4core.ExportMenu();
		chart.exporting.menu.align = "right";
		chart.exporting.menu.verticalAlign = "top";
		
		//
		
		var title = chart.titles.create();
		title.text = "Status";
		title.disabled = true;
		chart.exporting.events.on("exportstarted", function(ev) {
			  title.disabled = false;
			  title.parent.invalidate();
			});

			// Disable title when export finishes
		/*	chart.exporting.events.on("exportfinished", function(ev) {
			  title.disabled = true;
			});
*/
			// Add title to validated sprites
			chart.exporting.validateSprites.push(title);
			chart.exporting.validateSprites.push(title.parent);
		/*chart.exporting=[{
			"exporting": {
			    "menu": {
			      // No need to specify `type`, since
			      // there's only one type of `ExportMenu`
			    }
			  }
		}]*/
		chart.exporting.menu.items = [{
			
			"label": "Exp",
			"titles": [{
			    "text": "Speed",
			    "fontSize": 25,
			    "marginBottom": 30
			  }],
			 // "icon": "../images/download_image.png",
		    "menu": [
		      {
		    	
		        "label": "Image",
		        "menu": [
		          { "type": "png", "label": "PNG" },
		          { "type": "jpg", "label": "JPG" },
		         
		          { "type": "pdf", "label": "PDF" }
		        ]
		      }, {
		        "label": "Data",
		        "menu": [
		         
		         
		          { "type": "xlsx", "label": "XLSX" },
		         
		          { "type": "pdfdata", "label": "PDF" }
		        ]
		      }, {
		        "label": "Print", "type": "print"
		      }
		    ]
			
			}];
		
		
		
		var options = chart.exporting.getFormatOptions("pdf");
		options.addURL = false;
		options.pivot = true;
		options.pageOrientation='landscape'; 
		options.pageSize ="A4";
		chart.exporting.setFormatOptions("pdf", options);
		
		var options2 = chart.exporting.getFormatOptions("pdfdata");
		options2.addURL = false;
		options2.pivot=true;
		chart.exporting.setFormatOptions("pdfdata", options2);
		
		var options3 = chart.exporting.getFormatOptions("xlsx");		
		options3.pivot=true;
		chart.exporting.setFormatOptions("xlsx", options3);
		
		chart.exporting.adapter.add("pdfmakeDocument", function(pdf, target) {

			  // Add title to the beginning
			
			  pdf.doc.content.unshift({

					alignment: 'justify',
				  
			    text: "Abstract",
			    margin: [90, 30],
			    style: {
			      fontSize: 25,
			      bold: true,
			    }
			  
			 
			  });

			  return pdf;
			});
		
		chart.exporting.filePrefix = "Abstract";
	
		
	});

</script>
	
