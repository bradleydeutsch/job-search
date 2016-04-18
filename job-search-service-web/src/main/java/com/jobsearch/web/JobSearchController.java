package com.jobsearch.web;

import com.jobsearch.git.GitRepositoryConfiguration.GitRepositoryState;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

import static org.springframework.http.HttpStatus.OK;

@Api(value = "Job Search Health Controller", description = "Health Controller")
@RestController
@RequestMapping(value = "/v1", method = RequestMethod.GET)
public class JobSearchController {

    private static final String SERVICE_ALIVE_MESSAGE = "\"Service alive\"";

    private final GitRepositoryState repositoryState;

    @Autowired
    public JobSearchController(GitRepositoryState repositoryState) {
        this.repositoryState = repositoryState;
    }

    @RequestMapping(value = "/health/ping")
    @ResponseStatus(OK)
    @Nonnull
    public String ping() {

        return SERVICE_ALIVE_MESSAGE;
    }

    @RequestMapping(value = "/version")
    @ResponseStatus(OK)
    @Nonnull
    public GitRepositoryState version() {

        return repositoryState;
    }
}
