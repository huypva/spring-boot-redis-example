package io.codebyexample.springbootredisson;

import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;

@SpringBootTest
public class SpringBootRedissonApplicationTests {

	@Autowired
	RedissonClient redissonClient;

	@Test
	void contextLoads() {
	}

	@Test
	void set() {
		RBucket<Long> rBucket = redissonClient.getBucket("KEY-1");
		rBucket.set(1L);
	}

	@Test
	void get() {
		RBucket<Long> rBucket = redissonClient.getBucket("KEY-1");
		rBucket.set(1L);


		long value = rBucket.get().longValue();
		System.out.println(value);
	}
}
