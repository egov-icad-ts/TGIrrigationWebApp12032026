
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
<script type="text/javascript" src="../js/component/projSeasonAyacut.js"></script>

<script type="text/javascript">






		   
</script>



<script type="text/javascript">

$(document).ready(function(){
	
	 
     
      
     
	
	$('#financialYear').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	  var cyear = (new Date).getFullYear();

		$(".datepick").datepicker({
			changeYear : false,
			changeMonth : true,
			 minDate: new Date(cyear, 0, 1),
		        maxDate: new Date(cyear, 11, 31),
		     
			
			 dateFormat: "dd/mm/yy"+" "+ getCurrentTime(),
			   
			
		/* 
		 dateFormat : "dd/mm/yy", onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});

		
		
		function getCurrentTime() {
		    var CurrentTime = "";
		    try {
		        var CurrentDate = new Date();
		        var CurrentHours = CurrentDate.getHours();
		        var CurrentMinutes = CurrentDate.getMinutes();
		        var  CurrentSeconds= CurrentDate.getSeconds();
		        var CurrentAmPm = "A'M'";
		        if (CurrentMinutes < 10) { CurrentMinutes = "0" + CurrentMinutes; }

		       /* if (CurrentHours == 12) {
		            CurrentHours = 12;
		            CurrentAmPm = " P'M'";
		        }
		        else if (CurrentHours == 0) {
		            CurrentHours = 12;
		            CurrentAmPm = " A'M'";
		        }
		        else if (CurrentHours > 12) {
		            CurrentHours = CurrentHours - 12;
		            CurrentAmPm = " P'M'";
		        }
		        else {
		            CurrentAmPm = " A'M'";
		        }*/
		        CurrentTime = "" + CurrentHours + ":" + CurrentMinutes +":" + CurrentSeconds +  "";
		    }
		    catch (ex) {
		    }
		    return CurrentTime;
		}

	



	
	
	 
	 
	 
	

	}); 

</script>




<script>
	

	

	$(function() {
		
		
		
		 $('.irayacut1').hide();
		 $('.irayacut2').hide();
		
		 $('#ayacutinfo_dialogue').dialog({
			 autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#addseainfo_dialogue').dialog({
			 autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
			 $('#viewseadata_dialogue').dialog({
				 autoOpen:false,
				  width:1200,
				  close: function() {
					  
					
						  $(this).dialog("close");
						  }
				 });
			 
			 $('#viewEditseadata_dialogue').dialog({
				 autoOpen:false,
				  width:1200,
				  close: function() {
					  
					
						  $(this).dialog("close");
						  }
				 });
			 
			 $('#viewDeleteseadata_dialogue').dialog({
				 autoOpen:false,
				  width:1200,
				  close: function() {
					  
					
						  $(this).dialog("close");
						  }
				 });

		
		
		 
	

	});	
	
	
	function ViewMandalInfo(ProjectAyacutId){
		
		var  pid=ProjectAyacutId;
		
		var divpid="#"+pid+"info";
		
		
		  $('.ainfo').hide();
		
		 $('#ayacutinfo_dialogue').dialog('option', 'title', 'Ayacut Info');
		  $('#ayacutinfo_dialogue').dialog('open');
		  
		  
		  
		  $(divpid).show();
		
		
	}
	
	function AddSeaAyacutInfo(ProjectAyacutId,projectId,seasonId,projectSeasonId){
		

		
		 $('#addseainfo_dialogue').dialog('option', 'title', 'Add Ayacut Kharif/Rabi Info');
		  $('#addseainfo_dialogue').dialog('open');
		 
		 
			 $("#projSeaAyacutform").trigger("reset");
		  
		  $('#hiddenprojectayacutId').val(ProjectAyacutId);
		  $('#hiddenprojectId').val(projectId);
		  $('#hiddenseasonId').val(seasonId);
		  $('#hiddenprojectSeasonId').val(projectSeasonId);
		  
			$('#editFlag').val(false);
			
			 $('#hiddencropId').removeAttr('name');
		  
			 if($('#cropId').prop('disabled') == true){
				    //Selected option is disabled
				 $('#cropId').removeAttr('disabled');
				}
		  
		
	}
	function getcorrectlabel(seaid){
		
		var sid=seaid;
		
		if(sid==1){
			 $('.irayacut2').show();
			 $('.irayacut1').hide();
			
		}else {
			 $('.irayacut2').hide();
			
		}
		
		if (sid==2){
			
			 $('.irayacut1').show();
			 $('.irayacut2').hide();
		}else{
			 $('.irayacut1').hide();
		}
		
		
	}
	

</script>



<div class="col-md-9">

<div>
						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Add Seasonal Ayacut Info <c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						
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
						
						
					<div class="row show-grid ">
<div class="alert alert-info" role="alert" id="action_alert">
				
				

			</div>
			</div>
									
						
						
				
				<c:if test="${msg!=null || err!=null }">


							<div >
								<c:if test="${msg!=null}">
									<div class="alert alert-success" role="alert">
										<strong></strong>
										<c:out value="${msg	}"></c:out>
									</div>

								</c:if>
								
								
								

								<c:if test="${err!=null}">
									<div class="alert alert-danger" role="alert">
										<strong></strong>
										<c:out value="${err}"></c:out>

									</div>

								</c:if>

							</div>
						</c:if> 
						
							
							
				
							
							<form:form id="parasinput" method="post" modelAttribute="addSeasonalprojayacut"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
     <div class="col-md-12 invDiv">
					<div class="col-md-12 invDiv" style="text-align: center; font-weight: bold;">
					
					<div class="col-md-4">Mandal Name (Village Name)  &emsp;&emsp;&emsp;<span style="color: red"> Click on Mandal Name to see details </span></div>
					<div class="col-md-8">Action</div>
					
					
					
					</div>
			
					
					<br></br>
					
					
					<c:if test="${ayacutList!=null }">
					
					
					
					 <c:set var="c" value="1" scope="page" /> 
					<c:forEach items="${ayacutList}" var="d" varStatus="count">
					
					<c:if test="${d.unitId==userObj.unitId }">
					
				
						 <c:if test="${userObj.unitId==d.unitId }">
						
							
						 
					<div class="col-md-12 invDiv">
					
											 
											
					<div class="col-md-4" style="text-align: center; font-weight: bold; ">
					<button type="button" name="showmandalname" id="khfman" 
																	class="btn btn-1 btn-info center-block "  onclick="ViewMandalInfo(${d.projAyacutId})"  ><c:out value="${c}"></c:out> &emsp; &emsp;<c:out value="${d.mandalName}"></c:out> (<c:out value="${d.villageName}"></c:out>) </button>
					</div>
					
					<c:if test="${compCapList!=null}">
				
					<div class="col-md-8"> 
					
					<c:forEach items="${compCapList}" var="t" varStatus="count">
					
					<div class="col-md-12">
					<c:if test="${d.projectId==t.projectId && t.seasonId==1}">
					
				
					<div class="col-md-6">
					
					<button type="button" name="showtanksname" id="khfadd" 
																	class="btn btn-1 btn-success center-block addtankfeedinfcls "   onclick="AddSeaAyacutInfo(${d.projAyacutId},${t.projectId},${t.seasonId },${t.projectseasonId})" >Add <c:out value="${t.seasonName}"></c:out>  <c:out value="${t.actplanYear }"></c:out></button>
					
					    <br>
				         </div>
				     
					 	<div class="col-md-2">	
					 														
					<button type="button" name="showtanksname" id="khfview" 
														class="btn btn-1 btn-success center-block "   onclick="ViewSeaAyacutInfo(${d.projAyacutId},${t.projectseasonId},${t.seasonId },'${t.actplanYear }')"  >View  </button>
							
								&emsp;&emsp;												
				   		</div>	
					<div class="col-md-2">	
				
					<button type="button" name="showtanksname" id="khfedit" 
						
																	class="btn btn-1 btn-success center-block "  onclick="ViewEditSeaAyacutInfo(${d.projAyacutId},${t.projectseasonId},${t.seasonId },'${t.actplanYear }')"   >Edit </button>
						&emsp;&emsp;	</div>
					<div class="col-md-2">	
						
					<button type="button" name="showtanksname" id="khfdel" 
																	class="btn btn-1 btn-danger center-block "  onclick="ViewDeleteSeaAyacutInfo(${d.projAyacutId},${t.projectseasonId},${t.seasonId },'${t.actplanYear }')">Delete </button>
																	
                     &emsp;&emsp;	 </div>
					
					
					</c:if>
					</div>
					</c:forEach>
					<c:forEach items="${compCapList}" var="t" varStatus="count">
					
					<div class="col-md-12">
					<c:if test="${d.projectId==t.projectId && t.seasonId==2}">
				
					<div class="col-md-6">
					
						<button type="button" name="showtanksname" id="rabiadd" 
																	class="btn btn-1 btn-primary center-block addtankfeedinfcls "   onclick="AddSeaAyacutInfo(${d.projAyacutId},${t.projectId},${t.seasonId },${t.projectseasonId })" >Add <c:out value="${t.seasonName}"></c:out>  <c:out value="${t.actplanYear }"></c:out></button>
					
					 <br>	
					 </div>	
					 <div class="col-md-2">														
					<button type="button" name="showtanksname" id="rabiview" 
																	class="btn btn-1 btn-primary center-block " onclick="ViewSeaAyacutInfo(${d.projAyacutId},${t.projectseasonId},${t.seasonId },'${t.actplanYear }')"  >View </button>
																	
																
					&emsp; &emsp;</div> 
					<div class="col-md-2">
					<button type="button" name="showtanksname" id="rabiedit" 
																	class="btn btn-1 btn-primary center-block "  onclick="ViewEditSeaAyacutInfo(${d.projAyacutId},${t.projectseasonId},${t.seasonId },'${t.actplanYear }')"  >Edit </button>
					&emsp; &emsp;</div>
					<div class="col-md-2">
					<button type="button" name="showtanksname" id="rebidel" 
																	class="btn btn-1 btn-danger center-block " onclick="ViewDeleteSeaAyacutInfo(${d.projAyacutId},${t.projectseasonId},${t.seasonId },'${t.actplanYear }')"  >Delete </button>
																	
				
					&emsp; &emsp; </div>
					
					</c:if>
					</div>
					</c:forEach>
					</div>
					</c:if>
					</div>
					
				 	<c:set var="c" value="${c + 1}" scope="page"/> 
						
				 	</c:if> 
					
						</c:if>
					</c:forEach>
					
				
					
					</c:if>
					
					
					
					
					
					
					
					</div>
									

	</form:form>
	

&emsp;&emsp;


    
    	</div>
							
					</div>
					
					</div>
					</div>
					
    

  
  <div id="ayacutinfo_dialogue" >
  
  <form:form id="ayacutinfo" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		<c:if test="${ayacutList!=null }">
					<c:forEach items="${ayacutList}" var="d" varStatus="count">	
					
	<div class="col-md-12 invDiv ainfo" id="${d.projAyacutId}info">	
	
	<div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Project Name</label>
											 </div>				      
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.projectName}</label>
											 </div>
	<div class="col-md-6" style="color: blue"> 
											 <label class="label-control rowlebel ">District Name</label>
											 </div>	
	    <div class="col-md-6">
											 <label class="label-control rowlebel ">${d.districtName}</label>
											 </div>
											 
		<div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Mandal Name</label>
											 </div>	
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.mandalName}</label>
											 </div>
	    <div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Village Name</label>
											 </div>	
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.villageName}</label>
											 </div>
		    <div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">New Ayacut proposed</label>
											 </div>	
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.contemplatedAyacut}</label>
											 </div>

		    <div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Ayacut Created</label>
											 </div>	
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.ayacutCreated}</label>
											 </div>
		 <div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Irrigated Ayacut</label>
											 </div>	
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.irriagtedAyacut}</label>
											 </div>
		 <div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Stabilized Ayacut</label>
											 </div>	
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.stableAyacut}</label>
											 </div>
	</div>										 
											 
											 
										  
			</c:forEach>
			</c:if>						
										
										
										
											 
										
</form:form>
  </div>
  
  
  
  
  
   <div id="addseainfo_dialogue" >
  
  <form:form id="projSeaAyacutform" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
				 <input type="hidden" class="form-control"  id="unitId" name="unitId" value="${userObj.unitId}" />
                         <input type="hidden" class="form-control"  id="circleId" name="circleId" value="${userObj.circleId}" />
                            <input type="hidden" class="form-control"  id="divisionId" name="divisionId" value="${userObj.divisionId}" />
                             <input type="hidden" class="form-control"  id="subdivisionId" name="subdivisionId" value="${userObj.subdivisionId}" />
                              <input type="hidden" class="form-control"  id="hiddenprojectId" name="projectId" value="0" />
                              
                              <input type="hidden" class="form-control"  id="hiddenprojectSeasonId" name="projectseasonId" value="0" />
                              <input type="hidden" class="form-control"  id="hiddenprojectayacutId" name="projAyacutId" value="0" />
                                <input type="hidden" class="form-control"  id="hiddenseasonId" name="seasonId" value="0" />
                                <input type="hidden" class="form-control"  id="hiddencropId"  value="0" />
                                   <input type="hidden" class="form-control"  id="hiddenprojSeasonAyacutId" name="projSeasonAyacutId" value="0" />
                                
                                 <input type="hidden" class="form-control"  id="editFlag"  value="false" />
                                
                                
		
	
	<div class="col-md-12 invDiv seainfo" >	
	

	
			      
<div class="col-md-6"> <label class="label-control rowlebel " style="color: blue">Select crop</label>
									 <select class="form-control" id="cropId" name="cropId" required> 
										<option value=" ">--select--</option>  
										<option value="1">ID</option>
										<option value="2">Wet</option>
										
										
										</select>
											  </div>

	
		<div class="col-md-6">
		<label class="label-control rowlebel " style="color: blue">Irrigated ayacut (acres)</label>
											  <input type="text" class=" form-control"  id="irriagtedAyacut" name="irriagtedAyacut" placeholder="" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 decimals ex:0.12" value="0.00"  /> 
											  </div>
											  <div class="col-md-6">
		<label class="label-control rowlebel " style="color: blue">Proposed ayacut (acres)</label>
											  <input type="text" class=" form-control"  id="proposedAyacut" name="proposedAyacut" placeholder=""  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 decimals ex:0.12" value="0.00" /> 
											  </div>
											    <div class="col-md-6">
		<label class="label-control rowlebel " style="color: blue">Crop Names</label>
											  <input type="text" class=" form-control"  id="cropNames" name="cropNames" placeholder="paddy,jowar"  /> 
											  </div>
											  
											  <div class="col-md-6">
		<label class="label-control rowlebel " style="color: blue">Observation Date</label>
											  <input type="text" class=" datepick form-control datepicker"  id="ObsDate" name="ObsDate" placeholder="" readonly="readonly"  required /> 
											  </div>
											  
											  	   <div class="col-md-12">
	 <label class="label-control rowlebel " style="color: blue">Remarks </label>
											  <textarea  class=" form-control"  id="remarks" name="remarks" placeholder="" cols="80" rows="2" > </textarea>
											  </div>
											  
											   <br>	&emsp;&emsp; 
											
											  
											  <div class="col-md-12" style="text-align: center;">
											  
					
					<button type="button" name="showtanksname" id="addtankfeedinf" 
																	class="btn btn-1 btn-primary center-block addtankfeedinfcls "   onclick="AddSeasonAyacutRequired()" >Submit</button>
					
					 <br>	
											  
	




		   
	</div>		
	</div>								 
											 
											 
										  
						
										
										
											 
										
</form:form>
  </div>
  
  
  
  
  
   <div id="viewseadata_dialogue" >
  
  <form:form id="v_SeaAyacut" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
	
		<div id="v_sea_form_ayacut">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="doc-frm-table-1">
											<thead id="doc-thead1">

											</thead>


											<tbody id="doc-tbody1">

											</tbody>
										</table>
									</div>


								</div>
							</div>
		
	
									
											 
										
</form:form>
  </div>
  
  
   <div id="viewEditseadata_dialogue" >
  
  <form:form id="v_editSeaAyacut" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
	
		<div id="v_edit_sea_form_ayacut">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="doc-edit-table-1">
											<thead id="doc-edit-thead1">

											</thead>


											<tbody id="doc-edit-tbody1">

											</tbody>
										</table>
									</div>


								</div>
							</div>
		
	
									
											 
										
</form:form>
  </div>
  
  
  <div id="viewDeleteseadata_dialogue" >
  
  <form:form id="v_deleteSeaAyacut" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
	
		<div id="v_delete_sea_form_ayacut">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="doc-delete-table-1">
											<thead id="doc-delete-thead1">

											</thead>


											<tbody id="doc-delete-tbody1">

											</tbody>
										</table>
									</div>


								</div>
							</div>
		
	
									
											 
										
</form:form>
  </div>

						
							

							
  
  							
							

						



<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



