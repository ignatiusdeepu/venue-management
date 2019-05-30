package com.netinsight.scheduall.venue.management.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netinsight.scheduall.venue.management.config.VenueDetailsConfig;
import com.netinsight.scheduall.venue.management.dao.VenueRepository;
import com.netinsight.scheduall.venue.management.domain.response.VenueDetails;

@Repository("venueRepository")
public class VenueRepositoryImpl implements VenueRepository {

	private static final Logger logger = LoggerFactory.getLogger(VenueRepositoryImpl.class);

	@Autowired
	VenueDetailsConfig venueDetailsConfig;
	
	@Override
	public List<VenueDetails> findAll() {
		logger.info("Inside VenueRepositoryImpl::findAll");
		return venueDetailsConfig.getVenueDetailsList();
	}
	
}
