FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
EXPOSE 8080
RUN mkdir micronaut-upload
RUN cd micronaut-upload
COPY ./ micronaut-upload/
WORKDIR /micronaut-upload
#CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar micronaut-upload.jar
CMD ./gradlew --info clean test
