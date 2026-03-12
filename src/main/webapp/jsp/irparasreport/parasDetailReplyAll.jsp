
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />
	
<!--   <script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">  -->


<link rel="stylesheet" href="../css/treeview/jquery.treeview.css" />
<style>

td, th {

    
    vertical-align: top;

}</style>
<!--   <link rel="stylesheet" href="../red-treeview.css" />  -->

<!--  <script src="../js/treeview/lib/jquery.js" type="text/javascript"></script> -->
 <script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script>

<!-- <link rel="stylesheet" type="text/css" href="../css/Html5DataTable/datatables.min.css"/>
<script type="text/javascript" src="../js/Html5DataTable/datatables.min.js"></script> -->





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

	
	
	

	MergeCommonRows($("#table"), 1);
	MergeCommonRows($("#table"), 2);
	
	
	
	
	
	
	
	 


	 
	  
			
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




$(function() {
	
	$("input[name='taskTypeId']").change(function(){
        var radioValue = $("input[name='taskTypeId']:checked").val();
        if(radioValue){
          //  alert("Your are a  " + radioValue);
        	$("#hiddentaskTypeId").val(radioValue);
        /* 	var page_url = $(".myunit").prop("href"); 
        	alert("page_url"+page_url);
        	$(".myunit").prop("href", page_url+'&taskTypeId='+$("#hiddentaskTypeId").val()); */
        	
        	
            
        }
    });
	
	/* var b = $("#taskTypeId").val();
	
	$("#hiddentaskTypeId").val(b); */
	
	/* $(".mycircle").click(function() {
		 var $this = $(this);      
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		  
		}); */
	
	
	/* $(".myunit").click(function() {
		 var $this = $(this);      
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		  
		}); */
	
	
	
	/* $(".mydivision").click(function() {
		 var $this = $(this);   
		 
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		   
		});
	 */
	/* $(".mysubdivision").click(function() {
		
		
		event.preventDefault();
		
		 var $this = $(this);  
		 
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	      
	      window.location.replace(page_url+'&taskTypeId='+m);
	   
		 //  $this.prop("href", page_url+'&taskTypeId='+m);
		   
		  
		});
	 */
	
	
	
	
});
</script>

<script type="text/javascript">


       
    </script>




	
<div class="col-md-9">
	


<div>



		





		<div class="panel panel-primary" >
			<div class="panel-heading">
				<h3 class="panel-title">Paras Gist
				<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						 <c:if test="${userObj.employeeName!=null &&  userObj.employeeName!='NA'  }">	
						   
			Er. <c:out value="${userObj.employeeName }"></c:out>	
			 
			 </c:if>
			 
			 <c:if test="${userObj.designationName!=null  && userObj.designationName!='NA' }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>	
			 
			 </c:if>
			 </div>
			 <br></br>
			 <div class="span6 pull-right">
			
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
					 <c:if test="${userObj.userName!='icad_test' && userObj.userName!='cs_telangana' }">	 <c:out value="${userObj.unitName}"></c:out></c:if>
			   <c:if test="${userObj.userName=='icad_test'  }">	 AG AUDIT</c:if>
			    <c:if test="${userObj.userName=='cs_telangana'  }"> CS Telangana</c:if>	
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



	<form:form id="casesReport" method="post" modelAttribute="taskreport2">

		<input name=urlvalue type=hidden>
		<input name=unitId id="unitId" type=hidden>
		<input name=circleId id="circleId" type=hidden>
		<input name=divisionId id="divisionId" type=hidden>
		<input name=subdivisionId id="subdivisionId" type=hidden>
		
	<!-- start of admin and irrigation -->	
  
						   <c:if test="${(userObj.unitId==4 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0)||
													 (userObj.unitId==9832 && userObj.circleId==21614 && userObj.divisionId==0 && userObj.subdivisionId==0)||
													 (userObj.unitId==4 && userObj.circleId==104 && userObj.divisionId==30327 && userObj.subdivisionId==0) }">
			
	<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>
<div id="accordion1" class="treeDiv">
<ul id="tree">

<c:forEach items="${unitList}" var="u">
								
								
	<li><a class="myunit"  href="../parasreport/parasDetailReply?unitId=<c:out value="${u.unitId}"></c:out>" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	<ul>
	<c:forEach items="${circleList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	
		<li><a class="mycircle" href="../parasreport/parasDetailReply?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>" ><c:out value="${c.circleName}"></c:out></a>
		
			<ul>
			
			<c:forEach items="${divisionList}" var="d">
			<c:if test="${c.circleId==d.circleId}">
		
			<li><a class="mydivision" href="../parasreport/parasDetailReply?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>" ><c:out value="${d.divisionName}"></c:out></a>

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
</div>
		
		
		</c:if>
		
	<!-- end of admin and irrigation -->
	
	
	<!-- start of unit -->	
  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 && userObj.unitId!=4 && userObj.unitId!=9832 }">	
			<div class="w3_agile_main_left">
	<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">

<c:forEach items="${unitList}" var="u">
	<c:if test="${userObj.unitId==u.unitId  && userObj.divisionId==0 && userObj.circleId==0 }">									
							
	<li><a class="myunit"  href="../parasreport/parasDetailReply?unitId=<c:out value="${u.unitId}"></c:out>" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	<ul>
	<c:forEach items="${circleList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	
		<li><a class="mycircle" href="../parasreport/parasDetailReply?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>" ><c:out value="${c.circleName}"></c:out></a>
		
			<ul>
			
			<c:forEach items="${divisionList}" var="d">
			<c:if test="${c.circleId==d.circleId}">
		
			<li><a class="mydivision" href="../parasreport/parasDetailReply?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>" ><c:out value="${d.divisionName}"></c:out></a>

			</li>
			</c:if>
			
			</c:forEach>
			</ul>
		</li>
	
	</c:if>
		</c:forEach>
	
	</ul>
	
	</li>
	
	</c:if>
	
	</c:forEach>  
	
	</ul>	
</div>
		</div>
		
		</c:if>
		</c:if>
	<!-- end of unit -->
	
	<!-- start of circle -->	
  <c:if test="${userObj.unitId!=0 && userObj.circleId >0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 && userObj.unitId!=4 && userObj.unitId!=9832  }">	
			<div class="w3_agile_main_left">
	<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">

<c:forEach items="${unitList}" var="u">
	<c:if test="${userObj.unitId==u.unitId && userObj.circleId>0  && userObj.divisionId==0  }">									
							


	<c:forEach items="${circleList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	
	<c:if test="${userObj.circleId==c.circleId  && userObj.divisionId==0 }">	
		<li><a class="mycircle" href="../parasreport/parasDetailReply?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>" ><strong><c:out value="${c.circleName}"></c:out></strong></a>
		
			<ul>
			
			<c:forEach items="${divisionList}" var="d">
			<c:if test="${c.circleId==d.circleId}">
		
			<li><a class="mydivision" href="../parasreport/parasDetailReply?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>" ><c:out value="${d.divisionName}"></c:out></a>

			</li>
			</c:if>
			
			</c:forEach>
			</ul>
		</li>
	</c:if>
	</c:if>
		</c:forEach>
	
	
	
	
	
	</c:if>
	
	</c:forEach>  
	
	</ul>	
</div>
		</div>
		
		</c:if>
		</c:if>
	<!-- end of circle -->
	
	
	<!-- start of division -->	
  <c:if test="${userObj.unitId!=0 && userObj.circleId >0 && userObj.divisionId >0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 && userObj.unitId!=4 && userObj.unitId!=9832  }">	
			<div class="w3_agile_main_left">
	<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">

<c:forEach items="${unitList}" var="u">
	<c:if test="${userObj.unitId==u.unitId && userObj.circleId>0  && userObj.divisionId >0  }">									
							


	<c:forEach items="${circleList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	
	<c:if test="${userObj.circleId==c.circleId  && userObj.divisionId >0 }">	
		
			
			<c:forEach items="${divisionList}" var="d">
			<c:if test="${c.circleId==d.circleId}">
			
			<c:if test="${userObj.divisionId==d.divisionId}">	
		
			<li><a class="mydivision" href="../parasreport/parasDetailReply?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>" ><strong><c:out value="${d.divisionName}"></c:out></strong></a>

			</li>
			
			</c:if>
			</c:if>
			
			</c:forEach>
		
	</c:if>
	</c:if>
		</c:forEach>
	
	
	
	
	
	</c:if>
	
	</c:forEach>  
	
	</ul>	
</div>
		</div>
		
		</c:if>
		</c:if>
	<!-- end of division-->
		
		
		
		</form:form>
		

		
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<div class="  show-grid ">
<div class="alert alert-info" role="alert">

               	  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
              <strong style="color:#CA3F22"> Note: Please click on Expand all or (+) to see respective Offices.</strong><br>
               	</c:if>
               	</c:if>
               	
               	<c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 && userObj.circleId>0  }">	
               <strong style="color:#CA3F22"> Note: Please click on Expand all or (+) to see respective Offices.</strong><br>
               	</c:if>
               	</c:if>
               
				
				<strong style="color:#CA3F22"> Note: Please click on office Name to see respective data.</strong>
				

			</div>
			</div>


 <div align="center">
		
		<h1><a target="_blank" href="../parasreport/downloadPDF?unitId=${paraListTotal[0].unitId} &circleId=${paraListTotal[0].circleId} &divisionId=${paraListTotal[0].divisionId}">Download PDF Document</a></h1>
	</div>

	



						<div class="show-grid gridList" id="printarea">

						<div class="table-responsive" id="customers">	
						<table class=" display table-bordered  table1 " id="table" >
		
								<thead>
									
									<tr>
										<th  style="text-align: center;">Sl.No</th>
										<th   style="text-align: center;">Name of Office</th>
										<th  style="text-align: center;">Financial Year</th>
										<th   style="text-align: center;" >LAR Number<br></br> 										
										
										<th  style="text-align: center;">File Number</th>	
										
										<th  style="text-align: center;">Transferred From</th>	
										<th  colspan="2" style="text-align: center;" >Para Number</th>	
															
										
										<th  style="text-align: center;">Gist Of The Para <br> </br>Para </th>
										
										<th  style="text-align: center;">Reply</th>
										<th    style="text-align: center;">Documents</th>
																
										
										
										
										
										


									</tr>
									
									  <tr>
									
									<th></th>
									<th></th>
									<th></th>
									<th></th>
									<th></th>	
									<th></th>			
								
									<th  >SectionA</th>
										<th  >SectionB</th>	
										
										<th></th>
									<th></th>
									<th></th>	
										
										
									
									
									</tr>
									 

									

								</thead>


								<tbody>
									
										<c:forEach items="${paraListTotal}" var="t" varStatus="count">
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
												
												<c:if test="${t.unitId>0 && t.circleId==0 && t.divisionId==0  }">
												<td><b><c:out value="${t.unitName}"></c:out></b></td>
												
												</c:if>
												<c:if test="${t.unitId>0 && t.circleId>0 && t.divisionId==0  }">
												<td><b><c:out value="${t.circleName}"></c:out></b></td>
												
												</c:if>
												<c:if test="${t.unitId>0 && t.circleId>0 && t.divisionId>0  }">
												<td><b><c:out value="${t.divisionName}"></c:out></b></td>
												
												</c:if>
												
												
												 <td><c:out value="${t.financialYear}"></c:out></td>
												 <td><c:out value="${t.larNumber}"></c:out></td>
												<td><c:out value="${t.fileNumber}"></c:out></td>
											<c:choose>
											<c:when test="${t.oldParaId>0}">
											<td style="color:red">unit : <c:out value="${t.trfromUnit}"></c:out> <br> circle : <c:out value="${t.trfromCircle}"></c:out> <br> Division : <c:out value="${t.trfromDivision}"></c:out></td>
											
											</c:when>
											
											<c:otherwise>
											<td>--</td>
											
											</c:otherwise>
											</c:choose>
												<td><c:out value="${t.paraNumsectionA}"></c:out></td>
																						
												
											
												
												
											
												
												
												<td><c:out value="${t.paraNumsectionB}"></c:out></td>
																							
												
												
												
											
												
												<td ><b><c:out value="${t.actionTitle}"></c:out></b>
												
												<br>
                                              
											
												<c:out value="${t.parasAction}"  escapeXml="false" ></c:out></td>
												
												
												
												  <td><table>
												<c:if test="${replyListTotal!=null}">
												<c:forEach items="${replyListTotal}" var="m" varStatus="mcount">
												<c:choose>
												<c:when test="${t.paraId==m.paraId }">
												<tr>
												
												<td ><c:out value="${m.replyAction}" escapeXml="false" ></c:out></td>
												
												</tr>
												
												</c:when>
												<c:otherwise><tr><td></td></tr></c:otherwise>
												</c:choose>
												</c:forEach> 
												</c:if>
												
												
												</table></td>
												 
												
											<%-- 	
												<c:forEach items="${replyListTotal}" var="m" varStatus="mcount">
												
												<c:if test="${t.paraId==m.paraId }">
												
												<td ><c:out value="${m.replyAction}" escapeXml="false" ></c:out></td>
												
												</c:if>
												</c:forEach> 
											 --%>
											 
											
											
											 <c:if test="${paradocsList!=null}">
											  <c:set var="c" value="1" scope="page" />
											 
											
											 <td  >
											 <table>
											
										
											
												<c:forEach items="${paradocsList}" var="n" varStatus="ncount">
												
											
												
												<c:choose>
												<c:when test="${t.paraId==n.paraId }">
												
												
												<tr >
												
												<td  style="color: green; font-weight: bold;">
											<c:out 	value="${c}"></c:out>) <br></br>
											
											
											
											</td >
												<td style="color: green; font-weight: bold;"><a target="_blank" href="${pageContext.request.contextPath}/parasreport/viewIRParas?fileName=${n.paraDocName}" ><c:out value="${n.paraDocOriginalName}"></c:out></a>
												
												</td>
												<c:set var="c" value="${c + 1}" scope="page"/>
												
												</tr>
												
												
												
												
												</c:when>
												<c:otherwise> <tr> <td></td></tr> </c:otherwise>
												</c:choose>
												</c:forEach>
											
												</table> 
												</td>
												</c:if> 
												
												
												
												
											<%-- <td> <c:if test="${paradocsList!=null}">
											 <c:set var="c" value="1" scope="page" />
											 <c:forEach items="${paradocsList}" var="n" varStatus="ncount">
											 
											main <c:out value="${t.paraId}"></c:out> <br>
											 doc <c:out value="${n.paraId}"></c:out>
											 <br>
											 	<c:if test="${t.paraId==n.paraId }">
											 	<c:out 	value="${c}"></c:out> &emsp;&emsp;
											 	<a target="_blank" href="../uploadedFiles/IRParas/<c:out value="${n.paraDocName}"></c:out>" ><c:out value="${n.paraDocOriginalName}"></c:out></a>
											 	<br>
											 	</c:if>
											 	<c:set var="c" value="${c + 1}" scope="page"/>
											 	
											 </c:forEach>
											</c:if>
											
											<c:if test="${paradocsList[0].paraDocName==null}">
											otherwise
											</c:if></td>	 --%>
										</tr>
										
										
										
									
										</c:forEach>
									


								
									
									
								</tbody>


							</table>
							
							</div>
							
							

	
       	
    
								
								
							


						
					</div><%-- 	</c:if> --%>
					


				</div>
			
		</div>






</div>
</div>
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
	<!-- <script src="../js/Html5DataTable/buttons.colVis.min.js" type="text/javascript"></script> -->
	 <script src="../js/Html5DataTable/buttons.html5.new.js" type="text/javascript"></script> 
	
	
	
	<script type="text/javascript">			
							
    $('.table1').DataTable( {
    	retrieve: true,
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "autoWidth": true,
        "lengthChange": true,
        "pageLength": 10,
        columnDefs: [
                     { targets: [9], type: 'html' },
                   ],
        buttons: [
            'copyHtml5',
            {
                extend: 'excelHtml5',
                autoFilter: true,
                sheetName: 'Exported Paras data',
                text:  'Save To Excel',
                className: 'btn btn-1 btn-primary ',
                messageTop: 'IR Paras AG Paras Report',
                customize: function ( xlsx ){
                    var sheet = xlsx.xl.worksheets['sheet1.xml'];
     
                    // jQuery selector to add a border
                    $('row c[r*="10"]', sheet).attr( 's', '25' );
                    
                   
                   
                   
                    
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
   
    



  <!--  <script type="text/javascript" class="example">
$(function () {
	 $('#getParaCount').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.getParaCount.action="../parasreport/parastatus";
				 document.forms.getParaCount.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script> -->
	  


<!-- //main-content -->
