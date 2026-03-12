
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

	
	
	
	
	

	MergeCommonRows($("#table1"), 1);
	MergeCommonRows($("#table1"), 2);
	
	
	
	
	
	
	
	 


	 
	  
			
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
function getResInfo(resCode){
	
	//alert("resCode"+resCode);
	
$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/resinfobycode?resCode="+resCode,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg) {
        console.log(msg); 
        
        $('#dialog-para').empty();
        $('#dialog-para').append('<div id="main3" class="col-md-12 "> '+
		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Salient Features  </div>');            
      



	// var j=parseInt(i)+1;
	  //var userN=msg2[i].createUserName;
	 
	 
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   Reservoir Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.resName +'</div><div  class="col-md-3 " style="font-weight:bold;" >  Reservoir Status </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.resStatus +'</div>'); 


	 
	 
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   Water Spread Area </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.waterSpreadArea +'SQ.KM.</div><div  class="col-md-3 " style="font-weight:bold;" >   Hydro Power </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.hydroPower +'MW</div>');



$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >  Latitude </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.resLatitude +'</div><div  class="col-md-3 " style="font-weight:bold;" >  Longitude </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.resLongitude +'</div>');

$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   Land Acquistion </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.landAcquistion +'sq.km</div><div  class="col-md-3 " style="font-weight:bold;" >  Catchment Area </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.catchmentArea +'sq.km</div>');

$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >  M.F.D (cumecs) </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.maxfloodDischarge +'cumecs</div><div class="col-md-6 "></div>');



$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   MWL Capacity </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.mwlCapacity +'(TMC)</div><div  class="col-md-3 " style="font-weight:bold;" >   FRL Capacity </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.frlCapacity +'(TMC)</div>');
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   MDDL Capacity </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.mddlCapacity +'(TMC)</div><div  class="col-md-3 " style="font-weight:bold;" > Deadstorage Capacity </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.deadstorageCapacity +'(TMC)</div>');
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   TRL Level </div> <div  class="col-md-3 " style="font-weight:bold;" > : +'+ msg.trlLevel +'Mt.s</div><div  class="col-md-3 " style="font-weight:bold;" > FRL Level </div> <div  class="col-md-3 " style="font-weight:bold;" > : +'+ msg.frlLevel +'Mt.s</div>');
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   MWL Level </div> <div  class="col-md-3 " style="font-weight:bold;" > : +'+ msg.mwlLevel +'Mt.s</div><div  class="col-md-3 " style="font-weight:bold;" > MDDL Level </div> <div  class="col-md-3 " style="font-weight:bold;" > : +'+ msg.mddlLevel +'Mt.s</div>');
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   Dead Storage Level </div> <div  class="col-md-3 " style="font-weight:bold;" > : +'+ msg.deadstorageLevel +'Mt.s</div><div class="col-md-6 "></div>');
$("#dialog-para").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Spill Way Details</div>');


$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   Spill Way Length </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.spillwayLength +'Mt.</div><div  class="col-md-3 " style="font-weight:bold;" >   N.O.F Length </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.nonoverflowLength +'Mt.</div>');

$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   Max.Height of Spill Way </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.maxhtSpillWay +'Mt.</div><div  class="col-md-3 " style="font-weight:bold;" >   Top Width of Dam </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.topWidthDam +'Mt.</div>');

$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   Max. Base Width Dam </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.maxbaseWidthDam +'Mt.</div><div  class="col-md-3 " style="font-weight:bold;" >  Clear Bridge Width </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.clearBridgeWidth +'Mt.</div>');

$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   Stilling Basin Length/Apron </div> <div  class="col-md-3" style="font-weight:bold;" > : '+ msg.stillingBasinLength +'Mt.</div><div class="col-md-6 "></div>');

$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >  Deepest foundation Level </div> <div  class="col-md-3 " style="font-weight:bold;" > : + '+ msg.deepestfoundationLevel +'Mt.</div><div  class="col-md-3 " style="font-weight:bold;" >  Avg River bed Level </div> <div  class="col-md-3 " style="font-weight:bold;" > : +'+ msg.avgRiverbedLevel +'Mt.</div>');
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   Spill Way Crest Level </div> <div  class="col-md-3 " style="font-weight:bold;" > : +'+ msg.spillWayCrestLevel +'Mt.</div><div  class="col-md-3 " style="font-weight:bold;" > Bridge Top Level </div> <div  class="col-md-3 " style="font-weight:bold;" > : +'+ msg.bridgeTopLevel +'Mt.</div>');
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >   Invert Level of Bucket </div> <div  class="col-md-3 " style="font-weight:bold;" > : +'+ msg.invertLevel +'Mt.</div><div  class="col-md-3 " style="font-weight:bold;" > Stilling Basin Level/Apron </div> <div  class="col-md-3 " style="font-weight:bold;" > : +'+ msg.stillingBasinLevel +'Mt.</div>');

$("#dialog-para").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Earth Dam Details/Concrete Dam Details</div>');

$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >  Earth Dam Left Length </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.earthdamLeftLength +'Mt.</div><div  class="col-md-3 " style="font-weight:bold;" >  Earth Dam Right Length </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.earthdamRightLength +'Mt.</div>');
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" >  Max Height </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.maxHeight +'Mt.</div><div  class="col-md-3 " style="font-weight:bold;" > Masonary Dam Length </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.masonarydamLength +'Mt.</div>');
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" > Rock Fill Dam Length </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.rockfilldamLength +'Mt.</div><div  class="col-md-3 " style="font-weight:bold;" > Concrete Dam Length </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.concretedamLength +'Mt.</div>');
$("#dialog-para").append('<div  class="col-md-3 " style="font-weight:bold;" > Zonal Section Length </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.zonalSectionLength +'Mt.</div><div  class="col-md-3 " style="font-weight:bold;" > Homogeneous Section Length </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg.homogeneousSectionLength +'Mt.</div>');







//  $("#dialog-para").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply Updated by  '+  msg2[i].createUserName  +' </div>'); 
 
//$("#dialog-para").append(' <div  class="col-md-12 " > '+  msg2[i].replyAction +' </div>'); 

//$("#dialog-para").append(' <div  class="col-md-12 " style="font-weight:bold;" > Remarks </div>');

//$("#dialog-para").append(' <div  class="col-md-12 " >  '+  msg2[i].replyRemarks +' </div>'); 
          
       
$("#main3").append(	'</div>' );
/*    $("#main1").append(	'</div>' ); */


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
	    }
	});

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

		<%-- <c:if test="${selectedunitId!=null }"> --%>
			<div align="center">

				<h1>
					<a target="_blank"
						href="../invtsimis/resinfoPDF?unitId=${selectedunitId} &resStatusId=${selectedStatusId}">Download
						PDF Document</a>
				</h1>
			</div>
	<%-- 	</c:if> --%>

		<%-- <c:if test="${selectedunitId==null && selectedabstract==true}">
<div align="center">
		
		<h1><a target="_blank" href="../parasreport/downloadabstarctviewPDF?sectionId=${selectedsectionId} &paraStatusId=${selectedParaStatusId} &transferFlag=${selectedTransferFlag}">Download PDF Document</a></h1>
	</div>
</c:if>

<c:if test="${selectedunit!=null && selectedabs==false}">
<div align="center">
		
		<h1><a target="_blank" href="../parasreport/downloadabstarctofficeviewPDF?unitId=${selectedunit} &sectionId=${selectedSectionId} &paraStatusId=${selectedParaStatusId} &transferFlag=${selectedTransferFlag} &circleId=${selectedCircleId} &divisionId=${selectedDivisionId}&circleTotal=${selectedcircleTotal}&unitTotal=${selectedunitTotal}">Download PDF Document</a></h1>
	</div>
</c:if>
 --%>


		<div class="panel panel-primary  " style="padding: 10px">
			<div class="panel-heading">
				<h3 class="panel-title">Reservoir Jurisdiction</h3>
			</div>






			<div>














				<div class="show-grid gridList mainprint pagecontent">

					<div class="table-responsive" id="printarea">

						<table class=" display table-bordered " style="width: 100%"
							id="table1">
							<thead>

								<tr style="font-size: 18px">
									<th rowspan="2" style="text-align: center;">Sl.No</th>
									<th rowspan="2" style="text-align: center;">Unit Name</th>
									<th rowspan="2" style="text-align: center;">Circle Name</th>
									<th rowspan="2" style="text-align: center;">Division Name</th>
									<th rowspan="2" style="text-align: center;">Sub Division
										Name</th>
									<th rowspan="2" style="text-align: center;">Project Name</th>


									<th rowspan="2" style="text-align: center;">Package Name</th>
									<!-- <th rowspan="1" >Para</th> -->
									<th rowspan="2" style="text-align: center;">Reservoir Name</th>
									<th rowspan="2" style="text-align: center;">Reservoir
										Status</th>
									<!-- <th rowspan="1" colspan="2">AuditDate</th> -->






								</tr>





							</thead>


							<tbody>

								<c:forEach items="${resUnitData}" var="t" varStatus="count">

									<tr>

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>

										<td><b><c:out value="${t.unitName}"></c:out></b></td>





										<td><c:out value="${t.circleName}"></c:out></td>
										<td><c:out value="${t.divisionName}"></c:out></td>
										<td><c:out value="${t.subdivisionName}"></c:out></td>

										<td><c:out value="${t.projectName}"></c:out></td>

										<td><c:out value="${t.packName}"></c:out></td>


										<td><a href="javascript:void(null);"
											onclick="getResInfo('${t.reservoirId}');"><c:out
													value="${t.resName}"></c:out></a></td>


										<td><c:out value="${t.resStatus}"></c:out></td>

									</tr>

								</c:forEach>

							</tbody>


						</table>

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
							
    $('#table1').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "autoWidth": true,
        "lengthChange": false,
        "pageLength": 20,
        buttons: [
           
            
            
            {
                extend:  'copyHtml5',
               
               
               
                className: 'btn btn-1 btn-primary ',
              
                
                
            },
            {
                extend: 'excelHtml5',
                autoFilter: true,
                sheetName: 'Exported Reservoirs data',
                text:  'Save To Excel',
                className: 'btn btn-1 btn-primary ',
                messageTop: 'Reservoir Info'
                
                
            },
            
            /* {
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
               
               
            }, */
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

		<div id="dialog-para" title="Reservoir Info" style="display: none">



		</div>



		<!-- <script src="../js/Html5DataTable/jquery-3.3.1.js" type="text/javascript"></script> -->



		<div class="row show-grid">
			<div class="clearfix"></div>
			<div class="clearfix"></div>
			<div class="col-md-4"></div>
			<!-- <div class="col-md-4">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table1', 'countertable')" >
					</div>
 -->
			<!-- <div class="col-md-2">
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







<!-- //main-content -->
