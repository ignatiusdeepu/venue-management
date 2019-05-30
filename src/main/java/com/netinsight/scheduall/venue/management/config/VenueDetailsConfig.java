/**
 * 
 */
package com.netinsight.scheduall.venue.management.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.netinsight.scheduall.venue.management.domain.response.VenueDetails;

/**
 * @author ignatiusjoseph
 *
 */
@ConfigurationProperties(prefix = "venue-details")
@EnableConfigurationProperties
@Component("VenueDetailsConfig")
public class VenueDetailsConfig {

	private List<VenueDetails> venueDetailsList = new ArrayList<>();

	public List<VenueDetails> getVenueDetailsList() {
		return venueDetailsList;
	}

	public void setVenueDetailsList(List<VenueDetails> venueDetailsList) {
		this.venueDetailsList = venueDetailsList;
	}

}
