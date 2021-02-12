package com.careerbuilder.datascience.deduplication;

import com.careerbuilder.datascience.blankspace.response.ServiceResponse;

public class Response implements ServiceResponse {
	String text;

	public Response(String text) {
		this.text = text;
	}

	@Override
	public boolean useDataNode() {
		return false;
	}
}
