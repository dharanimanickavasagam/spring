package com.myspringlearnings.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspringlearnings.spring.web.dao.Offer;
import com.myspringlearnings.spring.web.dao.OffersDAO;

// Equivalent of @Component, by giving different meaning 

@Service("offersService")
public class OffersService {

	private OffersDAO offersDao;

	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}

	public List<Offer> getCurrent() {
		return offersDao.getAllOffers();
	}

	public void create(Offer offer) {
		offersDao.create(offer);

	}
}
