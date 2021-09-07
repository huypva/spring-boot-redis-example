The example project for StringBoot service

<div align="center">
    <img src="./assets/images/spring_boot_icon.png"/>
</div>

## Getting Started

## Project structure
```
.
├── spring-boot-redisson
│   ├── Dockerfile
│   ...
├── docker-compose.yaml
|
└── README.md
```

## Prerequisites
- Make sure that you have Docker and Docker Compose installed
  - Windows or macOS:
    [Install Docker Desktop](https://www.docker.com/get-started)
  - Linux: [Install Docker](https://www.docker.com/get-started) and then
    [Docker Compose](https://github.com/docker/compose)

## Start project
### Start project in local

- Install & start [redis](https://redis.io/)


- Start example
```
$ cd spring-boot-redisson
$ mvn clean package
$ mvn spring-boot:run
...
2021-09-07 10:54:34.188  INFO 3909 --- [isson-netty-2-5] o.r.c.pool.MasterPubSubConnectionPool    : 1 connections initialized for 127.0.0.1/127.0.0.1:6379
2021-09-07 10:54:34.201  INFO 3909 --- [isson-netty-2-7] o.r.c.pool.MasterConnectionPool          : 10 connections initialized for 127.0.0.1/127.0.0.1:6379
2021-09-07 10:54:35.083  INFO 3909 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2021-09-07 10:54:35.149  INFO 3909 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8081 (http) with context path ''
2021-09-07 10:54:35.172  INFO 3909 --- [           main] i.c.s.SpringBootRedissonApplication      : Started SpringBootRedissonApplication in 6.177 seconds (JVM running for 7.102)
```

### Start project in docker 

- Start project

```console
docker-compose up -d
```

- Stop project

```console
docker-compose down
```


## Send request & test

```shell script
$ curl http://localhost:8081/api/set?key=k1&value=v1
$ curl http://localhost:8081/api/get\?key\=k1 
v1
```

## Contribute

## Reference
- https://github.com/redisson/redisson/tree/master/redisson-spring-boot-starter