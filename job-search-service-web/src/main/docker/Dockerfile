FROM java:openjdk-8u72-jdk

VOLUME /tmp # Spring Boot creates a working directory of /tmp
ADD job-search-service.jar job-search-service.jar
RUN sh -c 'touch /job-search-service.jar' # To give the jar a modification time as Docker creates all container files in an unmodified state
ENTRYPOINT ["java", "-jar", "/job-search-service.jar"]