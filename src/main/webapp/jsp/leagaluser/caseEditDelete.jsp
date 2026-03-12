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
	 
	$('#dialog').hide();
	
	  
			
});


/* function loadForm(){
	
	var courtId=$('#courtId').val();
	var caseType =$('#caseGenId').val();
	
	
	

	
		
	
		  $('#caseeditdelete').attr('action', "../web/caseEditDelete");
          $("#caseeditdelete").submit();
         
	
	
	
	
    
} */

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


/* function deletecase(){
	 
	 
	// alert(n+"kal");
	 
	// alert(m+"lak")
	 
	
			  $('#caseeditdelete2').attr('action', "../web/caseEditDelete");
	          $("#caseeditdelete2").submit();
	          e.preventDefault();
		
	 
	 
 }
 */

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
	
	




		
		
	
	 
	<div class="w3_agile_main_left">
	
				
<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Case Delete</h3>
			</div>

			<div class='container'>




				<div class="row col-md-12 toppad ">
<form:form id="caseeditdelete" method="post"
				modelAttribute="casesedit"  >

					

					
					<div class="col-md-12" >
					<div class="col-md-3" ></div>
					<div class="col-md-6" >
					
					<div class="col-md-6" >
							<label class="label-control rowlebel ">Select Case</label> 
							</div>
							
							<div class="col-md-6" ><select
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
							<input type="hidden" class="form-control"  id="caseDelete" name="caseDelete" value="false" />
							
							</div>
							</div>
							<div class="col-md-3" ></div>
							</div>
						

	
					<div class="row show-grid">
					
					<div class="col-md-12">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Get Case"  >
					</div>
					</div>
					
					</form:form>

					

</div>
</div>
</div>








					






			


			
		
	




	

		
		
		<c:if test="${caseData!=null }">
		<form:form id="caseeditdelete2" method="post"
				modelAttribute="casesedit" >
		<!-- <div class='container'> -->
		<div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active" style="display:block">
		
		 <div class="row show-grid gridList" id="printarea"  >
						<table class="table-responsive table-bordered " id="table">
							<thead style="background: #85C1E9 none repeat scroll 0 0;">
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1">Project / Package </th>
									
									<th rowspan="1">Unit / Circle / Division</th>
									
									
									<th rowspan="1">CourtName / CaseNumber with Type / Case Year</th>
									
									<th rowspan="1" >Petitioner</th>
									<th rowspan="1" >Petetioner Advocate</th>
									<th rowspan="1" >Respondent</th>
									<th rowspan="1" >Respondent Advocate</th>
									<th rowspan="1" >Case Subject</th>
									<th rowspan="1" >Case Stage / Case Status</th>
									<th rowspan="1" >Case Breif Prayer</th>
									<th rowspan="1" > Filing Date / Counter FilingDate /JudgementDate / Remarks</th>									
									
									<th rowspan="1" >Delete</th>
								</tr>

								
							
								

							</thead>

							
							<tbody>
								<c:forEach var="c" items="${caseData}" varStatus="count">
								
									
										<tr>
											
											<td style="text-align: center;"><c:out
													value="${count.count}"></c:out></td>
											<td><c:out value="${c.projectName}"></c:out> / <c:out value="${c.packageName}"></c:out></td>
											
											<td><c:out value="${c.unitName}"></c:out> / <c:out value="${c.circleName}"></c:out> / <c:out value="${c.divisionName}"></c:out> </td>
											
											<td><c:out value="${c.courtName}"></c:out> / <c:out value="${c.caseWpNumber}"></c:out> / <c:out value="${c.caseYear}"></c:out> </td>
											<td><c:out value="${c.petitioner}"></c:out></td>
											<td><c:out value="${c.petetionerAdvocate}"></c:out></td>
											<td><c:out value="${c.respondent}"></c:out></td>
											<td><c:out value="${c.respondentAdvocate}"></c:out></td>
											<td><c:out value="${c.caseGenSubName}"></c:out> </td>
											<td><c:out value="${c.caseStageName}"></c:out> / <c:out value="${c.caseStatus}"></c:out>  </td>
											
											
											<td><c:out value="${c.briefPrayer}"></c:out></td>
											<td><c:out value="${c.filingDate}"></c:out> / <c:out value="${c.counterDate}"></c:out> / <c:out value="${c.judgementDate}"></c:out> / <c:out value="${c.remarks}"></c:out></td>
											
								<td>
								<input type="hidden" class="form-control"  id="caseDelete" name="caseDelete" value="true" />
								<input type="hidden" class="form-control"  id="caseId" name="caseId" value="<c:out value="${c.caseId}"></c:out>" />
								<c:if test="${ userObj.unitId==null || userObj.unitId==c.unitId }">
								<input
								type="submit" class="btn btn-1 btn-danger center-block"
								id="deleteid" value="Delete"  >
								</c:if>
								</td>
											
											
											
											
							</tr>
									
								</c:forEach>
								</tbody>
							

						</table>
						
				
					</div>
					
					<div id="dialog" title="Confirmation Required to Delete">
  Are you sure to delete case?
</div>
				
		</div>
		<!-- </div> -->
		</form:form>
		</c:if>
		
		
		
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
			  
			 
				
			  document.forms.caseeditdelete.action="../web/caseEditDelete";
				 document.forms.caseeditdelete.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});	

$(function () {
	
	
	 $('#caseeditdelete2').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  
			 
				
			  document.forms.caseeditdelete2.action="../web/caseEditDelete";
				 document.forms.caseeditdelete2.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});	
</script>
	 
	 

<!-- //main-content -->
