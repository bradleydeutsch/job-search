package com.jobsearch.web;

import com.jobsearch.git.GitRepositoryConfiguration.GitRepositoryState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class HealthControllerUnitTest {

    private HealthController sut;

    @Mock
    private GitRepositoryState gitRepositoryState;

    @Before
    public void before() {
        sut = new HealthController(gitRepositoryState);
    }

    @Test
    public void pingWillReturnAliveMessage() {

        // when
        final String result = sut.ping();

        // then
        assertThat(result).isEqualTo("\"Service alive\"");
    }

    @Test
    public void versionWillReturnTheCurrentGitRepositoryState() {

        // when
        final GitRepositoryState result = sut.version();

        // then
        assertThat(result).isSameAs(gitRepositoryState);
    }
}