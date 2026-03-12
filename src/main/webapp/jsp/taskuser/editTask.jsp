
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
	
	$('#hidediv').hide();
	$('#hidesubdiv').hide();
	$('#hideeid').hide();
	$('#hidedeeid').hide();
	$('#hideaeeid').hide();
	$('#hidseid').hide();
	$('#resunitList').show();
	
	

	$('#unitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#projectId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#packageId').multiselect({
		 
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

$('#taskTypeId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#priorId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#statusId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#responsibleEmpId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

 $('#responsibleSEEmpId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
}); 

$('#responsibleEEEmpId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
}); 

 $('#responsibleDEEEmpId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
}); 
 
 $('#responsibleAEEEmpId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
}); 
 $('#responsibleAEEId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});
 





});

	 
	  
			




function getProjects(unitId){
	
	 
    var   unitId=unitId;
      
  //  alert("procId"+procId);
	$('#projectId').multiselect('rebuild');


	$.ajax({	          
	      url: "../task/getProjects?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	    	  var $select = $('#projectId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#projectId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						
	  						
	  					$('#projectId').append( '<option value="'+value.projectId+'"> '+value.projectName+'</option>' );
	  					
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

function getPackages(projectId){
	
	 
    var   projectId=projectId;
      
  //  alert("procId"+procId);
	$('#packageId').multiselect('rebuild');


	$.ajax({	          
	      url: "../task/getPackages?projectId="+projectId,
	      type: "GET",
	      success: function (response) {
	    	  var $select = $('#packageId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#packageId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						
	  						
	  					$('#packageId').append( '<option value="'+value.pkgId+'"> '+value.pkgName+'</option>' );
	  					
	  				$('#packageId').multiselect('rebuild')
	  				
	  				
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

	
	
	
	
	function getSEList(circleId){
		$('#hidseid').show();
	//	$('#resunitList').hide();
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var circleId=circleId;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../task/getSEList?circleId="+circleId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	 // var $select = $('#responsibleSEId');
	    	 
			 // $select.find('option').remove();
			  
			/*   var n =$('#hiddenresSEId').val();
			  
			  //alert("n"+n);

				var t=0;
				if(n!=null){
					if(n>0){
						t=parseInt(n);
					}
					
				} */
			  
			 
			
			 
					var obj = JSON.parse(response);
					  //$('#responsibleSEId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						
						
						
						$('#responsibleSEName').val(value.responsibleEmpName);
						$('#hiddenresSEId').val(value.responsibleEmpId);
						
						
						/* if( Boolean(n)){
						if(value.responsibleEmpId==t){
							$('#responsibleSEId').append( '<option value="'+value.responsibleEmpId+'" selected="selected" > '+value.responsibleEmpName+'</option>' );
							
						}
						
						if(value.responsibleEmpId!=t){
							
							$('#responsibleSEId').append( '<option value="'+value.responsibleEmpId+'" disabled="disabled" > '+value.responsibleEmpName+'</option>' );
						}
						}
						if( !Boolean(n)){
							
							$('#responsibleSEId').append( '<option value="'+value.responsibleEmpId+'"  > '+value.responsibleEmpName+'</option>' );
							
						}
						
						
	  	  				$('#responsibleSEId').multiselect('rebuild'); */
					
	  	  				
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getEEList(divisionId){
		$("#hideeid").show();
		//$('#resunitList').hide();
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var divisionId=divisionId;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../task/getEEList?divisionId="+divisionId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	//  var $select = $('#responsibleEEId');
	    	 
			/*   $select.find('option').remove();
  var k =$('#hiddenresEEId').val();
			  
			 // alert("k"+k);

				var t=0;
				if(k!=null){
					if(k>0){
						t=parseInt(k);
					}
					
				}
			   */
			  
			 
			
			 
					var obj = JSON.parse(response);
					 // $('#responsibleEEId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						$('#responsibleEEName').val(value.responsibleEmpName);
						$('#hiddenresEEId').val(value.responsibleEmpId);
						
						
						/* if( Boolean(k)){
							if(value.responsibleEmpId==t){
						
							$('#responsibleEEId').append( '<option value="'+value.responsibleEmpId+'" selected="selected" > '+value.responsibleEmpName+'</option>' );
					      
							}
							
							if(value.responsibleEmpId!=t){
								$('#responsibleEEId').append( '<option value="'+value.responsibleEmpId+'" disabled="disabled" > '+value.responsibleEmpName+'</option>' );
							}
						}
						if( !Boolean(k)){
							$('#responsibleEEId').append( '<option value="'+value.responsibleEmpId+'" > '+value.responsibleEmpName+'</option>' );
							
							}
	  	  				$('#responsibleEEId').multiselect('rebuild'); */
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getDEEList(subdivisionId){
		$('#hidedeeid').show();
		//$('#resunitList').hide();
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var subdivisionId=subdivisionId;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../task/getDEEList?subdivisionId="+subdivisionId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	 // var $select = $('#responsibleDEEId');
	    	 
			  /* $select.find('option').remove();
			  
 var l =$('#hiddenresDEEId').val();
			  
			 // alert("l"+l);

				var t=0;
				if(l!=null){
					if(l>0){
						t=parseInt(l);
					}
					
				} */
			
			 
					var obj = JSON.parse(response);
					//  $('#responsibleDEEId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						$('#responsibleDEEName').val(value.responsibleEmpName);
						$('#hiddenresDEEId').val(value.responsibleEmpId);
						
						/* if( Boolean(l)){
							if(value.responsibleEmpId==t){
						
							$('#responsibleDEEId').append( '<option value="'+value.responsibleEmpId+'"  selected="selected"> '+value.responsibleEmpName+'</option>' );
					
}
							
							if(value.responsibleEmpId!=t){
								
								$('#responsibleDEEId').append( '<option value="'+value.responsibleEmpId+'"  disabled="disabled"> '+value.responsibleEmpName+'</option>' );
								
								
								
							}
						}
						if( !Boolean(l)){
							
							$('#responsibleDEEId').append( '<option value="'+value.responsibleEmpId+'" > '+value.responsibleEmpName+'</option>' );
						}
							
	  	  				$('#responsibleDEEId').multiselect('rebuild'); */
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}

	
	
	
	function getAEEList(subdivisionId){
		
		$('#hideaeeid').show();
		//$('#resunitList').hide();
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var subdivisionId=subdivisionId;
		//alert("AEE"+subdivisionId);
	
		  $.ajax({	          
	      url: "../task/getAEEList?subdivisionId="+subdivisionId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#responsibleAEEId');
	    	 
			   $select.find('option').remove();
			  
 
			 
					var obj = JSON.parse(response);
					  $('#responsibleAEEId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						
						
						
					
						
							$('#responsibleAEEId').append( '<option value="'+value.responsibleEmpId+'"  selected="selected"> '+value.responsibleEmpName+'</option>' );
					

						
							
	  	  				$('#responsibleAEEId').multiselect('rebuild'); 
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}

	
	
	
	

 


 /* function addpackage()
 {	
 	  	var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
 	  	var url="../task/packages";
 	  	
 		popup =window.open(url,"_blank",features);
 } */
 
 function addEmployee()
 {	
 	  	var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
 	  	var url="../task/addEmp";
 	  	
 		popup =window.open(url,"_blank",features);
 }
 

	
 
 $(function() {
		
		$("#assignedDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		

		$("#targetDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		

		var a=parseInt($("#unitId").val()); 
		if(a>0){
			//alert("a"+a);
			getProjects(a);
			getCircles(a);
			
			
		}
		
		/*  var b=parseInt($("#projectId").val()); 
		if(b>0){
			alert("b"+b);
			getPackages(b);
			
			
		} */
		 
		 
		 var c=parseInt($("#hiddencircleId").val()); 
		// alert(c+"c")
		if(c>0){
			
		//	alert("c"+c);
			getDivisions(c);
			getSEList(c);
			
			
			
			
		}else {
			
			$("#hidediv").hide();
			$("#hideeid").hide();
			
		}
		
		var d=parseInt($("#hiddendivisionId").val()); 
		if(d>0){
			
			getSubDivisions(d);
			getEEList(d);
			
			
		}
		
		var e=parseInt($("#hiddensubdivisionId").val()); 
		if(e>0){
			
			getDEEList(e);
			getAEEList(e);
			
		}
		
		
		
var f=parseInt($("#officeType").val())
		
		if(f==2||f==3){
			$("#resunitList").show();
			$("#sectionList").hide();
			$('#hidseid').hide();
			$('#hideeid').hide();
			$('#hidedeeid').hide();
			$('#hideaeeid').hide();
			
			
			
		}
		
		if(f==1){			
			$("#resunitList").hide();
			$("#sectionList").show();
			 $('#hidseid').show();
				$('#hideeid').show();
				$('#hidedeeid').show();
				$('#hideaeeid').show();
			
			
		}
		
		$( ".ot" ).change(function() {
			 var m= parseInt(this.value);
			 
			// alert("m"+m);
			 
			 if(m==2||m==3){
				// alert("i am in 23")
					$("#resunitList").show();
				 $("#sectionList").hide();
				 $('#hidseid').hide();
					$('#hideeid').hide();
					$('#hidedeeid').hide();
					$('#hideaeeid').hide();
					
					
				}
				
				if(m==1){	
					//alert("i am in 1")
					$("#resunitList").hide();
					$("#sectionList").show();
					 $('#hidseid').show();
						$('#hideeid').show();
						$('#hidedeeid').show();
						$('#hideaeeid').show();
					
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
			<h3 class="panel-title">
				Edit Task =====>


				<c:if test="${userObj!=null}">

					<c:if
						test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">
						<c:if test="${userObj.unitId>0  }">
							<c:out value="${userObj.unitName}"></c:out>
						</c:if>
					</c:if>

					<c:if
						test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">
						<c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">
							<c:out value="${userObj.circleName}"></c:out>
						</c:if>
					</c:if>

					<c:if
						test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId==0 }">
						<c:if
							test="${userObj.unitId>0  &&  userObj.circleId>0  &&  userObj.divisionId>0 }">
							<c:out value="${userObj.divisionName}"></c:out>
						</c:if>
					</c:if>

					<c:if
						test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId!=0 }">
						<c:if
							test="${userObj.unitId>0 &&  userObj.circleId>0  &&  userObj.divisionId>0 &&  userObj.subdivisionId>0  }">
							<c:out value="${userObj.subdivisionName}"></c:out>
						</c:if>
					</c:if>

					<c:if
						test="${userObj.unitId==null && userObj.circleId==null && userObj.divisionId==null && userObj.subdivisionId==null }">

						<c:out value="${userObj.userName}"></c:out>

					</c:if>
				</c:if>
			</h3>


		</div>


		<form:form id="taskinput" method="post" modelAttribute="taskinput"
			data-parsley-validate-if-empty="" enctype="multipart/form-data">







			<div class="col-md-12" id="hidseid">
				<label class="label-control rowlebel ">SE</label> <input type="text"
					class="form-control bluetext" id="responsibleSEName"
					name="responsibleSEName" value="0" readonly="readonly" /> <input
					type="hidden" class="form-control" id="hiddenresSEId"
					name="hiddenresSEId" value="0" />

			</div>
			<div class="col-md-12" id="hideeid">
				<label class="label-control rowlebel ">EE</label> <input type="text"
					class="form-control bluetext" id="responsibleEEName"
					name="responsibleEEName" value="0" readonly="readonly" /> <input
					type="hidden" class="form-control" id="hiddenresEEId"
					name="hiddenresEEId" value="0" />

			</div>

			<div class="col-md-12" id="hidedeeid">
				<label class="label-control rowlebel ">DEE</label> <input
					type="text" class="form-control bluetext" id="responsibleDEEName"
					name="responsibleDEEName" value="0" readonly="readonly" /> <input
					type="hidden" class="form-control" id="hiddenresDEEId"
					name="hiddenresDEEId" value="0" />

			</div>

			<!-- 	<div class="col-md-12" id="hideaeeid" >
							<label class="label-control rowlebel ">Responsible AEE</label> 
							<input type="text" class="form-control"  id="responsibleAEEId" name="responsibleAEEId" value="" readonly="readonly"  />
							<input type="hidden" class="form-control"  id="hiddenresAEEId" name="hiddenresAEEId" value=""/>
							
							</div> -->








			<div class="col-md-12">
				<div class="alert alert-primary" role="alert">
					<div class="col-md-12"></div>
					<strong>Note: Please Select Unit office/ Circle Office to
						Assign the Task to Unit Office /Circle Office Staff </strong>

				</div>
				<div class="col-md-6">
					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Unit *</label>
					</div>
					<div class="col-md-6">
						<c:if test="${selectedunit!=null }">
							<select class="form-control" id="unitId" name="unitId"
								onchange="getProjects(this.value),getCircles(this.value),getSEList(this.value);"
								required>
								<option value="0">--select --</option>
								<c:forEach items="${unitList}" var="u">

									<c:choose>

										<c:when test="${u.unitId==selectedunit}">
											<option value="${u.unitId}" selected="selected">${u.unitName}</option>
										</c:when>

										<c:otherwise>
											<option value="${u.unitId}">${u.unitName}</option>
										</c:otherwise>
									</c:choose>




								</c:forEach>


							</select>
						</c:if>
						<c:if test="${selectedunit==null }">
							<select class="form-control" id="unitId" name="unitId"
								onchange="getProjects(this.value),getCircles(this.value),getSEList(this.value);"
								required>
								<option value="0">--select --</option>
								<c:forEach items="${unitList}" var="u">



									<option value="${u.unitId}">${u.unitName}</option>




								</c:forEach>


							</select>
						</c:if>
					</div>


					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Project</label>
					</div>
					<div class="col-md-6">
						<select class="form-control" id="projectId" name="projectId"
							onchange="getPackages(this.value)">


						</select>


					</div>

					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Package</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" id="packageId" name="packageId">




						</select>


					</div>



					<div class="col-md-3">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="addnewpack" value="Add Package" onclick="addPack()">

					</div>
					
					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Task Type</label>
					</div>


					<div class="col-md-6">
						<select class="form-control" id="taskTypeId" name="taskTypeId"
							required>

							<c:forEach items="${ttList}" var="u">
								<c:choose>
									<c:when test="${u.taskTypeId==tasktypeId}">
										<option value="${u.taskTypeId}" selected="selected">${u.taskTypeName}</option>
									</c:when>
									<c:otherwise>
										<option value="${u.taskTypeId}">${u.taskTypeName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>

						</select>

					</div>
					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Priority </label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="priorId" name="priorId" required>
							<c:forEach items="${tpList}" var="u">
								<c:choose>
									<c:when test="${u.priorId==priority}">

										<option value="${u.priorId}" selected="selected">${u.priorName}</option>
									</c:when>
									<c:otherwise>
										<option value="${u.priorId}">${u.priorName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>


						</select>

					</div>






					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Status</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="statusId" name="statusId"
							required>
							<c:forEach items="${tsList}" var="u">
								<c:choose>
									<c:when test="${u.statusId==statusId}">
										<option value="${u.statusId}">${u.statusName}</option>
									</c:when>
									<c:otherwise>
										<option value="${u.statusId}">${u.statusName}</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>



						</select>
					</div>
							<div class="col-md-6">

						<label class="label-control rowlebel ">Assigned Date</label>

					</div>

					<div class="col-md-6">
						<c:choose>
							<c:when test="${assignDate!=null}">
								<input type="text" class="form-control datepicker"
									id="assignedDate" name="assignedDate" placeholder="dd/mm/yyyy"
									required value='<c:out value="${assignDate}"></c:out>' />
							</c:when>
							<c:otherwise>
								<input type="text" class="form-control datepicker"
									id="assignedDate" name="assignedDate" placeholder="dd/mm/yyyy"
									required />

							</c:otherwise>
						</c:choose>
					</div>

					<div class="col-md-6">

						<label class="label-control rowlebel ">Target Date</label>

					</div>

					<div class="col-md-6">

						<c:choose>
							<c:when test="${targetDate!=null}">
								<input type="text" class="form-control datepicker"
									id="targetDate" name="targetDate" placeholder="dd/mm/yyyy"
									required value='<c:out value="${targetDate}"></c:out>' />
							</c:when>
							<c:otherwise>
								<input type="text" class="form-control datepicker"
									id="targetDate" name="targetDate" placeholder="dd/mm/yyyy"
									required />

							</c:otherwise>
						</c:choose>
					</div>


				</div>
				<div class="col-md-6">
				
					<div class="col-md-12">

						<label class="label-control rowlebel ">Issue/Subject</label>
						<c:choose>
							<c:when test="${Subject!=null}">
								<textarea class="form-control" id="subject" name="subject"
									placeholder="Issue/Subject" required rows="4" cols="80"><c:out
										value="${Subject}"></c:out></textarea>
							</c:when>
							<c:otherwise>
								<textarea class="form-control" id="subject" name="subject"
									placeholder="Issue/Subject" required rows="4" cols="80"></textarea>


							</c:otherwise>
						</c:choose>
					</div>

					<div class="col-md-12">

						<label class="label-control rowlebel ">Remarks</label>
						<c:choose>
							<c:when test="${Remarks!=null}">
								<textarea class="form-control" id="remarks" name="remarks"
									placeholder="Remarks" required rows="4" cols="80"><c:out
										value="${Remarks}"></c:out></textarea>
							</c:when>
							<c:otherwise>
								<textarea class="form-control" id="remarks" name="remarks"
									placeholder="Remarks" required rows="4" cols="80"></textarea>

							</c:otherwise>
						</c:choose>

					</div>
					
				
					
					
					<div class="col-md-6">

						<label class="label-control rowlebel ">Upload
							Multiple/Single File</label>
					</div>

					<div class="col-md-6">

						<input type="file" id="upfile" name="upfile" multiple="multiple" />
					</div>
					</div>
				
			</div>




			
		
	
	             <div class="col-md-12" >
	              <br></br>
	             
	            
	             <div class="col-md-12">
	              <div class="col-md-2"></div>
						<c:choose>

							<c:when test="${officeType==1  }">
								<label class="radio-inline"> <input class="ot"
									type="radio" name="officeType" id="officeType"
									checked="checked" value="1"> <strong>None</strong></label>
							</c:when>
							<c:otherwise>
								<label class="radio-inline"> <input class="ot"
									type="radio" name="officeType" id="officeType" value="1">
									<strong>None</strong></label>


							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${officeType==2 }">
								<label class="radio-inline"> <input class="ot"
									type="radio" name="officeType" id="officeType"
									checked="checked" value="2"> <strong>Unit
										Office</strong></label>
							</c:when>
							<c:otherwise>
								<label class="radio-inline"> <input class="ot"
									type="radio" name="officeType" id="officeType" value="2">
									<strong>Unit Office</strong></label>


							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${officeType==3 }">
								<label class="radio-inline"> <input class="ot"
									type="radio" name="officeType" id="officeType"
									checked="checked" value="3"> <strong>Circle
										Office</strong></label>
							</c:when>
							<c:otherwise>
								<label class="radio-inline"> <input class="ot"
									type="radio" name="officeType" id="officeType" value="3">
									<strong>Circle Office</strong></label>

							</c:otherwise>
						</c:choose>
						 <div class="col-md-2"></div>
					</div>

				<div class="col-md-6" id="sectionList">


					<div class="col-md-6">
						<c:choose>
							<c:when test="${selectedcircle!=null}">
								<input type="hidden" class="form-control" id="hiddencircleId"
									name="hiddencircleId"
									value="<c:out value="${selectedcircle}"></c:out>" />
							</c:when>
							<c:otherwise>
								<input type="hidden" class="form-control" id="hiddencircleId"
									name="hiddencircleId" value="0" />
							</c:otherwise>
						</c:choose>
						<label class="label-controlPMS rowlebel ">Select Circle</label>
					</div>
					<div class="col-md-6">
						<select class="form-control" id="circleId" name="circleId"
							onchange="getDivisions(this.value),getSEList(this.value);">



						</select>
					</div>



					<div class="col-md-6">
						<c:choose>
							<c:when test="${selecteddivision!=null}">
								<input type="hidden" class="form-control" id="hiddendivisionId"
									name="hiddendivisionId"
									value="<c:out value="${selecteddivision}"></c:out>" />
							</c:when>
							<c:otherwise>
								<input type="hidden" class="form-control" id="hiddendivisionId"
									name="hiddendivisionId" value="0" />
							</c:otherwise>
						</c:choose>

						<label class="label-controlPMS rowlebel ">Select Division</label>
					</div>
					<div class="col-md-6">
						<select class="form-control" id="divisionId" name="divisionId"
							onchange="getSubDivisions(this.value),getEEList(this.value);">




						</select>

					</div>

					<div class="col-md-6">
						<c:choose>
							<c:when test="${selectedsubdivision!=null}">
								<input type="hidden" class="form-control"
									id="hiddensubdivisionId" name="hiddensubdivisionId"
									value="<c:out value="${selectedsubdivision}"></c:out>" />
							</c:when>
							<c:otherwise>
								<input type="hidden" class="form-control"
									id="hiddensubdivisionId" name="hiddensubdivisionId" value="0" />
							</c:otherwise>
						</c:choose>

						<label class="label-controlPMS rowlebel ">Select
							SubDivision</label>
					</div>
					<div class="col-md-6">
						<select class="form-control" id="subdivisionId"
							name="subdivisionId"
							onchange="getDEEList(this.value),getAEEList(this.value);">
							<option value="0">--select--</option>




						</select>
					</div>



					<div class="col-md-6">
						<!-- <input type="hidden" class="form-control"  id="hiddenresAEEId" name="hiddenresAEEId" value="0"/> -->
						<label class="label-controlPMS rowlebel ">Select AEE / AE</label>
					</div>
					<div class="col-md-6">

						<select class="form-control bluetext" id="responsibleAEEId"
							name="responsibleAEEId">
							<option value="0">--select--</option>



						</select>
					</div>
				</div>
				<div class="col-md-6" id="resunitList">
					<c:if test="${ resSeList!=null}">
						<div class="col-md-6">

							<label class="label-controlPMS rowlebel "> SE</label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="responsibleSEEmpId"
								name="responsibleSEEmpId">
								<option value="0">select</option>
								<c:forEach items="${resSeList}" var="u">
									<option value="${u.responsibleEmpId}">${u.responsibleEmpName}</option>

								</c:forEach>


							</select>

						</div>
					</c:if>


					<c:if test="${resEeList!=null}">
						<div class="col-md-6">

							<label class="label-controlPMS rowlebel "> EE</label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="responsibleEEEmpId"
								name="responsibleEEEmpId">
								<option value="0">select</option>
								<c:forEach items="${resEeList}" var="u">
									<option value="${u.responsibleEmpId}">${u.responsibleEmpName}</option>

								</c:forEach>


							</select>
						</div>
					</c:if>
					
					<c:if test="${resDeeList!=null}">
					<div class="col-md-6">

						<label class="label-controlPMS rowlebel "> DEE</label>
					</div>
					<div class="col-md-6">
						<select class="form-control" id="responsibleDEEEmpId"
							name="responsibleDEEEmpId">
							<option value="0">select</option>
							<c:forEach items="${resDeeList}" var="u">
								<option value="${u.responsibleEmpId}">${u.responsibleEmpName}</option>

							</c:forEach>


						</select>
					</div>
				</c:if>
				<c:if test="${resAeeList!=null}">
					<div class="col-md-6">

						<label class="label-controlPMS rowlebel "> AEE</label>
					</div>

					<div class="col-md-6">

						<select class="form-control" id="responsibleAEEEmpId"
							name="responsibleAEEEmpId">
							<option value="0">select</option>
							<c:forEach items="${resAeeList}" var="u">
								<option value="${u.responsibleEmpId}">${u.responsibleEmpName}</option>

							</c:forEach>


						</select>
					</div>
				</c:if>

					



				</div>
			</div>

		
	
	
				<div class="col-md-12">

					



				</div>


			


			<div class="row show-grid">
				<div class="col-md-10 ">
					<label class="label-control rowlebel "></label>
					<c:choose>
						<c:when test="${taskId!=null }">
							<input type="hidden" class="form-control" id="taskId"
								name="taskId" value='<c:out value="${taskId}"></c:out>' />
						</c:when>
						<c:otherwise>
							<input type="hidden" class="form-control" id="taskId"
								name="taskId" />
						</c:otherwise>
					</c:choose>
					<input type="submit" class="btn btn-1 btn-primary center-block"
						id="addtask" value="Edit Task">
				</div>
			</div>
		</form:form>

	</div>

</div>





<!-- create component ends here -->
















<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>





<script type="text/javascript" class="example">
$(function () {
	 $('#taskinput').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  
			 
				
			  document.forms.taskinput.action="../task/editTask";
				 document.forms.taskinput.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

