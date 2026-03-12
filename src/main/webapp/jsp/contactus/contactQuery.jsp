<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-multiselect.css" type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css"/>

<script type="text/javascript" src="../js/chartist.min.js.map"></script>
<script type="text/javascript" src="../js/chartist.js"></script>
<script type="text/javascript" src="../js/chartist.min.js"></script>
<!-- <script type="text/javascript" src="../js/jquery.js"></script> -->
<link rel="stylesheet" media="screen" href="../css/chartist.min.css">


<script>
$(document).ready(function(){
	

	$('#randomNumber').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });



});
	

	
	
	
function loadForm(){
	
	var randomNumber=$('#randomNumber').val();
	if(randomNumber >0){
		
	//	alert("coming in two ");
		  $('#queryStatus').attr('action', "../pmsUser/contactQuery");
          $("#queryStatus").submit();
          e.preventDefault();
	};
}
 


</script>






<div class='container'>

<div class="row-fluid">

		<div class="span6 pull-right">
			<c:out value="${userObj.employeeName}"></c:out>
		</div>
	</div>


	

	<div class="page">


<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">CONTACT QUERY STATUS</h3>
			</div>
			
			<div class='container'>
		
<form:form  id="queryStatus"  name= "queryStatus" modelAttribute="Contactus"  method="post" >		
		<div class="row col-md-12 toppad ">

        <!--   onchange="getPackages(this);" -->



			<div class="row show-grid">
				
				<div class="col-md-10">
				 <label class="label-controlPMS rowlebel ">Select Query Number</label>
					<select class="form-control" id="randomNumber" name="randomNumber"  >
						<option value=0>--Select --</option>
					 <c:forEach items="${randomList}" var="prj">
							<option value="${prj.randomNumber}">${prj.randomNumber}</option>
						</c:forEach> 
					</select>
				</div>
				
				
				<div class="col-md-2">
					<input type="submit" class="btn btn-1 btn-primary center-block"
						id="queryStatus" value="Get Query Status"   onclick="loadForm();">
				</div>
				
			
		
		
		
		</div>
		</div>
		</form:form>
		
		
		
		


		
			</div>
		
		</div> <!-- panel -->
		
		
		


		<!-- end of list -->
		
		

		<!-- end of list -->
		
		
		
	<div class="row col-md-12 toppad ">
		


		<!-- end of list -->
		
	
		
        


		<!-- end of list -->
		
		
		
        
		
		
		
		
        	<c:if test="${contactList!=null}">
		<!-- start of list -->
		
		<div class='container'>

		<div class="col-md-12">


			
				
				<c:forEach var="land" items="${contactList}" varStatus="count" >
				
			

				<div class="row show-grid   ">
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Conatct Id</label>
				
				</div>
				
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.randomNumber}"></c:out></label>
					
				</div>
				</div>
				<div class="row show-grid  ">

				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Name</label>
					
				</div>
				
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.name}"></c:out></label>
					
				</div>
				</div>
				<div class="row show-grid   ">
				
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Designation</label>
					
				</div>
				
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.designation}"></c:out></label>
					
				</div>
				</div>
				
				<div class="row show-grid   ">
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Subject</label>
					
				</div>
				
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.subject}"></c:out></label>
					
				</div>
				</div>
				
				<div class="row show-grid  ">
				
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Description</label>
					
				</div>
				
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.description}" escapeXml="false"></c:out></label>
					
				</div>
				</div>
				
				<div class="row show-grid  ">
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Email</label>
					
				</div>
				
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.email}"></c:out></label>
					
				</div>
				</div>
				
				<div class="row show-grid  ">
				
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Contact No</label>
					
				</div>
				
				
				<c:choose>
														  <c:when test="${contactNo!=99}">
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.contactNo}"></c:out></label>
					
				</div>
				
				</c:when>
				<c:otherwise>
				
				<div class="col-md-6">
				<label class="label-controlPMS">No Contact Number</label>
					
				</div>
				
				</c:otherwise>
				</c:choose>
				
				</div>
				
				<div class="row show-grid   ">
				
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Status</label>
					
				</div>
				
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.status}"></c:out></label>
					
				</div>
				
				</div>
				
				<div class="row show-grid   ">
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Resolution</label>
					
				</div>
				
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.resolution}" ></c:out></label>
					
				</div>
				</div>
				
				<div class="row show-grid  ">
				
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Contact Date</label>
					
				</div>
				
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.contactDate}"></c:out></label>
					
				</div>
				</div>
				<div class="row show-grid ">
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">Remarks</label>
					
				</div>
				
				<div class="col-md-6">
				<label class="label-controlPMS"><c:out value="${land.remarks}" escapeXml="false" ></c:out></label>
					
				</div>
				
				</div>
				
				<div class="row show-grid ">
				
				<div class="col-md-6">
				<label class="label-controlPMS rowlebel">File Name</label>
					
				</div>
				<c:choose>
									<c:when test="${fileName!='--'}">
				<div class="col-md-6">
				<label class="label-controlPMS"><a href=" ../uploadedFiles/contactus/%{fileName}" target="_blank"><c:out value="${land.fileName}"></c:out></a></label>
					
				</div>
				
				</c:when>
				<c:otherwise>
				
				<div class="col-md-6">
				<label class="label-controlPMS">File Not Uploaded</label>
					
				</div>
				
				</c:otherwise>
				</c:choose>
			
				
				</div>
				
				
				
				
				

				
				</c:forEach>

			

		</div>
		<!-- col-md-12 -->


		
			
			
			
			
			
		</div>
		</c:if>
		
		
		
		
        
	</div>
	<!-- page -->
</div>
</div>
<!-- container -->



<!-- create component ends here -->

