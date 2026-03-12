package in.ts.icad.leagal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.pdf.PRAcroForm;

import in.ts.icad.leagal.dao.InventoryAdminDAO;
import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.model.Canal;
import in.ts.icad.leagal.model.CaseTypeOrder;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.Constituency;
import in.ts.icad.leagal.model.DamInspectDocs;
import in.ts.icad.leagal.model.Designation;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.EmpApprove;
import in.ts.icad.leagal.model.Employee;
import in.ts.icad.leagal.model.EmployeeDiversion;
import in.ts.icad.leagal.model.Habitations;
import in.ts.icad.leagal.model.Mandal;
import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankInspect;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.MitankChecks;
import in.ts.icad.leagal.model.MitankComps;
import in.ts.icad.leagal.model.MstOutputWithFlag;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.PumpCommonData;
import in.ts.icad.leagal.model.PumpMaintainActivities;
import in.ts.icad.leagal.model.PumpOperationInstructions;
import in.ts.icad.leagal.model.PumpOperationType;
import in.ts.icad.leagal.model.PumpPumpsData;
import in.ts.icad.leagal.model.PumpStations;
import in.ts.icad.leagal.model.Pumpmotor;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.ReservoirAyacut;
import in.ts.icad.leagal.model.ReservoirGates;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirMaintenanceCategory;
import in.ts.icad.leagal.model.ReservoirMaintenanceChecks;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.ReservoirUnitData;
import in.ts.icad.leagal.model.ScheduleDuty;
import in.ts.icad.leagal.model.Sectiondata;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.TankFeedDetails;
import in.ts.icad.leagal.model.Tanks;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.model.Village;
import in.ts.icad.leagal.util.DateUtil;

@Repository
public class InventoryAdminDAOImpl implements InventoryAdminDAO {
	
	private JdbcTemplate jdbcTemplate7;
	private JdbcTemplate jdbcTemplate8;
	private JdbcTemplate jdbcTemplate9;
	
	private JdbcTemplate jdbcTemplate10;
	
	private JdbcTemplate jdbcTemplate11;
	
	private JdbcTemplate jdbcTemplate3;

	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate hrmsjdbcTemplate;
	
	private JdbcTemplate irrInvTemplate;
	
	
	private JdbcTemplate mkTemplate;
	
	private JdbcTemplate pmsstageTemplate;
	
	
	
	
	
	
	

	@Resource(name = "dataSource7")
	public void setDataSource7(DataSource dataSource7) {
		this.jdbcTemplate7 = new JdbcTemplate(dataSource7);
	}
	
	@Resource(name = "dataSource11")
	public void setDataSource11(DataSource dataSource11) {
		this.jdbcTemplate11 = new JdbcTemplate(dataSource11);
	}
	
	@Resource(name = "dataSource8")
	public void setDataSource8(DataSource dataSource8) {
		this.jdbcTemplate8 = new JdbcTemplate(dataSource8);
	}
	
	@Resource(name = "dataSource9")
	public void setDataSource9(DataSource dataSource9) {
		this.jdbcTemplate9 = new JdbcTemplate(dataSource9);
	}
	
	@Resource(name = "dataSource10")
	public void setDataSource10(DataSource dataSource10) {
		this.jdbcTemplate10 = new JdbcTemplate(dataSource10);
	}
	
	@Resource(name = "dataSource")
	public void setDataSource4(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Resource(name = "dataSource1")
	public void setDataSource1(DataSource dataSource1) {
		this.hrmsjdbcTemplate = new JdbcTemplate(dataSource1);
	}
	@Resource(name = "dataSource3")
	public void setDataSource3(DataSource dataSource3) {
		this.jdbcTemplate3 = new JdbcTemplate(dataSource3);
	}
	
	@Resource(name = "dataSource13")
	public void setDataSource13(DataSource dataSource13) {
		this.mkTemplate = new JdbcTemplate(dataSource13);
	}
	
	@Resource(name = "dataSource14")
	public void setDataSource14(DataSource dataSource14) {
		this.irrInvTemplate = new JdbcTemplate(dataSource14);
	}
	
	@Resource(name = "dataSource15")
	public void setDataSource15(DataSource dataSource15) {
		this.pmsstageTemplate = new JdbcTemplate(dataSource15);
	}
	
	



	
	@Value("${INSERT_RESERVOIRS}")
	private String INSERT_RESERVOIRS;
	
	@Value("${SELECT_RES}")
	private String SELECT_RES;
	
	@Value("${SELECT_RES_BYID}")
	private String SELECT_RES_BYID;
	
	@Value("${INSERT_RES_UNIT_MAP}")
	private String INSERT_RES_UNIT_MAP;
	
	@Value("${SELECT_RES_UNIT_MAP}")
	private String SELECT_RES_UNIT_MAP;
	
	@Value("${UPDATE_RES_INFO_BY_CODE}")
	private String UPDATE_RES_INFO_BY_CODE;
	
	@Value("${DELETE_RES_INFO_BY_CODE}")
	private String DELETE_RES_INFO_BY_CODE;
	
	@Value("${SELECT_RES_UNIT_MAP_BYMAPID}")
	private String SELECT_RES_UNIT_MAP_BYMAPID;
	
	@Value("${UPDATE_UNIT_MAP_BYMAPID}")
	private String UPDATE_UNIT_MAP_BYMAPID;
	
	@Value("${DELETE_RES_UNIT_MAP_BY_ID}")
	private String DELETE_RES_UNIT_MAP_BY_ID;
	
	@Value("${SELECT_RES_UNIT_MAP_BY_RESCODE}")
	private String SELECT_RES_UNIT_MAP_BY_RESCODE;
	
	
	@Value("${INSERT_RES_REGULATOR}")
	private String INSERT_RES_REGULATOR;
	
	@Value("${INSERT_INV_AYACUT_BY_RES_REG}")
	private String INSERT_INV_AYACUT_BY_RES_REG;
	
	@Value("${SELECT_RES_REG}")
	private String SELECT_RES_REG;
	
	@Value("${INSERT_RES_GATES}")
	private String INSERT_RES_GATES;
	
	@Value("${SELECT_RES_REG_BYCODE}")
	private String SELECT_RES_REG_BYCODE;
	
	@Value("${SELECT_RES_GATES_BYRES}")
	private String SELECT_RES_GATES_BYRES;
	
	@Value("${SELECT_RES_AYACUT_BY_RES}")
	private String SELECT_RES_AYACUT_BY_RES;
	
	@Value("${SELECT_RES_AYACUT_BY_ID}")
	private String SELECT_RES_AYACUT_BY_ID;
	
	@Value("${SELECT_RES_GATE_BY_ID}")
	private String SELECT_RES_GATE_BY_ID;
	
	@Value("${SELECT_RES_REG_BY_REGCODE}")
	private String SELECT_RES_REG_BY_REGCODE;
	
	@Value("${DELETE_RES_REG}")
	private String DELETE_RES_REG;
	
	@Value("${UPDATE_RES_GATE}")
	private String UPDATE_RES_GATE;
	
	@Value("${DELETE_RES_GATE}")
	private String DELETE_RES_GATE;
	
	@Value("${UPDATE_RES_AYACUT}")
	private String UPDATE_RES_AYACUT;
	
	@Value("${DELETE_RES_AYACUT}")
	private String DELETE_RES_AYACUT;
	
	
	@Value("${SELECT_PUMP_DATA}")
	private String SELECT_PUMP_DATA;
	
	@Value("${SELECT_COMMOM_DATA}")
	private String SELECT_COMMOM_DATA;
	
	
	@Value("${SELECT_PUMP_MAINTAIN_ACTIVITIES}")
	private String SELECT_PUMP_MAINTAIN_ACTIVITIES;
	
	
	
	@Value("${SELECT_MI_COMPS}")
	private String SELECT_MI_COMPS;
	
	
	@Value("${SELECT_MI_CHECKS}")
	private String SELECT_MI_CHECKS;
	
	@Value("${SELECT_PUMP_OPERATION_TYPES}")
	private String SELECT_PUMP_OPERATION_TYPES;
	
	@Value("${SELECT_PUMP_OPER_INSTRUCTIONS}")
	private String SELECT_PUMP_OPER_INSTRUCTIONS;
	
	@Value("${SELECT_RES_SCHEDULE_DUTIES}")
	private String SELECT_RES_SCHEDULE_DUTIES;
	
	@Value("${INSERT_MI_INSPECT}")
	private String INSERT_MI_INSPECT;
	
	
	@Value("${SELECT_TANKS_BY_VILLAGE}")
	private String SELECT_TANKS_BY_VILLAGE;
	
	
	@Value("${SELECT_RES_CHECKS_ANN1}")
	private String SELECT_RES_CHECKS_ANN1;
	
	@Value("${SELECT_RES_CAT_ANN2}")
	private String SELECT_RES_CAT_ANN2;
	
	@Value("${INSERT_RES_INSPECT_ANN1}")
	private String INSERT_RES_INSPECT_ANN1;
	
	@Value("${SELECT_INVOM_RESERVOIRS}")
	private String SELECT_INVOM_RESERVOIRS;
	
	@Value("${INSERT_RES_INSPECT_ANN1_APP}")
	private String INSERT_RES_INSPECT_ANN1_APP;
	
	
	@Value("${INSERT_RES_INSPECT_ANN2}")
	private String INSERT_RES_INSPECT_ANN2;
	
	
	@Value("${INSERT_RES_DAM_DUTY_INSPECT}")
	private String INSERT_RES_DAM_DUTY_INSPECT;
	
	@Value("${SELECT_BASIN_DATA}")
	private String SELECT_BASIN_DATA;
	
	@Value("${SELECT_PUMP_LINKS}")
	private String SELECT_PUMP_LINKS;
	
	@Value("${SELECT_PUMP_STATIONS}")
	private String SELECT_PUMP_STATIONS;
	
	
	@Value("${INSERT_PUMP_MAIN_ACTIVITY_INSPECT}")
	private String INSERT_PUMP_MAIN_ACTIVITY_INSPECT;
	
	@Value("${INSERT_INVOM_MI_TANK_INSPECT_MST1}")
	private String INSERT_INVOM_MI_TANK_INSPECT_MST1;
	
	@Value("${GET_TANK_FREQ}")
	private String GET_TANK_FREQ;
	
	@Value("${INSERT_INVOM_MI_TANK_INSPECT_MST2}")
	private String INSERT_INVOM_MI_TANK_INSPECT_MST2;
	
	
	@Value("${INSERT_INVOM_MI_TANK_INSPECT_REPAIRS}")
	private String INSERT_INVOM_MI_TANK_INSPECT_REPAIRS;
	
	@Value("${INSERT_INVOM_MI_TANK_INSPECT_IN_OUT_FLOW}")
	private String INSERT_INVOM_MI_TANK_INSPECT_IN_OUT_FLOW;
	
	@Value("${INSERT_INVOM_MI_TANK_INSPECT_CAPACITY}")
	private String INSERT_INVOM_MI_TANK_INSPECT_CAPACITY;
	
	@Value("${GET_MIINSPECT_MST1_ID}")
	private String GET_MIINSPECT_MST1_ID;
	
	@Value("${GET_MIMST2ID_BY_MST1ID}")
	private String GET_MIMST2ID_BY_MST1ID;
	
	@Value("${GET_MIMST2ID_BY_YEAR_FREQ}")
	private String GET_MIMST2ID_BY_YEAR_FREQ;
	
	@Value("${GET_MI_REPAIR}")
	private String GET_MI_REPAIR;
	
	@Value("${SELECT_MI_INOUT}")
	private String SELECT_MI_INOUT;
	
	@Value("${GET_MI_CAPACITY}")
	private String GET_MI_CAPACITY;
	
	
	@Value("${SELECT_CE_ENC}")
	private String SELECT_CE_ENC;
	
	@Value("${SELECT_SE_IN_UNIT}")
	private String SELECT_SE_IN_UNIT;
	
	@Value("${SELECT_SE_IN_CIRCLE}")
	private String SELECT_SE_IN_CIRCLE;
	
	@Value("${SELECT_EE_IN_UNIT}")
	private String SELECT_EE_IN_UNIT;
	
	@Value("${SELECT_EE_IN_CIRCLE}")
	private String SELECT_EE_IN_CIRCLE;
	
	@Value("${SELECT_EE_IN_DIV}")
	private String SELECT_EE_IN_DIV;
	
	@Value("${SELECT_DEE_IN_UNIT}")
	private String SELECT_DEE_IN_UNIT;
	
	@Value("${SELECT_DEE_IN_CIRCLE}")
	private String SELECT_DEE_IN_CIRCLE;
	
	@Value("${SELECT_DEE_IN_DIV}")
	private String SELECT_DEE_IN_DIV;
	
	@Value("${SELECT_DEE_IN_SUBDIV}")
	private String SELECT_DEE_IN_SUBDIV;
	
	
	@Value("${INSERT_RES_ANN2_MST1}")
	private String INSERT_RES_ANN2_MST1;
	
	@Value("${GET_RES_ANN2_FREQ}")
	private String GET_RES_ANN2_FREQ;
	
	@Value("${GET_RES_ANN2_MST1_ID}")
	private String GET_RES_ANN2_MST1_ID;
	
	@Value("${INSERT_RES_ANN2_MST2}")
	private String INSERT_RES_ANN2_MST2;
	
	@Value("${GET_RESANN2MST2_BY_MST1ID}")
	private String GET_RESANN2MST2_BY_MST1ID;
	
	
	@Value("${INSERT_RES_HEALTH}")
	private String INSERT_RES_HEALTH;
	
	
	@Value("${INSERT_RES_RECOMMEND}")
	private String INSERT_RES_RECOMMEND;
	
	@Value("${INSERT_RES_ACTION_TAKEN}")
	private String INSERT_RES_ACTION_TAKEN;
	
	
	@Value("${GET_RES_ANN2_MST2_INSPECTDATA}")
	private String GET_RES_ANN2_MST2_INSPECTDATA;
	
	
	@Value("${SELECT_RES_HEALTH}")
	private String SELECT_RES_HEALTH;
	
	
	@Value("${SELECT_RES_RECOMMEND}")
	private String SELECT_RES_RECOMMEND;
	

	@Value("${SELECT_RES_ACTION_TAKEN}")
	private String SELECT_RES_ACTION_TAKEN;
	
	@Value("${SELECT_LATEST_RECOMMENDATION}")
	private String SELECT_LATEST_RECOMMENDATION;
	
	@Value("${SELECT_LATEST_HEALTH}")
	private String SELECT_LATEST_HEALTH;
	
	@Value("${INSERT_RES_ANN1_MST1}")
	private String INSERT_RES_ANN1_MST1;
	
	@Value("${INSERT_RES_ANN1_MST2}")
	private String INSERT_RES_ANN1_MST2;
	
	@Value("${GET_RES_ANN1_FREQ}")
	private String GET_RES_ANN1_FREQ;
	
	@Value("${GET_RES_ANN1_MST1_ID}")
	private String GET_RES_ANN1_MST1_ID;
	
	
	@Value("${GET_RESANN1MST2_BY_MST1ID}")
	private String GET_RESANN1MST2_BY_MST1ID;
	
	@Value("${GET_RES_ANN1_MST2_INSPECTDATA}")
	private String GET_RES_ANN1_MST2_INSPECTDATA;
	
	@Value("${INSERT_TANK_FEED_DETAIL}")
	private String INSERT_TANK_FEED_DETAIL;
	
	@Value("${GET_TANK_FEED_DATA}")
	private String GET_TANK_FEED_DATA;
	
	@Value("${INSERT_TANK_FEED_REMARKS}")
	private String INSERT_TANK_FEED_REMARKS;
	
	@Value("${GET_TANK_FEED_REMARKS}")
	private String GET_TANK_FEED_REMARKS;
	
	
	
	@Value("${GET_TANK_CAPACITY_REMARKS}")
	private String GET_TANK_CAPACITY_REMARKS;
	
	/*@Value("${GET_TANK_INOUTFLOW_REMARKS}")
	private String GET_TANK_INOUTFLOW_REMARKS;
	*/
	@Value("${GET_TANK_REPAIR_REMARKS}")
	private String GET_TANK_REPAIR_REMARKS;
	
	@Value("${INSERT_TANK_REPAIR_REMARKS}")
	private String INSERT_TANK_REPAIR_REMARKS;
	
	@Value("${INSERT_TANK_INOUTFLOW_REMARKS}")
	private String INSERT_TANK_INOUTFLOW_REMARKS;
	
	@Value("${INSERT_TANK_CPACITY_REMARKS}")
	private String INSERT_TANK_CPACITY_REMARKS;
	
	@Value("${GET_TANK_MST1_REMARKS}")
	private String GET_TANK_MST1_REMARKS;
	
	@Value("${INSERT_TANK_MST1_REMARKS}")
	private String INSERT_TANK_MST1_REMARKS;
	
	@Value("${UPDATE_OLD_MST1_REMARKS}")
	private String UPDATE_OLD_MST1_REMARKS;
	
	@Value("${DELETE_MITANK_MST1}")
	private String DELETE_MITANK_MST1;
	
	@Value("${DELETE_MITANK_MST1_REMARKS}")
	private String DELETE_MITANK_MST1_REMARKS;
	
	@Value("${DELETE_MITANK_MST2}")
	private String DELETE_MITANK_MST2;
	
	@Value("${DELETE_MITANK_FEED_DETAILS}")
	private String DELETE_MITANK_FEED_DETAILS;
	
	@Value("${DELETE_MITANK_FEED_REMARKS}")
	private String DELETE_MITANK_FEED_REMARKS;
	
	@Value("${DELETE_MITANK_CAPACITY}")
	private String DELETE_MITANK_CAPACITY;
	
	@Value("${DELETE_MITANK_CAPACITY_REMARKS}")
	private String DELETE_MITANK_CAPACITY_REMARKS;
	
	@Value("${DELETE_MITANK_INOUTFLOW}")
	private String DELETE_MITANK_INOUTFLOW;
	
	/*@Value("${DELETE_MITANK_INOUTFLOW_REMARKS}")
	private String DELETE_MITANK_INOUTFLOW_REMARKS;*/
	
	@Value("${DELETE_MITANK_REPAIRS}")
	private String DELETE_MITANK_REPAIRS;
	
	@Value("${DELETE_MITANK_REPAIRS_REMARKS}")
	private String DELETE_MITANK_REPAIRS_REMARKS;
	
	@Value("${UPDATE_MITANK_MST2}")
	private String UPDATE_MITANK_MST2;
	
	@Value("${EDIT_GET_MITANK_MST2}")
	private String EDIT_GET_MITANK_MST2;
	
	/*@Value("${EDIT_GET_INOUTFLOW_TANK}")
	private String EDIT_GET_INOUTFLOW_TANK;*/
	
	/*@Value("${UPDATE_INOUTFLOW_TANK}")
	private String UPDATE_INOUTFLOW_TANK;*/
	
	@Value("${EDIT_GET_REPAIR_TANK}")
	private String EDIT_GET_REPAIR_TANK;
	
	
	@Value("${UPDATE_REPAIRS_TANK}")
	private String UPDATE_REPAIRS_TANK;
	
	
	
	@Value("${EDIT_GET_CAPACITY_TANK}")
	private String EDIT_GET_CAPACITY_TANK;
	
	@Value("${UPDATE_CAPACITY_TANK}")
	private String UPDATE_CAPACITY_TANK;
	
	
	@Value("${EDIT_GET_FEED_TANK}")
	private String EDIT_GET_FEED_TANK;
	
	
	@Value("${UPDATE_FEED_TANK}")
	private String UPDATE_FEED_TANK;
	
	
	@Value("${GET_TANK_REPAIR_FREQ}")
	private String GET_TANK_REPAIR_FREQ;
	
	
	@Value("${GET_TANK_REPAIR_ID}")
	private String GET_TANK_REPAIR_ID;
	
	@Value("${UPDATE_OLD_REPAIRS_REMARKS}")
	private String UPDATE_OLD_REPAIRS_REMARKS;
	
	/*@Value("${UPDATE_OLD_INOUTFLOW_REMARKS}")
	private String UPDATE_OLD_INOUTFLOW_REMARKS;*/
	
	@Value("${UPDATE_OLD_CAPACITY_REMARKS}")
	private String UPDATE_OLD_CAPACITY_REMARKS;
	
	@Value("${UPDATE_OLD_FEED_REMARKS}")
	private String UPDATE_OLD_FEED_REMARKS;
	
	@Value("${VIEW_MST1_REMARKS}")
	private String VIEW_MST1_REMARKS;
	
	
	@Value("${INSERT_TANK_SLUICE_WEIR}")
	private String INSERT_TANK_SLUICE_WEIR;
	
	
	@Value("${GET_WEIR_SLUICE_BY_TANKID}")
	private String GET_WEIR_SLUICE_BY_TANKID;
	
	
	@Value("${GET_TANK_CAPACITY_BY_TANK}")
	private String GET_TANK_CAPACITY_BY_TANK;
	
	@Value("${UPDATE_TANK_CRITICAL_STATUS}")
	private String UPDATE_TANK_CRITICAL_STATUS;
	
	
	@Value("${INSERT_REPAIRS_DESCRIPTION}")
	private String INSERT_REPAIRS_DESCRIPTION;
	
	
	@Value("${GET_TANK_REPAIRDESC_BY_TANKID}")
	private String GET_TANK_REPAIRDESC_BY_TANKID;
	
	
	@Value("${EDIT_TANK_REPAIRDESC}")
	private String EDIT_TANK_REPAIRDESC;
	
	
	@Value("${DELETE_TANK_REPAIRDESC}")
	private String DELETE_TANK_REPAIRDESC;
	
	@Value("${GET_REPAIRDESC_BY_DESCID}")
	private String GET_REPAIRDESC_BY_DESCID;
	
	
	@Value("${GET_CONST_BY_DISTID}")
	private String GET_CONST_BY_DISTID;
	
	@Value("${VIEW_REPAIRS_REMARKS}")
	private String VIEW_REPAIRS_REMARKS;
	
	@Value("${VIEW_CAPACITY_REMARKS}")
	private String VIEW_CAPACITY_REMARKS;
	
	/*@Value("${VIEW_INFLOW_REMARKS}")
	private String VIEW_INFLOW_REMARKS;*/
	
	
	///start of integration 
	
	@Value("${SOURCE_DISTRICTS}")
	private String SOURCE_DISTRICTS;
	
	@Value("${DELETE_STAGE_DISTRICTS}")
	private String DELETE_STAGE_DISTRICTS;
	
	@Value("${INSERT_STAGE_DISTRICTS}")
	private String INSERT_STAGE_DISTRICTS;
	
	
	@Value("${SOURCE_MANDALS}")
	private String SOURCE_MANDALS;
	
	@Value("${DELETE_STAGE_MANDALS}")
	private String DELETE_STAGE_MANDALS;
	
	@Value("${INSERT_STAGE_MANDALS}")
	private String INSERT_STAGE_MANDALS;
	
	
	@Value("${SOURCE_CONST}")
	private String SOURCE_CONST;
	
	@Value("${DELETE_STAGE_CONST}")
	private String DELETE_STAGE_CONST;
	
	@Value("${INSERT_STAGE_CONST}")
	private String INSERT_STAGE_CONST;
	
	
	@Value("${SOURCE_CONST_MANDALS}")
	private String SOURCE_CONST_MANDALS;
	
	@Value("${DELETE_STAGE_CONST_MANDALS}")
	private String DELETE_STAGE_CONST_MANDALS;
	
	@Value("${INSERT_STAGE_CONST_MANDALS}")
	private String INSERT_STAGE_CONST_MANDALS;
	
	
	@Value("${SOURCE_VILLAGES}")
	private String SOURCE_VILLAGES;
	
	@Value("${DELETE_STAGE_VILLAGES}")
	private String DELETE_STAGE_VILLAGES;
	
	@Value("${INSERT_STAGE_VILLAGES}")
	private String INSERT_STAGE_VILLAGES;
	
	
	@Value("${SOURCE_HABITATION}")
	private String SOURCE_HABITATION;
	
	@Value("${DELETE_STAGE_HABITATION}")
	private String DELETE_STAGE_HABITATION;
	
	@Value("${INSERT_STAGE_HABITATION}")
	private String INSERT_STAGE_HABITATION;
	
	@Value("${SOURCE_TANKS_INFO}")
	private String SOURCE_TANKS_INFO;
	
	@Value("${DELETE_STAGE_TANKS}")
	private String DELETE_STAGE_TANKS;
	
	@Value("${INSERT_STAGE_TANKS}")
	private String INSERT_STAGE_TANKS;
	
	///end of integration 
	
	@Value("${SELECT_HABITATION}")
	private String SELECT_HABITATION;
	
	@Value("${SECTION_TANK_MAPP}")
	private String SECTION_TANK_MAPP;
	
	
	
	
	
	@Value("${SOURCE_HRMS_EMP_MST}")
	private String SOURCE_HRMS_EMP_MST;
	
	@Value("${DELETE_STAGE_EMP_MST}")
	private String DELETE_STAGE_EMP_MST;
	
	@Value("${INSERT_STAGE_EMP_MST}")
	private String INSERT_STAGE_EMP_MST;
	
	
	@Value("${SOURCE_HRMS_ADDNL_CHARGE}")
	private String SOURCE_HRMS_ADDNL_CHARGE;
	
	@Value("${DELETE_STAGE_ADDNL_CHARGE}")
	private String DELETE_STAGE_ADDNL_CHARGE;
	
	@Value("${INSERT_STAGE_ADDNL_CHARGE}")
	private String INSERT_STAGE_ADDNL_CHARGE;
	
	
	@Value("${SOURCE_HRMS_UNIT_MASTER}")
	private String SOURCE_HRMS_UNIT_MASTER;
	
	@Value("${DELETE_STAGE_UNIT_MASTER}")
	private String DELETE_STAGE_UNIT_MASTER;
	
	@Value("${INSERT_STAGE_UNIT_MASTER}")
	private String INSERT_STAGE_UNIT_MASTER;	
	
	@Value("${SOURCE_HRMS_CIRCLE_MST}")
	private String SOURCE_HRMS_CIRCLE_MST;
	
	@Value("${DELETE_STAGE_CIRCLE_MST}")
	private String DELETE_STAGE_CIRCLE_MST;
	
	@Value("${INSERT_STAGE_CIRCLE_MST}")
	private String INSERT_STAGE_CIRCLE_MST;
	
	
	@Value("${SOURCE_HRMS_DIVISION_MST}")
	private String SOURCE_HRMS_DIVISION_MST;
	
	@Value("${DELETE_STAGE_DIVISION_MST}")
	private String DELETE_STAGE_DIVISION_MST;
	
	@Value("${INSERT_STAGE_DIVISION_MST}")
	private String INSERT_STAGE_DIVISION_MST;
	
	

	@Value("${SOURCE_HRMS_sub_division_mst}")
	private String SOURCE_HRMS_sub_division_mst;
	
	@Value("${DELETE_STAGE_sub_division_mst}")
	private String DELETE_STAGE_sub_division_mst;
	
	@Value("${INSERT_STAGE_sub_division_mst}")
	private String INSERT_STAGE_sub_division_mst;
	
	
	@Value("${SOURCE_HRMS_section_mst}")
	private String SOURCE_HRMS_section_mst;
	
	@Value("${DELETE_STAGE_section_mst}")
	private String DELETE_STAGE_section_mst;
	
	@Value("${INSERT_STAGE_section_mst}")
	private String INSERT_STAGE_section_mst;
	
	
	@Value("${SOURCE_HRMS_subposts}")
	private String SOURCE_HRMS_subposts;
	
	@Value("${DELETE_STAGE_subposts}")
	private String DELETE_STAGE_subposts;
	
	@Value("${INSERT_STAGE_subposts}")
	private String INSERT_STAGE_subposts;
	
	
	@Value("${SOURCE_HRMS_PRESENT_POST_EMP}")
	private String SOURCE_HRMS_PRESENT_POST_EMP;
	
	@Value("${DELETE_STAGE_PRESENT_POST_EMP}")
	private String DELETE_STAGE_PRESENT_POST_EMP;
	
	@Value("${INSERT_STAGE_PRESENT_POST_EMP}")
	private String INSERT_STAGE_PRESENT_POST_EMP;
	
	
	@Value("${SOURCE_HRMS_users}")
	private String SOURCE_HRMS_users;
	
	@Value("${DELETE_STAGE_users}")
	private String DELETE_STAGE_users;
	
	@Value("${INSERT_STAGE_users}")
	private String INSERT_STAGE_users;
	

	@Value("${SOURCE_HRMS_DESIGNATION_MST}")
	private String SOURCE_HRMS_DESIGNATION_MST;
	
	@Value("${DELETE_STAGE_DESIGNATION_MST}")
	private String DELETE_STAGE_DESIGNATION_MST;
	
	@Value("${INSERT_STAGE_DESIGNATION_MST}")
	private String INSERT_STAGE_DESIGNATION_MST;
	
	@Value("${SELECT_BASE_UPDATES_UNIT_MASTER}")
	private String SELECT_BASE_UPDATES_UNIT_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_CIRCLE_MASTER}")
	private String SELECT_BASE_UPDATES_CIRCLE_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_DIVISION_MASTER}")
	private String SELECT_BASE_UPDATES_DIVISION_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_SUBDIVISION_MASTER}")
	private String SELECT_BASE_UPDATES_SUBDIVISION_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_SECTION_MASTER}")
	private String SELECT_BASE_UPDATES_SECTION_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_SUBPOSTS_MASTER}")
	private String SELECT_BASE_UPDATES_SUBPOSTS_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_ADDNLCHARGE_MASTER}")
	private String SELECT_BASE_UPDATES_ADDNLCHARGE_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_PPE_MASTER}")
	private String SELECT_BASE_UPDATES_PPE_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_EMP_MASTER}")
	private String SELECT_BASE_UPDATES_EMP_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_DESG_MASTER}")
	private String SELECT_BASE_UPDATES_DESG_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_USERS_MASTER}")
	private String SELECT_BASE_UPDATES_USERS_MASTER;
	
	@Value("${SELECT_BASE_UPDATES_TANKS_INFO}")
	private String SELECT_BASE_UPDATES_TANKS_INFO;
	
	
	@Value("${SOURCE_HRMS_EMP_DIVERSION}")
	private String SOURCE_HRMS_EMP_DIVERSION;
	
	
	@Value("${DELETE_STAGE_EMP_DIVERSION}")
	private String DELETE_STAGE_EMP_DIVERSION;
	
	@Value("${INSERT_STAGE_EMP_DIVERSION}")
	private String INSERT_STAGE_EMP_DIVERSION;
	
	@Value("${SELECT_BASE_UPDATES_EMP_DIV_MASTER}")
	private String SELECT_BASE_UPDATES_EMP_DIV_MASTER;
	
	
	@Value("${EDIT_GET_SLUICENAME_BYID}")
	private String EDIT_GET_SLUICENAME_BYID;
	
	
	@Value("${UPDATE_SLUICENAME_BYID}")
	private String UPDATE_SLUICENAME_BYID;
	
	@Value("${UPDATE_TANKREMARKS_BWS_BYMST1ID}")
	private String UPDATE_TANKREMARKS_BWS_BYMST1ID;
	
	@Value("${EDIT_GET_MST1REMARKS_BYREVIEWID}")
	private String EDIT_GET_MST1REMARKS_BYREVIEWID;
	
	@Value("${VIEW_MST1_REMARKS_EMPID}")
	private String VIEW_MST1_REMARKS_EMPID;
	
	@Value("${EDIT_GET_CAPACITYREMARKS_BYREVIEWID}")
	private String EDIT_GET_CAPACITYREMARKS_BYREVIEWID;
	
	@Value("${UPDATE_CAPACITYREMARKS_BWS_BYMST1ID}")
	private String UPDATE_CAPACITYREMARKS_BWS_BYMST1ID;
	
	
	//start of form 20 
	
	@Value("${INSERT_FORM20_DATA}")
	private String INSERT_FORM20_DATA;
	
	@Value("${INSERT_FORM20_DETAIL}")
	private String INSERT_FORM20_DETAIL;
	
	@Value("${INSERT_FORM20_DOCS}")
	private String INSERT_FORM20_DOCS;
	
	
	@Value("${INSERT_FORM20_APPRV}")
	private String INSERT_FORM20_APPRV;
	
	
	@Value("${GET_FRM_FREQ_TANK}")
	private String GET_FRM_FREQ_TANK;
	
	@Value("${GET_FRM_DATA_ID_TANK}")
	private String GET_FRM_DATA_ID_TANK;
	
	@Value("${GET_FRM_DATA_ID_RES}")
	private String GET_FRM_DATA_ID_RES;
	
	
	@Value("${GET_FRM_DATA_ID_CAN}")
	private String GET_FRM_DATA_ID_CAN;
	
	@Value("${COUNT_FRM_DOCS}")
	private String COUNT_FRM_DOCS;
	
	@Value("${INSERT_FRM_DOCUMENTS}")
	private String INSERT_FRM_DOCUMENTS;
	
	@Value("${FRM_IRR_SRC_LIST}")
	private String FRM_IRR_SRC_LIST;
	
	
	@Value("${GET_FRM_SENT_LIST}")
	private String GET_FRM_SENT_LIST;
	
	
	@Value("${SELECT_FORM_DATA}")
	private String SELECT_FORM_DATA;
	
	@Value("${SELECT_FORM_DETAIL}")
	private String SELECT_FORM_DETAIL;
	
	@Value("${SELECT_FORM_DOCS}")
	private String SELECT_FORM_DOCS;
	
	
	@Value("${EDIT_MIFORM_DATA}")
	private String EDIT_MIFORM_DATA;
	
	@Value("${EDIT_MIFORM_DETAIL}")
	private String EDIT_MIFORM_DETAIL;
	
	
	@Value("${DELETE_FRM_DATA}")
	private String DELETE_FRM_DATA;
	
	@Value("${DELETE_FRM_DETAIL_DATAID}")
	private String DELETE_FRM_DETAIL_DATAID;
	
	@Value("${DELETE_FRM_DOCS_DATAID}")
	private String DELETE_FRM_DOCS_DATAID;
	
	@Value("${DELETE_FRM_DOCS_DOCID}")
	private String DELETE_FRM_DOCS_DOCID;
	
	@Value("${INSERT_FROM_APPRV}")
	private String INSERT_FROM_APPRV;
	
	
	@Value("${UPDATE_OLD_APPRV}")
	private String UPDATE_OLD_APPRV;
	
	
	@Value("${DELETE_FRM_DETAIL_BYID}")
	private String DELETE_FRM_DETAIL_BYID;
	
	
	@Value("${TANK_FEED_MAP_UNIT}")
	private String TANK_FEED_MAP_UNIT;
	@Value("${TANK_FEED_MAP_CIRCLE}")
	private String TANK_FEED_MAP_CIRCLE;
	@Value("${TANK_FEED_MAP_DIVISION}")
	private String TANK_FEED_MAP_DIVISION;
	
	@Value("${TANK_FEED_MAP_SUBDIVISION}")
	private String TANK_FEED_MAP_SUBDIVISION;
	
	
	@Value("${INSERT_RES_ANN1_MST1_REMARKS}")
	private String INSERT_RES_ANN1_MST1_REMARKS;
	
	@Value("${UPDATE_OLD_RES_ANN1_MST1_REMARKS}")
	private String UPDATE_OLD_RES_ANN1_MST1_REMARKS;
	
	
	@Value("${GET_FRM_FREQ_RES}")
	private String GET_FRM_FREQ_RES;
	

	@Value("${GET_FRM_FREQ_CAN}")
	private String GET_FRM_FREQ_CAN;
	
	
	
	
	
	@Value("${FORM20_CANAL_INSERT}")
	private String FORM20_CANAL_INSERT;
	
	@Value("${FORM20_CANAL_UPDATE}")
	private String FORM20_CANAL_UPDATE;
	
	
	@Value("${FORM20_CANAL_INSERT_UNIT}")
	private String FORM20_CANAL_INSERT_UNIT;
	
	
	@Value("${FORM20_RESLOC_UPDATE}")
	private String FORM20_RESLOC_UPDATE;
	
	
	@Value("${FORM20_RESLOC_INSERT_UNIT}")
	private String FORM20_RESLOC_INSERT_UNIT;
	
	
	@Value("${FORM20_RESLOC_SELECT_BYRESID}")
	private String FORM20_RESLOC_SELECT_BYRESID;
	
	
	@Value("${FORM20_CANALLOC_SELECT_BYCANID}")
	private String FORM20_CANALLOC_SELECT_BYCANID;
	
	
	@Value("${SELECT_CANAL_BYUNITID}")
	private String SELECT_CANAL_BYUNITID;
	
	
	@Value("${SOURCE_PMS_INV_RES_BASIC_DATA}")
	private String SOURCE_PMS_INV_RES_BASIC_DATA;
	
	@Value("${DELETE_STAGE_INV_RES}")
	private String DELETE_STAGE_INV_RES;
	
	@Value("${INSERT_STAGE_PMS_INV_RES}")
	private String INSERT_STAGE_PMS_INV_RES;
	
	
	@Value("${SOURCE_PMS_INV_PROJ_MST_DATA}")
	private String SOURCE_PMS_INV_PROJ_MST_DATA;
	
	@Value("${DELETE_STAGE_INV_PROJ_MST}")
	private String DELETE_STAGE_INV_PROJ_MST;
	
	@Value("${INSERT_STAGE_PMS_INV_PROJ_MST}")
	private String INSERT_STAGE_PMS_INV_PROJ_MST;
	
	
	@Value("${SOURCE_PMS_INV_PROJ_UNIT_MAP}")
	private String SOURCE_PMS_INV_PROJ_UNIT_MAP;
	
	@Value("${DELETE_STAGE_INV_PROJ_UNIT_MAP}")
	private String DELETE_STAGE_INV_PROJ_UNIT_MAP;
	
	
	@Value("${INSERT_STAGE_PMS_INV_PROJ_UNIT_MAP}")
	private String INSERT_STAGE_PMS_INV_PROJ_UNIT_MAP;
	
	
	@Value("${SOURCE_PMS_INV_PACKAGES}")
	private String SOURCE_PMS_INV_PACKAGES;
	
	@Value("${DELETE_STAGE_INV_PACKAGES}")
	private String DELETE_STAGE_INV_PACKAGES;
	
	@Value("${INSERT_STAGE_PMS_INV_PACKAGES}")
	private String INSERT_STAGE_PMS_INV_PACKAGES;
	
	
	@Value("${FORM20_CANAL_INSERT_LOCATION}")
	private String FORM20_CANAL_INSERT_LOCATION;
	
	
	
	@Value("${FORM20_CANAL_UPDATE_LOCATION}")
	private String FORM20_CANAL_UPDATE_LOCATION;
	
	
	@Value("${FROM20_GET_CANAL_LOCATION_BYLOCID}")
	private String FROM20_GET_CANAL_LOCATION_BYLOCID;
	
	
	@Value("${SELECT_CANAL_BYPROJECTIDEDIT}")
	private String SELECT_CANAL_BYPROJECTIDEDIT;
	
	
	@Value("${SELECT_CANAL_BYCANALIDEDIT}")
	private String SELECT_CANAL_BYCANALIDEDIT;
	
	
	@Value("${SELECT_CANAL_BYPROJECTIDNOTINLOC}")
	private String SELECT_CANAL_BYPROJECTIDNOTINLOC;
	
	
	@Value("${CANAL_COUNT_BY_NAME}")
	private String CANAL_COUNT_BY_NAME;
	
	
	@Value("${SELECT_PROJECTS_CODES}")
	private String SELECT_PROJECTS_CODES;
	
	
	//end of form 20 
	
	//start of nrld
	
	@Value("${INSERT_NRLD_ANN_MST1}")
	private String INSERT_NRLD_ANN_MST1;
	
	@Value("${GET_NRLD_ANN_FREQ}")
	private String GET_NRLD_ANN_FREQ;
	
	
	@Value("${GET_NRLD_ANN_MST1_ID}")
	private String GET_NRLD_ANN_MST1_ID;
	
	@Value("${INSERT_NRLD_ANN_MST2}")
	private String INSERT_NRLD_ANN_MST2;
	
	
/*	@Value("${INSERT_NRLD_ANN_MST1_REMARKS}")
	private String INSERT_NRLD_ANN_MST1_REMARKS;
	
	@Value("${UPDATE_OLD_NRLD_ANN_MST1_REMARKS}")
	private String UPDATE_OLD_NRLD_ANN_MST1_REMARKS;*/
	
	@Value("${GET_NRLD_ANN_MST2_BY_MST1ID}")
	private String GET_NRLD_ANN_MST2_BY_MST1ID;
	
	@Value("${INSERT_NRLD_ANN_REMARKS}")
	private String INSERT_NRLD_ANN_REMARKS;
	
	@Value("${UPDATE_NRLD_OLD_ANN_REMARKS}")
	private String UPDATE_NRLD_OLD_ANN_REMARKS;
	
	
	@Value("${INSERT_NRLD_INSPECT_INFO}")
	private String INSERT_NRLD_INSPECT_INFO;
	
	@Value("${UPDATE_NRLD_INSPECT_INFO}")
	private String UPDATE_NRLD_INSPECT_INFO;
	
	
	@Value("${INSERT_NRLD_ANN_RECOMMENDATIONS}")
	private String INSERT_NRLD_ANN_RECOMMENDATIONS;
	
	
	@Value("${UPDATE_NRLD_ANN_RECOMMENDATIONS}")
	private String UPDATE_NRLD_ANN_RECOMMENDATIONS;
	
	
	@Value("${GET_RES_MST2_MST1_BY_YEAR_FREQ}")
	private String GET_RES_MST2_MST1_BY_YEAR_FREQ;
	
	
	@Value("${GET_RES_INSPECT_INFO_TANK}")
	private String GET_RES_INSPECT_INFO_TANK;
	
	
	@Value("${INSERT_RES_DAM_HEALTH}")
	private String INSERT_RES_DAM_HEALTH;
	
	@Value("${RES_DAM_HEALTH_STATUS_COUNT}")
	private String RES_DAM_HEALTH_STATUS_COUNT;
	
	@Value("${RES_DAM_HEALTH_ID}")
	private String RES_DAM_HEALTH_ID;
	
	
	@Value("${GET_DAM_HEALTH_BY_MST1ID}")
	private String GET_DAM_HEALTH_BY_MST1ID;
	
	
	@Value("${GET_DAM_HEALTH_BY_INSPECTINFO}")
	private String GET_DAM_HEALTH_BY_INSPECTINFO;
	
	
	@Value("${INSPECT_INFO_BY_INSPECT_OFFICEINFO_ID}")
	private String INSPECT_INFO_BY_INSPECT_OFFICEINFO_ID;
	
	
	@Value("${GET_RES_ANN_RECOMMEND_BY_INSPECT_ID}")
	private String GET_RES_ANN_RECOMMEND_BY_INSPECT_ID;
	
	
	@Value("${INSERT_ACTION_TAKEN_STATUS}")
	private String INSERT_ACTION_TAKEN_STATUS;
	
	@Value("${ATS_DAM_STATUS_COUNT}")
	private String ATS_DAM_STATUS_COUNT;
	
	@Value("${ATS_DAM_ACTION_ID}")
	private String ATS_DAM_ACTION_ID;
	
	@Value("${GET_ACTION_TAKEN_DETAILS_MST1ID}")
	private String GET_ACTION_TAKEN_DETAILS_MST1ID;
	
	
	@Value("${INSERT_RES_DAM_INSPECT_PHOTOS}")
	private String INSERT_RES_DAM_INSPECT_PHOTOS;
	
	@Value("${COUNT_DAM_DOCS}")
	private String COUNT_DAM_DOCS;
	
	
	@Value("${INSERT_DAM_INSPECT_DOCUMENTS}")
	private String INSERT_DAM_INSPECT_DOCUMENTS;
	
	
	@Value("${GET_DAM_MST1_REMARKS}")
	private String GET_DAM_MST1_REMARKS;
	
	@Value("${GET_DAM_INSPECT_PHOTOS}")
	private String GET_DAM_INSPECT_PHOTOS;
	
	
	@Value("${GET_RES_DAM_INFO}")
	private String GET_RES_DAM_INFO;
	
	@Value("${GET_RES_IMP_LEVELS_INFO}")
	private String GET_RES_IMP_LEVELS_INFO;
	
	@Value("${GET_RES_DAMINF_LEVELS_INFO}")
	private String GET_RES_DAMINF_LEVELS_INFO;
	
	
	@Value("${GET_TANK_DAM_INFO}")
	private String GET_TANK_DAM_INFO;
	
	@Value("${GET_TANK_IMP_CONTROL}")
	private String GET_TANK_IMP_CONTROL;
	
	
	@Value("${UPDATE_TANK_DEMO_INFO}")
	private String UPDATE_TANK_DEMO_INFO;
	
	
	@Value("${UPDATE_TANK_IMP_CONTROL_LEVELS}")
	private String UPDATE_TANK_IMP_CONTROL_LEVELS;
	
	
	@Value("${UPDATE_RES_DEMO_INFO}")
	private String UPDATE_RES_DEMO_INFO;
	
	
	@Value("${UPDATE_RES_IMP_CONTROL_LEVELS}")
	private String UPDATE_RES_IMP_CONTROL_LEVELS;
	
	@Value("${GET_TANK_DAMINF_LEVELS_INFO}")
	private String GET_TANK_DAMINF_LEVELS_INFO;
	
	@Value("${UPDATE_DAM_CONDITION_STATUS}")
	private String UPDATE_DAM_CONDITION_STATUS;
	
	
	@Value("${DELETE_ANN_REMARKS_REVIEWID}")
	private String DELETE_ANN_REMARKS_REVIEWID;
	
	@Value("${DELETE_ANN_MST2_MST2ID}")
	private String DELETE_ANN_MST2_MST2ID;
	
	@Value("${DELETE_ANN_RECOMMEND_RECID}")
	private String DELETE_ANN_RECOMMEND_RECID;
	
	@Value("${DELETE_RES_ANN_DOCS}")
	private String DELETE_RES_ANN_DOCS;
	
	@Value("${DELETE_RES_HEALTH_ID}")
	private String DELETE_RES_HEALTH_ID;
	
	@Value("${DELETE_RES_INSPECT_INFO_ID}")
	private String DELETE_RES_INSPECT_INFO_ID;
	
	@Value("${DELETE_RES_ACTION_INFO_ID}")
	private String DELETE_RES_ACTION_INFO_ID;
	
	
	@Value("${UPDATE_NRLD_INSPECT_INFO_OLD}")
	private String UPDATE_NRLD_INSPECT_INFO_OLD;
	
	@Value("${UPDATE_NRLD_ANN_MST2}")
	private String UPDATE_NRLD_ANN_MST2;
	
	
	@Value("${GET_DAM_MST1_REMARKS_BY_REVIEWID}")
	private String GET_DAM_MST1_REMARKS_BY_REVIEWID;
	
	
	@Value("${UPDATE_NRLD_DAM_REMARKS_INFO}")
	private String UPDATE_NRLD_DAM_REMARKS_INFO;
	
	
	@Value("${GET_RES_ANN_RECOMMEND_BY_RES_TANK_YEAR}")
	private String GET_RES_ANN_RECOMMEND_BY_RES_TANK_YEAR;
	
	
	@Value("${GET_RES_ANN_RECOMMEND_BY_RECOMMENDID}")
	private String GET_RES_ANN_RECOMMEND_BY_RECOMMENDID;
	
	
	@Value("${UPDATE_NRLD_ANN_RECOMMENDATION_INFO}")
	private String UPDATE_NRLD_ANN_RECOMMENDATION_INFO;
	
	
	@Value("${DELETE_NRLD_ANN_RECOMMENDATION_INFO}")
	private String DELETE_NRLD_ANN_RECOMMENDATION_INFO;
	
	
	@Value("${GET_DAM_HEALTH_BY_HEALTHID}")
	private String GET_DAM_HEALTH_BY_HEALTHID;
	
	@Value("${UPDATE_NRLD_ANN_HEALTH_INFO}")
	private String UPDATE_NRLD_ANN_HEALTH_INFO;
	
	
	@Value("${GET_ACTION_TAKEN_DETAILS_ACTIONID}")
	private String GET_ACTION_TAKEN_DETAILS_ACTIONID;
	
	@Value("${UPDATE_ACTION_TAKEN_DETAILS_ACTIONID}")
	private String UPDATE_ACTION_TAKEN_DETAILS_ACTIONID;
	
	@Value("${SECTION_TANK_MAPP_NRLD}")
	private String SECTION_TANK_MAPP_NRLD;
	
	@Value("${SELECT_INVOM_NRLD_RESERVOIRS}")
	private String SELECT_INVOM_NRLD_RESERVOIRS;
	
	@Value("${SELECT_PROJECTS_NRLD}")
	private String SELECT_PROJECTS_NRLD;
	
	
	
	@Value("${SELECT_COUNT_NRLD_INSPECT_INTO}")
	private String SELECT_COUNT_NRLD_INSPECT_INTO;
	
	@Value("${SELECT_OLD_NRLD_INSPECT_ID}")
	private String SELECT_OLD_NRLD_INSPECT_ID;
	
	
	@Value("${INSERT_PREV_NRLD_ANN_MST1}")
	private String INSERT_PREV_NRLD_ANN_MST1;
	
	@Value("${INSERT_PREV_NRLD_ANN_MST2}")
	private String INSERT_PREV_NRLD_ANN_MST2;
	
	@Value("${GET_PREV_MST1ID_BYNEWMST1ID}")
	private String GET_PREV_MST1ID_BYNEWMST1ID;
	
	
	@Value("${SELECT_PREV_COUNT_NRLD_INSPECT_INTO}")
	private String SELECT_PREV_COUNT_NRLD_INSPECT_INTO;
	
	
	@Value("${INSERT_PREV_NRLD_INSPECT_INFO}")
	private String INSERT_PREV_NRLD_INSPECT_INFO;
	
	
	@Value("${SELECT_PREV_OLD_NRLD_INSPECT_ID}")
	private String SELECT_PREV_OLD_NRLD_INSPECT_ID;
	
	
	@Value("${INSERT_PREV_RES_DAM_HEALTH}")
	private String INSERT_PREV_RES_DAM_HEALTH;
	
	@Value("${INSERT_PREV_NRLD_ANN_REMARKS}")
	private String INSERT_PREV_NRLD_ANN_REMARKS;
	
	
	@Value("${INSERT_PREV_DAM_INSPECT_DOCUMENTS}")
	private String INSERT_PREV_DAM_INSPECT_DOCUMENTS;
	
	@Value("${INSERT_PREV_NRLD_ANN_RECOMMENDATIONS}")
	private String INSERT_PREV_NRLD_ANN_RECOMMENDATIONS;
	
	
	@Value("${GET_MST1ID_BYYEARMONSOONMST1ID}")
	private String GET_MST1ID_BYYEARMONSOONMST1ID;
	
	
	@Value("${GET_DAM_MST1_REMARKS_BYMST1ID}")
	private String GET_DAM_MST1_REMARKS_BYMST1ID;
	
	
	@Value("${SELECT_INVOM_RESERVOIRS_ADMIN}")
	private String SELECT_INVOM_RESERVOIRS_ADMIN;
	
	@Value("${UPDATE_NRLD_CODE}")
	private String UPDATE_NRLD_CODE;
	
	@Value("${GET_RES_POST_EMP}")
	private String GET_RES_POST_EMP;
	
	
	@Value("${INSERT_RES_POST_ACCESS}")
	private String INSERT_RES_POST_ACCESS;
	
	
	@Value("${DELETE_RES_POST_ACCESS}")
	private String DELETE_RES_POST_ACCESS;
	
	
	@Value("${EMP_DATA_BY_UNIT_CI_DI_SUB}")
	private String EMP_DATA_BY_UNIT_CI_DI_SUB;
	
	
	@Value("${UPDATE_OLD_RES_DAM_HEALTH}")
	private String UPDATE_OLD_RES_DAM_HEALTH;
	
	@Value("${SELECT_IRDAM1_NRLD_RESERVOIRS}")
	private String SELECT_IRDAM1_NRLD_RESERVOIRS;
	
	@Value("${GET_RES_DAMSAL_INFO}")
	private String GET_RES_DAMSAL_INFO;
	
	@Value("${UPDATE_RES_SAL_INFO9}")
	private String UPDATE_RES_SAL_INFO9;
	
	@Value("${UPDATE_RES_SAL_INFO8}")
	private String UPDATE_RES_SAL_INFO8;
	
	@Value("${UPDATE_RES_SAL_INFO7}")
	private String UPDATE_RES_SAL_INFO7;
	
	@Value("${UPDATE_RES_SAL_INFO5}")
	private String UPDATE_RES_SAL_INFO5;
	
	@Value("${UPDATE_RES_SAL_INFO4}")
	private String UPDATE_RES_SAL_INFO4;
	
	@Value("${UPDATE_RES_SAL_INFO2}")
	private String UPDATE_RES_SAL_INFO2;
	
	@Value("${UPDATE_RES_SAL_INFO3}")
	private String UPDATE_RES_SAL_INFO3;
	
	@Value("${UPDATE_RES_SAL_INFO1}")
	private String UPDATE_RES_SAL_INFO1;
	
	@Value("${GET_TANK_DAMSAL_INFO}")
	private String GET_TANK_DAMSAL_INFO;
	
	
	@Value("${UPDATE_TANK_SAL_INFO9}")
	private String UPDATE_TANK_SAL_INFO9;
	
	@Value("${UPDATE_TANK_SAL_INFO8}")
	private String UPDATE_TANK_SAL_INFO8;
	
	@Value("${UPDATE_TANK_SAL_INFO7}")
	private String UPDATE_TANK_SAL_INFO7;
	
	@Value("${UPDATE_TANK_SAL_INFO5}")
	private String UPDATE_TANK_SAL_INFO5;
	
	@Value("${UPDATE_TANK_SAL_INFO4}")
	private String UPDATE_TANK_SAL_INFO4;
	
	@Value("${UPDATE_TANK_SAL_INFO3}")
	private String UPDATE_TANK_SAL_INFO3;
	
	@Value("${UPDATE_TANK_SAL_INFO2}")
	private String UPDATE_TANK_SAL_INFO2;
	
	@Value("${UPDATE_TANK_SAL_INFO1}")
	private String UPDATE_TANK_SAL_INFO1;
	
	
	
	
	@Value("${GET_TANK_RES_CANAL_REPEATED_BREACH}")
	private String GET_TANK_RES_CANAL_REPEATED_BREACH;
	
	@Value("${GET_TANK_RES_CANAL_REPEATED_DAMAGE}")
	private String GET_TANK_RES_CANAL_REPEATED_DAMAGE;
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public List<Map<String, Object>> generalqueryforresult(String generalquery) {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		int count = 0;
		try {
			if (generalquery.toLowerCase().contains("select")) {
				List<Map<String, Object>> result = jdbcTemplate7.queryForList(generalquery);
				for (Map<String, Object> row : result) {
					rs.add(row);
				}
			} else {

				count = jdbcTemplate7.update(generalquery);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", count);
				rs.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return rs;

	}
	
	
	@Override
	public List<Map<String, Object>> generalqueryforresultirrinv(String generalquery) {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here"+generalquery);
		List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		int count = 0;
		try {
			if (generalquery.toLowerCase().contains("select")) {
				List<Map<String, Object>> result = irrInvTemplate.queryForList(generalquery);
				for (Map<String, Object> row : result) {
					rs.add(row);
				}
			} else {

				count = irrInvTemplate.update(generalquery);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", count);
				rs.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				irrInvTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return rs;

	}
	
	
	
	@Override
	public List<Map<String, Object>> generalqueryforresultpmsstage(String generalquery) {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here"+generalquery);
		List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		int count = 0;
		try {
			if (generalquery.toLowerCase().contains("select")) {
				List<Map<String, Object>> result = pmsstageTemplate.queryForList(generalquery);
				for (Map<String, Object> row : result) {
					rs.add(row);
				}
			} else {

				count = pmsstageTemplate.update(generalquery);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", count);
				rs.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				pmsstageTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return rs;

	}
	
	
	
	
	@Override
	public List<Map<String, Object>> generalqueryforinvomresult(String generalquery) {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		int count = 0;
		try {
			if (generalquery.toLowerCase().contains("select")) {
				List<Map<String, Object>> result = jdbcTemplate8.queryForList(generalquery);
				for (Map<String, Object> row : result) {
					rs.add(row);
				}
			} else {

				count = jdbcTemplate8.update(generalquery);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", count);
				rs.add(map);
			}
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
		return rs;

	}

	@Override
	public List<Map<String, Object>> generalqueryformisviews(String generalquery) {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		int count = 0;
		try {
			if (generalquery.toLowerCase().contains("select")) {
				List<Map<String, Object>> result = jdbcTemplate9.queryForList(generalquery);
				for (Map<String, Object> row : result) {
					rs.add(row);
				}
			} else {

				count = jdbcTemplate9.update(generalquery);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", count);
				rs.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate9.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return rs;

	}
	
	
	@Override
	public List<Map<String, Object>> generalqueryformtanksview(String generalquery) {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		int count = 0;
		try {
			if (generalquery.toLowerCase().contains("select")) {
				List<Map<String, Object>> result = mkTemplate.queryForList(generalquery);
				for (Map<String, Object> row : result) {
					rs.add(row);
				}
			} else {

				count = mkTemplate.update(generalquery);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", count);
				rs.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				mkTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return rs;

	}
	
	
	@Override
	public List<Map<String, Object>> generalqueryforstagetims(String generalquery) {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		int count = 0;
		try {
			if (generalquery.toLowerCase().contains("select")) {
				List<Map<String, Object>> result = jdbcTemplate10.queryForList(generalquery);
				for (Map<String, Object> row : result) {
					rs.add(row);
				}
			} else {

				count = jdbcTemplate10.update(generalquery);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", count);
				rs.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return rs;

	}

	
	
	
	
	@Override
	public List<Map<String, Object>> generalqueryforstagehrms(String generalquery) {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		int count = 0;
		try {
			if (generalquery.toLowerCase().contains("select")) {
				List<Map<String, Object>> result = jdbcTemplate11.queryForList(generalquery);
				for (Map<String, Object> row : result) {
					rs.add(row);
				}
			} else {

				count = jdbcTemplate11.update(generalquery);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", count);
				rs.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return rs;

	}
	
	
	
	
	
	
	
	@Override
	public String inserReservoir(final ReservoirSalient ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_RESERVOIRS;

	   

		

		String resCode = null;
		
		Integer resSource=0;

		try {
			if (ressalObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				List<Map<String, Object>> rows = jdbcTemplate7.queryForList(sql, ressalObj.getResName(),
						resSource,ressalObj.getWaterSpreadArea(),ressalObj.getResLatitude(),ressalObj.getResLongitude(),
						ressalObj.getResStatusId(),ressalObj.getHydroPower(),ressalObj.getLandAcquistion(),ressalObj.getCatchmentArea(),
						ressalObj.getMwlCapacity(),ressalObj.getFrlCapacity(),ressalObj.getMddlCapacity(),ressalObj.getDeadstorageCapacity(),
						ressalObj.getTrlLevel(),ressalObj.getFrlLevel(),ressalObj.getMwlLevel(),ressalObj.getMddlLevel(),
						ressalObj.getDeadstorageLevel(),ressalObj.getSpillwayLength(),ressalObj.getNonoverflowLength(),ressalObj.getMaxhtSpillWay(),
						ressalObj.getTopWidthDam(),ressalObj.getMaxbaseWidthDam(),ressalObj.getClearBridgeWidth(),ressalObj.getStillingBasinLength(),
						ressalObj.getDeepestfoundationLevel(),ressalObj.getAvgRiverbedLevel(),ressalObj.getSpillWayCrestLevel(),ressalObj.getBridgeTopLevel(),
						ressalObj.getInvertLevel(),ressalObj.getStillingBasinLevel(),ressalObj.getEarthdamLeftLength(),ressalObj.getEarthdamRightLength(),
						ressalObj.getMaxHeight(),ressalObj.getMasonarydamLength(),ressalObj.getRockfilldamLength(),ressalObj.getConcretedamLength(),
						ressalObj.getZonalSectionLength(),ressalObj.getHomogeneousSectionLength(),ressalObj.getUserId(),ressalObj.getUserName(),ressalObj.getMaxfloodDischarge());

				for (Map<String, Object> row : rows) {
					resCode = row.get("res_code").toString();
				}

				
			
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return resCode;
	}

	@Override
	public List<ReservoirSalient> getResList() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES;
		try {

			List<ReservoirSalient> ReservoirSalientList = jdbcTemplate7.query(sql,
					new RowMapper<ReservoirSalient>() {

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirSalient reservoirSalient = new ReservoirSalient();
							reservoirSalient.setResCode(rs.getString(1));
							reservoirSalient.setResName(rs.getString(2));
							return reservoirSalient;
						}

					});
			jdbcTemplate7.getDataSource().getConnection().close();
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public ReservoirSalient getResListBYCode(String rescode) throws InventoryUserException {
		
		//System.out.println("impl"+rescode);
		// TODO Auto-generated method stub
		String sql = SELECT_RES_BYID;
		
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
							return reservoirSalient;
						}

					});
			
			// System.out.println("sql"+sql);
			jdbcTemplate7.getDataSource().getConnection().close();
			
		//	System.out.println("impl2"+ReservoirSalientList);
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public Integer inserResUnitMap(final ReservoirUnitData resunitObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_RES_UNIT_MAP;

	   

		

		Integer rows = 0;

		try {
			if (resunitObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate7.update(sql,resunitObj.getUnitId(),resunitObj.getCircleId(),resunitObj.getDivisionId(),resunitObj.getSubdivisionId()
						,resunitObj.getReservoirId(),resunitObj.getProjectId(),resunitObj.getPackageId(),resunitObj.getWorkinspectorno(),resunitObj.getLuscurno(),
						resunitObj.getRemarks(),resunitObj.getUserId(),resunitObj.getUserName());

				
				

				
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	
	@Override
	public List<ReservoirUnitData> getResUnitMapListById(Integer unitId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_UNIT_MAP;
		try {

			//System.out.println("unitId"+unitId);
			//System.out.println("SELECT_RES_UNIT_MAP"+SELECT_RES_UNIT_MAP);
			List<ReservoirUnitData> reservoirUnitDataList = jdbcTemplate7.query(sql,new Object[]{unitId},
					new RowMapper<ReservoirUnitData>() {

						public ReservoirUnitData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirUnitData reservoirUnitData = new ReservoirUnitData();
							reservoirUnitData.setResunitmapid(rs.getInt(1));
							reservoirUnitData.setUnitId(rs.getInt(2));
							reservoirUnitData.setCircleId(rs.getInt(3));
							reservoirUnitData.setDivisionId(rs.getInt(4));
							reservoirUnitData.setSubdivisionId(rs.getInt(5));
							reservoirUnitData.setReservoirId(rs.getString(6));
							reservoirUnitData.setProjectId(rs.getInt(7));
							reservoirUnitData.setPackageId(rs.getInt(8));
							reservoirUnitData.setWorkinspectorno(rs.getInt(9));
							reservoirUnitData.setLuscurno(rs.getInt(10));
							reservoirUnitData.setRemarks(rs.getString(11));
							reservoirUnitData.setUserId(rs.getInt(12));
							reservoirUnitData.setUserName(rs.getString(13));
							reservoirUnitData.setUnitName(rs.getString(14));
							reservoirUnitData.setCircleName(rs.getString(15));
							reservoirUnitData.setDivisionName(rs.getString(16));
							reservoirUnitData.setSubdivisionName(rs.getString(17));
							reservoirUnitData.setResName(rs.getString(18));
							reservoirUnitData.setProjectName(rs.getString(19));
							reservoirUnitData.setPackName(rs.getString(20));
							
							
							
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
	public Integer editReservoirInfo(final ReservoirSalient ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql = UPDATE_RES_INFO_BY_CODE;
		
		

	
		
		Integer rows=0;
		
		
		//System.out.println("sql"+sql);
		
		String rescode=ressalObj.getResCode();
		
		String val=rescode.replace("\"", "");
		
		//System.out.println("val"+rescode);
		
		Integer resSource=0;
		
		try {

			jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);
			 if(ressalObj!=null && ressalObj.getResCode()!=null){
             	
				
					
					
					rows = jdbcTemplate7.update(sql,ressalObj.getResName(),
							resSource,ressalObj.getWaterSpreadArea(),ressalObj.getResLatitude(),ressalObj.getResLongitude(),
							ressalObj.getResStatusId(),ressalObj.getHydroPower(),ressalObj.getLandAcquistion(),ressalObj.getCatchmentArea(),
							ressalObj.getMwlCapacity(),ressalObj.getFrlCapacity(),ressalObj.getMddlCapacity(),ressalObj.getDeadstorageCapacity(),
							ressalObj.getTrlLevel(),ressalObj.getFrlLevel(),ressalObj.getMwlLevel(),ressalObj.getMddlLevel(),
							ressalObj.getDeadstorageLevel(),ressalObj.getSpillwayLength(),ressalObj.getNonoverflowLength(),ressalObj.getMaxhtSpillWay(),
							ressalObj.getTopWidthDam(),ressalObj.getMaxbaseWidthDam(),ressalObj.getClearBridgeWidth(),ressalObj.getStillingBasinLength(),
							ressalObj.getDeepestfoundationLevel(),ressalObj.getAvgRiverbedLevel(),ressalObj.getSpillWayCrestLevel(),ressalObj.getBridgeTopLevel(),
							ressalObj.getInvertLevel(),ressalObj.getStillingBasinLevel(),ressalObj.getEarthdamLeftLength(),ressalObj.getEarthdamRightLength(),
							ressalObj.getMaxHeight(),ressalObj.getMasonarydamLength(),ressalObj.getRockfilldamLength(),ressalObj.getConcretedamLength(),
							ressalObj.getZonalSectionLength(),ressalObj.getHomogeneousSectionLength(),ressalObj.getUserId(),ressalObj.getUserName(),ressalObj.getMaxfloodDischarge(),val);
				
				
							

							
									
									
									
				
		        
			
			 } 
				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer deleteReservoirInfo(final ReservoirSalient ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_RES_INFO_BY_CODE;
		
		
String rescode=ressalObj.getResCode();
		
		String val=rescode.replace("\"", "");
		
		//System.out.println("val"+rescode);
	
		
		Integer rows=0;
		
		
		
		
		
		try {

			jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);
			 if(ressalObj!=null && ressalObj.getResCode()!=null){
             	
				
					
					
					rows = jdbcTemplate7.update(sql3,ressalObj.getUserId(),ressalObj.getUserName(),val);
				
				
							

							
									
									
									
				
		        
			
			 } 
				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public ReservoirUnitData getResUnitMapListByMapId(Integer resunitId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_UNIT_MAP_BYMAPID;
		try {

			//System.out.println("resunitId"+resunitId+SELECT_RES_UNIT_MAP_BYMAPID);
			//System.out.println("SELECT_RES_UNIT_MAP"+SELECT_RES_UNIT_MAP);
			ReservoirUnitData reservoirUnitDataList = (ReservoirUnitData) jdbcTemplate7.queryForObject(sql,new Object[]{resunitId},
					new RowMapper<Object>() {

						public Object mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							
							
						
							ReservoirUnitData reservoirUnitData = new ReservoirUnitData();
							reservoirUnitData.setResunitmapid(rs.getInt(1));
							reservoirUnitData.setUnitId(rs.getInt(2));
							reservoirUnitData.setCircleId(rs.getInt(3));
							reservoirUnitData.setDivisionId(rs.getInt(4));
							reservoirUnitData.setSubdivisionId(rs.getInt(5));
							reservoirUnitData.setReservoirId(rs.getString(6));
							reservoirUnitData.setProjectId(rs.getInt(7));
							reservoirUnitData.setPackageId(rs.getInt(8));
							reservoirUnitData.setWorkinspectorno(rs.getInt(9));
							reservoirUnitData.setLuscurno(rs.getInt(10));
							reservoirUnitData.setRemarks(rs.getString(11));
							reservoirUnitData.setUserId(rs.getInt(12));
							reservoirUnitData.setUserName(rs.getString(13));
							
							
							
							
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
	public Integer UpdateResUnitMapById(final ReservoirUnitData resunitObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_UNIT_MAP_BYMAPID;

	   

		

		Integer rows = 0;

		try {
			if (resunitObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate7.update(sql,resunitObj.getUnitId(),resunitObj.getCircleId(),resunitObj.getDivisionId(),resunitObj.getSubdivisionId()
						,resunitObj.getReservoirId(),resunitObj.getProjectId(),resunitObj.getPackageId(),resunitObj.getWorkinspectorno(),resunitObj.getLuscurno(),
						resunitObj.getRemarks(),resunitObj.getUserId(),resunitObj.getUserName(),resunitObj.getResunitmapid());

				
				

				
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	@Override
	public Integer DeleteResUnitMapById(final ReservoirUnitData resunitObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_RES_UNIT_MAP_BY_ID;

	   

		

		Integer rows = 0;

		try {
			if (resunitObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate7.update(sql,resunitObj.getUserId(),resunitObj.getUserName(),resunitObj.getResunitmapid());

				
				

				
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	@Override
	public List<ReservoirUnitData> getResUnitMapListByResCode(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_UNIT_MAP_BY_RESCODE;
		

		
		String val=rescode.replace("\"", "");
		
		//System.out.println("val"+rescode);
		try {

			//System.out.println("unitId"+unitId);
			//System.out.println("SELECT_RES_UNIT_MAP"+SELECT_RES_UNIT_MAP);
			List<ReservoirUnitData> reservoirUnitDataList = jdbcTemplate7.query(sql,new Object[]{val},
					new RowMapper<ReservoirUnitData>() {

						public ReservoirUnitData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirUnitData reservoirUnitData = new ReservoirUnitData();
							reservoirUnitData.setResunitmapid(rs.getInt(1));
							reservoirUnitData.setUnitId(rs.getInt(2));
							reservoirUnitData.setCircleId(rs.getInt(3));
							reservoirUnitData.setDivisionId(rs.getInt(4));
							reservoirUnitData.setSubdivisionId(rs.getInt(5));
							reservoirUnitData.setReservoirId(rs.getString(6));
							reservoirUnitData.setProjectId(rs.getInt(7));
							reservoirUnitData.setPackageId(rs.getInt(8));
							reservoirUnitData.setWorkinspectorno(rs.getInt(9));
							reservoirUnitData.setLuscurno(rs.getInt(10));
							reservoirUnitData.setRemarks(rs.getString(11));
							reservoirUnitData.setUserId(rs.getInt(12));
							reservoirUnitData.setUserName(rs.getString(13));
							reservoirUnitData.setUnitName(rs.getString(14));
							reservoirUnitData.setCircleName(rs.getString(15));
							reservoirUnitData.setDivisionName(rs.getString(16));
							reservoirUnitData.setSubdivisionName(rs.getString(17));
							reservoirUnitData.setResName(rs.getString(18));
							reservoirUnitData.setProjectName(rs.getString(19));
							reservoirUnitData.setPackName(rs.getString(20));
							
							
							
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
	public Integer insertResRegulator(final ReservoirGates ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_RES_REGULATOR;

	   

		

		Integer rows=0;
		
		

		try {
			if (ressalObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate7.update(sql,ressalObj.getRegreservoirId(),ressalObj.getRegulatorName(), ressalObj.getUserId(),ressalObj.getUserName());

				
				
			
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer insertResGates(final ReservoirGates ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_RES_GATES;

	   

		

		Integer  resgateId = null;
		
		

		try {
			if (ressalObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				List<Map<String, Object>> rows = jdbcTemplate7.queryForList(sql,ressalObj.getRegulatorCode(), ressalObj.getGatereservoirId(),
						ressalObj.getGateTypeId(),ressalObj.getGateSize(),ressalObj.getGateDischarge(),
						ressalObj.getGateSillLevel(),ressalObj.getGateTopLevel(),ressalObj.getGateSystemId(),ressalObj.getGateWeight(),
						ressalObj.getGateHoistMotor(),ressalObj.getUserId(),ressalObj.getUserName(),ressalObj.getGateNo());

				for (Map<String, Object> row : rows) {
					resgateId = Integer.parseInt(row.get("res_gate_id").toString());
				}

				
			
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return resgateId;
	}
	
	@Override
	public Integer insertInvAyacutByResReg(final ReservoirAyacut resObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_INV_AYACUT_BY_RES_REG;

	   

		

		Integer rows = 0;

		try {
			if (resObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate7.update(sql,resObj.getResRegulatorCode(),resObj.getAyacutreservoirId(),resObj.getAyacutContemplated(),resObj.getUserId(),resObj.getUserName());

				
				

				
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public List<ReservoirGates> getResRegList(String resCode) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_REG;
		
		String val=resCode.replace("\"", "");
		try {

			List<ReservoirGates> reservoirGatesList = jdbcTemplate7.query(sql,new Object[]{val},
					new RowMapper<ReservoirGates>() {

						public ReservoirGates mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirGates reservoirGates = new ReservoirGates();
							reservoirGates.setRegulatorCode(rs.getString(1));
							reservoirGates.setRegulatorName(rs.getString(2));
							return reservoirGates;
						}

					});
			jdbcTemplate7.getDataSource().getConnection().close();
			return reservoirGatesList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public ReservoirGates getResRegByRegCode(String regCode) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_REG_BYCODE;
		
		String val=regCode.replace("\"", "");
		try {

			ReservoirGates reservoirGatesList = jdbcTemplate7.queryForObject(sql,new Object[]{val},
					new RowMapper<ReservoirGates>() {

						public ReservoirGates mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirGates reservoirGates = new ReservoirGates();
							reservoirGates.setRegulatorCode(rs.getString(1));
							reservoirGates.setRegulatorName(rs.getString(2));
							return reservoirGates;
						}

					});
			jdbcTemplate7.getDataSource().getConnection().close();
			return reservoirGatesList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirGates> getResGateList(String resCode) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_GATES_BYRES;
		
		String val=resCode.replace("\"", "");
		try {

			List<ReservoirGates> reservoirGatesList = jdbcTemplate7.query(sql,new Object[]{val},
					new RowMapper<ReservoirGates>() {

						public ReservoirGates mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirGates reservoirGates = new ReservoirGates();
							reservoirGates.setReservoirGateId(rs.getInt(1));
							reservoirGates.setRegulatorCode(rs.getString(2));
							reservoirGates.setResCode(rs.getString(3));
							reservoirGates.setGateTypeId(rs.getInt(4));
							reservoirGates.setGateDischarge(rs.getDouble(5));
							reservoirGates.setGateSillLevel(rs.getDouble(6));
							reservoirGates.setGateTopLevel(rs.getDouble(7));
							reservoirGates.setGateSystemId(rs.getInt(8));
							reservoirGates.setGateWeight(rs.getDouble(9));
							reservoirGates.setGateHoistMotor(rs.getDouble(10));
							reservoirGates.setGateSize(rs.getString(11));
							reservoirGates.setUserId(rs.getInt(12));
							reservoirGates.setUserName(rs.getString(13));
							reservoirGates.setRegulatorName(rs.getString(14));
							reservoirGates.setGateType(rs.getString(15));
							reservoirGates.setGateSystem(rs.getString(16));
							reservoirGates.setResName(rs.getString(17));
							reservoirGates.setGateNo(rs.getInt(18));
						
							return reservoirGates;
						}

					});
			jdbcTemplate7.getDataSource().getConnection().close();
			return reservoirGatesList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirAyacut> getResRegAyacutList(String resCode) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_AYACUT_BY_RES;
		
		String val=resCode.replace("\"", "");
		try {

			List<ReservoirAyacut> reservoirAyacutList = jdbcTemplate7.query(sql,new Object[]{val},
					new RowMapper<ReservoirAyacut>() {

						public ReservoirAyacut mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirAyacut reservoirAyacut = new ReservoirAyacut();
							reservoirAyacut.setResRegulatorCode(rs.getString(1));
							reservoirAyacut.setResCode(rs.getString(2));
							reservoirAyacut.setAyacutContemplated(rs.getDouble(3));
							reservoirAyacut.setUserId(rs.getInt(4));
							reservoirAyacut.setUserName(rs.getString(5));
							reservoirAyacut.setResAyacutId(rs.getInt(6));
							reservoirAyacut.setResName(rs.getString(7));
							reservoirAyacut.setResRegulatorName(rs.getString(8));
							
							return reservoirAyacut;
						}

					});
			jdbcTemplate7.getDataSource().getConnection().close();
			return reservoirAyacutList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public ReservoirGates getResGateByGateId(Integer gateId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_GATE_BY_ID;
		
		//System.out.println("gateId"+gateId+"gate"+sql);
		
		
		try {

			ReservoirGates reservoirGatesList = jdbcTemplate7.queryForObject(sql,new Object[]{gateId},
					new RowMapper<ReservoirGates>() {

						public ReservoirGates mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirGates reservoirGates = new ReservoirGates();
							reservoirGates.setRegulatorCode(rs.getString(1));
							reservoirGates.setGatereservoirId(rs.getString(2));
							reservoirGates.setGateTypeId(rs.getInt(3));
							reservoirGates.setGateDischarge(rs.getDouble(4));
							reservoirGates.setGateSillLevel(rs.getDouble(5));
							reservoirGates.setGateTopLevel(rs.getDouble(6));
							reservoirGates.setGateSystemId(rs.getInt(7));
							reservoirGates.setGateWeight(rs.getDouble(8));
							reservoirGates.setGateHoistMotor(rs.getDouble(9));
							reservoirGates.setGateSize(rs.getString(10));
							reservoirGates.setGateNo(rs.getInt(11));
							reservoirGates.setReservoirGateId(rs.getInt(12));
							
							
							return reservoirGates;
						}

					});
			jdbcTemplate7.getDataSource().getConnection().close();
			return reservoirGatesList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public ReservoirAyacut getResAyacutById(Integer ayacutId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_AYACUT_BY_ID;
		
		
		try {

			ReservoirAyacut reservoirAyacutList = jdbcTemplate7.queryForObject(sql,new Object[]{ayacutId},
					new RowMapper<ReservoirAyacut>() {

						public ReservoirAyacut mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirAyacut reservoirAyacut = new ReservoirAyacut();
							reservoirAyacut.setResRegulatorCode(rs.getString(1));
							reservoirAyacut.setAyacutreservoirId(rs.getString(2));
							reservoirAyacut.setAyacutContemplated(rs.getDouble(3));
							reservoirAyacut.setResAyacutId(rs.getInt(4));
							
							return reservoirAyacut;
						}

					});
			jdbcTemplate7.getDataSource().getConnection().close();
			return reservoirAyacutList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public Integer DeleteResAyacutById(final ReservoirAyacut resunitObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_RES_AYACUT;

	   

		

		Integer rows = 0;

		try {
			if (resunitObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate7.update(sql,resunitObj.getUserId(),resunitObj.getUserName(),resunitObj.getResAyacutId());

				
				

				
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer UpdateResAyacutById(final ReservoirAyacut resObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_RES_AYACUT;

	   

		

		Integer rows = 0;

		try {
			if (resObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate7.update(sql,resObj.getResRegulatorCode(),resObj.getAyacutreservoirId(),resObj.getAyacutContemplated(),resObj.getUserId(),resObj.getUserName(),resObj.getResAyacutId());

				
				

				
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer DeleteResGateById(final ReservoirGates resObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_RES_GATE;

	   

		

		Integer rows = 0;

		try {
			if (resObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate7.update(sql,resObj.getUserId(),resObj.getUserName(),resObj.getReservoirGateId());

				
				

				
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer UpdateResGateById(final ReservoirGates ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_RES_GATE;

	   

		

		Integer rows = 0;

		try {
			if (ressalObj != null) {

				jdbcTemplate7.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate7.update(sql,ressalObj.getRegulatorCode(), ressalObj.getGatereservoirId(),
							ressalObj.getGateTypeId(),ressalObj.getGateDischarge(),
							ressalObj.getGateSillLevel(),ressalObj.getGateTopLevel(),ressalObj.getGateSystemId(),ressalObj.getGateWeight(),
							ressalObj.getGateHoistMotor(),ressalObj.getUserId(),ressalObj.getUserName(),ressalObj.getGateSize(),ressalObj.getGateNo(),ressalObj.getReservoirGateId());

				
				

				
			

					jdbcTemplate7.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public List<PumpPumpsData> getPumpsdataList() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_PUMP_DATA;
		
		
		try {

			List<PumpPumpsData> pumpsdataList = jdbcTemplate8.query(sql,
					new RowMapper<PumpPumpsData>() {

						public PumpPumpsData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PumpPumpsData pcd = new PumpPumpsData();
							pcd.setPumpdataId(rs.getInt(1));
							pcd.setPumpDataItem(rs.getString(2));
							pcd.setPumpDataItemType(rs.getInt(3));
							pcd.setPumpDataShortForm(rs.getString(4));
							
							return pcd;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return pumpsdataList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	@Override
	public List<PumpCommonData> getPumpsCommonList() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_COMMOM_DATA;
		
		
		try {

			List<PumpCommonData> pumpCommonDataList = jdbcTemplate8.query(sql,
					new RowMapper<PumpCommonData>() {

						public PumpCommonData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PumpCommonData pcd = new PumpCommonData();
							pcd.setPumpCommonDataId(rs.getInt(1));
							pcd.setPumpCommonDataItem(rs.getString(2));
							pcd.setPumpCommonDataItemType(rs.getInt(3));
							pcd.setPumpCommonDataShortForm(rs.getString(4));
							
							return pcd;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return pumpCommonDataList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<PumpMaintainActivities> getPumpMaintainActivities() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_PUMP_MAINTAIN_ACTIVITIES;
		
		
		try {

			List<PumpMaintainActivities> pumpMaintainActivList = jdbcTemplate8.query(sql,
					new RowMapper<PumpMaintainActivities>() {

						public PumpMaintainActivities mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PumpMaintainActivities pma = new PumpMaintainActivities();
							pma.setPmActivityId(rs.getInt(1));
							pma.setPmActivity(rs.getString(2));
							pma.setActivityFreqId(rs.getInt(3));
							
							
							return pma;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return pumpMaintainActivList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<MitankComps> getMiTankComps() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_MI_COMPS;
		
		
		try {

			List<MitankComps> mitankCompsList = jdbcTemplate8.query(sql,
					new RowMapper<MitankComps>() {

						public MitankComps mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MitankComps mtc = new MitankComps();
							mtc.setMiCompId(rs.getInt(1));
							mtc.setMiCompName(rs.getString(2));
							mtc.setMiparentId(rs.getInt(3));
							mtc.setHasChild(rs.getBoolean(4));
							return mtc;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return mitankCompsList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<MitankChecks> getMitankChecks() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_MI_CHECKS;
		
		
		try {

			List<MitankChecks> mitankChecksList = jdbcTemplate8.query(sql,
					new RowMapper<MitankChecks>() {

						public MitankChecks mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MitankChecks mtc = new MitankChecks();
							mtc.setMiInspectMapId(rs.getInt(1));
							mtc.setMiInspectTypeId(rs.getInt(2));
							mtc.setMiCompId(rs.getInt(3));
							mtc.setMiComp(rs.getString(4));
							mtc.setMiCheck(rs.getString(5));
							return mtc;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return mitankChecksList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<PumpOperationType> getPumpOperationTypes() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_PUMP_OPERATION_TYPES;
		
		
		try {

			List<PumpOperationType> pumpOperationTypeList = jdbcTemplate8.query(sql,
					new RowMapper<PumpOperationType>() {

						public PumpOperationType mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PumpOperationType pot = new PumpOperationType();
							
							pot.setPumpOperationTypeId(rs.getInt(1));
							pot.setPumpOperationType(rs.getString(2));
							pot.setPumpOPerationParentId(rs.getInt(3));
							pot.setPumpOperationSequence(rs.getInt(4));
						
							return pot;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return pumpOperationTypeList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<PumpOperationInstructions> getPumpOperationInstructions() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_PUMP_OPER_INSTRUCTIONS;
		
		
		try {

			List<PumpOperationInstructions> PumpOperationInstructionList = jdbcTemplate8.query(sql,
					new RowMapper<PumpOperationInstructions>() {

						public PumpOperationInstructions mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PumpOperationInstructions poi = new PumpOperationInstructions();
							
							poi.setPumpInstructId(rs.getInt(1));
							poi.setPumpInstruction(rs.getString(2));
							poi.setPumpInstructType(rs.getInt(3));
							poi.setPumpInstructSeq(rs.getInt(4));
							
						
							return poi;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return PumpOperationInstructionList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<ScheduleDuty> getReservoirScheduleofDuties() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_SCHEDULE_DUTIES;
		
		
		try {

			List<ScheduleDuty> scheduleofDutiesList = jdbcTemplate8.query(sql,
					new RowMapper<ScheduleDuty>() {

						public ScheduleDuty mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ScheduleDuty sd = new ScheduleDuty();
							
							sd.setDutyDesignationMapId(rs.getInt(1));
							sd.setDutyId(rs.getInt(2));
							sd.setDesignationId(rs.getInt(3));
							sd.setDutyName(rs.getString(4));
							sd.setParentDutyId(rs.getInt(5));
							sd.setParentHasChild(rs.getBoolean(6));
							sd.setDutyDisplaySeq(rs.getInt(7));
							sd.setDutyFrequencyId(rs.getInt(8));
							
						
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
	public Integer insertMiinspect(final List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_MI_INSPECT;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		final Integer olddictId=0;
		final Integer waterlevelinspect=0;
		final Integer capacity=0;
		final Integer mitankinspectapprovId=0;
	
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
				 
				 
				if (miObj.size() > 0) {
					if(miObj.get(0).getMiTankFreqId()!=null && miObj.get(0).getMiInspectMapId()!=null ){
					j = jdbcTemplate8.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
									
											
										

									MiTankInspect sd = miObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());

								
										ps.setLong(1,  miObj.get(0).getTankId());
										
										ps.setInt(2,  miObj.get(0).getUnitId());
										ps.setInt(3,  miObj.get(0).getCircleId());
										ps.setInt(4,  miObj.get(0).getDivisionId());
										ps.setInt(5,  miObj.get(0).getSubdivisionId());
										ps.setInt(6,  miObj.get(0).getProjectId());
										ps.setInt(7,  miObj.get(0).getConstId());
										ps.setInt(8,  miObj.get(0).getNewDistrictId());
										ps.setInt(9,  miObj.get(0).getMandalId());
										ps.setInt(10,  miObj.get(0).getVillageId());
										ps.setInt(11, olddictId);
										ps.setInt(12, sd.getMiInspectMapId());
										ps.setInt(13,  miObj.get(0).getMiTankFreqId());
										
										
										
										 java.sql.Date date1 = null;
										try {
											
											if (sd.getInspectDate()!= null
													&& sd.getInspectDate() != ""
													&& !sd.getInspectDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( sd.getInspectDate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										 
									
											ps.setDate(14, date1);
										
											ps.setInt(15, waterlevelinspect);
											ps.setInt(16, capacity);
										
											ps.setInt(17,sd.getActionrequireqId());
											//ps.setInt(18, miObj.get(0).getUserId());
											
											ps.setString(18, miObj.get(0).getUserEmpId());
											ps.setString(19, miObj.get(0).getUserName());
											ps.setString(20,sd.getRemarks());
											ps.setInt(21,mitankinspectapprovId);
											ps.setInt(22,miObj.get(0).getTankWeirSluiceId());
											ps.setInt(23, miObj.get(0).getYear());
											ps.setBoolean(24,sd.getActionreq());
											ps.setInt(25,sd.getMiInspectTypeId());
											ps.setInt(26,sd.getMiCompId());
											

									
								}

								@Override
								public int getBatchSize() {
									return miObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public MstOutputWithFlag insertMiinspectMst1(final List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_INVOM_MI_TANK_INSPECT_MST1;
		
		String sql2=GET_TANK_FREQ;
		
		String sql4=GET_MIINSPECT_MST1_ID;

		
		
		
		Integer updatedfreq=0;
		Integer rows1=0;
		Integer olddictId=0;
		
		MstOutputWithFlag mstoutput = new MstOutputWithFlag();
		
	Integer mst1output=0;
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
				 if(miObj.get(0).getMiTankFreqId()!=null && miObj.get(0).getTankId()!=null && miObj.get(0).getYear()!=null){
				
					 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2, new Object[]{miObj.get(0).getYear(),miObj.get(0).getTankId(),miObj.get(0).getMiTankFreqId()});
					 
					 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("mitankfreq").toString());
							}
					 }
					 
					 
				 }
				 
				// System.out.println("updatedfreq"+updatedfreq);
				 
				 if(updatedfreq>0){
					 
					 List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{miObj.get(0).getTankId(),miObj.get(0).getMiTankFreqId(),miObj.get(0).getYear()});
             
					 if(result1!=null){
						 
						 for (Map<String, Object> row : result1) {
							 mstoutput.setMstOldId(Integer.parseInt(row.get("mi_inpsect_mst1_id").toString())); ;
							}
					 }
					 
					 
				 }
				 
				 
				 
				 
				 if(updatedfreq<1){
				if (miObj.size() > 0) {
					if(miObj.get(0).getMiTankFreqId()!=null  ){
						
						// System.out.println("coming here"+updatedfreq);
						 List<Map<String, Object>> result2 = jdbcTemplate8.queryForList(sql3,miObj.get(0).getTankId(),miObj.get(0).getConstId(), miObj.get(0).getNewDistrictId(),
								miObj.get(0).getMandalId(),miObj.get(0).getVillageId(),olddictId,miObj.get(0).getMiTankFreqId(),miObj.get(0).getUserId(),miObj.get(0).getUserName(),
								miObj.get(0).getYear(),miObj.get(0).getTankStatusId(),miObj.get(0).getUnitId(),miObj.get(0).getCircleId(),miObj.get(0).getDivisionId(),miObj.get(0).getSubdivisionId(),miObj.get(0).getEmpId(),miObj.get(0).getPostId(),miObj.get(0).getSectionId() );	
						 
						 
						 if(result2!=null){
							 
							 for (Map<String, Object> row : result2) {
								 mstoutput.setMstNewId(Integer.parseInt(row.get("mi_inpsect_mst1_id").toString()));
								}
							 
							// System.out.println("mst1outputdao"+mst1output);
						 }
					}	
					
				}
			
			 }
			 }
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mstoutput;
	}
	
	@Override
	public Integer insertMiinspectMst2(final List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_INVOM_MI_TANK_INSPECT_MST2;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		final Integer olddictId=0;
		final Integer waterlevelinspect=0;
		final Integer capacity=0;
		final Integer mitankinspectapprovId=0;
	
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
				 
				// System.out.println("dao"+miObj.get(0).getMiInpsectMst1Id());
				if (miObj.size() > 0) {
					if(miObj.get(0).getMiInpsectMst1Id()!=null  ){
					j = jdbcTemplate8.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
									
											
										

									MiTankInspect sd = miObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());

									ps.setInt(1,  miObj.get(0).getMiInpsectMst1Id());
									
									ps.setLong(2,  miObj.get(0).getTankId());
										ps.setInt(3,  miObj.get(0).getUnitId());
										ps.setInt(4,  miObj.get(0).getCircleId());
										ps.setInt(5,  miObj.get(0).getDivisionId());
										ps.setInt(6,  miObj.get(0).getSubdivisionId());
										ps.setInt(7,  miObj.get(0).getProjectId());
										
										ps.setInt(8, sd.getMiInspectMapId());
										
										
										
										
										
										 java.sql.Date date1 = null;
										try {
											
											if (sd.getInspectDate()!= null
													&& sd.getInspectDate() != ""
													&& !sd.getInspectDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( sd.getInspectDate());
											
											
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										 
									
											ps.setDate(9, date1);
										
											ps.setInt(10, waterlevelinspect);
											ps.setInt(11, capacity);
											ps.setBoolean(12, false);
											ps.setBoolean(13, false);
										
											ps.setInt(14,sd.getActionrequireqId());
											
											ps.setInt(15,miObj.get(0).getDesignationId());
											ps.setString(16,sd.getRemarks());
											ps.setInt(17,mitankinspectapprovId);
											ps.setInt(18,miObj.get(0).getTankWeirSluiceId());
											ps.setBoolean(19,sd.getActionreq());
											ps.setInt(20,sd.getMiInspectTypeId());
											ps.setInt(21,sd.getMiCompId());
											ps.setInt(22, miObj.get(0).getUserId());
											ps.setString(23, miObj.get(0).getUserName());
											//ps.setInt(18, miObj.get(0).getUserId());
											
										
											ps.setInt(24, sd.getTabId());
											
											ps.setInt(25, miObj.get(0).getEmpId());
											
											ps.setLong(26, miObj.get(0).getPostId());
											ps.setInt(27, miObj.get(0).getSectionId());
											
											

									
								}

								@Override
								public int getBatchSize() {
									return miObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer insertMiinspectRepairs(final List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_INVOM_MI_TANK_INSPECT_REPAIRS;		 
		
		//String sql2=GET_TANK_REPAIR_FREQ;
				
			//	String sql4=GET_TANK_REPAIR_ID;
		
Integer rows1=0;
Integer repairId=0;	


		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				 
				 
				/* if(miObj.get(0).getTankId()!=null && date1!=null){
						
					 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2, new Object[]{miObj.get(0).getTankId(),date1});
					 
					 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("mitankfreq").toString());
							}
					 }
					 
					 
				 }*/
				 
				// System.out.println("updatedfreq"+updatedfreq);
				 
			/*	 if(updatedfreq>0){
					 
					 List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{miObj.get(0).getTankId(),date1});
             
					 if(result1!=null){
						 
						 for (Map<String, Object> row : result1) {
							 mstoutput.setMstOldId(Integer.parseInt(row.get("mi_inspect_repair_id").toString())); ;
							}
					 }
					 
					 
				 }*/
				 
				
				if (miObj.size() > 0) {
					 if( miObj.get(0).getTankId()!=null ){
						 List<Map<String, Object>> result2 = jdbcTemplate8.queryForList(sql3,miObj.get(0).getTankId(),miObj.get(0).getMiCompId(), miObj.get(0).getRate(),
								miObj.get(0).getUnitMeasureId(),miObj.get(0).getQuantity(),miObj.get(0).getAmount(),  miObj.get(0).getUserId(),miObj.get(0).getUserName(),
								miObj.get(0).getUnitId(),miObj.get(0).getCircleId(),miObj.get(0).getDivisionId(),miObj.get(0).getSubdivisionId(),miObj.get(0).getProjectId(),
								miObj.get(0).getDesignationId(),
								miObj.get(0).getLevelId(),miObj.get(0).getRepairdescId(),miObj.get(0).getEmpId(),miObj.get(0).getPostId(),miObj.get(0).getSectionId() );	
						 
                           if(result2!=null){
							 
							 for (Map<String, Object> row : result2) {
								 repairId=Integer.parseInt(row.get("mi_inspect_repair_id").toString());
								}
							 
							// System.out.println("mst1outputdao"+mst1output);
						 }
										
					}	
					
				}
				 
			
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return repairId;
	}
	
	
	/*@Override
	public Integer insertMiinspectInOut(final List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_INVOM_MI_TANK_INSPECT_IN_OUT_FLOW;
		
		

		
		
		
		
		Integer rows1=0;
		
		Integer inoutId=0;
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				 if (miObj.get(0).getInspectDate()!= null
							&& miObj.get(0).getInspectDate() != ""
							&& !miObj.get(0).getInspectDate().equals('0')) {
					
					try {
						date1 = DateUtil.getSQLDate( miObj.get(0).getInspectDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
					
				if (miObj.size() > 0) {
					 if( miObj.get(0).getTankId()!=null ){
						 List<Map<String, Object>> result2 = jdbcTemplate8.queryForList(sql3,miObj.get(0).getTankId(),miObj.get(0).getInflow(), miObj.get(0).getOutfow(),
								miObj.get(0).getAyacut(),date1,miObj.get(0).getUserId(),miObj.get(0).getUserName(),
								miObj.get(0).getUserEmpId(),miObj.get(0).getUnitId(),miObj.get(0).getCircleId(),miObj.get(0).getDivisionId(),miObj.get(0).getSubdivisionId(),miObj.get(0).getProjectId(),miObj.get(0).getDesignationId(),miObj.get(0).getLevelId() );	
						 
						 
                           if(result2!=null){
							 
							 for (Map<String, Object> row : result2) {
								 inoutId=Integer.parseInt(row.get("mi_inspect_in_out_flow_id").toString());
								}
							 
							// System.out.println("mst1outputdao"+mst1output);
						 }
						 
										
					}	
					
				}
			
			 }
			 
			 
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return inoutId;
	}*/
	
	@Override
	public Integer insertMiinspectCapacity(final List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_INVOM_MI_TANK_INSPECT_CAPACITY;
		
		

		
		
		
		Integer capacityId=0;
		Integer rows1=0;
		Integer olddictId=0;
		
	
		
		java.sql.Timestamp date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				 if (miObj.get(0).getInspectDate()!= null
							&& miObj.get(0).getInspectDate() != ""
							&& !miObj.get(0).getInspectDate().equals('0')) {
					
					try {
						
				//		System.out.println("miObj.get(0).getInspectDate()"+miObj.get(0).getInspectDate());
						date1 = DateUtil.getSQLDateWithTimenew( miObj.get(0).getInspectDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
					
			//	 System.out.println("date1  "+date1);
				 
				if (miObj.size() > 0) {
					 if(miObj.get(0).getTankId()!=null ){
						 List<Map<String, Object>> result2 = jdbcTemplate8.queryForList(sql3,miObj.get(0).getTankId(),miObj.get(0).getGrossCapacity(),
								 miObj.get(0).getAvailableCapacity(),miObj.get(0).getSurplus(),date1,miObj.get(0).getUserId(),miObj.get(0).getUserName(),
								miObj.get(0).getUnitId(),miObj.get(0).getCircleId(),miObj.get(0).getDivisionId(),miObj.get(0).getSubdivisionId(),
								miObj.get(0).getProjectId(),miObj.get(0).getDesignationId(),miObj.get(0).getLevelId(),miObj.get(0).getInflow(),miObj.get(0).getOutfow(),
								miObj.get(0).getAyacut(),miObj.get(0).getTankLevel(),miObj.get(0).getEmpId(),miObj.get(0).getPostId(),miObj.get(0).getSectionId() );	
								
						 
						 
                         if(capacityId!=null){
							 
							 for (Map<String, Object> row : result2) {
								 capacityId=Integer.parseInt(row.get("mi_inspect_capacity_id").toString());
								}
							 
							// System.out.println("mst1outputdao"+mst1output);
						 }
										
					}	
					
				}
			
			 }
			 
			 
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return capacityId;
	}
	@Override
	public List<Tanks> getTanks(Habitations habitObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_TANKS_BY_VILLAGE;
		
	//	System.out.println("sql"+sql+"villageId"+villageId);
		Integer dId=0;
		
		Integer mId=0;
		
		Integer vId=0;
		
		Integer hId=0;
				
		try {

			if(habitObj!=null){
				
				if(habitObj.getdId()!=null){
					dId=habitObj.getdId();
					
				}
if(habitObj.getmId()!=null){
				
	mId=habitObj.getmId();
					
				}
if(habitObj.getvId()!=null){
	
	vId=habitObj.getvId();
}

if(habitObj.gethId()!=null){
	
	hId=habitObj.gethId();
}
				
				
			}
			List<Tanks> tankList = jdbcTemplate8.query(sql,new Object[]{dId,mId,vId,hId},
					new RowMapper<Tanks>() {

						public Tanks mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							Tanks sd = new Tanks();
							
							sd.setTankId(rs.getLong(1));
							sd.setTankName(rs.getString(2));
							sd.setAcCode(rs.getInt(3));
							sd.setConstName(rs.getString(4));
							/*sd.setCapacitytank(rs.getDouble(3));
							sd.setGeoTagId(rs.getLong(4));
							*/
							
							
						
							return sd;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
			//System.out.println("tankList"+tankList);
			return tankList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirMaintenanceChecks> getResCheckAnn1() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_CHECKS_ANN1;
		
	//	System.out.println("sql"+sql+"villageId"+villageId);
		try {

			List<ReservoirMaintenanceChecks> resChecksList = jdbcTemplate8.query(sql,
					new RowMapper<ReservoirMaintenanceChecks>() {

						public ReservoirMaintenanceChecks mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							ReservoirMaintenanceChecks sd = new ReservoirMaintenanceChecks();
						
							
							sd.setResCheckId(rs.getInt(1));
							sd.setResCheck(rs.getString(2));
							sd.setResCategoryId(rs.getInt(3));
							sd.setResCheckSeq(rs.getInt(4));
							sd.setIsTitle(rs.getBoolean(5));
							sd.setAnnxId(rs.getInt(6));
							sd.setCheckdisplayNum(rs.getString(7));
							
							
							
						
							return sd;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
			//System.out.println("tankList"+tankList);
			return resChecksList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirMaintenanceCategory> getResCatAnn2() throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_CAT_ANN2;
		
	//	System.out.println("coming");
		
	//	System.out.println("sql"+sql+"villageId"+villageId);
		try {

			List<ReservoirMaintenanceCategory> resCatList = jdbcTemplate8.query(sql,
					new RowMapper<ReservoirMaintenanceCategory>() {

						public ReservoirMaintenanceCategory mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							ReservoirMaintenanceCategory sd = new ReservoirMaintenanceCategory();
						
							
							
							
							sd.setResCategoryId(rs.getInt(1));
							sd.setResCategory(rs.getString(2));
							sd.setResCatParentId(rs.getInt(3));
							sd.setResCatHasChild(rs.getBoolean(4));
							sd.setCatseq(rs.getInt(5));
							sd.setCatType(rs.getInt(6));
							sd.setCatNumDisplay(rs.getString(7));
							sd.setCatTitle(rs.getBoolean(8));
							
					
							return sd;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
			//System.out.println("tankList"+tankList);
			return resCatList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public Integer  insertResinspect(final List<ReservoirInspect> resObj) throws InventoryUserException  {
		// TODO Auto-generated method stub
		
		String sql3 =INSERT_RES_INSPECT_ANN1 ;
				
				// +INSERT_RES_INSPECT_ANN1_APP;
				
				 

		 int[] rows=null;
		 
		 Integer len=0;
		
		
		
		final Integer status=1;
	
		
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
             	
				 
			
				
				// batchArgs, batchSize, pss)(sql3,
				 
				if (resObj.size() > 0) {
					
					//System.out.println("  sql3"+ sql3);
					if(resObj.get(0).getResCode()!=null  ){
						rows=jdbcTemplate8.batchUpdate(sql3,new BatchPreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps, int i)
									throws SQLException {	
											
										

									ReservoirInspect sd = resObj.get(i);
									
									 
									//System.out.println(" sd.getResCheckId()"+  sd.getResCheckId());

								
										ps.setLong(1, sd.getResCheckId() );
										
										ps.setInt(2,  sd.getResCatId());
										ps.setInt(3,   sd.getUnitId());
										ps.setInt(4,    sd.getCircleId());
										ps.setInt(5,   sd.getDivisionId());
										ps.setInt(6,   sd.getSubdivisionId());
										ps.setInt(7,   sd.getDesignationId());
										ps.setInt(8,   sd.getUserId());
										ps.setString(9,    sd.getUserName());
										
										 java.sql.Date date1 = null;
											try {
												
												if (sd.getInspectDate()!= null
														&& sd.getInspectDate() != ""
														&& !sd.getInspectDate().equals('0')) {
												
												date1 = DateUtil.getSQLDate( sd.getInspectDate());
												}
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											 
										ps.setDate(10,   date1);
										ps.setInt(11,    sd.getProjectId());
										ps.setString(12, sd.getResCode());
									
										ps.setString(13, sd.getRemarks());
										ps.setInt(14, sd.getApprovStatusId());
										ps.setInt(15, sd.getYear());
										
									
										//System.out.println("i am breaking here");
	
										
										
									

									
								}

								@Override
								public int getBatchSize() {
									// TODO Auto-generated method stub
									return resObj.size();
								}
								

								
							});
					
					}
				}
			}
		      
		
			
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			if(rows!=null)	{
				
				len=rows.length;
				
			}
			

		}
		
        catch (SQLException e) {
			
		//	System.out.println("error"+e.getErrorCode()+"======"+e.fillInStackTrace()+"-----"+e.getLocalizedMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}

		return len;
	}
	
	@Override
	public MstOutputWithFlag insertResAnn1Mst1(final List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_RES_ANN1_MST1;
		
		String sql2=GET_RES_ANN1_FREQ;
		
		String sql4=GET_RES_ANN1_MST1_ID;

		
		
		
		Integer updatedfreq=0;
		Integer rows1=0;
		Integer olddictId=0;
		
		MstOutputWithFlag mstoutput = new MstOutputWithFlag();
		
	Integer mst1output=0;
		
		 
		
		try {
			
			//System.out.println("resObj.get(0).getReservoirId()"+resObj.get(0).getReservoirId());

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			
			
			 if(resObj!=null){
				 
				 
				 java.sql.Date date1 = null;
				
						
						if (resObj.get(0).getInspectDate()!= null
								&& resObj.get(0).getInspectDate() != ""
								&& !resObj.get(0).getInspectDate().equals('0')) {
						
						date1 = DateUtil.getSQLDate( resObj.get(0).getInspectDate());
						
						// System.out.println("date1"+date1);
						}
             	
				
				 if(resObj.get(0).getReservoirId()!=null && resObj.get(0).getDutyFrequencyId()!=null && resObj.get(0).getYear()!=null){
				
					 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2, new Object[]{resObj.get(0).getYear(),resObj.get(0).getReservoirId(),resObj.get(0).getDutyFrequencyId()});
					 
					 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("res_ann1_mst_freq").toString());
							}
					 }
					 
					 
				 }
				 
		//	 System.out.println("updatedfreq"+updatedfreq);
				 
				 if(updatedfreq>0){
					 
					 List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{resObj.get(0).getReservoirId(),resObj.get(0).getDutyFrequencyId(),resObj.get(0).getYear()});
             
					 if(result1!=null){
						 
						 for (Map<String, Object> row : result1) {
							 mstoutput.setMstOldId(Integer.parseInt(row.get("res_ann1_mst1_id").toString())); ;
							}
					 }
					 
					 
				 }
				 
				 
				 /*resObj.get(0).getResStatusId(),*/
				 
				 if(updatedfreq<1){
				if (resObj.size() > 0) {
					if(resObj.get(0).getDutyFrequencyId()!=null  ){
						
						// System.out.println("coming here"+updatedfreq);
						 List<Map<String, Object>> result2 = jdbcTemplate8.queryForList(sql3,resObj.get(0).getUnitId(),resObj.get(0).getCircleId(), resObj.get(0).getDivisionId(),
								 resObj.get(0).getSubdivisionId(),resObj.get(0).getResCode(),resObj.get(0).getProjectId(),resObj.get(0).getReservoirId(),resObj.get(0).getUserName(),
								 resObj.get(0).getDutyFrequencyId(),resObj.get(0).getYear(),resObj.get(0).getEmpId(),resObj.get(0).getSectionId(),date1 );	
						 
						 
						 if(result2!=null){
							 
							 for (Map<String, Object> row : result2) {
								 mstoutput.setMstNewId(Integer.parseInt(row.get("res_ann1_mst1_id").toString()));
								}
							 
							// System.out.println("mst1outputdao"+mst1output);
						 }
					}	
					
				}
			
			 }
			 }
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mstoutput;
	}
	
	
	
	
	@Override
	public MstOutputWithFlag insertNrldAnnMst1(final ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 =INSERT_NRLD_ANN_MST1; 
		
		String sql2=GET_NRLD_ANN_FREQ; 
		
		String sql4=GET_NRLD_ANN_MST1_ID; 
		
		
	
		
		
		Integer updatedfreq=0;
		Integer rows1=0;
		Integer olddictId=0;
		
		MstOutputWithFlag mstoutput = new MstOutputWithFlag();
		
	Integer mst1output=0;
		
		 
		
		try {
			
			//System.out.println("resObj.getReservoirId()"+resObj.getReservoirId()+" ttest"+sql3);

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			
			
			 if(resObj!=null){
				 
				 
				 java.sql.Date date1 = null;
				
						
					
             	
				
				 if(resObj.getReservoirId()!=null && resObj.getDutyFrequencyId()!=null && resObj.getYear()!=null && resObj.getTankId()!=null  ){
				
					 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2, new Object[]{resObj.getYear(),resObj.getReservoirId(),resObj.getDutyFrequencyId(),resObj.getTankId()});
					 
					 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("res_ann1_mst_freq").toString());
							}
					 }
					 
					 
				 }
				 
		// System.out.println("updatedfreq"+updatedfreq);
				 
				 if(updatedfreq>0){
					 
					 List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{resObj.getReservoirId(),resObj.getDutyFrequencyId(),resObj.getYear() , resObj.getTankId()});
             
					 if(result1!=null){
						 
						 for (Map<String, Object> row : result1) {
							 mstoutput.setMstOldId(Integer.parseInt(row.get("res_ann1_mst1_id").toString())); ;
							}
					 }
					 
					 
				 }
				 
				 
				 /*resObj.get(0).getResStatusId(),*/
				 
				 if(updatedfreq<1){
			/*	if (resObj.size() > 0) {*/
					if(resObj.getDutyFrequencyId()!=null  ){
						
						// System.out.println("coming here"+updatedfreq);
						 List<Map<String, Object>> result2 = jdbcTemplate8.queryForList(sql3,resObj.getUnitId(),resObj.getCircleId(), resObj.getDivisionId(),
								 resObj.getSubdivisionId(),resObj.getProjectId(),resObj.getReservoirId(),resObj.getUserName(),
								 resObj.getDutyFrequencyId(),resObj.getYear(),resObj.getEmpId(),resObj.getSectionId(), resObj.getPostId(),resObj.getConditionofDamId(),resObj.getTankId() );	
						 
						 
						 if(result2!=null){
							 
							 for (Map<String, Object> row : result2) {
								 mstoutput.setMstNewId(Integer.parseInt(row.get("res_ann1_mst1_id").toString()));
								}
							 
							// System.out.println("mst1outputdao"+mst1output);
						 }
					}
					
				/*}*/
			
			 }
			 }
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mstoutput;
	}
	
	
	
	@Override
	public Integer insertresAnn1inspectMst2(final List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_RES_ANN1_MST2;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		final Integer olddictId=0;
		final Integer waterlevelinspect=0;
		final Integer capacity=0;
		final Integer mitankinspectapprovId=0;
	
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
             	
				
				 
				// System.out.println("dao"+miObj.get(0).getMiInpsectMst1Id());
				if (resObj.size() > 0) {
					if(resObj.get(0).getResInspectMst1Id()!=null  ){
					j = jdbcTemplate8.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
									
											
										

									ReservoirInspect sd = resObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());

									ps.setInt(1,  resObj.get(0).getResInspectMst1Id());
									
									ps.setString(2,  resObj.get(0).getResCode());
										ps.setInt(3,  sd.getResCheckId());
										ps.setInt(4,  sd.getResCatId());
										ps.setInt(5,  resObj.get(0).getDesignationId());
								
										 java.sql.Date date1 = null;
										try {
											
											if (resObj.get(0).getInspectDate()!= null
													&& resObj.get(0).getInspectDate() != ""
													&& !resObj.get(0).getInspectDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( resObj.get(0).getInspectDate());
											
											// System.out.println("date1from mst2"+date1);
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										 
									
											ps.setDate(6, date1);
										
											ps.setInt(7, resObj.get(0).getApprovStatusId());
										
										
											ps.setString(8, resObj.get(0).getUserName());
											//ps.setInt(18, miObj.get(0).getUserId());
											
											ps.setString(9, resObj.get(0).getUserEmpId());
											
											ps.setString(10, sd.getRemarks());
											
											ps.setInt(11, sd.getTabId());
											ps.setInt(12, sd.getEmpId());
											ps.setInt(13, sd.getReservoirId());
											ps.setLong(14, sd.getPostId());
											ps.setInt(15, sd.getSectionId());
											
	
								}

								@Override
								public int getBatchSize() {
									return resObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer insertNrldAnninspectMst2(final ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_NRLD_ANN_MST2;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		final Integer olddictId=0;
		final Integer waterlevelinspect=0;
		final Integer capacity=0;
		final Integer mitankinspectapprovId=0;
	
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				 

				 if (resObj!=null) {
						if(resObj.getResInspectMst1Id()!=null  ){
							
							// System.out.println("coming here"+updatedfreq);
							filerows = jdbcTemplate8.update(sql3,resObj.getResInspectMst1Id(), resObj.getResCheckId(), resObj.getResCatId(),
									 resObj.getDesignationId(),resObj.getApprovStatusId(),resObj.getUserName(),resObj.getRemarks(),
									 resObj.getTabId(),resObj.getEmpId(), resObj.getReservoirId(),resObj.getPostId(),resObj.getAnnexureId(), resObj.getIrrChFrm(),resObj.getIrrChTo(),
									 resObj.getInstalledcount(),
									 resObj.getLocation(),
									 resObj.getInstallmonth(),
									 resObj.getWorkingcondition(),
									 resObj.getDatelastCalibrated(),
									 resObj.getDatenextCalibrated(),
									 resObj.getObsmaintained(),
									 resObj.getAgencyresponsible(),
									 resObj.getAnalysisofdata(),
									 resObj.getDatasenttoDSO(),
									 resObj.getDamcheckResponseId(),
									 resObj.getResCheckName(),
									 resObj.getConditionofCheckId()
									 );	
							 
							 
							
						}	
						
					}
					 
					 
				 
             	
				
				 
			
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			 }	
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filerows;
	}
	
	
	@Override
	public MstOutputWithFlag inserprevtNrldAnnMst1(final ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 =INSERT_PREV_NRLD_ANN_MST1; 
		
		String sql2=GET_NRLD_ANN_FREQ; 
		
		String sql4=GET_NRLD_ANN_MST1_ID; 
		
		
	
		
		
		Integer updatedfreq=0;
		Integer rows1=0;
		Integer olddictId=0;
		
		MstOutputWithFlag mstoutput = new MstOutputWithFlag();
		
	Integer mst1output=0;
		
		 
		
		try {
			
			//System.out.println("resObj.getReservoirId()"+resObj.getReservoirId()+" ttest"+sql3);

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			
			
			 if(resObj!=null){
				 
				 
				 java.sql.Date date1 = null;
				
						
					
             	
				
				 if(resObj.getReservoirId()!=null && resObj.getDutyFrequencyId()!=null && resObj.getYear()!=null && resObj.getTankId()!=null  ){
				
					 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2, new Object[]{resObj.getYear(),resObj.getReservoirId(),resObj.getDutyFrequencyId(),resObj.getTankId()});
					 
					 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("res_ann1_mst_freq").toString());
							}
					 }
					 
					 
				 }
				 
		// System.out.println("updatedfreq"+updatedfreq);
				 
				 if(updatedfreq>0){
					 
					 List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{resObj.getReservoirId(),resObj.getDutyFrequencyId(),resObj.getYear() , resObj.getTankId()});
             
					 if(result1!=null){
						 
						 for (Map<String, Object> row : result1) {
							 mstoutput.setMstOldId(Integer.parseInt(row.get("res_ann1_mst1_id").toString())); ;
							}
					 }
					 
					 
				 }
				 
				 
				 /*resObj.get(0).getResStatusId(),*/
				 
				 if(updatedfreq<1){
			/*	if (resObj.size() > 0) {*/
					if(resObj.getDutyFrequencyId()!=null  ){
						
						// System.out.println("coming here"+updatedfreq);
						 List<Map<String, Object>> result2 = jdbcTemplate8.queryForList(sql3,resObj.getUnitId(),resObj.getCircleId(), resObj.getDivisionId(),
								 resObj.getSubdivisionId(),resObj.getUserName(),
								 resObj.getDutyFrequencyId(),resObj.getYear(),resObj.getEmpId(),resObj.getSectionId(), resObj.getPostId(),resObj.getReservoirId(),resObj.getTankId(),resObj.getPrevYear(),resObj.getPrevFreq() );	
						 
						 
						 if(result2!=null){
							 
							 for (Map<String, Object> row : result2) {
								 mstoutput.setMstNewId(Integer.parseInt(row.get("res_ann1_mst1_id").toString()));
								}
							 
							// System.out.println("mst1outputdao"+mst1output);
						 }
					}
					
				/*}*/
			
			 }
			 }
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mstoutput;
	}
	
	
	@Override
	public Integer insertPrevNrldAnninspectMst2(final ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_PREV_NRLD_ANN_MST2;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		final Integer olddictId=0;
		final Integer waterlevelinspect=0;
		final Integer capacity=0;
		final Integer mitankinspectapprovId=0;
	
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				 

				 if (resObj!=null) {
						if(resObj.getResInspectMst1Id()!=null  ){
							
							// System.out.println("coming here"+updatedfreq);
							filerows = jdbcTemplate8.update(sql3,resObj.getResInspectMst1Id(), 
									 resObj.getDesignationId(),resObj.getUserName(),resObj.getEmpId(),resObj.getPostId(),
									 resObj.getPrevResInspectMst1Id(),resObj.getResInspectMst1Id()
									 );	
							 
							 
							
						}	
						
					}
					 
					 
				 
             	
				
				 
			
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			 }	
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filerows;
	}
	
	
	@Override
	public List<ReservoirInspect> getPrevAnnMst1IdByNewMst1Id(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_PREV_MST1ID_BYNEWMST1ID;
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{mst1Id},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
						
							resInspect.setResInspectMst1Id(rs.getInt(1));
							resInspect.setPrevResInspectMst1Id(rs.getInt(2));
							
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<ReservoirInspect> getAnnMst1IdByYearandMonsoonMst1Id(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_MST1ID_BYYEARMONSOONMST1ID;
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{resobj.getYear(),resobj.getDutyFrequencyId(),resobj.getReservoirId(),resobj.getTankId()},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
						
							resInspect.setResInspectMst1Id(rs.getInt(1));
							resInspect.setYear(rs.getInt(2));
							resInspect.setDutyFrequencyId(rs.getInt(3));
							resInspect.setReservoirId(rs.getInt(4));
							resInspect.setTankId(rs.getInt(5));
							resInspect.setPrevResInspectMst1Id(rs.getInt(6));
							
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
/*	@Override
	public Integer insertNrldAnnMst1Remarks(final ReservoirInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_NRLD_ANN_MST1_REMARKS;		// query not in db queries 
		
		String sql2 = UPDATE_OLD_NRLD_ANN_MST1_REMARKS;		 // query not in db queries 
		
		
		
Integer rows1=0;
Integer rows2=0;
		
String Remarks =null;
		
	
		
	
	
		
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				 if(miObj.getResInspectMst1Id()!=null && miObj.getLevelId()!=null){
					
					 rows2 = jdbcTemplate8.update(sql2,miObj.getUserName(),miObj.getTabId(),miObj.getResInspectMst1Id(),miObj.getLevelId()  );	
					 
				 }
			
					 if( miObj.getResInspectMst1Id()!=null && miObj.getLevelId()!=null && miObj.getReservoirId()!=null ){
						 
						
						 
						 rows1 = jdbcTemplate8.update(sql3,miObj.getResInspectMst1Id(),miObj.getReservoirId(),miObj.getUserName(),
								miObj.getUnitId(),miObj.getCircleId(),
								miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getProjectId(),
								miObj.getDesignationId(),miObj.getLevelId(),miObj.getNextEmpId(),Remarks,miObj.getTabId(),miObj.getEmpId(),miObj.getPostId(),miObj.getNextPostId(),miObj.getSectionId());	
						 
						 
										
				
					
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}*/
	
	
	
	public Integer insertResAnn1Mst1Remarks(final ReservoirInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_RES_ANN1_MST1_REMARKS;		// query not in db queries 
		
		String sql2 = UPDATE_OLD_RES_ANN1_MST1_REMARKS;		 // query not in db queries 
		
		
		
Integer rows1=0;
Integer rows2=0;
		
String Remarks =null;
		
	
		
		java.sql.Date date1 = null;
		
	///	System.out.println("getremarks"+miObj.getEmbRemarks());
		//System.out.println("getsluremarks"+miObj.getSluRemarks());
		//System.out.println("getweirremarks"+miObj.getWeirRemarks());
//		System.out.println("getnextempid"+miObj.getNextEmpId());
		if(miObj.getTabId()==1){
		Remarks=miObj.getGenRemarks();
		}
		if(miObj.getTabId()==2){
		Remarks=miObj.getErRemarks();
		}
		if(miObj.getTabId()==3){
		Remarks=miObj.getCmRemarks();
		}
		if(miObj.getTabId()==4){
			Remarks=miObj.getOmRemarks();
			}
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				 if(miObj.getResInspectMst1Id()!=null && miObj.getLevelId()!=null){
					
					 rows2 = jdbcTemplate8.update(sql2,miObj.getUserName(),miObj.getTabId(),miObj.getResInspectMst1Id(),miObj.getLevelId()  );	
					 
				 }
			
					 if( miObj.getResInspectMst1Id()!=null && miObj.getLevelId()!=null && miObj.getResCode()!=null ){
						 
						// System.out.println("miObj.getResInspectMst1Id()"+miObj.getResInspectMst1Id());
						 
						 rows1 = jdbcTemplate8.update(sql3,miObj.getResInspectMst1Id(),miObj.getResCode(),miObj.getReservoirId(),miObj.getUserName(),
								miObj.getUnitId(),miObj.getCircleId(),
								miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getProjectId(),
								miObj.getDesignationId(),miObj.getLevelId(),miObj.getNextEmpId(),Remarks,miObj.getTabId(),miObj.getEmpId(),miObj.getPostId(),miObj.getNextPostId(),miObj.getSectionId(),miObj.getNextEmpId());	
						 
						 
										
				
					
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public List<ReservoirInspect> getResAnn1mst2IdByMst1Id(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_RESANN1MST2_BY_MST1ID;
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{mst1Id},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
							resInspect.setResInspectMst2Id(rs.getInt(1));
							resInspect.setResInspectMst1Id(rs.getInt(2));
							resInspect.setResCode(rs.getString(3));
							resInspect.setResCheckId(rs.getInt(4));
							resInspect.setResCatId(rs.getInt(5));
							resInspect.setDesignationId(rs.getInt(6));
							resInspect.setInspectDate(rs.getString(7));
							resInspect.setApprovStatusId(rs.getInt(8));
							resInspect.setUserId(rs.getInt(9));
							resInspect.setUserName(rs.getString(10));
							resInspect.setUserEmpId(rs.getString(11));
							resInspect.setRemarks(rs.getString(12));
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<ReservoirInspect> getNrldAnnmst2IdByMst1Id(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_NRLD_ANN_MST2_BY_MST1ID;
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{mst1Id},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
							resInspect.setResInspectMst2Id(rs.getInt(1));
							resInspect.setResInspectMst1Id(rs.getInt(2));
							//resInspect.setResCode(rs.getString(3));
							resInspect.setResCheckId(rs.getInt(3));
							resInspect.setResCatId(rs.getInt(4));
							resInspect.setDesignationId(rs.getInt(5));
							//resInspect.setInspectDate(rs.getString(7));
							resInspect.setApprovStatusId(rs.getInt(6));
							//resInspect.setUserId(rs.getInt(7));
							resInspect.setUserName(rs.getString(7));
							//resInspect.setUserEmpId(rs.getString(11));
							resInspect.setRemarks(rs.getString(8));
							
							resInspect.setAnnexureId(rs.getInt(9));
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirSalient> getInvomResList(Integer unitId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_INVOM_RESERVOIRS;
		try {
			
			//System.out.println("sql"+sql+"unitId"+unitId);

			List<ReservoirSalient> ReservoirSalientList = jdbcTemplate8.query(sql,new Object[]{unitId},
					new RowMapper<ReservoirSalient>() {

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirSalient reservoirSalient = new ReservoirSalient();
							//reservoirSalient.setResCode(rs.getString(1));
							reservoirSalient.setResName(rs.getString(1));
							reservoirSalient.setReservoirId(rs.getInt(2));
							reservoirSalient.setUnitId(rs.getInt(3));
							reservoirSalient.setProjectId(rs.getInt(4));
							reservoirSalient.setDistrictId(rs.getInt(5));
							reservoirSalient.setMandalId(rs.getInt(6));
							reservoirSalient.setVillageId(rs.getInt(7));
							reservoirSalient.setRemarksVillage(rs.getString(8));
							reservoirSalient.setDistrictName(rs.getString(9));
							reservoirSalient.setMandalName(rs.getString(10));
							reservoirSalient.setVillageName(rs.getString(11));
							reservoirSalient.setIsNrld(rs.getBoolean(12));
							reservoirSalient.setNrldCode(rs.getString(13));
							return reservoirSalient;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	@Override
	public List<ReservoirSalient> getInvomResListAdmin(Integer unitId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_INVOM_RESERVOIRS_ADMIN;
		try {
			
			//System.out.println("sql"+sql+"unitId"+unitId);

			List<ReservoirSalient> ReservoirSalientList = jdbcTemplate8.query(sql,new Object[]{},
					new RowMapper<ReservoirSalient>() {

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirSalient reservoirSalient = new ReservoirSalient();
							//reservoirSalient.setResCode(rs.getString(1));
							reservoirSalient.setResName(rs.getString(1));
							reservoirSalient.setReservoirId(rs.getInt(2));
							reservoirSalient.setUnitId(rs.getInt(3));
							reservoirSalient.setProjectId(rs.getInt(4));
							reservoirSalient.setDistrictId(rs.getInt(5));
							reservoirSalient.setMandalId(rs.getInt(6));
							reservoirSalient.setVillageId(rs.getInt(7));
							reservoirSalient.setRemarksVillage(rs.getString(8));
							reservoirSalient.setDistrictName(rs.getString(9));
							reservoirSalient.setMandalName(rs.getString(10));
							reservoirSalient.setVillageName(rs.getString(11));
							reservoirSalient.setIsNrld(rs.getBoolean(12));
							reservoirSalient.setNrldCode(rs.getString(13));
							return reservoirSalient;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	@Override
	public List<ReservoirSalient> getNrldResList(User user) throws InventoryUserException {
		// TODO Auto-generated method stub
	
		
		String sql =null;
		
		//String sql2=SELECT_IRDAM1_NRLD_RESERVOIRS;
		
		if(user!=null){
			
			if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null && user.getPost()!=null && (user.getDesignationId()==2 || user.getDesignationId()==8)){
				if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0 && user.getPost()>0 ){
				
			   sql=	SELECT_INVOM_NRLD_RESERVOIRS+" and irum.post_id="+user.getPost() +"  order by district_name,mandal_name,vname,res_name";
				}
				
				
			}
			
			if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null  && user.getSectionId()==0 && user.getDesignationId()==4  ){
				if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0  ){
				
			   sql=	SELECT_INVOM_NRLD_RESERVOIRS+"  and irum.division_id="+user.getDivisionId()+ " and irum.subdivision_id="+user.getSubdivisionId() +" order by district_name,mandal_name,vname,res_name";
				}
				
				
			}
			
			if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null  && user.getSubdivisionId()==0 &&  user.getSectionId()==0  ){
				if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 ){
				
			   sql=	SELECT_INVOM_NRLD_RESERVOIRS+" and irum.division_id="+user.getDivisionId() + "  order by district_name,mandal_name,vname,res_name";
				}
				
				
			}
			
			if(user.getUnitId()!=null && user.getCircleId()!=null && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0)   ){
				if(user.getUnitId()>0 && user.getCircleId()>0    ){
				
			   sql=	SELECT_INVOM_NRLD_RESERVOIRS+" and irum.circle_id="+user.getCircleId() +"  order by district_name,mandal_name,vname,res_name";
				}				
				
			}
			
			if(user.getUnitId()!=null && (user.getCircleId()==0) && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0) ){
				if(user.getUnitId()>0 &&  user.getUnitId()!=9  ){
				
			   sql=SELECT_INVOM_NRLD_RESERVOIRS+" and irum.unit_id="+user.getUnitId()+ "  order by district_name,mandal_name,vname,res_name";
				}		
				
				if(((user.getUnitId()==9) && ( user.getPost()==83125 || user.getPost()==83213 ||  user.getPost()==83266   ))   ){
					
					   sql=SELECT_INVOM_NRLD_RESERVOIRS+"  order by district_name,mandal_name,vname,res_name";
						}				
						
				
			}
			
			
			
			
			

			/*if((user.getUnitId()==9) && ( user.getPost()==83125 || user.getPost()==83213 ||  user.getPost()==83266  || user.getPost()==931 || user.getPost()==932 || user.getPost()==921 || user.getPost()==911  ) ){
				
				sql=sql2+" where irdam1.unit_id= "+user.getUnitId()+"  order by district_name,mandal_name,vname,res_name" ;
			}
			*/
		}
		try {
			
		//	System.out.println("sql"+sql+"unitId"+user.getPost());

			List<ReservoirSalient> ReservoirSalientList = jdbcTemplate8.query(sql,new Object[]{ },
					new RowMapper<ReservoirSalient>() {

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirSalient reservoirSalient = new ReservoirSalient();
							//reservoirSalient.setResCode(rs.getString(1));
							reservoirSalient.setResName(rs.getString(1));
							reservoirSalient.setReservoirId(rs.getInt(2));
							reservoirSalient.setUnitId(rs.getInt(3));
							reservoirSalient.setProjectId(rs.getInt(4));
							reservoirSalient.setDistrictId(rs.getInt(5));
							reservoirSalient.setMandalId(rs.getInt(6));
							reservoirSalient.setVillageId(rs.getInt(7));
							reservoirSalient.setRemarksVillage(rs.getString(8));
							reservoirSalient.setDistrictName(rs.getString(9));
							reservoirSalient.setMandalName(rs.getString(10));
							reservoirSalient.setVillageName(rs.getString(11));
							reservoirSalient.setIsNrld(rs.getBoolean(12));
							reservoirSalient.setNrldCode(rs.getString(13));
							return reservoirSalient;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("ReservoirSalientList"+ReservoirSalientList);
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<Project> getNrldProjectList(User user) throws InventoryUserException {
		
String sql =null;
		
		if(user!=null){
			
			
			
			
			
			
			
			
			if(user.getUnitId()!=null && (user.getCircleId()!=null) && (user.getDivisionId()!=null)  && (user.getSubdivisionId()!=null) && ( user.getSectionId()!=null) ){
				if(user.getUnitId()>0 &&  user.getUnitId()!=9  ){
				
			   sql=SELECT_PROJECTS_NRLD+"  and pum.unit_id="+user.getUnitId()+" order by project_name";
				}		
				
				if(((user.getUnitId()==9) && ( user.getPost()==83125 || user.getPost()==83213 ||  user.getPost()==83266   ))  ){
					
					   sql=SELECT_PROJECTS_NRLD+"  order by project_name";
						}				
						
				
			}
			
		}
		
		try {

			List<Project> projectList = jdbcTemplate.query(sql,new Object[] {  },
					new RowMapper<Project>() {

						public Project mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Project project = new Project();
							project.setProjectId(rs.getInt(1));
							project.setProjectName(rs.getString(2));
							return project;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return projectList;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return null;
		}
	}
	
	
	

	@Override
	public Integer  insertResinspectann2(final List<ReservoirInspect> resObj) throws InventoryUserException  {
		// TODO Auto-generated method stub
		
		String sql3 =INSERT_RES_INSPECT_ANN2 ;
				
				// +INSERT_RES_INSPECT_ANN1_APP;
				
				 

		 int[] rows=null;
		 
		 Integer len=0;
		
		
		
		final Integer status=1;
	
		
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
             	
				 
			
				
				// batchArgs, batchSize, pss)(sql3,
				 
				if (resObj.size() > 0) {
					
				//	System.out.println("  sql3"+ sql3);
					if(resObj.get(0).getResCode()!=null  ){
						rows=jdbcTemplate8.batchUpdate(sql3,new BatchPreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps, int i)
									throws SQLException {	
											
										

									ReservoirInspect sd = resObj.get(i);
									
									 
									///System.out.println(" sd.getResCheckId()"+  sd.getResCheckId());

								
										ps.setLong(1, sd.getResCheckId() );
										
										ps.setInt(2,  sd.getResCatId());
										ps.setInt(3,   sd.getUnitId());
										ps.setInt(4,    sd.getCircleId());
										ps.setInt(5,   sd.getDivisionId());
										ps.setInt(6,   sd.getSubdivisionId());
										ps.setInt(7,   sd.getDesignationId());
										ps.setInt(8,   sd.getUserId());
										ps.setString(9,    sd.getUserName());
										
										 java.sql.Date date1 = null;
											try {
												
												if (sd.getInspectDate()!= null
														&& sd.getInspectDate() != ""
														&& !sd.getInspectDate().equals('0')) {
												
												date1 = DateUtil.getSQLDate( sd.getInspectDate());
												}
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											 
										ps.setDate(10,   date1);
										ps.setInt(11,    sd.getProjectId());
										ps.setString(12, sd.getResCode());
									
										ps.setString(13, sd.getRemarks());
										ps.setInt(14, sd.getApprovStatusId());
										ps.setInt(15, sd.getYear());
										
									
									//	System.out.println("i am breaking here");
	
										
										
									

									
								}

								@Override
								public int getBatchSize() {
									// TODO Auto-generated method stub
									return resObj.size();
								}
								

								
							});
					
					}
				}
			}
		      
		
			
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			if(rows!=null)	{
				
				len=rows.length;
				
			}
			

		}
		
        catch (SQLException e) {
			
		//	System.out.println("error"+e.getErrorCode()+"======"+e.fillInStackTrace()+"-----"+e.getLocalizedMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}

		return len;
	}
	
	
	
	@Override
	public MstOutputWithFlag insertResAnn2Mst1(final List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_RES_ANN2_MST1;
		
		String sql2=GET_RES_ANN2_FREQ;
		
		String sql4=GET_RES_ANN2_MST1_ID;

		
		
		
		Integer updatedfreq=0;
		Integer rows1=0;
		Integer olddictId=0;
		
		MstOutputWithFlag mstoutput = new MstOutputWithFlag();
		
	Integer mst1output=0;
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
             	
				
				 if(resObj.get(0).getResCode()!=null && resObj.get(0).getDutyFrequencyId()!=null && resObj.get(0).getYear()!=null){
				
					 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2, new Object[]{resObj.get(0).getYear(),resObj.get(0).getResCode(),resObj.get(0).getDutyFrequencyId()});
					 
					 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("res_ann2_mst_freq").toString());
							}
					 }
					 
					 
				 }
				 
			// System.out.println("updatedfreq"+updatedfreq);
				 
				 if(updatedfreq>0){
					 
					 List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{resObj.get(0).getResCode(),resObj.get(0).getDutyFrequencyId(),resObj.get(0).getYear()});
             
					 if(result1!=null){
						 
						 for (Map<String, Object> row : result1) {
							 mstoutput.setMstOldId(Integer.parseInt(row.get("res_ann2_mst1_id").toString())); ;
							}
					 }
					 
					 
				 }
				 
				 
				 
				 
				 if(updatedfreq<1){
				if (resObj.size() > 0) {
					if(resObj.get(0).getDutyFrequencyId()!=null  ){
						
						// System.out.println("coming here"+updatedfreq);
						 List<Map<String, Object>> result2 = jdbcTemplate8.queryForList(sql3,resObj.get(0).getUnitId(),resObj.get(0).getCircleId(), resObj.get(0).getDivisionId(),
								 resObj.get(0).getSubdivisionId(),resObj.get(0).getResCode(),resObj.get(0).getProjectId(),resObj.get(0).getReservoirId(),resObj.get(0).getUserId(),resObj.get(0).getUserName(),
								 resObj.get(0).getDutyFrequencyId(),resObj.get(0).getYear(),resObj.get(0).getUserEmpId() );	
						 
						 
						 if(result2!=null){
							 
							 for (Map<String, Object> row : result2) {
								 mstoutput.setMstNewId(Integer.parseInt(row.get("res_ann2_mst1_id").toString()));
								}
							 
							// System.out.println("mst1outputdao"+mst1output);
						 }
					}	
					
				}
			
			 }
			 }
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mstoutput;
	}
	
	
	
	@Override
	public Integer insertresAnn2inspectMst2(final List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_RES_ANN2_MST2;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		final Integer olddictId=0;
		final Integer waterlevelinspect=0;
		final Integer capacity=0;
		final Integer mitankinspectapprovId=0;
	
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
             	
				
				 
				// System.out.println("dao"+miObj.get(0).getMiInpsectMst1Id());
				if (resObj.size() > 0) {
					if(resObj.get(0).getResInspectMst1Id()!=null  ){
					j = jdbcTemplate8.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
									
											
										

									ReservoirInspect sd = resObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());

									ps.setInt(1,  resObj.get(0).getResInspectMst1Id());
									
									ps.setString(2,  resObj.get(0).getResCode());
										ps.setInt(3,  sd.getResCheckId());
										ps.setInt(4,  sd.getResCatId());
										ps.setInt(5,  resObj.get(0).getDesignationId());
								
										 java.sql.Date date1 = null;
										try {
											
											if (sd.getInspectDate()!= null
													&& sd.getInspectDate() != ""
													&& !sd.getInspectDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( sd.getInspectDate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										 
									
											ps.setDate(6, date1);
										
											ps.setInt(7, resObj.get(0).getApprovStatusId());
										
											ps.setInt(8, resObj.get(0).getUserId());
											ps.setString(9, resObj.get(0).getUserName());
											//ps.setInt(18, miObj.get(0).getUserId());
											
											ps.setString(10, resObj.get(0).getUserEmpId());
											
											ps.setString(11, sd.getRemarks());
											
	
								}

								@Override
								public int getBatchSize() {
									return resObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public List<ReservoirInspect> getResAnn2mst2IdByMst1Id(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_RESANN2MST2_BY_MST1ID;
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{mst1Id},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
							resInspect.setResInspectMst2Id(rs.getInt(1));
							resInspect.setResInspectMst1Id(rs.getInt(2));
							resInspect.setResCode(rs.getString(3));
							resInspect.setResCheckId(rs.getInt(4));
							resInspect.setResCatId(rs.getInt(5));
							resInspect.setDesignationId(rs.getInt(6));
							resInspect.setInspectDate(rs.getString(7));
							resInspect.setApprovStatusId(rs.getInt(8));
							resInspect.setUserId(rs.getInt(9));
							resInspect.setUserName(rs.getString(10));
							resInspect.setUserEmpId(rs.getString(11));
							resInspect.setRemarks(rs.getString(12));
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public Integer  insertResDamDutyinspect(final List<ScheduleDuty> resObj) throws InventoryUserException  {
		// TODO Auto-generated method stub
		
		String sql3 =INSERT_RES_DAM_DUTY_INSPECT ;
				
				// +INSERT_RES_INSPECT_ANN1_APP;
				
				 

		 int[] rows=null;
		 
		 Integer len=0;
		
		
		
		final Integer status=1;
	
		
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
             	
				 
			
				
				// batchArgs, batchSize, pss)(sql3,
				 
				if (resObj.size() > 0) {
					
				//	System.out.println("  sql3"+ sql3);
					if(resObj.get(0).getResCode()!=null  ){
						rows=jdbcTemplate8.batchUpdate(sql3,new BatchPreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps, int i)
									throws SQLException {	
											
										

								   ScheduleDuty sd = resObj.get(i);
									
									 
									///System.out.println(" sd.getResCheckId()"+  sd.getResCheckId());

								
										ps.setString(1, sd.getResCode() );								
									
										ps.setInt(2,   sd.getUnitId());
										ps.setInt(3,    sd.getCircleId());
										ps.setInt(4,   sd.getDivisionId());
										ps.setInt(5,   sd.getSubdivisionId());
										ps.setInt(6,   sd.getProjectId());
										ps.setInt(7,   sd.getDutyId());
										ps.setInt(8,    sd.getParentDutyId());
										
										 java.sql.Date date1 = null;
											try {
												
												if (sd.getInspectDate()!= null
														&& sd.getInspectDate() != ""
														&& !sd.getInspectDate().equals('0')) {
												
												date1 = DateUtil.getSQLDate( sd.getInspectDate());
												}
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											 
										ps.setDate(9,   date1);
										ps.setInt(10,    sd.getDutyFrequencyId());
										ps.setInt(11, sd.getDutyDesignationMapId());
									
										ps.setInt(12, sd.getDesignationId());
										ps.setBoolean(13, false);
										ps.setString(14, sd.getRemarks());
										ps.setInt(15, sd.getApproveStatusId());
										ps.setBoolean(16, sd.getActionId());
										ps.setInt(17, sd.getActionReqId());
										ps.setInt(18 ,sd.getUserId());
										ps.setString(19,  sd.getUserName());
									
										
									
									//	System.out.println("i am breaking here");
	
										
										
									

									
								}

								@Override
								public int getBatchSize() {
									// TODO Auto-generated method stub
									return resObj.size();
								}
								

								
							});
					
					}
				}
			}
		      
		
			
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			if(rows!=null)	{
				
				len=rows.length;
				
			}
			

		}
		
        catch (SQLException e) {
			
			//System.out.println("error"+e.getErrorCode()+"======"+e.fillInStackTrace()+"-----"+e.getLocalizedMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}

		return len;
	}
	
	
	@Override
	public List<PumpStations> getBasinData( ) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_BASIN_DATA;
		try {

			List<PumpStations> ReservoirSalientList = jdbcTemplate8.query(sql ,
					new RowMapper<PumpStations>() {

						public PumpStations mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PumpStations pumpstation = new PumpStations();
							pumpstation.setBasinId(rs.getInt(1));
							pumpstation.setBasinName(rs.getString(2));
							
							
							return pumpstation;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<PumpStations> getPumpLinks( ) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_PUMP_LINKS;
		try {

			List<PumpStations> ReservoirSalientList = jdbcTemplate8.query(sql ,
					new RowMapper<PumpStations>() {

						public PumpStations mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PumpStations pumpstation = new PumpStations();
							pumpstation.setPumpLinkId(rs.getInt(1));
							pumpstation.setPumpLink(rs.getString(2));
							pumpstation.setBasinId(rs.getInt(3));
							
							
							return pumpstation;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<PumpStations> getPumpStations(Integer pumpLinkId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_PUMP_STATIONS;
		try {

			List<PumpStations> ReservoirSalientList = jdbcTemplate8.query(sql ,new Object[]{pumpLinkId},
					new RowMapper<PumpStations>() {

						public PumpStations mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PumpStations pumpstation = new PumpStations();
							pumpstation.setPumpStationId(rs.getInt(1));
							pumpstation.setPumpStation(rs.getString(2));
							pumpstation.setPumpLinkId(rs.getInt(3));
							pumpstation.setUnitId(rs.getInt(4));
							pumpstation.setCircleId(rs.getInt(5));
							pumpstation.setDivisionId(rs.getInt(6));
							pumpstation.setSubdivisionId(rs.getInt(7));
							
							
							
							return pumpstation;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	
	
	@Override
	public Integer  insertpumpMainActivityInspect(final List<PumpMaintainActivities> pumpObj) throws InventoryUserException  {
		// TODO Auto-generated method stub
		
		String sql3 =INSERT_PUMP_MAIN_ACTIVITY_INSPECT ;
				
				// +INSERT_RES_INSPECT_ANN1_APP;
				
				 

		 int[] rows=null;
		 
		 Integer len=0;
		
		
		
		final Integer status=1;
	
		
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(pumpObj!=null){
             	
				 
			
				
				// batchArgs, batchSize, pss)(sql3,
				 
				if (pumpObj.size() > 0) {
					
				//	System.out.println("  sql3"+ sql3);
					if(pumpObj.get(0).getPumpStationId()!=null  ){
						rows=jdbcTemplate8.batchUpdate(sql3,new BatchPreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps, int i)
									throws SQLException {	
											
										

								PumpMaintainActivities sd = pumpObj.get(i);
									
									 
									///System.out.println(" sd.getResCheckId()"+  sd.getResCheckId());

								
																		
									
										ps.setInt(1,   sd.getUnitId());
										ps.setInt(2,    sd.getCircleId());
										ps.setInt(3,   sd.getDivisionId());
										ps.setInt(4,   sd.getSubdivisionId());
										ps.setInt(5,   sd.getProjectId());
										ps.setInt(6,   sd.getPmActivityId());
										ps.setInt(7,    sd.getBasinId());
										
										ps.setInt(8,    sd.getPumpLinkId());
										ps.setInt(9,    sd.getPumpStationId());
										
										
										 java.sql.Date date1 = null;
											try {
												
												if (sd.getInspectDate()!= null
														&& sd.getInspectDate() !=""
														&& !sd.getInspectDate().equals('0')) {
												
												date1 = DateUtil.getSQLDate( sd.getInspectDate());
												}
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											 
										ps.setDate(10,   date1);
										ps.setInt(11,    sd.getDutyFrequencyId());
										
									
										ps.setInt(12, sd.getDesignationId());
										ps.setBoolean(13, false);
										ps.setString(14, sd.getRemarks());
										ps.setInt(15, sd.getApproveStatusId());
										
										ps.setInt(16 ,sd.getUserId());
										ps.setString(17,  sd.getUserName());
										
										ps.setInt(18 ,sd.getInspectHour());
									
										
									
									//	System.out.println("i am breaking here");
	
										
										
									

									
								}

								@Override
								public int getBatchSize() {
									// TODO Auto-generated method stub
									return pumpObj.size();
								}
								

								
							});
					
					}
				}
			}
		      
		
			
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			if(rows!=null)	{
				
				len=rows.length;
				
			}
			

		}
		
        catch (SQLException e) {
			
			//System.out.println("error"+e.getErrorCode()+"======"+e.fillInStackTrace()+"-----"+e.getLocalizedMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}

		return len;
	}
	
	
	@Override
	public List<MiTankInspect> getMimst2IdByMst1Id(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_MIMST2ID_BY_MST1ID;
		try {

			List<MiTankInspect> ReservoirSalientList = jdbcTemplate8.query(sql ,new Object[]{mst1Id},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							mitankinspect.setMiInpsectMst2Id(rs.getInt(1));
							mitankinspect.setMiInpsectMst1Id(rs.getInt(2));
							mitankinspect.setUnitId(rs.getInt(3));
							mitankinspect.setCircleId(rs.getInt(4));
							mitankinspect.setDivisionId(rs.getInt(5));
							mitankinspect.setSubdivisionId(rs.getInt(6));
							mitankinspect.setProjectId(rs.getInt(7));
							mitankinspect.setMiInspectMapId(rs.getInt(8));
							mitankinspect.setInspectDate(rs.getString(9));
							
							mitankinspect.setWaterLevelInspect(rs.getInt(10));
							mitankinspect.setCapacitymcft(rs.getInt(11));
							mitankinspect.setActionrequireqId(rs.getInt(12));
							mitankinspect.setDesignationId(rs.getInt(13));
							mitankinspect.setRemarks(rs.getString(14));
							mitankinspect.setTankInspectApproveId(rs.getInt(15));
							mitankinspect.setTankWeirSluiceId(rs.getInt(16));
							mitankinspect.setActionreq(rs.getBoolean(17));
							mitankinspect.setMiInspectTypeId(rs.getInt(18));
							mitankinspect.setMiCompId(rs.getInt(19));
							mitankinspect.setUserName(rs.getString(20));
							mitankinspect.setUserEmpId(rs.getString(21));
							mitankinspect.setTankId(rs.getLong(22));
							
							
							
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<MiTankInspect> getMimst2IdByYearFreq(Integer year, Long tankId, Integer miTankFreqId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_MIMST2ID_BY_YEAR_FREQ;
		try {
			
			//System.out.println("rs.getInt(23)");	
			

			List<MiTankInspect> ReservoirSalientList = jdbcTemplate8.query(sql ,new Object[]{year,miTankFreqId,tankId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
							//System.out.println("rs.getInt(1)"+rs.getInt(1));	
							
							mitankinspect.setMiInpsectMst2Id(rs.getInt(1));
							mitankinspect.setMiInpsectMst1Id(rs.getInt(2));
							mitankinspect.setUnitId(rs.getInt(3));
							mitankinspect.setCircleId(rs.getInt(4));
							mitankinspect.setDivisionId(rs.getInt(5));
							mitankinspect.setSubdivisionId(rs.getInt(6));
							mitankinspect.setProjectId(rs.getInt(7));
							mitankinspect.setMiInspectMapId(rs.getInt(8));
							mitankinspect.setInspectDate(rs.getString(9));
							
							mitankinspect.setWaterLevelInspect(rs.getInt(10));
							mitankinspect.setCapacitymcft(rs.getInt(11));
							mitankinspect.setActionrequireqId(rs.getInt(12));
							mitankinspect.setDesignationId(rs.getInt(13));
							mitankinspect.setRemarks(rs.getString(14));
							mitankinspect.setTankInspectApproveId(rs.getInt(15));
							mitankinspect.setTankWeirSluiceId(rs.getInt(16));
							mitankinspect.setActionreq(rs.getBoolean(17));
							mitankinspect.setMiInspectTypeId(rs.getInt(18));
							mitankinspect.setMiCompId(rs.getInt(19));
							mitankinspect.setUserName(rs.getString(20));
							mitankinspect.setPostId(rs.getLong(22));
							mitankinspect.setTankId(rs.getLong(23));
							
							mitankinspect.setTankStatusId(rs.getInt(24));
							
						
							
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	/*@Override
	public List<MiTankInspect> selectMiInoutBytankId(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_MI_INOUT;
		try {
			
			//System.out.println("SELECT_MI_INOUT"+SELECT_MI_INOUT);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{tankId},
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
	}*/
	
	@Override
	public List<MiTankInspect> getMiRepairs(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_MI_REPAIR;
		try {
			
			//System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{tankId},
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
							
							
							
						
							mitankinspect.setQuantity(rs.getDouble(7));
							mitankinspect.setAmount(rs.getDouble(8));
							mitankinspect.setSchemeTaken(rs.getString(9));
							
							mitankinspect.setUserName(rs.getString(10));
						
							mitankinspect.setUnitId(rs.getInt(11));
							mitankinspect.setCircleId(rs.getInt(12));
							mitankinspect.setDivisionId(rs.getInt(13));
							mitankinspect.setSubdivisionId(rs.getInt(14));
							
							mitankinspect.setDesignationId(rs.getInt(15));
							mitankinspect.setLevelId(rs.getInt(16));
							mitankinspect.setTankName(rs.getString(17));
							mitankinspect.setUnitName(rs.getString(18));
							mitankinspect.setCircleName(rs.getString(19));
							mitankinspect.setDivisionName(rs.getString(20));
							mitankinspect.setSubdivisionName(rs.getString(21));
							
							mitankinspect.setDesignation(rs.getString(22));
							mitankinspect.setDistrictName(rs.getString(23));
							mitankinspect.setMandalName(rs.getString(24));
							mitankinspect.setVillageName(rs.getString(25));
							mitankinspect.setMiCompName(rs.getString(26));
							mitankinspect.setRepairStartDate(rs.getString(27));
							mitankinspect.setRepairEndDate(rs.getString(28));
							mitankinspect.setEmpId(rs.getInt(29));
							mitankinspect.setPostId(rs.getLong(30));
							
						
							
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
	public List<MiTankInspect> getMiCapacity(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_MI_CAPACITY;
		
		try {
			
			//System.out.println("GET_MI_CAPACITY"+GET_MI_CAPACITY);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{tankId},
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
						//	mitankinspect.setRemarks(rs.getString(7));
					//		System.out.println("rs.getInspectDate"+mitankinspect.getInspectDate());
							mitankinspect.setUserName(rs.getString(7));
							
							mitankinspect.setUnitId(rs.getInt(8));
							mitankinspect.setCircleId(rs.getInt(9));
							mitankinspect.setDivisionId(rs.getInt(10));
							mitankinspect.setSubdivisionId(rs.getInt(11));
							
							mitankinspect.setDesignationId(rs.getInt(12));
							mitankinspect.setLevelId(rs.getInt(13));
							mitankinspect.setTankName(rs.getString(14));
							mitankinspect.setUnitName(rs.getString(15));
							mitankinspect.setCircleName(rs.getString(16));
							mitankinspect.setDivisionName(rs.getString(17));
							mitankinspect.setSubdivisionName(rs.getString(18));
						
							mitankinspect.setDesignation(rs.getString(19));
							mitankinspect.setDistrictName(rs.getString(20));
							mitankinspect.setMandalName(rs.getString(21));
							mitankinspect.setVillageName(rs.getString(22));
							
							mitankinspect.setPercentageCapacity(rs.getDouble(23));
							mitankinspect.setInflow(rs.getDouble(24));
							mitankinspect.setOutfow(rs.getDouble(25));
							mitankinspect.setAyacut(rs.getDouble(26));
							mitankinspect.setTankLevel(rs.getDouble(27));
						
							
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
	//		System.out.println("GET_MI_CAPACITY"+miinflowoutflow);
			return miinflowoutflow;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<EmpApprove> getEmployeeApprove(EmpApprove empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		 String sql = null;
		
		try {
			if(empObj!=null){
				if(empObj.getDesignationId()!=null){
					
					if((empObj.getDesignationId()==2||empObj.getDesignationId()==8) && (empObj.getUnitId()>0 )){
						sql=SELECT_DEE_IN_UNIT;
						
						//System.out.println("coming here");
						
					}
					
					if((empObj.getDesignationId()==4 && empObj.getUnitId()>0 )){
						
						empObj.setSubdivisionId(0);
						sql=SELECT_EE_IN_UNIT;
						
					}
					if((empObj.getDesignationId()==5 && empObj.getUnitId()>0 )){
						
						empObj.setDivisionId(0);
						empObj.setSubdivisionId(0);
						
						sql=SELECT_SE_IN_UNIT;
						
					}
					if(((empObj.getDesignationId()==7 || empObj.getDesignationId()==6) && empObj.getUnitId()>0 )){
						
						empObj.setDivisionId(0);
						empObj.setSubdivisionId(0);
						empObj.setCircleId(0);
						sql=SELECT_CE_ENC;
						
					}
					
					
				}	
				
			}
			
		//	userObj.getSubdivisionId(),userObj.getDivisionId(),userObj.getCircleId(),userObj.getUnitId()

			List<EmpApprove> getempApprove = jdbcTemplate8.query(sql ,new Object[]{empObj.getSubdivisionId(),empObj.getDivisionId(),empObj.getCircleId(),empObj.getUnitId(),empObj.getSubdivisionId(),empObj.getDivisionId(),empObj.getCircleId(),empObj.getUnitId(),empObj.getSubdivisionId(),empObj.getDivisionId(),empObj.getCircleId(),empObj.getUnitId()},
					new RowMapper<EmpApprove>() {

						public EmpApprove mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							EmpApprove empapprove = new EmpApprove();
							
				
							
							empapprove.setEmpId(rs.getInt(1));
							empapprove.setEmpName(rs.getString(2));
							empapprove.setDesignationId(rs.getInt(3));
							empapprove.setUnitId(rs.getInt(4));
							empapprove.setCircleId(rs.getInt(5));
							empapprove.setDivisionId(rs.getInt(6));
							empapprove.setSubdivisionId(rs.getInt(7));
							empapprove.setPostId(rs.getLong(8));
						
							
							return empapprove;
						}

					});
			
			
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return getempApprove;
			
			
			
		} catch (Exception exc) {
		
			return null;
		}
		
	}
	
	@Override
	public Integer insertResHealth(final List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_RES_HEALTH;
		
		

		
		
		
		
		Integer rows1=0;
		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
             	
				 if (resObj.get(0).getInspectDate()!= null
							&& resObj.get(0).getInspectDate() != ""
							&& !resObj.get(0).getInspectDate().equals('0')) {
					
					try {
						date1 = DateUtil.getSQLDate( resObj.get(0).getInspectDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
					
				if (resObj.size() > 0) {
					 if( resObj.get(0).getResCode()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,resObj.get(0).getResCode(),resObj.get(0).getResCategoryId(), resObj.get(0).getDesignationId(),
								 date1,resObj.get(0).getRemarks(),resObj.get(0).getUserId(),resObj.get(0).getUserName(),
								 resObj.get(0).getUserEmpId(),resObj.get(0).getUnitId(),resObj.get(0).getCircleId(),resObj.get(0).getDivisionId(),resObj.get(0).getSubdivisionId(),resObj.get(0).getProjectId(),resObj.get(0).getLevelId(),resObj.get(0).getRoleId() );	
						 
						 
										
					}	
					
				}
			
			 }
			 
			 
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer insertResRecommend(final List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_RES_RECOMMEND;
		
		

		
		
		
		
		Integer rows1=0;
		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
	             	
				 if (resObj.get(0).getInspectDate()!= null
							&& resObj.get(0).getInspectDate() != ""
							&& !resObj.get(0).getInspectDate().equals('0')) {
					
					try {
						date1 = DateUtil.getSQLDate( resObj.get(0).getInspectDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
					
				if (resObj.size() > 0) {
					 if( resObj.get(0).getResCode()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,resObj.get(0).getResCode(), date1,resObj.get(0).getRecomendbysdso(),resObj.get(0).getDesignationId(),
								 resObj.get(0).getUserId(),resObj.get(0).getUserName(), resObj.get(0).getUserEmpId(),
								 resObj.get(0).getUnitId(), resObj.get(0).getCircleId(),resObj.get(0).getDivisionId(),resObj.get(0).getSubdivisionId(),
								 resObj.get(0).getLevelId(),resObj.get(0).getProjectId(),resObj.get(0).getRoleId(),resObj.get(0).getResDamHealthId() );	
						 
						 
										
					}	
					
				}
			
			 }
			 
			 
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer insertResActiontaken(final List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_RES_ACTION_TAKEN;
		
		

		
		
		
		
		Integer rows1=0;
		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
	             	
				 if (resObj.get(0).getInspectDate()!= null
							&& resObj.get(0).getInspectDate() != ""
							&& !resObj.get(0).getInspectDate().equals('0')) {
					
					try {
						date1 = DateUtil.getSQLDate( resObj.get(0).getInspectDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
					
				if (resObj.size() > 0) {
					 if( resObj.get(0).getResCode()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,resObj.get(0).getResDamHealthId(),resObj.get(0).getResCode(),date1,resObj.get(0).getActionTakeninit(), resObj.get(0).getRemarks(),
								 resObj.get(0).getDesignationId(),resObj.get(0).getUserId(),resObj.get(0).getUserName(),
								 resObj.get(0).getUserEmpId(),resObj.get(0).getUnitId(),resObj.get(0).getCircleId(),resObj.get(0).getDivisionId(),resObj.get(0).getSubdivisionId(),resObj.get(0).getLevelId(),resObj.get(0).getRoleId(),resObj.get(0).getProjectId(),resObj.get(0).getActionTakencomplete(),resObj.get(0).getResRecommendId() );	
						 
						 
										
					}	
					
				}
			
			 }
			 
			 
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public List<ReservoirInspect> getResAnn2mst2InspectData(Integer year, String rescode, Integer frequency_oper) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_RES_ANN2_MST2_INSPECTDATA;
		
		String val=rescode.replace("\"", "");
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{val,frequency_oper,year},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
							resInspect.setResInspectMst2Id(rs.getInt(1));
							resInspect.setResInspectMst1Id(rs.getInt(2));
							resInspect.setResCode(rs.getString(3));
							resInspect.setResCheckId(rs.getInt(4));
							resInspect.setResCatId(rs.getInt(5));
							resInspect.setDesignationId(rs.getInt(6));
							resInspect.setInspectDate(rs.getString(7));
							resInspect.setApprovStatusId(rs.getInt(8));
							resInspect.setUserId(rs.getInt(9));
							resInspect.setUserName(rs.getString(10));
							resInspect.setUserEmpId(rs.getString(11));
							resInspect.setRemarks(rs.getString(12));
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirInspect> getResAnn1mst2InspectData(Integer year, Integer reservoirId, Integer frequency_oper) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_RES_ANN1_MST2_INSPECTDATA;
		
		//String val=rescode.replace("\"", "");
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{reservoirId,frequency_oper,year},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
							resInspect.setResInspectMst2Id(rs.getInt(1));
							resInspect.setResInspectMst1Id(rs.getInt(2));
							resInspect.setReservoirId(rs.getInt(3));
							resInspect.setResCheckId(rs.getInt(4));
							resInspect.setResCatId(rs.getInt(5));
							resInspect.setDesignationId(rs.getInt(6));
							resInspect.setInspectDate(rs.getString(7));
							resInspect.setApprovStatusId(rs.getInt(8));
						
							resInspect.setUserName(rs.getString(9));
							resInspect.setEmpId(rs.getInt(10));
							resInspect.setRemarks(rs.getString(11));
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirInspect> getResAnn2health(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_HEALTH;
		
		String val=rescode.replace("\"", "");
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{val},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
							resInspect.setResDamHealthId(rs.getInt(1));
							resInspect.setResCode(rs.getString(2));
							resInspect.setResCatId(rs.getInt(3));
							resInspect.setDesignationId(rs.getInt(4));
							resInspect.setInspectDate(rs.getString(5));
							resInspect.setRemarks(rs.getString(6));							
							resInspect.setUserName(rs.getString(7));
							resInspect.setUserEmpId(rs.getString(8));
							resInspect.setUnitId(rs.getInt(9));
							resInspect.setCircleId(rs.getInt(10));
							resInspect.setDivisionId(rs.getInt(11));
							resInspect.setSubdivisionId(rs.getInt(12));
							resInspect.setProjectId(rs.getInt(13));
							resInspect.setLevelId(rs.getInt(14));
							resInspect.setResName(rs.getString(15));
							resInspect.setUnitName(rs.getString(16));
							resInspect.setCircleName(rs.getString(17));
							resInspect.setDivisionName(rs.getString(18));
							resInspect.setSubdivisionName(rs.getString(19));
							resInspect.setProjectName(rs.getString(20));
							resInspect.setDesignationName(rs.getString(21));
							
							
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	@Override
	public List<ReservoirInspect> getResAnn2Recommendations(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_RECOMMEND;
		
		String val=rescode.replace("\"", "");
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{val},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
							resInspect.setResRecommendId(rs.getInt(1));
							resInspect.setResDamHealthId(rs.getInt(2));
							resInspect.setResCode(rs.getString(3));
							resInspect.setDesignationId(rs.getInt(4));
							resInspect.setInspectDate(rs.getString(5));
							resInspect.setRecomendbysdso(rs.getString(6));
							resInspect.setUserId(rs.getInt(7));
							resInspect.setUserName(rs.getString(8));
							resInspect.setUserEmpId(rs.getString(9));
							resInspect.setUnitId(rs.getInt(10));
							resInspect.setCircleId(rs.getInt(11));
							resInspect.setDivisionId(rs.getInt(12));
							resInspect.setSubdivisionId(rs.getInt(13));
							resInspect.setProjectId(rs.getInt(14));
							resInspect.setLevelId(rs.getInt(15));
							resInspect.setResName(rs.getString(16));
							resInspect.setUnitName(rs.getString(17));
							resInspect.setCircleName(rs.getString(18));
							resInspect.setDivisionName(rs.getString(19));
							resInspect.setSubdivisionName(rs.getString(20));
							resInspect.setProjectName(rs.getString(21));
							resInspect.setDesignationName(rs.getString(22));
							resInspect.setRemarks(rs.getString(23));
							resInspect.setResCategoryId(rs.getInt(24));
							resInspect.setResCategory(rs.getString(25));
							
							
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	@Override
	public List<ReservoirInspect> getResAnn2ActionTakenData(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_RES_ACTION_TAKEN;
		
		String val=rescode.replace("\"", "");
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{val},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
							resInspect.setResDamActionId(rs.getInt(1));
							resInspect.setResDamHealthId(rs.getInt(2));
							resInspect.setResCode(rs.getString(3));
							resInspect.setInspectDate(rs.getString(4));
							resInspect.setActionTakeninit(rs.getBoolean(5));
							resInspect.setReasonForPending(rs.getString(6));
							
							resInspect.setDesignationId(rs.getInt(7));
							resInspect.setUserId(rs.getInt(8));
							resInspect.setUserName(rs.getString(9));
							resInspect.setUserEmpId(rs.getString(10));
							resInspect.setUnitId(rs.getInt(11));
							resInspect.setCircleId(rs.getInt(12));
							resInspect.setDivisionId(rs.getInt(13));
							resInspect.setSubdivisionId(rs.getInt(14));
							resInspect.setProjectId(rs.getInt(15));
							resInspect.setLevelId(rs.getInt(16));
							
							
							
							
							resInspect.setResName(rs.getString(17));
							resInspect.setUnitName(rs.getString(18));
							resInspect.setCircleName(rs.getString(19));
							resInspect.setDivisionName(rs.getString(20));
							resInspect.setSubdivisionName(rs.getString(21));
							resInspect.setProjectName(rs.getString(22));
							resInspect.setDesignationName(rs.getString(23));
							resInspect.setRemarks(rs.getString(24));
							resInspect.setResCategoryId(rs.getInt(25));
							resInspect.setResCategory(rs.getString(26));
							resInspect.setResRecommendId(rs.getInt(27));
							resInspect.setActionTakencomplete(rs.getBoolean(28));
							//resInspect.setRoleId(rs.getInt(29));							
							resInspect.setRecomendbysdso(rs.getString(29));
							
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirInspect> getResAnn2latestRecommend(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_LATEST_RECOMMENDATION;
		
		String val=rescode.replace("\"", "");
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{val},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
							resInspect.setResCode(rs.getString(1));
							resInspect.setInspectDate(rs.getString(2));
							
							resInspect.setRecomendbysdso(rs.getString(3));
							
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<ReservoirInspect> getResAnn2latesthealth(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_LATEST_HEALTH;
		
		String val=rescode.replace("\"", "");
		try {
               // System.out.println("mst1Id"+mst1Id+sql);
			List<ReservoirInspect> resinspectList = jdbcTemplate8.query(sql ,new Object[]{val},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect resInspect = new ReservoirInspect();
							resInspect.setResCategoryId(rs.getInt(1));
							resInspect.setRemarks(rs.getString(2));
							resInspect.setResCode(rs.getString(3));
							resInspect.setInspectDate(rs.getString(4));
							resInspect.setResCategory(rs.getString(5));
							
							
							
							
							
							
							return resInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return resinspectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public Integer insertMiTankFeedDetails(final List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_TANK_FEED_DETAIL;		 
		
Integer rows1=0;
		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				 if (miObj.get(0).getInspectDate()!= null
							&& miObj.get(0).getInspectDate() != ""
							&& !miObj.get(0).getInspectDate().equals('0')) {
					
					try {
						date1 = DateUtil.getSQLDate( miObj.get(0).getInspectDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
					
				if (miObj.size() > 0) {
					 if( miObj.get(0).getTankId()!=null ){
						 List<Map<String, Object>> result2 = jdbcTemplate8.queryForList(sql3,miObj.get(0).getTankId(),miObj.get(0).getCanFeed(), 
								 miObj.get(0).getChainLinkId(),miObj.get(0).getSourceTypeId(),miObj.get(0).getSourceCompTypeId(),miObj.get(0).getSourceCompId(),date1,
								miObj.get(0).getSourceDetails(),miObj.get(0).getUserId(),miObj.get(0).getUserName(),miObj.get(0).getUserEmpId(),miObj.get(0).getUnitId(),
								miObj.get(0).getCircleId(),miObj.get(0).getDivisionId(),miObj.get(0).getSubdivisionId(),miObj.get(0).getProjectId(),
								miObj.get(0).getDesignationId(),miObj.get(0).getLevelId(),miObj.get(0).getOtLocationKm(),miObj.get(0).getSectionId());	
						 
						 
						 
 if(result2!=null){
							 
							 for (Map<String, Object> row : result2) {
								 rows1=Integer.parseInt(row.get("mi_feed_detail_id").toString());
								}
							 
							// System.out.println("mst1outputdao"+mst1output);
						 }

										
					}
					 
					
				}
			
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public List<MiTankInspect> getMiTankFeedData(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_TANK_FEED_DATA;
		try {
			
			//System.out.println("GET_TANK_FEED_DATA"+GET_TANK_FEED_DATA);

			List<MiTankInspect> mitankfeeddata = jdbcTemplate8.query(sql ,new Object[]{tankId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
					//System.out.println("rs.getInt(3)"+rs.getInt(3));
							mitankinspect.setMitankFeedDetailsId(rs.getInt(1));
							mitankinspect.setTankId(rs.getLong(2));
							mitankinspect.setCanFeed(rs.getBoolean(3));
							mitankinspect.setChainLinkId(rs.getInt(4));
							mitankinspect.setSourceTypeId(rs.getInt(5));
							
							mitankinspect.setSourceCompTypeId(rs.getInt(6));
							mitankinspect.setSourceCompId(rs.getInt(7));
							mitankinspect.setInspectDate(rs.getString(8));
							mitankinspect.setSourceDetails(rs.getString(9));
							mitankinspect.setUserName(rs.getString(10));
							mitankinspect.setUserEmpId(rs.getString(11));
							mitankinspect.setUnitId(rs.getInt(12));
							mitankinspect.setCircleId(rs.getInt(13));
							mitankinspect.setDivisionId(rs.getInt(14));
							mitankinspect.setSubdivisionId(rs.getInt(15));
							mitankinspect.setProjectId(rs.getInt(16));
							mitankinspect.setDesignationId(rs.getInt(17));
							mitankinspect.setLevelId(rs.getInt(18));
							mitankinspect.setTankName(rs.getString(19));
							mitankinspect.setUnitName(rs.getString(20));
							mitankinspect.setCircleName(rs.getString(21));
							mitankinspect.setDivisionName(rs.getString(22));
							mitankinspect.setSubdivisionName(rs.getString(23));
							mitankinspect.setProjectName(rs.getString(24));
							mitankinspect.setDesignation(rs.getString(25));
							mitankinspect.setDistrictName(rs.getString(26));
							mitankinspect.setMandalName(rs.getString(27));
							mitankinspect.setVillageName(rs.getString(28));
						
							mitankinspect.setChainLinkName(rs.getString(29));
							
							mitankinspect.setSourceTypeName(rs.getString(30));

							mitankinspect.setSourceCompTypeName(rs.getString(31));
							
							mitankinspect.setSourceCompName(rs.getString(32));	
							
							mitankinspect.setCompCode(rs.getString(33));
							mitankinspect.setOtLocationKm(rs.getString(34));
						
							
						
							
							
							
							
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
			//System.out.println("miinflowoutflow"+mitankfeeddata);
			return mitankfeeddata;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public Integer insertMiTankFeedRemarks(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_TANK_FEED_REMARKS;		
		
		String sql2=UPDATE_OLD_FEED_REMARKS;
		
Integer rows1=0;
Integer rows2=0;
		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				 if(miObj.getMitankFeedDetailsId()!=null && miObj.getLevelId()!=null){
						
					 rows2 = jdbcTemplate8.update(sql2,miObj.getUserId(),miObj.getUserName(),miObj.getMitankFeedDetailsId(),miObj.getLevelId() );	
					 
				 }
             	
				 
				
					 if( miObj.getTankId()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getMitankFeedDetailsId(),miObj.getTankId(),miObj.getUserId(),miObj.getUserName(),
								miObj.getUserEmpId(),miObj.getUnitId(),miObj.getCircleId(),miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getProjectId(),miObj.getDesignationId(),miObj.getLevelId(),miObj.getEmpId(),miObj.getRemarks() );	
						 
						 
										
				
					
				}
			
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public List<MiTankInspect> getMiTankFeedRemarks (Long tankId,Integer empId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_TANK_FEED_REMARKS;
		try {
			
			//System.out.println("GET_MI_CAPACITY"+GET_MI_CAPACITY);

			List<MiTankInspect> mitankfeeddata = jdbcTemplate8.query(sql ,new Object[]{tankId,empId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
				//	System.out.println("rs.getInt(3)"+rs.getInt(3));
							mitankinspect.setMitankFeedReviewId(rs.getInt(1));
							mitankinspect.setMitankFeedDetailsId(rs.getInt(2));
							mitankinspect.setTankId(rs.getLong(3));
							mitankinspect.setUserId(rs.getInt(4));
							mitankinspect.setUserName(rs.getString(5));
							mitankinspect.setUserEmpId(rs.getString(6));
							mitankinspect.setUnitId(rs.getInt(7));
							mitankinspect.setCircleId(rs.getInt(8));
							mitankinspect.setDivisionId(rs.getInt(9));
							mitankinspect.setSubdivisionId(rs.getInt(10));
							mitankinspect.setProjectId(rs.getInt(11));
							mitankinspect.setDesignationId(rs.getInt(12));
							mitankinspect.setLevelId(rs.getInt(13));						
							mitankinspect.setEmpId(rs.getInt(14));
							mitankinspect.setRemarks(rs.getString(15));
							
					
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return mitankfeeddata;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public Integer insertMiTankCapacityRemarks(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_TANK_CPACITY_REMARKS;		 
		
		String sql2=UPDATE_OLD_CAPACITY_REMARKS;
		
Integer rows1=0;
Integer rows2=0;
		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				 if(miObj.getMitankCapacityId()!=null && miObj.getLevelId()!=null){
						
					 rows2 = jdbcTemplate8.update(sql2,miObj.getUserId(),miObj.getUserName(),miObj.getMitankCapacityId(),miObj.getLevelId() );	
					 
				 }
             	
				 
				
					 if( miObj.getTankId()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getMitankCapacityId(),miObj.getTankId(),miObj.getUserId(),miObj.getUserName(),
								miObj.getUnitId(),miObj.getCircleId(),miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getDesignationId(),
								miObj.getLevelId(),miObj.getRemarks(),miObj.getEmpId(),miObj.getPostId(),miObj.getNextPostId(),miObj.getNextEmpId(),miObj.getSectionId());	
						 
						 
						 
										
				
					
				}
			
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public List<MiTankInspect> getMiTankCapacityRemarks (Long tankId,Long postId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_TANK_CAPACITY_REMARKS;
		try {
			
			//System.out.println("GET_MI_CAPACITY"+GET_MI_CAPACITY);

			List<MiTankInspect> mitankCapacitydata = jdbcTemplate8.query(sql ,new Object[]{tankId,postId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
				//	System.out.println("rs.getInt(3)"+rs.getInt(3));
							mitankinspect.setMitankCapacityReviewId(rs.getInt(1));;
							mitankinspect.setMitankCapacityId(rs.getInt(2));
							mitankinspect.setTankId(rs.getLong(3));
							mitankinspect.setUserId(rs.getInt(4));
							mitankinspect.setUserName(rs.getString(5));
							
							mitankinspect.setUnitId(rs.getInt(6));
							mitankinspect.setCircleId(rs.getInt(7));
							mitankinspect.setDivisionId(rs.getInt(8));
							mitankinspect.setSubdivisionId(rs.getInt(9));
						
							mitankinspect.setDesignationId(rs.getInt(10));
							mitankinspect.setLevelId(rs.getInt(11));						
							
							mitankinspect.setRemarks(rs.getString(12));
							mitankinspect.setEmpId(rs.getInt(13));
							mitankinspect.setPostId(rs.getLong(14));
							mitankinspect.setNextPostId(rs.getLong(15));
							
					
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return mitankCapacitydata;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public Integer insertMiTankRepairsRemarks(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_TANK_REPAIR_REMARKS;		 
		
		String sql2 = UPDATE_OLD_REPAIRS_REMARKS;	
		
		Integer rows2=0;
		
Integer rows1=0;
		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				 if(miObj.getMitankRepairsId()!=null && miObj.getLevelId()!=null){
						
					 rows2 = jdbcTemplate8.update(sql2,miObj.getUserId(),miObj.getUserName(),miObj.getMitankRepairsId(),miObj.getLevelId() );	
					 
				 }
             	
				 
				
					 if( miObj.getTankId()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getMitankRepairsId(),miObj.getTankId(),miObj.getUserId(),miObj.getUserName(),
								miObj.getUnitId(),miObj.getCircleId(),miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getProjectId(),miObj.getDesignationId(),
								miObj.getLevelId(),miObj.getEmpId(),miObj.getRemarks(),miObj.getRepairdescId(),miObj.getPostId(),miObj.getNextPostId(),miObj.getNextEmpId(),miObj.getSectionId() );	
						 
						 
										
				
					
				}
			
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public List<MiTankInspect> getMiTankRepairsRemarks (Long tankId,Long nextPostId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_TANK_REPAIR_REMARKS;
		try {
			
			//System.out.println("GET_MI_CAPACITY"+GET_MI_CAPACITY);

			List<MiTankInspect> mitankRepairsdata = jdbcTemplate8.query(sql ,new Object[]{tankId,nextPostId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
				//	System.out.println("rs.getInt(3)"+rs.getInt(3));
							mitankinspect.setMitankRepairsReviewId(rs.getInt(1));;
							mitankinspect.setMitankRepairsId(rs.getInt(2));
							mitankinspect.setTankId(rs.getLong(3));
							mitankinspect.setUserId(rs.getInt(4));
							mitankinspect.setUserName(rs.getString(5));
							
							mitankinspect.setUnitId(rs.getInt(6));
							mitankinspect.setCircleId(rs.getInt(7));
							mitankinspect.setDivisionId(rs.getInt(8));
							mitankinspect.setSubdivisionId(rs.getInt(9));
							mitankinspect.setProjectId(rs.getInt(10));
							mitankinspect.setDesignationId(rs.getInt(11));
							mitankinspect.setLevelId(rs.getInt(12));						
						
							mitankinspect.setRemarks(rs.getString(13));
							mitankinspect.setEmpId(rs.getInt(14));
							mitankinspect.setPostId(rs.getLong(15));
							mitankinspect.setNextPostId(rs.getLong(16));
							
					
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return mitankRepairsdata;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	/*@Override
	public Integer insertMiTankInOutFlowRemarks(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_TANK_INOUTFLOW_REMARKS;	
		
		String sql2=UPDATE_OLD_INOUTFLOW_REMARKS;
		
Integer rows1=0;
Integer rows2=0;
		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				 if(miObj.getMitankInoutFlowId()!=null && miObj.getLevelId()!=null){
						
					 rows2 = jdbcTemplate8.update(sql2,miObj.getUserId(),miObj.getUserName(),miObj.getMitankInoutFlowId(),miObj.getLevelId() );	
					 
				 }
             	
				 
				
					 if( miObj.getTankId()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getMitankInoutFlowId(),miObj.getTankId(),miObj.getUserId(),miObj.getUserName(),
								miObj.getUserEmpId(),miObj.getUnitId(),miObj.getCircleId(),miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getProjectId(),miObj.getDesignationId(),miObj.getLevelId(),miObj.getEmpId(),miObj.getRemarks() );	
						 
						 
										
				
					
				}
			
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	*/
	
	/*
	@Override
	public List<MiTankInspect> getMiTankInoutFlowRemarks (Long tankId,Integer empId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_TANK_INOUTFLOW_REMARKS;
		try {
			
			//System.out.println("GET_MI_CAPACITY"+GET_MI_CAPACITY);

			List<MiTankInspect> mitankCapacitydata = jdbcTemplate8.query(sql ,new Object[]{tankId,empId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
				//	System.out.println("rs.getInt(3)"+rs.getInt(3));
							mitankinspect.setMitankInoutFlowReviewId(rs.getInt(1));;
							mitankinspect.setMitankInoutFlowId(rs.getInt(2));
							mitankinspect.setTankId(rs.getLong(3));
							mitankinspect.setUserId(rs.getInt(4));
							mitankinspect.setUserName(rs.getString(5));
							mitankinspect.setUserEmpId(rs.getString(6));
							mitankinspect.setUnitId(rs.getInt(7));
							mitankinspect.setCircleId(rs.getInt(8));
							mitankinspect.setDivisionId(rs.getInt(9));
							mitankinspect.setSubdivisionId(rs.getInt(10));
							mitankinspect.setProjectId(rs.getInt(11));
							mitankinspect.setDesignationId(rs.getInt(12));
							mitankinspect.setLevelId(rs.getInt(13));						
							mitankinspect.setEmpId(rs.getInt(14));
							mitankinspect.setRemarks(rs.getString(15));
							
					
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return mitankCapacitydata;
		} catch (Exception exc) {
			
			return null;
		}
	}*/
	
	
	@Override
	public Integer insertMiTankMst1Remarks(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_TANK_MST1_REMARKS;		 
		
		String sql2 = UPDATE_OLD_MST1_REMARKS;		 
		
		
		
Integer rows1=0;
Integer rows2=0;
		
String Remarks =null;
		
	
		
		java.sql.Date date1 = null;
		
	///	System.out.println("getremarks"+miObj.getEmbRemarks());
		//System.out.println("getsluremarks"+miObj.getSluRemarks());
		//System.out.println("getweirremarks"+miObj.getWeirRemarks());
//		System.out.println("getnextempid"+miObj.getNextEmpId());
		if(miObj.getTabId()==1){
		Remarks=miObj.getEmbRemarks();
		}
		if(miObj.getTabId()==2){
		Remarks=miObj.getSluRemarks();
		}
		if(miObj.getTabId()==3){
		Remarks=miObj.getWeirRemarks();
		}
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				 if(miObj.getMiInpsectMst1Id()!=null && miObj.getLevelId()!=null){
					
					 rows2 = jdbcTemplate8.update(sql2,miObj.getUserId(),miObj.getUserName(),miObj.getTabId(),miObj.getMiInpsectMst1Id(),miObj.getLevelId(),miObj.getTankWeirSluiceId()  );	
					 
				 }
			
					 if( miObj.getMiInpsectMst1Id()!=null && miObj.getLevelId()!=null && miObj.getTankId()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getMiInpsectMst1Id(),miObj.getTankId(),miObj.getUserId(),miObj.getUserName(),
								miObj.getUnitId(),miObj.getCircleId(),
								miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getProjectId(),
								miObj.getDesignationId(),miObj.getLevelId(),Remarks,miObj.getTabId(),miObj.getTankWeirSluiceId(),miObj.getEmpId(),miObj.getPostId(),miObj.getNextPostId(),miObj.getNextEmpId(),miObj.getSectionId());	
						 
						 
										
				
					
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	
	
	@Override
	public List<MiTankInspect> getMiTankMst1Remarks (Integer mst1Id,Long  postId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_TANK_MST1_REMARKS;
		try {
			
			//System.out.println("GET_TANK_MST1_REMARKS  "+GET_TANK_MST1_REMARKS+mst1Id+"--"+nextPostId);


			List<MiTankInspect> mitankMst1remarks = jdbcTemplate8.query(sql ,new Object[]{mst1Id,postId},

					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
					//System.out.println("rs.getInt(3)"+rs.getLong(3));
							
							mitankinspect.setMiInpsectMst1IdReviewId(rs.getInt(1));
							mitankinspect.setMiInpsectMst1Id(rs.getInt(2));
							mitankinspect.setTankId(rs.getLong(3));
							mitankinspect.setUserId(rs.getInt(4));
							mitankinspect.setUserName(rs.getString(5));
							
							mitankinspect.setUnitId(rs.getInt(6));
							mitankinspect.setCircleId(rs.getInt(7));
							mitankinspect.setDivisionId(rs.getInt(8));
							mitankinspect.setSubdivisionId(rs.getInt(9));
							mitankinspect.setProjectId(rs.getInt(10));
							mitankinspect.setDesignationId(rs.getInt(11));
							mitankinspect.setLevelId(rs.getInt(12));
							mitankinspect.setPostId(rs.getLong(13));
							mitankinspect.setNextPostId(rs.getLong(14));
							
							mitankinspect.setRemarks(rs.getString(15));
							
					
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("getMiTankMst1Remarks"+mitankMst1remarks);
			return mitankMst1remarks ;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public Integer deleteMiTankMst1(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_MST1;		 
		
Integer rows1=0;

		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMiInpsectMst1Id()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMiInpsectMst1Id()	);	
				
				}
			 
			 }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer deleteMiTankMst1Remarks(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_MST1_REMARKS;		 
		
	
		
		
Integer rows1=0;

		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMiInpsectMst1IdReviewId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMiInpsectMst1IdReviewId()	);	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer deleteMiTankMst2(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_MST2;		 
		
	
		
		
Integer rows1=0;

		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMiInpsectMst2Id()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMiInpsectMst2Id()	);	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer deleteMitankFeedDetails(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_FEED_DETAILS;		 
		
	
		
		
Integer rows1=0;

		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMitankFeedDetailsId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMitankFeedDetailsId()	);	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer deleteMitankFeedRemarks(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_FEED_REMARKS;		 
		
	
		
		
Integer rows1=0;

		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMitankFeedReviewId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMitankFeedReviewId()	);	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public Integer deleteMitankCapacity(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_CAPACITY;		 
		
	
		
		
Integer rows1=0;

		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMitankCapacityId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMitankCapacityId()	);	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer deleteMitankCapacityRemarks(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_CAPACITY_REMARKS;		 
		
	
		
		
Integer rows1=0;

		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMitankCapacityReviewId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMitankCapacityReviewId()	);	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	/*@Override
	public Integer deleteMitankInoutFlow(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_INOUTFLOW;		 
		
	
		
		
Integer rows1=0;

		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMitankInoutFlowId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMitankInoutFlowId()	);	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}*/
	
/*	@Override
	public Integer deleteMitankInoutFlowRemarks(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_INOUTFLOW_REMARKS;		 
		
	
		
		
Integer rows1=0;

		
		
	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMitankFeedReviewId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMitankFeedReviewId()	);	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}*/
	
	@Override
	public Integer deleteMitankRepairs(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_REPAIRS;		 
		
	
Integer rows1=0;

	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMitankRepairsId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMitankRepairsId()	);	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer deleteMitankRepairsRemarks(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_MITANK_REPAIRS_REMARKS;		 
		
	
Integer rows1=0;

	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
             	
				
					 if( miObj.getMitankRepairsReviewId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getMitankRepairsReviewId()	);	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public List<MiTankInspect> getEditMiTankMst2Checks (Integer mst2Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =EDIT_GET_MITANK_MST2;
		try {
			
			//System.out.println("GET_MI_CAPACITY"+GET_MI_CAPACITY);

			List<MiTankInspect> mitankCapacitydata = jdbcTemplate8.query(sql ,new Object[]{mst2Id},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
				//	System.out.println("rs.getInt(3)"+rs.getInt(3));
							mitankinspect.setMiInpsectMst2Id(rs.getInt(1));
							mitankinspect.setMiInpsectMst1Id(rs.getInt(2));
							mitankinspect.setUnitId(rs.getInt(3));
							mitankinspect.setCircleId(rs.getInt(4));
							mitankinspect.setDivisionId(rs.getInt(5));
							mitankinspect.setSubdivisionId(rs.getInt(6));
							mitankinspect.setProjectId(rs.getInt(7));
							mitankinspect.setMiInspectMapId(rs.getInt(8));
							mitankinspect.setInspectDate(rs.getString(9));
							mitankinspect.setActionrequireqId(rs.getInt(10));
							mitankinspect.setDesignationId(rs.getInt(11));
							mitankinspect.setRemarks(rs.getString(12));
							mitankinspect.setTankWeirSluiceId(rs.getInt(13));
							mitankinspect.setActionreq(rs.getBoolean(14));
							mitankinspect.setMiInspectTypeId(rs.getInt(15));
							mitankinspect.setMiCompId(rs.getInt(16));
							mitankinspect.setTankId(rs.getLong(17));
							mitankinspect.setMiInspectTypeName(rs.getString(18));
							
						
					
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return mitankCapacitydata;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public Integer editMitankMst2(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_MITANK_MST2;		 
		
		// System.out.println("in dao impl"+UPDATE_MITANK_MST2); 
Integer rows1=0;

	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				 if (miObj.getInspectDate()!= null
							&& miObj.getInspectDate() != ""
							&& !miObj.getInspectDate().equals('0')) {
					
					try {
						date1 = DateUtil.getSQLDate( miObj.getInspectDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
             	
				
					 if( miObj.getMiInpsectMst2Id()!=null  ){
						// System.out.println("in dao"+miObj.getActionrequireqId());
						 rows1 = jdbcTemplate8.update(sql3, date1,
								 miObj.getActionrequireqId(),miObj.getRemarks(), miObj.getActionreq(),miObj.getUserId(),miObj.getUserName(),miObj.getMiInpsectMst2Id());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	/*@Override
	public List<MiTankInspect> getEditInoutflowTank (Integer mstinoutflowId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql =EDIT_GET_INOUTFLOW_TANK;
		try {
			
			//System.out.println("GET_MI_CAPACITY"+GET_MI_CAPACITY);

			List<MiTankInspect> mitankinouteditdata = jdbcTemplate8.query(sql ,new Object[]{mstinoutflowId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
				//	System.out.println("rs.getInt(3)"+rs.getInt(3));
							mitankinspect.setMitankInoutFlowId(rs.getInt(1));
							mitankinspect.setTankId(rs.getLong(2));
							mitankinspect.setInflow(rs.getDouble(3));
							mitankinspect.setOutfow(rs.getDouble(4));
							mitankinspect.setAyacut(rs.getDouble(5));
							mitankinspect.setInspectDate(rs.getString(6));
							//mitankinspect.setRemarks(rs.getString(7));
							
							
							mitankinspect.setUnitId(rs.getInt(7));
							mitankinspect.setCircleId(rs.getInt(8));
							mitankinspect.setDivisionId(rs.getInt(9));
							mitankinspect.setSubdivisionId(rs.getInt(10));
							mitankinspect.setProjectId(rs.getInt(11));
							
							
						
							mitankinspect.setDesignationId(rs.getInt(12));
							
							mitankinspect.setLevelId(rs.getInt(13));
							
							
							
						
					
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return mitankinouteditdata;
		} catch (Exception exc) {
			
			return null;
		}
	}*/
	
	
	
	/*@Override
	public Integer UpdateInoutflowTank(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_INOUTFLOW_TANK;		 
		
	
Integer rows1=0;

	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				 if (miObj.getInspectDate()!= null
							&& miObj.getInspectDate() != ""
							&& !miObj.getInspectDate().equals('0')) {
					
					try {
						date1 = DateUtil.getSQLDate( miObj.getInspectDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
             	
				
					 if( miObj.getMitankInoutFlowId()!=null  ){
						// System.out.println("in dao"+miObj.getActionrequireqId());
						 rows1 = jdbcTemplate8.update(sql3,miObj.getInflow(),miObj.getOutfow(),miObj.getAyacut(),date1,miObj.getRemarks(),miObj.getUserId(),miObj.getUserName(),miObj.getUnitId(),miObj.getCircleId(),miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getProjectId(),
								 miObj.getDesignationId(),miObj.getLevelId(),miObj.getMitankInoutFlowId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}*/
	
	
	@Override
	public List<MiTankInspect> getEditMiRepairs(Integer repairId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = EDIT_GET_REPAIR_TANK;
		try {
			
			//System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{repairId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
							//System.out.println("rs.getInt(1)"+rs.getInt(1));
							mitankinspect.setMitankRepairsId(rs.getInt(1));
							mitankinspect.setTankId(rs.getLong(2));
							mitankinspect.setMiCompId(rs.getInt(3));
							//mitankinspect.setRepairDescription(rs.getString(4));
							mitankinspect.setRate(rs.getDouble(4));
							//mitankinspect.setInspectDate(rs.getString(6));
							mitankinspect.setUnitMeasureId(rs.getInt(5));
						
							
							//mitankinspect.setRemarks(rs.getString(8));
							mitankinspect.setQuantity(rs.getDouble(6));
							mitankinspect.setAmount(rs.getDouble(7));
							//mitankinspect.setSchemeTaken(rs.getString(8));
							
						
							mitankinspect.setUnitId(rs.getInt(8));
							mitankinspect.setCircleId(rs.getInt(9));
							mitankinspect.setDivisionId(rs.getInt(10));
							mitankinspect.setSubdivisionId(rs.getInt(11));
							mitankinspect.setProjectId(rs.getInt(12));
							mitankinspect.setDesignationId(rs.getInt(13));
							mitankinspect.setLevelId(rs.getInt(14));
							mitankinspect.setRepairdescId(rs.getInt(15));
						
						
							
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
	public Integer UpdateRepairsTank(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_REPAIRS_TANK;	
		
		
		
	
Integer rows1=0;

	
		
		
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				
             	
				
					 if( miObj.getMitankRepairsId()!=null  ){
						// System.out.println("in dao"+miObj.getActionrequireqId());
						 rows1 = jdbcTemplate8.update(sql3,miObj.getTankId(),miObj.getMiCompId(),miObj.getRate(),miObj.getUnitMeasureId(),miObj.getQuantity(),miObj.getAmount(),miObj.getUserId(),miObj.getUserName(),
								 miObj.getRepairdescId(),miObj.getMitankRepairsId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public List<MiTankInspect> getEditMiCapacity(Integer capacityId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = EDIT_GET_CAPACITY_TANK;
		try {
			
			//System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{capacityId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
							//System.out.println("rs.getInt(1)"+rs.getInt(1));
							mitankinspect.setMitankCapacityId(rs.getInt(1));
							mitankinspect.setTankId(rs.getLong(2));
							
							DecimalFormat df = new DecimalFormat("#");
					        df.setMaximumFractionDigits(8);
							mitankinspect.setAvailableCapacity(df.format(rs.getDouble(3)));
							mitankinspect.setSurplus(rs.getBoolean(4));						
							mitankinspect.setInspectDate(rs.getString(5));							
						//	mitankinspect.setRemarks(rs.getString(6));							
							mitankinspect.setUnitId(rs.getInt(6));
							mitankinspect.setCircleId(rs.getInt(7));
							mitankinspect.setDivisionId(rs.getInt(8));
							mitankinspect.setSubdivisionId(rs.getInt(9));
							mitankinspect.setProjectId(rs.getInt(10));
							mitankinspect.setDesignationId(rs.getInt(11));
							mitankinspect.setLevelId(rs.getInt(12));
							
							mitankinspect.setInflow(rs.getDouble(13));
							mitankinspect.setOutfow(rs.getDouble(14));
							mitankinspect.setAyacut(rs.getDouble(15));
							
							mitankinspect.setTankLevel(rs.getDouble(16));
							
						
						
							
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
	public Integer UpdateCapacityTank(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_CAPACITY_TANK;		 
		
	
Integer rows1=0;

	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				 if (miObj.getInspectDateCapacity()!= null
							&& miObj.getInspectDateCapacity() != ""
							&& !miObj.getInspectDateCapacity().equals('0')) {
					
					try {
						date1 = DateUtil.getSQLDate( miObj.getInspectDateCapacity());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
				 
				 if(miObj.getTankLevel()==null){
					 
					 miObj.setTankLevel(0.00);
				 }
             	
				
					 if( miObj.getMitankCapacityId()!=null  ){
						// System.out.println("in dao"+miObj.getActionrequireqId());
						 rows1 = jdbcTemplate8.update(sql3,miObj.getTankId(),miObj.getAvailableCapacity(),miObj.getSurplus(),date1,miObj.getUserId(),miObj.getUserName(),
								 miObj.getInflow(),miObj.getOutfow(),miObj.getAyacut(),miObj.getTankLevel(),miObj.getMitankCapacityId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}

	
	
	
	@Override
	public List<MiTankInspect> getEditMiFeed(Integer feedId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = EDIT_GET_FEED_TANK;
		try {
			
			//System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{feedId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
						
							mitankinspect.setMitankFeedDetailsId(rs.getInt(1));
							mitankinspect.setTankId(rs.getLong(2));
							mitankinspect.setCanFeed(rs.getBoolean(3));
							mitankinspect.setChainLinkId(rs.getInt(4));
							mitankinspect.setSourceTypeId(rs.getInt(5));
			                mitankinspect.setSourceCompTypeId(rs.getInt(6));
			                mitankinspect.setSourceCompId(rs.getInt(7));
			
							mitankinspect.setInspectDate(rs.getString(8));							
							mitankinspect.setSourceDetails(rs.getString(9));							
							mitankinspect.setUnitId(rs.getInt(10));
							mitankinspect.setCircleId(rs.getInt(11));
							mitankinspect.setDivisionId(rs.getInt(12));
							mitankinspect.setSubdivisionId(rs.getInt(13));
							mitankinspect.setProjectId(rs.getInt(14));
							mitankinspect.setDesignationId(rs.getInt(15));
							mitankinspect.setLevelId(rs.getInt(16));
							mitankinspect.setOtLocationKm(rs.getString(17));
					
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
	public Integer UpdateFeedTank(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_FEED_TANK;		 
		
	
Integer rows1=0;

	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				 if (miObj.getInspectDateFeed()!= null
							&& miObj.getInspectDateFeed() != ""
							&& !miObj.getInspectDateFeed().equals('0')) {
					
					try {
						date1 = DateUtil.getSQLDate( miObj.getInspectDateFeed());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
             	
				
					 if( miObj.getMitankFeedDetailsId()!=null  ){
						// System.out.println("in dao"+miObj.getActionrequireqId());
						 rows1 = jdbcTemplate8.update(sql3,miObj.getTankId(),miObj.getCanFeed(),miObj.getChainLinkId(),miObj.getSourceTypeId(),miObj.getSourceCompTypeId(),miObj.getSourceCompId(),date1,miObj.getSourceDetails(),miObj.getUserId(),miObj.getUserName(),miObj.getUnitId(),miObj.getCircleId(),miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getProjectId(),
								 miObj.getDesignationId(),miObj.getLevelId(),miObj.getOtLocationKm(),miObj.getMitankFeedDetailsId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	@Override
	public List<MiTankInspect> viewMst1Remarks(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql=VIEW_MST1_REMARKS_EMPID;
	//	String sql = VIEW_MST1_REMARKS;
		try {
			
			//System.out.println("VIEW_MST1_REMARKS"+VIEW_MST1_REMARKS);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{mst1Id},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
							mitankinspect.setMiInpsectMst1IdReviewId(rs.getInt(1));
						//	System.out.println("Mst1Id() "+mitankinspect.getMiInpsectMst1IdReviewId());
							mitankinspect.setMiInpsectMst1Id(rs.getInt(2));
							mitankinspect.setTankId(rs.getLong(3));
							mitankinspect.setLatestRemarks(rs.getBoolean(4));
							
							mitankinspect.setRemarks(rs.getString(5));
							mitankinspect.setTabId(rs.getInt(6));
							mitankinspect.setPostId(rs.getLong(7));
							mitankinspect.setNextPostId(rs.getLong(8));
					
							
							mitankinspect.setSubmittedToEmpName(rs.getString(9));
						    mitankinspect.setRemarksSubmittedBy(rs.getString(10));
						
							mitankinspect.setDesignationId(rs.getInt(11));
							mitankinspect.setDesignation(rs.getString(12));
			              
			                
			                mitankinspect.setTankWeirSluiceId(rs.getInt(13));
			                mitankinspect.setTankWeirSluiceName(rs.getString(14));
			            	mitankinspect.setRemarksDate(rs.getString(15));
			       //     	System.out.println("RemarksDate() "+mitankinspect.getRemarksDate());
							
					
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
	public Integer insertTankWeirSluice(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_TANK_SLUICE_WEIR;		 
		
	
Integer rows1=0;

	
		
		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 
				
             	
				
					 if( miObj.getTankId()!=null  ){
						// System.out.println("in dao"+miObj.getActionrequireqId());
						 rows1 = jdbcTemplate8.update(sql3,miObj.getTankId(),miObj.getTankWeirSluiceName(),miObj.getTankWeirSluiceTypeId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public List<MiTankInspect> getTankWeirSluicelist(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_WEIR_SLUICE_BY_TANKID;
		try {
			
			//System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{tankId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
						
							mitankinspect.setTankWeirSluiceName(rs.getString(1));
							mitankinspect.setTankWeirSluiceId(rs.getInt(2));
							mitankinspect.setTankWeirSluiceTypeId(rs.getInt(3));
					
						
							
					
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
	public List<Tanks> getTanksCapacityBYTankId(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_TANK_CAPACITY_BY_TANK;
		
	//	System.out.println("sql"+sql+"villageId"+villageId);
		try {

			List<Tanks> tankcapacityList = jdbcTemplate8.query(sql,new Object[]{tankId},
					new RowMapper<Tanks>() {

						public Tanks mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							Tanks sd = new Tanks();
							
							sd.setTankId(rs.getLong(1));
							sd.setTankCode(rs.getLong(2));
							sd.setGeoTagId(rs.getLong(3));
							
							DecimalFormat df = new DecimalFormat("#");
					        df.setMaximumFractionDigits(8);
					        
					
							sd.setCapacitytank(df.format(rs.getDouble(4)));
							
							sd.setGrossAyacut(rs.getDouble(5));
							
							sd.setLatitude(rs.getString(6));
							
							sd.setLongitude(rs.getString(7));
							
							
							
						
							return sd;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
			//System.out.println("tankList"+tankList);
			return tankcapacityList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public Integer updateTankCrticalStatus(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_CRITICAL_STATUS;		 
	
Integer rows1=0;

		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
		//	 System.out.println("miObj.getUnitId()"+miObj.getUnitId());
			 if(miObj!=null){
			//	 System.out.println("miObj.getUnitId()"+miObj.getUnitId());
				 
				 /* if( miObj.getMiInpsectMst1Id()!=null && miObj.getUnitId()!=null ){
						 
						 if(miObj.getCircleId()==null){
							 miObj.setCircleId(0);
						 }
						 if(miObj.getDivisionId()==null){
							 miObj.setDivisionId(0);
						 }
						 if(miObj.getSubdivisionId()==null){
							 miObj.setSubdivisionId(0);
						 }*/
				 if( miObj.getMiInpsectMst1Id()!=null  ){
						// System.out.println("in dao"+miObj.getActionrequireqId());
						 List<Map<String, Object>> result2  = jdbcTemplate8.queryForList(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getTankStatusId(),miObj.getMiInpsectMst1Id());
						/* List<Map<String, Object>> result2  = jdbcTemplate8.queryForList(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getTankStatusId(),miObj.getUnitId(),miObj.getCircleId(),
								 miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getMiInpsectMst1Id());	*/
				 
						    if(result2!=null){
								 
								 for (Map<String, Object> row : result2) {
									 rows1=Integer.parseInt(row.get("tank_status_id").toString());
									}
								 
							//	 System.out.println("rows1: "+rows1);
							 }
				}
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer insertTankRepairsDescription(final MiTankInspect miobj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_REPAIRS_DESCRIPTION;

	   

		

		Integer  tankdescId = null;
		

		 java.sql.Date startdate = null;

		 java.sql.Date enddate = null;

		try {
			if (miobj != null ) {
				
				if(miobj.getTankId()!=null){
					
					 if (miobj.getRepairStartDate()!= null
								&& miobj.getRepairStartDate() != ""
								&& !miobj.getRepairStartDate().equals('0')) {
						
						try {
							startdate = DateUtil.getSQLDate( miobj.getRepairStartDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					 
					 if (miobj.getRepairEndDate()!= null
								&& miobj.getRepairEndDate() != ""
								&& !miobj.getRepairEndDate().equals('0')) {
						
						try {
							enddate = DateUtil.getSQLDate( miobj.getRepairEndDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }

				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

				List<Map<String, Object>> rows = jdbcTemplate8.queryForList(sql,miobj.getTankId(), miobj.getRepairDescription(),startdate,enddate,
						miobj.getSchemeTaken(),miobj.getUserId(),miobj.getUserName(),miobj.getDesignationId(),miobj.getLevelId(),miobj.getEmpId(),miobj.getPostId());

				for (Map<String, Object> row : rows) {
				  tankdescId = Integer.parseInt(row.get("mi_repair_desc_id").toString());
				}

				}
			
			

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return tankdescId;
	}
	
	
	
	
	@Override
	public List<MiTankInspect> getTankRepairdescList(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_TANK_REPAIRDESC_BY_TANKID;
		try {
			
			//System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR);

			List<MiTankInspect> repairdescList = jdbcTemplate8.query(sql ,new Object[]{tankId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect repairdesc = new MiTankInspect();
							
						
							repairdesc.setRepairdescId(rs.getInt(1));
							repairdesc.setRepairdescdata(rs.getString(2));
							repairdesc.setTankId(rs.getLong(3));
							
							repairdesc.setRepairDescription(rs.getString(4));
							repairdesc.setRepairStartDate(rs.getString(5));
							repairdesc.setRepairEndDate(rs.getString(6));
							repairdesc.setSchemeTaken(rs.getString(7));
							
							
							
							repairdesc.setDesignationId(rs.getInt(8));
							
							repairdesc.setLevelId(rs.getInt(9));
							
							repairdesc.setPostId(rs.getLong(10));
							
							
							
							
							
					
						
							
					
							return repairdesc;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return repairdescList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public Integer editTankRepairsDescription(final MiTankInspect miobj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = EDIT_TANK_REPAIRDESC;

	   

		

		Integer  result = 0;
		

		 java.sql.Date startdate = null;

		 java.sql.Date enddate = null;

		try {
			if (miobj != null ) {
				
				if(miobj.getRepairdescId()!=null){
					
					 if (miobj.getRepairStartDate()!= null
								&& miobj.getRepairStartDate() != ""
								&& !miobj.getRepairStartDate().equals('0')) {
						
						try {
							startdate = DateUtil.getSQLDate( miobj.getRepairStartDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					 
					 if (miobj.getRepairEndDate()!= null
								&& miobj.getRepairEndDate() != ""
								&& !miobj.getRepairEndDate().equals('0')) {
						
						try {
							enddate = DateUtil.getSQLDate( miobj.getRepairEndDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }

				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

				result = jdbcTemplate8.update(sql, miobj.getRepairDescription(),startdate,enddate,
						miobj.getSchemeTaken(),miobj.getUserId(),miobj.getUserName(),miobj.getDesignationId(),miobj.getLevelId(),miobj.getRepairdescId());

				

				}
			
			

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return result;
	}
	
	@Override
	public Integer deleteTankRepairsDescription(final MiTankInspect miobj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_TANK_REPAIRDESC;

	   

		

		Integer  result = 0;
		

		 java.sql.Date startdate = null;

		 java.sql.Date enddate = null;

		try {
			if (miobj != null ) {
				
				if(miobj.getRepairdescId()!=null){
					
				
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

				result = jdbcTemplate8.update(sql, 
						miobj.getUserId(),miobj.getDesignationId(),miobj.getLevelId(),miobj.getUserName(),miobj.getRepairdescId());

				

				}
			
			

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return result;
	}
	
	@Override
	public MiTankInspect getTankSuiceNamebyId(Integer tankWeirSluiceId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = EDIT_GET_SLUICENAME_BYID;
		try {
			
		//	System.out.println("getTankSuiceNamebyId"+tankWeirSluiceId);

			MiTankInspect SluiceName = (MiTankInspect) jdbcTemplate8.queryForObject(sql ,new Object[]{tankWeirSluiceId},
					new RowMapper<Object>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							MiTankInspect SluiceName = new MiTankInspect();
							SluiceName.setTankWeirSluiceId(rs.getInt(1));
						//	System.out.println("SluiceNamebyid: "+SluiceName.getTankWeirSluiceId());
							SluiceName.setTankWeirSluiceName(rs.getString(2));
					//		System.out.println("SluiceNamebyid: "+SluiceName.getTankWeirSluiceName());
							SluiceName.setTankWeirSluiceTypeId(rs.getInt(3));
					//		System.out.println("SluiceNamebyid: "+SluiceName.getTankWeirSluiceTypeId());
							return SluiceName;
						}

					});
		//	System.out.println("SluiceName"+SluiceName);
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("SluiceName2: "+SluiceName);
			return SluiceName;
			
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public Integer updateSluicenamebyid(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_SLUICENAME_BYID;		 
		Integer result2=0;
			try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 if( miObj.getTankWeirSluiceId()!=null  ){
						 result2  = jdbcTemplate8.update(sql3,miObj.getTankWeirSluiceName(),miObj.getTankWeirSluiceId());
						 
				}
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result2;
	}
	
	
	
	
	@Override
	public MiTankInspect getMst1remarksbyreviewId(Integer miInpsectMst1IdReviewId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = EDIT_GET_MST1REMARKS_BYREVIEWID;
		try {
			
		//	System.out.println("miInpsectMst1IdReviewId daoimpl"+miInpsectMst1IdReviewId);
			MiTankInspect mst1remarksbyreviewid = (MiTankInspect) jdbcTemplate8.queryForObject(sql ,new Object[]{miInpsectMst1IdReviewId},
					new RowMapper<Object>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							MiTankInspect mst1r = new MiTankInspect();
							mst1r.setMiInpsectMst1IdReviewId(rs.getInt(1));
							mst1r.setMiInpsectMst1Id(rs.getInt(2));
							mst1r.setTankId(rs.getLong(3));
							mst1r.setLatestRemarks(rs.getBoolean(4));
							mst1r.setLevelId(rs.getInt(5));
							mst1r.setRemarks(rs.getString(6));
							mst1r.setTabId(rs.getInt(7));
							mst1r.setTankWeirSluiceId(rs.getInt(8));
							mst1r.setPostId(rs.getLong(9));
							mst1r.setNextPostId(rs.getLong(10));
							
							return mst1r;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("mst1remarksbyreviewid"+mst1remarksbyreviewid);
			return mst1remarksbyreviewid;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public MiTankInspect getCapacityremarksbyreviewId(Integer mitankCapacityReviewId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = EDIT_GET_CAPACITYREMARKS_BYREVIEWID;
		try {
			
		//	System.out.println("miInpsectMst1IdReviewId daoimpl"+miInpsectMst1IdReviewId);
			MiTankInspect mst1remarksbyreviewid = (MiTankInspect) jdbcTemplate8.queryForObject(sql ,new Object[]{mitankCapacityReviewId},
					new RowMapper<Object>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							MiTankInspect mcapr = new MiTankInspect();
							mcapr.setMitankCapacityReviewId(rs.getInt(1));
							mcapr.setMitankCapacityId(rs.getInt(2));
							mcapr.setTankId(rs.getLong(3));
							mcapr.setLatestRemarks(rs.getBoolean(4));
							mcapr.setLevelId(rs.getInt(5));
							mcapr.setRemarks(rs.getString(6));
						
						
							mcapr.setPostId(rs.getLong(7));
							mcapr.setNextPostId(rs.getLong(8));
							mcapr.setTankWeirSluiceId(0);
							mcapr.setTabId(6);
							
							return mcapr;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("mst1remarksbyreviewid"+mst1remarksbyreviewid);
			return mst1remarksbyreviewid;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	@Override
	public Integer updateMst1remarksByreviewid(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		 //System.out.println(" miObj.getMiInpsectMst1IdReviewId()"+ miObj.getMiInpsectMst1IdReviewId());
		// System.out.println("remarks and username"+miObj.getRemarks()+" "+miObj.getUserName());
		String sql3 = UPDATE_TANKREMARKS_BWS_BYMST1ID;		 
		Integer result2=0;
		try {
			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 if( miObj.getMiInpsectMst1IdReviewId()!=null){
						 result2  = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getRemarks(),miObj.getMiInpsectMst1IdReviewId());
						// System.out.println("result2"+result2);
				 }
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result2;
	}
	
	
	@Override
	public Integer updateMstCapacityremarksByreviewid(final MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		 //System.out.println(" miObj.getMiInpsectMst1IdReviewId()"+ miObj.getMiInpsectMst1IdReviewId());
		// System.out.println("remarks and username"+miObj.getRemarks()+" "+miObj.getUserName());
		String sql3 = UPDATE_CAPACITYREMARKS_BWS_BYMST1ID;		 
		Integer result2=0;
		try {
			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miObj!=null){
				 if( miObj.getMitankCapacityReviewId()!=null){
						 result2  = jdbcTemplate8.update(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getRemarks(),miObj.getMitankCapacityReviewId());
						// System.out.println("result2"+result2);
				 }
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result2;
	}
	
	@Override
	public List<MiTankInspect> getTankRepairdatabyId(Integer tankRepairdescId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_REPAIRDESC_BY_DESCID;
		try {
			
			//System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR);

			List<MiTankInspect> repairdescList = jdbcTemplate8.query(sql ,new Object[]{tankRepairdescId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect repairdesc = new MiTankInspect();
							
						
							repairdesc.setRepairdescId(rs.getInt(1));
							
							repairdesc.setTankId(rs.getLong(2));
							
							repairdesc.setRepairDescription(rs.getString(3));
							repairdesc.setRepairStartDate(rs.getString(4));
							repairdesc.setRepairEndDate(rs.getString(5));
							repairdesc.setSchemeTaken(rs.getString(6));
							repairdesc.setUserId(rs.getInt(7));
							repairdesc.setUserName(rs.getString(8));
							
							repairdesc.setDesignationId(rs.getInt(9));
							
							repairdesc.setLevelId(rs.getInt(10));
							
					
							return repairdesc;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return repairdescList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<Constituency> getConstByDistId(Integer distId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_CONST_BY_DISTID;
		
		//System.out.println("rs.getInt(1)");
		try {

			List<Constituency> mitankChecksList = jdbcTemplate8.query(sql,new Object[]{distId},
					new RowMapper<Constituency>() {

						public Constituency mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							
						

							Constituency mtc = new Constituency();
							
							//System.out.println("rs.getInt(1)"+rs.getInt(1));
							mtc.setConstId(rs.getInt(1));
							mtc.setConstName(rs.getString(2));
							mtc.setDistrictId(rs.getInt(3));
							//mtc.setAcCode(rs.getInt(4));
						
							return mtc;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return mitankChecksList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<MiTankInspect> viewRepairRemarks(Integer repairId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = VIEW_REPAIRS_REMARKS;
		try {
			
			//System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{repairId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
							mitankinspect.setMitankRepairsReviewId(rs.getInt(1));
							mitankinspect.setMitankRepairsId(rs.getInt(2));
							mitankinspect.setTankId(rs.getLong(3));
							mitankinspect.setLatestRemarks(rs.getBoolean(4));
							mitankinspect.setSubmittedToEmpName(rs.getString(5));
					
							mitankinspect.setRemarks(rs.getString(6));
							
						mitankinspect.setRemarksSubmittedBy(rs.getString(7));
							mitankinspect.setNextDesignationId((rs.getInt(8)));
							mitankinspect.setDesignationId(rs.getInt(9));
							mitankinspect.setEmpId(rs.getInt(10));
							mitankinspect.setPostId(rs.getLong(11));
							mitankinspect.setNextPostId(rs.getLong(12));
							mitankinspect.setRepairRemarksDate(rs.getString(13));
							
			               
			
							
					
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
	public List<MiTankInspect> viewCapacityRemarks(Integer capacityId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = VIEW_CAPACITY_REMARKS;
		try {
			
			//System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{capacityId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
							mitankinspect.setMitankCapacityReviewId(rs.getInt(1));
							mitankinspect.setMitankCapacityId(rs.getInt(2));
							mitankinspect.setTankId(rs.getLong(3));
							mitankinspect.setLatestRemarks(rs.getBoolean(4));
							mitankinspect.setSubmittedToEmpName(rs.getString(5));
					
							mitankinspect.setRemarks(rs.getString(6));
							 mitankinspect.setRemarksSubmittedBy(rs.getString(7));
							
							
							mitankinspect.setNextDesignationId(rs.getInt(8));
							mitankinspect.setDesignationId(rs.getInt(9));
							mitankinspect.setEmpId(rs.getInt(10));
							mitankinspect.setPostId(rs.getLong(11));
							mitankinspect.setNextPostId(rs.getLong(12));
							mitankinspect.setCapacityRemarksDate(rs.getString(13));
							
			               
			
							
					
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
	public Integer deleteMitankInoutFlow(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	@Override
	public List<MiTankInspect> viewInflowRemarks(Integer inoutId) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = VIEW_INFLOW_REMARKS;
		try {
			
			//System.out.println("GET_MI_REPAIR"+GET_MI_REPAIR);

			List<MiTankInspect> miinflowoutflow = jdbcTemplate8.query(sql ,new Object[]{inoutId},
					new RowMapper<MiTankInspect>() {

						public MiTankInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankInspect mitankinspect = new MiTankInspect();
							
							mitankinspect.setMitankInoutFlowReviewId(rs.getInt(1));
							mitankinspect.setMitankInoutFlowId(rs.getInt(2));
							mitankinspect.setTankId(rs.getLong(3));
							mitankinspect.setLatestRemarks(rs.getBoolean(4));
							mitankinspect.setSubmittedTOEmp(rs.getInt(5));
					
							mitankinspect.setRemarks(rs.getString(6));
							
							mitankinspect.setSubmittedToEmpName(rs.getString(7));
							mitankinspect.setDesignationId(rs.getInt(8));
							mitankinspect.setDesignation(rs.getString(9));
			                mitankinspect.setRemarksSubmittedBy(rs.getString(10));
			                mitankinspect.setSubmittedBy(rs.getInt(11));
			
							
					
							return mitankinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return miinflowoutflow;
		} catch (Exception exc) {
			
			return null;
		}
	}*/
	
	
	@Override
	public List<District> source_mk_districts() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_DISTRICTS;
		
		try {
			
			List<District> sourcedistricts = mkTemplate.query(sql ,
					new RowMapper<District>() {

						public District mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							District district = new District();
							
							district.setDistrictCode(rs.getString(1));
							district.setDistrictName(rs.getString(2));
							district.setStatusCode(rs.getString(3));
							district.setStatmodifieddate(rs.getString(4));
							district.setOldDistrictCode(rs.getString(5));
					
							
			
							
					
							return district;
						}

					});
			mkTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sourcedistricts;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				mkTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageDistricts(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_DISTRICTS;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate10.update(sql);
			

					jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertDistricts(final List<District> distObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_DISTRICTS;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);
			 if(distObj!=null){
             	
				if (distObj.size() > 0) {
					if(distObj.get(0).getDistrictCode()!=null && distObj.get(0).getDistrictName()!=null ){
					j = jdbcTemplate10.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									District sd = distObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());
									

									 java.sql.Date date1 = null;
									
									// System.out.println("sd"+sd.getDistrictCode());

										ps.setString(1,  sd.getDistrictCode());
										
										ps.setString(2,  sd.getDistrictName());
										ps.setString(3, sd.getStatusCode());
										
										try {
											
											if (sd.getStatmodifieddate()!= null
													
													&& !sd.getStatmodifieddate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( sd.getStatmodifieddate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										ps.setDate(4,  date1);
										ps.setString(5,  sd.getOldDistrictCode());
										
							
								}

								@Override
								public int getBatchSize() {
									return distObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	

	
	
	@Override
	public List<Mandal> source_mk_mandals() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_MANDALS;
		
		try {
			
			List<Mandal> sourcemandals = mkTemplate.query(sql ,
					new RowMapper<Mandal>() {

						public Mandal mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Mandal mandal = new Mandal();
							
							mandal.setMandalId(rs.getInt(1));							
							mandal.setMandalCode(rs.getString(2));
							mandal.setMandalName(rs.getString(3));
							
							mandal.setStatusCode(rs.getString(4));
							mandal.setStatusModifiedDate(rs.getString(5));
							mandal.setDistrictCode(rs.getString(6));
							
					
							
			
							
					
							return mandal;
						}

					});
			mkTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sourcemandals;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				mkTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageMandals(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_MANDALS;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate10.update(sql);
			

					jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertMandals(final List<Mandal> mandalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_MANDALS;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);
			 if(mandalObj!=null){
             	
				if (mandalObj.size() > 0) {
					if(mandalObj.get(0).getDistrictCode()!=null && mandalObj.get(0).getMandalName()!=null && mandalObj.get(0).getMandalCode()!=null ){
					j = jdbcTemplate10.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Mandal sd = mandalObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());
									

									 java.sql.Date date1 = null;
									
									// System.out.println("sd"+sd.getDistrictCode());

										ps.setInt(1,  sd.getMandalId());
										
										ps.setString(2,  sd.getMandalCode());
										ps.setString(3, sd.getMandalName());
										ps.setString(4, sd.getStatusCode());
										
										try {
											
											if (sd.getStatusModifiedDate()!= null
													
													&& !sd.getStatusModifiedDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( sd.getStatusModifiedDate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										ps.setDate(5,  date1);
										ps.setString(6,  sd.getDistrictCode());
										
							
								}

								@Override
								public int getBatchSize() {
									return mandalObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public List<Constituency> sourceMkAssembly() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_CONST;
		
		try {
			
			List<Constituency> sourceconst = mkTemplate.query(sql ,
					new RowMapper<Constituency>() {

						public Constituency mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Constituency constt = new Constituency();
							
							
							constt.setAcode(rs.getString(1));
							constt.setConstName(rs.getString(2));
							constt.setStatusCode(rs.getString(3));
							constt.setStatusmodifyDate(rs.getString(4));
			
							
					
							return constt;
						}

					});
			mkTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sourceconst;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				mkTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageAssembly(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_CONST;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate10.update(sql);
			

					jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertAssembly(final List<Constituency> constObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_CONST;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);
			 if(constObj!=null){
             	
				if (constObj.size() > 0) {
					if(constObj.get(0).getAcode()!=null && constObj.get(0).getConstName()!=null  ){
					j = jdbcTemplate10.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Constituency sd = constObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());
									

									 java.sql.Date date1 = null;
									
									// System.out.println("sd"+sd.getDistrictCode());

										ps.setString(1,  sd.getAcode());
										
										ps.setString(2,  sd.getConstName());
										ps.setString(3, sd.getStatusCode());
									
										
										try {
											
											if (sd.getStatusmodifyDate()!= null
													
													&& !sd.getStatusmodifyDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( sd.getStatusmodifyDate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										ps.setDate(4,  date1);
										
										
							
								}

								@Override
								public int getBatchSize() {
									return constObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	@Override
	public List<Constituency> sourceMkAssemblyMandals() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_CONST_MANDALS;
		
		try {
			
			List<Constituency> sourceconst = mkTemplate.query(sql ,
					new RowMapper<Constituency>() {

						public Constituency mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Constituency constt = new Constituency();
							
							
							constt.setAcode(rs.getString(1));
							constt.setDcode(rs.getString(2));
							constt.setMcode(rs.getString(3));
							
						
							constt.setStatusCode(rs.getString(4));
							constt.setStatusmodifyDate(rs.getString(5));
							constt.setMandalId(rs.getInt(6));
			
							
					
							return constt;
						}

					});
			mkTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sourceconst;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				mkTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageAssemblyMandals(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_CONST_MANDALS;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate10.update(sql);
			

					jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertAssemblyMandals(final List<Constituency> constObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_CONST_MANDALS;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);
			 if(constObj!=null){
             	
				if (constObj.size() > 0) {
					if(constObj.get(0).getAcode()!=null && constObj.get(0).getDcode()!=null && constObj.get(0).getMcode()!=null  ){
					j = jdbcTemplate10.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Constituency sd = constObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());
									

									 java.sql.Date date1 = null;
									
									// System.out.println("sd"+sd.getAcode());

										ps.setString(1,  sd.getAcode());
										ps.setString(2,  sd.getDcode());
										ps.setString(3,  sd.getMcode());
										
										
										ps.setString(4, sd.getStatusCode());
									
										
										try {
											
											if (sd.getStatusmodifyDate()!= null
													
													&& !sd.getStatusmodifyDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( sd.getStatusmodifyDate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										ps.setDate(5,  date1);
										ps.setInt(6,  sd.getMandalId());
										
										
							
								}

								@Override
								public int getBatchSize() {
									return constObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	@Override
	public List<Village> sourceMkVillages() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_VILLAGES;
		
		try {
			
			List<Village> sourceconst = mkTemplate.query(sql ,
					new RowMapper<Village>() {

						public Village mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Village village = new Village();
							
							
							village.setVillageCode(rs.getString(1));
							village.setVillageName(rs.getString(2));
							village.setStatusCode(rs.getString(3));
							village.setStatusModifiedDate(rs.getString(4));
							village.setDcode(rs.getString(5));
							village.setMcode(rs.getString(6));
							village.setMandalId(rs.getInt(7));
							
							
					
							return village;
						}

					});
			mkTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sourceconst;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				mkTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageVillages(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_VILLAGES;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate10.update(sql);
			

					jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertVillages(final List<Village> villageObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_VILLAGES;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);
			 if(villageObj!=null){
             	
				if (villageObj.size() > 0) {
					if(villageObj.get(0).getDcode()!=null && villageObj.get(0).getMcode()!=null && villageObj.get(0).getVillageCode()!=null  ){
					j = jdbcTemplate10.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Village sd = villageObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());
									

									 java.sql.Date date1 = null;
									
									// System.out.println("sd"+sd.getAcode());
									 ps.setString(1,  sd.getVillageName());
									 ps.setString(2,  sd.getStatusCode());
										
										
										
										
										
										
									
										
										try {
											
											if (sd.getStatusModifiedDate()!= null
													
													&& !sd.getStatusModifiedDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( sd.getStatusModifiedDate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										ps.setDate(3,  date1);
										ps.setInt(4,  sd.getMandalId());
										ps.setString(5,  sd.getDcode());
										ps.setString(6,  sd.getMcode());
										ps.setString(7,  sd.getVillageCode());
								
								}

								@Override
								public int getBatchSize() {
									return villageObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	@Override
	public List<Habitations> sourceMkHabitations() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HABITATION;
		
		try {
			
			List<Habitations> sourceconst = mkTemplate.query(sql ,
					new RowMapper<Habitations>() {

						public Habitations mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Habitations habitations = new Habitations();
							
							
							habitations.setHcode(rs.getString(1));
							habitations.setHname(rs.getString(2));
							habitations.setStatusMode(rs.getString(3));
							habitations.setStatusModifyDate(rs.getString(4));
							habitations.setDcode(rs.getString(5));
							habitations.setMcode(rs.getString(6));
							habitations.setVcode(rs.getString(7));
							habitations.setMandalId(rs.getInt(8));
							

							
							
					
							return habitations;
						}

					});
			mkTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sourceconst;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				mkTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageHabitations(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_HABITATION;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate10.update(sql);
			

					jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertHabitations(final List<Habitations> habitationObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_HABITATION;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);
			 if(habitationObj!=null){
             	
				if (habitationObj.size() > 0) {
					if(habitationObj.get(0).getHcode()!=null && habitationObj.get(0).getHname()!=null  ){
					j = jdbcTemplate10.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Habitations sd = habitationObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());
									

									 java.sql.Date date1 = null;
									
									// System.out.println("sd"+sd.getAcode());
									 ps.setString(1,  sd.getHname());
									 ps.setString(2,  sd.getStatusMode());
										
										
										
										
										
										
									
										
										try {
											
											if (sd.getStatusModifyDate()!= null
													
													&& !sd.getStatusModifyDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( sd.getStatusModifyDate());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										ps.setDate(3,  date1);
										ps.setInt(4,  sd.getMandalId());
										ps.setString(5,  sd.getDcode());
										ps.setString(6,  sd.getMcode());
										ps.setString(7,  sd.getVcode()	);
										ps.setString(8,  sd.getHcode());
								
								}

								@Override
								public int getBatchSize() {
									return habitationObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public List<Tanks> sourceMkTanksInfo() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_TANKS_INFO;
		
		try {
			
			List<Tanks> sourceconst = mkTemplate.query(sql ,
					new RowMapper<Tanks>() {

						public Tanks mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Tanks tankinfo = new Tanks();
							
							
							tankinfo.setTankpkey(rs.getInt(1));
							tankinfo.setTankName(rs.getString(2));
							tankinfo.setTankId(rs.getLong(3));
							tankinfo.setAcode(rs.getString(4));
							tankinfo.setAyacut(rs.getDouble(5));
							tankinfo.setBundLength(rs.getDouble(6));
							tankinfo.setPreworkCapacity(rs.getDouble(7));
							tankinfo.setSectionId(rs.getInt(8));
							tankinfo.setSourceType(rs.getInt(9));
							tankinfo.setAyacutType(rs.getDouble(10));
							
							tankinfo.setBasin(rs.getString(11));
							tankinfo.setSubBasin(rs.getString(12));
							tankinfo.setDcode(rs.getString(13));
							tankinfo.setMcode(rs.getString(14));
							tankinfo.setVcode(rs.getString(15));
							tankinfo.setHcode(rs.getString(16));
							tankinfo.setWaterSpreadAreaAcres(rs.getDouble(17));
							tankinfo.setGeo_id(rs.getDouble(18));
							tankinfo.setWeir_length(rs.getInt(19));
							tankinfo.setSluiceCount(rs.getInt(20));
							tankinfo.setSluiceType(rs.getString(21));
							tankinfo.setIpWet(rs.getDouble(22));
							tankinfo.setIpId(rs.getDouble(23));
							tankinfo.setNewCheckDam(rs.getBoolean(24));
							tankinfo.setIsNrld(rs.getBoolean(25));
							tankinfo.setNrldCode(rs.getString(26));
							
							tankinfo.setLatitude(rs.getString(27));
							
							tankinfo.setLongitude(rs.getString(28));
							
							

							
							
					
							return tankinfo;
						}

					});
			mkTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sourceconst;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				mkTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageTanks(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_TANKS;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate10.update(sql);
			

					jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertTanksInfo(final List<Tanks> tanksObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_TANKS;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate10.getDataSource().getConnection().setAutoCommit(false);
			 if(tanksObj!=null){
             	
				if (tanksObj.size() > 0) {
					if(tanksObj.get(0).getTankId()!=null && tanksObj.get(0).getTankName()!=null  ){
					j = jdbcTemplate10.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Tanks sd = tanksObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());
									
									
									
								
									
									
									
									
								
									
								
									
								
								
									
									
									
									
								
									
									
									
									
								
									
									
									 java.sql.Date date1 = null;
									
									// System.out.println("sd"+sd.getAcode());
									 ps.setInt(1,  sd.getTankpkey());
									 ps.setString(2,  sd.getTankName());
									 ps.setLong(3,  sd.getTankId());
									 ps.setString(4,  sd.getAcode());
									 ps.setDouble(5,  sd.getAyacut());
									 ps.setDouble(6,  sd.getBundLength());
									 ps.setDouble(7,  sd.getPreworkCapacity());
									 ps.setInt(8,  sd.getSectionId());
									 ps.setInt(9,  sd.getSourceType());
									 ps.setDouble(10,  sd.getAyacutType());
									
									 ps.setString(11,  sd.getBasin());
									 ps.setString(12,  sd.getSubBasin());
									 ps.setString(13,  sd.getDcode());
									 ps.setString(14,  sd.getMcode());
									 ps.setString(15,  sd.getVcode());
									 ps.setString(16,  sd.getHcode());
									 ps.setDouble(17,  sd.getWaterSpreadAreaAcres());
									 ps.setDouble(18,  sd.getGeo_id());
									 ps.setDouble(19,  sd.getWeir_length());
									 ps.setDouble(20,  sd.getSluiceCount());
									 ps.setString(21,  sd.getSluiceType());
									 ps.setDouble(22,  sd.getIpWet());
									 ps.setDouble(23,  sd.getIpId());
									 ps.setBoolean(24,  sd.getNewCheckDam());
									 ps.setBoolean(25, sd.getIsNrld());
									 ps.setString(26, sd.getNrldCode());
									 ps.setString(27, sd.getLatitude());
									 ps.setString(28, sd.getLongitude());
									 
										
										
										
								
								}

								@Override
								public int getBatchSize() {
									return tanksObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate10.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public List<Habitations> getHabitations(Integer dcode,Integer mcode,Integer vcode) throws InventoryUserException {
		
		//System.out.println("impl"+dcode+mcode+vcode);
		// TODO Auto-generated method stub
		String sql = SELECT_HABITATION;
		
	
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
			List<Habitations> habitationList = jdbcTemplate.query(sql ,new Object[]{dcode,mcode,vcode},
					new RowMapper<Habitations>() {
				
			
						public Habitations mapRow(ResultSet rs, int rowNum)
								throws SQLException {
	
							
							
					//	System.out.println("impl"+rs.getString(1));
							Habitations habitations = new Habitations();
							
							habitations.setHname(rs.getString(1));
							habitations.setMandalId(rs.getInt(2));
							habitations.setdId(rs.getInt(3));
							habitations.setmId(rs.getInt(4));
							habitations.setvId(rs.getInt(5));
							habitations.sethId(rs.getInt(6));
							
							return habitations;
						}

					});
			
			// System.out.println("sql"+sql);
			jdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("impl2"+ReservoirSalientList);
			return habitationList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public List<Employee> sourceHrmsEmpMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_EMP_MST;
		
		try {
			
			List<Employee> sourceempmst = hrmsjdbcTemplate.query(sql ,
					new RowMapper<Employee>() {

						public Employee mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Employee empinfo = new Employee();
							
							empinfo.setEmpId(Integer.parseInt(rs.getString(1)));
							empinfo.setEmployeeName(rs.getString(2));
							empinfo.setDesignationId(rs.getInt(3));
							empinfo.setEmpStatus(rs.getInt(4));
							empinfo.setEmailId(rs.getString(5));
							empinfo.setPhoneNum1(rs.getString(6));
							
							

							
							
					
							return empinfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sourceempmst;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageEmpMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_EMP_MST;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertEmpMst(final List<Employee> empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_EMP_MST;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(empObj!=null){
             	
				if (empObj.size() > 0) {
					if(empObj.get(0).getEmpId()!=null && empObj.get(0).getEmployeeName()!=null  ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Employee sd = empObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());
									

									 java.sql.Date date1 = null;
									
									// System.out.println("sd"+sd.getAcode());
									 ps.setString(1,  sd.getEmployeeName());
									 ps.setInt(2,  sd.getDesignationId());
									 ps.setInt(3,  sd.getEmpStatus());
									 ps.setString(4,  sd.getEmailId());
									 ps.setString(5,  sd.getPhoneNum1());
									 ps.setInt(6,  sd.getEmpId());
									
								
								}

								@Override
								public int getBatchSize() {
									return empObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public List<Employee> sourceHrmsAdditionalCharge() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_ADDNL_CHARGE;
		
		try {
			
			List<Employee> sourceempmst = hrmsjdbcTemplate.query(sql ,
					new RowMapper<Employee>() {

						public Employee mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Employee empinfo = new Employee();
							
							empinfo.setUnitId(rs.getInt(1));
							empinfo.setCircleId(rs.getInt(2));
							empinfo.setDivisionId(rs.getInt(3));
							empinfo.setSubdivisionId(rs.getInt(4));
							empinfo.setSectionId(rs.getInt(5));
							empinfo.setPostId(Long.parseLong(rs.getString(6)));
							empinfo.setFromDate(rs.getString(7));
							empinfo.setEmpId(Integer.parseInt(rs.getString(8)));
							empinfo.setPostType(rs.getString(9));
							empinfo.setToDate(rs.getString(10));
							
					
					
							return empinfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sourceempmst;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageAdditionalCharge(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_ADDNL_CHARGE;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertAdditionalCharge(final List<Employee> empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_ADDNL_CHARGE;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(empObj!=null){
             	
				if (empObj.size() > 0) {
					if(empObj.get(0).getEmpId()!=null && empObj.get(0).getPostId()!=null  ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Employee sd = empObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());
									
									 java.sql.Date date1 = null;
									 java.sql.Date date2 = null;
										try {
											
											if (sd.getFromDate()!= null
													&& sd.getFromDate() != ""
													&& !sd.getFromDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate( sd.getFromDate().trim().toString());
											}
											
											if (sd.getToDate()!= null
													&& sd.getToDate() != ""
													&& !sd.getToDate().equals('0')) {
											
											date2 = DateUtil.getSQLDate( sd.getToDate().trim().toString());
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

									
									 
									 
									
									// System.out.println("sd"+sd.getAcode());
									 ps.setInt(1,  sd.getUnitId());
									 ps.setInt(2,  sd.getCircleId());
									 ps.setInt(3,  sd.getDivisionId());
									 ps.setInt(4,  sd.getSubdivisionId());
									 ps.setInt(5,  sd.getSectionId());
									 ps.setLong(6,  sd.getPostId());
									 ps.setDate(7,  date1);
									 ps.setString(8,  sd.getEmpId().toString());
									 ps.setString(9,  sd.getPostType());
									 ps.setDate(10,  date2);
									
								
								}

								@Override
								public int getBatchSize() {
									return empObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	@Override
	public List<Designation> sourceHrmsDesignationMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_DESIGNATION_MST;
		
		try {
			
			List<Designation> sourcedesigmst = hrmsjdbcTemplate.query(sql ,
					new RowMapper<Designation>() {

						public Designation mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Designation desiginfo = new Designation();
							desiginfo.setDesignationId(rs.getInt(1));
							desiginfo.setDesignationName(rs.getString(2));
							desiginfo.setHierarchy(rs.getInt(3));
							desiginfo.setDesignation_type(rs.getString(4));
							
							
					
					
							return desiginfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sourcedesigmst;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageDesignationMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_DESIGNATION_MST;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertDesignationMst(final List<Designation> desObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_DESIGNATION_MST;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(desObj!=null){
             	
				if (desObj.size() > 0) {
					if(desObj.get(0).getDesignationId()!=null && desObj.get(0).getDesignationName()!=null  ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Designation sd = desObj.get(i);
									
							
								
									 ps.setInt(1,  sd.getDesignationId());
									 ps.setString(2,  sd.getDesignationName());
									 ps.setString(3,  sd.getDesignation_type());
									 ps.setInt(4,  sd.getHierarchy());
									
								
								}

								@Override
								public int getBatchSize() {
									return desObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	
	@Override
	public List<Employee> sourceHrmsPreaentPostEmp() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_PRESENT_POST_EMP;
		
		try {
			
			List<Employee> employeeppelist = hrmsjdbcTemplate.query(sql ,
					new RowMapper<Employee>() {

						public Employee mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Employee ppeinfo = new Employee();
							
							

							
							
							ppeinfo.setUnitId(rs.getInt(1));
							ppeinfo.setCircleId(rs.getInt(2));
							ppeinfo.setDivisionId(rs.getInt(3));
							ppeinfo.setSubdivisionId(rs.getInt(4));
							ppeinfo.setSectionId(rs.getInt(5));
							ppeinfo.setDesignationId(rs.getInt(6));
							ppeinfo.setPostId(rs.getLong(7));
							ppeinfo.setPostFromDate(rs.getString(8));
			ppeinfo.setWorkType(rs.getString(9));
			ppeinfo.setEmpId(rs.getInt(10));
			ppeinfo.setUpdateStatus(rs.getString(11));
							
							
							
					
					
							return ppeinfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return employeeppelist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStagePresentPostEMP(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_PRESENT_POST_EMP;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertPresentPostEmp(final List<Employee> empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_PRESENT_POST_EMP;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(empObj!=null){
             	
				if (empObj.size() > 0) {
					if(empObj.get(0).getPostId()!=null ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Employee sd = empObj.get(i);
									 java.sql.Date date1 =null;
										try {
											
											if (sd.getPostFromDate()!= null
													&& sd.getPostFromDate() != ""
													&& !sd.getPostFromDate().equals('0')) {
											
											date1 = DateUtil.getSQLDate(sd.getPostFromDate());
											}
											
											
											
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
							
								
									 ps.setInt(1,  sd.getUnitId());
									 ps.setInt(2,  sd.getCircleId());
									 ps.setInt(3,  sd.getDivisionId());
									 ps.setInt(4,  sd.getSubdivisionId());
									 ps.setInt(5,  sd.getSectionId());
									 ps.setInt(6,  sd.getDesignationId());
									 
									 ps.setLong(7,  sd.getPostId());
									 ps.setDate(8,  date1);
									 ps.setString(9,  sd.getWorkType());
									 ps.setInt(10,  sd.getEmpId());
									 ps.setString(11,  sd.getUpdateStatus());
									
								
								}

								@Override
								public int getBatchSize() {
									return empObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public List<Employee> sourceHrmsSubposts() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_subposts;
		
		try {
			
			List<Employee> employeeppelist = hrmsjdbcTemplate.query(sql ,
					new RowMapper<Employee>() {

						public Employee mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Employee  subinfo = new Employee();
							
							

							subinfo.setOfficeId(rs.getInt(1));
							subinfo.setPostId(rs.getLong(2));
							subinfo.setPostName(rs.getString(3));
							subinfo.setDesignationId(rs.getInt(4));
							subinfo.setPostNo(rs.getLong(5));
							subinfo.setUnitId(rs.getInt(6));
							subinfo.setCircleId(rs.getInt(7));
							subinfo.setDivisionId(rs.getInt(8));
							subinfo.setSubdivisionId(rs.getInt(9));
							subinfo.setSectionId(rs.getInt(10));
							subinfo.setStatus(rs.getInt(11));
							subinfo.setHeadquarterId(rs.getInt(12));
							subinfo.setPostStatus(rs.getString(13));
							subinfo.setPresentStatusId(rs.getInt(14));
							subinfo.setOldPostId(rs.getLong(15));
							subinfo.setEffectiveFrom(rs.getString(16));
							
			
			
							
							
							
					
					
							return subinfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return employeeppelist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageSubPosts(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_subposts;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertSubpostsEmp(final List<Employee> empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_subposts;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(empObj!=null){
             	
				if (empObj.size() > 0) {
					if(empObj.get(0).getPostId()!=null ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Employee sd = empObj.get(i);
									 java.sql.Date date1 =null;
										try {
											
											if (sd.getEffectiveFrom()!= null
													&& sd.getEffectiveFrom() != ""
													&& !sd.getEffectiveFrom().equals('0')) {
											
											date1 = DateUtil.getSQLDate(sd.getEffectiveFrom());
											}
											
											
											
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
							
								
									 ps.setInt(1,  sd.getOfficeId());
									 ps.setLong(2,  sd.getPostId());
									 ps.setString(3,  sd.getPostName());
									 ps.setInt(4,  sd.getDesignationId());
									 ps.setLong(5,  sd.getPostNo());
									 ps.setInt(6,  sd.getUnitId());
									 
									 ps.setInt(7,  sd.getCircleId());
									 ps.setInt(8,  sd.getDivisionId());
									 ps.setInt(9,  sd.getSubdivisionId());
									 ps.setInt(10,  sd.getSectionId());
									 ps.setInt(11,  sd.getStatus());
									 ps.setInt(12,  sd.getHeadquarterId());
									 ps.setString(13,  sd.getPostStatus());
									 ps.setInt(14,  sd.getPresentStatusId());
									 ps.setLong(15,  sd.getOldPostId());
									 ps.setDate(16, date1);
									
									
								
								}

								@Override
								public int getBatchSize() {
									return empObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	
	@Override
	public List<Unit> sourceHrmsUnitMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_UNIT_MASTER;
		
		try {
			
			List<Unit> employeeppelist = hrmsjdbcTemplate.query(sql ,
					new RowMapper<Unit>() {

						public Unit mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Unit  unitinfo = new Unit();
							
							unitinfo.setUnitId(rs.getInt(1));
							unitinfo.setUnitName(rs.getString(2));
							unitinfo.setHeadquarterId(rs.getInt(3));
							unitinfo.setStatus(rs.getString(4));
							unitinfo.setOfficeAddress(rs.getString(5));
							unitinfo.setEmailId(rs.getString(6));
				
							return unitinfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return employeeppelist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageUnitMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_UNIT_MASTER;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertUnitMst(final List<Unit>  unitObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_UNIT_MASTER;
		
		

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(unitObj!=null){
             	
				if (unitObj.size() > 0) {
					if(unitObj.get(0).getUnitId()!=null ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Unit sd = unitObj.get(i);
									 						
								
									 ps.setInt(1,  sd.getUnitId());
									 ps.setString(2,  sd.getUnitName());
									 ps.setInt(3,  sd.getHeadquarterId());
									 ps.setString(4,  sd.getStatus());
									 ps.setString(5,  sd.getOfficeAddress());
									 ps.setString(6,  sd.getEmailId());
					
								
								}

								@Override
								public int getBatchSize() {
									return unitObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows1);
					
					
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	@Override
	public Integer getbaseupdatesUnitMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_UNIT_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_unit_master_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	
	@Override
	public Integer getbaseupdatesCircleMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_CIRCLE_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_circle_master_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesDivisionMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_DIVISION_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_division_master_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesSubDivisionMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_SUBDIVISION_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_subdivision_master_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesSectionMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_SECTION_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_section_master_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesSubpostsMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_SUBPOSTS_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_subpost_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesAddnlChargeMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_ADDNLCHARGE_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_addnl_charge_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesPPeMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_PPE_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_ppe_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesEmpMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_EMP_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_employee_mst_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesDesgMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_DESG_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_designation_mst_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesUsersMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_USERS_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_users_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesTanksInfo() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_TANKS_INFO;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_tanks_info_update_from_stage()").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	@Override
	public Integer getbaseupdatesEmpdivMaster() throws InventoryUserException {

		String sql4=SELECT_BASE_UPDATES_EMP_DIV_MASTER;
		Boolean flag=false;
		Integer ucount=0;
		try {

			
			//System.out.println("ucount1"+ucount);

			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {} );
			
			
			for (Map<String, Object> row : ct) {
				ucount = Integer.parseInt(row.get("get_emp_diversion_update_from_stage").toString());
				
				
			}
	      
		
			jdbcTemplate.getDataSource().getConnection().close();
	        
			return ucount;
		} catch (Exception exc) {
			//log.error(exc.getMessage());
			return ucount;
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	
	
	
	@Override
	public List<Circle> sourceHrmsCircleMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_CIRCLE_MST;
		
		try {
			
			List<Circle> circlelist = hrmsjdbcTemplate.query(sql ,
					new RowMapper<Circle>() {

						public Circle mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Circle   circleinfo = new Circle();
							
							circleinfo.setCircleId(rs.getInt(1));
							circleinfo.setCircleName(rs.getString(2));
							circleinfo.setUnitId(rs.getInt(3));
							circleinfo.setHeadquarterId(rs.getInt(4));
							circleinfo.setStatus(rs.getString(5));
							circleinfo.setOfficeAdress(rs.getString(6));
							circleinfo.setEmail(rs.getString(7));
							circleinfo.setOldCircleId(rs.getInt(8));
							circleinfo.setOldUnitId(rs.getInt(9));
							circleinfo.setEffectiveFrom(rs.getString(10));
				
							return circleinfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return circlelist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageCircleMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_CIRCLE_MST;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertCircleMst(final List<Circle>  circleObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_CIRCLE_MST;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(circleObj!=null){
             	
				if (circleObj.size() > 0) {
					if(circleObj.get(0).getCircleId()!=0 ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Circle sd = circleObj.get(i);
									
									java.sql.Date date1 =null;
									try {
										
										if (sd.getEffectiveFrom()!= null
												&& sd.getEffectiveFrom() != ""
												&& !sd.getEffectiveFrom().equals('0')) {
										
										date1 = DateUtil.getSQLDate(sd.getEffectiveFrom());
										}
										
										
										
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
						
									 						
								
									 ps.setInt(1,  sd.getCircleId());
									 ps.setString(2,  sd.getCircleName());
									 ps.setInt(3,  sd.getUnitId());
									 ps.setInt(4,  sd.getHeadquarterId());
									 ps.setString(5,  sd.getStatus());
									 ps.setString(6,  sd.getOfficeAdress());
									 ps.setString(7,  sd.getEmail());
									 ps.setInt(8,  sd.getOldCircleId());
									 ps.setInt(9,  sd.getOldUnitId());		
									 ps.setDate(10,  date1);		
								
								}

								@Override
								public int getBatchSize() {
									return circleObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public List<Division> sourceHrmsDivisionMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_DIVISION_MST;
		
		try {
			
			List<Division> circlelist = hrmsjdbcTemplate.query(sql ,
					new RowMapper<Division>() {

						public Division mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Division    divisioninfo = new Division();
							
							
							divisioninfo.setDivisionId(rs.getInt(1));
							divisioninfo.setDivisionName(rs.getString(2));
							divisioninfo.setCircleId(rs.getInt(3));							
							
							divisioninfo.setHeadquarterId(rs.getInt(4));
							divisioninfo.setStatus(rs.getString(5));
							divisioninfo.setOfficeaddress(rs.getString(6));
							divisioninfo.setEmail(rs.getString(7));
							divisioninfo.setOldDivisionId(rs.getInt(8));
							divisioninfo.setOldCircleId(rs.getInt(9));
							divisioninfo.setEffectiveFrom(rs.getString(10));
				
							return divisioninfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return circlelist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageDivisionMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_DIVISION_MST;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertDivisionMst(final List<Division>  divisionObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_DIVISION_MST;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(divisionObj!=null){
             	
				if (divisionObj.size() > 0) {
					if(divisionObj.get(0).getDivisionId()!=0 ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Division sd = divisionObj.get(i);
									
									java.sql.Date date1 =null;
									try {
										
										if (sd.getEffectiveFrom()!= null
												&& sd.getEffectiveFrom() != ""
												&& !sd.getEffectiveFrom().equals('0')) {
										
										date1 = DateUtil.getSQLDate(sd.getEffectiveFrom());
										}
										
										
										
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
						
									 						
								
									 ps.setInt(1,  sd.getDivisionId());
									 ps.setString(2,  sd.getDivisionName());
									 ps.setInt(3,  sd.getCircleId());
									 ps.setInt(4,  sd.getHeadquarterId());
									 ps.setString(5,  sd.getStatus());
									 ps.setString(6,  sd.getOfficeaddress());
									 ps.setString(7,  sd.getEmail());
									 ps.setInt(8,  sd.getOldDivisionId());
									 ps.setInt(9,  sd.getOldCircleId());		
									 ps.setDate(10,  date1);		
								
								}

								@Override
								public int getBatchSize() {
									return divisionObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	
	@Override
	public List<Subdivision> sourceHrmsSubDivisionMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_sub_division_mst;
		
		try {
			
			List<Subdivision> circlelist = hrmsjdbcTemplate.query(sql ,
					new RowMapper<Subdivision>() {

						public Subdivision mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Subdivision    subdivisioninfo = new Subdivision();
							
							subdivisioninfo.setSubdivisionId(rs.getInt(1));
							subdivisioninfo.setSubdivisionName(rs.getString(2));
							subdivisioninfo.setDivisionId(rs.getInt(3));
							
							subdivisioninfo.setCircleId(rs.getInt(4));							
							
							subdivisioninfo.setHeadquarterId(rs.getInt(5));
							subdivisioninfo.setStatus(rs.getString(6));
							subdivisioninfo.setOfficeAddress(rs.getString(7));
							subdivisioninfo.setEmail(rs.getString(8));
							subdivisioninfo.setOldsubdivisionId(rs.getInt(9));
							subdivisioninfo.setOlddivisionId(rs.getInt(10));
							subdivisioninfo.setOldCircleId(rs.getInt(11));
							subdivisioninfo.setEffectiveFrom(rs.getString(12));
				
							return subdivisioninfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return circlelist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageSubDivisionMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_sub_division_mst;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertSubDivisionMst(final List<Subdivision>  subdivisionObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_sub_division_mst;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(subdivisionObj!=null){
             	
				if (subdivisionObj.size() > 0) {
					if(subdivisionObj.get(0).getSubdivisionId()!=0 ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Subdivision sd = subdivisionObj.get(i);
									
									java.sql.Date date1 =null;
									try {
										
										if (sd.getEffectiveFrom()!= null
												&& sd.getEffectiveFrom() != ""
												&& !sd.getEffectiveFrom().equals('0')) {
										
										date1 = DateUtil.getSQLDate(sd.getEffectiveFrom());
										}
										
										
										
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
						
									 						
								
									 ps.setInt(1,  sd.getSubdivisionId());
									 ps.setString(2,  sd.getSubdivisionName());
									 ps.setInt(3,  sd.getDivisionId());
									 ps.setInt(4,  sd.getCircleId());
									 ps.setInt(5,  sd.getHeadquarterId());
									 ps.setString(6,  sd.getStatus());
									 ps.setString(7,  sd.getOfficeAddress());
									 ps.setString(8,  sd.getEmail());
									 ps.setInt(9,  sd.getOldsubdivisionId());									
									 ps.setInt(10,  sd.getOlddivisionId());
									 ps.setInt(11,  sd.getOldCircleId());		
									 ps.setDate(12,  date1);		
								
								}

								@Override
								public int getBatchSize() {
									return subdivisionObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	@Override
	public List<Sectiondata> sourceHrmsSectionMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_section_mst;
		
		try {
			
			List<Sectiondata>   sectionlist = hrmsjdbcTemplate.query(sql ,
					new RowMapper<Sectiondata>() {

						public Sectiondata mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Sectiondata    sectioninfo = new Sectiondata();
							
							sectioninfo.setSectionId(rs.getInt(1));
							sectioninfo.setSectionName(rs.getString(2));
							sectioninfo.setSubdivisionId(rs.getInt(3));
							sectioninfo.setDivisionId(rs.getInt(4));							
							sectioninfo.setCircleId(rs.getInt(5));							
							sectioninfo.setHeadquarterId(rs.getInt(6));
							sectioninfo.setStatus(rs.getString(7));
							sectioninfo.setOfficeAddress(rs.getString(8));
							sectioninfo.setEmail(rs.getString(9));
							sectioninfo.setOldSectionId(rs.getInt(10));
							sectioninfo.setOldCircleId(rs.getInt(11));
							sectioninfo.setOldDivisionId(rs.getInt(12));
							sectioninfo.setOldSubdivisionId(rs.getInt(13));					
				
				
							return sectioninfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return sectionlist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageSectionMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_section_mst;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertSectionMst(final List<Sectiondata>  sectiondataObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_section_mst;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(sectiondataObj!=null){
             	
				if (sectiondataObj.size() > 0) {
					if(sectiondataObj.get(0).getSectionId()!=0 ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									Sectiondata sd = sectiondataObj.get(i);
									
									 ps.setInt(1,  sd.getSectionId());
									 ps.setString(2,  sd.getSectionName());
									 ps.setInt(3,  sd.getSubdivisionId());
									 ps.setInt(4,  sd.getDivisionId());
									 ps.setInt(5,  sd.getCircleId());
									 ps.setInt(6,  sd.getHeadquarterId());
									 ps.setString(7,  sd.getStatus());
									 ps.setString(8,  sd.getOfficeAddress());
									 ps.setString(9,  sd.getEmail());
									 ps.setInt(10,  sd.getOldSectionId());	
									 ps.setInt(11,  sd.getOldCircleId());
									 ps.setInt(12,  sd.getOldDivisionId());	
									 ps.setInt(13,  sd.getOldSubdivisionId());									
									
								
								
								}

								@Override
								public int getBatchSize() {
									return sectiondataObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	
	@Override
	public List<User> sourceHrmsUserEmp() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_users;
		
		try {
			
			List<User>   userslistlist = hrmsjdbcTemplate.query(sql ,
					new RowMapper<User>() {

						public User mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							User    uinfo = new User();
							
							uinfo.setUserName(rs.getString(1));
							uinfo.setPassword(rs.getString(2));
							uinfo.setRoleId(rs.getInt(3));
							uinfo.setAccess(rs.getString(4));
							uinfo.setEmpId(Integer.parseInt(rs.getString(5)));
							
						
							return uinfo;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return userslistlist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageUsers(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_users;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertUserMst(final List<User>  usObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_users;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(usObj!=null){
             	
				if (usObj.size() > 0) {
					if(usObj.get(0).getUserName()!=null ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									User sd = usObj.get(i);
									
									 ps.setString(1,  sd.getUserName());
									 ps.setString(2,  sd.getPassword());
									 ps.setInt(3,  sd.getRoleId());
									 ps.setString(4,  sd.getAccess());
									 ps.setString(5,  sd.getEmpId().toString());
									
								}

								@Override
								public int getBatchSize() {
									return usObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	
	
	@Override
	public List<Tanks> getTankSectionMap(User user) throws InventoryUserException {
		
		//System.out.println(user.getCircleId()+"--"+user.getDivisionId()+"imp "+user.getSubdivisionId()+"--"+user.getSectionId());
		// TODO Auto-generated method stub
		String sql =null;
				
				if(user!=null){
					
					if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null && user.getPost()!=null && (user.getDesignationId()==2 || user.getDesignationId()==8)){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0 && user.getPost()>0 ){
						
					   sql=SECTION_TANK_MAPP+" and ts.postid="+user.getPost() +"  order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}
					
					if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null  && user.getSectionId()==0 && user.getDesignationId()==4  ){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0  ){
						
					   sql=SECTION_TANK_MAPP+"  and ts.division_id="+user.getDivisionId()+ " and ts.subdivision_id="+user.getSubdivisionId() +" order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}
					
					if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null  && user.getSubdivisionId()==0 &&  user.getSectionId()==0  ){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 ){
						
					   sql=SECTION_TANK_MAPP+" and ts.division_id="+user.getDivisionId() + "  order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}
					
					if(user.getUnitId()!=null && user.getCircleId()!=null && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0)   ){
						if(user.getUnitId()>0 && user.getCircleId()>0    ){
						
					   sql=SECTION_TANK_MAPP+" and ts.circle_id="+user.getCircleId() +"  order by district_name,mandal_name,vname,tank_name";
						}				
						
					}
					
				/*	if(user.getUnitId()!=null && (user.getCircleId()==0) && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0) ){
						if(user.getUnitId()>0    ){
						
					   sql=SECTION_TANK_MAPP+" and ts.unit_id="+user.getUnitId()+ "  order by district_name,mandal_name,vname,tank_name";
						}				
						
					}*/
					
				}
				
				
				;
		//System.out.println("tankslistsql"+sql);
	
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
			List<Tanks> tankList = jdbcTemplate8.query(sql ,new Object[]{},
					new RowMapper<Tanks>() {
				
			
						public Tanks mapRow(ResultSet rs, int rowNum)
								throws SQLException {
	
							
							
					//	System.out.println("impl"+rs.getString(1));
							Tanks tanks = new Tanks();
							
							tanks.setTankId(rs.getLong(1));
							tanks.setNewDistrictId(rs.getInt(2));
							tanks.setMandalId(rs.getInt(3));
							tanks.setVillageId(rs.getInt(4));
							tanks.setHabitationId(rs.getInt(5));
							tanks.setAcCode(rs.getInt(6));
							tanks.setTankCode(rs.getLong(7));
							tanks.setUnitId(rs.getInt(8));
							tanks.setCircleId(rs.getInt(9));
							tanks.setDivisionId(rs.getInt(10));
							tanks.setSubdivisionId(rs.getInt(11));
							tanks.setSectionId(rs.getInt(12));
							tanks.setTankName(rs.getString(13));
							tanks.setDistrictName(rs.getString(14));
							tanks.setMandalName(rs.getString(15));
							tanks.setVillageName(rs.getString(16));
							tanks.setHabitationName(rs.getString(17));
							tanks.setConstName(rs.getString(18));
							tanks.setSourceId(rs.getInt(19));
							tanks.setIsNrld(rs.getBoolean(20));
							tanks.setNrldCode(rs.getString(21));
							
							
							
							
							
							return tanks;
						}

					});
			
			// System.out.println("sql"+sql);
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("impl2"+ReservoirSalientList);
			return tankList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	

	
	@Override
	public List<EmployeeDiversion> sourceHrmsEmpDiversion() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SOURCE_HRMS_EMP_DIVERSION;
		
		try {
			
			List<EmployeeDiversion>   empdivList = hrmsjdbcTemplate.query(sql ,
					new RowMapper<EmployeeDiversion>() {

						public EmployeeDiversion mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							EmployeeDiversion    empdiv = new EmployeeDiversion();
							
							empdiv.setEmpId(rs.getString(1));
							empdiv.setActualPostId(rs.getLong(2));
							empdiv.setUnitId(rs.getInt(3));
							empdiv.setCircleId(rs.getInt(4));
							empdiv.setDivisionId(rs.getInt(5));
							empdiv.setSubdivisionId(rs.getInt(6));
							empdiv.setSectionId(rs.getInt(7));
							empdiv.setOdFromDate(rs.getString(8));
							empdiv.setOdToDate(rs.getString(9));
							empdiv.setPostId(rs.getLong(10));
							empdiv.setDesignationId(rs.getInt(11));
							empdiv.setEmpDivId(rs.getInt(12));
							empdiv.setIsLatest(rs.getString(13));
							empdiv.setIsDelete(rs.getString(14));
							empdiv.setOtherOfficeDetails(rs.getString(15));
							empdiv.setOdType(rs.getString(16));
							empdiv.setCancelledRefDate(rs.getString(17));
							empdiv.setCancelledOn(rs.getString(18));
							empdiv.setCancelledSubmittedDate(rs.getString(19));
							
						
							return empdiv;
						}

					});
			hrmsjdbcTemplate.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return empdivList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				hrmsjdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//System.out.println("rs"+rs);
		return null;

	}
	
	@Override
	public Integer DeleteStageEmpDiversion(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_EMP_DIVERSION;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);

				 rows = jdbcTemplate11.update(sql);
			

					jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	

	@Override
	public Integer stageinsertEmpDiversion(final List<EmployeeDiversion> empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_STAGE_EMP_DIVERSION;

		Integer rows1 = 0;
		int[] j = null;
		
		
		try {

			jdbcTemplate11.getDataSource().getConnection().setAutoCommit(false);
			 if(empObj!=null){
             	
				if (empObj.size() > 0) {
					if(empObj.get(0).getEmpId()!=null && empObj.get(0).getPostId()!=null  ){
					j = jdbcTemplate11.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
							
									EmployeeDiversion sd = empObj.get(i);
									
									 
								//	System.out.println(" miObj.get(0).getMiTankFreqId()"+  miObj.get(0).getMiTankFreqId());
									

									 java.sql.Date date1 = null;
									 java.sql.Date date2 = null;
									 java.sql.Date date3 = null;
									 java.sql.Date date4 = null;
									 java.sql.Date date5 = null;
									 
									 try {
											
											if (sd.getOdFromDate()!= null) {
											
											date1 = DateUtil.getSQLDate( sd.getOdFromDate());
											}
											
											if (sd.getOdToDate()!= null) {
												
												date2 = DateUtil.getSQLDate( sd.getOdToDate());
												}
                                            if (sd.getCancelledRefDate()!= null) {
												
												date3 = DateUtil.getSQLDate( sd.getCancelledRefDate());
												}
 if (sd.getCancelledOn()!= null) {
												
												date4 = DateUtil.getSQLDate( sd.getCancelledOn());
												}
 if (sd.getCancelledSubmittedDate()!= null) {
		
		date5 = DateUtil.getSQLDate( sd.getCancelledSubmittedDate());
		}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									
									// System.out.println("sd"+sd.getAcode());
									 ps.setString(1,  sd.getEmpId());
									 ps.setLong(2,  sd.getActualPostId());
									 ps.setInt(3,  sd.getUnitId());
									 ps.setInt(4,  sd.getCircleId());
									 ps.setInt(5,  sd.getDivisionId());
									 ps.setInt(6,  sd.getSubdivisionId());
									 ps.setInt(7,  sd.getSectionId());
									 ps.setDate(8,  date1);
									 ps.setDate(9,  date2);
									 ps.setLong(10,  sd.getPostId());
									 ps.setInt(11,  sd.getDesignationId());
									 ps.setInt(12,  sd.getEmpDivId());
									 ps.setString(13,  sd.getIsLatest());
									 ps.setString(14,  sd.getIsDelete());
									 ps.setString(15,  sd.getOtherOfficeDetails());
									 ps.setString(16,  sd.getOdType());
									 ps.setDate(17,  date3);
									 ps.setDate(18,  date4);
									 ps.setDate(19,  date5);
									 
									
									
								
								}

								@Override
								public int getBatchSize() {
									return empObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate11.getDataSource().getConnection().setAutoCommit(true);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	//start for form 20 methods 10-11-2021
	
	@Override
	public MstOutputWithFlag insertForm20Data(final List<MiTankformData> miFormObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_FORM20_DATA;
		
	String sql2=GET_FRM_FREQ_TANK;
	
	String sql5=GET_FRM_FREQ_RES;
	
	String sql6=GET_FRM_FREQ_CAN;
		
String sql4=GET_FRM_DATA_ID_TANK;

String sql7=GET_FRM_DATA_ID_RES;

String sql8=GET_FRM_DATA_ID_CAN;

		

		
		Integer updatedfreq=0;
		Integer rows1=0;
		Integer olddictId=0;
		
		MstOutputWithFlag mstoutput = new MstOutputWithFlag();
		
	Integer mst1output=0;
		
		// System.out.println("miFormObj.get(0).getCatId()"+miFormObj.get(0).getCatId());
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miFormObj!=null){
				 
				 java.sql.Date tsfdate = null;
				 java.sql.Date damagedate = null;
				 java.sql.Date raindate = null;
					try {
						
						if ( miFormObj.get(0).getTsfcFormDate()!= null
								&&  miFormObj.get(0).getTsfcFormDate()!= ""
								&& ! miFormObj.get(0).getTsfcFormDate().equals('0')) {
						
							tsfdate = DateUtil.getSQLDate( miFormObj.get(0).getTsfcFormDate());
						
						
						}
						
						if ( miFormObj.get(0).getDamageDate()!= null
								&&  miFormObj.get(0).getDamageDate()!= ""
								&& ! miFormObj.get(0).getDamageDate().equals('0')) {
						
							damagedate = DateUtil.getSQLDate( miFormObj.get(0).getDamageDate());
						
						
						}
						
						if (miFormObj.get(0).getRainDate()!= null
								&&  miFormObj.get(0).getRainDate()!= ""
								&& ! miFormObj.get(0).getRainDate().equals('0')) {
						
							raindate = DateUtil.getSQLDate( miFormObj.get(0).getRainDate());
						
						
						}
						
						
						
					
						
						
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
             	
				
				if((miFormObj.get(0).getTankId()!=null ||  miFormObj.get(0).getResId()!=null || miFormObj.get(0).getCanId()!=null ) && tsfdate!=null &&  miFormObj.get(0).getCatId()!=null  ){
				
					
					if(miFormObj.get(0).getCatId()>0 && miFormObj.get(0).getCatId()==1 ){
					 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2, new Object[]{tsfdate,miFormObj.get(0).getTankId()});
					 
					 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("miformfreq").toString());
							}
					 }
				
				 }
					
					if(miFormObj.get(0).getCatId()>0 && miFormObj.get(0).getCatId()==2 ){
						 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql5, new Object[]{tsfdate,miFormObj.get(0).getResId()});
						 
						 if(result!=null){
							 
							 for (Map<String, Object> row : result) {
								 updatedfreq = Integer.parseInt(row.get("miformfreq").toString());
								}
						 }
					
					 }
					
					if(miFormObj.get(0).getCatId()>0 && miFormObj.get(0).getCatId()==3 ){
						 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql6, new Object[]{tsfdate,miFormObj.get(0).getCanalLocId(),miFormObj.get(0).getCanId()});
						 
						 if(result!=null){
							 
							 for (Map<String, Object> row : result) {
								 updatedfreq = Integer.parseInt(row.get("miformfreq").toString());
								}
						 }
					
					 }
				}
				 
				// System.out.println("updatedfreq"+updatedfreq);
				 
				 if(updatedfreq>0){
					 
					 if(miFormObj.get(0).getCatId()>0 && miFormObj.get(0).getCatId()==1 ){
					 
					 List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{tsfdate,miFormObj.get(0).getTankId()});
             
					 if(result1!=null){
						 
						 for (Map<String, Object> row : result1) {
							 mstoutput.setOldformdataId(Integer.parseInt(row.get("form_data_id").toString())); ;
							}
					 }
					 
					 }
					 
					 if(miFormObj.get(0).getCatId()>0 && miFormObj.get(0).getCatId()==2 ){
						 
						 List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql7, new Object[]{tsfdate,miFormObj.get(0).getResId()});
	             
						 if(result1!=null){
							 
							 for (Map<String, Object> row : result1) {
								 mstoutput.setOldformdataId(Integer.parseInt(row.get("form_data_id").toString())); ;
								}
						 }
						 
						 }
					 
					 if(miFormObj.get(0).getCatId()>0 && miFormObj.get(0).getCatId()==3 ){
						 
						 List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql8, new Object[]{tsfdate,miFormObj.get(0).getCanalLocId(),miFormObj.get(0).getCanId()});
	             
						 if(result1!=null){
							 
							 for (Map<String, Object> row : result1) {
								 mstoutput.setOldformdataId(Integer.parseInt(row.get("form_data_id").toString())); ;
								}
						 }
						 
						 }
				 }
				 
				 
				 
				 
				 if((updatedfreq<1 && (miFormObj.get(0).getCatId()==1 || miFormObj.get(0).getCatId()==2) ) || (updatedfreq<=1 && (miFormObj.get(0).getCatId()==3 ) ) ){
				if (miFormObj.size() > 0) {
					if(miFormObj.get(0).getTankId()!=null || miFormObj.get(0).getResId()!=null || miFormObj.get(0).getCanId()!=null  ){
						
						// System.out.println("coming here"+updatedfreq);
						 List<Map<String, Object>> result2 = jdbcTemplate8.queryForList(sql3,
								 tsfdate,
								 miFormObj.get(0).getDamageCause(),	
								 miFormObj.get(0).getFrmBookValue(),							
								 miFormObj.get(0).getUserName(),
								 miFormObj.get(0).getTankId(),
								 damagedate,								
								 miFormObj.get(0).getDamageTime(),							
								 miFormObj.get(0).getWriteOffValue(),
								 miFormObj.get(0).getWriteOffAction(),
								 miFormObj.get(0).getDamageBreaches(),
								 miFormObj.get(0).getEffAyacutAcres(),
								 miFormObj.get(0).getEffAyacutValue(),
								 miFormObj.get(0).getApproxRepPermanent(),
								 miFormObj.get(0).getApproxRepTemp(),
								 miFormObj.get(0).getActionStdCrops(),
								 miFormObj.get(0).getUsefulRemarks(),								 
								 miFormObj.get(0).getUnitId(),
								 miFormObj.get(0).getCircleId(),
								 miFormObj.get(0).getDivisionId(),
								 miFormObj.get(0).getSubDivisionId(),
								 miFormObj.get(0).getDesignationId(),
								 miFormObj.get(0).getPostId(),
								 miFormObj.get(0).getNextPostId(),								 
								 miFormObj.get(0).getEmpId(),
								 miFormObj.get(0).getNextEmpId(),
								 miFormObj.get(0).getFrmProposed(),
								 miFormObj.get(0).getRegLeftChnnAcres(),
								 miFormObj.get(0).getRegRightChnnAcres(),
								 miFormObj.get(0).getRainRGStation(),
								 miFormObj.get(0).getRainQty(),
								 raindate,
								 miFormObj.get(0).getQuartName(),
								 miFormObj.get(0).getQuartType(),
								 miFormObj.get(0).getBldgTypeName(),
								 miFormObj.get(0).getBldgDescDamage(),
								 miFormObj.get(0).getSectionId(),
								 miFormObj.get(0).getRegOthAcres(),
								 miFormObj.get(0).getDamageType(),
								 miFormObj.get(0).getResId(),
								 miFormObj.get(0).getCanId(),
								 miFormObj.get(0).getCatId(),
								 miFormObj.get(0).getProjectId(),
								 miFormObj.get(0).getCanalLocId()
								// miFormObj.get(0).getIrrStrDmaPort()
								 
								
								 );	
						 
						 
						 if(result2!=null){
							 
							 for (Map<String, Object> row : result2) {
								 mstoutput.setFormdataId(Integer.parseInt(row.get("form_data_id").toString()));
								}
							 
							// System.out.println("mst1outputdao"+mst1output);
						 }
					}	
					
				}
			
	            }
			 }
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mstoutput;
	}
	
	
	@Override
	public Integer  insertForm20approv(final List<MiTankformData> miFormObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_FROM_APPRV;
		
	String sql2=UPDATE_OLD_APPRV;
		


		
		
		
		Integer updatedfreq=0;
		Integer rows1=0;
		Integer olddictId=0;
		
		
		
	Integer mst1output=0;
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miFormObj!=null){
				 
			
				 if (miFormObj.size() > 0) {
				 updatedfreq= jdbcTemplate8.update(sql2, new Object[]{ miFormObj.get(0).getFormDataId()});
				 
			//	 System.out.println("updatedfreq"+updatedfreq);
		             
							
						// System.out.println("coming here"+updatedfreq);
						mst1output = jdbcTemplate8.update(sql3,
								
								 miFormObj.get(0).getFormDataId(),
								 miFormObj.get(0).getApprv_status(),
								 miFormObj.get(0).getEmpId(),
								 miFormObj.get(0).getNextEmpId(),
								 miFormObj.get(0).getPostId(),
								 miFormObj.get(0).getNextPostId(),				
								 miFormObj.get(0).getUserName()
								
								
								 );	
						 
						 
						
					}	
					
				}
			
	            
			 
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mst1output;
	}
	
	@Override
	public Integer insertForm20Detail(final List<MiTankformData> miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_FORM20_DETAIL;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		final Integer olddictId=0;
		final Integer waterlevelinspect=0;
		final Integer capacity=0;
		final Integer mitankinspectapprovId=0;
	
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miformObj!=null){
             	
				
				 
				//System.out.println("dao"+miformObj.get(0).getFormDataId());
				if (miformObj.size() > 0) {
					if(miformObj.get(0).getFormDataId()!=null  ){
					j = jdbcTemplate8.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
									
											
										

									MiTankformData sd = miformObj.get(i);
									
									
									
									ps.setInt(1,   miformObj.get(0).getFormDataId());
									
									
									
									ps.setLong(2,  sd.getIrrSrcId());
										ps.setDouble(3,  sd.getIrrChFrm());
										ps.setDouble(4,  sd.getIrrChTo());
										ps.setDouble(5, sd.getIrrL());
										ps.setString(6,  miformObj.get(0).getUserName());
										ps.setDouble(7, sd.getIrrB());
										ps.setDouble(8, sd.getIrrD());
										ps.setDouble(9, sd.getIrrPermcost());
										ps.setDouble(10, sd.getIrrTempcost());
									
									
									
									
									
								}

								@Override
								public int getBatchSize() {
									return miformObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer getCountOfDamInpsectDocs() throws InventoryUserException{
		// TODO Auto-generated method stub
		
		String sql = COUNT_DAM_DOCS;

		Integer rows1 = 0;
		
		
		Integer filerows=0;
		
		 java.sql.Date date1 = null;
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			List<Map<String, Object>> 	ct=	jdbcTemplate8.queryForList(sql );
			
			
			for (Map<String, Object> row : ct) {
				rows1 = Integer.parseInt(row.get("doccount").toString());
			}
			
             // System.out.println("rows1"+rows1) ;
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return rows1;
	}
	
	
	
	@Override
	public Integer getCountOfform20Docs() throws InventoryUserException{
		// TODO Auto-generated method stub
		
		String sql = COUNT_FRM_DOCS;

		Integer rows1 = 0;
		
		
		Integer filerows=0;
		
		 java.sql.Date date1 = null;
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			List<Map<String, Object>> 	ct=	jdbcTemplate8.queryForList(sql );
			
			
			for (Map<String, Object> row : ct) {
				rows1 = Integer.parseInt(row.get("doccount").toString());
			}
			
             // System.out.println("rows1"+rows1) ;
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return rows1;
	}
	
	@Override
	public Integer insertFormDocuments(final MiTankformData midocObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql2 = INSERT_FRM_DOCUMENTS;
				
		

		Integer rows1 = 0;
		int[] j = null;
		Integer filerows=0;
		
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			
			if(midocObj.getPhotosList()!=null){
			 if(midocObj.getPhotosList()!=null){
             //	System.out.println("coming here");
      			//System.out.println(midocObj.getPhotosList().get(0).getFormDocName());
				
					if( midocObj.getFormDataId()!=null && midocObj.getPhotosList().get(0).getFormDocName()!=null || midocObj.getPhotosList().get(0).getFormDocName()!=" " ){
					j = jdbcTemplate8.batchUpdate(sql2,		new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {

									MiTankFormDocs sd = midocObj.getPhotosList().get(i);
								
									  ps.setInt(1,  midocObj.getFormDataId());
										ps.setString(2, sd.getFormDocOriginalName());
										ps.setString(3, sd.getFormDocName());
									ps.setString(4, sd.getFormDocLocation());
									
									 ps.setString(5,  midocObj.getMiTankformDataList().get(0).getUserName());
									
								}

								@Override
								public int getBatchSize() {
									return midocObj.getPhotosList().size();
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
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	
	@Override
	public List<MiTankformData> getFrmIrrSrcList() throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=FRM_IRR_SRC_LIST;
		
		try {
			
			List<MiTankformData>   frmsrclist = jdbcTemplate8.query(sql ,
					new RowMapper<MiTankformData>() {

						public MiTankformData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankformData    frmsrc = new MiTankformData();
							
							frmsrc.setIrrSrcId(rs.getInt(1));
							frmsrc.setIrrSrcName(rs.getString(2));
							frmsrc.setSrcNo(rs.getInt(3));
							
							
						
							return frmsrc;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return frmsrclist;
			
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
	public List<MiTankformData> getFrmSentList(MiTankformData miobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=GET_FRM_SENT_LIST;
		
		
		
		try {
			if(miobj.getTankId()!=null && miobj.getResId()!=null && miobj.getCanId()!=null){
			
			
			List<MiTankformData>   frmsrclist = jdbcTemplate8.query(sql ,new Object[] { miobj.getTankId(), miobj.getResId(),miobj.getCanId()},
					new RowMapper<MiTankformData>() {

						public MiTankformData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankformData    frmsrc = new MiTankformData();
							
							frmsrc.setFormDataId(rs.getInt(1));
							frmsrc.setTsfcFormDate(rs.getString(2));
							frmsrc.setTankId(rs.getInt(3));
							frmsrc.setCreateDate(rs.getString(4));
							frmsrc.setResId(rs.getInt(5));
							frmsrc.setProjectId(rs.getInt(6));
							frmsrc.setCanId(rs.getInt(7));
							frmsrc.setCatId(rs.getInt(8));
							
							
							
						
							return frmsrc;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return frmsrclist;
			}	
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
	public List<MiTankformData> getFrmDataList(Integer formDataId) throws InventoryUserException {
		// TODO Auto-generated method stub
		
	//	System.out.println("daoimpl"+formDataId);
		
		String sql=SELECT_FORM_DATA;
		
		try {
			
			List<MiTankformData>   frmdatalist = jdbcTemplate8.query(sql ,new Object[] { formDataId},
					new RowMapper<MiTankformData>() {

						public MiTankformData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankformData    frmdata = new MiTankformData();
							
						//	System.out.println("rs.getInt(1)"+rs.getInt(1));
							
							frmdata.setFormDataId(rs.getInt(1));
							frmdata.setTsfcFormDate(rs.getString(2));
							frmdata.setDamageCause(rs.getString(3));
							frmdata.setFrmBookValue(rs.getDouble(4));
							frmdata.setTankId(rs.getInt(5));
							frmdata.setDamageDate(rs.getString(6));
							frmdata.setWriteOffValue(rs.getDouble(7));
							frmdata.setWriteOffAction(rs.getString(8));
							frmdata.setDamageBreaches(rs.getString(9));
							frmdata.setEffAyacutAcres(rs.getDouble(10));
							frmdata.setEffAyacutValue(rs.getDouble(11));
							frmdata.setApproxRepPermanent(rs.getDouble(12));
							frmdata.setApproxRepTemp(rs.getDouble(13));
							frmdata.setActionStdCrops(rs.getString(14));
							frmdata.setUsefulRemarks(rs.getString(15));
							frmdata.setUnitId(rs.getInt(16));
							frmdata.setCircleId(rs.getInt(17));
							frmdata.setDivisionId(rs.getInt(18));
							frmdata.setSubDivisionId(rs.getInt(19));
							frmdata.setDesignationId(rs.getInt(20));
							frmdata.setPostId(rs.getLong(21));
							frmdata.setNextPostId(rs.getLong(22));
							frmdata.setEmpId(rs.getLong(23));
							frmdata.setNextEmpId(rs.getLong(24));
							frmdata.setFrmProposed(rs.getString(25));
							frmdata.setRegLeftChnnAcres(rs.getDouble(26));
							frmdata.setRegRightChnnAcres(rs.getDouble(27));
							frmdata.setRainRGStation(rs.getString(28));
							frmdata.setRainQty(rs.getDouble(29));
							frmdata.setRainDate(rs.getString(30));
							frmdata.setQuartName(rs.getString(31));
							frmdata.setQuartType(rs.getString(32));
							frmdata.setBldgTypeName(rs.getString(33));
							frmdata.setBldgDescDamage(rs.getString(34));
							frmdata.setDamageTime(rs.getString(35));
							frmdata.setSectionId(rs.getInt(36));
							frmdata.setRegOthAcres(rs.getDouble(37));
							frmdata.setDamageType(rs.getInt(38));
							
							frmdata.setResId(rs.getInt(39));
							frmdata.setCanId(rs.getInt(40));
							frmdata.setCatId(rs.getInt(41));
							frmdata.setProjectId(rs.getInt(42));
							
							
							if(rs.getInt(38)==1){
								
								frmdata.setDamageTypeName("Breach");
								
							}
							
                            if(rs.getInt(38)==2){
								
								frmdata.setDamageTypeName("Damage");
								
							}
							
							
						//	System.out.println("frmdata"+frmdata);
						
							return frmdata;
							
							
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
			
			return frmdatalist;
			
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
	public List<MiTankformData> getFrmDetailList(Integer formDataId) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SELECT_FORM_DETAIL;
		
		try {
			
			List<MiTankformData>   frmdatalist = jdbcTemplate8.query(sql ,new Object[] { formDataId},
					new RowMapper<MiTankformData>() {

						public MiTankformData mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankformData    frmdata = new MiTankformData();
							
							frmdata.setFormDetailId(rs.getInt(1));
							frmdata.setFormDataId(rs.getInt(2));
							frmdata.setIrrSrcId(rs.getInt(3));
							frmdata.setIrrChFrm(rs.getDouble(4));
							frmdata.setIrrChTo(rs.getDouble(5));
							frmdata.setIrrL(rs.getDouble(6));
							frmdata.setIrrB(rs.getDouble(7));
							frmdata.setIrrD(rs.getDouble(8));
							frmdata.setIrrPermcost(rs.getDouble(9));
							frmdata.setIrrTempcost(rs.getDouble(10));
							frmdata.setIrrSrcName(rs.getString(11));
							
						
							return frmdata;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return frmdatalist;
			
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
	public List<MiTankFormDocs> getFrmDocsList(Integer formDataId) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SELECT_FORM_DOCS;	
		
		try {
			
			List<MiTankFormDocs>   frmdocslist = jdbcTemplate8.query(sql ,new Object[] { formDataId},
					new RowMapper<MiTankFormDocs>() {

						public MiTankFormDocs mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							MiTankFormDocs    docsdata = new MiTankFormDocs();
							
							docsdata.setFormdocId(rs.getInt(1));
							docsdata.setFormDataId(rs.getInt(2));
							docsdata.setFormDocOriginalName(rs.getString(3));
							docsdata.setFormDocName(rs.getString(4));
						
							docsdata.setFormDocLocation(rs.getString(5));
							
							return docsdata;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return frmdocslist;
			
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
	public Integer  updateForm20Data(final List<MiTankformData> miFormObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = EDIT_MIFORM_DATA;
		

		
		
		
		Integer updatedfreq=0;
		Integer rows1=0;
		Integer olddictId=0;
		
	
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miFormObj!=null){
				 
				 java.sql.Date tsfdate = null;
				 java.sql.Date damagedate = null;
				 java.sql.Date raindate = null;
					try {
						
						if ( miFormObj.get(0).getTsfcFormDate()!= null
								&&  miFormObj.get(0).getTsfcFormDate()!= ""
								&& ! miFormObj.get(0).getTsfcFormDate().equals('0')) {
						
							tsfdate = DateUtil.getSQLDate( miFormObj.get(0).getTsfcFormDate());
						
						
						}
						
						if ( miFormObj.get(0).getDamageDate()!= null
								&&  miFormObj.get(0).getDamageDate()!= ""
								&& ! miFormObj.get(0).getDamageDate().equals('0')) {
						
							damagedate = DateUtil.getSQLDate( miFormObj.get(0).getDamageDate());
						
						
						}
						
						if (miFormObj.get(0).getRainDate()!= null
								&&  miFormObj.get(0).getRainDate()!= ""
								&& ! miFormObj.get(0).getRainDate().equals('0')) {
						
							raindate = DateUtil.getSQLDate( miFormObj.get(0).getRainDate());
						
						
						}
						
						
						
					
						
						
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
             	
				
			
				 
				// System.out.println(" miFormObj.get(0).getDamageType()"+ miFormObj.get(0).getDamageType());
				 
				
				 
				 
				 
			
				if (miFormObj.size() > 0) {
					if(miFormObj.get(0).getTankId()!=null  && miFormObj.get(0).getResId()!=null && miFormObj.get(0).getCatId()!=null ){
						
						// System.out.println("coming here"+updatedfreq);
						rows1 = jdbcTemplate8.update(sql3,
								 tsfdate,
								 miFormObj.get(0).getDamageCause(),	
								 miFormObj.get(0).getFrmBookValue(),							
								 miFormObj.get(0).getUserName(),
							
								 damagedate,								
												
								 miFormObj.get(0).getWriteOffValue(),
								 miFormObj.get(0).getWriteOffAction(),
								 miFormObj.get(0).getDamageBreaches(),
								 miFormObj.get(0).getEffAyacutAcres(),
								 miFormObj.get(0).getEffAyacutValue(),
								 miFormObj.get(0).getApproxRepPermanent(),
								 miFormObj.get(0).getApproxRepTemp(),
								 miFormObj.get(0).getActionStdCrops(),
								 miFormObj.get(0).getUsefulRemarks(),								 
								
								 
								 miFormObj.get(0).getFrmProposed(),
								 miFormObj.get(0).getRegLeftChnnAcres(),
								 miFormObj.get(0).getRegRightChnnAcres(),
								 miFormObj.get(0).getRainRGStation(),
								 miFormObj.get(0).getRainQty(),
								 raindate,
								 miFormObj.get(0).getQuartName(),
								 miFormObj.get(0).getQuartType(),
								 miFormObj.get(0).getBldgTypeName(),
								 miFormObj.get(0).getBldgDescDamage(),
								 miFormObj.get(0).getDamageTime(),			
								
								 miFormObj.get(0).getRegOthAcres(),
								 
								 miFormObj.get(0).getDamageType(),
								 
								
								// miFormObj.get(0).getIrrStrDmaPort(),
								 miFormObj.get(0).getFormDataId()
								 
								
								 );	
						 
						 
						 
					}	
					
				}
			
	            }
			 
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateForm20Detail(final List<MiTankformData> miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = EDIT_MIFORM_DETAIL;

		Integer rows1 = 0;
		int[] j = null;
		
		Integer filerows=0;
		
		final Integer olddictId=0;
		final Integer waterlevelinspect=0;
		final Integer capacity=0;
		final Integer mitankinspectapprovId=0;
	
		
		 
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miformObj!=null){
             	
				
				 
				//System.out.println("dao"+miformObj.get(0).getFormDataId());
				//System.out.println("daoimpl"+miformObj.get(0).getFormDetailId());
				if (miformObj.size() > 0) {
					if(miformObj.get(0).getFormDataId()!=null   &&  miformObj.get(0).getFormDetailId()!=null){
					j = jdbcTemplate8.batchUpdate(sql3,new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {
									
									
											
										

									MiTankformData sd = miformObj.get(i);
									
									
									
								//System.out.println("sd.getFormDetailId()"+sd.getFormDetailId());
									
									
									
									
										ps.setDouble(1,  sd.getIrrChFrm());
										ps.setDouble(2,  sd.getIrrChTo());
										ps.setDouble(3, sd.getIrrL());
										ps.setString(4,  miformObj.get(0).getUserName());
										ps.setDouble(5, sd.getIrrB());
										ps.setDouble(6, sd.getIrrD());
										ps.setDouble(7, sd.getIrrPermcost());
										ps.setDouble(8, sd.getIrrTempcost());										
										ps.setInt(9,   sd.getFormDetailId());										
										ps.setInt(10,   miformObj.get(0).getFormDataId());
									
								
								}

								@Override
								public int getBatchSize() {
									return miformObj.size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					rows1=j.length;
					
					//System.out.println("rows"+rows);
					return rows1;
				}
		        }
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public Integer deleteFormData(final MiTankformData miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_FRM_DATA;		 
	
Integer rows1=0;

		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miformObj!=null){
             	
				
					 if( miformObj.getFormDataId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miformObj.getUserName(),miformObj.getFormDataId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer deleteFormDetail(final MiTankformData miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_FRM_DETAIL_DATAID;		 
		
	
Integer rows1=0;

	
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miformObj!=null){
             	
				
					 if( miformObj.getFormDataId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miformObj.getUserName(),miformObj.getFormDataId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer deleteFormdocs(final MiTankformData miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_FRM_DOCS_DATAID;		 
		
Integer rows1=0;

		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miformObj!=null){
             	
				
					 if( miformObj.getFormDataId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miformObj.getUserName(),miformObj.getFormDataId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer deleteFormdocsbydocId(final MiTankFormDocs miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_FRM_DOCS_DOCID;	
		
		//System.out.println(DELETE_FRM_DOCS_DOCID);
		
Integer rows1=0;

		try {
			
			//System.out.println("miformObj.getFormdocId()"+miformObj.getFormdocId()+"---"+miformObj.getUserName());

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(miformObj!=null){
             	
				 //System.out.println("coming here"+miformObj.getFormdocId()+"---"+miformObj.getUserName());
					 if( miformObj.getFormdocId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,miformObj.getUserName(),miformObj.getFormdocId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer deleteFormdetailsbydetailId(final List<MiTankformData> miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_FRM_DETAIL_BYID;	
		
		//System.out.println(DELETE_FRM_DOCS_DOCID);
		Integer rows1 = 0;
		int[] j = null;
		Integer filerows=0;
		
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			
			if(miformObj.get(0).getFormDataId()!=null){
			 if( miformObj.size()>0){
             //	System.out.println("coming here");
      			//System.out.println(midocObj.getPhotosList().get(0).getFormDocName());
				
					if( miformObj.get(0).getFormDataId()!=null && miformObj.get(0).getFormDetailId()!=null ){
					j = jdbcTemplate8.batchUpdate(sql3,		new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {

									MiTankformData sd = miformObj.get(i);
								
									  ps.setString(1,  miformObj.get(0).getUserName());
										ps.setInt(2, sd.getFormDetailId());
									
								}

								@Override
								public int getBatchSize() {
									return miformObj.size();
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
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	// end of form 20 methods 
	
	
	//feed methods
	
	@Override
	public List<TankFeedDetails> getTankFedUnitMap(User user) throws InventoryUserException {
		
		//System.out.println(user.getCircleId()+"--"+user.getDivisionId()+"imp "+user.getSubdivisionId()+"--"+user.getSectionId());
		// TODO Auto-generated method stub
		String sql =null;
				
				if(user!=null){
					
				/*	if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null && user.getPost()!=null && (user.getDesignationId()==2 || user.getDesignationId()==8)){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0 && user.getPost()>0 ){
						
					   sql=SECTION_TANK_MAPP+" and ts.postid="+user.getPost() +"  order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
					/*if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null  && user.getSectionId()==0 && user.getDesignationId()==4  ){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0  ){
						
					   sql=SECTION_TANK_MAPP+"  and ts.division_id="+user.getDivisionId()+ " and ts.subdivision_id="+user.getSubdivisionId() +" order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
					/*if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null  && user.getSubdivisionId()==0 &&  user.getSectionId()==0  ){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 ){
						
					   sql=SECTION_TANK_MAPP+" and ts.division_id="+user.getDivisionId() + "  order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
				/*	if(user.getUnitId()!=null && user.getCircleId()!=null && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0)   ){
						if(user.getUnitId()>0 && user.getCircleId()>0    ){
						
					   sql=SECTION_TANK_MAPP+" and ts.circle_id="+user.getCircleId() +"  order by district_name,mandal_name,vname,tank_name";
						}				
						
					}*/
					
/*					if(user.getUnitId()!=null && (user.getCircleId()==0) && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0) ){*/
						if(user.getUnitId()!=null  && (user.getUnitId()==4||user.getUnitId()==9832)  ){
						
					   sql=TANK_FEED_MAP_UNIT;
						}				
						
					}
					
			/*	}*/
				
				
				;
		//System.out.println("sql"+sql);
		//System.out.println("user"+user.getUnitId());
		
	
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
			List<TankFeedDetails> tankList = jdbcTemplate8.query(sql ,new Object[]{},
					new RowMapper<TankFeedDetails>() {
				
			
						public TankFeedDetails mapRow(ResultSet rs, int rowNum)
								throws SQLException {
	
							
							
					//	System.out.println("impl"+rs.getString(1));
							TankFeedDetails tanks = new TankFeedDetails();
							
							tanks.setUnitId(rs.getInt(1));
							tanks.setFeedtankCount(rs.getInt(2));
							tanks.setCannotfeedtankCount(rs.getInt(3));
							tanks.setTankdataCount(rs.getInt(4));
							tanks.setUnitName(rs.getString(5));
							
							
							
							
							
							return tanks;
						}

					});
			
			// System.out.println("sql"+sql);
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("impl2"+ReservoirSalientList);
			return tankList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<TankFeedDetails> getTankFedCircleMap(User user) throws InventoryUserException {
		
		//System.out.println(user.getCircleId()+"--"+user.getDivisionId()+"imp "+user.getSubdivisionId()+"--"+user.getSectionId());
		// TODO Auto-generated method stub
		String sql =null;
				
				if(user!=null){
					
				/*	if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null && user.getPost()!=null && (user.getDesignationId()==2 || user.getDesignationId()==8)){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0 && user.getPost()>0 ){
						
					   sql=SECTION_TANK_MAPP+" and ts.postid="+user.getPost() +"  order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
					/*if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null  && user.getSectionId()==0 && user.getDesignationId()==4  ){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0  ){
						
					   sql=SECTION_TANK_MAPP+"  and ts.division_id="+user.getDivisionId()+ " and ts.subdivision_id="+user.getSubdivisionId() +" order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
					/*if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null  && user.getSubdivisionId()==0 &&  user.getSectionId()==0  ){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 ){
						
					   sql=SECTION_TANK_MAPP+" and ts.division_id="+user.getDivisionId() + "  order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
				/*	if(user.getUnitId()!=null && user.getCircleId()!=null && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0)   ){
						if(user.getUnitId()>0 && user.getCircleId()>0    ){
						
					   sql=SECTION_TANK_MAPP+" and ts.circle_id="+user.getCircleId() +"  order by district_name,mandal_name,vname,tank_name";
						}				
						
					}*/
					
					if(user.getUnitId()!=null && (user.getCircleId()==0) && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0) ){
						if(user.getUnitId()>0  && (user.getUnitId()==4||user.getUnitId()==9832)  ){
						
					   sql=TANK_FEED_MAP_CIRCLE;
						}				
						
					}
					
				}
				
				
				;
	//	System.out.println("sql"+sql);
	
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
			List<TankFeedDetails> tankList = jdbcTemplate8.query(sql ,new Object[]{},
					new RowMapper<TankFeedDetails>() {
				
			
						public TankFeedDetails mapRow(ResultSet rs, int rowNum)
								throws SQLException {
	
							
							
					//	System.out.println("impl"+rs.getString(1));
							TankFeedDetails tanks = new TankFeedDetails();
							
							tanks.setUnitId(rs.getInt(1));
							tanks.setCircleId(rs.getInt(2));
							tanks.setFeedtankCount(rs.getInt(3));
							tanks.setCannotfeedtankCount(rs.getInt(4));
							tanks.setTankdataCount(rs.getInt(5));
							tanks.setCircleName(rs.getString(6));
							
							
							
							
							
							return tanks;
						}

					});
			
			// System.out.println("sql"+sql);
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("impl2"+ReservoirSalientList);
			return tankList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<TankFeedDetails> getTankFedDivisionMap(User user) throws InventoryUserException {
		
		//System.out.println(user.getCircleId()+"--"+user.getDivisionId()+"imp "+user.getSubdivisionId()+"--"+user.getSectionId());
		// TODO Auto-generated method stub
		String sql =null;
				
				if(user!=null){
					
				/*	if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null && user.getPost()!=null && (user.getDesignationId()==2 || user.getDesignationId()==8)){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0 && user.getPost()>0 ){
						
					   sql=SECTION_TANK_MAPP+" and ts.postid="+user.getPost() +"  order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
					/*if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null  && user.getSectionId()==0 && user.getDesignationId()==4  ){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0  ){
						
					   sql=SECTION_TANK_MAPP+"  and ts.division_id="+user.getDivisionId()+ " and ts.subdivision_id="+user.getSubdivisionId() +" order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
					/*if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null  && user.getSubdivisionId()==0 &&  user.getSectionId()==0  ){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 ){
						
					   sql=SECTION_TANK_MAPP+" and ts.division_id="+user.getDivisionId() + "  order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
				/*	if(user.getUnitId()!=null && user.getCircleId()!=null && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0)   ){
						if(user.getUnitId()>0 && user.getCircleId()>0    ){
						
					   sql=SECTION_TANK_MAPP+" and ts.circle_id="+user.getCircleId() +"  order by district_name,mandal_name,vname,tank_name";
						}				
						
					}*/
					
					if(user.getUnitId()!=null && (user.getCircleId()==0) && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0) ){
						if(user.getUnitId()>0  && (user.getUnitId()==4||user.getUnitId()==9832)  ){
						
					   sql=TANK_FEED_MAP_DIVISION;
						}				
						
					}
					
				}
				
				
				;
	//	System.out.println("sql"+sql);
	
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
			List<TankFeedDetails> tankList = jdbcTemplate8.query(sql ,new Object[]{},
					new RowMapper<TankFeedDetails>() {
				
			
						public TankFeedDetails mapRow(ResultSet rs, int rowNum)
								throws SQLException {
	
							
							
					//	System.out.println("impl"+rs.getString(1));
							TankFeedDetails tanks = new TankFeedDetails();
							
							tanks.setUnitId(rs.getInt(1));
							tanks.setCircleId(rs.getInt(2));
							tanks.setDivisionId(rs.getInt(3));
						
							tanks.setFeedtankCount(rs.getInt(4));
							tanks.setCannotfeedtankCount(rs.getInt(5));
							tanks.setTankdataCount(rs.getInt(6));
							tanks.setDivisionName(rs.getString(7));
							
							
							
							
							
							return tanks;
						}

					});
			
			// System.out.println("sql"+sql);
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("impl2"+ReservoirSalientList);
			return tankList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	@Override
	public List<TankFeedDetails> getTankFedSubdivisionMap(User user) throws InventoryUserException {
		
		//System.out.println(user.getCircleId()+"--"+user.getDivisionId()+"imp "+user.getSubdivisionId()+"--"+user.getSectionId());
		// TODO Auto-generated method stub
		String sql =null;
				
				if(user!=null){
					
				/*	if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null && user.getPost()!=null && (user.getDesignationId()==2 || user.getDesignationId()==8)){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0 && user.getPost()>0 ){
						
					   sql=SECTION_TANK_MAPP+" and ts.postid="+user.getPost() +"  order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
					/*if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null  && user.getSectionId()==0 && user.getDesignationId()==4  ){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0  ){
						
					   sql=SECTION_TANK_MAPP+"  and ts.division_id="+user.getDivisionId()+ " and ts.subdivision_id="+user.getSubdivisionId() +" order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
					/*if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null  && user.getSubdivisionId()==0 &&  user.getSectionId()==0  ){
						if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 ){
						
					   sql=SECTION_TANK_MAPP+" and ts.division_id="+user.getDivisionId() + "  order by district_name,mandal_name,vname,tank_name";
						}
						
						
					}*/
					
				/*	if(user.getUnitId()!=null && user.getCircleId()!=null && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0)   ){
						if(user.getUnitId()>0 && user.getCircleId()>0    ){
						
					   sql=SECTION_TANK_MAPP+" and ts.circle_id="+user.getCircleId() +"  order by district_name,mandal_name,vname,tank_name";
						}				
						
					}*/
					
					if(user.getUnitId()!=null && (user.getCircleId()==0) && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0) ){
						if(user.getUnitId()>0  && (user.getUnitId()==4||user.getUnitId()==9832)  ){
						
					   sql=TANK_FEED_MAP_SUBDIVISION;
						}				
						
					}
					
				}
				
				
				;
	//	System.out.println("sql"+sql);
	
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
			List<TankFeedDetails> tankList = jdbcTemplate8.query(sql ,new Object[]{},
					new RowMapper<TankFeedDetails>() {
				
			
						public TankFeedDetails mapRow(ResultSet rs, int rowNum)
								throws SQLException {
	
							
							
					//	System.out.println("impl"+rs.getString(1));
							TankFeedDetails tanks = new TankFeedDetails();
							
							tanks.setUnitId(rs.getInt(1));
							tanks.setCircleId(rs.getInt(2));
							tanks.setDivisionId(rs.getInt(3));
							tanks.setSubdivisionId(rs.getInt(4));
							tanks.setFeedtankCount(rs.getInt(5));
							tanks.setCannotfeedtankCount(rs.getInt(6));
							tanks.setTankdataCount(rs.getInt(7));
							tanks.setSubdivisionName(rs.getString(8));
							
							
							
							
							
							return tanks;
						}

					});
			
			// System.out.println("sql"+sql);
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("impl2"+ReservoirSalientList);
			return tankList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	//form20 canals insert
	
	
	@Override
	public Integer insertform20Canals(final Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = FORM20_CANAL_INSERT;
		
		String sql2= CANAL_COUNT_BY_NAME;

	   

		

		Integer  canal_id = 0;
		
		Integer updatedfreq=0;
		
		//System.out.println("sql2"+sql2);
		//System.out.println("sql"+sql);
		//System.out.println("canalObj.getProjectId()"+canalObj.getProjectId());
		//System.out.println("canalObj.getCanalName()"+canalObj.getCanalName());
		//System.out.println("canalObj.getCanalTypeId()"+canalObj.getCanalTypeId());

		try {
			if (canalObj != null) {

				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
				
				
       if  (   canalObj.getCanalName()!=null &&   canalObj.getCanalTypeId()!=null  && canalObj.getProjectId()!=null ){
				
					
					if(canalObj.getCanalName().length()>0 && canalObj.getCanalTypeId()>0 && canalObj.getProjectId()>0 ){
					 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2, new Object[]{canalObj.getCanalName(),canalObj.getCanalTypeId() , canalObj.getProjectId() });
					 
					 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("mycanalfreq").toString());
							}
					 }
				
				 }
					
					
					
					//System.out.println("updatedfreq"+updatedfreq);
					
					if(updatedfreq>0){
						
						
						canal_id=-4;
						
						
					}
					
					if(updatedfreq<=0){
				

				List<Map<String, Object>> rows = jdbcTemplate8.queryForList(sql,canalObj.getCanalName(),canalObj.getCreatedByUser(),
						canalObj.getCanalTypeId(),canalObj.getReservoirId(),canalObj.getProjectId() );

				for (Map<String, Object> row : rows) {
					canal_id = Integer.parseInt(row.get("canal_id").toString());
				}

					}
			
					
					//System.out.println("canal_id"+canal_id);
			

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return canal_id;
	}
	
	@Override
	public Integer insertform20CanalsLocation(final Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = FORM20_CANAL_INSERT_LOCATION;

	   

		

		Integer  canal_loc_id = 0;
		
		

		try {
			if (canalObj != null) {

				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

				List<Map<String, Object>> rows = jdbcTemplate8.queryForList(sql,canalObj.getCanalId(),canalObj.getCreatedByUser(),canalObj.getDistrictId(),canalObj.getMandalId(),
						canalObj.getVillageId(),canalObj.getRemarksVillage(),canalObj.getChainageFromkm(),canalObj.getChainageTokm() );

				for (Map<String, Object> row : rows) {
					canal_loc_id = Integer.parseInt(row.get("canal_loc_id").toString());
				}

				
			
			

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return canal_loc_id;
	}
	
	
	@Override
	public Integer updateform20Canals(final Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = FORM20_CANAL_UPDATE;

	   

		

		Integer  rows = 0;
		
		

		try {
			if (canalObj != null) {

				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

				rows = jdbcTemplate8.update(sql,canalObj.getCanalName(),canalObj.getCreatedByUser(),
						
						canalObj.getCanalTypeId(), canalObj.getReservoirId(),canalObj.getCanalId());

			
			
			

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer updateform20CanalsLocation(final Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = FORM20_CANAL_UPDATE_LOCATION;

	   

		

		Integer  rows = 0;
		
		//System.out.println("sql"+sql);

		try {
			if (canalObj != null) {

				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

				rows = jdbcTemplate8.update(sql,canalObj.getCanalId(),canalObj.getCreatedByUser(),
						canalObj.getDistrictId(),canalObj.getMandalId(),canalObj.getVillageId(),
						canalObj.getRemarksVillage(),canalObj.getChainageFromkm(), canalObj.getChainageTokm(),canalObj.getCanalLocId());

			
			
			

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer insertform20CanalsunitMap(final Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = FORM20_CANAL_INSERT_UNIT;

	   

		

		Integer  rows = 0;
		
		

		try {
			if (canalObj != null) {

				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

				rows = jdbcTemplate8.update(sql,canalObj.getUnitId(),canalObj.getCircleId(),
						canalObj.getDivisionId(),canalObj.getSubdivisionId(),canalObj.getCanalId(),
						canalObj.getProjectId(),canalObj.getPostId(),canalObj.getSectionId()
						);

			
			
			

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	@Override
	public Integer updateform20ReservoirLocation(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = FORM20_RESLOC_UPDATE;

	   

		

		Integer  rows = 0;
		
		

		try {
			if (resObj != null) {

				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

				rows = jdbcTemplate8.update(sql,resObj.getUserName(),resObj.getDistrictId(),resObj.getMandalId(),resObj.getVillageId(),
						resObj.getRemarksVillage(),resObj.getReservoirId());

			
			
			

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	@Override
	public Integer insertform20ReservoirUnitMap(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = FORM20_RESLOC_INSERT_UNIT;

	   

		

		Integer  rows = 0;
		
		

		try {
			if (resObj != null) {

				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

				rows = jdbcTemplate8.update(sql,resObj.getUnitId(),resObj.getCircleId(),resObj.getDivisionId(),resObj.getSubdivisionId(),
						resObj.getReservoirId(),resObj.getProjectId(),resObj.getPackageId(),resObj.getPostId(),resObj.getSectionId());

			
			
			

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	@Override
	public List<ReservoirSalient> getform20ResLocByResId(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=FORM20_RESLOC_SELECT_BYRESID;
		
		try {
			
			List<ReservoirSalient>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getReservoirId()},
					new RowMapper<ReservoirSalient>() {

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirSalient    resinfo = new ReservoirSalient();
							
							resinfo.setReservoirId(rs.getInt(1));
							resinfo.setResName(rs.getString(2));
							resinfo.setDistrictId(rs.getInt(3));
							resinfo.setMandalId(rs.getInt(4));
							resinfo.setVillageId(rs.getInt(5));
							resinfo.setRemarksVillage(rs.getString(6));
							resinfo.setDistrictName(rs.getString(7));
							resinfo.setMandalName(rs.getString(8));
							resinfo.setVillageName(rs.getString(9));
							resinfo.setProjectId(rs.getInt(10));
							resinfo.setUnitId(rs.getInt(11));
							resinfo.setCircleId(rs.getInt(12));
							resinfo.setDivisionId(rs.getInt(13));
							resinfo.setSubdivisionId(rs.getInt(14));
							resinfo.setSectionId(rs.getInt(15));
							resinfo.setPostId(rs.getLong(16));
							resinfo.setIsNrld(rs.getBoolean(17));
							resinfo.setNrldCode(rs.getString(18));
							
							
						
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
	public List<Canal> getform20CanLocByCanalId(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=FORM20_CANALLOC_SELECT_BYCANID;
		
		try {
			
			List<Canal>   canallist = jdbcTemplate8.query(sql ,new Object[] { canalObj.getCanalId(),canalObj.getCanalLocId()},
					new RowMapper<Canal>() {

						public Canal mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Canal    canalinfo = new Canal();
							
							canalinfo.setCanalId(rs.getInt(1));
							canalinfo.setCanalName(rs.getString(2));
							canalinfo.setDistrictId(rs.getInt(3));
							canalinfo.setMandalId(rs.getInt(4));
							canalinfo.setVillageId(rs.getInt(5));
							canalinfo.setRemarksVillage(rs.getString(6));
							canalinfo.setCanalTypeId(rs.getInt(7));
							canalinfo.setDistrictName(rs.getString(8));
							canalinfo.setMandalName(rs.getString(9));
							canalinfo.setVillageName(rs.getString(10));
							canalinfo.setUnitId(rs.getInt(11));
							canalinfo.setCircleId(rs.getInt(12));
							canalinfo.setDivisionId(rs.getInt(13));
							canalinfo.setSubdivisionId(rs.getInt(14));
							canalinfo.setPostId(rs.getLong(15));
							canalinfo.setProjectId(rs.getInt(16));
							canalinfo.setReservoirId(rs.getInt(17));
							canalinfo.setCanalLocId(rs.getInt(18));
							canalinfo.setChainageFromkm(rs.getDouble(19));
							canalinfo.setChainageTokm(rs.getDouble(20));
							
							canalinfo.setCanalType(rs.getString(21));
							
							
						
							return canalinfo;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return canallist;
			
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
	public List<Canal> getCanalsByProjectId(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SELECT_CANAL_BYUNITID;
		
		try {
			
			List<Canal>   canallist = jdbcTemplate8.query(sql ,new Object[] { canalObj.getProjectId()},
					new RowMapper<Canal>() {

						public Canal mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Canal    canalinfo = new Canal();
							
						
							canalinfo.setCanalName(rs.getString(1));
							canalinfo.setCanalId(rs.getInt(2));
							canalinfo.setUnitId(rs.getInt(3));
							canalinfo.setProjectId(rs.getInt(4));
							canalinfo.setDistrictId(rs.getInt(5));
							canalinfo.setMandalId(rs.getInt(6));
							canalinfo.setVillageId(rs.getInt(7));
							canalinfo.setRemarksVillage(rs.getString(8));
							canalinfo.setDistrictName(rs.getString(9));
							canalinfo.setMandalName(rs.getString(10));
							canalinfo.setVillageName(rs.getString(11));
							canalinfo.setCanalLocId(rs.getInt(12));
							canalinfo.setCircleId(rs.getInt(13));
							canalinfo.setDivisionId(rs.getInt(14));
							canalinfo.setSubdivisionId(rs.getInt(15));
							canalinfo.setPostId(rs.getLong(16));
							
							
							
							
						
							return canalinfo;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return canallist;
			
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
	public List<Canal> getCanalsByProjectedit(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SELECT_CANAL_BYPROJECTIDEDIT;
		
		try {
			
			List<Canal>   canallist = jdbcTemplate8.query(sql ,new Object[] { canalObj.getProjectId()},
					new RowMapper<Canal>() {

						public Canal mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Canal    canalinfo = new Canal();
							
						
							canalinfo.setCanalName(rs.getString(1));
							canalinfo.setCanalId(rs.getInt(2));
							canalinfo.setCanalType(rs.getString(3));
							canalinfo.setCanalTypeId(rs.getInt(4));
							canalinfo.setProjectId(rs.getInt(5));
							canalinfo.setUnitId(rs.getInt(6));
						
							
							canalinfo.setCircleId(rs.getInt(7));
							canalinfo.setDivisionId(rs.getInt(8));
							canalinfo.setSubdivisionId(rs.getInt(9));
							canalinfo.setPostId(rs.getLong(10));
							
							canalinfo.setResName(rs.getString(11));
							
							
							
							
							
							
							
						
							return canalinfo;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return canallist;
			
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
	public List<Canal> getCanalsNotInLoc(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SELECT_CANAL_BYPROJECTIDNOTINLOC;
		
		try {
			
			List<Canal>   canallist = jdbcTemplate8.query(sql ,new Object[] { canalObj.getProjectId()},
					new RowMapper<Canal>() {

						public Canal mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Canal    canalinfo = new Canal();
							
						
							canalinfo.setCanalName(rs.getString(1));
							canalinfo.setCanalId(rs.getInt(2));
							canalinfo.setCanalType(rs.getString(3));
							canalinfo.setCanalTypeId(rs.getInt(4));
							canalinfo.setProjectId(rs.getInt(5));
							canalinfo.setUnitId(rs.getInt(6));
						
							
							canalinfo.setCircleId(rs.getInt(7));
							canalinfo.setDivisionId(rs.getInt(8));
							canalinfo.setSubdivisionId(rs.getInt(9));
							canalinfo.setPostId(rs.getLong(10));
							
							canalinfo.setResName(rs.getString(11));
							
							
							
							
							
							
							
						
							return canalinfo;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return canallist;
			
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
	public List<Canal> getCanalsByCanalIdedit(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=SELECT_CANAL_BYCANALIDEDIT;
		
		try {
			
			List<Canal>   canallist = jdbcTemplate8.query(sql ,new Object[] { canalObj.getCanalId()},
					new RowMapper<Canal>() {

						public Canal mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Canal    canalinfo = new Canal();
							
						
							canalinfo.setCanalName(rs.getString(1));
							canalinfo.setCanalId(rs.getInt(2));
							canalinfo.setCanalType(rs.getString(3));
							canalinfo.setCanalTypeId(rs.getInt(4));
							canalinfo.setProjectId(rs.getInt(5));
							canalinfo.setUnitId(rs.getInt(6));
						
							
							canalinfo.setCircleId(rs.getInt(7));
							canalinfo.setDivisionId(rs.getInt(8));
							canalinfo.setSubdivisionId(rs.getInt(9));
							canalinfo.setPostId(rs.getLong(10));
							
							canalinfo.setResName(rs.getString(11));
							canalinfo.setReservoirId(rs.getInt(12));
							
							
							
							
							
							
							
						
							return canalinfo;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return canallist;
			
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
	public List<Canal> getCanalLocationByCanallocId(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		
		
		String sql=FROM20_GET_CANAL_LOCATION_BYLOCID;
		
		
		//System.out.println("coming here"+sql +canalObj.getCanalLocId());
		
		try {
			
			List<Canal>   canallist = jdbcTemplate8.query(sql ,new Object[] { canalObj.getCanalLocId()},
					new RowMapper<Canal>() {

						public Canal mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Canal    canalinfo = new Canal();
							
							canalinfo.setCanalLocId(rs.getInt(1));
							canalinfo.setCanalId(rs.getInt(2));
							canalinfo.setDistrictId(rs.getInt(3));
							canalinfo.setMandalId(rs.getInt(4));
							canalinfo.setVillageId(rs.getInt(5));
							canalinfo.setRemarksVillage(rs.getString(6));
							
							canalinfo.setDistrictName(rs.getString(7));
							canalinfo.setMandalName(rs.getString(8));
							canalinfo.setVillageName(rs.getString(9));
							
                           canalinfo.setCanalName(rs.getString(10));
                           
                           canalinfo.setChainageFromkm(rs.getDouble(11));
                           canalinfo.setChainageTokm(rs.getDouble(12));
							
							
							
							
							
							
						
							return canalinfo;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			
		//	System.out.println("miinflowoutflow"+miinflowoutflow);
			return canallist;
			
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
	public List<ReservoirSalient> getSourcePmsInvResBasic( ) throws InventoryUserException {
		
		//System.out.println("impl"+rescode);
		// TODO Auto-generated method stub
		String sql = SOURCE_PMS_INV_RES_BASIC_DATA;
		
		
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
           // System.out.println("sql"+sql);
			List<ReservoirSalient> ReservoirSalientList =  irrInvTemplate.query(sql,
					new RowMapper<ReservoirSalient>(){

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							
							

							ReservoirSalient reservoirSalient = new ReservoirSalient();
							
						
							
							reservoirSalient.setReservoirId(rs.getInt(1));
							reservoirSalient.setResName(rs.getString(2));
							reservoirSalient.setResLatitude(rs.getString(3));
							reservoirSalient.setResLongitude(rs.getString(4));
							reservoirSalient.setResStatusId(rs.getInt(5));
							reservoirSalient.setRiverBasinId(rs.getInt(6));
							reservoirSalient.setSubBasin(rs.getString(7));
							reservoirSalient.setYearConstructionFrom(rs.getInt(8));
							reservoirSalient.setYearConstructionTo(rs.getInt(9));
							reservoirSalient.setYearImpounding(rs.getInt(10));
							reservoirSalient.setCatchArea(rs.getString(11));
							
						
							reservoirSalient.setWaterSpreadArea(rs.getDouble(12));
							reservoirSalient.setDeepestfoundationLevel(rs.getDouble(13));
							reservoirSalient.setTypeOfDam(rs.getString(14));
							reservoirSalient.setFrlLevel(rs.getDouble(15));
							reservoirSalient.setGrossStorageatFrl(rs.getDouble(16));
							reservoirSalient.setMwlLevel(rs.getDouble(17));
							reservoirSalient.setMddlLevel(rs.getDouble(18));
							reservoirSalient.setLiveStorageabovemddl(rs.getDouble(19));
							reservoirSalient.setDeadStoragebelowmddl(rs.getDouble(20));
							reservoirSalient.setMaxfloodDischarge(rs.getDouble(21));
							reservoirSalient.setLandAcquistion(rs.getDouble(22));
							reservoirSalient.setIrrpotentialCreatedWet(rs.getDouble(23));
							reservoirSalient.setIrrpotentialCreatedDry(rs.getDouble(24));
							reservoirSalient.setIrrpotentialCreatedContemplated(rs.getDouble(25));
							reservoirSalient.setMajorCrops(rs.getString(26));
							reservoirSalient.setAllocationOfWater(rs.getString(27));
							reservoirSalient.setProjectId(rs.getInt(28));
							reservoirSalient.setPostId(Long.parseLong(rs.getString(29)));
							
							
							reservoirSalient.setDeleteFlag(rs.getBoolean(30));
							reservoirSalient.setIsLatest(rs.getBoolean(31));
							reservoirSalient.setEditFlag(rs.getBoolean(32));
							reservoirSalient.setUserName(rs.getString(33));
							reservoirSalient.setCreatesDate(rs.getString(34));
							reservoirSalient.setUpdateUserName(rs.getString(35));
							reservoirSalient.setUpdateDate(rs.getString(36));
							reservoirSalient.setStatusId(rs.getInt(37));
							reservoirSalient.setOldUnitId(rs.getInt(38));
							reservoirSalient.setOldCircleId(rs.getInt(39));
							reservoirSalient.setOldDivisionId(rs.getInt(40));
							reservoirSalient.setOldSubDivisionId(rs.getInt(41));
							reservoirSalient.setFilePath(rs.getString(42));
							reservoirSalient.setRes_lat_d(rs.getDouble(43));
							reservoirSalient.setRes_lat_m(rs.getDouble(44));
							reservoirSalient.setRes_lat_s(rs.getDouble(45));
							reservoirSalient.setRes_long_d(rs.getDouble(46));
							reservoirSalient.setRes_long_m(rs.getDouble(47));
							reservoirSalient.setRes_long_s(rs.getDouble(48));
							reservoirSalient.setFree_catch(rs.getDouble(49));
							reservoirSalient.setIntercepted(rs.getDouble(50));
							reservoirSalient.setAgriculture(rs.getDouble(51));
							reservoirSalient.setDrinking(rs.getDouble(52));
							reservoirSalient.setIndustrial(rs.getDouble(53));
							reservoirSalient.setOtherBenfits(rs.getDouble(54));
							reservoirSalient.setEvoparation(rs.getDouble(55));
							reservoirSalient.setApprUserName(rs.getString(56));
							reservoirSalient.setDeletedBy(rs.getString(57));
							reservoirSalient.setDeletedTime(rs.getString(58));
							reservoirSalient.setUnitId(rs.getInt(59));
							reservoirSalient.setCircleId(rs.getInt(60));
							reservoirSalient.setDivisionId(rs.getInt(61));
							reservoirSalient.setSubdivisionId(rs.getInt(62));
							reservoirSalient.setIsReassign(rs.getString(63));
							
							
							
							
							
							return reservoirSalient;
						}

					});
			
			// System.out.println("sql"+sql);
			irrInvTemplate.getDataSource().getConnection().close();
			
			//System.out.println("impl2"+ReservoirSalientList);
			return ReservoirSalientList;
		} catch (Exception exc) {
			
			return null;
		}finally{ 
		
			try {
				
				irrInvTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public Integer DeleteStagePMSinvRes(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_INV_RES;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(false);

				 rows = pmsstageTemplate.update(sql);
			

				 pmsstageTemplate.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				pmsstageTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	@Override
	public Integer StagePmsinsertReservoir(List< ReservoirSalient> resObj) throws InventoryUserException, ParseException {
		// TODO Auto-generated method stub

		String sql = INSERT_STAGE_PMS_INV_RES;

	   

		Integer rows1 = 0;
		int[] j = null;
		
	
		try {
			if (resObj != null) {

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(false);
				
				
				if (resObj.size() > 0) {
					
				
				
					
					

			j = pmsstageTemplate.batchUpdate(sql,new BatchPreparedStatementSetter(){
				
					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						
						ReservoirSalient ressalObj = resObj.get(i);
					
							
								java.sql.Date createDate=null;
							java.sql.Date updateDate=null ;
							java.sql.Date deleteDate =null;

						
						if ( resObj.get(i).getCreatesDate()!= null
								) {
						
							
								try {
									createDate = DateUtil.getSQLDate(  resObj.get(i).getCreatesDate());
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
						
						if ( resObj.get(i).getUpdateDate()!= null
								) {
						
							try {
								updateDate = DateUtil.getSQLDate(  resObj.get(i).getUpdateDate());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
						}
						
						if ( resObj.get(i).getDeletedTime()!= null
								) {
						
						
								try {
									deleteDate = DateUtil.getSQLDate(  resObj.get(i).getDeletedTime());
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
						
						}
						
					
					
						
						 ps.setInt(1, ressalObj.getReservoirId());
						 ps.setString(2,  ressalObj.getResName());
						 ps.setString(3, ressalObj.getResLatitude());
						 ps.setString(4,ressalObj.getResLongitude());
						 ps.setInt(5,ressalObj.getResStatusId());
						 ps.setInt(6,ressalObj.getRiverBasinId());
						 ps.setString(7,ressalObj.getSubBasin());
						 ps.setInt(8,ressalObj.getYearConstructionFrom());
						 ps.setInt(9,ressalObj.getYearConstructionTo());
						 ps.setInt(10,ressalObj.getYearImpounding());
						 ps.setString(11,ressalObj.getCatchArea());
						 ps.setDouble(12,ressalObj.getWaterSpreadArea());
						 ps.setDouble(13,ressalObj.getDeepestfoundationLevel());
						 ps.setString(14,ressalObj.getTypeOfDam());
						 ps.setDouble(15,ressalObj.getFrlLevel());
						 ps.setDouble(16,ressalObj.getGrossStorageatFrl());
						 ps.setDouble(17,ressalObj.getMwlLevel());
						 ps.setDouble(18,ressalObj.getMddlLevel());
						 ps.setDouble(19,ressalObj.getLiveStorageabovemddl());
						 ps.setDouble(20,ressalObj.getDeadStoragebelowmddl());
						 ps.setDouble(21,ressalObj.getMaxfloodDischarge());
						 ps.setDouble(22,ressalObj.getLandAcquistion());
						 ps.setDouble(23,ressalObj.getIrrpotentialCreatedWet());
						 ps.setDouble(24,ressalObj.getIrrpotentialCreatedDry());
						 ps.setDouble(25,ressalObj.getIrrpotentialCreatedContemplated());
						 ps.setString(26,ressalObj.getMajorCrops());
						 ps.setString(27,ressalObj.getAllocationOfWater());
						 ps.setInt(28,ressalObj.getProjectId());
						 ps.setLong(29,ressalObj.getPostId());
						 ps.setBoolean(30,ressalObj.getDeleteFlag());
						 ps.setBoolean(31,ressalObj.getIsLatest());
				 ps.setBoolean(32,ressalObj.getEditFlag());
				 ps.setString(33,ressalObj.getUserName());
				 ps.setDate(34,	createDate);
				 ps.setString(35,	ressalObj.getUpdateUserName());
				 ps.setDate(36,	updateDate);
				 ps.setInt(37,	ressalObj.getStatusId());
				 ps.setInt(38,	ressalObj.getOldUnitId());
				 ps.setInt(39,	ressalObj.getOldCircleId());
				 ps.setInt(40,		ressalObj.getOldDivisionId());
				 ps.setInt(41,	ressalObj.getOldSubDivisionId());
				 ps.setString(42,	ressalObj.getFilePath());
				 ps.setDouble(43,		ressalObj.getRes_lat_d());
				 ps.setDouble(44,	ressalObj.getRes_lat_m());
				 ps.setDouble(45,		ressalObj.getRes_lat_s());
				 ps.setDouble(46,		ressalObj.getRes_long_d());
				 ps.setDouble(47,		ressalObj.getRes_long_m());
				 ps.setDouble(48,		ressalObj.getRes_long_s());
				 ps.setDouble(49,		ressalObj.getFree_catch());
				 ps.setDouble(50,		ressalObj.getIntercepted());
				 ps.setDouble(51,	ressalObj.getAgriculture());
				 ps.setDouble(52,		ressalObj.getDrinking());
				 ps.setDouble(53,	ressalObj.getIndustrial());
				 ps.setDouble(54,		ressalObj.getOtherBenfits());
				 ps.setDouble(55,		ressalObj.getEvoparation());
				 ps.setString(56,	ressalObj.getApprUserName());
				 ps.setString(57,		ressalObj.getDeletedBy());
				 ps.setDate(58,		deleteDate);
				 ps.setInt(59,		ressalObj.getUnitId());
				 ps.setInt(60,		ressalObj.getCircleId());
				 ps.setInt(61,		ressalObj.getDivisionId());
				 ps.setInt(62,		ressalObj.getSubdivisionId());
				 ps.setString(63,		ressalObj.getIsReassign());
						
						
						
					}

					@Override
					public int getBatchSize() {
						return resObj.size();
					}
				});

				
				}
				
				 if(j!=null){   
						if (j.length > 0) {
							rows1=j.length;
							
							//System.out.println("rows"+rows);
							return rows1;
						}
				        }
					
			

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(true);
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally{ 
		
			try {
				
				pmsstageTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	
	@Override
	public List<Project> getSourcePmsInvProjectMst( ) throws InventoryUserException {
		
		//System.out.println("impl"+rescode);
		// TODO Auto-generated method stub
		String sql = SOURCE_PMS_INV_PROJ_MST_DATA;
		
		
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
           // System.out.println("sql"+sql);
			List<Project>  projectList =  irrInvTemplate.query(sql,
					new RowMapper<Project>(){

						public Project mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							
							

							Project projectinfo = new Project();
							
						
							
							projectinfo.setProjectId(rs.getInt(1));
							projectinfo.setProjectName(rs.getString(2));
							projectinfo.setProjParentId(rs.getInt(3));
							projectinfo.setProjectCode(rs.getString(4));
							projectinfo.setDeleteFlag(rs.getBoolean(5));
							projectinfo.setIsEPC(rs.getBoolean(6));
							projectinfo.setProjOldName(rs.getString(7));
							projectinfo.setProjOldId(rs.getInt(8));
							projectinfo.setProjectTypeId(rs.getInt(9));
							projectinfo.setProjStatusId(rs.getInt(10));
							
							
							
							
							
							
							
							return projectinfo;
						}

					});
			
			// System.out.println("sql"+sql);
			irrInvTemplate.getDataSource().getConnection().close();
			
			//System.out.println("impl2"+ReservoirSalientList);
			return projectList;
		} catch (Exception exc) {
			
			return null;
		}finally{ 
		
			try {
				
				irrInvTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public Integer DeleteStagePMSinvprojMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_INV_PROJ_MST;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(false);

				 rows = pmsstageTemplate.update(sql);
			

				 pmsstageTemplate.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				pmsstageTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	@Override
	public Integer StagePmsinsertProjMst(List<Project> projObj) throws InventoryUserException, ParseException {
		// TODO Auto-generated method stub

		String sql = INSERT_STAGE_PMS_INV_PROJ_MST;

	   

		Integer rows1 = 0;
		int[] j = null;
		
	
		try {
			if (projObj != null) {

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(false);
				
				
				if (projObj.size() > 0) {
					
				
				
					
					

			j = pmsstageTemplate.batchUpdate(sql,new BatchPreparedStatementSetter(){
				
					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						
						Project prnewObj = projObj.get(i);
					
							
								
					
					
						
						 ps.setInt(1, prnewObj.getProjectId());
						 ps.setString(2,  prnewObj.getProjectName());
						 ps.setInt(3, prnewObj.getProjParentId());
						 ps.setString(4,prnewObj.getProjectCode());
						 ps.setBoolean(5,prnewObj.getDeleteFlag());
						 ps.setBoolean(6,prnewObj.getIsEPC());
						 ps.setString(7,prnewObj.getProjOldName());
						 ps.setInt(8,prnewObj.getProjOldId());
						 ps.setInt(9,prnewObj.getProjectTypeId());
						 ps.setInt(10,prnewObj.getProjStatusId());
						
						
						 
						
						
					}

					@Override
					public int getBatchSize() {
						return projObj.size();
					}
				});

				
				}
				
				 if(j!=null){   
						if (j.length > 0) {
							rows1=j.length;
							
							//System.out.println("rows"+rows);
							return rows1;
						}
				        }
					
			

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(true);
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally{ 
		
			try {
				
				pmsstageTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public List<Project> getSourcePmsInvProjectUnitMap( ) throws InventoryUserException {
		
		//System.out.println("impl"+rescode);
		// TODO Auto-generated method stub
		String sql = SOURCE_PMS_INV_PROJ_UNIT_MAP;
		
		
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
           // System.out.println("sql"+sql);
			List<Project>  projectList =  irrInvTemplate.query(sql,
					new RowMapper<Project>(){

						public Project mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							
							

							Project projectinfo = new Project();
							
						
							
							projectinfo.setProjUnitId(rs.getInt(1));
							projectinfo.setProjectId(rs.getInt(2));
							projectinfo.setUnitId(rs.getInt(3));
							projectinfo.setDeleteFlag(rs.getBoolean(4));
							
							projectinfo.setIsLatest(rs.getBoolean(5));
						
							
							
							
							
							
							
							
							return projectinfo;
						}

					});
			
			// System.out.println("sql"+sql);
			irrInvTemplate.getDataSource().getConnection().close();
			
			//System.out.println("impl2"+ReservoirSalientList);
			return projectList;
		} catch (Exception exc) {
			
			return null;
		}finally{ 
		
			try {
				
				irrInvTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public Integer DeleteStagePMSinvprojUnitMap(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_INV_PROJ_UNIT_MAP;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(false);

				 rows = pmsstageTemplate.update(sql);
			

				 pmsstageTemplate.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				pmsstageTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	@Override
	public Integer StagePmsinsertProjUnitMap(List<Project> projObj) throws InventoryUserException, ParseException {
		// TODO Auto-generated method stub

		String sql = INSERT_STAGE_PMS_INV_PROJ_UNIT_MAP;

	   

		Integer rows1 = 0;
		int[] j = null;
		
	
		try {
			if (projObj != null) {

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(false);
				
				
				if (projObj.size() > 0) {
					
				
				
					
					

			j = pmsstageTemplate.batchUpdate(sql,new BatchPreparedStatementSetter(){
				
					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						
						Project prnewObj = projObj.get(i);
					
							
								
					
					
						
						 ps.setInt(1, prnewObj.getProjUnitId());
						 ps.setInt(2,  prnewObj.getProjectId());
						 ps.setInt(3,  prnewObj.getUnitId());
						 ps.setBoolean(4, prnewObj.getDeleteFlag());
						 ps.setBoolean(5,prnewObj.getIsLatest());
						
						
						
						
						 
						
						
					}

					@Override
					public int getBatchSize() {
						return projObj.size();
					}
				});

				
				}
				
				 if(j!=null){   
						if (j.length > 0) {
							rows1=j.length;
							
							//System.out.println("rows"+rows);
							return rows1;
						}
				        }
					
			

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(true);
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally{ 
		
			try {
				
				pmsstageTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public List<Packages> getSourcePmsInvPackages( ) throws InventoryUserException {
		
		//System.out.println("impl"+rescode);
		// TODO Auto-generated method stub
		String sql = SOURCE_PMS_INV_PACKAGES;
		
		
		
		//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
		try {
        
			List<Packages>  packList =  irrInvTemplate.query(sql,
					new RowMapper<Packages>(){

						public Packages mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							
							

							Packages packs = new Packages();
							
						
							
							packs.setPkgId(rs.getInt(1));
							packs.setPkgName(rs.getString(2));
							packs.setPkgCode(rs.getString(3));
							packs.setProjectId(rs.getInt(4));
							packs.setCircleId(rs.getInt(5));
							
							
							packs.setUserName(rs.getString(6));
							packs.setCreateDate(rs.getString(7));
							packs.setDeleteFlag(rs.getBoolean(8));
							
							packs.setPostId(Long.parseLong(rs.getString(9)));
							packs.setIsLatest(rs.getBoolean(10));
							packs.setExtent(rs.getDouble(11));
							packs.setAgmtValue(rs.getDouble(12));
							
							packs.setIsProforma(rs.getBoolean(13));
							
							
						
							
							
							
							
							
							
							
							return packs;
						}

					});
			
			// System.out.println("sql"+sql);
			irrInvTemplate.getDataSource().getConnection().close();
			
			//System.out.println("impl2"+ReservoirSalientList);
			return packList;
		} catch (Exception exc) {
			
			return null;
		}finally{ 
		
			try {
				
				irrInvTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public Integer DeleteStagePMSinvPackages(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_STAGE_INV_PACKAGES;   

		

		Integer rows = 0;

		try {
			if (flag == true) {

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(false);

				 rows = pmsstageTemplate.update(sql);
			

				 pmsstageTemplate.getDataSource().getConnection().setAutoCommit(true);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				pmsstageTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	@Override
	public Integer StagePmsinsertPackages(List<Packages> projObj) throws InventoryUserException, ParseException {
		// TODO Auto-generated method stub

		String sql = INSERT_STAGE_PMS_INV_PACKAGES;

	   

		Integer rows1 = 0;
		int[] j = null;
		
	
		try {
			if (projObj != null) {

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(false);
				
				
				if (projObj.size() > 0) {
					
				
				
					
					

			j = pmsstageTemplate.batchUpdate(sql,new BatchPreparedStatementSetter(){
				
					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						
						Packages prnewObj = projObj.get(i);
					
							
						java.sql.Date createDate=null;
						

					
					if ( projObj.get(i).getCreateDate()!= null
							) {
					
						
							try {
								createDate = DateUtil.getSQLDate( projObj.get(i).getCreateDate());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
					
					
					
					
						
						 ps.setInt(1, prnewObj.getPkgId());
						 ps.setString(2,  prnewObj.getPkgName());
						 ps.setString(3,  prnewObj.getPkgCode());
						 ps.setInt(4, prnewObj.getProjectId());
						 ps.setInt(5,prnewObj.getCircleId());
						 ps.setString(6, prnewObj.getUserName());
						 ps.setDate(7, createDate);
						 ps.setBoolean(8, prnewObj.getDeleteFlag());
						
					
						 ps.setLong(9, prnewObj.getPostId());
						 ps.setBoolean(10,prnewObj.getIsLatest());
						 ps.setDouble(11,prnewObj.getExtent());
						 ps.setDouble(12, prnewObj.getAgmtValue());
						 ps.setBoolean(13,  prnewObj.getIsProforma());
						
						
						
						
						
						
						 
						
						
					}

					@Override
					public int getBatchSize() {
						return projObj.size();
					}
				});

				
				}
				
				 if(j!=null){   
						if (j.length > 0) {
							rows1=j.length;
							
							//System.out.println("rows"+rows);
							return rows1;
						}
				        }
					
			

				pmsstageTemplate.getDataSource().getConnection().setAutoCommit(true);
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally{ 
		
			try {
				
				pmsstageTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	@Override
	public List<Project> getProjectCodesList(Integer projectId) throws InventoryUserException {
		
		String sql = SELECT_PROJECTS_CODES;
		try {

			List<Project> projectList = jdbcTemplate.query(sql,new Object[] { projectId },
					new RowMapper<Project>() {

						public Project mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Project project = new Project();
							project.setProjectId(rs.getInt(1));
							project.setProjectCode(rs.getString(2));
							project.setProjectName(rs.getString(3));
							return project;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return projectList;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	@Override
	public Integer AddAnnRemarks(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_NRLD_ANN_REMARKS;		 
		
		String sql2 = UPDATE_NRLD_OLD_ANN_REMARKS;		 
		
		
		
Integer rows1=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				/* if(resobj.getInspectDate()!=null){
					 
						try {
							
						//	System.out.println("resobj.getInspectDate()2"+resobj.getInspectDate());
							
							date1 = DateUtil.getSQLDate(resobj.getInspectDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				 }*/
             	
				 if(resobj.getReservoirId()!=null && resobj.getLevelId()!=null  && resobj.getTabId()!=null){
					
					 rows2 = jdbcTemplate8.update(sql2,resobj.getUserName(),resobj.getResInspectMst1Id(),resobj.getLevelId(),resobj.getInspectOfficeInfoId());	
					 
				 }
			
					 if( resobj.getResInspectMst1Id()!=null && resobj.getLevelId()!=null && resobj.getRemarks()!=null && resobj.getInspectOfficeInfoId()!=null){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getReservoirId(),resobj.getUserName(),
								 resobj.getUnitId(),resobj.getCircleId(),
								 resobj.getDivisionId(),resobj.getSubdivisionId(),resobj.getProjectId(),
								 resobj.getDesignationId(),resobj.getLevelId(),resobj.getRemarks(),
								 resobj.getTabId(),resobj.getEmpId(),resobj.getPostId(),resobj.getNextPostId(),resobj.getNextEmpId(),resobj.getSectionId(),resobj.getResInspectMst1Id(),resobj.getInspectOfficeInfoId(),resobj.getRemarksinclindoc());	
						
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer AddPrevAnnRemarks(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_PREV_NRLD_ANN_REMARKS;		 
		
		//String sql2 = UPDATE_NRLD_OLD_ANN_REMARKS;		 
		
		
		
Integer rows1=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				/* if(resobj.getInspectDate()!=null){
					 
						try {
							
						//	System.out.println("resobj.getInspectDate()2"+resobj.getInspectDate());
							
							date1 = DateUtil.getSQLDate(resobj.getInspectDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				 }*/
             	
				/* if(resobj.getReservoirId()!=null && resobj.getLevelId()!=null  && resobj.getTabId()!=null){
					
					 rows2 = jdbcTemplate8.update(sql2,resobj.getUserName(),resobj.getResInspectMst1Id(),resobj.getLevelId(),resobj.getInspectOfficeInfoId());	
					 
				 }*/
			
					 if( resobj.getResInspectMst1Id()!=null && resobj.getLevelId()!=null){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),
								 resobj.getUnitId(),resobj.getCircleId(),
								 resobj.getDivisionId(),resobj.getSubdivisionId(),
								 resobj.getDesignationId(),resobj.getLevelId(),
								 resobj.getEmpId(),resobj.getPostId(),resobj.getNextPostId(),resobj.getNextEmpId(),resobj.getSectionId(),resobj.getResInspectMst1Id(),resobj.getPrevResInspectMst1Id());	
						
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	
	
	
	
	@Override
	public Integer AddNrldInspectionInfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql1=  SELECT_COUNT_NRLD_INSPECT_INTO;
		
		String sql3 = INSERT_NRLD_INSPECT_INFO;		 
		
		String sql2 = UPDATE_NRLD_INSPECT_INFO_OLD;		 
		
		String sql4=  SELECT_OLD_NRLD_INSPECT_ID;
		
		
		
Integer rows1=0;
Integer rows2=0;

Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("sql2"+sql2);
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				 if(resobj.getInspectDate()!=null){
					 
					 
				
					 
					 
						try {
							
							//System.out.println("resobj.getInspectDate()2"+resobj.getInspectDate());
							
							date1 = DateUtil.getSQLDate(resobj.getInspectDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				 }
				 
				 
				 
				 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql1,resobj.getResInspectMst1Id() , date1,resobj.getInspectOfficeId()  );	
				 
				 if(result!=null){
										 
										 for (Map<String, Object> row : result) {
											 updatedfreq = Integer.parseInt(row.get("res_dam_inspect_info_id").toString());
											}
									 }
				 
				 if(updatedfreq>0){
					 
	            	  List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{resobj.getResInspectMst1Id() , date1,resobj.getInspectOfficeId()});
	                  
						 if(result1!=null){
							 
							 for (Map<String, Object> row : result1) {
								 rows1=Integer.parseInt(row.get("res_dam_inspect_info_id").toString()); ;
								}
						 }
		             
	            	 rows1=-4 ;
	            }
				 
				 
             	
				 if(resobj.getResInspectMst1Id()!=null && resobj.getLevelId()!=null  ){
					
					 rows2 = jdbcTemplate8.update(sql2,resobj.getUserName(),resobj.getResInspectMst1Id(),resobj.getLevelId());	
					 
				 }
			
				 if (updatedfreq<1){
					 if( resobj.getResInspectMst1Id()!=null && resobj.getLevelId()!=null   ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getResInspectMst1Id(),resobj.getUserName(),
								 resobj.getUnitId(),resobj.getCircleId(),
								 resobj.getDivisionId(),resobj.getSubdivisionId(),resobj.getProjectId(),
								 resobj.getDesignationId(),resobj.getInspectOfficeId(),resobj.getInspectOfficerData(),
								 resobj.getFieldOfficerData(),date1,resobj.getPresentWaterlevel(),
								 resobj.getTabId(),resobj.getEmpId(),resobj.getPostId(), resobj.getNextPostId(),
								resobj.getSectionId(), resobj.getNextEmpId(),resobj.getLevelId(), resobj.getTypeofinspection(),resobj.getStorageCapacity(), resobj.getWeatherconditionId(),resobj.getDamOperator(),resobj.getOwnerOfDam(),resobj.getInspectdesignationId()  );	
						
				}
				 }
					 
					 
					/* resobj.getInchargeofAnn1(),
					 resobj.getPreDaminspecteddata(),resobj.getItemsInspected(),resobj.getItemsInspectedReason(),
					 resobj.getVigandWatchProvided(),resobj.getVigandwatchreason(),resobj.getObsAnn2(),*/
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	@Override
	public Integer AddPrevNrldInspectionInfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql1=  SELECT_PREV_COUNT_NRLD_INSPECT_INTO;
		
		String sql3 = INSERT_PREV_NRLD_INSPECT_INFO;		 
		
		String sql2 = UPDATE_NRLD_INSPECT_INFO_OLD;		 
		
		String sql4=  SELECT_PREV_OLD_NRLD_INSPECT_ID;
		
		
		
Integer rows1=0;
Integer rows2=0;

Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("sql2"+sql2);
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				 if(resobj.getInspectDate()!=null){
					 
					 
					 
					
					 
					 
						try {
							
							//System.out.println("resobj.getInspectDate()2"+resobj.getInspectDate());
							
							date1 = DateUtil.getSQLDate(resobj.getInspectDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				 }
				 
				 
				 
				 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql1,resobj.getResInspectMst1Id()   );	
				 
				 if(result!=null){
										 
										 for (Map<String, Object> row : result) {
											 updatedfreq = Integer.parseInt(row.get("res_dam_inspect_info_id").toString());
											}
									 }
				 
				 if(updatedfreq>0){
					 
	            	  List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{resobj.getResInspectMst1Id() });
	                  
						 if(result1!=null){
							 
							 for (Map<String, Object> row : result1) {
								 rows1=Integer.parseInt(row.get("res_dam_inspect_info_id").toString()); ;
								}
						 }
		             
	            	 rows1=-4 ;
	            }
				 
				 
             	
				 if(resobj.getResInspectMst1Id()!=null && resobj.getLevelId()!=null  ){
					
					 rows2 = jdbcTemplate8.update(sql2,resobj.getUserName(),resobj.getResInspectMst1Id(),resobj.getLevelId());	
					 
				 }
			
				 if (updatedfreq<1){
					 
// System.out.println("resobj.getDutyFrequencyId()"+resobj.getDutyFrequencyId());
					 
					 if(resobj.getDutyFrequencyId()==9){
						 
						 resobj.setTypeofinspection("pre monsoon"); 
					 }else if (resobj.getDutyFrequencyId()==10){
						 
						 resobj.setTypeofinspection("post monsoon"); 
					 }
				
					 
					 
					 if( resobj.getResInspectMst1Id()!=null && resobj.getLevelId()!=null   ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getResInspectMst1Id(),resobj.getUserName(),
								 resobj.getUnitId(),resobj.getCircleId(),
								 resobj.getDivisionId(),resobj.getSubdivisionId(),
								 resobj.getDesignationId(),  resobj.getEmpId(),resobj.getPostId(), resobj.getNextPostId(),
								resobj.getSectionId(), resobj.getNextEmpId(),resobj.getLevelId(),resobj.getTypeofinspection(), resobj.getPrevResInspectMst1Id()   );	
						
				}
				 }
					 
					 
					/* resobj.getInchargeofAnn1(),
					 resobj.getPreDaminspecteddata(),resobj.getItemsInspected(),resobj.getItemsInspectedReason(),
					 resobj.getVigandWatchProvided(),resobj.getVigandwatchreason(),resobj.getObsAnn2(),*/
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	
	
	
	
	@Override
	public Integer UpdateNrldInspectionInfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_NRLD_INSPECT_INFO;		 
		
		 
		
		
		
Integer rows1=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("sql2"+sql2);
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				 if(resobj.getInspectDate()!=null){
					 
						try {
							
							//System.out.println("resobj.getInspectDate()2"+resobj.getInspectDate());
							
							date1 = DateUtil.getSQLDate(resobj.getInspectDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				 }
             	
				
			
					 if( resobj.getResinspectInfoId() !=null   ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),
								resobj.getInspectOfficeId(),resobj.getInspectOfficerData(),
								 resobj.getFieldOfficerData(),date1,resobj.getPresentWaterlevel(),
								 resobj.getTypeofinspection(),resobj.getStorageCapacity(), resobj.getWeatherconditionId(),resobj.getDamOperator(),resobj.getOwnerOfDam(), resobj.getInspectdesignationId(),resobj.getResinspectInfoId()  );	
						
				}
					 
					 
					/* resobj.getInchargeofAnn1(),
					 resobj.getPreDaminspecteddata(),resobj.getItemsInspected(),resobj.getItemsInspectedReason(),
					 resobj.getVigandWatchProvided(),resobj.getVigandwatchreason(),resobj.getObsAnn2(),*/
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	
	@Override
	public Integer UpdateNrldAnnmst2Info(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_NRLD_ANN_MST2;		
		
	//	System.out.println("resobj.getResCheckName()"+resobj.getResCheckName());
		
		 
		if(resobj.getResCheckName()==null){
			
			resobj.setResCheckName("NA");	
			
		}
		
		
Integer rows1=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("sql2"+sql2);
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				 if(resobj.getInspectDate()!=null){
					 
						try {
							
							//System.out.println("resobj.getInspectDate()2"+resobj.getInspectDate());
							
							date1 = DateUtil.getSQLDate(resobj.getInspectDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				 }
             	
				
				// System.out.println("resobj.getAnalysisofdata()"+resobj.getAnalysisofdata());
			
					 if( resobj.getResInspectMst2Id() !=null   ){
						 rows1 = jdbcTemplate8.update(sql3,date1,resobj.getUserName(),resobj.getRemarks(),
								resobj.getIrrChFrm(),resobj.getIrrChTo(),resobj.getInstalledcount(),
								resobj.getLocation(),resobj.getInstallmonth(), resobj.getWorkingcondition(),resobj.getDatelastCalibrated(),resobj.getDatenextCalibrated(),
								resobj.getObsmaintained(),resobj.getAgencyresponsible(),resobj.getAnalysisofdata(),resobj.getDatasenttoDSO(),
								resobj.getConditionofCheckId(),resobj.getResCheckName(),resobj.getDamcheckResponseId(),resobj.getResInspectMst2Id()  );	
						
				}
					 
					 
					/* resobj.getInchargeofAnn1(),
					 resobj.getPreDaminspecteddata(),resobj.getItemsInspected(),resobj.getItemsInspectedReason(),
					 resobj.getVigandWatchProvided(),resobj.getVigandwatchreason(),resobj.getObsAnn2(),*/
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	@Override
	public Integer AddNrldRecommendationInfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_NRLD_ANN_RECOMMENDATIONS;	
		
		String sql2= UPDATE_NRLD_ANN_RECOMMENDATIONS;		
		
		
		
		
		
Integer rows1=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	  // System.out.println("sql3"+sql3);
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				 
				 
				 if( resobj.getResInspectMst1Id()>0 && (( resobj.getResInspectMst2Id()>0 &&  resobj.getResDamHealthId()==0) || ( resobj.getResInspectMst2Id()==0 &&  resobj.getResDamHealthId()>0)  )   && resobj.getInspectOfficeInfoId()>0 &&  resobj.getRemarks().length()>0 ){
						
					 rows2 = jdbcTemplate8.update(sql2,resobj.getUserName(),resobj.getResInspectMst1Id() , resobj.getResInspectMst2Id() , resobj.getInspectOfficeInfoId(), resobj.getResDamHealthId());	
					 
				 }
				 
				
			
					 if( resobj.getResInspectMst1Id()>0  && (( resobj.getResInspectMst2Id()>0 &&  resobj.getResDamHealthId()==0) || ( resobj.getResInspectMst2Id()==0 &&  resobj.getResDamHealthId()>0)  )  && resobj.getInspectOfficeInfoId()>0 &&  resobj.getRemarks().length()>0 ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getResInspectMst1Id(),resobj.getResInspectMst2Id(),
								 resobj.getInspectOfficeInfoId(),resobj.getRemarks(),
								 resobj.getUserName(),resobj.getEmpId(),resobj.getResDamHealthId(),resobj.getPostId());	
						
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer AddPrevNrldRecommendationInfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_PREV_NRLD_ANN_RECOMMENDATIONS;	
		
		//String sql2= UPDATE_NRLD_ANN_RECOMMENDATIONS;		
		
		
		
		
		
Integer rows1=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	  // System.out.println("sql3"+sql3);
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				 
				 
				/* if( resobj.getResInspectMst1Id()>0 && (( resobj.getResInspectMst2Id()>0 &&  resobj.getResDamHealthId()==0) || ( resobj.getResInspectMst2Id()==0 &&  resobj.getResDamHealthId()>0)  )   && resobj.getInspectOfficeInfoId()>0 &&  resobj.getRemarks().length()>0 ){
						
					 rows2 = jdbcTemplate8.update(sql2,resobj.getUserName(),resobj.getResInspectMst1Id() , resobj.getResInspectMst2Id() , resobj.getInspectOfficeInfoId(), resobj.getResDamHealthId());	
					 
				 }
				 */
				
			
					 if( resobj.getResInspectMst1Id()>0  ){
						 rows1 = jdbcTemplate8.update(sql3,
								
								 resobj.getUserName(),resobj.getEmpId(),resobj.getPostId(),resobj.getPrevResInspectMst1Id() );	
						
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public List<ReservoirInspect> getResmst2andmst1ByYearFreq(ReservoirInspect reservoirInspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		String sql = GET_RES_MST2_MST1_BY_YEAR_FREQ;
		try {
			
			//System.out.println("sql"+sql);	
			

			List<ReservoirInspect> reservoirInspectinf = jdbcTemplate8.query(sql ,new Object[]{reservoirInspect.getReservoirId(),reservoirInspect.getYear(),reservoirInspect.getDutyFrequencyId(),reservoirInspect.getTankId()},
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect reservoirInspect = new ReservoirInspect();
							
							//System.out.println("rs.getInt(1)"+rs.getInt(1));	
							
							reservoirInspect.setResInspectMst1Id(rs.getInt(1));
							reservoirInspect.setResInspectMst2Id(rs.getInt(2));
							reservoirInspect.setResCheckId(rs.getInt(3));
							reservoirInspect.setResCategoryId(rs.getInt(4));
							reservoirInspect.setRemarks(rs.getString(5));
							reservoirInspect.setTabId(rs.getInt(6));
							reservoirInspect.setAnnexureId(rs.getInt(7));
							reservoirInspect.setPostId(rs.getLong(8));
							reservoirInspect.setIrrChFrm(rs.getDouble(9));
							reservoirInspect.setIrrChTo(rs.getDouble(10));
							reservoirInspect.setInstalledcount(rs.getInt(11));
							reservoirInspect.setLocation(rs.getString(12));
							reservoirInspect.setInstallmonth(rs.getString(13));
							reservoirInspect.setWorkingcondition(rs.getBoolean(14));
							
							reservoirInspect.setDatelastCalibrated(rs.getString(15));
							reservoirInspect.setDatenextCalibrated(rs.getString(16));
							reservoirInspect.setObsmaintained(rs.getBoolean(17));
							reservoirInspect.setAgencyresponsible(rs.getBoolean(18));
							reservoirInspect.setAnalysisofdata(rs.getBoolean(19));
							reservoirInspect.setDatasenttoDSO(rs.getBoolean(20));
							reservoirInspect.setConditionofCheckId(rs.getInt(21));
							reservoirInspect.setResCheckName(rs.getString(22));
							reservoirInspect.setDamcheckResponseId(rs.getInt(23));
							reservoirInspect.setConditionofDamId(rs.getInt(24));
							
						
							
							return reservoirInspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();
			return reservoirInspectinf;
		} catch (Exception exc) {
			
			return null;
		}
	}
	
	
	
	
	@Override
	public List<ReservoirInspect> getResInspectInfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=GET_RES_INSPECT_INFO_TANK;
		
		try {
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getReservoirId(),resObj.getYear(),resObj.getTankId(),resObj.getDutyFrequencyId()  },
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
							
							if(rs.getInt(24)==1){
							resinfo.setWeathercondition("Sunny");
							}else if(rs.getInt(24)==2){
								resinfo.setWeathercondition("Rainy");	
								
							}
							else if(rs.getInt(24)==3){
								resinfo.setWeathercondition("Good");	
								
							}
							
							else if(rs.getInt(24)==4){
								resinfo.setWeathercondition("Bad");	
								
							}
							resinfo.setTypeofinspection(rs.getString(25));
							resinfo.setTankId(rs.getInt(26));
							
							resinfo.setDamOperator(rs.getString(27));
							
							resinfo.setOwnerOfDam(rs.getString(28));
							
							resinfo.setInspectdesignationId(rs.getInt(29));
							
							
                             if(rs.getInt(29)==10){
								
								resinfo.setInspectdesignationName("ENC");
							}else if(rs.getInt(29)==9){
								
								resinfo.setInspectdesignationName("CE");
							}else if(rs.getInt(29)==7){
								
								resinfo.setInspectdesignationName("SE");
							}else if(rs.getInt(29)==5){
								
								resinfo.setInspectdesignationName("EE");
							}else if(rs.getInt(29)==4){
								
								resinfo.setInspectdesignationName("DEE");
							}else if(rs.getInt(29)==0){
								
								resinfo.setInspectdesignationName("NA");
							}
							
						
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
	public List<ReservoirInspect> getResInspectInfobyInspectOfficeInfoId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=INSPECT_INFO_BY_INSPECT_OFFICEINFO_ID;
		
		/*if(resObj.getResinspectInfoId()!=null){
		
		resObj.setInspectOfficeInfoId(resObj.getResinspectInfoId());
		
	}
		*/
		try {
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getResinspectInfoId()  },
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
							
							resinfo.setTypeofinspection(rs.getString(23));
							resinfo.setStorageCapacity(rs.getDouble(24));
							
							resinfo.setWeatherconditionId(rs.getInt(25));
							
							if(rs.getInt(25)==1){
							resinfo.setWeathercondition("Sunny");
							}else if(rs.getInt(25)==2){
								
								resinfo.setWeathercondition("Rainy");
							}
                              else if(rs.getInt(25)==3){
								
								resinfo.setWeathercondition("Good");
							}else if(rs.getInt(25)==4){
								
								resinfo.setWeathercondition("Bad");
							}
							resinfo.setDamOperator(rs.getString(26));
							resinfo.setOwnerOfDam(rs.getString(27));
							
							resinfo.setInspectdesignationId(rs.getInt(28));
							
							if(rs.getInt(28)==10){
								
								resinfo.setInspectdesignationName("ENC");
							}else if(rs.getInt(28)==9){
								
								resinfo.setInspectdesignationName("CE");
							}else if(rs.getInt(28)==7){
								
								resinfo.setInspectdesignationName("SE");
							}else if(rs.getInt(28)==5){
								
								resinfo.setInspectdesignationName("EE");
							}else if(rs.getInt(28)==4){
								
								resinfo.setInspectdesignationName("DEE");
							}else if(rs.getInt(28)==0){
								
								resinfo.setInspectdesignationName("NA");
							}
							resinfo.setUnitAddress(rs.getString(29));
							
						
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
	public Integer AddDamHealthStatusInfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_RES_DAM_HEALTH;	
		
		String sql2= RES_DAM_HEALTH_STATUS_COUNT;	

		String sql4=RES_DAM_HEALTH_ID;
		
		String sql5=UPDATE_OLD_RES_DAM_HEALTH;
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				 
				 
				 if( resobj.getResInspectMst1Id()>0   && resobj.getInspectOfficeInfoId()>0 &&  resobj.getRemarks().length()>0 ){
					 
					 rows2 = jdbcTemplate8.update(sql5,resobj.getUserName(),resobj.getResInspectMst1Id()  );		
					 
					 
					// System.out.println("sql5"+sql5);
					 
					// System.out.println("sql3"+sql3);
						
					/* 07012023 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2,resobj.getResInspectMst1Id() , resobj.getInspectOfficeInfoId());	
					 
 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("res_dam_health_id").toString());
							}
					 }
 
 */
           /*  07012023  if(updatedfreq>0){*/
	 
            	 /* List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{resobj.getResInspectMst1Id() , resobj.getInspectOfficeInfoId()});
                  
					 if(result1!=null){
						 
						 for (Map<String, Object> row : result1) {
							 rows1=Integer.parseInt(row.get("res_dam_health_id").toString()); ;
							}
					 }
	 */             
            	/*  07012023 rows1=-2 ;
            }*/
					 
				 
				 
				/*  07012023 if(updatedfreq<1){*/
			
					/* if( resobj.getResInspectMst1Id()>0   && resobj.getInspectOfficeInfoId()>0 &&  resobj.getRemarks().length()>0 ){*/
						 rows1 = jdbcTemplate8.update(sql3,resobj.getResInspectMst1Id(),resobj.getRemarks(),
								 resobj.getDesignationId(), resobj.getUserName(),resobj.getReservoirId(), resobj.getInspectOfficeInfoId(),resobj.getPostId(),resobj.getDeficiencyCategory());	
						
				/*}*/
				/*}*/
				 }
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public Integer AddPrevDamHealthStatusInfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_PREV_RES_DAM_HEALTH;	
		
		String sql2= RES_DAM_HEALTH_STATUS_COUNT;	

		String sql4=RES_DAM_HEALTH_ID;
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				 
				 
				 if( resobj.getResInspectMst1Id()>0  ){
					 
					
							
				
						 
					
						
					/* 07012023 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2,resobj.getResInspectMst1Id() , resobj.getInspectOfficeInfoId());	
					 
 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("res_dam_health_id").toString());
							}
					 }
 
 */
           /*  07012023  if(updatedfreq>0){*/
	 
            	 /* List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{resobj.getResInspectMst1Id() , resobj.getInspectOfficeInfoId()});
                  
					 if(result1!=null){
						 
						 for (Map<String, Object> row : result1) {
							 rows1=Integer.parseInt(row.get("res_dam_health_id").toString()); ;
							}
					 }
	 */             
            	/*  07012023 rows1=-2 ;
            }*/
					 
				 
				 
				/*  07012023 if(updatedfreq<1){*/
			
					 if( resobj.getResInspectMst1Id()>0    ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getResInspectMst1Id(),
								 resobj.getDesignationId(), resobj.getUserName(),resobj.getPostId(),resobj.getPrevResInspectMst1Id());	
						
				/*}*/
				}
				 }
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public List<ReservoirInspect> getDamHealthDetailsBYmst1Id(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=GET_DAM_HEALTH_BY_MST1ID;
		
		//System.out.println("sql"+sql);
		
		try {
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getReservoirId(),resObj.getYear(),resObj.getDutyFrequencyId(),resObj.getTankId()  },
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
	public List<ReservoirInspect> getDamHealthDetailsBYHealthId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=GET_DAM_HEALTH_BY_HEALTHID;
		
		//System.out.println("sql"+sql);
		
		try {
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getResDamHealthId()},
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
	public List<ReservoirInspect> getActionTakenDetailsBYmst1Id(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=GET_ACTION_TAKEN_DETAILS_MST1ID;
		
		try {
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getReservoirId(),resObj.getYear(),resObj.getDutyFrequencyId(),resObj.getTankId()  },
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect    resinfo = new ReservoirInspect();
							
							resinfo.setResDamActionId(rs.getInt(1));
							resinfo.setResInspectMst1Id(rs.getInt(2));
							resinfo.setRemarks(rs.getString(3));						
							
							resinfo.setDesignationId(rs.getInt(4));
							resinfo.setReservoirId(rs.getInt(5));
							resinfo.setInspectOfficeInfoId(rs.getInt(6));
							
							resinfo.setPostId(rs.getLong(7));
							resinfo.setInspectOfficeName(rs.getString(8));
							resinfo.setActionTakeninit(rs.getBoolean(9));
							resinfo.setResDamHealthId(rs.getInt(10));
							resinfo.setActionTakencomplete(rs.getBoolean(11));
							resinfo.setResannRecommendId(rs.getInt(12));
							
						
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
	public List<ReservoirInspect> getActionTakenDetailsBYActionId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=GET_ACTION_TAKEN_DETAILS_ACTIONID;
		
		try {
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getResDamActionId()  },
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect    resinfo = new ReservoirInspect();
							
							resinfo.setResDamActionId(rs.getInt(1));
							resinfo.setResInspectMst1Id(rs.getInt(2));
							resinfo.setRemarks(rs.getString(3));						
							
							resinfo.setDesignationId(rs.getInt(4));
							resinfo.setReservoirId(rs.getInt(5));
							resinfo.setInspectOfficeInfoId(rs.getInt(6));
							
							resinfo.setPostId(rs.getLong(7));
							resinfo.setInspectOfficeName(rs.getString(8));
							resinfo.setActionTakeninit(rs.getBoolean(9));
							resinfo.setResDamHealthId(rs.getInt(10));
							resinfo.setActionTakencomplete(rs.getBoolean(11));
							resinfo.setResannRecommendId(rs.getInt(12));
							
						
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
	public List<ReservoirInspect> getDamHealthDetailsBYInspectInfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		//System.out.println("coming here");
		
		String sql=GET_DAM_HEALTH_BY_INSPECTINFO;
		
		try {
			
			List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getResinspectInfoId()  },
					new RowMapper<ReservoirInspect>() {

						public ReservoirInspect mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirInspect    resinfo = new ReservoirInspect();
							
							resinfo.setResDamHealthId(rs.getInt(1));
							resinfo.setResInspectMst1Id(rs.getInt(2));
							resinfo.setRemarks(rs.getString(3));						
							
							resinfo.setDesignationId(rs.getInt(4));
							
							resinfo.setInspectOfficeInfoId(rs.getInt(5));
							
							resinfo.setPostId(rs.getLong(6));
							resinfo.setInspectOfficeName(rs.getString(7));
							resinfo.setDeficiencyCategory(rs.getInt(8));
							resinfo.setDeficiencyCategoryName(rs.getString(9));
						
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
	public List<ReservoirInspect> getResAnnRecomndbyhealthInspectInfo(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_RES_ANN_RECOMMEND_BY_INSPECT_ID ;
		try {
 // System.out.println("sql"+sql);
			List<ReservoirInspect> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getInspectOfficeInfoId(),resObj.getResInspectMst1Id(),resObj.getResInspectMst2Id() },
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
	public Integer AddActionTakenStatusInfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_ACTION_TAKEN_STATUS;	
		
		String sql2= ATS_DAM_STATUS_COUNT;	

		String sql4=ATS_DAM_ACTION_ID;
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				 
				 
				 if( resobj.getResInspectMst1Id()>0   && resobj.getInspectOfficeInfoId()>0 && resobj.getResDamHealthId()>0    &&  resobj.getRemarks().length()>0 ){
						
					 List<Map<String, Object>> result = jdbcTemplate8.queryForList(sql2,resobj.getResInspectMst1Id() , resobj.getInspectOfficeInfoId() , resobj.getResDamHealthId());	
					 
 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedfreq = Integer.parseInt(row.get("res_dam_action_id").toString());
							}
					 }
 
 
              if(updatedfreq>0){
	 
            	 /* List<Map<String, Object>> result1= jdbcTemplate8.queryForList(sql4, new Object[]{resobj.getResInspectMst1Id() , resobj.getInspectOfficeInfoId(),resobj.getResDamHealthId()});
                  
					 if(result1!=null){
						 
						 for (Map<String, Object> row : result1) {
							 rows1=Integer.parseInt(row.get("res_dam_action_id").toString()); ;
							}
					 }*/
            	  
            	  rows1=-2;
	 
            }
					 
				 }
				 
				 if(updatedfreq<1){
			
					 if( resobj.getResInspectMst1Id()>0   && resobj.getInspectOfficeInfoId()>0 && resobj.getResDamHealthId()>0 &&  resobj.getRemarks().length()>0 ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getResInspectMst1Id(),resobj.getResDamHealthId(),resobj.getActionTakeninit(),resobj.getRemarks(),resobj.getDesignationId(),
								  resobj.getUserName(),resobj.getEmpId(), resobj.getInspectOfficeInfoId(),resobj.getResannRecommendId(),resobj.getActionTakencomplete());	
						
				}
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public Integer AddDamInspectphotosInfo(final DamInspectDocs damobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = INSERT_RES_DAM_INSPECT_PHOTOS;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(damobj!=null){
				 
				 
				 
				 if( damobj.getResInspectMst1Id()>0   && damobj.getInspectOfficeInfoId()>0  ){
						
					
 
           
				
			
					 if( damobj.getResInspectMst1Id()>0   && damobj.getInspectOfficeInfoId()>0  ){
						 rows1 = jdbcTemplate8.update(sql3,damobj.getResInspectMst1Id(),damobj.getInspectOfficeInfoId(),damobj.getDamDocOriginalName(),damobj.getDamDocName(),damobj.getDamDocLocation(),
								 damobj.getUserName(),damobj.getDamTitle());	
						
				}
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer insertDamDocuments(final ReservoirInspect resdocObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql2 = INSERT_DAM_INSPECT_DOCUMENTS;
				
		

		Integer rows1 = 0;
		int[] j = null;
		Integer filerows=0;
		
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			
			if(resdocObj.getDaminspectphotoList()!=null){
		
            
				
					if( resdocObj.getResInspectMst1Id()!=null && resdocObj.getInspectOfficeInfoId()!=null && resdocObj.getDaminspectphotoList().get(0).getDamDocName()!=null || resdocObj.getDaminspectphotoList().get(0).getDamDocName()!=" " ){
					j = jdbcTemplate8.batchUpdate(sql2,		new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {

									DamInspectDocs sd = resdocObj.getDaminspectphotoList().get(i);
								
									  ps.setInt(1,  resdocObj.getResInspectMst1Id());
									  ps.setInt(2,  resdocObj.getInspectOfficeInfoId());
										ps.setString(3, sd.getDamDocOriginalName());
										ps.setString(4, sd.getDamDocName());
									ps.setString(5, sd.getDamDocLocation());
									
									 ps.setString(6,  resdocObj.getUserName());
									 ps.setString(7,  resdocObj.getDocTitle());
									 
									 ps.setLong(8,  resdocObj.getPostId());
									
								}

								@Override
								public int getBatchSize() {
									return resdocObj.getDaminspectphotoList().size();
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
			
                
				jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public Integer insertPrevDamDocuments(final ReservoirInspect resdocObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql2 = INSERT_PREV_DAM_INSPECT_DOCUMENTS;
				
		

		Integer rows1 = 0;
		int[] j = null;
		Integer filerows=0;
		
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resdocObj!=null){
				 
				 
				 
				 if( resdocObj.getResInspectMst1Id()>0   ){
						
					

          
				
			
					 if( resdocObj.getResInspectMst1Id()>0  &&  resdocObj.getPrevResInspectMst1Id()>0 ){
						 rows1 = jdbcTemplate8.update(sql2,resdocObj.getResInspectMst1Id(),
								 resdocObj.getUserName(),resdocObj.getPrevResInspectMst1Id());	
						
				}
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;

		
	}
	
	
	@Override
	public List<ReservoirInspect> getResDamInspectRemarksByReservoirId(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_DAM_MST1_REMARKS ;
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<ReservoirInspect> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getReservoirId(),resObj.getYear(),resObj.getDutyFrequencyId(),resObj.getTankId() },
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
	public List<ReservoirInspect> getResDamInspectRemarksByMst1Id(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_DAM_MST1_REMARKS_BYMST1ID ;
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
	public List<ReservoirInspect> getResDamInspectRemarksByReviewId(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_DAM_MST1_REMARKS_BY_REVIEWID ;
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<ReservoirInspect> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getResRemarksMst1ReviewId() },
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
	public List<DamInspectDocs> getDamInspectPhotosByReservoirId(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_DAM_INSPECT_PHOTOS ;
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<DamInspectDocs> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getReservoirId(),resObj.getYear(),resObj.getDutyFrequencyId(),resObj.getTankId() },
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
							resinspect.setPostId(rs.getLong(10));
							
							
							
							
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
	public List<ReservoirSalient> getresDamInfo(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_RES_DAM_INFO ;
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<ReservoirSalient> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getReservoirId() },
					new RowMapper<ReservoirSalient>() {

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirSalient resinspect = new ReservoirSalient();
							
							 // System.out.println("result"+rs.getInt(1));
							
							resinspect.setReservoirId(rs.getInt(1));				
							resinspect.setResName(rs.getString(2));
							resinspect.setTypeOfDamId(rs.getInt(3));
							resinspect.setOwnerOfDam(rs.getString(4));
							resinspect.setDamOperator(rs.getString(5));
							resinspect.setCommisionDate(rs.getString(6));
							resinspect.setHazardClassId(rs.getInt(7));
							resinspect.setDamPurposeId(rs.getInt(8));
							resinspect.setChangeFlag(rs.getBoolean(9));
						
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
	public List<ReservoirSalient> getresImpControlLevelInfo(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_RES_IMP_LEVELS_INFO ;
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<ReservoirSalient> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getReservoirId() },
					new RowMapper<ReservoirSalient>() {

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirSalient resinspect = new ReservoirSalient();
							
							 // System.out.println("result"+rs.getInt(1));
							
							resinspect.setReservoirId(rs.getInt(1));				
							resinspect.setResName(rs.getString(2));
							resinspect.setDeepestfoundationLevel(rs.getDouble(3));
							resinspect.setFrlLevel(rs.getDouble(4));
							resinspect.setGrossStorageatFrl(rs.getDouble(5));
							resinspect.setMwlLevel(rs.getDouble(6));
							resinspect.setMddlLevel(rs.getDouble(7));
							resinspect.setLiveStorageabovemddl(rs.getDouble(8));
							resinspect.setDeadStoragebelowmddl(rs.getDouble(9));
							resinspect.setMaxfloodDischarge(rs.getDouble(10));
							resinspect.setRes_lat_d(rs.getDouble(11));
							resinspect.setRes_lat_m(rs.getDouble(12));
							resinspect.setRes_lat_s(rs.getDouble(13));
							resinspect.setRes_long_d(rs.getDouble(14));
							resinspect.setRes_long_m(rs.getDouble(15));
							resinspect.setRes_long_s(rs.getDouble(16));
							resinspect.setChangeFlag(rs.getBoolean(17));
							resinspect.setTrlLevel(rs.getDouble(18));
							resinspect.setSpillWayCrestLevel(rs.getDouble(19));
							resinspect.setLowestRiverBed(rs.getDouble(20));
							
							resinspect.setTypeOfDamId(rs.getInt(21));
						
							resinspect.setCommisionDate(rs.getString(22));
							resinspect.setHazardClassId(rs.getInt(23));
							resinspect.setDamPurposeId(rs.getInt(24));
							resinspect.setChangeFlag(rs.getBoolean(25));
							
							Double reslatd=rs.getDouble(11);
							Double reslatm=rs.getDouble(12);
							Double reslats=rs.getDouble(13);
							String lat=reslatd.toString()+"-"+reslatm.toString()+"-"+reslats.toString();
							resinspect.setResLatitude(lat);
							
							Double reslogd=rs.getDouble(14);
							Double reslogm=rs.getDouble(15);
							Double reslogs=rs.getDouble(16);
							
							String longitude=reslogd.toString()+"-"+reslogm.toString()+"-"+reslogs.toString();
							resinspect.setResLongitude(longitude);
							
							
							
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
	public List<ReservoirSalient> getresDaminfoandControlLevelInfo(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		
		String sql = GET_RES_DAMINF_LEVELS_INFO ;
			
		//	System.out.println("GET_RES_DAMINF_LEVELS_INFO"+GET_RES_DAMINF_LEVELS_INFO);
			
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<ReservoirSalient> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{ resObj.getResInspectMst1Id() },
					new RowMapper<ReservoirSalient>() {

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirSalient resinspect = new ReservoirSalient();
							
							 // System.out.println("result"+rs.getInt(1));
							
							resinspect.setReservoirId(rs.getInt(1));				
							resinspect.setResName(rs.getString(2));
							
							if(rs.getInt(3)==1){
							resinspect.setTypeOfDam("Earthen");
							}else if(rs.getInt(3)==2){
								resinspect.setTypeOfDam("Composite");
								
							}else if (rs.getInt(3)==3){
								
								resinspect.setTypeOfDam("Concrete / Masonry");
							}
							//resinspect.setOwnerOfDam(rs.getString(4));
							//resinspect.setDamOperator(rs.getString(5));
							resinspect.setCommisionDate(rs.getString(4));
							
							if(rs.getInt(5)==1){
							resinspect.setHazardClass("High hazard Dam");	
							}else if (rs.getInt(5)==2){
								
								resinspect.setHazardClass("Significant hazard Dam");
							}
                               else if (rs.getInt(5)==3){
								
								resinspect.setHazardClass("Low hazard Dam");
							}
							resinspect.setDeepestfoundationLevel(rs.getDouble(6));
							resinspect.setFrlLevel(rs.getDouble(7));
							resinspect.setGrossStorageatFrl(rs.getDouble(8));
							resinspect.setMwlLevel(rs.getDouble(9));
							resinspect.setMddlLevel(rs.getDouble(10));
							resinspect.setLiveStorageabovemddl(rs.getDouble(11));
							resinspect.setDeadStoragebelowmddl(rs.getDouble(12));
							resinspect.setMaxfloodDischarge(rs.getDouble(13));
							resinspect.setRes_lat_d(rs.getDouble(14));
							resinspect.setRes_lat_m(rs.getDouble(15));
							resinspect.setRes_lat_s(rs.getDouble(16));
							resinspect.setRes_long_d(rs.getDouble(17));
							resinspect.setRes_long_m(rs.getDouble(18));
							resinspect.setRes_long_s(rs.getDouble(19));
							resinspect.setChangeFlag(rs.getBoolean(20));
							resinspect.setTrlLevel(rs.getDouble(21));
							resinspect.setSpillWayCrestLevel(rs.getDouble(22));
							resinspect.setLowestRiverBed(rs.getDouble(23));
							resinspect.setNrldCode(rs.getString(24));
							resinspect.setDistrictId(rs.getInt(25));
							resinspect.setMandalId(rs.getInt(26));
							resinspect.setVillageId(rs.getInt(27));
							resinspect.setDistrictName(rs.getString(28));
							resinspect.setMandalName(rs.getString(29));
							if(rs.getInt(27)>0){
							resinspect.setVillageName(rs.getString(30));
							}else if (rs.getInt(27)==0){
								resinspect.setVillageName(rs.getString(31));
								
							}
							resinspect.setResAnn1Insmst1(rs.getInt(32));
							
							resinspect.setFreqOperation(rs.getInt(33));
							if(rs.getInt(33)==9){
							resinspect.setFreqoperationName("Pre Monsoon");
							}
							if(rs.getInt(33)==10){
								resinspect.setFreqoperationName("Post Monsoon");
								}
							resinspect.setYear(rs.getInt(34));
							
							resinspect.setConditionofDamId(rs.getInt(35));
							if(rs.getInt(35)==1){
							resinspect.setTotalDamCondition("Unsatisfactory");
							}
							if(rs.getInt(35)==2){
								resinspect.setTotalDamCondition("Poor");
								}
							if(rs.getInt(35)==3){
								resinspect.setTotalDamCondition("Fair");
								}
							if(rs.getInt(35)==4){
								resinspect.setTotalDamCondition("Satisfactory");
								}
							
							if(rs.getInt(36)==1){
							resinspect.setDamPurpose("Irrigation");
							}
							else if(rs.getInt(36)==2){
								
								resinspect.setDamPurpose("Multipurpose");	
							}
							//System.out.println("rs.getInt(36)"+rs.getInt(36));
							
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
	public List<ReservoirSalient> getresDamSalientInfo(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		
		String sql = GET_RES_DAMSAL_INFO ;
			
			//System.out.println("GET_RES_DAMSAL_INFO"+GET_RES_DAMSAL_INFO+"resObj.getReservoirId()"+resObj.getReservoirId());
			
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<ReservoirSalient> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{ resObj.getReservoirId() },
					new RowMapper<ReservoirSalient>() {

						public ReservoirSalient mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							ReservoirSalient resinspect = new ReservoirSalient();
							
							 
							
							
							resinspect.setReservoirId(rs.getInt(1));				
							resinspect.setResName(rs.getString(2));	
							 
							resinspect.setEmergencyActionShared(rs.getString(3));
							resinspect.setEmergencyActionPlanPreparedId(rs.getInt(4));
							resinspect.setDisaster_manage_prepared(rs.getString(5));
							
							resinspect.setDamretrofitMeausreAdopted(rs.getString(6));
							
							resinspect.setDamRetrofitTime(rs.getString(7));
							
							resinspect.setDamRetrofitStatus(rs.getString(8));
							
							resinspect.setDamFoundSafe(rs.getString(9));
							
							resinspect.setPeakWaterLeakage(rs.getDouble(10));
							
							
							resinspect.setLostPercentageReservoirCapacity(rs.getDouble(11));
							resinspect.setOanMManualPreparedTime(rs.getString(12));
							resinspect.setOanMManualPreparedId(rs.getInt(13));
							
							
							resinspect.setGalleryDryStatus(rs.getString(14));
							resinspect.setGalleryElevation(rs.getString(15));
							resinspect.setUnusualDamDesignId(rs.getInt(16));
						
							 
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
							resinspect.setStructuralSafetyPerformedId(rs.getInt(27));
							
							 
							resinspect.setReservoirSiltedId(rs.getInt(28));
							resinspect.setGateOperationMethodId(rs.getInt(29));
							resinspect.setGrossCapacityMwl(rs.getDouble(30));
							
							resinspect.setResgatesize(rs.getString(31));
							resinspect.setResgatenumber(rs.getString(32));
							
							resinspect.setDamGalleryNumber(rs.getString(33));
							
							resinspect.setDamGateNumberFine(rs.getInt(34));
							
							resinspect.setCapacityactivestorage(rs.getDouble(35));
						
							
							
							
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
	public List<Tanks> getTankDamSalientInfo(MiTankInspect tankObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		
		String sql = GET_TANK_DAMSAL_INFO ;
			
			//System.out.println("GET_RES_DAMSAL_INFO"+GET_RES_DAMSAL_INFO+"resObj.getReservoirId()"+resObj.getReservoirId());
			
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<Tanks> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{ tankObj.getTankId() },
					new RowMapper<Tanks>() {

						public Tanks mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Tanks resinspect = new Tanks();
							
							 
							
							
							resinspect.setTankId(rs.getLong(1));				
							resinspect.setTankName(rs.getString(2));	
							 
							resinspect.setEmergencyActionShared(rs.getString(3));
							resinspect.setEmergencyActionPlanPreparedId(rs.getInt(4));
							resinspect.setDisaster_manage_prepared(rs.getString(5));
							
							resinspect.setDamretrofitMeausreAdopted(rs.getString(6));
							
							resinspect.setDamRetrofitTime(rs.getString(7));
							
							resinspect.setDamRetrofitStatus(rs.getString(8));
							
							resinspect.setDamFoundSafe(rs.getString(9));
							
							resinspect.setPeakWaterLeakage(rs.getDouble(10));
							
							
							resinspect.setLostPercentageReservoirCapacity(rs.getDouble(11));
							resinspect.setOanMManualPreparedTime(rs.getString(12));
							resinspect.setOanMManualPreparedId(rs.getInt(13));
							
							
							resinspect.setGalleryDryStatus(rs.getString(14));
							resinspect.setGalleryElevation(rs.getString(15));
							resinspect.setUnusualDamDesignId(rs.getInt(16));
						
							 
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
							resinspect.setStructuralSafetyPerformedId(rs.getInt(27));
							
							 
							resinspect.setReservoirSiltedId(rs.getInt(28));
							resinspect.setGateOperationMethodId(rs.getInt(29));
							resinspect.setGrossCapacityMwl(rs.getDouble(30));
							
							resinspect.setResgatesize(rs.getString(31));
							resinspect.setResgatenumber(rs.getString(32));
							
							resinspect.setDamGalleryNumber(rs.getString(33));
							
							resinspect.setDamGateNumberFine(rs.getInt(34));
							
							resinspect.setCapacityactivestorage(rs.getDouble(35));
						
							
							
							
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
	public List<Tanks> getTankinfoandControlLevelInfo(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		
		String sql = GET_TANK_DAMINF_LEVELS_INFO ;
			
		//	System.out.println("GET_RES_DAMINF_LEVELS_INFO"+GET_RES_DAMINF_LEVELS_INFO);
			
		try {
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<Tanks> tankinflist = jdbcTemplate8.query(sql,new Object[]{ resObj.getResInspectMst1Id() },
					new RowMapper<Tanks>() {

						public Tanks mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							//ReservoirSalient resinspect = new ReservoirSalient();
							
							 // System.out.println("result"+rs.getInt(1));
							
							Tanks  tanksinspect = new Tanks();
							
							 // System.out.println("result"+rs.getInt(1));
							
							tanksinspect.setTankId(rs.getLong(1));
							tanksinspect.setTankName(rs.getString(2));
							if(rs.getInt(3)==1){
								tanksinspect.setTypeOfDam("Earthen");
								}else if(rs.getInt(3)==2){
									tanksinspect.setTypeOfDam("Composite");
									
								}else if (rs.getInt(3)==3){
									
									tanksinspect.setTypeOfDam("Concrete / Masonry");
								}
							tanksinspect.setOwnerOfDam(rs.getString(4));
							tanksinspect.setDamOperator(rs.getString(5));
							tanksinspect.setCommisionDate(rs.getString(6));
							if(rs.getInt(7)==1){
								tanksinspect.setHazardClass("High hazard Dam");	
								}else if (rs.getInt(7)==2){
									
									tanksinspect.setHazardClass("Significant hazard Dam");
								}
	                               else if (rs.getInt(7)==3){
									
	                            	   tanksinspect.setHazardClass("Low hazard Dam");
								}					
							tanksinspect.setTrlLevel(rs.getDouble(8));
							tanksinspect.setMwlLevel(rs.getDouble(9));
							tanksinspect.setFrlLevel(rs.getDouble(10));
							tanksinspect.setSpillWayCrestLevel(rs.getDouble(11));
							tanksinspect.setMddlLevel(rs.getDouble(12));
							tanksinspect.setLowestRiverBed(rs.getDouble(13));
							tanksinspect.setDeepestfoundationLevel(rs.getDouble(14));
							tanksinspect.setGrossStorageatFrl(rs.getDouble(15));
							
							tanksinspect.setNrldCode(rs.getString(16));
							tanksinspect.setDistrictId(rs.getInt(17));
							tanksinspect.setMandalId(rs.getInt(18));
							tanksinspect.setVillageId(rs.getInt(19));
							tanksinspect.setDistrictName(rs.getString(20));
							tanksinspect.setMandalName(rs.getString(21));
							tanksinspect.setVillageName(rs.getString(22));
							
							tanksinspect.setResAnn1Insmst1(rs.getInt(23));
							
							tanksinspect.setFreqOperation(rs.getInt(24));
							if(rs.getInt(24)==9){
								tanksinspect.setFreqoperationName("Pre Monsoon");
							}
							if(rs.getInt(24)==10){
								tanksinspect.setFreqoperationName("Post Monsoon");
								}
							tanksinspect.setYear(rs.getInt(25));
							
							tanksinspect.setConditionofDamId(rs.getInt(26));
							if(rs.getInt(26)==1){
								tanksinspect.setTotalDamCondition("Unsatisfactory");
							}
							if(rs.getInt(26)==2){
								tanksinspect.setTotalDamCondition("Poor");
								}
							if(rs.getInt(26)==3){
								tanksinspect.setTotalDamCondition("Fair");
								}
							if(rs.getInt(26)==4){
								tanksinspect.setTotalDamCondition("Satisfactory");
								}
							
							if(rs.getInt(27)==1){
								tanksinspect.setDamPurpose("Irrigation");
								}
								else if(rs.getInt(27)==2){
									
									tanksinspect.setDamPurpose("Multipurpose");	
								}
							
							tanksinspect.setLatitude(rs.getString(28));
							
							tanksinspect.setLongitude(rs.getString(29));
							
							 String latnumber = rs.getString(28);
							 
							 String longnumber=rs.getString(29);

						     String[] outputlat = latnumber.split("-");
						     
						     String[] outputlong = longnumber.split("-");
						     
						     tanksinspect.setLatdegree(Double.parseDouble(outputlat[0]));
						     tanksinspect.setLatminutes(Double.parseDouble(outputlat[1]));
						     tanksinspect.setLatseconds(Double.parseDouble(outputlat[2]));
						     tanksinspect.setLongdegree(Double.parseDouble(outputlong[0]));
						     tanksinspect.setLongminutes(Double.parseDouble(outputlong[1]));
						     tanksinspect.setLongseconds(Double.parseDouble(outputlong[2]));
							
							
							return tanksinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return tankinflist;
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
	public List<Tanks> getTanksDaminfo(MiTankInspect tankObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_TANK_DAM_INFO ;
		try {
			
			//System.out.println("sql"+sql);
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<Tanks> tankslist = jdbcTemplate8.query(sql,new Object[]{tankObj.getTankId() },
					new RowMapper<Tanks>() {

						public Tanks mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Tanks  tanksinspect = new Tanks();
							
							 // System.out.println("result"+rs.getInt(1));
							
							tanksinspect.setTankId(rs.getLong(1));
							tanksinspect.setTankName(rs.getString(2));
							tanksinspect.setTypeOfDam(rs.getString(3));
							tanksinspect.setOwnerOfDam(rs.getString(4));
							tanksinspect.setDamOperator(rs.getString(5));
							tanksinspect.setCommisionDate(rs.getString(6));
							tanksinspect.setHazardClass(rs.getString(7));
							
							
							
							
							return tanksinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return tankslist;
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
	public List<Tanks> getTanksImpControlinfo(MiTankInspect tankObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_TANK_IMP_CONTROL ;
		try {
			
			//System.out.println("sql"+sql);
  //System.out.println("sql"+resObj.getReservoirId()+resObj.getYear()+resObj.getConditionofDamId());
			List<Tanks> tankslist = jdbcTemplate8.query(sql,new Object[]{tankObj.getTankId() },
					new RowMapper<Tanks>() {

						public Tanks mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Tanks  tanksinspect = new Tanks();
							
							 // System.out.println("result"+rs.getInt(1));
							
							tanksinspect.setTankId(rs.getLong(1));
							tanksinspect.setTrlLevel(rs.getDouble(2));
							tanksinspect.setMwlLevel(rs.getDouble(3));
							tanksinspect.setFrlLevel(rs.getDouble(4));
							tanksinspect.setSpillWayCrestLevel(rs.getDouble(5));
							tanksinspect.setMddlLevel(rs.getDouble(6));
							tanksinspect.setLowestRiverBed(rs.getDouble(7));
							tanksinspect.setDeepestfoundationLevel(rs.getDouble(8));
							tanksinspect.setPreworkCapacity(rs.getDouble(9));
							
							
							tanksinspect.setTankName(rs.getString(10));
							tanksinspect.setTypeOfDamId(rs.getInt(11));
							
							tanksinspect.setCommisionDate(rs.getString(12));
							tanksinspect.setHazardClassId(rs.getInt(13));
							
							tanksinspect.setDamPurposeId(rs.getInt(14));
							
							
							return tanksinspect;
						}

					});
			jdbcTemplate8.getDataSource().getConnection().close();

			return tankslist;
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
	public Integer updateTankDemoInfo(final Tanks tankobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_DEMO_INFO;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(tankobj!=null){
				 
					if ( tankobj.getCommisionDate()!= null
							) {
					
						
							try {
								date1 = DateUtil.getSQLDate( tankobj.getCommisionDate());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				 
				 
				 
				 if( tankobj.getTankId()>0   && tankobj.getTypeOfDam().length()>0  ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,tankobj.getTypeOfDam(),tankobj.getOwnerOfDam(),tankobj.getDamOperator(),date1,tankobj.getHazardClass(),
								 tankobj.getTankId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateTankImpControlInfo(final Tanks tankobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_IMP_CONTROL_LEVELS;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(tankobj!=null){
				 
				 if ( tankobj.getCommisionDate()!= null
							) {
					
						
							try {
								date1 = DateUtil.getSQLDate( tankobj.getCommisionDate());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				 
				 
				 if( tankobj.getTankId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,tankobj.getTrlLevel(),tankobj.getMwlLevel(),tankobj.getFrlLevel(),tankobj.getSpillWayCrestLevel(),tankobj.getMddlLevel(),
								 tankobj.getLowestRiverBed(), tankobj.getDeepestfoundationLevel(),tankobj.getGrossStorageatFrl(), tankobj.getTypeOfDamId(),date1,tankobj.getHazardClassId(),
								 tankobj.getDamPurposeId(),  tankobj.getUserName() ,tankobj.getTankId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateResDemoInfo(final ReservoirSalient resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_RES_DEMO_INFO;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
					if ( resobj.getCommisionDate()!= null
							) {
					
						
							try {
								date1 = DateUtil.getSQLDate( resobj.getCommisionDate());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				 
				 
				 
				 if( resobj.getReservoirId()>0   && resobj.getTypeOfDamId()>0  ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,resobj.getTypeOfDamId(),resobj.getOwnerOfDam(),date1,resobj.getHazardClassId(),resobj.getDamOperator(),resobj.getDamPurposeId(),
								 resobj.getReservoirId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer updateResImpControlInfo(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_RES_IMP_CONTROL_LEVELS;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				 
				 if ( resObj.getCommisionDate()!= null
							) {
					
						
							try {
								date1 = DateUtil.getSQLDate( resObj.getCommisionDate());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				 
				
				 
				 
				 if( resObj.getReservoirId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,resObj.getTrlLevel(),resObj.getMwlLevel(),resObj.getFrlLevel(),resObj.getMddlLevel(),resObj.getSpillWayCrestLevel(),
								 resObj.getLowestRiverBed(), resObj.getDeepestfoundationLevel(),resObj.getGrossStorageatFrl(),resObj.getTypeOfDamId(),date1,resObj.getHazardClassId(),resObj.getDamPurposeId(),
								 resObj.getUserName(),resObj.getRes_lat_d(),resObj.getRes_lat_m(),resObj.getRes_lat_s(), resObj.getRes_long_d(), resObj.getRes_long_m(), resObj.getRes_long_s(), resObj.getReservoirId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	@Override
	public Integer updateResSalientInfo9(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_RES_SAL_INFO9;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				
				
				 
				 
				 if( resObj.getReservoirId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,resObj.getEmergencyActionShared(),resObj.getEmergencyActionPlanPreparedId(),resObj.getUserName(), resObj.getReservoirId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateTankSalientInfo9(Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_SAL_INFO9;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(tankObj!=null){
				
				
				 
				 
				 if( tankObj.getTankId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,tankObj.getEmergencyActionShared(),tankObj.getEmergencyActionPlanPreparedId(),tankObj.getUserName(), tankObj.getTankId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public Integer updateResSalientInfo8(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_RES_SAL_INFO8;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				
				
				 
				 
				 if( resObj.getReservoirId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,resObj.getDamBreakAnalysisId(),resObj.getDisaster_manage_prepared(),resObj.getUserName(), resObj.getReservoirId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateTankSalientInfo8(final Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_SAL_INFO8;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(tankObj!=null){
				
				
				 
				 
				 if( tankObj.getTankId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,tankObj.getDamBreakAnalysisId(),tankObj.getDisaster_manage_prepared(),tankObj.getUserName(), tankObj.getTankId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer updateResSalientInfo7(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_RES_SAL_INFO7;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				
				
				 
				 
				 if( resObj.getReservoirId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,resObj.getStructuralSafetyPerformedId(),resObj.getDamFoundSafe(),resObj.getDamRetrofitStatus(),resObj.getDamRetrofitTime(),resObj.getDamretrofitMeausreAdopted(),resObj.getUserName(), resObj.getReservoirId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public Integer updateTankSalientInfo7(final Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_SAL_INFO7;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(tankObj!=null){
				
				
				 
				 
				 if( tankObj.getTankId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,tankObj.getStructuralSafetyPerformedId(),tankObj.getDamFoundSafe(),tankObj.getDamRetrofitStatus(),tankObj.getDamRetrofitTime(),tankObj.getDamretrofitMeausreAdopted(),tankObj.getUserName(), tankObj.getTankId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateResSalientInfo5(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_RES_SAL_INFO5;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				
				
				 
				 
				 if( resObj.getReservoirId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,resObj.getReservoirSiltedId(),resObj.getLostPercentageReservoirCapacity(),resObj.getPeakWaterLeakage(),resObj.getUserName(), resObj.getReservoirId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateTankSalientInfo5(final Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_SAL_INFO5;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(tankObj!=null){
				
				
				 
				 
				 if( tankObj.getTankId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,tankObj.getReservoirSiltedId(),tankObj.getLostPercentageReservoirCapacity(),tankObj.getPeakWaterLeakage(),tankObj.getUserName(), tankObj.getTankId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateResSalientInfo4(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_RES_SAL_INFO4;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				
				
				 
				 
				 if( resObj.getReservoirId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,resObj.getOanMManualPreparedId(),resObj.getOanMManualPreparedTime(),resObj.getUserName(), resObj.getReservoirId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateTankSalientInfo4(final Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_SAL_INFO4;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(tankObj!=null){
				
				
				 
				 
				 if( tankObj.getTankId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,tankObj.getOanMManualPreparedId(),tankObj.getOanMManualPreparedTime(),tankObj.getUserName(), tankObj.getTankId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateResSalientInfo3(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_RES_SAL_INFO3;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				
				
				 
				 
				 if( resObj.getReservoirId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,resObj.getGateOperationMethodId(),resObj.getResgatesize(),resObj.getResgatenumber(),resObj.getDamGateNumberFine(),resObj.getUserName(), resObj.getReservoirId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateTankSalientInfo3(final Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_SAL_INFO3;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(tankObj!=null){
				
				
				 
				 
				 if( tankObj.getTankId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,tankObj.getGateOperationMethodId(),tankObj.getResgatesize(),tankObj.getResgatenumber(),tankObj.getDamGateNumberFine(),tankObj.getUserName(), tankObj.getTankId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateResSalientInfo2(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_RES_SAL_INFO2;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				
				
				 
				 
				 if( resObj.getReservoirId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,resObj.getDamGalleryNumber(),resObj.getGalleryElevation(),resObj.getGalleryDryStatus(),resObj.getUserName(), resObj.getReservoirId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateTankSalientInfo2(final Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_SAL_INFO2;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(tankObj!=null){
				
				
				 
				 
				 if( tankObj.getTankId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,tankObj.getDamGalleryNumber(),tankObj.getGalleryElevation(),tankObj.getGalleryDryStatus(),tankObj.getUserName(), tankObj.getTankId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateResSalientInfo1(final ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_RES_SAL_INFO1;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resObj!=null){
				
				
				 
				 
				 if( resObj.getReservoirId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,resObj.getSalientheightdfl(),resObj.getSalientlengthcrest(),resObj.getSalientbottomwidth(),resObj.getSalienttopwidth(),
								 resObj.getGrossCapacityMwl(),resObj.getCapacitydeadstorage(),resObj.getMfddesignflood(),resObj.getMfdobservedflood(),resObj.getSpecialDifficultFoundationIssues(),resObj.getUnusualDamDesignId(),resObj.getUnusualDamDesigndetails()   ,resObj.getUserName(),resObj.getCapacityactivestorage(), resObj.getReservoirId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer updateTankSalientInfo1(final Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_TANK_SAL_INFO1;	
		
		
		
		
		
		
		
Integer rows1=0;
Integer updatedfreq=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("resobj.getInspectDate()1"+resobj.getInspectDate());
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(tankObj!=null){
				
				
				 
				 
				 if( tankObj.getTankId()>0     ){
						
					
						 rows1 = jdbcTemplate8.update(sql3,tankObj.getSalientheightdfl(),tankObj.getSalientlengthcrest(),tankObj.getSalientbottomwidth(),tankObj.getSalienttopwidth(),
								 tankObj.getGrossCapacityMwl(),tankObj.getCapacitydeadstorage(),tankObj.getMfddesignflood(),tankObj.getMfdobservedflood(),tankObj.getSpecialDifficultFoundationIssues(),tankObj.getUnusualDamDesignId(),tankObj.getUnusualDamDesigndetails()   ,tankObj.getUserName(),tankObj.getCapacityactivestorage(), tankObj.getTankId());	
						
				
				}
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	@Override
	public Integer updateDamConditionStatus(final ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_DAM_CONDITION_STATUS;		 
	
Integer rows1=0;

		java.sql.Date date1 = null;
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
		//	 System.out.println("miObj.getUnitId()"+miObj.getUnitId());
			 if(resObj!=null){
			
				 if( resObj.getResInspectMst1Id()!=null  ){
						// System.out.println("in dao"+miObj.getActionrequireqId());
						 List<Map<String, Object>> result2  = jdbcTemplate8.queryForList(sql3,resObj.getUserName(),resObj.getConditionofDamId(),resObj.getResInspectMst1Id());
						/* List<Map<String, Object>> result2  = jdbcTemplate8.queryForList(sql3,miObj.getUserId(),miObj.getUserName(),miObj.getTankStatusId(),miObj.getUnitId(),miObj.getCircleId(),
								 miObj.getDivisionId(),miObj.getSubdivisionId(),miObj.getMiInpsectMst1Id());	*/
				 
						    if(result2!=null){
								 
								 for (Map<String, Object> row : result2) {
									 rows1=Integer.parseInt(row.get("condition_dam_id").toString());
									}
								 
							//	 System.out.println("rows1: "+rows1);
							 }
				}
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public Integer deleteAnnRemarksReviewId(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_ANN_REMARKS_REVIEWID;		 
		
Integer rows1=0;

		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
             	
				
					 if( resobj.getResRemarksMst1ReviewId()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),resobj.getResRemarksMst1ReviewId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer deleteAnnMst2byMst2Id(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_ANN_MST2_MST2ID;		 
		
Integer rows1=0;

		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
             	
				
					 if( resobj.getResInspectMst2Id()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),resobj.getResInspectMst2Id());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	
	@Override
	public Integer deleteAnnRecommendationbyRecommendId(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_ANN_RECOMMEND_RECID;		 
		
Integer rows1=0;

		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
             	
				
					 if( resobj.getResRecommendId()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),resobj.getResRecommendId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer deleteResAnnDocs(final DamInspectDocs resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_RES_ANN_DOCS;		 
		
         Integer rows1=0;

		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
             	
				
					 if( resobj.getDamdocId()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),resobj.getDamdocId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer deleteResHealthDetails(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_RES_HEALTH_ID;		 
		
Integer rows1=0;

		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
             	
				
					 if( resobj.getResDamHealthId()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),resobj.getResDamHealthId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	@Override
	public Integer deleteResInspectInfoDetails(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_RES_INSPECT_INFO_ID;		 
		
Integer rows1=0;

		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
             	
				
					 if( resobj.getResinspectInfoId()!=null ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),resobj.getResinspectInfoId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer deleteResActionTakeninfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_RES_ACTION_INFO_ID;	
		
		//System.out.println(DELETE_FRM_DOCS_DOCID);
		
Integer rows1=0;

		try {
			
			//System.out.println("miformObj.getFormdocId()"+miformObj.getFormdocId()+"---"+miformObj.getUserName());

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
             	
				 //System.out.println("coming here"+miformObj.getFormdocId()+"---"+miformObj.getUserName());
					 if( resobj.getResDamActionId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),resobj.getResDamActionId());	
				
				}
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	@Override
	public Integer UpdateNrldDamRemarksinfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_NRLD_DAM_REMARKS_INFO;		 
		
		 
		
		
		
Integer rows1=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("sql2"+sql2);
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				 if(resobj.getInspectDate()!=null){
					 
						try {
							
							//System.out.println("resobj.getInspectDate()2"+resobj.getInspectDate());
							
							date1 = DateUtil.getSQLDate(resobj.getInspectDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				 }
             	
				
			
					 if( resobj.getResRemarksMst1ReviewId() !=null   ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),
								resobj.getRemarks(),resobj.getInspectOfficeInfoId(),
								 resobj.getRemarksinclindoc(),
								 resobj.getResRemarksMst1ReviewId()  );	
						
				}
					 
					 
					/* resobj.getInchargeofAnn1(),
					 resobj.getPreDaminspecteddata(),resobj.getItemsInspected(),resobj.getItemsInspectedReason(),
					 resobj.getVigandWatchProvided(),resobj.getVigandwatchreason(),resobj.getObsAnn2(),*/
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public List<ReservoirInspect> getResAnnRecomndbytankresyear(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_RES_ANN_RECOMMEND_BY_RES_TANK_YEAR ;
		try {
			
			//System.out.println("sql"+sql);
			
			//System.out.println("resObj.getDutyFrequencyId()"+resObj.getDutyFrequencyId());
			//System.out.println("resObj.getYear()"+resObj.getYear());
			//System.out.println("resObj.getReservoirId()"+resObj.getReservoirId());
			//System.out.println("resObj.getTankId()"+resObj.getTankId());

			List<ReservoirInspect> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getDutyFrequencyId(),resObj.getYear(),resObj.getReservoirId(),resObj.getTankId() },
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
							resinspect.setIsLatest(rs.getBoolean(8));
							resinspect.setPostId(rs.getLong(9));
							resinspect.setInspectDate(rs.getString(10));
							resinspect.setCreateDate(rs.getString(11));
							
							
							
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
	public List<ReservoirInspect> getResAnnRecomndbyRecId(ReservoirInspect resObj) throws InventoryUserException {
		// SELECT_FINANCIAL_YEAR
		String sql = GET_RES_ANN_RECOMMEND_BY_RECOMMENDID ;
		try {
			
			//System.out.println("sql"+sql);
			
			//System.out.println("resObj.getDutyFrequencyId()"+resObj.getDutyFrequencyId());
			//System.out.println("resObj.getYear()"+resObj.getYear());
			//System.out.println("resObj.getReservoirId()"+resObj.getReservoirId());
			//System.out.println("resObj.getTankId()"+resObj.getTankId());

			List<ReservoirInspect> resinspectrecommList = jdbcTemplate8.query(sql,new Object[]{resObj.getResannRecommendId() },
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
							resinspect.setIsLatest(rs.getBoolean(8));
							resinspect.setPostId(rs.getLong(9));
							resinspect.setInspectDate(rs.getString(10));
							resinspect.setCreateDate(rs.getString(11));
							
							
							
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
	public Integer UpdateNrldAnnRecommendationsinfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_NRLD_ANN_RECOMMENDATION_INFO;		 
		
		 
		
		
		
Integer rows1=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("sql2"+sql2);
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				
				
			
					 if( resobj.getResannRecommendId() !=null  && resobj.getInspectOfficeInfoId()!=null  ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getInspectOfficeInfoId(),resobj.getRemarks(),
								 resobj.getUserName(),								
								
								 resobj.getResannRecommendId()  );	
						
				}
					 
					 
					
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	@Override
	public Integer deleteNrldAnnRecommendationsinfo(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = DELETE_NRLD_ANN_RECOMMENDATION_INFO;		 
		
		 
		
		
		
Integer rows1=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("sql2"+sql2);
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				
				
			
					 if( resobj.getResannRecommendId() !=null   ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getUserName(),
								
								 resobj.getResannRecommendId()  );	
						
				}
					 
					 
					
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
	
	
	
	
	@Override
	public Integer updateActionTakenDetailsActionId(final ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		
		String sql3 = UPDATE_ACTION_TAKEN_DETAILS_ACTIONID;		 
		
		 
		
		
		
Integer rows1=0;
Integer rows2=0;

		
	
		
		java.sql.Date date1 = null;
		
		
		
		//System.out.println("sql2"+sql2);
	
		
		try {

			jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
			 if(resobj!=null){
				 
				
				
			
					 if( resobj.getResDamActionId() !=null   ){
						 rows1 = jdbcTemplate8.update(sql3,resobj.getResDamHealthId(),
								 resobj.getRemarks(), resobj.getUserName(),
								 resobj.getActionTakeninit(),
								 resobj.getInspectOfficeInfoId(),
								 resobj.getResannRecommendId(),
								 resobj.getActionTakencomplete(),
								 resobj.getResDamActionId()  );	
						
				}
					 
					 
					
			
			 
			 }
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows1;
	}
			
			
			@Override
			public Integer UpdateNrldAnnHealthinfo(final ReservoirInspect resobj) throws InventoryUserException {
				// TODO Auto-generated method stub
				
				String sql3 = UPDATE_NRLD_ANN_HEALTH_INFO;		 
				
				 
				
				
				
		Integer rows1=0;
		Integer rows2=0;

				
			
				
				java.sql.Date date1 = null;
				
				
				
				//System.out.println("sql2"+sql2);
			
				
				try {

					jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);
					 if(resobj!=null){
						 
						
						
					
							 if( resobj.getResDamHealthId() !=null  && resobj.getInspectOfficeInfoId()!=null  ){
								 rows1 = jdbcTemplate8.update(sql3,resobj.getRemarks(),resobj.getUserName(),
										 resobj.getInspectOfficeInfoId(),resobj.getDeficiencyCategory(),										
										
										 resobj.getResDamHealthId()  );	
								
						}
							 
							 
							
					
					 
					 }
					 

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return rows1;
			}
			
			@Override
			public List<Tanks> getTankSectionMapNrld(User user) throws InventoryUserException {
				
				//System.out.println(user.getCircleId()+"--"+user.getDivisionId()+"imp "+user.getSubdivisionId()+"--"+user.getSectionId());
				// TODO Auto-generated method stub
				String sql =null;
						
						if(user!=null){
							
							if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null && user.getPost()!=null && (user.getDesignationId()==2 || user.getDesignationId()==8)){
								if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0 && user.getPost()>0 ){
								
							   sql=	SECTION_TANK_MAPP_NRLD+" and ts.postid="+user.getPost() +"  order by district_name,mandal_name,vname,tank_name";
								}
								
								
							}
							
							if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null && user.getSubdivisionId()!=null  && user.getSectionId()==0 && user.getDesignationId()==4  ){
								if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()>0  ){
								
							   sql=	SECTION_TANK_MAPP_NRLD+"  and ts.division_id="+user.getDivisionId()+ " and ts.subdivision_id="+user.getSubdivisionId() +" order by district_name,mandal_name,vname,tank_name";
								}
								
								
							}
							
							if(user.getUnitId()!=null && user.getCircleId()!=null && user.getDivisionId()!=null  && user.getSubdivisionId()==0 &&  user.getSectionId()==0  ){
								if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 ){
								
							   sql=	SECTION_TANK_MAPP_NRLD+" and ts.division_id="+user.getDivisionId() + "  order by district_name,mandal_name,vname,tank_name";
								}
								
								
							}
							
							if(user.getUnitId()!=null && user.getCircleId()!=null && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0)   ){
								if(user.getUnitId()>0 && user.getCircleId()>0    ){
								
							   sql=	SECTION_TANK_MAPP_NRLD+" and ts.circle_id="+user.getCircleId() +"  order by district_name,mandal_name,vname,tank_name";
								}				
								
							}
							
							if(user.getUnitId()!=null && (user.getCircleId()==0) && (user.getDivisionId()==0)  && (user.getSubdivisionId()==0) && ( user.getSectionId()==0) ){
								if(user.getUnitId()>0 && user.getUnitId()!=9    ){
								
							   sql=SECTION_TANK_MAPP_NRLD+" and ts.unit_id="+user.getUnitId()+ "  order by district_name,mandal_name,vname,tank_name";
								}
								
								if(((user.getUnitId()==9) && ( user.getPost()==83125 || user.getPost()==83213 ||  user.getPost()==83266   ))){
									
									   sql=SECTION_TANK_MAPP_NRLD+"  order by district_name,mandal_name,vname,tank_name";
										}
								
							}
							
						}
						
						
						;
			//	System.out.println("sql"+sql);
			
				
				//"select  reservoir_code, reservoir_name from  inventory.reservoirs where delete_flag=false and is_latest=true and reservoir_code='"+rescode.replace("\"", "")+"'" ;
				try {
					List<Tanks> tankList = jdbcTemplate8.query(sql ,new Object[]{},
							new RowMapper<Tanks>() {
						
					
								public Tanks mapRow(ResultSet rs, int rowNum)
										throws SQLException {
			
									
									
							//	System.out.println("impl"+rs.getString(1));
									Tanks tanks = new Tanks();
									
									tanks.setTankId(rs.getLong(1));
									tanks.setNewDistrictId(rs.getInt(2));
									tanks.setMandalId(rs.getInt(3));
									tanks.setVillageId(rs.getInt(4));
									tanks.setHabitationId(rs.getInt(5));
									tanks.setAcCode(rs.getInt(6));
									tanks.setTankCode(rs.getLong(7));
									tanks.setUnitId(rs.getInt(8));
									tanks.setCircleId(rs.getInt(9));
									tanks.setDivisionId(rs.getInt(10));
									tanks.setSubdivisionId(rs.getInt(11));
									tanks.setSectionId(rs.getInt(12));
									tanks.setTankName(rs.getString(13));
									tanks.setDistrictName(rs.getString(14));
									tanks.setMandalName(rs.getString(15));
									tanks.setVillageName(rs.getString(16));
									tanks.setHabitationName(rs.getString(17));
									tanks.setConstName(rs.getString(18));
									tanks.setSourceId(rs.getInt(19));
									tanks.setIsNrld(rs.getBoolean(20));
									tanks.setNrldCode(rs.getString(21));
									
									
									
									
									
									return tanks;
								}

							});
					
					// System.out.println("sql"+sql);
					jdbcTemplate8.getDataSource().getConnection().close();
					
				//	System.out.println("impl2"+ReservoirSalientList);
					return tankList;
				} catch (Exception exc) {
					
					return null;
				}
			}
			
			
		
			
			@Override
			public Integer UpdateResNrldCode(final ReservoirSalient resObj) throws InventoryUserException {
				// TODO Auto-generated method stub

				String sql = UPDATE_NRLD_CODE;

			   

				

				Integer rows = 0;

				try {
					if (resObj != null) {

						jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

						 rows = jdbcTemplate8.update(sql,resObj.getNrldCode(),resObj.getReservoirId());

						
						

						
					

						 jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{ 
				
					try {
						
						jdbcTemplate8.getDataSource().getConnection().close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}

				return rows;
			}
			
			
			@Override
			public List<ReservoirInspect> getResPostEmpId(ReservoirInspect resObj) throws InventoryUserException {
				// TODO Auto-generated method stub
				
				//System.out.println("coming here");
				
				String sql=GET_RES_POST_EMP;
				
				try {
					
					List<ReservoirInspect>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getReservoirId()},
							new RowMapper<ReservoirInspect>() {

								public ReservoirInspect mapRow(ResultSet rs, int rowNum)
										throws SQLException {

									ReservoirInspect    resinfo = new ReservoirInspect();
									
									resinfo.setResUnitProjMapId(rs.getInt(1));
									resinfo.setUnitId(rs.getInt(2));
									resinfo.setCircleId(rs.getInt(3));
									resinfo.setDivisionId(rs.getInt(4));
									resinfo.setSubdivisionId(rs.getInt(5));
									resinfo.setReservoirId(rs.getInt(6));
									resinfo.setProjectId(rs.getInt(7));
									resinfo.setPostId(rs.getLong(8));
									resinfo.setSectionId(rs.getInt(9));
									resinfo.setUnitName(rs.getString(10));
									resinfo.setCircleName(rs.getString(11));
									resinfo.setDivisionName(rs.getString(12));
									resinfo.setSubdivisionName(rs.getString(13));
									resinfo.setResName(rs.getString(14));
									resinfo.setPostName(rs.getString(15));
									resinfo.setEmpName(rs.getString(16));
									
									
								
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
			public Integer deleteRespostaccess(final ReservoirInspect resObj) throws InventoryUserException {
				// TODO Auto-generated method stub

				String sql = DELETE_RES_POST_ACCESS;

			   

				

				Integer rows = 0;

				try {
					if (resObj != null) {

						jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

						 rows = jdbcTemplate8.update(sql,resObj.getResUnitProjMapId());

						
						

						
					

						 jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{ 
				
					try {
						
						jdbcTemplate8.getDataSource().getConnection().close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}

				return rows;
			}
			
			
			@Override
			public Integer insertRespostaccess(final ReservoirInspect resObj) throws InventoryUserException {
				// TODO Auto-generated method stub

				String sql = INSERT_RES_POST_ACCESS;

			   

				

				Integer rows = 0;

				try {
					if (resObj != null) {

						jdbcTemplate8.getDataSource().getConnection().setAutoCommit(false);

						 rows = jdbcTemplate8.update(sql,resObj.getUnitId(),
								 resObj.getCircleId(),
								 resObj.getDivisionId(),
								 resObj.getSubdivisionId(),
								 resObj.getReservoirId(),
								 resObj.getProjectId(),
								 resObj.getPostId(),
								 resObj.getSectionId()
								 );

						
						

						
					

						 jdbcTemplate8.getDataSource().getConnection().setAutoCommit(true);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{ 
				
					try {
						
						jdbcTemplate8.getDataSource().getConnection().close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}

				return rows;
			}
			
			
			
			@Override
			public List<Employee> getempdatabyoffice(ReservoirInspect resObj) throws InventoryUserException {
				// TODO Auto-generated method stub
				
				//System.out.println("coming here");
				
				String sql=EMP_DATA_BY_UNIT_CI_DI_SUB;
				
				try {
					
					List<Employee>   reslist = jdbcTemplate8.query(sql ,new Object[] { resObj.getUnitId(),resObj.getCircleId(),resObj.getDivisionId(),resObj.getSubdivisionId()},
							new RowMapper<Employee>() {

								public Employee mapRow(ResultSet rs, int rowNum)
										throws SQLException {

									Employee    empinfo = new Employee();
									
									empinfo.setPostId(rs.getLong(1));
									empinfo.setEmpId(rs.getInt(2));
									empinfo.setPostName(rs.getString(3));
									empinfo.setUnitId(rs.getInt(4));
									empinfo.setCircleId(rs.getInt(5));
									empinfo.setDivisionId(rs.getInt(6));
									empinfo.setSubdivisionId(rs.getInt(7));
									
									String empname=rs.getString(3)+"@"+rs.getString(8);
									empinfo.setEmployeeName(empname);
									empinfo.setDesignationId(rs.getInt(9));
									
									
								
									return empinfo;
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
			public List<MiTankformData> getRepeatedTankResCanalBreachList() throws InventoryUserException {
				// TODO Auto-generated method stub
				
				//System.out.println("coming here");
				
				String sql=GET_TANK_RES_CANAL_REPEATED_BREACH;
				
				
				
				try {
					
					
					
					List<MiTankformData>   frmsrclist = jdbcTemplate8.query(sql ,new Object[] {},
							new RowMapper<MiTankformData>() {

								public MiTankformData mapRow(ResultSet rs, int rowNum)
										throws SQLException {

									MiTankformData    frmsrc = new MiTankformData();
									
									
									
									frmsrc.setTotalTankCount(rs.getInt(1));
									frmsrc.setRepeatedTankId(rs.getInt(2));								
									frmsrc.setRepeatedTankName(rs.getString(3));
									frmsrc.setRepeatedCatId(rs.getInt(4));
									
									
									
									
								
									return frmsrc;
								}

							});
					jdbcTemplate8.getDataSource().getConnection().close();
					
				//	System.out.println("miinflowoutflow"+miinflowoutflow);
					return frmsrclist;
						
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
			public List<MiTankformData> getRepeatedTankResCanalLDamageist() throws InventoryUserException {
				// TODO Auto-generated method stub
				
				//System.out.println("coming here");
				
				String sql=GET_TANK_RES_CANAL_REPEATED_DAMAGE;
				
				
				
				try {
					
					
					
					List<MiTankformData>   frmsrclist = jdbcTemplate8.query(sql ,new Object[] {},
							new RowMapper<MiTankformData>() {

								public MiTankformData mapRow(ResultSet rs, int rowNum)
										throws SQLException {

									MiTankformData    frmsrc = new MiTankformData();
									
									
									
									frmsrc.setTotalTankCount(rs.getInt(1));
									frmsrc.setRepeatedTankId(rs.getInt(2));								
									frmsrc.setRepeatedTankName(rs.getString(3));
									frmsrc.setRepeatedCatId(rs.getInt(4));
									
									
									
									
								
									return frmsrc;
								}

							});
					jdbcTemplate8.getDataSource().getConnection().close();
					
				//	System.out.println("miinflowoutflow"+miinflowoutflow);
					return frmsrclist;
						
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
			
			
}



