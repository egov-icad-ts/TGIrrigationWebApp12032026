package in.ts.icad.leagal.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.IRParasAdminDAO;
import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.manager.IRParasAdminManager;
import in.ts.icad.leagal.model.CAGParas;
import in.ts.icad.leagal.model.CAGParasData;
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.ReservoirInspect;

@Component
public class IRParasAdminManagerImpl implements IRParasAdminManager {
	
	@Autowired
	private IRParasAdminDAO IRpad;

	@Override
	public Integer insertParas(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertParas(paraObj);
	}

	@Override
	public Integer insertParasDocuments(Paras paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertParasDocuments(paraobj);
	}

	@Override
	public Integer insertParasReply(Paras paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertParasReply(paraobj);
	}

	@Override
	public Integer insertParasTransfer(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertParasTransfer(paraObj);
	}

	@Override
	public Integer deleteParasDocsById(Integer docId, Integer userId,String userName) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.deleteParasDocsById(docId,userId,userName);
	}

	@Override
	public Integer deleteParasReplyById(Integer paraReplyId,Integer userId,String userName) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.deleteParasReplyById(paraReplyId,userId,userName);
	}

	@Override
	public Integer deleteParasReplyDocs(Integer paraId,Integer userId,String userName) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.deleteParasReplyDocs(paraId,userId,userName);
	}

	@Override
	public Paras getParaforedit(Integer paraId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getParaforedit(paraId);
	}

	@Override
	public Integer editParas(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editParas(paraObj);
	}

	@Override
	public Integer editParasDocuments(Paras paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editParasDocuments(paraobj);
	}

	@Override
	public Integer editParasReply(ReplyData replyObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editParasReply(replyObj);
	}

	@Override
	public List<ReplyData> getAllReplys() throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getAllReplys();
	}

	@Override
	public Integer editParasTransfer(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editParasTransfer(paraObj);
	}

	@Override
	public Integer editmultipleParasReply(Paras paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editmultipleParasReply(paraobj);
	}

	@Override
	public List<Map<String, Object>> generalqueryforresult(String generalquery) {
		// TODO Auto-generated method stub
		return IRpad.generalqueryforresult(generalquery);
	}

	@Override
	public List<Paras> getParasAbstractByUnit(Integer unitId, Integer circleId, Integer divisionId)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getParasAbstractByUnit(unitId, circleId, divisionId);
	}

	@Override
	public Integer getCountOfParaDocs() throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCountOfParaDocs();
	}

	@Override
	public List<Paras> getCAGParasAbstractByUnit(Integer unitId, Integer circleId, Integer divisionId)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCAGParasAbstractByUnit(unitId, circleId, divisionId);
	}

	@Override
	public Integer insertCAGParas(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertCAGParas(paraObj);
	}

	@Override
	public Integer insertCAGParasTransfer(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertCAGParasTransfer(paraObj);
	}

	@Override
	public Integer insertCAGParasDocuments(CAGParas paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertCAGParasDocuments(paraobj);
	}

	@Override
	public Integer insertCAGParasReply(CAGParas paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertCAGParasReply(paraobj);
	}

	@Override
	public Integer insertCAGParasMaster(CAGParasData paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertCAGParasMaster(paraobj);
	}

	@Override
	public List<CAGParas> getCAGGistByUnit(Integer unitId)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCAGGistByUnit(unitId);
	}

	/*
	@Override
	public Integer insertnewCAGPara(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertnewCAGPara(paraObj);
	}*/

	@Override
	public Integer addCAGParasReply(ReplyData replyObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.addCAGParasReply(replyObj);
	}

	@Override
	public Integer getCountOfCAGParaDocs() throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCountOfCAGParaDocs();
	}

	@Override
	public List<ReplyData> getCAGReplybyParaId(Integer cagParaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCAGReplybyParaId(cagParaId);
	}

	@Override
	public List<ParaDocuments> getCAGDocsByParaId(Integer cagParaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCAGDocsByParaId(cagParaId);
	}

	@Override
	public Integer deleteCAGGistParasReplyDocs(Integer cagGistId,  String userName)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.deleteCAGGistParasReplyDocs(cagGistId, userName);
	}

	@Override
	public Integer deleteCAGParasReplyByParaId(Integer cagParaId,  String userName)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.deleteCAGParasReplyByParaId(cagParaId,  userName);
	}

	@Override
	public Integer deleteCAGReplyByReplyId(Integer cagReplyId,  String userName)
			throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.deleteCAGReplyByReplyId(cagReplyId,  userName);
	}

	@Override
	public Integer deleteCAGDocsByDocId(Integer cagDocId,  String userName) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.deleteCAGDocsByDocId(cagDocId,  userName);
	}

	@Override
	public CAGParas getCAGGistByGistId(Integer cagGistId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCAGGistByGistId(cagGistId);
	}

	

	

	@Override
	public Integer editcagGistParas(Integer cagGistId,String finYear, String paraNum, String actionTitle, String userName) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editcagGistParas(cagGistId ,finYear,paraNum,actionTitle,userName);
	}

	@Override
	public Integer editCAGParasTransfer(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editCAGParasTransfer(paraObj);
	}

	@Override
	public Integer UpdateTrCAGGistIdByGistId(Integer oldcagGistId, Integer newcagGistId, Integer userId,
			String userName) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.UpdateTrCAGGistIdByGistId(oldcagGistId, newcagGistId, userId, userName);
	}

	@Override
	public List<CAGParas> getCAGFinancialYear() throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCAGFinancialYear();
	}

	@Override
	public CAGParas getCAGParaGist(Integer cagGistId) throws IRParasUserException {
		// TODO Auto-generated method stub;
		return IRpad.getCAGParaGist(cagGistId);
	}

	@Override
	public Integer insertcagparaunitmap(List<CAGParasData> paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertcagparaunitmap(paraobj);
	}

	@Override
	public List<CAGParasData> selectCAGSubParaList(Integer cagGistId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.selectCAGSubParaList(cagGistId);
	}

	@Override
	public List<CAGParas> getCAGParaGistbyFinYear(String finYear) throws IRParasUserException {
		// TODO Auto-generated method stub
		return  IRpad.getCAGParaGistbyFinYear(finYear);
	}

	@Override
	public CAGParasData selectSubParaListbyPara(Integer cagParaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.selectSubParaListbyPara(cagParaId);
	}

	@Override
	public List<Integer> getUnitListUnitMap(Integer cagParaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getUnitListUnitMap(cagParaId);
	}

	

	@Override
	public Integer editcagsubParas(CAGParasData paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editcagsubParas(paraObj);
	}

	@Override
	public Integer deleteunitmapbyunit(List<CAGParasData> paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.deleteunitmapbyunit(paraobj);
	}

	@Override
	public List<CAGParasData> getCAGParaAllbyunitId(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCAGParaAllbyunitId(paraObj);
	}

	@Override
	public List<CAGParasData> getCAGParaEnci(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCAGParaEnci(paraObj);
	}

	@Override
	public ReplyData getCAGReplybyreplyid(Integer cagReplyId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCAGReplybyreplyid(cagReplyId);
	}

	@Override
	public Integer editCagParasReply(ReplyData replyObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editCagParasReply(replyObj);
	}

	@Override
	public Integer insertParaMasterSub(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertParaMasterSub(paraObj);
	}

	@Override
	public List<Paras> getSubParaforedit(Integer paraId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getSubParaforedit(paraId);
	}

	@Override
	public Integer editSubParas(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editSubParas(paraObj);
	}

	@Override
	public Integer insertParasDataInfo(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertParasDataInfo(paraObj);
	}

	@Override
	public List<Paras> getParaYearByOffice(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getParaYearByOffice(paraObj);
	}

	@Override
	public List<Paras> getParagistByYearByOffice(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getParagistByYearByOffice(paraObj);
	}

	@Override
	public List<Paras> getSubParadataByParaId(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getSubParadataByParaId(paraObj);
	}

	@Override
	public List<ReplyData> getReplybySubParaId(Integer subParaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getReplybySubParaId(subParaId);
	}

	@Override
	public List<ParaDocuments> getDocsBySubParaId(Integer subParaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getDocsBySubParaId(subParaId);
	}

	@Override
	public List<Paras> getSubParabysubparaId(Integer subparaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getSubParabysubparaId(subparaId);
	}

	@Override
	public Integer deleteSubParaReplyDocs(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.deleteSubParaReplyDocs(paraObj);
	}

	@Override
	public List<ReplyData> getReplybyparaReplyId(Integer parareplyId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return  IRpad.getReplybyparaReplyId(parareplyId);
	}

	@Override
	public Integer editParasReplyByReplyId(ReplyData rdataObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.editParasReplyByReplyId(rdataObj);
	}

	@Override
	public Paras getParaforreportbyParaId(Integer paraId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getParaforreportbyParaId(paraId);
	}

	@Override
	public Paras getParatransferdreportbyParaId(Integer paraId) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getParatransferdreportbyParaId(paraId);
	}

	@Override
	public Integer insertcagStatus(CAGParasData paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.insertcagStatus(paraObj);
	}

	@Override
	public List<CAGParasData> selectPACCAGSubParaList(CAGParasData parObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.selectPACCAGSubParaList(parObj);
	}

	@Override
	public List<ParaDocuments> getCAGDocs(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		return IRpad.getCAGDocs(paraObj);
	}

	
	
	
	
	
	
	
}
