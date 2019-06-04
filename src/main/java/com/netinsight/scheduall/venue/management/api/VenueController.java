package com.netinsight.scheduall.venue.management.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netinsight.scheduall.core.domain.response.StandardResponse;
import com.netinsight.scheduall.venue.management.domain.response.VenueDetails;
import com.netinsight.scheduall.venue.management.service.VenueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/venue")
@RestController
@RequestMapping("/venue")
public class VenueController {
	
	private static final Logger logger = LoggerFactory.getLogger(VenueController.class);
	
	@Autowired
	VenueService venueService;
	
	@ApiOperation(value = "Returns the list of all the Venue Details")
	@GetMapping(path = "/list", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse<List<VenueDetails>> listAll() throws Exception {
		logger.info("Begin VenueController::listAll");
		final StandardResponse<List<VenueDetails>> standardResponse = new StandardResponse<List<VenueDetails>>();
		standardResponse.setResponseOK();
		standardResponse.setData(venueService.listAll());
		logger.info("End VenueController::listAll");
		return standardResponse;
	}
	
}
