<%@include file="/jsp/header/taglib_includes.jsp"%>

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">

<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>


<link rel="stylesheet"
	href="../css/Html5DataTable/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href=" ../css/Html5DataTable/buttons.dataTables.min.css" />

<!-- <script type="text/javascript">


$(function() {

	
	 
	 $( "#tabs2" ).tabs();

});
</script> -->

 <script type="text/javascript" src="../js/invomReports/michecks_report.js"></script>


<div class="col-md-12">       
		 


		<div >
			 

			
<div class="panel panel-primary" >
			<div class="panel-heading">
				<h3 class="panel-title">Irrigation Tanks: Irrigation Tanks Abstract Detail</h3>
			</div>
<div class="panel-body">
	
	
		<div id="tabs2">
				<ul class="left-tabs"> 
						 <li><a href="#tii" >TANK INSPECTION INFO</a></li>
						
						   <li><a href="#rh" >TANK REPAIR HISTORY</a></li>						   
						     <li><a href="#cp" >TANK CAPACITY</a></li>
						     <!--   <li><a href="#feed" >TANK FEED DETAILS</a></li> -->
						</ul> <!-- tabs -->
	
	<div class="left-content" >	
						 	<div id="tii" >
						 	
						 	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
             
				<strong style="color:#CA3F22"> Condition of Bund Top, Upstream Slope, Down Stream Slope , Revetment, Sluice and Weirs.</strong>
				

			</div>
			
			</div>
			
			
						 	<div id="tankinfodata">
				<div class="show-grid gridList " 	style="display: block">
				<div class="table-responsive" id="printarea">
						<table class="display table-bordered " style="width: 100%"
							id="tanks-checks-list-data">
							<thead  id="tcheckshead1">
							
							

                          
							
							</thead>


							<tbody id="tchecksbody1">

								

							</tbody>
		</table>


				</div>
				</div>
				
				&emsp;&emsp;&emsp;&emsp;
			<!-- 	<div class="col-md-12" >
			<div class="col-md-6" >
             
				<h4><button type="button" name="viewallweirReviews" id="viewshowReviews" class="btn btn-1 btn-primary center-block allWeirRemarks"   >Show Remarks</button></h4>
         </div>
         <div class="col-md-6" >
             
				<h4><button type="button" name="hideallweirReviews" id="hideshowReviews" class="btn btn-1 btn-primary center-block allWeirRemarks" onclick="hideremarks()"  >Hide Remarks</button></h4>
         </div>
			</div> -->
						 	
				</div>
				
						 	
		<!-- <div class="invDiv" id="dialog-para1"> </div> -->
	<!-- 	<div class="invDiv" id="dialog-para2"> -->
		
		
   
   <!--  <div id="emb" style="font-weight:bold;color:black;" class="invDiv"><h3 style="color:maroon;"><b>Condition of Bund Top, Upstream Slope, Down Stream Slope , Revetment, Sluice and Weirs. </b></h3>
     <div class="top">
     </div>
      <div class="up">
      </div>
       <div class="down">
       </div>
    
    </div> -->
    
    <!-- <div id="slu" class="invDiv" style="font-weight:bold;color:Black"> <h3> Sluice </h3> 
      
    </div> -->
    <!--  <div id="weir" class="invDiv" style="font-weight:bold;color:Black" ><h3>Weirs</h3>
      <div class="wall" >
      </div>
 
</div>  -->
</div>
</div>
<div id="rh" >

<div id="adminsanctiondata" class="col-md-12 invDiv" > <h3> Admin Sanction Info </h3> 
	<div id="admns-anction-data">
	<div class="table-responsive" >
										<table class="display table-bordered " style="width: 100%"
											id="table9">
											<thead id="thead9">

											</thead>


											<tbody id="tbody9">


											</tbody>
										</table>

									</div>
									</div>
									 </div>

	<div id="agmtdata" class="col-md-12 invDiv" > <h3> Agreement Info </h3> 
	 <div  id="aggmt-data">
    <div class="table-responsive" >
										<table class="display table-bordered " style="width: 100%"
											id="table10">
											<thead id="thead10">

											</thead>


											<tbody id="tbody10">


											</tbody>
										</table>

									</div>
									</div>
									 </div>
									 
		 <div id="billdata" class="col-md-12 invDiv" > <h3>Bill Info </h3>  
		<div  id="bill-data">
    <div class="table-responsive" >
										<table class="display table-bordered " style="width: 100%"
											id="table12">
											<thead id="thead12">

											</thead>


											<tbody id="tbody12">


											</tbody>
										</table>

									</div>
									</div>
									</div>
	
	
		<div id="repairdata" class="col-md-12 invDiv" > <h3> Repair Info </h3>  
		<div id="rdata">
	<div class="table-responsive" >
										<table class="display table-bordered " style="width: 100%"
											id="table7">
											<thead id="thead7">

											</thead>


											<tbody id="tbody7">


											</tbody>
										</table>

									</div>
									</div>
									</div>
								
	

	<!-- <div id="tenderdata" class="col-md-12 invDiv" > <h3> Tender Info </h3>  
	<div id="tender-data">
	<div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="table8">
											<thead id="thead8">

											</thead>


											<tbody id="tbody8">


											</tbody>
										</table>

									</div>
									</div>
									</div> -->
	
	
	<!-- <div id="estdata" class="col-md-12 invDiv" > <h3> Estimate Info </h3>  
	<div  id="est-data">
    <div class="table-responsive" >
										<table class="display table-bordered table1" style="width: 100%"
											id="table11">
											<thead id="thead11">

											</thead>


											<tbody id="tbody11">


											</tbody>
										</table>

									</div>
									</div>
									</div> -->
		

   
								<!-- for repaIR HISTORY REPORT IF TAKEN AS INPUT
								
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class="display table-bordered table1" style="width: 100%"
											id="table5">
											<thead id="thead5">

											</thead>


											<tbody id="tbody5">


											</tbody>
										</table>

									</div>

								</div> -->
	</div>						

	<div id="cp" >
	<div   class="show-grid gridList mainprint pagecontent" style="display: block">
									<div class="table-responsive" id="printarea">
										<table class="display table-bordered " style="width: 100%"
											id="table6">
											<thead id="thead6">

											</thead>


											<tbody id="tbody6">


											</tbody>
										</table>

									</div>

								</div> 
								</div>
</div>
</div>
</div>

</div>
</div>

<div id="viewRemarks_dialogue">

	<form:form id="viewremarksid" method="post" modelAttribute="weir"
		name="weirform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">



<div id="viewmst1data">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="view1">
											<thead id="viewhead1">

											</thead>


											<tbody id="viewbody1">

											</tbody>
										</table>
									</div>


								</div>
							</div>
							

	</form:form>

</div>

<script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.print.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>
		<script src="../js/Html5DataTable/buttons.colVis.min.js" type="text/javascript"></script>
		 <script src="../js/Html5DataTable/buttons.html5.new.js" type="text/javascript"></script> 