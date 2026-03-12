
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

function getcagparapdfreplyall(caggistId,cagparaId){
	
	$("#abscagGistId").val(caggistId);
	$("#abscagParaId").val(cagparaId);
	
	//var unit=$("#abscagParaId").val();
		
		
		var act1 = "../parasreport/cagPDFreplyAll"
var newformId1 = "#cagparaReport" 

$(newformId1).attr("action", act1);

$(newformId1).submit();
	
	
}
</script>

<script type="text/javascript">
function getparaData(paraId,unitId){
	
	
$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../parasrest/cagparasdetail",
    async: false,
    data :{
    	cagParaId : paraId,
    	unitId : unitId
    	
    },
    contentType: "application/json; charset=utf-8",
    success: function (msg) {
        console.log(msg); 
        
      //  alert(msg);
        $('#dialog-para').empty();   
      
         $('#dialog-para').append('<div clas="col-md-6 " id ="main2">');
        		 
         $('#dialog-para').append(	 '<div  clas="col-md-12 " style="background-color:grey; color:white; font-weight:bold;"> '+
                    '<div   style="text-align:left;">Para</div>'+
                  
                   
                '</div>'); 
         
         for(m in  msg ){
        	 var k=parseInt(m)+1;
       $("#dialog-para").append(' <div  class="col-md-12 " style="font-weight:bold;" >   '+ msg[m].subParaNumber  +'  '+  msg[m].paraTitle +'  </div>'); 
       
      
     
    // 
         
     //    $("#dialog-para").append(' <div clas="col-md-12 " style="font-weight:bold;" > '+  msg[m].paraTitle +' </div>'   );   
        $("#dialog-para").append(' <div clas="col-md-12 " > '+  msg[m].parasAction +' </div>'   );   
       
       
                   
         }    
        
     
        		              
               $("#main2").append( '</div>');     
                  
             
    }
});

$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../parasrest/parasReplyByPara",
    async: false,
    data :{
    	cagParaId : paraId
    	
    	
    },
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
       console.log(msg2); 
       
      
         $('#dialog-para').append('<div id="main3" class="col-md-12 "> '+
        		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> Replys   </div>');            
               
        
       
         for(i in  msg2 ){
        	 var j=parseInt(i)+1;
        	  var userN=msg2[i].createUserName;
        	 
        	  if( (userN!="ENC-IRRIGATION")){
       $("#dialog-para").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply Sno.'+ j  +'  Unit : '+ msg2[i].unitName +'</div>'); 
        	  }
     //  console.log(msg2[i]); 
      
     //  alert("createUserName"+userN); 
     
    // alert( msg2[i].replyAction);
         if( (userN=="ENC-IRRIGATION")){
        	 
        	 $("#dialog-para").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply Sno.'+ j  +'  Unit : '+ msg2[i].unitName +'  Updated by  '+ msg2[i].createUserName+'</div>'); 
       
     //  $("#dialog-para").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply Updated by  '+  msg2[i].createUserName  +' </div>'); 
       }  
        $("#dialog-para").append(' <div  class="col-md-12 " > '+  msg2[i].replyAction +' </div>'); 
        
        $("#dialog-para").append(' <div  class="col-md-12 " style="font-weight:bold;" > Remarks </div>');
        
        $("#dialog-para").append(' <div  class="col-md-12 " >  '+  msg2[i].replyRemarks +' </div>'); 
                   
         }         
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
 
	<form:form id="cagparaReport" method="post" modelAttribute="taskreport2" target="_blank"  >

		<input name=urlvalue type=hidden>
		<input name=unitId id="unitId" type=hidden>
		<input name=cagGistId id="abscagGistId" type=hidden>
		<input name=cagParaId id="abscagParaId" type=hidden>
	<!-- 	<input name=circleId id="circleId" type=hidden>
		<input name=divisionId id="divisionId" type=hidden>
		<input name=subdivisionId id="subdivisionId" type=hidden> -->
		
<div class="alert alert-info" role="alert">
 <strong>Note : Please Use A4(landscape) Size Paper for Print. Also Selected Data Can be Exported and Printed</strong>
</div>


		<div class="panel panel-primary  " style="padding:10px">
			<div class="panel-heading">
				<h3 class="panel-title">CAG Paras Gist</h3>
			</div>

			




				<div >








				

				
                 <c:if test="${paraListTotal!=null}">


					<div
						class="show-grid gridList mainprint pagecontent" >



						<div class="table-responsive" id="printarea">

							<table class=" display table-bordered " style="width:100%" id="table1">
								<thead >
								
								 <tr style="text-align: center;"><td><b>Financial Year</b></td><td ><b><c:out value="${paraListTotal[0].financialYear}"></c:out></b></td><td><b><c:out value="${paraListTotal[0].paraNumber}"></c:out></b></td><td colspan="2"><b><c:out value="${paraListTotal[0].cagGistTitle}"></c:out></b></td></tr>
									
									<tr style=" font-size: 18px" >
									
								
										<th  style="text-align: center;">Name of Office</th>	
										
										
										
										<th  style="text-align: center;">Para/Sub Para</th>							
										
										
									
										<th  style="text-align: center;">Status</th>
										
										<th  style="text-align: center;">Replies</th>
										<th  style="text-align: center;">Documents</th>	
										<th style="text-align: center;" ><b>Downloads</b></th>								
										
									
									</tr>
								
								</thead>


								<tbody>
								
								      
									
										<c:forEach items="${paraListTotal}" var="t" varStatus="count">
										
											<tr>
											
											<td><b><c:out value="${t.unitName}"></c:out></b></td>
									
												
											<td><table>
											<tr>				
								
											<td><c:choose>
								<c:when test="${t.subParaNumber=='0'}">
								<b>--</b>
								</c:when>
								<c:otherwise>
								<b><c:out value="${t.subParaNumber}"></c:out></b>
								</c:otherwise>
								</c:choose> &emsp;&emsp; <c:choose>
								<c:when test="${t.paraTitle=='0'}">
								<b>--</b>
								</c:when>
								<c:otherwise>
								<b><c:out value="${t.paraTitle}"></c:out></b>
								</c:otherwise>
								</c:choose></td></tr>
											<tr><td><c:out value="${t.parasAction}" escapeXml="false"></c:out><td></tr></table></td>	
											
												<td><c:out value="${t.paraStatus}"></c:out>
												<br>
												
												Discussed in PAC : <c:out value="${t.discussPac}"></c:out>
													<br>
												PAC Recommendations: <c:out value="${t.pacincluded}"></c:out>
													<br></td>
												
												
												
												
												<td>
												<c:forEach items="${replyList}" var="m" varStatus="count">
												<c:if test="${m.cagParaId==t.cagParaId}">
												<table>
												
												<tr><td>${m.unitName} &emsp; &emsp;${m.replyDate}</td></tr>
												<tr>
												<td><c:out value="${m.replyAction}" escapeXml="false"></c:out>
												
												<br>
												
												Remarks:
												<br>
												<c:out value="${m.replyRemarks}" escapeXml="false"></c:out></td>								
												
												</tr>
												
												
												
												</table>
												</c:if>												<a target="_blank"  href="${pageContext.request.contextPath}/parasreport/viewCAGParas?fileName=${n.paraDocName }" >${n.paraDocOriginalName}</a>
												
												</c:forEach></td>
												
												<td>
												<c:forEach items="${docsList}" var="n" varStatus="count">
												<table><tr><td>${n.doctitle}: &emsp;&emsp; ${n.docdate}
												<br>
												<a target="_blank"  href="${pageContext.request.contextPath}/parasreport/viewCAGParas?fileName=${n.paraDocName }" >${n.paraDocOriginalName}</a>
												
												<br>
												
												</td>
												</tr>
												
												</table>
												
												</c:forEach></td>
												
												
												<td> <br>
								<button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparapdfreplyall('${t.cagGistId}','${t.cagParaId}')"  ><b>Download All Replies</b></button>
											  <br></td>
												
												
												
										</tr>
										
									
										

										</c:forEach>
									
								</tbody>


							</table>
							
							
							
							
							
							
								
							


						</div>
					<%-- 	</c:if> --%>
					

					</div>
					
					</c:if> 
					
					
					
					<c:if test="${paraListYearTotal!=null}">


					<div
						class="show-grid gridList mainprint pagecontent" >



						<div class="table-responsive" id="printarea">

							<table class=" display table-bordered " style="width:100%" id="table1">
								<thead >
								
								 <tr style="text-align: center;"><td><b>Financial Year</b></td><td ><b><c:out value="${paraListTotal[0].financialYear}"></c:out></b></td><td><b><c:out value="${paraListTotal[0].paraNumber}"></c:out></b></td><td colspan="2"><b><c:out value="${paraListTotal[0].cagGistTitle}"></c:out></b></td></tr>
									
									<tr style=" font-size: 18px" >
									
								
										<th  style="text-align: center;">Name of Office</th>	
										
										
										
										<th  style="text-align: center;">Para/Sub Para</th>							
										
										
									
										<th  style="text-align: center;">Status</th>
										
										<th  style="text-align: center;">Replies</th>
										<th  style="text-align: center;">Documents</th>	
										<th style="text-align: center;" ><b>Downloads</b></th>								
										
									
									</tr>
								
								</thead>


								<tbody>
								
								      
									
										<c:forEach items="${paraListYearTotal}" var="t" varStatus="count">
										
											<tr>
											
											<td><b><c:out value="${t.unitName}"></c:out></b></td>
									
												
											<td><table>
											<tr><td><c:out value="${t.subParaNumber}"></c:out> &emsp;&emsp; <c:out value="${t.paraTitle}" ></c:out></td></tr>
											<tr><td><c:out value="${t.parasAction}" escapeXml="false"></c:out><td></tr></table></td>	
											
												<td><c:out value="${t.paraStatus}"></c:out>
												<br>
												
												Discussed in PAC : <c:out value="${t.discussPac}"></c:out>
													<br>
												PAC Recommendations: <c:out value="${t.pacincluded}"></c:out>
													<br></td>
												
												
												
												
												<td>
												<c:forEach items="${replyList}" var="m" varStatus="count">
												<c:if test="${m.cagParaId==t.cagParaId}">
												<table>
												
												<tr><td>${m.unitName} &emsp; &emsp;${m.replyDate}</td></tr>
												<tr>
												<td><c:out value="${m.replyAction}" escapeXml="false"></c:out>
												
												<br>
												
												Remarks:
												<br>
												<c:out value="${m.replyRemarks}" escapeXml="false"></c:out></td>								
												
												</tr>
												
												
												
												</table>
												</c:if>
												
												</c:forEach></td>
												
												<td>
												<c:forEach items="${docsList}" var="n" varStatus="count">
												<table><tr><td>${n.doctitle}: &emsp;&emsp; ${n.docdate}
												<br>
												<a target="_blank"  href="${pageContext.request.contextPath}/parasreport/viewCAGParas?fileName=${n.paraDocName }" >${n.paraDocOriginalName}</a>
												
												<br>
												
												</td>
												</tr>
												
												</table>
												
												</c:forEach></td>
												
												
												<td> <br>
								<button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparapdfreplyall('${t.cagGistId}','${t.cagParaId}')"  ><b>Download All Replies</b></button>
											  <br></td>
												
												
												
										</tr>
										
									
										

										</c:forEach>
									
								</tbody>


							</table>
							
							
							
							
							
							
								
							


						</div>
					<%-- 	</c:if> --%>
					

					</div>
					
					</c:if> 



				</div>
				
				
			
		</div>
		
		
		
		
		</form:form>
		</div>



	


	




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
           
            
            
            {
                extend:  'copyHtml5',
               
               
               
                className: 'btn btn-1 btn-primary ',
              
                
                
            },
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



















