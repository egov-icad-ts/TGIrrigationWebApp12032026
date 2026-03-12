
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />
	
<!--   <script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">  -->


<link rel="stylesheet" href="../css/treeview/jquery.treeview.css" />
<style>

td, th {

    
    vertical-align: top;

}</style>
<!--   <link rel="stylesheet" href="../red-treeview.css" />  -->

<!--  <script src="../js/treeview/lib/jquery.js" type="text/javascript"></script> -->
 <script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script>

<!-- <link rel="stylesheet" type="text/css" href="../css/Html5DataTable/datatables.min.css"/>
<script type="text/javascript" src="../js/Html5DataTable/datatables.min.js"></script> -->

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
	
	
	 var d = new Date();
	  var e=new Date();
	 e= e.getFullYear() - 39;
	  var j=00;
    for (var i = 40; i >= 0; i--) {
  	 // alert(i);
        var option = "<option value=" + parseInt(d.getFullYear() - i) +"-"+e+ ">" + parseInt(d.getFullYear() - i) +"-"+e+ "</option>"
       // alert(option);
        
        $('[id*=financialYear]').append(option);
        e++;
       // j++;
    }
    
	
	

	$('#financialYear').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#cagGistId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});


	MergeCommonRows($("#table"), 1);
	MergeCommonRows($("#table"), 2);
	
	
	
	
	
	
	
	 


	 
	  
			
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

<script type="text/javascript">


       
    </script>

<script>

function getcagGist(finYear){
//	alert("cmoing here"+finYear);
	//var districtId=document.getElementById("districtId").value;
	//var finYear=document.getElementById("financialYear").value;
	//alert(cagGistId);
  
   $('#action_alert').empty();
	  $.ajax({	          
      url: "../parastsimis/getParagistbyFinYear",
      type: "GET",
      async: false,
      data: {
    	  financialYear: finYear
      },
     
     
      success: function (response) {
    	  
    	
         
          

    	  var $select = $('#cagGistId');
    	 
		  $select.find('option').remove();
		 // alert("kal1");
		  
		  var obj = JSON.parse(response);
		 // alert("kal2");
		 
		
		  $('#cagGistId').append( '<option value="0"> --select--</option>' );
				
				 
				  
				$.each(obj, function(key, value) {
					
						$('#cagGistId').append( '<option value="'+value.cagGistId+'" > '+value.paraNumber+' '+value.actionTitle+'</option>' );
				
						$('#cagGistId').multiselect('rebuild');
				});
                   
      },
      error : function(){
    	  alert(error);
      }
  }); 	
}


function getCAGdata(cagGistId)
{
	
//alert(cagGistId);
	document.forms[0].urlvalue.value="../parasreport/cagparasDetailReply";
	
	   $("#cagGistId").val(cagGistId);
	   
	
		 document.forms[0].submit(); 
	
	
	
	}

	
	
	
</script>


	

						

<div class="col-md-9">
	


<div>



		<div class="panel panel-primary" >
			<div class="panel-heading">
				<h3 class="panel-title">CAG Paras
				<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						 <c:if test="${userObj.employeeName!=null  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>	
			 
			 </c:if>
			 
			 <c:if test="${userObj.designationName!=null  }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>	
			 
			 </c:if>
			 </div>
			 <br></br>
			 <div class="span6 pull-right">
			
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
			 <c:out value="${userObj.unitName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">	
			 <c:out value="${userObj.circleName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId==0  }">	
						   <c:if test="${userObj.unitId>0  &&  userObj.circleId>0  &&  userObj.divisionId>0 }">	
			 <c:out value="${userObj.divisionName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId!=0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  &&  userObj.divisionId>0 &&  userObj.subdivisionId>0  }">	
			 <c:out value="${userObj.subdivisionName}"></c:out>	
			 </c:if>
			 </c:if>
			 
			   <c:if test="${userObj.unitId==null && userObj.circleId==null && userObj.divisionId==null && userObj.subdivisionId==null }">	
						   
			 <c:out value="${userObj.userName}"></c:out>	
			 
			 </c:if>
			 
	</div></c:if> &emsp;&emsp;</h3>
			</div>

			

	<div class="panel-body">


	<form:form id="casesReport" method="post" modelAttribute="taskreport2">

		<input name=urlvalue type=hidden>
		<input name=unitId id="unitId" type=hidden>
		
		
	
	<div class="col-md-12">	
		<div class="col-md-3">
											<label class="label-control rowlebel ">Financial Year <font color=red>*</font> </label>
											</div>
											
											<div class="col-md-3">
											 <select class="form-control" id="financialYear" name="financialYear" required onchange="getcagGist(this.value)"> 
											 <option value=" ">--select--</option>
											
											 </select></div> 
											 <div class="col-md-3">
											<label class="label-control rowlebel ">Select Para Number <font color=red>*</font> </label>
											
											 </div> 
											 <div class="col-md-3">
											 <select class="form-control" id="cagGistId" name="cagGistId" required onchange="getCAGdata(this.value)"> 
											 <option value=" ">--select--</option>
											
											 </select></div> 
											 </div>
		
		
	</form:form>

 <div class="col-md-12">	
	
	<div class="alert alert-info" role="alert">
 <strong>Note : Please Use A3 Size Paper(landscape) for Print. Also Selected Data Can be Exported and Printed</strong>
</div> 
</div>

<div align="center">
		
		<h1><a target="_blank" href="../parasreport/downloadcagPDF?cagGistId=${paraListTotal[0].cagGistId} ">Download PDF Document</a></h1>
	</div>





			



						<div class="show-grid gridList" id="printarea">

						<div class="table-responsive" id="customers">	
						<table class=" display table-bordered " id="table" >
		
								<thead>
									
									<tr>
										<th style="text-align: center;">Sl.No</th>
											<th   style="text-align: center;" >Para Number</th>	
										<th   style="text-align: center;">Gist of the Para</th>
										
									
										
															
										
										<th  style="text-align: center;">Sub Para </th>
										<th style="text-align: center;"> Reply</th>
										
										
										<th   style="text-align: center;">Documents</th>
																
										
										
										
										
										


									</tr>
									
									
									 

									

								</thead>


								<tbody>
									
										<c:forEach items="${paraListTotal}" var="t" varStatus="count">
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
												
											
												
											<td ><b><c:out value="${t.paraNumber}"></c:out></b>
											<td><b><c:out value="${t.actionTitle}"></c:out></b></td>
											
												<td >
												 <table><thead></thead><tbody> 
												
												  
                                             
                                            
                                             
                                           	 <c:forEach items="${paraListDataTotal}" var="j" varStatus="jcount"> 
												
												<c:if test="${t.cagGistId==j.cagGistId}">
												
												
												
                                              <tr>
                                             
                                              <td>
											
												<c:out value="${j.subParaNumber}" ></c:out><c:out value="${j.paraTitle}" ></c:out>
												
												
												
												</td>
												</tr>
												
                                              <tr>
                                              <td>
											
												<c:out value="${j.parasAction}"  escapeXml="false" ></c:out>
												
												
												
												</td>
												
											</tr>
												</c:if>
												</c:forEach>
											
												</tbody>
												</table>
												
												</td>
												<td><table><thead></thead><tbody>
												
												
												<c:forEach items="${replyListTotal}" var="m" varStatus="mcount">
												
												
												
												<c:if test="${t.cagGistId==m.cagGistId }">
												<tr>
												<td >Sub Para<c:out value="${m.subParaNumber}"  ></c:out></td></tr>
												<tr><td ><c:out value="${m.replyAction}" escapeXml="false" ></c:out></td></tr>
													<tr><td >Remarks</td></tr>
													<tr><td ><c:out value="${m.replyRemarks}" escapeXml="false" ></c:out></td></tr>
												
												
												
												</c:if>
												</c:forEach> 
												
												
												</tbody></table></td>
												
											
											
											<c:if test="${paradocsList!=null}">
											<td  > <table>
											<thead>
											</thead>
											<tbody>
											<c:set var="c" value="1" scope="page" />
												<c:forEach items="${paradocsList}" var="n" varStatus="ncount">
												
											
												
												
												<c:if test="${t.cagGistId==n.cagGistId }">
												
												
												<tr >
												
												<td  style="color: green; font-weight: bold;">
											<c:out 	value="${c}"></c:out>) <br></br>
											
											
											
											</td >
												<td style="color: green; font-weight: bold;"><a target="_blank" href="${pageContext.request.contextPath}/parasreport/viewCAGParas?fileName=${n.paraDocName}" ><c:out value="${n.paraDocOriginalName}"></c:out></a>
												<c:set var="c" value="${c + 1}" scope="page"/>
												</td>
												
												</tr>
												
												
												
												
												</c:if>
												</c:forEach>
												</tbody>
												</table> 
												</td>
												</c:if>
												
												
												
										</tr>
										
										
										
									
										</c:forEach>
									


								
									
									
								</tbody>


							</table>
							
							</div>
							
				
					</div>


				</div>
			
		</div>





</div>
</div>






















<!-- //main-content -->


	<script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.print.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>
	<!-- <script src="../js/Html5DataTable/buttons.colVis.min.js" type="text/javascript"></script> -->
	
	
	
	<script type="text/javascript">			
							
    $('#table').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "autoWidth": true,
        "lengthChange": true,
        "pageLength": 10,
        buttons: [
            'copyHtml5',
            {
                extend: 'excelHtml5',
                autoFilter: true,
                sheetName: 'Exported Paras data',
                text:  'Save To Excel',
                className: 'btn btn-1 btn-primary ',
                messageTop: 'CAG Paras Report'
                
                
            },
            
            {
                extend: 'pdfHtml5',
                className: 'btn btn-1 btn-primary ',
                text:  'PDF View / Download',
                orientation: 'landscape',
                pageSize: 'A3',
                download: 'open',
            
               
                filename: 'CAG_Paras_Report',
               
               
                title: 'CAG Paras Report',
                customize: function (doc) {        
                	doc.defaultStyle.fontSize = 11;
                	doc.defaultStyle.alignment = 'center';
                	doc.styles.tableHeader.fontSize = 14;
                	doc.pageMargins = [150, 100, 100,80];
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
   
    
