FROM maven:3-jdk-8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} expat-2.3.5.jar
ENTRYPOINT ["java","-jar","/expat-2.3.5.jar"]