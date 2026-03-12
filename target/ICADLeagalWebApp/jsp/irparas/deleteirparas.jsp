	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 

<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
 
 
 <link rel="stylesheet" href="../css/treeview/jquery.treeview.css" />
<!-- <link rel="stylesheet" href="../red-treeview.css" /> -->

<!-- <script src="../js/treeview/lib/jquery.js" type="text/javascript"></script> -->
<script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
 <script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>
 

 
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
	
	<script type="text/javascript">

function clicked(){
	for ( instance in CKEDITOR.instances ){
		
		CKEDITOR.instances[instance].getData();
	//alert("ckeditor values : " + CKEDITOR.instances[instance].getData());
	}
	}
	
	</script>

<script>



$(document).ready(function(){

	
	


	 
	  
			
});


$(function() {
	
	
var emp= $("#userObjUserName").val();

//alert(""+emp);

if((emp=="CAO-UNIT") ){
	
	//alert("kal");
	
	$(".deleteid").hide()
	
	
}else if (emp=="ENC-IRRIGATION"){
	
	//alert("kal2");
	
	$(".deleteid").hide()
	
	}
else{
	
	//alert("kal3");
	
	$(".deleteid").show()
	
	
}

/* if((emp!="CAO-UNIT") || (emp!="ENC-IRRIGATION")){
	
	
	
	
} */

});




/* function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    //var originalContents = document.body.innerHTML;

   // document.body.innerHTML = printContents;
    document.body.innerHTML = '<link href="./I and CAD  Court Cases Monitoring System_files/bootstrap.min.css" rel="stylesheet" type="text/css"  media="print"><link rel="stylesheet" href="./I and CAD Court Cases Monitoring System_files/custom.css" type="text/css"  media="print"><body>';
    document.body.innerHTML += printContents+'</body>';
  //  alert(document.body.innerHTML);
    //alert(printContents);
    window.print();
    window.close();
    

   // document.body.innerHTML = originalContents;
} */

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


<script >

	
	
function getcompmonayacut(componentId,unitId)
{
	//alert("kalcoming"+componentId+"---"+unitId);
	
	document.forms[0].urlvalue.value="../comptsimis/delCompMonAyacut";
	
	   $("#componentId").val(componentId);
	   $("#unitId").val(unitId);
	 
		 document.forms[0].submit(); 
	
	
	
	}

function getData(unitId){
	
	
	 $("#deleteFlag").val(false);
	  $("#unitId").val(unitId);
	 
	 document.forms[0].urlvalue.value="../parastsimis/deleteirparas";
		
	
	 
	
		 document.forms[0].submit(); 
	
	
}

function getCircleData(unitId,circleId){
	
	////alert("kal")
	//alert(unitId);
	//alert(circleId);
	 $("#deleteFlag").val(false);
	  $("#unitId").val(unitId);
	  $("#circleId").val(circleId);
	 
	 document.forms[0].urlvalue.value="../parastsimis/deleteirparas";
		
	
	 
	
		 document.forms[0].submit(); 
	
	
}

function getDivisionData(unitId,circleId,divisionId){
	
	//alert("kal2")
	 $("#deleteFlag").val(false);
	  $("#unitId").val(unitId);
	  $("#circleId").val(circleId);
	  $("#divisionId").val(divisionId);
	 
	 document.forms[0].urlvalue.value="../parastsimis/deleteirparas";
		
	
	 
	
		 document.forms[0].submit(); 
	
	
}
	
	
	function deleteIrParas(paraId){
		
		
		// alert("klcoming here"+compPowerId);
		 $("#deleteFlag").val(true);
		  $("#paraId").val(paraId);
		 
		 document.forms[0].urlvalue.value="../parastsimis/deleteirparas";
			
		
		 
		
			 document.forms[0].submit(); 
		
		
		
		
	}
	
	function editIrParas(paraId){
		
		
		 var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	 	  	var url="../parastsimis/editirparas?paraId="+paraId+"&editFlag="+false;
	 	  	
	 		popup =window.open(url,"_blank",features);
		
		
		
	}
	
	function getReplys(paraId){
		
		 var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	 	  	var url="../parastsimis/viewreplydocs?paraId="+paraId+"&paravalue=rp";
	 	  	
	 		popup =window.open(url,"_blank",features);
		
	}
	
	function getDocs(paraId){
		
		 var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	 	  	var url="../parastsimis/viewreplydocs?paraId="+paraId+"&paravalue=dc"
	 	  	
	 		popup =window.open(url,"_blank",features);
		
	}
	
	function addnewreply(paraId){
	
		 var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	 	  	var url="../parastsimis/addnewreply?paraId="+paraId;
	 	  	
	 		popup =window.open(url,"_blank",features);
		
		
		
	}
	
	
</script>





<div class="col-md-9">
	


<div>


						<div class="panel panel-primary ">
							<div class="panel-heading">
							<h3 class="panel-title">Edit/Delete IrParas
								
							<c:if test="${userObj!=null}">	
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
				 		
	 
<form:form id="delirparas" method="post"
				modelAttribute="deleteparas" >
				<input name=urlvalue  id="urlvalue" type=hidden >
				<input name=paravalue id="paravalue" type=hidden >
				
				
				<input name=unitId     id="unitId" type=hidden   />
				<input name=circleId     id="circleId" type=hidden   />
				<input name=divisionId     id="divisionId" type=hidden   />
	  
				
				
				<input name=editFlag  id="editFlag" type=hidden value="false" >
				
				<input name=deleteFlag  id="deleteFlag" type=hidden value="false" >
				<input name=paraId  id="paraId" type=hidden >
				
					<input name=userObjUserName  id="userObjUserName" type=hidden value="${userObj.userName}" >
					
				
				
				
				
	
				
<c:if test="${userObj.unitId!=null}">				
		
	
<div class="col-md-12 " > 	

		<c:forEach items="${unitList}" var="m">					
								
		
	<c:if test="${userObj.unitId==m.unitId  && userObj.divisionId==0 && userObj.circleId==0 }">
	
<div class="col-md-12 "> 

	<div class="col-md-2  "> 
	<a class="myunit"  href="javascript:void(0)"  style="text-decoration: none; border-bottom: 1px solid black; color: #000000;" onclick="getData(<c:out value="${m.unitId}"></c:out>)"><strong><c:out value="${m.unitName}"></c:out></strong></a>
	</div>
	
<!-- 	<div class=" col-md-4 alert alert-info">
  <strong>To Edit Click on this link.</strong>
</div> -->
</div>
		
	</c:if>
	
	</c:forEach>
	
	
	
	<c:forEach items="${circleList}" var="n">
	
	

	
		
		<c:if test="${userObj.circleId==n.circleId  && userObj.divisionId==0 }">	
		<div class="col-md-2 "> 
		<a class="mycircle" href="javascript:void(0)"  style="text-decoration: none; border-bottom: 1px solid black; color: #000000;" onclick="getCircleData(<c:out value="${n.unitId}"></c:out>,<c:out value="${n.circleId}"></c:out>)" ><c:out value="${n.circleName}"></c:out></a>
			</div>
		<!-- 	<div class=" col-md-4 alert alert-info">
  <strong>To Edit Click on this link.</strong>
</div> -->
			</c:if>
			
			
			</c:forEach>
			
		
			<c:forEach items="${divisionList}" var="p">
		
			
		
			<c:if test="${userObj.divisionId==p.divisionId}">	
			<div class="col-md-2 "> 
			<a class="mydivision" href="javascript:void(0)"  style="text-decoration: none; border-bottom: 1px solid black; color: #000000;" onclick="getDivisionData(<c:out value="${userObj.unitId}"></c:out>,<c:out value="${p.circleId}"></c:out>,<c:out value="${p.divisionId}"></c:out>)" ><c:out value="${p.divisionName}"></c:out></a>
			</div>
		<!-- 	<div class=" col-md-4 alert alert-info">
  <strong>To Edit Click on this link.</strong>
</div> -->
			</c:if>			
			
			
			
			
			</c:forEach>
		
	</div>	
	
	</c:if>
		
	 
	<div class="col-md-12 "> 
		
	
		
	 <c:if test="${userObj.unitId==null || userObj.unitId==5 }">	

 <div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">


	
	<c:forEach items="${unitList}" var="u">		
	
	 <li><a class="myunit"  href="javascript:void(0)" onclick="getData(<c:out value="${u.unitId}"></c:out>)" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	<ul>
	<c:forEach items="${circleList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	<%-- ../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out> --%>
		<li><a class="mycircle" href="javascript:void(0) "  onclick="getCircleData(<c:out value="${u.unitId}"></c:out>,<c:out value="${c.circleId}"></c:out>)"><c:out value="${c.circleName}"></c:out></a>
			<ul>
			<c:forEach items="${divisionList}" var="d">
			<c:if test="${c.circleId==d.circleId}">
			<%-- ../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out> --%>
			<li><a class="mydivision" href="javascript:void(0)"  onclick="getDivisionData(<c:out value="${c.unitId}"></c:out>,<c:out value="${d.circleId}"></c:out>,<c:out value="${d.divisionId}"></c:out>)"><c:out value="${d.divisionName}"></c:out></a>
		
			
			
			
			</li>
			</c:if>
			
			</c:forEach>
		</ul>
		
		
		</li>
		</c:if>
		</c:forEach>
		
		


	</ul>
	</li>
	 
	 
	
	
	</c:forEach>  
	
		
		
		
	</ul>
	
</div> 
</c:if>

</div>
	


			<!-- 	<div class=" col-md-12  ">

				
				<div class="col-md-12">
		<div class="col-md-10">
		</div>
		<div class="col-md-2">
				<a href="../parastsimis/deleteirparas">	<input type="button" class="btn btn-1 btn-primary center-block"
						id="getcomps" value="Back"   >
						</a>
				</div>
				</div>
				
					
					
					
		</div>		 -->
					
						
	<!-- <div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  col-md-8" style="display:block"> -->
		
		
		<c:if test="${parasList!=null}">
		
		
					
		<div class="col-md-12">	
		
		<div class="col-md-2" style="color:blue; font-weight: bold; font-size: 18px;">Unit:</div>
					<div class="col-md-2" style="color:red ;font-weight: bold;font-size: 14px;">
					
					<c:out value="${parasList[0].unitName}"></c:out>
					</div>
					<div class="col-md-2" style="color:blue; font-weight: bold;font-size: 18px;">Circle:</div>
					<div class="col-md-2" style="color:red;font-weight: bold;font-size: 14px;">
				
				<c:out value="${parasList[0].circleName}"></c:out>
				</div>
				<div class="col-md-2" style="color:blue;font-weight: bold;font-size: 18px;">Division:</div>
				<div class="col-md-2" style="color:red;font-weight: bold;font-size: 14px;">
				<c:out value="${parasList[0].divisionName}"></c:out> 
				</div>
					
			
		</div>
		
		
		
		
		<div class="col-md-12" style="font-weight: bold; " >
	
						
									
									
									<div class="col-md-1">Financial Year</div>
									
									<div class="col-md-1">File Number </div>
									<div class="col-md-1">Lar Number </div>
									<div class="col-md-1">sectionA </div>
									
									<div class="col-md-1">Section B </div>
									<div class="col-md-2">Gist of Para</div>
									<div class="col-md-1">Para Status</div>
								
									<div class="col-md-1">print in CAG</div>
									<div class="col-md-1">View /Delete</div>
									<div class="col-md-2">Edit /Delete /Add</div>
									
									
									
									
									
						</div>			
								
								
									<c:forEach items="${parasList}" var="t" varStatus="count">
									 <div class="col-md-12"  style=" border-style:solid; border-color: gray;">
								
							
									 
										<div class="row show-grid" style="color: gray; font-weight: bold;">
										
											
																				
											
											
											<div class="col-md-1"><c:out value="${t.financialYear}"></c:out></div>
												<div class="col-md-1"><c:out value="${t.fileNumber}"></c:out></div>
												<div class="col-md-1"><c:out value="${t.larNumber}"></c:out></div>
											
											
											<div class="col-md-1"><c:out value="${t.paraNumsectionA}"></c:out></div>
																						
												
											
												
												
											
												
												
												<div class="col-md-1"><c:out value="${t.paraNumsectionB}"></c:out></div>
																							
												
												
												
											
												
												<div class="col-md-2"><c:out value="${t.actionTitle}"></c:out></div>

												
											<%-- 	<td width="20%"><c:out value="${t.parasAction}"  escapeXml="false" ></c:out></td> --%>
												<div class="col-md-1"><c:out value="${t.paraStatus}"></c:out></div>
												<div class="col-md-1"><c:out value="${t.printCagStatus}"></c:out></div>
											
											
										
											
												<div class="col-md-1"><button type="button" name="viewreply" id="viewreply"  onclick="getReplys(<c:out value="${t.paraId}"></c:out>)" class=" reply btn btn-primary" >Replys</button>
												
												<button type="button" name="viewdocs" id="viewdocs" class=" docs btn btn-primary"  onclick="getDocs(<c:out value="${t.paraId}"></c:out>)" >Uploaded Docs</button></div>	
															
											<div class="col-md-1 "> 
											
										<button type="button" class="btn btn-primary " onclick='editIrParas(<c:out value="${t.paraId}"></c:out>)'  >Edit</button>
										
							      
							           <button type="button" id="add"  onclick='addnewreply(<c:out value="${t.paraId}"></c:out> )' class="btn btn-success " >Add Reply</button>
							          
							          
							            <button type="button"  class="btn btn-danger deleteid " onclick='deleteIrParas(<c:out value="${t.paraId}"></c:out> )' >Delete</button> 
							           </div>
															
										
									</div>	
									
									
									
	
	
	
	




				
									
									
									
									
									
									
						
									</div>
									
									
									
											
											
											
										    
											
											
						
							</c:forEach>
							
									
								
								
							
					</c:if>
				
	



	

	
		
</form:form>
	</div> 	
</div>
</div>
</div>

<!-- //main-content -->








	




		
		
	
	 
	
	 
	 
	 <script type="text/javascript" src="../js/parsley.js"></script>

    
    
 <!--    <script type="text/javascript" class="example">
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
	  -->
	 

<!-- //main-content -->
