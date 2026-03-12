
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

	
	MergeCommonRows($("#tablenew"), 1);
	MergeCommonRows($("#tablenew"), 2);
	MergeCommonRows($("#tablenew"), 3);

	MergeCommonRows($("#tablenew1"), 1);
	MergeCommonRows($("#tablenew1"), 2);
	MergeCommonRows($("#tablenew1"), 3);
	
	
  
			
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

function getUnitProjectAyacut(projectId)
{
	
	document.forms[0].urlvalue.value="../compReport/unit-proj-mandal-ayacut";
	
	   $("#projectId").val(projectId);
	 
	
		 document.forms[0].submit();  
	
	
	
	}
	
	
function getUnitAyacut(unitId)
{
	//alert(unitId);
	document.forms[0].urlvalue.value="../compReport/unit-proj-mandal-ayacut";
	
	   $("#unitId").val(unitId);
	 
	
		 document.forms[0].submit();  
	
	
	
	}

       
    </script>




	
						

<div class="col-md-9">
	


<div>


			<div id="printable" class="panel panel-primary  ">
			<div class="panel-heading">
				<h3 class="panel-title">CE Wise-Project Wise-Constituency Wise-Ayacut	<c:if test="${userObj!=null}">	
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
				<input name=projectId  id="projectId" type=hidden >
					<input name=unitId  id="unitId" type=hidden >
				
 
		


<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>


<div id="accordion1" class="treeDiv">



<ul id="tree">
<c:forEach items="${unitList}" var="u">	


	<li><a class="myunit"  href="javascript:void(0)" onclick="getUnitAyacut(<c:out value="${u.unitId}"></c:out>)"><strong><c:out value="${u.unitName}"></c:out></strong></a>
	<ul>
	<c:forEach items="${prList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	
		<li>
		
		<a class="mycircle" href="javascript:void(0)" onclick="getUnitProjectAyacut(<c:out value="${c.projectId}"></c:out>)"><c:out value="${c.projectName}"></c:out></a>
		
			
		
		</li>
		</c:if>
		</c:forEach>
	
	</ul>
	</li>
	

	</c:forEach>  
	
		
	</ul>
	

	
	</div>


	
	
	
</div>
</form:form>	


	<br>
	
	<div class="row show-grid ">
               
               	<strong style="color:#CA3F22"> Note1: Please click on CE office to get CE wise Project Mandal Ayacut</strong> <br>
               	<strong style="color:#CA3F22"> Note2: Please click on Expand All Or + Symbol to see all the Projects under CE office. And then click on Project Name to get respective total Project Data</strong> <br>
               	<strong style="color:#CA3F22"> Note3: Please click on Exclude for Print/Export button  for exporting data without Package/Unit</strong>
				<br>
				<strong style="color:#CA3F22"> Note: Ayacut in Acres</strong>

		
			</div>
			
				<br>
				
				<c:if test="${reporttype==1}">
	
			 <div class="show-grid gridList "  	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">  	
						
						<c:if test="${constList!=null}">
						<table class=" display table-responsive table-bordered table1" id="tablenew">
						<thead >
						<tr style="color:red" >
						
						<td > Project </td>
						
						
						<td>:</td>
						<td > <c:out value="${constList[0].projectName}"></c:out></td>
						<td></td>
						<td></td>
					<!-- 	<td></td> -->
						
						<td></td>
						<td></td>
						
						<td></td>
							
						
						</tr>
						<tr style="text-align: center;">
						<th>S.No</th>
						<th>Constituency </th>
							<th>District</th>						
					     	<th>Mandal </th> 
					
						
					 
						
						<th>New Ayacut Proposed (Contemplated)</th>
						<th>Ayacut Created</th>
						<th>Irrigated Ayacut </th>
					<!-- 	<th>Stabilized Ayacut</th> -->
						
												
								<th>Package </th> 
								<th>Unit </th> 
									
						
					
						
						
						
						</thead>
						<tbody>
						<c:forEach items="${constList}" var="y" varStatus="count">
							
						
							<tr style="text-align: center;">
							<td  >${count.count}</td>
							
							
								<td style="color: blue;"  ><c:out value="${y.constName}"></c:out> </td>
						
							<td   ><c:out value="${y.districtName}"></c:out>  </td>
							
							 <td style="color: blue"  ><c:out value="${y.mandalName}"></c:out> </td>
							 
							 <td  ><c:out value="${y.contemplatedAyacut}"></c:out> </td>
							
							<td  ><c:out value="${y.ayacutCreated}"></c:out> </td>
							<td  ><c:out value="${y.irriagtedAyacut}"></c:out> </td>
							 
						<%-- 	<td   ><c:out value="${y.stableAyacut}"></c:out> </td> --%>
								
							
							
							  <td style="color: blue"  ><c:out value="${y.packageName}"></c:out> </td>
							   <td style="color: blue"  ><c:out value="${y.unitName}"></c:out> </td>
							 
							</tr>
						
						 
							 
							
											
											
							
						
							</c:forEach>
							<tr style="color:red; text-align: center;" >
							
							<td > Total Ayacut :</td>
							
							<td></td>
							<td></td>
							<td></td>
							
							<td><c:out value="${totalContemplatedAyacut}"></c:out> </td>
							<td><c:out value="${totalConstayacut}"></c:out> </td>
							<td> <c:out value="${totalIrrayacut}"></c:out></td>
							<%-- <td><c:out value="${totalConstStableayacut}"></c:out> </td> --%>
							
							<td></td>
							<td></td>
						
							
							</tr>
							</tbody>
							</table>
							</c:if>
							</div>
						
				
					
				
		 </div>
		 
		 </c:if>
		 
		 <c:if test="${reporttype==2}">
	
			 <div class="show-grid gridList "  	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">  	
						
						<c:if test="${constList!=null}">
						<table class=" display table-responsive table-bordered table1" id="tablenew1">
						<thead >
						<tr style="color:red" >
						
						<td > CE/ENC Office </td>
						
						
						<td>:</td>
						<td > <c:out value="${constList[0].unitName}"></c:out></td>
						<td></td>
						<td></td>
						<td></td>
						
					<!-- 	<td></td> -->
						<td></td>
						
						<td></td>
							
						
						</tr>
						<tr style="text-align: center;">
						<th>S.No</th>
							<th>Project </th> 
						   <th>Constituency </th>
							<th>District</th>						
					     	<th>Mandal </th> 
					
						
					 
						
						<th>New Ayacut Proposed (Contemplated)</th>
						<th>Ayacut Created</th>
						<th>Irrigated Ayacut </th>
						<!-- <th>Stabilized Ayacut</th> -->
						
												
								<th>Package </th> 
							
									
						
					
						
						
						
						</thead>
						<tbody>
						<c:forEach items="${constList}" var="y" varStatus="count">
							
						
							<tr style="text-align: center;">
							<td  >${count.count}</td>
							
							 <td style="color: blue"  ><c:out value="${y.projectName}"></c:out> </td>
								<td style="color: blue;"  ><c:out value="${y.constName}"></c:out> </td>
						
							<td   ><c:out value="${y.districtName}"></c:out>  </td>
							
							 <td style="color: blue"  ><c:out value="${y.mandalName}"></c:out> </td>
							 
							 <td  ><c:out value="${y.contemplatedAyacut}"></c:out> </td>
							
							<td  ><c:out value="${y.ayacutCreated}"></c:out> </td>
							<td  ><c:out value="${y.irriagtedAyacut}"></c:out> </td>
							 
							<%-- <td   ><c:out value="${y.stableAyacut}"></c:out> </td> --%>
								
							
							
							  <td style="color: blue"  ><c:out value="${y.packageName}"></c:out> </td>
							  
							 
							</tr>
						
						 
							 
							
											
											
							
						
							</c:forEach>
							<tr style="color:red; text-align: center;" >
							<td></td>
							<td > Total Ayacut :</td>
							
							<td></td>
							<td></td>
							<td></td>
							
							
							<td><c:out value="${totalContemplatedAyacut}"></c:out> </td>
							<td><c:out value="${totalConstayacut}"></c:out> </td>
							<td> <c:out value="${totalIrrayacut}"></c:out></td>
							<%-- <td><c:out value="${totalConstStableayacut}"></c:out> </td> --%>
							<td></td>
							
							
							
						
							
							</tr>
							</tbody>
							</table>
							</c:if>
							</div>
						
				
					
				
		 </div>
		 
		 </c:if>

					
</div>

</div>
</div>


	

		
	

</div>
 
 
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
							
    $('.table1').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "ordering": false,
        "autoWidth": true,
        "lengthChange": false,
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
                sheetName: 'Exported_Ayacut_data',
                text:  'Download Data To Excel',
                className: 'btn-primary ',
                messageTop: 'Project Wise Mandal Ayacut Report',
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
				 
               
                title: 'Project Wise Mandal Ayacut Report',
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
                columns: [ 7,8 ],
                columnText: function ( dt, idx, title ) {
                    return title;
                }
               
                }
        ],
        select: true
       
    } );
    
    </script>	