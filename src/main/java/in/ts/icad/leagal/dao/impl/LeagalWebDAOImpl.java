package in.ts.icad.leagal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.poi.util.SystemOutLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ts.icad.leagal.dao.LeagalWebDAO;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.Courts;

@Repository
public class LeagalWebDAOImpl implements LeagalWebDAO{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private final boolean IS_DEBUG_ENABLED = log.isDebugEnabled();

	private JdbcTemplate jdbcTemplate;
	
	
	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//private JdbcTemplate jdbcHrmsTemplate;

	/*@Resource(name = "dataSource1")
	public void setDataSource1(DataSource dataSource) {
		this.jdbcHrmsTemplate = new JdbcTemplate(dataSource);
	}*/

	
	
	
	

	


}
