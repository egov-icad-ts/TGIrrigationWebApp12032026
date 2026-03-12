
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>

<title>IR Paras AG Paras Information</title>

<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">




 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />











<script>


function getOfficeAbstract(unitId,circleId,divisionId,subdivisionId,formId,hkey)
{
	

//alert(unitId+circleId+divisionId+subdivisionId+formId+hkey);

	 
if(hkey==1){
	$('#unitId').val(unitId);
	$('#circleId').val(circleId);
	$('#divisionId').val(divisionId);
	$('#subdivisionId').val(subdivisionId);
//	alert("i am in kal"+unitId+circleId+divisionId+subdivisionId+formId+hkey);
	
	   var act1="../parasreport/paraAbstractOffice";
	   var newformId1="#"+formId;
	   $(newformId1).attr("action", act1);
	   $(newformId1).submit(); 
}

	
	}
	
	
function getOfficeDetail(unitId, circleId, divisionId,subdivisionId,paraStatusId, sectionId, transferflag, formId , hkey ){
	

//alert("hkey"+hkey);

	 

if(hkey==2){
	
	$('#unitId').val(unitId);
	$('#circleId').val(circleId);
	$('#divisionId').val(divisionId);
	$('#subdivisionId').val(subdivisionId);
	$('#transferFlag').val(transferflag);
	$('#sectionId').val(sectionId);
	$('#paraStatusId').val(paraStatusId);
	
		
	var act2="../parasreport/parasDetail";
	 var newformId2="#"+formId;
	   $(newformId2).attr("action", act2);
	   $(newformId2).submit(); 
	
	
}



	  
	
	
	}
	
	function getOfficeDetailtot(paraStatusId, sectionId, transferflag, formId , hkey){
		
		if(hkey==3){
			
		
			$('#transferFlag').val(transferflag);
			$('#sectionId').val(sectionId);
			$('#paraStatusId').val(paraStatusId);
			
				
			var act2="../parasreport/parasDetail";
			 var newformId2="#"+formId;
			   $(newformId2).attr("action", act2);
			   $(newformId2).submit(); 
			
			
		}
		
		
		
	}

</script>


	


<div class="col-md-9">
	


<div>





		<div class="panel panel-primary" >
			<div class="panel-heading">
				<h3 class="panel-title">Paras Abstract<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						 <c:if test="${userObj.employeeName!=null &&  userObj.employeeName!='NA'  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>	
			 
			 </c:if>
			 
			 <c:if test="${userObj.designationName!=null && userObj.designationName!='NA'  }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>	
			 
			 </c:if>
			 </div>
			 <br></br>
			 <div class="span6 pull-right">
			
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
					 <c:if test="${userObj.userName!='icad_test' &&  userObj.userName!='cs_telangana'  }">	 <c:out value="${userObj.unitName}"></c:out></c:if>
			   <c:if test="${userObj.userName =='icad_test'  }">	 AG AUDIT</c:if>
			    <c:if test="${userObj.userName =='cs_telangana'  }"> CS Telangana</c:if>	
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

			

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<div class="  show-grid ">
<div class="alert alert-info" role="alert">
  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
               	<strong style="color:#CA3F22"> Note: Please click on office name to see respective Office data.</strong> <br>
               	</c:if>
               	</c:if>
               	
               	<c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 && userObj.circleId>0  }">	
               	<strong style="color:#CA3F22"> Note: Please click on office name to see respective Office data.</strong> <br>
               	</c:if>
               	</c:if>
				<strong style="color:#CA3F22"> Note: Please click on count number to see respective information and Transferred from Office is displyed *** </strong>
				

			</div>
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
		
			<form:form id="parareport" method="post" modelAttribute="parareportdata">
			
				<input name=unitId id="unitId" type=hidden>
				<input name=circleId id="circleId" type=hidden>
				<input name=divisionId id="divisionId" type=hidden>
				<input name=subdivisionId id="subdivisionId" type=hidden>
				<input name=transferFlag id="transferFlag" type=hidden>
				<input name=sectionId id="sectionId" type=hidden>
				<input name=paraStatusId id="paraStatusId" type=hidden>
				
				
			
			</form:form>
	


					<div
						class="show-grid gridList mainprint pagecontent" 
						style="display: block">



					
						
						
                            <div class="table-responsive" id="printarea">
							<table class=" table display table-bordered" style="width:100%" id="table1">
								<thead >
									
									<tr style=" font-size: 18px" >
										<th >Sl.No</th>
										<th > Name of Office</th>
										<th  >Total Paras</th>
										
										<th  >Section A</th>
										<th >Section B</th>						
										<th >Dropped Paras</th>
										<th >Transferred</th>
										<th >Balance Paras</th>
										<th >Reply Sent to AG</th>
										<th >Reply Not sent to AG</th>									
									
										
										
										
										


									</tr>
									

									

								</thead>


								<tbody>
									
										<c:forEach items="${paraListCount}" var="t" varStatus="count">
											<tr style=" font-size: 16px">

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
													 <c:if test="${(userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0)||
													 (userObj.unitId==9832 && userObj.circleId==21614 && userObj.divisionId==0 && userObj.subdivisionId==0)||
													 (userObj.unitId==4 && userObj.circleId==104 && userObj.divisionId==30327 && userObj.subdivisionId==0) }">	
						   <c:if test="${userObj.unitId>0  }">	
				<td ><a   href="#" onclick="getOfficeAbstract( ${t.unitId},0,0,0,'parareport',1)" ><b><c:out value="${t.unitName}"></c:out></b></a></td>
			 </c:if>
			 </c:if>	
			  <c:if test="${!((userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0)||
													 (userObj.unitId==9832 && userObj.circleId==21614 && userObj.divisionId==0 && userObj.subdivisionId==0)||
													 (userObj.unitId==4 && userObj.circleId==104 && userObj.divisionId==30327 && userObj.subdivisionId==0)) }">
			  <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">	
			 <td ><a   href="#"  onclick="getOfficeAbstract( ${t.unitId}, ${t.circleId},0,0,'parareport',1)"><b><c:out value="${t.circleName}"></c:out></b></a></td>	
			 </c:if>
			 </c:if>	
			 </c:if>
			 
			  <c:if test="${!((userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0)||
													 (userObj.unitId==9832 && userObj.circleId==21614 && userObj.divisionId==0 && userObj.subdivisionId==0)||
													 (userObj.unitId==4 && userObj.circleId==104 && userObj.divisionId==30327 && userObj.subdivisionId==0)) }">
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId==0  }">	
						   <c:if test="${userObj.unitId>0  &&  userObj.circleId>0  &&  userObj.divisionId>0 }">	
			<td ><b><c:out value="${t.divisionName}"></c:out></b></td>	
			 </c:if>
			 </c:if>	
			 </c:if>
			 
											
												<td><a  href="javascript:void(0)"  onclick="getOfficeDetail( ${t.unitId}, ${t.circleId},${t.divisionId},${t.subdivisionId},0,0,false,'parareport',2)"><c:out value="${t.totalParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)"   onclick="getOfficeDetail( ${t.unitId}, ${t.circleId},${t.divisionId},${t.subdivisionId},0,1,false,'parareport',2)"><c:out value="${t.secAParasCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getOfficeDetail( ${t.unitId}, ${t.circleId},${t.divisionId},${t.subdivisionId},0,2,false,'parareport',2)"><c:out value="${t.secBParasCount}"></c:out></a></td>
												
												<td><a   href="javascript:void(0)"  onclick="getOfficeDetail( ${t.unitId}, ${t.circleId},${t.divisionId},${t.subdivisionId},3,0,false,'parareport',2)"><c:out value="${t.droppedCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)"  onclick="getOfficeDetail( ${t.unitId}, ${t.circleId},${t.divisionId},${t.subdivisionId},0,0,true,'parareport',2)"><c:out value="${t.transfrred}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getOfficeDetail( ${t.unitId}, ${t.circleId},${t.divisionId},${t.subdivisionId},8,0,false,'parareport',2)" ><c:out value="${t.balanceParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getOfficeDetail( ${t.unitId}, ${t.circleId},${t.divisionId},${t.subdivisionId},1,0,false,'parareport',2)"><c:out value="${t.replySent}"></c:out></a></td>

												
												<td><a   href="javascript:void(0)" onclick="getOfficeDetail( ${t.unitId}, ${t.circleId},${t.divisionId},${t.subdivisionId},2,0,false,'parareport',2)"><c:out value="${t.replyNotSent}"></c:out></a></td>
												
												
										</tr>

										</c:forEach>
									
<%-- <c:out value="${userObj.unitId }"></c:out>
<c:out value="${userObj.circleId }"></c:out>
<c:out value="${userObj.divisionId }"></c:out>
<c:out value="${userObj.subdivisionId }"></c:out> --%>
						   <c:if test="${(userObj.unitId==4 && userObj.circleId==0 &&  userObj.divisionId==0 && userObj.subdivisionId==0) || 
						      (userObj.unitId==9832 && userObj.circleId==21614 && userObj.divisionId==0 && userObj.subdivisionId==0 ) || 
						      (userObj.unitId==4 && userObj.circleId==104 && userObj.divisionId==30327 && userObj.subdivisionId==0 ) }">	

									<tr style="color: red; font-weight: bold; font-size: 16px;">
									<td >Paras</td>
										<td  style="text-align: center;">Total</td>
										 <td><a   href="javascript:void(0)" onclick="getOfficeDetailtot( 0,0,false,'parareport',3)">${totalParasAll}</a></td>
										<td><a   href="javascript:void(0)"  onclick="getOfficeDetailtot( 0,1,false,'parareport',3)">${secAAll}</a></td>
										<td><a   href="javascript:void(0)" onclick="getOfficeDetailtot( 0,2,false,'parareport',3)" >${secBAll}</a></td>
										<td><a  href="javascript:void(0)"  onclick="getOfficeDetailtot( 3,0,false,'parareport',3)">${DroppedAll}</a></td>
										<td><a   href="javascript:void(0)" onclick="getOfficeDetailtot( 0,0,true,'parareport',3)">${TrAll}</a></td>
										<td><a   href="javascript:void(0)" onclick="getOfficeDetailtot( 8,0,false,'parareport',3)">${Balanceall}</a></td>
										<td><a  href="javascript:void(0)" onclick="getOfficeDetailtot( 1,0,false,'parareport',3)">${replySentAll}</a></td> 
										<td><a   href="javascript:void(0)" onclick="getOfficeDetailtot( 2,0,false,'parareport',3)">${replyNaAll}</a></td> 
										 
										
									</tr> 
									</c:if>
									
							
									
									
									
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
                messageTop: 'IR Paras AG Paras Report',
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
                filename: 'IR_Paras_Report',
                exportOptions: {
					columns: ':visible'
					
				},
				 
               
                title: 'IR Paras AG Paras Report',
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
	
    
   
	
	
   

	  


<!-- //main-content -->
