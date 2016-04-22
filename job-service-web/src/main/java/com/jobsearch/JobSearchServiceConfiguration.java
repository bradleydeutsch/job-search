package com.jobsearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "com.jobsearch.git",
        "com.jobsearch.web"
})
public class JobSearchServiceConfiguration {
}
