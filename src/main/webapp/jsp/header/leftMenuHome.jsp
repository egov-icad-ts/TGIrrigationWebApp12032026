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
	
	<script type="text/javascript" src="../js/invomReports/michecks_report.js"></script>

<style>
#chartdiv {
  width: 100%;
  height: 600px;
}

</style>


<link rel="stylesheet" media="screen" href="../css/custom.css" >
<div class="col-md-9">       
		 


		<div >
			 

				<!--   panel start here -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title" style="color:#fff" >Welcome to     <c:if test="${userObj!=null}">	
						
						 <c:if test="${userObj.employeeName!=null && userObj.employeeName!='NA'  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>	
			 
			 </c:if>
			 
			 <c:if test="${userObj.designationName!=null && userObj.designationName!='NA'  }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>	
			 
			 </c:if>
			 <br></br>
						
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
			 <c:if test="${userObj.userName!='icad_test'   &&  userObj.userName != 'cs_telangana'  }">	 <c:out value="${userObj.unitName}"></c:out></c:if>
			   <c:if test="${userObj.userName=='icad_test'  }">	 AG AUDIT</c:if>
			    <c:if test="${userObj.userName=='cs_telangana'  }">	 CS Telangana</c:if>
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
	</c:if></h3>
					</div>
					
					<div class="panel-body">
					<div id="tankreportmaintabs"  class="col-md-12 invDiv">
			<!-- 	<ul id="tmsreportstab"> -->
					<!--  <li><a href="#itrpt" data-toggle="tab">Inspected Tanks Report</a></li> -->
					<!--  #form20subrpt,  ../invReport/tank-form20-ab -->
						  <!--  <li><a href="#form20subrpt" data-toggle="tab" >Form20 submitted tanks report</a></li>	 -->					   
					
					<!-- 	</ul>  -->
						
				<!-- 	 <div class="left-content" >	 -->
						 	<div id="itrpt" >
					
					<form:form id="tanksreportmain" method="post" modelAttribute="mitankinspect" name="mainabreport">	
					 <c:if test="${userObj!=null}">	
					 
					 <input name="unitId" value="${userObj.unitId}" class=" form-control " id="userUnitId" type="hidden" />
					  <input name="circleId" value="${userObj.circleId}" class=" form-control " id="userCircleId" type="hidden" />
					  <input name="divisionId" value="${userObj.divisionId}" class=" form-control " id="userDivisionId" type="hidden" />
					   <input name="subdivisionId" value="${userObj.subdivisionId}" class=" form-control " id="userSubdivisionId" type="hidden" />
					    <input name="designationId" value="${userObj.designationId}" class=" form-control " id="userdrilldowndesgId" type="hidden" />
					     <input name="postId" value="${userObj.post}" class=" form-control " id="userPostId" type="hidden" />
					       <input name="year"  class=" form-control " id="chkyear1" type="hidden" />
					        <input    name="offAccess" class=" form-control " id="userOfficeAccess" type="hidden" />
					       
					        <input name="miTankFreqId"  class=" form-control " id="chkmiTankFreqId1" type="hidden" />
					        
					      <input  value="${userObj.designationId}" class=" form-control " id="userDesignationId" type="hidden" /> 
					   
					   
		<input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="loginuserUnitId1" type="hidden" />
	       <input name="userCircleId" value="${userObj.circleId}" class=" form-control " id="loginuserCircleId1" type="hidden" />
	        <input name="userDivisionId" value="${userObj.divisionId}" class=" form-control " id="loginuserDivisionId1" type="hidden" />
	         <input name="userSubdivisionId" value="${userObj.subdivisionId}" class=" form-control " id="loginuserSubdivisionId1" type="hidden" />
	         <input name="userDesignationId" value="${userObj.designationId}" class=" form-control " id="loginuserdesignationId1" type="hidden" />
	         
	            <input name="backdesignationId" value="0" class=" form-control " id="userbackdesgId" type="hidden" />
	            
	              <input name="reportType"   class=" form-control "   value="0" id="captempreportTypeId" type="hidden" />
	         
	         
					 
					 </c:if>
					
					
					
					
					<div class="col-md-12 invDiv">

	                                      
											
							<!-- 	onchange="gettankChecksabstract(miTankFreqId.value,this.value),gettankCapacityabstract(this.value)"  -->
							<div class="col-md-4 ">
											<label class="label-control rowlebel ">Select Year</label>
											  <select class="form-control" id="miyear" name="year" required> 
											 <option value=" ">--select--</option>
											<!--  <option value="2019">2019</option> -->
											 <!--  <option value="2020">2020</option>
											  <option value="2021">2021</option>
											   <option value="2022">2022</option> -->
											    <c:forEach items="${selectTankYear}" var="u">
									              <option value="${u.year}">${u.year}</option>

								</c:forEach>
											
											 </select>
											</div>
																
												<div class="col-md-4">
												<label class="label-control rowlebel ">Select Frequency</label>
										<select class="form-control" id="newmiTankFreqId"
											name="miTankFreqId"  required>
											<option value=" ">--select--</option>
											<option value="9">PRE MONSOON (April,May)</option>
											<option value="11">DURING MONSOON(JUNE TO AUGUEST)</option>
											<option value="10">POST MONSOON (November,December)</option>
											


										</select>
									</div>
								
									
											
											<div class="col-md-4 "> 
											<button id="viewOMreport" class="btn btn-1 btn-primary center-block" type="button" name="viewOMreport" onclick="gettankchkabdata(newmiTankFreqId.value, miyear.value ,'tanksreportmain',true)">Submit</button>
											</div>
											</div>
											
											</form:form>
											
								
										
		
		&emsp; &emsp;
		
	
		<c:if test="${miunitAbstract!=null ||  mCapacityAbstract!=null || miTankUnitdetail!=null || miTankcapayacutdetail!=null }">
		 	<div id="tabs" >
				<ul >
					 <li><a href="#tcab1" >TANKS ABSTRACT</a></li>
						<!--   <li><a href="#tcab2" >TANKS ABSTRACT BY DISTRICT</a></li> -->
						   <li><a href="#tcab3" >CAPACITY AND AYACUT</a></li>						   
					
						</ul> 
				<!-- 	 <div class="left-content" >	 -->
						 	<div id="tcab1" >
						 	
				
	
		<!-- 	start new tables from controller -->
	<form:form id="tankschkreport1" method="post" modelAttribute="tankstatus">	
	
	     <c:set var = "orgdesg" scope = "session" value = "${userObj.designationId}"/>	
	      <c:set var = "offacc" scope = "session" value = "1"/>	
	      <c:set var = "newdesg" scope = "session" value = "1"/>	 
					       
	
	  <input name="year"  class=" form-control " id="chkyear2" type="hidden" />
	  <input name="miTankFreqId"  class=" form-control " id="chkmiTankFreqId2" type="hidden" />	
	  <input name="unitId"  class=" form-control " id="chktempUnitId" type="hidden" />	
	  <input name="circleId"  class=" form-control " id="chktempCircleId" type="hidden" />	
	   <input name="divisionId"  class=" form-control " id="chktempDivisionId" type="hidden" /> 
	   <input name="subdivisionId"  class=" form-control " id="chktempSubdivisionId" type="hidden" />
	    <input  value="${offacc}"  name="offAccess" class=" form-control " id="chktempOfficeAccess" type="hidden" />
	    <input name="postId"  class=" form-control " id="chktempPostId" type="hidden" />
	    <input name="designationId"  value="${newdesg}"  class=" form-control " id="chktempDesignationId" type="hidden" />
	     <input name="tankStatusId"   class=" form-control " id="chktemptankStatusId" type="hidden" />
	       <input name="reportType"   class=" form-control "   value="1" id="captempreportTypeId" type="hidden" />
	     
	       <!-- values for  for back button  -->	
	     
	      <input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="loginuserUnitId" type="hidden" />
	       <input name="userCircleId" value="${userObj.circleId}" class=" form-control " id="loginuserCircleId" type="hidden" />
	        <input name="userDivisionId" value="${userObj.divisionId}" class=" form-control " id="loginuserDivisionId" type="hidden" />
	         <input name="userSubdivisionId" value="${userObj.subdivisionId}" class=" form-control " id="loginuserSubdivisionId" type="hidden" />
	         <input name="userDesignationId" value="${userObj.designationId}" class=" form-control " id="loginuserdesignationId" type="hidden" />
	         
	         
	         <input name="backdesignationId" value="0" class=" form-control " id="sonewbackdesgId" type="hidden" />
	         
	         
	     
	     
	        <!-- Designation for back button  -->	
	        
	          <input value="${contdesgId}"  class=" form-control " id="preBackdesgId" type="hidden" />
	        
	        
	     
	    

					       
					 
			   <!--   sub office access -->		 
					
			<c:if test="${contdesgId==5}">
		   <c:set var = "newdesg" scope = "session" value = "4"/>
		 
		 </c:if>
		 
		 <c:if test="${contdesgId==7}">
		  <c:set var = "newdesg" scope = "session" value = "5"/>
		 
		 </c:if>
		 
		  <c:if test="${contdesgId==9}">
		  <c:set var = "newdesg" scope = "session" value = "7"/>
		 
		 </c:if>
		 
		  <c:if test="${contdesgId==10}">
		   <c:set var = "newdesg" scope = "session" value = "9"/>
		 
		 </c:if>		
		 
		  <!--   ce office access -->
		 <c:if test="${contunitId!=4 || contunitId!=9832 || contunitId!=9830  }">
		 <c:choose>
		  <c:when test="${(contunitId!=4  && contunitId!=9832 && contunitId!=9830  && contunitId>0 && contcircleId==0 && contdivisionId==0 &&  contsubdivisionId==0) && (contdesgId==2 || contdesgId==4 || contdesgId==5 || contdesgId==7) }">
		 
		 <%-- 	 <c:out value="${ contdesgId}"></c:out> --%>
		
		    <c:set var = "orgdesg" scope = "session" value = "9"/>
		     
		   
		      <c:set var = "newdesg" scope = "session" value = "7"/>
		    
		    <c:set var = "offacc" scope = "session" value = "2"/>
		  
		   
		   </c:when>
		   
		   <c:otherwise>
		   
		 <%--   <c:out value="${ contdesgId}"></c:out> --%>
		   
		   <c:set var = "orgdesg" scope = "session" value = "${userObj.designationId}"/>
		
		    <c:set var = "offacc" scope = "session" value = "1"/>
		   
		   
		   </c:otherwise>
		   
		   </c:choose>
		   
		   </c:if>  
		   
		   <!--   admin office access -->
		 
		 
		  <c:if test="${contunitId==4 || contunitId==9832 || contunitId==9830 }">
		 <c:choose>
		  <c:when test="${(contunitId==4  && contcircleId==0 && contdivisionId==0 &&  contsubdivisionId==0 &&  contdesgId==10) ||
		   (contunitId==4  && contcircleId==104 && contdivisionId==30327 &&  contsubdivisionId==0 && ( contdesgId==5 || contdesgId==4 ||  userObj.postId==3032797194 ||  userObj.postId== 3032797190 )) || 
		   (contunitId==9832  && contcircleId==0 && contdivisionId==0 &&  contsubdivisionId==0 ) || 
		   (contunitId==9832  && contcircleId==21606 && contdivisionId==0 &&  contsubdivisionId==0 )||
		   (contunitId==9830  && contcircleId==0 && contdivisionId==0 &&  contsubdivisionId==0 && ( contdesgId==10 || contdesgId==5 || contdesgId==4 || contdesgId==2 || contdesgId==8 ))||
		   (contunitId==9830  && contcircleId==21609 && contdivisionId==0 &&  contsubdivisionId==0 && ( contdesgId==7 || contdesgId==5 || contdesgId==4 || contdesgId==2 || contdesgId==8 ))||
		   (contunitId==9830  && contcircleId==21609 && contdivisionId==31099 &&  contsubdivisionId==0 && (  contdesgId==5 || contdesgId==4 || contdesgId==2 || contdesgId==8 ))||
		   (contunitId==9830  && contcircleId==21609 && contdivisionId==31099 &&  contsubdivisionId==12173 && (  contdesgId==4 || contdesgId==2 || contdesgId==8 ))
		   
		   }">
		 
		
		  <input name="circleId" value="0" class=" form-control " id="chkCircleId" type="hidden" />
					  <input name="divisionId" value="0" class=" form-control " id="chkDivisionId" type="hidden" />
		   
		    <c:set var = "orgdesg" scope = "session" value = "10"/>
		   
		   
		    <c:set var = "newdesg" scope = "session" value = "9"/>
		    
		     <c:set var = "offacc" scope = "session" value = "3"/>
		     
		    <%--  <c:out value="${ offacc}"></c:out> --%>
		 
		   
		   </c:when>
		    <c:otherwise>
		   
		  <%--   <c:out value="${ contdesgId}"></c:out> --%>
		   
		     <input name="circleId" value="${userObj.circleId}" class=" form-control " id="chkCircleId" type="hidden" />
					  <input name="divisionId" value="${userObj.divisionId}" class=" form-control " id="chkDivisionId" type="hidden" />
		    <c:set var = "orgdesg" scope = "session" value = "${userObj.designationId}"/>
		   
	  <c:set var = "offacc" scope = "session" value = "1"/>
		   
		   
		   </c:otherwise> 
		   
		   </c:choose>
		   
		   </c:if>
		   
		 <%--  	<div class="row show-grid ">

		 <div class="alert alert-success" >
		
		 <strong>Note1 : Please Use A4(landscape) Size Paper for
				Print. Also Selected Data Can be Exported and Printed</strong> <br>
			 
			<h3><strong>Inspected Tanks Condition with respect to&emsp;<c:if test="${userObj.designationName!=null && userObj.designationName!='NA'  }">	
						   
			 <c:out value="${userObj.designationName}"></c:out>	
			 
			 </c:if> </strong></h3>
			 
			
		</div>	 
		</div>--%>
		
		<div class="row show-grid ">
		<c:if test="${detailfreqId!=null}">
		
			
		<div class="col-md-12"  id="rebackdata">
		
		<button type="button" name="backtoreportinint" id="backtoreport1" class="btn btn-1 btn-primary center-block " onclick="gettankchkabdata('${detailfreqId}','${detailYear}','tanksreportmain',false )"><b>Back to Initial Abstract Data</b></button>
				
				</div>	
				</c:if>
				
		
				
				
				<c:if test="${socontbackdesgId!=0 && socontbackdesgId!=null && backmifreq!=null && socontbackdesgId>contdesgId && contunitId!=4 && contunitId!=9832  && contunitId!=9830 }">
				<div class="col-md-2"  id="preabstractn">
				
				<button type="button" name="preabstract" id="preabstractNew" class="btn btn-1 btn-primary center-block " onclick="gettankSONewAbstract('${backmifreq}','${backmiyear}', '${backdesgId}','${backunitId}','${backcircleId}','${backdivisionId}','${backsubdivisionId}','${backpost}','${backoffAccess}' )"><b>Previous Absract</b></button>
				
				</div>	
				</c:if>
			
				
		</div>
					 
	
		<c:if test="${miunitAbstract!=null}">
		<div class="show-grid gridList "  id="tank-chk-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered  table1" id="t-chk-1">
							<thead id="t-chk-hd-1" >
	                      <tr style="font-size: 18px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                      <th>Office</th>
	                      <th>Check list Monsoon (Pre / During / Post)</th>
	                      <th>Tanks Inspected</th>
	                      <th>Tanks in Emergency</th>
	                      <th>Tanks in Observation</th>
	                      <th>Tanks in Maintenance</th>
	                      <th>Tanks in Original Work</th>
	                      <th>Year</th>


							</tr>
							</thead>


							<tbody id="t-chk-bd-1">
							
						
							
							<c:forEach items="${miunitAbstract}" var="t" varStatus="count">		
								
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>
												
												<c:if test="${contdesgId==2 || contdesgId==8 && contsubdivisionId >0}">

										<td><b><c:out value="${t.postName}"></c:out></b></td>
										
										</c:if>
										
											<c:if test="${contdesgId==4 &&   contsubdivisionId >0}">

										<td><b><c:out value="${t.postName}"></c:out></b></td>
										
										</c:if>
										
											<c:if test="${contdesgId==5 && contdivisionId>0 &&    contsubdivisionId ==0}">

										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankSONewAbstract('${t.miTankFreqId}','${t.year }','${contdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess }')"  ><b><c:out value="${t.subdivisionName}"></c:out></b></button></td>
										
										</c:if>
										
										<c:if test="${contdesgId==7 && contunitId>0  && contcircleId>0 && contdivisionId==0 &&    contsubdivisionId ==0}">

										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "    onclick="gettankSONewAbstract('${t.miTankFreqId}','${t.year }','${contdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess }')"  ><b><c:out value="${t.divisionName}"></c:out></b></button></td>
										
										</c:if>
										<c:choose>
										
											<c:when test="${contOffAccess==3}">
											
											<c:if test="${(contdesgId==9  && contunitId>0  && contcircleId==0 && contdivisionId==0 &&    contsubdivisionId ==0) ||
											  (contdesgId==7  && t.unitId>0  && t.circleId==0 && t.divisionId==0 &&    t.subdivisionId ==0)}">
											  
											
											
                                         <c:if test="${contunitId!=4 && contunitId!=9832 && contunitId!=9830 }">
										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankSONewAbstract('${t.miTankFreqId}','${t.year }','${contdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess }')"  > <b><c:out value="${t.circleName}"></c:out></b></button></td>
										</c:if>
										
										
										</c:if>
											
											</c:when>
											
											<c:otherwise>
											
											<c:if test="${(contdesgId==9)  && (contunitId>0 &&  contunitId!=4 && contunitId!=9832 && contunitId!=9830  && contcircleId==0 && contdivisionId==0 &&    contsubdivisionId ==0)}">

										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankSONewAbstract('${t.miTankFreqId}','${t.year }','${contdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess }')"  > <b><c:out value="${t.circleName}"></c:out></b></button></td>
										
										</c:if>
											
											</c:otherwise>
										
										</c:choose>
										
										<c:choose>
										<c:when test="${contOffAccess==3}">
										<c:if test="${((contdesgId==10   && contunitId>0  && contcircleId==0 && contdivisionId==0 &&   contsubdivisionId ==0 ) ||
										      (contdesgId==9   && t.unitId>0  && t.circleId==0 && t.divisionId==0 &&   t.subdivisionId ==0 ) ) }">
										      
										      <c:if test="${backdesgId==null}">

										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankSONewAbstract('${t.miTankFreqId}','${t.year }','${contdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess }')"  >   <b><c:out value="${t.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										 <c:if test="${backdesgId!=null}">

										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankSONewAbstract('${t.miTankFreqId}','${t.year }','${backdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess }')"  >   <b><c:out value="${t.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										</c:if>
										</c:when>
										<c:otherwise>
										
											<c:if test="${(contdesgId==10  && contunitId>0  && contcircleId==0 && contdivisionId==0 &&   contsubdivisionId ==0)}">

										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankSONewAbstract('${t.miTankFreqId}','${t.year }','${contdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess }')"  >   <b><c:out value="${t.unitName}"></c:out></b> </button></td>
										
										</c:if>
										
										</c:otherwise>
										
										
									        </c:choose>
										
										
										
										<c:if test="${t.miTankFreqId==9}">
										<td>Pre Monsoon</td>
													</c:if>
													
													<c:if test="${t.miTankFreqId==10}">
										<td>Post Monsoon</td>
													</c:if>
													
													<c:if test="${t.miTankFreqId==11}">
										<td>During Monsoon</td>
													</c:if>

                                        <c:choose>
											<c:when test="${contdesgId==2 || contdesgId==8 || contdesgId==4 }">

										<td><button type="button" name="totalCount" id="totalCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankNewCountInfo('${t.miTankFreqId}','${t.year }',5,'${contdesgId }','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess }')"   ><b>${t.totalCount}</b></button>
										 <input  class="form-control gramtot2a" id="grtotalCount${count.count}" type="hidden" value="${t.totalCount}" />
										</td>
										
										</c:when>
										
										<c:otherwise>
										<td><button type="button" name="totalCount" id="totalCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankNewCountInfo('${t.miTankFreqId}','${t.year }',5,'${newdesg}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess }')"   ><b>${t.totalCount}</b></button>
										 <input  class="form-control gramtot2b" id="grtotalCount${count.count}" type="hidden" value="${t.totalCount}" />
										</td>
										
										</c:otherwise>
										
										</c:choose>
									
									
									 <c:choose>
											<c:when test="${contdesgId==2 || contdesgId==8 || contdesgId==4 }">

										<td><button type="button" name="emergencyCount" id="emergencyCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankNewCountInfo('${t.miTankFreqId}','${t.year }',2,'${contdesgId }','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess}')"   ><b>${t.emergencyCount}</b></button>
										<input  class="form-control gramem2a" id="gremergencyCount${count.count}" type="hidden" value="${t.emergencyCount}" />
										</td>
										
										</c:when>
										
										<c:otherwise>
										<td><button type="button" name="emergencyCount" id="emergencyCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankNewCountInfo('${t.miTankFreqId}','${t.year }',2,'${newdesg}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess}')"   ><b>${t.emergencyCount}</b></button>
										<input  class="form-control gramem2b" id="gremergencyCount${count.count}" type="hidden" value="${t.emergencyCount}" /></td>
										
										</c:otherwise>
										
										</c:choose>
										
										
										 <c:choose>
											<c:when test="${contdesgId==2 || contdesgId==8 || contdesgId==4 }">

										<td><button type="button" name="observeCount" id="observeCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankNewCountInfo('${t.miTankFreqId}','${t.year }',1,'${contdesgId }','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess}')"   ><b>${t.observeCount}</b></button>
										<input  class="form-control gramob2a" id="grobserveCount${count.count}" type="hidden" value="${t.observeCount}" />
										</td>
										
										</c:when>
										
										<c:otherwise>
										<td><button type="button" name="observeCount" id="observeCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankNewCountInfo('${t.miTankFreqId}','${t.year }',1,'${newdesg}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess}')"   ><b>${t.observeCount}</b></button>
										<input  class="form-control gramob2b" id="grobserveCount${count.count}" type="hidden" value="${t.observeCount}" /></td>
										
										</c:otherwise>
										
										</c:choose>
										
										 <c:choose>
											<c:when test="${contdesgId==2 || contdesgId==8 || contdesgId==4 }">

										<td><button type="button" name="defferedCount" id="defferedCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankNewCountInfo('${t.miTankFreqId}','${t.year }',3,'${contdesgId }','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess}')"   ><b>${t.defferedCount}</b></button>
										<input  class="form-control gramdef2a" id="grodefferedCount${count.count}" type="hidden" value="${t.defferedCount}" /></td>
										
										</c:when>
										
										<c:otherwise>
										<td><button type="button" name="defferedCount" id="defferedCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankNewCountInfo('${t.miTankFreqId}','${t.year }',3,'${newdesg}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess}')"   ><b>${t.defferedCount}</b></button>
										<input  class="form-control gramdef2b" id="grodefferedCount${count.count}" type="hidden" value="${t.defferedCount}" /></td>
										
										</c:otherwise>
										
										</c:choose>
									
									
									 <c:choose>
											<c:when test="${contdesgId==2 || contdesgId==8 || contdesgId==4 }">

										<td><button type="button" name="originalworkCount" id="originalworkCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankNewCountInfo('${t.miTankFreqId}','${t.year }',4,'${contdesgId }','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess}')"   ><b>${t.originalworkCount}</b></button>
										<input  class="form-control gramorgwk2a" id="grooriginalworkCount${count.count}" type="hidden" value="${t.originalworkCount}" /></td>
										
										</c:when>
										
										<c:otherwise>
										<td><button type="button" name="originalworkCount" id="originalworkCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankNewCountInfo('${t.miTankFreqId}','${t.year }',4,'${newdesg}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}','${contOffAccess}')"   ><b>${t.originalworkCount}</b></button>
										<input  class="form-control gramorgwk2b" id="grooriginalworkCount${count.count}" type="hidden" value="${t.originalworkCount}" /></td>
										
										</c:otherwise>
										
										</c:choose>
													
									
                                          <td><b>${t.year}</b></td>

									</tr>

								</c:forEach>

							
							</tbody>
		</table>


				</div>
				</div>
				
				</c:if>
				
			<c:if test="${miTankUnitdetail!=null}">
				
				<div class="show-grid gridList "  id="tank-detail-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered  table1" id="t-detail-1">
							<thead id="t-detail-hd-1" >
	                      <tr style="font-size: 18px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                      <th>Year</th>
	                      <th>Frequency</th>
	                      <th>District Name</th>
	                      <th>Unit Name</th>
	                      <th>Circle Name</th>
	                      <th>Division Name</th>
	                      <th>Sub Division Name</th>
	                      <th>Tank Name</th>


							</tr>
							</thead>


							<tbody id="t-detail-bd-1">
							
						
							
							<c:forEach items="${miTankUnitdetail}" var="t" varStatus="count">		
								
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>								
												

										<td><b><c:out value="${t.year}"></c:out></b></td>
										<td><b><c:out value="${t.activityFrequency}"></c:out></b></td>
										<td><b><c:out value="${t.districtName}"></c:out></b></td>
										<td><b><c:out value="${t.unitName}"></c:out></b></td>
											<td><b><c:out value="${t.circleName}"></c:out></b></td>
										<td><b><c:out value="${t.divisionName}"></c:out></b></td>
										<td><b><c:out value="${t.subdivisionName}"></c:out></b></td>
										<td><button type="button" name="tankinfo" id="tankinf${count.count}" class="btn btn-1 btn-primary center-block " onclick="gettankinfoNewData('${t.tankName}','${t.tankId}','${t.miInpsectMst1Id}','${t.year}')"><b>${t.tankName}</b></button></td>
									
									</tr>

								</c:forEach>

							
							</tbody>
		</table>


				</div>
				</div>
				
				</c:if>	
				
				
				</form:form>
				
		
		
		
		
			<!--end of new tables from controller -->
				
		<c:if test="${miunitAbstract!=null}">		
			<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Please click on Exp button to export Image of chart and Data</strong>
				

			</div>
			</div>
			
				 
				 
				   <div class="col-md-12 invDiv" id="chartdiv"></div>
				 
				 
				 </c:if>
				
       &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
  


				 
				 </div>
			
				
					<div id="tcab3" >
				
				
		
		
				<form:form id="tankschkreport2" method="post" modelAttribute="tankstatus">	
	
	     <c:set var = "capdesg" scope = "session" value = "${userObj.designationId}"/>	
	      <c:set var = "capoffacc" scope = "session" value = "1"/>	
	      <c:set var = "capnewdesg" scope = "session" value = "1"/>	 
					       
	
	  <input name="year"  class=" form-control " id="capyear" type="hidden" />
	  <input name="miTankFreqId"  class=" form-control " id="capmiTankFreqId" type="hidden" />	
	  <input name="unitId"  class=" form-control " id="captempUnitId" type="hidden" />	
	  <input name="circleId"  class=" form-control " id="captempCircleId" type="hidden" />	
	   <input name="divisionId"  class=" form-control " id="captempDivisionId" type="hidden" /> 
	   <input name="subdivisionId"  class=" form-control " id="captempSubdivisionId" type="hidden" />
	    <input  value="${capoffacc}"  name="offAccess" class=" form-control " id="captempOfficeAccess" type="hidden" />
	    <input name="postId"  class=" form-control " id="captempPostId" type="hidden" />
	    <input name="designationId"  value="${capnewdesg}"  class=" form-control " id="captempDesignationId" type="hidden" />
	     <input name="tankStatusId"   class=" form-control " id="captemptankStatusId" type="hidden" />
	     <input name="reportType"   class=" form-control "   value="2" id="captempreportTypeId" type="hidden" />
	     
	     
	     
	       <!-- values for  for back button  -->	
	     
	      <input name="userUnitId" value="${userObj.unitId}" class=" form-control " id="logincapUnitId" type="hidden" />
	       <input name="userCircleId" value="${userObj.circleId}" class=" form-control " id="logincapCircleId" type="hidden" />
	        <input name="userDivisionId" value="${userObj.divisionId}" class=" form-control " id="logincapDivisionId" type="hidden" />
	         <input name="userSubdivisionId" value="${userObj.subdivisionId}" class=" form-control " id="logincapSubdivisionId" type="hidden" />
	         <input name="userDesignationId" value="${userObj.designationId}" class=" form-control " id="logincapdesignationId" type="hidden" />
	         
	         
	         <input name="backdesignationId" value="0" class=" form-control " id="socapnewbackdesgId" type="hidden" />
	         
	         
	     
	     
	        <!-- Designation for back button  -->	
	        
	          <input value="${capdesgId}"  class=" form-control " id="precapBackdesgId" type="hidden" />
	        
	        
	     
	    

					       
					 
			   <!--   sub office access -->		 
					
			<c:if test="${capdesgId==5}">
		   <c:set var = "capnewdesg" scope = "session" value = "4"/>
		 
		 </c:if>
		 
		 <c:if test="${capdesgId==7}">
		  <c:set var = "capnewdesg" scope = "session" value = "5"/>
		 
		 </c:if>
		 
		  <c:if test="${capdesgId==9}">
		  <c:set var = "capnewdesg" scope = "session" value = "7"/>
		 
		 </c:if>
		 
		  <c:if test="${capdesgId==10}">
		   <c:set var = "capnewdesg" scope = "session" value = "9"/>
		 
		 </c:if>		
		 
		  <!--   ce office access -->
		 <c:if test="${capunitId!=4 || capunitId!=9832 ||  capunitId!=9830  }">
		 <c:choose>
		  <c:when test="${(capunitId!=4  && capunitId!=9832 && capunitId!=9830 && capunitId>0 && capcircleId==0 && capdivisionId==0 &&  capsubdivisionId==0) && (capdesgId==2 || capdesgId==4 || capdesgId==5 || capdesgId==7) }">
		 
		 <%-- 	 <c:out value="${ contdesgId}"></c:out> --%>
		
		    <c:set var = "capdesg" scope = "session" value = "9"/>
		     
		   
		      <c:set var = "capnewdesg" scope = "session" value = "7"/>
		    
		    <c:set var = "capoffacc" scope = "session" value = "2"/>
		  
		   
		   </c:when>
		   
		   <c:otherwise>
		   
		 <%--   <c:out value="${ contdesgId}"></c:out> --%>
		   
		   <c:set var = "capdesg" scope = "session" value = "${userObj.designationId}"/>
		
		    <c:set var = "capoffacc" scope = "session" value = "1"/>
		   
		   
		   </c:otherwise>
		   
		   </c:choose>
		   
		   </c:if>  
		   
		   <!--   admin office access -->
		 
		 
		  <c:if test="${capunitId==4 || capunitId==9832 || capunitId==9830  }">
		 <c:choose>
		  <c:when test="${(capunitId==4  && capcircleId==0 && capdivisionId==0 &&  capsubdivisionId==0 &&  capdesgId==10) ||
		   (capunitId==4  && capcircleId==104 && capdivisionId==30327 &&  capsubdivisionId==0 && ( capdesgId==5 || capdesgId==4 ||  userObj.postId==3032797194 ||  userObj.postId== 3032797190 )) || 
		   (capunitId==9832  && capcircleId==0 && capdivisionId==0 &&  capsubdivisionId==0 ) || 
		   (capunitId==9832  && capcircleId==21606 && capdivisionId==0 &&  capsubdivisionId==0 )||
		   (contunitId==9830  && contcircleId==0 && contdivisionId==0 &&  contsubdivisionId==0 && ( contdesgId==10 || contdesgId==5 || contdesgId==4 || contdesgId==2 || contdesgId==8 ))||
		   (contunitId==9830  && contcircleId==21609 && contdivisionId==0 &&  contsubdivisionId==0 && ( contdesgId==7 || contdesgId==5 || contdesgId==4 || contdesgId==2 || contdesgId==8 ))||
		   (contunitId==9830  && contcircleId==21609 && contdivisionId==31099 &&  contsubdivisionId==0 && (  contdesgId==5 || contdesgId==4 || contdesgId==2 || contdesgId==8 ))|| 
		   (contunitId==9830  && contcircleId==21609 && contdivisionId==31099 &&  contsubdivisionId==12173 && (   contdesgId==4 || contdesgId==2 || contdesgId==8 ))
		   }">
		 
	
		 
		  <input name="circleId" value="0" class=" form-control " id="capCircleId" type="hidden" />
					  <input name="divisionId" value="0" class=" form-control " id="capDivisionId" type="hidden" />
		   
		    <c:set var = "capdesg" scope = "session" value = "10"/>
		   
		   
		    <c:set var = "capnewdesg" scope = "session" value = "9"/>
		    
		     <c:set var = "capoffacc" scope = "session" value = "3"/>
		     
		    <%--  <c:out value="${ offacc}"></c:out> --%>
		 
		   
		   </c:when>
		    <c:otherwise>
		   
		  <%--   <c:out value="${ contdesgId}"></c:out> --%>
		   
		     <input name="circleId" value="${userObj.circleId}" class=" form-control " id="capCircleId" type="hidden" />
					  <input name="divisionId" value="${userObj.divisionId}" class=" form-control " id="capDivisionId" type="hidden" />
		    <c:set var = "capdesg" scope = "session" value = "${userObj.designationId}"/>
		   
	  <c:set var = "capoffacc" scope = "session" value = "1"/>
		   
		   
		   </c:otherwise> 
		   
		   </c:choose>
		   
		   </c:if>
		   
		   	<div class="row show-grid ">

		
		
		<c:if test="${capYear!=null}">
		
			
		<div class="col-md-12"  id="rebackdata2">
		
		<button type="button" name="backtoreportinint2" id="backtoreport2" class="btn btn-1 btn-primary center-block " onclick="gettankchkabdata('${capFreqId}','${capYear}','tanksreportmain',false )"><b>Back to Initial Abstract Data</b></button>
				
				</div>	
				</c:if>
				
			 
				
				
			 <c:if test="${socontbackdesgId!=0 && socontbackdesgId!=null  &&  backmifreq!=null &&  socontbackdesgId>capdesgId && capunitId!=4 && capunitId!=9832  }">
				<div class="col-md-2"  id="preabstractn">
				
				<button type="button" name="preabstract" id="preabstractNew" class="btn btn-1 btn-primary center-block " onclick="gettankSONewAbstract('${backmifreq}','${backmiyear}', '${backdesgId}','${backunitId}','${backcircleId}','${backdivisionId}','${backsubdivisionId}','${backpost}','${backoffAccess}' )"><b>Capacity Previous Absract</b></button>
				
				</div>	
				</c:if> 
				
			
				
		</div>
					 
	
		<c:if test="${mCapacityAbstract!=null}">
		<div class="show-grid gridList "  id="tank-cap-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered  table1" id="t-chk-1">
							<thead id="t-chk-hd-1" >
	                      <tr style="font-size: 18px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                      <th>Office</th>
	                      <th>Total Ayacut (acres)</th>
	                      <th>Cultivated Ayacut (acres)</th>
	                      <th>Gross Capacity (TMC)</th>	                      
	                      <th>Available Capacity (TMC)</th>
	                      <th>No. of Tanks</th>
	                    
							</tr>
							</thead>


							<tbody id="t-chk-bd-1">
							
							
							
							<c:forEach items="${mCapacityAbstract}" var="f" varStatus="count">		
								
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>
												
												<c:if test="${capdesgId==2 || capdesgId==8 && capsubdivisionId >0}">

										<td><b><c:out value="${f.postName}"></c:out></b></td>
										
										</c:if>
										
											<c:if test="${capdesgId==4 &&   capsubdivisionId >0}">

										<td><b><c:out value="${f.postName}"></c:out></b></td>
										
										</c:if>
										
											<c:if test="${capdesgId==5 && capdivisionId>0 &&    capsubdivisionId ==0}">

										<td><button type="button" name="captank" id="officeTankcap${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankCapSONewabstract('${capfreqId}','${f.year }','${capdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subdivisionId}','${f.postId}','${capOffAccess }')"  ><b><c:out value="${f.subdivisionName}"></c:out></b></button></td>
										
										</c:if>
										
										<c:if test="${capdesgId==7 && capunitId>0  && capcircleId>0 && capdivisionId==0 &&    capsubdivisionId ==0}">

										<td><button type="button" name="captank" id="officeTankcap${count.count}" class="btn btn-1 btn-primary center-block "    onclick="gettankCapSONewabstract('${capfreqId}','${f.year }','${capdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subdivisionId}','${f.postId}','${capOffAccess }')"  ><b><c:out value="${f.divisionName}"></c:out></b></button></td>
										
										</c:if>
										<c:choose>
										
											<c:when test="${capOffAccess==3}">
											
											<c:if test="${(capdesgId==9  && capunitId>0  && capcircleId==0 && capdivisionId==0 &&    capsubdivisionId ==0) ||
											  (capdesgId==7  && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&    f.subdivisionId ==0)}">
											  
											
											
                                         <c:if test="${capunitId!=4 && capunitId!=9832 }">
                                        <%--  <c:out value="off acc 3 not admn or major and 9 or 7"></c:out> --%>
										<td><button type="button" name="captank" id="officeTankcap${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankCapSONewabstract('${capfreqId}','${f.year }','${capdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subdivisionId}','${f.postId}','${capOffAccess }')"  > <b><c:out value="${f.circleName}"></c:out></b></button></td>
										</c:if>
										
										
										</c:if>
											
											</c:when>
											
											<c:otherwise>  <!-- officeaccess 2 and capdesgId=9 -->
											<c:if test="${(capdesgId==9)  && (capunitId>0 &&  capunitId!=4 && capunitId!=9832  && capcircleId==0 && capdivisionId==0 &&    capsubdivisionId ==0)}">
 											<%--  <c:out value="off  acc  not 3 not admn or major and 9 or 7"></c:out> --%>
										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "  style="white-space:normal"  onclick="gettankCapSONewabstract('${capfreqId}','${f.year }','${capdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subdivisionId}','${f.postId}','${capOffAccess }')"  > <b><c:out value="${f.circleName}"></c:out></b></button></td>
										</c:if>
											
											</c:otherwise>
										
										</c:choose>
										
										<c:choose>
										<c:when test="${capOffAccess==3}">
										
										<c:if test="${((capdesgId==10   && capunitId>0  && capcircleId==0 && capdivisionId==0 &&   capsubdivisionId ==0 ) ||
										      (capdesgId==9   && f.unitId>0  && f.circleId==0 && f.divisionId==0 &&   f.subdivisionId ==0 ) ) }">
										      
										       <%-- <c:out value="${backdesgId}"></c:out>  --%>
										      <c:if test="${backdesgId==null}">

										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankCapSONewabstract('${capfreqId}','${f.year }','${capdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subdivisionId}','${f.postId}','${capOffAccess }')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										 <c:if test="${backdesgId!=null}">

										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankCapSONewabstract('${capfreqId}','${f.year }','${backdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subdivisionId}','${f.postId}','${capOffAccess }')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if> 
										</c:if>
										</c:when>
										<c:otherwise>
										
											<c:if test="${(capdesgId==10  && capunitId>0  && capcircleId==0 && capdivisionId==0 &&   capsubdivisionId ==0)}">

										<td><button type="button" name="officeTankch" id="officeTankchk${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="gettankCapSONewabstract('${capfreqId}','${f.year }','${capdesgId}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subdivisionId}','${f.postId}','${capOffAccess }')"  >   <b><c:out value="${f.unitName}"></c:out></b> </button></td>
										
										</c:if>
										
										</c:otherwise>
										
										
									        </c:choose>
										
										<td class="micolred">${f.grossAyacut}</td>
										<td class="micolgreen">${f.ayacut}</td>
										<td  class="micolred">${f.grossCapacity}</td>
										<td class="micolgreen">${f.availableCapacity}</td>
										
									
													

                                        <c:choose>
											<c:when test="${(capdesgId==2 || capdesgId==8 || capdesgId==4) && (capsubdivisionId>0) }">

										<td><button type="button" name="tankcapCount" id="tankcapCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="getcapNewdetailsbyoffice('${capfreqId}','${f.year }','${capdesgId }','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subdivisionId}','${f.postId}')"   ><b>${f.totalCount}</b></button></td>
										
										</c:when>
										
										<c:otherwise>
										<td><button type="button" name="tankcapCount" id="tankcapCount${count.count}" class="btn btn-1 btn-primary center-block " onclick="getcapNewdetailsbyoffice('${capfreqId}','${f.year }','${capnewdesg}','${f.unitId}','${f.circleId}','${f.divisionId}','${f.subdivisionId}','${f.postId}')"   ><b>${f.totalCount}</b></button></td>
										
										</c:otherwise>
										
										</c:choose>
									
									

									</tr>

								</c:forEach>

							
							</tbody>
		</table>


				</div>
				</div>
				
				</c:if>
				
			<c:if test="${miTankcapayacutdetail!=null}">
				
				<div class="show-grid gridList "  id="cap-detail-data-1" 	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered  table1" id="cap-detail-1">
							<thead id="cap-detail-hd-1" >
	                      <tr style="font-size: 18px; color: gray; font-weight: bold;">
	                      <th>Sl.No</th>
	                      <th>Unit Name</th>
	                      <th>Circle Name</th>
	                      <th>Division Name</th>
	                      <th>Sub Division Name</th>
	                      <th>Tank Name</th>
	                      <th>Gross Ayacut</th>
	                      <th>Present ayacut</th>
	                      <th>Gross Capacity</th>
	                      <th>Available Capacity</th>
	                      <th>Year</th>


							</tr>
							</thead>


							<tbody id="cap-detail-bd-1">
							
						
							
							<c:forEach items="${miTankcapayacutdetail}" var="t" varStatus="count">		
								
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>								
												

										<td><b><c:out value="${t.unitName}"></c:out></b></td>
										<td><b><c:out value="${t.circleName}"></c:out></b></td>
										<td><b><c:out value="${t.divisionName}"></c:out></b></td>
										<td><b><c:out value="${t.subdivisionName}"></c:out></b></td>
											<td class="micolblue"><b><c:out value="${t.tankName}"></c:out></b></td>
										<td class="micolred"><b><c:out value="${t.grossAyacut}"></c:out></b></td>
										<td class="micolgreen"><b><c:out value="${t.ayacut}"></c:out></b></td>
										<td class="micolred"><b><c:out value="${t.grossCapacity}"></c:out></b></td>
										<td  class="micolgreen"><b><c:out value="${t.availableCapacity}"></c:out></b></td>
										<td><b><c:out value="${t.year}"></c:out></b></td>
									
									</tr>

								</c:forEach>

							
							</tbody>
		</table>


				</div>
				</div>
				
				</c:if>	
				
				
				</form:form>
				
				
				
				 </div>  <!-- end of tcab3 -->
				 
			
				 
				 </div>
				 </c:if>
				 
						
						
					</div>  <!-- end of tab itrpt -->
					
					
				
				</div> 	 <!-- main tabs div  -->
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


	
