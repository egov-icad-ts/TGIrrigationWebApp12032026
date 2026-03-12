	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 
 





<c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.employeeName}"></c:out></p>
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
		<br></br>
	<c:if test="${caseDetail!=null }">
		<!-- <div class='container'> -->
		<div class=" mainprint  pagecontent toppad" >
		
		 <div class="table-responsive" id="printarea"  >
						<table class=" table-bordered " id="table">
							<thead style="background: #85C1E9 none repeat scroll 0 0;">
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1">Project </th>
									<th rowspan="1">Package </th>
									
									<th rowspan="1">Unit </th>
									<th rowspan="1">Circle </th>
									<th rowspan="1">Division</th>
									
									
									<th rowspan="1">CourtName </th>
									<th rowspan="1">CaseNumber with Type</th>
									<th rowspan="1">Case Year</th>
									
									<th rowspan="1" >Petitioner</th>
									<th rowspan="1" >Petitioner Advocate</th>
									<th rowspan="1" >Respondent</th>
									<th rowspan="1" >Respondent Advocate</th>
									<th rowspan="1" >Case Subject</th>
									<th rowspan="1" >Case Stage</th>
									<th rowspan="1" >Case Status</th>
									<th rowspan="1" >Case Brief Prayer</th>
									<th rowspan="1" > Filing Date</th>
									<th rowspan="1" > Counter FilingDate </th>
									<th rowspan="1" > JudgementDate</th>
									<th rowspan="1" > Hearing Date</th>
									<th rowspan="1" > Contact Person</th>
									<th rowspan="1" > Contact Phone Numbers</th>
									<th rowspan="1" > Remarks</th>									
									
								</tr>

								
							
								

							</thead>

							
							<tbody>
								<c:forEach var="c" items="${caseDetail}" varStatus="count">
									
										<tr>
											
											<td style="text-align: center;"><c:out
													value="${count.count}"></c:out></td>
											<td><c:out value="${c.projectName}"></c:out> </td>
											<td> <c:out value="${c.packageName}"></c:out></td>
											
											<td><c:out value="${c.unitName}"></c:out>  </td>
											<td> <c:out value="${c.circleName}"></c:out>  </td>
											<td> <c:out value="${c.divisionName}"></c:out> </td>
											
											<td><c:out value="${c.courtName}"></c:out>  </td>
											<td> <c:out value="${c.caseWpNumber}"></c:out> </td>
											<td> <c:out value="${c.caseYear}"></c:out> </td>
											<td><c:out value="${c.petitioner}"></c:out></td>
											<td><c:out value="${c.petetionerAdvocate}"></c:out></td>
											<td><c:out value="${c.respondent}"></c:out></td>
											<td><c:out value="${c.respondentAdvocate}"></c:out></td>
											<td><c:out value="${c.caseGenSubName}"></c:out> </td>
											<td><c:out value="${c.caseStageName}"></c:out>   </td>
											<td><c:out value="${c.caseStatus}"></c:out>  </td>
											
											
											<td><c:out value="${c.briefPrayer}"></c:out></td>
											<td><c:out value="${c.filingDate}"></c:out> </td>
											<td> <c:out value="${c.counterDate}"></c:out> </td>
											<td><c:out value="${c.judgementDate}"></c:out></td>
											<td><c:out value="${c.hearingDate}"></c:out></td>
											<td><c:out value="${c.contactName}"></c:out></td>
											<td><c:out value="${c.contactPhone}"></c:out></td>
											<td> <c:out value="${c.remarks}"></c:out></td>
											
											
											
							</tr>
									
								</c:forEach>
								</tbody>
							

						</table>
						
				
					</div>
				
		</div>
		<!-- </div> -->
		</c:if>
		
		<div class="row show-grid">
					<div class="clearfix"> </div>
					<div class="clearfix"> </div>
					<div class="col-md-6">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table', 'casestable')"  >
					</div>
					
					<div class="col-md-6">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Print"  onclick="printDiv('printarea')" >
					</div>
					</div>
		
	</div>
	 
	
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

	
	 

	 
	  
			
});


function loadForm(){
	
	var courtId=$('#courtId').val();
	var caseType =$('#caseGenId').val();
	
	
	

	
		
	
		  $('#casesReport').attr('action', "../webReports/casesview");
          $("#casesReport").submit();
         
	
	
	
	
    
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


</script>
	 
	 
	 

<!-- //main-content -->
