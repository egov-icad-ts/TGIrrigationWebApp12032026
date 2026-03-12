package in.ts.icad.leagal.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement 
public class mkTankData {
	
	@XmlElement public String tank_code;

	@XmlElement public String tank_name;
	
	@XmlElement public String vname;
	
	@XmlElement String tank_id;
	
	@XmlElement String dname;
	
	@XmlElement String mname;
	
	@XmlElement String hname;
	
	
	@XmlElement String geo_id;

	@XmlElement List<mkTankData>   mkTankData ;

	
	
	
	
	public String getTank_code() {
		return tank_code;
	}


	public void setTank_code(String tank_code) {
		this.tank_code = tank_code;
	}


	public String getTank_name() {
		return tank_name;
	}


	public void setTank_name(String tank_name) {
		this.tank_name = tank_name;
	}


	public String getVname() {
		return vname;
	}


	public void setVname(String vname) {
		this.vname = vname;
	}


	public String getTank_id() {
		return tank_id;
	}


	public void setTank_id(String tank_id) {
		this.tank_id = tank_id;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getHname() {
		return hname;
	}


	public void setHname(String hname) {
		this.hname = hname;
	}


	public String getGeo_id() {
		return geo_id;
	}


	public void setGeo_id(String geo_id) {
		this.geo_id = geo_id;
	}


	public List<mkTankData> getMkTankData() {
		return mkTankData;
	}


	public void setMkTankData(List<mkTankData> mkTankData) {
		this.mkTankData = mkTankData;
	}


	@Override
	public String toString() {
		return "mkTankData [tank_code=" + tank_code + ", tank_name=" + tank_name + ", vname=" + vname + ", tank_id="
				+ tank_id + ", dname=" + dname + ", mname=" + mname + ", hname=" + hname + ", geo_id=" + geo_id
				+ ", mkTankData=" + mkTankData + "]";
	}
	
	
	
}
