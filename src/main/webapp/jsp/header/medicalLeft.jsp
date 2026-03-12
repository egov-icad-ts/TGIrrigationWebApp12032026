
<%@include file="/jsp/header/taglib_includes.jsp"%>
<script type="text/javascript">
$(document).ready(function () {

	
	 
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

});



</script>

<script type="text/javascript">
    	$(function(){
    		 var url = window.location.href; 

    		    // passes on every "a" tag 
    		    $("#sidebar a").each(function() {
    		            // checks if its the same on the address bar
    		        if(url == (this.href)) { 
    		        	$(this).closest("a").attr("aria-expanded",true);
    		        	$(this).closest("ul").attr("aria-expanded",true);
    		        	$(this).closest("ul").addClass("in");
    		        	
    		        
    		        	/* $(this).parent("a").attr("aria-expanded",true); */
    		        	
    		        	$(this).closest("ul ul").attr("aria-expanded",true);
    		        	
    		        	$(this).closest("ul ul").addClass("in");
    		        	
    		        	
    		            $(this).closest("li").addClass("active");
    		        }
    		    });
    	})
 </script>



<nav class="navbar navbar-expand-lg navbar-light bg-light"
	style="display: none">
	<div class="container-fluid">

		<button type="button" id="sidebarCollapse" class="btn btn-info">
			<i class="fas fa-align-left"></i> <span>Toggle Sidebar</span>
		</button>
	</div>
</nav>



<!-- Sidebar -->

<div class="col-md-3">
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
		<nav id="sidebar">
			<div class="sidebar-header">
				<h3 class="panel-title" style="color: #fff">Medical Bills</h3>
			</div>

			<ul class="list-unstyled components">

				<li class="dropdown"><a href="#ayacutSubmenu"
					data-toggle="collapse" aria-expanded="true"
					class="dropdown-toggle"  style="background-color:  #33ccff ; color: #fff">Medical Bills Input<b class="caret"></b></a>
					<ul class=" list-unstyled" id="ayacutSubmenu" style="font-size:12px">
						
					  <%--  <c:if test="${userObj.unitId==4 &&  userObj.circleId==0 && userObj.divisionId==0  }">	 --%>
  
                 <li ><a href="../invtsimis/medicalinputform">Medical Bills Employee Entry</a></li>
                  <li ><a href="../invtsimis/medical-forward-form">Medical Bills Sanction/Forward </a></li>
                   <li ><a href="../invtsimis/medical-auth-check-form">Medical Bills Authentication/Rules </a></li>
				
                
                     <%--   </c:if> --%>
					</ul></li>

				<li class="dropdown "><a href="#ayacutReportsSubmenu1"
					data-toggle="collapse" aria-expanded="true"
					class="dropdown-toggle" style="background-color: #33ccff; color: #fff">Medical Bills Reports<b class="caret"></b></a>
					<ul class=" list-unstyled" id="ayacutReportsSubmenu1" style="font-size:12px">
					
					
					 <li ><a href="../invReport/tank-form20-ab">Medical Bills Abstract</a></li>
                   <!--   <li ><a href="../invReport/res-ann2-abstract">Reservoir-Annexure2</a></li>
                     <li ><a href="../invReport/Schedule-Duty-Report">Reservoir-Schedule Duty Report</a></li> -->
 

					</ul></li>

	






			</ul>

		</nav>
	</div>
</div>

