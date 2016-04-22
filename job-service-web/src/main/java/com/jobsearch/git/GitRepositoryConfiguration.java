package com.jobsearch.git;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:git.properties", ignoreResourceNotFound = true)
public class GitRepositoryConfiguration {

    @Bean
    public GitRepositoryState gitRepositoryInformation() {
        return new GitRepositoryState();
    }

    public static class GitRepositoryState {

        @JsonProperty
        @Value("${git.branch:null}")
        String branch;
        @JsonProperty
        @Value("${git.tags:null}")
        String tags;
        @JsonProperty
        @Value("${git.commit.id:null}")
        String commitId;
        @JsonProperty
        @Value("${git.build.time:null}")
        String buildTime;
        @JsonProperty
        @Value("${git.commit.user.name:null}")
        String commitUserName;
        @JsonProperty
        @Value("${git.commit.message.full:null}")
        String commitMessageFull;
        @JsonProperty
        @Value("${git.commit.time:null}")
        String commitTime;
        @JsonProperty
        @Value("${git.commit.id.describe:null}")
        String commitDescription;
    }
}
