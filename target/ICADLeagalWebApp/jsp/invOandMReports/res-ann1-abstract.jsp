
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>

<title>Reservoir Checklist</title>

<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>

<script type="text/javascript" src="../js/invomReports/res_ann1_abs.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">

<script src="../js/newcharts/core.js"></script>
<script src="../js/newcharts/charts.js"></script>
<script src="../js/newcharts/animated.js"></script>













<link rel="stylesheet"
	href="../css/Html5DataTable/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href=" ../css/Html5DataTable/buttons.dataTables.min.css" />









<div class="col-md-9">




	<div>




		<div class="panel panel-primary" style="padding: 10px">
			<div class="panel-heading">
				<h3 class="panel-title">
					Pre/Post monsoon check list:Reservoir Inspection Report
					<c:if test="${userObj!=null}">
						<div class="span6 pull-right">

							Welcome to

							<c:if
								test="${userObj.employeeName!=null && userObj.employeeName!='NA'  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>

							</c:if>

							<c:if
								test="${userObj.designationName!=null && userObj.designationName!='NA'  }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>

							</c:if>
						</div>
						<br></br>
						<div class="span6 pull-right">

							<c:if
								test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">
								<c:if test="${userObj.unitId>0  }">
									<c:out value="${userObj.unitName}"></c:out>
								</c:if>
							</c:if>

							<c:if
								test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">
								<c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">
									<c:out value="${userObj.circleName}"></c:out>
								</c:if>
							</c:if>

							<c:if
								test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId==0  }">
								<c:if
									test="${userObj.unitId>0  &&  userObj.circleId>0  &&  userObj.divisionId>0 }">
									<c:out value="${userObj.divisionName}"></c:out>
								</c:if>
							</c:if>

							<c:if
								test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId!=0 }">
								<c:if
									test="${userObj.unitId>0 &&  userObj.circleId>0  &&  userObj.divisionId>0 &&  userObj.subdivisionId>0  }">
									<c:out value="${userObj.subdivisionName}"></c:out>
								</c:if>
							</c:if>

							<c:if
								test="${userObj.unitId==null && userObj.circleId==null && userObj.divisionId==null && userObj.subdivisionId==null }">

								<c:out value="${userObj.userName}"></c:out>

							</c:if>

						</div>
					</c:if>
					&emsp;&emsp;
				</h3>
			</div>




			<div class="panel-body">




				<div class="col-md-12  ">
					<form:form id="res1" method="post"
						modelAttribute="reservoirInspect1">


						<c:if test="${userObj!=null}">

							<input name="unitId" value="${userObj.unitId}"
								class=" form-control " id="uformUnitId" type="hidden" />
							<input name="circleId" value="${userObj.circleId}"
								class=" form-control " id="uformCircleId" type="hidden" />
							<input name="divisionId" value="${userObj.divisionId}"
								class=" form-control " id="uformDivisionId" type="hidden" />
							<input name="subdivisionId" value="${userObj.subdivisionId}"
								class=" form-control " id="uformSubdivisionId" type="hidden" />
							<input name="designationId" value="${userObj.designationId}"
								class=" form-control " id="uformdrilldesgId" type="hidden" />
							<input name="listDesignationId" class=" form-control "
								id="uformlistdesgId" type="hidden" />
							<input name="postId" value="${userObj.post}"
								class=" form-control " id="uformPostId" type="hidden" />
							<!--  <input name="tsfcFormYear"  class=" form-control " id="formyear1" type="hidden" /> -->
							<input name="offAccess" class=" form-control "
								id="uformOfficeAccess" type="hidden" />

							<input value="${userObj.designationId}" class=" form-control "
								id="uformDesignationId" type="hidden" />

						</c:if>




						<div class="col-md-12 invDiv">
							<div class="col-md-6">
								<label class="label-control rowlebel ">Select Frequency
									<font color=red>*</font>
								</label> <select class="form-control" id="dutyFrequencyId"
									name="dutyFrequencyId" required>
									<option value=" ">--select--</option>

									<option value="9">Pre Monsoon</option>
									<option value="10">Post Monsoon</option>

								</select>

							</div>

							<div class="col-md-6">

								<label class="label-control rowlebel ">Select Year <font
									color=red>*</font>
								</label> <select class="form-control" id="year" name="year" required
									onchange="getresabstractdata(this.value,dutyFrequencyId.value,'res1','true')">
									<option value=" ">--select--</option>
                                    
                                    
                                    
                                    <c:forEach items="${selectDamSafetyYear}" var="u">
									              <option value="${u.year}">${u.year}</option>

								</c:forEach>
								

								</select>
							</div>


						</div>



					</form:form>
				</div>

				<div id="abs1" class="col-md-12 ">

					<ul id="tmsreportstab">
						<li><a href="#tcab1" data-toggle="tab">Category Wise
								Abstract</a></li>
						<li><a href="#tcab2" data-toggle="tab">Condition Wise
								Abstract</a></li>


					</ul>
					<div id="tcab1" class="col-md-12 ">

						<form:form id="res22" method="post"
							modelAttribute="reservoirInspect1">

							<div class="col-md-12">
								<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Category wise
											Abstract</strong> <br> <strong style="color: #CA3F22">
											Note:Category1: Deficiencies which may lead to failure</strong> <br>
										<strong style="color: #CA3F22"> Note:Category2: Major
											Deficiencies required for prompt remediable measures</strong> <br>
										<strong style="color: #CA3F22"> Note:Category3: Minor
											remediable measures which are rectifiable during the year</strong>


									</div>
								</div>
							</div>

							<c:set var="frmdesg" scope="session"
								value="${userObj.designationId}" />
							<c:set var="frmoffacc" scope="session" value="1" />
							<c:set var="frmnewdesg" scope="session" value="1" />

							<input name="unitId" class=" form-control " id="frmtempUnitId2"
								type="hidden" />
							<input name="circleId" class=" form-control "
								id="frmtempCircleId2" type="hidden" />
							<input name="divisionId" class=" form-control "
								id="frmtempDivisionId2" type="hidden" />
							<input name="subdivisionId" class=" form-control "
								id="frmtempSubDivisionId2" type="hidden" />
							<input value="${frmoffacc}" name="offAccess"
								class=" form-control " id="frmtempOfficeAccess2" type="hidden" />
							<input name="postId" class=" form-control " id="frmtempPostId2"
								type="hidden" />
							<input name="designationId" value="${frmnewdesg}"
								class=" form-control " id="frmtempDesignationId2" type="hidden" />
							<input name="resInspectMst1Id" class=" form-control "
								id="formresInspectMst1Id2" type="hidden" />
							<!--  <input name="catId"    class=" form-control " id="frmcatId" type="hidden" /> -->
							<input name="sourceName" class=" form-control " id="sourceName2"
								type="hidden" />


							<input name=conditionofDamId id="conditionofDamId2" type=hidden>
							<input name=deficiencyCategory id="deficiencyCategory2"
								type=hidden>
							<!-- <input name=unitId id="unitId" type=hidden> -->

							<input name=year id="year2" type=hidden>
							<input name=dutyFrequencyId id="dutyFrequencyId2" type=hidden>

							<input name="userUnitId" value="${userObj.unitId}"
								class=" form-control " id="logincapUnitId2" type="hidden">
							<input name="userDesignationId" value="${userObj.designationId}"
								class=" form-control " id="loginfrm20designationId2"
								type="hidden" />
							<input name="backdesignationId" value="0" class=" form-control "
								id="frmbackdesgId2" type="hidden" />
							<input name="listDesignationId" class=" form-control "
								id="frmtemplistDesignationId2" type="hidden" />


							<input value="${totalcatres}" id="totalcatres2" type=hidden>
							<input value="${cattotalsubmitted}" id="cattotalsubmitted2"
								type=hidden>
							<input value="${catna}" id="catna2" type=hidden>
							<input value="${cat1}" id="cat12" type=hidden>
							<input value="${cat2}" id="cat22" type=hidden>
							<input value="${cat3}" id="cat32" type=hidden>



							<div class="col-md-12 show-grid gridList mainprint pagecontent"
								style="display: block">
								<div class="table-responsive" id="printarea">
									<br>
									<br> <br>
									<br>
									<table  id="data-table1"  class="tablenew display table-bordered"
										style="width: 100%" >
										<thead>

											<tr style="font-size: 12px">
												<th class="details-control sorting_disabled"
													style="width: 15px;" aria-label="" rowspan="1" colspan="1"></th>
												<th rowspan="1" colspan="1">Sl.No</th>
												<th rowspan="1" colspan="1">Name of Office</th>
												<th rowspan="1" colspan="1">Total Reservoirs</th>
												<th rowspan="1" colspan="1">Total Submitted</th>
												<th rowspan="1" colspan="1">To be Categorized</th>
												<th rowspan="1" colspan="1">Category1</th>
												<th rowspan="1" colspan="1">Category2</th>
												<th rowspan="1" colspan="1">Category3</th>

											</tr>
										</thead>

										<tbody>

											<tr>
												<td rowspan="1" colspan="1"></td>
												<c:choose>
													<c:when test="${invResCatList[0].dutyFrequencyId==9}">
														<td style="color: red; font-weight: bold;" rowspan="1"
															colspan="1"><c:out value="Pre monsoon"></c:out></td>
													</c:when>
													<c:when test="${invResCatList[0].dutyFrequencyId==10}">
														<td style="color: red; font-weight: bold;" rowspan="1"
															colspan="1"><c:out value="Post monsoon"></c:out></td>
													</c:when>
													<c:otherwise>
														<td rowspan="1" colspan="1"></td>

													</c:otherwise>
												</c:choose>

												<td style="color: red; font-weight: bold;" rowspan="1"
													colspan="1"><c:out value="${invResCatList[0].year}"></c:out></td>
												<td rowspan="1" colspan="1"></td>
												<td rowspan="1" colspan="1"></td>
												<td rowspan="1" colspan="1"></td>
												<td rowspan="1" colspan="1"></td>
												<td rowspan="1" colspan="1"></td>
												<td rowspan="1" colspan="1"></td>

											</tr>
											<c:forEach items="${invResCatList}" var="m"
												varStatus="mcount">
												<tr   data-child="${m.unitId}" style="font-size: 12px; text-align: center;" id="mainrow${m.unitId}">
													<td class="details-control" id="tdlist${m.unitId}"
														rowspan="1" colspan="1"><i class="fa fa-plus-square"
														aria-hidden="true"></i></td>

													<td class='sorting_1' style="text-align: center;"
														rowspan="1" colspan="1"><c:out
															value="${mcount.count}"></c:out></td>
													<c:if
														test="${frmdesgId==2 || frmdesgId==8 && frmsubdivId >0}">
														<td rowspan="1" colspan="1"><b><c:out
																	value="${m.postName}"></c:out></b></td>
													</c:if>
													<c:if
														test="${(frmdesgId==4 &&   frmsubdivId >0 ) && (frmpost!=1106177746 || frmpost!=932 || frmpost!=931 || frmpost!=921 || frmpost!=911) }">

														<td rowspan="1" colspan="1"><b><c:out
																	value="${m.postName}"></c:out></b></td>

													</c:if>

													<c:if
														test="${frmdesgId==5 && fmdivId>0 &&    frmsubdivId ==0}">

														<td rowspan="1" colspan="1"><b><c:out
																	value="${m.subdivisionName}"></c:out></b></td>

													</c:if>
													<c:if
														test="${frmdesgId==7 && frmunitId>0  && frmcircleId>0 && fmdivId==0 &&    frmsubdivId ==0}">

														<td rowspan="1" colspan="1"><b><c:out
																	value="${m.divisionName}"></c:out></b></td>

													</c:if>

													<c:choose>

														<c:when test="${frmOffAccess==3}">


															<c:if
																test="${(frmdesgId==9  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) ||
											  (frmdesgId==7  && m.unitId>0  && m.circleId==0 && m.divisionId==0 &&    m.subdivisionId ==0) }">



																<c:if
																	test="${(frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830 && frmunitId!=9) &&  (frmpost!=1106177746 || frmpost!=931 || frmpost!=932 || frmpost!=921 || frmpost!=911)  }">
																	<!--  This part of code executes when ENC A or I clicks on any unit name and designation Id becomes 9 or 7  onclick="getcatresunitlist('${m.unitId}')"-->
																	<%--   <c:out value="2 CE SE nt ENCA or I"></c:out> --%>
																	<%-- <td> <b><button type="button" name="resunitsee" id="catresuniteselist${qcount.count}" class="btn btn-1 btn-link center-block "    style="white-space:normal ; color: #451abb"    >  <c:out value="${m.unitName}"></c:out></button></b></td>  --%>
																	<td rowspan="1" colspan="1"
																		style="white-space: normal; color: #451abb"><b><c:out
																				value="${m.unitName}"></c:out></b></td>
																</c:if>


															</c:if>

														</c:when>

														<c:otherwise>
															<%-- 	<c:out value="not 3 CE SE nt ENCA or I"></c:out>   onclick="getcatresunitlist('${m.unitId}')" --%>

															<c:if
																test="${((frmdesgId==9)  && (frmunitId>0 &&  frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) &&  (frmpost!=1106177746 || frmpost!=932 || frmpost!=931 || frmpost!=921 || frmpost!=911))}">
																<%-- <c:out value="normal CE login"></c:out>  --%>
																<%-- <td> <b><button type="button" name="resunitsee" id="catresuniteselist${mcount.count}" class="btn btn-1 btn-link center-block "    style="white-space:normal ; color: #451abb"   >   <c:out value="${m.unitName}"></c:out></button></b></td> --%>

																<td rowspan="1" colspan="1"
																	style="white-space: normal; color: #451abb"><b><c:out
																			value="${m.unitName}"></c:out></b></td>

															</c:if>

														</c:otherwise>

													</c:choose>



													<c:choose>
														<c:when test="${frmOffAccess==3}">
															<c:if
																test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9   && m.unitId>0  && m.circleId==0 && m.divisionId==0 &&   m.subDivisionId ==0 ) ||  (frmpost==1106177746 || frmpost==931 || frmpost==932 || frmpost==921 || frmpost==911 ) ) }">




																<c:if test="${prefrm20desgId==null}">


																	<%-- <td>  <b><button type="button" name="resunitee" id="catresuniteelist${mcount.count}" class="btn btn-1 btn-link center-block "    style="white-space:normal; color: #451abb"   >   <b><c:out value="${m.unitName}"></c:out></b> </button></b> </td> --%>

																	<td rowspan="1" colspan="1"
																		style="white-space: normal; color: #451abb"><b><c:out
																				value="${m.unitName}"></c:out></b></td>


																</c:if>
																<c:if test="${prefrm20desgId!=null}">



																	<%-- <td>  <b><button type="button" name="resunitee" id="catresuniteelist${mcount.count}" class="btn btn-1 btn-link center-block "    style="white-space:normal; color: #451abb"    >   <b><c:out value="${m.unitName}"></c:out></b></button></b> </td> --%>
																	<td rowspan="1" colspan="1"
																		style="white-space: normal; color: #451abb"><b><c:out
																				value="${m.unitName}"></c:out></b></td>

																</c:if>
															</c:if>
														</c:when>
														<c:otherwise>

															<c:if
																test="${(frmdesgId==10  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0)}">

																<%-- <td>  <b><button type="button" name="resunitee" id="catresuniteelist${mcount.count}" class="btn btn-1 btn-link center-block "    style="white-space:normal; color: #451abb "    >   <b><c:out value="${m.unitName}"></c:out></b> </button></b> </td> --%>
																<td rowspan="1" colspan="1"
																	style="white-space: normal; color: #451abb"><b><c:out
																			value="${m.unitName}"></c:out></b></td>
															</c:if>

														</c:otherwise>


													</c:choose>
													<c:choose>

														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (m.resTotalCount>0) }">
															<td rowspan="1" colspan="1"><b><button
																		type="button" name="reson"
																		id="catrestot${mcount.count}"
																		class="btn btn-1 btn-link center-block "
																		style="white-space: normal; color: blue"
																		onclick="getresann1totalres('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',0, 'res22' )">
																		<b><c:out value="${m.resTotalCount}"></c:out></b>
																	</button></b></td>
														</c:when>
														<c:otherwise>
															<td rowspan="1" colspan="1"><b><button
																		type="button" name="reson"
																		id="catrestot${mcount.count}"
																		class="btn btn-1 btn-link center-block "
																		style="white-space: normal; color: blue"
																		onclick="getresann1totalres('${m.year }','${m.dutyFrequencyId}','${frmListdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',0, 'res22' )">
																		<b><c:out value="${m.resTotalCount}"></c:out></b>
																	</button></b></td>
														</c:otherwise>
														<%--  <c:otherwise>
										 <td style="text-align: center;"><c:out value="${t.resSubmittedCount}"></c:out></td>
										 </c:otherwise> --%>
													</c:choose>



													<c:choose>

														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (m.resSubmittedCount>0) }">
															<td rowspan="1" colspan="1"><b><button
																		type="button" name="reson"
																		id="catreson${mcount.count}"
																		class="btn btn-1 btn-link center-block "
																		style="white-space: normal; color: green"
																		onclick="getresann1details('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',0, 'res22' )">
																		<b><c:out value="${m.resSubmittedCount}"></c:out></b>
																	</button></b></td>
														</c:when>
														<c:when test="${ m.resSubmittedCount>0}">
															<td rowspan="1" colspan="1"><b><button
																		type="button" name="reson"
																		id="catreson${mcount.count}"
																		class="btn btn-1 btn-link center-block "
																		style="white-space: normal; color: green"
																		onclick="getresann1details('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',0, 'res22' )">
																		<b><c:out value="${m.resSubmittedCount}"></c:out></b>
																	</button></b></td>
														</c:when>
														<c:otherwise>
															<td rowspan="1" colspan="1"><b><c:out
																		value="${m.resSubmittedCount}"></c:out></b></td>
														</c:otherwise>
														<%--  <c:otherwise>
										 <td style="text-align: center;"><c:out value="${t.resSubmittedCount}"></c:out></td>
										 </c:otherwise> --%>
													</c:choose>

													<%-- <td style="color: maroon"><b><c:out value="${m.categoryNA}"></c:out></b></td> --%>
													<c:choose>
														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (m.categoryNA>0) }">

															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="catresun${mcount.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #FFA500"
																	onclick="getrescategorydetails('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',${m.categoryId4}, 'res22' )">
																	<b><c:out value="${m.categoryNA}"></c:out></b>
																</button></td>


														</c:when>

														<c:when test="${m.categoryNA>0}">
															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="catresun${mcount.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #FFA500"
																	onclick="getrescategorydetails('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',${m.categoryId4}, 'res22' )">
																	<b><c:out value="${m.categoryNA}"></c:out></b>
																</button></td>
														</c:when>
														<c:otherwise>
															<td rowspan="1" colspan="1"><b><c:out
																		value="${m.categoryNA}"></c:out></b></td>
														</c:otherwise>
													</c:choose>

													<%-- 	<td style="color: blue"><b><c:out value="${m.category1}"></c:out></b></td> --%>

													<c:choose>
														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (m.category1>0) }">

															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="catrespo${mcount.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: red"
																	onclick="getrescategorydetails('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',${m.categoryId1}, 'res22' )">
																	<b><c:out value="${m.category1}"></c:out></b>
																</button></td>


														</c:when>

														<c:when test="${m.category1>0}">
															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="catrespo${mcount.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: red"
																	onclick="getrescategorydetails('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',${m.categoryId1}, 'res22' )">
																	<b><c:out value="${m.category1}"></c:out></b>
																</button></td>
														</c:when>

														<c:otherwise>
															<td rowspan="1" colspan="1"><b><c:out
																		value="${m.category1}"></c:out></b></td>
														</c:otherwise>
													</c:choose>

													<%-- 	<td style="color: green"><b><c:out value="${m.category2}"></c:out></b></td> --%>

													<c:choose>
														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (m.category2>0) }">

															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="catresfa${mcount.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #9ACD32"
																	onclick="getrescategorydetails('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',${m.categoryId2}, 'res22' )">
																	<b><c:out value="${m.category2}"></c:out></b>
																</button></td>


														</c:when>

														<c:when test="${m.category2>0}">
															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="catresfa${mcount.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #9ACD32"
																	onclick="getrescategorydetails('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',${m.categoryId2}, 'res22' )">
																	<b><c:out value="${m.category2}"></c:out></b>
																</button></td>
														</c:when>
														<c:otherwise>
															<td rowspan="1" colspan="1"><b><c:out
																		value="${m.category2}"></c:out></b></td>
														</c:otherwise>
													</c:choose>

													<%-- <td ><b><c:out value="${m.category3}"></c:out></b></td> --%>

													<c:choose>
														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (m.category3>0) }">

															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="catressa${mcount.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #2E8B57"
																	onclick="getrescategorydetails('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',${m.categoryId3}, 'res22' )">
																	<b><c:out value="${m.category3}"></c:out></b>
																</button></td>


														</c:when>
														<c:when test="${m.category3>0}">
															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="catressa${mcount.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #2E8B57"
																	onclick="getrescategorydetails('${m.year }','${m.dutyFrequencyId}','${frmdesgId}','${m.unitId}','${m.circleId}','${m.divisionId}','${m.subdivisionId}','${m.postId}',${m.categoryId3}, 'res22' )">
																	<b><c:out value="${m.category3}"></c:out></b>
																</button></td>
														</c:when>
														<c:otherwise>
															<td rowspan="1" colspan="1"><b><c:out
																		value="${m.category3}"></c:out></b></td>
														</c:otherwise>
													</c:choose>
													<%-- <td><b><c:out value="${t.resPoor}"></c:out></b></td>
												<td><b><c:out value="${t.resFair}"></c:out></b></td>
												<td><b><c:out value="${t.resSatisfactory}"></c:out></b></td> --%>




												</tr>

												<!-- start cat ee list  -->






												<c:set var="snnores" scope="page" value="1" />
												<c:set var="ndivisioninfo" value="0" scope="page" />


												<c:if test="${invResCatListEE!=null}">

													<%-- <tr>

														<td rowspan="1" colspan="9">
															<table class="tablech display table-bordered"
																style="width: 100%" id="tablechild${m.unitId}"> --%>
																<!-- <thead>
																	<tr>
																		<th rowspan="1" colspan="1"></th>
																		<th rowspan="1" colspan="1">Sl.No</th>
																		<th rowspan="1" colspan="1">Name of Office</th>
																		<th rowspan="1" colspan="1">Total Reservoirs</th>
																		<th rowspan="1" colspan="1">Total Submitted</th>
																		<th rowspan="1" colspan="1">To be Categorized</th>
																		<th rowspan="1" colspan="1">Category1</th>
																		<th rowspan="1" colspan="1">Category2</th>
																		<th rowspan="1" colspan="1">Category3</th>
																	</tr>
																</thead> -->
															<!-- 	<tbody> -->


																	<c:set var="nnores" scope="page" value="1" />
																	<c:forEach items="${invResCatListEE}" var="n"
																		varStatus="ncount">









																		<c:if
																			test="${((m.unitId==n.unitId)&&(n.divisionId!=ndivisioninfo) )}">

																			<c:set var="snnores" scope="page"
																				value="${nnores+1 }" />






																			<tr style="font-size: 12px; text-align: center;"    class="tablech  eerow${m.unitId}"
																				id="eelist${m.unitId }${m.circleId }${n.divisionId}"
																				class="cateeinf   catlist${m.unitId}    ">
																				<td rowspan="1" colspan="1">--</td>
																				<td rowspan="1" colspan="1"
																					style="text-align: center;">${nnores}</td>
																				<c:if
																					test="${frmdesgId==2 || frmdesgId==8 && frmsubdivId >0}">
																					<td rowspan="1" colspan="1"><b><c:out
																								value="${n.postName}"></c:out></b></td>
																				</c:if>
																				<c:if
																					test="${(frmdesgId==4 &&   frmsubdivId >0 ) && (frmpost!=1106177746 || frmpost!=932 || frmpost!=931 || frmpost!=921 || frmpost!=911) }">

																					<td rowspan="1" colspan="1"><b><c:out
																								value="${n.postName}"></c:out></b></td>

																				</c:if>

																				<c:if
																					test="${frmdesgId==5 && fmdivId>0 &&    frmsubdivId ==0}">

																					<td rowspan="1" colspan="1"><b><c:out
																								value="${n.subdivisionName}"></c:out></b></td>

																				</c:if>
																				<c:if
																					test="${frmdesgId==7 && frmunitId>0  && frmcircleId>0 && fmdivId==0 &&    frmsubdivId ==0}">

																					<td rowspan="1" colspan="1"><b><c:out
																								value="${n.divisionName}"></c:out></b></td>


																				</c:if>



																				<c:choose>

																					<c:when test="${frmOffAccess==3}">


																						<c:if
																							test="${(frmdesgId==9  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) ||
											  (frmdesgId==7  && m.unitId>0  && m.circleId==0 && m.divisionId==0 &&    m.subdivisionId ==0) }">



																							<c:if
																								test="${(frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830 && frmunitId!=9) &&  (frmpost!=1106177746 || frmpost!=931 || frmpost!=932 || frmpost!=921 || frmpost!=911)  }">
																								<!--  This part of code executes when ENC A or I clicks on any unit name and designation Id becomes 9 or 7 -->
																								<%--   <c:out value="2 CE SE nt ENCA or I"></c:out> --%>
																								<td rowspan="1" colspan="1"><b><c:out
																											value="${n.divisionName}"></c:out></b></td>
																							</c:if>


																						</c:if>

																					</c:when>

																					<c:otherwise>
																						<%-- 	<c:out value="not 3 CE SE nt ENCA or I"></c:out>  --%>

																						<c:if
																							test="${((frmdesgId==9)  && (frmunitId>0 &&  frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) &&  (frmpost!=1106177746 || frmpost!=932 || frmpost!=931 || frmpost!=921 || frmpost!=911))}">
																							<%-- <c:out value="normal CE login"></c:out>  --%>

																							<td rowspan="1" colspan="1"><b><c:out
																										value="${n.divisionName}"></c:out></b></td>

																						</c:if>

																					</c:otherwise>

																				</c:choose>



																				<c:choose>
																					<c:when test="${frmOffAccess==3}">
																						<c:if
																							test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9  && ( m.unitId==m.unitId) && m.unitId>0  && m.circleId==0 && m.divisionId==0 &&   m.subDivisionId ==0 ) ||  (frmpost==1106177746 || frmpost==931 || frmpost==932 || frmpost==921 || frmpost==911 ) ) }">


																							<c:set var="ndivisioninfo"
																								value="${n.divisionId }" scope="page" />



																							<c:if test="${prefrm20desgId==null}">






																								<td rowspan="1" colspan="1" style="color: black">
																									<b><c:out value="${n.divisionName}"></c:out></b>
																								</td>


																							</c:if>
																							<c:if test="${prefrm20desgId!=null}">



																								<td rowspan="1" colspan="1" style="color: black">
																									<b><c:out value="${n.divisionName}"></c:out></b>
																								</td>

																							</c:if>
																						</c:if>
																					</c:when>
																					<c:otherwise>

																						<c:if
																							test="${(( m.unitId==n.unitId))&&(frmdesgId==10  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0)}">




																							<td rowspan="1" colspan="1" style="color: black">
																								<b><c:out value="${n.divisionName}"></c:out></b>
																							</td>

																						</c:if>

																					</c:otherwise>


																				</c:choose>
																				<c:choose>

																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (n.resTotalCount>0) }">
																						<td rowspan="1" colspan="1"><b><button
																									type="button" name="resonee"
																									id="catrestotee${count.count}"
																									class="btn btn-1 btn-link center-block "
																									style="white-space: normal; color: blue"
																									onclick="getresann1totalres('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}',0, 'res22' )">
																									<b><c:out value="${n.resTotalCount}"></c:out></b>
																								</button></b></td>
																					</c:when>
																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><button
																									type="button" name="resonee"
																									id="catrestotee${count.count}"
																									class="btn btn-1 btn-link center-block "
																									style="white-space: normal; color: blue"
																									onclick="getresann1totalres('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}',0, 'res22' )">
																									<b><c:out value="${n.resTotalCount}"></c:out></b>
																								</button></b></td>
																					</c:otherwise>
																					<%--  <c:otherwise>
										 <td style="text-align: center;"><c:out value="${t.resSubmittedCount}"></c:out></td>
										 </c:otherwise> --%>
																				</c:choose>



																				<c:choose>

																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (n.resSubmittedCount>0) }">
																						<td rowspan="1" colspan="1"><b><button
																									type="button" name="resonee"
																									id="catresonee${count.count}"
																									class="btn btn-1  btn-link center-block "
																									style="white-space: normal; color: green"
																									onclick="getresann1details('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}',0, 'res22' )">
																									<b><c:out value="${n.resSubmittedCount}"></c:out></b>
																								</button></b></td>
																					</c:when>

																					<c:when test="${ (n.resSubmittedCount>0) }">
																						<td rowspan="1" colspan="1"><b><button
																									type="button" name="resonee"
																									id="catresonee${count.count}"
																									class="btn btn-1  btn-link center-block "
																									style="white-space: normal; color: green"
																									onclick="getresann1details('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}',0, 'res22' )">
																									<b><c:out value="${n.resSubmittedCount}"></c:out></b>
																								</button></b></td>
																					</c:when>
																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><c:out
																									value="${n.resSubmittedCount}"></c:out></b></td>
																					</c:otherwise>
																					<%--  <c:otherwise>
										 <td style="text-align: center;"><c:out value="${t.resSubmittedCount}"></c:out></td>
										 </c:otherwise> --%>
																				</c:choose>


																				<c:choose>
																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (n.categoryNA>0) }">

																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="catresunee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #FFA500"
																								onclick="getrescategorydetails('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}','${n.categoryId4}', 'res22' )">
																								<b><c:out value="${n.categoryNA}"></c:out></b>
																							</button></td>


																					</c:when>

																					<c:when test="${n.categoryNA>0}">
																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="catresunee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #FFA500"
																								onclick="getrescategorydetails('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}','${n.categoryId4}', 'res22' )">
																								<b><c:out value="${n.categoryNA}"></c:out></b>
																							</button></td>
																					</c:when>
																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><c:out
																									value="${n.categoryNA}"></c:out></b></td>
																					</c:otherwise>
																				</c:choose>

																				<c:choose>
																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (n.category1>0) }">

																						<td rowspan="1" colspan="1">
																							<button type="button" name="resonee"
																								id="catrespoee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: red"
																								onclick="getrescategorydetails('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}','${n.categoryId1}', 'res22' )">
																								<b><c:out value="${n.category1}"></c:out></b>
																							</button>
																						</td>


																					</c:when>

																					<c:when test="${n.category1>0}">
																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="catrespoee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: red"
																								onclick="getrescategorydetails('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}','${n.categoryId1}', 'res22' )">
																								<b><c:out value="${n.category1}"></c:out></b>
																							</button></td>
																					</c:when>

																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><c:out
																									value="${n.category1}"></c:out></b></td>
																					</c:otherwise>
																				</c:choose>

																				<c:choose>
																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (n.category2>0) }">

																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="catresfaee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #9ACD32"
																								onclick="getrescategorydetails('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}','${n.categoryId2}', 'res22' )">
																								<b><c:out value="${n.category2}"></c:out></b>
																							</button></td>


																					</c:when>

																					<c:when test="${n.category2>0}">
																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="catresfaee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #9ACD32"
																								onclick="getrescategorydetails('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}','${n.categoryId2}', 'res22' )">
																								<b><c:out value="${n.category2}"></c:out></b>
																							</button></td>
																					</c:when>
																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><c:out
																									value="${n.category2}"></c:out></b></td>
																					</c:otherwise>
																				</c:choose>

																				<c:choose>
																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (n.category3>0) }">

																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="catressaee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #2E8B57"
																								onclick="getrescategorydetails('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}','${n.categoryId3}', 'res22' )">
																								<b><c:out value="${n.category3}"></c:out></b>
																							</button></td>


																					</c:when>
																					<c:when test="${n.category3>0}">
																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="catressaee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #2E8B57"
																								onclick="getrescategorydetails('${n.year }','${n.dutyFrequencyId}','5','${n.unitId}','${n.circleId}','${n.divisionId}','${n.subdivisionId}','${n.postId}','${n.categoryId3}', 'res22' )">
																								<b><c:out value="${n.category3}"></c:out></b>
																							</button></td>
																					</c:when>
																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><c:out
																									value="${n.category3}"></c:out></b></td>
																					</c:otherwise>
																				</c:choose>

																			</tr>

																			<c:set var="nnores" scope="page" value="${nnores+1}" />


																		</c:if>









																	</c:forEach>


															<!-- 	</tbody>

															</table>
														</td>


													</tr>
 -->




												</c:if>











												<!-- end cat eelist  -->



											</c:forEach>



											<tr style="color: red; font-weight: bold; font-size: 16px;">
												<td rowspan="1" colspan="1"
													
													style="width: 15px;" aria-label=""></td>
												<td rowspan="1" colspan="1">Total Reservoirs</td>
												<td style="text-align: center;">Total</td>
												<c:choose>
													<c:when test="${(frmdesgId==10) }">
														<td rowspan="1" colspan="1" style="text-align: center;">
															<button type="button" name="reson" id="catrestotals"
																class="btn btn-1 btn-link center-block "
																style="white-space: normal; color: blue"
																onclick="getresALLann1totalres('${ryear }','${rdutyFrequencyId}','${frmdesgId}','${runitId}','${rcircleId}','${rdivisionId}','${rsubdivisionId}','${rpost}',0, 'res22' )">
																<b><c:out value="${totalcatres}"></c:out></b>
															</button>
														</td>
													</c:when>
													<c:otherwise>
														<td rowspan="1" colspan="1"
															style="text-align: center; color: red"><b><c:out
																	value="${totalcatres}"></c:out></b></td>

													</c:otherwise>
												</c:choose>
												<td rowspan="1" colspan="1" style="text-align: center;"><b>
														<c:out value="${cattotalsubmitted}"></c:out>
												</b></td>

												<td rowspan="1" colspan="1" style="text-align: center;"><b>
														<c:out value="${catna}"></c:out>
												</b></td>
												<td rowspan="1" colspan="1" style="text-align: center;"><b>
														<c:out value="${cat1}"></c:out>
												</b></td>
												<td rowspan="1" colspan="1" style="text-align: center;"><b>
														<c:out value="${cat2}"></c:out>
												</b></td>
												<td rowspan="1" colspan="1" style="text-align: center;"><b>
														<c:out value="${cat3}"></c:out>
												</b></td>


											</tr>

										</tbody>



									</table>
								</div>
							</div>


						</form:form>

					</div>
					<div id="tcab2" class="col-md-12 ">
						<form:form id="res2" method="post"
							modelAttribute="reservoirInspect1">

							<div class="col-md-12">
								<div class="row show-grid ">
									<div class="alert alert-info" role="alert">
										<strong style="color: #CA3F22"> Note: Condition wise
											Abstract</strong> <br> <br> <strong> Note:
											Unsatisfactory : A dam safety deficiency is recognized that
											requires immediate or emergency remedial action for problem
											resolution.</strong> <br> <br> <strong> Note: Poor
											: A dam safety deficiency is recognized for loading
											conditions which may realistically occur. Remedial action is
											necessary. Poor may also be used when uncertainties exist as
											to critical analysis parameters which identify a potential
											dam safety deficiency. Further investigations and studies are
											necessary.</strong> <br> <br> <strong> Note: Fair
											: No existing dam safety deficiencies are recognized for
											normal loading conditions. Rare or extreme hydrologic and /
											or seismic events may result in a dam safety deficiency. Risk
											may be in the range to take further action.</strong> <br> <br>
										<strong> Note: Satisfactory : No existing or
											potential dam safety deficiencies are recognized. Acceptable
											performance is expected under all loading conditions (static,
											hydrologic,seismic) in accordance with the applicable
											regulatory criteria or tolerable risk guidelines.</strong> <br>




									</div>
								</div>
							</div>

							<c:set var="frmdesg" scope="session"
								value="${userObj.designationId}" />
							<c:set var="frmoffacc" scope="session" value="1" />
							<c:set var="frmnewdesg" scope="session" value="1" />

							<!--   <input name="tsfcFormYear"  class=" form-control " id="frmyear" type="hidden" /> -->

							<input name="unitId" class=" form-control " id="frmtempUnitId"
								type="hidden" />
							<input name="circleId" class=" form-control "
								id="frmtempCircleId" type="hidden" />
							<input name="divisionId" class=" form-control "
								id="frmtempDivisionId" type="hidden" />
							<input name="subdivisionId" class=" form-control "
								id="frmtempSubDivisionId" type="hidden" />
							<input value="${frmoffacc}" name="offAccess"
								class=" form-control " id="frmtempOfficeAccess" type="hidden" />
							<input name="postId" class=" form-control " id="frmtempPostId"
								type="hidden" />
							<input name="designationId" value="${frmnewdesg}"
								class=" form-control " id="frmtempDesignationId" type="hidden" />
							<input name="resInspectMst1Id" class=" form-control "
								id="formresInspectMst1Id" type="hidden" />
							<!--  <input name="catId"    class=" form-control " id="frmcatId" type="hidden" /> -->
							<input name="sourceName" class=" form-control " id="sourceName"
								type="hidden" />


							<input name=conditionofDamId id="conditionofDamId" type=hidden>
							<input name=deficiencyCategory id="deficiencyCategory"
								type=hidden>
							<!-- <input name=unitId id="unitId" type=hidden> -->

							<input name=year id="year1" type=hidden>
							<input name=dutyFrequencyId id="dutyFrequencyId1" type=hidden>

							<input name="userUnitId" value="${userObj.unitId}"
								class=" form-control " id="logincapUnitId" type="hidden">
							<input name="userDesignationId" value="${userObj.designationId}"
								class=" form-control " id="loginfrm20designationId"
								type="hidden" />
							<input name="backdesignationId" value="0" class=" form-control "
								id="frmbackdesgId" type="hidden" />
							<input name="listDesignationId" class=" form-control "
								id="frmtemplistDesignationId" type="hidden" />


							<input value="${totalres}" id="totalres" type=hidden>
							<input value="${restotalsubmitted}" id="restotalsubmitted"
								type=hidden>
							<input value="${resunsatisfactory}" id="resunsatisfactory"
								type=hidden>
							<input value="${respoor}" id="respoor" type=hidden>
							<input value="${resfair}" id="resfair" type=hidden>
							<input value="${ressatisfactory}" id="ressatisfactory"
								type=hidden>



							<%--  <c:if test="${totalres!=0}">
		<div class="col-md-12 show-grid gridList">	
		<br><br>
		<div id="chartdiv">
		
		</div>
		
		<br><br>
		</div>
		</c:if>  --%>


							<div class="col-md-12 show-grid gridList mainprint pagecontent"
								style="display: block">
								<div class="table-responsive" id="printarea">
									<br>
									<br> <br>
									<br>
									<table class="tablenew display table-bordered"
										style="width: 100%" id="data-table2">
										<thead>

											<tr style="font-size: 12px">
												<th rowspan="1" colspan="1"
													class="details-control sorting_disabled"
													style="width: 15px;" aria-label=""></th>
												<th rowspan="1" colspan="1">Sl.No</th>
												<th rowspan="1" colspan="1">Name of Office</th>
												<th rowspan="1" colspan="1">Total Reservoirs</th>
												<th rowspan="1" colspan="1">Total Submitted</th>
												<th rowspan="1" colspan="1">Unsatisfactory</th>
												<th rowspan="1" colspan="1">Poor</th>
												<th rowspan="1" colspan="1">Fair</th>
												<th rowspan="1" colspan="1">Satisfactory</th>


												<!--  <th>Ongoing </th> -->
												<!--	<th>Completed</th> -->

											</tr>

										</thead>
										<tbody>
											<tr>
												<td rowspan="1" colspan="1"></td>
												<c:choose>
													<c:when test="${invResList[0].dutyFrequencyId==9}">
														<td rowspan="1" colspan="1"
															style="color: red; font-weight: bold;"><c:out
																value="Pre monsoon"></c:out></td>
													</c:when>
													<c:when test="${invResList[0].dutyFrequencyId==10}">
														<td rowspan="1" colspan="1"
															style="color: red; font-weight: bold;"><c:out
																value="Post monsoon"></c:out></td>
													</c:when>
													<c:otherwise>
														<td rowspan="1" colspan="1"></td>
													</c:otherwise>
												</c:choose>
												<td rowspan="1" colspan="1"
													style="color: red; font-weight: bold;"><c:out
														value="${invResList[0].year}"></c:out></td>
												<td rowspan="1" colspan="1"></td>
												<td rowspan="1" colspan="1"></td>
												<td rowspan="1" colspan="1"></td>
												<td rowspan="1" colspan="1"></td>
												<td rowspan="1" colspan="1"></td>
												<td rowspan="1" colspan="1"></td>

											</tr>

											<c:forEach items="${invResList}" var="t" varStatus="count">


												<tr style="font-size: 12px; text-align: center;"  id="parentmainrow${t.unitId}">

													<td rowspan="1" colspan="1" class="details-control"
														id="tdlist${t.unitId}"><i class="fa fa-plus-square"
														aria-hidden="true"></i></td>

													<td rowspan="1" colspan="1" style="text-align: center;"><c:out
															value="${count.count}"></c:out></td>
													<c:if
														test="${frmdesgId==2 || frmdesgId==8 && frmsubdivId >0}">
														<td rowspan="1" colspan="1"><b><c:out
																	value="${t.postName}"></c:out></b></td>
													</c:if>
													<c:if
														test="${(frmdesgId==4 &&   frmsubdivId >0 ) && (frmpost!=1106177746 || frmpost!=932 || frmpost!=931 || frmpost!=921 || frmpost!=911) }">

														<td rowspan="1" colspan="1"><b><c:out
																	value="${t.postName}"></c:out></b></td>

													</c:if>

													<c:if
														test="${frmdesgId==5 && fmdivId>0 &&    frmsubdivId ==0}">

														<td rowspan="1" colspan="1"><b><c:out
																	value="${t.subdivisionName}"></c:out></b></td>

													</c:if>
													<c:if
														test="${frmdesgId==7 && frmunitId>0  && frmcircleId>0 && fmdivId==0 &&    frmsubdivId ==0}">

														<td rowspan="1" colspan="1"><b><c:out
																	value="${t.divisionName}"></c:out></b></td>

													</c:if>

													<c:choose>

														<c:when test="${frmOffAccess==3}">


															<c:if
																test="${(frmdesgId==9  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) ||
											  (frmdesgId==7  && t.unitId>0  && t.circleId==0 && t.divisionId==0 &&    t.subdivisionId ==0) }">



																<c:if
																	test="${(frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830 && frmunitId!=9) &&  (frmpost!=1106177746 || frmpost!=931 || frmpost!=932 || frmpost!=921 || frmpost!=911)  }">
																	<!--  This part of code executes when ENC A or I clicks on any unit name and designation Id becomes 9 or 7  onclick="getresunitlist('${t.unitId}')" -->
																	<%--   <c:out value="2 CE SE nt ENCA or I"></c:out> --%>
																	<td rowspan="1" colspan="1"><b><button
																				type="button" name="resunitsee"
																				id="resuniteselist${count.count}"
																				class="btn btn-1 btn-link center-block "
																				style="white-space: normal; color: #451abb">
																				<c:out value="${t.unitName}"></c:out>
																			</button></b></td>

																</c:if>


															</c:if>

														</c:when>

														<c:otherwise>
															<%-- 	<c:out value="not 3 CE SE nt ENCA or I"></c:out> onclick="getresunitlist('${t.unitId}')"  --%>

															<c:if
																test="${((frmdesgId==9)  && (frmunitId>0 &&  frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) &&  (frmpost!=1106177746 || frmpost!=932 || frmpost!=931 || frmpost!=921 || frmpost!=911))}">
																<%-- <c:out value="normal CE login"></c:out>  --%>
																<td rowspan="1" colspan="1"><b><button
																			type="button" name="resunitsee"
																			id="resuniteselist${count.count}"
																			class="btn btn-1 btn-link center-block "
																			style="white-space: normal; color: #451abb">
																			<c:out value="${t.unitName}"></c:out>
																		</button></b></td>



															</c:if>

														</c:otherwise>

													</c:choose>



													<c:choose>
														<c:when test="${frmOffAccess==3}">
															<c:if
																test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9   && t.unitId>0  && t.circleId==0 && t.divisionId==0 &&   t.subDivisionId ==0 ) ||  (frmpost==1106177746 || frmpost==931 || frmpost==932 || frmpost==921 || frmpost==911 ) ) }">




																<c:if test="${prefrm20desgId==null}">


																	<td rowspan="1" colspan="1"><b><button
																				type="button" name="resunitee"
																				id="resuniteelist${count.count}"
																				class="btn btn-1 btn-link center-block "
																				style="white-space: normal; color: #451abb">
																				<b><c:out value="${t.unitName}"></c:out></b>
																			</button></b></td>




																</c:if>
																<c:if test="${prefrm20desgId!=null}">



																	<td rowspan="1" colspan="1"><b><button
																				type="button" name="resunitee"
																				id="resuniteelist${count.count}"
																				class="btn btn-1 btn-link center-block "
																				style="white-space: normal; color: #451abb">
																				<b><c:out value="${t.unitName}"></c:out></b>
																			</button></b></td>

																</c:if>
															</c:if>
														</c:when>
														<c:otherwise>

															<c:if
																test="${(frmdesgId==10  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0)}">

																<td rowspan="1" colspan="1"><b><button
																			type="button" name="resunitee"
																			id="resuniteelist${count.count}"
																			class="btn btn-1 btn-link center-block "
																			style="white-space: normal; color: #451abb">
																			<b><c:out value="${t.unitName}"></c:out></b>
																		</button></b></td>

															</c:if>

														</c:otherwise>


													</c:choose>
													<c:choose>

														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (t.resSubmittedCount>0) }">
															<td rowspan="1" colspan="1"><b><button
																		type="button" name="reson" id="restot${count.count}"
																		class="btn btn-1 btn-link center-block "
																		style="white-space: normal; color: blue"
																		onclick="getresann1totalres('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',0, 'res2' )">
																		<b><c:out value="${t.resTotalCount}"></c:out></b>
																	</button></b></td>
														</c:when>
														<c:otherwise>
															<td rowspan="1" colspan="1"><b><button
																		type="button" name="reson" id="restot${count.count}"
																		class="btn btn-1 btn-link center-block "
																		style="white-space: normal; color: blue"
																		onclick="getresann1totalres('${t.year }','${t.dutyFrequencyId}','${frmListdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',0, 'res2' )">
																		<b><c:out value="${t.resTotalCount}"></c:out></b>
																	</button></b></td>
														</c:otherwise>
														<%--  <c:otherwise>
										 <td style="text-align: center;"><c:out value="${t.resSubmittedCount}"></c:out></td>
										 </c:otherwise> --%>
													</c:choose>



													<c:choose>

														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (t.resSubmittedCount>0) }">
															<td rowspan="1" colspan="1"><b><button
																		type="button" name="reson" id="reson${count.count}"
																		class="btn btn-1 btn-link center-block "
																		style="white-space: normal; color: green"
																		onclick="getresann1details('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',0, 'res2' )">
																		<b><c:out value="${t.resSubmittedCount}"></c:out></b>
																	</button></b></td>
														</c:when>
														<c:when test="${(t.resSubmittedCount>0) }">
															<td rowspan="1" colspan="1"><b><button
																		type="button" name="reson" id="reson${count.count}"
																		class="btn btn-1 btn-link center-block "
																		style="white-space: normal; color: green"
																		onclick="getresann1details('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',0, 'res2' )">
																		<b><c:out value="${t.resSubmittedCount}"></c:out></b>
																	</button></b></td>
														</c:when>
														<c:otherwise>
															<td rowspan="1" colspan="1"><b><c:out
																		value="${t.resSubmittedCount}"></c:out></b></td>
														</c:otherwise>
														<%--  <c:otherwise>
										 <td style="text-align: center;"><c:out value="${t.resSubmittedCount}"></c:out></td>
										 </c:otherwise> --%>
													</c:choose>
													<c:choose>
														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (t.resUnsatisfactory>0) }">

															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="resun${count.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #FFA500"
																	onclick="getresann1details('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',${t.unsatconditionofDamId}, 'res2' )">
																	<b><c:out value="${t.resUnsatisfactory}"></c:out></b>
																</button></td>


														</c:when>

														<c:when test="${t.resUnsatisfactory>0}">
															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="resun${count.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #FFA500"
																	onclick="getresann1details('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',${t.unsatconditionofDamId}, 'res2' )">
																	<b><c:out value="${t.resUnsatisfactory}"></c:out></b>
																</button></td>
														</c:when>
														<c:otherwise>
															<td rowspan="1" colspan="1"><b><c:out
																		value="${t.resUnsatisfactory}"></c:out></b></td>
														</c:otherwise>
													</c:choose>

													<c:choose>
														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (t.resPoor>0) }">

															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="respo${count.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: red"
																	onclick="getresann1details('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',${t.poorconditionofDamId}, 'res2' )">
																	<b><c:out value="${t.resPoor}"></c:out></b>
																</button></td>


														</c:when>

														<c:when test="${t.resPoor>0}">
															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="respo${count.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: red"
																	onclick="getresann1details('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',${t.poorconditionofDamId}, 'res2' )">
																	<b><c:out value="${t.resPoor}"></c:out></b>
																</button></td>
														</c:when>

														<c:otherwise>
															<td rowspan="1" colspan="1"><b><c:out
																		value="${t.resPoor}"></c:out></b></td>
														</c:otherwise>
													</c:choose>

													<c:choose>
														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (t.resFair>0) }">

															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="resfa${count.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #9ACD32"
																	onclick="getresann1details('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',${t.fairconditionofDamId}, 'res2' )">
																	<b><c:out value="${t.resFair}"></c:out></b>
																</button></td>


														</c:when>

														<c:when test="${t.resFair>0}">
															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="resfa${count.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #9ACD32"
																	onclick="getresann1details('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',${t.fairconditionofDamId}, 'res2' )">
																	<b><c:out value="${t.resFair}"></c:out></b>
																</button></td>
														</c:when>
														<c:otherwise>
															<td rowspan="1" colspan="1"><b><c:out
																		value="${t.resFair}"></c:out></b></td>
														</c:otherwise>
													</c:choose>

													<c:choose>
														<c:when
															test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (t.resSatisfactory>0) }">

															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="ressa${count.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #2E8B57"
																	onclick="getresann1details('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',${t.satconditionofDamId}, 'res2' )">
																	<b><c:out value="${t.resSatisfactory}"></c:out></b>
																</button></td>


														</c:when>
														<c:when test="${t.resSatisfactory>0}">
															<td rowspan="1" colspan="1"><button type="button"
																	name="reson" id="ressa${count.count}"
																	class="btn btn-1 btn-link center-block "
																	style="white-space: normal; color: #2E8B57"
																	onclick="getresann1details('${t.year }','${t.dutyFrequencyId}','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',${t.satconditionofDamId}, 'res2' )">
																	<b><c:out value="${t.resSatisfactory}"></c:out></b>
																</button></td>
														</c:when>
														<c:otherwise>
															<td rowspan="1" colspan="1"><b><c:out
																		value="${t.resSatisfactory}"></c:out></b></td>
														</c:otherwise>
													</c:choose>
													<%-- <td><b><c:out value="${t.resPoor}"></c:out></b></td>
												<td><b><c:out value="${t.resFair}"></c:out></b></td>
												<td><b><c:out value="${t.resSatisfactory}"></c:out></b></td> --%>




												</tr>



												<!-- start  -->





												<c:set var="snores" scope="page" value="1" />
												<c:set var="divisioninfo" value="0" scope="page" />


												<c:if test="${invResListEE!=null}">

<!-- 
													<tr>

														<td rowspan="1" colspan="9"> -->
															<%-- <table class="tablech1 display table-bordered"
																style="width: 100%" id="tablechild1${t.unitId}">
																<thead>
																	<tr>
																		<th rowspan="1" colspan="1"></th>
																		<th rowspan="1" colspan="1">Sl.No</th>
																		<th rowspan="1" colspan="1">Name of Office</th>
																		<th rowspan="1" colspan="1">Total Reservoirs</th>
																		<th rowspan="1" colspan="1">Total Submitted</th>
																		<th rowspan="1" colspan="1">Unsatisfactory</th>
																		<th rowspan="1" colspan="1">Poor</th>
																		<th rowspan="1" colspan="1">Fair</th>
																		<th rowspan="1" colspan="1">Satisfactory</th>
																	</tr>
																</thead>
																<tbody> --%>


																	<c:set var="qnores" scope="page" value="1" />
																	<c:forEach items="${invResListEE}" var="q"
																		varStatus="qcount">









																		<c:if
																			test="${((t.unitId==q.unitId)&&(q.divisionId!=divisioninfo) )}">

																			<c:set var="snores" scope="page" value="${snores+1 }" />



																			<tr style="font-size: 12px; text-align: center;"   class="tablech1  childeerow${t.unitId}"
																				id="eelist${t.unitId }${t.circleId }${q.divisionId}"
																				class="eeinf   list${t.unitId}    ">
																				<td rowspan="1" colspan="1">--</td>
																				<td rowspan="1" colspan="1"
																					style="text-align: center;">${qnores }</td>
																				<c:if
																					test="${frmdesgId==2 || frmdesgId==8 && frmsubdivId >0}">
																					<td rowspan="1" colspan="1"><b><c:out
																								value="${q.postName}"></c:out></b></td>
																				</c:if>
																				<c:if
																					test="${(frmdesgId==4 &&   frmsubdivId >0 ) && (frmpost!=1106177746 || frmpost!=932 || frmpost!=931 || frmpost!=921 || frmpost!=911) }">

																					<td rowspan="1" colspan="1"><b><c:out
																								value="${q.postName}"></c:out></b></td>

																				</c:if>

																				<c:if
																					test="${frmdesgId==5 && fmdivId>0 &&    frmsubdivId ==0}">

																					<td rowspan="1" colspan="1"><b><c:out
																								value="${q.subdivisionName}"></c:out></b></td>

																				</c:if>
																				<c:if
																					test="${frmdesgId==7 && frmunitId>0  && frmcircleId>0 && fmdivId==0 &&    frmsubdivId ==0}">

																					<td rowspan="1" colspan="1"><b><c:out
																								value="${q.divisionName}"></c:out></b></td>


																				</c:if>



																				<c:choose>

																					<c:when test="${frmOffAccess==3}">


																						<c:if
																							test="${(frmdesgId==9  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) ||
											  (frmdesgId==7  && t.unitId>0  && t.circleId==0 && t.divisionId==0 &&    t.subdivisionId ==0) }">



																							<c:if
																								test="${(frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830 && frmunitId!=9) &&  (frmpost!=1106177746 || frmpost!=931 || frmpost!=932 || frmpost!=921 || frmpost!=911)  }">
																								<!--  This part of code executes when ENC A or I clicks on any unit name and designation Id becomes 9 or 7 -->
																								<%--   <c:out value="2 CE SE nt ENCA or I"></c:out> --%>
																								<td rowspan="1" colspan="1"><b><c:out
																											value="${q.divisionName}"></c:out></b></td>
																							</c:if>


																						</c:if>

																					</c:when>

																					<c:otherwise>
																						<%-- 	<c:out value="not 3 CE SE nt ENCA or I"></c:out>  --%>

																						<c:if
																							test="${((frmdesgId==9)  && (frmunitId>0 &&  frmunitId!=4 && frmunitId!=9832 && frmunitId!=9830  && frmcircleId==0 && fmdivId==0 &&    frmsubdivId ==0) &&  (frmpost!=1106177746 || frmpost!=932 || frmpost!=931 || frmpost!=921 || frmpost!=911))}">
																							<%-- <c:out value="normal CE login"></c:out>  --%>

																							<td rowspan="1" colspan="1"><b><c:out
																										value="${q.divisionName}"></c:out></b></td>

																						</c:if>

																					</c:otherwise>

																				</c:choose>



																				<c:choose>
																					<c:when test="${frmOffAccess==3}">
																						<c:if
																							test="${((frmdesgId==10   && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0 ) ||
										      (frmdesgId==9  && ( t.unitId==q.unitId) && t.unitId>0  && t.circleId==0 && t.divisionId==0 &&   t.subDivisionId ==0 ) ||  (frmpost==1106177746 || frmpost==931 || frmpost==932 || frmpost==921 || frmpost==911 ) ) }">


																							<c:set var="divisioninfo"
																								value="${q.divisionId }" scope="page" />



																							<c:if test="${prefrm20desgId==null}">






																								<td rowspan="1" colspan="1" style="color: black">
																									<b><c:out value="${q.divisionName}"></c:out></b>
																								</td>


																							</c:if>
																							<c:if test="${prefrm20desgId!=null}">



																								<td rowspan="1" colspan="1" style="color: black">
																									<b><c:out value="${q.divisionName}"></c:out></b>
																								</td>

																							</c:if>
																						</c:if>
																					</c:when>
																					<c:otherwise>

																						<c:if
																							test="${(( t.unitId==q.unitId))&&(frmdesgId==10  && frmunitId>0  && frmcircleId==0 && fmdivId==0 &&   frmsubdivId ==0)}">




																							<td rowspan="1" colspan="1" style="color: black">
																								<b><c:out value="${q.divisionName}"></c:out></b>
																							</td>

																						</c:if>

																					</c:otherwise>


																				</c:choose>
																				<c:choose>

																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (q.resTotalCount>0) }">
																						<td rowspan="1" colspan="1"><b><button
																									type="button" name="resonee"
																									id="restotee${count.count}"
																									class="btn btn-1 btn-link center-block "
																									style="white-space: normal; color: blue"
																									onclick="getresann1totalres('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',0, 'res2' )">
																									<b><c:out value="${q.resTotalCount}"></c:out></b>
																								</button></b></td>
																					</c:when>
																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><button
																									type="button" name="resonee"
																									id="restotee${count.count}"
																									class="btn btn-1 btn-link center-block "
																									style="white-space: normal; color: blue"
																									onclick="getresann1totalres('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',0, 'res2' )">
																									<b><c:out value="${q.resTotalCount}"></c:out></b>
																								</button></b></td>
																					</c:otherwise>
																					<%--  <c:otherwise>
										 <td style="text-align: center;"><c:out value="${t.resSubmittedCount}"></c:out></td>
										 </c:otherwise> --%>
																				</c:choose>



																				<c:choose>

																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (q.resSubmittedCount>0) }">
																						<td rowspan="1" colspan="1"><b><button
																									type="button" name="resonee"
																									id="resonee${count.count}"
																									class="btn btn-1 btn-link center-block "
																									style="white-space: normal; color: green"
																									onclick="getresann1details('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',0, 'res2' )">
																									<b><c:out value="${q.resSubmittedCount}"></c:out></b>
																								</button></b></td>
																					</c:when>

																					<c:when test="${ (q.resSubmittedCount>0) }">
																						<td rowspan="1" colspan="1"><b><button
																									type="button" name="resonee"
																									id="resonee${count.count}"
																									class="btn btn-1 btn-link center-block "
																									style="white-space: normal; color: green"
																									onclick="getresann1details('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',0, 'res2' )">
																									<b><c:out value="${q.resSubmittedCount}"></c:out></b>
																								</button></b></td>
																					</c:when>
																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><c:out
																									value="${q.resSubmittedCount}"></c:out></b></td>
																					</c:otherwise>
																					<%--  <c:otherwise>
										 <td style="text-align: center;"><c:out value="${t.resSubmittedCount}"></c:out></td>
										 </c:otherwise> --%>
																				</c:choose>
																				<c:choose>
																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (q.resUnsatisfactory>0) }">

																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="resunee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #FFA500"
																								onclick="getresann1details('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${t.divisionId}','${q.subdivisionId}','${q.postId}',${q.unsatconditionofDamId}, 'res2' )">
																								<b><c:out value="${q.resUnsatisfactory}"></c:out></b>
																							</button></td>


																					</c:when>

																					<c:when test="${q.resUnsatisfactory>0}">
																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="resunee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #FFA500"
																								onclick="getresann1details('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',${q.unsatconditionofDamId}, 'res2' )">
																								<b><c:out value="${q.resUnsatisfactory}"></c:out></b>
																							</button></td>
																					</c:when>
																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><c:out
																									value="${q.resUnsatisfactory}"></c:out></b></td>
																					</c:otherwise>
																				</c:choose>

																				<c:choose>
																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (q.resPoor>0) }">

																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="respoee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: red"
																								onclick="getresann1details('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',${q.poorconditionofDamId}, 'res2' )">
																								<b><c:out value="${q.resPoor}"></c:out></b>
																							</button></td>


																					</c:when>

																					<c:when test="${q.resPoor>0}">
																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="respoee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: red"
																								onclick="getresann1details('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',${q.poorconditionofDamId}, 'res2' )">
																								<b><c:out value="${q.resPoor}"></c:out></b>
																							</button></td>
																					</c:when>

																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><c:out
																									value="${q.resPoor}"></c:out></b></td>
																					</c:otherwise>
																				</c:choose>

																				<c:choose>
																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (q.resFair>0) }">

																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="resfaee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #9ACD32"
																								onclick="getresann1details('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',${q.fairconditionofDamId}, 'res2' )">
																								<b><c:out value="${q.resFair}"></c:out></b>
																							</button></td>


																					</c:when>

																					<c:when test="${q.resFair>0}">
																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="resfaee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #9ACD32"
																								onclick="getresann1details('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',${q.fairconditionofDamId}, 'res2' )">
																								<b><c:out value="${q.resFair}"></c:out></b>
																							</button></td>
																					</c:when>
																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><c:out
																									value="${q.resFair}"></c:out></b></td>
																					</c:otherwise>
																				</c:choose>

																				<c:choose>
																					<c:when
																						test="${((frmdesgId==2 || frmdesgId==8 || frmdesgId==4) && (frmsubdivId>0)) && (q.resSatisfactory>0) }">

																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="ressaee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #2E8B57"
																								onclick="getresann1details('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',${q.satconditionofDamId}, 'res2' )">
																								<b><c:out value="${q.resSatisfactory}"></c:out></b>
																							</button></td>


																					</c:when>
																					<c:when test="${q.resSatisfactory>0}">
																						<td rowspan="1" colspan="1"><button
																								type="button" name="resonee"
																								id="ressaee${count.count}"
																								class="btn btn-1 btn-link center-block "
																								style="white-space: normal; color: #2E8B57"
																								onclick="getresann1details('${q.year }','${q.dutyFrequencyId}','5','${q.unitId}','${q.circleId}','${q.divisionId}','${q.subdivisionId}','${q.postId}',${q.satconditionofDamId}, 'res2' )">
																								<b><c:out value="${q.resSatisfactory}"></c:out></b>
																							</button></td>
																					</c:when>
																					<c:otherwise>
																						<td rowspan="1" colspan="1"><b><c:out
																									value="${q.resSatisfactory}"></c:out></b></td>
																					</c:otherwise>
																				</c:choose>
																				<%-- <td><b><c:out value="${t.resPoor}"></c:out></b></td>
												<td><b><c:out value="${t.resFair}"></c:out></b></td>
												<td><b><c:out value="${t.resSatisfactory}"></c:out></b></td> --%>




																			</tr>

																			<c:set var="qnores" scope="page" value="${qnores+1}" />


																		</c:if>









																	</c:forEach>


																<!-- </tbody>
															</table>
														</td>

													</tr> -->




												</c:if>










												<!-- end  -->





												<%-- <tr style="font-size: 16px">

										<td style="text-align: center;"><c:out
												value="${count.count}"></c:out></td>
												
												<button type="button" name="office" id="office${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick=""  >   <b><c:out value="${t.unitName}"></c:out></b> </button>
                                       
										
									<b><button type="button" name="res" id="res${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="getresann1details(${t.unitId},0,'res2')"  > </button></b>
										<td>  <b><c:out value="${t.resTotalCount}"></c:out></b> </td>
										
										<c:choose>
										<c:when test="${t.resSubmittedCount>0}">
										 <td><b><button type="button" name="reson" id="reson${count.count}" class="btn btn-1 btn-primary center-block "    style="white-space:normal"  onclick="getresann1details('${t.year }','${frmdesgId}','${t.unitId}','${t.circleId}','${t.divisionId}','${t.subdivisionId}','${t.postId}',0, 'res2' )"  >   <b><c:out value="${t.resSubmittedCount}"></c:out></b> </button></b></td>
										 </c:when>
										 <c:otherwise>
										 <td style="text-align: center;"><c:out value="${t.resSubmittedCount}"></c:out></td>
										 </c:otherwise>
										</c:choose>
										<td style="text-align: center;"><c:out value="${t.resUnsatisfactory}"></c:out></td>
								<td style="text-align: center;"><c:out value="${t.resPoor}"></c:out></td>
									<td style="text-align: center;"><c:out value="${t.resFair}"></c:out></td>
								<td style="text-align: center;"><c:out value="${t.resSatisfactory}"></c:out></td>

										


									</tr> --%>

											</c:forEach>

											<c:set var="snores" scope="page" value="1" />





											<tr style="color: red; font-weight: bold; font-size: 16px;">
												<td rowspan="1" colspan="1"
													
													style="width: 15px;" aria-label=""></td>
												<td rowspan="1" colspan="1">Total Reservoirs</td>
												<td rowspan="1" colspan="1" style="text-align: center;">Total</td>

												<c:choose>
													<c:when test="${(frmdesgId==10) }">
														<td rowspan="1" colspan="1" style="text-align: center;">
															<button type="button" name="reson" id="catrestotals"
																class="btn btn-1 btn-link center-block "
																style="white-space: normal; color: blue"
																onclick="getresALLann1totalres('${ryear }','${rdutyFrequencyId}','${frmdesgId}','${runitId}','${rcircleId}','${rdivisionId}','${rsubdivisionId}','${rpost}',0, 'res2' )">
																<b><c:out value="${totalres}"></c:out></b>
															</button>
														</td>
													</c:when>
													<c:otherwise>
														<td rowspan="1" colspan="1"
															style="text-align: center; color: red"><b><c:out
																	value="${totalres}"></c:out></b></td>

													</c:otherwise>
												</c:choose>
												<%-- <td style="text-align: center;"><b>   <c:out value="${totalres}"></c:out></b> </td> --%>

												<td rowspan="1" colspan="1" style="text-align: center;"><b>
														<c:out value="${restotalsubmitted}"></c:out>
												</b></td>

												<td rowspan="1" colspan="1" style="text-align: center;"><b>
														<c:out value="${resunsatisfactory}"></c:out>
												</b></td>
												<td rowspan="1" colspan="1" style="text-align: center;"><b>
														<c:out value="${respoor}"></c:out>
												</b></td>
												<td rowspan="1" colspan="1" style="text-align: center;"><b>
														<c:out value="${resfair}"></c:out>
												</b></td>
												<td rowspan="1" colspan="1" style="text-align: center;"><b>
														<c:out value="${ressatisfactory}"></c:out>
												</b></td>


											</tr>



										</tbody>



									</table>

								</div>

								<%-- 	</c:if> --%>


							</div>





						</form:form>
					</div>
					<!-- tcab2 -->




				</div>
				<!-- abs -->


			</div>
			<!-- //panel body-content -->
		</div>
		<!-- //panel-content -->



	</div>
	<!-- //row-content -->
</div>
<!-- //container-content -->



<!-- 	<script src="../js/Html5DataTable/jquery-3.3.1.js" type="text/javascript"></script> -->
<script src="../js/Html5DataTable/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script src=" ../js/Html5DataTable/dataTables.buttons.min.js"
	type="text/javascript"></script>
<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>
<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>
<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>
<script src="../js/Html5DataTable/buttons.html5.min.js"
	type="text/javascript"></script>
<script src="../js/Html5DataTable/buttons.print.min.js"
	type="text/javascript"></script>
<script src="../js/Html5DataTable/dataTables.select.min.js"
	type="text/javascript"></script>

<script src="../js/Html5DataTable/buttons.colVis.min.js"
	type="text/javascript"></script>


<script type="text/javascript">
$(function() {
	 var table =	  $('#data-table1').DataTable(
											{
												dom : 'Bfrtip',
												responsive : true,
												"paging" : false,
												"autoWidth" : true,
												"lengthChange" : false,
												"pageLength" : 20,
												 ordering: false,
												 info: false,
												 "scrollY": 400,
											        "scrollX": true,
											        
											               
												buttons : [
														'copyHtml5',
														{
															extend : 'excelHtml5',
															autoFilter : true,
															sheetName : 'Exported_Paras_data',
															text : 'Save To Excel',
															className : 'btn-primary ',
															messageTop : 'Inspection Abstract'

														},

														{
															extend : 'pdfHtml5',
															className : 'btn-primary ',
															text : 'PDF View / Download',
															orientation : 'landscape',
															pageSize : 'A4',
															download : 'open',
															font : '18',
															filename : 'Report',
															exportOptions : {
																columns : ':visible',
																search : 'applied',
																order : 'applied'
															},

															title : 'Inspection Abstract',
															customize : function(
																	doc) {
																doc.defaultStyle.fontfamily = 'Arial';

																doc.defaultStyle.fontSize = 16;
																doc.defaultStyle.alignment = 'center';
																doc.styles.tableHeader.fontSize = 18;
																doc.pageMargins = [
																		80, 80,
																		80, 80 ];
																doc['footer'] = (function(
																		page,
																		pages) {
																	return {
																		columns : [

																		{
																			alignment : 'right',
																			text : [
																					{
																						text : page
																								.toString(),
																						italics : true
																					},
																					' of ',
																					{
																						text : pages
																								.toString(),
																						italics : true
																					} ]
																		} ],
																		margin : [
																				5,
																				0 ]
																	}
																});

															}

														},
														{
															extend : 'print',
															text : 'Print All',
															className : 'btn-primary ',
															exportOptions : {
																modifier : {
																	selected : null
																}
															}

														},
														,
														{
															extend : 'print',
															text : 'Print Selected',
															className : 'btn-primary '

														},
														  {
											                extend: 'colvis',
											                text: 'Exclude for Print/Export',
											               
											                columnText: function ( dt, idx, title ) {
											                    return title;
											                }
											               
											                }],
											                
												select : true

											});
						 
						 
	// Add click event handler to parent rows
   /*   $('#data-table1 tbody').on('click', 'tr[data-child]', function() {
         var childId = $(this).data('child');
         var childRows = $('tr[data-parent="${childId}"]');

         if (childRows.is(':visible')) {
             childRows.hide();
         } else {
             childRows.show();
         }
     }); */
						
						 
					
						
						 $('#data-table1 tbody').on('click', 'td.details-control', function () {
							 
								// alert("kal1");
								 var idnew = $(this).attr("id");
								// alert("idnew"+idnew);
								 var idlen=idnew.length;
								// alert("idlen"+idlen);
								 var resultid = idnew.substring(6, idlen);
								// alert("resultid"+resultid);
								 
								 
								 var mainrowid="#mainrow"+resultid;
						         var tr = $(this).closest('tr');
						  
						         var tdi = $(mainrowid).find("i.fa");
						         
						        // alert("tdi"+tdi);
						       
						        
						        var rowclass=".eerow"+resultid;
						        
						        var elementsWithClass = $(rowclass);
						        
						        elementsWithClass.each(function () {
						            // Get the id of each element
						            var id = $(this).attr("id");
						            
						           // alert(id);
						            //console.log("ID:", id);
						            
						            
						            var shownstatus=$(mainrowid).hasClass('shown');
						            
						          //  alert("shownstatus"+shownstatus);
						          
						            if(!shownstatus){
						            	
						            	  $(rowclass).show();
						            	 
						            }else  {
						            	
						            	
						            	 $(rowclass).hide();
						            						             
							         
						            }
						            
						           
						             
						          });
						        
						        if (!$(mainrowid).hasClass('shown')) {
						        	
						        	$(mainrowid).addClass('shown');
					            	  tdi.first().addClass('fa-minus-square');
							             tdi.first().removeClass('fa-plus-square');
					            } else {
					            	  $(mainrowid).removeClass('shown');
							             tdi.first().addClass('fa-plus-square');
							             tdi.first().removeClass('fa-minus-square');
							             
					            }
						      
						         
						     
						     });
						 
						 
						 $('#data-table2').DataTable(
									{
										dom : 'Bfrtip',
										responsive : true,
										"paging" : false,
										"autoWidth" : true,
										"lengthChange" : false,
										"pageLength" : 20,
										 ordering: false,
										 info: false,
										 "scrollY": 400,
									        "scrollX": true,
									        
									               
										buttons : [
												'copyHtml5',
												{
													extend : 'excelHtml5',
													autoFilter : true,
													sheetName : 'Exported_Paras_data',
													text : 'Save To Excel',
													className : 'btn-primary ',
													messageTop : 'Inspection Abstract'

												},

												{
													extend : 'pdfHtml5',
													className : 'btn-primary ',
													text : 'PDF View / Download',
													orientation : 'landscape',
													pageSize : 'A4',
													download : 'open',
													font : '18',
													filename : 'Report',
													exportOptions : {
														columns : ':visible',
														search : 'applied',
														order : 'applied'
													},

													title : 'Inspection Abstract',
													customize : function(
															doc) {
														doc.defaultStyle.fontfamily = 'Arial';

														doc.defaultStyle.fontSize = 16;
														doc.defaultStyle.alignment = 'center';
														doc.styles.tableHeader.fontSize = 18;
														doc.pageMargins = [
																80, 80,
																80, 80 ];
														doc['footer'] = (function(
																page,
																pages) {
															return {
																columns : [

																{
																	alignment : 'right',
																	text : [
																			{
																				text : page
																						.toString(),
																				italics : true
																			},
																			' of ',
																			{
																				text : pages
																						.toString(),
																				italics : true
																			} ]
																} ],
																margin : [
																		5,
																		0 ]
															}
														});

													}

												},
												{
													extend : 'print',
													text : 'Print All',
													className : 'btn-primary ',
													exportOptions : {
														modifier : {
															selected : null
														}
													}

												},
												,
												{
													extend : 'print',
													text : 'Print Selected',
													className : 'btn-primary '

												},
												  {
									                extend: 'colvis',
									                text: 'Exclude for Print/Export',
									               
									                columnText: function ( dt, idx, title ) {
									                    return title;
									                }
									               
									                }],
									                
										select : true

									});
				 
				 
						 $('#data-table2 tbody').on('click', 'td.details-control', function () {
							 
							// alert("kal1");
							 var idnew = $(this).attr("id");
							// alert("idnew"+idnew);
							 var idlen=idnew.length;
							// alert("idlen"+idlen);
							 var resultid = idnew.substring(6, idlen);
							// alert("resultid"+resultid);
							 
							 
							 var mainrowid="#parentmainrow"+resultid;
					         var tr = $(this).closest('tr');
					  
					         var tdi = $(mainrowid).find("i.fa");
					         
					        // alert("tdi"+tdi);
					       
					        
					        var rowclass=".childeerow"+resultid;
					        
					        var elementsWithClass = $(rowclass);
					        
					        elementsWithClass.each(function () {
					            // Get the id of each element
					            var id = $(this).attr("id");
					            
					         //  alert(id);
					         //   console.log("ID:", id);
					            
					            
					            var shownstatus=$(mainrowid).hasClass('shown');
					            
					          //  alert("shownstatus"+shownstatus);
					          
					            if(!shownstatus){
					            	
					            	  $(rowclass).show();
					            	 
					            }else  {
					            	
					            	
					            	 $(rowclass).hide();
					            						             
						         
					            }
					            
					           
					             
					          });
					        
					        if (!$(mainrowid).hasClass('shown')) {
					        	
					        	$(mainrowid).addClass('shown');
				            	  tdi.first().addClass('fa-minus-square');
						             tdi.first().removeClass('fa-plus-square');
				            } else {
				            	  $(mainrowid).removeClass('shown');
						             tdi.first().addClass('fa-plus-square');
						             tdi.first().removeClass('fa-minus-square');
						             
				            }
						     });
				
				 
				});
				    
						</script>


























<script type="text/javascript" src="../js/parsley.js"></script>



<!-- //main-content -->
