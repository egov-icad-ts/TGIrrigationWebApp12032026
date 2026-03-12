
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


<script type="text/javascript">

	


	
	
</script>

<script type="text/javascript">

var newrowCount = 100;
function addMotorRows(frm) {
	
	
	newrowCount++;
	var newrecRow = ' <div class="row show-grid" id="newrowCount'+newrowCount+'"><div class="col-md-6"><label class="label-control rowlebel ">Enter Motor Name/Number*</label> </div> <div class="col-md-6"> <input	type="text" class="form-control" 	id="motorList['+newrowCount+'].motorNumber" name="motorList['+newrowCount+'].motorNumber" placeholder="EX:Motor1"  required/> </div>'
			+ '<div class="col-md-6"><label class="label-control rowlebel ">Connected Load on Motor*</label> </div><div class="col-md-6"> <input type="text" class="form-control"  id="motorList['+newrowCount+'].motorconnectedLoad" name="motorList['+newrowCount+'].motorconnectedLoad" placeholder="load in mW"  required/> </div>'
			+ '<div class="col-md-6"><label class="label-control rowlebel ">Actual Load on Motor*</label> </div><div class="col-md-6"> <input type="text" class="form-control"  id="motorList['+newrowCount+'].motoractualLoad" name="motorList['+newrowCount+'].motoractualLoad" placeholder="load in mW"  required/> </div>'
			+ '<div class="col-md-6"><label class="label-control rowlebel ">Motor RPM*</label> </div><div class="col-md-6"> <input type="text" class="form-control"  id="motorList['+newrowCount+'].motorrpm" name="motorList['+newrowCount+'].motorrpm" placeholder="Ex:500"  required/> </div>'
			+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Motor Make*</label></div><div class="col-md-6"><select class="form-control" id="motorList['+newrowCount+'].motormakeId" name="motorList['+newrowCount+'].motormakeId"   required> <option value="0">--select--</option> <c:forEach items="${motormake}" var="p"> <option value="${p.motormakeId}">${p.motormakeName}</option> </c:forEach> </select></div>'
			+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Motor Type*</label></div><div class="col-md-6"><select class="form-control" id="motorList['+newrowCount+'].motortypeId" name="motorList['+newrowCount+'].motortypeId"  required> <option value="0">--select--</option> <c:forEach items="${motortype}" var="p"> <option value="${p.motortypeId}">${p.motortypeName}</option> </c:forEach> </select> </div>'
			+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Motor Capacity</label></div><div class="col-md-6"><select class="form-control" id="motorList['+newrowCount+'].motorcapacityId" name="motorList['+newrowCount+'].motorcapacityId"  required> <option value="0">--select--</option> <option value="1">Small</option> <option value="2">Medium</option> <option value="3">Major</option> </select> </div>'
			+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Motor Status</label></div><div class="col-md-6"><select class="form-control" id="motorList['+newrowCount+'].motorstatusId" name="motorList['+newrowCount+'].motorstatusId" required> <option value="0">--select--</option> <option value="1">Service</option> <option value="2">Execution</option> </select> </div>'
			+ '<div class="col-md-6"></div><div class="col-md-6"><input type="button" class="btn btn-1 btn-danger center-block"	id="deleteloadmotor" value="Delete Motor" onclick="newremoveRow('+ newrowCount + ')" ></div></div>';
	jQuery('#addedMotorRows').append(newrecRow);
}

function newremoveRow(removeNum) {
	jQuery('#newrowCount' + removeNum).remove();
}

//alert("kal1");
var rowCount = 0

function addMoreRows(frm) {
	//alert("kal2");
	
	
	rowCount++;
	
	var recRow = '<div class="row show-grid" id="rowCount'+rowCount+'"><div class="col-md-6"><label class="label-control rowlebel ">Enter Pump Name/Number*</label></div><div class="col-md-6"> <input	type="text" class="form-control" 	id="pumpList['+rowCount+'].pumpNumber" name="pumpList['+rowCount+'].pumpNumber" placeholder="Ex:Pump1"  required/> </div>'
	+ '<div class="col-md-6"><label class="label-control rowlebel ">Connected Load on pumps*</label></div><div class="col-md-6"> <input type="text" class="form-control"  id="pumpList['+rowCount+'].pumpconnectedLoad" name="pumpList['+rowCount+'].pumpconnectedLoad" placeholder="load in mW"  required/> </div>'
	+ '<div class="col-md-6"><label class="label-control rowlebel ">Actual Load on pumps*</label></div><div class="col-md-6"> <input type="text" class="form-control"  id="pumpList['+rowCount+'].pumpactualLoad" name="pumpList['+rowCount+'].pumpactualLoad" placeholder="load in mW"  required/> </div>'
	+ '<div class="col-md-6"><label class="label-control rowlebel ">Pump RPM*</label></div><div class="col-md-6"> <input type="text" class="form-control"  id="pumpList['+rowCount+'].pumprpm" name="pumpList['+rowCount+'].pumprpm" placeholder="Ex:500"  required/> </div>'
	+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Pump Make*</label></div><div class="col-md-6"><select class="form-control" id="pumpList['+rowCount+'].pumpmakeId" name="pumpList['+rowCount+'].pumpmakeId"  required> <option value="0">--select--</option> <c:forEach items="${pumpmake}" var="p"> <option value="${p.pumpmakeId}">${p.pumpmakename}</option></c:forEach> </select>  </select></div>'
	+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Pump Type*</label></div><div class="col-md-6"><select class="form-control" id="pumpList['+rowCount+'].pumptypeId" name="pumpList['+rowCount+'].pumptypeId" required> <option value="0">--select--</option> <c:forEach items="${pumptype}" var="p"> <option value="${p.pumptypeId}">${p.pumptype}</option> </c:forEach> </select> </div>'
	+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Pump Capacity</label></div><div class="col-md-6"><select class="form-control" id="pumpList['+rowCount+'].pumpcapacityId" name="pumpList['+rowCount+'].pumpcapacityId"  required> <option value="0">--select--</option> <option value="1">small</option> <option value="2">Medium</option> <option value="3">Major</option> </select> </div>'
	+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Pump Status</label></div><div class="col-md-6"><select class="form-control" id="pumpList['+rowCount+'].pumpstatusId" name="pumpList['+rowCount+'].pumpstatusId"  required> <option value="0">--select--</option> <option value="1">Service</option> <option value="2">Execution</option> </select> </div>'
	+ '<div class="col-md-6"></div><div class="col-md-6"><input type="button" class="btn btn-1 btn-danger center-block"	id="deleteloadpump" value="Delete Pump" onclick="removeRow('+ rowCount + ')" ></div></div>';
	
jQuery('#addedPumpRows').append(recRow);
	
}

function removeRow(removeNum) {
	jQuery('#rowCount' + removeNum).remove();
}
	
</script>



<script type="text/javascript">

$(document).ready(function(){
	
	
		 
	$('#projectId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#compPackId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#componentId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#stageId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#phaseId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	



	$('#parentComponentId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	

	}); 



function getcompParent(){
	
	 
    var   componentId=$('#componentId').val();
      
   // alert("kal"+projectId);
	$('#parentComponentId').multiselect('rebuild');
	
	//  alert("kal2");

	$.ajax({	          
	      url: "../comptsimis/getParentComp?componentId="+componentId,
	      type: "GET",
	      success: function (response) {
	    	//  alert("res"+response)
	    	  var $select = $('#parentComponentId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#parentComponentId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						
	  					if(value.componentId==-1){
	  					$('#parentComponentId').append( '<option value="'+value.componentId+'"> No parent </option>' );
	  					}
	  					if(value.componentId!=-1){
	  						
	  						$('#parentComponentId').append( '<option value="'+value.componentId+'" selected="selected">'+value.componentName+'</option>' );	
	  						
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


function getcompPackage(){
	
	 
    var   componentId=$('#componentId').val();
      
   // alert("kal"+projectId);
	$('#compPackId').multiselect('rebuild');
	
	 // alert("kal2");

	$.ajax({	          
	      url: "../comptsimis/getCompPackage?componentId="+componentId,
	      type: "GET",
	      success: function (response) {
	    	//  alert("res"+response)
	    	  var $select = $('#compPackId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#compPackId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						if(value.pkgId){
	  						
	  					$('#compPackId').append( '<option value="'+value.pkgId+'" selected="selected"> '+value.pkgName+'</option>' );
	  						}
	  					
	  				$('#compPackId').multiselect('rebuild')
	  				
	  				
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
function getParents(){
	
	 
    var   projectId=$('#projectId').val();
      
  //  alert("kal"+projectId);
	$("#componentId").multiselect('rebuild');
	
	//  alert("kal2");

	$.ajax({	          
	      url: "../comptsimis/getparent?projectId="+projectId,
	      type: "GET",
	      success: function (response) {
	    	  //alert("res"+response)
	    	  var $select = $('#componentId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#componentId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						
	  						
	  					$('#componentId').append( '<option value="'+value.componentId+'"> '+value.componentName+'</option>' );
	  					
	  				$('#componentId').multiselect('rebuild')
	  				
	  				
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
	
</script>




<script>
	

	

	$(function() {

		$("#addCF")
				.click(
						function() {

						//	alert("kal");

							var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
							var url = "../comptsimis/addcomp";

							popup = window.open(url, "_blank", features);

						});

	});
	
	
	

</script>



	<c:if test="${userObj!=null}">
						<div class="row-fluid  ">

							<div class="span6 pull-right">
								<p class="rowBlue">
									<c:out value="${userObj.employeeName}"></c:out>
								</p>
							</div>
						</div>
					</c:if>
						<c:if test="${msg!=null || err!=null }">


							<div class="row show-grid">
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

<div class="w3_agile_main_left">


	<!-- <div class="col-md-12 agile_banner_bottom_grids">
		<div
			style="display: block; width: 100%; margin-left: 10px; margin-right: 10px;">

			<div class="resp-tabs-container">
				<div
					class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active"
					style="display: block"> -->






				


					<!-- <div class="page">
 -->


					




						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Component Input</h3>
							</div>
							<form:form id="compinput" method="post" modelAttribute="Compin" class="stepform"
								data-parsley-validate-if-empty="">
								


<div class="form-section">

									<div class="row col-md-12 toppad ">



										<div class="col-md-6">




											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Project</label>
											</div>
											<div class="col-md-6">
												<select class="form-control" id="projectId" name="projectId" onchange="getParents()">
												<option value="0">--select--</option>
												 <c:forEach items="${newprList}" var="u">
									              <option value="${u.projectId}">${u.projectName}</option>

								</c:forEach>
 
												
												
												</select>
											</div>

											
											
												<div class="col-md-6">
												<label class="label-control rowlebel ">Select Component*</label>

											</div>
											<div class="col-md-6">
												<select class="form-control" id="componentId" name="componentId" onchange="getcompParent(),getcompPackage()"
													required>
													<option value="0">--select--</option>


												</select>




											</div>
											


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Package</label>
											</div>
											<div class="col-md-6">
												<select class="form-control" id="compPackId" name="compPackId">




												</select>


											</div>
											
												<div class="col-md-6">
												<label class="label-control rowlebel ">Select Parent
													Component*</label>
											</div>

											<div class="col-md-3">
												<select class="form-control" id="parentComponentId" name="parentComponentId"
													required>
													<option value="0">--select--</option>
													<option value="-1">--noparent--</option>


												</select>




											</div>
												<div class="col-md-3">
											<label class="label-control rowlebel "></label> <a
												href="javascript:void(0);" id="addCF"><input
												type="button" class="btn btn-1 btn-primary center-block"
												id="addComponent" value="Add Component"></a>
										</div>


										







										</div>

										<div class="col-md-6">
										
										<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Stage</label>
											</div>
											<div class="col-md-6">
												<select class="form-control" id="stageId" name="stageId">
													<option value="0">--select--</option>
														<option value="1">Stage1</option>
															<option value="2">Stage2</option>
															<option value="3">Stage3</option>
															<option value="4">Stage4</option>
												</select>
											</div>
											
											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Phase</label>
											</div>
											<div class="col-md-6">
												<select class="form-control" id="phaseId" name="phaseId">
													<option value="0">--select--</option>
														<option value="1">Phase1</option>
															<option value="2">Phase2</option>
															<option value="3">Phase3</option>
															<option value="4">Phase4</option>
												</select>
											</div>

										
<div class="row show-grid">
											<div class="col-md-6">
											

												<label class="label-control rowlebel ">Annual power Consumption* (March to February)</label>
											
											</div>
											<div class="col-md-6">
												<input type="text" class="form-control" id="annualpowerconsumption"
													name="annualpowerconsumption" placeholder="load in mW"  />
											</div>
												</div>
<div class="row show-grid">
											<div class="col-md-6">

												<label class="label-control rowlebel ">Ayacut in Acres*(March to February)</label>
											</div>
											<div class="col-md-6">
												<input type="text" class="form-control" id="ayacutacres"
													name="ayacutacres" placeholder="acres"  />
											</div>
											</div>
											<div class="col-md-6">

												<label class="label-control rowlebel ">Enter Financial Year</label>
											</div>
											<div class="col-md-6">
												<input type="text" class="form-control" id="financialyear"
													name="financialyear" placeholder="Ex:2017-18"  />
											</div>
										</div>
											<div class="col-md-12">


										<div class="col-md-2">
											<label class="label-control rowlebel ">Remarks</label>
										</div>
										<div class="col-md-8">
											<textarea class="form-control" id="remarks" name="remarks"></textarea>
										</div>

									</div>

									</div>
									</div>
									<div class="form-section">
									
									

									<div class="col-md-12">

										<div class="col-md-6">
											<label class="label-control rowlebel "></label><input
												type="button" class="btn btn-1 btn-primary center-block"
												id="addloadpump" value="Add pump "
												onclick="addMoreRows(this.form)">
										</div>

									


										<div class="col-md-6">
											<label class="label-control rowlebel "></label><input
												type="button" class="btn btn-1 btn-primary center-block"
												id="addloadmotor" value="Add motor"
												onclick="addMotorRows(this.form)">

										</div>
									</div>

									<div class="col-md-12"></div>

									<div class="col-md-6">

										<div id="addedPumpRows"></div>
									</div>

									<div class="col-md-6">

										<div id="addedMotorRows"></div>
									</div>

</div>




<div class="form-navigation">


    <button type="button" class="previous btn btn-primary pull-left">&lt; Previous</button>
    <button type="button" class="next btn btn-primary pull-right">Next &gt;</button>
    <input class="btn btn-primary pull-right"  value ="Submit" type="submit">
   
    <span class="clearfix"></span>
  </div>
  

								





								



							</form:form>

						</div>
					






</div>
<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
	$(function() {
		
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
		
		
		$('#compinput').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			// alert('hi');

		})

		.on('form:submit', function() {
			// alert("coming here");

			document.forms.compinput.action = "../comptsimis/compinput";
			document.forms.compinput.submit();

			// Don't submit form for this demo
		});
	});
</script>

