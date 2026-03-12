package in.ts.icad.leagal.model;

public class ComponentLineSegment {
	
	private Integer xCoord;
	private Integer yCoord;
	private Integer length;
	private Double actualLength;
	private String direction;
	private Double scale;
	private Integer componentId;
	private Integer parentId;
	private String componentName;
	private Integer levelId;
	private String progressString;

	private String remarks;
	private String colour;
	private Integer angle;
	private Integer componentWidth;

	private String textXcord;
	private String textYcord;

	private String fromKm;
	private String toKm;
	private String percentageComplete;
	private Double chainageAt;
	private String structureType;
	private boolean flag;

	private Integer x1Coord;
	private Integer y1Coord;

	private Integer x2Coord;
	private Integer y2Coord;
	private Double compLength;
	
	
	
	
	

	public Integer getX1Coord() {
		return x1Coord;
	}

	public void setX1Coord(Integer x1Coord) {
		this.x1Coord = x1Coord;
	}

	public Integer getY1Coord() {
		return y1Coord;
	}

	public void setY1Coord(Integer y1Coord) {
		this.y1Coord = y1Coord;
	}

	public Integer getX2Coord() {
		return x2Coord;
	}

	public void setX2Coord(Integer x2Coord) {
		this.x2Coord = x2Coord;
	}

	public Integer getY2Coord() {
		return y2Coord;
	}

	public void setY2Coord(Integer y2Coord) {
		this.y2Coord = y2Coord;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Double getChainageAt() {
		return chainageAt;
	}

	public void setChainageAt(Double chainageAt) {
		this.chainageAt = chainageAt;
	}

	public String getStructureType() {
		return structureType;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public String getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(String percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	public String getFromKm() {
		return fromKm;
	}

	public Integer getComponentId() {
		return componentId;
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

	public Integer getComponentWidth() {
		return componentWidth;
	}

	public void setComponentWidth(Integer componentWidth) {
		this.componentWidth = componentWidth;
	}

	public void setFromKm(String fromKm) {
		this.fromKm = fromKm;
	}

	public String getToKm() {
		return toKm;
	}

	public void setToKm(String toKm) {
		this.toKm = toKm;
	}

	private Double componentLength;

	public Double getComponentLength() {
		return componentLength;
	}

	public Double getCompLength() {
		return compLength;
	}

	public void setCompLength(Double compLength) {
		this.compLength = compLength;
	}

	public void setComponentLength(Double componentLength) {
		this.componentLength = componentLength;
	}

	public String getTextXcord() {
		return textXcord;
	}

	public void setTextXcord(String textXcord) {
		this.textXcord = textXcord;
	}

	public String getTextYcord() {
		return textYcord;
	}

	public void setTextYcord(String textYcord) {
		this.textYcord = textYcord;
	}

	private ComponentLineSegment textSegment;

	public ComponentLineSegment getTextSegment() {
		return textSegment;
	}

	public void setTextSegment(ComponentLineSegment textSegment) {
		this.textSegment = textSegment;
	}

	public Integer getxCoord() {
		return xCoord;
	}

	public String getProgressString() {
		return progressString;
	}

	public void setProgressString(String progressString) {
		this.progressString = progressString;
	}

	public void setxCoord(Integer xCoord) {
		this.xCoord = xCoord;
	}

	public Integer getyCoord() {
		return yCoord;
	}

	public void setyCoord(Integer yCoord) {
		this.yCoord = yCoord;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Double getActualLength() {
		return actualLength;
	}

	public void setActualLength(Double actualLength) {
		this.actualLength = actualLength;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Integer getAngle() {
		return angle;
	}

	public void setAngle(Integer angle) {
		this.angle = angle;
	}

	

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	@Override
	public String toString() {
		return "ComponentLineSegment [xCoord=" + xCoord + ", yCoord=" + yCoord + ", length=" + length
				+ ", actualLength=" + actualLength + ", direction=" + direction + ", scale=" + scale + ", componentId="
				+ componentId + ", parentId=" + parentId + ", componentName=" + componentName + ", levelId=" + levelId
				+ ", progressString=" + progressString + ", remarks=" + remarks + ", colour=" + colour + ", angle="
				+ angle + ", componentWidth=" + componentWidth + ", textXcord=" + textXcord + ", textYcord=" + textYcord
				+ ", fromKm=" + fromKm + ", toKm=" + toKm + ", percentageComplete=" + percentageComplete
				+ ", chainageAt=" + chainageAt + ", structureType=" + structureType + ", flag=" + flag + ", x1Coord="
				+ x1Coord + ", y1Coord=" + y1Coord + ", x2Coord=" + x2Coord + ", y2Coord=" + y2Coord + ", componentLength="
				+ componentLength + ", textSegment=" + textSegment + "]";
	}

	
}
