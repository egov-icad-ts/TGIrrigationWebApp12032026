
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>

<title>Tank feed Information</title>



<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<link rel="stylesheet" media="screen" href="../css/style.css">


 







 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />


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
$(document).ready(function(){
	MergeCommonRows($("#table"), 1);

		
		
 

			
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


<script>



	
	
	
</script>


		
		


<div class="col-md-9">
	


<div>





		<div class="panel panel-primary" >
			<div class="panel-heading">
				<h3 class="panel-title">Tank Feed Abstract
				<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						
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
	
	
<!-- <div class="alert alert-info" style="padding: 0px"  role="alert">
 <strong>Note : Please Use A4(landscape) Size Paper for Print. Also Selected Data Can be Exported and Printed</strong>
</div> -->

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
                    
			

	<form:form id="cagstatusreport" method="post" modelAttribute="cagparas"  target="_blank">

		<input name=urlvalue type=hidden>
		<c:choose>
		<c:when test="${userObj.unitId==9832 && userObj.circleId==21614 }">
		<input name=cunitId id="absunitId" type=hidden value="983221614">
		</c:when>
		<c:otherwise>
		<input name=cunitId id="absunitId" type=hidden value="${userObj.unitId}">
		</c:otherwise>
		</c:choose>
		<input name=circleId id="circleId" type=hidden>
		<input name=divisionId id="divisionId" type=hidden>
		<input name=subdivisionId id="subdivisionId" type=hidden>
		<input name=cagGistId id="abscagGistId" type=hidden>
		<input name=paraStatusId id="absparaStatusId" type=hidden>
		<input name=transferFlag id="abstransferFlag" type=hidden>
		<input name=discussPac id="absdiscussPac" type=hidden>
		<input name=pacincluded id="abspacincluded" type=hidden>
		

					<div class="show-grid gridList "  	style="display: block" >




				
						
						
                            <div class="table-responsive" >
							 <table class=" display table-bordered" style="width:100%" id="table">
								<thead >
								
							
									<tr style=" font-size: 18px" >
										<th >Sl.No</th>
										<th > Office</th>
										<th > Tank count(Gis+mk)</th>
									
										<th  >Can Feed </th>
										
														
										<th >Can not Feed</th>
									
																
									
										
										
										
										


									</tr>
									

									

								</thead>

 <c:if test="${compCapList!=null}"> 
								<tbody>
									
										<c:forEach items="${unitdata}" var="t" varStatus="count">
										<a target="_blank"  href="../parasreport/cagParasAbstractOffice?unitId=<c:out value="${t.unitId}"></c:out>" ></a>
											<tr style=" font-size: 16px"  >

												<td style="text-align: center;" class="dt-control"></td>
													
												<td ><b><c:out value="${t.unitName}"></c:out></b></td>
												<td ><b><c:out value="${t.tankdataCount}"></c:out></b></td>
												<td ><b><c:out value="${t.feedtankCount}"></c:out></b></td>
												<td ><b><c:out value="${t.cannotfeedtankCount}"></c:out></b></td>
												
												
											
										
									
										
										
									</tr>
									</c:forEach>
									<tr style=" font-size: 16px; color: red">

												<td style="text-align: center;">Total</td>
													
												<td ></td>
												<td  ><b><c:out value="${totalcnt}"></c:out></b></td>
												<td ><b><c:out value="${canfeedcnt}"></c:out></b></td>
												<td ><b><c:out value="${cannotfeedcnt}"></c:out></b></td>
												
												
											
										
									
										
										
									</tr>
									
									
								</tbody>
								</c:if>	
							

							</table> 
							 



   
    
							
							
</div>

					
					

					</div>
					
												
	
	</form:form>
					</div>



			
			
		</div>







</div>

</div>
<!-- //main-content -->


 















<script type="text/javascript" src="../js/parsley.js"></script>
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
							
      $('#table').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "autoWidth": true,
        "lengthChange": false,
        "pageLength": 20,
        buttons: [
            'copyHtml5',
            {
                extend: 'excelHtml5',
                autoFilter: true,
                sheetName: 'Exported_Paras_data',
                text:  'Save To Excel',
                className: 'btn-primary ',
                messageTop: 'CAG Paras Report'
               
                
            },
            
            {
                extend: 'pdfHtml5',
                className: 'btn-primary ',
                text:  'PDF View / Download',
                orientation: 'landscape',
                pageSize: 'A4',
                download: 'open',
                font:'18',
                filename: 'CAG_Paras_Report',
                exportOptions: {
					columns: ':visible',
					search: 'applied',
					order: 'applied'
				},
				
               
                title: 'CAG Paras Report',
                customize: function (doc) {
                	doc.defaultStyle.fontfamily ='Arial';
                	
                	doc.defaultStyle.fontSize = 16;
                	doc.defaultStyle.alignment = 'center';
                	doc.styles.tableHeader.fontSize = 18;
                	doc.pageMargins = [80, 80, 80,80];
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
                className: 'btn-primary ',
                exportOptions: {
                    modifier: {
                        selected: null
                    }
                }
               
                
                
            },
            ,{
                extend: 'print',
                text: 'Print Selected',
                className: 'btn-primary ',
                exportOptions: {
                    columns: ':visible'
                }
                
            },
                {
                    extend: 'colvis',
                    text: 'Exclude for Print/Export',
                 
                    columnText: function ( dt, idx, title ) {
                        return title;
                    }
                   
                    }
                
                
                
                
            
        ],
        select: true
       
    } );
    
   

 
 



    </script>	
   
   
   
 