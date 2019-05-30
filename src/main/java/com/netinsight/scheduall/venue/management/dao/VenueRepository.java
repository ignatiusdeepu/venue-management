package com.netinsight.scheduall.venue.management.dao;

import java.util.List;

import com.netinsight.scheduall.venue.management.domain.response.VenueDetails;

public interface VenueRepository{

	 List<VenueDetails> findAll();
	
}
