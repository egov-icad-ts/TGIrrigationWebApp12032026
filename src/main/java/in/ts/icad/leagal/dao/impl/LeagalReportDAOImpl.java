package in.ts.icad.leagal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import in.ts.icad.leagal.dao.LeagalAdminDAO;
import in.ts.icad.leagal.dao.LeagalReportDAO;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Courts;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.abstractCounterData;
import in.ts.icad.leagal.util.UserDBUtil;


@Repository
public class LeagalReportDAOImpl implements LeagalReportDAO {
	
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private final boolean IS_DEBUG_ENABLED = log.isDebugEnabled();

	private JdbcTemplate jdbcTemplate;
	
	
	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*private JdbcTemplate jdbcHrmsTemplate;

	@Resource(name = "dataSource1")
	public void setDataSource1(DataSource dataSource) {
		this.jdbcHrmsTemplate = new JdbcTemplate(dataSource);
	}*/
	
	@Value("${SELECT_COURTS}")
	private String SELECT_COURTS;

	@Value("${SELECT_UNIT}")
	private String SELECT_UNIT;
	@Value("${SELECT_CIRCLE}")
	private String SELECT_CIRCLE;
	@Value("${SELECT_DIVISION}")
	private String SELECT_DIVISION;
	@Value("${SELECT_SUBDIVISION}")
	private String SELECT_SUBDIVISION;
	
	
	
	@Value("${SELECT_COUNTER_GEN}")
	private String SELECT_COUNTER_GEN;
	
	@Value("${SELECT_CASE_GEN_CASEFILED}")
	private String SELECT_CASE_GEN_CASEFILED;
	@Value("${SELECT_CASE_GEN_COUNTERFILED}")
	private String SELECT_CASE_GEN_COUNTERFILED;
	@Value("${SELECT_CASE_GEN_JUDGEFILED}")
	private String SELECT_CASE_GEN_JUDGEFILED;
	@Value("${SELECT_CASE_GEN_DRAFTFILED}")
	private String SELECT_CASE_GEN_DRAFTFILED;
	
	@Value("${SELECT_CASE_GEN_COUNTERNOTFILED}")
	private String SELECT_CASE_GEN_COUNTERNOTFILED;
	
	
	@Value("${SELECT_CASES_GEN_ALL}")
	private String SELECT_CASES_GEN_ALL;
	@Value("${SELECT_CASES_GEN}")
	private String SELECT_CASES_GEN;
	
	@Value("${SELECT_CASES_GEN_COURT}")
	private String SELECT_CASES_GEN_COURT;
	@Value("${SELECT_CASES_COURT}")
	private String SELECT_CASES_COURT;
	
	@Value("${UNIT_NAME}")
	private String UNIT_NAME;
	
	@Value("${CIRCLE_NAME}")
	private String CIRCLE_NAME;
	
	@Value("${DIVISION_NAME}")
	private String DIVISION_NAME;
	
	@Value("${SUBDIVISION_NAME}")
	private String SUBDIVISION_NAME;
	
	@Value("${SELECT_COUNTER_ALL}")
	private String SELECT_COUNTER_ALL;
	
	@Value("${SELECT_CASE_CASEFILED}")
	private String SELECT_CASE_CASEFILED;
	
	@Value("${SELECT_CASE_COUNTERFILED}")
	private String SELECT_CASE_COUNTERFILED;
	
	@Value("${SELECT_CASE_JUDGEFILED}")
	private String SELECT_CASE_JUDGEFILED;
	
	@Value("${SELECT_CASE_DRAFTFILED}")
	private String SELECT_CASE_DRAFTFILED;
	
	@Value("${SELECT_CASE_COUNTERNOTFILED}")
	private String SELECT_CASE_COUNTERNOTFILED;
	
	
	@Value("${SELECT_COUNTER_COURT_GEN}")
	private String SELECT_COUNTER_COURT_GEN;
	
	@Value("${SELECT_CASE_COURT_GEN_CF}")
	private String SELECT_CASE_COURT_GEN_CF;
	
	@Value("${SELECT_CASE_COURT_GEN_CTF}")
	private String SELECT_CASE_COURT_GEN_CTF;
	
	@Value("${SELECT_CASE_COURT_GEN_JF}")
	private String SELECT_CASE_COURT_GEN_JF;
	
	@Value("${SELECT_CASE_COURT_GEN_DF}")
	private String SELECT_CASE_COURT_GEN_DF;
	
	@Value("${SELECT_CASE_COURT_GEN_CNTF}")
	private String SELECT_CASE_COURT_GEN_CNTF;
	
	
	
	@Value("${SELECT_COUNTER_COURT}")
	private String SELECT_COUNTER_COURT;
	
	
	
	@Value("${SELECT_CASE_COURT_CF}")
	private String SELECT_CASE_COURT_CF;
	
	@Value("${SELECT_CASE_COURT_CTF}")
	private String SELECT_CASE_COURT_CTF;
	
	@Value("${SELECT_CASE_COURT_JF}")
	private String SELECT_CASE_COURT_JF;
	
	@Value("${SELECT_CASE_COURT_DF}")
	private String SELECT_CASE_COURT_DF;
	
	@Value("${SELECT_CASE_COURT_CNTF}")
	private String SELECT_CASE_COURT_CNTF;
	
	
	
	@Value("${SELECT_COURT_CASE_TYPE_COUNT}")
	private String SELECT_COURT_CASE_TYPE_COUNT;
	
	
	
	@Value("${SELECT_CASE_EPCOUNT_CF_TYPE}")
	private String SELECT_CASE_EPCOUNT_CF_TYPE;
	
	@Value("${SELECT_CASE_EPCOUNT_CTF_TYPE}")
	private String SELECT_CASE_EPCOUNT_CTF_TYPE;
	
	@Value("${SELECT_CASE_EPCOUNT_JF_TYPE}")
	private String SELECT_CASE_EPCOUNT_JF_TYPE;
	
	@Value("${SELECT_CASE_EPCOUNT_DF_TYPE}")
	private String SELECT_CASE_EPCOUNT_DF_TYPE;
	
	@Value("${SELECT_CASE_EPCOUNT_CNTF_TYPE}")
	private String SELECT_CASE_EPCOUNT_CNTF_TYPE;
	
	
	@Value("${GET_CIRCLE_LIST}")
	private String GET_CIRCLE_LIST;
	
	@Value("${GET_DIVISION_LIST}")
	private String GET_DIVISION_LIST;
	
	
	@Value("${SELECT_COUNT_PETADV_COURT}")
	private String SELECT_COUNT_PETADV_COURT;
	
	@Value("${SELECT_CASE_COURT_PETADV_CF}")
	private String SELECT_CASE_COURT_PETADV_CF;
	
	@Value("${SELECT_CASE_COURT_PETADV_CTF}")
	private String SELECT_CASE_COURT_PETADV_CTF;
	
	@Value("${SELECT_CASE_COURT_PETADV_JF}")
	private String SELECT_CASE_COURT_PETADV_JF;
	
	@Value("${SELECT_CASE_COURT_PETADV_DF}")
	private String SELECT_CASE_COURT_PETADV_DF;
	
	@Value("${SELECT_CASE_COURT_PETADV_CNTF}")
	private String SELECT_CASE_COURT_PETADV_CNTF;
	
	@Value("${SELECT_COUNT_PETADV_ALL}")
	private String SELECT_COUNT_PETADV_ALL;
	
	
	@Value("${SELECT_CASE_All_PETADV_CF}")
	private String SELECT_CASE_All_PETADV_CF;
	
	@Value("${SELECT_CASE_All_PETADV_CTF}")
	private String SELECT_CASE_All_PETADV_CTF;
	
	@Value("${SELECT_CASE_All_PETADV_JF}")
	private String SELECT_CASE_All_PETADV_JF;
	
	@Value("${SELECT_CASE_All_PETADV_DF}")
	private String SELECT_CASE_All_PETADV_DF;
	
	@Value("${SELECT_CASE_All_PETADV_CNTF}")
	private String SELECT_CASE_All_PETADV_CNTF;
	
	
	//petwise report
	
	@Value("${SELECT_COUNT_PET_COURT}")
	private String SELECT_COUNT_PET_COURT;
	@Value("${SELECT_COUNT_PET_ALL}")
	private String SELECT_COUNT_PET_ALL;
	@Value("${SELECT_CASE_COURT_PET_CF}")
	private String SELECT_CASE_COURT_PET_CF;
	@Value("${SELECT_CASE_COURT_PET_CTF}")
	private String SELECT_CASE_COURT_PET_CTF;
	@Value("${SELECT_CASE_COURT_PET_JF}")
	private String SELECT_CASE_COURT_PET_JF;
	@Value("${SELECT_CASE_COURT_PET_DF}")
	private String SELECT_CASE_COURT_PET_DF;
	@Value("${SELECT_CASE_COURT_PET_CNTF}")
	private String SELECT_CASE_COURT_PET_CNTF;
	@Value("${SELECT_CASE_ALL_PET_CF}")
	private String SELECT_CASE_ALL_PET_CF;
	@Value("${SELECT_CASE_ALL_PET_CTF}")
	private String SELECT_CASE_ALL_PET_CTF;
	@Value("${SELECT_CASE_ALL_PET_JF}")
	private String SELECT_CASE_ALL_PET_JF;
	@Value("${SELECT_CASE_ALL_PET_DF}")
	private String SELECT_CASE_ALL_PET_DF;
	@Value("${SELECT_CASE_ALL_PET_CNTF}")
	private String SELECT_CASE_ALL_PET_CNTF;
	
//viewcases total	
	
	@Value("${SELECT_CASE_All_TOT_CF}")
	private String SELECT_CASE_All_TOT_CF;
	
	@Value("${SELECT_CASE_All_TOT_CTF}")
	private String SELECT_CASE_All_TOT_CTF;
	
	@Value("${SELECT_CASE_All_TOT_JF}")
	private String SELECT_CASE_All_TOT_JF;
	
	@Value("${SELECT_CASE_All_TOT_DF}")
	private String SELECT_CASE_All_TOT_DF;
	
	@Value("${SELECT_CASE_All_TOT_CNTF}")
	private String SELECT_CASE_All_TOT_CNTF;
	
	@Value("${SELECT_CASE_GEN_TOT_CF}")
	private String SELECT_CASE_GEN_TOT_CF;
	
	@Value("${SELECT_CASE_GEN_TOT_CTF}")
	private String SELECT_CASE_GEN_TOT_CTF;
	
	@Value("${SELECT_CASE_GEN_TOT_JF}")
	private String SELECT_CASE_GEN_TOT_JF;
	
	@Value("${SELECT_CASE_GEN_TOT_DF}")
	private String SELECT_CASE_GEN_TOT_DF;
	
	@Value("${SELECT_CASE_GEN_TOT_CNTF}")
	private String SELECT_CASE_GEN_TOT_CNTF;
	
	@Value("${SELECT_CASE_COURT_TOT_CF}")
	private String SELECT_CASE_COURT_TOT_CF;
	
	@Value("${SELECT_CASE_COURT_TOT_CTF}")
	private String SELECT_CASE_COURT_TOT_CTF;
	
	@Value("${SELECT_CASE_COURT_TOT_JF}")
	private String SELECT_CASE_COURT_TOT_JF;
	
	@Value("${SELECT_CASE_COURT_TOT_DF}")
	private String SELECT_CASE_COURT_TOT_DF;
	
	@Value("${SELECT_CASE_COURT_TOT_CNTF}")
	private String SELECT_CASE_COURT_TOT_CNTF;
	
	
	@Value("${SELECT_CASE_COURT_GEN_TOT_CF}")
	private String SELECT_CASE_COURT_GEN_TOT_CF;
	
	@Value("${SELECT_CASE_COURT_GEN_TOT_CTF}")
	private String SELECT_CASE_COURT_GEN_TOT_CTF;
	
	@Value("${SELECT_CASE_COURT_GEN_TOT_JF}")
	private String SELECT_CASE_COURT_GEN_TOT_JF;
	
	@Value("${SELECT_CASE_COURT_GEN_TOT_DF}")
	private String SELECT_CASE_COURT_GEN_TOT_DF;
	
	@Value("${SELECT_CASE_COURT_GEN_TOT_CNTF}")
	private String SELECT_CASE_COURT_GEN_TOT_CNTF;
	
	//view tottal EP
	
	@Value("${SELECT_CASE_EPTOT_CF_TYPE}")
	private String SELECT_CASE_EPTOT_CF_TYPE;
	
	@Value("${SELECT_CASE_EPTOT_CTF_TYPE}")
	private String SELECT_CASE_EPTOT_CTF_TYPE;
	
	@Value("${SELECT_CASE_EPTOT_JF_TYPE}")
	private String SELECT_CASE_EPTOT_JF_TYPE;
	
	@Value("${SELECT_CASE_EPTOT_DF_TYPE}")
	private String SELECT_CASE_EPTOT_DF_TYPE;
	
	@Value("${SELECT_CASE_EPTOT_CNTF_TYPE}")
	private String SELECT_CASE_EPTOT_CNTF_TYPE;
	
	//view cases petadv total  and all
	
	@Value("${SELECT_CASE_All_PETADV_TOT_CF}")
	private String SELECT_CASE_All_PETADV_TOT_CF;
	@Value("${SELECT_CASE_All_PETADV_TOT_CTF}")
	private String SELECT_CASE_All_PETADV_TOT_CTF;
	@Value("${SELECT_CASE_All_PETADV_TOT_JF}")
	private String SELECT_CASE_All_PETADV_TOT_JF;
	@Value("${SELECT_CASE_All_PETADV_TOT_DF}")
	private String SELECT_CASE_All_PETADV_TOT_DF;
	@Value("${SELECT_CASE_All_PETADV_TOT_CNTF}")
	private String SELECT_CASE_All_PETADV_TOT_CNTF;
	
	//view cases petadv total  and court
	

	@Value("${SELECT_CASE_COURT_PETADV_TOT_CF}")
	private String SELECT_CASE_COURT_PETADV_TOT_CF;

	@Value("${SELECT_CASE_COURT_PETADV_TOT_CTF}")
	private String SELECT_CASE_COURT_PETADV_TOT_CTF;

	@Value("${SELECT_CASE_COURT_PETADV_TOT_JF}")
	private String SELECT_CASE_COURT_PETADV_TOT_JF;

	@Value("${SELECT_CASE_COURT_PETADV_TOT_DF}")
	private String SELECT_CASE_COURT_PETADV_TOT_DF;

	@Value("${SELECT_CASE_COURT_PETADV_TOT_CNTF}")
	private String SELECT_CASE_COURT_PETADV_TOT_CNTF;
	
	//view caese pet total all
	

	@Value("${SELECT_CASE_ALL_PET_TOT_CF}")
	private String SELECT_CASE_ALL_PET_TOT_CF;

	@Value("${SELECT_CASE_ALL_PET_TOT_CTF}")
	private String SELECT_CASE_ALL_PET_TOT_CTF;

	@Value("${SELECT_CASE_ALL_PET_TOT_JF}")
	private String SELECT_CASE_ALL_PET_TOT_JF;

	@Value("${SELECT_CASE_ALL_PET_TOT_DF}")
	private String SELECT_CASE_ALL_PET_TOT_DF;

	@Value("${SELECT_CASE_ALL_PET_TOT_CNTF}")
	private String SELECT_CASE_ALL_PET_TOT_CNTF;
	//view cases pet total court
	

	@Value("${SELECT_CASE_COURT_PET_TOT_CF}")
	private String SELECT_CASE_COURT_PET_TOT_CF;

	@Value("${SELECT_CASE_COURT_PET_TOT_CTF}")
	private String SELECT_CASE_COURT_PET_TOT_CTF;

	@Value("${SELECT_CASE_COURT_PET_TOT_JF}")
	private String SELECT_CASE_COURT_PET_TOT_JF;

	@Value("${SELECT_CASE_COURT_PET_TOT_DF}")
	private String SELECT_CASE_COURT_PET_TOT_DF;

	@Value("${SELECT_CASE_COURT_PET_TOT_CNTF}")
	private String SELECT_CASE_COURT_PET_TOT_CNTF;
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<abstractCounterData> getabstractcountGen(Integer caseGenId)throws LeagalUserException {
		
		String sql = SELECT_COUNTER_GEN;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			 final List<Unit> unitList= getUnitList();
			
			

			List<abstractCounterData> abcountList = jdbcTemplate.query(sql ,new Object[] { caseGenId }, new RowMapper<abstractCounterData>() {

				public abstractCounterData mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					abstractCounterData abcount = new abstractCounterData();
					abcount.setUnitId(rs.getInt(1));
					
					abcount.setCasesFiled(rs.getInt(2));
					abcount.setCasesJudged(rs.getInt(3));
					abcount.setCounterFiled(rs.getInt(4));
					abcount.setCasesToFile(rs.getInt(5));
					abcount.setDraftCountFile(rs.getInt(6));
					abcount.setCaseGenId(rs.getInt(7));
					abcount.setCategoryName(rs.getString(8));
					
					
					
					if( rs.getInt(1)>0){
						
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(1))
								abcount.setUnitName(unitList.get(i).getUnitName());
						     }	
						
						}
						
						
					
					}
					
					return abcount;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return abcountList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<abstractCounterData> getabstractcountCourt(Integer courtId) throws LeagalUserException {
		
		String sql = SELECT_COUNTER_COURT;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
			
			 final List<Unit> unitList= getUnitList();
				
			List<abstractCounterData> abcountList = jdbcTemplate.query(sql ,new Object[] { courtId }, new RowMapper<abstractCounterData>() {

				public abstractCounterData mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					abstractCounterData abcount = new abstractCounterData();
					abcount.setUnitId(rs.getInt(1));
					
					abcount.setCasesFiled(rs.getInt(2));
					abcount.setCasesJudged(rs.getInt(3));
					abcount.setCounterFiled(rs.getInt(4));
					abcount.setCasesToFile(rs.getInt(5));
					abcount.setDraftCountFile(rs.getInt(6));
					//abcount.setCaseGenId(rs.getInt(8));
					abcount.setCourtId(rs.getInt(7));
					
					
					abcount.setCourtName(rs.getString(8));
					
					
					
						
						if( rs.getInt(1)>0){
							
							
							if(unitList.size()>0){	
								
								final int len=unitList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(unitList.get(i).getUnitId()==rs.getInt(1))
									abcount.setUnitName(unitList.get(i).getUnitName());
							     }	
							
							}
							
							
						
						}
					
					
					
					return abcount;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return abcountList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<abstractCounterData> getabstractcountGenCourt( Integer caseGenId, Integer courtId) throws LeagalUserException {
		
		String sql = SELECT_COUNTER_COURT_GEN;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
			final List<Unit> unitList=getUnitList();

			List<abstractCounterData> abcountList = jdbcTemplate.query(sql ,new Object[] {caseGenId ,courtId  }, new RowMapper<abstractCounterData>() {

				public abstractCounterData mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					abstractCounterData abcount = new abstractCounterData();
					abcount.setUnitId(rs.getInt(1));
					
					abcount.setCasesFiled(rs.getInt(2));
					abcount.setCasesJudged(rs.getInt(3));
					abcount.setCounterFiled(rs.getInt(4));
					abcount.setCasesToFile(rs.getInt(5));
					abcount.setDraftCountFile(rs.getInt(6));
					abcount.setCaseGenId(rs.getInt(7));
					abcount.setCategoryName(rs.getString(8));
					abcount.setCourtId(rs.getInt(9));
					
					
					
					abcount.setCourtName(rs.getString(10));
					
					
					
					if( rs.getInt(1)>0){
						
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(1))
								abcount.setUnitName(unitList.get(i).getUnitName());
						     }	
						
						}
						
						
					
					}
					
					return abcount;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return abcountList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<abstractCounterData> getabstractcountGenAll() throws LeagalUserException {
		
		String sql = SELECT_COUNTER_ALL;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
			final List<Unit> unitList=getUnitList();

			List<abstractCounterData> abcountList = jdbcTemplate.query(sql , new RowMapper<abstractCounterData>() {

				public abstractCounterData mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					abstractCounterData abcount = new abstractCounterData();
					abcount.setUnitId(rs.getInt(1));
					
					abcount.setCasesFiled(rs.getInt(2));
					abcount.setCasesJudged(rs.getInt(3));
					abcount.setCounterFiled(rs.getInt(4));
					abcount.setCasesToFile(rs.getInt(5));
					abcount.setDraftCountFile(rs.getInt(6));
					//abcount.setCaseGenId(rs.getInt(8));
                      
					
					
					
					
					
					
					if( rs.getInt(1)>0){
						
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(1))
								abcount.setUnitName(unitList.get(i).getUnitName());
						     }	
						
						}
						
						
					
					}
					
					return abcount;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return abcountList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	

	@Override
	public List<Cases> getcasesGenCourt(Integer courtId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASES_GEN_COURT;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
            
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			
			
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					courtId, caseGenId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
					
					if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
					//Integer uName=rs.getInt(16);
					//cases.setUnitName(uName.toString());
					//Integer cName=rs.getInt(17);
					//cases.setCircleName(cName.toString());
					//Integer dName=rs.getInt(18);
					//cases.setDivisionName(dName.toString());

				
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}

	@Override
	public List<Cases> getcasesGenAll() throws LeagalUserException {
		
		
		String sql = SELECT_CASES_GEN_ALL;
		//String sql2 = SELECT_UNIT;
		
		
		try {

			
			
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
				
			
			List<Cases> CasesList = jdbcTemplate.query(sql,  new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
					
					
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					


	
					
					
					return cases;

				}
				
				
                
			});
             // System.out.println("CasesList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}

	@Override
	public List<Cases> getcasesGen( Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASES_GEN;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		try {
           
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					 caseGenId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
	
					
					
					return cases;

				}

			});
              //System.out.println("CasesList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}

	@Override
	public List<Cases> getcasesCourt(Integer courtId) throws LeagalUserException {
		
		
		String sql = SELECT_CASES_COURT;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		try {
               
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					courtId}, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
					
					
					return cases;

				}

			});
             // System.out.println("CasesList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}

	@Override
	public List<Courts> getCourts() throws LeagalUserException {
		

		String sql = SELECT_COURTS;
		try {

			List<Courts> courts = jdbcTemplate.query(sql , new RowMapper<Courts>() {

				public Courts mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Courts courts = new Courts();
					courts.setCourtId(rs.getInt(1));
					courts.setCourtName(rs.getString(2));
					return courts;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return courts;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<Cases> getEPcasesfiled(Integer unitId, Integer caseTypeId,Integer filingtype) throws LeagalUserException {
		
		
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_EPCOUNT_CF_TYPE;
			}
			if(filingtype==3){
				sql=SELECT_CASE_EPCOUNT_CTF_TYPE;;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_EPCOUNT_JF_TYPE;
			}
			if(filingtype==2){
			sql=SELECT_CASE_EPCOUNT_DF_TYPE;;
			}
			if(filingtype==4){
			sql=SELECT_CASE_EPCOUNT_CNTF_TYPE;;
			}
		
		
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		try {
			List<Cases> CasesList = new ArrayList<Cases>();
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			 CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId, caseTypeId}, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
					
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	

	
	
	@Override
	public List<abstractCounterData> getCountEPdata(Integer courtId,Integer caseTypeId) throws LeagalUserException {
		
		String sql = SELECT_COURT_CASE_TYPE_COUNT;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
			final List<Unit> unitList=getUnitList();

			List<abstractCounterData> abcountList = jdbcTemplate.query(sql ,new Object[] {caseTypeId,courtId  }, new RowMapper<abstractCounterData>() {

				public abstractCounterData mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					abstractCounterData abcount = new abstractCounterData();
					abcount.setUnitId(rs.getInt(1));
					
					abcount.setCasesFiled(rs.getInt(2));
					abcount.setCasesJudged(rs.getInt(3));
					abcount.setCounterFiled(rs.getInt(4));
					abcount.setCasesToFile(rs.getInt(5));
					abcount.setDraftCountFile(rs.getInt(6));
					abcount.setCaseTypeId(rs.getInt(7));
					abcount.setCourtName(rs.getString(8));
					abcount.setCaseType(rs.getString(9));
					abcount.setCourtId(rs.getInt(10));
					
					
					if( rs.getInt(1)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(1))
								abcount.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					
					}
					
					return abcount;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return abcountList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesfiled(Integer unitId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_GEN_CASEFILED;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId, caseGenId}, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
	
					
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesCounterfiled(Integer unitId,Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_GEN_COUNTERFILED;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId , caseGenId}, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
					
					return cases;

				}

			});
            //  System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesjudgefiled(Integer unitId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_GEN_JUDGEFILED;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId , caseGenId}, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
					
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesdraftfiled(Integer unitId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_GEN_DRAFTFILED;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId, caseGenId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
					
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<Cases> getcasescounternotfiled(Integer unitId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_GEN_COUNTERNOTFILED;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId , caseGenId}, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
					
					
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<Cases> getcasesAbstractGenCourtcasefiled( Integer unitId,Integer courtId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COURT_GEN_CF;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {

			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId , caseGenId ,courtId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
					
					return cases;

				}

			});
             // System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<Cases> getcasesAbstractGenCourtcounterfiled( Integer unitId,Integer courtId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COURT_GEN_CTF;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId , caseGenId ,courtId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesAbstractGenCourtjudgefiled( Integer unitId,Integer courtId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COURT_GEN_JF;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId , caseGenId ,courtId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					

				
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesAbstractGenCourtdraftfiled( Integer unitId,Integer courtId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COURT_GEN_DF;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();

			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId , caseGenId ,courtId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesAbstractGenCourtcounternotfiled( Integer unitId,Integer courtId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COURT_GEN_CNTF;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId , caseGenId ,courtId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesAbstractcasefiled( Integer unitId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_CASEFILED;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		//System.out.println("SELECT_CASE_CASEFILED"+sql);
		
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					

				
					
					return cases;

				}

			});
             // System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesAbstractcounterfiled( Integer unitId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COUNTERFILED;
		////final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();

			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
					
					return cases;

				}

			});
             // System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	@Override
	public List<Cases> getcasesAbstractjudgefiled( Integer unitId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_GEN_JUDGEFILED;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	@Override
	public List<Cases> getcasesAbstractdraftfiled( Integer unitId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_DRAFTFILED;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	@Override
	public List<Cases> getcasesAbstractcounternotfiled( Integer unitId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COUNTERNOTFILED;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {  
			
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();

			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<Cases> getcasesAbstractcourtcasefiled( Integer unitId , Integer courtId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COURT_CF;
		//final String sql2=UNIT_NAME;
		////final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();

			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId, courtId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
					
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					

				
					
					return cases;

				}

			});
              //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	@Override
	public List<Cases> getcasesAbstractcourtcounterfiled( Integer unitId , Integer courtId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COURT_CTF;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {  
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();

			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId, courtId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
					
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
					
					return cases;

				}

			});
             // System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	@Override
	public List<Cases> getcasesAbstractcourtjudgefiled( Integer unitId , Integer courtId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COURT_JF;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId, courtId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
					
					return cases;

				}

			});
             // System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	@Override
	public List<Cases> getcasesAbstractcourtdraftfiled( Integer unitId , Integer courtId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COURT_DF;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId, courtId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
					
					return cases;

				}

			});
             // System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesAbstractcourtcounternotfiled( Integer unitId , Integer courtId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_COURT_CNTF;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
		
		try {
			
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();

			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId, courtId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
					
					return cases;

				}

			});
             // System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	

	@Override
	public List<Unit> getUnitList() throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_UNIT;
		try {

			List<Unit> unitList = jdbcTemplate.query(sql,
					new RowMapper<Unit>() {

						public Unit mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Unit unit = new Unit();
							unit.setUnitId(rs.getInt(1));
							unit.setUnitName(rs.getString(2));
							return unit;
						}

					});
			//jdbcHrmsTemplate.getDataSource().getConnection().close();
			jdbcTemplate.getDataSource().getConnection().close();
			return unitList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	
	@Override
	public List<Circle> getCircleList() throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = GET_CIRCLE_LIST;
		try {

			List<Circle> circleList = jdbcTemplate.query(sql,
					new RowMapper<Circle>() {

						public Circle mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Circle circle = new Circle();
							circle.setCircleId(rs.getInt(1));
							circle.setCircleName(rs.getString(2));
							circle.setUnitId(rs.getInt(3));
							return circle;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return circleList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<Division> getDivisionList() throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = GET_DIVISION_LIST;
		try {

			List<Division> divisionList = jdbcTemplate.query(sql,
					new RowMapper<Division>() {

						public Division mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Division division = new Division();
							division.setDivisionId(rs.getInt(1));
							division.setDivisionName(rs.getString(2));
							division.setCircleId(rs.getInt(3));
							return division;
						}

					});
		jdbcTemplate.getDataSource().getConnection().close();
			return divisionList;
			
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<Subdivision> getSubDivisionList(Integer divisionId) throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_SUBDIVISION;
		try {

			List<Subdivision> subdivisionList = jdbcTemplate.query(sql,new Object[] { divisionId },
					new RowMapper<Subdivision>() {

						public Subdivision mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Subdivision subdivision = new Subdivision();
							subdivision.setSubdivisionId(rs.getInt(1));
							subdivision.setSubdivisionName(rs.getString(2));
							return subdivision;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return subdivisionList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<abstractCounterData> getabstractPetAdvCourt(Integer advocateId,Integer courtId) throws LeagalUserException {
		
		String sql = SELECT_COUNT_PETADV_COURT;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
			
			 final List<Unit> unitList= getUnitList();
				
			List<abstractCounterData> abcountList = jdbcTemplate.query(sql ,new Object[] {advocateId, courtId }, new RowMapper<abstractCounterData>() {

				public abstractCounterData mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					abstractCounterData abcount = new abstractCounterData();
					abcount.setUnitId(rs.getInt(1));
					
					abcount.setCasesFiled(rs.getInt(2));
					abcount.setCasesJudged(rs.getInt(6));
					abcount.setCounterFiled(rs.getInt(5));
					abcount.setCasesToFile(rs.getInt(11));
					abcount.setDraftCountFile(rs.getInt(7));
					//abcount.setCaseGenId(rs.getInt(8));
					abcount.setCourtId(rs.getInt(4));
					
					
					abcount.setCourtName(rs.getString(9));
					abcount.setAdvocateId(rs.getInt(3));
					abcount.setAdvocateName(rs.getString(10));
					
					
					
						
						if( rs.getInt(1)>0){
							
							
							if(unitList.size()>0){	
								
								final int len=unitList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(unitList.get(i).getUnitId()==rs.getInt(1))
									abcount.setUnitName(unitList.get(i).getUnitName());
							     }	
							
							}
							
							
						
						}
					
					
					
					return abcount;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return abcountList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	
	
	//abstract petadv
	
	
	
	@Override
	public List<Cases> getcasesAbstractCourtPetAdvCourt( Integer unitId,Integer courtId,Integer filingtype, Integer advocateId) throws LeagalUserException {
		
		

		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_COURT_PETADV_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_COURT_PETADV_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_COURT_PETADV_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_COURT_PETADV_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_COURT_PETADV_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId , courtId, advocateId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}


		
	}
	
	
	
	
	
	
	
	@Override
	public List<abstractCounterData> getabstractPetAdvAll(Integer advocateId) throws LeagalUserException {
		
		String sql = SELECT_COUNT_PETADV_ALL;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
			
			 final List<Unit> unitList= getUnitList();
				
			List<abstractCounterData> abcountList = jdbcTemplate.query(sql ,new Object[] {advocateId }, new RowMapper<abstractCounterData>() {

				public abstractCounterData mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					abstractCounterData abcount = new abstractCounterData();
					abcount.setUnitId(rs.getInt(1));
					
					abcount.setCasesFiled(rs.getInt(2));
					abcount.setCasesJudged(rs.getInt(5));
					abcount.setCounterFiled(rs.getInt(4));
					abcount.setCasesToFile(rs.getInt(9));
					abcount.setDraftCountFile(rs.getInt(6));
					//abcount.setCaseGenId(rs.getInt(8));
					
					
					
					
					abcount.setAdvocateId(rs.getInt(3));
					abcount.setAdvocateName(rs.getString(8));
					
					
					
						
						if( rs.getInt(1)>0){
							
							
							if(unitList.size()>0){	
								
								final int len=unitList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(unitList.get(i).getUnitId()==rs.getInt(1))
									abcount.setUnitName(unitList.get(i).getUnitName());
							     }	
							
							}
							
							
						
						}
					
					
					
					return abcount;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return abcountList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	
		
	}
	
	@Override
	public List<Cases> getcasesAbstractAllPetAdvAll( Integer unitId,Integer filingtype, Integer advocateId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_All_PETADV_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_All_PETADV_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_All_PETADV_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_All_PETADV_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_All_PETADV_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId ,  advocateId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<abstractCounterData> getabstractPetCourt(Integer petitionerId,Integer courtId) throws LeagalUserException {
		
		String sql = SELECT_COUNT_PET_COURT;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
			
			 final List<Unit> unitList= getUnitList();
				
			List<abstractCounterData> abcountList = jdbcTemplate.query(sql ,new Object[] {petitionerId , courtId }, new RowMapper<abstractCounterData>() {

				public abstractCounterData mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					abstractCounterData abcount = new abstractCounterData();
					abcount.setUnitId(rs.getInt(1));
					
					abcount.setCasesFiled(rs.getInt(2));
					abcount.setCasesJudged(rs.getInt(6));
					abcount.setCounterFiled(rs.getInt(5));
					abcount.setCasesToFile(rs.getInt(11));
					abcount.setDraftCountFile(rs.getInt(7));
					//abcount.setCaseGenId(rs.getInt(8));
					
					
					
					abcount.setCourtId(rs.getInt(4));
					abcount.setPetitionerId(rs.getInt(3));
					abcount.setPetitionerName(rs.getString(10));
					abcount.setCourtName(rs.getString(9));
					
					
					
						
						if( rs.getInt(1)>0){
							
							
							if(unitList.size()>0){	
								
								final int len=unitList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(unitList.get(i).getUnitId()==rs.getInt(1))
									abcount.setUnitName(unitList.get(i).getUnitName());
							     }	
							
							}
							
							
						
						}
					
					
					
					return abcount;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return abcountList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	
		
	}
	
	
	@Override
	public List<abstractCounterData> getabstractPetAll(Integer petitionerId) throws LeagalUserException {
		
		String sql = SELECT_COUNT_PET_ALL;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
			
			 final List<Unit> unitList= getUnitList();
				
			List<abstractCounterData> abcountList = jdbcTemplate.query(sql ,new Object[] {petitionerId}, new RowMapper<abstractCounterData>() {

				public abstractCounterData mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					abstractCounterData abcount = new abstractCounterData();
					abcount.setUnitId(rs.getInt(1));
					
					abcount.setCasesFiled(rs.getInt(2));
					abcount.setCasesJudged(rs.getInt(5));
					abcount.setCounterFiled(rs.getInt(4));
					abcount.setCasesToFile(rs.getInt(9));
					abcount.setDraftCountFile(rs.getInt(6));
					//abcount.setCaseGenId(rs.getInt(8));
					
					
					
					
					abcount.setPetitionerId(rs.getInt(3));
					abcount.setPetitionerName(rs.getString(8));
					
					
					
						
						if( rs.getInt(1)>0){
							
							
							if(unitList.size()>0){	
								
								final int len=unitList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(unitList.get(i).getUnitId()==rs.getInt(1))
									abcount.setUnitName(unitList.get(i).getUnitName());
							     }	
							
							}
							
							
						
						}
					
					
					
					return abcount;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return abcountList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	
		
	}
	
	
	@Override
	public List<Cases> getcasesAbstractPetAll( Integer unitId,Integer filingtype, Integer petitionerId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_ALL_PET_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_ALL_PET_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_ALL_PET_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_ALL_PET_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_ALL_PET_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId ,  petitionerId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<Cases> getcasesAbstractPetCourt( Integer unitId,Integer filingtype,Integer courtId, Integer petitionerId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_COURT_PET_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_COURT_PET_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_COURT_PET_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_COURT_PET_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_COURT_PET_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
					unitId , courtId, petitionerId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<Cases> getcasesAbstractTotAll( Integer filingtype) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_All_TOT_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_All_TOT_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_All_TOT_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_All_TOT_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_All_TOT_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesAbstractTotGen( Integer filingtype, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_GEN_TOT_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_GEN_TOT_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_GEN_TOT_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_GEN_TOT_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_GEN_TOT_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
						caseGenId}, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesAbstractTotCourt( Integer filingtype,Integer courtId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_COURT_TOT_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_COURT_TOT_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_COURT_TOT_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_COURT_TOT_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_COURT_TOT_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
						courtId}, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<Cases> getcasesAbstractEPTotType( Integer filingtype,Integer caseTypeId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_EPTOT_CF_TYPE;
			}
			if(filingtype==3){
				sql=SELECT_CASE_EPTOT_CTF_TYPE;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_EPTOT_JF_TYPE;
			}
			if(filingtype==2){
			sql=SELECT_CASE_EPTOT_DF_TYPE;
			}
			if(filingtype==4){
			sql=SELECT_CASE_EPTOT_CNTF_TYPE;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
						caseTypeId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<Cases> getcasesAbstractTotCourtGen( Integer filingtype,Integer courtId, Integer caseGenId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_COURT_GEN_TOT_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_COURT_GEN_TOT_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_COURT_GEN_TOT_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_COURT_GEN_TOT_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_COURT_GEN_TOT_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
						caseGenId, courtId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}

	
	
	@Override
	public List<Cases> getcasesAbstractTotPetAdvCourt( Integer filingtype,Integer courtId, Integer advocateId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_COURT_PETADV_TOT_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_COURT_PETADV_TOT_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_COURT_PETADV_TOT_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_COURT_PETADV_TOT_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_COURT_PETADV_TOT_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
						 courtId,advocateId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}

	
	@Override
	public List<Cases> getcasesAbstractTotPetAdvAll( Integer filingtype,Integer advocateId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_All_PETADV_TOT_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_All_PETADV_TOT_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_All_PETADV_TOT_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_All_PETADV_TOT_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_All_PETADV_TOT_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
						advocateId  }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}

	
	@Override
	public List<Cases> getcasesAbstractTotPetCourt( Integer filingtype,Integer courtId,Integer petitionerId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_COURT_PET_TOT_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_COURT_PET_TOT_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_COURT_PET_TOT_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_COURT_PET_TOT_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_COURT_PET_TOT_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
						 courtId ,petitionerId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}

	
	@Override
	public List<Cases> getcasesAbstractTotPetAll( Integer filingtype,Integer petitionerId) throws LeagalUserException {
		
		
		String sql = null;
			if(filingtype==1){
			sql=	SELECT_CASE_ALL_PET_TOT_CF;
			}
			if(filingtype==3){
				sql=SELECT_CASE_ALL_PET_TOT_CTF;
			
			}
			if(filingtype==5){
			sql=SELECT_CASE_ALL_PET_TOT_JF;
			}
			if(filingtype==2){
			sql=SELECT_CASE_ALL_PET_TOT_DF;
			}
			if(filingtype==4){
			sql=SELECT_CASE_ALL_PET_TOT_CNTF;
			}
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		//final String sql5=SUBDIVISION_NAME;
			List<Cases> CasesList=new ArrayList<Cases>() ;
		try {
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();
			if(sql!=null){
			
				CasesList = jdbcTemplate.query(sql, new Object[] {
						petitionerId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					cases.setFilingDate(rs.getString(13));
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					
					
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setContactName(rs.getString(23));
					cases.setContactPhone(rs.getString(24));
					cases.setHearingDate(rs.getString(25));
					
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
				
				
					
					return cases;

				}

			});
			}   //System.out.println("CasesgenCourtList"+CasesList);
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}

	
}
