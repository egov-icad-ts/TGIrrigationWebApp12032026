	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 



<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
 
 
 <link rel="stylesheet" href="../css/treeview/jquery.treeview.css" />

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

	
	
//	MergeCommonRows($("#table"), 2);
	
	

	
	

	

	
	
	
	
	 


	 
	  
			
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

function getConstProjectAyacut(districtId)
{
	
	document.forms[0].urlvalue.value="../compReport/dist-man-proj";
	
	   $("#districtId").val(districtId);
	 
	
		 document.forms[0].submit();  
	
	
	
	}

       
    </script>



						

<div class="col-md-9">
	


<div>
                 	<div   class="panel panel-primary  ">
			<div class="panel-heading">
				<h3 class="panel-title">District Wise Mandal Wise Project-Ayacut
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
			 		 <c:if test="${userObj.userName!='icad_test'  }">	 <c:out value="${userObj.unitName}"></c:out></c:if>
			   <c:if test="${userObj.userName=='icad_test'  }">	 AG AUDIT</c:if>
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

	 
<form:form id="casesReport" method="post"
				modelAttribute="compAyacutReport" >
				
				
				
				
				<input name=urlvalue type=hidden >
				<input name=districtId  id="districtId" type=hidden >
				
		



<div id="sidetree"  >
<div class="treeheader">&nbsp;</div>
<!-- <div id="sidetreecontrol" ><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div> -->
<div id="accordion2" class="treeDiv">
<ul id="tree" >

<c:forEach items="${distList}" var="u">
								

								
	<li><a class="myunit"  href="javascript:void(0)"  onclick="getConstProjectAyacut(<c:out value="${u.districtId}"></c:out>)" ><strong><c:out value="${u.districtName}"></c:out></strong></a>
	
	</li>
	
	</c:forEach>  
	
		
		
		
	</ul>
	
</div>

</div>

</form:form>	
<div class="row show-grid ">
<div class="alert alert-info" role="alert">
               	<strong style="color:#CA3F22"> Note1: Please click on District Name to get Data.</strong> <br>
				<strong style="color:#CA3F22"> Note2: Please click on Exclude for Print/Export button  for exporting data without Package/Unit/Mandal/District</strong>
				<br>
				<strong style="color:#CA3F22"> Note: Ayacut in Acres</strong>

			</div>
			</div>

					 <div class="show-grid gridList "  	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<c:if test="${ayacutList!=null}">
						<table class="display table-bordered  " id="table">
						<thead >
						<!--<tr style="color: maroon;text-align: center;" >
						 <th>S.No</th>
						
				        <th>Mandal </th>
						<th>Medium Project </th>
						
						<th>Medium Project Contemplated Ayacut in (Acres) </th>
						<th>Major Project</th>
						<th>Major Project Contemplated Ayacut in (Acres)</th> -->
						
						<tr style="color: maroon;text-align: center;" >
                <th rowspan="2">Sno</th>
                <th rowspan="2">Mandal Name</th>
                <th colspan="2">Medium Project</th>
                 <th colspan="2">Major Project</th>
                   <th rowspan="2">Mandal wise Sub Total(Major & Medium)</th>
                
                
                
                    </tr>
                    
                     <tr>
                <th>Project Name (Medium)</th>
                <th>Contemplated Ayacut</th>
                <th>Project Name(Major)</th>
                <th>Contemplated Ayacut</th>
               
            </tr>
				
					
						</thead>
						<tbody>
						
						
						
						<c:forEach items="${ayacutList}" var="y" varStatus="ycount">
						
						
						<c:if test="${y.projectId!=-5 && y.projectId!=-1 }">
						    
							<tr style="text-align: center;">
											
											<td><c:out value="${ycount.count}"></c:out> </td>													
											<td style="color: blue; " ><c:out value="${y.mandalName}"></c:out> </td>	
											
											<c:choose>	
											<c:when test="${y.projectTypeId==2 }">
											<td style="color: blue" ><c:out value="${y.projectName}"></c:out> </td>	
											<td    ><c:out value="${y.contemplatedAyacut}"></c:out> </td>
											</c:when>
											<c:otherwise>
											<td></td>
											<td></td>
											</c:otherwise>
											</c:choose>
											
											<c:choose>	
											<c:when test="${y.projectTypeId==1 }">
											<td style="color: blue" ><c:out value="${y.projectName}"></c:out> </td>	
											<td   ><c:out value="${y.contemplatedAyacut}"></c:out> </td>
											</c:when>
											<c:otherwise>
											<td></td>
											<td></td>
											</c:otherwise>
											</c:choose>	
											<td></td>
											
											
											
							</tr>
							
							</c:if>				
											
							<c:if test="${y.projectId==-1 }">
							
						
							<tr style="color: #de1282 ; text-align:center" >
							 <td  ><c:out value="${ycount.count}"></c:out></td>
							      <td><b><c:out value="${y.mandalName}"></c:out></b></td>	
							 	
								<c:choose>	
											<c:when test="${(y.projectTypeId==2) }">
											 
										<td></td>
											<td   style="color:red" ><b><c:out value="${y.contemplatedAyacut}"></c:out></b> </td>
											<td></td>
										<td></td>
											
											</c:when>
												
											<c:when test="${(y.projectTypeId==1) }">
											
											<td></td>
											<td></td>
											  <td></td>												
											<td   style="color:red" ><b><c:out value="${y.contemplatedAyacut}"></c:out></b> </td>
											</c:when>
											
												<c:otherwise>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										
																	
											</c:otherwise>
											
											</c:choose>
											
											
												<td></td>
													
							
							</tr> 
							
								
							
							</c:if>
							
							
							<c:if test="${y.projectId==-5 }">
							<tr style="color: maroon; text-align:center" >
							 <td ></td>
							
							 	 <td><b><c:out value="${y.mandalName}"></c:out> </b></td>
							
									<td></td>	
									<td></td>
									<td></td>
						<td   style="color:maroon" > </td>
											
							<td><c:out value="${y.contemplatedAyacut}"></c:out></td>
							
							
							</tr> 
							
							</c:if>
						
							</c:forEach>
							<tr style="color:green ;  text-align: center;" >
						
							<td > </td>
							
							<td><b><c:out value="${ayacutList[0].districtName}"></c:out> (District) Total   : </b></td>
							<td> </td>
							<td><c:out value="${MediumConstContemplatedAyacut}"></c:out></td>
							<td></td>
							<td><c:out value="${MajorConstContemplatedAyacut}"></c:out></td>
							<td><c:out value="${totalConstContemplatedAyacut}"></c:out></td>
							
							
						</tr>
							</tbody>
							</table>
							</c:if>
							</div>
							
							
							
						
				
				
		 </div>
		 </div>

					





	

		

		

</div>
</div>
</div>
 

<!-- //main-content -->







	




		
		
	
	 
	
	 
	 

	 
	 
	 
	
    
    


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
							
    $('#table').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "ordering": false,
        "autoWidth": true,
        "lengthChange": false,
        "scrollY": 400,
        "scrollX": true,
        "pageLength": 20,
       
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
                sheetName: 'Contemplated Ayacut',
                text:  'Download Data To Excel',
                className: 'btn-primary ',
                messageTop: 'Contemplated Ayacut in Acres',
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
				 
               
                title: 'Contemplated Ayacut in Acres',
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
               
                columnText: function ( dt, idx, title ) {
                    return title;
                }
               
                }
        ],
        select: true
       
    } );
    
    </script>	
		
