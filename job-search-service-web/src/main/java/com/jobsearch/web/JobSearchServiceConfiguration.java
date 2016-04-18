package com.jobsearch.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({
        "com.jobsearch.git",
        "com.jobsearch.web"
})
public class JobSearchServiceConfiguration {
}
