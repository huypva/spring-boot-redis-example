package io.codebyexample.springbootredisson.core.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doAnswer;

import io.codebyexample.springbootredisson.dataprovider.ExampleRedisClientImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author huypva
 */
@ExtendWith(SpringExtension.class)
@Import(ExampleServiceImpl.class)
public class ExampleServiceImplTest {

  @Autowired
  ExampleService exampleService;

  @MockBean
  ExampleRedisClientImpl exampleRedisClientImpl;

  @Test
  void setRedisTest() {
    doAnswer(invocation -> {
      Object arg0 = invocation.getArgument(0);
      Object arg1 = invocation.getArgument(1);

      assertEquals("k1", arg0);
      assertEquals("v1", arg1);
      return null;
    }).when(exampleRedisClientImpl).setExample("k1", "v1");
  }

  @Test
  void getRedisTest() {
    String defaultValue = "v1";
    given(exampleRedisClientImpl.getExample("k1")).willReturn(defaultValue);

    String value = exampleService.getRedis("k1");
    assertThat(value).isEqualTo(defaultValue);

  }
}