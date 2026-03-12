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
    window.onunload = refreshParent;
    function refreshParent() {
    	
       window.opener.location.reload(true);
        self.close();
    }
</script>

 

<script>
$(document).ready(function(){
	
	
	

	$('#unitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	
	
	 
	 
$('#circleId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	 
$('#divisionId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#subdivisionId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#designationId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});









});

	 
	  
			






	
	
	
	function getCircles(unitId){
		
		
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var unitId=unitId;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../task/getCircles?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#circleId');
	    	 
			  $select.find('option').remove();
			  
			  var n =$('#hiddencircleId').val();
			  
			 // alert("n"+n);

				var t=0;
				if(n!=null){
					if(n>0){
						t=parseInt(n);
					}
					
				}
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#circleId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						
						if(n>0){
						if(value.circleId==t){
							
							
							$('#circleId').append( '<option value="'+value.circleId+'" selected="selected" > '+value.circleName+'</option>' );
							
						}
						
						if(value.circleId!=t){
							
							$('#circleId').append( '<option value="'+value.circleId+'"  > '+value.circleName+'</option>' );
						}
						}
						if( n==0){
							
							$('#circleId').append( '<option value="'+value.circleId+'"  > '+value.circleName+'</option>' );
							
						}
						
						
	  	  				$('#circleId').multiselect('rebuild');
					
	  	  				
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
		  
		 
		  
		  
	}
	
	
	function getDivisions(circleId){
		
		$("#hidediv").show();
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var circleId=circleId;
			//document.getElementById("circleId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../task/getDivisions?circleId="+circleId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#divisionId');
	    	 
			  $select.find('option').remove();
  var k =$('#hiddendivisionId').val();
			  
			//  alert("k"+k);

				var t=0;
				if(k!=null){
					if(k>0){
						t=parseInt(k);
					}
					
				}
			  
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#divisionId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if( k>0){
							if(value.divisionId==t){
						
							$('#divisionId').append( '<option value="'+value.divisionId+'" selected="selected" > '+value.divisionName+'</option>' );
					      
							}
							
							if(value.divisionId!=t){
								$('#divisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
							}
						}
						if( k==0){
							$('#divisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
							
							}
	  	  				$('#divisionId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getSubDivisions(divisionId){
		$('#hidesubdiv').show();
		
		
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var divisionId=divisionId;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../task/getSubDivisions?divisionId="+divisionId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#subdivisionId');
	    	 
			  $select.find('option').remove();
			  
 var l =$('#hiddensubdivisionId').val();
			  
			  //alert("l"+l);

				var t=0;
				if(l!=null){
					if(l>0){
						t=parseInt(l);
					}
					
				}
			
			 
					var obj = JSON.parse(response);
					  $('#subdivisionId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(l>0){
							if(value.subdivisionId==t){
						
							$('#subdivisionId').append( '<option value="'+value.subdivisionId+'"  selected="selected"> '+value.subdivisionName+'</option>' );
					
}
							
							if(value.subdivisionId!=t){
								
								$('#subdivisionId').append( '<option value="'+value.subdivisionId+'"  > '+value.subdivisionName+'</option>' );
								
								
								
							}
						}
						if( l==0){
							
							$('#subdivisionId').append( '<option value="'+value.subdivisionId+'" > '+value.subdivisionName+'</option>' );
						}
							
	  	  				$('#subdivisionId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

 


	
 
 $(function() {
		

		var a=parseInt($("#unitId").val()); 
		if(a>0){
			//alert("a"+a);
			
			getCircles(a);
			
			
		}
		
		
		 
		 var c=parseInt($("#hiddencircleId").val()); 
		// alert(c+"c")
		if(c>0){
			
		//	alert("c"+c);
			getDivisions(c);
		
			
			
			
		}
		
		var d=parseInt($("#hiddendivisionId").val()); 
		if(d>0){
			
			getSubDivisions(d);
			
			
		}
		
		
		
		

		
		
		
 });

</script>


	<%-- <c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.employeeName}"></c:out></p>
		</div>
	</div>
	</c:if> --%>



	



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
				<div class="row show-grid">
				<div class=" row col-md-1"></div>
			<div class=" row col-md-4">
			
				<h3 class="panel-title">Edit Employee Data</h3>
				</div>
				<div class=" row col-md-4">
				<h3 class="panel-title"><c:if test="${userObj!=null}">	
						
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
			 <c:out value="${userObj.unitName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">	
			 <c:out value="${userObj.circleName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  &&  userObj.circleId>0  &&  userObj.divisionId>0 }">	
			 <c:out value="${userObj.divisionName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId!=0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  &&  userObj.divisionId>0 &&  userObj.subdivisionId>0  }">	
			 <c:out value="${userObj.subdivisionName}"></c:out>	
			 </c:if>
			 </c:if>
			 
			   <c:if test="${userObj.unitId==null && userObj.circleId==null && userObj.divisionId==null && userObj.subdivisionId==null }">	
						   
			 <c:out value="${userObj.userName}"></c:out>	
			 
			 </c:if>	
	</c:if></h3>
				</div>
				<div class=" row col-md-4"></div>
				</div>
				
			</div>
<form:form id="editEmpData" method="post" modelAttribute="editEmpData"  data-parsley-validate-if-empty=""  enctype="multipart/form-data"  >
			<div class='container'>




				<div class="row col-md-12 toppad ">
<c:if test="${empObj!=null }">
                   <div class="row show-grid">
                   	<div class="col-md-6">
                   	<label class="label-controlPMS rowlebel ">First Name : </label>
						</div>
							<div class="col-md-6">
						<input type="text" class="form-control"  id="firstName" name="firstName" value="<c:out value="${empObj.firstName}"></c:out>"/>
							</div>
							 </div>
							  <div class="row show-grid">
							<div class="col-md-6">
								<label class="label-controlPMS rowlebel ">Last Name : </label>
						</div>
						<div class="col-md-6">
						<input type="text" class="form-control"  id="lastName" name="lastName" value="<c:out value="${empObj.lastName}"></c:out>"/>
						</div>
						</div>
						<div class="row show-grid">
						<div class="col-md-6">
								<label class="label-controlPMS rowlebel ">Phone Number : </label>
						</div>
						<div class="col-md-6">
						<input type="text" class="form-control"  id="phoneNum1" name="phoneNum1" value="<c:out value="${empObj.phoneNum1}"></c:out>"/>
						</div>
                   </div>
					



					<div class="row show-grid">
					<div class="col-md-1"></div>
					<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select Unit *</label>
							 
							<select class="form-control" id="unitId"  name="unitId" onchange="getCircles(this.value)" required >
							<option value="0">--select --</option>
						 <c:forEach items="${unitList}" var="u">
						
						  <c:choose>
						  
								 <c:when test="${u.unitId==selectedunit}">
									<option value="${u.unitId}" selected="selected">${u.unitName}</option>
									</c:when>
									
									<c:otherwise>
									<option value="${u.unitId}" >${u.unitName}</option>
									</c:otherwise>
									</c:choose>
									
									
									

								</c:forEach>  
 

							</select>
							
							
						
						</div>

					
					
							<div class="col-md-2">
						
						<c:choose>
						<c:when test="${selectedcircle!=null}">
						<input type="hidden" class="form-control"  id="hiddencircleId" name="hiddencircleId" value="<c:out value="${selectedcircle}"></c:out>"/>
						</c:when>
						<c:otherwise>
						<input type="hidden" class="form-control"  id="hiddencircleId" name="hiddencircleId" value="0"/>
						</c:otherwise>
						</c:choose>
							<label class="label-controlPMS rowlebel ">Select Circle</label>
							<select class="form-control" id="circleId"  name="circleId" onchange="getDivisions(this.value)">
							
							

							</select>
						</div>
						
						<div class="col-md-2" id="hidediv">
						<c:choose>
						<c:when test="${selecteddivision!=null}">
						 <input type="hidden" class="form-control"  id="hiddendivisionId" name="hiddendivisionId" value="<c:out value="${selecteddivision}"></c:out>"/>
						 </c:when>
						<c:otherwise>
						<input type="hidden" class="form-control"  id="hiddendivisionId" name="hiddendivisionId" value="0" />
						</c:otherwise>
						</c:choose>
						
							<label class="label-controlPMS rowlebel ">Select Division</label>
							<select class="form-control" id="divisionId"  name="divisionId" onchange="getSubDivisions(this.value),getEEList(this.value);">
							
							


							</select>
						</div>
						
						<div class="col-md-2" id="hidesubdiv">
						<c:choose>
						<c:when test="${selectedsubdivision!=null}">
						 <input type="hidden" class="form-control"  id="hiddensubdivisionId" name="hiddensubdivisionId" value="<c:out value="${selectedsubdivision}"></c:out>"/>
						  </c:when>
						<c:otherwise>
						 <input type="hidden" class="form-control"  id="hiddensubdivisionId" name="hiddensubdivisionId" value="0"/>
						 </c:otherwise>
						 </c:choose>
						
							<label class="label-controlPMS rowlebel ">Select SubDivision</label>
							<select class="form-control" id="subdivisionId"  name="subdivisionId" >
							<option value="0">--select--</option>
							



							</select>
						</div>
						
						<div class="col-md-2" id="hidesubdiv">
						<c:choose>
						<c:when test="${selectedsubdivision!=null}">
						 <input type="hidden" class="form-control"  id="hiddensubdivisionId" name="hiddensubdivisionId" value="<c:out value="${selectedsubdivision}"></c:out>"/>
						  </c:when>
						<c:otherwise>
						 <input type="hidden" class="form-control"  id="hiddensubdivisionId" name="hiddensubdivisionId" value="0"/>
						 </c:otherwise>
						 </c:choose>
						
							<label class="label-controlPMS rowlebel ">Select Designation</label>
							<select class="form-control" id="designationId"  name="designationId" >
							<option value="0">--select--</option>
							
							 <c:forEach items="${designationList}" var="u">
						
						  <c:choose>
						  
								 <c:when test="${u.designationId==selecteddesignation}">
									<option value="${u.designationId}" selected="selected">${u.designationName}</option>
									</c:when>
									
									<c:otherwise>
									<option value="${u.designationId}" >${u.designationName}</option>
									</c:otherwise>
									</c:choose>
									
									
									

								</c:forEach>  
							
							



							</select>
						</div>
						
						</div>
						
						<div class="row show-grid">
						<div class="col-md-5"></div>
						<div class="col-md-2">
						
						<label class="label-control rowlebel "></label><input
								type="submit" class="btn btn-1 btn-primary center-block"
								id="addeditdata" value="Submit"  >
						
						</div>
						<div class="col-md-5"></div>
						
						</div>
					
						</c:if>
						
					
						
						
					
						
						
						
					
						
					
													
											
						
						
	




					

				
						
							
					
						
						
						
					
				
				





			
</div>

			</div>
			</form:form>

		</div>
		
	



<!-- create component ends here -->


					
		
					
			
				
		
		

	 
	 
	 
	 
</div>
<!-- //main-content -->
 <script type="text/javascript" src="../js/parsley.js"></script>



    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#editEmpData').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    edit
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  
			 
				
			  document.forms.editEmpData.action="../task/editEmpData";
				 document.forms.editEmpData.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

 