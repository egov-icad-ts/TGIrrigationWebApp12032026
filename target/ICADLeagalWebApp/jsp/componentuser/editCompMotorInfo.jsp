
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
		
		 
		$('#projectId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});

		
		$('#componentId').multiselect({
			 
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
		
		
		

		$("#editcompbutton").click(function(){
			
			
			
			
			
			$("#deviceName").attr("readonly", false);
			$("#connectedLoad").attr("readonly", false);
			$("#actualLoad").attr("readonly", false);
			$("#rpm").attr("readonly", false);
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
								<h3 class="panel-title">Edit Component Motor/Pump Input</h3>
							</div>
							<form:form id="compinputform" method="post" modelAttribute="editcompinput"
								data-parsley-validate-if-empty="">
								<c:if test="${editcompMotorinfo!=null}">
								
				<input name=compInfoId  id="compInfoId" type=hidden  value="${editcompMotorinfo.compInfoId}">
				
				<input name=editFlag  id="editFlag" type=hidden  value="false">
								
								<div class='container'>




									<div class="row col-md-12 toppad ">


                                    <!--    <div class="row show-grid">
                                       
                                       	<div class="alert alert-primary" role="alert">
										<strong>Note: Considering 375 rs kVA/month,if change in price mail to admin</strong>
										
										
										
										
									</div>
                                       
                                       </div> -->

                                       <div class="col-sm-6">
										
                                       
                                       	<div class="col-md-6">

												<label class="label-control rowlebel ">Pump/Motor Number
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control"
													id="deviceName" name="deviceName" readonly="readonly" value="${editcompMotorinfo.deviceName}"
													 />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Connected Load
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control"
													id="connectedLoad" name="connectedLoad" readonly="readonly" value="${editcompMotorinfo.connectedLoad}"
													 />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Actual Load
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control"
													id="actualLoad" name="actualLoad" readonly="readonly" value="${editcompMotorinfo.actualLoad}"
													 />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Pump Rpm
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control"
													id="rpm" name="rpm" readonly="readonly" value="${editcompMotorinfo.rpm}"
													 />

											</div>

										 <div class="col-md-6">

												<label class="label-control rowlebel ">Category</label> 
													
												</div>	
												<div class="col-md-6">	
													<select class="form-control" id="deviceCategory"
													name="deviceCategory"  
													required>
												
													
													 <c:if  test="${selectdeviceCategory.equals('P')}" >
													
									              <option value="P" selected="selected">Pump</option>
									                <option value="M" >Motor</option>
									              </c:if>
									               <c:if test="${selectdeviceCategory.equals('M')}" >
													
									              <option value="M" selected="selected">Motor</option>
									                <option value="P" >Pump</option>
									              </c:if>
									            
									            

							
 


												</select>


											</div>
											
													
													





											
											
											
										
											</div>
											
											 <div class="col-sm-6">
											 
											 
											 <div class="col-md-6">

												<label class="label-control rowlebel ">Pump/Motor Make</label> 
													
												</div>	
												<div class="col-md-6">	
													<select class="form-control" id="make"
													name="make"  
													required>
												 <c:forEach items="${motormake}" var="u">
													 <c:choose>
													 <c:when  test="${u.motormakeId==selectMotormakeId}" >
													
									              <option value="${u.motormakeId}" selected="selected">${u.motormakeName}</option>
									              </c:when>
									              <c:otherwise>
									              
									              <option value="${u.motormakeId}" >${u.motormakeName}</option>
									              </c:otherwise>
									             
									              </c:choose>

								</c:forEach>
 


												</select>


											</div>
											
											
												
												
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Pump/Motor Type</label> 
												</div>
												
												<div class="col-md-6">
												
												<select class="form-control" id="deviceType"
													name="deviceType" 
													required>
													 <c:forEach items="${motortype}" var="u">
													 <c:choose>
													 <c:when  test="${u.motortypeId==slectedMotorTypeId}" >
													
									              <option value="${u.motortypeId}" selected="selected">${u.motortypeName}</option>
									              </c:when>
									              <c:otherwise>
									              
									              <option value="${u.motortypeId}" >${u.motortypeName}</option>
									              </c:otherwise>
									             
									              </c:choose>

								</c:forEach>
 


												</select>
											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Pump/Motor Capacity</label>
													</div>
													
													<div class="col-md-6"> 
													
													<select class="form-control" id="deviceCapacity"
													name="deviceCapacity" 
													required>
													 <c:forEach items="${pumpCapacity}" var="u">
													 <c:choose>
													 <c:when  test="${u.pumpcapacityId==slectedMotorCapacityId}" >
													
									              <option value="${u.pumpcapacityId}" selected="selected">${u.pumpCapacityName}</option>
									              </c:when>
									              <c:otherwise>
									              
									              <option value="${u.pumpcapacityId}" >${u.pumpCapacityName}</option>
									              </c:otherwise>
									             
									              </c:choose>

								</c:forEach>
 


												</select>

											</div>
											
											
										
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Pump/Motor Status
													</label>
													</div>
													
													
													<div class="col-md-6"> <select class="form-control" id="statusId"
													name="statusId" 
													required>
													
													 <c:choose>
													 <c:when  test="${selctedStatusId==1}" >
													
									              <option value="1" selected="selected">Service</option>
									              </c:when>
									              <c:otherwise>
									              
									              <option value="2" >Execution</option>
									              </c:otherwise>
									             
									              </c:choose>
									               <c:choose>
													 <c:when  test="${selctedStatusId==2}" >
													 <option value="2"  selected="selected">Execution</option>
									            
									              </c:when>
									              <c:otherwise>
									              
									                <option value="1" >Service</option>
									              </c:otherwise>
									             
									              </c:choose>
									              

							
 


												</select>
											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Remarks
													</label>
													</div>
													
													<div class="col-md-6"> <textarea  class="form-control"
													id="remarks" name="remarks" readonly="readonly" 
													 ><c:out value="${editcompMotorinfo.remarks}"></c:out>   </textarea>

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
									<!-- row -->




								</div>
								</c:if>
							</form:form>
							
							<form:form id="cancelcompform" method="post" modelAttribute="editCompInput"  data-parsley-validate-if-empty=""  >
 <c:if test="${editcompMotorinfo!=null}">
<div class="row show-grid">
					<br></br>
					<div class="col-md-5"></div>
					<div class="col-md-2">
					<input type="hidden" class="form-control"  id="compInfoId" name="compInfoId" value="<c:out value="${editcompMotorinfo.compInfoId}"></c:out>"/>
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
			  
			 
				
			  document.forms.cancelcompform.action="../comptsimis/editCompInput";
				 document.forms.cancelcompform.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

