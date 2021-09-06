package io.codebyexample.springbootredisson.core.service;


/**
 * @author huypva
 */
public interface ExampleService {

  void setRedis(String key, String value);

  String getRedis(String key);
}
