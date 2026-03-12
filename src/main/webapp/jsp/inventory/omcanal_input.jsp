

<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<!-- <script type="text/javascript" src="../js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>

<style>
.ui-tabs-vertical { width: 45em; }
.ui-tabs-vertical .ui-tabs-nav { padding: .1em .1em .1em .1em; float: left; width: 8em; }
.ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
.ui-tabs-vertical .ui-tabs-nav li a { display:block; }
.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
.ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 30em;}
</style>


<script type="text/javascript">

$(document).ready(function(){
	
	
		 
	$('#unitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#circleId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#divisionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#subdivisionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#reservoirId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	





	
	
	
	
	
	
	 
	 
	 
	

	}); 
	
	
$(function() {
	
	
$("#addresjuris").click(function() {
	  var link = $(this).attr('href');
	  
	  alert(link);
	
	  $('#whereFormWillLive').load(link);
	 

	 // $(".content").load(link);
	});
	
/* 
$( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
$( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
 */
 $( "#tabs" ).tabs()


				
	
});



</script>

<div class="col-md-9">
	


<div>

	<div class="panel panel-primary " >
		<div class="panel-heading">
			<h3 class="panel-title">O&M of Inventory:Operation of Canal</h3>
		</div>
			
		
		<div class='container ' style="padding-top: 20px" >
		
		<div id="result" class="col-md-4 invDiv">
		
		<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Status: 
						</label>
						</div>
						
						<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Completed/Ongoing
						</label>
					</div>
					
		
		
		<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Canal Type: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="pumphouseId" name="pumphouseId"
							 required>
							<option value=" ">--select--</option>
							<option value=" ">Main</option>
							<option value=" ">Major/Distributory</option>
							<option value=" ">Minor</option>
							<option value=" ">SubMinor</option>

						</select>
					</div>
					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Canal: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="pumphouseId" name="pumphouseId"
							 required>
							<option value=" ">--select--</option>
							<option value=" ">Canal1</option>
							<option value=" ">Canal2</option>
							<option value=" ">Canal3</option>
							

						</select>
					</div>
					
						
						
					
		<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Operation: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="OperationId" name="OperationId"
							 required>
							<option value=" ">--select--</option>
							<option value=" ">Daily</option>
							<option value=" ">Weekley</option>
							<option value=" ">Monthly</option>
							<option value=" ">Quarterly</option>
							<option value=" ">Half-Yearly</option>
							<option value=" ">Yearly</option>
							

						</select>
					</div>
					
					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Test Type: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="OperationId" name="OperationId"
							 required>
							<option value=" ">--select--</option>
							<option value=" ">Test Name1</option>
							<option value=" ">Test Name2</option>
							<option value=" ">Test Name3</option>
							<option value=" ">Test Name4</option>
							

						</select>
					</div>
		            
		            <div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
					<input
				type="text" class="form-control" id="dateofoperation" name="dateofoperation"
				placeholder="dateofoperation"  />
					</div>
					
					 <div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Hour: <font
							color=red>*</font>
						</label>
					</div>

				<div class="col-md-6">
						<select class="form-control" id="hour" name="hour"
							 required>
							<option value=" ">--select--</option>
							<option value=" ">1</option>
							<option value=" ">2</option>
							<option value=" ">3</option>
							<option value=" ">4</option>
							<option value=" ">5</option>
							<option value=" ">6</option>
							
							<option value=" ">7</option>
							<option value=" ">8</option>
							<option value=" ">9</option>
							<option value=" ">10</option>
							<option value=" ">11</option>
							<option value=" ">12</option>
							<option value=" ">13</option>
							<option value=" ">14</option>
							<option value=" ">15</option>
							<option value=" ">16</option>
							<option value=" ">17</option>
							<option value=" ">18</option>
							<option value=" ">19</option>
							<option value=" ">20</option>
							<option value=" ">21</option>
							<option value=" ">22</option>
							<option value=" ">23</option>
							<option value=" ">24</option>
							
							

						</select>
					</div>
		
		

		
		
		</div>
	
		
		
		<div id="result" class="col-md-8">
	<div class="wrapper">
		
			<div id="tabs">
				<ul>
					<li><a href="#civilparams">Civil Parameters</a></li>
				
					<li><a href="#hydparams">Hydraulic Parameters</a></li>
				</ul>
				<div id="civilparams">
				
					<form method="post" action="LoginController">
						<label class="label-control rowlebel " for="parameter1">parameter1</label> <br /> 
					<input  	type="text" class="form-control" id="parameter1" name="parameter1" 	placeholder="parameter1" required /> 
				<label class="label-control rowlebel " for="parameter2">parameter2</label> <br /> 
					<input  	type="text" class="form-control" id="parameter2" name="parameter2" 	placeholder="parameter2" required /> <br />
						<br />
					</form>
				</div>
				
				
				<div id="hydparams">
				
				<form method="post" action="LoginController">
						<label class="label-control rowlebel " for="parameter1">parameter5</label> <br /> 
					<input  	type="text" class="form-control" id="parameter1" name="parameter1" 	placeholder="parameter1" required /> 
				<label class="label-control rowlebel " for="parameter2">parameter6</label> <br /> 
					<input  	type="text" class="form-control" id="parameter2" name="parameter2" 	placeholder="parameter2" required /> 
					<br />
					
						 <br />
						 <button type="button" name="addres" id="addres" class="btn btn-1 btn-primary center-block" >Submit</button>
					</form>
				
				
				</div>
			</div>
		
	</div>
	

		</div> <!-- col-md-8 div -->
		
		 </div>	<!-- container div -->
	

	</div>	<!-- panel div -->
	

	

    
	
	
	<!-- data ends -->



<!--  dilogue starts -->

	
	
	

	
	
	
	
	
	
	
	
			

	






</div>
</div>

<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>




