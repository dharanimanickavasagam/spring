package com.myspringlearnings.spring.dao_pattern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("offersDao")
public class OffersDAO {

	// JdbcTemplate is used from the jar, spring-jdbc
	private NamedParameterJdbcTemplate jdbc;

	// //////////////////////////////////////////////////////////////////////////////
	//
	// OffersDAO is the class that connects with the database and does CRUD
	//
	// So it has to be linked with the BasicDataSource Class that connects DB
	// There is a 'dataSource' bean with defined properties in bean.xml that is
	// needed for sql connection
	//
	//
	// JdbcTemplate ?
	//
	// It simplifies the use of JDBC and helps to avoid common errors.
	// It executes core JDBC workflow, leaving application code to provide SQL
	// and extract results. This class executes SQL queries or updates,
	// initiating iteration over ResultSets
	//
	// setDataSource()
	//
	// this method builds a JDBC Template for the Data Source,jdbcConnectionBean
	// jdbcConnectionBean contains the results to be worked with
	// DataSource comes from class="org.apache.commons.dbcp.BasicDataSource"
	// so it has to be wired
	//
	// It's because there is a dataSource bean that provides the connection to
	// the database, but there is no JdbcTemplate bean. So it's easy just to
	// get the dataSource and create the JdbcTemplate object
	//
	//
	// Check JdbcTemplate constructor to get a clear understanding
	//
	// /////////////////////////////////////////////////////////////////////////////

	@Autowired
	public void setDataSource(DataSource jdbcConnectionBean) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbcConnectionBean);
	}

	// //////////////////////////////////////////////////////////////////////////////
	//
	// RowMapper
	// Allows to map a single result of a query (i.e jdbc object) with a single
	// offer object
	//
	// NamedParameterJdbcTemplate
	// Use it for prepared statements alike query
	//
	// ///////////////////////////////////////////////////////////////////////////////

	public List<Offer> getAllOffers() {

		MapSqlParameterSource params = new MapSqlParameterSource("Name", "Achu");

		return jdbc.query("select * from offers where Name = :Name", params,
				new RowMapper<Offer>() {

					public Offer mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						Offer offer = new Offer();
						offer.setId(rs.getInt("ID"));
						offer.setName(rs.getString("Name"));
						offer.setEmail(rs.getString("Email"));
						offer.setText(rs.getString("Text"));
						return offer;
					}
				});
	}

	public Offer getSpecifiedOffer(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID", id);
		// queryForObject returns single record

		return jdbc.queryForObject("select * from offers where ID = :ID",
				params, new RowMapper<Offer>() {

					public Offer mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						Offer offer = new Offer();
						offer.setId(rs.getInt("ID"));
						offer.setName(rs.getString("Name"));
						offer.setEmail(rs.getString("Email"));
						offer.setText(rs.getString("Text"));
						return offer;
					}
				});
	}

	
	public boolean create(List<Offer> list ) {
		
		
		return false; 
		
	}
	
	public boolean delete(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID", id);

		return (jdbc.update("delete from offers where ID= :ID", params)) == 1;
	}

}
