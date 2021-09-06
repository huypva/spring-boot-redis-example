package io.codebyexample.springbootredisson.dataprovider;

/**
 * @author huypva
 */
public interface ExampleRedisClient {

  void setExample(String key, String value);

  String getExample(String key);

}
