package io.codebyexample.springbootredisson.configuration;

import io.codebyexample.springbootredisson.SpringBootRedissonApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

/**
 * @author huypva
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRedissonApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public abstract class AbstractIntegrationTest {

  static GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:3-alpine"))
      .withExposedPorts(6379);

  @DynamicPropertySource
  static void redisProperties(DynamicPropertyRegistry registry) {
    redis.start();
    registry.add("spring.redis.host", redis::getContainerIpAddress);
    registry.add("spring.redis.port", redis::getFirstMappedPort);
  }
}
