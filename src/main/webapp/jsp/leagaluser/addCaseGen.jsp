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
	


var z=1;
$('#adgwefryewry').click(function() {

	     var unitId =$("#unitId").val();
	     var unitName =$('#unitId').find("option:selected").text(); 
	     var projectId =$("#projectId").val();
	     var projectName =$('#projectId').find("option:selected").text();
	     var packageId =$("#packageId").val();
	     var packageName =$('#packageId').find("option:selected").text();
	     var circleId =$("#circleId").val();
	     var circleName =$('#circleId').find("option:selected").text();
	     var packageId =$("#packageId").val();
	     var packageName =$('#packageId').find("option:selected").text();
	     var divisionId =$("#divisionId").val();
	     var divisionName =$('#divisionId').find("option:selected").text();
	     var subdivisionId =$("#subdivisionId").val();
	     var subdivisionName =$('#subdivisionId').find("option:selected").text();
	    /*  var districtId =$("#districtId").val();
	     var districtName =$('#districtId').find("option:selected").text();
	     var mandalId =$("#mandalId").val();
	     var mandalName =$('#mandalId').find("option:selected").text();
	     var villageId =$("#villageId").val();
	     var villageName =$('#villageId').find("option:selected").text(); */
	     var courtId =$("#courtId").val();
	     var courtName =$('#courtId').find("option:selected").text();
	     var courtdistrictId =$("#courtdistrictId").val();
	     var courtdistrictName =$('#courtdistrictId').find("option:selected").text();
	     var caseTypeId =$("#caseTypeId").val();
	     var caseType =$('#caseTypeId').find("option:selected").text();
	     var caseWpNumber =$("#caseWpNumber").val();
	    
	     var caseYear =$("#caseYear").val();
	    
	     var filingDate =$("#filingDate").val();
	    
	     var caseStageId =$("#caseStageId").val();
	     var caseStageName =$('#caseStageId').find("option:selected").text();
	     var caseGenId =$("#caseGenId").val();
	     var caseGeneral =$('#caseGenId').find("option:selected").text();
	     var caseGenSubId =$("#caseGenSubId").val();
	     var caseGenSubName =$('#caseGenSubId').find("option:selected").text();
	     var petitionerIdArray =$("#petitionerId").val();
	     var petitionerName =$('#petitionerId').find("option:selected").text();
	     var petetionerAdvIdArray =$("#petitionerAdvId").val();
	     var petitionerAdvName =$('#petitionerAdvId').find("option:selected").text();
	     var respondentIdArray =$("#respondentId").val();
	     var respondentName =$('#respondentId').find("option:selected").text();
	     var respondentAdvIdArray =$("#respondentAdvId").val();
	     var respondentAdvName =$('#respondentAdvId').find("option:selected").text();
	     var briefPrayer =$("#briefPrayer").val();
	     
	     
	     var remarks =$("#remarks").val();
	    
	     var caseStatusId =$("#caseStatusId").val();
	     var caseStatus =$('#caseStatusId').find("option:selected").text();
	     
	     var phoneNumber =$("#phoneNumber").val();
	    
	   
	     var contactPerson =$("#contactPerson").val();
	     
	     
	     var f=1;
			
			
			var m = $('#caserow').children().length;
			var j = m + 1;
			
			//alert(ee);
			//alert(prj);
					
					
					var divid = "caseview"+ j;
					var divrowid = "#"+ divid;
					$('#caserow').append($('<div/>').attr("id",divid).addClass("row gridList"));
					  $('<div class="col-md-1  " >'+ j + '<input type="hidden" class="form-control" name="casesList['+m+'].unitId" readonly="readonly" id="casesList'+m+'" value="'+unitId+'" /><input type="hidden" class="form-control" name="casesList['+m+'].projectId" readonly="readonly" id="casesList'+m+'" value="'+projectId+'" /></div>').fadeIn('slow').appendTo(divrowid); 
				 
					$('<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].packageId" readonly="readonly" id="casesList'+m+'" value="'+packageId+'" /><input type="hidden" class="form-control" name="casesList['+m+'].circleId" readonly="readonly" id="casesList'+m+'" value="'+circleId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].divisionId" readonly="readonly" id="casesList'+m+'" value="'+divisionId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].subdivisionId" readonly="readonly" id="casesList'+m+'" value="'+subdivisionId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].courtId" readonly="readonly" id="casesList'+m+'" value="'+courtId+'" /> '+' '+divisionName+'   /'+circleName +' /'+packageName+ '</div>').fadeIn('slow').appendTo(divrowid)
					
				
				
				 	$('<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].courtdistrictId" readonly="readonly" id="casesList'+m+'" value="'+courtdistrictId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].caseTypeId" readonly="readonly" id="casesList'+m+'" value="'+caseTypeId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].caseWpNumber" readonly="readonly" id="casesList'+m+'" value="'+caseWpNumber+'" /> '+courtName+'  /'+courtdistrictName+'  /'+ caseType	+'/'+ caseWpNumber+'/'+'</div>').fadeIn('slow').appendTo(divrowid) 
				
					$('<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].caseYear" readonly="readonly" id="casesList'+m+'" value="'+caseYear+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].filingDate" readonly="readonly" id="casesList'+m+'" value="'+filingDate+'" />  '+ caseYear	+' /'+ filingDate+'</div>').fadeIn('slow').appendTo(divrowid)
					
					
					$('<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].caseGenId" readonly="readonly" id="casesList'+m+'" value="'+caseGenId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].caseStageId" readonly="readonly" id="casesList'+m+'" value="'+caseStageId+'" />  <input type="hidden" class="form-control" name="casesList['+m+'].caseGenSubId" readonly="readonly" id="casesList'+m+'" value="'+caseGenSubId+'" />   '+ caseGeneral	+' /'+caseGenSubName+' /' +caseStageName+'</div>').fadeIn('slow').appendTo(divrowid)
					
					$('<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].petitionerIdArray" readonly="readonly" id="casesList'+m+'" value="'+petitionerIdArray+'" />  '+ petitionerName+','+ '</div>').fadeIn('slow').appendTo(divrowid)
					$('<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].petetionerAdvIdArray" readonly="readonly" id="casesList'+m+'" value="'+petetionerAdvIdArray+'" />  '+ petitionerAdvName	+ '</div>').fadeIn('slow').appendTo(divrowid)
					$('<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].respondentIdArray" readonly="readonly" id="casesList'+m+'" value="'+respondentIdArray+'" />  '+ respondentName	+','+ '</div>').fadeIn('slow').appendTo(divrowid)
					$('<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].respondentAdvIdArray" readonly="readonly" id="casesList'+m+'" value="'+respondentAdvIdArray+'" />  '+ respondentAdvName	+ '</div>').fadeIn('slow').appendTo(divrowid)
					 $('<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].briefPrayer" readonly="readonly" id="casesList'+m+'" value="'+briefPrayer+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].remarks" readonly="readonly" id="casesList'+m+'" value="'+remarks+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].caseStatusId" readonly="readonly" id="casesList'+m+'" value="'+caseStatusId+'" />  '+ briefPrayer	+' /'+caseStatus+ '</div>').fadeIn('slow').appendTo(divrowid) 
					
					$('<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].contactPerson" readonly="readonly" id="casesList'+m+'" value="'+contactPerson+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].phoneNumber" readonly="readonly" id="casesList'+m+'" value="'+phoneNumber+'" /> '+remarks+' /'+ contactPerson	+' /'+phoneNumber+ '</div>').fadeIn('slow').appendTo(divrowid)
					 
					
						
					$('<div class="col-md-1 " ><input type="button" class=" form-control cusbtn cus-btn-lg btn-danger" name="del" id="casesList'+j+'"  value="Delete" onclick="deleteRow(this) "  /></div>').fadeIn('slow').appendTo(divrowid);
					 
					   /*  if(j>=1){$("#submitAssignWork").show();} */
						j = parseInt(j) + 1;
						
					
						
						
		

							

							
		

					

	    
	   
	   

						
		});


	 

});


	 
	  
			




	
	
	
	/* function loadaddcasegenform(){
		
		alert("kal is here")
		
		  $('#casegen').attr('action', "../web/addCaseGen");
          $("#casegen").submit();
         
		
		
	} */
	



		
	
 
 

</script>
	
	 
	<div class="w3_agile_main_left">

		
		<div class="col-md-12 agile_banner_bottom_grids">
		<div  style="display: block; width: 100%; margin-left:10px;margin-right:10px;">
			 
			<div class="resp-tabs-container">
				<div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active" style="display:block">
					
						




	<c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.employeeName}"></c:out></p>
		</div>
	</div>
	</c:if>



	<div class="page">



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
		
	


		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Add Case General</h3>
			</div>
<form:form id="casegen" method="post" modelAttribute="casegen"  data-parsley-validate-if-empty="" >
			<div class='container'>




				<!-- <div class="row col-md-12 toppad "> -->





						
					
					 
						<div class="col-md-12">
						<div class="col-md-3"></div>
						<div class="col-md-6">
                           <div class="col-md-6">
							<label class="label-control rowlebel ">Case Genral Name</label> 
							</div>
							<div class="col-md-6">
							<input
								type="text" class="form-control" 
								id="caseGeneral" name="caseGeneral" placeholder="Name"  required />
								</div>
								</div>
								<div class="col-md-3"></div>
						</div>
						
						
						

						


					

						


					
			
					
<%-- 
					<div class="row show-grid">


						<div class="col-md-3">

							<label class="label-control rowlebel ">Select Petitioner</label> <select
								class="form-control" id="petitionerId" name="petitionerIdArray" multiple="multiple"
								>

							<c:forEach items="${petList}" var="p">
									<option value="${p.petitionerId}">${p.petitionerName}</option>

								</c:forEach>
								

							</select>

						</div>
						
					


</div>
 --%>

					
				
					
					<div class="row show-grid">
                       <div class="col-md-12">
							<label class="label-control rowlebel "></label><input
								type="submit" class="btn btn-1 btn-primary center-block"
								id="addcaseGen" value="Add Case General" >
						</div>
						
					
						</div>







			<!-- 	</div> -->
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
				      <div class="col-md-1" >Petitioner</div>	
				     <div class="col-md-1" >Petitioner Address</div>	
				     
				    
				     
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
	</div>




<!-- create component ends here -->


					</div>
		
					
			
				
				
			</div>
		</div>
	</div>
	 
	 
	 
	 
</div>


 <script type="text/javascript" src="../js/parsley.js"></script>

    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#casegen').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  
			 
				
			  document.forms.casegen.action="../web/addCaseGen";
				 document.forms.casegen.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

<!-- //main-content -->
