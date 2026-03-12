<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">



<link rel="stylesheet"
	href="../css/Html5DataTable/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href=" ../css/Html5DataTable/buttons.dataTables.min.css" />
	
	<style>
.ui-tabs-vertical { width: 100% }
.ui-tabs-vertical .ui-tabs-nav { padding: .1em .1em .1em .1em; float: left; width: 15%; }
.ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
.ui-tabs-vertical .ui-tabs-nav li a { display:block; }
.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
.ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right;width:85%  }
</style> 

<!-- <script type="text/javascript">


$(function() {

	
	 
	 $( "#tabs2" ).tabs();

});
</script> -->

 <script type="text/javascript" src="../js/invomReports/michecks_report.js"></script>


<div class="col-md-12">       
		 


		<div >
			 

			
<div class="panel panel-primary" >
			<div class="panel-heading">
				<h3 class="panel-title">Reservoir Inspection Check List:${TankCheckList[0].tankName} </h3>
			</div>
<div class="panel-body">
	<c:if test="${TankCheckList!=null}">
			
			 <c:set var = "newslvalue" scope = "session" value = "0"/>	
	      <c:set var = "oldslvalue" scope = "session" value = "0"/>	
	       <c:set var = "newwrvalue" scope = "session" value = "0"/>	
	      <c:set var = "oldwrvalue" scope = "session" value = "0"/>	
						 	<div id="tankinfodata">
				<div class="show-grid gridList " 	style="display: block">
				<div class="table-responsive" id="printarea1">
						<table class="display table-bordered  tableinspect" style="width: 100%"
							id="tanks-info-data">
							<thead  id="tcheckshead1">
                           <tr >
			    			    <th class="micolmaroon" >Tank Name</th>	    		
			    	    		<th class="micolgray">${TankCheckList[0].tankName}</th>
			    	    		<th class="micolmaroon">Tank Id</th>
			    	    		<th class="micolgray">${TankCheckList[0].tankCode}</th>	
			    	    		 <th class="micolmaroon">District Name</th>   	    		
				    	    	<th class="micolgray">${TankCheckList[0].districtName}</th>
			    	    		</tr>
			    	    		
			    	    		</thead>
			    	    		<tbody id="tchecksbody1">	
			    	    		<tr >   			   
			    	    		<th class="micolmaroon">Mandal Name</th>
			    	    		<th class="micolgray">${TankCheckList[0].mandalName}</th>   
			    	    		 <th class="micolmaroon">Village Name</th>   	    		
				    	    	<th class="micolgray">${TankCheckList[0].villageName}  </th>
				    	    	<th class="micolmaroon">Unit Name</th>
				    	    	<th class="micolgray"> ${TankCheckList[0].unitName}  </th>
			    	    		</tr>
			    	    		
			    	    		<tr >
			    			    <th class="micolmaroon">Circle Name</th>    	    		
			    	    		<th class="micolgray">${TankCheckList[0].circleName} </th>
			    	    		<th class="micolmaroon">Division Name </th>
			    	    		<th class="micolgray">  ${TankCheckList[0].divisionName}  </th>
			    	    		 <th class="micolmaroon">Sub Division Name</th>    		
				    	    	<th class="micolgray">${TankCheckList[0].subdivisionName} </th>
			    	    		</tr>
			    	    		
			    	    		<tr >	    			   
			    	    		<th class="micolmaroon">Frequency </th>
			    	    		<th class="micolgray">  ${TankCheckList[0].activityFrequency}  </th>	 
			    	    		<th></th>
			    	    		<th></th>
			    	    		<th></th>
			    	    		<th></th>
			    	    		</tr>
			    	    		</tbody>
			    	    		</table>
			    	    		</div>
			    	    		</div>
			    	    		</div>
			    	    		</c:if>
			
			
	
		<div id="tabs2">
				<ul class="left-tabs"> 
						 <li><a href="#tii" >Reservoir Inspection Check List</a></li>
						 <li><a href="#cptank" >Reservoir Location</a></li>
						   <li><a href="#rh" >Reservoir General Information</a></li>						   
						    
						     <!--   <li><a href="#feed" >TANK FEED DETAILS</a></li> -->
						</ul> <!-- tabs -->
	
	<div class="left-content" >	
						 	<div id="tii" >
						 	
						 	
						 	<div id="verticaltii">
				<ul>
					<li><a href="#resInspectdata" >Reservoir Inspection Details</a></li>
					<li><a href="#resann1" >AnnexureI</a></li>
						<li><a href="#resann2" >AnnexureII</a></li>
							<li><a href="#resrmks" >Remarks</a></li>
							<li><a href="#reshealth" >HealthStatus</a></li>
								<li><a href="#acttakenstatus" >ActionTakenStatus</a></li>
					
				</ul>
				<div id="resInspectdata">
						 	
						 
			
			
						 	<div id="tankinspectionreport">
				<div class="show-grid gridList " 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class="display table-bordered  tableinspect" style="width: 100%"
							id="tanks-checks-list-data">
							<thead  id="tcheckshead2">
                           
			    	    		
			    	    					    	    		
			    	    		
			    	    		
			    	    		
			    	    		
			    	    	
			    	    	<c:if test="${EmbCheckList!=null}">
			    	    		<tr class="micolblue" >
			    			    <th  >Component</th>	    		
			    	    		<th >AEE Inspection Date</th>
			    	    		<th >Action Required</th>
			    	    		<th >Observed Status</th>	
			    	    		<th >AEE Observations</th>
			    	    
			    	    		</tr>
			    	    		</c:if>
                          
							
							
</thead>
			    	    	<tbody id="tchecksbody2">	


							<tr><td></td><td></td></tr>
                        
                      
                      
                   
			    		 
                     
			    		 
			    		
			    		</tbody>
		</table>
		
			
		
		</div>
		</div>
				</div>
				
				
				
			
		
						 	
				</div>
				
                      
                      
          <div id="resann1">
                      	<c:if test="${AllRemarksList!=null}">
                      	 <c:set var = "tabvalue" scope = "session" value = "0"/>	
                      	 	<table class="display table-bordered  tableinspect" style="width: 100%"
											id="tableremarks">
											<thead id="tremarkshead">
                     <tr style="font-size: 18px; color: gray; font-weight: bold;" class="inspectremarks"><th>Sl.No</th>
			    	    		
			    	    		<th>Remarks</th>
			    	    		<th>Remarks for</th>
			    	    	
			    	    	 <th>Remarks Date</th>
			    	    		<th>Remarks/Instructions </th>
			    	    		
			    	    		<!-- <th>Submitted To</th> -->
			    	    		
			    	    		
			    	    		</tr>
			    	    		</thead>
			    	    		
			    	    		<tbody>
			    	    		<c:forEach items="${AllRemarksList}" var="m" varStatus="count">	
			    	    		
			    	    			 <c:set var = "tabvalue" scope = "session" value = "${m.tabId}"/>
			    	    		 	
			    	    		<tr style="font-size: 16px" class="inspectremarks">
			    	    			                                <td style="text-align: center;">${count.count}</td>
			    	    			                                
			    	    			                                <td><b>${m.remarks}</b></td>
			    	    			                               
			    	    			                                <c:if test="${tabvalue==1 }">
			    	    			                                <td><b>Bund Remarks</b></td>
			    	    			                                </c:if>
			    	    			                              
			    	    			                               
			    	    			                                <c:if test="${tabvalue==2 }">
			    	    			                                <td><b>${m.tankWeirSluiceName}</b></td>
			    	    			                                </c:if>
			    	    			                               
			    	    			                                <c:if test="${tabvalue==3 }">
			    	    			                                <td><b>${m.tankWeirSluiceName}</b></td>
			    	    			                                </c:if>
			    	    			                               
			    	    			                                <td><b>${m.remarksDate}</b></td>
			    	    			                                <td><b>${m.remarksSubmittedBy}</b></td>
			    	    			                               <%--  <td><b>${m.submittedToEmpName}</b></td> --%>
			    	    			                                
			    	    			                            
			    	    			                                </tr>
			    	    		
			    	    		</c:forEach>
			    	    		</tbody>
			    	    		
			    	    	</table>
								
                               </c:if>
                               
                               </div>
                               
                               
                               <div id="resann2">
                      	<c:if test="${AllRemarksList!=null}">
                      	 <c:set var = "tabvalue" scope = "session" value = "0"/>	
                      	 	<table class="display table-bordered  tableinspect" style="width: 100%"
											id="tableremarks">
											<thead id="tremarkshead">
                     <tr style="font-size: 18px; color: gray; font-weight: bold;" class="inspectremarks"><th>Sl.No</th>
			    	    		
			    	    		<th>Remarks</th>
			    	    		<th>Remarks for</th>
			    	    	
			    	    	 <th>Remarks Date</th>
			    	    		<th>Remarks/Instructions </th>
			    	    		
			    	    		<!-- <th>Submitted To</th> -->
			    	    		
			    	    		
			    	    		</tr>
			    	    		</thead>
			    	    		
			    	    		<tbody>
			    	    		<c:forEach items="${AllRemarksList}" var="m" varStatus="count">	
			    	    		
			    	    			 <c:set var = "tabvalue" scope = "session" value = "${m.tabId}"/>
			    	    		 	
			    	    		<tr style="font-size: 16px" class="inspectremarks">
			    	    			                                <td style="text-align: center;">${count.count}</td>
			    	    			                                
			    	    			                                <td><b>${m.remarks}</b></td>
			    	    			                               
			    	    			                                <c:if test="${tabvalue==1 }">
			    	    			                                <td><b>Bund Remarks</b></td>
			    	    			                                </c:if>
			    	    			                              
			    	    			                               
			    	    			                                <c:if test="${tabvalue==2 }">
			    	    			                                <td><b>${m.tankWeirSluiceName}</b></td>
			    	    			                                </c:if>
			    	    			                               
			    	    			                                <c:if test="${tabvalue==3 }">
			    	    			                                <td><b>${m.tankWeirSluiceName}</b></td>
			    	    			                                </c:if>
			    	    			                               
			    	    			                                <td><b>${m.remarksDate}</b></td>
			    	    			                                <td><b>${m.remarksSubmittedBy}</b></td>
			    	    			                               <%--  <td><b>${m.submittedToEmpName}</b></td> --%>
			    	    			                                
			    	    			                            
			    	    			                                </tr>
			    	    		
			    	    		</c:forEach>
			    	    		</tbody>
			    	    		
			    	    	</table>
								
                               </c:if>
                               
                               </div>
                               
                               <div id="resrmks">
                      	<c:if test="${AllRemarksList!=null}">
                      	 <c:set var = "tabvalue" scope = "session" value = "0"/>	
                      	 	<table class="display table-bordered  tableinspect" style="width: 100%"
											id="tableremarks">
											<thead id="tremarkshead">
                     <tr style="font-size: 18px; color: gray; font-weight: bold;" class="inspectremarks"><th>Sl.No</th>
			    	    		
			    	    		<th>Remarks</th>
			    	    		<th>Remarks for</th>
			    	    	
			    	    	 <th>Remarks Date</th>
			    	    		<th>Remarks/Instructions </th>
			    	    		
			    	    		<!-- <th>Submitted To</th> -->
			    	    		
			    	    		
			    	    		</tr>
			    	    		</thead>
			    	    		
			    	    		<tbody>
			    	    		<c:forEach items="${AllRemarksList}" var="m" varStatus="count">	
			    	    		
			    	    			 <c:set var = "tabvalue" scope = "session" value = "${m.tabId}"/>
			    	    		 	
			    	    		<tr style="font-size: 16px" class="inspectremarks">
			    	    			                                <td style="text-align: center;">${count.count}</td>
			    	    			                                
			    	    			                                <td><b>${m.remarks}</b></td>
			    	    			                               
			    	    			                                <c:if test="${tabvalue==1 }">
			    	    			                                <td><b>Bund Remarks</b></td>
			    	    			                                </c:if>
			    	    			                              
			    	    			                               
			    	    			                                <c:if test="${tabvalue==2 }">
			    	    			                                <td><b>${m.tankWeirSluiceName}</b></td>
			    	    			                                </c:if>
			    	    			                               
			    	    			                                <c:if test="${tabvalue==3 }">
			    	    			                                <td><b>${m.tankWeirSluiceName}</b></td>
			    	    			                                </c:if>
			    	    			                               
			    	    			                                <td><b>${m.remarksDate}</b></td>
			    	    			                                <td><b>${m.remarksSubmittedBy}</b></td>
			    	    			                               <%--  <td><b>${m.submittedToEmpName}</b></td> --%>
			    	    			                                
			    	    			                            
			    	    			                                </tr>
			    	    		
			    	    		</c:forEach>
			    	    		</tbody>
			    	    		
			    	    	</table>
								
                               </c:if>
                               
                               </div>
                               
                               <div id="reshealth">
                      	<c:if test="${AllRemarksList!=null}">
                      	 <c:set var = "tabvalue" scope = "session" value = "0"/>	
                      	 	<table class="display table-bordered  tableinspect" style="width: 100%"
											id="tableremarks">
											<thead id="tremarkshead">
                     <tr style="font-size: 18px; color: gray; font-weight: bold;" class="inspectremarks"><th>Sl.No</th>
			    	    		
			    	    		<th>Remarks</th>
			    	    		<th>Remarks for</th>
			    	    	
			    	    	 <th>Remarks Date</th>
			    	    		<th>Remarks/Instructions </th>
			    	    		
			    	    		<!-- <th>Submitted To</th> -->
			    	    		
			    	    		
			    	    		</tr>
			    	    		</thead>
			    	    		
			    	    		<tbody>
			    	    		<c:forEach items="${AllRemarksList}" var="m" varStatus="count">	
			    	    		
			    	    			 <c:set var = "tabvalue" scope = "session" value = "${m.tabId}"/>
			    	    		 	
			    	    		<tr style="font-size: 16px" class="inspectremarks">
			    	    			                                <td style="text-align: center;">${count.count}</td>
			    	    			                                
			    	    			                                <td><b>${m.remarks}</b></td>
			    	    			                               
			    	    			                                <c:if test="${tabvalue==1 }">
			    	    			                                <td><b>Bund Remarks</b></td>
			    	    			                                </c:if>
			    	    			                              
			    	    			                               
			    	    			                                <c:if test="${tabvalue==2 }">
			    	    			                                <td><b>${m.tankWeirSluiceName}</b></td>
			    	    			                                </c:if>
			    	    			                               
			    	    			                                <c:if test="${tabvalue==3 }">
			    	    			                                <td><b>${m.tankWeirSluiceName}</b></td>
			    	    			                                </c:if>
			    	    			                               
			    	    			                                <td><b>${m.remarksDate}</b></td>
			    	    			                                <td><b>${m.remarksSubmittedBy}</b></td>
			    	    			                               <%--  <td><b>${m.submittedToEmpName}</b></td> --%>
			    	    			                                
			    	    			                            
			    	    			                                </tr>
			    	    		
			    	    		</c:forEach>
			    	    		</tbody>
			    	    		
			    	    	</table>
								
                               </c:if>
                               
                               </div>
                               
                               <div id="acttakenstatus">
                      	<c:if test="${AllRemarksList!=null}">
                      	 <c:set var = "tabvalue" scope = "session" value = "0"/>	
                      	 	<table class="display table-bordered  tableinspect" style="width: 100%"
											id="tableremarks">
											<thead id="tremarkshead">
                     <tr style="font-size: 18px; color: gray; font-weight: bold;" class="inspectremarks"><th>Sl.No</th>
			    	    		
			    	    		<th>Remarks</th>
			    	    		<th>Remarks for</th>
			    	    	
			    	    	 <th>Remarks Date</th>
			    	    		<th>Remarks/Instructions </th>
			    	    		
			    	    		<!-- <th>Submitted To</th> -->
			    	    		
			    	    		
			    	    		</tr>
			    	    		</thead>
			    	    		
			    	    		<tbody>
			    	    		<c:forEach items="${AllRemarksList}" var="m" varStatus="count">	
			    	    		
			    	    			 <c:set var = "tabvalue" scope = "session" value = "${m.tabId}"/>
			    	    		 	
			    	    		<tr style="font-size: 16px" class="inspectremarks">
			    	    			                                <td style="text-align: center;">${count.count}</td>
			    	    			                                
			    	    			                                <td><b>${m.remarks}</b></td>
			    	    			                               
			    	    			                                <c:if test="${tabvalue==1 }">
			    	    			                                <td><b>Bund Remarks</b></td>
			    	    			                                </c:if>
			    	    			                              
			    	    			                               
			    	    			                                <c:if test="${tabvalue==2 }">
			    	    			                                <td><b>${m.tankWeirSluiceName}</b></td>
			    	    			                                </c:if>
			    	    			                               
			    	    			                                <c:if test="${tabvalue==3 }">
			    	    			                                <td><b>${m.tankWeirSluiceName}</b></td>
			    	    			                                </c:if>
			    	    			                               
			    	    			                                <td><b>${m.remarksDate}</b></td>
			    	    			                                <td><b>${m.remarksSubmittedBy}</b></td>
			    	    			                               <%--  <td><b>${m.submittedToEmpName}</b></td> --%>
			    	    			                                
			    	    			                            
			    	    			                                </tr>
			    	    		
			    	    		</c:forEach>
			    	    		</tbody>
			    	    		
			    	    	</table>
								
                               </c:if>
                               
                               </div>
							


				
			
				
						 	
	
</div>
</div>
<div id="rh" >

		
				<div id="vtasi">

<div id="adminsanctiondata" class="col-md-12 invDiv" > <h3> General Information </h3> 
	<div id="admns-anction-data">
	<div class="table-responsive" >
	
	
	
	 	<c:if test="${adminsanctionObj!=null}">
										<table class="display table-bordered  tableinspect" style="width: 100%"
											id="table9">
											<thead id="thead9">
										
			    	    		<tr style="font-size: 18px; color: blue; font-weight: bold;"><th>Sl.No</th>
			    	    		 <th>Phase</th>
			    	    		<th>GO Number</th>
			    	    		<th>GO Issued Date</th>
			    	    		<th>GO Amount(In Lakhs)</th>
			    	    	<th>Admin Amount(In Lakhs)</th>
			    	    	
			    	    		</tr>
										</thead>


											<tbody id="tbody9">
										<c:forEach items="${adminsanctionObj}" var="n" varStatus="count">		
											
											<tr style="font-size: 16px">
				    	    			                                <td style="text-align: center;">${count.count}</td> 
				    	    			                                <td><b>${n.phase}</b></td> 
				    	    			                                <td><b>${n.go_number}</b></td>
				    	    			                                <td><b>${n.go_issued_date}</b></td>
				    	    			                                <td><b>${n.go_amount}</b></td>
				    	    			                                <td><b>${n.admin_amount}</b></td>
				    	    			                               
				    	    			                                
				    	    			                                </tr>

                                            </c:forEach>
											</tbody>
										</table>
										
										</c:if>

									</div>
									</div>
									 </div>
									 
									 </div>
									 
									 	
				
	
	</div>			

	<div id="cptank" >
	

	
									<div class="table-responsive" id="printarea">
									
									<c:if test="${CapacityInspectObj!=null}">
										<table class="display table-bordered tableinspect" style="width: 100%"
											id="tablecapdata">
											<thead id="theadcap">
											<tr style="font-size: 18px; color: gray; font-weight: bold;">
			  	    		<th>Sl.No</th>
			  	    		<th>Gross Capacity(TMC) </th>
			  	    		<th>Available Capacity(TMC)</th>
			  	    		<th>Tank Level(M)</th>
			  	    		<th>Inflow(Cusecs)</th>
			  	    		<th>Outflow(Cusecs)</th>
			  	    		<th>Ayacut(Acres)</th>
			  	    	
			  	    		  <th>Surplus</th>
			  	    		<th>Inspect Date</th>
			  	    		</tr>

											</thead>


											<tbody id="tbodycap">
											
											 <c:forEach items="${CapacityInspectObj}" var="j" varStatus="count">
											
											<tr style="font-size: 16px">
			  	    			                                <td style="text-align: center;">${count.count}</td>
			  	    			                                <td><b>${j.grossCapacity}</b></td>
			  	    			                                <td><b>${j.availableCapacity}</b></td>
			  	    			                                <td><b>${j.tankLevel}</b></td>
			  	    			                                <td><b>${j.inflow}</b></td>
			  	    			                                <td><b>${j.outfow}</b></td>
			  	    			                                <td><b>${j.ayacut}</b></td>
			  	    			                             <c:choose>
				    	    			                                	<c:when test="${j.surplus=='true'}">	
				    	    			                      <td><b>Yes</b></td>
				    	    			                      </c:when>
				    	    			                      <c:otherwise>
				    	    			                      <td><b>No</b></td>
				    	    			                      
				    	    			                      </c:otherwise>
				    	    			                      </c:choose>
			  	    			                                
			  	    			                              <%--   <td><b>${j.surplus}</b></td> --%>
			  	    			                                <td><b>${j.inspectDate}</b></td>
			  	    			                               
			  	    			                                </tr>
			  	    			                                
			  	    			                                </c:forEach>


											</tbody>
										</table>
										</c:if>

									</div>

								</div> 
								

</div>
</div>

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
		 <script src="../js/Html5DataTable/buttons.html5.new.js" type="text/javascript"></script> 
		 <script type="text/javascript">			
							
    $('.tableinspect').DataTable( {
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
                messageTop: 'Irrigation Tanks Report',
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
                filename: 'Irrigation Tanks Report',
                exportOptions: {
					columns: ':visible'
					
				},
				 
               
                title: 'Irrigation Tanks Report',
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
		 