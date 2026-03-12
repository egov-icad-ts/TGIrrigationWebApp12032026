<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">

<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>




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
				<h3 class="panel-title">Status of Tank:${TankCheckList[0].tankName} </h3>
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
						 <li><a href="#tii" >TANK INSPECTION REPORT</a></li>
						 <li><a href="#cptank" >TANK CAPACITY</a></li>
						   <li><a href="#rh" >TANK REPAIR HISTORY</a></li>						   
						    
						     <!--   <li><a href="#feed" >TANK FEED DETAILS</a></li> -->
						</ul> <!-- tabs -->
	
	<div class="left-content" >	
						 	<div id="tii" >
						 	
						 	
						 	<div id="verticaltii">
				<ul>
					<li><a href="#vtci" >Tank Inspection Data</a></li>
					<li><a href="#vtr" >Remarks</a></li>
					
				</ul>
				<div id="vtci">
						 	
						 	<!-- <div class="row show-grid ">
                            <div class="alert alert-info" role="alert">
				      <strong style="color:#CA3F22"> Condition of Bund Top, Upstream Slope, Down Stream Slope , Revetment, Sluice and Weirs.</strong>
							</div>
							</div> -->
							
			
			
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
			    	    	<!-- 	<th >Inspected by</th> -->
			    	    		</tr>
			    	    		</c:if>
                          
							
							
</thead>
			    	    	<tbody id="tchecksbody2">	


							
                             
                             <tr  >
			    			    <th class="micolred" >BUND</th>   	    		
			    	    		<th ></th>
			    	    		<th ></th>
			    	    		<th ></th>
			    	    		<th ></th>
			    	    	
			    	    		</tr>   
    
                      <c:forEach items="${EmbCheckList}" var="t" varStatus="count">	
                      
                      <c:if test="${t.miCompId==2}">
                      
                      
                      <tr  >
			    			    <th  >${t.miInspectTypeName}</th>  	    		
			    	    		<th >${t.inspectDate }</th>
			    	    		<th >${t.actionReqName }</th>
			    	    		<th >${t.miActionReqTypeName} </th>
			    	    		<th >${t.remarks}</th>
			    	    	<%-- 	<th >${t.tankInspectApproveStatus}</th>	 --%>
			    	    		</tr> 
                      
                      </c:if>
                      <c:if test="${t.miCompId==3}">
                      
                      
                      <tr  >
			    			    <th  >${t.miInspectTypeName}</th>  	    		
			    	    		<th >${t.inspectDate }</th>
			    	    		<th >${t.actionReqName }</th>
			    	    		<th >${t.miActionReqTypeName} </th>
			    	    		<th >${t.remarks}</th>
			    	    		<%-- <th >${t.tankInspectApproveStatus}</th>	 --%>
			    	    		</tr> 
                      
                      </c:if>
                      
                       <c:if test="${t.miCompId==4}">
                      
                      
                      <tr  >
			    			    <th  >${t.miInspectTypeName}</th>  	    		
			    	    		<th >${t.inspectDate }</th>
			    	    		<th >${t.actionReqName }</th>
			    	    		<th >${t.miActionReqTypeName} </th>
			    	    		<th >${t.remarks}</th>
			    	    		<%-- <th >${t.tankInspectApproveStatus}</th>	 --%>
			    	    		</tr> 
                      
                      </c:if>
                      
                                  </c:forEach>
                      
                     <tr  >
					    <th class="micolred"  >SLUICE</th>    		
			    		<th class=""></th>
			    		<th class=""></th>
			    		<th class=""></th>
			    		<th class=""></th>
			    		
			    		</tr>
			    		 <c:forEach items="${EmbCheckList}" var="t" varStatus="count">	
                        <c:if test="${t.miCompId==5}">
                        
                         <c:if test="${t.tankWeirSluiceId>0}">
                         
                          <c:set var = "newslvalue" scope = "session" value = "${t.tankWeirSluiceId}"/>
                          
                           <c:if test="${oldslvalue!=newslvalue}">
                           
                            <c:set var = "oldslvalue" scope = "session" value = "${newslvalue}"/>
                            
                            <tr  >
				    			    <th class="micolgreen" >${t.tankWeirSluiceName}</th>   	    		
				    	    		<th class=""></th>
				    	    		<th class=""></th>
				    	    		<th class=""></th>
				    	    		<th class=""></th>
				    	    		
				    	    		</tr>
                           
                           </c:if>
                         
                         </c:if>
                         
                          <tr >
			    			    <th  >${t.miInspectTypeName}</th>  	    		
			    	    		<th >${t.inspectDate }</th>
			    	    		<th >${t.actionReqName }</th>
			    	    		<th >${t.miActionReqTypeName} </th>
			    	    		<th >${t.remarks}</th>
			    	    	<%-- 	<th >${t.tankInspectApproveStatus}</th>	 --%>
			    	    		</tr> 
                        
                        </c:if>
                        </c:forEach>
                        <tr  >
					    <th class="micolred" >WEIR</th>   	    		
			    		<th ></th>
			    		<th ></th>
			    		<th ></th>	
			    		<th ></th>
			    		
			    		</tr>
			    		 <c:forEach items="${EmbCheckList}" var="t" varStatus="count">	
			    		<c:if test="${t.miCompId==6 || t.miCompId==7}">
			    		
			    			<c:if test="${t.tankWeirSluiceId>0}">
			    			
			    			  <c:set var = "newwrvalue" scope = "session" value = "${t.tankWeirSluiceId>0}"/>	
			    			  
			    			   <c:if test="${oldwrvalue!=newwrvalue}">
			    			    <c:set var = "oldwrvalue" scope = "session" value = "${newwrvalue}"/>
			    			    
			    			     <tr  >
				    			    <th class="micolgreen" >${t.tankWeirSluiceName}</th>   	    		
				    	    		<th class=""></th>
				    	    		<th class=""></th>
				    	    		<th class=""></th>
				    	    		<th class=""></th>
				    	    		
				    	    		</tr>
			    			   </c:if>	
			    			   
			    			   
			    		</c:if>
			    		
			    		 <tr >
			    			    <th  >${t.miInspectTypeName}</th>  	    		
			    	    		<th >${t.inspectDate }</th>
			    	    		<th >${t.actionReqName }</th>
			    	    		<th >${t.miActionReqTypeName} </th>
			    	    		<th >${t.remarks}</th>
			    	    		<%-- <th >${t.tankInspectApproveStatus}</th>	 --%>
			    	    		</tr> 
			    		</c:if>
			    		</c:forEach>
			    		
			    		</tbody>
		</table>
		
			
		
		</div>
		</div>
				</div>
				
				
				
			
		
						 	
				</div>
				
                      
                      
          <div id="vtr">
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

	<div id="verticalrh">
				<ul>
					<li><a href="#vtasi" >Admin Sanction Information</a></li>
					<li><a href="#vtai" > Repair History</a></li>
					<li><a href="#vtbi" >Status of Execution</a></li>
				<!-- 	<li><a href="#vtri" >Repair Information</a></li> -->
					
				</ul>
				<div id="vtasi">

<div id="adminsanctiondata" class="col-md-12 invDiv" > <h3> Admin Sanction Info </h3> 
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
									 
									 	<div id="vtai">

	<div id="agmtdata" class="col-md-12 invDiv" > <h3> Repair History </h3> 
	 <div  id="aggmt-data">
    <div class="table-responsive" >
    <c:if test="${agmtObj!=null}">
										<table class="display table-bordered tableinspect " style="width: 100%"
											id="table10">
											<thead id="thead10">
											<tr style="font-size: 18px; color: blue; font-weight: bold;"><th>Sl.No</th>
			    	    	
			    	    		<th>Name of Agency</th>
			    	    		<th>Agreement Amount(in Lakhs.)</th>
			    	    		<th>Agreement Date</th>
			    	    	   <th>Tender Premium %</th>
			    	    		<th>Agreement Number</th>
			    	    		<th>Agreement Type</th>			    	    		
			    	    		<th>Action</th>	
			    	    	
			    	    		</tr>

											</thead>


											<tbody id="tbody10">
                                            <c:forEach items="${agmtObj}" var="k" varStatus="count">
                                             <c:set var = "agtype" scope = "session" value = "${k.agreement_type_id}"/>	
                                              <c:set var = "agmttypename" scope = "session" value = " "/>
                                                <c:if test="${agtype==1}">	
                                               <c:set var = "agmttypename" scope = "session" value = "Original Agreement"/>
                                            	</c:if>
                                            	<c:if test="${agtype==2}">	
                                               <c:set var = "agmttypename" scope = "session" value = "Work Slip"/>
                                            	</c:if>	
                                            	<c:if test="${agtype==3}">	
                                               <c:set var = "agmttypename" scope = "session" value = "Supplementary Agreement"/>
                                            	</c:if>	
                                            		<c:if test="${agtype==4}">	
                                               <c:set var = "agmttypename" scope = "session" value = "60c"/>
                                            	</c:if>	
                                            	 <c:set var = "x" scope = "session" value = "${k.work_id}"/>	
                                            	 
                                            	 
                                            		
                                            	 
                                            	 <!-- start of table -->
                                            	 
                                            	 <tr style="font-size: 16px" >
				    	    			                               <td style="text-align: center;">${count.count}</td>
				    	    			                           
				    	    			                                <td><b>${k.agency_name}</b></td>				    	    			                                
				    	    			                               <td><b>${k.agreement_amount}</b></td> 
				    	    			                                <td><b>${k.agreement_date}</b></td>
				    	    			                                <td><b>${k.premium_percentage}</b></td>
				    	    			                                
				    	    			                                <td><b>${k.agreement_number}</b></td>
				    	    			                                <c:choose>
				    	    			                                	<c:when test="${agmttypename!=null}">	
				    	    			                      <td><b>${agmttypename}</b></td>
				    	    			                      </c:when>
				    	    			                      <c:otherwise>
				    	    			                      <td></td>
				    	    			                      
				    	    			                      </c:otherwise>
				    	    			                      </c:choose>
				    	    			                       <c:choose>
				    	    			                                	<c:when test="${x>0}">	
				    	    			                                	<td><button type="button" name="repairdatainf" id="repairdatainf${count.count}" class="btn btn-1 btn-primary center-block " onclick="getmkrepairdatafun('${x}')"><b>View Repair Info</b></button></td>
				    	    			                                	</c:when>
				    	    			                                	 <c:otherwise>
				    	    			                      <td></td>
				    	    			                      
				    	    			                      </c:otherwise>
				    	    			                                	</c:choose>
				    	    			                              
				    	    			                                </tr>
                                            	 
                                            	 
                                            	 
                                            	 
                                            	 
                                             </c:forEach>
											</tbody>
										</table>
										</c:if>

									</div>
									</div>
									
									
				<br>	
				
				  <c:set var = "oldworkid" scope = "session" value = "0"/>	
				   <c:set var = "newworkid" scope = "session" value = "0"/>	
				    <c:set var = "slcount" scope = "session" value = "1"/>		
	  <c:forEach items="${agmtObj}" var="m" varStatus="count">	
	  <br>	
	  &emsp;&emsp;&emsp;&emsp;	
	  
	  		
	  		<c:set var = "newworkid" scope = "session" value = "${m.work_id}"/>	
	  		
	  	
	  		
	  		
	  		
	  	
	  		
	  			
		<div id="rdata${m.work_id}" class="rview">
	<div class="table-responsive" >
	
	 <c:if test="${repairObj!=null}">
										<table class="display table-bordered  tableinspect" style="width: 100%"
											id="table7${count.count}">
											<thead id="thead7${count.count}">
												<tr style="font-size: 18px; color: blue; font-weight: bold;"><th>Sl.No</th>
			    	    		
			    	    		<th>Quantity</th>
			    	    		<th>Work Done Quantity</th>
			    	    		 <th>Unit Name </th>
			    	    		<th>Rate Per Unit</th>
			    	    		<th>Type Of Work</th>
			    	    	
			    	    		
			    	    		<th>Customized Description</th>
			    	    		
			    	    		</tr>

											</thead>


											<tbody id="tbody7${count.count}">
											
											   
											    
											   
											  
	  	
	  		
											 <c:forEach items="${repairObj}" var="q" varStatus="count">
											      <%--  <c:set var = "rworkid" scope = "session" value = "${q.work_id}"/> --%>
								     
											      
											     
											   
											      
											      <c:if test="${m.work_id==q.work_id }">
											      
					
	  		  <c:if test="${oldworkid!=newworkid }">
											  
	  			<c:set var = "oldworkid" scope = "session" value = "${newworkid}"/>	
	  			<c:set var = "slcount" scope = "session" value = "1"/>	
	  		</c:if>
							
											      
											      
											       
											       <tr style="font-size: 16px"  >
			    	    			                                <td style="text-align: center;">${slcount}</td>
			    	    			                                
			    	    			                                <td><b>${q.quantity}</b></td>
			    	    			                                <td><b>${q.work_done_quantity}</b></td>
			    	    			                                <td><b>${q.unit_name}</b></td>
			    	    			                                <td><b>${q.rate_per_unit}</b></td>
			    	    			                                <td><b>${q.typeofwork}</b></td>
			    	    			                                <td><b>${q.customized_description}</b></td>
			    	    			                                </tr>	
			    	    			                                
			    	    			                                </c:if>
                                                 <c:set var = "slcount" scope = "session" value = "${slcount+1}"/>	
                                             </c:forEach>
											</tbody>
										</table>
										
										</c:if>

									</div>
									</div>
									
									
									</c:forEach>
									
									 </div>
									 </div>
									 
									 	<div id="vtbi">
									 
		 <div id="billdata" class="col-md-12 invDiv" > <h3>Status of Execution </h3>  
		<div  id="bill-data">
    <div class="table-responsive" >
    
     <c:if test="${billObj!=null}">
										<table class="display table-bordered tableinspect " style="width: 100%"
											id="table12">
											<thead id="thead12">											
			    	    		<tr style="font-size: 18px; color: blue; font-weight: bold;"><th>Sl.No</th>
			    	    	
			    	    	<th>Phase</th>
			    	    		<th>Bill Status</th>
			    	    		<!-- <th>Bill Status Id</th> -->
			    	    		<th>Updated On</th>
			    	    		<th>Bill Type</th>
			    	    		
			    	    		</tr>
		</thead>


											<tbody id="tbody12">
   <c:forEach items="${billObj}" var="p" varStatus="count">
      <c:set var = "billtype" scope = "session" value = "${p.bill_type}"/>	
   
   
   <tr style="font-size: 16px">
			    	    			                                <td style="text-align: center;">${count.count}</td>
			    	    			                                <td><b>${p.phase}</b></td>
			    	    			                                <td><b>${p.bill_status}</b></td>
			    	    			                               <!--  <td><b>'+billObj[i].bill_status_id+'</b></td> -->
			    	    			                                <td><b>${p.updated_on}</b></td>
			    	    			                                <c:choose>
			    	    			                                <c:when test="${billtype==3 }">
			    	    			                                <td><b>Work Completed </b></td>
			    	    			                                
			    	    			                                </c:when>
			    	    			                                <c:otherwise>
			    	    			                                <td><b>Work in progress </b></td>
			    	    			                                </c:otherwise>
			    	    			                                
			    	    			                                </c:choose>
			    	    			                            
			    	    			                                </tr>
   
   </c:forEach>

											</tbody>
										</table>
										
										</c:if>

									</div>
									</div>
									</div>
									</div>
									
										<%-- <div id="vtri">
	
	
		<div id="repairdata" class="col-md-12 invDiv" > <h3> Repair Info </h3>  
		<div id="rdata">
	<div class="table-responsive" >
	
	 <c:if test="${repairObj!=null}">
										<table class="display table-bordered  tableinspect" style="width: 100%"
											id="table7">
											<thead id="thead7">
												<tr style="font-size: 18px; color: blue; font-weight: bold;"><th>Sl.No</th>
			    	    		
			    	    		<th>Quantity</th>
			    	    		<th>Work Done Quantity</th>
			    	    		 <th>Unit Name </th>
			    	    		<th>Rate Per Unit</th>
			    	    		<th>Type Of Work</th>
			    	    	
			    	    		
			    	    		<th>Customized Description</th>
			    	    		
			    	    		</tr>

											</thead>


											<tbody id="tbody7">
											 <c:forEach items="${repairObj}" var="q" varStatus="count">
											       <c:set var = "rworkid" scope = "session" value = "${q.work_id}"/>
											       
											       <tr style="font-size: 16px"  >
			    	    			                                <td style="text-align: center;">${count.count}</td>
			    	    			                                
			    	    			                                <td><b>${q.quantity}</b></td>
			    	    			                                <td><b>${q.work_done_quantity}</b></td>
			    	    			                                <td><b>${q.unit_name}</b></td>
			    	    			                                <td><b>${q.rate_per_unit}</b></td>
			    	    			                                <td><b>${q.typeofwork}</b></td>
			    	    			                                <td><b>${q.customized_description}</b></td>
			    	    			                                </tr>	

                                             </c:forEach>
											</tbody>
										</table>
										
										</c:if>

									</div>
									</div>
									</div>
									
									</div> --%>
								
	

	<!-- <div id="tenderdata" class="col-md-12 invDiv" > <h3> Tender Info </h3>  
	<div id="tender-data">
	<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="table8">
											<thead id="thead8">

											</thead>


											<tbody id="tbody8">


											</tbody>
										</table>

									</div>
									</div>
									</div> -->
	
	
	<!-- <div id="estdata" class="col-md-12 invDiv" > <h3> Estimate Info </h3>  
	<div  id="est-data">
    <div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="table11">
											<thead id="thead11">

											</thead>


											<tbody id="tbody11">


											</tbody>
										</table>

									</div>
									</div>
									</div> -->
		

   
								<!-- for repaIR HISTORY REPORT IF TAKEN AS INPUT
								
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class="display table-bordered table1" style="width: 100%"
											id="table5">
											<thead id="thead5">

											</thead>


											<tbody id="tbody5">


											</tbody>
										</table>

									</div>

								</div> -->
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
		 