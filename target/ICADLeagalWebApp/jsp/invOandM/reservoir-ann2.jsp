

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
<script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>

<style>
.ui-tabs-vertical { width: 45em; }
.ui-tabs-vertical .ui-tabs-nav { padding: .1em .1em .1em .1em; float: left; width: 8em; }
.ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
.ui-tabs-vertical .ui-tabs-nav li a { display:block; }
.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
.ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 30em;}
</style>


<script type="text/javascript">

$(document).ready(function(){
	
	
		 
	$('#unitId').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	$('#circleId').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	$('#divisionId').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	$('#subdivisionId').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	$('#reservoirId').multiselect({

		enableCaseInsensitiveFiltering : true

	});
	
	$('#projectId').multiselect({

		enableCaseInsensitiveFiltering : true

	});
	
	$('#designationId').multiselect({

		enableCaseInsensitiveFiltering : true

	});



	
	
	
	
	
	
	 
	 
	 
	

	}); 
	
	
$(function() {
	
	$(".datepick").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	
$("#addresjuris").click(function() {
	  var link = $(this).attr('href');
	  
	  alert(link);
	
	  $('#whereFormWillLive').load(link);
	 

	 // $(".content").load(link);
	});
	
/* 
$( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
$( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
 */
 $( "#tabs" ).tabs()
 
 
 

 $("#frequencyId").change(function() {
	  var freq = $(this).val();
	  
	 // alert(freq);
	  
	 

	
	});
	
});



</script>

<div class="col-md-9">



<div>

	<div class="panel panel-primary " >
		<div class="panel-heading">
			<h3 class="panel-title">O&M of Reservoir:Reservoir-Annexure-II</h3>
		</div>
			
	<div class="panel-body">	
	
	<div class="alert alert-info col-md-12" style="padding: 0px;"
				id="action_alert"></div>
	
	
		
		<div class="col-md-12 invDiv">

					
						<form:form id="mainformid" name="mainformname"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">


				<div class="col-md-12" >
					<br />
					<br />
					<div class="col-md-6">
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Unit: <font
								color=red>*</font>
							</label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="unitId" name="unitId"
								required onchange="getProjects(this.value,1);getCircles(this.value,1)" >
									<option value=" ">--select--</option>

							<c:forEach items="${unitList}" var="u">
								<option value="${u.unitId}">${u.unitName}</option>

							</c:forEach>



							</select>
						</div>

						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Circle:
								
							</label>
						</div>
						<div class="col-md-6">
							<select class="form-control" id="circleId" name="circleId"
								 onchange="getDivisions(this.value,1)">
								


							</select>
						</div>


						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select
								Division: 
							</label>
						</div>
						<div class="col-md-6">
							<select class="form-control" id="divisionId" name="divisionId"
								 onchange="getSubDivisions(this.value,1)">
								

							</select>
						</div>

						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Sub
								Division: 
							</label>
						</div>
						<div class="col-md-6">
							<select class="form-control" id="subdivisionId" name="subdivisionId"
								>
								


							</select>
						</div>


					</div>
					<div class="col-md-6">

						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Project:
								<font color=red>*</font>
							</label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="projectId" name="projectId"
								required onchange="getReservoirs(this.value,1)">
								


							</select>
						</div>
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select
								Reservoir: <font color=red>*</font>
							</label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="reservoirId" name="reservoirId"
								required onchange="getResHealthData(this.value),getResRecommendData(this.value),getResActionTakenData(this.value)">
								


							</select>
						</div>
						
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select
								 For Approval: <font color=red>*</font>
							</label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="empId" name="empId"
								required>
									<option value=" ">--select--</option>

							<c:forEach items="${getempapprove}" var="u">
								<option value="${u.empId}">${u.empName}</option>

							</c:forEach>


							</select>
						</div>
						

					
						
						<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Frequency: <font
							color=red>*</font>
						</label>
					</div>
					<div class="col-md-6">
						<select class="form-control" id="dutyFrequencyId" name="dutyFrequencyId"
							 required>
							<option value=" ">--select--</option>
							<option value="9">PRE MONSOON (April,May)</option>
							<option value="10">POST MONSOON (November,December)</option>
							<option value="11">DURING MONSOON(JUNE TO AUGUEST)</option>
						

						</select>
					</div>
					
					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Year <font
							color=red>*</font>
						</label>
					</div>
					<div class="col-md-6">
						<select class="form-control" id="year" name="year" onchange="getann2inspectdata(this.value)"
							 required>
							<option value=" ">--select--</option>
							<option value="2019">2019</option>
							<option value="2020">2020</option>
						
						

						</select>
					</div>
						
						
						


					</div>



				</div>

</form:form>

			</div>
		
	
		
		
		<div id="result" class="col-md-12" style="padding-right:0px !important;padding-left:0px !important;">
	<div class="wrapper">
		
			<div id="tabs">
				<ul>
					<li><a href="#eart" onclick="getcheckfalse1()">A.EARTH DAM</a></li>
					<li><a href="#maso" onclick="getcheckfalse2()">B.MASONARY / CONCRETE  DAM :</a></li>
					<li><a href="#comm" onclick="getcheckfalse3()">C.COMMUNICATION FACILITIES</a></li>
					<li><a href="#gen" onclick="getcheckfalse4()">D.GENERAL ASSESMENTS OF CONDITION OF THE DAM</a></li>
					<li><a href="#health" onclick="getcheckfalse5()">RESERVOIR HEALTH STATUS</a></li>
					<li><a href="#rec" onclick="getcheckfalse6()">RECOMMENDATIONS</a></li>
					<li><a href="#act" onclick="getcheckfalse7()">ACTION TAKEN STATUS</a></li>
				</ul>
				<div id="eart">
				
					<form:form id="resann2form1" name="resann2form1name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
					
						<c:if test="${rescatList!=null}">
						
						
						<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId1" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId1" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId1" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId1" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId1" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId1" type="hidden" />
							
						                   <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId1" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId1" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId1" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year1"
									type="hidden" />
									
									 <input name="reservoirInspectList[0].tabId" value="1" id="tabId1" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId1" type="hidden" /> 
						                
						                   <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId1" type="hidden" /> 
						
						
						

					   <c:forEach items="${rescatList}" var="m" varStatus="mcount">
					   
					   <c:if test="${m.resCatParentId==5}"> 
						    	 <div class="col-md-12 invDiv" style="color:maroon; "><h3><b><c:out value="${m.resCategory}"></c:out></b></h3></div>
						    	 
						    	 </c:if>
						    	   <c:forEach items="${rescheckann2a}" var="n" varStatus="ncount">
						    	   <c:if test="${n.resCategoryId==m.resCategoryId && m.resCatParentId==5}">
					  <div class="row col-md-12">
					  
					   <div class="col-md-1">
                     ${n.resCheckSeq}
                     </div> 
                     <div class="col-md-1">
                       <input
													name="reservoirInspectList[${ncount.count}].resCheckboxId"
													class="rescustomcheck1" value="0"
													id="aresCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
					  <div class="col-md-4">
					  
					  <label class="label-control rowlebel invDiv "
													for="parameter1"> ${n.resCheck}</label> <input
													name="reservoirInspectList[${ncount.count}].resCheckId"
													value="${n.resCheckId}" id="aresCheckId${ncount.count}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="aresCatId${ncount.count}"
													name="reservoirInspectList[${ncount.count}].resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-4">	 
				<textarea class="form-control" id="aremarks${ncount.count}"
													name="reservoirInspectList[${ncount.count}].remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					
					<div class="col-md-2">
                     <button type="button" name="aedit" id="aedit" class="btn btn-1 btn-primary center-block" >Edit</button> 
                     <button type="button" name="adelet" id="adelete" class="btn btn-1 btn-primary center-block" >Delete</button> 
                     </div> 
						<br />
							<br />
					
					</div>
					</c:if>
					
					
					</c:forEach>
				</c:forEach>
				 	  </c:if>
						<br />
						 <button type="button" name="rescheckbutton1" id="rescheckbutton1" class="btn btn-1 btn-primary center-block rescheckbutton" >Submit</button>
					</form:form>
				</div>
				<div id="maso">
				
						<form:form id="resann2form2" name="resann2form2name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						<c:if test="${rescatList!=null}">
						
						<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId2" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId2" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId2" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId2" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId2" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId2" type="hidden" />
								 <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId2" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId2" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId2" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year2"
									type="hidden" />
									
									 <input name="reservoirInspectList[0].tabId" value="2" id="tabId2" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId2" type="hidden" /> 
						    <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId2" type="hidden" /> 
						    
						     
						
						

					   <c:forEach items="${rescatList}" var="m" varStatus="mcount">
					   
					    
						    	 <c:if test="${ m.resCatParentId==6 }"> 
						    	 <div class="col-md-12 invDiv" style="color:maroon; "><h3><b><c:out value="${m.resCategory}"></c:out></b></h3></div>
						    	 
						    		 </c:if>
						    	 
						    		<%-- <c:set var="bseq" value="1" scope="page" />  --%>
						    	  <c:forEach items="${rescheckann2b}" var="n" varStatus="ncount">
						    	  
						    	   <c:if test="${n.resCategoryId==m.resCategoryId && m.resCatParentId==6 && n.isTitle==true}">
						    	       <div class="col-md-12 invDiv" style="color:blue; ">
						    	        <div class="col-md-1">
                     ${n.resCheckSeq}
                     </div> <div class="col-md-11">
						    	       <h4><b><c:out value="${n.resCheck}"></c:out></b></h4> </div></div>
						    	      </c:if>
						    	  
						    	  
						    	   <c:if test="${n.resCategoryId==m.resCategoryId && m.resCatParentId==6 && n.isTitle==false }">
					  <div class="row col-md-12">
					  
					   <div class="col-md-1">
                     ${n.resCheckSeq}
                     </div> 
                     <div class="col-md-1">
                      <input
													name="reservoirInspectList[${ncount.count}].resCheckboxId"
													class="rescustomcheck2" value="0"
													id="bresCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
					  <div class="col-md-4">
					  
					   <label class="label-control rowlebel invDiv "
													for="parameter1"> ${n.resCheck}</label> <input
													name="reservoirInspectList[${ncount.count}].resCheckId"
													value="${n.resCheckId}" id="bresCheckId${ncount.count}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="bresCatId${ncount.count}"
													name="reservoirInspectList[${ncount.count}].resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-4">	 
				<textarea class="form-control" id="bremarks${ncount.count}"
													name="reservoirInspectList[${ncount.count}].remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					<div class="col-md-2">
                     <button type="button" name="bedit" id="bedit" class="btn btn-1 btn-primary center-block" >Edit</button> 
                     <button type="button" name="bdelete" id="bdelete" class="btn btn-1 btn-primary center-block" >Delete</button> 
                     </div> 
						<br />
							<br />
					
					</div>
					</c:if>
					
						</c:forEach>	
				
					<%-- <c:set var="bseq" value="${bseq + 1}" scope="page"/> --%>
				
						    	 
						    	 
						    	 
						    	  
					   
					    <c:if test="${m.resCatParentId==19 }"> 
						    	 <div class="col-md-12 invDiv" style="color:maroon; "><h3><b><c:out value="${m.resCategory}"></c:out></b></h3></div>
						 
						     </c:if>	 
					  	  <c:forEach items="${rescheckann2b}" var="n" varStatus="ncount"> 
					 <c:if test="${n.resCategoryId==m.resCategoryId && m.resCatParentId==19 }">
					  <div class="row col-md-12">
					  
					   <div class="col-md-1">
                     ${n.resCheckSeq}
                     </div> 
                     <div class="col-md-1">
                   <input
													name="reservoirInspectList[${ncount.count}].resCheckboxId"
													class="rescustomcheck2" value="0"
													id="bsresCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
					  <div class="col-md-4">
					  
					   	<label class="label-control rowlebel invDiv "
													for="parameter1"> ${n.resCheck}</label> <input
													name="reservoirInspectList[${ncount.count}].resCheckId"
													value="${n.resCheckId}" id="bresCheckId${ncount.count}"
													type="hidden" /> <input type="hidden" class="form-control"
													id="bresCatId${ncount.count}"
													name="reservoirInspectList[${ncount.count}].resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-4">	 
						<textarea class="form-control" id="bremarks${ncount.count}"
													name="reservoirInspectList[${ncount.count}].remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					<div class="col-md-2">
                     <button type="button" name="bedit" id="bedit" class="btn btn-1 btn-primary center-block" >Edit</button> 
                     <button type="button" name="bdelete" id="bdelete" class="btn btn-1 btn-primary center-block" >Delete</button> 
                     </div> 
						<br />
							<br />
					
					</div>
					</c:if>
				<%-- 	<c:set var="bseq" value="${bseq + 1}" scope="page"/> --%>
				 </c:forEach> 
						    	 
						    	
					    	
				 </c:forEach> 
				 	  </c:if>
						<br />
						 <button type="button" name="rescheckbutton2" id="rescheckbutton2" class="btn btn-1 btn-primary center-block rescheckbutton" >Submit</button>
					</form:form>
				</div>
				
				<div id="comm">
				
				<form:form id="resann2form3" name="resann2form3name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
					<c:if test="${rescatList!=null}">
					
					<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId3" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId3" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId3" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId3" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId3" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId3" type="hidden" />
							 <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId3" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId3" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId3" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year3"
									type="hidden" />
									 <input name="reservoirInspectList[0].tabId" value="3" id="tabId3" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId3" type="hidden" /> 
						    <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId3" type="hidden" /> 
						

					
					   
					 	<c:set var="seq" value="1" scope="page" />
						    	   <c:forEach items="${rescheckann2c}" var="n" varStatus="ncount">
						    	   
						    	      <c:if test="${n.isTitle==true}">
						    	       <div class="col-md-12 invDiv" style="color:blue; ">
						    	        <div class="col-md-1">
                     ${n.resCheckSeq}
                     </div> <div class="col-md-11">
						    	       <h4><b><c:out value="${n.resCheck}"></c:out></b></h4> </div></div>
						    	      </c:if>
						    	    
						    	   <c:if test="${ n.isTitle==false}">
					  <div class="row col-md-12">
					  
					   <div class="col-md-1">
                     ${n.resCheckSeq}
                     </div> 
                     <div class="col-md-1">
                    <input name="reservoirInspectList[${ncount.count}].resCheckboxId"  class="rescustomcheck3" value="0"  id="cresCheckboxId${ncount.count}" type="checkbox" />
                     </div> 
					  <div class="col-md-4">
					  
					   <label class="label-control rowlebel invDiv " for="parameter1"> ${n.resCheck}</label>
					   

												     <input
													name="reservoirInspectList[${ncount.count}].resCheckId"
													value="${n.resCheckId}" id="cresCheckId${ncount.count}"
													type="hidden" /> 
													
													<input type="hidden" class="form-control"
													id="cresCatId${ncount.count}"
													name="reservoirInspectList[${ncount.count}].resCatId"
													value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-4">	 
					<textarea class="form-control" id="cremarks${ncount.count}"
													name="reservoirInspectList[${ncount.count}].remarks"
													rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					<div class="col-md-2">
                     <button type="button" name="cedit" id="cedit" class="btn btn-1 btn-primary center-block" >Edit</button> 
                     <button type="button" name="cdelet" id="cdelete" class="btn btn-1 btn-primary center-block" >Delete</button> 
                     </div> 
					<c:set var="seq" value="${seq + 1}" scope="page"/>
						<br />
							<br />
					
					</div>
					</c:if>
					</c:forEach>
					
				
				 	  </c:if>	<br />
					
						 <br />
						 <button type="button" name="rescheckbutton3" id="rescheckbutton3" class="btn btn-1 btn-primary center-block rescheckbutton" >Submit</button>
					</form:form>
				
				
				</div>
				
				<div id="gen">
				
				<form:form id="resann2form4" name="resann2form4name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						<c:if test="${rescatList!=null}">
						
						<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId4" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId4" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId4" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId4" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId4" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId4" type="hidden" />
								 <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId4" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId4" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId4" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year4"
									type="hidden" />
									 <input name="reservoirInspectList[0].tabId" value="4" id="tabId4" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId4" type="hidden" /> 
    <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId4" type="hidden" /> 
					
					   
					  
						    	   <c:forEach items="${rescheckann2d}" var="n" varStatus="ncount">
						    
					  <div class="row col-md-12">
					  
					   <div class="col-md-1">
                     ${n.resCheckSeq}
                     </div> 
                     <div class="col-md-1">
                     
                     <input name="reservoirInspectList[${ncount.count}].resCheckboxId" 	class="rescustomcheck4" value="0"  id="dresCheckboxId${ncount.count}" type="checkbox" />
                    
                     </div> 
					  <div class="col-md-4">
					  
					   <label class="label-control rowlebel invDiv " for="parameter1"> ${n.resCheck}</label>
					  
					    <input name="reservoirInspectList[${ncount.count}].resCheckId" 	value="${n.resCheckId}" id="dresCheckId${ncount.count}" 	type="hidden" /> 
					    <input type="hidden" class="form-control" id="dresCatId${ncount.count}" 	name="reservoirInspectList[${ncount.count}].resCatId"  value="${n.resCategoryId}" />
						</div> 
					<div class="col-md-4">	 
				<textarea class="form-control" id="dremarks${ncount.count}" 	name="reservoirInspectList[${ncount.count}].remarks" rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					<div class="col-md-2">
                     <button type="button" name="dedit" id="dedit" class="btn btn-1 btn-primary center-block" >Edit</button> 
                     <button type="button" name="ddelet" id="ddelete" class="btn btn-1 btn-primary center-block" >Delete</button> 
                     </div> 
						<br />
							<br />
					
					</div>
			
					</c:forEach>
		
				 	  </c:if>	<br />
					
						 <br />
						 <button type="button" name="rescheckbutton4" id="rescheckbutton4" class="btn btn-1 btn-primary center-block rescheckbutton" >Submit</button>
					</form:form>
				
				
				</div>
				<div id="health">
				
				<form:form id="resann2form5" name="resann2form5name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
						
						
						<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId5" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId5" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId5" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId5" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId5" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId5" type="hidden" />
							 <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId5" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId5" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId5" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year5"
									type="hidden" />
									
									 <input name="reservoirInspectList[0].tabId" value="5" id="tabId5" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId5" type="hidden" /> 
                                       <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId5" type="hidden" /> 
                                       
                                       <div class="row">
					<div class="col-md-1">
                     
                     <input name="reservoirInspectList[0].resCheckboxId" 	class="rescustomcheck5" value="0"  id="resCheckboxId0" type="checkbox" />
                    
                     </div> 
					   <div class="col-md-5">
							<label class="label-controlPMS rowlebel ">Select
								Category: <font color=red>*</font>
							</label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="resCategoryId" name="reservoirInspectList[0].resCategoryId"
								required>
								<option value=" ">--select--</option>
								<option value="1">1-Deficiencies which may lead to failure</option>
								<option value="2">2-Major Deficiencies required for  prompt remediable measures</option>
								<option value="3">3-Minor remediable measures which are rectifiable during the year</option>
								


							</select>
						</div>
						<div class="col-md-6"> 
    <label class="label-controlPMS rowlebel ">Select Inspection Date:: <font
							color=red>*</font>
						</label>	
						</div>
    
    <div class="col-md-6">
					
					
					
					<select class="form-control" id="restab5inspectDate" name="inspectDate"
								required>
								

							</select>
					</div>
						 <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Significant Deficiencies Noticed: <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
				<textarea class="form-control" id="restab5remarks" 	name="reservoirInspectList[0].remarks" rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					  
						</div>   	
					
						 <br />
						 <button type="button" name="rescheckbutton5" id="rescheckbutton5" class="btn btn-1 btn-primary center-block rescheckbutton" >Submit</button>
					</form:form>
					
					<div id="reshealth"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table5">
						<thead id="thead5"> </thead>
						
						<tbody id="tbody5"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>
				
				
				</div>
				
				<div id="rec">
				
				<form:form id="resann2form6" name="resann2form6name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
					
						
						<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId6" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId6" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId6" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId6" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId6" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId6" type="hidden" />
								 <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId6" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId6" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId6" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year6"
									type="hidden" />
									 <input name="reservoirInspectList[0].tabId" value="6" id="tabId6" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId6" type="hidden" /> 
                                           <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId6" type="hidden" /> 
                                <div class="row">             
                                           <div class="col-md-1">
                     
                     <input name="reservoirInspectList[0].resCheckboxId" 	class="rescustomcheck6" value="0"  id="resCheckboxId0" type="checkbox" />
                    
                     </div> 
                     
                     <div class="col-md-5">
							<label class="label-controlPMS rowlebel ">Latest Health Status: <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
						 <input name="reservoirInspectList[0].resDamHealthId" value="1" id="resDamHealthId" type="hidden" /> 
						
				<textarea class="form-control" id="reslatesthealth"  rows="3" cols="50" placeholder="Observations" readonly="readonly"> </textarea>
					</div>
					<div class="col-md-6"> 
    <label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>	
						</div>
						
						
    <div class="col-md-6">
					
					<input
				type="text" class=" datepick form-control datepicker" id="inspectDate" name="reservoirInspectList[0].inspectDate"
				placeholder="dateofoperation"  />
					</div>
					    <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Recommendations by SDSO /SDSIT : <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
				<textarea class="form-control" id="recomendbysdso" 	name="reservoirInspectList[0].recomendbysdso" rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					  
					</div>	
						
						
						 <br />
						 <button type="button" name="rescheckbutton6" id="rescheckbutton6" class="btn btn-1 btn-primary center-block rescheckbutton" >Submit</button>
						 
						 
					
					</form:form>
					
					 <div id="resrecommend"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table6">
						<thead id="thead6"> </thead>
						
						<tbody id="tbody6"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>    	
				
				
				</div>
				
				<div id="act">
				
				<form:form id="resann2form7" name="resann2form7name"
								modelAttribute="resann2checkList" method="post"
								data-parsley-validate-if-empty="">
					
						
						<input name="reservoirInspectList[0].unitId" value="0"
									id="resunitId7" type="hidden" />
								<input name="reservoirInspectList[0].circleId" value="0"
									id="rescircleId7" type="hidden" />
								<input name="reservoirInspectList[0].divisionId" value="0"
									id="resdivisionId7" type="hidden" />
								<input name="reservoirInspectList[0].subdivisionId" value="0"
									id="ressubdivisionId7" type="hidden" />
								<input name="reservoirInspectList[0].projectId" value="0"
									id="resprojectId7" type="hidden" />
								<input name="reservoirInspectList[0].reservoirId" value="0"
									id="resreservoirId7" type="hidden" />
								 <c:if test="${userObj!=null && userObj.designationId!=null}">
						             
						               <c:if test="${userObj.designationId>0}">
						               <input name="reservoirInspectList[0].designationId" value="${userObj.designationId}" id="resdesignationId7" type="hidden" /> 
						               </c:if>
						              </c:if>
						              
						              <c:if test="${userObj!=null && userObj.designationId==null}">
						           
						               <c:if test="${userObj.designationId==0}">
						               <input name="reservoirInspectList[0].designationId" value="0" id="resdesignationId7" type="hidden" /> 
						               </c:if>
						              </c:if>
								<input name="reservoirInspectList[0].resCode" value="0"
									id="resresCodeId7" type="hidden" />
								<input name="reservoirInspectList[0].year" value="0" id="year7"
									type="hidden" />
									 <input name="reservoirInspectList[0].tabId" value="7" id="tabId7" type="hidden" /> 
						                <input name="reservoirInspectList[0].levelId" value="0" id="levelId7" type="hidden" /> 
						                    <input name="reservoirInspectList[0].dutyFrequencyId" value="0" id="dutyFrequencyId7" type="hidden" /> 
						               <div class="row">     
						                     <div class="col-md-1">
                     
                     <input name="reservoirInspectList[0].resCheckboxId" 	class="rescustomcheck7" value="0"  id="resCheckboxId0" type="checkbox" />
                    
                     </div> 
            <div class="col-md-5">
							<label class="label-controlPMS rowlebel ">Latest Health Status: <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
						 <input name="reservoirInspectList[0].resDamHealthId" value="1" id="resDamHealthId" type="hidden" /> 
						
				<textarea class="form-control"  rows="3" cols="50" placeholder="Observations" readonly="readonly"> text here</textarea>
					</div>
					        <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Latest Recommendation: <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
						 <input name="reservoirInspectList[0].resRecommendId" value="1" id="resRecommendId" type="hidden" /> 
						
				<textarea class="form-control"  rows="3" cols="50" placeholder="Observations" readonly="readonly"> text here recommend</textarea>
					</div>

					 <div class="col-md-6">
				<label class="label-controlPMS rowlebel ">Whether Action initiated  :<font
							color=red>*</font>
						</label>
						</div>
						
						  <div class="col-md-6">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakeninit" id="actionTakeninitn"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakeninit" id="actionTakeninity"     value="true"   >Yes</label>
       
          
    </div>
    
     <div class="col-md-6">
				<label class="label-controlPMS rowlebel ">Whether action completed  :<font
							color=red>*</font>
						</label>
						</div>
						
						  <div class="col-md-6">	
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompleten"     value="false"   >NO</label>
        <label class="radio-inline"> <input type="radio" class="myradio" name="reservoirInspectList[0].actionTakencomplete" id="actionTakencompletey"     value="true"   >Yes</label>
       
          
    </div>
    <div class="col-md-6"> 
    <label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>	
						</div>
    
    <div class="col-md-6">
					
					<input
				type="text" class=" datepick form-control datepicker" id="restab7inspectDate" name="reservoirInspectList[0].inspectDate"
				placeholder="dateofoperation"  />
					</div>
					   
					   <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Remarks/Reasons for pending  : <font color=red>*</font>
							</label>
						</div>
						<div class="col-md-6">	 
				<textarea class="form-control" id="restab7remarks" 	name="reservoirInspectList[0].remarks" rows="3" cols="50" placeholder="Observations"></textarea>
					</div>
					</div>
						    	   
					
						 <br />
						 <button type="button" name="rescheckbutton7" id="rescheckbutton7" class="btn btn-1 btn-primary center-block rescheckbutton" >Submit</button>
					</form:form>
					
					
					 <div id="acttaken"> 
					
					<div class="show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%" id="table7">
						<thead id="thead7"> </thead>
						
						<tbody id="tbody7"></tbody>
							</table>
							</div>
							</div>
					
					
					
					</div>    	
				
				
				
				</div>
			</div>
		
	</div>
	

		</div> <!--  div -->
	</div>	
		 </div>	<!-- panel div -->
	
</div> <!-- row -->
	</div>	<!-- container -->
	
	

	

    
	
	
	<!-- data ends -->



<!--  dilogue starts -->

	
	<script type="text/javascript">
	
	function getcheckfalse1(){	
	/* 	$('.rescustomcheck2').prop('checked', false);
		$('.rescustomcheck3').prop('checked', false);
		$('.rescustomcheck4').prop('checked', false); */
		$('.rescheckbutton').hide();
		$('#action_alert').empty();
		
	}

	function getcheckfalse2(){	
	/* 	$('.rescustomcheck1').prop('checked', false);
		$('.rescustomcheck3').prop('checked', false);
		$('.rescustomcheck4').prop('checked', false); */
		$('.rescheckbutton').hide();
		$('#action_alert').empty();
		
	}


	function getcheckfalse3(){	
		/* $('.rescustomcheck1').prop('checked', false);
		$('.rescustomcheck2').prop('checked', false);
		$('.rescustomcheck4').prop('checked', false); */
		$('.rescheckbutton').hide();
		$('#action_alert').empty();
		
	}

	function getcheckfalse4(){	
	/* 	$('.rescustomcheck1').prop('checked', false);
		$('.rescustomcheck2').prop('checked', false);
		$('.rescustomcheck3').prop('checked', false); */
		$('.rescheckbutton').hide();
		$('#action_alert').empty();
		
	}

	
	
	</script>
	

	
	
	
	

<script type="text/javascript">
	$(function() {

		$('.rescheckbutton').hide();

		$('.rescustomcheck1')
				.click(
						function() {

							var checkid = $(this).prop('id');

							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == true) {
								$(this).val(1);

							}
							//class=mycustomcheck
							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == false) {
								$(this).val(0);

							}
							//   alert( "uncome"); 

							var numberNotChecked = $('input:checkbox[class=rescustomcheck1]:not(":checked")').length;
							var numberOfChecked = $('input:checkbox[class=rescustomcheck1]:checked').length;

							//   alert( "un"+numberNotChecked);
							//   alert("mat"+numberOfChecked);

							//  alert( "diff"+(numberOfChecked-numberNotChecked) );

							if ((numberOfChecked) >= 1) {
								$('.rescheckbutton').show();
							} else {

								$('.rescheckbutton').hide();
							}

						});
		$('.rescustomcheck2')
				.click(
						function() {

							var checkid = $(this).prop('id');

							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == true) {
								$(this).val(1);

							}
							//class=mycustomcheck
							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == false) {
								$(this).val(0);

							}
							//   alert( "uncome"); 

							var numberNotChecked = $('input:checkbox[class=rescustomcheck2]:not(":checked")').length;
							var numberOfChecked = $('input:checkbox[class=rescustomcheck2]:checked').length;

							//   alert( "un"+numberNotChecked);
							//   alert("mat"+numberOfChecked);

							//   alert( "diff"+(numberOfChecked-numberNotChecked) );

							if ((numberOfChecked) >= 1) {
								$('.rescheckbutton').show();
							} else {

								$('.rescheckbutton').hide();
							}

						});

		$('.rescustomcheck3')
				.click(
						function() {

							var checkid = $(this).prop('id');

							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == true) {
								$(this).val(1);

							}
							//class=mycustomcheck
							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == false) {
								$(this).val(0);

							}
							//   alert( "uncome"); 

							var numberNotChecked = $('input:checkbox[class=rescustomcheck3]:not(":checked")').length;
							var numberOfChecked = $('input:checkbox[class=rescustomcheck3]:checked').length;

							//   alert( "un"+numberNotChecked);
							//   alert("mat"+numberOfChecked);

							//   alert( "diff"+(numberOfChecked-numberNotChecked) );

							if ((numberOfChecked) >= 1) {
								$('.rescheckbutton').show();
							} else {

								$('.rescheckbutton').hide();
							}

						});

		$('.rescustomcheck4')
				.click(
						function() {

							var checkid = $(this).prop('id');

							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == true) {
								$(this).val(1);

							}
							//class=mycustomcheck
							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == false) {
								$(this).val(0);

							}
							//   alert( "uncome"); 

							var numberNotChecked = $('input:checkbox[class=rescustomcheck4]:not(":checked")').length;
							var numberOfChecked = $('input:checkbox[class=rescustomcheck4]:checked').length;

							//  alert( "un"+numberNotChecked);
							//  alert("mat"+numberOfChecked);

							//   alert( "diff"+(numberOfChecked-numberNotChecked) );

							if ((numberOfChecked) >= 1) {
								$('.rescheckbutton').show();
							} else {

								$('.rescheckbutton').hide();
							}

						});
		$('.rescustomcheck5')
		.click(
				function() {

					var checkid = $(this).prop('id');

					if ($('input:checkbox[id=' + checkid + ']').is(
							':checked') == true) {
						$(this).val(1);

					}
					//class=mycustomcheck
					if ($('input:checkbox[id=' + checkid + ']').is(
							':checked') == false) {
						$(this).val(0);

					}
					//   alert( "uncome"); 

					var numberNotChecked = $('input:checkbox[class=rescustomcheck5]:not(":checked")').length;
					var numberOfChecked = $('input:checkbox[class=rescustomcheck5]:checked').length;

					//  alert( "un"+numberNotChecked);
					//  alert("mat"+numberOfChecked);

					//   alert( "diff"+(numberOfChecked-numberNotChecked) );

					if ((numberOfChecked) >= 1) {
						$('.rescheckbutton').show();
					} else {

						$('.rescheckbutton').hide();
					}

				});
		
		$('.rescustomcheck6')
		.click(
				function() {

					var checkid = $(this).prop('id');

					if ($('input:checkbox[id=' + checkid + ']').is(
							':checked') == true) {
						$(this).val(1);

					}
					//class=mycustomcheck
					if ($('input:checkbox[id=' + checkid + ']').is(
							':checked') == false) {
						$(this).val(0);

					}
					//   alert( "uncome"); 

					var numberNotChecked = $('input:checkbox[class=rescustomcheck6]:not(":checked")').length;
					var numberOfChecked = $('input:checkbox[class=rescustomcheck6]:checked').length;

					//  alert( "un"+numberNotChecked);
					//  alert("mat"+numberOfChecked);

					//   alert( "diff"+(numberOfChecked-numberNotChecked) );

					if ((numberOfChecked) >= 1) {
						$('.rescheckbutton').show();
					} else {

						$('.rescheckbutton').hide();
					}

				});
		
		$('.rescustomcheck7')
		.click(
				function() {

					var checkid = $(this).prop('id');

					if ($('input:checkbox[id=' + checkid + ']').is(
							':checked') == true) {
						$(this).val(1);

					}
					//class=mycustomcheck
					if ($('input:checkbox[id=' + checkid + ']').is(
							':checked') == false) {
						$(this).val(0);

					}
					//   alert( "uncome"); 

					var numberNotChecked = $('input:checkbox[class=rescustomcheck7]:not(":checked")').length;
					var numberOfChecked = $('input:checkbox[class=rescustomcheck7]:checked').length;

					//  alert( "un"+numberNotChecked);
					//  alert("mat"+numberOfChecked);

					//   alert( "diff"+(numberOfChecked-numberNotChecked) );

					if ((numberOfChecked) >= 1) {
						$('.rescheckbutton').show();
					} else {

						$('.rescheckbutton').hide();
					}

				});

		/* 
		 $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
		 $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
		 */

		$("#unitId").change(function() {
			var id = $(this).val();

			$('#resunitId1').val(id);
			$('#resunitId2').val(id);
			$('#resunitId3').val(id);
			$('#resunitId4').val(id);
			$('#resunitId5').val(id);
			$('#resunitId6').val(id);
			$('#resunitId7').val(id);

		});

		$("#circleId").change(function() {
			var id = $(this).val();
			$('#rescircleId1').val(id);
			$('#rescircleId2').val(id);
			$('#rescircleId3').val(id);
			$('#rescircleId4').val(id);
			$('#rescircleId5').val(id);
			$('#rescircleId6').val(id);
			$('#rescircleId7').val(id);

		});

		$("#divisionId").change(function() {
			var id = $(this).val();

			$('#resdivisionId1').val(id);

			$('#resdivisionId2').val(id);
			$('#resdivisionId3').val(id);
			$('#resdivisionId4').val(id);
			$('#resdivisionId5').val(id);
			$('#resdivisionId6').val(id);
			$('#resdivisionId7').val(id);

		});

		$("#subdivisionId").change(function() {
			var id = $(this).val();

			$('#ressubdivisionId1').val(id);

			$('#ressubdivisionId2').val(id);
			$('#ressubdivisionId3').val(id);
			$('#ressubdivisionId4').val(id);
			$('#ressubdivisionId5').val(id);
			$('#ressubdivisionId6').val(id);
			$('#ressubdivisionId7').val(id);

		});

		$("#projectId").change(function() {
			var id = $(this).val();

			$('#resprojectId1').val(id);

			$('#resprojectId2').val(id);
			$('#resprojectId3').val(id);
			$('#resprojectId4').val(id);
			$('#resprojectId5').val(id);
			$('#resprojectId6').val(id);
			$('#resprojectId7').val(id);

		});
		
		$("#year").change(function() {
			var id = $(this).val();

			$('#year1').val(id);

			$('#year2').val(id);
			$('#year3').val(id);
			$('#year4').val(id);
			$('#year5').val(id);
			$('#year6').val(id);
			$('#year7').val(id);

		});
		
		
		

		$("#reservoirId").change(function() {
			var id = $(this).val();

			$('#resresCodeId1').val(id);

			$('#resresCodeId2').val(id);
			$('#resresCodeId3').val(id);
			$('#resresCodeId4').val(id);
			$('#resresCodeId5').val(id);
			$('#resresCodeId6').val(id);
			$('#resresCodeId7').val(id);

		});

		$("#year").change(function() {
			var id = $(this).val();

			$('#year1').val(id);

			$('#year2').val(id);
			$('#year3').val(id);
			$('#year4').val(id);
			$('#year5').val(id);
			$('#year6').val(id);
			$('#year7').val(id);

		});

		$("#designationId").change(function() {
			var id = $(this).val();

			$('#resdesignationId1').val(id);

			$('#resdesignationId2').val(id);
			$('#resdesignationId3').val(id);
			$('#resdesignationId4').val(id);
			$('#resdesignationId5').val(id);
			$('#resdesignationId6').val(id);
			$('#resdesignationId7').val(id);

		});
		
		$("#dutyFrequencyId").change(function() {
			var id = $(this).val();

			$('#dutyFrequencyId1').val(id);

			$('#dutyFrequencyId2').val(id);
			$('#dutyFrequencyId3').val(id);
			$('#dutyFrequencyId4').val(id);
			$('#dutyFrequencyId5').val(id);
			$('#dutyFrequencyId6').val(id);
			$('#dutyFrequencyId7').val(id);

		});

		$('.rescheckbutton')
				.click(
						function(e) {

							var formname = this.form.name;
							//	var getformname=$(formname).prop('form');
							var buttonid = $(this).prop('id');

							alert("buttonid" + buttonid);

							alert("formname" + formname);

							alert("kal1");

							// alert("kal1");
							// var n= $('#addayacutinfo').text() ;

							// alert("text"+n);

							$('#action_alert').empty();

							e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===

							alert("kal1");

							// var fname="form[name="+""+formname+"]";

							//alert("fname"+fname);
							/* 	if(buttonid=='addmichecks1'){ */
								
									if ($('form[name=mainformname]').parsley().isValid()) {  
							if ($('form[name=' + formname + ']').parsley()
									.isValid()) {

								/*  
								   if($('.mycustomcheck').val()!=null){
								   	
								   	  if($('.mycustomcheck').val()==1){ */

								alert("kal2");

								$
										.ajax({
											url : "../invtsimis/addReschecksAnn2",
											method : "POST",
											async : false,
											data : $(
													'form[name=' + formname
															+ ']').serialize(),

											success : function(response) {

												//alert("kal"+response);

												if (response != 0) {

													// $('#ayacut-dailogue').dialog('close'); 

													$('#action_alert')
															.html(
																	'<p style="margin: 0px !important;">Data Updated Successfully</p>');
												}
												if (response == 0) {

													$('#action_alert')
															.html(
																	'<p style="margin: 0px !important;">Failed to Update data</p>');
												}

												//getResRegAyacutByResCode(response);

												//  alert(finYear);

												//  $('#action_alert').dialog('open'); 

												// getunitData(unitId,circleId,divisionId) ;

											},

											error : function() {
												alert(error);

											}

										});

								/* 	  }
								  } */
								/*  }  */

							}
							}else {
								
								$('form[name=mainformname]').parsley().validate();
								alert("kal4");
							}

						});

	});
</script>

	
	
	
	
			

	






<!-- </div> -->
<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>

<script type="text/javascript">
function getProjects(unitId,hkey) {

	var unitId = unitId ;
		
		//$('#unitId').val();

	//  alert("procId"+procId);
	
	if(hkey==1){
	$('#projectId').multiselect('rebuild');
}
	
	if(hkey==2){
	$('#dipackprojectId').multiselect('rebuild');
	}

	$.ajax({
		url : "../web/getProjects?unitId=" + unitId,
		type : "GET",
		success : function(response) {
			
			if(hkey==1){
			var $select = $('#projectId');
			
			var selectedprojectId=$('#hiddenprojectId').val();
			}
			if(hkey==2){
				var $select = $('#dipackprojectId');
				}
			$select.find('option').remove();

			var obj = JSON.parse(response);

			if(hkey==1){
			$('#projectId')
					.append('<option value="0"> --select--</option>');
			}
			
			if(hkey==2){
			$('#dipackprojectId')
			.append('<option value="0"> --select--</option>');
			}

			
			$.each(obj, function(key, value) {
				
				if(hkey==1){
					
					if(selectedprojectId==value.projectId){

				$('#projectId').append(
						'<option value="'+value.projectId+'"selected="selected"> '
								+ value.projectName + '</option>');
					}
					
					if(selectedprojectId==null || selectedprojectId!=value.projectId){

						$('#projectId').append(
								'<option value="'+value.projectId+'"> '
										+ value.projectName + '</option>');
							}

				$('#projectId').multiselect('rebuild')
				}
				if(hkey==2){
				$('#dipackprojectId').append(
						'<option value="'+value.projectId+'"> '
								+ value.projectName + '</option>');

				$('#dipackprojectId').multiselect('rebuild')
				}

				/* 	$(this).removeAttr('selected').prop('selected', false);
				  
				  if($('li').hasClass('active')){
				  	if($('input').prop('checked', true)){
				  		
				  		 $('input').prop('checked', false);
				  		
				  	var spantext=	$("span.multiselect-selected-text").text();
				  	$("span.multiselect-selected-text").text('None Selected')
				  		
				  		
				  	}
				  	$('li').removeClass('active');
				     
				  } */

			});
		},
		error : function() {
			alert(error);
		}
	});
}

function getPackages(projectId) {

	var projectId =projectId ;
		
		//$('#projectId').val();

	//  alert("procId"+procId);
	$('#packageId').multiselect('rebuild');

	$.ajax({
		url : "../web/getPackages?projectId=" + projectId,
		type : "GET",
		success : function(response) {
			var $select = $('#packageId');
			$select.find('option').remove();
			
			var selectedpackageId=$('#hiddenpackageId').val();

			var obj = JSON.parse(response);

			$('#packageId')
					.append('<option value="0"> --select--</option>');

			$.each(obj, function(key, value) {
				
				if(selectedpackageId==value.pkgId){

				$('#packageId').append(
						'<option value="'+value.pkgId+'" selected="selected"> ' + value.pkgName
								+ '</option>');
				}
				if(selectedpackageId==null || selectedpackageId!=value.pkgId){
					$('#packageId').append(
							'<option value="'+value.pkgId+'"> ' + value.pkgName
									+ '</option>');
					
				}

				$('#packageId').multiselect('rebuild')

				/* 	$(this).removeAttr('selected').prop('selected', false);
				  
				  if($('li').hasClass('active')){
				  	if($('input').prop('checked', true)){
				  		
				  		 $('input').prop('checked', false);
				  		
				  	var spantext=	$("span.multiselect-selected-text").text();
				  	$("span.multiselect-selected-text").text('None Selected')
				  		
				  		
				  	}
				  	$('li').removeClass('active');
				     
				  } */

			});
		},
		error : function() {
			alert(error);
		}
	});
}

function getCircles(unitId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var unitId = unitId ;
		//document.getElementById("unitId").value;
	//alert(mandalId);

	$
			.ajax({
				url : "../web/getCircles?unitId=" + unitId,
				type : "GET",
				success : function(response) {
                    if(hkey==1){
					var $select = $('#circleId');
					
					var selectedCircleId= $('#hiddencircleId').val();
					
					//alert("selectedCircleId"+selectedCircleId);
                    }
                    if(hkey==2){
                    	
                    	var $select = $('#dipackcircleId');
                    }
					$select.find('option').remove();

					var obj = JSON.parse(response);
					
					if(hkey==1){
					$('#circleId').append(
							'<option value="0"> --select--</option>');
					}
					if(hkey==2){
					$('#dipackcircleId').append(
					'<option value="0"> --select--</option>');
			}

					$.each(obj, function(key, value) {
						if(hkey==1){
							
	if(selectedCircleId==value.circleId){	
	  							
	  							/* $('#projectId').val(value.projectId);
	  							$('#projectName').val(value.projectName); */
	  						
	  					$('#circleId').append( '<option value="'+value.circleId+'" selected="selected"> '+value.circleName+'</option>' );
	  					
	  						}
	  						
	  					 if(selectedCircleId==null||selectedCircleId!=value.circleId){
	  							$('#circleId').append( '<option value="'+value.circleId+'"> '+value.circleName+'</option>' );	
	  						
	  						} 
							
						

						$('#circleId').multiselect('rebuild');
						
						}
						if(hkey==2){
							$('#dipackcircleId').append(
									'<option value="'+value.circleId+'" > '
											+ value.circleName + '</option>');

							$('#dipackcircleId').multiselect('rebuild');
							
							}
					});

				},
				error : function() {
					alert(error);
				}
			});
}

function getDivisions(circleId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId =circleId ;
		//document.getElementById("circleId").value;
	//alert(mandalId);

	$.ajax({
		url : "../web/getDivisions?circleId=" + circleId,
		type : "GET",
		success : function(response) {
			if(hkey==1){
			var $select = $('#divisionId');
			
			var selecteddivisionId= $('#hiddendivisionId').val();
			}
			if(hkey==2){
				var $select = $('#dipackdivisionId');
				}

			$select.find('option').remove();

			var obj = JSON.parse(response);
			
			if(hkey==1){
			$('#divisionId').append(
					'<option value="0"> --select--</option>');
			}
			if(hkey==2){
			$('#dipackdivisionId').append(
			'<option value="0"> --select--</option>');
			}

			$.each(obj, function(key, value) {
				if(hkey==1){
					if(selecteddivisionId==value.divisionId){
				$('#divisionId').append(
						'<option value="'+value.divisionId+'" selected="selected"> '
								+ value.divisionName + '</option>');
					}
					
					 if(selecteddivisionId==null||selecteddivisionId!=value.divisionId){
						 
							$('#divisionId').append(
									'<option value="'+value.divisionId+'"> '
											+ value.divisionName + '</option>');
						 
					 }

				$('#divisionId').multiselect('rebuild');
				}
				if(hkey==2){
					$('#dipackdivisionId').append(
							'<option value="'+value.divisionId+'" > '
									+ value.divisionName + '</option>');

					$('#dipackdivisionId').multiselect('rebuild');
					}
			});

		},
		error : function() {
			alert(error);
		}
	});
}



function getSubDivisions(divisionId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var divisionId = divisionId ;
		
		//document.getElementById("divisionId").value;
	//alert(mandalId);

	$.ajax({
		url : "../web/getSubDivisions?divisionId=" + divisionId,
		type : "GET",
		success : function(response) {
			if(hkey==1){
			var $select = $('#subdivisionId');
			
			var selectedsubdivisionId= $('#hiddensubdivisionId').val();
			//alert("selectedsubdivisionId"+selectedsubdivisionId);
			}
			/* if(hkey==2){
				var $select = $('#subdivisionId');	
				
			} */
			$select.find('option').remove();

			var obj = JSON.parse(response);
			
		
			$('#subdivisionId').append(
					'<option value="0"> --select--</option>');
			

			$.each(obj, function(key, value) {

				if(selectedsubdivisionId==value.subdivisionId){
				$('#subdivisionId').append(
						'<option value="'+value.subdivisionId+'" selected="selected" > '
								+ value.subdivisionName + '</option>');
				}
				if(selectedsubdivisionId==null || selectedsubdivisionId!=value.subdivisionId){
					$('#subdivisionId').append(
							'<option value="'+value.subdivisionId+'" > '
									+ value.subdivisionName + '</option>');
					}

				$('#subdivisionId').multiselect('rebuild');
			});

		},
		error : function() {
			alert(error);
		}
	});
}



function getReservoirs(projectId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	//var projectId = projectId ;
		
		//document.getElementById("divisionId").value;
	//alert(mandalId);

	$.ajax({
		url : "../invtsimis/getResList?projectId=" + projectId,
		type : "GET",
		success : function(response) {
			if(hkey==1){
			var $select = $('#reservoirId');
			
			$select.find('option').remove();
			
		
			//alert("selectedsubdivisionId"+selectedsubdivisionId);
			}
			
		/* 	var selectedreservoirId=null ; */// $('#hiddenrservoirId').val();
			/* if(hkey==2){
				var $select = $('#subdivisionId');	
				
			} */
			//alert(response);

			var obj = JSON.parse(response);
			
		
			$('#reservoirId').append(
					'<option value="0"> --select--</option>');
			

			$.each(obj, function(key, value) {
				
				$('#reservoirId').append(
						'<option value="'+value.resCode+'" > '
								+ value.resName + '</option>');

				/* if(selectedreservoirId==value.reservoirId){
				$('#reservoirId').append(
						'<option value="'+value.resCode+'" selected="selected" > '
								+ value.resName + '</option>');
				}
				if(selectedreservoirId==null || selectedreservoirId!=value.reservoirId){
				
					} */

				$('#reservoirId').multiselect('rebuild');
			});

		},
		error : function() {
			alert(error);
		}
	});
}
</script>

<script type="text/javascript" >

function getann2inspectdata(year){
	
	var freq= $('#dutyFrequencyId').val();
	
	var resCode=$('#reservoirId').val();
	
	//alert(year+tankId+freq);
	
	$.ajax({	          
	      url: "../invtsimis/getann2inspectdata?year="+year+"&resCode="+resCode+"&freq_oper="+freq,
	      type: "GET",
	      contentType: "application/json; charset=utf-8",
	      success: function (msg) {
	    	  
	    	  console.log(msg);
	    	  
	    	  var obj = JSON.parse(msg);
	    	  
	    	  for(i in obj){
	    		  
	    		  var dbmapvalue=obj[i].resCheckId;
	    		  var dbcatId=obj[i].resCatId;
	    		  
	    		  alert("dbmapvalue"+dbmapvalue);
	    		  
	    		  if(dbcatId>=9 && dbcatId<=17){
	    		if(dbmapvalue>=100 && dbmapvalue<=157) {
	    		  for(var j=1 ; j<=58 ;j++){
	    			  var mapid="#aresCheckId"+j ;
	    			  
	    		  var mapvalue=$(mapid).val();
	    		 alert("mapvalue"+mapvalue);
	    		 
	    		
		    		  
	    		
	    			  
	    		if( dbmapvalue==mapvalue ){
	    			
	    			var getid=$(mapid).attr('id');
		    		
		    		//alert("getid"+getid);
		    		
		    		//alert("getinsidej"+j);
		    		var checkid="#aresCheckId"+j;
		    		var catid="#aresCatId"+j;
		    		var checkboxid="#aresCheckboxId"+j
		    		var remarks="#aremarks"+j;

		    		$(checkboxid).prop('checked', true);
		    		$(checkboxid).attr('disabled',true); 
		    		
		    		
		    		$(remarks).val(obj[i].remarks);
		    		$(remarks).attr('readonly',true); 
		    	
		    	
		    		
		    		
	    		}
	    			
	    			
	    		  }
	    		  
	    	  }
	    	  }
	    	  if(dbcatId>=18 && dbcatId<=33){
	    		if(dbmapvalue>157 && dbmapvalue<=315 )  {
		    		  for(var j=1 ; j<=158 ;j++){
		    			  var mapid="#bresCheckId"+j ;
		    			  
		    		  var mapvalue=$(mapid).val();
		    		 // alert("mapvalue"+mapvalue);
		    		 
		    		
			    		  
		    		
		    			  
		    		  if( dbmapvalue==mapvalue ){
			    			
			    			var getid=$(mapid).attr('id');
				    		
				    		//alert("getid"+getid);
				    		
				    		//alert("getinsidej"+j);
				    		var checkid="#bresCheckId"+j;
				    		var catid="#bresCatId"+j;
				    		var checkboxid="#bresCheckboxId"+j
				    		var remarks="#bremarks"+j;

				    		$(checkboxid).prop('checked', true);
				    		$(checkboxid).attr('disabled',true); 
				    		
				    		
				    		$(remarks).val(obj[i].remarks);
				    		$(remarks).attr('readonly',true); 
				    	
				    	
				    		
				    		
			    		}
		    		  
		    	  }
	    		}
	    		}
	    	  if(dbcatId==7){
	    		if(dbmapvalue>=317 && dbmapvalue<=329 ) {
		    		  for(var j=1 ; j<=14 ;j++){
		    			  var mapid="#cresCheckId"+j ;
		    			  
		    		  var mapvalue=$(mapid).val();
		    		  alert("mapvalue"+mapvalue);
		    		 
		    		
			    		  
		    		
		    			  
		    		  if( dbmapvalue==mapvalue ){
			    			
			    			var getid=$(mapid).attr('id');
				    		
				    		//alert("getid"+getid);
				    		
				    		//alert("getinsidej"+j);
				    		var checkid="#cresCheckId"+j;
				    		var catid="#cresCatId"+j;
				    		var checkboxid="#cresCheckboxId"+j
				    		var remarks="#cremarks"+j;

				    		$(checkboxid).prop('checked', true);
				    		$(checkboxid).attr('disabled',true); 
				    		
				    		
				    		$(remarks).val(obj[i].remarks);
				    		$(remarks).attr('readonly',true); 
				    	
				    	
				    		
				    		
			    		}
		    		  
		    			
		    		  }
		    		  
		    	  }
	    	  }
	    	  if(dbcatId==8){
	    		if(dbmapvalue==330 ) {
		    		
		    			  var mapid="#dresCheckId"+1 ;
		    			  
		    		  var mapvalue=$(mapid).val();
		    		 // alert("mapvalue"+mapvalue);
		    		 
		    		
			    		  
		    		
		    			  
		    		  if( dbmapvalue==mapvalue ){
			    			
			    			var getid=$(mapid).attr('id');
				    		
				    		//alert("getid"+getid);
				    		
				    		//alert("getinsidej"+j);
				    		var checkid="#dresCheckId"+1;
				    		var catid="#dresCatId"+1;
				    		var checkboxid="#dresCheckboxId"+1
				    		var remarks="#dremarks"+1;

				    		$(checkboxid).prop('checked', true);
				    		$(checkboxid).attr('disabled',true); 
				    		
				    		
				    		$(remarks).val(obj[i].remarks);
				    		$(remarks).attr('readonly',true); 
				    	
				    	
				    		
				    		
			    		}
		    	
		    		  
		    	  }
	    	  }
	    	  
	    	  }

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
}

function getResHealthData(resCode){
	
	
	
	//alert(year+tankId+freq);
	$("#thead5").empty();
	$("#tbody5").empty();
	
	
	$.ajax({	          
	      url: "../invtsimis/getreshealthdata?resCode="+resCode,
	      type: "GET",
	      contentType: "application/json; charset=utf-8",
	      success: function (msg) {
	    	  
	    	// console.log(msg);
	    	  
	    	  var obj = JSON.parse(msg);
	    	  
	    	  var j=1;
	    	  
	    	
	    	    $('#reshealth table thead').append(  '<tr style="font-size: 18px">'+
	    	    		'<th style="color: blue">Unit</th><th style="color: red">'+obj[0].unitName+'</th>'+
	    	    		'<th style="color: blue">Circle</th><th style="color: red">'+obj[0].circleName+' </th>'+
	    	    		'<th style="color: blue">Division</th><th style="color: red">'+obj[0].divisionName+'</th>'+
	    	    		'<th style="color: blue">Sub division</th><th style="color: red">'+obj[0].subdivisionName+'</th></tr>'+
	    	    		'<tr><th style="color: blue" colspan="2">Reservoir</th><th style="color: red" colspan="2">'+obj[0].resName+'</th>'+
	    	    		'<th style="color: blue" colspan="2">Project</th><th style="color: red" colspan="2">'+obj[0].projectName+'</th></tr>'+
	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    		'<th>Category </th>'+
	    	    		' <th>Inspect Date (dd / mm/ yyyy) </th>'+
	    	    		' <th colspan="3">Deficiencies Noted </th><th>Edit </th><th>Delete </th></tr>'); 	  
	    	    
	    	    for(i in obj){
	    	    	
	    	    	   $('#reshealth table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                                '<td><b>'+obj[i].resCatId+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].inspectDate+'</b></td>' +
	    	    			                                '<td colspan="3"><b>'+obj[i].remarks+'</b></td>' +
	    	    			                                '<td><button type="button" name="editreshealth" id="editreshealth" class="btn btn-1 btn-primary center-block "  >Edit</button></td>'+
	    	    			                                '<td><button type="button" name="deletereshealth" id="deletereshealth" class="btn btn-1 btn-primary center-block "  >Delete</button></td></tr>');
	    	    	   
	    	    	   
	    	    	  
	    	    	   
	    	    	   j++;
	    	    }
	    	    
	    	  
	    	
	    	    
	    	    
	    	
	    	

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
}


function getResRecommendData(resCode){
	
	
	
	//alert(year+tankId+freq);
	$("#thead6").empty();
	$("#tbody6").empty();
	
	
	$.ajax({	          
	      url: "../invtsimis/getresrecommenddata?resCode="+resCode,
	      type: "GET",
	      contentType: "application/json; charset=utf-8",
	      success: function (msg) {
	    	  
	    	// console.log(msg);
	    	  
	    	  var obj = JSON.parse(msg);
	    	  
	    	 // $('#reslatesthealth').val(obj[0].resCategory)
	    	  
	    	  var j=1;
	    	  
	    	
	    	    $('#resrecommend table thead').append(  '<tr style="font-size: 14px">'+
	    	    		'<th style="color: blue">Unit</th><th style="color: black">'+obj[0].unitName+'</th>'+
	    	    		'<th style="color: blue">Circle</th><th style="color: black">'+obj[0].circleName+' </th>'+
	    	    		'<th style="color: blue">Division</th><th style="color: black">'+obj[0].divisionName+'</th>'+
	    	    		'<th style="color: blue">Sub division</th><th style="color: black">'+obj[0].subdivisionName+'</th></tr>'+
	    	    		'<tr><th style="color: blue" colspan="2">Reservoir</th><th style="color: black" colspan="2">'+obj[0].resName+'</th>'+
	    	    		'<th style="color: blue" colspan="2">Project</th><th style="color: black" colspan="2">'+obj[0].projectName+'</th></tr>'+
	    	    		'<tr style="font-size: 14px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    		'<th>Category </th>'+
	    	    		' <th>Inspect Date (dd / mm/ yyyy) </th>'+
	    	    		' <th colspan="1" >Latest Health Status </th>'+
	    	    		'<th colspan="2">Latest Recommendations</th><th>Edit </th><th>Delete </th></tr>'); 	  
	    	    
	    	    for(i in obj){
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	   $('#resrecommend table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                                '<td><b>'+obj[i].resCategory+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].inspectDate+'</b></td>' +
	    	    			                                '<td colspan="1"><b>'+obj[i].remarks+'</b></td>' +
	    	    			                                '<td colspan="2"><b>'+obj[i].recomendbysdso+'</b></td>' +
	    	    			                                '<td><button type="button" name="editresrec" id="editresrec" class="btn btn-1 btn-primary center-block "  >Edit</button></td>'+
	    	    			                                '<td><button type="button" name="deleteresrec" id="deleteresrec" class="btn btn-1 btn-primary center-block "  >Delete</button></td></tr>');
	    	    	   
	    	    	   
	    	    	  
	    	    	   
	    	    	   j++;
	    	    }
	    	    
	    	  
	    	
	    	    
	    	    
	    	
	    	

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
}

function getResActionTakenData(resCode){
	
	
	
	//alert(year+tankId+freq);
	$("#thead7").empty();
	$("#tbody7").empty();
	
	
	$.ajax({	          
	      url: "../invtsimis/getresactiontakendata?resCode="+resCode,
	      type: "GET",
	      contentType: "application/json; charset=utf-8",
	      success: function (msg) {
	    	  
	    	// console.log(msg);
	    	  
	    	  var obj = JSON.parse(msg);
	    	  
	    	 // $('#reslatesthealth').val(obj[0].resCategory)
	    	  
	    	  var j=1;
	    	  
	    	
	    	    $('#acttaken table thead').append(  '<tr style="font-size: 14px">'+
	    	    		'<th style="color: blue">Unit</th><th style="color: black">'+obj[0].unitName+'</th>'+
	    	    		'<th style="color: blue">Circle</th><th style="color: black">'+obj[0].circleName+' </th>'+
	    	    		'<th style="color: blue">Division</th><th style="color: black">'+obj[0].divisionName+'</th>'+
	    	    		'<th style="color: blue">Sub division</th><th style="color: black">'+obj[0].subdivisionName+'</th></tr>'+
	    	    		'<tr><th style="color: blue" colspan="2">Reservoir</th><th style="color: black" colspan="2">'+obj[0].resName+'</th>'+
	    	    		'<th style="color: blue" colspan="2">Project</th><th style="color: black" colspan="2">'+obj[0].projectName+'</th></tr>'+
	    	    		'<tr style="font-size: 14px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    		'<th>Action Initiated</th>'+
	    	    		'<th>Action Completed</th>'+
	    	    		' <th>Inspect Date (dd / mm/ yyyy) </th>'+
	    	    		
	    	    		'<th colspan="2">Reasons for pending</th><th>Edit </th><th>Delete </th></tr>'); 	  
	    	    
	    	    for(i in obj){
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	   $('#acttaken table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                                '<td><b>'+obj[i].actionTakeninit+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].actionTakencomplete+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].inspectDate+'</b></td>' +
	    	    			                                '<td colspan="2"><b>'+obj[i].reasonForPending+'</b></td>' +
	    	    			                                
	    	    			                                '<td><button type="button" name="editresrec" id="editresrec" class="btn btn-1 btn-primary center-block "  >Edit</button></td>'+
	    	    			                                '<td><button type="button" name="deleteresrec" id="deleteresrec" class="btn btn-1 btn-primary center-block "  >Delete</button></td></tr>');
	    	    	   
	    	    	   
	    	    	  
	    	    	   
	    	    	   j++;
	    	    }
	    	    
	    	  
	    	
	    	    
	    	    
	    	
	    	

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
}
</script>
