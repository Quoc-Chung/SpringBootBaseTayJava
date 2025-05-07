package com.quocchung.SPRINGBOOT_BASE.service.impl;

import com.quocchung.SPRINGBOOT_BASE.service.BaseRedisService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.stream.Collectors;

@Service
public class BaseRedisServiceImp<K, F, V> implements BaseRedisService<K, F, V> {

  private final RedisTemplate<K, V> redisTemplate;
  private final HashOperations<K, F, V> hashOperations;

  public BaseRedisServiceImp(RedisTemplate<K, V> redisTemplate) {
    this.redisTemplate = redisTemplate;
    this.hashOperations = redisTemplate.opsForHash();
  }

  @Override
  public void set(K key, V value) {
    redisTemplate.opsForValue().set(key, value);
  }

  @Override
  public void setTimeToLive(K key, int ttl) {
    redisTemplate.expire(key, Duration.ofSeconds(ttl));
  }

  @Override
  public V get(K key) {
    return redisTemplate.opsForValue().get(key);
  }

  @Override
  public void hashSet(K key, F field, V value) {
    hashOperations.put(key, field, value);
  }

  @Override
  public boolean hashExists(K key, F field) {
    return Boolean.TRUE.equals(hashOperations.hasKey(key, field));
  }

  @Override
  public Map<F, V> hashGet(K key) {
    return hashOperations.entries(key);
  }

  @Override
  public Map<F, V> getField(K key) {
    return hashOperations.entries(key);
  }

  @Override
  public List<V> hashGetByFieldPrefix(K key, String fieldPrefix) {
    return hashOperations.entries(key).entrySet().stream()
        .filter(entry -> entry.getKey().toString().startsWith(fieldPrefix))
        .map(Map.Entry::getValue)
        .collect(Collectors.toList());
  }

  @Override
  public Set<F> getFieldPrefixes(K key) {
    return hashOperations.keys(key);
  }

  @Override
  public void delete(K key) {
    redisTemplate.delete(key);
  }

  @Override
  public void delete(K key, F field) {
    hashOperations.delete(key, field);
  }

  @Override
  public void delete(K key, List<F> fields) {
    hashOperations.delete(key, fields.toArray());
  }
}
