package io.codebyexample.springbootredisson.core.service;

import io.codebyexample.springbootredisson.dataprovider.ExampleRedisClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huypva
 */
@AllArgsConstructor
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    ExampleRedisClient exampleRedisClient;

    @Override
    public void setRedis(String key, String value) {
        exampleRedisClient.setExample(key, value);
    }

    @Override
    public String getRedis(String key) {
        return exampleRedisClient.getExample(key);
    }
}
