package ca.sheridancollege.yussufa.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yussufa.beans.Voter;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertVoter(Voter voter) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "INSERT INTO voter(name, candidate) VALUES (:name, :candidate)";
		
		namedParameters.addValue("name", voter.getName());
		namedParameters.addValue("candidate", voter.getCandidate());

		int rowsAffected = jdbc.update(query,  namedParameters);
		
		if(rowsAffected > 0) {
			System.out.println("A Voter was inserted into DB");
		}
	}
	
	public List<Voter> getVoterList(){
		
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
			
		
		String query = "SELECT * FROM voter";
		
		
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Voter>(Voter.class));
	}
}
