package in.ts.icad.leagal.model;

import java.util.List;

public class Component {
	
	private Integer componentId;
	private String componentName;
	private Integer componentLevelId;
	private String componentType;
	private Integer componentTypeId;
	private Double offtakeChainage;
	private Integer componentDirection;
	private String componentCategory;
	private Integer componentCategoryId;
	private Double cubicCapacity;
	private Double componentLength;
	private String tailendStructure;
	private String structureType;
	private Integer projectId;
	private String parentComponent;
	private Integer parentComponentId;
	private Integer parentLevelId;
	private String creationDate;
	private String lastUpdatedDate;
	private String createdByUser;
	private String lastUpdatedByUser;
	private Integer reservoirId;
	private ProjectComponent projcomponent;
	// private Canal canal;
	private String progressString;
	private String remarks;
	private List<ComponentLineSegment> segments;
	private Integer structureTypeId;
	private String StructureType;
	private Integer compPackId;
	private String projectName;
	private Integer levelId;
	private Integer userId;
	
	private Double connectedLoad;
	private Double actualLoad;
	private String deviceName;
	private Integer make;
	private String deviceCategory;
	private Integer deviceType;
	private Integer deviceCapacity;
	private Integer deviceStatus;
	private Integer rpm;
	
	public Integer getRpm() {
		return rpm;
	}
	public void setRpm(Integer rpm) {
		this.rpm = rpm;
	}
	private List<Component> compInputList;
	
	
	
	
	
	
	public List<Component> getCompInputList() {
		return compInputList;
	}
	public void setCompInputList(List<Component> compInputList) {
		this.compInputList = compInputList;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public Integer getMake() {
		return make;
	}
	public void setMake(Integer make) {
		this.make = make;
	}
	public String getDeviceCategory() {
		return deviceCategory;
	}
	public void setDeviceCategory(String deviceCategory) {
		this.deviceCategory = deviceCategory;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public Integer getDeviceCapacity() {
		return deviceCapacity;
	}
	public void setDeviceCapacity(Integer deviceCapacity) {
		this.deviceCapacity = deviceCapacity;
	}
	public Integer getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(Integer deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	private Double pumpconnectedLoad;
	private Double pumpactualLoad;
	
	private Double motorconnectedLoad;
	private Double motoractualLoad;
	
	
	
	
	
	public Integer getMotorrpm() {
		return motorrpm;
	}
	public void setMotorrpm(Integer motorrpm) {
		this.motorrpm = motorrpm;
	}
	public Integer getAvgrpm() {
		return avgrpm;
	}
	public void setAvgrpm(Integer avgrpm) {
		this.avgrpm = avgrpm;
	}
	private Integer motorrpm;
	private Integer avgrpm;
	
	
	
	
	

	public Double getPumpconnectedLoad() {
		return pumpconnectedLoad;
	}
	public void setPumpconnectedLoad(Double pumpconnectedLoad) {
		this.pumpconnectedLoad = pumpconnectedLoad;
	}
	public Double getPumpactualLoad() {
		return pumpactualLoad;
	}
	public void setPumpactualLoad(Double pumpactualLoad) {
		this.pumpactualLoad = pumpactualLoad;
	}
	public Double getMotorconnectedLoad() {
		return motorconnectedLoad;
	}
	public void setMotorconnectedLoad(Double motorconnectedLoad) {
		this.motorconnectedLoad = motorconnectedLoad;
	}
	public Double getMotoractualLoad() {
		return motoractualLoad;
	}
	public void setMotoractualLoad(Double motoractualLoad) {
		this.motoractualLoad = motoractualLoad;
	}
	public Double getConnectedLoad() {
		return connectedLoad;
	}
	public void setConnectedLoad(Double connectedLoad) {
		this.connectedLoad = connectedLoad;
	}
	public Double getActualLoad() {
		return actualLoad;
	}
	public void setActualLoad(Double actualLoad) {
		this.actualLoad = actualLoad;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getLevelId() {
		return levelId;
	}
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	private Integer compId0;

	private Integer compId1;

	private Integer compId2;

	private Integer compId3;

	private Integer compId4;

	private Integer compId5;

	private Integer packageId;
	private Integer unitId ;
	private Integer circleId;
	private Integer divisionId;
	private Integer subdivisionId;
	private String unitName;
	private String circleName;
	private String divisionName;
	private String subdivisionName;
	private String packageName;
	
	
	
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getSubdivisionName() {
		return subdivisionName;
	}
	public void setSubdivisionName(String subdivisionName) {
		this.subdivisionName = subdivisionName;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getCircleId() {
		return circleId;
	}
	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}
	public Integer getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}
	public Integer getSubdivisionId() {
		return subdivisionId;
	}
	public void setSubdivisionId(Integer subdivisionId) {
		this.subdivisionId = subdivisionId;
	}
	private User user;

	private Double fromKm;
	private Double toKm;
	private String fromlocation;
	private String tolocation;
	private Double pmlength;
	private Integer motorNumber;
	private Integer pumpNumber;
	private Double motorload;
	private Double pumpload;
	public Double getMotorload() {
		return motorload;
	}
	public void setMotorload(Double motorload) {
		this.motorload = motorload;
	}
	public Double getPumpload() {
		return pumpload;
	}
	public void setPumpload(Double pumpload) {
		this.pumpload = pumpload;
	}
	public Integer getPumpNumber() {
		return pumpNumber;
	}
	public void setPumpNumber(Integer pumpNumber) {
		this.pumpNumber = pumpNumber;
	}
	private Double motormegawatts;
	private Double liftStatic;
	private Double liftStaticsign;
	private  Double liftDynamic;
	private  Double liftDynamicsign;
	
	private String staticlift;
	
	private  String dynamiclift;
	
	public Double getLiftStaticsign() {
		return liftStaticsign;
	}
	public void setLiftStaticsign(Double liftStaticsign) {
		this.liftStaticsign = liftStaticsign;
	}
	public Double getLiftDynamicsign() {
		return liftDynamicsign;
	}
	public void setLiftDynamicsign(Double liftDynamicsign) {
		this.liftDynamicsign = liftDynamicsign;
	}
	public String getStaticlift() {
		return staticlift;
	}
	public void setStaticlift(String staticlift) {
		this.staticlift = staticlift;
	}
	public String getDynamiclift() {
		return dynamiclift;
	}
	public void setDynamiclift(String dynamiclift) {
		this.dynamiclift = dynamiclift;
	}
	private Integer noofpumpdays;
	private Double annualpowerconsumption;
	private  Double dischrgecusecs;
	private Double pipediameter;
	private Integer noofpiperows;
	private Double totalLift;
	private Integer liftperiod;
	private Double lifttmc;
	private Double  mddl;
	private Double deliveryLevel;
	private Double eachmotorPower;
	private Double auxPower;
	private  Double totalpowerwithAux;
	private String substationCapacity;
	private Double subupcapacity;
	private Double subdowncapacity;
	private String substationdivision;
	private Integer statusId;
	private Double totalpower;
	private Integer districtId;
	private Integer mandalId;
	private Integer villageId;
	private String mddlsign;
	private String deliverylevelsign;
	private Integer stageId;
	private Integer phaseId;
	private String districtName;
	private String mandalName;
	private String  villageName;
	
	private Integer hiddenProjId;
	 private Integer hiddenPackId;
	 private Integer hiddencircleId;
	 private Integer hiddendivisionId;
	 private Integer hiddenSubdivId;
	 private Integer hiddencompParentId;
	 private Integer hiddenMandalId;
	 private Integer hiddenVillageId;
	 private Double substationHV;
	 private Double substationLV;
	 private String stageName;
	 private String  phaseName;
	 private String hiddencompId;
	 
	 
	 
	
	
	
	
	

	
	
	
	
	public String getHiddencompId() {
		return hiddencompId;
	}
	public void setHiddencompId(String hiddencompId) {
		this.hiddencompId = hiddencompId;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getPhaseName() {
		return phaseName;
	}
	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}
	public Double getSubstationHV() {
		return substationHV;
	}
	public void setSubstationHV(Double substationHV) {
		this.substationHV = substationHV;
	}
	public Double getSubstationLV() {
		return substationLV;
	}
	public void setSubstationLV(Double substationLV) {
		this.substationLV = substationLV;
	}
	public Integer getHiddenMandalId() {
		return hiddenMandalId;
	}
	public void setHiddenMandalId(Integer hiddenMandalId) {
		this.hiddenMandalId = hiddenMandalId;
	}
	public Integer getHiddenVillageId() {
		return hiddenVillageId;
	}
	public void setHiddenVillageId(Integer hiddenVillageId) {
		this.hiddenVillageId = hiddenVillageId;
	}
	public Integer getHiddenProjId() {
		return hiddenProjId;
	}
	public void setHiddenProjId(Integer hiddenProjId) {
		this.hiddenProjId = hiddenProjId;
	}
	public Integer getHiddenPackId() {
		return hiddenPackId;
	}
	public void setHiddenPackId(Integer hiddenPackId) {
		this.hiddenPackId = hiddenPackId;
	}
	public Integer getHiddencircleId() {
		return hiddencircleId;
	}
	public void setHiddencircleId(Integer hiddencircleId) {
		this.hiddencircleId = hiddencircleId;
	}
	public Integer getHiddendivisionId() {
		return hiddendivisionId;
	}
	public void setHiddendivisionId(Integer hiddendivisionId) {
		this.hiddendivisionId = hiddendivisionId;
	}
	public Integer getHiddenSubdivId() {
		return hiddenSubdivId;
	}
	public void setHiddenSubdivId(Integer hiddenSubdivId) {
		this.hiddenSubdivId = hiddenSubdivId;
	}
	public Integer getHiddencompParentId() {
		return hiddencompParentId;
	}
	public void setHiddencompParentId(Integer hiddencompParentId) {
		this.hiddencompParentId = hiddencompParentId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getMandalName() {
		return mandalName;
	}
	public void setMandalName(String mandalName) {
		this.mandalName = mandalName;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public Integer getStageId() {
		return stageId;
	}
	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}
	public Integer getPhaseId() {
		return phaseId;
	}
	public void setPhaseId(Integer phaseId) {
		this.phaseId = phaseId;
	}
	public String getMddlsign() {
		return mddlsign;
	}
	public void setMddlsign(String mddlsign) {
		this.mddlsign = mddlsign;
	}
	public String getDeliverylevelsign() {
		return deliverylevelsign;
	}
	public void setDeliverylevelsign(String deliverylevelsign) {
		this.deliverylevelsign = deliverylevelsign;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public Integer getMandalId() {
		return mandalId;
	}
	public void setMandalId(Integer mandalId) {
		this.mandalId = mandalId;
	}
	public Integer getVillageId() {
		return villageId;
	}
	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}
	public Double getTotalpower() {
		return totalpower;
	}
	public void setTotalpower(Double totalpower) {
		this.totalpower = totalpower;
	}
	public Double getDischrgecusecs() {
		return dischrgecusecs;
	}
	public void setDischrgecusecs(Double dischrgecusecs) {
		this.dischrgecusecs = dischrgecusecs;
	}
	private Double ayacutacres;
	private String pumpType;
	private String pumpMake;
	private String motorMake;
	private String motorType;
	private String status;
	private Integer pumprpm;
	private Double pumpcapacity;
	private Double motorcapacity;
	private Integer pumpstatusId;
	private Integer motorstatusId;
	private Integer pumpmakeId;
	private Integer motormakeId;
	private String financialyear;
	private String statusColor;
	private String statusAddress;
	
	private Boolean deleteFlag;
	private Boolean editFlag;
	private Integer componentPowerAyacutId;
	private Integer compInfoId;
	
	
	
	
	public Integer getCompInfoId() {
		return compInfoId;
	}
	public void setCompInfoId(Integer compInfoId) {
		this.compInfoId = compInfoId;
	}
	public Integer getComponentPowerAyacutId() {
		return componentPowerAyacutId;
	}
	public void setComponentPowerAyacutId(Integer componentPowerAyacutId) {
		this.componentPowerAyacutId = componentPowerAyacutId;
	}
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Boolean getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(Boolean editFlag) {
		this.editFlag = editFlag;
	}
	public String getStatusColor() {
		return statusColor;
	}
	public void setStatusColor(String statusColor) {
		this.statusColor = statusColor;
	}
	public String getStatusAddress() {
		return statusAddress;
	}
	public void setStatusAddress(String statusAddress) {
		this.statusAddress = statusAddress;
	}
	public String getFinancialyear() {
		return financialyear;
	}
	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}
	private Integer pumpcapacityId;
	private Integer motorcapacityId;
	private String pumpCapacityName;

	public String getPumpCapacityName() {
		return pumpCapacityName;
	}
	public void setPumpCapacityName(String pumpCapacityName) {
		this.pumpCapacityName = pumpCapacityName;
	}
	public Integer getPumpcapacityId() {
		return pumpcapacityId;
	}
	public void setPumpcapacityId(Integer pumpcapacityId) {
		this.pumpcapacityId = pumpcapacityId;
	}
	public Integer getMotorcapacityId() {
		return motorcapacityId;
	}
	public void setMotorcapacityId(Integer motorcapacityId) {
		this.motorcapacityId = motorcapacityId;
	}
	public Integer getMotormakeId() {
		return motormakeId;
	}
	public void setMotormakeId(Integer motormakeId) {
		this.motormakeId = motormakeId;
	}
	private Integer pumptypeId;
	private Integer motortypeId;
	private String typepumpmotor;
	private String motorMakeName;
	private String motorTypeName;
	
	
	public String getMotorMakeName() {
		return motorMakeName;
	}
	public void setMotorMakeName(String motorMakeName) {
		this.motorMakeName = motorMakeName;
	}
	public String getMotorTypeName() {
		return motorTypeName;
	}
	public void setMotorTypeName(String motorTypeName) {
		this.motorTypeName = motorTypeName;
	}
	public Integer getPumpmakeId() {
		return pumpmakeId;
	}
	public void setPumpmakeId(Integer pumpmakeId) {
		this.pumpmakeId = pumpmakeId;
	}
	
	public Integer getPumptypeId() {
		return pumptypeId;
	}
	public void setPumptypeId(Integer pumptypeId) {
		this.pumptypeId = pumptypeId;
	}
	public Integer getMotortypeId() {
		return motortypeId;
	}
	public void setMotortypeId(Integer motortypeId) {
		this.motortypeId = motortypeId;
	}
	public String getTypepumpmotor() {
		return typepumpmotor;
	}
	public void setTypepumpmotor(String typepumpmotor) {
		this.typepumpmotor = typepumpmotor;
	}
	private List<Component> pumpList;
	
	private List<Component> motorList;
	
	
	public List<Component> getPumpList() {
		return pumpList;
	}
	public void setPumpList(List<Component> pumpList) {
		this.pumpList = pumpList;
	}
	public List<Component> getMotorList() {
		return motorList;
	}
	public void setMotorList(List<Component> motorList) {
		this.motorList = motorList;
	}
	public Double getPumpcapacity() {
		return pumpcapacity;
	}
	public void setPumpcapacity(Double pumpcapacity) {
		this.pumpcapacity = pumpcapacity;
	}
	public Double getMotorcapacity() {
		return motorcapacity;
	}
	public void setMotorcapacity(Double motorcapacity) {
		this.motorcapacity = motorcapacity;
	}
	public Integer getPumpstatusId() {
		return pumpstatusId;
	}
	public void setPumpstatusId(Integer pumpstatusId) {
		this.pumpstatusId = pumpstatusId;
	}
	public Integer getMotorstatusId() {
		return motorstatusId;
	}
	public void setMotorstatusId(Integer motorstatusId) {
		this.motorstatusId = motorstatusId;
	}
	
	private String componentDesc;
	
	
	
	public String getComponentDesc() {
		return componentDesc;
	}
	public void setComponentDesc(String componentDesc) {
		this.componentDesc = componentDesc;
	}
	public Integer getPumprpm() {
		return pumprpm;
	}
	public void setPumprpm(Integer pumprpm) {
		this.pumprpm = pumprpm;
	}
	public String getFromlocation() {
		return fromlocation;
	}
	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}
	public String getTolocation() {
		return tolocation;
	}
	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}
	public Double getPmlength() {
		return pmlength;
	}
	public void setPmlength(Double pmlength) {
		this.pmlength = pmlength;
	}
	public Integer getMotorNumber() {
		return motorNumber;
	}
	public void setMotorNumber(Integer motorNumber) {
		this.motorNumber = motorNumber;
	}
	public Double getMotormegawatts() {
		return motormegawatts;
	}
	public void setMotormegawatts(Double motormegawatts) {
		this.motormegawatts = motormegawatts;
	}
	public Double getLiftStatic() {
		return liftStatic;
	}
	public void setLiftStatic(Double liftStatic) {
		this.liftStatic = liftStatic;
	}
	public Double getLiftDynamic() {
		return liftDynamic;
	}
	public void setLiftDynamic(Double liftDynamic) {
		this.liftDynamic = liftDynamic;
	}
	public Integer getNoofpumpdays() {
		return noofpumpdays;
	}
	public Double getTotalLift() {
		return totalLift;
	}
	public void setTotalLift(Double totalLift) {
		this.totalLift = totalLift;
	}
	public Integer getLiftperiod() {
		return liftperiod;
	}
	public void setLiftperiod(Integer liftperiod) {
		this.liftperiod = liftperiod;
	}
	public Double getLifttmc() {
		return lifttmc;
	}
	public void setLifttmc(Double lifttmc) {
		this.lifttmc = lifttmc;
	}
	public Double getMddl() {
		return mddl;
	}
	public void setMddl(Double mddl) {
		this.mddl = mddl;
	}
	public Double getDeliveryLevel() {
		return deliveryLevel;
	}
	public void setDeliveryLevel(Double deliveryLevel) {
		this.deliveryLevel = deliveryLevel;
	}
	public Double getEachmotorPower() {
		return eachmotorPower;
	}
	public void setEachmotorPower(Double eachmotorPower) {
		this.eachmotorPower = eachmotorPower;
	}
	public Double getAuxPower() {
		return auxPower;
	}
	public void setAuxPower(Double auxPower) {
		this.auxPower = auxPower;
	}
	public Double getTotalpowerwithAux() {
		return totalpowerwithAux;
	}
	public void setTotalpowerwithAux(Double totalpowerwithAux) {
		this.totalpowerwithAux = totalpowerwithAux;
	}
	public String getSubstationCapacity() {
		return substationCapacity;
	}
	public void setSubstationCapacity(String substationCapacity) {
		this.substationCapacity = substationCapacity;
	}
	public Double getSubupcapacity() {
		return subupcapacity;
	}
	public void setSubupcapacity(Double subupcapacity) {
		this.subupcapacity = subupcapacity;
	}
	public Double getSubdowncapacity() {
		return subdowncapacity;
	}
	public void setSubdowncapacity(Double subdowncapacity) {
		this.subdowncapacity = subdowncapacity;
	}
	public String getSubstationdivision() {
		return substationdivision;
	}
	public void setSubstationdivision(String substationdivision) {
		this.substationdivision = substationdivision;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public void setNoofpumpdays(Integer noofpumpdays) {
		this.noofpumpdays = noofpumpdays;
	}
	
	public Double getAnnualpowerconsumption() {
		return annualpowerconsumption;
	}
	public void setAnnualpowerconsumption(Double annualpowerconsumption) {
		this.annualpowerconsumption = annualpowerconsumption;
	}
	
	public Double getAyacutacres() {
		return ayacutacres;
	}
	public void setAyacutacres(Double ayacutacres) {
		this.ayacutacres = ayacutacres;
	}
	public String getPumpType() {
		return pumpType;
	}
	public void setPumpType(String pumpType) {
		this.pumpType = pumpType;
	}
	public String getPumpMake() {
		return pumpMake;
	}
	public void setPumpMake(String pumpMake) {
		this.pumpMake = pumpMake;
	}
	public String getMotorMake() {
		return motorMake;
	}
	public void setMotorMake(String motorMake) {
		this.motorMake = motorMake;
	}
	public String getMotorType() {
		return motorType;
	}
	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getComponentId() {
		return componentId;
	}
	public Double getComponentLength() {
		return componentLength;
	}
	public void setComponentLength(Double componentLength) {
		this.componentLength = componentLength;
	}
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public Integer getComponentLevelId() {
		return componentLevelId;
	}
	public void setComponentLevelId(Integer componentLevelId) {
		this.componentLevelId = componentLevelId;
	}
	public String getComponentType() {
		return componentType;
	}
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}
	public Integer getComponentTypeId() {
		return componentTypeId;
	}
	public void setComponentTypeId(Integer componentTypeId) {
		this.componentTypeId = componentTypeId;
	}
	public Double getOfftakeChainage() {
		return offtakeChainage;
	}
	public void setOfftakeChainage(Double offtakeChainage) {
		this.offtakeChainage = offtakeChainage;
	}
	public Integer getComponentDirection() {
		return componentDirection;
	}
	public Double getPipediameter() {
		return pipediameter;
	}
	public void setPipediameter(Double pipediameter) {
		this.pipediameter = pipediameter;
	}
	public Integer getNoofpiperows() {
		return noofpiperows;
	}
	public void setNoofpiperows(Integer noofpiperows) {
		this.noofpiperows = noofpiperows;
	}
	public void setComponentDirection(Integer componentDirection) {
		this.componentDirection = componentDirection;
	}
	public String getComponentCategory() {
		return componentCategory;
	}
	public void setComponentCategory(String componentCategory) {
		this.componentCategory = componentCategory;
	}
	public Integer getComponentCategoryId() {
		return componentCategoryId;
	}
	public void setComponentCategoryId(Integer componentCategoryId) {
		this.componentCategoryId = componentCategoryId;
	}
	public Double getCubicCapacity() {
		return cubicCapacity;
	}
	public void setCubicCapacity(Double cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}
	
	public String getTailendStructure() {
		return tailendStructure;
	}
	public void setTailendStructure(String tailendStructure) {
		this.tailendStructure = tailendStructure;
	}
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getParentComponent() {
		return parentComponent;
	}
	public void setParentComponent(String parentComponent) {
		this.parentComponent = parentComponent;
	}
	public Integer getParentComponentId() {
		return parentComponentId;
	}
	public void setParentComponentId(Integer parentComponentId) {
		this.parentComponentId = parentComponentId;
	}
	public Integer getParentLevelId() {
		return parentLevelId;
	}
	public void setParentLevelId(Integer parentLevelId) {
		this.parentLevelId = parentLevelId;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}
	public String getLastUpdatedByUser() {
		return lastUpdatedByUser;
	}
	public void setLastUpdatedByUser(String lastUpdatedByUser) {
		this.lastUpdatedByUser = lastUpdatedByUser;
	}
	public Integer getReservoirId() {
		return reservoirId;
	}
	public void setReservoirId(Integer reservoirId) {
		this.reservoirId = reservoirId;
	}
	public ProjectComponent getProjcomponent() {
		return projcomponent;
	}
	public void setProjcomponent(ProjectComponent projcomponent) {
		this.projcomponent = projcomponent;
	}
	public String getProgressString() {
		return progressString;
	}
	public void setProgressString(String progressString) {
		this.progressString = progressString;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<ComponentLineSegment> getSegments() {
		return segments;
	}
	public void setSegments(List<ComponentLineSegment> segments) {
		this.segments = segments;
	}
	public Integer getStructureTypeId() {
		return structureTypeId;
	}
	public void setStructureTypeId(Integer structureTypeId) {
		this.structureTypeId = structureTypeId;
	}
	public String getStructureType() {
		return StructureType;
	}
	public void setStructureType(String structureType) {
		StructureType = structureType;
	}
	public Integer getCompPackId() {
		return compPackId;
	}
	public void setCompPackId(Integer compPackId) {
		this.compPackId = compPackId;
	}
	public Integer getCompId0() {
		return compId0;
	}
	public void setCompId0(Integer compId0) {
		this.compId0 = compId0;
	}
	public Integer getCompId1() {
		return compId1;
	}
	public void setCompId1(Integer compId1) {
		this.compId1 = compId1;
	}
	public Integer getCompId2() {
		return compId2;
	}
	public void setCompId2(Integer compId2) {
		this.compId2 = compId2;
	}
	public Integer getCompId3() {
		return compId3;
	}
	public void setCompId3(Integer compId3) {
		this.compId3 = compId3;
	}
	public Integer getCompId4() {
		return compId4;
	}
	public void setCompId4(Integer compId4) {
		this.compId4 = compId4;
	}
	public Integer getCompId5() {
		return compId5;
	}
	public void setCompId5(Integer compId5) {
		this.compId5 = compId5;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getFromKm() {
		return fromKm;
	}
	public void setFromKm(Double fromKm) {
		this.fromKm = fromKm;
	}
	public Double getToKm() {
		return toKm;
	}
	public void setToKm(Double toKm) {
		this.toKm = toKm;
	}
	

	
	
	
	@Override
	public String toString() {
		return "Component [componentId=" + componentId + ", componentName=" + componentName + ", componentLevelId="
				+ componentLevelId + ", componentType=" + componentType + ", componentTypeId=" + componentTypeId
				+ ", offtakeChainage=" + offtakeChainage + ", componentDirection=" + componentDirection
				+ ", componentCategory=" + componentCategory + ", componentCategoryId=" + componentCategoryId
				+ ", cubicCapacity=" + cubicCapacity + ", componentLength=" + componentLength + ", tailendStructure="
				+ tailendStructure + ", structureType=" + structureType + ", projectId=" + projectId
				+ ", parentComponent=" + parentComponent + ", parentComponentId=" + parentComponentId
				+ ", parentLevelId=" + parentLevelId + ", creationDate=" + creationDate + ", lastUpdatedDate="
				+ lastUpdatedDate + ", createdByUser=" + createdByUser + ", lastUpdatedByUser=" + lastUpdatedByUser
				+ ", reservoirId=" + reservoirId + ", projcomponent=" + projcomponent + ", progressString="
				+ progressString + ", remarks=" + remarks + ", segments=" + segments + ", structureTypeId="
				+ structureTypeId + ", StructureType=" + StructureType + ", compPackId=" + compPackId + ", projectName="
				+ projectName + ", levelId=" + levelId + ", userId=" + userId + ", connectedLoad=" + connectedLoad
				+ ", actualLoad=" + actualLoad + ", pumpconnectedLoad=" + pumpconnectedLoad + ", pumpactualLoad="
				+ pumpactualLoad + ", motorconnectedLoad=" + motorconnectedLoad + ", motoractualLoad=" + motoractualLoad
				+ ", motorrpm=" + motorrpm + ", avgrpm=" + avgrpm + ", compId0=" + compId0 + ", compId1=" + compId1
				+ ", compId2=" + compId2 + ", compId3=" + compId3 + ", compId4=" + compId4 + ", compId5=" + compId5
				+ ", packageId=" + packageId + ", unitId=" + unitId + ", circleId=" + circleId + ", divisionId="
				+ divisionId + ", subdivisionId=" + subdivisionId + ", unitName=" + unitName + ", circleName="
				+ circleName + ", divisionName=" + divisionName + ", subdivisionName=" + subdivisionName
				+ ", packageName=" + packageName + ", user=" + user + ", fromKm=" + fromKm + ", toKm=" + toKm
				+ ", fromlocation=" + fromlocation + ", tolocation=" + tolocation + ", pmlength=" + pmlength
				+ ", motorNumber=" + motorNumber + ", pumpNumber=" + pumpNumber + ", motorload=" + motorload
				+ ", pumpload=" + pumpload + ", motormegawatts=" + motormegawatts + ", liftStatic=" + liftStatic
				+ ", liftStaticsign=" + liftStaticsign + ", liftDynamic=" + liftDynamic + ", liftDynamicsign="
				+ liftDynamicsign + ", staticlift=" + staticlift + ", dynamiclift=" + dynamiclift + ", noofpumpdays="
				+ noofpumpdays + ", annualpowerconsumption=" + annualpowerconsumption + ", dischrgecusecs="
				+ dischrgecusecs + ", pipediameter=" + pipediameter + ", noofpiperows=" + noofpiperows + ", totalLift="
				+ totalLift + ", liftperiod=" + liftperiod + ", lifttmc=" + lifttmc + ", mddl=" + mddl
				+ ", deliveryLevel=" + deliveryLevel + ", eachmotorPower=" + eachmotorPower + ", auxPower=" + auxPower
				+ ", totalpowerwithAux=" + totalpowerwithAux + ", substationCapacity=" + substationCapacity
				+ ", subupcapacity=" + subupcapacity + ", subdowncapacity=" + subdowncapacity + ", substationdivision="
				+ substationdivision + ", statusId=" + statusId + ", totalpower=" + totalpower + ", districtId="
				+ districtId + ", mandalId=" + mandalId + ", villageId=" + villageId + ", mddlsign=" + mddlsign
				+ ", deliverylevelsign=" + deliverylevelsign + ", stageId=" + stageId + ", phaseId=" + phaseId
				+ ", districtName=" + districtName + ", mandalName=" + mandalName + ", villageName=" + villageName
				+ ", hiddenProjId=" + hiddenProjId + ", hiddenPackId=" + hiddenPackId + ", hiddencircleId="
				+ hiddencircleId + ", hiddendivisionId=" + hiddendivisionId + ", hiddenSubdivId=" + hiddenSubdivId
				+ ", hiddencompParentId=" + hiddencompParentId + ", hiddenMandalId=" + hiddenMandalId
				+ ", hiddenVillageId=" + hiddenVillageId + ", substationHV=" + substationHV + ", substationLV="
				+ substationLV + ", stageName=" + stageName + ", phaseName=" + phaseName + ", ayacutacres="
				+ ayacutacres + ", pumpType=" + pumpType + ", pumpMake=" + pumpMake + ", motorMake=" + motorMake
				+ ", motorType=" + motorType + ", status=" + status + ", pumprpm=" + pumprpm + ", pumpcapacity="
				+ pumpcapacity + ", motorcapacity=" + motorcapacity + ", pumpstatusId=" + pumpstatusId
				+ ", motorstatusId=" + motorstatusId + ", pumpmakeId=" + pumpmakeId + ", motormakeId=" + motormakeId
				+ ", financialyear=" + financialyear + ", statusColor=" + statusColor + ", statusAddress="
				+ statusAddress + ", deleteFlag=" + deleteFlag + ", editFlag=" + editFlag + ", componentPowerAyacutId="
				+ componentPowerAyacutId + ", compInfoId=" + compInfoId + ", pumpcapacityId=" + pumpcapacityId
				+ ", motorcapacityId=" + motorcapacityId + ", pumptypeId=" + pumptypeId + ", motortypeId=" + motortypeId
				+ ", typepumpmotor=" + typepumpmotor + ", motorMakeName=" + motorMakeName + ", motorTypeName="
				+ motorTypeName + ", pumpList=" + pumpList + ", motorList=" + motorList + ", componentDesc="
				+ componentDesc + "]";
	}

	

}
