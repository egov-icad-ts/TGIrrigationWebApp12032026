
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

 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" /> 








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








<link rel="stylesheet" media="screen" href="../css/custom.css" >
<div class="col-md-9">       
		 


		<div >
			 
 
	<form:form id="form20docs" method="post" modelAttribute="form20docsview" target="_blank" >

		



		<div class="panel panel-primary " style="padding:10px">
			<div class="panel-heading">
				<h3 class="panel-title">View Photos/Files<c:if test="${userObj!=null}">	
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

		
				<div >


					<div  class="show-grid gridList mainprint pagecontent" >



						<div class="table-responsive" id="printarea">

							<table class="display table-bordered " style="width:100%"  id="table1" >
								<thead >								
								
									
									<tr >
								  <th style="color:black"><b>Sl. No</b></th>
								  <th style="color:black"><b>Source Name</b></th>
								    <th style="color:black"><b>File Name</b></th>					  
								 
								  <th style="text-align: center;"><b>Download File</b></th>
								  <th style="text-align: center;"><b>View File</b></th>
								 
								 
								
								  </tr> 
								
								</thead>


								<tbody>
								
								      
									
										<c:forEach items="${getdamDocsList}" var="t" varStatus="count">
										
											 <tr >
								  <td style="text-align: center;"><b>${count.count}</b></td>
						
								  <td style="text-align: center;"><b>${sourceName}</b></td>
								
								  <td style="text-align: center;" ><b>${t.docTitle}</b></td>
								  <td style="text-align: center;" ><a target="_blank" href="../uploadedFiles/DamInspectDocs/${t.damDocName}" >Download File</a></td>
								  
								 
								 
								  <td style="text-align: center;" ><b><img src="../uploadedFiles/DamInspectDocs/${t.damDocName}" alt="${t.damDocOriginalName}" class="img-responsive"/></b></td>
								
								
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
	<script src="../js/Html5DataTable/buttons.colVis.min.js" type="text/javascript"></script>
	
	<script type="text/javascript">	
	

							
$('#table1').DataTable( {
    	
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "ordering": false,
        "autoWidth": true,
        "lengthChange": false,
        "pageLength": 20,
        "scrollY": 400,
        "scrollX": true,
       
        buttons: [
                 

            
          
            {
                extend: 'print',
                text: 'Print All',
                className: 'btn-primary ',
                exportOptions: {
                    modifier: {
                        selected: null
                    },
                    columns: ':visible',
                    stripHtml : false,
                    customize: function ( win ) {
                        $(win.document.body)
                            .css( 'font-size', '10pt' );
                /*            .prepend(
                                '<img src="http://datatables.net/media/images/logo-fade.png" style="position:absolute; top:0; left:0;" />'    
                            ); */

                        $(win.document.body).find( 'table' )
                            .addClass( 'compact' )
                            .css( 'font-size', 'inherit' );
                    }
                }
               
                
                
            },
            ,{
                extend: 'print',
                text: 'Print Selected',
                className: 'btn-primary ',
                exportOptions: {
                    columns: ':visible',
                    stripHtml : false,
                    customize: function ( win ) {
                        $(win.document.body)
                            .css( 'font-size', '10pt' );
                /*            .prepend(
                                '<img src="http://datatables.net/media/images/logo-fade.png" style="position:absolute; top:0; left:0;" />'    
                            ); */

                        $(win.document.body).find( 'table' )
                            .addClass( 'compact' )
                            .css( 'font-size', 'inherit' );
                    }
                }
                
                
                
            },
            {
                extend: 'colvis',
                text: 'Exclude for Print/Export',
               
               
                }
        ],
        select: true
       
    } );
    

    
    </script>