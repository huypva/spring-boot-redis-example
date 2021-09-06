package io.codebyexample.springbootredisson.entrypoint.controller;

import io.codebyexample.springbootredisson.core.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@RequiredArgsConstructor
@RestController
public class Controller {

  private final ExampleService userService;

  @GetMapping("/api/set")
  public void set(@RequestParam(name = "key") String key,
      @RequestParam(name = "value") String value) {
    userService.setRedis(key, value);
  }

  @GetMapping("/api/get")
  public String get(@RequestParam(name = "key") String key) {
    return userService.getRedis(key);
  }
}
