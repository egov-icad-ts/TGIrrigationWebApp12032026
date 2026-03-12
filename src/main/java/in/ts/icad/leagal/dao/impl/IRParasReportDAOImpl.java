package in.ts.icad.leagal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ts.icad.leagal.dao.IRParasReportDAO;
import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.model.CAGParas;
import in.ts.icad.leagal.model.CAGParasData;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.officeDataSend;

@Repository
public class IRParasReportDAOImpl implements IRParasReportDAO {
	
	private JdbcTemplate jdbcTemplate6;

	@Resource(name = "dataSource6")
	public void setDataSource(DataSource dataSource6) {
		this.jdbcTemplate6 = new JdbcTemplate(dataSource6);
	}
	
	private JdbcTemplate jdbcTemplate3;
	
	
	@Resource(name = "dataSource3")
	public void setDataSource3(DataSource dataSource3) {
		this.jdbcTemplate3 = new JdbcTemplate(dataSource3);
	}

	
	
	@Value("${SELECT_PARAS_ABSTRACT_COUNT}")
	private String SELECT_PARAS_ABSTRACT_COUNT;
	
	
	@Value("${TOTAL_PARAS}")
	private String TOTAL_PARAS;
	
	@Value("${TOTAL_PARAS_BYUNIT}")
	private String TOTAL_PARAS_BYUNIT;
	
	@Value("${REPLY_ALL}")
	private String REPLY_ALL;
	
	@Value("${DOCS_ALL_PARAS}")
	private String DOCS_ALL_PARAS;
	
	@Value("${TOTAL_PARAS_DETAIL}")
	private String TOTAL_PARAS_DETAIL;
	
	@Value("${SELECT_PARAS_ABSTRACT_OFFICE}")
	private String SELECT_PARAS_ABSTRACT_OFFICE;
	
	
	
	@Value("${SELECT_PARAS_ABSTRACT_UNIT}")
	private String SELECT_PARAS_ABSTRACT_UNIT;
	
	@Value("${SELECT_PARAS_ABSTRACT_CIRCLE}")
	private String SELECT_PARAS_ABSTRACT_CIRCLE;
	
	@Value("${SELECT_PARAS_ABSTRACT_DIVISION}")
	private String SELECT_PARAS_ABSTRACT_DIVISION;
	
	@Value("${SELECT_PARAS_ABSTRACT_SUBDIVISION}")
	private String SELECT_PARAS_ABSTRACT_SUBDIVISION;
	
	@Value("${SELECT_PARAS_ABSTRACT_CIRCLE_TOT}")
	private String SELECT_PARAS_ABSTRACT_CIRCLE_TOT;
	
	
	@Value("${SELECT_PARAS_ABSTRACT_UNIT_TOTAL}")
	private String SELECT_PARAS_ABSTRACT_UNIT_TOTAL;
	
	
	@Value("${SELECT_WITHOUT_CIRCLE_DIVISION}")
	private String SELECT_WITHOUT_CIRCLE_DIVISION;
	
	@Value("${GET_REPLY_BY_PARA_ID}")
	private String GET_REPLY_BY_PARA_ID;
	
	@Value("${GET_ALL_DOCS}")
	private String GET_ALL_DOCS;
	
	
	@Value("${TOTAL_PARAS_DETAIL_PDF}")
	private String TOTAL_PARAS_DETAIL_PDF;
	
	
	@Value("${SELECT_CAG_ABSTRACT_COUNT}")
	private String SELECT_CAG_ABSTRACT_COUNT;
	
	@Value("${SELECT_CAG_ABSTRACT_UNIT}")
	private String SELECT_CAG_ABSTRACT_UNIT;
	
	@Value("${SELECT_CAG_ABSTRACT_CIRCLE}")
	private String SELECT_CAG_ABSTRACT_CIRCLE;
	
	@Value("${SELECT_CAG_ABSTRACT_DIVISION}")
	private String SELECT_CAG_ABSTRACT_DIVISION;
	
	@Value("${SELECT_CAG_WITHOUT_CIRCLE_DIVISION}")
	private String SELECT_CAG_WITHOUT_CIRCLE_DIVISION;
	
	@Value("${SELECT_CAG_ABSTRACT_SUBDIVISION}")
	private String SELECT_CAG_ABSTRACT_SUBDIVISION;
	
	@Value("${SELECT_CAG_ABSTRACT_CIRCLE_TOT}")
	private String SELECT_CAG_ABSTRACT_CIRCLE_TOT;
	
	@Value("${SELECT_CAG_ABSTRACT_UNIT_TOTAL}")
	private String SELECT_CAG_ABSTRACT_UNIT_TOTAL;
	
	@Value("${TOTAL_CAG_PARAS}")
	private String TOTAL_CAG_PARAS;
	
	@Value("${TOTAL_CAG_PARAS_BYUNIT}")
	private String TOTAL_CAG_PARAS_BYUNIT;
	
	
	@Value("${TOTAL_CAG_BYUNIT}")
	private String TOTAL_CAG_BYUNIT;
	
	
	@Value("${GET_CAG_PARAS_SUBPARAID}")
	private String GET_CAG_PARAS_SUBPARAID;
	
	@Value("${GET_CAG_REPLYS_PARAID}")
	private String GET_CAG_REPLYS_PARAID;
	
	@Value("${TOTAL_CAG_PARAS_DETAIL}")
	private String TOTAL_CAG_PARAS_DETAIL;
	
	
	@Value("${GET_CAG_PARAS_TOTAL_DETAIL}")
	private String GET_CAG_PARAS_TOTAL_DETAIL;
	
	@Value("${GET_CAG_REPLYS_ALL}")
	private String GET_CAG_REPLYS_ALL;
	
	
	@Value("${TOTAL_CAGPARAS_DTAIL_PDF}")
	private String TOTAL_CAGPARAS_DTAIL_PDF;
	
	@Value("${GET_CAG_REPLYS_GISTID}")
	private String GET_CAG_REPLYS_GISTID;
	
	@Value("${GET_CAG_PARAS_PARAID}")
	private String GET_CAG_PARAS_PARAID;
	
	@Value("${CAG_DOCS_ALL_PARAS}")
	private String CAG_DOCS_ALL_PARAS;
	
	@Value("${CAG_PARAS_DTAIL_PDF_NEW_GIST}")
	private String CAG_PARAS_DTAIL_PDF_NEW_GIST;
	
	
	
	@Value("${REPLY_ALL_WITH_ALL_REPLY}")
	private String REPLY_ALL_WITH_ALL_REPLY;
	
	
	@Value("${SELECT_PARAS_ABSTRACT_CIRCLE_BYCIRCLETOT}")
	private String SELECT_PARAS_ABSTRACT_CIRCLE_BYCIRCLETOT;
	
	@Value("${SELECT_PARAS_ABSTRACT_DIVISION_BYDIVISION}")
	private String SELECT_PARAS_ABSTRACT_DIVISION_BYDIVISION;
	
	@Value("${TOTAL_PARAS_BYUNIT_transfer}")
	private String TOTAL_PARAS_BYUNIT_transfer;
	
	@Value("${SELECT_OFF_USER_DATA_BY_UNIT_ID}")
	private String SELECT_OFF_USER_DATA_BY_UNIT_ID;
	
	@Value("${SELECT_UNIT_OFFICE_EMAILID}")
	private String SELECT_UNIT_OFFICE_EMAILID;
	
	@Value("${SELECT_CIRCLE_OFFICE_EMAILID}")
	private String SELECT_CIRCLE_OFFICE_EMAILID;
	
	@Value("${SELECT_DIVISION_OFFICE_EMAILID}")
	private String SELECT_DIVISION_OFFICE_EMAILID;
	
	@Value("${TOTAL_PARAS_transfer}")
	private String TOTAL_PARAS_transfer;
	
	
	@Value("${TOTAL_PARAS_BYUNIT_PDF}")
	private String TOTAL_PARAS_BYUNIT_PDF;
	
	@Value("${TOTAL_PARAS_BYUNIT_transfer_PDF}")
	private String TOTAL_PARAS_BYUNIT_transfer_PDF;
	
	@Value("${TOTAL_PARAS_DOC_PDF}")
	private String TOTAL_PARAS_DOC_PDF;
	
	@Value("${TOTAL_PARAS_transfer_DOC_PDF}")
	private String TOTAL_PARAS_transfer_DOC_PDF;
	
	@Value("${REPLY_ALL_BY_OFFICE}")
	private String REPLY_ALL_BY_OFFICE;
	
	
	@Value("${DOCS_ALL_PARAS_BY_OFFICE}")
	private String DOCS_ALL_PARAS_BY_OFFICE;
	
	@Value("${SELECT_CAG_ABSTRACT_COUNT_BYUNIT}")
	private String SELECT_CAG_ABSTRACT_COUNT_BYUNIT;
	
	
	@Value("${TOTAL_CAG_PARAS_BYOFFICE}")
	private String TOTAL_CAG_PARAS_BYOFFICE;
	
	@Value("${GET_CAG_REPLYS_GISTID_BYUNIT}")
	private String GET_CAG_REPLYS_GISTID_BYUNIT;
	
	
	@Value("${CAG_DOCS_UNIT_PARAS}")
	private String CAG_DOCS_UNIT_PARAS;
	
	
	@Value("${SELECT_CAG_ABSTRACT_BYFIN_UNIT}")
	private String SELECT_CAG_ABSTRACT_BYFIN_UNIT;
	
	@Value("${SELECT_CAG_REPORT_YEAR}")
	private String SELECT_CAG_REPORT_YEAR;
	
	
	@Value("${SELECT_CAG_UNIT_WISE}")
	private String SELECT_CAG_UNIT_WISE;
	
	
	@Value("${GET_CAG_REPLYS_FY}")
	private String GET_CAG_REPLYS_FY;
	
	@Value("${GET_CAG_REPLYS_FY_BYUNIT}")
	private String GET_CAG_REPLYS_FY_BYUNIT;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Value("${TOTAL_PARAS_DETAIL_BYUNIT}")
	private String TOTAL_PARAS_DETAIL_BYUNIT;
	
	@Value("${TOTAL_PARAS_DETAIL_BYCIRCLE}")
	private String TOTAL_PARAS_DETAIL_BYCIRCLE;
	
	@Value("${TOTAL_PARAS_DETAIL_BYDIVISION}")
	private String TOTAL_PARAS_DETAIL_BYDIVISION;*/
	
	
	
	
	
	
	
	@Override
	public List<Paras> getParasAbstarctCount(Paras paraObj ) throws IRParasUserException {
		
		
		String sql= SELECT_PARAS_ABSTRACT_COUNT;
		String newsq1 = null ;
		
		
		if(paraObj!=null){
			
			//System.out.println("paraObj.getUnitId()"+paraObj.getUnitId());
			//System.out.println("paraObj.getCircleId()"+paraObj.getCircleId());
			//System.out.println("paraObj.getDivisionId()"+paraObj.getDivisionId());
			//System.out.println("paraObj.getSubdivisionId()"+paraObj.getSubdivisionId());
			
			if (paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null){
				
				//System.out.println("1"+paraObj.getUnitId());
				
				if((paraObj.getUnitId()==4 && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 &&  paraObj.getSubdivisionId()==0) || 
				    (paraObj.getUnitId()==9832 && paraObj.getCircleId()==21614 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0) || 
				    (paraObj.getUnitId()==4 && paraObj.getCircleId()==104 && paraObj.getDivisionId()==30327 && paraObj.getSubdivisionId()==0)){
					
				
					
					
				
				/*if( paraObj.getUnitId()>0  && paraObj.getCircleId().equals(0)  && paraObj.getDivisionId().equals(0)  && paraObj.getSubdivisionId().equals(0) ){*/
					
					
					
					
						
					newsq1= sql  + " order by unit_code,totalparas, balance " ;
					
				//	System.out.println("newsq1 i am herer"+newsq1);
					/*	}*/
					
				}
				if(!((paraObj.getUnitId()==4 && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 &&  paraObj.getSubdivisionId()==0) || 
					    (paraObj.getUnitId()==9832 && paraObj.getCircleId()==21614 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0) || 
					    (paraObj.getUnitId()==4 && paraObj.getCircleId()==104 && paraObj.getDivisionId()==30327 && paraObj.getSubdivisionId()==0))){
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
			
					newsq1=sql +" WHERE ptirpm.unit_id="+paraObj.getUnitId() +"  order by unit_code,totalparas,balance" ;
				}
				
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
					newsq1=SELECT_PARAS_ABSTRACT_CIRCLE_BYCIRCLETOT +" WHERE ptirpm.unit_id="+paraObj.getUnitId() + " and  ptirpm.circle_id="+paraObj.getCircleId()+"  order by unit_code,totalparas,balance" ;
				}
				
                if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId()>0 && paraObj.getSubdivisionId()==0){
					
					newsq1=SELECT_PARAS_ABSTRACT_DIVISION_BYDIVISION  +" WHERE ptirpm.unit_id="+paraObj.getUnitId() +"  and  ptirpm.circle_id="+paraObj.getCircleId()+" and  ptirpm.division_id="+paraObj.getDivisionId()+"   order by unit_code,totalparas,balance" ;
				}
			}
			}
		}
		
	//	System.out.println("newsq12"+newsq1);
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query( newsq1 , new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					
					//System.out.println("rs.getInt(1)"+rs.getInt(1));
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
			
				pr.setTotalParas(rs.getInt(5));
				
				pr.setSecAParasCount(rs.getInt(6));
				pr.setSecBParasCount(rs.getInt(7));
				pr.setBalanceParas(rs.getInt(8));
				
				
				
				pr.setReplySent(rs.getInt(9));
				pr.setReplyNotSent(rs.getInt(10));
				pr.setTransfrred(rs.getInt(11));
				pr.setDroppedCount(rs.getInt(12));
				
				pr.setUnitCode(rs.getString(13));
				pr.setCircleName(rs.getString(14));
				pr.setDivisionName(rs.getString(15));
				pr.setSubdivisionName(rs.getString(16));
				pr.setUnitName(rs.getString(17));
				
				
				
				
				
			    return pr;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			
			//System.out.println("prList"+prList);
			return prList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Paras> getParasTotal(Integer sectionId,Integer paraStatusId , Boolean trFlag) throws IRParasUserException {
		String sql = null;
		
		if(sectionId==0 && paraStatusId ==0 && trFlag==false  ){
				
			sql=TOTAL_PARAS +"  and transfer_flag=false  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
		}
		if(sectionId!=0 && paraStatusId ==0 && trFlag==false ){
			
			sql=TOTAL_PARAS +"  and transfer_flag=false  and irpm.section_id="+sectionId+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			
		}
		
         if(sectionId==0 && paraStatusId !=0  && trFlag==false){
        	 
        	 if(paraStatusId==1 || paraStatusId==2 ||paraStatusId==3){
			
			sql=TOTAL_PARAS +" and transfer_flag=false  and  irpm.paras_status_id="+paraStatusId+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
        	 }
        	 
        	 if(paraStatusId==8){
        		
     			
     			sql=TOTAL_PARAS +"  and  irpm.paras_status_id in (1,2) and transfer_flag=false   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
             	 }
        	
		}
         
         if(sectionId==0 && paraStatusId ==0 && trFlag==true ){
        	 
        		
 			
 			sql=TOTAL_PARAS_transfer +" and transfer_flag=true   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
 			
 		}
         
         
         
      // System.out.println("sqlin parastotal"+sql);
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql , new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
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
					
					pr.setSectionA(rs.getString(13));
					pr.setSectionB(rs.getString(14));
					pr.setPrintCagStatus(rs.getString(15));
					pr.setCategoryId(rs.getString(16));
					pr.setParaNumber(rs.getString(17));
					pr.setAuditDateFrom(rs.getString(18));
					pr.setAuditDateTo(rs.getString(19));
					pr.setFileNumber(rs.getString(20));
					pr.setLarNumber(rs.getString(21));
					pr.setParaNumsectionA(rs.getString(22));
					pr.setParaNumsectionB(rs.getString(23));
					pr.setTransferFlag(rs.getBoolean(24));
					pr.setOldParaId(rs.getInt(25));
					pr.setUnitName(rs.getString(26));
					pr.setCircleName(rs.getString(27));
					pr.setDivisionName(rs.getString(28));
				
				
				
				
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
	public List<Paras> getParasTotalDOCPDF(Integer sectionId,Integer paraStatusId , Boolean trFlag) throws IRParasUserException {
		String sql = null;
		
		if(sectionId==0 && paraStatusId ==0 && trFlag==false  ){
				
			sql=TOTAL_PARAS_DOC_PDF +"  and transfer_flag=false  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
		}
		if(sectionId!=0 && paraStatusId ==0 && trFlag==false ){
			
			sql=TOTAL_PARAS_DOC_PDF +"  and transfer_flag=false  and irpm.section_id="+sectionId+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			
		}
		
         if(sectionId==0 && paraStatusId !=0  && trFlag==false){
        	 
        	 if(paraStatusId==1 || paraStatusId==2 ||paraStatusId==3){
			
			sql=TOTAL_PARAS_DOC_PDF +" and transfer_flag=false  and  irpm.paras_status_id="+paraStatusId+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
        	 }
        	 
        	 if(paraStatusId==8){
        		
     			
     			sql=TOTAL_PARAS_DOC_PDF +"  and  irpm.paras_status_id in (1,2) and transfer_flag=false   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
             	 }
        	
		}
         
         if(sectionId==0 && paraStatusId ==0 && trFlag==true ){
        	 
        		
 			
 			sql=TOTAL_PARAS_transfer_DOC_PDF +" and transfer_flag=true   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
 			
 		}
         
         
         
       //System.out.println("sqlin parasdoc pdf"+sql);
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql , new RowMapper<Paras>() {
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
	public List<Paras> getParasByUnit( Paras paraObj ) throws IRParasUserException {
		
		String sql=null;
		
		
	//	System.out.println("dao impl"+paraObj.getUnitId());
	//	System.out.println("dao impl"+paraObj.getCircleId());
	////	System.out.println("dao impl"+paraObj.getDivisionId());
	//	System.out.println("dao impl"+paraObj.getSubdivisionId());
	//	System.out.println("dao impl"+paraObj.getParaStatusId());
	//	System.out.println("dao impl"+paraObj.getSectionId());
	//	System.out.println("dao impl"+paraObj.getTransferFlag());

		
		
		//Integer unitId,Integer sectionId, Integer paraStatusId,Boolean trFlag
		
		//System.out.println(unitId+","+sectionId+","+paraStatusId+","+trFlag);
		
		if(paraObj.getUnitId()!=null &&paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null  && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==false){
	     
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0 ){
			sql = TOTAL_PARAS_BYUNIT +"  and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			
			}
			
			if(paraObj.getUnitId() >0  && paraObj.getCircleId()>0 && paraObj.getDivisionId()==-2 && paraObj.getSubdivisionId()==-2 ){
				sql = TOTAL_PARAS_BYUNIT +" and irpm.circle_id="+paraObj.getCircleId()+"   and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
				}
			
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()>0 && paraObj.getSubdivisionId()==0 ){
				sql = TOTAL_PARAS_BYUNIT +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id="+paraObj.getDivisionId()+" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
				}
		
		}
		if(paraObj.getUnitId()!=null &&paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null && paraObj.getSectionId()!=0 && paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==false){
			
		//	System.out.println("i must be here"+unitId+","+sectionId+","+paraStatusId+","+trFlag);
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0 ){
			 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false  and irpm.delete_flag=false and irpm.is_latest=true  and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			}
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()==-2 && paraObj.getSubdivisionId()==-2 ){
				 sql = TOTAL_PARAS_BYUNIT +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				}
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()>0 && paraObj.getSubdivisionId()==0 ){
				 sql = TOTAL_PARAS_BYUNIT +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id="+paraObj.getDivisionId()+" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				}
		}
		
		if(paraObj.getUnitId()!=null &&paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null && paraObj.getSectionId()==0 && paraObj.getParaStatusId()!=0 && paraObj.getTransferFlag()==false){
			
			 if(paraObj.getParaStatusId()==1 || paraObj.getParaStatusId()==2 ||paraObj.getParaStatusId()==3){
				 
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0 ){
			
			 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and  irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					}
					
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()==-2 && paraObj.getSubdivisionId()==-2 ){
						
						 sql = TOTAL_PARAS_BYUNIT +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and  irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
								}
					
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()>0 && paraObj.getSubdivisionId()==0 ){
						
						 sql = TOTAL_PARAS_BYUNIT +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id="+paraObj.getDivisionId()+" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and  irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
								}
			 }
					
			 
			 if(paraObj.getParaStatusId()==8){
				 
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0 ){
				 
				
					
				 sql = TOTAL_PARAS_BYUNIT +" and  irpm.paras_status_id in (1,2) and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				 
					}
					
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()==-2 && paraObj.getSubdivisionId()==-2 ){
						 
						
						
						 sql = TOTAL_PARAS_BYUNIT +" and irpm.circle_id="+paraObj.getCircleId()+" and  irpm.paras_status_id in (1,2) and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						 
							}
					
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()>0 && paraObj.getSubdivisionId()==0 ){
						 
						
						
						 sql = TOTAL_PARAS_BYUNIT +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id="+paraObj.getDivisionId()+"  and  irpm.paras_status_id in (1,2) and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						 
							}
				 }
			 
			
		}
		
		if(paraObj.getUnitId()!=null &&paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==true){
			
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0 ){
			
			 sql = TOTAL_PARAS_BYUNIT_transfer +" and irpm.transfer_flag=true and irpm.delete_flag=true and irpm.is_latest=false  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			 
			}
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()==-2 && paraObj.getSubdivisionId()==-2 ){
				
				 sql = TOTAL_PARAS_BYUNIT_transfer +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.transfer_flag=true and irpm.delete_flag=true and irpm.is_latest=false  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				 
				}
			
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId() >0 && paraObj.getSubdivisionId()==0 ){
				
				 sql = TOTAL_PARAS_BYUNIT_transfer +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id="+paraObj.getDivisionId()+" and irpm.transfer_flag=true and  irpm.delete_flag=true and irpm.is_latest=false   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				 
				}
			
		}
		
		
		
		
		//System.out.println("sqlnew"+sql);
		
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId() }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
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
					pr.setTransferFlag(rs.getBoolean(24));
					pr.setTunitId(rs.getInt(25));
					pr.setTcircleId(rs.getInt(26));
					pr.setTdivisionId(rs.getInt(27));
					pr.setTsubdivisionId(rs.getInt(28));
					pr.setOldParaId(rs.getInt(29));
					pr.setTrfromUnit(rs.getString(30));
					pr.setTrfromCircle(rs.getString(31));
					pr.setTrfromDivision(rs.getString(32));
				
				
				
				
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
	public List<Paras> getParasByUnitDOCPDF( Paras paraObj ) throws IRParasUserException {
		
		String sql=null;
		
		
	//	System.out.println("dao impl"+paraObj.getUnitId());
	//	System.out.println("dao impl"+paraObj.getCircleId());
	////	System.out.println("dao impl"+paraObj.getDivisionId());
	//	System.out.println("dao impl"+paraObj.getSubdivisionId());
	//	System.out.println("dao impl"+paraObj.getParaStatusId());
	//	System.out.println("dao impl"+paraObj.getSectionId());
	//	System.out.println("dao impl"+paraObj.getTransferFlag());

		
		
		//Integer unitId,Integer sectionId, Integer paraStatusId,Boolean trFlag
		
		//System.out.println(unitId+","+sectionId+","+paraStatusId+","+trFlag);
		
		if(paraObj.getUnitId()!=null &&paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null  && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==false){
	     
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0 ){
			sql = TOTAL_PARAS_BYUNIT_PDF +"  and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			
			}
			
			if(paraObj.getUnitId() >0  && paraObj.getCircleId()>0 && paraObj.getDivisionId()==-2 && paraObj.getSubdivisionId()==-2 ){
				sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.circle_id="+paraObj.getCircleId()+"   and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
				}
			
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()>0 && paraObj.getSubdivisionId()==0 ){
				sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id="+paraObj.getDivisionId()+" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
				}
		
		}
		if(paraObj.getUnitId()!=null &&paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null && paraObj.getSectionId()!=0 && paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==false){
			
		//	System.out.println("i must be here"+unitId+","+sectionId+","+paraStatusId+","+trFlag);
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0 ){
			 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false  and irpm.delete_flag=false and irpm.is_latest=true  and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			}
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()==-2 && paraObj.getSubdivisionId()==-2 ){
				 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				}
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()>0 && paraObj.getSubdivisionId()==0 ){
				 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id="+paraObj.getDivisionId()+" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				}
		}
		
		if(paraObj.getUnitId()!=null &&paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null && paraObj.getSectionId()==0 && paraObj.getParaStatusId()!=0 && paraObj.getTransferFlag()==false){
			
			 if(paraObj.getParaStatusId()==1 || paraObj.getParaStatusId()==2 ||paraObj.getParaStatusId()==3){
				 
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0 ){
			
			 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and  irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					}
					
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()==-2 && paraObj.getSubdivisionId()==-2 ){
						
						 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and  irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
								}
					
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()>0 && paraObj.getSubdivisionId()==0 ){
						
						 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id="+paraObj.getDivisionId()+" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and  irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
								}
			 }
					
			 
			 if(paraObj.getParaStatusId()==8){
				 
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0 ){
				 
				
					
				 sql = TOTAL_PARAS_BYUNIT_PDF +" and  irpm.paras_status_id in (1,2) and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				 
					}
					
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()==-2 && paraObj.getSubdivisionId()==-2 ){
						 
						
						
						 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.circle_id="+paraObj.getCircleId()+" and  irpm.paras_status_id in (1,2) and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						 
							}
					
					if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()>0 && paraObj.getSubdivisionId()==0 ){
						 
						
						
						 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id="+paraObj.getDivisionId()+"  and  irpm.paras_status_id in (1,2) and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						 
							}
				 }
			 
			
		}
		
		if(paraObj.getUnitId()!=null &&paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==true){
			
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0 ){
			
			 sql = TOTAL_PARAS_BYUNIT_transfer_PDF +" and irpm.transfer_flag=true and irpm.delete_flag=true and irpm.is_latest=false  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			 
			}
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId()==-2 && paraObj.getSubdivisionId()==-2 ){
				
				 sql = TOTAL_PARAS_BYUNIT_transfer_PDF +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.transfer_flag=true and irpm.delete_flag=true and irpm.is_latest=false  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				 
				}
			
			if(paraObj.getUnitId() >0  &&paraObj.getCircleId()>0 && paraObj.getDivisionId() >0 && paraObj.getSubdivisionId()==0 ){
				
				 sql = TOTAL_PARAS_BYUNIT_transfer_PDF +" and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id="+paraObj.getDivisionId()+" and irpm.transfer_flag=true and  irpm.delete_flag=true and irpm.is_latest=false   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				 
				}
			
		}
		
		
		
		
		//System.out.println("sqlPDFnew"+sql);
		
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId() }, new RowMapper<Paras>() {
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
					pr.setSectionId(rs.getInt(15));
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
	public List<ReplyData> getReplyAll( ) throws IRParasUserException {
		String sql = REPLY_ALL;
		
		
		
	
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
	public List<ReplyData> getReplyAllbyOffice(Paras paraObj) throws IRParasUserException {
		String sql = REPLY_ALL_BY_OFFICE;
		
		
		
	
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId(),paraObj.getCircleId(),paraObj.getDivisionId() }, new RowMapper<ReplyData>() {
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
	public List<ParaDocuments> getDocsAll( ) throws IRParasUserException {
		String sql = DOCS_ALL_PARAS;
		
		
		
	
		try {
			List<ParaDocuments> docList = jdbcTemplate6.query(sql , new RowMapper<ParaDocuments>() {
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
			return docList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<ParaDocuments> getDocsAllByOffice(Paras paraObj) throws IRParasUserException {
		String sql = DOCS_ALL_PARAS_BY_OFFICE;
		
		
		
	
		try {
			List<ParaDocuments> docList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId(),paraObj.getCircleId(),paraObj.getDivisionId() }, new RowMapper<ParaDocuments>() {
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
			return docList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
     
	
	@Override
	public List<Paras> getParasByOffice( Integer unitId,Integer circleId, Integer divisionId ) throws IRParasUserException {
		
		
		String sql = null;
		
		if(unitId==null && (circleId==null||circleId==0 ) && (divisionId==null || divisionId==0) ){
			
			sql=TOTAL_PARAS_DETAIL+" order by para_id";
			
		}
		if(unitId!=null && ( circleId==null || circleId==0 ) && (divisionId==null || divisionId==0 )){
		sql=TOTAL_PARAS_DETAIL+" and irpm.unit_id="+unitId+" and (coalesce( irpm.circle_id,0)=0) and (coalesce(irpm.division_id,0)=0) order by para_id";
		
		}
		
		if((unitId!=null && unitId>0 ) && (circleId!=null && circleId>0 ) && ( divisionId==null || divisionId==0 )){
		sql=TOTAL_PARAS_DETAIL+" and irpm.circle_id= "+circleId+" and (coalesce(irpm.division_id,0)=0) order by para_id " ;
		
		}
		
		if((unitId!=null && unitId > 0  ) && (circleId!=null && circleId > 0 ) && ( divisionId!=null && divisionId>0 )){
		sql=TOTAL_PARAS_DETAIL+" and irpm.division_id= "+divisionId+" order by para_id";
		}
				
				
		//System.out.println("getParasByOffice"+sql);		
				
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql , new RowMapper<Paras>() {
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
					pr.setOldParaId(rs.getInt(25));
					pr.setTrfromUnit(rs.getString(26));
					pr.setTrfromCircle(rs.getString(27));
					pr.setTrfromDivision(rs.getString(28));
				
				
				
				
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
	public List<Paras> getParasAbstarctCountByoffice( ) throws IRParasUserException {
		String sql = SELECT_PARAS_ABSTRACT_OFFICE;
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql , new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				pr.setSecAParasCount(rs.getInt(6));
				pr.setSecBParasCount(rs.getInt(7));
				pr.setBalanceParas(rs.getInt(8));
				
				
				
				pr.setReplySent(rs.getInt(9));
				pr.setReplyNotSent(rs.getInt(10));
				pr.setTransfrred(rs.getInt(11));
				pr.setDroppedCount(rs.getInt(12));
				pr.setUnitCode(rs.getString(13));
				pr.setCircleName(rs.getString(14));
				pr.setDivisionName(rs.getString(15));
				pr.setSubdivisionName(rs.getString(16));
				pr.setUnitName(rs.getString(17));
				
				
				
				
				
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
	public List<Paras> getParasAbstractTotal(Integer sectionId,Integer paraStatusId ) throws IRParasUserException {
		String sql = null;
		
		if(sectionId==null && paraStatusId ==null  ){
				
			sql=TOTAL_PARAS +" order by division_name,irpm.section_id,irpm.financial_year";
				
		}
		if(sectionId!=null && paraStatusId ==null ){
			
			sql=TOTAL_PARAS +" and irpm.section_id="+sectionId+" order by division_name,irpm.section_id,irpm.financial_year";
			
		}
		
         if(sectionId==null && paraStatusId !=null ){
        	 
        	 if(paraStatusId==1 || paraStatusId==2 ||paraStatusId==3){
			
			sql=TOTAL_PARAS +" and  irpm.paras_status_id="+paraStatusId+" order by division_name,irpm.section_id,irpm.financial_year";
        	 }
        	 if(paraStatusId==4){
     			
     			sql=TOTAL_PARAS +" and irpm.paras_status_id in (4,5,6) order by division_name,irpm.section_id,irpm.financial_year";
             	 }
        	 
        	 if(paraStatusId==8){
        		 
            	 sql=TOTAL_PARAS +" and  irpm.paras_status_id not in (3,4,5,6) order by division_name,irpm.section_id,irpm.financial_year";
              
            	 }
		}
         
       
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql , new RowMapper<Paras>() {
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
	public List<Paras> getParasAbstractByUnit( Paras paraObj ) throws IRParasUserException {
		
		
		
		String sql=null;
		
	 //System.out.println("dai impl getParasAbstractByUnit"+paraObj.getUnitId());
	 //System.out.println("dai impl getParasAbstractByUnit"+paraObj.getCircleId());
	 //System.out.println("dai impl getParasAbstractByUnit"+paraObj.getDivisionId());
	 //System.out.println("dai impl getParasAbstractByUnit"+paraObj.getSectionId());
	 //System.out.println("dai impl getParasAbstractByUnit"+paraObj.getParaStatusId());
	 //System.out.println("dai paraObj.getUnitTotal()"+paraObj.getUnitTotal());
	// System.out.println("dai impl paraObj.getCircleTotal"+paraObj.getCircleTotal());
	// System.out.println("dai impl getParasAbstractByUnit"+paraObj.getTransferFlag());
		
		
		if(paraObj.getUnitId()!=null && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("false") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false){
		      sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and (irpm.circle_id=0 or irpm.circle_id is null) and (irpm.division_id=0 or  irpm.division_id is null)  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			
			}
		if(paraObj.getUnitId()!=null && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("false") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==true){
		      sql = TOTAL_PARAS_BYUNIT_transfer +" and irpm.transfer_flag=true  and irpm.delete_flag=true and irpm.is_latest=false and (irpm.circle_id=0 or irpm.circle_id is null) and (irpm.division_id=0 or  irpm.division_id is null)  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			
			}
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSectionId()>0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("false") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false){
				
				 sql = TOTAL_PARAS_BYUNIT +" and  irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and (irpm.circle_id=0 or irpm.circle_id is null) and (irpm.division_id=0 or  irpm.division_id is null) and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
			}
			
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()>9 && paraObj.getUnitTotal().equals("false") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false){
				
				// System.out.println("coming"+paraStatusId);
				 if(paraObj.getParaStatusId()==1 || paraObj.getParaStatusId()==2 ||paraObj.getParaStatusId()==3){
				
				 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and (irpm.circle_id=0 or irpm.circle_id is null) and (irpm.division_id=0 or  irpm.division_id is null) and irpm.section_id in (1,2) and   irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				 }
				 
				
		        	 if(paraObj.getParaStatusId()==8){
		        		// System.out.println(paraStatusId);
		        		 
		            	 sql=TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and (irpm.circle_id=0 or irpm.circle_id is null) and (irpm.division_id=0 or  irpm.division_id is null)  and irpm.section_id in (1,2) and  irpm.paras_status_id in (1,2) order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
		              
		            	 }
			}
			
			if(paraObj.getUnitId()!=null && (paraObj.getCircleId()==-1||paraObj.getCircleId()==0) && (paraObj.getDivisionId()==-1||paraObj.getDivisionId()==0) && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("true") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false){
			      sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
				}
			if(paraObj.getUnitId()!=null && (paraObj.getCircleId()==-1||paraObj.getCircleId()==0) && (paraObj.getDivisionId()==-1||paraObj.getDivisionId()==0) && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("true")&& paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==true){
			      sql = TOTAL_PARAS_BYUNIT_transfer +" and irpm.transfer_flag=true and irpm.delete_flag=true and irpm.is_latest=false order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
				}
				if(paraObj.getUnitId()!=null &&(paraObj.getCircleId()==-1||paraObj.getCircleId()==0) && (paraObj.getDivisionId()==-1||paraObj.getDivisionId()==0) && paraObj.getSectionId()>0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("true") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false){
					
					 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					
				}
				
				if(paraObj.getUnitId()!=null && (paraObj.getCircleId()==-1||paraObj.getCircleId()==0) && (paraObj.getDivisionId()==-1||paraObj.getDivisionId()==0) && paraObj.getSectionId()==0 && paraObj.getParaStatusId()>0 && paraObj.getUnitTotal().equals("true") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false ){
					
					 if(paraObj.getParaStatusId()==1 || paraObj.getParaStatusId()==2 ||paraObj.getParaStatusId()==3){
					
					 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.section_id in (1,2) and   irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					 }
					 
					 
			        	 
			        	 if(paraObj.getParaStatusId()==8){
			        		 
			            	 sql=TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.section_id in (1,2) and  irpm.paras_status_id in (1,2) order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			              
			            	 }
				}
			
			
				// start of circle office data
				if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId() ==-1 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
				      sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and (irpm.division_id=0 or  irpm.division_id is null)  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					
					}
				
				if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()==-1 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==true){
				      sql = TOTAL_PARAS_BYUNIT_transfer +" and irpm.transfer_flag=true  and irpm.delete_flag=true and irpm.is_latest=false  and irpm.circle_id="+paraObj.getCircleId()+" and (irpm.division_id=0 or  irpm.division_id is null)  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					
					}
					if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null  && paraObj.getDivisionId()==-1 && paraObj.getSectionId()>0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
						
						 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false  and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and (irpm.division_id=0 or  irpm.division_id is null) and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
					}
					
					if(paraObj.getUnitId()!=null  &&  paraObj.getCircleId()!=null && paraObj.getDivisionId()==-1 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()!=null && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
						
						 if(paraObj.getParaStatusId()==1 || paraObj.getParaStatusId()==2 ||paraObj.getParaStatusId()==3){
						
						 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and irpm.circle_id="+paraObj.getCircleId()+" and (irpm.division_id=0 or  irpm.division_id is null) and irpm.section_id in (1,2) and   irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						 }
						 
						
				        	 
				        	 if(paraObj.getParaStatusId()==8){
				        		 
				            	 sql=TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false  and irpm.delete_flag=false and irpm.is_latest=true  and irpm.circle_id="+paraObj.getCircleId()+" and (irpm.division_id=0 or  irpm.division_id is null)  and irpm.section_id in (1,2) and  irpm.paras_status_id in (1,2) order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				              
				            	 }
					}
					
					
					// end of circle office paras
					
					// start of circle total
					
					if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null &&  paraObj.getDivisionId()==-2 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("true") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
					      sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false  and irpm.delete_flag=false and irpm.is_latest=true   and irpm.circle_id="+paraObj.getCircleId()+"   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
						}
					
					if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null &&  paraObj.getDivisionId()==-2 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("true") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==true){
					      sql = TOTAL_PARAS_BYUNIT_transfer +" and irpm.transfer_flag=true  and irpm.delete_flag=true and irpm.is_latest=false and irpm.circle_id="+paraObj.getCircleId()+"   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
						}
						if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null  &&  paraObj.getDivisionId()==-2 && paraObj.getSectionId()>0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("true") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
							
							 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+"  and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
							
						}
						
						if(paraObj.getUnitId()!=null  && paraObj.getCircleId()!=null &&  paraObj.getDivisionId()==-2 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()!=null && paraObj.getCircleTotal().equals("true") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
							
							 if( paraObj.getParaStatusId()==1 ||  paraObj.getParaStatusId()==2 || paraObj.getParaStatusId()==3){
							
							 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+"  and irpm.section_id in (1,2) and   irpm.paras_status_id="+ paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
							 }
							 
							
					        	 
					        	 if( paraObj.getParaStatusId()==8){
					        		 
					            	 sql=TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and irpm.circle_id="+paraObj.getCircleId()+"   and irpm.section_id in (1,2) and  irpm.paras_status_id in (1,2) order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					              
					            	 }
						}
					
					
					if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()>0 && paraObj.getSectionId()==0 &&  paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==false && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false")){
					      sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id= "+paraObj.getDivisionId()+"  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
						}
					
					if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()>0 &&  paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==true && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false")){
					      sql = TOTAL_PARAS_BYUNIT_transfer +" and irpm.transfer_flag=true and irpm.delete_flag=true and irpm.is_latest=false and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id= "+paraObj.getDivisionId()+"  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
						}
						if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()>0 &&  paraObj.getSectionId()>0 &&  paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==false && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false")){
							
							 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id= "+paraObj.getDivisionId()+" and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
							
						}
						
						if(paraObj.getUnitId()!=null  && paraObj.getCircleId()!=null && paraObj.getDivisionId()>0 &&  paraObj.getSectionId()==0 &&  paraObj.getParaStatusId()!=null && paraObj.getTransferFlag()==false && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false")){
							
							 if( paraObj.getParaStatusId()==1 ||  paraObj.getParaStatusId()==2 || paraObj.getParaStatusId()==3){
							
							 sql = TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id= "+ paraObj.getDivisionId()+" and irpm.section_id in (1,2) and   irpm.paras_status_id="+ paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
							 }
							 
							 
					        	 
					        	 if( paraObj.getParaStatusId()==8){
					        		 
					            	 sql=TOTAL_PARAS_BYUNIT +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id= "+paraObj.getDivisionId()+"  and irpm.section_id in (1,2) and  irpm.paras_status_id  in (1,2) order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					              
					            	 }
						}
		
		
		
		
		//System.out.println("getParasAbstractByUnit"+sql);
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId() }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					pr.setParaId(rs.getInt(1));
					pr.setActionTitle(rs.getString(2));
				//	pr.setParasAction(rs.getString(3));
					
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
					pr.setSectionB(rs.getString(14));
					pr.setPrintCagStatus(rs.getString(15));
					pr.setCategoryId(rs.getString(16));
					pr.setParaNumber(rs.getString(17));
					pr.setAuditDateFrom(rs.getString(18));
					pr.setAuditDateTo(rs.getString(19));
					pr.setFileNumber(rs.getString(20));
					pr.setLarNumber(rs.getString(21));
					pr.setParaNumsectionA(rs.getString(22));
					pr.setParaNumsectionB(rs.getString(23));
					pr.setTransferFlag(rs.getBoolean(24));
					pr.setTunitId(rs.getInt(25));
					pr.setTcircleId(rs.getInt(26));
					pr.setTdivisionId(rs.getInt(27));
					pr.setTsubdivisionId(rs.getInt(28));
				
				
				
				
			    return pr;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			
			//System.out.println("getParasprList"+prList);
			return prList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	@Override
	public List<Paras> getParasAbstractByUnitPDF( Paras paraObj ) throws IRParasUserException {
		
		
		
		String sql=null;
		
	 //System.out.println("dai impl getParasAbstractByUnit"+paraObj.getUnitId());
	 //System.out.println("dai impl getParasAbstractByUnit"+paraObj.getCircleId());
	 //System.out.println("dai impl getParasAbstractByUnit"+paraObj.getDivisionId());
	 //System.out.println("dai impl getParasAbstractByUnit"+paraObj.getSectionId());
	 //System.out.println("dai impl getParasAbstractByUnit"+paraObj.getParaStatusId());
	 //System.out.println("dai paraObj.getUnitTotal()"+paraObj.getUnitTotal());
	// System.out.println("dai impl paraObj.getCircleTotal"+paraObj.getCircleTotal());
	// System.out.println("dai impl getParasAbstractByUnit"+paraObj.getTransferFlag());
		
		
		if(paraObj.getUnitId()!=null && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("false") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false){
		      sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and (irpm.circle_id=0 or irpm.circle_id is null) and (irpm.division_id=0 or  irpm.division_id is null)  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			
			}
		if(paraObj.getUnitId()!=null && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("false") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==true){
		      sql = TOTAL_PARAS_BYUNIT_transfer_PDF +" and irpm.transfer_flag=true  and irpm.delete_flag=true and irpm.is_latest=false and (irpm.circle_id=0 or irpm.circle_id is null) and (irpm.division_id=0 or  irpm.division_id is null)  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			
			}
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSectionId()>0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("false") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false){
				
				 sql = TOTAL_PARAS_BYUNIT_PDF +" and  irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and (irpm.circle_id=0 or irpm.circle_id is null) and (irpm.division_id=0 or  irpm.division_id is null) and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
			}
			
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()>9 && paraObj.getUnitTotal().equals("false") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false){
				
				// System.out.println("coming"+paraStatusId);
				 if(paraObj.getParaStatusId()==1 || paraObj.getParaStatusId()==2 ||paraObj.getParaStatusId()==3){
				
				 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and (irpm.circle_id=0 or irpm.circle_id is null) and (irpm.division_id=0 or  irpm.division_id is null) and irpm.section_id in (1,2) and   irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				 }
				 
				
		        	 if(paraObj.getParaStatusId()==8){
		        		// System.out.println(paraStatusId);
		        		 
		            	 sql=TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and (irpm.circle_id=0 or irpm.circle_id is null) and (irpm.division_id=0 or  irpm.division_id is null)  and irpm.section_id in (1,2) and  irpm.paras_status_id in (1,2) order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
		              
		            	 }
			}
			
			if(paraObj.getUnitId()!=null && (paraObj.getCircleId()==-1||paraObj.getCircleId()==0) && (paraObj.getDivisionId()==-1||paraObj.getDivisionId()==0) && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("true") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false){
			      sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
				}
			if(paraObj.getUnitId()!=null && (paraObj.getCircleId()==-1||paraObj.getCircleId()==0) && (paraObj.getDivisionId()==-1||paraObj.getDivisionId()==0) && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("true")&& paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==true){
			      sql = TOTAL_PARAS_BYUNIT_transfer_PDF +" and irpm.transfer_flag=true and irpm.delete_flag=true and irpm.is_latest=false order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				
				}
				if(paraObj.getUnitId()!=null &&(paraObj.getCircleId()==-1||paraObj.getCircleId()==0) && (paraObj.getDivisionId()==-1||paraObj.getDivisionId()==0) && paraObj.getSectionId()>0 && paraObj.getParaStatusId()==0 && paraObj.getUnitTotal().equals("true") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false){
					
					 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					
				}
				
				if(paraObj.getUnitId()!=null && (paraObj.getCircleId()==-1||paraObj.getCircleId()==0) && (paraObj.getDivisionId()==-1||paraObj.getDivisionId()==0) && paraObj.getSectionId()==0 && paraObj.getParaStatusId()>0 && paraObj.getUnitTotal().equals("true") && paraObj.getCircleTotal().equals("false") && paraObj.getTransferFlag()==false ){
					
					 if(paraObj.getParaStatusId()==1 || paraObj.getParaStatusId()==2 ||paraObj.getParaStatusId()==3){
					
					 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.section_id in (1,2) and   irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					 }
					 
					 
			        	 
			        	 if(paraObj.getParaStatusId()==8){
			        		 
			            	 sql=TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.section_id in (1,2) and  irpm.paras_status_id in (1,2) order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
			              
			            	 }
				}
			
			
				// start of circle office data
				if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId() ==-1 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
				      sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and (irpm.division_id=0 or  irpm.division_id is null)  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					
					}
				
				if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()==-1 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==true){
				      sql = TOTAL_PARAS_BYUNIT_transfer_PDF +" and irpm.transfer_flag=true  and irpm.delete_flag=true and irpm.is_latest=false  and irpm.circle_id="+paraObj.getCircleId()+" and (irpm.division_id=0 or  irpm.division_id is null)  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					
					}
					if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null  && paraObj.getDivisionId()==-1 && paraObj.getSectionId()>0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
						
						 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false  and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and (irpm.division_id=0 or  irpm.division_id is null) and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
					}
					
					if(paraObj.getUnitId()!=null  &&  paraObj.getCircleId()!=null && paraObj.getDivisionId()==-1 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()!=null && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
						
						 if(paraObj.getParaStatusId()==1 || paraObj.getParaStatusId()==2 ||paraObj.getParaStatusId()==3){
						
						 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and irpm.circle_id="+paraObj.getCircleId()+" and (irpm.division_id=0 or  irpm.division_id is null) and irpm.section_id in (1,2) and   irpm.paras_status_id="+paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						 }
						 
						
				        	 
				        	 if(paraObj.getParaStatusId()==8){
				        		 
				            	 sql=TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false  and irpm.delete_flag=false and irpm.is_latest=true  and irpm.circle_id="+paraObj.getCircleId()+" and (irpm.division_id=0 or  irpm.division_id is null)  and irpm.section_id in (1,2) and  irpm.paras_status_id in (1,2) order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
				              
				            	 }
					}
					
					
					// end of circle office paras
					
					// start of circle total
					
					if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null &&  paraObj.getDivisionId()==-2 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("true") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
					      sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false  and irpm.delete_flag=false and irpm.is_latest=true   and irpm.circle_id="+paraObj.getCircleId()+"   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
						}
					
					if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null &&  paraObj.getDivisionId()==-2 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("true") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==true){
					      sql = TOTAL_PARAS_BYUNIT_transfer_PDF +" and irpm.transfer_flag=true  and irpm.delete_flag=true and irpm.is_latest=false and irpm.circle_id="+paraObj.getCircleId()+"   order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
						}
						if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null  &&  paraObj.getDivisionId()==-2 && paraObj.getSectionId()>0 && paraObj.getParaStatusId()==0 && paraObj.getCircleTotal().equals("true") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
							
							 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+"  and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
							
						}
						
						if(paraObj.getUnitId()!=null  && paraObj.getCircleId()!=null &&  paraObj.getDivisionId()==-2 && paraObj.getSectionId()==0 && paraObj.getParaStatusId()!=null && paraObj.getCircleTotal().equals("true") && paraObj.getUnitTotal().equals("false") && paraObj.getTransferFlag()==false){
							
							 if( paraObj.getParaStatusId()==1 ||  paraObj.getParaStatusId()==2 || paraObj.getParaStatusId()==3){
							
							 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+"  and irpm.section_id in (1,2) and   irpm.paras_status_id="+ paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
							 }
							 
							
					        	 
					        	 if( paraObj.getParaStatusId()==8){
					        		 
					            	 sql=TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true  and irpm.circle_id="+paraObj.getCircleId()+"   and irpm.section_id in (1,2) and  irpm.paras_status_id in (1,2) order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					              
					            	 }
						}
					
					
					if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()>0 && paraObj.getSectionId()==0 &&  paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==false && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false")){
					      sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id= "+paraObj.getDivisionId()+"  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
						}
					
					if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()>0 &&  paraObj.getSectionId()==0 && paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==true && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false")){
					      sql = TOTAL_PARAS_BYUNIT_transfer_PDF +" and irpm.transfer_flag=true and irpm.delete_flag=true and irpm.is_latest=false and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id= "+paraObj.getDivisionId()+"  order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
						
						}
						if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()>0 &&  paraObj.getSectionId()>0 &&  paraObj.getParaStatusId()==0 && paraObj.getTransferFlag()==false && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false")){
							
							 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id= "+paraObj.getDivisionId()+" and irpm.section_id = "+paraObj.getSectionId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
							
						}
						
						if(paraObj.getUnitId()!=null  && paraObj.getCircleId()!=null && paraObj.getDivisionId()>0 &&  paraObj.getSectionId()==0 &&  paraObj.getParaStatusId()!=null && paraObj.getTransferFlag()==false && paraObj.getCircleTotal().equals("false") && paraObj.getUnitTotal().equals("false")){
							
							 if( paraObj.getParaStatusId()==1 ||  paraObj.getParaStatusId()==2 || paraObj.getParaStatusId()==3){
							
							 sql = TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id= "+ paraObj.getDivisionId()+" and irpm.section_id in (1,2) and   irpm.paras_status_id="+ paraObj.getParaStatusId()+" order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
							 }
							 
							 
					        	 
					        	 if( paraObj.getParaStatusId()==8){
					        		 
					            	 sql=TOTAL_PARAS_BYUNIT_PDF +" and irpm.transfer_flag=false and irpm.delete_flag=false and irpm.is_latest=true and irpm.circle_id="+paraObj.getCircleId()+" and irpm.division_id= "+paraObj.getDivisionId()+"  and irpm.section_id in (1,2) and  irpm.paras_status_id  in (1,2) order by division_name,circle_name,unit_name,irpm.section_id,irpm.financial_year";
					              
					            	 }
						}
		
		
		
		
		//System.out.println("getParasAbstractByUnit"+sql);
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId() }, new RowMapper<Paras>() {
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
			
			//System.out.println("getParasprList"+prList);
			return prList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<Paras> getParasAbstarctCountByUnit( Paras ParaObj ) throws IRParasUserException {
		String sql = null;
		
		if(ParaObj!=null){
			
			//System.out.println("ParaObj.getUnitId()"+ParaObj.getUnitId());
			//System.out.println("ParaObj.getCircleId()"+ParaObj.getCircleId());
			//System.out.println("ParaObj.getDivisionId()"+ParaObj.getDivisionId());
			//System.out.println("ParaObj.getSubdivisionId()"+ParaObj.getSubdivisionId());
			
			if(ParaObj.getUnitId()!=null && ParaObj.getCircleId()!=null && ParaObj.getDivisionId()!=null && ParaObj.getSubdivisionId()!=null ){
				
				if(ParaObj.getUnitId()>0 && ParaObj.getCircleId()==0 && ParaObj.getDivisionId()==0 && ParaObj.getSubdivisionId()==0){
				
					sql=SELECT_PARAS_ABSTRACT_UNIT;
			}
			
			}
			
		}
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { ParaObj.getUnitId() }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				pr.setSecAParasCount(rs.getInt(6));
				pr.setSecBParasCount(rs.getInt(7));
				pr.setBalanceParas(rs.getInt(8));
				
				
				
				pr.setReplySent(rs.getInt(9));
				pr.setReplyNotSent(rs.getInt(10));
				pr.setTransfrred(rs.getInt(11));
				pr.setDroppedCount(rs.getInt(12));
				pr.setUnitCode(rs.getString(13));
				pr.setCircleName(rs.getString(14));
				pr.setDivisionName(rs.getString(15));
				pr.setSubdivisionName(rs.getString(16));
				pr.setUnitName(rs.getString(17));
				
				
				
				
				
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
	public List<Paras> getParasAbstarctCountByCircle(Paras paraObj  ) throws IRParasUserException {
		String sql = null ;
		

		
		if(paraObj!=null){
			
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null ){
				
				
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
				
				sql=SELECT_PARAS_ABSTRACT_CIRCLE;
				
				}
				
			
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
					sql=SELECT_PARAS_ABSTRACT_CIRCLE + " and ptirpm.circle_id="+ paraObj.getCircleId() ;
					
					}
				
				
			}
			
			
		}
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId() }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				pr.setSecAParasCount(rs.getInt(6));
				pr.setSecBParasCount(rs.getInt(7));
				pr.setBalanceParas(rs.getInt(8));
				
				
				
				pr.setReplySent(rs.getInt(9));
				pr.setReplyNotSent(rs.getInt(10));
				pr.setTransfrred(rs.getInt(11));
				pr.setDroppedCount(rs.getInt(12));
				pr.setUnitCode(rs.getString(13));
				pr.setCircleName(rs.getString(14));
				pr.setDivisionName(rs.getString(15));
				pr.setSubdivisionName(rs.getString(16));
				pr.setUnitName(rs.getString(17));
				
				
				
				
				
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
	public List<Paras> getParasAbstarctCountByDivision(Paras paraObj  ) throws IRParasUserException {
		
		String sql = null;
if(paraObj!=null){
			
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null ){
				
				
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
				
				     sql=SELECT_PARAS_ABSTRACT_DIVISION;
				
				}
				
			
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
					sql=SELECT_PARAS_ABSTRACT_DIVISION + " and ptirpm.circle_id="+ paraObj.getCircleId() ;
					
					}
				
if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId() >0 && paraObj.getSubdivisionId()==0){
					
					sql=SELECT_PARAS_ABSTRACT_DIVISION + " and ptirpm.circle_id="+ paraObj.getCircleId() + " and ptirpm.division_id="+paraObj.getDivisionId() ;
					
					}
				
				
			}
			
			
		}
	
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId() }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				pr.setSecAParasCount(rs.getInt(6));
				pr.setSecBParasCount(rs.getInt(7));
				pr.setBalanceParas(rs.getInt(8));
				
				
				
				pr.setReplySent(rs.getInt(9));
				pr.setReplyNotSent(rs.getInt(10));
				pr.setTransfrred(rs.getInt(11));
				pr.setDroppedCount(rs.getInt(12));
				pr.setUnitCode(rs.getString(13));
				pr.setCircleName(rs.getString(14));
				pr.setDivisionName(rs.getString(15));
				pr.setSubdivisionName(rs.getString(16));
				pr.setUnitName(rs.getString(17));
				
				
				
				
				
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
	public List<Paras> getCountWithoutCircleByDivision(Paras  paraObj  ) throws IRParasUserException {
		String sql = null;
		
     if(paraObj!=null){
			
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null ){
				
				
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
				
				     sql=SELECT_WITHOUT_CIRCLE_DIVISION;
				
				}
				
			
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
					sql=SELECT_WITHOUT_CIRCLE_DIVISION + " and ptirpm.circle_id="+ paraObj.getCircleId() ;
					
					}
				
if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId() >0 && paraObj.getSubdivisionId()==0){
					
					sql=SELECT_WITHOUT_CIRCLE_DIVISION + " and ptirpm.circle_id="+ paraObj.getCircleId() + " and ptirpm.division_id="+paraObj.getDivisionId() ;
					
					}
				
				
			}
			
			
		}
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId(),paraObj.getUnitId() }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				pr.setSecAParasCount(rs.getInt(6));
				pr.setSecBParasCount(rs.getInt(7));
				pr.setBalanceParas(rs.getInt(8));
				
				
				
				pr.setReplySent(rs.getInt(9));
				pr.setReplyNotSent(rs.getInt(10));
				pr.setTransfrred(rs.getInt(11));
				pr.setDroppedCount(rs.getInt(12));
				pr.setUnitCode(rs.getString(13));
				pr.setCircleName(rs.getString(14));
				pr.setDivisionName(rs.getString(15));
				pr.setSubdivisionName(rs.getString(16));
				pr.setUnitName(rs.getString(17));
				
				
				
				
				
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
	public List<Paras> getParasAbstarctCountBySubDiv( Paras paraObj ) throws IRParasUserException {
		
		String sql = SELECT_PARAS_ABSTRACT_SUBDIVISION;
		
if(paraObj!=null){
			
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null ){
				
				
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
				
				     sql=SELECT_PARAS_ABSTRACT_SUBDIVISION;
				
				}
				
			
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
					sql=SELECT_PARAS_ABSTRACT_SUBDIVISION + " and ptirpm.circle_id="+ paraObj.getCircleId() ;
					
					}
				
if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId() >0 && paraObj.getSubdivisionId()==0){
					
					sql=SELECT_PARAS_ABSTRACT_SUBDIVISION + " and ptirpm.circle_id="+ paraObj.getCircleId() + " and ptirpm.division_id="+paraObj.getDivisionId() ;
					
					}

if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId() >0 && paraObj.getSubdivisionId()>0){
	
	sql=SELECT_PARAS_ABSTRACT_SUBDIVISION + " and ptirpm.circle_id="+ paraObj.getCircleId() + " and ptirpm.division_id="+paraObj.getDivisionId()+" and ptirpm.subdivision_id="+paraObj.getSubdivisionId()  ;
	
	}
				
				
			}
			
			
		}
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId() }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				pr.setSecAParasCount(rs.getInt(6));
				pr.setSecBParasCount(rs.getInt(7));
				pr.setBalanceParas(rs.getInt(8));
				
				
				
				pr.setReplySent(rs.getInt(9));
				pr.setReplyNotSent(rs.getInt(10));
				pr.setTransfrred(rs.getInt(11));
				pr.setDroppedCount(rs.getInt(12));
				pr.setUnitCode(rs.getString(13));
				pr.setCircleName(rs.getString(14));
				pr.setDivisionName(rs.getString(15));
				pr.setSubdivisionName(rs.getString(16));
				pr.setUnitName(rs.getString(17));
				
				
				
				
				
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
	public List<Paras> getParasAbstarctCountByCirTot(Paras paraObj   ) throws IRParasUserException {
		String sql = null;
		
if(paraObj!=null){
			
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null ){
				
				
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
				
				     sql=SELECT_PARAS_ABSTRACT_CIRCLE_TOT;
				
				}
				
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
					
				     sql=SELECT_PARAS_ABSTRACT_CIRCLE_TOT + " and ptirpm.circle_id="+paraObj.getCircleId();
				
				}
				
			
				
			}
			
			
		}
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getUnitId() }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				pr.setSecAParasCount(rs.getInt(6));
				pr.setSecBParasCount(rs.getInt(7));
				pr.setBalanceParas(rs.getInt(8));
				
				
				
				pr.setReplySent(rs.getInt(9));
				pr.setReplyNotSent(rs.getInt(10));
				pr.setTransfrred(rs.getInt(11));
				pr.setDroppedCount(rs.getInt(12));
				pr.setUnitCode(rs.getString(13));
				pr.setCircleName(rs.getString(14));
				pr.setDivisionName(rs.getString(15));
				pr.setSubdivisionName(rs.getString(16));
				pr.setUnitName(rs.getString(17));
				
				
				
				
				
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
	public List<Paras> getParasAbstarctCountByUnitTot(Paras  paraObj  ) throws IRParasUserException {
		String sql = null;
		
if(paraObj!=null){
			
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null ){
				
				
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
				
				     sql=SELECT_PARAS_ABSTRACT_UNIT_TOTAL;
				
				}
				
			
				
			}
			
			
		}
		
			
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql , new Object[] { paraObj.getUnitId() },new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				pr.setSecAParasCount(rs.getInt(6));
				pr.setSecBParasCount(rs.getInt(7));
				pr.setBalanceParas(rs.getInt(8));
				
				
				
				pr.setReplySent(rs.getInt(9));
				pr.setReplyNotSent(rs.getInt(10));
				pr.setTransfrred(rs.getInt(11));
				pr.setDroppedCount(rs.getInt(12));
				pr.setUnitCode(rs.getString(13));
				pr.setCircleName(rs.getString(14));
				pr.setDivisionName(rs.getString(15));
				pr.setSubdivisionName(rs.getString(16));
				pr.setUnitName(rs.getString(17));
				
				
				
				
				
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
	public List<ReplyData> getReplybyParaId(Integer paraId ) throws IRParasUserException {
		String sql = GET_REPLY_BY_PARA_ID;
		
		
		
		
	
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql ,new Object[] { paraId }, new RowMapper<ReplyData>() {
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
	public List<ParaDocuments> getDocsByParaId(Integer paraId ) throws IRParasUserException {
		String sql = GET_ALL_DOCS;
		
		
		
	
		try {
			List<ParaDocuments> docList = jdbcTemplate6.query(sql ,new Object[] { paraId }, new RowMapper<ParaDocuments>() {
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
	public List<Paras> getParasByOfficePdf( Integer unitId,Integer circleId, Integer divisionId ) throws IRParasUserException {
		
		
		String sql = null;
		
		if(unitId==null && (circleId==null||circleId==0 ) && (divisionId==null || divisionId==0) ){
			
			sql=TOTAL_PARAS_DETAIL_PDF+" order by para_id";
			
		}
		if(unitId!=null && ( circleId==null || circleId==0 ) && (divisionId==null || divisionId==0 )){
		sql=TOTAL_PARAS_DETAIL_PDF+" and irpm.unit_id="+unitId+" and (coalesce( irpm.circle_id,0)=0) and (coalesce(irpm.division_id,0)=0) order by para_id";
		
		}
		
		if((unitId!=null && unitId>0 ) && (circleId!=null && circleId>0 ) && ( divisionId==null || divisionId==0 )){
		sql=TOTAL_PARAS_DETAIL_PDF+" and irpm.circle_id= "+circleId+" and (coalesce(irpm.division_id,0)=0) order by para_id " ;
		
		}
		
		if((unitId!=null && unitId > 0  ) && (circleId!=null && circleId > 0 ) && ( divisionId!=null && divisionId>0 )){
		sql=TOTAL_PARAS_DETAIL_PDF+" and irpm.division_id= "+divisionId+" order by para_id";
		}
				
				
		//System.out.println("sql"+sql);		
				
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql , new RowMapper<Paras>() {
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
					
					pr.setReplyAction(rs.getString(25));
					pr.setDocoriginalName(rs.getString(26));
					
				
				
				
				
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
	public List<CAGParas> getCAGParasAbstarctCount(CAGParas paraObj ) throws IRParasUserException {
		String sql1 = SELECT_CAG_ABSTRACT_COUNT;
		
		String sql2=SELECT_CAG_ABSTRACT_COUNT_BYUNIT;
		
		String sql=null;
		
		if(paraObj!=null){
			
			if(paraObj.getUnitId()!=null){
				
				if(paraObj.getUnitId()>0){
					
					if(paraObj.getUnitId()==4 || paraObj.getUnitId()==9832){
						
						sql=sql1;
						
					}else {
						
						
						sql=sql2+"  and  totalcag.unit_id="+paraObj.getUnitId()+" order by financial_year,para_number;";
						
					}
					
				}
				
				
				
			}
			
			
		}
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql , new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					
				pr.setFinancialYear(rs.getString(1));
				pr.setParaNumber(rs.getString(2));
				pr.setCagGistId(rs.getInt(3));
				pr.setTotalParas(rs.getInt(4));
				pr.setBalanceParas(rs.getInt(5));
				pr.setReplyNotSent(rs.getInt(6));
				pr.setReplybyce(rs.getInt(7));
				pr.setReplybyenci(rs.getInt(8));
				pr.setReplybysecyag(rs.getInt(9));
				pr.setReplybyseccont(rs.getInt(10));
				pr.setDroppedCount(rs.getInt(11));
				pr.setDicusspaccount(rs.getInt(12));
				pr.setPacinclcount(rs.getInt(13));
				pr.setUnitName(rs.getString(14));
				
				
				
				
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
	public List<CAGParas> getCAGParasAbstarctYearUnit(CAGParas paraObj ) throws IRParasUserException {
		//String sql1 = SELECT_CAG_ABSTRACT_COUNT;
		//SELECT_CAG_ABSTRACT_COUNT_BYUNIT;
		
		String sql2=SELECT_CAG_ABSTRACT_BYFIN_UNIT;
				
				
		
		String sql=null;
		
		if(paraObj!=null){
			
			if(paraObj.getUnitId()!=null){
				
				if(paraObj.getUnitId()>0){
					
					if((paraObj.getUnitId()==4 || paraObj.getUnitId()==9832)&& paraObj.getFinancialYear()!=null ){
						
						sql=sql2 + " 	where financial_year= '"+paraObj.getFinancialYear()+"'";
						
					}else {
						
						
						sql=sql2+" where financial_year='"+paraObj.getFinancialYear()+"'  and totaldata.unit_id= '"+paraObj.getUnitId()+"'";
						
					}
					
				}
				
				
				
			}
			
			
		}
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql , new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					
				pr.setFinancialYear(rs.getString(1));
				pr.setParaNumber(rs.getString(2));
				pr.setCagGistId(rs.getInt(3));
				pr.setTotalParas(rs.getInt(4));
				pr.setBalanceParas(rs.getInt(5));
				pr.setReplyNotSent(rs.getInt(6));
				pr.setReplybyce(rs.getInt(7));
				pr.setReplybyenci(rs.getInt(8));
				pr.setReplybysecyag(rs.getInt(9));
				pr.setReplybyseccont(rs.getInt(10));
				pr.setDroppedCount(rs.getInt(11));
				pr.setDicusspaccount(rs.getInt(12));
				pr.setPacinclcount(rs.getInt(13));
				pr.setUnitName(rs.getString(14));
				pr.setUnitId(rs.getInt(15));
			
				
				
				
				
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
	public List<CAGParas> getCAGparaFinYear() throws IRParasUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = SELECT_CAG_REPORT_YEAR ;
		try {

			List<CAGParas> yearList = jdbcTemplate6.query(sql,
					new RowMapper<CAGParas>() {

						public CAGParas mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CAGParas mtfd = new CAGParas();
							
							mtfd.setFinancialYear(rs.getString(1));
							return mtfd;
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
	public List<CAGParas> getCAGParasAbstarctCountByUnit( Integer unitId ) throws IRParasUserException {
		String sql = SELECT_CAG_ABSTRACT_UNIT;
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql ,new Object[] { unitId }, new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
			
				pr.setBalanceParas(rs.getInt(6));
				
				
				
				pr.setReplySent(rs.getInt(7));
				pr.setReplyNotSent(rs.getInt(8));
				pr.setTransfrred(rs.getInt(9));
				pr.setDroppedCount(rs.getInt(10));
				pr.setUnitCode(rs.getString(11));
				pr.setCircleName(rs.getString(12));
				pr.setDivisionName(rs.getString(13));
				pr.setSubdivisionName(rs.getString(14));
				pr.setUnitName(rs.getString(15));
				
				
				
				
				
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
	public List<CAGParas> getCAGParasAbstarctCountByCircle(Integer unitId  ) throws IRParasUserException {
		String sql = SELECT_CAG_ABSTRACT_CIRCLE;
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql ,new Object[] { unitId }, new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				
				pr.setBalanceParas(rs.getInt(6));
				
				
				
				pr.setReplySent(rs.getInt(7));
				pr.setReplyNotSent(rs.getInt(8));
				pr.setTransfrred(rs.getInt(9));
				pr.setDroppedCount(rs.getInt(10));
				pr.setUnitCode(rs.getString(11));
				pr.setCircleName(rs.getString(12));
				pr.setDivisionName(rs.getString(13));
				pr.setSubdivisionName(rs.getString(14));
				pr.setUnitName(rs.getString(15));
				
				
				
				
				
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
	public List<CAGParas> getCAGParasAbstarctCountByDivision(Integer unitId  ) throws IRParasUserException {
		String sql = SELECT_CAG_ABSTRACT_DIVISION;
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql ,new Object[] { unitId }, new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				
				pr.setBalanceParas(rs.getInt(6));
				
				
				
				pr.setReplySent(rs.getInt(7));
				pr.setReplyNotSent(rs.getInt(8));
				pr.setTransfrred(rs.getInt(9));
				pr.setDroppedCount(rs.getInt(10));
				pr.setUnitCode(rs.getString(11));
				pr.setCircleName(rs.getString(12));
				pr.setDivisionName(rs.getString(13));
				pr.setSubdivisionName(rs.getString(14));
				pr.setUnitName(rs.getString(15));
				
				
				
				
				
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
	public List<CAGParas> getCAGCountWithoutCircleByDivision(Integer unitId  ) throws IRParasUserException {
		String sql = SELECT_CAG_WITHOUT_CIRCLE_DIVISION;
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql ,new Object[] { unitId,unitId }, new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				
				pr.setBalanceParas(rs.getInt(6));
				
				
				
				pr.setReplySent(rs.getInt(7));
				pr.setReplyNotSent(rs.getInt(8));
				pr.setTransfrred(rs.getInt(9));
				pr.setDroppedCount(rs.getInt(10));
				pr.setUnitCode(rs.getString(11));
				pr.setCircleName(rs.getString(12));
				pr.setDivisionName(rs.getString(13));
				pr.setSubdivisionName(rs.getString(14));
				pr.setUnitName(rs.getString(15));
				
				
				
				
				
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
	public List<CAGParas> getCAGParasAbstarctCountBySubDiv( Integer unitId ) throws IRParasUserException {
		String sql = SELECT_CAG_ABSTRACT_SUBDIVISION;
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql ,new Object[] { unitId }, new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				
				pr.setBalanceParas(rs.getInt(6));
				
				
				
				pr.setReplySent(rs.getInt(7));
				pr.setReplyNotSent(rs.getInt(8));
				pr.setTransfrred(rs.getInt(9));
				pr.setDroppedCount(rs.getInt(10));
				pr.setUnitCode(rs.getString(11));
				pr.setCircleName(rs.getString(12));
				pr.setDivisionName(rs.getString(13));
				pr.setSubdivisionName(rs.getString(14));
				pr.setUnitName(rs.getString(15));
				
				
				
				
				
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
	public List<CAGParas> getCAGParasAbstarctCountByCirTot(Integer unitId  ) throws IRParasUserException {
		String sql = SELECT_CAG_ABSTRACT_CIRCLE_TOT;
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql ,new Object[] { unitId }, new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
				
				pr.setBalanceParas(rs.getInt(6));
				
				
				
				pr.setReplySent(rs.getInt(7));
				pr.setReplyNotSent(rs.getInt(8));
				pr.setTransfrred(rs.getInt(9));
				pr.setDroppedCount(rs.getInt(10));
				pr.setUnitCode(rs.getString(11));
				pr.setCircleName(rs.getString(12));
				pr.setDivisionName(rs.getString(13));
				pr.setSubdivisionName(rs.getString(14));
				pr.setUnitName(rs.getString(15));
				
				
				
				
				
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
	public List<CAGParas> getCAGParasAbstarctCountByUnitTot(Integer unitId  ) throws IRParasUserException {
		String sql = SELECT_CAG_ABSTRACT_UNIT_TOTAL;
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql , new Object[] { unitId },new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					
				pr.setUnitId(rs.getInt(1));
				pr.setCircleId(rs.getInt(2));
				pr.setDivisionId(rs.getInt(3));
				pr.setSubdivisionId(rs.getInt(4));
				
				pr.setTotalParas(rs.getInt(5));
				
			
				pr.setBalanceParas(rs.getInt(6));
				
				
				
				pr.setReplySent(rs.getInt(7));
				pr.setReplyNotSent(rs.getInt(8));
				pr.setTransfrred(rs.getInt(9));
				pr.setDroppedCount(rs.getInt(10));
				pr.setUnitCode(rs.getString(11));
				pr.setCircleName(rs.getString(12));
				pr.setDivisionName(rs.getString(13));
				pr.setSubdivisionName(rs.getString(14));
				pr.setUnitName(rs.getString(15));
				
				
				
				
				
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
	public List<CAGParas> getCAGParasTotal(Integer paraStatusId , Boolean trFlag) throws IRParasUserException {
		String sql = null;
		
	
		if( paraStatusId ==null && trFlag==false ){
			
			sql=TOTAL_CAG_PARAS +"  and icm.transfer_flag=false   order by  icmg.financial_year,icm.sub_para_number , unit_name";
			
		}
		
         if( paraStatusId !=null  && trFlag==false){
        	 
        	 if(paraStatusId==4 || paraStatusId==2 ||paraStatusId==3 ||paraStatusId==5 ){
			
			sql=TOTAL_CAG_PARAS +" and icm.transfer_flag=false  and  icum.para_status_id_byunit="+paraStatusId+" order by icmg.financial_year,icm.sub_para_number,unit_name";
        	 }
        	 
        	 if(paraStatusId==8){
        		
     			
     			sql=TOTAL_CAG_PARAS +"  and  icum.para_status_id_byunit in (4,2,5) and icm.transfer_flag=false   order by icmg.financial_year,icm.sub_para_number,unit_name";
             	 }
        	
		}
         
         if( paraStatusId ==null && trFlag==true ){
        	 
        		
 			
 			sql=TOTAL_CAG_PARAS +" and icm.transfer_flag=true   order by icmg.financial_year,icm.sub_para_number,unit_name";
 			
 		}
         
         
         
       
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql , new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					pr.setCagGistId(rs.getInt(1));
					pr.setActionTitle(rs.getString(2));
					
					
					pr.setFinancialYear(rs.getString(3));
				
					pr.setUnitName(rs.getString(4));
					pr.setUnitId(rs.getInt(5));
					
					pr.setParaStatusId(rs.getInt(6));
					pr.setParaStatus(rs.getString(7));
					
					
					pr.setPrintCagStatus(rs.getString(8));
					
					pr.setParaNumber(rs.getString(9));
					pr.setSubParaNumber(rs.getString(10));
					pr.setCagParaId(rs.getInt(11));
					
				
				
				
				
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
	public List<CAGParasData> getCAGParasByUnit( CAGParasData paraobj ) throws IRParasUserException {
		
		String sql=TOTAL_CAG_PARAS_BYUNIT;
		String sql2=TOTAL_CAG_PARAS_BYOFFICE;
		
		//System.out.println("paraStatus"+paraobj.getParaStatusId());
		
		//System.out.println("paradiscuss"+paraobj.getDiscussPac());
		//System.out.println("parapac"+paraobj.getPacincluded());
		
		if(paraobj.getCunitId()==4 || (paraobj.getCunitId()==9832 && paraobj.getCircleId()==21614)){
		
		if(paraobj.getCagGistId()!=null && paraobj.getParaStatusId()!=null && paraobj.getDiscussPac()!=null && paraobj.getPacincluded()!=null ){
			
			if(paraobj.getParaStatusId()==0){			
			sql=sql+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" order by ircag.para_sequence ,ircag.sub_para_number";
			}else if( paraobj.getParaStatusId()==20 || paraobj.getParaStatusId()==3 || paraobj.getParaStatusId()==7 || paraobj.getParaStatusId()==8 || paraobj.getParaStatusId()==9 || paraobj.getParaStatusId()==10){			
				sql=sql+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and ics.cag_para_status_id="+paraobj.getParaStatusId()+" order by ircag.para_sequence, ircag.sub_para_number";
				}else if(paraobj.getParaStatusId()==21){			
				sql=sql+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and ics.cag_para_status_id in ( 20,7,8,9,10) order by ircag.para_sequence , ircag.sub_para_number";
				}else if (paraobj.getParaStatusId()==11 && paraobj.getDiscussPac().equals("Yes")) {
					sql=sql+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and ics.cag_para_status_id in ( 20,7,8,9,10) and ircag.discuss_pac= true order by ircag.para_sequence , ircag.sub_para_number";	
					
				}else if (paraobj.getParaStatusId()==12 && paraobj.getPacincluded().equals("Yes")){
					
					sql=sql+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and ics.cag_para_status_id in ( 20,7,8,9,10) and ircag.pac_incl= true order by ircag.para_sequence , ircag.sub_para_number";	
				
				}else {
					
					
				}
			
		}
		}
		
		if(paraobj.getCunitId()!=4 && (paraobj.getCunitId()!=9832 && paraobj.getCircleId()!=21614 )){
			
			if(paraobj.getCagGistId()!=null && paraobj.getParaStatusId()!=null && paraobj.getDiscussPac()!=null && paraobj.getPacincluded()!=null ){
				
				if(paraobj.getParaStatusId()==0){			
				sql=sql2+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and cum.unit_id="+paraobj.getCunitId()+" order by ircag.para_sequence ,ircag.sub_para_number";
				}else if( paraobj.getParaStatusId()==20 || paraobj.getParaStatusId()==3 || paraobj.getParaStatusId()==7 || paraobj.getParaStatusId()==8 || paraobj.getParaStatusId()==9 || paraobj.getParaStatusId()==10){			
					sql=sql2+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and cum.unit_id="+paraobj.getCunitId()+" and ics.cag_para_status_id="+paraobj.getParaStatusId()+" order by ircag.para_sequence, ircag.sub_para_number";
					}else if(paraobj.getParaStatusId()==21){			
					sql=sql2+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and cum.unit_id="+paraobj.getCunitId()+" and ics.cag_para_status_id in ( 20,7,8,9,10) order by ircag.para_sequence , ircag.sub_para_number";
					}else if (paraobj.getParaStatusId()==11 && paraobj.getDiscussPac().equals("Yes")) {
						sql=sql2+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and cum.unit_id="+paraobj.getCunitId()+" and ics.cag_para_status_id in ( 20,7,8,9,10) and ircag.discuss_pac= true order by ircag.para_sequence , ircag.sub_para_number";	
						
					}else if (paraobj.getParaStatusId()==12 && paraobj.getPacincluded().equals("Yes")){
						
						sql=sql2+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and cum.unit_id="+paraobj.getCunitId()+" and ics.cag_para_status_id in ( 20,7,8,9,10) and ircag.pac_incl= true order by ircag.para_sequence , ircag.sub_para_number";	
					
					}else {
						
						
					}
				
			}
			}
		
		//System.out.println("sql "+sql);
		
		/*if(unitId!=null &&   paraStatusId==null && trFlag==false){
			
			
			
			 sql = sql +" and ircag.transfer_flag=false   order by unit_name,financial_year,para_sequence";
			
		}
		
		if(unitId!=null &&  paraStatusId!=null && trFlag==false){
			
			
			 if(paraStatusId==4 || paraStatusId==2 ||paraStatusId==3 || paraStatusId==5){
				 
				// System.out.println("paraStatusId"+paraStatusId);
				
					
			
			 sql = sql +" and ircag.transfer_flag=false  and  icum.para_status_id_byunit="+paraStatusId+" order by unit_name,financial_year,para_sequence";
			 }
			 
			 if(paraStatusId==8){
				 
				
					
					
				 sql = sql +" and  icum.para_status_id_byunit in (4,2,5) and ircag.transfer_flag=false  order by unit_name,financial_year,para_sequence";
				 }
			 
			
		}
		
		if(unitId!=null &&  paraStatusId==null && trFlag==true){
			
			
			 sql = sql +" and ircag.transfer_flag=true  order by unit_name,financial_year";
			
		}*/
		
		
		
		
		
		
		
		
		
	
		try {
			List<CAGParasData> prList = jdbcTemplate6.query(sql ,new Object[] {  }, new RowMapper<CAGParasData>() {
				public CAGParasData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParasData pr = new CAGParasData();
					pr.setCagGistId(rs.getInt(1));
					pr.setCagGistTitle(rs.getString(2));
					pr.setFinancialYear(rs.getString(3));
					pr.setParaNumber(rs.getString(4));				
					pr.setCagParaId(rs.getInt(5));
					pr.setSubParaNumber(rs.getString(6));
					pr.setParasAction(rs.getString(7));
					pr.setDiscussPac(rs.getString(8));
					pr.setPacincluded(rs.getString(9));
					
					pr.setParaStatusId(rs.getInt(10));
					
					
					pr.setParaStatus(rs.getString(11));
					
					pr.setUnitName(rs.getString(12));
					
					pr.setParaTitle(rs.getString(13));
				
				
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
	public List<CAGParasData> getCAGParasByYearUnit( CAGParasData paraobj ) throws IRParasUserException {
		
		String sql=null;
		String sql2=TOTAL_CAG_PARAS_BYOFFICE;
		


		
		
			
			if(paraobj.getCagGistId()!=null && paraobj.getParaStatusId()!=null && paraobj.getDiscussPac()!=null && paraobj.getPacincluded()!=null  && paraobj.getCunitId()!=null){
				
				//System.out.println("coming here");
				if(paraobj.getParaStatusId()==0){			
				sql=sql2+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and cum.unit_id="+paraobj.getCunitId()+" order by ircag.para_sequence ,ircag.sub_para_number";
				}else if( paraobj.getParaStatusId()==20 || paraobj.getParaStatusId()==3 || paraobj.getParaStatusId()==7 || paraobj.getParaStatusId()==8 || paraobj.getParaStatusId()==9 || paraobj.getParaStatusId()==10){			
					sql=sql2+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and cum.unit_id="+paraobj.getCunitId()+" and ics.cag_para_status_id="+paraobj.getParaStatusId()+" order by ircag.para_sequence, ircag.sub_para_number";
					}else if(paraobj.getParaStatusId()==21){			
					sql=sql2+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and cum.unit_id="+paraobj.getCunitId()+" and ics.cag_para_status_id in ( 20,7,8,9,10) order by ircag.para_sequence , ircag.sub_para_number";
					}else if (paraobj.getParaStatusId()==11 && paraobj.getDiscussPac().equals("Yes")) {
						sql=sql2+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and cum.unit_id="+paraobj.getCunitId()+" and ics.cag_para_status_id in ( 20,7,8,9,10) and ircag.discuss_pac= true order by ircag.para_sequence , ircag.sub_para_number";	
						
					}else if (paraobj.getParaStatusId()==12 && paraobj.getPacincluded().equals("Yes")){
						
						sql=sql2+" where ircag.cag_gist_id="+paraobj.getCagGistId()+" and cum.unit_id="+paraobj.getCunitId()+" and ics.cag_para_status_id in ( 20,7,8,9,10) and ircag.pac_incl= true order by ircag.para_sequence , ircag.sub_para_number";	
					
					}else {
						
						
					}
				
			}
			
		
		//System.out.println("sql "+sql);
		
	
		
		
		
		
		
		
		
		
	
		try {
			List<CAGParasData> prList = jdbcTemplate6.query(sql ,new Object[] {  }, new RowMapper<CAGParasData>() {
				public CAGParasData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParasData pr = new CAGParasData();
					pr.setCagGistId(rs.getInt(1));
					pr.setCagGistTitle(rs.getString(2));
					pr.setFinancialYear(rs.getString(3));
					pr.setParaNumber(rs.getString(4));				
					pr.setCagParaId(rs.getInt(5));
					pr.setSubParaNumber(rs.getString(6));
					pr.setParasAction(rs.getString(7));
					pr.setDiscussPac(rs.getString(8));
					pr.setPacincluded(rs.getString(9));
					
					pr.setParaStatusId(rs.getInt(10));
					
					
					pr.setParaStatus(rs.getString(11));
					
					pr.setUnitName(rs.getString(12));
					
					pr.setParaTitle(rs.getString(13));
				
				
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
	public List<CAGParas> getCAGParasAbstractByUnit( Integer unitId,Integer circleId, Integer divisionId, Integer paraStatusId,String circleTotal,String unitTotal,Boolean trFlag ) throws IRParasUserException {
		
		
		
		String sql=null;
		
		/// System.out.println(paraStatusId+"--"+trFlag+"--"+unitId+"--"+unitTotal);
		
	
		if(unitId!=null && circleId==null && divisionId==null  && paraStatusId==null && unitTotal.equals("false") && trFlag==true){
		      sql = TOTAL_CAG_BYUNIT +" and transfer_flag=true and (ircag.circle_id=0 or ircag.circle_id is null) and (ircag.division_id=0 or  ircag.division_id is null)  order by division_name,circle_name,unit_name,ircag.financial_year";
			
			}
			if(unitId!=null && circleId==null && divisionId==null  && paraStatusId==null && unitTotal.equals("false") && trFlag==false){
				
				 sql = TOTAL_CAG_BYUNIT +" and  transfer_flag=false and (ircag.circle_id=0 or ircag.circle_id is null) and (ircag.division_id=0 or  ircag.division_id is null)  order by division_name,circle_name,unit_name,ircag.financial_year";
				
			}
			
			if(unitId!=null && circleId==null && divisionId==null  && paraStatusId!=null && unitTotal.equals("false") && trFlag==false){
				
				// System.out.println("coming"+paraStatusId);
				 if(paraStatusId==4 || paraStatusId==2 ||paraStatusId==3){
				
				 sql = TOTAL_CAG_BYUNIT +" and transfer_flag=false and (ircag.circle_id=0 or ircag.circle_id is null) and (ircag.division_id=0 or  ircag.division_id is null) and   ircag.paras_status_id="+paraStatusId+" order by division_name,circle_name,unit_name,ircag.financial_year";
				 }
				 
				
		        	 if(paraStatusId==8){
		        		// System.out.println(paraStatusId);
		        		 
		            	 sql=TOTAL_CAG_BYUNIT +" and transfer_flag=false  and (ircag.circle_id=0 or ircag.circle_id is null) and (ircag.division_id=0 or  ircag.division_id is null)   and  ircag.paras_status_id in (1,2) order by division_name,circle_name,unit_name,ircag.financial_year";
		              
		            	 }
			}
			
			if(unitId!=null && (circleId==null||circleId==0) && (divisionId==null||divisionId==0) && paraStatusId==null && unitTotal.equals("true") && trFlag==false){
			      sql = TOTAL_CAG_BYUNIT +" and transfer_flag=false  order by division_name,circle_name,unit_name,ircag.financial_year";
				
				}
			if(unitId!=null && (circleId==null||circleId==0) && (divisionId==null||divisionId==0)  && paraStatusId==null && unitTotal.equals("true") && trFlag==true){
			      sql = TOTAL_CAG_BYUNIT +" and transfer_flag=true  order by division_name,circle_name,unit_name,ircag.financial_year";
				
				}
				
				
				if(unitId!=null && (circleId==null||circleId==0) && (divisionId==null||divisionId==0)  && paraStatusId!=null && unitTotal.equals("true") && trFlag==false ){
					
					 if(paraStatusId==4 || paraStatusId==2 ||paraStatusId==3){
					
					 sql = TOTAL_CAG_BYUNIT +" and transfer_flag=false  and   ircag.paras_status_id="+paraStatusId+" order by division_name,circle_name,unit_name,ircag.financial_year";
					 }
					 
					 
			        	 
			        	 if(paraStatusId==8){
			        		 
			            	 sql=TOTAL_CAG_BYUNIT +" and transfer_flag=false  and   ircag.paras_status_id in (4,2) order by division_name,circle_name,unit_name,ircag.financial_year";
			              
			            	 }
				}
			
			
				
				if(unitId!=null && circleId!=null && divisionId==null  && paraStatusId==null && circleTotal.equals("false") && trFlag==false){
				      sql = TOTAL_CAG_BYUNIT +" and transfer_flag=false and ircag.circle_id="+circleId+" and (ircag.division_id=0 or  ircag.division_id is null)  order by division_name,circle_name,unit_name,ircag.financial_year";
					
					}
				
				if(unitId!=null && circleId!=null && divisionId==null  && paraStatusId==null && circleTotal.equals("false") && trFlag==true){
				      sql = TOTAL_CAG_BYUNIT +" and transfer_flag=true and ircag.circle_id="+circleId+" and (ircag.division_id=0 or  ircag.division_id is null)  order by division_name,circle_name,unit_name,ircag.financial_year";
					
					}
					
					
					if(unitId!=null  && circleId!=null && divisionId==null  && paraStatusId!=null && circleTotal.equals("false") && trFlag==false){
						
						 if(paraStatusId==4 || paraStatusId==2 ||paraStatusId==3){
						
						 sql = TOTAL_CAG_BYUNIT +" and transfer_flag=false and ircag.circle_id="+circleId+" and (ircag.division_id=0 or  ircag.division_id is null)  and   ircag.paras_status_id="+paraStatusId+" order by division_name,circle_name,unit_name,ircag.financial_year";
						 }
						 
						
				        	 
				        	 if(paraStatusId==8){
				        		 
				            	 sql=TOTAL_CAG_BYUNIT +" and transfer_flag=false and ircag.circle_id="+circleId+" and (ircag.division_id=0 or  ircag.division_id is null)   and  ircag.paras_status_id in (1,2) order by division_name,circle_name,unit_name,ircag.financial_year";
				              
				            	 }
					}
					
					
					if(unitId!=null && circleId!=null && divisionId==null &&  paraStatusId==null && circleTotal.equals("true") && trFlag==false){
					      sql = TOTAL_CAG_BYUNIT +" and transfer_flag=false and ircag.circle_id="+circleId+"   order by division_name,circle_name,unit_name,ircag.financial_year";
						
						}
					
					if(unitId!=null && circleId!=null && divisionId==null &&  paraStatusId==null && circleTotal.equals("true") && trFlag==true){
					      sql = TOTAL_CAG_BYUNIT +" and transfer_flag=true and ircag.circle_id="+circleId+"   order by division_name,circle_name,unit_name,irpm.financial_year";
						
						}
						
						
						if(unitId!=null  && circleId!=null && divisionId==null &&  paraStatusId!=null && circleTotal.equals("true") && trFlag==false){
							
							 if(paraStatusId==4 || paraStatusId==2 ||paraStatusId==3){
							
							 sql = TOTAL_CAG_BYUNIT +" and transfer_flag=false and ircag.circle_id="+circleId+"   and   ircag.paras_status_id="+paraStatusId+" order by division_name,circle_name,unit_name,ircag.financial_year";
							 }
							 
							
					        	 
					        	 if(paraStatusId==8){
					        		 
					            	 sql=TOTAL_CAG_BYUNIT +" and transfer_flag=false  and ircag.circle_id="+circleId+"    and  ircag.paras_status_id in (4,2) order by division_name,circle_name,unit_name,ircag.financial_year";
					              
					            	 }
						}
					
					
					if(unitId!=null && circleId!=null && divisionId!=null  && paraStatusId==null && trFlag==false){
					      sql = TOTAL_CAG_BYUNIT +" and transfer_flag=false and ircag.circle_id="+circleId+" and ircag.division_id= "+divisionId+"  order by division_name,circle_name,unit_name,ircag.financial_year";
						
						}
					
					if(unitId!=null && circleId!=null && divisionId!=null  && paraStatusId==null && trFlag==true){
					      sql = TOTAL_CAG_BYUNIT +" and transfer_flag=true and ircag.circle_id="+circleId+" and ircag.division_id= "+divisionId+"  order by division_name,circle_name,unit_name,ircag.financial_year";
						
						}
						
						if(unitId!=null  && circleId!=null && divisionId!=null &&  paraStatusId!=null && trFlag==false){
							
							 if(paraStatusId==4 || paraStatusId==2 ||paraStatusId==3){
							
							 sql = TOTAL_CAG_BYUNIT +" and transfer_flag=false and ircag.circle_id="+circleId+" and ircag.division_id= "+divisionId+"  and   ircag.paras_status_id="+paraStatusId+" order by division_name,circle_name,unit_name,ircag.financial_year";
							 }
							 
							 
					        	 
					        	 if(paraStatusId==8){
					        		 
					            	 sql=TOTAL_CAG_BYUNIT +" and transfer_flag=false and ircag.circle_id="+circleId+" and ircag.division_id= "+divisionId+"   and  ircag.paras_status_id  in (4,2) order by division_name,circle_name,unit_name,ircag.financial_year";
					              
					            	 }
						}
		
		
		
		
		
		
	
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
					pr.setCircleName(rs.getString(6));
					pr.setCircleId(rs.getInt(7));
					pr.setDivisionName(rs.getString(8));
					pr.setDivisionId(rs.getInt(9));
					pr.setParaStatusId(rs.getInt(10));
					pr.setParaStatus(rs.getString(11));
					
				
					pr.setPrintCagStatus(rs.getString(12));
				
					pr.setParaNumber(rs.getString(13));
					pr.setAuditDateFrom(rs.getString(14));
					pr.setAuditDateTo(rs.getString(15));
				
					pr.setTransferFlag(rs.getBoolean(16));
					pr.setTunitId(rs.getInt(17));
					pr.setTcircleId(rs.getInt(18));
					pr.setTdivisionId(rs.getInt(19));
					pr.setTsubdivisionId(rs.getInt(20));
				
				
				
				
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
	public List<CAGParasData> getCAGParasbyGistId(Integer cagParaId, Integer unitId ) throws IRParasUserException {
		String sql = GET_CAG_PARAS_SUBPARAID;
		
		
		
		
	
		try {
			List<CAGParasData> replyList = jdbcTemplate6.query(sql ,new Object[] { cagParaId ,unitId }, new RowMapper<CAGParasData>() {
				public CAGParasData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParasData cagpd = new CAGParasData();
			
					cagpd.setParasAction(rs.getString(1));
					cagpd.setParaSequence(rs.getInt(2));
				
					cagpd.setCagGistId(rs.getInt(3));
					cagpd.setCagParaId(rs.getInt(4));
					cagpd.setParaTitle(rs.getString(5));
					cagpd.setSubParaNumber(rs.getString(6));
					cagpd.setSubParaUnitId(rs.getInt(7));
					
					
				
				
				
			    return cagpd;


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
	public List<ReplyData> getCAGReplybyGistId(CAGParasData paraObj ) throws IRParasUserException {
		String sql1 = GET_CAG_REPLYS_GISTID;
		
		String sql2=GET_CAG_REPLYS_GISTID_BYUNIT;
		
		String sql=null;
				
				if(paraObj!=null){
					
					if(paraObj.getCunitId()!=null){
						
						if(paraObj.getCunitId()==4 || paraObj.getCunitId()==9832){
							
							sql=sql1 ;
							
						}else {
						
						sql=sql2+" and icr.create_by_unit_id in ( "+paraObj.getCunitId()+",9832)  order by cag_reply_date ";
					}
					
					
				}
				
				}
		
		
		//System.out.println("paraObj.getCagGistId()"+paraObj.getCagGistId());
		
	
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getCagGistId()}, new RowMapper<ReplyData>() {
				public ReplyData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReplyData rep = new ReplyData();
			
				rep.setCagGistId(rs.getInt(1));
				rep.setCagParaId(rs.getInt(2));
				
				
				rep.setReplyAction(rs.getString(3));
				rep.setReplyRemarks(rs.getString(4));
				rep.setReplyDate(rs.getString(5));
				rep.setParaReplyId(rs.getInt(6));
			
				rep.setUpdatedUsername(rs.getString(7));
			
			
				rep.setCreateUserName(rs.getString(8));
				
			
				rep.setUnitName(rs.getString(9));
				
				rep.setCreateReplybyUnit(rs.getInt(10));
				
				//rep.setPacincl(rs.getBoolean(11));
				
				
				
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
	public List<ReplyData> getCAGReplybyfy(CAGParas paraObj ) throws IRParasUserException {
		
		String sql1 = GET_CAG_REPLYS_FY;
		
		String sql2=GET_CAG_REPLYS_FY_BYUNIT;
		
		String sql=null;
				
				if(paraObj!=null){
					
					if(paraObj.getUnitId()!=null){
						
						if(paraObj.getUnitId()==4 || paraObj.getUnitId()==9832){
							
							sql=sql1;
							
						}else {
						
						sql=sql2+" and icr.create_by_unit_id in ( "+paraObj.getUnitId()+",9832)  order by cag_reply_date ";
					}
					
					
				}
				
				}
		
		
		//System.out.println("sql"+sql);
		
	
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getFinancialYear()}, new RowMapper<ReplyData>() {
				public ReplyData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReplyData rep = new ReplyData();
			
				rep.setCagGistId(rs.getInt(1));
				rep.setCagParaId(rs.getInt(2));
				
			
				rep.setReplyDate(rs.getString(3));
				rep.setParaReplyId(rs.getInt(4));
			
				rep.setUpdatedUsername(rs.getString(5));
			
			
				rep.setCreateUserName(rs.getString(6));
				
			
				rep.setUnitName(rs.getString(7));
				
				rep.setCreateReplybyUnit(rs.getInt(8));
				
				rep.setCreateDate(rs.getString(9));
				
				//rep.setPacincl(rs.getBoolean(11));
				
				
				
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
	public List<CAGParas> getCAGParasByOffice(Integer cagGistId) throws IRParasUserException {
		
		
		String sql = null;
	
		if(cagGistId!=0){
		sql=TOTAL_CAG_PARAS_DETAIL+" and ircag.cag_gist_id = "+cagGistId+" order by cag_gist_id";
		
		}
		
		
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql , new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					pr.setCagGistId(rs.getInt(1));
					pr.setActionTitle(rs.getString(2));
				
					
					pr.setFinancialYear(rs.getString(3));
					
					
					
					
				
					pr.setParaNumber(rs.getString(4));
					
					
				
				
				
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
	public List<CAGParasData> getCAGParastotalDetail() throws IRParasUserException {
		String sql = GET_CAG_PARAS_TOTAL_DETAIL;
		
		
		
		
	
		try {
			List<CAGParasData> replyList = jdbcTemplate6.query(sql , new RowMapper<CAGParasData>() {
				
				public CAGParasData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParasData cagpd = new CAGParasData();
			
					cagpd.setParasAction(rs.getString(1));
					cagpd.setParaSequence(rs.getInt(2));
				
					cagpd.setCagGistId(rs.getInt(3));
					
					cagpd.setParaTitle(rs.getString(4));
					cagpd.setSubParaNumber(rs.getString(5));
					
					cagpd.setParaStatusId(rs.getInt(6));
					
					
					cagpd.setParaStatus(rs.getString(7));
					cagpd.setDiscussPac(rs.getString(8));
					cagpd.setCagParaId(rs.getInt(9));
				
					
				
				
				
			    return cagpd;


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
	public List<ReplyData> getCAGReplyALL( ) throws IRParasUserException {
		String sql = GET_CAG_REPLYS_ALL;
		
		
		
		
	
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql ,new Object[] {  }, new RowMapper<ReplyData>() {
				public ReplyData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReplyData rep = new ReplyData();
			
				rep.setCagGistId(rs.getInt(1));
				rep.setCagParaId(rs.getInt(2));
				
				
				rep.setReplyAction(rs.getString(3));
				rep.setReplyRemarks(rs.getString(4));
				rep.setReplyDate(rs.getString(5));
				rep.setParaReplyId(rs.getInt(6));
				rep.setUserId(rs.getInt(7));
				rep.setUserName(rs.getString(8));
				rep.setCreateUserId(rs.getInt(9));
				rep.setCreateUserName(rs.getString(10));
				
				//System.out.println("now"+rs.getInt(11));
				rep.setParaseq(rs.getInt(11));
				rep.setSubParaNumber(rs.getString(12));
				rep.setSubParaUnitId(rs.getInt(13));
				
				
				
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
	public List<CAGParas> getCAGParasByOfficePdf( Integer unitId,Integer circleId, Integer divisionId ) throws IRParasUserException {
		
		
		String sql = null;
		
		if(unitId==null && (circleId==null||circleId==0 ) && (divisionId==null || divisionId==0) ){
			
			sql=TOTAL_CAGPARAS_DTAIL_PDF+" order by icmg.cag_gist_id,cagparas.cag_para_id, cagparas.para_sequence";
			
		}
		if(unitId!=null && ( circleId==null || circleId==0 ) && (divisionId==null || divisionId==0 )){
		sql=TOTAL_CAGPARAS_DTAIL_PDF+" and icmg.unit_id="+unitId+" and (coalesce( icmg.circle_id,0)=0) and (coalesce(icmg.division_id,0)=0) order by icmg.cag_gist_id,cagparas.cag_para_id, cagparas.para_sequence";
		
		}
		
		if((unitId!=null && unitId>0 ) && (circleId!=null && circleId>0 ) && ( divisionId==null || divisionId==0 )){
		sql=TOTAL_CAGPARAS_DTAIL_PDF+" and icmg.circle_id= "+circleId+" and (coalesce(icmg.division_id,0)=0) order by icmg.cag_gist_id,cagparas.cag_para_id, cagparas.para_sequence" ;
		
		}
		
		if((unitId!=null && unitId > 0  ) && (circleId!=null && circleId > 0 ) && ( divisionId!=null && divisionId>0 )){
		sql=TOTAL_CAGPARAS_DTAIL_PDF+" and icmg.division_id= "+divisionId+" order by icmg.cag_gist_id,cagparas.cag_para_id, cagparas.para_sequence";
		}
				
				
		//System.out.println("sql"+sql);		
				
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql , new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
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
					
					
					pr.setPrintCagStatus(rs.getString(12));
					
					pr.setParaNumber(rs.getString(13));
					pr.setAuditDateFrom(rs.getString(14));
					pr.setAuditDateTo(rs.getString(15));
					
					
					pr.setReplyAction(rs.getString(16));
					pr.setDocoriginalName(rs.getString(17));
					pr.setParasAction(rs.getString(18));
					pr.setParaSequence(rs.getInt(19));
					pr.setParaTitle(rs.getString(20));
				
				
				
				
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
	public List<CAGParasData> getCAGParasbyParaId(Integer cagParaId ) throws IRParasUserException {
		String sql = GET_CAG_PARAS_PARAID;
		
		
		
		
	
		try {
			List<CAGParasData> replyList = jdbcTemplate6.query(sql ,new Object[] { cagParaId }, new RowMapper<CAGParasData>() {
				public CAGParasData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParasData cagpd = new CAGParasData();
			
					cagpd.setParasAction(rs.getString(1));
					cagpd.setParaSequence(rs.getInt(2));
				
					cagpd.setCagGistId(rs.getInt(3));
					cagpd.setCagParaId(rs.getInt(4));
					cagpd.setParaTitle(rs.getString(5));
					
				
				
				
			    return cagpd;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return replyList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	/*@Override
	public List<ReplyData> getCAGReplybyParaId(Integer cagParaId ) throws IRParasUserException {
		String sql = GET_CAG_REPLYS_PARAID;
		
		
		
		
	
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql ,new Object[] { cagParaId }, new RowMapper<ReplyData>() {
				public ReplyData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReplyData rep = new ReplyData();
			
				rep.setCagGistId(rs.getInt(1));
				rep.setCagParaId(rs.getInt(2));
				
				
				rep.setReplyAction(rs.getString(3));
				rep.setReplyRemarks(rs.getString(4));
				rep.setReplyDate(rs.getString(5));
				rep.setParaReplyId(rs.getInt(6));
				rep.setUserId(rs.getInt(7));
				rep.setUserName(rs.getString(8));
				rep.setCreateUserId(rs.getInt(9));
				rep.setCreateUserName(rs.getString(10));
				
				//System.out.println("now"+rs.getInt(11));
				rep.setParaseq(rs.getInt(11));
				
				
				
			    return rep;


				}
            
			});
			jdbcTemplate6.getDataSource().getConnection().close();
			return replyList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}*/

	
	@Override
	public List<ParaDocuments> CAGgetDocsAll(CAGParasData paraObj) throws IRParasUserException {
		String sql1= CAG_DOCS_ALL_PARAS;
		
		String sql2=CAG_DOCS_UNIT_PARAS;
		
		String sql=null;
		
		if(paraObj!=null){
			
			if(paraObj.getCunitId()!=null){
				
				if(paraObj.getCunitId()==4 || paraObj.getCunitId()==9832){
					
					sql=sql1;
					
				}else {
					
					sql=sql2+"   and  cad.create_by_unit_id in ( "+paraObj.getCunitId()+ " ,9832)  order by doc_date";
					
				}
				
				
			}
			
			
		}
		
		
		
		
		
		
	
		try {
			List<ParaDocuments> docList = jdbcTemplate6.query(sql ,new Object[] { paraObj.getCagGistId() }, new RowMapper<ParaDocuments>() {
				public ParaDocuments mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ParaDocuments doc = new ParaDocuments();
				doc.setDocId(rs.getInt(1));
				doc.setParaDocOriginalName(rs.getString(2));
				doc.setCagParaId(rs.getInt(3));
				doc.setCagGistId(rs.getInt(4));
				doc.setParaDocName(rs.getString(5));
				doc.setDoctitle(rs.getString(6));
				doc.setDocdate(rs.getString(7));
				doc.setUnitId(rs.getInt(8));
				doc.setUnitName(rs.getString(9));
				
				
				
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
	public CAGParas getCAGGistByOfficePdfnew(Integer cagGistId ) throws IRParasUserException {
		
		
		String sql = CAG_PARAS_DTAIL_PDF_NEW_GIST;
		
		
		
				
				
		//System.out.println("sql"+sql);		
				
		
		
		
	
		try {
			CAGParas prList = (CAGParas) jdbcTemplate6.queryForObject(sql ,new Object[] { cagGistId }, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					pr.setCagGistId(rs.getInt(1));
					pr.setActionTitle(rs.getString(2));
					
					
					pr.setFinancialYear(rs.getString(3));
					
				
					
					
					pr.setParaNumber(rs.getString(4));
					
					
					
				
				
				
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
	public List<ReplyData> getReplysWithAllReplys( ) throws IRParasUserException {
		String sql = REPLY_ALL_WITH_ALL_REPLY;
		
		
		
	
		try {
			List<ReplyData> replyList = jdbcTemplate6.query(sql , new RowMapper<ReplyData>() {
				public ReplyData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReplyData rep = new ReplyData();
			
				//rep.setParaReplyId(rs.getInt(1));
				rep.setParaId(rs.getInt(1));
			
				rep.setReplyAction(rs.getString(2));
				rep.setReplyRemarks(rs.getString(3));
				//rep.setReplyDate(rs.getString(5));
				//rep.setSubParaId(rs.getInt(6));
				
				
				
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
	public List<Paras> getParasTotalPDF(Integer sectionId,Integer paraStatusId , Boolean trFlag) throws IRParasUserException {
		String sql = null;
		
		if(sectionId==null && paraStatusId ==null && trFlag==false  ){
				
			sql=TOTAL_PARAS +"  and transfer_flag=false  order by para_id";
				
		}
		if(sectionId!=null && paraStatusId ==null && trFlag==false ){
			
			sql=TOTAL_PARAS +"  and transfer_flag=false  and irpm.section_id="+sectionId+" order by para_id";
			
		}
		
         if(sectionId==null && paraStatusId !=null  && trFlag==false){
        	 
        	 if(paraStatusId==1 || paraStatusId==2 ||paraStatusId==3){
			
			sql=TOTAL_PARAS +" and transfer_flag=false  and  irpm.paras_status_id="+paraStatusId+" order by para_id";
        	 }
        	 
        	 if(paraStatusId==8){
        		
     			
     			sql=TOTAL_PARAS +"  and  irpm.paras_status_id in (1,2) and transfer_flag=false   order by para_id";
             	 }
        	
		}
         
         if(sectionId==null && paraStatusId ==null && trFlag==true ){
        	 
        		
 			
 			sql=TOTAL_PARAS +" and transfer_flag=true   order by para_id";
 			
 		}
         
         
         
       
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql , new RowMapper<Paras>() {
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
	public List<Paras> getParasByUnitPDF( Integer unitId,Integer sectionId, Integer paraStatusId,Boolean trFlag ) throws IRParasUserException {
		
		String sql=null;
		
		//System.out.println(unitId+","+sectionId+","+paraStatusId+","+trFlag);
		
		if(unitId!=null && sectionId==null && paraStatusId==null && trFlag==false){
	      sql = TOTAL_PARAS_BYUNIT +" and transfer_flag=false   order by para_id";
		
		}
		if(unitId!=null && sectionId!=null && paraStatusId==null && trFlag==false){
			
		//	System.out.println("i must be here"+unitId+","+sectionId+","+paraStatusId+","+trFlag);
			
			 sql = TOTAL_PARAS_BYUNIT +" and transfer_flag=false  and irpm.section_id = "+sectionId+" order by para_id";
			
		}
		
		if(unitId!=null && sectionId==null && paraStatusId!=null && trFlag==false){
			
			 if(paraStatusId==1 || paraStatusId==2 ||paraStatusId==3){
			
			 sql = TOTAL_PARAS_BYUNIT +" and transfer_flag=false  and  irpm.paras_status_id="+paraStatusId+" order by para_id";
			 }
			 
			 if(paraStatusId==8){
				 
				
					
				 sql = TOTAL_PARAS_BYUNIT +" and  irpm.paras_status_id in (1,2) and transfer_flag=false  order by para_id";
				 }
			 
			
		}
		
		if(unitId!=null && sectionId==null && paraStatusId==null && trFlag==true){
			
			
			 sql = TOTAL_PARAS_BYUNIT_transfer +" and transfer_flag=true  order by para_id";
			
		}
		
		
		
		
		
		
		
		
		
	
		try {
			List<Paras> prList = jdbcTemplate6.query(sql ,new Object[] { unitId }, new RowMapper<Paras>() {
				public Paras mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Paras pr = new Paras();
					pr.setParaId(rs.getInt(1));
					pr.setActionTitle(rs.getString(2));
				//	pr.setParasAction(rs.getString(3));
					
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
					pr.setTransferFlag(rs.getBoolean(24));
				
				
				
				
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
	public List<officeDataSend> getOfficeUserNamePwd(officeDataSend  officeObj ) throws IRParasUserException {
		String sql = SELECT_OFF_USER_DATA_BY_UNIT_ID;
		
		Integer unitId=0;
		Integer circleId=0;
		Integer  divisionId=0;
		
		if(officeObj!=null){
			if(officeObj.getUnitId()!=null){
				unitId=officeObj.getUnitId();
			}
			if(officeObj.getCircleId()!=null){
				circleId=officeObj.getCircleId();
			}else {
				
				circleId=0;
			}
			if(officeObj.getDivisionId()!=null){
				divisionId=officeObj.getDivisionId();
			}else {
				divisionId=0;
				
			}
			
		}
//		System.out.println("unitId"+unitId+"circleId"+circleId+"divisionId"+divisionId);
//		System.out.println("officeObj.getLatestemailId()"+officeObj.getLatestemailId());
	
		try {
			List<officeDataSend> oodList = jdbcTemplate3.query(sql ,new Object[] { unitId,circleId,divisionId }, new RowMapper<officeDataSend>() {
				public officeDataSend mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					
					officeDataSend ood = new officeDataSend();
					ood.setUserId(rs.getInt(1));
					ood.setUserName(rs.getString(2));
					ood.setPwd(rs.getString(3));
					ood.setUnitId(rs.getInt(4));
					ood.setCircleId(rs.getInt(5));
					ood.setDivisionId(rs.getInt(6));
				
			    return ood;
				}
				
            
			});
			jdbcTemplate3.getDataSource().getConnection().close();
		//	System.out.println("oodList"+oodList);
			return oodList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<officeDataSend> getOfficeEmailId(officeDataSend  officeObj ) throws IRParasUserException {
		String sqlu = SELECT_UNIT_OFFICE_EMAILID;
		String sqlc = SELECT_CIRCLE_OFFICE_EMAILID;
		String sqld = SELECT_DIVISION_OFFICE_EMAILID;
		String sql=null;
		
	//System.out.println("dao1"+officeObj.getUnitId());
	//System.out.println("dao1"+officeObj.getCircleId());
	
	//System.out.println("dao1"+officeObj.getDivisionId());
	
		
		if(officeObj!=null){
			if(officeObj.getUnitId()>0 && (officeObj.getCircleId()==null|| officeObj.getCircleId()==0 ) && (officeObj.getDivisionId()==null||officeObj.getDivisionId()==0) ){
//				System.out.println("u c d"+officeObj.getUnitId()+"c "+officeObj.getCircleId()+"D "+officeObj.getDivisionId());	
				officeObj.setCircleId(0);
				officeObj.setDivisionId(0);
				sql=sqlu + " and unit_id="+officeObj.getUnitId();
			}
			if(officeObj.getUnitId()>0 && officeObj.getCircleId()>0 && (officeObj.getDivisionId()==null||officeObj.getDivisionId()==0) ){
//				System.out.println("u c d"+officeObj.getUnitId()+"c "+officeObj.getCircleId()+"D "+officeObj.getDivisionId());	
				officeObj.setDivisionId(0);
				sql=sqlc + " and unit_id="+officeObj.getUnitId()+ " and circle_id=" +officeObj.getCircleId();
			}
			if(officeObj.getUnitId()!=null && officeObj.getCircleId()>0 && officeObj.getDivisionId()>0){
	//			System.out.println("u c d"+officeObj.getUnitId()+"c "+officeObj.getCircleId()+"D "+officeObj.getDivisionId());	
				sql=sqld + " and um.unit_id="+officeObj.getUnitId()+" and dm.circle_id=" + officeObj.getCircleId()+" and dm.division_id="+officeObj.getDivisionId();
			}
			
		}
	//System.out.println("emaildaoimpl"+sql);
	
		try {
			List<officeDataSend> oodList = jdbcTemplate3.query(sql , new RowMapper<officeDataSend>() {
				public officeDataSend mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					
					officeDataSend ood = new officeDataSend();
					ood.setLatestemailId(rs.getString(1));
				
			    return ood;
				}
            
			});
			jdbcTemplate3.getDataSource().getConnection().close();
	//		System.out.println("oodList"+oodList);
			return oodList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<CAGParas> getCAGParasAbstractUnit(CAGParas paraObj ) throws IRParasUserException {
		//String sql1 = SELECT_CAG_ABSTRACT_COUNT;
		//SELECT_CAG_ABSTRACT_COUNT_BYUNIT;
		
		String sql2=SELECT_CAG_UNIT_WISE;
				
				
		
		String sql=null;
		
		if(paraObj!=null){
			
			if(paraObj.getUnitId()!=null){
				
				if(paraObj.getUnitId()>0){
					
					if((paraObj.getUnitId()==4 || paraObj.getUnitId()==9832) ){
						
						sql=sql2 + "  order by unit_name";
						
					}else {
						
						sql=sql2 + "  where totaldata.unit_id= '"+paraObj.getUnitId()+"'  order by unit_name";
						//sql=sql2+" where financial_year='"+paraObj.getFinancialYear()+"'  and totaldata.unit_id= '"+paraObj.getUnitId()+"'";
						
					}
					
				}
				
				
				
			}
			
			
		}
		
		
		
	
		try {
			List<CAGParas> prList = jdbcTemplate6.query(sql , new RowMapper<CAGParas>() {
				public CAGParas mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					CAGParas pr = new CAGParas();
					
				pr.setFinancialYear(rs.getString(1));
				pr.setParaNumber(rs.getString(2));
				pr.setCagGistId(rs.getInt(3));
				pr.setTotalParas(rs.getInt(4));
				pr.setBalanceParas(rs.getInt(5));
				pr.setReplyNotSent(rs.getInt(6));
				pr.setReplybyce(rs.getInt(7));
				pr.setReplybyenci(rs.getInt(8));
				pr.setReplybysecyag(rs.getInt(9));
				pr.setReplybyseccont(rs.getInt(10));
				pr.setDroppedCount(rs.getInt(11));
				pr.setDicusspaccount(rs.getInt(12));
				pr.setPacinclcount(rs.getInt(13));
				pr.setUnitName(rs.getString(14));
				pr.setUnitId(rs.getInt(15));
			
				
				
				
				
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
	
}
