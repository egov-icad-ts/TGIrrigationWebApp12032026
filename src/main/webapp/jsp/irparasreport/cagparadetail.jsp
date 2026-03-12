
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





$(function() {
	
	
	
	
	
	
});


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
 
	<form:form id="cagparaReport" method="post" modelAttribute="taskreport2" target="_blank" >

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


		<div class="panel panel-primary " style="padding:10px">
			<div class="panel-heading">
				<h3 class="panel-title">CAG Paras Gist</h3>
			</div>

		
				<div >


					<div  class="show-grid gridList mainprint pagecontent" >



						<div class="table-responsive" id="printarea">

							<table class="display table-bordered " style="width:100%"  id="table1" >
								<thead >								
								<tr ><th></th>
								<th></th>
								
						  <th></th>
								<th  style="color:blue"><b>${subparaList[0].paraNumber} </b>  </th> 
						  <th style="color:blue"><b>${subparaList[0].cagGistPara} </b>  </th> 
						 
						 <th></th>
						  <th></th>
						  <th></th> </tr>
									
									<tr >
								  <th style="color:black"><b>Sl. No</b></th>
								  <th style="color:black"><b>Sub Para Number</b></th>
								  <th style="text-align: center;"><b>Unit Name</b></th>
								  <th style="text-align: center;"><b>Para/Sub Para Title</b></th>
								  <th style="text-align: center;" ><b>Para/Sub Para</b></th>
								  <th style="text-align: center;" ><b>Discussed in PAC</b></th>
								  <th style="text-align: center;" ><b>PAC Recommendations</b></th>
								  <th style="text-align: center;" ><b>Para status</b></th>
								 
								
								  </tr> 
								
								</thead>


								<tbody>
								
								      
									
										<c:forEach items="${subparaList}" var="t" varStatus="count">
										
											 <tr >
								  <td style="text-align: center;"><b>${count.count}</b></td>
								 <c:choose>
								<c:when test="${t.subParaNumber=='0'}">
								<td ><b>--</b></td>
								</c:when>
								<c:otherwise>
								<td ><b><c:out value="${t.subParaNumber}"></c:out></b></td>
								</c:otherwise>
								</c:choose>
								  <td style="text-align: center;"><b>${t.unitName}</b></td>
								<c:choose>
								<c:when test="${t.paraTitle=='0'}">
								<td ><b>--</b></td>
								</c:when>
								<c:otherwise>
								<td ><b><c:out value="${t.paraTitle}"></c:out></b></td>
								</c:otherwise>
								</c:choose>
								  <td style="text-align: center;" ><b>${t.parasAction}</b></td>
								  <td style="text-align: center;" ><b>${t.discussPac}</b></td>
								  <td style="text-align: center;" ><b>${t.pacincluded}</b></td>
								  <td style="text-align: center;" ><b>${t.paraStatus}</b></td>
								
								
								  </tr>                  
										
								
										</c:forEach>
									
								</tbody>


							</table>
					
						</div>
				
					

					</div>



				</div>
				
				
			
		</div>
		
	
	</form:form>
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