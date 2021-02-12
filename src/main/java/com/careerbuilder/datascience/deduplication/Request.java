package com.careerbuilder.datascience.deduplication;

import com.careerbuilder.datascience.blankspace.exceptions.BadRequestException;
import com.careerbuilder.datascience.blankspace.request.ServiceRequest;

public class Request implements ServiceRequest {
	String text;

	@Override
	public void validate() {
		if (text == null) {
			throw new BadRequestException("Invalid input", "The text parameter must be provided.",
					null);
		}
	}
}
