
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>

<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>




<link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />

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

<script type="text/javascript">
		$(function() {
			
		})
		
	</script>

<script>
$(document).ready(function(){

	
	 


	 
	  
			
});


/* function loadForm(){
	
	
	
	

	
		
	
		  $('#casesReport').attr('action', "../webReports/abstractCounterFiles");
          $("#casesReport").submit();
         
	
	
	
	
    
} */

/* function printDiv(divName) {
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
} */

function printDiv(divName) {
    var toPrint = document.getElementById(divName);
    var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');
    popupWin.document.open();
    popupWin.document.write('<html><title>::Preview::</title><link rel="stylesheet" type="text/css" href="print.css" /></head><body onload="window.print()">')
    popupWin.document.write(toPrint.innerHTML);
    popupWin.document.write('</html>');
    popupWin.document.close();
}
/*--This JavaScript method for Print Preview command--*/
function PrintPreview(divName) {
    var toPrint = document.getElementById(divName);
    var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');
    popupWin.document.open();
    popupWin.document.write('<html><title>::Print Preview::</title><link rel="stylesheet" type="text/css" href="Print.css" media="screen"/></head><body">')
    popupWin.document.write(toPrint.innerHTML);
    popupWin.document.write('</html>');
    popupWin.document.close();
}

$(function() {
	
	$("input[name='taskTypeId']").change(function(){
        var radioValue = $("input[name='taskTypeId']:checked").val();
        if(radioValue){
          //  alert("Your are a  " + radioValue);
        	$("#hiddentaskTypeId").val(radioValue);
        /* 	var page_url = $(".myunit").prop("href"); 
        	alert("page_url"+page_url);
        	$(".myunit").prop("href", page_url+'&taskTypeId='+$("#hiddentaskTypeId").val()); */
        	
        	
            
        }
    });
	
	/* var b = $("#taskTypeId").val();
	
	$("#hiddentaskTypeId").val(b); */
	
	/* $(".mycircle").click(function() {
		 var $this = $(this);      
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		  
		}); */
	
	
	/* $(".myunit").click(function() {
		 var $this = $(this);      
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		  
		}); */
	
	
	
	/* $(".mydivision").click(function() {
		 var $this = $(this);   
		 
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		   
		});
	 */
	/* $(".mysubdivision").click(function() {
		
		
		event.preventDefault();
		
		 var $this = $(this);  
		 
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	      
	      window.location.replace(page_url+'&taskTypeId='+m);
	   
		 //  $this.prop("href", page_url+'&taskTypeId='+m);
		   
		  
		});
	 */
	
	
	
	
});
</script>

<script type="text/javascript">
       
    </script>

<script>
function gettaskunitList(unitId)
{
	
	var m =$("#hiddentaskTypeId").val();
	//alert("minscript"+m);
	
	$("#unitId").val(unitId);
$("#taskTypeId").val(m);

   var page_url="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m;
     window.location.assign(page_url);

     
     $("#myunit").attr('href',page_url);

	/*  document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#taskTypeId").val(m);
	  
	
		 document.forms[0].submit(); 
		 return false;
		  */
		
		 
		   /*   document.forms.casesReport.action="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m; */
		 /* document.forms.casesReport.submit();  */
	
	
	
	
	}
function gettaskcircleList(unitId,circleId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	}
function gettaskdivisionList(unitId,circleId,divisionId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#divisionId").val(divisionId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	
	}
function gettasksubdivisionList(unitId,circleId,divisionId,subdivisionId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#divisionId").val(divisionId);
	   $("#subdivisionId").val(subdivisionId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
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





<div class="w3l-main" id="borderStyle">

	<form:form id="casesReport" method="post" modelAttribute="taskreport2">

		<input name=urlvalue type=hidden>
		<input name=unitId id="unitId" type=hidden>
		<input name=circleId id="circleId" type=hidden>
		<input name=divisionId id="divisionId" type=hidden>
		<input name=subdivisionId id="subdivisionId" type=hidden>
		

<div class="alert alert-info" role="alert">
 <strong>Note : Please Use A4(landscape) Size Paper for Print. Also Selected Data Can be Exported and Printed</strong>
</div>

		<div class="panel panel-primary" style="padding:10px">
			<div class="panel-heading">
				<h3 class="panel-title">CAG Paras Abstract</h3>
			</div>

			




			





  <div>
				

				



					<div
						class="mainprint pagecontent"
						style="display: block">

<%-- <c:if test="${compCapList!=null}"> --%>

						<div class="table-responsive" id="printarea">

							<table class=" display table-bordered " id="table1">
								<thead >
									
									<tr>
										
										<th > Name of Unit</th>
										<th > Name of Circle</th>
										<th > Name of Division</th>
										<th  >Total Paras</th>
										
														
										<th  >Dropped Paras</th>
										<th  >Transferred</th>										
										<th >Balance Paras</th>
										<th  >Reply Sent to Government</th>
										<th >Reply Not sent </th>									
										
										
										
										


									</tr>
									

									

								</thead>


								<tbody>
									
										<c:forEach items="${paraListUnit}" var="t" varStatus="count">
											<tr>

											
													
													
					
											
												
											
												
												
												<td style="color: black "><b><c:out value="${t.unitName}"></c:out> </b></td>
												<td></td>
												<td></td>
												<td  style="color: red"><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${t.unitId}"></c:out> &transferFlag=false &unitTotal=false  " ><c:out value="${t.totalParas}"></c:out></a></td>
												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${t.unitId}"></c:out> &transferFlag=false &paraStatusId=3 &unitTotal=false " ><c:out value="${t.droppedCount}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${t.unitId}"></c:out>  &transferFlag=true &unitTotal=false" ><c:out value="${t.transfrred}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${t.unitId}"></c:out>  &transferFlag=false  &paraStatusId=8 &unitTotal=false  " ><c:out value="${t.balanceParas}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${t.unitId}"></c:out> &transferFlag=false &paraStatusId=4 &unitTotal=false   " ><c:out value="${t.replySent}"></c:out></a></td>

												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${t.unitId}"></c:out> &transferFlag=false &paraStatusId=2 &unitTotal=false   " ><c:out value="${t.replyNotSent}"></c:out></a></td>
												
												
												
												
										</tr>
										
										
										
										

										</c:forEach>
										
										<c:if test="${paraListCircle!=null}">
										<c:forEach items="${paraListCircle}" var="d" varStatus="count">
										
									
										<tr>

												
												<td></td>
													
													
													
					
											
												
											
												
												
												<td style="color: green " ><b><c:out value="${d.circleName}"></c:out> </b></td>
												<td></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${d.unitId}"></c:out>  &transferFlag=false &circleId=<c:out value="${d.circleId}"></c:out> &circleTotal=false" ><c:out value="${d.totalParas}"></c:out></a></td>
												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${d.unitId}"></c:out>   &transferFlag=false &paraStatusId=3 &circleId=<c:out value="${d.circleId}"></c:out> &circleTotal=false" ><c:out value="${d.droppedCount}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${d.unitId}"></c:out>  &transferFlag=true  &circleId=<c:out value="${d.circleId}"></c:out> &circleTotal=false" ><c:out value="${d.transfrred}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${d.unitId}"></c:out> &paraStatusId=8  &transferFlag=false &circleId=<c:out value="${d.circleId}"></c:out> &circleTotal=false"  ><c:out value="${d.balanceParas}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${d.unitId}"></c:out> &paraStatusId=4   &transferFlag=false &circleId=<c:out value="${d.circleId}"></c:out> &circleTotal=false" ><c:out value="${d.replySent}"></c:out></a></td>

												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${d.unitId}"></c:out> &paraStatusId=2  &transferFlag=false &circleId=<c:out value="${d.circleId}"></c:out> &circleTotal=false" ><c:out value="${d.replyNotSent}"></c:out></a></td>
												
												
												
												
										</tr>
										
										
										
											<c:forEach items="${paraListDivision}" var="e" varStatus="count">
											
											
										
										<c:if test="${( d.circleId==e.circleId) }">
										<tr>

												
												<td></td>
													
													
													
					
											
												
											   <td></td>
												
												
												<td style="color: blue "><b><c:out value="${e.divisionName}"></c:out> </b></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${e.unitId}"></c:out>  &transferFlag=false  &circleId=<c:out value="${e.circleId}"></c:out> &divisionId=<c:out value="${e.divisionId}"></c:out>" ><c:out value="${e.totalParas}"></c:out></a></td>
												
												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${e.unitId}"></c:out>  &transferFlag=false &paraStatusId=3 &circleId=<c:out value="${e.circleId}"></c:out> &divisionId=<c:out value="${e.divisionId}"></c:out>" ><c:out value="${e.droppedCount}"></c:out></a></td>
													<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${e.unitId}"></c:out>  &transferFlag=true  &circleId=<c:out value="${e.circleId}"></c:out> &divisionId=<c:out value="${e.divisionId}"></c:out>" ><c:out value="${e.transfrred}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${e.unitId}"></c:out>  &transferFlag=false &paraStatusId=8 &circleId=<c:out value="${e.circleId}"></c:out> &divisionId=<c:out value="${e.divisionId}"></c:out>" ><c:out value="${e.balanceParas}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${e.unitId}"></c:out>   &transferFlag=false &paraStatusId=4 &circleId=<c:out value="${e.circleId}"></c:out> &divisionId=<c:out value="${e.divisionId}"></c:out>" ><c:out value="${e.replySent}"></c:out></a></td>

												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${e.unitId}"></c:out>   &transferFlag=false &paraStatusId=2 &circleId=<c:out value="${e.circleId}"></c:out> &divisionId=<c:out value="${e.divisionId}"></c:out>" ><c:out value="${e.replyNotSent}"></c:out></a></td>
											
												
												
												
										</tr>
										</c:if>
										</c:forEach>
										
										
										
										
									
										
										<c:forEach items="${paraListCircleTotal}" var="g" varStatus="count">
										
										<c:if test="${( d.circleId == g.circleId ) }">
										<tr>

												
												
													
													
													
					
											
												
											  <td></td>
												
												<td style="color: red "><b><c:out value="${g.circleName}"></c:out>  Total</b></td>
												<td></td>
												<td  style="color: red " ><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${g.unitId}"></c:out>  &transferFlag=false &circleId=<c:out value="${g.circleId}"></c:out> &circleTotal=true" ><c:out value="${g.totalParas}"></c:out></a></td>
												
												 
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${g.unitId}"></c:out>  &transferFlag=false  &paraStatusId=3 &circleId=<c:out value="${g.circleId}"></c:out> &circleTotal=true" ><c:out value="${g.droppedCount}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${g.unitId}"></c:out>   &transferFlag=true  &circleId=<c:out value="${g.circleId}"></c:out> &circleTotal=true" ><c:out value="${g.transfrred}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${g.unitId}"></c:out>   &transferFlag=false &paraStatusId=8 &circleId=<c:out value="${g.circleId}"></c:out> &circleTotal=true" ><c:out value="${g.balanceParas}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${g.unitId}"></c:out>   &transferFlag=false &paraStatusId=4 &circleId=<c:out value="${g.circleId}"></c:out> &circleTotal=true" ><c:out value="${g.replySent}"></c:out></a></td>

												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${g.unitId}"></c:out>  &transferFlag=false  &paraStatusId=2 &circleId=<c:out value="${g.circleId}"></c:out> &circleTotal=true" ><c:out value="${g.replyNotSent}"></c:out></a></td>
												
												
												
												
									
										</c:if>
										
										</c:forEach>
										
										
										
										
										
										
										</c:forEach>
									
										</c:if>
										
										
									
										<c:if test="${paraListDivisionWithOutCircle!=null}">
										
									
										
										
										<c:forEach items="${paraListDivisionWithOutCircle}" var="k" varStatus="count">
											
											
									
										
										<c:if test="${(k.unitId>0 && k.circleId>0 && k.divisionId>0) }">
										<tr>

												
												<td></td>
												
													
													
					
											
												
											   <td></td>
												
												
												<td style="color: blue "><b><c:out value="${k.divisionName}"></c:out> </b></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${k.unitId}"></c:out>  &transferFlag=false &circleId=<c:out value="${k.circleId}"></c:out> &divisionId=<c:out value="${k.divisionId}"></c:out>" ><c:out value="${k.totalParas}"></c:out></a></td>
												
												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${k.unitId}"></c:out>  &transferFlag=false &paraStatusId=3 &circleId=<c:out value="${k.circleId}"></c:out> &divisionId=<c:out value="${k.divisionId}"></c:out>" ><c:out value="${k.droppedCount}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${k.unitId}"></c:out>  &transferFlag=true &circleId=<c:out value="${k.circleId}"></c:out> &divisionId=<c:out value="${k.divisionId}"></c:out>" ><c:out value="${k.transfrred}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${k.unitId}"></c:out>  &transferFlag=false &paraStatusId=8 &circleId=<c:out value="${k.circleId}"></c:out> &divisionId=<c:out value="${k.divisionId}"></c:out>" ><c:out value="${k.balanceParas}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${k.unitId}"></c:out>  &transferFlag=false &paraStatusId=4 &circleId=<c:out value="${k.circleId}"></c:out> &divisionId=<c:out value="${k.divisionId}"></c:out>" ><c:out value="${k.replySent}"></c:out></a></td>

												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${k.unitId}"></c:out>  &transferFlag=false &paraStatusId=2 &circleId=<c:out value="${k.circleId}"></c:out> &divisionId=<c:out value="${k.divisionId}"></c:out>" ><c:out value="${k.replyNotSent}"></c:out></a></td>
												
												
												
												
										</tr>
										</c:if>
										
										
										
										<c:forEach items="${paraListCircleTotal}" var="m" varStatus="count">
										
										<c:if test="${( k.circleId == m.circleId ) }">
										<tr>

												
												
												
													
													
					
											
												
											 
												<td></td>
												<td style="color:  red ; "><b><c:out value="${m.circleName}"></c:out>  Total</b></td>
												<td></td>
												<td  ><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${m.unitId}"></c:out>  &transferFlag=false &circleId=<c:out value="${m.circleId}"></c:out> &circleTotal=true" ><c:out value="${m.totalParas}"></c:out></a></td>
												
												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${m.unitId}"></c:out>  &transferFlag=false &paraStatusId=3 &circleId=<c:out value="${m.circleId}"></c:out>  &circleTotal=true" ><c:out value="${m.droppedCount}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${m.unitId}"></c:out>  &transferFlag=true  &circleId=<c:out value="${m.circleId}"></c:out>  &circleTotal=true" ><c:out value="${m.transfrred}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${m.unitId}"></c:out>  &transferFlag=false &paraStatusId=8 &circleId=<c:out value="${m.circleId}"></c:out>  &circleTotal=true" ><c:out value="${m.balanceParas}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${m.unitId}"></c:out>  &transferFlag=false &paraStatusId=4 &circleId=<c:out value="${m.circleId}"></c:out>  &circleTotal=true" ><c:out value="${m.replySent}"></c:out></a></td>

												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${m.unitId}"></c:out>  &transferFlag=false &paraStatusId=2 &circleId=<c:out value="${m.circleId}"></c:out>  &circleTotal=true" ><c:out value="${m.replyNotSent}"></c:out></a></td>
												
												
												
												
										</tr>
									
										</c:if>
											
										</c:forEach>
										
										</c:forEach>
									
										
										</c:if>
										
										<c:forEach items="${paraListUnitTotal}" var="h" varStatus="count">
										
										
										<tr>

												
												
													
													
													
					
											
												
											 
												
												<td style="color: red "><b><c:out value="${h.unitName}"></c:out>  Total</b></td>
												<td></td>
												<td></td>
												
												<td  style="color: red "><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${h.unitId}"></c:out>  &transferFlag=false &unitTotal=true" ><c:out value="${h.totalParas}"></c:out></a></td>
												
												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${h.unitId}"></c:out>  &transferFlag=false &paraStatusId=3 &unitTotal=true" ><c:out value="${h.droppedCount}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${h.unitId}"></c:out>  &transferFlag=true   &unitTotal=true" ><c:out value="${h.transfrred}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${h.unitId}"></c:out>  &transferFlag=false &paraStatusId=8  &unitTotal=true" ><c:out value="${h.balanceParas}"></c:out></a></td>
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${h.unitId}"></c:out>  &transferFlag=false  &paraStatusId=4 &unitTotal=true" ><c:out value="${h.replySent}"></c:out></a></td>

												
												<td><a target="_blank"  href="../parasreport/CAGAbstractDetail?unitId=<c:out value="${h.unitId}"></c:out>  &transferFlag=false &paraStatusId=2  &unitTotal=true" ><c:out value="${h.replyNotSent}"></c:out></a></td>
												
												
												
												
										</tr>
										
										</c:forEach>
									


									
									
								</tbody>


							</table>
							
							
	<script src="../js/Html5DataTable/jquery-3.3.1.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.print.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>
	
	<script type="text/javascript">			
							
    $('#table1').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "autoWidth": true,
        "lengthChange": false,
        "pageLength": 20,
        buttons: [
            'copyHtml5',
            {
                extend: 'excelHtml5',
                autoFilter: true,
                sheetName: 'Exported Paras data',
                text:  'Save To Excel',
                className: 'btn btn-1 btn-primary ',
                messageTop: 'IR Paras AG Paras Report'
                
                
            },
            
            {
                extend: 'pdfHtml5',
                className: 'btn btn-1 btn-primary ',
                text:  'PDF View / Download',
                orientation: 'landscape',
                pageSize: 'A4',
                download: 'open',
            
               
                filename: 'IR_Paras_Report',
                exportOptions: {
					columns: ':visible',
					search: 'applied',
					order: 'applied'
				},
				
               
                title: 'IR Paras AG Paras Report',
                customize: function (doc) {        
                	doc.defaultStyle.fontSize = 11;
                	doc.defaultStyle.alignment = 'center';
                	doc.styles.tableHeader.fontSize = 14;
                	doc.pageMargins = [90, 80,80,90];
                	 doc['footer']=(function(page, pages) {
                      	return {
                      	columns: [
                     
                      	{
                      	alignment: 'right',
                      	text: [
                      	{ text: page.toString(), italics: true },
                      	' of ',
                      	{ text: pages.toString(), italics: true }
                      	]
                      	}
                      	],
                      	margin: [5, 0]
                      	}
                      	});
      				
                	
                	
                }
				
               
            },
            {
                extend: 'print',
                text: 'Print All',
                className: 'btn btn-1 btn-primary ',
                exportOptions: {
                    modifier: {
                        selected: null
                    }
                }
               
                
                
            },
            ,{
                extend: 'print',
                text: 'Print Selected',
                className: 'btn btn-1 btn-primary '
                
                
                
            }
        ],
        select: true
       
    } );
    
    </script>	
								
							


						</div>
					<%-- 	</c:if> --%>
					

					</div>

</div>

			
			
		</div>





		<div class="row show-grid">
			<div class="clearfix"></div>
			<div class="clearfix"></div>
			<div class="col-md-4"></div>
			<!-- <div class="col-md-4">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table1', 'countertable')" >
					</div>

			<div class="col-md-2">
				<input type="button" value="Print Preview"
					class="btn btn-1 btn-primary center-block"
					onclick="PrintPreview('printarea')" />
			</div>
			<div class="col-md-2">
				<input type="button" class="btn btn-1 btn-primary center-block"
					id="getCasesId" value="Print" onclick="printDiv('printarea')">
			</div>
 -->

		</div>

	</form:form>
</div>
<!-- //main-content -->



















<script type="text/javascript" src="../js/parsley.js"></script>



   <script type="text/javascript" class="example">
$(function () {
	 $('#getParaCount').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.getParaCount.action="../parasreport/cagstatus";
				 document.forms.getParaCount.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script>
	  


<!-- //main-content -->
