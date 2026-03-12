
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

<script type="text/javascript" src="../js/jquery.timepicker.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/jquery.timepicker.css" />

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
	  				
	  			var selectedComp=$('#selectedcompId').val();
	  					
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
	
</script>



<script>

  
	$(document).ready(function() {
		
		 
		

	});

	$(function() {
		
		
		$('#pumpStartTime').timepicker({ 'scrollDefault': 'now' });
		$('#pumpEndTime').timepicker({ 'scrollDefault': 'now' });
		
		
		

		$("#editcompbutton").click(function(){
			
			
			
			
			
			//$("#pumpName").attr("readonly", false);
			$("#pumpDischarge").attr("readonly", false);
			$("#pumpStartDate").attr("readonly", false);
			$("#pumpStartTime").attr("readonly", false);
			 $("#pumpEndTime").attr("readonly", false);
			 $("#pumpEnergy").attr("readonly", false);
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
								<h3 class="panel-title">Edit Daily Input</h3>
							</div>
							<form:form id="compinputform" method="post" modelAttribute="editcompdailyinput"
								data-parsley-validate-if-empty="">
								<c:if test="${compinfObj!=null}">
								
				<input name=compInputId  id="compInputId" type=hidden  value="${compinfObj.compInputId}">
				
				<input name=editFlag  id="editFlag" type=hidden  value="false">
								
								



									<div class="row col-md-12 toppad ">


                                  

                                   
										
                                       
                                       	<div class="col-md-6">

												<label class="label-control rowlebel ">Pump/Motor 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control"
													id="pumpName" name="pumpName" readonly="readonly" value="${compinfObj.pumpName}"
													 />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Pump Discharge
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control"
													id="pumpDischarge" name="pumpDischarge" readonly="readonly" value="${compinfObj.pumpDischarge}"
													 />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Pump Start Date
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control"
													id="pumpStartDate" name="pumpStartDate" readonly="readonly" value="${compinfObj.pumpStartDate}"
													 />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Pump Start Time
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class=" time form-control"
													id="pumpStartTime" name="pumpStartTime" readonly="readonly" value="${compinfObj.pumpStartTime}"
													 />

											</div>

										<div class="col-md-6">

												<label class="label-control rowlebel ">Pump End Time
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class=" time form-control"
													id="pumpEndTime" name="pumpEndTime" readonly="readonly" value="${compinfObj.pumpEndTime}"
													 />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Pump Energy Consumed
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control"
													id="pumpEnergy" name="pumpEnergy" readonly="readonly" value="${compinfObj.pumpEnergy}"
													 />

											</div>
											

										<div class="col-md-6">

												<label class="label-control rowlebel ">Remarks
													</label>
													</div>
													
													<div class="col-md-6"> <textarea  class="form-control"
													id="remarks" name="remarks" readonly="readonly" 
													 ><c:out value="${compinfObj.remarks}"></c:out>   </textarea>

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

			document.forms.compinputform.action = "../comptsimis/editCompDailyInput";
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
			  
			 
				
			  document.forms.cancelcompform.action="../comptsimis/editCompDailyInput";
				 document.forms.cancelcompform.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

