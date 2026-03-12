
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
			
		
			
		
		$("#billDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		$("#billDueDate").datepicker({
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
		
		
		
		
		
	
		
		$(".compareDate").keyup(function(){
			
			 var a =   new Date($("#billDate").val());
			 var b =   new Date($("#billDueDate").val());
			 var c =   new Date($("#disconnectionDate").val());
			 var d =   new Date($("#paidDate").val());
			 
			 if(b < a && b > c && b > d){
				 
				 var b =   $("#billDueDate").val(0); 
				 alert("Please Select Correct bill due date")
				 
			 }
             if( c < b||c < a && c > d){
				 
				 var b =   $("#disconnectionDate").val(0); 
				 alert("please select Correct disconnection date")
				 
			 }
			 
               if( d < a||d < b||d < c ){
				 
				 var b =   $("#paidDate").val(0); 
				 alert("please select Correct paid date")
				 
			 }
               
		   });
		
		 /* $("#billDueDate").keyup(function(){
			 var e =   new Date($("#billDate").val());
			 var f =   new Date($("#billDueDate").val());
			 var g =   new Date($("#disconnectionDate").val());
			 var h =   new Date($("#paidDate").val());
			 
 if(b<a){
				 
				 var b =   $("#billDueDate").val(0); 
				 alert("please select Correct bill due date")
				 
			 }
			 
			 
			 if(c<b||c<a){
				 
				 var b =   $("#disconnectionDate").val(0); 
				 alert("please select Correct disconnection date")
				 
			 }
			 
               if(d<a||d<b||d<c){
				 
				 var b =   $("#paidDate").val(0); 
				 alert("please select Correct paid date")
				 
			 }
			 
					 
			
		   });
		
		$("#disconnectionDate").keyup(function(){
			 var i =   new Date($("#billDate").val());
			 var j =   new Date($("#billDueDate").val());
			 var k =   new Date($("#disconnectionDate").val());
			 var l =   new Date($("#paidDate").val());
			 
 if(b<a){
				 
				 var b =   $("#billDueDate").val(0); 
				 alert("please select Correct bill due date")
				 
			 }
			 
			 
			 if(c<b||c<a){
				 
				 var b =   $("#disconnectionDate").val(0); 
				 alert("please select Correct disconnection date")
				 
			 }
			 
               if(d<a||d<b||d<c){
				 
				 var b =   $("#paidDate").val(0); 
				 alert("please select Correct paid date")
				 
			 }
			 
			 
					 
			
		   });
		
		$("#paidDate").keyup(function(){
			 var m =   new Date($("#billDate").val());
			 var n =   new Date($("#billDueDate").val());
			 var o =   new Date($("#disconnectionDate").val());
			 var p =   new Date($("#paidDate").val());
			 
            if (b<a){
				 
				 var b =   $("#billDueDate").val(0); 
				 alert("please select Correct bill due date")
				 
			 }
			 
			 
			 if(c<b||c<a){
				 
				 var b =   $("#disconnectionDate").val(0); 
				 alert("please select Correct disconnection date")
				 
			 }
			 
               if(d<a||d<b||d<c){
				 
				 var b =   $("#paidDate").val(0); 
				 alert("please select Correct paid date")
				 
			 }
			 
			 
					 
			
		   }); */
		 
	
            $(".variable").keyup(function(){
    			
    			var	aa4=parseFloat($("#energyCharges").val());
    			var	bb4=parseFloat($("#electricityDuty").val());
    			var	cc4=parseFloat($("#eletricityDutyInterest").val());
    			var	dd4=parseFloat($("#variableOthers").val());
    			
    			var total4=aa4+bb4+cc4+dd4;
    			
    			$("#variableCharges").val(total4);
    			
    			
    			
    			   });
            
            
 
 
 $(".total").keyup(function(){
		
		var	aa7=parseFloat($("#variableCharges").val());		
		var	bb7=parseFloat($("#fixedCharges").val());
		var	cc7=parseFloat($("#latePaySurCharge").val());
		var	dd7=parseFloat($("#ACDSurCharges").val());
		var	ee7=parseFloat($("#interestSecurityDeposite").val());
		
		
		
		
		var total7=aa7+bb7+cc7+dd7-ee7;
		
		$("#totalAmount").val(total7);
		
		
		
		   });
 
 $("#paidAmount").keyup(function(){
		
		var	aat=parseFloat($("#totalAmount").val());		
		var	bbp=parseFloat($("#paidAmount").val());
		
		
		
		
		
		if(bbp>aat){
		
		
		$("#paidAmount").val(0);
		alert("Please Enter correct Paid Amount");
		}
		
		
		
		   });
 

 /* $("#fixedCharges"). keyup(function(){
		
		var	aa8=parseFloat($("#variableCharges").val());		
		var	bb8=parseFloat($("#fixedCharges").val());
		var	cc8=parseFloat($("#latePaySurCharge").val());
		var	dd8=parseFloat($("#ACDSurCharges").val());
		
		
		var total8=aa8+bb8;
		
		$("#totalAmount").val(total8);
		
		
		
		   }); */
            
           
		
 
 $( ".fixed" ).keyup(function() {
	 
	
	 var aaa=parseFloat($("#demandCharges").val());
	var  bbb=parseFloat($("#customerCharges").val());
		
	
		var totalfixed=aaa+bbb;
		
		$("#fixedCharges").val(totalfixed);
	  
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
							<form:form id="comppowerId" method="post" modelAttribute="editCompPowerBill" enctype="multipart/form-data"
								data-parsley-validate-if-empty="">
								
								
								<c:if test="${editcompPowerObj!=null}">
								
						<input name=selectedProjId  id="selectedProjId" type=hidden  value="${editcompPowerObj.projectId}">
				<input name=compPowerBillId  id="compPowerBillId" type=hidden  value="${editcompPowerObj.compPowerBillId}">
				<input name=selectedcompId  id="selectedCompId" type=hidden  value="${editcompPowerObj.componentId}">
				<input name=editFlag  id="editFlag" type=hidden  value="false">
								<div class='container'>

                             

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
									<c:when test="${u.unitId==editcompPowerObj.unitId}">
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

												<label class="label-control rowlebel ">Bill Number</label> 
												</div>
												
												<div class="col-md-6">
												
												<input type="text" class="form-control"
													id="billNumber" name="billNumber" value="${editcompPowerObj.billNumber}"
													placeholder="number Ex:57267" required  data-parsley-type="alphanum" readonly="readonly"  />
											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Bill Date 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control compareDate datepicker "
													id="billDate" name="billDate" readonly="readonly" value="${editcompPowerObj.billDate}"
													required value="0" />

											</div>
											
												
											<div class="col-md-6">

												<label class="label-control rowlebel ">Bill Due Date 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control  compareDate datepicker "
													id="billDueDate" name="billDueDate" readonly="readonly" value="${editcompPowerObj.billDueDate}"
													required value="0" />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Disconnection Date 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control  compareDate datepicker "
													id="disconnectionDate" name="disconnectionDate" readonly="readonly" value="${editcompPowerObj.disconnectionDate}"
													required value="0" />

											</div>
											
										
											<div class="col-md-6">

												<label class="label-control rowlebel ">Paid Date</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control datepicker compareDate"
													id="paidDate" name="paidDate" readonly="readonly" value="${editcompPowerObj.paidDate}"
													required value="0" />
											</div>	
											
											
 
									 
											
										

	<div class="col-md-6">

												<label class="label-control rowlebel ">Additional Security Deposit (ASD)</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="additionalSecurityDeposit" name="additionalSecurityDeposit"
													placeholder="load in mW"  value="0"  data-parsley-type="number"   value="${editcompPowerObj.additionalSecurityDeposit}" />
											</div>
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">Consumed Units(KVAH)</label> 
												</div>
												
												<div class="col-md-6">
												
												<input type="text" class="form-control"
													id="consumedUnits" name="consumedUnits"
													placeholder="KVAH" required   data-parsley-type="number"  value="${editcompPowerObj.consumedUnits}"  />
											</div>
											
											<div class="col-md-6">

												
												</div>
												<div class="col-md-3">

												<label class="label-control rowlebel ">Rate</label> 
												</div>
												<div class="col-md-3">

												<label class="label-control rowlebel ">Charges</label> 
												</div>
											<div class="col-md-6">

												<label class="label-control rowlebel ">1.Energy Charges </label> 
												</div>
												<div class="col-md-3">
												
												<input type="text" class="form-control"
													id="energyChargeRate" name="energyChargeRate"
													placeholder="5.80/KVAH" required   data-parsley-type="number"   value="${editcompPowerObj.energyChargeRate}" />
											</div>
											
											
												
												<div class="col-md-3">
												
												<input type="text" class="form-control variable"
													id="energyCharges" name="energyCharges"
													   data-parsley-type="number"  value="0"  value="${editcompPowerObj.energyCharges}"  />
											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">2.Electricity Duty </label> 
												</div>
												<div class="col-md-3">
												
												<input type="text" class="form-control"
													id="electricityDutyRate" name="electricityDutyRate"
													placeholder="0.06/KVAH" required  data-parsley-type="number"   value="${editcompPowerObj.electricityDutyRate}"   />
											</div>
												
												
												<div class="col-md-3">
												
												<input type="text" class="form-control variable"
													id="electricityDuty" name="electricityDuty"  data-parsley-type="number" 
													  value="${editcompPowerObj.electricityDuty} " />
											</div>
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">3.Electricity Duty Interest</label> 
												</div>
												<div class="col-md-6">
												
												<input type="text" class="form-control variable"
													id="eletricityDutyInterest" name="eletricityDutyInterest"
													placeholder="Rs:2637267.67" required  data-parsley-type="number"   value="${editcompPowerObj.eletricityDutyInterest} "  />
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">4.Others</label> 
												</div>
												<div class="col-md-6">
												
												<input type="text" class="form-control variable"
													id="variableOthers" name="variableOthers"
													placeholder="Rs:2637267.67" required  data-parsley-type="number"  value="${editcompPowerObj.variableOthers} "   />
											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">(A)Variable Charges(1+2+3+4)</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control total"
													id="variableCharges" name="variableCharges" value="${editcompPowerObj.variableCharges} " 
													value="0"  readonly ="readonly"/>
											</div>
											
											 
											
										
											</div>
											
											<div class="col-sm-6">
											
											  <br></br>
											
											
											
												<div class="col-md-6">

												
												</div>
												<div class="col-md-3">

												<label class="label-control rowlebel ">Rate </label> 
												</div>
												<div class="col-md-3">

												<label class="label-control rowlebel ">Charges</label> 
												</div>
										
												<div class="col-md-6">

												<label class="label-control rowlebel ">4.Demand Charges </label> 
												</div>
												<div class="col-md-3">
												
												<input type="text" class="form-control"
													id="demandRate" name="demandRate"
													placeholder="165/KVA" required    data-parsley-type="number"  value="${editcompPowerObj.demandRate} "  />
											</div>
												
												
												<div class="col-md-3">
												
												<input type="text" class="form-control fixed"
													id="demandCharges" name="demandCharges"  value="0" data-parsley-type="number"   value="${editcompPowerObj.demandCharges} " 
													 />
											</div>
												
												
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">5.Customer Charges</label> 
												</div>
												<div class="col-md-6">
												
												<input type="text" class="form-control fixed"
													id="customerCharges" name="customerCharges"
													placeholder="Rs. 67357.67" required  value="0"  data-parsley-type="number"  value="${editcompPowerObj.customerCharges} "  />
											</div>
											<div class="col-md-6">

												<label class="label-control rowlebel ">(B)Fixed Charges(4+5)</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control  total"
													id="fixedCharges" name="fixedCharges"
													value="0"  readonly ="readonly"  value="${editcompPowerObj.fixedCharges} " />
											</div>
											
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">6.Delay Pay Paise/100 </label> 
												</div>
												<div class="col-md-6">

												<label class="label-control rowlebel ">Delay Pay rate/day </label> 
												</div>
												<div class="col-md-5">
												
												<input type="text" class="form-control"
													id="delayPayInPaise" name="delayPayInPaise"
													placeholder="5ps/Rs.100"   data-parsley-type="integer"  value="${editcompPowerObj.delayPayInPaise} " />
											</div>
											<div class="col-md-1">
											(OR)
											</div>
											
											<div class="col-md-6">
												
												<input type="text" class="form-control"
													id="delayPayPerDay" name="delayPayPerDay"
													placeholder="150/Day"   data-parsley-type="integer"  value="${editcompPowerObj.delayPayPerDay} "  />
											</div>
												
													
										
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">(C)Late Payment Surcharges</label> 
												</div>
												<div class="col-md-6">
												
												<input type="text" class="form-control total"
													id="latePaySurCharge" name="latePaySurCharge"  value="0" data-parsley-type="number" 
													  value="${editcompPowerObj.latePaySurCharge} "  />
											</div>
											
											
											<div class="col-md-6">

											<label class="label-control rowlebel ">(D)ACD Surcharges </label> 
												</div>
												<div class="col-md-6">
												
												<input type="text" class="form-control total"
													id="ACDSurCharges" name="ACDSurCharges" value="${editcompPowerObj.ACDSurCharges} " 
													placeholder="rs:6356" data-parsley-type="number"  value="0" />
											</div>
											
											<div class="col-md-6">

											<label class="label-control rowlebel ">(E)Interest on  Security Deposite </label> 
												</div>
												<div class="col-md-6">
												
												<input type="text" class="form-control total"
													id="interestSecurityDeposite" name="interestSecurityDeposite"
													placeholder="rs:6356"  data-parsley-type="number" value="${editcompPowerObj.interestSecurityDeposite} "  />
											</div>
											
											
											<div class="col-md-6">

											<label class="label-control rowlebel ">Total Amount(A+B+C+D-E) </label> 
												</div>
												<div class="col-md-6">
												
												<input type="text" class="form-control"
													id="totalAmount" name="totalAmount" value="${editcompPowerObj.totalAmount} " 
													placeholder="rs:6356"  value="0" data-parsley-type="number" readonly="readonly"/>
											</div>
												
											
											
											
											
											
											
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">Paid Amount</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="paidAmount" name="paidAmount" value="${editcompPowerObj.paidAmount}" 
													placeholder="load in mW" required value="0" data-parsley-type="number" />
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Paid Status</label>
												</div>
												<div class="col-md-6">	<select class="form-control" id="paidStatusId"
													name="paidStatusId" 
													required>
													<option value="0">--select--</option>
													<c:choose>
													<c:when test="${ editcompPowerObj.paidStatusId.equals('NP')}">
													<option value="NP" selected="selected">Not Paid</option>
													</c:when>
													<c:when test="${ editcompPowerObj.paidStatusId.equals('PP')}">
													<option value="PP" selected="selected">Partial Payment</option>
													</c:when>
													<c:when test="${ editcompPowerObj.paidStatusId.equals('FP')}">
													<option value="FP" selected="selected">Final Payment</option>
													</c:when>
													
													<c:otherwise>
													<option value="NP" >Not Paid</option>
													<option value="PP" >Partial Payment</option>
													<option value="FP">Final Payment</option>
													</c:otherwise>
													</c:choose>
													


												</select>
												
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Lift In Metres</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="liftMetres" name="liftMetres"
													 required value="0"  data-parsley-type="number"   value="${editcompPowerObj.liftMetres}"  />
											</div>
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">Quantity</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="quantity" name="quantity"
													 required value="0" data-parsley-type="number"  value="${editcompPowerObj.quantity}" />
											</div>
											
											
										
													
											<div class="col-md-6">

												<label class="label-control rowlebel ">Upload Bill</label>
												</div>
												<div class="col-md-6"> <input type="file" 
													id="uploadBill" name="uploadBill"
													 required />
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
													 value="Submit">
											</div>
										</div>







									</div>
									<!-- row -->




								</div>
								</c:if>
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

<script>
    window.onunload = refreshParent;
    function refreshParent() {
    	 self.close();
       window.opener.location.reload(true);
       
    }
</script>

<script type="text/javascript" class="example">
	$(function() {
		$('#comppowerId').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			// alert('hi');

		})

		.on('form:submit', function() {
			// alert("coming here");
             $("#editFlag").val(true);
			document.forms.comppowerId.action = "../comptsimis/editCompPowerBill";
			document.forms.comppowerId.submit();

			// Don't submit form for this demo
		});
	});
</script>

