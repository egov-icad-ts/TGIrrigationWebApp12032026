package in.ts.icad.leagal.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.LeagalWebDAO;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.manager.LeagalWebManager;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.Courts;

@Component
public class LeagalWebManagerImpl implements LeagalWebManager {

	@Autowired
	private LeagalWebDAO leagalWebDAO;
	

}
