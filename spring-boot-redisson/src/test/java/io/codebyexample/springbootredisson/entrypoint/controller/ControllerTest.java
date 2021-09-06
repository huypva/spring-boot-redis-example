package io.codebyexample.springbootredisson.entrypoint.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.codebyexample.springbootredisson.core.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

/**
 * @author huypva
 */
@WebMvcTest(Controller.class)
public class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ExampleService exampleService;

  @Test
  void setTest() throws Exception {
    String api = "/api/set?key=k1&value=v1";

    doNothing().when(exampleService).setRedis("k1", "v1");

    ResultActions resultActions = mockMvc.perform(get(api))
        .andDo(print());

    resultActions.andExpect(status().isOk());
  }

  @Test
  void getTest() throws Exception {
    String api = "/api/get?key=k1";
    String defaultValue = "v1";

    given(exampleService.getRedis("k1")).willReturn(defaultValue);

    ResultActions resultActions = mockMvc.perform(get(api))
        .andDo(print());

    resultActions.andExpect(status().isOk())
        .andExpect(content().string(defaultValue));
  }
}