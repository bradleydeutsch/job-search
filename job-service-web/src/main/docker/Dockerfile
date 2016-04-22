FROM java:openjdk-8u72-jdk

ADD job-service.jar job-service.jar
RUN sh -c 'touch /job-service.jar' # To give the jar a modification time as Docker creates all container files in an unmodified state
ENTRYPOINT ["java", "-jar", "/job-service.jar"]