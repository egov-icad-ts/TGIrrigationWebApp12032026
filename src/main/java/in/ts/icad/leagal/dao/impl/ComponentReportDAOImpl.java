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

import in.ts.icad.leagal.dao.ComponentReportDAO;
import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.ComponentAyacut;
import in.ts.icad.leagal.model.ComponentsCapacity;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.abstractCounterData;

@Repository
public class ComponentReportDAOImpl implements ComponentReportDAO {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private final boolean IS_DEBUG_ENABLED = log.isDebugEnabled();

	private JdbcTemplate jdbcTemplate;
	private JdbcTemplate jdbcTemplate4;
	
	private JdbcTemplate jdbcTemplate12;
	
	
	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Resource(name = "dataSource4")
	public void setDataSource4(DataSource dataSource4) {
		this.jdbcTemplate4 = new JdbcTemplate(dataSource4);
	}
	
	
	@Resource(name = "dataSource12")
	public void setDataSource12(DataSource dataSource12) {
		this.jdbcTemplate12 = new JdbcTemplate(dataSource12);
	}

	
	

	/*private JdbcTemplate jdbcHrmsTemplate;

	@Resource(name = "dataSource1")
	public void setDataSource1(DataSource dataSource) {
		this.jdbcHrmsTemplate = new JdbcTemplate(dataSource);
	}
*/
	
	@Value("${SELECT_PROJ_COMPONENTS}")
	private String SELECT_PROJ_COMPONENTS;
	
	@Value("${SELECT_PROJ_LIFT_DATA}")
	private String SELECT_PROJ_LIFT_DATA;
	
	@Value("${SELECT_COMP_CAP_ALLLIFTS}")
	private String SELECT_COMP_CAP_ALLLIFTS;
	
	@Value("${SELECT_COMP_POWER_INFO}")
	private String SELECT_COMP_POWER_INFO;
	
	@Value("${SELECT_COMP_GOOGLEMAPQUERY}")
	private String SELECT_COMP_GOOGLEMAPQUERY;
	
	@Value("${SELECT_MANDAL_AYACUT}")
	private String SELECT_MANDAL_AYACUT;
	
	@Value("${SELECT_CONST_AYACUT}")
	private String SELECT_CONST_AYACUT;
	
	@Value("${SELECT_CONST_TOTAL}")
	private String SELECT_CONST_TOTAL;
	
	@Value("${SELECT_PROJ_TOTAL_CONST}")
	private String SELECT_PROJ_TOTAL_CONST;
	
	@Value("${SELECT_PROJ_TOTAL_DIST_CONST}")
	private String SELECT_PROJ_TOTAL_DIST_CONST;
	
	
	@Value("${SELECT_TOTAL_DIST_CONST}")
	private String SELECT_TOTAL_DIST_CONST;
	
	
	@Value("${SELECT_TOTAL_MANDAL_CONST}")
	private String SELECT_TOTAL_MANDAL_CONST;
	
	@Value("${SELECT_PROJ_TOTAL_ALL_CONST}")
	private String SELECT_PROJ_TOTAL_ALL_CONST;
	
	@Value("${SELECT_PROJ_TOTAL}")
	private String SELECT_PROJ_TOTAL;
	
	@Value("${SELECT_CONST_DIST_MAN_VILL}")
	private String SELECT_CONST_DIST_MAN_VILL;
	
	
	@Value("${SELECT_CONST_DIST_MAN_VILL_BYID}")
	private String SELECT_CONST_DIST_MAN_VILL_BYID;
	
	
	@Value("${SELECT_VILLAGE_BYCONST}")
	private String SELECT_VILLAGE_BYCONST;
	
	
	@Value("${SELECT_MANDAL_BY_PROJ}")
	private String SELECT_MANDAL_BY_PROJ;
	
	
	@Value("${SELECT_OLD_DISTRICT}")
	private String SELECT_OLD_DISTRICT;
	
	
	@Value("${SELECT_UNIT_AYACUT}")
	private String SELECT_UNIT_AYACUT;
	
	@Value("${SELECT_DISTRICT_PROJECT_AYACUT}")
	private String SELECT_DISTRICT_PROJECT_AYACUT;
	
	
	@Value("${SELECT_PROJECT_PACKAGE_MAN_TOTAL}")
	private String SELECT_PROJECT_PACKAGE_MAN_TOTAL;
	
	@Value("${SELECT_UNIT_DISTRICT_AYACUT}")
	private String SELECT_UNIT_DISTRICT_AYACUT;
	
	@Value("${SELECT_MANDAL_BY_UNIT}")
	private String SELECT_MANDAL_BY_UNIT;
	
	@Value("${REPORT_PROJ_SEASON_CAP_ALL}")
	private String REPORT_PROJ_SEASON_CAP_ALL;
	
	@Value("${SELECT_AYACUT_JURISDICTION}")
	private String SELECT_AYACUT_JURISDICTION;
	
	
	@Value("${SELECT_AYACUT_DIVISION_MANDAL}")
	private String SELECT_AYACUT_DIVISION_MANDAL;
	
	@Value("${SELECT_PROJECT_AYACUT_PMS}")
	private String SELECT_PROJECT_AYACUT_PMS;
	
	
	@Value("${SELECT_PROJECT_MAN_TOTAL}")
	private String SELECT_PROJECT_MAN_TOTAL;
	
	
	@Value("${SELECT_PROJECT_MAN_VILLAGE_TOTAL}")
	private String SELECT_PROJECT_MAN_VILLAGE_TOTAL;
	
	@Value("${SELECT_DISTRICT_MAN_PROJECT_TOTAL}")
	private String SELECT_DISTRICT_MAN_PROJECT_TOTAL;
	
	@Value("${SELECT_DIST_MAN_PROJ}")
	private String SELECT_DIST_MAN_PROJ;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public List<Component> getComponentProgress( Integer projectId) throws ComponentUserException {
		String sql = SELECT_PROJ_COMPONENTS;
	
		try {
			List<Component> compList = jdbcTemplate4.query(sql ,new Object[] { projectId }, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum)
						throws SQLException {
				Component comp = new Component();
				comp.setComponentId(rs.getInt(1));
				comp.setComponentName(rs.getString(2));
				comp.setParentComponentId(rs.getInt(4));
				comp.setComponentLevelId(rs.getInt(5));
				comp.setComponentLength(rs.getDouble(8));			
				comp.setComponentDirection(rs.getInt(7));
				comp.setOfftakeChainage(rs.getDouble(6));
				comp.setProgressString(rs.getString(9));

			    return comp;


				}
            
			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentProgress method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
		
	}
	
	
	@Override
	public List<Component> getProjectLiftData( Integer projectId) throws ComponentUserException {
		String sql = SELECT_PROJ_LIFT_DATA;
		final Integer pumprpm=500;
		final Double ayacut=0.00;
		final Double powerconsumption =0.00;
		
	
		try {
			List<Component> compList = jdbcTemplate4.query(sql ,new Object[] { projectId }, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum)
						throws SQLException {
				Component comp = new Component();
				comp.setComponentId(rs.getInt(1));
				comp.setComponentName(rs.getString(2));
				//comp.setFromlocation("NA");
				//comp.setTolocation("NA");
				comp.setPmlength(rs.getDouble(14));
				//comp.setPumprpm(pumprpm);			
				comp.setMotorNumber(rs.getInt(21));
				comp.setMotormegawatts(rs.getDouble(19));
				comp.setLiftStatic(rs.getDouble(17));
				comp.setLiftDynamic(rs.getDouble(18));
				
				comp.setAnnualpowerconsumption(powerconsumption);;
				comp.setDischrgecusecs(rs.getDouble(12));
				comp.setAyacutacres(ayacut);
				comp.setPumpType(rs.getString(23));
				comp.setPumpMake(rs.getString(22));
				comp.setMotorType(rs.getString(24));
				comp.setMotorMake(rs.getString(25));
				comp.setPumprpm(rs.getInt(26));
				comp.setNoofpumpdays(rs.getInt(27));
				comp.setFromlocation(rs.getString(28));
				comp.setTolocation(rs.getString(29));
				if(rs.getInt(16)==1){
				comp.setStatus("service");
				}
				if(rs.getInt(16)==2){
					comp.setStatus("execution");
					}
				
				
				comp.setRemarks("NA");
				
			    return comp;


				}
            
			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getProjectLiftData method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
		
	}
	
	@Override
	public List<ComponentsCapacity> getComponentCapacityAllLifts( Integer statusId) throws ComponentUserException {
		String sql = SELECT_COMP_CAP_ALLLIFTS;
	
		try {
			List<ComponentsCapacity> compCapList = jdbcTemplate4.query(sql ,new Object[] { statusId }, new RowMapper<ComponentsCapacity>() {
				public ComponentsCapacity mapRow(ResultSet rs, int rowNum)
						throws SQLException {
				ComponentsCapacity cap = new ComponentsCapacity();
				cap.setComponentId(rs.getInt(1));
				cap.setComponentName(rs.getString(2));
				cap.setSmallconnected(rs.getDouble(3));
				cap.setSmallactual(rs.getDouble(4));
				cap.setMediumconnected(rs.getDouble(5));
				cap.setMediumactual(rs.getDouble(6));
				cap.setMajorconnected(rs.getDouble(7));
				cap.setMajoractual(rs.getDouble(8));
				

			    return cap;


				}
            
			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return compCapList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentCapacityAllLifts method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
		
	}
	
	@Override
	public List<Component> getCompPowerInfo( Integer projectId) throws ComponentUserException {
		String sql = SELECT_COMP_POWER_INFO;
		//final Integer pumprpm=500;
		final Double ayacut=0.00;
		final Double powerconsumption =0.00;
		
	
		try {
			List<Component> compList = jdbcTemplate4.query(sql ,new Object[] { projectId }, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum)
						throws SQLException {
				Component comp = new Component();
				comp.setComponentId(rs.getInt(1));
				comp.setComponentName(rs.getString(2));
				//comp.setFromlocation("NA");
				//comp.setTolocation("NA");
				comp.setPmlength(rs.getDouble(14));
				//comp.setPumprpm(pumprpm);			
				comp.setMotorNumber(rs.getInt(21));
				comp.setMotormegawatts(rs.getDouble(19));
				comp.setLiftStatic(rs.getDouble(17));
				comp.setLiftDynamic(rs.getDouble(18));
				
				comp.setAnnualpowerconsumption(powerconsumption);;
				comp.setDischrgecusecs(rs.getDouble(12));
				comp.setAyacutacres(ayacut);
				comp.setPumpType(rs.getString(23));
				comp.setPumpMake(rs.getString(22));
				comp.setMotorType(rs.getString(24));
				comp.setMotorMake(rs.getString(25));
				comp.setPumprpm(rs.getInt(26));
				comp.setNoofpumpdays(rs.getInt(27));
				comp.setFromlocation(rs.getString(28));
				comp.setTolocation(rs.getString(29));
				comp.setPipediameter(rs.getDouble(30));
				comp.setNoofpiperows(rs.getInt(32));
				comp.setTotalLift(rs.getDouble(33));
				comp.setLiftperiod(rs.getInt(34));
				comp.setLifttmc(rs.getDouble(35));
				comp.setMddlsign(rs.getString(36));
				comp.setDeliverylevelsign(rs.getString(37));
				comp.setEachmotorPower(rs.getDouble(38));
				comp.setTotalpower(rs.getDouble(39));
				comp.setAuxPower(rs.getDouble(40));
				comp.setTotalpowerwithAux(rs.getDouble(41));
				comp.setSubstationCapacity(rs.getString(42));
				if(rs.getInt(16)==1){
				comp.setStatus("service");
				}
				if(rs.getInt(16)==2){
					comp.setStatus("execution");
					}
				
				
				comp.setRemarks("NA");
				
			    return comp;


				}
            
			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return compList;

		} catch (Exception ex) {
			log.error("Inside getCompPowerInfo getProjectLiftData method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
		
	}

	@Override
	public List<Component> getCompGoogleMapStatusInfo(Integer projectId) throws ComponentUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_COMP_GOOGLEMAPQUERY;
		//final Integer pumprpm=500;
	
		
	
		try {
			List<Component> compList = jdbcTemplate4.query(sql ,new Object[] { projectId }, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum)
						throws SQLException {
				Component comp = new Component();
				comp.setComponentId(rs.getInt(1));
				comp.setComponentName(rs.getString(2));
				comp.setComponentCategory(rs.getString(3));
				comp.setDischrgecusecs(rs.getDouble(4));
				comp.setPipediameter(rs.getDouble(5));
				comp.setPmlength(rs.getDouble(6));
				comp.setNoofpiperows(rs.getInt(7));
				comp.setTotalLift(rs.getDouble(8));
				comp.setLiftperiod(rs.getInt(9));
				comp.setLifttmc(rs.getDouble(10));
				comp.setTotalpowerwithAux(rs.getDouble(11));
				comp.setSubstationCapacity(rs.getString(12));
				comp.setFromlocation(rs.getString(13));
				comp.setStatusId(rs.getInt(14));
				comp.setStatus(rs.getString(15));
				comp.setStatusColor(rs.getString(16));
				comp.setStatusAddress(rs.getString(17));
						
			
				
			
				
				
				
				
			    return comp;


				}
            
			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return compList;

		} catch (Exception ex) {
			log.error("Inside getCompGoogleMapStatusInfo  method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
		
	}
	
	@Override
	public List<ComponentAyacut> getMandalAyacutInfo(Integer districtId) throws ComponentUserException {

		String sql = SELECT_MANDAL_AYACUT;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> manList = jdbcTemplate4.query(sql,  new Object []{districtId,districtId},  new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut manayacut = new ComponentAyacut();
                   
					manayacut.setConstId(rs.getInt(1));
					manayacut.setConstName(rs.getString(2));
                        manayacut.setDistrictId(rs.getInt(3));
					
					manayacut.setMandalId(rs.getInt(4));
					manayacut.setAyacutCreated(rs.getDouble(5));
					manayacut.setStableAyacut(rs.getDouble(6));
					manayacut.setRemarks(rs.getString(7));
					manayacut.setProjectName(rs.getString(8));
					
					manayacut.setUnitName(rs.getString(9));
					manayacut.setPackageName(rs.getString(10));
					manayacut.setDistrictName(rs.getString(11));
					manayacut.setMandalName(rs.getString(12));
					manayacut.setIrriagtedAyacut(rs.getDouble(13));
					manayacut.setContemplatedAyacut(rs.getDouble(14));
					
					
					
					
					return manayacut;

				}

			});
			
			jdbcTemplate4.getDataSource().getConnection().close();
			return manList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getMandalAyacutInfo method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	@Override
	public List<ComponentAyacut> getUnitAyacutInfo() throws ComponentUserException {

		String sql = SELECT_UNIT_AYACUT;
		
		/*new Object []{districtId,districtId},*/

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> ceayacutList = jdbcTemplate4.query(sql,    new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut ceayacut = new ComponentAyacut();
					
					
					ceayacut.setUnitId(rs.getInt(1));
					ceayacut.setProjectId(rs.getInt(2));
					ceayacut.setAyacutCreated(rs.getDouble(3));
					ceayacut.setIrriagtedAyacut(rs.getDouble(4));
					ceayacut.setStableAyacut(rs.getDouble(5));
					ceayacut.setRemarks(rs.getString(6));
					ceayacut.setUnitName(rs.getString(7));
					ceayacut.setProjectName(rs.getString(8));
					ceayacut.setDistrictName(rs.getString(9));
					ceayacut.setPackageName(rs.getString(10));
					ceayacut.setMandalName(rs.getString(11));
					ceayacut.setConstName(rs.getString(12));
					ceayacut.setContemplatedAyacut(rs.getDouble(13));
					
					
					return ceayacut;

				}

			});
			
			jdbcTemplate4.getDataSource().getConnection().close();
			return ceayacutList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getUnitAyacutInfo method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	@Override
	public List<ComponentAyacut> getUnitDistrictAyacutInfo() throws ComponentUserException {

		String sql = SELECT_UNIT_DISTRICT_AYACUT;
		
		/*new Object []{districtId,districtId},*/

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> ceayacutList = jdbcTemplate4.query(sql,    new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut ceayacut = new ComponentAyacut();
					
					
					ceayacut.setUnitId(rs.getInt(1));
					ceayacut.setDistrictId(rs.getInt(2));
					ceayacut.setAyacutCreated(rs.getDouble(3));
					ceayacut.setIrriagtedAyacut(rs.getDouble(4));
					ceayacut.setStableAyacut(rs.getDouble(5));
					ceayacut.setRemarks(rs.getString(6));
					ceayacut.setUnitName(rs.getString(7));
					ceayacut.setProjectName(rs.getString(8));
					ceayacut.setDistrictName(rs.getString(9));
					ceayacut.setPackageName(rs.getString(10));
					ceayacut.setMandalName(rs.getString(11));
					ceayacut.setConstName(rs.getString(12));
					ceayacut.setContemplatedAyacut(rs.getDouble(13));
					
					
					return ceayacut;

				}

			});
			
			jdbcTemplate4.getDataSource().getConnection().close();
			return ceayacutList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getUnitAyacutInfo method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	@Override
	public List<ComponentAyacut> getDistprojAyacutInfo() throws ComponentUserException {

		String sql = SELECT_DISTRICT_PROJECT_AYACUT;
		
		/*new Object []{districtId,districtId},*/

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> distayacutList = jdbcTemplate4.query(sql,    new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut distayacut = new ComponentAyacut();
					
					
					distayacut.setDistrictId(rs.getInt(1));
					distayacut.setProjectId(rs.getInt(2));
					distayacut.setAyacutCreated(rs.getDouble(3));
					distayacut.setIrriagtedAyacut(rs.getDouble(4));
					distayacut.setStableAyacut(rs.getDouble(5));
					distayacut.setRemarks(rs.getString(6));
					distayacut.setDistrictName(rs.getString(7));
					distayacut.setProjectName(rs.getString(8));
					distayacut.setUnitName(rs.getString(9));
					distayacut.setPackageName(rs.getString(10));
					distayacut.setMandalName(rs.getString(11));
					distayacut.setConstName(rs.getString(12));
					distayacut.setContemplatedAyacut(rs.getDouble(13));
					
					return distayacut;

				}

			});
			
			jdbcTemplate4.getDataSource().getConnection().close();
			return distayacutList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getDistprojAyacutInfo method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	
	
	@Override
	public List<ComponentAyacut> getConstAyacutSum(Integer districtId) throws ComponentUserException {

		String sql = SELECT_CONST_AYACUT;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new Object []{districtId,districtId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();

					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setProjectId(rs.getInt(3));
					constsum.setAyacutCreated(rs.getDouble(4));
					constsum.setStableAyacut(rs.getDouble(5));
					constsum.setRemarks(rs.getString(6));
					
					constsum.setProjectName(rs.getString(7));
					constsum.setUnitName(rs.getString(8));
					constsum.setPackageName(rs.getString(9));
					constsum.setDistrictName(rs.getString(10));
					constsum.setMandalName(rs.getString(11));
					constsum.setIrriagtedAyacut(rs.getDouble(12));
					constsum.setContemplatedAyacut(rs.getDouble(13));
				
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getConstAyacutSum method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	@Override
	public List<ComponentAyacut> getConstTotalSum() throws ComponentUserException {

		String sql = SELECT_CONST_TOTAL;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql,  new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setAyacutCreated(rs.getDouble(3));
					constsum.setStableAyacut(rs.getDouble(4));
					constsum.setRemarks(rs.getString(5));
					constsum.setProjectName(rs.getString(6));
					constsum.setUnitName(rs.getString(7));
					
					constsum.setPackageName(rs.getString(8));
					constsum.setDistrictName(rs.getString(9));
					constsum.setIrriagtedAyacut(rs.getDouble(10));
					constsum.setContemplatedAyacut(rs.getDouble(11));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getConstAyacutSum method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}

	
	@Override
	public List<ComponentAyacut> getprojTotalbyconstSum(Integer constId) throws ComponentUserException {

		String sql = SELECT_PROJ_TOTAL_CONST;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new Object []{constId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setProjectId(rs.getInt(3));
					constsum.setAyacutCreated(rs.getDouble(4));
					constsum.setStableAyacut(rs.getDouble(5));
					constsum.setRemarks(rs.getString(6));
					constsum.setProjectName(rs.getString(7));
					constsum.setUnitName(rs.getString(8));
					
					constsum.setPackageName(rs.getString(9));
					constsum.setDistrictName(rs.getString(10));
					constsum.setIrriagtedAyacut(rs.getDouble(11));
					constsum.setContemplatedAyacut(rs.getDouble(12));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getprojTotalbyconstSum method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	@Override
	public List<ComponentAyacut> getprojTotalbydistconstSum(Integer constId) throws ComponentUserException {

		String sql = SELECT_PROJ_TOTAL_DIST_CONST;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new Object []{constId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setProjectId(rs.getInt(3));
					constsum.setDistrictId(rs.getInt(4));
					constsum.setAyacutCreated(rs.getDouble(5));
					constsum.setStableAyacut(rs.getDouble(6));
					constsum.setRemarks(rs.getString(7));
					constsum.setProjectName(rs.getString(8));
					constsum.setUnitName(rs.getString(9));
					
					constsum.setPackageName(rs.getString(10));
					constsum.setDistrictName(rs.getString(11));
					constsum.setIrriagtedAyacut(rs.getDouble(12));
					constsum.setContemplatedAyacut(rs.getDouble(13));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getprojTotalbydistconstSum  method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	@Override
	public List<ComponentAyacut> getDistTotalbyconstSum(Integer constId) throws ComponentUserException {

		String sql = SELECT_TOTAL_DIST_CONST;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new Object []{constId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					
					constsum.setDistrictId(rs.getInt(3));
					constsum.setAyacutCreated(rs.getDouble(4));
					constsum.setStableAyacut(rs.getDouble(5));
					constsum.setRemarks(rs.getString(6));
					constsum.setProjectName(rs.getString(7));
					constsum.setUnitName(rs.getString(8));
					
					constsum.setPackageName(rs.getString(9));
					constsum.setDistrictName(rs.getString(10));
					constsum.setMandalName(rs.getString(11));
					constsum.setIrriagtedAyacut(rs.getDouble(12));
					constsum.setContemplatedAyacut(rs.getDouble(13));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getDistTotalbyconstSum  method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	@Override
	public List<ComponentAyacut> getMandalTotalbyconstSum(Integer districtId, Integer constId) throws ComponentUserException {

		String sql = SELECT_TOTAL_MANDAL_CONST;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new Object []{districtId,constId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					
					constsum.setDistrictId(rs.getInt(3));
					constsum.setMandalId(rs.getInt(4));
					constsum.setAyacutCreated(rs.getDouble(5));
					constsum.setStableAyacut(rs.getDouble(6));
					constsum.setRemarks(rs.getString(7));
					constsum.setProjectName(rs.getString(8));
					constsum.setUnitName(rs.getString(9));
					
					constsum.setPackageName(rs.getString(10));
					constsum.setDistrictName(rs.getString(11));
					constsum.setMandalName(rs.getString(12));
					constsum.setIrriagtedAyacut(rs.getDouble(13));
					constsum.setContemplatedAyacut(rs.getDouble(14));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getMandalTotalbyconstSum  method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	/*@Override
	public List<ComponentAyacut> getprojTotalAllconstSum() throws ComponentUserException {

		String sql = SELECT_PROJ_TOTAL_ALL_CONST;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setProjectId(rs.getInt(3));
					constsum.setPresentAyacutCreated(rs.getDouble(4));
					constsum.setStableAyacut(rs.getDouble(5));
					constsum.setRemarks(rs.getString(6));
					constsum.setProjectName(rs.getString(7));
					constsum.setUnitName(rs.getString(8));
					
					constsum.setPackageName(rs.getString(9));
					constsum.setDistrictName(rs.getString(10));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getprojTotalbyconstSum method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	*/
	
	@Override
	public List<ComponentAyacut> getprojTotal() throws ComponentUserException {

		String sql = SELECT_PROJ_TOTAL;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setProjectId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setAyacutCreated(rs.getDouble(3));
					constsum.setStableAyacut(rs.getDouble(4));
					constsum.setRemarks(rs.getString(5));
					constsum.setProjectName(rs.getString(6));
					constsum.setUnitName(rs.getString(7));
					
					constsum.setPackageName(rs.getString(8));
					constsum.setDistrictName(rs.getString(9));
					constsum.setMandalName(rs.getString(10));
					constsum.setContemplatedAyacut(rs.getDouble(11));
					constsum.setIrriagtedAyacut(rs.getDouble(12));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getprojTotal method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	@Override
	public List<ComponentAyacut> getProjPackManTotal() throws ComponentUserException {

		String sql = SELECT_PROJECT_PACKAGE_MAN_TOTAL;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setProjectId(rs.getInt(1));
					constsum.setPackageId(rs.getInt(2));
					constsum.setConstName(rs.getString(3));
					constsum.setAyacutCreated(rs.getDouble(4));
					constsum.setStableAyacut(rs.getDouble(5));
					constsum.setRemarks(rs.getString(6));
					constsum.setProjectName(rs.getString(7));
					constsum.setUnitName(rs.getString(8));
					
					constsum.setPackageName(rs.getString(9));
					constsum.setDistrictName(rs.getString(10));
					constsum.setMandalName(rs.getString(11));
					constsum.setContemplatedAyacut(rs.getDouble(12));
					constsum.setIrriagtedAyacut(rs.getDouble(13));
					constsum.setMandalId(rs.getInt(14));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getprojTotal method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	
	@Override
	public List<ComponentAyacut> getDistrictManprojTotal() throws ComponentUserException {

		String sql = SELECT_DISTRICT_MAN_PROJECT_TOTAL;

		final Double preunit = 0.0;
		
		System.out.println("sql"+sql);
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setDistrictId(rs.getInt(1));
					constsum.setDistrictName(rs.getString(2));
					constsum.setMandalId(rs.getInt(3));
					constsum.setMandalName(rs.getString(4));
					constsum.setProjectId(rs.getInt(5));
					constsum.setProjectName(rs.getString(6));
					constsum.setProjectTypeId(rs.getInt(7));
					constsum.setProjectType(rs.getString(8));
					constsum.setContemplatedAyacut(rs.getDouble(9));
					constsum.setAyacutCreated(rs.getDouble(10));
					constsum.setStableAyacut(rs.getDouble(11));
					constsum.setIrriagtedAyacut(rs.getDouble(12));
					constsum.setUnitName(rs.getString(13));
					constsum.setRemarks(rs.getString(14));					
					constsum.setConstName(rs.getString(15));
					
				
				
					
				
					
					
					
					
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getprojTotal method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	
	
	
	@Override
	public List<ComponentAyacut> getProjManTotal() throws ComponentUserException {

		String sql = SELECT_PROJECT_MAN_TOTAL;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setProjectId(rs.getInt(1));
					
					constsum.setConstName(rs.getString(2));
					constsum.setAyacutCreated(rs.getDouble(3));
					constsum.setStableAyacut(rs.getDouble(4));
					constsum.setRemarks(rs.getString(5));
					constsum.setProjectName(rs.getString(6));
					constsum.setUnitName(rs.getString(7));
					
				
					constsum.setDistrictName(rs.getString(8));
					constsum.setMandalName(rs.getString(9));
					constsum.setContemplatedAyacut(rs.getDouble(10));
					constsum.setIrriagtedAyacut(rs.getDouble(11));
					constsum.setMandalId(rs.getInt(12));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getprojTotal method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	
	@Override
	public List<ComponentAyacut> getProjManVillageTotal() throws ComponentUserException {

		String sql = SELECT_PROJECT_MAN_VILLAGE_TOTAL;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setProjectId(rs.getInt(1));
					
					constsum.setConstName(rs.getString(2));
					constsum.setAyacutCreated(rs.getDouble(3));
					constsum.setStableAyacut(rs.getDouble(4));
					constsum.setRemarks(rs.getString(5));
					constsum.setProjectName(rs.getString(6));
					constsum.setUnitName(rs.getString(7));
					
				
					constsum.setDistrictName(rs.getString(8));
					constsum.setMandalName(rs.getString(9));
					constsum.setContemplatedAyacut(rs.getDouble(10));
					constsum.setIrriagtedAyacut(rs.getDouble(11));
					constsum.setDistrictId(rs.getInt(12));
					constsum.setMandalId(rs.getInt(13));
					constsum.setVillageId(rs.getInt(14));
					constsum.setVillageName(rs.getString(15));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getprojTotal method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	@Override
	public List<ComponentAyacut> getConstDistManVillage(Integer districtId) throws ComponentUserException {

		String sql = SELECT_CONST_DIST_MAN_VILL;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new Object []{districtId,districtId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setDistrictId(rs.getInt(3));
					constsum.setMandalId(rs.getInt(4));
					constsum.setVillageId(rs.getInt(5));
					constsum.setAyacutCreated(rs.getDouble(6));
					constsum.setStableAyacut(rs.getDouble(7));
					constsum.setRemarks(rs.getString(8));
					constsum.setProjectName(rs.getString(9));
					constsum.setUnitName(rs.getString(10));
					
					constsum.setPackageName(rs.getString(11));
					constsum.setDistrictName(rs.getString(12));
					constsum.setMandalName(rs.getString(13));
					constsum.setVillageName(rs.getString(14));
					constsum.setIrriagtedAyacut(rs.getDouble(15));
					constsum.setContemplatedAyacut(rs.getDouble(16));
					
				
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getConstDistManVillage method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	@Override
	public List<ComponentAyacut> getConstDistManVillageByID(Integer constId,Integer districtId,Integer mandalId) throws ComponentUserException {

		String sql = SELECT_CONST_DIST_MAN_VILL_BYID;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql,new Object []{constId,districtId,mandalId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setDistrictId(rs.getInt(3));
					constsum.setMandalId(rs.getInt(4));
					constsum.setVillageId(rs.getInt(5));
					constsum.setAyacutCreated(rs.getDouble(6));
					constsum.setStableAyacut(rs.getDouble(7));
					constsum.setRemarks(rs.getString(8));
					constsum.setProjectName(rs.getString(9));
					constsum.setUnitName(rs.getString(10));
					
					constsum.setPackageName(rs.getString(11));
					constsum.setDistrictName(rs.getString(12));
					constsum.setMandalName(rs.getString(13));
					constsum.setVillageName(rs.getString(14));
					constsum.setIrriagtedAyacut(rs.getDouble(15));
					constsum.setContemplatedAyacut(rs.getDouble(16));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getConstDistManVillage method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
		
		
		
		
		
	}
	
	
	@Override
	public List<ComponentAyacut> getVillageByConst(Integer constId) throws ComponentUserException {

		String sql = SELECT_VILLAGE_BYCONST;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql,new Object []{constId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setDistrictId(rs.getInt(3));
					constsum.setMandalId(rs.getInt(4));
					constsum.setVillageId(rs.getInt(5));
					constsum.setAyacutCreated(rs.getDouble(6));
					constsum.setStableAyacut(rs.getDouble(7));
					constsum.setRemarks(rs.getString(8));
					constsum.setProjectName(rs.getString(9));
					constsum.setUnitName(rs.getString(10));
					
					constsum.setPackageName(rs.getString(11));
					constsum.setDistrictName(rs.getString(12));
					constsum.setMandalName(rs.getString(13));
					constsum.setVillageName(rs.getString(14));
					constsum.setIrriagtedAyacut(rs.getDouble(15));
					constsum.setContemplatedAyacut(rs.getDouble(16));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getVillageByConst method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
		
		
		
		
		
	}
	
	@Override
	public List<ComponentAyacut> getMandalbyProj(Integer projectId) throws ComponentUserException {

		String sql = SELECT_MANDAL_BY_PROJ;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql,new Object []{projectId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setDistrictId(rs.getInt(3));
					constsum.setMandalId(rs.getInt(4));
					constsum.setUnitId(rs.getInt(5));
					constsum.setProjectId(rs.getInt(6));
					constsum.setAyacutCreated(rs.getDouble(7));
					constsum.setStableAyacut(rs.getDouble(8));
					constsum.setRemarks(rs.getString(9));
					constsum.setProjectName(rs.getString(10));
					constsum.setUnitName(rs.getString(11));
					
					constsum.setPackageName(rs.getString(12));
					constsum.setDistrictName(rs.getString(13));
					constsum.setMandalName(rs.getString(14));
					constsum.setIrriagtedAyacut(rs.getDouble(15));
					constsum.setContemplatedAyacut(rs.getDouble(16));
				
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getMandalbyProj method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
		
		
		
		
		
	}
	
	
	@Override
	public List<ComponentAyacut> getMandalbyUnit(Integer unitId) throws ComponentUserException {

		String sql = SELECT_MANDAL_BY_UNIT;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql,new Object []{unitId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setConstId(rs.getInt(1));
					constsum.setConstName(rs.getString(2));
					constsum.setDistrictId(rs.getInt(3));
					constsum.setMandalId(rs.getInt(4));
					constsum.setUnitId(rs.getInt(5));
					constsum.setProjectId(rs.getInt(6));
					constsum.setAyacutCreated(rs.getDouble(7));
					constsum.setStableAyacut(rs.getDouble(8));
					constsum.setRemarks(rs.getString(9));
					constsum.setProjectName(rs.getString(10));
					constsum.setUnitName(rs.getString(11));
					
					constsum.setPackageName(rs.getString(12));
					constsum.setDistrictName(rs.getString(13));
					constsum.setMandalName(rs.getString(14));
					constsum.setIrriagtedAyacut(rs.getDouble(15));
					constsum.setContemplatedAyacut(rs.getDouble(16));
				
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getMandalbyUnit method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
		
		
		
		
		
	}
	
	@Override
	public List<District> getOldDistricts() throws ComponentUserException {

		String sql = SELECT_OLD_DISTRICT;
		try {
			List<District> distList = jdbcTemplate4.query(sql, new RowMapper<District>() {
				public District mapRow(ResultSet rs, int rowNum) throws SQLException {
					District dist = new District();
					dist.setDistrictId(rs.getInt(1));
					dist.setDistrictName(rs.getString(2));

					return dist;

				}

			});
			return distList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getParentComponent method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	@Override
	public List<ComponentAyacut> getReportProjSeasonCap(ComponentAyacut compObj) throws ComponentUserException {

		String sql = REPORT_PROJ_SEASON_CAP_ALL;

		final Double preunit = 0.0;
		
		  //System.out.println("sql"+sql);
		try {
			List<ComponentAyacut> projCapList = jdbcTemplate4.query(sql,new Object []{compObj.getKhrifactplanYear(),compObj.getRabiactplanYear()  }, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut projCap= new ComponentAyacut();
					
					
					projCap.setPreWaterLevel(rs.getDouble(1));
					projCap.setPreWaterCap(rs.getDouble(2));
					projCap.setNetAvailablewaterKhrif(rs.getDouble(3));
					projCap.setWaterRequired(rs.getDouble(4));
					projCap.setProjIdKh(rs.getInt(5));
					projCap.setObsdatekh(rs.getString(6));
					projCap.setNoOfWettings(rs.getInt(7));
					projCap.setProjseasonCapIdKh(rs.getInt(8));
					projCap.setKhrifactplanYear(rs.getString(9));
					projCap.setProposedAyacutKharifID(rs.getDouble(10));
					projCap.setProposedAyacutKharifWet(rs.getDouble(11));
					projCap.setKhtotal(rs.getDouble(12));
					projCap.setWaterUtil(rs.getDouble(13));
					projCap.setNetAvailablewaterrabi(rs.getDouble(14));
					projCap.setProjIdRabi(rs.getInt(15));
					projCap.setObsdaterabi(rs.getString(16));
					projCap.setRabiactplanYear(rs.getString(17));
					projCap.setProjseasonCapIdRabi(rs.getInt(18));
					projCap.setIrrigatedAyacutRabiID(rs.getDouble(19));
					projCap.setIrrigatedAyacutRabiWet(rs.getDouble(20));
					projCap.setRabitotal(rs.getDouble(21));
					projCap.setCropNames(rs.getString(22));
					projCap.setRemarks(rs.getString(23));
					projCap.setProjectName(rs.getString(24));
					projCap.setContemplatedAyacut(rs.getDouble(25));
					projCap.setAyacutCreated(rs.getDouble(26));
					
					
				
					
					return projCap;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return projCapList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getReportProjSeasonCap method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
		
		
		
		
		
	}
	
	@Override
	public List<ComponentAyacut> getAyacutJurisdiction() throws ComponentUserException {

		String sql = SELECT_AYACUT_JURISDICTION;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setUnitId(rs.getInt(1));
					constsum.setCircleId(rs.getInt(2));
					constsum.setConstName(rs.getString(3));
					constsum.setAyacutCreated(rs.getDouble(4));
					constsum.setStableAyacut(rs.getDouble(5));
					constsum.setRemarks(rs.getString(6));
					constsum.setProjectName(rs.getString(7));
					constsum.setUnitName(rs.getString(8));
					
					constsum.setPackageName(rs.getString(9));
					constsum.setDistrictName(rs.getString(10));
					constsum.setMandalName(rs.getString(11));
					constsum.setContemplatedAyacut(rs.getDouble(12));
					constsum.setIrriagtedAyacut(rs.getDouble(13));
					
					constsum.setDivisionId(rs.getInt(14));
					constsum.setCircleName(rs.getString(15));
					constsum.setDivisionName(rs.getString(16));
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getAyacutJurisdiction method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}

	
	
	@Override
	public List<ComponentAyacut> getAyacutdivisionMandal() throws ComponentUserException {

		String sql = SELECT_AYACUT_DIVISION_MANDAL;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setUnitId(rs.getInt(1));
					constsum.setCircleId(rs.getInt(2));
					constsum.setConstName(rs.getString(3));
					constsum.setAyacutCreated(rs.getDouble(4));
					constsum.setStableAyacut(rs.getDouble(5));
					constsum.setRemarks(rs.getString(6));
					constsum.setProjectName(rs.getString(7));
					constsum.setUnitName(rs.getString(8));
					
					constsum.setPackageName(rs.getString(9));
					constsum.setDistrictName(rs.getString(10));
					constsum.setMandalName(rs.getString(11));
					constsum.setContemplatedAyacut(rs.getDouble(12));
					constsum.setIrriagtedAyacut(rs.getDouble(13));
					
					constsum.setDivisionId(rs.getInt(14));
					constsum.setCircleName(rs.getString(15));
					constsum.setDivisionName(rs.getString(16));
					constsum.setDistrictId(rs.getInt(17));
					constsum.setMandalId(rs.getInt(18));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getAyacutJurisdiction method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	@Override
	public List<ComponentAyacut> gettestdataforpms() throws ComponentUserException {

		String sql = SELECT_PROJECT_AYACUT_PMS;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate12.query(sql, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setProjAyacutId(rs.getInt(1));
					constsum.setProjectId(rs.getInt(2));
					constsum.setAyacutCreated(rs.getDouble(3));
					constsum.setStableAyacut(rs.getDouble(3));
					
					
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl gettestdataforpms method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
	
	
	@Override
	public List<ComponentAyacut> getDistManProjAyacutSum(Integer districtId) throws ComponentUserException {

		String sql = SELECT_DIST_MAN_PROJ;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new Object []{districtId,districtId,districtId}, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();

					constsum.setDistrictId(rs.getInt(1));
					constsum.setDistrictName(rs.getString(2));
					constsum.setMandalId(rs.getInt(3));
					constsum.setMandalName(rs.getString(4));
					constsum.setProjectId(rs.getInt(5));
					constsum.setProjectName(rs.getString(6));
					constsum.setProjectTypeId(rs.getInt(7));
					constsum.setProjectType(rs.getString(8));
					constsum.setContemplatedAyacut(rs.getDouble(9));
					constsum.setAyacutCreated(rs.getDouble(10));
					constsum.setStableAyacut(rs.getDouble(11));
					constsum.setIrriagtedAyacut(rs.getDouble(12));
					constsum.setUnitName(rs.getString(13));
					constsum.setRemarks(rs.getString(14));					
					constsum.setConstName(rs.getString(15));
				
					
					
					
					return constsum;

				}

			});
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getConstAyacutSum method error due to " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		// System.out.println("daoimpl canal list " + canalList);
	}
	
}
