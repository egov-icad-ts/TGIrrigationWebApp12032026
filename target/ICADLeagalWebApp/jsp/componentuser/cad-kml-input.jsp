

<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<!-- <script type="text/javascript" src="../js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript" src="../js/jquery-ui-timepicker-addon.min.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>

<script type="text/javascript" src="../js/moment.min.js"></script>

<script type="text/javascript" src="../js/component/cadAyacutKml.js"></script>

<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" media="screen" href="../css/bootstrap-datetimepicker.min.css">






<link rel="stylesheet" media="screen" href="../css/invom/michecks.css">

 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />






<!-- <div class="w3l-main" id="borderStyle"> -->


<div class="col-md-9">



	<div>



		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Command Area-KML
				
				 <c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						 <c:if test="${userObj.employeeName!=null && userObj.employeeName!='NA'  }">	
						   
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
			
			
				
				<div class="alert alert-info col-md-12" style="padding: 0px"
					id="action_alert">
					<c:if test="${msg!=null }">
						<c:out value="${msg}"></c:out>
					</c:if>
				</div>
				
				
				<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note: Submit KML's in DCE logins only. </strong>
				<br>
				
				

			</div>
			</div>


				<div id="result" class="col-md-12 ">
				
				

					
						
						

					
						&emsp; &emsp;
						<div class="col-md-12 invDiv">
						
							<c:if test="${projectList!=null}">
						 <c:forEach items="${projectList}" var="k" varStatus="kcount">
						 
						 <form:form id="compkmlform${kcount.count}" name="compkml" 
						modelAttribute="compkmlayacut" method="post"
						data-parsley-validate-if-empty="" style="overflow:hidden">
						
						<input value="${userObj.unitId}" id="userunit" type="hidden" />
						<input value="${userObj.circleId}" id="usercircle" type="hidden" />
						<input value="${userObj.divisionId}" id="userdivision" type="hidden" />
						<input value="${userObj.subdivisionId}" id="usersubdivision" type="hidden" />
						<input value="${userObj.post}" id="userpost" type="hidden" />
						
						<%-- <button type="button" name="projName" id="projNameinf"  class="btn btn-1 btn-primary center-block " onclick="openreservoir(${kcount.count})" ></button> --%>
						 
						 <c:if test="${userObj.unitId==k.unitId}">
						 
						 <div class="col-md-12">
						 <br>
						 <div class="col-md-4" style="color: blue; font-weight: bold;">
						 
						  <input value="<c:out value="${k.projectId}"></c:out>" id="projhiddenId" type="hidden" name="projectId" />
						 <input value="<c:out value="${k.projectName}"></c:out>" id="projhiddenName" type="hidden" name="projectName" />
						 
						<c:out value="${kcount.count}"></c:out>  <c:out value="${k.projectName}"></c:out>
																	
																	</div>	
																	
																	
																	
																	
						<c:choose>	
						
						<c:when test="${(userObj.unitId>0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 && (userObj.designationId==5 || userObj.designationId==6 || userObj.designationId==7) ) }">				
																	
						<div class="col-md-4">
										 <label class="label-controlPMS rowlebel ">Upload KML File</label>
										
										 
										
								<input id="formPhotosnew" name="cadkmldocs[0].kmlfiles" type="file" 	class="btn-info" value="Upload Documents"  multiple="multiple"   data-parsley-max-file-size="20480"  data-parsley-fileextension='kml,KML'  required > 
					   </div>
					   
						<div class="col-md-4">
						 <button type="button" name="Addfiles" id="adfileinf${kount.count}" 
																	class="btn btn-1 btn-primary center-block nrldpid"  onclick="updatekmldatafn(this.form.id)" > Submit File </button></div>
						
						</c:when>
						<c:otherwise>
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
						
						</c:otherwise>		
						</c:choose>
						 <br>
						 	<br>
						</div>
						
						</c:if>
						
							<%-- <c:if test="${cadkmlList!=null }">
							  <c:set var = "snores" scope = "page" value = "1"/>	
							   <c:forEach items="${cadkmlList}" var="m" varStatus="mcount">
						 
						 <c:if test="${m.projectId==k.projectId }">
						 
						 <c:if test="${m.docName!=null}">
						
						  
					
						
						
						  						 
						 
							
						
						 </c:if>
					 <c:set var="snores" value="${snores + 1}" scope="page"/>	
						 </c:if>
				
						 </c:forEach>
						 							 	
						 </c:if> --%>
						 	</form:form>
							</c:forEach>
							
								<c:if test="${cadkmlList!=null }">
							  <div class="col-md-12 invDiv resinf" id="resdata">
							<div id="viewemp">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block; overflow:hidden">
									<div class="table-responsive" id="printarea">
										<table class=" table1 display table-bordered " style="width: 100%"
											id="viewempId">
											<thead id="viewemphead">
											
											<tr style="font-weight: bold;">
											<td>S.No</td>
											<td>Unit Name</td>
											<td>Project Name</td>
											<td>File Name</td>
											<td>Download file</td>
											<td>Submitted Date</td>
											<td>Action</td>
											
											</tr>
											
											</thead>


											<tbody id="viewempbody${mcount.count}">
											  <c:forEach items="${cadkmlList}" var="m" varStatus="mcount">
											  <c:if test="${m.docName!=null }">
											<tr style="font-weight: bold;">
											<td><c:out value="${mcount.count}"></c:out></td>
											<td><c:out value="${m.unitName}"></c:out></td>
											<td><c:out value="${m.projectName}"></c:out></td>
											<td><c:out value="${m.docName}"></c:out></td>
											<td><a target="_blank" href="${pageContext.request.contextPath}/compReport/viewKML?fileName=${m.docName}" >Download File</a></td>
											<td><c:out value="${m.submitteddate}"></c:out></td>
											<c:choose>
											<c:when test="${(userObj.unitId>0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 && (userObj.designationId==5 || userObj.designationId==6 || userObj.designationId==7) ) }">
											<td><b><button type="button" name="resempinf" id="deletedockml" class="btn btn-1 btn-primary center-block mst1resaccess" onclick="deletekmlfile(${m.cadkmlId})"  >Delete KML </button></b></td>
											</c:when>
											<c:otherwise>
											<td></td>
											</c:otherwise>
											</c:choose>
											
											</tr>
											</c:if>
											</c:forEach>
											
											
											</tbody>
										</table>
									</div>


								</div>
							</div>
							</div>
							</c:if>
							</c:if>										
						
						
								
								
								
								
								</div>
						
						
								
								<!-- start of res display -->
								
						

				
					
				

															
				</div>





				
			

			</div>
			<!-- panel div div -->


		</div>
		<!-- panel div -->

<!-- <div class="row show-grid ">
				<div class="col-md-4">
				</div>
					<div class="col-md-4">
				</div>
				
			<div class="col-md-4" >
									
									<label class="label-controlPMS rowlebel "><b><a id="helpId" href="javascript:void(0)"><strong style="color:#CA3F22">****Click Here For Clarifications</strong></a></b>
										
									</label> 
					 
					
											
									 </div>
							
			</div> -->

	</div>
	<!-- container div -->




	<!-- data ends -->



	<!--  dilogue starts -->


















</div>



<!-- </div> -->
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
				
   $('#viewempId').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
     
        "autoWidth": true,
        "lengthChange": false,
        "pageLength": 20,
        ordering: false,
		 info: false,
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
                messageTop: 'kml- Report',
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
                filename: 'kml Report',
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
               
                columnText: function ( dt, idx, title ) {
                    return title;
                }
               
                }
                
            
        ],
        select: true
       
    } );
   
  
  

    
    </script>	
	
	

