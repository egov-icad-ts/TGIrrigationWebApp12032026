

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

<script type="text/javascript" src="../js/invom/res-assgn.js"></script>

<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" media="screen" href="../css/bootstrap-datetimepicker.min.css">






<link rel="stylesheet" media="screen" href="../css/invom/michecks.css">

 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />






<!-- <div class="w3l-main" id="borderStyle"> -->


<div class="col-md-9">



	<div>



		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Res-add-post. 
				
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
						data-parsley-validate-if-empty="" style="overflow:hidden">
						
						<input value="${userObj.unitId}" id="userunit" type="hidden" />
						<input value="${userObj.circleId}" id="usercircle" type="hidden" />
						<input value="${userObj.divisionId}" id="userdivision" type="hidden" />
						<input value="${userObj.subdivisionId}" id="usersubdivision" type="hidden" />
						<input value="${userObj.post}" id="userpost" type="hidden" />

					
						&emsp; &emsp;
						<div class="col-md-12 invDiv">
						
							<c:if test="${projectList!=null}">
						 <c:forEach items="${projectList}" var="k" varStatus="kcount">
						 
						 <div class="col-md-12">
						 <br>
						 <div class="col-md-4">
						<button type="button" name="projName" id="projNameinf" 
																	class="btn btn-1 btn-primary center-block " onclick="openreservoir(${kcount.count})" ><c:out value="${kcount.count}"></c:out>  <c:out value="${k.projectName}"></c:out></button>
																	
																	</div>	
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
						
						<br>
						 <br>
						</div>
						
						 <div class="col-md-12 invDiv resinf" id="resdata<c:out value="${kcount.count}"></c:out>">
						  
						<c:if test="${reservoirList!=null }">
						  <c:set var = "snores" scope = "page" value = "1"/>	
						 <c:forEach items="${reservoirList}" var="m" varStatus="mcount">
						 
						 <c:if test="${m.projectId==k.projectId }">
						  
						  <div class="col-md-12">
						  <br>
						   <div class="col-md-6">
						 <button type="button" name="resName" id="resNameinf" 
																	class="btn btn-1 btn-primary center-block "  onclick="getRespostEmp(${mcount.count},${m.reservoirId})" ><c:out value="${snores}"></c:out>  <c:out value="${m.resName}"></c:out></button>
						   <br>
						   </div>
						    <div class="col-md-2">
						    <c:out value="${m.isNrld}"></c:out>
						    </div>
						     <div class="col-md-2">
						     <c:out value="${m.nrldCode}"></c:out>
						     </div>
						     <c:choose>
						     <c:when test="${m.isNrld==false}">
						     <div class="col-md-2">
						 <button type="button" name="Addnrld" id="addnrldinf${kount.count}" 
																	class="btn btn-1 btn-primary center-block nrldpid"  onclick="addnrldinformation(${m.reservoirId},${m.projectId })" ><c:out value="${snores}"></c:out>  Add Nrld Code </button>
							<br>
							
						<button type="button" name="Addemp" id="addempinf${kount.count}" 
																	class="btn btn-1 btn-primary center-block nrldemp"  onclick="addempformation(${m.reservoirId},${m.projectId })" >  Add Emp Access </button>
							
							<br>
							<br>
							</div>
							
								  <c:set var="snores" value="${snores + 1}" scope="page"/>	
							</c:when>
							<c:otherwise>
							 <div class="col-md-2"><button type="button" name="Addemp" id="addempinf${kount.count}" 
																	class="btn btn-1 btn-primary center-block nrldemp"  onclick="addempformation(${m.reservoirId},${m.projectId },'${m.resName }')" >  Add Emp Access </button></div>
							</c:otherwise>
							</c:choose>
						   <br>
						 </div>
						 
						 <div id="viewemp${mcount.count}">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block; overflow:hidden">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered " style="width: 100%"
											id="viewempId${mcount.count}">
											<thead id="viewemphead${mcount.count}">
											
											</thead>


											<tbody id="viewempbody${mcount.count}">
											
											
											</tbody>
										</table>
									</div>


								</div>
							</div>
					
						 </c:if>
				
						 </c:forEach>
						 	
						 	
						 </c:if>
						 </div>
							</c:forEach>
							</c:if>										
						
						
								
								
								
								
								</div>
						
						
								
								<!-- start of res display -->
								
						

					</form:form>
					
				

															
				</div>





				
			

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



<div id="nrld_dialogue">

	<form:form id="nrldstatusid" method="post" modelAttribute="nrldstatus"
		name="nrldform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
<input name="projectId" value="0"
									id="resprojectId" type="hidden" class="mainprojectId" />
									
<input name="reservoirId" value="0"
									id="resnrldId" type="hidden" class="mainresId" />
									
									
								
   <div class="row" id="editcritical" >
								
									<div class="col-md-6">
																<label class="label-control rowlebel ">PID code:<font color=red>*</font>
																</label>
																</div>
																<div class="col-md-6"> 
																
																<input id="resNrldcode" value="0" name="nrldCode"   style="color:blue; font-weight: bold;"
											class=" form-control "  type="text"  />
																</div>
																
																
									 
																	<div class="col-md-4">
																
																<button type="button" name="updatenrldStatus" id="updatenrldStatusinf"  style="text-align: center;"
																	class="btn btn-1 btn-primary center-block  " onclick="updatenrldStatusdata(this.form.id)">Submit</button>
															</div>
								

							</div>
	
	</form:form>

</div>



<div id="resaccess_dialogue">

	<form:form id="resaccessstatusid" method="post" modelAttribute="resaccessstatus"
		name="resaccessform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
<input name="projectId" value="0"
									id="accprojectId" type="hidden" class="mainprojectId" />
									
<input name="reservoirId" value="0"
									id="accresId" type="hidden" class="mainresId" />
									
									
								
   <div class="row" id="resaccesscritical" >
								
									<div class="col-md-6">
																<label class="label-control rowlebel ">Unit:<font color=red>*</font>
																</label>
																</div>
																<div class="col-md-6"> <select class="form-control"
																	id="unitId"
																	name="unitId" required onchange="getCircles()">
																	<option value=" ">--select--</option>
																	 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>



																</select>
																</div>
																
								<div class="col-md-6">
																<label class="label-control rowlebel ">Circle:<font color=red>*</font>
																</label>
																</div>
																<div class="col-md-6"> <select class="form-control"
																	id="circleId"
																	name="circleId" required  onchange="getDivisions()">
																	<option value=" ">--select--</option>
																	



																</select>
																</div>
											<div class="col-md-6">
																<label class="label-control rowlebel ">Division:<font color=red>*</font>
																</label>
																</div>
																<div class="col-md-6"> <select class="form-control"
																	id="divisionId"
																	name="divisionId" required onchange="getSubDivisions()">
																	<option value=" ">--select--</option>
																	



																</select>
																</div>
																
											<div class="col-md-6">
																<label class="label-control rowlebel ">Sub Division:<font color=red>*</font>
																</label>
																</div>
																<div class="col-md-6"> <select class="form-control"
																	id="subdivisionId"
																	name="subdivisionId" required  onchange="getemployees()" >
																	<option value=" ">--select--</option>
																	



																</select>
																</div>
																
											<div class="col-md-6">
																<label class="label-control rowlebel ">Employee:<font color=red>*</font>
																</label>
																</div>
																<div class="col-md-6"> <select class="form-control"
																	id="postId"
																	name="postId" required   >
																	<option value=" ">--select--</option>
																
																</select>
																</div>
																
																
									 
																	<div class="col-md-4">
																
																<button type="button" name="updateaccessStatus" id="updateresaccessStatusinf"  style="text-align: center;"
																	class="btn btn-1 btn-primary center-block  " onclick="updateaccessStatusdata(this.form.id)">Submit</button>
															</div>
								

							</div>
	
	</form:form>

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
	
	
	

