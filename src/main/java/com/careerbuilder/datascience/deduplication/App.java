package com.careerbuilder.datascience.deduplication;

import com.careerbuilder.datascience.blankspace.auth.AuthenticationChain;
import com.careerbuilder.datascience.blankspace.request.RequestLeniency;
import com.careerbuilder.datascience.blankspace.resource.AppConfiguration;
import com.careerbuilder.datascience.blankspace.resource.BaseApp;
import com.careerbuilder.datascience.blankspace.resource.ResourceConfiguration;
import com.careerbuilder.datascience.blankspace.resource.RouteConfiguration;
import com.careerbuilder.datascience.blankspace.resource.RouteVersionConfig;

public class App extends BaseApp {
	private static final String PUBLIC_ROUTE = "/core/deduplication/job";
	private static final String INTERNAL_ROUTE = PUBLIC_ROUTE;

	public App() {
		super(appConfig());
	}

	private static AppConfiguration appConfig() {
		RouteConfiguration routeConfig = RouteConfiguration.builder(versionConfig()).build();
		return AppConfiguration.builder(INTERNAL_ROUTE, routeConfig).build(App::healthCheck);
	}

	static RouteVersionConfig versionConfig() {
		return RouteVersionConfig.buildGetAndPost("1.0", resourceConfig());
	}

	static ResourceConfiguration<Request, Response> resourceConfig() {
		return ResourceConfiguration
				.builder(Request.class, Response.class, Handler::new)
				.requestLeniency(RequestLeniency.ERROR)
				.build(AuthenticationChain.jwtOnly(PUBLIC_ROUTE));
	}

	private static boolean healthCheck() {
		Request req = new Request();
		req.text = "hello world";
		new Handler().handleRequest(req);
		return true;
	}
}
