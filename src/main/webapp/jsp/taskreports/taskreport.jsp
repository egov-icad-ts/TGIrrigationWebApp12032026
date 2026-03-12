
<%@include file="/jsp/header/taglib_includes.jsp"%> 
<script type="text/javascript" src="../js/chartist.min.js.map"></script>
<script type="text/javascript" src="../js/chartist.js"></script>
<script type="text/javascript" src="../js/chartist.min.js"></script>
<link rel="stylesheet" media="screen" href="../css/chartist.min.css">


<div class="w3l-main" id="borderStyle">
	 

	<div class="w3_agile_main_left">
		<!--start left block-->
		
		<div class="col-md-4 w3layouts-second">
		
		
		
	 
	<div class="col-md w3l-accordion-mk"> 
		 <div class="acrdn-top">
			<h4>Task Management Unit Wise</h4>
		</div>
	<!--  Accordion  -->
	 	<div class="ac-container agileits w3layouts"> 
			
			 <div>
				<input id="ac-5" name="accordion-1" type="checkbox" />
				<label for="ac-5" class="grid2"><i></i>CE(KRMR) projects </label>
				<article class="ac-small agileits w3layouts">
					 <ul>
						<li><a href="#"><label for="ac-5" class="grid2"><i></i>SYP Circle</label></a>
						<article class="ac-small agileits w3layouts">
						<ul>
						<li><a href="#">EE1</a></li>
						<li><a href="#">EE2</a></li>
						
					    </ul> 
					    </article>
						
						
						</li>
						<li><a href="#"><label for="ac-5" class="grid2"><i></i>IFFCC Circle</label></a>
						<article class="ac-small agileits w3layouts">
						<ul>
						<li><a href="#">EE1</a></li>
						<li><a href="#">EE2</a></li>
						
					    </ul> 
					    </article>
						
						
						
						</li>
						
					</ul> 
				</article>
			</div> 
			
			 <div>
				<input id="ac-7" name="accordion-1" type="checkbox" />
				<label for="ac-7" class="grid4"><i></i>Total Cases And Status</label>
				<article class="ac-small agileits w3layouts">
					<ul>
						<li><a href="#">Accordion 4 Sub Menu 1</a></li>
						<li><a href="#">Accordion 4 Sub Menu 2</a></li>
						<li><a href="#">Accordion 4 Sub Menu 3</a></li>
						<li><a href="#">Accordion 4 Sub Menu 4</a></li>
						<li><a href="#">Accordion 4 Sub Menu 5</a></li>
					</ul>
				</article>
			</div> 
			
			
			
		   
			
			 
			
			
		</div>
		<!-- //Accordion -->
	 </div>
	
	
	
		
			
			<!-- 9th-section -->
	
		</div>
		
		<!--end left block SAR-->
		<!--start main block SAR-->
		<div class="col-md-8 banner-top">
			
			<div class="clearfix"> </div>
			
				
	<!-- calendar -->
	<div class="clearfix"></div> 
	<!-- //calendar -->
	</div>
	
	
<!--end main block SAR-->


<!--start footer block SAR-->	
	
	
	
	
	

	
	
</div>
<!-- //main-content -->
</div>



<script type="text/javascript" src="../js/parsley.js"></script>
<link rel="stylesheet" media="screen" href="../css/parsley.css">
    
    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#userLogin').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			  //alert("coming here");
			  
			  var user=$("#userName").val();
				
				
					 document.forms.userLogin.action="../webtsimis/login";
					 document.forms.userLogin.submit(); 
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>
