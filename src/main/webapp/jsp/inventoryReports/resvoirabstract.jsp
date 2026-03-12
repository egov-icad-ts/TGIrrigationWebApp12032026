
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>

<title>IR Paras AG Paras Information</title>

<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">

<!-- <link rel="stylesheet" type="text/css" href="../css/Html5DataTable/datatables.min.css"/>
<script type="text/javascript" src="../js/Html5DataTable/datatables.min.js"></script>
 <script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>  -->
<!--  <script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>  -->


<!-- <link rel="stylesheet" href="../css/treeview/jquery.treeview.css" /> -->
<!-- <link rel="stylesheet" href="../red-treeview.css" /> -->

<!-- <script src="../js/treeview/lib/jquery.js" type="text/javascript"></script> -->
<!-- <script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script> -->
<!-- <script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script> -->


<!-- <script src="../js/Html5DataTable/jquery-3.3.1.js" type="text/javascript"></script>
 <script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>
 <script src="../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>
<script src="../js/Html5DataTable/buttons.flash.min.js" type="text/javascript"></script>
<script src="../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>
<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>
<script src="../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>


 -->

<!-- -->











<link rel="stylesheet"
	href="../css/Html5DataTable/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href=" ../css/Html5DataTable/buttons.dataTables.min.css" />



<script type="text/javascript">
	var tableToExcel = (function() {

		var uri = 'data:application/vnd.ms-excel;base64,', template = '<html xmlns:o="urn:schemas-microsoft-com:office:office"<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>', base64 = function(
				s) {
			return window.btoa(unescape(encodeURIComponent(s)))
		}, format = function(s, c) {
			return s.replace(/{(\w+)}/g, function(m, p) {
				return c[p];
			})
		}
		return function(table, name) {
			if (!table.nodeType)
				table = document.getElementById(table);
			var ctx = {
				worksheet : 'Worksheet',
				table : table.innerHTML
			};
			window.location.href = uri + base64(format(template, ctx));
		}
	})()
</script>

<script type="text/javascript">
	/* $(function() {
		$("#tree").treeview({
			collapsed: true,
			animated: "medium",
			control:"#sidetreecontrol",
			persist: "location"
		});
		
		 
		 

	})
	 */
</script>

<script>
	$(document).ready(function() {

		/* var example=$("#table").DataTable({
		 responsive: true,
		 dom: 'Bfrtip',
		 "paging": false,
		 "autoWidth": true,
		 "lengthChange": false,
		 "pageLength": 20,
		 buttons: [
		 {
		 extend: 'pdfHtml5',
		 className: 'btn btn-1 btn-primary ',
		 text:  'PDF View / Download',
		 orientation: 'landscape',
		 pageSize: 'A3',
		 download: 'open',
		 font:'22',
		 filename: 'IR_Paras_Report',
		 exportOptions: {
		 columns: ':visible',
		 search: 'applied',
		 order: 'applied'
		 },
		
		
		 title: 'IR Paras AG Paras Information Report',
		 customize: function (doc) {        
		 doc.defaultStyle.fontSize = 22;
		 doc.defaultStyle.alignment = 'center';
		 doc.styles.tableHeader.fontSize = 25;
		
		
		 }
		
		
		 },{
		 extend: 'excelHtml5',
		 autoFilter: true,
		 sheetName: 'Exported Paras data',
		 text:  'Excel Export',
		 className: 'btn btn-1 btn-primary ',
		 messageTop: 'The information in this table is copyright to Sirius Cybernetics Corp.',
		 customize: function( xlsx ) {
		 var sheet = xlsx.xl.worksheets['sheet1.xml'];
		
		 $('row c[r^="C"]', sheet).attr( 's', '2' );
		 }
		
		 },{
		 extend: 'print',
		 text: 'Print all',
		 className: 'btn btn-1 btn-primary ',
		
		
		
		 },
		 {
		 extend: 'print',
		 text: 'Print selected',
		 className: 'btn btn-1 btn-primary ',
		 exportOptions: {
		 modifier: {
		 selected: true
		 }
		 }
		
		 }
		
		 ],
		
		 select: true
		 });

		
		 example.buttons().container().appendTo( '#table_wrapper .col-md-6:eq(0)' ); */

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
		var popupWin = window.open('', '_blank',
				'width=350,height=150,location=no,left=200px');
		popupWin.document.open();
		popupWin.document
				.write('<html><title>::Preview::</title><link rel="stylesheet" type="text/css" href="print.css" /></head><body onload="window.print()">')
		popupWin.document.write(toPrint.innerHTML);
		popupWin.document.write('</html>');
		popupWin.document.close();
	}
	/*--This JavaScript method for Print Preview command--*/
	function PrintPreview(divName) {
		var toPrint = document.getElementById(divName);
		var popupWin = window.open('', '_blank',
				'width=350,height=150,location=no,left=200px');
		popupWin.document.open();
		popupWin.document
				.write('<html><title>::Print Preview::</title><link rel="stylesheet" type="text/css" href="Print.css" media="screen"/></head><body">')
		popupWin.document.write(toPrint.innerHTML);
		popupWin.document.write('</html>');
		popupWin.document.close();
	}

	$(function() {

		$("input[name='taskTypeId']").change(function() {
			var radioValue = $("input[name='taskTypeId']:checked").val();
			if (radioValue) {
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
	function gettaskunitList(unitId) {

		var m = $("#hiddentaskTypeId").val();
		//alert("minscript"+m);

		$("#unitId").val(unitId);
		$("#taskTypeId").val(m);

		var page_url = "../task/taskreport2?unitId=" + unitId + "& taskTypeId="
				+ m;
		window.location.assign(page_url);

		$("#myunit").attr('href', page_url);

		/*  document.forms[0].urlvalue.value="../task/taskreport2";
		
		   $("#unitId").val(unitId);
		   $("#taskTypeId").val(m);
		  
		
			 document.forms[0].submit(); 
			 return false;
		 */

		/*   document.forms.casesReport.action="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m; */
		/* document.forms.casesReport.submit();  */

	}
	function gettaskcircleList(unitId, circleId) {

		var m = $("#hiddentaskTypeId").val();
		document.forms[0].urlvalue.value = "../task/taskreport2";

		$("#unitId").val(unitId);
		$("#circleId").val(circleId);
		$("#taskTypeId").val(m);

		document.forms[0].submit();

	}
	function gettaskdivisionList(unitId, circleId, divisionId) {

		var m = $("#hiddentaskTypeId").val();
		document.forms[0].urlvalue.value = "../task/taskreport2";

		$("#unitId").val(unitId);
		$("#circleId").val(circleId);
		$("#divisionId").val(divisionId);
		$("#taskTypeId").val(m);

		document.forms[0].submit();

	}
	function gettasksubdivisionList(unitId, circleId, divisionId, subdivisionId) {

		var m = $("#hiddentaskTypeId").val();
		document.forms[0].urlvalue.value = "../task/taskreport2";

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
			<strong>Note : Please Use A4(landscape) Size Paper for
				Print. Also Selected Data Can be Exported and Printed</strong>
		</div>

		<div class="panel panel-primary" style="padding: 10px">
			<div class="panel-heading">
				<h3 class="panel-title">Inventory:Reservoirs Abstract</h3>
			</div>















			<div>





				<div class="show-grid gridList mainprint pagecontent"
					style="display: block">

					<%-- <c:if test="${compCapList!=null}"> --%>




					<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%"
							id="table">
							<thead>

								<tr style="font-size: 18px">
									<th>Sl.No</th>
									<th>Name of Office</th>
									<th>Total Reservoirs</th>
									<th>Ongoing </th>
									<th>Completed</th>
									







								</tr>




							</thead>


							<tbody>

								<c:forEach items="${invResList}" var="t" varStatus="count">
									<%-- <a target="_blank"  href="../parasreport/cagParasAbstractOffice?unitId=<c:out value="${t.unitId}"></c:out>" ></a> --%>
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>

										<td><b><c:out value="${t.unitName}"></c:out></b></td>
										<td><a target="_blank"
											href="../invReport/resUnitMapDetail?unitId=<c:out value="${t.unitId}"></c:out> &resStatus=0"><c:out
													value="${t.resTotalCount}"></c:out></a></td>


										<td><a target="_blank"
											href="../invReport/resUnitMapDetail?unitId=<c:out value="${t.unitId}"></c:out> &resStatus=1"><c:out
													value="${t.resOngoingCount}"></c:out></a></td>
										<td><a target="_blank"
											href="../invReport/resUnitMapDetail?unitId=<c:out value="${t.unitId}"></c:out> &resStatus=2"><c:out
													value="${t.resCompleted}"></c:out></a></td>
										


									</tr>

								</c:forEach>



								<tr style="color: red; font-weight: bold; font-size: 16px;">
									<td>Reservoirs</td>
									<td style="text-align: center;">Total</td>
									<td><a target="_blank"
										href="../invReport/resUnitMapDetail?unitId=<c:out value="${t.unitId}"></c:out> &resStatus=0">${totalres}</a></td>

									<td><a target="_blank"
										href="../invReport/resUnitMapDetail?unitId=<c:out value="${t.unitId}"></c:out> &resStatus=1">${ongoingtotal}</a></td>
									<td><a target="_blank"
										href="../invReport/resUnitMapDetail?unitId=<c:out value="${t.unitId}"></c:out> &resStatus=2">${completedtotal}</a></td>
									

								</tr>



							</tbody>

							<!-- <tfoot >
									
									<tr>
										<th >Sl.No</th>
										<th> Name of Office</th>
										<th  >Total Paras</th>
										
										<th  >Section A</th>
										<th >Section B</th>						
										<th >Dropped Paras</th>
										<th  >Transferred</th>
										<th >Balance Paras</th>
										<th >Reply Sent to AG</th>
										<th >Reply Not sent to AG</th>									
									
										
										
										
										


									</tr>
									

									

								</tfoot> -->


						</table>

						<!-- 	<script src="../js/Html5DataTable/jquery-3.3.1.js" type="text/javascript"></script> -->
						<script src="../js/Html5DataTable/jquery.dataTables.min.js"
							type="text/javascript"></script>
						<script src=" ../js/Html5DataTable/dataTables.buttons.min.js"
							type="text/javascript"></script>
						<script src=" ../js/Html5DataTable/jszip.min.js"
							type="text/javascript"></script>
						<script src="../js/Html5DataTable/pdfmake.min.js"
							type="text/javascript"></script>
						<script src=" ../js/Html5DataTable/vfs_fonts.js"
							type="text/javascript"></script>
						<script src="../js/Html5DataTable/buttons.html5.min.js"
							type="text/javascript"></script>
						<script src="../js/Html5DataTable/buttons.print.min.js"
							type="text/javascript"></script>
						<script src="../js/Html5DataTable/dataTables.select.min.js"
							type="text/javascript"></script>








						<script type="text/javascript">
							$('#table')
									.DataTable(
											{
												dom : 'Bfrtip',
												responsive : true,
												"paging" : false,
												"autoWidth" : true,
												"lengthChange" : false,
												"pageLength" : 20,
												buttons : [
														'copyHtml5',
														{
															extend : 'excelHtml5',
															autoFilter : true,
															sheetName : 'Exported_Paras_data',
															text : 'Save To Excel',
															className : 'btn-primary ',
															messageTop : 'IR Paras AG Paras Report'

														},

														{
															extend : 'pdfHtml5',
															className : 'btn-primary ',
															text : 'PDF View / Download',
															orientation : 'landscape',
															pageSize : 'A4',
															download : 'open',
															font : '18',
															filename : 'IR_Paras_Report',
															exportOptions : {
																columns : ':visible',
																search : 'applied',
																order : 'applied'
															},

															title : 'IR Paras AG Paras Report',
															customize : function(
																	doc) {
																doc.defaultStyle.fontfamily = 'Arial';

																doc.defaultStyle.fontSize = 16;
																doc.defaultStyle.alignment = 'center';
																doc.styles.tableHeader.fontSize = 18;
																doc.pageMargins = [
																		80, 80,
																		80, 80 ];
																doc['footer'] = (function(
																		page,
																		pages) {
																	return {
																		columns : [

																		{
																			alignment : 'right',
																			text : [
																					{
																						text : page
																								.toString(),
																						italics : true
																					},
																					' of ',
																					{
																						text : pages
																								.toString(),
																						italics : true
																					} ]
																		} ],
																		margin : [
																				5,
																				0 ]
																	}
																});

															}

														},
														{
															extend : 'print',
															text : 'Print All',
															className : 'btn-primary ',
															exportOptions : {
																modifier : {
																	selected : null
																}
															}

														},
														,
														{
															extend : 'print',
															text : 'Print Selected',
															className : 'btn-primary '

														} ],
												select : true

											});
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
			<!-- <div class="col-md-2">
				<input type="button" class="btn btn-1 btn-primary center-block"
					id="getparaId" value="Excel Export"
					onclick="tableToExcel('table', 'countertable')">
			</div>

			<div class="col-md-2">
				<input type="button" value="Print Preview"
					class="btn btn-1 btn-primary center-block"
					onclick="PrintPreview('printarea')" />
			</div>
			<div class="col-md-2">
				<input type="button" class="btn btn-1 btn-primary center-block"
					id="getparaprintId" value="Print" onclick="printDiv('printarea')">
			</div> -->




		</div>

	</form:form>
</div>
<!-- //main-content -->


















<script type="text/javascript" src="../js/parsley.js"></script>
<script type="text/javascript" class="example">
	$(function() {
		$('#getParaCount').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			// alert('hi');

		})

		.on('form:submit', function() {
			// alert("coming here");

			document.forms.getParaCount.action = "../parasreport/cagstatus";
			document.forms.getParaCount.submit();

			// Don't submit form for this demo
		});
	});
</script>



<!-- //main-content -->
