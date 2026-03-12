package in.ts.icad.leagal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ts.icad.leagal.dao.IRParasAdminDAO;
import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.model.CAGParas;
import in.ts.icad.leagal.model.CAGParasData;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.ComponentPower;
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.util.DateUtil;


@Repository
public class IRParasAdminDAOImpl  implements IRParasAdminDAO {
	
	
	private JdbcTemplate jdbcTemplate6;

	@Resource(name = "dataSource6")
	public void setDataSource(DataSource dataSource6) {
		this.jdbcTemplate6 = new JdbcTemplate(dataSource6);
	}

	@Value("${INSERT_PARA_MAST}")
	private String INSERT_PARA_MAST;
	
	@Value("${INSERT_PARA_REPLY}")
	private String INSERT_PARA_REPLY;
	
	@Value("${INSERT_IR_PARAS_DOCUMENTS}")
	private String INSERT_IR_PARAS_DOCUMENTS;
	
	@Value("${INSERT_PARA_MAST_TRANSFERED}")
	private String INSERT_PARA_MAST_TRANSFERED;
	
	@Value("${DELETE_PARAS_MASTER}")
	private String DELETE_PARAS_MASTER;
	
	@Value("${DELETE_PARA_DOCS}")
	private String DELETE_PARA_DOCS;
	
	
	
	@Value("${DELETE_PARA_REPLY}")
	private String DELETE_PARA_REPLY;
	
	@Value("${DELETE_REPLY_ID}")
	private String DELETE_REPLY_ID;
	
	@Value("${DELETE_DOCS_BYID}")
	private String DELETE_DOCS_BYID;
	
	
	@Value("${SELECT_PARA_EDIT_BY_PARAID}")
	private String SELECT_PARA_EDIT_BY_PARAID;
	
	
	
	@Value("${UPDATE_PARAS_MASTER}")
	private String UPDATE_PARAS_MASTER;
	
	
	@Value("${UPDATE_PARAS_TRANSFER}")
	private String UPDATE_PARAS_TRANSFER;
	
	@Value("${UPDATE_REPLYS}")
	private String UPDATE_REPLYS;
	
	
	
	@Value("${UPDATE_PARA_DOCS}")
	private String UPDATE_PARA_DOCS;
	
	
	@Value("${GET_ALL_REPLY}")
	private String GET_ALL_REPLY;
	
	@Value("${TOTAL_PARAS_BYUNIT}")
	private String TOTAL_PARAS_BYUNIT;
	
	@Value("${COUNT_PARA_DOCS}")
	private String COUNT_PARA_DOCS;
	
	
	@Value("${INSERT_PARA_REPLY_NEW_EDIT}")
	private String INSERT_PARA_REPLY_NEW_EDIT;
	
	
	@Value("${TOTAL_CAG_PARAS_BYUNIT}")
	private String TOTAL_CAG_PARAS_BYUNIT;
	
	@Value("${INSERT_CAG_PARA_GIST}")
	private String INSERT_CAG_PARA_GIST;
	
	@Value("${INSERT_CAG_PARA_MAST_TRANSFERED}")
	private String INSERT_CAG_PARA_MAST_TRANSFERED;
	
	@Value("${INSERT_CAG_REPLY}")
	private String INSERT_CAG_REPLY;
	
	
	@Value("${INSERT_CAG_PARAS_DOCUMENTS}")
	private String INSERT_CAG_PARAS_DOCUMENTS;
	
	@Value("${INSERT_CAG_PARA_MAST}")
	private String INSERT_CAG_PARA_MAST;
	
	
	@Value("${TOTAL_CAG_GIST_BYUNIT}")
	private String TOTAL_CAG_GIST_BYUNIT;
	
	@Value("${TOTAL_CAG_PARA_ALL}")
	private String TOTAL_CAG_PARA_ALL;
	
	
	@Value("${INSERT_CAG_PARA_REPLY_NEW}")
	private String INSERT_CAG_PARA_REPLY_NEW;
	
	@Value("${COUNT_CAG_PARA_DOCS}")
	private String COUNT_CAG_PARA_DOCS;
	
	@Value("${GET_CAG_REPLY_BY_PARAID}")
	private String GET_CAG_REPLY_BY_PARAID;
	
	@Value("${GET_CAG_DOCS_BY_PARAID}")
	private String GET_CAG_DOCS_BY_PARAID;
	
	
	@Value("${DELETE_CAG_GIST}")
	private String DELETE_CAG_GIST;
	
	@Value("${DELETE_CAG_GIST_PARA}")
	private String DELETE_CAG_GIST_PARA;
	@Value("${DELETE_CAG_PARA}")
	private String DELETE_CAG_PARA;
	@Value("${DELETE_CAG_GIST_PARAREPLY}")
	private String DELETE_CAG_GIST_PARAREPLY;
	@Value("${DELETE_CAG_PARA_REPLY}")
	private String DELETE_CAG_PARA_REPLY;
	@Value("${DELETE_CAG_REPLY}")
	private String DELETE_CAG_REPLY;
	@Value("${DELETE_CAG_GIST_PARADOCS}")
	private String DELETE_CAG_GIST_PARADOCS;
	@Value("${DELETE_CAG_PARA_DOCS}")
	private String DELETE_CAG_PARA_DOCS;
	@Value("${DELETE_CAG_DOCS}")
	private String DELETE_CAG_DOCS;
	
	@Value("${GET_CAG_GIST_BYGISTID}")
	private String GET_CAG_GIST_BYGISTID;
	
	@Value("${UPDATE_CAG_MASTER_GIST}")
	private String UPDATE_CAG_MASTER_GIST;
	
	@Value("${UPDATE_CAG_MASTER}")
	private String UPDATE_CAG_MASTER;
	
	@Value("${UPDATE_REPLY_CAG}")
	private String UPDATE_REPLY_CAG;
	
	@Value("${UPDATE_CAG_PARAS_TRANSFER}")
	private String UPDATE_CAG_PARAS_TRANSFER;
	
	@Value("${UPDATE_TR_REPLY}")
	private String UPDATE_TR_REPLY;
	
	@Value("${UPDATE_TR_PARAS_MST}")
	private String UPDATE_TR_PARAS_MST;
	
	@Value("${UPDATE_TR_DOCS}")
	private String UPDATE_TR_DOCS;
	
	@Value("${SELECT_FINANCIAL_YEAR}")
	private String SELECT_FINANCIAL_YEAR;
	
	@Value("${SELECT_CAG_GIST}")
	private String SELECT_CAG_GIST;
	
	@Value("${INSERT_CAG_PARA_UNIT_MAP}")
	private String INSERT_CAG_PARA_UNIT_MAP;
	
	@Value("${SELECT_SUB_PARALIST}")
	private String SELECT_SUB_PARALIST;
	
	@Value("${SELECT_GIST_BYFIN}")
	private String SELECT_GIST_BYFIN;
	
	@Value("${DELETE_CAG_UNIT_MAP}")
	private String DELETE_CAG_UNIT_MAP;
	
	
	@Value("${SELECT_COUNT_GIST_BYFIN}")
	private String SELECT_COUNT_GIST_BYFIN;
	
	
	@Value("${DELETE_SUB_PARA_UNIT_MAP}")
	private String DELETE_SUB_PARA_UNIT_MAP;
	
	
	@Value("${SELECT_SUB_PARA_PARAID}")
	private String SELECT_SUB_PARA_PARAID;
	
	@Value("${SELECT_COUNT_UNIT_MAP}")
	private String SELECT_COUNT_UNIT_MAP;
	
	
	@Value("${DELETE_PARA_UNIT_MAP_BYUNIT}")
	private String DELETE_PARA_UNIT_MAP_BYUNIT;
	
	
	@Value("${TOTAL_CAG_PARA_ENCI}")
	private String TOTAL_CAG_PARA_ENCI;
	
	@Value("${GET_CAG_REPLY_BYREPLYID}")
	private String GET_CAG_REPLY_BYREPLYID;
	
	
	@Value("${UPDATE_UNIT_MAP_BYREPLY}")
	private String UPDATE_UNIT_MAP_BYREPLY;
	
	@Value("${INSERT_PARA_MAST_Sub}")
	private String INSERT_PARA_MAST_Sub;
	
	@Value("${UPDATE_PARAS_SUB_TRANSFER}")
	private String UPDATE_PARAS_SUB_TRANSFER;
	
	@Value("${UPDATE_PARAS_REPLY_TRANSFER}")
	private String UPDATE_PARAS_REPLY_TRANSFER;
	
	@Value("${UPDATE_PARAS_DOCS_TRANSFER}")
	private String UPDATE_PARAS_DOCS_TRANSFER;
	
	@Value("${SELECT_SUB_PARA_EDIT_BY_PARAID}")
	private String SELECT_SUB_PARA_EDIT_BY_PARAID;
	
	
	@Value("${UPDATE_SUB_PARAS_MASTER}")
	private String UPDATE_SUB_PARAS_MASTER;
	
	@Value("${DELETE_SUB_PARAS_MASTER}")
	private String DELETE_SUB_PARAS_MASTER;
	
	
	@Value("${INSERT_PARA_MAST_DATA_INFO}")
	private String INSERT_PARA_MAST_DATA_INFO;
	
	@Value("${SELECT_PARA_YEAR_OFFICE}")
	private String SELECT_PARA_YEAR_OFFICE;
	
	@Value("${SELECT_GIST_YEAR_OFFICE}")
	private String SELECT_GIST_YEAR_OFFICE;
	
	
	@Value("${SELECT_SUBPARA_DATA_BY_PARA_ID}")
	private String SELECT_SUBPARA_DATA_BY_PARA_ID;
	
	@Value("${GET_REPLY_BY_SUB_PARA_ID}")
	private String GET_REPLY_BY_SUB_PARA_ID;
	
	@Value("${GET_ALL_DOCS_SUB_PARA_ID}")
	private String GET_ALL_DOCS_SUB_PARA_ID;
	
	
	@Value("${SELECT_SUB_PARA_BY_SUBPARAID}")
	private String SELECT_SUB_PARA_BY_SUBPARAID;
	
	@Value("${DELETE_SUB_PARA_DOCS}")
	private String DELETE_SUB_PARA_DOCS;
	
	@Value("${DELETE_SUB_PARA_REPLY}")
	private String DELETE_SUB_PARA_REPLY;
	
	@Value("${DELETE_SUB_PARAS_SUBID}")
	private String DELETE_SUB_PARAS_SUBID;
	
	@Value("${GET_REPLY_BY_PARA_REPLY_ID}")
	private String GET_REPLY_BY_PARA_REPLY_ID;
	
	
	@Value("${UPDATE_REPLYS_replyId}")
	private String UPDATE_REPLYS_replyId;
	
	
	@Value("${SELECT_PARA_Report_BY_PARAID}")
	private String SELECT_PARA_Report_BY_PARAID;
	
	@Value("${SELECT_Transfer_Report_BY_PARAID}")
	private String SELECT_Transfer_Report_BY_PARAID;
	
	
	@Value("${INSERT_INTO_CAG_STATUS}")
	private String INSERT_INTO_CAG_STATUS;
	
	@Value("${UPDATE_CAG_STATUS_OLD}")
	private String UPDATE_CAG_STATUS_OLD;
	
	@Value("${DELETE_CAG_STATUS}")
	private String DELETE_CAG_STATUS;
	
	
	@Value("${INSERT_CAG_STATUS}")
	private String INSERT_CAG_STATUS;
	
	
	@Value("${UPDATE_OLD_CAG_STATUS}")
	private String UPDATE_OLD_CAG_STATUS;
	
	
	@Value("${SELECT_SUB_PACPARALIST}")
	private String SELECT_SUB_PACPARALIST;
	
	
	@Value("${GET_CAG_DOCS}")
	private String GET_CAG_DOCS;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	










	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Map<String, Object>> generalqueryforresult(String generalquery) {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		int count = 0;
		try {
			if (generalquery.toLowerCase().contains("select")) {
				List<Map<String, Object>> result = jdbcTemplate6.queryForList(generalquery);
				for (Map<String, Object> row : result) {
					rs.add(row);
				}
			} else {

				count = jdbcTemplate6.update(generalquery);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", count);
				rs.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return rs;

	}

	
	
	
	
	
	
	
	




	@Override
	public Integer insertParas(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql1 = INSERT_PARA_MAST;
		
		Integer paraId = 0;
		
		Date date1=null;
		Date date2=null;
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraObj != null) {

				if (paraObj.getParaDataList().size()>0) {

					
					
					if (paraObj.getAuditDateFrom() != null
							&& paraObj.getAuditDateFrom() != ""
							&& !paraObj.getAuditDateFrom().equals('0')) {

						date1 = DateUtil.getSQLDate(paraObj.getAuditDateFrom());

					}
					if (paraObj.getAuditDateTo() != null && paraObj.getAuditDateTo() != ""
							&& !paraObj.getAuditDateTo().equals('0')) {

						date2 = DateUtil.getSQLDate(paraObj.getAuditDateTo());

					}
					
						

					List<Map<String, Object>> rows = jdbcTemplate6.queryForList(sql1,paraObj.getParaDataList().get(0).getActionTitle(),paraObj.getParaDataList().get(0).getParasAction(), paraObj.getFinancialYear(),
							paraObj.getParaDataList().get(0).getRemarks(), paraObj.getUnitId(),	paraObj.getDivisionId(), paraObj.getCircleId(),paraObj.getSubdivisionId(),
									paraObj.getParaStatusId(),paraObj.getSectionId(), paraObj.getCategoryId(),paraObj.getParaNumber(), paraObj.getTunitId(),paraObj.getTcircleId(),paraObj.getTdivisionId(),paraObj.getTsubdivisionId(),
									date1,date2,paraObj.getPrintCAG(),paraObj.getFileNumber(),paraObj.getLarNumber(),paraObj.getUserId(),paraObj.getUserName());
							
							
							
					
					
					for (Map<String, Object> row : rows) {
						paraId = Integer.parseInt(row.get("para_id").toString());
					}

					

						}
					

						
							
							
							}

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return paraId;
	}
	
	
	@Override
	public Integer insertParasDataInfo(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql1 = INSERT_PARA_MAST_DATA_INFO;
		
		Integer paraId = 0;
		
		Date date1=null;
		Date date2=null;
		
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraObj != null) {

				if (paraObj!=null) {
					if(paraObj.getActionTitle()!=null){

					
					
					if (paraObj.getAuditDateFrom() != null
							&& paraObj.getAuditDateFrom() != ""
							&& !paraObj.getAuditDateFrom().equals('0')) {

						date1 = DateUtil.getSQLDate(paraObj.getAuditDateFrom());

					}
					if (paraObj.getAuditDateTo() != null && paraObj.getAuditDateTo() != ""
							&& !paraObj.getAuditDateTo().equals('0')) {

						date2 = DateUtil.getSQLDate(paraObj.getAuditDateTo());

					}
					
					if(paraObj.getOldParaId()==null){
						
						paraObj.setOldParaId(0);
					}
					
						

					List<Map<String, Object>> rows = jdbcTemplate6.queryForList(sql1,paraObj.getActionTitle(), paraObj.getFinancialYear(),
							 paraObj.getUnitId(),	paraObj.getDivisionId(), paraObj.getCircleId(),paraObj.getSubdivisionId(),
									paraObj.getParaStatusId(),paraObj.getSectionId(), paraObj.getCategoryId(),paraObj.getParaNumber(), paraObj.getTunitId(),paraObj.getTcircleId(),paraObj.getTdivisionId(),paraObj.getTsubdivisionId(),
									date1,date2,paraObj.getPrintCAG(),paraObj.getFileNumber(),paraObj.getLarNumber(),paraObj.getUserId(),paraObj.getUserName(),paraObj.getInclPropCAG(),paraObj.getOldParaId());
							
							
							
					
					
					for (Map<String, Object> row : rows) {
						paraId = Integer.parseInt(row.get("para_id").toString());
					}

					

						}
					

						
				}
							
							}

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return paraId;
	}
	
	
	
	@Override
	public Integer insertParaMasterSub(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql1 = INSERT_PARA_MAST_Sub;
		
		Integer subparaId = 0;
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraObj != null) {

				
                    if(paraObj.getOldSubParaId()==null){
                    	
                    	paraObj.setOldSubParaId(0);
                    }
				
						

					List<Map<String, Object>> rows = jdbcTemplate6.queryForList(sql1,paraObj.getParaId(),paraObj.getParasAction(), 
							 					paraObj.getParaStatusId(),paraObj.getSubcategory(),paraObj.getUserName(),paraObj.getParareasonsDelay(),paraObj.getOldSubParaId());
							
							
							
					
					
					for (Map<String, Object> row : rows) {
						subparaId = Integer.parseInt(row.get("para_sub_id").toString());
					}

					
	
							
							}

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return subparaId;
	}
	
	
	
	@Override
	public Integer insertParasTransfer(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql1 = INSERT_PARA_MAST_TRANSFERED;
		
		Integer paraId = 0;
		Date date1=null;
		Date date2=null;
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraObj != null) {

				if (paraObj.getParaDataList().size()>0) {
					
					if (paraObj.getAuditDateFrom() != null
							&& paraObj.getAuditDateFrom() != ""
							&& !paraObj.getAuditDateFrom().equals('0')) {

						date1 = DateUtil.getSQLDate(paraObj.getAuditDateFrom());

					}
					if (paraObj.getAuditDateTo() != null && paraObj.getAuditDateTo() != ""
							&& !paraObj.getAuditDateTo().equals('0')) {

						date2 = DateUtil.getSQLDate(paraObj.getAuditDateTo());

					}
					

					
						

					List<Map<String, Object>> rows = jdbcTemplate6.queryForList(sql1,paraObj.getParaDataList().get(0).getActionTitle(),paraObj.getParaDataList().get(0).getParasAction(), paraObj.getFinancialYear(),
							paraObj.getParaDataList().get(0).getRemarks(), paraObj.getUnitId(),	paraObj.getDivisionId(), paraObj.getCircleId(),paraObj.getSubdivisionId(),
									paraObj.getParaStatusId(),paraObj.getSectionId(), paraObj.getCategoryId(),paraObj.getParaNumber(), paraObj.getTunitId(),paraObj.getTcircleId(),paraObj.getTdivisionId(),paraObj.getTsubdivisionId(),
									date1,date2,paraObj.getPrintCAG(),paraObj.getFileNumber(),paraObj.getLarNumber(),paraObj.getUserId(),paraObj.getUserName());
							
							
							
					
					
					for (Map<String, Object> row : rows) {
						paraId = Integer.parseInt(row.get("para_id").toString());
					}

					

						}
					

						
							
							
							}

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return paraId;
	}
	
	
	@Override
	public Integer insertParasDocuments(final Paras paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql2 = INSERT_IR_PARAS_DOCUMENTS;
				
		

		Integer rows1 = 0;
		int[] j = null;
		Integer filerows=0;
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			
			if(paraobj.getParadocList()!=null){
			 if(paraobj.getParadocList().size()>0){
             	//System.out.println("coming here");
      			//System.out.println(taskObject.getFiledataList().get(0).getFileName());
				
					if(paraobj.getParadocList().get(0).getParaDocName()!=null || paraobj.getParadocList().get(0).getParaDocName()!=" " ){
					j = jdbcTemplate6.batchUpdate(sql2,		new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {

									ParaDocuments sd = paraobj.getParadocList().get(i);
									
									
									 if(sd.getDocId()!=null){
									    	if(sd.getDocId()>0){
									    		
									    		paraobj.setOldDocumentId(sd.getDocId());    ;
									    	}
									    	
									    	
									    }else {
									    	
									    	paraobj.setOldDocumentId(0);
									    }
									 
									 if(sd.getSubParaId()!=null){
										 
										 if(sd.getSubParaId()>0){
											 
											 paraobj.setSubParaId(sd.getSubParaId());
										 }
										 
										 
										 
									 }

									
									ps.setString(1, sd.getParaDocLocation());
									
									 ps.setString(2,  paraobj.getUserName());
									
								     ps.setInt(3,  paraobj.getParaId());
										
										ps.setString(4, sd.getParaDocOriginalName());
										ps.setString(5, sd.getParaDocName());
										ps.setInt(6,  paraobj.getSubParaId());
										ps.setInt(7,  paraobj.getOldDocumentId());
										
										
										

									
								}

								@Override
								public int getBatchSize() {
									return paraobj.getParadocList().size();
								}
							});
					
					}
				}
			 
			}
			
		        if(j!=null){   
				if (j.length > 0) {
					filerows=j.length;
					
					//System.out.println("rows"+rows);
					return filerows;
				}
		        }
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer insertParasReply(final Paras paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_PARA_REPLY;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		
		 
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(paraobj.getReplyDataList()!=null){
             	
				
				 
				 
				if (paraobj.getReplyDataList().size() > 0) {
					if(paraobj.getReplyDataList().get(0).getReplyAction()!=null ){
					j = jdbcTemplate6.batchUpdate(sql3, 							new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
									
											
										

									ReplyData sd = paraobj.getReplyDataList().get(i);
									
									    if(sd.getParaReplyId()!=null){
									    	if(sd.getParaReplyId()>0){
									    		
									    		paraobj.setOldReplyId(sd.getParaReplyId());    ;
									    	}
									    	
									    	
									    }else {
									    	
									    	paraobj.setOldReplyId(0);
									    }
									    
									    if(sd.getSubParaId()!=null){
											 
											 if(sd.getSubParaId()>0){
												 
												 paraobj.setSubParaId(sd.getSubParaId());
											 }
											 
											 
											 
										 }
									

								
										ps.setInt(1,  paraobj.getParaId());
										
										ps.setString(2, sd.getReplyAction());
										ps.setString(3, sd.getReplyRemarks());
										
										 java.sql.Date date1 = null;
										try {
											
											if (sd.getReplyDate() != null
													&& sd.getReplyDate() != ""
													&& !sd.getReplyDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( paraobj.getReplyDataList().get(i).getReplyDate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										 
									
											ps.setDate(4, date1);
										
										//ps.setInt(5, paraobj.getUserId());
										
										ps.setString(5, paraobj.getUserName());
										
										ps.setInt(6, paraobj.getSubParaId());
										
										ps.setInt(7, paraobj.getOldReplyId());
										

									
								}

								@Override
								public int getBatchSize() {
									return paraobj.getReplyDataList().size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					filerows=j.length;
					
					//System.out.println("rows"+rows);
					return filerows;
				}
		        }
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filerows;
	}
	
	
	@Override
	public Integer deleteParasReplyDocs(Integer paraId,Integer userId, String userName) throws IRParasUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_PARAS_MASTER;
		
		String sql2 = DELETE_PARA_DOCS;
		
		String sql3 = DELETE_PARA_REPLY;
		
		String sql4 = DELETE_SUB_PARAS_MASTER;
		
		
		//System.out.println("delete paradata"+sql1);
		

		Integer rows1 = 0;
		Integer rows2 = 0;
		Integer rows3 = 0;
		Integer rows4 = 0;

		Date date1 = null;

		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraId != null) {

				if (paraId > 0) {
					
				//	System.out.println("delete paradaoimpl"+sql1);
					

					rows1 = jdbcTemplate6.update(sql1, userName ,paraId);
					rows2 = jdbcTemplate6.update(sql2, userName,paraId);
					rows3 = jdbcTemplate6.update(sql3, userName,paraId);
					rows4 = jdbcTemplate6.update(sql4, userName,paraId);

				}

				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public Integer deleteSubParaReplyDocs(Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub

		
		
		String sql1 = DELETE_SUB_PARA_DOCS;
		
		String sql2 = DELETE_SUB_PARA_REPLY;
		
		String sql3 = DELETE_SUB_PARAS_SUBID;
		
		
		//System.out.println("delete paradata"+sql1);
		

		Integer rows1 = 0;
		Integer rows2 = 0;
		Integer rows3 = 0;
		Integer rows4 = 0;

		Date date1 = null;

		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraObj.getSubParaId() != null) {

				if (paraObj.getSubParaId() > 0) {
					
				//	System.out.println("delete paradaoimpl"+sql1);
					

					rows1 = jdbcTemplate6.update(sql1, paraObj.getUserName() ,paraObj.getSubParaId());
					rows2 = jdbcTemplate6.update(sql2, paraObj.getUserName() ,paraObj.getSubParaId());
					rows3 = jdbcTemplate6.update(sql3, paraObj.getUserName() ,paraObj.getSubParaId());
					

				}

				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows3;
	}
	
	
	@Override
	public Integer deleteParasReplyById(Integer paraReplyId,Integer userId, String userName) throws IRParasUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_REPLY_ID;
		
		

		Integer rows1 = 0;
		

		Date date1 = null;

		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraReplyId != null) {

				if (paraReplyId > 0) {

					rows1 = jdbcTemplate6.update(sql1, userName, paraReplyId);
					

				}

				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	@Override
	public Integer deleteParasDocsById(Integer docId,Integer userId, String userName) throws IRParasUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_DOCS_BYID;
		
	
		Integer rows1 = 0;
		

		Date date1 = null;

		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (docId != null) {

				if (docId > 0) {

					rows1 = jdbcTemplate6.update(sql1,  userName, docId);
					

				}

				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public Paras getParaforedit(Integer paraId) throws IRParasUserException {

		String sql = SELECT_PARA_EDIT_BY_PARAID;

		try {
			Paras probj = (Paras) jdbcTemplate6.queryForObject(sql, new Object[] { paraId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Paras pr = new Paras();
							pr.setParaId(rs.getInt(1));
							pr.setActionTitle(rs.getString(2));
							//pr.setParasAction(rs.getString(3));
							
							pr.setFinancialYear(rs.getString(3));
							pr.setParaRemarks (rs.getString(4));
							pr.setUnitName(rs.getString(5));
							pr.setUnitId(rs.getInt(6));
							pr.setCircleName(rs.getString(7));
							pr.setCircleId(rs.getInt(8));
							pr.setDivisionName(rs.getString(9));
							pr.setDivisionId(rs.getInt(10));
							pr.setParaStatusId(rs.getInt(11));
							pr.setParaStatus(rs.getString(12));
							
							
							if(rs.getInt(14)==1){
							pr.setSectionA(rs.getString(13));
							}
							if(rs.getInt(14)==2){
								pr.setSectionB(rs.getString(13));
								}
							pr.setSectionId(rs.getInt(14));
							pr.setPrintCagStatus(rs.getString(15));
							pr.setCategoryId(rs.getString(16));
							pr.setParaNumber(rs.getString(17));
							pr.setAuditDateFrom(rs.getString(18));
							pr.setAuditDateTo(rs.getString(19));
							pr.setFileNumber(rs.getString(20));
							pr.setLarNumber(rs.getString(21));
							pr.setParaNumsectionA(rs.getString(22));
							pr.setParaNumsectionB(rs.getString(23));
							pr.setInclPropCAG(rs.getBoolean(24));
							//pr.setTransferFlag(rs.getBoolean(25));
							//.setTunitId(rs.getInt(26));
							//pr.setTcircleId(rs.getInt(27));
							//pr.setTdivisionId(rs.getInt(28));
							//pr.setTsubdivisionId(rs.getInt(29));
							//pr.setSubParaId(rs.getInt(30));
						
						
						
						
					    return pr;

						}

					});
			return probj;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		// System.out.println("daoimpl canal list " + canalList);

	}
	
	
	
	@Override
	public Paras getParaforreportbyParaId(Integer paraId) throws IRParasUserException {
		
		//System.out.println("paraId"+paraId);

		String sql = SELECT_PARA_Report_BY_PARAID;

		try {
			Paras probj = (Paras) jdbcTemplate6.queryForObject(sql, new Object[] { paraId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Paras pr = new Paras();
							pr.setParaId(rs.getInt(1));
							pr.setActionTitle(rs.getString(2));
							
							
							pr.setFinancialYear(rs.getString(3));
							pr.setParaRemarks (rs.getString(4));
							pr.setUnitName(rs.getString(5));
							pr.setUnitId(rs.getInt(6));
							pr.setCircleName(rs.getString(7));
							pr.setCircleId(rs.getInt(8));
							pr.setDivisionName(rs.getString(9));
							pr.setDivisionId(rs.getInt(10));
							pr.setParaStatusId(rs.getInt(11));
							pr.setParaStatus(rs.getString(12));
							
							pr.setSectionA(rs.getString(13));
							pr.setSectionId(rs.getInt(14));
							pr.setPrintCagStatus(rs.getString(15));
							pr.setCategoryId(rs.getString(16));
							pr.setParaNumber(rs.getString(17));
							pr.setAuditDateFrom(rs.getString(18));
							pr.setAuditDateTo(rs.getString(19));
							pr.setFileNumber(rs.getString(20));
							pr.setLarNumber(rs.getString(21));
							pr.setParaNumsectionA(rs.getString(22));
							pr.setParaNumsectionB(rs.getString(23));
							pr.setInclPropCAG(rs.getBoolean(24));
							pr.setParasAction(rs.getString(25));
							pr.setParareasonsDelay(rs.getString(26));
							
							pr.setOldParaId(rs.getInt(27));
							
							pr.setTrfromUnit(rs.getString(28));
							pr.setTrfromCircle(rs.getString(29));
							pr.setTrfromDivision(rs.getString(30));
							
							
							//pr.setTransferFlag(rs.getBoolean(25));
							//.setTunitId(rs.getInt(26));
							//pr.setTcircleId(rs.getInt(27));
							//pr.setTdivisionId(rs.getInt(28));
							//pr.setTsubdivisionId(rs.getInt(29));
							//pr.setSubParaId(rs.getInt(30));
						
						
						
						
					    return pr;

						}

					});
			return probj;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		// System.out.println("daoimpl canal list " + canalList);

	}
	
	
	@Override
	public Paras getParatransferdreportbyParaId(Integer paraId) throws IRParasUserException {
		
		//System.out.println("transferaraId"+paraId);

		String sql = SELECT_Transfer_Report_BY_PARAID;

		try {
			Paras probj = (Paras) jdbcTemplate6.queryForObject(sql, new Object[] { paraId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Paras pr = new Paras();
							pr.setParaId(rs.getInt(1));
							pr.setActionTitle(rs.getString(2));
							
							
							pr.setFinancialYear(rs.getString(3));
							pr.setParaRemarks (rs.getString(4));
							pr.setUnitName(rs.getString(5));
							pr.setUnitId(rs.getInt(6));
							pr.setCircleName(rs.getString(7));
							pr.setCircleId(rs.getInt(8));
							pr.setDivisionName(rs.getString(9));
							pr.setDivisionId(rs.getInt(10));
							pr.setParaStatusId(rs.getInt(11));
							pr.setParaStatus(rs.getString(12));
							
							pr.setSectionA(rs.getString(13));
							pr.setSectionId(rs.getInt(14));
							pr.setPrintCagStatus(rs.getString(15));
							pr.setCategoryId(rs.getString(16));
							pr.setParaNumber(rs.getString(17));
							pr.setAuditDateFrom(rs.getString(18));
							pr.setAuditDateTo(rs.getString(19));
							pr.setFileNumber(rs.getString(20));
							pr.setLarNumber(rs.getString(21));
							pr.setParaNumsectionA(rs.getString(22));
							pr.setParaNumsectionB(rs.getString(23));
							pr.setInclPropCAG(rs.getBoolean(24));
							pr.setParasAction(rs.getString(25));
							pr.setParareasonsDelay(rs.getString(26));
							//pr.setTransferFlag(rs.getBoolean(25));
							//.setTunitId(rs.getInt(26));
							//pr.setTcircleId(rs.getInt(27));
							//pr.setTdivisionId(rs.getInt(28));
							//pr.setTsubdivisionId(rs.getInt(29));
							//pr.setSubParaId(rs.getInt(30));
						
						
						
						
					    return pr;

						}

					});
			return probj;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		// System.out.println("daoimpl canal list " + canalList);

	}
	
	
	@Override
	public List<Paras> getSubParaforedit(Integer paraId) throws IRParasUserException {

		String sql = SELECT_SUB_PARA_EDIT_BY_PARAID;
		
		
		
		
 

		try {
			List<Paras> probjList =  jdbcTemplate6.query(sql, new Object[] { paraId },
					new RowMapper<Paras>() {
						public Paras mapRow(ResultSet rs, int rowNum) throws SQLException {
							Paras pr = new Paras();
							pr.setParaId(rs.getInt(1));						
							pr.setParasAction(rs.getString(2));						
							pr.setParaStatusId(rs.getInt(3));
							pr.setParaStatus(rs.getString(4));	
						
							pr.setTransferFlag(rs.getBoolean(5));							
							pr.setSubParaId(rs.getInt(6));							
							pr.setSubcategory(rs.getString(7));
							pr.setParareasonsDelay(rs.getString(8));
						
						
						
					    return pr;

						}

					});
			return probjList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		// System.out.println("daoimpl canal list " + canalList);

	}
	
	
	@Override
	public Integer editParas(final Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub

String sql1 = UPDATE_PARAS_MASTER;
		
		Integer paraId = 0;
		
		Date date1=null;
		Date date2=null;
		
		Integer rows=0;
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraObj != null) {

				if (paraObj.getActionTitle()!=null && paraObj.getParaId()!=null ) {

					
					
					if (paraObj.getAuditDateFrom() != null
							&& paraObj.getAuditDateFrom() != ""
							&& !paraObj.getAuditDateFrom().equals('0')) {

						date1 = DateUtil.getSQLDate(paraObj.getAuditDateFrom());

					}
					if (paraObj.getAuditDateTo() != null && paraObj.getAuditDateTo() != ""
							&& !paraObj.getAuditDateTo().equals('0')) {

						date2 = DateUtil.getSQLDate(paraObj.getAuditDateTo());

					}
					
						
					
					//System.out.println("paraObjdaoimpl"+paraObj);

					rows = jdbcTemplate6.update(sql1,paraObj.getActionTitle(), paraObj.getFinancialYear(),
							
									paraObj.getParaStatusId(),paraObj.getSectionId(),paraObj.getParaNumber(),
									date1,date2,paraObj.getPrintCAG(),paraObj.getFileNumber(),paraObj.getLarNumber(),paraObj.getUserName(),paraObj.getInclPropCAG(),paraObj.getParaId());
							
							
							
					
					
				
					

						}
					

						
							
							
							}

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows;
	}
	
	
	
	
	@Override
	public Integer editSubParas(final Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub

String sql1 = UPDATE_SUB_PARAS_MASTER;
		
		Integer paraId = 0;
		
		Date date1=null;
		Date date2=null;
		
		Integer rows=0;
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraObj != null) {

				if (paraObj!=null &&  paraObj.getParaId()!=null &&  paraObj.getSubParaId()!=null ) {

					
					
					
					
						

					rows = jdbcTemplate6.update(sql1,paraObj.getParasAction(), 
							 
									paraObj.getParaStatusId(),
									paraObj.getUserName(),paraObj.getSubcategory(),paraObj.getParareasonsDelay(),paraObj.getSubParaId());
							
							
							
					
					
				
					

						}
					

						
							
							
							}

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return rows;
	}
	
	
	
	
	@Override
	public Integer editParasTransfer(final Paras paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub

String sql1 =   UPDATE_PARAS_TRANSFER;
String sql2=   UPDATE_PARAS_SUB_TRANSFER;
String sql3=   UPDATE_PARAS_REPLY_TRANSFER;
String sql4=   UPDATE_PARAS_DOCS_TRANSFER;
		
		Integer paraId = 0;
		Date date1=null;
		Date date2=null;
		Integer rows1=0;
		Integer rows2=0;
		
		Integer rows3=0;
		
		Integer rows4=0;
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraObj != null && paraObj.getParaId()!=null) {

				if ( paraObj.getParaId()>0 ) {
					
					/*if (paraObj.getAuditDateFrom() != null
							&& paraObj.getAuditDateFrom() != ""
							&& !paraObj.getAuditDateFrom().equals('0')) {

						date1 = DateUtil.getSQLDate(paraObj.getAuditDateFrom());

					}
					if (paraObj.getAuditDateTo() != null && paraObj.getAuditDateTo() != ""
							&& !paraObj.getAuditDateTo().equals('0')) {

						date2 = DateUtil.getSQLDate(paraObj.getAuditDateTo());

					}
					*/
					
					
					 rows1 = jdbcTemplate6.update(sql1, paraObj.getTunitId(),paraObj.getTcircleId(),paraObj.getTdivisionId(),paraObj.getTsubdivisionId(),
									paraObj.getUserName(),paraObj.getParaId());
					 
					 if(rows1>0){
					 rows2 = jdbcTemplate6.update(sql2, paraObj.getUserName(),paraObj.getParaId());
					 }
					 if(rows1>0 && rows2>0){
					 rows3 = jdbcTemplate6.update(sql3, paraObj.getUserName(),paraObj.getParaId());
					 }
					 
					 if(rows1>0 && rows2>0){
					 rows4 = jdbcTemplate6.update(sql4, paraObj.getUserName(),paraObj.getParaId());
					 }
					 
							

					
						
/*
					 rows = jdbcTemplate6.update(sql1,paraObj.getParaDataList().get(0).getActionTitle(),paraObj.getParaDataList().get(0).getParasAction(), paraObj.getFinancialYear(),
							 paraObj.getUnitId(),	paraObj.getDivisionId(), paraObj.getCircleId(),paraObj.getSubdivisionId(),
									paraObj.getParaStatusId(),paraObj.getSectionId(), paraObj.getParaNumber(), paraObj.getTunitId(),paraObj.getTcircleId(),paraObj.getTdivisionId(),paraObj.getTsubdivisionId(),
									date1,date2,paraObj.getPrintCAG(),paraObj.getFileNumber(),paraObj.getLarNumber(),paraObj.getUserName(),paraObj.getParaId());
							
							
							*/
					
					

					

						}
					

						
							
							
							}

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return rows1;
	}
	
	
	@Override
	public Integer editParasDocuments(final Paras paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql2 = UPDATE_PARA_DOCS;
				
		

		Integer rows1 = 0;
		int[] j = null;
		Integer filerows=0;
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(paraobj.getParadocList().size()>0){
             	// System.out.println(taskObject.getFiledataList().size());
      			//System.out.println(taskObject.getFiledataList().get(0).getFileName());
				
					if(paraobj.getParadocList().get(0).getParaDocName()!=null || paraobj.getParadocList().get(0).getParaDocName()!=" " ){
					j = jdbcTemplate6.batchUpdate(sql2,		new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {

									ParaDocuments sd = paraobj.getParadocList().get(i);

									
									ps.setString(1, sd.getParaDocLocation());
									
								     ps.setInt(2,  paraobj.getParaId());
										
										ps.setString(3, sd.getParaDocOriginalName());
										
										 ps.setInt(4,  paraobj.getUserId());
										
										

									
								}

								@Override
								public int getBatchSize() {
									return paraobj.getParadocList().size();
								}
							});
					
					}
				}
			
		        if(j!=null){   
				if (j.length > 0) {
					filerows=j.length;
					
					//System.out.println("rows"+rows);
					return filerows;
				}
		        }
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer editParasReply(final ReplyData replyObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_PARA_REPLY_NEW_EDIT;

		Integer rows1 = 0;
		
		
		Integer filerows=0;
		
		 java.sql.Date date1 = null;
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(replyObj.getReplyAction()!=null){
				 
				 if (replyObj.getReplyDate() != null
							&& replyObj.getReplyDate() != ""
							&& !replyObj.getReplyDate().equals('0')) {

						date1 = DateUtil.getSQLDate(replyObj.getReplyDate());

					}
				 
             	// System.out.println(taskObject.getFiledataList().size());
      			//System.out.println(taskObject.getFiledataList().get(0).getFileName());
				
					if(replyObj.getReplyDate()!=null ){
						 rows1 = jdbcTemplate6.update(sql,replyObj.getParaId(),replyObj.getReplyAction(),replyObj.getReplyRemarks(), 
								 date1,replyObj.getUserName());
								
								
					
					
				}
			}
		       
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public List<ReplyData> getAllReplys( ) throws IRParasUserException {
		String sql = GET_ALL_REPLY;
		
		
		
	
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql , new RowMapper<ReplyData>() {
				public ReplyData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReplyData rep = new ReplyData();
			
				rep.setParaReplyId(rs.getInt(1));
				rep.setParaId(rs.getInt(2));
				
				rep.setReplyAction(rs.getString(3));
				rep.setReplyRemarks(rs.getString(4));
				rep.setReplyDate(rs.getString(5));
				
				
				
			    return rep;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return replyList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public Integer editmultipleParasReply(final Paras paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_REPLYS;

	
		int[] j = null;
		
		Integer filerows=0;
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(paraobj.getReplyDataList()!=null){
             	// System.out.println(taskObject.getFiledataList().size());
      			//System.out.println(paraobj.getReplyDataList().size()+"--"+paraobj.getReplyDataList().get(0).getParaReplyId());
				if (paraobj.getReplyDataList().size() > 0) {
					if(paraobj.getReplyDataList().get(0).getParaReplyId()!=null ){
					j = jdbcTemplate6.batchUpdate(sql3, 							new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {

									ReplyData sd = paraobj.getReplyDataList().get(i);

									 java.sql.Date date1 = null;
										try {
									if (sd.getReplyDate() != null
											&& sd.getReplyDate() != ""
											&& !sd.getReplyDate().equals('0')) {
										
									
											date1 = DateUtil.getSQLDate( paraobj.getReplyDataList().get(i).getReplyDate());
										
										
									}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									
									
										ps.setString(1, sd.getReplyAction());
										ps.setDate(2, date1);
										ps.setString(3, sd.getReplyRemarks());
									//	ps.setInt(4, paraobj.getUserId());
										ps.setString(4, paraobj.getUserName());
										ps.setInt(5, sd.getParaReplyId());
										
										

									
								}

								@Override
								public int getBatchSize() {
									return paraobj.getReplyDataList().size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					filerows=j.length;
					
					//System.out.println("rows"+filerows);
					return filerows;
				}
		        }
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filerows;
	}
	
	
	
	
	@Override
	public Integer editParasReplyByReplyId(final ReplyData rdataObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql = UPDATE_REPLYS_replyId;

	
		
		
		Integer filerows=0;
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(rdataObj!=null){
             	// System.out.println(taskObject.getFiledataList().size());
      			//System.out.println(paraobj.getReplyDataList().size()+"--"+paraobj.getReplyDataList().get(0).getParaReplyId());
			
					if(rdataObj.getParaReplyId()!=null ){
					
									 java.sql.Date date1 = null;
										try {
									if (rdataObj.getReplyDate() != null
											&& rdataObj.getReplyDate() != ""
											&& !rdataObj.getReplyDate().equals('0')) {
										
									
											date1 = DateUtil.getSQLDate( rdataObj.getReplyDate());
										
										
									}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
										
										filerows=		jdbcTemplate6.update(sql,rdataObj.getReplyAction(),date1,rdataObj.getReplyRemarks(), 
												rdataObj.getUserName(),rdataObj.getParaReplyId());
									
									
										

								
					
				
		        }
			
			 }
			 
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

		return filerows;
	}
	
	
	
	@Override
	public List<Paras> getParasAbstractByUnit( Integer unitId,Integer circleId, Integer divisionId ) throws IRParasUserException {
		
		
		
		String sql=null;
		
	// System.out.println(unitId+"--"+circleId+"--"+divisionId);
		
	
		
		
			
			if(unitId!=null && (circleId==null||circleId==0) && (divisionId==null||divisionId==0) ){
				
				
			      sql = TOTAL_PARAS_BYUNIT +" and (irpm.circle_id is null or irpm.circle_id=0  ) and (irpm.division_id is null or irpm.division_id=0  )   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
				}
			
			
			
				
				if(unitId!=null && circleId!=null && (divisionId==null||divisionId==0) ){
					
					
				      sql = TOTAL_PARAS_BYUNIT +"  and (irpm.division_id is null or irpm.division_id=0  )  and irpm.circle_id="+circleId+" and (irpm.division_id=0 or  irpm.division_id is null)  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					
					}
				
				
					
					
					
					
					
						
						
					
					if(unitId!=null && circleId!=null && divisionId!=null ){
						 
					      sql = TOTAL_PARAS_BYUNIT +"  and irpm.circle_id="+circleId+" and irpm.division_id= "+divisionId+"  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
						}
					
					
				
						
					// System.out.println("sqlIrparas"+sql);
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { unitId }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					pr.setParaId(rs.getInt(1));
					pr.setActionTitle(rs.getString(2));
					pr.setParasAction(rs.getString(3));
					
					pr.setFinancialYear(rs.getString(4));
					pr.setParaRemarks (rs.getString(5));
					pr.setUnitName(rs.getString(6));
					pr.setUnitId(rs.getInt(7));
					pr.setCircleName(rs.getString(8));
					pr.setCircleId(rs.getInt(9));
					pr.setDivisionName(rs.getString(10));
					pr.setDivisionId(rs.getInt(11));
					pr.setParaStatusId(rs.getInt(12));
					pr.setParaStatus(rs.getString(13));
					
					pr.setSectionA(rs.getString(14));
					pr.setSectionB(rs.getString(15));
					pr.setPrintCagStatus(rs.getString(16));
					pr.setCategoryId(rs.getString(17));
					pr.setParaNumber(rs.getString(18));
					pr.setAuditDateFrom(rs.getString(19));
					pr.setAuditDateTo(rs.getString(20));
					pr.setFileNumber(rs.getString(21));
					pr.setLarNumber(rs.getString(22));
					pr.setParaNumsectionA(rs.getString(23));
					pr.setParaNumsectionB(rs.getString(24));
					pr.setTransferFlag(rs.getBoolean(25));
					pr.setTunitId(rs.getInt(26));
					pr.setTcircleId(rs.getInt(27));
					pr.setTdivisionId(rs.getInt(28));
					pr.setTsubdivisionId(rs.getInt(29));
				
				
				
				
			    return pr;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return prList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Integer getCountOfParaDocs() throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql = COUNT_PARA_DOCS;

		Integer rows1 = 0;
		
		
		Integer filerows=0;
		
		 java.sql.Date date1 = null;
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			List<Map<String, Object>> 	ct=	jdbcTemplate6.queryForList(sql );
			
			
			for (Map<String, Object> row : ct) {
				rows1 = Integer.parseInt(row.get("doccount").toString());
			}
			
             // System.out.println("rows1"+rows1) ;
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return rows1;
	}
	
	
	@Override
	public List<Paras> getCAGParasAbstractByUnit( Integer unitId,Integer circleId, Integer divisionId ) throws IRParasUserException {
		
		
		
		String sql=null;
		
	 //System.out.println(unitId+"--"+circleId+"--"+divisionId);
		
	
		
		
			
			if(unitId!=null && (circleId==null||circleId==0) && (divisionId==null||divisionId==0) ){
				
				
			      sql = TOTAL_CAG_PARAS_BYUNIT +" and (irpm.circle_id is null or irpm.circle_id=0  ) and (irpm.division_id is null or irpm.division_id=0  )   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
				}
			
			
			
				
				if(unitId!=null && circleId!=null && (divisionId==null||divisionId==0) ){
					
					
				      sql = TOTAL_CAG_PARAS_BYUNIT +"  and (irpm.division_id is null or irpm.division_id=0  )  and irpm.circle_id="+circleId+" and (irpm.division_id=0 or  irpm.division_id is null)  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					
					}
				
				
					
					
					
					
					
						
						
					
					if(unitId!=null && circleId!=null && divisionId!=null ){
						 
					      sql = TOTAL_CAG_PARAS_BYUNIT +"  and irpm.circle_id="+circleId+" and irpm.division_id= "+divisionId+"  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
						}
					
					
				
						
		
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { unitId }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					pr.setParaId(rs.getInt(1));
					pr.setActionTitle(rs.getString(2));
					pr.setParasAction(rs.getString(3));
					
					pr.setFinancialYear(rs.getString(4));
					pr.setParaRemarks (rs.getString(5));
					pr.setUnitName(rs.getString(6));
					pr.setUnitId(rs.getInt(7));
					pr.setCircleName(rs.getString(8));
					pr.setCircleId(rs.getInt(9));
					pr.setDivisionName(rs.getString(10));
					pr.setDivisionId(rs.getInt(11));
					pr.setParaStatusId(rs.getInt(12));
					pr.setParaStatus(rs.getString(13));
					
					pr.setParaCAGsection(rs.getString(14));
					pr.setSectionId(rs.getInt(15));
					pr.setPrintCagStatus(rs.getString(16));
				
					pr.setParaNumber(rs.getString(17));
					pr.setAuditDateFrom(rs.getString(18));
					pr.setAuditDateTo(rs.getString(19));
					pr.setFileNumber(rs.getString(20));
					pr.setLarNumber(rs.getString(21));
					
					pr.setTransferFlag(rs.getBoolean(22));
					pr.setTunitId(rs.getInt(23));
					pr.setTcircleId(rs.getInt(24));
					pr.setTdivisionId(rs.getInt(25));
					pr.setTsubdivisionId(rs.getInt(26));
				
				
				
				
			    return pr;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return prList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public Integer insertCAGParas(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql1 = INSERT_CAG_PARA_GIST;
		
		//String sql2=SELECT_COUNT_GIST_BYFIN;
		
		Integer cag_gist_id = 0;
		
		Date date1=null;
		Date date2=null;
		
		Integer gistcount=0;
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			
			
			
			
			
			if (paraObj != null) {
				
				

			/*	List<Map<String, Object>> rows2 = jdbcTemplate6.queryForList(sql2, paraObj.getFinancialYear());
						 
								
						
				
				for (Map<String, Object> row1 : rows2) {
					gistcount = Integer.parseInt(row1.get("gistcount").toString());
				}*/
		

		/*	if(gistcount==0){*/

					List<Map<String, Object>> rows = jdbcTemplate6.queryForList(sql1,paraObj.getActionTitle(), paraObj.getFinancialYear(),
							 
									 paraObj.getParaNumber(), 
									paraObj.getUserName(),
									paraObj.getUnitId());
							
							
							
					
					
					for (Map<String, Object> row : rows) {
						cag_gist_id = Integer.parseInt(row.get("cag_gist_id").toString());
					}

				
			/*}
			if(gistcount>0){
				
				cag_gist_id=-1;
				
			}*/
					

						
							
							
							}

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cag_gist_id;
	}
	
	
	
	@Override
	public Integer insertCAGParasTransfer(CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql1 = INSERT_CAG_PARA_MAST_TRANSFERED;
		
		Integer cag_gist_id = 0;
		Date date1=null;
		Date date2=null;
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraObj != null) {

				if (paraObj.getParaDataList().size()>0) {
					
					if (paraObj.getAuditDateFrom() != null
							&& paraObj.getAuditDateFrom() != ""
							&& !paraObj.getAuditDateFrom().equals('0')) {

						date1 = DateUtil.getSQLDate(paraObj.getAuditDateFrom());

					}
					if (paraObj.getAuditDateTo() != null && paraObj.getAuditDateTo() != ""
							&& !paraObj.getAuditDateTo().equals('0')) {

						date2 = DateUtil.getSQLDate(paraObj.getAuditDateTo());

					}
					

					
						

					List<Map<String, Object>> rows = jdbcTemplate6.queryForList(sql1,paraObj.getActionTitle(), paraObj.getFinancialYear(),
							 paraObj.getUnitId(),	paraObj.getDivisionId(), paraObj.getCircleId(),paraObj.getSubdivisionId(),
									paraObj.getParaStatusId(),paraObj.getSectionId(), paraObj.getParaNumber(), paraObj.getTunitId(),paraObj.getTcircleId(),paraObj.getTdivisionId(),paraObj.getTsubdivisionId(),
									date1,date2,paraObj.getPrintCAG(),paraObj.getUserId(),paraObj.getUserName());
							
							
							
					
					
					for (Map<String, Object> row : rows) {
						cag_gist_id = Integer.parseInt(row.get("cag_gist_id").toString());
					}

					

						}
					

						
							
							
							}

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cag_gist_id;
	}
	
	
	@Override
	public Integer insertCAGParasDocuments(final CAGParas paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql2 = INSERT_CAG_PARAS_DOCUMENTS;
				
		

		Integer rows1 = 0;
		int[] j = null;
		Integer filerows=0;
		
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			
			if(paraobj.getParadocList()!=null){
			 if(paraobj.getParadocList().size()>0){
             	//System.out.println("coming here");
      			//System.out.println(taskObject.getFiledataList().get(0).getFileName());
				
					 
				
					if(paraobj.getParadocList().get(0).getParaDocName()!=null || paraobj.getParadocList().get(0).getParaDocName()!=" " ){
					j = jdbcTemplate6.batchUpdate(sql2,		new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {

									ParaDocuments sd = paraobj.getParadocList().get(i);
									
									 java.sql.Date date1 = null;
										
										try {
											
											if (paraobj.getDocdate()!= null
													&& paraobj.getDocdate() != ""
													&& !paraobj.getDocdate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( paraobj.getDocdate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

									
									ps.setInt(1, paraobj.getCagGistId());
									 ps.setInt(2,  paraobj.getCagParaId());
								     ps.setString(3,  sd.getParaDocName());
										
										ps.setString(4, sd.getParaDocLocation());
										ps.setString(5, sd.getParaDocOriginalName());
										
										//ps.setInt(6, paraobj.getUserId());
										ps.setString(6, paraobj.getUserName());
										ps.setInt(7, paraobj.getUnitId());
										
										ps.setString(8, paraobj.getDoctitle());
										
										ps.setDate(9, date1);
										
										

									
								}

								@Override
								public int getBatchSize() {
									return paraobj.getParadocList().size();
								}
							});
					
					}
				}
			 
			}
			
		        if(j!=null){   
				if (j.length > 0) {
					filerows=j.length;
					
					//System.out.println("rows"+rows);
					return filerows;
				}
		        }
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer insertCAGParasReply(final CAGParas paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_CAG_REPLY;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		
		 
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(paraobj.getReplyDataList()!=null){
             	
				
				 
				 
				if (paraobj.getReplyDataList().size() > 0) {
					if(paraobj.getReplyDataList().get(0).getReplyAction()!=null ){
					j = jdbcTemplate6.batchUpdate(sql3, 							new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
									
											
										

									ReplyData sd = paraobj.getReplyDataList().get(i);
									
									 
									

								
										ps.setInt(1,  paraobj.getCagGistId());
										ps.setInt(2,  paraobj.getCagParaId());										
										ps.setString(3, sd.getReplyAction());
										ps.setString(5, sd.getReplyRemarks());
										
										 java.sql.Date date1 = null;
										try {
											
											if (sd.getReplyDate() != null
													&& sd.getReplyDate() != ""
													&& !sd.getReplyDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( paraobj.getReplyDataList().get(i).getReplyDate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										 
									
											ps.setDate(5, date1);
										
										ps.setInt(6, paraobj.getUserId());
										
										ps.setString(7, paraobj.getUserName());
										

									
								}

								@Override
								public int getBatchSize() {
									return paraobj.getReplyDataList().size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					filerows=j.length;
					
					//System.out.println("rows"+rows);
					return filerows;
				}
		        }
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filerows;
	}
	
	
	@Override
	public Integer insertCAGParasMaster(final CAGParasData paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql1 = INSERT_CAG_PARA_MAST;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer cag_para_id=0;
		
		
		 
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			
             	
				//System.out.println("coming1"+sql1);
				if(paraobj.getCagGistId()!=null ){ 
					//System.out.println("comin2");
				 
			List<Map<String, Object>> rows = jdbcTemplate6.queryForList(sql1, paraobj.getParasAction(), paraobj.getParaTitle(),
					paraobj.getParaSequence(),	  paraobj.getUserName(),paraobj.getCagGistId(),
					paraobj.getSubParaNumber(), Boolean.parseBoolean(paraobj.getDiscussPac()) , Boolean.parseBoolean(paraobj.getPacincluded()),paraobj.getCunitId() );
			
			
			for (Map<String, Object> row : rows) {
				cag_para_id = Integer.parseInt(row.get("cag_para_id").toString());
			}

			
									 
									
									
										
									
							
					
					}
			
		      
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cag_para_id;
	}
	
	/*Integer circleId, Integer divisionId*/
	
	@Override
	public List<CAGParas> getCAGGistByUnit( Integer unitId ) throws IRParasUserException {
		
		
		
		String sql=null;
		
	 //System.out.println(unitId+"--"+circleId+"--"+divisionId);
		
	
	/*	&& (circleId==null||circleId==0) && (divisionId==null||divisionId==0)*/
		
			
			if(unitId!=null  ){
				
				
			      sql = TOTAL_CAG_GIST_BYUNIT    ;
				
				}
			
			
			
				/*
				if(unitId!=null && circleId!=null && (divisionId==null||divisionId==0) ){
					
					
				      sql = TOTAL_CAG_GIST_BYUNIT +"  and (icmg.division_id is null or icmg.division_id=0  )  and icmg.circle_id="+circleId+" and (icmg.division_id=0 or  icmg.division_id is null)  order by icmg.cag_gist_id ";
					
					}
				
				
					*/
					
					
					
					
						
						
					
					/*if(unitId!=null && circleId!=null && divisionId!=null ){
						 
					      sql = TOTAL_CAG_GIST_BYUNIT +"  and icmg.circle_id="+circleId+" and icmg.division_id= "+divisionId+"  order by icmg.cag_gist_id ";
						
						}
					
					
				
						*/
		
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql ,new Object[] { unitId }, new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					pr.setCagGistId(rs.getInt(1));
					pr.setActionTitle(rs.getString(2));
					
					
					pr.setFinancialYear(rs.getString(3));
					
					pr.setUnitName(rs.getString(4));
					pr.setUnitId(rs.getInt(5));
				
					
					
				
					
					pr.setParaNumber(rs.getString(6));
					
					
					pr.setTransferFlag(rs.getBoolean(7));
					pr.setTunitId(rs.getInt(8));
					
				
				
				
			    return pr;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return prList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<CAGParasData> getCAGParaAllbyunitId(CAGParas paraObj) throws IRParasUserException {
		String sql=null;
		
		if(((paraObj.getUnitId()!=9832)&&(paraObj.getCircleId()!=21614 ))|| paraObj.getUnitId()!=4 ){
		sql =TOTAL_CAG_PARA_ALL;
		}
		
		

		try {
			List<CAGParasData> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId(),paraObj.getFinancialYear() }, new RowMapper<CAGParasData>() {
				public CAGParasData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParasData pr = new CAGParasData();
					pr.setParasAction(rs.getString(1));
					pr.setParaSequence(rs.getInt(2));
				
					pr.setCagGistId(rs.getInt(3));
					pr.setCagParaId(rs.getInt(4));
					pr.setParaTitle(rs.getString(5));
					pr.setSubParaNumber(rs.getString(6));
					
				
					pr.setDiscussPac(rs.getString(7));
				
					pr.setSubParaUnitId(rs.getInt(8));
					pr.setFinancialYear(rs.getString(9));
					pr.setCagGistPara(rs.getString(10));
					pr.setUnitName(rs.getString(11));
					pr.setParaNumber(rs.getString(12));
					pr.setPacincluded(rs.getString(13));
					pr.setFinancialYear(rs.getString(14));
					pr.setParaStatusId(rs.getInt(15));
					pr.setParaStatus(rs.getString(16));
					
					
				
				
				
				
			    return pr;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return prList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<CAGParasData> getCAGParaEnci(CAGParas paraObj ) throws IRParasUserException {
		String sql=null;
		
	
		
		 sql=TOTAL_CAG_PARA_ENCI;
		

		try {
			List<CAGParasData> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getFinancialYear() }, new RowMapper<CAGParasData>() {
				public CAGParasData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParasData pr = new CAGParasData();
					pr.setParasAction(rs.getString(1));
					pr.setParaSequence(rs.getInt(2));
				
					pr.setCagGistId(rs.getInt(3));
					pr.setCagParaId(rs.getInt(4));
					pr.setParaTitle(rs.getString(5));
					pr.setSubParaNumber(rs.getString(6));
					
					//pr.setParaStatusId(rs.getInt(7));
					pr.setDiscussPac(rs.getString(7));
				   
					pr.setSubParaUnitList(rs.getString(8));
					pr.setFinancialYear(rs.getString(9));
					pr.setUnitName(rs.getString(10));
					pr.setCagGistPara(rs.getString(11));
				
					pr.setParaNumber(rs.getString(12));
					
					pr.setPacincluded(rs.getString(13));
					pr.setFinancialYear(rs.getString(14));
					pr.setParaStatusId(rs.getInt(15));
					pr.setParaStatus(rs.getString(16));
					
					
				
				
				
				
			    return pr;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return prList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	/*@Override
	public Integer insertnewCAGPara(final CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_CAG_PARA_MAST;

		Integer rows1 = 0;
		
		
		Integer filerows=0;
		
		 java.sql.Date date1 = null;
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(paraObj.getCagGistId()!=null){
				 
				
			
				
					if(paraObj.getParasAction()!=null  ){
						 rows1 = jdbcTemplate6.update(sql,paraObj.getParasAction(),paraObj.getParaTitle(),paraObj.getParaSequence(), 
								 paraObj.getUserId(),paraObj.getUserName(),paraObj.getCagGistId());
								
								
					
					
				}
			}
		       
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return rows1;
	}
	*/
	@Override
	public Integer addCAGParasReply(final ReplyData replyObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_CAG_PARA_REPLY_NEW;
		
		//String sql1=UPDATE_UNIT_MAP_BYREPLY;

		Integer rows1 = 0;
		
		Integer rows2=0;
		
		
		Integer filerows=0;
		
		 java.sql.Date date1 = null;
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(replyObj.getReplyAction()!=null){
				 
				 if (replyObj.getReplyDate() != null
							&& replyObj.getReplyDate() != ""
							&& !replyObj.getReplyDate().equals('0')) {

						date1 = DateUtil.getSQLDate(replyObj.getReplyDate());

					}
				 
             	// System.out.println(taskObject.getFiledataList().size());
      			//System.out.println(taskObject.getFiledataList().get(0).getFileName());
				
					if(replyObj.getReplyDate()!=null ){
						 rows1 = jdbcTemplate6.update(sql,replyObj.getCagGistId()   ,replyObj.getCagParaId(),replyObj.getReplyAction(),replyObj.getReplyRemarks(), 
								replyObj.getUserName(), date1,replyObj.getSubParaUnitId());
								
								
					//if(rows1>0){
						
					///	rows2= jdbcTemplate6.update(sql1,replyObj.getUserName(),replyObj.getSubParaUnitId(),replyObj.getCagParaId());
						
					//}
					
				}
			}
		       
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer getCountOfCAGParaDocs() throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql = COUNT_CAG_PARA_DOCS;

		Integer rows1 = 0;
		
		
		Integer filerows=0;
		
		 java.sql.Date date1 = null;
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			List<Map<String, Object>> 	ct=	jdbcTemplate6.queryForList(sql );
			
			
			for (Map<String, Object> row : ct) {
				rows1 = Integer.parseInt(row.get("doccount").toString());
			}
			
             // System.out.println("rows1"+rows1) ;
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return rows1;
	}
	
	@Override
	public List<ReplyData> getCAGReplybyParaId(Integer cagParaId ) throws IRParasUserException {
		
		String sql = GET_CAG_REPLY_BY_PARAID;
		
		
		//System.out.println("sql"+sql+cagParaId);
		
	
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql ,new Object[] { cagParaId}, new RowMapper<ReplyData>() {
				public ReplyData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReplyData rep = new ReplyData();
			
				rep.setCagGistId(rs.getInt(1));
				rep.setCagParaId(rs.getInt(2));
				
				rep.setReplyAction(rs.getString(3));
				rep.setReplyRemarks(rs.getString(4));
			
				//rep.setUserId(rs.getInt(5));
				rep.setUserName(rs.getString(5));
				//rep.setCreateUserId(rs.getInt(7));
				rep.setUpdatedUsername(rs.getString(6));
				rep.setReplyDate(rs.getString(7));
				rep.setParaReplyId(rs.getInt(8));
				rep.setSubParaUnitId(rs.getInt(9));
				rep.setUnitName(rs.getString(10));
				rep.setParaStatusId(rs.getInt(11));
				rep.setParaStatus(rs.getString(12));
			
				
				
				
			    return rep;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return replyList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<ParaDocuments> getCAGDocsByParaId(Integer cagParaId ) throws IRParasUserException {
		String sql = GET_CAG_DOCS_BY_PARAID;
		
		
		
	
		try {
			List<ParaDocuments> docList = jdbcTemplate6.query(sql ,new Object[] { cagParaId}, new RowMapper<ParaDocuments>() {
				public ParaDocuments mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ParaDocuments doc = new ParaDocuments();
				doc.setCagGistId(rs.getInt(1));
				doc.setCagParaId(rs.getInt(2));
				doc.setParaDocName(rs.getString(3));
				doc.setParaDocLocation(rs.getString(4));
				doc.setParaDocOriginalName(rs.getString(5));
			//	doc.setUserId(rs.getInt(6));
				doc.setUserName(rs.getString(6));
				//doc.setUpdateduserId(rs.getInt(8));
				doc.setUpdateduserName(rs.getString(7));
				
				
				doc.setDocId(rs.getInt(8));
				doc.setUnitId(rs.getInt(9));
				doc.setUnitName(rs.getString(10));
				doc.setDoctitle(rs.getString(11));
				doc.setDocdate(rs.getString(12));
				
				
				
			    return doc;

			    

				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return docList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<ParaDocuments> getCAGDocs(CAGParas paraObj ) throws IRParasUserException {
		String sql = GET_CAG_DOCS;
		
		
		
		
		
	
		try {
			List<ParaDocuments> docList = jdbcTemplate6.query(sql ,new Object[] { }, new RowMapper<ParaDocuments>() {
				public ParaDocuments mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ParaDocuments doc = new ParaDocuments();
				doc.setCagGistId(rs.getInt(1));
				doc.setCagParaId(rs.getInt(2));
				doc.setParaDocName(rs.getString(3));
				doc.setParaDocLocation(rs.getString(4));
				doc.setParaDocOriginalName(rs.getString(5));
			//	doc.setUserId(rs.getInt(6));
				doc.setUserName(rs.getString(6));
				//doc.setUpdateduserId(rs.getInt(8));
				doc.setUpdateduserName(rs.getString(7));
				
				
				doc.setDocId(rs.getInt(8));
				doc.setUnitId(rs.getInt(9));
				doc.setUnitName(rs.getString(10));
				doc.setDoctitle(rs.getString(11));
				doc.setDocdate(rs.getString(12));
				
				
				
			    return doc;

			    

				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return docList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	
	@Override
	public Integer deleteCAGGistParasReplyDocs(Integer cagGistId, String userName) throws IRParasUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_CAG_GIST;
		
		//String sql2 = DELETE_CAG_GIST_PARA;
		
		//String sql3 = DELETE_CAG_GIST_PARAREPLY;
		//String sql4 = DELETE_CAG_GIST_PARADOCS;
		
	//	String sql5= DELETE_CAG_UNIT_MAP ;

		Integer rows1 = 0;
	/*	Integer rows2 = 0;
		Integer rows3 = 0;
		Integer rows4 = 0;
		Integer rows5 = 0;*/

		Date date1 = null;

		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (cagGistId != null) {

				if (cagGistId > 0) {

					rows1 = jdbcTemplate6.update(sql1,userName ,cagGistId);
					/*rows2 = jdbcTemplate6.update(sql2, userId,userName,cagGistId);
					rows3 = jdbcTemplate6.update(sql3, userId,userName,cagGistId);
					
					rows4 = jdbcTemplate6.update(sql4, userId,userName,cagGistId);
					rows5 = jdbcTemplate6.update(sql5, userId,userName,cagGistId);
*/
				}

				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	@Override
	public Integer deleteCAGParasReplyByParaId(Integer cagParaId, String userName) throws IRParasUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_CAG_PARA;
		String sql2 = DELETE_CAG_PARA_REPLY;
		String sql3 = DELETE_CAG_PARA_DOCS;
		String sql4=  DELETE_SUB_PARA_UNIT_MAP ;
		String sql5=  DELETE_CAG_STATUS;
		
		

		Integer rows1 = 0;
		Integer rows2 = 0;
		Integer rows3 = 0;
		Integer rows4 = 0;
		Integer rows5 = 0;
		

		Date date1 = null;

		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (cagParaId != null) {

				if (cagParaId > 0) {

					rows1 = jdbcTemplate6.update(sql1, userName, cagParaId);
					rows2 = jdbcTemplate6.update(sql2, userName, cagParaId);
					rows3 = jdbcTemplate6.update(sql3, userName, cagParaId);
					rows4 = jdbcTemplate6.update(sql4, userName, cagParaId);
					rows5 = jdbcTemplate6.update(sql5, userName, cagParaId);
					

				}

				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public Integer deleteCAGReplyByReplyId(Integer cagReplyId, String userName) throws IRParasUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_CAG_REPLY;
		
		

		Integer rows1 = 0;
		
		

		Date date1 = null;

		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (cagReplyId != null) {

				if (cagReplyId > 0) {

					rows1 = jdbcTemplate6.update(sql1, userName, cagReplyId);
					
					

				}

				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public Integer deleteCAGDocsByDocId(Integer cagDocId, String userName) throws IRParasUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_CAG_DOCS;
	
		Integer rows1 = 0;
	    Date date1 = null;

		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (cagDocId != null) {

				if (cagDocId > 0) {

					rows1 = jdbcTemplate6.update(sql1, userName, cagDocId);
					
					

				}

				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	

	

	@Override
	public CAGParas getCAGGistByGistId(Integer cagGistId ) throws IRParasUserException {
		
		
	
				String sql=GET_CAG_GIST_BYGISTID;
						
		
		
		
		
	
		try {
			CAGParas prList = (CAGParas) jdbcTemplate6.queryForObject(sql ,new Object[] { cagGistId }, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					pr.setCagGistId(rs.getInt(1));
					pr.setActionTitle(rs.getString(2));
					
					
					pr.setFinancialYear(rs.getString(3));
					
					pr.setUnitName(rs.getString(4));
					pr.setUnitId(rs.getInt(5));
					pr.setCircleName(rs.getString(6));
					pr.setCircleId(rs.getInt(7));
					pr.setDivisionName(rs.getString(8));
					pr.setDivisionId(rs.getInt(9));
					pr.setParaStatusId(rs.getInt(10));
					pr.setParaStatus(rs.getString(11));
					
					
					pr.setParaCAGsection(rs.getString(12));
					pr.setSectionId(rs.getInt(13));
					
					pr.setPrintCagStatus(rs.getString(14));
					
					pr.setParaNumber(rs.getString(15));
					pr.setAuditDateFrom(rs.getString(16));
					pr.setAuditDateTo(rs.getString(17));
					
					pr.setTransferFlag(rs.getBoolean(18));
					pr.setTunitId(rs.getInt(19));
					pr.setTcircleId(rs.getInt(20));
					pr.setTdivisionId(rs.getInt(21));
					pr.setTsubdivisionId(rs.getInt(22));
				
				
				
				
			    return pr;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return prList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	@Override
	public Integer editcagGistParas(Integer cagGistId,String finYear, String paraNum, String actionTitle,String userName) throws IRParasUserException {
		// TODO Auto-generated method stub

    String sql1 = UPDATE_CAG_MASTER_GIST;
		
		Integer paraId = 0;
		
		Date date1=null;
		Date date2=null;
		
		Integer rows=0;
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
		

				if ( cagGistId!=null ) {

				rows = jdbcTemplate6.update(sql1,actionTitle,finYear,paraNum,userName,cagGistId);
							
							
					}
					
							

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer editcagsubParas(final CAGParasData paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql1 = UPDATE_CAG_MASTER;

	
		
		Integer rows=0;
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(paraObj!=null){
				 
				 rows = jdbcTemplate6.update(sql1,paraObj.getParasAction(), paraObj.getParaSequence(),
							paraObj.getUserName(), paraObj.getParaTitle(),paraObj.getSubParaNumber(),
								 Boolean.parseBoolean(paraObj.getDiscussPac()),Boolean.parseBoolean(paraObj.getPacincluded()), paraObj.getCagParaId());
						
						
				 
		        }
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	

	@Override
	public Integer editCagParasReply(final ReplyData replyObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_REPLY_CAG;
		
		//String sql4=UPDATE_UNIT_MAP_BYREPLY;

	
		
		Integer rows=0;
		
		Integer rows1=0;
		
		Date date1=null;
		
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(replyObj!=null && replyObj.getParaReplyId()!=null){
             	
				if (replyObj.getParaReplyId() > 0) {
					
					if (replyObj.getReplyDate() != null
							&& replyObj.getReplyDate() != ""
							&& !replyObj.getReplyDate().equals('0')) {
						
					
							date1 = DateUtil.getSQLDate( replyObj.getReplyDate());
						
						
					}
					
					
					
					rows = jdbcTemplate6.update(sql3,replyObj.getReplyAction(), replyObj.getReplyRemarks(),
							date1,	  replyObj.getUserName(),replyObj.getParaReplyId());
				
				
					//if(rows>0){
					//	rows1=jdbcTemplate6.update(sql4, replyObj.getUserId(), replyObj.getUserName(),replyObj.getParaStatusId(),replyObj.getSubParaUnitId(),replyObj.getCagParaId());
						
					//}		
								

							
									
									
									
				
		        }
			
			 } 
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer editCAGParasTransfer(final CAGParas paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub

String sql1 = UPDATE_CAG_PARAS_TRANSFER;
		
		Integer paraId = 0;
		Date date1=null;
		Date date2=null;
		Integer rows=0;
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (paraObj != null && paraObj.getCagGistId()!=null) {

				if ( paraObj.getCagGistId()>0 ) {
					
					if (paraObj.getAuditDateFrom() != null
							&& paraObj.getAuditDateFrom() != ""
							&& !paraObj.getAuditDateFrom().equals('0')) {

						date1 = DateUtil.getSQLDate(paraObj.getAuditDateFrom());

					}
					if (paraObj.getAuditDateTo() != null && paraObj.getAuditDateTo() != ""
							&& !paraObj.getAuditDateTo().equals('0')) {

						date2 = DateUtil.getSQLDate(paraObj.getAuditDateTo());

					}
					

					
						//System.out.println("paraObj.getTcircleId()"+paraObj.getUnitId());

					 rows = jdbcTemplate6.update(sql1,paraObj.getActionTitle(), paraObj.getFinancialYear(),
							 paraObj.getUnitId(),	paraObj.getDivisionId(), paraObj.getCircleId(),paraObj.getSubdivisionId(),
									paraObj.getParaStatusId(), paraObj.getParaNumber(), paraObj.getTunitId(),paraObj.getTcircleId(),paraObj.getTdivisionId(),paraObj.getTsubdivisionId(),
									date1,date2,paraObj.getPrintCAG(),paraObj.getUserId(),paraObj.getUserName(),paraObj.getCagGistId());
							
							
							
					// System.out.println("rows"+rows);
					

					

						}
					

						
							
							
							}

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer UpdateTrCAGGistIdByGistId(Integer oldcagGistId,Integer newcagGistId,Integer userId, String userName) throws IRParasUserException {
		// TODO Auto-generated method stub

		String sql1 = UPDATE_TR_REPLY;
		String sql2 = UPDATE_TR_PARAS_MST;
		String sql3 = UPDATE_TR_DOCS;
		
		

		Integer rows1 = 0;
		Integer rows2 = 0;
		Integer rows3 = 0;
		

		Date date1 = null;

		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			if (oldcagGistId != null) {

				if (oldcagGistId > 0) {

					rows1 = jdbcTemplate6.update(sql1,newcagGistId, userId,userName, oldcagGistId);
					rows2 = jdbcTemplate6.update(sql2,newcagGistId, userId,userName, oldcagGistId);
					rows3 = jdbcTemplate6.update(sql3,newcagGistId, userId,userName, oldcagGistId);
					

				}

				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	

	@Override
	public List<CAGParas> getCAGFinancialYear() throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_FINANCIAL_YEAR;
		try {

			List<CAGParas> yearList = jdbcTemplate6.query(sql,
					new RowMapper<CAGParas>() {

						public CAGParas mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CAGParas cagp = new CAGParas();
							cagp.setCagGistId(rs.getInt(1));
							cagp.setFinancialYear(rs.getString(2));
							return cagp;
						}

					});
			jdbcTemplate6.getDataSource().getConnection().close();

			return yearList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	@Override
	public CAGParas getCAGParaGist(Integer cagGistId) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_CAG_GIST;
		try {
			
			//System.out.println(SELECT_CAG_GIST);

			CAGParas paraList = (CAGParas) jdbcTemplate6.queryForObject (sql,new Object[] { cagGistId },
					new RowMapper<Object>() {

						public Object mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CAGParas cagp = new CAGParas();
							cagp.setCagGistId(rs.getInt(1));
							cagp.setActionTitle(rs.getString(2));
							cagp.setParaNumber(rs.getString(3));
							cagp.setParasAction(rs.getString(4));
							cagp.setFinancialYear(rs.getString(5));
							return cagp;
						}

					});
			jdbcTemplate6.getDataSource().getConnection().close();
			//System.out.println(paraList);
			return paraList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	
	@Override
	public Integer insertcagparaunitmap(final List<CAGParasData> paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_CAG_PARA_UNIT_MAP;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		
		 
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(paraobj!=null){
             	
				
				 
				 
				if (paraobj.size() > 0) {
					if(paraobj.get(0).getSubParaUnitId()!=null ){
					j = jdbcTemplate6.batchUpdate(sql3, new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
									
											
										

									CAGParasData sd = paraobj.get(i);
									
									 
								//	System.out.println("in dao"+sd.getSubParaUnitId());
									//System.out.println("in userid"+sd.getUserId());
									//System.out.println("in para status"+sd.getParaStatusId());
									
									//System.out.println("in get unitId"+sd.getCunitId());

								
										ps.setInt(1,  sd.getCagParaId());
										ps.setInt(2,  sd.getSubParaUnitId());
										ps.setInt(3,  sd.getCagGistId());										
										//ps.setInt(4, sd.getUserId());
										ps.setString(4, sd.getUserName());
										
										ps.setInt(5, sd.getCunitId());
										
										
									
									
										
									
								}

								@Override
								public int getBatchSize() {
									return paraobj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					filerows=j.length;
					
					//System.out.println("rows"+rows);
					return filerows;
				}
		        }
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return filerows;
	}
	
	
	@Override
	public List<CAGParasData> selectCAGSubParaList(Integer cagGistId) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_SUB_PARALIST;
		
		final String No="NO";
		
		final String Yes="YES";
		try {
			
			//System.out.println(SELECT_SUB_PARALIST);

			List<CAGParasData> paraList = jdbcTemplate6.query(sql,new Object[] { cagGistId },
					new RowMapper<CAGParasData>() {

						public CAGParasData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CAGParasData cagp = new CAGParasData();
							
							
						///	System.out.println(rs.getString(1));
					
							cagp.setParasAction(rs.getString(1));
							
							cagp.setParaSequence(rs.getInt(2));
							cagp.setCagGistId(rs.getInt(3));
							cagp.setCagParaId(rs.getInt(4));
							cagp.setParaTitle(rs.getString(5));
							cagp.setSubParaNumber(rs.getString(6));
							
							//System.out.println("7"+rs.getString(7));
							//System.out.println("10"+rs.getString(10));
						
							if(rs.getString(7).equals("f")){
								
							cagp.setDiscussPac(No);
							};
							if(rs.getString(7).equals("t")){
								
								cagp.setDiscussPac(Yes);	
							}
							cagp.setSubParaUnitList(rs.getString(8));
							cagp.setUnitName(rs.getString(9));
							if(rs.getString(10).equals("f")){
							cagp.setPacincluded(No);
							}
                            if(rs.getString(10).equals("t")){
								
								cagp.setPacincluded(Yes);	
							}
                            cagp.setCunitId(rs.getInt(11));
                          //  System.out.println("cagp"+cagp);
                            
                            cagp.setParaStatusId(rs.getInt(12));
                            cagp.setParaStatus(rs.getString(13));
                            cagp.setCagGistPara(rs.getString(14));
                            cagp.setParaNumber(rs.getString(15));
                            cagp.setFinancialYear(rs.getString(16));
                            
							return cagp;
						}

					});
			jdbcTemplate6.getDataSource().getConnection().close();
			//System.out.println("paraList"+paraList);
			return paraList;
		} catch (Exception exc) {
			exc.getMessage();
			//System.out.println("coming here");
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	@Override
	public List<CAGParasData> selectPACCAGSubParaList(CAGParasData parObj) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_SUB_PACPARALIST;
		
		final String No="NO";
		
		final String Yes="YES";
		try {
			
			//System.out.println(SELECT_SUB_PARALIST);

			List<CAGParasData> paraList = jdbcTemplate6.query(sql,new Object[] { parObj.getCagGistId() },
					new RowMapper<CAGParasData>() {

						public CAGParasData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CAGParasData cagp = new CAGParasData();
							
							
						///	System.out.println(rs.getString(1));
					
							cagp.setParasAction(rs.getString(1));
							
							cagp.setParaSequence(rs.getInt(2));
							cagp.setCagGistId(rs.getInt(3));
							cagp.setCagParaId(rs.getInt(4));
							cagp.setParaTitle(rs.getString(5));
							cagp.setSubParaNumber(rs.getString(6));
							
							//System.out.println("7"+rs.getString(7));
							//System.out.println("10"+rs.getString(10));
						
							if(rs.getString(7).equals("f")){
								
							cagp.setDiscussPac(No);
							};
							if(rs.getString(7).equals("t")){
								
								cagp.setDiscussPac(Yes);	
							}
							cagp.setSubParaUnitList(rs.getString(8));
							cagp.setUnitName(rs.getString(9));
							if(rs.getString(10).equals("f")){
							cagp.setPacincluded(No);
							}
                            if(rs.getString(10).equals("t")){
								
								cagp.setPacincluded(Yes);	
							}
                            cagp.setCunitId(rs.getInt(11));
                          //  System.out.println("cagp"+cagp);
                            
                            cagp.setParaStatusId(rs.getInt(12));
                            cagp.setParaStatus(rs.getString(13));
                            cagp.setCagGistPara(rs.getString(14));
                            cagp.setParaNumber(rs.getString(15));
                            cagp.setFinancialYear(rs.getString(16));
                            
							return cagp;
						}

					});
			jdbcTemplate6.getDataSource().getConnection().close();
			//System.out.println("paraList"+paraList);
			return paraList;
		} catch (Exception exc) {
			exc.getMessage();
			//System.out.println("coming here");
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	
	@Override
	public List<CAGParas> getCAGParaGistbyFinYear(String finYear) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_GIST_BYFIN;
		try {
			
			//System.out.println(SELECT_CAG_GIST);

			List<CAGParas> paraList = jdbcTemplate6.query (sql,new Object[] { finYear },
					new RowMapper<CAGParas>() {

						public CAGParas mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CAGParas cagp = new CAGParas();
							cagp.setCagGistId(rs.getInt(1));
							cagp.setActionTitle(rs.getString(2));
							cagp.setParaNumber(rs.getString(3));
							cagp.setFinancialYear(rs.getString(4));
							cagp.setSubparacount(rs.getInt(5));
							cagp.setUnitId(rs.getInt(6));
							return cagp;
						}

					});
			jdbcTemplate6.getDataSource().getConnection().close();
			//System.out.println(paraList);
			return paraList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public CAGParasData selectSubParaListbyPara(Integer cagParaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_SUB_PARA_PARAID;
		
		
		try {
			
			//System.out.println(SELECT_CAG_GIST);

			CAGParasData paraObj = (CAGParasData) jdbcTemplate6.queryForObject(sql,new Object[] { cagParaId },
					new RowMapper<Object>() {

						public Object mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CAGParasData cagp = new CAGParasData();
							cagp.setParasAction(rs.getString(1));
							
							cagp.setParaSequence(rs.getInt(2));
							cagp.setCagGistId(rs.getInt(3));
							cagp.setCagParaId(rs.getInt(4));
							cagp.setParaTitle(rs.getString(5));
							cagp.setSubParaNumber(rs.getString(6));
						
							if(rs.getString(7).equals("t")){
								
							cagp.setDiscussPac("true");
							}
							if(rs.getString(7).equals("f")){
								
								cagp.setDiscussPac("false");
								}
						
							cagp.setSubParaUnitList(rs.getString(8));
							cagp.setParaUnitIdList(rs.getString(9));
							
							if(rs.getString(10).equals("t")){
								
								cagp.setPacincluded("true");
								}
								if(rs.getString(10).equals("f")){
									
									cagp.setPacincluded("false");
									}
							
							return cagp;
						}

					});
			jdbcTemplate6.getDataSource().getConnection().close();
			//System.out.println(paraList);
			return paraObj;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	

	@Override
	public List<Integer> getUnitListUnitMap(Integer cagParaId) throws IRParasUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_COUNT_UNIT_MAP;
		
		List<Integer> unitList = new ArrayList<Integer>();
		
		Integer unitid=0;
		try {


			List<Map<String, Object>> rows2 = jdbcTemplate6.queryForList(sql, cagParaId);
					 
							
					
			
			for (Map<String, Object> row1 : rows2) {
				unitid = Integer.parseInt(row1.get("unit_id").toString());
				
				//System.out.println("unitid"+unitid);

				
				unitList.add(unitid);
			}
	

			jdbcTemplate6.getDataSource().getConnection().close();
			
			//System.out.println("unitList"+unitList);

			return unitList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	

	@Override
	public Integer deleteunitmapbyunit(final List<CAGParasData> paraobj) throws IRParasUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_PARA_UNIT_MAP_BYUNIT;
		
		

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		
		 
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			 if(paraobj!=null){
             	
				
				 
				 
				if (paraobj.size() > 0) {
					if(paraobj.get(0).getSubParaUnitId()!=null ){
					j = jdbcTemplate6.batchUpdate(sql1, new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
									
											
										

									CAGParasData sd = paraobj.get(i);
									
									 
									//System.out.println("in dao"+sd.getSubParaUnitId());

								
										
										ps.setString(1,  sd.getUserName());
										ps.setInt(2,  sd.getCagParaId());										
										ps.setInt(3, sd.getSubParaUnitId());
								
										
										
										
									
									
										
									
								}

								@Override
								public int getBatchSize() {
									return paraobj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					filerows=j.length;
					
					//System.out.println("rows"+rows);
					return filerows;
				}
		        }
			
                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return filerows;
	}
	
	
	@Override
	public  ReplyData getCAGReplybyreplyid(Integer cagReplyId ) throws IRParasUserException {
		
		String sql = GET_CAG_REPLY_BYREPLYID;
		
		
		try {
			ReplyData replyList = (ReplyData) jdbcTemplate6.queryForObject(sql ,new Object[] { cagReplyId}, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReplyData rep = new ReplyData();
			
				rep.setCagGistId(rs.getInt(1));
				rep.setCagParaId(rs.getInt(2));
				
				rep.setReplyAction(rs.getString(3));
				rep.setReplyRemarks(rs.getString(4));
				//rep.setCreateUserId(rs.getInt(5));
				rep.setCreateUserName(rs.getString(5));
			//	rep.setUserId(rs.getInt(7));
				rep.setUpdatedUsername(rs.getString(6));
			
				rep.setReplyDate(rs.getString(7));
				rep.setParaReplyId(rs.getInt(8));
				rep.setSubParaUnitId(rs.getInt(9));
				//rep.setParaStatusId(rs.getInt(10));
				
				
				
				
			    return rep;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return replyList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public  List<Paras> getParaYearByOffice(Paras paraObj ) throws IRParasUserException {
		
		String sql = SELECT_PARA_YEAR_OFFICE;
		
		
		
		//System.out.println("SELECT_PARA_YEAR_OFFICE"+sql);
	
		try {
			List<Paras> yearList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId(),paraObj.getCircleId(),paraObj.getDivisionId(),paraObj.getSubdivisionId()}
			, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras rep = new Paras();
			
				rep.setFinancialYear(rs.getString(1));
				
			    return rep;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return yearList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public  List<Paras> getParagistByYearByOffice(Paras paraObj ) throws IRParasUserException {
		
		String sql = SELECT_GIST_YEAR_OFFICE;
		
		
		
	//System.out.println("SELECT_GIST_YEAR_OFFICE"+sql);
	
		try {
			List<Paras> yearList = jdbcTemplate6.query(sql ,new Object[] {  paraObj.getFinancialYear(),paraObj.getUnitId(),paraObj.getCircleId(),paraObj.getDivisionId(),paraObj.getSubdivisionId()}
			, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
			
					pr.setParaId(rs.getInt(1));
					pr.setActionTitle(rs.getString(2));				
					pr.setFinancialYear(rs.getString(3));	
					
					pr.setUnitId(rs.getInt(4));					
					pr.setCircleId(rs.getInt(5));					
					pr.setDivisionId(rs.getInt(6));
					pr.setSubdivisionId(rs.getInt(7));
					pr.setParaStatusId(rs.getInt(8));
					pr.setSectionId(rs.getInt(9));
					pr.setCategoryId(rs.getString(10));
					pr.setParaNumber(rs.getString(11));
					pr.setTunitId(rs.getInt(12));
					pr.setTcircleId(rs.getInt(13));
					pr.setTdivisionId(rs.getInt(14));
					pr.setTsubdivisionId(rs.getInt(15));
					
					pr.setAuditDateFrom(rs.getString(16));
					pr.setAuditDateTo(rs.getString(17));
					pr.setPrintCAG(rs.getBoolean(18));
					pr.setFileNumber(rs.getString(19));
					pr.setLarNumber(rs.getString(20));
					
				
					
				
			    return pr;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return yearList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public  List<Paras> getSubParadataByParaId(Paras paraObj ) throws IRParasUserException {
		
		String sql = SELECT_SUBPARA_DATA_BY_PARA_ID;
		
		
		
		//System.out.println("SELECT_GIST_YEAR_OFFICE"+sql);
	
		try {
			List<Paras> yearList = jdbcTemplate6.query(sql ,new Object[] {  paraObj.getParaId()}
			, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
			
					pr.setSubParaId(rs.getInt(1));
					pr.setParasAction(rs.getString(2));
					pr.setSubcategory(rs.getString(3));	
					pr.setParaStatusId(rs.getInt(4));
					
			    return pr;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return yearList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<ReplyData> getReplybySubParaId(Integer subParaId ) throws IRParasUserException {
		String sql = GET_REPLY_BY_SUB_PARA_ID;
		
		
		
		
	
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql ,new Object[] { subParaId }, new RowMapper<ReplyData>() {
				public ReplyData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReplyData rep = new ReplyData();
			
				rep.setParaReplyId(rs.getInt(1));
				rep.setParaId(rs.getInt(2));
				
				rep.setReplyAction(rs.getString(3));
				rep.setReplyRemarks(rs.getString(4));
				rep.setReplyDate(rs.getString(5));
				rep.setUserId(rs.getInt(6));
				rep.setUserName(rs.getString(7));
				rep.setCreateUserId(rs.getInt(8));
				rep.setCreateUserName(rs.getString(9));
				rep.setSubParaId(rs.getInt(10));
				
				
				
			    return rep;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			
			//System.out.println("replyList"+replyList);
			return replyList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	@Override
	public List<ReplyData> getReplybyparaReplyId(Integer parareplyId ) throws IRParasUserException {
		String sql = GET_REPLY_BY_PARA_REPLY_ID;
		
		
		
		
	 //System.out.println("GET_REPLY_BY_PARA_REPLY_ID"+GET_REPLY_BY_PARA_REPLY_ID+parareplyId);
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql ,new Object[] { parareplyId }, new RowMapper<ReplyData>() {
				public ReplyData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReplyData rep = new ReplyData();
			
				rep.setParaReplyId(rs.getInt(1));
				rep.setParaId(rs.getInt(2));
				
				rep.setReplyAction(rs.getString(3));
				rep.setReplyRemarks(rs.getString(4));
				rep.setReplyDate(rs.getString(5));
				rep.setUserId(rs.getInt(6));
				rep.setUserName(rs.getString(7));
				rep.setCreateUserId(rs.getInt(8));
				rep.setCreateUserName(rs.getString(9));
				rep.setSubParaId(rs.getInt(10));
				
				
				
			    return rep;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			
			//System.out.println("replyList"+replyList);
			return replyList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<ParaDocuments> getDocsBySubParaId(Integer subParaId ) throws IRParasUserException {
		String sql = GET_ALL_DOCS_SUB_PARA_ID;
		
		
		
	
		try {
			List<ParaDocuments> docList = jdbcTemplate6.query(sql ,new Object[] { subParaId }, new RowMapper<ParaDocuments>() {
				public ParaDocuments mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ParaDocuments doc = new ParaDocuments();
				doc.setDocId(rs.getInt(1));
				doc.setParaDocOriginalName(rs.getString(2));
				doc.setParaId(rs.getInt(3));
				doc.setParaDocName(rs.getString(4));
				doc.setSubParaId(rs.getInt(5));
				
				
				
			    return doc;

			    

				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			
			//System.out.println("docList"+docList);
			return docList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Paras> getSubParabysubparaId(Integer subparaId) throws IRParasUserException {

		String sql = SELECT_SUB_PARA_BY_SUBPARAID;
		
		
		
		
 

		try {
			List<Paras> probjList =  jdbcTemplate6.query(sql, new Object[] { subparaId },
					new RowMapper<Paras>() {
						public Paras mapRow(ResultSet rs, int rowNum) throws SQLException {
							
							Paras pr = new Paras();
							
							pr.setParaId(rs.getInt(1));						
							pr.setParasAction(rs.getString(2));						
							pr.setParaStatusId(rs.getInt(3));
							pr.setParaStatus(rs.getString(4));	
						
							pr.setTransferFlag(rs.getBoolean(5));							
							pr.setSubParaId(rs.getInt(6));							
							pr.setSubcategory(rs.getString(7));
							pr.setParareasonsDelay(rs.getString(8));
						
						
						
						
					    return pr;

						}

					});
			return probjList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		// System.out.println("daoimpl canal list " + canalList);

	}
	
	
	
	@Override
	public Integer insertcagStatus(CAGParasData paraObj) throws IRParasUserException {
		// TODO Auto-generated method stub

    String sql1 =INSERT_INTO_CAG_STATUS;
    String sql=UPDATE_CAG_STATUS_OLD;
		
		Integer paraId = 0;
		
		Date date1=null;
		Date date2=null;
		
		Integer rows=0;
		Integer rows1=0;
		
		try {

			jdbcTemplate6.getDataSource().getConnection().setAutoCommit(false);
			
		

				if ( paraObj.getCagGistId()!=null && paraObj.getCagParaId()!=null && paraObj.getParaStatusId()!=null ) {
					
					//System.out.println("sql cagstatus"+sql);
					
			rows1 = jdbcTemplate6.update(sql,paraObj.getUserName(),paraObj.getCagParaId());
			
			//System.out.println("sql1 new cagstatus"+sql1);

				rows = jdbcTemplate6.update(sql1,paraObj.getCagParaId(),paraObj.getCagGistId(),paraObj.getRemarks(),paraObj.getUserName(),paraObj.getParaStatusId(),paraObj.getCunitId());
							
							
					}
					
			//	System.out.println("rows"+rows);			

                
				jdbcTemplate6.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	
	
	
	
	
}
