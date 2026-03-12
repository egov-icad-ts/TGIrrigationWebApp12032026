
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
<script type="text/javascript" src="../js/component/projSeasonCap.js"></script>

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
			  width:600,
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
		 
		 $('#viewseainfo_dialogue').dialog({
			 autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#viewEditseainfo_dialogue').dialog({
			 autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#viewDeleteseainfo_dialogue').dialog({
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
	
	function AddSeaAyacutInfo(projectId,projectname){
		//alert("projectId"+projectId)
		
		 $("#projSeaAyacutCap").trigger("reset");
		
		 $('#addseainfo_dialogue').dialog('option', 'title', 'Add Capacity Kharif/Rabi for '+projectname);
		  $('#addseainfo_dialogue').dialog('open');
		  
		//  alert("projectId"+projectId);
		  
		  $('#hiddenprojectId').val(projectId);
		  
		  $(".vana").hide();
			 $(".yasa").hide();
			 
			 
			 if($('#seasonId ').prop('disabled') == true){
				    //Selected option is disabled
				 $('#seasonId').removeAttr('disabled');
				}
			
			 var editinfo=$('#editFlag').val(false);
				
			
		  
		
	}
	/* function getcorrectlabel(seaid){
		
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
	
 */   function getactionyear(seaid){
	 
		var sid=seaid;		
		var actyear=0;
		
		var actualdate=new Date();
		
		var month=actualdate.getMonth();
	
		
		 var d = new Date();
		  var e=new Date();
		  var f=new Date();
		  var c=new Date();
		  var i=1; 
		  
		  var vanadate;
		  var yasangidate;
		// month=10;
		//	alert("month"+month);
		  if(month>9 && month<=12){
			  
			 // alert("in 4 to 12");
		  f=parseInt(f.getFullYear() + i) ;
		  var k=f.toString()
		  k=k.substring(2,4);		
		  vanadate= parseInt(e.getFullYear()) +"-"+ k;
		  }
		  
		 
		  if((month>=0 && month<=9)){
			  
			 // alert("in 0 to 4");
			  f=parseInt( f.getFullYear() ) ;
			  var k=f.toString()
			  k=k.substring(2,4);		
			  vanadate= parseInt( e.getFullYear()-i) +"-"+ k;
			  }
		  
		 
		  if(month>=0 && month<=12){
		  d=parseInt( d.getFullYear());
		  c=parseInt(c.getFullYear()+i) ;
		  var m=c.toString()
		  m=m.substring(2,4);		
		  yasangidate= parseInt(e.getFullYear()) +"-"+ m;
		  
		  }
		
		
		if(month>=5 && month<=9 && sid==1){
			
		//	alert("sid1 month>6 and 9");
			
			var actyear=yasangidate;
			
			 $("#actplanYear").val(actyear);
			 
			 $(".vana").show();
			 $(".yasa").hide();
			
		}
		
		if (month>=5 && month<=9 && sid==2){
			
		//	alert("sid2 month>6 and 9");
			var actyear=vanadate;
			$("#actplanYear").val(actyear);
			
			 $(".vana").hide();
			 $(".yasa").show();
		}
		
     if((month>9 && month<=12  && sid==2) || ((month>=0 && month<=4  && sid==2))){
    	 
    	// alert("sid2 month>9 and 5");
			
	      var actyear=vanadate;
			
			 $("#actplanYear").val(actyear);
			 
			 $(".vana").show();
			 $(".yasa").hide();
			
		}
    
if((month>9 && month<=12  && sid==1) || ((month>=0 && month<=4  && sid==1))){
	
//	alert("sid1 month>9 and 4");
	
	var actyear=yasangidate;
	
	$("#actplanYear").val(actyear);
	
	 $(".vana").hide();
	 $(".yasa").show();
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
					
					<div class="col-md-4">Project Name </div>
					<div class="col-md-8">Action</div>
					
					
					
					</div>
					
					<!-- <div id="react-container"></div> -->
					
					<br></br>
					
					
					<c:if test="${projectList!=null }">
					
					<%--  <c:set var="c" value="1" scope="page" /> --%>
					<c:forEach items="${projectList}" var="d" varStatus="count">
					
				
						<%-- <c:if test="${userObj.unitId==d.unitId }"> --%>
						
							
						 
					<div class="col-md-12 invDiv">
					
											 
											
					<div class="col-md-4" style="text-align: center; font-weight: bold; ">
					<button type="button" name="showmandalname" id="showayacutmondata" 
																	class="btn btn-1 btn-info center-block "    ><c:out value="${count.count}"></c:out> &emsp; &emsp;<strong><c:out value="${d.projectName}"></c:out></strong>  </button>
					</div>
				
					<div class="col-md-8"> 
					
					<div class="col-md-12">
					<div class="col-md-3">
					
					<button type="button" name="showtanksname" id="addtankfeedinf" 
																	class="btn btn-1 btn-success center-block addtankfeedinfcls "   onclick="AddSeaAyacutInfo(${d.projectId},'${d.projectName}')" >Add Info</button>
					
					&emsp; &emsp;</div>	
				
					<div class="col-md-3">														
					<button type="button" name="showtanksname" id="showtanksdata" 
																	class="btn btn-1 btn-info center-block "  onclick="ViewSeaAyacutInfo(${d.projectId},'${d.projectName}')"  >View</button>
															
					&emsp;	&emsp;	</div><div class="col-md-3">
					<button type="button" name="showtanksname" id="showtanksdata" 
																	class="btn btn-1 btn-primary center-block " onclick="ViewEditSeaAyacutInfo(${d.projectId},'${d.projectName}')" >Edit</button>
				&emsp;	 &emsp;	</div><div class="col-md-3">
					<button type="button" name="showtanksname" id="showtanksdata" 
																	class="btn btn-1 btn-danger center-block " onclick="ViewDeleteSeaAyacutInfo(${d.projectId},'${d.projectName}')" >Delete</button>
																	

					</div>
				
					</div>
					</div>
					</div>
					
				<%-- 	<c:set var="c" value="${c + 1}" scope="page"/> --%>
						
				<%-- 	</c:if> --%>
					
					
					</c:forEach>
					
					
					</c:if>
					
					
					
					
					
					
					
					</div>
									

	</form:form>
	

&emsp;&emsp;


    
    	</div>
							
					</div>
					
					</div>
					</div>
					
    

  

  
  
  
  
  
   <div id="addseainfo_dialogue" >
  
  <form:form id="projSeaAyacutCap" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		 <input type="hidden" class="form-control"  id="unitId" name="unitId" value="${userObj.unitId}" />
                         <input type="hidden" class="form-control"  id="circleId" name="circleId" value="${userObj.circleId}" />
                            <input type="hidden" class="form-control"  id="divisionId" name="divisionId" value="${userObj.divisionId}" />
                             <input type="hidden" class="form-control"  id="subdivisionId" name="subdivisionId" value="${userObj.subdivisionId}" />
                              <input type="hidden" class="form-control"  id="hiddenprojectId" name="projectId" value="0" />
                              <input type="hidden" class="form-control"  id="hiddenprojectseasonId" name="projectseasonId" value="0" />
                               <input type="hidden" class="form-control"  id="editFlag"  value="false" />
                               
                               <input type="hidden" class="form-control"  id="hiddenseasonId"  value="0" />
		
	
	<div class="col-md-12 invDiv seainfo" >	
	

	 <div class="col-md-6">
	 	 <label class="label-control rowlebel " style="color: blue">Select season</label>
											  <select class="form-control" id="seasonId" name="seasonId" onchange="getactionyear(this.value)" required> 
										<option value=" ">--select--</option>  
										<option   value="1" >Vana kalam / Kharif(1st July-31st Oct)</option>
										<option   value="2">Yasangi / Rabi (1st Dec- 31st May)</option>
										
										
										</select>
											  </div>
	


	<div class="col-md-6">
	 <label class="label-control rowlebel " style="color: blue">Action plan year</label>
											   <input type="text" class=" form-control"  id="actplanYear" name="actplanYear" placeholder=""  readonly="readonly"  required/> 
											  </div>
											  
										
											  
											  <div class="col-md-6 vana">
	 <label class="label-control rowlebel " style="color: blue">Present water level(m)</label>
											  <input type="text" class=" form-control"  id="preWaterLevel" name="preWaterLevel" placeholder=""  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 decimals ex:0.12" value="0.00" /> 
											  </div>
											  
											  		  
											  <div class="col-md-6 vana">
	 <label class="label-control rowlebel " style="color: blue">Present water capacity(TMC)</label>
											  <input type="text" class=" form-control"  id="preWaterCap" name="preWaterCap" placeholder=""  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 decimals ex:0.12" value="0.00" /> 
											  </div>
											  

	                                            
	<div class="col-md-6 yasa">
	 <label class="label-control rowlebel " style="color: blue">Water utilized (TMC)</label>
											  <input type="text" class=" form-control"  id="waterUtil" name="waterUtil" placeholder="" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 decimals ex:0.12"  value="0.00" /> 
											  </div>
											  
	
											  
											  <div class="col-md-6 ">
	 <label class="label-control rowlebel " style="color: blue">Net availability of water(TMC)</label>
											  <input type="text" class=" form-control"  id="BalWaterRequired" name="BalWaterRequired" placeholder=""  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 decimals ex:0.12" value="0.00" /> 
											  </div>
											
											  
	<div class="col-md-6 vana">
	 <label class="label-control rowlebel " style="color: blue">Water required (TMC)</label>
											  <input type="text" class=" form-control"  id="waterRequired" name="waterRequired" placeholder=""  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"  data-parsley-error-message="You must enter 2 decimals ex:0.12" value="0.00" /> 
											  </div>
	
		<div class="col-md-6 vana">
	 <label class="label-control rowlebel " style="color: blue">No of Wettings</label>
											  <input type="text" class=" form-control"  id="noOfWettings" name="noOfWettings" placeholder="0" data-parsley-pattern="^[0-9]*$"
  data-parsley-trigger="blur"  data-parsley-error-message="You must enter number ex: 2 "  value="0"/> 
											  </div>
											  
											  <div class="col-md-6 ">
	 <label class="label-control rowlebel " style="color: blue">Observation date </label>
											  <input type="text" class="datepick form-control datepicker"  id="ObsDate" name="ObsDate" placeholder=""  readonly="readonly" required /> 
											  </div>
											  &emsp;&emsp; 
											  
											   <div class="col-md-12">
	 <label class="label-control rowlebel " style="color: blue">Remarks </label>
											  <textarea  class=" form-control"  id="remarks" name="remarks" placeholder="" cols="80" rows="2" > </textarea>
											  </div>
											  
											  	 <br>	&emsp;&emsp; 
											
											  
											  <div class="col-md-12" style="text-align: center;">
											  
					
					<button type="button" name="showtanksname" id="addtankfeedinf" 
																	class="btn btn-1 btn-primary center-block addtankfeedinfcls "   onclick="AddprojectSeasonCapacity()" >Submit</button>
					
					 <br>	
											  

		   
	</div>										 
											 
											 
										  
						
										
	</div>									
											 
										
</form:form>
  </div>
  
  
  
  
   <div id="viewseainfo_dialogue" >
  
  <form:form id="v_SeaAyacutCap" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
	
		<div id="v_sea_form">
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
  
  
   <div id="viewEditseainfo_dialogue" >
  
  <form:form id="v_editSeaAyacutCap" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
	
		<div id="v_edit_sea_form">
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
  
  
  <div id="viewDeleteseainfo_dialogue" >
  
  <form:form id="v_deleteSeaAyacutCap" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
	
		<div id="v_delete_sea_form">
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



