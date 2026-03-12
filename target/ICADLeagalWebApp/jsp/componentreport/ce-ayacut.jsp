	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 
<title>Ayacut Reports</title>



<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
 <script type="text/javascript" src="../js/jquery-ui.js"></script> 
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
 
 
 <link rel="stylesheet" href="../css/treeview/jquery.treeview.css" />
<!-- <link rel="stylesheet" href="../red-treeview.css" /> -->


   <script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script> 
<script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script> 

 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />






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

 </script>

<script type = "text/javascript">


function getConstMandalAyacut(districtId)
{
	
	document.forms[0].urlvalue.value="../compReport/getCompAyacutReport";
	
	   $("#districtId").val(districtId);
	 
	
		 document.forms[0].submit();  
	
	
	
	}




       
    </script>





<div class="col-md-9">
	


<div>

	
	<div class="panel panel-primary"    >
			<div class="panel-heading  ">
				<h3 class="panel-title">CE Wise Projects-Ayacut<c:if test="${userObj!=null}">	
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
			 		 <c:if test="${userObj.userName!='icad_test' &&  userObj.userName!='cs_telangana'  }">	 <c:out value="${userObj.unitName}"></c:out></c:if>
			   <c:if test="${userObj.userName=='icad_test'  }">	 AG AUDIT</c:if>	
			    <c:if test="${userObj.userName=='cs_telangana'  }"> CS Telangana</c:if>	
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
		
			<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Please click on Exclude for Print/Export button  for exporting data without Package/Mandal/District/Constituency</strong>
				<br>
				<strong style="color:#CA3F22"> Note: Ayacut in Acres</strong>
				

			</div>
			</div>
	 
<form:form id="casesReport" method="post"
				modelAttribute="compAyacutReport" >
				<input name=urlvalue type=hidden >
				<input name=districtId  id="districtId" type=hidden >
				
		



</form:form>


						
	<div class="show-grid gridList "  	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered " id="table1">
							<thead >
							
								<tr style="text-align: center;" >
									<th >Sl.No</th>
									
									
									<th> CE Office</th>	
									<th >Project </th>	
									<th >New Ayacut Proposed (Contemplated)</th>					
									<th >Ayacut Created</th>
									<!-- <th >Irrigated Ayacut</th> -->
									<!-- <th >Stable Ayacut</th> -->
									
									
									<th  >Package</th>
									<th  > District </th>
									<th> Mandal </th>
										<th> Constituency </th>
											
								
								</tr>
								
								
								

								
							
								

							</thead>

							
							<tbody>
								
								<c:if test="${ayacutList!=null}">
								
							
									<c:forEach items="${ayacutList}" var="t" varStatus="count">
									
									<c:if test="${t.projectId!=-3 }">
									
										<tr style="text-align: center;">
											
											<td  ><c:out	value="${count.count}"></c:out></td>	
											<td ><b><c:out value="${t.unitName}"></c:out></b></td>	
											<td style="color: blue" ><c:out value="${t.projectName}"></c:out> </td>		
											<td   style="color:green" ><c:out value="${t.contemplatedAyacut}"></c:out> </td>
											<td  style="color:green" ><c:out value="${t.ayacutCreated}"></c:out> </td>
										<%-- 	<td  style="color:green" ><c:out value="${t.irriagtedAyacut}"></c:out> </td>	 --%>
											<%-- <td   style="color:green" ><c:out value="${t.stableAyacut}"></c:out> </td> --%>	
											
											
											<td ><strong><c:out value="${t.packageName}"></c:out></strong> </td> 
												<td ><c:out value="${t.districtName}"></c:out> </td>	
												<td  style="color: blue; " ><c:out value="${t.mandalName}"></c:out> </td>					
											<td  style="color: blue; " ><c:out value="${t.constName}"></c:out> </td>
																	
											
											
											
											
									
											
											
											
											
											
										
											
											
												
											
							</tr>
							
							</c:if>
							
							
							<c:if test="${t.projectId==-3 }">
							 <tr style="color: red; text-align:center" >
							  <td></td>
							 <td ><c:out value="${t.unitName}"></c:out> </td>
							
							<td ></td> 
							<td  ><c:out value="${t.contemplatedAyacut}"></c:out> </td> 
							<td  ><c:out value="${t.ayacutCreated}"></c:out> </td>
						<%-- 	<td  ><c:out value="${t.irriagtedAyacut }"></c:out> </td> --%>
							<%--  <td  ><c:out value="${t.stableAyacut}"></c:out> </td>  --%>
							 
							 <td></td>
							
							
							
							<td ></td>
							<td ></td>
							<td ></td>
							</tr> 
							
							</c:if>
						
							
							
							
							
							</c:forEach>
							
						
							
							 	 
						
							</c:if>
							<tr style="color:green ; text-align:center" >
							<td ></td>
							 	<td > Total Ayacut </td>
							 	
								<td ></td> 
								 <td> <c:out value="${totalContemplatedAyacut}"></c:out></td>
							 	<td ><c:out value="${totalManayacut}"></c:out> </td>
							 	<%-- <td ><c:out value="${totalIrrayacut}"></c:out> </td> --%>
							 	
							 	<%--  <td> <c:out value="${totalManStableayacut}"></c:out></td> --%>
							 	 
							 	<td ></td>
							 
							 	<td ></td>
							 	<td ></td>
							 	<td ></td>
							 	
							 	</tr>  
								
								
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
                extend: 'copyHtml5',
                text:  'Copy Data',
                exportOptions: {
                    columns: [ 0, ':visible' ]
                }
            },
            {
                extend: 'excelHtml5',
                autoFilter: true,
                sheetName: 'Exported_Ayacut_data',
                text:  'Download Data To Excel',
                className: 'btn-primary ',
                messageTop: 'CE-Ayacut Report',
                	 exportOptions: {
                         columns: ':visible'
                     }
               
                
            },
            
            {
                extend: 'pdfHtml5',
                className: 'btn-primary ',
                text:  'PDF View / Download',
                orientation: 'landscape',
                pageSize: 'A4',
                download: 'open',
                font:'10',
                filename: 'Ayacut Report',
                 exportOptions: {
					columns: ':visible'
					
				},
				 
               
                title: 'CE-Ayacut Report',
                customize: function (doc) {
                	doc.defaultStyle.fontfamily ='Arial';
                	
                	doc.defaultStyle.fontSize = 10;
                	doc.defaultStyle.alignment = 'center';
                	doc.styles.tableHeader.fontSize = 12;
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
                    },
                    columns: ':visible'
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
                columns: [ 6,7,8,9 ],
                columnText: function ( dt, idx, title ) {
                    return title;
                }
               
                }
                
            
        ],
        select: true
       
    } );
   
  
  

    
    </script>	
		
