FROM tomcat
EXPOSE 6666
WORKDIR /app
COPY target/schulhardware.jar .
# RUN chmod +x emberAPI.jar
CMD ["java", "-jar", "/app/schulhardware.jar"]