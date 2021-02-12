package com.careerbuilder.datascience.deduplication;

import com.careerbuilder.datascience.blankspace.request.RequestHandler;

public class Handler implements RequestHandler<Request> {

	@Override
	public Response handleRequest(Request req) {
		String uppercaseText = req.text.toUpperCase();
		return new Response(uppercaseText);
	}
}
