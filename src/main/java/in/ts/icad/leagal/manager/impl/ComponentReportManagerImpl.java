package in.ts.icad.leagal.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.ComponentReportDAO;
import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.manager.ComponentReportManager;
import in.ts.icad.leagal.model.ComponentAyacut;
import in.ts.icad.leagal.model.ComponentsCapacity;
import in.ts.icad.leagal.model.District;


@Component
public class ComponentReportManagerImpl  implements  ComponentReportManager {
	@Autowired
	private ComponentReportDAO cro;
 
	
	@Override
	public List<in.ts.icad.leagal.model.Component> getComponentProgress(Integer projectId) throws ComponentUserException{
		
		
		return cro.getComponentProgress(projectId);
	}


	@Override
	public List<in.ts.icad.leagal.model.Component> getProjectLiftData(Integer projectId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getProjectLiftData(projectId);
	}


	@Override
	public List<ComponentsCapacity> getComponentCapacityAllLifts(Integer statusId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getComponentCapacityAllLifts(statusId);
	}


	@Override
	public List<in.ts.icad.leagal.model.Component> getCompPowerInfo(Integer projectId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getCompPowerInfo(projectId);
	}


	@Override
	public List<in.ts.icad.leagal.model.Component> getCompGoogleMapStatusInfo(Integer projectId)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getCompGoogleMapStatusInfo(projectId);
	}


	@Override
	public List<ComponentAyacut> getMandalAyacutInfo(Integer districtId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getMandalAyacutInfo(districtId);
	}


	@Override
	public List<ComponentAyacut> getConstAyacutSum(Integer districtId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getConstAyacutSum(districtId);
	}


	@Override
	public List<ComponentAyacut> getConstTotalSum() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getConstTotalSum();
	}


	@Override
	public List<ComponentAyacut> getprojTotalbyconstSum(Integer constId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getprojTotalbyconstSum(constId);
	}


	@Override
	public List<ComponentAyacut> getprojTotalbydistconstSum(Integer constId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getprojTotalbydistconstSum(constId);
	}


	@Override
	public List<ComponentAyacut> getDistTotalbyconstSum(Integer constId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getDistTotalbyconstSum(constId);
	}


	@Override
	public List<ComponentAyacut> getMandalTotalbyconstSum(Integer districtId,Integer constId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getMandalTotalbyconstSum(districtId,constId);
	}


	/*@Override
	public List<ComponentAyacut> getprojTotalAllconstSum() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getprojTotalAllconstSum();
	}

*/
	@Override
	public List<ComponentAyacut> getprojTotal() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getprojTotal();
	}


	@Override
	public List<ComponentAyacut> getConstDistManVillage(Integer districtId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getConstDistManVillage(districtId);
	}


	@Override
	public List<ComponentAyacut> getConstDistManVillageByID(Integer constId, Integer districtId, Integer mandalId)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getConstDistManVillageByID(constId, districtId, mandalId);
	}


	@Override
	public List<ComponentAyacut> getVillageByConst(Integer constId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getVillageByConst(constId);
	}


	@Override
	public List<ComponentAyacut> getMandalbyProj(Integer projectId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getMandalbyProj(projectId);
	}


	@Override
	public List<District> getOldDistricts() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getOldDistricts();
	}


	@Override
	public List<ComponentAyacut> getUnitAyacutInfo() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getUnitAyacutInfo();
	}
	
	@Override
	public List<ComponentAyacut> getDistprojAyacutInfo() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getDistprojAyacutInfo();
	}


	@Override
	public List<ComponentAyacut> getProjPackManTotal() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getProjPackManTotal();
	}


	@Override
	public List<ComponentAyacut> getUnitDistrictAyacutInfo() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getUnitDistrictAyacutInfo();
	}


	@Override
	public List<ComponentAyacut> getMandalbyUnit(Integer unitId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getMandalbyUnit(unitId);
	}


	@Override
	public List<ComponentAyacut> getReportProjSeasonCap(ComponentAyacut compObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getReportProjSeasonCap(compObj);
	}


	@Override
	public List<ComponentAyacut> getAyacutJurisdiction() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getAyacutJurisdiction();
	}


	@Override
	public List<ComponentAyacut> getAyacutdivisionMandal() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getAyacutdivisionMandal();
	}


	@Override
	public List<ComponentAyacut> gettestdataforpms() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.gettestdataforpms();
	}


	@Override
	public List<ComponentAyacut> getProjManTotal() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getProjManTotal();
	}


	@Override
	public List<ComponentAyacut> getProjManVillageTotal() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getProjManVillageTotal();
	}


	@Override
	public List<ComponentAyacut> getDistrictManprojTotal() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getDistrictManprojTotal();
	}


	@Override
	public List<ComponentAyacut> getDistManProjAyacutSum(Integer districtId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cro.getDistManProjAyacutSum(districtId);
	}


	
	

}
