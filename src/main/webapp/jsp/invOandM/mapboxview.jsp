

<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<!-- <link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script> -->

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<!-- <script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script> -->
<script src='https://api.mapbox.com/mapbox-gl-js/v1.11.1/mapbox-gl.js'></script>
<link href='https://api.mapbox.com/mapbox-gl-js/v1.11.1/mapbox-gl.css' rel='stylesheet' />

<script type="text/javascript" src="//cdn.jsdelivr.net/jspdf/1.3.4/jspdf.min.js"></script>
  <script type="text/javascript" src="//cdn.jsdelivr.net/canvas-toblob/0.1/canvas-toBlob.min.js"></script>
        <script type="text/javascript" src="//cdn.rawgit.com/eligrey/FileSaver.js/1.3.3/FileSaver.min.js"></script>
        
         <script type="text/javascript" src="../js/invomReports/tokml.js"></script>
        
        
       
           <!--    <script type="text/javascript" src="https://api.tiles.mapbox.com/mapbox-gl-js/v0.42.2/mapbox-gl.js"></script> -->


<!-- <style type="text/css">
#info {
display: block;
position: relative;
margin: 0px auto;
width: 50%;
padding: 10px;
border: none;
border-radius: 3px;
font-size: 12px;
text-align: center;
color: #222;
background: #fff;
}
</style> -->
<style>
.mapboxgl-popup {
max-width: 400px;
font: 12px/20px  Arial, Helvetica, sans-serif;
}
</style>





<div class="col-md-9">



<div>

	

	


	<div class="panel panel-primary " >
		<div class="panel-heading">
			<h3 class="panel-title">Map View</h3>
		</div>
		
		
	<div class="panel-body">
<div class="alert alert-info col-md-12" style="padding: 0px"
				id="action_alert">
<c:if test="${msg!=null }">
<c:out value="${msg}"></c:out>
</c:if>				
				</div>

								
								

	
	
	&emsp;&emsp;
	
		<div id="tabs">
						<ul>


                              <li><a href="#earth" >Earth View Map</a></li>
							
							<li><a href="#street" >View Map</a></li>
							






						</ul>
						<!-- tabs -->




  <div class="row">
		   <label class="checkbox-inline"><input class="boundaryCheck"  id="district" type="checkbox" value="">District Boundary</label>
<label class="checkbox-inline"><input class="boundaryCheck"  id="mandal" type="checkbox" value="">Mandal Boundary</label>
<label class="checkbox-inline"><input class="boundaryCheck"  id="village" type="checkbox" value="">Village Boundary</label> 

<label class="checkbox-inline"><input class="boundaryCheck"  id="canal" type="checkbox" value="">Canals</label> 
<label class="checkbox-inline"><input class="boundaryCheck"  id="knrtanks"type="checkbox" value="">karimnagar Tanks</label> 
<label class="checkbox-inline"><input class="boundaryCheck"  id="wgltanks" type="checkbox" value="">Warangal Tanks</label> 
		  </div>
                  
						<div id="earth">
	
		<div id='map' style='width: 900px; height: 800px;'></div>
			
			&emsp;&emsp;
			 <form:form id="mapprintform" name="mapprintform"
								>
					

                            <div class="col-md-12">
		<div class="col-md-4"></div>
		<div class="col-md-4">
		<div class="" id="spinner" style="text-align: center;"></div>
		 <a id="downloadLink" href="" download="map1.png">Download Map <span class="glyphicon glyphicon-download-alt"></span></a>
    <div id="image"></div>
		</div>
		<div class="col-md-4"></div>
		</div>                            
                            </form:form> 
                            
		 
		
			<div id="map1data">
		<div class="show-grid gridList mainprint pagecontent">


						<div class="" id="printarea">

							<table class=" display table-bordered table1" style="width:100%" id="maptable1">
								<thead id="mapthead1">
									
						

								</thead>


								<tbody id="maptbody1">
									
						
									
								</tbody>


							</table>
							
				

						</div>
				
					</div>
					</div>
		

	
	</div>
	
		<div id="street">
		
		
		<div id='map2' style='width: 900px; height: 800px;'></div>
			
			&emsp;&emsp;
			 <form:form id="mapprintform2" name="mapprintform2"	>
			
                            <div class="col-md-12">
		<div class="col-md-4"></div>
		<div class="col-md-4">
		<div class="" id="spinner" style="text-align: center;"></div>
		 <a id="downloadLink2" href="" download="map2.png">Download Map <span class="glyphicon glyphicon-download-alt"></span></a>
    <div id="image2"></div>
		</div>
		
		

		<div class="col-md-4"></div>
		</div>
	
		          
                            </form:form> 
      <div id="map2data">
		<div class="show-grid gridList mainprint pagecontent">


						<div class="" id="printarea">

							<table class=" display table-bordered table1" style="width:100%" id="maptable2">
								<thead id="mapthead2">
									
						

								</thead>


								<tbody id="maptbody2">
									
						
									
								</tbody>


							</table>
							
				

						</div>
				
					</div>
					</div>
		
		

		</div>
		
		</div><!-- tabs -->
	
		
		 </div>	<!-- panel div div -->
	

	</div>	<!-- panel div -->
	

	
	</div><!-- container div -->



</div>
<script type="text/javascript" src="../js/invomReports/maps_view.js"></script>

<script>

// map js here

</script>






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
           
            
{
    extend:  'copyHtml5',
   
   
   
    className: 'btn btn-1 btn-primary ',
  
    
    
},
{
    extend: 'excelHtml5',
    autoFilter: true,
    sheetName: 'Exported Paras data',
    text:  'Save To Excel',
    className: 'btn btn-1 btn-primary ',
    messageTop: 'Tank Abstract Detail'
    
    
},
{
    extend: 'pdfHtml5',
    className: 'btn btn-1 btn-primary ',
    text:  'PDF View / Download',
    orientation: 'landscape',
    pageSize: 'A4',
    download: 'open',

   
    filename: 'Map_Detail',
    exportOptions: {
		columns: ':visible',
		search: 'applied'
		
	}, 
	
   
    title: 'Map Details',
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
						
	

	
	
