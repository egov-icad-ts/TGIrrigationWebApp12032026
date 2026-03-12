
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



 <nav class="navbar navbar-expand-lg navbar-light bg-light" style="display:none">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-align-left"></i>
                    <span>Toggle Sidebar</span>
                </button>
            </div>
        </nav>



    <!-- Sidebar -->
    
   <div class="col-md-3"> 
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3 class="panel-title" style="color:#fff">TMS</h3>
        </div>

        <ul class="list-unstyled components">
            
         <!--    <li class="dropdown">
                <a href="#resSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">O&M Reservoirs<b class="caret"></b></a>
                <ul class="collapse list-unstyled" id="resSubmenu">
                    <li ><a href="../invtsimis/res-ann1">Reservoir-Annexure-I</a></li>
						       <li ><a href="../invtsimis/res-ann2">Reservoir-Annexure-II</a></li>
						     <li ><a href="../invtsimis/res-schedule-duties">Reservoir-Schedule of Duties</a></li>
                </ul>
            </li> -->
            
         <!--    <li class="dropdown ">
                <a href="#lisSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">O&M Lift Schemes<b class="caret"></b></a>
                <ul class="collapse list-unstyled" id="lisSubmenu">
                   	 <li ><a href="../invtsimis/omlift-input">Pump Station-Operation</a></li>
							 <li ><a href="../invtsimis/omlift-log1">Pumps Station-Data During Operation</a></li>
							
							<li ><a href="../invtsimis/omlift-maintain">Pump Station-Maintenance</a></li>
                </ul>
            </li> -->
            
           <!--   <li class="dropdown ">
                <a href="#canSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">O&M Canals<b class="caret"></b></a>
                <ul class="collapse list-unstyled" id="canSubmenu">
                    <li>
                        <a href="../invtsimis/canal-maintenance">Canal-Maintenance</a>
                    </li>
                   
                </ul>
            </li> -->
           <!-- added on 18-09-2021 by commenting below 6 lines -->
                      <li ><a href="../invtsimis/ommitank-input"> Tank Inspection 
                      <br>
                       (Data entry by AEE only) <br>
                       DEE/EE/SE can add remarks only. </a></li>
                       
                    <!--    <li ><a href="../invtsimis/tank-feed-add"> AddTank Feeding Details 
                      </a></li>
                      
                       <li ><a href="../invtsimis/tank-fed-get"> View Tank Feeding Details 
                      </a></li> -->
                
            <!-- on 18-09-2021    <li class="dropdown ">
                <a href="#miSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">O&M Irrigation Tanks<b class="caret"></b></a>
                <ul class="collapse list-unstyled" id="miSubmenu">
                      <li ><a href="../invtsimis/ommitank-input">Irrigation Tank-Checks</a></li>
                </ul>
            </li> -->
            
            
<%--             <c:if test="${ userObj.unitId==4 || userObj.unitId==9832 || userObj.unitId==9830  }">
            
                    	  <li class="dropdown " ><a href="#reptanks" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Form 20 Reports<b class="caret"></b></a>
                    	 
                    	 
                    	 
                    	    <ul class="collapse list-unstyled" id="reptanks">
                    	    
                    	     <li><a href="../invReport/tank-form20-district-ab">form20 District Abstract</a></li>
                    	    <!--    <li><a href="../invtsimis/mapbox-view">MAP View</a></li> -->
                    	    
                    	    </ul>
                    	 
                    	 
                    	 
                    	 </li> 
                    	 
                    	 </c:if> --%>
                <!--     <li class="dropdown " >
                        <a href="#repres" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">O&M Reservoir reports<b class="caret"></b></a>
                        
                         <ul class="collapse list-unstyled" id="repres">
                    	    
                    	     <li ><a href="../invReport/res-ann1-abstract">Reservoir-Annexure1</a></li>
                    	      <li ><a href="../invReport/res-ann2-abstract">Reservoir-Annexure2</a></li>
                    	      <li ><a href="../invReport/Schedule-Duty-Report">Reservoir-Schedule Duty Report</a></li>
                    	      
                    	     
                    	     
                    	    
                    	    </ul>
                    </li> -->
                    
                <!--     <li class="dropdown " >
                        <a href="#replis" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">O&M Lift Schemes reports<b class="caret"></b></a>
                        
                         <ul class="collapse list-unstyled" id="replis">
                    	    
                    	     <li ><a href="../invReport/pump-station-maintenance">Pump Station-Maintenance Report</a></li>
                    	      <li><a href="../invReport/pump-station-protocol">Pump Station-Protocol Report</a></li>
                    	    
                    	    </ul>
                    </li> -->
                    
                  <!--    <li class="dropdown " >
                        <a href="#repcan" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">O&M Canals reports<b class="caret"></b></a>
                        
                         <ul class="collapse list-unstyled" id="repcan">
                    	    
                    	     <li ><a href="#">Report1</a></li>
                    	      <li><a href="#">Report2</a></li>
                    	    
                    	    </ul>
                    </li> -->
                   
                </ul>
          
    </nav>
    </div>
    </div> 
    
      