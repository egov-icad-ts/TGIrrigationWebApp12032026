
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
	  				
	  				var selectedProj=$('#selectedProjId').val();
	  					
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
	
</script>

	




<script>

  
	$(document).ready(function() {
		
		$('#unitId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		 
		$('#projectId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});

		
		$('#componentId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		$('#seasonId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		$('#seasonMonth').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		

		
		 
		

	});

	$(function() {
		
		
		
		
		$("#seasonMonthName").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "mm/yy",
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
			 var myproj= parseInt($("#selectedProjId").val()); 
			//alert("m"+myproj);
			var e=myproj;
			if(e!=null && e>0){
				//alert(myproj+"myproj");
				getParents(e);
			
			}
		
		
		$("#editcompbutton").click(function(){
			
			
			
			
			
			//$("#pumpName").attr("readonly", false);
			
			
			$("#pumpDischarge").attr("readonly", false);
			$("#ayacut").attr("readonly", false);
			$("#remarks").attr("readonly", false);
			 
			 
			
			 $("#editFlag").val(true);
			 
			 
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
								<h3 class="panel-title">Edit Component Discharge</h3>
							</div>
							<form:form id="compinputform" method="post" modelAttribute="editCompDischargeInput"
								data-parsley-validate-if-empty="">
								<c:if test="${compinfObj!=null}">
								
				<input name=compDischargeId  id="compDischargeId" type=hidden  value="${compinfObj.compDischargeId}">
				
				<input name=selectedProjId  id="selectedProjId" type=hidden  value="${compinfObj.projectId}">
				
				<input name=selectedCompId  id="selectedCompId" type=hidden  value="${compinfObj.componentId}">
				
				
				
				
				
				<input name=editFlag  id="editFlag" type=hidden  value="false">
								
								



									<div class="row col-md-12 toppad ">


                                  

                                   
										
                                       
                                      
                                       <div class="col-md-12">
										
										
										
                                       <div class="col-md-4">
										
                                         
											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Unit</label> 
													</div>
													
													<div class="col-md-6">
													
													
													<select class="form-control" id="unitId"
													name="unitId" onchange="getProjects()" >
													
													<option value="0">--select--</option>
												<option value="">--select --</option>
							
								<c:forEach items="${unitList}" var="u">
								<c:choose>
									<c:when test="${u.unitId==compinfObj.unitId}">
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
											

										

</div>

  <div class="col-md-4">
  
  <div class="col-md-6" >
												<label class="label-control rowlebel ">Select
													Season*</label> 
													
													</div>
													<div class="col-md-6">
													
													<select class="form-control" id="seasonId"
													name="seasonId"   
													required>
												
													<option value="0">--select--</option>
														
													<c:if test="${compinfObj.seasonId==1}">
													<option value="1" selected="selected">Kharif</option>
													<option value="2">Rabi</option>
													</c:if>
													<c:if test="${compinfObj.seasonId==2}">
													<option value="1" >Kharif</option>
													<option value="2" selected="selected">Rabi</option>
													
												</c:if>


												</select>




											</div>
											<div class="col-md-6" >
												<label class="label-control rowlebel ">Select
													Year*</label> 
													
													</div>
													<div class="col-md-6">
													
					
												<input type="text" name="seasonMonthName" id="seasonMonthName" class="form-control  datepicker" readonly="readonly" value="${compinfObj.seasonMonthName}"/>




											</div>
											<!-- <div class="col-md-6" >
												<label class="label-control rowlebel ">Select Month
												   *</label> 
													
													</div>
													<div class="col-md-6">
													
													<select class="form-control" id="seasonMonth"
													name="seasonMonth"   
													required>
													<option value="0">--select--</option>
													<option value="1">Jan</option>
													<option value="2">Feb</option>


												</select>




											</div>
   -->
   
     	<div class="col-md-6">

												<label class="label-control rowlebel ">Discharge(cusecs)</label> 
												</div>
												<div class="col-md-6">
												<input type="text" class="form-control"
													id="pumpDischarge" name="pumpDischarge" placeholder="In cusecs Ex: 23.89" required value="${compinfObj.pumpDischarge}" readonly="readonly" />
											</div>
  </div>
  
  <div class="col-md-4">
  

											
												<div class="col-md-6">

												<label class="label-control rowlebel ">Ayacut (acres)</label> 
												</div>
												<div class="col-md-6">
												<input type="text" class="form-control"
													id="ayacut" name="ayacut" placeholder="In acres Ex: 23.49" required value="${compinfObj.ayacut}"  readonly="readonly"/>
											</div>
											
													<div class="col-md-6">

												<label class="label-control rowlebel ">Remarks</label> 
												</div>
												<div class="col-md-6">
												<textarea  class="form-control"
													id="remarks" name="remarks"  readonly="readonly" ><c:out value="${compinfObj.remarks}"></c:out>   </textarea>
											</div>
  
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






									
									<!-- row -->




								</div>
								</c:if>
							</form:form>
							
							<form:form id="cancelcompform" method="post" modelAttribute="editCompInput"  data-parsley-validate-if-empty=""  >
 <c:if test="${compinfObj!=null}">
<div class="row show-grid">
					<br></br>
					<div class="col-md-5"></div>
					<div class="col-md-2">
					<input type="hidden" class="form-control"  id="compInputId" name="compInputId" value="<c:out value="${compinfObj.compInfoId}"></c:out>"/>
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
	$(function() {
		$('#compinputform').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			// alert('hi');

		})

		.on('form:submit', function() {
			// alert("coming here");

			document.forms.compinputform.action = "../comptsimis/editCompDischargeInput";
			document.forms.compinputform.submit();

			// Don't submit form for this demo
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

<script type="text/javascript" class="example">
$(function () {
	 $('#cancelcompform').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  
			 
				
			  document.forms.cancelcompform.action="../comptsimis/editCompDischargeInput";
				 document.forms.cancelcompform.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

