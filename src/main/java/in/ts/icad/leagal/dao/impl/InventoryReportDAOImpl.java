package in.ts.icad.leagal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ts.icad.leagal.dao.InventoryReportDAO;
import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.model.DamInspectDocs;
import in.ts.icad.leagal.model.InvResAbstract;
import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankInspect;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.PumpMaintainActivities;
import in.ts.icad.leagal.model.PumpStations;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.ReservoirUnitData;
import in.ts.icad.leagal.model.ScheduleDuty;
import in.ts.icad.leagal.model.Tanks;
import in.ts.icad.leagal.model.User;

@Repository
public class InventoryReportDAOImpl implements InventoryReportDAO {

	private JdbcTemplate jdbcTemplate7;
	private JdbcTemplate jdbcTemplate8;

	@Resource(name = "dataSource7")
	public void setDataSource7(DataSource dataSource7) {
		this.jdbcTemplate7 = new JdbcTemplate(dataSource7);
	}

	
	@Resource(name = "dataSource8")
	public void setDataSource8(DataSource dataSource8) {
		this.jdbcTemplate8 = new JdbcTemplate(dataSource8);
	}

	
	
	@Value("${SELECT_RES_ABSTRACT}")
	private String SELECT_RES_ABSTRACT;

	@Value("${SELECT_RES_TOTAL}")
	private String SELECT_RES_TOTAL;

	@Value("${SELECT_RES_ONGOING}")
	private String SELECT_RES_ONGOING;

	@Value("${SELECT_RES_COMPLETED}")
	private String SELECT_RES_COMPLETED;

	@Value("${SELECT_RES_INFO_BYRESCODE}")
	private String SELECT_RES_INFO_BYRESCODE;

	@Value("${SELECT_RES_BYUNIT_TOTAL_PDF}")
	private String SELECT_RES_BYUNIT_TOTAL_PDF;

	
	
	
	
	@Value("${SELECT_RES_BYUNIT_ONGOING_PDF}")
	private String SELECT_RES_BYUNIT_ONGOING_PDF;
	
	@Value("${SELECT_RES_BYUNIT_COMPLETED_PDF}")
	private String SELECT_RES_BYUNIT_COMPLETED_PDF;
	
	@Value("${SELECT_RES_RESCODE_PDF}")
	private String SELECT_RES_RESCODE_PDF;
	
	
	@Value("${SELECT_TANK_CHECKS_ABSTRACT_DISTRICT}")
	private String SELECT_TANK_CHECKS_ABSTRACT_DISTRICT;
	
	@Value("${SELECT_TANK_ABSTRACT_DETAIL}")
	private String SELECT_TANK_ABSTRACT_DETAIL;
	
	@Value("${SELECT_TANK_ABSTRACT_TANKINFO}")
	private String SELECT_TANK_ABSTRACT_TANKINFO;
	
	@Value("${SELECT_TANK_ABSTRACT_EMBINFO}")
	private String SELECT_TANK_ABSTRACT_EMBINFO;
	
	@Value("${SELECT_INVOM_RES_ABSTRACT_UNIT}")
	private String SELECT_INVOM_RES_ABSTRACT_UNIT;
	
	
	@Value("${SELECT_INVOM_RES_TOTAL}")
	private String SELECT_INVOM_RES_TOTAL;
	
	@Value("${SELECT_INVOM_RES_ONGOING}")
	private String SELECT_INVOM_RES_ONGOING;
	
	@Value("${SELECT_INVOM_RES_COMPLETED}")
	private String SELECT_INVOM_RES_COMPLETED;
	
	@Value("${SELECT_INVOM_RES_ANN1_BY_RESCODE}")
	private String SELECT_INVOM_RES_ANN1_BY_RESCODE;
	
	@Value("${SELECT_RES_ANN1_DETAIL_TABINFO}")
	private String SELECT_RES_ANN1_DETAIL_TABINFO;
	
	@Value("${SELECT_RES_ANN2_ABSTRACT}")
	private String SELECT_RES_ANN2_ABSTRACT;
	
	@Value("${SELECT_INVOM_RES_ANN2_BY_RESCODE}")
	private String SELECT_INVOM_RES_ANN2_BY_RESCODE;
	
	@Value("${SELECT_RES_ANN2_DETAIL_TABINFO}")
	private String SELECT_RES_ANN2_DETAIL_TABINFO;
	
	
	@Value("${SELECT_SCH_AEE_DAILY}")
	private String SELECT_SCH_AEE_DAILY;
	
	@Value("${SELECT_SCH_AEE_WEEKLY}")
	private String SELECT_SCH_AEE_WEEKLY;
	
	
	@Value("${SELECT_SCH_AEE_DAILY_RES_INFO}")
	private String SELECT_SCH_AEE_DAILY_RES_INFO;
	
	
	@Value("${SELECT_SCH_INSPECT_INFO}")
	private String SELECT_SCH_INSPECT_INFO;
	
	
	@Value("${SELECT_PMP_MAIN_DAILY}")
	private String SELECT_PMP_MAIN_DAILY;
	
	
	@Value("${SELECT_PUMP_MAINTAIN_PUMP_INFO}")
	private String SELECT_PUMP_MAINTAIN_PUMP_INFO;
	
	@Value("${SELECT_PUMP_MAINTAIN_INSPECT_INFO}")
	private String SELECT_PUMP_MAINTAIN_INSPECT_INFO;
	
	@Value("${SELECT_PMP_MAIN_WEEKLY}")
	private String SELECT_PMP_MAIN_WEEKLY;
	
	@Value("${GET_INOUT_BY_TANKID_YEAR}")
	private String GET_INOUT_BY_TANKID_YEAR;
	
	
	@Value("${GET_MI_REPAIR_BY_TANKID_YEAR}")
	private String GET_MI_REPAIR_BY_TANKID_YEAR;
	
	@Value("${GET_MI_CAPACITY_BY_TANKID_YEAR}")
	private String GET_MI_CAPACITY_BY_TANKID_YEAR;
	
	
	@Value("${SELECT_TANK_UNIT_ABSTRACT_STATUS}")
	private String SELECT_TANK_UNIT_ABSTRACT_STATUS;
	
	
	@Value("${SELECT_TANK_UNIT_ABSTRACT_DETAIL}")
	private String SELECT_TANK_UNIT_ABSTRACT_DETAIL;
	
	
	@Value("${GET_TANK_ABSTRACT_AYACUT_CAPACITY}")
	private String GET_TANK_ABSTRACT_AYACUT_CAPACITY;
	
	@Value("${SELECT_TANK_CAP_AYACUT_DETAIL}")
	private String SELECT_TANK_CAP_AYACUT_DETAIL;
	
	@Value("${SELECT_TANK_SE_ABSTRACT_STATUS}")
	private String SELECT_TANK_SE_ABSTRACT_STATUS;
	
	@Value("${SELECT_TANK_DIV_ABSTRACT_STATUS}")
	private String SELECT_TANK_DIV_ABSTRACT_STATUS;
	
	@Value("${SELECT_TANK_SUB_DIV_ABSTRACT_STATUS}")
	private String SELECT_TANK_SUB_DIV_ABSTRACT_STATUS;
	
	@Value("${SELECT_TANK_EMP_SD_ABSTRACT_STATUS}")
	private String SELECT_TANK_EMP_SD_ABSTRACT_STATUS;
	
	
	@Value("${GET_TANK_EMP_SD_ABSTRACT_AYACUT_CAPACITY}")
	private String GET_TANK_EMP_SD_ABSTRACT_AYACUT_CAPACITY;
	
	@Value("${GET_TANK_SUB_DIV_ABSTRACT_AYACUT_CAPACITY}")
	private String GET_TANK_SUB_DIV_ABSTRACT_AYACUT_CAPACITY;
	
	@Value("${GET_TANK_DIV_ABSTRACT_AYACUT_CAPACITY}")
	private String GET_TANK_DIV_ABSTRACT_AYACUT_CAPACITY;
	
	@Value("${GET_TANK_SE_ABSTRACT_AYACUT_CAPACITY}")
	private String GET_TANK_SE_ABSTRACT_AYACUT_CAPACITY;
	
	@Value("${GET_TANK_UNIT_ABSTRACT_AYACUT_CAPACITY}")
	private String GET_TANK_UNIT_ABSTRACT_AYACUT_CAPACITY; 
	
	@Value("${SELECT_TANK_FORM20_ABSTRACT_DETAIL}")
	private String SELECT_TANK_FORM20_ABSTRACT_DETAIL; 
	
	@Value("${GET_TANK_UNIT_FORM20_ABSTRACT}")
	private String GET_TANK_UNIT_FORM20_ABSTRACT; 
	
	@Value("${GET_TANK_SE_FORM20_ABSTRACT}")
	private String GET_TANK_SE_FORM20_ABSTRACT; 
	
	@Value("${GET_TANK_DIV_FORM20_ABSTRACT}")
	private String GET_TANK_DIV_FORM20_ABSTRACT;
	
	@Value("${GET_TANK_SUB_DIV_FORM20_ABSTRACT}")
	private String GET_TANK_SUB_DIV_FORM20_ABSTRACT;
	
	@Value("${GET_TANK_EMP_SD_FORM20_ABSTRACT}")
	private String GET_TANK_EMP_SD_FORM20_ABSTRACT;
	
	@Value("${FORM20_TANK_DATA_PDF_BY_ID}")
	private String FORM20_TANK_DATA_PDF_BY_ID;
	
	@Value("${FORM20_TANK_DETAILLIST_PDF_BY_ID}") 
	private String FORM20_TANK_DETAILLIST_PDF_BY_ID;
	
	@Value("${FORM20_ALL_DOCS_BY_FORMID}")
	private String FORM20_ALL_DOCS_BY_FORMID;
	
	@Value("${SELECT_FORM20_YEAR}")
	private String SELECT_FORM20_YEAR;
	
	@Value("${SELECT_MI_TANK_YEAR}")
	private String SELECT_MI_TANK_YEAR;
	
	
	@Value("${SELECT_INVOM_RES_CHECKS}")
	private String SELECT_INVOM_RES_CHECKS;
	
	
	@Value("${SELECT_INVOM_RES_CATEGORY}")
	private String SELECT_INVOM_RES_CATEGORY;
	
	
	@Value("${SELECT_RES_ANN1_MST2_PDF}")
	private String SELECT_RES_ANN1_MST2_PDF;
	
	
	@Value("${GET_TANK_DISTRICT_FORM20_ABSTRACT}")
	private String GET_TANK_DISTRICT_FORM20_ABSTRACT;
	
	
	
	
	
	@Value("${SELECT_RESERVOIR_ABSTRACT_DETAIL}")
	private String SELECT_RESERVOIR_ABSTRACT_DETAIL;
	
	
	@Value("${SELECT_CANAL_FORM20_ABSTRACT_DETAIL}")
	private String SELECT_CANAL_FORM20_ABSTRACT_DETAIL;
	
	
	@Value("${FORM20_RES_DATA_PDF_BY_ID}")
	private String FORM20_RES_DATA_PDF_BY_ID;
	
	
	@Value("${FORM20_CANAL_DATA_PDF_BY_ID}")
	private String FORM20_CANAL_DATA_PDF_BY_ID;
	
	
	@Value("${GET_RES_ANN_RECOMMEND_BY_MST1ID}")
	private String GET_RES_ANN_RECOMMEND_BY_MST1ID;
	
	
	@Value("${GET_RES_INSPECT_INFO_UNIT_ID}")
	private String GET_RES_INSPECT_INFO_UNIT_ID;
	
	@Value("${GET_DAM_MST1_REMARKS_MST1ID}")
	private String GET_DAM_MST1_REMARKS_MST1ID;
	
	@Value("${GET_DAM_HEALTH_BY_MST1ID_REPORT}")
	private String GET_DAM_HEALTH_BY_MST1ID_REPORT;
	
	
	@Value("${GET_DAM_INSPECT_PHOTOS_MST1_REPORT}")
	private String GET_DAM_INSPECT_PHOTOS_MST1_REPORT;
	
	
	@Value("${SELECT_INVOM_RES_ABSTRACT_CIRCLE}")
	private String SELECT_INVOM_RES_ABSTRACT_CIRCLE;
	
	@Value("${SELECT_INVOM_RES_ABSTRACT_DIVISION}")
	private String SELECT_INVOM_RES_ABSTRACT_DIVISION;
	
	
	@Value("${SELECT_INVOM_RES_ABSTRACT_SUBDIVISION}")
	private String SELECT_INVOM_RES_ABSTRACT_SUBDIVISION;
	
	
	@Value("${SELECT_INVOM_RES_ABSTRACT_EMP}")
	private String SELECT_INVOM_RES_ABSTRACT_EMP;
	
	
	@Value("${SELECT_INVOM_RES_ONGOING_UNIT}")
	private String SELECT_INVOM_RES_ONGOING_UNIT;
	
	@Value("${SELECT_INVOM_RES_ONGOING_CIRCLE}")
	private String SELECT_INVOM_RES_ONGOING_CIRCLE;
	
	@Value("${SELECT_INVOM_RES_ONGOING_DIVISION}")
	private String SELECT_INVOM_RES_ONGOING_DIVISION;
	
	@Value("${SELECT_INVOM_RES_ONGOING_SUBDIVISION}")
	private String SELECT_INVOM_RES_ONGOING_SUBDIVISION;
	
	@Value("${SELECT_INVOM_RES_ONGOING_POST}")
	private String SELECT_INVOM_RES_ONGOING_POST;
	
	
	@Value("${SELECT_NRLD_RES_TOTAL}")
	private String SELECT_NRLD_RES_TOTAL;
	
	@Value("${SELECT_CAT_RES_ABSTRACT_UNIT}")
	private String SELECT_CAT_RES_ABSTRACT_UNIT;
	
	@Value("${SELECT_CAT_RES_ABSTRACT_CIRCLE}")
	private String SELECT_CAT_RES_ABSTRACT_CIRCLE;
	
	@Value("${SELECT_CAT_RES_ABSTRACT_DIVISION}")
	private String SELECT_CAT_RES_ABSTRACT_DIVISION;
	
	@Value("${SELECT_CAT_RES_ABSTRACT_SUBDIVISION}")
	private String SELECT_CAT_RES_ABSTRACT_SUBDIVISION;
	
	@Value("${SELECT_CAT_RES_DETAILS}")
	private String SELECT_CAT_RES_DETAILS;
	
	@Value("${SELECT_CAT_NA_RES_DETAILS}")
	private String SELECT_CAT_NA_RES_DETAILS;
	
	@Value("${GET_RES_CAT_INSPECT_INFO_UNIT_ID}")
	private String GET_RES_CAT_INSPECT_INFO_UNIT_ID;
	
	
	@Value("${GET_RES_CATNA_INSPECT_INFO_UNIT_ID}")
	private String GET_RES_CATNA_INSPECT_INFO_UNIT_ID;
	
	@Value("${SELECT_ALL_NRLD_RES_TOTAL}")
	private String SELECT_ALL_NRLD_RES_TOTAL;
	
	@Value("${SELECT_CAT_RES_ABSTRACT_EMP}")
	private String SELECT_CAT_RES_ABSTRACT_EMP;
	
	@Value("${GET_RES_HEALTH_INFO_UNIT_ID}")
	private String GET_RES_HEALTH_INFO_UNIT_ID;
	
	
	@Value("${GET_DAM_SALIENT_BY_MST1ID_REPORT}")
	private String GET_DAM_SALIENT_BY_MST1ID_REPORT;
	
	@Value("${GET_TANKS_SALIENT_BY_MST1ID_REPORT}")
	private String GET_TANKS_SALIENT_BY_MST1ID_REPORT;
	
	@Value("${SELECT_RES_DAM_SAFETY_YR}")
	private String SELECT_RES_DAM_SAFETY_YR;
	
	@Value("${GET_TANK_UNIT_FDR_ABSTRACT}")
	private String GET_TANK_UNIT_FDR_ABSTRACT;
	
	@Value("${GET_TANK_SE_FDR_ABSTRACT}")
	private String GET_TANK_SE_FDR_ABSTRACT;
	
	@Value("${GET_TANK_DIV_FDR_ABSTRACT}")
	private String GET_TANK_DIV_FDR_ABSTRACT;
	
	@Value("${GET_TANK_SUB_DIV_FDR_ABSTRACT}")
	private String GET_TANK_SUB_DIV_FDR_ABSTRACT;
	
	@Value("${GET_TANK_EMP_SD_FDR_ABSTRACT}")
	private String GET_TANK_EMP_SD_FDR_ABSTRACT;
	
	@Value("${SELECT_TANK_FDR_ABSTRACT_DETAIL}")
	private String SELECT_TANK_FDR_ABSTRACT_DETAIL;
	
	@Value("${SELECT_RESERVOIR_FDR_ABSTRACT_DETAIL}")
	private String SELECT_RESERVOIR_FDR_ABSTRACT_DETAIL;
	
	
	@Value("${SELECT_CANAL_FDR_ABSTRACT_DETAIL}")
	private String SELECT_CANAL_FDR_ABSTRACT_DETAIL;
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public List<InvResAbstract> getResAbstractList() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_ABSTRACT;
		try {

			List<InvResAbstract> invResAbstractList = jdbcTemplate7.query(sql, new RowMapper<InvResAbstract>() {

				public InvResAbstract mapRow(ResultSet rs, int rowNum) throws SQLException {

					InvResAbstract invResAbstract = new InvResAbstract();
					invResAbstract.setUnitId(rs.getInt(1));
					invResAbstract.setResTotalCount(rs.getInt(2));
					invResAbstract.setResOngoingCount(rs.getInt(3));
					invResAbstract.setResCompleted(rs.getInt(4));
					invResAbstract.setUnitName(rs.getString(5));

					return invResAbstract;
				}

			});
			jdbcTemplate7.getDataSource().getConnection().close();
			return invResAbstractList;
		} catch (Exception exc) {

			return null;
		}
	}

	@Override
	public List<ReservoirUnitData> getrestotalList(Integer unitId, Integer resStatus) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = null;
		
		//System.out.println("resStatus"+resStatus);

		if (resStatus != null) {

			if (resStatus >= 0) {

				if (resStatus == 0) {

					sql = SELECT_RES_TOTAL;

				}
				if (resStatus == 1) {

					sql = SELECT_RES_ONGOING;

				}
				if (resStatus == 2) {

					sql = SELECT_RES_COMPLETED;

				}

			}
		}
		try {

			
			//System.out.println("sql"+sql);
			List<ReservoirUnitData> reservoirUnitDataList = jdbcTemplate7.query(sql,new Object[]{unitId}, new RowMapper<ReservoirUnitData>() {

				public ReservoirUnitData mapRow(ResultSet rs, int rowNum) throws SQLException {

					ReservoirUnitData reservoirUnitData = new ReservoirUnitData();
					reservoirUnitData.setUnitId(rs.getInt(1));
					reservoirUnitData.setReservoirId(rs.getString(2));
					reservoirUnitData.setResName(rs.getString(3));
					reservoirUnitData.setUnitName(rs.getString(4));
					reservoirUnitData.setCircleName(rs.getString(5));
					reservoirUnitData.setDivisionName(rs.getString(6));
					reservoirUnitData.setSubdivisionName(rs.getString(7));
					reservoirUnitData.setProjectName(rs.getString(8));
					reservoirUnitData.setPackName(rs.getString(9));
					reservoirUnitData.setResStatus(rs.getString(10));
					

					return reservoirUnitData;
				}

			});
			jdbcTemplate7.getDataSource().getConnection().close();
			return reservoirUnitDataList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	
	@Override
	public ReservoirSalient getResInfoBYCode(String rescode) throws InventoryUserException {
		
		//System.out.println("impl"+rescode);
		// TODO Auto-generated method stub
		String sql = SELECT_RES_INFO_BYRESCODE;
		
		String val=rescode.replace("\"", "");
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
            //System.out.println("sql"+sql);
			ReservoirSalient ReservoirSalientList = (ReservoirSalient) jdbcTemplate7.queryForObject(sql,new Object[] { val},
					new RowMapper<Object>(){

						public Object mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							
							

							ReservoirSalient reservoirSalient = new ReservoirSalient();
							reservoirSalient.setResCode(rs.getString(1));
							reservoirSalient.setResName(rs.getString(2));
							reservoirSalient.setSourceId(rs.getInt(3));
							reservoirSalient.setWaterSpreadArea(rs.getDouble(4));
							reservoirSalient.setResLatitude(rs.getString(5));
							reservoirSalient.setResLongitude(rs.getString(6));
							reservoirSalient.setResStatusId(rs.getInt(7));
							reservoirSalient.setHydroPower(rs.getDouble(8));
							reservoirSalient.setLandAcquistion(rs.getDouble(9));
							reservoirSalient.setCatchmentArea(rs.getDouble(10));
							reservoirSalient.setMwlCapacity(rs.getDouble(11));
							reservoirSalient.setFrlCapacity(rs.getDouble(12));
							reservoirSalient.setMddlCapacity(rs.getDouble(13));
							reservoirSalient.setDeadstorageCapacity(rs.getDouble(14));
							reservoirSalient.setTrlLevel(rs.getDouble(15));
							reservoirSalient.setFrlLevel(rs.getDouble(16));
							reservoirSalient.setMwlLevel(rs.getDouble(17));
							reservoirSalient.setMddlLevel(rs.getDouble(18));
							reservoirSalient.setDeadstorageLevel(rs.getDouble(19));
							reservoirSalient.setSpillwayLength(rs.getDouble(20));
							reservoirSalient.setNonoverflowLength(rs.getDouble(21));
							reservoirSalient.setMaxhtSpillWay(rs.getDouble(22));
							reservoirSalient.setTopWidthDam(rs.getDouble(23));
							reservoirSalient.setMaxbaseWidthDam(rs.getDouble(24));
							reservoirSalient.setClearBridgeWidth(rs.getDouble(25));
							reservoirSalient.setStillingBasinLength(rs.getDouble(26));
							
							reservoirSalient.setDeepestfoundationLevel(rs.getDouble(27));
							reservoirSalient.setAvgRiverbedLevel(rs.getDouble(28));
							reservoirSalient.setSpillWayCrestLevel(rs.getDouble(29));
							reservoirSalient.setBridgeTopLevel(rs.getDouble(30));
							reservoirSalient.setInvertLevel(rs.getDouble(31));
							reservoirSalient.setStillingBasinLevel(rs.getDouble(32));
							reservoirSalient.setEarthdamLeftLength(rs.getDouble(33));
							reservoirSalient.setEarthdamRightLength(rs.getDouble(34));
							reservoirSalient.setMaxHeight(rs.getDouble(35));
							reservoirSalient.setMasonarydamLength(rs.getDouble(36));
							reservoirSalient.setRockfilldamLength(rs.getDouble(37));
							reservoirSalient.setConcretedamLength(rs.getDouble(38));
							reservoirSalient.setZonalSectionLength(rs.getDouble(39));
							reservoirSalient.setHomogeneousSectionLength(rs.getDouble(40));
							reservoirSalient.setMaxfloodDischarge(rs.getDouble(41));
							reservoirSalient.setUserId(rs.getInt(42));
							reservoirSalient.setUserName(rs.getString(43));
							reservoirSalient.setResStatus(rs.getString(44));
							
							
							
							
							
							return reservoirSalient;
						}

					});
			
			// System.out.println("sql"+sql);
			jdbcTemplate7.getDataSource().getConnection().close();
			
			//System.out.println("impl2"+ReservoirSalientList);
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirSalient> resinfopdf(Integer unitId, Integer resStatus) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = null;
		
		//System.out.println("resStatus"+resStatus);

		if (resStatus != null) {

			if (resStatus >= 0) {

				if (resStatus == 0) {

					sql = SELECT_RES_BYUNIT_TOTAL_PDF;

				}
				if (resStatus == 1) {

					sql = SELECT_RES_BYUNIT_ONGOING_PDF;

				}
				if (resStatus == 2) {

					sql = SELECT_RES_BYUNIT_COMPLETED_PDF;

				}

			}
		}
		try {

			
		//	System.out.println("sql"+sql);
			List<ReservoirSalient> reservoirSalientList = jdbcTemplate7.query(sql,new Object[]{unitId}, new RowMapper<ReservoirSalient>() {

				public ReservoirSalient mapRow(ResultSet rs, int rowNum) throws SQLException {


					ReservoirSalient reservoirSalient = new ReservoirSalient();
					reservoirSalient.setResCode(rs.getString(1));
					reservoirSalient.setResName(rs.getString(2));
					reservoirSalient.setSourceId(rs.getInt(3));
					reservoirSalient.setWaterSpreadArea(rs.getDouble(4));
					reservoirSalient.setResLatitude(rs.getString(5));
					reservoirSalient.setResLongitude(rs.getString(6));
					reservoirSalient.setResStatusId(rs.getInt(7));
					reservoirSalient.setHydroPower(rs.getDouble(8));
					reservoirSalient.setLandAcquistion(rs.getDouble(9));
					reservoirSalient.setCatchmentArea(rs.getDouble(10));
					reservoirSalient.setMwlCapacity(rs.getDouble(11));
					reservoirSalient.setFrlCapacity(rs.getDouble(12));
					reservoirSalient.setMddlCapacity(rs.getDouble(13));
					reservoirSalient.setDeadstorageCapacity(rs.getDouble(14));
					reservoirSalient.setTrlLevel(rs.getDouble(15));
					reservoirSalient.setFrlLevel(rs.getDouble(16));
					reservoirSalient.setMwlLevel(rs.getDouble(17));
					reservoirSalient.setMddlLevel(rs.getDouble(18));
					reservoirSalient.setDeadstorageLevel(rs.getDouble(19));
					reservoirSalient.setSpillwayLength(rs.getDouble(20));
					reservoirSalient.setNonoverflowLength(rs.getDouble(21));
					reservoirSalient.setMaxhtSpillWay(rs.getDouble(22));
					reservoirSalient.setTopWidthDam(rs.getDouble(23));
					reservoirSalient.setMaxbaseWidthDam(rs.getDouble(24));
					reservoirSalient.setClearBridgeWidth(rs.getDouble(25));
					reservoirSalient.setStillingBasinLength(rs.getDouble(26));
					
					reservoirSalient.setDeepestfoundationLevel(rs.getDouble(27));
					reservoirSalient.setAvgRiverbedLevel(rs.getDouble(28));
					reservoirSalient.setSpillWayCrestLevel(rs.getDouble(29));
					reservoirSalient.setBridgeTopLevel(rs.getDouble(30));
					reservoirSalient.setInvertLevel(rs.getDouble(31));
					reservoirSalient.setStillingBasinLevel(rs.getDouble(32));
					reservoirSalient.setEarthdamLeftLength(rs.getDouble(33));
					reservoirSalient.setEarthdamRightLength(rs.getDouble(34));
					reservoirSalient.setMaxHeight(rs.getDouble(35));
					reservoirSalient.setMasonarydamLength(rs.getDouble(36));
					reservoirSalient.setRockfilldamLength(rs.getDouble(37));
					reservoirSalient.setConcretedamLength(rs.getDouble(38));
					reservoirSalient.setZonalSectionLength(rs.getDouble(39));
					reservoirSalient.setHomogeneousSectionLength(rs.getDouble(40));
					reservoirSalient.setMaxfloodDischarge(rs.getDouble(41));
					reservoirSalient.setUserId(rs.getInt(42));
					reservoirSalient.setUserName(rs.getString(43));
					reservoirSalient.setResStatus(rs.getString(44));
					
					return reservoirSalient;
				}

			});
			jdbcTemplate7.getDataSource().getConnection().close();
			
		//System.out.println("reservoirSalientPDF"+reservoirSalientList);
			return reservoirSalientList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	@Override
	public List<ReservoirUnitData> getresinfoBycodePDF() throws InventoryUserException {
		// TODO Auto-generated method stub
		

             String sql = SELECT_RES_RESCODE_PDF;
		
		//String val=resCode.replace("\"", "");
		try {

			
			//System.out.println("sql"+sql);
			List<ReservoirUnitData> reservoirUnitDataList = jdbcTemplate7.query(sql, new RowMapper<ReservoirUnitData>() {

				public ReservoirUnitData mapRow(ResultSet rs, int rowNum) throws SQLException {

					ReservoirUnitData reservoirUnitData = new ReservoirUnitData();
					
					reservoirUnitData.setReservoirId(rs.getString(1));
					reservoirUnitData.setUnitId(rs.getInt(2));
					
					
					reservoirUnitData.setUnitName(rs.getString(3));
					reservoirUnitData.setCircleName(rs.getString(4));
					reservoirUnitData.setDivisionName(rs.getString(5));
					reservoirUnitData.setSubdivisionName(rs.getString(6));
					reservoirUnitData.setProjectName(rs.getString(7));
					reservoirUnitData.setPackName(rs.getString(8));
					
					

					return reservoirUnitData;
				}

			});
			jdbcTemplate7.getDataSource().getConnection().close();
			//System.out.println("reservoirUnitDataList"+reservoirUnitDataList);
			return reservoirUnitDataList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	@Override
	public List<MiTankInspect> getMiTankChecksAbstract(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =SELECT_TANK_CHECKS_ABSTRACT_DISTRICT ; 
		
		Integer year=0;
		Integer freqId=0;
		try {
if(miinspect.getYear()!=null){
				
				if(miinspect.getYear()>0){
					year=miinspect.getYear();
				}
}

if(miinspect.getMiTankFreqId()!=null){
	
	if(miinspect.getMiTankFreqId()>0){
		freqId=miinspect.getMiTankFreqId();
		
		
	}
}


			
		//System.out.println("year"+sql+""+year);	
		List<MiTankInspect> scheduleofDutiesList = jdbcTemplate8.query(sql,new Object[]{year,freqId},
				new RowMapper<MiTankInspect>() {

					public MiTankInspect mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						
						

						MiTankInspect sd = new MiTankInspect();
						
						
						//System.out.println("rs.getInt(1)"+rs.getInt(1));
					
						sd.setDistrictName(rs.getString(1));
						sd.setNewDistrictId(rs.getInt(2));
						sd.setTotalCount(rs.getInt(3));
						sd.setEmergencyCount(rs.getInt(4));
						sd.setObserveCount(rs.getInt(5));
						sd.setOriginalworkCount(rs.getInt(6));
						sd.setDefferedCount(rs.getInt(7));
						sd.setMiTankFreqId(rs.getInt(8));
						sd.setYear(rs.getInt(9));
						//sd.setMiInpsectMst1Id(rs.getInt(10));
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		return scheduleofDutiesList;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<MiTankInspect> getMiTankChecksAbstractDetail(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =null;
		
	
		try {
if(miinspect.getNewDistrictId()!=null && miinspect.getMiTankFreqId()!=null ){
				
				if ( miinspect.getNewDistrictId()>0 && miinspect.getMiTankFreqId()>0){
				
					sql=SELECT_TANK_ABSTRACT_DETAIL+" and imt1.new_district_id="+miinspect.getNewDistrictId()+" and mi_check_frequency_id="+miinspect.getMiTankFreqId(); 
				}
				
				

			
				

if(miinspect.getMiTankFreqId()!=null && miinspect.getNewDistrictId()==0 ){
	
	sql=SELECT_TANK_ABSTRACT_DETAIL+ " and  imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId() ;
}
				}
			
		//System.out.println("year"+sql+""+miinspect.getMiTankFreqId());	
		List<MiTankInspect> scheduleofDutiesList = jdbcTemplate8.query(sql,
				new RowMapper<MiTankInspect>() {

					public MiTankInspect mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						
						

						MiTankInspect sd = new MiTankInspect();
						
						
						//System.out.println("rs.getInt(1)"+rs.getInt(1));
						sd.setTankId(rs.getLong(1));
						sd.setUnitId(rs.getInt(2));
						sd.setCircleId(rs.getInt(3));
						sd.setDivisionId(rs.getInt(4));
						sd.setSubdivisionId(rs.getInt(5));
					
						sd.setNewDistrictId(rs.getInt(6));
						sd.setYear(rs.getInt(7));
						sd.setMiTankFreqId(rs.getInt(8));
						sd.setTankName(rs.getString(9));
						sd.setDistrictName(rs.getString(10));
						sd.setUnitName(rs.getString(11));
						sd.setCircleName(rs.getString(12));
						sd.setDivisionName(rs.getString(13));
						sd.setSubdivisionName(rs.getString(14));
						sd.setActivityFrequency(rs.getString(15));
						sd.setMiInpsectMst1Id(rs.getInt(16));
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		return scheduleofDutiesList;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<MiTankInspect> getMiTankUnitAbstractDetail(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =SELECT_TANK_UNIT_ABSTRACT_DETAIL;
		Integer	year=0;
		Integer unitId=0;
		Integer freqId=0;
		String sql1=null;
		String sqlUt=null;
		
		String sql2="  and imt1.circle_id="+miinspect.getCircleId()+"  and imt1.division_id="+miinspect.getDivisionId()+"  and imt1.subdivision_id="+miinspect.getSubdivisionId()+"  and imt1.tank_status_id="+miinspect.getTankStatusId() ;
		String sql3=" and imt1.tank_status_id in (1,2,3,4)  and imt1.circle_id="+miinspect.getCircleId()+"  and imt1.division_id="+miinspect.getDivisionId()+"  and imt1.subdivision_id="+miinspect.getSubdivisionId()  ;
	
		try {
if(miinspect.getUnitId()!=null && miinspect.getTankStatusId()!=null && miinspect.getYear()!=null && miinspect.getMiTankFreqId()!=null ){
	
		year= miinspect.getYear();
		unitId=miinspect.getUnitId();
		freqId=miinspect.getMiTankFreqId();
		sqlUt= sql+ "and imt1.unit_id="+unitId;
				if(miinspect.getTankStatusId()>0 && miinspect.getTankStatusId()!=5){
					if(miinspect.getUnitId()!=4){
					if((miinspect.getDesignationId()==2||miinspect.getDesignationId()==8 ||miinspect.getDesignationId()==4 ) && (miinspect.getSubdivisionId()>0 && miinspect.getPostId()>0)){
				
					sql1=sqlUt+sql2+"  and imt1.post_id="+miinspect.getPostId(); 
				}
				//in the drill down reports of higher offices --postId is zero and subdivision has value , in case of direct dee login postId is >0
					if((miinspect.getDesignationId()==4 ) && (miinspect.getSubdivisionId()>0 && miinspect.getPostId()==0 )){
						
						sql1=sqlUt+ sql2 ;
					}
					
if((miinspect.getDesignationId()==5 ) && (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()>0) && (miinspect.getDivisionId()>0 ) && (miinspect.getSubdivisionId()==0 )){
						
						sql1=sqlUt+ "  and imt1.circle_id="+miinspect.getCircleId()+"  and imt1.division_id="+miinspect.getDivisionId()+"  and imt1.tank_status_id="+miinspect.getTankStatusId();  
					}

if( (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()>0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubdivisionId()==0 )){
	
	sql1=sqlUt+"  and imt1.circle_id="+miinspect.getCircleId()+"  and imt1.tank_status_id="+miinspect.getTankStatusId();  
}
					}

if(miinspect.getUnitId()!=4 && miinspect.getUnitId() !=9832  &&  miinspect.getUnitId()!=9830 ) {
if( (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()==0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubdivisionId()==0 )){
	
	sql1=sqlUt+"   and imt1.tank_status_id="+miinspect.getTankStatusId(); 
}
}
if( ((miinspect.getUnitId()>0 )&& (miinspect.getUnitId()==4 || miinspect.getUnitId() ==9832 || miinspect.getUnitId()==9830) && (miinspect.getCircleId()==0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubdivisionId()==0 ))
		||(miinspect.getUnitId()==4 && miinspect.getCircleId()==104 && miinspect.getDivisionId()==30327&& miinspect.getDesignationId()==5)
		||(miinspect.getUnitId()==9832 && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getDesignationId()==5)
		||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609  && miinspect.getDivisionId()==0 && miinspect.getDesignationId()==7)
		||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609  && miinspect.getDivisionId()==31099 && miinspect.getDesignationId()==5)
		
		){
	
	sql1=sql+"   and imt1.tank_status_id="+miinspect.getTankStatusId(); 
}
				}
				if(miinspect.getTankStatusId()>0 && miinspect.getTankStatusId()==5){
					if(unitId!=4){
					
					if((miinspect.getDesignationId()==2||miinspect.getDesignationId()==8  || (miinspect.getDesignationId()==4 ) ) && (miinspect.getSubdivisionId()>0 && miinspect.getPostId()>0)){
						
						sql1=sqlUt+sql3+"  and imt1.post_id="+miinspect.getPostId()  ; 
					}
					
if((miinspect.getDesignationId()==4 ) && (miinspect.getSubdivisionId()>0 && miinspect.getPostId()==0)){
						
						sql1=sqlUt+ sql3;
					}
					//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


if((miinspect.getDesignationId()==5 ) && (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()>0) && (miinspect.getDivisionId()>0 ) && (miinspect.getSubdivisionId()==0 )){
	
	sql1=sqlUt +" and imt1.tank_status_id in (1,2,3,4)  and imt1.circle_id="+miinspect.getCircleId()+"  and imt1.division_id="+miinspect.getDivisionId(); 
}
					
if( (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()>0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubdivisionId()==0 )){

sql1=sqlUt+" and imt1.tank_status_id in (1,2,3,4)  and imt1.circle_id="+miinspect.getCircleId(); 
}
					}

	if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
if( (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()==0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubdivisionId()==0 )){

sql1=sqlUt+" and imt1.tank_status_id in (1,2,3,4) "; 
}
	}
if( ((miinspect.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830) && (miinspect.getCircleId()==0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubdivisionId()==0 ))
		||(miinspect.getUnitId()==4 && miinspect.getCircleId()==104 && miinspect.getDivisionId()==30327&& miinspect.getDesignationId()==5)
		||(miinspect.getUnitId()==9832 && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getDesignationId()==5)
		||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609  && miinspect.getDivisionId()==0 && miinspect.getDesignationId()==7)
		||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609  && miinspect.getDivisionId()==31099 && miinspect.getDesignationId()==5)
		){

sql1=sql+" and imt1.tank_status_id in (1,2,3,4) "; 
}
				}
}

		//System.out.println("year "+sql1+" "+miinspect.getTankStatusId());	
		List<MiTankInspect> scheduleofDutiesList = jdbcTemplate8.query(sql1,new Object[]{freqId,year},
				new RowMapper<MiTankInspect>() {

					public MiTankInspect mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						MiTankInspect sd = new MiTankInspect();
						//System.out.println("rs.getInt(1)"+rs.getInt(1));
						sd.setTankId(rs.getLong(1));
						sd.setUnitId(rs.getInt(2));
						sd.setCircleId(rs.getInt(3));
						sd.setDivisionId(rs.getInt(4));
						sd.setSubdivisionId(rs.getInt(5));
						
						sd.setNewDistrictId(rs.getInt(6));
						sd.setYear(rs.getInt(7));
						sd.setMiTankFreqId(rs.getInt(8));
						sd.setTankName(rs.getString(9));
						sd.setDistrictName(rs.getString(10));
						sd.setUnitName(rs.getString(11));
						sd.setCircleName(rs.getString(12));
						sd.setDivisionName(rs.getString(13));
						sd.setSubdivisionName(rs.getString(14));
						sd.setActivityFrequency(rs.getString(15));
						sd.setMiInpsectMst1Id(rs.getInt(16));
						sd.setPostId(rs.getLong(17));
						
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		//System.out.println("getMiTankUnitAbstractDetail "+scheduleofDutiesList);	
		return scheduleofDutiesList;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public MiTankformData getform20TankDataByIdPdf(MiTankformData formData ) throws InventoryUserException {
		
		
		String sql=null;
		if(formData.getCatId()!=null){
			if(formData.getCatId()==1){
			
			sql = FORM20_TANK_DATA_PDF_BY_ID;
			}
			if(formData.getCatId()==2){
				
				sql = FORM20_RES_DATA_PDF_BY_ID;
				}
			
			if(formData.getCatId()==3){
				
				sql = FORM20_CANAL_DATA_PDF_BY_ID;
				}
		}
		
	
		try {
			MiTankformData prList = (MiTankformData) jdbcTemplate8.queryForObject(sql ,new Object[] { formData.getFormDataId() }, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					MiTankformData pr = new MiTankformData();
					pr.setTankId(rs.getInt(1));
					pr.setTankName(rs.getString(2));
					pr.setDistrictId(rs.getInt(3));
					pr.setDistrictName(rs.getString(4));
					pr.setConstituencyId(rs.getInt(5));
					pr.setConstituencyName(rs.getString(6));
					pr.setTsfcFormDate(rs.getString(7));
					pr.setFormDataId(rs.getInt(8));
					
					pr.setDamageCause(rs.getString(9));
					pr.setFrmBookValue(rs.getDouble(10));
					pr.setDamageDate(rs.getString(11));
				
					pr.setFrmProposed(rs.getString(12));//to check
					pr.setWriteOffValue(rs.getDouble(13));
					pr.setWriteOffAction(rs.getString(14));
					
					pr.setDamageBreaches(rs.getString(15));
					pr.setEffAyacutAcres(rs.getDouble(16));
					pr.setEffAyacutValue(rs.getDouble(17));
					
					pr.setApproxRepPermanent(rs.getDouble(18));
					pr.setApproxRepTemp(rs.getDouble(19));
					
					pr.setActionStdCrops(rs.getString(20));
					pr.setUsefulRemarks(rs.getString(21));
					
					pr.setRegLeftChnnAcres(rs.getDouble(22));
					pr.setRegRightChnnAcres(rs.getDouble(23));
					pr.setRegOthAcres(rs.getDouble(24));
					
					pr.setRainRGStation(rs.getString(25));
					pr.setRainQty(rs.getDouble(26));
					pr.setRainDate(rs.getString(27));
					pr.setQuartName(rs.getString(28));
					pr.setQuartType(rs.getString(29));
					
					pr.setBldgTypeName(rs.getString(30));
					pr.setBldgDescDamage(rs.getString(31));
					
					pr.setDamageTime(rs.getString(32));
					
					pr.setUnitId(rs.getInt(33));
					pr.setUnitName(rs.getString(34));
					
					pr.setCircleId(rs.getInt(35));
					pr.setCircleName(rs.getString(36));
					
					pr.setDivisionId(rs.getInt(37));
					pr.setDivisionName(rs.getString(38));
					
					pr.setSubDivisionId(rs.getInt(39));
					pr.setSubDivisionName(rs.getString(40));
					
					pr.setMandalId(rs.getInt(41));
					pr.setMandalName(rs.getString(42));
					
					pr.setVillageId(rs.getInt(43));
					//pr.setVillageName(rs.getString(44));
					pr.setApproxRepTotal(rs.getDouble(45));
					pr.setTankGeoId(rs.getLong(46));
					pr.setCatId(rs.getInt(47));
					
					
					if(rs.getInt(47)==2 ||  rs.getInt(47)==3){
					if(rs.getInt(43)>0){
						
						pr.setVillageName(rs.getString(44));
					}
					
	            if(rs.getInt(43)==0){
						
						pr.setVillageName(rs.getString(48));
					}
					}
					

					if(rs.getInt(47)==1){
					if(rs.getInt(43)>0){
						
						pr.setVillageName(rs.getString(44));
					}
					
	            if(rs.getInt(43)==0){
						
						pr.setVillageName(rs.getString(48));
					}
					}
					//pr.setIrrStrDmaPort(rs.getString(48));
					
			    return pr;

				}
            
			});
			jdbcTemplate8.getDataSource().getConnection().close();
			//System.out.println("prList"+prList);
			return prList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<MiTankFormDocs> getForm20AllDocs(MiTankformData formData)  throws InventoryUserException  {
		String sql = FORM20_ALL_DOCS_BY_FORMID;
		try {
			List<MiTankFormDocs> docList = jdbcTemplate8.query(sql ,new Object[] { formData.getFormDataId() }, new RowMapper<MiTankFormDocs>() {
				public MiTankFormDocs mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					MiTankFormDocs doc = new MiTankFormDocs();
				doc.setFormdocId(rs.getInt(1));
				doc.setFormDocOriginalName(rs.getString(2));
				doc.setFormDataId(rs.getInt(3));
				doc.setFormDocName(rs.getString(4));
				doc.setFormDocLocation(rs.getString(5));
			    return doc;
				}
			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return docList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<MiTankformData> getform20TankDetailListByIdPdf(MiTankformData formData) throws InventoryUserException {
		
		String sql = FORM20_TANK_DETAILLIST_PDF_BY_ID;
	
		try {
			
			
				List<MiTankformData> formdetailList = jdbcTemplate8.query(sql ,new Object[] { formData.getFormDataId() }, new RowMapper<MiTankformData>() {
				public MiTankformData mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					
					
					MiTankformData pr = new MiTankformData();
					pr.setFormDetailId(rs.getInt(1));
					pr.setIrrSrcId(rs.getInt(2));
					pr.setIrrSrcName(rs.getString(3));
					pr.setIrrChFrm(rs.getDouble(4));
					pr.setIrrChTo(rs.getDouble(5));
					pr.setIrrL(rs.getDouble(6));
					pr.setIrrB(rs.getDouble(7));
					pr.setIrrD(rs.getDouble(8));
					pr.setIrrPermcost(rs.getDouble(9));
					pr.setIrrTempcost(rs.getDouble(10));
					pr.setFormDataId(rs.getInt(11));
					
					
					
			    return pr;

				}
            
			});
			jdbcTemplate8.getDataSource().getConnection().close();
			//System.out.println("formdetailList"+formdetailList);
			return formdetailList;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	@Override
	public List<MiTankformData> getMiTankFormAbstractDetail(MiTankformData miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("miinspect.getCatId()"+miinspect.getCatId());
		
		
		String sql=null;
		
		String frmdate=null;
		
		String todate=null;
		
		
		if(miinspect!=null){
			if(miinspect.getCatId()!=null){
			
			if(miinspect.getCatId()==1){
				
				sql =SELECT_TANK_FORM20_ABSTRACT_DETAIL;
			}
			
         if(miinspect.getCatId()==2){
				
				sql =SELECT_RESERVOIR_ABSTRACT_DETAIL;
			}
         
         if(miinspect.getCatId()==3){
				
				sql =SELECT_CANAL_FORM20_ABSTRACT_DETAIL;
			}
			
			}	
		}
		
		if(miinspect.getFrmFromDate()!=null && miinspect.getFrmFromDate().length()>0){
			
			//System.out.println("coming here"+1);
					
			frmdate=miinspect.getFrmFromDate();
					
				}

		if(miinspect.getFrmToDate()!=null && miinspect.getFrmToDate().length()>0){
			
			//System.out.println("coming here"+2);
			
			todate=miinspect.getFrmToDate();
			
		}
		
		Integer	year=0;
		Integer unitId=0;
		Integer dId=0;
		String sql1=null;
		String sqlUt=null;
		Integer catId=0;
		
		String sql2="  and mtf.circle_id= "+miinspect.getCircleId()+"  and mtf.division_id="+miinspect.getDivisionId()+"  and mtf.subdivision_id="+miinspect.getSubDivisionId() ;
	
		try {
			
if(miinspect.getUnitId()!=null  && ((miinspect.getTsfcFormYear()!=null) || (miinspect.getFrmFromDate()!=null && miinspect.getFrmToDate()!=null )) ) {
	
		year= miinspect.getTsfcFormYear();
		unitId=miinspect.getUnitId();
		dId=miinspect.getDesignationId();
	
		catId=miinspect.getCatId();
		
		sqlUt= sql+ " and mtf.unit_id="+unitId;
				
			
					if(unitId!=4  ){
					if((miinspect.getSubDivisionId()>0 && miinspect.getPostId()>0)){
							if((dId==2)||(dId==8)|| (dId==4)) {
						sql1=sqlUt+sql2+"  and mtf.post_id="+miinspect.getPostId()  ; 
					}							
							
						
					}
if((dId==4 ) && (miinspect.getSubDivisionId()>0 && miinspect.getPostId()==0)){
						
						sql1=sqlUt+ sql2;
					}
					//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


if((dId==5 ) && (unitId>0 )&& (miinspect.getCircleId()>0) && (miinspect.getDivisionId()>0 ) && (miinspect.getSubDivisionId()==0 )){
	
	sql1=sqlUt +"   and mtf.circle_id="+miinspect.getCircleId()+"  and mtf.division_id="+miinspect.getDivisionId(); 
	//System.out.println("DAO Impl 5 "+sql1);
}
					
if( (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()>0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubDivisionId()==0 )){

sql1=sqlUt+"   and mtf.circle_id="+miinspect.getCircleId(); 
//System.out.println("DAO Impl 7 "+sql1);
}
					}

	if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
if( (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()==0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubDivisionId()==0 )){

sql1=sqlUt; 
//System.out.println("DAO Impl 9 "+sql1);
}
	}
if( ((miinspect.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(miinspect.getCircleId()==0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubDivisionId()==0 ))
		||(miinspect.getUnitId()==4 && miinspect.getCircleId()==104 && miinspect.getDivisionId()==30327&& miinspect.getDesignationId()==5)
		||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 && miinspect.getDesignationId()==5)
		||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==0 && miinspect.getDesignationId()==7)
		){

sql1=sql; 
//System.out.println("DAO Impl 10 "+sql1);
}
				}

year = miinspect.getTsfcFormYear();
		//System.out.println("year "+year+" "+frmdate+ todate+ sql1);	
		List<MiTankformData> mtfd = jdbcTemplate8.query(sql1,new Object[]{year,frmdate,todate,catId},
				new RowMapper<MiTankformData>() {

					public MiTankformData mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						MiTankformData sd = new MiTankformData();
						
					//	System.out.println("rs.getInt(1)"+rs.getInt(1));
						sd.setTankId(rs.getInt(1));
						sd.setTankName(rs.getString(2));
						sd.setDistrictId(rs.getInt(3));
						sd.setDistrictName(rs.getString(4));
						sd.setMandalId(rs.getInt(5));
						sd.setMandalName(rs.getString(6));
						
						sd.setConstituencyId(rs.getInt(9));
						sd.setConstituencyName(rs.getString(10));
						sd.setUnitId(rs.getInt(11));
						sd.setUnitName(rs.getString(12));						
						sd.setCircleId(rs.getInt(13));
						sd.setCircleName(rs.getString(14));						
						sd.setDivisionId(rs.getInt(15));
						sd.setDivisionName(rs.getString(16));
						sd.setSubDivisionId(rs.getInt(17));
						sd.setSubDivisionName(rs.getString(18));
						sd.setTsfcFormDate(rs.getString(19));
						//System.out.println("sd"+sd.getTsfcFormDate());
						/*sd.setTsfcFormYear(rs.getInt(19));*/
						sd.setFormDataId(rs.getInt(20));
						sd.setPostId(rs.getLong(21));
						sd.setPostName(rs.getString(22));
						
						if(rs.getInt(23)==1){
							
							sd.setDamageTypeName("Breach");
						}
						
						if(rs.getInt(23)==2){
							
							sd.setDamageTypeName("Damage");
							
						}
						
                        if(rs.getInt(23)==0){
							
							sd.setDamageTypeName("NA");
							
						}
                        
                        sd.setCatId(rs.getInt(24));
                        
                        if(rs.getInt(24)==2 || rs.getInt(24)==3){
                        	
                        	if(rs.getInt(7)>0){
                        		
                        		sd.setVillageName(rs.getString(8));
                        	}
                        	if(rs.getInt(7)==0){
                        		
                        		 sd.setVillageName(rs.getString(25));
                        	}
                        	
                        
                        }
                        
                        if(rs.getInt(24)==1 ){
                        	
                        	if(rs.getInt(7)>0){
                          
                        	sd.setVillageName(rs.getString(8));
                        	}
                        	
                        	if(rs.getInt(7)==0){
                        		
                       		 sd.setVillageName(rs.getString(25));
                       	}
                       	
                        
                        }
						
						//System.out.println("sd"+sd);
						return sd;
					}
					
				});
		jdbcTemplate8.getDataSource().getConnection().close();
		//System.out.println("mtfd"+mtfd);
		return mtfd;
		
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	
	@Override
	public List<MiTankformData> getMiTankFDRAbstractDetail(MiTankformData miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		System.out.println("miinspect.getCatId()"+miinspect.getUnitId()+miinspect.getPostId());
		System.out.println("miinspect.getDesignationId()"+miinspect.getDesignationId()+miinspect.getPostId());
		
		
		
		
		String sql=null;
		
		String frmdate=null;
		
		String todate=null;
		
		
		if(miinspect!=null){
		
			
			
				
				sql = "  select *  from  (("+ SELECT_TANK_FDR_ABSTRACT_DETAIL + " ) union all  ( " + SELECT_RESERVOIR_FDR_ABSTRACT_DETAIL + " ) union all  (" +SELECT_CANAL_FDR_ABSTRACT_DETAIL  +" ) ) totaldata  ";
			
		}
		
		if(miinspect.getFrmFromDate()!=null && miinspect.getFrmFromDate().length()>0){
			
			//System.out.println("coming here"+1);
					
			frmdate=miinspect.getFrmFromDate();
					
				}

		if(miinspect.getFrmToDate()!=null && miinspect.getFrmToDate().length()>0){
			
			//System.out.println("coming here"+2);
			
			todate=miinspect.getFrmToDate();
			
		}
		
		Integer	year=0;
		Integer unitId=0;
		Integer dId=0;
		String sql1=null;
		String sqlUt=null;
		Integer catId=0;
		
		String sql2="  and mtf.circle_id= "+miinspect.getCircleId()+"  and mtf.division_id="+miinspect.getDivisionId()+"  and mtf.subdivision_id="+miinspect.getSubDivisionId() ;
	
		try {
			
if(miinspect.getUnitId()!=null  && ((miinspect.getTsfcFormYear()!=null) || (miinspect.getFrmFromDate()!=null && miinspect.getFrmToDate()!=null )) ) {
	
		year= miinspect.getTsfcFormYear();
		unitId=miinspect.getUnitId();
		dId=miinspect.getDesignationId();
	
		
		
		sqlUt= sql+ " where totaldata.unit_id="+unitId;
				
			
				





					

					}



year = miinspect.getTsfcFormYear();
		System.out.println("year "+year+" "+frmdate+ todate+ sqlUt);	
		List<MiTankformData> mtfd = jdbcTemplate8.query(sqlUt,new Object[]{year,frmdate,todate,year,frmdate,todate,year,frmdate,todate},
				new RowMapper<MiTankformData>() {

					public MiTankformData mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						MiTankformData sd = new MiTankformData();
						
					//	System.out.println("rs.getInt(1)"+rs.getInt(1));
						sd.setTankId(rs.getInt(1));
						sd.setTankName(rs.getString(2));
						sd.setDistrictId(rs.getInt(3));
						sd.setDistrictName(rs.getString(4));
						sd.setMandalId(rs.getInt(5));
						sd.setMandalName(rs.getString(6));
						
						sd.setConstituencyId(rs.getInt(9));
						sd.setConstituencyName(rs.getString(10));
						sd.setUnitId(rs.getInt(11));
						sd.setUnitName(rs.getString(12));						
						sd.setCircleId(rs.getInt(13));
						sd.setCircleName(rs.getString(14));						
						sd.setDivisionId(rs.getInt(15));
						sd.setDivisionName(rs.getString(16));
						sd.setSubDivisionId(rs.getInt(17));
						sd.setSubDivisionName(rs.getString(18));
						sd.setTsfcFormDate(rs.getString(19));
						//System.out.println("sd"+sd.getTsfcFormDate());
						/*sd.setTsfcFormYear(rs.getInt(19));*/
						sd.setFormDataId(rs.getInt(20));
						sd.setPostId(rs.getLong(21));
						sd.setPostName(rs.getString(22));
						
						if(rs.getInt(23)==1){
							
							sd.setDamageTypeName("Breach");
						}
						
						if(rs.getInt(23)==2){
							
							sd.setDamageTypeName("Damage");
							
						}
						
                        if(rs.getInt(23)==0){
							
							sd.setDamageTypeName("NA");
							
						}
                        
                        sd.setCatId(rs.getInt(24));
                        
                        if(rs.getInt(24)==2 || rs.getInt(24)==3){
                        	
                        	if(rs.getInt(7)>0){
                        		
                        		sd.setVillageName(rs.getString(8));
                        	}
                        	if(rs.getInt(7)==0){
                        		
                        		 sd.setVillageName(rs.getString(25));
                        	}
                        	
                        
                        }
                        
                        if(rs.getInt(24)==1 ){
                        	
                        	if(rs.getInt(7)>0){
                          
                        	sd.setVillageName(rs.getString(8));
                        	}
                        	
                        	if(rs.getInt(7)==0){
                        		
                       		 sd.setVillageName(rs.getString(25));
                       	}
                       	
                        
                        }
                        
                        sd.setTankCode(String.valueOf(rs.getLong(26)));
                        sd.setTankGeoId(rs.getLong(27));
                        sd.setAyacutAcres(rs.getDouble(28));
                        sd.setSumAprxCostPermt(rs.getDouble(29));
                        sd.setSumAprxCostTemp(rs.getDouble(30));
                        sd.setRainQty(rs.getDouble(31));
                        sd.setRainDate(rs.getString(32));
                        sd.setRainRGStation(rs.getString(33));
                        
                        sd.setRestored(rs.getInt(34));
                        sd.setSrcname(rs.getString(35));
                        
                        sd.setBreachLength(rs.getDouble(36));
						
						//System.out.println("sd"+sd);
						return sd;
					}
					
				});
		jdbcTemplate8.getDataSource().getConnection().close();
		//System.out.println("mtfd"+mtfd);
		return mtfd;
		
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	
	
	@Override
	public List<MiTankInspect> getMiTankChecksTankInfo(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =SELECT_TANK_ABSTRACT_TANKINFO ; 
		
		
		Long tankId=0l;
		Integer id=0;
		try {
if(miinspect.getTankId()!=null && miinspect.getMiInpsectMst1Id()!=null ){
				
				if(miinspect.getTankId()>0){
					tankId=miinspect.getTankId();
					
				}
				
				if(miinspect.getMiInpsectMst1Id()>0){
					
					id=miinspect.getMiInpsectMst1Id();
				}
				
				
}
			
		//System.out.println("year"+sql+""+year);	
		List<MiTankInspect> scheduleofDutiesList = jdbcTemplate8.query(sql,new Object[]{tankId,id },
				new RowMapper<MiTankInspect>() {

					public MiTankInspect mapRow(ResultSet rs, int rowNum)
							throws SQLException {
            			MiTankInspect sd = new MiTankInspect();
						//System.out.println("rs.getInt(1)"+rs.getInt(1));
						sd.setTankId(rs.getLong(1));
						sd.setUnitId(rs.getInt(2));
						sd.setCircleId(rs.getInt(3));
						sd.setDivisionId(rs.getInt(4));
						sd.setSubdivisionId(rs.getInt(5));
						sd.setProjectId(rs.getInt(6));
						sd.setNewDistrictId(rs.getInt(7));
						sd.setMandalId(rs.getInt(8));
						sd.setVillageId(rs.getInt(9));
						sd.setMiTankFreqId(rs.getInt(10));
						sd.setTankName(rs.getString(11));
						sd.setDistrictName(rs.getString(12));
						sd.setMandalName(rs.getString(13));
						sd.setVillageName(rs.getString(14));
						sd.setActivityFrequency(rs.getString(15));
						sd.setUnitName(rs.getString(16));
						sd.setCircleName(rs.getString(17));
						sd.setDivisionName(rs.getString(18));
						sd.setSubdivisionName(rs.getString(19));
					     sd.setYear(rs.getInt(20));
					     sd.setTankCode(rs.getLong(21));
						
						
						
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		return scheduleofDutiesList;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<MiTankInspect> getMiTankChecksEmbInfo(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =SELECT_TANK_ABSTRACT_EMBINFO ; 
		
		
		Long tankId=0l;
		Integer year=0;
		
		Integer m1id=0;
		try {
if(miinspect.getTankId()!=null && miinspect.getMiInpsectMst1Id()!=null){
				
				if(miinspect.getTankId()>0){
					tankId=miinspect.getTankId();
					
				}
				
				if(miinspect.getMiInpsectMst1Id()>0){
					
					m1id=miinspect.getMiInpsectMst1Id();
				}

				
				
}
			
		//System.out.println("year"+sql+""+tankId+year+freqId);	
		List<MiTankInspect> scheduleofDutiesList = jdbcTemplate8.query(sql,new Object[]{tankId,m1id},
				new RowMapper<MiTankInspect>() {

					public MiTankInspect mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						
						

						MiTankInspect sd = new MiTankInspect();
						
						
						//System.out.println("rs.getInt(1)"+rs.getInt(1));
						sd.setMiInpsectMst1Id(rs.getInt(1));
						sd.setMiInpsectMst2Id(rs.getInt(2));
						sd.setRemarks(rs.getString(3));
						sd.setMiInspectMapId(rs.getInt(4));
						sd.setInspectDate(rs.getString(5));
						sd.setWaterLevelInspect(rs.getDouble(6));
						if(rs.getBoolean(7)==true){
					sd.setInpsectComplete("Yes");
					}
						if(rs.getBoolean(7)==false){
					   sd.setInpsectComplete("No");	
					   sd.setMiActionReqTypeName("NA");
						}
						if(rs.getInt(8)==1){
						sd.setMiActionReqTypeName("Observation");
						}
						if(rs.getInt(8)==2){
							sd.setMiActionReqTypeName("Emergency");
							}
						
						if(rs.getInt(8)==3){
							sd.setMiActionReqTypeName("Maintenance");
							}
						if(rs.getInt(8)==4){
							sd.setMiActionReqTypeName("Original work");
							}
						
						sd.setTankWeirSluiceId(rs.getInt(9)); 
					
						
						if(rs.getBoolean(10)==true){
						
							sd.setActionReqName("Yes");
							
						}
						
						if(rs.getBoolean(10)==false){
							
							sd.setActionReqName("No");
							
						}
						
						sd.setTankInspectApproveId(rs.getInt(11));
						sd.setMiInspectTypeId(rs.getInt(12));
						sd.setMiCompId(rs.getInt(13));
						sd.setMiInspectTypeName(rs.getString(14));
						sd.setMiCompName(rs.getString(15));
						sd.setMiCompParentId(rs.getInt(16));
						sd.setTankInspectApproveStatus(rs.getString(17));
						sd.setTabId(rs.getInt(18));
						sd.setTankWeirSluiceName(rs.getString(19));
						
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		
		//System.out.println("scheduleofDutiesList"+scheduleofDutiesList);
		return scheduleofDutiesList;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<InvResAbstract> getInvomResAbstractList(ReservoirInspect reservoirObj) throws InventoryUserException {
		// TODO Auto-generated method stub
	//	String sql = SELECT_INVOM_RES_ABSTRACT_UNIT;
		
		String sql_not_in_unit_cond= "(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as ressubmittedunsat, 0 as ressubmittedpoor , 0 as ressubmittedfair , 0 as ressubmittedsat ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",0 as circle_id,'NA' as circle_name , 0 as division_id, 'NA' as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cnd1, 0 as cnd2,0 as cnd3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id  from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id ) not in ( select distinct irdam1.unit_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id   FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id ) not in ( select distinct irdam1.unit_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id ) )  resdata  group by resdata.unit_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false) ) union all ";
		
		String sql_not_in_unit_byunit_cond= "(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as ressubmittedunsat, 0 as ressubmittedpoor , 0 as ressubmittedfair , 0 as ressubmittedsat ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",0 as circle_id,'NA' as circle_name , 0 as division_id, 'NA' as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cnd1, 0 as cnd2,0 as cnd3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id  from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id ) not in ( select distinct irdam1.unit_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id   FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id ) not in ( select distinct irdam1.unit_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id ) )  resdata  group by resdata.unit_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false) where um.unit_id="+reservoirObj.getUnitId()+" ) union all ";
		
		String sql_not_in_division_bydivision_cond= "(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as ressubmittedunsat, 0 as ressubmittedpoor , 0 as ressubmittedfair , 0 as ressubmittedsat ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",cm.circle_id as circle_id,cm.circle_name as circle_name , dm.division_id as division_id, dm.division_name as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cnd1, 0 as cnd2,0 as cnd3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id,resdata.circle_id, resdata.division_id from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id,irum.circle_id,irum.division_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id,irum.circle_id,irum.division_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id,irum.circle_id, irum.division_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id,ts.circle_id,ts.division_id  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id,ts.circle_id,ts.division_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id,ts.circle_id,ts.division_id ) )  resdata  group by resdata.unit_id,resdata.circle_id,resdata.division_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false)  inner join circle_master cm on (restotalnadata.circle_id=cm.circle_id and cm.delete_flag=false)  inner join division_master dm on (restotalnadata.division_id =dm.division_id  and restotalnadata.circle_id=dm.circle_id   and dm.delete_flag=false) where cm.circle_id= "+reservoirObj.getCircleId()+"  and  um.unit_id="+reservoirObj.getUnitId()+" ) union all   ";
		
		String sql_not_in_subdivision_bysubdiv_cond= "(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as ressubmittedunsat, 0 as ressubmittedpoor , 0 as ressubmittedfair , 0 as ressubmittedsat ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",cm.circle_id as circle_id,cm.circle_name as circle_name , dm.division_id as division_id, dm.division_name as division_name , sm.subdivision_id as subdivision_id, sm.subdivision_name as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cnd1, 0 as cnd2,0 as cnd3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id,resdata.circle_id, resdata.division_id,resdata.subdivision_id from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id,irum.circle_id,irum.division_id,irum.subdivision_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id,irum.circle_id,irum.division_id,irum.subdivision_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id,irdam1.subdivision_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id,irum.circle_id, irum.division_id,irum.subdivision_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id,ts.circle_id,ts.division_id,ts.subdivision_id  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id,ts.circle_id,ts.division_id,ts.subdivision_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id,irdam1.subdivision_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id,ts.circle_id,ts.division_id,ts.subdivision_id ) )  resdata  group by resdata.unit_id,resdata.circle_id,resdata.division_id,resdata.subdivision_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false)  inner join circle_master cm on (restotalnadata.circle_id=cm.circle_id and cm.delete_flag=false)  inner join division_master dm on (restotalnadata.division_id =dm.division_id  and restotalnadata.circle_id=dm.circle_id   and dm.delete_flag=false) inner join subdivision_master sm on (restotalnadata.subdivision_id=sm.subdivision_id and restotalnadata.division_id=sm.division_id and sm.delete_flag=false ) where dm.division_id="+reservoirObj.getDivisionId()+" and cm.circle_id="+reservoirObj.getCircleId()+" and um.unit_id="+reservoirObj.getUnitId()+"  ) union all  ";
		
String sql=null;
		
		if(reservoirObj!=null){
			
			if(((reservoirObj.getUnitId()>0 &&(reservoirObj.getUnitId()==4 || reservoirObj.getUnitId()==9832 || reservoirObj.getUnitId()==9830 ||  reservoirObj.getUnitId()==9  ) && reservoirObj.getCircleId()==0 && reservoirObj.getDivisionId()==0 && reservoirObj.getSubdivisionId()==0)
					||(reservoirObj.getUnitId()==4 && reservoirObj.getCircleId()==104 && reservoirObj.getDivisionId()==30327&& reservoirObj.getDesignationId()==5)
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==0 && reservoirObj.getDesignationId()==7)
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==31099 && (reservoirObj.getDesignationId()==5 || reservoirObj.getDesignationId()==4 || reservoirObj.getDesignationId()==2 || reservoirObj.getDesignationId()==8 ))
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==31099 &&  reservoirObj.getSubdivisionId()==12173 && (reservoirObj.getDesignationId()==5 || reservoirObj.getDesignationId()==4 || reservoirObj.getDesignationId()==2 || reservoirObj.getDesignationId()==8 ))
					
					||(reservoirObj.getUnitId()==9818 && reservoirObj.getCircleId()==21584 && reservoirObj.getDivisionId()==31022 &&  reservoirObj.getSubdivisionId()==11862 && ( reservoirObj.getDesignationId()==4 ))
					
					)|| (reservoirObj.getPostId()==1106177746)
					|| (reservoirObj.getPostId()==931)
					|| (reservoirObj.getPostId()==932)
					|| (reservoirObj.getPostId()==921)
					|| (reservoirObj.getPostId()==911)){
		
		sql= sql_not_in_unit_cond+SELECT_INVOM_RES_ABSTRACT_UNIT + "  order by unit_name" ;
		
			}
			if((reservoirObj.getUnitId()!=4 && reservoirObj.getUnitId()!=9832 && reservoirObj.getUnitId()!=9830 && reservoirObj.getUnitId()!=9 && reservoirObj.getPostId()!=1106177746) ) {
			if((reservoirObj.getUnitId()>0  && reservoirObj.getCircleId()==0 && reservoirObj.getDivisionId()==0 && reservoirObj.getSubdivisionId()==0) ){
				
				sql= sql_not_in_unit_byunit_cond+SELECT_INVOM_RES_ABSTRACT_UNIT + " and irdam1.unit_id="+reservoirObj.getUnitId()+"  order by unit_name" ;
				
				//31052023
				//sql= SELECT_INVOM_RES_ABSTRACT_CIRCLE+ "  and irdam1.unit_id="+reservoirObj.getUnitId()+"  order by um.unit_name";
				
					}
			}if(reservoirObj.getUnitId()!=4  ){
			if(reservoirObj.getUnitId()>0 && reservoirObj.getCircleId()>0 && reservoirObj.getDivisionId()==0 && reservoirObj.getSubdivisionId()==0){
				
				sql=sql_not_in_division_bydivision_cond+SELECT_INVOM_RES_ABSTRACT_DIVISION+" and irdam1.circle_id="+reservoirObj.getCircleId()+" and  irdam1.unit_id="+reservoirObj.getUnitId()+" order by division_name, circle_name, unit_name" ; 
				
					}
			
     if(reservoirObj.getUnitId()>0 && reservoirObj.getCircleId()>0 && reservoirObj.getDivisionId()>0 && reservoirObj.getSubdivisionId()==0 && (reservoirObj.getDesignationId()==5)){
				
				sql=sql_not_in_subdivision_bysubdiv_cond+SELECT_INVOM_RES_ABSTRACT_SUBDIVISION+ " and irdam1.division_id="+reservoirObj.getDivisionId()+" and irdam1.circle_id="+reservoirObj.getCircleId()+" and  irdam1.unit_id="+reservoirObj.getUnitId()+" order by subdivision_name,  division_name, circle_name, unit_name" ; 
				
					}
     
     if(reservoirObj.getUnitId()>0 && reservoirObj.getCircleId()>0 && reservoirObj.getDivisionId()>0 && reservoirObj.getSubdivisionId()>0 && (reservoirObj.getDesignationId()==4)){
			
			sql=SELECT_INVOM_RES_ABSTRACT_EMP+" and irdam1.subdivision_id="+reservoirObj.getSubdivisionId()+" and irdam1.division_id="+reservoirObj.getDivisionId()+" and irdam1.circle_id="+reservoirObj.getCircleId()+" and  irdam1.unit_id="+reservoirObj.getUnitId()+" order by subdivision_name, division_name, circle_name, unit_name" ; 
			
				}
     
     if(reservoirObj.getUnitId()>0 && reservoirObj.getCircleId()>0 && reservoirObj.getDivisionId()>0 && reservoirObj.getSubdivisionId()>0 &&  reservoirObj.getPostId()>0 && (reservoirObj.getDesignationId()==2 || reservoirObj.getDesignationId()==8 )){
			
    	 sql=SELECT_INVOM_RES_ABSTRACT_EMP+" and irdam1.post_id= "+reservoirObj.getPostId() +" and irdam1.subdivision_id="+reservoirObj.getSubdivisionId()+" and irdam1.division_id="+reservoirObj.getDivisionId()+" and irdam1.circle_id="+reservoirObj.getCircleId()+" and  irdam1.unit_id="+reservoirObj.getUnitId()+" order by post_name, subdivision_name, division_name, circle_name, unit_name" ; 
			
				}
			}
		
		}
		
		
		//System.out.println("sql cond list"+sql);
		
		
		Integer year=0;
		Integer dutyfrequnecy=0;
		try {
			
			if(reservoirObj.getYear()>0){
				
				year=reservoirObj.getYear();
			}
			
           if(reservoirObj.getDutyFrequencyId()>0){
				
        	   dutyfrequnecy=reservoirObj.getDutyFrequencyId();
			}
			
		//	System.out.println("year"+year);
			
		//	System.out.println("sql"+sql);
			
		//	System.out.println("dutyfrequnecy"+dutyfrequnecy);

			List<InvResAbstract> invResAbstractList = jdbcTemplate8.query(sql,new Object[]{year,dutyfrequnecy }, new RowMapper<InvResAbstract>() {

				public InvResAbstract mapRow(ResultSet rs, int rowNum) throws SQLException {

					InvResAbstract invResAbstract = new InvResAbstract();
					invResAbstract.setUnitId(rs.getInt(1));
					invResAbstract.setResTotalCount(rs.getInt(2));
					invResAbstract.setResSubmittedCount(rs.getInt(3));
					invResAbstract.setResUnsatisfactory(rs.getInt(4));
					invResAbstract.setResPoor(rs.getInt(5));
					invResAbstract.setResFair(rs.getInt(6));
					invResAbstract.setResSatisfactory(rs.getInt(7));
					
					invResAbstract.setUnitName(rs.getString(8));
					
					invResAbstract.setYear(rs.getInt(9));
					
					invResAbstract.setDutyFrequencyId(rs.getInt(10));
					
					invResAbstract.setCircleId(rs.getInt(11));
					
					invResAbstract.setCircleName(rs.getString(12));
					
					invResAbstract.setDivisionId(rs.getInt(13));
					
					invResAbstract.setDivisionName(rs.getString(14));
					
					invResAbstract.setSubdivisionId(rs.getInt(15));
					
					invResAbstract.setSubdivisionName(rs.getString(16));
					
					invResAbstract.setSectionId(rs.getInt(17));
					
					invResAbstract.setPostId(rs.getLong(18));
					
					invResAbstract.setPostName(rs.getString(19));
					
					invResAbstract.setConditionofDamId(rs.getInt(20));
					
					invResAbstract.setUnsatconditionofDamId(rs.getInt(21));
					
					invResAbstract.setPoorconditionofDamId(rs.getInt(22));
					
					
					invResAbstract.setFairconditionofDamId(rs.getInt(23));
					
					invResAbstract.setSatconditionofDamId(rs.getInt(24));


					return invResAbstract;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return invResAbstractList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	@Override
	public List<ReservoirInspect> getinvomrestotalList(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =null;
		
		Integer	year=0;
		Integer unitId=0;
		Integer dId=0;
		Integer circleId=0;
		Integer divisionId=0;
		Integer freq=0;
		
		Integer subdivisionId=0;
		Long postId=0l;
		
		String sql1=SELECT_INVOM_RES_ONGOING_POST;
		String sqlUt=null;
		
		if (resObj.getConditionofDamId() != null) {

			if (resObj.getConditionofDamId() >= 0) {

				if (resObj.getConditionofDamId() == 0) {

				
					//System.out.println("coming here  if ");
			
		
	
		if(resObj.getUnitId()!=null  && resObj.getYear()!=null && resObj.getDutyFrequencyId()!=null  ){
			
			year= resObj.getYear();
			unitId=resObj.getUnitId();
			circleId=resObj.getCircleId();
			divisionId=resObj.getDivisionId();
			freq=resObj.getDutyFrequencyId();
			subdivisionId=resObj.getSubdivisionId();
			
			postId=resObj.getPostId();
			dId=resObj.getDesignationId();
		
					
				
						if(unitId!=4  ){
						if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
								if((dId==2)||(dId==8)|| (dId==4)) {
									sql=sql1+ " and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+"  and irdia.post_id="+resObj.getPostId()+ "  )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+" and irdia.post_id="+resObj.getPostId()+"  )   order by res_ann1_mst1_id  "  ; 
						}							
								
							
						}
	if(((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))|| ((dId==5 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))){
							
		sql=sql1+ " and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+"  )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+"  )  order by res_ann1_mst1_id  ";
						}
						//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


	if(((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 ))||(((dId==7 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )))){
		
		sql=sql1+ "  and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+"  )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+"  )   order by res_ann1_mst1_id  "; 
		//System.out.println("DAO Impl 5 "+sql1);
	}
						
	if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

		sql=sql1+ "   and  irdia.circle_id= "+resObj.getCircleId()+")  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+"  )  order by res_ann1_mst1_id  ";
	//System.out.println("DAO Impl 7 "+sql1);
	}
						}

		if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
	if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

		sql=sql1 + " )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" )   order by res_ann1_mst1_id  "; 
	//System.out.println("DAO Impl 9 "+sql1);
	}
		}
	if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
			||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
			||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
			||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
			){

		sql=sql1  + " )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year= "+resObj.getYear()+ "  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" )  order by res_ann1_mst1_id  ";
	//System.out.println("DAO Impl 10 "+sql1);
	}
					}
		} else if (resObj.getConditionofDamId() > 0) {

			

			//System.out.println("coming here else if ");
			
			
			if(resObj.getUnitId()!=null  && resObj.getYear()!=null && resObj.getDutyFrequencyId()!=null  && resObj.getConditionofDamId()!=null ){
				
				year= resObj.getYear();
				unitId=resObj.getUnitId();
				circleId=resObj.getCircleId();
				divisionId=resObj.getDivisionId();
				freq=resObj.getDutyFrequencyId();
				subdivisionId=resObj.getSubdivisionId();
				
				postId=resObj.getPostId();
				dId=resObj.getDesignationId();
			
						
					
							if(unitId!=4  ){
							if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
									if((dId==2)||(dId==8)|| (dId==4)) {
										sql=sql1+ " and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+"  and irdia.post_id="+resObj.getPostId()+" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+"  )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+" and irdia.post_id="+resObj.getPostId()+" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+"  )   order by res_ann1_mst1_id  "  ; 
							}							
									
								
							}
		if(((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))||((dId==5 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))){
								
			sql=sql1+ " and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+"  )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+"  )  order by res_ann1_mst1_id  ";
							}
							//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


		if((((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )))||(((dId==7 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )))){
			
			sql=sql1+ "  and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+"  )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+"  )   order by res_ann1_mst1_id  "; 
			//System.out.println("DAO Impl 5 "+sql1);
		}
							
		if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

			sql=sql1+ "   and  irdia.circle_id= "+resObj.getCircleId()+" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+")  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+"  )  order by res_ann1_mst1_id  ";
		//System.out.println("DAO Impl 7 "+sql1);
		}
							}

			if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
		if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

			sql=sql1 + " and irdia.condition_dam_id = "+resObj.getConditionofDamId()+ " )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+" )  order by res_ann1_mst1_id "; 
		//System.out.println("DAO Impl 9 "+sql1);
		}
			}
		if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
				||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
				||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
				||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
				){

			sql=sql1  +" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+ " )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year= "+resObj.getYear()+ "  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.condition_dam_id = "+resObj.getConditionofDamId()+" )  order by res_ann1_mst1_id  ";
		//System.out.println("DAO Impl 10 "+sql1);
		}
						}
			}
			}}
		
		try {

			
		//System.out.println("sql total details"+sql+ "unitId" +unitId+circleId+divisionId+subdivisionId+postId+freq+year);
			List<ReservoirInspect> reservoirUnitDataList = jdbcTemplate8.query(sql,new Object[]{year,freq,unitId}, new RowMapper<ReservoirInspect>() {

				public ReservoirInspect mapRow(ResultSet rs, int rowNum) throws SQLException {

					ReservoirInspect reservoirUnitData = new ReservoirInspect();
					
				//	System.out.println("sql2"+rs.getInt(1));
					reservoirUnitData.setUnitId(rs.getInt(1));
					reservoirUnitData.setReservoirId(rs.getInt(2));
					reservoirUnitData.setResName(rs.getString(3));
					reservoirUnitData.setUnitName(rs.getString(4));
					reservoirUnitData.setCircleName(rs.getString(5));
					reservoirUnitData.setDivisionName(rs.getString(6));
					reservoirUnitData.setSubdivisionName(rs.getString(7));
					reservoirUnitData.setProjectName(rs.getString(8));
					
				
					reservoirUnitData.setYear(rs.getInt(9));
					
					//reservoirUnitData.setResStatusId(rs.getInt(10));
					
					/*if(rs.getInt(10)==1){
						reservoirUnitData.setResStatus("Ongoing");
						
					}
					if(rs.getInt(10)==2){
						reservoirUnitData.setResStatus("Completed");
						
					}*/
					
					
					reservoirUnitData.setResInspectMst1Id(rs.getInt(10));
					
					reservoirUnitData.setTankId(rs.getInt(11));
					
					reservoirUnitData.setDutyFrequencyId(rs.getInt(12));
				
					

					return reservoirUnitData;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return reservoirUnitDataList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	
	
	
	
	
	@Override
	public List<ReservoirInspect> getinvomresCattotalList(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =null;
		
		Integer	year=0;
		Integer unitId=0;
		Integer dId=0;
		Integer circleId=0;
		Integer divisionId=0;
		Integer freq=0;
		
		Integer subdivisionId=0;
		Long postId=0l;
		
		String sql1=SELECT_CAT_RES_DETAILS;
		String sql2=SELECT_CAT_NA_RES_DETAILS;
		String sqlUt=null;
		//System.out.println("resObj"+resObj);
		
		if (resObj.getDeficiencyCategory() != null) {

		

			 if ( resObj.getDeficiencyCategory()!=4) {

			

			//System.out.println("coming here  if ");
			
			
			if(resObj.getUnitId()!=null  && resObj.getYear()!=null && resObj.getDutyFrequencyId()!=null  && resObj.getDeficiencyCategory()!=null ){
				
				year= resObj.getYear();
				unitId=resObj.getUnitId();
				circleId=resObj.getCircleId();
				divisionId=resObj.getDivisionId();
				freq=resObj.getDutyFrequencyId();
				subdivisionId=resObj.getSubdivisionId();
				
				postId=resObj.getPostId();
				dId=resObj.getDesignationId();
			
						
					
							if(unitId!=4  ){
							if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
									if((dId==2)||(dId==8)|| (dId==4)) {
										sql=sql1+ " and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+"  and irdia.post_id="+resObj.getPostId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+"  )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)       where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)  inner join invom.invom_res_dam_health irdh on (irdia.res_ann1_mst1_id=irdh.res_ann1_mst1_id and irdh.delete_flag=false and irdh.is_latest=true)   where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+" and irdia.post_id="+resObj.getPostId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+"  ) "  ; 
							}							
									
								
							}
		if(((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))||(((dId==5 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0)))){
								
			sql=sql1+ " and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+"  )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)  inner join invom.invom_res_dam_health irdh on (irdia.res_ann1_mst1_id=irdh.res_ann1_mst1_id and irdh.delete_flag=false and irdh.is_latest=true)   where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+"  ) ";
							}
							//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


		if(((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 ))||(((dId==7 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )))){
			
			sql=sql1+ "  and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+"  )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)  inner join invom.invom_res_dam_health irdh on (irdia.res_ann1_mst1_id=irdh.res_ann1_mst1_id and irdh.delete_flag=false and irdh.is_latest=true)   where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+"  ) "; 
			//System.out.println("DAO Impl 5 "+sql1);
		}
							
		if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

			sql=sql1+ "   and  irdia.circle_id= "+resObj.getCircleId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+")  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+"  )";
		//System.out.println("DAO Impl 7 "+sql1);
		}
							}

			if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
		if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

			sql=sql1 + " and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+ " )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id) inner join invom.invom_res_dam_health irdh on (irdia.res_ann1_mst1_id=irdh.res_ann1_mst1_id and irdh.delete_flag=false and irdh.is_latest=true)   where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+" )"; 
		//System.out.println("DAO Impl 9 "+sql1);
		}
			}
		if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
				||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
				||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
				||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
				){

			sql=sql1  +" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+ " )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)   inner join invom.invom_res_dam_health irdh on (irdia.res_ann1_mst1_id=irdh.res_ann1_mst1_id and irdh.delete_flag=false and irdh.is_latest=true)  where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.freq_year= "+resObj.getYear()+ "  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory()+" ) ";
		//System.out.println("DAO Impl 10 "+sql1);
		}
						}
			}else if(resObj.getDeficiencyCategory()==4){
				
				//System.out.println("coming here else  if  4");
				
				if(resObj.getUnitId()!=null  && resObj.getYear()!=null && resObj.getDutyFrequencyId()!=null  && resObj.getDeficiencyCategory()!=null ){
					
					year= resObj.getYear();
					unitId=resObj.getUnitId();
					circleId=resObj.getCircleId();
					divisionId=resObj.getDivisionId();
					freq=resObj.getDutyFrequencyId();
					subdivisionId=resObj.getSubdivisionId();
					
					postId=resObj.getPostId();
					dId=resObj.getDesignationId();
				
							
						
								if(unitId!=4  ){
								if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
										if((dId==2)||(dId==8)|| (dId==4)) {
											sql=sql2+ " and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+"  and irdia.post_id="+resObj.getPostId()+"  )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)      where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.res_ann1_mst1_id not in (select distinct res_ann1_mst1_id from invom.invom_res_dam_health where delete_flag=false )  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+" and irdia.post_id="+resObj.getPostId()+" ) "  ; 
								}							
										
									
								}
			if(((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))||(((dId==5 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0)))){
									
				sql=sql2+ " and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+"   )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)   where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.res_ann1_mst1_id not in (select distinct res_ann1_mst1_id from invom.invom_res_dam_health where delete_flag=false ) and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+" and irdia.subdivision_id="+resObj.getSubdivisionId()+" ) ";
								}
								//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


			if(((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 ))||(((dId==7 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )))){
				
				sql=sql2+ "  and  irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+"   )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)     where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.res_ann1_mst1_id not in (select distinct res_ann1_mst1_id from invom.invom_res_dam_health where delete_flag=false )   and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+" and irdia.division_id="+resObj.getDivisionId()+"  ) "; 
				//System.out.println("DAO Impl 5 "+sql1);
			}
								
			if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

				sql=sql2+ "   and  irdia.circle_id= "+resObj.getCircleId()+" )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.res_ann1_mst1_id not in (select distinct res_ann1_mst1_id from invom.invom_res_dam_health where delete_flag=false )  and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+" and irdia.circle_id="+resObj.getCircleId()+"   )";
			//System.out.println("DAO Impl 7 "+sql1);
			}
								}

				if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
			if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

				sql=sql2 +  " )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id,irdia.freq_operation   FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)    where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.res_ann1_mst1_id not in (select distinct res_ann1_mst1_id from invom.invom_res_dam_health where delete_flag=false ) and irdia.freq_year="+resObj.getYear()+"  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+"  )"; 
			//System.out.println("DAO Impl 9 "+sql1);
			}
				}
			if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
					||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
					||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
					||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
					){

				sql=sql2  +" )  union   (SELECT distinct irdia.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  projnames.project_name,  irdia.freq_year,  irdia.res_ann1_mst1_id,irdia.tank_id as tank_id ,irdia.freq_operation  FROM invom.invom_res_dam_ann1_mst1 irdia   inner join invom.invom_mi_tanks imt   on (irdia.tank_id=imt.tank_id_mk and imt.delete_flag=false and imt.is_latest=true)  inner join   unit_master um   on ( irdia.unit_id=um.unit_id and um.delete_flag=false)  inner join   ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from  invom.invom_res_dam_ann1_mst1 irdia   left join circle_master cm  on(irdia.circle_id=cm.circle_id and cm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) circlenames   on (irdia.tank_id=circlenames.tank_id)    left  join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from   invom.invom_res_dam_ann1_mst1 irdia   left join division_master dm   on ( irdia.division_id=dm.division_id and dm.delete_flag=false)   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) divisionnames   on (irdia.tank_id=divisionnames.tank_id)   left join( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from   invom.invom_res_dam_ann1_mst1 irdia   left join subdivision_master sdm on (irdia.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) subdivisionnames   on (irdia.tank_id=subdivisionnames.tank_id)   left join ( select distinct tank_id,array_to_string(array_agg(distinct(coalesce(project_name,'0'))) , ',') as project_name   from   invom.invom_res_dam_ann1_mst1 irdia     left join project_mst pm   on (irdia.project_id=pm.project_id and pm.delete_flag=false)    where irdia.delete_flag=false and irdia.is_latest=true  group by tank_id ) projnames   on (irdia.tank_id=projnames.tank_id)     where irdia.delete_flag=false   and irdia.is_latest=true  and irdia.res_ann1_mst1_id not in (select distinct res_ann1_mst1_id from invom.invom_res_dam_health where delete_flag=false ) and irdia.freq_year= "+resObj.getYear()+ "  and  freq_operation="+resObj.getDutyFrequencyId()+" and irdia.unit_id="+resObj.getUnitId()+"  ) ";
			//System.out.println("DAO Impl 10 "+sql1); 
			}
							}
				
				
				
			}
		
			 }
		
		try {

			
		//System.out.println("sql"+sql+ "unitId" +unitId+circleId+divisionId+subdivisionId+postId+freq+year);
			List<ReservoirInspect> reservoirUnitDataList = jdbcTemplate8.query(sql,new Object[]{year,freq,unitId}, new RowMapper<ReservoirInspect>() {

				public ReservoirInspect mapRow(ResultSet rs, int rowNum) throws SQLException {

					ReservoirInspect reservoirUnitData = new ReservoirInspect();
					
				//	System.out.println("sql2"+rs.getInt(1));
					reservoirUnitData.setUnitId(rs.getInt(1));
					reservoirUnitData.setReservoirId(rs.getInt(2));
					reservoirUnitData.setResName(rs.getString(3));
					reservoirUnitData.setUnitName(rs.getString(4));
					reservoirUnitData.setCircleName(rs.getString(5));
					reservoirUnitData.setDivisionName(rs.getString(6));
					reservoirUnitData.setSubdivisionName(rs.getString(7));
					reservoirUnitData.setProjectName(rs.getString(8));
					
				
					reservoirUnitData.setYear(rs.getInt(9));
					
					//reservoirUnitData.setResStatusId(rs.getInt(10));
					
					/*if(rs.getInt(10)==1){
						reservoirUnitData.setResStatus("Ongoing");
						
					}
					if(rs.getInt(10)==2){
						reservoirUnitData.setResStatus("Completed");
						
					}*/
					
					
					reservoirUnitData.setResInspectMst1Id(rs.getInt(10));
					
					reservoirUnitData.setTankId(rs.getInt(11));
					
					reservoirUnitData.setDutyFrequencyId(rs.getInt(12));
				
					

					return reservoirUnitData;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return reservoirUnitDataList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	
	
	
	@Override
	public List<ReservoirInspect> getinvomrestotalnrldresList(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =null;
		
		Integer	year=0;
		Integer unitId=0;
		Integer dId=0;
		Integer circleId=0;
		Integer divisionId=0;
		Integer freq=0;
		
		Integer subdivisionId=0;
		Long postId=0l;
		
		String sql1=SELECT_NRLD_RES_TOTAL;
		String sqlUt=null;
		
		if (resObj.getUnitId() != null) {

			if (resObj.getUnitId() >= 0) {

			
			
			year= resObj.getYear();
			unitId=resObj.getUnitId();
			circleId=resObj.getCircleId();
			divisionId=resObj.getDivisionId();
			freq=resObj.getDutyFrequencyId();
			subdivisionId=resObj.getSubdivisionId();
			
			postId=resObj.getPostId();
			dId=resObj.getDesignationId();
		
					
				
						if(unitId!=4  ){
						if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
								if((dId==2)||(dId==8)|| (dId==4)) {
									sql=sql1+ " and  irum.circle_id="+resObj.getCircleId()+" and irum.division_id="+resObj.getDivisionId()+" and irum.subdivision_id="+resObj.getSubdivisionId()+"  and irum.post_id="+resObj.getPostId()+ "  )  union    (SELECT distinct ts.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  'NA' as project_name,  imt.tank_id_mk as tank_id ,coalesce(nrld_code,'0') as nrld_code  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')   inner join   unit_master um   on ( ts.unit_id=um.unit_id and um.delete_flag=false)   inner join   ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join circle_master cm  on(ts1.circle_id=cm.circle_id and cm.delete_flag=false)   where ts1.post_status='ACTIVE' group by imt1.tank_id_mk ) circlenames   on (imt.tank_id_mk=circlenames.tank_id)    left  join ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from invom.invom_mi_tanks as imt1 inner join  taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join division_master dm   on ( ts1.division_id=dm.division_id and dm.delete_flag=false)   where ts1.post_status='ACTIVE'  group by tank_id_mk ) divisionnames   on (imt.tank_id_mk=divisionnames.tank_id)     left join( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from  invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true)  left join subdivision_master sdm on (ts1.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where ts1.post_status='ACTIVE'  group by tank_id_mk ) subdivisionnames   on (imt.tank_id_mk=subdivisionnames.tank_id)        where imt.delete_flag=false   and imt.is_latest=true  and imt.is_nrld=true and  ts.unit_id =  "+ resObj.getUnitId()+" and ts.circle_id="+resObj.getCircleId()+" and ts.division_id="+resObj.getDivisionId()+" and ts.subdivision_id="+resObj.getSubdivisionId()+" and ts.postid="+resObj.getPostId()+"  )  "  ; 
						}							
								
							
						}
	if((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0)){
							
		sql=sql1+ " and  irum.circle_id="+resObj.getCircleId()+" and irum.division_id="+resObj.getDivisionId()+" and irum.subdivision_id="+resObj.getSubdivisionId()+"  )  union   (SELECT distinct ts.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  'NA' as project_name,  imt.tank_id_mk as tank_id ,coalesce(nrld_code,'0') as nrld_code  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')   inner join   unit_master um   on ( ts.unit_id=um.unit_id and um.delete_flag=false)   inner join   ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join circle_master cm  on(ts1.circle_id=cm.circle_id and cm.delete_flag=false)   where ts1.post_status='ACTIVE' group by imt1.tank_id_mk ) circlenames   on (imt.tank_id_mk=circlenames.tank_id)    left  join ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from invom.invom_mi_tanks as imt1 inner join  taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join division_master dm   on ( ts1.division_id=dm.division_id and dm.delete_flag=false)   where ts1.post_status='ACTIVE'  group by tank_id_mk ) divisionnames   on (imt.tank_id_mk=divisionnames.tank_id)     left join( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from  invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true)  left join subdivision_master sdm on (ts1.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where ts1.post_status='ACTIVE'  group by tank_id_mk ) subdivisionnames   on (imt.tank_id_mk=subdivisionnames.tank_id)        where imt.delete_flag=false   and imt.is_latest=true  and imt.is_nrld=true and  ts.unit_id =  "+ resObj.getUnitId()+" and ts.circle_id="+resObj.getCircleId()+" and ts.division_id="+resObj.getDivisionId()+" and ts.subdivision_id="+resObj.getSubdivisionId()+ "   )  ";
						}
						//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


	if((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )){
		
		sql=sql1+ "  and  irum.circle_id="+resObj.getCircleId()+" and irum.division_id="+resObj.getDivisionId()+"  )  union   (SELECT distinct ts.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  'NA' as project_name,  imt.tank_id_mk as tank_id ,coalesce(nrld_code,'0') as nrld_code  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')   inner join   unit_master um   on ( ts.unit_id=um.unit_id and um.delete_flag=false)   inner join   ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join circle_master cm  on(ts1.circle_id=cm.circle_id and cm.delete_flag=false)   where ts1.post_status='ACTIVE' group by imt1.tank_id_mk ) circlenames   on (imt.tank_id_mk=circlenames.tank_id)    left  join ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from invom.invom_mi_tanks as imt1 inner join  taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join division_master dm   on ( ts1.division_id=dm.division_id and dm.delete_flag=false)   where ts1.post_status='ACTIVE'  group by tank_id_mk ) divisionnames   on (imt.tank_id_mk=divisionnames.tank_id)     left join( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from  invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true)  left join subdivision_master sdm on (ts1.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where ts1.post_status='ACTIVE'  group by tank_id_mk ) subdivisionnames   on (imt.tank_id_mk=subdivisionnames.tank_id)        where imt.delete_flag=false   and imt.is_latest=true  and imt.is_nrld=true and  ts.unit_id =  "+ resObj.getUnitId()+" and ts.circle_id="+resObj.getCircleId()+" and ts.division_id="+resObj.getDivisionId()+"    ) "; 
		//System.out.println("DAO Impl 5 "+sql1);
	}
						
	if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

		sql=sql1+ "   and  irum.circle_id= "+resObj.getCircleId()+")  union   (SELECT distinct ts.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  'NA' as project_name,  imt.tank_id_mk as tank_id ,coalesce(nrld_code,'0') as nrld_code  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')   inner join   unit_master um   on ( ts.unit_id=um.unit_id and um.delete_flag=false)   inner join   ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join circle_master cm  on(ts1.circle_id=cm.circle_id and cm.delete_flag=false)   where ts1.post_status='ACTIVE' group by imt1.tank_id_mk ) circlenames   on (imt.tank_id_mk=circlenames.tank_id)    left  join ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from invom.invom_mi_tanks as imt1 inner join  taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join division_master dm   on ( ts1.division_id=dm.division_id and dm.delete_flag=false)   where ts1.post_status='ACTIVE'  group by tank_id_mk ) divisionnames   on (imt.tank_id_mk=divisionnames.tank_id)     left join( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from  invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true)  left join subdivision_master sdm on (ts1.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where ts1.post_status='ACTIVE'  group by tank_id_mk ) subdivisionnames   on (imt.tank_id_mk=subdivisionnames.tank_id)        where imt.delete_flag=false   and imt.is_latest=true  and imt.is_nrld=true and  ts.unit_id =  "+ resObj.getUnitId()+" and ts.circle_id="+resObj.getCircleId()+"    )";
	//System.out.println("DAO Impl 7 "+sql1);
	}
						}

		if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
	if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

		sql=sql1 + " )  union   (SELECT distinct ts.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  'NA' as project_name,  imt.tank_id_mk as tank_id ,coalesce(nrld_code,'0') as nrld_code  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')   inner join   unit_master um   on ( ts.unit_id=um.unit_id and um.delete_flag=false)   inner join   ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join circle_master cm  on(ts1.circle_id=cm.circle_id and cm.delete_flag=false)   where ts1.post_status='ACTIVE' group by imt1.tank_id_mk ) circlenames   on (imt.tank_id_mk=circlenames.tank_id)    left  join ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from invom.invom_mi_tanks as imt1 inner join  taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join division_master dm   on ( ts1.division_id=dm.division_id and dm.delete_flag=false)   where ts1.post_status='ACTIVE'  group by tank_id_mk ) divisionnames   on (imt.tank_id_mk=divisionnames.tank_id)     left join( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from  invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true)  left join subdivision_master sdm on (ts1.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where ts1.post_status='ACTIVE'  group by tank_id_mk ) subdivisionnames   on (imt.tank_id_mk=subdivisionnames.tank_id)        where imt.delete_flag=false   and imt.is_latest=true  and imt.is_nrld=true and  ts.unit_id =  "+ resObj.getUnitId()+"   )"; 
	//System.out.println("DAO Impl 9 "+sql1);
	}
		}
	if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
			||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
			||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
			||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
			){

		sql=sql1  + " )  union   (SELECT distinct ts.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  'NA' as project_name,  imt.tank_id_mk as tank_id ,coalesce(nrld_code,'0') as nrld_code  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')   inner join   unit_master um   on ( ts.unit_id=um.unit_id and um.delete_flag=false)   inner join   ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join circle_master cm  on(ts1.circle_id=cm.circle_id and cm.delete_flag=false)   where ts1.post_status='ACTIVE' group by imt1.tank_id_mk ) circlenames   on (imt.tank_id_mk=circlenames.tank_id)    left  join ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from invom.invom_mi_tanks as imt1 inner join  taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join division_master dm   on ( ts1.division_id=dm.division_id and dm.delete_flag=false)   where ts1.post_status='ACTIVE'  group by tank_id_mk ) divisionnames   on (imt.tank_id_mk=divisionnames.tank_id)     left join( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from  invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true)  left join subdivision_master sdm on (ts1.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where ts1.post_status='ACTIVE'  group by tank_id_mk ) subdivisionnames   on (imt.tank_id_mk=subdivisionnames.tank_id)        where imt.delete_flag=false   and imt.is_latest=true  and imt.is_nrld=true and  ts.unit_id =  "+ resObj.getUnitId()+"   ) ";
	//System.out.println("DAO Impl 10 "+sql1);
	}
					
		
			}}
		try {

			
		//System.out.println("sql"+sql+ "unitId" +unitId+circleId+divisionId+subdivisionId+postId+dId);
			List<ReservoirInspect> reservoirUnitDataList = jdbcTemplate8.query(sql,new Object[]{unitId}, new RowMapper<ReservoirInspect>() {

				public ReservoirInspect mapRow(ResultSet rs, int rowNum) throws SQLException {

					ReservoirInspect reservoirUnitData = new ReservoirInspect();
					
				//	System.out.println("sql2"+rs.getInt(1));
					reservoirUnitData.setUnitId(rs.getInt(1));
					reservoirUnitData.setReservoirId(rs.getInt(2));
					reservoirUnitData.setResName(rs.getString(3));
					reservoirUnitData.setUnitName(rs.getString(4));
					reservoirUnitData.setCircleName(rs.getString(5));
					reservoirUnitData.setDivisionName(rs.getString(6));
					reservoirUnitData.setSubdivisionName(rs.getString(7));
					reservoirUnitData.setProjectName(rs.getString(8));
					
	                       reservoirUnitData.setTankId(rs.getInt(9));
					
					reservoirUnitData.setNrldCode(rs.getString(10));
				
					
					
					
					
					
					
				
				
					

					return reservoirUnitData;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return reservoirUnitDataList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	
	@Override
	public List<ReservoirInspect> getAllrestotalnrldresList(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =null;
		
		Integer	year=0;
		Integer unitId=0;
		Integer dId=0;
		Integer circleId=0;
		Integer divisionId=0;
		Integer freq=0;
		
		Integer subdivisionId=0;
		Long postId=0l;
		
		String sql1=SELECT_ALL_NRLD_RES_TOTAL;
		String sqlUt=null;
		
		if (resObj.getUnitId() == null) {

		

			
			
			year= resObj.getYear();
			unitId=resObj.getUnitId();
			circleId=resObj.getCircleId();
			divisionId=resObj.getDivisionId();
			freq=resObj.getDutyFrequencyId();
			subdivisionId=resObj.getSubdivisionId();
			
			postId=resObj.getPostId();
			dId=resObj.getDesignationId();
		
					
				
						


		sql=sql1  + " )  union   (SELECT distinct ts.unit_id,   0 as reservoir_id,  tank_name,  um.unit_name,   circlenames.circle_name,  divisionnames.division_name,   subdivisionnames.subdivision_name,  'NA' as project_name,  imt.tank_id_mk as tank_id ,coalesce(nrld_code,'0') as nrld_code,'Minor'  as ptype  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')   inner join   unit_master um   on ( ts.unit_id=um.unit_id and um.delete_flag=false)   inner join   ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(circle_name,'0'))) , ',') as circle_name   from invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join circle_master cm  on(ts1.circle_id=cm.circle_id and cm.delete_flag=false)   where ts1.post_status='ACTIVE' group by imt1.tank_id_mk ) circlenames   on (imt.tank_id_mk=circlenames.tank_id)    left  join ( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(division_name,'0'))) , ',') as division_name   from invom.invom_mi_tanks as imt1 inner join  taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true) left join division_master dm   on ( ts1.division_id=dm.division_id and dm.delete_flag=false)   where ts1.post_status='ACTIVE'  group by tank_id_mk ) divisionnames   on (imt.tank_id_mk=divisionnames.tank_id)     left join( select distinct tank_id_mk as tank_id,array_to_string(array_agg(distinct(coalesce(subdivision_name,'0'))) , ',') as subdivision_name    from  invom.invom_mi_tanks as imt1 inner join taskmanagement.subposts ts1  on (imt1.post_id=ts1.postid and imt1.delete_flag=false and imt1.is_latest=true and imt1.is_nrld=true)  left join subdivision_master sdm on (ts1.subdivision_id=sdm.subdivision_id and sdm.delete_flag=false )   where ts1.post_status='ACTIVE'  group by tank_id_mk ) subdivisionnames   on (imt.tank_id_mk=subdivisionnames.tank_id)        where imt.delete_flag=false   and imt.is_latest=true  and imt.is_nrld=true    ) ";
	//System.out.println("DAO Impl 10 "+sql);
	
					
		
			}
		try {

			
		//System.out.println("sql"+sql+ "unitId" +unitId+circleId+divisionId+subdivisionId+postId+dId);
			List<ReservoirInspect> reservoirUnitDataList = jdbcTemplate8.query(sql,new Object[]{}, new RowMapper<ReservoirInspect>() {

				public ReservoirInspect mapRow(ResultSet rs, int rowNum) throws SQLException {

					ReservoirInspect reservoirUnitData = new ReservoirInspect();
					
				//	System.out.println("sql2"+rs.getInt(1));
					reservoirUnitData.setUnitId(rs.getInt(1));
					reservoirUnitData.setReservoirId(rs.getInt(2));
					reservoirUnitData.setResName(rs.getString(3));
					reservoirUnitData.setUnitName(rs.getString(4));
					reservoirUnitData.setCircleName(rs.getString(5));
					reservoirUnitData.setDivisionName(rs.getString(6));
					reservoirUnitData.setSubdivisionName(rs.getString(7));
					reservoirUnitData.setProjectName(rs.getString(8));
					
	                       reservoirUnitData.setTankId(rs.getInt(9));
					
					reservoirUnitData.setNrldCode(rs.getString(10));
					
					reservoirUnitData.setPtype(rs.getString(11));
				
					
					
					
					
					
					
				
				
					

					return reservoirUnitData;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return reservoirUnitDataList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	
	@Override
	public List<ReservoirInspect> getResInspectInfobyUnitId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=null ;
		String sql1=GET_RES_INSPECT_INFO_UNIT_ID;
		
		Integer year=0;
		Integer unitId=0;
		Integer circleId=0;
		Integer divisionId=0;
		Integer freq=0;
		
		Integer subdivisionId=0;
		Long postId=0l;
		
		Integer dId=0;
		
		if (resObj.getConditionofDamId() != null) {

			if (resObj.getConditionofDamId() >= 0) {

				if (resObj.getConditionofDamId() == 0) {

				

			
		
	
		if(resObj.getUnitId()!=null  && resObj.getYear()!=null && resObj.getDutyFrequencyId()!=null  ){
			
			year= resObj.getYear();
			unitId=resObj.getUnitId();
			circleId=resObj.getCircleId();
			divisionId=resObj.getDivisionId();
			freq=resObj.getDutyFrequencyId();
			subdivisionId=resObj.getSubdivisionId();
			
			postId=resObj.getPostId();
			dId=resObj.getDesignationId();
		
					
				
						if(unitId!=4  ){
						if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
								if((dId==2)||(dId==8)|| (dId==4)) {
									sql=sql1 + " and irdiam.circle_id= "+resObj.getCircleId()+ " and irdiam.division_id= "+resObj.getDivisionId() + " and irdiam.subdivision_id= "+ resObj.getSubdivisionId() +" and irdiam.post_id= "+ resObj.getPostId() ; 
						}							
								
							
						}
	if(((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))|| ((dId==5 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))){
							
		sql=sql1 + " and irdiam.circle_id= "+resObj.getCircleId() +" and irdiam.division_id= "+ resObj.getDivisionId() +" and irdiam.subdivision_id= "+ resObj.getSubdivisionId();
						}
						//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


	if(((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )) || ((dId==7 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 ))){
		
		sql=sql1+ " and irdiam.circle_id= "+resObj.getCircleId()+" and irdiam.division_id=  "+ resObj.getDivisionId() ;
		//System.out.println("DAO Impl 5 "+sql1);
	}
						
	if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

		sql=sql1+ " and irdiam.circle_id= "+ resObj.getCircleId() ;
	//System.out.println("DAO Impl 7 "+sql1);
	}
						}

		if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
	if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

		sql=sql1 ;
	//System.out.println("DAO Impl 9 "+sql1);
	}
		}
	if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
			||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
			||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
			||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
			){

		sql=sql1  ;
	
	}
					}
		} else if (resObj.getConditionofDamId() > 0) {

			

			
			
			
			if(resObj.getUnitId()!=null  && resObj.getYear()!=null && resObj.getDutyFrequencyId()!=null && resObj.getConditionofDamId()!=null  ){
				
				year= resObj.getYear();
				unitId=resObj.getUnitId();
				circleId=resObj.getCircleId();
				divisionId=resObj.getDivisionId();
				freq=resObj.getDutyFrequencyId();
				subdivisionId=resObj.getSubdivisionId();
				
				postId=resObj.getPostId();
				dId=resObj.getDesignationId();
			
						
					
							if(unitId!=4  ){
							if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
									if((dId==2)||(dId==8)|| (dId==4)) {
										sql=sql1 + " and irdiam.circle_id= "+resObj.getCircleId()+ " and irdiam.division_id= "+resObj.getDivisionId() + " and irdiam.subdivision_id= "+ resObj.getSubdivisionId() +" and irdiam.post_id= "+ resObj.getPostId() +" and irdiam.condition_dam_id = "+resObj.getConditionofDamId() ; 
							}							
									
								
							}
		if(((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))||(((dId==5 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0)))){
								
			sql=sql1 + " and irdiam.circle_id= "+resObj.getCircleId() +" and irdiam.division_id= "+ resObj.getDivisionId() +" and irdiam.subdivision_id= "+ resObj.getSubdivisionId() +" and irdiam.condition_dam_id = "+resObj.getConditionofDamId();
							}
							//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


		if(((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 ))|| (((dId==7 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )))){
			
			sql=sql1+ " and irdiam.circle_id= "+resObj.getCircleId()+" and irdiam.division_id=  "+ resObj.getDivisionId()+" and irdiam.condition_dam_id = "+resObj.getConditionofDamId() ;
			//System.out.println("DAO Impl 5 "+sql1);
		}
							
		if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

			sql=sql1+ " and irdiam.circle_id= "+ resObj.getCircleId()+" and irdiam.condition_dam_id = "+resObj.getConditionofDamId() ;
		//System.out.println("DAO Impl 7 "+sql1);
		}
							}

			if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
		if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

			sql=sql1+" and irdiam.condition_dam_id = "+resObj.getConditionofDamId() ;
		//System.out.println("DAO Impl 9 "+sql1);
		}
			}
		if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
				||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
				||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
				||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
				){

			sql=sql1 + " and irdiam.condition_dam_id = "+resObj.getConditionofDamId() ;
		
		}
						}
			}
			}}
		
		try {
			
			//System.out.println("DAO Impl 10 "+sql);
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getYear(),resObj.getDutyFrequencyId(),resObj.getUnitId()  },
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect    resinfo = new ReservoirInspect();
							
							resinfo.setResinspectInfoId(rs.getInt(1));
							resinfo.setReservoirId(rs.getInt(2));
							resinfo.setIsLatest(rs.getBoolean(3));							
							resinfo.setUnitId(rs.getInt(4));
							resinfo.setCircleId(rs.getInt(5));
							resinfo.setDivisionId(rs.getInt(6));
							resinfo.setSubdivisionId(rs.getInt(7));
							resinfo.setProjectId(rs.getInt(8));
							resinfo.setDesignationId(rs.getInt(9));
							resinfo.setInspectOfficeId(rs.getInt(10));
							resinfo.setInspectOfficerData(rs.getString(11));
							resinfo.setFieldOfficerData(rs.getString(12));
							resinfo.setInspectDate(rs.getString(13));
							resinfo.setPresentWaterlevel(rs.getDouble(14));
							
							resinfo.setEmpId(rs.getInt(15));
							resinfo.setPostId(rs.getLong(16));
							resinfo.setNextPostId(rs.getLong(17));
							resinfo.setSectionId(rs.getInt(18));
							resinfo.setNextEmpId(rs.getInt(19));
							resinfo.setLevelId(rs.getInt(20));
							resinfo.setResInspectMst1Id(rs.getInt(21));
							resinfo.setInspectOfficeName(rs.getString(22));
							
							resinfo.setStorageCapacity(rs.getDouble(23));
							resinfo.setWeathercondition(rs.getString(24));
							resinfo.setTypeofinspection(rs.getString(25));
							resinfo.setTankId(rs.getInt(26));
							
							
							
						
							return resinfo;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return reslist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	
	
	@Override
	public List<ReservoirInspect> getResCategoryInspectInfobyUnitId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=null ;
		String sql1=GET_RES_CAT_INSPECT_INFO_UNIT_ID;
		
		String sql2=GET_RES_CATNA_INSPECT_INFO_UNIT_ID;
		
		Integer year=0;
		Integer unitId=0;
		Integer circleId=0;
		Integer divisionId=0;
		Integer freq=0;
		
		Integer subdivisionId=0;
		Long postId=0l;
		
		Integer dId=0;
		
		if (resObj.getDeficiencyCategory() != null) {

		

				if (resObj.getDeficiencyCategory() > 0 && resObj.getDeficiencyCategory()==4 ) {

				

			
		
	
		if(resObj.getUnitId()!=null  && resObj.getYear()!=null && resObj.getDutyFrequencyId()!=null  ){
			
			year= resObj.getYear();
			unitId=resObj.getUnitId();
			circleId=resObj.getCircleId();
			divisionId=resObj.getDivisionId();
			freq=resObj.getDutyFrequencyId();
			subdivisionId=resObj.getSubdivisionId();
			
			postId=resObj.getPostId();
			dId=resObj.getDesignationId();
		
					
				
						if(unitId!=4  ){
						if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
								if((dId==2)||(dId==8)|| (dId==4)) {
									sql=sql2 + " and irdiam.circle_id= "+resObj.getCircleId()+ " and irdiam.division_id= "+resObj.getDivisionId() + " and irdiam.subdivision_id= "+ resObj.getSubdivisionId() +" and irdiam.post_id= "+ resObj.getPostId() ; 
						}							
								
							
						}
	if(((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))||(((dId==5 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0)))){
							
		sql=sql2 + " and irdiam.circle_id= "+resObj.getCircleId() +" and irdiam.division_id= "+ resObj.getDivisionId() +" and irdiam.subdivision_id= "+ resObj.getSubdivisionId();
						}
						//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


	if(((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 ))||((dId==7 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 ))){
		
		sql=sql2+ " and irdiam.circle_id= "+resObj.getCircleId()+" and irdiam.division_id=  "+ resObj.getDivisionId() ;
		//System.out.println("DAO Impl 5 "+sql1);
	}
						
	if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

		sql=sql2+ " and irdiam.circle_id= "+ resObj.getCircleId() ;
	//System.out.println("DAO Impl 7 "+sql1);
	}
						}

		if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
	if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

		sql=sql2 ;
	//System.out.println("DAO Impl 9 "+sql1);
	}
		}
	if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
			||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
			||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
			||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
			){

		sql=sql2  ;
	
	}
					}
		} else if (resObj.getDeficiencyCategory()>0 &&  resObj.getDeficiencyCategory()!=4) {

			

			
			
			
			if(resObj.getUnitId()!=null  && resObj.getYear()!=null && resObj.getDutyFrequencyId()!=null && resObj.getDeficiencyCategory()!=null  ){
				
				year= resObj.getYear();
				unitId=resObj.getUnitId();
				circleId=resObj.getCircleId();
				divisionId=resObj.getDivisionId();
				freq=resObj.getDutyFrequencyId();
				subdivisionId=resObj.getSubdivisionId();
				
				postId=resObj.getPostId();
				dId=resObj.getDesignationId();
			
						
					
							if(unitId!=4  ){
							if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
									if((dId==2)||(dId==8)|| (dId==4)) {
										sql=sql1 + " and irdiam.circle_id= "+resObj.getCircleId()+ " and irdiam.division_id= "+resObj.getDivisionId() + " and irdiam.subdivision_id= "+ resObj.getSubdivisionId() +" and irdiam.post_id= "+ resObj.getPostId() +" and irdh.deficiency_category = "+resObj.getDeficiencyCategory() ; 
							}							
									
								
							}
		if(((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))||(((dId==5 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0)))){
								
			sql=sql1 + " and irdiam.circle_id= "+resObj.getCircleId() +" and irdiam.division_id= "+ resObj.getDivisionId() +" and irdiam.subdivision_id= "+ resObj.getSubdivisionId() +" and irdh.deficiency_category = "+resObj.getDeficiencyCategory();
							}
							//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


		if(((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 ))||(((dId==7 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )))){
			
			sql=sql1+ " and irdiam.circle_id= "+resObj.getCircleId()+" and irdiam.division_id=  "+ resObj.getDivisionId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory() ;
			//System.out.println("DAO Impl 5 "+sql1);
		}
							
		if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

			sql=sql1+ " and irdiam.circle_id= "+ resObj.getCircleId()+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory() ;
		//System.out.println("DAO Impl 7 "+sql1);
		}
							}

			if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
		if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

			sql=sql1+" and irdh.deficiency_category = "+resObj.getDeficiencyCategory() ;
		//System.out.println("DAO Impl 9 "+sql1);
		}
			}
		if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
				||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
				||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
				||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
				){

			sql=sql1 + " and irdh.deficiency_category = "+resObj.getDeficiencyCategory() ;
		
		}
						}
			}
			}
		
		try {
			
			//System.out.println("DAO Impl 10 "+sql);
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getYear(),resObj.getDutyFrequencyId(),resObj.getUnitId()  },
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect    resinfo = new ReservoirInspect();
							
							resinfo.setResinspectInfoId(rs.getInt(1));
							resinfo.setReservoirId(rs.getInt(2));
							resinfo.setIsLatest(rs.getBoolean(3));							
							resinfo.setUnitId(rs.getInt(4));
							resinfo.setCircleId(rs.getInt(5));
							resinfo.setDivisionId(rs.getInt(6));
							resinfo.setSubdivisionId(rs.getInt(7));
							resinfo.setProjectId(rs.getInt(8));
							resinfo.setDesignationId(rs.getInt(9));
							resinfo.setInspectOfficeId(rs.getInt(10));
							resinfo.setInspectOfficerData(rs.getString(11));
							resinfo.setFieldOfficerData(rs.getString(12));
							resinfo.setInspectDate(rs.getString(13));
							resinfo.setPresentWaterlevel(rs.getDouble(14));
							
							resinfo.setEmpId(rs.getInt(15));
							resinfo.setPostId(rs.getLong(16));
							resinfo.setNextPostId(rs.getLong(17));
							resinfo.setSectionId(rs.getInt(18));
							resinfo.setNextEmpId(rs.getInt(19));
							resinfo.setLevelId(rs.getInt(20));
							resinfo.setResInspectMst1Id(rs.getInt(21));
							resinfo.setInspectOfficeName(rs.getString(22));
							
							resinfo.setStorageCapacity(rs.getDouble(23));
							resinfo.setWeathercondition(rs.getString(24));
							resinfo.setTypeofinspection(rs.getString(25));
							resinfo.setTankId(rs.getInt(26));
							
							
							
						
							return resinfo;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return reslist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	
	
	
	
	@Override
	public List<ReservoirInspect> getResHealthInfobyUnitId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=null ;
		String sql1=GET_RES_HEALTH_INFO_UNIT_ID;
		
		Integer year=0;
		Integer unitId=0;
		Integer circleId=0;
		Integer divisionId=0;
		Integer freq=0;
		
		Integer subdivisionId=0;
		Long postId=0l;
		
		Integer dId=0;
		
		if (resObj.getConditionofDamId() != null) {

			if (resObj.getConditionofDamId() >= 0) {

				if (resObj.getConditionofDamId() == 0) {

				

			
		
	
		if(resObj.getUnitId()!=null  && resObj.getYear()!=null && resObj.getDutyFrequencyId()!=null  ){
			
			year= resObj.getYear();
			unitId=resObj.getUnitId();
			circleId=resObj.getCircleId();
			divisionId=resObj.getDivisionId();
			freq=resObj.getDutyFrequencyId();
			subdivisionId=resObj.getSubdivisionId();
			
			postId=resObj.getPostId();
			dId=resObj.getDesignationId();
		
					
				
						if(unitId!=4  ){
						if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
								if((dId==2)||(dId==8)|| (dId==4)) {
									sql=sql1 + " and irdam.circle_id= "+resObj.getCircleId()+ " and irdam.division_id= "+resObj.getDivisionId() + " and irdam.subdivision_id= "+ resObj.getSubdivisionId() +" and irdam.post_id= "+ resObj.getPostId() +" order by irdh.res_ann1_mst1_id "; 
						}							
								
							
						}
	if(((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))|| ((dId==5 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))){
							
		sql=sql1 + " and irdam.circle_id= "+resObj.getCircleId() +" and irdam.division_id= "+ resObj.getDivisionId() +" and irdam.subdivision_id= "+ resObj.getSubdivisionId() +" order by irdh.res_ann1_mst1_id ";
						}
						//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


	if(((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )) || ((dId==7 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 ))){
		
		sql=sql1+ " and irdam.circle_id= "+resObj.getCircleId()+" and irdam.division_id=  "+ resObj.getDivisionId() +" order by irdh.res_ann1_mst1_id " ;
		//System.out.println("DAO Impl 5 "+sql1);
	}
						
	if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

		sql=sql1+ " and irdam.circle_id= "+ resObj.getCircleId() +" order by irdh.res_ann1_mst1_id " ;
	//System.out.println("DAO Impl 7 "+sql1);
	}
						}

		if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
	if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

		sql=sql1 ;
	//System.out.println("DAO Impl 9 "+sql1);
	}
		}
	if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
			||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
			||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
			||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
			){

		sql=sql1  ;
	
	}
					}
		} else if (resObj.getConditionofDamId() > 0) {

			

			
			
			
			if(resObj.getUnitId()!=null  && resObj.getYear()!=null && resObj.getDutyFrequencyId()!=null && resObj.getConditionofDamId()!=null  ){
				
				year= resObj.getYear();
				unitId=resObj.getUnitId();
				circleId=resObj.getCircleId();
				divisionId=resObj.getDivisionId();
				freq=resObj.getDutyFrequencyId();
				subdivisionId=resObj.getSubdivisionId();
				
				postId=resObj.getPostId();
				dId=resObj.getDesignationId();
			
						
					
							if(unitId!=4  ){
							if((resObj.getSubdivisionId()>0 && resObj.getPostId()>0)){
									if((dId==2)||(dId==8)|| (dId==4)) {
										sql=sql1 + " and irdam.circle_id= "+resObj.getCircleId()+ " and irdam.division_id= "+resObj.getDivisionId() + " and irdam.subdivision_id= "+ resObj.getSubdivisionId() +" and irdam.post_id= "+ resObj.getPostId() +" and irdam.condition_dam_id = "+resObj.getConditionofDamId() +" order by irdh.res_ann1_mst1_id " ; 
							}							
									
								
							}
		if(((dId==4 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0))||(((dId==5 ) && (resObj.getSubdivisionId()>0 && resObj.getPostId()==0)))){
								
			sql=sql1 + " and irdam.circle_id= "+resObj.getCircleId() +" and irdam.division_id= "+ resObj.getDivisionId() +" and irdam.subdivision_id= "+ resObj.getSubdivisionId() +" and irdam.condition_dam_id = "+resObj.getConditionofDamId() +" order by irdh.res_ann1_mst1_id " ;
							}
							//sql1=sql+"  and imt1.unit_id="+miinspect.getUnitId()+"  and imt1.mi_check_frequency_id="+miinspect.getMiTankFreqId()+" and imt1.tank_status_id in (1,2,3,4) and freq_year="+miinspect.getYear()  ; 


		if(((dId==5 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 ))|| (((dId==7 ) && (unitId>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()>0 ) && (resObj.getSubdivisionId()==0 )))){
			
			sql=sql1+ " and irdam.circle_id= "+resObj.getCircleId()+" and irdam.division_id=  "+ resObj.getDivisionId()+" and irdam.condition_dam_id = "+resObj.getConditionofDamId() +" order by irdh.res_ann1_mst1_id " ;
			//System.out.println("DAO Impl 5 "+sql1);
		}
							
		if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()>0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

			sql=sql1+ " and irdam.circle_id= "+ resObj.getCircleId()+" and irdam.condition_dam_id = "+resObj.getConditionofDamId() +" order by irdh.res_ann1_mst1_id ";
		//System.out.println("DAO Impl 7 "+sql1);
		}
							}

			if(unitId!=4 && unitId!=9832 && unitId!=9830)	{
		if( (resObj.getUnitId()>0 )&& (resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 )){

			sql=sql1+" and irdam.condition_dam_id = "+resObj.getConditionofDamId() +" order by irdh.res_ann1_mst1_id " ;
		//System.out.println("DAO Impl 9 "+sql1);
		}
			}
		if( ((resObj.getUnitId()>0 )&& (unitId==4 || unitId==9832 || unitId==9830 ) && 	(resObj.getCircleId()==0) && (resObj.getDivisionId()==0 ) && (resObj.getSubdivisionId()==0 ))
				||(resObj.getUnitId()==4 && resObj.getCircleId()==104 && resObj.getDivisionId()==30327&& resObj.getDesignationId()==5)
				||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==31099 && resObj.getDesignationId()==5)
				||(resObj.getUnitId()==9830 && resObj.getCircleId()==21609 && resObj.getDivisionId()==0 && resObj.getDesignationId()==7)
				){

			sql=sql1 + " and irdam.condition_dam_id = "+resObj.getConditionofDamId() +" order by irdh.res_ann1_mst1_id " ;
		
		}
						}
			}
			}}
		
		try {
			
			//System.out.println("DAO Impl 10 "+sql+"unit"+resObj.getUnitId());
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getYear(),resObj.getDutyFrequencyId(),resObj.getUnitId()  },
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect    resinfo = new ReservoirInspect();
							
							resinfo.setResDamHealthId(rs.getInt(1));
							resinfo.setResInspectMst1Id(rs.getInt(2));
							resinfo.setRemarks(rs.getString(3));
							resinfo.setDesignationId(rs.getInt(4));
							resinfo.setReservoirId(rs.getInt(5));
							resinfo.setTankId(rs.getInt(6));
							resinfo.setResinspectInfoId(rs.getInt(7));
							resinfo.setPostId(rs.getLong(8));
							resinfo.setInspectOfficeName(rs.getString(9));
							resinfo.setDeficiencyCategory(rs.getInt(10));
							resinfo.setDeficiencyCategoryName(rs.getString(11));
							resinfo.setIsLatest(rs.getBoolean(12));
							
							
							
							
							
						
							return resinfo;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return reslist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	
	
	
	@Override
	public List<ReservoirUnitData> getinvomresann1resInfobyrescode(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_INVOM_RES_ANN1_BY_RESCODE;
		
		String val=null;
		
		Integer year=0;
		
		Integer unitId=0;
		//System.out.println("resStatus"+resStatus+"--"+unitId);
       if(resObj!=null){
    	   
    	   if(resObj.getReservoirId()!=null && resObj.getYear()!=null &&  resObj.getUnitId()!=null){
		
		//val=resObj.getResCode().replace("\"", "");
		
		year=resObj.getYear();
		
		unitId=resObj.getUnitId();
    	   }
       }
		
		try {

			
			//System.out.println("sql"+sql);
			List<ReservoirUnitData> reservoirUnitDataList = jdbcTemplate8.query(sql,new Object[]{resObj.getReservoirId(),year,unitId}, new RowMapper<ReservoirUnitData>() {

				public ReservoirUnitData mapRow(ResultSet rs, int rowNum) throws SQLException {

					ReservoirUnitData reservoirUnitData = new ReservoirUnitData();
					
				//	System.out.println("sql2"+rs.getInt(1));
					reservoirUnitData.setUnitId(rs.getInt(1));
					reservoirUnitData.setReservoirId(rs.getString(2));
					reservoirUnitData.setResName(rs.getString(3));
					reservoirUnitData.setUnitName(rs.getString(4));
					reservoirUnitData.setCircleName(rs.getString(5));
					reservoirUnitData.setDivisionName(rs.getString(6));
					reservoirUnitData.setSubdivisionName(rs.getString(7));
					reservoirUnitData.setProjectName(rs.getString(8));
					
					
					reservoirUnitData.setYear(rs.getInt(9));
					
					if(rs.getInt(10)==1){
						
						reservoirUnitData.setResStatus("Observation");
						
					}
if(rs.getInt(10)==2){
						
						reservoirUnitData.setResStatus("Emergency");
						
					}

if(rs.getInt(10)==3){
	
	reservoirUnitData.setResStatus("Maintenance");
	
}
if(rs.getInt(10)==4){
	
	reservoirUnitData.setResStatus("Original work");
	
}
					
				
					

					return reservoirUnitData;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return reservoirUnitDataList;
		} catch (Exception exc) {

			return null;
		}
	}

	
	@Override
	public List<ReservoirInspect> getResAnn1tabsInfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =SELECT_RES_ANN1_DETAIL_TABINFO ; 
		
		
		
		
		String resCode=null;
		Integer year=0;
		
		Integer unitId=0;
		try {
if(resObj.getReservoirId()!=null && resObj.getYear()!=null  && resObj.getUnitId()!=null){
				
				/*if(resObj.getResCode()!=null){
					resCode=resObj.getResCode().replace("\"", "");;
					
				}
				*/
				if(resObj.getYear()>0){
					
					year=resObj.getYear();
				}
				
if(resObj.getUnitId()>0){
					
	unitId=resObj.getUnitId();
				}
				
				
}
			
		//System.out.println("year"+sql+""+tankId+year+freqId);	
		List<ReservoirInspect> resann1List = jdbcTemplate8.query(sql,new Object[]{resObj.getReservoirId(),year,unitId },
				new RowMapper<ReservoirInspect>() {

					public ReservoirInspect mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						
						

						ReservoirInspect sd = new ReservoirInspect();
						
						sd.setResInspectId(rs.getInt(1));
						sd.setResCheckId(rs.getInt(2));
						sd.setResCatId(rs.getInt(3));
					
					
						
						sd.setYear(rs.getInt(4));
						sd.setResCheckName(rs.getString(5));
						
						sd.setRemarks(rs.getString(6));
						
						

						
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		
	//	System.out.println("scheduleofDutiesList"+resann1List);
		return resann1List;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<InvResAbstract> getResAbstractAnn2List(ReservoirInspect reservoirObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_ANN2_ABSTRACT;
		
		Integer year=0;
		try {
			
			if(reservoirObj.getYear()>0){
				
				year=reservoirObj.getYear();
			}

			List<InvResAbstract> invResAbstractList = jdbcTemplate8.query(sql,new Object[]{year }, new RowMapper<InvResAbstract>() {

				public InvResAbstract mapRow(ResultSet rs, int rowNum) throws SQLException {

					InvResAbstract invResAbstract = new InvResAbstract();
					invResAbstract.setUnitId(rs.getInt(1));
					invResAbstract.setResCode(rs.getString(2));
					invResAbstract.setYear(rs.getInt(3));
					invResAbstract.setResName(rs.getString(4));
					invResAbstract.setUnitName(rs.getString(5));
					invResAbstract.setRescheckTotalCount(rs.getInt(6));
					invResAbstract.setResInspectCount(rs.getInt(7));
					invResAbstract.setResInspectMst1Id(rs.getInt(8));
					
					return invResAbstract;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return invResAbstractList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	@Override
	public List<ReservoirUnitData> getinvomresann2resInfobyrescode(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_INVOM_RES_ANN2_BY_RESCODE;
		
		String val=null;
		
		Integer year=0;
		
		Integer unitId=0;
		//System.out.println("resStatus"+resStatus+"--"+unitId);
       if(mst1Id!=null){
    	   
    	  
       }
		
		try {

			
			//System.out.println("sql"+sql);
			List<ReservoirUnitData> reservoirUnitDataList = jdbcTemplate8.query(sql,new Object[]{mst1Id}, new RowMapper<ReservoirUnitData>() {

				public ReservoirUnitData mapRow(ResultSet rs, int rowNum) throws SQLException {

					ReservoirUnitData reservoirUnitData = new ReservoirUnitData();
					
				//	System.out.println("sql2"+rs.getInt(1));
					reservoirUnitData.setUnitId(rs.getInt(1));
					reservoirUnitData.setReservoirId(rs.getString(2));
					reservoirUnitData.setResName(rs.getString(3));
					reservoirUnitData.setUnitName(rs.getString(4));
					reservoirUnitData.setCircleName(rs.getString(5));
					reservoirUnitData.setDivisionName(rs.getString(6));
					reservoirUnitData.setSubdivisionName(rs.getString(7));
					reservoirUnitData.setProjectName(rs.getString(8));
					
					reservoirUnitData.setResStatus(rs.getString(9));
					reservoirUnitData.setYear(rs.getInt(10));
					

					return reservoirUnitData;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return reservoirUnitDataList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	@Override
	public List<ReservoirInspect> getResAnn2tabsInfo(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =SELECT_RES_ANN2_DETAIL_TABINFO ; 
		
		
		
		
		String resCode=null;
		Integer mst1id=0;
		
		Integer unitId=0;
		try {
if(mst1Id!=null){
				
	mst1id=mst1Id;
				
				
}
			
		//System.out.println("year"+sql+""+tankId+year+freqId);	
		List<ReservoirInspect> resann1List = jdbcTemplate8.query(sql,new Object[]{mst1id },
				new RowMapper<ReservoirInspect>() {

					public ReservoirInspect mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						
						

						ReservoirInspect sd = new ReservoirInspect();
						
						sd.setResInspectMst2Id(rs.getInt(1));
						sd.setResInspectMst1Id(rs.getInt(2));
						sd.setResCheckId(rs.getInt(3));
						sd.setResCatId(rs.getInt(4));
						sd.setDesignationId(rs.getInt(5));
						sd.setRemarks(rs.getString(6));
						sd.setApprovStatusId(rs.getInt(7));
						
						sd.setResCheckName(rs.getString(8));
						sd.setStatusName(rs.getString(9));
						
						

						
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		
	//	System.out.println("scheduleofDutiesList"+resann1List);
		return resann1List;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ScheduleDuty> getScheduledutyaeedaily(ScheduleDuty scObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =null ; 
		
		
		
		
		
		String  date1=null;
		
		String date2=null;
		Integer dutyfreqId=0;
		try {
if(scObj.getFromDate1()!=null && scObj.getFromDate2()!=null  && scObj.getDutyFrequencyId()!=null ){
				
				if(scObj.getFromDate1()!=null){
					date1=scObj.getFromDate1();
					
				}
				
				if(scObj.getFromDate2()!=null){
					
					date2= scObj.getFromDate2();
				}
				
                 if(scObj.getDutyFrequencyId()>0){
					
                	 dutyfreqId= scObj.getDutyFrequencyId();
				}
                 
                 if(dutyfreqId!=null){
                	 
                	 if(dutyfreqId==1){
                	sql=SELECT_SCH_AEE_DAILY ;
                		 
                	 }
                	 if(dutyfreqId==2){
                     	sql=SELECT_SCH_AEE_WEEKLY ;
                     		 
                     	 }
                	 
                	 
                	 
                 }
				
				

				
}
			
		//System.out.println("year"+sql+""+dutyfreqId+date1+date2);	
		List<ScheduleDuty> resann1List = jdbcTemplate8.query(sql,new Object[]{date1,date2,dutyfreqId},
				new RowMapper<ScheduleDuty>() {

					public ScheduleDuty mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						
						

						ScheduleDuty sd = new ScheduleDuty();
						
						
						//System.out.println("kal"+rs.getInt(1));
						sd.setUnitId(rs.getInt(1));
						sd.setResCode(rs.getString(2));
						sd.setDesignationId(rs.getInt(3));
						sd.setResName(rs.getString(4));
						sd.setUnitName(rs.getString(5));
						
						sd.setDesignationName(rs.getString(6));
						
						sd.setDutyFrequencyId(rs.getInt(8));
						sd.setTotalDutyCount(rs.getInt(9));
						 if(rs.getInt(8)==1){
							 sd.setAeedailyCount(rs.getInt(7));
						sd.setInspectDate(rs.getString(10));
						 }
						 if(rs.getInt(8)==2){
							 sd.setAeeweeklycount(rs.getInt(7));
							sd.setWeekstartDate(rs.getString(10)); 
						sd.setWeekendDate(rs.getString(11));	 
							 
						 }
						

						
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		
	//	System.out.println("scheduleofDutiesList"+resann1List);
		return resann1List;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirUnitData> getschaeedailyresinfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = null;
		
		String val=null;
		
		String inspectdate=null;
		
		Integer unitId=0;
		Integer designationid=0;
		Integer dutyfreqid=0;
		//System.out.println("resStatus"+resStatus+"--"+unitId);
       if(resObj!=null){
    	   
    	   if(resObj.getResCode()!=null && resObj.getUnitId()!=null && resObj.getDesignationId()!=null && resObj.getDutyFrequencyId()!=null){
		
		val=resObj.getResCode().replace("\"", "");
		if(resObj.getInspectDate()!=null){
		inspectdate=resObj.getInspectDate();
		}
		
		unitId=resObj.getUnitId();
		designationid=resObj.getDesignationId();
		dutyfreqid=resObj.getDutyFrequencyId();
		
		if(dutyfreqid==1){
			
			sql=SELECT_SCH_AEE_DAILY_RES_INFO +" and to_char(irdia.inspect_date,'dd/mm/yyyy')="+inspectdate; 
			
		}
     if(dutyfreqid==2){
			
			sql=SELECT_SCH_AEE_DAILY_RES_INFO +" and to_date(to_char(irdia.inspect_date,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date('"+resObj.getWeekstartDate()+"' ,'dd/mm/yyyy') and to_date('"+resObj.getWeekendDate()+"','dd/mm/yyyy') ";
			
		}
    	   }
       }
		
		try {

			
		//	System.out.println("sql"+sql);
			List<ReservoirUnitData> reservoirUnitDataList = jdbcTemplate8.query(sql,new Object[]{val,unitId,designationid,dutyfreqid}, new RowMapper<ReservoirUnitData>() {

				public ReservoirUnitData mapRow(ResultSet rs, int rowNum) throws SQLException {

					ReservoirUnitData reservoirUnitData = new ReservoirUnitData();
					
				//	System.out.println("sql2"+rs.getInt(1));
					reservoirUnitData.setUnitId(rs.getInt(1));
					reservoirUnitData.setReservoirId(rs.getString(2));
					reservoirUnitData.setResName(rs.getString(3));
					reservoirUnitData.setUnitName(rs.getString(4));
					reservoirUnitData.setCircleName(rs.getString(5));
					reservoirUnitData.setDivisionName(rs.getString(6));
					reservoirUnitData.setSubdivisionName(rs.getString(7));
					reservoirUnitData.setProjectName(rs.getString(8));
					
					reservoirUnitData.setResStatus(rs.getString(9));
					
					

					return reservoirUnitData;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return reservoirUnitDataList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	
	@Override
	public List<ScheduleDuty> getSchInspectinfo(ScheduleDuty schObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =null;
				
			 
		
		
		
		
		String resCode=null;
		Integer year=0;
		
		Integer unitId=0;
		try {
if(schObj.getResCode()!=null && schObj.getDesignationId()!=null  && schObj.getUnitId()!=null){
				
	
					resCode=schObj.getResCode().replace("\"", "");;
					
				if(schObj.getDutyFrequencyId()==1){	
					sql=SELECT_SCH_INSPECT_INFO+ "and irddi.res_code= '"+resCode+"'  and irddi.res_duty_frequency="+schObj.getDutyFrequencyId()+" and to_date(to_char(irddi.inspect_date,'dd/mm/yyyy'),'dd/mm/yyyy') = to_date('"+schObj.getInspectDate()+"' ,'dd/mm/yyyy') and irddi.designation_id="+schObj.getDesignationId()+" and irddi.unit_id="+schObj.getUnitId();
				
				}
				if(schObj.getDutyFrequencyId()==2){
				
					sql=SELECT_SCH_INSPECT_INFO+ "and irddi.res_code= '"+resCode+"'  and irddi.res_duty_frequency="+schObj.getDutyFrequencyId()+" and to_date(to_char(irddi.inspect_date,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date('"+schObj.getWeekstartDate()+"' ,'dd/mm/yyyy') and to_date('"+schObj.getWeekendDate()+"','dd/mm/yyyy')  and irddi.designation_id="+schObj.getDesignationId()+" and irddi.unit_id="+schObj.getUnitId();
					
				}

				
				
}
			
		//System.out.println("come"+sql);	
		List<ScheduleDuty> resann1List = jdbcTemplate8.query(sql,
				new RowMapper<ScheduleDuty>() {

					public ScheduleDuty mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						
						
						

						ScheduleDuty sd = new ScheduleDuty();
						
						sd.setDutyInspectId(rs.getInt(1));
						sd.setDutyId(rs.getInt(2));
						sd.setParentDutyId(rs.getInt(3));
						sd.setInspectDate(rs.getString(4));
						sd.setDutyFrequencyId(rs.getInt(5));
						sd.setDesignationId(rs.getInt(6));
						sd.setRemarks(rs.getString(7));
						sd.setApproveStatusId(rs.getInt(8));
						if(rs.getBoolean(9)){
						sd.setAction("Yes");
						}else{
							
							sd.setAction("No");	
						}
						sd.setActionReqId(rs.getInt(10));
						sd.setResCode(rs.getString(11));
						sd.setDutyName(rs.getString(12));
						sd.setDutyparentName(rs.getString(13));
						sd.setDesignationName(rs.getString(14));
						sd.setActionReqName(rs.getString(15));
						sd.setApproveStatus(rs.getString(16));
						
						
						

						
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		
	//	System.out.println("scheduleofDutiesList"+resann1List);
		return resann1List;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<PumpMaintainActivities> getpumpmaintainActivity(PumpMaintainActivities pmpObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =null ; 
		
		
		
		
		
		String  date1=null;
		
		String date2=null;
		Integer dutyfreqId=0;
		try {
if(pmpObj.getFromDate1()!=null && pmpObj.getFromDate2()!=null  && pmpObj.getDutyFrequencyId()!=null ){
				
				if(pmpObj.getFromDate1()!=null){
					date1=pmpObj.getFromDate1();
					
				}
				
				if(pmpObj.getFromDate2()!=null){
					
					date2= pmpObj.getFromDate2();
				}
				
                 if(pmpObj.getDutyFrequencyId()>0){
					
                	 dutyfreqId= pmpObj.getDutyFrequencyId();
				}
                 
                 if(dutyfreqId!=null){
                	 
                	 if(dutyfreqId==1){
                	sql=SELECT_PMP_MAIN_DAILY ;
                		 
                	 }
                	 if(dutyfreqId==2){
                     	sql=SELECT_PMP_MAIN_WEEKLY ;
                     		 
                     	 }
                	 
                	 
                	 
                 }
				
				

				
}
			
	//	System.out.println("year"+sql+""+dutyfreqId+date1+date2);	
		List<PumpMaintainActivities> resann1List = jdbcTemplate8.query(sql,new Object[]{date1,date2,dutyfreqId},
				new RowMapper<PumpMaintainActivities>() {

					public PumpMaintainActivities mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						
						

						PumpMaintainActivities sd = new PumpMaintainActivities();
						
						
					//	System.out.println("kal"+rs.getInt(1));
						sd.setUnitId(rs.getInt(1));
						sd.setBasinId(rs.getInt(2));
						sd.setDesignationId(rs.getInt(3));
						sd.setPumpLinkId(rs.getInt(4));
						sd.setPumpStationId(rs.getInt(5));
						sd.setPumpStation(rs.getString(6));
						sd.setPumpLink(rs.getString(7));
						
						
						
						sd.setUnitName(rs.getString(8));
						
						sd.setDesignationName(rs.getString(9));
						
						
						
						sd.setTotalDutyCount(rs.getInt(12));
						sd.setDutyFrequencyId(rs.getInt(11));
						 if(rs.getInt(11)==1){
							 sd.setDailyCount(rs.getInt(10));	
						sd.setInspectDate(rs.getString(13));
						sd.setInspectHour(rs.getInt(14));
						 }
						 if(rs.getInt(11)==2){
							 sd.setWeeklycount(rs.getInt(10));
							 sd.setWeekstartDate(rs.getString(13));
							 sd.setWeekendDate(rs.getString(14));
							 
						 }
						 

						
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		
	//	System.out.println("scheduleofDutiesList"+resann1List);
		return resann1List;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<PumpStations> getpumpmaintainpumpinfo(PumpStations pumpObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = null;
		
		String val=null;
		
		String inspectdate=null;
		
		Integer unitId=0;
		Integer pumpStationId=0;
		Integer dutyfreqid=0;
		//System.out.println("coming herer");
       if(pumpObj!=null){
    	   
    	   if(pumpObj.getPumpStationId()!=null && pumpObj.getUnitId()!=null && pumpObj.getDutyFrequencyId()!=null){
    		   pumpStationId=pumpObj.getPumpStationId();
		
		if(pumpObj.getInspectDate()!=null){
		inspectdate=pumpObj.getInspectDate();
		}
		
		unitId=pumpObj.getUnitId();
		
		dutyfreqid=pumpObj.getDutyFrequencyId();
		
		if(dutyfreqid==1){
			
			sql=SELECT_PUMP_MAINTAIN_PUMP_INFO +" and to_char(ipmai.inspect_date,'dd/mm/yyyy')='"+inspectdate+"'"; 
			
		}
    if(dutyfreqid==2){
			
			sql=SELECT_PUMP_MAINTAIN_PUMP_INFO +" and to_date(to_char(ipmai.inspect_date,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date('"+pumpObj.getWeekstartDate()+"' ,'dd/mm/yyyy') and to_date('"+pumpObj.getWeekendDate()+"','dd/mm/yyyy') ";
			
		}
    	   }
       }
		
		try {

			
			//System.out.println("sql"+sql);
			List<PumpStations> psdataList = jdbcTemplate8.query(sql,new Object[]{pumpStationId,unitId,dutyfreqid}, new RowMapper<PumpStations>() {

				public PumpStations mapRow(ResultSet rs, int rowNum) throws SQLException {

					PumpStations ps = new PumpStations();
					
				//	System.out.println("sql2"+rs.getInt(1));
					ps.setUnitId(rs.getInt(1));
					ps.setPumpStationId(rs.getInt(2));
					ps.setPumpStation(rs.getString(3));
					ps.setUnitName(rs.getString(4));
					ps.setCircleName(rs.getString(5));
					ps.setDivisionName(rs.getString(6));
					ps.setSubdivisionName(rs.getString(7));
					ps.setProjectName(rs.getString(8));
					
					
					
					

					return ps;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return psdataList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	
	@Override
	public List<PumpMaintainActivities> getpumpmaintainInspectinfo(PumpMaintainActivities pumpObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =null;
				
			 
		
		
		
		
		String resCode=null;
		Integer year=0;
		Integer pumpstationId=0;
		
		Integer unitId=0;
		try {
if(pumpObj.getPumpStationId()!=null  && pumpObj.getUnitId()!=null){
				
	
	pumpstationId=pumpObj.getPumpStationId();
					
				if(pumpObj.getDutyFrequencyId()==1){	
					sql=SELECT_PUMP_MAINTAIN_INSPECT_INFO+ "and ipmai.pump_station_id= '"+pumpstationId+"'  and ipmai.duty_frequency="+pumpObj.getDutyFrequencyId()+" and to_date(to_char(ipmai.inspect_date,'dd/mm/yyyy'),'dd/mm/yyyy') = to_date('"+pumpObj.getInspectDate()+"' ,'dd/mm/yyyy') and ipmai.unit_id="+pumpObj.getUnitId();
				
				}
				if(pumpObj.getDutyFrequencyId()==2){
				
					sql=SELECT_PUMP_MAINTAIN_INSPECT_INFO+ "and ipmai.pump_station_id= '"+pumpstationId+"'  and ipmai.duty_frequency="+pumpObj.getDutyFrequencyId()+" and to_date(to_char(ipmai.inspect_date,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date('"+pumpObj.getWeekstartDate()+"' ,'dd/mm/yyyy') and to_date('"+pumpObj.getWeekendDate()+"','dd/mm/yyyy')   and ipmai.unit_id="+pumpObj.getUnitId();
					
				}

				
				
}
			
	//	System.out.println("come"+sql);	
		List<PumpMaintainActivities> resann1List = jdbcTemplate8.query(sql,
				new RowMapper<PumpMaintainActivities>() {

					public PumpMaintainActivities mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						
						
						

						PumpMaintainActivities sd = new PumpMaintainActivities();
						
						sd.setActivityInspectId(rs.getInt(1));
						sd.setPmActivityId(rs.getInt(2));
						
						sd.setInspectDate(rs.getString(3));
						sd.setDutyFrequencyId(rs.getInt(4));
						sd.setDesignationId(rs.getInt(5));
						sd.setRemarks(rs.getString(6));
						sd.setApproveStatusId(rs.getInt(7));
						sd.setPumpStationId(rs.getInt(8));
						
						sd.setPmActivity(rs.getString(9));
						
						sd.setDesignationName(rs.getString(10));
						
						sd.setApproveStatus(rs.getString(11));
						sd.setInspectHour(rs.getInt(12));
						
						
						

						
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		
	//	System.out.println("scheduleofDutiesList"+resann1List);
		return resann1List;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<MiTankInspect> getInnoutBytankIdyear(Long tankId , Integer year) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_INOUT_BY_TANKID_YEAR;
		try {
			
			//System.out.println("SELECT_MI_INOUT"+SELECT_MI_INOUT);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{tankId,year},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
							//System.out.println("rs.getInt(1)"+rs.getInt(1));
							mitankinspect.setInflowoutflowId(rs.getInt(1));
							mitankinspect.setTankId(rs.getLong(2));
							mitankinspect.setInflow(rs.getDouble(3));
							mitankinspect.setOutfow(rs.getDouble(4));
							mitankinspect.setAyacut(rs.getDouble(5));
							mitankinspect.setInspectDate(rs.getString(6));
							//mitankinspect.setRemarks(rs.getString(7));
							mitankinspect.setUserName(rs.getString(7));
							mitankinspect.setUserEmpId(rs.getString(8));
							mitankinspect.setUnitId(rs.getInt(9));
							mitankinspect.setCircleId(rs.getInt(10));
							mitankinspect.setDivisionId(rs.getInt(11));
							mitankinspect.setSubdivisionId(rs.getInt(12));
							mitankinspect.setProjectId(rs.getInt(13));
							mitankinspect.setDesignationId(rs.getInt(14));
							mitankinspect.setLevelId(rs.getInt(15));
							mitankinspect.setTankName(rs.getString(16));
							mitankinspect.setUnitName(rs.getString(17));
							mitankinspect.setCircleName(rs.getString(18));
							mitankinspect.setDivisionName(rs.getString(19));
							mitankinspect.setSubdivisionName(rs.getString(20));
							mitankinspect.setProjectName(rs.getString(21));
							mitankinspect.setDesignation(rs.getString(22));
							mitankinspect.setDistrictName(rs.getString(23));
							mitankinspect.setMandalName(rs.getString(24));
							mitankinspect.setVillageName(rs.getString(25));
						
							
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return miinflowoutflow;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<MiTankInspect> getMiRepairsbytankidyear(Long tankId,Integer year) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_MI_REPAIR_BY_TANKID_YEAR;
		try {
			
		//	System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR_BY_TANKID_YEAR);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{tankId,year},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
							//System.out.println("rs.getInt(1)"+rs.getInt(1));
							mitankinspect.setOmmirepairId(rs.getInt(1));
							mitankinspect.setTankId(rs.getLong(2));
							mitankinspect.setMiCompId(rs.getInt(3));
							mitankinspect.setRepairDescription(rs.getString(4));
							mitankinspect.setRate(rs.getDouble(5));
						
							
							if(rs.getInt(6)==1){
								mitankinspect.setUnitMeasureName("No.");	
								
							}
							if(rs.getInt(6)==2){
								mitankinspect.setUnitMeasureName("Square Meter");	
								
							}
							if(rs.getInt(6)==3){
								mitankinspect.setUnitMeasureName("Cubic Meter");	
								
							}
							if(rs.getInt(6)==4){
								mitankinspect.setUnitMeasureName("Meter");	
								
							}
							
							
							
							mitankinspect.setRemarks(rs.getString(7));
							mitankinspect.setQuantity(rs.getDouble(8));
							mitankinspect.setAmount(rs.getDouble(9));
							mitankinspect.setSchemeTaken(rs.getString(10));
							
							mitankinspect.setUserName(rs.getString(11));
							//mitankinspect.setUserEmpId(rs.getString(12));
							mitankinspect.setUnitId(rs.getInt(12));
							mitankinspect.setCircleId(rs.getInt(13));
							mitankinspect.setDivisionId(rs.getInt(14));
							mitankinspect.setSubdivisionId(rs.getInt(15));
							//mitankinspect.setProjectId(rs.getInt(17));
							mitankinspect.setDesignationId(rs.getInt(16));
							mitankinspect.setLevelId(rs.getInt(17));
							mitankinspect.setTankName(rs.getString(18));
							mitankinspect.setUnitName(rs.getString(19));
							mitankinspect.setCircleName(rs.getString(20));
							mitankinspect.setDivisionName(rs.getString(21));
							mitankinspect.setSubdivisionName(rs.getString(22));
							//mitankinspect.setProjectName(rs.getString(25));
							mitankinspect.setDesignation(rs.getString(23));
							mitankinspect.setDistrictName(rs.getString(24));
							mitankinspect.setMandalName(rs.getString(25));
							mitankinspect.setVillageName(rs.getString(26));
							mitankinspect.setMiCompName(rs.getString(27));
							mitankinspect.setRepairStartDate(rs.getString(28));
							mitankinspect.setRepairEndDate(rs.getString(29));
							mitankinspect.setRepairdescId(rs.getInt(30));
						
							
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return miinflowoutflow;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<MiTankInspect> getMiCapacityTankIdYear(Long tankId,Integer year ) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_MI_CAPACITY_BY_TANKID_YEAR;
		try {
			
			//System.out.println("GET_MI_CAPACITY"+GET_MI_CAPACITY);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{tankId,year},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
				//	System.out.println("rs.getInt(3)"+rs.getInt(3));
							mitankinspect.setOmmicapacityId(rs.getInt(1));
							mitankinspect.setTankId(rs.getLong(2));
							DecimalFormat df = new DecimalFormat("#");
					        df.setMaximumFractionDigits(8);
							mitankinspect.setGrossCapacity(df.format(rs.getDouble(3)));
							mitankinspect.setAvailableCapacity(df.format(rs.getDouble(4)));
							mitankinspect.setSurplus(rs.getBoolean(5));
							mitankinspect.setInspectDate(rs.getString(6));
							mitankinspect.setRemarks(rs.getString(7));
							mitankinspect.setUserName(rs.getString(8));
							
							mitankinspect.setUnitId(rs.getInt(9));
							mitankinspect.setCircleId(rs.getInt(10));
							mitankinspect.setDivisionId(rs.getInt(11));
							mitankinspect.setSubdivisionId(rs.getInt(12));
							
							mitankinspect.setDesignationId(rs.getInt(13));
							mitankinspect.setLevelId(rs.getInt(14));
							mitankinspect.setTankName(rs.getString(15));
							mitankinspect.setUnitName(rs.getString(16));
							mitankinspect.setCircleName(rs.getString(17));
							mitankinspect.setDivisionName(rs.getString(18));
							mitankinspect.setSubdivisionName(rs.getString(19));
							
							mitankinspect.setDesignation(rs.getString(20));
							mitankinspect.setDistrictName(rs.getString(21));
							mitankinspect.setMandalName(rs.getString(22));
							mitankinspect.setVillageName(rs.getString(23));
							mitankinspect.setInflow(rs.getDouble(24));
							mitankinspect.setOutfow(rs.getDouble(25));
							mitankinspect.setAyacut(rs.getDouble(26));
							mitankinspect.setTankLevel(rs.getDouble(27));
							
						
							
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return miinflowoutflow;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<MiTankInspect> getMiTankUnitAbstract(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =  null ;
		
	
				
				if(miinspect!=null){
					
					if((miinspect.getUnitId()>0 &&(miinspect.getUnitId()==4 || miinspect.getUnitId()==9832 ||  miinspect.getUnitId()==9830 ) && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getSubdivisionId()==0)){
			//			System.out.println("in unit 4 or 9832: "+miinspect.getUnitId());
				sql= SELECT_TANK_UNIT_ABSTRACT_STATUS + "  order by um.unit_code,imtim.mi_check_frequency_id" ;
				
			
					}
					if(miinspect.getUnitId()!=4 && miinspect.getUnitId()!=9832 &&  miinspect.getUnitId()!=9830) {
					if(miinspect.getUnitId()>0  && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getSubdivisionId()==0 ){
				//		System.out.println("in unit other than 4 or 9832"+miinspect.getUnitId());
						sql= SELECT_TANK_SE_ABSTRACT_STATUS+ "  and imtim.unit_id="+miinspect.getUnitId()+"  order by um.unit_code,imtim.mi_check_frequency_id";
						
						
							}
					}if(miinspect.getUnitId()!=4){
					if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()==0 && miinspect.getSubdivisionId()==0){
						
						sql=SELECT_TANK_DIV_ABSTRACT_STATUS+" and imtim.circle_id="+miinspect.getCircleId()+" and  imtim.unit_id="+miinspect.getUnitId()+" order by cm.circle_name, um.unit_code,imtim.mi_check_frequency_id" ; 
						
						
							}
					
             if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubdivisionId()==0 && (miinspect.getDesignationId()==5)){
						
						sql=SELECT_TANK_SUB_DIV_ABSTRACT_STATUS+ "and imtim.division_id="+miinspect.getDivisionId()+" and imtim.circle_id="+miinspect.getCircleId()+" and  imtim.unit_id="+miinspect.getUnitId()+" order by dm.division_name, cm.circle_name, um.unit_code,imtim.mi_check_frequency_id" ; 
						
					
							}
					
             if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubdivisionId()>0 && (miinspect.getDesignationId()==4)){
					
					sql=SELECT_TANK_EMP_SD_ABSTRACT_STATUS+" and imtim.subdivision_id="+miinspect.getSubdivisionId()+"and imtim.division_id="+miinspect.getDivisionId()+" and imtim.circle_id="+miinspect.getCircleId()+" and  imtim.unit_id="+miinspect.getUnitId()+" order by sm.subdivision_name, dm.division_name, cm.circle_name, um.unit_code,imtim.mi_check_frequency_id" ; 
					
				
						}
             
             if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubdivisionId()>0 &&  miinspect.getPostId()>0 && (miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 )){
					
					sql=SELECT_TANK_EMP_SD_ABSTRACT_STATUS+" and imtim.post_id="+miinspect.getPostId()+" order by sm.subdivision_name, dm.division_name, cm.circle_name, um.unit_code,imtim.mi_check_frequency_id" ; 
					
				
						}
				
					}
				}
				//System.out.println("getMiTankUnitAbstract in rimpl "+sql);
		//	System.out.println("getMiTankUnitAbstract sql"+sql+"--"+miinspect.getUnitId()+"--"+miinspect.getCircleId()+"--"+miinspect.getDivisionId()+"--"+miinspect.getSubdivisionId()+"--"+miinspect.getPostId());
		
		Integer year=0;
		Integer freqId=0;
		try {
if(miinspect.getYear()!=null){
				
				if(miinspect.getYear()>0){
					year=miinspect.getYear();
					
				}
				
				
}

if(miinspect.getMiTankFreqId()!=null){
	
	if(miinspect.getMiTankFreqId()>0){
		freqId=miinspect.getMiTankFreqId();
		
	}
	
	
}
			
		//System.out.println("year"+sql+""+year);	
		List<MiTankInspect> tankUnitAbstract = jdbcTemplate8.query(sql,new Object[]{year,freqId},
				new RowMapper<MiTankInspect>() {

					public MiTankInspect mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						MiTankInspect sd = new MiTankInspect();
						
						//System.out.println("rs.getInt(1)"+rs.getInt(1));
						
						sd.setTotalCount(rs.getInt(1));
						sd.setEmergencyCount(rs.getInt(2));
						sd.setObserveCount(rs.getInt(3));
						sd.setOriginalworkCount(rs.getInt(4));
						sd.setDefferedCount(rs.getInt(5));
						sd.setMiTankFreqId(rs.getInt(6));
						sd.setYear(rs.getInt(7));
						sd.setUnitId(rs.getInt(8));
						sd.setUnitName(rs.getString(9));
						sd.setCircleId(rs.getInt(10));
						sd.setCircleName(rs.getString(11));
						sd.setDivisionId(rs.getInt(12));
						sd.setDivisionName(rs.getString(13));						
						sd.setSubdivisionId(rs.getInt(14));
						sd.setSubdivisionName(rs.getString(15));
						sd.setSectionId(rs.getInt(16));
						sd.setSectionName(rs.getString(17));
						sd.setPostId(rs.getLong(18));
						sd.setPostName(rs.getString(19));
						
					   
						
						
						return sd;
					}

				});
		jdbcTemplate8.getDataSource().getConnection().close();
		return tankUnitAbstract;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<MiTankInspect> getMiTankCapAyacutAbstract(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		//String sql =GET_TANK_ABSTRACT_AYACUT_CAPACITY ; 
		
		String sql=null;
		
		/*GET_TANK_ABSTRACT_AYACUT_CAPACITY*/ 
		if(miinspect!=null){
			
			if((miinspect.getUnitId()>0 &&(miinspect.getUnitId()==4 || miinspect.getUnitId()==9832 || miinspect.getUnitId()==9830) 
					&& miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getSubdivisionId()==0)
					||(miinspect.getUnitId()==4 && miinspect.getCircleId()==104 && miinspect.getDivisionId()==30327&& miinspect.getDesignationId()==5)
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 && (miinspect.getDesignationId()==5 || miinspect.getDesignationId()==4 || miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 ))
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 && miinspect.getSubdivisionId()==12173 && ( miinspect.getDesignationId()==4 || miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 ))
					
					
					
					){
		
		sql= GET_TANK_UNIT_ABSTRACT_AYACUT_CAPACITY + "  order by um.unit_code" ;
		
			}
			if(miinspect.getUnitId()!=4 && miinspect.getUnitId()!=9832 && miinspect.getUnitId()!=9830) {
			if(miinspect.getUnitId()>0  && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getSubdivisionId()==0){
				
				sql= GET_TANK_SE_ABSTRACT_AYACUT_CAPACITY+ "  and mtic.unit_id="+miinspect.getUnitId()+"  order by um.unit_code";
				
					}
			}if(miinspect.getUnitId()!=4){
			if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()==0 && miinspect.getSubdivisionId()==0){
				
				sql=GET_TANK_DIV_ABSTRACT_AYACUT_CAPACITY+" and mtic.circle_id="+miinspect.getCircleId()+" and  mtic.unit_id="+miinspect.getUnitId()+" order by dm.division_name, cm.circle_name, um.unit_code" ; 
				
					}
			
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubdivisionId()==0 && (miinspect.getDesignationId()==5)){
				
				sql=GET_TANK_SUB_DIV_ABSTRACT_AYACUT_CAPACITY+ " and mtic.division_id="+miinspect.getDivisionId()+" and mtic.circle_id="+miinspect.getCircleId()+" and  mtic.unit_id="+miinspect.getUnitId()+" order by sm.subdivision_name,  dm.division_name, cm.circle_name, um.unit_code" ; 
				
					}
     
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubdivisionId()>0 && (miinspect.getDesignationId()==4)){
			
			sql=GET_TANK_EMP_SD_ABSTRACT_AYACUT_CAPACITY+" and mtic.subdivision_id="+miinspect.getSubdivisionId()+" and mtic.division_id="+miinspect.getDivisionId()+" and mtic.circle_id="+miinspect.getCircleId()+" and  mtic.unit_id="+miinspect.getUnitId()+" order by sm.subdivision_name, dm.division_name, cm.circle_name, um.unit_code" ; 
			
				}
     
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubdivisionId()>0 &&  miinspect.getPostId()>0 && (miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 )){
			
			sql=GET_TANK_EMP_SD_ABSTRACT_AYACUT_CAPACITY+" and mtic.post_id="+miinspect.getPostId()+" order by sm.subdivision_name, dm.division_name, cm.circle_name, um.unit_code" ; 
			
				}
			}
		
		}
		
	// System.out.println(" sql getMiTankCapAyacutAbstract "+sql+"--"+miinspect.getUnitId()+"--"+miinspect.getCircleId()+"--"+miinspect.getDivisionId()+"--"+miinspect.getSubdivisionId()+"--"+miinspect.getPostId());

		
		
		Integer year=0;
		
		if(miinspect.getYear()!=null){
			
			year=miinspect.getYear();
			
		}
		try {
		
	//	System.out.println("year "+year );	
		List<MiTankInspect> tankCapacityAbstract = jdbcTemplate8.query(sql,new Object[]{year,year,year,year,year},
				new RowMapper<MiTankInspect>() {

					public MiTankInspect mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						
						MiTankInspect ca = new MiTankInspect();
						
						ca.setGrossAyacut(rs.getDouble(1));
					//	System.out.println("ca.getGrossAyacut())"+ca.getGrossAyacut());
						ca.setAyacut(rs.getDouble(2));
						DecimalFormat df = new DecimalFormat("#");
				        df.setMaximumFractionDigits(8);
							   
				        ca.setGrossCapacity(df.format(rs.getDouble(3)));
						
				        ca.setAvailableCapacity(df.format(rs.getDouble(4)));
				        ca.setUnitId(rs.getInt(5));
				        ca.setUnitName(rs.getString(6));
				        ca.setCircleId(rs.getInt(7));
				        ca.setCircleName(rs.getString(8));
				        ca.setDivisionId(rs.getInt(9));
				        ca.setDivisionName(rs.getString(10));
				        ca.setSubdivisionId(rs.getInt(11));
				        ca.setSubdivisionName(rs.getString(12));
				        ca.setYear(rs.getInt(13));
				        ca.setSectionId(rs.getInt(14));
				        ca.setSectionName(rs.getString(15));
				        ca.setPostId(rs.getLong(16));
				        ca.setPostName(rs.getString(17));
				        ca.setTotalCount(rs.getInt(18));
				    //    System.out.println("ca.setTotalCount())"+ca.getTotalCount());
				    //    System.out.println("ca"+ca);	
						
						return ca;
						
					}

				});
		
		
	//	System.out.println("tankCapacityAbstract"+tankCapacityAbstract);	
		jdbcTemplate8.getDataSource().getConnection().close();
		return tankCapacityAbstract;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	

	@Override
	public List<MiTankformData> getMiTankForm20Abstract(MiTankformData miinspect) throws InventoryUserException {
		//String sql referred =GET_TANK_ABSTRACT_AYACUT_CAPACITY ; 
		
		String sql=null;
		
		Integer year=0;
		String frmDate= null;
		
		String toDate=null;
		//System.out.println("frmDate"+frmDate+miinspect.getFrmFromDate());
		//System.out.println("toDate"+toDate+miinspect.getFrmToDate());
		
		if(miinspect.getTsfcFormYear()!=null){
			
			year=miinspect.getTsfcFormYear();
			
		}
		
if(miinspect.getFrmFromDate()!=null && miinspect.getFrmFromDate().length()>0){
	

			
	frmDate=miinspect.getFrmFromDate();
	
	//System.out.println("coming here1"+frmDate);
			
		}

if(miinspect.getFrmToDate()!=null && miinspect.getFrmToDate().length()>0){
	
	//System.out.println("coming here"+2);
	
	toDate=miinspect.getFrmToDate();
	
	//System.out.println("coming here2"+toDate);
	
}
		
		if(miinspect!=null){
			
			if((miinspect.getUnitId()>0 &&(miinspect.getUnitId()==4 || miinspect.getUnitId()==9832 || miinspect.getUnitId()==9830 ) && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getSubDivisionId()==0)
					||(miinspect.getUnitId()==4 && miinspect.getCircleId()==104 && miinspect.getDivisionId()==30327&& miinspect.getDesignationId()==5)
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==0 && miinspect.getDesignationId()==7)
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 && (miinspect.getDesignationId()==5 || miinspect.getDesignationId()==4 || miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 ))
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 &&  miinspect.getSubDivisionId()==12173 && (miinspect.getDesignationId()==5 || miinspect.getDesignationId()==4 || miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 ))
					
					){
		
		sql= GET_TANK_UNIT_FORM20_ABSTRACT + "  order by um.unit_name" ;
		
			}
			if(miinspect.getUnitId()!=4 && miinspect.getUnitId()!=9832 && miinspect.getUnitId()!=9830 ) {
			if(miinspect.getUnitId()>0  && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getSubDivisionId()==0){
				
				sql= GET_TANK_SE_FORM20_ABSTRACT+ "  and totbv.unit_id="+miinspect.getUnitId()+"  group by totbv.unit_id,totbv.circle_id,um.unit_name,cm.circle_name,totbv.comp_cat_id   order by um.unit_name";
				
					}
			}if(miinspect.getUnitId()!=4){
			if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()==0 && miinspect.getSubDivisionId()==0){
				
				sql=GET_TANK_DIV_FORM20_ABSTRACT+" and totbv.circle_id="+miinspect.getCircleId()+" and  totbv.unit_id="+miinspect.getUnitId()+" group by totbv.unit_id,totbv.circle_id,totbv.division_id,um.unit_name,cm.circle_name,dm.division_name,totbv.comp_cat_id   order by dm.division_name, cm.circle_name, um.unit_name" ; 
				
					}
			
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubDivisionId()==0 && (miinspect.getDesignationId()==5)){
				
				sql=GET_TANK_SUB_DIV_FORM20_ABSTRACT+ " and totbv.division_id="+miinspect.getDivisionId()+" and totbv.circle_id="+miinspect.getCircleId()+" and  totbv.unit_id="+miinspect.getUnitId()+" group by totbv.unit_id,totbv.circle_id,totbv.division_id,totbv.subdivision_id,um.unit_name,cm.circle_name,dm.division_name, sm.subdivision_name ,totbv.comp_cat_id   order by sm.subdivision_name,  dm.division_name, cm.circle_name, um.unit_name" ; 
				
					}
     
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubDivisionId()>0 && (miinspect.getDesignationId()==4)){
			
			sql=GET_TANK_EMP_SD_FORM20_ABSTRACT+" and totbv.subdivision_id="+miinspect.getSubDivisionId()+" and totbv.division_id="+miinspect.getDivisionId()+" and totbv.circle_id="+miinspect.getCircleId()+" and  totbv.unit_id="+miinspect.getUnitId()+"  group by totbv.unit_id,totbv.circle_id,totbv.division_id,totbv.subdivision_id,totbv.section_id, 	totbv.post_id, um.unit_name,cm.circle_name,dm.division_name, sm.subdivision_name ,secm.section_name,tsp.post_name,totbv.comp_cat_id  order by sm.subdivision_name, dm.division_name, cm.circle_name, um.unit_name" ; 
			
				}
     
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubDivisionId()>0 &&  miinspect.getPostId()>0 && (miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 )){
			
			sql=GET_TANK_EMP_SD_FORM20_ABSTRACT+" and totbv.post_id="+miinspect.getPostId()+"  group by totbv.unit_id,totbv.circle_id,totbv.division_id,totbv.subdivision_id,totbv.section_id, 	totbv.post_id, um.unit_name,cm.circle_name,dm.division_name, sm.subdivision_name ,secm.section_name,tsp.post_name,totbv.comp_cat_id order by sm.subdivision_name, dm.division_name, cm.circle_name, um.unit_name" ; 
			
				}
			}
		
		}
		

		//System.out.println("sql info" +sql);	
		
	
		try {
		
	//System.out.println("year "+year +"from date "+frmDate+ "  to date "+toDate+"" +sql);	
		List<MiTankformData> form20Abstract = jdbcTemplate8.query(sql,new Object[]{year,frmDate,toDate},
				new RowMapper<MiTankformData>() {

		
					public MiTankformData mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						
						
						MiTankformData ca = new MiTankformData();
						
						
					
						ca.setSumfrmBookValue(rs.getDouble(1));
						
						 /* Double sfbv=rs.getDouble(1);
					        Double sfbvlakhs=(sfbv/100000.00);
					        DecimalFormat f1 = new DecimalFormat("##.00"); 
							 String finalSumFmBkValue=  f1.format(sfbvlakhs);*/
						
						//ca.setSumFmBkValue(finalSumFmBkValue);
					//	System.out.println("ca.getGrossAyacut())"+ca.getGrossAyacut());
						/*DecimalFormat df = new DecimalFormat("#");
				        df.setMaximumFractionDigits(8);*/
							   
						
				        ca.setUnitId(rs.getInt(2));
				        ca.setUnitName(rs.getString(3));
				        ca.setCircleId(rs.getInt(4));
				        ca.setCircleName(rs.getString(5));
				        ca.setDivisionId(rs.getInt(6));
				        ca.setDivisionName(rs.getString(7));
				        ca.setSubDivisionId(rs.getInt(8));
				        ca.setSubDivisionName(rs.getString(9));
				       
				        ca.setSectionId(rs.getInt(10));
				        ca.setSectionName(rs.getString(11));
				      
				        ca.setPostId(rs.getLong(12));
				      
				        ca.setPostName(rs.getString(13));
				      
				        ca.setTotalTankCount(rs.getInt(14));
				        /*Double sacp=rs.getDouble(16);
				        Double sacplakhs=(sacp/100000.00);
				        DecimalFormat f2 = new DecimalFormat("##.00"); 
						 String finalSumAprxCostPermt=  f2.format(sacplakhs);
						 
						 Double sact=rs.getDouble(17);
					        Double sactlakhs=(sact/100000.00);
						 DecimalFormat f3 = new DecimalFormat("##.00"); 
						 String finalSumAprxCostTemp=  f3.format(sactlakhs);
						 
						 Double srpt=rs.getDouble(18);
					        Double srptlakhs=(srpt/100000.00);
						 DecimalFormat f4 = new DecimalFormat("##.00"); 
						 String finalSumRepairsPermTemp=  f4.format(srptlakhs);*/
				     
				        ca.setSumAprxCostPermt(rs.getDouble(15));
				       
				        ca.setSumAprxCostTemp(rs.getDouble(16));
				       
				        ca.setSumRepairsPermTemp(rs.getDouble(17));
						 
						// ca.setSumApxCtPermt(finalSumAprxCostPermt);
						// ca.setSumAxCtTemp(finalSumAprxCostTemp);
						// ca.setSumRepsPermTemp(finalSumRepairsPermTemp);
				        ca.setBreachCount(rs.getInt(18));
				         ca.setDamageCount(rs.getInt(19));
				        
				         ca.setCatId(rs.getInt(20));
				       
				         ca.setFormsentdatebyunit(rs.getString(21));
				        // ca.setTsfcFormYear(rs.getInt(21));
						 
				    //    System.out.println("ca"+ca);	
						
						return ca;
						
					}

				});
		
		
	//	System.out.println("form20Abstract"+form20Abstract);	
		jdbcTemplate8.getDataSource().getConnection().close();
		return form20Abstract;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	@Override
	public List<MiTankformData> getMiTankFDRAbstract(MiTankformData miinspect) throws InventoryUserException {
		//String sql referred =GET_TANK_ABSTRACT_AYACUT_CAPACITY ; 
		
		String sql=null;
		
		Integer year=0;
		String frmDate= null;
		
		String toDate=null;
		//System.out.println("frmDate"+frmDate+miinspect.getFrmFromDate());
		//System.out.println("toDate"+toDate+miinspect.getFrmToDate());
		
		if(miinspect.getTsfcFormYear()!=null){
			
			year=miinspect.getTsfcFormYear();
			
		}
		
if(miinspect.getFrmFromDate()!=null && miinspect.getFrmFromDate().length()>0){
	

			
	frmDate=miinspect.getFrmFromDate();
	
	//System.out.println("coming here1"+frmDate);
			
		}

if(miinspect.getFrmToDate()!=null && miinspect.getFrmToDate().length()>0){
	
	//System.out.println("coming here"+2);
	
	toDate=miinspect.getFrmToDate();
	
	//System.out.println("coming here2"+toDate);
	
}
		
		if(miinspect!=null){
			
			if((miinspect.getUnitId()>0 &&(miinspect.getUnitId()==4 || miinspect.getUnitId()==9832 || miinspect.getUnitId()==9830 ) && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getSubDivisionId()==0)
					||(miinspect.getUnitId()==4 && miinspect.getCircleId()==104 && miinspect.getDivisionId()==30327&& miinspect.getDesignationId()==5)
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==0 && miinspect.getDesignationId()==7)
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 && (miinspect.getDesignationId()==5 || miinspect.getDesignationId()==4 || miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 ))
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 &&  miinspect.getSubDivisionId()==12173 && (miinspect.getDesignationId()==5 || miinspect.getDesignationId()==4 || miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 ))
					
					){
		
		sql= GET_TANK_UNIT_FDR_ABSTRACT + "  order by um.unit_name" ;
		
			}
			if(miinspect.getUnitId()!=4 && miinspect.getUnitId()!=9832 && miinspect.getUnitId()!=9830 ) {
			if(miinspect.getUnitId()>0  && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getSubDivisionId()==0){
				
				sql= GET_TANK_SE_FDR_ABSTRACT+ "  and totbv.unit_id="+miinspect.getUnitId()+"  group by totbv.unit_id,totbv.circle_id,um.unit_name,cm.circle_name,totbv.comp_cat_id   order by um.unit_name";
				
					}
			}if(miinspect.getUnitId()!=4){
			if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()==0 && miinspect.getSubDivisionId()==0){
				
				sql=GET_TANK_DIV_FDR_ABSTRACT+" and totbv.circle_id="+miinspect.getCircleId()+" and  totbv.unit_id="+miinspect.getUnitId()+" group by totbv.unit_id,totbv.circle_id,totbv.division_id,um.unit_name,cm.circle_name,dm.division_name,totbv.comp_cat_id   order by dm.division_name, cm.circle_name, um.unit_name" ; 
				
					}
			
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubDivisionId()==0 && (miinspect.getDesignationId()==5)){
				
				sql=GET_TANK_SUB_DIV_FDR_ABSTRACT+ " and totbv.division_id="+miinspect.getDivisionId()+" and totbv.circle_id="+miinspect.getCircleId()+" and  totbv.unit_id="+miinspect.getUnitId()+" group by totbv.unit_id,totbv.circle_id,totbv.division_id,totbv.subdivision_id,um.unit_name,cm.circle_name,dm.division_name, sm.subdivision_name ,totbv.comp_cat_id   order by sm.subdivision_name,  dm.division_name, cm.circle_name, um.unit_name" ; 
				
					}
     
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubDivisionId()>0 && (miinspect.getDesignationId()==4)){
			
			sql=GET_TANK_EMP_SD_FDR_ABSTRACT+" and totbv.subdivision_id="+miinspect.getSubDivisionId()+" and totbv.division_id="+miinspect.getDivisionId()+" and totbv.circle_id="+miinspect.getCircleId()+" and  totbv.unit_id="+miinspect.getUnitId()+"  group by totbv.unit_id,totbv.circle_id,totbv.division_id,totbv.subdivision_id,totbv.section_id, 	totbv.post_id, um.unit_name,cm.circle_name,dm.division_name, sm.subdivision_name ,secm.section_name,tsp.post_name,totbv.comp_cat_id  order by sm.subdivision_name, dm.division_name, cm.circle_name, um.unit_name" ; 
			
				}
     
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubDivisionId()>0 &&  miinspect.getPostId()>0 && (miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 )){
			
			sql=GET_TANK_EMP_SD_FDR_ABSTRACT+" and totbv.post_id="+miinspect.getPostId()+"  group by totbv.unit_id,totbv.circle_id,totbv.division_id,totbv.subdivision_id,totbv.section_id, 	totbv.post_id, um.unit_name,cm.circle_name,dm.division_name, sm.subdivision_name ,secm.section_name,tsp.post_name,totbv.comp_cat_id order by sm.subdivision_name, dm.division_name, cm.circle_name, um.unit_name" ; 
			
				}
			}
		
		}
		

		//System.out.println("sql info" +sql);	
		
	
		try {
		
	//System.out.println("year "+year +"from date "+frmDate+ "  to date "+toDate+"" +sql);	
		List<MiTankformData> form20Abstract = jdbcTemplate8.query(sql,new Object[]{year,frmDate,toDate},
				new RowMapper<MiTankformData>() {

		
					public MiTankformData mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						
						
						MiTankformData ca = new MiTankformData();
						
						
					
						ca.setSumfrmBookValue(rs.getDouble(1));
						
						 /* Double sfbv=rs.getDouble(1);
					        Double sfbvlakhs=(sfbv/100000.00);
					        DecimalFormat f1 = new DecimalFormat("##.00"); 
							 String finalSumFmBkValue=  f1.format(sfbvlakhs);*/
						
						//ca.setSumFmBkValue(finalSumFmBkValue);
					//	System.out.println("ca.getGrossAyacut())"+ca.getGrossAyacut());
						/*DecimalFormat df = new DecimalFormat("#");
				        df.setMaximumFractionDigits(8);*/
							   
						
				        ca.setUnitId(rs.getInt(2));
				        ca.setUnitName(rs.getString(3));
				        ca.setCircleId(rs.getInt(4));
				        ca.setCircleName(rs.getString(5));
				        ca.setDivisionId(rs.getInt(6));
				        ca.setDivisionName(rs.getString(7));
				        ca.setSubDivisionId(rs.getInt(8));
				        ca.setSubDivisionName(rs.getString(9));
				       
				        ca.setSectionId(rs.getInt(10));
				        ca.setSectionName(rs.getString(11));
				      
				        ca.setPostId(rs.getLong(12));
				      
				        ca.setPostName(rs.getString(13));
				      
				        ca.setTotalTankCount(rs.getInt(14));
				        /*Double sacp=rs.getDouble(16);
				        Double sacplakhs=(sacp/100000.00);
				        DecimalFormat f2 = new DecimalFormat("##.00"); 
						 String finalSumAprxCostPermt=  f2.format(sacplakhs);
						 
						 Double sact=rs.getDouble(17);
					        Double sactlakhs=(sact/100000.00);
						 DecimalFormat f3 = new DecimalFormat("##.00"); 
						 String finalSumAprxCostTemp=  f3.format(sactlakhs);
						 
						 Double srpt=rs.getDouble(18);
					        Double srptlakhs=(srpt/100000.00);
						 DecimalFormat f4 = new DecimalFormat("##.00"); 
						 String finalSumRepairsPermTemp=  f4.format(srptlakhs);*/
				     
				        ca.setSumAprxCostPermt(rs.getDouble(15));
				       
				        ca.setSumAprxCostTemp(rs.getDouble(16));
				       
				        ca.setSumRepairsPermTemp(rs.getDouble(17));
						 
						// ca.setSumApxCtPermt(finalSumAprxCostPermt);
						// ca.setSumAxCtTemp(finalSumAprxCostTemp);
						// ca.setSumRepsPermTemp(finalSumRepairsPermTemp);
				        ca.setBreachCount(rs.getInt(18));
				         ca.setDamageCount(rs.getInt(19));
				        
				         ca.setCatId(rs.getInt(20));
				       
				         ca.setFormsentdatebyunit(rs.getString(21));
				         
				         
				         ca.setPermanentCount(rs.getInt(22));
				         ca.setPermanentAmount(rs.getDouble(23));
				         
				         ca.setTemporaryCount(rs.getInt(24));
				         
				         ca.setTemporaryAmount(rs.getDouble(25));
				         
				         ca.setRestoredCount(rs.getInt(26));
				         
				         ca.setUnderRestoredCount(rs.getInt(27));
				         
				         
				        // ca.setTsfcFormYear(rs.getInt(21));
						 
				    //    System.out.println("ca"+ca);	
						
						return ca;
						
					}

				});
		
		
	//	System.out.println("form20Abstract"+form20Abstract);	
		jdbcTemplate8.getDataSource().getConnection().close();
		return form20Abstract;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	
	@Override
	public List<MiTankformData> getMiTankForm20DistrictAbstract(MiTankformData miinspect) throws InventoryUserException {
		//String sql referred =GET_TANK_ABSTRACT_AYACUT_CAPACITY ; 
		
		String sql=null;
		
		//System.out.println(miinspect.getUnitId());
		//System.out.println(miinspect.getCircleId());
		//System.out.println(miinspect.getDivisionId());
		
		//System.out.println(miinspect.getSubDivisionId());
		//System.out.println(miinspect.getDesignationId());
		
		if(miinspect!=null){
			
			if((miinspect.getUnitId()>0 &&(miinspect.getUnitId()==4 || miinspect.getUnitId()==9832 || miinspect.getUnitId()==9830 ) && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getSubDivisionId()==0)
					||(miinspect.getUnitId()==4 && miinspect.getCircleId()==104 && miinspect.getDivisionId()==30327&& ( miinspect.getDesignationId()==5 ||  miinspect.getDesignationId()==2  ||  miinspect.getDesignationId()==4))
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==0 && miinspect.getDesignationId()==7)
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 && (miinspect.getDesignationId()==5 || miinspect.getDesignationId()==4 || miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 ))
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 &&  miinspect.getSubDivisionId()==12173 && (miinspect.getDesignationId()==5 || miinspect.getDesignationId()==4 || miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 ))
					
					){
		
		sql= GET_TANK_DISTRICT_FORM20_ABSTRACT + "  order by reptot asc" ;
		
			}
			/*if(miinspect.getUnitId()!=4 && miinspect.getUnitId()!=9832 && miinspect.getUnitId()!=9830 ) {
			if(miinspect.getUnitId()>0  && miinspect.getCircleId()==0 && miinspect.getDivisionId()==0 && miinspect.getSubDivisionId()==0){
				
				sql= GET_TANK_SE_FORM20_ABSTRACT+ "  and mtf.unit_id="+miinspect.getUnitId()+"  order by um.unit_name";
				
					}
			}*//*if(miinspect.getUnitId()!=4){
			if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()==0 && miinspect.getSubDivisionId()==0){
				
				sql=GET_TANK_DIV_FORM20_ABSTRACT+" and mtf.circle_id="+miinspect.getCircleId()+" and  mtf.unit_id="+miinspect.getUnitId()+" order by dm.division_name, cm.circle_name, um.unit_name" ; 
				
					}
			
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubDivisionId()==0 && (miinspect.getDesignationId()==5)){
				
				sql=GET_TANK_SUB_DIV_FORM20_ABSTRACT+ " and mtf.division_id="+miinspect.getDivisionId()+" and mtf.circle_id="+miinspect.getCircleId()+" and  mtf.unit_id="+miinspect.getUnitId()+" order by sm.subdivision_name,  dm.division_name, cm.circle_name, um.unit_name" ; 
				
					}
     
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubDivisionId()>0 && (miinspect.getDesignationId()==4)){
			
			sql=GET_TANK_EMP_SD_FORM20_ABSTRACT+" and mtf.subdivision_id="+miinspect.getSubDivisionId()+" and mtf.division_id="+miinspect.getDivisionId()+" and mtf.circle_id="+miinspect.getCircleId()+" and  mtf.unit_id="+miinspect.getUnitId()+" order by sm.subdivision_name, dm.division_name, cm.circle_name, um.unit_name" ; 
			
				}
     
     if(miinspect.getUnitId()>0 && miinspect.getCircleId()>0 && miinspect.getDivisionId()>0 && miinspect.getSubDivisionId()>0 &&  miinspect.getPostId()>0 && (miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8 )){
			
			sql=GET_TANK_EMP_SD_FORM20_ABSTRACT+" and mtf.post_id="+miinspect.getPostId()+" order by sm.subdivision_name, dm.division_name, cm.circle_name, um.unit_name" ; 
			
				}
			}*/
		
		}
		

		
		
		Integer year=0;
		
		if(miinspect.getTsfcFormYear()!=null){
			
			year=miinspect.getTsfcFormYear();
			
		}
		try {
		
	//System.out.println("year "+year +" "+sql);	
		List<MiTankformData> form20Abstract = jdbcTemplate8.query(sql,new Object[]{year,year},
				new RowMapper<MiTankformData>() {

					public MiTankformData mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						
						MiTankformData ca = new MiTankformData();
						
						//ca.setSumfrmBookValue(rs.getDouble(1));
						
						 // Double sfbv=rs.getDouble(1);
					     //   Double sfbvlakhs=(sfbv/100000.00);
					     //   DecimalFormat f1 = new DecimalFormat("##.00"); 
							// String finalSumFmBkValue=  f1.format(sfbvlakhs);
						
						
					//	System.out.println("ca.getGrossAyacut())"+ca.getGrossAyacut());
						//DecimalFormat df = new DecimalFormat("#");
				      //  df.setMaximumFractionDigits(8);
							   
				        ca.setDistrictName(rs.getString(1));
				        ca.setSumApxCtPermt(String.valueOf(rs.getDouble(2)));
				        ca.setSumAxCtTemp(String.valueOf(rs.getDouble(3)));
				        ca.setSumRepsPermTemp(String.valueOf(rs.getDouble(4)));
				        ca.setSumFmBkValue(String.valueOf(rs.getDouble(5)));
				        ca.setTotalTankCount(rs.getInt(6));
				        
				        ca.setBreachCount(rs.getInt(7));
				         ca.setDamageCount(rs.getInt(8));
				         ca.setTsfcFormYear(rs.getInt(9));
				         
				         ca.setUnitName(rs.getString(10));				      	     
				         ca.setDistrictId(rs.getInt(11));
				     
				     
				       
				      
				       
				       // Double sacp=rs.getDouble(16);
				     //   Double sacplakhs=(sacp/100000.00);
				       // DecimalFormat f2 = new DecimalFormat("##.00"); 
						// String finalSumAprxCostPermt=  f2.format(sacplakhs);
						 
						// Double sact=rs.getDouble(17);
					    //    Double sactlakhs=(sact/100000.00);
						// DecimalFormat f3 = new DecimalFormat("##.00"); 
						// String finalSumAprxCostTemp=  f3.format(sactlakhs);
						 
						// Double srpt=rs.getDouble(18);
					     //   Double srptlakhs=(srpt/100000.00);
						 //DecimalFormat f4 = new DecimalFormat("##.00"); 
						// String finalSumRepairsPermTemp=  f4.format(srptlakhs);
				       // ca.setSumAprxCostPermt(rs.getDouble(16));
				       // ca.setSumAprxCostTemp(rs.getDouble(17));
				      //  ca.setSumRepairsPermTemp(rs.getDouble(18));
						 
						
						
						
				     
						 
				    //    System.out.println("ca"+ca);	
						
						return ca;
						
					}

				});
		
		
	//	System.out.println("form20Abstract"+form20Abstract);	
		jdbcTemplate8.getDataSource().getConnection().close();
		return form20Abstract;
			
		} catch (Exception exc) {
			
			return null;
		}
	}


	@Override
	public List<MiTankformData> getForm20SelectYear() throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = SELECT_FORM20_YEAR ;
		try {

			List<MiTankformData> yearList = jdbcTemplate8.query(sql,
					new RowMapper<MiTankformData>() {

						public MiTankformData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankformData mtfd = new MiTankformData();
							
							mtfd.setTsfcFormYear(rs.getInt(1));
							/*mtfd.setFormDataId(rs.getInt(2));*/
							return mtfd;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return yearList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	@Override
	public List<MiTankInspect> getmiTankSelectYear() throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = SELECT_MI_TANK_YEAR ;
		try {

			List<MiTankInspect> yearList = jdbcTemplate8.query(sql,
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mti = new MiTankInspect();
							
							mti.setYear(rs.getInt(1));
							/*mtfd.setFormDataId(rs.getInt(2));*/
							return mti;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return yearList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	@Override
	public List<MiTankInspect> getMiTankCapAayacutDetail(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =SELECT_TANK_CAP_AYACUT_DETAIL; 
		String	sql1=null;
		Integer	year=0;
		Integer unitId=0;
		
	
		try {
			if(miinspect.getYear()!=null && miinspect.getUnitId()!=null){
			year= miinspect.getYear();
			unitId=miinspect.getUnitId();
		//	System.out.println("capacity unitId "+unitId);	
			sql1=sql+" and um.unit_id="+unitId;
			if(miinspect.getUnitId()!=4){
				if((miinspect.getDesignationId()==2||miinspect.getDesignationId()==8 ||miinspect.getDesignationId()==4) && (miinspect.getSubdivisionId()>0 && miinspect.getPostId()>0)){
					
					sql=sql1+"  and cm.circle_id="+miinspect.getCircleId()+"  and divm.division_id="+miinspect.getDivisionId()+"  and sdm.subdivision_id="+miinspect.getSubdivisionId()+"  and mtic.post_id="+miinspect.getPostId(); 
				}
					
					if((miinspect.getDesignationId()==4 ) && (miinspect.getSubdivisionId()>0 && miinspect.getPostId()==0 )){
						
						sql=sql1 +"  and cm.circle_id="+miinspect.getCircleId()+"  and divm.division_id="+miinspect.getDivisionId()+"  and sdm.subdivision_id="+miinspect.getSubdivisionId();
					}
							
			if((miinspect.getDesignationId()==5 ) && (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()>0) && (miinspect.getDivisionId()>0 ) && (miinspect.getSubdivisionId()==0 )){
						
						sql=sql1+"  and cm.circle_id="+miinspect.getCircleId()+"  and divm.division_id="+miinspect.getDivisionId() ; 
					}
					
			if( (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()>0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubdivisionId()==0 )){

			sql=sql1+"  and cm.circle_id="+miinspect.getCircleId(); 
			}
			}
if(miinspect.getUnitId()!=4 && miinspect.getUnitId()!=9832 && miinspect.getUnitId()!=9830) {
			if( (miinspect.getUnitId()>0 )&& (miinspect.getCircleId()==0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubdivisionId()==0 )){

			sql=sql1;
			}
}
			if(( (miinspect.getUnitId()>0 ) && (miinspect.getUnitId()==4 || miinspect.getUnitId()==9832  || miinspect.getUnitId()==9830) && (miinspect.getCircleId()==0) && (miinspect.getDivisionId()==0 ) && (miinspect.getSubdivisionId()==0 ))
					||(miinspect.getUnitId()==4 && miinspect.getCircleId()==104 && miinspect.getDivisionId()==30327 && (miinspect.getDesignationId()==5  ))
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 && (miinspect.getDesignationId()==5 || miinspect.getDesignationId()==4 || miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8  ))
					||(miinspect.getUnitId()==9830 && miinspect.getCircleId()==21609 && miinspect.getDivisionId()==31099 && miinspect.getSubdivisionId()==12173 &&  (miinspect.getDesignationId()==4 || miinspect.getDesignationId()==2 || miinspect.getDesignationId()==8  ))
					
					
					
					){

				sql=sql;
				}
				
				
			}			
							
						
					//System.out.println("capacity detail: "+sql);	
					List<MiTankInspect> tankCapOfficewiseList = jdbcTemplate8.query(sql,new Object[]{year,year},
							new RowMapper<MiTankInspect>() {

								public MiTankInspect mapRow(ResultSet rs, int rowNum)
										throws SQLException {
					
									MiTankInspect sd = new MiTankInspect();
													
									//System.out.println("rs.getInt(1)"+rs.getInt(1));
									sd.setTankId(rs.getLong(1));
									sd.setTankName(rs.getString(2));
									 sd.setGrossAyacut(rs.getDouble(3));
									 DecimalFormat df = new DecimalFormat("#");
								        df.setMaximumFractionDigits(8);
											   
										sd.setGrossCapacity(df.format(rs.getDouble(4)));
									 
									 sd.setAvailableCapacity(df.format(rs.getDouble(5)));
									 sd.setAyacut(rs.getDouble(6)); 
									 sd.setYear(rs.getInt(7));
									sd.setUnitId(rs.getInt(8));
									sd.setUnitName(rs.getString(9));
									sd.setCircleId(rs.getInt(10));
									sd.setCircleName(rs.getString(11));
									sd.setDivisionId(rs.getInt(12));
									sd.setDivisionName(rs.getString(13));
									sd.setSubdivisionId(rs.getInt(14));
									sd.setSubdivisionName(rs.getString(15));
								
							//	 System.out.println("capacity-detail-sd "+sd);
									return sd;
								}

							});
					
			//		System.out.println("tankCapOfficewiseList  "+tankCapOfficewiseList);	
					jdbcTemplate8.getDataSource().getConnection().close(); 
					return tankCapOfficewiseList;
					
						} catch (Exception exc) {
						
						return null;
					}
					}
	
	
	
	@Override
	public List<ReservoirInspect> getResChecks() throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = SELECT_INVOM_RES_CHECKS ;
		try {

			List<ReservoirInspect> resChecksList = jdbcTemplate8.query(sql,
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect reschecks = new ReservoirInspect();
							
							reschecks.setResCheckId(rs.getInt(1));
							reschecks.setResCheckName(rs.getString(2));
							reschecks.setResCategoryId(rs.getInt(3));
							reschecks.setResCheckSeq(rs.getInt(4));
							reschecks.setIsTitle(rs.getBoolean(5));
							reschecks.setAnnexureId(rs.getInt(6));
							reschecks.setResCheckNumDisplay(rs.getString(7));
							
							
							return reschecks;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return resChecksList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	@Override
	public List<ReservoirInspect> getResChecksCategory() throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = SELECT_INVOM_RES_CATEGORY ;
		try {

			List<ReservoirInspect> resCatList = jdbcTemplate8.query(sql,
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resCat = new ReservoirInspect();
							
							resCat.setResCategoryId(rs.getInt(1));
							resCat.setResCategory(rs.getString(2));
							resCat.setResParentcatId(rs.getInt(3));
							resCat.setHasChild(rs.getBoolean(4));
							resCat.setResCheckSeq(rs.getInt(5));
							resCat.setCatType(rs.getInt(6));
							resCat.setResCatNumDisplay(rs.getString(7));
							resCat.setCatistitle(rs.getBoolean(8));
							
							
							return resCat;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return resCatList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public List<ReservoirInspect> getResAnn1mst2(Integer resInspectAnn1mst1Id) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = SELECT_RES_ANN1_MST2_PDF ;
		
		//System.out.println("sql"+sql+resInspectAnn1mst1Id+"resInspectAnn1mst1Id");
		try {

			List<ReservoirInspect> resann1mst2List = jdbcTemplate8.query(sql,new Object[]{resInspectAnn1mst1Id },
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resCat = new ReservoirInspect();
							
							resCat.setResInspectMst1Id(rs.getInt(1));
							resCat.setResInspectMst2Id(rs.getInt(2));
							resCat.setResCheckId(rs.getInt(3));
							resCat.setResCategoryId(rs.getInt(4));
							resCat.setYear(rs.getInt(5));
							resCat.setRemarks(rs.getString(6));
							resCat.setTabId(rs.getInt(7));
							resCat.setReservoirId(rs.getInt(8));
							resCat.setEmpId(rs.getInt(9));
							resCat.setAnnexureId(rs.getInt(10));
							resCat.setIrrChFrm(rs.getDouble(11));
							resCat.setIrrChTo(rs.getDouble(12));
							resCat.setInstalledcount(rs.getInt(13));
							resCat.setLocation(rs.getString(14));
							resCat.setInstallmonth(rs.getString(15));
							resCat.setWorkingcondition(rs.getBoolean(16));
							resCat.setDatelastCalibrated(rs.getString(17));
							resCat.setDatenextCalibrated(rs.getString(18));
							resCat.setObsmaintained(rs.getBoolean(19));
							resCat.setAgencyresponsible(rs.getBoolean(20));
							resCat.setAnalysisofdata(rs.getBoolean(21));
							resCat.setDatasenttoDSO(rs.getBoolean(22));
							resCat.setConditionofCheckId(rs.getInt(23));
							
							
							if(rs.getInt(23)==0){
								resCat.setConditionofCheck("NA");
							}
							
							if(rs.getInt(23)==1){
							resCat.setConditionofCheck(" UnSatisfactory");
							}
							if(rs.getInt(23)==2){
								resCat.setConditionofCheck(" Poor");
								}
							if(rs.getInt(23)==3){
								resCat.setConditionofCheck(" Fair");
								}
							
							if(rs.getInt(23)==4){
								resCat.setConditionofCheck(" Satisfactory");
								}
							
							resCat.setResCheckName(rs.getString(24));
							resCat.setDamcheckResponseId(rs.getInt(25));
							
							
							
							
							
							if(rs.getInt(25)==1){
								resCat.setDamcheckResponse("No");
								}
							
							if(rs.getInt(25)==2){
								resCat.setDamcheckResponse("Yes");
								}
							
							if(rs.getInt(25)==3){
								resCat.setDamcheckResponse("NA");
								}
							
							
							return resCat;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return resann1mst2List;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public List<ReservoirInspect> getResAnnRecomndbymst1(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_RES_ANN_RECOMMEND_BY_MST1ID ;
		try {

			List<ReservoirInspect> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getResInspectMst1Id() },
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resinspect = new ReservoirInspect();
							
							resinspect.setResannRecommendId(rs.getInt(1));							
							resinspect.setResInspectMst1Id(rs.getInt(2));
							resinspect.setResInspectMst2Id(rs.getInt(3));
							resinspect.setInspectOfficeInfoId(rs.getInt(4));							
							resinspect.setRemarks(rs.getString(5));
							resinspect.setInspectOfficeName(rs.getString(6));
							resinspect.setResDamHealthId(rs.getInt(7));
							
							
							
							return resinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return resinspectrecommList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<ReservoirInspect> getResDamInspectRemarksByresmst1Id(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_DAM_MST1_REMARKS_MST1ID ;
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<ReservoirInspect> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getResInspectMst1Id() },
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resinspect = new ReservoirInspect();
							
							 // System.out.println("result"+rs.getInt(1));
							
							resinspect.setResRemarksMst1ReviewId(rs.getInt(1));							
							resinspect.setResInspectMst1Id(rs.getInt(2));
							resinspect.setReservoirId(rs.getInt(3));
							resinspect.setIsLatest(rs.getBoolean(4));
							resinspect.setUnitId(rs.getInt(5));
							resinspect.setCircleId(rs.getInt(6));
							resinspect.setDivisionId(rs.getInt(7));
							resinspect.setSubdivisionId(rs.getInt(8));
							resinspect.setProjectId(rs.getInt(9));
							resinspect.setDesignationId(rs.getInt(10));
							resinspect.setLevelId(rs.getInt(11));
							resinspect.setSubmitedToEmpId(rs.getInt(12));
							resinspect.setRemarks(rs.getString(13));
							resinspect.setTabId(rs.getInt(14));
							resinspect.setEmpId(rs.getInt(15));
							resinspect.setPostId(rs.getLong(16));
							resinspect.setNextPostId(rs.getLong(17));
							resinspect.setSectionId(rs.getInt(18));
							resinspect.setNextEmpId(rs.getInt(19));
							resinspect.setInspectOfficeName(rs.getString(20));
							resinspect.setRemarksinclindoc(rs.getBoolean(21));
							resinspect.setResinspectInfoId(rs.getInt(22));
							resinspect.setSubmittedToEmpName(rs.getString(23));
							resinspect.setRemarksSubmittedBy(rs.getString(24));
						
							
						
							
							
							
							return resinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return resinspectrecommList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public List<ReservoirInspect> getDamHealthDetailsBYmst1IdReport(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=GET_DAM_HEALTH_BY_MST1ID_REPORT;
		
		try {
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getResInspectMst1Id()  },
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect    resinfo = new ReservoirInspect();
							
							resinfo.setResDamHealthId(rs.getInt(1));
							resinfo.setResInspectMst1Id(rs.getInt(2));
							resinfo.setRemarks(rs.getString(3));						
							
							resinfo.setDesignationId(rs.getInt(4));
							resinfo.setReservoirId(rs.getInt(5));
							resinfo.setInspectOfficeInfoId(rs.getInt(6));
							
							resinfo.setPostId(rs.getLong(7));
							resinfo.setInspectOfficeName(rs.getString(8));
							resinfo.setDeficiencyCategory(rs.getInt(9));
							resinfo.setDeficiencyCategoryName(rs.getString(10));
							
							resinfo.setLatestHealthCategory(rs.getBoolean(11));
						
							return resinfo;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return reslist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	
	
	@Override
	public List<ReservoirSalient> getDamSalientDetailsBYmst1IdReport(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=GET_DAM_SALIENT_BY_MST1ID_REPORT;
		
		try {
			
			List<ReservoirSalient>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getResInspectMst1Id()  },
					new RowMapper<ReservoirSalient>() {

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {

                      ReservoirSalient resinspect = new ReservoirSalient();
							
							 
							
							
							resinspect.setReservoirId(rs.getInt(1));				
							resinspect.setResName(rs.getString(2));	
							 
							resinspect.setEmergencyActionShared(rs.getString(3));
							resinspect.setEmergencyActionPlanPreparedId(rs.getInt(4));
							if(rs.getInt(4)==1){
								
								resinspect.setEmergencyActionPlanPrepared("Yes");	
							}else{
								resinspect.setEmergencyActionPlanPrepared("No");	
								
							}
							resinspect.setDisaster_manage_prepared(rs.getString(5));
							
							resinspect.setDamretrofitMeausreAdopted(rs.getString(6));
							
							resinspect.setDamRetrofitTime(rs.getString(7));
							
							resinspect.setDamRetrofitStatus(rs.getString(8));
							
							resinspect.setDamFoundSafe(rs.getString(9));
							
							resinspect.setPeakWaterLeakage(rs.getDouble(10));
							
							
							resinspect.setLostPercentageReservoirCapacity(rs.getDouble(11));
							resinspect.setOanMManualPreparedTime(rs.getString(12));
							resinspect.setOanMManualPreparedId(rs.getInt(13));
							
							if(rs.getInt(13)==1){
								
								resinspect.setOanMManualPrepared("Yes");
							}else{
								resinspect.setOanMManualPrepared("No");
								
							}
							
							
							resinspect.setGalleryDryStatus(rs.getString(14));
							resinspect.setGalleryElevation(rs.getString(15));
							resinspect.setUnusualDamDesignId(rs.getInt(16));
							
							if(rs.getInt(16)==1){
								
								resinspect.setUnusualDamDesign("Yes");
							}else{
								
								resinspect.setUnusualDamDesign("No");
							}
						
							 
							resinspect.setUnusualDamDesigndetails(rs.getString(17));
							resinspect.setSpecialDifficultFoundationIssues(rs.getString(18));
							resinspect.setMfdobservedflood(rs.getDouble(19));
							resinspect.setMfddesignflood(rs.getDouble(20));
							resinspect.setCapacitydeadstorage(rs.getDouble(21));
							resinspect.setSalienttopwidth(rs.getDouble(22));
							resinspect.setSalientbottomwidth(rs.getDouble(23));
							resinspect.setSalientlengthcrest(rs.getDouble(24));
							resinspect.setSalientheightdfl(rs.getDouble(25));
							resinspect.setDamBreakAnalysisId(rs.getInt(26));
							
							if(rs.getInt(26)==1){
								
								resinspect.setDamBreakAnalysis("Yes");
							}else{
								
								resinspect.setDamBreakAnalysis("No");
							}
							resinspect.setStructuralSafetyPerformedId(rs.getInt(27));
							
							if(rs.getInt(27)==1){
								
								resinspect.setStructuralSafetyPerformed("Yes");
							}else{
								
								resinspect.setStructuralSafetyPerformed("No");
								
							}
							 
							resinspect.setReservoirSiltedId(rs.getInt(28));
							
							if(rs.getInt(28)==1){
								
								resinspect.setReservoirSilted("Yes");
							}else{
								resinspect.setReservoirSilted("No");
								
							}
							resinspect.setGateOperationMethodId(rs.getInt(29));
							if(rs.getInt(29)==1){
								
								resinspect.setGateOperationMethod("Hydraulic");
							}else if (rs.getInt(29)==2){
								
								resinspect.setGateOperationMethod("Electric");
								
							}else if (rs.getInt(29)==3){
								
								resinspect.setGateOperationMethod("Manual");
								
							}
                               else if (rs.getInt(29)==4){
								
								resinspect.setGateOperationMethod("Automatic fall");
								
							}else {
								
								resinspect.setGateOperationMethod("No Gates");
							}
							
							resinspect.setGrossCapacityMwl(rs.getDouble(30));
							
							resinspect.setResgatesize(rs.getString(31));
							resinspect.setResgatenumber(rs.getString(32));
							
							resinspect.setDamGalleryNumber(rs.getString(33));
							
							resinspect.setDamGateNumberFine(rs.getInt(34));
							
							//System.out.println("rs.getDouble(35)"+rs.getString(35));
							
							resinspect.setCapacityactivestorageStr(rs.getString(35));
							
							
						
							
							
							
							return resinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return reslist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	
	
	@Override
	public List<Tanks> getTanksSalientDetailsBYmst1IdReport(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=GET_TANKS_SALIENT_BY_MST1ID_REPORT;
		
		try {
			
			List<Tanks>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getResInspectMst1Id()  },
					new RowMapper<Tanks>() {

						public Tanks mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Tanks resinspect = new Tanks();
							
							 
							
							
							resinspect.setTankId(rs.getLong(1));				
							resinspect.setTankName(rs.getString(2));	
							 
							resinspect.setEmergencyActionShared(rs.getString(3));
							resinspect.setEmergencyActionPlanPreparedId(rs.getInt(4));
							if(rs.getInt(4)==1){
								
								resinspect.setEmergencyActionPlanPrepared("Yes");	
							}else{
								resinspect.setEmergencyActionPlanPrepared("No");	
								
							}
							resinspect.setDisaster_manage_prepared(rs.getString(5));
							
							resinspect.setDamretrofitMeausreAdopted(rs.getString(6));
							
							resinspect.setDamRetrofitTime(rs.getString(7));
							
							resinspect.setDamRetrofitStatus(rs.getString(8));
							
							resinspect.setDamFoundSafe(rs.getString(9));
							
							resinspect.setPeakWaterLeakage(rs.getDouble(10));
							
							
							resinspect.setLostPercentageReservoirCapacity(rs.getDouble(11));
							resinspect.setOanMManualPreparedTime(rs.getString(12));
							resinspect.setOanMManualPreparedId(rs.getInt(13));
							
							if(rs.getInt(13)==1){
								
								resinspect.setOanMManualPrepared("Yes");
							}else{
								resinspect.setOanMManualPrepared("No");
								
							}
							
							
							resinspect.setGalleryDryStatus(rs.getString(14));
							resinspect.setGalleryElevation(rs.getString(15));
							resinspect.setUnusualDamDesignId(rs.getInt(16));
							
							if(rs.getInt(16)==1){
								
								resinspect.setUnusualDamDesign("Yes");
							}else{
								
								resinspect.setUnusualDamDesign("No");
							}
						
							 
							resinspect.setUnusualDamDesigndetails(rs.getString(17));
							resinspect.setSpecialDifficultFoundationIssues(rs.getString(18));
							resinspect.setMfdobservedflood(rs.getDouble(19));
							resinspect.setMfddesignflood(rs.getDouble(20));
							resinspect.setCapacitydeadstorage(rs.getDouble(21));
							resinspect.setSalienttopwidth(rs.getDouble(22));
							resinspect.setSalientbottomwidth(rs.getDouble(23));
							resinspect.setSalientlengthcrest(rs.getDouble(24));
							resinspect.setSalientheightdfl(rs.getDouble(25));
							resinspect.setDamBreakAnalysisId(rs.getInt(26));
							
							if(rs.getInt(26)==1){
								
								resinspect.setDamBreakAnalysis("Yes");
							}else{
								
								resinspect.setDamBreakAnalysis("No");
							}
							resinspect.setStructuralSafetyPerformedId(rs.getInt(27));
							
							if(rs.getInt(27)==1){
								
								resinspect.setStructuralSafetyPerformed("Yes");
							}else{
								
								resinspect.setStructuralSafetyPerformed("No");
								
							}
							 
							resinspect.setReservoirSiltedId(rs.getInt(28));
							
							if(rs.getInt(28)==1){
								
								resinspect.setReservoirSilted("Yes");
							}else{
								resinspect.setReservoirSilted("No");
								
							}
							resinspect.setGateOperationMethodId(rs.getInt(29));
							if(rs.getInt(29)==1){
								
								resinspect.setGateOperationMethod("Hydraulic");
							}else if (rs.getInt(29)==2){
								
								resinspect.setGateOperationMethod("electric");
								
							}else if (rs.getInt(29)==3){
								
								resinspect.setGateOperationMethod("manual");
								
							}
                               else if (rs.getInt(29)==4){
								
								resinspect.setGateOperationMethod("Automatic fall");
								
							}else {
								
								resinspect.setGateOperationMethod("No Gates");
							}
							
							resinspect.setGrossCapacityMwl(rs.getDouble(30));
							
							resinspect.setResgatesize(rs.getString(31));
							resinspect.setResgatenumber(rs.getString(32));
							
							resinspect.setDamGalleryNumber(rs.getString(33));
							
							resinspect.setDamGateNumberFine(rs.getInt(34));
							
							//resinspect.setCapacityactivestorage(rs.getDouble(35));
							
							resinspect.setCapacityactivestorageStr(rs.getString(35));
							
							
						
							
							
							
							return resinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return reslist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public List<DamInspectDocs> getDamInspectPhotosByResInspectMst1Id(DamInspectDocs resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_DAM_INSPECT_PHOTOS_MST1_REPORT ;
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<DamInspectDocs> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getResInspectMst1Id() },
					new RowMapper<DamInspectDocs>() {

						public DamInspectDocs mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							DamInspectDocs resinspect = new DamInspectDocs();
							
							 // System.out.println("result"+rs.getInt(1));
							
							resinspect.setDamdocId(rs.getInt(1));				
							resinspect.setResInspectMst1Id(rs.getInt(2));
							resinspect.setInspectOfficeInfoId(rs.getInt(3));
							resinspect.setDamDocOriginalName(rs.getString(4));
							resinspect.setDamDocName(rs.getString(5));
							resinspect.setDamDocLocation(rs.getString(6));
							resinspect.setIsLatest(rs.getBoolean(7));
							resinspect.setDocTitle(rs.getString(8));
							resinspect.setInspectOfficeName(rs.getString(9));
							
							
							
							
							return resinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return resinspectrecommList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public List<InvResAbstract> getInvomResEEAbstractList(ReservoirInspect reservoirObj) throws InventoryUserException {
		// TODO Auto-generated method stub
	//	String sql = SELECT_INVOM_RES_ABSTRACT_UNIT;
		
	      String sql_not_in_division_cond= "(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as ressubmittedunsat, 0 as ressubmittedpoor , 0 as ressubmittedfair , 0 as ressubmittedsat ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",cm.circle_id as circle_id,cm.circle_name as circle_name , dm.division_id as division_id, dm.division_name as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cnd1, 0 as cnd2,0 as cnd3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id,resdata.circle_id, resdata.division_id from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id,irum.circle_id,irum.division_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id,irum.circle_id,irum.division_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id,irum.circle_id, irum.division_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id,ts.circle_id,ts.division_id  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id,ts.circle_id,ts.division_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id,ts.circle_id,ts.division_id ) )  resdata  group by resdata.unit_id,resdata.circle_id,resdata.division_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false)  inner join circle_master cm on (restotalnadata.circle_id=cm.circle_id and cm.delete_flag=false)  inner join division_master dm on (restotalnadata.division_id =dm.division_id  and restotalnadata.circle_id=dm.circle_id   and dm.delete_flag=false)  ) union all   ";
		
		String sql_not_in_division_bydivision_cond= "(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as ressubmittedunsat, 0 as ressubmittedpoor , 0 as ressubmittedfair , 0 as ressubmittedsat ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",cm.circle_id as circle_id,cm.circle_name as circle_name , dm.division_id as division_id, dm.division_name as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cnd1, 0 as cnd2,0 as cnd3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id,resdata.circle_id, resdata.division_id from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id,irum.circle_id,irum.division_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id,irum.circle_id,irum.division_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id,irum.circle_id, irum.division_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id,ts.circle_id,ts.division_id  FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id,ts.circle_id,ts.division_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id,ts.circle_id,ts.division_id ) )  resdata  group by resdata.unit_id,resdata.circle_id,resdata.division_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false)  inner join circle_master cm on (restotalnadata.circle_id=cm.circle_id and cm.delete_flag=false)  inner join division_master dm on (restotalnadata.division_id =dm.division_id  and restotalnadata.circle_id=dm.circle_id   and dm.delete_flag=false) where um.unit_id="+reservoirObj.getUnitId()+" ) union all   ";
		
	
		
	
String sql=null;
		
		if(reservoirObj!=null){
			
			if(((reservoirObj.getUnitId()>0 &&(reservoirObj.getUnitId()==4 || reservoirObj.getUnitId()==9832 || reservoirObj.getUnitId()==9830 ||  reservoirObj.getUnitId()==9  ) && reservoirObj.getCircleId()==0 && reservoirObj.getDivisionId()==0 && reservoirObj.getSubdivisionId()==0)
					||(reservoirObj.getUnitId()==4 && reservoirObj.getCircleId()==104 && reservoirObj.getDivisionId()==30327&& reservoirObj.getDesignationId()==5)
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==0 && reservoirObj.getDesignationId()==7)
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==31099 && (reservoirObj.getDesignationId()==5 || reservoirObj.getDesignationId()==4 || reservoirObj.getDesignationId()==2 || reservoirObj.getDesignationId()==8 ))
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==31099 &&  reservoirObj.getSubdivisionId()==12173 && (reservoirObj.getDesignationId()==5 || reservoirObj.getDesignationId()==4 || reservoirObj.getDesignationId()==2 || reservoirObj.getDesignationId()==8 ))
					
					||(reservoirObj.getUnitId()==9818 && reservoirObj.getCircleId()==21584 && reservoirObj.getDivisionId()==31022 &&  reservoirObj.getSubdivisionId()==11862 && ( reservoirObj.getDesignationId()==4 ))
					
					)|| (reservoirObj.getPostId()==1106177746)
					|| (reservoirObj.getPostId()==931)
					|| (reservoirObj.getPostId()==932)
					|| (reservoirObj.getPostId()==921)
					|| (reservoirObj.getPostId()==911)){
		
		 sql=sql_not_in_division_cond+ SELECT_INVOM_RES_ABSTRACT_DIVISION+"  order by  unit_name " ; 
		
			}
			if((reservoirObj.getUnitId()!=4 && reservoirObj.getUnitId()!=9832 && reservoirObj.getUnitId()!=9830 && reservoirObj.getUnitId()!=9 && reservoirObj.getPostId()!=1106177746) ) {
			if((reservoirObj.getUnitId()>0  && reservoirObj.getCircleId()==0 && reservoirObj.getDivisionId()==0 && reservoirObj.getSubdivisionId()==0) ){
				
				sql= sql_not_in_division_bydivision_cond+ SELECT_INVOM_RES_ABSTRACT_DIVISION+ "  and irdam1.unit_id="+reservoirObj.getUnitId()+" order by unit_name ";
				
					}
			}
			
			
		
		}
		
		
	//System.out.println("sql ee cond"+sql);
		
		
		Integer year=0;
		Integer dutyfrequnecy=0;
		try {
			
			if(reservoirObj.getYear()>0){
				
				year=reservoirObj.getYear();
			}
			
           if(reservoirObj.getDutyFrequencyId()>0){
				
        	   dutyfrequnecy=reservoirObj.getDutyFrequencyId();
			}
			
		//	System.out.println("year"+year);
			
		//	System.out.println("sql"+sql);
			
		//	System.out.println("dutyfrequnecy"+dutyfrequnecy);

			List<InvResAbstract> invResAbstractList = jdbcTemplate8.query(sql,new Object[]{year,dutyfrequnecy }, new RowMapper<InvResAbstract>() {

				public InvResAbstract mapRow(ResultSet rs, int rowNum) throws SQLException {

					InvResAbstract invResAbstract = new InvResAbstract();
					invResAbstract.setUnitId(rs.getInt(1));
					invResAbstract.setResTotalCount(rs.getInt(2));
					invResAbstract.setResSubmittedCount(rs.getInt(3));
					invResAbstract.setResUnsatisfactory(rs.getInt(4));
					invResAbstract.setResPoor(rs.getInt(5));
					invResAbstract.setResFair(rs.getInt(6));
					invResAbstract.setResSatisfactory(rs.getInt(7));
					
					invResAbstract.setUnitName(rs.getString(8));
					
					invResAbstract.setYear(rs.getInt(9));
					
					invResAbstract.setDutyFrequencyId(rs.getInt(10));
					
					invResAbstract.setCircleId(rs.getInt(11));
					
					invResAbstract.setCircleName(rs.getString(12));
					
					invResAbstract.setDivisionId(rs.getInt(13));
					
					invResAbstract.setDivisionName(rs.getString(14));
					
					invResAbstract.setSubdivisionId(rs.getInt(15));
					
					invResAbstract.setSubdivisionName(rs.getString(16));
					
					invResAbstract.setSectionId(rs.getInt(17));
					
					invResAbstract.setPostId(rs.getLong(18));
					
					invResAbstract.setPostName(rs.getString(19));
					
					invResAbstract.setConditionofDamId(rs.getInt(20));
					
					invResAbstract.setUnsatconditionofDamId(rs.getInt(21));
					
					invResAbstract.setPoorconditionofDamId(rs.getInt(22));
					
					
					invResAbstract.setFairconditionofDamId(rs.getInt(23));
					
					invResAbstract.setSatconditionofDamId(rs.getInt(24));


					return invResAbstract;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return invResAbstractList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	
	
	@Override
	public List<InvResAbstract> getInvomCategoryResEEAbstractList(ReservoirInspect reservoirObj) throws InventoryUserException {
		// TODO Auto-generated method stub
	//	String sql = SELECT_INVOM_RES_ABSTRACT_UNIT;
		//String sql_not_in_unit = "(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as restotalcat1, 0 as restotalcat2 , 0 as restankscat3 , 0 as restotalcatna ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",0 as circle_id,'na' as circle_name , 0 as division_id, 'NA' as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cat1, 0 as cat2,0 as cat3,4 as cnd4  from ( select sum (restotal) as restotal, resdata.unit_id as unit_id from ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id FROM  invom.invom_reservoirs ir inner join invom.invom_res_unit_map irum   on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )   where ir.is_nrld=true   and  irum.unit_id not in ( select distinct irdam1.unit_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id  )   union all  (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id    FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts      on (ts.postid=imt.post_id and ts.post_status='ACTIVE') where ts.unit_id not in ( select distinct irdam1.unit_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id ) )  resdata  group by resdata.unit_id) restotalnadata inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false) ) union all " ;
		
		String sql_not_in_division="(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as restotalcat1, 0 as restotalcat2 , 0 as restankscat3 , 0 as restotalcatna ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",cm.circle_id as circle_id,cm.circle_name as circle_name , dm.division_id as division_id, dm.division_name as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cat1, 0 as cat2,0 as cat3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id,resdata.circle_id, resdata.division_id from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id,irum.circle_id ,irum.division_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id, irum.circle_id,irum.division_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id,irum.circle_id,irum.division_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id,ts.circle_id,ts.division_id   FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id,ts.circle_id,ts.division_id ) not in ( select distinct irdam1.unit_id, irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id,ts.circle_id,ts.division_id ) )  resdata  group by resdata.unit_id,resdata.circle_id,resdata.division_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false)   inner join circle_master cm on (restotalnadata.circle_id=cm.circle_id and cm.delete_flag=false)  inner join division_master dm on (restotalnadata.division_id =dm.division_id  and restotalnadata.circle_id=dm.circle_id   and dm.delete_flag=false)  ) union all " ;	
			
		String sql_not_in_divisionbydivision="(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as restotalcat1, 0 as restotalcat2 , 0 as restankscat3 , 0 as restotalcatna ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",cm.circle_id as circle_id,cm.circle_name as circle_name , dm.division_id as division_id, dm.division_name as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cat1, 0 as cat2,0 as cat3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id,resdata.circle_id, resdata.division_id from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id,irum.circle_id ,irum.division_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id, irum.circle_id,irum.division_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id,irum.circle_id,irum.division_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id,ts.circle_id,ts.division_id   FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id,ts.circle_id,ts.division_id ) not in ( select distinct irdam1.unit_id, irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id,ts.circle_id,ts.division_id ) )  resdata  group by resdata.unit_id,resdata.circle_id,resdata.division_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false)   inner join circle_master cm on (restotalnadata.circle_id=cm.circle_id and cm.delete_flag=false)  inner join division_master dm on (restotalnadata.division_id =dm.division_id  and restotalnadata.circle_id=dm.circle_id   and dm.delete_flag=false) where um.unit_id="+reservoirObj.getUnitId()+"  ) union all " ;
		
		
String sql=null;
		
		if(reservoirObj!=null){
			
			if(((reservoirObj.getUnitId()>0 &&(reservoirObj.getUnitId()==4 || reservoirObj.getUnitId()==9832 || reservoirObj.getUnitId()==9830 ||  reservoirObj.getUnitId()==9  ) && reservoirObj.getCircleId()==0 && reservoirObj.getDivisionId()==0 && reservoirObj.getSubdivisionId()==0)
					||(reservoirObj.getUnitId()==4 && reservoirObj.getCircleId()==104 && reservoirObj.getDivisionId()==30327&& reservoirObj.getDesignationId()==5)
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==0 && reservoirObj.getDesignationId()==7)
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==31099 && (reservoirObj.getDesignationId()==5 || reservoirObj.getDesignationId()==4 || reservoirObj.getDesignationId()==2 || reservoirObj.getDesignationId()==8 ))
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==31099 &&  reservoirObj.getSubdivisionId()==12173 && (reservoirObj.getDesignationId()==5 || reservoirObj.getDesignationId()==4 || reservoirObj.getDesignationId()==2 || reservoirObj.getDesignationId()==8 ))
					
					||(reservoirObj.getUnitId()==9818 && reservoirObj.getCircleId()==21584 && reservoirObj.getDivisionId()==31022 &&  reservoirObj.getSubdivisionId()==11862 && ( reservoirObj.getDesignationId()==4 ))
					
					)|| (reservoirObj.getPostId()==1106177746)
					|| (reservoirObj.getPostId()==931)
					|| (reservoirObj.getPostId()==932)
					|| (reservoirObj.getPostId()==921)
					|| (reservoirObj.getPostId()==911)){
		
		 sql=sql_not_in_division+SELECT_CAT_RES_ABSTRACT_DIVISION+"  order by  unit_name " ; 
		
			}
			if((reservoirObj.getUnitId()!=4 && reservoirObj.getUnitId()!=9832 && reservoirObj.getUnitId()!=9830 && reservoirObj.getUnitId()!=9 && reservoirObj.getPostId()!=1106177746) ) {
			if((reservoirObj.getUnitId()>0  && reservoirObj.getCircleId()==0 && reservoirObj.getDivisionId()==0 && reservoirObj.getSubdivisionId()==0) ){
				
				sql=sql_not_in_divisionbydivision+ SELECT_CAT_RES_ABSTRACT_DIVISION+ "  and irdam1.unit_id="+reservoirObj.getUnitId()+" order by unit_name ";
				
					}
			}
			
			
		
		}
		
		
		//System.out.println("sqleecat"+sql);
		
		
		Integer year=0;
		Integer dutyfrequnecy=0;
		try {
			
			if(reservoirObj.getYear()>0){
				
				year=reservoirObj.getYear();
			}
			
           if(reservoirObj.getDutyFrequencyId()>0){
				
        	   dutyfrequnecy=reservoirObj.getDutyFrequencyId();
			}
			
		//	System.out.println("year"+year);
			
		//	System.out.println("sql"+sql);
			
		//	System.out.println("dutyfrequnecy"+dutyfrequnecy);

			List<InvResAbstract> invResAbstractList = jdbcTemplate8.query(sql,new Object[]{year,dutyfrequnecy }, new RowMapper<InvResAbstract>() {

				public InvResAbstract mapRow(ResultSet rs, int rowNum) throws SQLException {

					InvResAbstract invResAbstract = new InvResAbstract();
					invResAbstract.setUnitId(rs.getInt(1));
					invResAbstract.setResTotalCount(rs.getInt(2));
					invResAbstract.setResSubmittedCount(rs.getInt(3));
					invResAbstract.setCategory1(rs.getInt(4));
					invResAbstract.setCategory2(rs.getInt(5));
					invResAbstract.setCategory3(rs.getInt(6));
					invResAbstract.setCategoryNA(rs.getInt(7));
					
					invResAbstract.setUnitName(rs.getString(8));
					
					invResAbstract.setYear(rs.getInt(9));
					
					invResAbstract.setDutyFrequencyId(rs.getInt(10));
					
					invResAbstract.setCircleId(rs.getInt(11));
					
					invResAbstract.setCircleName(rs.getString(12));
					
					invResAbstract.setDivisionId(rs.getInt(13));
					
					invResAbstract.setDivisionName(rs.getString(14));
					
					invResAbstract.setSubdivisionId(rs.getInt(15));
					
					invResAbstract.setSubdivisionName(rs.getString(16));
					
					invResAbstract.setSectionId(rs.getInt(17));
					
					invResAbstract.setPostId(rs.getLong(18));
					
					invResAbstract.setPostName(rs.getString(19));
					
					invResAbstract.setCategoryId0(rs.getInt(20));
					
					invResAbstract.setCategoryId1(rs.getInt(21));
					
					invResAbstract.setCategoryId2(rs.getInt(22));
					
					
					invResAbstract.setCategoryId3(rs.getInt(23));
					
					invResAbstract.setCategoryId4(rs.getInt(24));


					return invResAbstract;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return invResAbstractList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	
	
	
	
	@Override
	public List<InvResAbstract> getInvomResCategorywiseAbstractList(ReservoirInspect reservoirObj) throws InventoryUserException {
		// TODO Auto-generated method stub
	String sql_not_in_unit = "(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as restotalcat1, 0 as restotalcat2 , 0 as restankscat3 , 0 as restotalcatna ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",0 as circle_id,'na' as circle_name , 0 as division_id, 'NA' as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cat1, 0 as cat2,0 as cat3,4 as cnd4  from ( select sum (restotal) as restotal, resdata.unit_id as unit_id from ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id FROM  invom.invom_reservoirs ir inner join invom.invom_res_unit_map irum   on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )   where ir.is_nrld=true   and  irum.unit_id not in ( select distinct irdam1.unit_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id  )   union all  (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id    FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts      on (ts.postid=imt.post_id and ts.post_status='ACTIVE') where ts.unit_id not in ( select distinct irdam1.unit_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id ) )  resdata  group by resdata.unit_id) restotalnadata inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false) ) union all " ;
	
	String sql_not_in_unit_byunit = "(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as restotalcat1, 0 as restotalcat2 , 0 as restankscat3 , 0 as restotalcatna ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",0 as circle_id,'na' as circle_name , 0 as division_id, 'NA' as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cat1, 0 as cat2,0 as cat3,4 as cnd4  from ( select sum (restotal) as restotal, resdata.unit_id as unit_id from ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id FROM  invom.invom_reservoirs ir inner join invom.invom_res_unit_map irum   on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )   where ir.is_nrld=true   and  irum.unit_id not in ( select distinct irdam1.unit_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id  )   union all  (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id    FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts      on (ts.postid=imt.post_id and ts.post_status='ACTIVE') where ts.unit_id not in ( select distinct irdam1.unit_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id ) )  resdata  group by resdata.unit_id) restotalnadata inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false) where um.unit_id="+reservoirObj.getUnitId()+" ) union all " ;
		
	//04072023String sql_not_in_division="(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as restotalcat1, 0 as restotalcat2 , 0 as restankscat3 , 0 as restotalcatna ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",cm.circle_id as circle_id,cm.circle_name as circle_name , dm.division_id as division_id, dm.division_name as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cat1, 0 as cat2,0 as cat3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id,resdata.circle_id, resdata.division_id from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id,irum.circle_id ,irum.division_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id, irum.circle_id,irum.division_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id,irum.circle_id,irum.division_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id,ts.circle_id,ts.division_id   FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id,ts.circle_id,ts.division_id ) not in ( select distinct irdam1.unit_id, irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id,ts.circle_id,ts.division_id ) )  resdata  group by resdata.unit_id,resdata.circle_id,resdata.division_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false)   inner join circle_matser cm on (restotalnadata.circle_id)=cm.circle_id and cm.delete_flag=false)  inner join division_master dm on (restotalnadata.division_id =dm.division_id  and restotalnadata.circle_id=dm.circle_id   and dm.delete_flag=false)  ) union all " ;	
	String sql_not_in_division="(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as restotalcat1, 0 as restotalcat2 , 0 as restankscat3 , 0 as restotalcatna ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",cm.circle_id as circle_id,cm.circle_name as circle_name , dm.division_id as division_id, dm.division_name as division_name , 0 as subdivision_id, 'NA' as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cat1, 0 as cat2,0 as cat3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id,resdata.circle_id, resdata.division_id from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id,irum.circle_id ,irum.division_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id, irum.circle_id,irum.division_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id,irum.circle_id,irum.division_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id,ts.circle_id,ts.division_id   FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id,ts.circle_id,ts.division_id ) not in ( select distinct irdam1.unit_id, irdam1.circle_id,irdam1.division_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id,ts.circle_id,ts.division_id ) )  resdata  group by resdata.unit_id,resdata.circle_id,resdata.division_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false)   inner join circle_master cm on (restotalnadata.circle_id=cm.circle_id and cm.delete_flag=false)  inner join division_master dm on (restotalnadata.division_id =dm.division_id  and restotalnadata.circle_id=dm.circle_id   and dm.delete_flag=false) where cm.circle_id="+reservoirObj.getCircleId()+"  and um.unit_id="+reservoirObj.getUnitId()+" ) union all " ;	

	String sql_not_in_subdivision= "(select restotalnadata.unit_id,restotal,0  as ressubmitted,0  as restotalcat1, 0 as restotalcat2 , 0 as restankscat3 , 0 as restotalcatna ,um.unit_name, "+reservoirObj.getYear()+","+reservoirObj.getDutyFrequencyId()+",cm.circle_id as circle_id,cm.circle_name as circle_name , dm.division_id as division_id, dm.division_name as division_name , sm.subdivision_id as subdivision_id, sm.subdivision_name as subdivision_name,0 as section_id, 0 as post_id, 'NA' as post_name,0 as ressubcondition,0 as cat1, 0 as cat2,0 as cat3,4 as cnd4   from ( select sum (restotal) as restotal,  resdata.unit_id as unit_id,resdata.circle_id, resdata.division_id,resdata.subdivision_id from   ( (SELECT  count(distinct (coalesce( irum.reservoir_id,0))) as restotal,irum.unit_id as unit_id,irum.circle_id ,irum.division_id,irum.subdivision_id   FROM  invom.invom_reservoirs ir   inner join invom.invom_res_unit_map irum    on (ir.res_id=irum.reservoir_id and irum.delete_flag=false and irum.is_latest=true )  where ir.is_nrld=true   and  (irum.unit_id, irum.circle_id,irum.division_id,irum.subdivision_id ) not in ( select distinct irdam1.unit_id,irdam1.circle_id,irdam1.division_id,irdam1.subdivision_id  from  invom.invom_res_dam_ann1_mst1 irdam1 where irdam1.delete_flag=false and irdam1.is_latest=true and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+" )  group by irum.unit_id,irum.circle_id,irum.division_id,irum.subdivision_id  )   union all   (SELECT  count(coalesce( imt.tank_id_mk,0)) as restotal,ts.unit_id as unit_id,ts.circle_id,ts.division_id,ts.subdivision_id   FROM  invom.invom_mi_tanks imt   inner join taskmanagement.subposts ts   on (ts.postid=imt.post_id and ts.post_status='ACTIVE')  where (ts.unit_id,ts.circle_id,ts.division_id,ts.subdivision_id ) not in ( select distinct irdam1.unit_id, irdam1.circle_id,irdam1.division_id,irdam1.subdivision_id  from  invom.invom_res_dam_ann1_mst1 irdam1  where irdam1.delete_flag=false and irdam1.is_latest=true  and irdam1.freq_year= "+reservoirObj.getYear()+" and irdam1.freq_operation= "+reservoirObj.getDutyFrequencyId()+  " ) and imt.is_nrld=true   and imt.delete_flag=false and imt.is_latest=true  group by ts.unit_id,ts.circle_id,ts.division_id,ts.subdivision_id ) )  resdata  group by resdata.unit_id,resdata.circle_id,resdata.division_id,resdata.subdivision_id) restotalnadata  inner join unit_master um on (restotalnadata.unit_id=um.unit_id and um.delete_flag=false)   inner join circle_master cm on (restotalnadata.circle_id=cm.circle_id and cm.delete_flag=false)  inner join division_master dm on (restotalnadata.division_id =dm.division_id  and restotalnadata.circle_id=dm.circle_id   and dm.delete_flag=false)  inner join subdivision_master sm on (restotalnadata.subdivision_id=sm.subdivision_id and restotalnadata.division_id=sm.division_id and sm.delete_flag=false ) where dm.division_id="+reservoirObj.getDivisionId()+" and cm.circle_id="+reservoirObj.getCircleId()+" and um.unit_id="+reservoirObj.getUnitId()+" ) union all  " ;
	
	String sql=null;
		
		if(reservoirObj!=null){
			
			if(((reservoirObj.getUnitId()>0 &&(reservoirObj.getUnitId()==4 || reservoirObj.getUnitId()==9832 || reservoirObj.getUnitId()==9830 ||  reservoirObj.getUnitId()==9  ) && reservoirObj.getCircleId()==0 && reservoirObj.getDivisionId()==0 && reservoirObj.getSubdivisionId()==0)
					||(reservoirObj.getUnitId()==4 && reservoirObj.getCircleId()==104 && reservoirObj.getDivisionId()==30327&& reservoirObj.getDesignationId()==5)
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==0 && reservoirObj.getDesignationId()==7)
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==31099 && (reservoirObj.getDesignationId()==5 || reservoirObj.getDesignationId()==4 || reservoirObj.getDesignationId()==2 || reservoirObj.getDesignationId()==8 ))
					||(reservoirObj.getUnitId()==9830 && reservoirObj.getCircleId()==21609 && reservoirObj.getDivisionId()==31099 &&  reservoirObj.getSubdivisionId()==12173 && (reservoirObj.getDesignationId()==5 || reservoirObj.getDesignationId()==4 || reservoirObj.getDesignationId()==2 || reservoirObj.getDesignationId()==8 ))
					
					||(reservoirObj.getUnitId()==9818 && reservoirObj.getCircleId()==21584 && reservoirObj.getDivisionId()==31022 &&  reservoirObj.getSubdivisionId()==11862 && ( reservoirObj.getDesignationId()==4 ))
					
					)|| (reservoirObj.getPostId()==1106177746)
					|| (reservoirObj.getPostId()==931)
					|| (reservoirObj.getPostId()==932)
					|| (reservoirObj.getPostId()==921)
					|| (reservoirObj.getPostId()==911)){
		
		sql=  sql_not_in_unit+SELECT_CAT_RES_ABSTRACT_UNIT + "  order by unit_name" ;
		
			}
			if((reservoirObj.getUnitId()!=4 && reservoirObj.getUnitId()!=9832 && reservoirObj.getUnitId()!=9830 && reservoirObj.getUnitId()!=9 && reservoirObj.getPostId()!=1106177746) ) {
			if((reservoirObj.getUnitId()>0  && reservoirObj.getCircleId()==0 && reservoirObj.getDivisionId()==0 && reservoirObj.getSubdivisionId()==0) ){
				
				sql= sql_not_in_unit_byunit+SELECT_CAT_RES_ABSTRACT_UNIT + " and irdam1.unit_id="+reservoirObj.getUnitId()+"  order by unit_name" ;
				
				//31052023
				//sql= SELECT_CAT_RES_ABSTRACT_CIRCLE+ "  and irdam1.unit_id="+reservoirObj.getUnitId()+"  order by um.unit_name";
				
					}
			}if(reservoirObj.getUnitId()!=4  ){
			if(reservoirObj.getUnitId()>0 && reservoirObj.getCircleId()>0 && reservoirObj.getDivisionId()==0 && reservoirObj.getSubdivisionId()==0){
				
				sql=sql_not_in_division+SELECT_CAT_RES_ABSTRACT_DIVISION+" and irdam1.circle_id="+reservoirObj.getCircleId()+" and  irdam1.unit_id="+reservoirObj.getUnitId()+" order by division_name, circle_name, unit_name" ; 
				
					}
			
     if(reservoirObj.getUnitId()>0 && reservoirObj.getCircleId()>0 && reservoirObj.getDivisionId()>0 && reservoirObj.getSubdivisionId()==0 && (reservoirObj.getDesignationId()==5)){
				
				sql=sql_not_in_subdivision+SELECT_CAT_RES_ABSTRACT_SUBDIVISION+ " and irdam1.division_id="+reservoirObj.getDivisionId()+" and irdam1.circle_id="+reservoirObj.getCircleId()+" and  irdam1.unit_id="+reservoirObj.getUnitId()+" order by subdivision_name,  division_name, circle_name, unit_name" ; 
				
					}
     
     if(reservoirObj.getUnitId()>0 && reservoirObj.getCircleId()>0 && reservoirObj.getDivisionId()>0 && reservoirObj.getSubdivisionId()>0 && (reservoirObj.getDesignationId()==4)){
			
			sql=SELECT_CAT_RES_ABSTRACT_EMP+" and irdam1.subdivision_id="+reservoirObj.getSubdivisionId()+" and irdam1.division_id="+reservoirObj.getDivisionId()+" and irdam1.circle_id="+reservoirObj.getCircleId()+" and  irdam1.unit_id="+reservoirObj.getUnitId()+" order by subdivision_name, division_name, circle_name, unit_name" ; 
			
				}
     
     if(reservoirObj.getUnitId()>0 && reservoirObj.getCircleId()>0 && reservoirObj.getDivisionId()>0 && reservoirObj.getSubdivisionId()>0 &&  reservoirObj.getPostId()>0 && (reservoirObj.getDesignationId()==2 || reservoirObj.getDesignationId()==8 )){
			
    	 sql=SELECT_CAT_RES_ABSTRACT_EMP+" and irdam1.post_id= "+reservoirObj.getPostId() +" and irdam1.subdivision_id="+reservoirObj.getSubdivisionId()+" and irdam1.division_id="+reservoirObj.getDivisionId()+" and irdam1.circle_id="+reservoirObj.getCircleId()+" and  irdam1.unit_id="+reservoirObj.getUnitId()+" order by post_name, subdivision_name, division_name, circle_name, unit_name" ; 
			
				}
			}
		
		}
		
		
		//System.out.println("sql cat list "+sql);
		
		
		Integer year=0;
		Integer dutyfrequnecy=0;
		try {
			
			if(reservoirObj.getYear()>0){
				
				year=reservoirObj.getYear();
			}
			
           if(reservoirObj.getDutyFrequencyId()>0){
				
        	   dutyfrequnecy=reservoirObj.getDutyFrequencyId();
			}
			
		//	System.out.println("year"+year);
			
		//	System.out.println("sql"+sql);
			
		//	System.out.println("dutyfrequnecy"+dutyfrequnecy);

			List<InvResAbstract> invResAbstractList = jdbcTemplate8.query(sql,new Object[]{year,dutyfrequnecy }, new RowMapper<InvResAbstract>() {

				public InvResAbstract mapRow(ResultSet rs, int rowNum) throws SQLException {

					InvResAbstract invResAbstract = new InvResAbstract();
					invResAbstract.setUnitId(rs.getInt(1));
					invResAbstract.setResTotalCount(rs.getInt(2));
					invResAbstract.setResSubmittedCount(rs.getInt(3));
					invResAbstract.setCategory1(rs.getInt(4));
					invResAbstract.setCategory2(rs.getInt(5));
					invResAbstract.setCategory3(rs.getInt(6));
					invResAbstract.setCategoryNA(rs.getInt(7));
					
					invResAbstract.setUnitName(rs.getString(8));
					
					invResAbstract.setYear(rs.getInt(9));
					
					invResAbstract.setDutyFrequencyId(rs.getInt(10));
					
					invResAbstract.setCircleId(rs.getInt(11));
					
					invResAbstract.setCircleName(rs.getString(12));
					
					invResAbstract.setDivisionId(rs.getInt(13));
					
					invResAbstract.setDivisionName(rs.getString(14));
					
					invResAbstract.setSubdivisionId(rs.getInt(15));
					
					invResAbstract.setSubdivisionName(rs.getString(16));
					
					invResAbstract.setSectionId(rs.getInt(17));
					
					invResAbstract.setPostId(rs.getLong(18));
					
					invResAbstract.setPostName(rs.getString(19));
					
					invResAbstract.setCategoryId0(rs.getInt(20));
					
					invResAbstract.setCategoryId1(rs.getInt(21));
					
					invResAbstract.setCategoryId2(rs.getInt(22));
					
					
					invResAbstract.setCategoryId3(rs.getInt(23));
					
					invResAbstract.setCategoryId4(rs.getInt(24));


					return invResAbstract;
				}

			});
			jdbcTemplate8.getDataSource().getConnection().close();
			return invResAbstractList;
		} catch (Exception exc) {

			return null;
		}
	}
	
	
	@Override
	public List<ReservoirInspect> getDamsafetySelectYear() throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = SELECT_RES_DAM_SAFETY_YR ;
		try {

			List<ReservoirInspect> yearList = jdbcTemplate8.query(sql,
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect mtfd = new ReservoirInspect();
							
							mtfd.setYear(rs.getInt(1));
							/*mtfd.setFormDataId(rs.getInt(2));*/
							return mtfd;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return yearList;
		} catch (Exception exc) {
			exc.getMessage();
			return null;
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
				
			}
