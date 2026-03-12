package in.ts.icad.leagal.manager;

import java.util.List;
import java.util.Map;

import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.model.CAGParas;
import in.ts.icad.leagal.model.CAGParasData;
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.ReservoirInspect;

public interface IRParasAdminManager {
	
	public Integer insertParas(final Paras paraObj) throws IRParasUserException ;
	public Integer insertParasDocuments(final Paras paraobj) throws IRParasUserException;
	public Integer insertParasReply(final Paras paraobj) throws IRParasUserException;
	public Integer insertParasTransfer(Paras paraObj) throws IRParasUserException;
	public Integer deleteParasDocsById(Integer docId,Integer userId,String userName) throws IRParasUserException;
	public Integer deleteParasReplyById(Integer paraReplyId,Integer userId,String userName) throws IRParasUserException;
	public Integer deleteParasReplyDocs(Integer paraId,Integer userId,String userName) throws IRParasUserException;
	public Paras getParaforedit(Integer paraId) throws IRParasUserException;
	public Integer editParas(final Paras paraObj) throws IRParasUserException;
	public Integer editParasDocuments(final Paras paraobj) throws IRParasUserException;
	public Integer editParasReply(final ReplyData replyObj) throws IRParasUserException;
	public List<ReplyData> getAllReplys( ) throws IRParasUserException;
	public Integer editParasTransfer(final Paras paraObj) throws IRParasUserException;
	public Integer editmultipleParasReply(final Paras paraobj) throws IRParasUserException;
	public List<Map<String, Object>> generalqueryforresult(String generalquery);
	public List<Paras> getParasAbstractByUnit( Integer unitId,Integer circleId, Integer divisionId ) throws IRParasUserException;
	public Integer getCountOfParaDocs() throws IRParasUserException;
	public List<Paras> getCAGParasAbstractByUnit( Integer unitId,Integer circleId, Integer divisionId ) throws IRParasUserException ;
	
	public Integer insertCAGParas(CAGParas paraObj) throws IRParasUserException ;
	public Integer insertCAGParasTransfer(CAGParas paraObj) throws IRParasUserException;
	public Integer insertCAGParasDocuments(final CAGParas paraobj) throws IRParasUserException;
	public Integer insertCAGParasReply(final CAGParas paraobj) throws IRParasUserException;
	public Integer insertCAGParasMaster(final CAGParasData paraobj) throws IRParasUserException;
	public List<CAGParas> getCAGGistByUnit( Integer unitId) throws IRParasUserException;
	public List<CAGParasData> getCAGParaAllbyunitId(CAGParas paraObj ) throws IRParasUserException;
	/*public Integer insertnewCAGPara(final CAGParas paraObj) throws IRParasUserException;*/
	public Integer addCAGParasReply(final ReplyData replyObj) throws IRParasUserException ;
	public Integer getCountOfCAGParaDocs() throws IRParasUserException;
	public List<ReplyData> getCAGReplybyParaId(Integer cagParaId ) throws IRParasUserException;
	public List<ParaDocuments> getCAGDocsByParaId(Integer cagParaId ) throws IRParasUserException;
	public Integer deleteCAGGistParasReplyDocs(Integer cagGistId, String userName) throws IRParasUserException;
	public Integer deleteCAGParasReplyByParaId(Integer cagParaId, String userName) throws IRParasUserException;

	public Integer deleteCAGReplyByReplyId(Integer cagReplyId, String userName) throws IRParasUserException;
	public Integer deleteCAGDocsByDocId(Integer cagDocId, String userName) throws IRParasUserException;
	public CAGParas getCAGGistByGistId(Integer cagGistId ) throws IRParasUserException;
	 public Integer editCagParasReply(final ReplyData replyObj) throws IRParasUserException;
	public Integer editcagsubParas(final CAGParasData paraObj) throws IRParasUserException ;
	public Integer editcagGistParas(Integer cagGistId,String finYear, String paraNum, String actionTitle, String userName) throws IRParasUserException;
	public Integer editCAGParasTransfer(final CAGParas paraObj) throws IRParasUserException;
	public Integer UpdateTrCAGGistIdByGistId(Integer oldcagGistId,Integer newcagGistId,Integer userId, String userName) throws IRParasUserException;
	public List<CAGParas> getCAGFinancialYear() throws IRParasUserException ;
	public CAGParas getCAGParaGist(Integer cagGistId) throws IRParasUserException;
	public Integer insertcagparaunitmap(final List<CAGParasData> paraobj) throws IRParasUserException ;
	public List<CAGParasData> selectCAGSubParaList(Integer cagGistId) throws IRParasUserException;
	public List<CAGParas> getCAGParaGistbyFinYear(String finYear) throws IRParasUserException;
	public CAGParasData selectSubParaListbyPara(Integer cagParaId) throws IRParasUserException;
	public List<Integer> getUnitListUnitMap(Integer cagParaId) throws IRParasUserException;
	public Integer deleteunitmapbyunit(final List<CAGParasData> paraobj) throws IRParasUserException ;
	public List<CAGParasData> getCAGParaEnci(CAGParas paraObj ) throws IRParasUserException ;
	public  ReplyData getCAGReplybyreplyid(Integer cagReplyId ) throws IRParasUserException;
	public Integer insertParaMasterSub(Paras paraObj) throws IRParasUserException;
	public List<Paras> getSubParaforedit(Integer paraId) throws IRParasUserException;
	
	public Integer editSubParas(final Paras paraObj) throws IRParasUserException ;
	
	public Integer insertParasDataInfo(Paras paraObj) throws IRParasUserException;
	
	public  List<Paras> getParaYearByOffice(Paras paraObj ) throws IRParasUserException;
	public  List<Paras> getParagistByYearByOffice(Paras paraObj ) throws IRParasUserException;
	
	public  List<Paras> getSubParadataByParaId(Paras paraObj ) throws IRParasUserException;
	public List<ReplyData> getReplybySubParaId(Integer subParaId ) throws IRParasUserException;
	public List<ParaDocuments> getDocsBySubParaId(Integer subParaId ) throws IRParasUserException;
	
	public List<Paras> getSubParabysubparaId(Integer subparaId) throws IRParasUserException;
	
	public Integer deleteSubParaReplyDocs(Paras paraObj) throws IRParasUserException;
	
	public List<ReplyData> getReplybyparaReplyId(Integer parareplyId ) throws IRParasUserException;
	public Integer editParasReplyByReplyId(final ReplyData rdataObj) throws IRParasUserException;
	public Paras getParaforreportbyParaId(Integer paraId) throws IRParasUserException;
	public Paras getParatransferdreportbyParaId(Integer paraId) throws IRParasUserException;
	public Integer insertcagStatus(CAGParasData paraObj) throws IRParasUserException;
	public List<CAGParasData> selectPACCAGSubParaList(CAGParasData parObj) throws IRParasUserException;
	
	public List<ParaDocuments> getCAGDocs(CAGParas paraObj ) throws IRParasUserException;
	
	
	
	
	

}
