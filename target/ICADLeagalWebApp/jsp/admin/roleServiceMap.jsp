<!-- create component start here -->

<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css"/>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="../css/bootstrap-multiselect.css" type="text/css"/>


<script type="text/javascript">
    $(document).ready(function() {
        $('#userslist').multiselect();
    });
</script>

<div class='container'>

	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p>Project Name here</p>
		</div>
	</div>

	<div class="page">


<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Role User Service Mapping</h3>
			</div>
			
			<div class='container'>
		

<div class="col-md-3 "></div>

		<div class="row col-md-6 toppad ">





			<div class="row show-grid  ">
						<div class="col-md-5 rowlebel">
							<label class="label-controlPMS">
								<b>Select Role</b>
							</label>
						</div>
						<div class="col-md-6"><select class="form-control" id="project">
						<option value="C1">role1</option>
						<option value="C2">role2</option>
						

					</select></div>
					<div class="col-md-12 alert alert-info" role="alert">
        <strong>Note!</strong> Based on the Role Users list will get Displayed.
      </div>
					<div class="col-md-5 rowlebel">
							<label class="label-controlPMS">
								<b>Select User</b>
							</label>
						</div>
						<div class="col-md-6"><select class="form-control" id="userslist" multiple="multiple" >
						<option value="C1">user1</option>
						<option value="C2">user2</option>
						

					</select></div>

						
						
						
						
						

					</div>
					
					
					<div class="row show-grid   ">
						
	       <div class=" checkbox">
       
         <label class="checkbox-inline"> <input id="check1" type="checkbox"><b>Service 1</b></label>
        
   
          <label class="checkbox-inline">   <input id="check2" type="checkbox"><b>Service 2</b></label>
        
      
        
         <label class="checkbox-inline">    <input id="check3" type="checkbox"><b>Service 3</b></label>
       
      
        
           <label class="checkbox-inline">  <input id="check3" type="checkbox"><b>Enter Componnet Quantity</b></label>
       
      
       
          <label class="checkbox-inline">  <input id="check3" type="checkbox"><b> Enter Componnet </b></label>
        
     
        
         <label class="checkbox-inline">   <input id="check3" type="checkbox"><b> Enter Componnet </b></label>
       
      
        
          <label class="checkbox-inline">  <input id="check3" type="checkbox"><b> Carete User</b></label>
       
     
       
          <label class="checkbox-inline">  <input id="check3" type="checkbox"><b>MOP Generate</b></label>
        
      
        
          <label class="checkbox-inline">  <input id="check3" type="checkbox"><b>Bill Generate</b></label>
       
     
        
          <label class="checkbox-inline">  <input id="check3" type="checkbox"><b>Enter Componnet Quantity</b></label>
       
      </div>
						
						
						
						

					</div>
					
					
					
					
			
			



			












			<div class="row show-grid">
				<div class="col-md-12">
					<input type="submit" class="btn btn-1 btn-primary center-block"
						id="roleService" value="Role Service MAP">
				</div>
			</div>






		</div>
		<!-- row -->
		<div class="col-md-3 "></div>
                


		
		</div>
		
		
		</div> <!-- panel -->
		
		
		




	</div>
	<!-- page -->
</div>
<!-- container -->

<!-- create component ends here -->

