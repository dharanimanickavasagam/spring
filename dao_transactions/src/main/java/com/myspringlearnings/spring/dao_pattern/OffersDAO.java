package com.myspringlearnings.spring.dao_pattern;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	// It executes core JDBC work flow, leaving application code to provide SQL
	// and extract results. This class executes SQL queries or updates,
	// initiating iteration over ResultSets
	//
	// setDataSource()
	//
	// this method builds a JDBC Template for the Data Source,jdbcConnectionBean
	// jdbcConnectionBean contains the results to be worked with.
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

	@Transactional("transactionManager")
	
	public int[] create(List<Offer> offers) {

		// ///////////////////////////////////////////////////////////////////////
		//
		// batchUpdate
		// Similar to batch updates of prepared statements in java
		// Efficient method to do
		//
		// SqlParameterSource - Handles runtime mapping of values to the sql
		// SqlParameterSourceUtils - Class that provides helper methods for the
		// use of {@link SqlParameterSource},in particular with {@link
		// NamedParameterJdbcTemplate}
		//
		// createBatch
		// Create an array of {@link SqlParameterSource} objects populated with
		// data from the values passed in (either a {@link Map} or a bean
		// object).This will define what is included in a batch operation.
		//
		// ///////////////////////////////////////////////////////////////////////

		SqlParameterSource[] params = SqlParameterSourceUtils
				.createBatch(offers);

		return jdbc
				.batchUpdate(
						"insert into offers(ID,Name, Email,Text) values(:id,:name,:email,:text )",
						params);
	}

}
