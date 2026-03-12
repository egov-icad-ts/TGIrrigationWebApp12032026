
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
<script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script> 
<script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script> 

 <link rel="stylesheet" href="../css/treeview/jquery.treeview.css" /> 




 







 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />
	
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
	//MergeCommonRows($("#table1"), 2);
	
	
	
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

 </script>


<script>


/* function loadForm(){
	
	
	
	

	
		
	
		  $('#casesReport').attr('action', "../webReports/abstractCounterFiles");
          $("#casesReport").submit();
         
	
	
	
	
    
} */

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
	
	 $('#getcaggist_dialogue').dialog({
		  autoOpen:false,
		  width:1200,
		  close: function() {
			  
			
				  $(this).dialog("close");
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

<script>
function gettaskunitList(unitId)
{
	
	var m =$("#hiddentaskTypeId").val();
	//alert("minscript"+m);
	
	$("#unitId").val(unitId);
$("#taskTypeId").val(m);

   var page_url="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m;
     window.location.assign(page_url);

     
     $("#myunit").attr('href',page_url);

	/*  document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#taskTypeId").val(m);
	  
	
		 document.forms[0].submit(); 
		 return false;
		  */
		
		 
		   /*   document.forms.casesReport.action="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m; */
		 /* document.forms.casesReport.submit();  */
	
	
	
	
	}
function gettaskcircleList(unitId,circleId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	}
function gettaskdivisionList(unitId,circleId,divisionId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#divisionId").val(divisionId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	
	}
function gettasksubdivisionList(unitId,circleId,divisionId,subdivisionId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#divisionId").val(divisionId);
	   $("#subdivisionId").val(subdivisionId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	}
	
	function getcagparadata(subcagGistId){
		
		 $('#getcaggist_dialogue').dialog('option', 'title', 'View CAG Para Info');
		  $('#getcaggist_dialogue').dialog('open');
		  
		  $("#viewgistinfohead").empty();
			$("#viewgistinfobody").empty();

		  
		  $.ajax({	          
		      url: "../parastsimis/getSubparaListbygistid",
		      type: "GET",
		      async: false,
		      data: {
		    	  cagGistId: subcagGistId
		      },
		     
		     
		      success: function (response) {
		    	  
		    	//  alert(response);
		    	  
		    	 $('#viewgistinfo table thead').append('<tr >'+
		    			 '<td></td>'+
		    			 '<td></td>'+
		    			 '<td></td>'+
		    			
		    			 '<td colspan="1" style="color:blue"><b>Download CAG Para</b></td>'+
		    			 '<td colspan="1" style="color:blue"><b>Download CAG Para and Reply</b></td>'+
		    			 '<td></td>'+
		    			
		    			 '<td colspan="1" style="color:blue"><b>Download ATR(PAC Recommendations)</b></td>'+
		    			 '<td colspan="1" colspan="2" style="color:blue"><b>Download All replies</b></td>'+
		    			 '</tr>'                     
                         
				  );   
   	  
		    	  $('#viewgistinfo table thead').append( 
								  '<tr >'+
								  '<td style="color:black"><b>Sl. No</b></td>'+
								  '<td style="color:black"><b>Sub Para Number</b></td>'+
								  '<td style="text-align: center;"><b>Unit Name</b></td>'+
								  '<td style="text-align: center;"><b>Para/Sub Para Title</b></td>'+
								  '<td style="text-align: center;" ><b>Para/Sub Para</b></td>'+
								  '<td style="text-align: center;" ><b>Discussed in PAC</b></td>'+
								  '<td style="text-align: center;" ><b>PAC Recommendations</b></td>'+
								  '<td style="text-align: center;" ><b>Reply status</b></td>'+
								
								 
								
								  '</tr>'                     
	                                         
						  );   
		    	  
		    
		          var obj = JSON.parse(response);
		          
		    	  $('#viewgistinfo table tbody').append( 
		    			  '<tr ><td  style="color:blue"><b>'+obj[0].paraNumber+'   </b>  </td> '+
						  '<td colspan="7" style="color:blue"><b>'+obj[0].cagGistPara+'   </b>  </td>  </tr>' 
						 
		    			  
		    	  );   

		         
		      var j=1;
		        
		          for(i in obj){	
						// alert("kal here"+i);
						  $('#viewgistinfo table tbody').append( 
								  '<tr >'+
								  '<td style="text-align: center;"><b>'+j+'</b></td>'+
								  '<td style="text-align: center;"><b>'+obj[i].subParaNumber+'</b></td>'+
								  '<td style="text-align: center;"><b>'+obj[i].unitName+'</b></td>'+
								  '<td style="text-align: center;" ><b>'+obj[i].paraTitle+'</b></td>'+
								  '<td style="text-align: center;" ><b>'+obj[i].parasAction+'</b></td></td>'+
								  '<td style="text-align: center;" ><b>'+obj[i].discussPac+'</b></td>'+
								  '<td style="text-align: center;" ><b>'+obj[i].pacincluded+'</b></td>'+
								  '<td style="text-align: center;" ><b>'+obj[i].paraStatus+'</b></td>'+
								 
								
								  '</tr>'                     
	                                         
						  );   

	          	   j++;
	          	   
					 }
		      		 
	
		                   
		      },
		      error : function(){
		    	  alert(error);
		      }
		  }); 
		
	}
	
	function getcagparadatails(parastatusId,transferFlag,cagGistId,discussspac, includedpac){
		

	
		
		//$("#absunitId").val(unitId);
		$("#abscagGistId").val(cagGistId);
		$("#absparaStatusId").val(parastatusId);
		$("#abstransferFlag").val(transferFlag);
		
		$("#absdiscussPac").val(discussspac);
		$("#abspacincluded").val(includedpac);
		
		
		var unit=$("#absunitId").val();
		
		
		var act1 = "../parasreport/cagparasDetail"
var newformId1 = "#cagstatusreport" 

$(newformId1).attr("action", act1);

$(newformId1).submit();
		//  $("#unitId").val(unitId);
		
		// document.forms[0].urlvalue.value="../parasreport/cagparasDetail";
			
		
		 
		
			// document.forms[0].submit(); 
		
		
	}
	
	function getcagparadatanew(subcagGistId){
		
		$("#abscagGistId").val(subcagGistId);
		
		
		
		var unit=$("#absunitId").val();
		
		
		var act1 = "../parasreport/getSubparaListbygistid"
var newformId1 = "#cagstatusreport" 

$(newformId1).attr("action", act1);

$(newformId1).submit();
	
	}
	
	function getcagbyunit(unitId){
		
		
		
	$("#unitId2").val(unitId)
		
		
		var act1 = "../parasreport/cagstatusbyUnit"
var newformId1 = "#unitcagreport" 

$(newformId1).attr("action", act1);

$(newformId1).submit();
		
		
		
	}
	
	function getcagmainabstract(){
		
	
		var act1 = "../parasreport/cagstatusbyUnit"
var newformId1 = "#unitcagreport" 

$(newformId1).attr("action", act1);

$(newformId1).submit();
		
		
	}
	
	
	function getcagparapdf(subcagGistId){
		
		
$("#abscagGistId").val(subcagGistId);
		
		
		
		var unit=$("#absunitId").val();
		
		
		var act1 = "../parasreport/cagPDFpara"
var newformId1 = "#cagstatusreport" 

$(newformId1).attr("action", act1);

$(newformId1).submit();
		
		
	}
	
	function getcagparadatapdf(subcagGistId){
		$("#abscagGistId").val(subcagGistId);
		
	var unit=$("#absunitId").val();
		
		
		var act1 = "../parasreport/cagPDFparareply"
var newformId1 = "#cagstatusreport" 

$(newformId1).attr("action", act1);

$(newformId1).submit();
		
	}
	
	function getcagparapacpdf(subcagGistId){
		$("#abscagGistId").val(subcagGistId);
		
	var unit=$("#absunitId").val();
		
		
		var act1 = "../parasreport/cagPDFparareply"
var newformId1 = "#cagstatusreport" 

$(newformId1).attr("action", act1);

$(newformId1).submit();
		
	}
	
function getcagparapacpdf (subcagGistId){
		
		$("#abscagGistId").val(subcagGistId);
		
		var unit=$("#absunitId").val();
			
			
			var act1 = "../parasreport/cagPACPDFparareply"
	var newformId1 = "#cagstatusreport" 

	$(newformId1).attr("action", act1);

	$(newformId1).submit();
		
		
	}
	
	
</script>


		
		


<div class="col-md-9">
	


<div>





		<div class="panel panel-primary" >
			<div class="panel-heading">
				<h3 class="panel-title">CAG Paras year wise abstract 
				<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						
			 </div>
			 <br></br>
			 <div class="span6 pull-right">
			
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
			 		 <c:if test="${userObj.userName!='icad_test' && userObj.userName!='cs_telangana'  }">	 <c:out value="${userObj.unitName}"></c:out></c:if>
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
	
	
<!-- <div class="alert alert-info" style="padding: 0px"  role="alert">
 <strong>Note : Please Use A4(landscape) Size Paper for Print. Also Selected Data Can be Exported and Printed</strong>
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
		
	<c:if test="${userObj.unitId==4 || (userObj.unitId==9832 && userObj.circleId==21614)}">	
		<form:form id="unitcagreport" method="post"  modelAttribute="irparas" >
				
				<input name=urlvalue type=hidden >
				<input name=subParaUnitId  id="unitId2" type=hidden >
				
				
				
<c:if test="${reportvar==2}">			
	<div class="col-md-12">

<button type="button" name="captank" id="backcagparaid" class="btn btn-1 btn-primary center-block "    onclick="getcagmainabstract()"  ><b>Back to abstract report</b></button>

</div>
</c:if>
				


<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<!-- <div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div> -->


 <div id="accordion2" class="treeDiv">
<ul id="tree">


<c:forEach items="${unitList}" var="d" varStatus="count">
									

								
	<li><a class="myunit"  href="#" onclick="getcagbyunit(${d.unitId})" ><strong><c:out value="${d.unitName}"></c:out></strong></a>
	<%-- <a class="myunit"  href="#" ><strong><c:out value="${d.unitName}"></c:out></strong></a> --%>
	
	
	</li>
	
	</c:forEach>  
	
		
		
		
	</ul>
	</div>

	
</div>

</form:form>


</c:if>
                    
			

	<form:form id="cagstatusreport" method="post" modelAttribute="cagparas"  target="_blank">

		<input name=urlvalue type=hidden>
		<c:choose>
		<c:when test="${userObj.unitId==9832 && userObj.circleId==21614 }">
		<input name=cunitId id="absunitId" type=hidden value="983221614">
		</c:when>
		<c:otherwise>
		<input name=cunitId id="absunitId" type=hidden value="${userObj.unitId}">
		</c:otherwise>
		</c:choose>
		<input name=circleId id="circleId" type=hidden>
		<input name=divisionId id="divisionId" type=hidden>
		<input name=subdivisionId id="subdivisionId" type=hidden>
		<input name=cagGistId id="abscagGistId" type=hidden>
		<input name=paraStatusId id="absparaStatusId" type=hidden>
		<input name=transferFlag id="abstransferFlag" type=hidden>
		<input name=discussPac id="absdiscussPac" type=hidden>
		<input name=pacincluded id="abspacincluded" type=hidden>
		

					<div
						class="show-grid gridList mainprint pagecontent" 
						style="display: block">

<%-- <c:if test="${compCapList!=null}"> --%>

					
						
						
                            <div class="table-responsive" id="printarea">
							<table class=" display table-bordered" style="width:100%" id="table">
								<thead >
								
							
									<tr style=" font-size: 18px" >
										<th >Sl.No</th>
										<th > Financial year</th>
										<th > Para number</th>
										<!-- <th > Pertains to Unit</th> -->
										<th  >Total Sub Paras</th>
										
														
										<th >Dropped Sub Paras</th>
									
										<th >Balance Sub Paras</th>
										<th >Reply not sent</th>	
										<th > CE-ENC</th>
										<th > ENC-Government</th>
										<th >Government-AG</th>
										<th >Government-ASSEMBLY</th>
										<th >Discussed in PAC</th>
										<th >PAC Recommendations</th>
										
										<th >Downloads</th>										
									
										
										
										
										


									</tr>
									

									

								</thead>


								<tbody>
									
										<c:forEach items="${paraListCount}" var="t" varStatus="count">
										<c:choose>
										<c:when test="${t.paraNumber!='NA' && t.cagGistId>0 }">
										<%-- <a target="_blank"  href="../parasreport/cagParasAbstractOffice?unitId=<c:out value="${t.unitId}"></c:out>" ></a> --%>
											<tr style=" font-size: 16px">

												<td style="text-align: center;"><strong><c:out
														value="${t.unitName}"></c:out></strong></td>
													
												<td ><b><c:out value="${t.financialYear}"></c:out></b></td>
												
												<td ><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatanew('${t.cagGistId}')"  ><b><c:out value="${t.paraNumber}"></c:out></b></button></td>
												<%-- <td ><b><c:out value="${t.paraNumber}"></c:out></b></td> --%>
											<%-- 	<td ><b><c:out value="${t.unitName}"></c:out></b></td> --%>
											 <td><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatails(0,false,'${t.cagGistId}','No','No')"  ><b><c:out value="${t.totalParas}"></c:out></b></button></td>
											  <td><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatails(3,false,'${t.cagGistId}','No','No')"  ><b><c:out value="${t.droppedCount}"></c:out></b></button></td>
											  <td><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatails(21,false,'${t.cagGistId}','No','No')"  ><b><c:out value="${t.balanceParas}"></c:out></b></button></td>
											  <td><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatails(20,false,'${t.cagGistId}','No','No')"  ><b><c:out value="${t.replyNotSent}"></c:out></b></button></td>
											  <td><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatails(7,false,'${t.cagGistId}','No','No')"  ><b><c:out value="${t.replybyce}"></c:out></b></button></td>
											  <td><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatails(8,false,'${t.cagGistId}','No','No')"  ><b><c:out value="${t.replybyenci}"></c:out></b></button></td>
											  <td><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatails(9,false,'${t.cagGistId}','No','No')"  ><b><c:out value="${t.replybysecyag}"></c:out></b></button></td>
											  <td><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatails(10false,'${t.cagGistId}','No','No')"  ><b><c:out value="${t.replybyseccont}"></c:out></b></button></td>
											  <td><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatails(11,false,'${t.cagGistId}','Yes','No')"  ><b><c:out value="${t.dicusspaccount}"></c:out></b></button></td>
											  <td><button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatails(12,false,'${t.cagGistId}','No','Yes')"  ><b><c:out value="${t.pacinclcount}"></c:out></b></button></td>
											  
											  
											  <td>
											  <br>
											  <button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparapdf('${t.cagGistId}')"  ><b>CAG Para</b></button>
											  <br>
											  <button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparadatapdf('${t.cagGistId}')"  ><b>CAG Para with Reply</b></button>
											 
                                               <c:if test="${t.pacinclcount>0}">
											  
											  <br>
											  <button type="button" name="captank" id="paranum${count.count}" class="btn btn-1 btn-primary center-block "    onclick="getcagparapacpdf('${t.cagGistId}')"  ><b>PAC recommendations with ATR</b></button>
											  
											  </c:if>
												
												
												
										</tr>
										
										</c:when>
										<c:otherwise>
										<tr style=" text-align: center; font-size: 16px ; color:green;">

												
													
												
												<td ><b><c:out value="${t.unitName}"></c:out></b></td>
												<c:if test="${t.financialYear=='finyear'}">
												<td ><b>--</b></td>
												</c:if>
												<td ><b>--</b></td>
												<%-- <td ><b><c:out value="${t.paraNumber}"></c:out></b></td> --%>
											<%-- 	<td ><b><c:out value="${t.unitName}"></c:out></b></td> --%>
											 <td><b><c:out value="${t.totalParas}"></c:out></b></td>
											  <td><b><c:out value="${t.droppedCount}"></c:out></b></td>
											  <td><b><c:out value="${t.balanceParas}"></c:out></b></td>
											   <td><b><c:out value="${t.replyNotSent}"></c:out></b></td>
											  <td><b><c:out value="${t.replybyce}"></c:out></b></td>
											  <td><b><c:out value="${t.replybyenci}"></c:out></b></td>
											  <td><b><c:out value="${t.replybysecyag}"></c:out></b></td>
											  <td><b><c:out value="${t.replybyseccont}"></c:out></b></td>
											  <td><b><c:out value="${t.dicusspaccount}"></c:out></b></td>
											  <td><b><c:out value="${t.pacinclcount}"></c:out></b></td>
											 
											  
											  <td>
											 </td>
											 

												
												
												
										</tr>
										
										</c:otherwise>
										
										</c:choose>

										</c:forEach>
									


								 	<tr style="color: red; font-weight: bold; font-size: 16px; text-align: center;">
									
									
										
										<td  >Paras</td>
										<td  >Total</td>
										<td  ></td>
										
									
									<!-- <td ></td> -->
									
										
										  <td><b><c:out value="${totalParasAll}"></c:out></b></td>
											  
											  <td><b><c:out value="${DroppedAll}"></c:out></b></td>
											  <td><b><c:out value="${Balanceall}"></c:out></b></td>
											    <td><b><c:out value="${replyNaAll}"></c:out></b></td>
											  <td><b><c:out value="${replyByCE}"></c:out></b></td>
											  <td><b><c:out value="${replyByENCI}"></c:out></b></td>
											  <td><b><c:out value="${replyBySEYAG}"></c:out></b></td>
											  <td><b><c:out value="${replyBYSEYCONT}"></c:out></b></td>
											  <td><b><c:out value="${discussPACCount}"></c:out></b></td>
											  <td><b><c:out value="${inclPACCount}"></c:out></b></td>
											<td  ></td>
										
									</tr>
									
									
									
								</tbody>
								
							

							</table>
							


    
   
    
							
							
</div>

					<%-- 	</c:if> --%>
					

					</div>
					
												
	
	</form:form>
					</div>



			
			
		</div>



<div id="getcaggist_dialogue">

<div id="viewgistinfo">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="viewgistinfoid">
											
											<thead id="viewgistinfohead">											
											</thead>
											
											<tbody id="viewgistinfobody">
											</tbody>
											
										</table>
									</div>


								</div>
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
	
	<script src="../js/Html5DataTable/buttons.colVis.min.js" type="text/javascript"></script>
	
	
	
    
   
	
	<script type="text/javascript">			
							
    $('#table').DataTable( {
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
                sheetName: 'Exported_Paras_data',
                text:  'Save To Excel',
                className: 'btn-primary ',
                messageTop: 'CAG Paras Report'
               
                
            },
            
            {
                extend: 'pdfHtml5',
                className: 'btn-primary ',
                text:  'PDF View / Download',
                orientation: 'landscape',
                pageSize: 'A4',
                download: 'open',
                font:'18',
                filename: 'CAG_Paras_Report',
                exportOptions: {
					columns: ':visible',
					search: 'applied',
					order: 'applied'
				},
				
               
                title: 'CAG Paras Report',
                customize: function (doc) {
                	doc.defaultStyle.fontfamily ='Arial';
                	
                	doc.defaultStyle.fontSize = 16;
                	doc.defaultStyle.alignment = 'center';
                	doc.styles.tableHeader.fontSize = 18;
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
                    }
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
   
   
   
  <script type="text/javascript" class="example">
$(function () {
	 $('#getParaCount').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.getParaCount.action="../parasreport/cagstatus";
				 document.forms.getParaCount.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script>
	  


<!-- //main-content -->
