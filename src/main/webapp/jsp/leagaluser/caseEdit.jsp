	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 
 
<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
 
 
 
 <script type="text/javascript">
var tableToExcel = (function() {
  var uri = 'data:application/vnd.ms-excel;base64,'
    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office"<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
    , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
  return function(table, name) {
    if (!table.nodeType) table = document.getElementById(table);
    var ctx = {worksheet:  'Worksheet', table: table.innerHTML};
    window.location.href = uri + base64(format(template, ctx));
  }
})()
</script>
 

<script>
$(document).ready(function(){

	$('#caseId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#parentcaseId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#caseStageId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#caseStatusId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	
	
	
	
	$('#caseTypeOrderId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	
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
	
	$('#projectId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#packageId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#caseGenSubId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#caseGenId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	$('#caseTypeId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	
	
	
	
	
	
	
	
	
	
	
	

	$('#OrderIdla').hide();
	$('#OrderIdin').hide();
	$('#OrderIdlada').hide();
	$('#OrderIdinda').hide();
	$('#OrderIdlain').hide();
	$('#OrderIdlaup').hide();
	

	
	
	
	
	
	
	$('#parentcasela').hide();
	$('#parentcaseopt').hide();
	  $('#unit').hide();
	   
	
	
	 $('input[type=radio][name=isChildCase]').change(function() {
	        if (this.value == '1') {
	        	$('#parentcasela').show();
	        	$('#parentcaseopt').show();
	        }
	        else if (this.value == '2') {
	        	$('#parentcasela').hide();
	        	$('#parentcaseopt').hide();
	        }
	    });
	

	
	  
	  
			
});

function loadedit(){
	  
	   
	   $('#caseWpNumber').attr('readonly', false);
	   $('#caseYear').attr('readonly', false);
	  
	   $('#briefPrayer').attr('readonly', false);
	  
	   $('#petOthers').attr('readonly', false);
	   $('#resOthers').attr('readonly', false);
	   $('#caseStageId').attr('readonly', false);
	   $('#caseStatusId').attr('readonly', false);
	   $('#remarks').attr('readonly', false);
	   
	   $('#caseEdit2').val(true);
	   $('#unit').show();
	   
	   
		
	   
	   
	   
	 
	
	 
}
   
  





function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    //var originalContents = document.body.innerHTML;

   // document.body.innerHTML = printContents;
    document.body.innerHTML = '<link href="./I and CAD  Court Cases Monitoring System_files/bootstrap.min.css" rel="stylesheet" type="text/css"  media="print"><link rel="stylesheet" href="./I and CAD Court Cases Monitoring System_files/custom.css" type="text/css"  media="print"><body>';
    document.body.innerHTML += printContents+'</body>';
  //  alert(document.body.innerHTML);
    //alert(printContents);
    window.print();
    window.close();
    

   // document.body.innerHTML = originalContents;
}

//start




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
	  				
	  				 var n =$('#hiddenprojectId').val();

		 				var t=0;
		 				if(n!=null){
		 					if(n>0){
		 						t=parseInt(n);
		 					}
		 					
		 				}
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#projectId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  					if(value.projectId==t){	
	  						
	  					$('#projectId').append( '<option value="'+value.projectId+'" selected="selected"> '+value.projectName+'</option>' );
	  					
	  					}
	  					if(value.projectId!=t||t==0){
	  						
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

function getPackages(projectId) {

	var projectId =projectId ;
		
		//$('#projectId').val();

	//  alert("procId"+procId);
	$('#packageId').multiselect('rebuild');

	$.ajax({
		url : "../web/getPackages?projectId=" + projectId,
		type : "GET",
		success : function(response) {
			var $select = $('#packageId');
			$select.find('option').remove();
			
			var selectedpackageId= $('#hiddenpackageId').val();

		//	alert("selectedpackageId"+selectedpackageId);
			var obj = JSON.parse(response);
			
			

			$('#packageId')
					.append('<option value="0"> --select--</option>');

			$.each(obj, function(key, value) {
				
				if(value.pkgId==selectedpackageId){	

				$('#packageId').append(
						'<option value="'+value.pkgId+'" selected="selected"> ' + value.pkgName
								+ '</option>');
				}
				
				if(value.pkgId!=selectedpackageId || selectedpackageId==null ){	

					$('#packageId').append(
							'<option value="'+value.pkgId+'"> ' + value.pkgName
									+ '</option>');
					}

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
		error : function() {
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
			
			 
			  $('#mandalId').append( '<option value="0"> --select--</option>' );
					var obj = JSON.parse(response);
					$.each(obj, function(key, value) {
						
							$('#mandalId').append( '<option value="'+value.mandalId+'"  > '+value.mandalName+'</option>' );
						
		  					
	  	  				$('#mandalId').multiselect('rebuild');
					});

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 

	function getVillages(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var mandalId=document.getElementById("mandalId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getVillages?mandalId="+mandalId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#villageId');
	    	 
			  $select.find('option').remove();
			  
			  var n =$('#hiddenvillageId').val();

				var t=0;
				if(n!=null){
					if(n>0){
						t=parseInt(n);
					}
					
				}
			 
			
			 
					var obj = JSON.parse(response);
					  $('#villageId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(value.villageId==t){
						
							$('#villageId').append( '<option value="'+value.villageId+'" selected="selected" > '+value.villageName+'</option>' );
						}
						if(value.villageId!=t){
							
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
	
	
	function getCircles(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var unitId=document.getElementById("unitId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getCircles?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#circleId');
	    	 
			  $select.find('option').remove();
			  
			  var n =$('#hiddencircleId').val();

				var t=0;
				if(n!=null){
					if(n>0){
						t=parseInt(n);
					}
					
				}
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#circleId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(value.circleId==t){
							$('#circleId').append( '<option value="'+value.circleId+'" selected="selected" > '+value.circleName+'</option>' );
							
						}
						
						if(value.circleId!=t||t==0){
							$('#circleId').append( '<option value="'+value.circleId+'" > '+value.circleName+'</option>' );
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
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var circleId=circleId
			//document.getElementById("circleId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getDivisions?circleId="+circleId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#divisionId');
	    	 
			  $select.find('option').remove();
			  
			  var n =$('#hiddendivisionId').val();

				var t=0;
				if(n!=null){
					if(n>0){
						t=parseInt(n);
					}
					
				}
			
			 
					var obj = JSON.parse(response);
					  $('#divisionId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(value.divisionId==t){
						
							$('#divisionId').append( '<option value="'+value.divisionId+'"   selected="selected"> '+value.divisionName+'</option>' );
						}
						
						if(value.divisionId!=t||t==0){
							
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
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var divisionId=divisionId ;
			//document.getElementById("divisionId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getSubDivisions?divisionId="+divisionId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#subdivisionId');
	    	 
			  $select.find('option').remove();
			  
			  var n =$('#hiddensubdivisionId').val();
			  
			 // alert("n"+n);

				var t=0;
				if(n!=null){
					if(n>0){
						t=parseInt(n);
					}
					
				}
			 
			
			 
					var obj = JSON.parse(response);
					  $('#subdivisionId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(value.subdivisionId==t){
						
							$('#subdivisionId').append( '<option value="'+value.subdivisionId+'" selected="selected" > '+value.subdivisionName+'</option>' );
						}
						if(value.subdivisionId!=t){
							
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

	
	function getCaseTypes(courtId){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var courtId=courtId ;
			//document.getElementById("courtId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getCaseTypes?courtId="+courtId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#caseTypeId');
	    	 
			  $select.find('option').remove();
			  
			 
			  var n =$('#hiddencaseTypeId').val();

				var t=0;
				if(n!=null){
					if(n>0){
						t=parseInt(n);
					}
					
				}
			
			 
					var obj = JSON.parse(response);
					
					
					  $('#caseTypeId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(value.caseTypeId==t){
						
							$('#caseTypeId').append( '<option value="'+value.caseTypeId+'"  selected="selected"> '+value.caseType+'</option>' );
						}
						if(value.caseTypeId!=t || t==0){
							
							$('#caseTypeId').append( '<option value="'+value.caseTypeId+'" > '+value.caseType+'</option>' );
						}
	  	  				$('#caseTypeId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}	 
	
	function getCaseGenSub(caseGenId){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var caseGenId=caseGenId ;
			//document.getElementById("caseGenId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getCaseGenSub?caseGenId="+caseGenId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#caseGenSubId');
	    	 
			  $select.find('option').remove();
			  
			  var n =$('#hiddencaseGenSubId').val();

				var t=0;
				if(n!=null){
					if(n>0){
						t=parseInt(n);
					}
					
				}
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#caseGenSubId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(value.caseGenSubId==t){
						
							$('#caseGenSubId').append( '<option value="'+value.caseGenSubId+'"  selected="selected"> '+value.caseGenSubName+'</option>' );
						}
						
						if(value.caseGenSubId!=t || t==0){
							
							$('#caseGenSubId').append( '<option value="'+value.caseGenSubId+'" > '+value.caseGenSubName+'</option>' );
						}
						
	  	  				$('#caseGenSubId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}	  
	




//end functions on change




 
function getCaseTypeOrders(caseStageId){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var caseStageId=caseStageId;
			
			//document.getElementById("caseStageId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getCaseTypeOrders?caseStageId="+caseStageId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#caseTypeOrderId');
	    	 
			  $select.find('option').remove();
			  
			 
			var n =$('#hiddenOrderId').val();

			var t=0;
			if(n!=null){
				if(n>0){
					t=parseInt(n);
				}
				
			}
			
			 
					var obj = JSON.parse(response);
					  $('#caseTypeOrderId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(value.caseTypeOrderId==t){
							$('#caseTypeOrderId').append( '<option value="'+value.caseTypeOrderId+'"   selected="selected"> '+value.caseTypeOrder+'</option>' );
						}
						if(value.caseTypeOrderId!=t || t==0){
							$('#caseTypeOrderId').append( '<option value="'+value.caseTypeOrderId+'" > '+value.caseTypeOrder+'</option>' );
						}
	  	  				$('#caseTypeOrderId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getOrderList(){
		
		var caseStageId=parseInt(document.getElementById("caseStageId").value);
		//alert("caseStageId"+caseStageId);
		if(caseStageId>0 && caseStageId==13){
			//alert("cm")
			$('#OrderIdla').show();
			$('#OrderIdin').show();
			$('#OrderIdlada').show();
			$('#OrderIdinda').show();
			$('#OrderIdlaup').show();
			$('#OrderIdlain').show();
			
			
			
			
			
			
			
			
	
		  getCaseTypeOrders(caseStageId);}
		else {
			//alert("nccm")
			
			$('#OrderIdla').hide();
			$('#OrderIdin').hide();
			$('#OrderIdlada').hide();
			$('#OrderIdinda').hide();
			$('#OrderIdlain').hide();
			$('#OrderIdlaup').hide();
			
			
			
			
			
			
			
			
		}
		
	}
 
$(function() {
	
	$("#filingDate").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	

	$("#counterDate").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	

	$("#judgementDate").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	$("#draftdateconttoGP").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	$("#orderDate").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	$("#hearingDate").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	
	var m =parseInt($("#caseStageId").val());
	if(m==13){
		
		$("#OrderIdla").show();
		$("#OrderIdin").show();
		$("#OrderIdlada").show();
		$("#OrderIdinda").show();
		$("#OrderIdlain").show();
		$("#OrderIdlaup").show();
		getCaseTypeOrders(m);
	}else {
		$("#OrderIdla").hide();
		$("#OrderIdin").hide();
		$("#OrderIdlada").hide();
		$("#OrderIdinda").hide();
		$("#OrderIdlain").hide();
		$("#OrderIdlaup").hide();
		
		
		
		
		
		
		
	}
	
	var n=parseInt($("#hiddenChildCase").val()); 
	
if(n==1){
		//alert("kal");
		$('#parentcasela').show();
		$('#parentcaseopt').show();
	$('#isChildCase1').prop('checked',true);
	
	}
	
	if(n==2){
		//alert("kalis alwayshere")
		$('#parentcasela').hide();
		$('#parentcaseopt').hide();
		$('#isChildCase2').prop('checked',true);
		
	}
	
	
	var a=parseInt($("#unitId").val()); 
	if(a>0){
		
		getProjects();
		getCircles();
		
		
		var b=parseInt($("#hiddenprojectId").val()); 
		if(b>0){
		
			getPackages(b);
			
		}
		
		var c=parseInt($("#hiddencircleId").val()); 
		if(c>0){
			
			getDivisions(c);
			
		}
		
		var d=parseInt($("#hiddendivisionId").val()); 
		if(d>0){
			//alert("kal");
			getSubDivisions(d);
			
		}
		
	}
	
	
	
	
	
	var e =parseInt($("#courtId").val());
	
if(e>0){
		
	getCaseTypes(e);
		
	}
	
var f =parseInt($("#caseGenId").val());

if(f>0){
		
	getCaseGenSub(f);
		
	}
	
	
	
	
	
});	

</script>







<c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.userName}"></c:out></p>
		</div>
	</div>
	</c:if>	<c:if test="${msg!=null || err!=null }">


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
	
	




		
		
						
<div class="w3l-main" id="borderStyle">
	 
	<div class="w3_agile_main_left">
	
				
<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Case Edit</h3>
			</div>

		




				
 <form:form id="caseeditdelete" method="post"
				modelAttribute="caseeditnew" >

					
					
					<div class="col-md-12" >
						<div class="col-md-3" ></div>
							<div class="col-md-6" >
							<div class="col-md-6" >
							<label class="label-control rowlebel ">Select Case</label> 
							</div>
							<div class="col-md-3" ><select
								class="form-control" id="caseId"  name="caseId">
								
								 <c:forEach items="${caseidList}" var="p">
							
								 
								  <c:choose>
								 <c:when test="${p.caseId==selectedcaseId}">
									<option value="${p.caseId}" selected="selected">${p.caseWpNumber}</option>
									</c:when>
									
									<c:otherwise>
									<option value="${p.caseId}">${p.caseWpNumber}</option>
									</c:otherwise>
									</c:choose>
								 
									
								</c:forEach>

							</select>
								<input type="hidden" class="form-control"  id="caseEdit1" name="caseEdit" value="false" />
							</div>
							<div class="col-md-3">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Get Case"  >
					</div>
						
							</div>
								<div class="col-md-3" ></div>
							</div>
						

	
					
					</form:form>
 


		<div
						class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  mainprint pagecontent"
						style="display: block">
		
		<c:if test="${caseData!=null }">
		<form:form id="casesedit" method="post"
				modelAttribute="caseeditnew"  data-parsley-validate-if-empty="" enctype="multipart/form-data" >
		<!-- <div class='container'> -->
		<!-- <div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active" style="display:block"> -->
		
		<c:forEach var="c" items="${caseData}" varStatus="count">
		
		
		
		
							
							
								<div class="col-md-12" >
													
<br></br>
								
								<div class="col-md-6" >
								<div class="col-md-6" >
								<input type="hidden" class="form-control"  id="caseId" name="caseId" value="<c:out value="${c.caseId}"></c:out>"/>
								<label class="label-control rowlebel ">Select Unit</label> 
								</div>
								<div class="col-md-6" >
									<select
								class="form-control" id="unitId"  name="unitId"  onchange="getProjects();getCircles();">
								
								 <c:forEach items="${unitList}" var="p">
								 <c:choose>
								 <c:when test="${p.unitId==selectedunitId}">
									<option value="${p.unitId}" selected="selected">${p.unitName}</option>
									</c:when>
									
									<c:otherwise>
									<option value="${p.unitId}">${p.unitName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>

							</select>
							
								
								</div>
								
								<div class="col-md-6" >
						
							 <input type="hidden" class="form-control"  id="hiddenprojectId" name="hiddenprojectId" value="<c:out value="${selectedprojectId}"></c:out>"/> 
							<label class="label-control rowlebel ">Select Project</label>
							</div>
							<div class="col-md-6" > <select
								class="form-control" id="projectId"  name="projectId" onchange="getPackages(this.value)"   ></select>
								
							</div>
							
							<div class="col-md-6" >
							
							 <input type="hidden" class="form-control"  id="hiddenpackageId" name="hiddenpackageId" value="<c:out value="${selectedpackageId}"></c:out>"/> 
							<label class="label-control rowlebel ">Select Package</label> 
							</div>
							<div class="col-md-6" ><select
								class="form-control" id="packageId"  name="packageId"  ></select>
							</div>
							
							<div class="col-md-6" >
							
							 <input type="hidden" class="form-control"  id="hiddencircleId" name="hiddencircleId" value="<c:out value="${selectedcircleId}"></c:out>"/> 
							<label class="label-control rowlebel ">Select Circle</label> 
							</div>
							<div class="col-md-6" ><select
								class="form-control" id="circleId"  name="circleId"  onchange="getDivisions(this.value)" ></select>
							</div>
							
							<div class="col-md-6" >
							
							 <input type="hidden" class="form-control"  id="hiddendivisionId" name="hiddendivisionId" value="<c:out value="${selecteddivisionId}"></c:out>"/> 
							<label class="label-control rowlebel ">Select Division</label> 
							</div>
							
							<div class="col-md-6" ><select
								class="form-control" id="divisionId"  name="divisionId"  onchange="getSubDivisions(this.value)" ></select>
							</div>
							
							<div class="col-md-6" >
							
							 <input type="hidden" class="form-control"  id="hiddensubdivisionId" name="hiddensubdivisionId" value="<c:out value="${selectedsubdivisionId}"></c:out>"/> 
							
							<label class="label-control rowlebel ">Select SubDivision</label> 
							</div>
							<div class="col-md-6" ><select
								class="form-control" id="subdivisionId"  name="subdivisionId"  ></select>
							</div>
								
								</div>
								
								<div class="col-md-6" >
								
								<div class="col-md-6" >
							
							<label class="label-control rowlebel ">Select Court</label>
							</div>
							<div class="col-md-6" > <select
								class="form-control" id="courtId"  name="courtId" onchange="getCaseTypes(this.value)">
								
								 <c:forEach items="${courtList}" var="p">
								 <c:choose>
								 <c:when test="${p.courtId==selectedcourtId}">
									<option value="${p.courtId}" selected="selected">${p.courtName}</option>
									</c:when>
									
									<c:otherwise>
									<option value="${p.courtId}">${p.courtName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>

							</select>
							</div>
							<div class="col-md-6" >
							<label class="label-control rowlebel ">Petitioner</label> 
							</div>
							<div class="col-md-6" >
							<input type="text" class="form-control"  id="petitioner" name="petitioner" value="<c:out value="${c.petitioner}"></c:out>" readonly="readonly" />
							<input type="hidden" class="form-control"  id="petitionerIdArray" name="petitionerIdArray" value="<c:out value="${c.petitionerIdArray}"></c:out>"/>
							</div>
							
							<div class="col-md-6" >
							<label class="label-control rowlebel ">Petitioner Advocate</label> 
							</div>
							<div class="col-md-6" >
							<input type="text" class="form-control"  id="petetionerAdvocate" name="petetionerAdvocate" value="<c:out value="${c.petetionerAdvocate}"></c:out>" readonly="readonly" />
							<input type="hidden" class="form-control"  id="petetionerAdvIdArray" name="petetionerAdvIdArray" value="<c:out value="${c.petetionerAdvIdArray}"></c:out>"/>
							</div>
							
							<div class="col-md-6" >
							<label class="label-control rowlebel ">Respondent</label> 
							</div>
							<div class="col-md-6" >
							<input type="text" class="form-control"  id="respondent" name="respondent" value="<c:out value="${c.respondent}"></c:out>" readonly="readonly" />
							<input type="hidden" class="form-control"  id="respondentIdArray" name="respondentIdArray" value="<c:out value="${c.respondentIdArray}"></c:out>"/>
							
							</div>
							
							<div class="col-md-6" >
							<label class="label-control rowlebel ">Respondent Advocate</label> 
							</div>
							<div class="col-md-6" >
							<input type="text" class="form-control"  id="respondentAdvocate" name="respondentAdvocate" value="<c:out value="${c.respondentAdvocate}"></c:out>" readonly="readonly" />
							<input type="hidden" class="form-control"  id="respondentAdvIdArray" name="respondentAdvIdArray" value="<c:out value="${c.respondentAdvIdArray}"></c:out>"/>
							
							</div>
							
								 <div class="col-md-6">
							<label class="label-control rowlebel ">Others Petitioner</label>
							</div>
							 <div class="col-md-6"><input
								type="text" class="form-control"
								id="petOthers" value="0" name="petOthers" data-parsley-trigger="keyup" data-parsley-type="number" readonly="readonly"  >
						</div>
							 <div class="col-md-6 ">
							<label class="label-control rowlebel ">Others Respondent</label>
							</div>
							 <div class="col-md-6"><input
								type="text" class="form-control"
								id="resOthers" value="0" name="resOthers" data-parsley-trigger="keyup" data-parsley-type="number" readonly="readonly">
						</div>
							
								
								
								
								</div>
								
						
							</div>
							
							<div class="col-md-12" >
							<div class="col-md-6" >
								<div class="col-md-6" >
							
							<label class="label-control rowlebel ">Select Category</label> 
							</div>
							<div class="col-md-6" ><select
								class="form-control" id="caseGenId"  name="caseGenId" onchange="getCaseGenSub(this.value)">
								
								 <c:forEach items="${caseGenList}" var="p">
								 <c:choose>
								 <c:when test="${p.caseGenId==selectedcaseGenId}">
									<option value="${p.caseGenId}" selected="selected">${p.caseGeneral}</option>
									</c:when>
									
									<c:otherwise>
									<option value="${p.caseGenId}">${p.caseGeneral}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>

							</select>
							</div>
							
							
							<div class="col-md-6" >	
							
						 <input type="hidden" class="form-control"  id="hiddencaseGenSubId" name="hiddencaseGenSubId" value="<c:out value="${selectedcaseGenSubId}"></c:out>"/> 
							<label class="label-control rowlebel ">Select Case Sub Category</label>
							</div>
							<div class="col-md-6" >	 <select
								class="form-control" id="caseGenSubId"  name="caseGenSubId"   ></select>
							</div>
							
							<div class="col-md-6" >
							
							 <input type="hidden" class="form-control"  id="hiddencaseTypeId" name="hiddencaseTypeId" value="<c:out value="${selectedcaseTypeId}"></c:out>"/> 
							<label class="label-control rowlebel ">Select Case Type</label> 
							</div>
							<div class="col-md-6" >	<select
								class="form-control" id="caseTypeId"  name="caseTypeId"  ></select>
							</div>
							
							<div class="col-md-6" >
							<label class="label-control rowlebel ">Case Number</label> 
							</div>
							<div class="col-md-6" >	
							<input type="text" class="form-control"  id="caseWpNumber" name="caseWpNumber" value="<c:out value="${c.caseNum}"></c:out>" readonly="readonly"  required />
							
							</div>
							
							<div class="col-md-6" >
							<label class="label-control rowlebel ">Case Year</label> 
							</div>
							<div class="col-md-6" >	
							<input type="text" class="form-control"  id="caseYear" name="caseYear" value="<c:out value="${c.caseYear}"></c:out>" readonly="readonly"  required data-parsley-trigger="keyup" data-parsley-type="number"/>
							
							</div>
							
						
							</div>
							<div class="col-md-6" >
							<div class="col-md-6">

							<label class="label-control rowlebel ">Date of Filing</label> 
							</div>
							<div class="col-md-6"><input
								type="text" class="form-control datepicker"  value="<c:out value="${c.filingDate}"></c:out>"
								id="filingDate" name="filingDate"  readonly="readonly" required/>
							
						</div>
						
						<div class="col-md-6">

							<label class="label-control rowlebel ">Draft Counter to G.P</label> 
							</div>
							<div class="col-md-6"><input
								type="text" class="form-control datepicker"  
								id="draftdateconttoGP" name="draftdateconttoGP"  value="<c:out value="${c.draftdateconttoGP}"></c:out>" readonly="readonly" />
							
						</div>
						<div class="col-md-6">

							<label class="label-control rowlebel ">Date of Counter Filed</label> 
							</div>
							<div class="col-md-6"><input
								type="text" class="form-control  datepicker"  value="<c:out value="${c.counterDate}"></c:out>"
								id="counterDate" name="counterDate" readonly="readonly" />
							
						</div>
						
						<div class="col-md-6">

							<label class="label-control rowlebel ">Date of Hearing</label> 
							</div>
							<div class="col-md-6"><input
								type="text" class="form-control  datepicker "  	id="hearingDate" name="hearingDate"  value="<c:out value="${c.hearingDate}"></c:out>" readonly="readonly" />
							
						</div>
						
						<div class="col-md-6">

							<label class="label-control rowlebel ">Date of Judgement</label>
							</div>
							<div class="col-md-6"> <input
								type="text" class="form-control  datepicker "  value="<c:out value="${c.judgementDate}"></c:out>"
								id="judgementDate" name="judgementDate"  readonly="readonly" />
							
						</div>
							</div>
							
							</div>
							
							<div class="col-md-12" >
							<div class="col-md-6" >
							<div class="col-md-6" >
							<label class="label-control rowlebel ">Select Stages</label> 
							</div>
							<div class="col-md-6" ><select
								class="form-control" id="caseStageId"  name="caseStageId"  required   onchange="getOrderList()" >
								
								<c:forEach items="${caseStageList}" var="p">
								<c:choose>
						 <c:when test="${p.caseStageId==selectedstageId}">
						 
									<option value="${p.caseStageId}"  selected="selected" >${p.caseStageName}</option>
                                </c:when>
                                <c:otherwise>
									<option value="${p.caseStageId}">${p.caseStageName}</option>
									</c:otherwise>
                                    </c:choose>
								</c:forEach>
								

							</select>

						
							</div>
							<div class="col-md-6"  id="OrderIdla">
							<label class="label-control rowlebel ">Select Type Order</label> 
							</div>
							<div class="col-md-6"  id="OrderIdin"><select
								class="form-control" id="caseTypeOrderId"  name="caseTypeOrderId"  >
								
								

							</select>
							
								<input type="hidden" class="form-control"  id="hiddenOrderId" name="hiddenOrderId" value="<c:out value="${c.caseTypeOrderId}"></c:out>" />
							</div>
							<div class="col-md-6" >
							<label class="label-control rowlebel ">Select Status</label> 
							</div>
							<div class="col-md-6" ><select
								class="form-control" id="caseStatusId"  name="caseStatusId" required>
								
								 <c:forEach items="${caseStatusList}" var="p">
								 <c:choose>
						 <c:when test="${p.caseStatusId==selectedstatusId}">
						 
									<option value="${p.caseStatusId}"  selected="selected" >${p.caseStatus}</option>
                                </c:when>
                                <c:otherwise>
									<option value="${p.caseStatusId}">${p.caseStatus}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>

							</select>
							</div>
						
						
							
							<div class="col-md-6" id="OrderIdlada" >

							<label class="label-control rowlebel ">Date of Order</label> 
							</div>
							<div class="col-md-6" id="OrderIdinda"><input
								type="text" class="form-control  datepicker "  	id="orderDate" name="orderDate"  value="<c:out value="${c.orderDate}"></c:out>"   readonly="readonly" />
							
						</div>
						
						
						
						  
							<div class="col-md-6"  id="OrderIdlaup">
							<label class="label-control rowdarkgrren" > <b>Upload
										Order</b></label></div>
										<div class="col-md-6"  id="OrderIdlain">
								<input id="orderFile" name="orderFile" type="file"
									class="btn-info" value="Upload Order"  data-parsley-max-file-size="1024" data-parsley-fileextension='pdf'>
							</div>
							 
							
					
							
							
							</div>
							<div class="col-md-6" >
							
							<div class="col-md-12">
							<div class="form-group">
        <label class="col-sm-6 control-label">Is Child Case[case transfered from Other Courts]</label>
        <div class="col-sm-6">
       
						 
        <label class="radio-inline"> <input type="radio" name="isChildCase" id="isChildCase1" value="1"  > Yes </label>
            <label class="radio-inline"> <input type="radio" name="isChildCase" id="isChildCase2" value="2"  > NO </label>
            <input type="hidden" name="hiddenChildCase" id="hiddenChildCase" value="<c:out value="${c.isChildCase}" ></c:out>"   >
            
        </div>
    </div>
						</div>	
						
						 
						<div class="col-md-6"  id="parentcasela">
							<label class="label-control rowlebel ">Select Parent Case</label> 
							</div>
							<div class="col-md-6"  id="parentcaseopt"><select
								class="form-control" id="k"  name="parentcaseId">
								
								 <c:forEach items="${caseidList}" var="p">
									<option value="${p.caseId}">${p.caseWpNumber}</option>

								</c:forEach>

							</select>
							
							</div>
							
					 <div class="col-md-12 ">
							<label class="label-control rowlebel ">Case Brief Prayer*</label>
							
							<textarea  class="form-control"    id="briefPrayer" name="briefPrayer"  readonly="readonly" required><c:out value="${c.briefPrayer}" ></c:out></textarea>  
						</div>
					
					
					 <div class="col-md-12">
							<label class="label-control rowlebel ">Remarks</label><textarea
							 class="form-control"   
								id="remarks"  name="remarks" readonly="readonly" > <c:out value="${c.remarks}" ></c:out></textarea>
						</div>
					
					
					
							</div>
							
							</div>
							
							
							
							
							
							
							
							
							
							
							
						
					
		
		
						
							
						
						
						
						
				
					
						
						
					
					</c:forEach>	
						
					<div class="col-md-12">
					<br></br>
					
					
					<div class="col-md-6">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="caseeditId" value="Edit" onclick="loadedit()"  >
					</div>
					
					<div class="col-md-6">
					<input type="hidden" class="form-control"  id="caseEdit2" name="caseEdit" value="false" />
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="caseeditsubmit" value="Submit"  >
					</div>
					</div>	
						
		
		
		
		
		
		
	<!-- 	</div> -->
		
		</form:form>
		
		
		<form:form id="canceledit" method="post"
				modelAttribute="caseeditnew"   >
		<div class="row show-grid">
					
					
					<div class="col-md-5"></div>
					<div class="col-md-2">
					<input type="hidden" class="form-control"  id="caseId" name="caseId" value="<c:out value="${caseData[0].caseId}"></c:out>"/>
					<input type="hidden" class="form-control"  id="caseEdit3" name="caseEdit" value="false" />
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="caseeditId" value="Cancel Edit" >
					</div>
					<div class="col-md-5"></div>
					
					</div>	
					
					</form:form>
		
		
		</c:if>
		 </div> 
		

	</div>	
	</div>
	
	<div class="row show-grid">
	</div>
	</div>
	
	
	 
	 
	 <script type="text/javascript" src="../js/parsley.js"></script>

    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#caseeditdelete').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			  document.forms.caseeditdelete.action="../web/caseEditNew";
				 document.forms.caseeditdelete.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});


$(function () {
	 $('#casesedit').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		    //alert('hi');
		  
				
		    
		  })
		  
		  .on('form:submit', function() {
			  alert("coming here");
			  
			 
						
			
			  document.forms.casesedit.action="../web/caseEditNew";
				 document.forms.casesedit.submit(); 
				
			
			  
			  
			    // Don't submit form for this demo
			  });
});

$(function () {
	 $('#canceledit').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  
			 
				
			  document.forms.canceledit.action="../web/caseEditNew";
				 document.forms.canceledit.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});


window.Parsley.addValidator('maxFileSize', {
	  validateString: function(_value, maxSize, parsleyInstance) {
	    if (!window.FormData) {
	      alert('formdata');
	      return true;
	    }
	    var files = parsleyInstance.$element[0].files;
	    return files.length != 1  || files[0].size <= maxSize * 1024;
	  },
	  requirementType: 'integer',
	  messages: {
	    en: 'This file should not be larger than %s Kb',
	   
	  }
	});
	
window.ParsleyValidator
.addValidator('fileextension', function (value, requirement) {
	alert(value);
    var fileExtension1 = value.split('.');
  
    var len=fileExtension1.length ;
 
  var fileExtension2 =null;
  if(len===2){
    
	  fileExtension2 = fileExtension1.pop();
  }
  if(len!=2){
	  fileExtension2 = "notallowed";
	  
  }
    
   // alert("fileExtensionhere"+fileExtension2);
    
    return fileExtension2 === requirement;
}, 32)
.addMessage('en', 'fileextension', 'The extension doesn\'t match the .pdf');



</script>
	 
	 
	 
	 

<!-- //main-content -->
