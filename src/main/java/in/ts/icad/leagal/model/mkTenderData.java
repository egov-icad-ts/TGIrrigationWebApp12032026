package in.ts.icad.leagal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class mkTenderData {
	
	@XmlElement String phase;
	
	@XmlElement String publish_date;
	
	@XmlElement String award_date;

	@XmlElement List<mkTenderData>   mkTenderData ;
	
	
	
	
	
	
	
	
	
	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getAward_date() {
		return award_date;
	}

	public void setAward_date(String award_date) {
		this.award_date = award_date;
	}

	public List<mkTenderData> getMkTenderData() {
		return mkTenderData;
	}

	public void setMkTenderData(List<mkTenderData> mkTenderData) {
		this.mkTenderData = mkTenderData;
	}

	@Override
	public String toString() {
		return "mkTenderData [phase=" + phase + ", publish_date=" + publish_date + ", award_date=" + award_date
				+ ", mkTenderData=" + mkTenderData + "]";
	}
	
	
	

}
