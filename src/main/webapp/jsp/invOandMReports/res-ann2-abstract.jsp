
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>

<title>O&M Tank Checks</title>

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



<script>

function getresabstractdata(year)
{
	
//alert(cagGistId);
	document.forms[0].urlvalue.value="../invReport/res-ann1-abstract";
	
	   $("#year").val(year);
	   
	
		 document.forms[0].submit(); 
	
	
	
	}
	

	
</script>

<div class="col-md-9">
	

	

	<div>


		

		<div class="panel panel-primary" style="padding: 10px">
			<div class="panel-heading">
				<h3 class="panel-title">O&M of Reservoir: Reservoir Maintenance Annexure2</h3>
			</div>




<div class="panel-body">

	
<div class="alert alert-info" >
			<strong>Note : Please Use A4(landscape) Size Paper for
				Print. Also Selected Data Can be Exported and Printed</strong>
		</div>





	<form:form id="res-ann2" method="post" modelAttribute="reservoirInspect1">
	
	
	<input name=newDistrictId id="newDistrictId" type=hidden>
		<input name=miTankFreqId id="miTankFreqId" type=hidden>
		<input name=year id="year" type=hidden>
	

		<input name=urlvalue id= "urlvalue" type=hidden>
		
			
		
		
		<div class="col-md-12 invDiv">	
		<div class="col-md-6">
											<label class="label-control rowlebel ">Select Year <font color=red>*</font> </label>
											</div>
											
											<div class="col-md-6">
											 <select class="form-control" id="year" name="year" required onchange="getresabstractdata(this.value)" > 
											 <option value=" ">--select--</option>
											 <option value="2019">2019</option>
											 <option value="2019">2020</option>
											
											 </select></div> 
											 
											
											 </div>


	

		

				<div class="col-md-12 show-grid gridList mainprint pagecontent" 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class=" display table-bordered" style="width: 100%"
							id="table">
							<thead>

								<tr style="font-size: 18px">
									<th>Sl.No</th>
									<th>Name of Office</th>
									<th>Reservoir Name</th>
									<th>Total Checks </th>
									<th>Completed Checks</th>
								
								</tr>




							</thead>


							<tbody>

								<c:forEach items="${invResList}" var="t" varStatus="count">
									<%-- <a target="_blank"  href="../parasreport/cagParasAbstractOffice?unitId=<c:out value="${t.unitId}"></c:out>" ></a> --%>
									<tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>

										<td><b><c:out value="${t.unitName}"></c:out></b></td>
											<td><b><c:out value="${t.resName}"></c:out></b></td>
										<td><a 	href="javascript:void(null);" ><c:out  value="${t.rescheckTotalCount}"></c:out></a></td>


										<td><a 	href="javascript:void(null);" onclick="getResInfo('${t.resInspectMst1Id}');"><c:out value="${t.resInspectCount}"></c:out></a></td>
										
										


									</tr>

								</c:forEach>






							</tbody>

						

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
															messageTop : 'Inspection Abstract'

														},

														{
															extend : 'pdfHtml5',
															className : 'btn-primary ',
															text : 'PDF View / Download',
															orientation : 'landscape',
															pageSize : 'A4',
															download : 'open',
															font : '18',
															filename : 'Report',
															exportOptions : {
																columns : ':visible',
																search : 'applied',
																order : 'applied'
															},

															title : 'Inspection Abstract',
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
		



		
	</form:form>
</div> <!-- //panel body-content -->
		</div> <!-- //panel-content -->


	
	 </div> 
<!-- //row-content -->
 </div> 
<!-- //container-content -->





	<div id="dialog-para" title="Reservoir maintenance Annexure2" style="display:none">
		<div class="invDiv" id="dialog-para1"> </div>
		<div class="invDiv" id="dialog-para2">
		 
  <!--   <ul>
      <li><a href="#gen">A.GENERAL</a></li>
      <li><a href="#ear">B.EARTH/ROCK FILL DAMS</a></li>
        <li><a href="#con">C.CONCRETE/MASONRY DAMS</a></li>
        <li><a href="#ope">D.OPERATION AND MAINTENANCE</a></li>
      <li class="ui-tabs-close-button"><button id="closeBtn">X</button></li>
    </ul> -->
    <div id="gen" >
    
    
    </div>
    <div id="con" > 
      
    </div>
     <div id="comm" >
     
    </div>
    
     <div id="asses" > 
     
    </div>
    
  </div>
 

		
		
		
		</div>














<script type="text/javascript" src="../js/parsley.js"></script>



<!-- //main-content -->

<script type="text/javascript">
function getResInfo(resInspectMst1Id){
	
	
$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/res-ann2-res-Info?mst1Id="+resInspectMst1Id,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg) {
        console.log(msg); 
    	 $('#dialog-para1').empty();
         $('#dialog-para1').append( '<div class="col-md-12 invDiv"><h3>RESERVOIR INFO</h3>  </div>');            
       



 	
 	 
         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" >  Reservoir Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].resName +'</div><div  class="col-md-3 " style="font-weight:bold;" > ReservoirStatus</div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].resStatus+'</div>'); 

       


         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" >  unit Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].unitName +'</div><div  class="col-md-3 " style="font-weight:bold;" >  Circle Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].circleName  +'</div>');



         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" >   division Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].divisionName  +'</div><div  class="col-md-3 " style="font-weight:bold;" >  Sub Division Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].subdivisionName  +'</div>');

         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" > Circle Name  </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].projectName +'</div><div  class="col-md-3 " style="font-weight:bold;" >  year </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg[0].year  +'</div>');
         
        


             
    }
}); 

$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/res-ann2-gen-Info?mst1Id="+resInspectMst1Id,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
      //  console.log(msg2); 
      //  alert("kal"+msg2);
        
        
    	 $('#gen').empty();
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
       
 */
 
 $('#gen').append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:black" ><h3>A.EARTH DAM</h3></div>')
 $("#gen").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-4 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-4 " style="font-weight:bold;" >  Remarks</div> <div  class="col-md-4 " style="font-weight:bold;" >Status</div></div>');
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
 	
	 
         $("#gen").append('<div  class="row col-md-12" > <div  class="col-md-4 invDiv" style="font-weight:bold;" > '+msg2[i].resCheckName+' </div> <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div>  <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].statusName+'</div> </div>'); 

         
  } 

         

             
    }
}); 

$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/res-ann2-con-Info?mst1Id="+resInspectMst1Id,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
      //  console.log(msg2); 
      //  alert("kal"+msg2);
        
        
    	 $('#con').empty();
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
       
 */
 
 $('#con').append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:black" ><h3>B.MASONARY / CONCRETE DAM</h3></div>')
 $("#con").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-4 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-4 " style="font-weight:bold;" >  Remarks</div> <div  class="col-md-4 " style="font-weight:bold;" >Status</div></div>');
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
 	
	 
         $("#con").append('<div  class="row col-md-12" > <div  class="col-md-4 invDiv" style="font-weight:bold;" > '+msg2[i].resCheckName+' </div> <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div>  <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].statusName+'</div> </div>'); 

         
  } 

         

             
    }
});

$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/res-ann2-asses-Info?mst1Id="+resInspectMst1Id,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
      //  console.log(msg2); 
      //  alert("kal"+msg2);
        
        
    	 $('#asses').empty();
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
       
 */
 
 $('#asses').append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:black" ><h3>D.GENERAL  ASSESMENTS OF CONDITION OF THE DAM</h3></div>')
 $("#asses").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-4 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-4 " style="font-weight:bold;" >  Remarks</div> <div  class="col-md-4 " style="font-weight:bold;" >Status</div></div>');
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
 	
	 
         $("#asses").append('<div  class="row col-md-12" > <div  class="col-md-4 invDiv" style="font-weight:bold;" > '+msg2[i].resCheckName+' </div> <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div>  <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].statusName+'</div> </div>'); 

         
  } 

         

             
    }
}); 


$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/res-ann2-comm-Info?mst1Id="+resInspectMst1Id,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
      //  console.log(msg2); 
      //  alert("kal"+msg2);
        
        
    	 $('#comm').empty();
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
       
 */
 
 $('#comm').append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:black" ><h3>C.COMMUNICATION FACILITIES</h3></div>')
 $("#comm").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-4 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-4 " style="font-weight:bold;" >  Remarks</div> <div  class="col-md-4 " style="font-weight:bold;" >Status</div></div>');
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
 	
	 
         $("#comm").append('<div  class="row col-md-12" > <div  class="col-md-4 invDiv" style="font-weight:bold;" > '+msg2[i].resCheckName+' </div> <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div>  <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].statusName+'</div> </div>'); 

         
  } 

         

             
    }
}); 







	
	$("#dialog-para").dialog({
	    modal: true,
	    draggable: true,
	    resizable: true,
	    position: ['center', 'center'],
	    show: 'blind',
	    hide: 'blind',
	    width: 1200,
	    height:600,
	    dialogClass: 'ui-dialog-osx',
	    buttons: {
	        "close para": function() {
	            $(this).dialog("close");
	        }
	    },
	    open: function() {
	       // $('#infotabs').tabs( );
	        //intabs function 
	        /*  create: function(e, ui) {
                $('#closeBtn').click(function() {
                    $('#dialog-para').dialog('close');
                });
            } */
	      // $(this).parent().children('.ui-dialog-titlebar').remove();
	    }
	});

}




       
    </script>
