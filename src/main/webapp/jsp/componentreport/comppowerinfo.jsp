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

<script type = "text/javascript">
       
    </script>

<script >
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
	 
<form:form id="casesReport" method="post"
				modelAttribute="taskreport2" >
				
				<input name=urlvalue type=hidden >
				<input name=unitId  id="unitId" type=hidden >
				<input name=circleId  id="circleId" type=hidden >
				<input name=divisionId  id="divisionId" type=hidden >
				<input name=subdivisionId  id="subdivisionId" type=hidden >
	<div class="w3_agile_main_left">
		<!--start left block-->
	<!-- 	
		<div class="col-md-3 w3layouts-second">
		
		
		
	 
	<div class="col-md w3l-accordion-mk"> 
		 -->
		
		

<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">

<c:forEach items="${unitList}" var="u">
									<%-- <option value="${u.unitId}">${u.unitName}</option>
 --%>
								
	<li><a class="myunit"  href="../compReport/comppowerinfo?unitId=<c:out value="${u.unitId}"></c:out> &projectId=16" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	<ul>
	<c:forEach items="${prList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	<%-- ../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out> --%>
		<li><a class="mycircle" href="../compReport/comppowerinfo?projectId=<c:out value="${c.projectId}"></c:out>"><c:out value="${c.projectName}"></c:out></a>
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

<!-- </div> -->
	 <!-- </div> -->
	
	
	
		
			
			<!-- 9th-section -->
	
		</div>
		
		
	
	
	<div class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Power Information of Lift Schemes</h3>
			</div>

			<div class='container'>




				<div class="row col-md-12 toppad ">

				
				<div class="row show-grid">
		<div class="col-md-10">
		</div>
		<div class="col-md-2">
				<a href="../compReport/comppowerinfo">	<input type="button" class="btn btn-1 btn-primary center-block"
						id="gettasks" value="Back"   >
						</a>
				</div>
				</div>
				
				
					
				
					
						
	 <div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  mainprint pagecontent" style="display:block"> 
		
		
		
	<!-- 	 <div class="row show-grid gridList  col-md-12" id="printarea"  > -->
		 
		
						<table class="table-responsive table-bordered " id="table">
							<thead style="background: #D3D3D3 none repeat scroll 0 0;">
							<tr style="color: red; font-weight: bold; background: #ffffff;"><td></td><td><c:out value="${displayunit}"></c:out></td><td><c:out value="${displayvalue}"></c:out></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td> </td><td><c:out value="${displaytype}"></c:out> </td> </tr>
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1" >Location</th>
									<c:forEach items="${compList}" var="t" varStatus="count">
									<th rowspan="1"> ${t.componentName}</th>
									
									</c:forEach>
									<th colspan="1" style="text-align: center; color: red">  Total</th>
									
									
									
									
								</tr>
							

								
							
								

							</thead>

							
							<tbody>
								<c:if test="${compList!=null}">
									
										<tr>
											
<td style="text-align: center;">1</td><td><b>Motor Type</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td>

<c:out value="${t.motorType}"></c:out> </td>	
</c:forEach>								
							             </tr>
							             <tr>											
<td style="text-align: center;">2</td><td><b>Motor Make</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.motorMake}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td style="text-align: center;">3</td><td><b>Pump Type</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.pumpType}"></c:out> </td>		
</c:forEach>									
							             </tr>
							             <tr>											
<td style="text-align: center;">4</td><td><b>Pump Make</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.pumpMake}"></c:out> </td>		
</c:forEach>									
							             </tr>
							             <tr>											
<td style="text-align: center;">5</td><td><b>NO . of pumps and motors</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.motorNumber}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td >6</td><td><b>Pump Discharge cumecs</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.dischrgecusecs}"></c:out> </td>	
</c:forEach>	
<td style="color: red">${totaldischargecusecs}</td>									
							             </tr>
							             <tr>											
<td >7</td><td><b>Pipe Dia</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.pipediameter}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td >8</td><td><b>Length in KMS</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.pmlength}"></c:out> </td>
</c:forEach>											
							             </tr>
							             <tr>											
<td>9</td><td><b>No. Of rows</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.noofpiperows}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td >10</td><td><b>Static Head</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.liftStatic}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td >11</td><td><b>Dynamic Head</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.liftDynamic}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td >12</td><td><b>Total lift in mts</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.totalLift}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td style="text-align: center;">13</td><td><b>Total lifting period</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.liftperiod}"></c:out> for <c:out value="${t.lifttmc}"></c:out> tmc </td>	</c:forEach>										
							             </tr>
							             <tr>											
<td >14</td><td><b>Mddl(mts)</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.mddlsign}"></c:out> </td>
</c:forEach>											
							             </tr>
							             <tr>											
<td >15</td><td><b>Delivery level</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.deliverylevelsign}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td >16</td><td><b>Power for each motor</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.eachmotorPower}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td >17</td><td><b>Total Power for Motors</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.totalpower}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td >18</td><td><b>Auxilary power</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.auxPower}"></c:out> </td>	
</c:forEach>										
							             </tr>
							             <tr>											
<td >19</td><td><b>Total Power Requirement for all pumping stations including Auxilary power</b> </td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.totalpowerwithAux}"></c:out> </td>
</c:forEach>
<td style="color: red">${newtotalPowerWithAux}</td>											
							             </tr>
							             <tr>											
<td style="text-align: center;">20</td><td><b>Sub Station Capacity</b></td>
<c:forEach items="${compList}" var="t" varStatus="count">
<td><c:out value="${t.substationCapacity}"></c:out> </td>
</c:forEach>											
							             </tr>
							        
							
						
							</c:if>
									
								
							
								</tbody>
							

						</table>
						
				
					<!-- </div> -->
					
				
		 </div>

					

</div>
</div>
</div>

	

		
	
		<div class="row show-grid">
					<div class="clearfix"> </div>
					<div class="clearfix"> </div>
					<div class="col-md-4"></div>
					<div class="col-md-2">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table', 'countertable')" >
					</div>
					
					<div class="col-md-2">
					 <input type="button" value="Print Preview" class="btn btn-1 btn-primary center-block" onclick="PrintPreview('mainprint')"/>
					 </div>
					<div class="col-md-2">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Print"  onclick="printDiv('mainprint')" >
					</div>
					
					
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
