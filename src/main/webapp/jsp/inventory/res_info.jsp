    
    <div id="res_dialogue">

<form:form id="reservoirformid" method="post" modelAttribute="addreservoir" name="reservoirform"
			data-parsley-validate-if-empty="" enctype="multipart/form-data">


<div class="col-md-12 invDiv" > 



<div class="col-md-12 invDivheading" >Salient features </div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Reservoir Name</label> <input
				type="text" class="form-control" id="resName" name="resName"
				placeholder="resName" required />
		</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Water Spread Area(Acres)</label> <input
				type="text" class="form-control" id="waterSpreadArea" name="waterSpreadArea"
				placeholder="Water Spread Area"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Latitude</label> <input
				type="text" class="form-control" id="resLatitude" name="resLatitude"
				placeholder="degrees"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Longitude</label> <input
				type="text" class="form-control" id="resLongitude" name="resLongitude"
				placeholder="degrees"  />
		</div>
		
		<div class="col-md-3">
					<label class="label-control rowlebel ">Select Status</label> <select
						class="form-control" id="resStatusId" name="resStatusId" required>
                         <option value=" ">Select</option>
						<option value="1">Ongoing</option>
						<option value="2">Completed</option>
						



					</select>
				</div>
				
			
		<div class="col-md-3">
			<label class="label-control rowlebel ">Hydro Power(MW)</label> <input
				type="text" class="form-control" id="hydroPower"
				name="hydroPower" placeholder="hydroPower"  />
		</div>
		
			
		<div class="col-md-3">
			<label class="label-control rowlebel ">Land Acquisition(Acres)</label> <input
				type="text" class="form-control" id="landAcquistion"
				name="landAcquistion" placeholder="landAcquistion"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Catchment Area(Sq. Km)</label> <input
				type="text" class="form-control" id="catchmentArea"
				name="catchmentArea" placeholder="catchmentArea"  />
		</div>
		
			<div class="col-md-3">
			<label class="label-control rowlebel ">M.F.D(cumecs)</label> <input
				type="text" class="form-control" id="maxfloodDischarge"
				name="maxfloodDischarge" placeholder="maxfloodDischarge"  />
		</div>
		
		
		

		
		
		




<div class="col-md-12 invDivsubheading" > Capacity(TMC) </div>


		

		<div class="col-md-3">
			<label class="label-control rowlebel ">MWL</label> <input
				type="text" class="form-control" id="mwlCapacity" name="mwlCapacity"
				placeholder="MWL(TMC)" required />
		</div>

		<div class="col-md-3">
			<label class="label-control rowlebel ">FRL</label> <input
				type="text" class="form-control" id="frlCapacity" name="frlCapacity"
				placeholder="FRL(TMC)" required />
		</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">MDDL</label> <input
				type="text" class="form-control" id="mddlCapacity"
				name="mddlCapacity" placeholder="MDDL(TMC)" required />
		</div>
		
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Dead Storage </label> <input
				type="text" class="form-control" id="deadstorageCapacity" name="deadstorageCapacity"
				placeholder="deadstorageCapacity(TMC)"  />
		</div>
		

<div class="col-md-12 invDivsubheading" > Level(+Mt.) </div>

<div class="col-md-3">
			<label class="label-control rowlebel ">TRL</label> <input
				type="text" class="form-control" id="trlLevel" name="trlLevel"
				placeholder="TRL Level"  />
		</div>
		
			<div class="col-md-3">
			<label class="label-control rowlebel ">FRL  </label> <input
				type="text" class="form-control" id="frlLevel" name="frlLevel"
				placeholder="FRL Level"  />
		</div>


<div class="col-md-3">
			<label class="label-control rowlebel ">MWL  </label> <input
				type="text" class="form-control" id="mwlLevel" name="mwlLevel"
				placeholder="MWL Level"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">MDDL </label> <input
				type="text" class="form-control" id="mddlLevel" name="mddlLevel"
				placeholder="MDDL Level"  />
		</div>

		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Dead Storage Level </label> <input
				type="text" class="form-control" id="deadstorageLevel" name="deadstorageLevel"
				placeholder="deadstorage Level"  />
		</div>
		
	
		
	
		</div>
		
		<div class="col-md-12 invDiv" > 

<div class="col-md-12 invDivheading" > Spill Way/Weir Details </div>

<div class="col-md-12 invDivsubheading" > Spill Way Length (Mt.)</div>
		
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Spill Way Length</label> <input
				type="text" class="form-control" id="spillwayLength"
				name="spillwayLength" placeholder="spillwayLength"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">N.O.F Length</label>
			<input type="text" class="form-control" id="nonoverflowLength"
				name="nonoverflowLength" placeholder="nonoverflowLength"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Maximum Height of Spill Way</label> <input
				type="text" class="form-control" id="maxhtSpillWay"
				name="maxhtSpillWay" placeholder="maxhtSpillWay"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Top Width Of Dam</label> <input
				type="text" class="form-control" id="topWidthDam"
				name="topWidthDam" placeholder="topwidtdam"  />
		</div>

		<div class="col-md-3">
			<label class="label-control rowlebel ">Max Base Width Dam</label> <input
				type="text" class="form-control" id="maxbaseWidthDam"
				name="maxbaseWidthDam" placeholder="maxbasewidthdam"  />
		</div>

		<div class="col-md-3">
			<label class="label-control rowlebel ">Clear Bridge Width</label>
			<input type="text" class="form-control" id="clearBridgeWidth"
				name="clearBridgeWidth" placeholder="clearBridgeWidth"
				 />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Stilling Basin Length/Apron(Mts.)</label>
			<input type="text" class="form-control" id="stillingBasinLength"
				name="stillingBasinLength" placeholder="stillingBasinLength"
				 />
		</div>
		
		
<div class="col-md-12 invDivsubheading" > Level (+Mt.)</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Deepest Foundation(+)</label>
			<input type="text" class="form-control" id="deepestfoundationLevel"
				name="deepestfoundationLevel" placeholder="deepestfoundationLevel"
				 />
		</div>

		<div class="col-md-3">
			<label class="label-control rowlebel ">Average River Bed(+)</label> <input
				type="text" class="form-control" id="avgRiverbedLevel"
				name="avgRiverbedLevel" placeholder="avgRiverbedLevel"  />
		</div>
		
			<div class="col-md-3">
			<label class="label-control rowlebel ">Spill Way Crest(+)</label> <input
				type="text" class="form-control" id="spillWayCrestLevel"
				name="spillWayCrestLevel" placeholder="spillWayCrestLevel"  />
		</div>

		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Bridge Top Level</label>
			<input type="text" class="form-control" id="bridgeTopLevel"
				name="bridgeTopLevel" placeholder="BridgeTopLevel"
				 />
		</div>

		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Invert Level of Bucket(+)</label> <input
				type="text" class="form-control" id="invertLevel" name="invertLevel"
				placeholder="invertLevel"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Stilling Basin Level/Apron(+Mts.)</label>
			<input type="text" class="form-control" id="stillingBasinLevel"
				name="stillingBasinLevel" placeholder="stillingBasinLevel"
				 />
		</div>
		
		</div>

	
	<div class="col-md-12 invDiv" > 

<div class="col-md-12 invDivheading" > Earth Dam/Concrete Dam Details</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Left Length(Mt.)</label> <input
				type="text" class="form-control" id="earthdamLeftLength"
				name="earthdamLeftLength" placeholder="EarthdamLeftLength"  />
		</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Right Length(Mt.)</label> <input
				type="text" class="form-control" id="earthdamRightLength"
				name="earthdamRightLength" placeholder="EarthdamRightLength"
				 />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Max Height</label> <input
				type="text" class="form-control" id="maxHeight"
				name="maxHeight" placeholder="maxHeight"  />
		</div>
		

		

		<div class="col-md-3">
			<label class="label-control rowlebel ">Masonary Dam Length(Mts.)</label> <input
				type="text" class="form-control" id="masonarydamLength" name="masonarydamLength"
				placeholder="masonarydamLength"  />
		</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Rock Fill Dam Length(Mts.)</label> <input
				type="text" class="form-control" id="rockfilldamLength" name="rockfilldamLength"
				placeholder="rockfilldamLength"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Concrete Dam Length(Mts.)</label> <input
				type="text" class="form-control" id="concretedamLength" name="concretedamLength"
				placeholder="concretedamLength"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Zonal Section Length (Mts.)</label> <input
				type="text" class="form-control" id="zonalSectionLength"
				name="zonalSectionLength" placeholder="maxHeight"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Homogeneous Section Length (Mts.)</label> <input
				type="text" class="form-control" id="homogeneousSectionLength"
				name="homogeneousSectionLength" placeholder="HomogeneousSectionLength"  />
		</div>



</div>





		<div class="row show-grid">

			<div class="col-md-12" style="text-align: center;">
				<label class="label-control rowlebel "></label>
				 
				<input 	type="hidden" class="form-control" id="resCodeid" 	name="resCode" placeholder="resCode"  />
				  <button type="button" name="addres" id="addres" class="btn btn-1 btn-primary center-block" >AddReservoir</button>
				
				
			</div>


		</div>

</form:form>

	</div>