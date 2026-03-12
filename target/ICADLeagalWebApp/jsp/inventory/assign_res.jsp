	<div id="assignres-dialogue">
		
		<div class="alert alert-primary" role="alert">
  Note: First Add Reservoir.It will appear in the Select Reservoir  and then Assign Reservoir to Jurisdiction.
</div>
		<form:form id="assinresid" method="post" modelAttribute="res"  name="assinresform"
			data-parsley-validate-if-empty="" enctype="multipart/form-data">
			




				<!-- 	<div > -->


				<div class="col-md-6">


					<br></br>


					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Unit <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="unitId" name="unitId"
							onchange="getProjects(this.value,1);getCircles(this.value,1);getresunitlistmapData(this.value)" required>
							<option value=" ">--select--</option>

							<c:forEach items="${unitList}" var="u">
								<option value="${u.unitId}">${u.unitName}</option>

							</c:forEach>



						</select>
					</div>




					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Circle</label>
					</div>
					<div class="col-md-6">
					<input
						type="hidden" class="form-control" id="hiddencircleId"
						 placeholder=""  />
					
						<select class="form-control" id="circleId" name="circleId"
							onchange="getDivisions(this.value,1)">
							<option value="0">--select--</option>



						</select>

					</div>




					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Division</label>
					</div>
					<div class="col-md-6">
					<input
						type="hidden" class="form-control" id="hiddendivisionId"
						 placeholder=""  />
						<select class="form-control" id="divisionId" name="divisionId"
							onchange="getSubDivisions(this.value,1)">
						</select>
					</div>





					<div class="col-md-6">
						<label class="label-control rowlebel ">Select SubDivision
						</label>
					</div>
					<div class="col-md-6">
					<input
						type="hidden" class="form-control" id="hiddensubdivisionId"
						 placeholder=""  />
						<select class="form-control" id="subdivisionId"
							name="subdivisionId">



						</select>

					</div>


					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Project</label>
					</div>

					<div class="col-md-6">
					<input
						type="hidden" class="form-control" id="hiddenprojectId"
						 placeholder=""  />
						<select class="form-control" id="projectId" name="projectId"
							onchange="getPackages(this.value)">
						</select>
					</div>


					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Package</label>
					</div>


					<div class="col-md-3">
					<input
						type="hidden" class="form-control" id="hiddenpackageId"
						 placeholder=""  />
						<select class="form-control" id="packageId" name="packageId">




						</select>


					</div>






					<div class="col-md-3">

						<input type="button" class="btn btn-1 btn-primary center-block"
							id="addnewpack" value="Add Package">

						<!-- onclick="addPack()" -->

					</div>


					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Reservoir</label>
					</div>

					<div class="col-md-3">
					<input
						type="hidden" class="form-control" id="hiddenreservoirId"
						 placeholder=""  />
						<select class="form-control" id="reservoirId" name="reservoirId">
						
						<option value="">select</option>
						
						<c:forEach items="${resList}" var="u">
								<option value="${u.resCode}">${u.resName}</option>

							</c:forEach>
						</select>
					</div>
					<div class="col-md-3">

						<input type="button" class="btn btn-1 btn-primary center-block"
							id="assignres" value="Add Reservoir">

						<!-- onclick="addPack()" -->

					</div>








				</div>

				<div class="col-md-6">
					<br></br>

					
					
					<div class="col-md-6">
						<label class="label-control rowlebel ">Work Inspectors(No.)
							</label>
					</div>
					<div class="col-md-6">

						<input type="text" class="form-control" id="workinspectorno"
							name="workinspectorno" placeholder="workinspectorno" required />
					</div>
					
					<div class="col-md-6">
						<label class="label-control rowlebel ">Luscurs(No.)
							</label>
					</div>
					<div class="col-md-6">

						<input type="text" class="form-control" id="luscurno"
							name="luscurno" placeholder="luscurno" required />
					</div>






					<!-- <div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Upload
							Files(Multiple)</label>
					</div>

					<div class="col-md-6">
						<input id="uploadFile" name="uploadFile" type="file"
							class="btn-info" value="Upload Documents" multiple="multiple">
					</div>
 -->







				</div>
				
				 <div class="col-md-12">
    <label class="label-control rowlebel ">Remarks*</label>
<textarea class="form-control"  id="remarks" name="remarks"  rows="5" cols="80" placeholder="Remarks"  ></textarea> 
    
   </div>

				<div class="col-sm-12">
					<div class="col-md-2 "></div>
					<div class="col-md-8 ">
						<label class="label-control rowlebel "></label>
						
						<input
						type="hidden" class="form-control" id="resunitmapid" name="resunitmapid"
						 placeholder=""  />
						
						 <button type="button" name="submtReservoir" id="submtReservoir" class="btn btn-1 btn-primary center-block" >SubmitReservoir</button>
						
					</div>
				</div>







				<!-- 	</div> -->
			
			<!-- row -->





		</form:form>
		
		
			<!-- data starts -->
	<div class="col-md-12">
	
	
    
	
	
	<div class="table-responsive ">
     <table class="table table-striped table-bordered" id="res-data">
     <thead id="reshead">
     
    
      <tr style="color: blue; ">  
      
       
        <th style="text-align: center;"><b>Circle Name</b></th>
       
        <th style="text-align: center;"><b>Division Name</b></th>
       
        <th style="text-align: center;"><b>Sub Division Name</b></th> 
        
        <th style="text-align: center;"><b>Project Name</b></th>     
         <th style="text-align: center;"><b>Package Name</b></th>     
       
       <th style="text-align: center;"><b>Reservoir Name</b></th>
       
         <th style="text-align: center;"><b>Work Inspector No.</b></th>
         
           <th style="text-align: center;"><b>Luscurs No.</b></th>
            <th style="text-align: center;"><b>Remarks</b></th>
           
             
      
   
       
      
    
      </tr>
      </thead>
      <tbody id="resdata">
   
     </tbody>
     </table>
     
    </div>
   
    </div>
    
    </div>