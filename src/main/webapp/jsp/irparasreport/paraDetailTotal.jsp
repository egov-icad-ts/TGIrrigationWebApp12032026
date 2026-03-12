
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

	
	
	
	
	

	MergeCommonRows($("#table1"), 1);
	MergeCommonRows($("#table1"), 2);
	
	
	
	
	
	
	
	 


	 
	  
			
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

$(function() {
	
	

	
	
	
	
	
});
</script>

<script type="text/javascript">

function getaboffice(selectedunitId,selectedcircleId,selecteddivisionId,selectedsubdivisionId,selectedsectionId,selectedParaStatusId,selectedTransferFlag,formId,hkey){
	
	
	
		if(hkey==1){
				
			$('#unitId').val(selectedunitId);
			$('#circleId').val(selectedcircleId);
			$('#divisionId').val(selecteddivisionId);
			$('#subdivisionId').val(selectedsubdivisionId);
			//$('#transferFlag').val(selectedTransferFlag);
			//$('#sectionId').val(selectedsectionId);
			//$('#paraStatusId').val(selectedParaStatusId);
		//	$('#circleTotal').val(circleTotal);
		//	$('#unitTotal').val(totalflag);
				
					
				var act2="../parasreport/parastatus";
				 var newformId2="#"+formId;
				   $(newformId2).attr("action", act2);
				   $(newformId2).submit(); 
				
				
		}
		
		
	
	
}

function getadminffice(adminId,formId,hkey){
	
	
	
	if(hkey==1){
			
		$('#unitId').val(adminId);
		$('#circleId').val(0);
		$('#divisionId').val(0);
		$('#subdivisionId').val(0);
		//$('#transferFlag').val(selectedTransferFlag);
		//$('#sectionId').val(selectedsectionId);
		//$('#paraStatusId').val(selectedParaStatusId);
	//	$('#circleTotal').val(circleTotal);
	//	$('#unitTotal').val(totalflag);
			
				
			var act2="../parasreport/parastatus";
			 var newformId2="#"+formId;
			   $(newformId2).attr("action", act2);
			   $(newformId2).submit(); 
			
			
	}
	
	


}

function getabstactffice(selectedunit,selectedCircleId,selectedDivisionId,selectedsubDivisionId,selectedSectionId,selectedParaStatusId,selectedTransferFlag,selectedcircleTotal,selectedunitTotal,formId,hkey){
	
	
	
	if(hkey==2){
		$('#unitId').val(selectedunit);
		$('#circleId').val(0);
		$('#divisionId').val(0);
		$('#subdivisionId').val(selectedsubDivisionId);
		//alert("i am in kal"+unitId+circleId+divisionId+subdivisionId+formId+hkey);
		
		   var act1="../parasreport/paraAbstractOffice";
		   var newformId1="#"+formId;
		   $(newformId1).attr("action", act1);
		   $(newformId1).submit(); 
	}
	
	if(hkey==3){
		$('#unitId').val(selectedunit);
		$('#circleId').val(selectedCircleId);
		$('#divisionId').val(0);
		$('#subdivisionId').val(selectedsubDivisionId);
		//alert("i am in kal"+unitId+circleId+divisionId+subdivisionId+formId+hkey);
		
		   var act1="../parasreport/paraAbstractOffice";
		   var newformId1="#"+formId;
		   $(newformId1).attr("action", act1);
		   $(newformId1).submit(); 
	}
	
	
	
	if(hkey==4){
		$('#unitId').val(selectedunit);
		$('#circleId').val(selectedCircleId);
		$('#divisionId').val(selectedDivisionId);
		$('#subdivisionId').val(selectedsubDivisionId);
		//alert("i am in kal"+unitId+circleId+divisionId+subdivisionId+formId+hkey);
		
		   var act1="..parasreport/parastatus";
		   var newformId1="#"+formId;
		   $(newformId1).attr("action", act1);
		   $(newformId1).submit(); 
	}
	
	
}

function getparaData(paraId,tr){
	//alert("kal"+tr);
	if (tr==false){
		
		//alert("coming"+tr);
		
		  var paraReason;
$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../parasrest/parasDetailByPara?paraId="+paraId,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg) {
       // console.log(msg); 
        $('#dialog-para').empty();   
      
         $('#dialog-para').append('<div clas="col-md-12 " id ="main2">');
         
         if(msg.oldParaId>0){
        	 
         
         $('#dialog-para').append(	 '<div  clas="col-md-12 " style="background-color:none; color:Red; font-weight:bold;"> '+
                 '<div   style="text-align:left;">Transferred From Office</div>'+
                
             '</div>');   
         $("#dialog-para").append( '<div clas="col-md-12 ">'  +
        		 '<div clas="col-md-4 " style="font-weight:bold;" > Unit : '+  msg.trfromUnit +' </div> '  +
                 
                    '<div clas="col-md-4 " style="font-weight:bold;"> Circle  : '+  msg.trfromCircle +' </div>   '    +  
                      
                     
                    	     ' <div clas="col-md-4 " style="font-weight:bold;" > Division : '+  msg.trfromDivision +' </div>'    + 
                    	     
        		 
         
                      '</div>  <br/>'  );     
    
    
        
         }
         $('#dialog-para').append(	 '<div  clas="col-md-12 " style="background-color:grey; color:white; font-weight:bold;"> '+
                    '<div   style="text-align:left;">Para</div>'+
                  
                   
                '</div>');   
        
       
         $("#dialog-para").append(' <div clas="col-md-12 " style="font-weight:bold;" > '+  msg.actionTitle +' </div>'   );   
        $("#dialog-para").append(' <div clas="col-md-12 " > '+  msg.parasAction +' </div>'   );  
        
        paraReason= msg.parareasonsDelay;
       // alert("paraReason"+paraReason);
        		              
               $("#main2").append( '</div>');     
                  
             
    }
});


$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../parasrest/replyDetailByPara?paraId="+paraId,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
       console.log(msg2); 
       
      
         $('#dialog-para').append('<div id="main3" class="col-md-12 "> '+
        		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> '+
                   
                    '<div  style="text-align:left;">Reply</div>'+
                   
                '</div>');   
        
       
         for(i in  msg2 ){
        	 var j=parseInt(i)+1;
       $("#dialog-para").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply S.No  '+ j  +' </div>'); 
       
        var userN=msg2[i].userName;
      // alert("userN"+userN); 
     
    // alert( msg2[i].replyAction);
         if( (userN =="ENC-IRRIGATION") || (userN =="CAO-UNIT") ){
       
       $("#dialog-para").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply Updated by  '+  msg2[i].userName  +' </div>'); 
       }  
        $("#dialog-para").append(' <div  class="col-md-12 " > '+  msg2[i].replyAction +' </div>'); 
        
        
        
                   
         }         
         $("#main3").append(	'</div>' );
      /*    $("#main1").append(	'</div>' ); */
       
         
    }
});
if(paraReason!=null){
    $('#dialog-para').append('<div id="main4" class="col-md-12 "> '+
   		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> '+
              
               '<div  style="text-align:left;">Reasons for Delay</div>'+
              
           '</div>');   
    
    $("#dialog-para").append(' <div clas="col-md-12 " > &emsp;&emsp; </div>'   );  
   
$("#dialog-para").append(' <div clas="col-md-12 " > '+ paraReason +' </div>'   );  

$("#main4").append(	'</div>' );
}
}

if(tr==true){
	
	//alert("coming tr"+tr);
	$.ajax({
	    type: "GET", //rest Type
	    dataType: 'json', //mispelled
	    url: "../parasrest/parastransferDetailByPara?paraId="+paraId,
	    async: false,
	    contentType: "application/json; charset=utf-8",
	    success: function (msg) {
	       // console.log(msg); 
	        $('#dialog-para').empty();   
	      
	         $('#dialog-para').append('<div clas="col-md-12 " id ="main2">');
	        		 
	         $('#dialog-para').append(	 '<div  clas="col-md-12 " style="background-color:grey; color:white; font-weight:bold;"> '+
	                    '<div   style="text-align:left;">Transferred TO</div>'+
	                  
	                   
	                '</div>');   
	         $("#dialog-para").append('<div clas="col-md-6 " style="font-weight:bold;" > Gist : </div> <div clas="col-md-6 " style="font-weight:bold;" > '+  msg.actionTitle +' </div>'   ); 
	       
	         $("#dialog-para").append('<div clas="col-md-3 " style="font-weight:bold;" > Unit : </div> <div clas="col-md-3 " style="font-weight:bold;" > '+  msg.unitName +' </div>'   ); 
	         if( msg.circleName!=null){
	        $("#dialog-para").append('<div clas="col-md-3 " > Circle  : </div> <div clas="col-md-3 " > '+  msg.circleName +' </div>'   );   
	         }
	         if( msg.divisionName!=null){
	        $("#dialog-para").append(' <div clas="col-md-3 " > Division : </div><div clas="col-md-3 " > '+  msg.divisionName +' </div>'   );  
	         }
	        
	         
	        		              
	               $("#main2").append( '</div>');     
	                  
	             
	    }
	});
	
	
	
}
	
	$("#dialog-para").dialog({
	    modal: true,
	    draggable: true,
	    resizable: true,
	    position: ['center', 'center'],
	    show: 'blind',
	    hide: 'blind',
	    width: 1200,
	    height:600,
	    dialogClass: 'ui-dialog-osx',
	    buttons: {
	        "close para": function() {
	            $(this).dialog("close");
	        }
	    }
	});

}




       
    </script>




		



<div class="col-md-9">
	


<div>





		<div class="panel panel-primary  " >
			<div class="panel-heading">
				<h3 class="panel-title">Paras Gist<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						 <c:if test="${userObj.employeeName!=null  &&  userObj.employeeName!='NA' }">	
						   
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
		
		
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<div class="  show-grid ">
<div class="alert alert-info" role="alert">

               	
               
				<strong style="color:#CA3F22"> Note: Please click on Gist of the Para to see respective SubParas and Replys. Also Transferred from Office is displyed  ****</strong>
				

			</div>
			</div>
		
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
				
		
	


<c:if test="${selectedunitId!=null && selectedabstract==true }">
<div align="center">
		
		<h1><a target="_blank" href="../parasreport/downloadabstarctviewPDF?unitId=${selectedunitId}&circleId=${selectedcircleId}&divisionId=${selecteddivisionId}&subdivisionId=${selectedsubdivisionId} &sectionId=${selectedsectionId} &paraStatusId=${selectedParaStatusId} &transferFlag=${selectedTransferFlag}">Download PDF Document</a></h1>
	</div>
</c:if>

<c:if test="${selectedunitId==null && selectedabstract==true}">
<div align="center">
		
		<h1><a target="_blank" href="../parasreport/downloadabstarctviewPDF?sectionId=${selectedsectionId} &paraStatusId=${selectedParaStatusId} &transferFlag=${selectedTransferFlag}">Download PDF Document</a></h1>
	</div>
</c:if>

<c:if test="${selectedunit!=null && selectedabs==false}">
<div align="center">
		
		<h1><a target="_blank" href="../parasreport/downloadabstarctofficeviewPDF?unitId=${selectedunit} &sectionId=${selectedSectionId} &paraStatusId=${selectedParaStatusId} &transferFlag=${selectedTransferFlag} &circleId=${selectedCircleId} &divisionId=${selectedDivisionId}&circleTotal=${selectedcircleTotal}&unitTotal=${selectedunitTotal}">Download PDF Document</a></h1>
	</div>
</c:if>

</form:form>

					<div
						class="show-grid gridList mainprint pagecontent"
						>

<%-- <c:if test="${compCapList!=null}"> --%>

						<div class="table-responsive" id="printarea">

							<table class=" display table-bordered table1" style="width:100%" id="tabledata">
								<thead >
									
									<tr style=" font-size: 18px" >
										<th rowspan="2" style="text-align: center;">Sl.No</th>
										<th rowspan="2" style="text-align: center;">Name of Office</th>
										<th rowspan="2"  style="text-align: center;">Year</th>										
										<th rowspan="2"  style="text-align: center;">File No</th>
										<th rowspan="2" style="text-align: center;" >LAR No.</th>
										<th rowspan="2" style="text-align: center;" >Transferred from Office.</th>
										<th rowspan="1"  colspan="2" style="text-align: center;">Para Number</th>	
															
										
										<th rowspan="2" style="text-align: center;">Gist Of The Para</th>
										<!-- <th rowspan="1" >Para</th> -->
										<th rowspan="2" style="text-align: center;">Para Status</th>
										<th rowspan="2" style="text-align: center;">Print in CAG</th>									
										<!-- <th rowspan="1" colspan="2">AuditDate</th> -->
										
							
									</tr>
									
									<tr>
									
									<th rowspan="1" >SectionA</th>
										<th rowspan="1" >SectionB</th>	
										
									
									</tr>
									

									

								</thead>


								<tbody>
									
										<c:forEach items="${paraListTotal}" var="t" varStatus="count">
										  <c:if test="${t.unitId>0&&t.circleId<=0&&t.divisionId<=0}">	
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
											  
												<td><b><c:out value="${t.unitName}"></c:out></b></td>
												
											
												<td><c:out value="${t.financialYear}"></c:out></td>
												<td><c:out value="${t.fileNumber}"></c:out></td>
												<td><c:out value="${t.larNumber}"></c:out></td>
											  <c:choose>
											  <c:when test="${t.oldParaId>0 }">
												<td style="color:red"><c:out value="${t.trfromUnit}"></c:out></br><c:out value="${t.trfromCircle}"></c:out> </br> <c:out value="${t.trfromDivision}"></c:out></td>
												</c:when>
												<c:otherwise>
												
												<td>--</td>
												
												</c:otherwise>
												</c:choose>
												<td><c:out value="${t.paraNumsectionA}"></c:out></td>
																						
												
											
												
												
											
												
												
												<td><c:out value="${t.paraNumsectionB}"></c:out></td>
																							
												
												
												
											
												
												<td><a href="javascript:void(null);" onclick="getparaData(${t.paraId},${t.transferFlag});"><c:out value="${t.actionTitle}"></c:out></a></td>

												
											<%-- 	<td width="20%"><c:out value="${t.parasAction}"  escapeXml="false" ></c:out></td> --%>
												<td><c:out value="${t.paraStatus}"></c:out></td>
												<td><c:out value="${t.printCagStatus}"></c:out></td>
												
												
												
										</tr>
										
										</c:if>
										
										<c:if test="${t.unitId>0&&t.circleId>0&&t.divisionId<=0}">	
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
											  
												<td><b><c:out value="${t.circleName}"></c:out></b></td>
												
												
											
												
												
												<td><c:out value="${t.financialYear}"></c:out></td>
												<td><c:out value="${t.fileNumber}"></c:out></td>
												<td><c:out value="${t.larNumber}"></c:out></td>
											     <c:choose>
											  <c:when test="${t.oldParaId>0 }">
												<td style="color:red"><c:out value="${t.trfromUnit}"></c:out></br><c:out value="${t.trfromCircle}"></c:out> </br> <c:out value="${t.trfromDivision}"></c:out></td>
												</c:when>
												<c:otherwise>
												
												<td>--</td>
												
												</c:otherwise>
												</c:choose>
											
												<td><c:out value="${t.paraNumsectionA}"></c:out></td>
																						
												
											
												
												
											
												
												
												<td><c:out value="${t.paraNumsectionB}"></c:out></td>
																							
												
												
												
											
												
												<td><a href="javascript:void(null);" onclick="getparaData(${t.paraId},${t.transferFlag});"><c:out value="${t.actionTitle}"></c:out></a></td>

												
											<%-- 	<td width="20%"><c:out value="${t.parasAction}"  escapeXml="false" ></c:out></td> --%>
												<td><c:out value="${t.paraStatus}"></c:out></td>
												<td><c:out value="${t.printCagStatus}"></c:out></td>
												
												
												
										</tr>
										
										</c:if>
										
										<c:if test="${t.unitId>0&&t.circleId>0&&t.divisionId>0}">	
										
										<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
											  
											
												
												
												<td><b><c:out value="${t.divisionName}"></c:out></b></td>
												
												
												<td><c:out value="${t.financialYear}"></c:out></td>
												<td><c:out value="${t.fileNumber}"></c:out></td>
												<td><c:out value="${t.larNumber}"></c:out></td>
											
											<c:choose>
											  <c:when test="${t.oldParaId>0 }">
												<td style="color:red"><c:out value="${t.trfromUnit}"></c:out></br><c:out value="${t.trfromCircle}"></c:out> </br> <c:out value="${t.trfromDivision}"></c:out></td>
												</c:when>
												<c:otherwise>
												
												<td>--</td>
												
												</c:otherwise>
												</c:choose>
												<td><c:out value="${t.paraNumsectionA}"></c:out></td>
																						
												
											
												
												
											
												
												
												<td><c:out value="${t.paraNumsectionB}"></c:out></td>
																							
												
												
												
											
												
												<td><a href="javascript:void(null);" onclick="getparaData(${t.paraId},${t.transferFlag});"><c:out value="${t.actionTitle}"></c:out></a></td>

												
											<%-- 	<td width="20%"><c:out value="${t.parasAction}"  escapeXml="false" ></c:out></td> --%>
												<td><c:out value="${t.paraStatus}"></c:out></td>
												<td><c:out value="${t.printCagStatus}"></c:out></td>
												
												
												
										</tr>
										
										</c:if>
										
										<%-- <tr>	<td><c:out value="${t.auditDateFrom}"></c:out></td>
												<td><c:out value="${t.auditDateTo}"></c:out></td></tr> --%>

										</c:forEach>
									


								
									
									
								</tbody>


							</table>
							
									
							
							
							
								
							


						</div>
					<%-- 	</c:if> --%>
					

					</div>



				</div>
				
				
			
		</div>
		</div>
		
					
					
		                     <c:if test="${reportType==2}">
		                     <c:if test="${selectedabstract==true}">
	                         <div class="col-md-12">
																
									<button type="button" name="showgist" id="showgistid"  class="btn btn-1 btn-primary center-block "  onclick="getaboffice(${selectedunitId},${selectedcircleId},${selecteddivisionId},${selectedsubdivisionId},${selectedsectionId},${selectedParaStatusId},${selectedTransferFlag},'parareport',1)" >Back to Report By Unit Office  </button>
										
										</div>
										</c:if>
										</c:if>
										
										 <c:if test="${reportType==1}">
		                   
	                         <div class="col-md-12">
																
									<button type="button" name="showgist" id="showgistid"  class="btn btn-1 btn-primary center-block "  onclick="getadminffice(4,'parareport',1)" >Back to Report By admin Office  </button>
										
										</div>
									
										</c:if>
										
										  
			
			
			 
			 
		
			 
									<c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">		
									
										       <c:if test="${selectedabs==false}">								
	                         <div class="col-md-12">
																
									<button type="button" name="showgistn" id="showgistidnabs"  class="btn btn-1 btn-primary center-block "  onclick="getabstactffice(${selectedunit},${selectedCircleId},${selectedDivisionId},${selectedsubDivisionId},${selectedSectionId},${selectedParaStatusId},${selectedTransferFlag},${selectedcircleTotal},${selectedunitTotal},'parareport',2)" >Back to Report By  Office  </button>
										
										</div>
										</c:if>
										 </c:if>
			 </c:if>	
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">	
										  <c:if test="${selectedabs==false}">								
	                         <div class="col-md-12">
																
									<button type="button" name="showgistn" id="showgistidn"  class="btn btn-1 btn-primary center-block "  onclick="getabstactffice(${selectedunit},${selectedCircleId},${selectedDivisionId},${selectedsubDivisionId},${selectedSectionId},${selectedParaStatusId},${selectedTransferFlag},${selectedcircleTotal},${selectedunitTotal},'parareport',3)" >Back to Report By  Office  </button>
										
										</div>
										</c:if>
										</c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">	
										  <c:if test="${selectedabs==false}">								
	                         <div class="col-md-12">
																
									<button type="button" name="showgistn" id="showgistidnt"  class="btn btn-1 btn-primary center-block "  onclick="getabstactffice(0,0,0,0,${selectedSectionId},${selectedParaStatusId},${selectedTransferFlag},false,false,'parareport',4)" >Back to Report By  Office  </button>
										
										</div>
										</c:if>
										</c:if>
			 </c:if>	
										
										
										
	
</div>

<div id="dialog-para" title="Para-Replys" style="display:none">
		
		
		
		</div>


<!-- //main-content -->

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
					

















