package com.jobsearch.web;

import com.jayway.restassured.RestAssured;
import com.jobsearch.WebApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.HttpStatus.CREATED;

@SpringApplicationConfiguration(classes = WebApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest(randomPort = true)
public class ITJobSearchControllerTest {

    //@Value("${local.server.port}")
    private int serverPort = 3452;

    @Before
    public void before() {
        RestAssured.port = serverPort;
    }

    @Test
    public void pingWillReturnServiceStatus() {

        final String body =
                when()
                        .get("/v1/health/ping")
                .then()
                        .statusCode(is(CREATED.value()))
                .extract()
                        .body().asString();
    }
}
