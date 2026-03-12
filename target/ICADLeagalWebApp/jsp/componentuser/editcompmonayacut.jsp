
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
	  				
	  				var selectedProj=$('#selectedProjectId').val();
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#projectId').append( '<option value=" "> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						if(selectedProj==value.projectId){	
	  						
	  					$('#projectId').append( '<option value="'+value.projectId+'" selected="selected"> '+value.projectName+'</option>' );
	  					
	  						}
	  						
	  						if(selectedProj==null||selectedProj!=value.projectId){
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

function getParents(projId){
	
	 
    var   projectId=projId;
    	//$('#projectId').val();
      
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
	  				
	  				var selectedCompId=$('#selectedCompId').val();
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#componentId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						if(selectedCompId==value.componentId){	
	  						
	  						
	  					$('#componentId').append( '<option value="'+value.componentId+'" selected="selected"> '+value.componentName+'</option>' );
	  					
}
	  						
	  						if(selectedCompId==null||selectedCompId!=value.componentId){
	  						
	  							$('#componentId').append( '<option value="'+value.componentId+'"> '+value.componentName+'</option>' );
	  							
	  						}
	  					
	  				$('#componentId').multiselect('rebuild');
	  				
	  				
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
			
			  var selectedMandal=$('#selectedMandalId').val();
			 
			  $('#mandalId').append( '<option value="0"> --select--</option>' );
					var obj = JSON.parse(response);
					$.each(obj, function(key, value) {
						
						if(selectedMandal==value.mandalId){
							$('#mandalId').append( '<option value="'+value.mandalId+'" selected="selected" > '+value.mandalName+'</option>' );
						}
						
						if(selectedMandal==null || selectedMandal!=value.mandalId){
							$('#mandalId').append( '<option value="'+value.mandalId+'"  > '+value.mandalName+'</option>' );
						}
		  					
	  	  				$('#mandalId').multiselect('rebuild');
					});

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 

	function getVillages(k){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var mandalId=k;
			//document.getElementById("mandalId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getVillages?mandalId="+mandalId,
	      type: "GET",
	      success: function (response) {
	    	
	    	 
	    	
	    	  var $select = $('#villageId');
	    	 
			  $select.find('option').remove();
			  
			  var selectedVillage=$('#hiddenVillageId').val();
			
			 
					var obj = JSON.parse(response);
					  $('#villageId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(selectedVillage==value.villageId){
						
							$('#villageId').append( '<option value="'+value.villageId+'" selected=="selected"> '+value.villageName+'</option>' );
						}
						if(selectedVillage==null||selectedVillage!=value.villageId){
							
							$('#villageId').append( '<option value="'+value.villageId+'" > '+value.villageName+'</option>' );
						}
					
	  	  				$('#villageId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getConstituencies(olddistrictId){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var olddistrictId=olddistrictId;
			//document.getElementById("mandalId").value;
	//	alert("olddistrictId"+olddistrictId);
	
		  $.ajax({	          
	      url: "../comptsimis/getConstolddistList?districtId="+olddistrictId,
	      type: "GET",
	      success: function (response) {
	    	//alert("response"+response);
	    	
	    	
	    	  var $select = $('#constId');
	    	 
			  $select.find('option').remove();
			  
			  var selectedConstId=$('#selectedConstId').val();
			
			 
					var obj = JSON.parse(response);
					  $('#constId').append( '<option value=" "> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(selectedConstId==value.constId){	
						
							$('#constId').append( '<option value="'+value.constId+'" selected="selected" > '+value.constName+'</option>' );
						}
						
						if(selectedConstId==null||selectedConstId!=value.constId){
							$('#constId').append( '<option value="'+value.constId+'" > '+value.constName+'</option>' );
						
						}
					
	  	  				$('#constId').multiselect('rebuild');
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
		
		$('#unitId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		$('#constId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		$('#oldDistrictId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		
		
		 
		$('#projectId').multiselect({
			 
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

		
		$('#componentId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});

	});

	$(function() {
		
		
		$("#presentAyacutmonth").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		
		
		 var myunit= parseInt($("#unitId").val()); 
			//alert("m"+myunit);
			var a=myunit;
			if(a!=null && a>0){
				//alert(myunit+"myunit");
				getProjects();
			
			}
			 var myproj= parseInt($("#selectedProjectId").val()); 
			//alert("m"+myproj);
			var e=myproj;
			if(e!=null && e>0){
				//alert(myproj+"myproj");
				getParents(e);
			
			}
			 
			var mdistrict= parseInt($("#districtId").val()); 
			//alert("b"+mdistrict);
			var b=mdistrict;
			if(b!=null && b>0){
				//alert(myproj+"myproj");
				getMandals(b);
				
			
			}
			
			var mmandal= parseInt($("#selectedMandalId").val()); 
			//alert("c"+mmandal);
			var c=mmandal;
			if(c!=null && c>0){
				//alert(myproj+"myproj");
				getVillages(c);
				
			
			}
			
			
			var cconst= parseInt($("#selectedolddistId").val()); 
			//alert("c"+mmandal);
			var d=cconst;
			if(d!=null && d>0){
				//alert(myproj+"myproj");
				getConstituencies(d);
				
			
			}
			
		
		
			
			
		
			

		
		

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


					<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Edit Component Ayacut Created</h3>
							</div>
							<form:form id="compmonthly" method="post" modelAttribute="compayacutmon"
								data-parsley-validate-if-empty="">
								<div class='container'>

                           <c:if test="${editcompAyacutObj!=null}">


									<div class="row col-md-12 toppad ">
									
									
										<input type="hidden" class="form-control"  id="selectedProjectId" name="selectedProjectId" value="${selectedProjectId}" />
				<input type="hidden" class="form-control"  id="selectedUnitId" name="selectedUnitId" value="${selectedUnitId}"/>
				<input type="hidden" class="form-control"  id="selectedCompId" name="selectedcompId" value="${selectedcompId}" />
				<input type="hidden" class="form-control"  id="selectedDistrictId" name="selectedDistrictId" value="${selectedDistrictId}"/>
				<input type="hidden" class="form-control"  id="selectedMandalId" name="selectedMandalId" value="${selectedMandalId}"/>
				<input type="hidden" class="form-control"  id="selectedConstId" name="selectedConstId" value="${selectedConstId}"/>
				<input type="hidden" class="form-control"  id="compMonAyacutId" name="compMonAyacutId" value="${compMonAyacutId}"/>
                   <input name=editFlag  id="editFlag" type=hidden  value="false">    
                         <input type="hidden" class="form-control"  id="selectedolddistId" name="selectedolddistId" value="${selectedolddistId}"/>
									


                                   

                                       <div class="col-md-6">
                                       
                                       <div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Unit</label> 
													</div>
													
													<div class="col-md-6">
													
													
													<select class="form-control" id="unitId"
													name="unitId" onchange="getProjects()">
													<option value="">--select --</option>
							
								<c:forEach items="${unitList}" var="u">
													<c:choose>
									<c:when test="${u.unitId==selectedUnitId}">
									<option value="${u.unitId}" selected="selected">${u.unitName}</option>
									</c:when>
									<c:otherwise>
									<option value="${u.unitId}">${u.unitName}</option>
									</c:otherwise>
									</c:choose>
									</c:forEach>
 
												</select>
											</div>
                                       
										


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Project</label> 
													</div>
													
													<div class="col-md-6">
													
													
													<select class="form-control" id="projectId"
													name="projectId" onchange="getParents(this.value)">
													
													
 
												</select>
											</div>






											<div class="col-md-6" >
												<label class="label-control rowlebel ">Select
													Component*</label> 
													
													</div>
													<div class="col-md-6">
													
													<select class="form-control" id="componentId"
													name="componentId" 
													required>
													<option value="0">--select--</option>


												</select>




											</div>
											
													<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Old District*</label>
							</div>
							<div class="col-md-6">
							

								<select class="form-control" id="oldDistrictId" name="oldDistrictId"
								 required onchange="getConstituencies(this.value)">
								<option value="">--select --</option>
							
								<c:forEach items="${distList}" var="u">
								<c:choose>
									<c:when test="${u.districtId==selectedolddistId}">
									<option value="${u.districtId}" selected="selected">${u.districtName}</option>
									</c:when>
									<c:otherwise>
									<option value="${u.districtId}">${u.districtName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>


							</select>

							
 

						</div>
						
												<div class="col-md-6 ">

							<label class="label-control rowlebel ">Constituency
								*</label>
						</div>
						<div class="col-md-6 ">
							<select class="form-control" id="constId" name="constId"
								 required>

								<option value="">--select--</option>
                               
							

							</select>
						</div>
											<div class="col-md-6 ">
							<label class="label-controlPMS rowlebel ">Select
								District*</label>
						</div>
						<div class="col-md-6 ">
							<select class="form-control" id="districtId" name="districtId"
								onchange="getMandals(this.value)" required>

								<option value="">--select--</option>
								<c:forEach items="${districtList}" var="d">
								<c:choose>
								<c:when test="${d.districtId==selectedDistrictId }">
									<option value="${d.districtId}" selected="selected">${d.districtName}</option>
									</c:when>
									<c:otherwise>
									<option value="${d.districtId}">${d.districtName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>


							</select>
						</div>
						
						
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Mandal</label>
							</div>
							
							<div class="col-md-6">
							<select class="form-control" id="mandalId" name="mandalId"
								onchange="getVillages(this.value)" required>

								 <option value="0">--select--</option>
								
 

							</select>
						</div>
						
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Village</label>
							</div>
							<div class="col-md-6">
							<select class="form-control" id="villageId" name="villageId"
								 required>

								 <option value="0">--select--</option>
								 
								

							</select>
						</div>
					
											
											

											</div>
											<div class="col-md-6">
											

										
										
											
										<div class="row show-grid">	
											<div class="col-md-6">

												<label class="label-control rowlebel ">Ayacut Contemplated*</label> 
												</div>
												
												<div class="col-md-3">
												
												<input type="text" class="form-control"
													id="presentAyacutContemplated" name="presentAyacutContemplated" value="${editcompAyacutObj.presentAyacutContemplated }"
													placeholder="in Acres" required  /> 
											</div>
										
											
							
						
							
						</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Stabilized Created *</label> 
												</div>
												
												<div class="col-md-5">
												
												<input type="text" class="form-control"
													id="presentAyacutCreated" name="presentAyacutCreated"
													placeholder="in Acres" required  value="${editcompAyacutObj.presentAyacutCreated }" />
											</div>
											(acres)
										
										
												
 

											<div class="col-md-6">

												<label class="label-control rowlebel ">Ayacut Created Month/Date
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control datepicker"
													id="presentAyacutmonth" name="presentAyacutmonth" readonly="readonly" value="${editcompAyacutObj.presentAyacutmonth }"
													required value="0" />

											</div>





										</div>
										



										<div id="addedRows"></div>


										<div class="row show-grid">

											<div class="col-md-1"></div>
								<div class="col-md-1"></div>
										</div>














										<div class="row show-grid">


											<div class="col-md-12">
												<label class="label-control rowlebel ">Remarks</label>
												<textarea class="form-control" id="remarks" name="remarks"><c:out value="${editcompAyacutObj.remarks }"></c:out> </textarea>
											</div>

										</div>


										<div class="row show-grid">
											<div class="col-md-2 "></div>
											<div class="col-md-10 ">
												<label class="label-control rowlebel "></label><input
													type="submit" class="btn btn-1 btn-primary center-block"
													id="addpowerinfo" value="Submit">
											</div>
										</div>







									</div>
									<!-- row -->

</c:if>


								</div>
							</form:form>

						</div>
						






</div>

<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>

<script>
    window.onunload = refreshParent;
    function refreshParent() {
    	 self.close();
       window.opener.location.reload(true);
       
    }
</script>


<script type="text/javascript" class="example">
	$(function() {
		$('#compmonthly').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			 //alert('hi');

		})

		.on('form:submit', function() {
			 //alert("coming here");
             $("#editFlag").val(true);
			document.forms.compmonthly.action = "../comptsimis/editCompMonAyacut";
			document.forms.compmonthly.submit();

			// Don't submit form for this demo
		});
	});
</script>

