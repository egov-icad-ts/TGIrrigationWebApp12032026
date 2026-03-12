
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
            <h3 class="panel-title" style="color:#fff">IR/CAG Paras</h3>
        </div>

        <ul class="list-unstyled components">
            
            <li class="dropdown">
                <a href="#irSubmenu" data-toggle="collapse" aria-expanded="true" class="dropdown-toggle" style="background-color:  #33ccff ; color: #fff">IR/CAG Paras Reports<b class="caret"></b></a>
                <ul class=" list-unstyled" id="irSubmenu" style="font-size:12px">
                
						         <li ><a href="../parasreport/parastatus">IR Paras abstract</a></li>
							<!-- <li ><a href="../parasreport/paraAbstractOffice">Paras Abstract Office</a></li> -->
							<li ><a href="../parasreport/parasDetailReply">IR Paras details</a></li>
							
							  <c:if test="${userObj!=null}">
							  <c:if test="${(userObj.unitId==9832 && userObj.circleId==21614 )|| ( userObj.unitId==4 ) || (userObj.unitId>0 && userObj.circleId==0 && userObj.divisionId==0 ) }"> 
                   <li ><a href="../parasreport/cagstatus">CAG Paras year wise abstract</a></li>
                      <c:if test="${userObj!=null && (userObj.userName!='icad_test' && userObj.userName!='cs_telangana') }">
                    <li ><a href="../parasreport/cagstatusyear">CAG Paras unit/Fy wise abstract </a></li>
                    </c:if>
					<li ><a href="../parasreport/cagstatusbyUnit">CAG Paras unit wise abstract</a></li> 
							 </c:if> 
							</c:if>
						      
						   
                </ul>
            </li>
            
            
              <c:if test="${userObj!=null && (userObj.userName!='icad_test' &&  userObj.userName!='cs_telangana' ) }">
             <li class="dropdown ">
                <a href="#cagSubmenu" data-toggle="collapse" aria-expanded="true" class="dropdown-toggle" style="background-color:  #33ccff ; color: #fff">IR/CAG Paras Add/Edit<b class="caret"></b></a>
                <ul class=" list-unstyled" id="cagSubmenu"  style="font-size:12px">
                
                
                  <li ><a href="../parastsimis/add-para-data">IR Paras</a></li>
                <c:if test="${userObj!=null}">
							
						 <c:if test="${(userObj.unitId==9832 && userObj.circleId==21614 )|| ( userObj.unitId==4 ) || (userObj.unitId>0 && userObj.circleId==0 && userObj.divisionId==0 ) }"> 
                   	 <li ><a href="../parastsimis/addCAGParaGist">CAG Paras Gist</a></li>
							 <li ><a href="../parastsimis/addCAGSubPara">CAG Para/Sub Para</a></li>
							 <li ><a href="../parastsimis/addcagreplydocs">CAG Reply/Docs</a></li> 
							
						</c:if> 
							</c:if>
							
							 <!--    <li ><a href="../parastsimis/addPara">Add Paras</a></li>
						       <li ><a href="../parastsimis/deleteirparas">Delete/Edit IR Paras</a></li> -->
						      
							
                </ul>
            </li> 
            </c:if>
             
           
        <%--    
           <li class="dropdown ">
                <a href="#cagReportsSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle" style="background-color:  #33ccff ; color: #fff">CAG Paras Reports<b class="caret"></b></a>
                <ul class="collapse list-unstyled" id="cagReportsSubmenu"  style="font-size:12px">
                     <c:if test="${userObj!=null}">
							  <c:if test="${(userObj.unitId==9832 && userObj.circleId==21614 )|| ( userObj.unitId==4 ) || (userObj.unitId>0 && userObj.circleId==0 && userObj.divisionId==0 ) }"> 
                   <li ><a href="../parasreport/cagstatus">CAG Paras year wise abstract</a></li>
                    <li ><a href="../parasreport/cagstatusyear">CAG Paras unit wise abstract </a></li>
							<!-- <li ><a href="../parasreport/cagparasDetailReply">CAG Paras Detail</a></li>  -->
							 </c:if> 
							</c:if>
                </ul>
            </li> 
              --%>
            
               
                    
                  
                   
                </ul>
          
    </nav>
    </div>
    </div> 
    
      