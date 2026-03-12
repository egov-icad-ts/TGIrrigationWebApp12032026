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
	 
	 $('#packId').hide();
	
$('#unitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	 
$('#projectId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#packageId').multiselect({
	 
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

$('#districtId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#mandalId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#villageId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#componentDirection').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});


$('#componentCategoryId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#parentComponentId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#liftStaticsign').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#liftDynamicsign').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#statusId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});









	 

}); 


	 
	  
function closeWindow()
{
	  // window.opener.location.reload();
		    	self.close();
	
}	  			


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

function getPackages(projId){
	
	 
    var   projectId=projId
    	//$('#projectId').val();
      
  //  alert("procId"+procId);
	$('#packageId').multiselect('rebuild');


	$.ajax({	          
	      url: "../comptsimis/getProjPacks?projectId="+projectId,
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


	function getParents(){
		
		 
	    var   projectId=$('#projectId').val();
	      
	  //  alert("procId"+procId);
		$('#parentComponentId').multiselect('rebuild');


		$.ajax({	          
		      url: "../comptsimis/getparent?projectId="+projectId,
		      type: "GET",
		      success: function (response) {
		    	  var $select = $('#parentComponentId');
		  				$select.find('option').remove();
		  				
		  			
		  					
		  					var obj = JSON.parse(response);
		  					
		  				$('#parentComponentId').append( '<option value=" "> --select--</option>' );
		  				$('#parentComponentId').append( '<option value="-1">No Parent</option>' );
		  					
		  					$.each(obj, function(key, value) {
		  						
		  						
		  						
		  						
		  						
		  					$('#parentComponentId').append( '<option value="'+value.componentId+'"> '+value.componentName+'</option>' );
		  					
		  				$('#parentComponentId').multiselect('rebuild')
		  				
		  				
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

	
 
  $(function() {
		
	  var a=0;
	  var b=0;
	  var c=0;
	  var d=0;
	  var e=0;
	  $( "#totalpower" ).keyup(function() {
		  a=this.value;
		
		  if(a!=null){
			  b=a;
		  }
		  
		  if(a==null){
			  
			  b=0;
		  }
		  if(parseFloat(a)=='NaN'){
			  alert("kal");
			  b=0;
			  
		  }
		  
		 
		  e=parseFloat(b)
		//  alert("c"+c);
		// alert("e"+e);
		 $("#totalpowerwithAux").val(0); 
		  
		 $("#totalpowerwithAux").val(e);
		});
	  
	  var f=0;
	 var  g=0
	 var  h=0;
	 var  i=0;
	 var   j=0;	
	
	 
	  $( "#auxPower" ).keyup(function() {
		  f=this.value;
		  g=$("#totalpower").val();
		  
		  if(f!=null){
			  h=f;
		  }
		  if(g!=null){
			  i=g;
			  
		  }
		  if(f==null){
			  
			  h=0;
		  }
		  if(g==null){
			 // alert("kal");
			  i=0;
			  
		  }
		 // alert("j"+j+"h"+h);
		  j=parseFloat(h)+parseFloat(i);
		 // alert("h"+h);
		// alert("j"+j);
		 $("#totalpowerwithAux").val(0); 
		 $("#totalpowerwithAux").val(j);
		});
		
		
	  
	  $('#packageId').change(function(){
			
			var x=$(this).val();
			//alert("x"+x);
			
			if(x==1){
			
			$('#packId').show();
			} else{
				
				$('#packId').hide();
			} 
			
		}); 
			
		
 }); 

</script>
	<c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.employeeName}"></c:out></p>
		</div>
	</div>
	</c:if>
	
		<c:if test="${msg!=null || err!=null }">
		
	

			<div class="row show-grid">
				<c:if test="${msg!=null}">
					<div class="alert alert-success" role="alert">
						<strong></strong>
						<c:out value="${msg}"></c:out> 
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

	
	 
	 <div class="w3_agile_main_left"> 

		
		<!-- <div class="col-md-12 agile_banner_bottom_grids"> -->
		<!-- <div  style="display: block; width: 100%; margin-left:10px;margin-right:10px;">
			  -->
			<!-- <div class="resp-tabs-container"> -->
				<!-- <div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active" style="display:block"> -->
					
	
		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Add Component</h3>
			</div>
<form:form id="addcompForm" method="post" modelAttribute="compObj" class="stepform"  data-parsley-validate-if-empty=""   >
			



             
    <div class="form-section"  >
    <div class="row col-md-12 toppad " style="padding:35px 8px;">
     <div class="col-md-6"  >
    	
    	 <div class="col-md-6"  >
							<label class="label-controlPMS rowlebel ">Select Unit *</label>
							</div>
							 <div class="col-md-6"  >
							
							<select class="form-control" id="unitId"  name="unitId" onchange="getProjects()"  required >
							<option value=" ">--select --</option>
						 <c:forEach items="${unitList}" var="u">
									<option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
 

							</select>
							</div>
							 <div class="col-md-6"  >
						
							<label class="label-controlPMS rowlebel ">Select Project</label>
							</div>
							
							 <div class="col-md-6"  >
							
							<select class="form-control" id="projectId"  name="projectId"
								onchange="getPackages(this.value),getParents()" required>
						</select>
						</div>
						 <div class="col-md-6"  >
							<label class="label-controlPMS rowlebel ">Select Package</label>
							</div>
							
							 <div class="col-md-3"  >
							
							<select class="form-control" id="packageId"  name="packageId"  >
							
							


							</select>
							</div>
							<div class="col-md-3 cellMargin" id="packId">

							<input type="text" class="form-control" id="packageName"
								name="packageName" placeholder="EX:Package No-1" value=" " />
						</div>
						
							
							
						
						<!-- 	<label class="label-controlPMS rowlebel ">Select Circle</label>
							
							
							
											<select class="form-control" id="circleId"  name="circleId" onchange="getDivisions()">
							</select> -->
						
							<!-- <label class="label-controlPMS rowlebel ">Select Division</label>
							
							<select class="form-control" id="divisionId"  name="divisionId" onchange="getSubDivisions()">
							</select> -->
						<!-- 
							<label class="label-controlPMS rowlebel ">Select SubDivision</label>
							
							<select class="form-control" id="subdivisionId"  name="subdivisionId">
							</select>
						 -->
						<%-- 	<label class="label-controlPMS rowlebel ">Select District*</label>
							
							<select class="form-control" id="districtId" name="districtId" onchange="getMandals()"
								 required>

								 <option value="0">--select--</option>
								<c:forEach items="${districtList}" var="d">
									<option value="${d.districtId}">${d.districtName}</option>

								</c:forEach>
 

							</select> --%>
						
							<!-- <label class="label-controlPMS rowlebel ">Select Mandal</label>
							
							<select class="form-control" id="mandalId" name="mandalId"
								onchange="getVillages()" required>

								 <option value="0">--select--</option>
								
 

							</select>
						 -->
							<!-- <label class="label-controlPMS rowlebel ">Select Village</label>
							
							<select class="form-control" id="villageId" name="villageId"
								 required>

								 <option value="0">--select--</option>
								 
								

							</select> -->
					
						
							
					</div>
					 <div class="col-md-6"  >	
					  <div class="col-md-6"  >
							<label class="label-control rowlebel ">Component Name*</label> 
							</div>
							 <div class="col-md-6"  >
							
							<input
								type="text" class="form-control" 
								id="componentName" name="componentName" placeholder="ex: Gangadhra pumphouse"  required  />
						
						</div>
						
						<%--   <div class="col-md-6"  >
							<label class="label-controlPMS rowlebel ">Select component category</label>
							</div>
							  <div class="col-md-6"  >
						
							<select class="form-control" id="componentCategoryId" name="componentCategoryId"
								 required>

								 <option value="0">--select--</option>
								  <option value="1">Reservoir</option>
								   <option value="2">Lift</option>
								    <option value="3">Canal</option>
								<c:forEach items="${caseGenList}" var="p">
									<option value="${p.caseGenId}">${p.caseGeneral}</option>

								</c:forEach>
 

							</select>
							</div> --%>
					
						<!--   <div class="col-md-6"  >
							<label class="label-control rowlebel ">Component Direction*</label> 
							</div>
							  <div class="col-md-6"  >
							
							<select class="form-control" id="componentDirection" name="componentDirection"
								required>

								 <option value="0">--select--</option>
								 <option value="1">Left</option>
								 <option value="2">Right</option>
								

							</select>
							</div>
						 -->
						  <div class="col-md-6"  >
							<label class="label-control rowlebel ">Select Parent Component*</label>
							</div>
							
							  <div class="col-md-6"  >
							
							 <select
								class="form-control" id="parentComponentId"  name="parentComponentId"  required > 
								
								<!-- <option value="-1">No Parent</option> -->
								
								

							</select>
							</div>

						

						
						
						
						<!-- 	<label class="label-control rowlebel ">Component Description*</label>
							
							 <input
								type="text" class="form-control" 
								id="componentDesc" name="componentDesc" placeholder="ex:Gangadhara pumphouse description"  />
						 -->
						
							
						

						
							
                     <div class="col-md-6"  >
							<label class="label-control rowlebel ">From Location(Name)</label> 
							<input
								type="text" class="form-control" 
								id="fromlocation" name="fromlocation" placeholder="from location"   required/>
								</div>
								
								  <div class="col-md-6"  >
								
								<label class="label-control rowlebel ">TO Location(Name)</label> 
								<input
								type="text" class="form-control" 
								id="tolocation" name="tolocation" placeholder="to location"  />
								</div>
					
							
						

						
							
                             <div class="col-md-6"  >
							<label class="label-control rowlebel ">Discharge (cusecs)</label>
							</div>
							  <div class="col-md-6"  >
							<input
								type="text" class="form-control" 
								id="dischrgecusecs" name="dischrgecusecs" placeholder=" Discharge cusecs"  required />
								</div>
					
							
						

						
    
                      
							
                               <div class="col-md-6"  >
							<label class="label-control rowlebel ">Component Length(PM length )</label> 
							</div>
							  <div class="col-md-6"  >
							<input
								type="text" class="form-control" 
								id="componentLength" name="componentLength" placeholder="length in Km"   required/>
								</div>
								  <div class="col-md-6"  >
							<label class="label-control rowlebel ">Status</label>
							</div>
							 <div class="col-md-6"  >
							
							<select class="form-control" id="statusId" name="statusId"
								required>

								 <option value=" ">--select--</option>
								 <option value="1">Commissioned </option>
								 <option value="2">Not Commissioned</option>
								  <option value="3">In Progress</option>
								   <option value="4">Not Tackled</option>
								
 

							</select>
							</div>
					
							
						

						
                           


						
						
						
						
						
					
					
						
						
						
						
		</div>				
    </div>
    </div>
    <div class="form-section" >
      <div class="row col-md-12 toppad " style="padding:35px 8px;">
      <div class="col-md-6"  >
						
						
					
  <div class="col-md-6"  >
							<label class="label-control rowlebel ">Pipe Diameter(m)</label>
							</div>
							  <div class="col-md-6"  >
							
						 <input
								type="text" class="form-control" 
								id="pipediameter" name="pipediameter" placeholder="ex:4"  />
								</div>
					
							
						

					
						
					
							  <div class="col-md-6"  >

							<label class="label-control rowlebel ">No of Pipe Rows</label> 
							</div>
							  <div class="col-md-6"  >
							<input
								type="text" class="form-control" 
								id="noofpiperows" name="noofpiperows" placeholder="ex:2"  />
								</div>
					
							
						

					
					
						
						  <div class="col-md-6"  >
						<label class="label-control rowlebel ">Static Head (Meters)</label>
						</div>
						
						
							
  <div class="col-md-6"  >
							<input
								type="text" class="form-control" 
								id="liftStatic" name="liftStatic" placeholder="ex:23.2"  />
								</div>
					
							
						

					
                            <div class="col-md-6"  >
							<label class="label-control rowlebel ">Dynamic Head (Meters)</label>
							</div>
							  <div class="col-md-6"  >
							
							 <input
								type="text" class="form-control" 
								id="liftDynamic" name="liftDynamic" placeholder="ex:23.2"  />
								</div>
					
							
						

					
							
  <div class="col-md-6"  >
							<label class="label-control rowlebel ">Total Lift (Meters)</label> 
							</div>
							  <div class="col-md-6"  >
							<input
								type="text" class="form-control" 
								id="totalLift" name="totalLift" placeholder="ex:24.5"  />
								</div>
					
							
						

						
							
  <div class="col-md-6"  >
							<label class="label-control rowlebel ">Total Lift period (Days)</label>
							</div>
							  <div class="col-md-6"  >
							<input
								type="text" class="form-control" 
								id="liftperiod" name="liftperiod" placeholder="ex:120"  />
								</div>
					  <div class="col-md-6"  >
							
						


							<label class="label-control rowlebel ">Total Lift (TMC)</label> 
							</div>
							  <div class="col-md-6"  >
							<input
								type="text" class="form-control" 
								id="lifttmc" name="lifttmc"  placeholder="ex:24"  />
								</div>
								
								<div class="col-md-6"  >
							<label class="label-control rowlebel ">Power of each M/P(MW)</label> 
							</div>
							  <div class="col-md-6"  >
							<input
								type="text" class="form-control" 
								id="eachmotorPower" name="eachmotorPower" placeholder="ex:24"  />
								</div>
					
							
						
</div>
					  <div class="col-md-6"  >
							
                            
					
							
						

							
  <div class="col-md-6"  >
							<label class="label-control rowlebel ">Total Power(MW)</label> 
							</div>
							  <div class="col-md-6"  >
						
							
							<input
								type="text" class="form-control" 
								id="totalpower" name="totalpower"  placeholder="ex:23.4"  />
								</div>
					
							
						

						
  <div class="col-md-6"  >
							<label class="label-control rowlebel ">Auxilary power(MW)</label>
							</div>
							  <div class="col-md-6"  >
							<input
								type="text" class="form-control" 
								id="auxPower" name="auxPower" placeholder="ex:23.4"  />
								</div>
					
							
						

					
							
  <div class="col-md-6"  >
							<label class="label-control rowlebel ">Total Power with Auxilary(MW)</label> 
							</div>
							  <div class="col-md-6"  >
							<input
								type="text" class="form-control" 
								id="totalpowerwithAux" name="totalpowerwithAux"  placeholder="ex:23.4"   readonly="readonly"/>
								</div>
					
							
						

						
  <div class="col-md-6"  >
							<label class="label-control rowlebel ">Sub Station Capacity(Volts)</label> 
							</div>
							  <div class="col-md-2"  >
							
							
							<input
								type="text" class="form-control" 
								id="substationHV" name="substationHV" placeholder="ex:1300"  />
								</div>
								
							 <div class="col-md-2"  >	
								<input
								type="text" class="form-control" 
								id="substationdivision" name="substationdivision"  value="/"  readonly="readonly"/>
								</div>
								
							 <div class="col-md-2"  >	
								<input
								type="text" class="form-control" 
								id="substationLV" name="substationLV"  placeholder="ex:440" />
					
					</div>
							
						

						
							
 <div class="col-md-6"  >
							<label class="label-control rowlebel ">MDDL(mts)</label>
							</div>
							 <div class="col-md-3"  >
							
							<select class="form-control" id="liftStaticsign" name="liftStaticsign"
								 required>

								 <option value="0">--select--</option>
								 <option value="1">+</option>
								 <option value="2">-</option>
								
 

							</select>
							</div>
							
							 <div class="col-md-3"  >
							
							
							<input
								type="text" class="form-control" 
								id="mddl" name="mddl"  placeholder="ex:34"  />
								</div>
					
							
						

						
							
 <div class="col-md-6"  >
							<label class="label-control rowlebel ">Delivery Level(M)</label> 
							</div>
							 <div class="col-md-3"  >
							
							<select class="form-control" id="liftDynamicsign" name="liftDynamicsign"
								required>

								 <option value="0">--select--</option>
								 <option value="1">+</option>
								 <option value="2">-</option>
								
 

							</select>
							</div>
							 <div class="col-md-3"  >
							<input
								type="text" class="form-control" 
								id="deliveryLevel" name="deliveryLevel"  placeholder="ex:23.4"  />
								</div>
					
							
						

					
						
							
                          
					
							
						

						
						
		 <div class="col-md-6"  >			
		<label class="label-control rowlebel ">Remarks</label>
		</div>
		 <div class="col-md-6"  >
							<textarea
							 class="form-control"   
								id="remarks"  name="remarks" ></textarea>	
								</div>			
						
						
    
    </div>
    </div>
    
    </div>
   
  
						
						
						
						<div class="form-navigation">
    <button type="button" class="previous btn btn-primary pull-left">&lt; Previous</button>
    <button type="button" class="next btn btn-primary pull-right">Next &gt;</button>
    <input class="btn btn-primary pull-right"  value ="Submit" type="submit">
    <span class="clearfix"></span>
  </div>
					
  <!--   
    <div class="row show-grid ">
                       <div class="col-md-10 ">
							<label class="label-control rowlebel "></label><input
								type="submit" class="btn btn-1 btn-primary center-block"
								id="addcomp" value="Add Component" onclick="loadcaseinputform()">
						</div>
						</div> -->




			
			</form:form>

		 </div> 
	






<!-- create component ends here -->


					
	 
</div> 
<!-- //main-content -->
 <script type="text/javascript" src="../js/parsley.js"></script>

    
    
    <script type="text/javascript" class="example">
    
    
    
    
$(function () {
	
	
	 var $sections = $('.form-section');

	  function navigateTo(index) {
		 // alert("index"+index);
	    // Mark the current section with the class 'current'
	    $sections
	      .removeClass('current')
	      .eq(index)
	        .addClass('current');
	    // Show only the navigation buttons that make sense for the current section:
	    $('.form-navigation .previous').toggle(index > 0);
	    var atTheEnd = index >= $sections.length - 1;
	    $('.form-navigation .next').toggle(!atTheEnd);
	    $('.form-navigation [type=submit]').toggle(atTheEnd);
	  }

	  function curIndex() {
	    // Return the current index by looking at which section has the class 'current'
	    return $sections.index($sections.filter('.current'));
	  }

	  // Previous button is easy, just go back
	  $('.form-navigation .previous').click(function() {
	    navigateTo(curIndex() - 1);
	  });

	  // Next button goes forward iff current block validates
	  $('.form-navigation .next').click(function() {
	    $('.stepform').parsley().whenValidate({
	      group: 'block-' + curIndex()
	    }).done(function() {
	      navigateTo(curIndex() + 1);
	    });
	  });
	  
	  // Prepare sections by setting the `data-parsley-group` attribute to 'block-0', 'block-1', etc.
	  $sections.each(function(index, section) {
	    $(section).find(':input').attr('data-parsley-group', 'block-' + index);
	  });
	  navigateTo(0); // Start at the beginning

	   $('#addcompForm').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0; 
		
		   // alert('hi');
		    
		    })
		  
		  .on('form:submit', function() {
			  alert("coming here");
			  
			 
				
			  document.forms.addcompForm.action="../comptsimis/addcomp";
				 document.forms.addcompForm.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  }); 
});
</script>

 