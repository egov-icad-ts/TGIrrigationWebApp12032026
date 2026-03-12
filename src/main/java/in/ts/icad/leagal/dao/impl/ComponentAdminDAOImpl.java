package in.ts.icad.leagal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ts.icad.leagal.dao.ComponentAdminDAO;
import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.model.CadAyacutKmlDocs;
import in.ts.icad.leagal.model.CompInfo;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.ComponentAyacut;
import in.ts.icad.leagal.model.ComponentPower;
import in.ts.icad.leagal.model.Constituency;
import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.PowerBill;
import in.ts.icad.leagal.model.Pumpmotor;
import in.ts.icad.leagal.model.Task;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.util.DateUtil;

@Repository
public class ComponentAdminDAOImpl implements ComponentAdminDAO {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private final boolean IS_DEBUG_ENABLED = log.isDebugEnabled();

	private JdbcTemplate jdbcTemplate;
	private JdbcTemplate jdbcTemplate4;

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Resource(name = "dataSource4")
	public void setDataSource4(DataSource dataSource4) {
		this.jdbcTemplate4 = new JdbcTemplate(dataSource4);
	}

	/*private JdbcTemplate jdbcHrmsTemplate;

	@Resource(name = "dataSource1")
	public void setDataSource1(DataSource dataSource) {
		this.jdbcHrmsTemplate = new JdbcTemplate(dataSource);
	}*/

	@Value("${INSERT_COMPONENTS_COMPS}")
	private String INSERT_COMPONENTS_COMPS;

	@Value("${INSERT_COMP_PROJECT_PACK}")
	private String INSERT_COMP_PROJECT_PACK;

	@Value("${SELECT_COMP_PARENTLEN}")
	private String SELECT_COMP_PARENTLEN;

	@Value("${SELECT_PARENT_LIST}")
	private String SELECT_PARENT_LIST;

	@Value("${SELECT_COMP_PKG}")
	private String SELECT_COMP_PKG;

	@Value("${SELECT_COMP_PARENT}")
	private String SELECT_COMP_PARENT;

	@Value("${SELECT_PUMP_MAKE}")
	private String SELECT_PUMP_MAKE;

	@Value("${SELECT_MOTOR_MAKE}")
	private String SELECT_MOTOR_MAKE;

	@Value("${SELECT_MOTOR_TYPE}")
	private String SELECT_MOTOR_TYPE;

	@Value("${SELECT_PUMP_TYPE}")
	private String SELECT_PUMP_TYPE;

	@Value("${INSERT_COMP_POWER_AYACUT_DATA}")
	private String INSERT_COMP_POWER_AYACUT_DATA;

	@Value("${INSERT_COMP_INFO}")
	private String INSERT_COMP_INFO;

	@Value("${SELECT_PGDELAY}")
	private String SELECT_PGDELAY;

	@Value("${INSERT_COMP_MON_POWER}")
	private String INSERT_COMP_MON_POWER;

	@Value("${INSERT_COMP_MON_AYACUT}")
	private String INSERT_COMP_MON_AYACUT;

	@Value("${SELECT_COMP_EDITORDEL}")
	private String SELECT_COMP_EDITORDEL;

	@Value("${DELETE_COMPONENT}")
	private String DELETE_COMPONENT;

	@Value("${SELECT_COMP_EDIT}")
	private String SELECT_COMP_EDIT;

	@Value("${UPDATE_COMP_MAP}")
	private String UPDATE_COMP_MAP;

	@Value("${UPDATE_COMP_COMP}")
	private String UPDATE_COMP_COMP;

	@Value("${EDIT_NUMER_COMP}")
	private String EDIT_NUMER_COMP;

	@Value("${EDIT_NUMER_COMPMAP}")
	private String EDIT_NUMER_COMPMAP;

	@Value("${SELECT_COMP_MON_POWER_EDIT}")
	private String SELECT_COMP_MON_POWER_EDIT;

	@Value("${DELETE_COMP_MON_POWER}")
	private String DELETE_COMP_MON_POWER;

	@Value("${SELECT_COMP_MON_POWERID}")
	private String SELECT_COMP_MON_POWERID;

	@Value("${SELECT_COMP_MON_AYACUT_DEL}")
	private String SELECT_COMP_MON_AYACUT_DEL;

	@Value("${DELETE_COMP_MON_AYACUT}")
	private String DELETE_COMP_MON_AYACUT;

	@Value("${SELECT_COMP_MON_AYACUT_EDIT}")
	private String SELECT_COMP_MON_AYACUT_EDIT;

	@Value("${UPDATE_COMP_MON_POWER}")
	private String UPDATE_COMP_MON_POWER;

	@Value("${UPDATE_COMP_MON_AYACUT}")
	private String UPDATE_COMP_MON_AYACUT;

	@Value("${SELECT_COMP_INPUT_P_A_DEL}")
	private String SELECT_COMP_INPUT_P_A_DEL;

	@Value("${SELECT_MOTOR_COMP_INPUT}")
	private String SELECT_MOTOR_COMP_INPUT;

	@Value("${SELECT_PUMP_COMP_INPUT}")
	private String SELECT_PUMP_COMP_INPUT;

	@Value("${DELETE_COMP_INFO_BYPA}")
	private String DELETE_COMP_INFO_BYPA;

	@Value("${DELETE_COMP_POW_AYACUT}")
	private String DELETE_COMP_POW_AYACUT;

	@Value("${DELETE_COMP_INFO_BYID}")
	private String DELETE_COMP_INFO_BYID;
	
	@Value("${SELECT_COMP_POWERAYACUTINFO_EDIT}")
	private String SELECT_COMP_POWERAYACUTINFO_EDIT;
	
	@Value("${SELECT_COMP_INFO_EDIT}")
	private String SELECT_COMP_INFO_EDIT;
	
	@Value("${UPDATE_COMP_POWER_AYACUT}")
	private String UPDATE_COMP_POWER_AYACUT;
	
	@Value("${UPDATE_COMP_POWER_INFO}")
	private String UPDATE_COMP_POWER_INFO;
	
	
	
	@Value("${SELECT_COMP_PSCAPACITY}")
	private String SELECT_COMP_PSCAPACITY;
	
	@Value("${SELECT_STAGE}")
	private String SELECT_STAGE;
	
	@Value("${SELECT_PHASE}")
	private String SELECT_PHASE;
	@Value("${SELECT_COMP_TYPE}")
	private String SELECT_COMP_TYPE;
	@Value("${INSERT_PACKS}")
	private String INSERT_PACKS;
	@Value("${UPDATE_CONST_MST}")
	private String UPDATE_CONST_MST;
	@Value("${UPDATE_MANDAL_CONST}")
	private String UPDATE_MANDAL_CONST;
	@Value("${UPDATE_VILLAGE_CONST}")
	private String UPDATE_VILLAGE_CONST;
	@Value("${SELECT_CONST_MST}")
	private String SELECT_CONST_MST;
	@Value("${INSERT_PROJ_AYACUT}")
	private String INSERT_PROJ_AYACUT;
	
	@Value("${SELECT_CONST_NAME}")
	private String SELECT_CONST_NAME;
	
	@Value("${SELECT_PROJ_PACKSNEW}")
	private String SELECT_PROJ_PACKSNEW;
	
	@Value("${SELECT_PROJ_AYACUT_DELETE}")
	private String SELECT_PROJ_AYACUT_DELETE;
	
	@Value("${DELETE_PROJECT_AYACUT}")
	private String DELETE_PROJECT_AYACUT;
	
	@Value("${SELECT_PROJ_AYACUT_EDIT}")
	private String SELECT_PROJ_AYACUT_EDIT;
	
	@Value("${EDIT_PROJ_AYACUT}")
	private String EDIT_PROJ_AYACUT;
	
	@Value("${EDIT_PACKS}")
	private String EDIT_PACKS;
	
	@Value("${EDIT_DISTRICT_MAST}")
	private String EDIT_DISTRICT_MAST;
	
	@Value("${INSERT_CONST_DIST_MAP}")
	private String INSERT_CONST_DIST_MAP;
	
	@Value("${UPDATE_CONST_DIST_MAP}")
	private String UPDATE_CONST_DIST_MAP;
	
	
	@Value("${SELECT_CONST_MST_BYOLDDIST}")
	private String SELECT_CONST_MST_BYOLDDIST;
	
	@Value("${SELECT_COMP_PUMPS}")
	private String SELECT_COMP_PUMPS;
	
	@Value("${INSERT_DAILY_INPUT}")
	private String INSERT_DAILY_INPUT;
	
	
	@Value("${INSERT_COMP_INFONEW}")
	private String INSERT_COMP_INFONEW;
	
	
	
	
	@Value("${SELECT_COMP_DAILY_INFO}")
	private String SELECT_COMP_DAILY_INFO;
	
	
	@Value("${SELECT_COMP_LIST}")
	private String SELECT_COMP_LIST;
	
	@Value("${DELETE_COMP_DAILYINPUT}")
	private String DELETE_COMP_DAILYINPUT;
	
	
	@Value("${SELECT_DAILY_EDITINFO}")
	private String SELECT_DAILY_EDITINFO;
	
	
	@Value("${UPDATE_COMP_DAILY_INPUT}")
	private String UPDATE_COMP_DAILY_INPUT;
	
	@Value("${INSERT_COMP_DISCHARGE}")
	private String INSERT_COMP_DISCHARGE;
	
	@Value("${SELECT_COMP_DISCHARGE}")
	private String SELECT_COMP_DISCHARGE;
	
	@Value("${SELECT_COMP_EDIT_DISCHARGE}")
	private String SELECT_COMP_EDIT_DISCHARGE;
	
	@Value("${EDIT_COMP_DISCHRAGE}")
	private String EDIT_COMP_DISCHRAGE;
	
	@Value("${DELETE_COMP_DISCHARGE}")
	private String DELETE_COMP_DISCHARGE;
	
	@Value("${INSERT_COMP_POWER_BILL}")
	private String INSERT_COMP_POWER_BILL;
	
	@Value("${GET_DOC_NUM}")
	private String GET_DOC_NUM;
	
	@Value("${SELECT_POWER_BILL_DELETE}")
	private String SELECT_POWER_BILL_DELETE;
	
	
	@Value("${DELETE_COMP_POWER_BILL}")
	private String DELETE_COMP_POWER_BILL;
	
	@Value("${SELECT_POWER_BILL_EDIT}")
	private String SELECT_POWER_BILL_EDIT;
	
	@Value("${UPDATE_COMP_POWER_BILL}")
	private String UPDATE_COMP_POWER_BILL;
	
	@Value("${SELECT_PROJ_AYCT_MAN_DAT}")
	private String SELECT_PROJ_AYCT_MAN_DAT;
	
	
	
	@Value("${INSERT_PROJ_SEASON_CAP}")
	private String INSERT_PROJ_SEASON_CAP;
	
	@Value("${GET_COUNT_PROJ_SEASON_CAP}")
	private String GET_COUNT_PROJ_SEASON_CAP;
	
	@Value("${GET_PROJ_SEASON_CAP_ID}")
	private String GET_PROJ_SEASON_CAP_ID;
	
	
	@Value("${GET_PROJ_SEASON_CAP_EDIT}")
	private String GET_PROJ_SEASON_CAP_EDIT;
	
	@Value("${UPDATE_PROJ_SEASON_CAP}")
	private String UPDATE_PROJ_SEASON_CAP;
	
	@Value("${DELETE_PROJ_SEASON_CAP}")
	private String DELETE_PROJ_SEASON_CAP;
	
	
	@Value("${INSERT_PROJ_SEASON_AYACUT}")
	private String INSERT_PROJ_SEASON_AYACUT;
	
	@Value("${GET_COUNT_PROJ_SEASON_AYACUT}")
	private String GET_COUNT_PROJ_SEASON_AYACUT;
	

	
	
	@Value("${GET_PROJ_SEASON_AYACUT_EDIT}")
	private String GET_PROJ_SEASON_AYACUT_EDIT;
	
	@Value("${UPDATE_PROJ_SEASON_AYACUT}")
	private String UPDATE_PROJ_SEASON_AYACUT;
	
	@Value("${DELETE_PROJ_SEASON_AYACUT}")
	private String DELETE_PROJ_SEASON_AYACUT;
	
	@Value("${GET_PROJ_SEASON_AYACUT_ID}")
	private String GET_PROJ_SEASON_AYACUT_ID;
	
	@Value("${GET_PROJ_SEASON_CAP_INFO}")
	private String GET_PROJ_SEASON_CAP_INFO;
	
	@Value("${GET_PROJ_SEASON_AYACUT_INFO}")
	private String GET_PROJ_SEASON_AYACUT_INFO;
	
	@Value("${COUNT_CADKML_DOCS}")
	private String COUNT_CADKML_DOCS;
	
	@Value("${INSERT_CADKML_DOCUMENTS}")
	private String INSERT_CADKML_DOCUMENTS;
	
	@Value("${DELETE_CADKML_ID}")
	private String DELETE_CADKML_ID;
	
	@Value("${SELECT_CADKML_BY_UNIT}")
	private String SELECT_CADKML_BY_UNIT;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public Integer insertComponents(final Component compObject) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_COMPONENTS_COMPS;

	     String sql1 = INSERT_COMP_PROJECT_PACK;

		Date date1 = null;
		Date date2 = null;

		Integer packrows = 0;

		Integer componentId = 0;
		try {
			if (compObject != null) {

				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

				List<Map<String, Object>> rows = jdbcTemplate4.queryForList(sql, compObject.getComponentName(),
						 compObject.getParentComponentId(), compObject.getLevelId(),
						compObject.getComponentCategoryId(), compObject.getOfftakeChainage(),
						compObject.getComponentDirection(), compObject.getComponentLength(), compObject.getFromKm(),
						compObject.getToKm(), compObject.getUserId(),  compObject.getProjectId(),
						compObject.getDischrgecusecs(), compObject.getPipediameter(), compObject.getPmlength(),
						compObject.getNoofpiperows(), compObject.getLiftStatic(), compObject.getLiftDynamic(),
						compObject.getTotalLift(), compObject.getLiftperiod(), compObject.getLifttmc(),
						compObject.getMddlsign(), compObject.getDeliverylevelsign(), compObject.getEachmotorPower(),
						compObject.getTotalpower(), compObject.getAuxPower(), compObject.getTotalpowerwithAux(),
						compObject.getFromlocation(), compObject.getTolocation(), compObject.getStatusId(),
						compObject.getRemarks(), compObject.getSubstationHV(), compObject.getSubstationLV(),compObject.getUnitId());

				for (Map<String, Object> row : rows) {
					componentId = Integer.parseInt(row.get("component_id").toString());
				}

				final Integer id = componentId;

				// System.out.println("id"+id);

				if (componentId > 0) {

					compObject.setComponentId(componentId);

					if (compObject.getProjectId() != null && 
							 compObject.getComponentId() != null && compObject.getPackageId()!=null) {
						if (compObject.getProjectId() > 0) {

							packrows = jdbcTemplate4.update(sql1, compObject.getUnitId(),compObject.getComponentId(),
									compObject.getProjectId(), compObject.getPackageId(),
									compObject.getComponentCategoryId(), compObject.getUserId());

						}
					}

				}

				if (packrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return packrows;
	}

	@Override
	public Component getParentComponentLength(Integer compParentId) throws ComponentUserException {

		String sql = SELECT_COMP_PARENTLEN;

		try {
			Component comp = (Component) jdbcTemplate4.queryForObject(sql, new Object[] { compParentId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Component comp = new Component();
							comp.setComponentId(rs.getInt(1));
							comp.setComponentLength(rs.getDouble(2));
							comp.setFromKm(rs.getDouble(3));
							comp.setToKm(rs.getDouble(4));

							return comp;

						}

					});
			return comp;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentProgress method error due to " + ex.getMessage());
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
	public List<Component> getParentComponent(Integer projectId) throws ComponentUserException {

		String sql = SELECT_PARENT_LIST;
		try {
			List<Component> compList = jdbcTemplate4.query(sql, new Object[] { projectId }, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum) throws SQLException {
					Component comp = new Component();
					comp.setComponentId(rs.getInt(1));
					comp.setComponentName(rs.getString(2));

					return comp;

				}

			});
			return compList;

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
	public List<Packages> getCompPackage(Integer componentId) throws ComponentUserException {

		String sql = SELECT_COMP_PKG;
		try {
			List<Packages> packList = jdbcTemplate4.query(sql, new Object[] { componentId }, new RowMapper<Packages>() {
				public Packages mapRow(ResultSet rs, int rowNum) throws SQLException {
					Packages pack = new Packages();
					pack.setPkgId(rs.getInt(1));
					pack.setPkgName(rs.getString(2));

					return pack;

				}

			});
			return packList;

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
	public List<Component> getCompParent(Integer componentId) throws ComponentUserException {

		String sql = SELECT_COMP_PARENT;
		try {
			List<Component> compList = jdbcTemplate4.query(sql, new Object[] { componentId },
					new RowMapper<Component>() {
						public Component mapRow(ResultSet rs, int rowNum) throws SQLException {
							Component comp = new Component();
							comp.setComponentId(rs.getInt(1));
							comp.setComponentName(rs.getString(2));

							return comp;

						}

					});
			return compList;

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
	public List<Pumpmotor> getPumpMakeList() throws ComponentUserException {
		String sql = SELECT_PUMP_MAKE;
		try {
			List<Pumpmotor> pumpmotorList = jdbcTemplate4.query(sql, new RowMapper<Pumpmotor>() {
				public Pumpmotor mapRow(ResultSet rs, int rowNum) throws SQLException {

					Pumpmotor pm = new Pumpmotor();
					pm.setPumpmakeId(rs.getInt(1));
					pm.setPumpmakename(rs.getString(2));

					return pm;

				}

			});
			return pumpmotorList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getPumpMakeList method error due to " + ex.getMessage());
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
	public List<Pumpmotor> getPumpTypeList() throws ComponentUserException {
		String sql = SELECT_PUMP_TYPE;
		try {
			List<Pumpmotor> pumpmotorList = jdbcTemplate4.query(sql, new RowMapper<Pumpmotor>() {
				public Pumpmotor mapRow(ResultSet rs, int rowNum) throws SQLException {
					Pumpmotor pm = new Pumpmotor();
					pm.setPumptypeId(rs.getInt(1));
					pm.setPumptype(rs.getString(2));

					return pm;

				}

			});
			return pumpmotorList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getPumpTypeList method error due to " + ex.getMessage());
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
	public List<Pumpmotor> getMotorMakeList() throws ComponentUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_MOTOR_MAKE;
		try {
			List<Pumpmotor> pmList = jdbcTemplate4.query(sql, new RowMapper<Pumpmotor>() {
				public Pumpmotor mapRow(ResultSet rs, int rowNum) throws SQLException {
					Pumpmotor pm = new Pumpmotor();
					pm.setMotormakeId(rs.getInt(1));
					pm.setMotormakeName(rs.getString(2));

					return pm;

				}

			});
			return pmList;

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
	public List<Pumpmotor> getMotorTypeList() throws ComponentUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_MOTOR_TYPE;
		try {
			List<Pumpmotor> pmList = jdbcTemplate4.query(sql, new RowMapper<Pumpmotor>() {
				public Pumpmotor mapRow(ResultSet rs, int rowNum) throws SQLException {
					Pumpmotor pm = new Pumpmotor();
					pm.setMotortypeId(rs.getInt(1));
					pm.setMotortypeName(rs.getString(2));

					return pm;

				}

			});
			return pmList;

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
	public Integer insertComponentsMotorinfo(final Component compObject) throws ComponentUserException {

		String sql = INSERT_COMP_INFO;

		Integer rows = 0;

		int[] k = null;

		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (compObject.getMotorList().size() > 0) {
				k = jdbcTemplate4.batchUpdate(sql, new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {

						Component comp = compObject.getMotorList().get(i);

						ps.setInt(1, compObject.getComponentId());
						ps.setInt(2, 2);
						ps.setInt(3, compObject.getProjectId());
						ps.setInt(4, compObject.getMotorList().get(i).getMotorNumber());
						ps.setInt(5, compObject.getUserId());
						ps.setInt(6, compObject.getUserId());
						ps.setInt(7, compObject.getCompPackId());
						ps.setInt(8, compObject.getPhaseId());
						ps.setInt(9, compObject.getMotorList().get(i).getMotormakeId());
						ps.setInt(10, compObject.getMotorList().get(i).getMotortypeId());
						ps.setInt(11, compObject.getMotorList().get(i).getMotorstatusId());
						ps.setInt(12, compObject.getStageId());
						ps.setInt(13, compObject.getMotorList().get(i).getMotorcapacityId());
						ps.setDouble(14, compObject.getMotorList().get(i).getMotorconnectedLoad());
						ps.setString(15, "M");
						ps.setDouble(16, compObject.getMotorList().get(i).getMotoractualLoad());
						ps.setDouble(17, compObject.getMotorList().get(i).getMotorrpm());

					}

					@Override
					public int getBatchSize() {
						return compObject.getMotorList().size();
					}
				});

			}
			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
			rows = k.length;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}

	@Override
	public Integer insertComponentsPumpinfo(final Component compObject) throws ComponentUserException {

		String sql = INSERT_COMP_INFO;
		int[] j = null;
		Integer rows = 0;
		try {

			if (compObject != null) {

				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

				if (compObject.getPumpList().size() > 0) {
					j = jdbcTemplate4.batchUpdate(sql, new BatchPreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps, int i) throws SQLException {

							Component comp = compObject.getPumpList().get(i);

							
							/* * System.out.println("i" + i +
							 * compObject.getPumpList().get(i).getPumpNumber() +
							 * compObject.getPumpList().get(i).getPumptypeId() +
							 * compObject.getPumpList().get(i).getPumpstatusId()
							 * +
							 * compObject.getPumpList().get(i).getPumpcapacityId
							 * ());*/
							 
							ps.setInt(1, compObject.getComponentId());
							ps.setInt(2, 2);
							ps.setInt(3, compObject.getProjectId());
							ps.setInt(4, compObject.getPumpList().get(i).getPumpNumber());
							ps.setInt(5, compObject.getUserId());
							ps.setInt(6, compObject.getUserId());
							ps.setInt(7, compObject.getCompPackId());
							ps.setInt(8, compObject.getPhaseId());
							ps.setInt(9, compObject.getPumpList().get(i).getPumpmakeId());
							ps.setInt(10, compObject.getPumpList().get(i).getPumptypeId());
							ps.setInt(11, compObject.getPumpList().get(i).getPumpstatusId());
							ps.setInt(12, compObject.getStageId());
							ps.setInt(13, compObject.getPumpList().get(i).getPumpcapacityId());
							ps.setDouble(14, compObject.getPumpList().get(i).getPumpconnectedLoad());
							ps.setString(15, "P");
							ps.setDouble(16, compObject.getPumpList().get(i).getPumpactualLoad());
							ps.setDouble(17, compObject.getPumpList().get(i).getPumprpm());

						}

						@Override
						public int getBatchSize() {
							return compObject.getPumpList().size();
						}
					});
				}

				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
				rows = j.length;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	/*
	 * @Override public Integer insertComponentsAyacutData(final Component
	 * compObject) throws ComponentUserException {
	 * 
	 * String sql = INSERT_COMP_AYACUT_DATA; Integer rows1 = 0;
	 * 
	 * try {
	 * 
	 * jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false); if
	 * (compObject.getAyacutacres() != null) {
	 * 
	 * if (compObject.getProjectId() != null && compObject.getComponentId() !=
	 * null) { if (compObject.getProjectId() > 0) {
	 * 
	 * rows1 = jdbcTemplate4.update(sql, compObject.getComponentId(),
	 * compObject.getProjectId(), compObject.getCompPackId(),
	 * compObject.getAyacutacres(), compObject.getFinancialyear(),
	 * compObject.getUserId(), compObject.getUserId(), compObject.getStageId(),
	 * compObject.getPhaseId());
	 * 
	 * } }
	 * 
	 * } jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return rows1; }
	 */

	@Override
	public Integer insertComponentsPowerAyacutData(final Component compObject) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql1 = INSERT_COMP_POWER_AYACUT_DATA;

		Integer rows1 = 0;
		
		
		
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (compObject != null) {

				if (compObject.getAnnualpowerconsumption() != null) {

					if (compObject.getProjectId() != null && compObject.getComponentId() != null) {
						if (compObject.getProjectId() > 0) {

							rows1 = jdbcTemplate4.update(sql1, compObject.getComponentId(), compObject.getProjectId(),
									compObject.getCompPackId(), compObject.getStageId(), compObject.getPhaseId(),
									compObject.getAnnualpowerconsumption(), compObject.getUserId(),
									compObject.getUserId(), compObject.getFinancialyear(), compObject.getAyacutacres());
							
							
							

						}
					}

				}
							
							
							
							}

                
				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
				
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}

	@Override
	public Integer insertComponentMonthlyPowerConsumed(final ComponentPower cpObject) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql1 = INSERT_COMP_MON_POWER;

		Integer rows1 = 0;

		Date date1 = null;
		Date date2 = null;
		Date date3 = null;
		Date date4=null;
		Integer componentId = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (cpObject != null) {

				if (cpObject.getPowerConsumeMonth() != null && cpObject.getPowerConsumeMonth() != ""
						&& !cpObject.getPowerConsumeMonth().equals('0')) {

					date1 = DateUtil.getSQLDate(cpObject.getPowerConsumeMonth());

				}

				if (cpObject.getDueDate() != null && cpObject.getDueDate() != ""
						&& !cpObject.getDueDate().equals('0')) {
					date2 = DateUtil.getSQLDate(cpObject.getDueDate());
				}
				if (cpObject.getDisconnectionDate() != null && cpObject.getDisconnectionDate() != ""
						&& !cpObject.getDisconnectionDate().equals('0')) {
					date3 = DateUtil.getSQLDate(cpObject.getDisconnectionDate());
				}if(cpObject.getPaidDate() != null && cpObject.getPaidDate() != ""
						&& !cpObject.getPaidDate().equals('0')){
					
					
					date4=   DateUtil.getSQLDate(  cpObject.getPaidDate());
				}

				if (cpObject.getPresentunit() != null) {

					if (cpObject.getProjectId() != null && cpObject.getComponentId() != null) {
						if (cpObject.getProjectId() > 0) {

							rows1 = jdbcTemplate4.update(sql1, cpObject.getProjectId(), cpObject.getComponentId(),
									cpObject.getPresentunit(), cpObject.getFixedCharges(),
									cpObject.getNetBillCost(), date1, cpObject.getUserId(), cpObject.getRemarks(),
									cpObject.getPresentunit(), cpObject.getBillCost(), cpObject.getPenalityCharges(),
									cpObject.getAdditionalDeposit(), date2, date3,cpObject.getPaidAmount(),cpObject.getPendingAmount(),
									cpObject.getPaidStatusId(),date4,cpObject.getTotalAmount(),cpObject.getUnitId());

						}
					}

				}

				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}

	@Override
	public Integer insertComponentMonthlyAyacutCreated(final ComponentAyacut cpObject) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql1 = INSERT_COMP_MON_AYACUT;

		Integer rows1 = 0;

		Date date1 = null;
		Integer componentId = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (cpObject != null) {

				if (cpObject.getPresentAyacutmonth() != null && cpObject.getPresentAyacutmonth() != ""
						&& !cpObject.getPresentAyacutmonth().equals('0')) {

					//System.out.println("ayacutmonth" + cpObject.getPresentAyacutmonth());

					date1 = DateUtil.getSQLDate(cpObject.getPresentAyacutmonth());
				}

				if (cpObject.getPresentAyacutCreated() != null) {

					if (cpObject.getProjectId() != null && cpObject.getComponentId() != null) {
						if (cpObject.getProjectId() > 0) {

							rows1 = jdbcTemplate4.update(sql1, cpObject.getProjectId(), cpObject.getUserId(),
									cpObject.getComponentId(),cpObject.getRemarks(),date1, cpObject.getPresentAyacutCreated(), 
									
									cpObject.getPresentAyacutContemplated(), cpObject.getDistrictId(),
									 cpObject.getMandalId(), cpObject.getVillageId(),cpObject.getUnitId(),cpObject.getConstId());

						}
					}

				}

				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}

	@Override
	public List<Map<String, Object>> generalqueryforresult(String generalquery) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		int count = 0;
		try {
			if (generalquery.toLowerCase().contains("select")) {
				List<Map<String, Object>> result = jdbcTemplate4.queryForList(generalquery);
				for (Map<String, Object> row : result) {
					rs.add(row);
				}
			} else {

				count = jdbcTemplate4.update(generalquery);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", count);
				rs.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return rs;

	}

	@Override
	public List<Component> getCompdatfordeleteInfo(Integer projectId) throws ComponentUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_COMP_EDITORDEL;
		// final Integer pumprpm=500;

		try {
			List<Component> compList = jdbcTemplate4.query(sql, new Object[] { projectId }, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum) throws SQLException {
					Component comp = new Component();
					comp.setComponentId(rs.getInt(1));
					comp.setComponentName(rs.getString(2));
					//comp.setComponentDesc(rs.getString(3));
					comp.setParentComponentId(rs.getInt(3));
					comp.setLevelId(rs.getInt(4));
					comp.setComponentCategory(rs.getString(5));
					comp.setOfftakeChainage(rs.getDouble(6));
					comp.setComponentDirection(rs.getInt(7));
					comp.setComponentLength(rs.getDouble(8));
					comp.setFromKm(rs.getDouble(9));
					comp.setToKm(rs.getDouble(10));
					comp.setProjectId(rs.getInt(11));
					comp.setPackageId(rs.getInt(12));
					//comp.setDistrictId(rs.getInt(14));
				//	comp.setMandalId(rs.getInt(15));
					//comp.setVillageId(rs.getInt(16));
					comp.setDischrgecusecs(rs.getDouble(13));
					comp.setPipediameter(rs.getDouble(14));
					comp.setPmlength(rs.getDouble(15));
					comp.setNoofpiperows(rs.getInt(16));
					comp.setStaticlift(rs.getString(17));
					comp.setDynamiclift(rs.getString(18));
					comp.setTotalLift(rs.getDouble(19));
					comp.setLiftperiod(rs.getInt(20));
					comp.setLifttmc(rs.getDouble(21));
					comp.setMddlsign(rs.getString(22));
					comp.setDeliverylevelsign(rs.getString(23));
					comp.setEachmotorPower(rs.getDouble(24));
					comp.setTotalpower(rs.getDouble(25));
					comp.setAuxPower(rs.getDouble(26));
					comp.setTotalpowerwithAux(rs.getDouble(27));
					comp.setSubstationCapacity(rs.getString(28));
					comp.setFromlocation(rs.getString(29));
					comp.setTolocation(rs.getString(30));
					comp.setStatusId(rs.getInt(31));
					comp.setRemarks(rs.getString(32));
					comp.setStatus(rs.getString(33));
					comp.setComponentCategory(rs.getString(34));

					//comp.setDistrictName(rs.getString(39));
					comp.setProjectName(rs.getString(35));
					comp.setUnitId(rs.getInt(36));
					comp.setUnitName(rs.getString(37));

					return comp;

				}

			});
			return compList;

		} catch (Exception ex) {
			log.error("Inside getCompGoogleMapStatusInfo  method error due to " + ex.getMessage());
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
	public Integer deleteComponent(Integer componentId) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_COMPONENT;

		Integer rows1 = 0;

		Date date1 = null;

		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (componentId != null) {

				if (componentId > 0) {

					rows1 = jdbcTemplate4.update(sql1, componentId);

				}

				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}

	@Override
	public Component editcompinfo(Integer componentId) throws ComponentUserException {

		String sql = SELECT_COMP_EDIT;

		try {
			Component comp = (Component) jdbcTemplate4.queryForObject(sql, new Object[] { componentId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Component comp = new Component();
							comp.setComponentId(rs.getInt(1));
							comp.setComponentName(rs.getString(2));
							
							comp.setParentComponentId(rs.getInt(3));
							comp.setLevelId(rs.getInt(4));
							comp.setComponentCategoryId(Integer.parseInt(rs.getString(5)));
							comp.setOfftakeChainage(rs.getDouble(6));
							comp.setComponentDirection(rs.getInt(7));
							comp.setComponentLength(rs.getDouble(8));
							comp.setFromKm(rs.getDouble(9));
							comp.setToKm(rs.getDouble(10));
							comp.setProjectId(rs.getInt(11));
							comp.setPackageId(rs.getInt(12));
							
							comp.setDischrgecusecs(rs.getDouble(13));
							comp.setPipediameter(rs.getDouble(14));
							comp.setPmlength(rs.getDouble(15));
							comp.setNoofpiperows(rs.getInt(16));
							comp.setLiftStatic(Double.parseDouble(rs.getString(17)));
							comp.setLiftDynamic(Double.parseDouble(rs.getString(18)));
							comp.setTotalLift(rs.getDouble(19));
							comp.setLiftperiod(rs.getInt(20));
							comp.setLifttmc(rs.getDouble(21));
							comp.setMddlsign(rs.getString(22));
							comp.setDeliverylevelsign(rs.getString(23));
							comp.setEachmotorPower(rs.getDouble(24));
							comp.setTotalpower(rs.getDouble(25));
							comp.setAuxPower(rs.getDouble(26));
							comp.setTotalpowerwithAux(rs.getDouble(27));
							comp.setSubstationCapacity(rs.getString(28));
							comp.setFromlocation(rs.getString(29));
							comp.setTolocation(rs.getString(30));
							comp.setStatusId(rs.getInt(31));
							comp.setRemarks(rs.getString(32));
							comp.setStatus(rs.getString(33));
							comp.setComponentCategory(rs.getString(34));

							
							comp.setProjectName(rs.getString(35));
							comp.setUnitId(rs.getInt(36));
						
							comp.setSubstationHV(rs.getDouble(37));
							comp.setSubstationLV(rs.getDouble(38));
							comp.setCompPackId(rs.getInt(39));
						
							return comp;
                        
							
						}
						
						

					});
			return comp;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentProgress method error due to " + ex.getMessage());
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
	public Integer updateComponents(final Component compObject) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_COMP_COMP;

		String sql1 = UPDATE_COMP_MAP;

		String sql2 = EDIT_NUMER_COMP;

		String sql3 = EDIT_NUMER_COMPMAP;

		Integer packrows = 0;
		Integer comprows = 0;
		Integer editNum = 0;
		Integer editPackNum = 0;

		Integer componentId = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compObject != null) {

				List<Map<String, Object>> ct = jdbcTemplate4.queryForList(sql2,
						new Object[] { compObject.getComponentId() });

				for (Map<String, Object> row : ct) {
					editNum = Integer.parseInt(row.get("edit_number").toString());
				}

				Integer editno = editNum + 1;

				comprows = jdbcTemplate4.update(sql, compObject.getComponentName(),
						compObject.getParentComponentId(), compObject.getLevelId(), compObject.getComponentCategoryId(),
						compObject.getOfftakeChainage(), compObject.getComponentDirection(),
						compObject.getComponentLength(), compObject.getFromKm(), compObject.getToKm(),
						compObject.getUserId(), editno, compObject.getProjectId(), 
						compObject.getFromlocation(), compObject.getDischrgecusecs(), compObject.getPipediameter(),
						compObject.getPmlength(), compObject.getNoofpiperows(), compObject.getLiftStatic(),
						compObject.getLiftDynamic(), compObject.getTotalLift(), compObject.getLiftperiod(),
						compObject.getLifttmc(), compObject.getMddlsign(), compObject.getDeliverylevelsign(),
						compObject.getEachmotorPower(), compObject.getTotalpower(), compObject.getAuxPower(),
						compObject.getTotalpowerwithAux(), compObject.getFromlocation(), compObject.getTolocation(),
						compObject.getStatusId(), compObject.getRemarks(), compObject.getSubstationHV(),
						compObject.getSubstationLV(), compObject.getComponentId());

				if (comprows > 0) {

					if (compObject.getComponentId() != null && compObject.getCompPackId() != null) {

						if (compObject.getComponentId() > 0 && compObject.getCompPackId() > 0) {

							if (compObject.getProjectId() > 0) {

								List<Map<String, Object>> packt = jdbcTemplate4.queryForList(sql3,
										new Object[] { compObject.getCompPackId() });

								for (Map<String, Object> row : packt) {
									editNum = Integer.parseInt(row.get("edit_number").toString());
								}

								Integer editpackno = editPackNum + 1;

								packrows = jdbcTemplate4.update(sql1, compObject.getComponentId(),
										compObject.getProjectId(), compObject.getPackageId(),
										compObject.getComponentCategoryId(), compObject.getUserId(), editpackno,
										compObject.getUnitId(),
										compObject.getCompPackId());

							}
						}

					}

				}

				if (comprows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return comprows;
	}

	@Override
	public List<ComponentPower> getComponentMonthlyPower(Integer projectId) throws ComponentUserException {

		String sql = SELECT_COMP_MON_POWER_EDIT;
		try {
			List<ComponentPower> compList = jdbcTemplate4.query(sql, new Object[] { projectId },
					new RowMapper<ComponentPower>() {
						public ComponentPower mapRow(ResultSet rs, int rowNum) throws SQLException {
							ComponentPower comp = new ComponentPower();
							comp.setComponentPowerId(rs.getInt(1));
							comp.setProjectId(rs.getInt(2));
							comp.setComponentId(rs.getInt(3));
							comp.setTotalUnitsConsumed(rs.getDouble(4));
							comp.setFixedCharges(rs.getDouble(5));
							comp.setNetBillCost(rs.getDouble(6));
							comp.setPowerConsumeMonth(rs.getString(7));
							comp.setRemarks(rs.getString(8));
							comp.setPresentunit(rs.getDouble(9));
							comp.setBillCost(rs.getDouble(10));
							comp.setPenalityCharges(rs.getDouble(11));
							comp.setAdditionalDeposit(rs.getDouble(12));
							comp.setDueDate(rs.getString(13));
							comp.setDisconnectionDate(rs.getString(14));
							comp.setComponentName(rs.getString(15));
							comp.setProjectName(rs.getString(16));
							comp.setUnitName(rs.getString(17));

							return comp;

						}

					});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentMonthlyPower method error due to " + ex.getMessage());
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
	public Integer deleteCompMonPower(Integer componentPowerId) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_COMP_MON_POWER;

		Integer rows1 = 0;

		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (componentPowerId != null) {

				if (componentPowerId > 0) {

					rows1 = jdbcTemplate4.update(sql1, componentPowerId);

				}

				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}

	@Override
	public ComponentPower editcompPowerinfo(Integer compPowerId) throws ComponentUserException {

		String sql = SELECT_COMP_MON_POWERID;

		final Double preunit = 0.0;
		try {
			ComponentPower comp = (ComponentPower) jdbcTemplate4.queryForObject(sql, new Object[] { compPowerId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							ComponentPower comp = new ComponentPower();
							comp.setComponentPowerId(rs.getInt(1));
							comp.setProjectId(rs.getInt(2));
							comp.setComponentId(rs.getInt(3));
							comp.setTotalUnitsConsumed(rs.getDouble(4));
							comp.setFixedCharges(rs.getDouble(5));
							comp.setNetBillCost(rs.getDouble(6));
							comp.setPowerConsumeMonth(rs.getString(7));
							comp.setRemarks(rs.getString(8));
							comp.setPresentunit(rs.getDouble(9));
							comp.setBillCost(rs.getDouble(10));
							comp.setPenalityCharges(rs.getDouble(11));
							comp.setAdditionalDeposit(rs.getDouble(12));
							comp.setDueDate(rs.getString(13));
							comp.setDisconnectionDate(rs.getString(14));
							comp.setComponentName(rs.getString(15));
							comp.setPreviousunit(preunit);

							return comp;

						}

					});
			return comp;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl editcompPowerinfo method error due to " + ex.getMessage());
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
	public List<ComponentAyacut> getComponentMonthlyAyacut(Integer componentId) throws ComponentUserException {

		String sql = SELECT_COMP_MON_AYACUT_DEL;
		try {
			List<ComponentAyacut> compList = jdbcTemplate4.query(sql, new Object[] { componentId },
					new RowMapper<ComponentAyacut>() {
						public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
							ComponentAyacut comp = new ComponentAyacut();
							comp.setCompMonAyacutId(rs.getInt(1));
							comp.setProjectId(rs.getInt(2));

							comp.setPresentAyacutCreated(rs.getDouble(3));
							comp.setComponentId(rs.getInt(4));

							comp.setRemarks(rs.getString(5));
							comp.setPresentAyacutmonth(rs.getString(6));
							comp.setPresentAyacutContemplated(rs.getDouble(7));
								
							comp.setDistrictId(rs.getInt(8));
							comp.setMandalId(rs.getInt(9));
							comp.setVillageId(rs.getInt(10));
							comp.setConstId(rs.getInt(11));
							comp.setUnitId(rs.getInt(12));
							comp.setUnitName(rs.getString(13));
							comp.setProjectName(rs.getString(14));
							comp.setDistrictName(rs.getString(15));
							comp.setMandalName(rs.getString(16));
							comp.setVillageName(rs.getString(17));
							comp.setConstName(rs.getString(18));
							comp.setComponentName(rs.getString(19));
							

							return comp;

						}

					});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentMonthlyAyacut method error due to " + ex.getMessage());
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
	public Integer deleteCompMonAyacut(Integer componentAyacutId) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_COMP_MON_AYACUT;

		Integer rows1 = 0;

		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (componentAyacutId != null) {

				if (componentAyacutId > 0) {

					rows1 = jdbcTemplate4.update(sql1, componentAyacutId);

				}

				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}

	@Override
	public ComponentAyacut editcompAyacutinfo(Integer compAyacutId) throws ComponentUserException {

		String sql = SELECT_COMP_MON_AYACUT_EDIT;
		
		try {
			ComponentAyacut comp = (ComponentAyacut) jdbcTemplate4.queryForObject(sql, new Object[] { compAyacutId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							ComponentAyacut comp = new ComponentAyacut();

							comp.setCompMonAyacutId(rs.getInt(1));
							comp.setProjectId(rs.getInt(2));

							comp.setPresentAyacutCreated(rs.getDouble(3));
							comp.setComponentId(rs.getInt(4));

							comp.setRemarks(rs.getString(5));
							comp.setPresentAyacutmonth(rs.getString(6));
							comp.setPresentAyacutContemplated(rs.getDouble(7));
							
							comp.setDistrictId(rs.getInt(8));
							comp.setMandalId(rs.getInt(9));
							comp.setVillageId(rs.getInt(10));
							comp.setConstId(rs.getInt(11));
							comp.setUnitId(rs.getInt(12));
							comp.setOldDistrictId(rs.getInt(13));
						
							

							return comp;

						}

					});
			return comp;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl editcompAyacutinfo method error due to " + ex.getMessage());
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
	public Integer updateComponentMonPower(final ComponentPower compObjectPower) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_COMP_MON_POWER;

		Date date1 = null;
		Date date2 = null;
		Date date3 = null;

		Integer editNum = 0;
		Integer editPackNum = 0;

		Integer componentId = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compObjectPower != null) {

				if (compObjectPower.getComponentPowerId() != null) {

					if (compObjectPower.getComponentPowerId() > 0) {

						if (compObjectPower.getPowerConsumeMonth() != null
								&& compObjectPower.getPowerConsumeMonth() != ""
								&& !compObjectPower.getPowerConsumeMonth().equals('0')) {

							date1 = DateUtil.getSQLDate(compObjectPower.getPowerConsumeMonth());

						}
						if (compObjectPower.getDueDate() != null && compObjectPower.getDueDate() != ""
								&& !compObjectPower.getDueDate().equals('0')) {

							date2 = DateUtil.getSQLDate(compObjectPower.getDueDate());

						}
						if (compObjectPower.getDisconnectionDate() != null
								&& compObjectPower.getDisconnectionDate() != ""
								&& !compObjectPower.getDisconnectionDate().equals('0')) {

							date3 = DateUtil.getSQLDate(compObjectPower.getDisconnectionDate());

						}

						editPackNum = jdbcTemplate4.update(sql, compObjectPower.getProjectId(),
								compObjectPower.getComponentId(), compObjectPower.getTotalUnitsConsumed(),
								compObjectPower.getFixedCharges(), compObjectPower.getNetBillCost(), date1,
								compObjectPower.getUserId(), 1, compObjectPower.getRemarks(),
								compObjectPower.getPresentunit(), compObjectPower.getBillCost(),
								compObjectPower.getPenalityCharges(), compObjectPower.getAdditionalDeposit(), date2,
								date3, compObjectPower.getComponentPowerId());

					}
				}

				if (editPackNum > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return editPackNum;
	}

	@Override
	public Integer updateComponentMonAyacut(final ComponentAyacut compObjectAyacut) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_COMP_MON_AYACUT;

		Integer editNum = 0;
		Integer editPackNum = 0;

		Date date1 = null;

		Integer componentId = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compObjectAyacut != null) {

				if (compObjectAyacut.getCompMonAyacutId() != null) {

					if (compObjectAyacut.getCompMonAyacutId() > 0) {

						if (compObjectAyacut.getPresentAyacutmonth() != null
								&& compObjectAyacut.getPresentAyacutmonth() != ""
								&& !compObjectAyacut.getPresentAyacutmonth().equals('0')) {

							date1 = DateUtil.getSQLDate(compObjectAyacut.getPresentAyacutmonth());

						}

						editPackNum = jdbcTemplate4.update(sql, compObjectAyacut.getProjectId(),
								compObjectAyacut.getPresentAyacutCreated(), compObjectAyacut.getComponentId(),
								compObjectAyacut.getRemarks(), date1, compObjectAyacut.getPresentAyacutContemplated(),
								 compObjectAyacut.getDistrictId(),	compObjectAyacut.getMandalId(), 
								 compObjectAyacut.getVillageId(),compObjectAyacut.getConstId(),
								 compObjectAyacut.getUnitId(),
								compObjectAyacut.getCompMonAyacutId());

					}
				}

				if (editPackNum > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return editPackNum;
	}

	@Override
	public List<Component> getComponentPowerAyacut(Integer projectId) throws ComponentUserException {

		String sql = SELECT_COMP_INPUT_P_A_DEL;
		try {
			List<Component> compList = jdbcTemplate4.query(sql, new Object[] { projectId }, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum) throws SQLException {
					Component comp = new Component();

					comp.setComponentName(rs.getString(1));
					comp.setComponentPowerAyacutId(rs.getInt(2));
					comp.setComponentId(rs.getInt(3));
					comp.setProjectId(rs.getInt(4));
					comp.setStageId(rs.getInt(5));
					comp.setPhaseId(rs.getInt(6));
					comp.setAnnualpowerconsumption(rs.getDouble(7));
					comp.setAyacutacres(rs.getDouble(8));
					comp.setFinancialyear(rs.getString(9));
					comp.setParentComponent(rs.getString(10));
					comp.setPackageName(rs.getString(11));
					

					return comp;

				}

			});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentPowerAyacut method error due to " + ex.getMessage());
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
	public List<Component> getComponentMotorInput(Integer projectId) throws ComponentUserException {

		String sql = SELECT_MOTOR_COMP_INPUT;
		try {
			List<Component> compList = jdbcTemplate4.query(sql, new Object[] { projectId }, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum) throws SQLException {
					Component comp = new Component();

					comp.setCompInfoId(rs.getInt(1));
					comp.setComponentId(rs.getInt(2));
					comp.setProjectId(rs.getInt(3));
					comp.setMotorNumber(rs.getInt(4));
					comp.setMotorconnectedLoad(rs.getDouble(5));
					comp.setMotoractualLoad(rs.getDouble(6));
					comp.setMotorrpm(rs.getInt(7));
					comp.setMotormakeId(rs.getInt(8));
					comp.setMotorMake(rs.getString(9));
					comp.setMotortypeId(rs.getInt(10));
					comp.setMotorType(rs.getString(11));
					comp.setMotorcapacityId(rs.getInt(13));
					comp.setTypepumpmotor(rs.getString(14));
					comp.setStatusId(rs.getInt(15));
					comp.setStatus(rs.getString(16));
					comp.setComponentPowerAyacutId(rs.getInt(17));

					return comp;

				}

			});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentMotorInput method error due to " + ex.getMessage());
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
	public List<Component> getComponentPumpInput(Integer componentId) throws ComponentUserException {

		String sql = SELECT_PUMP_COMP_INPUT;
		try {
			List<Component> compList = jdbcTemplate4.query(sql, new Object[] { componentId }, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum) throws SQLException {
					Component comp = new Component();

					comp.setCompInfoId(rs.getInt(1));
					comp.setComponentId(rs.getInt(2));
					comp.setProjectId(rs.getInt(3));
					
					comp.setConnectedLoad(rs.getDouble(4));
					comp.setActualLoad(rs.getDouble(5));
					comp.setRpm(rs.getInt(6));
					comp.setMake(rs.getInt(7));
					comp.setMotorMake(rs.getString(8));
					comp.setDeviceType(rs.getInt(9));
					comp.setMotorType(rs.getString(10));
					
					comp.setDeviceCategory(rs.getString(11));
					comp.setDeviceCapacity(rs.getInt(12));
					comp.setPumpCapacityName(rs.getString(13));
					comp.setDeviceStatus(rs.getInt(14));
					comp.setStatus(rs.getString(15));
					comp.setDeviceName(rs.getString(16));
					comp.setProjectName(rs.getString(17));
					comp.setUnitName(rs.getString(18));
					comp.setComponentName(rs.getString(19));
					
					return comp;

				}

			});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentPumpInput method error due to " + ex.getMessage());
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
	public Integer deleteCompInput(Integer componentPowerAyacutId) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_COMP_POW_AYACUT;
		String sql2 = DELETE_COMP_INFO_BYPA;

		Integer rows1 = 0;

		Integer rows2 = 0;

		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (componentPowerAyacutId != null) {

				if (componentPowerAyacutId > 0) {

					rows1 = jdbcTemplate4.update(sql1, componentPowerAyacutId);

					if (rows1 != null) {
						if (rows1 > 0) {

							rows2 = jdbcTemplate4.update(sql2, componentPowerAyacutId);

						}

					}

				}
				
				if(rows2>0){

				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
				
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows2;
	}
	@Override
	public Integer deleteCompmotorinfo(Integer componentInfoId) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql1 = DELETE_COMP_INFO_BYID;
		

		Integer rows1 = 0;

		

		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (componentInfoId != null) {

				if (componentInfoId > 0) {

					rows1 = jdbcTemplate4.update(sql1, componentInfoId);

					

				}
			

				jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows1;
	}
	
	
	
	@Override
	public Component editcompPowerAyacutinfo(Integer compPowerAyacutId) throws ComponentUserException {

		String sql = SELECT_COMP_POWERAYACUTINFO_EDIT;

		final Double preunit = 0.0;
		try {
			Component comp = (Component) jdbcTemplate4.queryForObject(sql, new Object[] { compPowerAyacutId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Component comp = new Component();
							comp.setComponentPowerAyacutId(rs.getInt(1));
							comp.setComponentId(rs.getInt(2));
							comp.setProjectId(rs.getInt(3));
							comp.setCompPackId(rs.getInt(4));
							comp.setStageId(rs.getInt(5));
							comp.setPhaseId(rs.getInt(6));
							comp.setAnnualpowerconsumption(rs.getDouble(7));
							comp.setFinancialyear(rs.getString(8));
							comp.setAyacutacres(rs.getDouble(9));
							comp.setParentComponentId(rs.getInt(10));
							

							return comp;

						}

					});
			return comp;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl editcompPowerAyacutinfo method error due to " + ex.getMessage());
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
	public Component editcompMotorinfo(Integer compInfoId) throws ComponentUserException {

		String sql = SELECT_COMP_INFO_EDIT;

		final Double preunit = 0.0;
		try {
			Component comp = (Component) jdbcTemplate4.queryForObject(sql, new Object[] { compInfoId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Component comp = new Component();
							comp.setCompInfoId(rs.getInt(1));
							comp.setComponentId(rs.getInt(2));
							comp.setProjectId(rs.getInt(3));
							
							
							comp.setCompPackId(rs.getInt(4));
							
							comp.setMake(rs.getInt(5));
							comp.setDeviceType(rs.getInt(6));
							
							comp.setStatusId(rs.getInt(7));
							
							comp.setDeviceCapacity(rs.getInt(8));
							comp.setConnectedLoad(rs.getDouble(9));
							comp.setActualLoad(rs.getDouble(10));
							comp.setRpm(rs.getInt(11));
							comp.setDeviceName(rs.getString(12));
							comp.setUnitId(rs.getInt(13));
							comp.setDeviceCategory(rs.getString(14));
							
						

							return comp;

						}

					});
			return comp;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl editcompPowerinfo method error due to " + ex.getMessage());
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
	public Integer updateCompPowerAyacut(final Component compObject) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_COMP_POWER_AYACUT;

		Integer editNum = 0;
		Integer editPackNum = 0;

		Date date1 = null;

		Integer componentId = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compObject != null) {

				if (compObject.getComponentPowerAyacutId() != null) {

					if (compObject.getComponentPowerAyacutId() > 0) {

					

						editPackNum = jdbcTemplate4.update(sql, compObject.getComponentId(), compObject.getProjectId(),
								compObject.getCompPackId(),compObject.getStageId(),compObject.getPhaseId(),
								compObject.getAnnualpowerconsumption(), compObject.getUserId(),1,compObject.getFinancialyear(),
								compObject.getAyacutacres(),compObject.getComponentPowerAyacutId()
								);

					}
				}

				if (editPackNum > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return editPackNum;
	}

	
	@Override
	public Integer updateComponentInfo(final Component compObject) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_COMP_POWER_INFO;

		Integer editNum = 0;
		Integer editPackNum = 0;

		Date date1 = null;

		Integer componentId = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compObject != null) {

				if (compObject.getCompInfoId() != null) {

					if (compObject.getCompInfoId() > 0) {

						

						editPackNum = jdbcTemplate4.update(sql, compObject.getDeviceName(),
								1,compObject.getUserId(), 
								compObject.getMake(), compObject.getDeviceType(),
								compObject.getStatusId(),
								 compObject.getDeviceCapacity(),
								compObject.getConnectedLoad(),compObject.getActualLoad(),compObject.getRpm(),compObject.getDeviceCategory(),compObject.getRemarks(),  compObject.getCompInfoId());

					}
				}

				if (editPackNum > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return editPackNum;
	}

	
	@Override
	public List<Component> getPumPCapacityList() throws ComponentUserException {
		
		String sql = SELECT_COMP_PSCAPACITY;
		try {
			List<Component> pumpmotorList = jdbcTemplate4.query(sql, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum) throws SQLException {

					Component pm = new Component();
					pm.setPumpcapacityId(rs.getInt(1));
					pm.setPumpCapacityName(rs.getString(2));

					return pm;

				}

			});
			return pumpmotorList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getPumPCapacityList method error due to " + ex.getMessage());
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
	public List<Component> getStageList() throws ComponentUserException {
		
		String sql = SELECT_STAGE;
		try {
			List<Component> pumpmotorList = jdbcTemplate4.query(sql, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum) throws SQLException {

					Component pm = new Component();
					pm.setStageId(rs.getInt(1));
					pm.setStageName(rs.getString(2));

					return pm;

				}

			});
			return pumpmotorList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getStageList method error due to " + ex.getMessage());
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
	public List<Component> getPhaseList() throws ComponentUserException {
		
		String sql = SELECT_PHASE;
		try {
			List<Component> pumpmotorList = jdbcTemplate4.query(sql, new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum) throws SQLException {

					Component pm = new Component();
					pm.setPhaseId(rs.getInt(1));
					pm.setPhaseName(rs.getString(2));

					return pm;

				}

			});
			return pumpmotorList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getPhaseList method error due to " + ex.getMessage());
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
	public List<Component> getCompTypeList(Integer compcatId) throws ComponentUserException {
		
		String sql = SELECT_COMP_TYPE;
		try {
			List<Component> pumpmotorList = jdbcTemplate4.query(sql, new Object[] { compcatId },new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum) throws SQLException {

					Component pm = new Component();
					pm.setComponentTypeId(rs.getInt(1));
					pm.setComponentType(rs.getString(2));

					return pm;

				}

			});
			return pumpmotorList;

		} catch (Exception ex) {
			log.error("Inside getCompTypeList getPhaseList method error due to " + ex.getMessage());
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
	public List<Constituency> getConstList() throws ComponentUserException {
		
		String sql = SELECT_CONST_MST;
		try {
			List<Constituency> constList = jdbcTemplate4.query(sql, new RowMapper<Constituency>() {
				public Constituency mapRow(ResultSet rs, int rowNum) throws SQLException {

					Constituency cons = new Constituency();
					cons.setConstId(rs.getInt(1));
					cons.setConstName(rs.getString(2));
					cons.setDistrictId(rs.getInt(3));

					return cons;

				}

			});
			
			
			
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

			
			
			
		} catch (Exception ex) {
			log.error("Inside getCompTypeList getPhaseList method error due to " + ex.getMessage());
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
	public Integer insertPackages(Integer projectId, String packName, Integer circleId) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_PACKS;

		
		Integer packageId = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			

				if (projectId != null && packName!=null) {

					if (packName.length() > 0) {

						

						List<Map<String, Object>> packId = jdbcTemplate4.queryForList(sql, projectId
								,packName,circleId
								);
						
						for (Map<String, Object> row : packId) {
							packageId = Integer.parseInt(row.get("pack_id").toString());
						}

						

					}
				}

				if (packageId > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
					
				}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return packageId;
	
	}

	@Override
	public Integer insertConstituency(final ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_CONST_DIST_MAP;
         //String sql1=SELECT_CONST_NAME;
		
		Integer output = 0;
		String constituency=null;
		Integer constdistMapId=0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compAyacutObj != null) {

				if (compAyacutObj.getDistrictId() != null && compAyacutObj.getConstId()!=null) {

					if (compAyacutObj.getConstId() > 0 &&  compAyacutObj.getDistrictId()>0) {
						
						
						  
         			   //System.out.println("coming 123compAyacutObj.getConstName()"+compAyacutObj.getConstName()+"----------"+compAyacutObj.getDistrictId());
						/*List<String>  constnameList = jdbcTemplate4.query(sql,compAyacutObj.getDistrictId() );

						for (Map<String, Object> row : constname) {
							constituency = (row.get("constituency_name").toString());
						}*/
						// System.out.println("coming 124compAyacutObj.getConstName()"+compAyacutObj.getConstName()+"----------"+compAyacutObj.getDistrictId());
                    	  
                    		  /* if(compAyacutObj.getConstName()!=constituency ){*/
                    			   
                    			//   System.out.println("compAyacutObj.getConstName()"+compAyacutObj.getConstName()+"----------"+compAyacutObj.getDistrictId());
						List<Map<String, Object>> constdistId  = jdbcTemplate4.queryForList(sql,compAyacutObj.getConstId(),compAyacutObj.getDistrictId());
						
						for (Map<String, Object> row : constdistId) {
							constdistMapId = Integer.parseInt(row.get("const_dist_id").toString());
					}
                    	  
                      

					}
				}

				if (output > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return constdistMapId;
	}
	
	
	/*@Override
	public Integer updateMandalConstituency(final ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_MANDAL_CONST;

		
		Integer updatedrows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compAyacutObj != null) {

				if (compAyacutObj.getMandalId() != null && compAyacutObj.getConstName()!=null) {

					if (compAyacutObj.getConstId() > 0) {

						

						updatedrows = jdbcTemplate4.update(sql, compAyacutObj.getConstId(),compAyacutObj.getMandalId()
								,compAyacutObj.getDistrictId()
								);
						
						

						

					}
				}

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return updatedrows;
	}
	
	@Override
	public Integer updateVillageConstituency(final ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_VILLAGE_CONST;

		
		Integer updatedrows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compAyacutObj != null) {

				if (compAyacutObj.getVillageId() != null && compAyacutObj.getConstId()!=null) {

					if (compAyacutObj.getConstId() > 0) {

						

						updatedrows = jdbcTemplate4.update(sql, compAyacutObj.getConstId(),compAyacutObj.getVillageId(),compAyacutObj.getMandalId()
								
								);
						
						

						

					}
				}

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return updatedrows;
	}
     */
	
	@Override
	public Integer insertprojAyacut(final ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_PROJ_AYACUT;

		
		Integer updatedrows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compAyacutObj != null) {

				if (compAyacutObj.getProjectId() != null && compAyacutObj.getDistrictId()!=null && compAyacutObj.getContemplatedAyacut()!=null ) {

				
                     //,compAyacutObj.getAyacutYear()
						

						updatedrows = jdbcTemplate4.update(sql, compAyacutObj.getProjectId(),compAyacutObj.getPackageId(),compAyacutObj.getAyacutCreated()
								,compAyacutObj.getStableAyacut(),compAyacutObj.getUserId(),compAyacutObj.getRemarks(),compAyacutObj.getDistrictId(),compAyacutObj.getConstId(),
								compAyacutObj.getMandalId(),compAyacutObj.getVillageId(),compAyacutObj.getUnitId(),compAyacutObj.getUserName(),compAyacutObj.getIrriagtedAyacut(),
								compAyacutObj.getCircleId(),compAyacutObj.getDivisionId(),compAyacutObj.getSubdivisionId(),compAyacutObj.getContemplatedAyacut(),
								compAyacutObj.getOldProjAyacutId(),compAyacutObj.getJursFlag()
								);
						
						

						

					
				}

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return updatedrows;
	}
	
	@Override
	public List<Packages> getProjPacks(Integer projectId) throws ComponentUserException {

		String sql = SELECT_PROJ_PACKSNEW;
		try {
			List<Packages> packList = jdbcTemplate4.query(sql, new Object[] { projectId }, new RowMapper<Packages>() {
				public Packages mapRow(ResultSet rs, int rowNum) throws SQLException {
					Packages pack = new Packages();
					pack.setPkgId(rs.getInt(1));
					pack.setPkgName(rs.getString(2));

					return pack;

				}

			});
			return packList;

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
	public List<ComponentAyacut> getProjectAyacutInfo(Integer unitId) throws ComponentUserException {

		String sql = SELECT_PROJ_AYACUT_DELETE;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> projAyacutList = jdbcTemplate4.query(sql, new Object[] { unitId }, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut projayacut = new ComponentAyacut();
					
					projayacut.setUnitName(rs.getString(1));
					projayacut.setProjectName(rs.getString(2));
					projayacut.setPackageName(rs.getString(3));
					projayacut.setConstName(rs.getString(4));
					projayacut.setDistrictName(rs.getString(5));
					projayacut.setMandalName(rs.getString(6));
					projayacut.setVillageName(rs.getString(7));
					projayacut.setProjAyacutId(rs.getInt(8));
					
					
					projayacut.setProjectId(rs.getInt(9));
					projayacut.setPackageId(rs.getInt(10));
					projayacut.setAyacutCreated(rs.getDouble(11));
					
					
					projayacut.setStableAyacut(rs.getDouble(12));
					projayacut.setRemarks(rs.getString(13));
					projayacut.setDistrictId(rs.getInt(14));
					projayacut.setConstId(rs.getInt(15));
					projayacut.setMandalId(rs.getInt(16));
					projayacut.setVillageId(rs.getInt(17));					
					projayacut.setUnitId(rs.getInt(18));	
					projayacut.setIrriagtedAyacut(rs.getDouble(19));
					projayacut.setContemplatedAyacut(rs.getDouble(20));
					projayacut.setCircleName(rs.getString(21));
					projayacut.setDivisionName(rs.getString(22));
					projayacut.setCircleId(rs.getInt(23));
					projayacut.setDivisionId(rs.getInt(24));
					/*projayacut.setAyacutYear(rs.getInt(25));*/
					
					
					return projayacut;

				}

			});
			
			//jdbcTemplate4.getDataSource().getConnection().close();
			return projAyacutList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getProjectAyacutInfo method error due to " + ex.getMessage());
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
	public Integer  deleteProjectAyacut(Integer projAyacutId, String userName ) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_PROJECT_AYACUT;

		
		Integer updatedrows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (projAyacutId != null) {

			
					if (projAyacutId > 0) {

						

						updatedrows = jdbcTemplate4.update(sql,userName, projAyacutId );
								
					
				}

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return updatedrows;
	}
     
	
	@Override
	public ComponentAyacut geteditProjectAyacutInfo(Integer projAyacutId) throws ComponentUserException {

		String sql = SELECT_PROJ_AYACUT_EDIT;

		final Double preunit = 0.0;
		try {
			ComponentAyacut projAyacutobj = (ComponentAyacut)jdbcTemplate4.queryForObject(sql, new Object[] { projAyacutId },
					new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					ComponentAyacut projayacut = new ComponentAyacut();
					
					projayacut.setUnitName(rs.getString(1));
					projayacut.setProjectName(rs.getString(2));
					projayacut.setPackageName(rs.getString(3));
					projayacut.setConstName(rs.getString(4));
					projayacut.setDistrictName(rs.getString(5));
					projayacut.setMandalName(rs.getString(6));
					projayacut.setVillageName(rs.getString(7));
					projayacut.setProjAyacutId(rs.getInt(8));
					
					
					projayacut.setProjectId(rs.getInt(9));
					projayacut.setPackageId(rs.getInt(10));
					projayacut.setAyacutCreated(rs.getDouble(11));
					
					projayacut.setStableAyacut(rs.getDouble(12));
					projayacut.setRemarks(rs.getString(13));
					projayacut.setDistrictId(rs.getInt(14));
					projayacut.setConstId(rs.getInt(15));
					projayacut.setMandalId(rs.getInt(16));
					projayacut.setVillageId(rs.getInt(17));					
					projayacut.setUnitId(rs.getInt(18));
					projayacut.setConstdistMapId(rs.getInt(19));
					projayacut.setOldDistrictId(rs.getInt(20));
					projayacut.setIrriagtedAyacut(rs.getDouble(21));
					projayacut.setContemplatedAyacut(rs.getDouble(22));
					/*projayacut.setAyacutYear(rs.getInt(23));*/
					return projayacut;

				}

			});
			
			
			return projAyacutobj;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl geteditProjectAyacutInfo method error due to " + ex.getMessage());
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
	public Integer editprojAyacut(final ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = EDIT_PROJ_AYACUT;

		
		Integer updatedrows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compAyacutObj != null) {

				if (compAyacutObj.getProjectId() != null && compAyacutObj.getDistrictId()!=null && compAyacutObj.getContemplatedAyacut()!=null ) {

					
                       //compAyacutObj.getAyacutYear(),
						

						updatedrows = jdbcTemplate4.update(sql,compAyacutObj.getProjectId(), compAyacutObj.getPackageId(),compAyacutObj.getAyacutCreated()
								,compAyacutObj.getStableAyacut(),compAyacutObj.getRemarks(),compAyacutObj.getDistrictId(),compAyacutObj.getConstId(),
								compAyacutObj.getMandalId(),compAyacutObj.getVillageId(),
								compAyacutObj.getUserId(),compAyacutObj.getUserName(),compAyacutObj.getIrriagtedAyacut(),compAyacutObj.getContemplatedAyacut(),   compAyacutObj.getProjAyacutId()
								);
						
						

						

					
				}

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return updatedrows;
	}
	
	
	@Override
	public Integer editPackages(final ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = EDIT_PACKS;

		
		Integer packageId = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compAyacutObj != null) {

				if (compAyacutObj.getPackageId()!=null && compAyacutObj.getPackageName()!=null) {

					if (compAyacutObj.getPackageName().length() > 0) {

						

						packageId = jdbcTemplate4.update(sql, compAyacutObj.getPackageName(),compAyacutObj.getPackageId()
								);
						
					
						

					}
				}

				if (packageId > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return packageId;
	
	}

	
	@Override
	public Integer updateConstituency(final ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_CONST_DIST_MAP;
         //String sql1=SELECT_CONST_NAME;
		
		Integer output = 0;
		String constituency=null;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compAyacutObj != null) {

				if (compAyacutObj.getDistrictId() != null && compAyacutObj.getConstId()!=null) {

					if (compAyacutObj.getConstId() > 0 &&  compAyacutObj.getDistrictId()>0) {
						
						
						  
         			   //System.out.println("coming 123compAyacutObj.getConstName()"+compAyacutObj.getConstName()+"----------"+compAyacutObj.getDistrictId());
						/*List<String>  constnameList = jdbcTemplate4.query(sql,compAyacutObj.getDistrictId() );

						for (Map<String, Object> row : constname) {
							constituency = (row.get("constituency_name").toString());
						}*/
						// System.out.println("coming 124compAyacutObj.getConstName()"+compAyacutObj.getConstName()+"----------"+compAyacutObj.getDistrictId());
                    	  
                    		  /* if(compAyacutObj.getConstName()!=constituency ){*/
                    			   
                    			//   System.out.println("compAyacutObj.getConstName()"+compAyacutObj.getConstName()+"----------"+compAyacutObj.getDistrictId());
						output = jdbcTemplate4.update(sql,compAyacutObj.getConstId(),compAyacutObj.getDistrictId(),compAyacutObj.getConstdistMapId());
						
//						for (Map<String, Object> row : constituencyId) {
//							constId = Integer.parseInt(row.get("constituency_id").toString());
//						}
                    	  /* }*/
                    	  
                      

					}
				}

				if (output > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return output;
	}
	
	
	
	

	@Override
	public List<Constituency> getConstListbyoldDist(Integer districtId,Integer mcode) throws ComponentUserException {
		
		String sql = SELECT_CONST_MST_BYOLDDIST;
		try {
			List<Constituency> constList = jdbcTemplate4.query(sql,new Object[] { districtId,mcode }, new RowMapper<Constituency>() {
				public Constituency mapRow(ResultSet rs, int rowNum) throws SQLException {

					Constituency cons = new Constituency();
					cons.setConstId(rs.getInt(1));
					cons.setConstName(rs.getString(2));
					

					return cons;

				}

			});
			
			
			
			jdbcTemplate4.getDataSource().getConnection().close();
			return constList;

			
			
			
		} catch (Exception ex) {
			log.error("Inside CompAdminDAoImpl getConstListbyoldDist method error due to " + ex.getMessage());
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
	public List<CompInfo> getCompPumpsInfo(Integer componentId) throws ComponentUserException {

		String sql = SELECT_COMP_PUMPS;
		try {
			List<CompInfo> compList = jdbcTemplate4.query(sql, new Object[] { componentId },
					new RowMapper<CompInfo>() {
						public CompInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
							CompInfo comp = new CompInfo();
							comp.setCompInfoId(rs.getInt(1));
							comp.setPumpName(rs.getString(2));

							return comp;

						}

					});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getCompPumpsInfo method error due to " + ex.getMessage());
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
	public Integer insertComponentsDailyinfo(final CompInfo CompInfoObj) throws ComponentUserException {

		String sql = INSERT_DAILY_INPUT;

		Integer rows = 0;

		int[] k = null;
		

		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (CompInfoObj.getCompInfoList().size() > 0) {
				
				
				k = jdbcTemplate4.batchUpdate(sql, new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						
						
						//System.out.println("print"+i);
						
						
						

						CompInfo cpinfo = CompInfoObj.getCompInfoList().get(i);
						
						//System.out.println( "new"+cpinfo.getCompInfoId());

						ps.setInt(1, cpinfo.getComponentId());
						
						ps.setInt(2, cpinfo.getCompInfoId());
						ps.setInt(3,  cpinfo.getUnitId());
						ps.setInt(4,  cpinfo.getProjectId());
						ps.setDouble(5, cpinfo.getPumpDischarge());
						ps.setString(6,  cpinfo.getPumpStartDate());
						ps.setString(7, cpinfo.getPumpStartTime());
						ps.setString(8, cpinfo.getPumpEndTime());
						ps.setDouble(9, cpinfo.getPumpEnergy());
						ps.setString(10, cpinfo.getRemarks());
						ps.setInt(11, cpinfo.getUserId());
						ps.setString(12, cpinfo.getUserName());
						
						
					}

					@Override
					public int getBatchSize() {
						return CompInfoObj.getCompInfoList().size();
					}
				});

			}
			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
			rows = k.length;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}

	@Override
	public Integer insertComponentsinfo(final Component compInfoobj) throws ComponentUserException {

		String sql = INSERT_COMP_INFONEW;

		Integer rows = 0;

		int[] k = null;

		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
			if (compInfoobj.getCompInputList().size() > 0) {
				k = jdbcTemplate4.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
					
					
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						//System.out.println("print1"+i);
						//i=i+1;
					//	System.out.println("print2"+i);
						
						
					
						Component compin = compInfoobj.getCompInputList().get(i);

						ps.setInt(1, compInfoobj.getComponentId());
						ps.setInt(2, 2);
						ps.setInt(3, compInfoobj.getProjectId());
					
						ps.setInt(4, 1);
						
					
						ps.setInt(5, compin.getMake());
						ps.setInt(6, compin.getDeviceType());
						ps.setInt(7, compin.getDeviceStatus());
					
						ps.setInt(8, compin.getDeviceCapacity());
						ps.setDouble(9, compin.getConnectedLoad());
						ps.setString(10, compin.getDeviceCategory());
						ps.setDouble(11, compin.getActualLoad());
						ps.setInt(12, compin.getRpm());
						ps.setString(13, compin.getDeviceName());
						ps.setInt(14, compInfoobj.getUnitId());
						
					

					}
					

					@Override
					public int getBatchSize() {
						return compInfoobj.getCompInputList().size();
					}
				});

			}
			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
			rows = k.length;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return rows;
	}
	
	
	
	@Override
	public List<CompInfo> getCompdailyInfo(Integer componentId, String componentDate) throws ComponentUserException {

		String sql = SELECT_COMP_DAILY_INFO;
		try {
			List<CompInfo> compList = jdbcTemplate4.query(sql, new Object[] { componentId , componentDate},
					new RowMapper<CompInfo>() {
						public CompInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
							CompInfo comp = new CompInfo();
							comp.setCompInputId(rs.getInt(1));
							comp.setComponentId(rs.getInt(2));
							comp.setCompInfoId(rs.getInt(3));
							comp.setUnitId(rs.getInt(4));
							comp.setProjectId(rs.getInt(5));
							comp.setPumpDischarge(rs.getDouble(6));
							comp.setPumpEnergy(rs.getDouble(7));
							comp.setRemarks(rs.getString(8));
							comp.setPumpStartTime(rs.getString(9));
							comp.setPumpEndTime(rs.getString(10));
							comp.setPumpStartDate(rs.getString(11));
							comp.setProjectName(rs.getString(12));
							comp.setUnitName(rs.getString(13));
comp.setComponentName(rs.getString(14));

							
							comp.setPumpName(rs.getString(15));

							return comp;

						}

					});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getCompdailyInfo method error due to " + ex.getMessage());
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
	public List<Component> getComponentList() throws ComponentUserException {

		String sql = SELECT_COMP_LIST;
		try {
			List<Component> compList = jdbcTemplate4.query(sql,  new RowMapper<Component>() {
				public Component mapRow(ResultSet rs, int rowNum) throws SQLException {
					Component comp = new Component();
					comp.setComponentId(rs.getInt(1));
					comp.setComponentName(rs.getString(2));
					comp.setProjectId(rs.getInt(3));

					return comp;

				}

			});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentList method error due to " + ex.getMessage());
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
	public Integer deleteCompDailyInput(Integer compInputId) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_COMP_DAILYINPUT;

		
		Integer deletedRows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compInputId != null) {

				

					if (compInputId>0) {

						

						deletedRows = jdbcTemplate4.update(sql, compInputId);
						
					
						

					}
				

				if (deletedRows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return deletedRows;
	
	}
	
	
	
	@Override
	public CompInfo getEditdailyInfo(Integer compInputId) throws ComponentUserException {

		String sql = SELECT_DAILY_EDITINFO;
		try {
			CompInfo compList = (CompInfo)jdbcTemplate4.queryForObject(sql, new Object[] { compInputId},new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							CompInfo comp = new CompInfo();
							comp.setCompInputId(rs.getInt(1));
							comp.setComponentId(rs.getInt(2));
							comp.setCompInfoId(rs.getInt(3));
							comp.setUnitId(rs.getInt(4));
							comp.setProjectId(rs.getInt(5));
							comp.setPumpDischarge(rs.getDouble(6));
							comp.setPumpEnergy(rs.getDouble(7));
							comp.setRemarks(rs.getString(8));
							comp.setPumpStartTime(rs.getString(9));
							comp.setPumpEndTime(rs.getString(10));
							comp.setPumpStartDate(rs.getString(11));
							comp.setPumpName(rs.getString(12));
							


							
							

							return comp;

						}

					});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getEditdailyInfo method error due to " + ex.getMessage());
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
	public Integer editCompDailyInput(CompInfo compInfoObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_COMP_DAILY_INPUT;

		
		Integer updatedRows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compInfoObj.getCompInputId() != null) {

				

					if (compInfoObj.getCompInputId()>0) {

						

						updatedRows = jdbcTemplate4.update(sql,compInfoObj.getPumpDischarge(),compInfoObj.getPumpEnergy(),
								compInfoObj.getRemarks(),compInfoObj.getUserId(),compInfoObj.getUserName(),
								compInfoObj.getPumpStartTime(),compInfoObj.getPumpEndTime(),compInfoObj.getPumpStartDate()
								,compInfoObj.getCompInputId());
					}
				

				if (updatedRows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return updatedRows;
	
	}
	
	
	@Override
	public Integer insertCompDischarge(final CompInfo compInfObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_COMP_DISCHARGE;

		
		Integer updatedrows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compInfObj != null) {

				if (compInfObj.getProjectId() != null && compInfObj.getComponentId()!=null && compInfObj.getPumpDischarge()!=null ) {

					if (compInfObj.getPumpDischarge() > 0.0) {

						

						updatedrows = jdbcTemplate4.update(sql,compInfObj.getUnitId(), compInfObj.getProjectId(),compInfObj.getComponentId(),compInfObj.getSeasonId()
								,compInfObj.getSeasonYear(),compInfObj.getSeasonMonth(),compInfObj.getPumpDischarge(),compInfObj.getAyacut(),compInfObj.getRemarks(),
								compInfObj.getUserId(),compInfObj.getUserName()
								);
						
						

						

					}
				}

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return updatedrows;
	}
	
	
	@Override
	public List<CompInfo> getCompDischargeList(Integer componentId) throws ComponentUserException {

		String sql = SELECT_COMP_DISCHARGE;
		try {
			List<CompInfo> compList = jdbcTemplate4.query(sql,new Object[] { componentId},  new RowMapper<CompInfo>() {
				public CompInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
					CompInfo comp = new CompInfo();
					
					comp.setCompDischargeId(rs.getInt(1));
					comp.setUnitId(rs.getInt(2));
					comp.setProjectId(rs.getInt(3));
					comp.setComponentId(rs.getInt(4));
					comp.setSeasonId(rs.getInt(5));
					comp.setSeasonYear(rs.getInt(6));
					comp.setSeasonMonth(rs.getInt(7));
					comp.setPumpDischarge(rs.getDouble(8));
					comp.setAyacut(rs.getDouble(9));
					comp.setRemarks(rs.getString(10));
					comp.setProjectName(rs.getString(11));
					comp.setUnitName(rs.getString(12));
					comp.setComponentName(rs.getString(13));

					return comp;

				}

			});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getCompDischargeList method error due to " + ex.getMessage());
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
	public CompInfo getEditCompDischarge(Integer compDischargeId) throws ComponentUserException {

		String sql = SELECT_COMP_EDIT_DISCHARGE;
		try {
			CompInfo compList = (CompInfo)jdbcTemplate4.queryForObject(sql,new Object[] { compDischargeId},  new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					CompInfo comp = new CompInfo();
					
					comp.setCompDischargeId(rs.getInt(1));
					comp.setUnitId(rs.getInt(2));
					comp.setProjectId(rs.getInt(3));
					comp.setComponentId(rs.getInt(4));
					comp.setSeasonId(rs.getInt(5));
					comp.setSeasonYear(rs.getInt(6));
					comp.setSeasonMonth(rs.getInt(7));
					comp.setPumpDischarge(rs.getDouble(8));
					comp.setAyacut(rs.getDouble(9));
					comp.setRemarks(rs.getString(10));
					comp.setProjectName(rs.getString(11));
					comp.setUnitName(rs.getString(12));
					comp.setComponentName(rs.getString(13));
					comp.setSeasonMonthName(rs.getString(14));

					return comp;

				}

			});
			return compList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getEditCompDischarge method error due to " + ex.getMessage());
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
	public Integer updateCompDischarge(final CompInfo compInfObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = EDIT_COMP_DISCHRAGE;

		
		Integer updatedrows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compInfObj != null) {

				if (compInfObj.getProjectId() != null && compInfObj.getComponentId()!=null && compInfObj.getPumpDischarge()!=null ) {

					if (compInfObj.getPumpDischarge() > 0.0) {

						

						updatedrows = jdbcTemplate4.update(sql,compInfObj.getUnitId(), compInfObj.getProjectId(),compInfObj.getComponentId(),compInfObj.getSeasonId()
								,compInfObj.getSeasonYear(),compInfObj.getSeasonMonth(),compInfObj.getPumpDischarge(),compInfObj.getAyacut(),compInfObj.getRemarks(),
								compInfObj.getUserId(),compInfObj.getUserName(), compInfObj.getCompDischargeId()
								);
						
						

						

					}
				}

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return updatedrows;
	}
	
	
	@Override
	public Integer getDocNumber(  ) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = GET_DOC_NUM;

		
		Integer docnum = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			List<Map<String, Object>> ct = jdbcTemplate4.queryForList(sql);

			for (Map<String, Object> row : ct) {
				docnum = Integer.parseInt(row.get("docnum").toString());
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return docnum;
	
	}
	
	
	
	
	@Override
	public Integer deleteCompDischarge(Integer compDischargeId) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_COMP_DISCHARGE;

		
		Integer deletedRows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compDischargeId != null) {

				

					if (compDischargeId>0) {

						

						deletedRows = jdbcTemplate4.update(sql, compDischargeId);
						
					
						

					}
				

				if (deletedRows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return deletedRows;
	
	}
	
	
	
	@Override
	public Integer insertPowerBill(final PowerBill powerBill) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_COMP_POWER_BILL;

		
		Integer updatedrows = 0;
		Double delayRate=0.0;
		
		Date billdate=null;
		Date billDuedate=null;
		Date disconnectoinDate=null;
		Date paidDate=null;
		
		
		
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (powerBill != null) {

				if (powerBill.getProjectId() != null && powerBill.getComponentId()!=null && powerBill.getTotalAmount()!=null ) {

					if (powerBill.getTotalAmount() > 0.0) {
						
						

						if (powerBill.getBillDate() != null && powerBill.getBillDate() != ""
								&& !powerBill.getBillDate().equals('0')) {

							billdate = DateUtil.getSQLDate(powerBill.getBillDate());

						}if (powerBill.getBillDueDate() != null && powerBill.getBillDueDate() != ""
								&& !powerBill.getBillDueDate().equals('0')) {

							billDuedate = DateUtil.getSQLDate(powerBill.getBillDueDate());

						}
						if (powerBill.getDisconnectionDate() != null && powerBill.getDisconnectionDate() != ""
								&& !powerBill.getDisconnectionDate().equals('0')) {

							disconnectoinDate = DateUtil.getSQLDate(powerBill.getDisconnectionDate());

						}
						if (powerBill.getPaidDate() != null && powerBill.getPaidDate() != ""
								&& !powerBill.getPaidDate().equals('0')) {

							paidDate = DateUtil.getSQLDate(powerBill.getPaidDate());

						}
					
						
						
						
						if(powerBill.getDelayPayInPaise()!=null||powerBill.getDelayPayInPaise()!=0){
							if(powerBill.getDelayPayInPaise()>0){
							delayRate=powerBill.getDelayPayInPaise();
							}
						}else if(powerBill.getDelayPayPerDay()!=null||powerBill.getDelayPayPerDay()!=0){
							if(powerBill.getDelayPayPerDay()>0){
							delayRate=powerBill.getDelayPayPerDay();
							}
						}

						

						updatedrows = jdbcTemplate4.update(sql,powerBill.getUnitId(), powerBill.getProjectId(),powerBill.getComponentId(),powerBill.getBillNumber(),
								billDuedate,billdate,disconnectoinDate,powerBill.getConsumedUnits(),
								powerBill.getEnergyChargeRate(),powerBill.getEnergyCharges(), powerBill.getElectricityDutyRate(),powerBill.getElectricityDuty(),
								powerBill.getEletricityDutyInterest(),powerBill.getDemandRate(),powerBill.getDemandCharges(),powerBill.getCustomerCharges(),powerBill.getLatePaySurCharge(),
								delayRate,powerBill.getACDSurCharges(),powerBill.getInterestSecurityDeposite(),powerBill.getTotalAmount(),paidDate,
								powerBill.getPaidAmount(),powerBill.getAdditionalSecurityDeposit(),powerBill.getPendingAmount(),powerBill.getPaidStatusId(),powerBill.getRemarks(),
								powerBill.getBillYear(),powerBill.getBillMonth(),powerBill.getLiftMetres(),powerBill.getEnergyChargeRate(),powerBill.getQuantity(),
								powerBill.getUserId(),powerBill.getUserName(),powerBill.getDocumentName(),powerBill.getDocumentNumer(),powerBill.getDocumentPath(),
								powerBill.getFixedCharges(),powerBill.getVariableCharges(),powerBill.getVariableOthers()
								);
						
						

						

					}
				}

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return updatedrows;
	}
	
	
	@Override
	public List<PowerBill> getComponentPowerInfo(Integer componentId) throws ComponentUserException {

		String sql = SELECT_POWER_BILL_DELETE;

		final Double preunit = 0.0;
		try {
			List<PowerBill> powerBillList = jdbcTemplate4.query(sql, new Object[] { componentId }, new RowMapper<PowerBill>() {
				public PowerBill mapRow(ResultSet rs, int rowNum) throws SQLException {
					PowerBill pbill = new PowerBill();
					
					
					pbill.setCompPowerBillId(rs.getInt(1));
					pbill.setUnitId(rs.getInt(2));
					pbill.setProjectId(rs.getInt(3));
					pbill.setComponentId(rs.getInt(4));
					
					
					pbill.setBillDueDate(rs.getString(5));
					pbill.setBillDate(rs.getString(6));
					pbill.setDisconnectionDate(rs.getString(7));
					
					pbill.setConsumedUnits(rs.getDouble(8));
					pbill.setEnergyChargeRate(rs.getDouble(9));
					pbill.setEnergyCharges(rs.getDouble(10));
					pbill.setElectricityDutyRate(rs.getDouble(11));
					pbill.setElectricityDutyRate(rs.getDouble(12));
					pbill.setEletricityDutyInterest(rs.getDouble(13));					
					pbill.setDemandRate(rs.getDouble(14));
					pbill.setDemandCharges(rs.getDouble(15));
					pbill.setCustomerCharges(rs.getDouble(16));
					pbill.setLatePaySurCharge(rs.getDouble(17));
					pbill.setDelayPayInPaise(rs.getDouble(18));
					pbill.setACDSurCharges(rs.getDouble(19));
					pbill.setInterestSecurityDeposite(rs.getDouble(20));
					pbill.setTotalAmount(rs.getDouble(21));
					pbill.setPaidDate(rs.getString(22));
					pbill.setPaidAmount(rs.getDouble(23));
					pbill.setAdditionalSecurityDeposit(rs.getDouble(24));
					pbill.setPendingAmount(rs.getDouble(25));
					pbill.setPaidStatus(rs.getString(26));
					pbill.setRemarks(rs.getString(27));
					pbill.setBillYear(rs.getInt(28));
					pbill.setBillMonth(rs.getInt(29));
					pbill.setLiftMetres(rs.getDouble(30));
					pbill.setUnitrate(rs.getDouble(31));
					pbill.setQuantity(rs.getDouble(32));
					pbill.setDocumentNumer(rs.getString(33));
					pbill.setDocumentName(rs.getString(34));
					pbill.setDocumentPath(rs.getString(35));
					pbill.setBillNumber(rs.getString(36));
					pbill.setProjectName(rs.getString(37));					
					pbill.setUnitName(rs.getString(38));
				
					pbill.setComponentName(rs.getString(39));
					pbill.setFixedCharges(rs.getDouble(40));
					pbill.setVariableCharges(rs.getDouble(41));
					
					
					
					return pbill;

				}

			});
			
			//jdbcTemplate4.getDataSource().getConnection().close();
			return powerBillList;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentPowerInfo  method error due to " + ex.getMessage());
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
	public Integer deleteCompPowerBill(Integer compPowerBillId) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_COMP_POWER_BILL;

		
		Integer deletedRows = 0;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (compPowerBillId != null) {

				

					if (compPowerBillId>0) {

						

						deletedRows = jdbcTemplate4.update(sql, compPowerBillId);
						
					
						

					}
				

				if (deletedRows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return deletedRows;
	
	}
	
	

	@Override
	public PowerBill getComponentPowerEditInfo(Integer compPowerBillId) throws ComponentUserException {

		String sql = SELECT_POWER_BILL_EDIT;

		final Double preunit = 0.0;
		try {
			PowerBill powerBill = (PowerBill)jdbcTemplate4.queryForObject(sql, new Object[] { compPowerBillId }, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					PowerBill pbill = new PowerBill();
					
					
					pbill.setCompPowerBillId(rs.getInt(1));
					pbill.setUnitId(rs.getInt(2));
					pbill.setProjectId(rs.getInt(3));
					pbill.setComponentId(rs.getInt(4));
					
					
					pbill.setBillDueDate(rs.getString(5));
					pbill.setBillDate(rs.getString(6));
					pbill.setDisconnectionDate(rs.getString(7));
					
					pbill.setConsumedUnits(rs.getDouble(8));
					pbill.setEnergyChargeRate(rs.getDouble(9));
					pbill.setEnergyCharges(rs.getDouble(10));
					pbill.setElectricityDutyRate(rs.getDouble(11));
					pbill.setElectricityDutyRate(rs.getDouble(12));
					pbill.setEletricityDutyInterest(rs.getDouble(13));					
					pbill.setDemandRate(rs.getDouble(14));
					pbill.setDemandCharges(rs.getDouble(15));
					pbill.setCustomerCharges(rs.getDouble(16));
					pbill.setLatePaySurCharge(rs.getDouble(17));
					pbill.setDelayPayInPaise(rs.getDouble(18));
					pbill.setACDSurCharges(rs.getDouble(19));
					pbill.setInterestSecurityDeposite(rs.getDouble(20));
					pbill.setTotalAmount(rs.getDouble(21));
					pbill.setPaidDate(rs.getString(22));
					pbill.setPaidAmount(rs.getDouble(23));
					pbill.setAdditionalSecurityDeposit(rs.getDouble(24));
					pbill.setPendingAmount(rs.getDouble(25));
					pbill.setPaidStatus(rs.getString(26));
					pbill.setRemarks(rs.getString(27));
					pbill.setBillYear(rs.getInt(28));
					pbill.setBillMonth(rs.getInt(29));
					pbill.setLiftMetres(rs.getDouble(30));
					pbill.setUnitrate(rs.getDouble(31));
					pbill.setQuantity(rs.getDouble(32));
					pbill.setDocumentNumer(rs.getString(33));
					pbill.setDocumentName(rs.getString(34));
					pbill.setDocumentPath(rs.getString(35));
					pbill.setBillNumber(rs.getString(36));
					pbill.setProjectName(rs.getString(37));					
					pbill.setUnitName(rs.getString(38));
				
					pbill.setComponentName(rs.getString(39));
					pbill.setFixedCharges(rs.getDouble(40));
					pbill.setVariableCharges(rs.getDouble(41));
					
					
					
					return pbill;

				}

			});
			
			//jdbcTemplate4.getDataSource().getConnection().close();
			return powerBill;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getComponentPowerEditInfo  method error due to " + ex.getMessage());
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
	public Integer updatePowerBill(final PowerBill powerBill) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_COMP_POWER_BILL;

		
		Integer updatedrows = 0;
		Double delayRate=0.0;
		
		Date billdate=null;
		Date billDuedate=null;
		Date disconnectoinDate=null;
		Date paidDate=null;
		
		
		
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (powerBill != null) {

				if (powerBill.getProjectId() != null && powerBill.getComponentId()!=null && powerBill.getTotalAmount()!=null ) {

					if (powerBill.getTotalAmount() > 0.0) {
						
						

						if (powerBill.getBillDate() != null && powerBill.getBillDate() != ""
								&& !powerBill.getBillDate().equals('0')) {

							billdate = DateUtil.getSQLDate(powerBill.getBillDate());

						}if (powerBill.getBillDueDate() != null && powerBill.getBillDueDate() != ""
								&& !powerBill.getBillDueDate().equals('0')) {

							billDuedate = DateUtil.getSQLDate(powerBill.getBillDueDate());

						}
						if (powerBill.getDisconnectionDate() != null && powerBill.getDisconnectionDate() != ""
								&& !powerBill.getDisconnectionDate().equals('0')) {

							disconnectoinDate = DateUtil.getSQLDate(powerBill.getDisconnectionDate());

						}
						if (powerBill.getPaidDate() != null && powerBill.getPaidDate() != ""
								&& !powerBill.getPaidDate().equals('0')) {

							paidDate = DateUtil.getSQLDate(powerBill.getPaidDate());

						}
					
						
						
						
						if(powerBill.getDelayPayInPaise()!=null||powerBill.getDelayPayInPaise()!=0){
							if(powerBill.getDelayPayInPaise()>0){
							delayRate=powerBill.getDelayPayInPaise();
							}
						}else if(powerBill.getDelayPayPerDay()!=null||powerBill.getDelayPayPerDay()!=0){
							if(powerBill.getDelayPayPerDay()>0){
							delayRate=powerBill.getDelayPayPerDay();
							}
						}

						

						updatedrows = jdbcTemplate4.update(sql,powerBill.getUnitId(), powerBill.getProjectId(),powerBill.getComponentId(),
								billDuedate,billdate,disconnectoinDate,powerBill.getConsumedUnits(),
								powerBill.getEnergyChargeRate(),powerBill.getEnergyCharges(), powerBill.getElectricityDutyRate(),powerBill.getElectricityDuty(),
								powerBill.getEletricityDutyInterest(),powerBill.getDemandRate(),powerBill.getDemandCharges(),powerBill.getCustomerCharges(),powerBill.getLatePaySurCharge(),
								delayRate,powerBill.getACDSurCharges(),powerBill.getInterestSecurityDeposite(),powerBill.getTotalAmount(),paidDate,
								powerBill.getPaidAmount(),powerBill.getAdditionalSecurityDeposit(),powerBill.getPendingAmount(),powerBill.getPaidStatusId(),powerBill.getRemarks(),
								powerBill.getBillYear(),powerBill.getBillMonth(),powerBill.getLiftMetres(),powerBill.getEnergyChargeRate(),powerBill.getQuantity(),
								powerBill.getUserId(),powerBill.getUserName(),1,powerBill.getDocumentNumer(),powerBill.getDocumentName(),powerBill.getDocumentPath(),powerBill.getBillNumber(),
								powerBill.getFixedCharges(),powerBill.getVariableCharges(),powerBill.getVariableOthers(),powerBill.getCompPowerBillId()
								);
						
						

						

					}
				}

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return updatedrows;
	}
	
	@Override
	public List<ComponentAyacut> getprojactmondata(User userObj) throws ComponentUserException {

		String sql = SELECT_PROJ_AYCT_MAN_DAT;

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> constList = jdbcTemplate4.query(sql, new RowMapper<ComponentAyacut>() {
				public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
					ComponentAyacut constsum = new ComponentAyacut();
					
					constsum.setProjAyacutId(rs.getInt(1));
					constsum.setProjectId(rs.getInt(2));
					constsum.setDistrictId(rs.getInt(3));
					constsum.setMandalId(rs.getInt(4));
					constsum.setVillageId(rs.getInt(5));
					constsum.setUnitId(rs.getInt(6));
					constsum.setCircleId(rs.getInt(7));
					constsum.setDivisionId(rs.getInt(8));
					constsum.setSubdivisionId(rs.getInt(9));
					constsum.setIrriagtedAyacut(rs.getDouble(10));
					constsum.setContemplatedAyacut(rs.getDouble(11));
					constsum.setStableAyacut(rs.getDouble(12));
					constsum.setAyacutCreated(rs.getDouble(13));
					constsum.setProjectName(rs.getString(14));
					constsum.setDistrictName(rs.getString(15));
					constsum.setMandalName(rs.getString(16));
					constsum.setVillageName(rs.getString(17));
					constsum.setRemarks(rs.getString(18));
					
					
				
		
					
					
					
					
					
					
					
					
					
					
					
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
	public Integer insertProjectSeasonCapacity(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_PROJ_SEASON_CAP;
		
		String sql2 = GET_COUNT_PROJ_SEASON_CAP;
		
		String sql3 = GET_PROJ_SEASON_CAP_ID;

		
		Integer updatedId = 0;
		
		Integer updatedOldId = 0;
		
		Integer updatedcap=0;
		
		Date obsdate=null;
		
		
		
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (ayacutObj != null) {

				if (ayacutObj.getProjectId() != null && ayacutObj.getSeasonId()!=null && ayacutObj.getActplanYear()!=null ) {

				
					
					List<Map<String, Object>> result = jdbcTemplate4.queryForList(sql2, new Object[]{ayacutObj.getProjectId(),ayacutObj.getSeasonId(),ayacutObj.getActplanYear()});
					 
					 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedcap = Integer.parseInt(row.get("proj_season_cap_id").toString());
							}
					 }
					
					 
					 if(updatedcap>0){
						 
						 List<Map<String, Object>> result1= jdbcTemplate4.queryForList(sql3, new Object[]{ayacutObj.getProjectId(),ayacutObj.getSeasonId(),ayacutObj.getActplanYear()});
			             
						 if(result1!=null){
							 
							 for (Map<String, Object> row : result1) {
								 updatedOldId=(Integer.parseInt(row.get("proj_season_cap_id").toString())); ;
								}
						 }
						 if(updatedOldId>0){
							
							 updatedId=-2;
							 
						 }
						 
					 }
					
						
						
                  
						if (ayacutObj.getObsDate() != null && ayacutObj.getObsDate() != ""
								&& !ayacutObj.getObsDate().equals('0')) {

							obsdate = DateUtil.getSQLDate(ayacutObj.getObsDate());

						}
					
						
						
						// System.out.println("updatedcap"+updatedcap);
						

						 if(updatedcap<1){

							 List<Map<String, Object>> result2 = jdbcTemplate4.queryForList(sql,
								                            ayacutObj.getProjectId(),
								                            ayacutObj.getSeasonId(),
								                            ayacutObj.getActplanYear(),
								                            ayacutObj.getPreWaterLevel(),
								                            ayacutObj.getPreWaterCap(),
								                            ayacutObj.getWaterUtil(),
								                            ayacutObj.getBalWaterRequired(),
								                            ayacutObj.getWaterRequired(),
								                              obsdate,
								                              ayacutObj.getRemarks(),
								                              ayacutObj.getUnitId(),
								                              ayacutObj.getCircleId(),
								                              ayacutObj.getDivisionId(),
								                              ayacutObj.getSubdivisionId(),
								                              ayacutObj.getUserName(),
								                              ayacutObj.getNoOfWettings()
								);
							 
							 if(result2!=null){
								 
								 for (Map<String, Object> row : result2) {
									 updatedId=(Integer.parseInt(row.get("proj_season_cap_id").toString()));
									}
								 
								// System.out.println("mst1outputdao"+mst1output);
							 }
						
						

						 }	

				
				
				}
				

				if (updatedId > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
				}
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		//System.out.println("updatedId"+updatedId);
		return updatedId;
	}
	
	@Override
	public ComponentAyacut getProjectSeasonCapEdit(ComponentAyacut compAyacut) throws ComponentUserException {

		String sql = GET_PROJ_SEASON_CAP_EDIT;

		final Double preunit = 0.0;
		try {
			ComponentAyacut compayacut = (ComponentAyacut) jdbcTemplate4.queryForObject(sql, new Object[] { compAyacut.getProjectseasonId() },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							ComponentAyacut comp = new ComponentAyacut();
							comp.setProjectseasonId(rs.getInt(1));
							comp.setProjectId(rs.getInt(2));
							comp.setSeasonId(rs.getInt(3));
							comp.setActplanYear(rs.getString(4));
							comp.setPreWaterLevel(rs.getDouble(5));
							comp.setPreWaterCap(rs.getDouble(6));
							comp.setWaterUtil(rs.getDouble(7));
							
							comp.setBalWaterRequired(rs.getDouble(8));
							comp.setWaterRequired(rs.getDouble(9));
							comp.setObsDate(rs.getString(10));
							comp.setRemarks(rs.getString(11));
							comp.setUnitId(rs.getInt(12));
							comp.setCircleId(rs.getInt(13));
							comp.setDivisionId(rs.getInt(14));
							comp.setSubdivisionId(rs.getInt(15));
							comp.setNoOfWettings(rs.getInt(16));
							
							return comp;

						}

					});
			return compayacut;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getProjectSeasonCapEdit  method error due to " + ex.getMessage());
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
	public Integer UpdateProjSeasonCapacity(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_PROJ_SEASON_CAP;

		
		Integer updatedrows = 0;
		Date obsdate=null;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (ayacutObj.getProjectseasonId() != null) {

				

					if (ayacutObj.getProjectseasonId()>0) {
               
						if (ayacutObj.getObsDate() != null && ayacutObj.getObsDate() != ""
								&& !ayacutObj.getObsDate().equals('0')) {

							try {
								obsdate = DateUtil.getSQLDate(ayacutObj.getObsDate());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					
						

						updatedrows = jdbcTemplate4.update(sql, 
								                        ayacutObj.getSeasonId(),
								                        ayacutObj.getPreWaterLevel(),
								                        ayacutObj.getPreWaterCap(),
								                        ayacutObj.getWaterUtil(),
								                        ayacutObj.getBalWaterRequired(),
								                        ayacutObj.getWaterRequired(),
								                        obsdate,
								                        ayacutObj.getRemarks(),
								                        ayacutObj.getUserName(),
								                        ayacutObj.getNoOfWettings(),
								                        ayacutObj.getProjectseasonId()
								                       
								                        
								                        
								                            );
						
					
						

					}
				

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return updatedrows;
	
	}
	
	
	@Override
	public Integer DeleteProjectSeasonCapacity(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_PROJ_SEASON_CAP;

		
		Integer updatedrows = 0;
		Date obsdate=null;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (ayacutObj.getProjectseasonId() != null) {

				

					if (ayacutObj.getProjectseasonId()>0) {
               
						
						

						updatedrows = jdbcTemplate4.update(sql, 
								                       
								                        ayacutObj.getUserName(),
								                        ayacutObj.getProjectseasonId()
								                        
								                        
								                            );
						
					
						

					}
				

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return updatedrows;
	
	}
	
	@Override
	public Integer insertProjectSeasonAyacut(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = INSERT_PROJ_SEASON_AYACUT;
		
		String sql2 = GET_COUNT_PROJ_SEASON_AYACUT;
		
		String sql3 = GET_PROJ_SEASON_AYACUT_ID;

		
		Integer updatedId = 0;
		
		Integer updatedoldId=0;
		
		Integer updatedcap=0;
		
		Date obsdate=null;
		
		
		
		//System.out.println("sql"+sql +ayacutObj.getProjectseasonId()+"  ----"+ayacutObj.getCropId()+" ----"+ayacutObj.getProjAyacutId()+" ----"+ayacutObj.getSeasonId());
		//System.out.println("sql2"+sql2);
		//System.out.println("sql3"+sql3);
		
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (ayacutObj != null) {

				if (ayacutObj.getProjectId() != null && ayacutObj.getSeasonId()!=null && ayacutObj.getProjectseasonId()!=null && ayacutObj.getSeasonId()!=null ) {

				
					
					List<Map<String, Object>> result = jdbcTemplate4.queryForList(sql2, new Object[]{ayacutObj.getProjectseasonId(),ayacutObj.getCropId(),ayacutObj.getProjAyacutId(),ayacutObj.getSeasonId()});
					 
					 if(result!=null){
						 
						 for (Map<String, Object> row : result) {
							 updatedcap = Integer.parseInt(row.get("proj_season_ayacut_id").toString());
							}
					 }
					
					 
					 if(updatedcap>0){
						 
						 List<Map<String, Object>> result1= jdbcTemplate4.queryForList(sql3, new Object[]{ayacutObj.getProjectseasonId(),ayacutObj.getCropId(),ayacutObj.getProjAyacutId(),ayacutObj.getSeasonId()});
			             
						 if(result1!=null){
							 
							 for (Map<String, Object> row : result1) {
								 updatedoldId=(Integer.parseInt(row.get("proj_season_ayacut_id").toString())); ;
								}
						 }
						 
						 if(updatedoldId>0){
							 
							 updatedId=-2;
							 
						 }
						 
						 
					 }
					
						
						
                  
						if (ayacutObj.getObsDate() != null && ayacutObj.getObsDate() != ""
								&& !ayacutObj.getObsDate().equals('0')) {

							obsdate = DateUtil.getSQLDate(ayacutObj.getObsDate());

						}
					
						
						
						// System.out.println("updatedcap"+updatedcap);
						

						 if(updatedcap<1){

							 List<Map<String, Object>> result2 = jdbcTemplate4.queryForList(sql,
								                            ayacutObj.getProjectseasonId(),
								                            ayacutObj.getProjectId(),
								                            ayacutObj.getSeasonId(),
								                            ayacutObj.getProjAyacutId(),
								                            ayacutObj.getCropId(),
								                            ayacutObj.getIrriagtedAyacut(),
								                            ayacutObj.getProposedAyacut(),
								                            obsdate,
								                            ayacutObj.getRemarks(),  
								                              ayacutObj.getUnitId(),
								                              ayacutObj.getCircleId(),
								                              ayacutObj.getDivisionId(),
								                              ayacutObj.getSubdivisionId(),
								                              ayacutObj.getUserName(),
								                              ayacutObj.getCropNames()
								);
							 
							 if(result2!=null){
								 
								 for (Map<String, Object> row : result2) {
									 updatedId=(Integer.parseInt(row.get("proj_season_ayacut_id").toString()));
									}
								 
								// System.out.println("mst1outputdao"+mst1output);
							 }
						
						

						 }	

				
				
				}
				

				if (updatedId > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
				}
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{ 
			
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return updatedId;
	}
	
	
	@Override
	public ComponentAyacut getProjectSeasonAyacutEdit(ComponentAyacut compObj) throws ComponentUserException {

		String sql = GET_PROJ_SEASON_AYACUT_EDIT;

		final Double preunit = 0.0;
		try {
			ComponentAyacut compayacut = (ComponentAyacut) jdbcTemplate4.queryForObject(sql, new Object[] { compObj.getProjSeasonAyacutId() },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							ComponentAyacut comp = new ComponentAyacut();
							comp.setProjSeasonAyacutId(rs.getInt(1));
							comp.setProjectseasonId(rs.getInt(2));
							comp.setProjectId(rs.getInt(3));							
							comp.setSeasonId(rs.getInt(4));
							comp.setProjAyacutId(rs.getInt(5));
							comp.setCropId(rs.getInt(6));
							comp.setIrriagtedAyacut(rs.getDouble(7));
							comp.setProposedAyacut(rs.getDouble(8));
							comp.setObsDate(rs.getString(9));
							
						
							comp.setRemarks(rs.getString(10));
							comp.setUnitId(rs.getInt(11));
							comp.setCircleId(rs.getInt(12));
							comp.setDivisionId(rs.getInt(13));
							comp.setSubdivisionId(rs.getInt(14));
							comp.setCropNames(rs.getString(15));
							
							return comp;

						}

					});
			return compayacut;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getProjectSeasonAyacutEdit  method error due to " + ex.getMessage());
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
	public Integer UpdateProjectSeasonAyacut(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = UPDATE_PROJ_SEASON_AYACUT;

		
		Integer updatedrows = 0;
		Date obsdate=null;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (ayacutObj.getProjSeasonAyacutId() != null) {

				

					if (ayacutObj.getProjSeasonAyacutId()>0) {
               
						if (ayacutObj.getObsDate() != null && ayacutObj.getObsDate() != ""
								&& !ayacutObj.getObsDate().equals('0')) {

							try {
								obsdate = DateUtil.getSQLDate(ayacutObj.getObsDate());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					
						

						updatedrows = jdbcTemplate4.update(sql, 
								                        ayacutObj.getCropId(),
								                        ayacutObj.getIrriagtedAyacut(),
								                        ayacutObj.getProposedAyacut(),
								                        obsdate,
								                        ayacutObj.getRemarks(),
								                        ayacutObj.getUserName(),
								                        ayacutObj.getCropNames(),
								                        ayacutObj.getProjSeasonAyacutId()
								                        
								                        
								                            );
						
					
						

					}
				

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return updatedrows;
	
	}
	
	
	@Override
	public Integer DeleteProjectSeasonAyacut(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub

		String sql = DELETE_PROJ_SEASON_AYACUT;

		
		Integer updatedrows = 0;
		Date obsdate=null;
		try {

			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);

			if (ayacutObj.getProjSeasonAyacutId() != null) {

				

					if (ayacutObj.getProjSeasonAyacutId()>0) {
               
						
						

						updatedrows = jdbcTemplate4.update(sql, 
								                       
								                        ayacutObj.getUserName(),
								                        ayacutObj.getProjSeasonAyacutId()
								                        
								                        
								                            );
						
					
						

					}
				

				if (updatedrows > 0) {

					jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
					
					
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{ 
		
			try {
				jdbcTemplate4.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return updatedrows;
	
	}
	
	
	
	@Override
	public List<ComponentAyacut> getProjSeasonCapInfo(ComponentAyacut compObj) throws ComponentUserException {

		String sql = GET_PROJ_SEASON_CAP_INFO;
		
		//System.out.println("kharif"+compObj.getKhrifactplanYear());
		//System.out.println("rabi"+compObj.getRabiactplanYear());

		final Double preunit = 0.0;
		try {
			List<ComponentAyacut> projListSeasonInfo =  jdbcTemplate4.query(sql, new Object[] { compObj.getUnitId(),compObj.getKhrifactplanYear(),compObj.getRabiactplanYear() },
					new RowMapper<ComponentAyacut>() {
						public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
							ComponentAyacut comp = new ComponentAyacut();
							comp.setProjectseasonId(rs.getInt(1));
							comp.setProjectId(rs.getInt(2));
							comp.setSeasonId(rs.getInt(3));
							comp.setActplanYear(rs.getString(4));
							comp.setPreWaterLevel(rs.getDouble(5));
							comp.setPreWaterCap(rs.getDouble(6));
							comp.setWaterUtil(rs.getDouble(7));
							
							comp.setBalWaterRequired(rs.getDouble(8));
							comp.setWaterRequired(rs.getDouble(9));
							comp.setObsDate(rs.getString(10));
							comp.setRemarks(rs.getString(11));
							comp.setUnitId(rs.getInt(12));
							comp.setCircleId(rs.getInt(13));
							comp.setDivisionId(rs.getInt(14));
							comp.setSubdivisionId(rs.getInt(15));
							comp.setNoOfWettings(rs.getInt(16));
							
							if(rs.getInt(3)==1){
								
								comp.setSeasonName("Vana Kalam / Kharif");
							}
							if(rs.getInt(3)==2){
								
								comp.setSeasonName("Yasangi / Rabi");
							}
							
							return comp;

						}

					});
			return projListSeasonInfo;

		} catch (Exception ex) {
			log.error("Inside ComponentDAOImpl getProjSeasonCapInfo  method error due to " + ex.getMessage());
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
public List<ComponentAyacut> getProjSeasonAyacutInfo(ComponentAyacut compObj) throws ComponentUserException {

	String sql = GET_PROJ_SEASON_AYACUT_INFO;

	final Double preunit = 0.0;
	try {
		List<ComponentAyacut> projListSeasonInfo =  jdbcTemplate4.query(sql, new Object[] { compObj.getProjAyacutId(),compObj.getProjectseasonId() },
				new RowMapper<ComponentAyacut>() {
					public ComponentAyacut mapRow(ResultSet rs, int rowNum) throws SQLException {
						ComponentAyacut comp = new ComponentAyacut();
						comp.setProjSeasonAyacutId(rs.getInt(1));
						comp.setProjectseasonId(rs.getInt(2));
						comp.setProjectId(rs.getInt(3));
						comp.setSeasonId(rs.getInt(4));
						comp.setProjAyacutId(rs.getInt(5));
						comp.setCropId(rs.getInt(6));
						comp.setIrriagtedAyacut(rs.getDouble(7));
						
						comp.setProposedAyacut(rs.getDouble(8));
						comp.setObsDate(rs.getString(9));
						
						comp.setRemarks(rs.getString(10));
						comp.setUnitId(rs.getInt(11));
						comp.setCircleId(rs.getInt(12));
						comp.setDivisionId(rs.getInt(13));
						comp.setSubdivisionId(rs.getInt(14));
						comp.setCropNames(rs.getString(15));
						
						if(rs.getInt(6)==1){
							
							comp.setCropName("ID");
						}
						if(rs.getInt(6)==2){
							
							comp.setCropName("Wet");
						}
						
						return comp;

					}

				});
		return projListSeasonInfo;

	} catch (Exception ex) {
		log.error("Inside ComponentDAOImpl getProjSeasonAyacutInfo  method error due to " + ex.getMessage());
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
public Integer getCountOfCadAyacutKmlDocs() throws ComponentUserException{
	// TODO Auto-generated method stub
	
	String sql = COUNT_CADKML_DOCS;

	Integer rows1 = 0;
	
	
	Integer filerows=0;
	
	 java.sql.Date date1 = null;
	try {

		jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
		List<Map<String, Object>> 	ct=	jdbcTemplate4.queryForList(sql );
		
		
		for (Map<String, Object> row : ct) {
			rows1 = Integer.parseInt(row.get("doccount").toString());
		}
		
         // System.out.println("rows1"+rows1) ;
			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
			
			
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 

	return rows1;
}

@Override
public Integer insertCadAyacutKmlDocuments(final ComponentAyacut  compobj) throws ComponentUserException {
	// TODO Auto-generated method stub
	
	String sql2 = INSERT_CADKML_DOCUMENTS;
			
	

	Integer rows1 = 0;
	int[] j = null;
	Integer filerows=0;
	
	
	try {

		jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
		
		if(compobj.getCadkmldocs()!=null){
	
         //	System.out.println("coming here");
  			//System.out.println(midocObj.getPhotosList().get(0).getFormDocName());
			
				if( compobj.getUnitId()!=null && compobj.getProjectId()!=null && compobj.getCadkmldocs().get(0).getDocName()!=null && compobj.getCadkmldocs().get(0).getDocOriginalName()!=" " ){
				j = jdbcTemplate4.batchUpdate(sql2,		new BatchPreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps, int i)
									throws SQLException {

								CadAyacutKmlDocs sd = compobj.getCadkmldocs().get(i);
							
								  ps.setInt(1,  compobj.getProjectId());
									ps.setInt(2, compobj.getUnitId());
									ps.setInt(3, compobj.getCircleId());
								ps.setInt(4, compobj.getDivisionId());
								ps.setInt(5, compobj.getSubdivisionId());
								ps.setLong(6, compobj.getPostId());
								
								ps.setString(7, sd.getDocOriginalName());
								ps.setString(8, sd.getDocName());
								ps.setString(9, sd.getDocLocation());
								 ps.setString(10,  compobj.getUserName());
								
							}

							@Override
							public int getBatchSize() {
								return compobj.getCadkmldocs().size();
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
		
            
			jdbcTemplate4.getDataSource().getConnection().setAutoCommit(true);
			
			
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return rows1;
}

@Override
public Integer deleteCADKMLbyId(final CadAyacutKmlDocs caddocs) throws ComponentUserException {
	// TODO Auto-generated method stub
	
	String sql3 = DELETE_CADKML_ID;	
	
	//System.out.println(DELETE_FRM_DOCS_DOCID);
	
Integer rows1=0;

	try {
		
		//System.out.println("miformObj.getFormdocId()"+miformObj.getFormdocId()+"---"+miformObj.getUserName());

		jdbcTemplate4.getDataSource().getConnection().setAutoCommit(false);
		 if(caddocs!=null){
         	
			 //System.out.println("coming here"+miformObj.getFormdocId()+"---"+miformObj.getUserName());
				 if( caddocs.getCadkmlId()!=null  ){
					 rows1 = jdbcTemplate4.update(sql3,caddocs.getUserName(),caddocs.getCadkmlId());	
			
			}
		
		 
		 }
		 

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return rows1;
}

@Override
public List<CadAyacutKmlDocs> getCadAyacutkmlbyUnitInfo(ComponentAyacut compObj) throws ComponentUserException {

	String sql = SELECT_CADKML_BY_UNIT;
	
	if(compObj.getUnitId()==4 || compObj.getUnitId()==9832 ){
		
		 sql = SELECT_CADKML_BY_UNIT + " and caak.delete_flag=false and caak.is_latest=true   order by cad_kml_id desc ";
		
	}else if (compObj.getUnitId()!=4 || compObj.getUnitId()!=9832){
		
		 sql = SELECT_CADKML_BY_UNIT + " where caak.unit_id= "+compObj.getUnitId() +" and caak.delete_flag=false and caak.is_latest=true   order by cad_kml_id desc ";
	}

	final Double preunit = 0.0;
	try {
		List<CadAyacutKmlDocs> projListcadAyacutInfo =  jdbcTemplate4.query(sql, new Object[] {  },
				new RowMapper<CadAyacutKmlDocs>() {
					public CadAyacutKmlDocs mapRow(ResultSet rs, int rowNum) throws SQLException {
						CadAyacutKmlDocs comp = new CadAyacutKmlDocs();
						comp.setCadkmlId(rs.getInt(1))	;				
						comp.setProjectId(rs.getInt(2));
						comp.setUnitId(rs.getInt(3));
						comp.setCircleId(rs.getInt(4));
						comp.setDivisionId(rs.getInt(5));
						comp.setSubdivisionId(rs.getInt(6));
						comp.setPostId(rs.getLong(7));
						comp.setDocOriginalName(rs.getString(8));
						comp.setDocName(rs.getString(9));
						comp.setDocLocation(rs.getString(10));
						comp.setUnitName(rs.getString(11));
						comp.setProjectName(rs.getString(12));
						comp.setSubmitteddate(rs.getString(13));
						return comp;
				

					}

				});
		return projListcadAyacutInfo;

	} catch (Exception ex) {
		log.error("Inside ComponentDAOImpl getCadAyacutkmlbyUnitInfo  method error due to " + ex.getMessage());
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


}
