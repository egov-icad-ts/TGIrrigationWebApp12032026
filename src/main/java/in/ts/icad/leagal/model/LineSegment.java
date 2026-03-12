package in.ts.icad.leagal.model;

public class LineSegment {

	private Integer xCoord;
	private Integer yCoord;
	private Integer length;
	private Double actualLength;
	private String direction;
	private Double scale;
	private Integer canalId;
	private Integer parentId;
	private String canalName;
	private Integer levelId;
	private String progressString;

	private String remarks;
	private String colour;
	private Integer angle;
	private Integer canalWidth;

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

	public void setFromKm(String fromKm) {
		this.fromKm = fromKm;
	}

	public String getToKm() {
		return toKm;
	}

	public void setToKm(String toKm) {
		this.toKm = toKm;
	}

	private Double canalLength;

	public Double getCanalLength() {
		return canalLength;
	}

	public void setCanalLength(Double canalLength) {
		this.canalLength = canalLength;
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

	private LineSegment textSegment;

	public LineSegment getTextSegment() {
		return textSegment;
	}

	public void setTextSegment(LineSegment textSegment) {
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

	public Integer getCanalId() {
		return canalId;
	}

	public void setCanalId(Integer canalId) {
		this.canalId = canalId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getCanalName() {
		return canalName;
	}

	public void setCanalName(String canalName) {
		this.canalName = canalName;
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

	public Integer getCanalWidth() {
		return canalWidth;
	}

	public void setCanalWidth(Integer canalWidth) {
		this.canalWidth = canalWidth;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	@Override
	public String toString() {
		return "LineSegment [xCoord=" + xCoord + ", yCoord=" + yCoord + ", length=" + length + ", actualLength="
				+ actualLength + ", direction=" + direction + ", scale=" + scale + ", canalId=" + canalId
				+ ", parentId=" + parentId + ", canalName=" + canalName + ", levelId=" + levelId + ", progressString="
				+ progressString + ", remarks=" + remarks + ", colour=" + colour + ", angle=" + angle + ", canalWidth="
				+ canalWidth + ", textXcord=" + textXcord + ", textYcord=" + textYcord + ", fromKm=" + fromKm
				+ ", toKm=" + toKm + ", percentageComplete=" + percentageComplete + ", canalLength=" + canalLength
				+ ", textSegment=" + textSegment + "]";
	}

}
