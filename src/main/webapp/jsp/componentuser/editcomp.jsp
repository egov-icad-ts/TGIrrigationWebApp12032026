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
	  				
	  			 var selectedproj=	$('#hiddenProjId').val();
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#projectId').append( '<option value=" "> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  					if(value.projectId==selectedproj){	
	  						
	  					$('#projectId').append( '<option value="'+value.projectId+'" selected="selected"> '+value.projectName+'</option>' );
	  					}
	  					if(selectedproj==null||value.projectId!=selectedproj){
	  						
	  						$('#projectId').append( '<option value="'+value.projectId+'"> '+value.projectName+'</option>' );
	  						
	  					}
	  					
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

function getPackages(m){
	
	 
    var   projectId=m;
    	$('#projectId').val();
      
    //alert("procId"+procId);
	$('#packageId').multiselect('rebuild');


	$.ajax({	          
	      url: "../comptsimis/getProjPacks?projectId="+projectId,
	      type: "GET",
	      success: function (response) {
	    	  
	    	 // alert("response"+response);
	    	  var $select = $('#packageId');
	  				$select.find('option').remove();
	  				
	  			  var selectedpack=$('#hiddenPackId').val();
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#packageId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						
	  					if(selectedpack==value.pkgId){	
	  					$('#packageId').append( '<option value="'+value.pkgId+'" selected="selected"> '+value.pkgName+'</option>' );
	  					}
	  					
	  					if(selectedpack==null||selectedpack!=value.pkgId){	
		  					$('#packageId').append( '<option value="'+value.pkgId+'"> '+value.pkgName+'</option>' );
		  					}
	  					
	  				$('#packageId').multiselect('rebuild');
	  				
	  				
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
		

	function getParents(m){
		
		 
	    var   projectId=m;
	    	//$('#projectId').val();
	      
	  //  alert("procId"+procId);
		$('#parentComponentId').multiselect('rebuild');


		$.ajax({	          
		      url: "../comptsimis/getparent?projectId="+projectId,
		      type: "GET",
		      success: function (response) {
		    	  var $select = $('#parentComponentId');
		  				$select.find('option').remove();
		  				
		  			        var selectedval=$('#hiddencompParentId').val()
		  					
		  					var obj = JSON.parse(response);
		  					
		  				$('#parentComponentId').append( '<option value="0"> --select--</option>' );
		  				
		  				if(selectedval==-1){	
	  						
		  					$('#parentComponentId').append( '<option value="'+selectedval+'" selected="selected"> No Parent</option>' );
		  					}
		  				if(selectedval!=-1){	
		  					
		  					$('#parentComponentId').append( '<option value="-1"> No parent</option>' );
		  				
		  				}
		  					
		  					$.each(obj, function(key, value) {
		  						
		  						//alert("selectedval"+selectedval);
		  						
		  					if(selectedval==value.componentId){	
		  						
		  					$('#parentComponentId').append( '<option value="'+value.componentId+'" selected="selected"> '+value.componentName+'</option>' );
		  					}
		  					
		  					
			  					
		  					if(selectedval==null ||selectedval!=value.componentId){	
		  						
			  					$('#parentComponentId').append( '<option value="'+value.componentId+'"> '+value.componentName+'</option>' );
			  					
			  					
			  					}
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
			 // alert("kal");
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
		
		
		
		$("#editcompbutton").click(function(){
			
			 $("#componentName").attr("readonly", false);
			 $("#componentDesc").attr("readonly", false);
			 $("#fromlocation").attr("readonly", false);
			 $("#tolocation").attr("readonly", false);
			 $("#dischrgecusecs").attr("readonly", false);
			 $("#componentLength").attr("readonly", false);
			 $("#pipediameter").attr("readonly", false);
			 $("#noofpiperows").attr("readonly", false);
			 $("#liftStatic").attr("readonly", false);
			 $("#liftDynamic").attr("readonly", false);
			 $("#totalLift").attr("readonly", false);
			 $("#liftperiod").attr("readonly", false);
			 $("#lifttmc").attr("readonly", false);
			 $("#eachmotorPower").attr("readonly", false);
			 $("#totalpower").attr("readonly", false);
			 $("#auxPower").attr("readonly", false);
			 $("#totalpowerwithAux").attr("readonly", false);
			 $("#mddl").attr("readonly", false);
			 $("#deliveryLevel").attr("readonly", false);
			 $("#substationHV").attr("readonly", false);
			 $("#substationLV").attr("readonly", false);
			 $("#remarks").attr("readonly", false);
			 $("#editFlag").val(true);
			 
			 
		}); 
		
		
		
		var myunit= parseInt($("#unitId").val()); 
		if(myunit!=null && myunit>0){
			//alert(myunit+"myunit");
			getProjects();	
			
			
			var myproj= parseInt($("#hiddenProjId").val()); 
			//alert("m"+myproj);
			var m=myproj;
			if(m!=null && m>0){
				//alert(myproj+"myproj");
				getPackages(m);
				getParents(m);
				
				
			}
			
			
				
				
			
		}

		
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
<script>
    window.onunload = refreshParent;
    function refreshParent() {
    	 self.close();
       window.opener.location.reload(true);
       
    }
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
				<h3 class="panel-title">Edit Component</h3>
			</div>
<form:form id="editcompform" method="post" modelAttribute="editcomp"  data-parsley-validate-if-empty=""  >
 <c:if test="${editcompObj!=null}">
 

				<input name=hiddenProjId  id="hiddenProjId" type=hidden value="${selectedProj }" >
					<input name=hiddenPackId  id="hiddenPackId" type=hidden value="${selctedPack}" >
				
			
				<input name=hiddencompParentId id="hiddencompParentId" type=hidden value="${selctedParentCompId }" >
				
				<input name=editFlag id="editFlag" type=hidden  value="false" >
				
				<input name=compPackId id="compPackId" type=hidden  value="${editcompObj.compPackId }" >
				<input name=componentId id="componentId" type=hidden  value="${editcompObj.componentId}" >
				

			<div class='container'>



              <div class="row toppad">
    <div class="col-md-6" >
    
    	<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Unit *</label>
							</div>
							<div class="col-md-6">
							<select class="form-control" id="unitId"  name="unitId" onchange="getProjects()" required >
							<option value="0">--select --</option>
						 <c:forEach items="${unitList}" var="u">
						
						 <c:choose>
						 <c:when test="${u.unitId==selctedUnitId}">
									<option value="${u.unitId}" selected="selected" >${u.unitName}</option>
									</c:when>
									<c:otherwise>
									
									<option value="${u.unitId}">${u.unitName}</option>
									
									</c:otherwise>
									</c:choose>

								</c:forEach>
 

							</select>
						</div>
						
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Project</label>
							</div>
							<div class="col-md-6">
							<select class="form-control" id="projectId"  name="projectId"
								onchange="getPackages(this.value),getParents(this.value)">
						</select>
						</div>
						
							<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Package</label>
							</div>
							<div class="col-md-3">
							<select class="form-control" id="packageId"  name="packageId"  >
							
							


							</select>
							
							
						</div>
						
							<div class="col-md-3" id="packId">

							<input type="text" class="form-control" id="packageName"
								name="packageName" placeholder="EX:Package No-1" value=" " />
						</div>
						
					<!-- 	<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Circle</label>
							</div>
							
							
							<div class="col-md-6">					<select class="form-control" id="circleId"  name="circleId" onchange="getDivisions(this.value)">
							</select>
						</div>
						 -->
					<!-- 	<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Division</label>
							</div>
							<div class="col-md-6">
							<select class="form-control" id="divisionId"  name="divisionId" onchange="getSubDivisions(this.value)">
							</select>
						</div>
						 -->
						<!-- <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select SubDivision</label>
							</div>
							
							<div class="col-md-6">
							<select class="form-control" id="subdivisionId"  name="subdivisionId">
							</select>
						</div> -->
						
						<%-- <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select District*</label>
							</div>
							<div class="col-md-6">
							<select class="form-control" id="districtId" name="districtId" onchange="getMandals()"
								 required>

								 <option value="0">--select--</option>
								<c:forEach items="${districts}" var="d">
								
								 <c:choose>
						 <c:when test="${d.districtId==selcteddistId}">
						 <option value="${d.districtId}" selected="selected">${d.districtName}</option>
						 </c:when>
						 <c:otherwise>
						
									<option value="${d.districtId}">${d.districtName}</option>
									</c:otherwise>
                             </c:choose>
								</c:forEach>
 

							</select>
						</div> --%>
						
						<!-- <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Mandal</label>
							</div>
							
							<div class="col-md-6">
							<select class="form-control" id="mandalId" name="mandalId"
								onchange="getVillages(this.value)" required>

								 <option value="0">--select--</option>
								
 

							</select>
						</div> -->
						
					<!-- 	<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Village</label>
							</div>
							<div class="col-md-6">
							<select class="form-control" id="villageId" name="villageId"
								 required>

								 <option value="0">--select--</option>
								 
								

							</select>
						</div>
						 -->
						 <div class="col-md-6" id="component">
						
							<label class="label-control rowlebel ">Component Name*</label> 
							</div>
							<div class="col-md-6">
							<input
								type="text" class="form-control" 
								id="componentName" name="componentName" placeholder="ex: Gangadhra pumphouse"  value="${editcompObj.componentName}"  readonly="readonly" required/>
						
						
							
						

						</div>
						<%-- <div class="row show-grid">
						<div class="col-md-6 " id="component">
						
							<label class="label-control rowlebel ">Component Description*</label>
							</div>
							
							<div class="col-md-6">
							 <input
								type="text" class="form-control" 
								id="componentDesc" name="componentDesc" placeholder="ex:Gangadhara pumphouse description" value="${editcompObj.componentDesc}"  readonly="readonly" required/>
						
						
							
						

						</div>
						</div>
						 --%>
						
						

						
							
						
						
						  <div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">From Location(Name)</label> 
							</div>
							<div class="col-md-6"><input
								type="text" class="form-control" 
								id="fromlocation" name="fromlocation" placeholder="from location"  value="${editcompObj.fromlocation}"  readonly="readonly" required/>
								</div>
								<div class="col-md-6">
								<label class="label-control rowlebel ">TO Location(Name)</label> 
								</div>
								<div class="col-md-6"><input
								type="text" class="form-control" 
								id="tolocation" name="tolocation" placeholder="to location"  value="${editcompObj.tolocation}"  readonly="readonly" />
					
							
						

						</div>
						
							 <div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Discharge (cusecs)</label>
							</div>
							<div class="col-md-6"> <input
								type="text" class="form-control" 
								id="dischrgecusecs" name="dischrgecusecs" placeholder=" Discharge cusecs" value="${editcompObj.dischrgecusecs}"  readonly="readonly"  required/>
					
							
						

						</div>
						 <div class="row show-grid ">
    
                       <div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Component Length(pressure main length )</label> 
							</div>
							
							<div class="col-md-6"><input
								type="text" class="form-control" 
								id="componentLength" name="componentLength" placeholder="length in Km" value="${editcompObj.componentLength}"  readonly="readonly"  required/>
					
							
						

						</div>
						</div>
						<div class="col-md-6">

							<label class="label-control rowlebel ">Component Direction*</label> 
							</div>
							
							<div class="col-md-6">
							<select class="form-control" id="componentDirection" name="componentDirection"
								required>

								 <option value="0">--select--</option>
								 <c:choose>
								 <c:when test="${selctedCompDirection==1}">
								 <option value="1" selected="selected">Left</option>
								 </c:when>
								 <c:otherwise>
								  <option value="1">Left</option>
								 </c:otherwise>
								  </c:choose>
								  <c:choose>
								 <c:when test="${selctedCompDirection==2}">
								 <option value="2" selected="selected">Right</option>
								  </c:when>
								 <c:otherwise>
								  <option value="2">Right</option>
								 </c:otherwise>
								  </c:choose>
								
								

							</select>
						</div>
						
						<div class="row show-grid">
						<div class="col-md-6" id="component">
							<label class="label-control rowlebel ">Select Parent Component*</label>
							</div>
							
							<div class="col-md-6">
							 <select
								class="form-control" id="parentComponentId"  name="parentComponentId"  required> 
								<option value="0">--select--</option>
								
								
								

							</select>




						</div>
						</div>
						<div class="row show-grid">
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select component category</label>
							</div>
							<div class="col-md-6">
							<select class="form-control" id="componentCategoryId" name="componentCategoryId"
								 required>

								 <option value="0">--select--</option>
								  <c:choose>
								  <c:when test="${selctedCateId==1 }">
								  <option value="1" selected="selected">Reservoir</option>
								  </c:when>
								  <c:otherwise>
								   <option value="1">Reservoir</option>
								   </c:otherwise>
								   </c:choose>
								  <c:choose>
								  <c:when test="${selctedCateId==2 }">
								   <option value="2" selected="selected">Lift</option>
								   </c:when><c:otherwise>
								   <option value="2">Lift</option>
								   </c:otherwise>
								   </c:choose>
								    <c:choose>
								  <c:when test="${selctedCateId==3}">
								    <option value="3">Canal</option>
								    </c:when>
								     <c:otherwise>
								   <option value="3">Canal</option>
								   </c:otherwise>
								    </c:choose>
								
 

							</select>
						</div>
						</div>
						
						
						
					
					
						
						
						
						
						
    
    </div>
    <div class="col-md-6" >
    
						
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Pipe Diameter(m)</label>
							</div>
							<div class="col-md-6"> <input
								type="text" class="form-control" 
								id="pipediameter" name="pipediameter" placeholder="ex:4" value="${editcompObj.pipediameter}"  readonly="readonly" required/>
					
							
						

						</div>
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">No of Pipe Rows</label> 
							</div>
							<div class="col-md-6"><input
								type="text" class="form-control" 
								id="noofpiperows" name="noofpiperows" placeholder="ex:2" value="${editcompObj.noofpiperows}"  readonly="readonly" required/>
					
							
						

						</div>
					
						
						<div class="col-md-6" id="component">
						<label class="label-control rowlebel ">Static Head (Meters)</label>
						</div> 
						<div class="col-md-6">
						
							

							<input
								type="text" class="form-control" 
								id="liftStatic" name="liftStatic" placeholder="ex:23.2"  value="${editcompObj.liftStatic}"  readonly="readonly" required/>
					
							
						

						</div>
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Dynamic Head (Meters)</label>
							</div>
							<div class="col-md-6" >
							 <input
								type="text" class="form-control" 
								id="liftDynamic" name="liftDynamic" placeholder="ex:23.2"  value="${editcompObj.liftDynamic}"  readonly="readonly" required/>
					
							
						

						</div>
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Total Lift (Meters)</label> 
							</div>
							<div class="col-md-6" ><input
								type="text" class="form-control" 
								id="totalLift" name="totalLift" placeholder="ex:24.5"  value="${editcompObj.totalLift}"  readonly="readonly" required/>
					
							
						

						</div>
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Total Lift period (Days)</label>
							</div>
							<div class="col-md-6" > <input
								type="text" class="form-control" 
								id="liftperiod" name="liftperiod" placeholder="ex:120"  value="${editcompObj.liftperiod}"  readonly="readonly" required/>
					
							
						

						</div>
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Total Lift (TMC)</label> 
							</div>
							
							<div class="col-md-6" ><input
								type="text" class="form-control" 
								id="lifttmc" name="lifttmc"  placeholder="ex:24"  value="${editcompObj.lifttmc}"  readonly="readonly" required/>
					
							
						

						</div>
						
						
						 <div class="row show-grid ">
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Total Power of each motor/pump(MW)</label> 
							</div>
							
							<div class="col-md-5" ><input
								type="text" class="form-control" 
								id="eachmotorPower" name="eachmotorPower" placeholder="ex:24"  value="${editcompObj.eachmotorPower}"  readonly="readonly" required/>
					
							
						

						</div>
						</div>
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Total Power(MW)</label> 
							</div>
							
							<div class="col-md-5" ><input
								type="text" class="form-control" 
								id="totalpower" name="totalpower"  placeholder="ex:23.4"  value="${editcompObj.totalpower}"  readonly="readonly" required/>
					
							
						

						</div>
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Auxilary power(MW)</label>
							</div>
							
							<div class="col-md-6" > <input
								type="text" class="form-control" 
								id="auxPower" name="auxPower" placeholder="ex:23.4"  value="${editcompObj.auxPower}"  readonly="readonly" required/>
					
							
						

						</div>
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Total Power with Auxilary(MW)</label> 
							</div>
							
							<div class="col-md-6" ><input
								type="text" class="form-control" 
								id="totalpowerwithAux" name="totalpowerwithAux"  placeholder="ex:23.4"  value="${editcompObj.totalpowerwithAux}"  readonly="readonly" required />
					
							
						

						</div>
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Sub Station Capacity(Volts)</label> 
							
							</div>
							
							<div class="col-md-2" >
							<input
								type="text" class="form-control" 
								id="substationHV" name="substationHV" placeholder="ex:1300"  value="${editcompObj.substationHV}"  readonly="readonly" />
								</div>
								<div class="col-md-2" >
								
								<input
								type="text" class="form-control" 
								id="substationdivision" name="substationdivision"  value="/"  readonly="readonly"/>
								</div>
								<div class="col-md-2" >
								
								<input
								type="text" class="form-control" 
								id="substationLV" name="substationLV"  placeholder="ex:440"   value="${editcompObj.substationLV}"  readonly="readonly" />
					
							
						

						</div>
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">MDDL(mts)</label>
							</div> 
							<div class="col-md-3" >
							<select class="form-control" id="liftStaticsign" name="liftStaticsign"
								 >
								 

								 <option value="0">--select--</option>
								 <c:choose>
								 <c:when test="${selctedmdlsign==1 }">
								 <option value="1" selected="selected">+</option>
								 </c:when>
								 <c:otherwise>
								 <option value="1">+</option>
								 </c:otherwise>
								 </c:choose>
								  <c:choose>
								 <c:when test="${selctedmdlsign==2 }">
								 <option value="2">-</option>
								 </c:when>
								  <c:otherwise>
								 <option value="2">-</option>
								 </c:otherwise>
								 </c:choose>
								
 

							</select>
							</div>
							
								<div class="col-md-3" >
							
							<input
								type="text" class="form-control" 
								id="mddl" name="mddl"  placeholder="ex:34"  value="${editcompObj.mddl}"  readonly="readonly"  />
					
							
						

						</div>
						
						<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Delivery Level(M)</label> 
							</div>
							<div class="col-md-3" >
							
							<select class="form-control" id="liftDynamicsign" name="liftDynamicsign"
								>

								 <option value="0">--select--</option>
								 <c:choose>
								 <c:when test="${selcteddelsign==1}">
								 <option value="1" selected="selected">+</option>
								 </c:when>
								 <c:otherwise>
								  <option value="1">+</option>
								  </c:otherwise>
								 </c:choose>
								  <c:choose>
								  <c:when test="${selcteddelsign==1}">
								 <option value="2" selected="selected">-</option>
								 </c:when>
								 <c:otherwise>
								  <option value="2">-</option>
								 </c:otherwise>
								 </c:choose>
								
 

							</select>
							</div>
							<div class="col-md-3" >
							<input
								type="text" class="form-control" 
								id="deliveryLevel" name="deliveryLevel"  placeholder="ex:23.4"  value="${editcompObj.deliveryLevel}"  readonly="readonly"  />
					
							
						

						</div>
						
							<div class="col-md-6" id="component">
							

							<label class="label-control rowlebel ">Status</label>
							</div>
							
							<div class="col-md-6" >
							<select class="form-control" id="statusId" name="statusId"
								required>

								 <option value="0">--select--</option>
								 <c:choose>
								 <c:when test="${selectedstatus==1}">
								 <option value="1" selected="selected">Commissioned </option>
								 </c:when>
								 <c:otherwise>
								 <option value="1">Commissioned </option>
								 </c:otherwise>
								 </c:choose>
								  <c:choose>
								 <c:when test="${selectedstatus==2}">
								 <option value="2" selected="selected">Not Commissioned</option>
								 </c:when>
								 <c:otherwise>
								 <option value="2">Not Commissioned</option>
								 </c:otherwise>
								 </c:choose>
								 <c:choose>
								  <c:when test="${selectedstatus==3 }">
								  <option value="3" selected="selected">In Progress</option>
								  </c:when>
								  <c:otherwise>
								 <option value="3">In Progress</option>
								 </c:otherwise>
								 </c:choose>
								 <c:choose>
								   <c:when test="${selectedstatus==4}">
								   <option value="4" selected="selected">Not Tackled</option>
								   </c:when>
								    <c:otherwise>
								 <option value="4">Not Tackled</option>
								 </c:otherwise>
								  </c:choose>
								
 

							</select>
					
							
						

						</div>
						
						
					
						
						
						
    
    
    
    </div>
   
    <div class="col-sm-12">
     <div class="col-md-4">
							<label class="label-control rowlebel ">Remarks</label>
							</div>
							
							<div class="col-md-8" ><textarea
							 class="form-control"   
								id="remarks"  name="remarks"   readonly="readonly">${editcompObj.remarks}</textarea>
						</div>
						</div>
					
    
    <div class="row show-grid ">
                       <div class="col-md-4 ">
							<label class="label-control rowlebel "></label><input
								type="button" class="btn btn-1 btn-primary center-block"
								id="editcompbutton" value="Edit" >
						</div>
						
						<div class="col-md-4 "></div>
						 <div class="col-md-4 ">
							<label class="label-control rowlebel "></label><input
								type="submit" class="btn btn-1 btn-primary center-block"
								id="submitcomp" value="Submit" >
						</div>
						</div>
  </div>



			</div>
			</c:if> 
			</form:form>
			
			<form:form id="cancelcompform" method="post" modelAttribute="editcomp"  data-parsley-validate-if-empty=""  >
 <c:if test="${editcompObj!=null}">
<div class="row show-grid">
					<br></br>
					<div class="col-md-5"></div>
					<div class="col-md-2">
					<input type="hidden" class="form-control"  id="componentId" name="componentId" value="<c:out value="${editcompObj.componentId}"></c:out>"/>
					<input type="hidden" class="form-control"  id="editFlag" name="editFlag" value="false" />
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="caseeditId" value="Cancel Edit" >
					</div>
					<div class="col-md-5"></div>
					
					</div>	
 
 </c:if>
 </form:form>

		</div>
		







	 
</div>
<!-- //main-content -->
 <script type="text/javascript" src="../js/parsley.js"></script>

    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#editcompform').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
        
             
			
		    
		  })
		  
		  
		  .on('form:submit', function() {
			 
			  var editflag=$("#editFlag").val();
				
				//alert("kal"+editflag);
				
			  
			  if(editflag=="false"){
					
					alert("please click on Edit button before submit");
					
				}
		
				if(editflag=="true"){	
			  document.forms.editcompform.action="../comptsimis/editComp";
				 document.forms.editcompform.submit(); 
		
				}
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
			
		
});
</script>

 <script type="text/javascript" class="example">
$(function () {
	 $('#cancelcompform').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  
			 
				
			  document.forms.cancelcompform.action="../comptsimis/editComp";
				 document.forms.cancelcompform.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

 