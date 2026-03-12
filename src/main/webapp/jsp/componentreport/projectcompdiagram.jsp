	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 
 
<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="../css/print.css" />
 
 
 
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

function getProjects(){
	
	 
    var   unitId=$('#unitId').val();
      
  //  alert("procId"+procId);
	$('#projectId').multiselect('rebuild');


	$.ajax({	          
	      url: "../compReport/getProjects?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	    	  var $select = $('#projectId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#projectId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						
	  						
	  					$('#projectId').append( '<option value="'+value.projectId+'"> '+value.projectName+'</option>' );
	  					
	  				$('#projectId').multiselect('rebuild')
	  				
	  				
	  		/* 	$(this).removeAttr('selected').prop('selected', false);
				  
			    if($('li').hasClass('active')){
			    	if($('input').prop('checked', true)){
			    		
			    		 $('input').prop('checked', false);
			    		
			    	var spantext=	$("span.multiselect-selected-text").text();
			    	$("span.multiselect-selected-text").text('None Selected')
			    		
			    		
			    	}
			    	$('li').removeClass('active');
			       
			    } */
	  				
	  					});
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 
function loadForm(){
	
	var courtId=$('#courtId').val();
	var caseType =$('#caseGenId').val();
	
	
	

	
		
	
		  $('#casesReport').attr('action', "../webReports/casesview");
          $("#casesReport").submit();
         
	
	
	
	
    
}

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
}
 */
 
 
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
		 $('#unitId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		 });
		
		$('#projectId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		 });
		 

			
			

			$( "#projectId" ).change(function() {
				
				  var projectId =$("#projectId").val();
				     var projectName =$('#projectId').find("option:selected").text(); 
				     $("#projectName").val(projectName);
				     
				     var b=$("#projectName").val();
			  //alert( b+"b");
			});


			
	 });
	
	
</script>








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
	
	




		
		
	
	 
	<div class="w3_agile_main_left">
	
	<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Lift Scheme Components Diagram</h3>
			</div>

			<div class='container'>




				<div class="row col-md-12 toppad ">
<form:form id="projdia" method="post"
				modelAttribute="projdiagram"  data-parsley-validate-if-empty="">
				
				<div class="row show-grid">
					
			<div class="col-md-4"></div>
					
					

						<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select Unit*</label>
							<select class="form-control" id="unitId" name="unitId"
								onchange="getProjects()" required>

								 <option value="0">--select--</option>
								<c:forEach items="${unitList}" var="p">
									<option value="${p.unitId}">${p.unitName}</option>

								</c:forEach>
 

							</select>
						</div>
						
						<div class="col-md-2">
							<label class="label-controlPMS rowlebel ">Select Project*</label>
							<select class="form-control" id="projectId" name="projectId"
								onchange="" required>

								 <option value="0">--select--</option>
								

							</select>
						</div>
						<div class="col-md-2">
						<input type="hidden" class="form-control" name="projectName" readonly="readonly" id="projectName" value="" />
						</div>
						
						<div class="col-md-4"></div>
						
						</div>
						
				
						

				


					

					
					<div class="row show-grid">
					<div class="clearfix"> </div>
					<div class="clearfix"> </div>
					<div class="col-md-12">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="projcompdiaid" value="Get project Components" onclick="" >
					</div>
					</div>
					
					</form:form>

					

</div>
</div>
</div>

	<div class="row show-grid">
	<div class="col-md-2"></div>
	<div class="col-md-8">
	<c:if test="${component!=null}">
						<c:if test="${component.projectId!=null}">
					<!-- 	
						<svg height="200" width="500">
  <polyline points="20,20 40,25 60,40 80,120 120,140 200,180"
  style="fill:none;stroke:black;stroke-width:3" />
</svg> -->
			
			
			<svg width="1200" height="1000">
			
			
			
			 <g>
			 <rect id="button_rect" x="50" y="50" width="1000" height="800"
					style="stroke-width:3; stroke:black; fill:white"> </rect>
						 <text id="" x="350" y="45" font-size="25" fill="black">${component.projectName} &nbsp  Project Component Diagram</text>
						 
				</g>		 
						 
						 <g>
				<text id="" x="55" y="90" font-size="17" fill="black">Legend for shapes:: </text> 
			<circle cx="280" cy="85" r="6" stroke="black" stroke-width="1"
					fill="white"></circle>
						 <text id="" x="295" y="90" font-size="15" fill="black"> -- reservoir</text>
						 
				</g>		 
						 
						
						 <g>
			 <polygon id="button_rect" points="275,110 282,105 289,110"
					style="stroke-width:1; stroke:black; fill:white"> </polygon>
						 <text id="" x="295" y="110" font-size="15" fill="black"> -- Lift Scheme</text>
						 
				</g>
				
				 <text id="" x="275" y="130" font-size="15" fill="black"> pm=Pressure main Length in KM</text>		 
						 
						
					<!-- 	 <g>
			 <line id="button_rect" x1="625" y1="85" x2="630" y2="85"
					style="stroke-width:2; stroke:black; fill:white"> </line>
					 <line id="button_rect" x1="625" y1="90" x2="630" y2="90"
					style="stroke-width:2; stroke:black; fill:white"> </line>
					
						 <text id="" x="645" y="90" font-size="15" fill="black"> -- Bride</text>
						 
				</g>		 
						 
						
						 <g>
			 <rect id="button_rect" x="815" y="85" width="12" height="4"
					style="stroke-width:1; stroke:black; fill:white"> </rect>
						 <text id="" x="835" y="90" font-size="15" fill="black"> -- Cross Regulator</text>
						 
				</g>		 --> 
						 
						 
						 
						 
						 
			<c:forEach items="${segmentsList}" var="elem"
					varStatus="currentStatus">
					<c:choose>
					<c:when test="${elem.flag}">
					
					<%-- <c:if test="${elem.structureType.equals('4')}">
					<g>
					<rect onclick="FillColor1(evt)"
									id="button_rect${currentStatus.index}" x="${elem.xCoord}"
									y="${elem.yCoord}" width="12" height="5" fill="${elem.colour}"
									style="stroke:purple;stroke-width:25"> 
								
						     <title>
         
     <fmt:formatNumber var="chainageAt" type="number"
										minFractionDigits="3" maxFractionDigits="3"
										value="${elem.chainageAt}" />
		
								
     Chainage@(Km): <c:out value="${chainageAt}"></c:out>
       
      Remarks: <c:out value="${elem.remarks}"></c:out>
     			
					
       </title>
           
      </rect>      
      </g>
					</c:if> --%>
					<c:if test="${elem.structureType.equals('1')}">
					<g>
					
					<circle cx="${elem.xCoord}" cy="${elem.yCoord}" r="5"
									stroke="black" stroke-width="1" fill="${elem.colour}">
					
					 <title>
         
     <fmt:formatNumber var="chainageAt" type="number"
										minFractionDigits="3" maxFractionDigits="3"
										value="${elem.chainageAt}" />
		
								
     Chainage@(Km): <c:out value="${chainageAt}"></c:out>
       
      Remarks: <c:out value="${elem.remarks}"></c:out>
     			
					
       </title>
					</circle>
		</g>
					</c:if>

									
						<c:if test="${elem.structureType.equals('2')}">
					
									<g>
									 <polygon
									points="${elem.xCoord},${elem.yCoord} ${elem.x1Coord},${elem.y1Coord} ${elem.x2Coord},${elem.y2Coord}"
									style="stroke-width:10;stroke:${elem.colour};fill:${elem.colour}">
								<title>      
     <fmt:formatNumber var="chainageAt" type="number"
										minFractionDigits="3" maxFractionDigits="3"
										value="${elem.chainageAt}" />
		
						
     Chainage@(Km): <c:out value="${compLength}"></c:out>
       
      Remarks: <c:out value="${elem.remarks}"></c:out>
     			
					
       </title></polygon>
       
       <text id="" x="${elem.xCoord}" y="${elem.yCoord}"
								font-size="15" fill="black" style="stroke-width:3;"
								transform="rotate(50, ${elem.xCoord+10},${elem.yCoord+10})">${elem.remarks}   &nbsp pm@(Km) &nbsp  ${elem.compLength}</text> 
  
      
       
								 </g>	
								 
								  </c:if>
																 
									<%--  	<c:if test="${elem.structureType.equals('3')}">
					
				                	<g>
					                <line x1="${elem.xCoord}" y1="${elem.yCoord}"
									x2="${elem.xCoord+10}" y2="${elem.yCoord}"
									style="stroke:${elem.colour};stroke-width:3" />
									
									<rect x="${elem.xCoord}" y="${elem.yCoord}" width="10"
									height="5" fill="lightgray"> <title>
     <fmt:formatNumber var="chainageAt" type="number"
										minFractionDigits="3" maxFractionDigits="3"
										value="${elem.chainageAt}" />
				
     Chainage@(Km): <c:out value="${chainageAt}"></c:out>
      
      Remarks: <c:out value="${elem.remarks}"></c:out>
			
					
       </title> </rect>
									<line x1="${elem.x1Coord}" y1="${elem.y1Coord}"
									x2="${elem.x1Coord+10}" y2="${elem.y1Coord}"
									style="stroke:${elem.colour};stroke-width:2">					
	        						
					</line>
					</g>
					
					
       
       
       
       
       
       </c:if> --%>
					
					</c:when>
					<c:otherwise>
					
					<g render-order="-1">
					<rect onclick="FillColor1(evt)"
								id="button_rect${currentStatus.index}" x="${elem.xCoord}"
								y="${elem.yCoord}" width="${elem.componentWidth}"
								height="${elem.actualLength}" fill="${elem.colour}"> 
						</rect>
						
						 <text id="thepopup" x="${elem.textXcord}" y="${elem.textYcord-10}"
								font-size="15" fill="black" st
								transform="rotate(${elem.angle}, ${elem.textXcord},${elem.textYcord})">${elem.componentName}   &nbsp  &nbsp  ${elem.componentLength}</text>     
								
							
    	</g>
					</c:otherwise>
					</c:choose>
					 
					 
	
      </c:forEach> 
		
		 
			</svg>
			</c:if>
</c:if>
</div>
<div class="col-md-2"></div>
</div>
				







					






			


			
		
	




	

		
		
		
		
		<div class="row show-grid">
					<div class="clearfix"> </div>
					<div class="clearfix"> </div>
					<div class="col-md-4">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table', 'casestable')"  >
					</div>
					
					<div class="col-md-4">
					 <input type="button" value="Print Preview" class="btn btn-1 btn-primary center-block" onclick="PrintPreview('printarea')"/>
					 </div>
					
					<div class="col-md-4">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Print"  onclick="printDiv('printarea')" >
					</div>
					</div>
		
	</div>
	 
	 
	 
	 

<!-- //main-content -->


<script type="text/javascript" src="../js/parsley.js"></script>

    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#projdia').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  
			 
				
			  document.forms.projdia.action="../compReport/projCompDia";
				 document.forms.projdia.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>
