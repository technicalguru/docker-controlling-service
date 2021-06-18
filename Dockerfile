FROM openjdk:14-jdk-alpine
RUN addgroup -S spring \
    && adduser -S spring -G spring

# copy the application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /home/spring/app.jar
RUN    mkdir /home/spring/config \
    && chmod 777 /home/spring/app.jar \
    && chmod 777 /home/spring/config \
    && chown -R spring:spring /home/spring

# Define running params
USER spring:spring
WORKDIR /home/spring
#ENTRYPOINT ["java","-jar","/home/spring/app.jar"]
ENTRYPOINT ["sleep","3600"]

# This part shall build layered but maven does not build like this yet
# ARG DEPENDENCY=target/dependency
#
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#
#ENTRYPOINT ["java","-cp","app:app/lib/*","rs.controlling.svc.ServiceForControllingApplication"]


