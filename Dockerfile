FROM tomcat
EXPOSE 6789
WORKDIR /app
COPY target/hardwareManagement.jar .
RUN chmod +x hardwareManagement.jar
CMD ["java", "-jar", "/app/hardwareManagement.jar"]
