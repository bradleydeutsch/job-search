package com.jobsearch;

import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class WebApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(JobSearchServiceConfiguration.class)
                .bannerMode(Banner.Mode.LOG)
                .logStartupInfo(true)
                .run(args);
	}
}
