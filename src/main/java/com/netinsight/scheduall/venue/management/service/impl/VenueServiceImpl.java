package com.netinsight.scheduall.venue.management.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netinsight.scheduall.core.exception.ApplicationException;
import com.netinsight.scheduall.venue.management.dao.VenueRepository;
import com.netinsight.scheduall.venue.management.domain.response.VenueDetails;
import com.netinsight.scheduall.venue.management.service.VenueService;

@Service("venueService")
public class VenueServiceImpl implements VenueService{

	private static final Logger logger = LoggerFactory.getLogger(VenueServiceImpl.class);
	
	@Autowired
	VenueRepository venueRepository;
	
	@Override
	public  List<VenueDetails> listAll() {
		logger.info("Begin VenueServiceImpl::listAll");
		 List<VenueDetails> venueDetailsList = venueRepository.findAll();
		logger.info("Begin VenueServiceImpl::listAll");
		throw new ApplicationException("asd");
		//return venueDetailsList;
	}
	
}
