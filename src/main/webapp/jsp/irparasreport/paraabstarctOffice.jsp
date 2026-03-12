
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
	<link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />






<script type="text/javascript">

function getparastatus (unitId,circleId,divisionId,subdivisionId,formId){
	
	//alert(unitId+circleId+divisionId+subdivisionId);
	
	
			
			$('#unitId').val(unitId);
			$('#circleId').val(circleId);
			$('#divisionId').val(divisionId);
			$('#subdivisionId').val(subdivisionId);
			
				
			var act2="../parasreport/parastatus";
			 var newformId2="#"+formId;
			   $(newformId2).attr("action", act2);
			   $(newformId2).submit(); 
			
			
		
	
	
	
}






function getabstractDetail(unitId, circleId, divisionId,subdivisionId,paraStatusId, sectionId, transferflag, formId , hkey,totalflag ){
	

	//alert("hkey"+hkey);
//for unit office
if(hkey==1){
	
	var circleTotal=false;
		
		$('#unitId').val(unitId);
		$('#circleId').val(circleId);
		$('#divisionId').val(divisionId);
		$('#subdivisionId').val(subdivisionId);
		$('#transferFlag').val(transferflag);
		$('#sectionId').val(sectionId);
		$('#paraStatusId').val(paraStatusId);
		$('#circleTotal').val(circleTotal);
		$('#unitTotal').val(totalflag);
		
			
		var act2="../parasreport/parasAbstractDetail";
		 var newformId2="#"+formId;
		   $(newformId2).attr("action", act2);
		   $(newformId2).submit(); 
		
		
	}
// for circle office
	if(hkey==2){
		
		var unitTotal=false;
		
		$('#unitId').val(unitId);
		$('#circleId').val(circleId);
		$('#divisionId').val(divisionId);
		$('#subdivisionId').val(subdivisionId);
		$('#transferFlag').val(transferflag);
		$('#sectionId').val(sectionId);
		$('#paraStatusId').val(paraStatusId);
		$('#circleTotal').val(totalflag);
		$('#unitTotal').val(unitTotal);
		
			
		var act2="../parasreport/parasAbstractDetail";
		 var newformId2="#"+formId;
		   $(newformId2).attr("action", act2);
		   $(newformId2).submit(); 
		
		
	}
	
if(hkey==4){
	
	var unitTotal=false;
		
		$('#unitId').val(unitId);
		$('#circleId').val(circleId);
		$('#divisionId').val(divisionId);
		$('#subdivisionId').val(subdivisionId);
		$('#transferFlag').val(transferflag);
		$('#sectionId').val(sectionId);
		$('#paraStatusId').val(paraStatusId);
		$('#circleTotal').val(totalflag);
		$('#unitTotal').val(unitTotal);
		
			
		var act2="../parasreport/parasAbstractDetail";
		 var newformId2="#"+formId;
		   $(newformId2).attr("action", act2);
		   $(newformId2).submit(); 
		
		
	}
	
if(hkey==6){
	
	var unitTotal=false;
		
		$('#unitId').val(unitId);
		$('#circleId').val(circleId);
		$('#divisionId').val(divisionId);
		$('#subdivisionId').val(subdivisionId);
		$('#transferFlag').val(transferflag);
		$('#sectionId').val(sectionId);
		$('#paraStatusId').val(paraStatusId);
		$('#circleTotal').val(totalflag);
		$('#unitTotal').val(unitTotal);
		
			
		var act2="../parasreport/parasAbstractDetail";
		 var newformId2="#"+formId;
		   $(newformId2).attr("action", act2);
		   $(newformId2).submit(); 
		
		
	}  
	
	
if(hkey==7){
	
	var circleTotal=false;
		
		$('#unitId').val(unitId);
		$('#circleId').val(circleId);
		$('#divisionId').val(divisionId);
		$('#subdivisionId').val(subdivisionId);
		$('#transferFlag').val(transferflag);
		$('#sectionId').val(sectionId);
		$('#paraStatusId').val(paraStatusId);
		$('#circleTotal').val(circleTotal);
		$('#unitTotal').val(totalflag);
		
			
		var act2="../parasreport/parasAbstractDetail";
		 var newformId2="#"+formId;
		   $(newformId2).attr("action", act2);
		   $(newformId2).submit(); 
		
		
	}  
		
		
		}
		
		
		function getabstractDetaildiv(unitId, circleId, divisionId,subdivisionId,paraStatusId, sectionId, transferflag, formId , hkey ){
			
			if(hkey==3 || 5 ){
				
				var unitTotal=false;
				var circleTotal=false;
					
					$('#unitId').val(unitId);
					$('#circleId').val(circleId);
					$('#divisionId').val(divisionId);
					$('#subdivisionId').val(subdivisionId);
					$('#transferFlag').val(transferflag);
					$('#sectionId').val(sectionId);
					$('#paraStatusId').val(paraStatusId);
					$('#circleTotal').val(circleTotal);
					$('#unitTotal').val(unitTotal);
					
						
					var act2="../parasreport/parasAbstractDetail";
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
						
						 <c:if test="${userObj.employeeName!=null &&  userObj.employeeName!='NA'   }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>	
			 
			 </c:if>
			 
			 <c:if test="${userObj.designationName!=null  && userObj.designationName!='NA' }">	
						   
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
			
			<div class="alert alert-info" style="padding: 0px" role="alert">
 <strong>Note : Please Use A4(landscape) Size Paper for Print. Also Selected Data Can be Exported and Printed</strong>
</div>


<!-- <div >
										<div class="col-md-4 "></div>
										<div class="col-md-4 ">
											<button type="button" name="gistform1" id="gist1"
									class="btn btn-1 btn-primary  ">Back to Report By Unit </button>
										</div>
										<div class="col-md-4 "></div>
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
			


	

				<form:form id="parareport" method="post" modelAttribute="parareportdata">
			
				<input name=unitId id="unitId" type=hidden>
				<input name=circleId id="circleId" type=hidden>
				<input name=divisionId id="divisionId" type=hidden>
				<input name=subdivisionId id="subdivisionId" type=hidden>
				<input name=transferFlag id="transferFlag" type=hidden>
				<input name=sectionId id="sectionId" type=hidden>
				<input name=paraStatusId id="paraStatusId" type=hidden>
				<input name=unitTotal id="unitTotal" type=hidden>
			    <input name=circleTotal id="circleTotal" type=hidden>
				
				
			
			</form:form>
		



					<div
						class="mainprint pagecontent"
						style="display: block">

<%-- <c:if test="${compCapList!=null}"> --%>

						<div class="table-responsive" id="printarea">

							<table class="table1 display table-bordered " id="table1">
								<thead >
									
									<tr>
										
										<th > Name of Unit</th>
										<th > Name of Circle</th>
										<th > Name of Division</th>
										<th  >Total Paras</th>
										
										<th  >Section A</th>
										<th  >Section B</th>						
										<th  >Dropped Paras</th>
										<th  >Transferred</th>										
										<th >Balance Paras</th>
										<th  >Reply Sent to AG</th>
										<th >Reply Not sent to AG</th>									
										
										
										
										


									</tr>
									

									

								</thead>


								<tbody>
									
										<c:forEach items="${paraListUnit}" var="t" varStatus="count">
											<tr>

											
													
													
					
											
												
											
												
												
												<td style="color: black "><b><c:out value="${t.unitName}"></c:out> </b></td>
												<td></td>
												<td></td>
												<td  style="color: red"><a   href="javascript:void(0)" onclick="getabstractDetail(${t.unitId},${t.circleId},${t.divisionId},${t.subdivisionId},0,0,false,'parareport',1,false)"><c:out value="${t.totalParas}"></c:out></a></td>
												<td><a  href="javascript:void(0)" onclick="getabstractDetail(${t.unitId},${t.circleId},${t.divisionId},${t.subdivisionId},0,1,false,'parareport',1,false)"><c:out value="${t.secAParasCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${t.unitId},${t.circleId},${t.divisionId},${t.subdivisionId},0,2,false,'parareport',1,false)"><c:out value="${t.secBParasCount}"></c:out></a></td>
												
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${t.unitId},${t.circleId},${t.divisionId},${t.subdivisionId},3,0,false,'parareport',1,false)"><c:out value="${t.droppedCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${t.unitId},${t.circleId},${t.divisionId},${t.subdivisionId},0,0,true,'parareport',1,false)"><c:out value="${t.transfrred}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${t.unitId},${t.circleId},${t.divisionId},${t.subdivisionId},8,0,false,'parareport',1,false)"><c:out value="${t.balanceParas}"></c:out></a></td>
												<td><a  href="javascript:void(0)" onclick="getabstractDetail(${t.unitId},${t.circleId},${t.divisionId},${t.subdivisionId},1,0,false,'parareport',1,false)"><c:out value="${t.replySent}"></c:out></a></td>

												
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${t.unitId},${t.circleId},${t.divisionId},${t.subdivisionId},2,0,false,'parareport',1,false)"><c:out value="${t.replyNotSent}"></c:out></a></td>
												
												
												
												
										</tr>
										
										
										
										

										</c:forEach>
										
										<c:if test="${paraListCircle!=null}">
										<c:forEach items="${paraListCircle}" var="d" varStatus="count">
										
									
										<tr>

												
												<td></td>
													
											
												<td style="color: green " ><b><c:out value="${d.circleName}"></c:out> </b></td>
												<td></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${d.unitId},${d.circleId},${d.divisionId},${d.subdivisionId},0,0,false,'parareport',2,false)" ><c:out value="${d.totalParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${d.unitId},${d.circleId},${d.divisionId},${d.subdivisionId},0,1,false,'parareport',2,false)"><c:out value="${d.secAParasCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${d.unitId},${d.circleId},${d.divisionId},${d.subdivisionId},0,2,false,'parareport',2,false)"><c:out value="${d.secBParasCount}"></c:out></a></td>
												
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${d.unitId},${d.circleId},${d.divisionId},${d.subdivisionId},3,0,false,'parareport',2,false)"><c:out value="${d.droppedCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${d.unitId},${d.circleId},${d.divisionId},${d.subdivisionId},0,0,true,'parareport',2,false)"><c:out value="${d.transfrred}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${d.unitId},${d.circleId},${d.divisionId},${d.subdivisionId},8,0,false,'parareport',2,false)" ><c:out value="${d.balanceParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${d.unitId},${d.circleId},${d.divisionId},${d.subdivisionId},1,0,false,'parareport',2,false)" ><c:out value="${d.replySent}"></c:out></a></td>

												
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${d.unitId},${d.circleId},${d.divisionId},${d.subdivisionId},2,0,false,'parareport',2,false)" ><c:out value="${d.replyNotSent}"></c:out></a></td>
												
												
												
												
										</tr>
										
										
										
											<c:forEach items="${paraListDivision}" var="e" varStatus="count">
											
											
										
										<c:if test="${( d.circleId==e.circleId) }">
										<tr>

												
												<td></td>
													
													
													
					
											
												
											   <td></td>
												
												
												<td style="color: blue "><b><c:out value="${e.divisionName}"></c:out> </b></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${e.unitId},${e.circleId},${e.divisionId},${e.subdivisionId},0,0,false,'parareport',3)" ><c:out value="${e.totalParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)"  onclick="getabstractDetaildiv(${e.unitId},${e.circleId},${e.divisionId},${e.subdivisionId},0,1,false,'parareport',3)" ><c:out value="${e.secAParasCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${e.unitId},${e.circleId},${e.divisionId},${e.subdivisionId},0,2,false,'parareport',3)"><c:out value="${e.secBParasCount}"></c:out></a></td>
												
												<td><a  href="javascript:void(0)" onclick="getabstractDetaildiv(${e.unitId},${e.circleId},${e.divisionId},${e.subdivisionId},3,0,false,'parareport',3)"><c:out value="${e.droppedCount}"></c:out></a></td>
													<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${e.unitId},${e.circleId},${e.divisionId},${e.subdivisionId},0,0,true,'parareport',3)"><c:out value="${e.transfrred}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${e.unitId},${e.circleId},${e.divisionId},${e.subdivisionId},8,0,false,'parareport',3)"><c:out value="${e.balanceParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${e.unitId},${e.circleId},${e.divisionId},${e.subdivisionId},1,0,false,'parareport',3)"><c:out value="${e.replySent}"></c:out></a></td>

												
												<td><a   href="javascript:void(0)"  onclick="getabstractDetaildiv(${e.unitId},${e.circleId},${e.divisionId},${e.subdivisionId},2,0,false,'parareport',3)"><c:out value="${e.replyNotSent}"></c:out></a></td>
											
												
												
												
										</tr>
										</c:if>
										</c:forEach>
										
										
										
										
									
										
										<c:forEach items="${paraListCircleTotal}" var="g" varStatus="count">
										
										<c:if test="${( d.circleId == g.circleId ) }">
										<tr>

									
											  <td></td>
												
												<td style="color: red "><b><c:out value="${g.circleName}"></c:out>  Total</b></td>
												<td></td>
												<td  style="color: red " ><a   href="javascript:void(0)" onclick="getabstractDetail(${g.unitId},${g.circleId},${g.divisionId},${g.subdivisionId},0,0,false,'parareport',4,true)"><c:out value="${g.totalParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${g.unitId},${g.circleId},${g.divisionId},${g.subdivisionId},0,1,false,'parareport',4,true)"><c:out value="${g.secAParasCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${g.unitId},${g.circleId},${g.divisionId},${g.subdivisionId},0,2,false,'parareport',4,true)"><c:out value="${g.secBParasCount}"></c:out></a></td>
												 
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${g.unitId},${g.circleId},${g.divisionId},${g.subdivisionId},3,0,false,'parareport',4,true)"><c:out value="${g.droppedCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${g.unitId},${g.circleId},${g.divisionId},${g.subdivisionId},0,0,true,'parareport',4,true)"><c:out value="${g.transfrred}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${g.unitId},${g.circleId},${g.divisionId},${g.subdivisionId},8,0,false,'parareport',4,true)"><c:out value="${g.balanceParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${g.unitId},${g.circleId},${g.divisionId},${g.subdivisionId},1,0,false,'parareport',4,true)"><c:out value="${g.replySent}"></c:out></a></td>

												
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${g.unitId},${g.circleId},${g.divisionId},${g.subdivisionId},2,0,false,'parareport',4,true)" ><c:out value="${g.replyNotSent}"></c:out></a></td>
												
												
												
												
									
										</c:if>
										
										</c:forEach>
										
										
										
										
										
										
										</c:forEach>
									
										</c:if>
										
										
									
										 <c:if test="${paraListDivisionWithOutCircle!=null}">
										
									
										
										
										<c:forEach items="${paraListDivisionWithOutCircle}" var="k" varStatus="count">
											
										<c:set var = "withoutcircle" scope = "session" value = "${k.circleId}"/>		
									
										
										<c:if test="${(k.unitId>0 && k.circleId>0 && k.divisionId>0) }">
										<tr>

												
												<td></td>
												
													
													
					
											
												
											   <td></td>
												
												
												<td style="color: blue "><b><c:out value="${k.divisionName}"></c:out> </b></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${k.unitId},${k.circleId},${k.divisionId},${k.subdivisionId},0,0,false,'parareport',5)" ><c:out value="${k.totalParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${k.unitId},${k.circleId},${k.divisionId},${k.subdivisionId},0,1,false,'parareport',5)"><c:out value="${k.secAParasCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${k.unitId},${k.circleId},${k.divisionId},${k.subdivisionId},0,2,false,'parareport',5)"><c:out value="${k.secBParasCount}"></c:out></a></td>
												
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${k.unitId},${k.circleId},${k.divisionId},${k.subdivisionId},3,0,false,'parareport',5)"><c:out value="${k.droppedCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${k.unitId},${k.circleId},${k.divisionId},${k.subdivisionId},0,0,true,'parareport',5)"><c:out value="${k.transfrred}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${k.unitId},${k.circleId},${k.divisionId},${k.subdivisionId},8,0,false,'parareport',5)"><c:out value="${k.balanceParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetaildiv(${k.unitId},${k.circleId},${k.divisionId},${k.subdivisionId},1,0,false,'parareport',5)"><c:out value="${k.replySent}"></c:out></a></td>

												
												<td><a  href="javascript:void(0)" onclick="getabstractDetaildiv(${k.unitId},${k.circleId},${k.divisionId},${k.subdivisionId},2,0,false,'parareport',5)"><c:out value="${k.replyNotSent}"></c:out></a></td>
												
												
												
												
										</tr>
										</c:if>
										
										
										
									
										
										</c:forEach>
									
											<c:forEach items="${paraListCircleTotal}" var="m" varStatus="count">
										
										<c:if test="${( withoutcircle == m.circleId ) }">
										<tr>

											
												<td></td>
												<td style="color:  red ; "><b><c:out value="${m.circleName}"></c:out>  Total</b></td>
												<td></td>
												<td  ><a   href="javascript:void(0)"  onclick="getabstractDetail(${m.unitId},${m.circleId},${m.divisionId},${m.subdivisionId},0,0,false,'parareport',6,true)"><c:out value="${m.totalParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${m.unitId},${m.circleId},${m.divisionId},${m.subdivisionId},0,1,false,'parareport',6,true)"><c:out value="${m.secAParasCount} "></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${m.unitId},${m.circleId},${m.divisionId},${m.subdivisionId},0,2,false,'parareport',6,true)"><c:out value="${m.secBParasCount} "></c:out></a></td>
												
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${m.unitId},${m.circleId},${m.divisionId},${m.subdivisionId},3,0,false,'parareport',6,true)"><c:out value="${m.droppedCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${m.unitId},${m.circleId},${m.divisionId},${m.subdivisionId},0,0,true,'parareport',6,true)"><c:out value="${m.transfrred}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${m.unitId},${m.circleId},${m.divisionId},${m.subdivisionId},8,0,false,'parareport',6,true)"><c:out value="${m.balanceParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${m.unitId},${m.circleId},${m.divisionId},${m.subdivisionId},1,0,false,'parareport',6,true)"><c:out value="${m.replySent}"></c:out></a></td>

												
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${m.unitId},${m.circleId},${m.divisionId},${m.subdivisionId},2,0,false,'parareport',6,true)"><c:out value="${m.replyNotSent}"></c:out></a></td>
												
												
												
												
										</tr>
									
										</c:if>
											
										</c:forEach>
										
										   <c:set var = "withoutcircle" scope = "session" value = "0"/>
										</c:if> 
										
										<c:forEach items="${paraListUnitTotal}" var="h" varStatus="count">
										
										
										<tr>

											<td style="color: red "><b><c:out value="${h.unitName}"></c:out>  Total</b></td>
												<td></td>
												<td></td>
												
												<td  style="color: red "><a   href="javascript:void(0)"  onclick="getabstractDetail(${h.unitId},${h.circleId},${h.divisionId},${h.subdivisionId},0,0,false,'parareport',7,true)"><c:out value="${h.totalParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)"  onclick="getabstractDetail(${h.unitId},${h.circleId},${h.divisionId},${h.subdivisionId},0,1,false,'parareport',7,true)"><c:out value="${h.secAParasCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)"  onclick="getabstractDetail(${h.unitId},${h.circleId},${h.divisionId},${h.subdivisionId},0,2,false,'parareport',7,true)"><c:out value="${h.secBParasCount}"></c:out></a></td>
												
												<td><a  href="javascript:void(0)" onclick="getabstractDetail(${h.unitId},${h.circleId},${h.divisionId},${h.subdivisionId},3,0,false,'parareport',7,true)"><c:out value="${h.droppedCount}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${h.unitId},${h.circleId},${h.divisionId},${h.subdivisionId},0,0,true,'parareport',7,true)"><c:out value="${h.transfrred}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${h.unitId},${h.circleId},${h.divisionId},${h.subdivisionId},8,0,false,'parareport',7,true)"><c:out value="${h.balanceParas}"></c:out></a></td>
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${h.unitId},${h.circleId},${h.divisionId},${h.subdivisionId},1,0,false,'parareport',7,true)"><c:out value="${h.replySent}"></c:out></a></td>

												
												<td><a   href="javascript:void(0)" onclick="getabstractDetail(${h.unitId},${h.circleId},${h.divisionId},${h.subdivisionId},2,0,false,'parareport',7,true)"><c:out value="${h.replyNotSent}"></c:out></a></td>
												
												
												
												
										</tr>
										
										</c:forEach>
									


									
									
								</tbody>


							</table>
							
							
	
						</div>
				
					

					</div>
					
					


</div>

			
			
		</div>





</div>

<div class="col-md-12">
																
									<button type="button" name="showgist" id="showgistid"  class="btn btn-1 btn-primary center-block "  onclick="getparastatus(${sunitId},${scircleId},${sdivisionId},${ssubdivisionId},'parareport')" >Back to Report By Unit Office  </button>
										
										</div>

</div>
<!-- //main-content -->


<!-- <script src="../js/Html5DataTable/jquery-3.3.1.js" type="text/javascript"></script> -->
	<script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.print.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>

	
	
	<script type="text/javascript">			
							
    $('.table1').DataTable( {
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
                sheetName: 'Exported Paras data',
                text:  'Save To Excel',
                className: 'btn btn-1 btn-primary ',
                messageTop: 'IR Paras AG Paras Report'
                
                
            },
            
            {
                extend: 'pdfHtml5',
                className: 'btn btn-1 btn-primary ',
                text:  'PDF View / Download',
                orientation: 'landscape',
                pageSize: 'A4',
                download: 'open',
            
               
                filename: 'IR_Paras_Report',
                exportOptions: {
					columns: ':visible',
					search: 'applied',
					order: 'applied'
				},
				
               
                title: 'IR Paras AG Paras Report',
                customize: function (doc) {        
                	doc.defaultStyle.fontSize = 11;
                	doc.defaultStyle.alignment = 'center';
                	doc.styles.tableHeader.fontSize = 14;
                	doc.pageMargins = [90, 80,80,90];
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
                className: 'btn btn-1 btn-primary ',
                exportOptions: {
                    modifier: {
                        selected: null
                    }
                }
               
                
                
            },
            ,{
                extend: 'print',
                text: 'Print Selected',
                className: 'btn btn-1 btn-primary '
                
                
                
            }
        ],
        select: true
       
    } );
    
    </script>	
								



  


<!-- //main-content -->
