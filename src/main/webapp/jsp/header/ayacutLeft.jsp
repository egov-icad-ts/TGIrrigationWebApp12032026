
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
				<h3 class="panel-title" style="color: #fff">Ayacut Information</h3>
			</div>

			<ul class="list-unstyled components">
  <c:if test="${userObj!=null && (userObj.userName!='icad_test' && userObj.userName!='cs_telangana') }">
				<li class="dropdown"><a href="#ayacutSubmenu"
					data-toggle="collapse" aria-expanded="true"
					class="dropdown-toggle"  style="background-color:  #33ccff ; color: #fff">Ayacut Input<b class="caret"></b></a>
					<ul class=" list-unstyled" id="ayacutSubmenu" style="font-size:12px">
						<li><a href="../comptsimis/compayacutinput">Add Ayacut</a></li>
						<li><a href="../comptsimis/deleteCompAyacut">Delete/Edit
								Ayacut</a></li>
							<li><a href="../comptsimis/cadkmlinput">Command Area KML </a></li>
								
					  <%--  <c:if test="${userObj.unitId==4 &&  userObj.circleId==0 && userObj.divisionId==0  }">	 --%>
					  <!-- <li><a href="../comptsimis/addProjcapacitySeasonal">Add Sciwam Info</a></li>		
						<li><a href="../comptsimis/addProjAyacutSeasonal">Add Sciwam Data</a></li> -->
                     <%--   </c:if> --%>
					</ul></li>
					</c:if>

				<li class="dropdown "><a href="#ayacutReportsSubmenu1"
					data-toggle="collapse" aria-expanded="true"
					class="dropdown-toggle" style="background-color: #33ccff; color: #fff">T.S. Ayacut Reports<b class="caret"></b></a>
					<ul class=" list-unstyled" id="ayacutReportsSubmenu1" style="font-size:12px">
						<li><a href="../compReport/getproject-ayacut-report">Project Wise CE's-Ayacut</a></li>
						<li><a href="../compReport/ce-ayacut">CE Wise Projects-Ayacut</a></li>
						<li><a href="../compReport/ce-district-ayacut">CE Wise Districts-Ayacut</a></li>
					  <c:if test="${userObj!=null &&  (userObj.userName!='icad_test' &&  userObj.userName!='cs_telangana') }">	
						<li><a href="../compReport/district-ayacut">District Wise Projects-Ayacut</a></li>
						<li><a href="../compReport/dist-man-proj-total">District wise Mandal wise Project -Ayacut</a></li>
						<li><a href="../compReport/proj-pack-man">Project Wise Package-Ayacut</a></li>
						<li><a href="../compReport/proj-man">Project Wise Mandal-Ayacut</a></li>
						<li><a href="../compReport/proj-man-village">Project Wise Mandal and Village-Ayacut</a></li>
						<li><a href="../compReport/getconsttotal-ayacut-report">Constituency Wise-Ayacut</a></li>
						<li><a href="../compReport/getjurisdiction-ayacut-report">Unit wise Circle wise Division-Ayacut</a></li>
						<li><a href="../compReport/getdivision-mandal-ayacut">Unit wise Circle wise Division wise Mandal-Ayacut</a></li>
                       </c:if>

					</ul></li>
					
					  <c:if test="${userObj!=null && (userObj.userName!='icad_test' && userObj.userName!='cs_telangana') }">

				<li class="dropdown " ><a href="#ayacutReportsSubmenu2"
					data-toggle="collapse" aria-expanded="true"
					class="dropdown-toggle" style="background-color:  #33ccff ; color: #fff">Area Wise Ayacut Reports<b
						class="caret"></b></a>
					<ul class=" list-unstyled" id="ayacutReportsSubmenu2" style="font-size:12px">

                        <li><a href="../compReport/unit-proj-mandal-ayacut">CE Wise-Project Wise-Constituency Wise-Ayacut</a></li>
                        <li><a href="../compReport/getconst-proj-ayacut-report">Constituency Wise Project-Ayacut</a></li>
						<li><a href="../compReport/getcomp-ayacut-report">Constituency Wise Mandal-Ayacut</a></li>
						<li><a href="../compReport/getvillage-byconst-ayacut">Constituency-Mandal-Village Wise-Ayacut</a></li>
						<li><a href="../compReport/dist-man-proj">District-Mandal-Project Wise-Ayacut</a></li>
						
						





					<!-- 	<li><a href="../compReport/getVillageAyacutReport">Constituency-Village
								Ayacut</a></li> -->
						
					

					


					</ul></li>
					</c:if>






			</ul>

		</nav>
	</div>
</div>

