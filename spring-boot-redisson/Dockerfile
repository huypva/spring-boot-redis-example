FROM maven:3.6.3-jdk-11 AS builder
WORKDIR /workdir/spring-boot-redisson
COPY pom.xml /workdir/spring-boot-redisson/pom.xml
RUN mvn dependency:go-offline

COPY src /workdir/spring-boot-redisson/src
RUN mvn -DskipTests=true install
RUN mkdir  -p target/depency
WORKDIR /workdir/spring-boot-redisson/target/dependency
RUN jar -xf ../*.jar

FROM openjdk:11-jre-slim

EXPOSE 8081
VOLUME /tmp
ARG DEPENDENCY=/workdir/spring-boot-redisson/target/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","io.codebyexample.springbootredisson.SpringBootRedissonApplication"]
