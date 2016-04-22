package com.jobsearch.web;

import com.jobsearch.git.GitRepositoryConfiguration.GitRepositoryState;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.HttpStatus.OK;

@Api(
        basePath = "/v1",
        value = "Health Controller",
        description = "Health Controller"
)
@RestController
@RequestMapping(value = "/v1", method = RequestMethod.GET)
public class HealthController {

    private static final String SERVICE_ALIVE_MESSAGE = "\"Service alive\"";

    private final GitRepositoryState repositoryState;

    @Autowired
    public HealthController(GitRepositoryState repositoryState) {
        this.repositoryState = repositoryState;
    }

    @RequestMapping(value = "/health/ping")
    @ApiOperation(
            value = "Check health of the application",
            code = SC_OK,
            response = String.class
    )
    @ResponseStatus(OK)
    @Nonnull
    public String ping() {

        return SERVICE_ALIVE_MESSAGE;
    }

    @RequestMapping(value = "/version")
    @ApiOperation(
            value = "Get the application version information",
            code = SC_OK,
            response = GitRepositoryState.class
    )
    @ResponseStatus(OK)
    @Nonnull
    public GitRepositoryState version() {

        return repositoryState;
    }
}
