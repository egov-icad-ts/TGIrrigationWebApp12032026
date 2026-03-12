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
 

<script>
$(document).ready(function(){
	
	$('#distCourt').hide();
	
	

	$('#unitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#projectId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#packageId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#districtId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#mandalId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#villageId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	 
	 
$('#courtId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	 
$('#courtdistrictId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#caseTypeId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#caseGenId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#caseGenSubId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#circleId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#divisionId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#subdivisionId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});




$('#caseStageId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#caseStatusId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#petitionerId').multiselect({
	
    
	 enableClickableOptGroups: true,
    enableCaseInsensitiveFiltering: true,
    enableCollapsibleOptGroups: false,
    includeSelectAllOption: true,
    disableIfEmpty: true
    
});
$('#petitionerAdvId').multiselect({
	
    
	 enableClickableOptGroups: true,
   enableCaseInsensitiveFiltering: true,
   enableCollapsibleOptGroups: false,
   includeSelectAllOption: true,
   disableIfEmpty: true
   
});

$('#respondentId').multiselect({
	
    
	 enableClickableOptGroups: true,
   enableCaseInsensitiveFiltering: true,
   enableCollapsibleOptGroups: false,
   includeSelectAllOption: true,
   disableIfEmpty: true
   
});

$('#respondentAdvId').multiselect({
	
    
	 enableClickableOptGroups: true,
  enableCaseInsensitiveFiltering: true,
  enableCollapsibleOptGroups: false,
  includeSelectAllOption: true,
  disableIfEmpty: true
  
});


});

	 
	  
			




function getProjects(){
	
	 
    var   unitId=$('#unitId').val();
      
  //  alert("procId"+procId);
	$('#projectId').multiselect('rebuild');


	$.ajax({	          
	      url: "../web/getProjects?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	    	  var $select = $('#projectId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#projectId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						
	  						
	  					$('#projectId').append( '<option value="'+value.projectId+'"> '+value.projectName+'</option>' );
	  					
	  				$('#projectId').multiselect('rebuild')
	  				
	  				
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
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 

function getPackages(){
	
	 
    var   projectId=$('#projectId').val();
      
  //  alert("procId"+procId);
	$('#packageId').multiselect('rebuild');


	$.ajax({	          
	      url: "../web/getPackages?projectId="+projectId,
	      type: "GET",
	      success: function (response) {
	    	  var $select = $('#packageId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#packageId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						
	  						
	  					$('#packageId').append( '<option value="'+value.pkgId+'"> '+value.pkgName+'</option>' );
	  					
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
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 
		
function getMandals(){
	
	//alert("kal");

	
	var districtId=document.getElementById("districtId").value;
	
	//alert(districtId);

	$.ajax({	          
	      url: "../web/getMandals?districtId="+districtId,
	      type: "GET",
	      success: function (response) {
	    	  var $select = $('#mandalId');
			  $select.find('option').remove();
			
			 
			  $('#mandalId').append( '<option value="0"> --select--</option>' );
					var obj = JSON.parse(response);
					$.each(obj, function(key, value) {
						
							$('#mandalId').append( '<option value="'+value.mandalId+'"  > '+value.mandalName+'</option>' );
						
		  					
	  	  				$('#mandalId').multiselect('rebuild');
					});

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 

	function getVillages(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var mandalId=document.getElementById("mandalId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getVillages?mandalId="+mandalId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#villageId');
	    	 
			  $select.find('option').remove();
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#villageId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#villageId').append( '<option value="'+value.villageId+'" > '+value.villageName+'</option>' );
					
	  	  				$('#villageId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getCircles(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var unitId=document.getElementById("unitId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getCircles?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#circleId');
	    	 
			  $select.find('option').remove();
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#circleId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#circleId').append( '<option value="'+value.circleId+'" > '+value.circleName+'</option>' );
					
	  	  				$('#circleId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getDivisions(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var circleId=document.getElementById("circleId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getDivisions?circleId="+circleId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#divisionId');
	    	 
			  $select.find('option').remove();
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#divisionId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#divisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
					
	  	  				$('#divisionId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getSubDivisions(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var divisionId=document.getElementById("divisionId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getSubDivisions?divisionId="+divisionId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#subdivisionId');
	    	 
			  $select.find('option').remove();
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#subdivisionId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#subdivisionId').append( '<option value="'+value.subdivisionId+'" > '+value.subdivisionName+'</option>' );
					
	  	  				$('#subdivisionId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}

	
	function getCaseTypes(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var courtId=document.getElementById("courtId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getCaseTypes?courtId="+courtId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#caseTypeId');
	    	 
			  $select.find('option').remove();
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#caseTypeId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#caseTypeId').append( '<option value="'+value.caseTypeId+'" > '+value.caseType+'</option>' );
					
	  	  				$('#caseTypeId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}	 
	
	function getCaseGenSub(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var caseGenId=document.getElementById("caseGenId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getCaseGenSub?caseGenId="+caseGenId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#caseGenSubId');
	    	 
			  $select.find('option').remove();
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#caseGenSubId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#caseGenSubId').append( '<option value="'+value.caseGenSubId+'" > '+value.caseGenSubName+'</option>' );
					
	  	  				$('#caseGenSubId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}	  
	
	
	
	/* function loadcaseinputform(){
		
		alert("kal is here")
		
		  $('#caseinput1').attr('action', "../web/caseinput");
          $("#caseinput1").submit();
         
		
		
	} */
	 

 function callcourt(){
	 
	 var cid=$('#courtId').val();
		
		if(parseInt(cid)==3){
			
			$('#distCourt').show();
		}else{
			
			$('#distCourt').hide();
			
		}
	 
 }


 function addayacut()
 {	
 	  	var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
 	  	var url="../projects/addayacut";
 	  	
 		popup =window.open(url,"_blank",features);
 }
 
 function addComponent()
 {	
 	  	var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
 	  	var url="../projects/addcomponent";
 	  	
 		popup =window.open(url,"_blank",features);
 }
 

	
 
 $(function() {
		
		$("#filingDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		

		$("#counterDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		

		$("#judgementDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		$("#draftdateconttoGP").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		
		
		
 });

</script>
	
	 
	<div class="w3_agile_main_left">

		
		<div class="col-md-12 agile_banner_bottom_grids">
		<div  style="display: block; width: 100%; margin-left:10px;margin-right:10px;">
			 
			<div class="resp-tabs-container">
				<div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active" style="display:block">
					
						




	<c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.employeeName}"></c:out></p>
		</div>
	</div>
	</c:if>



	<div class="page">



		<c:if test="${msg1!=null || err1!=null }">


			<div class="row show-grid">
				<c:if test="${msg1!=null}">
					<div class="alert alert-success" role="alert">
						<strong></strong>
						<c:out value="${msg1}"></c:out> / <c:out value="${msg2}"></c:out> / <c:out value="${msg3}"></c:out> / <c:out value="${msg4}"></c:out> / <c:out value="${msg5}"></c:out> / <c:out value="${msg6}"></c:out>
					</div>

				</c:if>

				<c:if test="${err1!=null}">
					<div class="alert alert-danger" role="alert">
						<strong></strong>
						<c:out value="${err1}"></c:out> / <c:out value="${err2}"></c:out> / <c:out value="${err3}"></c:out> / <c:out value="${err4}"></c:out> / <c:out value="${err5}"></c:out> / <c:out value="${err6}"></c:out> / <c:out value="${err7}"></c:out>
					</div>

				</c:if>

			</div>
		</c:if>
		
	


		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Ayacut Input</h3>
			</div>
<form:form id="ayacutinput" method="post" modelAttribute="projectayacut"  data-parsley-validate-if-empty=""  >
			<div class='container'>




				<div class="row col-md-12 toppad ">

                   
                   <div class="row show-grid">
	<div class="col-md-12">
	<h4  style="color:blue ;margin:1em; font-weight: bold;"> Note: Component length From km and to Km is Package Wise  </h4>
	</div>
	
	</div>	



					<div class="row show-grid">
					<div class="col-md-1"></div>
					<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select Unit *</label>
							<select class="form-control" id="unitId"  name="unitId" onchange="getProjects();getCircles()" required >
							<option value="0">--select --</option>
						<%--  <c:forEach items="${unitList}" var="u">
									<option value="${u.unitId}">${u.unitName}</option>

								</c:forEach> --%>
 

							</select>
						</div>

					
						<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select Project</label>
							<select class="form-control" id="projectId"  name="projectId"  >
							
							


							</select>
							
							
						</div>
						
						<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select Package</label>
							<select class="form-control" id="packageId"  name="packageId"  >
							
							


							</select>
							
							
						</div>
						
							<div class="col-md-2">
						
						<label class="label-control rowlebel "></label><input
								type="button" class="btn btn-1 btn-primary center-block"
								id="addnewpack" value="Add Package" onclick="addPack()" >
						
						</div>
						
						</div>
						
						<div class="row show-grid">					
						
					    <div class="col-md-1"></div>
						<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select Circle</label>
							<select class="form-control" id="circleId"  name="circleId" onchange="getDivisions()">
							<!-- <option value="0">--select--</option>
							<option value="21156">Sripada Yellampally Project Circle,LMD Colony,Karimnagar</option>
							<option value="21157">Indiramma Flood Flow Canal Circle,LMD Colony Karimnagar</option>
							 -->
							

							</select>
						</div>
						<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select Division</label>
							<select class="form-control" id="divisionId"  name="divisionId" onchange="getSubDivisions()">
							<!-- <option value="0">--select--</option>
							<option value="30373">IFFC Division No.6,Jagitial</option>
							<option value="30374">IFFC Division No.1, L.M.D Colony, Karimnagar</option>
							<option value="30375">IFFC Division No.2, ,L.M.D Colony, Karimnagar</option>
							<option value="30376">IFFC Division No.3, Husnabad</option>
							<option value="30378">IFFC Division No.5, L.M.D Colony, Karimnagar</option>
							 -->
							


							</select>
						</div>
						
						<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select SubDivision</label>
							<select class="form-control" id="subdivisionId"  name="subdivisionId">
							<option value="0">--select--</option>
							


							</select>
						</div>
						
						<div class="col-md-2" id="component">
							<label class="label-control rowlebel ">Select Component Category</label> <select
								class="form-control" id="componentId"  name="componentId"  required> 
								<option value="0">--select--</option>
								<option value="0">--Lift --</option>
								<option value="0">--Canal--</option>
								<option value="0">--Reservoir--</option>
								<%--  <c:forEach items="${courtList}" var="u">
									<option value="${u.courtId}">${u.courtName}</option>

								</c:forEach> --%>

							</select>




						</div>
						
						
						
					
						
						
						
						</div>
							<div class="row show-grid">
						<div class="col-md-1"></div>
						
						<div class="col-md-2" id="component">
							<label class="label-control rowlebel ">Select Component </label> <select
								class="form-control" id="componentId"  name="componentId"  required> 
								<option value="0">--RMC Left Name 0-10 @0km --</option>
								<option value="0">--LMC left Name length takeoffpoint --</option>
								<option value="0">--D12 left name 10-20 @5km--</option>
								<option value="1">--Lift left name takeoffpoint--</option>
								<option value="2">--Reservoir capacity name takeoffpoint--</option>
								<option value="3">--Reservoir capacity name takeoffpoint--</option>
								
								

							</select>

                    </div>
                    
                    <div class="col-md-2">
						
						<label class="label-control rowlebel "></label><input
								type="button" class="btn btn-1 btn-primary center-block"
								id="addcomp" value="Add Component" onclick="addComponent()" >
						
						</div>
						
						<div class="col-md-2">

							<label class="label-control rowlebel ">Ayacut in Acres</label> <input
								type="text" class="form-control" 
								id="caseWpNumber" name="caseWpNumber" placeholder="2300Acres"  readonly="readonly" required/>
						</div>
						
						
						
							<div class="col-md-2">
						
						<label class="label-control rowlebel "></label><input
								type="button" class="btn btn-1 btn-primary center-block"
								id="add" value="Add Ayacut" onclick="addayacut()" >
						
						</div>
						
						
						
						
								
						
						</div>
					
						
						
						<div class="row show-grid">
						<div class="col-md-1"></div>
						
						<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select Structures</label>
							<select class="form-control" id="divisionId"  name="divisionId" onchange="getSubDivisions()">
							<option value="0">--SLRB -2no --</option>
							<option value="0">--DLRB -2no --</option>
							<option value="0">--Pipe Culvert -1no --</option>


							</select>
						</div>
						
						 <div class="col-md-2">
							<label class="label-control rowlebel "></label><input
								type="submit" class="btn btn-1 btn-primary center-block"
								id="addstructure" value="Add Structures" >
						</div>
						
						
						
						<div class="col-md-2">

							<label class="label-control rowlebel ">Off take point of Component</label> <input
								type="text" class="form-control" 
								id="caseWpNumber" name="caseWpNumber" placeholder="2324"  required/>
						</div>
						
						<div class="col-md-2">

							<label class="label-control rowlebel ">From Km</label> <input
								type="text" class="form-control" 
								id="caseWpNumber" name="caseWpNumber" placeholder="2324"  required/>
						</div>
						
						<div class="col-md-2">

							<label class="label-control rowlebel ">To Km</label> <input
								type="text" class="form-control" 
								id="caseWpNumber" name="caseWpNumber" placeholder="2324"  required/>
						</div>
						
						
                      
						
						
						
						
						
					
						

<div class="col-md-1"></div>


					</div>

				

					
			






					

				
						
							
					
						
						
						
					
				
				
					<div class="row show-grid">
                       <div class="col-md-10 ">
							<label class="label-control rowlebel "></label><input
								type="submit" class="btn btn-1 btn-primary center-block"
								id="addCases" value="Add Component ayacut" onclick="loadcaseinputform()">
						</div>
						</div>







			
</div>

			</div>
			</form:form>

		</div>
		
		<!-- page -->
	</div>




<!-- create component ends here -->


					</div>
		
					
			
				
				
			</div>
		</div>
	</div>
	 
	 
	 
	 
</div>
<!-- //main-content -->
 <script type="text/javascript" src="../js/parsley.js"></script>

    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#ayacutinput').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  
			 
				
			  document.forms.ayacutinput.action="../projects/ayacutinput";
				 document.forms.ayacutinput.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

 