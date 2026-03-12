<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>

  <script type="text/javascript" src="../js/jquery.min.js"></script>  
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">


<link rel="stylesheet" href="../css/bootstrap-multiselect.css" type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css"/>




<script>
$(document).ready(function(){
	
	 
	$('#statusID').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	 });
	
	
	
	
	



});
	

	
	
	
/* function loadForm(){
	
	var unitId=$('#unitId').val();
	if(unitId >0){
		
	//	alert("coming in two ");
		  $('#adminsanc').attr('action', "../pmsReports/adminsancReport");
          $("#adminsanc").submit();
          e.preventDefault();
	};
} */
 


</script>

 





<div class='container'>

	

	<div class="page">


<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Contact Status</h3>
			</div>
			
			<div class='container'>
		
<form:form  id="contactstatus"  name= "contactstatus" modelAttribute="Contactus"  method="post" >		
		<div class="row col-md-12 toppad ">

        <!--   onchange="getPackages(this);" -->



			<div class="row show-grid">
				
				<div class="col-md-10">
				 <label class="label-controlPMS rowlebel ">Select Contact Status</label>
					<select class="form-control" id="statusID" name="statusID"  >
						<option value=0>--Select --</option>
						<c:forEach items="${contactStatusList}" var="prj">
							<option value="${prj.statusID}">${prj.status}</option>
						</c:forEach>
					</select>
				</div>
				
				
				<div class="col-md-2">
					<input type="submit" class="btn btn-1 btn-primary center-block"
						id="getqueries" value="Get  Queries"   onclick="loadForm();">
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
		
		
		
        
		
		
		
		
        	<c:if test="${contactViewList!=null}">
		<!-- start of list -->
		
		

		 <div id="content" class="bs-example col-md-12 " data-example-id="contextual-table" style="border: 1px solid #eee">
    <table class="table pagination " id="contactTable" >
      <thead>
        <tr class="rowlebel">
         <th >S.No</th>
          <th>Contact Id</th>
          <th>Name</th>
          <th>Designation</th>
          <th>Subject</th>
            <th>Description</th>
              <th>Email</th>
                <th>Contact No</th>
                  <th>Status</th>
                    <th>Resolution</th>
                      <th>Contact Date</th>
                        <th>File Name</th>
                          <th>Reply Remarks</th>
                            <th>Updated by</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="land" items="${contactViewList}" varStatus="count" >
     
        <tr class="active" style="width: 100%;">
          <td width="2%" scope="row"><c:out value="${count.count}"></c:out></td>
          <td width="5%"><b><a href="../pmsUser/contactUpdate?randomNumber=<c:out value="${land.randomNumber}"></c:out>"><c:out value="${land.randomNumber}"></c:out></a></b></td>
          <td  width="10%"><c:out value="${land.name}"></c:out></td>
          <td width="5%"><c:out value="${land.designation}"></c:out></td>
           <td  width="10%"><c:out value="${land.subject}"></c:out></td>
            <td class="col-md-2" width="20%" ><c:out value="${land.description}"  escapeXml="false" ></c:out></td>
             <td  width="9%"><c:out value="${land.email}"></c:out></td>
              <td  width="8%"><c:out value="${land.contactNo}"></c:out></td>
              <td  width="2%"><c:out value="${land.status}"></c:out></td>
              <td  width="2%"><c:out value="${land.resolution}"></c:out></td>
              <td  width="2%"><c:out value="${land.contactDate}"></c:out></td>
              
              <c:choose>
									<c:when test="${land.fileName!='--'}">
										<td ><a
												href="../uploadedFiles/contactus/<c:out value="${land.fileName}"></c:out>" target="_blank">View Uploaded file</a></td>
									</c:when>
									<c:otherwise>
										<td ><c:out value="${land.fileName}"></c:out></td>
									</c:otherwise>
								</c:choose>
              <%--  <td  width="5%"><c:out value="${land.fileName}"></c:out></td> --%>
                <td width="20%"><c:out value="${land.remarks}"  escapeXml="false" ></c:out></td>
                 <td width="5%"><c:out value="${land.lastupdatedUserId}"></c:out></td>
                 
        </tr>
       
        </c:forEach>
       
      </tbody>
    </table>
  </div>
 

		
			
			
		
			
			
		
		</c:if>
		
		
		
		
        
		

	</div>
	<!-- page -->
	
	
   
</div>
</div>
<!-- container -->



<!-- create component ends here -->

