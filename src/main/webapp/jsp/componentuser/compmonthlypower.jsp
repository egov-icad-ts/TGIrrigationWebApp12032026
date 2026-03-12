
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
		
		$('#paidStatusId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});


		
		 
		$('#projectId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});

		
		$('#componentId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});

	});

	$(function() {
		
		

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
		
		$("#powerConsumeMonth").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		$("#dueDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		$("#disconnectionDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		
		$("#paidDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		
		
		
		
		
	/* 	$("#presentunit").keyup(function(){
			   
           var a =   parseFloat($("#presentunit").val());
			 
			 var b =   parseFloat($("#previousunit").val());
			 
			 //alert("a"+a);
			 //alert("b"+b);
			 
			 var c=parseFloat(a-b);
			 
			
			 
			 $("#totalUnitsConsumed").val(c);
			   
			   
		   }); */
		
		
		$("#fixedCharges").keyup(function(){
			 var d =   parseFloat($("#fixedCharges").val());
			 var e =   parseFloat($("#billCost").val());
			 var f =   parseFloat($("#penalityCharges").val());
			 
			
			 var i=parseFloat(d+e+f)
			
			
			 $("#netBillCost").val(i);
			
		   });
		
		$("#billCost").keyup(function(){
			 var d =   parseFloat($("#fixedCharges").val());
			 var e =   parseFloat($("#billCost").val());
			 var f =   parseFloat($("#penalityCharges").val());
			
			
			 var i=parseFloat(d+e+f)
			
			
			 $("#netBillCost").val(i);
			 
			 $("#totalAmount").val(i);
			 
			 
			
		   });
		
		$("#penalityCharges").keyup(function(){
			 var d =   parseFloat($("#fixedCharges").val());
			 var e =   parseFloat($("#billCost").val());
			 var f =   parseFloat($("#penalityCharges").val());
			
			
			 var i=parseFloat(d+e+f)
			
			
			 $("#netBillCost").val(i);
			 $("#totalAmount").val(i);
			
		   });
		
		$("#additionalDeposit").keyup(function(){
			 var d =   parseFloat($("#fixedCharges").val());
			 var e =   parseFloat($("#billCost").val());
			 var f =   parseFloat($("#penalityCharges").val());
			
			
			 var i=parseFloat(d+e+f)
			
			
			 $("#netBillCost").val(i);
			 $("#totalAmount").val(i);
			
		   });
		
		
		$("#paidAmount").keyup(function(){
			 var d =   parseFloat($("#totalAmount").val());
			 var e =   parseFloat($("#paidAmount").val());
			
			
			if(d<e){
				
				 $("#paidAmount").val(0);
				
				
				
			}
			
			
			
			
			
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
								<h3 class="panel-title">Component Power Consumption</h3>
							</div>
							<form:form id="compmonthly" method="post" modelAttribute="comppower"
								data-parsley-validate-if-empty="">
								<div class='container'>

                            <input type="hidden" class="form-control"  id="selectedProjId" name="selectedProjId" value="${selectedProjId}" />
				                   <input type="hidden" class="form-control"  id="selectedUnitId" name="selectedUnitId" value="${selectedUnitId}"/>
				                   <input type="hidden" class="form-control"  id="selectedCompId" name="selectedCompId" value="${selectedCompId}"/>


									<div class="row col-md-12 toppad ">


                               

                                       <div class="col-sm-6">
                                       
                                       
                                       <br></br>
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

										<!-- 	<div class="col-md-6">

												<label class="label-control rowlebel ">(A)pre. units consumed(mw).*</label> 
													
												</div>	
												<div class="col-md-6">	
													<input type="text" class="form-control"
													id="previousunit" name="previousunit"
													placeholder="load in mW" required  value="0" readonly="readonly"/>
											</div>
											 -->
											<div class="col-md-6">

												<label class="label-control rowlebel ">Units Consumed(mw)</label> 
												</div>
												
												<div class="col-md-6">
												
												<input type="text" class="form-control"
													id="presentunit" name="presentunit"
													placeholder="load in mW" required  />
											</div>
											
											<!-- <div class="col-md-6">

												<label class="label-control rowlebel ">(B-A)Total units consumed(mw)</label> 
												</div>
												
												<div class="col-md-6">
												
												<input type="text" class="form-control"
													id="totalUnitsConsumed" name="totalUnitsConsumed"
													placeholder="load in mW" required  readonly="readonly" />
											</div>
											 -->
											 
											 <div class="col-md-6">

												<label class="label-control rowlebel ">Bill Number</label> 
												</div>
												
												<div class="col-md-6">
												
												<input type="text" class="form-control"
													id="billNumber" name="billNumber"
													placeholder="number Ex:57267" required   />
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Bill Date 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control datepicker"
													id="powerConsumeMonth" name="powerConsumeMonth" readonly="readonly"
													required value="0" />

											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Bill Due Date 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control datepicker"
													id="dueDate" name="dueDate" readonly="readonly"
													required value="0" />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Disconnection Date 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control datepicker"
													id="disconnectionDate" name="disconnectionDate" readonly="readonly"
													required value="0" />

											</div>
											
										
											</div>
											<div class="col-sm-6">
											
											  <br></br>
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">Additional Deposit(rupees)</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="additionalDeposit" name="additionalDeposit"
													placeholder="load in mW" required value="0" />
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">(A)Fixed Charges(rupees)</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="fixedCharges" name="fixedCharges"
													placeholder="load in mW" required value="0" />
											</div>
											
											

											<div class="col-md-6">

												<label class="label-control rowlebel ">(B)Bill Cost(rupees) </label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="billCost" name="billCost"
													placeholder="load in mW" required value="0" />
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">(C)Penality(rupees)</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="penalityCharges" name="penalityCharges"
													placeholder="load in mW" required value="0" />
											</div>
											
										
											
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">(A+B+C)Net Bill cost(rupees)</label> 
												</div>
												<div class="col-md-6">
												<input type="text" class="form-control"
													id="netBillCost" name="netBillCost" readonly="readonly"
													placeholder="In Rupees" required />
											</div>
											
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">Total Amount</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="totalAmount" name="totalAmount"
													placeholder="load in mW" required value="0" />
											</div>
											
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">Paid Amount</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="paidAmount" name="paidAmount"
													placeholder="load in mW" required value="0" />
											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Paid Date</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control datepicker"
													id="paidDate" name="paidDate" readonly="readonly"
													required value="0" />
											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Paid Status</label>
												</div>
												<div class="col-md-6">	<select class="form-control" id="paidStatusId"
													name="paidStatusId" 
													required>
													<option value="0">--select--</option>
													
													<option value="NP">Not Paid</option>
													<option value="PP">Partial Payment</option>
													<option value="FP">Final Payment</option>


												</select>
												
											</div>
											
										
											
											
											
											
												
											
										






										</div>
										



										

										












										<div class="row show-grid">


											<div class="col-md-12">
												<label class="label-control rowlebel ">Remarks</label>
												<textarea class="form-control" id="remarks" name="remarks"></textarea>
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




								</div>
							</form:form>

						</div>
						<!-- panel -->

						<%-- <div class='row'>
			<!-- col-md-12 -->

			<form:form id="caseinput" method="post" modelAttribute="listWrappers" >
				
				<div class="col-md-12" id="showitem">
				    <div class="col-md-12" id="caseheader">
				    <div class='row' style="border:2px solid #F39C12;font-weight:bold;background: #85C1E9 none repeat scroll 0 0;" >
				    <div class="col-md-1" >S.NO</div>
				     <div class="col-md-1" >Circle /Division /Package</div>
				     <div class="col-md-1" >Court /Case Number /Type</div>	
				     <div class="col-md-1" >Year /Filing Date</div>	
				     <div class="col-md-1" >Case Subject /Sub / Stage</div>	
				     <div class="col-md-1" >Petitioners</div>	
				     <div class="col-md-1" >Petitioner Advocates</div>	
				     <div class="col-md-1" >Respondents</div>	
				     <div class="col-md-1" >Respondent Advocates</div>	
				     <div class="col-md-1" >Brief Prayer / Status</div>
				     <div class="col-md-1" >Remarks /Contact Person /Phone Number</div>	
				     <div class="col-md-1" >Delete</div>		
				    
				    </div>
				    
				   
			
			
				    </div>
									
					<div class="col-md-12" id="caserow"></div>
					
				</div>
				
				





				<div class="col-md-12" id="divcreate">
					
				
					 
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="submitCases" value="Submit Cases" onclick="loadcaseinputform()">
					 
				</div>


			</form:form>

		</div>
 --%>




						<!-- page -->
				<!-- 	</div> -->




					<!-- create component ends here -->


				<!-- </div>





			</div>
		</div>
	</div> -->




</div>
<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
	$(function() {
		$('#compmonthly').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			// alert('hi');

		})

		.on('form:submit', function() {
			// alert("coming here");

			document.forms.compmonthly.action = "../comptsimis/compmonthlypower";
			document.forms.compmonthly.submit();

			// Don't submit form for this demo
		});
	});
</script>

