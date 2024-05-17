# Stage 1: Build the application
FROM maven:3.9.5-sapmachine-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B -q
COPY src ./src
RUN mvn clean package

# Stage 2: Run the application on Tomcat
FROM tomcat:10.1.19-jdk17
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]