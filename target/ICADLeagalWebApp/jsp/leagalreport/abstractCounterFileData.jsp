
<%@include file="/jsp/header/taglib_includes.jsp"%> 











<c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.employeeName}"></c:out></p>
		</div>
	</div>
	</c:if>	<c:if test="${msg!=null || err!=null }">


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
	
	




		
		
	
	 
	<div class="w3l-main" id="borderStyle">
	
				
<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Counter File Status</h3>
			</div>

			<div class='container'>




				<div class="row col-md-12 toppad ">
<form:form id="casesReport" method="post"
				modelAttribute="abstract" >
				
					<div class="row show-grid">

					
						<div class="col-md-10">
							<div class="form-group">
        <label class="col-sm-2 control-label">Select Court</label>
        <div class="col-sm-10">
        <c:choose>
        <c:when test="${selectedCourt==-1||selectedCourt==null}">
          <label class="radio-inline"> <input type="radio" name="courtId" id="courtId" checked="checked" value="-1" > All Cases </label>
           </c:when>
           <c:otherwise>
           <label class="radio-inline"> <input type="radio" name="courtId" id="courtId"  value="-1" > All Cases </label>
           </c:otherwise>
            </c:choose>
            
        <c:forEach items="${courtList}" var="c" varStatus="count">
         <c:choose>
            <c:when test="${selectedCourt==c.courtId}">
        
        <label class="radio-inline"> <input type="radio" name="courtId" id="courtId"  checked="checked"    value="${c.courtId}" > <c:out value="${c.courtName}"></c:out> </label>
       
        </c:when>
               <c:otherwise>
               
                <label class="radio-inline"> <input type="radio" name="courtId" id="courtId"   value="${c.courtId}" > <c:out value="${c.courtName}"></c:out> </label>
               
           </c:otherwise>
           </c:choose>
        
        
           
            </c:forEach>
            
                
               
               
           
         
            
           
        </div>
    </div>
						</div>
						</div>
				

					<div class="row show-grid">

						


						<div class="col-md-10">
							<div class="form-group">
        <label class="col-sm-2 control-label">Case Category</label>
        <div class="col-sm-10">
        <c:forEach items="${caseGenList}" var="c" varStatus="count">
        
         <c:choose>
        <c:when test="${selectedCategory==c.caseGenId}">
        
        
        <label class="radio-inline"> <input type="radio" name="caseGenId" id="caseGenId" checked="checked"   value="${c.caseGenId}" > <c:out value="${c.caseGeneral}"></c:out> </label>
        </c:when>
         <c:otherwise>
         
          <label class="radio-inline"> <input type="radio" name="caseGenId" id="caseGenId"  value="${c.caseGenId}" > <c:out value="${c.caseGeneral}"></c:out> </label>
         
         </c:otherwise>
        </c:choose>
           
            </c:forEach>
        </div>
    </div>
						</div>
						




					</div>
					<div class="row show-grid">
					<div class="clearfix"> </div>
					<div class="clearfix"> </div>
					<div class="col-md-12">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Get Cases" onclick="loadForm()" >
					</div>
					</div>
					
					</form:form>

					

</div>
</div>
</div>








					






			


			
		
	




	

		
		
		<c:if test="${counterDataAll!=null }">
		
		
		<!-- <div class='container'> -->
		<div class=" mainprint  pagecontent" style="display:block">
		
		<!--  <div class="row show-grid gridList"   >
		  -->
		 <div class=" table-responsive" id="printarea">
						<table class=" table-bordered " id="table">
							<thead style="background: #85C1E9 none repeat scroll 0 0;">
							<tr style="color: red; font-weight: bold; background: #ffffff;"><td></td><td>  Court Type</td><td><c:out value="${court}"></c:out></td><td></td><td></td><td> Category:</td><td><c:out value="${category}"></c:out></td> </tr>
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1">Unit Name </th>
									
									
									
									<th rowspan="1" >Cases Filed</th>
									<th rowspan="1" >Draft Counter to GP</th>
									<th rowspan="1" >Counter Filed by GP</th>
									<th rowspan="1" >Counter To be Filed </th>
									<th rowspan="1" >Judgement Given </th>
									
									
								</tr>

								
							
								

							</thead>

							
							<tbody>
								<c:forEach var="c" items="${counterDataAll}" varStatus="count">
									
										<tr>
											
											<td style="text-align: center;"><c:out
													value="${count.count}"></c:out></td>
											<td><c:out value="${c.unitName}"></c:out> </td>
											
											
											
											<td><a target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>&filingDate=1" > <c:out value="${c.casesFiled}"></c:out>   </a></td>
											<td><a  target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>&draftdateconttoGP=2"> <c:out value="${c.draftCountFile}"></c:out></a></td>
											<td><a target="_blank"   href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>&counterDate=3"> <c:out value="${c.counterFiled}"></c:out></a></td>
											<td><a target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>&casesToFile=4"><c:out value="${c.casesToFile}"></c:out></a></td>
											<td><a  target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>&judgementDate=5"><c:out value="${c.casesJudged}"></c:out></a></td>
											
											
											
											
											
							</tr>
									
								</c:forEach>
								<tr style="color: red; font-weight: bold;"><td></td><td>  Total</td><td><a target="_blank"  style="color: red; font-weight: bold;"  href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataAll[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataAll[0].courtId}"></c:out>&filingDate=1" ><c:out value="${AllCF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;"  href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataAll[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataAll[0].courtId}"></c:out>&filingDate=2" ><c:out value="${AllDF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataAll[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataAll[0].courtId}"></c:out>&filingDate=3" ><c:out value="${AllCountF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;"  href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataAll[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataAll[0].courtId}"></c:out>&filingDate=4" ><c:out value="${AllNF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataAll[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataAll[0].courtId}"></c:out>&filingDate=5" ><c:out value="${AllJF}"></c:out></a></td> </tr>
								</tbody>
							

						</table>
						</div>
						
				
					<!-- </div> -->
				
		</div>
		<!-- </div> -->
		</c:if>
		
		
		<c:if test="${counterDataCourt!=null }">
		
		
		<!-- <div class='container'> -->
		<div class=" mainprint  pagecontent" style="display:block">
		
		 <div class="table-responsive" id="printarea"  >
		 
		
						<table class=" table-bordered " id="table">
							<thead style="background: #85C1E9 none repeat scroll 0 0;">
							<tr style="color: red; font-weight: bold; background: #ffffff"><td></td><td>  Court Type</td><td><c:out value="${court}"></c:out></td><td></td><td></td><td> Category:</td><td><c:out value="${category}"></c:out></td> </tr>
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1">Unit Name </th>
									
									
									
									<th rowspan="1" >Cases Filed</th>
									<th rowspan="1" >Draft Counter to GP</th>
									<th rowspan="1" >Counter Filed by GP</th>
									<th rowspan="1" >Counter To be Filed </th>
									<th rowspan="1" >Judgement Given </th>
									
									
								</tr>

								
							
								

							</thead>

							
							<tbody>
								<c:forEach var="c" items="${counterDataCourt}" varStatus="count">
									
										<tr>
											
											<td style="text-align: center;"><c:out
													value="${count.count}"></c:out></td>
											<td><c:out value="${c.unitName}"></c:out> </td>
											
											
											
											<td><a target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &courtId=<c:out value="${c.courtId}"></c:out>  &filingDate=1" > <c:out value="${c.casesFiled}"></c:out>   </a></td>
											<td><a  target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &courtId=<c:out value="${c.courtId}"></c:out>  &draftdateconttoGP=2"> <c:out value="${c.draftCountFile}"></c:out></a></td>
											<td><a target="_blank"   href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>  &courtId=<c:out value="${c.courtId}"></c:out> &counterDate=3"> <c:out value="${c.counterFiled}"></c:out></a></td>
											<td><a target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>  &courtId=<c:out value="${c.courtId}"></c:out> &casesToFile=4"><c:out value="${c.casesToFile}"></c:out></a></td>
											<td><a  target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>  &courtId=<c:out value="${c.courtId}"></c:out> &judgementDate=5"><c:out value="${c.casesJudged}"></c:out></a></td>
											
											
											
											
											
							</tr>
							
									
								</c:forEach>
								
								<tr style="color: red; font-weight: bold;"><td></td><td>  Total</td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataCourt[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataCourt[0].courtId}"></c:out>&filingDate=1" ><c:out value="${courtCF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataCourt[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataCourt[0].courtId}"></c:out>&filingDate=2" ><c:out value="${courtDF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;"  href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataCourt[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataCourt[0].courtId}"></c:out>&filingDate=3" ><c:out value="${courtCountF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataCourt[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataCourt[0].courtId}"></c:out>&filingDate=4" ><c:out value="${courtCountNF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataCourt[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataCourt[0].courtId}"></c:out>&filingDate=5" ><c:out value="${courtJF}"></c:out></a></td> </tr>
								</tbody>
							

						</table>
						
				
					</div>
				
		</div>
		<!-- </div> -->
		</c:if>
		
		
		<c:if test="${counterDataGen!=null }">
		
		
		<!-- <div class='container'> -->
		<div class=" mainprint  pagecontent" >
		
		 <div class="table-responsive" id="printarea"  >
		 
		
						<table class=" table-bordered " id="table">
							<thead style="background: #85C1E9 none repeat scroll 0 0;">
							<tr style="color: red; font-weight: bold;background: #ffffff;"><td></td><td>  Court Type</td><td><c:out value="${court}"></c:out></td><td></td><td></td><td> Category:</td><td><c:out value="${category}"></c:out></td> </tr>
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1">Unit Name </th>
									
									
									
									<th rowspan="1" >Cases Filed</th>
									<th rowspan="1" >Draft Counter to GP</th>
									<th rowspan="1" >Counter Filed by GP</th>
									<th rowspan="1" >Counter To be Filed </th>
									<th rowspan="1" >Judgement Given </th>
									
									
								</tr>

								
							
								

							</thead>

							
							<tbody>
								<c:forEach var="c" items="${counterDataGen}" varStatus="count">
									
										<tr>
											
											<td style="text-align: center;"><c:out
													value="${count.count}"></c:out></td>
											<td><c:out value="${c.unitName}"></c:out> </td>
											
											
											
											<td><a target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &caseGenId=<c:out value="${c.caseGenId}"></c:out>  &filingDate=1" > <c:out value="${c.casesFiled}"></c:out>   </a></td>
											<td><a  target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &caseGenId=<c:out value="${c.caseGenId}"></c:out>  &draftdateconttoGP=2"> <c:out value="${c.draftCountFile}"></c:out></a></td>
											<td><a target="_blank"   href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &caseGenId=<c:out value="${c.caseGenId}"></c:out>  &counterDate=3"> <c:out value="${c.counterFiled}"></c:out></a></td>
											<td><a target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>  &caseGenId=<c:out value="${c.caseGenId}"></c:out> &casesToFile=4"><c:out value="${c.casesToFile}"></c:out></a></td>
											<td><a  target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &caseGenId=<c:out value="${c.caseGenId}"></c:out>  &judgementDate=5"><c:out value="${c.casesJudged}"></c:out></a></td>
											
											
											
											
											
							</tr>
									
								</c:forEach>
								<tr style="color: red; font-weight: bold;"><td></td><td>  Total</td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataGen[0].courtId}"></c:out>&filingDate=1" ><c:out value="${GenCF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataGen[0].courtId}"></c:out>&filingDate=2" ><c:out value="${GenDF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataGen[0].courtId}"></c:out>&filingDate=3" ><c:out value="${GenCountF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataGen[0].courtId}"></c:out>&filingDate=4" ><c:out value="${GenCountNF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataGen[0].courtId}"></c:out>&filingDate=5" ><c:out value="${GenJF}"></c:out></a></td> </tr>
								</tbody>
							

						</table>
						
			
					</div>
				
		</div>
		<!-- </div> -->
		</c:if>
		
		<c:if test="${counterDataCourtGen!=null }">
		
		
		<!-- <div class='container'> -->
		<div class=" mainprint  pagecontent" style="display:block">
		
		 <div class="table-responsive" id="printarea"  >
		 
		
						<table class=" table-bordered " id="table">
							<thead style="background: #85C1E9 none repeat scroll 0 0;">
							<tr style="color: red; font-weight: bold; background: #ffffff; " ><td></td><td>  Court Type</td><td><c:out value="${court}"></c:out></td><td></td><td></td><td> Category:</td><td><c:out value="${category}"></c:out></td> </tr>
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1">Unit Name </th>
									
									
									
									<th rowspan="1" >Cases Filed</th>
									<th rowspan="1" >Draft Counter to GP</th>
									<th rowspan="1" >Counter Filed by GP</th>
									<th rowspan="1" >Counter To be Filed </th>
									<th rowspan="1" >Judgement Given </th>
									
									
								</tr>

								
							
								

							</thead>

							
							<tbody>
								<c:forEach var="c" items="${counterDataCourtGen}" varStatus="count">
									
										<tr>
											
											<td style="text-align: center;"><c:out
													value="${count.count}"></c:out></td>
											<td><c:out value="${c.unitName}"></c:out> </td>
											
											
											
											<td><a target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &courtId=<c:out value="${c.courtId}"></c:out>  &caseGenId=<c:out value="${c.caseGenId}"></c:out> &filingDate=1" > <c:out value="${c.casesFiled}"></c:out>   </a></td>
											<td><a  target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &courtId=<c:out value="${c.courtId}"></c:out>  &caseGenId=<c:out value="${c.caseGenId}"></c:out> &draftdateconttoGP=2"> <c:out value="${c.draftCountFile}"></c:out></a></td>
											<td><a target="_blank"   href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>  &courtId=<c:out value="${c.courtId}"></c:out> &caseGenId=<c:out value="${c.caseGenId}"></c:out> &counterDate=3"> <c:out value="${c.counterFiled}"></c:out></a></td>
											<td><a target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &courtId=<c:out value="${c.courtId}"></c:out>  &caseGenId=<c:out value="${c.caseGenId}"></c:out> &casesToFile=4"><c:out value="${c.casesToFile}"></c:out></a></td>
											<td><a  target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &courtId=<c:out value="${c.courtId}"></c:out> &caseGenId=<c:out value="${c.caseGenId}"></c:out> &judgementDate=5"><c:out value="${c.casesJudged}"></c:out></a></td>
											
											
											
											
											
							</tr>
									
								</c:forEach>
								<tr style="color: red; font-weight: bold;"><td></td><td>  Total</td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataCourtGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataCourtGen[0].courtId}"></c:out>&filingDate=1" ><c:out value="${courtGenCF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataCourtGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataCourtGen[0].courtId}"></c:out>&filingDate=2" ><c:out value="${courtGenDF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataCourtGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataCourtGen[0].courtId}"></c:out>&filingDate=3" ><c:out value="${courtGenCountF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataCourtGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataCourtGen[0].courtId}"></c:out>&filingDate=4" ><c:out value="${courtGenCountNF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataCourtGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataCourtGen[0].courtId}"></c:out>&filingDate=5" ><c:out value="${courtGenJF}"></c:out></a></td> </tr>
								</tbody>
							

						</table>
						
				
					</div>
				
		</div>
		<!-- </div> -->
		</c:if>
		
		<c:if test="${counterDataAllGen!=null }">
		
		
		<!-- <div class='container'> -->
		<div class=" mainprint  pagecontent" style="display:block">
		
		 <div class="table-responsive" id="printarea"  >
		 
		
						<table class=" table-bordered " id="table">
							<thead style="background: #85C1E9 none repeat scroll 0 0;">
							<tr style="color: red; font-weight: bold; background: #ffffff;"><td></td><td>  Court Type</td><td><c:out value="${court}"></c:out></td><td></td><td></td><td> Category:</td><td><c:out value="${category}"></c:out></td> </tr>
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1">Unit Name </th>
									
									
									
									<th rowspan="1" >Cases Filed</th>
									<th rowspan="1" >Draft Counter to GP</th>
									<th rowspan="1" >Counter Filed by GP</th>
									<th rowspan="1" >Counter To be Filed </th>
									<th rowspan="1" >Judgement Given </th>
									
									
								</tr>

								
							
								

							</thead>

							
							<tbody>
								<c:forEach var="c" items="${counterDataAllGen}" varStatus="count">
									
										<tr>
											
											<td style="text-align: center;"><c:out
													value="${count.count}"></c:out></td>
											<td><c:out value="${c.unitName}"></c:out> </td>
											
											
											
											<td><a target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>  &caseGenId=<c:out value="${c.caseGenId}"></c:out> &filingDate=1" > <c:out value="${c.casesFiled}"></c:out>   </a></td>
											<td><a  target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>  &caseGenId=<c:out value="${c.caseGenId}"></c:out>  &draftdateconttoGP=2"> <c:out value="${c.draftCountFile}"></c:out></a></td>
											<td><a target="_blank"   href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>  &caseGenId=<c:out value="${c.caseGenId}"></c:out> &counterDate=3"> <c:out value="${c.counterFiled}"></c:out></a></td>
											<td><a target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out> &caseGenId=<c:out value="${c.caseGenId}"></c:out> &casesToFile=4"><c:out value="${c.casesToFile}"></c:out></a></td>
											<td><a  target="_blank"  href="../webReports/caseDetails?unitId=<c:out value="${c.unitId}"></c:out>  &caseGenId=<c:out value="${c.caseGenId}"></c:out> &judgementDate=5"><c:out value="${c.casesJudged}"></c:out></a></td>
											
											
											
											
											
							</tr>
									
								</c:forEach>
								<tr style="color: red; font-weight: bold;"><td></td><td>  Total</td><td  ><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataAllGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataAllGen[0].courtId}"></c:out>&filingDate=1" ><c:out value="${AllGenCF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataAllGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataAllGen[0].courtId}"></c:out>&filingDate=2" ><c:out value="${AllGenDF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataAllGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataAllGen[0].courtId}"></c:out>&filingDate=3" ><c:out value="${AllGenCountF}"></c:out></a></td><td><a target="_blank" style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataAllGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataAllGen[0].courtId}"></c:out>&filingDate=4" ><c:out value="${AllGenCountNF}"></c:out></a></td><td><a target="_blank"  style="color: red; font-weight: bold;" href="../webReports/viewCaseTotalDetails?caseGenId=<c:out value="${counterDataAllGen[0].caseGenId}"></c:out>&courtId=<c:out value="${counterDataAllGen[0].courtId}"></c:out>&filingDate=5" ><c:out value="${AllGenJF}"></c:out></a></td> </tr>
								</tbody>
							

						</table>
						
				
					</div>
				
		</div>
		<!-- </div> -->
		</c:if>
		
		<div class="row show-grid">
					<div class="clearfix"> </div>
					<div class="clearfix"> </div>
					<div class="col-md-4">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table', 'countertable')" >
					</div>
					
					<div class="col-md-4">
					 <input type="button" value="Print Preview" class="btn btn-1 btn-primary center-block" onclick="PrintPreview('printarea')"/>
					 </div>
					<div class="col-md-4">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Print"  onclick="printDiv('printarea')" >
					</div>
					
					
					</div>
		
	</div>
	
	<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
 
 
 <script type="text/javascript">
var tableToExcel = (function() {
  var uri = 'data:application/vnd.ms-excel;base64,'
    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office"<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
    , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
  return function(table, name) {
    if (!table.nodeType) table = document.getElementById(table);
    var ctx = {worksheet:  'Worksheet', table: table.innerHTML};
    window.location.href = uri + base64(format(template, ctx));
  }
})()
</script>

<script>
$(document).ready(function(){

	
	 


	 
	  
			
});






function printDiv(divName) {
    var toPrint = document.getElementById(divName);
    var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');
    popupWin.document.open();
    popupWin.document.write('<html><title>::Preview::</title><link rel="stylesheet" type="text/css" href="print.css" /></head><body onload="window.print()">')
    popupWin.document.write(toPrint.innerHTML);
    popupWin.document.write('</html>');
    popupWin.document.close();
}
/*--This JavaScript method for Print Preview command--*/
function PrintPreview(divName) {
    var toPrint = document.getElementById(divName);
    var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');
    popupWin.document.open();
    popupWin.document.write('<html><title>::Print Preview::</title><link rel="stylesheet" type="text/css" href="Print.css" media="screen"/></head><body">')
    popupWin.document.write(toPrint.innerHTML);
    popupWin.document.write('</html>');
    popupWin.document.close();
}
</script>
	 
	 
	 <script type="text/javascript" src="../js/parsley.js"></script>

    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#casesReport').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.casesReport.action="../webReports/abstractCounterFiles";
				 document.forms.casesReport.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script>
	 
	 

<!-- //main-content -->
