package com.myspringlearnings.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDAO {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getAllOffers() {
		return jdbc.query("select * from offers", new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("ID"));
				offer.setName(rs.getString("Name"));
				offer.setEmail(rs.getString("Email"));
				offer.setText(rs.getString("Text"));

				return offer;
			}
		});
	}

	public boolean create(Offer offer) {

		// ////////////////////////////////////////////////////////////////////////////
		// BeanPropertySqlParameterSource
		//
		// It creates set of params to replace placeholder in sql from actual
		// bean properties
		//
		// ////////////////////////////////////////////////////////////////////////////

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
				offer);

		return jdbc
				.update("insert into offers(Name, Email,Text) values(:name,:email,:text )",
						params) == 1;
	}

	@Transactional
	public int[] create(List<Offer> offers) {

		SqlParameterSource[] params = SqlParameterSourceUtils
				.createBatch(offers.toArray());
		System.out.println("its me");

		return jdbc
				.batchUpdate(
						"insert into offers (id, name, text, email) values (:id, :name, :text, :email)",
						params);
	}

}
