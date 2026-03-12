<%@include file="/jsp/header/taglib_includes.jsp"%> 

<script>
function chargeIndex(desg,postid){
	
	
	$("#postId").val(postid);
	
	var p=$("#postId").val();
	//alert(p);
	
	$("#designationId").val(desg);
	
	var ds=$("#designationId").val();
	
	
	//alert(ds);
	
	
	
	  
		/* document.getElementById("noDuesNoCharges["+rr+"].challanRemarks").value;  */
		document.forms.addnlLoginformid.action="../webtsimis/addnllogin";
			//?postId="+postId+"&designationId="+designationId+"&employeeName="+userName ;
	
		document.forms.addnlLoginformid.submit();
}

</script>
<div class='container'>

 

           <div class="row-fluid  ">
        <div class="span6    " >
            <!-- <p  class="marquee"  >Text left</p> -->
        </div>
        <div class="span6 pull-right">
           <!--  <p>Sri Ram Sagar Project Stage-I</p> -->
        </div>
    </div>

	<div class="page">
		<div class="col-md-4"></div>


		<div class="row">
			<div class="col-md-12">
			
			<font color="#088AC4" face="verdana" size=1></font>
		<div  align="right" >
		<marquee>
 			<b>	Last Login Date : </b>
				<fmt:formatDate type = "date" value="${userObj.logouttime}" ></fmt:formatDate> 			
			</marquee>
		</div> 

				<!--   panel start here -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Welcome to  
						
						
						
						   <c:if test="${userObj!=null}">	
						   
						   
						   <c:if test="${userObj.employeeName!=null && userObj.employeeName!='NA'  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>	
			 
			 </c:if>
			 
			 
			 
			  <c:if test="${usersAddChargeList==null}">	
			 
			 <c:if test="${userObj.designationName!=null && userObj.designationName!='NA'  }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>	
			 
			 </c:if>
			 <br></br>
						
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
						   
			  <c:if test="${userObj.userName!='icad_test' &&  userObj.userName!='cs_telangana'  }">	 <c:out value="${userObj.unitName}"></c:out></c:if>
			   <c:if test="${userObj.userName=='icad_test'  }">	 AG AUDIT</c:if>
			     <c:if test="${userObj.userName=='cs_telangana'  }">	 CS Telangana</c:if>
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
			 </c:if>
			 
			  <%-- <c:out value="${userObj.subdivisionId}"></c:out>	 --%>
			 
			   <c:if test="${userObj.unitId==null && userObj.circleId==null && userObj.divisionId==null && userObj.subdivisionId==null }">	
						   
			 <c:out value="${userObj.userName}"></c:out>	
			 
			 </c:if>	
	</c:if></h3>
					</div>
					<div class="panel-body">
					
				<form id="addnlLoginformid" name="addnlLogin" 	 method="post"  >	
				
				               <input   type="hidden" name="designationId" value="0" id="designationId"  />
					                   <input name="post" value="0" id="postId" type="hidden" />
											 

					 <!--   table starts here -->
						<div class="table-responsive">
							<table class="table table-bordered table-striped">
							<c:if test="${usersAddChargeList!=null}"> 
							
							
							<thead>
							<tr style="text-align: center;">
							<th>Sl.No</th>
							<th>Unit Name</th>
							<th>Circle Name</th>
							<th>Division Name</th>
							<th>SubDivision Name</th>
							<th>Section</th>
							<th>Designation</th>
							</tr>
							
							</thead>

								<tbody>
					
						
						
					   <c:forEach items="${usersAddChargeList}" var="a" varStatus="count">
											<tr>
												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
												<td><c:out value="${a.unitName}"></c:out></td>
												<td><c:out value="${a.circleName}"></c:out></td>
												<td><c:out value="${a.divisionName}"></c:out></td>
												<td><c:out value="${a.subdivisionName}"></c:out></td>
												<td><c:out value="${a.sectionName}"></c:out></td>
												<td><c:out value="${a.designationName}"></c:out></td>
												<td>
												 <button type="submit" name="addres" id="addres${count.count}" class="btn btn-1 btn-primary center-block" onclick="chargeIndex(${a.designationId},${a.post})">login</button>
											 
												 </td>
										</tr>
						
						</c:forEach> 
						
						</c:if>	 
								
								
									
								</tbody>
							</table>
							
						</div>
						
						</form>
						<!-- table ends here -->
					</div>
				</div>
				<!--  panel ends here -->

			</div>
			<!-- /.col-sm-4 -->


		</div>
		<!-- row -->
		<div class="col-sm-4"></div>
	</div>
	<!-- page -->
</div>
<!-- container -->