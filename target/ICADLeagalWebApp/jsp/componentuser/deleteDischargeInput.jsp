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
 /* var tableToExcel = (function() {
  var uri = 'data:application/vnd.ms-excel;base64,'
    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office"<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
    , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
  return function(table, name) {
    if (!table.nodeType) table = document.getElementById(table);
    var ctx = {worksheet:  'Worksheet', table: table.innerHTML};
    window.location.href = uri + base64(format(template, ctx));
       }
})()  */
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
	 

	 

		
	

	
});
</script>


<script >

	
	
/* function getcomps(projectId,unitId)
{
	alert("kalcoming"+projectId);
	
	document.forms[0].urlvalue.value="../comptsimis/deleteCompdailyInput";
	
	   $("#projectId").val(projectId);
	   $("#unitId").val(unitId);
	   $("#deleteFlag").val(false);
	 
		 document.forms[0].submit(); 
	
	
	
	} */
	
	function deletedischrageInfo(inputId,comp){
		
		
		document.forms[0].urlvalue.value="../comptsimis/deleteDischargeInput";
		
		// alert(inputId);
		// alert(comp);
		   $("#compDischargeId").val(inputId);
		   $("#deleteFlag").val(true);
		   $("#componentId").val(comp);
		   
		   
		 
			 document.forms[0].submit(); 
		
		
		
		
	}
	
function getcompdischargeinfo(compId,unitId)


{
	
	//alert("kal"+compId);

	 $("#deleteFlag").val(false);
	 $("#unitId").val(unitId);
	 $("#componentId").val(compId);
	 
			
	document.forms[0].urlvalue.value="../comptsimis/deleteDischargeInput";
	
	  
	 
		 document.forms[0].submit(); 
	
	
	
	
	}
	



	

	
	function editdischargeData(compDischargeId){
		 $("#editFlag").val(true);
		
		 var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	 	  	var url="../comptsimis/editCompDischargeInput?compDischargeId="+compDischargeId+"&editFlag="+false;
	 	  	
	 		popup =window.open(url,"_blank",features);
		
		
		
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
<div class="w3_agile_main_left">
		<!--start left block-->
	 
<form:form id="deleteCompdailyInput" method="post"
				modelAttribute="deleteDischargeInput" >
				<input name=urlvalue type=hidden >
				<!-- <input name=unitId  id="unitId" type=hidden > -->
				<!-- <input name=projectId  id="projectId" type=hidden >  -->
				<input name=compDischargeId  id="compDischargeId" type=hidden >
				
				<input name=editFlag  id="editFlag" type=hidden value="false" >
				
				<input name=deleteFlag  id="deleteFlag" type=hidden value="false" >
				
				
				
	
				
				
		
	<!-- 	<div class="col-md-3 w3layouts-second"> -->
		
		
		
	 
	<div class="col-md-12 "> 
		
		
		

 <div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">


<c:forEach items="${unitList}" var="u">								
	<li>
	

	<a class="myunit"  href="../comptsimis/deleteDischargeInput?unitId=<c:out value="${u.unitId}"></c:out>" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	  <input name=unitId     id="unitId" type=hidden  value="<c:out value="${u.unitId}"></c:out>" />
	  
	
	
	<ul>
	<c:forEach items="${prList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	   <input name=projectId    id="projectId"  type=hidden  value="<c:out value="${c.projectId}"></c:out>" />
	 
		<li><a class="mycircle"  href="#"><c:out value="${c.projectName}"></c:out></a>
		
		
		
			<ul>
	<c:forEach items="${compsList}" var="d">
	 <c:if test="${c.projectId==d.projectId}"> 
	  <input name=componentId    id="componentId"  type=hidden  value="<c:out value="${d.componentId}"></c:out>" />
	
		<li><a class="mycomps"  onclick="getcompdischargeinfo(<c:out value="${d.componentId}"></c:out>,<c:out value="${u.unitId}"></c:out>)"  href="javascript:void(0);"><c:out value="${d.componentName}"></c:out></a>
		
		
		
		
		
		
		</li>
		
		</c:if> 
		</c:forEach>

	</ul>
		
		
		
		
		</li>
		</c:if>
		</c:forEach>

	</ul>
	
	
	</li>
	
	</c:forEach>  
	
		
		
		
	</ul>
	
</div> 

</div>
	
	
		
		
	
	
	
	
	<div class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Edit/Delete Component Discharge Input</h3>
			</div>

			<!-- <div class='container'> -->

 

			
				
				<div class="col-md-12">
		<div class="col-md-10">
		</div>
		<div class="col-md-2">
				<a href="../comptsimis/deleteDischargeInput">	<input type="button" class="btn btn-1 btn-primary center-block"
						id="getcomps" value="Back"   >
						</a>
				</div>
				</div>
					
					
			
					
						
	<!-- <div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  col-md-8" style="display:block"> -->
		
		
		<c:if test="${compInfList!=null}">
		
		<div class="col-md-12">	
		
		<div class="col-md-2" style="color:blue">Unit:</div>
					<div class="col-md-2" style="color:red">
					
					<c:out value="${compInfList[0].unitName}"></c:out>
					</div>
					<div class="col-md-2" style="color:blue">Project:</div>
					<div class="col-md-2" style="color:red">
				
				<c:out value="${compInfList[0].projectName}"></c:out>
				</div>
				<div class="col-md-2" style="color:blue">Component:</div>
				<div class="col-md-2" style="color:red">
				<c:out value="${compInfList[0].componentName}"></c:out> 
				</div>
					
			
		</div>
		
		
		
		
		
		<div class="col-md-12">
		<br></br>
						
									<div class="col-md-1">Sl.No</div>
								
									<div class="col-md-2">Season</div>
									<div class="col-md-2">Year</div>
									
									<div class="col-md-1">Month</div>
								
									<div class="col-md-2">Discharge</div>
									<div class="col-md-1">Ayacut</div>
									<div class="col-md-1">Remarks</div>
									
									<div class="col-md-1">Edit / Delete</div>
									
									
									
						</div>			
								<c:forEach items="${compInfList}" var="t" varStatus="count">
									 
								<div class="col-md-12"  style="color: blue">
									
									 
										<br></br>
										
											
											<div class="col-md-1"><c:out	value="${count.count}"></c:out></div>											
											
											<div class="col-md-2"><c:out value="${t.seasonName}"></c:out>  </div>
											<div class="col-md-2"><c:out value="${t.seasonYear}"></c:out>  </div>
											<div class="col-md-1"><c:out value="${t.seasonMonthName}"></c:out> </div>
											
											<div class="col-md-2"><c:out value="${t.pumpDischarge}"></c:out>  </div>
											<div class="col-md-1"><c:out value="${t.ayacut}"></c:out> </div>
											
											<div class="col-md-1"><c:out value="${t.remarks}"></c:out> </div>
										
											
											<div class="col-md-2">  <button type="button" class="btn btn-primary btn-sm" onclick='editdischargeData(<c:out value="${t.compDischargeId}"></c:out>)' ><span class="glyphicon glyphicon-plus"></span></button>
											
							          <button type="button" class="btn btn-danger btn-sm" onclick='deletedischrageInfo(<c:out value="${t.compDischargeId}"></c:out>,<c:out value="${t.componentId}"></c:out> )'><span class="glyphicon glyphicon-remove"></span></button></div>
															
											
										
											
											
											
											
						
							
							</div>
							</c:forEach>
									
								
								
							
					</c:if>
				
	
</div>

	

		
	<div class="row show-grid">
		
					</div>
		
</form:form>
	</div> 	
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
