
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
		
		
		
		
		$("#presentunit").keyup(function(){
			   
           var a =   parseFloat($("#presentunit").val());
			 
			 var b =   parseFloat($("#previousunit").val());
			 
			 //alert("a"+a);
			 //alert("b"+b);
			 
			 var c=parseFloat(a-b);
			 
			
			 
			 $("#totalUnitsConsumed").val(c);
			   
			   
		   });
		
		
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
			
		   });
		
		$("#penalityCharges").keyup(function(){
			 var d =   parseFloat($("#fixedCharges").val());
			 var e =   parseFloat($("#billCost").val());
			 var f =   parseFloat($("#penalityCharges").val());
			
			
			 var i=parseFloat(d+e+f)
			
			
			 $("#netBillCost").val(i);
			
		   });
		
		$("#additionalDeposit").keyup(function(){
			 var d =   parseFloat($("#fixedCharges").val());
			 var e =   parseFloat($("#billCost").val());
			 var f =   parseFloat($("#penalityCharges").val());
			
			
			 var i=parseFloat(d+e+f)
			
			
			 $("#netBillCost").val(i);
			
		   });
		
		var myproj= parseInt($("#projectId").val()); 
		//alert("m"+myproj);
		var m=myproj;
		if(m!=null && m>0){
			//alert(myproj+"myproj");
			getParents();
		
		}
		
		
		

		$("#editcompbutton").click(function(){
			
			 $("#presentunit").attr("readonly", false);
			 $("#additionalDeposit").attr("readonly", false);
			 $("#fixedCharges").attr("readonly", false);
			 $("#penalityCharges").attr("readonly", false);
			 $("#billCost").attr("readonly", false);
			 $("#remarks").attr("readonly", false);
			 
			
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
								<h3 class="panel-title">Edit Power Consumption</h3>
							</div>
							<form:form id="compmonthly" method="post" modelAttribute="comppowermon"
								data-parsley-validate-if-empty="">
								<c:if test="${editcompPowerObj!=null}">
								
				<input name=componentPowerId  id="componentPowerId" type=hidden  value="${editcompPowerObj.componentPowerId}">
				<input name=selectedcompId  id="selectedcompId" type=hidden  value="${selectedcompId}">
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
													name="componentId" 
													required>
													<option value="0">--select--</option>


												</select>




											</div>

											<div class="col-md-6">

												<label class="label-control rowlebel ">(A)pre. units consumed(mw).*</label> 
													
												</div>	
												<div class="col-md-6">	
													<input type="text" class="form-control"
													id="previousunit" name="previousunit"
													placeholder="load in mW" required  value="${editcompPowerObj.previousunit }" readonly="readonly"/>
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">(B)present units consumed(mw)</label> 
												</div>
												
												<div class="col-md-6">
												
												<input type="text" class="form-control"
													id="presentunit" name="presentunit"
													placeholder="load in mW" required value="${editcompPowerObj.presentunit }" readonly="readonly"  />
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">(B-A)Total units consumed(mw)</label> 
												</div>
												
												<div class="col-md-6">
												
												<input type="text" class="form-control"
													id="totalUnitsConsumed" name="totalUnitsConsumed"
													placeholder="load in mW" required  readonly="readonly"  value="${editcompPowerObj.totalUnitsConsumed }" />
											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Present Bill Date 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control datepicker"
													id="powerConsumeMonth" name="powerConsumeMonth" readonly="readonly"
													required value="${editcompPowerObj.powerConsumeMonth }" />

											</div>
											
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Present Bill Due Date 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control datepicker"
													id="dueDate" name="dueDate" readonly="readonly"
													required value="${editcompPowerObj.dueDate }" />

											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">Disconnection Date 
													</label>
													</div>
													
													<div class="col-md-6"> <input type="text" class="form-control datepicker"
													id="disconnectionDate" name="disconnectionDate" readonly="readonly"
													required value="${editcompPowerObj.disconnectionDate }" />

											</div>
											
										
											</div>
											<div class="col-sm-6">
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">Additional Deposit(rupees)</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="additionalDeposit" name="additionalDeposit"
													placeholder="load in mW" required value="${editcompPowerObj.additionalDeposit }" readonly="readonly" />
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">(A)Fixed Charges(rupees)</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="fixedCharges" name="fixedCharges"
													placeholder="load in mW" required value="${editcompPowerObj.fixedCharges }"  readonly="readonly"/>
											</div>
											
											

											<div class="col-md-6">

												<label class="label-control rowlebel ">(B)Bill Cost(rupees) </label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="billCost" name="billCost"
													placeholder="load in mW" required value="${editcompPowerObj.billCost }"  readonly="readonly" />
											</div>
											
											<div class="col-md-6">

												<label class="label-control rowlebel ">(C)Penality(rupees)</label>
												</div>
												<div class="col-md-6"> <input type="text" class="form-control"
													id="penalityCharges" name="penalityCharges"
													placeholder="load in mW" required value="${editcompPowerObj.penalityCharges }"  readonly="readonly"/>
											</div>
											
										
											
											
												<div class="col-md-6">

												<label class="label-control rowlebel ">(A+B+C)Net Bill cost(rupees)</label> 
												</div>
												<div class="col-md-6">
												<input type="text" class="form-control"
													id="netBillCost" name="netBillCost" readonly="readonly"
													placeholder="In Rupees" required  value="${editcompPowerObj.netBillCost }"/>
											</div>
											
								</div>
										



									


										<div class="row show-grid">


											<div class="col-md-12">
												<label class="label-control rowlebel ">Remarks</label>
												<textarea class="form-control" id="remarks" name="remarks"  readonly="readonly">${editcompPowerObj.remarks }</textarea>
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
							
							<form:form id="cancelcompform" method="post" modelAttribute="editcomp"  data-parsley-validate-if-empty=""  >
 <c:if test="${editcompPowerObj!=null}">
<div class="row show-grid">
					<br></br>
					<div class="col-md-5"></div>
					<div class="col-md-2">
					<input type="hidden" class="form-control"  id="componentPowerId" name="componentPowerId" value="<c:out value="${editcompPowerObj.componentPowerId}"></c:out>"/>
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
		$('#compmonthly').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			// alert('hi');

		})

		.on('form:submit', function() {
			// alert("coming here");

			document.forms.compmonthly.action = "../comptsimis/editCompMonPower";
			document.forms.compmonthly.submit();

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
			  
			 
				
			  document.forms.cancelcompform.action="../comptsimis/editCompMonPower";
				 document.forms.cancelcompform.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

