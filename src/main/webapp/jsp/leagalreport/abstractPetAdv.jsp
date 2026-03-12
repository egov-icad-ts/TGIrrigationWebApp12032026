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
	
				
<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Petitioner Advocate</h3>
			</div>

			<div class='container'>




				<div class=" toppad ">
<form:form id="casesReport" method="post"
				modelAttribute="abstract"  data-parsley-validate-if-empty="">
				
				<div class="row show-grid">
				<div class="col-md-12">
							<div class="form-group">
        <label class="col-sm-4 control-label">Court </label>
        <div class="col-sm-8" id="courtdiv">
        <c:choose>
        <c:when test="${selectedCourt==-1||selectedCourt==null}">
          <label class="radio-inline"> <input type="radio" name="courtId" id="courtId" checked="checked" value="-1" > All Cases </label>
           </c:when>
           <c:otherwise>
           <label class="radio-inline"> <input type="radio" name="courtId" id="courtId"  value="-1" > All Cases </label>
           </c:otherwise>
            </c:choose>
         <c:forEach items="${courtList}" var="u" varStatus="count">
         <c:choose>
         <c:when test="${selectedCourt==u.courtId}">
        <label class="radio-inline"> <input type="radio" name="courtId" id="courtId${count.count}"  checked="checked"    value="<c:out value="${u.courtId}"></c:out>"  required > <c:out value="${u.courtName}"></c:out> </label>
        </c:when>
        <c:otherwise>
        <label class="radio-inline"> <input type="radio" name="courtId" id="courtId${count.count}" value="<c:out value="${u.courtId}"></c:out>"  required > <c:out value="${u.courtName}"></c:out> </label>
        </c:otherwise>
            </c:choose>
          
           </c:forEach>
        </div>
    </div>
						</div>
						</div>
						
						<div class="row show-grid">
				<div class="col-md-6">
							
       <label class="label-control rowlebel ">Select Petitioner Advocate* 
								</label> <select class="form-control" id="advocateId" name="advocateId"
								 required >
								
								<c:forEach items="${petAdvList}" var="p">
								
								 <c:choose>
        <c:when test="${p.petitionerAdvId==selectedAdvocate}">
									<option value="${p.petitionerAdvId}" selected="selected" >${p.petitionerAdvName}</option>
									</c:when>
									
									 <c:otherwise>
									<option value="${p.petitionerAdvId}" >${p.petitionerAdvName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>
								


							</select>
       <%--  <input type="hidden" class="form-control"  id="hiddencaseType" name="hiddencaseType" value="<c:out value="${selectedCaseType}"></c:out>" /> --%>
        <input type="hidden" class="form-control"  id="hiddencourtId" name="hiddencourtId" value="<c:out value="${selectedCourt}"></c:out>" />
       
   
						</div>
						</div>
						

				


					

					
					<div class="row show-grid">
					<div class="clearfix"> </div>
					<div class="clearfix"> </div>
					<div class="col-md-12">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Get Cases" onclick="loadForm()" >
					</div>
					</div>
					
					</form:form>

					

</div>
</div>
</div>








					






			


			
		
	




	

		
		
		<c:if test="${petadvData!=null }">
		
		
		<!-- <div class='container'> -->
		<div class=" mainprint  pagecontent" style="display:block">
		
		 <div class="table-responsive" id="printarea"  >
		 
		
						<table class=" table-bordered " id="table">
							<thead style="background: #85C1E9 none repeat scroll 0 0;">
							<tr style="color: red; font-weight: bold; background: #ffffff;"><td></td><td>  Court Type</td><td><c:out value="${court}"></c:out></td><td></td><td></td><td> Advocate Name:</td><td><c:out value="${advocateName}"></c:out></td> </tr>
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1">Unit Name </th>
									
									
									
									<th rowspan="1" >Cases Filed</th>
									<th rowspan="1" >Draft Counter to GP</th>
									<th rowspan="1" >Counter Filed by GP</th>
									<th rowspan="1" >Counter To be Filed </th>
									<th rowspan="1" >Judgement Given </th>
									
									
								</tr>

								
							
								

							</thead>

							
							<tbody>
								<c:forEach var="c" items="${petadvData}" varStatus="count">
									
										<tr>
											
											<td style="text-align: center;"><c:out
													value="${count.count}"></c:out></td>
											<td><c:out value="${c.unitName}"></c:out> </td>
											
											
											
											<td><a target="_blank"  href="../webReports/petAdvDetails?unitId=<c:out value="${c.unitId}"></c:out>  &advocateId=<c:out value="${c.advocateId}"></c:out> &courtId=<c:out value="${c.courtId}"></c:out>  &filingDate=1" > <c:out value="${c.casesFiled}"></c:out>   </a></td>
											<td><a  target="_blank"  href="../webReports/petAdvDetails?unitId=<c:out value="${c.unitId}"></c:out> &advocateId=<c:out value="${c.advocateId}"></c:out> &courtId=<c:out value="${c.courtId}"></c:out>  &filingDate=2"> <c:out value="${c.draftCountFile}"></c:out></a></td>
											<td><a target="_blank"   href="../webReports/petAdvDetails?unitId=<c:out value="${c.unitId}"></c:out> &advocateId=<c:out value="${c.advocateId}"></c:out> &courtId=<c:out value="${c.courtId}"></c:out> &filingDate=3"> <c:out value="${c.counterFiled}"></c:out></a></td>
											<td><a target="_blank"  href="../webReports/petAdvDetails?unitId=<c:out value="${c.unitId}"></c:out> &advocateId=<c:out value="${c.advocateId}"></c:out>  &courtId=<c:out value="${c.courtId}"></c:out> &filingDate=4"><c:out value="${c.casesToFile}"></c:out></a></td>
											<td><a  target="_blank"  href="../webReports/petAdvDetails?unitId=<c:out value="${c.unitId}"></c:out> &advocateId=<c:out value="${c.advocateId}"></c:out>  &courtId=<c:out value="${c.courtId}"></c:out> &filingDate=5"><c:out value="${c.casesJudged}"></c:out></a></td>
											
											
											
											
											
							</tr>
									
								</c:forEach>
								<tr style="color: red; font-weight: bold;"><td></td><td>  Total</td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCasePetAdvTotalDetails?courtId=<c:out value="${petadvData[0].courtId}"></c:out>&advocateId=<c:out value="${petadvData[0].advocateId}"></c:out>&filingDate=1" ><c:out value="${petAdvCF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCasePetAdvTotalDetails?courtId=<c:out value="${petadvData[0].courtId}"></c:out>&advocateId=<c:out value="${petadvData[0].advocateId}"></c:out>&filingDate=2" ><c:out value="${petAdvDF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCasePetAdvTotalDetails?courtId=<c:out value="${petadvData[0].courtId}"></c:out>&advocateId=<c:out value="${petadvData[0].advocateId}"></c:out>&filingDate=3" ><c:out value="${petAdvCountF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCasePetAdvTotalDetails?courtId=<c:out value="${petadvData[0].courtId}"></c:out>&advocateId=<c:out value="${petadvData[0].advocateId}"></c:out>&filingDate=4" ><c:out value="${petAdvCountNF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCasePetAdvTotalDetails?courtId=<c:out value="${petadvData[0].courtId}"></c:out>&advocateId=<c:out value="${petadvData[0].advocateId}"></c:out>&filingDate=5" ><c:out value="${petAdvJF}"></c:out></a></td> </tr>
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
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table', 'countertable')" >
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

	$('#advocateId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	 


	 
	  
			
});


/* function loadForm(){
	
	
	
	

	
		
	
		  $('#casesReport').attr('action', "../webReports/EPFileStatus");
          $("#casesReport").submit();
         
	
	
	
	
    
}
 */
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


function getCaseTypes(val){
//alert("kal"+val.value);
var i =val
	//var districtId=document.getElementById("districtId").value;
	//var courtId=document.getElementById("courtId"+i).value;
	var courtId=i;
	//alert(courtId);

	  $.ajax({	          
      url: "../web/getCaseTypes?courtId="+courtId,
      type: "GET",
      success: function (response) {
    	
    		var deleteid = "#dataview" ;

    		$(deleteid).remove();
    	
    	//  var $select = $('#caseTypeId');
    	 
		 // $select.find('option').remove();
		  
		 
		var childCount = $('#typeid').children().length ;
		    var i = childCount+1;
		    var divid = "dataview" ;	
			var divrowid = "#" + divid;	
			 $('#typeid').append($('<div/>').attr("id",divid));
		 
				var obj = JSON.parse(response);
				//  $('#caseTypeId').append( '<option value="0"> --select--</option>' );
				
				var m =$('#hiddencaseType').val();
				  
				$.each(obj, function(key, value) {
					
					
					if(value.caseTypeId==m){
					
					$('<label class="radio-inline"> <input type="radio" name="caseTypeId" id="caseTypeId" value="'+value.caseTypeId+'" required  checked="checked" > '+value.caseType+' </label>').fadeIn('slow').appendTo(divrowid);
					
					}else {
						
						$('<label class="radio-inline"> <input type="radio" name="caseTypeId" id="caseTypeId" value="'+value.caseTypeId+'" required > '+value.caseType+' </label>').fadeIn('slow').appendTo(divrowid);
						
					}
					
						/* $('#caseTypeId').append( '<option value="'+value.caseTypeId+'" > '+value.caseType+'</option>' ); */
				
  	  				//$('#typeid').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}	 


$(function() {
	
	var k=$('#hiddencourtId').val();
	
	if(k!='NaN'){
		//alert("k"+k);
	getCaseTypes(k);
	}
	
	
	
	
	
	
});	



</script>
	
	
	 <script type="text/javascript" src="../js/parsley.js"></script>

    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#casesReport').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.casesReport.action="../webReports/PetAdvStatus";
				 document.forms.casesReport.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script>
	
	 
	 
	 
	 

<!-- //main-content -->
