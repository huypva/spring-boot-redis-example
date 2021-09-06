package io.codebyexample.springbootredisson.dataprovider;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.doAnswer;

import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * @author huypva
 */
public class ExampleRedisClientImplTest {

  @Autowired
  ExampleRedisClientImpl exampleRedisClient;

  @MockBean
  RedissonClient redissonClient;

  @Test
  void setExampleTest() {
    doAnswer(invocation -> {
      Object arg0 = invocation.getArgument(0);
      Object arg1 = invocation.getArgument(1);

      assertEquals("k1", arg0);
      assertEquals("v1", arg1);
      return null;
    }).when(exampleRedisClient).setExample("k1", "v1");
  }

  @Test
  void getExampleTest() {
    String defaultValue = "v1";
    given(redissonClient.getBucket("k1").get()).willReturn(defaultValue);

    String value = exampleRedisClient.getExample("k1");
    assertThat(value).isEqualTo(defaultValue);
  }
}