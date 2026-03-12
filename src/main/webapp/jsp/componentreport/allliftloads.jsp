
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
		



		<div class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Load Details of Pumping Stations</h3>
			</div>

			




				<div class="row col-md-12 toppad ">



					<form:form id="alllifts" method="post" modelAttribute="complifts"
						data-parsley-validate-if-empty="">
						
						
						
				<div class="col-md-12">
							<div class="form-group">
        <label class="col-sm-4 control-label">Select Lift Status </label>
        <div class="col-sm-8" id="statusdiv">
       
        
        <label class="radio-inline"> <input type="radio" name="statusId" id="statusId"  checked="checked"    value="1"  required >Commissioned</label>
        <label class="radio-inline"> <input type="radio" name="statusId" id="statusId"     value="2"  required >Not Commissioned</label>
        <label class="radio-inline"> <input type="radio" name="statusId" id="statusId"      value="3"  required >In Progress</label>
        <label class="radio-inline"> <input type="radio" name="statusId" id="statusId"     value="4"  required >Not Tackled</label>
        
       
       
          
         
        </div>
    </div>
						</div>
					



					






					
							<div class="col-md-12">
							<br></br>
								<input type="submit" class="btn btn-1 btn-primary center-block"
									id="getliftschemes" value="Get Lift Schemes" >
							</div>
						

					</form:form>






				

				



					<div
						class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  mainprint pagecontent"
						style="display: block">

<c:if test="${compCapList!=null}">

						<div class="row show-grid gridList  col-md-12" id="printarea">

							<table class="table-responsive table-bordered " id="table">
								<thead style="background: #D3D3D3 none repeat scroll 0 0;">
									
									<tr>
										<th rowspan="1">Sl.No</th>
										<th rowspan="1">Name of Work</th>
										<th rowspan="1" colspan="2">Small Lift Schemes(with less than 5MW rating for each pump) </th>
										
										<th rowspan="1" colspan="2">Medium Lift Schemes(with more than 5 MW and less than 10MW rating for each pump)</th>
										<th rowspan="1" colspan="2">Major Lift Schemes (with more than 10MW rating for each pump )</th>
										


									</tr>
									<tr>
										<th rowspan="1"></th>
										<th rowspan="1"></th>
										<th rowspan="1" colspan="1">Total Connected Load</th>
										<th rowspan="1" colspan="1">Total Actual Load</th>
										<th rowspan="1" colspan="1">Total Connected Load</th>
										<th rowspan="1" colspan="1">Total Actual Load</th>
										<th rowspan="1" colspan="1">Total Connected Load</th>
										<th rowspan="1" colspan="1">Total Actual Load</th>
										
										


									</tr>

									

								</thead>


								<tbody>
									
										<c:forEach items="${compCapList}" var="t" varStatus="count">
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
												<td><b><c:out value="${t.componentName}"></c:out></b></td>
												<td><c:out value="${t.smallconnected}"></c:out></td>
												<td><c:out value="${t.smallactual}"></c:out></td>
												<td><c:out value="${t.mediumconnected}"></c:out></td>
												<td><c:out value="${t.mediumconnected}"></c:out></td>

												<td><c:out value="${t.majorconnected}"></c:out></td>
												<td><c:out value="${t.majoractual}"></c:out></td>
										</tr>

										</c:forEach>
									


									<tr style="color: red; font-weight: bold;">
										<td   colspan="2" style="text-align: center;">Total</td>
										<td>${totalsmallconnected}</td>
										<td>${totalsmallactual}</td>
										<td>${totalmediumconnected}</td>
										<td>${totalmediumacttual}</td>
										<td>${totalmajorconnected}</td>
										<td>${totalmajoractual}</td>
										
									</tr>
									<c:if test="${compCapList!=null}">
									<tr><td colspan="8"><table >
									
						
						
								<thead style="background: #D3D3D3 none repeat scroll 0 0;">
									<tr><th colspan="8"><b>Abstract of pumping station</b> </th></tr>
									<tr>
										<th rowspan="1" colspan="4">Type Lift Irrigation Schemes</th>
										<th rowspan="1" colspan="2">Connected Load in MW</th>
										<th rowspan="1" colspan="2">Actual Load in MW</th>
										
										


									</tr>
								

									

								</thead>


								<tbody>
								
                                 <tr><td colspan="4">Small Lift Irrigation Schemes (With less than 5MW rating for each pump)</td><td  colspan="2">${totalsmallconnected}</td><td  colspan="2">${totalsmallactual}</td></tr>
                                 <tr><td colspan="4">Medium Lift Irrigation Schemes (With more than 5MW and less than 10MW rating for each pump)</td><td  colspan="2">${totalmediumconnected}</td><td  colspan="2">${totalmediumacttual}</td></tr>
                                 <tr><td colspan="4">Major Lift Irrigation Schemes (With more than 10MW rating for each pump)</td><td  colspan="2">${totalmajorconnected}</td><td  colspan="2">${totalmajoractual}</td></tr>

									<tr style="color: red; font-weight: bold;">
										<td   colspan="4" style="text-align: center;">Total</td><td  colspan="2">${abstractconnectedload}</td><td  colspan="2">${abstractactualload}</td></tr>
										
										
										
										
										
										
										
									
								</tbody>

</table></td></tr>	</c:if>
									
									
								</tbody>


							</table>
								
							


						</div>
						</c:if>
					

					</div>



				</div>
			
		</div>





		<div class="row show-grid">
			<div class="clearfix"></div>
			<div class="clearfix"></div>
			<div class="col-md-4"></div>
			<div class="col-md-2">
				<input type="submit" class="btn btn-1 btn-primary center-block"
					id="getCasesId" value="Excel Export"
					onclick="tableToExcel('table', 'countertable')">
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


		</div>

	</form:form>
</div>
<!-- //main-content -->



















<script type="text/javascript" src="../js/parsley.js"></script>



   <script type="text/javascript" class="example">
$(function () {
	 $('#alllifts').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.alllifts.action="../compReport/getliftsall";
				 document.forms.alllifts.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script>
	  


<!-- //main-content -->
