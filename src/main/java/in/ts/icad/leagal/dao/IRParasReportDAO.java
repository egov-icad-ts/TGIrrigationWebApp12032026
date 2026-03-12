package in.ts.icad.leagal.dao;

import java.util.List;

import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.model.CAGParas;
import in.ts.icad.leagal.model.CAGParasData;
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.officeDataSend;

public interface IRParasReportDAO {
	
	public List<Paras> getParasAbstarctCount(Paras paraObj) throws IRParasUserException;
	public List<Paras> getParasTotal(Integer sectionId,Integer paraStatusId,Boolean trFlag) throws IRParasUserException;
	public List<ReplyData> getReplyAll( ) throws IRParasUserException;
	public List<Paras> getParasByUnit( Paras paraObj) throws IRParasUserException;
	
	public List<ParaDocuments> getDocsAll( ) throws IRParasUserException;
	public List<Paras> getParasByOffice( Integer unitId,Integer circleId, Integer divisionId ) throws IRParasUserException;
	public List<Paras> getParasAbstarctCountByoffice( ) throws IRParasUserException;
	public List<Paras> getParasAbstractTotal(Integer sectionId,Integer paraStatusId ) throws IRParasUserException;
	public List<Paras> getParasAbstractByUnit( Paras paraObj ) throws IRParasUserException;
	
	
	public List<Paras> getParasAbstarctCountByUnitTot(Paras paraObj ) throws IRParasUserException;
	public List<Paras> getParasAbstarctCountByCirTot( Paras paraObj) throws IRParasUserException;
	public List<Paras> getParasAbstarctCountBySubDiv( Paras paraObj) throws IRParasUserException;
	public List<Paras> getParasAbstarctCountByDivision( Paras paraObj) throws IRParasUserException;
	public List<Paras> getParasAbstarctCountByCircle(Paras paraObj) throws IRParasUserException;
	public List<Paras> getParasAbstarctCountByUnit(Paras paraObj ) throws IRParasUserException;

	public List<Paras> getCountWithoutCircleByDivision(Paras paraObj  ) throws IRParasUserException ;
	public List<ReplyData> getReplybyParaId(Integer paraId ) throws IRParasUserException;
	public List<ParaDocuments> getDocsByParaId(Integer ParaId ) throws IRParasUserException ;
	public List<Paras> getParasByOfficePdf( Integer unitId,Integer circleId, Integer divisionId ) throws IRParasUserException ;
	public List<CAGParas> getCAGParasAbstarctCount(CAGParas paraObj ) throws IRParasUserException;
	
	public List<CAGParas> getCAGParasAbstarctCountByUnit( Integer unitId ) throws IRParasUserException ;
	public List<CAGParas> getCAGParasAbstarctCountByCircle(Integer unitId  ) throws IRParasUserException;
	public List<CAGParas> getCAGParasAbstarctCountByDivision(Integer unitId  ) throws IRParasUserException;
	public List<CAGParas> getCAGCountWithoutCircleByDivision(Integer unitId  ) throws IRParasUserException;
	public List<CAGParas> getCAGParasAbstarctCountBySubDiv( Integer unitId ) throws IRParasUserException;
	public List<CAGParas> getCAGParasAbstarctCountByCirTot(Integer unitId  ) throws IRParasUserException;
	
	public List<CAGParas> getCAGParasAbstarctCountByUnitTot(Integer unitId  ) throws IRParasUserException;
	public List<CAGParasData> getCAGParasByUnit(  CAGParasData paraobj ) throws IRParasUserException ;
	public List<CAGParas> getCAGParasTotal(Integer paraStatusId , Boolean trFlag) throws IRParasUserException;
	public List<CAGParas> getCAGParasAbstractByUnit( Integer unitId,Integer circleId, Integer divisionId, Integer paraStatusId,String circleTotal,String unitTotal,Boolean trFlag ) throws IRParasUserException;
	
	public List<CAGParasData> getCAGParasbyGistId(Integer cagParaId,Integer unitId ) throws IRParasUserException ;
	public List<ReplyData> getCAGReplybyGistId(CAGParasData paraObj) throws IRParasUserException;
	public List<CAGParas> getCAGParasByOffice( Integer cagGistId ) throws IRParasUserException;
	
	public List<CAGParasData> getCAGParastotalDetail() throws IRParasUserException;
	public List<ReplyData> getCAGReplyALL( ) throws IRParasUserException;
	public List<CAGParas> getCAGParasByOfficePdf( Integer unitId,Integer circleId, Integer divisionId ) throws IRParasUserException;
	public List<CAGParasData> getCAGParasbyParaId(Integer cagParaId ) throws IRParasUserException;
	public List<ParaDocuments> CAGgetDocsAll(CAGParasData paraObj ) throws IRParasUserException;
	public CAGParas getCAGGistByOfficePdfnew( Integer cagGistId) throws IRParasUserException;
	public List<ReplyData> getReplysWithAllReplys( ) throws IRParasUserException;
	
	public List<Paras> getParasByUnitPDF( Integer unitId,Integer sectionId, Integer paraStatusId,Boolean trFlag ) throws IRParasUserException;
	public List<Paras> getParasTotalPDF(Integer sectionId,Integer paraStatusId , Boolean trFlag) throws IRParasUserException;
	
	public List<officeDataSend> getOfficeUserNamePwd(officeDataSend  officeObj ) throws IRParasUserException;
	public List<Paras> getParasByUnitDOCPDF( Paras paraObj ) throws IRParasUserException;
	
	public List<Paras> getParasAbstractByUnitPDF( Paras paraObj ) throws IRParasUserException;
	public List<officeDataSend> getOfficeEmailId(officeDataSend officeObj) throws IRParasUserException;
	public List<Paras> getParasTotalDOCPDF(Integer sectionId,Integer paraStatusId , Boolean trFlag) throws IRParasUserException;
	
	public List<ReplyData> getReplyAllbyOffice(Paras paraObj) throws IRParasUserException;
	public List<ParaDocuments> getDocsAllByOffice(Paras paraObj) throws IRParasUserException;
	public List<CAGParas> getCAGParasAbstarctYearUnit(CAGParas paraObj ) throws IRParasUserException;
	
	public List<CAGParasData> getCAGParasByYearUnit( CAGParasData paraobj ) throws IRParasUserException;

	public List<CAGParas> getCAGparaFinYear() throws IRParasUserException;

	public List<CAGParas> getCAGParasAbstractUnit(CAGParas paraObj ) throws IRParasUserException;
	
	public List<ReplyData> getCAGReplybyfy(CAGParas paraObj ) throws IRParasUserException;

	
	
}
