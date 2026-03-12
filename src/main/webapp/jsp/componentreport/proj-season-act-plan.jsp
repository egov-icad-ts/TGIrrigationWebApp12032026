	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 
<title>Sciwam Reports</title>



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


function getkharifandRabiAction(seasonId,actyear)
{
	
//alert("seasondata"+seasonId+actyear);

/* $("#season").val(seasonId);

$("#act").val(actyear); */

	var act1 = "../compReport/getProjSeasonActionPlan"
			
	

	$("#casesReport").attr("action", act1);

	$("#casesReport").submit();

	
	
	}




       
    </script>





<div class="col-md-9">
	


<div>

	
	<div class="panel panel-primary"    >
			<div class="panel-heading  ">
				<h3 class="panel-title">Kharif / Rabi action plan <c:if test="${userObj!=null}">	
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
				

			</div>
			</div> 
			
			&emsp;&emsp;
			
				
		<div class="invDiv col-md-12 ">
		
		<form:form id="casesReport" method="post"
				modelAttribute="projSeasonReport" >
				<input name=urlvalue type=hidden >
				
			<!-- 	<input id="season" name=seasonId type=hidden value="0">
				
				<input id="act" name=actplanYear type=hidden value="0"> -->
			
				
		<div class=" col-md-4 ">
		  <select class="form-control" id="seasonId" name="seasonId" > 
										<option value=" ">--select--</option>  
										<option   value="1" >Kharif Action Plan</option>
										<option   value="2">Rabi Action Plan</option>
										
										
										</select>
										</div>
										<div class=" col-md-4">
										
										  <select class="form-control" id="actplanYear" name="actplanYear" > 
										<option value=" ">--select--</option>  
										<option   value="2022-23" >2022-23</option>
									
										
										
										</select>
										</div>
										
										<div class=" col-md-4 ">
										
										<button type="button" name="showtanksname" id="rebidel" 
																	class="btn btn-1 btn-primary center-block " onclick="getkharifandRabiAction(seasonId.value,actplanYear.value)"  >Submit</button>
																	
										
										</div>
										
										
</form:form>

			</div>
	 

		





	<c:if test="${seasoninfo==1}">						
	<div class="show-grid gridList col-md-12"  	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered  mydatatable " id="table1">
							<thead >
							<c:if test="${projseasonList!=null}">	
								<tr style="text-align: center;" >
									<th rowspan="2" >Sl.No</th>
									
									
									<th rowspan="2" >Project Name</th>	
									<th rowspan="2" >Contemplated Ayacut  (Acres)</th>	
									<th rowspan="2" >Ayacut Created  (Acres)</th>	
								
									<th rowspan="2" >Present water level (m)</th>					
									<th rowspan="2" >Corresponding Capacity (TMC)</th>
									<th colspan="3" >Irrigated Ayacut Rabi  ${projseasonList[0].rabiactplanYear}</th>
									
									
									
									<th  rowspan="2" >Water Utilized upto end of Rabi  ${projseasonList[0].rabiactplanYear}</th>
									<th  rowspan="2"> Net Availability of water in TMC by end of Rabi ${projseasonList[0].rabiactplanYear} </th>
									<th  colspan="3" > Proposed Ayacut for kharif ${projseasonList[0].khrifactplanYear} </th>
										
										<th rowspan="2" > Requirement of water for kharif ${projseasonList[0].khrifactplanYear} </th>
										<th rowspan="2" > Net Availabity of water after kharif  ${projseasonList[0].khrifactplanYear} </th>
										<th rowspan="2" > No of Wettings  </th>
										<th rowspan="2" > Crop Names </th>
										<th  rowspan="2"> Remarks</th>
											
								
								</tr>
								</c:if>
								
								
						<c:if test="${projseasonList!=null}">		
							<tr>
								
							<th>Irrigated Ayacut Rabi ID ${projseasonList[0].rabiactplanYear}</th>
							<th> Irrigated Ayacut Rabi Wet ${projseasonList[0].rabiactplanYear}</th>
							<th>Irrigated Ayacut Rabi Total  ${projseasonList[0].rabiactplanYear}</th>
								
								<th>Proposed Ayacut for kharif ID ${projseasonList[0].khrifactplanYear}</th>
								<th>Proposed Ayacut for kharif Wet  ${projseasonList[0].khrifactplanYear}</th>
								<th>Proposed Ayacut kharif Total  ${projseasonList[0].khrifactplanYear}</th>
								
					
								
								</tr>
								</c:if>
								
								
								
								

								
							
								

							</thead>

							
							<tbody>
							
							
								
								<c:if test="${projseasonList!=null}">
								 <input type="hidden" class="form-control"  id="actyear"  value="${projseasonList[0].khrifactplanYear}" />
								 
								  <input type="hidden" class="form-control seasoninfodata"  id="seainfo1"  value="${seasoninfo}" />
								
									<c:forEach items="${projseasonList}" var="t" varStatus="count">
									
								
									
										<tr style="text-align: center;">
											
											<td  ><c:out	value="${count.count}"></c:out></td>	
										
											<td style="color: blue" ><c:out value="${t.projectName}"></c:out> </td>	
												<td style="color: blue" ><c:out value="${t.contemplatedAyacut}"></c:out> </td>		
											<td style="color: blue" ><c:out value="${t.ayacutCreated}"></c:out> </td>		
											<td   style="color:green" ><c:out value="${t.preWaterLevel}"></c:out> </td>
											<td  style="color:green" ><c:out value="${t.preWaterCap}"></c:out> </td>
											<td  style="color:green" ><c:out value="${t.irrigatedAyacutRabiID}"></c:out> </td>	
											<td   style="color:green" ><c:out value="${t.irrigatedAyacutRabiWet}"></c:out> </td>	
											<td   style="color:green" ><c:out value="${t.rabitotal}"></c:out> </td>	
											
											
											<td ><strong><c:out value="${t.waterUtil}"></c:out></strong> </td> 
												<td ><c:out value="${t.netAvailablewaterrabi}"></c:out> </td>	
												<td  style="color: blue; " ><c:out value="${t.proposedAyacutKharifID}"></c:out> </td>					
											<td  style="color: blue; " ><c:out value="${t.proposedAyacutKharifWet}"></c:out> </td>
											<td   style="color:green" ><c:out value="${t.khtotal}"></c:out> </td>
											<td  style="color: blue; " ><c:out value="${t.waterRequired}"></c:out> </td>					
											<td  style="color: blue; " ><c:out value="${t.netAvailablewaterKhrif}"></c:out> </td>
											<td style="color: blue; "><c:out value="${t.noOfWettings}"></c:out> </td>
											<td style="color: blue; "><c:out value="${t.cropNames}"></c:out> </td>
											<td  style="color: blue; " ><c:out value="${t.remarks}"></c:out> </td>
																	
											
											
											
											
									
											
											
											
											
											
										
											
											
												
											
							</tr>
							
				
							
							
							
							
							</c:forEach>
							
						
							
							 	 
						
							</c:if>
						 
								
								
								</tbody>
							

						</table>
						
				
						</div>
						
							
	 
	
			
					

</div>
</c:if>

<c:if test="${seasoninfo==2}">		

<div class="show-grid gridList col-md-12"  	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
						<table class="display table-bordered  mydatatable" id="table2">
							<thead >
							<c:if test="${projseasonList!=null}">	
								<tr style="text-align: center;" >
									<th rowspan="2" >Sl.No</th>
									
									
									<th rowspan="2" >Project Name</th>	
									<th rowspan="2" >Contemplated Ayacut (Acres)</th>	
									<th rowspan="2" >Localised Ayacut (Acres)</th>	
								
									<th rowspan="2" >Present water level (feet)</th>					
									<th rowspan="2" >Corresponding Capacity (TMC)</th>
										
									<th colspan="3" >Irrigated Ayacut Kharif  ${projseasonList[0].khrifactplanYear} </th>
									
									
									
									<th  rowspan="2" >Water Utilized upto end of Kharif</th>
									<th  rowspan="2"> Net Availability of water in TMC by end of Kharif </th>
										
									<th  colspan="3" > Proposed Ayacut for Rabi ${projseasonList[0].rabiactplanYear} </th>
									
										<th rowspan="2" > Requirement of water for rabi  </th>
										<th rowspan="2" > Net Availabity of water after Rabi  </th>
										<th rowspan="2" > No of Wettings  </th>
										<th rowspan="2" > Crop Names </th>
										<th  rowspan="2"> Remarks</th>
											
								
								</tr>
									</c:if>
								
								
						<c:if test="${projseasonList!=null}">		
							<tr>
								
							<th>Irrigated Ayacut Kharif ID  ${projseasonList[0].khrifactplanYear}</th>
							<th> Irrigated Ayacut Kharif Wet  ${projseasonList[0].khrifactplanYear}</th>
							<th> Irrigated Ayacut Kharif Total  ${projseasonList[0].khrifactplanYear}</th>
								
								<th>Proposed Ayacut for Rabi ID  ${projseasonList[0].rabiactplanYear} </th>
								<th>Proposed Ayacut for Rabi Wet  ${projseasonList[0].rabiactplanYear}</th>
								<th>Proposed Ayacut for Rabi Total  ${projseasonList[0].rabiactplanYear}</th>
								
					
								
								</tr>
								</c:if>
								
								
								
								

								
							
								

							</thead>

							
							<tbody>
							
							
								
								<c:if test="${projseasonList!=null}">
								 <input type="hidden" class="form-control"  id="actyear"  value="${projseasonList[0].rabiactplanYear}" />
																  <input type="hidden" class="form-control seasoninfodata"  id="seainfo2"  value="${seasoninfo}" />
									<c:forEach items="${projseasonList}" var="t" varStatus="count">
									
								
									
										<tr style="text-align: center;">
											
											<td  ><c:out	value="${count.count}"></c:out></td>	
										
											<td style="color: blue" ><c:out value="${t.projectName}"></c:out> </td>		
											<td style="color: blue" ><c:out value="${t.contemplatedAyacut}"></c:out> </td>		
											<td style="color: blue" ><c:out value="${t.ayacutCreated}"></c:out> </td>		
											<td   style="color:green" ><c:out value="${t.preWaterLevel}"></c:out> </td>
											<td  style="color:green" ><c:out value="${t.preWaterCap}"></c:out> </td>
											<td  style="color:green" ><c:out value="${t.irrigatedAyacutKharifID}"></c:out> </td>	
											<td   style="color:green" ><c:out value="${t.irrigatedAyacutKharifWet}"></c:out> </td>	
											<td   style="color:green" ><c:out value="${t.khtotal}"></c:out> </td>	
											
											
											<td ><strong><c:out value="${t.waterUtil}"></c:out></strong> </td> 
												<td ><c:out value="${t.netAvailablewaterKhrif}"></c:out> </td>	
												<td  style="color: blue; " ><c:out value="${t.proposedAyacutRabiID}"></c:out> </td>					
											<td  style="color: blue; " ><c:out value="${t.proposedAyacutRabiWet}"></c:out> </td>
											<td  style="color: blue; " ><c:out value="${t.rabitotal}"></c:out> </td>
											<td  style="color: blue; " ><c:out value="${t.waterRequired}"></c:out> </td>					
											<td  style="color: blue; " ><c:out value="${t.netAvailablewaterrabi}"></c:out> </td>
											<td style="color: blue; "><c:out value="${t.noOfWettings}"></c:out> </td>
											<td style="color: blue; "><c:out value="${t.cropNames}"></c:out> </td>
											<td  style="color: blue; " ><c:out value="${t.remarks}"></c:out> </td>
																	
											
											
											
											
									
											
											
											
											
											
										
											
											
												
											
							</tr>
							
				
							
							
							
							
							</c:forEach>
							
						
							
							 	 
						
							</c:if>
						 
								
								
								</tbody>
							

						</table>
						
				
						</div>
						
							
	 
	
			
					

</div>

</c:if>

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
	
	var actyear=$("#actyear").val();
	var seasonId=$(".seasoninfodata").val();
	var actionmessage;
	if(seasonId==1){
		
		actionmessage="Kharif action plan "
	}
if(seasonId==2){
		
		actionmessage="Rabi action plan "
	}
				
   $('.mydatatable').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "ordering": false,
        "autoWidth": true,
        "lengthChange": false,
        "pageLength": 20,
        "autoheight": true,
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
                messageTop: 'Kharif action plan  '+actyear,
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
				 
               
                title: actionmessage+' '+actyear,
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
                columns: [ 7,8,9,10 ],
                columnText: function ( dt, idx, title ) {
                    return title;
                }
               
                }
                
            
        ],
        select: true
       
    } );
   
  
  

    
    </script>	
		
