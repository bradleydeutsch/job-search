package com.jobsearch.web;

import com.jayway.restassured.RestAssured;
import com.jobsearch.JobSearchServiceConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.HttpStatus.OK;

@SpringApplicationConfiguration(classes = {JobSearchServiceConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest(randomPort = true)
public class ITJobSearchControllerTest {

    @Value("${local.server.port}")
    private int serverPort;

    @Before
    public void before() {
        RestAssured.port = serverPort;
    }

    @Test
    public void pingWillReturnServiceStatus() {

        // when
        final String body =
                when()
                        .get("/v1/health/ping")
                .then()
                        .statusCode(is(OK.value()))
                .extract()
                        .body().asString();

        // then
        assertThat(body).isEqualTo("\"Service alive\"");
    }

    @Test
    public void versionWillReturnVersionInformationForTheApplication() {

        // when
        final String body =
                when()
                        .get("/v1/version")
                    .then()
                        .statusCode(is(OK.value()))
                    .extract()
                        .body().asString();

        // then
        assertThat(body).isEqualTo("{" +
                "\"branch\":\"test-branch\"," +
                "\"tags\":\"test-tag\"," +
                "\"commitId\":\"1234567890\"," +
                "\"buildTime\":\"build-time\"," +
                "\"commitUserName\":\"username\"," +
                "\"commitMessageFull\":\"message\"," +
                "\"commitTime\":\"commit-time\"," +
                "\"commitDescription\":\"comments\"" +
                "}");
    }
}
