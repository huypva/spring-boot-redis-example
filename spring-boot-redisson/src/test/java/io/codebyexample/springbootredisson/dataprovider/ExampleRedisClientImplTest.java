package io.codebyexample.springbootredisson.dataprovider;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.doAnswer;

import io.codebyexample.springbootredisson.core.service.ExampleServiceImpl;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.redisson.api.ObjectListener;
import org.redisson.api.RBucket;
import org.redisson.api.RFuture;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author huypva
 */
@ExtendWith(SpringExtension.class)
@Import(ExampleRedisClientImpl.class)
public class ExampleRedisClientImplTest {

  @Autowired
  ExampleRedisClientImpl exampleRedisClient;

  @MockBean
  RedissonClient redissonClient;

  @Test
  void setExampleTest() {

    given(redissonClient.getBucket("k1")).willReturn(newDefaultBucket());

    exampleRedisClient.setExample("k1", "v1");
  }

  @Test
  void getExampleTest() {
    String defaultValue = "v1";
    given(redissonClient.getBucket("k1")).willReturn(newDefaultBucket());

    String value = exampleRedisClient.getExample("k1");
    assertThat(value).isEqualTo(defaultValue);
  }

  public RBucket<Object> newDefaultBucket() {
    return new RBucket<Object>() {

      @Override
      public RFuture<Long> getIdleTimeAsync() {
        return null;
      }

      @Override
      public RFuture<Long> sizeInMemoryAsync() {
        return null;
      }

      @Override
      public RFuture<Void> restoreAsync(byte[] bytes) {
        return null;
      }

      @Override
      public RFuture<Void> restoreAsync(byte[] bytes, long l, TimeUnit timeUnit) {
        return null;
      }

      @Override
      public RFuture<Void> restoreAndReplaceAsync(byte[] bytes) {
        return null;
      }

      @Override
      public RFuture<Void> restoreAndReplaceAsync(byte[] bytes, long l, TimeUnit timeUnit) {
        return null;
      }

      @Override
      public RFuture<byte[]> dumpAsync() {
        return null;
      }

      @Override
      public RFuture<Boolean> touchAsync() {
        return null;
      }

      @Override
      public RFuture<Void> migrateAsync(String s, int i, int i1, long l) {
        return null;
      }

      @Override
      public RFuture<Void> copyAsync(String s, int i, int i1, long l) {
        return null;
      }

      @Override
      public RFuture<Boolean> moveAsync(int i) {
        return null;
      }

      @Override
      public RFuture<Boolean> deleteAsync() {
        return null;
      }

      @Override
      public RFuture<Boolean> unlinkAsync() {
        return null;
      }

      @Override
      public RFuture<Void> renameAsync(String s) {
        return null;
      }

      @Override
      public RFuture<Boolean> renamenxAsync(String s) {
        return null;
      }

      @Override
      public RFuture<Boolean> isExistsAsync() {
        return null;
      }

      @Override
      public RFuture<Integer> addListenerAsync(ObjectListener objectListener) {
        return null;
      }

      @Override
      public RFuture<Void> removeListenerAsync(int i) {
        return null;
      }

      @Override
      public RFuture<Boolean> expireAsync(long l, TimeUnit timeUnit) {
        return null;
      }

      @Override
      public RFuture<Boolean> expireAtAsync(Date date) {
        return null;
      }

      @Override
      public RFuture<Boolean> expireAtAsync(long l) {
        return null;
      }

      @Override
      public RFuture<Boolean> expireAsync(Instant instant) {
        return null;
      }

      @Override
      public RFuture<Boolean> clearExpireAsync() {
        return null;
      }

      @Override
      public RFuture<Long> remainTimeToLiveAsync() {
        return null;
      }

      @Override
      public boolean expire(long l, TimeUnit timeUnit) {
        return false;
      }

      @Override
      public boolean expireAt(long l) {
        return false;
      }

      @Override
      public boolean expireAt(Date date) {
        return false;
      }

      @Override
      public boolean expire(Instant instant) {
        return false;
      }

      @Override
      public boolean clearExpire() {
        return false;
      }

      @Override
      public long remainTimeToLive() {
        return 0;
      }

      @Override
      public RFuture<Long> sizeAsync() {
        return null;
      }

      @Override
      public RFuture<Object> getAsync() {
        return null;
      }

      @Override
      public RFuture<Object> getAndDeleteAsync() {
        return null;
      }

      @Override
      public RFuture<Boolean> trySetAsync(Object o) {
        return null;
      }

      @Override
      public RFuture<Boolean> trySetAsync(Object o, long l, TimeUnit timeUnit) {
        return null;
      }

      @Override
      public RFuture<Boolean> setIfExistsAsync(Object o) {
        return null;
      }

      @Override
      public RFuture<Boolean> setIfExistsAsync(Object o, long l, TimeUnit timeUnit) {
        return null;
      }

      @Override
      public RFuture<Boolean> compareAndSetAsync(Object o, Object v1) {
        return null;
      }

      @Override
      public RFuture<Object> getAndSetAsync(Object o) {
        return null;
      }

      @Override
      public RFuture<Object> getAndSetAsync(Object o, long l, TimeUnit timeUnit) {
        return null;
      }

      @Override
      public RFuture<Void> setAsync(Object o) {
        return null;
      }

      @Override
      public RFuture<Void> setAsync(Object o, long l, TimeUnit timeUnit) {
        return null;
      }

      @Override
      public RFuture<Void> setAndKeepTTLAsync(Object o) {
        return null;
      }

      @Override
      public long size() {
        return 0;
      }

      @Override
      public Object get() {
        return "v1";
      }

      @Override
      public Object getAndDelete() {
        return null;
      }

      @Override
      public boolean trySet(Object o) {
        return false;
      }

      @Override
      public boolean trySet(Object o, long l, TimeUnit timeUnit) {
        return false;
      }

      @Override
      public boolean setIfExists(Object o) {
        return false;
      }

      @Override
      public boolean setIfExists(Object o, long l, TimeUnit timeUnit) {
        return false;
      }

      @Override
      public boolean compareAndSet(Object o, Object v1) {
        return false;
      }

      @Override
      public Object getAndSet(Object o) {
        return null;
      }

      @Override
      public Object getAndSet(Object o, long l, TimeUnit timeUnit) {
        return null;
      }

      @Override
      public void set(Object o) {

      }

      @Override
      public void set(Object o, long l, TimeUnit timeUnit) {

      }

      @Override
      public void setAndKeepTTL(Object o) {

      }

      @Override
      public Long getIdleTime() {
        return null;
      }

      @Override
      public long sizeInMemory() {
        return 0;
      }

      @Override
      public void restore(byte[] bytes) {

      }

      @Override
      public void restore(byte[] bytes, long l, TimeUnit timeUnit) {

      }

      @Override
      public void restoreAndReplace(byte[] bytes) {

      }

      @Override
      public void restoreAndReplace(byte[] bytes, long l, TimeUnit timeUnit) {

      }

      @Override
      public byte[] dump() {
        return new byte[0];
      }

      @Override
      public boolean touch() {
        return false;
      }

      @Override
      public void migrate(String s, int i, int i1, long l) {

      }

      @Override
      public void copy(String s, int i, int i1, long l) {

      }

      @Override
      public boolean move(int i) {
        return false;
      }

      @Override
      public String getName() {
        return null;
      }

      @Override
      public boolean delete() {
        return false;
      }

      @Override
      public boolean unlink() {
        return false;
      }

      @Override
      public void rename(String s) {

      }

      @Override
      public boolean renamenx(String s) {
        return false;
      }

      @Override
      public boolean isExists() {
        return false;
      }

      @Override
      public Codec getCodec() {
        return null;
      }

      @Override
      public int addListener(ObjectListener objectListener) {
        return 0;
      }

      @Override
      public void removeListener(int i) {

      }
    };
  }
}