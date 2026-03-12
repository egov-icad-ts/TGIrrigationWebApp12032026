<html>
<head>

<%@include file="/jsp/header/taglib_includes.jsp"%> 
 <script type="text/javascript"  async defer	
   src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDEQ-pY6Kr2boodqITGaSgBqRmeimIfMnc"></script>
   
  <!--testcgg  AIzaSyDPE87UZ3Twls2eUQq-2YNWJyyMmdMlTd4 -->
   
  <!--localhost   AIzaSyBQik5xJp-zcmfr3TQTS_wqffBj08AZZkk"  -->
   
   <link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css"> 
 <link rel="stylesheet" href="../css/treeview/jquery.treeview.css" />
<script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script>
<!-- <script>
$(document).ready(function(){
    $(this).bind("contextmenu", function(e) {
        e.preventDefault();
    });
});
</script> -->

 <script type="text/javascript">
            //<![CDATA[

            var map;
            var poly;
          


            // Ban Jelacic Square - Center of Zagreb, Croatia
           // geocoder = new google.maps.Geocoder();
             var geocoder = new google.maps.Geocoder();
             var infowindow = new google.maps.InfoWindow();
            function initialize(id) {
            	//alert("kal"+id);
            var projId=id;
           // alert("id"+id);
            	 var mapOptions = {
            		       
            		        zoom: 10,
            		        mapTypeId: google.maps.MapTypeId.ROADMAP,
            		    };
            		    

                map = new google.maps.Map(document.getElementById("googleMap"), mapOptions);
               /*  makeRequest('get_location.php', function(data) {

            var data = JSON.parse(data.responseText);

            for (var i = 0; i < data.length; i++) {
                displayLocation(data[i]);
				 }
        });   
               
 */  
 
 $.getJSON("../compMapRest/compStatus?projectId="+projId, function(json) {
 	
 	//alert(json);

   
     for (var i in json){
     	
          // alert(json[i].statusAddress)
           
     displayComponentStatus(json[i]);	
     	
     };

	
});
 
 
 
             /*  for (var k = 0; k < myData.length; k++) {
            	 // alert("kal1")
                  displayLocation(myData[k]);
                  
                } */
           }
            var flightPlanCoordinates = new Array();
           
    function displayComponentStatus(comps) {

    	 var myMarkers = [];
    	 var cusicon = {
 		        
 		        path:"M22-48h-44v43h16l6 5 6-5h16z",
 		        fillColor: '#FF0000',
 		        fillOpacity: .6,
 		        anchor: new google.maps.Point(0,0),
 		        strokeWeight: 0,
 		        scale: 0.5,
 		       
 		    }
    	 
        var content =   '<div class="infoWindow"><strong>Component: <font color="blue">'  + comps.componentName + '</font></strong>'
                        + '<br/><strong> Category: <font color="green"> '     + comps.componentCategory+ '</font></strong>'
                        + '<br/><strong> Pressure main Length: <font color="red">'     + comps.pmlength+ ' km</font></strong>'
                        + '<br/><strong> Discharge Cusecs: <font color="gray">'     + comps.dischrgecusecs+ '</font></strong>'
                        + '<br/><strong> Pipe Diameter: <font color="blue">'     + comps.pipediameter+ '</font></strong>'
                        + '<br/><strong> PipeRowsNo.: <font color="green">'     + comps.noofpiperows+ '</font></strong>'
                        + '<br/><strong> Total Lift: <font color="red">'     + comps.totalLift+ '</font></strong>'
                        + '<br/><strong> Lift Period: <font color="gray">'     + comps.liftperiod+ '</font></strong>'
                        + '<br/><strong> Lift TMC: <font color="blue">'     + comps.lifttmc+ '</font></strong>'
                        + '<br/><strong> Total Power With Aux: <font color="green">'     + comps.totalpowerwithAux+ ' Mw </font></strong>'
                        + '<br/><strong> Substation Capacity: <font color="red">'     + comps.substationCapacity+ '</font></strong>'
                        + '<br/><strong> Status:<font color="gray">'     + comps.status+ '</font></strong>'
                        + '</div>';
                        // alert("kal2")
       
            geocoder.geocode( { 'address': comps.statusAddress }, function(results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                	 map.setCenter(results[0].geometry.location);
                	
                	 
                	 cusicon.fillColor = comps.statusColor;
                	 console.log(comps.statusColor);
           		  
                    var marker = new google.maps.Marker({
                        map: map, 
                        position: results[0].geometry.location,

                        title: comps.componentName,
                        icon:cusicon
                    });
                    
                  //  alert("kal3")
                 
                  
					google.maps.event.addListener(marker, 'click', function() {
                        infowindow.setContent(content);
                        infowindow.open(map,marker);
                    });
                    
                    myMarkers.push(marker.getPosition().lat(),marker.getPosition().lng());
                    console.log(myMarkers);
                    var point =new google.maps.LatLng(parseFloat(myMarkers[0]),parseFloat(myMarkers[1]));
                     console.log(point);
        		    flightPlanCoordinates.push(point);  
        		   console.log(flightPlanCoordinates)
        		   
        		   var flightPath = new google.maps.Polyline({
        				  path: flightPlanCoordinates,
        				  geodesic: true,
        				  strokeColor: 'orange',
        				  strokeOpacity: 1.0,
        				  strokeWeight: 8
        				  });
        			  flightPath.setMap(map);
            		
            		
            		
           		  
           		
           		
           		  }
                
            });
         
    }      

                
            </script>

 
</head>

 <!-- onload="initialize()" -->

<body>

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

 
	 
<form:form id="compMapId" method="post"
				modelAttribute="compMap" >
				
				<input name=urlvalue type=hidden >
				<input name=unitId  id="unitId" type=hidden >
				<input name=circleId  id="circleId" type=hidden >
				<input name=divisionId  id="divisionId" type=hidden >
				<input name=subdivisionId  id="subdivisionId" type=hidden >
	<div class="w3_agile_main_left">
		
		

<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">

<c:forEach items="${unitList}" var="u">
								
								
	<li><a class="myunit"  href="../compReport/componentMap?unitId=<c:out value="${u.unitId}"></c:out> &projectId=16" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	<ul>
	<c:forEach items="${prList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	
		<li><a class="mycircle"  onclick="initialize(<c:out value="${c.projectId}"></c:out>)"  href="javascript:void(0);"><c:out value="${c.projectName}"></c:out></a>
			<ul>
	<!-- href="../compReport/componentMap?projectId= " -->
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
		
		
	
	
	

		
	
	
</form:form>	


	<div class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Component Status on Map</h3>
			</div>

			<div class='container'>




				<div class="row col-md-12 toppad ">

				
				<div class="row show-grid">
		<div class="col-md-10">
		</div>
		<div class="col-md-2">
				<a href="../compReport/componentMap">	<input type="button" class="btn btn-1 btn-primary center-block"
						id="getcompMaps" value="Back"   >
						</a>
				</div>
				</div>
				
		<div class="row show-grid">		
		<div id="googleMap" style="height: 400px;"></div>	
		</div>	
		
			<div class="row show-grid">
				<br></br>
					<div class="col-md-4"></div>
				
					<div class="col-md-2">
					 <input type="button" value="Print Preview" class="btn btn-1 btn-primary center-block" onclick="PrintPreview('mainprint')"/>
					 </div>
					<div class="col-md-2">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Print"  onclick="printDiv('mainprint')" >
					</div>
						<div class="col-md-4"></div>
					
					
					</div>	
			
				
					
						
	
					

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


   
</body>

</html>