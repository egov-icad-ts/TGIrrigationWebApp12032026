package in.ts.icad.leagal.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.IRParasAdminDAO;
import in.ts.icad.leagal.dao.IRParasReportDAO;
import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.manager.IRParasReportManager;
import in.ts.icad.leagal.model.CAGParas;
import in.ts.icad.leagal.model.CAGParasData;
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.officeDataSend;

@Component
public class IRParasReportManagerImpl implements IRParasReportManager {

	
	
	@Autowired
	private IRParasReportDAO Irrd;
	
	
	@Override
	public List<Paras> getParasAbstarctCount(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstarctCount(paraObj);
	}


	@Override
	public List<Paras> getParasTotal(Integer sectionId,Integer paraStatusId , Boolean trFlag) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasTotal(sectionId,paraStatusId,trFlag );
	}


	@Override
	public List<ReplyData> getReplyAll() throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getReplyAll();
	}


	@Override
	public List<Paras> getParasByUnit(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasByUnit(paraObj);
	}


	@Override
	public List<ParaDocuments> getDocsAll() throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getDocsAll();
	}


	@Override
	public List<Paras> getParasByOffice(Integer unitId, Integer circleId, Integer divisionId)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasByOffice(unitId, circleId, divisionId);
	}


	@Override
	public List<Paras> getParasAbstarctCountByoffice() throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstarctCountByoffice();
	}


	@Override
	public List<Paras> getParasAbstractTotal(Integer sectionId, Integer paraStatusId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstractTotal(sectionId, paraStatusId);
	}


	@Override
	public List<Paras> getParasAbstractByUnit(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstractByUnit(paraObj);
	}


	@Override
	public List<Paras> getParasAbstarctCountByUnitTot(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstarctCountByUnitTot(paraObj);
	}


	@Override
	public List<Paras> getParasAbstarctCountByCirTot(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstarctCountByCirTot(paraObj);
	}


	@Override
	public List<Paras> getParasAbstarctCountBySubDiv(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstarctCountBySubDiv(paraObj);
	}


	@Override
	public List<Paras> getParasAbstarctCountByDivision(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstarctCountByDivision(paraObj);
	}


	@Override
	public List<Paras> getParasAbstarctCountByCircle(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstarctCountByCircle(paraObj);
	}


	@Override
	public List<Paras> getParasAbstarctCountByUnit(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstarctCountByUnit(paraObj);
	}


	
	@Override
	public List<Paras> getCountWithoutCircleByDivision(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCountWithoutCircleByDivision(paraObj);
	}


	@Override
	public List<ReplyData> getReplybyParaId(Integer paraId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getReplybyParaId(paraId);
	}


	@Override
	public List<ParaDocuments> getDocsByParaId(Integer ParaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getDocsByParaId(ParaId);
	}


	@Override
	public List<Paras> getParasByOfficePdf(Integer unitId, Integer circleId, Integer divisionId)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasByOfficePdf(unitId, circleId, divisionId);
	}


	@Override
	public List<CAGParas> getCAGParasAbstarctCount(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasAbstarctCount(paraObj);
	}


	@Override
	public List<CAGParas> getCAGParasAbstarctCountByUnit(Integer unitId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasAbstarctCountByUnit(unitId);
	}


	@Override
	public List<CAGParas> getCAGParasAbstarctCountByCircle(Integer unitId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasAbstarctCountByCircle(unitId);
	}


	@Override
	public List<CAGParas> getCAGParasAbstarctCountByDivision(Integer unitId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasAbstarctCountByDivision(unitId);
	}


	@Override
	public List<CAGParas> getCAGCountWithoutCircleByDivision(Integer unitId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGCountWithoutCircleByDivision(unitId);
	}


	@Override
	public List<CAGParas> getCAGParasAbstarctCountBySubDiv(Integer unitId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasAbstarctCountBySubDiv(unitId);
	}


	@Override
	public List<CAGParas> getCAGParasAbstarctCountByCirTot(Integer unitId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasAbstarctCountByCirTot(unitId);
	}


	@Override
	public List<CAGParas> getCAGParasAbstarctCountByUnitTot(Integer unitId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasAbstarctCountByUnitTot(unitId);
	}


	@Override
	public List<CAGParasData> getCAGParasByUnit( CAGParasData paraobj )
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasByUnit(paraobj);
	}


	@Override
	public List<CAGParas> getCAGParasTotal(Integer paraStatusId, Boolean trFlag) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasTotal(paraStatusId, trFlag);
	}


	@Override
	public List<CAGParas> getCAGParasAbstractByUnit(Integer unitId, Integer circleId, Integer divisionId,
			Integer paraStatusId, String circleTotal, String unitTotal, Boolean trFlag) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasAbstractByUnit(unitId, circleId, divisionId, paraStatusId, circleTotal, unitTotal, trFlag);
	}


	@Override
	public List<CAGParasData> getCAGParasbyGistId(Integer cagGistId,Integer unitId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasbyGistId(cagGistId,unitId);
	}


	@Override
	public List<ReplyData> getCAGReplybyGistId(CAGParasData paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGReplybyGistId(paraObj);
	}


	@Override
	public List<CAGParas> getCAGParasByOffice(Integer cagGistId)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasByOffice(cagGistId);
	}


	@Override
	public List<CAGParasData> getCAGParastotalDetail() throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParastotalDetail();
	}


	@Override
	public List<ReplyData> getCAGReplyALL() throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGReplyALL();
	}


	@Override
	public List<CAGParas> getCAGParasByOfficePdf(Integer unitId, Integer circleId, Integer divisionId)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasByOfficePdf(unitId, circleId, divisionId);
	}


	@Override
	public List<CAGParasData> getCAGParasbyParaId(Integer cagParaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasbyParaId(cagParaId);
	}


	@Override
	public List<ParaDocuments> CAGgetDocsAll(CAGParasData paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.CAGgetDocsAll(paraObj);
	}


	@Override
	public CAGParas getCAGGistByOfficePdfnew(Integer cagGistId)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGGistByOfficePdfnew(cagGistId);
	}


	@Override
	public List<ReplyData> getReplysWithAllReplys() throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getReplysWithAllReplys();
	}


	@Override
	public List<Paras> getParasByUnitPDF(Integer unitId, Integer sectionId, Integer paraStatusId, Boolean trFlag)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasByUnitPDF(unitId, sectionId, paraStatusId, trFlag);
	}


	@Override
	public List<Paras> getParasTotalPDF(Integer sectionId, Integer paraStatusId, Boolean trFlag)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasTotalPDF(sectionId, paraStatusId, trFlag);
	}


	@Override
	public List<officeDataSend> getOfficeUserNamePwd(officeDataSend officeObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getOfficeUserNamePwd(officeObj);
	}


	@Override
	public List<Paras> getParasByUnitDOCPDF(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasByUnitDOCPDF(paraObj);
	}


	@Override
	public List<Paras> getParasAbstractByUnitPDF(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasAbstractByUnitPDF(paraObj);
	}


	@Override
	public List<officeDataSend> getOfficeEmailId(officeDataSend dataObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getOfficeEmailId(dataObj);
	}


	@Override
	public List<Paras> getParasTotalDOCPDF(Integer sectionId, Integer paraStatusId, Boolean trFlag)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getParasTotalDOCPDF(sectionId, paraStatusId, trFlag);
	}


	@Override
	public List<ReplyData> getReplyAllbyOffice(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getReplyAllbyOffice(paraObj);
	}


	@Override
	public List<ParaDocuments> getDocsAllByOffice(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getDocsAllByOffice(paraObj);
	}


	@Override
	public List<CAGParas> getCAGParasAbstarctYearUnit(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasAbstarctYearUnit(paraObj);
	}
	
	@Override
	public List<CAGParas> getCAGparaFinYear() throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGparaFinYear();
	}


	@Override
	public List<CAGParasData> getCAGParasByYearUnit(CAGParasData paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasByYearUnit(paraobj);
	}


	@Override
	public List<CAGParas> getCAGParasAbstractUnit(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGParasAbstractUnit(paraObj);
	}


	@Override
	public List<ReplyData> getCAGReplybyfy(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return Irrd.getCAGReplybyfy(paraObj);
	}

   
	
}
