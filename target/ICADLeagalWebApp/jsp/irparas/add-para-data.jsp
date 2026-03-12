

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
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>

 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />


 <script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>
 
  <script type="text/javascript" src="../js/irparas/add_paras_input.js"></script>
   

<style>
.ui-tabs-vertical { width: 100% }
.ui-tabs-vertical .ui-tabs-nav { padding: .1em .1em .1em .1em; float: left; width: 15%; }
.ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
.ui-tabs-vertical .ui-tabs-nav li a { display:block; }
.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
.ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right;width:85%  }
</style> 











<!-- <div id="content">
<div class="w3l-main" style="width:100%" id="borderStyle"> -->

<div class="col-md-9">
	

	

	<div>


	<div class="panel panel-primary " >
		<div class="panel-heading">
			<h3 class="panel-title">IR Paras: Add Paras Information
			
			<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						 <c:if test="${userObj.employeeName!=null &&  userObj.employeeName!='NA'  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>	
			 
			 </c:if>
			 
			 <c:if test="${userObj.designationName!=null && userObj.designationName!='NA' }">	
						   
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
				id="action_alert"></div>	
		
	<!-- 	<div class="col-md-12">
	
<form id="dupform" action="javascript:alert( 'success!' );">
  <div>
    
  </div>
</form>
<span></span>
		</div> -->
		
		<div class="row show-grid ">
				<div class="col-md-4">
				</div>
					<div class="col-md-4">
				</div>
				
			<div class="col-md-4" >
									
									<label class="label-controlPMS rowlebel "><b><a id="helpId" href="javascript:void(0)"><strong style="color:#CA3F22">****Click Here For Clarifications</strong></a></b>
										
									</label> 
					 
					
											
									 </div>
							
			</div>
			
			
				
	
		
		
		<div id="result" class="col-md-12">
	<div class="wrapper">
	
		
		
			<div id="tabs">
				<ul>
					<li><a href="#tgist1" onclick="getalertempty()"   class="ac-ta">Add Gist of Para</a></li>
					<li><a href="#tgist2" onclick="getalertempty()"  class="ac-ta">Add Para</a></li>
					<li><a href="#tgist3" onclick="getalertempty()"  class="ac-ta">Add Replies</a></li>
					<li><a href="#tgist4" onclick="getalertempty()"  class="ac-ta">Add Documents</a></li>
					
					<li><a href="#tgist5" onclick="getalertempty()"   class="ac-ta" >Transfer To Other Office</a></li>
				</ul>
				<div id="tgist1">
				
				
				<form:form id="parasinput1"  name="parasform1" method="post"  class="irparasform" modelAttribute="irparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
					 
					 
					 <input name="unitId" value="${userObj.unitId}"  id="unitId1" type="hidden" />
		<input name="circleId" value="${userObj.circleId}"  id="circleId1" type="hidden" />
		<input name="divisionId" value="${userObj.divisionId}"  id="divisionId1" type="hidden" />
		<input name="subdivisionId" value="${userObj.subdivisionId}"  id="subdivisionId1" type="hidden" />
		<input name="paratabId" value="1"  id="paratabId1" type="hidden" />
		
		 <input name="tunitId" value="0"  id="tunitId1" type="hidden" />
		<input name="tcircleId" value="0"  id="tcircleId1" type="hidden" />
		<input name="tdivisionId" value="0"  id="tdivisionId1" type="hidden" />
		<input name="tsubdivisionId" value="0"  id="tsubdivisionId1" type="hidden" />
		<!-- 	<input  value="0"  id="finy" type="hidden" />
		 -->
					   
					   		
<div class="col-md-12 invDiv">	

<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: please select any relevant dates in the respective financial year of the Para.</strong>
				

			</div>
			</div>	
									      							

<div class="col-md-6">
										
										<div class="col-md-6">
											<label class="label-control rowlebel ">Financial Year <font color=red>*</font> </label>
											</div>
											
											<div class="col-md-6">
											 <select class="form-control" id="financialYear" name="financialYear" required onchange="getGistinAddGistByYear(this.value,1)"> 
											 <option value=" ">--select--</option>
											
											 </select></div> 
											 
											 
										    	<div class="col-md-6">
										    <label class="label-controlPMS rowlebel ">
										    Para Number  <font color=red>*</font>  </label>
										    </div>
										    <div class="col-md-6">
										    <select class="form-control" id="paraNumber" name="paraNumber"  required>
										     <option value=" ">--select--</option> 
										     <option value="I">I</option> 
										     <option value="II">II</option> 
										     <option value="III">III</option>
										      <option value="IV">IV</option>
										      <option value="V">V</option>
										      <option value="VI">VI</option>
										      <option value="VII">VII</option>
										      <option value="VIII">VIII</option>
										      <option value="IX">IX</option>
										      <option value="X">X</option>
										      <option value="XI">XI</option>
										      <option value="XII">XII</option>
										      <option value="XIII">XIII</option>
										      <option value="XIV">XIV</option>
										       <option value="XV">XV</option>
										         <option value="XVI">XVI</option>
										          <option value="XVII">XVII</option>
										           <option value="XVIII">XVIII</option>
										           <option value="XIX">XIX</option>
										             <option value="XX">XX</option>
										              <option value="XXI">XXI</option>
										               <option value="XXII">XXII</option>
										                <option value="XXIII">XXIII</option>
										                <option value="XXIV">XXIV</option>
										                 <option value="XXV">XXV</option>
										      </select> </div>
										      
										      
											 
											 
											  <div class="col-md-6">
											 <label class="label-control rowlebel ">File No.  </label>
											 </div>
											 
											 <div class="col-md-6">
											  <input type="text" class=" form-control"  id="fileNumber" name="fileNumber" placeholder="Ex:9-40/08-09(AG File)"  /> 
											  </div>
											  
											   <div class="col-md-6">
											 <label class="label-control rowlebel ">LAR No.  </label>
											 </div>
											 
											 <div class="col-md-6">
											  <input type="text" class=" form-control"  id="larNumber" name="larNumber" placeholder="Ex:183/08-09"  /> 
											  </div>
											 
											 
										
											 
											 
											  <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Section <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="sectionId" name="sectionId" required> 
										<option value=" ">--select--</option>  
										<option value="1">Section-A</option>
										<option value="2">Section-B</option>
										<!-- <option value="3">CAG Report</option> -->
										
										</select> </div>
										
										
										
										
										      
										      
										        <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Para Status  <font color=red>*</font>  </label>
										</div>
										<div class="col-md-6">
										<select class="paratrunit form-control" id="paraStatusId" name="paraStatusId"  required> 
										<option value=" ">--select--</option> 
										 <option value="1">Reply Sent to AG</option>
									    <option value="2">Reply Not Sent</option> 										
									
										<option value="3">Dropped</option> 
									   <!--   <option value="4">Reply Sent to Government</option>  -->
									     
										 </select>
									     </div>
								
										
											</div>
											
											 <div class="col-md-6">
										
										
										<div class="col-md-6">
											 <label class="label-control rowlebel ">Date of Audit <font color=red>*</font> </label>
											 </div>
											 
											 <div class="col-md-6">
											 <label class="label-control rowlebel ">from</label>
											  <input type="text" class="datepick form-control datepicker"  id="auditDateFrom" name="auditDateFrom" placeholder="auditDateFrom"  readonly="readonly" value="0" required/> 
											  </div>
											  
											  
											  <div class="col-md-6"></div>
											   <div class="col-md-6">
											   <label class="label-control rowlebel ">to</label>
											  <input type="text" class="datepick form-control datepicker"  id="auditDateTo" name="auditDateTo" placeholder="auditDateto"  readonly="readonly" value="0"  /> 
											  </div>
										
										<div class="col-md-12 row">	
										
											   <div class="col-md-6" id="cag" >
										 <label class="label-controlPMS rowlebel ">Included in CAG Report <font color=red>*</font> </label>
										 </div>
									
      
        <div class="col-md-6" id="statusdiv">
       
        
        <label class="radio-inline"> <input type="radio" name="printCAG" id="printCAGn"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="printCAG" id="printCAGy"     value="true"  required >Yes</label>
       
       
         
        </div>
        </div>
        <div class="col-md-12 row">
           <div class="col-md-6" id="inclproposed" >
										 <label class="label-controlPMS rowlebel ">Proposed for inclusion in CAG Report <font color=red>*</font> </label>
										 </div>
										 
										   
        <div class="col-md-6" id="inclproposeddiv">
       
        
        <label class="radio-inline"> <input type="radio" name="inclPropCAG" id="inclPropCAGy"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="inclPropCAG" id="inclPropCAGn"     value="true"  required >Yes</label>
       
       
        </div>
        
        </div>
     
									</div>
									

	</div>		
	
	
	<div class="col-md-12">
        <label class="label-control rowlebel" >Gist of Para*</label> 
      
      <textarea class="form-control "  id="actionTitle" name="actionTitle" rows="3" cols="80" placeholder="Para"    required> </textarea>
      
	</div>
											
		&emsp;&emsp;
									<div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<button type="button" name="gistform1" id="gist1"
									class="btn btn-1 btn-primary center-block parasbutton">Submit Gist</button>
										</div>
									</div>


							</form:form>
							
							 &emsp;&emsp;
							<div class="col-md-12" id="add-para-gist">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="add-para-gist-tid">
											
											<thead id="add-para-gist-head">											
											</thead>
											
											<tbody id="add-para-gist-body">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
							
						
				
				</div>
				<div id="tgist2">
				
				<form:form id="parasinput2" name="parasform2" method="post"  class="irparasform" modelAttribute="irparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
								<input name="unitId" value="${userObj.unitId}"  id="unitId2" type="hidden" />
		<input name="circleId" value="${userObj.circleId}"  id="circleId2" type="hidden" />
		<input name="divisionId" value="${userObj.divisionId}"  id="divisionId2" type="hidden" />
		<input name="subdivisionId" value="${userObj.subdivisionId}"  id="subdivisionId2" type="hidden" />
		<input name="paratabId" value="2"  id="paratabId2" type="hidden" />
		
		 <input name="tunitId" value="0"  id="tunitId2" type="hidden" />
		<input name="tcircleId" value="0"  id="tcircleId2" type="hidden" />
		<input name="tdivisionId" value="0"  id="tdivisionId2" type="hidden" />
		<input name="tsubdivisionId" value="0"  id="tsubdivisionId2" type="hidden" />
		<input name="paraId" value="0"  id="paraId2" type="hidden" />
	
				
				<div class="col-md-12 invDiv">
					 
											  <div class="col-md-3">
										<label class="label-control rowlebel ">
										Select Year  </label><font color=red>*</font>
										</div>
										
										 <div class="col-md-3">
										<select class="form-control" id="year2" name="financialYear" onchange="getParaGistByYearoffice(unitId2.value,circleId2.value,divisionId2.value,this.value,1)" required> 
										<option value=" ">--select--</option> 
										<c:if test="${finYearData!=null}">
										 <c:forEach items="${finYearData}" var="f">
										<option value="<c:out value="${f.financialYear}"></c:out>"><c:out value="${f.financialYear}"></c:out></option> 
										</c:forEach>
										
										</c:if> 
										
										
										
										</select> </div>
										
										
										
										<div class="col-md-6">
																
									<button type="button" name="showgist" id="showgistid"  class="btn btn-1 btn-primary center-block "  >Show Gist of Para</button>
										
										</div>
									
									</div>
									<div class="col-md-12 invDiv">	
										
										<div class="col-md-12" id="act-alert"></div>
										
										
										
										
										<div class="col-md-2" id="paranumdid"></div>
										<div class="col-md-6" id="viewparainf"></div>
										
										  <div class="col-md-4" >
										 </div>
										
										
										
							</div>
					
										
										
								<div class="col-md-12 invDiv" >		 
										
										
										 <div class="col-md-6">
										 <label class="label-control rowlebel ">
										Select Sub Category  </label>
										<select class="form-control" id="subcategory" name="subcategory" > 
										<option value=" ">-select-</option>
										<option value="A">A</option>
										<option value="B">B</option> 
										<option value="C">C</option> 
										<option value="D">D</option> 
										<option value="E">E</option> 
										<option value="F">F</option> 
										<option value="G">G</option> 
										<option value="H">H</option> 
										<option value="I">I</option> 
										<option value="K">K</option> 
										<option value="L">L</option> 
										
										</select> </div>
										
										 <div class="col-md-6">
										 
										 <label class="label-controlPMS rowlebel ">
										Select Para Status  <font color=red>*</font>  </label>
										 
										 <select class="paratrunit form-control" id="paraStatusId2" name="paraStatusId"  required> 
										<option value=" ">--select--</option> 
										 <option value="1">Reply Sent to AG</option>
									    <option value="2">Reply Not Sent</option>									
										<option value="3">Dropped</option> 
									   <!--   <option value="4">Reply Sent to Government</option>  -->
									     
										 </select>
										
										
										
										</div>
										
										
										
											 
											 </div>
											 
	
	<div class="col-md-12 invDiv rdelay" >		 
									<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: please use NA, if there are no reasons For delay.</strong>
				

			</div>
			</div>	
										
										 <div class="col-md-4">
										 <label class="label-control rowlebel ">
										Reasons For Delay/Remarks <font color=red>*</font> </label>
										
										</div>
										
										 <div class="col-md-8">
										 
										 <textarea class="form-control "  id="parareasonsDelay" name="parareasonsDelay" rows="2" cols="80" placeholder="parareasonsDelay"    required> </textarea>
										</div>
										
										</div>
										
								
      
				  &emsp;&emsp;  &emsp;&emsp;
				<div class="col-md-12">
	
	
<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: please do not copy any images to avoid discrepancy in reports</strong>
				

			</div>
			</div>	
  <div class="table-responsive">
     <table class="table table-striped table-bordered" id="para_data">
     
      <tbody>
    
      
      <tr>
      
     
        <td style="color: red;text-align: center;">
        	<label class="label-control rowlebel " >Para*</label> 
	<textarea class="ckedit form-control "  id="parasAction" name="parasAction" rows="10" cols="80" placeholder="Para"  required
	data-parsley-errors-container="#purpose-errors" data-parsley-required-message="Please Enter Para Information!" data-parsley-group="block1"></textarea>
     
       </td>
      
        
      </tr>
        <tr> <td></td> <td style="margin-bottom: 20px;color: red; text-align: center;" id="purpose-errors"></td></tr>
      
      
      </tbody>
     </table>
    </div>
      </div>
      
<div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<button type="button" name="gistform2" id="para2"
									class="btn btn-1 btn-primary center-block parasbutton">Submit Para</button>
										</div>
									</div>
				
				
				</form:form>
				
				
					 &emsp;&emsp;
					 
					 <div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<button type="button" name="subdia" id="subdia1"
									class="btn btn-1 btn-primary center-block diaviewsubpara">View/Edit/Delete Submitted Para Info</button>
										</div>
									</div>
				
				
					 &emsp;&emsp;
							<div class="col-md-12" id="add-sub-para">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="add-sub-para-tid">
											
											<thead id="add-sub-para-head">											
											</thead>
											
											<tbody id="add-sub-para-body">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
					
				</div>
				
				<div id="tgist3">
				
				<form:form id="parasinput3" name="parasform3" method="post"  class="irparasform" modelAttribute="irparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
									<input name="unitId" value="${userObj.unitId}"  id="unitId3" type="hidden" />
		<input name="circleId" value="${userObj.circleId}"  id="circleId3" type="hidden" />
		<input name="divisionId" value="${userObj.divisionId}"  id="divisionId3" type="hidden" />
		<input name="subdivisionId" value="${userObj.subdivisionId}"  id="subdivisionId3" type="hidden" />
		<input name="paratabId" value="3"  id="paratabId3" type="hidden" />
		
		<input name="tunitId" value="0"  id="tunitId3" type="hidden" />
		<input name="tcircleId" value="0"  id="tcircleId3" type="hidden" />
		<input name="tdivisionId" value="0"  id="tdivisionId3" type="hidden" />
		<input name="tsubdivisionId" value="0"  id="tsubdivisionId3" type="hidden" />
		<input name="paraId" value="0"  id="paraId3" type="hidden" />
		<input name="subParaId" value="0"  id="subParaId3" type="hidden" />
	
	<c:if test="${userObj.unitId==9832 && userObj.circleId==21614}">
	           <div class="col-md-12 invDiv" id="cao-units-display"  >
	           
	           <div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select Unit  <font color=red>*</font> 
													</label></div>
													
													<div class="col-md-6">
													<select class="form-control" id="caounitId" name="unitId"  onchange="getCircles(),getcaofinYeardata(caounitId.value,0,0)" required>
												 <option value=" ">--select--</option>
												
												 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
 
												
												
												</select>
											</div>
											
											<div class="col-md-6">
												<label class="label-control rowlebel ">Select Circle</label>
												</div>
												<div class="col-md-6">
												<select class="form-control" id="caocircleId" name="circleId" 
													 onchange="getDivisions(),getcaofinYeardata(caounitId.value,caocircleId.value,0) ">
													<option value="0">--select--</option>
													


												</select>

											</div>
											
											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select Division</label>
												</div>
												<div class="col-md-6">
												<select class="form-control" id="caodivisionId" name="divisionId"  onchange="getcaofinYeardata(caounitId.value,caocircleId.value,this.value)" >
	</select>
											</div>
											
	           </div>
	           </c:if>
	
		
				<div class="col-md-12 invDiv"  >
				
				<c:if test="${(userObj.unitId!=9832 && userObj.circleId!=21614)||(userObj.unitId==9832 &&  userObj.circleId!=21614)  }">
					  <div class="col-md-3">
										<label class="label-controlPMS rowlebel ">
										Select Year <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-3">
										<select class="form-control" id="year3" name="financialYear" required onchange="getParaGistByYearoffice(unitId3.value,circleId3.value,divisionId3.value,this.value,2)"> 
										<option value=" ">--select--</option>  
										<c:if test="${finYearData!=null}">
										 <c:forEach items="${finYearData}" var="f">
										<option value="<c:out value="${f.financialYear}"></c:out>"><c:out value="${f.financialYear}"></c:out></option> 
										</c:forEach>
										
										</c:if> 
										
										</select> </div>
								</c:if> 
								
									<c:if test="${userObj.unitId==9832 && userObj.circleId==21614 }">
										
										  <div class="col-md-3">
										<label class="label-controlPMS rowlebel ">
										Select Year <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-3">
										<select class="form-control" id="caoyear" name="financialYear" required onchange="getParaGistByYearoffice(caounitId.value,caocircleId.value,caodivisionId.value,this.value,2)"> 
										<option value=" ">--select--</option>  
										
										
										</select> </div>
										</c:if>
										
										
										<div class="col-md-3">
										  <button type="button" name="showparagist" id="subparagistinfo" class="btn btn-primary" >Select Gist of Para </button>
											
										</div>
										
										<div class="col-md-3">
										  <button type="button" name="showpara" id="getsubparainfo" class="btn btn-primary" >Select Para</button>
											
										</div> 
										
										</div>
										
										<div class="col-md-12 invDiv"  >
										
										<div class="col-md-12" id="act-alertrep"></div>
										<div class="col-md-2" id="para-gist-num-did">
										 </div>
										 <div class="col-md-6" id="para-inf">
										 </div>
										  <div class="col-md-4" >
										 </div>
										 </div>
										 
										 <div class="col-md-12 invDiv"  >
										 
										 <div class="col-md-4 "></div>
										 
										 <div class="col-md-4 ">
										
										 	 <button type="button" name="viewsubParadata" id="viewsubParaid3"  class="btn btn-1 btn-primary center-block "  >View Para</button>
										 	  </div>
										 	  <div class="col-md-4 "></div>
										 </div>
										
										
										<div class="col-md-12 invDiv"  >
										
										 <div class="col-md-3" style="text-align: center;" >
											  <button type="button" name="reply" id="reply" class="btn btn-primary" >Add Replies</button>
											 </div>
											 
											 <div class="col-md-9" style="text-align: center;" >
											 
											 </div>
										
										</div>
										
									
								
				
			
				 &emsp;&emsp;&emsp;&emsp;
				 
				
				  
      <div class="col-md-12" id="reply_data_table">

  <div class="table-responsive">
     <table class="table table-striped table-bordered" id="reply_data">
       <thead id="reply-data-head">											
										
      <tr style="color: blue; ">
    
      
       <th style="text-align: center;"><b>Reply</b></th>
       <th style="text-align: center;"><b>Remarks</b></th>
        <th style="text-align: center;"><b>Reply Date</b></th>
       <th style="text-align: center;"><b>Edit</b></th>
        <th style="text-align: center;"><b>Delete</b></th>
    
      </tr>
      
    	</thead>
											
		<tbody id="reply-data-body">
		</tbody>
     </table>
    </div>
      </div>
      
     <div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<button type="button" name="gistform3" id="reply3"
									class="btn btn-1 btn-primary center-block parasbutton">Submit Replies</button>
										</div>
									</div>
   
				
				
				
					</form:form>	
					
					
						 &emsp;&emsp;
					 
					 <div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<button type="button" name="subreply" id="subreply2"
									class="btn btn-1 btn-primary center-block diaviewsubpara">View/Edit/Delete Submitted Reply Info</button>
										</div>
									</div>
					
					
					 &emsp;&emsp;
							<div class="col-md-12" id="add-reply-para">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="add-reply-para-tid">
											
											<thead id="add-reply-para-head">											
											</thead>
											
											<tbody id="add-reply-para-body">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
					
				
				</div>
				<div id="tgist4">
				
				<form:form id="parasinput4"  name="parasform4" method="post"  class="irparasform" modelAttribute="irparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
									<input name="unitId" value="${userObj.unitId}"  id="unitId4" type="hidden" />
		<input name="circleId" value="${userObj.circleId}"  id="circleId4" type="hidden" />
		<input name="divisionId" value="${userObj.divisionId}"  id="divisionId4" type="hidden" />
		<input name="subdivisionId" value="${userObj.subdivisionId}"  id="subdivisionId4" type="hidden" />
		<input name="paratabId" value="4"  id="paratabId4" type="hidden" />
		<input name="tunitId" value="0"  id="tunitId4" type="hidden" />
		<input name="tcircleId" value="0"  id="tcircleId4" type="hidden" />
		<input name="tdivisionId" value="0"  id="tdivisionId4" type="hidden" />
		<input name="tsubdivisionId" value="0"  id="tsubdivisionId4" type="hidden" />
		<input name="paraId" value="0"  id="paraId4" type="hidden" />
		<input name="subParaId" value="0"  id="subParaId4" type="hidden" />
		
				
				 <div class="col-md-12 invDiv">
					  <div class="col-md-3">
										<label class="label-controlPMS rowlebel ">
										Select Year <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-3">
										<select class="form-control" id="year4" name="financialYear" required onchange="getParaGistByYearoffice(unitId4.value,circleId4.value,divisionId4.value,this.value,3)"> 
										<option value=" ">--select--</option>  
										<c:if test="${finYearData!=null}">
										 <c:forEach items="${finYearData}" var="f">
										<option value="<c:out value="${f.financialYear}"></c:out>"><c:out value="${f.financialYear}"></c:out></option> 
										</c:forEach>
										
										</c:if> 
										
										</select> </div>
										
										
										<div class="col-md-3">
										  <button type="button" name="docparagist" id="docgistinfo" class="btn btn-primary" >Select Gist of Para</button>
											
										</div>
										
										<div class="col-md-3">
										  <button type="button" name="docpara" id="docsubparainfo" class="btn btn-primary" >Select Para</button>
											
										</div> 
										</div>
										
										
										<div class="col-md-12 invDiv"  >
										
										 <div class="col-md-12" id="act-alertdoc">  </div>
										 
										<div class="col-md-2" id="doc-gist-num-did">
										 </div>
										 <div class="col-md-6" id="doc-inf">
										 </div>
										  <div class="col-md-4" >
										 </div>
										 </div>
										 
										 <div class="col-md-12 invDiv"  >
										 
										  <div class="col-md-4 "></div>
										 
										 <div class="col-md-4 ">
										
										 	 <button type="button" name="docsubParadata" id="docsubParaid4"  class="btn btn-1 btn-primary center-block "  >View Para</button>
										 	  </div>
										 	  <div class="col-md-4 "></div>
										
										 
										 </div>
								
				 <div class="col-md-12 invDiv">
					   <div class="col-md-6"  >
										 <label class="label-controlPMS rowlebel ">Upload Files(Multiple)</label>
										 </div>
										 
										  <div class="col-md-6"  >
								<input id="uploadFile" name="uploadFile" type="file" 	class="btn-info" value="Upload Documents"  multiple="multiple"    data-parsley-max-file-size="3072"  data-parsley-fileextension='pdf,jpg,png'> 
							</div>
							
							</div>
										
							<div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<button type="button" name="gistform4" id="para4"
									class="btn btn-1 btn-primary center-block parasbutton">Submit Documents</button>
										</div>
									</div>
										
				
				
					
					</form:form>	
					
					 &emsp;&emsp;
							<div class="col-md-12" id="add-doc-list">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="add-doc-list-tid">
											
											<thead id="add-doc-list-head">											
											</thead>
											
											<tbody id="add-doc-list-body">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
				
				</div>
				
				
				<div id="tgist5">
				
				<form:form id="parasinput5" name="parasform5" method="post"  class="irparasform" modelAttribute="irparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
									<input name="unitId" value="${userObj.unitId}"  id="unitId5" type="hidden" />
		<input name="circleId" value="${userObj.circleId}"  id="circleId5" type="hidden" />
		<input name="divisionId" value="${userObj.divisionId}"  id="divisionId5" type="hidden" />
		<input name="subdivisionId" value="${userObj.subdivisionId}"  id="subdivisionId5" type="hidden" />
		<input name="paratabId" value="5"  id="paratabId5" type="hidden" />
		
		<input name="paraId" value="0"  id="paraId5" type="hidden" />
		<input name="transferFlag" value="false"  id="transferFlag5" type="hidden" />
				
				  <div class="col-md-12 invDiv">
					  <div class="col-md-3">
										<label class="label-controlPMS rowlebel ">
										Select Year <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-3">
										<select class="form-control" id="year5" name="financialYear" required onchange="getParaGistByYearoffice(unitId5.value,circleId5.value,divisionId5.value,this.value,4)"> 
										<option value=" ">--select--</option>  
										<c:if test="${finYearData!=null}">
										 <c:forEach items="${finYearData}" var="f">
										<option value="<c:out value="${f.financialYear}"></c:out>"><c:out value="${f.financialYear}"></c:out></option> 
										</c:forEach>
										
										</c:if> 
										
										</select> </div>
										
										
										
										
										<div class="col-md-6">
											 <button type="button" name="tpara" id="tparainfo" class="btn btn-primary" >Select Para</button>
										</div>
										</div>
										
											<div class="col-md-12 invDiv"  >
											 <div class="col-md-12" id="act-alerttr">
										 </div>
										<div class="col-md-2" id="t-gist-num-did">
										 </div>
										 <div class="col-md-6" id="t-inf">
										 </div>
										 
										  <div class="col-md-4" >
										 </div>
										 </div>
										
										
										
										<div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Unit <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="tunitId" name="tunitId"  onchange="gettCircles()" required> 
										<option value=" ">--select--</option>  
										 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
										
										
										</select> </div>
										
										<div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select circle  </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="tcircleId" name="tcircleId"   onchange="gettDivisions()"> 
										
										
										</select> </div>
										
										<div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select division </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="tdivisionId" name="tdivisionId" > 
										
										<!-- <option value="3">CAG Report</option> -->
										
										</select> </div>
										
										
								
				
					&emsp;&emsp;
										
						<div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<button type="button" name="gistform5" id="para5"
									class="btn btn-1 btn-primary center-block parasbutton">Submit Transfer</button>
										</div>
									</div>
										
				
				
					
					</form:form>	
				
				</div>
				</div>
				
			
					
					
					
					
					
						
				
				
				</div>
				
				
			</div>
		
	</div>
	

		</div> <!-- col-md-8 div -->
		
		 </div>	<!--panel body div -->
	

	</div>	<!-- panel div -->
	
	 

	

    
	
	
	<!-- data ends -->



<!--  dilogue starts -->


<div id="viewgist_dialogue">


<form:form id="getviewgist" method="post" modelAttribute="getsubparadata"
		name="getviewgistform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		<div id="view-gist-inf">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="sub-para-inf-tab">
											
											<thead id="view-gist-inf-head">											
											</thead>
											
											<tbody id="view-gist-inf-body">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
							
							
							
							
		
		
	
	</form:form>
	
		
		

</div>


<div id="getgist_dialogue">

	<form:form id="getgist" method="post" modelAttribute="getgistdata"
		name="getgistform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		
		<div id="viewgistinfo">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="viewgistinfoid">
											
											<thead id="viewgistinfohead">											
											</thead>
											
											<tbody id="viewgistinfobody">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
							
							
								<div id="viewsubparagistinfo">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="viewsubparagistinfoid">
											
											<thead id="viewsubparagistinfohead">											
											</thead>
											
											<tbody id="viewsubparagistinfobody">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
							
							<div id="doc-gist-info">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="doc-gist-info-tab">
											
											<thead id="doc-gist-info-head">											
											</thead>
											
											<tbody id="doc-gist-info-body">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
							
							<div id="t-gist-info">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="t-gist-info-tab">
											
											<thead id="t-gist-info-head">											
											</thead>
											
											<tbody id="t-gist-info-body">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
					

	</form:form>

</div>




<div id="getsubpara_dialogue">


<form:form id="getsubpara" method="post" modelAttribute="getsubparadata"
		name="getsubparaform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		
		<div id="sub-para-inf">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="sub-para-inf-tab">
											
											<thead id="sub-para-inf-head">											
											</thead>
											
											<tbody id="sub-para-inf-body">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
							
							
							<div id="doc-para-inf">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="doc-para-inf-tab">
											
											<thead id="doc-para-inf-head">											
											</thead>
											
											<tbody id="doc-para-inf-body">
											</tbody>
											
										</table>
									</div>


								</div>
							</div>
							
		
		
	
	</form:form>
	
		
		

</div>

 <div id="reply_dialog" title="Reply Data" class="col-md-12">
 
 <form:form id="replyinputform"  name="replyform" method="post"  class="irparasform" modelAttribute="irparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
								<input name="paraReplyId" value="0"  id="editparaReplyId" type="hidden" />
								<input name="subParaId" value="0"  id="editsubParaId" type="hidden" />
								<input name="editFlag" value="false"  id="editFlag" type="hidden" />
  <div class="col-md-12">
     <div class="col-md-6">
     <label class="label-controlPMS rowlebel "> Reply Date<font color=red>*</font> </label>
	</div>
	 <div class="col-md-6">
	  <span id="error_replyDate" class="text-danger"></span>
        <input type="text" name="replyDate" id="replyDate" class=" datepick form-control datepicker"  data-parsley-trigger="blur" 
		data-parsley-errors-container="#error_replyDate" data-parsley-error-message="Any relevant reply date is required"  readonly="readonly"   required />
       
       </div>
       </div>
     				
										
   
 
  <div class="col-md-12">
   	<label class="label-control rowlebel ">Reply<font color=red>*</font></label> 
	<textarea class="ckedit form-control"  id="replyAction" name="replyAction" rows="10" cols="80" placeholder="Reply"  
	data-parsley-errors-container="#eract" data-parsley-required-message="Please Enter Reply Information!"  data-parsley-group="block3" required="required" ></textarea>
    <span id="error_replyAction" class="text-danger"></span>
    </div>
     <div class="col-md-12 text-danger" id="eract"></div>
    
  
   <div class="col-md-12">
    <label class="label-control rowlebel ">Reply Remarks</label>
<textarea class="form-control"  id="replyRemarks" name="replyRemarks"  rows="10" cols="80" placeholder="Reply Remarks"  
 ></textarea> 
    <span id="error_replyRemarks" class="text-danger"></span>
    </div>
   
  
 <div class="col-md-12" style="text-align: center;">
    <input type="hidden" name="replyrow_id" id="replyrow_id" />
    <button type="button" name="savereply" id="savereply" class="btn btn-info" >Save</button>
    </div>
   
   
   </form:form>
  </div>
  
  
  
  <div id="edit-para-dialogue">
				
				
				<form:form id="editParainputform"  name="editParagist" method="post"  class="irparasform" modelAttribute="irparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
					 
					 
					 <input name="unitId" value="${userObj.unitId}"  id="unitId6" type="hidden" />
		<input name="circleId" value="${userObj.circleId}"  id="circleId6" type="hidden" />
		<input name="divisionId" value="${userObj.divisionId}"  id="divisionId6" type="hidden" />
		<input name="subdivisionId" value="${userObj.subdivisionId}"  id="subdivisionId6" type="hidden" />
		<input name="paratabId" value="1"  id="paratabId6" type="hidden" />
		<input name="paraId" value="0"  id="editparaId1" type="hidden" />
		
		
		   
					   		
<div class="col-md-12 invDiv">								

<div class="col-md-6">
										
										<div class="col-md-6">
											<label class="label-control rowlebel ">Financial Year <font color=red>*</font> </label>
											</div>
											
											<div class="col-md-6">
											 <select class="form-control" id="editfinancialYear1" name="financialYear" required > 
											 <option value=" ">--select--</option>
											
											 </select></div> 
											 
											 
										    	<div class="col-md-6">
										    <label class="label-controlPMS rowlebel ">
										    Para Number  <font color=red>*</font>  </label>
										    </div>
										    <div class="col-md-6">
										    <select class="form-control" id="editparaNumber1" name="paraNumber"  required>
										     <option value=" ">--select--</option> 
										     <option value="I">I</option> 
										     <option value="II">II</option> 
										     <option value="III">III</option>
										      <option value="IV">IV</option>
										      <option value="V">V</option>
										      <option value="VI">VI</option>
										      <option value="VII">VII</option>
										      <option value="VIII">VIII</option>
										      <option value="IX">IX</option>
										      <option value="X">X</option>
										      <option value="XI">XI</option>
										      <option value="XII">XII</option>
										      <option value="XII">XII</option>
										      <option value="XIII">XIII</option>
										      <option value="XIV">XIV</option>
										       <option value="XV">XV</option>
										         <option value="XVI">XVI</option>
										          <option value="XVII">XVII</option>
										           <option value="XVIII">XVIII</option>
										           <option value="XIX">XIX</option>
										             <option value="XX">XX</option>
										              <option value="XXI">XXI</option>
										               <option value="XXII">XXII</option>
										                <option value="XXIII">XXIII</option>
										                <option value="XXIV">XXIV</option>
										                 <option value="XXV">XXV</option>
										      </select> </div>
										      
										      
											 
											 
											  <div class="col-md-6">
											 <label class="label-control rowlebel ">File No.  </label>
											 </div>
											 
											 <div class="col-md-6">
											  <input type="text" class=" form-control"  id="editfileNumber" name="fileNumber" placeholder="Ex:9-40/08-09(AG File)"  /> 
											  </div>
											  
											   <div class="col-md-6">
											 <label class="label-control rowlebel ">LAR No.  </label>
											 </div>
											 
											 <div class="col-md-6">
											  <input type="text" class=" form-control"  id="editlarNumber" name="larNumber" placeholder="Ex:183/08-09"  /> 
											  </div>
											 
											 
										
											 
											 
											  <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Section <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="editsectionId" name="sectionId" required> 
										<option value=" ">--select--</option>  
										<option value="1">Section-A</option>
										<option value="2">Section-B</option>
										<!-- <option value="3">CAG Report</option> -->
										
										</select> </div>
										
										
										
										
										      
										      
										        <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Para Status  <font color=red>*</font>  </label>
										</div>
										<div class="col-md-6">
										<select class="paratrunit form-control" id="editparaStatusId" name="paraStatusId"  required> 
										<option value=" ">--select--</option> 
										 <option value="1">Reply Sent to AG</option>
									    <option value="2">Reply Not Sent</option> 										
									
										<option value="3">Dropped</option> 
									   <!--   <option value="4">Reply Sent to Government</option>  -->
									     
										 </select>
									     </div>
								
										
											</div>
											
											 <div class="col-md-6">
										
									      
										<div class="col-md-6">
											 <label class="label-control rowlebel ">Date of Audit <font color=red>*</font> </label>
											 </div>
											 
											 <div class="col-md-6">
											 <label class="label-control rowlebel ">from</label>
											  <input type="text" class="datepick form-control datepicker"  id="editauditDateFrom" name="auditDateFrom" placeholder="auditDateFrom"  readonly="readonly" value="0" required/> 
											  </div>
											  
											  
											  <div class="col-md-6"></div>
											   <div class="col-md-6">
											   <label class="label-control rowlebel ">to</label>
											  <input type="text" class="datepick form-control datepicker"  id="editauditDateTo" name="auditDateTo" placeholder="auditDateto"  readonly="readonly" value="0"  /> 
											  </div>
										
										<div class="col-md-12 row">	
										
											   <div class="col-md-6" id="cag" >
										 <label class="label-controlPMS rowlebel ">Included in CAG Report <font color=red>*</font> </label>
										 </div>
									
      
        <div class="col-md-6" id="statusdiv">
       
        
        <label class="radio-inline"> <input type="radio" name="printCAG" id="editprintCAGn"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="printCAG" id="editprintCAGy"     value="true"  required >Yes</label>
       
       
         
        </div>
        </div>
        <div class="col-md-12 row">
           <div class="col-md-6" id="inclproposed" >
										 <label class="label-controlPMS rowlebel ">Inclusion of Proposals in CAG Report <font color=red>*</font> </label>
										 </div>
										 
										   
        <div class="col-md-6" id="inclproposeddiv">
       
        
        <label class="radio-inline"> <input type="radio" name="inclPropCAG" id="editinclPropCAGy"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="inclPropCAG" id="editinclPropCAGn"     value="true"  required >Yes</label>
       
       
        </div>
        
        </div>
     
									</div>
									

	</div>		
	
	
	<div class="col-md-12">
        <label class="label-control rowlebel" >Gist of Para*</label> 
      
      <textarea class="form-control "  id="editactionTitle" name="actionTitle" rows="3" cols="80" placeholder="Para"    required> </textarea>
      
	</div>
											
		&emsp;&emsp;
									<div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<button type="button" name="gistform2" id="gist2"
									class="btn btn-1 btn-primary center-block editparagistbutton" onclick="submitgisteditdata()">Edit Gist</button>
										</div>
									</div>


							</form:form>
							
							
						
				
				</div>
				
				
				
				<div id="edit-sub-para-dialogue">
				
				<form:form id="editsubparadi" name="editsubparaform" method="post"  class="irparasform" modelAttribute="irparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
								<input name="unitId" value="${userObj.unitId}"  id="unitId2" type="hidden" />
		<input name="circleId" value="${userObj.circleId}"  id="circleId2" type="hidden" />
		<input name="divisionId" value="${userObj.divisionId}"  id="divisionId2" type="hidden" />
		<input name="subdivisionId" value="${userObj.subdivisionId}"  id="subdivisionId2" type="hidden" />
		<input name="paratabId" value="2"  id="editparatabId2" type="hidden" />
		
		
		<input name="subParaId" value="0"  id="editsubParaId2" type="hidden" />
		<input name="paraId" value="0"  id="editparaId2" type="hidden" />
		
	
				
			<%-- 	<div class="col-md-12 invDiv">
					 
											  <div class="col-md-3">
										<label class="label-control rowlebel ">
										Select Year  </label><font color=red>*</font>
										</div>
										
										 <div class="col-md-3">
										<select class="form-control" id="edityear2" name="financialYear" onchange="getParaGistByYearoffice(unitId.value,circleId.value,divisionId.value,this.value,1)" required> 
										<option value=" ">--select--</option> 
										<c:if test="${finYearData!=null}">
										 <c:forEach items="${finYearData}" var="f">
										<option value="<c:out value="${f.financialYear}"></c:out>"><c:out value="${f.financialYear}"></c:out></option> 
										</c:forEach>
										
										</c:if> 
										
										
										
										</select> </div>
										
										
										
										<div class="col-md-6">
																
									<button type="button" name="showgist" id="editshowgistid"  class="btn btn-1 btn-primary center-block "  >Show Gist of Para</button>
										
										</div>
									
									</div> --%>
									<!-- <div class="col-md-12 invDiv">	
										
										
										
										
										<div class="col-md-2" id="editparanumdid">
										 </div>
										 <div class="col-md-4" id="editviewparainf">
										 </div>
										  -->
										 
										<div class="col-md-12 invDiv">	
										 <div class="col-md-6">
										 <label class="label-control rowlebel ">
										Select Sub Category  </label>
										<select class="form-control" id="editsubcategory" name="subcategory" > 
										<option value="A">A</option>
										<option value="B">B</option> 
										<option value="C">C</option> 
										<option value="D">D</option> 
										<option value="E">E</option> 
										<option value="F">F</option> 
										<option value="G">G</option> 
										<option value="H">H</option> 
										<option value="I">I</option> 
										<option value="K">K</option> 
										<option value="L">L</option> 
										
										</select> </div>
										
										 <div class="col-md-6">
										 
										 <label class="label-controlPMS rowlebel ">
										Select Para Status  <font color=red>*</font>  </label>
										 
										 <select class="paratrunit form-control" id="editparaStatusId2" name="paraStatusId"  required> 
										<option value=" ">--select--</option> 
										 <option value="1">Reply Sent to AG</option>
									    <option value="2">Reply Not Sent</option>									
										<option value="3">Dropped</option> 
									   <!--   <option value="4">Reply Sent to Government</option>  -->
									     
										 </select>
										
										</div>
										
										
										
											 
											 </div>
											 
											 <div class="col-md-12 invDiv editrdelay" >		 
										
										
										 <div class="col-md-4">
										 <label class="label-control rowlebel ">
										Reasons For Delay <font color=red>*</font> </label>
										
										</div>
										
										 <div class="col-md-8">
										 
										 <textarea class="form-control "  id="editparareasonsDelay" name="parareasonsDelay" rows="2" cols="80" placeholder="parareasonsDelay"    required> </textarea>
										</div>
										
										</div>
										
								
      
				  &emsp;&emsp;  &emsp;&emsp;
				<div class="col-md-12">
	
	

  <div class="table-responsive">
     <table class="table table-striped table-bordered" id="editpara_data">
     
      <tbody>
    
      
      <tr>
      
     
        <td style="color: red;text-align: center;">
        	<label class="label-control rowlebel " >Para*</label> 
	<textarea class="ckedit form-control"  id="editparasAction" name="parasAction" rows="10" cols="80" placeholder="Para" 
	data-parsley-errors-container="#edpurpose-errors" data-parsley-required-message="Please Enter Para Information!" data-parsley-group="block2"></textarea>
     
       </td>
      
        
      </tr>
        <tr> <td></td> <td style="margin-bottom: 20px;color: red; text-align: center;" id="edpurpose-errors"></td></tr>
      
      
      </tbody>
     </table>
    </div>
      </div>
      
<div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<button type="button" name="editgistform2" id="editsubpara2"
									class="btn btn-1 btn-primary center-block "  onclick="submitSubParaeditdata()">Edit Para</button>
										</div>
									</div>
				
				
				</form:form>
				
				
					 
					
				</div>
				
				<div id="view-sub-para-3-dialogue">
				
				 <div class="col-md-2" id="subcat">
										 </div>
										<div class="col-md-10" id="subParadata">
										 </div>
				
				</div>
				
				<div id="view-sub-para-4-dialogue">
				
				   <div class="col-md-2" id="doccat">
										 </div>
										<div class="col-md-10" id="docsubdata">
										 </div>
										 
				
				</div>
				
				
				<div id="faqSpopup" class="ayucutFaq container">
    

   

    <div class="panel-group" id="accordion">
        <div class="faqHeader">General Clarifications</div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><b>Below Logins can be used to enter IR Paras</b></a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                     Office logins are allowed to enter Paras data.
                     Please ensure that data is not Duplicated.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTen"><b>Add Gist of Para</b></a>
                </h4>
            </div>
            <div id="collapseTen" class="panel-collapse collapse in">
                <div class="panel-body">
                   1.Add Gist of the Para<br>
                   2.File Number is Optional<br>
                   3.LAR Number is Optional<br>
                   4.Date of Audit can be relevant to the para year(Not shown in reports).<br>
                   5.If Para is printed in CAG report please mention  Yes or no Status.<br>
                   6.If Para is included in Proposals of CAG please mention yes or no status.<br>
                   7.By selecteing Year respective para gist data is displyed below is shown with Edit/Delete Action.<br>
                   8.In edit all the fields of para gist can be changed.<br>
                   9.please use delete carefully this will delete entire para,subparas,Replies and documents.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseEleven"><b>Add Para</b></a>
                </h4>
            </div>
            <div id="collapseEleven" class="panel-collapse collapse in">
                <div class="panel-body">
              
                  1.Select year <br>
                   2.Show gist of Para will display gist of the respective year then select gist of the para.<br>
                   3.Sub category is optional(Roman Numbers are not allowed)<br>
                   4.Select Para Status is  enabled by selecting gist of the para.<br>
                   5.Please provide your remarks in Reasons for delay/remarks.<br>
                   6.Copy your para without images.<br>
                   7.Click on view/edit/delete Submitted para info button to avail  Edit/Delete Action.<br>
                   8.In edit all the fields of Sub para can be changed.<br>
                   9.please use delete carefully this will delete entire subparas,Replies and documents.
                    
                </div>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse1"><b>Add Replies</b></a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse in">
                <div class="panel-body">
                
                1.Select year <br>
                   2.Select Gist.<br>
                   3.Select Sub Para<br>
                   4.Click on Add Reply to add Replies<br>
                   5.Reply Date is Mandatory(Any relevant date)<br>
                   6.Copy your para without images.<br>
                   7.Click on view/edit/delete Submitted Reply info button to avail  Edit/Delete Action.<br>
                   8.In edit all the fields of Reply can be changed.<br>
                   9.please use delete carefully this will delete respective reply .
                    
                  
                </div>
            </div>
        </div>
        
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse2"><b>Add Documents</b></a>
                </h4>
            </div>
            <div id="collapse2" class="panel-collapse collapse in">
                <div class="panel-body">
                
                 1.Select year <br>
                   2.Select Gist.<br>
                   3.Select Sub Para<br>
                   4.select files less than 3mb . only pdf format<br>                                  
                   5.After Submiting data  Delete Action is available.<br>                  
                   6.please use delete carefully this will delete Document .
                
                </div>
            </div>
        </div>
        
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse3"><b>Transfer To Other Office</b></a>
                </h4>
            </div>
            <div id="collapse3" class="panel-collapse collapse in">
                <div class="panel-body">
                
                   1.Select year <br>
                   2.Select Para.<br>               
                   3.Select respective office to which para should be transmitted.<br>                                  
                   4.Entire para including Replies and documents will be transferred to Other Office  .                
                 
                   
                </div>
            </div>
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
	

	
	

	
	
	
	
	
	
	
	
			

	











