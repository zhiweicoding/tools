FROM openjdk:11-jre

WORKDIR /app
ARG JAR_FILE
ADD target/${JAR_FILE} /app/chat.jar
EXPOSE 443
ENV JAVA_OPTIONS "-Xms1g -Xmx2g -Dfile.encoding=UTF-8 "
ENV OVERRIDE_PROP ""

ENTRYPOINT ["java", "-jar", "/app/chat.jar"]