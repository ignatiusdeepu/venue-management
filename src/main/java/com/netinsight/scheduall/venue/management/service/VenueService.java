package com.netinsight.scheduall.venue.management.service;

import java.util.List;

import com.netinsight.scheduall.venue.management.domain.response.VenueDetails;

public interface VenueService {

	List<VenueDetails> listAll();
	
}
