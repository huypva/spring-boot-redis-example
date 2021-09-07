package io.codebyexample.springbootredisson.dataprovider;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Component
public class ExampleRedisClientImpl implements ExampleRedisClient {

  @Autowired
  RedissonClient redissonClient;

  @Override
  public void setExample(String key, String value) {
    RBucket<String> bucket = redissonClient.getBucket(key);
    bucket.set(value);
  }

  @Override
  public String getExample(String key) {
    RBucket<String> bucket = redissonClient.getBucket(key);
    return bucket.get();
  }
}
