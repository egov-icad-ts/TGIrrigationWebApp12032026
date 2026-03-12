
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

var newrowCount = 100;
function addMotorRows(frm) {
	
	
	newrowCount++;
	var newrecRow = ' <div class="row show-grid" id="newrowCount'+newrowCount+'"><div class="col-md-6"><label class="label-control rowlebel ">Enter No Of Motors*</label> </div> <div class="col-md-6"> <input	type="text" class="form-control" 	id="motorList['+newrowCount+'].motorNumber" name="motorList['+newrowCount+'].motorNumber" placeholder="no of motors"  required/> </div>'
			+ '<div class="col-md-6"><label class="label-control rowlebel ">Connected Load on Motors*</label> </div><div class="col-md-6"> <input type="text" class="form-control"  id="motorList['+newrowCount+'].motorconnectedLoad" name="motorList['+newrowCount+'].motorconnectedLoad" placeholder="load in mW"  required/> </div>'
			+ '<div class="col-md-6"><label class="label-control rowlebel ">Actual Load on Motors*</label> </div><div class="col-md-6"> <input type="text" class="form-control"  id="motorList['+newrowCount+'].motoractualLoad" name="motorList['+newrowCount+'].motoractualLoad" placeholder="load in mW"  required/> </div>'
			+ '<div class="col-md-6"><label class="label-control rowlebel ">Motor RPM*</label> </div><div class="col-md-6"> <input type="text" class="form-control"  id="motorList['+newrowCount+'].motorrpm" name="motorList['+newrowCount+'].motorrpm" placeholder="Ex:500"  required/> </div>'
			+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Motor Make*</label></div><div class="col-md-6"><select class="form-control" id="motorList['+newrowCount+'].motormakeId" name="motorList['+newrowCount+'].motormakeId"   required> <option value="0">--select--</option> <c:forEach items="${motormake}" var="p"> <option value="${p.motormakeId}">${p.motormakeName}</option> </c:forEach> </select></div>'
			+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Motor Type*</label></div><div class="col-md-6"><select class="form-control" id="motorList['+newrowCount+'].motortypeId" name="motorList['+newrowCount+'].motortypeId"  required> <option value="0">--select--</option> <c:forEach items="${motortype}" var="p"> <option value="${p.motortypeId}">${p.motortypeName}</option> </c:forEach> </select> </div>'
			+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Motor Capacity</label></div><div class="col-md-6"><select class="form-control" id="motorList['+newrowCount+'].motorcapacityId" name="motorList['+newrowCount+'].motorcapacityId"  required> <option value="0">--select--</option> <c:forEach items="${pumpCapacity}" var="p"><option value="${p.pumpcapacityId}">${p.pumpCapacityName}</option></c:forEach> </select> </div>'
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
	
	var recRow = '<div class="row show-grid" id="rowCount'+rowCount+'"><div class="col-md-6"><label class="label-control rowlebel ">Enter No Of Pumps*</label></div><div class="col-md-6"> <input	type="text" class="form-control" 	id="pumpList['+rowCount+'].pumpNumber" name="pumpList['+rowCount+'].pumpNumber" placeholder="no of pumps"  required/> </div>'
	+ '<div class="col-md-6"><label class="label-control rowlebel ">Connected Load on pumps*</label></div><div class="col-md-6"> <input type="text" class="form-control"  id="pumpList['+rowCount+'].pumpconnectedLoad" name="pumpList['+rowCount+'].pumpconnectedLoad" placeholder="load in mW"  required/> </div>'
	+ '<div class="col-md-6"><label class="label-control rowlebel ">Actual Load on pumps*</label></div><div class="col-md-6"> <input type="text" class="form-control"  id="pumpList['+rowCount+'].pumpactualLoad" name="pumpList['+rowCount+'].pumpactualLoad" placeholder="load in mW"  required/> </div>'
	+ '<div class="col-md-6"><label class="label-control rowlebel ">Pump RPM*</label></div><div class="col-md-6"> <input type="text" class="form-control"  id="pumpList['+rowCount+'].pumprpm" name="pumpList['+rowCount+'].pumprpm" placeholder="Ex:500"  required/> </div>'
	+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Pump Make*</label></div><div class="col-md-6"><select class="form-control" id="pumpList['+rowCount+'].pumpmakeId" name="pumpList['+rowCount+'].pumpmakeId"  required> <option value="0">--select--</option> <c:forEach items="${pumpmake}" var="p"> <option value="${p.pumpmakeId}">${p.pumpmakename}</option></c:forEach> </select>  </select></div>'
	+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Pump Type*</label></div><div class="col-md-6"><select class="form-control" id="pumpList['+rowCount+'].pumptypeId" name="pumpList['+rowCount+'].pumptypeId" required> <option value="0">--select--</option> <c:forEach items="${pumptype}" var="p"> <option value="${p.pumptypeId}">${p.pumptype}</option> </c:forEach> </select> </div>'
	+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Pump Capacity</label></div><div class="col-md-6"><select class="form-control" id="pumpList['+rowCount+'].pumpcapacityId" name="pumpList['+rowCount+'].pumpcapacityId"  required> <option value="0">--select--</option>  <c:forEach items="${pumpCapacity}" var="p"><option value="${p.pumpcapacityId}">${p.pumpCapacityName}</option></c:forEach> </select> </div>'
	+ '<div class="col-md-6"><label class="label-controlPMS rowlebel ">Select Pump Status</label></div><div class="col-md-6"><select class="form-control" id="pumpList['+rowCount+'].pumpstatusId" name="pumpList['+rowCount+'].pumpstatusId"  required> <option value="0">--select--</option> <option value="1">Service</option> <option value="2">Execution</option> </select> </div>'
	+ '<div class="col-md-6"></div><div class="col-md-6"><input type="button" class="btn btn-1 btn-danger center-block"	id="deleteloadpump" value="Delete Pump" onclick="removeRow('+ rowCount + ')" ></div></div>';
	
jQuery('#addedPumpRows').append(recRow);
	
}

function removeRow(removeNum) {
	jQuery('#rowCount' + removeNum).remove();
}
	
</script>


<script>
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
	  				
	  			var selectedComp=$('#hiddencompId').val();
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#componentId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						//alert("selectedComp"+selectedComp);
	  						
	  					if(selectedComp==value.componentId){	
	  						
	  					$('#componentId').append( '<option value="'+value.componentId+'" selected="selected"> '+value.componentName+'</option>' );
	  					}
	  					if(selectedComp==null||selectedComp!=value.componentId){
	  						$('#componentId').append( '<option value="'+value.componentId+'"> '+value.componentName+'</option>' );	
	  						
	  					}
	  					
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
	
function getcompParent(k){
	
	 
    var   componentId=k;
    	//$('#componentId').val();
      
  // alert("kal"+componentId);
	$('#parentComponentId').multiselect('rebuild');
	
	  //alert("kal2");

	$.ajax({	          
	      url: "../comptsimis/getParentComp?componentId="+componentId,
	      type: "GET",
	      success: function (response) {
	    	 // alert("res"+response)
	    	  var $select = $('#parentComponentId');
	  				$select.find('option').remove();
	  				
	  			var selectedparent=$('#hiddencompParentId').val()
	  					
	  					var obj = JSON.parse(response);
	  					
	  		//	alert(selectedparent+"kal");
	  				$('#parentComponentId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  					if(selectedparent==value.componentId && value.componentId==-1){
	  				
	  					$('#parentComponentId').append( '<option value="'+value.componentId+'" selected="selected"> No parent </option>' );
	  					
	  					}
	  					
	  					if(selectedparent==null && value.componentId==-1){
	  		  				
		  					$('#parentComponentId').append( '<option value="'+value.componentId+'"> No parent </option>' );
		  					
		  					}
	  					if(selectedparent== value.componentId  && value.componentId!=-1){
	  						
	  						$('#parentComponentId').append( '<option value="'+value.componentId+'" selected="selected">'+value.componentName+'</option>' );	
	  						
	  					}
	  					
                         if(selectedparent==null  && value.componentId!=-1){
	  						
	  						$('#parentComponentId').append( '<option value="'+value.componentId+'" >'+value.componentName+'</option>' );	
	  						
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


function getcompPackage(k){
	
	 
    var   componentId=k
    	//$('#componentId').val();
      
   // alert("kal"+componentId);
	$('#compPackId').multiselect('rebuild');
	
	 // alert("kal2");

	$.ajax({	          
	      url: "../comptsimis/getCompPackage?componentId="+componentId,
	      type: "GET",
	      success: function (response) {
	    	  //alert("res"+response)
	    	  var $select = $('#compPackId');
	  				$select.find('option').remove();
	  				
	  			     
	  					var selectedPack=$('#hiddenPackId').val()
	  					var obj = JSON.parse(response);
	  					
	  				$('#compPackId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						if(value.pkgId==selectedPack){
	  						
	  					$('#compPackId').append( '<option value="'+value.pkgId+'" selected="selected"> '+value.pkgName+'</option>' );
	  						}
	  						if(selectedPack==null ||value.pkgId!=selectedPack ){
		  						
	  		  					$('#compPackId').append( '<option value="'+value.pkgId+'"> '+value.pkgName+'</option>' );
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
	
	

</script>



<script>

  
	$(document).ready(function() {
		
		 
		$('#projectId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});

		
		$('#componentId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		$('#compPackId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		$('#parentComponentId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});

	});

	$(function() {
		
		
	
		
		var myproj= parseInt($("#projectId").val()); 
		//alert("m"+myproj);
		var m=myproj;
		if(m!=null && m>0){
			//alert(myproj+"myproj");
			getParents();
		
		}
		
		var mcomp= parseInt($("#hiddencompId").val()); 
		//alert("m"+myproj);
		var n=mcomp;
		if(n!=null && n>0){
			//alert(myproj+"myproj");
			getcompParent(n);
			getcompPackage(n);
		
		}
		
		
		

		$("#editcompbutton").click(function(){
			
			
			 $("#remarks").attr("readonly", false);
			 $("#financialyear").attr("readonly", false);
			 $("#annualpowerconsumption").attr("readonly", false);
			 $("#ayacutacres").attr("readonly", false);
			 
			 
			 
			 
			
			 $("#editFlag").val(true);
			 
			 
		}); 
		
		

		
		

	});
	
	
	 
</script>
<script>
    window.onunload = refreshParent;
    function refreshParent() {
    	
       window.opener.location.reload(true);
        self.close();
    }
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


	<!-- <div class="col-md-12 agile_banner_bottom_grids">
		<div
			style="display: block; width: 100%; margin-left: 10px; margin-right: 10px;">

			<div class="resp-tabs-container">
				<div
					class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active"
					style="display: block">

 -->




					


					<div class="page">



					


						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Edit Component Input</h3>
							</div>
							<form:form id="compinputform" method="post" modelAttribute="editcompinput"
								data-parsley-validate-if-empty="">
								<c:if test="${editcomppowerayacut!=null}">
								
				<input name=componentPowerAyacutId  id="componentPowerAyacutId" type=hidden  value="${editcomppowerayacut.componentPowerAyacutId }">
				<input name=editFlag  id="editFlag" type=hidden  value="false">
				<input name=hiddenPackId  id="hiddenPackId" type=hidden  value="${selectedPackId }">
				<input name=hiddencompParentId  id="hiddencompParentId" type=hidden  value="${selectedParentComp }">
				<input name=hiddencompId  id="hiddencompId" type=hidden  value="${selectedCompId }">
				
				  
				  
								
								<div class='container'>




									<div class="row col-md-12 toppad ">


                                    <!--    <div class="row show-grid">
                                       
                                       	<div class="alert alert-primary" role="alert">
										<strong>Note: Considering 375 rs kVA/month,if change in price mail to admin</strong>
										
										
										
										
									</div>
                                       
                                       </div> -->

                                       <div class="col-sm-6">
										


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Project</label> 
													</div>
													
													<div class="col-md-6">
													
													
													<select class="form-control" id="projectId"
													name="projectId" onchange="getParents()">
													
													 <c:forEach items="${newprList}" var="u">
													 <c:choose>
													 <c:when  test="${u.projectId==selectedprojId}" >
													
									              <option value="${u.projectId}" selected="selected">${u.projectName}</option>
									              </c:when>
									              <c:otherwise>
									              
									              <option value="${u.projectId}" >${u.projectName}</option>
									              </c:otherwise>
									             
									              </c:choose>

								</c:forEach>
 
												</select>
											</div>






											<div class="col-md-6" >
												<label class="label-control rowlebel ">Select
													Component*</label> 
													
													</div>
													<div class="col-md-6">
													
													<select class="form-control" id="componentId"
													name="componentId" onchange="getcompParent(this.value),getcompPackage(this.value)" required>
													<option value="0">--select--</option>


												</select>




											</div>

											<div class="col-md-6">

												<label class="label-control rowlebel ">Package</label> 
													
												</div>	
												<div class="col-md-6">	
													<select class="form-control" id="compPackId" name="compPackId"  required>
														
												</select>


											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Parent Component</label> 
												</div>
												
												<div class="col-md-6">
												
												<select class="form-control" id="parentComponentId"
													name="parentComponentId"  
													required>
													

												</select>
												
											</div>
											
											
											
											
											
										
											</div>
											<div class="col-sm-6">
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Stage</label> 
												</div>
												
												<div class="col-md-6">
												
												<select class="form-control" id="stageId"
													name="stageId" 
													required>
													 <c:forEach items="${stageList}" var="u">
													 <c:choose>
													 <c:when  test="${u.stageId==selectedStage}" >
													
									              <option value="${u.stageId}" selected="selected">${u.stageName}</option>
									              </c:when>
									              <c:otherwise>
									              
									              <option value="${u.stageId}" >${u.stageName}</option>
									              </c:otherwise>
									             
									              </c:choose>

								</c:forEach>
 


												</select>
											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Phase</label>
													</div>
													
													<div class="col-md-6"> 
													
													<select class="form-control" id="phaseId"
													name="phaseId" 
													required>
													 <c:forEach items="${phaseList}" var="u">
													 <c:choose>
													 <c:when  test="${u.phaseId==selectedPhase}" >
													
									              <option value="${u.phaseId}" selected="selected">${u.phaseName}</option>
									              </c:when>
									              <c:otherwise>
									              
									              <option value="${u.phaseId}" >${u.phaseName}</option>
									              </c:otherwise>
									             
									              </c:choose>

								</c:forEach>



												</select>

											</div>
											
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">Financial Year</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="financialyear" name="financialyear" value="${editcomppowerayacut.financialyear}" readonly="readonly" 
													 />
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Annual Power Consumption
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control" value="${editcomppowerayacut.annualpowerconsumption}"
													id="annualpowerconsumption" name="annualpowerconsumption" readonly="readonly" 
													 />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Ayacut in Acres 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control" value="${editcomppowerayacut.ayacutacres}"
													id="ayacutacres" name="ayacutacres" readonly="readonly"
													 />
											</div>
											
											
											
											

											
											
											
											
											
											
								</div>
										



									


										<div class="row show-grid">


											<div class="col-md-12">
												<label class="label-control rowlebel ">Remarks</label>
												<textarea class="form-control" id="remarks" name="remarks"  readonly="readonly">${editcomppowerayacut.remarks }</textarea>
											</div>

										</div>
										
										
										<div class="col-md-12">
										<br></br>
											<div class="row show-grid">

									<div class="col-md-6">

										<div id="addedPumpRows"></div>
									</div>

									<div class="col-md-6">

										<div id="addedMotorRows"></div>
									</div>
									</div>
									</div>


										  
    <div class="row show-grid ">
                       <div class="col-md-4 ">
							<label class="label-control rowlebel "></label><input
								type="button" class="btn btn-1 btn-primary center-block"
								id="editcompbutton" value="Edit" >
						</div>
						
						<div class="col-md-2 ">
						<label class="label-control rowlebel "></label><input
								type="button" class="btn btn-1 btn-primary center-block"
								id="addpumpbutton" value="Add Pumps" onclick="addMoreRows(this.form)" ></div>
						
						<div class="col-md-2 ">
						<label class="label-control rowlebel "></label><input
								type="button" class="btn btn-1 btn-primary center-block"
								id="addmotorbutton" value="Add motors" onclick="addMotorRows(this.form)" ></div>
								
						 <div class="col-md-4 ">
							<label class="label-control rowlebel "></label><input
								type="submit" class="btn btn-1 btn-primary center-block"
								id="submitcomp" value="Submit" >
						</div>
						</div>






									</div>
									<!-- row -->




								</div>
								</c:if>
							</form:form>
							
							<form:form id="cancelcompform" method="post" modelAttribute="editcomp"  data-parsley-validate-if-empty=""  >
 <c:if test="${editcomppowerayacut!=null}">
<div class="row show-grid">
					<br></br>
					<div class="col-md-5"></div>
					<div class="col-md-2">
					<input type="hidden" class="form-control"  id="componentPowerAyacutId" name="componentPowerAyacutId" value="<c:out value="${editcomppowerayacut.componentPowerAyacutId}"></c:out>"/>
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
</div>
<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
	$(function() {
		$('#compinputform').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			// alert('hi');

		})

		.on('form:submit', function() {
			// alert("coming here");

			document.forms.compinputform.action = "../comptsimis/editCompInput";
			document.forms.compinputform.submit();

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
			  
			 
				
			  document.forms.cancelcompform.action="../comptsimis/editCompInput";
				 document.forms.cancelcompform.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

