	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 

<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
 
 
 <link rel="stylesheet" href="../css/treeview/jquery.treeview.css" />
<!-- <link rel="stylesheet" href="../red-treeview.css" /> -->

<!-- <script src="../js/treeview/lib/jquery.js" type="text/javascript"></script> -->
<script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script>
 
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
			$("#tree").treeview({
				collapsed: true,
				animated: "medium",
				control:"#sidetreecontrol",
				persist: "location"
			});
			
			
			
			/* var a=$(".resayacutCon").val();
			alert("a"+a); */
		})
		
	</script>

<script>
$(document).ready(function(){

	
	
	MergeCommonRows($("#table"), 2);
	MergeCommonRows($("#table"), 3);
	MergeCommonRows($("#table"), 6);
	 
	
	  
			
});


function MergeCommonRows(table, columnIndexToMerge) {
	
    previous = null;
    cellToExtend = null;
    table.find("td:nth-child(" + columnIndexToMerge + ")").each(
            function() {
                jthis = $(this);
                content = jthis.text();
                if (previous == content) {
                	
                    jthis.remove();
                    if (cellToExtend.attr("rowspan") == undefined) {
                        cellToExtend.attr("rowspan", 2);
                    } else {
                        currentrowspan = parseInt(cellToExtend
                                .attr("rowspan"));
                        cellToExtend.attr("rowspan",
                                currentrowspan + 1);
                    }
                } else {
                    previous = content;
                    cellToExtend = jthis;
                }
            });
};


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

/* function printDiv(divName) {
    var toPrint = document.getElementById(divName);
    var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');
    popupWin.document.open();
    popupWin.document.write('<html><title>::Preview::</title><link rel="stylesheet" type="text/css" href="print.css" /></head><body onload="window.print()">')
    popupWin.document.write(toPrint.innerHTML);
    popupWin.document.write('</html>');
    popupWin.document.close();
} */
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

function printDiv(divID) {
	//Get the HTML of div

	var divElements = document.getElementById(divID).innerHTML;
	//Get the HTML of whole page
	var oldPage = document.body.innerHTML;

	//Reset the page's HTML with div's HTML only
	document.body.innerHTML = "<html><head><title></title></head><body>"
			+ divElements + "</body>";
	//Print Page
	window.print();

	//Restore orignal HTML
	document.body.innerHTML = oldPage;
}

</script>
<style type="text/css">    table th, table td{

        padding: 7px; /* Apply cell padding */

    }</style>
<script type = "text/javascript">
       
    </script>

<script >
/*function gettaskunitList(unitId)
{
	
	var m =$("#hiddentaskTypeId").val();
	//alert("minscript"+m);
	
	$("#unitId").val(unitId);
$("#taskTypeId").val(m);

   var page_url="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m;
     window.location.assign(page_url);

     
     $("#myunit").attr('href',page_url);

	  document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#taskTypeId").val(m);
	  
	
		 document.forms[0].submit(); 
		 return false;
		  */
		
		 
		   /*   document.forms.casesReport.action="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m; */
		 /* document.forms.casesReport.submit();  
	
	
	
	
	}*/
/* function gettaskcircleList(unitId,circleId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	} */
/* function gettaskdivisionList(unitId,circleId,divisionId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#divisionId").val(divisionId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	
	} */
/* function gettasksubdivisionList(unitId,circleId,divisionId,subdivisionId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#divisionId").val(divisionId);
	   $("#subdivisionId").val(subdivisionId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	} */
</script>


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

<div  class="w3l-main" id="borderStyle" >
	 
<form:form id="casesReport" method="post"
				modelAttribute="taskreport2" >
				
				<!-- <input name=urlvalue type=hidden >
				<input name=unitId  id="unitId" type=hidden >
				<input name=circleId  id="circleId" type=hidden >
				<input name=divisionId  id="divisionId" type=hidden >
				<input name=subdivisionId  id="subdivisionId" type=hidden > -->
	<%-- <div class="w3_agile_main_left">
		<!--start left block-->
		
		<!-- <div class="col-md-2 w3layouts-second">
		
		
		
	 
	<div class="col-md w3l-accordion-mk"> 
		
		 -->
		

<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">

<c:forEach items="${unitList}" var="u">
									<option value="${u.unitId}">${u.unitName}</option>

								
	<li><a class="myunit"  href="../compReport/projectComponents?unitId=<c:out value="${u.unitId}"></c:out> &projectId=16" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	<ul>
	<c:forEach items="${prList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>
		<li><a class="mycircle" href="../compReport/projectComponents?projectId=<c:out value="${c.projectId}"></c:out>"><c:out value="${c.projectName}"></c:out></a>
			<ul>
	
		</ul>
		
		
		</li>
		</c:if>
		</c:forEach>
		
		


	</ul>
	</li>
	
	</c:forEach>  
	
		
		
		
	</ul>
	
</div>

<!-- </div>
	 </div>
	 -->
	
	
		
			
			<!-- 9th-section -->
	
		</div> --%>
		
		
	
	<div class="row show-grid  "  >
		 <div class="col-md-4"></div>
		 <div class="col-md-4">
		
						<input type="button" value="Print Page" class="btn btn-1 btn-primary center-block"
							onclick="javascript:printDiv('printable')" />
					
		 </div>
		 <div class="col-md-4"></div>
		 
		 </div>	
	
		 
	
			<div  id="printable" class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Project Ayacut Report</h3>
			</div>			
					<div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  mainprint pagecontent" style="display:block"> 
					
						<c:if test="${ayacutList!=null}">
						
						<table class="table-responsive table-bordered " id="table">
						<thead style="background: #e9e9e9 none repeat scroll 0 0;">
						<tr><th>S.No</th>
						<th>Constituency </th>
						<th>Project </th> 
					 
						
						<th>New Ayacut Proposed (Contemplated)</th>
						<th>Stabilization</th>
							
								<th>Package </th> 
						<th>Unit</th>
						<th>District</th>
						<!--  <th>Remarks</th>  --></tr>
						</thead>
						<tbody>
							
						
						<c:forEach items="${ayacutList}" var="y" varStatus="count">
					
							
							<c:if test="${y.projectId!=-3 }">
							<tr ><td style="text-align: center;" >${count.count}</td>
							
							<td style="color: blue; text-align:center" ><c:out value="${y.constName}"></c:out> </td>
							 <td style="color: blue" ><c:out value="${y.projectName}"></c:out> </td>
							
							
							<td style="text-align: center;" ><c:out value="${y.presentAyacutCreated}"></c:out> </td>
							 
							<td style="text-align: center;" ><c:out value="${y.stableAyacut}"></c:out> </td>
							
							  <td style="color: blue" ><c:out value="${y.packageName}"></c:out> </td>
							<td class="cell"><b><c:out value="${y.unitName}"></c:out></b></td>
							<td style="text-align: center;" ><c:out value="${y.districtName}"></c:out>  </td>
							
							</c:if>
							<c:if test="${y.projectId==-3 }">
							<tr style="color: red; text-align:center" ><td colspan="3"><c:out value="${y.constName}"></c:out> </td>
								<td style="text-align: center;" ><c:out value="${y.presentAyacutCreated}"></c:out> </td>
							 
							<td style="text-align: center;" ><c:out value="${y.stableAyacut}"></c:out> </td></tr>
							
							</c:if>
							
					
							</c:forEach>
							
							
							</tbody>
							</table>
							</c:if>
						
						
				
					<!-- </div>
					 -->
				
		 </div>
		 </div>

					





	

		
	
		<div class="row show-grid">
					<div class="clearfix"> </div>
					<div class="clearfix"> </div>
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table', 'countertable')" >
					</div>
					
					<div class="col-md-4"></div>
					<!-- <div class="col-md-2">
					 <input type="button" value="Print Preview" class="btn btn-1 btn-primary center-block" onclick="PrintPreview('mainprint')"/>
					 </div>
					<div class="col-md-2">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Print"  onclick="printDiv('mainprint')" >
					</div>
					 -->
					
					</div>	
		
</form:form>	
</div>
 

<!-- //main-content -->







	




		
		
	
	 
	
	 
	 
	 <script type="text/javascript" src="../js/parsley.js"></script>
	
    
    
 <!--    <script type="text/javascript" class="example">
$(function () {
	 $('#casesReport').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.casesReport.action="../webReports/abstractCounterFiles";
				 document.forms.casesReport.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script>
	  -->
	 

<!-- //main-content -->
