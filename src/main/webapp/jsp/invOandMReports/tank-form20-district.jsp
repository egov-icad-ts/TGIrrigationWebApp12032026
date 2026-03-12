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
	
	<!-- <script type="text/javascript" src="../js/invomReports/form20_report.js"></script> -->

<style>
#chartdiv {
  width: 100%;
  height: 600px;
}

</style>

<script >

function gettankForm20abstract( year) {
	
	//alert("year"+year)
	
	// designation, unit, circle,
	//	division, subdivision, post, officeaccess

	//alert("gettankForm20abstract "+year+"designation"+designation+"unit"+unit+"circle"+circle+"division"+ division+ "subdivision"+subdivision+"post"+post+"OA"+officeaccess);
/* 
	var unit = unit;
	var circle = circle;
	var division = division;
	var subdivision = subdivision;
	var userdesignation = $("#uformDesignationId").val();
	//alert("userdesignation"+userdesignation);
	var designation = designation;

	var post = post;
	var officeaccessn = officeaccess; */

	/* if (officeaccess == 1 && officeaccess != 2) {
		if (designation == 5) {
			newdesignation = 4;
		//	alert("newdesignation"+newdesignation);
			listdesig = 0;

		}
		if (designation == 7) {
			newdesignation = 5;
			listdesig = 4;

		}
		if (designation == 9) {
			newdesignation = 7;
			listdesig = 5;

		}
		if (designation == 10) {
			newdesignation = 9;
			listdesig = 7;

		}

	}
 */
	/* if (officeaccess == 2) {
		userdesignation = 9;
		if (designation == 4) {
			newdesignation = 2;
			listdesig = 0;

		}

		if (designation == 5) {
			newdesignation = 4;
			listdesig = 0;

		}
		if (designation == 7) {
			newdesignation = 5;
			listdesig = 4;

		}
		if (designation == 9) {
			newdesignation = 7;
			listdesig = 5;

		}
		if (designation == 10) {
			newdesignation = 9;
			listdesig = 7;

		}

	} */

	/* if (officeaccess == 3) {
		userdesignation = 10;
		if (designation == 4) {
			newdesignation = 2;
			listdesig = 0;
		}

		if (designation == 5) {
			newdesignation = 4;
		//	alert("newdesignation"+newdesignation);
			listdesig = 0;
		}
		if (designation == 7) {
			newdesignation = 5;
			listdesig = 4;

		}
		if (designation == 9) {
			newdesignation = 7;
			listdesig = 5;

		}
		if (designation == 10) {
			newdesignation = 9;
			listdesig = 7;

		}

	} */
	
	//$('#frmtempDesignationId').val(newdesignation);
//	alert("newdesignation"+newdesignation);
//	$('#frmtempUnitId').val(unit);
//	$('#frmtempCircleId').val(circle);
//	$('#frmtempDivisionId').val(division);
//	$('#frmtempSubDivisionId').val(subdivision);
	$('#formyear1').val(year);
	

//	$('#frmtempPostId').val(post);

//	$('#frmbackdesgId').val(designation);
//	$('#frmtempOfficeAccess').val(officeaccess);

//	var desg = $('#frmtempDesignationId').val();
//	alert("listdesig"+listdesig);
	
	//$('#frmtemplistDesignationId').val(listdesig);
	

	var act1 = "../invReport/tank-form20-district-ab";
	var newformId1 = "#tankform20main";

	$(newformId1).attr("action", act1);

	$(newformId1).submit();

}


</script>


<link rel="stylesheet" media="screen" href="../css/custom.css" >
<div class="col-md-9">       
		 


		<div >
			 

				<!--   panel start here -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title" style="color:#fff" >TMS of Irrigation Tank :Form 20 Report.  
						
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
			 </div>
			 <br>
	</c:if></h3>
					</div>
					
					<div class="panel-body">
				
				
						
			
						 	
					
					
					<div class="col-md-12 ">
					<form:form id="tankform20main" method="post" modelAttribute="mitankform20main" name="mainform20abreport">
					
					 <c:if test="${userObj!=null}">	
					 
					 <input name="unitId" value="${userObj.unitId}" class=" form-control " id="uformUnitId" type="hidden" />
					  <input name="circleId" value="${userObj.circleId}" class=" form-control " id="uformCircleId" type="hidden" />
					  <input name="divisionId" value="${userObj.divisionId}" class=" form-control " id="uformDivisionId" type="hidden" />
					   <input name="subDivisionId" value="${userObj.subdivisionId}" class=" form-control " id="uformSubdivisionId" type="hidden" />
					    <input name="designationId" value="${userObj.designationId}" class=" form-control " id="uformdrilldesgId" type="hidden" />
					    <input name="listDesignationId"  class=" form-control " id="uformlistdesgId" type="hidden" />
					     <input name="postId" value="${userObj.post}" class=" form-control " id="uformPostId" type="hidden" />
					       <input name="tsfcFormYear"  class=" form-control " id="formyear1" type="hidden" />
					        <input    name="offAccess" class=" form-control " id="uformOfficeAccess" type="hidden" />
					        
					          <input  value="${userObj.designationId}" class=" form-control " id="uformDesignationId" type="hidden" />
					        
					        </c:if>
					
					
                                        <div class="col-md-4 ">
											<label class="label-control rowlebel ">Select Year</label>
											  <select class="form-control" id="form20year" name="formYear" required> 
											 <option value=" ">--select--</option>
											
											<c:forEach items="${selectFormYear}" var="u">
									              <option value="${u.tsfcFormYear}">${u.tsfcFormYear}</option>

								</c:forEach>
											 </select>
											</div>
																
												
									<div class="col-md-4 "></div>
											
											<div class="col-md-4 "> 
											<button id="viewform20report" class="btn btn-1 btn-primary center-block" type="button" name="viewform20report" onclick="gettankForm20abstract( form20year.value )">Submit</button>
											</div>
											
										<!-- ,'true' -->
											
											
								</form:form>
							</div>	
								
								<form:form id="tankform20report" method="post" modelAttribute="mitankform20rpt" target="_blank">	
	
	   <%--   <c:set var = "frmdesg" scope = "session" value = "${userObj.designationId}"/>	
	      <c:set var = "frmoffacc" scope = "session" value = "1"/>	
	      <c:set var = "frmnewdesg" scope = "session" value = "1"/>	  
					       
	
	  <input name="tsfcFormYear"  class=" form-control " id="frmyear" type="hidden" />
	 
	  <input name="unitId"  class=" form-control " id="frmtempUnitId" type="hidden" />	
	  <input name="circleId"  class=" form-control " id="frmtempCircleId" type="hidden" />	
	   <input name="divisionId"  class=" form-control " id="frmtempDivisionId" type="hidden" /> 
	   <input name="subDivisionId"  class=" form-control " id="frmtempSubDivisionId" type="hidden" />
	    <input  value="${frmoffacc}"  name="offAccess" class=" form-control " id="frmtempOfficeAccess" type="hidden" />
	    <input name="postId"  class=" form-control " id="frmtempPostId" type="hidden" />
	    <input name="designationId"  value="${frmnewdesg}"  class=" form-control " id="frmtempDesignationId" type="hidden" />
	    <input name="formDataId"    class=" form-control " id="form20DataId" type="hidden" /> --%>
	    
	     <!-- <input name="reportType"   class=" form-control "    id="frmtempreportTypeId" type="hidden" /> -->

	     
	     
	     
	       <!-- values for  for back button  -->	
	     
	     <%--  <input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="logincapUnitId" type="hidden" />
	       <input name="userCircleId" value="${userObj.circleId}" class=" form-control " id="logincapCircleId" type="hidden" />
	        <input name="userDivisionId" value="${userObj.divisionId}" class=" form-control " id="logincapDivisionId" type="hidden" />
	         <input name="userSubdivisionId" value="${userObj.subdivisionId}" class=" form-control " id="logincapSubdivisionId" type="hidden" />
	         --%>
	        <%--  <input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="logincapUnitId" type="hidden" >
	          <input name="userDesignationId" value="${userObj.designationId}" class=" form-control " id="loginfrm20designationId" type="hidden" />
	         <input name="backdesignationId" value="0" class=" form-control " id="frmbackdesgId" type="hidden" /> 
	         <input name="listDesignationId"    class=" form-control " id="frmtemplistDesignationId" type="hidden" /> --%>
	         
	         
	         
	         	<div class="row show-grid ">

		
		
	<%-- 	<c:if test="${frmdetailYear!=null}">
		<div class="col-md-12"  id="form20pre">
		
		<button type="button" name="backtoform20intreport" id="backtoform20intreport" class="btn btn-1 btn-primary center-block " onclick="getform20tankabdata('${frmdetailYear}','tankform20main',false )"><b>Back to Initial Abstract Data</b></button>				
				</div>	
				</c:if>
				 --%>
			<%--  <c:if test="${formcontbackdesgId!=0 && formcontbackdesgId!=null  &&  formcontbackdesgId>capdesgId && capunitId!=4 && capunitId!=9832  }"> --%>
				
		<%-- 		<!-- && frmunitId!=4 && frmunitId!=9832  -->
			 <c:if test="${formcontbackdesgId!=0 && formcontbackdesgId!=null  && prefrm20year!=null &&  formcontbackdesgId>frmdesgId && frmunitId!=4 && frmunitId!=9832  && frmunitId!=9830 }">
				<div class="col-md-2"  id="preform20abstract">
				  <c:out value="${formcontbackdesgId} ,${frmdesgId} "></c:out>
				<button type="button" name="preform20abst" id="preform20abst" class="btn btn-1 btn-primary center-block " onclick="gettankForm20abstract('${prefrm20year}', '${prefrm20desgId}','${prefrm20unitId}','${prefrm20circleId}','${prefrm20divisionId}','${prefrm20subdivisionId}','${prefrm20post}','${prefrm20offAccess}' )"><b>Form20 Previous Absract</b></button>
				
				</div>	
				</c:if> 
				 --%>
			
				
		</div>
								
									<c:if test="${mifrom20Abst!=null}">
		<div class="show-grid gridList "  id="cap-detail-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
				 
						<table class="display table-bordered  table1" id="t-form-1">
							<thead id="t-form-hd-1" >
	                      <tr style="font-size: 18px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                      <th>District</th>
	                      
	                    
	                      <th>Sum of Approx. Permanent Cost (In Lakhs)</th>
	                      <th>Sum of Approx Temporary Cost (In Lakhs)</th>
	                      <th>Sum of Approx. Total Repairs Cost (In Lakhs)</th>
	                      <!--   <th>Total Book value (In Lakhs)</th> -->
	                      
	                      <th>Form 20 breached tanks count</th>
	                      <th>Form 20 damaged tanks count</th>
	                      <th>Form 20 submitted tanks count</th>
	                      
	                      <th>Year</th>
	                       <th>Office</th>
							</tr>
							</thead>


							<tbody id="t-form-bd-1">
							
						
							
							<c:forEach items="${mifrom20Abst}" var="f" varStatus="count">	
							
							<c:if test="${f.districtId>0 }">
								
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>
											<%-- 	<c:if test="${frmdesgId==2 || frmdesgId==8 && frmsubdivId >0}">
											<td><b><c:out value="${f.postName}"></c:out></b></td>	
											</c:if>
											<c:if test="${frmdesgId==4 &&   frmsubdivId >0}">

										<td><b><c:out value="${f.postName}"></c:out></b></td>
										
										</c:if> --%>
										
									<%-- 	<c:if test="${frmdesgId==5 && fmdivId>0 &&    frmsubdivId ==0}">

										<td><button type="button" name="form20tank" id="officeTankfrm${count.count}" class="btn btn-1 btn-primary center-block"  style="white-space:normal"  onclick="gettankForm20abstract('${f.tsfcFormYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }')"  ><b><c:out value="${f.subDivisionName}"></c:out></b></button></td>
										
										</c:if> --%>
									<%-- 	<c:if test="${frmdesgId==7 && frmunitId>0  && frmcircleId>0 && fmdivId==0 &&    frmsubdivId ==0}">
										
										<td><button type="button" name="form20tank" id="officeTankfrm${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${f.tsfcFormYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }')"  ><b><c:out value="${f.divisionName}"></c:out></b></button></td>
										
										</c:if> --%>
										
									<%-- 	<c:choose> --%>
										
										<%-- 	<c:when test="${frmOffAccess==3}">
											
											
											 <c:if test="${(frmdesgId==9  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) ||
											  (frmdesgId==7  && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&    f.subDivisionId ==0)}">
											  
											 --%>
											
                                      <%--    <c:if test="${frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830 }">
                                        <!--  This part of code executes when ENC A or I clicks on any unit name and designation Id becomes 9 or 7 -->
                                         <c:out value="2 CE SE nt ENCA or I"></c:out>
										<td><button type="button" name="form20tank" id="officeTankfrm${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${f.tsfcFormYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }')"  > <b><c:out value="${f.circleName}"></c:out></b></button></td>
										</c:if> --%>
										
										
										<%-- </c:if> 
											
											</c:when>
											 --%>
										<%-- 	<c:otherwise> --%>
										 <%-- 	<c:out value="not 3 CE SE nt ENCA or I"></c:out>  --%>
											
										<%-- 	<c:if test="${(frmdesgId==9)  && (frmunitId>0 &&  frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0)}">
										 	<c:out value="normal CE login"></c:out> 
										<td><button type="button" name="officeTankfm" id="officeTankfrm20${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankForm20abstract('${f.tsfcFormYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }')"  > <b><c:out value="${f.circleName}"></c:out></b></button></td>
										
										</c:if> --%>
											
											<%-- </c:otherwise> --%>
										
										<%-- </c:choose> --%>
										
										
										
										<%-- <c:choose>
										<c:when test="${frmOffAccess==3}">
										<c:if test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9   && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&   f.subDivisionId ==0 ) ) }">
										      
										      <c:out value="${prefrm20desgId}"></c:out> 
										      <c:if test="${prefrm20desgId==null}">

										<td><button type="button" name="officeTankfm" id="officeTankfrm20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract('${f.tsfcFormYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										 <c:if test="${prefrm20desgId!=null}">

										<td><button type="button" name="officeTankfm" id="officeTankfrm20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract ('${f.tsfcFormYear }','${prefrm20desgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										</c:if>
										</c:when>
										<c:otherwise>
										
											<c:if test="${(frmdesgId==10  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0)}">

										<td><button type="button" name="officeTankfm" id="officeTankfrm20${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankForm20abstract('${f.tsfcFormYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if>
										
										</c:otherwise>
										
										
									        </c:choose> --%>
										
										
											<td><b>${f.districtName}</b></td>	
											<td><b>${f.sumApxCtPermt}</b></td>	
											<td><b>${f.sumAxCtTemp}</b></td>
											<td><b>${f.sumRepsPermTemp}</b></td>
											<%-- <td><b>${f.sumFmBkValue}</b></td>	 --%>
											
											 <td><b>${f.breachCount}</b></td>
											 
											  <td><b>${f.damageCount}</b></td>
											   <td><b>${f.totalTankCount}</b></td>
											
										<%-- 	sumAprxCostPermt,sumAprxCostTemp ,sumRepairsPermTemp<td><b>${f.totalTankCount}</b></td>	 --%>	
										
										<%--  <c:choose>
											<c:when test="${(frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0) }">
										<td><button type="button" name="Form20Tanks" id="Form20Tanks${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="getForm20tanks('${f.tsfcFormYear }','${frmdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }')"  > <b>${f.totalTankCount}</b></button></td>
										
										
										</c:when>
										
										<c:otherwise>
										<td><button type="button" name="Form20Tanks" id="Form20Tanks${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="getForm20tanks('${f.tsfcFormYear }','${frmListdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subDivisionId}','${f.postId}','${frmOffAccess }')"  > <b>${f.totalTankCount}</b></button></td>
										
										
										</c:otherwise>
										
										</c:choose> --%>
										
																			 
											 
											
									
                                          <td><b>${f.tsfcFormYear}</b></td>
                                           <td><b>${f.unitName}</b></td>
                                          
                                          

									</tr>
									
									</c:if>
									
										<c:if test="${f.districtId==0 }">
										
											<tr style="font-size: 16px;color:red" >
											<td style="text-align: center;"></td>
												<td><b>${f.districtName}</b></td>	
											<td><b>${f.sumApxCtPermt}</b></td>	
											<td><b>${f.sumAxCtTemp}</b></td>
											<td><b>${f.sumRepsPermTemp}</b></td>
											<%-- <td><b>${f.sumFmBkValue}</b></td>	 --%>
											
											 <td><b>${f.breachCount}</b></td>
											 
											  <td><b>${f.damageCount}</b></td>
											   <td><b>${f.totalTankCount}</b></td>
											     <td><b>${f.tsfcFormYear}</b></td>
                                           <td><b>--</b></td>
											
											</tr>
										
										</c:if>

								</c:forEach>

							
							</tbody>
							
		</table>
		<c:out value="Note: Approx. Total Repairs Cost= Approx Permament cost + Approx temporary cost "></c:out>
		</div>
		</div>
				
				</c:if>
				
				<%-- <c:if test="${miTankForm20detail!=null}">
				
				<div class="show-grid gridList "  id="form-detail-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered  table1" id="form-detail-1">
							<thead id="form-detail-hd-1" >
	                      <tr style="font-size: 18px; color: gray; font-weight: bold;">
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
	                       <th>Downloads</th>
	                        <th>Images/Files</th>
	                     
	                     <!--  <th>Year</th> -->


							</tr>
							</thead>


							<tbody id="form-detail-bd-1">
							
						
							
							<c:forEach items="${miTankForm20detail}" var="t" varStatus="count">		
								
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>								
										<td ><b><c:out value="${t.districtName}"></c:out></b></td>
										<td><b><c:out value="${t.mandalName}"></c:out></b></td>
										<td><b><c:out value="${t.villageName}"></c:out></b></td>
										<td><b><c:out value="${t.constituencyName}"></c:out></b></td>		

										<td><b><c:out value="${t.unitName}"></c:out></b></td>
										<td><b><c:out value="${t.circleName}"></c:out></b></td>
										<td><b><c:out value="${t.divisionName}"></c:out></b></td>
										<td><b><c:out value="${t.subDivisionName}"></c:out></b></td>
											<td class="micolblue"><b><c:out value="${t.tankName}"></c:out></b></td>
											
										<td><b><c:out value="${t.tsfcFormDate}"></c:out></b></td>
										
										<td><button type="button" name="form20detailrpt" id="form20detailrpt${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="getForm20DetailReport('${t.formDataId }','tankform20report')"  ><b><c:out value="${t.tsfcFormDate}"></c:out></b></button></td>
									<td><b><c:out value="${t.damageTypeName}"></c:out></b></td>
										<td><button type="button" name="form20detailrpt" id="form20detailrpt${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="getForm20ImagesReport('${t.formDataId }','tankform20report')"  ><b>Download Images in pdf</b></button></td>
										
										<td><b><button type="button" name="viewfrmpht" id="viewfrmphtr${count.count}" class="btn btn-1 btn-primary center-block "  onclick="viewfrmphtfn(${t.formDataId })"  >View Photos</button> </b></td>
										<td><b><c:out value="${t.tsfcFormYear}"></c:out></b></td>
									
									</tr>

								</c:forEach>

							
							</tbody>
		</table>


				</div>
				</div>
				
				</c:if>	 --%>
				
									</form:form> 
									


	                                      
											
						
					
				
			
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
                sheetName: 'Exported_Ayacut_data',
                text:  'Download Data To Excel',
                className: 'btn-primary ',
                messageTop: 'Irrigation Tanks Report',
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
                filename: 'Irrigation Tanks Report',
                exportOptions: {
					columns: ':visible'
					
				},
				 
               
                title: 'Irrigation Tanks Report',
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


	
