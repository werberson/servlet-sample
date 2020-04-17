FROM maven:3.6.1-jdk-8 as builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src src
RUN mvn package

FROM tomcat:8.0-alpine

COPY --from=builder /app/target/servlet-sample-*.war /usr/local/tomcat/webapps/app.war

EXPOSE 8080
CMD ["catalina.sh", "run"]